import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

// Aluminium etchant

MIXER.recipeBuilder()
    .fluidInputs(fluid('nitric_acid') * 20)
    .fluidInputs(fluid('phosphoric_acid') * 250)
    .fluidInputs(fluid('acetic_acid') * 50)
    .fluidInputs(fluid('ultrapure_water') * 680)
    .fluidOutputs(fluid('aluminium_etchant') * 1000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Ultrapure HF (fast silicate glass etching)

BCR.recipeBuilder()
    .fluidInputs(fluid('hydrofluoric_acid') * 1000)
    .fluidInputs(fluid('ultrapure_water') * 1000)
    .fluidOutputs(fluid('ultrapure_hydrofluoric_acid') * 1000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Buffered oxide etchant (BOE, slow etching of silicon dioxide)

MIXER.recipeBuilder()
    .inputs(ore('dustAmmoniumFluoride') * 6)
    .fluidInputs(fluid('ultrapure_hydrofluoric_acid') * 70)
    .fluidInputs(fluid('ultrapure_water') * 930)
    .fluidOutputs(fluid('buffered_oxide_etchant') * 1000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Ultrapure FeCl3 (copper and nickel etchant)

MIXER.recipeBuilder()
    .inputs(ore('dustIronIiiChloride') * 4)
    .fluidInputs(fluid('ultrapure_water') * 1000)
    .fluidOutputs(fluid('ultrapure_iron_iii_chloride_solution') * 1000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

/* Ultrapure H2O2 (titanium and tungsten etchant)

BCR.recipeBuilder()
    .fluidInputs(fluid('hydrogen_peroxide_solution') * 1000)
    .fluidInputs(fluid('ultrapure_water') * 1000)
    .fluidOutputs(fluid('ultrapure_hydrogen_peroxide_solution') * 2000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()
*/