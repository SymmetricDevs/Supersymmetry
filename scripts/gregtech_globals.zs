#priority 1000

//Script based on the gregtech_globals.zs script from the Gregicality Community Pack

import mods.gregtech.recipe.RecipeMap;
import mods.gtadditions.recipe.Utils;
import mods.gtadditions.recipe.LargeRecipeMap;
import mods.gtadditions.recipe.GARecipeMaps;
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;


global alloy_smelter as RecipeMap =                 RecipeMap.getByName("alloy_smelter");
global arc_furnace as RecipeMap =                   RecipeMap.getByName("arc_furnace");
global assembler as RecipeMap =                     RecipeMap.getByName("assembler");
global assembly_line as RecipeMap =                 RecipeMap.getByName("assembly_line");
global autoclave as RecipeMap =                     RecipeMap.getByName("autoclave");
global bio_lab as RecipeMap =                       RecipeMap.getByName("bio_lab");
global bio_reactor as RecipeMap =                   RecipeMap.getByName("bio_reactor");
global blast_alloy as RecipeMap =                   RecipeMap.getByName("blast_alloy");
global blast_furnace as RecipeMap =                 RecipeMap.getByName("blast_furnace");
global brewer as RecipeMap =                        RecipeMap.getByName("brewer");
global canner as RecipeMap =                        RecipeMap.getByName("canner");
global centrifuge as RecipeMap =                    RecipeMap.getByName("centrifuge");
global chemical_bath as RecipeMap =                 RecipeMap.getByName("chemical_bath");
global chemical_dehydrator as RecipeMap =           RecipeMap.getByName("chemical_dehydrator");
global chemical_plant as RecipeMap =                RecipeMap.getByName("chemical_plant");
global chemical_reactor as RecipeMap =              RecipeMap.getByName("chemical_reactor");
global circuit_assembler as RecipeMap =             RecipeMap.getByName("circuit_assembler");
global cluster_mill as RecipeMap =                  RecipeMap.getByName("cluster_mill");
global compressor as RecipeMap =                    RecipeMap.getByName("compressor");
global cracker as RecipeMap =                       RecipeMap.getByName("cracker");
global cutting_saw as RecipeMap =                   RecipeMap.getByName("cutting_saw");
global decay_chamber as RecipeMap =                 RecipeMap.getByName("decay_chamber");
global disassembler as RecipeMap =                  RecipeMap.getByName("disassembler");
global distillery as RecipeMap =                    RecipeMap.getByName("distillery");
global efurnace as RecipeMap =                      RecipeMap.getByName("furnace");
global electrolyzer as RecipeMap =                  RecipeMap.getByName("electrolyzer");
global extractor as RecipeMap =                     RecipeMap.getByName("extractor");
global extruder as  RecipeMap =                     RecipeMap.getByName("extruder");
global fermenter as RecipeMap =                     RecipeMap.getByName("fermenter");
global fluid_canner as RecipeMap =                  RecipeMap.getByName("fluid_canner");
global fluid_extractor as RecipeMap =               RecipeMap.getByName("fluid_extractor");
global fluid_heater as RecipeMap =                  RecipeMap.getByName("fluid_heater");
global fluid_solidifier as RecipeMap =              RecipeMap.getByName("fluid_solidifier");
global forge_hammer as RecipeMap =                  RecipeMap.getByName("forge_hammer");
global forming_press as RecipeMap =                 RecipeMap.getByName("forming_press");
global fusion_reactor as RecipeMap =                RecipeMap.getByName("fusion_reactor");
global gas_centrifuge as RecipeMap =                RecipeMap.getByName("gas_centrifuge");
global green_house as RecipeMap =                   RecipeMap.getByName("green_house");
global implosion_compressor as RecipeMap =          RecipeMap.getByName("implosion_compressor");
global large_centrifuge as RecipeMap =              LargeRecipeMap.of(GARecipeMaps.LARGE_CENTRIFUGE_RECIPES);
global large_chemical_reactor as RecipeMap =        RecipeMap.getByName("large_chemical_reactor");
//global large_forge_hammer as RecipeMap =            LargeRecipeMap.of(GARecipeMaps.LARGE_FORGE_HAMMER_RECIPES);
global large_mixer as RecipeMap =                   RecipeMap.getByName("large_mixer");
global laser_engraver as RecipeMap =                RecipeMap.getByName("laser_engraver");
global lathe as RecipeMap =                         RecipeMap.getByName("lathe");
global macerator as RecipeMap =                     RecipeMap.getByName("macerator");
global metal_bender as RecipeMap =                  RecipeMap.getByName("metal_bender");
global mixer as RecipeMap =                         RecipeMap.getByName("mixer");
global packer as RecipeMap =                        RecipeMap.getByName("packer");
global polarizer as RecipeMap =                     RecipeMap.getByName("polarizer");
global pyro as RecipeMap =                          RecipeMap.getByName("pyro");
global sifter as RecipeMap =                        RecipeMap.getByName("sifter");
global stellar_forge as RecipeMap =                 RecipeMap.getByName("stellar_forge");
global thermal_centrifuge as RecipeMap =            RecipeMap.getByName("thermal_centrifuge");
global unpacker as RecipeMap =                      RecipeMap.getByName("unpacker");
global vacuum_freezer as RecipeMap =                RecipeMap.getByName("vacuum_freezer");
global wiremill as RecipeMap =                      RecipeMap.getByName("wiremill");
global stock_manipulator as RecipeMap =             RecipeMap.getByName("stock_manipulator");
global weapons_factory as RecipeMap =               RecipeMap.getByName("weapons_factory");

