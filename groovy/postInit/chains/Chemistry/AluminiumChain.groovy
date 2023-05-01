import static globals.Globals.*

ROASTER = recipemap('roaster')
CENTRIFUGE = recipemap('centrifuge')
AUTOCLAVE = recipemap('autoclave')
EBF = recipemap('electric_blast_furnace')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
BCR = recipemap('bubble_column_reactor')
DISTILLERY = recipemap('distillery')
EMSEPARATOR = recipemap('electromagnetic_separator')
ELECTROLYZER = recipemap('electrolyzer')

// Bauxite -> Red Mud

ROASTER.recipeBuilder()
.fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
.inputs(ore('dustBauxite') * 5)
.fluidOutputs(fluid('impure_sodium_aluminate_solution') * 3000)
.duration(200)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('impure_sodium_aluminate_solution') * 3000)
.fluidOutputs(fluid('sodium_aluminate_solution') * 3000)
.fluidOutputs(fluid('red_mud') * 500)
.duration(200)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

// Carbon dioxide bubbling !!! requires susycore 0.0.8 !!!

// CRYSTALLIZER.recipeBuilder()
// .fluidInputs(fluid('sodium_aluminate_solution') * 3000)
// .fluidInputs(fluid('water') * 1000)
// .fluidInputs(fluid('carbon_dioxide') * 1000)
// .fluidOutputs(fluid('impure_sodium_carbonate_solution') * 1000)
// .outputs(ore('dustAluminiumHydroxide').first() * 14)
// .duration(300)
// .EUt(Globals.voltAmps[1])
// .buildAndRegister()

// CRYSTALLIZER.recipeBuilder()
// .fluidInputs(fluid('sodium_aluminate_solution') * 1500)
// .fluidInputs(fluid('water') * 1500)
// .notConsumable(ore('dustAluminiumHydroxide'))
// .fluidOutputs(fluid('impure_sodium_hydroxide_solution') * 1000)
// .outputs(ore('dustAluminiumHydroxide').first() * 7)
// .duration(300)
// .EUt(Globals.voltAmps[1])
// .buildAndRegister()

// TODO: Electrodes for electroplating

ELECTROLYZER.recipeBuilder()
.fluidInputs(fluid('impure_sodium_carbonate_solution') * 1000)
.fluidOutputs(fluid('gtfo_sodium_carbonate_solution') * 1000)
.outputs(ore('dustTinyGallium').first())
.duration(300)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

ELECTROLYZER.recipeBuilder()
.fluidInputs(fluid('impure_sodium_hydroxide_solution') * 1000)
.fluidOutputs(fluid('sodium_hydroxide_solution') * 1000)
.outputs(ore('dustTinyGallium').first())
.duration(300)
.EUt(Globals.voltAmps[1])
.buildAndRegister()


// Alumina from Al(OH)3

EBF.recipeBuilder()
.inputs(ore('dustAluminiumHydroxide') * 14)
.fluidOutputs(fluid('steam') * 3000)
.outputs(ore('dustAlumina').first() * 5)
.duration(100)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// Electrolysis

ELECTROLYTIC_CELL.recipeBuilder()
.fluidInputs(fluid('cryolite') * 144)
.inputs(ore('dustAlumina') * 10)
.inputs(ore('dustAluminiumTrifluoride'))
.inputs(ore('dustCarbon') * 3)
.fluidOutputs(fluid('fluorine') * 1350)
.fluidOutputs(fluid('carbon_dioxide') * 3000)
.outputs(ore('ingotAluminium').first() * 4)
.duration(300)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

// EBF

EBF.recipeBuilder()
.inputs(ore('dustAlumina') * 10)
.inputs(ore('dustCarbon') * 3)
.fluidOutputs(fluid('carbon_dioxide') * 3000)
.outputs(ore('ingotAluminium').first() * 4)
.duration(600)
.EUt(Globals.voltAmps[3] * 2)
.buildAndRegister()

EBF.recipeBuilder()
.inputs(ore('dustAlumina') * 10)
.inputs(ore('dustCoke') * 3)
.fluidOutputs(fluid('carbon_dioxide') * 3000)
.outputs(ore('ingotAluminium').first() * 4)
.duration(600)
.EUt(Globals.voltAmps[3] * 2)
.buildAndRegister()

// Production of cryolite

ROASTER.recipeBuilder()
.fluidInputs(fluid('hydrochloric_acid') * 6000)
.inputs(ore('dustAlumina') * 5)
.fluidOutputs(fluid('steam') * 3000)
.outputs(ore('dustAluminiumTrifluoride').first() * 8)
.duration(300)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

BCR.recipeBuilder()
.fluidInputs(fluid('hydrogen_fluoride') * 50)
.fluidInputs(fluid('sodium_hydroxide_solution') * 50)
.fluidOutputs(fluid('sodium_fluoride_solution') * 50)
.duration(5)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('sodium_fluoride_solution') * 1000)
.fluidOutputs(fluid('water') * 1000)
.outputs(ore('dustSodiumFluoride').first() * 2)
.duration(200)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

ROASTER.recipeBuilder()
.inputs(ore('dustAluminiumTrifluoride') * 4)
.inputs(ore('dustSodiumFluoride') * 6)
.outputs(ore('dustCryolite').first() * 10)
.duration(180)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

// Red mud processing

// EMSEPARATOR.recipeBuilder()
// .fluidInputs(fluid('red_mud') * 2000)
// .outputs(ore('dustSmallIronIiiOxide').first() * 2)
// .fluidOutputs(fluid('concentrated_red_mud') * 1000)
// .duration(200)
// .EUt(Globals.voltAmps[2])
// .buildAndRegister()

EBF.recipeBuilder()
.fluidInputs(fluid('concentrated_red_mud') * 2000)
.outputs(ore('ingotIron').first())
.outputs(metaitem('red_mud_slag'))
.duration(300)
.EUt(Globals.voltAmps[2] * 2)
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('sulfuric_acid') * 250)
.inputs(metaitem('red_mud_slag'))
.outputs(ore('dustTinyRutile').first() * 3)
.outputs(metaitem('leached_red_mud_slag'))
.duration(100)
.EUt(Globals.voltAmps[3])
.buildAndRegister()

// CENTRIFUGE.recipeBuilder()
// .fluidInputs(fluid('hydrochloric_acid') * 500)
// .inputs(metaitem('leached_red_mud_slag'))
// .fluidOutputs(fluid('acidic_ree_solution') * 500)
// .duration(100)
// .EUt(Globals.voltAmps[4])
// .buildAndRegister()

