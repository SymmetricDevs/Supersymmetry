import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import postInit.utils.RecyclingHelper

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('lava') * 1000)
        .notConsumable(metaitem('stickSteel'))
        .outputs(metaitem('mineral_wool') * 16)
        .duration(500)
        .EUt(VA[LV])
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('chilled_lava') * 1000)
        .notConsumable(ore('stickSteel'))
        .outputs(metaitem('mineral_wool') * 16)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .inputs(ore('wireGtDoubleCupronickel') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(ore('foilBronze') * 8)
        .outputs(item('gregtech:wire_coil'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();


ASSEMBLER.recipeBuilder()
        .inputs(ore('wireGtDoubleNichrome') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(ore('foilAluminium') * 8)
        .outputs(item('gregtech:wire_coil', 1)) // swapped
        .duration(300)
        .EUt(VA[MV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .inputs(ore('wireGtDoubleKanthal') * 8)
        .inputs(metaitem('ingotSyntheticMulliteRefractory') * 8)
        .inputs(ore('foilStainlessSteel') * 8)
        .outputs(item('gregtech:wire_coil', 2)) // swapped
        .duration(400)
        .EUt(VA[HV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .fluidInputs(fluid('refractory_gunning_mixture') * 1000)
        .inputs(ore('stickMolybdenumDisilicide') * 8)
        .inputs(metaitem('ingotTabularAluminaRefractory') * 8)
        .inputs(ore('foilHighPurityAluminium') * 8)
        .outputs(item('susy:heating_coil'))
        .duration(400)
        .EUt(VA[EV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .fluidInputs(fluid('molybdenum_disilicide') * 144)
        .inputs(ore('wireGtDoubleTungsten') * 8)
        .inputs(metaitem('ingotTabularAluminaRefractory') * 8)
        .inputs(ore('foilTantalum') * 8)
        .outputs(item('susy:heating_coil', 1))
        .duration(400)
        .EUt(VA[IV])
        .buildAndRegister();

mods.jei.ingredient.yeet(item('gregtech:wire_coil', 3))
mods.jei.ingredient.yeet(item('gregtech:wire_coil', 4))

crafting.addShapeless('susy:heating_coil.rtm_convert', item('susy:heating_coil', 2), [item('gregtech:wire_coil', 3)])
crafting.addShapeless('susy:heating_coil.hssg_convert', item('susy:heating_coil', 2), [item('gregtech:wire_coil', 4)])
crafting.addShapeless('susy:spring.kanthal_convert', item('gregtech:meta_spring', 294), [item('gregtech:meta_spring', 288)])
crafting.addShapeless('susy:spring.nichrome_convert', item('gregtech:meta_spring', 288), [item('gregtech:meta_spring', 294)])

//Gotta swap nichrome and kanthal 4x wires in these recipes as part of the coil changes.
//Alloy Smelter
RecyclingHelper.removeByOutput(item('gregtech:machine', 83))
RecyclingHelper.removeByOutput(item('gregtech:machine', 82))
crafting.replaceShaped('gregtech:machine_83_', item('gregtech:machine', 83), [
        [ore('circuitEv'), ore('wireGtQuadrupleKanthal'), ore('circuitEv')],
        [ore('wireGtQuadrupleKanthal'), metaitem('hull.ev'), ore('wireGtQuadrupleKanthal')],
        [ore('cableGtSingleAluminium'), ore('wireGtQuadrupleKanthal'), ore('cableGtSingleAluminium')]])
crafting.replaceShaped('gregtech:machine_82', item('gregtech:machine', 82), [
        [ore('circuitHv'), ore('wireGtQuadrupleNichrome'), ore('circuitHv')],
        [ore('wireGtQuadrupleNichrome'), metaitem('hull.hv'), ore('wireGtQuadrupleNichrome')],
        [ore('cableGtSingleGold'), ore('wireGtQuadrupleNichrome'), ore('cableGtSingleGold')]])

//Extruder
RecyclingHelper.removeByOutput(item('gregtech:machine', 323))
RecyclingHelper.removeByOutput(item('gregtech:machine', 322))
crafting.replaceShaped('gregtech:machine_323', item('gregtech:machine', 323), [
        [ore('wireGtQuadrupleKanthal'), ore('wireGtQuadrupleKanthal'), ore('circuitEv')],
        [metaitem('electric.piston.ev'), metaitem('hull.ev'), ore('pipeNormalFluidTitanium')],
        [ore('wireGtQuadrupleKanthal'), ore('wireGtQuadrupleKanthal'), ore('circuitEv')]])
crafting.replaceShaped('gregtech:machine_322', item('gregtech:machine', 322), [
        [ore('wireGtQuadrupleNichrome'), ore('wireGtQuadrupleNichrome'), ore('circuitHv')],
        [metaitem('electric.piston.hv'), metaitem('hull.hv'), ore('pipeNormalFluidStainlessSteel')],
        [ore('wireGtQuadrupleNichrome'), ore('wireGtQuadrupleNichrome'), ore('circuitHv')]])

//Thermal Centrifuge
RecyclingHelper.removeByOutput(item('gregtech:machine', 608))
RecyclingHelper.removeByOutput(item('gregtech:machine', 607))
crafting.replaceShaped('gregtech:machine_608', item('gregtech:machine', 608), [
        [ore('circuitEv'), metaitem('electric.motor.ev'), ore('circuitEv')],
        [ore('wireGtQuadrupleKanthal'), metaitem('hull.ev'), ore('wireGtQuadrupleKanthal')],
        [ore('cableGtSingleAluminium'), metaitem('electric.motor.ev'), ore('cableGtSingleAluminium')]])
crafting.replaceShaped('gregtech:machine_607', item('gregtech:machine', 607), [
        [ore('circuitHv'), metaitem('electric.motor.hv'), ore('circuitHv')],
        [ore('wireGtQuadrupleNichrome'), metaitem('hull.hv'), ore('wireGtQuadrupleNichrome')],
        [ore('cableGtSingleGold'), metaitem('electric.motor.hv'), ore('cableGtSingleGold')]])

//Fluid Heater
RecyclingHelper.removeByOutput(item('gregtech:machine', 383))
RecyclingHelper.removeByOutput(item('gregtech:machine', 382))
crafting.replaceShaped('gregtech:machine_383', item('gregtech:machine', 383), [
        [ore('wireGtQuadrupleKanthal'), item('gregtech:transparent_casing'), ore('wireGtQuadrupleKanthal')],
        [metaitem('electric.pump.ev'), metaitem('hull.ev'), metaitem('electric.pump.ev')],
        [ore('cableGtSingleAluminium'), ore('circuitEv'), ore('cableGtSingleAluminium')]])
crafting.replaceShaped('gregtech:machine_382', item('gregtech:machine', 382), [
        [ore('wireGtQuadrupleNichrome'), item('gregtech:transparent_casing'), ore('wireGtQuadrupleNichrome')],
        [metaitem('electric.pump.hv'), metaitem('hull.hv'), metaitem('electric.pump.hv')],
        [ore('cableGtSingleGold'), ore('circuitHv'), ore('cableGtSingleGold')]])

//Multicooker
RecyclingHelper.removeByOutput(item('gregtech:machine', 8569))
RecyclingHelper.removeByOutput(item('gregtech:machine', 8568))
crafting.replaceShaped('gregtech:machine_8569', item('gregtech:machine', 8569), [
        [ore('circuitEv'), item('gregtech:transparent_casing'), ore('circuitEv')],
        [item('gregtech:transparent_casing'), metaitem('hull.ev'), item('gregtech:transparent_casing')],
        [ore('wireGtQuadrupleKanthal'), metaitem('electric.motor.ev'), ore('wireGtQuadrupleKanthal')]])
crafting.replaceShaped('gregtech:machine_8568', item('gregtech:machine', 8568), [
        [ore('circuitHv'), item('gregtech:transparent_casing'), ore('circuitHv')],
        [item('gregtech:transparent_casing'), metaitem('hull.hv'), item('gregtech:transparent_casing')],
        [ore('wireGtQuadrupleNichrome'), metaitem('electric.motor.hv'), ore('wireGtQuadrupleNichrome')]])