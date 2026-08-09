import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Scandium recovery from lunar pyroxene.
// Picks up from PyroxeneProcessing.groovy after the titanyl sulfate hydrolysis, which
// delivers scandium_bearing_waste_acid at ~1.5 M H2SO4.
//
// This is the "scandium from titania waste acid" flowsheet, which is the best-documented
// Sc route in industry: P204 extraction at low acidity, HCl scrub, HF scrub, alkaline
// strip, controlled redissolution, oxalate precipitation, calcination.

// TODO: UNREGISTERED MATERIALS
//   dustCrudeScandiumHydroxide         Sc(OH)3 + impurities, 7 dust = 1 mol
//   dustScandiumOxalate                Sc2(C2O4)3(H2O)6, 38 dust = 1 mol
//   dustScandiumOxide                  Sc2O3, 5 dust = 1 mol
//   scandium_depleted_sulfate_raffinate
//   scandium_p204_extract
//   scrubbed_scandium_p204_extract
//   purified_scandium_p204_extract
//   iron_chloride_scrub_raffinate
//   fluoride_scrub_raffinate
//   scandium_chloride_solution

// The solvent-extraction steps below are partitions rather than reactions, so they carry no
// $stoik receipt - same as the P204/P507 stages in the bastnasite and monazite chains.


// ---------------------------------------------------------------------------------------
// P204 solvent extraction
// ---------------------------------------------------------------------------------------

// 30% P204 in kerosene against a ~1.5 M H2SO4 feed. Extraction order is
// Sc3+ > Fe3+ > Lu3+ > Yb3+ > Er3+ > Y3+ > Ho3+, so Fe(III) is the main co-extractant with
// Zr/Hf close behind. The raffinate keeps the bulk Fe and is also where Cr and V report,
// since neither is well extracted by P204.
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('scandium_bearing_waste_acid') * 60000)
    .fluidInputs(fluid('p_two_zero_four_extraction_mixture') * 6000)
    .fluidOutputs(fluid('scandium_depleted_sulfate_raffinate') * 60000)
    .fluidOutputs(fluid('scandium_p204_extract') * 6000)
    .requiredCells(4)
    .EUt(VA[EV])
    .duration(200)
    .buildAndRegister()

// Iron scrub, 5 M HCl.
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('scandium_p204_extract') * 6000)
    .fluidInputs(fluid('hydrochloric_acid') * 30000)
    .fluidOutputs(fluid('scrubbed_scandium_p204_extract') * 6000)
    .fluidOutputs(fluid('iron_chloride_scrub_raffinate') * 30000)
    .requiredCells(2)
    .EUt(VA[HV])
    .duration(120)
    .buildAndRegister()

// Fluoride scrub, 0.1 M HF. This is the step that decides product purity: Zr behaves almost
// identically to Sc and will otherwise follow it all the way to the oxide, which is why
// industrial Sc2O3 typically carries 3-10% Zr. HF converts Ti/Zr/Hf to anionic fluoride
// complexes that will not stay in the organic phase.
// Fluorine is the scarcest reagent in the lunar tree - the only source is fluorapatite in
// the KREEP branch - so the raffinate is recycled at the bottom of this file.
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('scrubbed_scandium_p204_extract') * 6000)
    .fluidInputs(fluid('hydrofluoric_acid') * 1000)
    .fluidOutputs(fluid('purified_scandium_p204_extract') * 6000)
    .fluidOutputs(fluid('fluoride_scrub_raffinate') * 1000)
    .requiredCells(2)
    .EUt(VA[HV])
    .duration(120)
    .buildAndRegister()