// Tiered Components

global voltageTiers as string[] = ["ulv", "lv", "mv", "hv", "ev", "iv", "luv", "zpm", "uv", "uhv", "uev", "uiv", "umv", "uxv"];

global voltageTiersInt as int[] = [8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, 2097152, 8388608, 33554432, 134217728, 536870912, 2147483647];

global circuits as IIngredient[] = [<ore:circuitPrimitive>, <ore:circuitBasic>, <ore:circuitGood>, 
    <ore:circuitAdvanced>, <ore:circuitExtreme>, <ore:circuitElite>, 
    <ore:circuitMaster>, <ore:circuitUltimate>, <ore:circuitSuperconductor>, 
    <ore:circuitInfinite>, <ore:circuitUev>, <ore:circuitUiv>, 
    <ore:circuitUmv>, <ore:circuitUxv>];

global conveyors as IIngredient[] = [null, <metaitem:conveyor.module.lv>, <metaitem:conveyor.module.mv>, <metaitem:conveyor.module.hv>, 
    <metaitem:conveyor.module.ev>, <metaitem:conveyor.module.iv>, <metaitem:conveyor.module.luv>, 
    <metaitem:conveyor.module.zpm>, <metaitem:conveyor.module.uv>, <metaitem:conveyor.module.uhv>,
    <metaitem:conveyor.module.uev>, <metaitem:conveyor.module.uiv>, <metaitem:conveyor.module.umv>,
    <metaitem:conveyor.module.uxv>];

global pumps as IIngredient[] = [null, <metaitem:electric.pump.lv>, <metaitem:electric.pump.mv>, <metaitem:electric.pump.hv>,
    <metaitem:electric.pump.ev>, <metaitem:electric.pump.iv>, <metaitem:electric.pump.luv>, 
    <metaitem:electric.pump.zpm>, <metaitem:electric.pump.uv>, <metaitem:electric.pump.uhv>,
    <metaitem:electric.pump.uev>, <metaitem:electric.pump.uiv>, <metaitem:electric.pump.umv>,
    <metaitem:electric.pump.uxv>];

