import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Grignard reagents

BR.recipeBuilder()
    .inputs(ore('dustAnyPurityMagnesium'))
    .fluidInputs(fluid('chloromethane') * 2000)
    .fluidInputs(fluid('tetrahydrofuran') * 3000)
    .fluidOutputs(fluid('methylmagnesium_chloride_solution') * 1000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

// Gilman reagents

BR.recipeBuilder()
    .fluidInputs(fluid('bromooctane') * 2000)
    .inputs(ore('dustLithium'))
    .inputs(ore('dustCopper'))
    .fluidOutputs(fluid('lithium_dioctylcopper') * 1000)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

// Organolithium reagents

    // Lithium diisopropylamide (LDA), sterically hindered base

    BR.recipeBuilder()
        .inputs(ore('dustLithium'))
        .fluidInputs(fluid('diisopropylamine') * 1000)
        .fluidInputs(fluid('tetrahydrofuran') * 3000)
        .fluidOutputs(fluid('lithium_diisopropylamide_solution') * 1000)
        .duration(160)
        .EUt(VA[MV])
