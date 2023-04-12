crafting.replaceShaped('packagedauto:packager', item('packagedauto:packager'), [
    [ore('plateSteel'), item('packagedauto:me_package_component'), ore('plateSteel')],
    [ore('wireFineRedAlloy'), metaitem('robot.arm.mv'), ore('wireFineRedAlloy')],
    [ore('plateSteel'), ore('piston'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:encoder', item('packagedauto:encoder'), [
    [ore('plateSteel'), item('packagedauto:package_component'), ore('plateSteel')],
    [metaitem('robot.arm.mv'), null, metaitem('robot.arm.mv')],
    [ore('plateSteel'), ore('circuitMv'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:unpackager', item('packagedauto:unpackager'), [
    [ore('plateSteel'), item('packagedauto:me_package_component'), ore('plateSteel')],
    [ore('wireFineRedAlloy'), metaitem('crate.wood'), ore('wireFineRedAlloy')],
    [ore('plateSteel'), metaitem('robot.arm.mv'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:packager_extension', item('packagedauto:packager_extension'), [
    [ore('plateSteel'), item('packagedauto:me_package_component'), ore('plateSteel')],
    [ore('wireFineRedAlloy'), metaitem('crate.wood'), ore('wireFineRedAlloy')],
    [ore('plateSteel'), ore('piston'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:recipe_holder', item('packagedauto:recipe_holder') * 2, [
    [ore('plateGlass'), ore('wireFineRedAlloy'), ore('plateGlass')],
    [ore('wireFineRedAlloy'), item('appliedenergistics2:material', 39), ore('wireFineRedAlloy')],
    [ore('plateSteel'), item('packagedauto:package_component'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:package_component', item('packagedauto:package_component'), [
    [ore('plateGold'), ore('wireFineRedAlloy'), ore('plateGold')],
    [ore('wireFineRedAlloy'), ore('circuitMv'), ore('wireFineRedAlloy')],
    [ore('plateGold'), ore('wireFineRedAlloy'), ore('plateGold')]
])

crafting.replaceShaped('packagedauto:me_package_component', item('packagedauto:me_package_component'), [
    [ore('plateSteel'), item('appliedenergistics2:quartz_glass'), ore('plateSteel')],
    [item('appliedenergistics2:material', 43), item('packagedauto:package_component'), item('appliedenergistics2:material', 44)],
    [ore('plateSteel'), item('appliedenergistics2:quartz_glass'), ore('plateSteel')]
])