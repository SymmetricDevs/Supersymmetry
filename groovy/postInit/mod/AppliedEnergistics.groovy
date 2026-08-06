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
        'appliedenergistics2:network/parts/planes_annihilatition_identity',
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
                .inputs(metaitem('plate.random_access_memory') * component.ramCount)
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

