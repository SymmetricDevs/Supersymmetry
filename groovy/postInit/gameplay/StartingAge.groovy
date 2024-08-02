import Globals.*
import appeng.api.AEApi;
import appeng.api.features.IGrinderRegistry;
import appeng.api.features.IGrinderRecipeBuilder;

final IGrinderRegistry reg = AEApi.instance().registries().grinder();

log.infoMC("Running StartingAge.groovy...")

def name_removals = [
        "notreepunching:tools/iron_saw",
        "notreepunching:tools/gold_saw",
        "notreepunching:tools/diamond_saw",
        "notreepunching:misc/clay_tool_clay_brick_2",
        "notreepunching:misc/clay_tool_clay_brick",
        "notreepunching:tools/iron_knife",
        "notreepunching:tools/gold_knife",
        "notreepunching:tools/diamond_knife",
        "biomesoplenty:mud_from_dirt"
]

for (item in name_removals) {
    crafting.remove(item);
}

crafting.addShapeless("fiber_from_cane", item('notreepunching:grass_fiber') * 2, [
        item('minecraft:reeds'),
        ore('toolknife')
])

crafting.addShapeless("fiber_from_wheat", item('notreepunching:grass_fiber') * 2, [
        item('minecraft:wheat'),
        ore('toolknife')
])

crafting.addShapeless("fiber_from_grass", item('notreepunching:grass_fiber'), [
        item('minecraft:tallgrass', 1),
        ore('toolknife')
])

crafting.addShapeless("fiber_from_leaves", item('notreepunching:grass_fiber'), [
        ore('treeLeaves'),
        ore('toolknife')
])

crafting.replaceShapeless("gregtech:clay_ball_to_dust", metaitem('dustClay'), [
        ore('craftingToolMortar'),
        ore('ingotClay')
])

crafting.addShapeless("gregtech:mud_block_to_ball", item('biomesoplenty:mudball') * 4, [
        item('biomesoplenty:mud')
])

crafting.addShapeless("gregtech:mud_from_dirt", item('biomesoplenty:mud'), [
        fluid('water') * 1000,
        ore('dirt')
])

//Magnetite Chunk Crafting
crafting.addShapeless("magnetite_chunk", metaitem('chunk.magnetite'), [ore('oreMagnetite'), ore('rock')]);
crafting.addShapeless("magnetite_chunk_1", metaitem('chunk.magnetite'), [ore('oreVanadiumMagnetite'), ore('rock')]);

crafting.replaceShaped("appliedenergistics2:misc/grindstone", item('appliedenergistics2:grindstone'),[
        [ore('stone'), null, ore('stone')],
        [metaitem('gearBronze'), ore('craftingToolFile'), metaitem('gearBronze')],
        [ore('cobblestone'), ore('cobblestone'), ore('cobblestone')]
])

def GrindstoneMap = [
        'gregtech:ore_acanthite_0': "crushedAcanthite",
        'gregtech:ore_anglesite_0': "crushedAnglesite",
        'gregtech:ore_sphalerite_0': "crushedSphalerite",
        'gregtech:ore_chlorapatite_0': "crushedChlorapatite",
        'gregtech:ore_fluorapatite_0': "crushedFluorapatite",
        'gregtech:ore_arsenopyrite_0': "crushedArsenopyrite",
        'gregtech:ore_pyrite_0': "crushedPyrite",
        'gregtech:ore_banded_iron_0': "crushedBandedIron",
        'gregtech:ore_magnetite_0': "crushedMagnetite",
        'gregtech:ore_bornite_0': "crushedBornite",
        'gregtech:ore_chalcopyrite_0': "crushedChalcopyrite",
        'susy:resource_block:2': "dustSalt",
        'susy:resource_block:3': "dustSalt",
        'susy:resource_block:4': "dustSalt",
        'susy:resource_block:5': "dustSalt",
        'gregtech:ore_cassiterite_0': "crushedCassiterite",
        'gregtech:ore_cerussite_0': "crushedCerussite",
        'gregtech:ore_cinnabar_0': "crushedCinnabar",
        'gregtech:ore_stibnite_0': "crushedStibnite",
        'gregtech:ore_coal_0': "crushedCoal",
        'gregtech:ore_fluorite_0': "crushedFluorite",
        'gregtech:ore_galena_0': "crushedGalena",
        'gregtech:ore_lapis_0': "crushedLapis",
        'gregtech:ore_lazurite_0': "crushedLazurite",
        'gregtech:ore_sodalite_0': "crushedSodalite",
        'gregtech:ore_lignite_0': "crushedLignite",
        'gregtech:ore_malachite_0': "crushedMalachite",
        'gregtech:ore_proustite_0': "crushedProustite",
        'gregtech:ore_pyrolusite_0': "crushedPyrolusite",
        'gregtech:ore_realgar_0': "crushedRealgar",
        'gregtech:ore_redstone_0': "crushedRedstone",
        'gregtech:ore_saltpeter_0': "crushedSaltpeter",
        'gregtech:ore_chalcocite_0': "crushedChalcocite",
        'gregtech:ore_enargite_0': "crushedEnargite",
        'gregtech:ore_tetrahedrite_0': "crushedTetrahedrite",
        'gregtech:ore_anthracite_0': "crushedAnthracite"
]

