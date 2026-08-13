import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

LUNAR_BWE.recipeBuilder()
    .notConsumable(item("susy:regolith"))
    .outputs(item("susy:regolith") * 16)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(item("susy:regolith"))
    .outputs(metaitem("dustAnorthositicRegolith") * 8)
    .EUt(VA[MV])
    .duration(50)
    .buildAndRegister()

LUNAR_BWE.recipeBuilder()
    .notConsumable(item("susy:regolith", 1))
    .outputs(item("susy:regolith", 1) * 16)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(item("susy:regolith", 1))
    .outputs(metaitem("dustBasalticRegolith") * 8)
    .EUt(VA[MV])
    .duration(50)
    .buildAndRegister()

LUNAR_BWE.recipeBuilder()
    .notConsumable(item("susy:regolith", 2))
    .outputs(item("susy:regolith", 2) * 16)
    .EUt(VA[HV])
    .duration(20)
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(item("susy:regolith", 2))
    .outputs(metaitem("dustKreepRegolith") * 8)
    .EUt(VA[MV])
    .duration(50)
    .buildAndRegister()

// Tier 1

ELECTROSTATIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustBasalticRegolith") * 4)
    .outputs(metaitem("dustDemagnetizedAnorthosite") * 1)
    .outputs(metaitem("dustLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 5000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustAnorthositicRegolith") * 4)
    .outputs(metaitem("dustDemagnetizedAnorthosite") * 4)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 300, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustBasalticRegolith") * 4)
    .outputs(metaitem("dustDemagnetizedAnorthosite") * 1)
    .outputs(metaitem("dustDemagnetizedLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 5000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustKreepRegolith") * 4)
    .outputs(metaitem("dustDemagnetizedKreepAnorthosite") * 1)
    .outputs(metaitem("dustDemagnetizedLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 6000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
    .inputs(metaitem("dustDemagnetizedAnorthosite"))
    .outputs(metaitem("dustAnorthosite"))
    .fluidOutputs(fluid("regolith_gases") * 1)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()


RESISTANCE_FURNACE.recipeBuilder()
    .inputs(metaitem("dustDemagnetizedLunarBasalt"))
    .outputs(metaitem("dustLunarBasalt"))
    .fluidOutputs(fluid("regolith_gases") * 1)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
    .inputs(metaitem("dustDemagnetizedKreepAnorthosite"))
    .outputs(metaitem("dustKreepAnorthosite"))
    .fluidOutputs(fluid("regolith_gases") * 1)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()


// Lunar Magnetic Dust Processing
// Change the output amounts if accurate info found
ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustLunarMagnetic"))
    .outputs(metaitem("dustNativeLunarIron"))
    .chancedOutput(metaitem("dustHematite") * 1, 5000, 0)
    .chancedOutput(metaitem("dustIlmenite") * 1, 5000, 0)
    .chancedOutput(metaitem("dustChromite") * 1, 2500, 0)
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(metaitem("dustNativeLunarIron"))
    .fluidInputs(fluid("carbon_monoxide") * 4000)
    .outputs(metaitem("dustIron"))
    .fluidOutputs(fluid("nickel_carbonyl") * 1000)
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid("nickel_carbonyl") * 1000)
    .outputs(metaitem("dustNickel"))
    .fluidOutputs(fluid("carbon_monoxide") * 4000)
    .EUt(1500)
    .duration(45)
    .buildAndRegister()

// Ilmenite flotation
builders = [CSTR, FROTH_FLOTATION]
durations = [300, 30]

def flotation_stats = [
        [builder: CSTR, duration: 300],
        [builder: FROTH_FLOTATION, duration: 30]
]

flotation_stats.each { flotation_machine ->
    flotation_machine.builder.recipeBuilder()
        .inputs(metaitem("dustKreepAnorthosite") * 1)
        .fluidInputs(fluid("water") * 1000)
        .notConsumable(fluid("sodium_silicate_solution") * 100)
        .notConsumable(fluid('alkaline_sodium_oleate_solution') * 1000)
        .notConsumable(fluid('heavy_gas_oil') * 100)
        .fluidOutputs(fluid('lunar_phosphate_concentrate_slurry') * 100)
        .fluidOutputs(fluid("lunar_kreep_ferrosilicate_slurry") * 900)
        .EUt(VA[LV])
        .duration(flotation_machine.duration)
        .buildAndRegister()

    flotation_machine.builder.recipeBuilder()
        .inputs(metaitem("dustDemagnetizedKreepAnorthosite") * 1)
        .fluidInputs(fluid("water") * 1000)
        .notConsumable(fluid("sodium_silicate_solution") * 100)
        .notConsumable(fluid('alkaline_sodium_oleate_solution') * 1000)
        .notConsumable(fluid('heavy_gas_oil') * 100)
        .fluidOutputs(fluid("lunar_phosphate_concentrate_slurry") * 100)
        .fluidOutputs(fluid("lunar_kreep_ferrosilicate_slurry") * 900)
        .EUt(VA[LV])
        .duration(flotation_machine.duration)
        .buildAndRegister()

    flotation_machine.builder.recipeBuilder()
        .inputs(metaitem("dustLunarBasalt") * 1)
        .fluidInputs(fluid("water") * 1000)
        .notConsumable(fluid("sodium_silicate_solution") * 100)
        .notConsumable(fluid("oleic_acid") * 100)
        .notConsumable(fluid("methyl_isobutyl_carbinol") * 100)
        .fluidOutputs(fluid("lunar_ilmenite_slurry") * 100)
        .fluidOutputs(fluid("lunar_ferrosilicate_slurry") * 900)
        .EUt(VA[LV])
        .duration(flotation_machine.duration)
        .buildAndRegister()

    flotation_machine.builder.recipeBuilder()
        .inputs(metaitem("dustDemagnetizedLunarBasalt") * 1)
        .fluidInputs(fluid("water") * 1000)
        .notConsumable(fluid("sodium_silicate_solution") * 100)
        .notConsumable(fluid("oleic_acid") * 100)
        .notConsumable(fluid("methyl_isobutyl_carbinol") * 100)
        .fluidOutputs(fluid("lunar_ilmenite_slurry") * 100)
        .fluidOutputs(fluid("lunar_ferrosilicate_slurry") * 900)
        .EUt(VA[LV])
        .duration(flotation_machine.duration)
        .buildAndRegister()

    flotation_machine.builder.recipeBuilder()
        .fluidInputs(fluid("lunar_ferrosilicate_slurry") * 1000)
        .notConsumable(fluid("sodium_silicate_solution") * 1000)
        .notConsumable(fluid("oleic_acid") * 100)
        .notConsumable(metaitem("dustSodiumEthylXanthate") * 1)
        .fluidOutputs(fluid("lunar_troilite_slurry") * 100)
        .fluidOutputs(fluid("lunar_silicate_slurry") * 900)
        .EUt(VA[LV])
        .duration(flotation_machine.duration)
        .buildAndRegister()

    // another optional recipe, specifically if someone just wants to process the plagioclase separately (or not at all)
    flotation_machine.builder.recipeBuilder()
        .fluidInputs(fluid('lunar_silicate_slurry') * 3000)
        .notConsumable(fluid("sodium_silicate_solution") * 1000)
        .notConsumable(ore('dustOctylHydroxamicAcid') * 1)
        .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
        .fluidOutputs(fluid('lunar_plagioclase_slurry') * 1000)
        .fluidOutputs(fluid('lunar_mafic_slurry') * 2000)
        .EUt(VA[LV])
        .duration(flotation_machine.duration)
        .buildAndRegister()
}

// FeTiO3(H2O) + 2H -> Fe + TiO2 + 2H2O
SOLAR_FURNACE.recipeBuilder()
    .fluidInputs(fluid("lunar_ilmenite_slurry") * 1000)
    .fluidInputs(fluid("hydrogen") * 2000)
    .fluidOutputs(fluid("dense_steam") * 2000)
    .outputs(metaitem("dustIron"))
    .outputs(metaitem("dustRutile") * 3)
    .duration(150)
    .EUt(12000)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('lunar_troilite_slurry') * 1000)
    .outputs(metaitem('dustIronIiSulfide') * 2)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('lunar_troilite_slurry') * 1000)
    .outputs(metaitem('dustIronIiSulfide') * 2)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[ULV])
    .duration(300)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('lunar_plagioclase_slurry') * 1000)
    .outputs(metaitem('dustAnorthosite') * 13)
    .fluidOutputs(fluid('wastewater') * 800)
    .EUt(VA[LV])
    .duration(40)
    .buildAndRegister()

