import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;

// conversion recipes from greg ports
recipes.addShapeless("lv input bus -> mbd input bus", <multiblocked:item_input>, [<gregtech:machine:1151>]);
recipes.addShapeless("lv output bus -> mbd output bus", <multiblocked:item_output>, [<gregtech:machine:1166>]);
recipes.addShapeless("lv input hatch -> mbd input hatch", <multiblocked:fluid_input>, [<gregtech:machine:1181>]);
recipes.addShapeless("lv output hatch -> mbd output hatch", <multiblocked:fluid_output>, [<gregtech:machine:1196>]);

// conversion recipes to greg ports
recipes.addShapeless("mbd input bus -> lv input bus", <gregtech:machine:1151>, [<multiblocked:item_input>]);
recipes.addShapeless("mbd output bus -> lv output bus", <gregtech:machine:1166>, [<multiblocked:item_output>]);
recipes.addShapeless("mbd input hatch -> lv input hatch", <gregtech:machine:1181>, [<multiblocked:fluid_input>]);
recipes.addShapeless("mbd output hatch -> lv output hatch", <gregtech:machine:1196>, [<multiblocked:fluid_output>]);
