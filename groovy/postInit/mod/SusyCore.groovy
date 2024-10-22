import globals.Globals
import globals.RecyclingHelper

crafting.addShaped("susy:basic_structural_casing", item('susy:susy_multiblock_casing', 3) * 6, [
    [ore('screwWroughtIron'), ore('plateWroughtIron'), ore('craftingToolHardHammer')],
    [ore('plateWroughtIron'), null, ore('plateWroughtIron')],
    [ore('craftingToolScrewdriver'), ore('plateWroughtIron'), ore('screwWroughtIron')]
])

crafting.addShaped("susy:basic_serpentine", item('susy:serpentine') * 6, [
    [null, ore('plateSteel'), ore('craftingToolWrench')],
    [ore('pipeTinyFluidCopper'), ore('pipeTinyFluidCopper'), ore('pipeTinyFluidCopper')],
    [ore('craftingToolHardHammer'), ore('plateSteel'), null]
])

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateWroughtIron') * 4)
    .circuitMeta(2)
    .outputs(item('susy:susy_multiblock_casing', 3) * 6)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 3) * 3, [ore('plateWroughtIron') * 2])

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateSteel') * 2)
    .inputs(ore('pipeTinyFluidCopper') * 2)
    .circuitMeta(2)
    .outputs(item('susy:serpentine') * 6)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:serpentine') * 3, [item('gregtech:fluid_pipe_tiny', 25), ore('plateSteel')])

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(10)
    .inputs(metaitem('electric.motor.hv') * 2)
    .inputs(ore('gearStainlessSteel') * 4)
    .inputs(ore('rotorStainlessSteel') * 16)
    .inputs(ore('plateStainlessSteel') * 16)
    .outputs(item('susy:separator_rotor') * 5)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:separator_rotor') * 5,
		[metaitem('electric.motor.hv') * 2, ore('gearStainlessSteel') * 4, ore('rotorStainlessSteel') * 16, ore('plateStainlessSteel') * 16]
)

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(9)
    .inputs(ore('plateStainlessSteel') * 9)
    .outputs(item('susy:susy_multiblock_casing', 2))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 2), [ore('plateStainlessSteel') * 9])

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(11)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('susy:susy_multiblock_casing', 1))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 1), [ore('plateStainlessSteel') * 4, ore('frameGtStainlessSteel')])

RecyclingHelper.addShaped("susy:air_vent_w", item('susy:meta_item', 4), [
	[ore('craftingToolHardHammer'),ore('stickWroughtIron'),ore('craftingToolScrewdriver')],
	[ore('plateWroughtIron'),ore('stickWroughtIron'),ore('plateWroughtIron')],
	[ore('screwWroughtIron'),ore('stickWroughtIron'),ore('screwWroughtIron')]
])

crafting.addShaped("susy:air_vent_n", item('susy:meta_item', 4), [
	[ore('craftingToolHardHammer'),ore('stickIron'),ore('craftingToolScrewdriver')],
	[ore('plateIron'),ore('stickIron'),ore('plateIron')],
	[ore('screwIron'),ore('stickIron'),ore('screwIron')]
])

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateWroughtIron') * 2)
    .inputs(ore('stickWroughtIron') * 2)
    .inputs(ore('screwWroughtIron') * 2)
    .circuitMeta(13)
    .outputs(item('susy:meta_item', 4))
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateIron') * 2)
    .inputs(ore('stickIron') * 2)
    .inputs(ore('screwIron') * 2)
    .circuitMeta(13)
    .outputs(item('susy:meta_item', 4))
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//Deposit stuff
// Crushed Sulfur Ore * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('gregtech:ore_sulfur_0')], null)
// Crushed Sulfur Ore * 2
mods.gregtech.macerator.removeByInput(2, [item('gregtech:ore_sulfur_0')], null)
