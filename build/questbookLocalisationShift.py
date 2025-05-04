# Created by The Science Demon for trainvoi
# Next time, don't have such a skill issue, thanks

import json
import os

questbookPath = os.path.normpath(os.path.abspath(f"{__file__}/../../config/betterquesting/DefaultQuests.json"))

def Setup():
	questbook = GetQuestbook()

	ShiftLocalisationKeys(questbook = questbook, location = "questDatabase:9")

	input("Press Enter to exit...")

def GetQuestbook():
	with open(questbookPath, "r") as file:
		return json.load(file)

def ShiftLocalisationKeys(questbook: dict, location: str):
	for quest in dict(questbook[location]):
		questId = questbook[location][quest]["questID:3"]
		print(f"Found quest with ID: {questId}")

		wantedQuestTitel = "susy.quest.db.%s.%s" % (questId, "title")
		wantedQuestDescription = "susy.quest.db.%s.%s" % (questId, "desc")

		actualQuestTitel = questbook[location][quest]["properties:10"]["betterquesting:10"]["name:8"]
		actualQuestDescription = questbook[location][quest]["properties:10"]["betterquesting:10"]["desc:8"]

		isLocalisedCheck = "susy.quest.db"

		if (actualQuestTitel[0:13] == isLocalisedCheck or actualQuestDescription[0:13] == isLocalisedCheck) and (actualQuestTitel != wantedQuestTitel or actualQuestDescription != wantedQuestDescription):
			questbook[location][quest]["properties:10"]["betterquesting:10"]["name:8"] = wantedQuestTitel
			questbook[location][quest]["properties:10"]["betterquesting:10"]["desc:8"] = wantedQuestDescription
			print(f"Quest {questId} - Fixed!")
		else:
			print(f"Quest {questId} - Fine as is")

		print("--------")
	
	with open(questbookPath, "w") as file:
		json.dump(questbook, file, indent = 2)

	print("Done!")

if (__name__ == "__main__"):
	Setup()
