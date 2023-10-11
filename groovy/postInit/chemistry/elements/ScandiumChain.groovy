import static globals.Globals.*

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
CENTRIFUGE = recipemap('centrifuge')
CRYSTALLIZER = recipemap('crystallizer')
CSTR = recipemap('continuous_stirred_tank_reactor')
REACTION_FURNACE = recipemap('reaction_furnace')
//source: https://link.springer.com/article/10.1007/s12598-016-0805-5


// Red Mud * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustRedMud')], null)
// Concentrated Red Mud * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustConcentratedRedMud')], null)

CENTRIFUGE.recipeBuilder() //seperation of Zr, Ti
    .fluidInputs(fluid('leached_red_mud_residue') * 1000)
    .fluidInputs(fluid('primene_jmt') * 100) //16-dimethylheptadecan-1-amine
    //someone has to balance the stoik
    //source: https://www.sciencedirect.com/science/article/pii/S1383586613000774
    //is the primene even recoverable?
    .fluidOutputs(fluid('purified_leached_red_mud') * 1000)
    .fluidOutputs(fluid('wastewater') * 1000) //contains Zr, Ti
    .EUt(Globals.voltAmps[2])
    .duration(400)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder() //impurity removal
    .fluidInputs(fluid('purified_leached_red_mud') * 1000)
    .fluidInputs(fluid('uranium_vanadium_extraction_mixture') * 100) //cyanex 572
    .fluidOutputs(fluid('organic_loaded_red_mud_mixture') * 1000)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister()

BR.recipeBuilder() //scrubbing Fe, Ti
    .fluidInputs(fluid('organic_loaded_red_mud_mixture') * 1000)
    .fluidInputs(fluid('sodium_phosphate_solution') * 1000)
    .fluidInputs(fluid('hydrogen_peroxide') * 1000) //source: https://www.sciencedirect.com/science/article/pii/S0304386X17304437
    .fluidOutputs(fluid('scrubbed_organic_loaded_red_mud_mixture') * 1000)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //scrubbing Fe, Ti but with less efficiency
    .fluidInputs(fluid('organic_loaded_red_mud_mixture') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidInputs(fluid('hydrogen_peroxide') * 1000) //source: https://www.sciencedirect.com/science/article/pii/S0304386X17304437
    .fluidOutputs(fluid('scrubbed_organic_loaded_red_mud_mixture') * 1000)
    .fluidOutputs(fluid('acidic_wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //stripping
    .fluidInputs(fluid('scrubbed_organic_loaded_red_mud_mixture') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000) //should be in excess
    .fluidOutputs(fluid('uranium_vanadium_extraction_mixture') * 100) //cyanex 572
    .fluidOutputs(fluid('impure_sodium_scandate_solution') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('impure_sodium_scandate_solution') * 1000)
    .fluidInputs(fluid('water') * 1000)
	.chancedOutput(metaitem('dustImpureScandiumHydroxide') * 6, 1000, 0) //chancedOutput?
    .fluidOutputs(fluid('diluted_sodium_hydroxide_solution') * 2000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //removing Fe, Al, Ti residue from Sc(OH)3
	.inputs(ore('dustImpureScandiumHydroxide') * 12)
    .fluidInputs(fluid('sulfuric_acid') * 3000)
    .fluidOutputs(fluid('impure_scandium_sulfate_solution') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //removing Fe, Al, Ti residue from Sc(OH)3
	.inputs(ore('dustImpureScandiumHydroxide') * 6)
    .fluidInputs(fluid('hydrochloric_acid') * 3000)
    .fluidOutputs(fluid('impure_scandium_chloride_solution') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('impure_scandium_sulfate_solution') * 3000)
    .inputs(ore('dustOxalicAcid') * 6)
    .outputs(metaitem('dustScandiumOxalate') * 18)
    .fluidOutputs(fluid('acidic_wastewater') * 3000) //contains trace amount of Fe, Al, Ti
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('impure_scandium_chloride_solution') * 6000)
    .inputs(ore('dustOxalicAcid') * 6)
    .outputs(metaitem('dustScandiumOxalate') * 18)
    .fluidOutputs(fluid('acidic_wastewater') * 6000) //contains trace amount of Fe, Al, Ti
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustScandiumOxalate') * 18)
    .outputs(metaitem('dustScandiumOxide') * 5)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustScandiumOxide') * 5)
    .fluidInputs(fluid('hydrogen_fluoride') * 6000)
    .outputs(metaitem('dustScandiumFluoride') * 8)
    .fluidOutputs(fluid('steam') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustMagnesium') * 3)
    .inputs(ore('dustScandiumFluoride') * 8)
    .outputs(metaitem('dustScandium') * 2)
    .outputs(metaitem('dustMagnesiumFluoride') * 9)
    .EUt(Globals.voltAmps[2])
    .duration(400)
    .buildAndRegister()
    
//it should be faster to use calcium
REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustCalcium') * 3)
    .inputs(ore('dustScandiumFluoride') * 8)
    .outputs(metaitem('dustScandium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()