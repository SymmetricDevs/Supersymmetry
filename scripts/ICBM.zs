import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.oredict.IOreDictEntry;

import scripts.thermodynamics.ICryoGas.ICryoGas;
import scripts.thermodynamics.ISuperconductor.ISuperconductor;
import scripts.thermodynamics.thermo;

val name_removals as string[] = [
	"icbmclassic:missile/vanilla/missile.module",
	"icbmclassic:launcher/base/base.tier.1",
	"icbmclassic:launcher/base/base.tier.2",
	"icbmclassic:launcher/base/base.tier.3",
	"icbmclassic:launcher/support/support.tier.1",
	"icbmclassic:launcher/support/support.tier.2",
	"icbmclassic:launcher/support/support.tier.3",
	"icbmclassic:launcher/screen/screen.tier.1",
	"icbmclassic:launcher/screen/screen.tier.2",
	"icbmclassic:launcher/screen/screen.tier.3",
	"icbmclassic:missile/ex/missile.anvil",
	"icbmclassic:missile/ex/missile.repulsive",
	"icbmclassic:missile/ex/missile.attractive",
	"icbmclassic:missile/ex/missile.sonic",
	"icbmclassic:missile/ex/missile.antimatter",
	"icbmclassic:missile/ex/missile.incendiary",
	"icbmclassic:missile/ex/missile.redmatter",
	"icbmclassic:missile/ex/missile.fragmentation",
	"icbmclassic:missile/ex/missile.breaching",
	"icbmclassic:missile/ex/missile.thermobaric",
	"icbmclassic:missile/ex/missile.exothermic",
	"icbmclassic:missile/ex/missile.shrapnel",
	"icbmclassic:missile/ex/missile.ender",
	"icbmclassic:missile/ex/missile.emp",
	"icbmclassic:missile/ex/missile.endothermic",
	"icbmclassic:missile/ex/missile.contagious",
	"icbmclassic:missile/ex/missile.debilitation",
	"icbmclassic:missile/ex/missile.nuclear",
	"icbmclassic:missile/ex/missile.conventional",
	"icbmclassic:missile/ex/missile.anti_grav",
	"icbmclassic:missile/ex/missile.chemical",
	"icbmclassic:missile/ex/missile.hypersonic",
	"icbmclassic:tools/defuser",
	"icbmclassic:tools/radargun",
	"icbmclassic:tools/tracker",
	"icbmclassic:tools/remote",
	"icbmclassic:tools/laser",
	"icbmclassic:machine/cruiselauncher",
	"icbmclassic:explosives/condensed",
	"icbmclassic:explosives/shrapnel",
	"icbmclassic:explosives/incendiary",
	"icbmclassic:explosives/debilitation",
	"icbmclassic:explosives/chemical",
	"icbmclassic:explosives/contagious",
	"icbmclassic:explosives/sonic",
	"icbmclassic:explosives/breaching",
	"icbmclassic:explosives/thermobaric",
	"icbmclassic:explosives/exothermic",
	"icbmclassic:explosives/endothermic",
	"icbmclassic:explosives/anti_grav",
	"icbmclassic:explosives/ender",
	"icbmclassic:explosives/hypersonic"
];

for item in name_removals {
	recipes.removeByRecipeName(item);
}

recipes.addShaped("icbm_frame_1", <icbmclassic:launcherframe:0>, [
	[null, <ore:frameGtSteel>, null],
	[null, <ore:frameGtSteel>, null],
	[null, <ore:frameGtSteel>, null]
]);

recipes.addShaped("icbm_frame_2", <icbmclassic:launcherframe:1>, [
	[null, <ore:frameGtAluminium>, null],
	[null, <ore:frameGtAluminium>, null],
	[null, <ore:frameGtAluminium>, null]
]);

