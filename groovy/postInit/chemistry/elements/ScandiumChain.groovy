import static globals.Globals.*

BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
CENTRIFUGE = recipemap('centrifuge')
CRYSTALLIZER = recipemap('crystallizer')
//source: https://link.springer.com/article/10.1007/s12598-016-0805-5

CENTRIFUGE.recipeBuilder() //seperation of Zr, Ti
    .fluidInputs(fluid('leached_red_mud_residue') * 1000)
    .fluidInputs(fluid('primene_jmt') * 100) //16-dimethylheptadecan-1-amine
    //someone has to balance the stoik
    //source: https://www.sciencedirect.com/science/article/pii/S1383586613000774
    //is the primene even recoverable?
    .fluidOutputs(fluid('purified_leached_red_mud') * 1000) //need to be registered
    .fluidOutputs(fluid('wastewater') * 1000) //contains Zr, Ti
    .EUt(Globals.voltAmps[2])
    .duration(400)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder() //impurity removal
    .fluidInputs(fluid('purified_leached_red_mud') * 1000)
    .fluidInputs(fluid('UraniumVanadiumExtractionMixture') * 100) //cyanex 572
    .fluidOutputs(fluid('organic_loaded_something') * 1000) //need to be registered and renamed
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister()

BR.recipeBuilder() //scrubbing Fe, Ti
    .fluidInputs(fluid('organic_loaded_something') * 1000)
    .fluidInputs(fluid('SodiumPhosphateSolution') * 100)
    .fluidInputs(fluid('hydrogen_peroxide') * 100) //source: https://www.sciencedirect.com/science/article/pii/S0304386X17304437
    .fluidOutputs(fluid('scrubbed_organic_loaded_something') * 1000) //need to be registered and renamed
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //stripping
    .fluidInputs(fluid('scrubbed_organic_loaded_something') * 1000)
    .fluidInputs(fluid('SodiumHydroxideSolution') * 1000) //should be in excess
    .fluidOutputs(fluid('ImpureSodiumScandateSolution') * 1000) //need to be registered and renamed
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('ImpureSodiumScandateSolution') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .outputs(ore('dustImpureScandiumHydroxide') * 6) //chancedOutput?
    .fluidOutputs(fluid('DilutedSodiumHydroxideSolution') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //removing Fe, Al, Ti residue from Sc(OH)3
    .fluidInputs(fluid('ImpureSodiumScandateSolution') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('ImpureScandiumSulfateSolution') * 1000) //need to be registered
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder() //removing Fe, Al, Ti residue from Sc(OH)3
    .fluidInputs(fluid('ImpureSodiumScandateSolution') * 1000)
    .fluidInputs(fluid('hydrochloric_acid') * 1000)
    .fluidOutputs(fluid('ImpureScandiumChlorideSolution') * 1000) //need to be registered
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('ImpureScandiumSulfateSolution') * 1000)
    .inputs(ore('dustOxalicAcid') * 6)
    .outputs(ore('dustScandiumOxalate') * 18) //need to be registered
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('ImpureScandiumChlorideSolution') * 1000)
    .inputs(ore('dustOxalicAcid') * 6)
    .outputs(ore('dustScandiumOxalate') * 18) //need to be registered
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(Globals.voltAmps[2])
    .duration(300)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustScandiumOxalate') * 18)
    .outputs(metaitem('dustScandiumOxide') * 5) //need to be registered
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
    .EUt(Globals.voltAmps[2])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustScandiumOxide') * 5)
    .fluidInputs(fluid('hydrogen_fluoride') * 6000)
    .outputs(metaitem('dustScandiumFluoride') * 8) //need to be registered
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
    .duration(100)
    .buildAndRegister()
    
//it should be faster to use calcium
REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustCalcium') * 3)
    .inputs(ore('dustScandiumFluoride') * 8)
    .outputs(metaitem('dustScandium') * 2)
    .outputs(metaitem('dustFluorite') * 9)
    .EUt(Globals.voltAmps[2])
    .duration(100)
    .buildAndRegister()