import globals.Globals

ASSEMBLER = recipemap('assembler')
PYROLYSE_OVEN = recipemap('pyrolyse_oven')
VACUUM_CHAMBER = recipemap('vacuum_chamber')

//Carbon Filament Lamp

PYROLYSE_OVEN.recipeBuilder()
    .inputs(item('minecraft:string') * 16)
    .outputs(metaitem('wireFineCarbon') * 8)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineCopper') * 2)
    .inputs(ore('wireFineCarbon'))
    .inputs(metaitem('component.glass.tube') * 2)
    .outputs(metaitem('lamp.carbon_filament') * 2)
    .duration(400)
    .EUt(16)
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('lamp.carbon_filament'))
    .fluidInputs(fluid('nitrogen') * 800)
    .outputs(metaitem('lamp.carbon_filament'))
    .duration(200)
    .EUt(30)
    .buildAndRegister();