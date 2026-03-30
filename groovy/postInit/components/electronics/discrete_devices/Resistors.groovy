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

// Oredicting

oreDict.add('componentResistorMedium', metaitem('component.resistor.carbon_composite'))
oreDict.add('componentResistorMedium', metaitem('component.resistor.carbon_film'))

oreDict.add('componentResistorSmall', metaitem('component.smd.resistor'))
oreDict.add('componentResistorSmall', metaitem('component.advanced_smd.resistor'))

// Carbon composite

oreDict.add('resistorCarbon', metaitem('dustCarbon'))
oreDict.add('resistorCarbon', metaitem('dustHighPurityCarbon'))
oreDict.add('resistorCarbon', metaitem('dustGraphite'))

MIXER.recipeBuilder()
    .inputs(ore('resistorCarbon'))
    .inputs(ore('dustClay'))
    .outputs(metaitem('dustCarbonCompound') * 2)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

COMPRESSOR.recipeBuilder()
    .inputs(ore('dustCarbonCompound'))
    .notConsumable(metaitem('shape.mold.nugget'))
    .outputs(metaitem('component.resistor.carbon_composite.unfired') * 8)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

crafting.addShapeless("gregtech:ccr_core", metaitem('component.resistor.carbon_composite.unfired') * 8, [
    ore('resistorCarbon'),
    ore('dustClay'),
    metaitem('shape.mold.nugget')
])

furnace.add(metaitem('component.resistor.carbon_composite.unfired'), metaitem('component.resistor.carbon_composite.fired'))

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_composite.fired'))
    .inputs(ore('wireFineCopper') * 2)
    .fluidInputs(fluid('glue') * 50)
    .fluidInputs(fluid('soldering_alloy') * 18)
    .outputs(metaitem('component.resistor.carbon_composite'))
    .duration(240)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_composite.fired'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('glue') * 50)
    .fluidInputs(fluid('soldering_alloy') * 18)
    .outputs(metaitem('component.resistor.carbon_composite'))
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

crafting.shapedBuilder()
    .name('resistor_wire')
    .output(metaitem('component.resistor.carbon_composite'))
    .matrix('RPR',
        'WCW',
        ' P ')
    .key('R', metaitem('rubber_drop'))
    .key('P', item('minecraft:paper'))
    .key('W', ore('wireGtSingleCopper') | ore('wireFineCopper'))
    .key('C', metaitem('component.resistor.carbon_composite.fired'))
    .register()

// Carbon film resistor

LASER_ENGRAVER.recipeBuilder()
    .inputs(ore('boltAlumina') * 20)
    .outputs(metaitem('component.resistor.carbon_film.cut_substrate') * 20)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

CVD.recipeBuilder()
    .fluidInputs(fluid('methane') * 1000)
    .inputs(metaitem('component.resistor.carbon_film.cut_substrate') * 20)
    .outputs(metaitem('component.resistor.carbon_film.core') * 20)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_film.core'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('phenolic_novolac_resin') * 50)
    .fluidInputs(fluid('soldering_alloy') * 18)
    .outputs(metaitem('component.resistor.carbon_film'))
    .duration(30)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_film.core'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('epoxy_resin') * 16)
    .fluidInputs(fluid('soldering_alloy') * 18)
    .outputs(metaitem('component.resistor.carbon_film'))
    .duration(10)
    .EUt(VA[MV])
    .buildAndRegister();
