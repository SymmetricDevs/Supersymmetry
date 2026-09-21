import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Lead-Tin Soldering Alloy
RESISTANCE_FURNACE.recipeBuilder()
    .inputs(metaitem('dustTin') * 6)
    .inputs(metaitem('dustLead') * 3)
    .inputs(metaitem('dustAntimony'))
    .notConsumable(metaitem('susy:clay_graphite_crucible'))
    .fluidOutputs(fluid('soldering_alloy') * 1440)
    .temperature(904)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustTin') * 6)
    .inputs(metaitem('dustLead') * 3)
    .inputs(metaitem('dustAntimony'))
    .fluidOutputs(fluid('soldering_alloy') * 1440)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Lead-free (SAC) solder
ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustTin') * 27)
    .inputs(ore('dustSilver'))
    .outputs(metaitem('ingotLeadFreeSolder') * 27)
    .duration(360)
    .EUt(VA[MV])

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustTin') * 27)
    .inputs(ore('ingotSilver'))
    .outputs(metaitem('ingotLeadFreeSolder') * 27)
    .duration(360)
    .EUt(VA[MV])

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotTin') * 27)
    .inputs(ore('dustSilver'))
    .outputs(metaitem('ingotLeadFreeSolder') * 27)
    .duration(360)
    .EUt(VA[MV])

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotTin') * 27)
    .inputs(ore('ingotSilver'))
    .outputs(metaitem('ingotLeadFreeSolder') * 27)
    .duration(360)
    .EUt(VA[MV])

// Cryogenic solder
RESISTANCE_FURNACE.recipeBuilder()
    .inputs(ore('dustIndium') * 3)
    .inputs(ore('dustTinySilver'))
    .notConsumable(metaitem('susy:clay_graphite_crucible'))
    .fluidOutputs(fluid('cryogenic_solder') * 432)
    .temperature(1235)
    .EUt(VA[MV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(ore('dustIndium') * 3)
    .inputs(ore('dustTinySilver'))
    .fluidOutputs(fluid('cryogenic_solder') * 432)
    .duration(60)
    .EUt(VA[MV])
    .buildAndRegister()

// High-temperature solder, SAC solder melt and solder paste
MIXER.recipeBuilder()
    .inputs(ore('dustLead') * 43)
    .inputs(ore('dustTinySilver') * 6)
    .inputs(ore('dustTinyTin') * 4)
    .outputs(metaitem('dustHighTemperatureSolder') * 44)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

crafting.addShapeless("susy:high_temperature_solder", metaitem('dustHighTemperatureSolder') * 44, [
    ore('dustLead') * 43,
    ore('dustTinySilver') * 6,
    ore('dustTinyTin') * 4
])

INDUCTION_FURNACE.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 1000)
    .inputs(ore('dustCopper') * 1)
    .inputs(ore('dustSilver') * 2)
    .fluidInputs(fluid('tin') * 16560)
    .fluidOutputs(fluid('lead_free_solder') * 16560)
    .EUt(VA[MV])
    .duration(1000)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustRosin') * 4)
    .inputs(ore('dustSmallAdipicAcid'))
    .inputs(ore('dustTinyDiethylammoniumChloride'))
    .fluidInputs(fluid('isopropyl_alcohol') * 5000)
    .fluidInputs(fluid('stearic_acid') * 10)
    .fluidOutputs(fluid('mildly_activated_solder_flux_mixture') * 5000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustLeadFreeSolder') * 9)
    .fluidInputs(fluid('mildly_activated_solder_flux_mixture') * 1000)
    .fluidOutputs(fluid('lead_free_solder_paste') * 1440)
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()