// Alkaline strip, 2 M NaOH. Converts the loaded organic straight to solid crude Sc(OH)3
// (70-78% Sc2O3) and regenerates the extractant into the existing spent-P204 loop.
BR.recipeBuilder()
    .fluidInputs(fluid('purified_scandium_p204_extract') * 6000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .outputs(metaitem('dustCrudeScandiumHydroxide') * 7)
    .fluidOutputs(fluid('spent_p_two_zero_four_extraction_mixture') * 6000)
    .EUt(VA[MV])
    .duration(150)
    .buildAndRegister()


// ---------------------------------------------------------------------------------------
// Oxalate finish
// ---------------------------------------------------------------------------------------

// Controlled redissolution, held near 3 M so residual Ti, Zr, Fe and Si hydrolyse and stay
// in the solid residue while Sc goes into solution.
// $stoik 2Sc(OH)3 + 6HCl -> 2ScCl3 + 6H2O
BR.recipeBuilder()
    .inputs(ore('dustCrudeScandiumHydroxide') * 14)
    .fluidInputs(fluid('hydrochloric_acid') * 6000)
    .fluidOutputs(fluid('scandium_chloride_solution') * 6000)
    .chancedOutput(metaitem('dustZirconiumDioxide') * 1, 2500, 0)
    .EUt(VA[MV])
    .duration(200)
    .buildAndRegister()

// Oxalic acid precipitation. The HCl is regenerated and recycles to the redissolution and
// iron scrub above.
// $stoik 2ScCl3 + 3H2C2O4(H2O) + 3H2O -> Sc2(C2O4)3(H2O)6 + 6HCl
BR.recipeBuilder()
    .fluidInputs(fluid('scandium_chloride_solution') * 6000)
    .fluidInputs(fluid('oxalic_acid_solution') * 3000)
    .fluidInputs(fluid('water') * 3000)
    .outputs(metaitem('dustScandiumOxalate') * 38)
    .fluidOutputs(fluid('hydrochloric_acid') * 6000)
    .EUt(VA[LV])
    .duration(300)
    .buildAndRegister()

// Calcination, 700-800 C. Yields 99.5% Sc2O3.
// $stoik Sc2(C2O4)3(H2O)6 -> Sc2O3 + 3CO + 3CO2 + 6H2O
ROASTER.recipeBuilder()
    .inputs(ore('dustScandiumOxalate') * 38)
    .outputs(metaitem('dustScandiumOxide') * 5)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .fluidOutputs(fluid('carbon_dioxide') * 3000)
    .fluidOutputs(fluid('dense_steam') * 6000)
    .EUt(VA[HV])
    .duration(400)
    .buildAndRegister()


// ---------------------------------------------------------------------------------------
// Fluoride raffinate: Zr/Hf recovery and fluorine recycle
// ---------------------------------------------------------------------------------------

// Steam pyrohydrolysis, ~500 C, giving anhydrous HF rather than the aqueous acid. This is
// the same operation used industrially to detoxify spent aluminium potlining.
//
// Zr and Hf are deliberately not separated here. dustFusedZirconia is the existing
// Hf-bearing zirconia intermediate, so this drops straight into the sulfatization in
// ZirconiumChain.groovy, upstream of the MIBK/thiocyanate Hf split that already exists.
//
// Fluorine balance: the scrub above spends 1000 L (1 mol) HF per cycle, so 40 cycles give
// 40000 L of raffinate carrying 40 mol F as 6 mol H2ZrF6 (36 F) plus 4 mol free HF. This
// returns all 40 mol, so the loop closes exactly and only handling losses need making up.
// $stoik 6H2ZrF6 + 12H2O -> 6ZrO2 + 36HF
// The remaining 4000 L of hydrogen_fluoride output is the free HF carried in unreacted.
ROASTER.recipeBuilder()
    .fluidInputs(fluid('fluoride_scrub_raffinate') * 40000)
    .fluidInputs(fluid('steam') * 12000)
    .outputs(metaitem('dustFusedZirconia') * 18)
    .fluidOutputs(fluid('hydrogen_fluoride') * 40000)
    .EUt(VA[HV])
    .duration(400)
    .buildAndRegister()

// The anhydrous HF rejoins the scrub feed through the existing absorption recipe in
// ChemistryOverhaul.groovy: hydrogen_fluoride + water -> hydrofluoric_acid, 1:1:1.