global field_generators as IIngredient[]= [null, <metaitem:field.generator.lv>, <metaitem:field.generator.mv>, <metaitem:field.generator.hv>, 
    <metaitem:field.generator.ev>, <metaitem:field.generator.iv>, <metaitem:field.generator.luv>, 
    <metaitem:field.generator.zpm>, <metaitem:field.generator.uv>, <metaitem:field.generator.uhv>,
    <metaitem:field.generator.uev>, <metaitem:field.generator.uiv>, <metaitem:field.generator.umv>,
    <metaitem:field.generator.uxv>];

global emitters as IIngredient[] = [null, <metaitem:emitter.lv>, <metaitem:emitter.mv>, <metaitem:emitter.hv>, 
    <metaitem:emitter.ev>, <metaitem:emitter.iv>, <metaitem:emitter.luv>, 
    <metaitem:emitter.zpm>, <metaitem:emitter.uv>, <metaitem:emitter.uhv>,
    <metaitem:emitter.uev>, <metaitem:emitter.uiv>, <metaitem:emitter.umv>,
    <metaitem:emitter.uxv>];
	
global sensors as IIngredient[] = [null, <metaitem:sensor.lv>, <metaitem:sensor.mv>, <metaitem:sensor.hv>, 
    <metaitem:sensor.ev>, <metaitem:sensor.iv>, <metaitem:sensor.luv>, 
    <metaitem:sensor.zpm>, <metaitem:sensor.uv>, <metaitem:sensor.uhv>,
    <metaitem:sensor.uev>, <metaitem:sensor.uiv>, <metaitem:sensor.umv>,
    <metaitem:sensor.uxv>];

global motors as IIngredient[] = [null, <metaitem:electric.motor.lv>, <metaitem:electric.motor.mv>, <metaitem:electric.motor.hv>, 
    <metaitem:electric.motor.ev>, <metaitem:electric.motor.iv>, <metaitem:electric.motor.luv>, 
    <metaitem:electric.motor.zpm>, <metaitem:electric.motor.uv>, <metaitem:electric.motor.uhv>,
    <metaitem:electric.motor.uev>, <metaitem:electric.motor.uiv>, <metaitem:electric.motor.umv>,
    <metaitem:electric.motor.uxv>];

global pistons as IIngredient[] = [null, <metaitem:electric.piston.lv>, <metaitem:electric.piston.mv>, <metaitem:electric.piston.hv>, 
    <metaitem:electric.piston.ev>, <metaitem:electric.piston.iv>, <metaitem:electric.piston.luv>, 
    <metaitem:electric.piston.zpm>, <metaitem:electric.piston.uv>, <metaitem:electric.piston.uhv>,
    <metaitem:electric.piston.uev>, <metaitem:electric.piston.uiv>, <metaitem:electric.piston.umv>,
    <metaitem:electric.piston.uxv>];

global robotArms as IIngredient[] = [null, <metaitem:robot.arm.lv>, <metaitem:robot.arm.mv>, <metaitem:robot.arm.hv>, 
    <metaitem:robot.arm.ev>, <metaitem:robot.arm.iv>, <metaitem:robot.arm.luv>, 
    <metaitem:robot.arm.zpm>, <metaitem:robot.arm.uv>, <metaitem:robot.arm.uhv>,
    <metaitem:robot.arm.uev>, <metaitem:robot.arm.uiv>, <metaitem:robot.arm.umv>,
    <metaitem:robot.arm.uxv>];

global hulls as IIngredient[] = [<meta_tile_entity:hull.ulv>, <meta_tile_entity:hull.lv>, <meta_tile_entity:hull.mv>, <meta_tile_entity:hull.hv>, 
    <meta_tile_entity:hull.ev>, <meta_tile_entity:hull.iv>, <meta_tile_entity:hull.luv>,
    <meta_tile_entity:hull.zpm>, <meta_tile_entity:hull.uv>, <meta_tile_entity:gtadditions:hull.uhv>,
    <meta_tile_entity:gtadditions:hull.uev>, <meta_tile_entity:gtadditions:hull.uiv>, <meta_tile_entity:gtadditions:hull.umv>,
    <meta_tile_entity:gtadditions:hull.uxv>];

