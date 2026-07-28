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
    .chancedOutput(metaitem("dustLunarNodule") * 1, 3000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustBasalticRegolith") * 4)
    .outputs(metaitem("dustAnorthosite") * 1)
    .outputs(metaitem("dustLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarNodule") * 1, 5000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
    .inputs(metaitem("dustKreepRegolith") * 4)
    .outputs(metaitem("dustAnorthosite") * 1)
    .outputs(metaitem("dustLunarBasalt") * 3)
    .chancedOutput(metaitem("dustLunarNodule") * 1, 6000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()


MIXER.recipeBuilder()
    .inputs(metaitem("dustLunarBasalt") * 3)

// 95% anorthite, 5% albite
// $stoik CaAl2Si2O8 + 8 HCl + 8 H2O -> CaCl2 + 2 AlCl3(H2O)6 + 2 SiO2
// $stoik NaAlSi3O8 + 4HCl(H2O) -> NaCl + AlCl3 + 3SiO2 + 6H2O
// .95CaAl2Si2O8 + 7.6 HCl + 7.6 H2O -> .95CaCl2 + 1.9 AlCl3(H2O)6 + 1.9 SiO2
// .5NaAlSi3O8 + .2 HCl + .2 H2O -> .05NaCl + .05 AlCl3(H2O)6 + .15 SiO2
// 13 dust + 7.8HCl(H2O) -> .95CaCl2 + .05NaCl + 1.95 AlCl3(H2O)6 + 2.05 SiO2
BR.recipeBuilder()
    .inputs(metaitem("dustAnorthosite") * 3)
    .fluidInputs(fluid("diluted_hydrochloric_acid") * 3600)
    .fluidOutputs(fluid("anorthositic_chlorides") * 3600)
    .outputs(metaitem("dustSiliconDioxide")) // slight loss compared to the actual 2.05*3*3/13=1.41 dust possible but I'm not doing that
    .EUt(VA[LV])
    .duration(200)

// 2 * .95 + 1 + .05 -> 1.95 AlCl3 per mole anorthosite, 0.15 per dust
// 0.75 AlCl3(H2O)6 -> 0.75 Al(OH)3 + 9/4 HCl(H2O)
DRYER.recipeBuilder()
    .fluidInputs(fluid("anorthositic_chlorides") * 6000)
    .outputs(metaitem("dustDriedAnorthositicChlorides") * 5)
    .fluidOutputs(fluid("hydrochloric_acid") * 2250)
    .EUt(VA[LV])
    .duration(400)

// 3 Al(OH)3
// 20/13 anorthosite in here, which is:
// 1/13 NaCl
// 19/13 CaCl2
BR.recipeBuilder()
    .inputs(metaitem("dustDriedAnorthositicChlorides") * 20)
    .fluidInputs(fluid("water") * 500)
    .outputs(metaitem("dustAluminiumHydroxide") * 21)
    .fluidOutputs(fluid("alkali_anorthositic_chlorides") * 500)
    .EUt(VA[LV])
    .duration(80)

// 19 CaCl2 + NaCl + 38NaOH(H2O) -> 19Ca(OH)2 + 39NaCl + 38H2O
// Fortunately we can scale down the recipe 5x
BR.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid("alkali_anorthositic_chlorides") * 1300)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 18)
    .fluidOutputs(fluid("lunar_salt_water") * 7600)
    .EUt(VA[LV])
    .duration(80)

// But what if you're really careful?
// https://www.sciencedirect.com/science/article/abs/pii/S0003267001823849
BR.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid("alkali_anorthositic_chlorides") * 1300)
    .fluidInputs(fluid("sodium_hydroxide_solution") * 7600)
    .outputs(metaitem("dustCalciumHydroxide") * 18)
    .outputs(metaitem("dustStrontiumHydroxide") * 1)
    .fluidOutputs(fluid("lunar_salt_water") * 7600)
    .EUt(VA[LV])
    .duration(800)

DISTILLATION.recipeBuilder()
    .fluidInputs(fluid("lunar_salt_water") * 19000)
    .fluidOutputs(fluid("water") * 19000)
    .outputs(metaitem("dustSalt") * 39)
    .EUt(VA[LV])
    .duration(400)