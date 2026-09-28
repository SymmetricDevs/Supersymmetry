crafting.replaceShaped('packagedauto:packager', item('packagedauto:packager'), [
    [ore('plateSteel'), item('packagedauto:me_package_component'), ore('plateSteel')],
    [ore('wireFineCopper'), metaitem('robot.arm.mv'), ore('wireFineCopper')],
    [ore('plateSteel'), ore('piston'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:encoder', item('packagedauto:encoder'), [
    [ore('plateSteel'), item('packagedauto:package_component'), ore('plateSteel')],
    [metaitem('robot.arm.mv'), null, metaitem('robot.arm.mv')],
    [ore('plateSteel'), ore('circuitMv'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:unpackager', item('packagedauto:unpackager'), [
    [ore('plateSteel'), item('packagedauto:me_package_component'), ore('plateSteel')],
    [ore('wireFineCopper'), metaitem('crate.wood'), ore('wireFineCopper')],
    [ore('plateSteel'), metaitem('robot.arm.mv'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:packager_extension', item('packagedauto:packager_extension'), [
    [ore('plateSteel'), item('packagedauto:me_package_component'), ore('plateSteel')],
    [ore('wireFineCopper'), metaitem('crate.wood'), ore('wireFineCopper')],
    [ore('plateSteel'), ore('piston'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:recipe_holder', item('packagedauto:recipe_holder') * 2, [
    [ore('plateGlass'), ore('wireFineCopper'), ore('plateGlass')],
    [ore('wireFineCopper'), item('appliedenergistics2:material', 39), ore('wireFineCopper')],
    [ore('plateSteel'), item('packagedauto:package_component'), ore('plateSteel')]
])

crafting.replaceShaped('packagedauto:package_component', item('packagedauto:package_component'), [
    [ore('plateGold'), ore('wireFineCopper'), ore('plateGold')],
    [ore('wireFineCopper'), ore('circuitMv'), ore('wireFineCopper')],
    [ore('plateGold'), ore('wireFineCopper'), ore('plateGold')]
])

crafting.replaceShaped('packagedauto:me_package_component', item('packagedauto:me_package_component'), [
    [ore('plateSteel'), item('appliedenergistics2:quartz_glass'), ore('plateSteel')],
    [item('appliedenergistics2:material', 43), item('packagedauto:package_component'), item('appliedenergistics2:material', 44)],
    [ore('plateSteel'), item('appliedenergistics2:quartz_glass'), ore('plateSteel')]
])
