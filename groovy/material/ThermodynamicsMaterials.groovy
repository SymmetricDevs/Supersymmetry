package material;

import static material.SuSyMaterials.*;
import static globals.Globals.determineTemperatureGas;
import static globals.Globals.determineTemperatureLiquid;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.fluids.FluidConstants.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

class ThermodynamicsMaterials {


        private static void generateHighPressureGases(Material materialName, int id, boolean generateCold){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, SuSyUtility.susyId("hot_hp_" + materialName.toString()))
                        .gas(new FluidBuilder().temperature(323))
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, SuSyUtility.susyId("hp_" + materialName.toString()))
                        .gas()
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                if (generateCold) {
                        new Material.Builder(id + 2, SuSyUtility.susyId("cold_hp_" + materialName.toString()))
                                .gas(new FluidBuilder().temperature(223))
                                .color(color)
                                .components(materialName)
                                .flags(DISABLE_DECOMPOSITION)
                                .build();
                }
        }

        private static void generateLiquidFromGas(Material materialName, int id, int boilingTemperature){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, SuSyUtility.susyId("liquid_" + materialName.toString()))
                        .liquid(new FluidBuilder().temperature(boilingTemperature))
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateThermoRefrigerant(Material materialName, int id){
                var color = materialName.getMaterialRGB();

                new Material.Builder(id, SuSyUtility.susyId("hot_compressed_" + materialName.toString()))
                        .gas(new FluidBuilder().temperature(323))
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, SuSyUtility.susyId("compressed_" + materialName.toString()))
                        .gas()
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, SuSyUtility.susyId("cold_compressed_" + materialName.toString()))
                        .gas(new FluidBuilder().temperature(223))
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, SuSyUtility.susyId("cold_" + materialName.toString()))
                        .gas(new FluidBuilder().temperature(223))
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateCoolant(Material materialName, int id){
                var color = materialName.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("warm_" + materialName.toString()))
                        .liquid(new FluidBuilder().temperature(303))
                        .color(color)
                        .components(materialName)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

        }

        private static void generateHotGas(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("hot_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 100))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generateGreenhouseGases(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("warm_dry_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 1, SuSyUtility.susyId("warm_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 2, SuSyUtility.susyId("warm_humid_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 3, SuSyUtility.susyId("dry_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 4, SuSyUtility.susyId("humid_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 5, SuSyUtility.susyId("cool_dry_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 6, SuSyUtility.susyId("cool_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(id + 7, SuSyUtility.susyId("cool_humid_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                        .color(color)
                        .components(material)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();
        }

        private static void generatePurifiedGas(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("high_purity_" + material.toString()))
                        .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                        .color(color)
                        .components(material)
                        .build();
        }

        private static void generatePurifiedLiquid(Material material, int id) {
                var color = material.materialRGB;

                new Material.Builder(id, SuSyUtility.susyId("high_purity_" + material.toString()))
                        .liquid(new FluidBuilder().temperature(determineTemperatureLiquid(material)))
                        .color(color)
                        .components(material)
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

                generateHighPressureGases(FuelGas, 22039, true);

                generateHighPressureGases(Methane, 22042, true);

                generateHighPressureGases(NaturalGas, 22045, true);

                generateHighPressureGases(DecarburizedAir, 22048, true);

                generateLiquidFromGas(Hydrogen, 22100, 14);

                generateLiquidFromGas(Neon, 22102, 27);

                generateLiquidFromGas(Argon, 22103, 88);

                generateLiquidFromGas(Krypton, 22104, 120);

                generateLiquidFromGas(Xenon, 22105, 165);

                generateLiquidFromGas(Nitrogen, 22106, 77);

                // FREE ID: 22107

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
                .gas()
                .color(0x8fbfe3)
                .build();

        HotHighPressureSteam = new Material.Builder(22801, SuSyUtility.susyId("hot_hp_steam"))
                .gas(new FluidBuilder().temperature(1200))
                .color(0xffffff)
                .build();

        WasteGaseousNitrogen = new Material.Builder(22807, SuSyUtility.susyId("waste_gaseous_nitrogen"))
                .gas()
                .color(0x29a4a6)
                .build();

        ChillyWasteGaseousNitrogen = new Material.Builder(22813, SuSyUtility.susyId('chilly_waste_gaseous_nitrogen'))
                .gas(new FluidBuilder().temperature(243))
                .color(0x3f9d9e)
                .build();

        SubcooledLiquidNitrogen = new Material.Builder(22814, SuSyUtility.susyId('subcooled_liquid_nitrogen'))
                .liquid(new FluidBuilder().temperature(60))
                .color(0x009a9c)
                .build();

        ColdWasteGaseousNitrogen = new Material.Builder(22815, SuSyUtility.susyId('cold_waste_gaseous_nitrogen'))
                .gas(new FluidBuilder().temperature(223))
                .color(0x367f80)
                .build();

        UntreatedLiquidOxygen = new Material.Builder(22816, SuSyUtility.susyId('untreated_liquid_oxygen'))
                .liquid(new FluidBuilder().temperature(55))
                .color(0x49a4d1)
                .build();

        UntreatedLiquidNitrogen = new Material.Builder(22817, SuSyUtility.susyId('untreated_liquid_nitrogen'))
                .liquid(new FluidBuilder().temperature(60))
                .color(0x029799)
                .build();

        OxygenRichLiquid = new Material.Builder(22818, SuSyUtility.susyId('oxygen_rich_liquid'))
                .liquid(new FluidBuilder().temperature(55))
                .color(0x67c6e0)
                .build();

        OxygenRichGas = new Material.Builder(22819, SuSyUtility.susyId('oxygen_rich_gas'))
                .gas(new FluidBuilder().temperature(90))
                .color(0x78d2eb)
                .build();

        NitrogenRichGas = new Material.Builder(22820, SuSyUtility.susyId('nitrogen_rich_gas'))
                .gas(new FluidBuilder().temperature(120))
                .color(0x7ee0dd)
                .build();

        ArgonRichGas = new Material.Builder(22821, SuSyUtility.susyId('argon_rich_gas'))
                .gas(new FluidBuilder().temperature(140))
                .color(0x6bc9aa)
                .build();

        OxygenRichVapor = new Material.Builder(22822, SuSyUtility.susyId('oxygen_rich_vapor'))
                .gas(new FluidBuilder().temperature(170))
                .color(0x92e1f7)
                .build();

        CrudeArgonVapor = new Material.Builder(22823, SuSyUtility.susyId('crude_argon_vapor'))
                .gas(new FluidBuilder().temperature(160))
                .color(0x78e3c0)
                .build();

        SubcooledOxygenRichLiquid = new Material.Builder(22824, SuSyUtility.susyId('subcooled_oxygen_rich_liquid'))
                .gas(new FluidBuilder().temperature(90))
                .color(0x0dba0d)
                .build();

        CrudeLiquidKrypton = new Material.Builder(22825, SuSyUtility.susyId('crude_liquid_krypton'))
                .liquid(new FluidBuilder().temperature(120))
                .color(0x579e57)
                .build();

        RareGasRichFraction = new Material.Builder(22826, SuSyUtility.susyId('rare_gas_rich_fraction'))
                .gas(new FluidBuilder().temperature(80))
                .color(0xd3eb94)
                .build();

        CondensedRareGasRichFraction = new Material.Builder(22827, SuSyUtility.susyId('condensed_rare_gas_rich_fraction'))
                .gas(new FluidBuilder().temperature(60))
                .color(0xe3a56b)
                .build();

        CrudeNeonVapor = new Material.Builder(22828, SuSyUtility.susyId('crude_neon_vapor'))
                .gas(new FluidBuilder().temperature(40))
                .color(0xc77b7b)
                .build();

        GaseousCrudeKrypton = new Material.Builder(22829, SuSyUtility.susyId('gaseous_crude_krypton'))
                .gas(new FluidBuilder().temperature(160))
                .color(0x579e57)
                .build();

        ColdLiquidOxygen = new Material.Builder(22830, SuSyUtility.susyId('cold_liquid_oxygen'))
                .liquid(new FluidBuilder().temperature(40))
                .color(0x1f729c)
                .build();

        CompressedCrudeNeon = new Material.Builder(22831, SuSyUtility.susyId('compressed_crude_neon'))
                .gas(new FluidBuilder().temperature(40))
                .color(0xa65e5e)
                .build();

        PartiallyLiquefiedCrudeNeon = new Material.Builder(22832, SuSyUtility.susyId('partially_liquefied_crude_neon'))
                .liquid(new FluidBuilder().temperature(30))
                .color(0xb35959)
                .build();

        GaseousCrudeNeon = new Material.Builder(22833, SuSyUtility.susyId('gaseous_crude_neon'))
                .gas(new FluidBuilder().temperature(35))
                .color(0xbd5757)
                .build();

        LiquidCrudeNeon = new Material.Builder(22834, SuSyUtility.susyId('liquid_crude_neon'))
                .liquid(new FluidBuilder().temperature(25))
                .color(0x944444)
                .build();

        LiquidCrudeArgon = new Material.Builder(22835, SuSyUtility.susyId('liquid_crude_argon'))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x0dba0d)
                .build();

        ColdGaseousNitrogen = new Material.Builder(22836, SuSyUtility.susyId('cold_gaseous_nitrogen'))
                .gas(new FluidBuilder().temperature(140))
                .color(0x23b9ba)
                .build();

        LiquidArgonProduct = new Material.Builder(22837, SuSyUtility.susyId('liquid_argon_product'))
                .liquid(new FluidBuilder().temperature(87))
                .color(0x0ecc0e)
                .build();

        LiquidOxygenProduct = new Material.Builder(22838, SuSyUtility.susyId('liquid_oxygen_product'))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x459fcc)
                .build();

        LiquidNitrogenProduct = new Material.Builder(22839, SuSyUtility.susyId('liquid_nitrogen_product'))
                .liquid(new FluidBuilder().temperature(77))
                .color(0x0b9a9c)
                .build();

        LiquidDeoxygenatedArgon = new Material.Builder(22840, SuSyUtility.susyId('liquid_deoxygenated_argon'))
                .liquid(new FluidBuilder().temperature(87))
                .color(0x3de03d)
                .build();

        LiquidWasteNitrogen = new Material.Builder(22841, SuSyUtility.susyId('liquid_waste_nitrogen'))
                .liquid(new FluidBuilder().temperature(77))
                .color(0x379394)
                .build();

        PartiallyLiquefiedArgon = new Material.Builder(22842, SuSyUtility.susyId('partially_liquefied_argon'))
                .liquid(new FluidBuilder().temperature(120))
                .color(0x56bf56)
                .build();

        SupercriticalCarbonDioxide = new Material.Builder(22843, SuSyUtility.susyId('supercritical_carbon_dioxide'))
                .liquid(new FluidBuilder().temperature(373))
                .components(CarbonDioxide)
                .colorAverage()
                .build();

        ColdAmmoniacalArgonHydrogenMixture = new Material.Builder(22844, SuSyUtility.susyId('cold_ammoniacal_argon_hydrogen_mixture'))
                .gas(new FluidBuilder().temperature(220))
                .components(Argon, Hydrogen, Ammonia)
                .colorAverage()
                .build()
                .setFormula("(Ar)(NH3)(H)", true)

        ColdArgonHydrogenMixture = new Material.Builder(22845, SuSyUtility.susyId('cold_argon_hydrogen_mixture'))
                .gas(new FluidBuilder().temperature(220))
                .components(Argon, Hydrogen)
                .color(0x20a591)
                .build()
                .setFormula("(Ar)(H)", true)

        PartiallyLiquefiedArgonHydrogenMixture = new Material.Builder(22846, SuSyUtility.susyId('partially_liquefied_argon_hydrogen_mixture'))
                .liquid(new FluidBuilder().temperature(73))
                .components(Argon, Hydrogen)
                .color(0x20aa91)
                .build()
                .setFormula("(Ar)(H)", true)
    }
}