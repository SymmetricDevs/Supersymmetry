import static prePostInit.Recipemaps.*
import globals.Globals
// this removes all recipes Solo.
def name_removal = [
"retro_sophisticated_backpacks:inception_upgrade",
"retro_sophisticated_backpacks.stack_upgrade_starter_tier",
"retro_sophisticated_backpacks:stack_upgrade_tier_2",
"retro_sophisticated_backpacks:stack_upgrade_tier_3",
"retro_sophisticated_backpacks:stack_upgrade_tier_4",
"retro_sophisticated_backpacks.exponential_stack_upgrade",
"retro_sophisticated_backpacks:backpack_iron",
"retro_sophisticated_backpacks:backpack_gold",
"retro_sophisticated_backpacks:backpack_diamond",
"retro_sophisticated_backpacks:backpack_obsidian",
"retro_sophisticated_backpacks:upgrade_base",
"retro_sophisticated_backpacks:stack_upgrade_tier_1",
"retro_sophisticated_backpacks:crafting_upgrade",
"retro_sophisticated_backpacks:pickup_upgrade",
"retro_sophisticated_backpacks:advanced_pickup_upgrade",
"retro_sophisticated_backpacks:filter_upgrade",
"retro_sophisticated_backpacks:advanced_filter_upgrade",
"retro_sophisticated_backpacks:restock_upgrade",
"retro_sophisticated_backpacks:advanced_restock_upgrade",
"retro_sophisticated_backpacks:deposit_upgrade",
"retro_sophisticated_backpacks:advanced_deposit_upgrade",
"retro_sophisticated_backpacks:feeding_upgrade",
"retro_sophisticated_backpacks:advanced_feeding_upgrade",
]
for (name in name_removal) {
    crafting.remove(name)
}
// this hides items from JEI Solo.
mods.jei.ingredient.yeet(
    item('retro_sophisticated_backpacks:inception_upgrade'),
    item('retro_sophisticated_backpacks:stack_upgrade_starter_tier'),
    item('retro_sophisticated_backpacks:stack_upgrade_tier_2'),
    item('retro_sophisticated_backpacks:stack_upgrade_tier_3'),
    item('retro_sophisticated_backpacks:stack_upgrade_tier_4'),
    item('retro_sophisticated_backpacks:exponential_stack_upgrade')
)
// time to add recipes, this adds recipes for crafting table.
crafting.addShaped(
    'retro_sophisticated_backpacks:backpack_iron',
    item('retro_sophisticated_backpacks:backpack_iron'),
    [
        [ore('frameGtSteel'), ore('screwSteel'), ore('frameGtSteel')],
        [ore('leather'), ore('chest'), ore('leather')],
        [ore('leather'),ore('leather'), ore('leather')]
    ]
)
crafting.addShaped(
    'retro_sophisticated_backpacks:upgrade_base',
    item('retro_sophisticated_backpacks:upgrade_base'),
    [
        [ore('screwAluminium'), ore('plateAluminium'), ore('screwAluminium')],
        [ore('plateAluminium'), ore('circuitLv'), ore('plateAluminium')],
        [ore('screwAluminium'), ore('plateAluminium'), ore('screwAluminium')]
    ]
)
crafting.addShaped(
    'retro_sophisticated_backpacks:backpack_gold',
    item( 'retro_sophisticated_backpacks:backpack_gold'),
    [
        [ore('frameGtAluminium'), ore('screwAluminium'), ore('frameGtAluminium')],
        [ore('foilPolycaprolactam'), ore('chest'), ore('foilPolycaprolactam')],
        [ore('foilPolycaprolactam'), ore('foilPolycaprolactam'), ore('foilPolycaprolactam')]
    ]
)
ASSEMBLER.recipeBuilder()
    .inputs(ore('screwTitanium'))
    .inputs(ore('frameGtTitanium')*2) 
    .inputs(ore('plateUltraHighMolecularWeightPolyethylene')*5)
    .inputs(ore('chest'))
    .outputs(item('retro_sophisticated_backpacks:backpack_diamond'))
    .duration(100)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwTitanium'))
    .inputs(ore('frameGtTitanium')*2) 
    .inputs(ore('plateSpandex')*5)
    .inputs(ore('chest'))
    .outputs(item('retro_sophisticated_backpacks:backpack_obsidian'))
    .duration(100)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(metaitem('electric.piston.mv')*2)
    .outputs(item('retro_sophisticated_backpacks:stack_upgrade_tier_1'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(ore('workbench'))
    .outputs(item('retro_sophisticated_backpacks:crafting_upgrade'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(metaitem('item_magnet.lv'))
    .outputs(item('retro_sophisticated_backpacks:pickup_upgrade'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(item('retro_sophisticated_backpacks:pickup_upgrade'))
    .inputs(metaitem('item_filter'))
    .outputs(item('retro_sophisticated_backpacks:advanced_pickup_upgrade'))
    .duration(40)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('toolHeadBuzzSawSteel')*2)
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(metaitem('electric.pump.ev'))
    .inputs(ore('pipeTinyFluidPlastic'))
    .outputs(item('retro_sophisticated_backpacks:feeding_upgrade'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(item('retro_sophisticated_backpacks:feeding_upgrade'))
    .inputs(metaitem('item_filter'))
    .outputs(item('retro_sophisticated_backpacks:advanced_feeding_upgrade'))
    .duration(40)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(metaitem('robot.arm.mv')*2)
    .outputs(item('retro_sophisticated_backpacks:deposit_upgrade'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(item('retro_sophisticated_backpacks:deposit_upgrade'))
    .inputs(metaitem('item_filter'))
    .outputs(item('retro_sophisticated_backpacks:advanced_deposit_upgrade'))
    .duration(40)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(metaitem('conveyor.module.mv')*2)
    .outputs(item('retro_sophisticated_backpacks:restock_upgrade'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(item('retro_sophisticated_backpacks:restock_upgrade'))
    .inputs(metaitem('item_filter'))
    .outputs(item('retro_sophisticated_backpacks:advanced_restock_upgrade'))
    .duration(40)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('screwAluminium')*2)
    .inputs(item('retro_sophisticated_backpacks:upgrade_base'))
    .inputs(metaitem('item_filter'))
    .outputs(item('retro_sophisticated_backpacks:filter_upgrade'))
    .duration(30)
    .EUt(128)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(item('retro_sophisticated_backpacks:filter_upgrade'))
    .inputs(metaitem('smart_item_filter'))
    .outputs(item('retro_sophisticated_backpacks:advanced_filter_upgrade'))
    .duration(40)
    .EUt(128)
    .buildAndRegister();