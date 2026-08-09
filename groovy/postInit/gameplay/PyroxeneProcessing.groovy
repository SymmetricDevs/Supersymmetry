import static prePostInit.Recipemaps.*
import globals.Sintering
import static gregtech.api.GTValues.*

// Lunar pyroxene beneficiation and scandium liberation.
// Continues from RegolithProcessing.groovy, which produces lunar_silicate_slurry.
// The scandium hydrometallurgy picks up in ScandiumChain.groovy after the titanyl
// sulfate hydrolysis at the bottom of this file.

// TODO UNREGISTERED MATERIALS:
//   dustLunarPyroxene              CaFeSi2O6, 10 dust = 1 mol
//   dustSodianFerriteClinker       4NaFeO2 + 4CaO per 24 dust
//   dustHydrolyzedPyroxeneResidue  4Fe(OH)3 + 4Ca(OH)2 per 48 dust
//   lunar_plagioclase_slurry
//   lunar_mafic_slurry
//   scandian_ferric_sulfate_leachate
//   scandium_bearing_waste_acid

// ---------------------------------------------------------------------------------------
// Roast -> lattice modification -> leach
// ---------------------------------------------------------------------------------------

// Sodium carbonate roast, ~750 C. Breaks the silicate chain to soluble sodium silicate and
// oxidises Fe(2+) to a sodium ferrite phase; Sc rides along into that ferrite as NaScO2.
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

        // The roast needs 1000 L of O2 to oxidise the iron, and releases 10000 L of CO2
        // from the carbonate. Both collide with the kiln's own combustion fluids, so fold
        // them together rather than listing the same fluid twice in one recipe.
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

// Water wash / hydrolysis, ~80 C. This is the lattice modification: the sodium ferrite
// hydrolyses to a reactive, amorphous ferric hydroxide, so what was refractory pyroxene is
// now freely acid-soluble. The sodium silicate from the roast is already separated out and
// doubles as the flotation depressant at the top of this file.
// $stoik 4NaFeO2 + 4CaO + 12H2O -> 4Fe(OH)3 + 4Ca(OH)2 + 4NaOH
BR.recipeBuilder()
    .inputs(ore('dustSodianFerriteClinker') * 24)
    .fluidInputs(fluid('water') * 12000)
    .outputs(metaitem('dustHydrolyzedPyroxeneResidue') * 48)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 4000)
    .EUt(VA[MV])
    .duration(300)
    .buildAndRegister()

// Sulfuric acid leach, 8 M, ~80 C. Calcium drops out as gypsum; Fe and Sc report to
// solution. The acid is deliberately in large excess - 20 mol in, 10 mol consumed - and
// that free acidity is not incidental, it is what holds titanium in solution through this
// step so it does not co-precipitate with the gypsum. See the hydrolysis note below.
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


// ---------------------------------------------------------------------------------------
// Titanyl sulfate hydrolysis
// ---------------------------------------------------------------------------------------

// Lunar pyroxene carries Ti as a lattice substituent rather than as a separate mineral -
// the Lunar Sourcebook gives mare pyroxene cores up to 3.5 wt% TiO2 - so the upstream
// ilmenite flotation cannot remove it and it arrives here as titanyl sulfate. At ~4 wt%
// TiO2 against Sc at ~60 ppm it is by far the largest impurity, and Ti(IV) is strongly
// extracted by P204, so it is dropped here rather than scrubbed out later.

// Why this does not simply happen in the leach above, alongside the gypsum: the separation
// is kinetic, not thermodynamic. Titanyl sulfate solutions are metastable - the sulfate
// process deliberately dissolves its digestion cake cold to avoid premature hydrolysis.
// Three things hold Ti in solution up there and all three change here:
//   1. Acidity. The hydrolysis window is 2.5-15 wt% H2SO4; the leach liquor is 8 M, ~55 wt%.
//      The dilution below is what drops free acid into the window - it is not stoichiometric.
//   2. Temperature. Ea is 147.6 kJ/mol, so hydrolysis runs ~50x faster at 110 C than at
//      80 C. It is documented as slow below 90 C, with 110 C the preferred operating point.
//   3. Nucleation. It is a seeded, induction-period process. Hence the rutile seed and the
//      long duration; the seed comes from the ilmenite branch in RegolithProcessing.groovy.
// Gypsum by contrast precipitates on plain solubility grounds, fast and at any acidity, so
// the two never have to be separated from each other.

// The dilution also does double duty: dropping ~8 M by a factor of ~3 lands the liquor near
// the 1.5 M H2SO4 that P204 wants as its feed in ScandiumChain.groovy.
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
