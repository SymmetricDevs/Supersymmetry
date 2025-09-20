import globals.Globals

FLBR = recipemap('fluidized_bed_reactor')
PHASE_SEPARATOR = recipemap('phase_separator')
DT = recipemap('distillation_tower')
POLYMERIZATION = recipemap('polymerization_tank')
SIFTER = recipemap('sifter')
CHEMICAL_BATH = recipemap('chemical_bath')
TUBE_FURNACE = recipemap('tube_furnace')

// Acrylonitrile production via ammoxidation of propylene

// C3H6 + NH3 + 3O -> C3H3N + 3H2O
// C3H6 + NH3 + 5O -> C2H3N + 3H2O + CO2
// C3H6 + 3NH3 + 6O -> 3HCN + 6H2O
FLBR.recipeBuilder() // 100 -> acrylonitrile, 1 -> acetonitrile, 6 -> HCN in SOHIO process
    .notConsumable(ore('dustAmmoxidationCatalyst'))
    .fluidInputs(fluid('propene') * (100 + 1 + 6))
    .fluidInputs(fluid('ammonia') * (100 + 1 + 18))
    .fluidInputs(fluid('oxygen') * (300 + 5 + 36))
    .fluidOutputs(fluid('propylene_ammoxidation_mixture') * (400 + 5 + 54))
    .duration(10)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('propylene_ammoxidation_mixture') * 4590)
    .fluidOutputs(fluid('crude_acrylonitrile') * 4580)
    .fluidOutputs(fluid('carbon_dioxide') * 10)
    .duration(5)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('crude_acrylonitrile') * 4580)
    .fluidOutputs(fluid('water') * 3390)
    .fluidOutputs(fluid('acetonitrile') * 10)
    .fluidOutputs(fluid('acrylonitrile') * 1000)
    .fluidOutputs(fluid('gtfo_hydrogen_cyanide') * 180)
    .duration(10)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

// Polyacrylonitrile production

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('acrylonitrile') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .inputs(ore('dustTinySodiumSulfite') * 3)
    .outputs(metaitem('dustPolyacrylonitrile'))
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .inputs(ore('dustPolyacrylonitrile'))
    .fluidInputs(fluid('dimethylformamide') * 3000)
    .fluidOutputs(fluid('polyacrylonitrile_solution') * 3000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .fluidInputs(fluid('polyacrylonitrile_solution') * 3000)
    .fluidInputs(fluid('water') * 100)
    .notConsumable(metaitem('spinneret'))
    .outputs(metaitem('fiberWetPolyacrylonitrile') * 16)
    .fluidOutputs(fluid('dimethylformamide') * 3000)
    .fluidOutputs(fluid('wastewater') * 100)
    .duration(300)
    .EUt(480)
    .buildAndRegister()

// Conversion to carbon fibers

TUBE_FURNACE.recipeBuilder()
    .inputs(ore('fiberPolyacrylonitrile') * 16)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('fiber.oxidized_polyacrylonitrile') * 16)
    .duration(300)
    .EUt(480)
    .buildAndRegister()

TUBE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('argon') * 50)
    .inputs(metaitem('fiber.oxidized_polyacrylonitrile') * 16)
    .outputs(metaitem('carbon.fibers') * 16)
    .duration(300)
    .EUt(1920)
    .buildAndRegister()