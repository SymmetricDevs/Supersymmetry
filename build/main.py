# if there is a problem with building, please let htmlcsjs know
import os
import shutil
import subprocess
import requests
import json
import hashlib

modlist = []
basePath = os.path.realpath(__file__)[:-7] + ".."
copyDirs = ["/scripts", "/resources", "/config", "/mods", "/structures"]
serverCopyDirs = ["/scripts", "/config", "/mods", "/structures"]
modURLlist = []

with open(basePath + "/manifest.json") as file:
    manifest = json.load(file)

try:
    os.makedirs(basePath + "/buildOut/client/overrides")
    os.makedirs(basePath + "/buildOut/server")
    os.makedirs(basePath + "/mods")
    print("make directories")
except Exception as e:
    print("Directory exists, skipping")

for mod in manifest["externalDeps"]:
    with open(basePath + "/mods/" + mod["url"].split("/")[-1], "w+b") as jar:
        for i in range(1,100):
            r = requests.get(mod["url"])
            if i == 99:
                raise Exception("Download failed")

            hash = hashlib.sha256(jar.read()).hexdigest()
            if str(hash) == mod["hash"]:
                jar.write(r.content)
                modlist.append(mod["name"])
                print("hash succsessful")
                break
            else:
                print("hash unsuccsessful")
                print("use", str(hash), "this if it is consistant across runs")
                pass

for dir in copyDirs:
    try:
        shutil.copytree(basePath + dir, basePath + "/buildOut/client/overrides" + dir)
    except Exception as e:
        print("Directory exists, skipping")
print("directories copied to buildOut/client")

shutil.copy(basePath + "/manifest.json", basePath + "/buildOut/client/manifest.json")
shutil.make_archive("buildOut/client", "zip", basePath + "/buildOut/client")
print("client zip made")

for mod in manifest["files"]:
    url = "https://cursemeta.dries007.net/" + \
        str(mod["projectID"]) + "/" + str(mod["fileID"]) + ".json"
    r = requests.get(url)
    metadata = json.loads(r.text)
    modlist.append(metadata["FileName"])
    modURLlist.append(metadata["DownloadURL"])
print("modlist compiled")

with open(basePath + "/buildOut/modlist.html", "w") as file:
    data = "<html><body><h1>Supersymmetry modlist</h1><ul>"
    for mod in modlist:
        data += "<li>" + mod + "</li>"
    data += "</ul></body></html>"
    file.write(data)
print("modlist.html done")

shutil.copy(basePath + "/manifest.json", basePath + "/buildOut/server/manifest.json")
shutil.copy(basePath + "/LICENSE", basePath + "/buildOut/server/LICENSE")
shutil.copy(basePath + "/launch.sh", basePath + "/buildOut/server/launch.sh")
shutil.copy(basePath + "/launch.bat", basePath + "/buildOut/server/launch.bat")

for dir in serverCopyDirs:
    try:
        shutil.copytree(basePath + dir, basePath + "/buildOut/server" + dir)
    except Exception as e:
        print("Directory exists, skipping")
print("directories copied to buildOut/server")

for mod in modURLlist:
    with open(basePath + "/buildOut/server/mods/" + mod.split("/")[-1], "w+b") as jar:
        r = requests.get(mod)
        jar.write(r.content)
        print(mod + " Downloaded")
print("Mods Downloaded")

with open(basePath + "/buildOut/server/forge-installer.jar", "w+b") as jar:
    forgeVer = manifest["minecraft"]["modLoaders"][0]["id"].split("-")[-1]
    mcVer = manifest["minecraft"]["version"]
    url = "https://maven.minecraftforge.net/net/minecraftforge/forge/" + \
        mcVer + "-" + forgeVer + "/forge-" + mcVer + "-" + forgeVer + "-installer.jar"
    r = requests.get(url)
    jar.write(r.content)
print("Forge installer Downloaded")

# TODO: make a portable version between versions

with open(basePath + "/buildOut/server/minecraft_server.1.12.2.jar", "w+b") as jar:
    url = "https://launcher.mojang.com/v1/objects/886945bfb2b978778c3a0288fd7fab09d315b25f/server.jar"
    r = requests.get(url)
    jar.write(r.content)
print("Vanilla Downloaded")

subprocess.run(["java", "-jar", "forge-installer.jar", "--installServer"], cwd=basePath + "/buildOut/server/")
print("Forge Installed")

try:
    os.remove(basePath + "/buildout/server/forge-installer.jar")
except Exception as e:
    print("Couldn't delete forge-installer.jar")
try:
    os.remove(basePath + "/buildout/server/forge-installer.jar.log")
except Exception as e:
    print("Couldn't delete forge-installer.jar.log")

shutil.make_archive("buildOut/server", "zip", basePath + "/buildOut/server")
print("server zip made")
print("done")
