import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Tetrafluoroethylene

BCR.recipeBuilder()
    .fluidInputs(fluid('chloroform') * 50)
    .fluidInputs(fluid('hydrogen_fluoride') * 100)
    .fluidOutputs(fluid('acidic_chlorodifluoromethane') * 150)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

PYROLYSE_OVEN.recipeBuilder()
    .fluidInputs(fluid('acidic_chlorodifluoromethane') * 6000)
    .fluidOutputs(fluid('acidic_tetrafluoroethylene') * 5000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('acidic_tetrafluoroethylene') * 125)
    .fluidInputs(fluid('water') * 150)
    .fluidOutputs(fluid('tetrafluoroethylene') * 25)
    .fluidOutputs(fluid('hydrochloric_acid') * 150)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

// Fluorotelomers

    // Pentafluoroiodoethane building block

    ROASTER.recipeBuilder()
        .inputs(ore('dustAnyPurityIodine'))
        .fluidInputs(fluid('fluorine') * 5000)
        .fluidOutputs(fluid('iodine_pentafluoride') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustAnyPurityIodine') * 2)
        .fluidInputs(fluid('tetrafluoroethylene') * 5000)
        .fluidInputs(fluid('iodine_pentafluoride') * 1000)
        .fluidOutputs(fluid('pentafluoroiodoethane') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    // Nonafluorobutyl iodide

    CSTR.recipeBuilder()
        .notConsumable(metaitem('lamp.mercury.lp'))
        .fluidInputs(fluid('pentafluoroiodoethane') * 50)
        .fluidInputs(fluid('tetrafluoroethylene') * 50)
        .fluidOutputs(fluid('nonafluorobutyl_iodide') * 50)
        .duration(10)
        .EUt(VA[LV])
        .buildAndRegister()

// Fluorinated solvents

    // Novec/HFE-7100

    LCR.recipeBuilder()
        .inputs(ore('dustPotassiumMethoxide') * 6)
        .notConsumable(fluid('dimethylformamide') * 1000)
        .fluidInputs(fluid('nonafluorobutyl_iodide') * 1000)
        .outputs(metaitem('dustPotassiumIodide') * 2)
        .fluidOutputs(fluid('methoxyperfluorobutane') * 1000)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

// Refridgerants

    // Chlorofluoromethanes (I eated the ozone layer)

    ROASTER.recipeBuilder()
        .fluidInputs(fluid('chlorine') * 3000)
        .inputs(ore('dustAnyPurityAntimony'))
        .outputs(metaitem('dustAntimonyTrichloride') * 4)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('antimony_trichloride') * 72)
        .fluidInputs(fluid('chlorine') * 250)
        .fluidOutputs(fluid('antimony_pentachloride') * 125)
        .duration(10)
        .EUt(VA[LV])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('carbon_tetrachloride') * 150)
        .fluidInputs(fluid('hydrogen_fluoride') * 300)
        .fluidInputs(fluid('antimony_pentachloride') * 50)
        .fluidOutputs(fluid('chlorofluoromethane_mix') * 500)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('chlorofluoromethane_mix') * 5000)
        .fluidOutputs(fluid('antimony_pentachloride') * 500)
        .fluidOutputs(fluid('trichlorofluoromethane') * 500) // R-11
        .fluidOutputs(fluid('dichlorodifluoromethane') * 500) // R-12
        .fluidOutputs(fluid('chlorotrifluoromethane') * 500) // R-13
        .fluidOutputs(fluid('hydrogen_chloride') * 3000)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

    BCR.recipeBuilder()
        .fluidInputs(fluid('acidic_chlorodifluoromethane') * 150)
        .fluidInputs(fluid('water') * 100)
        .fluidOutputs(fluid('chlorodifluoromethane') * 50) // R-22
        .fluidOutputs(fluid('hydrochloric_acid') * 100)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    // Hydrofluorocarbons

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedChromiumIiiOxide'))
        .fluidInputs(fluid('trichloroethylene') * 50)
        .fluidInputs(fluid('hydrogen_fluoride') * 200)
        .fluidOutputs(fluid('tetrafluoroethane_mixture') * 200)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    BCR.recipeBuilder()
        .fluidInputs(fluid('tetrafluoroethane_mixture') * 200)
        .fluidInputs(fluid('water') * 150)
        .fluidOutputs(fluid('tetrafluoroethane') * 200) // R-134a
        .fluidOutputs(fluid('hydrochloric_acid') * 150)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

