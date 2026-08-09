import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

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
        .outputs(item('gregtech:wire_coil', 2))
        .duration(300)
        .EUt(VA[MV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .inputs(ore('wireGtDoubleKanthal') * 8)
        .inputs(metaitem('ingotSyntheticMulliteRefractory') * 8)
        .inputs(ore('foilStainlessSteel') * 8)
        .outputs(item('gregtech:wire_coil', 1))
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
