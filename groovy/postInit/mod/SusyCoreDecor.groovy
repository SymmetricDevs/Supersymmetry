import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// BMRF
ASSEMBLER.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('dye_orange') * 18)
    .inputs(item('gregtech:stone_smooth',4))
    .outputs(item('susy:bmrf_blocks', 0) * 32)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('dye_orange') * 18)
    .inputs(item('gregtech:stone_smooth',4))
    .outputs(item('susy:s3bmrf_blocks', 0) * 32)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('dye_orange') * 18)
    .inputs(item('gregtech:stone_smooth',4))
    .outputs(item('susy:s5bmrf_blocks', 0) * 32)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

mods.chisel.carving.addGroup("BMRF1&2_blocks")

for (int i = 0; i < 16; i++) {
    mods.chisel.carving.addVariation("BMRF1&2_blocks", item('susy:bmrf_blocks', i))
}
for (int i = 0; i < 16; i++) {
    mods.chisel.carving.addVariation("BMRF1&2_blocks", item('susy:s2bmrf_blocks', i))
}

mods.chisel.carving.addGroup("BMRF3&4_blocks")

for (int i = 0; i < 16; i++) {
    mods.chisel.carving.addVariation("BMRF3&4_blocks", item('susy:s3bmrf_blocks', i))
}
for (int i = 0; i < 16; i++) {
    mods.chisel.carving.addVariation("BMRF3&4_blocks", item('susy:s4bmrf_blocks', i))
}

mods.chisel.carving.addGroup("BMRF5&6_blocks")

for (int i = 0; i < 16; i++) {
    mods.chisel.carving.addVariation("BMRF5&6_blocks", item('susy:s5bmrf_blocks', i))
}
for (int i = 0; i < 16; i++) {
    mods.chisel.carving.addVariation("BMRF5&6_blocks", item('susy:s6bmrf_blocks', i))
}

// Activity blocks

crafting.addShaped(item('susy:wire_coil_active',0) * 16,
        [[metaitem('wireFineCopper'),ore('stone'),metaitem('wireFineCopper')],
         [ore('stone'), ore('gtLight'), ore('stone')],
         [metaitem('wireFineCopper'),ore('stone'),metaitem('wireFineCopper')]])


activityBlocks = []
def addActivityGroup(name, number) {
    for (int i = 0; i < number; i++) {
        activityBlocks << [item(name, i),  item(name + '_inverted', i)]
    }
}
addActivityGroup('susy:wire_coil_active', 8)
addActivityGroup('susy:heating_coil_active', 2)
addActivityGroup('susy:cooling_coil_active', 3)
addActivityGroup('susy:firebox_active', 4)
addActivityGroup('susy:engine_intake_active', 2)
addActivityGroup('susy:assembly_line_active', 1)
addActivityGroup('susy:fusion_casing_active', 3)
// weird edge case for no reason
activityBlocks << [item('susy:heat_vent_active', 3), item('susy:heat_vent_active_inverted', 3)]
addActivityGroup('susy:sintering_brick_active', 2)
addActivityGroup('susy:evaporation_bed_active', 1)
addActivityGroup('susy:electrode_assembly_active', 1)
addActivityGroup('susy:serpentine_active', 1)
addActivityGroup('susy:basic_intake_casing_active', 1)
addActivityGroup('susy:eccentric_roll_active', 1)
mods.chisel.carving.addGroup("active_blocks")

mods.chisel.carving.addGroup("active_inverted_blocks")

activityBlocks.each { active, inverted -> 
    mods.chisel.carving.addVariation("active_blocks", active)
    mods.chisel.carving.addVariation("active_inverted_blocks", inverted)
    // shapeless
    crafting.addShapeless(active, [inverted])
    crafting.addShapeless(inverted, [active])
}

crafting.addShapeless(item('gregtech:machine',18526) * 16, [
    item('gregtech:machine',1657)
])

crafting.addShapeless(item('gregtech:machine',18527) * 1, [
    item('susy:multiblock_tank',0)
])
