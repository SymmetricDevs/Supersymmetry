import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OrangicChemistryMaterials {
    public static void init() {
        
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

        TNT = new Material.Builder(32024, 'tnt')
                .dust()
                .components(Carbon, 7, Hydrogen, 5, Nitrogen, 3, Oxygen, 6)
                .color(0xacb38d)
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

        PolyvinylideneFluorine = new Material.Builder(20010, 'polyvinylidene_fluoride')
                .polymer(1)
                .color(0xfde3ff)
                .flags(GENERATE_FOIL)
                .components(Carbon, 2, Hydrogen, 2, Fluorine, 2)
                .fluidTemp(468)
                .build()

        Methylenedianiline = new Material.Builder(20015, 'methylenedianiline')
                .dust()
                .components(Carbon, 13, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .build()

        MethyleneDiphenylDiisocyanate = new Material.Builder(20016, 'methylene_diphenyl_diisocyanate')
                .dust()
                .components(Carbon, 15, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build()

        MemoryFoam = Material.Builder(20019, 'memory_foam')
                .polymer(1)
                .flags(GENERATE_PLATE)
                .color(0xFFFFFF)
                .fluidTemp(438)
                .build()

        Rayon = new Material.Builder(20020, 'rayon')
                .polymer(1)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .flags(GENERATE_FINE_WIRE)
                .color(0xaee8d9)
                .fluidTemp(438)
                .build()
                .setFormula("C6H5(OH)4OH", true);

        AlkaliCellulose = new Material.Builder(20021, 'alkali_cellulose')
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Sodium, 1)
                .color(0x7d6547)
                .build()

        SodiumCelluloseXanthate = new Material.Builder(20022, 'sodium_cellulose_xanthate')
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Carbon, 1, Sulfur, 2, Sodium, 1)
                .color(0x7d6057)
                .build()

        PMMA = new Material.Builder(20200, 'pmma')
                .polymer(1)
                .color(0x72e0c9)
                .flags(GENERATE_FOIL)
                .components(Carbon, 5, Oxygen, 2, Hydrogen, 8)
                .fluidTemp(438)
                .build()

        PhthalicAnhydride = new Material.Builder(32018, 'phthalic_anhydride')
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .colorAverage()
                .build();

        ImpureCaprolactam = new Material.Builder(32023, 'impure_caprolactam')
                .dust()
                .color(0x242119)
                .build();

        CrudeStyrene = new Material.Builder(11001, "crude_styrene")
                .fluid()
                .color(0x4d4d3e)
                .build();

        ChlorinatedMethaneMixture = new Material.Builder(11007, "chlorinated_methane_mixture")
                .fluid(FluidTypes.GAS)
                .color(0x8327d9)
                .build();

        ChlorinatedChloromethaneMixture = new Material.Builder(11008, "chlorinated_chloromethane_mixture")
                .fluid(FluidTypes.GAS)
                .color(0x6124bd)
                .build();

        ChlorinatedDichloromethaneMixture = new Material.Builder(11009, "chlorinated_dichloromethane_mixture")
                .fluid(FluidTypes.GAS)
                .color(0x4922a3)
                .build();

        ChloromethaneSolution = new Material.Builder(11010, "chloromethane_solution")
                .fluid()
                .components(Water, 1, Chloromethane, 1)
                .colorAverage()
                .build();

        AcidicChlorodifluoromethane = new Material.Builder(11015, "acidic_chlorodifluoromethane")
                .fluid(FluidTypes.GAS)
                .color(0xbd97c7)
                .build();

        AcidicTetrafluoroethylene = new Material.Builder(11016, "acidic_tetrafluoroethylene")
                .fluid(FluidTypes.GAS)
                .color(0x726678)
                .build();

        TrinitromethaneSolution = new Material.Builder(11017, "trinitromethane_solution")
                .fluid()
                .color(0x333c52)
                .build();

        TetranitronmethaneSolution = new Material.Builder(11018, "tetranitromethane_solution")
                .fluid()
                .color(0x373352)
                .build();

        ImpureDimethyldichloroSilane = new Material.Builder(11019, "impure_dimethyldichlorosilane")
                .fluid()
                .color(0x291e38)
                .build();

        ChlorinatedGlycerol = new Material.Builder(11021, "chlorinated_glycerol")
                .fluid()
                .components(Carbon, 3, Hydrogen, 6, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build();

        EpichlorohydrinSolution = new Material.Builder(11022, "epichlorohydrin_solution")
                .fluid()
                .color(0x9c6241)
                .build();

        AllylAlcoholMix = new Material.Builder(11023, "allyl_alcohol_mix")
                .fluid()
                .color(0xbede9b)
                .build();

        DiluteEpichlorohydrin = new Material.Builder(11024, "dilute_epichlorohydrin")
                .fluid()
                .color(0x91664d)
                .build();

        Isobutane = new Material.Builder(11025, "isobutane")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 10)
                .color(0x8a7566)
                .build();

        Isobutylene = new Material.Builder(11026, "isobutylene")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 4, Hydrogen, 8)
                .color(0x917d61)
                .build();

        Cyclohexane = new Material.Builder(11027, "cyclohexane")
                .fluid()
                .components(Carbon, 6, Hydrogen, 12)
                .color(0x66553c)
                .build();

        NMethylIIPyrrolidone = new Material.Builder(11029, 'n_methyl_ii_pyrrolidone')
                .fluid()
                .components(Carbon, 5, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        SaltyNMethylIIPyrrolidone = new Material.Builder(11030, 'salty_n_methyl_ii_pyrrolidone')
                .fluid()
                .components(NMethylIIPyrrolidone, 1, Salt, 1)
                .colorAverage()
                .build();

        MethylAcetateSolution = new Material.Builder(11031, 'methyl_acetate_solution')
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, MethylAcetate, 1)
                .colorAverage()
                .build();

        TwoNitrochlorobenzeneSolution = new Material.Builder(11032, 'two_nitrochlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, Nitrochlorobenzene, 1)
                .colorAverage()
                .build();

        FourNitrochlorobenzeneSolution = new Material.Builder(11033, 'four_nitrochlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, FourNitrochlorobenzene, 1)
                .colorAverage()
                .build();

        FourNitroanilineSolution = new Material.Builder(11034, 'four_nitroaniline_solution')
                .fluid()
                .components(Toluene, 1, FourNitroaniline, 1)
                .colorAverage()
                .build();

        ParaPhenylenediamineSolution = new Material.Builder(11035, 'para_phenylenediamine_solution')
                .fluid()
                .components(Toluene, 1, ParaPhenylenediamine, 1)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzeneSolution = new Material.Builder(11036, 'two_two_dichlorohydrazobenzene_solution')
                .fluid()
                .components(Toluene, 1, TwoTwoDichlorohydrazobenzene, 1)
                .colorAverage()
                .build();

        DichlorobenzidineSolution = new Material.Builder(11037, 'dichlorobenzidine_solution')
                .fluid()
                .components(Toluene, 1, Dichlorobenzidine, 1)
                .colorAverage()
                .build();

        Xylene = new Material.Builder(11038, 'xylene')
                .fluid()
                .components(Carbon, 8, Hydrogen, 10)
                .color(0x2e281f)
                .build();

        Phosgene = new Material.Builder(11039, 'phosgene')
                .fluid()
                .components(Carbon, 1, Oxygen, 1, Chlorine, 2)
                .colorAverage()
                .build();

        Dichloroethane = new Material.Builder(11040, 'dichloroethane')
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .build();

        PhthaloylDichlorideSolution = new Material.Builder(11041, 'phthaloyl_dichloride_solution')
                .fluid()
                .components(Dichloroethane, 1, Water, 1, PhthaloylDichloride, 1)
                .colorAverage()
                .build();

        SodiumPhenoxideSolution = new Material.Builder(11042, 'sodium_phenoxide_solution')
                .fluid()
                .components(Water, 1, SodiumPhenoxide, 1)
                .colorAverage()
                .build();

        DiphenylIsophthalateSolution = new Material.Builder(11043, 'diphenyl_isophthalate_solution')
                .fluid()
                .components(Water, 2, Dichloroethane, 1, DiphenylIsophtalate, 1)
                .colorAverage()
                .build();

        DiaminobenzidineSolution = new Material.Builder(11044, 'diaminobenzidine_solution')
                .fluid()
                .components(Water, 1, Toluene, 1, Diaminobenzidine, 1)
                .colorAverage()
                .build();

        PBIPolymerizationMix = new Material.Builder(11045, 'pbi_polymerization_mix')
                .fluid()
                .color(0x40342b)
                .fluidTemp(450)
                .build();

        PBIPrePolymerFoam = new Material.Builder(11046, 'pbi_pre_polymer_foam')
                .fluid()
                .color(0x332d28)
                .fluidTemp(450)
                .build();

        ImpurePBISolution = new Material.Builder(11047, 'impure_pbi_solution')
                .fluid()
                .color(0x292623)
                .fluidTemp(450)
                .build();

        DimethylacetamideSolution = new Material.Builder(11049, 'dimethylacetamide_solution')
                .fluid()
                .components(Water, 1, Dimethylacetamide, 1)
                .colorAverage()
                .build();

        Dimethylacetamide = new Material.Builder(11048, 'dimethylacetamide')
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        PBISolution = new Material.Builder(11050, 'pbi_solution')
                .fluid()
                .components(Dimethylacetamide, 1, Polybenzimidazole, 7)
                .color(0x171410)
                .build();

        PBIWaste = new Material.Builder(11051, 'pbi_waste')
                .fluid()
                .color(0x202226)
                .build();

        Hydroxylamine = new Material.Builder(11052, 'hydroxylamine')
                .fluid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        Cyclohexanone = new Material.Builder(11053, 'cyclohexanone')
                .fluid()
                .components(Hydrogen, 3, Nitrogen, 1, Oxygen, 1)
                .color(0x2b1e11)
                .build();

        DilutedCyclohexanone = new Material.Builder(11054, 'diluted_cyclohexanone')
                .fluid()
                .components(Water, 1, Cyclohexanone, 1)
                .colorAverage()
                .build();

        CaprolactamOximeSolution = new Material.Builder(11055, 'caprolactam_oxime_solution')
                .fluid()
                .components(SulfuricAcid, 1, CaprolactamOxime, 1)
                .colorAverage()
                .build();

        BisphenolADiglycidylEther = new Material.Builder(11056, 'bisphenola_diglycidyl_ether')
                .fluid()
                .components(Carbon, 21, Hydrogen, 24, Oxygen, 4)
                .colorAverage()
                .build();

        ImpureEpoxyResin = new Material.Builder(11057, 'impure_epoxy_resin')
                .fluid()
                .components(SaltWater, 1, Epoxy, 1)
                .colorAverage()
                .build();

        UncuredEpoxyResin = new Material.Builder(11058, 'uncured_epoxy_resin')
                .fluid()
                .components(Epoxy, 1)
                .colorAverage()
                .flags(DISABLE_DECOMPOSITION)
                .build();

        TNTSolution = new Material.Builder(11059, 'tnt_solution')
                .fluid()
                .components(TNT, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .build();

        VinylChlorideSolution = new Material.Builder(11064, 'vinyl_chloride_solution')
                .fluid()
                .components(Water, 1, VinylChloride, 1)
                .colorAverage()
                .build();

        PolyvinylChlorideSolution = new Material.Builder(11065, 'polyvinyl_chloride_solution')
                .fluid()
                .components(Water, 1, PolyvinylChloride, 1)
                .colorAverage()
                .build();

        StyreneSolution = new Material.Builder(11066, 'styrene_solution')
                .fluid()
                .components(Water, 1, Styrene, 1)
                .colorAverage()
                .build();

        PolystyreneSolution = new Material.Builder(11067, 'polystyrene_solution')
                .fluid()
                .components(Water, 1, Polystyrene, 1)
                .colorAverage()
                .build();

        VinylAcetateSolution = new Material.Builder(11068, 'vinyl_acetate_solution')
                .fluid()
                .components(Water, 1, VinylAcetate, 1)
                .colorAverage()
                .build();

        PolyvinylAcetateSolution = new Material.Builder(11069, 'polyvinyl_acetate_solution')
                .fluid()
                .components(Water, 1, PolyvinylAcetate, 1)
                .colorAverage()
                .build();

        Bleach = new Material.Builder(11070, 'bleach')
                .fluid()
                .components(Sodium, 1, Chlorine, 1, Oxygen, 1)
                .colorAverage()
                .build();

        ImpureBleach = new Material.Builder(11071, 'impure_bleach')
                .fluid()
                .components(Water, 3, Bleach, 1, Salt, 1)
                .colorAverage()
                .build();

        OneFourDichlorobenzeneSolution = new Material.Builder(11072, 'one_four_dichlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, Dichlorobenzene, 1)
                .colorAverage()
                .build();

        OneTwoDichlorobenzeneSolution = new Material.Builder(11073, 'one_two_dichlorobenzene_solution')
                .fluid()
                .components(Toluene, 1, OneTwoDichlorobenzene, 1)
                .colorAverage()
                .build();

        DryEthanol = new Material.Builder(11074, 'dry_ethanol')
                .fluid()
                .components(Ethanol, 1)
                .color(0xeb6b34)
                .build();

        StyreneButadieneSolution = new Material.Builder(11075, 'styrene_butadiene_solution')
                .fluid()
                .components(Styrene, 1, Butadiene, 1, Ethanol, 1)
                .colorAverage()
                .build();

        Bromobutane = new Material.Builder(11080, 'bromobutane')
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Bromine, 1)
                .colorAverage()
                .build();

        DilutedBromobutane = new Material.Builder(11081, 'diluted_bromobutane')
                .fluid()
                .components(Water, 1, Bromobutane, 1)
                .colorAverage()
                .build();

        Butyllithium = new Material.Builder(11082, 'butyllithium')
                .fluid()
                .components(Carbon, 4, Hydrogen, 9, Lithium, 1)
                .colorAverage()
                .build();

        DilutedButyllithium = new Material.Builder(11083, 'diluted_butyllithium')
                .fluid()
                .components(Water, 1, Butyllithium, 1)
                .colorAverage()
                .build();

        PolymerizedStyreneButadieneSolution = new Material.Builder(11084, 'polymerized_styrene_butadiene_solution')
                .fluid()
                .color(0x332e2c)
                .color(0x3d2509)
                .build();

        MethylFormate = new Material.Builder(11093, "methyl_formate")
                .fluid()
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .build();

        MethylFormateSolution = new Material.Builder(11094, "methyl_formate_solution")
                .fluid(FluidTypes.GAS)
                .components(Water, 1, MethylFormate, 1, SodiumHydroxide, 1)
                .colorAverage()
                .build();

        Acetylene = new Material.Builder(11095, "acetylene")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 2)
                .colorAverage()
                .build();

        DilutedDichloroethane = new Material.Builder(11097, 'diluted_dichloroethane')
                .fluid()
                .components(Water, 3, Dichloroethane, 1)
                .colorAverage()
                .build();

        Formaldehyde = new Material.Builder(11098, "formaldehyde")
                .fluid(FluidTypes.GAS)
                .components(Carbon, 1, Hydrogen, 2, Oxygen, 1)
                .colorAverage()
                .build();

        MethylamineMix = new Material.Builder(11099, 'methylamine_mix')
                .fluid()
                .color(0x6b4ea6)
                .build();

        Methylamine = new Material.Builder(11100, 'methylamine')
                .fluid()
                .components(Carbon, 1, Hydrogen, 5, Nitrogen, 1)
                .color(0x794c91)
                .build()
                .setFormula("CH3NH2", true);

        Trimethylamine = new Material.Builder(11101, 'trimethylamine')
                .fluid()
                .components(Carbon, 3, Hydrogen, 9, Nitrogen, 1)
                .color(0x4c2461)
                .build();

        Butynediol = new Material.Builder(11102, 'butynediol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .colorAverage()
                .build();

        Butanediol = new Material.Builder(11103, 'butanediol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 10, Oxygen, 2)
                .colorAverage()
                .build();

        GammaButyrolactone = new Material.Builder(11104, 'gamma_butyrolactone')
                .fluid()
                .components(Carbon, 4, Hydrogen, 6, Oxygen, 2)
                .color(0x4242f5)
                .build();

        DilutedMethylIIPyrrolidone = new Material.Builder(11105, 'diluted_methyl_ii_pyrrolidone')
                .fluid()
                .components(Water, 1, NMethylIIPyrrolidone, 1)
                .colorAverage()
                .build();

        DimethyldichlorosilaneEmulsion = new Material.Builder(11106, 'dimethyldichlorosilane_emulsion')
                .fluid()
                .color(0x542a4c)
                .build();

        TetrafluoroethyleneEmulsion = new Material.Builder(11107, 'tetrafluoroethylene_emulsion')
                .fluid()
                .color(0x3b2e38)
                .build();

        Dichloromethane = new Material.Builder(11109, 'dichloromethane')
                .fluid()
                .components(Carbon, 1, Hydrogen, 2, Chlorine, 2)
                .colorAverage()
                .build();

        CarbonTetrachloride = new Material.Builder(11110, 'carbon_tetrachloride')
                .fluid()
                .components(Carbon, 1, Chlorine, 4)
                .colorAverage()
                .build();

        PhthalicAcidSolution = new Material.Builder(11111, 'phthalic_acid_solution')
                .fluid()
                .components(Dichloroethane, 1, PhthalicAcid, 1)
                .color(0xdbbbbd)
                .build();

        Butanol = new Material.Builder(11112, 'butanol')
                .fluid()
                .components(Carbon, 4, Hydrogen, 7, Oxygen, 1)
                .colorAverage()
                .build();

        PolytetrafluoroethyleneSolution = new Material.Builder(11115, 'polytetrafluoroethylene_solution')
                .fluid()
                .components(Water, 1, Polytetrafluoroethylene, 1)
                .colorAverage()
                .build();

        MixedNitrochlorobenzeneSolution = new Material.Builder(11116, 'mixed_nitrochlorobenzene_solution')
                .fluid()
                .color(0xc18c18)
                .build();

        MixedDichlorobenzeneSolution = new Material.Builder(11117, 'mixed_dichlorobenzene_solution')
                .fluid()
                .color(0xFF7F7F)
                .build();

        Novolacs = new Material.Builder(11118, 'novolacs')
                .fluid()
                .color(0xbfa26f)
                .build();

        SiliconTetrachloride = new Material.Builder(11119, 'silicon_tetrachloride')
                .fluid()
                .components(Silicon, 1, Chlorine, 4)
                .color(0x63827f)
                .build();

        PurifiedSiliconTetrachloride = new Material.Builder(11120, 'purified_silicon_tetrachloride')
                .fluid()
                .components(Silicon, 1, Chlorine, 4)
                .color(0x7fa3a0)
                .build();

        Ethanolamine = new Material.Builder(11121, 'ethanolamine')
                .fluid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 1)
                .color(0x56a6e3)
                .build();

        Diethanolamine = new Material.Builder(11122, 'diethanolamine')
                .fluid()
                .components(Carbon, 4, Hydrogen, 11, Nitrogen, 1, Oxygen, 2)
                .color(0x4296d6)
                .build();

        Triethanolamine = new Material.Builder(11123, 'triethanolamine')
                .fluid()
                .components(Carbon, 6, Hydrogen, 15, Nitrogen, 1, Oxygen, 3)
                .color(0x2e86c9)
                .build();

        EthyleneGlycol = new Material.Builder(11124, 'ethylene_glycol')
                .fluid()
                .components(Carbon, 2, Hydrogen, 6, Oxygen, 2)
                .color(0x2e86c9)
                .build();

        EthyleneOxide = new Material.Builder(12046, 'ethylene_oxide')
                .fluid(FluidTypes.GAS)
                .components(Carbon, 2, Hydrogen, 4, Oxygen, 1)
                .colorAverage()
                .build();

        EthanolamineMix = new Material.Builder(12047, 'ethanolamine_mix')
                .fluid()
                .color(0x3e86bd)
                .build();

        RichAmine = new Material.Builder(12048, 'rich_amine')
                .fluid()
                .color(0x3ea8bd)
                .build();

        Pentane = new Material.Builder(12050, 'pentane')
                .fluid()
                .components(Carbon, 5, Hydrogen, 12)
                .color(0xe8e7be)
                .build();

        Hexane = new Material.Builder(12051, 'hexane')
                .fluid()
                .components(Carbon, 6, Hydrogen, 14)
                .color(0xcfceb6)
                .build();

        Furfural = new Material.Builder(12053, 'furfural')
                .fluid()
                .components(Carbon, 5, Hydrogen, 4, Oxygen, 2)
                .colorAverage()
                .build();

        Cresol = new Material.Builder(12099, "cresol")
                .fluid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 1)
                .color(0x827863)
                .build();

        Guaiacol = new Material.Builder(12100, "guaiacol")
                .fluid()
                .components(Carbon, 7, Hydrogen, 8, Oxygen, 2)
                .color(0x693834)
                .build();

        Xylenol = new Material.Builder(12101, "xylenol")
                .fluid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 1)
                .color(0x693834)
                .build();

        Creosol = new Material.Builder(12102, "creosol")
                .fluid()
                .components(Carbon, 8, Hydrogen, 10, Oxygen, 2)
                .color(0x473339)
                .build();

        Anthracene = new Material.Builder(12103, "anthracene")
                .fluid()
                .components(Carbon, 14, Hydrogen, 10)
                .color(0x000000)
                .build();



    }
}