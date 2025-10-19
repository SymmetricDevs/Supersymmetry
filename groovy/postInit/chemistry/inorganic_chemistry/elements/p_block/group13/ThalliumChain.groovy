import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

BR.recipeBuilder()
    .inputs(ore('dustThalliumIChloride') * 4)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
    .fluidOutputs(fluid('acidic_thallium_sulfate_solution') * 1000) // 1 Tl2SO4, 1 H2O, 2 HCl 
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('acidic_thallium_sulfate_solution') * 1000)
    .fluidOutputs(fluid('thallium_sulfate_solution') * 1000)
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(ore('stickPlatinum'))
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('thallium_sulfate_solution') * 1000)
    .outputs(metaitem('dustThallium') * 2)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .EUt(VA[LV])
    .duration(120)
    .buildAndRegister()