// Various leaches

// 95% anorthite, 5% albite
// $stoik CaAl2Si2O8 + 2HCl + 4H2O -> CaCl2 + Al2Si2O7(H2O)3 + 2H2O
// $stoik 2NaAlSi3O8 + 2HCl + 4H2O -> 2NaCl + Al2Si6O15(H2O)3 (gel) + 2H2O
BR.recipeBuilder()
    .inputs(metaitem("dustAnorthosite") * 13)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 3900)
    .fluidOutputs(fluid("anorthosite_leach") * 3900)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(metaitem("dustKreepAnorthosite") * 13)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 3900)
    .fluidOutputs(fluid("anorthosite_leach") * 3900)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem("dustDemagnetizedAnorthosite") * 13)
        .fluidInputs(fluid("diluted_hydrochloric_acid") * 3900)
        .fluidOutputs(fluid("anorthosite_leach") * 3900)
        .EUt(VA[LV])
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem("dustDemagnetizedKreepAnorthosite") * 13)
        .fluidInputs(fluid("diluted_hydrochloric_acid") * 3900)
        .fluidOutputs(fluid("anorthosite_leach") * 3900)
        .EUt(VA[LV])
        .duration(200)
        .buildAndRegister()

// Same but with the silicate stuff, although this also includes 0.25mol olivine (and pyroxenes but that's too much for t1)
// Mg2SiO4 + 4HCl + 8H2O -> 2MgCl2 + SiO2 + 10H2O

