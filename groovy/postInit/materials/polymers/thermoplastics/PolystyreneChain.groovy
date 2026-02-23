import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Styrene 

FIXED_BR.recipeBuilder()
    .fluidInputs(fluid('ethylbenzene') * 50)
    .fluidInputs(fluid('dense_steam') * 50)
    .notConsumable(ore('catalystBedIronIiiOxide'))
    .fluidOutputs(fluid('crude_styrene') * 50)
    .fluidOutputs(fluid('hydrogen') * 90)
    .duration(2)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('crude_styrene') * 1000)
    .fluidOutputs(fluid('styrene') * 900)
    .fluidOutputs(fluid('ethylbenzene') * 100)
    .duration(30)
    .EUt(VA[LV])
    .buildAndRegister()

// Polysterene

MIXER.recipeBuilder()
    .fluidInputs(fluid('styrene') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('styrene_suspension') * 2000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('styrene_suspension') * 2000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('polystyrene_suspension') * 2000)
    .duration(300)
    .EUt(60)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('polystyrene_suspension') * 2000)
    .outputs(metaitem('dustPolystyrene'))
    .fluidOutputs(fluid('water') * 1000)
    .duration(260)
    .EUt(VA[LV])
    .buildAndRegister()

// Polystyrene Sulfonate
BR.recipeBuilder()
    .fluidInputs(fluid('polystyrene') * 2304)
    .fluidInputs(fluid('sulfur_trioxide') * 1000)
    .fluidOutputs(fluid('polystyrene_sulfonate') * 2304)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()
