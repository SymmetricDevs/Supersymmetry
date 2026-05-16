import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Electric double-layer (EDLC) supercapacitor, EV-tier aqueous component.
// Manufacturing chain matched to Misra, "Supercapacitors: Concepts and advances"
// (IOP, 2025), sections 4.13, 5.6, 5.7.

oreDict.add('componentCapacitorAdvanced', metaitem('component.capacitor.edlc'))

// --- Electrode chain (book section 4.13) ---

// Ball mill the dry electrode mix: activated carbon + PVDF binder (~10 wt%)
// + conductive carbon black (~10 wt%)
BALL_MILL.recipeBuilder()
    .inputs(ore('dustActivatedCarbon') * 8)
    .inputs(ore('dustPolyvinylideneFluoride'))
    .inputs(ore('dustCarbon'))
    .outputs(metaitem('edlc_electrode_powder') * 8)
    .duration(200)
    .EUt(VA[EV])
    .buildAndRegister()

// Disperse the milled powder in isopropyl alcohol to form the coating slurry
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
    .fluidOutputs(fluid('isopropyl_alcohol') * 40)
    .duration(160)
    .EUt(VA[EV])
    .buildAndRegister()

// --- Cell assembly (book sections 4.13, 5.6) ---
// Two electrodes wound around a mica separator with copper terminals, soldered
// and filled with an aqueous electrolyte. Mica separator per book 5.6
// (aqueous devices use mica/glass/ceramics).

// Sulfuric acid electrolyte variant
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('edlc_electrode') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 250)
    .fluidInputs(fluid('soldering_alloy') * 72)
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
    .outputs(metaitem('component.capacitor.edlc'))
    .duration(300)
    .EUt(VA[EV])
    .buildAndRegister()