// CaFeSi2O6 passes through unreacted and is filtered off as dustLunarPyroxene.
BR.recipeBuilder()
    .fluidInputs(fluid('lunar_mafic_slurry') * 2000)
    .fluidInputs(fluid('diluted_hydrochloric_acid') * 7800)
    .fluidOutputs(fluid('lunar_basalt_leach') * 7800)
    .outputs(metaitem('dustLunarPyroxene'))
    .EUt(VA[MV])
    .duration(300)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('lunar_silicate_slurry') * 3000)
    .fluidInputs(fluid('diluted_hydrochloric_acid') * 11700)
    .fluidOutputs(fluid('lunar_basalt_leach') * 11700)
    .outputs(metaitem('dustLunarPyroxene'))  // off to PyroxeneProcessing.groovy
    .EUt(VA[MV])
    .duration(400)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid("lunar_kreep_silicate_slurry") * 1950)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 3900)
    .fluidOutputs(fluid("lunar_kreep_anorthosite_leach") * 5850)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid("anorthosite_leach") * 3900)
    .outputs(metaitem("dustLeachedAnorthosite") * 13)
    .fluidOutputs(fluid("dense_steam") * 3900)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid("lunar_basalt_leach") * 6400)
    .outputs(metaitem("dustLeachedLunarBasalt") * 13)
    .fluidOutputs(fluid("dense_steam") * 6400)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid("lunar_kreep_anorthosite_leach") * 5850)
    .outputs(metaitem("dustLeachedKreepAnorthosite") * 13)
    .fluidOutputs(fluid("dense_steam") * 5850)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

