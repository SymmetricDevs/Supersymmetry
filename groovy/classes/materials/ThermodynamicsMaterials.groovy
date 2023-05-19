import static classes.materials.Materials.*;

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
    
    
    public static void init() {

                generateHighPressureGases(Hydrogen, 10000, true);

                generateHighPressureGases(Oxygen, 10003, true);

                generateHighPressureGases(Helium, 10006, true);

                generateHighPressureGases(Neon, 10009, true);

                generateHighPressureGases(Argon, 10012, true);

                generateHighPressureGases(Krypton, 10015, true);

                generateHighPressureGases(Xenon, 10018, true);

                generateHighPressureGases(Nitrogen, 10021, true);

                generateHighPressureGases(Propene, 10024, false);

                generateHighPressureGases(Benzene, 10027, false);

                generateHighPressureGases(CarbonMonoxide, 10030, false);

                generateHighPressureGases(Air, 10033, true);

                generateHighPressureGases(NetherAir, 10036, true);

                generateHighPressureGases(RefineryGas, 10039, true);

                generateHighPressureGases(Methane, 10042, true);

                generateLiquidFromGas(Hydrogen, 10100, 21);

                generateLiquidFromGas(Helium, 10101, 5);

                generateLiquidFromGas(Neon, 10102, 27);

                generateLiquidFromGas(Argon, 10103, 88);

                generateLiquidFromGas(Krypton, 10104, 120);

                generateLiquidFromGas(Xenon, 10105, 165);

                generateLiquidFromGas(Nitrogen, 10106, 77);

                generateLiquidFromGas(RefineryGas, 10107, 112);

                generateLiquidFromGas(Methane, 10108, 112);

                generateThermoRefrigerant(Ammonia, 10200);

                generateThermoRefrigerant(Propane, 10204);

                generateThermoRefrigerant(CarbonDioxide, 10208);

                generateCoolant(Water, 10300);

                //generateCoolant(EthyleneGlycol, 10305);

                //generateCoolant(Brine, 10310);

                generateHotGas(Air, 10311);

                generateHotGas(Nitrogen, 10312);

                generateLiquidFromGas(NaturalGas, 10313, 110);

                generateHighPressureGases(NaturalGas, 10314, true);

                generateGreenhouseGases(EarthGreenhouseGas, 10401)

                generatePurifiedGas(Hydrogen, 10500)

                generatePurifiedGas(Helium, 10501)

                generatePurifiedGas(Nitrogen, 10502)

                generatePurifiedGas(Oxygen, 10503)

                generatePurifiedGas(Fluorine, 10504)

                generatePurifiedGas(Neon, 10505)

                generatePurifiedGas(Chlorine, 10506)

                generatePurifiedGas(Argon, 10507)

                generatePurifiedGas(Krypton, 10508)

                generatePurifiedGas(Xenon, 10509)

                generatePurifiedLiquid(Bromine, 10510)

                generatePurifiedLiquid(Mercury, 10511)

                generatePurifiedLiquid(Water, 10512)

    }
}

