import static globals.Globals.*
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.MetaBlocks.*;

import supersymmetry.api.capability.impl.PseudoMultiRecipeLogic;
import supersymmetry.api.recipes.builders.PseudoMultiRecipeBuilder;
import net.minecraft.init.Blocks;

println("Running Modern Warfare Cubed.groovy...")

def name_removals = [
		'mwc:gunmetal_composite',
		'mwc:gunmetal_ingot',
		'mwc:gunmetal_plate',
		'mwc:grenade40mm'
]

for (name in name_removals) {
    crafting.remove(name)
}

// Gun Barrels
		
crafting.addShaped("supersymmetry:item_lvgunbarrel", metaitem('barrel.lv'), [
		[null, ore('plateSteel'), null],
		[ore('craftingToolHardHammer'), ore('plateSteel'), ore('craftingToolFile')],
		[null, ore('craftingToolSaw'), null]
])
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('ingotSteel') * 2)
		.notConsumable(metaitem('shape.extruder.pipe.tiny'))
		.outputs(metaitem('barrel.mv'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('ingotStainlessSteel') * 2)
		.notConsumable(metaitem('shape.extruder.pipe.tiny'))
		.outputs(metaitem('barrel.hv'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('ingotTitanium') * 2)
		.notConsumable(metaitem('shape.extruder.pipe.tiny'))
		.outputs(metaitem('barrel.ev'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('ingotTungstenSteel') * 2)
		.notConsumable(metaitem('shape.extruder.pipe.tiny'))
		.outputs(metaitem('barrel.iv'))
		.duration(100)
		.EUt(120)
		.buildAndRegister();

// Ammo Casings

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateSteel'))
		.notConsumable(metaitem('shape.extruder.ring'))
		.inputs(ore('paper'))
		.inputs(ore('gunpowder'))
		.outputs(metaitem('bullet.primer') * 32)
		.circuitMeta(1)
		.duration(20)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateBrass'))
		.notConsumable(metaitem('shape.extruder.ring'))
		.outputs(metaitem('bullet.casing_small') * 8)
		.circuitMeta(1)
		.duration(20)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateDoubleBrass'))
		.notConsumable(metaitem('shape.extruder.ring'))
		.outputs(metaitem('bullet.casing_medium') * 8)
		.circuitMeta(1)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateDoubleBrass') * 2)
		.notConsumable(metaitem('shape.extruder.ring'))
		.outputs(metaitem('bullet.casing_large') * 8)
		.circuitMeta(2)
		.duration(20)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('paper'))
		.inputs(ore('plateBrass'))
		.notConsumable(metaitem('shape.extruder.ring'))
		.outputs(metaitem('bullet.casing_shotgun') * 8)
		.circuitMeta(2)
		.duration(20)
		.EUt(30)
		.buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('platePlastic'))
		.inputs(ore('plateBrass'))
		.notConsumable(metaitem('shape.extruder.ring'))
		.outputs(metaitem('bullet.casing_shotgun') * 16)
		.circuitMeta(2)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
// Weapon Stocks

crafting.addShaped("supersymmetry:item_woodstock", metaitem('stock.wood'), [
        [null, ore('craftingToolSoftHammer'), ore('craftingToolFile')],
        [ore('plankWood'), ore('plankWood'), ore('plankWood')],
        [ore('craftingToolSaw'), ore('plankWood'), ore('plankWood')]
])

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('seed_oil') * 100)
        .inputs(ore('plankWood') * 2)
        .outputs(metaitem('stock.wood'))
		.circuitMeta(1)
        .duration(40)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('seed_oil') * 100)
        .inputs(ore('plankTreatedWood') * 2)
        .outputs(metaitem('stock.treated_wood'))
		.circuitMeta(1)
        .duration(40)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('platePlastic') * 4)
		.inputs(metaitem('stickStainlessSteel') * 3)
		.circuitMeta(1)
        .outputs(metaitem('stock.plastic'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 288)
        .inputs(metaitem('platePolytetrafluoroethylene') * 4)
		.inputs(metaitem('stickTitanium') * 3)
		.circuitMeta(1)
        .outputs(metaitem('stock.advanced_plastic'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Grips
		
crafting.addShaped("supersymmetry:item_woodgrip", metaitem('rear_grip.wood'), [
        [null, ore('craftingToolSoftHammer'), ore('craftingToolFile')],
        [null, ore('plankWood'), ore('plankWood')],
        [ore('craftingToolSaw'), null, ore('plankWood')]
])

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('seed_oil') * 100)
        .inputs(ore('plankWood') * 1)
        .outputs(metaitem('rear_grip.wood'))
		.circuitMeta(2)
        .duration(40)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('seed_oil') * 100)
        .inputs(ore('plankTreatedWood') * 1)
        .outputs(metaitem('rear_grip.treated_wood'))
		.circuitMeta(2)
        .duration(40)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('platePlastic') * 2)
		.inputs(metaitem('stickStainlessSteel') * 1)
		.circuitMeta(2)
        .outputs(metaitem('rear_grip.plastic'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 288)
        .inputs(metaitem('platePolytetrafluoroethylene') * 2)
		.inputs(metaitem('stickTitanium') * 1)
		.circuitMeta(2)
        .outputs(metaitem('rear_grip.advanced_plastic'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Handguards
		
crafting.addShaped("supersymmetry:item_woodhandguard", metaitem('handguard.wood'), [
        [null, ore('craftingToolSoftHammer'), ore('craftingToolFile')],
        [ore('plankWood'), ore('plankWood'), ore('plankWood')],
        [ore('craftingToolSaw'), null, null]
])

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('seed_oil') * 100)
        .inputs(ore('plankWood') * 2)
        .outputs(metaitem('handguard.wood'))
		.circuitMeta(3)
        .duration(40)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('seed_oil') * 100)
        .inputs(ore('plankTreatedWood') * 2)
        .outputs(metaitem('handguard.treated_wood'))
		.circuitMeta(3)
        .duration(40)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(ore('plateStainlessSteel') * 3)
		.inputs(metaitem('stickStainlessSteel') * 2)
		.circuitMeta(3)
        .outputs(metaitem('handguard.stainless_steel'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(ore('plateTitanium') * 3)
		.inputs(metaitem('stickTitanium') * 2)
		.circuitMeta(3)
        .outputs(metaitem('handguard.titanium'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 288)
        .inputs(metaitem('plateTungstenSteel') * 3)
		.inputs(metaitem('stickTungstenSteel') * 2)
		.circuitMeta(3)
        .outputs(metaitem('handguard.tungsten_steel'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Pistol Bodies
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateSteel') * 2)
		.inputs(metaitem('stickSteel') * 2)
		.inputs(metaitem('springSmallSteel') * 1)
		.inputs(metaitem('boltSteel'))
		.inputs(metaitem('screwSteel') * 2)
		.circuitMeta(4)
        .outputs(metaitem('pistol_body.MV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateStainlessSteel') * 2)
		.inputs(metaitem('stickStainlessSteel') * 2)
		.inputs(metaitem('springSmallStainlessSteel') * 1)
		.inputs(metaitem('boltStainlessSteel'))
		.inputs(metaitem('screwStainlessSteel') * 2)
		.circuitMeta(4)
        .outputs(metaitem('pistol_body.HV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTitanium') * 2)
		.inputs(metaitem('stickTitanium') * 2)
		.inputs(metaitem('springSmallTitanium') * 1)
		.inputs(metaitem('boltTitanium'))
		.inputs(metaitem('screwTitanium') * 2)
		.circuitMeta(4)
        .outputs(metaitem('pistol_body.EV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTungstenSteel') * 2)
		.inputs(metaitem('stickTungstenSteel') * 2)
		.inputs(metaitem('springTungstenSteel') * 1)
		.inputs(metaitem('boltTungstenSteel'))
		.inputs(metaitem('screwTungstenSteel') * 2)
		.circuitMeta(4)
        .outputs(metaitem('pistol_body.IV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Pistol Slides
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateSteel') * 2)
		.inputs(metaitem('stickSteel') * 2)
		.inputs(metaitem('screwSteel') * 2)
		.circuitMeta(5)
        .outputs(metaitem('pistol_slide.MV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateStainlessSteel') * 2)
		.inputs(metaitem('stickStainlessSteel') * 2)
		.inputs(metaitem('screwStainlessSteel') * 2)
		.circuitMeta(5)
        .outputs(metaitem('pistol_slide.HV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTitanium') * 2)
		.inputs(metaitem('stickTitanium') * 2)
		.inputs(metaitem('screwTitanium') * 2)
		.circuitMeta(5)
        .outputs(metaitem('pistol_slide.EV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTungstenSteel') * 2)
		.inputs(metaitem('stickTungstenSteel') * 2)
		.inputs(metaitem('screwTungstenSteel') * 2)
		.circuitMeta(5)
        .outputs(metaitem('pistol_slide.IV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// SMG Bodies
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateSteel') * 3)
		.inputs(metaitem('stickSteel') * 2)
		.inputs(metaitem('springSmallSteel') * 2)
		.inputs(metaitem('boltSteel'))
		.inputs(metaitem('screwSteel') * 3)
		.circuitMeta(5)
        .outputs(metaitem('smg_body.MV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateStainlessSteel') * 3)
		.inputs(metaitem('stickStainlessSteel') * 2)
		.inputs(metaitem('springSmallStainlessSteel') * 2)
		.inputs(metaitem('boltStainlessSteel'))
		.inputs(metaitem('screwStainlessSteel') * 3)
		.circuitMeta(5)
        .outputs(metaitem('smg_body.HV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTitanium') * 3)
		.inputs(metaitem('stickTitanium') * 2)
		.inputs(metaitem('springSmallTitanium') * 2)
		.inputs(metaitem('boltTitanium'))
		.inputs(metaitem('screwTitanium') * 3)
		.circuitMeta(5)
        .outputs(metaitem('smg_body.EV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTungstenSteel') * 3)
		.inputs(metaitem('stickTungstenSteel') * 2)
		.inputs(metaitem('springTungstenSteel') * 2)
		.inputs(metaitem('boltTungstenSteel'))
		.inputs(metaitem('screwTungstenSteel') * 3)
		.circuitMeta(5)
        .outputs(metaitem('smg_body.IV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Rifle Receivers
		
crafting.addShaped("supersymmetry:item_leveractionreceiver", metaitem('rifle_receiver.lever_action'), [
        [ore('screwSteel'), ore('craftingToolHardHammer'), ore('craftingToolScrewdriver')],
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
        [ore('stickSteel'), ore('boltSteel'), ore('springSmallSteel')]
])
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateSteel') * 4)
		.inputs(metaitem('stickSteel') * 2)
		.inputs(metaitem('springSmallSteel') * 2)
		.inputs(metaitem('boltSteel'))
		.inputs(metaitem('screwSteel') * 4)
		.circuitMeta(6)
        .outputs(metaitem('rifle_receiver.MV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateStainlessSteel') * 4)
		.inputs(metaitem('stickStainlessSteel') * 2)
		.inputs(metaitem('springSmallStainlessSteel') * 2)
		.inputs(metaitem('boltStainlessSteel'))
		.inputs(metaitem('screwStainlessSteel') * 4)
		.circuitMeta(6)
        .outputs(metaitem('rifle_receiver.HV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTitanium') * 4)
		.inputs(metaitem('stickTitanium') * 2)
		.inputs(metaitem('springSmallTitanium') * 2)
		.inputs(metaitem('boltTitanium'))
		.inputs(metaitem('screwTitanium') * 4)
		.circuitMeta(6)
        .outputs(metaitem('rifle_receiver.EV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTungstenSteel') * 4)
		.inputs(metaitem('stickTungstenSteel') * 2)
		.inputs(metaitem('springTungstenSteel') * 2)
		.inputs(metaitem('boltTungstenSteel'))
		.inputs(metaitem('screwTungstenSteel') * 4)
		.circuitMeta(6)
        .outputs(metaitem('rifle_receiver.IV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Sniper Chassis
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 500)
        .inputs(metaitem('rear_grip.wood'))
		.inputs(metaitem('handguard.wood'))
		.inputs(metaitem('stock.wood'))
		.circuitMeta(1)
        .outputs(metaitem('chassis.wood'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('glue') * 1000)
        .inputs(metaitem('rear_grip.treated_wood'))
		.inputs(metaitem('handguard.treated_wood'))
		.inputs(metaitem('stock.treated_wood'))
		.circuitMeta(1)
        .outputs(metaitem('chassis.treated_wood'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 576)
		.inputs(ore('plateStainlessSteel') * 6)
        .inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('handguard.stainless_steel'))
		.inputs(metaitem('stock.plastic'))
		.circuitMeta(1)
        .outputs(metaitem('chassis.stainless_steel'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 576)
		.inputs(ore('plateTitanium') * 6)
        .inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('handguard.titanium'))
		.inputs(metaitem('stock.plastic'))
		.circuitMeta(1)
        .outputs(metaitem('chassis.titanium'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 576)
		.inputs(ore('plateTungstenSteel') * 6)
        .inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('handguard.tungsten_steel'))
		.inputs(metaitem('stock.advanced_plastic'))
		.circuitMeta(1)
        .outputs(metaitem('chassis.tungsten_steel'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Bolt Action Receivers
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateSteel') * 4)
		.inputs(metaitem('stickSteel') * 3)
		.inputs(metaitem('springSmallSteel') * 3)
		.inputs(metaitem('boltSteel')* 2)
		.inputs(metaitem('screwSteel') * 3)
		.circuitMeta(7)
        .outputs(metaitem('bolt_action.MV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateStainlessSteel') * 4)
		.inputs(metaitem('stickStainlessSteel') * 3)
		.inputs(metaitem('springSmallStainlessSteel') * 3)
		.inputs(metaitem('boltStainlessSteel')* 2)
		.inputs(metaitem('screwStainlessSteel') * 3)
		.circuitMeta(7)
        .outputs(metaitem('bolt_action.HV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTitanium') * 4)
		.inputs(metaitem('stickTitanium') * 3)
		.inputs(metaitem('springSmallTitanium') * 3)
		.inputs(metaitem('boltTitanium')* 2)
		.inputs(metaitem('screwTitanium') * 3)
		.circuitMeta(7)
        .outputs(metaitem('bolt_action.EV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('plastic') * 288)
        .inputs(metaitem('plateTungstenSteel') * 4)
		.inputs(metaitem('stickTungstenSteel') * 3)
		.inputs(metaitem('springTungstenSteel') * 3)
		.inputs(metaitem('boltTungstenSteel')* 2)
		.inputs(metaitem('screwTungstenSteel') * 3)
		.circuitMeta(7)
        .outputs(metaitem('bolt_action.IV'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();
		
		// Pistol Rounds
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(1)
		.outputs(item('mwc:bullet4570') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(2)
		.outputs(item('mwc:bullet44') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(3)
		.outputs(item('mwc:bullet500') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(4)
		.outputs(item('mwc:bullet9x18mm') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(5)
		.outputs(item('mwc:bullet9x19mm') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(6)
		.outputs(item('mwc:bullet9x39mm') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_small') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(7)
		.outputs(item('mwc:bullet50ae') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
		// Pistol Magazines
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('springSmallSteel') * 1)
		.inputs(ore('gearSmallSteel') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:makarovmag'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('springSmallSteel') * 1)
		.inputs(ore('gearSmallSteel') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(2)
		.outputs(item('mwc:m9mag_2'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(ore('springSmallStainlessSteel') * 1)
		.inputs(ore('gearSmallStainlessSteel') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:vssvintorezmag_2'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(ore('springSmallStainlessSteel') * 1)
		.inputs(ore('gearSmallStainlessSteel') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(2)
		.outputs(item('mwc:deserteaglemag'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
		// SMG Magazines
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 3)
		.inputs(ore('springSmallSteel') * 2)
		.inputs(ore('gearSmallSteel') * 3)
		.fluidInputs(fluid('plastic') * 432)
		.circuitMeta(3)
		.outputs(item('mwc:mp5a5mag'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 3)
		.inputs(ore('springSmallSteel') * 2)
		.inputs(ore('gearSmallSteel') * 3)
		.fluidInputs(fluid('plastic') * 432)
		.circuitMeta(4)
		.outputs(item('mwc:mp40mag_2'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 3)
		.inputs(ore('springSmallStainlessSteel') * 2)
		.inputs(ore('gearSmallStainlessSteel') * 3)
		.fluidInputs(fluid('plastic') * 432)
		.circuitMeta(3)
		.outputs(item('mwc:mp7mag'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
		// Shotgun Shells
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_shotgun') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(1)
		.outputs(item('mwc:shotgun4g') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_shotgun') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 4)
		.circuitMeta(2)
		.outputs(item('mwc:shotgun12gauge') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
		// Rifle Rounds
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_medium') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 6)
		.circuitMeta(1)
		.outputs(item('mwc:bullet46x30mm') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_medium') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 6)
		.circuitMeta(2)
		.outputs(item('mwc:bullet545x39') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_medium') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 6)
		.circuitMeta(3)
		.outputs(item('mwc:bullet556x45') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_medium') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 6)
		.circuitMeta(4)
		.outputs(item('mwc:bullet762x39') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_medium') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 6)
		.circuitMeta(5)
		.outputs(item('mwc:bullet762x51') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('dustTnt') * 4)
		.circuitMeta(3)
		.outputs(item('mwc:grenade40mm'))
		.duration(20)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(ore('dustTnt') * 6)
		.circuitMeta(3)
		.outputs(item('mwc:grenade40mm') * 2)
		.duration(20)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateTitanium') * 2)
		.inputs(ore('dustTnt') * 8)
		.circuitMeta(3)
		.outputs(item('mwc:grenade40mm') * 4)
		.duration(20)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateTitanium') * 2)
		.inputs(ore('dustTnt') * 6)
		.circuitMeta(4)
		.outputs(item('mwc:rpg7_rocket') * 2)
		.duration(20)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateTungstenSteel') * 2)
		.inputs(ore('dustTnt') * 6)
		.circuitMeta(4)
		.outputs(item('mwc:m202rocket') * 2)
		.duration(20)
		.EUt(480)
		.buildAndRegister();
		
		// Rifle Magazines
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 4)
		.inputs(ore('springSmallSteel') * 2)
		.inputs(ore('gearSmallSteel') * 4)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:ak74mag'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 4)
		.inputs(ore('springSmallSteel') * 2)
		.inputs(ore('gearSmallSteel') * 4)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(6)
		.outputs(item('mwc:ak15mag_2'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 4)
		.inputs(ore('springSmallSteel') * 2)
		.inputs(ore('gearSmallSteel') * 4)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(7)
		.outputs(item('mwc:m4a1mag_2'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(ore('springSmallStainlessSteel') * 1)
		.inputs(ore('gearSmallStainlessSteel') * 2)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(4)
		.outputs(item('mwc:scar40mag'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(ore('springSmallStainlessSteel') * 1)
		.inputs(ore('gearSmallStainlessSteel') * 2)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:stanag50'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
		// Heavy Rifle Magazines
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 6)
		.inputs(ore('springSmallSteel') * 2)
		.inputs(ore('gearSmallSteel') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(8)
		.outputs(item('mwc:brenmag'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateTitanium') * 6)
		.inputs(ore('springSmallTitanium') * 2)
		.inputs(ore('gearSmallTitanium') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(1)
		.outputs(item('mwc:m60mag'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateTitanium') * 8)
		.inputs(ore('springSmallTitanium') * 2)
		.inputs(ore('gearSmallTitanium') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(2)
		.outputs(item('mwc:m134mag'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();

		// Sniper Rounds
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_large') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 8)
		.circuitMeta(1)
		.outputs(item('mwc:bullet792x57') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_large') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 8)
		.circuitMeta(2)
		.outputs(item('mwc:bullet308winchester') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_large') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 8)
		.circuitMeta(3)
		.outputs(item('mwc:bullet408ct') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(metaitem('bullet.casing_large') * 8)
		.inputs(metaitem('roundLead') * 8)
		.inputs(metaitem('bullet.primer') * 8)
		.inputs(metaitem('dustSmallGunpowder') * 8)
		.circuitMeta(4)
		.outputs(item('mwc:bullet50bmg') * 8)
		.duration(20)
		.EUt(30)
		.buildAndRegister();
		
		//Sniper Magazines
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateSteel') * 4)
		.inputs(ore('springSmallSteel') * 4)
		.inputs(ore('gearSmallSteel') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(9)
		.outputs(item('mwc:m40a6mag_2'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(ore('springSmallStainlessSteel') * 4)
		.inputs(ore('gearSmallStainlessSteel') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(6)
		.outputs(item('mwc:interventionmag'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(ore('springSmallTitanium') * 4)
		.inputs(ore('gearSmallTitanium') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(3)
		.outputs(item('mwc:ssg08mag'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateTitanium') * 4)
		.inputs(ore('springSmallTitanium') * 4)
		.inputs(ore('gearSmallTitanium') * 4)
		.fluidInputs(fluid('plastic') * 864)
		.circuitMeta(4)
		.outputs(item('mwc:m82mag_2'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
		// Pistol Recipes
		
crafting.addShaped("supersymmetry:g2_contender", item('mwc:g2_contender'), [
        [ore('craftingToolSoftHammer'), metaitem('pipeTinyFluidSteel') ,ore('craftingToolFile')],
        [metaitem('handguard.wood'), ore('plateSteel'), metaitem('stock.wood')],
        [ore('craftingToolSaw'), null, metaitem('rear_grip.wood')]
])

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('stickSteel') * 6)
		.inputs(metaitem('plateSteel') * 2)
		.inputs(metaitem('rear_grip.wood'))
		.inputs(metaitem('barrel.lv'))
		.circuitMeta(1)
		.outputs(item('mwc:sw_500_magnum'))
		.duration(40)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('pistol_body.MV'))
		.inputs(metaitem('pistol_slide.MV'))
		.inputs(metaitem('barrel.mv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:makarov_pm'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('pistol_body.HV'))
		.inputs(metaitem('pistol_slide.HV'))
		.inputs(metaitem('barrel.hv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:m9a1'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('pistol_body.EV'))
		.inputs(metaitem('pistol_slide.EV'))
		.inputs(metaitem('barrel.ev'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:desert_eagle'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
		// SMG Recipes
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('smg_body.MV'))
		.inputs(metaitem('rear_grip.treated_wood'))
		.inputs(metaitem('stock.treated_wood'))
		.inputs(ore('plateSteel') * 2)
		.inputs(metaitem('barrel.mv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:mp40'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('smg_body.HV'))
		.inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('stock.plastic'))
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(metaitem('barrel.hv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:mp5a5'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('smg_body.EV'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTitanium') * 2)
		.inputs(metaitem('barrel.ev'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:mp7'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
		// Shotgun Recipes
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('plateSteel') * 2)
		.inputs(metaitem('stock.wood'))
		.inputs(metaitem('rear_grip.wood'))
		.inputs(metaitem('barrel.lv') * 2)
		.circuitMeta(1)
		.outputs(item('mwc:ks23'))
		.duration(40)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.treated_wood'))
		.inputs(metaitem('rear_grip.treated_wood'))
		.inputs(metaitem('stock.treated_wood'))
		.inputs(ore('plateSteel') * 2)
		.inputs(metaitem('barrel.mv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(9)
		.outputs(item('mwc:remington870'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.stainless_steel'))
		.inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('stock.plastic'))
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(metaitem('barrel.hv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(9)
		.outputs(item('mwc:supernova'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.titanium'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTitanium') * 2)
		.inputs(metaitem('barrel.ev'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(9)
		.outputs(item('mwc:spas_12'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.tungsten_steel'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTungstenSteel') * 2)
		.inputs(metaitem('barrel.iv'))
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(9)
		.outputs(item('mwc:m1014'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
		// Rifle Recipes
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('plateSteel') * 2)
		.inputs(metaitem('rifle_receiver.lever_action'))
		.inputs(metaitem('stock.wood'))
		.inputs(metaitem('rear_grip.wood'))
		.inputs(metaitem('barrel.lv') * 2)
		.circuitMeta(1)
		.outputs(item('mwc:mares_leg'))
		.duration(40)
		.EUt(30)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.treated_wood'))
		.inputs(metaitem('rear_grip.treated_wood'))
		.inputs(metaitem('stock.treated_wood'))
		.inputs(metaitem('rifle_receiver.MV'))
		.inputs(ore('plateSteel') * 2)
		.inputs(metaitem('barrel.mv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:ak74'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.treated_wood'))
		.inputs(metaitem('rear_grip.treated_wood'))
		.inputs(metaitem('stock.treated_wood'))
		.inputs(metaitem('rifle_receiver.MV'))
		.inputs(ore('plateSteel') * 2)
		.inputs(metaitem('barrel.mv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(2)
		.outputs(item('mwc:ak47'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.stainless_steel'))
		.inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('stock.plastic'))
		.inputs(metaitem('rifle_receiver.HV'))
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(metaitem('barrel.hv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(2)
		.outputs(item('mwc:m4a1'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.stainless_steel'))
		.inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('stock.plastic'))
		.inputs(metaitem('rifle_receiver.HV'))
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(metaitem('barrel.hv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(3)
		.outputs(item('mwc:m16a4'))
		.duration(40)
		.EUt(480)
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.titanium'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(metaitem('rifle_receiver.EV'))
		.inputs(ore('plateTitanium') * 2)
		.inputs(metaitem('barrel.ev') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(2)
		.outputs(item('mwc:scar_h_cqc'))
		.duration(40)
		.EUt(1920)
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.titanium'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(metaitem('rifle_receiver.EV'))
		.inputs(ore('plateTitanium') * 2)
		.inputs(metaitem('barrel.ev') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(3)
		.outputs(item('mwc:vss_vintorez'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.tungsten_steel'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(metaitem('rifle_receiver.IV'))
		.inputs(ore('plateTungstenSteel') * 2)
		.inputs(metaitem('barrel.iv') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(2)
		.outputs(item('mwc:m82_barrett'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
		// Sniper Recipes
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('chassis.treated_wood'))
		.inputs(metaitem('bolt_action.MV'))
		.inputs(ore('plateSteel') * 2)
		.inputs(metaitem('barrel.mv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:kar98k'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('chassis.stainless_steel'))
		.inputs(metaitem('bolt_action.HV'))
		.inputs(ore('plateStainlessSteel') * 2)
		.inputs(metaitem('barrel.hv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:m40a6'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('chassis.titanium'))
		.inputs(metaitem('bolt_action.EV'))
		.inputs(ore('plateTitanium') * 2)
		.inputs(metaitem('barrel.ev') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:m200_intervention'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('chassis.tungsten_steel'))
		.inputs(metaitem('bolt_action.IV'))
		.inputs(ore('plateTungstenSteel') * 2)
		.inputs(metaitem('barrel.iv') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(1)
		.outputs(item('mwc:ssg_08'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
		// Heavy Rifle Recipes
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.stainless_steel'))
		.inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('stock.plastic'))
		.inputs(ore('plateStainlessSteel') * 16)
		.inputs(metaitem('barrel.hv') * 4)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(10)
		.outputs(item('mwc:bren_mkii'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.tungsten_steel'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTungstenSteel') * 16)
		.inputs(metaitem('barrel.iv') * 4)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(10)
		.outputs(item('mwc:m60e4'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('handguard.tungsten_steel'))
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTungstenSteel') * 16)
		.inputs(metaitem('barrel.iv') * 4)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(11)
		.outputs(item('mwc:m134'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
		// Launchers
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('rear_grip.wood'))
		.inputs(metaitem('stock.wood'))
		.inputs(ore('plateSteel') * 4)
		.inputs(metaitem('barrel.mv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(15)
		.outputs(item('mwc:m79'))
		.duration(40)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('rear_grip.plastic'))
		.inputs(metaitem('stock.plastic'))
		.inputs(ore('plateStainlessSteel') * 4)
		.inputs(metaitem('barrel.hv') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(15)
		.outputs(item('mwc:gl06'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.wood'))
		.inputs(ore('plateTitanium') * 4)
		.inputs(metaitem('barrel.ev') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(15)
		.outputs(item('mwc:rpg7'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTungstenSteel') * 4)
		.inputs(metaitem('barrel.iv') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(15)
		.outputs(item('mwc:m32_mgl'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(metaitem('rear_grip.advanced_plastic'))
		.inputs(metaitem('stock.advanced_plastic'))
		.inputs(ore('plateTungstenSteel') * 4)
		.inputs(metaitem('barrel.iv') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 288)
		.circuitMeta(16)
		.outputs(item('mwc:m202'))
		.duration(40)
		.EUt(7680)
		.buildAndRegister();
		
		// Attachments
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('barrel.hv'))
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(5)
		.outputs(item('mwc:silencer9mm'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('handguard.stainless_steel'))
		.circuitMeta(5)
		.outputs(item('mwc:mk18handguard'))
		.duration(20)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('stickStainlessSteel')* 3)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:junogrip'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('stickTitanium') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:bipod'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('lensGlass'))
		.inputs(ore('ringSteel'))
		.inputs(ore('plateSteel'))
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:reflex'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('barrel.mv'))
		.inputs(ore('lensGlass') * 2)
		.fluidInputs(fluid('plastic') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:specter'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('lensGlass'))
		.inputs(ore('ringTitanium'))
		.inputs(ore('plateTitanium'))
		.fluidInputs(fluid('polytetrafluoroethylene') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:holographicalt'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('barrel.ev'))
		.inputs(ore('lensGlass') * 2)
		.fluidInputs(fluid('polytetrafluoroethylene') * 576)
		.circuitMeta(5)
		.outputs(item('mwc:leupoldrailscope'))
		.duration(40)
		.EUt(1920)
		.buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('lensGlass') * 2)
		.inputs(ore('lensEmerald'))
		.inputs(ore('plateSteel') * 2)
		.fluidInputs(fluid('plastic') * 288)
		.circuitMeta(5)
		.outputs(item('mwc:laser'))
		.duration(40)
		.EUt(480)
		.buildAndRegister();
		
		// Armor
		
mods.gregtech.weapons_factory.recipeBuilder()
        .fluidInputs(fluid('plastic') * 432)
		.inputs(metaitem('crop.cotton') * 6)
		.inputs(metaitem('foilPolyvinylChloride') * 6)
		.circuitMeta(1)
        .outputs(item('mwc:spec_ops_helmet'))
        .duration(80)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
        .fluidInputs(fluid('plastic') * 576)
		.inputs(metaitem('crop.cotton') * 8)
		.inputs(metaitem('foilPolyvinylChloride') * 8)
		.circuitMeta(2)
        .outputs(item('mwc:spec_ops_chest'))
        .duration(80)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
        .fluidInputs(fluid('plastic') * 432)
		.inputs(metaitem('crop.cotton') * 6)
		.inputs(metaitem('foilPolyvinylChloride') * 6)
		.circuitMeta(3)
        .outputs(item('mwc:spec_ops_boots'))
        .duration(80)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 432)
		.inputs(metaitem('plateKevlar') * 6)
		.inputs(metaitem('foilKevlar') * 6)
		.circuitMeta(1)
        .outputs(item('mwc:juggernaut_helmet'))
        .duration(80)
        .EUt(1920)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 576)
		.inputs(metaitem('plateKevlar') * 8)
		.inputs(metaitem('foilKevlar') * 8)
		.circuitMeta(2)
        .outputs(item('mwc:juggernaut_chest'))
        .duration(80)
        .EUt(1920)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
        .fluidInputs(fluid('polytetrafluoroethylene') * 432)
		.inputs(metaitem('plateKevlar') * 6)
		.inputs(metaitem('foilKevlar') * 6)
		.circuitMeta(3)
        .outputs(item('mwc:juggernaut_boots'))
        .duration(80)
        .EUt(1920)
        .buildAndRegister();
		
		// Tactical Vests
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('platePlastic') * 6)
		.inputs(ore('plateSteel') * 6)
		.inputs(metaitem('crop.cotton') * 6)
		.circuitMeta(3)
        .outputs(item('mwc:m43a_chest_harness'))
        .duration(80)
        .EUt(120)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('platePolycaprolactam') * 6)
		.inputs(metaitem('crop.cotton') * 6)
		.circuitMeta(3)
        .outputs(item('mwc:molle_black'))
        .duration(80)
        .EUt(480)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateUltraHighMolecularWeightPolyethylene') * 6)
		.inputs(metaitem('crop.cotton') * 6)
		.circuitMeta(3)
        .outputs(item('mwc:swat_vest'))
        .duration(80)
        .EUt(1920)
        .buildAndRegister();
		
mods.gregtech.weapons_factory.recipeBuilder()
		.inputs(ore('plateKevlar') * 6)
		.inputs(metaitem('crop.cotton') * 6)
		.circuitMeta(3)
        .outputs(item('mwc:usmc_vest_black'))
        .duration(80)
        .EUt(7680)
        .buildAndRegister();
		
		// Grenades
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateSteel') * 2)
		.inputs(ore('ringSteel'))
		.inputs(ore('boltSteel'))
		.notConsumable(metaitem('shape.mold.ball'))
		.inputs(metaitem('dustTnt') * 7)
		.outputs(item('mwc:m67frag'))
		.circuitMeta(1)
		.duration(20)
		.EUt(120)
		.buildAndRegister();
		
mods.gregtech.forming_press.recipeBuilder()
		.inputs(ore('plateTitanium') * 2)
		.notConsumable(metaitem('shape.mold.ball'))
		.inputs(metaitem('dustTnt') * 21)
		.outputs(item('mwc:impactgrenade'))
		.circuitMeta(1)
		.duration(20)
		.EUt(1920)
		.buildAndRegister();