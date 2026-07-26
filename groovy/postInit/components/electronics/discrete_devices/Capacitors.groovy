import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import globals.semiconductors.Packaging
import globals.Sintering
import gregtech.api.metatileentity.multiblock.CleanroomType

// SMD Capacitor * 8
mods.gregtech.assembler.removeByInput(480, [metaitem('foilSiliconeRubber'), metaitem('foilAluminium')], [fluid('plastic') * 72])
// SMD Capacitor * 12
mods.gregtech.assembler.removeByInput(480, [metaitem('foilPolyvinylChloride') * 2, metaitem('foilAluminium')], [fluid('plastic') * 72])
// SMD Capacitor * 16
mods.gregtech.assembler.removeByInput(480, [metaitem('foilSiliconeRubber'), metaitem('foilTantalum')], [fluid('plastic') * 72])
// SMD Capacitor * 24
mods.gregtech.assembler.removeByInput(480, [metaitem('foilPolyvinylChloride') * 2, metaitem('foilTantalum')], [fluid('plastic') * 72])

// Silver mica capacitors

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSilver') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('glue') * 200)
    .outputs(metaitem('component.capacitor.silver_mica'))
    .duration(360)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSilver') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('phenolic_novolacs_resin') * 50)
    .outputs(metaitem('component.capacitor.silver_mica'))
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()

// Plastic film capacitors

oreDict.add('capacitorFilm', metaitem('mylar'))
oreDict.add('capacitorFilm', metaitem('foilPolypropylene'))

EVAPORATION.recipeBuilder()
    .inputs(ore('nuggetAluminium'))
    .inputs(ore('capacitorFilm') * 8)
    .outputs(metaitem('component.capacitor.film.metallized_film'))
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.capacitor.film.metallized_film') * 2)
    .fluidInputs(fluid('aluminium') * 18)
    .fluidInputs(fluid('silicone_oil') * 50)
    .outputs(metaitem('component.capacitor.film.core'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.capacitor.film.metallized_film.impregnated'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('epoxy_molding_compound') * 16)
    .outputs(metaitem('component.capacitor.film'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

// Electric double-layer (EDLC) supercapacitor, EV-tier aqueous component.
// "Supercapacitors: Concepts and advances"
// (IOP, 2025), sections 4.13, 5.6, 5.7.

oreDict.add('componentSupercapacitor', metaitem('component.capacitor.edlc'))

// --- Electrode chain (book section 4.13) ---

// Mix the dry electrode mix
MIXER.recipeBuilder()
    .inputs(ore('dustActivatedCarbon') * 10)
    .inputs(ore('dustPolyvinylideneFluoride'))
    .inputs(ore('dustCarbon'))
    .outputs(metaitem('edlc_electrode_powder') * 10)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

// Disperse the powder in isopropyl alcohol to form the coating slurry
MIXER.recipeBuilder()
    .inputs(metaitem('edlc_electrode_powder') * 2)
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .fluidOutputs(fluid('edlc_electrode_slurry') * 1000)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

// Calendaring: coat the slurry onto an aluminium current collector
CURTAIN_COATER.recipeBuilder()
    .inputs(ore('foilAluminium'))
    .fluidInputs(fluid('edlc_electrode_slurry') * 250)
    .outputs(metaitem('edlc_electrode_coated'))
    .duration(120)
    .EUt(VA[EV])
    .buildAndRegister()

// Dry the coated electrode at high temperature, recovering solvent
DRYER.recipeBuilder()
    .inputs(metaitem('edlc_electrode_coated'))
    .outputs(metaitem('edlc_electrode'))
    .fluidOutputs(fluid('isopropyl_alcohol') * 250)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

// --- Cell assembly (book sections 4.13, 5.6) ---

// Sulfuric acid electrolyte variant
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('edlc_electrode') * 5)
    .inputs(ore('foilPolytetrafluoroethylene'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .inputs(ore('foilAluminium'))
    .fluidInputs(fluid('diluted_sulfuric_acid') * 250)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('epoxy_molding_compound') * 16)
    .outputs(metaitem('component.capacitor.edlc'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()

// Potassium hydroxide electrolyte variant
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('edlc_electrode') * 5)
    .inputs(ore('foilPolytetrafluoroethylene'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .inputs(ore('foilAluminium'))
    .fluidInputs(fluid('potassium_hydroxide_solution') * 250)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('epoxy_molding_compound') * 16)
    .outputs(metaitem('component.capacitor.edlc'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()

// MLCC ceramic capacitors
ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineStainlessSteel') * 16)
    .outputs(metaitem('mesh.stainless_steel'))
    .EUt(VA[MV])
    .duration(160)
    .buildAndRegister()

UV_LIGHT_BOX.recipeBuilder()
    .inputs(metaitem('mesh.stainless_steel'))
    .notConsumable(metaitem('stencil.capacitor'))
    .fluidInputs(fluid('acrylate_resist_mixture') * 50)
    .outputs(metaitem('screen_printing.pattern.mlcc'))
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustBariumTitanate') * 10)
    .fluidInputs(fluid('polyethylene_glycol') * 20)
    .fluidInputs(fluid('polyvinyl_alcohol_binder') * 80)
    .outputs(metaitem('barium_titanate_paste') * 5)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

dopants = ["Yttrium", "Dysprosium", "Holmium"]

for (dopant in dopants) {
    MIXER.recipeBuilder()
        .inputs(ore('dustBariumTitanate') * 10)
        .inputs(ore('dustTiny' + dopant + "IiiOxide"))
        .fluidInputs(fluid('polyethylene_glycol') * 20)
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 80)
        .outputs(metaitem('doped_barium_titanate_paste') * 5)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()
}

EXTRUDER.recipeBuilder()
    .inputs(metaitem('doped_barium_titanate_paste'))
    .notConsumable(metaitem('shape.extruder.foil'))
    .outputs(metaitem('sheet.doped_barium_titanate'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

SCREEN_PRINTING.recipeBuilder()
    .inputs(metaitem('sheet.doped_barium_titanate'))
    .notConsumable(metaitem('screen_printing.pattern.mlcc'))
    .fluidInputs(fluid('nickel_conductive_ink') * 50)
    .outputs(metaitem('component.bme_cap.layer'))
    .duration(104)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()

COMPRESSOR.recipeBuilder()
    .inputs(metaitem('sheet.doped_barium_titanate') * 2)
    .inputs(metaitem('component.bme_cap.layer') * 10)
    .outputs(metaitem('component.bme_cap.wafer'))
    .duration(50)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()

Packaging.generateDicingRecipe("component.bme_cap.wafer", "component.bme_cap.unfired", 64, 100, HV);

Sintering.blankets.each { blanket ->
    SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('component.bme_cap.unfired') * 64)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('component.bme_cap.fired') * 64)
        .duration(blanket.duration)
        .EUt(VA[EV])
        .buildAndRegister()

    SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('component.pme_cap.unfired') * 32)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('component.pme_cap.fired') * 32)
        .duration(blanket.duration)
        .EUt(VA[EV])
        .buildAndRegister()

    SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('component.bme_cap.dipped') * 64)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('component.bme_cap.terminated') * 64)
        .duration(blanket.duration)
        .EUt(VA[EV])
        .buildAndRegister()

    SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('component.pme_cap.dipped') * 32)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('component.pme_cap.terminated') * 32)
        .duration(blanket.duration)
        .EUt(VA[EV])
        .buildAndRegister()
}

Sintering.nonPlasmaFuels().each { fuel ->
    Sintering.comburents.each { comburent ->
        SINTERING_OVEN.recipeBuilder()
            .inputs(metaitem('component.pme_cap.unfired') * 4)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('component.pme_cap.fired') * 4)
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(VA[HV])
            .buildAndRegister()

        SINTERING_OVEN.recipeBuilder()
            .inputs(metaitem('component.pme_cap.dipped') * 4)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('component.pme_cap.terminated') * 4)
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(VA[HV])
            .buildAndRegister()
    }
}

