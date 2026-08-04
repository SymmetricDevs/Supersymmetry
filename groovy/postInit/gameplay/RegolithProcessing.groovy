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
    .outputs(metaitem("dustAnorthosite") * 1)
    .outputs(metaitem("dustLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 5000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustAnorthositicRegolith") * 4)
    .outputs(metaitem("dustAnorthosite") * 4)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 300, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustBasalticRegolith") * 4)
    .outputs(metaitem("dustAnorthosite") * 1)
    .outputs(metaitem("dustLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 5000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustKreepRegolith") * 4)
    .outputs(metaitem("dustAnorthosite") * 1)
    .outputs(metaitem("dustLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 6000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(metaitem("dustAnorthosite"))
    .outputs(metaitem("dustDegassedAnorthosite"))
    .fluidOutputs(fluid("regolith_gases") * 100)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()


ROASTER.recipeBuilder()
    .inputs(metaitem("dustLunarBasalt"))
    .outputs(metaitem("dustDegassedLunarBasalt"))
    .fluidOutputs(fluid("regolith_gases") * 100)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()


// Ilmenite flotation
CSTR.recipeBuilder()
    .inputs(metaitem("dustLunarBasalt") * 1)
    .fluidInputs(fluid("water") * 1000)
    .notConsumable(fluid("sodium_silicate_solution") * 100)
    .notConsumable(fluid("oleic_acid") * 100)
    .notConsumable(fluid("methyl_isobutyl_carbinol") * 100)
    .fluidOutputs(fluid("lunar_ilmenite_slurry") * 100)
    .fluidOutputs(fluid("lunar_ferrosilicate_slurry") * 900)
    .EUt(VA[LV])
    .duration(300)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .inputs(metaitem("dustLunarBasalt") * 1)
    .fluidInputs(fluid("water") * 1000)
    .notConsumable(fluid("sodium_silicate_solution") * 100)
    .notConsumable(fluid("oleic_acid") * 100)
    .notConsumable(fluid("methyl_isobutyl_carbinol") * 100)
    .fluidOutputs(fluid("lunar_ilmenite_slurry") * 100)
    .fluidOutputs(fluid("lunar_ferrosilicate_slurry") * 900)
    .EUt(VA[LV])
    .duration(30)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid("lunar_ferrosilicate_slurry") * 100)
    .notConsumable(fluid("sodium_silicate_solution") * 1000)
    .notConsumable(fluid("oleic_acid") * 100)
    .notConsumable(metaitem("dustSodiumEthylXanthate") * 1)
    .fluidOutputs(fluid("lunar_troilite_slurry") * 100)
    .fluidOutputs(fluid("lunar_silicate_slurry") * 900)
    .EUt(VA[LV])
    .duration(300)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .fluidInputs(fluid("lunar_ferrosilicate_slurry") * 100)
    .notConsumable(fluid("sodium_silicate_solution") * 1000)
    .notConsumable(fluid("oleic_acid") * 100)
    .notConsumable(metaitem("dustSodiumEthylXanthate") * 1)
    .fluidOutputs(fluid("lunar_troilite_slurry") * 100)
    .fluidOutputs(fluid("lunar_silicate_slurry") * 900)
    .EUt(VA[LV])
    .duration(30)
    .buildAndRegister()

// FeTiO3(H2O) + 2H -> Fe + TiO2 + 2H2O
SOLAR_FURNACE.recipeBuilder()
    .fluidInputs(fluid("lunar_ilmenite_slurry") * 1000)
    .fluidInputs(fluid("hydrogen") * 2000)
    .fluidOutputs(fluid("dense_steam") * 2000)
    .outputs(metaitem("dustIron"))
    .outputs(metaitem("dustRutile") * 3)
    .duration(9999999)
    .EUt(2147483647)//placeholder for the actual solar furnace
    //.temperature(1800)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('lunar_troilite_slurry') * 1000)
    .outputs(metaitem('dustTroilite') * 2)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('lunar_troilite_slurry') * 1000)
    .outputs(metaitem('dustTroilite') * 2)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[ULV])
    .duration(300)
    .buildAndRegister()


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


// Same but with the silicate stuff, although this also includes 0.25mol olivine (and pyroxenes but that's too much for t1)
// Mg2SiO4 + 4HCl + 8H2O -> 2MgCl2 + SiO2 + 10H2O

BR.recipeBuilder()
    .fluidInputs(fluid("lunar_silicate_slurry") * 1950)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 5900)
    .fluidOutputs(fluid("lunar_basalt_leach") * 6400)
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


// .95 CaCl2 + .05 NaCl coming out
BR.recipeBuilder()
    .inputs(metaitem("dustLeachedAnorthosite") * 13)
    .fluidInputs(fluid("water") * 1000)
    .outputs(metaitem("dustAnorthositeAluminosilicate") * 13)
    .fluidOutputs(fluid("alkali_anorthositic_chlorides") * 1000)
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
