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

RESISTANCE_FURNACE.recipeBuilder()
    .inputs(metaitem('dustCopper'))
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

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustCopper'))
    .inputs(item('minecraft:redstone') * 4)
    .fluidOutputs(fluid('red_alloy') * 144)
    .duration(74)
    .EUt(VA[LV])
    .buildAndRegister()

// Electrum

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('gold') * 144)
    .fluidInputs(fluid('silver') * 144)
    .fluidOutputs(fluid('electrum') * 288)
    .EUt(VA[MV])
    .duration(10)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('nitrogen') * 1000)
    .fluidInputs(fluid('gold') * 2736)
    .inputs(ore('dustAntimony'))
    .fluidOutputs(fluid('gold_antimony') * 2880)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .notConsumable(fluid('argon') * 1000)
    .fluidInputs(fluid('gold') * 2736)
    .inputs(ore('dustAntimony'))
    .fluidOutputs(fluid('gold_antimony') * 2880)
    .EUt(VA[MV])
    .duration(8)
    .buildAndRegister()

// Invar

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('iron') * 720) // TO DO: replace
    .inputs(metaitem('ingotNickel') * 3)
    .fluidOutputs(fluid('invar') * 1152)
    .EUt(VA[LV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .inputs(item('minecraft:iron_ingot') * 5) // TO DO: replace
    .inputs(metaitem('ingotNickel') * 3)
    .fluidOutputs(fluid('invar') * 1152)
    .EUt(VA[LV])
    .buildAndRegister()

// Kanthal

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 3312) // TO DO: replace
    .inputs(metaitem('dustFerrochromium') * 12)
    .inputs(metaitem('ingotAluminium') * 4)
    .fluidOutputs(fluid('kanthal') * 5616)
    .EUt(VA[HV])
    .material("Alumina")
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(item('minecraft:iron_ingot') * 23) // TO DO: replace
    .inputs(metaitem('dustFerrochromium') * 12)
    .inputs(metaitem('ingotAluminium') * 4)
    .fluidOutputs(fluid('kanthal') * 5616)
    .EUt(VA[HV])
    .material("Alumina")
    .buildAndRegister()

// Kovar

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('iron') * 1440) // TO DO: replace
    .inputs(metaitem('ingotNickel') * 5)
    .inputs(metaitem('ingotCobalt') * 3)
    .fluidOutputs(fluid('kovar') * 2592)
    .EUt(VA[LV])
    .material("Alumina")
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(item('minecraft:iron_ingot') * 10)
    .inputs(metaitem('ingotNickel') * 5)
    .inputs(metaitem('ingotCobalt') * 3)
    .fluidOutputs(fluid('kovar') * 2592)
    .EUt(VA[LV])
    .material("Alumina")
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('silver') * 144)
    .inputs(item('minecraft:gold_ingot'))
    .fluidOutputs(fluid('electrum') * 288)
    .EUt(VA[LV])
    .buildAndRegister()

// Silver-Indium-Cadmium

INDUCTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('silver') * 2448)
    .inputs(metaitem('dustIndium') * 3)
    .inputs(metaitem('dustCadmium'))
    .fluidOutputs(fluid('silver_indium_cadmium') * 3024)
    .EUt(VA[EV])
    .buildAndRegister()

INDUCTION_FURNACE.recipeBuilder()
    .inputs(metaitem('dustSilver') * 17)
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
