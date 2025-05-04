import static gregtech.api.GTValues.*
ASSEMBLER = recipemap('assembler')
CHEMICAL_BATH = recipemap('chemical_bath')

log.infoMC("Running projectRed.groovy...")

mods.jei.ingredient.yeet(
    item('projectred-core:resource_item', 100),         //Copper Ingot
    item('projectred-core:resource_item', 101),         //Tin Ingot
    item('projectred-core:resource_item', 102),         //Silver Ingot
    item('projectred-core:resource_item', 103),         //Red Alloy Ingot
    item('projectred-core:resource_item', 104),         //Electrotine Alloy Ingot
    item('projectred-core:resource_item', 105),         //Electrotine
    item('projectred-core:resource_item', 200),         //Ruby
    item('projectred-core:resource_item', 201),         //Sapphire
    item('projectred-core:resource_item', 202),         //Peridot
    item('projectred-core:resource_item', 250),         //Sandy Coal Compound
    item('projectred-core:resource_item', 251),         //Red Iron Compound
    item('projectred-core:resource_item', 252),         //Electrotine Iron Compound
    item('projectred-core:resource_item', 300),         //Silicon
    item('projectred-core:resource_item', 310),         //Red Silicon Compound
    item('projectred-core:resource_item', 311),         //Glowing Silicon Compound
    item('projectred-core:resource_item', 312),         //Electrotine Silicon Compound
    item('projectred-core:resource_item', 342),         //Electro Silicon
    item('projectred-core:resource_item', 400),         //Electro Silicon
    item('projectred-core:resource_item', 401),         //Iron Coil
    item('projectred-core:resource_item', 402),         //Gold Coil
    item('projectred-core:resource_item', 410),         //Motor
    item('projectred-core:resource_item', 421),         //Sail
    item('projectred-core:resource_item', 600),         //Null-Logic Routing Chip
    item('projectred-core:drawplate'),                  //Draw Plate
    item('projectred-core:multimeter'),                 //Multimeter
    item('projectred-integration:gate', 34),            //IC Gate
    item('projectred-transmission:wire', 34),           //Low Load Power Line
    item('projectred-transmission:framed_wire', 34),    //Framed Low Load Power Line
)

def name_removals = [
  'projectred-transmission:insulated/green_insulated_wire',
  'projectred-transmission:insulated/cyan_insulated_wire',
  'projectred-transmission:insulated/yellow_insulated_wire',
  'projectred-transmission:insulated/blue_insulated_wire',
  'projectred-transmission:insulated/light_gray_insulated_wire',
  'projectred-transmission:insulated/orange_insulated_wire',
  'projectred-transmission:insulated/gray_insulated_wire',
  'projectred-transmission:insulated/pink_insulated_wire',
  
  'projectred-transmission:insulated/magenta_insulated_wire',
  'projectred-transmission:insulated/brown_insulated_wire',
  'projectred-transmission:insulated/light_blue_insulated_wire',
  'projectred-transmission:insulated/white_insulated_wire',
  'projectred-transmission:insulated/red_insulated_wire',
  'projectred-transmission:insulated/black_insulated_wire',
  'projectred-transmission:insulated/lime_insulated_wire',
  'projectred-transmission:insulated/purple_insulated_wire'
];

for (name in name_removals) {
  crafting.remove(name)
}

// Recipes

// Red Alloy Wire
crafting.replaceShapeless("projectred-transmission:red_alloy_wire", item('projectred-transmission:wire'), [ore('wireGtSingleRedAlloy')])

// Circuit Plate
furnace.removeByOutput(item('projectred-core:resource_item'))

