package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;


class ThermodynamicsMaterials {
    
    private static void generateHighPressureGases(Material materialName, int id, boolean generateCold){
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

                if (generateCold) {
                        new Material.Builder(id + 2, "cold_hp_" + materialName.toString())
                                .fluid(FluidTypes.GAS)
                                .fluidTemp(223)
                                .color(color)
                                .components(materialName, 1)
                                .flags(DISABLE_DECOMPOSITION)
                                .build();
                }
        }

        private static void generateLiquidFromGas(Material materialName, int id, int boilingTemperature){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, "liquid_" + materialName.toString())
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

        private static void generateGreenhouseGases(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, "warm_dry_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, "warm_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, "warm_humid_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, "dry_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 4, "humid_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 5, "cool_dry_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() - 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 6, "cool_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() - 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 7, "cool_humid_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() - 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generatePurifiedGas(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, "high_purity_" + material.toString())
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .build();
        }

        private static void generatePurifiedLiquid(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, "high_purity_" + material.toString())
                        .fluid()
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .build();
        }
    
    
    public static void register() {

                log.infoMC("Registering Thermodynamics Materials!");


                generateHighPressureGases(Hydrogen, 22000, true);

                generateHighPressureGases(Oxygen, 22001, true);

                generateHighPressureGases(Helium, 22002, true);

                generateHighPressureGases(Neon, 22003, true);

                generateHighPressureGases(Argon, 22004, true);

                generateHighPressureGases(Krypton, 22005, true);

                generateHighPressureGases(Xenon, 22006, true);

                generateHighPressureGases(Nitrogen, 22007, true);

                generateHighPressureGases(Propene, 22008, false);

                generateHighPressureGases(Benzene, 22009, false);

                generateHighPressureGases(CarbonMonoxide, 22010, false);

                generateHighPressureGases(Air, 22011, true);

                generateHighPressureGases(NetherAir, 22012, true);

                generateHighPressureGases(RefineryGas, 22013, true);

                generateHighPressureGases(Methane, 22014, true);

                generateLiquidFromGas(Hydrogen, 22015, 21);

                generateLiquidFromGas(Helium, 22016, 5);

                generateLiquidFromGas(Neon, 22017, 27);

                generateLiquidFromGas(Argon, 22018, 88);

                generateLiquidFromGas(Krypton, 22019, 120);

                generateLiquidFromGas(Xenon, 22020, 165);

                generateLiquidFromGas(Nitrogen, 22021, 77);

                generateLiquidFromGas(RefineryGas, 22022, 112);

                generateLiquidFromGas(Methane, 22023, 112);

                generateThermoRefrigerant(Ammonia, 22024);

                generateThermoRefrigerant(Propane, 22025);

                generateThermoRefrigerant(CarbonDioxide, 22026);

                generateCoolant(Water, 22027);

                generateCoolant(EthyleneGlycol, 22028);

                generateCoolant(Brine, 22029);

                generateHotGas(Air, 22030);

                generateHotGas(Nitrogen, 22031);

                generateLiquidFromGas(NaturalGas, 22032, 110);

                generateHighPressureGases(NaturalGas, 22033, true);

                generateGreenhouseGases(EarthGreenhouseGas, 22034)

                generatePurifiedGas(Hydrogen, 22035)

                generatePurifiedGas(Helium, 22036)

                generatePurifiedGas(Nitrogen, 22037)

                generatePurifiedGas(Oxygen, 22038)

                generatePurifiedGas(Fluorine, 22039)

                generatePurifiedGas(Neon, 22040)

                generatePurifiedGas(Chlorine, 22041)

                generatePurifiedGas(Argon, 22042)

                generatePurifiedGas(Krypton, 22043)

                generatePurifiedGas(Xenon, 22044)

                generatePurifiedLiquid(Bromine, 22045)

                generatePurifiedLiquid(Mercury, 22046)

                generatePurifiedLiquid(Water, 22047)

                EarthlikeAir = new Material.Builder(22048, "earth_like_air")
                        .fluid(FluidTypes.GAS)
                        .color(0x8fbfe3)
                        .build();

    }
}

