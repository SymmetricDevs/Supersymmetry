import static prePostInit.Recipemaps.*
import globals.Sintering
import static gregtech.api.GTValues.*

// thanks claude

// TODO UNREGISTERED MATERIALS:
//   dustLunarPyroxene              CaFeSi2O6, 10 dust = 1 mol
//   dustSodianFerriteClinker       4NaFeO2 + 4CaO per 24 dust
//   dustHydrolyzedPyroxeneResidue  4Fe(OH)3 + 4Ca(OH)2 per 48 dust
//   lunar_plagioclase_slurry
//   lunar_mafic_slurry
//   scandian_ferric_sulfate_leachate
//   scandium_bearing_waste_acid

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore('dustLunarPyroxene') * 40)
    .inputs(ore('dustSodaAsh') * 60)
    .outputs(metaitem('dustSodiumSilicate') * 48)
    .outputs(metaitem('dustSodianFerriteClinker') * 24)
    .fluidOutputs(fluid('carbon_dioxide') * 10000)
    .duration(480)
    .EUt(12000)
    .buildAndRegister()


// $stoik 4NaFeO2 + 4CaO + 12H2O -> 4Fe(OH)3 + 4Ca(OH)2 + 4NaOH
BR.recipeBuilder()
    .inputs(ore('dustSodianFerriteClinker') * 24)
    .fluidInputs(fluid('water') * 12000)
    .outputs(metaitem('dustHydrolyzedPyroxeneResidue') * 48)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 4000)
    .EUt(VA[MV])
    .duration(300)
    .buildAndRegister()

// Sulfuric acid leach, "8 M", ~80 C. Needs extra acidity in order to prevent Ti coprecipitation as below.
// $stoik 4Fe(OH)3 + 4Ca(OH)2 + 10H2SO4(H2O) -> 2Fe2(SO4)3 + 4CaSO4 + 30H2O
// scandian_ferric_sulfate_leachate additionally carries 10 mol free H2SO4(H2O).
BR.recipeBuilder()
    .inputs(ore('dustHydrolyzedPyroxeneResidue') * 48)
    .fluidInputs(fluid('sulfuric_acid') * 20000)
    .outputs(metaitem('dustCalciumSulfate') * 24)
    .fluidOutputs(fluid('scandian_ferric_sulfate_leachate') * 20000)
    .EUt(VA[MV])
    .duration(200)
    .buildAndRegister()

// In summary, by increasing pH and heating to 110C, titanyl sulfate forms and then hydrolyzes much more quickly, so it
// doesn't form in the previous step.

// $stoik TiOSO4 + H2O -> TiO2 + H2SO4
// Ti enters via the leachate as a trace lattice substituent and is therefore not carried in
// the idealised CaFeSi2O6 formula used above. 40000 L of leachate is ~1 mol Ti.
BR.recipeBuilder()
    .fluidInputs(fluid('scandian_ferric_sulfate_leachate') * 40000)
    .fluidInputs(fluid('water') * 20000)
    .notConsumable(ore('dustLunarRutile') * 1)
    .outputs(metaitem('dustLunarRutile') * 3)
    .fluidOutputs(fluid('scandium_bearing_waste_acid') * 60000)
    .EUt(VA[MV])
    .duration(1200)
    .buildAndRegister()

//see ScandiumChain.groovy