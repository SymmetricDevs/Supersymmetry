import static prePostInit.Recipemaps.*
import globals.Globals
import com.cleanroommc.groovyscript.api.GroovyLog
import gregtech.api.metatileentity.multiblock.CleanroomType
import static gregtech.api.GTValues.*



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
        'nae2:item/material/storage/cell_part_256k',
        'nae2:item/material/storage/cell_part_1024k',
        'nae2:item/material/storage/cell_part_4096k',
        'nae2:item/material/storage/cell_part_16384k',
        'nae2:item/material/storage/cell_part_fluid_256k',
        'nae2:item/material/storage/cell_part_fluid_1024k',
        'nae2:item/material/storage/cell_part_fluid_4096k',
        'nae2:item/material/storage/cell_part_fluid_16384k',
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
        'appliedenergistics2:network/parts/planes_annihilation_identity',
        'appliedenergistics2:network/parts/import_bus_fluid',
        'appliedenergistics2:network/parts/import_bus',
        'nae2:block/crafting/storage_256k',
        'nae2:block/crafting/storage_1024k',
        'nae2:block/crafting/storage_4096k',
        'nae2:block/crafting/storage_16384k',
        'nae2:block/crafting/4x_coprocessor',
        'nae2:block/crafting/16x_coprocessor',
        'nae2:block/crafting/64x_coprocessor',
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
        'appliedenergistics2:network/parts/panels_semi_dark_monitor',
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
        'appliedenergistics2:network/blocks/spatial_io_port',
        'appliedenergistics2:tools/network_biometric_card',
        'appliedenergistics2:tools/network_memory_card',
        'appliedenergistics2:network/wireless_booster',
        'appliedenergistics2:network/blocks/interfaces_interface',
        'appliedenergistics2:network/blocks/interfaces_interface_alt',
        'appliedenergistics2:network/blocks/interfaces_interface_part',
        'appliedenergistics2:network/blocks/fluid_interfaces_interface',
        'appliedenergistics2:network/blocks/fluid_interfaces_interface_alt',
        'appliedenergistics2:network/blocks/fluid_interfaces_interface_part',
        'appliedenergistics2:network/blocks/storage_drive',
        'appliedenergistics2:network/blocks/storage_chest',
        'appliedenergistics2:network/blocks/energy_energy_acceptor',
        'appliedenergistics2:network/parts/storage_bus',
        'appliedenergistics2:network/parts/storage_bus_fluid',
        'appliedenergistics2:network/parts/terminals',
        'appliedenergistics2:network/parts/terminals_crafting',
        'appliedenergistics2:network/parts/terminals_pattern',
        'appliedenergistics2:network/crafting/molecular_assembler'
]

for (name in name_removals) {
    crafting.remove(name)
}
// Storage components
def storageComponents = [
        [circuit: 'circuitIv',  tier: IV,  ramCount: 1,  itemOutput: item('appliedenergistics2:material', 35), fluidOutput: item('appliedenergistics2:material', 54)],
        [circuit: 'circuitLuv', tier: LuV, ramCount: 4,  itemOutput: item('appliedenergistics2:material', 36), fluidOutput: item('appliedenergistics2:material', 55)],
        [circuit: 'circuitZpm', tier: ZPM, ramCount: 16, itemOutput: item('appliedenergistics2:material', 37), fluidOutput: item('appliedenergistics2:material', 56)],
        [circuit: 'circuitUv',  tier: UV,  ramCount: 64, itemOutput: item('appliedenergistics2:material', 38), fluidOutput: item('appliedenergistics2:material', 57)]
]

storageComponents.each { component ->
    [
            [circuitMeta: 1, output: component.itemOutput],
            [circuitMeta: 2, output: component.fluidOutput]
    ].each { storageType ->
        Globals.solders.each { solder, amount ->
            CIRCUIT_ASSEMBLER.recipeBuilder()
                    .inputs(ore(component.circuit))
                    .inputs(ore('wireFineSilver') * 4)
                    .inputs(metaitem('plate.random_access_memory') * component.ramCount)
                    .inputs(metaitem('storage.segment'))
                    .fluidInputs(fluid(solder) * amount)
                    .circuitMeta(storageType.circuitMeta)
                    .outputs(storageType.output)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(200)
                    .EUt(VA[component.tier])
                    .buildAndRegister()
        }
    }
}



//Spatial stuff. i dont understand it, but it seems to be a thing that exists in AE2. I guess its like a 3D storage cell or something.
def spatialStorageComponents = [
        [circuit: 'circuitUv',  tier: UV,  ramCount: 1,  output: item('appliedenergistics2:material', 32)],
        [circuit: 'circuitUhv', tier: UHV, ramCount: 4,  output: item('appliedenergistics2:material', 33)],
        [circuit: 'circuitUev', tier: UEV, ramCount: 16, output: item('appliedenergistics2:material', 34)]
]

