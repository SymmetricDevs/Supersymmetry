#norun
import mods.gregtech.recipe.RecipeMap;

//-------------------------REMOVE OLD RECIPES----------------

mods.qmd.ore_leacher.removeAllRecipes();

//--------------------------RECIPE ADDITION--------------------


//-----------------------CALCIUM 48 PRODUCTION (gt-ideas issue 10)------------------

large_chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:ethanol> * 2000, <liquid:sulfuric_acid> * 1000, <liquid:chlorine> * 4000])
.fluidOutputs([<liquid:diluted_hydrochloric_acid> * 2000, <liquid:diluted_sulfuric_acid> * 1000, <liquid:bischloroethyl> * 1000])
.duration(100)
.EUt(60)
.buildAndRegister();

large_chemical_reactor.recipeBuilder()
.inputs([<metaitem:dustSodiumHydroxide> * 12, <metaitem:dustPyrocatechol> * 24])
.fluidInputs([<liquid:bischloroethyl> * 2000])
.fluidOutputs([<liquid:dibenzocrown> * 1000, <liquid:salt_water> * 4000])
.duration(100)
.EUt(60)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.inputs([<metaitem:dustSiliconDioxide> * 4])
.fluidInputs([<liquid:dibenzocrown> * 1000, <liquid:bisphenol_a> * 1000, <liquid:formaldehyde> * 1000])
.outputs([<metaitem:dustCalciumSieve>])
.duration(100)
.EUt(60)
.buildAndRegister();

large_chemical_reactor.recipeBuilder()
.inputs([<metaitem:dustCalciumSieve>, <gregtech:meta_dust:16> * 64, <gregtech:meta_dust:16> * 64])
.fluidInputs([<liquid:hydrochloric_acid> * 4000])
.outputs(<metaitem:dustSmallCalcium48>)
.duration(4000)
.EUt(60)
.buildAndRegister();