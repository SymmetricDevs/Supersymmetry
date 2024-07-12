import globals.Globals

DISTILLATION_TOWER = recipemap('distillation_tower')
FLUIDIZED_BED_REACTOR = recipemap('fluidized_bed_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
CENTRIFUGE = recipemap('centrifuge')
ROASTER = recipemap('roaster')
PHASE_SEPARATOR = recipemap('phase_separator')
CHEMICAL_BATH = recipemap('chemical_bath')
POLYMERIZATION = recipemap('polymerization_tank')

// Polydimethylsiloxane

FLUIDIZED_BED_REACTOR.recipeBuilder()
    .fluidInputs(fluid('chloromethane') * 2000)
    .notConsumable(ore('dustCuprousOxide'))
    .inputs(ore('dustSilicon'))
    .fluidOutputs(fluid('organosilicon_mixture') * 2000)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('organosilicon_mixture') * 1000)
    .fluidOutputs(fluid('dimethyldichlorosilane') * 800)
    .fluidOutputs(fluid('methyltrichlorosilane') * 100)
    .fluidOutputs(fluid('methyldichlorosilane') * 50)
    .fluidOutputs(fluid('chlorotrimethylsilane') * 50)
    .duration(400)
    .EUt(Globals.voltAmps[1] * 2)
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
    .EUt(Globals.voltAmps[1])
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
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('polydimethylsiloxane') * 1000)
    .fluidInputs(fluid('di_tert_butyl_peroxide') * 50)
    .inputs(ore('dustSiliconDioxide'))
    .fluidOutputs(fluid('silicone_rubber') * 144)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('polydimethylsiloxane') * 1000)
    .fluidInputs(fluid('di_tert_butyl_peroxide') * 50)
    .inputs(ore('dustCarbon'))
    .fluidOutputs(fluid('silicone_rubber') * 144)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()
