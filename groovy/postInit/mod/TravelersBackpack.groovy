// Deprecated
mods.jei.ingredient.yeet(
    item('travelersbackpack:backpack_tank'),
    item('travelersbackpack:sleeping_bag_bottom'),
    item('travelersbackpack:hose_nozzle'),
    item('travelersbackpack:hose'),
    fluid('potion'),
)

for (i in 1..76) {
    mods.jei.ingredient.yeet(item('travelersbackpack:travelers_backpack', i))
}

crafting.replaceShaped('travelersbackpack:travelers_backpack_standard', item('travelersbackpack:travelers_backpack'), [
        [item('techguns:itemshared', 77), metaitem('workbench'), item('techguns:itemshared', 77)],
        [metaitem('large_fluid_cell.steel').or(item('gregtech:machine', 1612)), item('minecraft:chest'), metaitem('large_fluid_cell.steel').or(item('gregtech:machine', 1612))],
        [item('techguns:itemshared', 77), ore('wool'), item('techguns:itemshared', 77)]
])