import crafttweaker.api.item.IItemStack;

def name_removals = [
        "gregtech:iron_magnetic_stick",
        "appliedenergistics2:misc/grindstone_woodengear",
        "machinemod:woodengear",
        "gtadditions:clay_brick",
        "gtadditions:eight_clay_brick",
        "notreepunching:misc/clay_tool_clay_brick",
        "notreepunching:misc/clay_tool_clay_brick_2",
        "gregtech:bronze_primitive_blast_furnace",
        "gregtech:coke_oven",
        "appliedenergistics2:misc/grindstone",
        "notreepunching:tools/iron_saw",
        "notreepunching:tools/gold_saw",
        "notreepunching:tools/diamond_saw",
        "minecraft:oak_planks",
        "minecraft:spruce_planks",
        "minecraft:birch_planks",
        "minecraft:jungle_planks",
        "minecraft:acacia_planks",
        "minecraft:dark_oak_planks",
        "gregtech:oak_planks_saw",
        "gregtech:spruce_planks_saw",
        "gregtech:birch_planks_saw",
        "gregtech:jungle_planks_saw",
        "gregtech:acacia_planks_saw",
        "gregtech:dark_oak_planks_saw",
        "biomesoplenty:sacred_oak_planks",
        "biomesoplenty:cherry_planks",
        "biomesoplenty:umbran_planks",
        "biomesoplenty:fir_planks",
        "biomesoplenty:ethereal_planks",
        "biomesoplenty:magic_planks",
        "biomesoplenty:mangrove_planks",
        "biomesoplenty:palm_planks",
        "biomesoplenty:redwood_planks",
        "biomesoplenty:willow_planks",
        "biomesoplenty:pine_planks",
        "biomesoplenty:hellbark_planks",
        "biomesoplenty:jacaranda_planks",
        "biomesoplenty:mahogany_planks",
        "biomesoplenty:ebony_planks",
        "biomesoplenty:eucalyptus_planks",
        "gregtech:sacred_oak_planks_saw",
        "gregtech:cherry_planks_saw",
        "gregtech:umbran_planks_saw",
        "gregtech:fir_planks_saw",
        "gregtech:ethereal_planks_saw",
        "gregtech:magic_planks_saw",
        "gregtech:mangrove_planks_saw",
        "gregtech:palm_planks_saw",
        "gregtech:redwood_planks_saw",
        "gregtech:willow_planks_saw",
        "gregtech:pine_planks_saw",
        "gregtech:hellbark_planks_saw",
        "gregtech:jacaranda_planks_saw",
        "gregtech:mahogany_planks_saw",
        "gregtech:ebony_planks_saw",
        "gregtech:eucalyptus_planks_saw",
        "minecraft:stick",
        "notreepunching:misc/saw_plank_sticks",
        "notreepunching:misc/saw_log_sticks",
        "notreepunching:saw_planks_1",
        "notreepunching:saw_planks_2",
        "notreepunching:saw_planks_3",
        "notreepunching:saw_planks_4",
        "notreepunching:saw_planks_5",
        "notreepunching:saw_planks_6",
        "notreepunching:saw_planks_7",
        "notreepunching:saw_planks_8",
        "notreepunching:saw_planks_9",
        "notreepunching:saw_planks_10",
        "notreepunching:saw_planks_11",
        "notreepunching:saw_planks_12",
        "notreepunching:saw_planks_13",
        "notreepunching:saw_planks_14",
        "notreepunching:saw_planks_15",
        "notreepunching:saw_planks_16",
        "notreepunching:saw_planks_17",
        "notreepunching:saw_planks_18",
        "notreepunching:saw_planks_19",
        "notreepunching:saw_planks_20",
        "notreepunching:saw_planks_21",
        "notreepunching:saw_planks_22",
        "notreepunching:saw_planks_23",
        "notreepunching:saw_planks_24",
        "cd4017be_lib:dimstack/dim_pipe"
]

