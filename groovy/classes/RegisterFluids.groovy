import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//IDs 10000-20000 RESERVED FOR FLUIDS

class RegisterFluids{

        private static void generateHighPressureGases(Material materialName, int id){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, "hot_hp_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(323)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, "hp_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, "cold_hp_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(223)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, "hot_" + materialName.toString())
                        .fluid()
                        .fluidTemp(323)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateLiquidFromGas(Material materialName, int id, int boilingTemperature, boolean useGtPrefix){
                var color = materialName.getMaterialRGB();
                var prefix = "liquid_";

                if (useGtPrefix) {
                        prefix = "liquid_gt_";
                        //Used in case there is conflicting liquid names with other mods
                }

                new Material.Builder(id, prefix + materialName.toString())
                        .fluid()
                        .fluidTemp(boilingTemperature)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateThermoRefrigerant(Material materialName, int id){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, "hot_compressed_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(323)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, "compressed_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, "cold_compressed_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(223)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, "cold_" + materialName.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(223)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateCoolant(Material materialName, int id){
                var color = materialName.materialRGB;

                new Material.Builder(id, "warm_" + materialName.toString())
                        .fluid()
                        .fluidTemp(303)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

        }

        private static void generateHotGas(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, "hot_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 100)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        public static void init() {

                log.infoMC("Registering fluids...")

                new Material.Builder(11000, "sulfurous_water")
                        .fluid()
                        .color(0x592893)
                        .build();

                new Material.Builder(11001, "oxide_water")
                        .fluid()
                        .color(0x538020)
                        .build();

                new Material.Builder(11002, "mineralized_water")
                        .fluid()
                        .color(0x129077)
                        .build();

                new Material.Builder(11003, "silicate_water")
                        .fluid()
                        .color(0x651526)
                        .build();

                new Material.Builder(11004, "graphite_water")
                        .fluid()
                        .color(0x793000)
                        .build();

                new Material.Builder(11005, "phosphate_water")
                        .fluid()
                        .color(0x540032)
                        .build();

                new Material.Builder(11006, "precious_runoff")
                        .fluid()
                        .color(0x129077)
                        .build();

                new Material.Builder(11007, "radioactive_runoff")
                        .fluid()
                        .color(0x129077)
                        .build();

                new Material.Builder(11008, "silicon_solution")
                        .fluid()
                        .color(0x1f1c1c)
                        .build();

                new Material.Builder(11009, "calcium_carbonate_solution")
                        .fluid()
                        .color(0x8c8981)
                        .build();

                new Material.Builder(11010, "bentonite_clay_solution")
                        .fluid()
                        .color(0xa2bdb5)
                        .build();

                var FilteredAir = new Material.Builder(14000, "filtered_air")
                        .fluid()
                        .color(0x7ab5c4)
                        .build();

                new Material.Builder(15000, "sea_water")
                        .fluid()
                        .color(0x5b9acf)
                        .build();

                new Material.Builder(16000, "flue_gas")
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(1366)
                        .color(0x3e3f40)
                        .build();

                new Material.Builder(16001, "exhaust_steam")
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(523)
                        .color(0x7a7a7a)
                        .build();

                new Material.Builder(16002, "flibe_gt")
                        .fluid()
                        .dust()
                        .components(Fluorine, 3, Lithium, 1, Beryllium, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(19000, "smoke_bomb_mix")
                        .fluid()
                        .color(0xbfbfbf)
                        .build();

                generateHighPressureGases(Hydrogen, 10000);

                generateHighPressureGases(Oxygen, 10004);

                generateHighPressureGases(Helium, 10008);

                generateHighPressureGases(Neon, 10012);

                generateHighPressureGases(Argon, 10016);

                generateHighPressureGases(Krypton, 10020);

                generateHighPressureGases(Xenon, 10024);

                generateHighPressureGases(Air, 10028);

                generateHighPressureGases(Nitrogen, 10032);

                generateHighPressureGases(NetherAir, 10036);

                generateHighPressureGases(EnderAir, 10040);

                generateHighPressureGases(FilteredAir, 10044);

                generateLiquidFromGas(Hydrogen, 10100, 21, true);

                generateLiquidFromGas(Helium, 10101, 5, true);

                generateLiquidFromGas(Neon, 10102, 27, true);

                generateLiquidFromGas(Argon, 10103, 88, true);

                generateLiquidFromGas(Krypton, 10104, 120, false);

                generateLiquidFromGas(Xenon, 10105, 165, false);

                generateLiquidFromGas(Nitrogen, 10106, 77, true);

                generateLiquidFromGas(FilteredAir, 10107, 77, false);

                generateThermoRefrigerant(Ammonia, 10200);

                generateThermoRefrigerant(Propane, 10204);

                generateThermoRefrigerant(CarbonDioxide, 10208);

                generateCoolant(Water, 10300);

                //generateCoolant(EthyleneGlycol, 10305);

                //generateCoolant(Brine, 10310);

                generateHotGas(Air, 10311);

                new Material.Builder(32000, 'fluix')
                        .gem().iconSet(RUBY)
                        .components(Quartzite, 4, Naquadah, 1)
                        //.flags(MaterialFlags.DISABLE_DECOMPOSITION, MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_LENS])
                        .color(0x6503b6)
                        .build();


                new Material.Builder(32001, 'pig_iron')
                        .ingot().dust()
                        //.components(Iron, 1)
                        .flags(GENERATE_PLATE)
                        .color(0x99918A)
                        .build();

                log.infoMC("Finished adding fluids")
        }


}