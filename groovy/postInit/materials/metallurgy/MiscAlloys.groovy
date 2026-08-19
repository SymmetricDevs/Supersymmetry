import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Red Alloy
RESISTANCE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 144)
    .inputs(item('minecraft:redstone') * 4)
    .notConsumable(metaitem('susy:clay_graphite_crucible'))
    .fluidOutputs(fluid('red_alloy') * 144)
    .temperature(1473)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('copper') * 144)
    .inputs(item('minecraft:redstone') * 4)
    .fluidOutputs(fluid('red_alloy') * 144)
    .duration(74)
    .EUt(VA[LV])
    .buildAndRegister()

// Invar
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 720) // TO DO: replace
    .inputs(metaitem('ingotNickel') * 3)
    .fluidOutputs(fluid('invar') * 1152)
    .EUt(VA[LV])
    .buildAndRegister()

// Nichrome
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 1008)
    .inputs(metaitem('ingotChrome') * 2)
    .fluidOutputs(fluid('nichrome') * 1296)
    .EUt(VA[MV])
    .buildAndRegister()

// Kanthal
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 3312) // TO DO: replace
    .inputs(metaitem('dustFerrochromium') * 12)
    .inputs(metaitem('ingotAluminium') * 4)
    .fluidOutputs(fluid('kanthal') * 5616)
    .EUt(VA[HV])
    .buildAndRegister()

// Kovar
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 1440) // TO DO: replace
    .inputs(metaitem('ingotNickel') * 5)
    .inputs(metaitem('ingotCobalt') * 3)
    .fluidOutputs(fluid('kovar') * 2592)
    .EUt(VA[LV])
    .buildAndRegister()

// Electrum
RESISTANCE_FURNACE.recipeBuilder()
    .fluidInputs(fluid('silver') * 144)
    .inputs(item('minecraft:gold_ingot'))
    .notConsumable(metaitem('susy:clay_graphite_crucible'))
    .fluidOutputs(fluid('electrum') * 288)
    .temperature(1235)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('silver') * 144)
    .inputs(item('minecraft:gold_ingot'))
    .fluidOutputs(fluid('electrum') * 288)
    .temperature(1235)
    .EUt(VA[LV])
    .buildAndRegister()    

// Monel
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nickel') * 3312)
    .inputs(metaitem('dustManganese') * 2)
    .inputs(metaitem('dustCopper') * 10)
    .inputs(metaitem('dustAluminium') * 4)
    .inputs(metaitem('dustTitanium'))
    .fluidOutputs(fluid('monel_500') * 5760)
    .EUt(VA[MV])
    .buildAndRegister()

// Silver-Indium-Cadmium Alloy
INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('silver') * 2448)
    .inputs(metaitem('dustIndium') * 3)
    .inputs(metaitem('dustCadmium'))
    .fluidOutputs(fluid('silver_indium_cadmium') * 3024)
    .EUt(VA[EV])
    .buildAndRegister()

// Zircaloy
ADVANCED_ARC_FURNACE.recipeBuilder()
    .inputs(metaitem('dustHighPurityZirconium') * 18)
    .inputs(metaitem('dustTin') * 3)
    .inputs(metaitem('dustIron') * 2)
    .inputs(metaitem('dustChrome'))
    .fluidOutputs(fluid('zircaloy_4') * 3456)
    .EUt(VA[IV])
    .duration(400)
    .buildAndRegister()
