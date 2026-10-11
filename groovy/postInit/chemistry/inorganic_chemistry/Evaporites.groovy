import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

SIFTER.recipeBuilder()
    .inputs(ore('dustNonMarineEvaporite') * 3)
    .chancedOutput(metaitem('dustSalt'), 8000, 0)
    .chancedOutput(metaitem('dustTrona'), 6000, 0)
    .chancedOutput(metaitem('dustEpsomite'), 6000, 0)
    .chancedOutput(metaitem('dustBorax'), 6000, 0)
    .chancedOutput(metaitem('dustKernite'), 2000, 0)
    .chancedOutput(metaitem('dustColemanite'), 2000, 0)
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister();

SIFTER.recipeBuilder()
    .inputs(ore('dustSulfateEvaporite') * 2)
    .chancedOutput(metaitem('dustSalt'), 8000, 0)
    .chancedOutput(metaitem('dustGypsum'), 8000, 0)
    .chancedOutput(metaitem('dustLangbeinite'), 2000, 0)
    .chancedOutput(metaitem('dustPolyhalite'), 1000, 0)
    .chancedOutput(metaitem('dustKieserite'), 1000, 0)
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister();

SIFTER.recipeBuilder()
    .inputs(ore('dustCarbonateEvaporite') * 2)
    .chancedOutput(metaitem('dustSalt'), 5000, 0)
    .chancedOutput(metaitem('dustDolomite'), 5000, 0)
    .chancedOutput(metaitem('dustCalcite'), 5000, 0)
    .chancedOutput(metaitem('dustMagnesite'), 5000, 0)
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister();

SIFTER.recipeBuilder()
    .inputs(ore('dustHalideEvaporite') * 2)
    .outputs(metaitem('dustSalt'))
    .chancedOutput(metaitem('dustSalt'), 8000, 500)
    .chancedOutput(metaitem('dustCarnallite'), 7000, 250)
    .chancedOutput(metaitem('dustKainite'), 5000, 250)
    .duration(60)
    .EUt(VA[LV])
    .buildAndRegister();