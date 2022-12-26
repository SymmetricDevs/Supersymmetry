#norun
#priority 10000

//Script based on the gregtech_globals.zs script from the Gregicality Community Pack

import mods.gregtech.recipe.RecipeMap;
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.liquid.ILiquidStack;

//Recipe Maps

global alloy_smelter as RecipeMap =                 <recipemap:alloy_smelter>;
global arc_furnace as RecipeMap =                   <recipemap:arc_furnace>;
global assembler as RecipeMap =                     <recipemap:assembler>;
global assembly_line as RecipeMap =                 <recipemap:assembly_line>;
global autoclave as RecipeMap =                     <recipemap:autoclave>;
global alloy_blast_smelter as RecipeMap =           <recipemap:alloy_blast_smelter>;
global brewery as RecipeMap =                       <recipemap:brewery>;
global canner as RecipeMap =                        <recipemap:canner>;
global catalytic_reformer as RecipeMap =            <recipemap:catalytic_reformer_recipes>;
global centrifuge as RecipeMap =                    <recipemap:centrifuge>;
global chemical_bath as RecipeMap =                 <recipemap:chemical_bath>;
global chemical_reactor as RecipeMap =              <recipemap:chemical_reactor>;
global circuit_assembler as RecipeMap =             <recipemap:circuit_assembler>;
global cooling_tower as RecipeMap =                 <recipemap:large_chemical_reactor>; //REPLACE WITH COOLING TOWER RECIPEMAP WHEN MBD STUFF IS DONE
global compressor as RecipeMap =                    <recipemap:compressor>;
global cracker as RecipeMap =                       <recipemap:cracker>;
global cutting_saw as RecipeMap =                   <recipemap:cutter>;
global cvd as RecipeMap =                           <recipemap:cvd_recipes>;
global cryogenic_reactor as RecipeMap =             <recipemap:cryogenic_reactor_recipes>;
global distillery as RecipeMap =                    <recipemap:distillery>;
global distillation_tower as RecipeMap =            <recipemap:distillation_tower>;
global dryer as RecipeMap =                         <recipemap:dryer_recipes>;
global ebf as RecipeMap =                           <recipemap:electric_blast_furnace>;
global efurnace as RecipeMap =                      <recipemap:furnace>;
global electrolyzer as RecipeMap =                  <recipemap:electrolyzer>;
global extractor as RecipeMap =                     <recipemap:extractor>;
global extruder as  RecipeMap =                     <recipemap:extruder>;
global fermenter as RecipeMap =                     <recipemap:fermenter>;
global fluid_compressor as RecipeMap =              <recipemap:mixer>; //REPLACE WITH FLUID COMPRESSOR RECIPEMAP WHEN MBD STUFF IS DONE
global fluid_decompressor as RecipeMap =            <recipemap:chemical_reactor>; //REPLACE WITH FLUID DECOMPRESSOR RECIPEMAP WHEN MBD STUFF IS DONE
global fluid_heater as RecipeMap =                  <recipemap:fluid_heater>;
global fluid_solidifier as RecipeMap =              <recipemap:fluid_solidifier>;
global forge_hammer as RecipeMap =                  <recipemap:forge_hammer>;
global forming_press as RecipeMap =                 <recipemap:forming_press>;
global fusion_reactor as RecipeMap =                <recipemap:fusion_reactor>;
global gas_turbine_recipes as RecipeMap =           <recipemap:steam_turbine>; //REPLACE WITH GAS TURBINE RECIPEMAP WHEN MBD STUFF IS DONE
global heat_exchanger_recipes as RecipeMap =        <recipemap:large_chemical_reactor>; //REPLACE WITH HEAT EXCHANGER RECIPEMAP WHEN MBD STUFF IS DONE
global implosion_compressor as RecipeMap =          <recipemap:implosion_compressor>;
global large_chemical_reactor as RecipeMap =        <recipemap:large_chemical_reactor>;
global large_weapons_factory as RecipeMap =         <recipemap:assembly_line>; //REPLACE WITH LARGE WEAPONS FACTORY RECIPEMAP WHEN MBD STUFF IS DONE
global laser_engraver as RecipeMap =                <recipemap:laser_engraver>;
global lathe as RecipeMap =                         <recipemap:lathe>;
global macerator as RecipeMap =                     <recipemap:macerator>;
global metal_bender as RecipeMap =                  <recipemap:metal_bender>;
global mixer as RecipeMap =                         <recipemap:mixer>;
global ore_sorter  as RecipeMap =                   <recipemap:centrifuge>; //REPLACE WITH ORE SORTER RECIPEMAP WHEN MBD STUFF IS DONE
global packer as RecipeMap =                        <recipemap:packer>;
global polarizer as RecipeMap =                     <recipemap:polarizer>;
global primitive_blast_furnace as RecipeMap = 	    <recipemap:primitive_blast_furnace>;
global pyrolyse_oven as RecipeMap =                 <recipemap:pyrolyse_oven>;
global quencher as RecipeMap =                      <recipemap:chemical_reactor>; //REPLACE WITH QUENCHER RECIPEMAP WHEN MBD STUFF IS DONE
global radiator as RecipeMap =                      <recipemap:chemical_reactor>; //REPLACE WITH RADIATOR RECIPEMAP WHEN MBD STUFF IS DONE
global railroad_engineering_station as RecipeMap =  <recipemap:assembler>; //REPLACE WITH RAILROAD ENGINEERING STATION RECIPEMAP WHEN MBD STUFF IS DONE
global sifter as RecipeMap =                        <recipemap:sifter>;
global steam_turbine as RecipeMap =                 <recipemap:steam_turbine>; //REPLACE WITH STEAM TURBINE RECIPEMAP WHEN MBD STUFF IS DONE
global thermal_centrifuge as RecipeMap =            <recipemap:thermal_centrifuge>;
global vacuum_freezer as RecipeMap =                <recipemap:vacuum_freezer>;
global weapons_factory as RecipeMap =               <recipemap:assembler>; //REPLACE WITH WEAPONS FACTORY RECIPEMAP WHEN RECIPEMAPS ACTUALLY WORK AGAIN
global wiremill as RecipeMap =                      <recipemap:wiremill>;



