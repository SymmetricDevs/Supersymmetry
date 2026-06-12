# little script to find missing materials
import subprocess
from pathlib import Path

recipedump_loc = "PATH/TO/recipedump.json" 
if (recipedump_loc == "PATH/TO/recipedump.json"):
    print("\033[31;1myou need to replace recipedump_loc with the path to recipedump.json (from the recipedump command)!!\n")
    raise NotImplementedError

recipedump = open(recipedump_loc).read()

postInit = ["./groovy/prePostInit/", "./groovy/postInit/"]

materials_metaitems_set = set()
sources = dict()

oreprefix = sorted(["ingot", "ingotHot", "gemChipped", "gemFlawed", "gem", "gemFlawless", "gemExquisite", "dustTiny", "dustSmall", "dust", "nugget", "block", "plate", "plateDouble", "plateDense", "gear", "bolt", "stick", "stickLong", "ring", "screw", "round", "foil", "wireFine", "springSmall", "spring", "turbineBlade", "rotor", "lens", "dustImpure", "dustPure", "crushed", "crushedCentrifuged", "crushedPurified", "shard", "clump", "reduced", "crystalline", "dirtyGravel", "cleanGravel", "toolHeadSword", "toolHeadPickaxe", "toolHeadShovel", "toolHeadAxe", "toolHeadHoe", "toolHeadSense", "toolHeadFile", "toolHeadHammer", "toolHeadSaw", "toolHeadBuzzSaw", "toolHeadScrewdriver", "toolHeadDrill", "toolHeadChainsaw", "toolHeadWrench", "pipeTinyFluid", "pipeSmallFluid", "pipeNormalFluid", "pipeLargeFluid", "pipeHugeFluid", "pipeQuadrupleFluid", "pipeNonupleFluid", "pipeTinyItem", "pipeSmallItem", "pipeNormalItem", "pipeLargeItem", "pipeHugeItem", "pipeSmallRestrictive", "pipeNormalRestrictive", "pipeLargeRestrictive", "pipeHugeRestrictive", "wireGtSingle", "wireGtDouble", "wireGtQuadruple", "wireGtOctal", "wireGtHex", "cableGtSingle", "cableGtDouble", "cableGtQuadruple", "cableGtOctal", "cableGtHex", "frameGt", "glass", "ore", "oreGranite", "oreDiorite", "oreAndesite", "oreBlackgranite", "oreRedgranite", "oreMarble", "oreBasalt", "oreSand", "oreRedSand", "oreNetherrack", "oreEndstone", "log", "frame"], key=len, reverse=True) # from config/bogosorter/orePrefix.json

def findCommentedRegions(file):
    ranges = []
    start = 0
    end = 0
    in_multi_comment = False
    in_single_comment = False
    prevch = ''
    for ch in file:
        if (ch == '*' and prevch == '/' and not in_multi_comment):
            in_multi_comment = True
            start -= 1;
        if (ch == '/' and prevch == '*' and in_multi_comment):
            in_multi_comment = False
            ranges.append((start, end))
        if (ch == '/' and prevch == '/' and not in_single_comment and not in_multi_comment):
            in_single_comment = True
            start -= 1;
        if (ch == '\n' and in_single_comment):
            in_single_comment = False
            ranges.append((start, end))

        end += 1
        if not (in_single_comment or in_multi_comment):
            start = end
        prevch = ch
    if (in_multi_comment or in_single_comment):
        ranges.append((start, end))
    return ranges

def checkInRanges(ranges, num):
    for start_end in ranges:
        if (num >= start_end[0] and num <= start_end[1]):
            return True
    return False

def findAllEnclosed(file, start_find, end_char, ranges, filename):
    start = 0
    out = set()
    while True:
        start = contents.find(start_find, start)
        name = ""
        if (start == -1):
            break
        if (checkInRanges(ranges, start)):
            start += 1
            continue
        start += len(start_find)
        while contents[start] != end_char:
            name += contents[start]
            start += 1
        out.add(name)
        if (name not in sources):
            sources[name] = set()
        sources[name].add(filename)
    return out

poss_oredict = set()
for prefix in postInit:
    for file in Path(prefix).rglob('*.groovy'):
        contents = open(file, 'r').read()
        ranges = findCommentedRegions(contents)
        filename = str(file)
        materials_metaitems_set = materials_metaitems_set.union(findAllEnclosed(contents, "fluid(\'", "\'", ranges, filename))
        materials_metaitems_set = materials_metaitems_set.union(findAllEnclosed(contents, "fluid(\"", "\"", ranges, filename))
        poss_oredict = poss_oredict.union(findAllEnclosed(contents, "ore(\'", "\'", ranges, filename))
        poss_oredict = poss_oredict.union(findAllEnclosed(contents, "ore(\"", "\"", ranges, filename))
        poss_oredict = poss_oredict.union(findAllEnclosed(contents, "metaitem(\'", "\'", ranges, filename))
        poss_oredict = poss_oredict.union(findAllEnclosed(contents, "metaitem(\"", "\"", ranges, filename))

removed_prefix_oredict = set()
for name in poss_oredict:
    if (":" in name or name[-1] == '_'):
        continue
    foundprefix = False
    for poss_prefix in oreprefix:
        if (name[0:len(poss_prefix)] == poss_prefix and name[min(len(poss_prefix), len(name) - 1)] != '.'):
            removed_prefix_oredict.add(name[len(poss_prefix):])
            for file_source in sources[name]:
                if (name[len(poss_prefix):] not in sources):
                    sources[name[len(poss_prefix):]] = set()
                sources[name[len(poss_prefix):]].add(file_source)
            foundprefix = True
            break

    if (not foundprefix):
        removed_prefix_oredict.add(name)

materials_metaitems_set = materials_metaitems_set.union(removed_prefix_oredict)

for material in sorted(list(materials_metaitems_set)):
    if ('.' in material):
        continue # just ignore metaitems for now
    if (material == ''):
        continue # empty string happens for some reason and this is shrimpler
    if (material[-1] not in "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"):
        continue # filter out variable-configured names; i.e suffixes and etc
    if (recipedump.find(material) != -1):
        continue
    result = subprocess.run(["grep", "-r", material, "./groovy/material"], stdout=subprocess.PIPE)
    if (result.stdout):
        continue # last resort search for it in groovy (for pre-release changes)
    print(f"{material} missing; from files {str(sources[material])[1:-1]}")
