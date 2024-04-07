import globals.Globals

CRYSTALLIZER = recipemap('crystallizer')
BR = recipemap('batch_reactor')

// From lepidolite

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustAlkaliAlumMix'))
    .fluidOutputs(fluid('gtfo_heated_water') * 10000)
    .chancedOutput(metaitem('dustPotassiumAlum') * 12, 9000, 0)
    .chancedOutput(metaitem('dustRubidiumAlum') * 12, 500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(800)
    .buildAndRegister()

// Refining into metal

BR.recipeBuilder()
    .inputs(ore('dustRubidiumAlum') * 12)
    .notConsumable(ore('springCupronickel'))
    .fluidInputs(fluid('sodium_hydroxide_solution') * 4000)
    .outputs(metaitem('dustAluminiumHydroxide') * 7)
    .fluidOutputs(fluid('rubidium_hydroxide_solution') * 4000)
    .EUt(Globals.voltAmps[1])
    .duration(80)
    .buildAndRegister()
    
DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('rubidium_hydroxide_solution') * 4000)
    .outputs(metaitem('dustRubidiumHydroxide') * 3)
    .fluidOutputs(fluid('water') * 4000)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustRubidiumHydroxide') * 3)
    .inputs(ore('dustAnyPurityMagnesium'))
    .outputs(metaitem('dustRubidium'))
    .outputs(metaitem('dustMagnesiumHydroxide') * 5)
    .EUt(Globals.voltAmps[1])
    .duration(80)
    .buildAndRegister()