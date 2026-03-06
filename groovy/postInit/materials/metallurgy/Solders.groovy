import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustBismuth') * 6)
    .inputs(ore('dustTin') * 4)
    .outputs(metaitem('ingotLeadFreeSolder') * 10)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('dustBismuth') * 6)
    .inputs(ore('ingotTin') * 4)
    .outputs(metaitem('ingotLeadFreeSolder') * 10)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotBismuth') * 6)
    .inputs(ore('dustTin') * 4)
    .outputs(metaitem('ingotLeadFreeSolder') * 10)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

ALLOY_SMELTER.recipeBuilder()
    .inputs(ore('ingotBismuth') * 6)
    .inputs(ore('ingotTin') * 4)
    .outputs(metaitem('ingotLeadFreeSolder') * 10)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustIndium') * 3)
    .inputs(ore('dustTinySilver'))
    .outputs(metaitem('dustCryogenicSolder') * 3)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

crafting.addShaped("susy:cryogenic_solder", metaitem('dustCryogenicSolder') * 3, [
        [ore('dustIndium'), ore('dustIndium'), ore('dustIndium')],
        [ore('dustTinySilver'), null, null],
        [null, null, null]
])
