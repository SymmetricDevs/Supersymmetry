import static globals.Globals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

BATCH_REACTOR = recipemap('batch_reactor')
ELECTROLYZER = recipemap('electrolyzer')

BATCH_REACTOR.recipeBuilder()
        .fluidInputs(fluid('bromine') * 200)
        .fluidInputs(fluid('acetone') * 200)
        .inputs(ore('dustSodiumHydroxide') * 1)
        .fluidOutputs(fluid('sodium_acetate_solution') * 300)
        .fluidOutputs(fluid('bromoform') * 200)
        .duration(40)
        .EUt(120)
        .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
        .fluidInputs(fluid('bromoform') * 400)
        .inputs(ore('dustDicobaltOctacarbonyl') * 3)
        .outputs(metaitem('dustMethylidynetricobaltnonacarbonyl') * 1)
        .fluidOutputs(fluid('cobalt_ii_bromide_solution') * 600)
        .fluidOutputs(fluid('carbon_dioxide') * 3600)
        .duration(160)
        .EUt(480)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .fluidInputs(fluid('cobalt_ii_bromide_solution') * 600)
        .fluidOutputs(fluid('bromine') * 400)
        .outputs(metaitem('dustCobalt'))
        .duration(160)
        .EUt(120)
        .buildAndRegister()
