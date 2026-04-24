import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

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

MIXER.recipeBuilder()
    .inputs(ore('dustIndium') * 3)
    .inputs(ore('dustTinySilver'))
    .outputs(metaitem('dustCryogenicSolder') * 3)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

crafting.addShapeless("susy:cryogenic_solder", metaitem('dustCryogenicSolder') * 3, [
    ore('dustIndium'),
    ore('dustIndium'),
    ore('dustIndium'),
    ore('dustTinySilver')
])

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
        .fluidInputs(fluid('steric_acid') * 10)
        .fluidOutputs(fluid('mildly_activated_solder_flux_mixture') * 5000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustLeadFreeSolder') * 9)
        .fluidIuputs(fluid('mildly_activated_solder_flux_mixture') * 1000)
        .fluidOutputs(fluid('LeadFreeSolderPaste') * 1440)
        .duration(400)
        .EUt(VA[HV])
        .buildAndRegister()