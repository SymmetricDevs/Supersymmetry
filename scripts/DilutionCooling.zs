import mods.gregtech.recipe.RecipeMap;



mixer.recipeBuilder()
.fluidInputs([<liquid:helium> * 1000, <liquid:helium_3> * 1000])
.fluidOutputs(<liquid:enriched_helium> * 2000)
.duration(1200)
.EUt(64)
.buildAndRegister();

vacuum_freezer.recipeBuilder()
.fluidInputs([<liquid:helium> * 100])
.fluidOutputs(<liquid:liquid_helium> * 100)
.duration(200)
.EUt(6400)
.buildAndRegister();

vacuum_freezer.recipeBuilder()
.fluidInputs([<liquid:nitrogen> * 100])
.fluidOutputs(<liquid:liquid_nitrogen> * 100)
.duration(200)
.EUt(6400)
.buildAndRegister();

cryogenic_reactor.recipeBuilder()
.property("temperature", 80)
.fluidInputs([<liquid:helium_3> * 1000, <liquid:liquid_nitrogen> * 1000])
.fluidOutputs([<liquid:condensed_helium> * 1000, <liquid:nitrogen> * 1000])
.duration(100)
.EUt(480)
.buildAndRegister();

cryogenic_reactor.recipeBuilder()
.property("temperature", 4)
.fluidInputs([<liquid:condensed_helium> * 1000, <liquid:liquid_helium> * 1000])
.fluidOutputs([<liquid:liquid_heliumb> * 1000, <liquid:helium> * 1000])
.duration(100)
.EUt(480)
.buildAndRegister();

cryogenic_reactor.recipeBuilder()
.property("temperature", 4)
.fluidInputs([<liquid:liquid_heliumb> * 1000, <liquid:enriched_helium> * 1000])
.fluidOutputs([<liquid:superfluid_helium> * 500, <liquid:helium_3> * 1500])
.duration(100)
.EUt(480)
.buildAndRegister();