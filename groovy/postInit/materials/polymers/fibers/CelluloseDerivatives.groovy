import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ModHandler
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.UnificationEntry

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('dustCellulose') * 4)
    .fluidInputs(fluid('manganese_ii_sulfate_solution') * 50)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
    .fluidOutputs(fluid('wastewater') * 2000)
    .outputs(metaitem('dustAlkaliCellulose') * 4)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()

// Rayon

LCR.recipeBuilder()
    .fluidInputs(fluid('carbon_disulfide') * 1000)
    .inputs(ore('dustAlkaliCellulose'))
    .outputs(metaitem('dustSodiumCelluloseXanthate'))
    .duration(160)
    .EUt(VA[HV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSodiumCelluloseXanthate'))
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('sodium_cellulose_xanthate_solution') * 1000)
    .duration(160)
    .EUt(VA[HV])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .notConsumable(metaitem('spinneret'))
    .fluidInputs(fluid('sodium_cellulose_xanthate_solution') * 2000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 3000)
    .fluidInputs(fluid('air') * 1000)
    .fluidOutputs(fluid('carbon_disulfide') * 2000)
    .fluidOutputs(fluid('sodium_sulfate_solution') * 1500)
    .fluidOutputs(fluid('wastewater') * 500)
    .outputs(metaitem('fiberWetRayon') * 8)
    .duration(160)
    .EUt(VA[HV])
    .buildAndRegister()

COMPRESSOR.recipeBuilder()
    .inputs(ore('threadRayon') * 8)
    .outputs(item('minecraft:wool'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Sodium Carboxymethyl Cellulose (CMC)
// 4 C6H7O2(OH)2ONa + 5 ClCH2COOH + 6 NaOH -> 4 C6H7O2(OH)2OCH2COONa + HOCH2COONa + 5 H2O + 5 NaCl

BR.recipeBuilder()
    .inputs(ore('dustAlkaliCellulose') * 4)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 6000)
    .fluidInputs(fluid('chloroacetic_acid') * 5000)
    .fluidInputs(fluid('ethanol_water_azeotrope') * 5000)
    .fluidOutputs(fluid('sodium_cmc_suspension') * 16000)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .notConsumable(metaitem('item_filter'))
    .fluidInputs(fluid('sodium_cmc_suspension') * 16000)
    .outputs(metaitem('dustSodiumCarboxymethylCellulose') * 4)
    .fluidOutputs(fluid('cmc_waste') * 16000)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('cmc_waste') * 16000)
    .fluidOutputs(fluid('ethanol_water_azeotrope') * 5000)
    .fluidOutputs(fluid('wastewater') * 11000)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()
