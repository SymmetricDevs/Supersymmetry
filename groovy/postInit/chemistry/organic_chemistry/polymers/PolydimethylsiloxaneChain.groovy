import static globals.Globals.*


DISTILLATION_TOWER = recipemap('distillation_tower')
FLUIDIZED_BED_REACTOR = recipemap('fluidized_bed_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
CENTRIFUGE = recipemap('centrifuge')
ROASTER = recipemap('roaster')
DUMPER = recipemap('dumping')
// Polydimethylsiloxane

FLUIDIZED_BED_REACTOR.recipeBuilder()
  .fluidInputs(fluid('chloromethane') * 2000)
  .notConsumable(ore('dustCuprousOxide'))
  .inputs(ore('dustSilicon'))
  .fluidOutputs(fluid('organosilicon_mixture') * 2000)
  .duration(160)
  .EUt(Globals.voltAmps[3] * 2)
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

DUMPER.recipeBuilder()
  .fluidInputs('methyltrichlorosilane'* 50)
  .duration(2)
  .buildAndRegister()

DUMPER.recipeBuilder()
  .fluidInputs('methyldichlorosilane'* 50)
  .duration(2)
  .buildAndRegister()

DUMPER.recipeBuilder()
  .fluidInputs('chlorotrimethylsilane'* 50)
  .duration(2)
  .buildAndRegister()
//Methyltrichlorosilane can be used as a water repellent when put on a surface with water
//methyldichlorosilane is useless as far as i know
//Chlorotrimethylsilane has some uses but mostly in reactions that are not relevant to this

CSTR.recipeBuilder()
  .fluidInputs(fluid('dimethyldichlorosilane') * 50)
  .fluidInputs(fluid('water') * 100)
  .fluidOutputs(fluid('impure_polydimethylsiloxane_mixture') * 50)
  .fluidOutputs(fluid('hydrochloric_acid') * 100)
  .duration(2)
  .EUt(Globals.voltAmps[1])
  .buildAndRegister()

CENTRIFUGE.recipeBuilder()
  .fluidInputs(fluid('impure_polydimethylsiloxane_mixture') * 1000)
  .fluidOutputs(fluid('hydrochloric_acid') * 500)
  .fluidOutputs(fluid('raw_polydimethylsiloxane_mixture') * 1000)
  .duration(120)
  .EUt(Globals.voltAmps[1])
  .buildAndRegister()

ROASTER.recipeBuilder()
  .fluidInputs(fluid('raw_polydimethylsiloxane_mixture') * 1000)
  .fluidInputs(fluid('steam') * 2000)
  .fluidOutputs(fluid('hydrochloric_acid') * 500)
  .fluidOutputs(fluid('polydimethylsiloxane') * 1000)