// Tiered Components

global voltageTiers as string[] = ["ulv", "lv", "mv", "hv", "ev", "iv", "luv", "zpm", "uv", "uhv", "uev", "uiv", "uxv", "opv", "max"];

global voltageTiersInt as int[] = [8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, 2097152, 8388608, 33554432, 134217728, 536870912, 2147483647];
global voltAmps as int[] =        [7, 30, 120, 480, 1920, 7680, 30720, 122880, 491520, 1966080, 7864320, 31457280, 125829120, 503316480, 2013265920];

global circuits as IIngredient[] = [<ore:circuitUlv>, <ore:circuitLv>, <ore:circuitMv>, 
    <ore:circuitHv>, <ore:circuitEv>, <ore:circuitIv>, 
    <ore:circuitLuv>, <ore:circuitZpm>, <ore:circuitUv>, 
    <ore:circuitUhv>, <ore:circuitUev>, <ore:circuitUiv>, 
    <ore:circuitUxv>, <ore:circuitOpv>];

global conveyors as IIngredient[] = [null, <metaitem:conveyor.module.lv>, <metaitem:conveyor.module.mv>, <metaitem:conveyor.module.hv>, 
    <metaitem:conveyor.module.ev>, <metaitem:conveyor.module.iv>, <metaitem:conveyor.module.luv>, 
    <metaitem:conveyor.module.zpm>, <metaitem:conveyor.module.uv>, <metaitem:conveyor.module.uhv>,
    <metaitem:conveyor.module.uev>, <metaitem:conveyor.module.uiv>, <metaitem:conveyor.module.opv>,
    <metaitem:conveyor.module.uxv>];

global pumps as IIngredient[] = [null, <metaitem:electric.pump.lv>, <metaitem:electric.pump.mv>, <metaitem:electric.pump.hv>,
    <metaitem:electric.pump.ev>, <metaitem:electric.pump.iv>, <metaitem:electric.pump.luv>, 
    <metaitem:electric.pump.zpm>, <metaitem:electric.pump.uv>, <metaitem:electric.pump.uhv>,
    <metaitem:electric.pump.uev>, <metaitem:electric.pump.uiv>, <metaitem:electric.pump.uxv>,
    <metaitem:electric.pump.opv>];

global field_generators as IIngredient[]= [null, <metaitem:field.generator.lv>, <metaitem:field.generator.mv>, <metaitem:field.generator.hv>, 
    <metaitem:field.generator.ev>, <metaitem:field.generator.iv>, <metaitem:field.generator.luv>, 
    <metaitem:field.generator.zpm>, <metaitem:field.generator.uv>, <metaitem:field.generator.uhv>,
    <metaitem:field.generator.uev>, <metaitem:field.generator.uiv>, <metaitem:field.generator.uxv>,
    <metaitem:field.generator.opv>];

global emitters as IIngredient[] = [null, <metaitem:emitter.lv>, <metaitem:emitter.mv>, <metaitem:emitter.hv>, 
    <metaitem:emitter.ev>, <metaitem:emitter.iv>, <metaitem:emitter.luv>, 
    <metaitem:emitter.zpm>, <metaitem:emitter.uv>, <metaitem:emitter.uhv>,
    <metaitem:emitter.uev>, <metaitem:emitter.uiv>, <metaitem:emitter.uxv>,
    <metaitem:emitter.opv>];
	
global sensors as IIngredient[] = [null, <metaitem:sensor.lv>, <metaitem:sensor.mv>, <metaitem:sensor.hv>, 
    <metaitem:sensor.ev>, <metaitem:sensor.iv>, <metaitem:sensor.luv>, 
    <metaitem:sensor.zpm>, <metaitem:sensor.uv>, <metaitem:sensor.uhv>,
    <metaitem:sensor.uev>, <metaitem:sensor.uiv>, <metaitem:sensor.uxv>,
    <metaitem:sensor.opv>];

