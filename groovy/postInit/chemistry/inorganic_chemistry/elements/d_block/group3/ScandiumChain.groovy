import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Scandium recovery from lunar pyroxene.

// TODO: UNREGISTERED MATERIALS
//   dustCrudeScandiumHydroxide         Sc(OH)3 + impurities, 7 dust = 1 mol
//   dustScandiumOxalate                Sc2(C2O4)3(H2O)6, 38 dust = 1 mol
//   dustScandiumOxide                  Sc2O3, 5 dust = 1 mol
//   dustChromiumIiiSulfate
//   scandium_depleted_sulfate_raffinate
//   scandium_p204_extract
//   scrubbed_scandium_p204_extract
//   purified_scandium_p204_extract
//   iron_chloride_scrub_raffinate
//   fluoride_scrub_raffinate
//   scandium_chloride_solution

// 30% P204 in kerosene against a ~1.5 M H2SO4 feed. Extraction order is
// Sc3+ > Fe3+ > a bunch of lanthanides that aren't in here, probably
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('scandium_bearing_waste_acid') * 60000)
    .fluidInputs(fluid('p_two_zero_four_extraction_mixture') * 6000)
    .fluidOutputs(fluid('scandium_depleted_sulfate_raffinate') * 60000)
    .fluidOutputs(fluid('scandium_p204_extract') * 6000)
    .requiredCells(4)
    .EUt(VA[EV])
    .duration(200)
    .buildAndRegister()

// TODO: decide on adding vanadium here
CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('scandium_depleted_sulfate_raffinate') * 15000)
    .outputs(metaitem('dustIronIiiSulfate') * 4)
    .chancedOutput(metaitem('dustChromiumIiiSulfate') * 17, 1000, 0) // a little extra sulfate for the fans
    .fluidOutputs(fluid('sulfuric_acid') * 5250)
    .EUt(VA[HV])
    .duration(500)
    .buildAndRegister()

// Iron scrub, "5 M HCl"
MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('scandium_p204_extract') * 6000)
    .fluidInputs(fluid('hydrochloric_acid') * 10000)
    .fluidOutputs(fluid('scrubbed_scandium_p204_extract') * 6000)
    .fluidOutputs(fluid('iron_chloride_scrub_raffinate') * 10000)
    .requiredCells(2)
    .EUt(VA[HV])
    .duration(120)
    .buildAndRegister()

// FeCl3 + 3NaOH -> 3NaCl + Fe(OH)3  
BR.recipeBuilder()
    .fluidInputs(fluid('iron_chloride_scrub_raffinate') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .outputs(metaitem('dustIronIiiHydroxide') * 7)
    .fluidInputs(fluid('salt_water') * 1000)
    .EUt(VA[LV])
    .duration(120)
    .buildAndRegister()

// According to https://patents.google.com/patent/CN103060580A/en,
// you can get out Zr by converting it into a complex with HF, which is one of the very few ways
// it is separable from Sc.
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

// $stoik 6H2ZrF6 + 12H2O + 4HF -> 6ZrO2 + 36HF + 4HF
ROASTER.recipeBuilder()
    .fluidInputs(fluid('fluoride_scrub_raffinate') * 20000)
    .fluidInputs(fluid('steam') * 6000)
    .outputs(metaitem('dustFusedZirconia') * 9)
    .fluidOutputs(fluid('hydrogen_fluoride') * 20000)
    .EUt(VA[HV])
    .duration(400)
    .buildAndRegister()