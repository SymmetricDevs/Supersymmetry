import static globals.Globals.*

ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
CRYSTALLIZER = recipemap('crystallizer')

// TUNGSTEN BYPRODUCT PROCESSING

ROASTER.recipeBuilder()
        .inputs(ore('dustMolybdenumTrisulfide') * 4)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustImpureMolybdenumTrioxide') * 4)
        .fluidOutputs(fluid('sulfur_dioxide') * 3000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustImpureMolybdenumTrioxide') * 4)
        .fluidInputs(fluid('hydrochloric_acid') * 1000)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidOutputs(fluid('molybdenic_acid_solution') * 1000) // 1x H2MoO4, 1x HCl, 1x H2O
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('molybdenic_acid_solution') * 1000)
        .fluidInputs(fluid('ammonia_solution') * 3000)
        .fluidOutputs(fluid('neutralized_ammonium_molybdate_solution') * 4000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .notConsumable(item('gregtech:wire_coil', 2))
        .fluidInputs(fluid('neutralized_ammonium_molybdate_solution') * 8000)
        .outputs(metaitem('dustAmmoniumDimolybdenate') * 19)
        .fluidOutputs(fluid('ammonia') * 2000)
        .fluidOutputs(fluid('steam') * 7000)
        .fluidOutputs(fluid('ammonium_chloride_solution') * 2000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustAmmoniumDimolybdate') * 19)
        .outputs(metaitem('dustPurifiedMolybdenumTrioxide') * 8)
        .fluidOutputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('ammonia') * 2000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()
        
// REDUCTION TO PURE METAL

REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('hydrogen') * 6000)
        .inputs(ore('dustPurifiedMolybdenumTrioxide') * 4)
        .fluidOutputs(fluid('steam') * 3000)
        .outputs(metaitem('dustMolybdenum'))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()