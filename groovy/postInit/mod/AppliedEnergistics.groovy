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
                    .inputs(ore('wireGtSingleUraniumTriplatinum') * 4)
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



// Actual housing
ASSEMBLER.recipeBuilder()
        .inputs(metaitem('wing_panel.fiber_reinforced_epoxy') * 2)
        .inputs(ore('plateTitanium') * 4)
        .inputs(ore('screwTitanium') * 8)
        .inputs(ore('plateTungstenSteel') * 2)
        .inputs(metaitem('electric.pump.iv'))
        .inputs(ore('pipeNormalFluidTungstenSteel') * 2)
        .inputs(item('appliedenergistics2:part', 16))
        .fluidInputs(fluid('liquid_nitrogen') * 1000)
        .fluidInputs(fluid('cryogenic_solder') * 144)
        .circuitMeta(1)
        .outputs(item('appliedenergistics2:material', 39))
        .duration(400)
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
            .inputs(metaitem('fluorescent_light'))
            .outputs(item('appliedenergistics2:quartz_vibrant_glass') * 60)
            .blastFurnaceTemp(1400)
            .duration(1200)
            .EUt(60)
            .buildAndRegister()
}
// Illuminated Panel
ASSEMBLER.recipeBuilder()
        // gregtech:machine, 1667 = fluorescent light
        .inputs(item('gregtech:machine', 1667))
        .inputs(ore('cableGtSingleGold') * 2)
        .inputs(item('appliedenergistics2:quartz_glass'))
        .outputs(item('appliedenergistics2:part', 180)) // AE2 illuminated panel
        .circuitMeta(1)
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

// AE2 storage component metas: 35-38 = 1k/4k/16k/64k item components; 54-57 = fluid equivalents.
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
                .inputs(ore('wireGtSingleUraniumTriplatinum') * 8)
                .inputs(ore('foilIridium') * 4)
                .inputs(metaitem('battery.ni_mh.iv'))
                .outputs(item("appliedenergistics2:${type.output}"))
                .duration(200)
                .EUt(VA[cell.tier])
                .buildAndRegister()
    }
}

// AE2 material metas: 43 = formation core, 44 = annihilation core, 39 = drive housing.
// AE2 part metas: 240/241 = import buses, 260/261 = export buses, 280/281 = formation/annihilation planes.
// Core EV network: cable, terminals, buses, interfaces and chest.
[
        [output: item('appliedenergistics2:part', 240), cores: 1],
        [output: item('appliedenergistics2:part', 241), cores: 1],
        [output: item('appliedenergistics2:part', 260), cores: 1],
        [output: item('appliedenergistics2:part', 261), cores: 1],
        [output: item('appliedenergistics2:part', 280), cores: 1],
        [output: item('appliedenergistics2:part', 281), cores: 1],
        [output: item('appliedenergistics2:interface'), cores: 2],
        [output: item('appliedenergistics2:fluid_interface'), cores: 2],
        [output: item('appliedenergistics2:chest'), cores: 1]
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

// Four optical cables make the covered Fluix cable used by the network.
ASSEMBLER.recipeBuilder()
        .inputs(metaitem('cable.optical') * 4)
        .inputs(item('appliedenergistics2:quartz_glass') * 2)
        .inputs(ore('plateTitanium') * 2)
        .inputs(ore('wireGtSingleUraniumTriplatinum') * 4)
        .outputs(item('appliedenergistics2:part', 16) * 4)
        .duration(200)
        .EUt(VA[IV])
        .buildAndRegister()

// AE2 terminal part metas: 380 = terminal, 360 = crafting terminal, 340 = pattern terminal.
// Terminals use laminated-glass faces, iridium foil shielding and optical links.
[
        [output: 380, cores: 1],
        [output: 360, cores: 1],
        [output: 340, cores: 2]
].each { terminal ->
    ASSEMBLER.recipeBuilder()
            .inputs(ore('plateGlass') * 2)
            .inputs(ore('foilIridium') * 2)
            .inputs(metaitem('cable.optical') * 2)
            .inputs(item('appliedenergistics2:material', 43) * terminal.cores)
            .inputs(item('appliedenergistics2:material', 44) * terminal.cores)
            .inputs(ore('circuitEv'))
            .outputs(item('appliedenergistics2:part', terminal.output))
            .duration(300)
            .EUt(VA[EV])
            .buildAndRegister()
}

// Optical fiber production: high-purity silica -> preform -> strand -> cable.
ROASTER.recipeBuilder()
        .inputs(metaitem('dustHighPuritySilicon'))
        .fluidInputs(fluid('oxygen') * 2000)
        .outputs(metaitem('dustHighPuritySilica') * 3)
        .duration(200)
        .EUt(VA[HV])
        .buildAndRegister()

SOLIDIFIER.recipeBuilder()
        .fluidInputs(fluid('high_purity_silica') * 864)
        .notConsumable(metaitem('shape.mold.tube'))
        .outputs(metaitem('optical_fiber_preform.initial'))
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

CVD.recipeBuilder()
        .inputs(metaitem('optical_fiber_preform.initial'))
        .fluidInputs(fluid('silicon_tetrachloride') * 1990)
        .fluidInputs(fluid('germanium_tetrachloride') * 10)
        .fluidInputs(fluid('oxygen') * 4000)
        .outputs(metaitem('optical_fiber_preform'))
        .fluidOutputs(fluid('hydrogen_chloride') * 2000)
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(800)
        .EUt(VA[EV])
        .buildAndRegister()

EXTRUDER.recipeBuilder()
        .inputs(metaitem('optical_fiber_preform'))
        .notConsumable(metaitem('shape.extruder.wire'))
        .outputs(metaitem('fiber.optical') * 16)
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('fiber.optical') * 16)
        .fluidInputs(fluid('pmma') * 144)
        .outputs(metaitem('fiber.optical.coated') * 16)
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('fiber.optical.coated') * 16)
        .inputs(ore('foilExpandedPolytetrafluoroethylene') * 4)
        .inputs(ore('fiberKevlar') * 8)
        .inputs(ore('foilPolyvinylChloride') * 4)
        .outputs(metaitem('cable.optical') * 4)
        .duration(200)
        .EUt(VA[EV])
        .buildAndRegister()

