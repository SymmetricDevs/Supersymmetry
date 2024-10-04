import globals.Globals

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

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateSteel') * 2)
    .inputs(ore('pipeTinyFluidCopper') * 2)
    .circuitMeta(2)
    .outputs(item('susy:serpentine') * 6)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

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

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(9)
    .inputs(ore('plateStainlessSteel') * 9)
    .outputs(item('susy:susy_multiblock_casing', 2))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(11)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('susy:susy_multiblock_casing', 1))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()
    
crafting.addShaped("susy:air_vent_w", item('susy:meta_item', 4), [
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

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(11)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('susy:susy_multiblock_casing', 1))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//Deposit stuff
// Crushed Sulfur Ore * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('gregtech:ore_sulfur_0')], null)
// Crushed Sulfur Ore * 2
mods.gregtech.macerator.removeByInput(2, [item('gregtech:ore_sulfur_0')], null)

// Armors
crafting.addShaped("susy:simple_gas_mask", item('susy:susy_armor_item').withNbt(['damage': 0.0D]), [
    [item('gregtech:meta_item_1', 438), item('minecraft:paper'), item('gregtech:meta_item_1', 438)],
    [ore('string'), item('gregtech:meta_dust', 271), ore('string')],
    [null, item('minecraft:paper'), null]
])

crafting.addShaped("susy:gas_mask", item('susy:susy_armor_item', 1), [
    [ore('leather'), ore('plateGlass'), ore('leather')],
    [ore('leather'), ore('leather'), ore('leather')],
    [null, ore('pipeTinyFluidRubber'), ore('ringRubber')]
])
crafting.addShaped("susy:gas_tank", item('susy:susy_armor_item', 2).withNbt(['maxOxygen': 1200.0D, 'oxygen': 0.0D]), [
    [null, ore('pipeTinyFluidRubber'), ore('ringRubber')],
    [ore('leather'), metaitem('fluid_cell'), ore('leather')]
])
crafting.addShapeless("susy:gas_tank_fill", item('susy:susy_armor_item', 2).withNbt(['maxOxygen': 1200.0D, 'oxygen': 1200.0D]), 
    [item('susy:susy_armor_item', 2), 
    metaitem('fluid_cell').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 1000]])])

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(1)
    .inputs(item('minecraft:leather_helmet'))
    .inputs(ore('pipeTinyFluidRubber'))
    .inputs(ore('ringRubber'))
    .inputs(metaitem('mineral_wool') * 5)
    .inputs(ore('foilAsbestos') * 5)
    .fluidInputs(fluid('glass') * 144)
    .outputs(item('susy:susy_armor_item', 3).withNbt(['damage': 0.0D]))
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
    .outputs(item('susy:susy_armor_item', 4).withNbt(['maxOxygen': 1200.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

crafting.shapelessBuilder()
    .name("susy:asbestos_tank_fill")
    .output(item('susy:susy_armor_item', 4).withNbt(['maxOxygen': 1200.0D, 'oxygen': 1200.0D]))
    .input(item('susy:susy_armor_item', 4).mark('tank')) 
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
    .outputs(item('susy:susy_armor_item', 5).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()
    
mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(4)
    .inputs(item('minecraft:leather_boots'))
    .inputs(metaitem('mineral_wool') * 4)
    .inputs(ore('foilAsbestos') * 4)
    .outputs(item('susy:susy_armor_item', 6).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .inputs(item('susy:meta_item', 1))
    .inputs(item('susy:susy_armor_item', 4))
    .outputs(item('susy:susy_armor_item', 7).withNbt(['maxOxygen': 2400.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()
    
crafting.shapelessBuilder()
    .name("susy:rebreather_tank_fill")
    .output(item('susy:susy_armor_item', 7).withNbt(['maxOxygen': 2400.0D, 'oxygen': 2400.0D]))
    .input(item('susy:susy_armor_item', 7).mark('tank')) 
    .input(metaitem('dustLithiumHydroxide'))
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputs(item('susy:susy_armor_item', 3))
    .outputs(item('susy:susy_armor_item', 8).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputs(item('susy:susy_armor_item', 4))
    .outputs(item('susy:susy_armor_item', 9).withNbt(['damage': 0.0D, 'maxOxygen': 1200.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputs(item('susy:susy_armor_item', 7))
    .outputs(item('susy:susy_armor_item', 9).withNbt(['damage': 0.0D, 'maxOxygen': 1200.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputs(item('susy:susy_armor_item', 5))
    .outputs(item('susy:susy_armor_item', 10).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.cvd.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputs(item('susy:susy_armor_item', 6))
    .outputs(item('susy:susy_armor_item', 11).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

crafting.shapelessBuilder()
    .name("susy:reflective_tank_fill")
    .output(item('susy:susy_armor_item', 4).withNbt(['maxOxygen': 1200.0D, 'oxygen': 1200.0D]))
    .input(item('susy:susy_armor_item', 4).mark('tank')) 
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

mods.gregtech.assembler.recipeBuilder()
    .inputs(metaitem('dustMolecularSieve'))
    .inputs(item('susy:meta_item', 1))
    .inputs(item('susy:susy_armor_item', 9))
    .outputs(item('susy:susy_armor_item', 12).withNbt(['maxOxygen': -1.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('threadPolybenzimidazole'))
    .inputs(metaitem('plateNomex') * 5)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate'))
    .fluidInputs(fluid('borosilicate_glass') * 288)
    .outputs(item('susy:susy_armor_item', 13))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('plateNomex') * 8)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('electric.piston.ev'))
    .inputs(metaitem('rotorTitanium'))
    .inputs(metaitem('large_fluid_cell.stainless_steel'))
    .outputs(item('susy:susy_armor_item', 14))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(3)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('plateNomex') * 7)
    .outputs(item('susy:susy_armor_item', 15))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()
    
mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(4)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('plateNomex') * 4)
    .inputs(metaitem('electric.pump.mv'))
    .outputs(item('susy:susy_armor_item', 16))
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()