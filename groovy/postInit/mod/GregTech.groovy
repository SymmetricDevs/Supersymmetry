import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

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

crafting.addShaped("rubber_rod_manual", metaitem('stickRubber'), [
        [ore('craftingToolFile'), null, null],
        [null, ore('ingotRubber'), null],
        [null, null, null]
]);

//Manual chad for early paper

crafting.addShapeless("manual_chad", metaitem('dustPaper'), [
        ore('dustWood'),
        ore('dustWood'),
        fluid('water')
]);

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