spatialStorageComponents.each { component ->
    Globals.solders.each { solder, amount ->
        CIRCUIT_ASSEMBLER.recipeBuilder()
                .inputs(ore(component.circuit))
                .inputs(ore('wireFineSilver') * 4)
                .inputs(metaitem('plate.advanced_random_access_memory') * component.ramCount)
                .inputs(metaitem('storage.segment'))
                .fluidInputs(fluid(solder) * (amount * 2))
                .circuitMeta(3)
                .outputs(component.output)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(VA[component.tier])
                .buildAndRegister()
    }
}

crafting.replaceShaped('appliedenergistics2:network/blocks/spatial_io_port', item('appliedenergistics2:spatial_io_port'), [
        [ore('plateGlass'), ore('plateGlass'), ore('plateGlass')],
        [item('appliedenergistics2:part', 16), item('appliedenergistics2:io_port'), item('appliedenergistics2:part', 16)],
        [ore('plateTitanium'), ore('circuitUv'), ore('plateTitanium')]
])

ASSEMBLER.recipeBuilder()
        .inputs(ore('plateTitanium') * 4)
        .inputs(ore('stickTitanium') * 4)
        .inputs(ore('gemExquisiteFluix'))
        .inputs(item('appliedenergistics2:material', 43))
        .inputs(item('appliedenergistics2:material', 44))
        .inputs(ore('circuitUv'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(item('appliedenergistics2:spatial_pylon'))
        .duration(140)
        .EUt(VA[UV])
        .buildAndRegister()

// Actual housing
ASSEMBLER.recipeBuilder()
        .inputs(ore('plateTitanium') * 4)
        .inputs(metaitem('fused_quartz') * 2)
        .inputs(item('appliedenergistics2:part', 16))
        .fluidInputs(fluid('plastic') * 144)
        .circuitMeta(1)
        .outputs(item('appliedenergistics2:material', 39))
        .duration(200)
        .EUt(VA[IV])
        .buildAndRegister()
// Quartz glass: flame hydrolysis of SiCl4 followed by consolidation in a block mold
REACTION_FURNACE.recipeBuilder()
        .notConsumable(metaitem('shape.mold.block'))
        .fluidInputs(fluid('purified_silicon_tetrachloride') * 4000)
        .fluidInputs(fluid('hydrogen') * 8000)
        .fluidInputs(fluid('oxygen') * 4000)
        .outputs(item('appliedenergistics2:quartz_glass'))
        .fluidOutputs(fluid('hydrogen_chloride') * 16000)
        .duration(1600)
        .EUt(VA[MV])
        .buildAndRegister()

['dustCertusQuartz', 'dustNetherQuartz', 'dustQuartzite'].each { quartz ->
    mods.gregtech.electric_blast_furnace.recipeBuilder()
            .inputs(ore(quartz) * 60)
            .inputs(ore('dustGlowstone'))
            .outputs(item('appliedenergistics2:quartz_vibrant_glass') * 60)
            .blastFurnaceTemp(1400)
            .duration(1200)
            .EUt(60)
            .buildAndRegister()
}
// Illuminated Panel
ASSEMBLER.recipeBuilder()
        .inputs(item('gregtech:machine', 1667))
        .inputs(ore('cableGtSingleGold') * 2)
        .inputs(item('appliedenergistics2:quartz_glass'))
        .outputs(item('appliedenergistics2:part', 180))
        .circuitMeta(1)
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

// Finished item and fluid cells use the gated components above.
def storageCells = [
        [tier: IV,  circuit: 'circuitIv',  craftingTier: EV, craftingCircuit: 'circuitEv', component: 35, fluidComponent: 54, item: 'storage_cell_1k',  fluid: 'fluid_storage_cell_1k'],
        [tier: LuV, circuit: 'circuitLuv', component: 36, fluidComponent: 55, item: 'storage_cell_4k',  fluid: 'fluid_storage_cell_4k'],
        [tier: ZPM, circuit: 'circuitZpm', component: 37, fluidComponent: 56, item: 'storage_cell_16k', fluid: 'fluid_storage_cell_16k'],
        [tier: UV,  circuit: 'circuitUv',  component: 38, fluidComponent: 57, item: 'storage_cell_64k', fluid: 'fluid_storage_cell_64k']
]

storageCells.each { cell ->
    [
            [component: cell.component, output: cell.item],
            [component: cell.fluidComponent, output: cell.fluid]
    ].each { type ->
        ASSEMBLER.recipeBuilder()
                .inputs(item('appliedenergistics2:material', type.component))
                .inputs(item('appliedenergistics2:material', 39))
                .inputs(item('appliedenergistics2:quartz_glass') * 2)
                .inputs(ore('dustRedstone') * 2)
                .inputs(ore('ingotIron') * 3)
                .outputs(item("appliedenergistics2:${type.output}"))
                .duration(200)
                .EUt(VA[cell.tier])
                .buildAndRegister()
    }
}

def spatialCells = [
        [tier: UV,  component: 32, output: 'spatial_storage_cell_2_cubed'],
        [tier: UHV, component: 33, output: 'spatial_storage_cell_16_cubed'],
        [tier: UEV, component: 34, output: 'spatial_storage_cell_128_cubed']
]

spatialCells.each { cell ->
    ASSEMBLER.recipeBuilder()
            .inputs(item('appliedenergistics2:material', cell.component))
            .inputs(item('appliedenergistics2:material', 39))
            .inputs(item('appliedenergistics2:quartz_glass') * 2)
            .inputs(ore('dustRedstone') * 2)
            .inputs(ore('ingotIron') * 3)
            .outputs(item("appliedenergistics2:${cell.output}"))
            .duration(200)
            .EUt(VA[cell.tier])
            .buildAndRegister()
}

// Core EV network: cable, terminal, buses, interface, drive, chest and power entry.
[
        [output: item('appliedenergistics2:part', 16) * 4, cores: 0],
        [output: item('appliedenergistics2:part', 380), cores: 1],
        [output: item('appliedenergistics2:part', 360), cores: 1],
        [output: item('appliedenergistics2:part', 340), cores: 1],
        [output: item('appliedenergistics2:part', 240), cores: 1],
        [output: item('appliedenergistics2:part', 241), cores: 1],
        [output: item('appliedenergistics2:part', 260), cores: 1],
        [output: item('appliedenergistics2:part', 261), cores: 1],
        [output: item('appliedenergistics2:part', 280), cores: 1],
        [output: item('appliedenergistics2:part', 281), cores: 1],
        [output: item('appliedenergistics2:interface'), cores: 2],
        [output: item('appliedenergistics2:fluid_interface'), cores: 2],
        [output: item('appliedenergistics2:drive'), cores: 1],
        [output: item('appliedenergistics2:chest'), cores: 1],
        [output: item('appliedenergistics2:energy_acceptor'), cores: 0]
].each { device ->
    def recipe = ASSEMBLER.recipeBuilder()
            .inputs(ore('circuitEv'))
            .inputs(item('appliedenergistics2:quartz_glass'))
            .inputs(ore('plateTitanium') * 2)
    if (device.cores > 0) {
        recipe.inputs(item('appliedenergistics2:material', 43) * device.cores)
                .inputs(item('appliedenergistics2:material', 44) * device.cores)
    }
    recipe
            .outputs(device.output)
            .duration(200)
            .EUt(VA[EV])
            .buildAndRegister()
}

ASSEMBLER.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(item('appliedenergistics2:material', 43))
        .inputs(item('appliedenergistics2:material', 44))
        .inputs(ore('plateTitanium') * 4)
        .outputs(item('appliedenergistics2:crafting_unit'))
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(item('appliedenergistics2:crafting_unit'))
        .inputs(ore('circuitEv'))
        .inputs(item('appliedenergistics2:material', 43))
        .outputs(item('appliedenergistics2:crafting_accelerator'))
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(item('appliedenergistics2:quartz_glass'))
        .inputs(item('appliedenergistics2:material', 43))
        .outputs(item('appliedenergistics2:material', 52) * 2)
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

storageCells.each { cell ->
    ASSEMBLER.recipeBuilder()
            .inputs(item('appliedenergistics2:crafting_unit'))
            .inputs(item('appliedenergistics2:material', cell.component))
            .inputs(ore(cell.craftingCircuit ?: cell.circuit))
            .outputs(item("appliedenergistics2:crafting_storage_${cell.item - 'storage_cell_'}"))
            .duration(200)
            .EUt(VA[cell.craftingTier ?: cell.tier])
            .buildAndRegister()
}

// Lazy AE2's Mass Assembly Chamber replaces Molecular Assemblers for AE2 autocrafting.
[
        [output: 'ma_frame', cores: 0, count: 4],
        [output: 'ma_vent', cores: 0, count: 2],
        [output: 'ma_mod_pattern', cores: 1, count: 1],
        [output: 'ma_mod_cpu', cores: 1, count: 1],
        [output: 'ma_io_port', cores: 1, count: 1],
        [output: 'ma_controller', cores: 2, count: 1]
].each { part ->
    def recipe = ASSEMBLER.recipeBuilder()
            .inputs(ore('circuitEv'))
            .inputs(ore('plateTitanium') * 2)
    if (part.cores > 0) {
        recipe.inputs(item('appliedenergistics2:material', 43) * part.cores)
                .inputs(item('appliedenergistics2:material', 44) * part.cores)
    }
    recipe
            .outputs(item("threng:${part.output}") * part.count)
            .duration(200)
            .EUt(VA[EV])
            .buildAndRegister()
}
