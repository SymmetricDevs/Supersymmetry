import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import globals.semiconductors.Packaging
import globals.Sintering
import gregtech.api.tileentity.multiblock.CleanroomType

oreDict.add('componentCapacitorMedium', metaitem('component.capacitor.silver_mica'))
oreDict.add('componentCapacitorMedium', metaitem('component.capacitor.film'))

// Silver mica capacitors

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSilver') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('glue') * 200)
    .outputs(metaitem('component.capacitor.silver_mica'))
    .duration(360)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSilver') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
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
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy') * 16)
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
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy') * 16)
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
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy') * 16)
    .outputs(metaitem('component.capacitor.edlc'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()

//MLCC
MIXER.recipeBuilder()
    .inputs(ore('dustBariumTitanate') * 10)
    .fluidInputs(fluid('polyethylene_glycol') * 10)
    .fluidInputs(fluid('polyvinyl_alcohol_binder') * 50)
    .outputs(metaitem('barium_titanate_paste') * 5)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

dopants = ["Yttrium", "Dysprosium", "Holmium"]

for (dopant in dopants) {
    MIXER.recipeBuilder()
        .inputs(ore('dustBariumTitanate') * 10)
        .inputs(ore('dustTinyHighPurity' + dopant))
        .fluidInputs(fluid('polyethylene_glycol') * 10)
        .fluidInputs(fluid('polyvinyl_alcohol_binder') * 50)
        .outputs(metaitem('doped_barium_titanate_paste') * 5)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()
}

EXTRUDER.recipeBuilder()
    .inputs(metaitem('barium_titanate_paste'))
    .nonConsumable(metaitem('shape.extruder.foil'))
    .outputs(metaitem('sheet.barium_titanate') * 1)
    .duration(50)
    .EUt(VA[HV])
    .buildAndRegister()

SCREEN_PRINTER.recipeBuilder()
    .inputs(metaitem('sheet.barium_titanate') * 1)
    .nonConsumable(metaitem('screen_printing.mold.mlcc') * 1)
    .fluidInputs(fluid('nickel_conductive_ink') * 50)
    .outputs(metaitem('component.bme_cap.layer'))
    .duration(104)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()

COMPRESSOR.recipeBuilder()
    .inputs(metaitem('sheet.barium_titanate') * 2)
    .inputs(metaitem('component.bme_cap.layer') * 10)
    .outputs(metaitem('component.bme_cap.wafer') * 1)
    .duration(50)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()

Packaging.generateDicingRecipe("component.bme_cap.wafer", "component.bme_cap.unfired", 32, 100, HV);

Sintering.blankets.each { blanket ->
    SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('component.bme_cap.unfired') * 32)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('component.bme_cap.fired') * 32)
        .duration(blanket.duration)
        .EUt(VA[HV])
        .buildAndRegister()

    SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('component.pme_cap.unfired') * 32)
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('component.pme_cap.fired') * 32)
        .duration(blanket.duration)
        .EUt(VA[HV])
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
            .EUt(VA[MV])
            .buildAndRegister()
    }
}

SCREEN_PRINTER.recipeBuilder()
    .inputs(metaitem('sheet.barium_titanate') * 1)
    .nonConsumable(metaitem('screen_printing.mold.mlcc') * 1)
    .fluidInputs(fluid('silver_conductive_ink') * 50)
    .outputs(metaitem('component.pme_cap.layer'))
    .duration(104)
    .cleanroom(CleanroomType.CLEANROOM)
    .EUt(VA[HV])
    .buildAndRegister()
