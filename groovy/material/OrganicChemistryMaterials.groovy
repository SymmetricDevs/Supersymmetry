package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;
import supersymmetry.api.unification.material.properties.SuSyPropertyKey;
import supersymmetry.api.unification.material.properties.FiberProperty;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OrganicChemistryMaterials {
    public static void register() {
        
        log.infoMC('Registering Organic Chemistry Materials!');

        FourChloronitrobenzene = new Material.Builder(15000, SuSyUtility.susyId('four_chloronitrobenzene'))
                .dust()
                .components(Carbon * 6, Hydrogen * 4, Chlorine * 1, Nitrogen * 1, Oxygen * 2)
                .colorAverage()
                .build();

        FourNitroaniline = new Material.Builder(15001, SuSyUtility.susyId('four_nitroaniline'))
                .dust()
                .components(Carbon * 6, Hydrogen * 6, Nitrogen * 2, Oxygen * 2)
                .colorAverage()
                .build();

        ParaPhenylenediamine = new Material.Builder(15002, SuSyUtility.susyId('para_phenylenediamine'))
                .dust()
                .components(Carbon * 6, Hydrogen * 8, Nitrogen * 2)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzene = new Material.Builder(15003, SuSyUtility.susyId('two_two_dichlorohydrazobenzene'))
                .dust()
                .components(Carbon * 12, Hydrogen * 10, Chlorine * 2, Nitrogen * 2)
                .colorAverage()
                .build();

        SodiumPhenoxide = new Material.Builder(15004, SuSyUtility.susyId('sodium_phenoxide'))
                .dust()
                .components(Carbon * 6, Hydrogen * 5, Sodium * 1, Oxygen * 1)
                .colorAverage()
                .build();

        IsophthaloylChloride = new Material.Builder(15005, SuSyUtility.susyId('isophthaloyl_chloride'))
                .dust()
                .components(Carbon * 8, Hydrogen * 4, Chlorine * 2, Oxygen * 2)
                .colorAverage()
                .build();

        CaprolactamOxime = new Material.Builder(15006, SuSyUtility.susyId('caprolactam_oxime'))
                .dust()
                .components(Carbon * 6, Hydrogen * 11, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build();

        TNT = new Material.Builder(15007, SuSyUtility.susyId('tnt'))
                .dust()
                .components(Carbon * 7, Hydrogen * 5, Nitrogen * 3, Oxygen * 6)
                .color(0xacb38d)
                .build();

        Polystyrene = new Material.Builder(15008, SuSyUtility.susyId('polystyrene'))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(513))
                .components(Carbon * 8, Hydrogen * 8)
                .color(0xa2a389)
                .build();

        OneTwoDichlorobenzene = new Material.Builder(15009, SuSyUtility.susyId('one_two_dichlorobenzene'))
                .dust()
                .components(Carbon * 6, Hydrogen * 4, Chlorine * 2)
                .colorAverage()
                .build();

        PolyvinylideneFluorine = new Material.Builder(15010, SuSyUtility.susyId('polyvinylidene_fluoride'))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(468))
                .color(0xfde3ff)
                .flags(GENERATE_FOIL)
                .components(Carbon * 2, Hydrogen * 2, Fluorine * 2)
                .build()

        Methylenedianiline = new Material.Builder(15011, SuSyUtility.susyId('methylenedianiline'))
                .dust()
                .components(Carbon * 13, Hydrogen * 14, Nitrogen * 2)
                .colorAverage()
                .build()

        MethyleneDiphenylDiisocyanate = new Material.Builder(15012, SuSyUtility.susyId('methylene_diphenyl_diisocyanate'))
                .dust()
                .components(Carbon * 15, Hydrogen * 10, Nitrogen * 2, Oxygen * 2)
                .colorAverage()
                .build()

        EthyleneCarbonate = new Material.Builder(15013, SuSyUtility.susyId('ethylene_carbonate'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 4, Oxygen * 3)
                .color(0x348060)
                .build()

        Rayon = new Material.Builder(15014, SuSyUtility.susyId('rayon'))
                .components(Carbon * 6, Hydrogen * 10, Oxygen * 5)
                .color(0xaee8d9)
                .build()
                
        Rayon.setFormula('C6H5(OH)4OH', true)
        Rayon.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(true, false, true))

        AlkaliCellulose = new Material.Builder(15015, SuSyUtility.susyId('alkali_cellulose'))
                .dust()
                .components(Carbon * 6, Hydrogen * 9, Oxygen * 5, Sodium * 1)
                .color(0x7d6547)
                .build()

        SodiumCelluloseXanthate = new Material.Builder(15016, SuSyUtility.susyId('sodium_cellulose_xanthate'))
                .dust()
                .components(Carbon * 6, Hydrogen * 9, Oxygen * 5, Carbon * 1, Sulfur * 2, Sodium * 1)
                .color(0x7d6057)
                .build()

        PMMA = new Material.Builder(15017, SuSyUtility.susyId('pmma'))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(438))
                .color(0x72e0c9)
                .flags(GENERATE_FOIL)
                .components(Carbon * 5, Oxygen * 2, Hydrogen * 8)
                .build()

        PhthalicAnhydride = new Material.Builder(15018, SuSyUtility.susyId('phthalic_anhydride'))
                .dust()
                .components(Carbon * 8, Hydrogen * 4, Oxygen * 3)
                .colorAverage()
                .build();

        TributylPhosphate = new Material.Builder(15019, SuSyUtility.susyId('tributyl_phosphate'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 27, Oxygen * 4, Phosphorus * 1)
                .color(0xf5e3b3)
                .build();

        CrudeStyrene = new Material.Builder(15020, SuSyUtility.susyId('crude_styrene'))
                .liquid()
                .color(0x4d4d3e)
                .build();

        ChlorinatedMethaneMixture = new Material.Builder(15021, SuSyUtility.susyId('chlorinated_methane_mixture'))
                .liquid()
                .color(0x8327d9)
                .build();

        ChlorinatedChloromethaneMixture = new Material.Builder(15022, SuSyUtility.susyId('chlorinated_chloromethane_mixture'))
                .liquid()
                .color(0x6124bd)
                .build();

        ChlorinatedDichloromethaneMixture = new Material.Builder(15023, SuSyUtility.susyId('chlorinated_dichloromethane_mixture'))
                .liquid()
                .color(0x4922a3)
                .build();

        ChloromethaneSolution = new Material.Builder(15024, SuSyUtility.susyId('chloromethane_solution'))
                .liquid()
                .components(Chloromethane * 1, Water * 1)
                .colorAverage()
                .build();
        
        OneTwoDichloroethylene = new Material.Builder(15025, SuSyUtility.susyId('one_two_dichloroethylene'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 2, Chlorine * 2)
                .colorAverage()
                .build();

        AcidicTetrafluoroethylene = new Material.Builder(15026, SuSyUtility.susyId('acidic_tetrafluoroethylene'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetrafluoroethylene * 1, HydrogenChloride * 4)
                .color(0x726678)
                .build();

        TrinitromethaneSolution = new Material.Builder(15027, SuSyUtility.susyId('trinitromethane_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x333c52)
                .build();

        TetranitronmethaneSolution = new Material.Builder(15028, SuSyUtility.susyId('tetranitromethane_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetranitromethane * 1, SulfuricAcid * 1, Water * 3)
                .color(0x373352)
                .build();

        ImpureDimethyldichlorosilane = new Material.Builder(15029, SuSyUtility.susyId('impure_dimethyldichlorosilane'))
                .liquid()
                .color(0x291e38)
                .build();

        ChlorinatedGlycerol = new Material.Builder(15030, SuSyUtility.susyId('chlorinated_glycerol'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 3, Hydrogen * 6, Oxygen * 1, Chlorine * 2)
                .colorAverage()
                .build();

        EpichlorohydrinSolution = new Material.Builder(15031, SuSyUtility.susyId('epichlorohydrin_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Epichlorohydrin * 1, Salt * 1, Water * 3)
                .color(0x9c6241)
                .build();

        AllylAlcoholMix = new Material.Builder(15032, SuSyUtility.susyId('allyl_alcohol_mix'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xbede9b)
                .build();

        DilutedEpichlorohydrin = new Material.Builder(15033, SuSyUtility.susyId('diluted_epichlorohydrin'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Epichlorohydrin * 1, Salt * 1, Water * 1)
                .color(0x91664d)
                .build();

        Isobutane = new Material.Builder(15034, SuSyUtility.susyId('isobutane'))
                .gas()
                .components(Carbon * 4, Hydrogen * 10)
                .color(0x8a7566)
                .build();

        Isobutylene = new Material.Builder(15035, SuSyUtility.susyId('isobutylene'))
                .gas()
                .components(Carbon * 4, Hydrogen * 8)
                .color(0x917d61)
                .build();

        TriarylsulfoniumHexafluoroantimonate = new Material.Builder(15036, SuSyUtility.susyId('triarylsulfonium_hexafluoroantimonate'))
                .dust()
                .components(Carbon * 24, Hydrogen * 19, Fluorine * 6, Sulfur * 2, Antimony * 1)
                .color(0x31a374)
                .build();

        NMethylTwoPyrrolidone = new Material.Builder(15037, SuSyUtility.susyId('n_methyl_two_pyrrolidone'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 9, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build();

        //FREE ID: 15038

        MethylAcetateSolution = new Material.Builder(15039, SuSyUtility.susyId('methyl_acetate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid * 1, MethylAcetate * 1, Water * 1)
                .colorAverage()
                .build();

        TwoChloronitrobenzene = new Material.Builder(15040, SuSyUtility.susyId('two_chloronitrobenzene'))
                .dust().liquid(new FluidBuilder().temperature(306))
                .components(Carbon * 6, Hydrogen * 4, Chlorine * 1, Nitrogen * 1, Oxygen * 2)
                .color(0xc7c944)
                .build();

        MixedChloronitrobenzene = new Material.Builder(15041, SuSyUtility.susyId('mixed_chloronitrobenzene'))
                .dust().liquid(new FluidBuilder().temperature(330))
                .color(0xa4a644)
                .build();

        FourNitroanilineSolution = new Material.Builder(15042, SuSyUtility.susyId('four_nitroaniline_solution'))
                .liquid()
                .components(Toluene * 1, FourNitroaniline * 1)
                .colorAverage()
                .build();

        ParaPhenylenediamineSolution = new Material.Builder(15043, SuSyUtility.susyId('para_phenylenediamine_solution'))
                .liquid()
                .components(Toluene * 1, ParaPhenylenediamine * 1)
                .colorAverage()
                .build();

        //FREE ID: 15044

        DichlorobenzidineSolution = new Material.Builder(15045, SuSyUtility.susyId('dichlorobenzidine_solution'))
                .liquid()
                .components(Toluene * 1, Dichlorobenzidine * 1)
                .colorAverage()
                .build();

        Xylene = new Material.Builder(15046, SuSyUtility.susyId('xylene'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 10)
                .color(0x2e281f)
                .build();

        Phosgene = new Material.Builder(15047, SuSyUtility.susyId('phosgene'))
                .liquid()
                .components(Carbon * 1, Oxygen * 1, Chlorine * 2)
                .colorAverage()
                .build();

        OneTwoDichloroethane = new Material.Builder(15048, SuSyUtility.susyId('one_two_dichloroethane'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 4, Chlorine * 2)
                .colorAverage()
                .build();

        Propionaldehyde = new Material.Builder(15049, SuSyUtility.susyId('propionaldehyde'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 6, Oxygen * 1)
                .color(0x917b0f)
                .build();

        Cyclohexylamine = new Material.Builder(15050, SuSyUtility.susyId('cyclohexylamine'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 13, Nitrogen * 1)
                .color(0xbfba8c)
                .build();

        DiphenylIsophthalateSolution = new Material.Builder(15051, SuSyUtility.susyId('diphenyl_isophthalate_solution'))
                .liquid()
                .components(DiphenylIsophtalate * 1, OneTwoDichloroethane * 1)
                .colorAverage()
                .build();

        DiaminobenzidineSolution = new Material.Builder(15052, SuSyUtility.susyId('diaminobenzidine_solution'))
                .liquid()
                .components(Diaminobenzidine * 1, Toluene * 1)
                .colorAverage()
                .build();

        OneOneTwoTwoTetrachloroethane = new Material.Builder(15053, SuSyUtility.susyId('one_one_two_two_tetrachloroethane'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 2, Chlorine * 4)
                .colorAverage()
                .build();

        PBIFoam = new Material.Builder(15054, SuSyUtility.susyId('pbi_foam'))
                .dust()
                .color(0x332d28)
                .build();

        PBIPrepolymer = new Material.Builder(15055, SuSyUtility.susyId('pbi_prepolymer'))
                .dust()
                .color(0x292623)
                .build();

        Dimethylacetamide = new Material.Builder(15056, SuSyUtility.susyId('dimethylacetamide'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 9, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build();

        PBISolution = new Material.Builder(15057, SuSyUtility.susyId('pbi_solution'))
                .liquid()
                .components(Dimethylacetamide * 1, Polybenzimidazole * 1)
                .color(0x171410)
                .build();

        PBIWaste = new Material.Builder(15058, SuSyUtility.susyId('pbi_waste'))
                .liquid()
                .color(0x202226)
                .build();

        Hydroxylamine = new Material.Builder(15059, SuSyUtility.susyId('hydroxylamine'))
                .liquid(new FluidBuilder().temperature(306))
                .components(Hydrogen * 3, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build();

        Cyclohexanone = new Material.Builder(15060, SuSyUtility.susyId('cyclohexanone'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 10, Oxygen * 1)
                .color(0x2b1e11)
                .build();

        NHexadecylammoniumAcetate = new Material.Builder(15061, SuSyUtility.susyId('n_hexadecylammonium_acetate'))
                .dust()
                .components(Carbon * 16, Hydrogen * 39, Nitrogen * 1, Oxygen * 2)
                .color(0xffd4d4)
                .build();

        CaprolactamSolution = new Material.Builder(15062, SuSyUtility.susyId('caprolactam_solution'))
                .liquid()
                .components(AmmoniumSulfate * 1, Caprolactam * 1, Water * 2)
                .colorAverage()
                .build();

        Chlorotrimethylsilane = new Material.Builder(15063, SuSyUtility.susyId("chlorotrimethylsilane"))
                .liquid()
                .components(Carbon * 3, Hydrogen * 9, Silicon * 1, Chlorine * 1)
                .color(0xd9dddc)
                .build();

        Chlorotrimethylsilane.setFormula("(CH3)3SiCl", true)

        Methyldichlorosilane = new Material.Builder(15064, SuSyUtility.susyId("methyldichlorosilane"))
                .liquid()
                .components(Carbon * 1, Hydrogen * 4, Chlorine * 2, Silicon * 1)
                .color(0xd9dddc)
                .build();

        Methyldichlorosilane.setFormula("CH3Cl2SiH", true)

        Methyltrichlorosilane = new Material.Builder(15065, SuSyUtility.susyId("methyltrichlorosilane"))
                .liquid()
                .components(Carbon * 1, Hydrogen * 3, Silicon * 1, Chlorine * 3)
                .color(0xd9dddc)
                .build();

        Methyltrichlorosilane.setFormula("CH3SiCl3", true)

        CrackedOneTwoDichloroethaneMix = new Material.Builder(15066, SuSyUtility.susyId('cracked_one_two_dichloroethane_mix'))
                .liquid()
                .color(0x72afad)
                .build();

        VinylChlorideSuspension = new Material.Builder(15067, SuSyUtility.susyId('vinyl_chloride_suspension'))
                .liquid()
                .components(VinylChloride * 1, Water * 1)
                .colorAverage()
                .build();

        PolyvinylChlorideSuspension = new Material.Builder(15068, SuSyUtility.susyId('polyvinyl_chloride_suspension'))
                .liquid()
                .components(PolyvinylChloride * 1, Water * 1)
                .colorAverage()
                .build();

        StyreneSuspension = new Material.Builder(15069, SuSyUtility.susyId('styrene_suspension'))
                .liquid()
                .components(Styrene * 1, Water * 1)
                .colorAverage()
                .build();

        PolystyreneSuspension = new Material.Builder(15070, SuSyUtility.susyId('polystyrene_suspension'))
                .liquid()
                .components(Polystyrene * 1, Water * 1)
                .colorAverage()
                .build();

        VinylAcetateSuspension = new Material.Builder(15071, SuSyUtility.susyId('vinyl_acetate_suspension'))
                .liquid()
                .components(Methanol * 1, VinylAcetate * 1)
                .colorAverage()
                .build();

        PolyvinylAcetateSuspension = new Material.Builder(15072, SuSyUtility.susyId('polyvinyl_acetate_suspension'))
                .liquid()
                .components(Methanol * 1, PolyvinylAcetate * 1)
                .colorAverage()
                .build();

        Bleach = new Material.Builder(15073, SuSyUtility.susyId('bleach'))
                .liquid()
                .components(Sodium * 1, Chlorine * 1, Oxygen * 1, Water * 1)
                .colorAverage()
                .build();

        ImpureBleach = new Material.Builder(15074, SuSyUtility.susyId('impure_bleach'))
                .liquid()
                .components(Bleach * 1, Salt * 1, Water * 3)
                .colorAverage()
                .build();

        OneFourDichlorobenzeneSolution = new Material.Builder(15075, SuSyUtility.susyId('one_four_dichlorobenzene_solution'))
                .liquid()
                .components(Toluene * 1, Dichlorobenzene * 1)
                .colorAverage()
                .build();

        OneTwoDichlorobenzeneSolution = new Material.Builder(15076, SuSyUtility.susyId('one_two_dichlorobenzene_solution'))
                .liquid()
                .components(Toluene * 1, OneTwoDichlorobenzene * 1)
                .colorAverage()
                .build();

        StyreneButadieneSolution = new Material.Builder(15078, SuSyUtility.susyId('styrene_butadiene_solution'))
                .liquid()
                .components(Styrene * 1, Butadiene * 3, Ethanol * 1)
                .colorAverage()
                .build();

        OneBromobutane = new Material.Builder(15079, SuSyUtility.susyId('one_bromobutane'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 9, Bromine * 1)
                .colorAverage()
                .build();

        TwoFourFiveXylenolMixture = new Material.Builder(15080, SuSyUtility.susyId('two_four_five_xylenol_mixture'))
                .liquid(new FluidBuilder().temperature(400))
                .components(Carbon * 8, Hydrogen * 10, Oxygen * 1)
                .color(0x6e3632)
                .build();

        Butyllithium = new Material.Builder(15081, SuSyUtility.susyId('butyllithium'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 9, Lithium * 1)
                .colorAverage()
                .build();

        PolymerizedStyreneButadieneSolution = new Material.Builder(15083, SuSyUtility.susyId('polymerized_styrene_butadiene_solution'))
                .liquid()
                .color(0x332e2c)
                .build();

        TwoFourFiveXylenolMixture = new Material.Builder(15084, SuSyUtility.susyId('two_four_five_xylenol_mixture'))
                .liquid(new FluidBuilder().temperature(400))
                .components(Carbon * 8, Hydrogen * 10, Oxygen * 1)
                .color(0x6e3632)
                .build();
      
        TwoSixXylenol = new Material.Builder(15085, SuSyUtility.susyId('two_six_xylenol'))
                .liquid(new FluidBuilder().temperature(400))
                .components(Carbon * 8, Hydrogen * 10, Oxygen * 1)
                .color(0x572d2a)
                .build();

        Acetylene = new Material.Builder(15086, SuSyUtility.susyId('acetylene'))
                .gas()
                .components(Carbon * 2, Hydrogen * 2)
                .colorAverage()
                .build();

        TetrapropylammoniumBromide = new Material.Builder(15087, SuSyUtility.susyId('tetrapropylammonium_bromide'))
                .dust()
                .components(Carbon * 12, Hydrogen * 28, Bromine * 1, Nitrogen * 1)
                .color(0x916c0f)
                .build();

        Formaldehyde = new Material.Builder(15088, SuSyUtility.susyId('formaldehyde'))
                .gas()
                .components(Carbon * 1, Hydrogen * 2, Oxygen * 1)
                .colorAverage()
                .build();

        MethylamineMix = new Material.Builder(15089, SuSyUtility.susyId('methylamine_mix'))
                .liquid()
                .color(0x6b4ea6)
                .build();

        Methylamine = new Material.Builder(15090, SuSyUtility.susyId('methylamine'))
                .liquid()
                .components(Carbon * 1, Hydrogen * 5, Nitrogen * 1)
                .color(0x794c91)
                .build()
                .setFormula('CH3NH2', true);

        Trimethylamine = new Material.Builder(15091, SuSyUtility.susyId('trimethylamine'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 9, Nitrogen * 1)
                .color(0x4c2461)
                .build();

        Butynediol = new Material.Builder(15092, SuSyUtility.susyId('butynediol'))
                .liquid(new FluidBuilder().temperature(331))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 2)
                .colorAverage()
                .build();

        Butanediol = new Material.Builder(15093, SuSyUtility.susyId('butanediol'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 2)
                .colorAverage()
                .build();

        GammaButyrolactone = new Material.Builder(15094, SuSyUtility.susyId('gamma_butyrolactone'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 2)
                .color(0x4242f5)
                .build();
         
        OneOneDichloroethane = new Material.Builder(15095, SuSyUtility.susyId('one_one_dichloroethane'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 4, Chlorine * 2)
                .colorAverage()
                .build();

        DimethyldichlorosilaneEmulsion = new Material.Builder(15096, SuSyUtility.susyId('dimethyldichlorosilane_emulsion'))
                .liquid()
                .color(0x542a4c)
                .build();

        TetrafluoroethyleneEmulsion = new Material.Builder(15097, SuSyUtility.susyId('tetrafluoroethylene_emulsion'))
                .liquid()
                .color(0x3b2e38)
                .build();

        Dichloromethane = new Material.Builder(15098, SuSyUtility.susyId('dichloromethane'))
                .liquid()
                .components(Carbon * 1, Hydrogen * 2, Chlorine * 2)
                .colorAverage()
                .build();

        CarbonTetrachloride = new Material.Builder(15099, SuSyUtility.susyId('carbon_tetrachloride'))
                .liquid()
                .components(Carbon * 1, Chlorine * 4)
                .colorAverage()
                .build();

        IsophthalicAcid = new Material.Builder(15100, SuSyUtility.susyId('isophthalic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 6, Oxygen * 4)
                .color(0x8ac294)
                .build()

        NPropanol = new Material.Builder(15101, SuSyUtility.susyId('n_propanol'))
                .liquid()
                .components()
                .color(0xad9113)
                .build();

        NPropanol.setFormula('CH3CH2CH2OH', true)

        PolytetrafluoroethyleneSolution = new Material.Builder(15102, SuSyUtility.susyId('polytetrafluoroethylene_solution'))
                .liquid()
                .components(Polytetrafluoroethylene * 1, Water * 1)
                .colorAverage()
                .build();

        AcidicChloronitrobenzeneMixture = new Material.Builder(15103, SuSyUtility.susyId('acidic_chloronitrobenzene_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xc18c18)
                .build();

        MixedDichlorobenzeneSolution = new Material.Builder(15104, SuSyUtility.susyId('mixed_dichlorobenzene_solution'))
                .liquid()
                .color(0xFF7F7F)
                .build();

        Novolacs = new Material.Builder(15105, SuSyUtility.susyId('novolacs'))
                .liquid()
                .color(0xbfa26f)
                .build();

        Ethanolamine = new Material.Builder(15108, SuSyUtility.susyId('ethanolamine'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 7, Nitrogen * 1, Oxygen * 1)
                .color(0x56a6e3)
                .build();

        Diethanolamine = new Material.Builder(15109, SuSyUtility.susyId('diethanolamine'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 11, Nitrogen * 1, Oxygen * 2)
                .color(0x4296d6)
                .build();

        Triethanolamine = new Material.Builder(15110, SuSyUtility.susyId('triethanolamine'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 15, Nitrogen * 1, Oxygen * 3)
                .color(0x2e86c9)
                .build();

        EthyleneGlycol = new Material.Builder(15111, SuSyUtility.susyId('ethylene_glycol'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 6, Oxygen * 2)
                .color(0x2e86c9)
                .build();

        EthyleneOxide = new Material.Builder(15112, SuSyUtility.susyId('ethylene_oxide'))
                .gas()
                .components(Carbon * 2, Hydrogen * 4, Oxygen * 1)
                .colorAverage()
                .build();

        EthanolamineMix = new Material.Builder(15113, SuSyUtility.susyId('ethanolamine_mix'))
                .liquid()
                .color(0x3e86bd)
                .build();

        RichAmine = new Material.Builder(15114, SuSyUtility.susyId('rich_amine'))
                .liquid()
                .color(0x3ea8bd)
                .build();

        Pentane = new Material.Builder(15115, SuSyUtility.susyId('pentane'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 12)
                .color(0xe8e7be)
                .build();

        Hexane = new Material.Builder(15116, SuSyUtility.susyId('hexane'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14)
                .color(0xcfceb6)
                .build();

        Furfural = new Material.Builder(15117, SuSyUtility.susyId('furfural'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 4, Oxygen * 2)
                .colorAverage()
                .build();

        Cresol = new Material.Builder(15118, SuSyUtility.susyId('cresol'))
                .liquid()
                .components(Carbon * 7, Hydrogen * 8, Oxygen * 1)
                .color(0x827863)
                .build();

        Xylenol = new Material.Builder(15120, SuSyUtility.susyId('xylenol'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 10, Oxygen * 1)
                .color(0x693834)
                .build();

        Creosol = new Material.Builder(15121, SuSyUtility.susyId('creosol'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 10, Oxygen * 2)
                .color(0x473339)
                .build();

        Anthracene = new Material.Builder(15122, SuSyUtility.susyId('anthracene'))
                .dust()
                .components(Carbon * 14, Hydrogen * 10)
                .color(0x000000)
                .build();

        Triethylenediamine = new Material.Builder(15123, SuSyUtility.susyId('triethylenediamine'))
                .dust()
                .components(Carbon * 6, Hydrogen * 12, Nitrogen * 2)
                .colorAverage()
                .build()

        Polyurethane = new Material.Builder(15124, SuSyUtility.susyId('polyurethane'))
                .dust()
                .components(Carbon * 17, Hydrogen * 16, Nitrogen * 2, Oxygen * 4)
                .color(0xd1d1d1)
                .flags(NO_UNIFICATION, GENERATE_PLATE, FORCE_GENERATE_BLOCK)
                .build()
                .setFormula('(C15H10N2O2)(C2H6O2)', true);

        DiethylEther = new Material.Builder(15125, SuSyUtility.susyId('diethyl_ether'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 1)
                .color(0x2177ff)
                .build()

        DiethylEther.setFormula("(C2H5)2O", true)

        Polypropylene = new Material.Builder(15126, SuSyUtility.susyId('polypropylene'))
                .polymer(1)
                .liquid(new FluidBuilder().temperature(444))
                .components(Carbon * 3, Hydrogen * 6)
                .color(0xdfe39a)
                .flags(GENERATE_FOIL)
                .build();

        Dimethylformamide = new Material.Builder(15127, SuSyUtility.susyId('dimethylformamide'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 7, Nitrogen * 1)
                .colorAverage()
                .build()
                .setFormula('(CH3)2NCH', true);

        CativaCatalyst = new Material.Builder(15128, SuSyUtility.susyId('cativa_catalyst'))
                .dust()
                .color(0x695449)
                .build()
                .setFormula('[PPN][IrI2(CO)2]', true);

        TwoEthylanthraquinone = new Material.Builder(15129, SuSyUtility.susyId('two_ethylanthraquinone'))
                .liquid()
                .components(Carbon * 16, Hydrogen * 12, Oxygen * 2)
                .colorAverage()
                .build()

        TwoEthylanthrahydroquinone = new Material.Builder(15130, SuSyUtility.susyId('two_ethylanthrahydroquinone'))
                .liquid()
                .components(Carbon * 16, Hydrogen * 14, Oxygen * 2)
                .colorAverage()
                .build()

        Butanone = new Material.Builder(15131, SuSyUtility.susyId('butanone'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 8, Oxygen * 1)
                .colorAverage()
                .build()

        Durene = new Material.Builder(15132, SuSyUtility.susyId('durene'))
                .dust()
                .components(Carbon * 10, Hydrogen * 14)
                .colorAverage()
                .build()

        PyromelliticDianhydride = new Material.Builder(15133, SuSyUtility.susyId('pyromellitic_dianhydride'))
                .dust()
                .components(Carbon * 10, Hydrogen * 2, Oxygen * 6)
                .colorAverage()
                .build()

        FourFourOxydianiline = new Material.Builder(15134, SuSyUtility.susyId('four_four_oxydianiline'))
                .dust()
                .components(Carbon * 12, Hydrogen * 12, Nitrogen * 2, Oxygen * 1)
                .colorAverage()
                .build()

        KaptonK = new Material.Builder(15135, SuSyUtility.susyId('kapton_k'))
                .polymer(1)
                .components(Carbon * 22, Hydrogen * 10, Nitrogen * 2, Oxygen * 5)
                .color(0xfabe19)
                .build()

        KaptonE = new Material.Builder(15136, SuSyUtility.susyId('kapton_e'))
                .polymer(1)
                .components(Carbon * 22, Hydrogen * 10, Nitrogen * 2, Oxygen * 5)
                .color(0xdcfa19)
                .build()

        TwoButanol = new Material.Builder(15137, SuSyUtility.susyId('two_butanol'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 1)
                .colorAverage()
                .build()

        Acetamide = new Material.Builder(15138, SuSyUtility.susyId('acetamide'))
                .dust()
                .components(Carbon * 2, Hydrogen * 5, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build()

        Hydrazine = new Material.Builder(15139, SuSyUtility.susyId('hydrazine'))
                .liquid()
                .components(Nitrogen * 2, Hydrogen * 4)
                .colorAverage()
                .build()

        Ethylenediamine = new Material.Builder(15140, SuSyUtility.susyId('ethylenediamine'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 8, Nitrogen * 2)
                .colorAverage()
                .build()

        Pyrocatechol = new Material.Builder(15141, SuSyUtility.susyId('pyrocatechol'))
                .dust()
                .components(Carbon * 6, Hydrogen * 6, Oxygen * 2)
                .colorAverage()
                .build()

        AcetoneCyanohydrin = new Material.Builder(15142, SuSyUtility.susyId('acetone_cyanohydrin'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 7, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build()

        MethylMethacrylate = new Material.Builder(15143, SuSyUtility.susyId('methyl_methacrylate'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 8, Oxygen * 2)
                .colorAverage()
                .build()

        MethylMethacrylateEmulsion = new Material.Builder(15144, SuSyUtility.susyId('methyl_methacrylate_emulsion'))
                .liquid()
                .color(0x789c94)
                .build()

        PolymethylMethacrylateSolution = new Material.Builder(15145, SuSyUtility.susyId('polymethyl_methacrylate_solution'))
                .liquid()
                .color(0x79baad)
                .build()

        PolystyreneSulfonate = new Material.Builder(15146, SuSyUtility.susyId('polystyrene_sulfonate'))
                .polymer(1)
                .liquid()
                .color(0x8f795e)
                .build()
                .setFormula('(CH2CHC6H4SO3H)', true)

        EthylenediaminetetraaceticAcid = new Material.Builder(15147, SuSyUtility.susyId('ethylenediaminetetraacetic_acid'))
                .dust()
                .components(Carbon * 10, Hydrogen * 16, Nitrogen * 2, Oxygen * 8)
                .colorAverage()
                .build()
                .setFormula('(H4EDTA)', true)

        TetrasodiumEthylenediaminetetraacetate = new Material.Builder(15148, SuSyUtility.susyId('tetrasodium_ethylenediaminetetraacetate'))
                .dust()
                .components(Carbon * 10, Hydrogen * 12, Nitrogen * 2, Sodium * 4, Oxygen * 8)
                .colorAverage()
                .build()
        
        TetrasodiumEthylenediaminetetraacetate.setFormula('(Na4EDTA)', true)

        Urea = new Material.Builder(15149, SuSyUtility.susyId('urea'))
                .dust()
                .components(Carbon * 1, Oxygen * 1, Nitrogen * 2, Hydrogen * 4)
                .colorAverage()
                .build()

        Urea.setFormula('CO(NH2)2', true)

        Diiodobenzene = new Material.Builder(15150, SuSyUtility.susyId('diiodobenzene'))
                .dust()
                .components(Carbon * 6, Hydrogen * 4, Iodine * 2)
                .colorAverage()
                .build()

        TerephthalicAcid = new Material.Builder(15151, SuSyUtility.susyId('terephthalic_acid'))
                .dust().liquid(new FluidBuilder().temperature(473))
                .components(Carbon * 8, Hydrogen * 6, Oxygen * 4)
                .color(0xadf0ce)
                .build()

        Bistrichloromethylbenzene = new Material.Builder(15152, SuSyUtility.susyId('bistrichloromethylbenzene'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 4, Carbon * 2, Chlorine * 6)
                .colorAverage()
                .build()

        Bistrichloromethylbenzene.setFormula('C6H4(CCl3)2', true)

        TerephthaloylChloride = new Material.Builder(15153, SuSyUtility.susyId('terephthaloyl_chloride'))
                .dust()
                .components(Carbon * 8, Hydrogen * 4, Chlorine * 2, Oxygen * 2)
                .colorAverage()
                .build()

        Kevlar = new Material.Builder(15154, SuSyUtility.susyId('kevlar'))
                .color(0x4d443e)
                .components(Carbon * 14, Hydrogen * 10, Nitrogen * 2, Oxygen * 2)
                .flags(GENERATE_PLATE)
                .build()

        Kevlar.setFormula('[COC6H4CONHC6H4NH]n', true)
        Kevlar.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(true, false, true))

        BiphenylTetracarboxylicAcidDianhydride = new Material.Builder(15155, SuSyUtility.susyId('biphenyl_tetracarboxylic_acid_dianhydride'))
                .dust()
                .components(Carbon * 16, Hydrogen * 16, Oxygen * 6)
                .colorAverage()
                .build()

        CelluloseAcetate = new Material.Builder(15157, SuSyUtility.susyId('cellulose_acetate'))
                .components(Carbon * 76, Hydrogen * 114, Oxygen * 49)
                .color(0xd4c9ab)
                .build()

        CelluloseAcetate.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, false, false))

        Pyridine = new Material.Builder(15158, SuSyUtility.susyId('pyridine'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 5, Nitrogen * 1)
                .color(0x202836)
                .build()

        Quinoline = new Material.Builder(15159, SuSyUtility.susyId('quinoline'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 7, Nitrogen * 1)
                .color(0x2e3620)
                .build()

        DimethylCarbonate = new Material.Builder(15160, SuSyUtility.susyId('dimethyl_carbonate'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 6, Oxygen * 3)
                .colorAverage()
                .build()

        DiethyleneGlycol = new Material.Builder(15161, SuSyUtility.susyId('diethylene_glycol'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 3)
                .color(0x2ec9c1)
                .build()

        DiglycolicAcid = new Material.Builder(15162, SuSyUtility.susyId('diglycolic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 5)
                .colorAverage()
                .build()

        NOctanol = new Material.Builder(15163, SuSyUtility.susyId('n_octanol'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 18, Oxygen * 1)
                .color(0xbf8454)
                .build()

        NOctanol.setFormula('C8H17OH', true)

        NOctylamine = new Material.Builder(15164, SuSyUtility.susyId('n_octylamine'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 19, Nitrogen * 1)
                .color(0xeb8634)
                .build()

        Dioctylamine = new Material.Builder(15165, SuSyUtility.susyId('dioctylamine'))
                .liquid()
                .components(Carbon * 16, Hydrogen * 35, Nitrogen * 1)
                .colorAverage()
                .build()

        TetraoctylDiglycolamide = new Material.Builder(15166, SuSyUtility.susyId('tetraoctyl_diglycolamide'))
                .liquid()
                .components(Carbon * 36, Hydrogen * 72, Nitrogen * 2, Oxygen * 3)
                .colorAverage()
                .build()

        TwoEthylTwoHexenal = new Material.Builder(15167, SuSyUtility.susyId('two_ethyl_two_hexenal'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 14, Oxygen * 1)
                .colorAverage()
                .build()

        TwoEthylhexanol = new Material.Builder(15168, SuSyUtility.susyId('two_ethylhexanol'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 18, Oxygen * 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcid = new Material.Builder(15169, SuSyUtility.susyId('di_two_ethylhexyl_phosphoric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 16, Hydrogen * 35, Oxygen * 4, Phosphorus * 1)
                .color(0xb5a677)
                .build()

        DiTwoEthylhexylPhosphoricAcid.setFormula('(C8H17O)2PO(OH)2', true)

        LauricAcid = new Material.Builder(15170, SuSyUtility.susyId('lauric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 12, Hydrogen * 24, Oxygen * 2)
                .color(0xe39c32)
                .build()

        CapricAcid = new Material.Builder(15171, SuSyUtility.susyId('capric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 10, Hydrogen * 20, Oxygen * 2)
                .color(0xe3ba32)
                .build()

        PrimaryAmineN = new Material.Builder(15172, SuSyUtility.susyId('primary_amine_n'))
                .liquid()
                .components(Carbon * 20, Hydrogen * 43, Nitrogen * 1)
                .color(0x8533e8)
                .build()

        NineOctadecene = new Material.Builder(15173, SuSyUtility.susyId('nine_octadecanone'))
                .liquid()
                .components(Carbon * 18, Hydrogen * 36, Oxygen * 1)
                .colorAverage()
                .build()

        TriOctylDecylAmine = new Material.Builder(15174, SuSyUtility.susyId('tri_octyl_decyl_amine'))
                .liquid()
                .components(Carbon * 54, Hydrogen * 111, Nitrogen * 1)
                .color(0x6776c9)
                .build()

        Diethylbenzene = new Material.Builder(15175, SuSyUtility.susyId('diethylbenzene'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 14)
                .color(0xad9797)
                .build()

        Divinylbenzene = new Material.Builder(15176, SuSyUtility.susyId('divinylbenzene'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 10)
                .color(0xad9797)
                .build()

        NButanol = new Material.Builder(15177, SuSyUtility.susyId('n_butanol'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 1)
                .colorAverage()
                .build()

        DibutylCarbitol = new Material.Builder(15178, SuSyUtility.susyId('dibutyl_carbitol'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 26, Oxygen * 3)
                .color(0x89db6b)
                .build()

        DibutylCarbitol.setFormula('(CH3CH2CH2CH2OCH2CH2)2O', true)

        MonoTwoEthylhexylPhosphoricAcid = new Material.Builder(15179, SuSyUtility.susyId('mono_two_ethylhexyl_phosphoric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 16, Hydrogen * 34, Oxygen * 3, Phosphorus * 1)
                .color(0xb5a677)
                .build()

        MonoTwoEthylhexylPhosphoricAcid.setFormula('(C8H17O)2PO(OH)', true)

        MethylIsobutylKetone = new Material.Builder(15180, SuSyUtility.susyId('methyl_isobutyl_ketone'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 12, Oxygen * 1)
                .color(0x86dbb1)
                .build()

        MethylIsobutylCarbinol = new Material.Builder(15181, SuSyUtility.susyId('methyl_isobutyl_carbinol'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14, Oxygen * 1)
                .color(0x79c4c7)
                .build()

        NHexanol = new Material.Builder(15182, SuSyUtility.susyId('n_hexanol'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14, Oxygen * 1)
                .color(0xff9640)
                .build();

        NHexanol.setFormula('C6H13OH', true)

        NDecanol = new Material.Builder(15183, SuSyUtility.susyId('n_decanol'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 22, Oxygen * 1)
                .color(0xdb8035)
                .build();

        NDecanol.setFormula('C10H21OH', true)

        NDodecanol = new Material.Builder(15184, SuSyUtility.susyId('n_dodecanol'))
                .liquid(new FluidBuilder().temperature(293))
                .components(Carbon * 12, Hydrogen * 26, Oxygen * 1)
                .color(0xbd6e2d)
                .build();

        NDodecanol.setFormula('C12H25OH', true)

        NTetradecanol = new Material.Builder(15185, SuSyUtility.susyId('n_tetradecanol'))
                .liquid(new FluidBuilder().temperature(311))
                .components(Carbon * 14, Hydrogen * 30, Oxygen * 1)
                .color(0x2177ff)
                .build();

        NTetradecanol.setFormula('C14H29OH', true)

        NHexadecanol = new Material.Builder(15186, SuSyUtility.susyId('n_hexadecanol'))
                .liquid(new FluidBuilder().temperature(323))
                .components(Carbon * 16, Hydrogen * 34, Oxygen * 1)
                .color(0x824b1e)
                .build();

        NHexadecanol.setFormula('C16H33OH', true)

        OleicAcid = new Material.Builder(15187, SuSyUtility.susyId('oleic_acid'))
                .dust().liquid()
                .components(Carbon * 18, Hydrogen * 34, Oxygen * 2)
                .color(0xb1d1ae)
                .build()

        LinoleicAcid = new Material.Builder(15188, SuSyUtility.susyId('linoleic_acid'))
                .dust().liquid()
                .components(Carbon * 18, Hydrogen * 32, Oxygen * 2)
                .color(0xbfd1a3)
                .build()

        PalmiticAcid = new Material.Builder(15189, SuSyUtility.susyId('palmitic_acid'))
                .dust().liquid()
                .components(Carbon * 16, Hydrogen * 32, Oxygen * 2)
                .color(0xd4d392)
                .build()

        Capsaicin = new Material.Builder(15190, SuSyUtility.susyId('capsaicin'))
                .dust()
                .components(Carbon * 18, Hydrogen * 27, Nitrogen * 1, Oxygen * 3)
                .color(0xff1900)
                .build();

        Diisopropylamine = new Material.Builder(15191, SuSyUtility.susyId('diisopropylamine'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 15, Nitrogen * 1)
                .colorAverage()
                .build();

        Diisopropylaminoethanol = new Material.Builder(15192, SuSyUtility.susyId('diisopropylaminoethanol'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 19, Nitrogen * 1, Oxygen * 1)
                .colorAverage()
                .build();

        IsopropylAlcohol = new Material.Builder(15193, SuSyUtility.susyId('isopropyl_alcohol'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 8, Oxygen * 1)
                .colorAverage()
                .build();

        IsopropylAlcohol.setFormula('(CH3)2CHOH', true)

        Triethylamine = new Material.Builder(15194, SuSyUtility.susyId('triethylamine'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 15, Nitrogen * 1)
                .color(0xe07d26)
                .build();

        Diethylamine = new Material.Builder(15195, SuSyUtility.susyId('diethylamine'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 11, Nitrogen * 1)
                .color(0xf59542)
                .build();

        Ethylamine = new Material.Builder(15196, SuSyUtility.susyId('ethylamine'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 7, Nitrogen * 1)
                .color(0xf5a55f)
                .build();

        Diethylacetamide = new Material.Builder(15197, SuSyUtility.susyId('diethylacetamide'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 13, Oxygen * 1, Nitrogen * 1)
                .colorAverage()
                .build();

        Diethylacetimidamine = new Material.Builder(15198, SuSyUtility.susyId('diethylacetimidamine'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14, Nitrogen * 2)
                .colorAverage()
                .build();

        Novichok = new Material.Builder(15199, SuSyUtility.susyId('novichok'))
                .liquid()
                .components(Carbon * 7, Hydrogen * 16, Fluorine * 1, Nitrogen * 2, Oxygen * 1, Phosphorus * 1)
                .colorAverage()
                .build();

        IsoamylAlcohol = new Material.Builder(15200, SuSyUtility.susyId('isoamyl_alcohol'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 12, Oxygen * 1)
                .color(0x23ad13)
                .build();

        IsoamylAlcohol.setFormula('(CH3)2CHCH2CH2OH', true)

        IsobutylAlcohol = new Material.Builder(15201, SuSyUtility.susyId('isobutyl_alcohol'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 1)
                .color(0xa0ad13)
                .build();

        IsobutylAlcohol.setFormula('(CH3)2CHCH2OH', true)

        CaprylicAcid = new Material.Builder(15202, SuSyUtility.susyId('caprylic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 8, Hydrogen * 16, Oxygen * 2)
                .color(0x748545)
                .build();

        OctanoylChloride = new Material.Builder(15203, SuSyUtility.susyId('octanoyl_chloride'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 15, Chlorine * 1, Oxygen * 1)
                .color(0x458548)
                .build();

        PerfluorooctanoylFluoride = new Material.Builder(15204, SuSyUtility.susyId('perfluorooctanoyl_fluoride'))
                .liquid()
                .components(Carbon * 8, Fluorine * 16, Oxygen * 1)
                .color(0x288a7b)
                .build();

        PerfluorooctanoicAcid = new Material.Builder(15205, SuSyUtility.susyId('perfluorooctanoic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 1, Fluorine * 15, Oxygen * 2)
                .color(0x24bfa8)
                .build();

        OneButene = new Material.Builder(15206, SuSyUtility.susyId('one_butene'))
                .gas()
                .components(Carbon * 4, Hydrogen * 8)
                .color(0xed9595)
                .build();

        TwoButene = new Material.Builder(15207, SuSyUtility.susyId('two_butene'))
                .gas()
                .components(Carbon * 4, Hydrogen * 8)
                .color(0xab6009)
                .build();

        NPentanol = new Material.Builder(15208, SuSyUtility.susyId('n_pentanol'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 12, Oxygen * 1)
                .color(0xb37834)
                .build();

        SodiumEthoxideSolution = new Material.Builder(15209, SuSyUtility.susyId('sodium_ethoxide_solution'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 5, Oxygen * 1, Sodium * 1, Ethanol * 1)
                .color(0xcc5050)
                .build();

        SodiumEthoxideSolution.setFormula('(CH3CH2ONa)(H2O)', true)

        SodiumEthylXanthate = new Material.Builder(15210, SuSyUtility.susyId('sodium_ethyl_xanthate'))
                .dust()
                .components(Carbon * 3, Hydrogen * 5, Oxygen * 1, Sulfur * 2, Sodium * 1)
                .color(0xfdffbf)
                .build();

        SodiumEthylXanthate.setFormula('CH3CH2OCS2Na', true)

        PotassiumAmylXanthate = new Material.Builder(15211, SuSyUtility.susyId('potassium_amyl_xanthate'))
                .dust()
                .components(Carbon * 6, Hydrogen * 11, Oxygen * 1, Sulfur * 2, Potassium * 1)
                .color(0xe0d582)
                .build();

        PotassiumAmylXanthate.setFormula('C5H11OCS2K', true)

        Isobutyraldehyde = new Material.Builder(15212, SuSyUtility.susyId('isobutyraldehyde'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 8, Oxygen * 1)
                .color(0x9ccf69)
                .build();

        SodiumIsobutylXanthate = new Material.Builder(15213, SuSyUtility.susyId('sodium_isobutyl_xanthate'))
                .dust()
                .components(Carbon * 5, Hydrogen * 9, Oxygen * 1, Sulfur * 2, Sodium * 1)
                .color(0xb1bf60)
                .build();

        SodiumIsobutylXanthate.setFormula('(CH3)2CHCH2OCS2Na', true)

        PotassiumIsopropylXanthate = new Material.Builder(15214, SuSyUtility.susyId('potassium_isopropyl_xanthate'))
                .dust()
                .components(Carbon * 4, Hydrogen * 7, Oxygen * 1, Sulfur * 2, Potassium * 1)
                .color(0xcbdb6b)
                .build();

        PotassiumIsopropylXanthate.setFormula('(CH3)2CHOCS2K', true)

        PotassiumEthylXanthate = new Material.Builder(15215, SuSyUtility.susyId('potassium_ethyl_xanthate'))
                .dust()
                .components(Carbon * 3, Hydrogen * 5, Oxygen * 1, Sulfur * 2, Potassium * 1)
                .color(0xfdffc8)
                .build();

        PotassiumEthylXanthate.setFormula('CH3CH2OCS2K', true)

        Valeraldehyde = new Material.Builder(15216, SuSyUtility.susyId('valeraldehyde'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 10, Oxygen * 1)
                .color(0xb3af34)
                .build();

        NHexadecylamine = new Material.Builder(15217, SuSyUtility.susyId('n_hexadecylamine'))
                .dust()
                .components(Carbon * 16, Hydrogen * 35, Nitrogen * 1)
                .color(0xcff5ff)
                .build();

        TertButylAlcohol = new Material.Builder(15218, SuSyUtility.susyId('tert_butyl_alcohol'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 1)
                .colorAverage()
                .build();

        TertButylAlcohol.setFormula('(CH3)3COH', true)

        ButylatedHydroxytoluene = new Material.Builder(15219, SuSyUtility.susyId('butylated_hydroxytoluene'))
                .liquid()
                .components(Carbon * 15, Hydrogen * 25, Oxygen * 1)
                .colorAverage()
                .build();

        ButylatedHydroxytoluene.setFormula('((CH3)3C)2CH3C6H2OH', true)

        DimethylTertButylphenol = new Material.Builder(15220, SuSyUtility.susyId('dimethyl_tert_butylphenol'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 18, Oxygen * 1)
                .colorAverage()
                .build();

        DimethylTertButylphenol.setFormula('(CH3)2(CH3)3C7H2OH', true)

        AluminiumPhenolate = new Material.Builder(15221, SuSyUtility.susyId('aluminium_phenolate'))
                .dust()
                .components(Carbon * 18, Hydrogen * 15, Aluminium * 1, Oxygen * 3)
                .colorAverage()
                .build();

        AluminiumPhenolate.setFormula('Al(OC6H5)3', true)

        DiTertButylphenol = new Material.Builder(15222, SuSyUtility.susyId('di_tert_butylphenol'))
                .liquid()
                .components(Carbon * 14, Hydrogen * 22, Oxygen * 1)
                .colorAverage()
                .build();

        DiTertButylphenol.setFormula('((CH3)3C)2C6H3OH', true)

        IsoOctane = new Material.Builder(15223, SuSyUtility.susyId('isooctane'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 18)
                .colorAverage()
                .build();

        IsoOctane.setFormula('(CH3)3CCH2CH(CH3)2', true)

        PurifiedIsoprene = new Material.Builder(15224, SuSyUtility.susyId('purified_isoprene'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 8)
                .color(0x000000)
                .build();

        Cyclopentadiene = new Material.Builder(15225, SuSyUtility.susyId('cyclopentadiene'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 6)
                .color(0x403c32)
                .build();

        HexamethylenetetramineSolution = new Material.Builder(15226, SuSyUtility.susyId('hexamethylenetetramine_solution'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 12, Nitrogen * 4, Water * 4)
                .colorAverage()
                .build()
                .setFormula("(C6H12N4)(H2O)4", true)

        Ferrocene = new Material.Builder(15227, SuSyUtility.susyId('ferrocene'))
                .dust()
                .components(Carbon * 10, Hydrogen * 10, Iron * 1)
                .color(0x403c32)
                .build();

        Ferrocene.setFormula('Fe(C5H5)2', true)

        Polyisoprene = new Material.Builder(15228, SuSyUtility.susyId('polyisoprene'))
                .dust()
                .iconSet(SHINY)
                .components(Carbon * 5, Hydrogen * 8)
                .color(0x1f1f1f)
                .build();

        Chloroethane = new Material.Builder(15229, SuSyUtility.susyId('chloroethane'))
                .gas()
                .components(Carbon * 2, Hydrogen * 5, Chlorine * 1)
                .colorAverage()
                .build();

        ExtractedCaprolactamSolution = new Material.Builder(15230, SuSyUtility.susyId('extracted_caprolactam_solution'))
                .liquid()
                .components(Caprolactam * 1, Toluene * 1)
                .colorAverage()
                .build();
        
        Trimethylaluminium = new Material.Builder(15231, SuSyUtility.susyId('trimethylaluminium'))
                .liquid()
                .components(Aluminium * 1, Carbon * 3, Hydrogen * 9)
                .color(0x7abfb4)
                .build();

        Trimethylaluminium.setFormula('Al(CH3)3', true)

        Methylaluminoxane = new Material.Builder(15232, SuSyUtility.susyId('methylaluminoxane'))
                .dust()
                .components(Aluminium * 1, Carbon * 1, Hydrogen * 3, Oxygen * 1)
                .color(0x33a391)
                .build();

        ZirconoceneDichloride = new Material.Builder(15233, SuSyUtility.susyId('zirconocene_dichloride'))
                .dust()
                .components(Zirconium * 1, Carbon * 10, Hydrogen * 10, Chlorine * 2)
                .color(0x3ea0a3)
                .build();

        ZirconoceneDichloride.setFormula('Zr(C5H5)2Cl2', true)

        Tetrahydrofuran = new Material.Builder(15234, SuSyUtility.susyId('tetrahydrofuran'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 8, Oxygen * 1)
                .color(0xd13485)
                .build();

        AcidicRichAmine = new Material.Builder(15235, SuSyUtility.susyId('acidic_rich_amine'))
                .liquid()
                .color(0x6ca0ab)
                .build();
      
        OctylHydroxamicAcid = new Material.Builder(15236, SuSyUtility.susyId('octyl_hydroxamic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 17, Oxygen * 2, Nitrogen * 1)
                .color(0xd47f31)
                .build();

        PotassiumOctylHydroxamate = new Material.Builder(15237, SuSyUtility.susyId('potassium_octyl_hydroxamate'))
                .dust()
                .components(Carbon * 8, Hydrogen * 16, Oxygen * 2, Nitrogen * 1, Potassium * 1)
                .color(0xd47f50)
                .build();

        PotassiumButylXanthate = new Material.Builder(15238, SuSyUtility.susyId('potassium_butyl_xanthate'))
                .dust()
                .components(Carbon * 5, Hydrogen * 9, Oxygen * 1, Sulfur * 2, Potassium * 1)
                .color(0xd1c675)
                .build();

        PotassiumButylXanthate.setFormula('C4H9OCS2K', true)

        PicricAcid = new Material.Builder(15239, SuSyUtility.susyId('picric_acid')) 
                .dust()
                .components(Carbon * 6, Hydrogen * 3, Nitrogen * 3, Oxygen * 7)
                .color(0xc2ba1f)
                .build();

        Monomethylhydrazine = new Material.Builder(15240, SuSyUtility.susyId('monomethylhydrazine'))
                .liquid()
                .components(Carbon * 1, Hydrogen * 6, Nitrogen * 2)
                .color(0x558ca6)
                .build();

        OrthoXylene = new Material.Builder(15241, SuSyUtility.susyId('ortho_xylene'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 10)
                .color(0x3d3427)
                .build();

        MetaXylene = new Material.Builder(15242, SuSyUtility.susyId('meta_xylene'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 10)
                .color(0x40392f)
                .build();

        ParaXylene = new Material.Builder(15243, SuSyUtility.susyId('para_xylene'))
                .dust().liquid()
                .flags(NO_UNIFICATION)
                .components(Carbon * 8, Hydrogen * 10)
                .color(0x1a1611)
                .build();

        MetaParaXyleneMixture = new Material.Builder(15244, SuSyUtility.susyId('meta_para_xylene_mixture'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 10)
                .color(0x2b2319)
                .build();

        Tripropylamine = new Material.Builder(15245, SuSyUtility.susyId('tripropylamine'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 21, Nitrogen * 1)
                .color(0x90b846)
                .build();

        NBromopropane = new Material.Builder(15246, SuSyUtility.susyId('n_bromopropane'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 7, Bromine * 1)
                .color(0x9e833f)
                .build();
      		
      	Triethylenetetramine = new Material.Builder(15247, SuSyUtility.susyId('triethylenetetramine'))
      		.liquid()
      		.components(Carbon * 6, Hydrogen * 18, Nitrogen * 4)
      		.color(0x3d98ab)
      		.build();
      		
      	Aminoethylpiperazine = new Material.Builder(15248, SuSyUtility.susyId('aminoethylpiperazine'))
      		.liquid()
      	      	.components(Carbon * 6, Hydrogen * 15, Nitrogen * 3)
      		.color(0xcce862)
      		.build();	
    
        Diethylenetriamine = new Material.Builder(15249, SuSyUtility.susyId('diethylenetriamine'))
      		.liquid()
              	.components(Carbon * 4, Hydrogen * 13, Nitrogen * 3)
      		.color(0x0234a8)
      		.build();
    
        Ethylenediamine = new Material.Builder(15250, SuSyUtility.susyId('ethylenediamine'))
      		.liquid()
              	.components(Carbon * 2, Hydrogen * 8, Nitrogen * 2)
      		.color(0x2e7a25)
      		.build();
      		
      	Piperazine = new Material.Builder(15251, SuSyUtility.susyId('piperazine'))
      		.liquid(new FluidBuilder().temperature(379))
      	      	.components(Carbon * 4, Hydrogen * 10, Nitrogen * 2)
      		.color(0x8a8f9f)
      		.build();
      		
      	Cyclooctadiene = new Material.Builder(15253, SuSyUtility.susyId('cyclooctadiene'))
      		.liquid()
      		.components(Carbon * 8, Hydrogen * 12)
      		.color(0x4639ee)
      		.build();
      		
      	TriethylPhosphate = new Material.Builder(15254, SuSyUtility.susyId('triethyl_phosphate'))
      		.liquid()
      		.components(Carbon * 6, Hydrogen * 15, Oxygen * 4, Phosphorus * 1)
      		.color(0x4639ee)
      		.build();
      		
        IsopropenylAcetate = new Material.Builder(15255, SuSyUtility.susyId('isopropenyl_acetate'))
      		.liquid()
      		.components(Carbon * 5, Hydrogen * 8, Oxygen * 2)
      		.color(0x4639ee)
      		.build();
      		
      	Acetylacetone = new Material.Builder(15256, SuSyUtility.susyId('acetylacetone'))
      		.liquid()
      		.components(Carbon * 5, Hydrogen * 8, Oxygen * 2)
      		.color(0x092b30)
      		.build();
      		
        NickelIIBisacetylacetonate = new Material.Builder(15257, SuSyUtility.susyId('nickel_ii_bisacetylacetonate'))
      		.dust()
      		.components(Carbon * 10, Hydrogen * 14, Nickel * 1, Oxygen * 4)
      		.color(0x3e5051)
      		.build();
      	
        NickelIIBisacetylacetonate.setFormula('Ni(acac)2', true)

        BiscyclooctadienenickelZero = new Material.Builder(15258, SuSyUtility.susyId('biscyclooctadienenickel_zero'))
        	.dust()
        	.components(Carbon * 16, Hydrogen * 24, Nickel * 1)
        	.color(0xe0e00d)
        	.build();

        BiscyclooctadienenickelZero.setFormula('Ni(cod)2', true)
        	
        DiethylaluminiumAcetylacetonate = new Material.Builder(15259, SuSyUtility.susyId('diethylaluminium_acetylacetonate'))
                .liquid()
        	.components(Aluminium * 1, Carbon * 9, Hydrogen * 17, Oxygen * 2)
                .color(0x10a37e)
                .build();

        DiethylaluminiumAcetylacetonate.setFormula('(acac)AlEt2', true)

        OxalicAcid = new Material.Builder(15260, SuSyUtility.susyId('oxalic_acid'))
                .dust()
                .components(Hydrogen * 2, Carbon * 2, Oxygen * 4)
                .color(0xb5a7aa)
                .build();

        OneAmidoethylTwoAlkylTwoImidazoline = new Material.Builder(15261, SuSyUtility.susyId('one_amidoethyl_two_alkyl_two_imidazoline'))
                .liquid()
                .color(0x9c3398)
                .build();

        Chlorodiphenylphosphine = new Material.Builder(15262, SuSyUtility.susyId('chlorodiphenylphosphine'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 10, Chlorine * 1, Phosphorus * 1)
                .color(0xd2e080)
                .build();

        DiphenylphosphinoaceticAcid = new Material.Builder(15263, SuSyUtility.susyId('diphenylphosphinoacetic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 14, Hydrogen * 13, Oxygen * 2, Phosphorus * 1)
                .color(0xdeba6d)
                .build();

        OneHexene = new Material.Builder(15264, SuSyUtility.susyId('one_hexene'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 12)
                .color(0xd96c6c)
                .build();

        Tripropylene = new Material.Builder(15265, SuSyUtility.susyId('tripropylene'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 18)
                .color(0xcf5f1f)
                .build();

        Isodecanal = new Material.Builder(15266, SuSyUtility.susyId('isodecanal'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 20, Oxygen * 1)
                .color(0xde8431)
                .build();

        Isodecanol = new Material.Builder(15267, SuSyUtility.susyId('isodecanol'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 22, Oxygen * 1)
                .color(0xeb9546)
                .build();

        Trioctylamine = new Material.Builder(15268, SuSyUtility.susyId('trioctylamine'))
                .liquid()
                .components(Carbon * 24, Hydrogen * 51, Nitrogen * 1)
                .color(0x2274a3)
                .build();

        NButylamine = new Material.Builder(15269, SuSyUtility.susyId('n_butylamine'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 11, Nitrogen * 1)
                .color(0x43576e)
                .build();

        Ethyltoluene = new Material.Builder(15270, SuSyUtility.susyId('ethyltoluene'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 12)
                .color(0x806706)
                .build();

        VinylbenzylChloride = new Material.Builder(15271, SuSyUtility.susyId('vinylbenzyl_chloride'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 9, Chlorine * 1)
                .color(0x8fa32a)
                .build();

        TetrabromobisphenolA = new Material.Builder(15272, SuSyUtility.susyId('tetrabromobisphenol_a'))
                .dust()
                .components(Carbon * 15, Hydrogen * 12, Bromine * 4, Oxygen * 2)
                .color(0x6b3220)
                .build();

        Cyanamide = new Material.Builder(15273, SuSyUtility.susyId('cyanamide'))
                .dust()
                .components(Carbon * 1, Hydrogen * 2, Nitrogen * 2)
                .colorAverage()
                .build();

        Dicyandiamide = new Material.Builder(15274, SuSyUtility.susyId('dicyandiamide'))
                .dust()
                .components(Carbon * 2, Hydrogen * 4, Nitrogen * 4)
                .colorAverage()
                .iconSet(QUARTZ)
                .build();

        TwoMethylimidazole = new Material.Builder(15275, SuSyUtility.susyId('two_methylimidazole'))
                .dust()
                .components(Carbon * 4, Hydrogen * 6, Nitrogen * 2)
                .colorAverage()
                .build();

        FlameRetardantEpoxy = new Material.Builder(15276, SuSyUtility.susyId('flame_retardant_epoxy'))
                .dust().liquid()
                .components(Carbon * 21, Hydrogen * 21, Bromine * 4, Chlorine * 1, Oxygen * 5)
                .color(0xc86b14)
                .build();

        PropyleneChlorohydrin = new Material.Builder(15277, SuSyUtility.susyId('propylene_chlorohydrin'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 7, Chlorine * 1, Oxygen * 1)
                .colorAverage()
                .build();

        PropyleneOxide = new Material.Builder(15278, SuSyUtility.susyId('propylene_oxide'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 6, Oxygen * 1)
                .color(0x9ab522)
                .build();

        PropyleneCarbonate = new Material.Builder(15279, SuSyUtility.susyId('propylene_carbonate'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 3)
                .color(0x5db522)
                .build();

        DiphenylSulfide = new Material.Builder(15280, SuSyUtility.susyId('diphenyl_sulfide'))
                .dust()
                .components(Carbon * 12, Hydrogen * 10, Sulfur * 1)
                .color(0x5e5c0a)
                .build();

        DiphenylSulfoxide = new Material.Builder(15281, SuSyUtility.susyId('diphenyl_sulfoxide'))
                .dust()
                .components(Carbon * 12, Hydrogen * 10, Oxygen * 1, Sulfur * 1)
                .color(0x435e0a)
                .build();

        MethanesulfonicAcid = new Material.Builder(15282, SuSyUtility.susyId('methanesulfonic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 1, Hydrogen * 4, Oxygen * 3, Sulfur * 1)
                .color(0xff6e6e)
                .build();

        TriphenylphosphineOxide = new Material.Builder(15283, SuSyUtility.susyId('triphenylphosphine_oxide'))
                .dust()
                .components(Carbon * 18, Hydrogen * 15, Oxygen * 1, Phosphorus * 1)
                .colorAverage()
                .build();

        TosylicAcidSolution = new Material.Builder(15284, SuSyUtility.susyId("tosylic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 7, Hydrogen * 8, Oxygen * 3, Sulfur * 1, Water * 1)
                .colorAverage()
                .build();

        TosylicAcidSolution.setFormula("(TsOH)(H2O)", true)

        Triphenylphosphine = new Material.Builder(15285, SuSyUtility.susyId('triphenylphosphine'))
                .dust()
                .components(Carbon * 18, Hydrogen * 15, Phosphorus * 1)
                .colorAverage()
                .build();

        TriphenylphosphineDichloride = new Material.Builder(15286, SuSyUtility.susyId('triphenylphosphine_dichloride'))
                .dust()
                .components(Carbon * 18, Hydrogen * 15, Chlorine * 2, Phosphorus * 1)
                .colorAverage()
                .build();

        BistriphenylphosphineiminiumChloride = new Material.Builder(15287, SuSyUtility.susyId('bistriphenylphosphineiminium_chloride'))
                .dust()
                .components(Carbon * 36, Hydrogen * 30, Chlorine * 1, Nitrogen * 1, Phosphorus * 2)
                .colorAverage()
                .build();

        DimethylTerephthalate = new Material.Builder(15288, SuSyUtility.susyId('dimethyl_terephthalate'))
                .dust().liquid(new FluidBuilder().temperature(533))
                .components(Carbon * 10, Hydrogen * 10, Oxygen * 4)
                .color(0x56c48c)
                .build();

        PolyethyleneTerephthalate = new Material.Builder(15289, SuSyUtility.susyId('polyethylene_terephthalate'))
                .polymer().liquid(new FluidBuilder().temperature(533))
                .flags(GENERATE_FOIL)
                .components(Carbon * 10, Hydrogen * 6, Oxygen * 4)
                .color(0x7e9e8e)
                .build();

        PolyethyleneTerephthalate.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, false))

        AmocoTerephthalicAcid = new Material.Builder(15290, SuSyUtility.susyId('amoco_terephthalic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 6, Oxygen * 4)
                .color(0x66916c)
                .build();

        AmocoIsophthalicAcid = new Material.Builder(15291, SuSyUtility.susyId('amoco_isophthalic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 6, Oxygen * 4)
                .color(0x6b9166)
                .build();

        ParaToluicAcid = new Material.Builder(15292, SuSyUtility.susyId('para_toluic_acid'))
                .dust().liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(454))
                .flags(NO_UNIFICATION)
                .components(Carbon * 8, Hydrogen * 8, Oxygen * 2)
                .color(0x83943a)
                .build();

        MethylParaToluate = new Material.Builder(15293, SuSyUtility.susyId('methyl_para_toluate'))
                .liquid(new FluidBuilder().temperature(323))
                .components(Carbon * 9, Hydrogen * 10, Oxygen * 2)
                .color(0x4e8538)
                .build();

        CrudeDimethylTerephthalate = new Material.Builder(15294, SuSyUtility.susyId('crude_dimethyl_terephthalate'))
                .dust()
                .components(Carbon * 10, Hydrogen * 10, Oxygen * 4)
                .color(0x388568)
                .build();

        WetTerephthalicAcid = new Material.Builder(15295, SuSyUtility.susyId('wet_terephthalic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 6, Oxygen * 4)
                .color(0x669181)
                .iconSet(DULL)
                .build();

        WetIsophthalicAcid = new Material.Builder(15296, SuSyUtility.susyId('wet_isophthalic_acid'))
                .dust()
                .components(Carbon * 8, Hydrogen * 6, Oxygen * 4)
                .color(0x609169)
                .iconSet(DULL)
                .build();

        HydrogenDodecylSulfate = new Material.Builder(15297, SuSyUtility.susyId('hydrogen_dodecyl_sulfate'))
                .dust()
                .components(Carbon * 12, Hydrogen * 26, Sulfur * 1, Oxygen * 4)
                .iconSet(SAND)
                .color(0xd8dbb8)
                .build();
                
        SodiumDodecylSulfate = new Material.Builder(15298, SuSyUtility.susyId('sodium_dodecyl_sulfate'))
                .dust()
                .components(Carbon * 12, Hydrogen * 25, Sulfur * 1, Oxygen * 4, Sodium * 1)
                .iconSet(SAND)
                .color(0xe6e4cf)
                .build();

        Dinonylnaphthalene = new Material.Builder(15299, SuSyUtility.susyId('dinonylnaphthalene'))
                .dust()
                .components(Carbon * 28, Hydrogen * 44)
                .iconSet(SAND)
                .color(0xbfa263)
                .build();

        DinonylnaphthaleneSulfonicAcid = new Material.Builder(15300, SuSyUtility.susyId('dinonylnaphthalene_sulfonic_acid'))
                .dust()
                .components(Carbon * 28, Hydrogen * 44, Sulfur * 1, Oxygen * 3)
                .iconSet(SAND)
                .color(0xbfb463)
                .build();

        Pseudocumene = new Material.Builder(15301, SuSyUtility.susyId('pseudocumene'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 12)
                .color(0x553300)
                .build();

        Methylcyclopentadiene = new Material.Builder(15302, SuSyUtility.susyId('methylcyclopentadiene'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 8)
                .color(0x57ab82)
                .build();

        Methylcyclopentadiene.setFormula('C5H4CH3', true)

        Diglyme = new Material.Builder(15303, SuSyUtility.susyId('diglyme'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14, Oxygen * 3)
                .color(0x2f9982)
                .build();

        Bismethylcyclopentadienylmanganese = new Material.Builder(15304, SuSyUtility.susyId('bismethylcyclopentadienylmanganese'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 10, Manganese * 1)
                .color(0x75250d)
                .build();
        
        Bismethylcyclopentadienylmanganese.setFormula('Mn(C5H4CH3)2', true)

        MethylcyclopentadienylmanganeseTricarbonyl = new Material.Builder(15305, SuSyUtility.susyId('methylcyclopentadienylmanganese_tricarbonyl'))
                .liquid()
                .components(Carbon * 9, Hydrogen * 7, Oxygen * 3, Manganese * 1)
                .color(0xa16c0b)
                .build()

        MethylcyclopentadienylmanganeseTricarbonyl.setFormula('(C5H4CH3)Mn(CO)3', true)

        MethylCarbitol = new Material.Builder(15306, SuSyUtility.susyId('methyl_carbitol'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 12, Oxygen * 3)
                .color(0x3fd1b1)
                .build();

        DiisopropylParaPhenylenediamine = new Material.Builder(15307, SuSyUtility.susyId('diisopropyl_para_phenylenediamine'))
                .dust()
                .components(Carbon * 12, Hydrogen * 22, Nitrogen * 2)
                .color(0x1d666e)
                .build();

        OneTwoDiaminopropaneSolution = new Material.Builder(15308, SuSyUtility.susyId('one_two_diaminopropane_solution'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 10, Nitrogen * 2, Water * 1)
                .color(0x22b55d)
                .build();

        Salicylaldehyde = new Material.Builder(15309, SuSyUtility.susyId('salicylaldehyde'))
                .liquid()
                .components(Carbon * 7, Hydrogen * 6, Oxygen * 2)
                .color(0x3f44a6)
                .build();

        SalicylideneOneTwoPropanediamine = new Material.Builder(15310, SuSyUtility.susyId('salicylidene_one_two_propanediamine'))
                .dust()
                .components(Carbon * 17, Hydrogen * 18, Nitrogen * 2, Oxygen * 2)
                .color(0x571f80)
                .build();

        EthyleneVinylAcetate = new Material.Builder(15311, SuSyUtility.susyId('ethylene_vinyl_acetate'))
                .polymer()
                .components(Ethylene * 1, VinylAcetate * 1)
                .color(0x686ad4)
                .fluidPipeProperties(363, 100, true)
                .iconSet(DULL)
                .build();
        
        EthyleneIsobutyleneVinylAcetate = new Material.Builder(15312, SuSyUtility.susyId('ethylene_isobutylene_vinyl_acetate'))
                .dust()
                .components(Ethylene * 1, Isobutylene * 1, VinylAcetate * 1)
                .color(0x8768d4)
                .iconSet(DULL)
                .build();

        Dihexadecylamine = new Material.Builder(15313, SuSyUtility.susyId('dihexadecylamine'))
                .liquid(new FluidBuilder().temperature(340))
                .components(Carbon * 32, Hydrogen * 67, Nitrogen * 1)
                .color(0x5f6e0e)
                .build();

        DihexadecylaminePhthalateAmide = new Material.Builder(15314, SuSyUtility.susyId('dihexadecylamine_phthalate_amide'))
                .dust()
                .components(Carbon * 72, Hydrogen * 138, Nitrogen * 2, Oxygen * 3)
                .color(0x3e6e0e)
                .build();

        MethylTertButylEther = new Material.Builder(15315, SuSyUtility.susyId('methyl_tert_butyl_ether'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 12, Oxygen * 1)
                .color(0xae21b0)
                .build();

        TetraethylOrthosilicate = new Material.Builder(15316, SuSyUtility.susyId('tetraethyl_orthosilicate'))
                .liquid()
                .components(Silicon * 1, Carbon * 8, Hydrogen * 20, Oxygen * 4)
                .color(0x96a894)
                .build();

        TetraethylOrthosilicate.setFormula("Si(C2H5)4", true)

        Methylphenyldichlorosilane = new Material.Builder(15317, SuSyUtility.susyId('methylphenyldichlorosilane'))
                .liquid()
                .components(Silicon * 1, Carbon * 7, Hydrogen * 8, Chlorine * 2)
                .color(0x9ba178)
                .build();

        Methylphenyldichlorosilane.setFormula("C6H5Si(CH3)Cl2", true)

        OneOctene = new Material.Builder(15318, SuSyUtility.susyId('one_octene'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 16)
                .color(0xd68b9d)
                .build();

        OneDecene = new Material.Builder(15319, SuSyUtility.susyId('one_decene'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 20)
                .color(0xbf7184)
                .build();

        OneDodecene = new Material.Builder(15320, SuSyUtility.susyId('one_dodecene'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 24)
                .color(0xb0566c)
                .build();

        OneTetradecene = new Material.Builder(15321, SuSyUtility.susyId('one_tetradecene'))
                .liquid()
                .components(Carbon * 14, Hydrogen * 28)
                .color(0xb54a64)
                .build();

        OneHexadecene = new Material.Builder(15322, SuSyUtility.susyId('one_hexadecene'))
                .liquid()
                .components(Carbon * 16, Hydrogen * 32)
                .color(0xcc4969)
                .build();

        OneOctadecene = new Material.Builder(15323, SuSyUtility.susyId('one_octadecene'))
                .liquid()
                .components(Carbon * 18, Hydrogen * 36)
                .color(0xd94368)
                .build();

        OneIcosene = new Material.Builder(15324, SuSyUtility.susyId('one_icosene'))
                .liquid(new FluidBuilder().temperature(308))
                .components(Carbon * 20, Hydrogen * 40)
                .color(0xe63560)
                .build();

        OneDocosene = new Material.Builder(15325, SuSyUtility.susyId('one_docosene'))
                .liquid(new FluidBuilder().temperature(310))
                .components(Carbon * 22, Hydrogen * 44)
                .color(0xcf2750)
                .build();

        OneTetracosene = new Material.Builder(15326, SuSyUtility.susyId('one_tetracosene'))
                .liquid(new FluidBuilder().temperature(318))
                .components(Carbon * 24, Hydrogen * 48)
                .color(0xb51b41)
                .build();

        Polybutene = new Material.Builder(15327, SuSyUtility.susyId('polybutene'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 8)
                .color(0xb5471b)
                .build();

        Polybutene.setFormula('[C4H8]n', true)

        TrimelliticAcid = new Material.Builder(15328, SuSyUtility.susyId('trimellitic_acid'))
                .dust()
                .components(Carbon * 9, Hydrogen * 6, Oxygen * 6)
                .color(0xcb6fde)
                .build();

        TrimelliticAnhydride = new Material.Builder(15329, SuSyUtility.susyId('trimellitic_anhydride'))
                .dust()
                .components(Carbon * 9, Hydrogen * 4, Oxygen * 5)
                .color(0xac59bd)
                .build();

        Oleylamide = new Material.Builder(15330, SuSyUtility.susyId('oleylamide'))
                .liquid()
                .components(Carbon * 18, Hydrogen * 35, Nitrogen * 1, Oxygen * 1)
                .color(0x59bbbd)
                .build();

        StearicAcid = new Material.Builder(15331, SuSyUtility.susyId('stearic_acid'))
                .liquid(new FluidBuilder().temperature(342))
                .components(Carbon * 18, Hydrogen * 36, Oxygen * 2)
                .color(0xd3d4ae)
                .build();

        TriethyleneGlycol = new Material.Builder(15332, SuSyUtility.susyId('triethylene_glycol'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14, Oxygen * 4)
                .color(0x27a8a2)
                .build()

        OneNitronaphthalene = new Material.Builder(15333, SuSyUtility.susyId('one_nitronaphthalene'))
                .dust()
                .components(Carbon * 10, Hydrogen * 7, Nitrogen * 1, Oxygen * 2)
                .color(0x82bd8a)
                .build();

        OneNaphthylamine = new Material.Builder(15334, SuSyUtility.susyId('one_naphthylamine'))
                .dust().liquid(new FluidBuilder().temperature(322))
                .components(Carbon * 10, Hydrogen * 9, Nitrogen * 1)
                .color(0x82bd9c)
                .build();

        NPhenylOneNaphthylamine = new Material.Builder(15335, SuSyUtility.susyId('n_phenyl_one_naphthylamine'))
                .dust()
                .components(Carbon * 16, Hydrogen * 13, Nitrogen * 1)
                .color(0x62a37f)
                .build();

        Polyisobutene = new Material.Builder(15336, SuSyUtility.susyId('polyisobutene'))
                .dust()
                .components(Carbon * 4, Hydrogen * 8)
                .color(0x944234)
                .build();

        Polyisobutene.setFormula('[C4H8]n', true)

        EthylenePropyleneCopolymer = new Material.Builder(15337, SuSyUtility.susyId('ethylene_propylene_copolymer'))
                .dust()
                .components(Carbon * 5, Hydrogen * 10)
                .color(0xbab18a)
                .build();

        EthylenePropyleneCopolymer.setFormula('[(C2H4)(C3H6)]n', true)

        MethacrylicAcid = new Material.Builder(15338, SuSyUtility.susyId('methacrylic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 2)
                .color(0x5590ad)
                .build();

        StyreneIsopreneSolution = new Material.Builder(15339, SuSyUtility.susyId('styrene_isoprene_solution'))
                .liquid()
                .components(Isoprene * 3, Styrene * 1, Ethanol * 1)
                .color(0x520734)
                .build();

        RawStyreneIsopreneRubber = new Material.Builder(15340, SuSyUtility.susyId('raw_styrene_isoprene_rubber'))
                .dust()
                .components(Isoprene * 3, Styrene * 1)
                .color(0x3d0727)
                .build();

        StyreneIsopreneRubber = new Material.Builder(15341, SuSyUtility.susyId('styrene_isoprene_rubber'))
                .polymer()
                .iconSet(SHINY)
                .flags(GENERATE_FOIL, GENERATE_RING)
                .components(Isoprene * 3, Styrene * 1)
                .color(0x57103a)
                .build();

        HydrogenatedStyreneIsopreneRubber = new Material.Builder(15342, SuSyUtility.susyId('hydrogenated_styrene_isoprene_rubber'))
                .dust()
                .components(Carbon * 23, Hydrogen * 38)
                .color(0x70186c)
                .build();

        HydrogenatedStyreneIsopreneRubber.setFormula('(C5H10)3C8H8', true)

        HydrogenatedStyreneButadieneRubber = new Material.Builder(15343, SuSyUtility.susyId('hydrogenated_styrene_butadiene_rubber'))
                .dust()
                .components(Carbon * 20, Hydrogen * 32)
                .color(0x701818)
                .build();

        HydrogenatedStyreneButadieneRubber.setFormula('(C4H8)3C8H8', true)        

        Dodecylphenol = new Material.Builder(15344, SuSyUtility.susyId('dodecylphenol'))
                .dust()
                .components(Carbon * 18, Hydrogen * 30, Oxygen * 1)
                .color(0x4c3c63)
                .build();

        CalciumPhenate = new Material.Builder(15345, SuSyUtility.susyId('calcium_phenate'))
                .liquid()
                .components(Calcite * 1, Carbon * 18, Hydrogen * 29, Oxygen * 1, Sulfur * 1)
                .color(0x4a3f0a)
                .build();

        CalciumPhenate.setFormula("[C18H29SOCa(CO2)(CaOH)]n", true)

        Dodecylbenzene = new Material.Builder(15347, SuSyUtility.susyId('dodecylbenzene'))
                .dust()
                .components(Carbon * 18, Hydrogen * 30)
                .color(0x604882)
                .build();

        DodecylbenzenesulfonicAcid = new Material.Builder(15348, SuSyUtility.susyId('dodecylbenzenesulfonic_acid'))
                .dust()
                .components(Carbon * 18, Hydrogen * 30, Sulfur * 1, Oxygen * 3)
                .color(0x7c4882)
                .build();

        CalciumDodecylbenzeneSulfonate = new Material.Builder(15349, SuSyUtility.susyId('calcium_dodecylbenzene_sulfonate'))
                .dust()
                .components(Calcium * 1, Carbon * 36, Hydrogen * 60, Sulfur * 2, Oxygen * 6)
                .color(0x944a7c)
                .build();

        CalciumDodecylbenzeneSulfonate.setFormula("Ca(C18H30SO3)2", true)

        CalciumSalicylate = new Material.Builder(15350, SuSyUtility.susyId('calcium_salicylate'))
                .dust()
                .components(Calcium * 1, Carbon * 14, Hydrogen * 10, Oxygen * 6)
                .color(0x64bd90)
                .build();

        CalciumSalicylate.setFormula("Ca(C7H5O3)2", true)

        MaleicAnhydride = new Material.Builder(15351, SuSyUtility.susyId('maleic_anhydride'))
                .dust()
                .components(Carbon * 4, Hydrogen * 2, Oxygen * 3)
                .color(0xdb42ba)
                .build();

        CalciumDinonylnaphthaleneSulfonate = new Material.Builder(15352, SuSyUtility.susyId('calcium_dinonylnaphthalene_sulfonate'))
                .dust()
                .components(Calcium * 1, Carbon * 56, Hydrogen * 86, Sulfur * 2, Oxygen * 6)
                .color(0x42a3db)
                .build();

        CalciumDinonylnaphthaleneSulfonate.setFormula("Ca(C28H43SO3)", true)

        MetaParaCresolMixture = new Material.Builder(15353, SuSyUtility.susyId('meta_para_cresol_mixture'))
                .liquid()
                .components(Carbon * 7, Hydrogen * 8, Oxygen * 1)
                .color(0x73674e)
                .build();

        OrthoCresol = new Material.Builder(15354, SuSyUtility.susyId('ortho_cresol'))
                .liquid()
                .components(Carbon * 7, Hydrogen * 8, Oxygen * 1)
                .color(0xb5a991)
                .build();

        TricresylPhosphate = new Material.Builder(15355, SuSyUtility.susyId('tricresyl_phosphate'))
                .liquid()
                .components(Carbon * 21, Hydrogen * 21, Oxygen * 4, Phosphorus * 1)
                .color(0x9c924b)
                .build();

        DiisopropyldithiophosphoricAcid = new Material.Builder(15356, SuSyUtility.susyId('diisopropyldithiophosphoric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 6, Hydrogen * 15, Oxygen * 2, Phosphorus * 1, Sulfur * 2)
                .color(0x857714)
                .build();

        DiisopropyldithiophosphoricAcid.setFormula("(C3H7O)2PS2H", true)

        DibutyldithiophosphoricAcid = new Material.Builder(15357, SuSyUtility.susyId('dibutyldithiophosphoric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 8, Hydrogen * 19, Oxygen * 2, Phosphorus * 1, Sulfur * 2)
                .color(0x856914)
                .build();

        DibutyldithiophosphoricAcid.setFormula("(C4H9O)2PS2H", true)

        TwoButoxyethanol = new Material.Builder(15358, SuSyUtility.susyId('two_butoxyethanol'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 14, Oxygen * 2)
                .color(0xa0c9db)
                .build();

        //FREE ID: 15359

        Diamylamine = new Material.Builder(15360, SuSyUtility.susyId('diamylamine'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 23, Nitrogen * 1)
                .color(0x2b7842)
                .build();

        SodiumDiamylthiocarbamateSolution = new Material.Builder(15361, SuSyUtility.susyId('sodium_diamyldithiocarbamate_solution'))
                .liquid()
                .components(Carbon * 11, Hydrogen * 22, Nitrogen * 1, Sulfur * 2, Sodium * 1, Water * 1)
                .color(0x2b7865)
                .build();

        SodiumDiamylthiocarbamateSolution.setFormula("(C11H22NS2Na)(H2O)", true)

        ZincBisdiamyldithiocarbamate = new Material.Builder(15362, SuSyUtility.susyId('zinc_bisdiamyldithiocarbamate'))
                .dust()
                .components(Zinc * 1, Carbon * 22, Hydrogen * 44, Nitrogen * 2, Sulfur * 4)
                .color(0x69782b)
                .build();

        ZincBisdiamyldithiocarbamate.setFormula("Zn(C11H22NS2)2", true)

        Didodecylbenzene = new Material.Builder(15363, SuSyUtility.susyId('didodecylbenzene'))
                .dust()
                .components(Carbon * 30, Hydrogen * 54)
                .color(0x327894)
                .build();

        DidodecylbenzenesulfonicAcid = new Material.Builder(15364, SuSyUtility.susyId('didodecylbenzenesulfonic_acid'))
                .dust()
                .components(Carbon * 30, Hydrogen * 54, Sulfur * 1, Oxygen * 3)
                .color(0x32947c)
                .build();

        CalciumDidodecylbenzeneSulfonate = new Material.Builder(15365, SuSyUtility.susyId('calcium_didodecylbenzene_sulfonate'))
                .dust()
                .components(Calcium * 1, Carbon * 60, Hydrogen * 106, Sulfur * 2, Oxygen * 6)
                .color(0x325994)
                .build();

        CalciumDidodecylbenzeneSulfonate.setFormula("Ca(C30H53SO3)2", true)

        Nonylphenol = new Material.Builder(15366, SuSyUtility.susyId('nonylphenol'))
                .liquid()
                .components(Carbon * 15, Hydrogen * 24, Oxygen * 1)
                .color(0x4070b8)
                .build();

        Trichloroethylene = new Material.Builder(15367, SuSyUtility.susyId('trichloroethylene'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 1, Chlorine * 3)
                .color(0x55a663)
                .build();

        ChloroaceticAcid = new Material.Builder(15368, SuSyUtility.susyId('chloroacetic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 2, Hydrogen * 3, Chlorine * 1, Oxygen * 2)
                .color(0x58a33b)
                .build();

        FourNonylphenoxyaceticAcid = new Material.Builder(15369, SuSyUtility.susyId('four_nonylphenoxyacetic_acid'))
                .dust()
                .components(Carbon * 17, Hydrogen * 26, Oxygen * 3)
                .color(0x953ba3)
                .build();

        TwoNitroanilineSolution = new Material.Builder(15370, SuSyUtility.susyId('two_nitroaniline_solution'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 6, Nitrogen * 2, Oxygen * 2)
                .color(0x7653bd)
                .build();

        OrthoPhenylenediamine = new Material.Builder(15371, SuSyUtility.susyId('ortho_phenylenediamine'))
                .dust()
                .components(Carbon * 6, Hydrogen * 8, Nitrogen * 2)
                .color(0x252a80)
                .build();

        Benzotriazole = new Material.Builder(15372, SuSyUtility.susyId('benzotriazole'))
                .dust()
                .components(Carbon * 6, Hydrogen * 5, Nitrogen * 3)
                .color(0x4971ad)
                .build();

        Mercaptobenzothiazole = new Material.Builder(15373, SuSyUtility.susyId('mercaptobenzothiazole'))
                .dust()
                .components(Carbon * 7, Hydrogen * 5, Nitrogen * 1, Sulfur * 2)
                .color(0x878000)
                .build();

        SalicylideneEthylenediamine = new Material.Builder(15374, SuSyUtility.susyId('salicylidene_ethylenediamine'))
                .dust()
                .components(Carbon * 16, Hydrogen * 16, Nitrogen * 2, Oxygen * 2)
                .color(0x5c84c4)
                .build();

        PolyethyleneGlycol = new Material.Builder(15375, SuSyUtility.susyId('polyethylene_glycol'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 4, Oxygen * 1)
                .color(0x599c8e)
                .build();

        OneThreeDinitrobenzene = new Material.Builder(15377, SuSyUtility.susyId('one_three_dinitrobenzene'))
                .dust()
                .components(Carbon * 6, Hydrogen * 4, Nitrogen * 2, Oxygen * 4)
                .color(0x1c718a)
                .build();

        OneThreeDinitrobenzene.setFormula("C6H4(NO2)2", true)

        MetaPhenylenediamine = new Material.Builder(15378, SuSyUtility.susyId('meta_phenylenediamine'))
                .dust()
                .components(Carbon * 6, Hydrogen * 8, Nitrogen * 2)
                .color(0x1e89a8)
                .build();

        MetaPhenylenediamine.setFormula("C6H4(NH2)2", true)

        Nomex = new Material.Builder(15379, SuSyUtility.susyId('nomex'))
                .components(Carbon * 14, Hydrogen * 10, Nitrogen * 2, Oxygen * 2)
                .color(0x5d95a3)
                .build();

        Nomex.setFormula('[COC6H4CONHC6H4NH]n', true)
        Nomex.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(true, false, true))

        UltraHighMolecularWeightPolyethylene = new Material.Builder(15380, SuSyUtility.susyId('ultra_high_molecular_weight_polyethylene'))
                .dust().liquid(new FluidBuilder().temperature(425))
                .flags(GENERATE_PLATE)
                .components(Carbon * 2, Hydrogen * 4)
                .color(0xc5e3de)
                .iconSet(SHINY)
                .build();

        UltraHighMolecularWeightPolyethylene.setFormula('[C2H4]n', true)
        UltraHighMolecularWeightPolyethylene.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, true))

        AdipicAcid = new Material.Builder(15381, SuSyUtility.susyId('adipic_acid'))
                .dust()
                .components(Carbon * 6, Hydrogen * 10, Oxygen * 4)
                .color(0xe3ddb6)
                .build();
                
        Trimethylolpropane = new Material.Builder(15382, SuSyUtility.susyId('trimethylolpropane'))
                .dust()
                .components(Carbon * 6, Hydrogen * 14, Oxygen * 3)
                .color(0x5d8230)
                .build();

        AcrylicAcid = new Material.Builder(15383, SuSyUtility.susyId('acrylic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 3, Hydrogen * 4, Oxygen * 2)
                .color(0x308264)
                .build();

        TrimethylolpropaneTriacrylate = new Material.Builder(15384, SuSyUtility.susyId('trimethylolpropane_triacrylate'))
                .liquid()
                .components(Carbon * 15, Hydrogen * 20, Oxygen * 6)
                .color(0x279630)
                .build();

        BenzenediazoniumChloride = new Material.Builder(15385, SuSyUtility.susyId('benzenediazonium_chloride'))
                .dust()
                .components(Carbon * 6, Hydrogen * 5, Nitrogen * 2, Chlorine * 1)
                .color(0x18262b)
                .build();

        Crotonaldehyde = new Material.Builder(15386, SuSyUtility.susyId('crotonaldehyde'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 1)
                .color(0xa31a5c)
                .build();

        CalciumAcetate = new Material.Builder(15387, SuSyUtility.susyId('calcium_acetate'))
                .dust()
                .components(Calcium * 1, Carbon * 4, Hydrogen * 6, Oxygen * 4)
                .color(0xe3dcc8)
                .iconSet(QUARTZ)
                .build();

        CalciumAcetate.setFormula("Ca(CH3CO2)2", true)

        GaseousMethacroleinMixture = new Material.Builder(15388, SuSyUtility.susyId('gaseous_methacrolein_mixture'))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 1, Steam * 1)
                .colorAverage()
                .build();

        GaseousMethacroleinMixture.setFormula("(C4H6O)(H2O)", true)

        GaseousMethacroleinResidue = new Material.Builder(15389, SuSyUtility.susyId('gaseous_methacrolein_residue'))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 1, Steam * 4)
                .colorAverage()
                .build();

        GaseousMethacroleinResidue.setFormula("(C4H6O)(H2O)4", true)

        AbsorbedMethacrolein = new Material.Builder(15390, SuSyUtility.susyId('absorbed_methacrolein'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 1, AceticAcid * 4, Water * 5)
                .colorAverage()
                .build();

        AbsorbedMethacrolein.setFormula("(C4H6O)(CH3COOH)4(H2O)5", true)

        Tetraethyllead = new Material.Builder(15391, SuSyUtility.susyId('tetraethyllead'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 20, Lead * 1)
                .colorAverage()
                .build();

        Tetraethyllead.setFormula("Pb(CH3CH2)4", true)

        TertButylHydroperoxide = new Material.Builder(15392, SuSyUtility.susyId('tert_butyl_hydroperoxide'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Oxygen * 2)
                .colorAverage()
                .build();

        TertButylHydroperoxide.setFormula("(CH3)3COOH", true)

        DiTertButylPeroxide = new Material.Builder(15393, SuSyUtility.susyId('di_tert_butyl_peroxide'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 18, Oxygen * 2)
                .colorAverage()
                .build();

        DiTertButylPeroxide.setFormula("(CH3)3COOC(CH3)3", true)

        TwoEthylhexylNitrate = new Material.Builder(15394, SuSyUtility.susyId('two_ethylhexyl_nitrate'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 17, Nitrogen * 1, Oxygen * 3)
                .colorAverage()
                .build();

        Nitromethane = new Material.Builder(15395, SuSyUtility.susyId('nitromethane'))
                .liquid()
                .components(Carbon * 1, Hydrogen * 3, Nitrogen * 1, Oxygen * 2)
                .colorAverage()
                .build();

        SodiumBisphenolateSolution = new Material.Builder(15396, SuSyUtility.susyId('sodium_bisphenolate_solution'))
                .liquid()
                .components(SodiumHydroxide * 2, BisphenolA * 1, Water * 2)
                .colorAverage()
                .build();

        Polycarbonate = new Material.Builder(15397, SuSyUtility.susyId('polycarbonate'))
                .polymer()
                .flags(GENERATE_PLATE)
                .components(Carbon * 16, Hydrogen * 14, Oxygen * 3)
                .color(0xa1cacf)
                .iconSet(SHINY)
                .build();

        Polycarbonate.setFormula("C16H14O3", true)

        Trichlorofluoromethane = new Material.Builder(15398, SuSyUtility.susyId('trichlorofluoromethane'))
                .gas()
                .components(Carbon * 1, Chlorine * 3, Fluorine * 1)
                .color(0xeb6a6a)
                .build();

        Dichlorodifluoromethane = new Material.Builder(15399, SuSyUtility.susyId('dichlorodifluoromethane'))
                .gas()
                .components(Carbon * 1, Chlorine * 2, Fluorine * 2)
                .color(0xd14d4d)
                .build();

        Chlorotrifluoromethane = new Material.Builder(15400, SuSyUtility.susyId('chlorotrifluoromethane'))
                .gas()
                .components(Carbon * 1, Chlorine * 1, Fluorine * 3)
                .color(0xbf3232)
                .build();

        Chlorodifluoromethane = new Material.Builder(15401, SuSyUtility.susyId('chlorodifluoromethane'))
                .gas()
                .components(Carbon * 1, Hydrogen * 1, Chlorine * 1, Fluorine * 2)
                .color(0x8c5a99)
                .build();

        Acrolein = new Material.Builder(15402, SuSyUtility.susyId('acrolein'))
                .liquid()
                .components(Carbon * 3, Hydrogen * 4, Oxygen * 1)
                .color(0x389c7a)
                .build();

        Dicyclopentadiene = new Material.Builder(15403, SuSyUtility.susyId('dicyclopentadiene'))
                .liquid(new FluidBuilder().temperature(306))
                .components(Carbon * 10, Hydrogen * 12)
                .color(0x9c388b)
                .build();

        SodiumMethoxide = new Material.Builder(15404, SuSyUtility.susyId('sodium_methoxide'))
                .dust()
                .components(Carbon * 1, Hydrogen * 3, Oxygen * 1, Sodium * 1)
                .color(0xd19c21)
                .build();

        NeutralizedMethylFormateSolution = new Material.Builder(15405, SuSyUtility.susyId('neutralized_methyl_formate_solution'))
                .liquid()
                .color(0x6b3f58)
                .build();

        HydrolyzedMethylFormateSolution = new Material.Builder(15406, SuSyUtility.susyId('hydrolyzed_methyl_formate_solution'))
                .liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
                .color(0x91436e)
                .build();

        EthylAcetate = new Material.Builder(15407, SuSyUtility.susyId('ethyl_acetate'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 8, Oxygen * 2)
                .color(0xa5c773)
                .build();

        FormicAcid = new Material.Builder(15408, SuSyUtility.susyId('formic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Carbon * 1, Hydrogen * 2, Oxygen * 2)
                .color(0xbf395b)
                .build();

        MethylFormateSolution = new Material.Builder(15409, SuSyUtility.susyId('methyl_formate_solution'))
                .liquid()
                .color(0x915161)
                .build();

        PolyvinylAlcohol = new Material.Builder(15410, SuSyUtility.susyId('polyvinyl_alcohol'))
                .dust()
                .components(Carbon * 2, Hydrogen * 4, Oxygen * 1)
                .color(0xd4984e)
                .build();

        CompoundedPolyisoprene = new Material.Builder(15411, SuSyUtility.susyId('compounded_polyisoprene'))
                .dust()
                .components(Isoprene)
                .color(0x121212)
                .build();

        CompoundedStyreneIsopreneRubber = new Material.Builder(15412, SuSyUtility.susyId('compounded_styrene_isoprene_rubber'))
                .dust()
                .components(Isoprene * 3, Styrene * 1)
                .color(0x260418)
                .build();

        CompoundedStyreneButadieneRubber = new Material.Builder(15413, SuSyUtility.susyId('compounded_styrene_butadiene_rubber'))
                .dust()
                .components(Butadiene * 3, Styrene * 1)
                .color(0x3b2d2b)
                .build();
    }
}
