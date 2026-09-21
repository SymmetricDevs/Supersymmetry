import static prePostInit.Recipemaps.*

def name_removals = [
  'chesttransporter:tin_transporter',
  'chesttransporter:gold_transporter',
  'chesttransporter:obsidian_transporter',
  'chesttransporter:diamond_transporter'
];

for (name in name_removals) {
  crafting.remove(name)
}

crafting.replaceShaped('chesttransporter:wooden_transporter', item('chesttransporter:chesttransporter'), [
  [metaitem('rubber_drop'), null, metaitem('rubber_drop')],
  [item('minecraft:stick'), item('minecraft:stick') , item('minecraft:stick')],
  [null, item('minecraft:stick'), null]
]);

crafting.replaceShaped('chesttransporter:iron_transporter', item('chesttransporter:chesttransporter_iron'), [
  [ore('plateIron'), null, ore('plateIron')],
  [ore('screwIron'), ore('gearSmallIron') , ore('screwIron')],
  [ore('craftingToolScrewdriver'), ore('stickIron'), ore('craftingToolHardHammer')]
]);

crafting.replaceShaped('chesttransporter:silver_transporter', item('chesttransporter:chesttransporter_silver'), [
  [metaitem('robot.arm.lv'), null, metaitem('robot.arm.lv')],
  [ore('screwSteel'), ore('gearSmallSteel') , ore('screwSteel')],
  [ore('craftingToolScrewdriver'), ore('stickSilver'), ore('craftingToolHardHammer')]
]);

crafting.replaceShaped('chesttransporter:copper_transporter', item('chesttransporter:chesttransporter_copper'), [
  [ore('plateBronze'), null, ore('plateBronze')],
  [ore('screwBronze'), ore('gearSmallBronze') , ore('screwBronze')],
  [ore('craftingToolScrewdriver'), ore('stickBronze'), ore('craftingToolHardHammer')]
]);

ASSEMBLER.recipeBuilder()
    .inputs(item('minecraft:stick') * 4)
    .fluidInputs(fluid('glue') * 20)
    .outputs(item('chesttransporter:chesttransporter'))
    .duration(50)
    .EUt(16)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(item('minecraft:stick') * 4)
    .fluidInputs(fluid('resin') * 100)
    .outputs(item('chesttransporter:chesttransporter'))
    .duration(100)
    .EUt(16)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickBronze'))
    .inputs(ore('plateBronze') * 2)
    .inputs(ore('screwBronze') * 2)
    .inputs(ore('gearSmallBronze'))
    .outputs(item('chesttransporter:chesttransporter_copper'))
    .duration(100)
    .EUt(16)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickIron'))
    .inputs(ore('plateIron') * 2)
    .inputs(ore('screwIron') * 2)
    .inputs(ore('gearSmallIron'))
    .outputs(item('chesttransporter:chesttransporter_iron'))
    .duration(100)
    .EUt(16)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('stickSilver'))
    .inputs(ore('screwSteel') * 2)
    .inputs(ore('gearSmallSteel'))
    .inputs(metaitem('robot.arm.lv') * 2)
    .outputs(item('chesttransporter:chesttransporter_silver'))
    .duration(100)
    .EUt(16)
    .buildAndRegister()
