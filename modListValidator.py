import os
import argparse
import pickle
from os.path import isfile, isdir

parser = argparse.ArgumentParser()
parser.add_argument("--export", action="store_true")
parser.add_argument("--validate", action="store_true")
parser.add_argument("--print-list", action="store_true")
parser.add_argument("--print-pickle", action="store_true")

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

for file in file_list:
    file = file.strip()

if args.print_list:
    print("Listed", len(file_list), "files from directories")
    for file in file_list:
        print(">: ", file)

if args.print_pickle:
    with open('modValidationFile.pickle', 'rb') as picklefile:
        debuglist = pickle.load(picklefile)
        print("Listed", len(debuglist), "files from pickle")
        for file in debuglist:
            print(">: ", file)
            
if args.validate and args.export:
    print("Use export to make a new validation file, validate to check against an existing one")
    quit()

if args.export:
    with open('modValidationFile.pickle', 'wb') as outfile:
        pickle.dump(file_list, outfile)
    print("Written list to file")
    quit()

not_found = []
extras = []

if args.validate:

    all_good = True
    
    validation_file = open('modValidationFile.pickle', 'rb')
    validation_list = pickle.load(validation_file)
    
    for file in file_list:
        if file not in validation_list:
            extras.append(file)
            
    for file in validation_list:
        if file not in file_list:
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
    

