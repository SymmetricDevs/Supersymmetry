package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OrganicChemistryMaterials {
    public static void register() {
        
        log.infoMC("Registering Organic Chemistry Materials!");

        FourNitrochlorobenzene = new Material.Builder(15000, 'four_nitrochlorobenzene')
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .build();

        FourNitroaniline = new Material.Builder(15001, 'four_nitroaniline')
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build();

        ParaPhenylenediamine = new Material.Builder(15002, 'para_phenylenediamine')
                .dust()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzene = new Material.Builder(15003, 'two_two_dichlorohydrazobenzene')
                .dust()
                .components(Carbon, 12, Hydrogen, 10, Chlorine, 2, Nitrogen, 2)
                .colorAverage()
                .build();

        SodiumPhenoxide = new Material.Builder(15004, 'sodium_phenoxide')
                .dust()
                .components(Carbon, 6, Hydrogen, 5, Sodium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        PhthaloylDichloride = new Material.Builder(15005, 'phthaloyl_dichloride')
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .build();

        CaprolactamOxime = new Material.Builder(15006, 'caprolactam_oxime')
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        TNT = new Material.Builder(15007, 'tnt')
                .dust()
                .components(Carbon, 7, Hydrogen, 5, Nitrogen, 3, Oxygen, 6)
                .color(0xacb38d)
                .build();

        Polystyrene = new Material.Builder(15008, 'polystyrene')
                .polymer(1)
                .components(Carbon, 8, Hydrogen, 8)
                .color(0xa2a389)
                .build();

        OneTwoDichlorobenzene = new Material.Builder(15009, 'one_two_dichlorobenzene')
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .build();

        PolyvinylideneFluorine = new Material.Builder(15010, 'polyvinylidene_fluoride')
                .polymer(1)
                .color(0xfde3ff)
                .flags(GENERATE_FOIL)
                .components(Carbon, 2, Hydrogen, 2, Fluorine, 2)
                .fluidTemp(468)
                .build()

        Methylenedianiline = new Material.Builder(15011, 'methylenedianiline')
                .dust()
                .components(Carbon, 13, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .build()

        MethyleneDiphenylDiisocyanate = new Material.Builder(15012, 'methylene_diphenyl_diisocyanate')
                .dust()
                .components(Carbon, 15, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build()

        MemoryFoam = new Material.Builder(15013, 'memory_foam')
                .polymer(1)
                .flags(GENERATE_PLATE)
                .color(0xFFFFFF)
                .fluidTemp(438)
                .build()

        Rayon = new Material.Builder(15014, 'rayon')
                .polymer(1)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .flags(GENERATE_FINE_WIRE)
                .color(0xaee8d9)
                .fluidTemp(438)
                .build()
                .setFormula("C6H5(OH)4OH", true);

        AlkaliCellulose = new Material.Builder(15015, 'alkali_cellulose')
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Sodium, 1)
                .color(0x7d6547)
                .build()

        SodiumCelluloseXanthate = new Material.Builder(15016, 'sodium_cellulose_xanthate')
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Carbon, 1, Sulfur, 2, Sodium, 1)
                .color(0x7d6057)
                .build()

        PMMA = new Material.Builder(15017, 'pmma')
                .polymer(1)
                .color(0x72e0c9)
                .flags(GENERATE_FOIL)
                .components(Carbon, 5, Oxygen, 2, Hydrogen, 8)
                .fluidTemp(438)
                .build()

        PhthalicAnhydride = new Material.Builder(15018, 'phthalic_anhydride')
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .colorAverage()
                .build();

        ImpureCaprolactam = new Material.Builder(15019, 'impure_caprolactam')
                .dust()
                .color(0x242119)
                .build();

        CrudeStyrene = new Material.Builder(15020, "crude_styrene")
                .fluid()
                .color(0x4d4d3e)
                .build();

        ChlorinatedMethaneMixture = new Material.Builder(15021, "chlorinated_methane_mixture")
                .fluid(FluidTypes.GAS)
                .color(0x8327d9)
                .build();

        ChlorinatedChloromethaneMixture = new Material.Builder(15022, "chlorinated_chloromethane_mixture")
                .fluid(FluidTypes.GAS)
                .color(0x6124bd)
                .build();

        ChlorinatedDichloromethaneMixture = new Material.Builder(15023, "chlorinated_dichloromethane_mixture")
                .fluid(FluidTypes.GAS)
                .color(0x4922a3)
                .build();

        ChloromethaneSolution = new Material.Builder(15024, "chloromethane_solution")
                .fluid()
                .components(Water, 1, Chloromethane, 1)
                .colorAverage()
                .build();

        AcidicChlorodifluoromethane = new Material.Builder(15025, "acidic_chlorodifluoromethane")
                .fluid(FluidTypes.GAS)
                .color(0xbd97c7)
                .build();

        AcidicTetrafluoroethylene = new Material.Builder(15026, "acidic_tetrafluoroethylene")
                .fluid(FluidTypes.GAS)
                .color(0x726678)
                .build();

        TrinitromethaneSolution = new Material.Builder(15027, "trinitromethane_solution")
                .fluid()
                .color(0x333c52)
                .build();

        TetranitronmethaneSolution = new Material.Builder(15028, "tetranitromethane_solution")
                .fluid()
                .color(0x373352)
                .build();

        ImpureDimethyldichloroSilane = new Material.Builder(15029, "impure_dimethyldichlorosilane")
                .fluid()
                .color(0x291e38)
                .build();

        ChlorinatedGlycerol = new Material.Builder(15030, "chlorinated_glycerol")
                .fluid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build();

        EpichlorohydrinSolution = new Material.Builder(15031, "epichlorohydrin_solution")
                .fluid()
                .color(0x9c6241)
                .build();

        AllylAlcoholMix = new Material.Builder(15032, "allyl_alcohol_mix")
                .fluid()
                .color(0xbede9b)
                .build();

        DiluteEpichlorohydrin = new Material.Builder(15033, "dilute_epichlorohydrin")
                .fluid()
                .color(0x91664d)
                .build();

        Isobutane = new Material.Builder(15034, "isobutane")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 10)
                .color(0x8a7566)
                .build();

        Isobutylene = new Material.Builder(15035, "isobutylene")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 8)
                .color(0x917d61)
                .build();

        Cyclohexane = new Material.Builder(15036, "cyclohexane")
                .fluid()
                .components(Carbon, 6, Hydrogen, 12)
                .color(0x66553c)
                .build();

        NMethylIIPyrrolidone = new Material.Builder(15037, 'n_methyl_ii_pyrrolidone')
                .fluid()
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        SaltyNMethylIIPyrrolidone = new Material.Builder(15038, 'salty_n_methyl_ii_pyrrolidone')
                .fluid()
                .components(NMethylIIPyrrolidone, 1, Salt, 1)
                .colorAverage()
                .build();

        MethylAcetateSolution = new Material.Builder(15039, 'methyl_acetate_solution')
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, MethylAcetate, 1)
                .colorAverage()
                .build();

        TwoNitrochlorobenzeneSolution = new Material.Builder(15040, 'two_nitrochlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, Nitrochlorobenzene, 1)
                .colorAverage()
                .build();

        FourNitrochlorobenzeneSolution = new Material.Builder(15041, 'four_nitrochlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, FourNitrochlorobenzene, 1)
                .colorAverage()
                .build();

        FourNitroanilineSolution = new Material.Builder(15042, 'four_nitroaniline_solution')
                .fluid()
                .components(Toluene, 1, FourNitroaniline, 1)
                .colorAverage()
                .build();

        ParaPhenylenediamineSolution = new Material.Builder(15043, 'para_phenylenediamine_solution')
                .fluid()
                .components(Toluene, 1, ParaPhenylenediamine, 1)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzeneSolution = new Material.Builder(15044, 'two_two_dichlorohydrazobenzene_solution')
                .fluid()
                .components(Toluene, 1, TwoTwoDichlorohydrazobenzene, 1)
                .colorAverage()
                .build();

        DichlorobenzidineSolution = new Material.Builder(15045, 'dichlorobenzidine_solution')
                .fluid()
                .components(Toluene, 1, Dichlorobenzidine, 1)
                .colorAverage()
                .build();

        Xylene = new Material.Builder(15046, 'xylene')
                .fluid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x2e281f)
                .build();

        Phosgene = new Material.Builder(15047, 'phosgene')
                .fluid()
                .components(Carbon, 1, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build();

        Dichloroethane = new Material.Builder(15048, 'dichloroethane')
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .build();

        PhthaloylDichlorideSolution = new Material.Builder(15049, 'phthaloyl_dichloride_solution')
                .fluid()
                .components(Dichloroethane, 1, Water, 1, PhthaloylDichloride, 1)
                .colorAverage()
                .build();

        SodiumPhenoxideSolution = new Material.Builder(15050, 'sodium_phenoxide_solution')
                .fluid()
                .components(Water, 1, SodiumPhenoxide, 1)
                .colorAverage()
                .build();

        DiphenylIsophthalateSolution = new Material.Builder(15051, 'diphenyl_isophthalate_solution')
                .fluid()
                .components(Water, 2, Dichloroethane, 1, DiphenylIsophtalate, 1)
                .colorAverage()
                .build();

        DiaminobenzidineSolution = new Material.Builder(15052, 'diaminobenzidine_solution')
                .fluid()
                .components(Water, 1, Toluene, 1, Diaminobenzidine, 1)
                .colorAverage()
                .build();

        PBIPolymerizationMix = new Material.Builder(15053, 'pbi_polymerization_mix')
                .fluid()
                .color(0x40342b)
                .fluidTemp(450)
                .build();

        PBIPrePolymerFoam = new Material.Builder(15054, 'pbi_pre_polymer_foam')
                .fluid()
                .color(0x332d28)
                .fluidTemp(450)
                .build();

        ImpurePBISolution = new Material.Builder(15055, 'impure_pbi_solution')
                .fluid()
                .color(0x292623)
                .fluidTemp(450)
                .build();

        Dimethylacetamide = new Material.Builder(15056, 'dimethylacetamide')
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        PBISolution = new Material.Builder(15057, 'pbi_solution')
                .fluid()
                .components(Dimethylacetamide, 1, Polybenzimidazole, 7)
                .color(0x171410)
                .build();

        PBIWaste = new Material.Builder(15058, 'pbi_waste')
                .fluid()
                .color(0x202226)
                .build();

        Hydroxylamine = new Material.Builder(15059, 'hydroxylamine')
                .fluid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        Cyclohexanone = new Material.Builder(15060, 'cyclohexanone')
                .fluid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .color(0x2b1e11)
                .build();

        DilutedCyclohexanone = new Material.Builder(15061, 'diluted_cyclohexanone')
                .fluid()
                .components(Water, 1, Cyclohexanone, 1)
                .colorAverage()
                .build();

        CaprolactamOximeSolution = new Material.Builder(15062, 'caprolactam_oxime_solution')
                .fluid()
                .components(SulfuricAcid, 1, CaprolactamOxime, 1)
                .colorAverage()
                .build();

        BisphenolADiglycidylEther = new Material.Builder(15063, 'bisphenola_diglycidyl_ether')
                .fluid()
                .components(Carbon, 21, Hydrogen, 24, Oxygen, 4)
                .colorAverage()
                .build();

        ImpureEpoxyResin = new Material.Builder(15064, 'impure_epoxy_resin')
                .fluid()
                .components(SaltWater, 1, Epoxy, 1)
                .colorAverage()
                .build();

        UncuredEpoxyResin = new Material.Builder(15065, 'uncured_epoxy_resin')
                .fluid()
                .components(Epoxy, 1)
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .build();

        TNTSolution = new Material.Builder(15066, 'tnt_solution')
                .fluid()
                .components(TNT, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .build();

        VinylChlorideSolution = new Material.Builder(15067, 'vinyl_chloride_solution')
                .fluid()
                .components(Water, 1, VinylChloride, 1)
                .colorAverage()
                .build();

        PolyvinylChlorideSolution = new Material.Builder(15068, 'polyvinyl_chloride_solution')
                .fluid()
                .components(Water, 1, PolyvinylChloride, 1)
                .colorAverage()
                .build();

        StyreneSolution = new Material.Builder(15069, 'styrene_solution')
                .fluid()
                .components(Water, 1, Styrene, 1)
                .colorAverage()
                .build();

        PolystyreneSolution = new Material.Builder(15070, 'polystyrene_solution')
                .fluid()
                .components(Water, 1, Polystyrene, 1)
                .colorAverage()
                .build();

        VinylAcetateSolution = new Material.Builder(15071, 'vinyl_acetate_solution')
                .fluid()
                .components(Water, 1, VinylAcetate, 1)
                .colorAverage()
                .build();

        PolyvinylAcetateSolution = new Material.Builder(15072, 'polyvinyl_acetate_solution')
                .fluid()
                .components(Water, 1, PolyvinylAcetate, 1)
                .colorAverage()
                .build();

        Bleach = new Material.Builder(15073, 'bleach')
                .fluid()
                .components(Sodium, 1, Chlorine, 1, Oxygen, 1)
                .colorAverage()
                .build();

        ImpureBleach = new Material.Builder(15074, 'impure_bleach')
                .fluid()
                .components(Water, 3, Bleach, 1, Salt, 1)
                .colorAverage()
                .build();

        OneFourDichlorobenzeneSolution = new Material.Builder(15075, 'one_four_dichlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, Dichlorobenzene, 1)
                .colorAverage()
                .build();

        OneTwoDichlorobenzeneSolution = new Material.Builder(15076, 'one_two_dichlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, OneTwoDichlorobenzene, 1)
                .colorAverage()
                .build();

        DryEthanol = new Material.Builder(15077, 'dry_ethanol')
                .fluid()
                .components(Ethanol, 1)
                .color(0xeb6b34)
                .build();

        StyreneButadieneSolution = new Material.Builder(15078, 'styrene_butadiene_solution')
                .fluid()
                .components(Styrene, 1, Butadiene, 1, Ethanol, 1)
                .colorAverage()
                .build();

        Bromobutane = new Material.Builder(15079, 'bromobutane')
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .colorAverage()
                .build();

        DilutedBromobutane = new Material.Builder(15080, 'diluted_bromobutane')
                .fluid()
                .components(Water, 1, Bromobutane, 1)
                .colorAverage()
                .build();

        Butyllithium = new Material.Builder(15081, 'butyllithium')
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .colorAverage()
                .build();

        DilutedButyllithium = new Material.Builder(15082, 'diluted_butyllithium')
                .fluid()
                .components(Water, 1, Butyllithium, 1)
                .colorAverage()
                .build();

        PolymerizedStyreneButadieneSolution = new Material.Builder(15083, 'polymerized_styrene_butadiene_solution')
                .fluid()
                .color(0x332e2c)
                .color(0x3d2509)
                .build();

        MethylFormate = new Material.Builder(15084, "methyl_formate")
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .build();

        MethylFormateSolution = new Material.Builder(15085, "methyl_formate_solution")
                .fluid(FluidTypes.GAS)
                .components(Water, 1, MethylFormate, 1, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        Acetylene = new Material.Builder(15086, "acetylene")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        DilutedDichloroethane = new Material.Builder(15087, 'diluted_dichloroethane')
                .fluid()
                .components(Water, 3, Dichloroethane, 1)
                .colorAverage()
                .build();

        Formaldehyde = new Material.Builder(15088, "formaldehyde")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .colorAverage()
                .build();

        MethylamineMix = new Material.Builder(15089, 'methylamine_mix')
                .fluid()
                .color(0x6b4ea6)
                .build();

        Methylamine = new Material.Builder(15090, 'methylamine')
                .fluid()
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .color(0x794c91)
                .build()
                .setFormula("CH3NH2", true);

        Trimethylamine = new Material.Builder(15091, 'trimethylamine')
                .fluid()
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .color(0x4c2461)
                .build();

        Butynediol = new Material.Builder(15092, 'butynediol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .build();

        Butanediol = new Material.Builder(15093, 'butanediol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .build();

        GammaButyrolactone = new Material.Builder(15094, 'gamma_butyrolactone')
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .color(0x4242f5)
                .build();

        DilutedMethylIIPyrrolidone = new Material.Builder(15095, 'diluted_methyl_ii_pyrrolidone')
                .fluid()
                .components(Water, 1, NMethylIIPyrrolidone, 1)
                .colorAverage()
                .build();

        DimethyldichlorosilaneEmulsion = new Material.Builder(15096, 'dimethyldichlorosilane_emulsion')
                .fluid()
                .color(0x542a4c)
                .build();

        TetrafluoroethyleneEmulsion = new Material.Builder(15097, 'tetrafluoroethylene_emulsion')
                .fluid()
                .color(0x3b2e38)
                .build();

        Dichloromethane = new Material.Builder(15098, 'dichloromethane')
                .fluid()
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .colorAverage()
                .build();

        CarbonTetrachloride = new Material.Builder(15099, 'carbon_tetrachloride')
                .fluid()
                .components(Carbon, 1, Chlorine, 4)
                .colorAverage()
                .build();

        PhthalicAcidSolution = new Material.Builder(15100, 'phthalic_acid_solution')
                .fluid()
                .components(Dichloroethane, 1, PhthalicAcid, 1)
                .color(0xdbbbbd)
                .build();

        Butanol = new Material.Builder(15101, 'butanol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 7, Oxygen, 1)
                .colorAverage()
                .build();

        PolytetrafluoroethyleneSolution = new Material.Builder(15102, 'polytetrafluoroethylene_solution')
                .fluid()
                .components(Water, 1, Polytetrafluoroethylene, 1)
                .colorAverage()
                .build();

        MixedNitrochlorobenzeneSolution = new Material.Builder(15103, 'mixed_nitrochlorobenzene_solution')
                .fluid()
                .color(0xc18c18)
                .build();

        MixedDichlorobenzeneSolution = new Material.Builder(15104, 'mixed_dichlorobenzene_solution')
                .fluid()
                .color(0xFF7F7F)
                .build();

        Novolacs = new Material.Builder(15105, 'novolacs')
                .fluid()
                .color(0xbfa26f)
                .build();

        SiliconTetrachloride = new Material.Builder(15106, 'silicon_tetrachloride')
                .fluid()
                .components(Silicon, 1, Chlorine, 4)
                .color(0x63827f)
                .build();

        PurifiedSiliconTetrachloride = new Material.Builder(15107, 'purified_silicon_tetrachloride')
                .fluid()
                .components(Silicon, 1, Chlorine, 4)
                .color(0x7fa3a0)
                .build();

        Ethanolamine = new Material.Builder(15108, 'ethanolamine')
                .fluid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .color(0x56a6e3)
                .build();

        Diethanolamine = new Material.Builder(15109, 'diethanolamine')
                .fluid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1, Oxygen, 2)
                .color(0x4296d6)
                .build();

        Triethanolamine = new Material.Builder(15110, 'triethanolamine')
                .fluid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1, Oxygen, 3)
                .color(0x2e86c9)
                .build();

        EthyleneGlycol = new Material.Builder(15111, 'ethylene_glycol')
                .fluid()
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .color(0x2e86c9)
                .build();

        EthyleneOxide = new Material.Builder(15112, 'ethylene_oxide')
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .colorAverage()
                .build();

        EthanolamineMix = new Material.Builder(15113, 'ethanolamine_mix')
                .fluid()
                .color(0x3e86bd)
                .build();

        RichAmine = new Material.Builder(15114, 'rich_amine')
                .fluid()
                .color(0x3ea8bd)
                .build();

        Pentane = new Material.Builder(15115, 'pentane')
                .fluid()
                .components(Carbon, 5, Hydrogen, 12)
                .color(0xe8e7be)
                .build();

        Hexane = new Material.Builder(15116, 'hexane')
                .fluid()
                .components(Carbon, 6, Hydrogen, 14)
                .color(0xcfceb6)
                .build();

        Furfural = new Material.Builder(15117, 'furfural')
                .fluid()
                .components(Carbon, 5, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .build();

        Cresol = new Material.Builder(15118, "cresol")
                .fluid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                .color(0x827863)
                .build();

        Xylenol = new Material.Builder(15120, "xylenol")
                .fluid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .color(0x693834)
                .build();

        Creosol = new Material.Builder(15121, "creosol")
                .fluid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 2)
                .color(0x473339)
                .build();

        Anthracene = new Material.Builder(15122, "anthracene")
                .fluid()
                .components(Carbon, 14, Hydrogen, 10)
                .color(0x000000)
                .build();

        Triethylenediamine = new Material.Builder(15123, 'triethylenediamine')
                .dust()
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 2)
                .colorAverage()
                .build()

        Polyurethane = new Material.Builder(15124, 'polyurethane')
                .polymer(1)
                .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
                .color(0xd1d1d1)
                .flags(GENERATE_FINE_WIRE)
                .fluidTemp(438)
                .build()
                .setFormula("(C15H10N2O2)(C2H6O2)", true);

        DiethylEther = new Material.Builder(15125, 'diethyl_ether')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()
                .setFormula("(C2H5)2O", true);

        Polypropylene = new Material.Builder(15126, 'polypropylene')
                .polymer(1)
                .components(Carbon, 3, Hydrogen, 6)
                .color(0xdfe39a)
                .flags(GENERATE_FOIL)
                .build();

        Dimethylformamide = new Material.Builder(15127, 'dimethylformamide')
                .fluid()
                .components(Carbon, 3, Hydrogen, 7, Nitrogen, 1)
                .colorAverage()
                .build()
                .setFormula("(CH3)2NCH", true);

        CativaProcessCatalyst = new Material.Builder(15128, 'cativa_process_catalyst')
                .dust()
                .color(0x695449)
                .build()
                .setFormula("[PPN][IrI2(CO)2]", true);

        TwoEthylanthraquinone = new Material.Builder(15129, 'two_ethylanthraquinone')
                .fluid()
                .components(Carbon, 16, Hydrogen, 12, Oxygen, 2)
                .colorAverage()
                .build()

        TwoEthylanthrahydroquinone = new Material.Builder(15130, 'two_ethylanthrahydroquinone')
                .fluid()
                .components(Carbon, 16, Hydrogen, 14, Oxygen, 2)
                .colorAverage()
                .build()

        Butanone = new Material.Builder(15131, 'butanone')
                .fluid()
                .components(Carbon, 4, Hydrogen, 8, Oxygen, 1)
                .colorAverage()
                .build()

        Durene = new Material.Builder(15132, 'durene')
                .dust()
                .components(Carbon, 10, Hydrogen, 14)
                .colorAverage()
                .build()

        PyromelliticDianhydride = new Material.Builder(15133, 'pyromellitic_dianhydride')
                .dust()
                .components(Carbon, 10, Hydrogen, 2, Oxygen, 6)
                .colorAverage()
                .build()

        FourFourOxydianiline = new Material.Builder(15134, 'four_four_oxydianiline')
                .dust()
                .components(Carbon, 12, Hydrogen, 12, Nitrogen, 2, Oxygen, 1)
                .colorAverage()
                .build()

        KaptonK = new Material.Builder(15135, 'kapton_k')
                .polymer(1)
                .components(Carbon, 22, Hydrogen, 10, Nitrogen, 2, Oxygen, 5)
                .color(0xfabe19)
                .build()

        KaptonE = new Material.Builder(15136, 'kapton_e')
                .polymer(1)
                .components(Carbon, 22, Hydrogen, 10, Nitrogen, 2, Oxygen, 5)
                .color(0xdcfa19)
                .build()

        TwoButanol = new Material.Builder(15137, 'two_butanol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()

        Acetamide = new Material.Builder(15138, 'acetamide')
                .dust()
                .components(Carbon, 2, Hydrogen, 5, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build()

        Hydrazine = new Material.Builder(15139, 'hydrazine')
                .fluid()
                .components(Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .build()

        Ethylenediamine = new Material.Builder(15140, 'ethylenediamine')
                .fluid()
                .components(Carbon, 2, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .build()

        Pyrocatechol = new Material.Builder(15141, 'pyrocatechol')
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .build()

        AcetoneCyanohydrin = new Material.Builder(15142, 'acetone_cyanohydrin')
                .fluid()
                .components(Carbon, 4, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build()

        MethylMethacrylate = new Material.Builder(15143, 'methyl_methacrylate')
                .fluid()
                .components(Carbon, 5, Hydrogen, 8, Oxygen, 2)
                .colorAverage()
                .build()

        MethylMethacrylateEmulsion = new Material.Builder(15144, 'methyl_methacrylate_emulsion')
                .fluid()
                .color(0x789c94)
                .build()

        PolymethylMethacrylateSolution = new Material.Builder(15145, 'polymethyl_methacrylate_solution')
                .fluid()
                .color(0x79baad)
                .build()

        PolystyreneSulfonate = new Material.Builder(15146, 'polystyrene_sulfonate')
                .polymer(1)
                .color(0x8f795e)
                .build()
                .setFormula("(CH2CHC6H4SO3H)", true)

        EthylenediaminetetraaceticAcid = new Material.Builder(15147, 'ethylenediaminetetraacetic_acid')
                .dust()
                .components(Carbon, 10, Hydrogen, 16, Nitrogen, 2, Oxygen, 8)
                .colorAverage()
                .build()

        TetrasodiumEthylenediaminetetraaceticAcid = new Material.Builder(15148, 'tetrasodium_ethylenediaminetetraacetic_acid')
                .dust()
                .components(Carbon, 10, Hydrogen, 12, Nitrogen, 2, Sodium, 4, Oxygen, 8)
                .colorAverage()
                .build()

        Urea = new Material.Builder(15149, 'urea')
                .dust()
                .components(Carbon, 1, Oxygen, 1, Nitrogen, 2, Hydrogen, 4)
                .colorAverage()
                .build()

        Urea.setFormula("CO(NH2)2", true)

        Diiodobenzene = new Material.Builder(15150, 'diiodobenzene')
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Iodine, 2)
                .colorAverage()
                .build()

        TerephthalicAcid = new Material.Builder(15151, 'terephthalic_acid')
                .dust()
                .components(Carbon, 8, Hydrogen, 6, Oxygen, 4)
                .colorAverage()
                .build()

        Bistrichloromethylbenzene = new Material.Builder(15152, 'bistrichloromethylbenzene')
                .fluid()
                .components(Carbon, 6, Hydrogen, 4, Carbon, 2, Chlorine, 6)
                .colorAverage()
                .build()
                .setFormula("C6H4(CCl3)2", true)

        TerephthaloylChloride = new Material.Builder(15153, 'terephthaloyl_chloride')
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .build()

        Kevlar = new Material.Builder(15154, 'kevlar')
                .polymer(1)
                .color(0x4d443e)
                .build()

        Kevlar.setFormula("COC6H4CONHC6H4NH", true)

        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(15155, 'biphenyl_tetracarboxylic_acid_dianhydride')
                .dust()
                .components(Carbon, 16, Hydrogen, 16, Oxygen, 6)
                .colorAverage()
                .build()

        AceticAnhydride = new Material.Builder(15156, 'acetic_anhydride')
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 3)
                .color(0x8d939e)
                .build()

        CelluloseAcetate = new Material.Builder(15157, 'cellulose_acetate')
                .polymer()
                .flags(GENERATE_FINE_WIRE)
                .components(Carbon, 76, Hydrogen, 114, Oxygen, 49)
                .color(0xd4c9ab)
                .build()

        Pyridine = new Material.Builder(15158, 'pyridine')
                .fluid()
                .components(Carbon, 5, Hydrogen, 5, Nitrogen, 1)
                .color(0x202836)
                .build()

        Quinoline = new Material.Builder(15159, 'quinoline')
                .fluid()
                .components(Carbon, 9, Hydrogen, 7, Nitrogen, 1)
                .color(0x2e3620)
                .build()

        DimethylCarbonate = new Material.Builder(15160, 'dimethyl_carbonate')
                .fluid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 3)
                .colorAverage()
                .build()

        DiethyleneGlycol = new Material.Builder(15161, 'diethylene_glycol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 3)
                .color(0x2ec9c1)
                .build()

        DiglycolicAcid = new Material.Builder(15162, 'diglycolic_acid')
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 5)
                .colorAverage()
                .build()

        NOctanol = new Material.Builder(15163, 'n_octanol')
                .fluid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .color(0xbf8454)
                .build()

        NOctanol.setFormula("C8H17OH", true)

        NOctylamine = new Material.Builder(15164, 'n_octylamine')
                .fluid()
                .components(Carbon, 8, Hydrogen, 19, Nitrogen, 1)
                .color(0xeb8634)
                .build()

        Dioctylamine = new Material.Builder(15165, 'dioctylamine')
                .fluid()
                .components(Carbon, 16, Hydrogen, 35, Nitrogen, 1)
                .colorAverage()
                .build()

        TetraoctylDiglycolamide = new Material.Builder(15166, 'tetraoctyl_diglycolamide')
                .fluid()
                .components(Carbon, 36, Hydrogen, 72, Nitrogen, 2, Oxygen, 3)
                .colorAverage()
                .build()

        TwoEthylTwoHexenal = new Material.Builder(15167, 'two_ethyl_two_hexenal')
                .fluid()
                .components(Carbon, 8, Hydrogen, 14, Oxygen, 1)
                .colorAverage()
                .build()

        TwoEthylhexanol = new Material.Builder(15168, 'two_ethylhexanol')
                .fluid()
                .components(Carbon, 8, Hydrogen, 18, Oxygen, 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcid = new Material.Builder(15169, 'di_two_ethylhexyl_phosphoric_acid')
                .fluid()
                .components(Carbon, 16, Hydrogen, 35, Oxygen, 4, Phosphorus, 1)
                .color(0xb5a677)
                .build()

        DiTwoEthylhexylPhosphoricAcid.setFormula("(C8H17O)2PO(OH)2", true)

        LauricAcid = new Material.Builder(15170, 'lauric_acid')
                .fluid()
                .components(Carbon, 12, Hydrogen, 24, Oxygen, 2)
                .color(0xe39c32)
                .build()

        CapricAcid = new Material.Builder(15171, 'capric_acid')
                .fluid()
                .components(Carbon, 10, Hydrogen, 20, Oxygen, 2)
                .color(0xe3ba32)
                .build()

        PrimaryAmineN = new Material.Builder(15172, 'primary_amine_n')
                .fluid()
                .components(Carbon, 20, Hydrogen, 43, Nitrogen, 1)
                .color(0x8533e8)
                .build()

        NineOctadecene = new Material.Builder(15173, 'nine_octadecanone')
                .fluid()
                .components(Carbon, 18, Hydrogen, 36, Oxygen, 1)
                .colorAverage()
                .build()

        TriOctylDecylAmine = new Material.Builder(15174, 'tri_octyl_decyl_amine')
                .fluid()
                .components(Carbon, 54, Hydrogen, 111, Nitrogen, 1)
                .color(0x6776c9)
                .build()

        Diethylbenzene = new Material.Builder(15175, 'diethylbenzene')
                .fluid()
                .components(Carbon, 10, Hydrogen, 14)
                .color(0xad9797)
                .build()

        Divinylbenzene = new Material.Builder(15176, 'divinylbenzene')
                .fluid()
                .components(Carbon, 10, Hydrogen, 10)
                .color(0xad9797)
                .build()

        NButanol = new Material.Builder(15177, 'n_butanol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 1)
                .colorAverage()
                .build()

        DibutylCarbitol = new Material.Builder(15178, 'dibutyl_carbitol')
                .fluid()
                .components(Carbon, 12, Hydrogen, 26, Oxygen, 3)
                .color(0x89db6b)
                .build()

        DibutylCarbitol.setFormula("(CH3CH2CH2CH2OCH2CH2)2O", true)

        MonoTwoEthylhexylPhosphoricAcid = new Material.Builder(15179, 'mono_two_ethylhexyl_phosphoric_acid')
                .fluid()
                .components(Carbon, 16, Hydrogen, 34, Oxygen, 3, Phosphorus, 1)
                .color(0xb5a677)
                .build()

        MonoTwoEthylhexylPhosphoricAcid.setFormula("(C8H17O)2PO(OH)", true)

        MethylIsobutylKetone = new Material.Builder(15180, 'methyl_isobutyl_ketone')
                .fluid()
                .components(Carbon, 6, Hydrogen, 12, Oxygen, 1)
                .color(0x86dbb1)
                .build()

        MethylIsobutylCarbinol = new Material.Builder(15181, 'methyl_isobutyl_carbinol')
                .fluid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
                .color(0x79c4c7)
                .build()

        NHexanol = new Material.Builder(15182, "n_hexanol")
                .fluid()
                .components(Carbon, 6, Hydrogen, 14, Oxygen, 1)
                .color(0xff9640)
                .build();

        NHexanol.setFormula("C6H13OH", true)

        NDecanol = new Material.Builder(15183, "n_decanol")
                .fluid()
                .components(Carbon, 10, Hydrogen, 22, Oxygen, 1)
                .color(0xdb8035)
                .build();

        NDecanol.setFormula("C10H21OH", true)

        NDodecanol = new Material.Builder(15184, "n_dodecanol")
                .fluid()
                .components(Carbon, 12, Hydrogen, 26, Oxygen, 1)
                .color(0xbd6e2d)
                .build();

        NDodecanol.setFormula("C12H25OH", true)

        NTetradecanol = new Material.Builder(15185, "n_tetradecanol")
                .fluid()
                .components(Carbon, 14, Hydrogen, 30, Oxygen, 1)
                .color(0x2177ff)
                .build();

        NTetradecanol.setFormula("C14H29OH", true)

        NHexadecanol = new Material.Builder(15186, "n_hexadecanol")
                .fluid()
                .components(Carbon, 16, Hydrogen, 34, Oxygen, 1)
                .color(0x824b1e)
                .build();

        NHexadecanol.setFormula("C16H33OH", true)
    }
}