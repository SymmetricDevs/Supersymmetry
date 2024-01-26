import globals.Globals

//REMOVALS
furnace.removeByInput(item('minecraft:slime_ball'))
// Sticky Resin * 1
mods.gregtech.fluid_solidifier.removeByInput(8, [metaitem('shape.mold.ball')], [fluid('gtfo_rubber_sap') * 100])

//ADDITIONS

crafting.addShaped('gregtech:resin_item', metaitem('rubber_drop') * 4, [
        [null, null, null],
        [null, fluid('resin') * 1000, null],
        [null, metaitem('shape.mold.ball').reuse(), null]
])

def DISTILLERY = recipemap('distillery');
def CENTRIFUGE = recipemap('centrifuge');
def FLUID_SOLIDIFIER = recipemap('fluid_solidifier');

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('resin') * 100)
        .fluidOutputs(fluid('glue') * 75)
        .duration(15)
        .EUt(30)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .fluidInputs(fluid('resin') * 250)
        .outputs(metaitem('rubber_drop'))
        .duration(20)
        .EUt(2)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('rubber_drop'))
        .fluidOutputs(fluid('resin') * 250)
        .duration(40)
        .EUt(8)
        .buildAndRegister()