import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

println("Running GregTech.groovy...")

//REMOVALS

def name_removals = [
        'gregtech:iron_magnetic_stick',
]

for (name in name_removals) {
    //crafting.remove(name)
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

mods.gregtech.electric_blast_furnace.recipeBuilder()
        .inputs(ore('dustIron'))
        .outputs(item('minecraft:iron_ingot'))
        .blastFurnaceTemp(1800)
        .duration(60)
        .EUt(60)
        .buildAndRegister();

mods.gregtech.electric_blast_furnace.recipeBuilder()
        .inputs(ore('dustNickel'))
        .outputs(metaitem('ingotNickel'))
        .blastFurnaceTemp(1728)
        .duration(60)
        .EUt(60)
        .buildAndRegister();

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

//Coils

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('lava') * 1000)
        .outputs(metaitem('mineral_wool'))
        .duration(100)
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

crafting.addShapeless('susy:decompress_lignite_block', metaitem('gemLignite') * 9, [item('susy:resource_block', 3)])
crafting.addShapeless('susy:decompress_anthracite_block', metaitem('gemAnthracite') * 9, [item('susy:resource_block', 2)])

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block'))
        .outputs(metaitem('crushedBauxite') * 4)
        .chancedOutput(metaitem('dustStone'), 6700, 800)
        .duration(400)
        .EUt(2)
        .buildAndRegister();