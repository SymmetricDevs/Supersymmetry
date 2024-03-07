import os
import json
x = input() + ".json"
with open("zh_cn.json", "w", encoding = 'utf-8') as zh_cn_json, open(x, "r", encoding = 'utf-8') as input, open("zh_cn.lang", "r", encoding = 'utf-8') as zh_cn:
    dataglobal = json.loads(input.read())
    length = len(dataglobal)
    for line in zh_cn:
        if "=" in line:
            key, lang = line.split("=", 1)
            for i in range(length):
                if key == dataglobal[i]["key"] and dataglobal[i]["translation"] != "":
                    lang = dataglobal[i]["translation"] + "\n"
                    break
            zh_cn_json.write(key + "=" + lang)
        else:
            zh_cn_json.write(line)