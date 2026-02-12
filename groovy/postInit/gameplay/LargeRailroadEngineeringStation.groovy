import gregtech.api.multiblock.MultiblockControllerBase

supersymmetry.gregtech.multiblock.create("large_railroad_engineeringStation")
    .withPattern([...]) // Define block structure
    .withRecipeMap(...) // What recipes it uses
    .withEUt(512) // Energy usage
    .register()