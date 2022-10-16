#loader contenttweaker 

import mods.contenttweaker.VanillaFactory; 
import mods.contenttweaker.Block;
import mods.contenttweaker.Item; 
import mods.contenttweaker.Color;
import mods.contenttweaker.BlockMaterial;
import mods.contenttweaker.Fluid;
import mods.contenttweaker.Player;

import crafttweaker.entity.IEntity;
import crafttweaker.entity.IEntityLivingBase;
import crafttweaker.player.IPlayer;
import crafttweaker.world.IRayTraceResult;
import crafttweaker.world.IBlockPos;
import crafttweaker.world.IBlockAccess;
import crafttweaker.block.IBlockState;
import crafttweaker.command.ICommandSender;

//-----------------------------------FLUIDS-----------------------------------

//-----------------------------------ROCKS-----------------------------------

var rock_carbon = VanillaFactory.createItem("rock_carbon");
rock_carbon.register();
var rock_carbonate = VanillaFactory.createItem("rock_carbonate");
rock_carbonate.register();
var rock_clay = VanillaFactory.createItem("rock_clay");
rock_clay.register();
var rock_oxide = VanillaFactory.createItem("rock_oxide");
rock_oxide.register();
var rock_phosphate = VanillaFactory.createItem("rock_phosphate");
rock_phosphate.register();
var rock_precious = VanillaFactory.createItem("rock_precious");
rock_precious.register();
var rock_radioactive = VanillaFactory.createItem("rock_radioactive");
rock_radioactive.register();
var rock_sedimentary = VanillaFactory.createItem("rock_sedimentary");
rock_sedimentary.register();
var rock_silicate = VanillaFactory.createItem("rock_silicate");
rock_silicate.register();
var rock_sulfur = VanillaFactory.createItem("rock_sulfur");
rock_sulfur.register();

//-----------------------------------PRIMITIVE AGE ITEMS-----------------------------------

var magnetite_chunk = VanillaFactory.createItem("magnetite_chunk");
var hot_iron_rod = VanillaFactory.createItem("hot_iron_rod");
var voltaic_pile = VanillaFactory.createItem("voltaic_pile");
var electrolyte_paper = VanillaFactory.createItem("electrolyte_paper");

voltaic_pile.maxStackSize = 1;

magnetite_chunk.register();
hot_iron_rod.register();
voltaic_pile.register();
electrolyte_paper.register();

//-----------------------------------STEAM AGE-----------------------------------

var vacuum_ejector_cascade = VanillaFactory.createItem("vacuum_ejector_cascade");
vacuum_ejector_cascade.maxStackSize = 1;
vacuum_ejector_cascade.register();

var vacuum_ejector = VanillaFactory.createItem("vacuum_ejector");
vacuum_ejector.register();

var unsoldered_vacuum_ejector = VanillaFactory.createItem("unsoldered_vacuum_ejector");
unsoldered_vacuum_ejector.register();

var unfinished_vacuum_tube = VanillaFactory.createItem("unfinished_vacuum_tube");
unfinished_vacuum_tube.register();

//-----------------------------------MV AGE-----------------------------------

var engine_block_cast = VanillaFactory.createItem("engine_block_cast");
var full_engine_block_cast = VanillaFactory.createItem("full_engine_block_cast");
var engine_block = VanillaFactory.createItem("engine_block");
var silicon_dioxide_wafer = VanillaFactory.createItem("silicon_dioxide_wafer");
var photocoated_wafer = VanillaFactory.createItem("photocoated_wafer");
var engraved_wafer = VanillaFactory.createItem("engraved_wafer");
var etched_wafer = VanillaFactory.createItem("etched_wafer");
var lithography_mask = VanillaFactory.createItem("lithography_mask");
var photocoated_board = VanillaFactory.createItem("photocoated_board");
var engraved_board = VanillaFactory.createItem("engraved_board");

engine_block_cast.register();
full_engine_block_cast.register();
engine_block.register();
silicon_dioxide_wafer.register();
photocoated_wafer.register();
engraved_wafer.register();
etched_wafer.register();
lithography_mask.register();
photocoated_board.register();
engraved_board.register();

//-----------------------------------HV AGE-----------------------------------

var coated_logic_circuit = VanillaFactory.createItem("coated_logic_circuit");
var engraved_logic_circuit = VanillaFactory.createItem("engraved_logic_circuit");

coated_logic_circuit.register();
engraved_logic_circuit.register();

//-----------------------------------EV AGE-----------------------------------

var vacuum_casing = VanillaFactory.createBlock("vacuum_casing", <blockmaterial:iron>);
vacuum_casing.register();

var doped_logic_circuit = VanillaFactory.createItem("doped_logic_circuit");
var tungsten_logic_circuit = VanillaFactory.createItem("tungsten_logic_circuit");
var platinum_logic_circuit = VanillaFactory.createItem("platinum_logic_circuit");
var unprepared_heat_shield = VanillaFactory.createItem("unprepared_heat_shield");
var heat_shield = VanillaFactory.createItem("heat_shield");

doped_logic_circuit.register();
tungsten_logic_circuit.register();
platinum_logic_circuit.register();
unprepared_heat_shield.register();
heat_shield.register();

//----------------------------------IV AGE-------------------------------------

var polycrystalline_silicon_wafer = VanillaFactory.createItem("polycrystalline_silicon_wafer");
var engraved_polycrystalline_wafer = VanillaFactory.createItem("engraved_polycrystalline_wafer");
var evaporation_mask = VanillaFactory.createItem("evaporation_mask");

polycrystalline_silicon_wafer.register();
engraved_polycrystalline_wafer.register();
evaporation_mask.register();

//-----------------------------------PLANET BLOCKS-----------------------------------

var titandust = VanillaFactory.createBlock("titandust", <blockmaterial:ground>);
var titaniadust = VanillaFactory.createBlock("titaniadust", <blockmaterial:ground>);
var titaniastone = VanillaFactory.createBlock("titaniastone", <blockmaterial:rock>);

titandust.register();
titaniadust.register();
titaniastone.register();