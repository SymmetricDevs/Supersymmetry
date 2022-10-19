import mods.gregtech.recipe.RecipeMap;



//-------------------REMOVE OLD RECIPES----------------
// Brine * 1000
<recipemap:dryer_recipes>.findRecipe(480, null, [<liquid:salt_water> * 8000]).remove();

// Salt * 8
<recipemap:chemical_reactor>.findRecipe(480, [<metaitem:dustSodium>], [<liquid:chlorinated_brine> * 1000]).remove();


//---------------------ADD NEW RECIPES--------------------

dryer.recipeBuilder()
.fluidInputs([<liquid:sea_water> * 8000])
.fluidOutputs([<liquid:brine> * 1000])
.duration(640)
.EUt(480)
.buildAndRegister();

//----------------------BROMINE CHANGES--------------------
mixer.recipeBuilder()
.fluidInputs([
    <liquid:chlorinated_brine> * 2000,
    <liquid:steam> * 1000
    ])
.fluidOutputs([<liquid:hot_brine> * 2000])
.duration(160)
.EUt(480)
.buildAndRegister();

distillery.recipeBuilder()
.notConsumable([<gregtech:meta_item_1:461>.withTag({Configuration: 0})])
.fluidInputs([<liquid:hot_brine> * 2000])
.fluidOutputs([<liquid:bromine> * 200])
.duration(160)
.EUt(480)
.buildAndRegister();

//--------------------IODINE CHAIN--------------------------

mixer.recipeBuilder()
.fluidInputs([
    <liquid:brine> * 1000,
    <liquid:sulfuric_acid> * 250
    ])
.fluidOutputs([<liquid:acidic_brine> * 1000])
.duration(160)
.EUt(320)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:acidic_brine> * 1000,
    <liquid:chlorine> * 1000
    ])
.fluidOutputs([<liquid:iodine_solution> * 1000])
.duration(160)
.EUt(320)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:iodine_solution> * 1000,
    <liquid:air> * 2000
    ])
.fluidOutputs([
    <liquid:diluted_sulfuric_acid> * 500,
    <liquid:evaporated_iodine> * 100
    ])
.duration(300)
.EUt(160)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:evaporated_iodine> * 1000,
    <liquid:sulfur_dioxide> * 500
    ])
.fluidOutputs([<liquid:hydrogen_iodide> * 1000])
.duration(160)
.EUt(320)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:hydrogen_iodide> * 2000,
    <liquid:chlorine> * 2000
    ])
.fluidOutputs([<liquid:hydrochloric_acid> * 2000])
.outputs([<metaitem:dustIodine> * 2])
.duration(160)
.EUt(320)
.buildAndRegister();