global motors as IIngredient[] = [null, <metaitem:electric.motor.lv>, <metaitem:electric.motor.mv>, <metaitem:electric.motor.hv>, 
    <metaitem:electric.motor.ev>, <metaitem:electric.motor.iv>, <metaitem:electric.motor.luv>, 
    <metaitem:electric.motor.zpm>, <metaitem:electric.motor.uv>, <metaitem:electric.motor.uhv>,
    <metaitem:electric.motor.uev>, <metaitem:electric.motor.uiv>, <metaitem:electric.motor.uxv>,
    <metaitem:electric.motor.opv>];

global pistons as IIngredient[] = [null, <metaitem:electric.piston.lv>, <metaitem:electric.piston.mv>, <metaitem:electric.piston.hv>, 
    <metaitem:electric.piston.ev>, <metaitem:electric.piston.iv>, <metaitem:electric.piston.luv>, 
    <metaitem:electric.piston.zpm>, <metaitem:electric.piston.uv>, <metaitem:electric.piston.uhv>,
    <metaitem:electric.piston.uev>, <metaitem:electric.piston.uiv>, <metaitem:electric.piston.uxv>,
    <metaitem:electric.piston.opv>];

global robotArms as IIngredient[] = [null, <metaitem:robot.arm.lv>, <metaitem:robot.arm.mv>, <metaitem:robot.arm.hv>, 
    <metaitem:robot.arm.ev>, <metaitem:robot.arm.iv>, <metaitem:robot.arm.luv>, 
    <metaitem:robot.arm.zpm>, <metaitem:robot.arm.uv>, <metaitem:robot.arm.uhv>,
    <metaitem:robot.arm.uev>, <metaitem:robot.arm.uiv>, <metaitem:robot.arm.uxv>,
    <metaitem:robot.arm.opv>];

global hulls as IIngredient[] = [<meta_tile_entity:hull.ulv>, <meta_tile_entity:hull.lv>, <meta_tile_entity:hull.mv>, <meta_tile_entity:hull.hv>, 
    <meta_tile_entity:hull.ev>, <meta_tile_entity:hull.iv>, <meta_tile_entity:hull.luv>,
    <meta_tile_entity:hull.zpm>, <meta_tile_entity:hull.uv>, <meta_tile_entity:hull.uhv>,
    <meta_tile_entity:hull.uev>, <meta_tile_entity:hull.uiv>, <meta_tile_entity:hull.uxv>,
    <meta_tile_entity:hull.opv>];

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
	
/*global tieredGlass as IIngredient[] = [<ore:blockGlass>, <ore:blockGlass>, <gtadditions:ga_transparent_casing>, <gtadditions:ga_transparent_casing:1>, 
    <gtadditions:ga_transparent_casing:2>, <gtadditions:ga_transparent_casing:3>, <gtadditions:ga_transparent_casing:4>, 
    <gtadditions:ga_transparent_casing:5>, <gtadditions:ga_transparent_casing:6>, <gtadditions:ga_transparent_casing:6>,
    <gtadditions:ga_transparent_casing:6> ,<gtadditions:ga_transparent_casing:6>, <gtadditions:ga_transparent_casing:6>,
    <gtadditions:ga_transparent_casing:6>];
    */
global tieredCables as IIngredient[] = [<ore:cableGtSingleRedAlloy>, <ore:cableGtSingleTin>, <ore:cableGtSingleCopper>, <ore:cableGtSingleGold>, 
    <ore:cableGtSingleAluminium>, <ore:cableGtSingleTungsten>, <ore:cableGtSingleVanadiumGallium>, 
    <ore:cableGtSingleNaquadah>, <ore:cableGtSingleNaquadahAlloy>, <ore:cableGtSingleAbyssalAlloy>,
    <ore:cableGtSingleTitanSteel>, <ore:cableGtSingleBlackTitanium>, <ore:cableGtSingleNeutronium>,
    <ore:cableGtSingleNeutronium>];

global superconductors as IIngredient[] = [null, <ore:wireGtSingleMvSuperconductor>, <ore:wireGtSingleMvSuperconductor>, <ore:wireGtSingleHvSuperconductor>, <ore:wireGtSingleEvSuperconductor>, <ore:wireGtSingleIvSuperconductor>, 
    <ore:wireGtSingleLuvSuperconductor>, <ore:wireGtSingleZpmSuperconductor>, <ore:wireGtSingleUvSuperconductor>, <ore:wireGtSingleUhvSuperconductor>, <ore:wireGtSingleUevSuperconductor>, <ore:wireGtSingleUivSuperconductor>,
    <ore:wireGtSingleUmvSuperconductor>, <ore:wireGtSingleUxvSuperconductor>, <ore:wireGtSingleSuperconductor>];

global soldering_alloys as ILiquidStack[] = [<liquid:tin> * 144, <liquid:soldering_alloy> * 72];