global tieredWires as IIngredient[] = [<ore:wireGtSingleRedAlloy>, <ore:wireGtSingleTin>, <ore:wireGtSingleCopper>, <ore:wireGtSingleGold>, 
    <ore:wireGtSingleAluminium>, <ore:wireGtSingleTungsten>, <ore:wireGtSingleVanadiumGallium>, 
    <ore:wireGtSingleNaquadah>, <ore:wireGtSingleNaquadahAlloy>, <ore:wireGtSingleAbyssalAlloy>,
    <ore:wireGtSingleTitanSteel>, <ore:wireGtSingleBlackTitanium>, <ore:wireGtSingleNeutronium>,
    <ore:wireGtSingleNeutronium>];

global tieredPlates as IIngredient[] = [<ore:plateWroughtIron>, <ore:plateSteel>, <ore:plateAluminium>, <ore:plateStainlessSteel>, 
    <ore:plateTitanium>, <ore:plateTungstenSteel>, <ore:plateRhodiumPlatedPalladium>, 
    <ore:plateOsmiridium>, <ore:plateTritanium>, <ore:plateSeaborgium>,
    <ore:plateBohrium>, <ore:plateQuantum>, <ore:plateQuantum>,
    <ore:plateQuantum>];

global tieredLongSticks as IIngredient[] = [<ore:stickLongWroughtIron>, <ore:stickLongSteel>, <ore:stickLongAluminium>, <ore:stickLongStainlessSteel>, 
    <ore:stickLongTitanium>, <ore:stickLongTungstenSteel>, <ore:stickLongRhodiumPlatedPalladium>, 
    <ore:stickLongOsmiridium>, <ore:stickLongTritanium>, <ore:stickLongSeaborgium>,
    <ore:stickLongBohrium>, <ore:stickLongQuantum>, <ore:stickLongQuantum>,
    <ore:stickLongQuantum>];
	
global tieredSticks as IIngredient[] = [<ore:stickWroughtIron>, <ore:stickSteel>, <ore:stickAluminium>, <ore:stickStainlessSteel>, 
    <ore:stickTitanium>, <ore:stickTungstenSteel>, <ore:stickRhodiumPlatedPalladium>, 
    <ore:stickOsmiridium>, <ore:stickTritanium>, <ore:stickSeaborgium>,
    <ore:stickBohrium>, <ore:stickQuantum>, <ore:stickQuantum>,
    <ore:stickQuantum>];
	
global tieredGlass as IIngredient[] = [<ore:blockGlass>, <ore:blockGlass>, <gtadditions:ga_transparent_casing>, <gtadditions:ga_transparent_casing:1>, 
    <gtadditions:ga_transparent_casing:2>, <gtadditions:ga_transparent_casing:3>, <gtadditions:ga_transparent_casing:4>, 
    <gtadditions:ga_transparent_casing:5>, <gtadditions:ga_transparent_casing:6>, <gtadditions:ga_transparent_casing:6>,
    <gtadditions:ga_transparent_casing:6> ,<gtadditions:ga_transparent_casing:6>, <gtadditions:ga_transparent_casing:6>,
    <gtadditions:ga_transparent_casing:6>];
    
global tieredCables as IIngredient[] = [<ore:cableGtSingleRedAlloy>, <ore:cableGtSingleTin>, <ore:cableGtSingleCopper>, <ore:cableGtSingleGold>, 
    <ore:cableGtSingleAluminium>, <ore:cableGtSingleTungsten>, <ore:cableGtSingleVanadiumGallium>, 
    <ore:cableGtSingleNaquadah>, <ore:cableGtSingleNaquadahAlloy>, <ore:cableGtSingleAbyssalAlloy>,
    <ore:cableGtSingleTitanSteel>, <ore:cableGtSingleBlackTitanium>, <ore:cableGtSingleNeutronium>,
    <ore:cableGtSingleNeutronium>];

