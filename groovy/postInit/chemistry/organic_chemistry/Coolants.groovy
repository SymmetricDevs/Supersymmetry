import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

MIXER.recipeBuilder()
    .inputs(ore('dyeCyan'))
    .inputs(ore('dustTinyBorax'))
    .inputs(ore('dustSodiumHydroxide'))
    .fluidInputs(fluid('ethylene_glycol') * 10000)
    .fluidOutputs(fluid('coolant') * 10000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

BLENDER.recipeBuilder()
    .inputs(ore('dustTinyMercaptobenzothiazole'))
    .fluidInputs(fluid('polydimethylsiloxane') * 100)
    .fluidInputs(fluid('coolant') * 10000)
    .fluidOutputs(fluid('advanced_coolant') * 10000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();