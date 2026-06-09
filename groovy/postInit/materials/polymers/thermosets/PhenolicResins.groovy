import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Novolac Resins

// Phenol-formaldehyde novolacs

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustTinyOxalicAcid'))
    .fluidInputs(fluid('formaldehyde') * 750)
    .fluidInputs(fluid('phenol') * 1000)
    .fluidOutputs(fluid('phenolic_novolacs_oligomer') * 1750)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('phenolic_novolacs_oligomer') * 1750)
    .inputs(ore('dustHexamethylenetetramine') * 5)
    .fluidOutputs(fluid('phenolic_novolacs_resin') * 2000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Naphthol-modified phenol-formaldehyde novolacs

LCR.recipeBuilder()
    .fluidInputs(fluid('naphthalene') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .inputs(ore('dustSodiumSulfite') * 6)
    .outputs(metaitem('dustSodiumNaphthaleneTwoSulfonate'))
    .fluidOutputs(fluid('wastewater') * 2000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

LCR.recipeBuilder()
    .inputs(ore('dustSodiumNaphthaleneTwoSulfonate'))
    .fluidInputs(fluid('sodium_hydroxide') * 864)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 1000)
    .outputs(metaitem('dustTwoNaphthol'))
    .fluidOutputs(fluid('wastewater') * 1500)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .inputs(ore('dustTinyOxalicAcid') * 2)
    .inputs(ore('dustTwoNaphthol') * 1000)
    .fluidInputs(fluid('formaldehyde') * 1500)
    .fluidInputs(fluid('phenol') * 1000)
    .fluidOutputs(fluid('naphthol_modified_phenolic_novolacs_oligomer') * 3500)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

// Resol resins

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('formaldehyde') * 750)
    .fluidInputs(fluid('phenol') * 250)
    .notConsumable(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('phenolic_resol_resin') * 1000)
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister();

CSTR.recipeBuilder()
    .fluidInputs(fluid('isopropyl_alcohol') * 75)
    .fluidInputs(fluid('phenolic_resol_resin') * 25)
    .fluidOutputs(fluid('resol_infiltrant') * 100)
    .duration(2)
    .EUt(VA[MV])
    .buildAndRegister();
