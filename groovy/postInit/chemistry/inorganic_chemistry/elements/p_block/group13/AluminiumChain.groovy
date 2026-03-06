import static prePostInit.Recipemaps.*
import globals.Carbons
import static gregtech.api.GTValues.*

// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('dustRuby')], null)
//Remove ERF recipe with Aluminium Dust:
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustAluminium'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('nitrogen') * 1000])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustAluminium'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
//ERF recipe with Al dust re-enabled:
ERF.recipeBuilder()
    .inputs(ore('dustAluminium'))
    .outputs(metaitem('ingotAluminium'))
    .duration(240)
    .blastFurnaceTemp(933)
    .EUt(VA[MV])
    .buildAndRegister()

// remove auto generated furnace recipe, split into separate normal/pure recipes.
furnace.removeByInput(metaitem('dustHighPurityAluminium'))
ERF.recipeBuilder()
    .inputs(ore('dustHighPurityAluminium'))
    .outputs(metaitem('ingotHighPurityAluminium'))
    .duration(240)
    .blastFurnaceTemp(933)
    .EUt(VA[MV])
    .buildAndRegister()

// Ruby Slurry * 3000
mods.gregtech.mixer.removeByInput(1920, [metaitem('crushedRuby') * 2], [fluid('aqua_regia') * 3000])
mods.gregtech.blender.removeByInput(1920, [metaitem('crushedRuby') * 2], [fluid('aqua_regia') * 3000])
// Sapphire Slurry * 3000
mods.gregtech.mixer.removeByInput(1920, [metaitem('crushedSapphire') * 2], [fluid('aqua_regia') * 3000])
mods.gregtech.blender.removeByInput(1920, [metaitem('crushedSapphire') * 2], [fluid('aqua_regia') * 3000])
// Green Sapphire Slurry * 3000
mods.gregtech.mixer.removeByInput(1920, [metaitem('crushedGreenSapphire') * 2], [fluid('aqua_regia') * 3000])
mods.gregtech.blender.removeByInput(1920, [metaitem('crushedGreenSapphire') * 2], [fluid('aqua_regia') * 3000])

// Bauxite -> Red Mud

ROASTER.recipeBuilder()
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .inputs(ore('dustBauxite') * 5)
    .fluidOutputs(fluid('impure_sodium_aluminate_solution') * 3000)
    .info('recipe.bayer_process')
    .duration(200)
    .EUt(16)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('impure_sodium_aluminate_solution') * 3000)
    .fluidOutputs(fluid('sodium_aluminate_solution') * 3000)
    .fluidOutputs(fluid('red_mud') * 500)
    .info('recipe.sodium_aluminate_solution')
    .duration(200)
    .EUt(16)
    .buildAndRegister()

// Carbon dioxide bubbling

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('sodium_aluminate_solution') * 3000)
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .fluidOutputs(fluid('impure_soda_ash_solution') * 1000)
    .outputs(metaitem('dustAluminiumHydroxide') * 14)
    .info('recipe.aluminium_hydroxide.early')
    .duration(300)
    .EUt(20)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('sodium_aluminate_solution') * 1500)
    .fluidInputs(fluid('water') * 1500)
    .notConsumable(ore('dustAluminiumHydroxide'))
    .fluidOutputs(fluid('impure_sodium_hydroxide_solution') * 1000) //TO GALLIUM PROCESSING
    .outputs(metaitem('dustAluminiumHydroxide') * 7)
    .info('recipe.aluminium_hydroxide.late')
    .duration(300)
    .EUt(16)
    .buildAndRegister()

// Alumina from Al(OH)3

ERF.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustAluminiumHydroxide') * 14)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .outputs(metaitem('dustAlumina') * 5)
    .duration(100)
    .blastFurnaceTemp(1500)
    .EUt(40)
    .buildAndRegister()

// Electrolysis

Carbons.dusts().grep(Carbons.HighPurityCombustible).each { carbon ->
    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('cryolite') * 2880)
        .inputs(ore('dustAlumina') * 10)
        .notConsumable(ore('dustAluminiumTrifluoride') * 4)
        .inputs(ore(carbon.name) * carbon.equivalent(3))
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .fluidOutputs(fluid('aluminium') * 576)
        .info('recipe.hall-heroult')
        .duration(200 * carbon.duration - 100) // makes 100 for carbon / high purity carbon and 200 for coke / green coke
        .EUt(40)
        .buildAndRegister()
}

// Production of cryolite

