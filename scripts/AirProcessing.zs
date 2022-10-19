import mods.gregtech.recipe.RecipeMap;

//-------------------REMOVE OLD RECIPES----------------

// Nitrogen * 35000
<recipemap:distillation_tower>.findRecipe(480, null, [<liquid:liquid_air> * 50000]).remove();

// Liquid Air * 4000
<recipemap:vacuum_freezer>.findRecipe(480, null, [<liquid:air> * 4000]).remove();

//---------------------ADD NEW RECIPES--------------------

large_chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:air> * 4000])
.inputs([<metaitem:dustMediumMolecularSieve>])
.fluidOutputs([<liquid:filtered_air> * 4000])
.outputs([<metaitem:dustMediumMolecularSieveWet>])
.duration(800)
.EUt(64)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:liquid_air> * 50000])
.fluidOutputs([
    <liquid:nitrogen> * 39000,
    <liquid:oxygen> * 10500,
    <liquid:argon> * 500
    ])
.duration(2000)
.EUt(480)
.buildAndRegister();

vacuum_freezer.recipeBuilder()
.fluidInputs([<liquid:filtered_air> * 4000])
.fluidOutputs([<liquid:liquid_air> * 4000])
.duration(800)
.EUt(480)
.buildAndRegister();
