import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Vinyl Chloride

ROASTER.recipeBuilder()
    .fluidInputs(fluid('mercury') * 1000)
    .fluidInputs(fluid('chlorine') * 2000)
    .outputs(metaitem('dustMercuryIiChloride') * 3)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Klatte process
TBR.recipeBuilder()
    .notConsumable(metaitem('dustMercuryIiChloride'))
    .fluidInputs(fluid('acetylene') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('vinyl_chloride') * 50)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

// Dehydrochlorination
PYROLYSE_OVEN.recipeBuilder()
    .fluidInputs(fluid('one_two_dichloroethane') * 1000)
    .fluidOutputs(fluid('cracked_one_two_dichloroethane_mix') * 2000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

// https://koreascience.kr/article/JAKO200211920879285.pdf
DT.recipeBuilder()
    .fluidInputs(fluid('cracked_one_two_dichloroethane_mix') * 2000)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .fluidOutputs(fluid('vinyl_chloride') * 500)
    .fluidOutputs(fluid('acetylene') * 200)
    .fluidOutputs(fluid('one_one_dichloroethane') * 200)
    .fluidOutputs(fluid('ethylene') * 50)
    .fluidOutputs(fluid('one_two_dichloroethylene') * 50)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister()

// PVC

AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('vinyl_chloride') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('vinyl_chloride_suspension') * 2000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('vinyl_chloride_suspension') * 2000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('polyvinyl_chloride_suspension') * 2000)
    .duration(300)
    .EUt(60)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('polyvinyl_chloride_suspension') * 2000)
    .outputs(metaitem('dustPolyvinylChloride'))
    .fluidOutputs(fluid('water') * 1000)
    .duration(260)
    .EUt(VA[LV])
    .buildAndRegister()

// Polyvinyl Acetate

MIXER.recipeBuilder()
    .fluidInputs(fluid('vinyl_acetate') * 1000)
    .fluidInputs(fluid('methanol') * 1000)
    .fluidOutputs(fluid('vinyl_acetate_suspension') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('vinyl_acetate_suspension') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('polyvinyl_acetate_suspension') * 1000)
    .duration(150)
    .EUt(60)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('polyvinyl_acetate_suspension') * 1000)
    .outputs(metaitem('dustPolyvinylAcetate'))
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(50)
    .buildAndRegister()

// Ethylene-vinyl acetate

POLYMERIZATION_TANK.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('ethylene') * 1000)
    .fluidInputs(fluid('vinyl_acetate_suspension') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('ethylene_vinyl_acetate_suspension') * 2000)
    .duration(150)
    .EUt(60)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('ethylene_vinyl_acetate_suspension') * 2000)
    .outputs(metaitem('dustEthyleneVinylAcetate'))
    .fluidOutputs(fluid('methanol') * 1000)
    .duration(50)
    .buildAndRegister()