crafting.addShaped("projectred-core:circuit_plate", item('projectred-core:resource_item'), [
    [ore('wireFineRedAlloy'), ore('wireFineRedAlloy'), ore('wireFineRedAlloy')],
    [ore('plateStone'), ore('plateStone'), ore('plateStone')],
    [null, null, null]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineRedAlloy') * 3, ore('plateStone') * 3)
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()


// Conductive Plate
crafting.replaceShaped("projectred-core:parts/conductive_plate", item('projectred-core:resource_item:1'), [
    [null, ore('plateRedAlloy'), null],
    [null, item('projectred-core:resource_item'), null],
    [null, ore('craftingToolScrewdriver'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateRedAlloy'), item('projectred-core:resource_item'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:1'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Wired Plate
crafting.replaceShaped("projectred-core:parts/wired_plate", item('projectred-core:resource_item:2'), [
    [null, ore('plateRedAlloy'), null],
    [null, item('projectred-core:resource_item'), null],
    [null, ore('craftingToolScrewdriver'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireGtSingleRedAlloy'), item('projectred-core:resource_item'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:2'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Bundled Plate
crafting.replaceShaped("projectred-transmission:bundled_plate", item('projectred-core:resource_item:3'), [
    [null, ore('projredBundledCable'), null],
    [null, item('projectred-core:resource_item'), null],
    [null, ore('craftingToolScrewdriver'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item'), ore('projredBundledCable'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:3'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Platformed Plate
crafting.replaceShaped("projectred-core:parts/platformed_plate", item('projectred-core:resource_item:4'), [
    [null, item('projectred-core:resource_item'), null],
    [item('projectred-core:resource_item:2'), ore('frameGtWood'), item('projectred-core:resource_item:2')],
    [item('projectred-core:resource_item'), ore('craftingToolScrewdriver'), item('projectred-core:resource_item')]
])

ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item') * 3, item('projectred-core:resource_item', 2) * 2, ore('frameGtWood'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:4'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Anode
crafting.replaceShaped("projectred-core:parts/anode", item('projectred-core:resource_item:10'), [
    [null, ore('plateRedstone'), null],
    [null, item('projectred-core:resource_item'), null],
    [null, ore('craftingToolScrewdriver'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item'), ore('plateRedstone'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:10'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Cathode
crafting.replaceShaped("projectred-core:parts/cathode", item('projectred-core:resource_item:11'), [
    [null, ore('boltRedAlloy'), null],
    [null, item('projectred-core:resource_item'), null],
    [null, ore('craftingToolScrewdriver'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item'), ore('boltRedAlloy'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:11'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Pointer
crafting.replaceShaped("projectred-core:parts/pointer", item('projectred-core:resource_item:12'), [
    [null, ore('circuitUlv'), null],
    [null, item('projectred-core:resource_item:11'), null],
    [null, ore('craftingToolScrewdriver'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('circuitUlv'), item('projectred-core:resource_item'))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item:12'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Bus Input Panel
crafting.replaceShaped("projectred-integration:bus_input_panel", item('projectred-integration:gate:30'), [
    [item('projectred-core:resource_item:3'), ore('craftingToolScrewdriver'), item('projectred-core:resource_item:3')],
    [item('projectred-core:resource_item:3'), metaitem('cover.screen'), item('projectred-core:resource_item:3')],
    [item('projectred-core:resource_item:3'), ore('circuitLv'), item('projectred-core:resource_item:3')],
])

ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item:3') * 6, metaitem('cover.screen'), metaitem('cover.screen'))
    .circuitMeta(7)
    .outputs(item('projectred-integration:gate:30'))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Infused Silicon
furnace.removeByOutput(item('projectred-core:resource_item:320'))

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('plate.integrated_logic_circuit'))
    .fluidInputs(fluid('redstone') * 1152)
    .outputs(item('projectred-core:resource_item:320'))
    .duration(400)
    .EUt(7)
    .buildAndRegister();

// Energized Silicon
furnace.removeByOutput(item('projectred-core:resource_item:341'))

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('plate.integrated_logic_circuit'))
    .fluidInputs(fluid('glowstone') * 1152)
    .outputs(item('projectred-core:resource_item:341'))
    .duration(400)
    .EUt(7)
    .buildAndRegister();

// Silicon Chip
ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item') * 3, item('projectred-core:resource_item', 320))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item', 20))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

// Energized Silicon Chip
ASSEMBLER.recipeBuilder()
    .inputs(item('projectred-core:resource_item') * 3, item('projectred-core:resource_item', 341))
    .circuitMeta(7)
    .outputs(item('projectred-core:resource_item', 21))
    .duration(100).EUt(VA[LV])
    .buildAndRegister()

//Black Insulated Wire
crafting.addShapeless(item('projectred-transmission:wire:16'), [ore('cableGtSingleRedAlloy')]);

def chemical_dyes = [
    'dye_white',
    'dye_orange',
    'dye_magenta',
    'dye_light_blue',
    'dye_yellow',
    'dye_lime',
    'dye_pink',
    'dye_gray',
    'dye_light_gray',
    'dye_cyan',
    'dye_purple',
    'dye_blue',
    'dye_brown',
    'dye_green',
    'dye_red',
    'dye_black'
]

for (i = 0; i < 15; i++) {
    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('projredInsulatedWire'))
        .fluidInputs(fluid(chemical_dyes[i]) * 18)
        .outputs(item('projectred-transmission:wire', i+1))
        .duration(20)
        .EUt(7)
        .buildAndRegister();
    CHEMICAL_BATH.recipeBuilder()
        .inputs(item('projectred-transmission:wire', i+18))
        .fluidInputs(fluid('acetone') * 100)
        .outputs(item('projectred-transmission:wire:17'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();
    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('projredBundledCable'))
        .fluidInputs(fluid(chemical_dyes[i]) * 18)
        .outputs(item('projectred-transmission:wire', i+18))
        .duration(20)
        .EUt(7)
        .buildAndRegister();
    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('projredInsFramedWire'))
        .fluidInputs(fluid(chemical_dyes[i]) * 18)
        .outputs(item('projectred-transmission:framed_wire', i+1))
        .duration(20)
        .EUt(7)
        .buildAndRegister();
}