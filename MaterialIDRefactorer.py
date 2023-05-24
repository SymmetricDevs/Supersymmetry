import regex as re      # Has to be regex because pythons re lookbehinds need to be fixed length lm
import sys

# incredibly non robust and cursed do not use
# wrote this up in 5 minutes dont expect it to work well

path = sys.argv[1]  
        
with open(path, 'r') as f:        
    material_strs = f.readlines()

def replace_material_ids(strings):
    pattern_builder = r"(?<=Material.Builder\()(\d+)(?=,)"
    pattern_generate = r"(?<=\bgenerate\w+\(\w+,\s*)\b(\d+)\b"
    pattern_id_range = r"(?<=\bIDs\s+)\d+"
    replaced_strings = []
    currentId = int(sys.argv[2])
    
    for string in strings:
        replaced_string = string
        
        if "//" in string:
            found = re.search(pattern_id_range, string)
            if found != None:
                currentId = int(found.group())

        
        if "Material.Builder" in string:
            found = re.search(pattern_builder, string)
            if found != None:
                replaced_string = re.sub(pattern_builder ,str(currentId), string)
                currentId +=1
        if "generate" in string:
            found = re.search(pattern_generate, string)
            if found != None:
                replaced_string = re.sub(pattern_generate, str(currentId), string)
                currentId +=1
        
        replaced_strings.append(replaced_string)

    return replaced_strings

replaced_strings = replace_material_ids(material_strs)

with open(path, "w") as f:    
    for string in replaced_strings:
        f.write(string)