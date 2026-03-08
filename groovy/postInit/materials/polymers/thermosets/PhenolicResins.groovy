import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Novolac Resins

    // Phenol-formaldehyde novolacs

    POLYMERIZATION_TANK.recipeBuilder()
        .inputs(ore('dustTinyOxalicAcid'))
        .fluidInputs(fluid('formaldehyde') * 750)
        .fluidInputs(fluid('phenol') * 1000)
        .fluidOutputs(fluid('phenol_novolacs_oligomer') * 1750)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    MIXER.recipeBuilder()
        .fluidInputs(fluid('phenol_novolacs_oligomer') * 1750)
        .inputs(ore('dustHexamethylenetetramine') * 5)
        .fluidOutputs(fluid('phenolic_novolac_resin') * 2000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    // Epoxy Cresol Novolacs (ECN)

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedMagnesia'))
        .fluidInputs(fluid('phenol') * 50)
        .fluidInputs(fluid('methanol') * 50)
        .fluidOutputs(fluid('ortho_cresylic_acid_mixture') * 50)
        .circuitMeta(1)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    FIXED_BR.recipeBuilder()
        .notConsumable(ore('catalystBedMagnesia'))
        .fluidInputs(fluid('phenol') * 50)
        .fluidInputs(fluid('methanol') * 100)
        .fluidOutputs(fluid('two_six_xylenol') * 50)
        .circuitMeta(2)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('ortho_cresylic_acid_mixture') * 1000)
        .fluidOutputs(fluid('ortho_cresol') * 995)
        .fluidOutputs(fluid('two_six_xylenol') * 5)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('xylenol') * 1000)
        //.fluidOutputs(fluid('three_four_xylenol') * 65)
        //.fluidOutputs(fluid('three_five_xylenol') * 320) // These xylenols are used for insecticide, not needed now.
        //.fluidOutputs(fluid('two_three_xylenol') * 140)
        .fluidOutputs(fluid('two_four_five_xylenol_mixture') * 410)
        .fluidOutputs(fluid('two_six_xylenol') * 65)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    POLYMERIZATION_TANK.recipeBuilder()
        .inputs(ore('dustTinyOxalicAcid'))
        .fluidInputs(fluid('cresol') * 1400)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .fluidInputs(fluid('two_six_xylenol') * 100)
        .fluidOutputs(fluid('cresol_novolacs_oligomer') * 1500)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    POLYMERIZATION_TANK.recipeBuilder()
        .inputs(ore('dustTinyOxalicAcid'))
        .fluidInputs(fluid('ortho_cresol') * 1400)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .fluidInputs(fluid('two_six_xylenol') * 100)
        .fluidOutputs(fluid('cresol_novolacs_oligomer') * 1500)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

// Resol resins

CSTR.recipeBuilder()
    .fluidInputs(fluid('formaldehyde') * 75)
    .fluidInputs(fluid('phenol') * 25)
    .notConsumable(fluid('sodium_hydroxide_solution') * 50)
    .fluidOutputs(fluid('resol_resin_mixture') * 100)
    .duration(4)
    .EUt(VA[MV])
    .buildAndRegister();

CSTR.recipeBuilder()
    .fluidInputs(fluid('isopropyl_alcohol') * 75)
    .fluidInputs(fluid('resol_resin_mixture') * 25)
    .fluidOutputs(fluid('resol_resin_infiltrant') * 100)
    .duration(2)
    .EUt(VA[MV])
    .buildAndRegister();
