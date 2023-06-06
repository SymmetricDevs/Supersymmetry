package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

public class FirstDegreeMaterials{

    private static void generatePurifiedElement(Material material, int id, boolean generateLiquid, boolean generateIngot) {
        var color = material.materialRGB;

        if (generateLiquid) {
            new Material.Builder(id, "high_purity_" + material.toString())
                    .dust().fluid()
                    .iconSet(SHINY)
                    .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();
        } else if(generateIngot) {
            new Material.Builder(id, "high_purity_" + material.toString())
                    .dust().ingot()
                    .iconSet(SHINY)
                    .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();
        } else if(generateLiquid & generateIngot) {
            new Material.Builder(id, "high_purity_" + material.toString())
                    .dust().ingot().fluid()
                    .iconSet(SHINY)
                    .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();
        } else {
            new Material.Builder(id, "high_purity_" + material.toString())
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
        generatePurifiedElement(Phosphorus, 8008, false, false)
        generatePurifiedElement(Sulfur, 8009, false, false)
        generatePurifiedElement(Potassium, 8010, false, false)
        generatePurifiedElement(Calcium, 8011, false, false)
        generatePurifiedElement(Scandium, 8012, false, false)
        generatePurifiedElement(Titanium, 8013, false, false)
        generatePurifiedElement(Vanadium, 8014, false, false)
        generatePurifiedElement(Chrome, 8015, false, false)
        generatePurifiedElement(Manganese, 8016, false, false)
        generatePurifiedElement(Iron, 8017, false, false)
        generatePurifiedElement(Cobalt, 8018, false, false)
        generatePurifiedElement(Nickel, 8019, false, false)
        generatePurifiedElement(Copper, 8020, false, false)
        generatePurifiedElement(Zinc, 8021, false, false)
        generatePurifiedElement(Gallium, 8022, true, false)
        generatePurifiedElement(Germanium, 8023, false, false)
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
        generatePurifiedElement(Gold, 8053, false, false)
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

        CalciumHydroxide = new Material.Builder(8100, 'calcium_hydroxide')
                .dust()
                .components(Calcium, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()
                .setFormula("Ca(OH)2", true);

        PotassiumHydroxide = new Material.Builder(8101, 'potassium_hydroxide')
                .dust()
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        PotassiumCarbonate =  new Material.Builder(8102, 'potassium_carbonate')
                .dust()
                .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumSilicate =  new Material.Builder(8103, 'sodium_silicate')
                .dust()
                .components(Sodium, 2, Silicon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumAluminate =  new Material.Builder(8104, 'sodium_aluminate')
                .dust()
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        PotassiumBisulfate = new Material.Builder(8105, 'potassium_bisulfate')
                .dust().fluid()
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        AmmoniumNitrate = new Material.Builder(8107, 'ammonium_nitrate')
                .dust()
                .components(Nitrogen, 2, Oxygen, 3, Hydrogen, 4)
                .colorAverage()
                .build()
                .setFormula("NH4NO3", true);

        AmmoniumSulfate = new Material.Builder(8108, 'ammonium_sulfate')
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SodiumNitrate = new Material.Builder(8109, 'sodium_nitrate')
                .dust()
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumFluoride = new Material.Builder(8110, 'sodium_fluoride')
                .fluid().dust()
                .components(Sodium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        PotassiumFluoride = new Material.Builder(8111, 'potassium_fluoride')
                .fluid().dust()
                .components(Potassium, 1, Fluorine, 1)
                .colorAverage()
                .build();
                
        PotassiumTetrafluoroborate = new Material.Builder(8112, 'potassium_tetrafluoroborate')
                .fluid().dust()
                .components(Potassium, 1, Boron, 1, Fluorine, 4)
                .color(0x8fb5a3)
                .build();

        SodiumBromide = new Material.Builder(8113, 'sodium_bromide')
                .dust()
                .components(Sodium, 1, Bromine, 1)
                .colorAverage()
                .build();

        Fluix = new Material.Builder(8114, 'fluix')
                .gem().iconSet(RUBY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_LENS)
                .components(Quartzite, 4, Naquadah, 1)
                .color(0x6503b6)
                .build();

        PigIron = new Material.Builder(8115, 'pig_iron')
                .ingot().dust()
                .flags(GENERATE_PLATE)
                .color(0x99918A)
                .build();

        GreenCoke = new Material.Builder(8116, "green_coke")
                .gem(1, 2000).ore(2, 1)
                .color(0x424a34).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        IronIIISulfate = new Material.Builder(8117, 'iron_iii_sulfate')
                .dust()
                .color(0xb09d99)
                .components(Iron, 2, Sulfur, 3, Oxygen, 12)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .build()
                .setFormula("Fe2(SO4)3", true);

        AluminiumHydroxide = new Material.Builder(8118, 'aluminium_hydroxide')
                .dust()
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .build()
                .setFormula("Al(OH)3", true);

        AluminiumTrifluoride = new Material.Builder(8119, 'aluminium_trifluoride')
                .dust()
                .components(Aluminium, 1, Fluorine, 3)
                .color(0x3d98bf)
                .build()

        GalliumPhosphate = new Material.Builder(8120, 'gallium_phosphate')
                .gem().iconSet(RUBY)
                .components(Gallium, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        LithiumNiobate = new Material.Builder(8121, 'lithium_niobate')
                .gem().iconSet(RUBY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 3)
                .colorAverage()
                .build()

        LeadZirconateTitanite = new Material.Builder(8122, 'lead_zirconate_titanate')
                .gem().iconSet(RUBY)
                .components(Lead, 2, Zirconium, 1, Titanium, 1, Oxygen, 6)
                .colorAverage()
                .build()

        BoricAcid = new Material.Builder(8123, 'boric_acid')
                .dust()
                .color(0xedece8)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build()

        AmorphousBoron = new Material.Builder(8124, 'amorphous_boron')
                .dust()
                .color(0x47464b)
                .build()

        SulfurDichloride = new Material.Builder(8125, 'sulfur_dichloride')
                .fluid()
                .components(Sulfur, 1, Chlorine, 2)
                .color(0xd2042d)
                .build()

        BoronTrioxide = new Material.Builder(8126, 'boron_trioxide')
                .dust().fluid()
                .color(0xdfcfc2)
                .components(Boron, 2, Oxygen, 3)
                .build()

        ZincChloride = new Material.Builder(8127, 'zinc_chloride')
                .dust().fluid()
                .components(Zinc, 1, Chlorine, 2)
                .colorAverage()
                .build()

        SodiumTetraborate = new Material.Builder(8128, 'sodium_tetraborate')
                .dust()
                .components(Sodium, 2, Boron, 4, Oxygen, 7)
                .color(0xdbe7db)
                .build()

        ElectrolyticBoron = new Material.Builder(8129, 'electrolytic_boron')
                .dust()
                .components(Boron, 1)
                .color(0x9bd4af)
                .build()

        CalciumSulfate = new Material.Builder(8130, 'calcium_sulfate')
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        IronIISulfide = new Material.Builder(8131, 'iron_ii_sulfide')
                .dust()
                .components(Iron, 1, Sulfur, 1)
                .colorAverage()
                .build();

        PotassiumSulfate = new Material.Builder(8132, 'potassium_sulfate')
                .dust()
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        WetAntimonyTrifluoride = new Material.Builder(8133, 'wet_antimony_trifluoride')
                .dust()
                .components(Antimony, 1, Fluorine, 3)
                .colorAverage()
                .build();

        CalciumSulfide = new Material.Builder(8134, 'calcium_sulfide')
                .dust()
                .components(Calcium, 1, Sulfur, 1)
                .colorAverage()
                .build();

        CalciumSulfate = new Material.Builder(8135, 'calcium_sulfate')
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        VanadiumPentoxide = new Material.Builder(8136, 'vanadium_pentoxide')
                .dust()
                .components(Vanadium, 2, Oxygen, 5)
                .colorAverage()
                .build();

        PotassiumPersulfate = new Material.Builder(8137, 'potassium_persulfate')
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .build();

        LithiumHydroxide = new Material.Builder(8138, 'lithium_hydroxide')
                .dust()
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        CalciumCarbide = new Material.Builder(8139, 'calcium_carbide')
                .dust()
                .components(Calcium, 1, Carbon, 2)
                .colorAverage()
                .build();

        IronIIChloride = new Material.Builder(8140, 'iron_ii_chloride')
                .dust()
                .components(Iron, 1, Chlorine, 2)
                .color(0x9dad37)
                .build()

        CuprousOxide = new Material.Builder(8141, 'cuprous_oxide')
                .dust()
                .components(Copper, 2, Oxygen, 1)
                .color(0x822635)
                .build()

        LithiumBromide = new Material.Builder(8142, 'lithium_bromide')
                .dust()
                .components(Lithium, 1, Bromine, 1)
                .color(0xC5C5C5)
                .build()

        IronIIIOxide = new Material.Builder(8143, 'iron_iii_oxide')
                .dust()
                .components(Iron, 2, Oxygen, 3)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8F0C03)
                .build()

        CopperIIChloride = new Material.Builder(8144, 'copper_ii_chloride')
                .dust()
                .components(Copper, 1, Chlorine, 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x12112c)
                .build()

        SiliconCarbide = new Material.Builder(8145, 'silicon_carbide')
                .dust()
                .components(Silicon, 1, Carbon, 1)
                .color(0x404040)
                .build()

        TungstenTrioxide = new Material.Builder(8146, 'tungsten_trioxide')
                .dust()
                .components(Tungsten, 1, Oxygen, 3)
                .color(0x8a9734)
                .build()

        Alumina = new Material.Builder(8147, 'alumina')
                .dust()
                .components(Aluminium, 2, Oxygen, 3)
                .color(0xd0cff7)
                .build()

        BoronCarbide = new Material.Builder(8148, 'boron_carbide')
                .dust()
                .components(Boron, 4, Carbon, 1)
                .flags(GENERATE_ROD)
                .colorAverage()
                .build()

        SilverChloride = new Material.Builder(8149, 'silver_chloride')
                .dust()
                .components(Silver, 1, Chlorine, 1)
                .colorAverage()
                .build()

        ArsenicIIISulfide = new Material.Builder(8150, 'arsenic_iii_sulfide')
                .dust()
                .components(Arsenic, 2, Sulfur, 3)
                .colorAverage()
                .build()

        SodiumArsenide = new Material.Builder(8151, 'sodium_arsenide')
                .dust()
                .components(Sodium, 3, Arsenic, 1)
                .colorAverage()
                .build()

        ArsenicVSulfide = new Material.Builder(8152, 'arsenic_v_sulfide')
                .dust()
                .components(Arsenic, 2, Sulfur, 5)
                .colorAverage()
                .build()

        CopperSulfate = new Material.Builder(8153, 'copper_sulfate')
                .dust()
                .components(Copper, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()

        RoastedSperrylite = new Material.Builder(8154, 'roasted_sperrylite')
                .dust()
                .components(Platinum, 1)
                .color(0x3b1754)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SAND)
                .build();

        EnargiteResidue = new Material.Builder(8155, 'enargite_residue')
                .dust()
                .components(Copper, 2, Sulfur, 1)
                .color(0x59183c)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(BRIGHT)
                .build()
                .setFormula("(?)Cu2S", true);

        HydrogenChloride = new Material.Builder(8156, "hydrogen_chloride")
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Chlorine, 1)
                .colorAverage()
                .build();

        HydrogenFluoride = new Material.Builder(8157, "hydrogen_fluoride")
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Fluorine, 1)
                .colorAverage()
                .build();

        DilutedSaltwater = new Material.Builder(8158, "diluted_saltwater")
                .fluid()
                .components(Water, 2, Salt, 1)
                .color(0x3d61b8)
                .build();

        SodiumHydroxideSolution = new Material.Builder(8159, "sodium_hydroxide_solution")
                .fluid()
                .components(Water, 1, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        IronIIIChlorideSolution = new Material.Builder(8160, "iron_iii_chloride_solution")
                .fluid()
                .components(Water, 1, Iron3Chloride, 1)
                .colorAverage()
                .build();

        DiluteSaltpeterSolution = new Material.Builder(8161, 'dilute_saltpeter_solution')
                .fluid()
                .components(Water, 2, Saltpeter, 1)
                .colorAverage()
                .build();

        HydrogenBromide = new Material.Builder(8162, 'hydrogen_bromide')
                .fluid()
                .components(Hydrogen, 1, Bromine, 1)
                .colorAverage()
                .build();

        DiluteCalciumChlorideSolution = new Material.Builder(8163, "dilute_calcium_chloride_solution")
                .fluid()
                .components(Water, 2, CalciumChloride, 1)
                .colorAverage()
                .build();

        DiluteRockSaltSolution = new Material.Builder(8164, "dilute_rock_salt_solution")
                .fluid()
                .components(Water, 2, RockSalt, 1)
                .colorAverage()
                .build();

        DryCarbonMonoxide = new Material.Builder(8165, "dry_carbon_monoxide")
                .fluid(FluidTypes.GAS)
                .components(CarbonMonoxide, 1)
                .color(0x202329)
                .build();

        AmmoniaSolution = new Material.Builder(8166, "ammonia_solution")
                .fluid()
                .components(Water, 1, Ammonia, 1)
                .colorAverage()
                .build();

        SaltpeterSolution = new Material.Builder(8167, 'saltpeter_solution')
                .fluid()
                .components(Water, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        SaltySaltpeterSolution = new Material.Builder(8168, 'salty_saltpeter_solution')
                .fluid()
                .components(SaltWater, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        CarbonDisulfide = new Material.Builder(8169, 'carbon_disulfide')
                .fluid()
                .components(Carbon, 1, Sulfur, 2)
                .colorAverage()
                .build();

        HighPressureWater = new Material.Builder(8170, "high_pressure_water")
                .fluid()
                .colorAverage()
                .components(Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Cryolite = new Material.Builder(8171, "cryolite")
                .fluid().dust()
                .components(Sodium, 3, Aluminium, 1, Fluorine, 6)
                .color(0x2497a6)
                .build();

        EthanolSolution = new Material.Builder(8172, "ethanol_solution")
                .fluid()
                .components(Ethanol, 1, PhosphoricAcid, 1)
                .colorAverage()
                .build();

        HeavyWater = new Material.Builder(8173, "heavy_water")
                .fluid()
                .components(Deuterium, 2, Oxygen, 1)
                .color(0x2c37b0)
                .build();

        HeavyHydrogenSulfide = new Material.Builder(8174, "heavy_hydrogen_sulfide")
                .fluid()
                .components(Deuterium, 2, Sulfur, 1)
                .color(0xb09a2c)
                .build();

        SemiHeavyHydrogenSulfide = new Material.Builder(8175, "semiheavy_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Deuterium, 1, Sulfur, 1)
                .color(0xc29836)
                .build();

        SemiHeavyWater = new Material.Builder(8176, "semiheavy_water")
                .fluid()
                .components(Hydrogen, 1, Deuterium, 1, Oxygen, 1)
                .color(0x364ec2)
                .build();

        ImpureSemiheavyWater = new Material.Builder(8177, "impure_semiheavy_water")
                .fluid()
                .components(Water, 1, SemiHeavyWater, 1)
                .colorAverage()
                .build();

        IsotopicallyPureHydrogenSulfide = new Material.Builder(8178, "isotopically_pure_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1)
                .color(0xffab66)
                .build();

        ImpureSemiheavyHydrogenSulfide = new Material.Builder(8179, "impure_semiheavy_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1, SemiHeavyHydrogenSulfide, 1)
                .colorAverage()
                .build();

        ImpureHeavyHydrogenSulfide = new Material.Builder(8180, "impure_heavy_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1, HeavyHydrogenSulfide, 1)
                .colorAverage()
                .build();

        SeaWater = new Material.Builder(8181, "sea_water")
                .fluid()
                .components(Water, 2, Salt, 1)
                .color(0x3c5bc2)
                .build();

        TetrafluoroboricAcid = new Material.Builder(8182, "tetrafluoroboric_acid")
                .fluid()
                .components(Water, 3, Hydrogen, 1, Boron, 1, Fluorine, 4)
                .color(0xa4ab91)
                .build();

        BoronTrichloride = new Material.Builder(8183, "boron_trichloride")
                .fluid(FluidTypes.GAS)
                .components(Boron, 1, Chlorine, 3)
                .colorAverage()
                .build();

        ProustiteAlkalineLeachSolution = new Material.Builder(8184, "proustite_alkaline_leach_solution")
                .fluid()
                .components(Sodium, 3, Arsenic, 1, Sulfur, 3, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3AsS3)(H2O)", true)

        CrudeArsenicTrichloride = new Material.Builder(8185, "crude_arsenic_trichloride")
                .fluid()
                .components(Arsenic, 1, Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(?)(AsCl3)", true)

        Arsine = new Material.Builder(8186, "arsine")
                .fluid(FluidTypes.GAS)
                .components(Arsenic, 1, Hydrogen, 3)
                .colorAverage()
                .build()

        EnargiteSulfideLeachSolution = new Material.Builder(8187, "enargite_sulfide_leach_solution")
                .fluid()
                .components(Sodium, 3, Arsenic, 1, Sulfur, 4, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3AsS4)(H2O)", true)

        CobaltiteLeachSolution = new Material.Builder(8188, "cobaltite_leach_solution")
                .fluid()
                .components(Cobalt, 3, Nitrogen, 6, Oxygen, 30, Hydrogen, 9, Arsenic, 3, Water, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Co(NO3)2)3(H3AsO4)3(H2O)3", true)

        ArsenopyriteLeachSolution = new Material.Builder(8189, "arsenopyrite_leach_solution")
                .fluid()
                .components(Iron, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3, Water, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Fe(NO3)2)3(H3AsO4)3(H2O)3", true)

        ArsenousAcid = new Material.Builder(8190, "arsenous_acid")
                .fluid()
                .components(Hydrogen, 3, Arsenic, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        ArsenicTrichloride = new Material.Builder(8191, "arsenic_trichloride")
                .fluid()
                .components(Arsenic, 1, Chlorine, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        SaltyArsenousAcid = new Material.Builder(8192, "acidic_copper_solution")
                .fluid()
                .components(Water, 4, Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(H2O)4(CuSO4)2(HNO3)2", true)

        SperryliteWaste = new Material.Builder(8193, "sperrylite_waste")
                .fluid()
                .components(Water, 3, Chlorine, 2, Cobalt, 1, Nickel, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(H2O)3(Ni,Co)Cl2", true)

        AcidicCopperSolution = new Material.Builder(8194, "acidic_copper_solution")
                .fluid()
                .components(Water, 4, Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(H2O)4(CuSO4)2(HNO3)2", true)

        WustiteCatalyst = new Material.Builder(8195, "wustite_catalyst")
                .dust()
                .components(Iron, 1, Oxygen, 1)
                .color(0x696e62)
                .build()

        PalladiumChloride = new Material.Builder(8196, "palladium_chloride")
                .dust()
                .iconSet(SHINY)
                .components(Palladium, 1, Chlorine, 2)
                .colorAverage()
                .build()

        HexachloroiridicAcid = new Material.Builder(8197, "hexachloroiridic_acid")
                .dust()
                .iconSet(SHINY)
                .components(Chlorine, 6, Hydrogen, 2, Iridium, 1)
                .colorAverage()
                .build()

        PotassiumIodide = new Material.Builder(8198, "potassium_iodide")
                .dust()
                .components(Potassium, 1, Iodine, 1)
                .colorAverage()
                .build()

        IridiumIodide = new Material.Builder(8199, "iridium_iodide")
                .dust()
                .components(Iridium, 1, Iodine, 4)
                .colorAverage()
                .build()

        PhosphorusTrichloride = new Material.Builder(8200, "phosphorus_trichloride")
                .fluid()
                .components(Phosphorus, 1, Chlorine, 3)
                .colorAverage()
                .build()

        TriphenylPhosphine = new Material.Builder(8201, "triphenyl_phosphine")
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Phosphorus, 1)
                .colorAverage()
                .build()

        TriphenylPhosphineDichloride = new Material.Builder(8202, "triphenyl_phosphine_dichloride")
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Chlorine, 2, Phosphorus, 1)
                .colorAverage()
                .build()

        BistriphenylphosphineiminiumChloride = new Material.Builder(8203, "bistriphenylphosphineiminium_chloride")
                .dust()
                .components(Carbon, 36, Hydrogen, 30, Chlorine, 1, Nitrogen, 1, Phosphorus, 2)
                .colorAverage()
                .build()

        TriphenylphosphineOxide = new Material.Builder(8204, "triphenylphosphine_oxide")
                .dust()
                .components(Carbon, 18, Hydrogen, 15, Oxygen, 1, Phosphorus, 1)
                .colorAverage()
                .build()

        SodiumDichromate = new Material.Builder(8205, "sodium_dichromate")
                .dust()
                .components(Sodium, 2, Chrome, 2, Oxygen, 7)
                .colorAverage()
                .build()

        RaneyNickel = new Material.Builder(8206, "raney_nickel")
                .dust()
                .components(Nickel, 1, Aluminium, 1)
                .color(0x858aa1)
                .build()

        ActivatedRaneyNickel = new Material.Builder(8207, "activated_raney_nickel")
                .dust()
                .iconSet(SHINY)
                .components(Nickel, 1)
                .color(0xa9aec4)
                .build()

        CopperIIOxide = new Material.Builder(8209, "copper_ii_oxide")
                .dust()
                .components(Copper, 1, Oxygen, 1)
                .colorAverage()
                .build()

        DicobaltOctacarbonyl = new Material.Builder(8210, "dicobalt_octacarbonyl")
                .dust()
                .components(Cobalt, 2, Cobalt, 8, Oxygen, 8)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build()
                .setFormula("Co2(CO)8", true)

        ImpregnatedAluminaCatalyst = new Material.Builder(8211, "impregnated_alumina_catalyst")
                .dust()
                .components(SiliconDioxide, 1, Alumina, 1)
                .colorAverage()
                .build()

        BismuthCopper = new Material.Builder(8212, "bismuth_copper")
                .dust()
                .components(Bismuth, 1, Copper, 1)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build()

        Bromobenzene = new Material.Builder(8213, "bromobenzene")
                .fluid()
                .components(Carbon, 6, Hydrogen, 5, Bromine, 1)
                .colorAverage()
                .build()

        AluminiumTrichloride = new Material.Builder(8214, "aluminium_trichloride")
                .dust()
                .components(Aluminium, 1, Chlorine, 3)
                .colorAverage()
                .build()

        Triethylaluminium = new Material.Builder(8215, "triethylaluminium")
                .dust()
                .components(Carbon, 12, Hydrogen, 30, Aluminium, 2)
                .colorAverage()
                .build()

        HydrogenPeroxide = new Material.Builder(8216, "hydrogen_peroxide")
                .fluid()
                .components(Hydrogen, 2, Oxygen, 2)
                .colorAverage()
                .build()

        Tetrabromomethane = new Material.Builder(8217, "tetrabromomethane")
                .fluid()
                .components(Carbon, 1, Bromine, 4)
                .colorAverage()
                .build()

        Bromomethane = new Material.Builder(8218, "bromomethane")
                .fluid()
                .components(Carbon, 1, Hydrogen, 3, Bromine, 1)
                .colorAverage()
                .build()

        VeryDilutedSulfuricAcid = new Material.Builder(8219, "very_diluted_sulfuric_acid")
                .fluid()
                .components(Water, 2, SulfuricAcid, 1)
                .colorAverage()
                .build()

        SulfurDichloride = new Material.Builder(8220, "sulfur_dichloride")
                .fluid()
                .components(Sulfur, 1, Chlorine, 2)
                .colorAverage()
                .build()

        ThionylChloride = new Material.Builder(8221, "thionyl_chloride")
                .fluid()
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build()

        LithiumHydride = new Material.Builder(8222, "lithium_hydride")
                .dust()
                .components(Lithium, 1, Hydrogen, 1)
                .colorAverage()
                .build()

        BoronTrifluoride = new Material.Builder(8223, "boron_trifluoride")
                .fluid(FluidTypes.GAS)
                .components(Boron, 1, Fluorine, 3)
                .colorAverage()
                .build()

        Diborane = new Material.Builder(8224, "diborane")
                .fluid(FluidTypes.GAS)
                .components(Boron, 2, Hydrogen, 6)
                .color(0x524545)
                .build()

        LithiumFluoride = new Material.Builder(8225, "lithium_fluoride")
                .dust()
                .components(Lithium, 1, Fluorine, 1)
                .colorAverage()
                .build()

        LithiumTetrafluoroborate = new Material.Builder(8226, "lithium_tetrafluoroborate")
                .dust()
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .colorAverage()
                .build()

        TetramethylammoniumChloride = new Material.Builder(8227, "tetramethylammonium_chloride")
                .dust()
                .components(Carbon, 4, Hydrogen, 12, Nitrogen, 1, Chlorine, 1)
                .colorAverage()
                .build()

        TetramethylammoniumHydroxide = new Material.Builder(8228, "tetramethylammonium_hydroxide")
                .dust()
                .components(Carbon, 4, Hydrogen, 13, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build()

        MethacrylamideSulfate = new Material.Builder(8229, "methacrylamide_sulfate")
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 5, Sulfur, 1)
                .colorAverage()
                .build()

        AmmoniumBisulfate = new Material.Builder(8230, "ammonium_bisulfate")
                .dust().fluid()
                .components(Nitrogen, 1, Hydrogen, 5, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()
                .setFormula("(NH4)HSO4", true)

        Phosphine = new Material.Builder(8231, "phosphine")
                .fluid(FluidTypes.GAS)
                .components(Phosphorus, 1, Hydrogen, 3)
                .colorAverage()
                .build()

        PotassiumHypophosphite = new Material.Builder(8232, "potassium_hypophosphite")
                .dust()
                .components(Potassium, 1, Phosphorus, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()

        SodiumHypophosphite = new Material.Builder(8233, "sodium_hypophosphite")
                .dust()
                .components(Sodium, 1, Phosphorus, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()

        DipotassiumPhosphate = new Material.Builder(8234, "dipotassium_phosphate")
                .dust()
                .components(Potassium, 2, Hydrogen, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        DisodiumPhosphate = new Material.Builder(8235, "disodium_phosphate")
                .dust()
                .components(Sodium, 2, Hydrogen, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        SodiumCyanide = new Material.Builder(8236, "sodium_cyanide")
                .dust()
                .components(Sodium, 1, Carbon, 1, Nitrogen, 1)
                .colorAverage()
                .build()

        PhosphorylChloride = new Material.Builder(8237, "phosphoryl_chloride")
                .fluid()
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .colorAverage()
                .build()

        PhosphorusPentachloride = new Material.Builder(8238, "phosphorus_pentachloride")
                .dust()
                .components(Phosphorus, 1, Chlorine, 5)
                .colorAverage()
                .build()

        AmmoniumIodide = new Material.Builder(8240, "ammonium_iodide")
                .dust().fluid()
                .components(Nitrogen, 1, Hydrogen, 4, Iodine, 1)
                .colorAverage()
                .build()

        HydrobromicAcid = new Material.Builder(8241, "hydrobromic_acid")
                .fluid()
                .components(Hydrogen, 1, Bromine, 1)
                .colorAverage()
                .build()

        SodiumCyanide = new Material.Builder(8242, 'sodium_cyanide')
                .dust()
                .components(Sodium, 1, Carbon, 1, Nitrogen, 1)
                .color(0x077d44)
                .build()

        SodiumSulfite = new Material.Builder(8243, 'sodium_sulfite')
                .dust()
                .components(Sodium, 2, Sulfur, 1, Oxygen, 3)
                .colorAverage()
                .build()

        SodiumThiosulfate = new Material.Builder(8244, 'sodium_thiosulfate')
                .dust()
                .components(Sodium, 2, Sulfur, 2, Oxygen, 3)
                .color(0x879e21)
                .build()

        HydrogenCyanide = new Material.Builder(8246, "hydrogen_cyanide")
                .fluid()
                .components(Hydrogen, 1, Carbon, 1, Nitrogen, 1)
                .color(0x0b8542)
                .build()

        SulfidicSilverCyanideSolution = new Material.Builder(8247, "sulfidic_silver_cyanide_solution")
                .fluid()
                .components(Silver, 2, Carbon, 4, Nitrogen, 4, Sodium, 4, Sulfur, 1, Water, 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        SilverCyanideSolution = new Material.Builder(8248, "silver_cyanide_solution")
                .fluid()
                .components(Silver, 2, Carbon, 4, Nitrogen, 4, Sodium, 4, Chlorine, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na[Ag(CN)2])2(NaCl)2(H2O)4', true)

        SulfidicPyrargyriteCyanideLeachSolution = new Material.Builder(8249, 'sulfidic_pyrargyrite_cyanide_leach_solution')
                .fluid()
                .components(Sodium, 6, Silver, 3, Carbon, 6, Nitrogen, 6, Antimony, 1, Sulfur, 3, Water, 6)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na[Ag(CN)2])3(Na3SbS3)(H2O)6', true)

        PyrargyriteCyanideLeachSolution = new Material.Builder(8250, 'pyrargyrite_cyanide_leach_solution')
                .fluid()
                .components(Sodium, 6, Silver, 3, Carbon, 6, Nitrogen, 6, Antimony, 1, Chlorine, 6, Water, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na[Ag(CN)2])3(NaCl)2(NaSbCl4)(H2O)6', true)

        PyrargyriteThiosulfateLeachSolution = new Material.Builder(8251, 'pyrargyrite_thiosulfate_leach_solution')
                .fluid()
                .components(Sodium, 12, Silver, 3, Sulfur, 15, Oxygen, 18, Antimony, 1, Water, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na3[Ag(S2O3)2])3(Na3SbS3)(H2O)5', true)

        ThiosulfateThioantimoniteSolution = new Material.Builder(8252, "thiosulfate_thioantimonite_solution")
                .fluid()
                .components(Sodium, 15, Sulfur, 15, Oxygen, 18, Antimony, 1, Water, 5)
                .colorAverage()
                .build()
                .setFormula('(Na2S2O3)6(Na3SbS3)(H2O)5', true)

        ThiosulfateThioarseniteSolution = new Material.Builder(8253, "thiosulfate_thioarsenite_solution")
                .fluid()
                .components(Sodium, 15, Sulfur, 15, Oxygen, 18, Arsenic, 1, Water, 5)
                .colorAverage()
                .build()
                .setFormula('(Na2S2O3)6(Na3AsS3)(H2O)5', true)

        SulfidicStephaniteCyanideLeachSolution = new Material.Builder(8254, 'sulfidic_stephanite_cyanide_leach_solution')
                .fluid()
                .components(Sodium, 10, Silver, 5, Carbon, 10, Nitrogen, 10, Antimony, 1, Sulfur, 4, Water, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na[Ag(CN)2])5(Na3SbS3)(Na2S)(H2O)12', true)
        
        StephaniteCyanideLeachSolution = new Material.Builder(8255, 'stephanite_cyanide_leach_solution')
                .fluid()
                .components(Sodium, 10, Silver, 5, Carbon, 10, Nitrogen, 10, Antimony, 1, Chlorine, 8, Water, 20)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na[Ag(CN)2])5(NaCl)2(NaSbCl6)(H2O)20', true)

        ProustiteThiosulfateLeachSolution = new Material.Builder(8256, 'proustite_thiosulfate_leach_solution')
                .fluid()
                .components(Sodium, 12, Silver, 3, Sulfur, 15, Oxygen, 18, Arsenic, 1, Water, 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(Na3[Ag(S2O3)2])3(Na3AsS3)(H2O)5', true)
                
        AcidicArsenateVSolution = new Material.Builder(8257, 'acidic_arsenate_v_solution')
                .fluid()
                .components(NitricAcid, 6, Hydrogen, 9, Arsenic, 3, Oxygen, 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula('(HNO3)6(H3AsO4)3', true)

        ArsenicVOxide = new Material.Builder(8258, 'arsenic_v_oxide')
                .dust()
                .components(Arsenic, 2, Oxygen, 5)
                .colorAverage()
                .build()

        SilverOxide = new Material.Builder(8259, 'silver_oxide')
                .dust()
                .components(Silver, 2, Oxygen, 1)
                .colorAverage()
                .build()

        SilverSulfide = new Material.Builder(8260, 'silver_sulfide')
                .dust()
                .components(Silver, 2, Sulfur, 1)
                .colorAverage()
                .build()

        IronThioantimonite = new Material.Builder(8261, 'iron_thioantimonite')
                .dust()
                .components(Iron, 1, Antimony, 1, Sulfur, 3)
                .colorAverage()
                .build()
        
        AntimonyIIISulfide = new Material.Builder(8262, 'antimony_iii_sulfide')
                .dust()
                .components(Antimony, 2, Sulfur, 3)
                .colorAverage()
                .build()

        IronThioarsenite = new Material.Builder(8263, 'iron_thioarsenite')
                .dust()
                .components(Iron, 1, Arsenic, 1, Sulfur, 3)
                .colorAverage()
                .build()

        ManganeseIIOxide = new Material.Builder(8265, "manganese_ii_oxide")
                .dust()
                .components(Manganese, 1, Oxygen, 1)
                .color(0x472400)
                .iconSet(SAND)
                .build()

        CrudeManganeseIISulfateSolution = new Material.Builder(8266, "crude_manganese_ii_sulfate_solution")
                .fluid()
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .colorAverage()
                .build()
                .setFormula('(?)(MnSO4)(H2O)', true)

        CrudeManganeseIISulfateSolution = new Material.Builder(8267, "manganese_ii_sulfate_solution")
                .fluid()
                .components(Manganese, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .colorAverage()
                .build()
                .setFormula('(MnSO4)(H2O)', true)

        IronIIIHydroxide = new Material.Builder(8268, "iron_iii_hydroxide")
                .dust()
                .components(Iron, 1, Oxygen, 3, Hydrogen, 3)
                .color(0xcc7e35)
                .iconSet(SAND)
                .build()
                .setFormula('Fe(OH)3', true)

        Cellulose = new Material.Builder(8269, 'cellulose')
                .dust()
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .color(0x4a432f)
                .build()

        CrudeGalliumTrichloride = new Material.Builder(8270, 'crude_gallium_trichloride')
                .dust().fluid()
                .components(Gallium, 1, Chlorine, 3)
                .fluidTemp(351)
                .colorAverage()
                .build()
                .setFormula('(?)GaCl3', true)

        GalliumTrichloride = new Material.Builder(8271, 'gallium_trichloride')
                .fluid()
                .components(Gallium, 1, Chlorine, 3)
                .fluidTemp(351)
                .colorAverage()
                .build()
                .setFormula('GaCl3', true)
        
        MercuryIIChloride = new Material.Builder(8272, 'mercury_ii_chloride')
                .dust()
                .components(Mercury, 1, Chlorine, 2)
                .colorAverage()
                .build()

        BoronNitride = new Material.Builder(8273, 'boron_nitride')
                .dust()
                .components(Boron, 1, Nitrogen, 1)
                .colorAverage()
                .build()

        IronPentacarbonyl = new Material.Builder(8275, 'iron_pentacarbonyl')
                .dust()
                .components(Iron, 1, Carbon, 5, Oxygen, 5)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8c180d)
                .build()
                .setFormula('Fe(CO)5', true)

        AluminiumSulfate = new Material.Builder(8276, 'aluminium_sulfate')
                .dust()
                .components(Aluminium, 2, Sulfur, 3, Oxygen, 12)
                .colorAverage()
                .build()
                .setFormula('Al2(SO4)3', true)

        DemineralizedWater = new Material.Builder(8277, 'demineralized_water')
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x4761a8)
                .build()

        DeaeratedWater = new Material.Builder(8278, 'deaerated_water')
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x5681b3)
                .build()

        FilteredWater = new Material.Builder(8279, 'filtered_water')
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x62a0bd)
                .build()

        SterilizedWater = new Material.Builder(8280, 'sterilized_water')
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x6cb3c4)
                .build()

        UltrapureWater = new Material.Builder(8281, 'ultrapure_water')
                .fluid()
                .components(Hydrogen, 2, Oxygen, 1)
                .color(0x7acacf)
                .build()

        Ferrochromium = new Material.Builder(8282, 'ferrochromium')
                .dust()
                .components(Iron, 1, Chrome, 2)
                .color(0x6b6552)
                .build()

        Ferrosilicon = new Material.Builder(8283, 'ferrosilicon')
                .dust()
                .components(Iron, 1, Silicon, 3)
                .iconSet(SHINY)
                .color(0x999a99)
                .build()

        ConcentratedSaltWater = new Material.Builder(8284, "concentrated_salt_water")
                .fluid()
                .components(Water, 1, Salt, 2)
                .colorAverage()
                .build();

        HypersalineWater = new Material.Builder(8285, "hypersaline_water")
                .fluid()
                .components(Water, 1, Salt, 4)
                .colorAverage()
                .build();

        LithiumCarbonate = new Material.Builder(8286, "lithium_carbonate")
                .dust()
                .components(Lithium, 2, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        LithiumCobaltOxide = new Material.Builder(8287, "lithium_cobalt_oxide")
                .dust()
                .components(Lithium, 1, Cobalt, 1, Oxygen, 2)
                .colorAverage()
                .build();

        SodiumCathodeAlloy = new Material.Builder(8288, "sodium_cathode_alloy")
                .dust()
                .components(Sodium, 4, Iron, 3, Manganese, 3, Oxygen, 12)
                .colorAverage()
                .build();

        LithiumHexafluorophosphate = new Material.Builder(8289, "lithium_hexafluorophosphate")
                .fluid()
                .components(Lithium, 1, Phosphorus, 1, Fluorine, 6)
                .colorAverage()
                .build();

        NickelChloride = new Material.Builder(8290, "nickel_chloride")
                .dust()
                .components(Nickel, 1, Chlorine, 2)
                .colorAverage()
                .build();

        NickelHydroxide = new Material.Builder(8291, "nickel_hydroxide")
                .dust()
                .components(Nickel, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        NickelHydroxide.setFormula("Ni(OH)2", true)

        NickelOxideHydroxide = new Material.Builder(8292, "nickel_oxide_hydroxide")
                .dust()
                .components(Nickel, 1, Oxygen, 3, Hydrogen, 2)
                .colorAverage()
                .build();

        NickelOxideHydroxide.setFormula("NiO(OH)2", true)

        CalciumSilicate = new Material.Builder(8293, "calcium_silicate")
                .dust()
                .components(Calcium, 2, Silicon, 1, Oxygen, 4)
                .colorAverage()
                .build();

        MagnesiumChlorideSolution = new Material.Builder(8294, "magnesium_chloride_solution")
                .fluid()
                .components(MagnesiumChloride, 1, Water, 2)
                .colorAverage()
                .build();

        MagnesiumHydroxide = new Material.Builder(8295, "magnesium_hydroxide")
                .dust()
                .components(Magnesium, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        MagnesiumHydroxide.setFormula("Mg(OH)2", true)

        MagnesiumSulfate = new Material.Builder(8296, "magnesium_sulfate")
                .dust()
                .components(Magnesium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        CeriumIVOxide = new Material.Builder(8297, "cerium_iv_oxide")
                .dust()
                .components(Cerium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        CeriumIIIOxide = new Material.Builder(8298, "cerium_iii_oxide")
                .dust()
                .components(Cerium, 2, Oxygen, 3)
                .colorAverage()
                .build();

        IronSulfate = new Material.Builder(8299, "iron_sulfate")
                .dust()
                .components(Iron, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();
    }
}