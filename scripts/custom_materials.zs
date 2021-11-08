#loader gregtech
#priority 1000

import mods.gtadditions.recipe.Utils;
import mods.contenttweaker.Fluid;
import mods.contenttweaker.VanillaFactory;
import mods.gregtech.material.MaterialRegistry;

//-----------------------------------DUSTS-----------------------------------

Utils.registerDust("zircon.mold.base", 1200, 15441471, "DULL");
Utils.registerDust("ammonium_nitrate", 1201, 0xDEDEDE, "ROUGH");

//-----------------------------------FLUIDS-----------------------------------

Utils.registerFluid("low_vacuum", 16777215);
Utils.registerFluid("medium_vacuum", 16777215);
Utils.registerFluid("high_vacuum", 16777215);
Utils.registerFluid("ultra_high_vacuum", 16777215);
Utils.registerFluid("extremely_high_vacuum", 16777215);

//Thermo Gases
Utils.registerFluid("hot_hp_hydrogen", 181);
Utils.registerFluid("hp_hydrogen", 181);
Utils.registerFluid("cold_hp_hydrogen", 181);

Utils.registerFluid("hot_hp_oxygen", 9480942);
Utils.registerFluid("hp_oxygen", 9480942);
Utils.registerFluid("cold_hp_oxygen", 9480942);

Utils.registerFluid("hot_hp_helium", 14540032);
Utils.registerFluid("hp_helium", 14540032);
Utils.registerFluid("cold_hp_helium", 14540032);

Utils.registerFluid("hot_hp_neon", 16430260);
Utils.registerFluid("hp_neon", 16430260);
Utils.registerFluid("cold_hp_neon", 16430260);

Utils.registerFluid("hot_hp_argon", 65280);
Utils.registerFluid("hp_argon", 65280);
Utils.registerFluid("cold_hp_argon", 65280);

Utils.registerFluid("liquid_krypton", 8454016);
Utils.registerFluid("hot_hp_krypton", 8454016);
Utils.registerFluid("hp_krypton", 8454016);
Utils.registerFluid("cold_hp_krypton", 8454016);

Utils.registerFluid("liquid_xenon", 65535);
Utils.registerFluid("hot_hp_xenon", 65535);
Utils.registerFluid("hp_xenon", 65535);
Utils.registerFluid("cold_hp_xenon", 65535);

Utils.registerFluid("hot_hp_air", 11129077);
Utils.registerFluid("hp_air", 11129077);
Utils.registerFluid("cold_hp_air", 11129077);

Utils.registerFluid("hot_hp_nitrogen", 11129077);
Utils.registerFluid("hp_nitrogen", 11129077);
Utils.registerFluid("cold_hp_nitrogen", 11129077);

//Thermo Coolants
Utils.registerFluid("warm_water", 255);
Utils.registerFluid("warm_ethylene_glycol", 8421626);

//Thermo Refrigerants
Utils.registerFluid("hot_compressed_ammonia", 4142208);
Utils.registerFluid("compressed_ammonia", 4142208);
Utils.registerFluid("cold_ammonia", 4142208);

Utils.registerFluid("hot_compressed_propane", 16441936);
Utils.registerFluid("compressed_propane", 16441936);
Utils.registerFluid("cold_propane", 16441936);

Utils.registerFluid("hot_compressed_carbon_dioxide", 11129077);
Utils.registerFluid("compressed_carbon_dioxide", 11129077);
Utils.registerFluid("cold_carbon_dioxide", 11129077);

//Sulfurous water
Utils.registerFluid("sulfurous_water", 15592893);

//Oxide water
Utils.registerFluid("oxide_water", 15380270);

//Sedimentary water
Utils.registerFluid("mineralized_water", 11129077);

//Silicate water
Utils.registerFluid("silicate_water", 11651526);

//Graphite water
Utils.registerFluid("graphite_water", 6579300);

//Phosphate water
Utils.registerFluid("phosphate_water", 14540032);

//Precious water
Utils.registerFluid("precious_runoff", 11129077);

//Radioactive water
Utils.registerFluid("radioactive_runoff", 11129077);

//-----------------------------------OTHER TWEAKS-----------------------------------

<material:steel>.addFlags(["GENERATE_SPRING", "GENERATE_SPRING_SMALL"]);
<material:titanium>.addFlags(["GENERATE_SPRING_SMALL"]);
<material:lead>.addFlags(["GENERATE_ROUND"]);