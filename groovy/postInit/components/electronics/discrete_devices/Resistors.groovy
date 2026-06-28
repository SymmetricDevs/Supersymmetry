import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import globals.Sintering
import globals.semiconductors.Deposition
import globals.semiconductors.Lithography
import globals.semiconductors.Packaging
import globals.semiconductors.Etching
import gregtech.api.metatileentity.multiblock.CleanroomType

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
    .fluidInputs(fluid('phenolic_novolacs_resin') * 50)
    .fluidInputs(fluid('soldering_alloy') * 18)
    .outputs(metaitem('component.resistor.carbon_film'))
    .duration(30)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.resistor.carbon_film.core'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('epoxy') * 16)
    .fluidInputs(fluid('soldering_alloy') * 18)
    .outputs(metaitem('component.resistor.carbon_film'))
    .duration(10)
    .EUt(VA[MV])
    .buildAndRegister();

// thick/thin-film resistors

Sintering.nonPlasmaFuels().each { fuel ->
    Sintering.comburents.each { comburent ->
        SINTERING_OVEN.recipeBuilder()
            .inputs(metaitem('component.resistor.wafer.printed_pads'))
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('component.resistor.wafer.pads'))
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(240)
            .buildAndRegister()

        SINTERING_OVEN.recipeBuilder()
            .inputs(metaitem('component.thick_film_resistor.wafer.printed'))
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('component.thick_film_resistor.wafer.fired'))
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(240)
            .buildAndRegister()

        SINTERING_OVEN.recipeBuilder()
            .inputs(metaitem('component.thick_film_resistor.wafer.printed_coating'))
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('component.thick_film_resistor.wafer'))
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(240)
            .buildAndRegister()
    }
}

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('mesh.stainless_steel'))
    .notConsumable(metaitem('stencil.resistor'))
    .fluidInputs(fluid('acrylate_resist_mixture') * 50)
    .outputs(metaitem('screen_printing.pattern.resistor'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('mesh.stainless_steel'))
    .notConsumable(metaitem('stencil.resistor_pads'))
    .fluidInputs(fluid('acrylate_resist_mixture') * 50)
    .outputs(metaitem('screen_printing.pattern.resistor_pads'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

SCREEN_PRINTING.recipeBuilder()
    .notConsumable(metaitem('screen_printing.pattern.resistor_pads'))
    .inputs(metaitem('dustTinyCopper') * 5)
    .inputs(metaitem('plateAlumina'))
    .outputs(metaitem('component.resistor.wafer.printed_pads'))
    .duration(104)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()


SCREEN_PRINTING.recipeBuilder()
    .notConsumable(metaitem('screen_printing.pattern.resistor'))
    .inputs(metaitem('component.resistor.wafer.pads'))
    .fluidInputs(fluid('thick_film_resistor_ink') * 50)
    .outputs(metaitem('component.thick_film_resistor.wafer.printed'))
    .duration(104)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

LASER_ENGRAVER.recipeBuilder()
    .inputs(metaitem('component.thick_film_resistor.wafer.fired'))
    .outputs(metaitem('component.thick_film_resistor.wafer.etched'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

SCREEN_PRINTING.recipeBuilder()
    .notConsumable(metaitem('screen_printing.pattern.resistor'))
    .inputs(metaitem('component.thick_film_resistor.wafer.etched'))
    .inputs(metaitem('dustTinyGlass') * 5)
    .outputs(metaitem('component.thick_film_resistor.wafer.printed_coating'))
    .duration(104)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

Packaging.generateDicingRecipe("component.thick_film_resistor.wafer", "component.thick_film_resistor.unterminated", 32, 100, HV)

Deposition.generateSputteringRecipe("component.resistor.wafer.pads", "component.thin_film_resistor.wafer", ['chromium' : 120, 'nickel' : 480]) // NiCr vacuum deposition; 80/20 composition
Lithography.generatePhotolithographyRecipes("component.thin_film_resistor.wafer", "component.thin_film_resistor.wafer.patterned", "novolac_resist", "mask.resistor", false)
Etching.generateWetEtchingRecipe("component.thin_film_resistor.wafer.patterned", "component.thin_film_resistor.wafer.etched", "nichrome", 400, false)
Lithography.generateResistStrippingRecipes("component.thin_film_resistor.wafer.etched", "component.thin_film_resistor.wafer.stripped", 1, false, true) // don't know what timeMultiplier means

LASER_ENGRAVER.recipeBuilder()
    .inputs(metaitem('component.thin_film_resistor.wafer.stripped'))
    .outputs(metaitem('component.thin_film_resistor.wafer.tuned'))
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

Packaging.generateDicingRecipe("component.thin_film_resistor.wafer.tuned", "component.thin_film_resistor.unterminated", 32, 100, HV)

types = ["thick_film_resistor", "thin_film_resistor"]
for (type in types) {
    Sintering.nonPlasmaFuels().each { fuel ->
        Sintering.comburents.each { comburent ->
            SINTERING_OVEN.recipeBuilder()
                .inputs(metaitem('component.' + type + '.dipped') * 4)
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                .outputs(metaitem('component.' + type + '.terminated') * 4)
                .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                .duration(fuel.duration + comburent.duration)
                .EUt(VA[HV])
                .buildAndRegister()
        }
    }

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('component.' + type + '.polished') * 16)
        .fluidInputs(fluid('copper_frit_ink') * 10)
        .outputs(metaitem('component.' + type + '.dipped') * 16)
        .duration(40)
        .cleanroom(CleanroomType.CLEANROOM)
        .EUt(VA[MV])
        .buildAndRegister()

    BALL_MILL.recipeBuilder()
        .inputs(metaitem('component.' + type + ".unterminated") * 16)
        .outputs(metaitem('component.' + type + ".polished") * 16)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('watts_bath_electrolyte') * 1000)
        .inputs(ore('foilNickel'))
        .inputs(metaitem('component.' + type + '.terminated') * 16)
        .outputs(metaitem('component.' + type + '.plated') * 16)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('component.' + type + '.plated') * 16)
        .fluidInputs(fluid('soldering_alloy') * 160)
        .fluidInputs(fluid('epoxy') * 160)
        .outputs(metaitem('component.' + type) * 16)
        .duration(40)
        .EUt(VA[MV])
        .buildAndRegister()
}