recipes.addShaped("icbm_frame_3", <icbmclassic:launcherframe:2>, [
	[null, <ore:frameGtStainlessSteel>, null],
	[null, <ore:frameGtStainlessSteel>, null],
	[null, <ore:frameGtStainlessSteel>, null]
]);

//Explosives tier 1
recipes.addShaped("icbm_exp_1_0", <icbmclassic:explosives:0>, [
	[<metaitem:dynamite>, <metaitem:dynamite>, <metaitem:dynamite>],
	[<metaitem:dynamite>, <ore:wireFineRedAlloy>, <metaitem:dynamite>],
	[<metaitem:dynamite>, <metaitem:dynamite>, <metaitem:dynamite>]
]);

recipes.addShaped("icbm_exp_1_1", <icbmclassic:explosives:1>, [
	[<ore:roundLead>, <ore:roundLead>, <ore:roundLead>],
	[<ore:roundLead>, <icbmclassic:explosives:0>, <ore:roundLead>],
	[<ore:roundLead>, <ore:roundLead>, <ore:roundLead>]
]);

val flammable_liquids as ILiquidStack[] = [
	<liquid:naphtha>*1000,
	<liquid:gasoline>*500
];

for liquid in flammable_liquids{
	weapons_factory.recipeBuilder()
		.inputs([
			<icbmclassic:explosives:0>,
			<metaitem:fluid_cell>
		])
		.fluidInputs(liquid)
		.outputs(<icbmclassic:explosives:2>)
		.duration(20)
		.EUt(16)
		.buildAndRegister();
}

weapons_factory.recipeBuilder()
		.inputs([
			<icbmclassic:explosives:0>,
			<metaitem:fluid_cell>
		])
		.fluidInputs(<liquid:sulfur_dioxide>*1000)
		.outputs(<icbmclassic:explosives:3>)
		.duration(20)
		.EUt(16)
		.buildAndRegister();
		
val poisons as ILiquidStack[] = [
	<liquid:hydrogen_sulfide>*1000,
	<liquid:chlorine>*1000,
	<liquid:fluorine>*1000,
	<liquid:carbon_monoxide>*1000
];

for poison in poisons{
	weapons_factory.recipeBuilder()
		.inputs([
			<icbmclassic:explosives:0>,
			<metaitem:fluid_cell>
		])
		.fluidInputs(poison)
		.outputs(<icbmclassic:explosives:4>)
		.duration(20)
		.EUt(16)
		.buildAndRegister();
}

//Explosives tier 2
for solder in soldering_alloys {
	weapons_factory.recipeBuilder()
			.inputs([
				<icbmclassic:explosives:0>,
				<ore:plateSteel>*8,
				<ore:plateCurvedSteel>*8
			])
			.fluidInputs(solder*72)
			.outputs(<icbmclassic:explosives:11>)
			.duration(400)
			.EUt(60)
			.buildAndRegister();
}

val thermobaric_fuels as ILiquidStack[] = [
	<liquid:ethylene_oxide>*8000
];

for fuel in thermobaric_fuels {
	weapons_factory.recipeBuilder()
		.inputs([
			<metaitem:fluid_cell>*8,
			<icbmclassic:explosives:6>,
			<ore:plateCurvedAluminium>*4
		])
		.fluidInputs(fuel)
		.outputs(<icbmclassic:explosives:13>)
		.duration(400)
		.EUt(60)
		.buildAndRegister();
}

weapons_factory.recipeBuilder()
	.inputs([
		<metaitem:fluid_cell>*8,
		<icbmclassic:explosives:6>,
		<ore:plateCurvedAluminium>*4,
		<minecraft:rotten_flesh>*8
	])
	.fluidInputs(<liquid:biomass>*8000)
	.outputs(<icbmclassic:explosives:9>)
	.duration(400)
	.EUt(60)
	.buildAndRegister();
	
//Explosives tier 3

