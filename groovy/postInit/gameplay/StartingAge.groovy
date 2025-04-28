import Globals.*
import appeng.api.AEApi;
import appeng.api.features.IGrinderRegistry;
import appeng.api.features.IGrinderRecipeBuilder;
import net.minecraftforge.event.world.BlockEvent;
import gregtech.api.GTValues;
import gregtech.common.blocks.BlockSurfaceRock;
import gregtech.api.unification.material.properties.PropertyKey

final IGrinderRegistry reg = AEApi.instance().registries().grinder();

// Add rocks to ceu surface rock drops, and remove tiny dusts.
event_manager.listen { BlockEvent.HarvestDropsEvent event ->
    if (event.getState().getBlock() instanceof BlockSurfaceRock) {
        int amount = 1 + GTValues.RNG.nextInt(2);
        event.getDrops().clear()
        event.getDrops().add(item('pyrotech:rock') * amount)
    }
}

log.infoMC("Running StartingAge.groovy...")

mods.jei.ingredient.yeet(
        item('minecraft:stone_sword'),
        item('minecraft:stone_shovel'),
        item('minecraft:stone_pickaxe'),
        item('minecraft:stone_axe'),
        item('minecraft:stone_hoe')
)

crafting.replaceShapeless("gregtech:clay_ball_to_dust", metaitem('dustClay'), [
        ore('craftingToolMortar'),
        ore('ingotClay')
])

// 8 * compressed clay
crafting.addShaped("gregtech:compressed_clay_8", item('gregtech:meta_item_1', 349) * 8, [
        [ore('ingotClay'), ore('ingotClay'), ore('ingotClay')],
        [ore('ingotClay'), item('gregtech:meta_item_1', 348), ore('ingotClay')],
        [ore('ingotClay'), ore('ingotClay'), ore('ingotClay')]
])

// Long wood stick
crafting.replaceShaped("gregtech:stick_long_stick_wood", item('gregtech:meta_stick_long', 1617), [
        [null, ore('craftingToolKnife'), null],
        [ore('stickWood'), ore('craftingToolHardHammer'), ore('stickWood')]
])

// Stone Tools
crafting.replaceShaped("gregtech:axe_stone", item('gregtech:axe').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:stone', 'MaxDurability': 31, 'Durability': 0, 'ToolSpeed': 1.0F, 'HarvestLevel': 1, 'AttackDamage': 6.0F, 'AttackSpeed': -3.2F], 'HideFlags': 2, 'GT.Behaviours': ['DisableShields': (byte) 1, 'TreeFelling': (byte) 1]]), [
        [ore('rock'), item('pyrotech:material', 12)],
        [ore('rock'), ore("stickWood")]
])

crafting.replaceShaped("gregtech:hoe_stone", item('gregtech:hoe').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:stone', 'MaxDurability': 95, 'Durability': 0, 'AttackDamage': 0.0F, 'AttackSpeed': -1.0F, 'HarvestLevel': 1], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [item('pyrotech:material', 12), ore('rock')],
        [ore("stickWood"), null]
])

crafting.replaceShaped("gregtech:pickaxe_stone", item('gregtech:pickaxe').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:stone', 'MaxDurability': 95, 'Durability': 0, 'ToolSpeed': 6.0F, 'HarvestLevel': 1, 'AttackDamage': 2.0F, 'AttackSpeed': -2.8F], 'HideFlags': 2, 'GT.Behaviours': ['TorchPlacing': (byte) 1]]), [
        [ore('rock'), item('pyrotech:material', 12)],
        [ore("stickWood"), ore('rock')]
])

crafting.replaceShaped("gregtech:shovel_stone", item('gregtech:shovel').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:stone', 'MaxDurability': 95, 'Durability': 0, 'ToolSpeed': 2.0F, 'HarvestLevel': 1, 'AttackDamage': 2.5F, 'AttackSpeed': -3.0F], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [ore('rock'), item('pyrotech:material', 12)],
        [ore("stickWood"), null]
])

crafting.replaceShaped("gregtech:hammer_stone", item('gregtech:hammer').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:stone', 'MaxDurability': 95, 'Durability': 0, 'ToolSpeed': 3.0F, 'HarvestLevel': 1, 'AttackDamage': 5.0F, 'AttackSpeed': -3.8F], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [ore('rock'), ore('rock')],
        [ore("stickWood"), item('pyrotech:material', 12)]
])

crafting.replaceShaped("gregtech:knife_stone", item('gregtech:knife').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:stone', 'MaxDurability': 31, 'Durability': 0, 'AttackDamage': 1.0F, 'AttackSpeed': 2.5F], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [null, ore('rock')],
        [ore("stickWood"), item('pyrotech:material', 12)]
])

// Granite Mortar
crafting.replaceShaped("gregtech:mortar_granite", item('gregtech:mortar').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:granite', 'MaxDurability': 191, 'Durability': 0, 'AttackDamage': 0.0F, 'AttackSpeed': -2.4F], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [null, ore('stoneGranite'), null],
        [ore('stone'), ore('stoneGranite'), ore('stone')],
        [ore('stone'), ore('stone'), ore('stone')],
])

// Flint Tools
crafting.replaceShaped("gregtech:axe_flint", item('gregtech:axe').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:flint', 'MaxDurability': 127, 'Durability': 0, 'ToolSpeed': 2.0F, 'HarvestLevel': 1, 'AttackDamage': 6.0F, 'AttackSpeed': -3.2F], 'HideFlags': 2, 'GT.Behaviours': ['DisableShields': (byte) 1, 'TreeFelling': (byte) 1]]), [
        [item('pyrotech:material', 10), item('pyrotech:material', 10), null],
        [item('pyrotech:material', 10), ore("stickWood"), ore('twine')],
        [ore("stickWood"), null, null]
])

