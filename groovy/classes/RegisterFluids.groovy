import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.Materials.SodiumBicarbonate;
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
        public static Material FourDichlorohydrazobenzene;
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
                        .dust()
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

                FourDichlorohydrazobenzene = new Material.Builder(32016, 'four_dichlorohydrazobenzene')
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

                CaprolactamOxime = new Material.Builder(32021, 'cyclohexanone_oxime')
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

                generateLiquidFromGas(Hydrogen, 10100, 21);

                generateLiquidFromGas(Helium, 10101, 5);

                generateLiquidFromGas(Neon, 10102, 27);

                generateLiquidFromGas(Argon, 10103, 88);

                generateLiquidFromGas(Krypton, 10104, 120);

                generateLiquidFromGas(Xenon, 10105, 165);

                generateLiquidFromGas(Nitrogen, 10106, 77);

                generateThermoRefrigerant(Ammonia, 10200);

                generateThermoRefrigerant(Propane, 10204);

                generateThermoRefrigerant(CarbonDioxide, 10208);

                generateCoolant(Water, 10300);

                //generateCoolant(EthyleneGlycol, 10305);

                //generateCoolant(Brine, 10310);

                generateHotGas(Air, 10311);

                generateHotGas(Nitrogen, 10312);

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

                new Material.Builder(11036, 'four_dichlorohydrazobenzene_solution')
                        .fluid()
                        .components(Toluene, 1, FourDichlorohydrazobenzene, 1)
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

                new Material.Builder(11062, 'saltpeter_solution')
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

                log.infoMC("Finished registering fluids")
        }
}