val HV_SC_CriticalTemp as int = 80;
for solder in soldering_alloys {
	for CryoGas in thermo.CryoGases {
		if(HV_SC_CriticalTemp > CryoGas.getTemperature()){
			//EMP
			weapons_factory.recipeBuilder()
				.inputs([
					<gtadditions:ga_cell_casing>,
					<ore:plateStainlessSteel>*2,
					<ore:wireGtSingleHvSuperconductor>*8,
					<metaitem:fluid_cell>*2
				])
				.fluidInputs([
					solder*72,
					CryoGas.getLiquidGas(2)
				])
				.outputs(<icbmclassic:explosives:16>)
				.duration(200)
				.EUt(300)
				.buildAndRegister();
		}
		//Endothermic
		weapons_factory.recipeBuilder()
			.inputs([
				<metaitem:fluid_cell>*8,
				<icbmclassic:explosives:6>*8,
				<ore:plateCurvedStainlessSteel>*4
			])
			.fluidInputs([
				solder*72,
				CryoGas.getLiquidGas(32)
			])
			.outputs(<icbmclassic:explosives:18>)
			.duration(60)
			.EUt(300)
			.buildAndRegister();
	}
	for fuel in thermobaric_fuels {
		weapons_factory.recipeBuilder()
			.inputs([
				<metaitem:fluid_cell>*8,
				<icbmclassic:explosives:6>*8,
				<ore:plateCurvedStainlessSteel>*4
			])
			.fluidInputs([
				solder*72,
				fuel
			])
			.outputs(<icbmclassic:explosives:17>)
			.duration(60)
			.EUt(300)
			.buildAndRegister();
	}
}

//Launchers
for solder in soldering_alloys {
	assembler.recipeBuilder()
		.inputs([
			<ore:plateSteel>*3,
			<ore:frameGtSteel>*2,
			<ore:stickLongSteel>*2,
			circuits[2]
		])
		.fluidInputs(solder*72)
		.outputs(<icbmclassic:launcherbase:0>)
		.duration(400)
		.EUt(30)
		.buildAndRegister();
		
	assembler.recipeBuilder()
		.inputs([
			<ore:plateSteel>*2,
			<ore:stickSteel>*2,
			<ore:paneGlassColorless>,
			circuits[2]
		])
		.fluidInputs(solder*72)
		.outputs(<icbmclassic:launcherscreen:0>)
		.duration(400)
		.EUt(30)
		.buildAndRegister();
		
	assembler.recipeBuilder()
		.inputs([
			<ore:plateAluminium>*3,
			<ore:frameGtAluminium>*2,
			<ore:stickLongAluminium>*2,
			circuits[3]
		])
		.fluidInputs(solder*72)
		.outputs(<icbmclassic:launcherbase:1>)
		.duration(400)
		.EUt(60)
		.buildAndRegister();
		
	assembler.recipeBuilder()
		.inputs([
			<ore:plateAluminium>*2,
			<ore:stickAluminium>*2,
			<ore:paneGlassColorless>,
			circuits[3]
		])
		.fluidInputs(solder*72)
		.outputs(<icbmclassic:launcherscreen:1>)
		.duration(400)
		.EUt(60)
		.buildAndRegister();
		
	assembler.recipeBuilder()
		.inputs([
			<ore:plateStainlessSteel>*3,
			<ore:frameGtStainlessSteel>*2,
			<ore:stickLongStainlessSteel>*2,
			circuits[4]
		])
		.fluidInputs(solder*72)
		.outputs(<icbmclassic:launcherbase:2>)
		.duration(400)
		.EUt(260)
		.buildAndRegister();
		
	assembler.recipeBuilder()
		.inputs([
			<ore:plateStainlessSteel>*2,
			<ore:stickStainlessSteel>*2,
			<ore:paneGlassColorless>,
			circuits[4]
		])
		.fluidInputs(solder*72)
		.outputs(<icbmclassic:launcherscreen:2>)
		.duration(400)
		.EUt(260)
		.buildAndRegister();
}