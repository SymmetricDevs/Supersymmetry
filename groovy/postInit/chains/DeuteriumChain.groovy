import static globals.Globals.*


def LCR = recipemap('large_chemical_reactor');
def ELECTROLYZER = recipemap('electrolyzer');
def ELECTROLYTIC_CELL = recipemap('electrolytic_cell');

LCR.recipeBuilder().EUt(480).duration(200)
	.fluidInputs(fluid('hydrogen_sulfide') * 2000)
	.fluidInputs(fluid('sea_water') * 128000)
	.fluidOutputs(fluid('impure_semiheavy_water') * 128000)
	.fluidOutputs(fluid('isotopically_pure_hydrogen_sulfide') * 2000)
	.notConsumable(Globals.circuit(0))
	.buildAndRegister()
	
LCR.recipeBuilder().EUt(480).duration(200)
	.fluidInputs(fluid('impure_semiheavy_water') * 128000)
	.fluidInputs(fluid('isotopically_pure_hydrogen_sulfide') * 2000)
	.fluidOutputs(fluid('impure_semiheavy_hydrogen_sulfide') * 2000)
	.fluidOutputs(fluid('salt_water') * 128000)
	.notConsumable(Globals.circuit(1))
	.buildAndRegister()

LCR.recipeBuilder().EUt(480).duration(200)
	.fluidInputs(fluid('impure_semiheavy_hydrogen_sulfide') * 2000)
	.fluidInputs(fluid('impure_semiheavy_water') * 1000)
	.fluidOutputs(fluid('semiheavy_hydrogen_sulfide') * 2000)
	.fluidOutputs(fluid('steam') * 1000)
	.notConsumable(Globals.circuit(2))
	.buildAndRegister()

LCR.recipeBuilder().EUt(480).duration(200)
	.fluidInputs(fluid('impure_semiheavy_hydrogen_sulfide') * 2000)
	.fluidInputs(fluid('distilled_water') * 1000)
	.fluidOutputs(fluid('impure_semiheavy_water') * 1000)
	.fluidOutputs(fluid('hydrogen_sulfide') * 2000)
	.notConsumable(Globals.circuit(1))
	.buildAndRegister()

LCR.recipeBuilder().EUt(480).duration(200)
	.fluidInputs(fluid('semiheavy_hydrogen_sulfide') * 2000)
	.fluidInputs(fluid('semiheavy_water') * 1000)
	.fluidOutputs(fluid('impure_heavy_hydrogen_sulfide') * 2000)
	.fluidOutputs(fluid('distilled_water') * 1000)
	.notConsumable(Globals.circuit(2))
	.buildAndRegister()

LCR.recipeBuilder().EUt(480).duration(1000)
	.fluidInputs(fluid('semiheavy_hydrogen_sulfide') * 2000)
	.fluidInputs(fluid('distilled_water') * 2000)
	.fluidOutputs(fluid('semiheavy_water') * 2000)
	.fluidOutputs(fluid('hydrogen_sulfide') * 2000)
	.notConsumable(Globals.circuit(1))
	.buildAndRegister()

LCR.recipeBuilder().EUt(480).duration(200)
	.fluidInputs(fluid('impure_heavy_hydrogen_sulfide') * 2000)
	.fluidInputs(fluid('distilled_water') * 1000)
	.fluidOutputs(fluid('heavy_water') * 1000)
	.fluidOutputs(fluid('impure_semiheavy_hydrogen_sulfide') * 2000)
	.notConsumable(Globals.circuit(1))
	.buildAndRegister()

ELECTROLYZER.recipeBuilder()
		.notConsumable(metaitem('stickNickel'))
		.notConsumable(metaitem('stickIron'))
		.fluidInputs(fluid('heavy_water') * 1000)
		.fluidOutputs(fluid('deuterium') * 2000)
		.fluidOutputs(fluid('oxygen') * 1000)
		.EUt(30)
		.duration(1500)
		.buildAndRegister()

ELECTROLYZER.recipeBuilder()
		.notConsumable(metaitem('stickNickel'))
		.notConsumable(metaitem('stickIron'))
		.notConsumable(fluid('sodium_hydroxide_solution') * 50)
		.fluidInputs(fluid('heavy_water') * 1000)
		.fluidOutputs(fluid('deuterium') * 2000)
		.fluidOutputs(fluid('oxygen') * 1000)
		.EUt(30)
        .duration(200)
        .buildAndRegister()
