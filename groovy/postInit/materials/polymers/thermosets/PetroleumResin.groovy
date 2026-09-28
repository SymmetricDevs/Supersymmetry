import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

POLYMERIZATION_TANK.recipeBuilder()
        .fluidInputs(fluid('benzene') * 10000)
        .fluidInputs(fluid('dicyclopentadiene') * 9000)
        .inputs(metaitem('dustNorbornene') * 17)
        .inputs(metaitem('dustTinyAluminiumChloride') * 1)
        .fluidOutputs(fluid('petroleum_resin_solution') * 10000)
        .duration(360)
        .EUt(VA[HV])
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('petroleum_resin_solution') * 1000)
        .fluidOutputs(fluid('benzene') * 1000)
        .outputs(metaitem('dustPetroleumResin') * 1)
        .duration(28)
        .EUt(VA[LV])
        .buildAndRegister()

FIXED_BR.recipeBuilder()
        .inputs(metaitem('dustPetroleumResin') * 1)
        .fluidInputs(fluid('hydrogen') * 1000)
        .notConsumable(metaitem('catalystBedSupportedNickel'))
        .outputs(metaitem('dustHydrogenatedPetroleumResin') * 1)
        .duration(30)
        .EUt(VA[MV])
        .buildAndRegister()
