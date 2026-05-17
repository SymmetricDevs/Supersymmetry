import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

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
    .inputs(ore('dustActivatedCarbon') * 8)
    .inputs(ore('dustPolyvinylideneFluoride'))
    .inputs(ore('dustCarbon'))
    .outputs(metaitem('edlc_electrode_powder') * 8)
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

// Disperse the powder in isopropyl alcohol to form the coating slurry
MIXER.recipeBuilder()
    .inputs(metaitem('edlc_electrode_powder') * 4)
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .fluidOutputs(fluid('edlc_electrode_slurry') * 1000)
    .duration(160)
    .EUt(VA[EV])
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
    .EUt(VA[EV])
    .buildAndRegister()

// --- Cell assembly (book sections 4.13, 5.6) ---

// Sulfuric acid electrolyte variant
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('edlc_electrode') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 250)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy') * 16)
    .outputs(metaitem('component.capacitor.edlc'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()

// Potassium hydroxide electrolyte variant
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('edlc_electrode') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('potassium_hydroxide_solution') * 250)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy') * 16)
    .outputs(metaitem('component.capacitor.edlc'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()
