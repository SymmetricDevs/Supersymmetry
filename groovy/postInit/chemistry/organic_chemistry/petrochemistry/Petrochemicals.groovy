import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Aromatics

SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('reformate') * 1000)
    .fluidInputs(fluid('furfural') * 100)
    .fluidOutputs(fluid('furfural_btex_extract') * 800)
    .fluidOutputs(fluid('reformate_raffinate') * 300)
    .duration(50)
    .EUt(VA[LV])
    .buildAndRegister()

SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('reformate') * 1000)
    .fluidInputs(fluid('sulfolane') * 100)
    .fluidOutputs(fluid('sulfolane_btex_extract') * 800)
    .fluidOutputs(fluid('reformate_raffinate') * 300)
    .duration(25)
    .EUt(VA[LV])
    .buildAndRegister()

SIEVE_DT.recipeBuilder()
    .fluidInputs(fluid('furfural_btex_extract') * 800)
    .fluidInputs(fluid('dense_steam') * 100)
    .fluidOutputs(fluid('furfural_solution') * 200)
    .fluidOutputs(fluid('btex') * 800)
    .duration(50)
    .EUt(VA[LV])
    .buildAndRegister()

SIEVE_DT.recipeBuilder()
    .notConsumable(fluid('dense_steam') * 100)
    .fluidInputs(fluid('sulfolane_btex_extract') * 800)
    .fluidOutputs(fluid('sulfolane') * 100)
    .fluidOutputs(fluid('btex') * 800)
    .duration(25)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('furfural_btex_extract') * 800)
    .fluidInputs(fluid('dense_steam') * 100)
    .fluidOutputs(fluid('btex') * 800)
    .duration(250)
    .EUt(VA[ULV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('furfural_solution') * 2000)
    .fluidOutputs(fluid('furfural') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(250)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('btex') * 1000)
    .fluidOutputs(fluid('xylene') * 400)
    .fluidOutputs(fluid('ethylbenzene') * 50)
    .fluidOutputs(fluid('toluene') * 400)
    .fluidOutputs(fluid('benzene') * 150)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

    // Xylenes

    DT.recipeBuilder()
        .fluidInputs(fluid('xylene') * 1000)
        .fluidOutputs(fluid('ortho_xylene') * 200)
        .fluidOutputs(fluid('meta_para_xylene_mixture') * 800)
        .duration(100)
        .EUt(VA[LV] * 2)
        .buildAndRegister()

    CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('meta_para_xylene_mixture') * 4000)
        .outputs(metaitem('dustParaXylene'))
        .fluidOutputs(fluid('meta_xylene') * 3000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    EXTRACTOR.recipeBuilder()
        .inputs(ore('dustParaXylene'))
        .fluidOutputs(fluid('para_xylene') * 1000)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()

    REFORMER.recipeBuilder()
        .notConsumable(metaitem('catalystBedHydrogenZsmFive'))
        .fluidInputs(fluid('meta_xylene') * 1000)
        .fluidOutputs(fluid('para_xylene') * 1000)
        .duration(60)
        .EUt(VA[LV] * 2)
        .buildAndRegister()

    // Aromatics interconversions

        // Toluene from benzene

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedAluminiumChloride'))
            .circuitMeta(1)
            .fluidInputs(fluid('benzene') * 50)
            .fluidInputs(fluid('chloromethane') * 50)
            .fluidOutputs(fluid('toluene') * 50)
            .fluidOutputs(fluid('hydrogen_chloride') * 50)
            .duration(10)
            .EUt(VA[LV])
            .buildAndRegister()

        // Xylene from benzene

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedAluminiumChloride'))
            .circuitMeta(2)
            .fluidInputs(fluid('benzene') * 50)
            .fluidInputs(fluid('chloromethane') * 100)
            .fluidOutputs(fluid('ortho_para_xylene_mixture') * 50)
            .fluidOutputs(fluid('hydrogen_chloride') * 100)
            .duration(10)
            .EUt(VA[LV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('ortho_para_xylene_mixture') * 1000)
            .fluidOutputs(fluid('para_xylene') * 575)
            .fluidOutputs(fluid('ortho_xylene') * 375)
            .fluidOutputs(fluid('meta_xylene') * 50)
            .duration(100)
            .EUt(VA[LV] * 2)
            .buildAndRegister()

        // Xylene from toluene

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedSupportedAluminiumChloride'))
            .fluidInputs(fluid('toluene') * 50)
            .fluidInputs(fluid('chloromethane') * 50)
            .fluidOutputs(fluid('ortho_para_xylene_mixture') * 50)
            .fluidOutputs(fluid('hydrogen_chloride') * 50)
            .duration(10)
            .EUt(VA[LV])
            .buildAndRegister()

        // Biphenyl and polychlorinated biphenyls

        CRACKER.recipeBuilder()
            .fluidInputs(fluid('toluene') * 1000)
            .fluidInputs(fluid('hydrogen') * 4000)
            .fluidOutputs(fluid('hydrodealkylated_toluene_mixture') * 1000)
            .duration(100)
            .EUt(VA[MV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('hydrodealkylated_toluene_mixture') * 1000)
            .chancedOutput(metaitem('dustBiphenyl'), 250, 0)
            .fluidOutputs(fluid('toluene') * 200)
            .fluidOutputs(fluid('benzene') * 750)
            .fluidOutputs(fluid('methane') * 750)
            .fluidOutputs(fluid('hydrogen') * 2400)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister()

        BR.recipeBuilder()
            .notConsumable(ore('dustIronIiiChloride'))
            .inputs(ore('dustBiphenyl'))
            .fluidInputs(fluid('chlorine') * 5000)
            .fluidOutputs(fluid('polychlorinated_biphenyl') * 1000)
            .fluidOutputs(fluid('hydrogen_chloride') * 5000)
            .duration(15)
            .EUt(VA[LV])
            .buildAndRegister()

        FLUIDIZED_BR.recipeBuilder()
            .notConsumable(ore('springNichrome'))
            .fluidInputs(fluid('benzene') * 1000)
            .fluidInputs(fluid('oxygen') * 50)
            .chancedOutput(metaitem('dustBiphenyl'), 500, 0)
            .fluidOutputs(fluid('benzene') * 900)
            .fluidOutputs(fluid('water') * 50)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister()

        // Phenol from chlorobenzene

        BR.recipeBuilder()
            .fluidInputs(fluid('sodium_hydroxide') * 432)
            .fluidInputs(fluid('chlorobenzene') * 1000)
            .outputs(metaitem('dustSalt') * 2)
            .fluidOutputs(fluid('phenol') * 1000)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister()

        BR.recipeBuilder()
            .fluidInputs(fluid('sodium_phenoxide_solution') * 1000)
            .fluidInputs(fluid('hydrogen_chloride') * 1000)
            .fluidOutputs(fluid('phenol') * 1000)
            .fluidOutputs(fluid('salt_water') * 1000)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister()

        // Benzene from phenol

        ROASTER.recipeBuilder()
            .fluidInputs(fluid('phenol') * 1000)
            .inputs(ore('dustAnyPurityZinc'))
            .fluidOutputs(fluid('benzene') * 1000)
            .outputs(metaitem('dustZincOxide') * 2)
            .duration(120)
            .EUt(VA[LV])
            .buildAndRegister()

        // Toluene disproportionation

        FIXED_BR.recipeBuilder()
            .notConsumable(ore('catalystBedHydrogenZsmFive'))
            .fluidInputs(fluid('toluene') * 1000)
            .fluidOutputs(fluid('disproportionated_toluene_mixture') * 1000)
            .duration(120)
            .EUt(VA[MV])
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('disproportionated_toluene_mixture') * 1000)
            .fluidOutputs(fluid('para_xylene') * 120)
            .fluidOutputs(fluid('ortho_xylene') * 30)
            .fluidOutputs(fluid('meta_xylene') * 150)
            .fluidOutputs(fluid('toluene') * 600)
            .fluidOutputs(fluid('benzene') * 300)
            .duration(100)
            .EUt(VA[LV])
            .buildAndRegister()

    // Pyrolysis gasoline separation

    SIEVE_DT.recipeBuilder()
        .fluidInputs(fluid('pyrolysis_gasoline') * 1000)
        .fluidInputs(fluid('furfural') * 50)
        .fluidOutputs(fluid('furfural_btex_extract') * 400)
        .fluidOutputs(fluid('pyrolysis_raffinate') * 400)
        .fluidOutputs(fluid('c_five_fraction') * 200)
        .duration(120)
        .EUt(VA[LV])
        .buildAndRegister()

    SIEVE_DT.recipeBuilder()
        .fluidInputs(fluid('pyrolysis_gasoline') * 1000)
        .fluidInputs(fluid('sulfolane') * 50)
        .fluidOutputs(fluid('sulfolane_btex_extract') * 400)
        .fluidOutputs(fluid('pyrolysis_raffinate') * 400)
        .fluidOutputs(fluid('c_five_fraction') * 200)
        .duration(60)
        .EUt(VA[LV])
        .buildAndRegister()

// Aromatic derivatives

    // Toluene chlorination

    BR.recipeBuilder()
        .inputs(ore('dustTinyAzobisisobutyronitrile'))
        .fluidInputs(fluid('toluene') * 1000)
        .fluidInputs(fluid('chlorine') * 3000)
        .fluidOutputs(fluid('benzotrichloride') * 1000)
        .fluidOutputs(fluid('hydrogen_chloride') * 3000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    // Benzoyl chloride

    CSTR.recipeBuilder()
        .fluidInputs(fluid('benzotrichloride') * 50)
        .fluidInputs(fluid('water') * 50)
        .fluidOutputs(fluid('benzoyl_chloride') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 100)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    // Toluene derivatives

        // p-Nitrotoluene

        CSTR.recipeBuilder()
            .notConsumable(ore('springNichrome'))
            .fluidInputs(fluid('toluene') * 50)
            .fluidInputs(fluid('nitration_mixture') * 100)
            .fluidOutputs(fluid('acidic_nitrotoluene_mixture') * 150)
            .duration(10)
            .EUt(VA[LV])
            .buildAndRegister()

        PHASE_SEPARATOR.recipeBuilder()
            .fluidInputs(fluid('acidic_nitrotoluene_mixture') * 3000)
            .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
            .fluidOutputs(fluid('nitrotoluene_mixture') * 1000)
            .duration(50)
            .buildAndRegister()

        CRYSTALLIZER.recipeBuilder()
            .fluidInputs(fluid('nitrotoluene_mixture') * 3000)
            .outputs(metaitem('dustParaNitrotoluene') * 17)
            .fluidOutputs(fluid('ortho_nitrotoluene') * 2000)
            .duration(200)
            .EUt(VA[LV])
            .buildAndRegister()

// Alkanes

    // n-Hexane superfractionation

    DT.recipeBuilder()
        .fluidInputs(fluid('light_naphtha') * 1000)
        .fluidOutputs(fluid('hexane') * 150)
        .fluidOutputs(fluid('dehexanized_naphtha') * 850)
        .duration(600)
        .EUt(VA[LV])
        .buildAndRegister()

// Alkenes

    // Butenes separation

    DT.recipeBuilder()
        .fluidInputs(fluid('butene') * 1000)
        .fluidOutputs(fluid('isobutylene') * 500)
        .fluidOutputs(fluid('one_butene') * 300)
        .fluidOutputs(fluid('two_butene') * 200)
        .duration(60)
        .EUt(VA[LV])
        .buildAndRegister()

    // Cyclopentadiene

    FLUID_HEATER.recipeBuilder()
        .fluidInputs(fluid('c_five_fraction') * 1000)
        .fluidOutputs(fluid('dimerized_c_five_fraction') * 870)
        .duration(60)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('dimerized_c_five_fraction') * 870)
        .fluidOutputs(fluid('dicyclopentadiene') * 130)
        .fluidOutputs(fluid('pentane') * 380)
        .fluidOutputs(fluid('isoprene') * 360)
        .duration(60)
        .EUt(VA[LV])
        .buildAndRegister()

    FLUID_HEATER.recipeBuilder()
        .fluidInputs(fluid('dicyclopentadiene') * 1000)
        .fluidOutputs(fluid('cyclopentadiene') * 2000)
        .duration(60)
        .EUt(VA[LV])
        .buildAndRegister()

    // Butadiene without oil

    FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('gtfo_acetaldehyde') * 50)
        .fluidInputs(fluid('ethanol') * 50)
        .notConsumable(ore('catalystBedTantalum'))
        .fluidOutputs(fluid('butadiene') * 50)
        .fluidOutputs(fluid('water') * 100)
        .duration(5)
        .EUt(VA[LV])
        .buildAndRegister()
