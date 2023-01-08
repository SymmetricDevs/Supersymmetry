import com.cleanroommc.groovyscript.api.GroovyLog
import gregtech.api.metatileentity.multiblock.CleanroomType
import static globals.Globals.*

def circuit(x) {
        return metaitem('circuit.integrated').withNbt([Configuration: x])
}

println("Running AppliedEnergistics.groovy...")

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
        'appliedenergistics2:network/cells/spatial_components_1'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('appliedenergistics2:misc/grindstone', item('appliedenergistics2:grindstone'), [
        [ore('stone'), ore('gearWood'), ore('stone')],
        [ore('gemFlint'), ore('stone'), ore('gemFlint')],
        [ore('cobblestone'), ore('gemFlint'), ore('cobblestone')]
])

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
        [item('appliedenergistics2:material:44'), null, item('appliedenergistics2:material:43')],
        [ore('plateTitanium'), item('appliedenergistics2:part:16'), ore('plateTitanium')]
])

//GT Machines Recipes

def quartz_dusts = [
        'dustCertusQuartz',
        'dustNetherQuartz',
        'dustQuartzite'
]

for(quartz in quartz_dusts) {
        mods.gregtech.electric_blast_furnace.recipeBuilder()
                .inputs(ore(quartz) * 60)
                .notConsumable(circuit(1))
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
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(1))
        .outputs(item('appliedenergistics2:material:35'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitIv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(1))
        .outputs(item('appliedenergistics2:material:36'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(7680)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitLuv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(1))
        .outputs(item('appliedenergistics2:material:37'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(30720)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitZpm'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(1))
        .outputs(item('appliedenergistics2:material:38'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(122880)
        .buildAndRegister()

//Fluid cells
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitEv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(2))
        .outputs(item('appliedenergistics2:material:54'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(1920)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitIv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(2))
        .outputs(item('appliedenergistics2:material:55'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(7680)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitLuv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(2))
        .outputs(item('appliedenergistics2:material:56'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(30720)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitZpm'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(2))
        .outputs(item('appliedenergistics2:material:57'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(122880)
        .buildAndRegister()

//Spatial cells
mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitIv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(3))
        .outputs(item('appliedenergistics2:material:32'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(7680)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitLuv'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(3))
        .outputs(item('appliedenergistics2:material:33'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(30720)
        .buildAndRegister()

mods.gregtech.circuit_assembler.recipeBuilder()
        .inputs(ore('circuitZpm'))
        .inputs(ore('wireFineSilver') * 4)
        .inputs(metaitem('wafer.random_access_memory') * 4)
        .notConsumable(circuit(3))
        .outputs(item('appliedenergistics2:material:34'))
        .cleanroom(CleanroomType.CLEANROOM)
        .duration(200)
        .EUt(122880)
        .buildAndRegister()