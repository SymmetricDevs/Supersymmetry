import static globals.Globals.*

//TODO: ADD MORE EXPLOSIVES (AND THEIR CHAINS)

def FORMING_PRESS = recipemap('forming_press');

FORMING_PRESS.recipeBuilder()
		.inputs(item('minecraft:paper'))
		.inputs(item('minecraft:string'))
        .inputs(metaitem('dustTnt'))
        .outputs(metaitem('dynamite') * 4)
		.EUt(30)
		.duration(60)
		.buildAndRegister()