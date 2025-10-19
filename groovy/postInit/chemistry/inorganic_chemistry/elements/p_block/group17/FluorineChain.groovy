import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import static gregtech.api.unification.material.Materials.*
import gregtech.api.unification.material.MarkerMaterials
import static gregtech.api.unification.ore.OrePrefix.dye

//POTASSIUM FLUORIDE PRODUCTION
ROASTER.recipeBuilder()
        .inputs(ore('dustPotassiumCarbonate') * 6)
        .fluidInputs(fluid('hydrofluoric_acid') * 2000)
        .fluidOutputs(fluid('potassium_fluoride_solution') * 2000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .fluidOutputs(fluid('dense_steam') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_fluoride_solution') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .outputs(metaitem('dustPotassiumFluoride') * 2)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

//HYDROFLUORIC ACID ELECTROLYSIS
ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('stickNickel'))
        .notConsumable(metaitem('stickPlatinum'))
        .notConsumable(fluid('potassium_fluoride') * 1152)
        .fluidInputs(fluid('hydrogen_fluoride') * 2000)
        .fluidOutputs(fluid('fluorine') * 1000)
        .fluidOutputs(fluid('hydrogen') * 1000)
        .EUt(VA[MV])
        .duration(720)
        .buildAndRegister()

