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

// Modelled on the Na2CO3 roasting-water washing-H2SO4 leaching route for Sc-bearing
// aegirine, which is also a pyroxene.
// $stoik 4CaFeSi2O6 + 10Na2CO3 + O2 -> 8Na2SiO3 + 4NaFeO2 + 4CaO + 10CO2
Sintering.RotaryKiln.fuels.each { fuel ->
    Sintering.RotaryKiln.comburents.each { comburent ->
        def builder = ROTARY_KILN.recipeBuilder()
            .inputs(ore('dustLunarPyroxene') * 40)
            .inputs(ore('dustSodaAsh') * 60)
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .outputs(metaitem('dustSodiumSilicate') * 48)
            .outputs(metaitem('dustSodianFerriteClinker') * 24)
            .duration(fuel.duration + comburent.duration)
            .EUt(VA[HV])

        // Gotta not list the same fluid twice
        if (comburent.name == 'oxygen') {
            builder.fluidInputs(fluid('oxygen') * (1000 + comburent.amountRequired))
        } else {
            builder.fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            builder.fluidInputs(fluid('oxygen') * 1000)
        }

        if (fuel.byproduct == 'carbon_dioxide') {
            builder.fluidOutputs(fluid('carbon_dioxide') * (10000 + fuel.byproductAmount))
        } else {
            builder.fluidOutputs(fluid('carbon_dioxide') * 10000)
            builder.fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
        }

        builder.buildAndRegister()
    }
}

// $stoik 4NaFeO2 + 4CaO + 12H2O -> 4Fe(OH)3 + 4Ca(OH)2 + 4NaOH
BR.recipeBuilder()
    .inputs(ore('dustSodianFerriteClinker') * 24)
    .fluidInputs(fluid('water') * 12000)
    .outputs(metaitem('dustHydrolyzedPyroxeneResidue') * 48)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 4000)
    .EUt(VA[MV])
    .duration(300)
    .buildAndRegister()

// Sulfuric acid leach, 8 M, ~80 C. Needs extra acidity in order to prevent Ti coprecipitation as below.
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
    .notConsumable(ore('dustRutile') * 1)
    .outputs(metaitem('dustTitaniumDioxide') * 3)
    .fluidOutputs(fluid('scandium_bearing_waste_acid') * 60000)
    .EUt(VA[MV])
    .duration(1200)
    .buildAndRegister()
