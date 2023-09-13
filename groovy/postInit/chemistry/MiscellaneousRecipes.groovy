import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

BCR = recipemap('bubble_column_reactor')
BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')

BCR.recipeBuilder()
		.fluidInputs(fluid('sodium_hydroxide_solution') * 50)
		.fluidInputs(fluid('hydrogen_chloride') * 50)
		.fluidOutputs(fluid('salt_water') * 100)
		.duration(10)
		.EUt(Globals.voltAmps[1])
		.buildAndRegister()
BR.recipeBuilder()
        .inputs(ore('dustQuicklime') * 2)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .fluidOutputs(fluid('calcium_chloride_solution') * 1000)
        .duration(100)
		.EUt(16)
        .buildAndRegister()
BR.recipeBuilder()
        .inputs(ore('dustCalciumHydroxide') * 5)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .fluidOutputs(fluid('diluted_calcium_chloride_solution') * 2000)
        .duration(100)
		.EUt(16)
        .buildAndRegister()
ROASTER.recipeBuilder()
        .inputs(ore('dustCalcium'))
        .fluidInputs(fluid('oxygen') * 1000)
        .fluidOutputs(metaitem('dustQuicklime') * 2)
        .duration(60)
		.EUt(30)
        .buildAndRegister()