// Plasma etchants

    // Carbon tetrafluoride (CF4)

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedChromiumIiiOxide'))
        .fluidInputs(fluid('chlorotrifluoromethane') * 50)
        .fluidInputs(fluid('hydrogen_fluoride') * 50)
        .fluidOutputs(fluid('carbon_tetrafluoride_mixture') * 100)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    BCR.recipeBuilder()
        .fluidInputs(fluid('carbon_tetrafluoride_mixture') * 100)
        .fluidInputs(fluid('water') * 50)
        .fluidOutputs(fluid('carbon_tetrafluoride') * 50)
        .fluidOutputs(fluid('hydrochloric_acid') * 50)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedChromiumIiiOxide'))
        .fluidInputs(fluid('dichlorodifluoromethane') * 50)
        .fluidInputs(fluid('hydrogen_fluoride') * 100)
        .fluidOutputs(fluid('diluted_carbon_tetrafluoride_mixture') * 150)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    BCR.recipeBuilder()
        .fluidInputs(fluid('diluted_carbon_tetrafluoride_mixture') * 150)
        .fluidInputs(fluid('water') * 100)
        .fluidOutputs(fluid('carbon_tetrafluoride') * 50)
        .fluidOutputs(fluid('hydrochloric_acid') * 100)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    // Octafluorocyclobutane (C4F8) for deep reactive ion etches

    ROASTER.recipeBuilder()
        .fluidInputs(fluid('tetrafluoroethylene') * 2000)
        .fluidOutputs(fluid('octafluorocyclobutane') * 1000)
        .duration(200)
        .EUt(VA[HV])
        .buildAndRegister()

    // Fluoroform (CHF3)

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedChromiumIiiOxide'))
        .fluidInputs(fluid('chloroform') * 50)
        .fluidInputs(fluid('hydrogen_fluoride') * 150)
        .fluidOutputs(fluid('fluoroform_mixture') * 200)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    BCR.recipeBuilder()
        .fluidInputs(fluid('fluoroform_mixture') * 200)
        .fluidInputs(fluid('water') * 150)
        .fluidOutputs(fluid('fluoroform') * 50)
        .fluidOutputs(fluid('hydrochloric_acid') * 150)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    // Hexafluorobutadiene (C4F6)

    LCR.recipeBuilder()
        .notConsumable(ore('dustIronIiiChloride'))
        .fluidInputs(fluid('tetrachloroethylene') * 1000)
        .fluidInputs(fluid('chlorine') * 2000)
        .outputs(metaitem('dustHexachloroethane') * 8)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    LCR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedChromiumIiiOxide'))
        .inputs(ore('dustHexachloroethane') * 8)
        .fluidInputs(fluid('hydrogen_fluoride') * 3000)
        .fluidInputs(fluid('water') * 3000)
        .fluidOutputs(fluid('trichlorotrifluoroethane') * 1000)
        .fluidOutputs(fluid('hydrochloric_acid') * 3000)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()

    LCR.recipeBuilder()
        .notConsumable(fluid('methanol') * 4000)
        .inputs(ore('dustHighPurityZinc'))
        .fluidInputs(fluid('trichlorotrifluoroethane') * 1000)
        .outputs(metaitem('dustZincChloride') * 3)
        .fluidOutputs(fluid('chlorotrifluoroethylene') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustIodine'))
        .fluidInputs(fluid('chlorine') * 1000)
        .fluidOutputs(fluid('iodine_monochloride') * 1000)
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('chlorotrifluoroethylene') * 50)
        .fluidInputs(fluid('iodine_monochloride') * 50)
        .fluidOutputs(fluid('dichlorotrifluoroiodoethane') * 50)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()

    BR.recipeBuilder()
        .notConsumable(metaitem('lamp.mercury.lp'))
        .fluidInputs(fluid('dichlorotrifluoroiodoethane') * 2000)
        .fluidInputs(fluid('mercury') * 1000)
        //.outputs(metaitem('dustMercuryIiIodide') * 3)
        .fluidOutputs(fluid('tetrachlorohexafluorobutane') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    LCR.recipeBuilder()
        .notConsumable(fluid('methanol') * 4000)
        .inputs(ore('dustHighPurityZinc') * 2)
        .fluidInputs(fluid('tetrachlorohexafluorobutane') * 1000)
        .outputs(metaitem('dustZincChloride') * 6)
        .fluidOutputs(fluid('hexafluorobutadiene') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    // Hexafluorobutyne (C4F6)

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedAluminiumChlorofluoride'))
        .fluidInputs(fluid('hexafluorobutadiene') * 50)
        .fluidOutputs(fluid('hexafluorobutyne') * 50)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()