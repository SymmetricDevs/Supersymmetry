import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Graphite Components
MIXER.recipeBuilder()
    .inputs(ore('dustPitch'))
    .inputs(ore('dustCoke') * 9)
    .outputs(metaitem('carbon_paste') * 5)
    .EUt(VA[LV])
    .duration(80)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPitch'))
    .inputs(ore('dustHeatedGreenCoke') * 9)
    .outputs(metaitem('carbon_paste') * 10)
    .EUt(VA[LV])
    .duration(60)
    .buildAndRegister()

EXTRUDER.recipeBuilder()
    .notConsumable(metaitem('shape.extruder.rod'))
    .inputs(metaitem('carbon_paste'))
    .outputs(metaitem('raw_electrode'))
    .EUt(VA[LV])
    .duration(120)
    .buildAndRegister()

FORMING_PRESS.recipeBuilder()
    .inputs(metaitem('carbon_paste') * 7)
    .notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('raw_carbon_crucible'))
    .EUt(VA[LV])
    .duration(140)
    .buildAndRegister()

FORMING_PRESS.recipeBuilder()
    .inputs(metaitem('carbon_paste') * 9)
    .notConsumable(metaitem('shape.mold.block'))
    .outputs(ore('blockGreenCarbon').first())
    .EUt(VA[LV])
    .duration(180)
    .buildAndRegister()

EXTRUDER.recipeBuilder()
    .notConsumable(metaitem('shape.extruder.plate'))
    .inputs(metaitem('carbon_paste'))
    .outputs(metaitem('raw_carbon_plate'))
    .EUt(VA[LV])
    .duration(120)
    .buildAndRegister()

// Graphite Dust

// Graphite Dust * 9
mods.gregtech.macerator.removeByInput(2, [metaitem('blockGraphite')], null)

BALL_MILL.recipeBuilder()
    .inputs(metaitem('graphite_electrode'))
    .outputs(metaitem('dustGraphite') * 1)
    .EUt(VA[LV])
    .duration(40)
    .buildAndRegister()

BALL_MILL.recipeBuilder()
    .inputs(metaitem('crucible.graphite'))
    .outputs(metaitem('dustGraphite') * 7)
    .EUt(VA[LV])
    .duration(120)
    .buildAndRegister()

BALL_MILL.recipeBuilder()
    .inputs(ore('blockGraphite'))
    .outputs(metaitem('dustGraphite') * 9)
    .EUt(VA[LV])
    .duration(240)
    .buildAndRegister()

// Clay-Graphite
MIXER.recipeBuilder()
    .fluidInputs(fluid('water') * 100)
    .inputs(metaitem('dustFireclay'))
    .inputs(metaitem('dustGraphite'))
    .outputs(metaitem('clay_graphite_paste'))
    .EUt(VA[LV])
    .duration(60)
    .buildAndRegister()

FORMING_PRESS.recipeBuilder()
    .inputs(metaitem('clay_graphite_paste') * 7)
    .notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('raw_clay_graphite_crucible'))
    .EUt(VA[LV])
    .duration(160)
    .buildAndRegister()
