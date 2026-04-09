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

    // Hydrofluorocarbons

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedSupportedChromium'))
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
