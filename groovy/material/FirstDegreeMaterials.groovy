package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*
import gregtech.api.util.GTUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

public class FirstDegreeMaterials{

    private static void generatePurifiedElement(Material material, int id, boolean generateLiquid, boolean generateIngot) {
        var color = material.materialRGB;

        if (generateLiquid & !generateIngot) {
            new Material.Builder(id, GTUtility.gregtechId("high_purity_" + material.toString()))
                    .dust().fluid()
                    .iconSet(SHINY)
                    //.fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();

        } else if(generateIngot & !generateLiquid) {
            new Material.Builder(id, GTUtility.gregtechId("high_purity_" + material.toString()))
                    .dust().ingot()
                    .iconSet(SHINY)
                    //.fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();
        } else if(generateLiquid & generateIngot) {
            new Material.Builder(id, GTUtility.gregtechId("high_purity_" + material.toString()))
                    .dust().ingot().fluid()
                    .iconSet(SHINY)
                    //.fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();
        } else {
            new Material.Builder(id, GTUtility.gregtechId("high_purity_" + material.toString()))
                    .dust()
                    .iconSet(SHINY)
                    .color(color)
                    .components(material, 1)
                    .build();
        }
    }

    public static void register() {

        log.infoMC("Registering First Degree Materials!");

        // IDs 8000-8100: Pure Elements

        generatePurifiedElement(Lithium, 8000, false, false)
        generatePurifiedElement(Beryllium, 8001, false, false)
        generatePurifiedElement(Boron, 8002, false, false)
        generatePurifiedElement(Carbon, 8003, false, false)
        generatePurifiedElement(Sodium, 8004, false, false)
        generatePurifiedElement(Magnesium, 8005, false, false)
        generatePurifiedElement(Aluminium, 8006, false, false)
        generatePurifiedElement(Silicon, 8007, true, false)

        new Material.Builder(8008, GTUtility.gregtechId("high_purity_phosphorus"))
                .ingot().fluid().dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .fluidTemp(Phosphorus.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                .color(Phosphorus.materialRGB)
                .components(Phosphorus, 1)
                .build();

        generatePurifiedElement(Sulfur, 8009, false, false)
        generatePurifiedElement(Potassium, 8010, false, false)
        generatePurifiedElement(Calcium, 8011, false, false)
        generatePurifiedElement(Scandium, 8012, false, false)
        generatePurifiedElement(Titanium, 8013, false, false)
        generatePurifiedElement(Vanadium, 8014, false, false)
        generatePurifiedElement(Chrome, 8015, true, false)
        generatePurifiedElement(Manganese, 8016, false, false)
        generatePurifiedElement(Iron, 8017, false, false)
        generatePurifiedElement(Cobalt, 8018, false, false)
        generatePurifiedElement(Nickel, 8019, false, false)
        generatePurifiedElement(Copper, 8020, false, false)
        generatePurifiedElement(Zinc, 8021, false, false)
        generatePurifiedElement(Gallium, 8022, true, false)
        generatePurifiedElement(Germanium, 8023, true, false)
        generatePurifiedElement(Arsenic, 8024, true, false)
        generatePurifiedElement(Selenium, 8025, false, false)
        generatePurifiedElement(Rubidium, 8026, false, false)
        generatePurifiedElement(Strontium, 8027, false, false)
        generatePurifiedElement(Yttrium, 8028, false, false)
        generatePurifiedElement(Zirconium, 8029, false, false)
        generatePurifiedElement(Niobium, 8030, false, false)
        generatePurifiedElement(Molybdenum, 8031, false, false)
        generatePurifiedElement(Technetium, 8032, false, false)
        generatePurifiedElement(Ruthenium, 8033, false, false)
        generatePurifiedElement(Rhodium, 8034, false, false)
        generatePurifiedElement(Palladium, 8035, false, false)
        generatePurifiedElement(Silver, 8036, false, false)
        generatePurifiedElement(Cadmium, 8037, false, false)
        generatePurifiedElement(Indium, 8038, false, false)
        generatePurifiedElement(Tin, 8039, false, false)
        generatePurifiedElement(Antimony, 8040, false, false)
        generatePurifiedElement(Tellurium, 8041, false, false)
        generatePurifiedElement(Iodine, 8042, false, false)
        generatePurifiedElement(Caesium, 8043, false, false)
        generatePurifiedElement(Barium, 8044, false, false)
        generatePurifiedElement(Lanthanum, 8045, false, false)
        generatePurifiedElement(Hafnium, 8046, false, false)
        generatePurifiedElement(Tantalum, 8047, false, false)
        generatePurifiedElement(Tungsten, 8048, false, false)
        generatePurifiedElement(Rhenium, 8049, false, false)
        generatePurifiedElement(Osmium, 8050, false, false)
        generatePurifiedElement(Iridium, 8051, false, false)
        generatePurifiedElement(Platinum, 8052, false, false)

        new Material.Builder(8053, GTUtility.gregtechId("high_purity_gold"))
                .ingot()
                .iconSet(SHINY)
                .flags(GENERATE_FOIL, GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .fluidTemp(Gold.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                .color(Gold.materialRGB)
                .components(Gold, 1)
                .build();

        generatePurifiedElement(Thallium, 8054, false, false)
        generatePurifiedElement(Lead, 8055, false, false)
        generatePurifiedElement(Bismuth, 8056, false, false)
        generatePurifiedElement(Cerium, 8057, false, false)
        generatePurifiedElement(Praseodymium, 8058, false, false)
        generatePurifiedElement(Neodymium, 8059, false, false)
        generatePurifiedElement(Samarium, 8060, false, false)
        generatePurifiedElement(Europium, 8061, false, false)
        generatePurifiedElement(Gadolinium, 8062, false, false)
        generatePurifiedElement(Terbium, 8063, false, false)
        generatePurifiedElement(Dysprosium, 8064, false, false)
        generatePurifiedElement(Holmium, 8065, false, false)
        generatePurifiedElement(Erbium, 8066, false, false)
        generatePurifiedElement(Thulium, 8067, false, false)
        generatePurifiedElement(Ytterbium, 8068, false, false)
        generatePurifiedElement(Lutetium, 8069, false, false)
        generatePurifiedElement(Thorium, 8070, false, false)

        // IDs 8100+: Other first degree elements

        CalciumHydroxide = new Material.Builder(8100, GTUtility.gregtechId('calcium_hydroxide'))
                .dust()
                .components(Calcium, 1, Oxygen, 2, Hydrogen, 2)
                .color(0xcfcabc)
                .build()
                //.setFormula("Ca(OH)2", true);

        PotassiumHydroxide = new Material.Builder(8101, GTUtility.gregtechId('potassium_hydroxide'))
                .dust().fluid()
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        PotassiumCarbonate = new Material.Builder(8102, GTUtility.gregtechId('potassium_carbonate'))
                .dust().fluid()
                .fluidTemp(1164)
                .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumSilicate = new Material.Builder(8103, GTUtility.gregtechId('sodium_silicate'))
                .dust()
                .components(Sodium, 2, Silicon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumAluminate = new Material.Builder(8104, GTUtility.gregtechId('sodium_aluminate'))
                .dust()
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        PotassiumBisulfate = new Material.Builder(8105, GTUtility.gregtechId('potassium_bisulfate'))
                .dust().fluid()
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        AmmoniumNitrate = new Material.Builder(8107, GTUtility.gregtechId('ammonium_nitrate'))
                .dust()
                .components(Nitrogen, 2, Oxygen, 3, Hydrogen, 4)
                .colorAverage()
                .build()
                //.setFormula("NH4NO3", true);

        AmmoniumSulfate = new Material.Builder(8108, GTUtility.gregtechId('ammonium_sulfate'))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        //AmmoniumSulfate.setFormula("(NH4)2SO4", true)

        SodiumNitrate = new Material.Builder(8109, GTUtility.gregtechId('sodium_nitrate'))
                .dust().fluid()
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumFluoride = new Material.Builder(8110, GTUtility.gregtechId('sodium_fluoride'))
                .fluid().dust()
                .components(Sodium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        PotassiumFluoride = new Material.Builder(8111, GTUtility.gregtechId('potassium_fluoride'))
                .fluid().dust()
                .components(Potassium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        PotassiumTetrafluoroborate = new Material.Builder(8112, GTUtility.gregtechId('potassium_tetrafluoroborate'))
                .fluid().dust()
                .components(Potassium, 1, Boron, 1, Fluorine, 4)
                .color(0x8fb5a3)
                .build();

        SodiumBromide = new Material.Builder(8113, GTUtility.gregtechId('sodium_bromide'))
                .dust()
                .components(Sodium, 1, Bromine, 1)
                .colorAverage()
                .build();

        Fluix = new Material.Builder(8114, GTUtility.gregtechId('fluix'))
                .gem().iconSet(RUBY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_LENS)
                .components(Quartzite, 4, Naquadah, 1)
                .color(0x6503b6)
                .build();

        PigIron = new Material.Builder(8115, GTUtility.gregtechId('pig_iron'))
                .ingot().dust()
                .color(0x99918A)
                .build();

        GreenCoke = new Material.Builder(8116, GTUtility.gregtechId("green_coke"))
                .gem(1, 2000).ore(2, 1)
                .color(0x424a34).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        IronIIISulfate = new Material.Builder(8117, GTUtility.gregtechId('iron_iii_sulfate'))
                .dust()
                .color(0xb09d99)
                .components(Iron, 2, Sulfur, 3, Oxygen, 12)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .build()
                //.setFormula("Fe2(SO4)3", true);

        AluminiumHydroxide = new Material.Builder(8118, GTUtility.gregtechId('aluminium_hydroxide'))
                .dust()
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .build()
                //.setFormula("Al(OH)3", true);

        AluminiumTrifluoride = new Material.Builder(8119, GTUtility.gregtechId('aluminium_trifluoride'))
                .dust()
                .components(Aluminium, 1, Fluorine, 3)
                .color(0x3d98bf)
                .build()

        GalliumPhosphate = new Material.Builder(8120, GTUtility.gregtechId('gallium_phosphate'))
                .gem().iconSet(RUBY)
                .flags(CRYSTALLIZABLE)
                .components(Gallium, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        //GalliumPhosphate.setFormula("GaPO4", true)

        LithiumNiobate = new Material.Builder(8121, GTUtility.gregtechId('lithium_niobate'))
                .gem().iconSet(RUBY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 3)
                .colorAverage()
                .build()

        LeadZirconateTitanite = new Material.Builder(8122, GTUtility.gregtechId('lead_zirconate_titanate'))
                .gem().iconSet(RUBY)
                .components(Lead, 2, Zirconium, 1, Titanium, 1, Oxygen, 6)
                .colorAverage()
                .build()

        BoricAcid = new Material.Builder(8123, GTUtility.gregtechId('boric_acid'))
                .dust()
                .color(0xedece8)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build()

        AmorphousBoron = new Material.Builder(8124, GTUtility.gregtechId('amorphous_boron'))
                .dust()
                .color(0x47464b)
                .build()

        SulfurDichloride = new Material.Builder(8125, GTUtility.gregtechId('sulfur_dichloride'))
                .fluid()
                .components(Sulfur, 1, Chlorine, 2)
                .color(0xd2042d)
                .build()

        BoronTrioxide = new Material.Builder(8126, GTUtility.gregtechId('boron_trioxide'))
                .dust().fluid()
                .color(0xdfcfc2)
                .components(Boron, 2, Oxygen, 3)
                .build()

        ZincChloride = new Material.Builder(8127, GTUtility.gregtechId('zinc_chloride'))
                .dust().fluid()
                .components(Zinc, 1, Chlorine, 2)
                .colorAverage()
                .build()

        SodiumTetraborate = new Material.Builder(8128, GTUtility.gregtechId('sodium_tetraborate'))
                .dust()
                .components(Sodium, 2, Boron, 4, Oxygen, 7)
                .color(0xdbe7db)
                .build()

        ElectrolyticBoron = new Material.Builder(8129, GTUtility.gregtechId('electrolytic_boron'))
                .dust()
                .components(Boron, 1)
                .color(0x9bd4af)
                .build()

        CalciumSulfate = new Material.Builder(8130, GTUtility.gregtechId('calcium_sulfate'))
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        IronIISulfide = new Material.Builder(8131, GTUtility.gregtechId('iron_ii_sulfide'))
                .dust()
                .components(Iron, 1, Sulfur, 1)
                .colorAverage()
                .build();

        PotassiumSulfate = new Material.Builder(8132, GTUtility.gregtechId('potassium_sulfate'))
                .dust()
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        WetAntimonyTrifluoride = new Material.Builder(8133, GTUtility.gregtechId('wet_antimony_trifluoride'))
                .dust()
                .components(Antimony, 1, Fluorine, 3)
                .colorAverage()
                .build();

        CalciumSulfide = new Material.Builder(8134, GTUtility.gregtechId('calcium_sulfide'))
                .dust()
                .components(Calcium, 1, Sulfur, 1)
                .colorAverage()
                .build();

        VanadiumPentoxide = new Material.Builder(8136, GTUtility.gregtechId('vanadium_pentoxide'))
                .dust()
                .components(Vanadium, 2, Oxygen, 5)
                .colorAverage()
                .build();

        PotassiumPersulfate = new Material.Builder(8137, GTUtility.gregtechId('potassium_persulfate'))
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .build();

        LithiumHydroxide = new Material.Builder(8138, GTUtility.gregtechId('lithium_hydroxide'))
                .dust()
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        CalciumCarbide = new Material.Builder(8139, GTUtility.gregtechId('calcium_carbide'))
                .dust()
                .components(Calcium, 1, Carbon, 2)
                .color(0x87847c)
                .build();

        IronIIChloride = new Material.Builder(8140, GTUtility.gregtechId('iron_ii_chloride'))
                .dust()
                .components(Iron, 1, Chlorine, 2)
                .color(0x9dad37)
                .build()

        CuprousOxide = new Material.Builder(8141, GTUtility.gregtechId('cuprous_oxide'))
                .dust()
                .components(Copper, 2, Oxygen, 1)
                .flags(GENERATE_CATALYST_BED)
                .color(0x822635)
                .build()

        LithiumBromide = new Material.Builder(8142, GTUtility.gregtechId('lithium_bromide'))
                .dust()
                .components(Lithium, 1, Bromine, 1)
                .color(0xC5C5C5)
                .build()

        IronIIIOxide = new Material.Builder(8143, GTUtility.gregtechId('iron_iii_oxide'))
                .dust()
                .components(Iron, 2, Oxygen, 3)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8F0C03)
                .build()

        CopperIIChloride = new Material.Builder(8144, GTUtility.gregtechId('copper_ii_chloride'))
                .dust()
                .components(Copper, 1, Chlorine, 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x12112c)
                .build()

        SiliconCarbide = new Material.Builder(8145, GTUtility.gregtechId('silicon_carbide'))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Silicon, 1, Carbon, 1)
                .color(0x404040)
                .build()

        TungstenTrioxide = new Material.Builder(8146, GTUtility.gregtechId('tungsten_trioxide'))
                .dust()
                .components(Tungsten, 1, Oxygen, 3)
                .color(0x8a9734)
                .build()

        Alumina = new Material.Builder(8147, GTUtility.gregtechId('alumina'))
                .dust().fluid()
                .flags(GENERATE_PLATE)
                .components(Aluminium, 2, Oxygen, 3)
                .color(0xd0cff7)
                .build()

        BoronCarbide = new Material.Builder(8148, GTUtility.gregtechId('boron_carbide'))
                .dust()
                .components(Boron, 4, Carbon, 1)
                .flags(GENERATE_ROD)
                .colorAverage()
                .build()

        SilverChloride = new Material.Builder(8149, GTUtility.gregtechId('silver_chloride'))
                .dust()
                .components(Silver, 1, Chlorine, 1)
                .colorAverage()
                .build()

        ArsenicIIISulfide = new Material.Builder(8150, GTUtility.gregtechId('arsenic_iii_sulfide'))
                .dust()
                .components(Arsenic, 2, Sulfur, 3)
                .colorAverage()
                .build()

        SodiumArsenide = new Material.Builder(8151, GTUtility.gregtechId('sodium_arsenide'))
                .dust()
                .components(Sodium, 3, Arsenic, 1)
                .colorAverage()
                .build()

        ArsenicVSulfide = new Material.Builder(8152, GTUtility.gregtechId('arsenic_v_sulfide'))
                .dust()
                .components(Arsenic, 2, Sulfur, 5)
                .colorAverage()
                .build()

        CopperSulfate = new Material.Builder(8153, GTUtility.gregtechId('copper_sulfate'))
                .dust()
                .components(Copper, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()

        RoastedSperrylite = new Material.Builder(8154, GTUtility.gregtechId('roasted_sperrylite'))
                .dust()
                .components(Platinum, 1)
                .color(0x3b1754)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SAND)
                .build();

        EnargiteResidue = new Material.Builder(8155, GTUtility.gregtechId('enargite_residue'))
                .dust()
                .components(Copper, 2, Sulfur, 1)
                .color(0x59183c)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(BRIGHT)
                .build()
                //.setFormula("(?)Cu2S", true);

        HydrogenChloride = new Material.Builder(8156, GTUtility.gregtechId("hydrogen_chloride"))
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Chlorine, 1)
                .colorAverage()
                .build();

        HydrogenFluoride = new Material.Builder(8157, GTUtility.gregtechId("hydrogen_fluoride"))
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Fluorine, 1)
                .colorAverage()
                .build();

        DilutedSaltwater = new Material.Builder(8158, GTUtility.gregtechId("diluted_saltwater"))
                .fluid()
                .components(Water, 2, Salt, 1)
                .color(0x3d61b8)
                .build();

        SodiumHydroxideSolution = new Material.Builder(8159, GTUtility.gregtechId("sodium_hydroxide_solution"))
                .fluid()
                .components(Water, 1, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        IronIIIChlorideSolution = new Material.Builder(8160, GTUtility.gregtechId("iron_iii_chloride_solution"))
                .fluid()
                .components(Water, 1, Iron3Chloride, 1)
                .colorAverage()
                .build();

        DilutedSaltpeterSolution = new Material.Builder(8161, GTUtility.gregtechId('diluted_saltpeter_solution'))
                .fluid()
                .components(Water, 2, Saltpeter, 1)
                .colorAverage()
                .build();

        HydrogenBromide = new Material.Builder(8162, GTUtility.gregtechId('hydrogen_bromide'))
                .fluid()
                .components(Hydrogen, 1, Bromine, 1)
                .colorAverage()
                .build();

        DilutedCalciumChlorideSolution = new Material.Builder(8163, GTUtility.gregtechId("diluted_calcium_chloride_solution"))
                .fluid()
                .components(Water, 2, CalciumChloride, 1)
                .colorAverage()
                .build();

        DilutedRockSaltSolution = new Material.Builder(8164, GTUtility.gregtechId("diluted_rock_salt_solution"))
                .fluid()
                .components(Water, 2, RockSalt, 1)
                .colorAverage()
                .build();

        DryCarbonMonoxide = new Material.Builder(8165, GTUtility.gregtechId("dry_carbon_monoxide"))
                .fluid(FluidTypes.GAS)
                .components(CarbonMonoxide, 1)
                .color(0x202329)
                .build();

        AmmoniaSolution = new Material.Builder(8166, GTUtility.gregtechId("ammonia_solution"))
                .fluid()
                .components(Water, 1, Ammonia, 1)
                .colorAverage()
                .build();

        SaltpeterSolution = new Material.Builder(8167, GTUtility.gregtechId('saltpeter_solution'))
                .fluid()
                .components(Water, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        SaltySaltpeterSolution = new Material.Builder(8168, GTUtility.gregtechId('salty_saltpeter_solution'))
                .fluid()
                .components(SaltWater, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        CarbonDisulfide = new Material.Builder(8169, GTUtility.gregtechId('carbon_disulfide'))
                .fluid()
                .components(Carbon, 1, Sulfur, 2)
                .colorAverage()
                .build();

        HighPressureWater = new Material.Builder(8170, GTUtility.gregtechId("high_pressure_water"))
                .fluid()
                .colorAverage()
                .components(Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Cryolite = new Material.Builder(8171, GTUtility.gregtechId("cryolite"))
                .fluid().dust()
                .components(Sodium, 3, Aluminium, 1, Fluorine, 6)
                .color(0x2497a6)
                .build();

        HeavyWater = new Material.Builder(8173, GTUtility.gregtechId("heavy_water"))
                .fluid()
                .components(Deuterium, 2, Oxygen, 1)
                .color(0x2c37b0)
                .build();

        HeavyHydrogenSulfide = new Material.Builder(8174, GTUtility.gregtechId("heavy_hydrogen_sulfide"))
                .fluid()
                .components(Deuterium, 2, Sulfur, 1)
                .color(0xb09a2c)
                .build();

        SemiHeavyHydrogenSulfide = new Material.Builder(8175, GTUtility.gregtechId("semiheavy_hydrogen_sulfide"))
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Deuterium, 1, Sulfur, 1)
                .color(0xc29836)
                .build();

        SemiHeavyWater = new Material.Builder(8176, GTUtility.gregtechId("semiheavy_water"))
                .fluid()
                .components(Hydrogen, 1, Deuterium, 1, Oxygen, 1)
                .color(0x364ec2)
                .build();

        ImpureSemiheavyWater = new Material.Builder(8177, GTUtility.gregtechId("impure_semiheavy_water"))
                .fluid()
                .components(Water, 1, SemiHeavyWater, 1)
                .colorAverage()
                .build();

        IsotopicallyPureHydrogenSulfide = new Material.Builder(8178, GTUtility.gregtechId("isotopically_pure_hydrogen_sulfide"))
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1)
                .color(0xffab66)
                .build();

        ImpureSemiheavyHydrogenSulfide = new Material.Builder(8179, GTUtility.gregtechId("impure_semiheavy_hydrogen_sulfide"))
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1, SemiHeavyHydrogenSulfide, 1)
                .colorAverage()
                .build();

        ImpureHeavyHydrogenSulfide = new Material.Builder(8180, GTUtility.gregtechId("impure_heavy_hydrogen_sulfide"))
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1, HeavyHydrogenSulfide, 1)
                .colorAverage()
                .build();

        TetrafluoroboricAcid = new Material.Builder(8182, GTUtility.gregtechId("tetrafluoroboric_acid"))
                .fluid()
                .components(Water, 3, Hydrogen, 1, Boron, 1, Fluorine, 4)
                .color(0xa4ab91)
                .build();

        BoronTrichloride = new Material.Builder(8183, GTUtility.gregtechId("boron_trichloride"))
                .fluid(FluidTypes.GAS).plasma()
                .components(Boron, 1, Chlorine, 3)
                .colorAverage()
                .build();

        ProustiteAlkalineLeachSolution = new Material.Builder(8184, GTUtility.gregtechId("proustite_alkaline_leach_solution"))
                .fluid()
                .components(Sodium, 3, Arsenic, 1, Sulfur, 3, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(Na3AsS3)(H2O)", true)

        CrudeArsenicTrichloride = new Material.Builder(8185, GTUtility.gregtechId("crude_arsenic_trichloride"))
                .fluid()
                .components(Arsenic, 1, Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(?)(AsCl3)", true)

        Arsine = new Material.Builder(8186, GTUtility.gregtechId("arsine"))
                .fluid(FluidTypes.GAS)
                .components(Arsenic, 1, Hydrogen, 3)
                .colorAverage()
                .build()

        EnargiteSulfideLeachSolution = new Material.Builder(8187, GTUtility.gregtechId("enargite_sulfide_leach_solution"))
                .fluid()
                .components(Sodium, 3, Arsenic, 1, Sulfur, 4, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(Na3AsS4)(H2O)", true)

        CobaltiteLeachSolution = new Material.Builder(8188, GTUtility.gregtechId("cobaltite_leach_solution"))
                .fluid()
                .components(Cobalt, 3, Nitrogen, 6, Oxygen, 30, Hydrogen, 9, Arsenic, 3, Water, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(Co(NO3)2)3(H3AsO4)3(H2O)3", true)

        ArsenopyriteLeachSolution = new Material.Builder(8189, GTUtility.gregtechId("arsenopyrite_leach_solution"))
                .fluid()
                .components(Iron, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3, Water, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(Fe(NO3)2)3(H3AsO4)3(H2O)3", true)

        ArsenousAcid = new Material.Builder(8190, GTUtility.gregtechId("arsenous_acid"))
                .fluid()
                .components(Hydrogen, 3, Arsenic, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        ArsenicTrichloride = new Material.Builder(8191, GTUtility.gregtechId("arsenic_trichloride"))
                .fluid()
                .components(Arsenic, 1, Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        SaltyArsenousAcid = new Material.Builder(8192, GTUtility.gregtechId("acidic_copper_solution"))
                .fluid()
                .components(Water, 4, Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(H2O)4(CuSO4)2(HNO3)2", true)

        SperryliteWaste = new Material.Builder(8193, GTUtility.gregtechId("sperrylite_waste"))
                .fluid()
                .components(Water, 3, Chlorine, 2, Cobalt, 1, Nickel, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(H2O)3(Ni,Co)Cl2", true)

        AcidicCopperSolution = new Material.Builder(8194, GTUtility.gregtechId("acidic_copper_solution"))
                .fluid()
                .components(Water, 4, Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula("(H2O)4(CuSO4)2(HNO3)2", true)

        WustiteCatalyst = new Material.Builder(8195, GTUtility.gregtechId("wustite_catalyst"))
                .dust()
                .components(Iron, 1, Oxygen, 1)
                .color(0x696e62)
                .build()

        PalladiumChloride = new Material.Builder(8196, GTUtility.gregtechId("palladium_chloride"))
                .dust()
                .iconSet(SHINY)
                .components(Palladium, 1, Chlorine, 2)
                .colorAverage()
                .build()

        HexachloroiridicAcid = new Material.Builder(8197, GTUtility.gregtechId("hexachloroiridic_acid"))
                .dust()
                .iconSet(SHINY)
                .components(Chlorine, 6, Hydrogen, 2, Iridium, 1)
                .colorAverage()
                .build()

        PotassiumIodide = new Material.Builder(8198, GTUtility.gregtechId("potassium_iodide"))
                .dust()
                .components(Potassium, 1, Iodine, 1)
                .colorAverage()
                .build()

        IridiumIodide = new Material.Builder(8199, GTUtility.gregtechId("iridium_iodide"))
                .dust()
                .components(Iridium, 1, Iodine, 4)
                .colorAverage()
                .build()

        PhosphorusTrichloride = new Material.Builder(8200, GTUtility.gregtechId("phosphorus_trichloride"))
                .fluid()
                .components(Phosphorus, 1, Chlorine, 3)
                .colorAverage()
                .build()

        TriphenylPhosphine = new Material.Builder(8201, GTUtility.gregtechId("triphenyl_phosphine"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .colorAverage()
                .build()

        TriphenylPhosphineDichloride = new Material.Builder(8202, GTUtility.gregtechId("triphenyl_phosphine_dichloride"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Chlorine, 2, Phosphorus, 1)
                .colorAverage()
                .build()

        BistriphenylphosphineiminiumChloride = new Material.Builder(8203, GTUtility.gregtechId("bistriphenylphosphineiminium_chloride"))
                .dust()
                .components(Carbon, 36, Hydrogen, 30, Chlorine, 1, Nitrogen, 1, Phosphorus, 2)
                .colorAverage()
                .build()

        TriphenylphosphineOxide = new Material.Builder(8204, GTUtility.gregtechId("triphenylphosphine_oxide"))
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Oxygen, 1, Phosphorus, 1)
                .colorAverage()
                .build()

        SodiumDichromate = new Material.Builder(8205, GTUtility.gregtechId("sodium_dichromate"))
                .dust()
                .components(Sodium, 2, Chrome, 2, Oxygen, 7)
                .colorAverage()
                .build()

        RaneyNickel = new Material.Builder(8206, GTUtility.gregtechId("raney_nickel"))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Nickel, 1, Aluminium, 1)
                .color(0x858aa1)
                .build()

        ActivatedRaneyNickel = new Material.Builder(8207, GTUtility.gregtechId("activated_raney_nickel"))
                .dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nickel, 1, Aluminium, 1)
                .color(0xa9aec4)
                .build()

        CopperIIOxide = new Material.Builder(8209, GTUtility.gregtechId("copper_ii_oxide"))
                .dust()
                .components(Copper, 1, Oxygen, 1)
                .colorAverage()
                .build()

        DicobaltOctacarbonyl = new Material.Builder(8210, GTUtility.gregtechId("dicobalt_octacarbonyl"))
                .dust()
                .components(Cobalt, 2, Cobalt, 8, Oxygen, 8)
                .colorAverage()
                .build()
                //.setFormula("Co2(CO)8", true)

        ImpregnatedAluminaCatalyst = new Material.Builder(8211, GTUtility.gregtechId("impregnated_alumina_catalyst"))
                .dust()
                .components(SiliconDioxide, 1, Alumina, 1)
                .colorAverage()
                .build()

        BismuthCopper = new Material.Builder(8212, GTUtility.gregtechId("bismuth_copper"))
                .dust()
                .components(Bismuth, 1, Copper, 1)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build()

        Bromobenzene = new Material.Builder(8213, GTUtility.gregtechId("bromobenzene"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 5, Bromine, 1)
                .colorAverage()
                .build()

        AluminiumTrichloride = new Material.Builder(8214, GTUtility.gregtechId("aluminium_trichloride"))
                .dust()
                .components(Aluminium, 1, Chlorine, 3)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build()

        Triethylaluminium = new Material.Builder(8215, GTUtility.gregtechId("triethylaluminium"))
                .fluid()
                .components(Carbon, 12, Hydrogen, 30, Aluminium, 2)
                .colorAverage()
                .build()

        //Triethylaluminium.setFormula("Al2(C2H5)6", true)

        HydrogenPeroxide = new Material.Builder(8216, GTUtility.gregtechId("hydrogen_peroxide"))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 2)
                .colorAverage()
                .build()

        Tetrabromomethane = new Material.Builder(8217, GTUtility.gregtechId("tetrabromomethane"))
                .fluid()
                .components(Carbon, 1, Bromine, 4)
                .colorAverage()
                .build()

        Bromomethane = new Material.Builder(8218, GTUtility.gregtechId("bromomethane"))
                .fluid()
                .components(Carbon, 1, Hydrogen, 3, Bromine, 1)
                .colorAverage()
                .build()

        VeryDilutedSulfuricAcid = new Material.Builder(8219, GTUtility.gregtechId("very_diluted_sulfuric_acid"))
                .fluid()
                .components(Water, 2, SulfuricAcid, 1)
                .color(0x54362c)
                .build()

        SulfurDichloride = new Material.Builder(8220, GTUtility.gregtechId("sulfur_dichloride"))
                .fluid()
                .components(Sulfur, 1, Chlorine, 2)
                .colorAverage()
                .build()

        ThionylChloride = new Material.Builder(8221, GTUtility.gregtechId("thionyl_chloride"))
                .fluid()
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build()

        LithiumHydride = new Material.Builder(8222, GTUtility.gregtechId("lithium_hydride"))
                .dust()
                .components(Lithium, 1, Hydrogen, 1)
                .colorAverage()
                .build()

        BoronTrifluoride = new Material.Builder(8223, GTUtility.gregtechId("boron_trifluoride"))
                .fluid(FluidTypes.GAS)
                .components(Boron, 1, Fluorine, 3)
                .colorAverage()
                .build()

        Diborane = new Material.Builder(8224, GTUtility.gregtechId("diborane"))
                .fluid(FluidTypes.GAS)
                .components(Boron, 2, Hydrogen, 6)
                .color(0x524545)
                .build()

        LithiumFluoride = new Material.Builder(8225, GTUtility.gregtechId("lithium_fluoride"))
                .dust()
                .components(Lithium, 1, Fluorine, 1)
                .colorAverage()
                .build()

        LithiumTetrafluoroborate = new Material.Builder(8226, GTUtility.gregtechId("lithium_tetrafluoroborate"))
                .dust()
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .colorAverage()
                .build()

        TetramethylammoniumChloride = new Material.Builder(8227, GTUtility.gregtechId("tetramethylammonium_chloride"))
                .dust()
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .colorAverage()
                .build()

        TetramethylammoniumHydroxide = new Material.Builder(8228, GTUtility.gregtechId("tetramethylammonium_hydroxide"))
                .dust()
                .components(Carbon, 4, Hydrogen, 13, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build()

        MethacrylamideSulfate = new Material.Builder(8229, GTUtility.gregtechId("methacrylamide_sulfate"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 5, Sulfur, 1)
                .colorAverage()
                .build()

        AmmoniumBisulfate = new Material.Builder(8230, GTUtility.gregtechId("ammonium_bisulfate"))
                .dust().fluid()
                .components(Nitrogen, 1, Hydrogen, 5, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()
                ////.setFormula("(NH4)HSO4", true)

        Phosphine = new Material.Builder(8231, GTUtility.gregtechId("phosphine"))
                .fluid(FluidTypes.GAS)
                .components(Phosphorus, 1, Hydrogen, 3)
                .colorAverage()
                .build()

        PotassiumHypophosphite = new Material.Builder(8232, GTUtility.gregtechId("potassium_hypophosphite"))
                .dust()
                .components(Potassium, 1, Phosphorus, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()

        SodiumHypophosphite = new Material.Builder(8233, GTUtility.gregtechId("sodium_hypophosphite"))
                .dust()
                .components(Sodium, 1, Phosphorus, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()

        DipotassiumPhosphate = new Material.Builder(8234, GTUtility.gregtechId("dipotassium_phosphate"))
                .dust()
                .components(Potassium, 2, Hydrogen, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        DisodiumPhosphate = new Material.Builder(8235, GTUtility.gregtechId("disodium_phosphate"))
                .dust()
                .components(Sodium, 2, Hydrogen, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        SodiumCyanide = new Material.Builder(8236, GTUtility.gregtechId("sodium_cyanide"))
                .dust()
                .components(Sodium, 1, Carbon, 1, Nitrogen, 1)
                .colorAverage()
                .build()

        PhosphorylChloride = new Material.Builder(8237, GTUtility.gregtechId("phosphoryl_chloride"))
                .fluid()
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .colorAverage()
                .build()

        PhosphorusPentachloride = new Material.Builder(8238, GTUtility.gregtechId("phosphorus_pentachloride"))
                .dust()
                .components(Phosphorus, 1, Chlorine, 5)
                .colorAverage()
                .build()

        AmmoniumIodide = new Material.Builder(8240, GTUtility.gregtechId("ammonium_iodide"))
                .dust().fluid()
                .components(Nitrogen, 1, Hydrogen, 4, Iodine, 1)
                .colorAverage()
                .build()

        HydrobromicAcid = new Material.Builder(8241, GTUtility.gregtechId("hydrobromic_acid"))
                .fluid()
                .components(Hydrogen, 1, Bromine, 1)
                .colorAverage()
                .build()

        AluminiumChloride = new Material.Builder(8242, GTUtility.gregtechId("aluminium_chloride"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(460)
                .components(Aluminium, 1, Chlorine, 3)
                .colorAverage()
                .build()

        SodiumSulfite = new Material.Builder(8243, GTUtility.gregtechId('sodium_sulfite'))
                .dust()
                .components(Sodium, 2, Sulfur, 1, Oxygen, 3)
                .colorAverage()
                .build()

        SodiumThiosulfate = new Material.Builder(8244, GTUtility.gregtechId('sodium_thiosulfate'))
                .dust()
                .components(Sodium, 2, Sulfur, 2, Oxygen, 3)
                .color(0x879e21)
                .build()

        SulfidicSilverCyanideSolution = new Material.Builder(8247, GTUtility.gregtechId("sulfidic_silver_cyanide_solution"))
                .fluid()
                .components(Silver, 2, Carbon, 4, Nitrogen, 4, Sodium, 4, Sulfur, 1, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        SilverCyanideSolution = new Material.Builder(8248, GTUtility.gregtechId("silver_cyanide_solution"))
                .fluid()
                .components(Silver, 2, Carbon, 4, Nitrogen, 4, Sodium, 4, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na[Ag(CN)2])2(NaCl)2(H2O)4', true)

        SulfidicPyrargyriteCyanideLeachSolution = new Material.Builder(8249, GTUtility.gregtechId('sulfidic_pyrargyrite_cyanide_leach_solution'))
                .fluid()
                .components(Sodium, 6, Silver, 3, Carbon, 6, Nitrogen, 6, Antimony, 1, Sulfur, 3, Water, 6)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na[Ag(CN)2])3(Na3SbS3)(H2O)6', true)

        PyrargyriteCyanideLeachSolution = new Material.Builder(8250, GTUtility.gregtechId('pyrargyrite_cyanide_leach_solution'))
                .fluid()
                .components(Sodium, 6, Silver, 3, Carbon, 6, Nitrogen, 6, Antimony, 1, Chlorine, 6, Water, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na[Ag(CN)2])3(NaCl)2(NaSbCl4)(H2O)6', true)

        PyrargyriteThiosulfateLeachSolution = new Material.Builder(8251, GTUtility.gregtechId('pyrargyrite_thiosulfate_leach_solution'))
                .fluid()
                .components(Sodium, 12, Silver, 3, Sulfur, 15, Oxygen, 18, Antimony, 1, Water, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na3[Ag(S2O3)2])3(Na3SbS3)(H2O)5', true)

        ThiosulfateThioantimoniteSolution = new Material.Builder(8252, GTUtility.gregtechId("thiosulfate_thioantimonite_solution"))
                .fluid()
                .components(Sodium, 15, Sulfur, 15, Oxygen, 18, Antimony, 1, Water, 5)
                .colorAverage()
                .build()
                //.setFormula('(Na2S2O3)6(Na3SbS3)(H2O)5', true)

        ThiosulfateThioarseniteSolution = new Material.Builder(8253, GTUtility.gregtechId("thiosulfate_thioarsenite_solution"))
                .fluid()
                .components(Sodium, 15, Sulfur, 15, Oxygen, 18, Arsenic, 1, Water, 5)
                .colorAverage()
                .build()
                //.setFormula('(Na2S2O3)6(Na3AsS3)(H2O)5', true)

        SulfidicStephaniteCyanideLeachSolution = new Material.Builder(8254, GTUtility.gregtechId('sulfidic_stephanite_cyanide_leach_solution'))
                .fluid()
                .components(Sodium, 10, Silver, 5, Carbon, 10, Nitrogen, 10, Antimony, 1, Sulfur, 4, Water, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na[Ag(CN)2])5(Na3SbS3)(Na2S)(H2O)12', true)

        StephaniteCyanideLeachSolution = new Material.Builder(8255, GTUtility.gregtechId('stephanite_cyanide_leach_solution'))
                .fluid()
                .components(Sodium, 10, Silver, 5, Carbon, 10, Nitrogen, 10, Antimony, 1, Chlorine, 8, Water, 20)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na[Ag(CN)2])5(NaCl)2(NaSbCl6)(H2O)20', true)

        ProustiteThiosulfateLeachSolution = new Material.Builder(8256, GTUtility.gregtechId('proustite_thiosulfate_leach_solution'))
                .fluid()
                .components(Sodium, 12, Silver, 3, Sulfur, 15, Oxygen, 18, Arsenic, 1, Water, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(Na3[Ag(S2O3)2])3(Na3AsS3)(H2O)5', true)

        AcidicArsenateVSolution = new Material.Builder(8257, GTUtility.gregtechId('acidic_arsenate_v_solution'))
                .fluid()
                .components(NitricAcid, 6, Hydrogen, 9, Arsenic, 3, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                //.setFormula('(HNO3)6(H3AsO4)3', true)

        ArsenicVOxide = new Material.Builder(8258, GTUtility.gregtechId('arsenic_v_oxide'))
                .dust()
                .components(Arsenic, 2, Oxygen, 5)
                .colorAverage()
                .build()

        SilverOxide = new Material.Builder(8259, GTUtility.gregtechId('silver_oxide'))
                .dust()
                .components(Silver, 2, Oxygen, 1)
                .colorAverage()
                .build()

        SilverSulfide = new Material.Builder(8260, GTUtility.gregtechId('silver_sulfide'))
                .dust()
                .components(Silver, 2, Sulfur, 1)
                .colorAverage()
                .build()

        IronThioantimonite = new Material.Builder(8261, GTUtility.gregtechId('iron_thioantimonite'))
                .dust()
                .components(Iron, 1, Antimony, 1, Sulfur, 3)
                .colorAverage()
                .build()

        AntimonyIIISulfide = new Material.Builder(8262, GTUtility.gregtechId('antimony_iii_sulfide'))
                .dust()
                .components(Antimony, 2, Sulfur, 3)
                .colorAverage()
                .build()

        IronThioarsenite = new Material.Builder(8263, GTUtility.gregtechId('iron_thioarsenite'))
                .dust()
                .components(Iron, 1, Arsenic, 1, Sulfur, 3)
                .colorAverage()
                .build()

        ManganeseIIOxide = new Material.Builder(8265, GTUtility.gregtechId("manganese_ii_oxide"))
                .dust()
                .components(Manganese, 1, Oxygen, 1)
                .color(0x472400)
                .iconSet(SAND)
                .build()

        CrudeManganeseIISulfateSolution = new Material.Builder(8266, GTUtility.gregtechId("crude_manganese_ii_sulfate_solution"))
                .fluid()
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .colorAverage()
                .build()
                //.setFormula('(?)(MnSO4)(H2O)', true)

        CrudeManganeseIISulfateSolution = new Material.Builder(8267, GTUtility.gregtechId("manganese_ii_sulfate_solution"))
                .fluid()
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .colorAverage()
                .build()
                //.setFormula('(MnSO4)(H2O)', true)

        IronIIIHydroxide = new Material.Builder(8268, GTUtility.gregtechId("iron_iii_hydroxide"))
                .dust()
                .components(Iron, 1, Oxygen, 3, Hydrogen, 3)
                .color(0xcc7e35)
                .iconSet(SAND)
                .build()
                //.setFormula('Fe(OH)3', true)

        Cellulose = new Material.Builder(8269, GTUtility.gregtechId('cellulose'))
                .dust()
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .color(0x4a432f)
                .build()

        CrudeGalliumTrichloride = new Material.Builder(8270, GTUtility.gregtechId('crude_gallium_trichloride'))
                .dust().fluid()
                .components(Gallium, 1, Chlorine, 3)
                .fluidTemp(351)
                .colorAverage()
                .build()
                //.setFormula('(?)GaCl3', true)

        GalliumTrichloride = new Material.Builder(8271, GTUtility.gregtechId('gallium_trichloride'))
                .fluid()
                .components(Gallium, 1, Chlorine, 3)
                .fluidTemp(351)
                .colorAverage()
                .build()
                //.setFormula('GaCl3', true)

        MercuryIIChloride = new Material.Builder(8272, GTUtility.gregtechId('mercury_ii_chloride'))
                .dust()
                .components(Mercury, 1, Chlorine, 2)
                .colorAverage()
                .build()

        BoronNitride = new Material.Builder(8273, GTUtility.gregtechId('boron_nitride'))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Boron, 1, Nitrogen, 1)
                .colorAverage()
                .build()

        CrudeIronPentacarbonyl = new Material.Builder(8275, GTUtility.gregtechId('crude_iron_pentacarbonyl'))
                .fluid()
                .components(Iron, 1, Carbon, 5, Oxygen, 5)
                .color(0x362f2b)
                .build()
                //.setFormula('Fe(CO)5')

        AluminiumSulfate = new Material.Builder(8276, GTUtility.gregtechId('aluminium_sulfate'))
                .dust()
                .components(Aluminium, 2, Sulfur, 3, Oxygen, 12)
                .colorAverage()
                .build()

        //AluminiumSulfate.setFormula('Al2(SO4)3', true)

        DemineralizedWater = new Material.Builder(8277, GTUtility.gregtechId('demineralized_water'))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x4761a8)
                .build()

        DeaeratedWater = new Material.Builder(8278, GTUtility.gregtechId('deaerated_water'))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x5681b3)
                .build()

        FilteredWater = new Material.Builder(8279, GTUtility.gregtechId('filtered_water'))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x62a0bd)
                .build()

        SterilizedWater = new Material.Builder(8280, GTUtility.gregtechId('sterilized_water'))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x6cb3c4)
                .build()

        UltrapureWater = new Material.Builder(8281, GTUtility.gregtechId('ultrapure_water'))
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x7acacf)
                .build()

        Ferrochromium = new Material.Builder(8282, GTUtility.gregtechId('ferrochromium'))
                .dust()
                .components(Iron, 1, Chrome, 2)
                .color(0x6b6552)
                .build()

        Ferrosilicon = new Material.Builder(8283, GTUtility.gregtechId('ferrosilicon'))
                .dust()
                .components(Iron, 1, Silicon, 3)
                .iconSet(SHINY)
                .color(0x999a99)
                .build()

        ConcentratedSaltWater = new Material.Builder(8284, GTUtility.gregtechId("concentrated_salt_water"))
                .fluid()
                .components(Water, 1, Salt, 2)
                .colorAverage()
                .build();

        HypersalineWater = new Material.Builder(8285, GTUtility.gregtechId("hypersaline_water"))
                .fluid()
                .components(Water, 1, Salt, 4)
                .colorAverage()
                .build();

        LithiumCarbonate = new Material.Builder(8286, GTUtility.gregtechId("lithium_carbonate"))
                .dust()
                .components(Lithium, 2, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        LithiumCobaltOxide = new Material.Builder(8287, GTUtility.gregtechId("lithium_cobalt_oxide"))
                .dust()
                .components(Lithium, 1, Cobalt, 1, Oxygen, 2)
                .colorAverage()
                .build();

        SodiumCathodeAlloy = new Material.Builder(8288, GTUtility.gregtechId("sodium_cathode_alloy"))
                .dust()
                .components(Sodium, 4, Iron, 3, Manganese, 3, Oxygen, 12)
                .colorAverage()
                .build();

        LithiumHexafluorophosphate = new Material.Builder(8289, GTUtility.gregtechId("lithium_hexafluorophosphate"))
                .fluid()
                .components(Lithium, 1, Phosphorus, 1, Fluorine, 6)
                .colorAverage()
                .build();

        NickelChloride = new Material.Builder(8290, GTUtility.gregtechId("nickel_chloride"))
                .dust()
                .components(Nickel, 1, Chlorine, 2)
                .colorAverage()
                .build();

        NickelHydroxide = new Material.Builder(8291, GTUtility.gregtechId("nickel_hydroxide"))
                .dust()
                .components(Nickel, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        //NickelHydroxide.setFormula("Ni(OH)2", true)

        NickelOxideHydroxide = new Material.Builder(8292, GTUtility.gregtechId("nickel_oxide_hydroxide"))
                .dust()
                .components(Nickel, 1, Oxygen, 3, Hydrogen, 2)
                .colorAverage()
                .build();

        //NickelOxideHydroxide.setFormula("NiO(OH)2", true)

        SilverNitrateSolution = new Material.Builder(8293, GTUtility.gregtechId("silver_nitrate_solution"))
                .fluid()
                .components(Silver, 1, Nitrogen, 1, Oxygen, 3, Water, 1)
                .colorAverage()
                .build();

        //SilverNitrateSolution.setFormula("(AgNO3)(H2O)", true)

        ChloroauricAcid = new Material.Builder(8294, GTUtility.gregtechId("chloroauric_acid"))
                .dust()
                .components(Hydrogen, 1, Gold, 1, Chlorine, 4)
                .color(0xcc8821)
                .build();

        //ChloroauricAcid.setFormula("H[AuCl4]", true)

        SpentMoebiusElectrolyte = new Material.Builder(8295, GTUtility.gregtechId("spent_moebius_electrolyte"))
                .fluid()
                .components(Silver, 1, Nitrogen, 1, Oxygen, 3, Water, 1)
                .colorAverage()
                .build();

        //SpentMoebiusElectrolyte.setFormula("(?)(AgNO3)(H2O)", true)

        ActivatedCarbon = new Material.Builder(8296, GTUtility.gregtechId("activated_carbon"))
                .dust()
                .components(Carbon, 1)
                .color(0x38393b)
                .build();

        SulfuricPGMSolution = new Material.Builder(8297, GTUtility.gregtechId("sulfuric_pgm_solution"))
                .fluid()
                .components(SulfuricAcid, 3, HydrochloricAcid, 12, Water, 8)
                .colorAverage()
                .build();

        //SulfuricPGMSolution.setFormula("(?)(H2SO4)3(HCl)12(H2O)8", true)

        PGMSolution = new Material.Builder(8298, GTUtility.gregtechId("pgm_solution"))
                .fluid()
                .components(HydrochloricAcid, 12, Water, 12)
                .colorAverage()
                .build();

        //PGMSolution.setFormula("(?)(HCl)12(H2O)12", true)

        GoldPlatedSteel = new Material.Builder(8299, GTUtility.gregtechId("gold_plated_steel"))
                .ingot()
                .components(Gold, 1, Steel, 1)
                .colorAverage()
                .flags(GENERATE_FINE_WIRE)
                .build();

        GoldConcentrate = new Material.Builder(8300, GTUtility.gregtechId("gold_concentrate"))
                .dust()
                .components(SiliconDioxide, 4, Gold, 1)
                .colorAverage()
                .iconSet(SAND)
                .build();

        LoadedCarbon = new Material.Builder(8301, GTUtility.gregtechId("loaded_carbon"))
                .dust()
                .components(Sodium, 1, Gold, 1, Carbon, 3, Nitrogen, 2)
                .color(0x44453b)
                .build();

        //LoadedCarbon.setFormula("(Na[Au(CN)2])C", true)

        SpentActivatedCarbon = new Material.Builder(8302, GTUtility.gregtechId("spent_activated_carbon"))
                .dust()
                .components(Carbon, 1)
                .color(0x262729)
                .build();

        WashedActivatedCarbon = new Material.Builder(8303, GTUtility.gregtechId("washed_activated_carbon"))
                .dust()
                .components(Carbon, 1)
                .color(0x2d302b)
                .build();

        CalciumOrthosilicate = new Material.Builder(8304, GTUtility.gregtechId("calcium_orthosilicate"))
                .dust()
                .components(Calcium, 2, Silicon, 1, Oxygen, 4)
                .colorAverage()
                .build();

        MagnesiumChlorideSolution = new Material.Builder(8305, GTUtility.gregtechId("magnesium_chloride_solution"))
                .fluid()
                .components(MagnesiumChloride, 1, Water, 2)
                .colorAverage()
                .build();

        MagnesiumHydroxide = new Material.Builder(8306, GTUtility.gregtechId("magnesium_hydroxide"))
                .dust()
                .components(Magnesium, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        //MagnesiumHydroxide.setFormula("Mg(OH)2", true)

        MagnesiumSulfate = new Material.Builder(8307, GTUtility.gregtechId("magnesium_sulfate"))
                .dust()
                .components(Magnesium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        CeriumIVOxide = new Material.Builder(8308, GTUtility.gregtechId("cerium_iv_oxide"))
                .dust()
                .components(Cerium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        CeriumIIIOxide = new Material.Builder(8309, GTUtility.gregtechId("cerium_iii_oxide"))
                .dust()
                .components(Cerium, 2, Oxygen, 3)
                .colorAverage()
                .build();

        IronSulfate = new Material.Builder(8310, GTUtility.gregtechId("iron_sulfate"))
                .dust()
                .components(Iron, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        RoastedPetalite = new Material.Builder(8311, GTUtility.gregtechId("roasted_petalite"))
                .dust()
                .color(0xabc9c9)
                .components(Lithium, 1, Aluminium, 1, Silicon, 4, Oxygen, 10)
                .iconSet(SAND)
                .build()
                .setFormula("(LiAlSi2O6)(SiO2)2", true)

        BetaSpodumene = new Material.Builder(8312, GTUtility.gregtechId("beta_spodumene"))
                .dust()
                .color(0xab7676)
                .components(Lithium, 1, Aluminium, 1, Silicon, 2, Oxygen, 6)
                .build();

        LithiumSulfate = new Material.Builder(8313, GTUtility.gregtechId("lithium_sulfate"))
                .dust()
                .components(Lithium, 2, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        AluminiumPhosphate = new Material.Builder(8314, GTUtility.gregtechId("aluminium_phosphate"))
                .dust()
                .components(Aluminium, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SiliconTetrafluoride = new Material.Builder(8315, GTUtility.gregtechId("silicon_tetrafluoride"))
                .fluid(FluidTypes.GAS)
                .components(Silicon, 1, Fluorine, 4)
                .colorAverage()
                .build();

        SodiumFluoroberyllate = new Material.Builder(8316, GTUtility.gregtechId("sodium_fluoroberyllate"))
                .dust()
                .components(Sodium, 2, Beryllium, 1, Fluorine, 4)
                .colorAverage()
                .build();

        SodiumFluorosilicate = new Material.Builder(8317, GTUtility.gregtechId("sodium_fluorosilicate"))
                .dust()
                .components(Sodium, 2, Silicon, 1, Fluorine, 6)
                .colorAverage()
                .build();

        BerylliumHydroxide = new Material.Builder(8318, GTUtility.gregtechId("beryllium_hydroxide"))
                .dust()
                .components(Beryllium, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()
                //.setFormula("Be(OH)2", true);

        BerylliumOxide = new Material.Builder(8319, GTUtility.gregtechId("beryllium_oxide"))
                .dust().fluid()
                .flags(GENERATE_PLATE)
                .components(Beryllium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        BerylliumChloride = new Material.Builder(8320, GTUtility.gregtechId("beryllium_chloride"))
                .dust().fluid()
                .components(Beryllium, 1, Chlorine, 2)
                .colorAverage()
                .build();

        AmmoniumFluoride = new Material.Builder(8321, GTUtility.gregtechId("ammonium_fluoride"))
                .dust()
                .components(Nitrogen, 1, Hydrogen, 4, Fluorine, 1)
                .colorAverage()
                .build();

        AmmoniumBifluoride = new Material.Builder(8322, GTUtility.gregtechId("ammonium_bifluoride"))
                .dust()
                .components(Nitrogen, 1, Hydrogen, 5, Fluorine, 2)
                .colorAverage()
                .build();

        //AmmoniumBifluoride.setFormula("[NH4][HF2]", true)

        AmmoniumFluoroberyllate = new Material.Builder(8323, GTUtility.gregtechId("ammonium_fluoroberyllate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Beryllium, 1, Fluorine, 4)
                .colorAverage()
                .build();

        //AmmoniumFluoroberyllate.setFormula("(NH4)2BeF4", true)

        ChromiumIIIHydroxide = new Material.Builder(8324, GTUtility.gregtechId("chromium_iii_hydroxide"))
                .dust()
                .components(Chrome, 1, Oxygen, 3, Hydrogen, 3)
                .color(0x2e5207)
                .build();

        //ChromiumIIIHydroxide.setFormula("Cr(OH)3", true)

        DisassociatedAmmoniumFluoride = new Material.Builder(8325, GTUtility.gregtechId("disassociated_ammonium_fluoride"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(1200)
                .components(Ammonia, 1, HydrogenFluoride, 1)
                .colorAverage()
                .build();

        BerylliumFluoride = new Material.Builder(8326, GTUtility.gregtechId("beryllium_fluoride"))
                .dust()
                .components(Beryllium, 1, Fluorine, 2)
                .colorAverage()
                .build();

        MagnesiumFluoride = new Material.Builder(8327, GTUtility.gregtechId("magnesium_fluoride"))
                .dust()
                .components(Magnesium, 1, Fluorine, 2)
                .colorAverage()
                .build();

        DissolvedMagnesiumFluoride = new Material.Builder(8328, GTUtility.gregtechId("dissolved_magnesium_fluoride"))
                .fluid()
                .components(Magnesium, 1, Chlorine, 2, HydrofluoricAcid, 2)
                .colorAverage()
                .build();

        DissolvedAlkaliBeryl = new Material.Builder(8329, GTUtility.gregtechId("dissolved_beryl"))
                .fluid()
                .components(Beryllium, 3, Aluminium, 2, Sodium, 2, Sulfur, 7, Oxygen, 28, Water, 7)
                .colorAverage()
                .build();

        //DissolvedAlkaliBeryl.setFormula("(BeSO4)3(Al2(SO4)3)(Na2SO4)(H2O)7", true)

        PotassiumAlum = new Material.Builder(8330, GTUtility.gregtechId("potassium_alum"))
                .dust()
                .components(Potassium, 1, Aluminium, 1, Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .build();

        //PotassiumAlum.setFormula("KAl(SO4)2", true)

        BerylliumSulfateSolution = new Material.Builder(8331, GTUtility.gregtechId("beryllium_sulfate_solution"))
                .fluid()
                .components(Beryllium, 3, Sodium, 2, Sulfur, 4, Oxygen, 16, Water, 8)
                .colorAverage()
                .build();

        CopperChloride = new Material.Builder(8332, GTUtility.gregtechId("copper_chloride"))
                .dust()
                .components(Copper, 1, Chlorine, 2)
                .colorAverage()
                .build();

        RutheniumIVOxide = new Material.Builder(8333, GTUtility.gregtechId("ruthenium_iv_oxide"))
                .dust()
                .components(Ruthenium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        Trichlorosilane = new Material.Builder(8334, GTUtility.gregtechId("trichlorosilane"))
                .fluid()
                .components(Hydrogen, 1, Chlorine, 3, Silicon, 1)
                .color(0x77979e)
                .build();

        PurifiedTrichlorosilane = new Material.Builder(8335, GTUtility.gregtechId("purified_trichlorosilane"))
                .fluid()
                .components(Hydrogen, 1, Chlorine, 3, Silicon, 1)
                .color(0x93b9c2)
                .build();

        HexafluorosilicicAcid = new Material.Builder(8336, GTUtility.gregtechId("hexafluorosilicic_acid"))
                .fluid()
                .components(Hydrogen, 2, Silicon, 1, Fluorine, 6)
                .colorAverage()
                .build();

        CrudeLead = new Material.Builder(8337, GTUtility.gregtechId("crude_lead"))
                .fluid().ingot()
                .fluidTemp(600)
                .components(Lead, 1)
                .color(0x1f1926)
                .flags(GENERATE_PLATE)
                .build();

        SilverFreeLead = new Material.Builder(8338, GTUtility.gregtechId("silver_free_lead"))
                .dust().fluid()
                .fluidTemp(600)
                .components(Lead, 1)
                .color(0x26202e)
                .build();

        BismuthDross = new Material.Builder(8339, GTUtility.gregtechId("bismuth_dross"))
                .dust().fluid()
                .fluidTemp(600)
                .components(Calcium, 1, Magnesium, 2, Bismuth, 2)
                .color(0x292b45)
                .build();

        AntimonyDross = new Material.Builder(8340, GTUtility.gregtechId("antimony_dross"))
                .dust().fluid()
                .fluidTemp(600)
                .components(Calcium, 1, Magnesium, 2, Antimony, 2)
                .color(0x3c3a45)
                .build();

        ZincDross = new Material.Builder(8341, GTUtility.gregtechId("zinc_dross"))
                .dust().fluid()
                .fluidTemp(600)
                .components(Zinc, 2, Silver, 1)
                .color(0xb7baa8)
                .build();

        PurifiedTinIIOxide = new Material.Builder(8342, GTUtility.gregtechId("purified_tin_ii_oxide"))
                .dust()
                .iconSet(SHINY)
                .components(Tin, 1, Oxygen, 1)
                .colorAverage()
                .build();

        AluminiumSilicate = new Material.Builder(8343, GTUtility.gregtechId("aluminium_silicate"))
                .dust()
                .components(Aluminium, 2, Silicon, 1, Oxygen, 5)
                .colorAverage()
                .build();

        ChromiumIIIOxide = new Material.Builder(8344, GTUtility.gregtechId("chromium_iii_oxide"))
                .dust()
                .components(Chrome, 2, Oxygen, 3)
                .color(0xb3c99)
                .build();

        SodiumSulfateAcetoneSolution = new Material.Builder(8345, GTUtility.gregtechId("sodium_sulfate_acetone_solution"))
                .fluid()
                .components(Sodium, 12, Sulfur, 6, Oxygen, 24, Acetone, 1, Water, 9)
                .color(0x2c733a)
                .build();

        ImpureGalenaSlurry = new Material.Builder(8346, GTUtility.gregtechId("impure_galena_slurry"))
                .fluid()
                .components(Galena, 2, Water, 1)
                .colorAverage()
                .build();

        CopperDross = new Material.Builder(8347, GTUtility.gregtechId("copper_dross"))
                .dust()
                .components(Copper, 1, Sulfur, 1)
                .color(0x000000)
                .build();

        DecopperedLead = new Material.Builder(8348, GTUtility.gregtechId("decoppered_lead"))
                .fluid()
                .components(Lead, 1)
                .color(0x886b9c)
                .build();

        DezincedLead = new Material.Builder(8349, GTUtility.gregtechId("dezinced_lead"))
                .fluid()
                .components(Lead, 1)
                .color(0x825d9c)
                .build();

        BettsCrudeLead = new Material.Builder(8350, GTUtility.gregtechId("betts_crude_lead"))
                .fluid().ingot()
                .components(Bismuth, 3, Lead, 6, Copper, 1)
                .color(0x393673)
                .build();

        DecopperedBettsLead = new Material.Builder(8351, GTUtility.gregtechId("decoppered_betts_lead"))
                .fluid()
                .components(Bismuth, 3, Lead, 6)
                .color(0x2f2d63)
                .build();

        SoftenedLead = new Material.Builder(8352, GTUtility.gregtechId("softened_lead"))
                .dust().fluid()
                .components(Lead, 1)
                .color(0x9874b0)
                .build();

        SodiumAntimonate = new Material.Builder(8353, GTUtility.gregtechId("sodium_antimonate"))
                .dust()
                .components(Sodium, 1, Antimony, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumArsenate = new Material.Builder(8354, GTUtility.gregtechId("sodium_arsenate"))
                .ingot().fluid()
                .components(Sodium, 3, Arsenic, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SodiumStannate = new Material.Builder(8355, GTUtility.gregtechId("sodium_stannate"))
                .dust()
                .components(Sodium, 2, Tin, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SaltyArsenicAcid = new Material.Builder(8356, GTUtility.gregtechId("salty_arsenic_acid"))
                .fluid()
                .components(Salt, 3, Hydrogen, 3, Arsenic, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SaltyArsenicPentoxide = new Material.Builder(8357, GTUtility.gregtechId("salty_arsenic_pentoxide"))
                .dust()
                .components(Salt, 6, Arsenic, 2, Oxygen, 5)
                .colorAverage()
                .build();

        TinIVOxide = new Material.Builder(8358, GTUtility.gregtechId("tin_iv_oxide"))
                .dust()
                .components(Tin, 1, Oxygen, 2)
                .colorAverage()
                .build();

        AntimonyVOxide = new Material.Builder(8359, GTUtility.gregtechId("antimony_v_oxide"))
                .dust()
                .components(Antimony, 2, Oxygen, 5)
                .colorAverage()
                .build();

        CassiteriteConcentrate = new Material.Builder(8360, GTUtility.gregtechId("cassiterite_concentrate"))
                .dust()
                .components(Cassiterite, 1)
                .colorAverage()
                .iconSet(SHINY)
                .build();

        CrudeTin = new Material.Builder(8361, GTUtility.gregtechId("crude_tin"))
                .fluid()
                .components(Tin, 1)
                .color(0xbfbfbf)
                .iconSet(DULL)
                .build();

        LeachedCassiteriteConcentrate = new Material.Builder(8362, GTUtility.gregtechId("leached_cassiterite_concentrate"))
                .dust()
                .components(Cassiterite, 1)
                .colorAverage()
                .iconSet(DULL)
                .build();

        AmmoniumTungstateSolution = new Material.Builder(8363, GTUtility.gregtechId("ammonium_tungstate_solution"))
                .fluid()
                .components(Nitrogen, 2, Hydrogen, 8, Tungsten, 1, Oxygen, 8, Water, 2)
                .colorAverage()
                .build();

        //AmmoniumTungstateSolution.setFormula("[(NH4)2WO4](H2O)2", true)

        CopperMonosulfide = new Material.Builder(8364, GTUtility.gregtechId("copper_monosulfide"))
                .dust()
                .components(Copper, 1, Sulfur, 1)
                .color(0x1a1817)
                .build();

        PotassiumSaltMixture = new Material.Builder(8365, GTUtility.gregtechId("potassium_salt_mixture"))
                .fluid()
                .components(Potassium, 1, Salt, 1)
                .colorAverage()
                .build();

        PotassiumSulfide = new Material.Builder(8366, GTUtility.gregtechId("potassium_sulfide"))
                .dust()
                .components(Potassium, 2, Sulfur, 1)
                .color(0xcbcfae)
                .build();

        WashedMagnesiumChlorideAmmoniate = new Material.Builder(8367, GTUtility.gregtechId("washed_magnesium_chloride_ammoniate"))
                .dust()
                .components(MagnesiumChloride, 1, Ammonia, 6)
                .colorAverage()
                .iconSet(SHINY)
                .build();

        SaturatedAmmoniacalMethanol = new Material.Builder(8368, GTUtility.gregtechId("saturated_ammoniacal_methanol"))
                .fluid()
                .components(Methanol, 2, Ammonia, 1)
                .colorAverage()
                .build();

        MagnesiumChlorideAmmoniate = new Material.Builder(8369, GTUtility.gregtechId("magnesium_chloride_ammoniate"))
                .dust()
                .components(MagnesiumChloride, 1, Ammonia, 6)
                .colorAverage()
                .build();

        PurifiedMagnesiumChloride = new Material.Builder(8370, GTUtility.gregtechId("purified_magnesium_chloride"))
                .dust().fluid()
                .components(MagnesiumChloride, 1)
                .color(0xd40d5c)
                .iconSet(SHINY)
                .build();
                
        BariumSulfide = new Material.Builder(8371, GTUtility.gregtechId("barium_sulfide"))
                .dust()
                .components(Barium, 1, Sulfur, 1)
                .colorAverage()
                .build();

        BariumChloride = new Material.Builder(8372, GTUtility.gregtechId("barium_chloride"))
                .dust()
                .components(Barium, 1, Chlorine, 2)
                .colorAverage()
                .build();

        BariumOxide = new Material.Builder(8373, GTUtility.gregtechId("barium_oxide"))
                .dust()
                .components(Barium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        BariumCarbonate = new Material.Builder(8374, GTUtility.gregtechId("barium_carbonate"))
                .dust()
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        IronPentacarbonyl = new Material.Builder(8375, GTUtility.gregtechId('iron_pentacarbonyl'))
                .fluid()
                .components(Iron, 1, Carbon, 5, Oxygen, 5)
                .color(0x8c180d)
                .build();

        //IronPentacarbonyl.setFormula('Fe(CO)5', true)

        IronTwoThreeOxide = new Material.Builder(8376, GTUtility.gregtechId('iron_two_three_oxide'))
                .dust()
                .color(0x141313)
                .components(Iron, 3, Oxygen, 4)
                .build()

        PurifiedIronTwoThreeOxide = new Material.Builder(8377, GTUtility.gregtechId('purified_iron_two_three_oxide'))
                .dust()
                .iconSet(SHINY)
                .color(0x141313)
                .components(Iron, 3, Oxygen, 4)
                .build()

        PurifiedIronIIIOxide = new Material.Builder(8378, GTUtility.gregtechId('purified_iron_iii_oxide'))
                .dust()
                .iconSet(SHINY)
                .color(0x8F0C03)
                .components(Iron, 2, Oxygen, 3)
                .build()

        NickelIIOxide = new Material.Builder(8379, GTUtility.gregtechId('nickel_ii_oxide'))
                .dust()
                .color(0x92a371)
                .components(Nickel, 1, Oxygen, 1)
                .build()

        CarbonTetrafluoride = new Material.Builder(8380, GTUtility.gregtechId('carbon_tetrafluoride'))
                .fluid(FluidTypes.GAS).plasma()
                .components(Carbon, 1, Fluorine, 4)
                .color(0xa81d1d)
                .build()

        NitrogenTrifluoride = new Material.Builder(8381, GTUtility.gregtechId('nitrogen_trifluoride'))
                .fluid(FluidTypes.GAS).plasma()
                .components(Nitrogen, 1, Chlorine, 3)
                .colorAverage()
                .build()

        CobaltFerrite = new Material.Builder(8382, GTUtility.gregtechId('cobalt_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Cobalt, 1, Iron, 2, Oxygen, 4)
                .colorAverage()
                .build()

        StrontiumFerrite = new Material.Builder(8383, GTUtility.gregtechId('strontium_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Strontium, 1, Iron, 12, Oxygen, 19)
                .colorAverage()
                .build()

        BariumFerrite = new Material.Builder(8384, GTUtility.gregtechId('barium_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Barium, 1, Iron, 12, Oxygen, 19)
                .colorAverage()
                .build()

        ManganeseZincFerrite = new Material.Builder(8385, GTUtility.gregtechId('manganese_zinc_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Manganese, 1, Zinc, 1, Iron, 4, Oxygen, 8)
                .colorAverage()
                .build()

        StrontiumCarbonate = new Material.Builder(8386, GTUtility.gregtechId('strontium_carbonate'))
                .dust()
                .components(Strontium, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build()

        BariumCarbonate = new Material.Builder(8387, GTUtility.gregtechId('barium_carbonate'))
                .dust()
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build()

        LeadOxide = new Material.Builder(8388, GTUtility.gregtechId('lead_oxide'))
                .dust()
                .components(Lead, 1, Oxygen, 1)
                .colorAverage()
                .build()

        TantalumNitride = new Material.Builder(8389, GTUtility.gregtechId('tantalum_nitride'))
                .dust()
                .components(Tantalum, 1, Nitrogen, 1)
                .colorAverage()
                .build()

        RutheniumIVOxide = new Material.Builder(8390, GTUtility.gregtechId('ruthenium_iv_oxide'))
                .dust()
                .components(Ruthenium, 1, Oxygen, 2)
                .colorAverage()
                .build()

        BismuthIridate = new Material.Builder(8391, GTUtility.gregtechId('bismuth_iridate'))
                .dust()
                .components(Bismuth, 2, Iridium, 2, Oxygen, 7)
                .colorAverage()
                .build()

        SodiumBismuthate = new Material.Builder(8392, GTUtility.gregtechId('sodium_bismuthate'))
                .dust()
                .components(Sodium, 1, Bismuth, 1, Oxygen, 3)
                .colorAverage()
                .build()

        BismuthIIIOxide = new Material.Builder(8393, GTUtility.gregtechId('bismuth_iii_oxide'))
                .dust()
                .components(Bismuth, 2, Oxygen, 3)
                .colorAverage()
                .build()

        ManganeseIINitrate = new Material.Builder(8394, GTUtility.gregtechId('manganese_ii_nitrate'))
                .dust()
                .components(Manganese, 1, Nitrogen, 2, Oxygen, 6)
                .colorAverage()
                .build()
                //.setFormula("Mn(NO3)2", true)

        PurifiedManganeseDioxide = new Material.Builder(8395, GTUtility.gregtechId('purified_manganese_dioxide'))
                .dust()
                .iconSet(SHINY)
                .components(Manganese, 1, Oxygen, 2)
                .colorAverage()
                .build()

        BariumTitanate = new Material.Builder(8396, GTUtility.gregtechId('barium_titanate'))
                .gem().iconSet(RUBY)
                .components(Barium, 1, Titanium, 1, Oxygen, 3)
                .colorAverage()
                .build()

        HafniumTetrachloride = new Material.Builder(8397, GTUtility.gregtechId('hafnium_tetrachloride'))
                .fluid()
                .fluidTemp(800)
                .components(Hafnium, 1, Chlorine, 4)
                .colorAverage()
                .build()

        ZirconiumTetrachloride = new Material.Builder(8398, GTUtility.gregtechId('zirconium_tetrachloride'))
                .dust().fluid(FluidTypes.GAS)
                .fluidTemp(800)
                .components(Zirconium, 1, Chlorine, 4)
                .colorAverage()
                .build()

        RawElectrum = new Material.Builder(8399, GTUtility.gregtechId("raw_electrum"))
                .ore()
                .color(0xfcf403)
                .components(Silver, 1, Gold, 1)
                .build();

        NeodymiumAlloy = new Material.Builder(8400, GTUtility.gregtechId("neodymium_alloy"))
                .ingot()
                .color(0x2b2a2a).iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE)
                .components(Neodymium, 2, Iron, 14, Boron, 1)
                .blastTemp(1297, GasTier.MID)
                .build();

        TreatedNeodymiumAlloy = new Material.Builder(8401, GTUtility.gregtechId("treated_neodymium_alloy"))
                .ingot()
                .color(0x2b2a2a).iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_WORKING)
                .components(NeodymiumAlloy, 1)
                .ingotSmeltInto(NeodymiumAlloy)
                .arcSmeltInto(NeodymiumAlloy)
                .macerateInto(NeodymiumAlloy)
                .build();

        NeodymiumAlloyMagnetic = new Material.Builder(8402, GTUtility.gregtechId("neodymium_alloy_magnetic"))
                .ingot()
                .color(0x2b2a2a).iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_WORKING, IS_MAGNETIC)
                .components(NeodymiumAlloy, 1)
                .ingotSmeltInto(NeodymiumAlloy)
                .arcSmeltInto(NeodymiumAlloy)
                .macerateInto(NeodymiumAlloy)
                .build();

        TreatedNeodymiumAlloy.getProperty(PropertyKey.INGOT).setMagneticMaterial(NeodymiumAlloyMagnetic);

        SamariumAlloy = new Material.Builder(8403, GTUtility.gregtechId("samarium_alloy"))
                .dust().ingot().fluid()
                .color(0xb3d683).iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_WORKING)
                .components(Samarium, 1, Cobalt, 5)
                .build();

        TreatedSamariumAlloy = new Material.Builder(8404, GTUtility.gregtechId("treated_samarium_alloy"))
                .ingot()
                .color(0xb3d683).iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_WORKING)
                .components(SamariumAlloy, 1)
                .ingotSmeltInto(SamariumAlloy)
                .arcSmeltInto(SamariumAlloy)
                .macerateInto(SamariumAlloy)
                .build();

        SamariumAlloyMagnetic = new Material.Builder(8405, GTUtility.gregtechId("samarium_alloy_magnetic"))
                .ingot()
                .color(0xb3d683).iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_WORKING, IS_MAGNETIC)
                .components(SamariumAlloy, 1)
                .ingotSmeltInto(SamariumAlloy)
                .arcSmeltInto(SamariumAlloy)
                .macerateInto(SamariumAlloy)
                .build();

        TreatedSamariumAlloy.getProperty(PropertyKey.INGOT).setMagneticMaterial(SamariumAlloyMagnetic);

        Trichlorosilane = new Material.Builder(8406, GTUtility.gregtechId('trichlorosilane'))
                .fluid()
                .components(Silicon, 1, Hydrogen, 1, Chlorine, 3)
                .color(0x769169)
                .build()

        Dichlorosilane = new Material.Builder(8407, GTUtility.gregtechId('dichlorosilane'))
                .fluid()
                .components(Silicon, 1, Hydrogen, 2, Chlorine, 2)
                .color(0x90ab84)
                .build()

        Chlorosilane = new Material.Builder(8408, GTUtility.gregtechId('chlorosilane'))
                .fluid()
                .components(Silicon, 1, Hydrogen, 3, Chlorine, 1)
                .color(0xa0ba95)
                .build()

        Silane = new Material.Builder(8409, GTUtility.gregtechId('silane'))
                .fluid(FluidTypes.GAS)
                .components(Silicon, 1, Hydrogen, 4)
                .color(0xbbd1b2)
                .build()

        NickelCarbonyl = new Material.Builder(8410, GTUtility.gregtechId('nickel_carbonyl'))
                .fluid()
                .components(Nickel, 1, Carbon, 4, Oxygen, 4)
                .colorAverage()
                .build()

        //NickelCarbonyl.setFormula("Ni(CO)4", true)

        ChloroaceticAnhydride = new Material.Builder(8411, GTUtility.gregtechId('chloroacetic_anhydride'))
                .dust()
                .components(Carbon, 4, Hydrogen, 4, Oxygen, 3, Chlorine, 2)
                .colorAverage()
                .build()

        ZirconiumDioxide = new Material.Builder(8412, GTUtility.gregtechId('zirconium_dioxide'))
                .dust()
                .components(Zirconium, 1, Oxygen, 2)
                .colorAverage()
                .build()

        CopperIINitrate = new Material.Builder(8413, GTUtility.gregtechId('copper_ii_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Copper, 1, Nitrogen, 2, Oxygen, 6)
                .color(0x292fe3)
                .build()

        //CopperIINitrate.setFormula("Cu(NO3)2", true)

        NickelIINitrate = new Material.Builder(8414, GTUtility.gregtechId('nickel_ii_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Nickel, 1, Nitrogen, 2, Oxygen, 6)
                .color(0x236359)
                .build()

        //NickelIINitrate.setFormula("Ni(NO3)2", true)

        ZincNitrate = new Material.Builder(8415, GTUtility.gregtechId('zinc_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Zinc, 1, Nitrogen, 2, Oxygen, 6)
                .color(0xdfe6cf)
                .build()

        //ZincNitrate.setFormula("Zn(NO3)2", true)

        MagnesiumNitrate = new Material.Builder(8416, GTUtility.gregtechId('magnesium_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Magnesium, 1, Nitrogen, 2, Oxygen, 6)
                .color(0xe8d8e3)
                .build()

        //MagnesiumNitrate.setFormula("Mg(NO3)2", true)

        YttriumOxide = new Material.Builder(8417, GTUtility.gregtechId('yttrium_oxide'))
                .dust()
                .components(Yttrium, 2, Oxygen, 3)
                .colorAverage()
                .build()

        NeodymiumOxide = new Material.Builder(8418, GTUtility.gregtechId('neodymium_oxide'))
                .dust()
                .components(Neodymium, 2, Oxygen, 3)
                .colorAverage()
                .build()

        Bromooctane = new Material.Builder(8419, GTUtility.gregtechId('bromooctane'))
                .fluid()
                .components(Carbon, 8, Hydrogen, 17, Bromine, 1)
                .colorAverage()
                .build()

        LithiumDioctylcopper = new Material.Builder(8420, GTUtility.gregtechId('lithium_dioctylcopper'))
                .fluid()
                .components(Carbon, 16, Hydrogen, 34, Copper, 1, Lithium, 1)
                .colorAverage()
                .build()

        DecanoylChloride = new Material.Builder(8421, GTUtility.gregtechId('decanoyl_chloride'))
                .fluid()
                .components(Carbon, 10, Hydrogen, 19, Chlorine, 1, Oxygen, 1)
                .colorAverage()
                .build()

        SodiumCyanoborohydride = new Material.Builder(8422, GTUtility.gregtechId('sodium_cyanoborohydride'))
                .dust()
                .components(Sodium, 1, Boron, 1, Hydrogen, 3, Carbon, 1, Nitrogen, 1)
                .colorAverage()
                .build()

        //SodiumCyanoborohydride.setFormula("Na[BH3(CN)]", true)

        DilutedSodiumHydroxideSolution = new Material.Builder(8423, GTUtility.gregtechId("diluted_sodium_hydroxide_solution"))
                .fluid()
                .components(Water, 2, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        DiethylEther = new Material.Builder(8424, GTUtility.gregtechId("diethyl_ether"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .color(0x2177ff)
                .build();

        //DiethylEther.setFormula("(C2H5)2O", true)

        Oleum = new Material.Builder(8425, GTUtility.gregtechId("oleum"))
                .fluid()
                .components(SulfuricAcid, 10, SulfurTrioxide, 1)
                .color(0xe8c3a5)
                .build();

        ChromiumSulfateSolution = new Material.Builder(8426, GTUtility.gregtechId("chromium_sulfate_solution"))
                .fluid()
                .components(Chrome, 4, Sulfur, 6, Oxygen, 24, Acetone, 1, Water, 9)
                .color(0x2c733a)
                .build();

        MustardGas = new Material.Builder(8427, GTUtility.gregtechId("mustard_gas"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 8, Chlorine, 2, Sulfur, 1)
                .color(0xcf7f3e)
                .build();

        Methyldichlorophosphine = new Material.Builder(8428, GTUtility.gregtechId("methyldichlorophosphine"))
                .fluid()
                .components(Carbon, 1, Hydrogen, 3, Chlorine, 2, Phosphorus, 1)
                .colorAverage()
                .build();

        SulfurylChloride = new Material.Builder(8429, GTUtility.gregtechId("sulfuryl_chloride"))
                .fluid()
                .components(Sulfur, 1, Oxygen, 2, Chlorine, 2)
                .colorAverage()
                .build();

        MethylphosphonylDichloride = new Material.Builder(8430, GTUtility.gregtechId("methylphosphonyl_dichloride"))
                .fluid()
                .components(Carbon, 1, Hydrogen, 3, Chlorine, 2, Oxygen, 1, Phosphorus, 1)
                .colorAverage()
                .build();

        MethylphosphonylDifluoride = new Material.Builder(8431, GTUtility.gregtechId("methylphosphonyl_difluoride"))
                .fluid()
                .components(Carbon, 1, Hydrogen, 3, Phosphorus, 1, Oxygen, 1, Fluorine, 2)
                .colorAverage()
                .build();

        Sarin = new Material.Builder(8432, GTUtility.gregtechId("sarin"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Fluorine, 1, Oxygen, 2, Phosphorus, 1)
                .colorAverage()
                .build();

        MethylDiethylphosphinate = new Material.Builder(8433, GTUtility.gregtechId("methyl_diethylphosphinate"))
                .fluid()
                .components(Carbon, 5, Hydrogen, 13, Oxygen, 2, Phosphorus, 1)
                .colorAverage()
                .build();

        DiisopropylaminoEthylEthylMethylphosphonite = new Material.Builder(8434, GTUtility.gregtechId("diisopropylamino_ethyl_ethyl_methylphosphonite"))
                .fluid()
                .components(Carbon, 11, Hydrogen, 26, Nitrogen, 1, Oxygen, 2, Phosphorus, 1)
                .colorAverage()
                .build();

        VX = new Material.Builder(8435, GTUtility.gregtechId("vx"))
                .fluid()
                .components(Carbon, 11, Hydrogen, 26, Nitrogen, 1, Oxygen, 2, Phosphorus, 1, Sulfur, 1)
                .colorAverage()
                .build();

        TitaniumEthoxide = new Material.Builder(8436, GTUtility.gregtechId("titanium_ethoxide"))
                .fluid()
                .components(Titanium, 4, Carbon, 32, Hydrogen, 80, Oxygen, 16)
                .colorAverage()
                .build();
      
        DilutedPhosphoricAcid = new Material.Builder(8437, GTUtility.gregtechId('diluted_phosphoric_acid'))
                .fluid()
                .components(PhosphoricAcid, 3, Water, 1)
                .colorAverage()
                .build()

        MonocalciumPhosphate = new Material.Builder(8438, GTUtility.gregtechId('monocalcium_phosphate'))
                .dust()
                .components(Calcium, 1, Hydrogen, 4, Phosphorus, 2, Oxygen, 8)
                .color(0xc2bc13)
                .iconSet(SAND)
                .build()

        //MonocalciumPhosphate.setFormula("Ca(H2PO4)2", true)

        CalciumPhosphite = new Material.Builder(8439, GTUtility.gregtechId('calcium_phosphite'))
                .dust()
                .components(Calcium, 3, Phosphorus, 2, Oxygen, 6)
                .color(0xa2a832)
                .iconSet(CERTUS)
                .build()

        SulfurTrioxideReactionMixture = new Material.Builder(8440, GTUtility.gregtechId('sulfur_trioxide_reaction_mixture'))
                .fluid()
                .components(SulfurDioxide, 1, Oxygen, 1)
                .colorAverage()
                .build()

        CalciumMetasilicate = new Material.Builder(8441, GTUtility.gregtechId('calcium_metasilicate'))
                .dust()
                .components(Calcium, 1, Silicon, 1, Oxygen, 3)
                .colorAverage()
                .build()

        HighPurityPhosphorusVaporMixture = new Material.Builder(8442, GTUtility.gregtechId('high_purity_phosphorus_vapor_mixture'))
                .fluid(FluidTypes.GAS)
                .components(Phosphorus, 4, Water, 1)
                .fluidTemp(554)
                .colorAverage()
                .build()
                //.setFormula("P4", true);

        PotassiumAmylXanthate = new Material.Builder(8443, GTUtility.gregtechId('potassium_amyl_xanthate'))
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Potassium, 1, Oxygen, 1, Sulfur, 2)
                .colorAverage()
                .build()

        GoldAmalgam = new Material.Builder(8444, GTUtility.gregtechId("gold_amalgam"))
                .fluid()
                .components(Gold, 1, Mercury, 1)
                .colorAverage()
                .build();

        HotSulfuricAcid = new Material.Builder(8445, GTUtility.gregtechId('hot_sulfuric_acid'))
                .fluid()
                .fluidTemp(353)
                .components(Hydrogen, 2, Sulfur, 1, Oxygen, 4)
                .color(0xff570f)
                .build()

        CadmiumSulfateSolution = new Material.Builder(8446, GTUtility.gregtechId('cadmium_sulfate_solution'))
                .fluid()
                .components(Water, 1, Cadmium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()

        MercuryOxide = new Material.Builder(8447, GTUtility.gregtechId('mercury_oxide'))
                .dust()
                .components(Mercury, 1, Oxygen, 1)
                .colorAverage()
                .build()

        IndiumChloride = new Material.Builder(8448, GTUtility.gregtechId('indium_chloride'))
                .dust()
                .components(Indium, 1, Chlorine, 3)
                .colorAverage()
                .build()

        IndiumHydroxide = new Material.Builder(8449, GTUtility.gregtechId('indium_hydroxide'))
                .dust()
                .components(Indium, 1, Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .build()

        //IndiumHydroxide.setFormula("In(OH)3", true)

        TitaniumDioxide = new Material.Builder(8450, GTUtility.gregtechId('titanium_dioxide'))
                .dust()
                .components(Titanium, 1, Oxygen, 2)
                .color(0xffffff)
                .iconSet(SHINY)
                .build()

        IndiumOxide = new Material.Builder(8451, GTUtility.gregtechId('indium_oxide'))
                .dust()
                .components(Indium, 2, Oxygen, 3)
                .colorAverage()
                .build()

        EthanolWaterAzeotrope = new Material.Builder(8452, GTUtility.gregtechId('ethanol_water_azeotrope'))
                .fluid()
                .components(Ethanol, 91, Water, 9)
                .color(0xad552f)
                .build();

        EntrainedEthanolWaterAzeotrope = new Material.Builder(8453, GTUtility.gregtechId('entrained_ethanol_water_azeotrope'))
                .fluid()
                .components(Ethanol, 91, Water, 9, Toluene, 10)
                .colorAverage()
                .build();

        CalciumSulfite = new Material.Builder(8454, GTUtility.gregtechId('calcium_sulfite'))
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SilicaGel = new Material.Builder(8455, GTUtility.gregtechId('silica_gel'))
                .dust()
                .iconSet(SHINY)
                .components(Silicon, 1, Oxygen, 2)
                .color(0x6d6e63)
                .build();

        WetSilicaGel = new Material.Builder(8456, GTUtility.gregtechId('wet_silica_gel'))
                .dust()
                .components(Silicon, 1, Oxygen, 2)
                .color(0x585950)
                .build();

        PhosphoricAcidSilicaGel = new Material.Builder(8457, GTUtility.gregtechId('phosphoric_acid_silica_gel'))
                .dust()
                .iconSet(SHINY)
                .components(SilicaGel, 1, PhosphoricAcid, 1)
                .colorAverage()
                .build();

        SodiumChromateMixture = new Material.Builder(8458, GTUtility.gregtechId('sodium_chromate_mixture'))
                .dust()
                .components(Sodium, 1, Chrome, 1, Oxygen, 4, SodaAsh, 1)
                .color(0xfaff7d)
                .build();

        SodiumChromateSolution = new Material.Builder(8459, GTUtility.gregtechId('sodium_chromate_solution'))
                .fluid()
                .components(Sodium, 1, Chrome, 1, Oxygen, 4, Water, 1)
                .color(0xa4a839)
                .build();

        LeadChloride = new Material.Builder(8460, GTUtility.gregtechId('lead_chloride'))
                .dust().fluid()
                .components(Lead, 1, Chlorine, 2)
                .colorAverage()
                .build();

        SodiumVanadate = new Material.Builder(8461, GTUtility.gregtechId('sodium_vanadate'))
                .dust()
                .components(Sodium, 1, Vanadium, 1, Oxygen, 3)
                .colorAverage()
                .build();

        AmmoniumMetavanadate = new Material.Builder(8462, GTUtility.gregtechId('ammonium_metavanadate'))
                .dust()
                .components(Nitrogen, 1, Hydrogen, 4, Vanadium, 1, Oxygen, 3)
                .colorAverage()
                .build();

        CobaltAluminate = new Material.Builder(8463, GTUtility.gregtechId('cobalt_aluminate'))
                .dust()
                .iconSet(SHINY)
                .components(Cobalt, 1, Aluminium, 2, Oxygen, 4)
                .color(0x1605ff)
                .build();

        LeadNitrate = new Material.Builder(8464, GTUtility.gregtechId('lead_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Lead, 1, Nitrogen, 2, Oxygen, 6)
                .color(0xffffff)
                .build();

        //LeadNitrate.setFormula('Pb(NO3)2', true)

        AmmoniumChromeAlum = new Material.Builder(8465, GTUtility.gregtechId("ammonium_chrome_alum"))
                .dust()
                .components(Nitrogen, 1, Hydrogen, 4, Chrome, 1, Sulfur, 2, Oxygen, 8)
                .color(0x4e1554)
                .iconSet(SHINY)
                .build();

        //AmmoniumChromeAlum.setFormula("NH4Cr(SO4)2", true)

        AmmoniumIronIISulfate = new Material.Builder(8466, GTUtility.gregtechId("ammonium_iron_ii_sulfate"))
                .dust()
                .components(Iron, 1, Nitrogen, 2, Hydrogen, 8, Sulfur, 2, Oxygen, 8)
                .color(0x70cc6e)
                .iconSet(SHINY)
                .build();

        //AmmoniumIronIISulfate.setFormula("Fe(NH4)2(SO4)2", true)

        ElectrolyticChromium = new Material.Builder(8467, GTUtility.gregtechId("electrolytic_chromium"))
                .dust().fluid()
                .components(Chrome, 1)
                .colorAverage()
                .iconSet(SAND)
                .build();

        IronIIHydroxide = new Material.Builder(8468, GTUtility.gregtechId("iron_ii_hydroxide"))
                .dust()
                .components(Iron, 1, Oxygen, 2, Hydrogen, 2)
                .color(0x072406)
                .build();

        //IronIIHydroxide.setFormula("Fe(OH)2", true)

        SodiumAmide = new Material.Builder(8469, GTUtility.gregtechId('sodium_amide'))
                .dust()
                .components(Sodium, 1, Nitrogen, 1, Hydrogen, 2)
                .colorAverage()
                .build();

        LeadChromate = new Material.Builder(8470, GTUtility.gregtechId('lead_chromate'))
                .dust()
                .iconSet(SHINY)
                .components(Lead, 1, Chrome, 1, Oxygen, 4)
                .color(0xfffb00)
                .build();

        IronIIOxide = new Material.Builder(8471, GTUtility.gregtechId("iron_ii_oxide"))
                .dust()
                .components(Iron, 1, Oxygen, 1)
                .color(0x1c1c1c)
                .build();

        GalliumTrioxide = new Material.Builder(8472, GTUtility.gregtechId("gallium_trioxide"))
                .dust()
                .components(Gallium, 2, Oxygen, 3)
                .colorAverage()
                .build();

        AmmoniumDihydrogenPhosphate = new Material.Builder(8473, GTUtility.gregtechId("ammonium_dihydrogen_phosphate"))
                .dust()
                .components(Hydrogen, 6, Nitrogen, 1, Oxygen, 4, Phosphorus, 1)
                .colorAverage()
                .build();

        //AmmoniumDihydrogenPhosphate.setFormula("NH4H2PO4", true)

        AluminiumCarbonate = new Material.Builder(8474, GTUtility.gregtechId("aluminium_carbonate"))
                .dust()
                .components(Aluminium, 2, Carbon, 3, Oxygen, 9)
                .colorAverage()
                .build();

        //AluminiumCarbonate.setFormula("Al2(CO3)3", true)

        IronCarbonate = new Material.Builder(8475, GTUtility.gregtechId("iron_carbonate"))
                .dust()
                .components(Iron, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        AmmoniumDiuranate = new Material.Builder(8477, GTUtility.gregtechId("ammonium_diuranate"))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen, 2, Hydrogen, 8, Uranium235, 2, Oxygen, 7)
                .color(0xe6be22)
                .build();

        //AmmoniumDiuranate.setFormula("(NH4)2U2O7", true)

        MagnesiumCarbonate = new Material.Builder(8478, GTUtility.gregtechId("magnesium_carbonate"))
                .dust()
                .components(Magnesium, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumLeadAlloy = new Material.Builder(8479, GTUtility.gregtechId("sodium_lead_alloy"))
                .ingot()
                .components(Sodium, 1, Lead, 1)
                .colorAverage()
                .build();

        Tetraethyllead = new Material.Builder(8480, GTUtility.gregtechId("tetraethyllead"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 20, Lead, 1)
                .colorAverage()
                .build();

        //Tetraethyllead.setFormula("Pb(CH3CH2)4", true)

        TertButylHydroperoxide = new Material.Builder(8481, GTUtility.gregtechId("tert_butyl_hydroperoxide"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .build();

        //TertButylHydroperoxide.setFormula("(CH3)3COOH", true)

        DiTertButylPeroxide = new Material.Builder(8482, GTUtility.gregtechId("di_tert_butyl_peroxide"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 2)
                .colorAverage()
                .build();

        //DiTertButylPeroxide.setFormula("(CH3)3COOC(CH3)3", true)

        TwoEthylhexylNitrate = new Material.Builder(8483, GTUtility.gregtechId("two_ethylhexyl_nitrate"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 17, Nitrogen, 1, Oxygen, 3)
                .colorAverage()
                .build();

        Nitromethane = new Material.Builder(8484, GTUtility.gregtechId("nitromethane"))
                .fluid()
                .components(Carbon, 1, Hydrogen, 3, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .build();

        RutileConcentrate = new Material.Builder(8485, GTUtility.gregtechId("rutile_concentrate"))
                .dust()
                .components(Rutile, 1)
                .color(0x503f3e)
                .build();

        //RutileConcentrate.setFormula("(TiO2)(?)", true);

        UltramaficTailingSlurry = new Material.Builder(8486, GTUtility.gregtechId("ultramafic_tailing_slurry"))
                .fluid()
                .components(Water, 1, UltramaficTailings, 1)
                .color(0x878170)
                .build();

        RutileSlurry = new Material.Builder(8487, GTUtility.gregtechId("rutile_slurry"))
                .fluid()
                .components(Rutile, 1, Water, 1)
                .color(0xe8e6e2)
                .build();

        //RutileSlurry.setFormula("(H2O)(TiO2)(?)", true);

        ImpureTitaniumTetrachloride = new Material.Builder(8488, GTUtility.gregtechId("impure_titanium_tetrachloride"))
                .fluid()
                .components(TitaniumTetrachloride, 1)
                .color(0x54474a)
                .build();

        //ImpureTitaniumTetrachloride.setFormula("(TiCl4)(?)", true);

        DistilledTitaniumTetrachloride = new Material.Builder(8489, GTUtility.gregtechId("distilled_titanium_tetrachloride"))
                .fluid()
                .components(TitaniumTetrachloride, 1)
                .color(0x8c6c73)
                .build();

        //DistilledTitaniumTetrachloride.setFormula("(TiCl4)(?)", true);

        VanadiumFreeTitaniumTetrachloride = new Material.Builder(8490, GTUtility.gregtechId("vanadium_free_titanium_tetrachloride"))
                .fluid()
                .components(TitaniumTetrachloride, 1)
                .color(0xa16270)
                .build();

        //VanadiumFreeTitaniumTetrachloride.setFormula("(TiCl4)(?)", true);

        VanadiumOxydichloride = new Material.Builder(8491, GTUtility.gregtechId("vanadium_oxydichloride"))
                .dust()
                .components(Vanadium, 1, Oxygen, 1, Chlorine, 2)
                .color(0x1c1294)
                .build();

        VanadiumOxytrichloride = new Material.Builder(8492, GTUtility.gregtechId("vanadium_oxytrichloride"))
                .fluid()
                .components(Vanadium, 1, Oxygen, 1, Chlorine, 3)
                .color(0xbda51b)
                .build();

        GaseousIronIIIChloride = new Material.Builder(8493, GTUtility.gregtechId("gaseous_iron_iii_chloride"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(590)
                .components(Iron3Chloride, 1)
                .color(0xba8f49)
                .build();

        GaseousTitaniumTetrachloride = new Material.Builder(8494, GTUtility.gregtechId("gaseous_titanium_tetrachloride"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(1180)
                .components(TitaniumTetrachloride, 1)
                .color(0x8f4064)
                .build();

        TinTetrachloride = new Material.Builder(8495, GTUtility.gregtechId("tin_tetrachloride"))
                .fluid()
                .components(Tin, 1, Chlorine, 4)
                .color(0x887866)
                .build();

        GaseousAluminiumTrichloride = new Material.Builder(8496, GTUtility.gregtechId("gaseous_aluminium_trichloride"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(460)
                .components(AluminiumTrichloride, 1)
                .colorAverage()
                .build();

        SodiumBisphenolateSolution = new Material.Builder(8497, GTUtility.gregtechId("sodium_bisphenolate_solution"))
                .fluid()
                .components(SodiumHydroxide, 2, BisphenolA, 1, Water, 2)
                .colorAverage()
                .build();

        Polycarbonate = new Material.Builder(8498, GTUtility.gregtechId("polycarbonate"))
                .polymer()
                .flags(GENERATE_PLATE)
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 3)
                .color(0xa1cacf)
                .iconSet(SHINY)
                .build();

        //Polycarbonate.setFormula("C16H14O3", true)

        SodiumNitrite = new Material.Builder(8499, GTUtility.gregtechId("sodium_nitrite"))
                .dust()
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 2)
                .color(0xe7e899)
                .build();

        SodiumOxide = new Material.Builder(8500, GTUtility.gregtechId("sodium_oxide"))
                .dust()
                .components(Sodium, 2, Oxygen, 1)
                .colorAverage()
                .build();

        HexachloroplatinicAcidSolution = new Material.Builder(8501, GTUtility.gregtechId("hexachloroplatinic_acid_solution"))
                .fluid()
                .components(Hydrogen, 2, Platinum, 1, Chlorine, 6, Water, 1)
                .color(0xe06624)
                .build();

        SodiumHexachloroplatinateSolution = new Material.Builder(8502, GTUtility.gregtechId("sodium_hexachloroplatinate_solution"))
                .fluid()
                .components(Sodium, 2, Platinum, 1, Chlorine, 6, Water, 5)
                .color(0xb87627)
                .build();
        
        AmmoniumHexachloroplatinate = new Material.Builder(8503, GTUtility.gregtechId("ammonium_hexachloroplatinate"))
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .color(0xe6c532)
                .build();

        //AmmoniumHexachloroplatinate.setFormula("(NH4)2PtCl6", true)

        DilutedCopperSulfateSolution = new Material.Builder(8504, GTUtility.gregtechId("diluted_copper_sulfate_solution"))
                .fluid()
                .components(CopperSulfate, 2, Water, 3)
                .colorAverage()
                .build();

        NickelSulfateSolution = new Material.Builder(8505, GTUtility.gregtechId("nickel_sulfate_solution"))
                .fluid()
                .components(Nickel, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .color(0x38add1)
                .build();

        MercuryIICyanide = new Material.Builder(8506, GTUtility.gregtechId("mercury_ii_cyanide"))
                .dust()
                .components(Mercury, 1, Carbon, 2, Nitrogen, 2)
                .colorAverage()
                .build();

        //MercuryIICyanide.setFormula("Hg(CN)2", true)

        PalladiumIICyanide = new Material.Builder(8507, GTUtility.gregtechId("palladium_ii_cyanide"))
                .dust()
                .components(Palladium, 1, Carbon, 2, Nitrogen, 2)
                .color(0x787a7a)
                .build();

        //PalladiumIICyanide.setFormula("Pd(CN)2", true)

        AluminiumNitride = new Material.Builder(8508, GTUtility.gregtechId("aluminium_nitride"))
                .dust()
                .components(Aluminium, 1, Nitrogen, 1)
                .colorAverage()
                .build();

        AluminiumOxynitride = new Material.Builder(8509, GTUtility.gregtechId("aluminium_oxynitride"))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Aluminium, 23, Oxygen, 27, Nitrogen, 5)
                .color(0xc7dfed)
                .iconSet(GLASS)
                .build();

        UltraHighMolecularWeightPolyethylene = new Material.Builder(8510, GTUtility.gregtechId("ultra_high_molecular_weight_polyethylene"))
                .polymer()
                .flags(GENERATE_PLATE)
                .components(Carbon, 2, Hydrogen, 4)
                .color(0xc5e3de)
                .iconSet(SHINY)
                .build();

        AntimonyTrichloride = new Material.Builder(8511, GTUtility.gregtechId("antimony_trichloride"))
                .dust().fluid()
                .components(Antimony, 1, Chlorine, 3)
                .colorAverage()
                .build();

        AntimonyPentachloride = new Material.Builder(8512, GTUtility.gregtechId("antimony_pentachloride"))
                .fluid()
                .components(Antimony, 1, Chlorine, 5)
                .colorAverage()
                .build();

        Trichlorofluoromethane = new Material.Builder(8513, GTUtility.gregtechId("trichlorofluoromethane"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Chlorine, 3, Fluorine, 1)
                .color(0xeb6a6a)
                .build();

        Dichlorodifluoromethane = new Material.Builder(8514, GTUtility.gregtechId("dichlorodifluoromethane"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Chlorine, 2, Fluorine, 2)
                .color(0xd14d4d)
                .build();

        Chlorotrifluoromethane = new Material.Builder(8515, GTUtility.gregtechId("chlorotrifluoromethane"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Chlorine, 1, Fluorine, 3)
                .color(0xbf3232)
                .build();

        Chlorodifluoromethane = new Material.Builder(8516, GTUtility.gregtechId("chlorodifluoromethane"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Hydrogen, 1, Chlorine, 1, Fluorine, 2)
                .colorAverage()
                .build();
    }
}