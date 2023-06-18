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

                generateHighPressureGases(Oxygen, 22003, true);

                generateHighPressureGases(Helium, 22006, true);

                generateHighPressureGases(Neon, 22009, true);

                generateHighPressureGases(Argon, 22012, true);

                generateHighPressureGases(Krypton, 22015, true);

                generateHighPressureGases(Xenon, 22018, true);

                generateHighPressureGases(Nitrogen, 22021, true);

                generateHighPressureGases(Propene, 22024, false);

                generateHighPressureGases(Benzene, 22027, false);

                generateHighPressureGases(CarbonMonoxide, 22030, false);

                generateHighPressureGases(Air, 22033, true);

                generateHighPressureGases(NetherAir, 22036, true);

                generateHighPressureGases(RefineryGas, 22039, true);

                generateHighPressureGases(Methane, 22042, true);

                generateHighPressureGases(NaturalGas, 22045, true);

                generateLiquidFromGas(Hydrogen, 22100, 14);

                generateLiquidFromGas(Helium, 22101, 5);

                generateLiquidFromGas(Neon, 22102, 27);

                generateLiquidFromGas(Argon, 22103, 88);

                generateLiquidFromGas(Krypton, 22104, 120);

                generateLiquidFromGas(Xenon, 22105, 165);

                generateLiquidFromGas(Nitrogen, 22106, 77);

                generateLiquidFromGas(RefineryGas, 22107, 112);

                generateLiquidFromGas(Methane, 22108, 112);

                generateLiquidFromGas(NaturalGas, 22109, 110);
                
                generateThermoRefrigerant(Ammonia, 22150);

                generateThermoRefrigerant(Propane, 22155);

                generateThermoRefrigerant(CarbonDioxide, 22160);

                generateCoolant(Water, 22300);

                generateCoolant(EthyleneGlycol, 22305);

                generateCoolant(Brine, 22310);

                generateHotGas(Air, 22400);

                generateHotGas(Nitrogen, 22401);

                generatePurifiedGas(Hydrogen, 22500)

                generatePurifiedGas(Helium, 22501)

                generatePurifiedGas(Nitrogen, 22502)

                generatePurifiedGas(Oxygen, 22503)

                generatePurifiedGas(Fluorine, 22504)

                generatePurifiedGas(Neon, 22505)

                generatePurifiedGas(Chlorine, 22506)

                generatePurifiedGas(Argon, 22507)

                generatePurifiedGas(Krypton, 22508)

                generatePurifiedGas(Xenon, 22509)

                generatePurifiedLiquid(Bromine, 22600)

                generatePurifiedLiquid(Mercury, 22601)

                generateGreenhouseGases(EarthGreenhouseGas, 22700)

                EarthlikeAir = new Material.Builder(22800, "earth_like_air")
                        .fluid(FluidTypes.GAS)
                        .color(0x8fbfe3)
                        .build();

        HotHighPressureSteam = new Material.Builder(22801, "hot_hp_steam")
                .fluid(FluidTypes.GAS)
                .fluidTemp(1200)
                .color(0xffffff)
                .build();

    }
}

