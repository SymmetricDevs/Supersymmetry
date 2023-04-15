import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;


println("Running GregTech.groovy...")

def name_removals = [
    'gregtech:iron_magnetic_stick',
]

for (name in name_removals) {
    //crafting.remove(name)
}

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

crafting.replaceShaped("gregtech:steam_extractor_bronze", metaitem('steam_extractor_bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), item('gregtech:steam_casing'), ore('blockGlass')],
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

//TechGuns carbon plate removal
// Carbon Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('carbon') * 144])
