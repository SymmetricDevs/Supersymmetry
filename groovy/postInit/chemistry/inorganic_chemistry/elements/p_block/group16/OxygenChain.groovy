import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Peroxides

// 2-EAQ

BR.recipeBuilder()
    .inputs(ore('dustPhthalicAnhydride') * 15)
    .fluidInputs(fluid('ethylbenzene') * 1000)
    .outputs(metaitem('dustTwoEthylanthraquinone'))
    .fluidOutputs(fluid('water') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

// Anthraquinone solvent + solution

CSTR.recipeBuilder()
    .fluidInputs(fluid('phosphoryl_chloride') * 50)
    .fluidInputs(fluid('two_ethylhexanol') * 150)
    .fluidOutputs(fluid('tris_two_ethylhexyl_phosphate') * 50)
    .fluidOutputs(fluid('hydrogen_chloride') * 150)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(metaitem('dustTwoEthylanthraquinone') * 2)
    .fluidInputs(fluid('tris_two_ethylhexyl_phosphate') * 1000)
    .fluidInputs(fluid('xylene') * 1000)
    .fluidOutputs(fluid('two_ethylanthraquinone_solution') * 2000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Anthraquinone process

FIXED_BR.recipeBuilder()
    .notConsumable(ore('catalystBedSupportedPalladium'))
    .fluidInputs(fluid('two_ethylanthraquinone_solution') * 100)
    .fluidInputs(fluid('hydrogen') * 100)
    .fluidOutputs(fluid('two_ethylanthrahydroquinone_solution') * 100)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('two_ethylanthrahydroquinone') * 100)
    .fluidInputs(fluid('air') * 500)
    .fluidOutputs(fluid('oxidized_two_ethylanthraquinone_solution') * 100)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

BCR.recipeBuilder()
    .fluidInputs(fluid('two_ethylanthrahydroquinone') * 100)
    .fluidInputs(fluid('oxygen') * 100)
    .fluidOutputs(fluid('oxidized_two_ethylanthraquinone_solution') * 100)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

CSTR.recipeBuilder()
    .fluidInputs(fluid('oxidized_two_ethylanthraquinone_solution') * 100)
    .fluidInputs(fluid('water') * 50)
    .fluidOutputs(fluid('two_ethylanthraquinone_solution') * 100)
    .fluidOutputs(fluid('hydrogen_peroxide_solution') * 100)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

VACUUM_DT.recipeBuilder()
    .fluidInputs(fluid('hydrogen_peroxide_solution') * 2000)
    .fluidOutputs(fluid('hydrogen_peroxide') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('hydrogen_peroxide') * 1000)
    .fluidOutputs(fluid('hydrogen_peroxide_solution') * 2000)
    .EUt(VA[ULV])
    .duration(40)
    .buildAndRegister()
