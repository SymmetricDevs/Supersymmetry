#norun
import mods.gregtech.recipe.RecipeMap;

//-------------------REMOVE OLD RECIPES----------------

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
.fluidInputs([<liquid:liquid_filtered_air> * 50000])
.fluidOutputs([
    <liquid:liquid_nitrogen> * 39000,
    <liquid:liquid_oxygen> * 10500,
    <liquid:liquid_argon> * 500
    ])
.duration(2000)
.EUt(480)
.buildAndRegister();
