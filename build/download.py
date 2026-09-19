#!/usr/bin/env python3

import urllib.request
import subprocess
import os

basePath = os.path.normpath(os.path.realpath(__file__).replace("download.py", "") + "/server")

# maven.minecraftforge.net not a fan of the python default
userAgent = {"User-Agent": "curl/8.4.0"}

def fetch(url):
    with urllib.request.urlopen(urllib.request.Request(url, headers=userAgent)) as r:
        return r.read()

def download():
    with open(basePath + "/forge-installer.jar", "w+b") as jar:
        forgeVer = "14.23.5.2860"
        mcVer = "1.12.2"
        url = (
            "https://maven.minecraftforge.net/net/minecraftforge/forge/"
            + mcVer
            + "-"
            + forgeVer
            + "/forge-"
            + mcVer
            + "-"
            + forgeVer
            + "-installer.jar"
        )
        jar.write(fetch(url))
    print("Forge installer Downloaded")

    vanilla = basePath + "/minecraft_server.1.12.2.jar"
    if not os.path.isfile(vanilla):
        with open(basePath + "/minecraft_server.1.12.2.jar", "w+b") as jar:
            url = "https://launcher.mojang.com/v1/objects/886945bfb2b978778c3a0288fd7fab09d315b25f/server.jar"
            jar.write(fetch(url))
    print("Vanilla Downloaded")

    subprocess.run(["java", "-jar", "forge-installer.jar",
                   "--installServer"], cwd=basePath)
    print("Forge Installed")

    try:
        os.remove(basePath + "/forge-installer.jar")
    except Exception as e:
        print("Couldn't delete forge-installer.jar: %s" % (e))
    try:
        os.remove(basePath + "/forge-installer.jar.log")
    except Exception as e:
        print("Couldn't delete forge-installer.jar.log: %s" % (e))
