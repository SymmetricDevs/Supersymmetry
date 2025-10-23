import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Polydimethylsiloxane

FLUIDIZED_BR.recipeBuilder()
    .fluidInputs(fluid('chloromethane') * 2000)
    .notConsumable(ore('dustCopperIOxide'))
    .inputs(ore('dustSilicon'))
    .fluidOutputs(fluid('organosilicon_mixture') * 2000)
    .duration(160)
    .EUt(VA[LV] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('organosilicon_mixture') * 1000)
    .fluidOutputs(fluid('dimethyldichlorosilane') * 800)
    .fluidOutputs(fluid('methyltrichlorosilane') * 100)
    .fluidOutputs(fluid('methyldichlorosilane') * 50)
    .fluidOutputs(fluid('chlorotrimethylsilane') * 50)
    .duration(400)
    .EUt(VA[LV] * 2)
    .buildAndRegister()

//Methyltrichlorosilane can be used as a water repellent when put on a surface with water
//Chlorotrimethylsilane has some uses but mostly in reactions that are not relevant to this

// PDMS & Silicone Rubber

CSTR.recipeBuilder()
    .fluidInputs(fluid('dimethyldichlorosilane') * 50)
    .fluidInputs(fluid('water') * 125)
    .fluidOutputs(fluid('impure_polydimethylsiloxane_mixture') * 75)
    .fluidOutputs(fluid('hydrochloric_acid') * 50)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('impure_polydimethylsiloxane_mixture') * 1500)
    .fluidOutputs(fluid('hydrochloric_acid') * 500)
    .fluidOutputs(fluid('raw_polydimethylsiloxane_mixture') * 1000)
    .duration(200)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('raw_polydimethylsiloxane_mixture') * 1000)
    .fluidInputs(fluid('water') * 500)
    .fluidOutputs(fluid('hydrochloric_acid') * 500)
    .fluidOutputs(fluid('polydimethylsiloxane') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('polydimethylsiloxane') * 1000)
    .fluidInputs(fluid('di_tert_butyl_peroxide') * 50)
    .inputs(ore('dustSiliconDioxide'))
    .fluidOutputs(fluid('silicone_rubber') * 144)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('polydimethylsiloxane') * 1000)
    .fluidInputs(fluid('di_tert_butyl_peroxide') * 50)
    .inputs(ore('dustCarbon'))
    .fluidOutputs(fluid('silicone_rubber') * 144)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

// Liquid Polydimethylsiloxane * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustPolydimethylsiloxane')], null)