// The energy acceptor does what it says.
ASSEMBLER.recipeBuilder()
        .inputs(ore('circuitEv') * 8)
        .inputs(ore('wireGtSingleUraniumTriplatinum') * 16) // EV superconducting links
        .inputs(metaitem('circuit.optical_processor') * 16)
        .inputs(metaitem('wing_panel.fiber_reinforced_epoxy') * 2)
        .inputs(ore('plateTungstenSteel') * 4)
        .inputs(item('appliedenergistics2:material', 43) * 4)
        .inputs(item('appliedenergistics2:material', 44) * 4)
        .inputs(metaitem('electric.pump.iv'))
        .inputs(ore('pipeNormalFluidTungstenSteel') * 2)
        .fluidInputs(fluid('liquid_helium') * 1000)
        .fluidInputs(fluid('cryogenic_solder') * 288)
        .outputs(item('appliedenergistics2:energy_acceptor'))
        .duration(800)
        .EUt(VA[EV])
        .buildAndRegister()

// Drive housing plus shielding, cooling and the network link.
ASSEMBLER.recipeBuilder()
        .inputs(item('appliedenergistics2:material', 39)) // AE2 drive housing
        .inputs(metaitem('cable.optical'))
        .inputs(ore('plateTungstenSteel') * 4)
        .inputs(ore('screwTungstenSteel') * 8)
        .inputs(metaitem('electric.pump.iv'))
        .inputs(ore('pipeNormalFluidTungstenSteel') * 2)
        .fluidInputs(fluid('liquid_nitrogen') * 1000)
        .fluidInputs(fluid('cryogenic_solder') * 144)
        .outputs(item('appliedenergistics2:drive'))
        .duration(400)
        .EUt(VA[EV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(item('appliedenergistics2:material', 39)) // AE2 drive housing
        .inputs(metaitem('cable.optical'))
        .inputs(ore('plateUranium238') * 4)
        .inputs(ore('screwTungstenSteel') * 8)
        .inputs(metaitem('electric.pump.iv'))
        .inputs(ore('pipeNormalFluidTungstenSteel') * 2)
        .fluidInputs(fluid('liquid_helium') * 1000)
        .fluidInputs(fluid('cryogenic_solder') * 144)
        .outputs(item('appliedenergistics2:drive') * 2)
        .duration(400)
        .EUt(VA[EV])
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('circuitIv') * 32)
        .inputs(metaitem('frameTungstenSteel'))
        .inputs(metaitem('electric.pump.iv') * 2)
        .inputs(ore('pipeNormalFluidTungstenSteel') * 4)
        .fluidInputs(fluid('fc_75') * 1000)
        .fluidInputs(fluid('cryogenic_solder') * 288)
        .outputs(item('appliedenergistics2:crafting_unit'))
        .duration(800)
        .EUt(VA[IV])
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
        .inputs(metaitem('pattern.memory'))
        .inputs(metaitem('pattern.processor'))
        .inputs(metaitem('cable.optical'))
        .inputs(ore('plateTitanium'))
        .fluidInputs(fluid('cryogenic_solder') * 144)
        .outputs(item('appliedenergistics2:material', 52) * 2) // AE2 blank pattern
        .duration(400)
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
            .inputs(ore('plateTungstenSteel') * 2)
            .inputs(metaitem('electric.pump.ev'))
            .inputs(ore('pipeNormalFluidTungstenSteel'))
            .fluidInputs(fluid('liquid_nitrogen') * 500)
            .fluidInputs(fluid('cryogenic_solder') * 144)
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
