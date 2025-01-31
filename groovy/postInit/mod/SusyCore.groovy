import globals.Globals
import globals.RecyclingHelper
import gregtech.api.recipes.ingredients.nbtmatch.*

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


// Restrictive Filters
mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('foilSteel') * 8)
    .inputs(metaitem('item_filter'))
    .circuitMeta(1)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .duration(200)
    .outputs(item('susy:meta_item', 6))
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('foilSteel') * 8)
    .inputs(metaitem('item_filter'))
    .circuitMeta(1)
    .fluidInputs(fluid('tin') * 144)
    .outputs(item('susy:meta_item', 6))
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//Deposit stuff
// Crushed Sulfur Ore * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('gregtech:ore_sulfur_0')], null)
// Crushed Sulfur Ore * 2
mods.gregtech.macerator.removeByInput(2, [item('gregtech:ore_sulfur_0')], null)

// Armors
crafting.addShaped("susy:simple_gas_mask", item('susy:susy_armor', 0).withNbt(['damage': 0.0D]), [
    [item('gregtech:meta_item_1', 438), item('minecraft:paper'), item('gregtech:meta_item_1', 438)],
    [ore('string'), ore('dustCharcoal'), ore('string')],
    [null, item('minecraft:paper'), null]
])

crafting.addShaped("susy:gas_mask", item('susy:susy_armor', 2), [
    [metaitem('bound_leather'), ore('plateGlass'), metaitem('bound_leather')],
    [metaitem('bound_leather'), metaitem('bound_leather'), metaitem('bound_leather')],
    [null, ore('pipeTinyFluidRubber'), ore('ringRubber')]
])
crafting.addShaped("susy:gas_tank", item('susy:susy_armor', 3).withNbt(['oxygen': 0.0D]), [
    [metaitem('bound_leather'), null, null],
    [metaitem('bound_leather'), ore('pipeTinyFluidRubber'), ore('ringRubber')],
    [metaitem('bound_leather'), metaitem('fluid_cell'), metaitem('bound_leather')]
])

crafting.addShaped("susy:easy_cell", metaitem('fluid_cell'), [
    [ore('toolHardHammer'), null],
    [null, ore('plateSteel')]
])

crafting.addShapeless("susy:gas_tank_fill", item('susy:susy_armor', 3).withNbt(['oxygen': 1200.0D]), 
    [item('susy:susy_armor', 3),
    metaitem('fluid_cell').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 1000]])
])



mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(1)
    .inputs(item('minecraft:leather_helmet'))
    .inputs(ore('pipeTinyFluidRubber'))
    .inputs(ore('ringRubber'))
    .inputs(metaitem('mineral_wool') * 5)
    .inputs(ore('foilAsbestos') * 5)
    .fluidInputs(fluid('glass') * 144)
    .outputs(item('susy:susy_armor', 4).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(2)
    .inputs(item('minecraft:leather_chestplate'))
    .inputs(ore('pipeTinyFluidRubber'))
    .inputs(ore('ringRubber'))
    .inputs(metaitem('mineral_wool') * 8)
    .inputs(ore('foilAsbestos') * 8)
    .inputs(metaitem('large_fluid_cell.steel'))
    .outputs(item('susy:susy_armor', 5).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

crafting.shapelessBuilder()
    .name("susy:asbestos_tank_fill")
    .output(item('susy:susy_armor', 5).withNbt(['oxygen': 1200.0D]))
    .input(item('susy:susy_armor', 5).mark('tank')) 
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(3)
    .inputs(item('minecraft:leather_leggings'))
    .inputs(metaitem('mineral_wool') * 7)
    .inputs(ore('foilAsbestos') * 7)
    .outputs(item('susy:susy_armor', 6).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()
    
mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(4)
    .inputs(item('minecraft:leather_boots'))
    .inputs(metaitem('mineral_wool') * 4)
    .inputs(ore('foilAsbestos') * 4)
    .outputs(item('susy:susy_armor', 7).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .inputs(item('susy:meta_item', 1))
    .inputNBT(item('susy:susy_armor', 5), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 8).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()
    
crafting.shapelessBuilder()
    .name("susy:rebreather_tank_fill")
    .output(item('susy:susy_armor', 8).withNbt(['oxygen': 3600.0D]))
    .input(item('susy:susy_armor', 8).mark('tank')) 
    .input(metaitem('dustLithiumHydroxide'))
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 4), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 9).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 5), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 10).withNbt(['damage': 0.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

crafting.shapelessBuilder()
    .name("susy:reflective_tank_fill")
    .output(item('susy:susy_armor', 10).withNbt(['oxygen': 1200.0D]))
    .input(item('susy:susy_armor', 10).mark('tank')) 
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

// Rebreather tanks can be upgraded too.
mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 8), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 10).withNbt(['damage': 0.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 6), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 11).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 7), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 12).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

// Filtered tank
mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('dustMolecularSieve'))
    .inputs(metaitem('plateStainlessSteel') * 4)
    .inputs(item('susy:meta_item', 1))
    .inputNBT(item('susy:susy_armor', 10), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 13).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('threadPolybenzimidazole') * 10)
    .inputs(metaitem('plateNomex') * 5)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate'))
    .fluidInputs(fluid('borosilicate_glass') * 288)
    .outputs(item('susy:susy_armor', 14))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('plateNomex') * 8)
    .inputs(ore('threadPolybenzimidazole') * 20)
    .inputs(metaitem('dustMolecularSieve') * 4)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('electric.piston.ev'))
    .inputs(metaitem('rotorTitanium'))
    .inputs(metaitem('large_fluid_cell.stainless_steel'))
    .outputs(item('susy:susy_armor', 15))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(3)
    .inputs(ore('threadPolybenzimidazole') * 16)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 3)
    .inputs(metaitem('plateNomex') * 7)
    .outputs(item('susy:susy_armor', 16).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()
    
mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(4)
    .inputs(ore('threadPolybenzimidazole') * 14)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('plateNomex') * 4)
    .inputs(metaitem('electric.pump.mv'))
    .outputs(item('susy:susy_armor', 17))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()
