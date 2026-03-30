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
