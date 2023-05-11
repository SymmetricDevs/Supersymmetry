// Building Gadget
crafting.addShaped('buildinggadgets:buildingtool', item('buildinggadgets:buildingtool'), [
    [null, metaitem('electric.motor.lv'), null],
    [ore('plateIron'), metaitem('power_unit.lv'), ore('plateIron')],
    [ore('plateIron'), ore('circuitLv'), ore('plateIron')]
])

// Exchanging Gadget
crafting.addShaped('buildinggadgets:exchangertool', item('buildinggadgets:exchangertool'), [
    [null, metaitem('electric.piston.lv'), null],
    [ore('plateIron'), metaitem('power_unit.lv'), ore('plateIron')],
    [ore('plateIron'), ore('circuitLv'), ore('plateIron')]
])

// Copy Paste Gadget
crafting.addShaped('buildinggadgets:copypastetool', item('buildinggadgets:copypastetool'), [
    [null, metaitem('electric.piston.lv'), ore('gearSmallIron')],
    [ore('plateIron'), metaitem('power_unit.lv'), ore('plateIron')],
    [ore('plateIron'), ore('circuitLv'), ore('plateIron')]
])

// Destruction Gadget
crafting.addShaped('buildinggadgets:destructiontool', item('buildinggadgets:destructiontool'), [
    [null, metaitem('toolHeadDrillIron'), null],
    [ore('plateIron'), metaitem('power_unit.lv'), ore('plateIron')],
    [ore('plateIron'), ore('circuitLv'), ore('plateIron')]
])

// have to do template and paste stuff