crafting.replaceShaped("gregtech:hoe_flint", item('gregtech:hoe').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:flint', 'MaxDurability': 63, 'Durability': 0, 'AttackDamage': 0.0F, 'AttackSpeed': -1.0F, 'HarvestLevel': 1], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [item('pyrotech:material', 10), item('pyrotech:material', 10), ore('twine')],
        [null, ore("stickWood"), null],
        [ore("stickWood"), null, null]
])

crafting.replaceShaped("gregtech:pickaxe_flint", item('gregtech:pickaxe').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:flint', 'MaxDurability': 63, 'Durability': 0, 'ToolSpeed': 4.0F, 'HarvestLevel': 1, 'AttackDamage': 2.0F, 'AttackSpeed': -2.8F], 'HideFlags': 2, 'GT.Behaviours': ['TorchPlacing': (byte) 1]]), [
        [item('pyrotech:material', 10), item('pyrotech:material', 10), ore('twine')],
        [null, ore("stickWood"), item('pyrotech:material', 10)],
        [ore("stickWood"), null, item('pyrotech:material', 10)]
])

crafting.replaceShaped("gregtech:shovel_flint", item('gregtech:shovel').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:flint', 'MaxDurability': 63, 'Durability': 0, 'ToolSpeed': 4.0F, 'HarvestLevel': 1, 'AttackDamage': 2.5F, 'AttackSpeed': -3.0F], 'HideFlags': 2, 'GT.Behaviours': []]), [
        [null, ore('twine'), item('pyrotech:material', 10)],
        [null, ore("stickWood"), null],
        [ore("stickWood"), null, null]
])

crafting.replaceShaped("gregtech:knife_flint", item('gregtech:knife').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:flint', 'MaxDurability': 127, 'Durability': 0, 'AttackDamage': 1.0F, 'AttackSpeed': 3.0F], 'HideFlags': 2, 'ench': [['id': (short) 20, 'lvl': (short) 2]], 'GT.Behaviours': []]), [
        [item('pyrotech:material', 10), ore('twine')],
        [null, ore("stickWood")]
])

crafting.replaceShaped("gregtech:sword_flint", item('gregtech:sword').withNbt(['DisallowContainerItem': (byte) 0, 'GT.Tool': ['Material': 'gregtech:flint', 'MaxDurability': 127, 'Durability': 0, 'AttackDamage': 4.0F, 'AttackSpeed': -2.4F, 'HarvestLevel': 1], 'HideFlags': 2, 'ench': [['id': (short) 20, 'lvl': (short) 2]], 'GT.Behaviours': []]), [
        [null, null, item('pyrotech:material', 10)],
        [ore('twine'), item('pyrotech:material', 10), null],
        [ore("stickWood"), ore('twine'), null]
])

// Magnetite Chunk Crafting
crafting.addShapeless("magnetite_chunk", metaitem('chunk.magnetite'), [ore('oreMagnetite'), ore('rock')]);
crafting.addShapeless("magnetite_chunk_1", metaitem('chunk.magnetite'), [ore('oreVanadiumMagnetite'), ore('rock')]);

crafting.replaceShaped("appliedenergistics2:misc/grindstone", item('appliedenergistics2:grindstone'),[
        [ore('stone'), null, ore('stone')],
        [metaitem('gearBronze'), ore('craftingToolFile'), metaitem('gearBronze')],
        [ore('cobblestone'), ore('cobblestone'), ore('cobblestone')]
])

// AE2 Grindstone Ore Processing 
def GrindstoneOreList = [
        'acanthite',
        'anglesite',
        'sphalerite',
        'chlorapatite',
        'fluorapatite',
        'arsenopyrite',
        'pyrite',
        'banded_iron',
        'magnetite',
        'bornite',
        'chalcopyrite',
        'cassiterite',
        'cerussite',
        'cinnabar',
        'stibnite',
        'coal',
        'fluorite',
        'galena',
        'lapis',
        'lazurite',
        'sodalite',
        'lignite',
        'malachite',
        'proustite',
        'pyrolusite',
        'realgar',
        'redstone',
        'saltpeter',
        'chalcocite',
        'enargite',
        'tetrahedrite',
        'anthracite'
]

def GrindstoneDepositMap = [
        'susy:resource_block:2': metaitem("dustSalt") * 3,
        'susy:resource_block:3': metaitem("dustSalt") * 3,
        'susy:resource_block:4': metaitem("dustSalt") * 3,
        'susy:resource_block:5': metaitem("dustSalt") * 3,
        'susy:resource_block:15': metaitem("dustCoal") * 12,
]

for (mat_name in GrindstoneOreList) 
{
    final IGrinderRecipeBuilder builder = reg.builder();
    def mat = material(mat_name)
    def mat_cap = mat.toCamelCaseString()
    mat_cap = mat_cap.substring(0, 1).toUpperCase() + mat_cap.substring(1);

    builder.withInput(item("gregtech:ore_" + mat + "_0") * 2)
    builder.withOutput(metaitem('crushed' + mat_cap) * (int)(mat.oreMultiplier() * 3))
    builder.withTurns(5)

    reg.addRecipe(builder.build())
}

for (key in GrindstoneDepositMap) {
    final IGrinderRecipeBuilder builder = reg.builder();

    builder.withInput(item(key.getKey()) * 2)
    builder.withOutput(key.getValue())
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