import crafttweaker.api.item.IItemStack;

println("Running StartingAge.groovy...")

def name_removals = [
        "notreepunching:tools/iron_saw",
        "notreepunching:tools/gold_saw",
        "notreepunching:tools/diamond_saw",
        "notreepunching:misc/clay_tool_clay_brick_2",
        "notreepunching:misc/clay_tool_clay_brick"
]

for (item in name_removals) {
    crafting.remove(item);
}

crafting.replaceShapeless("gregtech:clay_ball_to_dust", metaitem('dustClay'), [
        ore('craftingToolMortar'),
        ore('ingotClay')
])

//Magnetite Chunk Crafting
//crafting.addShapeless("magnetite_chunk", metaitem('chunk.magnetite'), [ore('oreMagnetite')]);
//crafting.addShapeless("magnetite_chunk_1", metaitem('magnetite_chunk'), [ore('oreVanadiumMagnetite')]);


def fuels = [
        ore('coal')
];

//----------Recipes using GT machines----------

for (fuel in fuels) {

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

def ore_prefixes = ['ore']
def material_names = [
        'Iron',
        'Gold',
        'Copper',
        'Tin',
        'Silver',
        'Lead',
        'Zinc'
]

/*
for (prefix in ore_prefixes) {
        for (material in material_names) {
                mods.appliedenergistics.Grinder.recipeBuilder()
                        .input(ore(prefix + material))
                        .output(metaitem('ingot' + material))
                        .register()
        }
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

/*
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
*/