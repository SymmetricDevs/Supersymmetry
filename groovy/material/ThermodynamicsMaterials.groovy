package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;


class ThermodynamicsMaterials {
    
    private static void generateHighPressureGases(Material materialName, int id, boolean generateCold){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, SuSyUtility.susyId("hot_hp_" + materialName.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(323)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, SuSyUtility.susyId("hp_" + materialName.toString()))
                        .fluid(FluidTypes.GAS)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                if (generateCold) {
                        new Material.Builder(id + 2, SuSyUtility.susyId("cold_hp_" + materialName.toString()))
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

                new Material.Builder(id, SuSyUtility.susyId("liquid_" + materialName.toString()))
                        .fluid()
                        .fluidTemp(boilingTemperature)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateThermoRefrigerant(Material materialName, int id){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, SuSyUtility.susyId("hot_compressed_" + materialName.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(323)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, SuSyUtility.susyId("compressed_" + materialName.toString()))
                        .fluid(FluidTypes.GAS)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, SuSyUtility.susyId("cold_compressed_" + materialName.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(223)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, SuSyUtility.susyId("cold_" + materialName.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(223)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateCoolant(Material materialName, int id){
                var color = materialName.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("warm_" + materialName.toString()))
                        .fluid()
                        .fluidTemp(303)
                        .color(color)
                        .components(materialName, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

        }

        private static void generateHotGas(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("hot_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 100)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateGreenhouseGases(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("warm_dry_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, SuSyUtility.susyId("warm_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, SuSyUtility.susyId("warm_humid_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() + 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, SuSyUtility.susyId("dry_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 4, SuSyUtility.susyId("humid_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 5, SuSyUtility.susyId("cool_dry_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() - 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 6, SuSyUtility.susyId("cool_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() - 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 7, SuSyUtility.susyId("cool_humid_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature() - 20)
                        .color(color)
                        .components(material, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generatePurifiedGas(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("high_purity_" + material.toString()))
                        .fluid(FluidTypes.GAS)
                        .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                        .color(color)
                        .components(material, 1)
                        .build();
        }

        private static void generatePurifiedLiquid(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("high_purity_" + material.toString()))
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

                generateHighPressureGases(DecarburizedAir, 22048, true);

                generateLiquidFromGas(Hydrogen, 22100, 14);

                generateLiquidFromGas(Neon, 22102, 27);

                generateLiquidFromGas(Argon, 22103, 88);

                generateLiquidFromGas(Krypton, 22104, 120);

                generateLiquidFromGas(Xenon, 22105, 165);

                generateLiquidFromGas(Nitrogen, 22106, 77);

                generateLiquidFromGas(RefineryGas, 22107, 112);

                generateLiquidFromGas(Methane, 22108, 112);

                generateLiquidFromGas(NaturalGas, 22109, 110);

                generateLiquidFromGas(DecarburizedAir, 22110, 80)

                generateThermoRefrigerant(Ammonia, 22150);

                generateThermoRefrigerant(Propane, 22155);

                generateThermoRefrigerant(CarbonDioxide, 22160);

                generateThermoRefrigerant(Trichlorofluoromethane, 22165);

                generateThermoRefrigerant(Dichlorodifluoromethane, 22170);

                generateThermoRefrigerant(Chlorotrifluoromethane, 22175);

                generateThermoRefrigerant(Chlorodifluoromethane, 22180);

                generateCoolant(Water, 22300);

                generateCoolant(EthyleneGlycol, 22305);

                generateCoolant(SaltWater, 22310);

                generateCoolant(Lubricant, 22315);

                generateCoolant(PolychlorinatedBiphenyl, 22320);

                generateCoolant(Brine, 22325);

                generateCoolant(SodiumPotassium, 22330);

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

        EarthlikeAir = new Material.Builder(22800, SuSyUtility.susyId("earth_like_air"))
                .fluid(FluidTypes.GAS)
                .color(0x8fbfe3)
                .build();

        HotHighPressureSteam = new Material.Builder(22801, SuSyUtility.susyId("hot_hp_steam"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(1200)
                .color(0xffffff)
                .build();

        /*CompressedAir = new Material.Builder(22802, "compressed_air")
                .fluid(FluidTypes.GAS)
                .color(0x95bee6)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        ChilledAir = new Material.Builder(22803, "chilled_air")
                .fluid(FluidTypes.GAS)
                .fluidTemp(273)
                .color(0x7ea7cf)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        PurifiedAir = new Material.Builder(22804, "purified_air")
                .fluid(FluidTypes.GAS)
                .fluidTemp(273)
                .color(0x6b97c2)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        BoostedAir = new Material.Builder(22805, "boosted_air")
                .fluid(FluidTypes.GAS)
                .fluidTemp(273)
                .color(0x598ec2)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        ColdWater = new Material.Builder(22806, "cold_water")
                .fluid()
                .fluidTemp(273)
                .color(0x6293e3)
                .components(Hydrogen, 2, Oxygen, 1)
                .build();*/

        WasteGaseousNitrogen = new Material.Builder(22807, SuSyUtility.susyId("waste_gaseous_nitrogen"))
                .fluid(FluidTypes.GAS)
                .color(0x29a4a6)
                .build();

        /*PurfiedWasteGaseousNitrogen = new Material.Builder(22808, "purified_waste_gaseous_nitrogen")
                .fluid(FluidTypes.GAS)
                .color(0x37b1b3)
                .build();

        ChilledBoostedAir = new Material.Builder(22809, "chilled_boosted_air")
                .fluid(FluidTypes.GAS)
                .fluidTemp(203)
                .color(0x4679ab)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        PartiallyLiquifiedAir = new Material.Builder(22810, "partially_liquified_air")
                .fluid(FluidTypes.GAS)
                .fluidTemp(100)
                .color(0x4679ab)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        GaseousAirFeedstock = new Material.Builder(22811, "gaseous_air_feedstock")
                .fluid(FluidTypes.GAS)
                .fluidTemp(150)
                .color(0x3b72a8)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();

        LiquidAirFeedstock = new Material.Builder(22812, "liquid_air_feedstock")
                .fluid()
                .fluidTemp(80)
                .color(0x3b72a8)
                .components(Nitrogen, 78, Oxygen, 21, Argon, 9)
                .build();*/

        ChillyWasteGaseousNitrogen = new Material.Builder(22813, SuSyUtility.susyId('chilly_waste_gaseous_nitrogen'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(243)
                .color(0x3f9d9e)
                .build();

        SubcooledLiquidNitrogen = new Material.Builder(22814, SuSyUtility.susyId('subcooled_liquid_nitrogen'))
                .fluid()
                .fluidTemp(60)
                .color(0x009a9c)
                .build();

        ColdWasteGaseousNitrogen = new Material.Builder(22815, SuSyUtility.susyId('cold_waste_gaseous_nitrogen'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(223)
                .color(0x367f80)
                .build();

        UntreatedLiquidOxygen = new Material.Builder(22816, SuSyUtility.susyId('untreated_liquid_oxygen'))
                .fluid()
                .fluidTemp(55)
                .color(0x49a4d1)
                .build();

        UntreatedLiquidNitrogen = new Material.Builder(22817, SuSyUtility.susyId('untreated_liquid_nitrogen'))
                .fluid()
                .fluidTemp(60)
                .color(0x029799)
                .build();

        OxygenRichLiquid = new Material.Builder(22818, SuSyUtility.susyId('oxygen_rich_liquid'))
                .fluid()
                .fluidTemp(55)
                .color(0x67c6e0)
                .build();

        OxygenRichGas = new Material.Builder(22819, SuSyUtility.susyId('oxygen_rich_gas'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(90)
                .color(0x78d2eb)
                .build();

        NitrogenRichGas = new Material.Builder(22820, SuSyUtility.susyId('nitrogen_rich_gas'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(120)
                .color(0x7ee0dd)
                .build();

        ArgonRichGas = new Material.Builder(22821, SuSyUtility.susyId('argon_rich_gas'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(140)
                .color(0x6bc9aa)
                .build();

        OxygenRichVapor = new Material.Builder(22822, SuSyUtility.susyId('oxygen_rich_vapor'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(170)
                .color(0x92e1f7)
                .build();

        CrudeArgonVapor = new Material.Builder(22823, SuSyUtility.susyId('crude_argon_vapor'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(160)
                .color(0x78e3c0)
                .build();

        SubcooledOxygenRichLiquid = new Material.Builder(22824, SuSyUtility.susyId('subcooled_oxygen_rich_liquid'))
                .fluid()
                .fluidTemp(90)
                .color(0x0dba0d)
                .build();

        CrudeLiquidKrypton = new Material.Builder(22825, SuSyUtility.susyId('crude_liquid_krypton'))
                .fluid()
                .fluidTemp(120)
                .color(0x579e57)
                .build();

        RareGasRichFraction = new Material.Builder(22826, SuSyUtility.susyId('rare_gas_rich_fraction'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(80)
                .color(0xd3eb94)
                .build();

        CondensedRareGasRichFraction = new Material.Builder(22827, SuSyUtility.susyId('condensed_rare_gas_rich_fraction'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(60)
                .color(0xe3a56b)
                .build();

        CrudeNeonVapor = new Material.Builder(22828, SuSyUtility.susyId('crude_neon_vapor'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(40)
                .color(0xc77b7b)
                .build();

        GaseousCrudeKrypton = new Material.Builder(22829, SuSyUtility.susyId('gaseous_crude_krypton'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(160)
                .color(0x579e57)
                .build();

        ColdLiquidOxygen = new Material.Builder(22830, SuSyUtility.susyId('cold_liquid_oxygen'))
                .fluid()
                .fluidTemp(40)
                .color(0x1f729c)
                .build();

        CompressedCrudeNeon = new Material.Builder(22831, SuSyUtility.susyId('compressed_crude_neon'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(40)
                .color(0xa65e5e)
                .build();

        PartiallyLiquefiedCrudeNeon = new Material.Builder(22832, SuSyUtility.susyId('partially_liquefied_crude_neon'))
                .fluid()
                .fluidTemp(30)
                .color(0xb35959)
                .build();

        GaseousCrudeNeon = new Material.Builder(22833, SuSyUtility.susyId('gaseous_crude_neon'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(35)
                .color(0xbd5757)
                .build();

        LiquidCrudeNeon = new Material.Builder(22834, SuSyUtility.susyId('liquid_crude_neon'))
                .fluid()
                .fluidTemp(25)
                .color(0x944444)
                .build();

        LiquidCrudeArgon = new Material.Builder(22835, SuSyUtility.susyId('liquid_crude_argon'))
                .fluid()
                .fluidTemp(90)
                .color(0x0dba0d)
                .build();

        ColdGaseousNitrogen = new Material.Builder(22836, SuSyUtility.susyId('cold_gaseous_nitrogen'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(140)
                .color(0x23b9ba)
                .build();

        LiquidArgonProduct = new Material.Builder(22837, SuSyUtility.susyId('liquid_argon_product'))
                .fluid()
                .fluidTemp(87)
                .color(0x0ecc0e)
                .build();

        LiquidOxygenProduct = new Material.Builder(22838, SuSyUtility.susyId('liquid_oxygen_product'))
                .fluid()
                .fluidTemp(90)
                .color(0x459fcc)
                .build();

        LiquidNitrogenProduct = new Material.Builder(22839, SuSyUtility.susyId('liquid_nitrogen_product'))
                .fluid()
                .fluidTemp(77)
                .color(0x0b9a9c)
                .build();

        LiquidDeoxygenatedArgon = new Material.Builder(22840, SuSyUtility.susyId('liquid_deoxygenated_argon'))
                .fluid()
                .fluidTemp(87)
                .color(0x3de03d)
                .build();

        LiquidWasteNitrogen = new Material.Builder(22841, SuSyUtility.susyId('liquid_waste_nitrogen'))
                .fluid()
                .fluidTemp(77)
                .color(0x379394)
                .build();

        PartiallyLiquefiedArgon = new Material.Builder(22842, SuSyUtility.susyId('partially_liquefied_argon'))
                .fluid()
                .fluidTemp(120)
                .color(0x56bf56)
                .build();
    }
}