import globals.Globals;

BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
DISTILLERY = recipemap('distillery')
DISTILLATION_TOWER = recipemap('distillation_tower')
ROASTER = recipemap('roaster')
MACERATOR = recipemap('macerator')
SIFTER = recipemap('sifter')
CRYSTALLIZER = recipemap('crystallizer')
REACTION_FURNACE = recipemap('reaction_furnace')
GRAVITY_SEPARATOR = recipemap('gravity_separator')
FF = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')
MIXER = recipemap('mixer')
EBF = recipemap('electric_blast_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
AUTOCLAVE = recipemap('autoclave')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
DRYER = recipemap('dryer')
VACUUM_DT = recipemap('vacuum_distillation')
BCR = recipemap('bubble_column_reactor')
SIEVE_DT = recipemap('sieve_distillation')
PHASE_SEPARATOR = recipemap('phase_separator')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
MIXER_SETTLER = recipemap('mixer_settler')

// Smelting
// The pelletized material is smelted in a shaft furnace to form a 
// copper – nickel matte. Oxygen is then blown into the converter
// to oxidize the iron sulfide selectively to iron oxide, 
// which forms a slag.

EBF.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustFlotatedPentlandite') * 6)
    .outputs(metaitem('dustGreenMatte') * 6)
    .duration(200)
    .blastFurnaceTemp(1700)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// GM: Ni: 33%, Cu: 18%, Co: 6%, Fe: 7%, S: 33%, S: 2%, Se/Te: 1%
EBF.recipeBuilder()
    .inputs(ore('dustGreenMatte') * 6)
    .fluidInputs(fluid('oxygen') * 1400)
    .chancedOutput(metaitem('white_matte') * 6, 8600, 0) // Remaining components
    .chancedOutput(metaitem('dustGraniticMineralSand'), 1400, 0) // 0.07 * 6 Fe in, 0.42 Fe out as 0.14 Fe3O4
    .fluidOutputs(fluid('sulfur_dioxide') * 420) // Assumed Fe present as pyrrhotite (~FeS)
    .duration(200)
    .blastFurnaceTemp(1650)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(metaitem('white_matte'))
    .outputs(metaitem('dustWhiteMatte'))
    .duration(100)
    .EUt(2)
    .buildAndRegister()

// Atmospheric leach
// Method described in https://patentimages.storage.googleapis.com/2b/70/5a/cbb5549831857c/US4571262.pdf

// Oxidizes Ni, Co sulfides to oxide, sulfuric acid converts to sulfate.
BR.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustWhiteMatte') * 2)
    .fluidInputs(fluid('air') * 4220) 
    .fluidInputs(fluid('sulfuric_acid') * 890)
    .chancedOutput(metaitem('dustSulfur'), 1450, 0)
    .fluidOutputs(fluid('oxidized_pgm_leach') * 890)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// NiSO4: 37.50%, Cu: 20.45%, CoSO4: 6.82%, S: 31.82%, PGM: 2.27%, Se/Te: 1.14%, 2 moles solids/aqueous species carried w/ 890L H2O
SIFTER.recipeBuilder()
    .fluidInputs(fluid('oxidized_pgm_leach') * 890)
    .notConsumable(metaitem('item_filter'))
    .fluidOutputs(fluid('impure_nickel_sulfate_solution') * 890) // Carries 0.75 NiSO4, 0.136 CoSO4
    .chancedOutput(metaitem('dustCopperRichPgmSolids') * 2, 5630, 0)
    .duration(50)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Pressure leach

// Cu: 39.49%, S: 53.93%, PGM: 4.39%, Se/Te: 2.19%, Oxidizes Cu, S, Se/Te.
AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustCopperRichPgmSolids'))
    .fluidInputs(fluid('oxygen') * 480)
    .fluidInputs(fluid('sulfuric_acid') * 400)
    .chancedOutput(metaitem('dustSulfur'), 5400, 0)
    .fluidOutputs(fluid('pgm_copper_leach_slurry') * 400)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('pgm_copper_leach_slurry') * 400)
    .notConsumable(metaitem('item_filter'))
    .fluidOutputs(fluid('pgm_free_copper_leach') * 400) // Carries 0.40 CuSO4, 0.02 Se/TeO2 in 400L H2O
    .chancedOutput(metaitem('dustPgmConcentrate'), 440, 0) // PGM Oxides, avg. oxidation state = 4.82
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Selenium extraction

// 2 CuSO4 + 4 SO2 + 6 H2O + (Se,Te)O2 -> Cu2(Se,Te) + 6 H2SO4, 0.022 moles Se/TeO2 present
BCR.recipeBuilder()
    .fluidInputs(fluid('pgm_free_copper_leach') * 400)
    .fluidInputs(fluid('sulfur_dioxide') * 90)
    .fluidOutputs(fluid('sulfidic_copper_leach') * 285)
    .duration(50)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('sulfidic_copper_leach') * 285)
    .notConsumable(metaitem('item_filter'))
    .fluidOutputs(fluid('chalcogen_free_copper_leach') * 285) // Carries 0.35 CuSO4, 0.136 H2SO4 in 285L of H2O
    .chancedOutput(metaitem('dustCopperSelenideTelluride'), 220, 0)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister() 

ROASTER.recipeBuilder()
    .inputs(ore('dustCopperSelenideTelluride'))
    .fluidInputs(fluid('air') * 9530)
    .outputs(metaitem('dustMixedChalcogenDioxide'))
    .outputs(metaitem('dustCopper') * 2)
    .duration(300)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustCopperSelenideTelluride'))
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustMixedChalcogenDioxide'))
    .outputs(metaitem('dustCopper') * 2)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Copper electrowinning

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('chalcogen_free_copper_leach') * 810) // Carries 0.995 CuSO4, 0.386 H2SO4 in 810L of H2O => 1375L H2SO4
    .notConsumable(ore('plateCopper'))
    .notConsumable(ore('plateStainlessSteel'))
    .fluidInputs(fluid('water') * 185)
    .fluidOutputs(fluid('sulfuric_acid') * 1380)
    .fluidOutputs(fluid('oxygen') * 995)
    .chancedOutput(metaitem('dustCopper'), 9950, 0)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()    

// Nickel/cobalt separation
// Input the impure nickel sulfate solution into a crystallizer
// It should make a mixture of cobalt and nickel sulfate dusts and a mother liquor of iron ii sulfate solution
// Then redissolve and extract with cyanex
// Crystallisation step makes a nickel-cobalt solution and leaves behind an iron sulfate mother liquor

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('dense_steam') * 1000)
    .fluidInputs(fluid('impure_nickel_sulfate_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 2000)
    .outputs(metaitem('dustNickelCobaltSulfate') * 6)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustNickelCobaltSulfate') * 6)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('nickel_cobalt_sulfate_solution') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Cyanex-272 extractant makes cobalt sulfate leaving behind nickel sulfate solution

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('cobalt_extraction_mixture') * 1000) 
    .fluidInputs(fluid('nickel_cobalt_sulfate_solution') * 1000)
    .fluidOutputs(fluid('cobalt_extract') * 1000) 
    .fluidOutputs(fluid('nickel_sulfate_solution') * 850)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 300)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .requiredCells(4)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('cobalt_extract') * 1000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 300)
    .fluidOutputs(fluid('cobalt_extraction_mixture') * 1000)
    .fluidOutputs(fluid('cobalt_sulfate_solution') * 150) 
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .requiredCells(2)
    .buildAndRegister()
