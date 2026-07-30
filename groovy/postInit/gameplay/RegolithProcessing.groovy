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

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustAnorthositicRegolith") * 4)
    .outputs(metaitem("dustAnorthosite") * 4)
    .chancedOutput(metaitem("dustLunarMagnetic") * 1, 3000, 0)
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
    .fluidInputs(fluid("lunar_ilmenite_slurry") * 100)
    .notConsumable(fluid("sodium_silicate_solution") * 1000)
    .notConsumable(fluid("oleic_acid") * 100)
    .notConsumable(fluid("sodium_ethyl_xanthate") * 100)
    .fluidOutputs(fluid("lunar_troilite_slurry") * 100)
    .fluidOutputs(fluid("lunar_silicate_slurry") * 900)
    .EUt(VA[LV])
    .duration(300)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .fluidInputs(fluid("lunar_ilmenite_slurry") * 100)
    .notConsumable(fluid("sodium_silicate_solution") * 1000)
    .notConsumable(fluid("oleic_acid") * 100)
    .notConsumable(fluid("sodium_ethyl_xanthate") * 100)
    .fluidOutputs(fluid("lunar_troilite_slurry") * 100)
    .fluidOutputs(fluid("lunar_silicate_slurry") * 900)
    .EUt(VA[LV])
    .duration(30)
    .buildAndRegister()

// FeTiO3(H2O) + 2H -> Fe + TiO2 + 2H2O
ERF.recipeBuilder()
    .fluidInputs(fluid("lunar_ilmenite_slurry") * 1000)
    .fluidInputs(fluid("hydrogen") * 1000)
    .fluidOutputs(fluid("water") * 2000)
    .outputs(metaitem("dustIron"))
    .outputs(metaitem("dustTitaniumDioxide") * 3)
    .temperature(1800)

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
// $stoik CaAl2Si2O8 + 2HCl + 2H2O -> CaCl2 + Al2Si2O7(H2O)3
// $stoik 2NaAlSi3O8 + 2HCl + 2H2O -> 2NaCl + Al2Si6O15(H2O)3 (gel)
BR.recipeBuilder()
    .inputs(metaitem("dustAnorthosite") * 13)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 3900)
    .fluidOutputs(fluid("leached_anorthosite") * 3900)
    .EUt(VA[LV])
    .duration(200)

// Same but with the silicate stuff
BR.recipeBuilder()
    .fluidInputs(fluid("lunar_silicate_slurry") * 1950)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 1950)
    .fluidOutputs(fluid("leached_anorthosite") * 3900)
    .EUt(VA[LV])
    .duration(200)

ROASTER.recipeBuilder()
    .fluidInputs(fluid("leached_anorthosite") * 3900)
    .outputs(metaitem("dustLeachedAnorthosite") * 13)
    .fluidOutputs(fluid("dense_steam") * 3900)
    .EUt(VA[LV])
    .duration(200)

// .95 CaCl2 + .05 NaCl coming out
BR.recipeBuilder()
    .inputs(metaitem("dustLeachedAnorthosite") * 13)
    .fluidInputs(fluid("water") * 1000)
    .inputs(metaitem("dustAnorthositeAluminosilicate") * 13)
    .fluidOutputs(fluid("alkali_anorthositic_chlorides") * 1000)
    .EUt(VA[LV])
    .duration(200)

// 0.95 Al2Si2O7 + 0.025 Al2Si6O15 + NaOH
// If I multiply by 40...
// $stoik (38 Al2Si2O7 + Al2Si6O15) + 78NaOH(H2O) -> 39(NaAlO2)2(H2O)3 + 82SiO2
// Remove 4 SiO2 and it's OK
// 520 dust + 78NaOH(H2O) -> 39(NaAlO2)2(H2O)3 + 78SiO2
// 40 dust + 6NaOH(H2O) -> 13(NaAlO2)2(H2O)3 + 6SiO2
// + one extra division in half
BR.recipeBuilder()
    .inputs(metaitem("dustAnorthositeAluminosilicate") * 20)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 3000)
    .outputs(metaitem("dustSiliconDioxide") * 9) // TODO: there's actually pyroxenes and olivines in here if they didn't just get obliterated by NaOH
    .fluidOutputs(fluid("sodium_aluminate_solution") * 6500)
    .EUt(VA[LV])
    .duration(400)

// (19 CaCl2 + NaCl)(20H2O) + 38NaOH(H2O) -> 19Ca(OH)2 + 39NaCl + 58H2O
// Fortunately we can scale down the recipe 5x
BR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid("alkali_anorthositic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 19)
    .fluidOutputs(fluid("lunar_salt_water") * 11600)
    .EUt(VA[LV])
    .duration(80)

// But what if you're really careful?
// https://www.sciencedirect.com/science/article/abs/pii/S0003267001823849
BR.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid("alkali_anorthositic_chlorides") * 4000)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 18)
    .outputs(metaitem("dustStrontiumHydroxide") * 1)
    .fluidOutputs(fluid("lunar_salt_water") * 11600)
    .EUt(VA[LV])
    .duration(800)


// Lunar salt water reprocessing
DISTILLATION.recipeBuilder()
    .fluidInputs(fluid("lunar_salt_water") * 29000)
    .fluidOutputs(fluid("water") * 29000)
    .outputs(metaitem("dustSalt") * 39)
    .EUt(VA[MV])
    .duration(400)

// 39NaCl58H2O + 7H2O -> 13H + 13Cl + 13NaOH + 26NaCl(H2O)2
// (same NaOH to NaCl(H2O)2 ratio as the original recipe)
ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('graphite_electrode'))
    .notConsumable(ore('plateAsbestos'))
    .fluidInputs(fluid('lunar_salt_water') * 5800)
    .fluidInputs(fluid('water') * 700)
    .fluidOutputs(fluid('chlorine') * 1300)
    .fluidOutputs(fluid('hydrogen') * 1300)
    .fluidOutputs(fluid('diluted_salt_water') * 2600)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 1300)
    .EUt(VA[LV])
    .duration(720)
    .buildAndRegister()