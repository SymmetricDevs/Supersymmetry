import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import mods.gregtech.recipe.RecipeMapBuilder;
import mods.gregtech.recipe.RecipeMap;
import mods.gregtech.recipe.RecipeMaps;

val name_removals as string[] = [
	"openmodularturrets:disposable_item_turret_vanilla",
	"openmodularturrets:potato_cannon_turret_vanilla",
	"openmodularturrets:turret_base_0_vanilla",
	"openmodularturrets:ammo_meta_0_vanilla",
	"openmodularturrets:intermediate_regular_0_vanilla",
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

for solder in soldering_alloys {

	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateSteel>*4,
			hulls[1],
			circuits[1],
			<openmodularturrets:intermediate_regular:0>*2
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:turret_base:1>)
		.duration(200)
		.EUt(32)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateAluminium>*4,
			hulls[2],
			circuits[2],
			<openmodularturrets:intermediate_regular:0>*2
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:turret_base:2>)
		.duration(200)
		.EUt(128)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateStainlessSteel>*4,
			hulls[3],
			circuits[3],
			<openmodularturrets:intermediate_regular:0>*2
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:turret_base:3>)
		.duration(200)
		.EUt(512)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateTritanium>*4,
			hulls[8],
			circuits[8],
			<openmodularturrets:intermediate_regular:0>*2
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:turret_base:4>)
		.duration(200)
		.EUt(500000)
		.buildAndRegister();
	
	weapons_factory.recipeBuilder()
		.inputs([
			<openmodularturrets:intermediate_tiered:6>,
			<openmodularturrets:intermediate_tiered:11>,
			<openmodularturrets:intermediate_regular:0>,
			circuits[1],
			motors[1]*2,
			<techguns:pistol>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:machine_gun_turret>)
		.duration(200)
		.EUt(20)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<openmodularturrets:intermediate_tiered:6>,
			<openmodularturrets:intermediate_tiered:11>,
			<openmodularturrets:intermediate_regular:0>,
			circuits[1],
			motors[1]*2,
			pumps[1]
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:incendiary_turret>)
		.duration(200)
		.EUt(20)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<openmodularturrets:intermediate_tiered:7>,
			<openmodularturrets:intermediate_tiered:12>,
			<openmodularturrets:intermediate_regular:0>,
			<ore:plateAluminium>*4,
			circuits[2],
			motors[2]*2
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:grenade_turret>)
		.duration(200)
		.EUt(60)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<openmodularturrets:intermediate_tiered:8>,
			<openmodularturrets:intermediate_tiered:13>,
			<openmodularturrets:intermediate_regular:0>,
			<ore:plateStainlessSteel>*4,
			circuits[3],
			motors[3]*2
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:rocket_turret>)
		.duration(200)
		.EUt(300)
		.buildAndRegister();
	
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateSteel>,
			<ore:dustGunpowder>,
			<ore:roundLead>
		])
		.fluidInputs(solder*36)
		.outputs(<openmodularturrets:ammo_meta:1>*8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:roundAluminium>*4,
			<ore:plateSteel>,
			<ore:dustGunpowder>
		])
		.fluidInputs(solder*36)
		.outputs(<openmodularturrets:ammo_meta:3>)
		.duration(10)
		.EUt(60)
		.buildAndRegister();
	
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:wireFineRedAlloy>,
			conveyors[1],
			<ore:plateGold>,
			<ore:plateIron>
		])
		.fluidInputs(solder*36)
		.outputs(<openmodularturrets:intermediate_regular:0>)
		.duration(200)
		.EUt(20)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateDenseSteel>,
			<ore:wireFineRedAlloy>,
			<ore:plateSteel>,
			<ore:springSteel>,
			<ore:gearSteel>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:intermediate_tiered:6>)
		.duration(200)
		.EUt(20)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateAluminium>*9,
			<ore:wireFineRedAlloy>,
			<ore:plateAluminium>,
			<ore:springSteel>,
			<ore:gearAluminium>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:intermediate_tiered:7>)
		.duration(200)
		.EUt(60)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateStainlessSteel>*9,
			<ore:wireFineRedAlloy>,
			<ore:plateStainlessSteel>,
			<ore:springSteel>,
			<ore:gearStainlessSteel>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:intermediate_tiered:8>)
		.duration(200)
		.EUt(300)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateSteel>*6,
			<techguns:itemshared:39>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:intermediate_tiered:11>)
		.duration(200)
		.EUt(20)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateAluminium>*6,
			<techguns:itemshared:39>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:intermediate_tiered:12>)
		.duration(200)
		.EUt(60)
		.buildAndRegister();
		
	weapons_factory.recipeBuilder()
		.inputs([
			<ore:plateStainlessSteel>*6,
			<techguns:itemshared:39>
		])
		.fluidInputs(solder)
		.outputs(<openmodularturrets:intermediate_tiered:13>)
		.duration(200)
		.EUt(300)
		.buildAndRegister();
}

mixer.recipeBuilder()
		.inputs([
			<ore:dustClay>
		])
		.fluidInputs(<liquid:gasoline>*1000)
		.outputs(<openmodularturrets:ammo_meta:0>*32)
		.duration(20)
		.EUt(30)
		.buildAndRegister();