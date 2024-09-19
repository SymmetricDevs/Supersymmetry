#!/usr/bin/env python3

# Created by WaitingIdly for Divine Journey 2, licensed as GPLv3
#
# Inspired by Nomifactory's quest_i18n TypeScript code, licensed as LGPLv3
# https://github.com/Nomifactory/Nomifactory/blob/dev/buildtools/tasks/shared/transforms/quest_i18n.ts
#
# Used here by Supersymmetry, not the original creator (slightly modified)
# Source: https://github.com/Divine-Journey-2/Divine-Journey-2/blob/main/buildtools/questbook.py


"""filter the questbook file

accepts a lang param to set what language the output language file is, defaults to en_us
removes useless betterquesting props, since they are automatically assumed on loading the questbook file
this reduces file size by roughly 50% (eg DJ2 4.2mb -> 2.2mb)
"""

import argparse
import json
import os

def parse_args():
    parser = argparse.ArgumentParser(prog="build", description=__doc__)
    parser.add_argument("--prefix",
                        type=str,
                        default="susy",
                        help="prefix applied to questbook entries, typically the modpack id, defaults to susy")
    parser.add_argument("--lang",
                        type=str,
                        default="en_us",
                        help="what language the output language file is, defaults to en_us")
    return parser.parse_args()

# Props that BQ automatically assumes by default, thus only increasing the size of the DefaultQuests json.
uselessProps = {
    # betterquesting
    "issilent:1": 0,
    "snd_complete:8": "minecraft:entity.player.levelup",
    "lockedprogress:1": 0,
    "visibility:8": "NORMAL",
    "tasklogic:8": "AND",
    "repeattime:3": -1,
    "simultaneous:1": 0,
    "globalshare:1": 0,
    "questlogic:8": "AND",
    "snd_update:8": "minecraft:entity.player.levelup",
    "autoclaim:1": 0,
    "repeat_relative:1": 1,
    "ismain:1": 0,

    # task: retrival
    "partialMatch:1": 0,
    "autoConsume:1": 0,
    "groupDetect:1": 0,
    "ignoreNBT:1": 0,
    "index:3": 0,
    "consume:1": 0,

    # task: location
    "visible:1": 0,
    "invert:1": 0,
    "index:3": 0,
    "structure:8": "",
    "hideInfo:1": 0,
    "posX:3": 0,
    "posY:3": 0,
    "posZ:3": 0,
    "biome:8": "",
    "taxiCabDist:1": 0,

    # item
    "OreDict:8": "",
    "Damage:2": 0,
    "Count:3": 0,
    "ForgeCaps:10": {}, # deletes anything with the given key

    # questline
    "bg_image:8": "",
    "bg_size:3": 256,

    # delete edit mode if its true
    #"editmode:1": 1, # Actually don't because edit mode is enabled by default
}

basePath = os.path.normpath(os.path.abspath(__file__ + "/../../"))
defaultQuests = basePath + "/config/betterquesting/DefaultQuests"
lang = basePath + "/config/betterquesting/resources/supersymmetry/lang"

def convertToLang(line: str) -> str:
    """replaces any \\n or other json escape sequences with the correct escape character, %"""
    return line.replace("%", "%%").replace("\n", "%n")

def nest(location: dict) -> dict:
    """navigates through a dict to delete anything undesired"""

    for entry in dict(location):
        if (uselessProps.get(entry) == {} or uselessProps.get(entry) == location[entry]):
            del location[entry]
        elif (isinstance(location[entry], dict)):
            location[entry] = nest(location[entry])

    return location


def i18n(output: dict, id: int, entry: dict, place: str, prefix: str):
    """converts questbook title/desc into lang file"""

    start = "%s.quest" % prefix

    alreadyKnownKeys = []
    
    key = "%s.%s.%s" % (start, place, id)
    title = key + ".title"
    desc = key + ".desc"

    if (entry["properties:10"]["betterquesting:10"]["name:8"].startswith(start)):
        alreadyKnownKeys.append(title)
    else:
        output[title] = convertToLang(entry["properties:10"]["betterquesting:10"]["name:8"])
        entry["properties:10"]["betterquesting:10"]["name:8"] = title.rstrip()
        
    if (entry["properties:10"]["betterquesting:10"]["desc:8"].startswith(start)):
        alreadyKnownKeys.append(desc)
    else:
        output[desc] = convertToLang(entry["properties:10"]["betterquesting:10"]["desc:8"])
        entry["properties:10"]["betterquesting:10"]["desc:8"] = desc.rstrip()

    return len(alreadyKnownKeys)


def delIconCount(entry: dict):
    """delete count property for icons"""
    try:
        del entry["properties:10"]["betterquesting:10"]["icon:10"]["Count:3"]
    except:
        pass
    try:
        del entry["properties:10"]["betterquesting:10"]["icon:10"]["Count:3"]
    except:
        pass


def key(entry):
    """put database after questline, sort by int, and then desc after title"""
    """print(entry[14:(-5 if "desc" in entry else -6)])"""
    return ("db" in entry, int(entry[14:(-5 if "desc" in entry else -6)]), "desc" in entry)


def build(args):
    os.makedirs(lang, exist_ok=True)
    langFile = lang + "/" + args.lang + ".lang"
    questKeys = {}
    
    try:
        with open(langFile, "r", errors="ignore") as file:
            for line in file.readlines():
                questKeys[line.split("=", 1)[0]] = line.split("=", 1)[1].rstrip()
    except FileNotFoundError:
        print("lang file %s was not found" % (langFile))

    # Read the quest files
    knowKeys = 0
    for root, dirs, files in os.walk(defaultQuests):
        for filename in files:
            with open(os.path.join(root, filename), "r") as file:
                currentquest = json.load(file)
                
            if filename == "QuestSettings.json": 
                currentquest["betterquesting:10"]["editmode:1"] = 0
            else:
            
                entryid = int(filename.rstrip('.json'))
                nest(currentquest)

                delIconCount(currentquest)
                
                if root.endswith("QuestLines"): 
                    knowKeys += i18n(output=questKeys, id=entryid, entry=currentquest, place="ql", prefix=args.prefix)
                else:
                    knowKeys += i18n(output=questKeys, id=entryid, entry=currentquest, place="db", prefix=args.prefix)

            with open(os.path.join(root, filename), "w") as file:
                json.dump(currentquest, file, indent=2)
    
    
    if (knowKeys > 0):
        print("Already knew %s keys " % knowKeys)
    
    with open(langFile, "w") as file:
        for i in sorted(questKeys, key=key):
            file.write(i + "=" + questKeys[i] + "\n")


if (__name__ == "__main__"):
    build(parse_args())
