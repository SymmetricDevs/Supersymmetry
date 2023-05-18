import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//IDs 10000-20000 RESERVED FOR FLUIDS

class RegisterFluids {

        public static Material PotassiumBisulfate;
        public static Material SodiumBicarbonate;
        public static Material NMethylIIPyrrolidone;
        public static Material FourNitrochlorobenzene;
        public static Material FourNitroaniline;
        public static Material TwoTwoDichlorohydrazobenzene;
        public static Material ParaPhenylenediamine;
        public static Material SodiumPhenoxide;
        public static Material PhthaloylDichloride;
        public static Material Dichloroethane;
        public static Material Dimethylacetamide;
        public static Material CaprolactamOxime;
        public static Material TNT;
        public static Material AmmoniumNitrate;
        public static Material SodiumNitrate;
        public static Material Polystyrene;
        public static Material OneTwoDichlorobenzene;
        public static Material CalciumHydroxide;
        public static Material PotassiumHydroxide;
        public static Material PotassiumCarbonate;
        public static Material SodiumSilicate;
        public static Material SodiumAluminate;
        public static Material AmmoniumSulfate;
        public static Material SodiumFluoride;
        public static Material PotassiumFluoride;
        public static Material PotassiumTetrafluoroborate;
        public static Material SodiumBromide;

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

        public static void registerSolubles() {
                CalciumHydroxide = new Material.Builder(32033, 'calcium_hydroxide')
                        .dust()
                        .components(Calcium, 1, Oxygen, 2, Hydrogen, 2)
                        .colorAverage()
                        .build();

                CalciumHydroxide.setFormula("Ca(OH)2", true)

                PotassiumHydroxide = new Material.Builder(32034, 'potassium_hydroxide')
                        .dust()
                        .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                        .colorAverage()
                        .build();

                PotassiumCarbonate =  new Material.Builder(32035, 'potassium_carbonate')
                        .dust()
                        .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                        .colorAverage()
                        .build();

                SodiumSilicate =  new Material.Builder(32036, 'sodium_silicate')
                        .dust()
                        .components(Sodium, 2, Silicon, 1, Oxygen, 3)
                        .colorAverage()
                        .build();

                SodiumAluminate =  new Material.Builder(32037, 'sodium_aluminate')
                        .dust()
                        .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                        .colorAverage()
                        .build();

                PotassiumBisulfate = new Material.Builder(32005, 'potassium_bisulfate')
                        .dust().fluid()
                        .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 4)
                        .colorAverage()
                        .build();

                SodiumBicarbonate = new Material.Builder(32009, 'sodium_bicarbonate')
                        .dust()
                        .components(Sodium, 1, Hydrogen, 1, Carbon, 1, Oxygen, 3)
                        .colorAverage()
                        .build();

                AmmoniumNitrate = new Material.Builder(32011, 'ammonium_nitrate')
                        .dust()
                        .components(Nitrogen, 2, Oxygen, 3, Hydrogen, 4)
                        .colorAverage()
                        .build();

                AmmoniumNitrate.setFormula("NH4NO3", true);

                FourNitrochlorobenzene = new Material.Builder(32013, 'four_nitrochlorobenzene')
                        .dust()
                        .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                        .colorAverage()
                        .build();

                FourNitroaniline = new Material.Builder(32014, 'four_nitroaniline')
                        .dust()
                        .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                        .colorAverage()
                        .build();

                ParaPhenylenediamine = new Material.Builder(32015, 'para_phenylenediamine')
                        .dust()
                        .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                        .colorAverage()
                        .build();

                TwoTwoDichlorohydrazobenzene = new Material.Builder(32016, 'two_two_dichlorohydrazobenzene')
                        .dust()
                        .components(Carbon, 12, Hydrogen, 10, Chlorine, 2, Nitrogen, 2)
                        .colorAverage()
                        .build();

                SodiumPhenoxide = new Material.Builder(32019, 'sodium_phenoxide')
                        .dust()
                        .components(Carbon, 6, Hydrogen, 5, Sodium, 1, Oxygen, 1)
                        .colorAverage()
                        .build();

                PhthaloylDichloride = new Material.Builder(32020, 'phthaloyl_dichloride')
                        .dust()
                        .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                        .colorAverage()
                        .build();

                CaprolactamOxime = new Material.Builder(32021, 'caprolactam_oxime')
                        .dust()
                        .components(Carbon, 6, Hydrogen, 11, Nitrogen, 1, Oxygen, 1)
                        .colorAverage()
                        .build();

                AmmoniumSulfate = new Material.Builder(32022, 'ammonium_sulfate')
                        .dust()
                        .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                        .colorAverage()
                        .build();

                TNT = new Material.Builder(32024, 'tnt')
                        .dust()
                        .components(Carbon, 7, Hydrogen, 5, Nitrogen, 3, Oxygen, 6)
                        .color(0xacb38d)
                        .build();

                SodiumNitrate = new Material.Builder(32026, 'sodium_nitrate')
                        .dust()
                        .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                        .colorAverage()
                        .build();

                Polystyrene = new Material.Builder(32028, 'polystyrene')
                        .dust()
                        .components(Carbon, 8, Hydrogen, 8)
                        .color(0xa2a389)
                        .build();

                OneTwoDichlorobenzene = new Material.Builder(32029, 'one_two_dichlorobenzene')
                        .dust()
                        .components(Carbon, 6, Hydrogen, 4, Chlorine, 2)
                        .colorAverage()
                        .build();