// .95 CaCl2 + .05 NaCl coming out
BR.recipeBuilder()
    .inputs(metaitem("dustLeachedAnorthosite") * 13)
    .fluidInputs(fluid("water") * 1000)
    .outputs(metaitem("dustAnorthositeAluminosilicate") * 13)
    .fluidOutputs(fluid("alkali_anorthositic_chlorides") * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

// Mix .025 NaCl and .025 KCl
BR.recipeBuilder()
    .inputs(metaitem("dustLeachedKreepAnorthosite") * 13)
    .fluidInputs(fluid("water") * 1000)
    .outputs(metaitem("dustAnorthositeAluminosilicate") * 13)
    .fluidOutputs(fluid("alkali_kreep_anorthositic_chlorides") * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(metaitem("dustLeachedLunarBasalt") * 13)
    .fluidInputs(fluid("water") * 1000)
    .outputs(metaitem("dustAnorthositeAluminosilicate") * 13)
    .fluidOutputs(fluid("alkali_basaltic_chlorides") * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()


// 0.95 Al2Si2O7 + 0.025 Al2Si6O15 + NaOH
// If I multiply by 40...
// $stoik (38 Al2Si2O7 + Al2Si6O15) + 78NaOH(H2O) -> 39(NaAlO2)2(H2O)3 + 82SiO2
// Remove 4 SiO2 and it's OK
// 520 dust + 78NaOH(H2O) -> 39(NaAlO2)2(H2O)3 + 78SiO2
// 40 dust + 6NaOH(H2O) -> 3(NaAlO2)2(H2O)3 + 6SiO2
// + one extra division in half
BR.recipeBuilder()
    .inputs(metaitem("dustAnorthositeAluminosilicate") * 20)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 3000)
    .outputs(metaitem("dustSiliconDioxide") * 9)
    .fluidOutputs(fluid("sodium_aluminate_solution") * 4500)
    .EUt(VA[LV])
    .duration(400)
    .buildAndRegister()


// (19 CaCl2 + NaCl)(20H2O) + 38NaOH(H2O) -> 19Ca(OH)2 + 39NaCl + 58H2O
// The salt is 20000 salt water, 38000 diluted salt water
// Fortunately we can scale down the recipe 5x
BR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid("alkali_anorthositic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 19)
    .fluidOutputs(fluid("salt_water") * 4000)
    .fluidOutputs(fluid("diluted_salt_water") * 7600)
    .EUt(VA[LV])
    .duration(80)
    .buildAndRegister()

BR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid("alkali_kreep_anorthositic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 19)
    .fluidOutputs(fluid("salt_water") * 4000)
    .fluidOutputs(fluid("diluted_salt_water") * 7600)
    .EUt(VA[LV])
    .duration(80)
    .buildAndRegister()


// But what if you're really careful?
// https://www.sciencedirect.com/science/article/abs/pii/S0003267001823849
BR.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid("alkali_anorthositic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 18)
    .outputs(metaitem("dustStrontiumHydroxide") * 1)
    .fluidOutputs(fluid("salt_water") * 4000)
    .fluidOutputs(fluid("diluted_salt_water") * 7600)
    .EUt(VA[LV])
    .duration(800)
    .buildAndRegister()


// MgCl2 + 2NaOH -> Mg(OH)2 + 2NaCl
// (19 CaCl2 + 5MgCl2 + NaCl)(20H2O) + 48NaOH(H2O) -> 5Mg(OH)2 + 19Ca(OH)2 + 49NaCl + 68H2O
// The salt is 30000 salt water, 38000 diluted salt water
// Fortunately we can scale down the recipe 5x
BR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid("alkali_basaltic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 9600)
    .outputs(metaitem("dustCalciumHydroxide") * 19)
    .outputs(metaitem("dustMagnesiumHydroxide") * 5)
    .fluidOutputs(fluid("salt_water") * 6000)
    .fluidOutputs(fluid("diluted_salt_water") * 7600)
    .EUt(VA[LV])
    .duration(160)
    .buildAndRegister()

// But what if you're really careful, again?
// Since Mn is the one remaining cation that can be oxidized, we can use:
// https://en.wikipedia.org/wiki/Winkler_titration
// $stoik 2MnCl2 + 4NaOH + O2 -> 2MnO2 + 4NaCl + 2H2O
// Mn rides in as the tephroite component of the olivine and so is not carried in the idealised
// (19 CaCl2 + 5 MgCl2 + NaCl) formula. 4000 L of liquor is ~0.05 mol Mn; the O2 is sparged in
// excess, and the trace NaOH it consumes is absorbed in the existing charge.
BR.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid("alkali_basaltic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 9600)
    .fluidInputs(fluid("oxygen") * 50)
    .outputs(metaitem("dustCalciumHydroxide") * 19)
    .outputs(metaitem("dustMagnesiumHydroxide") * 5)
    .fluidOutputs(fluid("lunar_manganese_slurry") * 1000)
    .fluidOutputs(fluid("salt_water") * 6000)
    .fluidOutputs(fluid("diluted_salt_water") * 6600)   // 1000 L leaves with the slurry (RIP small amount of sodium)
    .EUt(VA[LV])
    .duration(1600)                                     // 10x circuit 1, as with the Sr step
    .buildAndRegister()

// Tier 2
// Regolith gas:
// 25% CO
// 5/32 C2H4
// 1/32 CO2
// 1/32 CH3OH
// 1/32 CH4
// 1/32 NH3
// 15/32 H/He

MACERATOR.recipeBuilder()
    .inputs(item('susy:deposit_block', 6))
    .outputs(metaitem("dustIcyRegolith") * 8)
    .EUt(VA[MV])
    .duration(50)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(metaitem("dustIcyRegolith") * 1)
    .fluidOutputs(fluid("regolith_gases") * 100)
    .fluidOutputs(fluid("water") * 400)
    .outputs(metaitem("dustLunarBasalt"))
    .EUt(2000)
    .duration(800)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .inputs(ore('dustMolecularSieveX'))
    .fluidInputs(fluid('regolith_gases') * 640)
    .fluidOutputs(fluid('decarburized_regolith_gases') * 620)
    .outputs(metaitem('dustCarbonatedMolecularSieveX'))
    .duration(4)
    .EUt(VA[LV])
    .buildAndRegister()

FLUID_COMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('decarburized_regolith_gases') * 1000)
    .fluidOutputs(fluid('high_pressure_decarburized_regolith_gases') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

CONDENSER.recipeBuilder()
    .fluidInputs(fluid('high_pressure_decarburized_regolith_gases') * 620)
    .fluidOutputs(fluid('methanol') * 20)
    .fluidOutputs(fluid('high_pressure_regolith_gases') * 600)  // 323 K
    .duration(100)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('high_pressure_regolith_gases') * 600)
    .fluidInputs(fluid('water') * 20)
    .fluidOutputs(fluid('ammonia_solution') * 20)
    .fluidOutputs(fluid('high_pressure_regolith_light_gases') * 580)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()


HIGH_PRESSURE_CRYO_DT.recipeBuilder()
    .fluidInputs(fluid('high_pressure_regolith_light_gases') * 580)
    .fluidOutputs(fluid('ethylene') * 100)
    .fluidOutputs(fluid('methane') * 20)
    .fluidOutputs(fluid('carbon_monoxide') * 160)
    .fluidOutputs(fluid('hydrogen_helium_mixture') * 300) // 82 K
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('hydrogen_helium_mixture') * 3750)
    .fluidInputs(fluid('oxygen') * 1750)
    .outputs(metaitem('dustSmallIce') * 7)
    .fluidOutputs(fluid('helium') * 250)
    .duration(50)
    .EUt(VA[LV])
    .buildAndRegister()

// Phosphorite processing
// According to https://claude.ai/share/28a8aa64-d4d0-446f-a54a-da74a429b93d:
// About a 2:3:1 stoichiometric ratio of merrillite, fluorapatite, and chlorapatite
// Wet process:
// Ca18Na2Mg2(PO4)14 + 21H2SO4(H2O) + 29H2O -> 18CaSO4(H2O)2 + Na2SO4 + 2MgSO4 + 14H3PO4(H2O)
// 3Ca5(PO4)3F + Ca5(PO4)3Cl + H2SO4(H2O) -> 20CaSO4(H2O)2 + 12H3PO4 
// Overall:
// 2Ca18Na2Mg2(PO4)14 + 3Ca5(PO4)3F + Ca5(PO4)3Cl + 62H2SO4(H2O) + 90H2O -> 56CaSO4(H2O)2 + 3HF + HCl + 2Na2SO4 + 4MgSO4 + 40H3PO4(H2O)
// Add silicon dioxide 

BR.recipeBuilder()
    .fluidInputs(fluid('lunar_phosphate_concentrate_slurry') * 9000)
    .fluidInputs(fluid('sulfuric_acid') * 6200)
    .fluidOutputs(fluid('impure_phosphoric_acid') * 4000)
    .fluidOutputs(fluid('halogen_mix') * 400)
    .EUt(VA[MV])
    .duration(300)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('halogen_mix') * 1000)
    .fluidOutputs(fluid('hydrogen_fluoride') * 750)
    .fluidOutputs(fluid('hydrogen_chloride') * 250)
    .EUt(VA[MV])
    .duration(40)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('impure_phosphoric_acid') * 4000)
    .fluidInputs(fluid('methyl_isobutyl_ketone') * 4000)
    .fluidOutputs(fluid('waste_gypsum') * 4000)
    .fluidOutputs(fluid('phosphoric_acid_extract') * 4000)
    .requiredCells(4)
    .EUt(VA[HV])
    .duration(400)
    .buildAndRegister()

MIXER_SETTLER.recipeBuilder()
    .fluidInputs(fluid('phosphoric_acid_extract') * 4000)
    .fluidInputs(fluid('distilled_water') * 4000)
    .fluidOutputs(fluid('methyl_isobutyl_ketone') * 4000)
    .fluidOutputs(fluid('phosphoric_acid') * 4000)
    .duration(100)
    .EUt(VA[HV])
    .requiredCells(2)
    .buildAndRegister()

// Pyroxene processing