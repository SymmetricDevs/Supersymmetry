import static prePostInit.Recipemaps.*
import globals.Batteries
import static gregtech.api.GTValues.*
import gregtech.api.capability.GregtechCapabilities
import gregtech.api.capability.IElectricItem

log.infoMC("Running PoweredTools.groovy...")

def setChargeFromBatteryFn = { output, inputs, info ->
    def batteryTag = inputs['battery']?.getTagCompound()
    if (batteryTag != null) {
        output.getTagCompound().setLong("Charge", batteryTag.getLong("Charge"))
    }
}

// LV Batteries
Batteries[LV].each { battery ->
    // Item Magnet
    crafting.shapedBuilder()
        .name("gregtech:lv_magnet_${battery.name}")
        .output(battery.imprintCapacity(metaitem('item_magnet.lv')))
        .shape([
            [ore('stickSteelMagnetic'), ore('toolWrench'), ore('stickSteelMagnetic')],
            [ore('stickSteelMagnetic'), battery.fetchMetaitem().mark('battery'), ore('stickSteelMagnetic')],
            [ore('cableGtSingleTin'), ore('plateSteel'), ore('cableGtSingleTin')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Prospector's Scanner
    crafting.shapedBuilder()
        .name("gregtech:prospector_${battery.name}")
        .output(battery.imprintCapacity(metaitem('prospector.lv')))
        .shape([
            [metaitem('emitter.lv'), ore('plateSteel'), metaitem('sensor.lv')],
            [ore('circuitLv'), ore('plateGlass'), ore('circuitLv')],
            [ore('plateSteel'), battery.fetchMetaitem().mark('battery'), ore('plateSteel')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // NightVision Goggles
    crafting.shapedBuilder()
        .name("gregtech:nightvision_${battery.name}")
        .output(battery.imprintCapacity(metaitem('nightvision_goggles')))
        .shape([
            [ore('circuitUlv'), metaitem('screwSteel'), ore('circuitUlv')],
            [metaitem('ringRubber'), battery.fetchMetaitem().mark('battery'), metaitem('ringRubber')],
            [metaitem('lensGlass'), ore('toolScrewdriver'), metaitem('lensGlass')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Power Unit (manual craft)
    crafting.shapedBuilder()
        .name("gregtech:lv_power_unit_${battery.name}")
        .output(battery.imprintCapacity(metaitem('power_unit.lv')))
        .shape([
            [ore('screwSteel'), null, ore('toolScrewdriver')],
            [ore('gearSmallSteel'), metaitem('electric.motor.lv'), ore('gearSmallSteel')],
            [ore('plateSteel'), battery.fetchMetaitem().mark('battery'), ore('plateSteel')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Power Unit
    ASSEMBLER.recipeBuilder()
        .inputs(ore('gearSmallSteel') * 2)
        .inputs(ore('screwSteel'))
        .inputs(ore('plateSteel') * 2)
        .inputs(metaitem('electric.motor.lv'))
        .inputs(battery.fetchMetaitem())
        .outputs(battery.imprintCapacity(metaitem('power_unit.lv')))
        .EUt(VA[LV])
        .duration(150)
        .buildAndRegister()
}

// MV Batteries
Batteries[MV].each { battery ->
    // Tricorder Scanner
    crafting.shapedBuilder()
        .name("gregtech:tricorder_${battery.name}")
        .output(battery.imprintCapacity(metaitem('tricorder_scanner')))
        .shape([
            [metaitem('emitter.mv'), metaitem('plateAluminium'), metaitem('sensor.mv')],
            [ore('circuitHv'), metaitem('cover.screen'), ore('circuitHv')],
            [metaitem('plateAluminium'), battery.fetchMetaitem().mark('battery'), metaitem('plateAluminium')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Electric Jetpack (power capacity does not depend on battery)
    crafting.addShaped("gregtech:electric_jetpack_${battery.name}", metaitem('gregtech:electric_jetpack'), [
        [ore('toolWireCutter'), ore('circuitMv'), ore('toolScrewdriver')],
        [metaitem('power_thruster'), battery.fetchMetaitem(), metaitem('power_thruster')],
        [ore('wireGtDoubleAnnealedCopper'), null, ore('wireGtDoubleAnnealedCopper')]
    ])
    // Power Unit (manual craft)
    crafting.shapedBuilder()
        .name("gregtech:mv_power_unit_${battery.name}")
        .output(battery.imprintCapacity(metaitem('power_unit.mv')))
        .shape([
            [ore('screwAluminium'), null, ore('toolScrewdriver')],
            [ore('gearSmallAluminium'), metaitem('electric.motor.mv'), ore('gearSmallAluminium')],
            [ore('plateAluminium'), battery.fetchMetaitem().mark('battery'), ore('plateAluminium')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Power Unit
    ASSEMBLER.recipeBuilder()
        .inputs(ore('gearSmallAluminium') * 2)
        .inputs(ore('screwAluminium'))
        .inputs(ore('plateAluminium') * 2)
        .inputs(metaitem('electric.motor.mv'))
        .inputs(battery.fetchMetaitem())
        .outputs(battery.imprintCapacity(metaitem('power_unit.mv')))
        .EUt(VA[MV])
        .duration(150)
        .buildAndRegister()
}

// HV Batteries
Batteries[HV].each { battery ->
    // Electric Jetpack (power capacity does not depend on battery)
    crafting.addShaped("gregtech:electric_jetpack_advanced_${battery.name}", metaitem('gregtech:advanced_electric_jetpack'), [
        [ore('toolWireCutter'), metaitem('electric_jetpack'), ore('toolScrewdriver')],
        [metaitem('power_thruster_advanced'), battery.fetchMetaitem(), metaitem('power_thruster_advanced')],
        [ore('wireGtQuadrupleGold'), ore('circuitHv'), ore('wireGtQuadrupleGold')]
    ])
    // Item Magnet
    crafting.shapedBuilder()
        .name("gregtech:hv_magnet_${battery.name}")
        .output(battery.imprintCapacity(metaitem('item_magnet.hv')))
        .shape([
            [ore('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), ore('stickNeodymiumAlloyMagnetic')],
            [ore('stickNeodymiumAlloyMagnetic'), battery.fetchMetaitem().mark('battery'), ore('stickNeodymiumAlloyMagnetic')],
            [ore('wireGtSingleGold'), ore('plateStainlessSteel'), ore('wireGtSingleGold')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Prospector's Scanner
    crafting.shapedBuilder()
        .name("gregtech:prospector_${battery.name}")
        .output(battery.imprintCapacity(metaitem('prospector.hv')))
        .shape([
            [metaitem('emitter.hv'), ore('plateStainlessSteel'), metaitem('sensor.hv')],
            [ore('circuitHv'), metaitem('cover.screen'), ore('circuitHv')],
            [ore('plateStainlessSteel'), battery.fetchMetaitem().mark('battery'), ore('plateStainlessSteel')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Power Unit (manual craft)
    crafting.shapedBuilder()
        .name("gregtech:hv_power_unit_${battery.name}")
        .output(battery.imprintCapacity(metaitem('power_unit.hv')))
        .shape([
            [ore('screwStainlessSteel'), null, ore('toolScrewdriver')],
            [ore('gearSmallStainlessSteel'), metaitem('electric.motor.hv'), ore('gearSmallStainlessSteel')],
            [ore('plateStainlessSteel'), battery.fetchMetaitem().mark('battery'), ore('plateStainlessSteel')]
        ])
        .recipeFunction(setChargeFromBatteryFn)
        .register()
    // Power Unit
    ASSEMBLER.recipeBuilder()
        .inputs(ore('gearSmallStainlessSteel') * 2)
        .inputs(ore('screwStainlessSteel'))
        .inputs(ore('plateStainlessSteel') * 2)
        .inputs(metaitem('electric.motor.hv'))
        .inputs(battery.fetchMetaitem())
        .outputs(battery.imprintCapacity(metaitem('power_unit.hv')))
        .EUt(VA[HV])
        .duration(150)
        .buildAndRegister()
}

// Power Units from non-reworked batteries

// Temporary function to set correct max charge of powered tool
ItemStack withMaxChargeFromBattery(ItemStack tool, ItemStack battery) {
    IElectricItem eiTool = tool?.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null)
    IElectricItem eiBattery = battery?.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null)
    if (eiTool == null || eiBattery == null)
        return tool

    eiTool.setMaxChargeOverride(eiBattery.getMaxCharge())
    return tool
}

// TODO: rework in future
[metaitem('battery.re.hv.lithium'), metaitem('battery.re.hv.cadmium')].each { battery ->
    ASSEMBLER.recipeBuilder()
        .inputs(ore('gearSmallStainlessSteel') * 2)
        .inputs(ore('screwStainlessSteel'))
        .inputs(ore('plateStainlessSteel') * 2)
        .inputs(metaitem('electric.motor.hv'))
        .inputs(battery)
        .outputs(withMaxChargeFromBattery(metaitem('power_unit.hv'), battery))
        .EUt(VA[HV])
        .duration(150)
        .buildAndRegister()
}

ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallTitanium') * 2)
    .inputs(ore('screwTitanium'))
    .inputs(ore('plateTitanium') * 2)
    .inputs(metaitem('electric.motor.ev'))
    .inputs(ore('batteryEv'))
    .outputs(metaitem('power_unit.ev'))
    .EUt(VA[EV])
    .duration(150)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('gearSmallTungstenSteel') * 2)
    .inputs(ore('screwTungstenSteel'))
    .inputs(ore('plateTungstenSteel') * 2)
    .inputs(metaitem('electric.motor.iv'))
    .inputs(ore('batteryIv'))
    .outputs(metaitem('power_unit.iv'))
    .EUt(VA[IV])
    .duration(150)
    .buildAndRegister()

// Jetpacks from non-reworked batteries

crafting.addShaped('gregtech:electric_jetpack_advanced1', metaitem('advanced_electric_jetpack'), [
    [ore('toolWireCutter'), metaitem('electric_jetpack'), ore('toolScrewdriver')],
    [metaitem('power_thruster_advanced'), metaitem('battery.re.hv.lithium'), metaitem('power_thruster_advanced')],
    [metaitem('wireGtQuadrupleGold'), ore('circuitHv'), metaitem('wireGtQuadrupleGold')]
])

crafting.addShaped('gregtech:electric_jetpack_advanced2', metaitem('advanced_electric_jetpack'), [
    [ore('toolWireCutter'), metaitem('electric_jetpack'), ore('toolScrewdriver')],
    [metaitem('power_thruster_advanced'), metaitem('battery.re.hv.cadmium'), metaitem('power_thruster_advanced')],
    [metaitem('wireGtQuadrupleGold'), ore('circuitHv'), metaitem('wireGtQuadrupleGold')]
])

// HV Item magnets non-reworked batteries

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.lithium', metaitem('item_magnet.hv'), [
    [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
    [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.lithium'), metaitem('stickNeodymiumAlloyMagnetic')],
    [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.cadmium', metaitem('item_magnet.hv'), [
    [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
    [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.cadmium'), metaitem('stickNeodymiumAlloyMagnetic')],
    [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_energy_crystal', metaitem('item_magnet.hv'), [
    [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
    [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('energy_crystal'), metaitem('stickNeodymiumAlloyMagnetic')],
    [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])
