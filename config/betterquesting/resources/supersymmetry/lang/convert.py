import os
import json
with open("en_us.json", "w", encoding = 'utf-8') as en_us_json, open("en_us.lang", "r", encoding = 'utf-8') as en_us, open("zh_cn.lang", "r", encoding = 'utf-8') as zh_cn:
    dataglobal = []
    for line_en, line_zh in zip(en_us, zh_cn):
        if line_en.strip() == "":
            continue
        data = {}
        if "=" in line_en:
            key, original = line_en.split("=", 1)
            _, translation = line_zh.split("=", 1)
            data["key"], data["original"], data["translation"] = key, original.rstrip("\n"), translation.rstrip("\n")
            dataglobal.append(data)
    en_us_json.write(json.dumps(dataglobal, ensure_ascii=False, sort_keys=True, indent=4, separators=(',', ': ')))
