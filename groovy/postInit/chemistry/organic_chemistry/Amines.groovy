import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Guanidinium salts

BR.recipeBuilder()
    .inputs(ore('dustCalciumCyanamide') * 4)
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .fluidInputs(fluid('water') * 2000)
    .fluidOutputs(fluid('cyanamide_slurry') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('cyanamide_slurry') * 1000)
    .outputs(metaitem('dustCalcite') * 5)
    .fluidOutputs(fluid('crude_cyanamide_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

ION_EXCHANGE.recipeBuilder()
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidInputs(fluid('crude_cyanamide_solution') * 1000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 100)
    .fluidOutputs(fluid('cyanamide_solution') * 1000)
    .fluidOutputs(fluid('wastewater') * 100)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustTinySodiumHydroxide'))
    .fluidInputs(fluid('cyanamide_solution') * 2000)
    .outputs(metaitem('dustDicyanamide') * 10)
    .fluidOutputs(fluid('wastewater') * 2000)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustDicyanamide') * 10)
    .fluidInputs(fluid('ammonium_nitrate_solution') * 2000)
    .fluidOutputs(fluid('guanidinium_nitrate_solution') * 2000)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(ore('springKanthal'))
    .fluidInputs(fluid('guanidinium_nitrate_solution') * 2000)
    .outputs(metaitem('dustGuanidiniumNitrate') * 14)
    .fluidOutputs(fluid('wastewater') * 2000)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustDicyanamide') * 10)
    .fluidInputs(fluid('ammonium_chloride_solution') * 2000)
    .fluidOutputs(fluid('guanidinium_chloride_solution') * 2000)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(ore('springKanthal'))
    .fluidInputs(fluid('guanidinium_chloride_solution') * 2000)
    .outputs(metaitem('dustGuanidiniumChloride') * 11)
    .fluidOutputs(fluid('wastewater') * 2000)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

// Ethanolamines

CSTR.recipeBuilder()
    .fluidInputs(fluid('ethylene_oxide') * 150)
    .fluidInputs(fluid('ammonia') * 300)
    .fluidOutputs(fluid('ethanolamine_mix') * 150)
    .duration(1)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('ethanolamine_mix') * 3000)
    .fluidOutputs(fluid('triethanolamine') * 1000)
    .fluidOutputs(fluid('diethanolamine') * 1000)
    .fluidOutputs(fluid('ethanolamine') * 1000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

// Urea

CSTR.recipeBuilder()
    .fluidInputs(fluid('ammonia') * 100)
    .fluidInputs(fluid('carbon_dioxide') * 50)
    .fluidOutputs(fluid('urea_solution') * 50)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('urea_solution') * 1000)
    .outputs(metaitem('dustUrea') * 8)
    .fluidOutputs(fluid('water') * 1000)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

// Methylamines

FLUIDIZED_BR.recipeBuilder()
    .fluidInputs(fluid('methanol') * 300)
    .fluidInputs(fluid('ammonia') * 150)
    .notConsumable(ore('catalystBedAmorphousSilicaAlumina'))
    .fluidOutputs(fluid('methylamine_mix') * 450)
    .duration(8)
    .EUt(VA[MV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('methylamine_mix') * 9000)
    .fluidOutputs(fluid('water') * 6000)
    .fluidOutputs(fluid('methylamine') * 1000)
    .fluidOutputs(fluid('dimethylamine') * 1000)
    .fluidOutputs(fluid('trimethylamine') * 1000)
    .EUt(90)
    .duration(1200)
    .buildAndRegister()

// Propylamines

FIXED_BR.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('ammonia') * 50)
    .fluidInputs(fluid('n_propanol') * 150)
    .fluidOutputs(fluid('tripropylamine') * 50)
    .fluidOutputs(fluid('water') * 150)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister();