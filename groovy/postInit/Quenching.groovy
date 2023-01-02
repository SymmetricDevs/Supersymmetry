import gregtech.loaders.recipe.handlers.OreRecipeHandler;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.material.Material;
import classes.*;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.material.properties.IngotProperty;
import gregtech.api.unification.ore.OrePrefix;


//IQuenchingFluid(cold fluid, hot fluid, amount, duration, isInert, generateHeatRadiatorRecipes)

IQuenchingFluid Water = new IQuenchingFluid("water", 'warm_water', 1000, 100.0, false, true);
IQuenchingFluid Air = new IQuenchingFluid('air', 'hot_air', 10000, 1000.0, false, false);
IQuenchingFluid CompressedAir = new IQuenchingFluid('hp_air', 'hot_hp_air', 5000, 500.0, false, true);
IQuenchingFluid Nitrogen = new IQuenchingFluid('nitrogen', 'hot_nitrogen', 10000, 500.0, true, false);
IQuenchingFluid CompressedNitrogen = new IQuenchingFluid('hp_nitrogen', 'hot_hp_nitrogen', 5000, 500.0, true, true);
//IQuenchingFluid Brine = new IQuenchingFluid('brine', 'warm_brine', 1000, 20.0, false, false);


//TODO: Find a way to somehow autogenerate quenching recipes for all hot ingots

/*
public void quenchHotIngots(OrePrefix ingot_hot, Material material, IngotProperty property) {
    println(material.toString())
    for (fluid in IQuenchingFluid.quenching_fluids) {
        println(fluid.getColdFluid())
        recipemap('quencher').recipeBuilder()
                .inputs(metaitem("ingotHot" + material.toString()))
                .fluidInputs(liquid(fluid.getColdFluid()) * fluid.amount)
                .outputs(metaitem("ingot" + material.toString()))
                .fluidOutputs(liquid(fluid.getHotFluid()) * fluid.amount)
                .duration((int) fluid.getDuration())
                .EUt(120)
                .buildAndRegister();
    }
}

OrePrefix.ingotHot.addProcessingHandler(PropertyKey.INGOT, Quenching::quenchHotIngots)
*/

for (fluid in IQuenchingFluid.quenching_fluids) {
    if (!fluid.hasRecipe()){
        recipemap('radiator').recipeBuilder()
                .fluidInputs(liquid(fluid.getHotFluid())*fluid.amount)
                .fluidOutputs(liquid(fluid.getColdFluid())*fluid.amount)
                .duration(400)
                .EUt(8)
                .buildAndRegister();
    }
}


