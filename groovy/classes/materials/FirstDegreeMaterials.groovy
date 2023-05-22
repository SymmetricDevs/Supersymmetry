import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class FirstDegreeMaterials{

    private static void generatePurifiedElement(Material material, int id, boolean generateLiquid) {
        var color = material.materialRGB;

        if (generateLiquid) {
            new Material.Builder(id, "high_purity_" + material.toString())
                    .dust().fluid()
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

    public static void init() {

        CalciumHydroxide = new Material.Builder(32033, 'calcium_hydroxide')
                .dust()
                .components(Calcium, 1, Oxygen, 2, Hydrogen, 2)
                .colorAverage()
                .build()
                .setFormula("Ca(OH)2", true);

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
                .build()
                .setFormula("NH4NO3", true);

        AmmoniumSulfate = new Material.Builder(32022, 'ammonium_sulfate')
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SodiumNitrate = new Material.Builder(32026, 'sodium_nitrate')
                .dust()
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
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
                .build();

        Fluix = new Material.Builder(20000, 'fluix')
                .gem().iconSet(RUBY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_LENS)
                .components(Quartzite, 4, Naquadah, 1)
                .color(0x6503b6)
                .build();

        PigIron = new Material.Builder(20001, 'pig_iron')
                .ingot().dust()
                .flags(GENERATE_PLATE)
                .color(0x99918A)
                .build();

        GreenCoke = new Material.Builder(20003, "green_coke")
                .gem(1, 2000).ore(2, 1)
                .color(0x424a34).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        IronIIISulfate = new Material.Builder(20002, 'iron_iii_sulfate')
                .dust()
                .color(0xb09d99)
                .components(Iron, 2, Sulfur, 3, Oxygen, 12)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .build()
                .setFormula("Fe2(SO4)3", true);

        AluminiumHydroxide = new Material.Builder(20005, 'aluminium_hydroxide')
                .dust()
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .build()
                .setFormula("Al(OH)3", true);

        AluminiumTrifluoride = new Material.Builder(20006, 'aluminium_trifluoride')
                .dust()
                .components(Aluminium, 1, Fluorine, 3)
                .color(0x3d98bf)
                .build()

        GalliumPhosphate = new Material.Builder(20007, 'gallium_phosphate')
                .gem().iconSet(RUBY)
                .components(Gallium, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        LithiumNiobate = new Material.Builder(20008, 'lithium_niobate')
                .gem().iconSet(RUBY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 3)
                .colorAverage()
                .build()

        LeadZirconateTitanite = new Material.Builder(20009, 'lead_zirconate_titanate')
                .gem().iconSet(RUBY)
                .components(Lead, 2, Zirconium, 1, Titanium, 1, Oxygen, 6)
                .colorAverage()
                .build()

        BoricAcid = new Material.Builder(20011, 'boric_acid')
                .dust()
                .color(0xedece8)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build()

        AmorphousBoron = new Material.Builder(20012, 'amorphous_boron')
                .dust()
                .color(0x47464b)
                .build()

        MagnesiumOxide = new Material.Builder(20013, 'magnesium_oxide')
                .dust()
                .color(0xf5f5f5)
                .components(Magnesium, 1, Oxygen, 1)
                .build()

        BoronTrioxide = new Material.Builder(20014, 'boron_trioxide')
                .dust()
                .color(0xdfcfc2)
                .components(Boron, 2, Oxygen, 3)
                .build()

        Triethylenediamine = new Material.Builder(20017, 'triethylenediamine')
                .dust()
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 2)
                .colorAverage()
                .build()

        Polyurethane = new Material.Builder(20018, 'polyurethane')
                .polymer(1)
                .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
                .color(0xd1d1d1)
                .flags(GENERATE_FINE_WIRE)
                .fluidTemp(438)
                .build()
                .setFormula("(C15H10N2O2)(C2H6O2)", true);

        ZincChloride = enew Material.Builder(20201, 'zinc_chloride')
                .dust().fluid()
                .components(Zinc, 1, Chlorine, 2)
                .colorAverage()
                .build()

        SodiumTetraborate = new Material.Builder(20203, 'sodium_tetraborate')
                .dust()
                .components(Sodium, 2, Boron, 4, Oxygen, 7)
                .color(0xdbe7db)
                .build()

        ElectrolyticBoron = new Material.Builder(20204, 'electrolytic_boron')
                .dust()
                .components(Boron, 1)
                .color(0x9bd4af)
                .build()

        CalciumSulfate = new Material.Builder(32003, 'calcium_sulfate')
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        IronIISulfide = new Material.Builder(32004, 'iron_ii_sulfide')
                .dust()
                .components(Iron, 1, Sulfur, 1)
                .colorAverage()
                .build();

        PotassiumSulfate = new Material.Builder(32006, 'potassium_sulfate')
                .dust()
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        WetAntimonyTrifluoride = new Material.Builder(32007, 'wet_antimony_trifluoride')
                .dust()
                .components(Antimony, 1, Fluorine, 3)
                .colorAverage()
                .build();

        CalciumSulfide = new Material.Builder(32010, 'calcium_sulfide')
                .dust()
                .components(Calcium, 1, Sulfur, 1)
                .colorAverage()
                .build();

        CalciumSulfate = new Material.Builder(32012, 'calcium_sulfate')
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        VanadiumPentoxide = new Material.Builder(32017, 'vanadium_pentoxide')
                .dust()
                .components(Vanadium, 2, Oxygen, 5)
                .colorAverage()
                .build();

        PotassiumPersulfate = new Material.Builder(32027, 'potassium_persulfate')
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .build();

        LithiumHydroxide = new Material.Builder(32030, 'lithium_hydroxide')
                .dust()
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        CalciumCarbide = new Material.Builder(32038, 'calcium_carbide')
                .dust()
                .components(Calcium, 1, Carbon, 2)
                .colorAverage()
                .build();

        IronIIChloride = new Material.Builder(32039, 'iron_ii_chloride')
                .dust()
                .components(Iron, 1, Chlorine, 2)
                .color(0x9dad37)
                .build()

        CuprousOxide = new Material.Builder(32040, 'cuprous_oxide')
                .dust()
                .components(Copper, 2, Oxygen, 1)
                .color(0x822635)
                .build()

        LithiumBromide = new Material.Builder(32041, 'lithium_bromide')
                .dust()
                .components(Lithium, 1, Bromine, 1)
                .color(0xC5C5C5)
                .build()

        IronIIIOxide = new Material.Builder(32042, 'iron_iii_oxide')
                .dust()
                .components(Iron, 2, Oxygen, 3)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8F0C03)
                .build()

        CopperIIChloride = new Material.Builder(32043, 'copper_ii_chloride')
                .dust()
                .components(Copper, 1, Chlorine, 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x12112c)
                .build()

        SiliconCarbide = new Material.Builder(32044, 'silicon_carbide')
                .dust()
                .components(Silicon, 1, Carbon, 1)
                .color(0x404040)
                .build()

        TungstenTrioxide = new Material.Builder(32045, 'tungsten_trioxide')
                .dust()
                .components(Tungsten, 1, Oxygen, 3)
                .color(0x8a9734)
                .build()

        Alumina = new Material.Builder(32047, 'alumina')
                .dust()
                .components(Aluminium, 2, Oxygen, 3)
                .color(0xd0cff7)
                .build()

        BoronCarbide = new Material.Builder(32049, 'boron_carbide')
                .dust()
                .components(Boron, 4, Carbon, 1)
                .flags(GENERATE_ROD)
                .colorAverage()
                .build()

        SilverChloride = new Material.Builder(32054, 'silver_chloride')
                .dust()
                .components(Silver, 1, Chlorine, 1)
                .colorAverage()
                .build()

        ArsenicIIISulfide = new Material.Builder(32055, 'arsenic_iii_sulfide')
                .dust()
                .components(Arsenic, 2, Sulfur, 3)
                .colorAverage()
                .build()

        SodiumArsenide = new Material.Builder(32056, 'sodium_arsenide')
                .dust()
                .components(Sodium, 3, Arsenic, 1)
                .colorAverage()
                .build()

        ArsenicVSulfide = new Material.Builder(32057, 'arsenic_v_sulfide')
                .dust()
                .components(Arsenic, 2, Sulfur, 5)
                .colorAverage()
                .build()

        CopperSulfate = new Material.Builder(32058, 'copper_sulfate')
                .dust()
                .components(Copper, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()

        RoastedSperrylite = new Material.Builder(32500, 'roasted_sperrylite')
                .dust()
                .components(Platinum, 1)
                .color(0x3b1754)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SAND)
                .build();

        EnargiteResidue = new Material.Builder(32600, 'enargite_residue')
                .dust()
                .components(Copper, 2, Sulfur, 1)
                .color(0x59183c)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(BRIGHT)
                .build()
                .setFormula("(?)Cu2S", true);

        HydrogenChloride = new Material.Builder(11002, "hydrogen_chloride")
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Chlorine, 1)
                .colorAverage()
                .build();

        HydrogenFluoride = new Material.Builder(11003, "hydrogen_fluoride")
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Fluorine, 1)
                .colorAverage()
                .build();

        DilutedSaltwater = new Material.Builder(11013, "diluted_saltwater")
                .fluid()
                .components(Water, 2, Salt, 1)
                .color(0x3d61b8)
                .build();

        SodiumHydroxideSolution = new Material.Builder(11020, "sodium_hydroxide_solution")
                .fluid()
                .components(Water, 1, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        IronIIIChlorideSolution = new Material.Builder(11028, "iron_iii_chloride_solution")
                .fluid()
                .components(Water, 1, Iron3Chloride, 1)
                .colorAverage()
                .build();

        DiluteSaltpeterSolution = new Material.Builder(11062, 'dilute_saltpeter_solution')
                .fluid()
                .components(Water, 2, Saltpeter, 1)
                .colorAverage()
                .build();

        DiethylEther = new Material.Builder(11076, 'diethyl_ether')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()
                .setFormula("(C2H5)2O", true);

        DiethylEtherSolution = new Material.Builder(11077, 'diethyl_ether_solution')
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, DiethylEther, 1)
                .colorAverage()
                .build();

        HydrogenBromide = new Material.Builder(11079, 'hydrogen_bromide')
                .fluid()
                .components(Hydrogen, 1, Bromine, 1)
                .colorAverage()
                .build();

        DiluteCalciumChlorideSolution = new Material.Builder(11085, "dilute_calcium_chloride_solution")
                .fluid()
                .components(Water, 2, CalciumChloride, 1)
                .colorAverage()
                .build();

        DiluteRockSaltSolution = new Material.Builder(11086, "dilute_rock_salt_solution")
                .fluid()
                .components(Water, 2, RockSalt, 1)
                .colorAverage()
                .build();

        DryCarbonMonoxide = new Material.Builder(11092, "dry_carbon_monoxide")
                .fluid(FluidTypes.GAS)
                .components(CarbonMonoxide, 1)
                .color(0x202329)
                .build();

        AmmoniaSolution = new Material.Builder(11096, "ammonia_solution")
                .fluid()
                .components(Water, 1, Ammonia, 1)
                .colorAverage()
                .build();

        SaltpeterSolution = new Material.Builder(11113, 'saltpeter_solution')
                .fluid()
                .components(Water, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        SaltySaltpeterSolution = new Material.Builder(11114, 'salty_saltpeter_solution')
                .fluid()
                .components(SaltWater, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        CarbonDisulfide = new Material.Builder(11125, 'carbon_disulfide')
                .fluid()
                .components(Carbon, 1, Sulfur, 2)
                .colorAverage()
                .build();

        HighPressureWater = new Material.Builder(12026, "high_pressure_water")
                .fluid()
                .colorAverage()
                .components(Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Cryolite = new Material.Builder(12089, "cryolite")
                .fluid().dust()
                .components(Sodium, 3, Aluminium, 1, Fluorine, 6)
                .color(0x2497a6)
                .build();

        EthanolSolution = new Material.Builder(12097, "ethanol_solution")
                .fluid()
                .components(Ethanol, 1, PhosphoricAcid, 1)
                .colorAverage()
                .build();

        HeavyWater = new Material.Builder(12200, "heavy_water")
                .fluid()
                .components(Deuterium, 2, Oxygen, 1)
                .color(0x2c37b0)
                .build();

        HeavyHydrogenSulfide = new Material.Builder(12201, "heavy_hydrogen_sulfide")
                .fluid()
                .components(Deuterium, 2, Sulfur, 1)
                .color(0xb09a2c)
                .build();

        SemiHeavyHydrogenSulfide = new Material.Builder(12202, "semiheavy_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(Hydrogen, 1, Deuterium, 1, Sulfur, 1)
                .color(0xc29836)
                .build();

        SemiHeavyWater = new Material.Builder(12203, "semiheavy_water")
                .fluid()
                .components(Hydrogen, 1, Deuterium, 1, Oxygen, 1)
                .color(0x364ec2)
                .build();

        ImpureSemiheavyWater = new Material.Builder(12204, "impure_semiheavy_water")
                .fluid()
                .components(Water, 1, SemiHeavyWater, 1)
                .colorAverage()
                .build();

        IsotopicallyPureHydrogenSulfide = new Material.Builder(12205, "isotopically_pure_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1)
                .color(0xffab66)
                .build();

        ImpureSemiheavyHydrogenSulfide = new Material.Builder(12206, "impure_semiheavy_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1, SemiHeavyHydrogenSulfide, 1)
                .colorAverage()
                .build();

        ImpureHeavyHydrogenSulfide = new Material.Builder(12207, "impure_heavy_hydrogen_sulfide")
                .fluid(FluidTypes.GAS)
                .components(HydrogenSulfide, 1, HeavyHydrogenSulfide, 1)
                .colorAverage()
                .build();

        SeaWater = new Material.Builder(12208, "sea_water")
                .fluid()
                .components(Water, 98, Salt, 2)
                .color(0x3c5bc2)
                .build();

        TetrafluoroboricAcid = new Material.Builder(12210, "tetrafluoroboric_acid")
                .fluid()
                .components(Water, 3, Hydrogen, 1, Boron, 1, Fluorine, 4)
                .color(0xa4ab91)
                .build();

        BoronTrichloride = new Material.Builder(12212, "boron_trichloride")
                .fluid(FluidTypes.GAS)
                .components(Boron, 1, Chlorine, 3)
                .colorAverage()
                .build();

        ThioarseniteSolution = new Material.Builder(12213, "thioarsenite_solution")
                .fluid()
                .components(Sodium, 3, Arsenic, 1, Sulfur, 3, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(?)(Na3AsS3)(H2O)", true);

        TetrachloroantimonateSolution = new Material.Builder(12214, "tetrachloroantimonate_solution")
                .fluid()
                .components(Hydrogen, 1, Antimony, 1, Chlorine, 4, Salt, 2, Water, 14)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(NaCl)14(NaSbCl4)(H2O)22", true);

        Arsine = new Material.Builder(12215, "arsine")
                .fluid(FluidTypes.GAS)
                .components(Arsenic, 1, Hydrogen, 3)
                .colorAverage()
                .build();

        ThioarsenateSolution = new Material.Builder(12217, "thioarsenate_solution")
                .fluid()
                .components(Sodium, 3, Arsenic, 1, Sulfur, 4, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(?)(Na3AsS4)(H2O)", true);


        CobaltiteLeachSolution = new Material.Builder(12218, "cobaltite_leach_solution")
                .fluid()
                .components(Cobalt, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Co(NO3)2)3(H3AsO4)3(H2O)2", true);

        ArsenopyriteLeachSolution = new Material.Builder(12219, "arsenopyrite_leach_solution")
                .fluid()
                .components(Iron, 3, Nitrogen, 6, Oxygen, 32, Hydrogen, 13, Arsenic, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Fe(NO3)2)3(H3AsO4)3(H2O)2", true);

        ArsenousAcid = new Material.Builder(12220, "arsenous_acid")
                .fluid()
                .components(Hydrogen, 3, Arsenic, 1, Oxygen, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build();

        AlkalineArseniteSolution = new Material.Builder(12221, "alkaline_arsenite_solution")
                .fluid()
                .components(Sodium, 3, Arsenic, 2, Oxygen, 3, Sulfur, 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3AsO3)(Na3AsS3)(H2O)9", true);

        SaltyArsenousAcid = new Material.Builder(12222, "salty_arsenous_acid")
                .fluid()
                .components(Salt, 12, Hydrogen, 6, Arsenic, 2, Oxygen, 6)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(NaCl)12(H3AsO3)2(H2O)21", true);

        SperryliteWaste = new Material.Builder(12223, "sperrylite_waste")
                .fluid()
                .components(Water, 3, Chlorine, 2, Cobalt, 1, Nickel, 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(H2O)3(Ni,Co)Cl2", true);

        AcidicCopperSolution = new Material.Builder(12224, "acidic_copper_solution")
                .fluid()
                .components(Water, 4, Copper, 2, Sulfur, 2, Oxygen, 8, NitricAcid, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(H2O)4(CuSO4)2(HNO3)2", true);

        generatePurifiedElement(Lithium, 22000, false)
        generatePurifiedElement(Beryllium, 22001, false)
        generatePurifiedElement(Boron, 22002, false)
        generatePurifiedElement(Carbon, 22003, false)
        generatePurifiedElement(Sodium, 22004, false)
        generatePurifiedElement(Magnesium, 22005, false)
        generatePurifiedElement(Aluminium, 22006, false)
        generatePurifiedElement(Silicon, 22007, true)
        generatePurifiedElement(Phosphorus, 22008, false)
        generatePurifiedElement(Sulfur, 22009, false)
        generatePurifiedElement(Potassium, 22010, false)
        generatePurifiedElement(Calcium, 22011, false)
        generatePurifiedElement(Scandium, 22012, false)
        generatePurifiedElement(Titanium, 22013, false)
        generatePurifiedElement(Vanadium, 22014, false)
        generatePurifiedElement(Chrome, 22015, false)
        generatePurifiedElement(Manganese, 22016, false)
        generatePurifiedElement(Iron, 22017, false)
        generatePurifiedElement(Cobalt, 22018, false)
        generatePurifiedElement(Nickel, 22019, false)
        generatePurifiedElement(Copper, 22020, false)
        generatePurifiedElement(Zinc, 22021, false)
        generatePurifiedElement(Gallium, 22022, false)
        generatePurifiedElement(Germanium, 22023, false)
        generatePurifiedElement(Arsenic, 22024, false)
        generatePurifiedElement(Selenium, 22025, false)
        generatePurifiedElement(Rubidium, 22026, false)
        generatePurifiedElement(Strontium, 22027, false)
        generatePurifiedElement(Yttrium, 22028, false)
        generatePurifiedElement(Zirconium, 22029, false)
        generatePurifiedElement(Niobium, 22030, false)
        generatePurifiedElement(Molybdenum, 22031, false)
        generatePurifiedElement(Technetium, 22032, false)
        generatePurifiedElement(Ruthenium, 22033, false)
        generatePurifiedElement(Rhodium, 22034, false)
        generatePurifiedElement(Palladium, 22035, false)
        generatePurifiedElement(Silver, 22036, false)
        generatePurifiedElement(Cadmium, 22037, false)
        generatePurifiedElement(Indium, 22038, false)
        generatePurifiedElement(Tin, 22039, false)
        generatePurifiedElement(Antimony, 22040, false)
        generatePurifiedElement(Tellurium, 22041, false)
        generatePurifiedElement(Iodine, 22042, false)
        generatePurifiedElement(Caesium, 22043, false)
        generatePurifiedElement(Barium, 22044, false)
        generatePurifiedElement(Lanthanum, 22045, false)
        generatePurifiedElement(Hafnium, 22046, false)
        generatePurifiedElement(Tantalum, 22047, false)
        generatePurifiedElement(Tungsten, 22048, false)
        generatePurifiedElement(Rhenium, 22049, false)
        generatePurifiedElement(Osmium, 22050, false)
        generatePurifiedElement(Iridium, 22051, false)
        generatePurifiedElement(Platinum, 22052, false)
        generatePurifiedElement(Gold, 22053, false)
        generatePurifiedElement(Thallium, 22054, false)
        generatePurifiedElement(Lead, 22055, false)
        generatePurifiedElement(Bismuth, 22056, false)
        generatePurifiedElement(Cerium, 22057, false)
        generatePurifiedElement(Praseodymium, 22058, false)
        generatePurifiedElement(Neodymium, 22059, false)
        generatePurifiedElement(Samarium, 22060, false)
        generatePurifiedElement(Europium, 22061, false)
        generatePurifiedElement(Gadolinium, 22062, false)
        generatePurifiedElement(Terbium, 22063, false)
        generatePurifiedElement(Dysprosium, 2164, false)
        generatePurifiedElement(Holmium, 22065, false)
        generatePurifiedElement(Erbium, 22066, false)
        generatePurifiedElement(Thulium, 22067, false)
        generatePurifiedElement(Ytterbium, 22068, false)
        generatePurifiedElement(Lutetium, 22069, false)
        generatePurifiedElement(Thorium, 22070, false)
    }
}