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

public class OrganicChemistryMaterials {
    public static void register() {
        
        log.infoMC("Registering Organic Chemistry Materials!");

        FourNitrochlorobenzene = new Material.Builder(15000, GTUtility.gregtechId('four_nitrochlorobenzene'))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .build();

        FourNitroaniline = new Material.Builder(15001, GTUtility.gregtechId('four_nitroaniline'))
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build();

        ParaPhenylenediamine = new Material.Builder(15002, GTUtility.gregtechId('para_phenylenediamine'))
                .dust()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzene = new Material.Builder(15003, GTUtility.gregtechId('two_two_dichlorohydrazobenzene'))
                .dust()
                .components(Carbon, 12, Hydrogen, 10, Chlorine, 2, Nitrogen, 2)
                .colorAverage()
                .build();

        SodiumPhenoxide = new Material.Builder(15004, GTUtility.gregtechId('sodium_phenoxide'))
                .dust()
                .components(Carbon, 6, Hydrogen, 5, Sodium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        PhthaloylDichloride = new Material.Builder(15005, GTUtility.gregtechId('phthaloyl_dichloride'))
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .build();

        CaprolactamOxime = new Material.Builder(15006, GTUtility.gregtechId('caprolactam_oxime'))
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        TNT = new Material.Builder(15007, GTUtility.gregtechId('tnt'))
                .dust()
                .components(Carbon, 7, Hydrogen, 5, Nitrogen, 3, Oxygen, 6)
                .color(0xacb38d)
                .build();

        Polystyrene = new Material.Builder(15008, GTUtility.gregtechId('polystyrene'))
                .polymer(1)
                .components(Carbon, 8, Hydrogen, 8)
                .color(0xa2a389)
                .build();

        OneTwoDichlorobenzene = new Material.Builder(15009, GTUtility.gregtechId('one_two_dichlorobenzene'))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .build();

        PolyvinylideneFluorine = new Material.Builder(15010, GTUtility.gregtechId('polyvinylidene_fluoride'))
                .polymer(1)
                .color(0xfde3ff)
                .flags(GENERATE_FOIL)
                .components(Carbon, 2, Hydrogen, 2, Fluorine, 2)
                .fluidTemp(468)
                .build()

        Methylenedianiline = new Material.Builder(15011, GTUtility.gregtechId('methylenedianiline'))
                .dust()
                .components(Carbon, 13, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .build()

        MethyleneDiphenylDiisocyanate = new Material.Builder(15012, GTUtility.gregtechId('methylene_diphenyl_diisocyanate'))
                .dust()
                .components(Carbon, 15, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build()

        MemoryFoam = new Material.Builder(15013, GTUtility.gregtechId('memory_foam'))
                .polymer(1)
                .flags(GENERATE_PLATE)
                .color(0xFFFFFF)
                .fluidTemp(438)
                .build()

        Rayon = new Material.Builder(15014, GTUtility.gregtechId('rayon'))
                .polymer(1)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .flags(GENERATE_FINE_WIRE)
                .color(0xaee8d9)
                .fluidTemp(438)
                .build()
                //.setFormula("C6H5(OH)4OH", true);

        AlkaliCellulose = new Material.Builder(15015, GTUtility.gregtechId('alkali_cellulose'))
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Sodium, 1)
                .color(0x7d6547)
                .build()

        SodiumCelluloseXanthate = new Material.Builder(15016, GTUtility.gregtechId('sodium_cellulose_xanthate'))
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Carbon, 1, Sulfur, 2, Sodium, 1)
                .color(0x7d6057)
                .build()

        PMMA = new Material.Builder(15017, GTUtility.gregtechId('pmma'))
                .polymer(1)
                .color(0x72e0c9)
                .flags(GENERATE_FOIL)
                .components(Carbon, 5, Oxygen, 2, Hydrogen, 8)
                .fluidTemp(438)
                .build()

        PhthalicAnhydride = new Material.Builder(15018, GTUtility.gregtechId('phthalic_anhydride'))
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .colorAverage()
                .build();

        TributylPhosphate = new Material.Builder(15019, GTUtility.gregtechId("tributyl_phosphate"))
                .fluid()
                .components(Carbon, 12, Hydrogen, 27, Oxygen, 4, Phosphorus, 1)
                .color(0xf5e3b3)
                .build();

        CrudeStyrene = new Material.Builder(15020, GTUtility.gregtechId("crude_styrene"))
                .fluid()
                .color(0x4d4d3e)
                .build();

        ChlorinatedMethaneMixture = new Material.Builder(15021, GTUtility.gregtechId("chlorinated_methane_mixture"))
                .fluid(FluidTypes.GAS)
                .color(0x8327d9)
                .build();

        ChlorinatedChloromethaneMixture = new Material.Builder(15022, GTUtility.gregtechId("chlorinated_chloromethane_mixture"))
                .fluid(FluidTypes.GAS)
                .color(0x6124bd)
                .build();

        ChlorinatedDichloromethaneMixture = new Material.Builder(15023, GTUtility.gregtechId("chlorinated_dichloromethane_mixture"))
                .fluid(FluidTypes.GAS)
                .color(0x4922a3)
                .build();

        ChloromethaneSolution = new Material.Builder(15024, GTUtility.gregtechId("chloromethane_solution"))
                .fluid()
                .components(Water, 1, Chloromethane, 1)
                .colorAverage()
                .build();

        AcidicChlorodifluoromethane = new Material.Builder(15025, GTUtility.gregtechId("acidic_chlorodifluoromethane"))
                .fluid(FluidTypes.GAS)
                .color(0xbd97c7)
                .build();

        AcidicTetrafluoroethylene = new Material.Builder(15026, GTUtility.gregtechId("acidic_tetrafluoroethylene"))
                .fluid(FluidTypes.GAS)
                .color(0x726678)
                .build();

        TrinitromethaneSolution = new Material.Builder(15027, GTUtility.gregtechId("trinitromethane_solution"))
                .fluid()
                .color(0x333c52)
                .build();

        TetranitronmethaneSolution = new Material.Builder(15028, GTUtility.gregtechId("tetranitromethane_solution"))
                .fluid()
                .color(0x373352)
                .build();

        ImpureDimethyldichloroSilane = new Material.Builder(15029, GTUtility.gregtechId("impure_dimethyldichlorosilane"))
                .fluid()
                .color(0x291e38)
                .build();

        ChlorinatedGlycerol = new Material.Builder(15030, GTUtility.gregtechId("chlorinated_glycerol"))
                .fluid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build();

        EpichlorohydrinSolution = new Material.Builder(15031, GTUtility.gregtechId("epichlorohydrin_solution"))
                .fluid()
                .color(0x9c6241)
                .build();

        AllylAlcoholMix = new Material.Builder(15032, GTUtility.gregtechId("allyl_alcohol_mix"))
                .fluid()
                .color(0xbede9b)
                .build();

        DilutedEpichlorohydrin = new Material.Builder(15033, GTUtility.gregtechId("diluted_epichlorohydrin"))
                .fluid()
                .color(0x91664d)
                .build();

        Isobutane = new Material.Builder(15034, GTUtility.gregtechId("isobutane"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 10)
                .color(0x8a7566)
                .build();

        Isobutylene = new Material.Builder(15035, GTUtility.gregtechId("isobutylene"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 8)
                .color(0x917d61)
                .build();

        NMethylIIPyrrolidone = new Material.Builder(15037, GTUtility.gregtechId('n_methyl_ii_pyrrolidone'))
                .fluid()
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        SaltyNMethylIIPyrrolidone = new Material.Builder(15038, GTUtility.gregtechId('salty_n_methyl_ii_pyrrolidone'))
                .fluid()
                .components(NMethylIIPyrrolidone, 1, Salt, 1)
                .colorAverage()
                .build();

        MethylAcetateSolution = new Material.Builder(15039, GTUtility.gregtechId('methyl_acetate_solution'))
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, MethylAcetate, 1)
                .colorAverage()
                .build();

        TwoNitrochlorobenzene = new Material.Builder(15040, GTUtility.gregtechId('two_nitrochlorobenzene'))
                .dust().fluid()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .color(0xc7c944)
                .build();

        MixedNitrochlorobenzene = new Material.Builder(15041, GTUtility.gregtechId('mixed_nitrochlorobenzene'))
                .dust().fluid()
                .color(0xa4a644)
                .build();

        FourNitroanilineSolution = new Material.Builder(15042, GTUtility.gregtechId('four_nitroaniline_solution'))
                .fluid()
                .components(Toluene, 1, FourNitroaniline, 1)
                .colorAverage()
                .build();

        ParaPhenylenediamineSolution = new Material.Builder(15043, GTUtility.gregtechId('para_phenylenediamine_solution'))
                .fluid()
                .components(Toluene, 1, ParaPhenylenediamine, 1)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzeneSolution = new Material.Builder(15044, GTUtility.gregtechId('two_two_dichlorohydrazobenzene_solution'))
                .fluid()
                .components(Toluene, 1, TwoTwoDichlorohydrazobenzene, 1)
                .colorAverage()
                .build();

        DichlorobenzidineSolution = new Material.Builder(15045, GTUtility.gregtechId('dichlorobenzidine_solution'))
                .fluid()
                .components(Toluene, 1, Dichlorobenzidine, 1)
                .colorAverage()
                .build();

        Xylene = new Material.Builder(15046, GTUtility.gregtechId('xylene'))
                .fluid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x2e281f)
                .build();

        Phosgene = new Material.Builder(15047, GTUtility.gregtechId('phosgene'))
                .fluid()
                .components(Carbon, 1, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build();

        Dichloroethane = new Material.Builder(15048, GTUtility.gregtechId('dichloroethane'))
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .build();

        PhthaloylDichlorideSolution = new Material.Builder(15049, GTUtility.gregtechId('phthaloyl_dichloride_solution'))
                .fluid()
                .components(Dichloroethane, 1, Water, 1, PhthaloylDichloride, 1)
                .colorAverage()
                .build();

        SodiumPhenoxideSolution = new Material.Builder(15050, GTUtility.gregtechId('sodium_phenoxide_solution'))
                .fluid()
                .components(Water, 1, SodiumPhenoxide, 1)
                .colorAverage()
                .build();

        DiphenylIsophthalateSolution = new Material.Builder(15051, GTUtility.gregtechId('diphenyl_isophthalate_solution'))
                .fluid()
                .components(Water, 2, Dichloroethane, 1, DiphenylIsophtalate, 1)
                .colorAverage()
                .build();

        DiaminobenzidineSolution = new Material.Builder(15052, GTUtility.gregtechId('diaminobenzidine_solution'))
                .fluid()
                .components(Water, 1, Toluene, 1, Diaminobenzidine, 1)
                .colorAverage()
                .build();

        PBIPolymerizationMix = new Material.Builder(15053, GTUtility.gregtechId('pbi_polymerization_mix'))
                .fluid()
                .color(0x40342b)
                .fluidTemp(450)
                .build();

        PBIPrePolymerFoam = new Material.Builder(15054, GTUtility.gregtechId('pbi_pre_polymer_foam'))
                .fluid()
                .color(0x332d28)
                .fluidTemp(450)
                .build();

        ImpurePBISolution = new Material.Builder(15055, GTUtility.gregtechId('impure_pbi_solution'))
                .fluid()
                .color(0x292623)
                .fluidTemp(450)
                .build();

        Dimethylacetamide = new Material.Builder(15056, GTUtility.gregtechId('dimethylacetamide'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        PBISolution = new Material.Builder(15057, GTUtility.gregtechId('pbi_solution'))
                .fluid()
                .components(Dimethylacetamide, 1, Polybenzimidazole, 7)
                .color(0x171410)
                .build();

        PBIWaste = new Material.Builder(15058, GTUtility.gregtechId('pbi_waste'))
                .fluid()
                .color(0x202226)
                .build();

        Hydroxylamine = new Material.Builder(15059, GTUtility.gregtechId('hydroxylamine'))
                .fluid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        Cyclohexanone = new Material.Builder(15060, GTUtility.gregtechId('cyclohexanone'))
                .fluid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .color(0x2b1e11)
                .build();

        NHexadecylammoniumAcetate = new Material.Builder(15061, GTUtility.gregtechId("n_hexadecylammonium_acetate"))
                .dust()
                .components(Carbon, 16, Hydrogen, 39, Nitrogen, 1, Oxygen, 2)
                .color(0xffd4d4)
                .build();

        CaprolactamSolution = new Material.Builder(15062, GTUtility.gregtechId('caprolactam_solution'))
                .fluid()
                .components(AmmoniumSulfate, 1, Caprolactam, 1, Water, 2)
                .colorAverage()
                .build();

        BisphenolADiglycidylEther = new Material.Builder(15063, GTUtility.gregtechId('bisphenola_diglycidyl_ether'))
                .fluid()
                .components(Carbon, 21, Hydrogen, 24, Oxygen, 4)
                .colorAverage()
                .build();

        ImpureEpoxyResin = new Material.Builder(15064, GTUtility.gregtechId('impure_epoxy_resin'))
                .fluid()
                .components(SaltWater, 1, Epoxy, 1)
                .colorAverage()
                .build();

        UncuredEpoxyResin = new Material.Builder(15065, GTUtility.gregtechId('uncured_epoxy_resin'))
                .fluid()
                .components(Epoxy, 1)
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .build();

        TNTSolution = new Material.Builder(15066, GTUtility.gregtechId('tnt_solution'))
                .fluid()
                .components(TNT, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .build();

        VinylChlorideSolution = new Material.Builder(15067, GTUtility.gregtechId('vinyl_chloride_solution'))
                .fluid()
                .components(Water, 1, VinylChloride, 1)
                .colorAverage()
                .build();

        PolyvinylChlorideSolution = new Material.Builder(15068, GTUtility.gregtechId('polyvinyl_chloride_solution'))
                .fluid()
                .components(Water, 1, PolyvinylChloride, 1)
                .colorAverage()
                .build();

        StyreneSolution = new Material.Builder(15069, GTUtility.gregtechId('styrene_solution'))
                .fluid()
                .components(Water, 1, Styrene, 1)
                .colorAverage()
                .build();

        PolystyreneSolution = new Material.Builder(15070, GTUtility.gregtechId('polystyrene_solution'))
                .fluid()
                .components(Water, 1, Polystyrene, 1)
                .colorAverage()
                .build();

        VinylAcetateSolution = new Material.Builder(15071, GTUtility.gregtechId('vinyl_acetate_solution'))
                .fluid()
                .components(Water, 1, VinylAcetate, 1)
                .colorAverage()
                .build();

        PolyvinylAcetateSolution = new Material.Builder(15072, GTUtility.gregtechId('polyvinyl_acetate_solution'))
                .fluid()
                .components(Water, 1, PolyvinylAcetate, 1)
                .colorAverage()
                .build();

        Bleach = new Material.Builder(15073, GTUtility.gregtechId('bleach'))
                .fluid()
                .components(Water, 1, Sodium, 1, Chlorine, 1, Oxygen, 1)
                .colorAverage()
                .build();

        ImpureBleach = new Material.Builder(15074, GTUtility.gregtechId('impure_bleach'))
                .fluid()
                .components(Water, 3, Bleach, 1, Salt, 1)
                .colorAverage()
                .build();

        OneFourDichlorobenzeneSolution = new Material.Builder(15075, GTUtility.gregtechId('one_four_dichlorobenzene_solution'))
                .fluid()
                .components(Toluene, 1, Dichlorobenzene, 1)
                .colorAverage()
                .build();

        OneTwoDichlorobenzeneSolution = new Material.Builder(15076, GTUtility.gregtechId('one_two_dichlorobenzene_solution'))
                .fluid()
                .components(Toluene, 1, OneTwoDichlorobenzene, 1)
                .colorAverage()
                .build();

        DryEthanol = new Material.Builder(15077, GTUtility.gregtechId('dry_ethanol'))
                .fluid()
                .components(Ethanol, 1)
                .color(0xeb6b34)
                .build();

        StyreneButadieneSolution = new Material.Builder(15078, GTUtility.gregtechId('styrene_butadiene_solution'))
                .fluid()
                .components(Styrene, 1, Butadiene, 1, Ethanol, 1)
                .colorAverage()
                .build();

        OneBromobutane = new Material.Builder(15079, GTUtility.gregtechId('one_bromobutane'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .colorAverage()
                .build();

        DilutedOneBromobutane = new Material.Builder(15080, GTUtility.gregtechId('diluted_one_bromobutane'))
                .fluid()
                .components(Water, 1, OneBromobutane, 1)
                .colorAverage()
                .build();

        Butyllithium = new Material.Builder(15081, GTUtility.gregtechId('butyllithium'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .colorAverage()
                .build();

        DilutedButyllithium = new Material.Builder(15082, GTUtility.gregtechId('diluted_butyllithium'))
                .fluid()
                .components(Water, 1, Butyllithium, 1)
                .colorAverage()
                .build();

        PolymerizedStyreneButadieneSolution = new Material.Builder(15083, GTUtility.gregtechId('polymerized_styrene_butadiene_solution'))
                .fluid()
                .color(0x332e2c)
                .color(0x3d2509)
                .build();

        MethylFormate = new Material.Builder(15084, GTUtility.gregtechId("methyl_formate"))
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .build();

        MethylFormateSolution = new Material.Builder(15085, GTUtility.gregtechId("methyl_formate_solution"))
                .fluid(FluidTypes.GAS)
                .components(Water, 1, MethylFormate, 1, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        Acetylene = new Material.Builder(15086, GTUtility.gregtechId("acetylene"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        DilutedDichloroethane = new Material.Builder(15087, GTUtility.gregtechId('diluted_dichloroethane'))
                .fluid()
                .components(Water, 3, Dichloroethane, 1)
                .colorAverage()
                .build();

        Formaldehyde = new Material.Builder(15088, GTUtility.gregtechId("formaldehyde"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .colorAverage()
                .build();

        MethylamineMix = new Material.Builder(15089, GTUtility.gregtechId('methylamine_mix'))
                .fluid()
                .color(0x6b4ea6)
                .build();

        Methylamine = new Material.Builder(15090, GTUtility.gregtechId('methylamine'))
                .fluid()
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .color(0x794c91)
                .build()
                //.setFormula("CH3NH2", true);

        Trimethylamine = new Material.Builder(15091, GTUtility.gregtechId('trimethylamine'))
                .fluid()
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .color(0x4c2461)
                .build();

        Butynediol = new Material.Builder(15092, GTUtility.gregtechId('butynediol'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .build();

        Butanediol = new Material.Builder(15093, GTUtility.gregtechId('butanediol'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .build();

        GammaButyrolactone = new Material.Builder(15094, GTUtility.gregtechId('gamma_butyrolactone'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .color(0x4242f5)
                .build();

        DilutedMethylIIPyrrolidone = new Material.Builder(15095, GTUtility.gregtechId('diluted_methyl_ii_pyrrolidone'))
                .fluid()
                .components(Water, 1, NMethylIIPyrrolidone, 1)
                .colorAverage()
                .build();

        DimethyldichlorosilaneEmulsion = new Material.Builder(15096, GTUtility.gregtechId('dimethyldichlorosilane_emulsion'))
                .fluid()
                .color(0x542a4c)
                .build();

        TetrafluoroethyleneEmulsion = new Material.Builder(15097, GTUtility.gregtechId('tetrafluoroethylene_emulsion'))
                .fluid()
                .color(0x3b2e38)
                .build();

        Dichloromethane = new Material.Builder(15098, GTUtility.gregtechId('dichloromethane'))
                .fluid()
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .colorAverage()
                .build();

        CarbonTetrachloride = new Material.Builder(15099, GTUtility.gregtechId('carbon_tetrachloride'))
                .fluid()
                .components(Carbon, 1, Chlorine, 4)
                .colorAverage()
                .build();

        PhthalicAcidSolution = new Material.Builder(15100, GTUtility.gregtechId('phthalic_acid_solution'))
                .fluid()
                .components(Dichloroethane, 1, PhthalicAcid, 1)
                .color(0xdbbbbd)
                .build();

        NPropanol = new Material.Builder(15101, GTUtility.gregtechId("n_propanol"))
                .fluid()
                .components()
                .color(0xad9113)
                .build();

        //NPropanol.setFormula("CH3CH2CH2OH", true)

        PolytetrafluoroethyleneSolution = new Material.Builder(15102, GTUtility.gregtechId('polytetrafluoroethylene_solution'))
                .fluid()
                .components(Water, 1, Polytetrafluoroethylene, 1)
                .colorAverage()
                .build();

        MixedNitrochlorobenzeneSolution = new Material.Builder(15103, GTUtility.gregtechId('mixed_nitrochlorobenzene_solution'))
                .fluid()
                .color(0xc18c18)
                .build();

        MixedDichlorobenzeneSolution = new Material.Builder(15104, GTUtility.gregtechId('mixed_dichlorobenzene_solution'))
                .fluid()
                .color(0xFF7F7F)
                .build();

        Novolacs = new Material.Builder(15105, GTUtility.gregtechId('novolacs'))
                .fluid()
                .color(0xbfa26f)
                .build();

        SiliconTetrachloride = new Material.Builder(15106, GTUtility.gregtechId('silicon_tetrachloride'))
                .fluid()
                .components(Silicon, 1, Chlorine, 4)
                .color(0x63827f)
                .build();

        PurifiedSiliconTetrachloride = new Material.Builder(15107, GTUtility.gregtechId('purified_silicon_tetrachloride'))
                .fluid()
                .components(Silicon, 1, Chlorine, 4)
                .color(0x7fa3a0)
                .build();

        Ethanolamine = new Material.Builder(15108, GTUtility.gregtechId('ethanolamine'))
                .fluid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .color(0x56a6e3)
                .build();

        Diethanolamine = new Material.Builder(15109, GTUtility.gregtechId('diethanolamine'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1, Oxygen, 2)
                .color(0x4296d6)
                .build();

        Triethanolamine = new Material.Builder(15110, GTUtility.gregtechId('triethanolamine'))
                .fluid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1, Oxygen, 3)
                .color(0x2e86c9)
                .build();

        EthyleneGlycol = new Material.Builder(15111, GTUtility.gregtechId('ethylene_glycol'))
                .fluid()
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .color(0x2e86c9)
                .build();

        EthyleneOxide = new Material.Builder(15112, GTUtility.gregtechId('ethylene_oxide'))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .colorAverage()
                .build();

        EthanolamineMix = new Material.Builder(15113, GTUtility.gregtechId('ethanolamine_mix'))
                .fluid()
                .color(0x3e86bd)
                .build();

        RichAmine = new Material.Builder(15114, GTUtility.gregtechId('rich_amine'))
                .fluid()
                .color(0x3ea8bd)
                .build();

        Pentane = new Material.Builder(15115, GTUtility.gregtechId('pentane'))
                .fluid()
                .components(Carbon, 5, Hydrogen, 12)
                .color(0xe8e7be)
                .build();

        Hexane = new Material.Builder(15116, GTUtility.gregtechId('hexane'))
                .fluid()
                .components(Carbon, 6, Hydrogen, 14)
                .color(0xcfceb6)
                .build();

        Furfural = new Material.Builder(15117, GTUtility.gregtechId('furfural'))
                .fluid()
                .components(Carbon, 5, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .build();

        Cresol = new Material.Builder(15118, GTUtility.gregtechId("cresol"))
                .fluid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                .color(0x827863)
                .build();

        Xylenol = new Material.Builder(15120, GTUtility.gregtechId("xylenol"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .color(0x693834)
                .build();

        Creosol = new Material.Builder(15121, GTUtility.gregtechId("creosol"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 2)
                .color(0x473339)
                .build();

        Anthracene = new Material.Builder(15122, GTUtility.gregtechId("anthracene"))
                .fluid()
                .components(Carbon, 14, Hydrogen, 10)
                .color(0x000000)
                .build();

        Triethylenediamine = new Material.Builder(15123, GTUtility.gregtechId('triethylenediamine'))
                .dust()
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 2)
                .colorAverage()
                .build()

        Polyurethane = new Material.Builder(15124, GTUtility.gregtechId('polyurethane'))
                .polymer(1)
                .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
                .color(0xd1d1d1)
                .flags(GENERATE_FINE_WIRE)
                .fluidTemp(438)
                .build()
                //.setFormula("(C15H10N2O2)(C2H6O2)", true);

        DiethylEther = new Material.Builder(15125, GTUtility.gregtechId('diethyl_ether'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()
                //.setFormula("(C2H5)2O", true);

        Polypropylene = new Material.Builder(15126, GTUtility.gregtechId('polypropylene'))
                .polymer(1)
                .components(Carbon, 3, Hydrogen, 6)
                .color(0xdfe39a)
                .flags(GENERATE_FOIL)
                .build();

        Dimethylformamide = new Material.Builder(15127, GTUtility.gregtechId('dimethylformamide'))
                .fluid()
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1)
                .colorAverage()
                .build()
                //.setFormula("(CH3)2NCH", true);

        CativaProcessCatalyst = new Material.Builder(15128, GTUtility.gregtechId('cativa_process_catalyst'))
                .dust()
                .color(0x695449)
                .build()
                //.setFormula("[PPN][IrI2(CO)2]", true);

        TwoEthylanthraquinone = new Material.Builder(15129, GTUtility.gregtechId('two_ethylanthraquinone'))
                .fluid()
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .colorAverage()
                .build()

        TwoEthylanthrahydroquinone = new Material.Builder(15130, GTUtility.gregtechId('two_ethylanthrahydroquinone'))
                .fluid()
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 2)
                .colorAverage()
                .build()

        Butanone = new Material.Builder(15131, GTUtility.gregtechId('butanone'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .colorAverage()
                .build()

        Durene = new Material.Builder(15132, GTUtility.gregtechId('durene'))
                .dust()
                .components(Carbon, 10, Hydrogen, 14)
                .colorAverage()
                .build()

        PyromelliticDianhydride = new Material.Builder(15133, GTUtility.gregtechId('pyromellitic_dianhydride'))
                .dust()
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .colorAverage()
                .build()

        FourFourOxydianiline = new Material.Builder(15134, GTUtility.gregtechId('four_four_oxydianiline'))
                .dust()
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .colorAverage()
                .build()

        KaptonK = new Material.Builder(15135, GTUtility.gregtechId('kapton_k'))
                .polymer(1)
                .components(Carbon, 22, Hydrogen, 10, Nitrogen, 2, Oxygen, 5)
                .color(0xfabe19)
                .build()

        KaptonE = new Material.Builder(15136, GTUtility.gregtechId('kapton_e'))
                .polymer(1)
                .components(Carbon, 22, Hydrogen, 10, Nitrogen, 2, Oxygen, 5)
                .color(0xdcfa19)
                .build()

        TwoButanol = new Material.Builder(15137, GTUtility.gregtechId('two_butanol'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()

        Acetamide = new Material.Builder(15138, GTUtility.gregtechId('acetamide'))
                .dust()
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build()

        Hydrazine = new Material.Builder(15139, GTUtility.gregtechId('hydrazine'))
                .fluid()
                .components(Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .build()

        Ethylenediamine = new Material.Builder(15140, GTUtility.gregtechId('ethylenediamine'))
                .fluid()
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .build()

        Pyrocatechol = new Material.Builder(15141, GTUtility.gregtechId('pyrocatechol'))
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .build()

        AcetoneCyanohydrin = new Material.Builder(15142, GTUtility.gregtechId('acetone_cyanohydrin'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build()

        MethylMethacrylate = new Material.Builder(15143, GTUtility.gregtechId('methyl_methacrylate'))
                .fluid()
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .colorAverage()
                .build()

        MethylMethacrylateEmulsion = new Material.Builder(15144, GTUtility.gregtechId('methyl_methacrylate_emulsion'))
                .fluid()
                .color(0x789c94)
                .build()

        PolymethylMethacrylateSolution = new Material.Builder(15145, GTUtility.gregtechId('polymethyl_methacrylate_solution'))
                .fluid()
                .color(0x79baad)
                .build()

        PolystyreneSulfonate = new Material.Builder(15146, GTUtility.gregtechId('polystyrene_sulfonate'))
                .polymer(1)
                .color(0x8f795e)
                .build()
                //.setFormula("(CH2CHC6H4SO3H)", true)

        EthylenediaminetetraaceticAcid = new Material.Builder(15147, GTUtility.gregtechId('ethylenediaminetetraacetic_acid'))
                .dust()
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .colorAverage()
                .build()

        TetrasodiumEthylenediaminetetraaceticAcid = new Material.Builder(15148, GTUtility.gregtechId('tetrasodium_ethylenediaminetetraacetic_acid'))
                .dust()
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Sodium, 4, Oxygen, 8)
                .colorAverage()
                .build()

        Urea = new Material.Builder(15149, GTUtility.gregtechId('urea'))
                .dust()
                .components(Carbon, 1, Oxygen, 1, Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .build()

        //Urea.setFormula("CO(NH2)2", true)

        Diiodobenzene = new Material.Builder(15150, GTUtility.gregtechId('diiodobenzene'))
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Iodine, 2)
                .colorAverage()
                .build()

        TerephthalicAcid = new Material.Builder(15151, GTUtility.gregtechId('terephthalic_acid'))
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .colorAverage()
                .build()

        Bistrichloromethylbenzene = new Material.Builder(15152, GTUtility.gregtechId('bistrichloromethylbenzene'))
                .fluid()
                .components(Carbon, 6, Hydrogen, 4, Carbon, 2, Chlorine, 6)
                .colorAverage()
                .build()
                //.setFormula("C6H4(CCl3)2", true)

        TerephthaloylChloride = new Material.Builder(15153, GTUtility.gregtechId('terephthaloyl_chloride'))
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .build()

        Kevlar = new Material.Builder(15154, GTUtility.gregtechId('kevlar'))
                .polymer(3)
                .color(0x4d443e)
                .flags(GENERATE_PLATE)
                .build()

        Kevlar//.setFormula("COC6H4CONHC6H4NH", true)

        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(15155, GTUtility.gregtechId('biphenyl_tetracarboxylic_acid_dianhydride'))
                .dust()
                .components(Carbon, 16, Hydrogen, 16, Oxygen, 6)
                .colorAverage()
                .build()

        CelluloseAcetate = new Material.Builder(15157, GTUtility.gregtechId('cellulose_acetate'))
                .polymer()
                .flags(GENERATE_FINE_WIRE)
                .components(Carbon, 76, Hydrogen, 114, Oxygen, 49)
                .color(0xd4c9ab)
                .build()

        Pyridine = new Material.Builder(15158, GTUtility.gregtechId('pyridine'))
                .fluid()
                .components(Carbon, 5, Hydrogen, 5, Nitrogen, 1)
                .color(0x202836)
                .build()

        Quinoline = new Material.Builder(15159, GTUtility.gregtechId('quinoline'))
                .fluid()
                .components(Carbon, 9, Hydrogen, 7, Nitrogen, 1)
                .color(0x2e3620)
                .build()

        DimethylCarbonate = new Material.Builder(15160, GTUtility.gregtechId('dimethyl_carbonate'))
                .fluid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .colorAverage()
                .build()

        DiethyleneGlycol = new Material.Builder(15161, GTUtility.gregtechId('diethylene_glycol'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 3)
                .color(0x2ec9c1)
                .build()

        DiglycolicAcid = new Material.Builder(15162, GTUtility.gregtechId('diglycolic_acid'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 5)
                .colorAverage()
                .build()

        NOctanol = new Material.Builder(15163, GTUtility.gregtechId('n_octanol'))
                .fluid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .color(0xbf8454)
                .build()

        //NOctanol.setFormula("C8H17OH", true)

        NOctylamine = new Material.Builder(15164, GTUtility.gregtechId('n_octylamine'))
                .fluid()
                .components(Carbon, 8, Hydrogen, 19, Nitrogen, 1)
                .color(0xeb8634)
                .build()

        Dioctylamine = new Material.Builder(15165, GTUtility.gregtechId('dioctylamine'))
                .fluid()
                .components(Carbon, 16, Hydrogen, 35, Nitrogen, 1)
                .colorAverage()
                .build()

        TetraoctylDiglycolamide = new Material.Builder(15166, GTUtility.gregtechId('tetraoctyl_diglycolamide'))
                .fluid()
                .components(Carbon, 36, Hydrogen, 72, Nitrogen, 2, Oxygen, 3)
                .colorAverage()
                .build()

        TwoEthylTwoHexenal = new Material.Builder(15167, GTUtility.gregtechId('two_ethyl_two_hexenal'))
                .fluid()
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 1)
                .colorAverage()
                .build()

        TwoEthylhexanol = new Material.Builder(15168, GTUtility.gregtechId('two_ethylhexanol'))
                .fluid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcid = new Material.Builder(15169, GTUtility.gregtechId('di_two_ethylhexyl_phosphoric_acid'))
                .fluid()
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .color(0xb5a677)
                .build()

        //DiTwoEthylhexylPhosphoricAcid.setFormula("(C8H17O)2PO(OH)2", true)

        LauricAcid = new Material.Builder(15170, GTUtility.gregtechId('lauric_acid'))
                .fluid()
                .components(Carbon, 12, Hydrogen, 24, Oxygen, 2)
                .color(0xe39c32)
                .build()

        CapricAcid = new Material.Builder(15171, GTUtility.gregtechId('capric_acid'))
                .fluid()
                .components(Carbon, 10, Hydrogen, 20, Oxygen, 2)
                .color(0xe3ba32)
                .build()

        PrimaryAmineN = new Material.Builder(15172, GTUtility.gregtechId('primary_amine_n'))
                .fluid()
                .components(Carbon, 20, Hydrogen, 43, Nitrogen, 1)
                .color(0x8533e8)
                .build()

        NineOctadecene = new Material.Builder(15173, GTUtility.gregtechId('nine_octadecanone'))
                .fluid()
                .components(Carbon, 18, Hydrogen, 36, Oxygen, 1)
                .colorAverage()
                .build()

        TriOctylDecylAmine = new Material.Builder(15174, GTUtility.gregtechId('tri_octyl_decyl_amine'))
                .fluid()
                .components(Carbon, 54, Hydrogen, 111, Nitrogen, 1)
                .color(0x6776c9)
                .build()

        Diethylbenzene = new Material.Builder(15175, GTUtility.gregtechId('diethylbenzene'))
                .fluid()
                .components(Carbon, 10, Hydrogen, 14)
                .color(0xad9797)
                .build()

        Divinylbenzene = new Material.Builder(15176, GTUtility.gregtechId('divinylbenzene'))
                .fluid()
                .components(Carbon, 10, Hydrogen, 10)
                .color(0xad9797)
                .build()

        NButanol = new Material.Builder(15177, GTUtility.gregtechId('n_butanol'))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()

        DibutylCarbitol = new Material.Builder(15178, GTUtility.gregtechId('dibutyl_carbitol'))
                .fluid()
                .components(Carbon, 12, Hydrogen, 26, Oxygen, 3)
                .color(0x89db6b)
                .build()

        //DibutylCarbitol.setFormula("(CH3CH2CH2CH2OCH2CH2)2O", true)

        MonoTwoEthylhexylPhosphoricAcid = new Material.Builder(15179, GTUtility.gregtechId('mono_two_ethylhexyl_phosphoric_acid'))
                .fluid()
                .components(Carbon, 16, Hydrogen, 34, Oxygen, 3, Phosphorus, 1)
                .color(0xb5a677)
                .build()

        //MonoTwoEthylhexylPhosphoricAcid.setFormula("(C8H17O)2PO(OH)", true)

        MethylIsobutylKetone = new Material.Builder(15180, GTUtility.gregtechId('methyl_isobutyl_ketone'))
                .fluid()
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 1)
                .color(0x86dbb1)
                .build()

        MethylIsobutylCarbinol = new Material.Builder(15181, GTUtility.gregtechId('methyl_isobutyl_carbinol'))
                .fluid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
                .color(0x79c4c7)
                .build()

        NHexanol = new Material.Builder(15182, GTUtility.gregtechId("n_hexanol"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
                .color(0xff9640)
                .build();

        //NHexanol.setFormula("C6H13OH", true)

        NDecanol = new Material.Builder(15183, GTUtility.gregtechId("n_decanol"))
                .fluid()
                .components(Carbon, 10, Hydrogen, 22, Oxygen, 1)
                .color(0xdb8035)
                .build();

        //NDecanol.setFormula("C10H21OH", true)

        NDodecanol = new Material.Builder(15184, GTUtility.gregtechId("n_dodecanol"))
                .fluid()
                .fluidTemp(298)
                .components(Carbon, 12, Hydrogen, 26, Oxygen, 1)
                .color(0xbd6e2d)
                .build();

        //NDodecanol.setFormula("C12H25OH", true)

        NTetradecanol = new Material.Builder(15185, GTUtility.gregtechId("n_tetradecanol"))
                .fluid()
                .fluidTemp(311)
                .components(Carbon, 14, Hydrogen, 30, Oxygen, 1)
                .color(0x2177ff)
                .build();

        //NTetradecanol.setFormula("C14H29OH", true)

        NHexadecanol = new Material.Builder(15186, GTUtility.gregtechId("n_hexadecanol"))
                .fluid()
                .fluidTemp(323)
                .components(Carbon, 16, Hydrogen, 34, Oxygen, 1)
                .color(0x824b1e)
                .build();

        //NHexadecanol.setFormula("C16H33OH", true)

        OleicAcid = new Material.Builder(15187, GTUtility.gregtechId('oleic_acid'))
                .dust().fluid()
                .components(Carbon, 18, Hydrogen, 34, Oxygen, 2)
                .color(0xb1d1ae)
                .build()

        LinoleicAcid = new Material.Builder(15188, GTUtility.gregtechId('linoleic_acid'))
                .dust().fluid()
                .components(Carbon, 18, Hydrogen, 32, Oxygen, 2)
                .color(0xbfd1a3)
                .build()

        PalmiticAcid = new Material.Builder(15189, GTUtility.gregtechId('palmitic_acid'))
                .dust().fluid()
                .components(Carbon, 16, Hydrogen, 32, Oxygen, 2)
                .color(0xd4d392)
                .build()

        Capsaicin = new Material.Builder(15190, GTUtility.gregtechId("capsaicin"))
                .dust()
                .components(Carbon, 18, Hydrogen, 27, Nitrogen, 1, Oxygen, 3)
                .color(0xff1900)
                .build();

        Diisopropylamine = new Material.Builder(15191, GTUtility.gregtechId("diisopropylamine"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1)
                .colorAverage()
                .build();

        Diisopropylaminoethanol = new Material.Builder(15192, GTUtility.gregtechId("diisopropylaminoethanol"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 19, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        IsopropylAlcohol = new Material.Builder(15193, GTUtility.gregtechId("isopropyl_alcohol"))
                .fluid()
                .components(Carbon, 3, Hydrogen, 8, Oxygen, 1)
                .colorAverage()
                .build();

        //IsopropylAlcohol.setFormula("(CH3)2CHOH", true)

        Triethylamine = new Material.Builder(15194, GTUtility.gregtechId("triethylamine"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1)
                .color(0xe07d26)
                .build();

        Diethylamine = new Material.Builder(15195, GTUtility.gregtechId("diethylamine"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1)
                .color(0xf59542)
                .build();

        Ethylamine = new Material.Builder(15196, GTUtility.gregtechId("ethylamine"))
                .fluid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1)
                .color(0xf5a55f)
                .build();

        Diethylacetamide = new Material.Builder(15197, GTUtility.gregtechId("diethylacetamide"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 13, Oxygen, 1, Nitrogen, 1)
                .colorAverage()
                .build();

        Diethylacetimidamine = new Material.Builder(15198, GTUtility.gregtechId("diethylacetimidamine"))
                .fluid()
                .components(Carbon, 6, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .build();

        Novichok = new Material.Builder(15199, GTUtility.gregtechId("novichok"))
                .fluid()
                .components(Carbon, 7, Hydrogen, 16, Fluorine, 1, Nitrogen, 2, Oxygen, 1, Phosphorus, 1)
                .colorAverage()
                .build();

        IsoamylAlcohol = new Material.Builder(15200, GTUtility.gregtechId("isoamyl_alcohol"))
                .fluid()
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 1)
                .color(0x23ad13)
                .build();

        //IsoamylAlcohol.setFormula("(CH3)2CHCH2CH2OH", true)

        IsobutylAlcohol = new Material.Builder(15201, GTUtility.gregtechId("isobutyl_alcohol"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .color(0xa0ad13)
                .build();

        //IsobutylAlcohol.setFormula("(CH3)2CHCH2OH", true)

        CaprylicAcid = new Material.Builder(15202, GTUtility.gregtechId("caprylic_acid"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2)
                .color(0x748545)
                .build();

        OctanoylChloride = new Material.Builder(15203, GTUtility.gregtechId("octanoyl_chloride"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 15, Chlorine, 1, Oxygen, 1)
                .color(0x458548)
                .build();

        PerfluorooctanoylFluoride = new Material.Builder(15204, GTUtility.gregtechId("perfluorooctanoyl_fluoride"))
                .fluid()
                .components(Carbon, 8, Fluorine, 16, Oxygen, 1)
                .color(0x288a7b)
                .build();

        PerfluorooctanoicAcid = new Material.Builder(15205, GTUtility.gregtechId("perfluorooctanoic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 1, Fluorine, 15, Oxygen, 2)
                .color(0x24bfa8)
                .build();

        OneButene = new Material.Builder(15206, GTUtility.gregtechId("one_butene"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 8)
                .color(0x965a15)
                .build();

        TwoButene = new Material.Builder(15207, GTUtility.gregtechId("two_butene"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 8)
                .color(0xab6009)
                .build();

        NPentanol = new Material.Builder(15208, GTUtility.gregtechId("n_pentanol"))
                .fluid()
                .components(Carbon, 5, Hydrogen, 12, Oxygen, 1)
                .color(0xb37834)
                .build();

        SodiumEthoxideSolution = new Material.Builder(15209, GTUtility.gregtechId("sodium_ethoxide_solution"))
                .fluid()
                .components(Carbon, 2, Hydrogen, 5, Oxygen, 1, Sodium, 1, Ethanol, 1)
                .color(0xcc5050)
                .build();

        //SodiumEthoxideSolution.setFormula("(CH3CH2ONa)(H2O)", true)

        SodiumEthylXanthate = new Material.Builder(15210, GTUtility.gregtechId("sodium_ethyl_xanthate"))
                .dust()
                .components(Carbon, 3, Hydrogen, 5, Oxygen, 1, Sulfur, 2, Sodium, 1)
                .color(0xfdffbf)
                .build();

        //SodiumEthylXanthate.setFormula("CH3CH2OCS2Na", true)

        PotassiumAmylXanthate = new Material.Builder(15211, GTUtility.gregtechId("potassium_amyl_xanthate"))
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xe0d582)
                .build();

        //PotassiumAmylXanthate.setFormula("C5H11OCS2K", true)

        Isobutyraldehyde = new Material.Builder(15212, GTUtility.gregtechId("isobutyraldehyde"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .color(0x9ccf69)
                .build();

        SodiumIsobutylXanthate = new Material.Builder(15213, GTUtility.gregtechId("sodium_isobutyl_xanthate"))
                .dust()
                .components(Carbon, 5, Hydrogen, 9, Oxygen, 1, Sulfur, 2, Sodium, 1)
                .color(0xb1bf60)
                .build();

        //SodiumIsobutylXanthate.setFormula("(CH3)2CHCH2OCS2Na", true)

        PotassiumIsopropylXanthate = new Material.Builder(15214, GTUtility.gregtechId("potassium_isopropyl_xanthate"))
                .dust()
                .components(Carbon, 4, Hydrogen, 7, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xcbdb6b)
                .build();

        //PotassiumIsopropylXanthate.setFormula("(CH3)2CHOCS2K", true)

        PotassiumEthylXanthate = new Material.Builder(15215, GTUtility.gregtechId("potassium_ethyl_xanthate"))
                .dust()
                .components(Carbon, 3, Hydrogen, 5, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xfdffc8)
                .build();

        //PotassiumEthylXanthate.setFormula("CH3CH2OCS2K", true)

        Valeraldehyde = new Material.Builder(15216, GTUtility.gregtechId("valeraldehyde"))
                .fluid()
                .components(Carbon, 5, Hydrogen, 10, Oxygen, 1)
                .color(0xb3af34)
                .build();

        NHexadecylamine = new Material.Builder(15217, GTUtility.gregtechId("n_hexadecylamine"))
                .dust()
                .components(Carbon, 16, Hydrogen, 35, Nitrogen, 1)
                .color(0xcff5ff)
                .build();

        TertButylAlcohol = new Material.Builder(15218, GTUtility.gregtechId("tert_butyl_alcohol"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build();

        //TertButylAlcohol.setFormula("(CH3)3COH", true)

        ButylatedHydroxytoluene = new Material.Builder(15219, GTUtility.gregtechId("butylated_hydroxytoluene"))
                .fluid()
                .components(Carbon, 15, Hydrogen, 25, Oxygen, 1)
                .colorAverage()
                .build();

        //ButylatedHydroxytoluene.setFormula("((CH3)3C)2CH3C6H2OH", true)

        DimethylTertButylphenol = new Material.Builder(15220, GTUtility.gregtechId("dimethyl_tert_butylphenol"))
                .fluid()
                .components(Carbon, 12, Hydrogen, 18, Oxygen, 1)
                .colorAverage()
                .build();

        //DimethylTertButylphenol.setFormula("(CH3)2(CH3)3C7H2OH", true)

        AluminiumPhenolate = new Material.Builder(15221, GTUtility.gregtechId("aluminium_phenolate"))
                .fluid()
                .components(Carbon, 18, Hydrogen, 15, Aluminium, 1, Oxygen, 3)
                .colorAverage()
                .build();

        //AluminiumPhenolate.setFormula("Al(OC6H5)3", true)

        DiTertButylphenol = new Material.Builder(15222, GTUtility.gregtechId("di_tert_butylphenol"))
                .fluid()
                .components(Carbon, 14, Hydrogen, 22, Oxygen, 1)
                .colorAverage()
                .build();

        //DiTertButylphenol.setFormula("((CH3)3C)2C6H3OH", true)

        IsoOctane = new Material.Builder(15223, GTUtility.gregtechId("isooctane"))
                .fluid()
                .components(Carbon, 8, Hydrogen, 18)
                .colorAverage()
                .build();

        //IsoOctane.setFormula("(CH3)3CCH2CH(CH3)2", true)

        PurifiedIsoprene = new Material.Builder(15224, GTUtility.gregtechId("purified_isoprene"))
                .fluid()
                .components(Carbon, 5, Hydrogen, 8)
                .color(0x000000)
                .build();

        Cyclopentadiene = new Material.Builder(15225, GTUtility.gregtechId("cyclopentadiene"))
                .fluid()
                .components(Carbon, 5, Hydrogen, 6)
                .color(0x403c32)
                .build();

        CyclopentadieneSolution = new Material.Builder(15226, GTUtility.gregtechId("cyclopentadiene_solution"))
                .fluid()
                .components(Cyclopentadiene, 1, Benzene, 1)
                .colorAverage()
                .build();

        Ferrocene = new Material.Builder(15227, GTUtility.gregtechId("ferrocene"))
                .dust()
                .components(Carbon, 10, Hydrogen, 10, Iron, 1)
                .color(0x403c32)
                .build();

        //Ferrocene.setFormula("Fe(C5H5)2", true)

        Polyisoprene = new Material.Builder(15228, GTUtility.gregtechId("polyisoprene"))
                .dust()
                .iconSet(SHINY)
                .components(Carbon, 5, Hydrogen, 8)
                .color(0x1f1f1f)
                .build();

        Chloroethane = new Material.Builder(15229, GTUtility.gregtechId("chloroethane"))
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 5, Chlorine, 1)
                .colorAverage()
                .build();

        ExtractedCaprolactamSolution = new Material.Builder(15230, GTUtility.gregtechId("extracted_caprolactam_solution"))
                .fluid()
                .components(Caprolactam, 1, Toluene, 1)
                .colorAverage()
                .build();
        
        Trimethylaluminium = new Material.Builder(15231, GTUtility.gregtechId("trimethylaluminium"))
                .fluid()
                .components(Aluminium, 1, Carbon, 3, Hydrogen, 9)
                .color(0x7abfb4)
                .build();

        //Trimethylaluminium.setFormula("Al(CH3)3", true)

        Methylaluminoxane = new Material.Builder(15232, GTUtility.gregtechId("methylaluminoxane"))
                .dust()
                .components(Aluminium, 1, Carbon, 1, Hydrogen, 3, Oxygen, 1)
                .color(0x33a391)
                .build();

        ZirconoceneDichloride = new Material.Builder(15233, GTUtility.gregtechId("zirconocene_dichloride"))
                .dust()
                .components(Zirconium, 1, Carbon, 10, Hydrogen, 10, Chlorine, 2)
                .color(0x3ea0a3)
                .build();

        //ZirconoceneDichloride.setFormula("Zr(C5H5)2Cl2", true)

        Tetrahydrofuran = new Material.Builder(15234, GTUtility.gregtechId("tetrahydrofuran"))
                .fluid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .color(0xd13485)
                .build();

        SodiumCyclopentadienide = new Material.Builder(15235, GTUtility.gregtechId("sodium_cyclopentadienide"))
                .dust()
                .components(Sodium, 1, Carbon, 5, Hydrogen, 5)
                .colorAverage()
                .build();
      
        OctylHydroxamicAcid = new Material.Builder(15236, GTUtility.gregtechId("octyl_hydroxamic_acid"))
                .dust()
                .components(Carbon, 8, Hydrogen, 17, Oxygen, 2, Nitrogen, 1)
                .color(0xd47f31)
                .build();

        PotassiumOctylHydroxamate = new Material.Builder(15237, GTUtility.gregtechId("potassium_octyl_hydroxamate"))
                .dust()
                .components(Carbon, 8, Hydrogen, 16, Oxygen, 2, Nitrogen, 1, Potassium, 1)
                .color(0xd47f50)
                .build();

        PotassiumButylXanthate = new Material.Builder(15238, GTUtility.gregtechId("potassium_butyl_xanthate"))
                .dust()
                .components(Carbon, 5, Hydrogen, 9, Oxygen, 1, Sulfur, 2, Potassium, 1)
                .color(0xd1c675)
                .build();

        //PotassiumButylXanthate.setFormula("C4H9OCS2K", true)
    }
}