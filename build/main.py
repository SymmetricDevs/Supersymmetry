#!/usr/bin/env python3

"""build client & server bundles"""

import argparse
import os
import sys
import shutil
import subprocess
from typing import Optional
import cfThirdPartyList
import zipfile
# Used to run questbook.py
import questbook

import download

# used to map a projects classId on curseforge to a folder
class_id_to_dir = {
    6: "mods",
    12: "resourcepacks",
    -1: "other"
}


def parse_args():
    parser = argparse.ArgumentParser(prog="build", description=__doc__)
    parser.add_argument("--sha", action="store_true",
                        help="append git hash to zips")
    parser.add_argument("--name", type=str, help="append name to zips")
    parser.add_argument("--retries", type=int, default=3,
                        help="download attempts before failure")
    parser.add_argument("--clean", action="store_true",
                        help="clean output dirs")
    parser.add_argument("--dev_build", action="store_true",
                        help="makes a folder with all the files symlinked for development. probally only works on linux")
    parser.add_argument("-c", "--client", action="store_true",
                        help="only builds the client pack")
    parser.add_argument("--prefix",
                        type=str,
                        default="susy",
                        help="prefix applied to questbook entries, typically the modpack id, defaults to susy")
    parser.add_argument("--lang",
                        type=str,
                        default="en_us",
                        help="what language the output language file is, defaults to en_us")

    return parser.parse_args()

def packwiz():
    if os.name == 'posix':
        subprocess.run(['chmod', '+x', './packwiz'], check=True)
        return './packwiz'
    if os.name == 'nt':
        return 'packwiz.exe'

basePath = os.path.normpath(os.path.realpath(__file__)[:-7] + "..")
packwizName = packwiz()

def build(args):
    # Run questbook.py first
    questbook.build(args)

    os.makedirs('./buildOut/', exist_ok=True)

    if args.clean:
        shutil.rmtree(basePath + "/buildOut",
                      ignore_errors=True)
        sys.exit(0)

    refresh()
    export_client_pack() # Client

    if args.client:
        return

    export_modlist()
    export_server_pack()

def refresh():
    subprocess.run([packwizName, 'refresh'], check=True)

def export_client_pack():
    print("Client Pack Exporting")
    subprocess.run([packwizName, 'curseforge', 'export', '-o', 'client.zip'], check=True)
    shutil.copy('./client.zip', './buildOut/')
    os.remove('./client.zip')
    print("Client Pack Export Done")

def export_server_pack():
    print("Server Pack Exporting")
    server_pack = "server.zip"

    download.download()

    shutil.copy("LICENSE", "build/server/LICENSE")

    os.chdir("build/server")
    print("downloading the mods, might take some time")
    download_result = subprocess.run(['java', '-jar', 'packwiz-installer-bootstrap.jar', '-s', 'server', '../../pack.toml'], check=True,stdout=subprocess.PIPE,text=True)
    print(f"{download_result.stdout}") # im not sure if there is a way to print its stdout while its working without making a separate thread and needlessly complicating the process

    missing_mods_list:Optional[str] = None

    if str("Failed") in download_result.stdout:
        not_downloaded = cfThirdPartyList.get_broken_from_log(download_result.stdout,basePath+"/mods")
        if not_downloaded:
            print("\nthe following mods failed to download automatically: ")
            missing_mods_list=""
            for mod,(project_id,file_id) in not_downloaded.items():
                print(f" - {mod}")
                
                out = cfThirdPartyList.cf_file_meta(project_id,file_id)
                if out:
                    name, url = out
                    missing_mods_list+=f"{name} : {url}\n"
            print("please download these manually and put them into ./mods folder before running the server itself\n")


    with zipfile.ZipFile(server_pack, 'w') as zipf:
        for folder in ['config', 'groovy', 'libraries', 'mods', 'structures']:
            for root, _, files in os.walk(folder):
                for file in files:
                    file_path = os.path.join(root, file)
                    arcname = os.path.relpath(file_path, start='.')
                    zipf.write(file_path, arcname)

        for file in ['launch.sh', 'forge-1.12.2-14.23.5.2860.jar', 'LICENSE', 'minecraft_server.1.12.2.jar']:
            zipf.write(file, file)
        if missing_mods_list:
            zipf.writestr("missing_mods.txt",missing_mods_list)

    os.chdir("../..")
    shutil.move(f"build/server/{server_pack}", f"buildOut/{server_pack}")
    print("Server Pack Export Done")

def export_modlist():
    print("Modlist Exporting")
    result = subprocess.run([packwizName, 'list'], capture_output=True, encoding='utf-8').stdout.strip().split('\n')
    with open(basePath + "/buildOut/modlist.html", "w") as file:
        data = "<html><body><h1>Modlist</h1><ul>"
        for mod in result:
            data += "<li>" + mod + "</li>"
        data += "</ul></body></html>"
        file.write(data)
    print("Modlist Export Done")


if __name__ == "__main__":
    build(parse_args())
