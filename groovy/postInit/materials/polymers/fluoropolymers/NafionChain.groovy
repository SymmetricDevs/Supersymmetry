import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ROASTER.recipeBuilder()
    .fluidInputs(fluid('hexafluoropropylene') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidOutputs(fluid('hexafluoropropylene_oxide') * 50)
    .duration(5)
    .EUt(VA[MV])
    .buildAndRegister();

CSTR.recipeBuilder()
    .notConsumable(ore('dustSodiumFluoride') * 2)
    .fluidInputs(fluid('tetrafluoroethylene') * 50)
    .fluidInputs(fluid('sulfur_trioxide') * 50)
    .fluidOutputs(fluid('fluorosulfonyl_difluoroacetyl_fluoride') * 50)
    .duration(5)
    .EUt(VA[HV])
    .buildAndRegister();

LCR.recipeBuilder()
    .inputs(ore('dustSodaAsh') * 6)
    .fluidInputs(fluid('dimethylformamide') * 2000)
    .fluidInputs(fluid('hexafluoropropylene_oxide') * 2000)
    .fluidInputs(fluid('fluorosulfonyl_difluoroacetyl_fluoride') * 1000)
    .fluidOutputs(fluid('perfluorovinyl_sulfonyl_ether_solution') * 3000)
    .fluidOutputs(fluid('carbon_dioxide') * 2000)
    .duration(100)
    .EUt(VA[EV])
    .buildAndRegister();

DT.recipeBuilder()
    .fluidInputs(fluid('perfluorovinyl_sulfonyl_ether_solution') * 3000)
    .fluidOutputs(fluid('perfluorovinyl_sulfonyl_ether') * 1000)
    .fluidOutputs(fluid('dimethylformamide') * 2000)
    .outputs(metaitem('dustSodiumFluoride') * 4)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister();

POLYMERIZATION_TANK.recipeBuilder()
    .fluidInputs(fluid('fluorinated_surfactant_mixture') * 500)
    .fluidInputs(fluid('perfluorovinyl_sulfonyl_ether') * 1000)
    .fluidInputs(fluid('tetrafluoroethylene') * 1000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('nafion_solution') * 500)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('nafion_solution') * 500)
    .outputs(metaitem('dustRawNafion'))
    .fluidOutputs(fluid('fluorinated_surfactant_mixture') * 500)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustRawNafion'))
    .fluidInputs(fluid('distilled_water') * 2000)
    .outputs(metaitem('dustNafion'))
    .fluidOutputs(fluid('hydrofluoric_acid') * 1000)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()
