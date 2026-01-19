import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

crafting.removeByOutput(metaitem('component.resistor'))

// SMD Resistor * 32
mods.gregtech.assembler.removeByInput(480, [metaitem('dustCarbon'), metaitem('wireFineTantalum') * 4], [fluid('plastic') * 288])
// SMD Resistor * 16
mods.gregtech.assembler.removeByInput(480, [metaitem('dustCarbon'), metaitem('wireFineElectrum') * 4], [fluid('plastic') * 288])
// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCoal'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100])
// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCharcoal'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100])
// Resistor * 2
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCarbon'), metaitem('wireFineCopper') * 4], [fluid('glue') * 100])
// Resistor * 4
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCoal'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100])
// Resistor * 4
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCharcoal'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100])
// Resistor * 4
mods.gregtech.assembler.removeByInput(6, [metaitem('dustCarbon'), metaitem('wireFineAnnealedCopper') * 4], [fluid('glue') * 100])

oreDict.add('resistorCarbon', metaitem('dustCarbon'))
oreDict.add('resistorCarbon', metaitem('dustHighPurityCarbon'))
oreDict.add('resistorCarbon', metaitem('dustGraphite'))

// Carbon composite (primitive)

MIXER.recipeBuilder()
    .inputs(ore('resistorCarbon'))
    .inputs(ore('dustClay'))
    .outputs(metaitem('dustCarbonCompound') * 2)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister();

COMPRESSOR.recipeBuilder()
    .inputs(ore('dustCarbonCompound'))
    .nonConsumable(metaitem('shape.mold.nugget'))
    .outputs(metaitem('component.resistor.unfired_carbon_composite') * 8)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister();

crafting.addShapeless("gregtech:ccr_core", metaitem('component.resistor.unfired_carbon_composite') * 8, [
    ore('resistorCarbon'),
    ore('dustClay'),
    metaitem('shape.mold.nugget')
])

furnace.add(metaitem('component.resistor.unfired_carbon_composite'), metaitem('component.resistor.fired_carbon_composite'))

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('glue') * 50)
    .input(metaitem('component.resistor.fired_carbon_composite'))
    .inputs(ore('wireFineCopper') * 2)
    .outputs(metaitem('component.resistor'))
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('glue') * 50)
    .input(metaitem('component.resistor.fired_carbon_composite'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .outputs(metaitem('component.resistor') * 2)
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister();

crafting.shapedBuilder()
    .name('resistor_wire')
    .output(metaitem('component.resistor'))
    .matrix('RPR',
        'WCW',
        ' P ')
    .key('R', metaitem('rubber_drop'))
    .key('P', item('minecraft:paper'))
    .key('W', ore('wireGtSingleCopper') | ore('wireFineCopper'))
    .key('C', metaitem('component.resistor.fired_carbon_composite'))
    .register()