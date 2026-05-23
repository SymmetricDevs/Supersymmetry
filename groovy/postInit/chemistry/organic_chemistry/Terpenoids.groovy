
import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// From tree resins

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('gum_turpentine') * 1000)
    .fluidOutputs(fluid('alpha_pinene') * 700)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

// From citrus peels

DISTILLERY.builder()
    .fluidInputs(fluid('dense_steam') * 1000)
    .inputs(ore('zest') * 20)
    .fluidOutputs(fluid('limonene') * 1000)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

// From paper pulping

// FIXME: add sulfate turpentine

// α-terpinene

    // From limonene isomerization

    CSTR.recipeBuilder()
        .notConsumable(fluid('diluted_sulfuric_acid') * 100)
        .fluidInputs(fluid('limonene') * 50)
        .fluidOutputs(fluid('terpinene_mixture') * 50)
        .duration(8)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('terpinene_mixture') * 100)
        .fluidOutputs(fluid('alpha_terpinene') * 70)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

    // From α-pinene isomerization

    FBR.recipeBuilder()
        .notConsumable(ore('catalystBedManganeseDioxide'))
        .fluidInputs(fluid('alpha_pinene') * 50)
        .fluidOutputs(fluid('terpinene_mixture') * 50)
        .duration(10)
        .EUt(VA[MV])
        .buildAndRegister()