ROASTER.recipeBuilder()
    .fluidInputs(fluid('hydrofluoric_acid') * 6000)
    .inputs(ore('dustAlumina') * 5)
    .fluidOutputs(fluid('dense_steam') * 9000)
    .outputs(metaitem('dustAluminiumTrifluoride') * 8)
    .duration(300)
    .EUt(16)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('hydrogen_fluoride') * 50)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 50)
    .fluidOutputs(fluid('sodium_fluoride_solution') * 50)
    .duration(5)
    .EUt(16)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_fluoride_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustSodiumFluoride') * 2)
    .duration(200)
    .EUt(VA[ULV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAluminiumTrifluoride') * 4)
    .inputs(ore('dustSodiumFluoride') * 6)
    .outputs(metaitem('dustCryolite') * 10)
    .info('recipe.cryolite.production')
    .duration(180)
    .EUt(16)
    .buildAndRegister()

// Red mud processing

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('red_mud') * 2000)
    .chancedOutput(metaitem('dustIronIiiOxide'), 5000, 0)
    .fluidOutputs(fluid('concentrated_red_mud') * 1000)
    .duration(200)
    .EUt(96)
    .buildAndRegister()

ERF.recipeBuilder()
    .fluidInputs(fluid('concentrated_red_mud') * 2000)
    .outputs(ore('ingotIron').first())
    .outputs(metaitem('red_mud_slag'))
    .blastFurnaceTemp(1600)
    .duration(300)
    .EUt(VA[MV] * 2)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 250)
    .inputs(metaitem('red_mud_slag'))
    .chancedOutput(metaitem('dustRutile'), 3333, 0)
    .outputs(metaitem('leached_red_mud_slag'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 3000)
    .inputs(ore('dustAluminiumHydroxide') * 14)
    .fluidOutputs(fluid('aluminium_sulfate_solution') * 6000)
    .duration(100)
    .EUt(96)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 3000)
    .fluidInputs(fluid('water') * 3000)
    .inputs(ore('dustAlumina') * 5)
    .fluidOutputs(fluid('aluminium_sulfate_solution') * 6000)
    .duration(100)
    .EUt(96)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('aluminium_sulfate_solution') * 6000)
    .outputs(metaitem('dustAluminiumSulfate') * 17)
    .fluidOutputs(fluid('water') * 6000)
    .duration(100)
    .EUt(96)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 3000)
    .inputs(ore('dustAnyPurityAluminium') * 2)
    .outputs(metaitem('dustAluminiumSulfate') * 17)
    .fluidOutputs(fluid('hydrogen') * 6000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

// CENTRIFUGE.recipeBuilder()
// .fluidInputs(fluid('hydrochloric_acid') * 500)
// .inputs(metaitem('leached_red_mud_slag'))
// .fluidOutputs(fluid('acidic_ree_solution') * 500)
// .duration(100)
// .EUt(VA[EV])
// .buildAndRegister()

BR.recipeBuilder()      
    .inputs(ore('dustAluminiumSulfate') * 17)
    .fluidInputs(fluid('sodium_bicarbonate_solution') * 6000)
    .outputs(metaitem('dustAluminiumHydroxide') * 14)
    .fluidOutputs(fluid('diluted_sodium_sulfate_solution') * 6000)
    .fluidOutputs(fluid('carbon_dioxide') * 6000)
    .duration(120)
    .EUt(200)
    .buildAndRegister()

// High purity aluminium (Ullman's - Aluminium Ch. 5)

BR.recipeBuilder()
    .inputs(ore('dustBariumCarbonate') * 5)
    .fluidInputs(fluid('ammonium_fluoride_solution') * 2000)
    .outputs(metaitem('dustBariumFluoride') * 3)
    .fluidOutputs(fluid('ammonium_carbonate_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSodiumFluoride') * 4)
    .inputs(ore('dustAluminiumTrifluoride') * 8)
    .inputs(ore('dustBariumFluoride') * 3)
    .outputs(metaitem('dustHoopesElectrolyte') * 15)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(metaitem('graphite_electrode'))
    .notConsumable(ore('blockGraphite'))
    .notConsumable(fluid('hoopes_electrolyte') * 2160)
    .notConsumable(fluid('copper') * 144)
    .fluidInputs(fluid('aluminium') * 576)
    .fluidOutputs(liquid('high_purity_aluminium') * 576)
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()

// Alums
ROASTER.recipeBuilder() 
    .inputs(ore('dustAmmoniumAlum') * 52)
    .chancedOutput(metaitem('dustAlumina') * 5, 5000, 0)
    .fluidOutputs(fluid('ammonia') * 1000)
    .fluidOutputs(fluid('sulfur_trioxide') * 2000)
    .fluidOutputs(fluid('dense_steam') * 12500)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()