                SodiumFluoride = new Material.Builder(32046, 'sodium_fluoride')
                        .fluid().dust()
                        .components(Sodium, 1, Fluorine, 1)
                        .colorAverage()
                        .build();

                PotassiumFluoride = new Material.Builder(32048, 'potassium_fluoride')
                        .fluid().dust()
                        .components(Potassium, 1, Fluorine, 1)
                        .colorAverage()
                        .build();
                        
                PotassiumTetrafluoroborate = new Material.Builder(32050, 'potassium_tetrafluoroborate')
                        .fluid().dust()
                        .components(Potassium, 1, Boron, 1, Fluorine, 4)
                        .color(0x8fb5a3)
                        .build();

                SodiumBromide = new Material.Builder(32053, 'sodium_bromide')
                        .dust()
                        .components(Sodium, 1, Bromine, 1)
                        .colorAverage()
                        .build()
        }

        public static void init() {

                log.infoMC("Registering fluids")

                registerSolubles();

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

                Material EarthGreenhouseGas = new Material.Builder(10400, "greenhouse_gases")
                        .fluid(FluidTypes.GAS)
                        .color(0x95cade)
                        .build();

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

                new Material.Builder(11000, "ammonium_chloride_solution")
                        .fluid()
                        .components(Water, 1, AmmoniumChloride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11001, "crude_styrene")
                        .fluid()
                        .colorAverage()
                        .build();

                new Material.Builder(11002, "hydrogen_chloride")
                        .fluid(FluidTypes.GAS)
                        .components(Hydrogen, 1, Chlorine, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11003, "hydrogen_fluoride")
                        .fluid(FluidTypes.GAS)
                        .components(Hydrogen, 1, Fluorine, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11004, "potassium_chloride_solution")
                        .fluid()
                        .color(0x3b5eeb)
                        .components(Water, 1, RockSalt, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11005, "potassium_bisulfate_solution")
                        .fluid()
                        .components(Water, 1, PotassiumBisulfate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11006, "sodium_bisulfate_solution")
                        .fluid()
                        .components(Water, 1, SodiumBisulfate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11007, "chlorinated_methane_mixture")
                        .fluid(FluidTypes.GAS)
                        .color(0x8327d9)
                        .build();

                new Material.Builder(11008, "chlorinated_chloromethane_mixture")
                        .fluid(FluidTypes.GAS)
                        .color(0x6124bd)
                        .build();

                new Material.Builder(11009, "chlorinated_dichloromethane_mixture")
                        .fluid(FluidTypes.GAS)
                        .color(0x4922a3)
                        .build();

                new Material.Builder(11010, "chloromethane_solution")
                        .fluid()
                        .components(Water, 1, Chloromethane, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11011, "calcium_chloride_solution")
                        .fluid()
                        .components(Water, 1, CalciumChloride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11012, "soda_ash_solution")
                        .fluid()
                        .components(Water, 1, SodaAsh, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11013, "diluted_saltwater")
                        .fluid()
                        .components(Water, 2, Salt, 1)
                        .color(0x3d61b8)
                        .build();

                new Material.Builder(11014, "sodium_bicarbonate_solution")
                        .fluid()
                        .components(Water, 1, SodiumBicarbonate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11015, "acidic_chlorodifluoromethane")
                        .fluid(FluidTypes.GAS)
                        .color(0xbd97c7)
                        .build();

                new Material.Builder(11016, "acidic_tetrafluoroethylene")
                        .fluid(FluidTypes.GAS)
                        .color(0x726678)
                        .build();

                new Material.Builder(11017, "trinitromethane_solution")
                        .fluid()
                        .color(0x333c52)
                        .build();

                new Material.Builder(11018, "tetranitromethane_solution")
                        .fluid()
                        .color(0x373352)
                        .build();

                new Material.Builder(11019, "impure_dimethyldichlorosilane")
                        .fluid()
                        .color(0x291e38)
                        .build();

                new Material.Builder(11020, "sodium_hydroxide_solution")
                        .fluid()
                        .components(Water, 1, SodiumHydroxide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11021, "chlorinated_glycerol")
                        .fluid()
                        .components(Carbon, 3, Hydrogen, 6, Oxygen, 1, Chlorine, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(11022, "epichlorohydrin_solution")
                        .fluid()
                        .color(0x9c6241)
                        .build();

                new Material.Builder(11023, "allyl_alcohol_mix")
                        .fluid()
                        .color(0xbede9b)
                        .build();

                new Material.Builder(11024, "dilute_epichlorohydrin")
                        .fluid()
                        .color(0x91664d)
                        .build();

                new Material.Builder(11025, "isobutane")
                        .fluid(FluidTypes.GAS)
                        .components(Carbon, 4, Hydrogen, 10)
                        .color(0x8a7566)
                        .build();

                new Material.Builder(11026, "isobutylene")
                        .fluid(FluidTypes.GAS)
                        .components(Carbon, 4, Hydrogen, 8)
                        .color(0x917d61)
                        .build();

                new Material.Builder(11027, "cyclohexane")
                        .fluid()
                        .components(Carbon, 6, Hydrogen, 12)
                        .color(0x66553c)
                        .build();

                new Material.Builder(11028, "iron_iii_chloride_solution")
                        .fluid()
                        .components(Water, 1, Iron3Chloride, 1)
                        .colorAverage()
                        .build();

                Material NMethylIIPyrrolidone = new Material.Builder(11029, 'n_methyl_ii_pyrrolidone')
                        .fluid()
                        .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11030, 'salty_n_methyl_ii_pyrrolidone')
                        .fluid()
                        .components(NMethylIIPyrrolidone, 1, Salt, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11031, 'methyl_acetate_solution')
                        .fluid()
                        .components(Water, 1, SulfuricAcid, 1, MethylAcetate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11032, 'two_nitrochlorobenzene_solution')
                        .fluid()
                        .components(Toluene, 1, Nitrochlorobenzene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11033, 'four_nitrochlorobenzene_solution')
                        .fluid()
                        .components(Toluene, 1, FourNitrochlorobenzene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11034, 'four_nitroaniline_solution')
                        .fluid()
                        .components(Toluene, 1, FourNitroaniline, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11035, 'para_phenylenediamine_solution')
                        .fluid()
                        .components(Toluene, 1, ParaPhenylenediamine, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11036, 'two_two_dichlorohydrazobenzene_solution')
                        .fluid()
                        .components(Toluene, 1, TwoTwoDichlorohydrazobenzene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11037, 'dichlorobenzidine_solution')
                        .fluid()
                        .components(Toluene, 1, Dichlorobenzidine, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11038, 'xylene')
                        .fluid()
                        .components(Carbon, 8, Hydrogen, 10)
                        .color(0x2e281f)
                        .build();

                new Material.Builder(11039, 'phosgene')
                        .fluid()
                        .components(Carbon, 1, Oxygen, 1, Chlorine, 2)
                        .colorAverage()
                        .build();

                Material Dichloroethane = new Material.Builder(11040, 'dichloroethane')
                        .fluid()
                        .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(11041, 'phthaloyl_dichloride_solution')
                        .fluid()
                        .components(Dichloroethane, 1, Water, 1, PhthaloylDichloride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11042, 'sodium_phenoxide_solution')
                        .fluid()
                        .components(Water, 1, SodiumPhenoxide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11043, 'diphenyl_isophthalate_solution')
                        .fluid()
                        .components(Water, 2, Dichloroethane, 1, DiphenylIsophtalate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11044, 'diaminobenzidine_solution')
                        .fluid()
                        .components(Water, 1, Toluene, 1, Diaminobenzidine, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11045, 'pbi_polymerization_mix')
                        .fluid()
                        .color(0x40342b)
                        .fluidTemp(450)
                        .build();

                new Material.Builder(11046, 'pbi_pre_polymer_foam')
                        .fluid()
                        .color(0x332d28)
                        .fluidTemp(450)
                        .build();

                new Material.Builder(11047, 'impure_pbi_solution')
                        .fluid()
                        .color(0x292623)
                        .fluidTemp(450)
                        .build();

                Material Dimethylacetamide = new Material.Builder(11048, 'dimethylacetamide')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11049, 'dimethylacetamide_solution')
                        .fluid()
                        .components(Water, 1, Dimethylacetamide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11050, 'pbi_solution')
                        .fluid()
                        .components(Dimethylacetamide, 1, Polybenzimidazole, 7)
                        .color(0x171410)
                        .build();

                new Material.Builder(11051, 'pbi_waste')
                        .fluid()
                        .color(0x202226)
                        .build();

                new Material.Builder(11052, 'hydroxylamine')
                        .fluid()
                        .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                        .colorAverage()
                        .build();

                Material Cyclohexanone = new Material.Builder(11053, 'cyclohexanone')
                        .fluid()
                        .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                        .color(0x2b1e11)
                        .build();

                new Material.Builder(11054, 'diluted_cyclohexanone')
                        .fluid()
                        .components(Water, 1, Cyclohexanone, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11055, 'caprolactam_oxime_solution')
                        .fluid()
                        .components(SulfuricAcid, 1, CaprolactamOxime, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11056, 'bisphenola_diglycidyl_ether')
                        .fluid()
                        .components(Carbon, 21, Hydrogen, 24, Oxygen, 4)
                        .colorAverage()
                        .build();

                new Material.Builder(11057, 'impure_epoxy_resin')
                        .fluid()
                        .components(SaltWater, 1, Epoxy, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11058, 'uncured_epoxy_resin')
                        .fluid()
                        .components(Epoxy, 1)
                        .colorAverage()
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(11059, 'tnt_solution')
                        .fluid()
                        .components(TNT, 1, DilutedSulfuricAcid, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11060, 'ammonium_nitrate_solution')
                        .fluid()
                        .components(Water, 1, AmmoniumNitrate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11061, 'nitrate_solution')
                        .fluid()
                        .components(Water, 2, AmmoniumChloride, 1, Saltpeter, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11062, 'dilute_saltpeter_solution')
                        .fluid()
                        .components(Water, 2, Saltpeter, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11063, 'sodium_nitrate_solution')
                        .fluid()
                        .components(Water, 1, SodiumNitrate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11064, 'vinyl_chloride_solution')
                        .fluid()
                        .components(Water, 1, VinylChloride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11065, 'polyvinyl_chloride_solution')
                        .fluid()
                        .components(Water, 1, PolyvinylChloride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11066, 'styrene_solution')
                        .fluid()
                        .components(Water, 1, Styrene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11067, 'polystyrene_solution')
                        .fluid()
                        .components(Water, 1, Polystyrene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11068, 'vinyl_acetate_solution')
                        .fluid()
                        .components(Water, 1, VinylAcetate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11069, 'polyvinyl_acetate_solution')
                        .fluid()
                        .components(Water, 1, PolyvinylAcetate, 1)
                        .colorAverage()
                        .build();

                Material Bleach = new Material.Builder(11070, 'bleach')
                        .fluid()
                        .components(Sodium, 1, Chlorine, 1, Oxygen, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11071, 'impure_bleach')
                        .fluid()
                        .components(Water, 3, Bleach, 1, Salt, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11072, 'one_four_dichlorobenzene_solution')
                        .fluid()
                        .components(Toluene, 1, Dichlorobenzene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11073, 'one_two_dichlorobenzene_solution')
                        .fluid()
                        .components(Toluene, 1, OneTwoDichlorobenzene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11074, 'dry_ethanol')
                        .fluid()
                        .components(Ethanol, 1)
                        .color(0xeb6b34)
                        .build();

                new Material.Builder(11075, 'styrene_butadiene_solution')
                        .fluid()
                        .components(Styrene, 1, Butadiene, 1, Ethanol, 1)
                        .colorAverage()
                        .build();

                Material DiethylEther = new Material.Builder(11076, 'diethyl_ether')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                        .colorAverage()
                        .build();

                DiethylEther.setFormula("(C2H5)2O", true);

                new Material.Builder(11077, 'diethyl_ether_solution')
                        .fluid()
                        .components(Water, 1, SulfuricAcid, 1, DiethylEther, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11078, 'lithium_solution')
                        .fluid()
                        .components(Lithium, 2, DiethylEther, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11079, 'hydrogen_bromide')
                        .fluid()
                        .components(Hydrogen, 1, Bromine, 1)
                        .colorAverage()
                        .build();

                Material Bromobutane = new Material.Builder(11080, 'bromobutane')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11081, 'diluted_bromobutane')
                        .fluid()
                        .components(Water, 1, Bromobutane, 1)
                        .colorAverage()
                        .build();

                Material Butyllithium = new Material.Builder(11082, 'butyllithium')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11083, 'diluted_butyllithium')
                        .fluid()
                        .components(Water, 1, Butyllithium, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11084, 'polymerized_styrene_butadiene_solution')
                        .fluid()
                        .color(0x332e2c)
                        .color(0x3d2509)
                        .build();

                new Material.Builder(11085, "dilute_calcium_chloride_solution")
                        .fluid()
                        .components(Water, 2, CalciumChloride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11086, "dilute_rock_salt_solution")
                        .fluid()
                        .components(Water, 2, RockSalt, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11087, "dilute_potassium_carbonate_solution")
                        .fluid()
                        .components(Water, 3, PotassiumCarbonate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11088, "potassium_hydroxide_solution")
                        .fluid()
                        .components(Water, 1, PotassiumHydroxide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11089, "calcium_hydroxide_solution")
                        .fluid()
                        .components(Water, 1, CalciumHydroxide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11090, "sodium_silicate_solution")
                        .fluid()
                        .components(Water, 4, SodiumSilicate, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11091, "raw_molecular_sieve")
                        .fluid()
                        .color(0x8c94a8)
                        .build();

                new Material.Builder(11092, "dry_carbon_monoxide")
                        .fluid(FluidTypes.GAS)
                        .components(CarbonMonoxide, 1)
                        .color(0x202329)
                        .build();

                Material MethylFormate = new Material.Builder(11093, "methyl_formate")
                        .fluid()
                        .components(Carbon, 2, Hydrogen, 4, Oxygen, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(11094, "methyl_formate_solution")
                        .fluid(FluidTypes.GAS)
                        .components(Water, 1, MethylFormate, 1, SodiumHydroxide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11095, "acetylene")
                        .fluid(FluidTypes.GAS)
                        .components(Carbon, 2, Hydrogen, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(11096, "ammonia_solution")
                        .fluid()
                        .components(Water, 1, Ammonia, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11097, 'diluted_dichloroethane')
                        .fluid()
                        .components(Water, 3, Dichloroethane, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11098, "formaldehyde")
                        .fluid(FluidTypes.GAS)
                        .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11099, 'methylamine_mix')
                        .fluid()
                        .color(0x6b4ea6)
                        .build();

                Material Methylamine = new Material.Builder(11100, 'methylamine')
                        .fluid()
                        .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                        .color(0x794c91)
                        .build();

                Methylamine.setFormula("CH3NH2", true)

                new Material.Builder(11101, 'trimethylamine')
                        .fluid()
                        .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                        .color(0x4c2461)
                        .build();

                new Material.Builder(11102, 'butynediol')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(11103, 'butanediol')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(11104, 'gamma_butyrolactone')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                        .color(0x4242f5)
                        .build();

                new Material.Builder(11105, 'diluted_methyl_ii_pyrrolidone')
                        .fluid()
                        .components(Water, 1, NMethylIIPyrrolidone, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11106, 'dimethyldichlorosilane_emulsion')
                        .fluid()
                        .color(0x542a4c)
                        .build();

                new Material.Builder(11107, 'tetrafluoroethylene_emulsion')
                        .fluid()
                        .color(0x3b2e38)
                        .build();

                new Material.Builder(11109, 'dichloromethane')
                        .fluid()
                        .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                        .colorAverage()
                        .build();

                Material CarbonTetrachloride = new Material.Builder(11110, 'carbon_tetrachloride')
                        .fluid()
                        .components(Carbon, 1, Chlorine, 4)
                        .colorAverage()
                        .build();

                new Material.Builder(11111, 'phthalic_acid_solution')
                        .fluid()
                        .components(Dichloroethane, 1, PhthalicAcid, 1)
                        .color(0xdbbbbd)
                        .build();

                new Material.Builder(11112, 'butanol')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 7, Oxygen, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11113, 'saltpeter_solution')
                        .fluid()
                        .components(Water, 1, Saltpeter, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11114, 'salty_saltpeter_solution')
                        .fluid()
                        .components(SaltWater, 1, Saltpeter, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11115, 'polytetrafluoroethylene_solution')
                        .fluid()
                        .components(Water, 1, Polytetrafluoroethylene, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(11116, 'mixed_nitrochlorobenzene_solution')
                        .fluid()
                        .color(0xc18c18)
                        .build();

                new Material.Builder(11117, 'mixed_dichlorobenzene_solution')
                        .fluid()
                        .color(0xFF7F7F)
                        .build();

                new Material.Builder(11118, 'novolacs')
                        .fluid()
                        .color(0xbfa26f)
                        .build();

                new Material.Builder(11119, 'silicon_tetrachloride')
                        .fluid()
                        .components(Silicon, 1, Chlorine, 4)
                        .color(0x63827f)
                        .build();

                new Material.Builder(11120, 'purified_silicon_tetrachloride')
                        .fluid()
                        .components(Silicon, 1, Chlorine, 4)
                        .color(0x7fa3a0)
                        .build();

                new Material.Builder(11121, 'ethanolamine')
                        .fluid()
                        .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                        .color(0x56a6e3)
                        .build();

                new Material.Builder(11122, 'diethanolamine')
                        .fluid()
                        .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1, Oxygen, 2)
                        .color(0x4296d6)
                        .build();

                new Material.Builder(11123, 'triethanolamine')
                        .fluid()
                        .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1, Oxygen, 3)
                        .color(0x2e86c9)
                        .build();

                new Material.Builder(11124, 'ethylene_glycol')
                        .fluid()
                        .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                        .color(0x2e86c9)
                        .build();

                new Material.Builder(11125, 'carbon_disulfide')
                        .fluid()
                        .components(Carbon, 1, Sulfur, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(12000, 'flue_gas')
                        .fluid(FluidTypes.GAS)
                        .color(0x484a48)
                        .fluidTemp(1000)
                        .build();

                new Material.Builder(12001, 'exhaust_steam')
                        .fluid(FluidTypes.GAS)
                        .color(0xc4c4c4)
                        .fluidTemp(1000)
                        .build();

                new Material.Builder(12002, 'smoke_bomb_mix')
                        .fluid(FluidTypes.GAS)
                        .color(0x515443)
                        .build();

                new Material.Builder(12003, "sulfurous_water")
                        .fluid()
                        .color(0x592893)
                        .build();

                new Material.Builder(12004, "oxide_water")
                        .fluid()
                        .color(0x538020)
                        .build();

                new Material.Builder(12005, "mineralized_water")
                        .fluid()
                        .color(0x129077)
                        .build();

                new Material.Builder(12006, "silicate_water")
                        .fluid()
                        .color(0x651526)
                        .build();

                new Material.Builder(12007, "graphite_water")
                        .fluid()
                        .color(0x793000)
                        .build();

                new Material.Builder(12008, "phosphate_water")
                        .fluid()
                        .color(0x540032)
                        .build();

                new Material.Builder(12009, "precious_runoff")
                        .fluid()
                        .color(0x129077)
                        .build();

                new Material.Builder(12010, "radioactive_runoff")
                        .fluid()
                        .color(0x129077)
                        .build();

                new Material.Builder(12011, "silicon_solution")
                        .fluid()
                        .color(0x1f1c1c)
                        .build();

                new Material.Builder(12012, "calcium_carbonate_solution")
                        .fluid()
                        .color(0x8c8981)
                        .build();

                new Material.Builder(12013, "bentonite_clay_solution")
                        .fluid()
                        .color(0xa2bdb5)
                        .build();

                new Material.Builder(12014, "sugary_water")
                        .fluid()
                        .color(0x8fbf9b)
                        .build();

                new Material.Builder(12015, "clarified_sugary_water")
                        .fluid()
                        .color(0xa7d6b3)
                        .build();

                new Material.Builder(12016, "diluted_oil_light")
                        .fluid()
                        .color(0x2d2f3b)
                        .build();

                new Material.Builder(12017, "diluted_oil")
                        .fluid()
                        .color(0x2d2f3b)
                        .build();

                new Material.Builder(12018, "diluted_oil_heavy")
                        .fluid()
                        .color(0x2d2f3b)
                        .build();

                new Material.Builder(12019, "desalted_oil_light")
                        .fluid()
                        .color(0x000000)
                        .build();

                new Material.Builder(12020, "desalted_oil")
                        .fluid()
                        .color(0x000000)
                        .build();

                new Material.Builder(12021, "desalted_oil_heavy")
                        .fluid()
                        .color(0x000000)
                        .build();

                new Material.Builder(12022, "brine")
                        .fluid()
                        .color(0xd1d08e)
                        .build();

                new Material.Builder(12023, "oily_brine")
                        .fluid()
                        .color(0x69684e)
                        .build();

                new Material.Builder(12024, "sulfuric_oil_residue")
                        .fluid()
                        .color(0x59572b)
                        .build();

                new Material.Builder(12026, "high_pressure_water")
                        .fluid()
                        .colorAverage()
                        .components(Water, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .build();

                new Material.Builder(12027, "dissolved_bitumen")
                        .fluid()
                        .color(0x1e2021)
                        .build();

                new Material.Builder(12028, "sulfuric_fuel_oil")
                        .fluid()
                        .color(0x858135)
                        .build();

                new Material.Builder(12029, "treated_sulfuric_fuel_oil")
                        .fluid()
                        .color(0x9e9a4f)
                        .build();

                new Material.Builder(12030, "crude_natural_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xc9c9b9)
                        .build();

                new Material.Builder(12031, "sulfuric_natural_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xe3e3d1)
                        .build();

                new Material.Builder(12032, "treated_sulfuric_natural_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xf7f7eb)
                        .build();

                new Material.Builder(12033, "treated_sulfuric_refinery_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xe3e3d8)
                        .build();

                new Material.Builder(12034, "sour_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xebeba4)
                        .build();

                new Material.Builder(12035, "sulfuric_diesel")
                        .fluid()
                        .color(0xa8a232)
                        .build();

                new Material.Builder(12036, "treated_sulfuric_diesel")
                        .fluid()
                        .color(0xc2bb42)
                        .build();

                new Material.Builder(12037, "sulfuric_kerosene")
                        .fluid()
                        .color(0xbfb82a)
                        .build();

                new Material.Builder(12038, "treated_sulfuric_kerosene")
                        .fluid()
                        .color(0xd6cf3a)
                        .build();

                new Material.Builder(12039, "kerosene")
                        .fluid()
                        .color(0xd6cf3a)
                        .build();

                new Material.Builder(12040, "sulfuric_gasoline")
                        .fluid()
                        .color(0xe8df23)
                        .build();

                new Material.Builder(12041, "treated_sulfuric_gasoline")
                        .fluid()
                        .color(0xf7ef40)
                        .build();

                new Material.Builder(12042, "fuel_oil")
                        .fluid()
                        .color(0x9e9a4f)
                        .build();

                new Material.Builder(12043, "lubricating_oil")
                        .fluid()
                        .color(0x858146)
                        .build();

                new Material.Builder(12044, "slack_wax")
                        .fluid()
                        .color(0x7d7b59)
                        .build();

                new Material.Builder(12045, "resin")
                        .fluid()
                        .color(0xb5803a)
                        .build();

                new Material.Builder(12046, 'ethylene_oxide')
                        .fluid(FluidTypes.GAS)
                        .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12047, 'ethanolamine_mix')
                        .fluid()
                        .color(0x3e86bd)
                        .build();

                new Material.Builder(12048, 'rich_amine')
                        .fluid()
                        .color(0x3ea8bd)
                        .build();

                new Material.Builder(12049, 'uncatalyzed_sulfurous_gases')
                        .fluid(FluidTypes.GAS)
                        .color(0xd6d372)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12050, 'pentane')
                        .fluid()
                        .components(Carbon, 5, Hydrogen, 12)
                        .color(0xe8e7be)
                        .build();

                new Material.Builder(12051, 'hexane')
                        .fluid()
                        .components(Carbon, 6, Hydrogen, 14)
                        .color(0xcfceb6)
                        .build();

                new Material.Builder(12052, 'naphtha_reformate')
                        .fluid()
                        .color(0xf2f2a0)
                        .fluidTemp(773)
                        .build();

                Material Furfural = new Material.Builder(12053, 'furfural')
                        .fluid()
                        .components(Carbon, 5, Hydrogen, 4, Oxygen, 2)
                        .colorAverage()
                        .build();

                new Material.Builder(12054, 'btex_extract')
                        .fluid()
                        .color(0xa8a87d)
                        .build();

                new Material.Builder(12055, 'btex')
                        .fluid()
                        .color(0x828267)
                        .build();

                new Material.Builder(12056, 'xylene')
                        .fluid()
                        .components(Carbon, 8, Hydrogen, 10)
                        .color(0x828271)
                        .build();

                new Material.Builder(12057, "lightly_steamcracked_kerosene")
                        .fluid()
                        .color(0xe3dd59)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12058, "severely_steamcracked_kerosene")
                        .fluid()
                        .color(0xf2ed83)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12059, "lightly_hydrocracked_kerosene")
                        .fluid()
                        .color(0xc4bf51)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12060, "severely_hydrocracked_kerosene")
                        .fluid()
                        .color(0xbab65f)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12061, "lightly_steamcracked_gasoline")
                        .fluid()
                        .color(0xebe34d)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12062, "severely_steamcracked_gasoline")
                        .fluid()
                        .color(0xf5ed62)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12063, "lightly_hydrocracked_gasoline")
                        .fluid()
                        .color(0xccc43f)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12064, "severely_hydrocracked_gasoline")
                        .fluid()
                        .color(0xbdb648)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12065, "lightly_steamcracked_kerosene_mix")
                        .fluid()
                        .color(0xe3dd59)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12066, "severely_steamcracked_kerosene_mix")
                        .fluid()
                        .color(0xf2ed83)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12067, "lightly_hydrocracked_kerosene_mix")
                        .fluid()
                        .color(0xc4bf51)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12068, "severely_hydrocracked_kerosene_mix")
                        .fluid()
                        .color(0xbab65f)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12069, "lightly_steamcracked_gasoline_mix")
                        .fluid()
                        .color(0xebe34d)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12070, "severely_steamcracked_gasoline_mix")
                        .fluid()
                        .color(0xf5ed62)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12071, "lightly_hydrocracked_gasoline_mix")
                        .fluid()
                        .color(0xccc43f)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12072, "severely_hydrocracked_gasoline_mix")
                        .fluid()
                        .color(0xbdb648)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12073, "lightly_steamcracked_naphtha_mix")
                        .fluid()
                        .color(0xdbd556)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12074, "severely_steamcracked_naphtha_mix")
                        .fluid()
                        .color(0xe3dd68)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12075, "lightly_hydrocracked_naphtha_mix")
                        .fluid()
                        .color(0xc4be49)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12076, "severely_hydrocracked_naphtha_mix")
                        .fluid()
                        .color(0xb5b050)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12077, "upgraded_lubricating_oil_mix")
                        .fluid()
                        .color(0x948f43)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12078, "upgraded_fuel_oil_mix")
                        .fluid()
                        .color(0x918d33)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12079, "upgraded_diesel_mix")
                        .fluid()
                        .color(0xbab32f)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12080, "upgraded_kerosene_mix")
                        .fluid()
                        .color(0xe3db30)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12081, "upgraded_naphtha_mix")
                        .fluid()
                        .color(0xf0e83e)
                        .fluidTemp(773)
                        .build();

                new Material.Builder(12082, "alkylated_natural_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xe6e4c1)
                        .build();

                new Material.Builder(12083, "alkylated_refinery_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xf7f5cb)
                        .build();

                new Material.Builder(12084, "impure_sodium_aluminate_solution")
                        .fluid()
                        .color(0x5b80ba)
                        .build();

                new Material.Builder(12085, "sodium_aluminate_solution")
                        .fluid()
                        .color(0x3f71bf)
                        .build();

                new Material.Builder(12086, "red_mud")
                        .fluid()
                        .color(0x913f2d)
                        .build();

                new Material.Builder(12087, "impure_soda_ash_solution")
                        .fluid()
                        .color(0x91919b)
                        .build();

                new Material.Builder(12088, "impure_sodium_hydroxide_solution")
                        .fluid()
                        .color(0x3a4991)
                        .build();

                new Material.Builder(12089, "cryolite")
                        .fluid().dust()
                        .components(Sodium, 3, Aluminium, 1, Fluorine, 6)
                        .color(0x2497a6)
                        .build();

                new Material.Builder(12090, "sodium_fluoride_solution")
                        .fluid()
                        .components(SodiumFluoride, 1, Water, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12091, "concentrated_red_mud")
                        .fluid()
                        .color(0x824133)
                        .build();

                new Material.Builder(12092, "furfural_solution")
                        .fluid()
                        .components(Water, 3, SulfuricAcid, 1, Furfural, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12093, "syngas")
                        .fluid(FluidTypes.GAS)
                        .color(0xf2ecdc)
                        .build();

                new Material.Builder(12094, "reformed_syngas")
                        .fluid(FluidTypes.GAS)
                        .color(0xfcf3d9)
                        .fluidTemp(800)
                        .build();

                new Material.Builder(12095, "ammonia_reaction_mix")
                        .fluid(FluidTypes.GAS)
                        .color(0x38478a)
                        .fluidTemp(400)
                        .build();

                new Material.Builder(12096, "ammonia_rich_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0x345691)
                        .fluidTemp(400)
                        .build();

                new Material.Builder(12097, "ethanol_solution")
                        .fluid()
                        .components(Ethanol, 1, PhosphoricAcid, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12098, "graphite_mix")
                        .color(0x080808)
                        .build();

                new Material.Builder(12099, "cresol")
                        .fluid()
                        .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                        .color(0x827863)
                        .build();

                new Material.Builder(12100, "guaiacol")
                        .fluid()
                        .components(Carbon, 7, Hydrogen, 8, Oxygen, 2)
                        .color(0x693834)
                        .build();

                new Material.Builder(12101, "xylenol")
                        .fluid()
                        .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                        .color(0x693834)
                        .build();

                new Material.Builder(12102, "creosol")
                        .fluid()
                        .components(Carbon, 8, Hydrogen, 10, Oxygen, 2)
                        .color(0x473339)
                        .build();

                new Material.Builder(12103, "anthracene")
                        .fluid()
                        .components(Carbon, 14, Hydrogen, 10)
                        .color(0x000000)
                        .build();

                new Material.Builder(12104, "mash")
                        .fluid()
                        .color(0x9e8660)
                        .build();

                new Material.Builder(12105, "weed_killer")
                        .fluid()
                        .color(0xade677)
                        .build();

                new Material.Builder(12106, "pesticide")
                        .fluid()
                        .color(0xc0c77d)
                        .build();

                new Material.Builder(12107, "earth_like_air")
                        .fluid(FluidTypes.GAS)
                        .color(0x8fbfe3)
                        .build();

                new Material.Builder(12108, "grain_solution")
                        .fluid()
                        .color(0xc2cc9d)
                        .build();

                new Material.Builder(12109, "yeast_solution")
                        .fluid()
                        .color(0xe6e3aa)
                        .build();

                new Material.Builder(12110, "impure_ethanol")
                        .fluid()
                        .color(0xbf9c77)
                        .build();
                        
                new Material.Builder(12111, "sulfuric_refinery_gas")
                        .fluid(FluidTypes.GAS)
                        .color(0xe3e3d8)
                        .build();

                new Material.Builder(12112, "treated_sulfuric_naphtha")
                        .fluid(FluidTypes.GAS)
                        .color(0xcec929)
                        .build();

                new Material.Builder(12113, "borate_liquor")
                        .fluid()
                        .color(0xacbbac)
                        .build();

                Material HeavyWater = new Material.Builder(12200, "heavy_water")
                        .fluid()
                        .components(Deuterium, 2, Oxygen, 1)
                        .color(0x2c37b0)
                        .build();

                Material HeavyHydrogenSulfide = new Material.Builder(12201, "heavy_hydrogen_sulfide")
                        .fluid()
                        .components(Deuterium, 2, Sulfur, 1)
                        .color(0xb09a2c)
                        .build();

                Material SemiHeavyHydrogenSulfide = new Material.Builder(12202, "semiheavy_hydrogen_sulfide")
                        .fluid(FluidTypes.GAS)
                        .components(Hydrogen, 1, Deuterium, 1, Sulfur, 1)
                        .color(0xc29836)
                        .build();

                Material SemiHeavyWater = new Material.Builder(12203, "semiheavy_water")
                        .fluid()
                        .components(Hydrogen, 1, Deuterium, 1, Oxygen, 1)
                        .color(0x364ec2)
                        .build();

                new Material.Builder(12204, "impure_semiheavy_water")
                        .fluid()
                        .components(Water, 1, SemiHeavyWater, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12205, "isotopically_pure_hydrogen_sulfide")
                        .fluid(FluidTypes.GAS)
                        .components(HydrogenSulfide, 1)
                        .color(0xffab66)
                        .build();

                new Material.Builder(12206, "impure_semiheavy_hydrogen_sulfide")
                        .fluid(FluidTypes.GAS)
                        .components(HydrogenSulfide, 1, SemiHeavyHydrogenSulfide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12207, "impure_heavy_hydrogen_sulfide")
                        .fluid(FluidTypes.GAS)
                        .components(HydrogenSulfide, 1, HeavyHydrogenSulfide, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12208, "sea_water")
                        .fluid()
                        .components(Water, 98, Salt, 2)
                        .color(0x3c5bc2)
                        .build();
                
                new Material.Builder(12209, "potassium_fluoride_solution")
                        .fluid()
                        .components(Water, 1, PotassiumFluoride, 1)
                        .colorAverage()
                        .build();

                new Material.Builder(12210, "tetrafluoroboric_acid")
                        .fluid()
                        .components(Water, 3, Hydrogen, 1, Boron, 1, Fluorine, 4)
                        .color(0xa4ab91)
                        .build();

                new Material.Builder(12211, "potassium_tetrafluoroborate_solution")
                        .fluid()
                        .components(Water, 7, PotassiumTetrafluoroborate, 2)
                        .color(0x8fb5a3)
                        .build();

                new Material.Builder(12212, "boron_trichloride")
                        .fluid(FluidTypes.GAS)
                        .components(Boron, 1, Chlorine, 3)
                        .colorAverage()
                        .build();

                new Material.Builder(12213, "thioarsenite_solution")
                        .fluid()
                        .components(Sodium, 3, Arsenic, 1, Sulfur, 3, Water, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(?)(Na3AsS3)(H2O)", true);

                new Material.Builder(12214, "tetrachloroantimonate_solution")
                        .fluid()
                        .components(Hydrogen, 1, Antimony, 1, Chlorine, 4, Salt, 2, Water, 14)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(NaCl)14(NaSbCl4)(H2O)22", true);

                new Material.Builder(12215, "arsine")
                        .fluid(FluidTypes.GAS)
                        .components(Arsenic, 1, Hydrogen, 3)
                        .colorAverage()
                        .build();

                new Material.Builder(12216, "sodium_bromide_solution")
                        .fluid()
                        .components(SodiumBromide, 1, Water, 1)
                        .colorAverage()
                        .build();
                
                new Material.Builder(12217, "thioarsenate_solution")
                        .fluid()
                        .components(Sodium, 3, Arsenic, 1, Sulfur, 4, Water, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(?)(Na3AsS4)(H2O)", true);

                new Material.Builder(12218, "cobaltite_leach_solution")
                        .fluid()
                        .components(Cobalt, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(Co(NO3)2)3(H3AsO4)3(H2O)2", true);
                
                new Material.Builder(12219, "arsenopyrite_leach_solution")
                        .fluid()
                        .components(Iron, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(Fe(NO3)2)3(H3AsO4)3(H2O)2", true);

                new Material.Builder(12220, "arsenous_acid")
                        .fluid()
                        .components(Hydrogen, 3, Arsenic, 1, Oxygen, 3)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build();  
                
                new Material.Builder(12221, "alkaline_arsenite_solution")
                        .fluid()
                        .components(Sodium, 3, Arsenic, 2, Oxygen, 3, Sulfur, 3)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(Na3AsO3)(Na3AsS3)(H2O)9", true);
                
                new Material.Builder(12222, "salty_arsenous_acid")
                        .fluid()
                        .components(Salt, 12, Hydrogen, 6, Arsenic, 2, Oxygen, 6)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(NaCl)12(H3AsO3)2(H2O)21", true);

                new Material.Builder(12223, "sperrylite_waste")
                        .fluid()
                        .components(Water, 3, Chlorine, 2, Cobalt, 1, Nickel, 1)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(H2O)3(Ni,Co)Cl2", true);
                
                new Material.Builder(12224, "acidic_copper_solution")
                        .fluid()
                        .components(Water, 4, Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2)
                        .flags(DISABLE_DECOMPOSITION)
                        .colorAverage()
                        .build()
                        .setFormula("(H2O)4(CuSO4)2(HNO3)2", true);

                log.infoMC("Finished registering fluids")
        }
}
