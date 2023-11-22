package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class ThirdDegreeMaterials {
    public static void register() {

        log.infoMC('Registering Third Degree Materials!');

        DiethylEtherSolution = new Material.Builder(24000, SuSyUtility.susyId('diethyl_ether_solution'))
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        LithiumSolution = new Material.Builder(24001, SuSyUtility.susyId('lithium_solution'))
                .fluid()
                .components(Lithium, 2, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        DimethylacetamideSolution = new Material.Builder(24002, SuSyUtility.susyId('dimethylacetamide_solution'))
                .fluid()
                .components(Water, 1, Dimethylacetamide, 1)
                .colorAverage()
                .build();

        FurfuralSolution = new Material.Builder(24003, SuSyUtility.susyId('furfural_solution'))
                .fluid()
                .components(Water, 3, SulfuricAcid, 1, Furfural, 1)
                .colorAverage()
                .build();

        WackerCatalystSolution = new Material.Builder(24004, SuSyUtility.susyId('wacker_catalyst_solution'))
                .fluid()
                .components(Water, 1, WackerCatalyst, 1)
                .colorAverage()
                .build();

        TwoEthylanthraquinoneSolution = new Material.Builder(24005, SuSyUtility.susyId('two_ethylanthraquinone_solution'))
                .fluid()
                .components(TwoEthylanthraquinone, 1, HydrogenPeroxide, 3)
                .colorAverage()
                .build();

        AcetamideSolution = new Material.Builder(24006, SuSyUtility.susyId('acetamide_solution'))
                .fluid()
                .components(Butanone, 1, Acetamide, 1)
                .colorAverage()
                .build();

        HydrazineSolution = new Material.Builder(24007, SuSyUtility.susyId('hydrazine_solution'))
                .fluid()
                .components(Water, 4, Hydrazine, 1, Ammonia, 2)
                .colorAverage()
                .build();

        EthylenediamineSolution = new Material.Builder(24008, SuSyUtility.susyId('ethylenediamine_solution'))
                .fluid()
                .components(Ethylenediamine, 1, HydrogenChloride, 1)
                .colorAverage()
                .build()

        DeacidifiedEthylenediamine = new Material.Builder(24009, SuSyUtility.susyId('deacidified_ethylenediamine'))
                .fluid()
                .components(Ethylenediamine, 1, Water, 2, Salt, 1)
                .colorAverage()
                .build()

        EthylenediaminetetraaceticAcidSolution = new Material.Builder(24010, SuSyUtility.susyId('ethylenediaminetetraacetic_acid_solution'))
                .fluid()
                .components(Water, 1, EthylenediaminetetraaceticAcid, 1)
                .colorAverage()
                .build()

        TetrasodiumEthylenediaminetetraaceticAcidSolution = new Material.Builder(24011, SuSyUtility.susyId('tetrasodium_ethylenediaminetetraacetic_acid_solution'))
                .fluid()
                .components(SaltWater, 1, TetrasodiumEthylenediaminetetraaceticAcid, 1)
                .colorAverage()
                .build()

        UreaSolution = new Material.Builder(24012, SuSyUtility.susyId('urea_solution'))
                .fluid()
                .components(Water, 1, Urea, 1)
                .colorAverage()
                .build()

        DiiodobenzeneSolution = new Material.Builder(24013, SuSyUtility.susyId('diiodobenzene_solution'))
                .fluid()
                .components(Ethanol, 1, Diiodobenzene, 1)
                .colorAverage()
                .build()

        ImpureFourFourOxydianiline = new Material.Builder(24014, SuSyUtility.susyId('impure_four_four_oxydianiline'))
                .fluid()
                .components(Ethanol, 2, Water, 5, FourFourOxydianiline, 1, AmmoniumIodide, 4)
                .colorAverage()
                .build()

        EthyleneGlycolSolution = new Material.Builder(24015, SuSyUtility.susyId('ethylene_glycol_solution'))
                .fluid()
                .components(EthyleneGlycol, 1, Water, 2, SodiumHydroxide, 3)
                .colorAverage()
                .build()

        TerephthalicAcidSlurry = new Material.Builder(24016, SuSyUtility.susyId('terephthalic_acid_slurry'))
                .fluid()
                .components(AceticAcid, 1, Water, 1, TerephthalicAcid, 1)
                .colorAverage()
                .build()

        CelluloseAcetateSolution = new Material.Builder(24017, SuSyUtility.susyId('cellulose_acetate_solution'))
                .fluid()
                .components(Acetone, 1, CelluloseAcetate, 1)
                .colorAverage()
                .build()

        TwoButanolSolution = new Material.Builder(24018, SuSyUtility.susyId('two_butanol_solution'))
                .fluid()
                .components(SulfuricAcid, 1, TwoButanol, 1)
                .colorAverage()
                .build()

        FourFourOxydianilineSolution = new Material.Builder(24019, SuSyUtility.susyId('four_four_oxydianiline_solution'))
                .fluid()
                .components(Water, 5, FourFourOxydianiline, 1)
                .colorAverage()
                .build()

        DiglycolicAcidSolution = new Material.Builder(24020, SuSyUtility.susyId('diglycolic_acid_solution'))
                .fluid()
                .components(DiglycolicAcid, 1, AmmoniaSolution, 1, Ethanol, 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcidSolution = new Material.Builder(24021, SuSyUtility.susyId('di_two_ethylhexyl_phosphoric_acid_solution'))
                .fluid()
                .components(DiTwoEthylhexylPhosphoricAcid, 1, Hexane, 1)
                .colorAverage()
                .build()

        DilutedChloroaceticAnhydride = new Material.Builder(24022, SuSyUtility.susyId('diluted_chloroacetic_anhydride'))
                .fluid()
                .components(ChloroaceticAnhydride, 1, Pyridine, 1, Water, 1)
                .colorAverage()
                .build()

        ZirconiumTetrachlorideTetrahydrofuranComplex = new Material.Builder(24023, SuSyUtility.susyId('zirconium_tetrachloride_tetrahydrofuran_complex'))
                .dust()
                .components(ZirconiumTetrachloride, 1, Tetrahydrofuran, 2)
                .colorAverage()
                .build();

        DilutedTwoEthylTwoHexenal = new Material.Builder(24024, SuSyUtility.susyId('diluted_two_ethyl_two_hexenal'))
                .fluid()
                .components(TwoEthylTwoHexenal, 1, DilutedSodiumHydroxideSolution, 1)
                .colorAverage()
                .build()

        PotassiumButylXanthateSolution = new Material.Builder(24025, SuSyUtility.susyId('potassium_butyl_xanthate_solution'))
                .fluid()
                .components(PotassiumButylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        DilutedMethylIsobutylKetone = new Material.Builder(24026, SuSyUtility.susyId('diluted_methyl_isobutyl_ketone'))
                .fluid()
                .components(MethylIsobutylKetone, 1, Water, 1)
                .colorAverage()
                .build()

        ChlorinatedBeryl = new Material.Builder(24027, SuSyUtility.susyId('chlorinated_beryl'))
                .fluid(FluidTypes.GAS)
                .fluidTemp(1100)
                .components(BerylliumChloride, 3, AluminiumChloride, 2, SiliconTetrachloride, 6, CarbonMonoxide, 18)
                .colorAverage()
                .build();

        HydratedMagnesiumChlorideGlycolate = new Material.Builder(24028, SuSyUtility.susyId('hydrated_magnesium_chloride_glycolate'))
                .fluid()
                .components(MagnesiumChloride, 1, Water, 2, EthyleneGlycol, 3)
                .colorAverage()
                .build();

        MagnesiumChlorideGlycolate = new Material.Builder(24029, SuSyUtility.susyId('magnesium_chloride_glycolate'))
                .fluid()
                .components(MagnesiumChloride, 1, EthyleneGlycol, 3)
                .colorAverage()
                .build();

        DilutedDiisopropylamine = new Material.Builder(24030, SuSyUtility.susyId('diluted_diisopropylamine'))
                .fluid()
                .components(Diisopropylamine, 1, Water, 2)
                .colorAverage()
                .build()

        PerfluorooctanoicAcidMixture = new Material.Builder(24031, SuSyUtility.susyId('perfluorooctanoic_acid_mixture'))
                .fluid()
                .components(PerfluorooctanoicAcid, 1, HydrofluoricAcid, 1)
                .colorAverage()
                .build()

        FluorinatedSurfactantMixture = new Material.Builder(24032, SuSyUtility.susyId('fluorinated_surfactant_mixture'))
                .fluid()
                .components(PerfluorooctanoicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumEthylXanthateSolution = new Material.Builder(24033, SuSyUtility.susyId('sodium_ethyl_xanthate_solution'))
                .fluid()
                .components(SodiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumAmylXanthateSolution = new Material.Builder(24034, SuSyUtility.susyId('potassium_amyl_xanthate_solution'))
                .fluid()
                .components(PotassiumAmylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumIsobutylXanthateSolution = new Material.Builder(24035, SuSyUtility.susyId('sodium_isobutyl_xanthate_solution'))
                .fluid()
                .components(SodiumIsobutylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumIsopropylXanthateSolution = new Material.Builder(24036, SuSyUtility.susyId('potassium_isopropyl_xanthate_solution'))
                .fluid()
                .components(PotassiumIsopropylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumEthylXanthateSolution = new Material.Builder(24037, SuSyUtility.susyId('potassium_ethyl_xanthate_solution'))
                .fluid()
                .components(PotassiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        AcidicTributylPhosphate = new Material.Builder(24038, SuSyUtility.susyId('acidic_tributyl_phosphate'))
                .fluid()
                .components(TributylPhosphate, 1, HydrogenChloride, 3)
                .colorAverage()
                .build();

        PhosgeneSolution = new Material.Builder(24039, SuSyUtility.susyId('phosgene_solution'))
                .fluid()
                .components(Phosgene, 1, Dichloromethane, 1)
                .colorAverage()
                .build();

        TriethylamineSolution = new Material.Builder(24040, SuSyUtility.susyId('triethylamine_solution'))
                .fluid()
                .components(Triethylamine, 1, Dichloromethane, 4)
                .colorAverage()
                .build();

        KaminskyCatalyst = new Material.Builder(24041, SuSyUtility.susyId('kaminsky_catalyst'))
                .dust()
                .components(ZirconoceneDichloride, 1, Methylaluminoxane, 1)
                .colorAverage()
                .build();

        TNPSolution = new Material.Builder(24042, SuSyUtility.susyId('tnp_solution'))
                .fluid()
                .components(PicricAcid, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .build();

        IsophthaloylDichlorideSolution = new Material.Builder(24043, SuSyUtility.susyId('isophthaloyl_dichloride_solution'))
                .fluid()
                .components(AceticAcid, 1, Water, 1, IsophthaloylDichloride, 1)
                .colorAverage()
                .build();

        IsophthalicAcidSlurry = new Material.Builder(24044, SuSyUtility.susyId('isophthalic_acid_slurry'))
                .fluid()
                .components(AceticAcid, 1, Water, 1, IsophthalicAcid, 1)
                .colorAverage()
                .build()

        DichloroethaneIsophthalicAcidSolution = new Material.Builder(24045, SuSyUtility.susyId('dichloroethane_isophthalic_acid_solution'))
                .fluid()
                .components(Dichloroethane, 1, IsophthalicAcid, 1)
                .colorAverage()
                .build()

        TetrahydrofuranSolution = new Material.Builder(24046, SuSyUtility.susyId('tetrahydrofuran_solution'))
                .fluid()
                .components(Tetrahydrofuran, 1, SulfuricAcid, 1, Water, 1)
                .colorAverage()
                .build()

        AcidicTriethylPhosphate = new Material.Builder(24047, SuSyUtility.susyId('acidic_triethyl_phosphate'))
      		.fluid()
                .components(TriethylPhosphate, 1, HydrogenChloride, 3)
      		.color(0x4639ee)
      		.build();

        NickelIIBisacetylacetonateSolution = new Material.Builder(24048, SuSyUtility.susyId('nickel_ii_bisacetylacetonate_solution'))
      		.fluid()
      		.components(NickelIIBisacetylacetonate, 1, SodiumNitrate, 2, Water, 2)
      		.color(0x3e5051)
      	    	.build();

        ShellHigherOlefinCatalystSolution = new Material.Builder(24049, SuSyUtility.susyId('shell_higher_olefin_catalyst_solution'))
                .fluid()
                .components(Nickel, 1, DiphenylphosphinoaceticAcid, 1, Cyclooctadiene, 2, EthyleneGlycol, 1)
                .color(0x9c1012)
                .build();

        CrudeNitrobenzene = new Material.Builder(24050, SuSyUtility.susyId('crude_nitrobenzene'))
                .fluid()
                .components(Nitrobenzene, 2, Benzene, 1)
                .colorAverage()
                .build();

        DichlorobistriphenylphosphinenickelII = new Material.Builder(24051, SuSyUtility.susyId('dichlorobistriphenylphosphinenickel_ii'))
                .dust()
                .components(Nickel, 1, Chlorine, 2, Triphenylphosphine, 2)
                .colorAverage()
                .build();

        DichlorobistriphenylphosphinenickelII.setFormula('NiCl2(PPh3)2', true)

        DicarbonylbistriphenylphosphinenickelZero = new Material.Builder(24052, SuSyUtility.susyId('dicarbonylbistriphenylphosphinenickel_zero'))
                .dust()
                .components(Nickel, 1, Carbon, 2, Oxygen, 2, Triphenylphosphine, 2)
                .colorAverage()
                .build();

        DicarbonylbistriphenylphosphinenickelZero.setFormula('Ni(CO)2(PPh)2', true)

        SodiumPhenoxideSolution = new Material.Builder(24053, SuSyUtility.susyId('sodium_phenoxide_solution'))
                .fluid()
                .components(Water, 1, SodiumPhenoxide, 1)
                .colorAverage()
                .build();

        WetEpoxy = new Material.Builder(24054, SuSyUtility.susyId('wet_epoxy'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Epoxy, 1)
                .color(0xa16f0d)
                .build();

        TetrabromobisphenolASolution = new Material.Builder(24055, SuSyUtility.susyId('tetrabromobisphenol_a_solution'))
                .fluid()
                .components(TetrabromobisphenolA, 1, Dichloroethane, 6)
                .colorAverage()
                .build();

        EpoxyCuringMixture = new Material.Builder(24056, SuSyUtility.susyId('epoxy_curing_mixture'))
                .dust()
                .components(Dicyandiamide, 1, TwoMethylimidazole, 1, PhthalicAnhydride, 1)
                .colorAverage()
                .build();

        WetFlameRetardantEpoxy = new Material.Builder(24057, SuSyUtility.susyId('wet_flame_retardant_epoxy'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(FlameRetardantEpoxy, 1)
                .color(0xa1530b)
                .build();

        PropyleneOxideSolution = new Material.Builder(24058, SuSyUtility.susyId('propylene_oxide_solution'))
                .fluid()
                .components(CalciumChloride, 1, PropyleneOxide, 2, Water, 2)
                .colorAverage()
                .build();

        OrthoParaXyleneMixture = new Material.Builder(24059, SuSyUtility.susyId('ortho_para_xylene_mixture'))
                .fluid()
                .components(OrthoXylene, 60, ParaXylene, 40)
                .colorAverage()
                .build();

        HydrogenSilsesquioxanePhotoresist = new Material.Builder(24060, SuSyUtility.susyId('hydrogen_silsesquioxane_photoresist'))
                .fluid()
                .components(HydrogenSilsesquioxane, 1, MethylIsobutylKetone, 99)
                .colorAverage()
                .build();

        CrudeTerephthalicAcidSolution = new Material.Builder(24061, SuSyUtility.susyId('crude_terephthalic_acid_solution'))
                .fluid()
                .fluidTemp(533)
                .components(AmocoTerephthalicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        CrudeIsophthalicAcidSolution = new Material.Builder(24062, SuSyUtility.susyId('crude_isophthalic_acid_solution'))
                .fluid()
                .fluidTemp(533)
                .components(AmocoIsophthalicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        HydrogenatedTerephthalicAcidSolution = new Material.Builder(24063, SuSyUtility.susyId('hydrogenated_terephthalic_acid_solution'))
                .fluid()
                .fluidTemp(533)
                .components(TerephthalicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        HydrogenatedIsophthalicAcidSolution = new Material.Builder(24064, SuSyUtility.susyId('hydrogenated_isophthalic_acid_solution'))
                .fluid()
                .fluidTemp(533)
                .components(IsophthalicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        AmocoPurificationMotherLiquor = new Material.Builder(24065, SuSyUtility.susyId('amoco_purification_mother_liquor'))
                .fluid()
                .components(MethylParaToluate, 1, Water, 100)
                .colorAverage()
                .build();

        ParaToluateMixture = new Material.Builder(24066, SuSyUtility.susyId('para_toluate_mixture'))
                .fluid()
                .components(Carbon, 9, Hydrogen, 8, Oxygen, 4, ParaToluicAcid, 1)
                .colorAverage()
                .build();
        
        ParaToluateMixture.setFormula("(C10H10O4)(C9H8O4)", true)

        CrudeDimethylTerephthalateSolution = new Material.Builder(24067, SuSyUtility.susyId('crude_dimethyl_terephthalate_solution'))
                .fluid()
                .components(CrudeDimethylTerephthalate, 1, Methanol, 1)
                .colorAverage()
                .build();

        TerephthalateMotherLiquor = new Material.Builder(24068, SuSyUtility.susyId('terephthalate_mother_liquor'))
                .fluid()
                .components(CrudeDimethylTerephthalate, 1, Methanol, 2)
                .colorAverage()
                .build();

        MethylParaToluateMixture = new Material.Builder(24069, SuSyUtility.susyId('methyl_para_toluate_mixture'))
                .fluid()
                .components(MethylParaToluate, 1, DimethylTerephthalate, 1)
                .colorAverage()
                .build();

        SodiumDodecylSulfateSolution = new Material.Builder(24070, SuSyUtility.susyId('sodium_dodecyl_sulfate_solution'))
                .fluid()
                .components(SodiumDodecylSulfate, 1, Water, 2)
                .colorAverage()
                .build();

        SodiumCyclopentadienideSolution = new Material.Builder(24071, SuSyUtility.susyId('sodium_cyclopentadienide_solution'))
                .fluid()
                .components(Sodium, 1, Carbon, 5, Hydrogen, 5, Tetrahydrofuran, 1)
                .colorAverage()
                .build()
                .setFormula("(NaC5H5)(C4H8O)", true);

        MethylcyclopentadieneSolution = new Material.Builder(24072, SuSyUtility.susyId('methylcyclopentadiene_solution'))
                .fluid()
                .components(Methylcyclopentadiene, 1, Tetrahydrofuran, 1, Salt, 2)
                .colorAverage()
                .build();

        BismethylcyclopentadienylmanganeseSolution = new Material.Builder(24073, SuSyUtility.susyId('bismethylcyclopentadienylmanganese_solution'))
                .fluid()
                .components(Bismethylcyclopentadienylmanganese, 1, Diglyme, 1, Salt, 2)
                .colorAverage()
                .build();

        //FREE ID: 24074
      
        EthyleneVinylAcetateMixture = new Material.Builder(24075, SuSyUtility.susyId('ethylene_vinyl_acetate_mixture'))
                .fluid()
                .components(EthyleneVinylAcetate, 1, Methanol, 1)
                .colorAverage()
                .build();

        EthyleneIsobutyleneVinylAcetateMixture = new Material.Builder(24076, SuSyUtility.susyId('ethylene_isobutylene_vinyl_acetate_mixture'))
                .fluid()
                .components(EthyleneIsobutyleneVinylAcetate, 1, Methanol, 1)
                .colorAverage()
                .build();
    }
}
