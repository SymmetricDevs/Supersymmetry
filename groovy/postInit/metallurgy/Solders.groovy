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