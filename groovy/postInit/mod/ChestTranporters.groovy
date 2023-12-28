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
  [ore('plateWroughtIron'), null, ore('plateWroughtIron')],
  [ore('screwWroughtIron'), ore('gearSmallIron') , ore('screwWroughtIron')],
  [ore('craftingToolScrewdriver'), ore('stickWroughtIron'), ore('craftingToolHardHammer')]
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