for (item in name_removals) {
    crafting.remove(item);
}

//Vanilla Brick Crafting
crafting.addShaped("brick_x1", item('notreepunching:clay_brick')*1, [
        [ore('ingotClay'), metaitem('wooden_form.brick'), null],
]);
crafting.addShaped("brick_x8", item('notreepunching:clay_brick')*8, [
        [ore('ingotClay'), ore('ingotClay'), ore('ingotClay')],
        [ore('ingotClay'), metaitem('wooden_form.brick'), ore('ingotClay')],
        [ore('ingotClay'), ore('ingotClay'), ore('ingotClay')],
]);

//Wooden Gear Crafting
crafting.addShaped("woodgear", metaitem('gearWood'), [
        [ore('stickWood'), ore('plankWood'), ore('stickWood')],
        [ore('plankWood'), ore('gregScrewDrivers'), ore('plankWood')],
        [ore('stickWood'), ore('plankWood'), ore('stickWood')]
]);

//AE2 Grindstone Crafting
crafting.addShaped("ae2_grindstone", item('appliedenergistics2:grindstone'), [
        [ore('stone'), ore('gearWood'), ore('stone')],
        [ore('gemFlint'), ore('stone'), ore('gemFlint')],
        [ore('cobblestone'), ore('gemFlint'), ore('cobblestone')]
]);

//Magnetite Chunk Crafting
crafting.addShapeless("magnetite_chunk", metaitem('chunk.magnetite'), [ore('oreMagnetite')]);
crafting.addShapeless("magnetite_chunk_1", metaitem('magnetite_chunk'), [ore('oreVanadiumMagnetite')]);

//Electrolyte Paper Crafting
crafting.addShaped("electrolyte_paper", metaitem('electrolyte_paper'), [
        [null, ore('paperEmpty'), null],
        [null, metaitem('food.lime'), null],
        [null, ore('gregMortars'), null]
]);
crafting.addShaped("electrolyte_paper_1", metaitem('electrolyte_paper'), [
        [null, ore('paperEmpty'), null],
        [null, metaitem('food.lemon'), null],
        [null, ore('gregMortars'), null]
]);

//Primitive Blast Furnace
crafting.addShaped("ga_pbf", item('gregtech:machine:1000'), [
        [ore('gregHardHammers'), ore('stickBronze'), ore('screwBronze')],
        [ore('plateBronze'), item('gregtech:metal_casing:1'), ore('stickBronze')],
        [ore('gregScrewDrivers'), ore('stickBronze'), ore('screwBronze')]
]);

//Coke Oven
crafting.addShaped("gt_co", item('gregtech:machine:1017'), [
        [item('gregtech:metal_casing:8'), ore('plateBronze'), item('gregtech:metal_casing:8')],
        [ore('plateBronze'), ore('gregWrenches'), ore('plateBronze')],
        [item('gregtech:metal_casing:8'), ore('plateBronze'), item('gregtech:metal_casing:8')]
]);

//Voltaic Pile Crafting
crafting.addShapeless("voltaic_pile", metaitem('voltaic_pile'), [ore('plateCopper'), ore('plateSilver'), metaitem('electrolyte_paper')]);
crafting.addShapeless("voltaic_pile_1", metaitem('voltaic_pile'), [ore('plateCopper'), ore('plateZinc'), metaitem('electrolyte_paper')]);

//Magnetic Rod Crafting
crafting.addShapeless("magnetic_iron_stick", metaitem('stickIronMagnetic'), [metaitem('hot_iron_rod'), metaitem('voltaic_pile'), ore('wireFineCopper')]);
crafting.addShapeless("magnetic_iron_stick_1", metaitem('stickIronMagnetic'), [metaitem('hot_iron_rod'), metaitem('magnetite_chunk')]);
crafting.addShapeless("magnetic_iron_stick_2", metaitem('stickIronMagnetic') * 2, [metaitem('hot_iron_rod'), ore('stickIronMagnetic')]);

