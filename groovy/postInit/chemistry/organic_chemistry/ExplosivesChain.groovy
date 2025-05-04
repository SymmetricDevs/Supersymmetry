import globals.Globals

//TODO: ADD MORE EXPLOSIVES (AND THEIR CHAINS)

def WEAPONS_FACTORY = recipemap('weapons_factory');

WEAPONS_FACTORY.recipeBuilder()
		.inputs(item('minecraft:paper'))
		.inputs(item('minecraft:string'))
        .fluidInputs(fluid('glyceryl_trinitrate') * 100)
        .outputs(metaitem('dynamite') * 4)
		.EUt(30)
		.duration(60)
		.buildAndRegister()