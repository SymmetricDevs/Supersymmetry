import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

log.infoMC("Running projectRed.groovy...")

mods.jei.ingredient.yeet(
    item('projectred-core:resource_item', 0),           //Circuit Plate
    item('projectred-core:resource_item', 1),           //Conductive Plate
    item('projectred-core:resource_item', 2),           //Wired Plate
    item('projectred-core:resource_item', 3),           //Bundeled Plate
    item('projectred-core:resource_item', 4),           //Platformed Plate
    item('projectred-core:resource_item', 10),          //Anode
    item('projectred-core:resource_item', 11),          //Cathode
    item('projectred-core:resource_item', 12),          //Pointer
    item('projectred-core:resource_item', 20),          //Silicon Chip
    item('projectred-core:resource_item', 21),          //Energized Silicon Chip
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
    item('projectred-core:resource_item', 301),         //Silicon
    item('projectred-core:resource_item', 310),         //Red Silicon Compound
    item('projectred-core:resource_item', 311),         //Glowing Silicon Compound
    item('projectred-core:resource_item', 312),         //Electrotine Silicon Compound
    item('projectred-core:resource_item', 320),         //Infused Silicon
    item('projectred-core:resource_item', 341),         //Energized Silicon
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
    item('microblockcbe:saw_stone'),                    //Stone Saw
    item('microblockcbe:saw_iron'),                     //Iron Saw
    item('microblockcbe:stone_rod')                     //Stone Rod
)

def name_removals = [
  'projectred-transmission:wired_plate',
  'projectred-core:parts/conductive_plate',
  'projectred-transmission:bundled_plate',
  'projectred-core:parts/platformed_plate',
  'projectred-core:parts/anode',
  'projectred-core:parts/cathode',
  'projectred-core:parts/pointer',
  'projectred-core:parts/silicon_chip',
  'projectred-core:parts/energized_silicon_chip',
  'projectred-core:resource/silicon',

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
  'projectred-transmission:insulated/purple_insulated_wire',

  'projectred-integration:or_gate',
  'projectred-integration:nor_gate',
  'projectred-integration:not_gate',
  'projectred-integration:and_gate',
  'projectred-integration:nand_gate',
  'projectred-integration:xor_gate',
  'projectred-integration:xnor_gate',
  'projectred-integration:buffer_gate',
  'projectred-integration:multiplexer_gate',
  'projectred-integration:pulse_former_gate',
  'projectred-integration:repeater_gate',
  'projectred-integration:randomizer_gate',
  'projectred-integration:rs_latch',
  'projectred-integration:toggle_latch',
  'projectred-integration:transparent_latch',
  'projectred-integration:light_sensor',
  'projectred-integration:rain_sensor',
  'projectred-integration:timer_gate',
  'projectred-integration:sequencer_gate',
  'projectred-integration:counter_gate',
  'projectred-integration:state_cell_gate',
  'projectred-integration:synchromizer_gate',
  'projectred-integration:bus_transceiver',
  'projectred-integration:null_cell',
  'projectred-integration:invert_cell',
  'projectred-integration:buffer_cell',
  'projectred-integration:comparator',
  'projectred-integration:and_cell',
  'projectred-integration:bus_randomizer',
  'projectred-integration:bus_converter',
  'projectred-integration:bus_input_panel',
  'projectred-integration:stacking_latch',
  'projectred-integration:segment_display',
  'projectred-integration:decoding_randomizer_gate',
];

for (name in name_removals) {
  crafting.remove(name)
}

furnace.removeByOutput(item('projectred-core:resource_item'))
furnace.removeByOutput(item('projectred-core:resource_item:301'))
furnace.removeByOutput(item('projectred-core:resource_item:320'))
furnace.removeByOutput(item('projectred-core:resource_item:341'))

// Recipes

// Red Alloy Wire
crafting.replaceShapeless("projectred-transmission:red_alloy_wire", item('projectred-transmission:wire'), [ore('wireGtSingleRedAlloy')])

// Susyfied Recipes
for (i = 0; i <= 6; i++) {
  ASSEMBLER.recipeBuilder()
    .inputs(ore('circuitLv'))
    .inputs(ore('plateStone'))
    .fluidInputs(fluid('glue') * 200)
    .circuitMeta(i+1)
    .outputs(item('projectred-integration:gate:' + (i).toString()) * 32)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()
  }

for (i = 7; i <= 33; i++) {
  ASSEMBLER.recipeBuilder()
    .inputs(ore('circuitLv'))
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineCopper') * 4)
    .fluidInputs(fluid('glue') * 200)
    .circuitMeta(i - 6)
    .outputs(item('projectred-integration:gate:' + (i).toString()) * 32)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()
  }

//Black Insulated Wire
crafting.addShapeless(item('projectred-transmission:wire:16'), [ore('cableGtSingleRedAlloy')]);

//Bundled Cable
ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('projredInsulatedWire')*5)
    .fluidInputs(fluid('glue') * 200)
    .outputs(item('projectred-transmission:wire', 17))
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister()

crafting.replaceShaped("microblockcbe:diamond_saw", item('microblockcbe:saw_diamond'), [
        [null, null, null],
        [ore('stickWood'), ore('stickStone'), ore('stickStone')],
        [ore('stickWood'), item('minecraft:diamond'), ore('stickStone')]
])

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
        .EUt(VA[ULV])
        .buildAndRegister();
    CHEMICAL_BATH.recipeBuilder()
        .inputs(item('projectred-transmission:wire', i+18))
        .fluidInputs(fluid('acetone') * 100)
        .outputs(item('projectred-transmission:wire:17'))
        .duration(20)
        .EUt(VA[ULV])
        .buildAndRegister();
    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('projredBundledCable'))
        .fluidInputs(fluid(chemical_dyes[i]) * 18)
        .outputs(item('projectred-transmission:wire', i+18))
        .duration(20)
        .EUt(VA[ULV])
        .buildAndRegister();
    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('projredInsFramedWire'))
        .fluidInputs(fluid(chemical_dyes[i]) * 18)
        .outputs(item('projectred-transmission:framed_wire', i+1))
        .duration(20)
        .EUt(VA[ULV])
        .buildAndRegister();
}
