#norun
import mods.gregtech.recipe.RecipeMap;



//-------------------REMOVE OLD RECIPES----------------
// Brine * 1000
<recipemap:dryer_recipes>.findRecipe(480, null, [<liquid:salt_water> * 8000]).remove();

// Salt * 8
<recipemap:chemical_reactor>.findRecipe(480, [<metaitem:dustSodium>], [<liquid:chlorinated_brine> * 1000]).remove();


//---------------------ADD NEW RECIPES--------------------

heat_exchanger_recipes.recipeBuilder()
.fluidInputs([<liquid:sea_water> * 1000, <liquid:steam> * 1000])
.fluidOutputs([<liquid:brine> * 100, <liquid:water> * 1000])
.duration(40)
.EUt(8)
.buildAndRegister();