import com.cleanroommc.groovyscript.api.GroovyLog
import gregtech.api.metatileentity.multiblock.CleanroomType
import globals.Globals

/*
def solders = [
        fluid('soldering_alloy') * 72,
        fluid('tin') * 144
]
*/

def name_removals = [
        'appliedenergistics2:misc/grindstone_woodengear',
        'appliedenergistics2:decorative/quartz_glass',
        'appliedenergistics2:decorative/quartz_vibrant_glass',
        'appliedenergistics2:misc/meteors_sky_compass',
        'appliedenergistics2:network/blocks/crystal_processing_charger',
        'appliedenergistics2:network/cells/storage_components_cell_1k_part',
        'appliedenergistics2:network/cells/storage_components_cell_4k_part',
        'appliedenergistics2:network/cells/storage_components_cell_16k_part',
        'appliedenergistics2:network/cells/storage_components_cell_64k_part',
        'appliedenergistics2:network/cells/fluid_storage_components_cell_1k_part',
        'appliedenergistics2:network/cells/fluid_storage_components_cell_4k_part',
        'appliedenergistics2:network/cells/fluid_storage_components_cell_16k_part',
        'appliedenergistics2:network/cells/fluid_storage_components_cell_64k_part',
        'appliedenergistics2:network/cells/spatial_components',
        'appliedenergistics2:network/cells/spatial_components_0',
        'appliedenergistics2:network/cells/spatial_components_1',
        'appliedenergistics2:network/crafting/cpu_crafting_unit',
        'appliedenergistics2:network/crafting/cpu_crafting_accelerator',
        'appliedenergistics2:network/crafting/cpu_crafting_storage_1k',
        'appliedenergistics2:network/crafting/cpu_crafting_storage_4k',
        'appliedenergistics2:network/crafting/cpu_crafting_storage_16k',
        'appliedenergistics2:network/crafting/cpu_crafting_storage_64k',
        'appliedenergistics2:network/parts/oredict_storage_bus',
        'appliedenergistics2:materials/formationcore',
        'appliedenergistics2:materials/annihilationcore',
        'appliedenergistics2:materials/basiccard',
        'appliedenergistics2:materials/advancedcard',
        'extracells:storagecomponent/item/256k',
        'extracells:storagecomponent/item/1024k',
        'extracells:storagecomponent/item/4096k',
        'extracells:storagecomponent/item/16384k',
        'extracells:storagecomponent/fluid/256k',
        'extracells:storagecomponent/fluid/1024k',
        'extracells:storagecomponent/fluid/4096k',
        'appliedenergistics2:network/cells/storage_cell_1k',
        'appliedenergistics2:network/cells/storage_cell_4k',
        'appliedenergistics2:network/cells/storage_cell_16k',
        'appliedenergistics2:network/cells/storage_cell_64k',
        'appliedenergistics2:network/cells/fluid_storage_cell_1k',
        'appliedenergistics2:network/cells/fluid_storage_cell_4k',
        'appliedenergistics2:network/cells/fluid_storage_cell_16k',
        'appliedenergistics2:network/cells/fluid_storage_cell_64k',
        'appliedenergistics2:network/cells/spatial_storage_cell_2_cubed',
        'appliedenergistics2:network/cells/spatial_storage_cell_16_cubed',
        'appliedenergistics2:network/cells/spatial_storage_cell_128_cubed',
        'appliedenergistics2:network/cells/view_cell',
        'extracells:storagecells/item/owncasing/256k',
        'extracells:storagecells/item/owncasing/1024k',
        'extracells:storagecells/item/owncasing/4096k',
        'extracells:storagecells/item/owncasing/16384k',
        'extracells:storagecells/fluid/owncasing/256k',
        'extracells:storagecells/fluid/owncasing/1024k',
        'extracells:storagecells/fluid/owncasing/4096k',
        'extracells:storagecells/case/fluid',
        'extracells:storagecells/case/item',
        'appliedenergistics2:network/parts/export_bus',
        'appliedenergistics2:network/parts/export_bus_fluid',
        'appliedenergistics2:network/cells/empty_storage_cell',
        'appliedenergistics2:network/parts/level_emitter',
        'appliedenergistics2:network/parts/fluid_level_emitter',
        'appliedenergistics2:network/crafting/patterns_blank',
        'appliedenergistics2:network/parts/planes_formation_fluid',
        'appliedenergistics2:network/parts/planes_formation_fluid_alt',
        'appliedenergistics2:network/parts/planes_formation',
        'appliedenergistics2:network/parts/planes_formation_alt',
        'appliedenergistics2:network/parts/planes_annihilation_fluid',
        'appliedenergistics2:network/parts/planes_annihilation_fluid_alt',
        'appliedenergistics2:network/parts/planes_annihilation',
        'appliedenergistics2:network/parts/planes_annihilation_alt',
        'appliedenergistics2:network/parts/planes_annihilation_alt2',
        'appliedenergistics2:network/parts/planes_annihilatition_identity',
        'appliedenergistics2:network/parts/import_bus_fluid',
        'appliedenergistics2:network/parts/import_bus',
        'extracpus:crafting_storage_256k',
        'extracpus:crafting_storage_1024k',
        'extracpus:crafting_storage_4096k',
        'extracpus:crafting_storage_16384k',
        'appliedenergistics2:network/blocks/crystal_processing_quartz_growth_accelerator',
        'appliedenergistics2:network/blocks/energy_vibration_chamber',
        'appliedenergistics2:network/blocks/quantum_link',
        'appliedenergistics2:network/blocks/quantum_ring',
        'appliedenergistics2:misc/tiny_tnt',
        'appliedenergistics2:network/blocks/inscribers',
        'appliedenergistics2:misc/fluixpearl',
        'ae2wtlib:booster_card_new',
        'threng:aggregator',
        'threng:centrifuge',
        'threng:etcher',
        'threng:energizer',
        'appliedenergistics2:network/parts/tunnels_me',
        'threng:ma_vent',
        'threng:ma_frame',
        'threng:ma_controller',
        'threng:ma_mod_pattern',
        'threng:ma_mod_cpu',
        'threng:ma_io_port',
        'appliedenergistics2:network/blocks/energy_energy_cell',
        'appliedenergistics2:network/blocks/energy_dense_energy_cell',
        'appliedenergistics2:network/cables/covered_fluix',
        'appliedenergistics2:network/cables/smart_fluix',
        'appliedenergistics2:network/wireless_part',
        'appliedenergistics2:network/parts/toggle_bus',
        'appliedenergistics2:network/cables/glass_fluix',
        'appliedenergistics2:network/parts/quartz_fiber_part',
        'threng:pau',
        'threng:level_maintainer',
        'appliedenergistics2:misc/seeds_certus',
        'appliedenergistics2:misc/seeds_nether',
        'appliedenergistics2:misc/seeds_fluix',
        'appliedenergistics2:network/blocks/controller',
        'appliedenergistics2:network/blocks/io_condenser',
        'appliedenergistics2:network/blocks/spatial_io_pylon',
        'appliedenergistics2:tools/network_biometric_card',
        'appliedenergistics2:tools/network_memory_card',
        'appliedenergistics2:network/wireless_booster'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('appliedenergistics2:decorative/quartz_fixture', item('appliedenergistics2:quartz_fixture') * 1, [
        [null, null, null],
        [item('appliedenergistics2:material'), ore('ringIron'), null],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:decorative/light_detector', item('appliedenergistics2:light_detector') * 1, [
        [null, null, null],
        [ore('gemNetherQuartz'), ore('ringIron'), null],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:network/wireless_access_point', item('appliedenergistics2:wireless_access_point'), [
        [null, metaitem('emitter.ev'), null],
        [metaitem('sensor.ev'), ore('circuitEv'), null],
        [null, null, item('appliedenergistics2:part:16')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/security_station', item('appliedenergistics2:security_station'), [
        [ore('plateTitanium'), item('appliedenergistics2:chest'), ore('plateTitanium')],
        [item('appliedenergistics2:part:16'), ore('circuitEv'), item('appliedenergistics2:part:16')],
        [ore('plateTitanium'), ore('plateTitanium'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/storage_drive', item('appliedenergistics2:drive'), [
        [ore('plateTitanium'), ore('circuitEv'), ore('plateTitanium')],
        [item('appliedenergistics2:part:16'), null, item('appliedenergistics2:part:16')],
        [ore('plateTitanium'), ore('circuitEv'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/storage_chest', item('appliedenergistics2:chest'), [
        [ore('plateGlass'), item('appliedenergistics2:part:380'), ore('plateGlass')],
        [item('appliedenergistics2:material:43'), null, item('appliedenergistics2:material:44')],
        [ore('plateTitanium'), ore('circuitEv'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/interfaces_interface', item('appliedenergistics2:interface'), [
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')],
        [item('appliedenergistics2:material:44'), metaitem('robot.arm.ev'), item('appliedenergistics2:material:43')],
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/fluid_interfaces_interface', item('appliedenergistics2:fluid_interface'), [
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')],
        [item('appliedenergistics2:material:44'), metaitem('electric.pump.ev'), item('appliedenergistics2:material:43')],
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/io_port', item('appliedenergistics2:io_port'), [
        [ore('plateGlass'), ore('plateGlass'), ore('plateGlass')],
        [item('appliedenergistics2:part:16'), item('appliedenergistics2:drive'), item('appliedenergistics2:part:16')],
        [ore('plateTitanium'), ore('circuitEv'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/spatial_io_port', item('appliedenergistics2:spatial_io_port'), [
        [ore('plateGlass'), ore('plateGlass'), ore('plateGlass')],
        [item('appliedenergistics2:part:16'), item('appliedenergistics2:io_port'), item('appliedenergistics2:part:16')],
        [ore('plateTitanium'), ore('circuitEv'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/cell_workbench', item('appliedenergistics2:cell_workbench'), [
        [ore('plateTitanium'), ore('circuitEv'), ore('plateTitanium')],
        [ore('plateTitanium'), ore('chestWood'), ore('plateTitanium')],
        [ore('plateTitanium'), ore('plateTitanium'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/blocks/energy_energy_acceptor', item('appliedenergistics2:energy_acceptor'), [
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')],
        [item('appliedenergistics2:part:16'), metaitem('energy_hatch.input.ev'), item('appliedenergistics2:part:16')],
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')]
])


crafting.replaceShaped('appliedenergistics2:network/parts/export_bus', item('appliedenergistics2:part:260'), [
        [null, null, null],
        [ore('plateTitanium'), item('appliedenergistics2:material:43'), ore('plateTitanium')],
        [ore('plateTitanium'), metaitem('conveyor.module.ev'), ore('plateTitanium')]
])

crafting.replaceShaped('appliedenergistics2:network/parts/export_bus_fluid', item('appliedenergistics2:part:261'), [
        [null, null, null],
        [ore('plateTitanium'), item('appliedenergistics2:material:43'), ore('plateTitanium')],
        [ore('plateTitanium'), metaitem('electric.pump.ev'), ore('plateTitanium')]
])


crafting.replaceShaped('appliedenergistics2:network/parts/panels_semi_dark_monitor', item('appliedenergistics2:part:180'), [
        [null, null, null],
        [item('appliedenergistics2:part:16'), metaitem('cover.screen'), item('appliedenergistics2:part:16')],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:network/parts/terminals', item('appliedenergistics2:part:380'), [
        [null, null, null],
        [item('appliedenergistics2:material:43'), ore('itemIlluminatedPanel'), item('appliedenergistics2:material:44')],
        [null, item('appliedenergistics2:part:16'), null]
])

crafting.replaceShaped('appliedenergistics2:network/crafting/molecular_assembler', item('appliedenergistics2:molecular_assembler'), [
        [ore('plateTitanium'), ore('plateGlass'), ore('plateTitanium')],
        [ore('plateGlass'), metaitem('pattern.processor'), ore('plateGlass')],
        [ore('plateTitanium'), ore('plateGlass'), ore('plateTitanium')]
])

crafting.replaceShapeless('appliedenergistics2:network/parts/terminals_interface', item('appliedenergistics2:part:480'), [ore('itemIlluminatedPanel'), item('appliedenergistics2:interface')])

crafting.replaceShapeless('appliedenergistics2:network/parts/terminals_crafting', item('appliedenergistics2:part:360'), [item('appliedenergistics2:part:380'), item('minecraft:crafting_table')])

crafting.replaceShapeless('appliedenergistics2:network/parts/storage_bus', item('appliedenergistics2:part', 220), [item('appliedenergistics2:interface'), metaitem('conveyor.module.ev')])

crafting.replaceShapeless('appliedenergistics2:network/parts/storage_bus_fluid', item('appliedenergistics2:part', 221), [item('appliedenergistics2:fluid_interface'), metaitem('electric.pump.ev')])

//Cards
crafting.replaceShapeless('appliedenergistics2:materials/cardredstone', item('appliedenergistics2:material:26'), [item('appliedenergistics2:material:25')])
crafting.replaceShapeless('appliedenergistics2:materials/cardcrafting', item('appliedenergistics2:material:53'), [item('appliedenergistics2:material:26')])
crafting.replaceShapeless('appliedenergistics2:materials/cardcapacity', item('appliedenergistics2:material:27'), [item('appliedenergistics2:material:53')])
//crafting.addShapeless('appliedenergistics2:recycle_card', item('appliedenergistics2:material:25'), [item('appliedenergistics2:material:27')])

crafting.replaceShapeless('appliedenergistics2:materials/cardspeed', item('appliedenergistics2:material:30'), [item('appliedenergistics2:material:28')])
crafting.replaceShapeless('appliedenergistics2:materials/cardpatternexpansion', item('appliedenergistics2:material:58'), [item('appliedenergistics2:material:30')])
crafting.replaceShapeless('appliedenergistics2:materials/cardinverter', item('appliedenergistics2:material:31'), [item('appliedenergistics2:material:58')])
crafting.replaceShapeless('appliedenergistics2:materials/cardfuzzy', item('appliedenergistics2:material:29'), [item('appliedenergistics2:material:31')])
//crafting.replaceShapeless('wct:magnet_card', item('wct:magnet_card'), [item('appliedenergistics2:material:29')])
//crafting.addShapeless('appliedenergistics2:recycle_advcard', item('appliedenergistics2:material:28'), [item('wct:magnet_card')])

crafting.replaceShapeless('appliedenergistics2:network/cells/view_cell_storage', item('appliedenergistics2:view_cell'), [item('appliedenergistics2:material', 39), metaitem('cover.screen')])

crafting.replaceShapeless('appliedenergistics2:network/parts/terminals_pattern', item('appliedenergistics2:part', 340), [item('appliedenergistics2:part', 360), item('appliedenergistics2:interface')])
crafting.replaceShapeless('appliedenergistics2:network/parts/terminals_fluid', item('appliedenergistics2:part', 520), [item('appliedenergistics2:part', 380), ore('bucket')])

crafting.replaceShaped('appliedenergistics2:network/parts/terminal_expanded_processing', item('appliedenergistics2:part', 341), [
        [null, null, null],
        [item('appliedenergistics2:part', 340), item('appliedenergistics2:part', 16), item('appliedenergistics2:part', 340)],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:network/cables/dense_smart_fluix', item('appliedenergistics2:part', 76), [
        [item('appliedenergistics2:part', 56), item('appliedenergistics2:part', 56), null],
        [item('appliedenergistics2:part', 56), item('appliedenergistics2:part', 56), null],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:network/parts/cable_anchor', item('appliedenergistics2:part', 120) * 4, [
        [ore('boltSteel'), ore('boltSteel'), null],
        [null, null, null],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:network/wireless_terminal', item('appliedenergistics2:wireless_terminal'), [
        [null, item('appliedenergistics2:wireless_access_point'), null],
        [null, item('appliedenergistics2:part', 380), null],
        [null, item('appliedenergistics2:dense_energy_cell'), null]
])

crafting.replaceShaped('appliedenergistics2:tools/network_tool', item('appliedenergistics2:network_tool'), [
        [ore('itemIlluminatedPanel'), ore('chestWood'), null],
        [ore('itemQuartzWrench'), ore('circuitEv'), null],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:tools/network_color_applicator', item('appliedenergistics2:color_applicator'), [
        [item('appliedenergistics2:material', 43), ore('plateTitanium'), null],
        [ore('plateTitanium'), item('appliedenergistics2:material', 36), null],
        [null, null, item('appliedenergistics2:energy_cell')]
])

crafting.replaceShaped('appliedenergistics2:tools/matter_cannon', item('appliedenergistics2:matter_cannon'), [
        [ore('plateTitanium'), ore('plateTitanium'), item('appliedenergistics2:material', 43)],
        [item('appliedenergistics2:material', 36), item('appliedenergistics2:energy_cell'), null],
        [ore('plateTitanium'), null, null]
])

crafting.replaceShaped('appliedenergistics2:tools/misctools_charged_staff', item('appliedenergistics2:charged_staff'), [
        [metaitem('emitter.ev'), null, null],
        [null, ore('stickTitanium'), null],
        [null, null, item('appliedenergistics2:energy_cell')]
])

crafting.replaceShaped('appliedenergistics2:tools/misctools_entropy_manipulator', item('appliedenergistics2:entropy_manipulator'), [
        [metaitem('emitter.ev'), item('appliedenergistics2:material', 43), null],
        [item('appliedenergistics2:material', 44), ore('stickTitanium'), null],
        [null, null, item('appliedenergistics2:energy_cell')]
])

//crafting.replaceShapeless('wct:wct', item('wct:wct'), [item('appliedenergistics2:part', 360), item('appliedenergistics2:wireless_terminal')])
//crafting.replaceShapeless('wft:wft', item('wft:wft'), [item('appliedenergistics2:part', 520), item('appliedenergistics2:wireless_terminal')])
//crafting.replaceShapeless('wit:wit', item('wit:wit'), [item('appliedenergistics2:part', 440), item('appliedenergistics2:wireless_terminal')])
//crafting.replaceShapeless('wpt:wpt', item('wpt:wpt'), [item('appliedenergistics2:part', 340), item('appliedenergistics2:wireless_terminal')])

//GT Machines Recipes

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateStainlessSteel') * 4)
        .inputs(ore('wireFineGold') * 4)
        .inputs(ore('wireFineSilver') * 4)
        .inputs(ore('plateCertusQuartz'))
        .inputs(item('appliedenergistics2:part', 16))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:material', 39))
        .duration(80)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateStainlessSteel') * 1)
        .inputs(ore('wireFinePlatinum') * 1)
        .inputs(metaitem('pattern.memory'))
        .inputs(item('appliedenergistics2:part', 16))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:material', 52))
        .duration(80)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateNaquadahAlloy') * 4)
        .inputs(ore('wireFineGold') * 4)
        .inputs(ore('wireFineSilver') * 4)
        .inputs(ore('plateCertusQuartz'))
        .inputs(item('appliedenergistics2:part', 16))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('extracells:storage.casing'))
        .duration(80)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(ore('gemExquisiteFluix'))
        .inputs(ore('wireFineSilver'))
        .inputs(ore('plateTitanium'))
        .inputs(ore('plateCertusQuartz'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:part', 460))
        .duration(80)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('frameGtTitanium'))
        .inputs(ore('plateTitanium'))
        .inputs(ore('plateCertusQuartz'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:big_assembler'))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('gregtech:multiblock_casing', 2))
        .inputs(ore('plateTitanium'))
        .inputs(ore('plateCertusQuartz'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:big_assembler', 1))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('threng:big_assembler'))
        .inputs(ore('plateTitanium'))
        .inputs(item('appliedenergistics2:molecular_assembler'))
        .inputs(item('appliedenergistics2:part', 16) * 2)
        .inputs(item('appliedenergistics2:interface'))
        .inputs(ore('circuitEv'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:big_assembler', 2))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('threng:big_assembler'))
        .inputs(ore('plateTitanium'))
        .inputs(item('appliedenergistics2:part', 16) * 2)
        .inputs(item('appliedenergistics2:interface'))
        .inputs(metaitem('pattern.memory'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:big_assembler', 3))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('threng:big_assembler'))
        .inputs(ore('plateTitanium'))
        .inputs(item('appliedenergistics2:part', 16) * 2)
        .inputs(item('appliedenergistics2:interface'))
        .inputs(item('appliedenergistics2:crafting_accelerator'))
        .inputs(metaitem('pattern.processor'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:big_assembler', 4))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('threng:big_assembler'))
        .inputs(ore('plateTitanium'))
        .inputs(item('appliedenergistics2:part', 16) * 2)
        .inputs(item('appliedenergistics2:interface'))
        .inputs(item('appliedenergistics2:io_port'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:big_assembler', 5))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateTitanium'))
        .inputs(metaitem('plate.power_integrated_circuit'))
        .inputs(metaitem('storage.segment'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:energy_cell'))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateTitanium'))
        .inputs(metaitem('plate.high_power_integrated_circuit'))
        .inputs(metaitem('storage.segment') * 8)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:dense_energy_cell'))
        .duration(100)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('rs_ctr:edge_trigger'))
        .inputs(item('appliedenergistics2:part', 280) * 2)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:part', 80))
        .duration(20)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('hull.iv'))
        .inputs(ore('circuitIv'))
        .inputs(item('appliedenergistics2:interface'))
        .inputs(item('appliedenergistics2:crafting_accelerator') * 2)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:machine', 3))
        .duration(100)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('hull.iv'))
        .inputs(ore('circuitIv'))
        .inputs(item('appliedenergistics2:material', 53))
        .inputs(item('appliedenergistics2:part', 280) * 3)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('threng:machine', 4))
        .duration(100)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('hull.ev'))
        .inputs(ore('circuitEv'))
        .inputs(ore('plateTitanium') * 2)
        .inputs(ore('wireFineGold') * 2)
        .inputs(ore('gemExquisiteFluix') * 4)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:controller'))
        .duration(200)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateTitanium') * 4)
        .inputs(ore('stickTitanium') * 4)
        .inputs(ore('gemExquisiteFluix'))
        .inputs(item('appliedenergistics2:material', 43))
        .inputs(item('appliedenergistics2:material', 44))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:spatial_pylon'))
        .duration(140)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateStainlessSteel'))
        .inputs(ore('wireFineGold'))
        .inputs(ore('wireFineRedAlloy'))
        .inputs(ore('circuitHv'))
        .circuitMeta(1)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:memory_card'))
        .duration(80)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateStainlessSteel'))
        .inputs(ore('wireFineGold'))
        .inputs(ore('wireFineRedAlloy'))
        .inputs(ore('circuitHv'))
        .circuitMeta(2)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:biometric_card'))
        .duration(80)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateRhodiumPlatedPalladium'))
        .inputs(metaitem('emitter.luv'))
        .inputs(metaitem('sensor.luv'))
        .inputs(ore('circuitLuv'))
        .inputs(item('appliedenergistics2:part', 16) * 4)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:material', 42))
        .duration(80)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

Globals.wireCoatings.each { key, val ->
        mods.gregtech.assembler.recipeBuilder()
                .inputs(item('appliedenergistics2:part', 16))
                .circuitMeta(1)
                .fluidInputs(fluid(key) * val)
                .outputs(item('appliedenergistics2:part', 36))
                .duration(40)
                .EUt(Globals.voltAmps[2])
                .buildAndRegister()

        mods.gregtech.assembler.recipeBuilder()
                .inputs(item('appliedenergistics2:part', 16))
                .inputs(ore('wireFineBorosilicateGlass'))
                .circuitMeta(2)
                .fluidInputs(fluid(key) * val)
                .outputs(item('appliedenergistics2:part', 56))
                .duration(40)
                .EUt(Globals.voltAmps[2])
                .buildAndRegister()
}

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('wireFineRedAlloy'))
        .inputs(item('appliedenergistics2:part', 16))
        .circuitMeta(1)
        .fluidInputs(fluid('red_alloy') * 144)
        .outputs(item('appliedenergistics2:part', 280) * 8)
        .duration(80)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('wireFineRedAlloy'))
        .inputs(item('appliedenergistics2:part', 16))
        .circuitMeta(2)
        .fluidInputs(fluid('red_alloy') * 144)
        .outputs(item('appliedenergistics2:part', 281) * 8)
        .duration(80)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

def quartz_dusts = [
        'dustCertusQuartz',
        'dustNetherQuartz',
        'dustQuartzite'
]

for(quartz in quartz_dusts) {
        mods.gregtech.electric_blast_furnace.recipeBuilder()
                .inputs(ore(quartz) * 60)
                .circuitMeta(1)
                .outputs(item('appliedenergistics2:quartz_glass') * 60)
                .blastFurnaceTemp(2500)
                .duration(1200)
                .EUt(60)
                .buildAndRegister();

        mods.gregtech.electric_blast_furnace.recipeBuilder()
                .inputs(ore(quartz) * 60)
                .inputs(ore('dustGlowstone') * 1)
                .outputs(item('appliedenergistics2:quartz_vibrant_glass') * 60)
                .blastFurnaceTemp(2500)
                .duration(1200)
                .EUt(60)
                .buildAndRegister();
}

//TODO: Add alien storage segments item

//Item cells
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 1)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('appliedenergistics2:material:35'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitIv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 4)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('appliedenergistics2:material:36'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitLuv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 16)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('appliedenergistics2:material:37'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[6])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitZpm'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 64)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('appliedenergistics2:material:38'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[7])
        .buildAndRegister()

//TODO: Replace wafers with advanced memory plates 

//Extracells item storage
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 1)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('extracells:storage.component:0'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[8])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUhv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 4)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('extracells:storage.component:1'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[9])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUev'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 16)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('extracells:storage.component:2'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[10])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUiv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 64)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(1)
        .outputs(item('extracells:storage.component:3'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[11])
        .buildAndRegister()


//Fluid cells
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 1)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('appliedenergistics2:material:54'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitIv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 4)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('appliedenergistics2:material:55'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitLuv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 16)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('appliedenergistics2:material:56'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[6])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitZpm'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 64)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('appliedenergistics2:material:57'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[7])
        .buildAndRegister()

//Extracells fluid storage
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 1)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('extracells:storage.component:8'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[8])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUhv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 4)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('extracells:storage.component:9'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[9])
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitUev'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.advanced_random_access_memory') * 1)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(2)
        .outputs(item('extracells:storage.component:10'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(Globals.voltAmps[10])
        .buildAndRegister()


//Spatial cells
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitIv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 1)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(3)
        .outputs(item('appliedenergistics2:material:32'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(7680)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitLuv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 4)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(3)
        .outputs(item('appliedenergistics2:material:33'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(30720)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitZpm'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('plate.random_access_memory') * 16)
        .inputs(metaitem('storage.segment') * 1)
        .circuitMeta(3)
        .outputs(item('appliedenergistics2:material:34'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(122880)
        .buildAndRegister()

def circuits_list = [
        'circuitEv',
        'circuitIv',
        'circuitLuv',
        'circuitZpm',
        'circuitUv'
]

int i = 0
solder = fluid('soldering_alloy') * 72

for (circuit in circuits_list) {
        mods.gregtech.assembler.recipeBuilder()
                .inputs(ore(circuit) * 4)
                .inputs(ore('plateTitanium') * 8)
                .inputs(item('appliedenergistics2:part:16') * 16)
                .circuitMeta(1)
                .fluidInputs(solder)
                .outputs(item('appliedenergistics2:crafting_unit') * (4 << i))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(480 * (4 << i))
                .buildAndRegister()
        i++
}

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:crafting_accelerator'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('appliedenergistics2:material:35'))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:crafting_storage_1k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('appliedenergistics2:material:36'))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:crafting_storage_4k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('appliedenergistics2:material:37'))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:crafting_storage_16k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('appliedenergistics2:material:38'))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:crafting_storage_64k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('extracells:storage.component', 0))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('extracpus:crafting_storage_256k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('extracells:storage.component', 1))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('extracpus:crafting_storage_1024k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('extracells:storage.component', 2))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('extracpus:crafting_storage_4096k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(item('extracells:storage.component', 3))
        .inputs(ore('wireFineSilver') * 2)
        .inputs(item('appliedenergistics2:crafting_unit'))
        .fluidInputs(solder)
        .outputs(item('extracpus:crafting_storage_16384k'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(metaitem('circuit_board.plastic'))
        .inputs(ore('circuitHv'))
        .inputs(ore('wireFineElectrum') * 4)
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:material:25'))
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(metaitem('circuit_board.advanced'))
        .inputs(ore('circuitEv'))
        .inputs(ore('wireFinePlatinum') * 4)
        .fluidInputs(solder)
        .outputs(item('appliedenergistics2:material:28'))
        .duration(80)
        .EUt(1920)
        .buildAndRegister()

for (int n = 20; n < 36; n++) {
        mods.gregtech.chemical_bath.recipeBuilder()
                .inputs(item('appliedenergistics2:part', n))
                .outputs(item('appliedenergistics2:part', 36))
                .fluidInputs(fluid('water') * 100)
                .duration(20)
                .EUt(Globals.voltAmps[0])
                .buildAndRegister()
}

for (int n = 40; n < 56; n++) {
        mods.gregtech.chemical_bath.recipeBuilder()
                .inputs(item('appliedenergistics2:part', n))
                .outputs(item('appliedenergistics2:part', 56))
                .fluidInputs(fluid('water') * 100)
                .duration(20)
                .EUt(Globals.voltAmps[0])
                .buildAndRegister()
}

for (int n = 60; n < 76; n++) {
        mods.gregtech.chemical_bath.recipeBuilder()
                .inputs(item('appliedenergistics2:part', n))
                .outputs(item('appliedenergistics2:part', 76))
                .fluidInputs(fluid('water') * 100)
                .duration(20)
                .EUt(Globals.voltAmps[0])
                .buildAndRegister()
}

for (int n = 500; n < 516; n++) {
        mods.gregtech.chemical_bath.recipeBuilder()
                .inputs(item('appliedenergistics2:part', n))
                .outputs(item('appliedenergistics2:part', 516))
                .fluidInputs(fluid('water') * 100)
                .duration(20)
                .EUt(Globals.voltAmps[0])
                .buildAndRegister()
}