crafting.addShaped("wood_stick", item('minecraft:stick')*2, [
        [ore('craftingToolSaw'), ore('plankWood'), null],
]);

crafting.addShaped("interdimensional_pipe", item('dimstack:dim_pipe'), [
        [ore('frameGtSteel'), ore('gemNetherQuartz'), ore('frameGtSteel')],
        [ore('frameGtSteel'), metaitem('crate.wood'), ore('frameGtSteel')],
        [ore('frameGtSteel'), ore('gemNetherQuartz'), ore('frameGtSteel')]
]);

def fuels = [
        ore('coal')
];

//----------Recipes using GT machines----------

for (fuel in fuels) {

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustIron') * 1)
            .outputs(item('minecraft:iron_ingot'))
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustMagnetite') * 7)
            .outputs(item('minecraft:iron_ingot') * 3)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustVanadiumMagnetite') * 8)
            .outputs(item('minecraft:iron_ingot') * 3)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustHematite') * 5)
            .outputs(item('minecraft:iron_ingot') * 2)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustBrownLimonite') * 4)
            .outputs(item('minecraft:iron_ingot') * 1)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustYellowLimonite') * 4)
            .outputs(item('minecraft:iron_ingot') * 1)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustPyrite') * 2)
            .outputs(item('minecraft:iron_ingot') * 1)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustNickel') * 1)
            .outputs(metaitem('ingotNickel') * 1)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustGarnierite') * 2)
            .outputs(metaitem('ingotNickel') * 1)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

    mods.gregtech.primitive_blast_furnace.recipeBuilder()
            .inputs(ore('dustPentlandite') * 17)
            .outputs(metaitem('ingotNickel') * 9)
            .duration(1000)
            .inputs(fuel * 1)
            .buildAndRegister();

}

/*
def OreMap = [
	item('gregtech:ore_Iron_0') : metaitem('dustIron')*2,
	item('gregtech:ore_Gold_0') : metaitem('dustGold')*2,
	item('gregtech:ore_Copper_0') : metaitem('dustCopper')*2,
	item('gregtech:ore_Tin_0') : metaitem('dustTin')*2,
	item('gregtech:ore_Silver_0') : metaitem('dustSilver')*2,
	item('gregtech:ore_Lead_0') : metaitem('dustLead')*2,
	item('gregtech:ore_Zinc_0') : metaitem('dustZinc')*2,
	item('gregtech:ore_Sphalerite_0') : metaitem('dustSphalerite')*4,
	item('gregtech:ore_Magnetite_0') : metaitem('dustMagnetite')*4,
	item('gregtech:ore_Vanadium_Magnetite_0') : metaitem('dustVanadiumMagnetite')*4,
	item('gregtech:ore_Hematite_0') : metaitem('dustHematite')*4,
	item('gregtech:ore_Brown_Limonite_0') : metaitem('dustBrownLimonite')*4,
	item('gregtech:ore_Yellow_Limonite_0') : metaitem('dustYellowLimonite')*4,
	item('gregtech:ore_Tenorite_0') : metaitem('dustTenorite')*4,
	item('gregtech:ore_Tetrahedrite_0') : metaitem('dustTetrahedrite')*4,
	item('gregtech:ore_Bornite_0') : metaitem('dustBornite')*4,
	item('gregtech:ore_Chalcopyrite_0') : metaitem('dustChalcopyrite')*4,
	item('gregtech:ore_Malachite_0') : metaitem('dustMalachite')*4,
	item('gregtech:ore_Enargite_0') : metaitem('dustEnargite')*4,
	item('gregtech:ore_Cassiterite_0') : metaitem('dustCassiterite')*4,
	item('gregtech:ore_Galena_0') : metaitem('dustGalena')*4,
	item('gregtech:ore_Pyrite_0') : metaitem('dustPyrite')*4,

	metaitem('ingotTin') : metaitem('dustTin'),
	metaitem('ingotCopper') : metaitem('dustCopper'),
	metaitem('ingotBronze') : metaitem('dustBronze'),
	metaitem('ingotIron') : metaitem('dustIron'),
	metaitem('ingotLead') : metaitem('dustLead'),
	metaitem('ingotZinc') : metaitem('dustZinc'),
	metaitem('ingotBrass') : metaitem('dustBrass'),
	metaitem('ingotNickel') : metaitem('dustNickel'),

	metaitem('nuggetTin') : metaitem('dustTinyTin'),
	metaitem('nuggetCopper') : metaitem('dustTinyCopper'),
	metaitem('nuggetBronze') : metaitem('dustTinyBronze'),
	metaitem('nuggetIron') : metaitem('dustTinyIron'),
	metaitem('nuggetLead') : metaitem('dustTinyLead'),
	metaitem('nuggetZinc') : metaitem('dustTinyZinc'),
	metaitem('nuggetBrass') : metaitem('dustTinyBrass'),
	metaitem('nuggetNickel') : metaitem('dustTinyNickel')

]

for (key in OreMap) {
	mods.appliedenergistics.Grinder.recipeBuilder()
	.input(key.getKey())
	.output(OreMap[key.getKey()])
	.register()
}
*/

