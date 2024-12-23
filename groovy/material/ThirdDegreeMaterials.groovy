package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class ThirdDegreeMaterials {
    public static void register() {

        log.infoMC('Registering Third Degree Materials!');

        DiethylEtherSolution = new Material.Builder(24000, SuSyUtility.susyId('diethyl_ether_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(material('diethyl_ether'), SulfuricAcid * 1, Water * 1)
                .colorAverage()
                .build();

        LithiumSolution = new Material.Builder(24001, SuSyUtility.susyId('lithium_solution'))
                .liquid()
                .components(Lithium * 2, material('diethyl_ether'))
                .colorAverage()
                .build();

        DimethylacetamideSolution = new Material.Builder(24002, SuSyUtility.susyId('dimethylacetamide_solution'))
                .liquid()
                .components(Dimethylacetamide * 1, Water * 1)
                .colorAverage()
                .build();

        AcidicFurfuralSolution = new Material.Builder(24003, SuSyUtility.susyId('acidic_furfural_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Furfural * 1, SulfuricAcid * 1, Water * 3)
                .colorAverage()
                .build();

        WackerCatalystSolution = new Material.Builder(24004, SuSyUtility.susyId('wacker_catalyst_solution'))
                .liquid()
                .components(WackerCatalyst * 1, Water * 1)
                .colorAverage()
                .build();

        TwoEthylanthraquinoneSolution = new Material.Builder(24005, SuSyUtility.susyId('two_ethylanthraquinone_solution'))
                .liquid()
                .components(TwoEthylanthraquinone * 1, HydrogenPeroxide * 3)
                .colorAverage()
                .build();

        AcetamideSolution = new Material.Builder(24006, SuSyUtility.susyId('acetamide_solution'))
                .liquid()
                .components(Butanone * 1, Acetamide * 1)
                .colorAverage()
                .build();

        HydrazineSolution = new Material.Builder(24007, SuSyUtility.susyId('hydrazine_solution'))
                .liquid()
                .components(Hydrazine * 1, Ammonia * 2, Water * 4)
                .colorAverage()
                .build();

        LithiumHexafluorophosphateElectrolyte = new Material.Builder(24008, SuSyUtility.susyId("lithium_hexafluorophosphate_electrolyte"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(LithiumHexafluorophosphate * 1, EthyleneCarbonate * 1)
                .colorAverage()
                .build();

        TNTSlurry = new Material.Builder(24009, SuSyUtility.susyId('tnt_slurry'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TNT * 1, DilutedSulfuricAcid * 1)
                .colorAverage()
                .build();

        DilutedDiTertButylPeroxide = new Material.Builder(24010, SuSyUtility.susyId('diluted_di_tert_butyl_peroxide'))
                .liquid()
                .components(DiTertButylPeroxide * 1, Water * 1)
                .colorAverage()
                .build();

        TetrasodiumEthylenediaminetetraacetateSolution = new Material.Builder(24011, SuSyUtility.susyId('tetrasodium_ethylenediaminetetraacetate_solution'))
                .liquid()
                .components(TetrasodiumEthylenediaminetetraacetate * 1, Water * 4)
                .colorAverage()
                .build();

        UreaSolution = new Material.Builder(24012, SuSyUtility.susyId('urea_solution'))
                .liquid()
                .components(Urea * 1, Water * 1)
                .colorAverage()
                .build()

        DiiodobenzeneSolution = new Material.Builder(24013, SuSyUtility.susyId('diiodobenzene_solution'))
                .liquid()
                .components(Ethanol * 1, Diiodobenzene * 1)
                .colorAverage()
                .build()

        ImpureFourFourOxydianiline = new Material.Builder(24014, SuSyUtility.susyId('impure_four_four_oxydianiline'))
                .liquid()
                .components(Ethanol * 2, Water * 5, FourFourOxydianiline * 1, AmmoniumIodide * 4)
                .colorAverage()
                .build()

        EthyleneGlycolSolution = new Material.Builder(24015, SuSyUtility.susyId('ethylene_glycol_solution'))
                .liquid()
                .components(EthyleneGlycol * 1, Water * 2, SodiumHydroxide * 3)
                .colorAverage()
                .build()

        TerephthalicAcidSlurry = new Material.Builder(24016, SuSyUtility.susyId('terephthalic_acid_slurry'))
                .liquid()
                .components(AceticAcid * 1, Water * 1, TerephthalicAcid * 1)
                .colorAverage()
                .build()

        CelluloseAcetateSolution = new Material.Builder(24017, SuSyUtility.susyId('cellulose_acetate_solution'))
                .liquid()
                .components(Acetone * 1, CelluloseAcetate * 1)
                .colorAverage()
                .build()

        TwoButanolSolution = new Material.Builder(24018, SuSyUtility.susyId('two_butanol_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid * 1, TwoButanol * 1)
                .colorAverage()
                .build()

        FourFourOxydianilineSlurry = new Material.Builder(24019, SuSyUtility.susyId('four_four_oxydianiline_slurry'))
                .liquid()
                .components(FourFourOxydianiline * 1, Water * 5)
                .colorAverage()
                .build()

        DiglycolicAcidSolution = new Material.Builder(24020, SuSyUtility.susyId('diglycolic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(DiglycolicAcid * 1, AmmoniaSolution * 1, Ethanol * 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcidSolution = new Material.Builder(24021, SuSyUtility.susyId('di_two_ethylhexyl_phosphoric_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(DiTwoEthylhexylPhosphoricAcid * 1, Hexane * 1)
                .colorAverage()
                .build()

        DilutedChloroaceticAnhydride = new Material.Builder(24022, SuSyUtility.susyId('diluted_chloroacetic_anhydride'))
                .liquid()
                .components(ChloroaceticAnhydride * 1, Pyridine * 1, Water * 1)
                .colorAverage()
                .build()

        ZirconiumTetrachlorideTetrahydrofuranComplex = new Material.Builder(24023, SuSyUtility.susyId('zirconium_tetrachloride_tetrahydrofuran_complex'))
                .dust()
                .components(ZirconiumTetrachloride * 1, Tetrahydrofuran * 2)
                .colorAverage()
                .build();

        DilutedTwoEthylTwoHexenal = new Material.Builder(24024, SuSyUtility.susyId('diluted_two_ethyl_two_hexenal'))
                .liquid()
                .components(TwoEthylTwoHexenal * 1, DilutedSodiumHydroxideSolution * 1)
                .colorAverage()
                .build()

        PotassiumButylXanthateSolution = new Material.Builder(24025, SuSyUtility.susyId('potassium_butyl_xanthate_solution'))
                .liquid()
                .components(PotassiumButylXanthate * 1, Water * 1)
                .colorAverage()
                .build();

        DilutedMethylIsobutylKetone = new Material.Builder(24026, SuSyUtility.susyId('diluted_methyl_isobutyl_ketone'))
                .liquid()
                .components(MethylIsobutylKetone * 1, Water * 1)
                .colorAverage()
                .build()

        DilutedTwoEthylhexylNitrate = new Material.Builder(24027, SuSyUtility.susyId('diluted_two_ethylhexyl_nitrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TwoEthylhexylNitrate * 1, Water * 1, SulfuricAcid * 1)
                .colorAverage()
                .build();

        HydratedMagnesiumChlorideGlycolate = new Material.Builder(24028, SuSyUtility.susyId('hydrated_magnesium_chloride_glycolate'))
                .liquid()
                .components(MagnesiumChloride * 1, Water * 2, EthyleneGlycol * 3)
                .colorAverage()
                .build();

        MagnesiumChlorideGlycolate = new Material.Builder(24029, SuSyUtility.susyId('magnesium_chloride_glycolate'))
                .liquid()
                .components(MagnesiumChloride * 1, EthyleneGlycol * 3)
                .colorAverage()
                .build();

        DilutedDiisopropylamine = new Material.Builder(24030, SuSyUtility.susyId('diluted_diisopropylamine'))
                .liquid()
                .components(Diisopropylamine * 1, Water * 2)
                .colorAverage()
                .build()

        PerfluorooctanoicAcidMixture = new Material.Builder(24031, SuSyUtility.susyId('perfluorooctanoic_acid_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PerfluorooctanoicAcid * 1, HydrofluoricAcid * 1)
                .colorAverage()
                .build()

        FluorinatedSurfactantMixture = new Material.Builder(24032, SuSyUtility.susyId('fluorinated_surfactant_mixture'))
                .liquid()
                .components(PerfluorooctanoicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        SodiumEthylXanthateSolution = new Material.Builder(24033, SuSyUtility.susyId('sodium_ethyl_xanthate_solution'))
                .liquid()
                .components(SodiumEthylXanthate * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumAmylXanthateSolution = new Material.Builder(24034, SuSyUtility.susyId('potassium_amyl_xanthate_solution'))
                .liquid()
                .components(PotassiumAmylXanthate * 1, Water * 1)
                .colorAverage()
                .build();

        SodiumIsobutylXanthateSolution = new Material.Builder(24035, SuSyUtility.susyId('sodium_isobutyl_xanthate_solution'))
                .liquid()
                .components(SodiumIsobutylXanthate * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumIsopropylXanthateSolution = new Material.Builder(24036, SuSyUtility.susyId('potassium_isopropyl_xanthate_solution'))
                .liquid()
                .components(PotassiumIsopropylXanthate * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumEthylXanthateSolution = new Material.Builder(24037, SuSyUtility.susyId('potassium_ethyl_xanthate_solution'))
                .liquid()
                .components(PotassiumEthylXanthate * 1, Water * 1)
                .colorAverage()
                .build();

        AcidicTributylPhosphate = new Material.Builder(24038, SuSyUtility.susyId('acidic_tributyl_phosphate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TributylPhosphate * 1, HydrogenChloride * 3)
                .colorAverage()
                .build();

        PhosgeneSolution = new Material.Builder(24039, SuSyUtility.susyId('phosgene_solution'))
                .liquid()
                .components(Phosgene * 1, Dichloromethane * 1)
                .colorAverage()
                .build();

        TriethylamineSolution = new Material.Builder(24040, SuSyUtility.susyId('triethylamine_solution'))
                .liquid()
                .components(Triethylamine * 1, Dichloromethane * 4)
                .colorAverage()
                .build();

        KaminskyCatalyst = new Material.Builder(24041, SuSyUtility.susyId('kaminsky_catalyst'))
                .dust()
                .components(ZirconoceneDichloride * 1, Methylaluminoxane * 1)
                .colorAverage()
                .build();

        TNPSlurry = new Material.Builder(24042, SuSyUtility.susyId('tnp_slurry'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PicricAcid * 1, DilutedSulfuricAcid * 1)
                .colorAverage()
                .build();

        IsophthaloylChlorideSolution = new Material.Builder(24043, SuSyUtility.susyId('isophthaloyl_chloride_solution'))
                .liquid()
                .components(OneTwoDichloroethane * 1, IsophthaloylChloride * 1)
                .colorAverage()
                .build();

        IsophthalicAcidSlurry = new Material.Builder(24044, SuSyUtility.susyId('isophthalic_acid_slurry'))
                .liquid()
                .components(Water * 1, OneTwoDichloroethane * 1, IsophthalicAcid * 1)
                .colorAverage()
                .build()

        DichloroethaneIsophthalicAcidSolution = new Material.Builder(24045, SuSyUtility.susyId('dichloroethane_isophthalic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(OneTwoDichloroethane * 1, IsophthalicAcid * 1)
                .colorAverage()
                .build()

        TetrahydrofuranSolution = new Material.Builder(24046, SuSyUtility.susyId('tetrahydrofuran_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetrahydrofuran * 1, SulfuricAcid * 1, Water * 1)
                .colorAverage()
                .build()

        AcidicTriethylPhosphate = new Material.Builder(24047, SuSyUtility.susyId('acidic_triethyl_phosphate'))
      		.liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TriethylPhosphate * 1, HydrogenChloride * 3)
      		.color(0x4639ee)
      		.build();

        NickelIIBisacetylacetonateSolution = new Material.Builder(24048, SuSyUtility.susyId('nickel_ii_bisacetylacetonate_solution'))
      		.liquid()
      		.components(NickelIIBisacetylacetonate * 1, SodiumNitrate * 2, Water * 2)
      		.color(0x3e5051)
      	    	.build();

        ShellHigherOlefinCatalystSolution = new Material.Builder(24049, SuSyUtility.susyId('shell_higher_olefin_catalyst_solution'))
                .liquid()
                .components(Nickel * 1, DiphenylphosphinoaceticAcid * 1, Cyclooctadiene * 2, EthyleneGlycol * 1)
                .color(0x9c1012)
                .build();

        AcidicNitrobenzeneMixture = new Material.Builder(24050, SuSyUtility.susyId('acidic_nitrobenzene_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Nitrobenzene * 1, SulfuricAcid * 1, Water * 1)
                .colorAverage()
                .build();

        DichlorobistriphenylphosphinenickelII = new Material.Builder(24051, SuSyUtility.susyId('dichlorobistriphenylphosphinenickel_ii'))
                .dust()
                .components(Nickel * 1, Chlorine * 2, Triphenylphosphine * 2)
                .colorAverage()
                .build();

        DichlorobistriphenylphosphinenickelII.setFormula('NiCl2(PPh3)2', true)

        DicarbonylbistriphenylphosphinenickelZero = new Material.Builder(24052, SuSyUtility.susyId('dicarbonylbistriphenylphosphinenickel_zero'))
                .dust()
                .components(Nickel * 1, Carbon * 2, Oxygen * 2, Triphenylphosphine * 2)
                .colorAverage()
                .build();

        DicarbonylbistriphenylphosphinenickelZero.setFormula('Ni(CO)2(PPh)2', true)

        SodiumPhenoxideSolution = new Material.Builder(24053, SuSyUtility.susyId('sodium_phenoxide_solution'))
                .liquid()
                .components(SodiumPhenoxide * 1, Water * 1)
                .colorAverage()
                .build();

        WetEpoxy = new Material.Builder(24054, SuSyUtility.susyId('wet_epoxy'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Epoxy * 1)
                .color(0xa16f0d)
                .build();

        TetrabromobisphenolASolution = new Material.Builder(24055, SuSyUtility.susyId('tetrabromobisphenol_a_solution'))
                .liquid()
                .components(TetrabromobisphenolA * 1, OneTwoDichloroethane * 6)
                .colorAverage()
                .build();

        EpoxyCuringMixture = new Material.Builder(24056, SuSyUtility.susyId('epoxy_curing_mixture'))
                .dust()
                .components(Dicyandiamide * 1, TwoMethylimidazole * 1, PhthalicAnhydride * 1)
                .colorAverage()
                .build();

        WetFlameRetardantEpoxy = new Material.Builder(24057, SuSyUtility.susyId('wet_flame_retardant_epoxy'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(FlameRetardantEpoxy * 1)
                .color(0xa1530b)
                .build();

        PropyleneOxideSolution = new Material.Builder(24058, SuSyUtility.susyId('propylene_oxide_solution'))
                .liquid()
                .components(CalciumChloride * 1, PropyleneOxide * 2, Water * 2)
                .colorAverage()
                .build();

        OrthoParaXyleneMixture = new Material.Builder(24059, SuSyUtility.susyId('ortho_para_xylene_mixture'))
                .liquid()
                .components(OrthoXylene * 60, ParaXylene * 40)
                .colorAverage()
                .build();

        HydrogenSilsesquioxanePhotoresist = new Material.Builder(24060, SuSyUtility.susyId('hydrogen_silsesquioxane_photoresist'))
                .liquid()
                .components(HydrogenSilsesquioxane * 1, MethylIsobutylKetone * 99)
                .colorAverage()
                .build();

        CrudeTerephthalicAcidSlurry = new Material.Builder(24061, SuSyUtility.susyId('crude_terephthalic_acid_slurry'))
                .liquid()
                .components(AmocoTerephthalicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        CrudeIsophthalicAcidSlurry = new Material.Builder(24062, SuSyUtility.susyId('crude_isophthalic_acid_slurry'))
                .liquid()
                .components(AmocoIsophthalicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        HydrogenatedTerephthalicAcidSlurry = new Material.Builder(24063, SuSyUtility.susyId('hydrogenated_terephthalic_acid_slurry'))
                .liquid()
                .components(TerephthalicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        HydrogenatedIsophthalicAcidSlurry = new Material.Builder(24064, SuSyUtility.susyId('hydrogenated_isophthalic_acid_slurry'))
                .liquid()
                .components(IsophthalicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        AmocoPurificationMotherLiquor = new Material.Builder(24065, SuSyUtility.susyId('amoco_purification_mother_liquor'))
                .liquid()
                .components(MethylParaToluate * 1, Water * 100)
                .colorAverage()
                .build();

        ParaToluateMixture = new Material.Builder(24066, SuSyUtility.susyId('para_toluate_mixture'))
                .liquid(new FluidBuilder().temperature(540))
                .components(Carbon * 9, Hydrogen * 8, Oxygen * 4, ParaToluicAcid * 1)
                .colorAverage()
                .build();
        
        ParaToluateMixture.setFormula("(C10H10O4)(C9H8O4)", true)

        CrudeDimethylTerephthalateSolution = new Material.Builder(24067, SuSyUtility.susyId('crude_dimethyl_terephthalate_solution'))
                .liquid()
                .components(CrudeDimethylTerephthalate * 1, Methanol * 1)
                .colorAverage()
                .build();

        TerephthalateMotherLiquor = new Material.Builder(24068, SuSyUtility.susyId('terephthalate_mother_liquor'))
                .liquid()
                .components(CrudeDimethylTerephthalate * 1, Methanol * 2)
                .colorAverage()
                .build();

        MethylParaToluateMixture = new Material.Builder(24069, SuSyUtility.susyId('methyl_para_toluate_mixture'))
                .liquid(new FluidBuilder().temperature(540))
                .components(MethylParaToluate * 1, DimethylTerephthalate * 1)
                .colorAverage()
                .build();

        SodiumDodecylSulfateSolution = new Material.Builder(24070, SuSyUtility.susyId('sodium_dodecyl_sulfate_solution'))
                .liquid()
                .components(SodiumDodecylSulfate * 1, Water * 2)
                .colorAverage()
                .build();

        SodiumCyclopentadienideSolution = new Material.Builder(24071, SuSyUtility.susyId('sodium_cyclopentadienide_solution'))
                .liquid()
                .components(Sodium * 1, Carbon * 5, Hydrogen * 5, Tetrahydrofuran * 1)
                .colorAverage()
                .build()
                .setFormula("(NaC5H5)(C4H8O)", true);

        MethylcyclopentadieneSolution = new Material.Builder(24072, SuSyUtility.susyId('methylcyclopentadiene_solution'))
                .liquid()
                .components(Methylcyclopentadiene * 1, Tetrahydrofuran * 1, Salt * 2)
                .colorAverage()
                .build();

        BismethylcyclopentadienylmanganeseSolution = new Material.Builder(24073, SuSyUtility.susyId('bismethylcyclopentadienylmanganese_solution'))
                .liquid()
                .components(Bismethylcyclopentadienylmanganese * 1, Diglyme * 1, Salt * 2)
                .colorAverage()
                .build();

        DilutedNitromethane = new Material.Builder(24074, SuSyUtility.susyId('diluted_nitromethane'))
                .liquid()
                .components(Nitromethane * 3, Water * 1)
                .colorAverage()
                .build();
      
        EthyleneVinylAcetateSuspension = new Material.Builder(24075, SuSyUtility.susyId('ethylene_vinyl_acetate_suspension'))
                .liquid()
                .components(EthyleneVinylAcetate * 1, Methanol * 1)
                .colorAverage()
                .build();

        EthyleneIsobutyleneVinylAcetateSuspension = new Material.Builder(24076, SuSyUtility.susyId('ethylene_isobutylene_vinyl_acetate_suspension'))
                .liquid()
                .components(EthyleneIsobutyleneVinylAcetate * 1, Methanol * 1)
                .colorAverage()
                .build();

        DewaxingSolvent = new Material.Builder(24077, SuSyUtility.susyId('dewaxing_solvent'))
                .liquid()
                .components(OneTwoDichloroethane * 1, Dichloromethane * 1)
                .colorAverage()
                .build();

        OlefinPolymerizationInitiator = new Material.Builder(24078, SuSyUtility.susyId('olefin_polymerization_initiator'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(NButanol * 1, BoronTrifluoride * 3)
                .colorAverage()
                .build();
        
        TrimelliticAcidSlurry = new Material.Builder(24079, SuSyUtility.susyId('trimellitic_acid_slurry'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TrimelliticAcid * 1, AceticAcid * 1, Water * 1)
                .colorAverage()
                .build();
        
        CalciumSalicylateSolution = new Material.Builder(24080, SuSyUtility.susyId('calcium_salicylate_solution'))
                .liquid()
                .components(CalciumSalicylate * 1, DiethyleneGlycol * 1)
                .colorAverage()
                .build();
        
        AcidicTricresylPhosphate = new Material.Builder(24081, SuSyUtility.susyId('acidic_tricresyl_phosphate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TricresylPhosphate * 1, HydrogenChloride * 3)
                .colorAverage()
                .build();
        
        ChloroaceticAcidSolution = new Material.Builder(24082, SuSyUtility.susyId('chloroacetic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroaceticAcid * 1, SulfuricAcid * 2)
                .colorAverage()
                .build();
        
        OrthoPhenylenediamineSlurry = new Material.Builder(24083, SuSyUtility.susyId('ortho_phenylenediamine_slurry'))
                .liquid()
                .components(OrthoPhenylenediamine * 1, Toluene * 1, Water * 2)
                .colorAverage()
                .build();

        NomexPolymerizationMix = new Material.Builder(24085, SuSyUtility.susyId('nomex_polymerization_mix'))
                .liquid()
                .components(Nomex * 1, CalciumChloride * 1, Dimethylacetamide * 4)
                .colorAverage()
                .build();

        KevlarPolymerizationMix = new Material.Builder(24086, SuSyUtility.susyId('kevlar_polymerization_mix'))
                .liquid()
                .components(Kevlar * 1, CalciumChloride * 1, Dimethylacetamide * 4)
                .colorAverage()
                .build();

        SpentDimethylacetamide = new Material.Builder(24087, SuSyUtility.susyId('spent_dimethylacetamide'))
                .liquid()
                .components(CalciumChloride * 1, Dimethylacetamide * 4)
                .colorAverage()
                .build();

        SodiumCelluloseXanthateSolution = new Material.Builder(24088, SuSyUtility.susyId('sodium_cellulose_xanthate_solution'))
                .liquid()
                .components(SodiumCelluloseXanthate * 1, SodiumHydroxide * 1, Water * 1)
                .colorAverage()
                .build();

        CrotonaldehydeMixture = new Material.Builder(24089, SuSyUtility.susyId('crotonaldehyde_mixture'))
                .liquid()
                .components(SodiumHydroxide * 1, Crotonaldehyde * 1)
                .colorAverage()
                .build();

        GaseousMethacrylicAcidMixture = new Material.Builder(24090, SuSyUtility.susyId('gaseous_methacrylic_acid_mixture'))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon * 4, Hydrogen * 6, Oxygen * 1, MethacrylicAcid * 3, Water * 4)
                .colorAverage()
                .build();

        GaseousMethacrylicAcidMixture.setFormula("(C4H6O)(C4H6O2)3(H2O)4", true)
        
        MethacrylicAcidSolution = new Material.Builder(24091, SuSyUtility.susyId('methacrylic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(MethacrylicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        AcidicChlorodifluoromethane = new Material.Builder(24092, SuSyUtility.susyId('acidic_chlorodifluoromethane'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorodifluoromethane * 1, HydrogenChloride * 2)
                .color(0xbd97c7)
                .build();
        
        SaltyNMethylTwoPyrrolidone = new Material.Builder(24093, SuSyUtility.susyId('salty_n_methyl_two_pyrrolidone'))
                .liquid()
                .components(NMethylTwoPyrrolidone * 1, Salt * 1)
                .colorAverage()
                .build();

        DilutedNMethylTwoPyrrolidone = new Material.Builder(24094, SuSyUtility.susyId('diluted_n_methyl_two_pyrrolidone'))
                .liquid()
                .components(NMethylTwoPyrrolidone * 1, Water * 1)
                .colorAverage()
                .build();

        DilutedButyllithium = new Material.Builder(24095, SuSyUtility.susyId('diluted_butyllithium'))
                .liquid()
                .components(Butyllithium * 1, DiethylEther * 1)
                .colorAverage()
                .build();

        SpentPBISolution = new Material.Builder(24096, SuSyUtility.susyId('spent_pbi_solution'))
                .liquid()
                .components(Dimethylacetamide * 1)
                .colorAverage()
                .build();

        OxalicAcidSolution = new Material.Builder(24097, SuSyUtility.susyId('oxalic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(OxalicAcid * 1, Water * 1)
                .colorAverage()
                .build();

        GalliumSulfateSolution = new Material.Builder(24098, SuSyUtility.susyId('gallium_sulfate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Gallium * 2, Sulfur * 3, Oxygen * 12, OxalicAcid * 6, Water * 3)
                .colorAverage()
                .build();

        GalliumSulfateSolution.setFormula("(Ga2(SO4)3)(H2C2O4)6(H2O)3", true)

        FormicAcidWaterAzeotrope = new Material.Builder(24099, SuSyUtility.susyId('formic_acid_water_azeotrope'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(FormicAcid * 6, Water * 4)
                .color(0xbf3983)
                .build();

        FurfuralSolution = new Material.Builder(24100, SuSyUtility.susyId('furfural_solution'))
                .liquid()
                .components(Furfural * 1, Water * 1)
                .colorAverage()
                .build();
    }
}