for (key in GrindstoneMap) {
    final IGrinderRecipeBuilder builder = reg.builder();

    builder.withInput(item(key.getKey()) * 2)
    builder.withOutput(metaitem(key.getValue()) * 3)
    builder.withTurns(5)

    reg.addRecipe(builder.build())
}

for (int i = 4; i < 8; i++) {
    crafting.addShaped("biomesoplenty:wood_cutting_0_" + i, item('biomesoplenty:planks_0', i - 4) * 6, [
            [null, ore('toolSaw'), null],
            [null, item('biomesoplenty:log_0', i), null],
            [null, null, null]
    ])

    mods.gregtech.cutter.recipeBuilder()
            .inputs(item('biomesoplenty:log_0', i))
            .outputs(item('biomesoplenty:planks_0', i - 4) * 6)
            .outputs(metaitem('dustWood') * 2)
            .duration(200)
            .EUt(7)
            .buildAndRegister();

    crafting.addShaped("biomesoplenty:wood_cutting_1_" + i, item('biomesoplenty:planks_0', i) * 6, [
            [null, ore('toolSaw'), null],
            [null, item('biomesoplenty:log_1', i), null],
            [null, null, null]
    ])

    mods.gregtech.cutter.recipeBuilder()
            .inputs(item('biomesoplenty:log_1', i))
            .outputs(item('biomesoplenty:planks_0', i) * 6)
            .outputs(metaitem('dustWood') * 2)
            .duration(200)
            .EUt(7)
            .buildAndRegister();

    crafting.addShaped("biomesoplenty:wood_cutting_2_" + i, item('biomesoplenty:planks_0', i + 4) * 6, [
            [null, ore('toolSaw'), null],
            [null, item('biomesoplenty:log_2', i), null],
            [null, null, null]
    ])

    mods.gregtech.cutter.recipeBuilder()
            .inputs(item('biomesoplenty:log_2', i))
            .outputs(item('biomesoplenty:planks_0', i + 4) * 6)
            .outputs(metaitem('dustWood') * 2)
            .duration(200)
            .EUt(7)
            .buildAndRegister();

    crafting.addShaped("biomesoplenty:wood_cutting_3_" + i, item('biomesoplenty:planks_0', i + 8) * 6, [
            [null, ore('toolSaw'), null],
            [null, item('biomesoplenty:log_3', i), null],
            [null, null, null]
    ])

    mods.gregtech.cutter.recipeBuilder()
            .inputs(item('biomesoplenty:log_3', i))
            .outputs(item('biomesoplenty:planks_0', i + 8) * 6)
            .outputs(metaitem('dustWood') * 2)
            .duration(200)
            .EUt(7)
            .buildAndRegister();
}


crafting.addShapeless("gtfo:wood_crafting_0", item('gregtechfoodoption:gtfo_planks_0') * 4, [item('gregtechfoodoption:gtfo_log_0')])
crafting.addShapeless("gtfo:wood_crafting_1", item('gregtechfoodoption:gtfo_planks_0:1') * 4, [item('gregtechfoodoption:gtfo_log_0:4')])
crafting.addShapeless("gtfo:wood_crafting_2", item('gregtechfoodoption:gtfo_planks_0:2') * 4, [item('gregtechfoodoption:gtfo_log_0:8')])
crafting.addShapeless("gtfo:wood_crafting_3", item('gregtechfoodoption:gtfo_planks_0:3') * 4, [item('gregtechfoodoption:gtfo_log_0:12')])
crafting.addShapeless("gtfo:wood_crafting_4", item('gregtechfoodoption:gtfo_planks_0:4') * 4, [item('gregtechfoodoption:gtfo_log_1')])
crafting.addShapeless("gtfo:wood_crafting_5", item('gregtechfoodoption:gtfo_planks_0:5') * 4, [item('gregtechfoodoption:gtfo_log_1:4')])
crafting.addShapeless("gtfo:wood_crafting_6", item('gregtechfoodoption:gtfo_planks_0:6') * 4, [item('gregtechfoodoption:gtfo_log_1:8')])
crafting.addShapeless("gtfo:wood_crafting_7", item('gregtechfoodoption:gtfo_planks_0:7') * 4, [item('gregtechfoodoption:gtfo_log_1:12')])
crafting.addShapeless("gtfo:wood_crafting_8", item('gregtechfoodoption:gtfo_planks_0:8') * 4, [item('gregtechfoodoption:gtfo_log_2')])