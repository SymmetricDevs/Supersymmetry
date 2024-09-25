import petrochemistry.Petrochemistry

REACTION_FURNACE = recipemap('reaction_furnace')
FBR = recipemap('fixed_bed_reactor')
REFORMER = recipemap('catalytic_reformer_recipes')
PHASE_SEPARATOR = recipemap('phase_separator')

/* Isomerization
    REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('light_naphtha') * 1000)
        .fluidInputs(fluid('hydrogen'))
        .fluidOutputs(fluid('isomerization_mixture'))
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedChloridedAlumina'))
        .fluidInputs(fluid('isomerization_mixture'))
        .fluidOutputs(fluid('isomerate'))
        .fluidOutputs(fluid('hydrogen'))
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedSulfatedMetalOxide'))
        .fluidInputs(fluid('isomerization_mixture'))
        .fluidOutputs(fluid('isomerate'))
        .fluidOutputs(fluid('hydrogen'))
        .duration(100)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
*/

/* Alkylation
    CSTR.recipeBuilder()
        .fluidInputs(fluid('hydrofluoric_acid') * 50)
        .fluidInputs(fluid('isobutane') * 1000)
        .fluidInputs(fluid('catalytic_olefin_rich_mixture') * 100)
        .fluidOutputs(fluid('acidic_alkylate_mixture') * 1150)
        .duration(10)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('acidic_alkylate_mixture') * 1150)
        .fluidOutputs(fluid('hydrofluoric_acid') * 45)
        .fluidOutputs(fluid('alkylate_mixture') * 1105)
        .duration(5)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('alkylate_mixture') * 1105)
        .fluidOutputs(fluid('alkylate') * 100)
        .fluidOutputs(fluid('butane') * 90)
        .fluidOutputs(fluid('crude_isobutane') * 915)
        .duration(10)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('crude_isobutane') * 915)
        .fluidOutputs(fluid('isobutane') * 900)
        .fluidOutputs(fluid('hydrofluoric_acid') * 5)
        .fluidOutputs(fluid('propane') * 10)
        .duration(10)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
*/

/* Polymerization
    FBR.recipeBuilder()
        .notConsumable('ore('catalystBedSolidPhosphoricAcid')')
        .fluidInputs(fluid('catalytic_olefin_rich_mixture') * 1000)
        .fluidOutputs(fluid('raw_gasoline_polymerate') * 500)
        .duration(200)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('raw_gasoline_polymerate') * 500)
        .fluidOutputs(fluid('gasoline_polymerate') * 250)
        .fluidOutputs(fluid('lpg') * 250)
        .duration(50)
        .buildAndRegister()
*/

/* Reforming
    REFORMER.recipeBuilder()
        .fluidInputs(fluid('heavy_naphtha') * 1000)
        .fluidInputs(fluid('hydrogen') * 1000)
        .notConsumable(ore('catalystBedSupportedPlatinum'))
        .fluidOutputs(fluid('naphtha_reformate') * 4000)
        .duration(25)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('naphtha_reformate') * 4000)
        .fluidOutputs(fluid('reforming_liquids') * 1000)
        .fluidOutputs(fluid('reforming_effluent') * 3000)
        .duration(25)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('reforming_liquids') * 1000)
        .fluidOutputs(fluid('reformate') * 600)
        .fluidOutputs(fluid('fuel_gas') * 200)
        .fluidOutputs(fluid('refinery_gas') * 200)
        .duration(400)
        .buildAndRegister()
*/