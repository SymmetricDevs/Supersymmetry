import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

BLENDER.recipeBuilder()
    .inputs(ore('dustOleicAcid') * 3)
    .fluidInputs(fluid('naphthenic_acid') * 3000)
    .fluidInputs(fluid('coconut_acid') * 6000)
    .fluidInputs(fluid('aluminium_sulfate_solution') * 12000)
    .inputs(ore('dustSodiumHydroxide') * 36)
    .outputs(metaitem('dustNapalmGellingAgent') * 12)
    .fluidOutputs(fluid('wastewater') * 24000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('gasoline') * 8000)
    .inputs(metaitem('dustNapalmGellingAgent'))
    .fluidOutputs(fluid('napalm') * 8000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()