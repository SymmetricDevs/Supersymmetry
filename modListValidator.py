import os
import argparse
from os.path import isfile, isdir

parser = argparse.ArgumentParser()
parser.add_argument("-export", action="store_true")
parser.add_argument("-validate", action="store_true")

args = parser.parse_args()

path = os.path.join(os.getcwd(), "mods")
file_list = []

def getFilesRecursive(directory):
    objects = os.listdir(directory)
    for obj in objects:
        if isfile(os.path.join(directory, obj)):
            file_list.append(obj)
        elif isdir(os.path.join(directory, obj)):
            getFilesRecursive(os.path.join(directory, obj))
    
getFilesRecursive(path)

if args.validate and args.export:
    print("Use export to make a new validation file, validate to check against an existing one")
    quit()

if args.export:
    outfile = open("modValidationFile.dat", 'wt', encoding='utf-8')
    for mod_file in file_list:
        outfile.write(mod_file + '\n')
    outfile.close()
    print("Written list to file")
    quit()

not_found = []
extras = []

if args.validate:

    all_good = True
    
    validation_file = open("modValidationFile.dat", 'rt', encoding='utf-8')
    validation_list = validation_file.readlines()
    
    for file in file_list:
        if file + '\n' not in validation_list:
            extras.append(file)
            
    for file in validation_list:
        if file.strip() not in file_list:
            not_found.append(file)

    if len(not_found) > 0:
        print("Files that were not found:")
        for file in not_found:
            print("#", file)
        all_good = False
        
    if len(extras) > 0:
        print("Files that are not supposed to be in the mods folder:")
        for file in extras:
            print("#", file)
        all_good = False

    if all_good:
        print("All good")
    

