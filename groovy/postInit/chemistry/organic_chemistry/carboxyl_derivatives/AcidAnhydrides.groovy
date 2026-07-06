import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Acetic Anhydride
// Source: Acetic Anhydride and Mixed Fatty Acid Anhydrides Chapter in Ullmann's Encyclopedia of Industrial Chemistry https://doi.org/10.1002/14356007.a01_065.pub3

// Oxidation of Acetaldehyde
// Cu2(OH)2CO3 + 4C2H4O2 + 3H2O -> 2Cu(C2H3O2)2*H2O + 4H2O + CO2
BR.recipeBuilder() // Source: Copper Compounds Chapter in Ullmann's Encyclopedia of Industrial Chemistry https://doi.org/10.1002/14356007.a07_567
    .inputs(ore('dustBasicCopperCarbonate') * 10)
    .fluidInputs(fluid('acetic_acid') * 4000)
    .fluidInputs(fluid('distilled_water') * 3000)
    .fluidOutputs(fluid('copper_ii_acetate_solution') * 4000) // Cu(C2H3O2)2(H2O)3
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .EUt(VA[MV])
    .duration(160)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('acetic_acid') * 1000)
    .fluidOutputs(fluid('diluted_acetic_acid') * 2000)
    .EUt(VA[LV])
    .duration(120)
    .buildAndRegister()

// CuO + 2C2H4O2(H2O) -> Cu(C2H3O2)*H2O + 2H2O
BR.recipeBuilder() // Source: Copper Compounds Chapter in Ullmann's Encyclopedia of Industrial Chemistry https://doi.org/10.1002/14356007.a07_567
    .inputs(ore('dustCupricOxide') * 2)
    .fluidInputs(fluid('diluted_acetic_acid') * 4000)
    .fluidOutputs(fluid('copper_ii_acetate_solution') * 2000) // Cu(C2H3O2)2(H2O)3
    .EUt(VA[MV])
    .duration(200)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .fluidInputs(fluid('copper_ii_acetate_solution') * 2000)
    .outputs(metaitem('dustCopperIiAcetateMonohydrate') * 16) // Cu(C2H3O2)2*H2O
    .fluidOutputs(fluid('water'))
    .fluidOutputs(fluid('dense_steam') * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

// 2CH3CHO + O2 -> C4H6O3 + H2O
// 150 + 150 -> 75 + 75
// 2CH3CHO + O2 -> 2C2H4O2
// 25 + 25 -> 25

MIXER.recipeBuilder()
    .inputs(ore('dustCobaltIiAcetateTetrahydrate'))
    .inputs(ore('dustCopperIiAcetateMonohydrate') * 2)
    .outputs(metaitem('dustAceticAnhydrideCatalyst') * 3)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

CSTR.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('dustTinyAceticAnhydrideCatalyst'))
    .fluidInputs(fluid('gtfo_acetaldehyde') * 50)
    .fluidInputs(fluid('ethyl_acetate') * 100)
    .fluidInputs(fluid('oxygen') * 40)
    .fluidOutputs(fluid('acetic_acid_anhydride_mixture') * 185)
    .EUt(VA[MV])
    .duration(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('acetic_acid_anhydride_mixture') * 1850)
    .outputs(metaitem('dustTinyAceticAnhydrideCatalyst') * 10)
    .fluidOutputs(fluid('gtfo_acetic_anhydride') * 150)
    .fluidOutputs(fluid('acetic_acid') * 100)
    .fluidOutputs(fluid('water') * 150)
    .fluidOutputs(fluid('ethyl_acetate') * 1000)
    .fluidOutputs(fluid('gtfo_acetaldehyde') * 100)
    .duration(300)
    .EUt(VA[MV])
    .buildAndRegister()

// Ketene (Ethenone) + Acetic Acid

BCR.recipeBuilder()
    .fluidInputs(fluid('ethenone') * 50)
    .fluidInputs(fluid('acetic_acid') * 50)
    .fluidOutputs(fluid('gtfo_acetic_anhydride') * 50)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister()

// Methyl Acetate Carbonylation

LCR.recipeBuilder()
    .notConsumable(fluid('monsanto_process_catalyst') * 4000)
    .fluidInputs(fluid('methyl_acetate') * 1000)
    .fluidInputs(fluid('carbon_monoxide') * 1000)
    .fluidOutputs(fluid('gtfo_acetic_anhydride') * 1000)
    .duration(40)
    .EUt(VA[IV])
    .buildAndRegister()