global superconductors as IIngredient[] = [null, <ore:wireGtSingleMvSuperconductor>, <ore:wireGtSingleMvSuperconductor>, <ore:wireGtSingleHvSuperconductor>, <ore:wireGtSingleEvSuperconductor>, <ore:wireGtSingleIvSuperconductor>, 
    <ore:wireGtSingleLuvSuperconductor>, <ore:wireGtSingleZpmSuperconductor>, <ore:wireGtSingleUvSuperconductor>, <ore:wireGtSingleUhvSuperconductor>, <ore:wireGtSingleUevSuperconductor>, <ore:wireGtSingleUivSuperconductor>,
    <ore:wireGtSingleUmvSuperconductor>, <ore:wireGtSingleUxvSuperconductor>, <ore:wireGtSingleSuperconductor>];

global cuttingFluids as ILiquidStack[] = [<liquid:water> * 42, <liquid:distilled_water> * 31, <liquid:lubricant> * 10];

global soldering_alloys as ILiquidStack[] = [<liquid:tin>, <liquid:soldering_alloy>];

global intCircuit as function(int)IIngredient = function(i as int) as IIngredient {
	return <metaitem:circuit.integrated>.withTag({Configuration: i});
};

global breweries as IItemStack[] = [null, <meta_tile_entity:gregtech:brewery.lv>, <meta_tile_entity:gregtech:brewery.mv>, <meta_tile_entity:gregtech:brewery.hv>,
	<meta_tile_entity:gregtech:brewery.ev>, <meta_tile_entity:gtadditions:brewery.iv>, <meta_tile_entity:gtadditions:brewery.luv>,
	<meta_tile_entity:gtadditions:brewery.zpm>, <meta_tile_entity:gtadditions:brewery.uv>, <meta_tile_entity:gtadditions:brewery.uhv>,
	<meta_tile_entity:gtadditions:brewery.uev>, <meta_tile_entity:gtadditions:brewery.uiv>, <meta_tile_entity:gtadditions:brewery.umv>,
	<meta_tile_entity:gtadditions:brewery.uxv>
];

global distilleries as IItemStack[] = [null, <meta_tile_entity:gregtech:distillery.lv>, <meta_tile_entity:gregtech:distillery.mv>, <meta_tile_entity:gregtech:distillery.hv>,
	<meta_tile_entity:gregtech:distillery.ev>, <meta_tile_entity:gtadditions:distillery.iv>, <meta_tile_entity:gtadditions:distillery.luv>,
	<meta_tile_entity:gtadditions:distillery.zpm>, <meta_tile_entity:gtadditions:distillery.uv>, <meta_tile_entity:gtadditions:distillery.uhv>,
	<meta_tile_entity:gtadditions:distillery.uev>, <meta_tile_entity:gtadditions:distillery.uiv>, <meta_tile_entity:gtadditions:distillery.umv>,
	<meta_tile_entity:gtadditions:distillery.uxv>
];

global createGreenHouseRecipes as function(IIngredient, IItemStack)void = function(seed as IIngredient, output as IItemStack) as void {
	green_house.recipeBuilder()
		.notConsumable(seed)
		.fluidInputs(<liquid:water> * 2000)
		.circuit(0)
		.outputs(output)
		.EUt(16)
		.duration(1000)
		.buildAndRegister();
	green_house.recipeBuilder()
		.notConsumable(seed)
		.inputs(<ore:dustBone>)
		.fluidInputs(<liquid:water> * 2000)
		.circuit(1)
		.outputs(output * 2)
		.EUt(16)
		.duration(1000)
		.buildAndRegister();
	green_house.recipeBuilder()
		.notConsumable(seed)
		.inputs(<ore:dustOrganicFertilizer>)
		.fluidInputs(<liquid:water> * 2000)
		.circuit(2)
		.outputs(output * 3)
		.EUt(16)
		.duration(1000)
		.buildAndRegister();
};