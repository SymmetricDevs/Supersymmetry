import globals.Globals

MACERATOR = recipemap('macerator');
MIXER = recipemap('mixer');
EVAPORATION_POOL = recipemap('evaporation_pool');
CSTR = recipemap('continuous_stirred_tank_reactor');
BR = recipemap('batch_reactor');

MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block:1'))
    .outputs(metaitem('dustCaliche') * 4)
    .duration(80)
    .EUt(7)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(metaitem('dustCaliche') * 4)
    .fluidInputs(fluid('distilled_water') * 500)
    .outputs(metaitem('dustLimestoneTailings') * 2)
    .fluidOutputs(fluid('caliche_leach') * 500)
    .duration(80)
    .EUt(7)
    .buildAndRegister()

EVAPORATION_POOL.recipeBuilder()
    .fluidInputs(fluid('caliche_leach') * 1000)
    .chancedOutput(metaitem('dustSalt'), 8000, 0)
    .chancedOutput(metaitem('dustSodiumNitrate'), 8000, 0)
    .fluidOutputs(fluid('iodate_concentrate') * 10)
    .duration(1000)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('iodate_concentrate') * 50)
    .fluidInputs(fluid('sodium_bisulfite_solution') * 150)
    .fluidOutputs(fluid('iodide_concentrate') * 275)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('iodate_concentrate') * 500)
    .fluidInputs(fluid('iodide_concentrate') * 13750)
    .outputs(metaitem('dustIodine') * 3)
    .fluidOutputs(fluid('acidic_wastewater') * 15750)
    .duration(100)
    .EUt(120)
    .buildAndRegister()