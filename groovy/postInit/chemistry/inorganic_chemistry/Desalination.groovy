import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Desalination

    /* Info table:
    Seawater - 0.05 moles of solids per 1000L
    Concentrated seawater - 5 moles of solids per 1000L
    Solids composition:
    NaCl - 86%
    MgCl2 - 7%
    MgSO4 - 3%
    CaSO4 - 2%
    KCl - 2%
    */

    // By distillation: very energy intensive

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('salt_water') * 1000)
        .outputs(metaitem('dustSalt') * 2)
        .fluidOutputs(fluid('water') * 1000)
        .duration(240)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('concentrated_salt_water') * 1000)
        .outputs(metaitem('dustSalt') * 4)
        .fluidOutputs(fluid('water') * 1000)
        .duration(240)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('hypersaline_water') * 1000)
        .outputs(metaitem('dustSalt') * 8)
        .fluidOutputs(fluid('water') * 1000)
        .duration(240)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('sea_water') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(240)
        .EUt(VA[LV])
        .buildAndRegister()

    MSFD.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('sea_water') * 10000)
        .fluidInputs(fluid('dense_steam') * 100)
        .fluidOutputs(fluid('water') * 10000)
        .fluidOutputs(fluid('concentrated_sea_water') * 100)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister()

    MSFD.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('sea_water') * 10000)
        .fluidInputs(fluid('dense_steam') * 100)
        .fluidOutputs(fluid('desalinated_sea_water') * 10000)
        .fluidOutputs(fluid('concentrated_sea_water') * 100)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister()

    MSFD.recipeBuilder()
        .fluidInputs(fluid('salt_water') * 5000)
        .fluidInputs(fluid('dense_steam') * 1000)
        .fluidOutputs(fluid('water') * 3500)
        .fluidOutputs(fluid('concentrated_salt_water') * 2500)
        .duration(80)
        .EUt(VA[MV])
        .buildAndRegister()

    MSFD.recipeBuilder()
        .fluidInputs(fluid('water') * 17500)
        .fluidInputs(fluid('dense_steam') * 1000)
        .fluidOutputs(fluid('distilled_water') * 18500)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()

    // By evaporation: slower than RO but more byproducts.

    EVAPORATION_POOL.recipeBuilder()
        .fluidInputs(fluid('salt_water') * 20000)
        .outputs(metaitem('dustSalt') * 40) 
        .duration(1800)
        .buildAndRegister()

    EVAPORATION_POOL.recipeBuilder() // Concentration step
        .fluidInputs(fluid('sea_water') * 20000)
        .chancedOutput(metaitem('dustGypsum'), 4800, 0)
        .fluidOutputs(fluid('concentrated_sea_water') * 200) // 25.5 mol NaCl
        .duration(1800)
        .buildAndRegister()

    EVAPORATION_POOL.recipeBuilder() // NaCl removal
        .fluidInputs(fluid('concentrated_sea_water') * 6000)
        .outputs(metaitem('dustSalt') * 51)
        .fluidOutputs(fluid('sea_bittern') * 1000) // 0.6 mol KMgCl3, 
        .duration(540)
        .buildAndRegister()

    // Bittern processing

    CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('sea_bittern') * 1000)
        .fluidInputs(fluid('water') * 7000)
        .chancedOutput(metaitem('dustEpsomite') * 13, 9000, 0)
        .fluidOutputs(fluid('desulfatized_sea_bittern') * 1000) // 0.7 mol MgCl2
        .duration(600)
        .EUt(VA[MV])
        .buildAndRegister()

    // See Bromine Chain

    CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('debrominated_sea_bittern') * 1000)
        .fluidInputs(fluid('water') * 6500)
        .chancedOutput(metaitem('dustCarnallite') * 5, 6000, 0)
        .fluidOutputs(fluid('magnesium_chloride_solution') * 1500)
        .duration(600)
        .EUt(VA[MV])
        .buildAndRegister()

    // By reverse osmosis: less byproducts but much faster.

    FLUID_COMPRESSOR.recipeBuilder()
        .notConsumable(metaitem('membrane.cellulose_acetate'))
        .fluidInputs(fluid('salt_water') * 10000)
        .fluidOutputs(fluid('hypersaline_water') * 2500)
        .fluidOutputs(fluid('water') * 7500)
        .duration(40)
        .EUt(VA[MV])
        .buildAndRegister()

    FLUID_COMPRESSOR.recipeBuilder()
        .circuitMeta(1)
        .notConsumable(metaitem('membrane.cellulose_acetate'))
        .fluidInputs(fluid('sea_water') * 10000)
        .fluidOutputs(fluid('concentrated_sea_water') * 1000)
        .fluidOutputs(fluid('water') * 9000)
        .duration(40)
        .EUt(VA[MV])
        .buildAndRegister()
        
    FLUID_COMPRESSOR.recipeBuilder()
        .circuitMeta(2)
        .notConsumable(metaitem('membrane.cellulose_acetate'))
        .fluidInputs(fluid('sea_water') * 10000)
        .fluidOutputs(fluid('concentrated_sea_water') * 1000)
        .fluidOutputs(fluid('desalinated_sea_water') * 9000)
        .duration(40)
        .EUt(VA[MV])
        .buildAndRegister()