//NoTreePunching tool stats tweak

/*
item('notreepunching:pickaxe/flint').setMaxDamage(200);
item('notreepunching:axe/flint').setMaxDamage(200);
item('notreepunching:shovel/flint').setMaxDamage(200);
item('notreepunching:hoe/flint').setMaxDamage(200);
item('notreepunching:knife/flint').setMaxDamage(200);
*/

def WoodMap = [
    'minecraft:log:0': 'minecraft:planks:0',
    'minecraft:log:1': 'minecraft:planks:1',
    'minecraft:log:2': 'minecraft:planks:2',
    'minecraft:log:3': 'minecraft:planks:3',
    'minecraft:log2:0': 'minecraft:planks:4',
    'minecraft:log2:1': 'minecraft:planks:5',
    'biomesoplenty:log_0:4': 'biomesoplenty:planks_0:0',
    'biomesoplenty:log_0:5': 'biomesoplenty:planks_0:1',
    'biomesoplenty:log_0:6': 'biomesoplenty:planks_0:2',
    'biomesoplenty:log_0:7': 'biomesoplenty:planks_0:3',
    'biomesoplenty:log_1:4': 'biomesoplenty:planks_0:4',
    'biomesoplenty:log_1:5': 'biomesoplenty:planks_0:5',
    'biomesoplenty:log_1:6': 'biomesoplenty:planks_0:6',
    'biomesoplenty:log_1:7': 'biomesoplenty:planks_0:7',
    'biomesoplenty:log_2:4': 'biomesoplenty:planks_0:8',
    'biomesoplenty:log_2:5': 'biomesoplenty:planks_0:9',
    'biomesoplenty:log_2:6': 'biomesoplenty:planks_0:10',
    'biomesoplenty:log_2:7': 'biomesoplenty:planks_0:11',
    'biomesoplenty:log_3:4': 'biomesoplenty:planks_0:12',
    'biomesoplenty:log_3:5': 'biomesoplenty:planks_0:13',
    'biomesoplenty:log_3:6': 'biomesoplenty:planks_0:14',
    'biomesoplenty:log_3:7': 'biomesoplenty:planks_0:15'
]

var i = 0 as int;

for (log in WoodMap) {
    crafting.addShaped("wood_" + i, item(WoodMap[log.getKey()]) * 4, [
            [ore('craftingToolSaw'), item(log.getKey()), null]
    ]);
    i+=1;
}

//Furnace Recipes

//furnace.add(ore('stickIron'), metaitem('hot_iron_rod'));