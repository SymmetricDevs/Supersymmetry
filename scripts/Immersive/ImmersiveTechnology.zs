import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

val name_removals as string[] = [
	"immersivetech:connectors/connectors_timer",
	"immersivetech:valves/fluid_valve",
	"immersivetech:valves/load_controller",
	"immersivetech:valves/stack_limiter",
	"immersivetech:stone_decoration/reinforced_cokebrick"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("it_redstone_timer", <immersivetech:connectors>, [
	[<ore:paneGlass>, <immersiveengineering:connector:12>, <ore:paneGlass>],
	[<ore:circuitPrimitive>, <ore:circuitPrimitive>, <ore:circuitPrimitive>],
	[<ore:paneGlass>, <ore:wireFineRedAlloy>, <ore:paneGlass>]
]);

recipes.addShaped("it_redstone_timer_1", <immersivetech:connectors>*3, [
	[<ore:paneGlass>, <immersiveengineering:connector:12>, <ore:paneGlass>],
	[<ore:circuitBasic>, <ore:circuitBasic>, <ore:circuitBasic>],
	[<ore:paneGlass>, <ore:wireFineRedAlloy>, <ore:paneGlass>]
]);

recipes.addShaped("it_fluid_valve", <immersivetech:valve:0>*2, [
	[<ore:plateIron>, <immersiveengineering:connector:12>, <ore:plateIron>],
	[<immersiveengineering:metal_device1:6>, <immersiveengineering:material:8>, <immersiveengineering:metal_device1:6>],
	[<ore:plateIron>, <ore:circuitPrimitive>, <ore:plateIron>]
]);

recipes.addShaped("it_fluid_valve_1", <immersivetech:valve:0>*6, [
	[<ore:plateIron>, <immersiveengineering:connector:12>, <ore:plateIron>],
	[<immersiveengineering:metal_device1:6>, <immersiveengineering:material:8>, <immersiveengineering:metal_device1:6>],
	[<ore:plateIron>, <ore:circuitBasic>, <ore:plateIron>]
]);

recipes.addShaped("it_load_controller", <immersivetech:valve:1>*2, [
	[<ore:plateIron>, <immersiveengineering:connector:12>, <ore:plateIron>],
	[<immersiveengineering:connector:4>, <immersiveengineering:material:8>, <immersiveengineering:connector:4>],
	[<ore:plateIron>, <ore:circuitPrimitive>, <ore:plateIron>]
]);

recipes.addShaped("it_load_controller_1", <immersivetech:valve:1>*6, [
	[<ore:plateIron>, <immersiveengineering:connector:12>, <ore:plateIron>],
	[<immersiveengineering:connector:4>, <immersiveengineering:material:8>, <immersiveengineering:connector:4>],
	[<ore:plateIron>, <ore:circuitBasic>, <ore:plateIron>]
]);

recipes.addShaped("it_stack_limiter", <immersivetech:valve:2>*2, [
	[<ore:plateIron>, <immersiveengineering:connector:12>, <ore:plateIron>],
	[<immersiveengineering:conveyor>, <immersiveengineering:material:8>, <immersiveengineering:conveyor>],
	[<ore:plateIron>, <ore:circuitPrimitive>, <ore:plateIron>]
]);

recipes.addShaped("it_stack_limiter_1", <immersivetech:valve:2>*6, [
	[<ore:plateIron>, <immersiveengineering:connector:12>, <ore:plateIron>],
	[<immersiveengineering:conveyor>, <immersiveengineering:material:8>, <immersiveengineering:conveyor>],
	[<ore:plateIron>, <ore:circuitBasic>, <ore:plateIron>]
]);