import globals.Globals

ASSEMBLER = recipemap('assembler')
PYROLYSE_OVEN = recipemap('pyrolyse_oven')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
REACTION_FURNACE = recipemap('reaction_furnace')
FORMING_PRESS = recipemap('forming_press')

// Glass Tube * 1
mods.gregtech.forming_press.removeByInput(7, [metaitem('dustGlass'), metaitem('shape.mold.ball')], null)

FORMING_PRESS.recipeBuilder()
    .inputs(ore('dustGlass'))
    .notConsumable(metaitem('shape.mold.ball'))
    .circuitMeta(1)
    .outputs(metaitem('component.glass.tube'))
    .duration(80)
    .EUt(7)
    .buildAndRegister();

FORMING_PRESS.recipeBuilder()
    .inputs(ore('dustGlass') * 2)
    .notConsumable(metaitem('shape.mold.ball'))
    .circuitMeta(2)
    .outputs(metaitem('bulb.glass'))
    .duration(160)
    .EUt(7)
    .buildAndRegister();

//Carbon Filament Lamp

PYROLYSE_OVEN.recipeBuilder()
    .inputs(item('minecraft:string') * 16)
    .outputs(metaitem('wireFineCarbon') * 8)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin') * 2)
    .inputs(ore('wireCopper') * 2)
    .inputs(ore('wireFineCarbon') * 8)
    .inputs(metaitem('component.glass.tube'))
    .outputs(metaitem('lamp.carbon_filament.unfilled'))
    .duration(400)
    .EUt(16)
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('lamp.carbon_filament.unfilled'))
    .fluidInputs(fluid('nitrogen') * 800)
    .outputs(metaitem('lamp.carbon_filament'))
    .duration(200)
    .EUt(30)
    .buildAndRegister();

//Mercury Lamps
/Low-Pressure Lamp (UV light source)
EBF.recipeBuilder()
    .notConsumable(metaitem('shape.extruder.pipe.small'))
    .inputs(ore('dustSiliconDioxide') * 3)
    .outputs(metaitem('bulb.fused_quartz'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustTinyQuicklime'))
    .inputs(ore('wireNickel') * 2)
    .inputs(ore('wireCopper') * 2)
    .inputs(metaitem('bulb.fused_quartz'))
    .fluidInputs(fluid('polyvinyl_chloride') * 72)
    .outputs(metaitem('lamp.mercury.uv.unfilled'))
    .duration(400)
    .EUt(120)
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('lamp.mercury.uv.unfilled'))
    .fluidInputs(fluid('nitrogen') * 200)
    .fluidInputs(fluid('mercury') * 100)
    .outputs(metaitem('lamp.mercury.uv'))
    .duration(400)
    .EUt(30)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('dustTinyQuicklime'))
    .inputs(ore('wireNickel') * 2)
    .inputs(ore('wireCopper') * 2))
    .inputs(metaitem('lamp.mercury.uv'))
    .inputs(metaitem('bulb.glass'))
    .fluidInputs(fluid('polyvinyl_chloride') * 72)
    .outputs(metaitem('blacklight'))
    .duration(200)
    .EUt(64)
    .buildAndRegister();

