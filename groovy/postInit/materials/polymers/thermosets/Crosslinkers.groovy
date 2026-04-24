import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// HMTA

CSTR.recipeBuilder()
    .fluidInputs(fluid('formaldehyde') * 75)
    .fluidInputs(fluid('ammonia_solution') * 50)
    .fluidOutputs(fluid('hexamethylenetetramine_solution') * 50)
    .duration(50)
    .EUt(VA[ULV])
    .buildAndRegister()

// Dicyanimide

BR.recipeBuilder()
    .inputs(ore('dustCalciumCyanamide') * 4)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .outputs(metaitem('dustCalcite') * 5)
    .outputs(metaitem('dustCyanamide') * 5)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCyanamide') * 10)
    .notConsumable(fluid('sodium_hydroxide_solution') * 1000)
    .outputs(metaitem('dustDicyandiamide') * 10)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// 2-methylimidazole (Debus–Radziszewski imidazole synthesis)

LCR.recipeBuilder()
    .fluidInputs(fluid('gtfo_glyoxal') * 1000)
    .fluidInputs(fluid('ammonia') * 2000)
    .fluidInputs(fluid('gtfo_acetaldehyde') * 1000)
    .outputs(metaitem('dustTwoMethylimidazole') * 12)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustTwoMethylimidazole'))
    .inputs(ore('dustDicyandiamide') * 2)
    .inputs(ore('dustPhthalicAnhydride'))
    .outputs(metaitem('dustEpoxyCuringMixture'))
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

// Amine oligomerization

BR.recipeBuilder()
    .fluidInputs(fluid('one_two_dichloroethane') * 1525)
    .fluidInputs(fluid('ammonia') * 2425)
    .fluidOutputs(fluid('aminated_ethylene_mixture') * 1000)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('aminated_ethylene_mixture') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 3050)
    .fluidOutputs(fluid('neutralized_aminated_ethylene_mixture') * 4050)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('neutralized_aminated_ethylene_mixture') * 4050)
    .outputs(metaitem('dustSalt') * 6)
    .fluidOutputs(fluid('piperazine') * 50)
    .fluidOutputs(fluid('triethylenetetramine') * 100)
    .fluidOutputs(fluid('aminoethylpiperazine') * 50)
    .fluidOutputs(fluid('diethylenetriamine') * 300)
    .fluidOutputs(fluid('ethylenediamine') * 500)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()
