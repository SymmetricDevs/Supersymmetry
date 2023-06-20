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

println("Running GregTech.groovy...")

//REMOVALS

// Carbon Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustCoal')], null)
// Small Pile of Rare Earth * 1
mods.gregtech.extractor.removeByInput(64, [metaitem('dustMonazite')], null)
// Graphene Dust * 1
mods.gregtech.mixer.removeByInput(480, [metaitem('dustGraphite'), metaitem('dustSilicon'), metaitem('dustCarbon') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Wrought Iron Ingot * 2
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustIlmenite') * 10, metaitem('dustCarbon') * 4], null)

def name_removals = [
        'gregtech:cover_fluid_voiding',
        'gregtech:cover_item_voiding',
        'gregtech:fluid_filter_lapis',
        'gregtech:fluid_filter_sodalite',
        'gregtech:fluid_filter_lazurite',
        'gregtech:comparator_certus',
        'gregtech:gregtech.machine.world_accelerator.lv',
        'gregtech:gregtech.machine.world_accelerator.mv',
        'gregtech:gregtech.machine.world_accelerator.hv',
        'gregtech:gregtech.machine.world_accelerator.ev',
        'gregtech:gregtech.machine.world_accelerator.iv',
        'gregtech:gregtech.machine.world_accelerator.luv',
        'gregtech:gregtech.machine.world_accelerator.zpm',
        'gregtech:gregtech.machine.world_accelerator.uv'
]

for (name in name_removals) {
    crafting.remove(name)
}

furnace.removeByInput(item('minecraft:iron_nugget'))

def ore_smelting_removals = [
        'lapis',
        'emerald',
        'almandine',
        'lazurite',
        'pyrope',
        'spessartine',
        'sodalite',
        'grossular',
        'garnet_red',
        'apatite',
        'blue_topaz',
        'certus_quartz',
        'garnet_yellow',
        'olivine',
        'monazite',
        'vanadinite',
        'celestine',
        'green_sapphire',
        'sperrylite',
        'sapphire',
        'ruby',
        'proustite',
        'topaz',
        'lorandite',
        'fluorite',
        'realgar',
        'amethyst',
        'opal',
        'perovskite',
        'cinnabar',
        'fluorapatite',
        'diamond'
]

for (name in ore_smelting_removals) {
    furnace.removeByInput(item('gregtech:ore_' + name + '_0', 0))
    furnace.removeByInput(item('gregtech:ore_' + name + '_0', 1))
    furnace.removeByInput(item('gregtech:ore_' + name + '_0', 2))
}

// Polycaprolactam Bar * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCaprolactam')], [fluid('nitrogen') * 1000])
// Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSilicon') * 32, metaitem('dustSmallGalliumArsenide')], null)
// Cupronickel Coil Block * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('wireGtDoubleCupronickel') * 8, metaitem('foilBronze') * 8], [fluid('tin_alloy') * 144])
// Kanthal Coil Block * 1
mods.gregtech.assembler.removeByInput(120, [metaitem('wireGtDoubleKanthal') * 8, metaitem('foilAluminium') * 8], [fluid('copper') * 144])
// Nichrome Coil Block * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('wireGtDoubleNichrome') * 8, metaitem('foilStainlessSteel') * 8], [fluid('aluminium') * 144])

//ADDITIONS

//CONSUMES IRON BUCKET ONLY BECAUSE THE OUTPUT IS IN AN IRON BUCKET
crafting.addShapeless('gregtech:salt_water_bucket', item('forge:bucketfilled').withNbt(["FluidName": "salt_water", "Amount": 1000]), [item('minecraft:water_bucket').noreturn(), metaitem('dustSalt'), metaitem('dustSalt')])

crafting.addShaped('gregtech:pbf_bronze', metaitem('primitive_blast_furnace.bronze'), [
    [ore('craftingToolHardHammer'), ore('stickBronze'), ore('screwBronze')],
    [ore('plateBronze'), item('gregtech:metal_casing:1'), ore('stickBronze')],
    [ore('craftingToolScrewdriver'), ore('stickBronze'), ore('screwBronze')]
])

crafting.addShaped('gregtech:steam_macerator', metaitem('steam_macerator_bronze'), [
    [metaitem('toolHeadBuzzSawSteel'), metaitem('pipeSmallFluidBronze'), metaitem('toolHeadBuzzSawSteel')],
    [metaitem('pipeSmallFluidBronze'), item('gregtech:steam_casing'), metaitem('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), metaitem('pipeSmallFluidBronze'), metaitem('steam.piston')]
])

crafting.addShaped('gregtech:co_bronze', metaitem('coke_oven'), [
    [item('gregtech:metal_casing:8'), ore('plateBronze'), item('gregtech:metal_casing:8')],
    [ore('plateBronze'), ore('craftingToolWrench'), ore('plateBronze')],
    [item('gregtech:metal_casing:8'), ore('plateBronze'), item('gregtech:metal_casing:8')]
])

crafting.addShaped('gregtech:drum_bronze', metaitem('drum.wood'), [
    [ore('craftingToolSoftHammer'), metaitem('rubber_drop'), ore('craftingToolSaw')],
    [ore('plankWood'), ore('stickLongBronze'), ore('plankWood')],
    [ore('plankWood'), ore('stickLongBronze'), ore('plankWood')]
])

crafting.addShaped("pig_iron_tiny_pile_manual", metaitem('dustTinyPigIron'), [
        [ore('craftingToolHardHammer'), null],
        [null, metaitem('nuggetPigIron')]
]);

crafting.addShaped("gregtech:steam_piston", metaitem('steam.piston'), [
    [ore('plateBronze'), ore('plateBronze'), ore('plateBronze')],
    [ore('pipeTinyFluidBronze'), ore('stickBronze'), ore('stickBronze')],
    [ore('pipeTinyFluidBronze'), ore('craftingToolHardHammer'), ore('gearSmallBronze')]
])

crafting.addShaped("gregtech:steam_motor", metaitem('steam.motor'), [
    [ore('plateBronze'), ore('stickBronze'), ore('plateBronze')],
    [metaitem('gearSmallBronze'), ore('stickBronze'), metaitem('gearSmallBronze')],
    [metaitem('steam.piston'), ore('stickBronze'), metaitem('steam.piston')]
]);

crafting.addShaped("gregtech:steam_pump", metaitem('pump.steam'), [
    [ore('screwBronze'), ore('rotorBronze'), ore('ringIron')],
    [ore('toolScrewdriver'), ore('pipeTinyFluidBronze'), ore('toolWrench')],
    [ore('ringIron'), metaitem('steam.motor'), ore('pipeTinyFluidBronze')]
])


crafting.replaceShaped("gregtech:steam_extractor_bronze", metaitem('steam_extractor_bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), item('gregtech:steam_casing'), ore('blockGlass')],
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

crafting.replaceShaped("gregtech:steam_vacuum_chamber", metaitem('vacuum_chamber.bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('pump.steam'), item('gregtech:steam_casing'), ore('blockGlass')],
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

crafting.replaceShaped('gregtech:steam_macerator_bronze', metaitem('steam_macerator_bronze'), [
    [ore('gemDiamond'), metaitem('pipeSmallFluidBronze'), ore('gemDiamond')],
    [metaitem('pipeSmallFluidBronze'), item('gregtech:steam_casing'), metaitem('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), metaitem('pipeSmallFluidBronze'), metaitem('steam.piston')]
])

crafting.replaceShaped("gregtech:steam_compressor_bronze", metaitem('steam_compressor_bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), item('gregtech:steam_casing'), metaitem('steam.piston')],
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

crafting.replaceShaped("gregtech:steam_hammer_bronze", metaitem('steam_hammer_bronze'), [
    [ore('pipeSmallFluidBronze'), metaitem('steam.piston'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), ore('craftingAnvil'), ore('pipeSmallFluidBronze')]
])

crafting.replaceShaped("gregtech:steam_rock_breaker_bronze", metaitem('steam_rock_breaker_bronze'), [
    [metaitem('steam.piston'), ore('pipeSmallFluidBronze'), metaitem('steam.piston')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')],
    [ore('gemDiamond'), ore('pipeSmallFluidBronze'), ore('gemDiamond')]
])

crafting.replaceShaped("gregtech:gregtech.machine.lathe.lv", metaitem('gregtech:lathe.lv'), [
    [metaitem('cableGtSingleTin'),  ore('circuitLv'), metaitem('cableGtSingleTin')],
    [metaitem('electric.motor.lv'), metaitem('gregtech:hull.lv'), metaitem('toolHeadDrillSteel')],
    [ore('circuitLv'), metaitem('cableGtSingleTin'), metaitem('electric.piston.lv')]
])

crafting.replaceShaped("gregtech:gregtech.machine.macerator.lv", metaitem('gregtech:macerator.lv'), [
    [metaitem('electric.piston.lv'), metaitem('electric.motor.lv') , metaitem('toolHeadBuzzSawSteel')],
    [metaitem('cableGtSingleTin'), metaitem('cableGtSingleTin'), metaitem('gregtech:hull.lv')],
    [ore('circuitLv'), ore('circuitLv'), metaitem('cableGtSingleTin')]
])

crafting.replaceShaped("gregtech:gregtech.machine.cutter.mv", metaitem('gregtech:cutter.mv'), [
    [metaitem('cableGtSingleCopper'), ore('circuitMv'), item('minecraft:glass')],
	[metaitem('conveyor.module.mv'), metaitem('gregtech:hull.mv'), metaitem('toolHeadBuzzSawAluminium')],
	[ore('circuitMv'), metaitem('cableGtSingleCopper'), metaitem('electric.motor.mv')]
])

crafting.replaceShaped("gregtech:gregtech.machine.cutter.hv", metaitem('gregtech:cutter.hv'), [
    [metaitem('cableGtSingleGold'), ore('circuitHv'), item('gregtech:transparent_casing')],
	[metaitem('conveyor.module.hv'), metaitem('gregtech:hull.hv'), metaitem('toolHeadBuzzSawVanadiumSteel')],
	[ore('circuitHv'), metaitem('cableGtSingleGold'), metaitem('electric.motor.hv')]
])

// crafting.addShaped("rubber_rod_manual", metaitem('stickRubber'), [
//     [ore('craftingToolFile'), null, null],
//     [null, ore('ingotRubber'), null],
//     [null, null, null]
// ]);

//Manual chad for early paper

// ModHandler.addShapedRecipe("manual_chad", metaitem('dustPaper'), 
//     new UnificationEntry(OrePrefix.dust, Materials.Wood), 
//     new UnificationEntry(OrePrefix.dust, Materials.Wood),
//     item('minecraft:water_bucket')
// );

// mods.gregtech.alloy_smelter.recipeBuilder()
//         .inputs(ore('dustRawRubber') * 6)
//         .inputs(ore('dustSulfur'))
//         .outputs(metaitem('dustRubber'))
//         .duration(400)
//         .EUt(8)
//         .buildAndRegister();

crafting.addShaped('gregtech:compressed_coke_clay', metaitem('compressed.coke_clay') * 8, [
    [ore('ingotClay'), ore('ingotClay'), ore('ingotClay')],
    [ore('sand'), metaitem('wooden_form.brick'), ore('sand')],
    [ore('sand'), ore('sand'), ore('sand')]
])

furnace.add(metaitem('dustLimestone'), metaitem('dustQuicklime'))

//TechGuns carbon plate removal
// Carbon Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('carbon') * 144])

//Remove old rubber recipes
// Rubber Bar * 1
mods.gregtech.alloy_smelter.removeByInput(7, [metaitem('dustSulfur'), metaitem('dustRawRubber') * 3], null)

//Remove Magic

// Item Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('screwSteel') * 2, metaitem('cover.item.detector'), metaitem('pipeNormalItemBrass'), item('minecraft:ender_pearl')], null)
// Fluid Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('screwSteel') * 2, metaitem('cover.fluid.detector'), metaitem('pipeNormalFluidBronze'), item('minecraft:ender_pearl')], null)
// Infinite Water Cover * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('electric.pump.hv') * 2, item('minecraft:cauldron'), metaitem('circuit.assembly')], null)
// Advanced Fluid Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cover.fluid.voiding'), metaitem('circuit.processor')], null)
// Advanced Item Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cover.item.voiding'), metaitem('circuit.processor')], null)
// Ender Fluid Link Cover * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('plateEnderPearl') * 9, metaitem('plateDoubleStainlessSteel'), metaitem('sensor.hv'), metaitem('emitter.hv'), metaitem('electric.pump.hv')], [fluid('plastic') * 288])

//Slaked Lime

crafting.addShapeless('convert_old_slaked_lime', metaitem('dustCalciumHydroxide'), [metaitem('slaked_lime')])

mods.gregtech.chemical_bath.recipeBuilder()
        .inputs(metaitem('dustQuicklime'))
        .fluidInputs(fluid('water') * 500)
        .outputs(metaitem('dustCalciumHydroxide'))
        .duration(20)
        .EUt(30)
        .buildAndRegister();

//Lava

mods.gregtech.fluid_solidifier.recipeBuilder()
        .fluidInputs(fluid('chilled_lava') * 1000)
        .notConsumable(metaitem('shape.mold.block'))
        .outputs(item('minecraft:obsidian') * 1)
        .duration(210)
        .EUt(16)
        .buildAndRegister();

//Coils

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('lava') * 1000)
        .outputs(metaitem('mineral_wool'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('chilled_lava') * 1000)
        .outputs(metaitem('mineral_wool'))
        .duration(80)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('tin_alloy') * 144)
        .inputs(metaitem('wireGtDoubleCupronickel') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(metaitem('foilBronze') * 8)
        .outputs(item('gregtech:wire_coil'))
        .duration(200)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('copper') * 144)
        .inputs(metaitem('wireGtDoubleKanthal') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(metaitem('foilAluminium') * 8)
        .outputs(item('gregtech:wire_coil', 1))
        .duration(300)
        .EUt(120)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('aluminium') * 144)
        .inputs(metaitem('wireGtDoubleNichrome') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(metaitem('foilStainlessSteel') * 8)
        .outputs(item('gregtech:wire_coil', 2))
        .duration(400)
        .EUt(480)
        .buildAndRegister();

//Cleanroom Filter Casings

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('plateSteel') * 4)
        .inputs(metaitem('foilAluminium') * 8)
        .inputs(metaitem('foilPolypropylene') * 16)
        .outputs(metaitem('hepa_filter'))
        .duration(80)
        .EUt(120)
        .buildAndRegister();

crafting.replaceShaped('gregtech:filter_casing', item('gregtech:cleanroom_casing', 1) * 2, [
        [item('minecraft:iron_bars'), item('minecraft:iron_bars'), item('minecraft:iron_bars')],
        [metaitem('electric.motor.mv'), metaitem('rotorSteel'), metaitem('electric.pump.mv')],
        [metaitem('frameSteel'), metaitem('hepa_filter'), metaitem('frameSteel')]
])

//Beds

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('stickLongWood') * 4)
        .inputs(metaitem('plateWood') * 8)
        .inputs(metaitem('plateMemoryFoam') * 16)
        .inputs(metaitem('wireFineRayon') * 64)
        .inputs(metaitem('springSmallSteel') * 8)
        .outputs(item('minecraft:bed'))
        .duration(400)
        .EUt(960)
        .buildAndRegister();

//Lights

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('cableGtSingleTin') * 2)
        .inputs(metaitem('graphite_electrode'))
        .inputs(metaitem('component.glass.tube') * 8)
        .outputs(metaitem('carbon_arc_lamp') * 8)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//Ore Recipes

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block'))
        .outputs(metaitem('crushedBauxite') * 4)
        .chancedOutput(metaitem('dustStone'), 6700, 800)
        .duration(400)
        .EUt(2)
        .buildAndRegister();

//Mud

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('mud') * 1000)
        .chancedOutput(item('minecraft:clay'), 2500, 250)
        .chancedOutput(item('minecraft:sand'), 2500, 250)
        .chancedOutput(item('minecraft:gravel'), 2500, 250)
        .chancedOutput(metaitem('dustLimestone'), 2500, 250)
        .duration(20)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.fluid_solidifier.recipeBuilder()
        .fluidInputs(fluid('mud') * 250)
        .notConsumable(metaitem('shape.mold.ball'))
        .outputs(item('biomesoplenty:mudball') * 1)
        .duration(40)
        .EUt(4)
        .buildAndRegister();

crafting.replaceShaped('susy:home_block', item('susy:home_block'), [
        [null, ore('craftingToolFile'), null],
        [null, ore('stoneSmooth'), null],
        [null, null, null]
])

crafting.addShapeless('susy:home_block_1', item('susy:home_block', 1), [item('susy:home_block')])
crafting.addShapeless('susy:home_block_2', item('susy:home_block', 2), [item('susy:home_block', 1)])
crafting.addShapeless('susy:home_block_3', item('susy:home_block', 3), [item('susy:home_block', 2)])
crafting.addShapeless('susy:home_block_4', item('susy:home_block',), [item('susy:home_block', 3)])

// Acetone * 200
mods.gregtech.fluid_heater.removeByInput(30, [metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('dissolved_calcium_acetate') * 200])

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustPegmatiteTailings') * 3)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(item('minecraft:emerald'), 1000, 250)
        .chancedOutput(metaitem('gemTourmaline'), 1000, 250)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustGraniteTailings') * 3)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustLimestoneTailings') * 3)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustUltramaficTailings') * 3)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustMagnesia'), 2000, 500)
        .chancedOutput(metaitem('dustMagnetite'), 1000, 500)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustKimberlite'))
        .chancedOutput(metaitem('dustUltramaficTailings'), 7500, 500)
        .chancedOutput(item('minecraft:diamond'), 1000, 500)
        .chancedOutput(metaitem('gemPyrope'), 500, 250)
        .chancedOutput(metaitem('gemAlmandine'), 500, 250)
        .chancedOutput(item('minecraft:dye', 4), 500, 250)
        .chancedOutput(metaitem('dustChromite'), 500, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustCorundum'))
        .chancedOutput(metaitem('dustUltramaficTailings'), 7500, 500)
        .chancedOutput(metaitem('gemRuby'), 1000, 250)
        .chancedOutput(metaitem('gemSapphire'), 1000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 2))
        .outputs(metaitem('dustNonMarineEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 4))
        .outputs(metaitem('dustSulfateEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 5))
        .outputs(metaitem('dustCarbonateEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 3))
        .outputs(metaitem('dustHalideEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 12))
        .outputs(metaitem('dustPhosphorite') * 8)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustNonMarineEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustBorax'), 7000, 250)
        .chancedOutput(metaitem('dustTrona'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustSulfateEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustGypsum'), 5000, 250)
        .chancedOutput(metaitem('dustKieserite'), 5000, 250)
        .chancedOutput(metaitem('dustLangbeinite'), 5000, 250)
        .chancedOutput(metaitem('dustPolyhalite'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustCarbonateEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustDolomite'), 5000, 250)
        .chancedOutput(metaitem('dustCalcite'), 5000, 250)
        .chancedOutput(metaitem('dustMagnesite'), 5000, 250)
        .chancedOutput(metaitem('dustTrona'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(metaitem('dustHalideEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustCarnallite'), 7000, 250)
        .chancedOutput(metaitem('dustKainite'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.centrifuge.recipeBuilder()
        .inputs(metaitem('dustLimestone'))
        .outputs(metaitem('dustCalcite'))
        .duration(40)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.packer.recipeBuilder()
        .inputs(item('minecraft:sand'))
        .outputs(metaitem('sand.dust') * 4)
        .duration(20)
        .EUt(7)
        .buildAndRegister();

crafting.addShaped('gregtech:fluid_filter_brass', metaitem('fluid_filter'), [
        [ore('foilZinc'), ore('foilZinc'), ore('foilZinc')],
        [ore('foilZinc'), ore('plateBrass'), ore('foilZinc')],
        [ore('foilZinc'), ore('foilZinc'), ore('foilZinc')]
])

crafting.addShaped('gregtech:brass_drum', metaitem('drum.brass'), [
        [null, ore('craftingToolHardHammer'), null],
        [metaitem('plateBrass'), metaitem('stickLongBrass'), metaitem('plateBrass')],
        [metaitem('plateBrass'), metaitem('stickLongBrass'), metaitem('plateBrass')]
])

// Electrolytic Cell
crafting.addShaped('gregtech:electrolytic_cell', metaitem('electrolytic_cell'), [
        [ore('plateSteel'), ore('circuitLv'), ore('plateSteel')],
        [ore('wireGtQuadrupleTin'), metaitem('hull.lv'), ore('wireGtQuadrupleTin')],
        [ore('circuitLv'), ore('cableGtSingleTin'), ore('circuitLv')]
])

// Prospector
crafting.addShaped('gregtech:prospector_lead_acid', metaitem('prospector.lv'), [
        [metaitem('emitter.lv'), ore('plateSteel'), metaitem('sensor.lv')],
        [ore('circuitLv'), ore('plateGlass'), ore('circuitLv')],
        [ore('plateSteel'), metaitem('battery.lead_acid'), ore('plateSteel')]
])

LATEX_COLLECTOR = recipemap('latex_collector')

LATEX_COLLECTOR.recipeBuilder()
        .notConsumable(fluid('water') * 10)
        .fluidOutputs(fluid('latex') * 100)
        .blockStates("latex_logs", MetaBlocks.RUBBER_LOG.getBlockState())
        .duration(20)
        .EUt(7)
        .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
        .notConsumable(fluid('distilled_water') * 10)
        .fluidOutputs(fluid('resin') * 100)
        .blockStates("extractable_logs_1", Blocks.LOG.getBlockState())
        .duration(20)
        .EUt(7)
        .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
        .notConsumable(fluid('lubricant') * 10)
        .fluidOutputs(fluid('resin') * 100)
        .blockStates("extractable_logs_2", Blocks.LOG2.getBlockState())
        .duration(20)
        .EUt(7)
        .buildAndRegister();

//TODO: ADD GRAVITY SEPARATOR STUFF
// Construction Foam * 8000
mods.gregtech.mixer.removeByInput(16, [metaitem('dustRawRubber')], [fluid('concrete') * 576])

MIXER.recipeBuilder()
        .inputs(metaitem('dustRubber'))
        .fluidInputs(fluid('concrete') * 576)
        .fluidOutputs(fluid('construction_foam') * 8000)
        .duration(20)
        .EUt(16)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustAnthracite'))
        .chancedOutput(metaitem('dustCarbon'), 9000, 0)
        .duration(80)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustCoal'))
        .chancedOutput(metaitem('dustCarbon'), 7500, 0)
        .duration(80)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustCharcoal'))
        .chancedOutput(metaitem('dustCarbon'), 6000, 0)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustCoke'))
        .outputs(metaitem('dustCarbon'))
        .duration(60)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustDiamond'))
        .outputs(metaitem('dustCarbon'))
        .duration(40)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustGraphite'))
        .outputs(metaitem('dustCarbon'))
        .duration(40)
        .EUt(30)
        .buildAndRegister();