EXTRUDER.recipeBuilder()
    .inputs(metaitem('barium_titanate_paste'))
    .notConsumable(metaitem('shape.extruder.foil'))
    .outputs(metaitem('sheet.barium_titanate'))
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

SCREEN_PRINTING.recipeBuilder()
    .inputs(metaitem('sheet.barium_titanate'))
    .notConsumable(metaitem('screen_printing.pattern.mlcc'))
    .fluidInputs(fluid('agpd_conductive_ink') * 50)
    .outputs(metaitem('component.pme_cap.layer'))
    .duration(104)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()

COMPRESSOR.recipeBuilder()
    .inputs(metaitem('sheet.barium_titanate') * 2)
    .inputs(metaitem('component.pme_cap.layer') * 10)
    .outputs(metaitem('component.pme_cap.wafer'))
    .duration(50)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.bme_cap.polished') * 16)
    .fluidInputs(fluid('copper_frit_ink') * 10)
    .outputs(metaitem('component.bme_cap.dipped') * 16)
    .duration(40)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.pme_cap.polished') * 16)
    .fluidInputs(fluid('silver_frit_ink') * 10)
    .outputs(metaitem('component.pme_cap.dipped') * 16)
    .duration(40)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[MV])
    .buildAndRegister()

cap_types = ["bme_cap", "pme_cap"]
for (cap_type in cap_types) {
    BALL_MILL.recipeBuilder()
        .inputs(metaitem('component.' + cap_type + ".fired") * 16)
        .outputs(metaitem('component.' + cap_type + ".polished") * 16)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('watts_bath_electrolyte') * 1000)
        .inputs(ore('foilNickel'))
        .inputs(metaitem('component.' + cap_type + '.terminated') * 16)
        .outputs(metaitem('component.' + cap_type + '.plated') * 16)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

    ASSEMBLER.recipeBuilder()
        .inputs(metaitem('component.' + cap_type + '.plated') * 16)
        .inputs(metaitem('component.smd.contact') * 32)
        .fluidInputs(fluid('high_temperature_solder') * 160)
        .outputs(metaitem('component.' + cap_type) * 16)
        .duration(40)
        .EUt(VA[MV])
        .buildAndRegister()
}
