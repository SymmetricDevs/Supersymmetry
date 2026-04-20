import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Acrylonitrile production via ammoxidation of propylene

// C3H6 + NH3 + 3O -> C3H3N + 3H2O
// C3H6 + NH3 + 5O -> C2H3N + 3H2O + CO2
// C3H6 + 3NH3 + 6O -> 3HCN + 6H2O
FLUIDIZED_BR.recipeBuilder() // 100 -> acrylonitrile, 1 -> acetonitrile, 6 -> HCN in SOHIO process
    .notConsumable(ore('dustAmmoxidationCatalyst'))
    .fluidInputs(fluid('propene') * (100 + 1 + 6))
    .fluidInputs(fluid('ammonia') * (100 + 1 + 18))
    .fluidInputs(fluid('oxygen') * (300 + 5 + 36))
    .fluidOutputs(fluid('propylene_ammoxidation_mixture') * (400 + 5 + 54))
    .duration(10)
    .EUt(VA[HV])
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
    .EUt(VA[HV])
    .buildAndRegister()

// Polyacrylonitrile production

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('acrylonitrile') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .inputs(ore('dustTinySodiumSulfite') * 3)
    .outputs(metaitem('dustPolyacrylonitrile'))
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .inputs(ore('dustPolyacrylonitrile'))
    .fluidInputs(fluid('dimethylformamide') * 3000)
    .fluidOutputs(fluid('polyacrylonitrile_solution') * 3000)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .fluidInputs(fluid('polyacrylonitrile_solution') * 3000)
    .fluidInputs(fluid('water') * 100)
    .notConsumable(metaitem('spinneret'))
    .outputs(metaitem('fiberWetPolyacrylonitrile') * 16)
    .fluidOutputs(fluid('dimethylformamide') * 3000)
    .fluidOutputs(fluid('wastewater') * 100)
    .duration(300)
    .EUt(VA[HV])
    .buildAndRegister()

// Conversion to carbon fibers

TUBE_FURNACE.recipeBuilder()
    .inputs(ore('fiberPolyacrylonitrile') * 16)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('fiber.oxidized_polyacrylonitrile') * 16)
    .duration(300)
    .EUt(VA[HV])
    .buildAndRegister()

TUBE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('argon') * 50)
    .inputs(metaitem('fiber.oxidized_polyacrylonitrile') * 16)
    .outputs(metaitem('carbon.fibers') * 16)
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()

// Raw Carbon Fibers * 1
mods.gregtech.autoclave.removeByInput(30, [metaitem('dustCarbon') * 4], [fluid('plastic') * 36])
// Raw Carbon Fibers * 2
mods.gregtech.autoclave.removeByInput(120, [metaitem('dustCarbon') * 4], [fluid('polytetrafluoroethylene') * 18])
// Raw Carbon Fibers * 4
mods.gregtech.autoclave.removeByInput(480, [metaitem('dustCarbon') * 4], [fluid('epoxy') * 9])
