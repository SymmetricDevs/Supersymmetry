import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ModHandler
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.UnificationEntry

// Salt * 2
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('salt_water') * 1000])

oreDict.add('dustFlocculant', metaitem('dustPotassiumAlum'))
oreDict.add('dustFlocculant', metaitem('dustSodiumAlum'))
oreDict.add('dustFlocculant', metaitem('dustAluminiumSulfate'))

// Wastewater treatment
FLUID_HEATER.recipeBuilder()
    .fluidInputs(fluid('wastewater') * 1000)
    .fluidOutputs(fluid('heated_wastewater') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('heated_wastewater') * 1000)
    .inputs(ore('dustFlocculant'))
    .fluidOutputs(fluid('flocculated_wastewater') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('flocculated_wastewater') * 8000)
    .outputs(metaitem('dustAluminiumSulfate'))
    .fluidOutputs(fluid('wastewater_sludge') * 2000)
    .fluidOutputs(fluid('water') * 6000)
    .duration(600)
    .EUt(VA[LV])
    .buildAndRegister()

// Deionized water
ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidInputs(fluid('ro_water') * 12800)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 20)
    .fluidOutputs(fluid('partially_deionized_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 10)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_basic_anion_exchange'))
    .fluidInputs(fluid('partially_deionized_water') * 12800)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 10)
    .fluidOutputs(fluid('deionized_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 10)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidInputs(fluid('desalinated_sea_water') * 12800)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 20)
    .fluidOutputs(fluid('partially_deionized_sea_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 20)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_basic_anion_exchange'))
    .fluidInputs(fluid('partially_deionized_sea_water') * 12800)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 20)
    .fluidOutputs(fluid('deionized_sea_water') * 12800)
    .fluidOutputs(fluid('wastewater') * 20)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

// Ultrapure water for semiconductors
SIFTER.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .notConsumable(ore('dustActivatedCarbon') * 4)
    .fluidOutputs(fluid('filtered_water') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('filtered_water') * 1000)
    .fluidInputs(fluid('steam') * 100)
    .fluidOutputs(fluid('deaerated_water') * 1100)
    .duration(110)
    .EUt(VA[LV])
    .buildAndRegister()

// Reverse osmosis
FLUID_COMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('deaerated_water') * 1000)
    .notConsumable(metaitem('membrane.cellulose_acetate'))
    .fluidOutputs(fluid('ro_water') * 800)
    .fluidOutputs(fluid('wastewater') * 200)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Deionization occurs between these two steps

UV_LIGHT_BOX.recipeBuilder()
    .fluidInputs(fluid('deionized_water') * 1000)
    .fluidOutputs(fluid('sterilized_water') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('ro_water') * 100)
    .fluidOutputs(fluid('ultrapure_water') * 30)
    .duration(10)
    .EUt(40)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('deionized_water') * 100)
    .fluidOutputs(fluid('ultrapure_water') * 60)
    .duration(10)
    .EUt(60)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sterilized_water') * 100)
    .fluidOutputs(fluid('ultrapure_water') * 90)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()
