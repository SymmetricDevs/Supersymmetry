package material

import static material.SuSyMaterials.*

import gregtech.api.unification.material.Material
import gregtech.api.GregTechAPI
import gregtech.api.fluids.attribute.FluidAttributes
import gregtech.api.fluids.FluidBuilder
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

class ThirdDegreeMaterials {

    static Material genSolution(int id, String name, Material solute, Material solvent, boolean is_acid) {
        def builder = new Material.Builder(id, SuSyUtility.susyId(name))
                .components(solute, solvent)
                .colorAverage()
        if (is_acid) {
            builder = builder.liquid(new FluidBuilder().attributes(FluidAttributes.ACID))
        } else {
            builder = builder.liquid();
        }
        return builder.build()
    }

    static void register() {

        log.infoMC('Registering Third Degree Materials!')

        DiethylEtherSolution = new Material.Builder(24000, SuSyUtility.susyId('diethyl_ether_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(material('diethyl_ether'), SulfuricAcid, Water)
                .colorAverage()
                .build()

        LithiumSolution = new Material.Builder(24001, SuSyUtility.susyId('lithium_solution'))
                .liquid()
                .components(Lithium * 2, material('diethyl_ether'))
                .colorAverage()
                .build()

        DimethylacetamideSolution = new Material.Builder(24002, SuSyUtility.susyId('dimethylacetamide_solution'))
                .liquid()
                .components(Dimethylacetamide, Water)
                .colorAverage()
                .build()

        AcidicFurfuralSolution = new Material.Builder(24003, SuSyUtility.susyId('acidic_furfural_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Furfural, SulfuricAcid, Water * 3)
                .colorAverage()
                .build()

        // FREE ID: 24004

        TwoEthylanthraquinoneSolution = new Material.Builder(24005, SuSyUtility.susyId('two_ethylanthraquinone_solution'))
                .liquid()
                .components(TwoEthylanthraquinone, TrisTwoEthylhexylPhosphate, Xylene)
                .colorAverage()
                .build()

        AcetamideSolution = new Material.Builder(24006, SuSyUtility.susyId('acetamide_solution'))
                .liquid()
                .components(Butanone, Acetamide)
                .colorAverage()
                .build()

        HydrazineSolution = new Material.Builder(24007, SuSyUtility.susyId('hydrazine_solution'))
                .liquid()
                .components(Hydrazine, Ammonia * 2, Water * 4)
                .colorAverage()
                .build()

        LithiumHexafluorophosphateElectrolyte = new Material.Builder(24008, SuSyUtility.susyId("lithium_hexafluorophosphate_electrolyte"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(LithiumHexafluorophosphate, EthyleneCarbonate)
                .colorAverage()
                .build()

        TNTSlurry = new Material.Builder(24009, SuSyUtility.susyId('tnt_slurry'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TNT, DilutedSulfuricAcid)
                .colorAverage()
                .build()

        BufferedOxideEtchant = new Material.Builder(24010, SuSyUtility.susyId('buffered_oxide_etchant'))
                .liquid()
                .components(AmmoniumFluoride * 3, UltrapureHydrofluoricAcid, UltrapureWater * 13)
                .colorAverage()
                .build()

        SodiumEthoxideSolution = new Material.Builder(24011, SuSyUtility.susyId('sodium_ethoxide_solution'))
                .liquid()
                .components(SodiumEthoxide, Ethanol)
                .color(0xcc5050)
                .build()

        SodiumEthoxideSolution.setFormula('(CH3CH2ONa)(CH3CH2OH)', true)

        UreaSolution = new Material.Builder(24012, SuSyUtility.susyId('urea_solution'))
                .liquid()
                .components(Urea, Water)
                .colorAverage()
                .build()

        DiiodobenzeneSolution = new Material.Builder(24013, SuSyUtility.susyId('diiodobenzene_solution'))
                .liquid()
                .components(Ethanol, Diiodobenzene)
                .colorAverage()
                .build()

        ImpureFourFourOxydianiline = new Material.Builder(24014, SuSyUtility.susyId('impure_four_four_oxydianiline'))
                .liquid()
                .components(Ethanol * 2, Water * 5, FourFourOxydianiline, AmmoniumIodide * 4)
                .colorAverage()
                .build()

        EthyleneGlycolSolution = new Material.Builder(24015, SuSyUtility.susyId('ethylene_glycol_solution'))
                .liquid()
                .components(EthyleneGlycol, Water * 2, SodiumHydroxide * 3)
                .colorAverage()
                .build()

        TerephthalicAcidSlurry = new Material.Builder(24016, SuSyUtility.susyId('terephthalic_acid_slurry'))
                .liquid()
                .components(AceticAcid, Water, TerephthalicAcid)
                .colorAverage()
                .build()

        CelluloseAcetateSolution = new Material.Builder(24017, SuSyUtility.susyId('cellulose_acetate_solution'))
                .liquid()
                .components(Acetone, CelluloseAcetate)
                .colorAverage()
                .build()

        TwoButanolSolution = new Material.Builder(24018, SuSyUtility.susyId('two_butanol_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, TwoButanol)
                .colorAverage()
                .build()

        FourFourOxydianilineSlurry = new Material.Builder(24019, SuSyUtility.susyId('four_four_oxydianiline_slurry'))
                .liquid()
                .components(FourFourOxydianiline, Water * 5)
                .colorAverage()
                .build()

        DiglycolicAcidSolution = new Material.Builder(24020, SuSyUtility.susyId('diglycolic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(DiglycolicAcid, AmmoniaSolution, Ethanol)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcidSolution = new Material.Builder(24021, SuSyUtility.susyId('di_two_ethylhexyl_phosphoric_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(DiTwoEthylhexylPhosphoricAcid, Hexane)
                .colorAverage()
                .build()

        DilutedChloroaceticAnhydride = new Material.Builder(24022, SuSyUtility.susyId('diluted_chloroacetic_anhydride'))
                .liquid()
                .components(ChloroaceticAnhydride, Pyridine, Water)
                .colorAverage()
                .build()

        ZirconiumTetrachlorideTetrahydrofuranComplex = new Material.Builder(24023, SuSyUtility.susyId('zirconium_tetrachloride_tetrahydrofuran_complex'))
                .dust()
                .components(ZirconiumTetrachloride, Tetrahydrofuran * 2)
                .colorAverage()
                .build()

        DilutedTwoEthylTwoHexenal = new Material.Builder(24024, SuSyUtility.susyId('diluted_two_ethyl_two_hexenal'))
                .liquid()
                .components(TwoEthylTwoHexenal, DilutedSodiumHydroxideSolution)
                .colorAverage()
                .build()

        PotassiumButylXanthateSolution = new Material.Builder(24025, SuSyUtility.susyId('potassium_butyl_xanthate_solution'))
                .liquid()
                .components(PotassiumButylXanthate, Water)
                .colorAverage()
                .build()

        DilutedMethylIsobutylKetone = new Material.Builder(24026, SuSyUtility.susyId('diluted_methyl_isobutyl_ketone'))
                .liquid()
                .components(MethylIsobutylKetone, Water)
                .colorAverage()
                .build()

        DilutedTwoEthylhexylNitrate = new Material.Builder(24027, SuSyUtility.susyId('diluted_two_ethylhexyl_nitrate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TwoEthylhexylNitrate, Water, SulfuricAcid)
                .colorAverage()
                .build()

        HydratedMagnesiumChlorideGlycolate = new Material.Builder(24028, SuSyUtility.susyId('hydrated_magnesium_chloride_glycolate'))
                .liquid()
                .components(MagnesiumChloride, Water * 2, EthyleneGlycol * 3)
                .colorAverage()
                .build()

        MagnesiumChlorideGlycolate = new Material.Builder(24029, SuSyUtility.susyId('magnesium_chloride_glycolate'))
                .liquid()
                .components(MagnesiumChloride, EthyleneGlycol * 3)
                .colorAverage()
                .build()

        DilutedDiisopropylamine = new Material.Builder(24030, SuSyUtility.susyId('diluted_diisopropylamine'))
                .liquid()
                .components(Diisopropylamine, Water * 2)
                .colorAverage()
                .build()

        PerfluorooctanoicAcidMixture = new Material.Builder(24031, SuSyUtility.susyId('perfluorooctanoic_acid_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PerfluorooctanoicAcid, HydrofluoricAcid)
                .colorAverage()
                .build()

        FluorinatedSurfactantMixture = new Material.Builder(24032, SuSyUtility.susyId('fluorinated_surfactant_mixture'))
                .liquid()
                .components(PerfluorooctanoicAcid, Water, Ammonia)
                .colorAverage()
                .build()

        SodiumEthylXanthateSolution = new Material.Builder(24033, SuSyUtility.susyId('sodium_ethyl_xanthate_solution'))
                .liquid()
                .components(SodiumEthylXanthate, Water)
                .colorAverage()
                .build()

        PotassiumAmylXanthateSolution = new Material.Builder(24034, SuSyUtility.susyId('potassium_amyl_xanthate_solution'))
                .liquid()
                .components(PotassiumAmylXanthate, Water)
                .colorAverage()
                .build()

        SodiumIsobutylXanthateSolution = new Material.Builder(24035, SuSyUtility.susyId('sodium_isobutyl_xanthate_solution'))
                .liquid()
                .components(SodiumIsobutylXanthate, Water)
                .colorAverage()
                .build()

        PotassiumIsopropylXanthateSolution = new Material.Builder(24036, SuSyUtility.susyId('potassium_isopropyl_xanthate_solution'))
                .liquid()
                .components(PotassiumIsopropylXanthate, Water)
                .colorAverage()
                .build()

        PotassiumEthylXanthateSolution = new Material.Builder(24037, SuSyUtility.susyId('potassium_ethyl_xanthate_solution'))
                .liquid()
                .components(PotassiumEthylXanthate, Water)
                .colorAverage()
                .build()

        AcidicTributylPhosphate = new Material.Builder(24038, SuSyUtility.susyId('acidic_tributyl_phosphate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TributylPhosphate, HydrogenChloride * 3)
                .colorAverage()
                .build()

        PhosgeneSolution = new Material.Builder(24039, SuSyUtility.susyId('phosgene_solution'))
                .liquid()
                .components(Phosgene, Dichloromethane)
                .colorAverage()
                .build()

        TriethylamineSolution = new Material.Builder(24040, SuSyUtility.susyId('triethylamine_solution'))
                .liquid()
                .components(Triethylamine, Dichloromethane * 4)
                .colorAverage()
                .build()

        KaminskyCatalyst = new Material.Builder(24041, SuSyUtility.susyId('kaminsky_catalyst'))
                .dust()
                .components(ZirconoceneDichloride, Methylaluminoxane)
                .colorAverage()
                .build()

        TNPSlurry = new Material.Builder(24042, SuSyUtility.susyId('tnp_slurry'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PicricAcid, DilutedSulfuricAcid)
                .colorAverage()
                .build()

        IsophthaloylChlorideSolution = new Material.Builder(24043, SuSyUtility.susyId('isophthaloyl_chloride_solution'))
                .liquid()
                .components(OneTwoDichloroethane, IsophthaloylChloride)
                .colorAverage()
                .build()

        IsophthalicAcidSlurry = new Material.Builder(24044, SuSyUtility.susyId('isophthalic_acid_slurry'))
                .liquid()
                .components(Water, AceticAcid, IsophthalicAcid)
                .colorAverage()
                .build()

        DichloroethaneIsophthalicAcidSolution = new Material.Builder(24045, SuSyUtility.susyId('dichloroethane_isophthalic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(OneTwoDichloroethane, IsophthalicAcid)
                .colorAverage()
                .build()

        TetrahydrofuranSolution = new Material.Builder(24046, SuSyUtility.susyId('tetrahydrofuran_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tetrahydrofuran, SulfuricAcid, Water)
                .colorAverage()
                .build()

        AcidicTriethylPhosphate = new Material.Builder(24047, SuSyUtility.susyId('acidic_triethyl_phosphate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TriethylPhosphate, HydrogenChloride * 3)
                .color(0x4639ee)
                .build()

        NickelIIBisacetylacetonateSolution = new Material.Builder(24048, SuSyUtility.susyId('nickel_ii_bisacetylacetonate_solution'))
                .liquid()
                .components(NickelIIBisacetylacetonate, SodiumNitrate * 2, Water * 2)
                .color(0x3e5051)
                .build()

        ShellHigherOlefinCatalystSolution = new Material.Builder(24049, SuSyUtility.susyId('shell_higher_olefin_catalyst_solution'))
                .liquid()
                .components(Nickel, DiphenylphosphinoaceticAcid, Cyclooctadiene * 2, EthyleneGlycol)
                .color(0x9c1012)
                .build()

        AcidicNitrobenzeneMixture = new Material.Builder(24050, SuSyUtility.susyId('acidic_nitrobenzene_mixture'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Nitrobenzene, SulfuricAcid, Water)
                .colorAverage()
                .build()

        DichlorobistriphenylphosphinenickelII = new Material.Builder(24051, SuSyUtility.susyId('dichlorobistriphenylphosphinenickel_ii'))
                .dust()
                .components(Nickel, Chlorine * 2, Triphenylphosphine * 2)
                .colorAverage()
                .build()

        DichlorobistriphenylphosphinenickelII.setFormula('NiCl2(PPh3)2', true)

        DicarbonylbistriphenylphosphinenickelZero = new Material.Builder(24052, SuSyUtility.susyId('dicarbonylbistriphenylphosphinenickel_zero'))
                .dust()
                .components(Nickel, Carbon * 2, Oxygen * 2, Triphenylphosphine * 2)
                .colorAverage()
                .build()

        DicarbonylbistriphenylphosphinenickelZero.setFormula('Ni(CO)2(PPh)2', true)

        SodiumPhenoxideSolution = new Material.Builder(24053, SuSyUtility.susyId('sodium_phenoxide_solution'))
                .liquid()
                .components(SodiumPhenoxide, Water)
                .colorAverage()
                .build()

        WetEpoxy = new Material.Builder(24054, SuSyUtility.susyId('wet_epoxy'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Epoxy)
                .color(0xa16f0d)
                .build()

        TetrabromobisphenolASolution = new Material.Builder(24055, SuSyUtility.susyId('tetrabromobisphenol_a_solution'))
                .liquid()
                .components(TetrabromobisphenolA, OneTwoDichloroethane * 6)
                .colorAverage()
                .build()

        EpoxyCuringMixture = new Material.Builder(24056, SuSyUtility.susyId('epoxy_curing_mixture'))
                .dust()
                .components(Dicyandiamide, TwoMethylimidazole, PhthalicAnhydride)
                .colorAverage()
                .build()

        WetFlameRetardantEpoxy = new Material.Builder(24057, SuSyUtility.susyId('wet_flame_retardant_epoxy'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(FlameRetardantEpoxy)
                .color(0xa1530b)
                .build()

        PropyleneOxideSolution = new Material.Builder(24058, SuSyUtility.susyId('propylene_oxide_solution'))
                .liquid()
                .components(CalciumChloride, PropyleneOxide * 2, Water * 2)
                .colorAverage()
                .build()

        OrthoParaXyleneMixture = new Material.Builder(24059, SuSyUtility.susyId('ortho_para_xylene_mixture'))
                .liquid()
                .components(OrthoXylene * 60, ParaXylene * 40)
                .colorAverage()
                .build()

        HydrogenSilsesquioxanePhotoresist = new Material.Builder(24060, SuSyUtility.susyId('hydrogen_silsesquioxane_photoresist'))
                .liquid()
                .components(HydrogenSilsesquioxane, MethylIsobutylKetone * 99)
                .colorAverage()
                .build()

        CrudeTerephthalicAcidSlurry = new Material.Builder(24061, SuSyUtility.susyId('crude_terephthalic_acid_slurry'))
                .liquid()
                .components(AmocoTerephthalicAcid, Water)
                .colorAverage()
                .build()

        CrudeIsophthalicAcidSlurry = new Material.Builder(24062, SuSyUtility.susyId('crude_isophthalic_acid_slurry'))
                .liquid()
                .components(AmocoIsophthalicAcid, Water)
                .colorAverage()
                .build()

        HydrogenatedTerephthalicAcidSlurry = new Material.Builder(24063, SuSyUtility.susyId('hydrogenated_terephthalic_acid_slurry'))
                .liquid()
                .components(TerephthalicAcid, Water)
                .colorAverage()
                .build()

        HydrogenatedIsophthalicAcidSlurry = new Material.Builder(24064, SuSyUtility.susyId('hydrogenated_isophthalic_acid_slurry'))
                .liquid()
                .components(IsophthalicAcid, Water)
                .colorAverage()
                .build()

        AmocoPurificationMotherLiquor = new Material.Builder(24065, SuSyUtility.susyId('amoco_purification_mother_liquor'))
                .liquid()
                .components(MethylParaToluate, Water * 100)
                .colorAverage()
                .build()

        ParaToluateMixture = new Material.Builder(24066, SuSyUtility.susyId('para_toluate_mixture'))
                .liquid(new FluidBuilder().temperature(540))
                .components(Carbon * 9, Hydrogen * 8, Oxygen * 4, ParaToluicAcid)
                .colorAverage()
                .build()

        ParaToluateMixture.setFormula("(C10H10O4)(C9H8O4)", true)

        CrudeDimethylTerephthalateSolution = new Material.Builder(24067, SuSyUtility.susyId('crude_dimethyl_terephthalate_solution'))
                .liquid()
                .components(CrudeDimethylTerephthalate, Methanol)
                .colorAverage()
                .build()

        TerephthalateMotherLiquor = new Material.Builder(24068, SuSyUtility.susyId('terephthalate_mother_liquor'))
                .liquid()
                .components(CrudeDimethylTerephthalate, Methanol * 2)
                .colorAverage()
                .build()

        MethylParaToluateMixture = new Material.Builder(24069, SuSyUtility.susyId('methyl_para_toluate_mixture'))
                .liquid(new FluidBuilder().temperature(540))
                .components(MethylParaToluate, DimethylTerephthalate)
                .colorAverage()
                .build()

        SodiumDodecylSulfateSolution = new Material.Builder(24070, SuSyUtility.susyId('sodium_dodecyl_sulfate_solution'))
                .liquid()
                .components(SodiumDodecylSulfate, Water * 2)
                .colorAverage()
                .build()

        SodiumCyclopentadienideSolution = new Material.Builder(24071, SuSyUtility.susyId('sodium_cyclopentadienide_solution'))
                .liquid()
                .components(Sodium, Carbon * 5, Hydrogen * 5, Tetrahydrofuran)
                .colorAverage()
                .build()

        SodiumCyclopentadienideSolution.setFormula("(NaC5H5)(C4H8O)", true)

        MethylcyclopentadieneSolution = new Material.Builder(24072, SuSyUtility.susyId('methylcyclopentadiene_solution'))
                .liquid()
                .components(Methylcyclopentadiene, Tetrahydrofuran, Salt * 2)
                .colorAverage()
                .build()

        BismethylcyclopentadienylmanganeseSolution = new Material.Builder(24073, SuSyUtility.susyId('bismethylcyclopentadienylmanganese_solution'))
                .liquid()
                .components(Bismethylcyclopentadienylmanganese, Diglyme, Salt * 2)
                .colorAverage()
                .build()

        DilutedNitromethane = new Material.Builder(24074, SuSyUtility.susyId('diluted_nitromethane'))
                .liquid()
                .components(Nitromethane * 3, Water)
                .colorAverage()
                .build()

        EthyleneVinylAcetateSuspension = new Material.Builder(24075, SuSyUtility.susyId('ethylene_vinyl_acetate_suspension'))
                .liquid()
                .components(EthyleneVinylAcetate, Methanol)
                .colorAverage()
                .build()

        EthyleneIsobutyleneVinylAcetateSuspension = new Material.Builder(24076, SuSyUtility.susyId('ethylene_isobutylene_vinyl_acetate_suspension'))
                .liquid()
                .components(EthyleneIsobutyleneVinylAcetate, Methanol)
                .colorAverage()
                .build()

        DewaxingSolvent = new Material.Builder(24077, SuSyUtility.susyId('dewaxing_solvent'))
                .liquid()
                .components(OneTwoDichloroethane, Dichloromethane)
                .colorAverage()
                .build()

        OlefinPolymerizationInitiator = new Material.Builder(24078, SuSyUtility.susyId('olefin_polymerization_initiator'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(NButanol, BoronTrifluoride * 3)
                .colorAverage()
                .build()

        TrimelliticAcidSlurry = new Material.Builder(24079, SuSyUtility.susyId('trimellitic_acid_slurry'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TrimelliticAcid, AceticAcid, Water)
                .colorAverage()
                .build()

        CalciumSalicylateSolution = new Material.Builder(24080, SuSyUtility.susyId('calcium_salicylate_solution'))
                .liquid()
                .components(CalciumSalicylate, DiethyleneGlycol)
                .colorAverage()
                .build()

        AcidicTricresylPhosphate = new Material.Builder(24081, SuSyUtility.susyId('acidic_tricresyl_phosphate'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TricresylPhosphate, HydrogenChloride * 3)
                .colorAverage()
                .build()

        ChloroaceticAcidSolution = new Material.Builder(24082, SuSyUtility.susyId('chloroacetic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroaceticAcid, SulfuricAcid * 2)
                .colorAverage()
                .build()

        OrthoPhenylenediamineSlurry = new Material.Builder(24083, SuSyUtility.susyId('ortho_phenylenediamine_slurry'))
                .liquid()
                .components(OrthoPhenylenediamine, Toluene, Water * 2)
                .colorAverage()
                .build()

        NomexPolymerizationMix = new Material.Builder(24085, SuSyUtility.susyId('nomex_polymerization_mix'))
                .liquid()
                .components(Nomex, CalciumChloride, Dimethylacetamide * 4)
                .colorAverage()
                .build()

        KevlarPolymerizationMix = new Material.Builder(24086, SuSyUtility.susyId('kevlar_polymerization_mix'))
                .liquid()
                .components(Kevlar, CalciumChloride, Dimethylacetamide * 4)
                .colorAverage()
                .build()

        SpentDimethylacetamide = new Material.Builder(24087, SuSyUtility.susyId('spent_dimethylacetamide'))
                .liquid()
                .components(CalciumChloride, Dimethylacetamide * 4)
                .colorAverage()
                .build()

        SodiumCelluloseXanthateSolution = new Material.Builder(24088, SuSyUtility.susyId('sodium_cellulose_xanthate_solution'))
                .liquid()
                .components(SodiumCelluloseXanthate, SodiumHydroxide, Water)
                .colorAverage()
                .build()

        CrotonaldehydeMixture = new Material.Builder(24089, SuSyUtility.susyId('crotonaldehyde_mixture'))
                .liquid()
                .components(SodiumHydroxide, Crotonaldehyde)
                .colorAverage()
                .build()

        GaseousMethacrylicAcidMixture = new Material.Builder(24090, SuSyUtility.susyId('gaseous_methacrylic_acid_mixture'))
                .gas(new FluidBuilder().temperature(434))
                .components(Carbon * 4, Hydrogen * 6, Oxygen, MethacrylicAcid * 3, Water * 4)
                .colorAverage()
                .build()

        GaseousMethacrylicAcidMixture.setFormula("(C4H6O)(C4H6O2)3(H2O)4", true)

        MethacrylicAcidSolution = new Material.Builder(24091, SuSyUtility.susyId('methacrylic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(MethacrylicAcid, Water)
                .colorAverage()
                .build()

        AcidicChlorodifluoromethane = new Material.Builder(24092, SuSyUtility.susyId('acidic_chlorodifluoromethane'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Chlorodifluoromethane, HydrogenChloride * 2)
                .color(0xbd97c7)
                .build()

        SaltyNMethylTwoPyrrolidone = new Material.Builder(24093, SuSyUtility.susyId('salty_n_methyl_two_pyrrolidone'))
                .liquid()
                .components(NMethylTwoPyrrolidone, Salt)
                .colorAverage()
                .build()

        DilutedNMethylTwoPyrrolidone = new Material.Builder(24094, SuSyUtility.susyId('diluted_n_methyl_two_pyrrolidone'))
                .liquid()
                .components(NMethylTwoPyrrolidone, Water)
                .colorAverage()
                .build()

        DilutedButyllithium = new Material.Builder(24095, SuSyUtility.susyId('diluted_butyllithium'))
                .liquid()
                .components(Butyllithium, DiethylEther)
                .colorAverage()
                .build()

        SpentPBISolution = new Material.Builder(24096, SuSyUtility.susyId('spent_pbi_solution'))
                .liquid()
                .components(Dimethylacetamide, LithiumChloride)
                .colorAverage()
                .build()

        OxalicAcidSolution = new Material.Builder(24097, SuSyUtility.susyId('oxalic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(OxalicAcid, Water)
                .colorAverage()
                .build()

        GalliumSulfateSolution = new Material.Builder(24098, SuSyUtility.susyId('gallium_sulfate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Gallium * 2, Sulfur * 3, Oxygen * 12, OxalicAcid * 6, Water * 3)
                .colorAverage()
                .build()

        GalliumSulfateSolution.setFormula("(Ga2(SO4)3)(H2C2O4)6(H2O)3", true)

        FormicAcidWaterAzeotrope = new Material.Builder(24099, SuSyUtility.susyId('formic_acid_water_azeotrope'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(FormicAcid * 6, Water * 4)
                .color(0xbf3983)
                .build()

        FurfuralSolution = new Material.Builder(24100, SuSyUtility.susyId('furfural_solution'))
                .liquid()
                .components(Furfural, Water)
                .colorAverage()
                .build()

        FourAminophenolSolution = new Material.Builder(24101, SuSyUtility.susyId('four_aminophenol_solution'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 7, Nitrogen, Oxygen, IsopropylAlcohol, Water * 2)
                .color(0xd9560b)
                .build()

        FourAminophenolSolution.setFormula('(C6H7NO)(C3H8O)(H2O)2', true)

        PhotographicEmulsion = new Material.Builder(24102, SuSyUtility.susyId('photographic_emulsion'))
                .liquid()
                .components(Gelatin, SilverNitrateSolution * 2, SodiumBromideSolution * 2)
                .colorAverage()
                .build()

        IsopropylamineSolution = new Material.Builder(24103, SuSyUtility.susyId('isopropylamine_solution'))
                .liquid()
                .components(Isopropylamine, Water)
                .colorAverage()
                .build()

        TributylPhosphateExtractionMixture = new Material.Builder(24104, SuSyUtility.susyId('tributyl_phosphate_extraction_mixture'))
                .liquid()
                .components(TributylPhosphate, Kerosene * 9)
                .colorAverage()
                .build()

        Aliquat336ExtractionMixture = new Material.Builder(24105, SuSyUtility.susyId('aliquat_336_extraction_mixture'))
                .liquid()
                .components(MethyltrioctylammoniumChloride, Xylene)
                .colorAverage()
                .build()

        PolyvinylAlcoholBinder = new Material.Builder(24106, SuSyUtility.susyId('polyvinyl_alcohol_binder'))
                .liquid()
                .components(PolyvinylAlcohol, Water)
                .colorAverage()
                .build()

        ActinideSeparationMixture = new Material.Builder(24107, SuSyUtility.susyId('actinide_separation_mixture'))
                .liquid()
                .components(TributylPhosphate * 3, Kerosene * 7)
                .color(0xa89e43)
                .build()

        HexamethylenetetramineSolution = new Material.Builder(24108, SuSyUtility.susyId('hexamethylenetetramine_solution'))
                .liquid()
                .components(Hexamethylenetetramine, Water * 4)
                .colorAverage()
                .build()

        CompositionB = new Material.Builder(24109, SuSyUtility.susyId('composition_b'))
                .dust()
                .components(RDX * 6, TNT * 4)
                .colorAverage()
                .build()

        Baratol = new Material.Builder(24110, SuSyUtility.susyId('baratol'))
                .dust()
                .components(TNT, BariumNitrate * 3)
                .colorAverage()
                .build()

        SodiumBisphenolateSolution = new Material.Builder(24111, SuSyUtility.susyId('sodium_bisphenolate_solution'))
                .liquid()
                .components(SodiumBisphenolate, Water * 2)
                .colorAverage()
                .build()

        PeekMixture = new Material.Builder(24112, SuSyUtility.susyId('peek_mixture'))
                .dust()
                .components(PolyetherEtherKetone, DiphenylSulfone)
                .colorAverage()
                .build()

        BisphenolADiimideSolution = new Material.Builder(24113, SuSyUtility.susyId('bisphenol_a_diimide_solution'))
                .liquid()
                .components(Carbon * 33, Hydrogen * 26, Oxygen * 6, Nitrogen * 2, NMethylTwoPyrrolidone)
                .colorAverage()
                .build()

        BisphenolADianhydrideSolution = new Material.Builder(24114, SuSyUtility.susyId('bisphenol_a_dianhydride_solution'))
                .liquid()
                .components(BisphenolADianhydride, Phthalimide * 2, NMethylTwoPyrrolidone)
                .colorAverage()
                .build()

        ImpureBisphenolADianhydride = new Material.Builder(24115, SuSyUtility.susyId('impure_bisphenol_a_dianhydride'))
                .dust().liquid(new FluidBuilder().temperature(510))
                .components(BisphenolADianhydride, Phthalimide * 2)
                .colorAverage()
                .build()

        PPOSolution = new Material.Builder(24116, SuSyUtility.susyId('ppo_solution'))
                .liquid()
                .components(PolyphenyleneOxide, Toluene)
                .color(0x395270)
                .build()

        VinylideneFluorideSurfactantMixture = new Material.Builder(24117, SuSyUtility.susyId('vinylidene_fluoride_surfactant_mixture'))
                .liquid()
                .components(PerfluorooctanoicAcid, LithiumHydroxide, Water)
                .colorAverage()
                .build()

        VitonSolution = new Material.Builder(24118, SuSyUtility.susyId('viton_solution'))
                .liquid()
                .components(Viton * 2, VinylideneFluorideSurfactantMixture)
                .color(0xbc716d)
                .build()

        DiphenylSulfoneSolution = new Material.Builder(24119, SuSyUtility.susyId('diphenyl_sulfone_solution'))
                .liquid()
                .components(DiphenylSulfone, Acetone)
                .colorAverage()
                .build()

        BenzenediolMixture = new Material.Builder(24120, SuSyUtility.susyId('benzenediol_mixture'))
                .dust().liquid(new FluidBuilder().temperature(445))
                .components(Hydroquinone * 2, Pyrocatechol * 3)
                .colorAverage()
                .build()

        BenzenediolSolution = new Material.Builder(24121, SuSyUtility.susyId('benzenediol_solution'))
                .liquid()
                .components(BenzenediolMixture, Phenol * 3)
                .colorAverage()
                .build()

        NitrotolueneMixture = new Material.Builder(24122, SuSyUtility.susyId('nitrotoluene_mixture'))
                .liquid()
                .components(ParaNitrotoluene, OrthoNitrotoluene * 2)
                .colorAverage()
                .build()

        CleavedParaDiisopropylbenzeneMixture = new Material.Builder(24123, SuSyUtility.susyId('cleaved_para_diisopropylbenzene_mixture'))
                .liquid()
                .components(SulfuricAcid, Hydroquinone * 5, Acetone * 10)
                .colorAverage()
                .build()

        PotassiumPhthalimideSolution = new Material.Builder(24124, SuSyUtility.susyId('potassium_phthalimide_solution'))
                .liquid()
                .components(PotassiumPhthalimide, Ethanol)
                .colorAverage()
                .build()

        NMethylPhthalimideSolution = new Material.Builder(24125, SuSyUtility.susyId('n_methyl_phthalimide_solution'))
                .liquid()
                .components(NMethylPhthalimide, Dimethylformamide)
                .colorAverage()
                .build()

        EthylenediamineSolution = new Material.Builder(24126, SuSyUtility.susyId('ethylenediamine_solution'))
                .liquid()
                .components(Ethylenediamine, Water)
                .color(0x2c6147)
                .build()

        XylenolSolution = new Material.Builder(24127, SuSyUtility.susyId('xylenol_solution'))
                .liquid()
                .components(Toluene, TwoSixXylenol)
                .color(0x4f301e)
                .build()

        FourFourDifluorobenzophenoneSolution = new Material.Builder(24128, SuSyUtility.susyId('four_four_difluorobenzophenone_solution'))
                .liquid()
                .components(FourFourDifluorobenzophenone, Hexane)
                .colorAverage()
                .build()

        PolyvinylideneFluorideSolution = new Material.Builder(24129, SuSyUtility.susyId('polyvinylidene_fluoride_solution'))
                .liquid()
                .components(PolyvinylideneFluoride * 2, VinylideneFluorideSurfactantMixture)
                .colorAverage()
                .build()

        AcidicNitrotolueneMixture = new Material.Builder(24130, SuSyUtility.susyId('acidic_nitrotoluene_mixture'))
                .liquid()
                .components(ParaNitrotoluene, OrthoNitrotoluene, DilutedSulfuricAcid)
                .colorAverage()
                .build()

        DiisopropylbenzeneMixture = new Material.Builder(24131, SuSyUtility.susyId('diisopropylbenzene_mixture'))
                .liquid()
                .components(ParaDiisopropylbenzene, MetaDiisopropylbenzene)
                .colorAverage()
                .build()

        FourNitroNMethylPhthalimideSolution = new Material.Builder(24132, SuSyUtility.susyId('four_nitro_n_methyl_phthalimide_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(FourNitroNMethylPhthalimide, SulfuricAcid, Water)
                .colorAverage()
                .build()

        PerfluorovinylSulfonylEtherSolution = new Material.Builder(24133, SuSyUtility.susyId('perfluorovinyl_sulfonyl_ether_solution'))
                .liquid()
                .components(PerfluorovinylSulfonylEther, Dimethylformamide * 2)
                .colorAverage()
                .build()

        NafionSolution = new Material.Builder(24134, SuSyUtility.susyId('nafion_solution'))
                .liquid()
                .components(Nafion * 2, FluorinatedSurfactantMixture)
                .colorAverage()
                .build()

        PolyacrylonitrileSolution = new Material.Builder(24135, SuSyUtility.susyId('polyacrylonitrile_solution'))
                .liquid()
                .components(Polyacrylonitrile, Dimethylformamide * 3)
                .colorAverage()
                .build()

        DichlorodiphenylSulfoneSolution = new Material.Builder(24136, SuSyUtility.susyId('dichlorodiphenyl_sulfone_solution'))
                .liquid()
                .components(DichlorodiphenylSulfone, DiethylSulfate * 2)
                .colorAverage()
                .build()

        FuelCellCatalystSolution = new Material.Builder(24137, SuSyUtility.susyId('fuel_cell_catalyst_solution'))
                .liquid()
                .components(PlatinumOnCarbon, Nafion, IsopropylAlcohol)
                .colorAverage()
                .build()

        PolytetrafluoroethyleneCoatingSolution = new Material.Builder(24138, SuSyUtility.susyId('polytetrafluoroethylene_coating_solution'))
                .liquid()
                .components(Polytetrafluoroethylene * 2, Cyclohexane)
                .colorAverage()
                .build()

        AcetanilideSolution = new Material.Builder(24139, SuSyUtility.susyId('acetanilide_solution'))
                .liquid()
                .components(Acetanilide, AceticAcid)
                .colorAverage()
                .build()

        GuanidiniumNitrateSolution = new Material.Builder(24140, SuSyUtility.susyId('guanidinium_nitrate_solution'))
                .liquid()
                .components(GuanidiniumNitrate, Water * 2)
                .colorAverage()
                .build()

        CrudeTrimethylOrthoformate = new Material.Builder(24141, SuSyUtility.susyId('crude_trimethyl_orthoformate'))
                .liquid()
                .components(TrimethylOrthoformate, Methanol)
                .colorAverage()
                .build()

        CrudeMethylVinylEther = new Material.Builder(24142, SuSyUtility.susyId('crude_methyl_vinyl_ether'))
                .liquid()
                .components(MethylVinylEther, Methanol, PotassiumHydroxide)
                .colorAverage()
                .build()
                
        TetrasodiumEthylenediaminetetraacetateSolution = new Material.Builder(24143, SuSyUtility.susyId('tetrasodium_ethylenediaminetetraacetate_solution'))
                .liquid()
                .components(TetrasodiumEthylenediaminetetraacetate, Water)
                .colorAverage()
                .build()

        OneNaphtholTwoDiazoniumChlorideSolution = new Material.Builder(24144, SuSyUtility.susyId('one_naphthol_two_diazonium_chloride_solution'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 8, Oxygen, Nitrogen * 2, Chlorine, Salt, Water * 4)
                .colorAverage()
                .build()

        OneNaphtholTwoDiazoniumChlorideSolution.setFormula('(C10H8ON2Cl)(NaCl)(H2O)4', true)

        AluminiumEtchant = new Material.Builder(24145, SuSyUtility.susyId('aluminium_etchant'))
                .liquid()
                .components(UltrapureWater, PhosphoricAcid * 12, NitricAcid * 2, AceticAcid * 35)
                .colorAverage()
                .build()

        BenzenediazoniumFluorideSolution = new Material.Builder(24146, SuSyUtility.susyId('benzenediazonium_fluoride_solution'))
                .liquid()
                .components(BenzenediazoniumFluoride, SodiumFluoride, Water * 4)
                .colorAverage()
                .build()

        IsopropylAlcoholSolution = new Material.Builder(24147, SuSyUtility.susyId('isopropyl_alcohol_solution'))
                .liquid()
                .components(IsopropylAlcohol, Water)
                .colorAverage()
                .build()

        KetoneAlcoholOil = new Material.Builder(24148, SuSyUtility.susyId('ketone_alcohol_oil'))
                .liquid()
                .components(Cyclohexanol * 7, Cyclohexanone * 2)
                .flags(FLAMMABLE)
                .colorAverage()
                .build()

        AcetyleneSolution = new Material.Builder(24149, SuSyUtility.susyId('acetylene_solution'))
                .liquid()
                .components(NMethylTwoPyrrolidone * 1, Acetylene * 1)
                .colorAverage()
                .build()

        BoronExtractionMixture = new Material.Builder(24150, SuSyUtility.susyId('boron_extraction_mixture'))
                .liquid()
                .components(TwoEthylOneThreeHexanediol, Kerosene)
                .colorAverage()
                .build()

        PolyhydroxystyreneSolution = genSolution(24151, 'polyhydroxystyrene_solution', Polyhydroxystyrene, Dimethylformamide, false)
        DiTertButylDicarbonateSolution = genSolution(24152, 'di_tert_butyl_dicarbonate_solution', DiTertButylDicarbonate, PotassiumChlorideSolution, false)
        ParaEthylbenzenesulfonicAcidSolution = genSolution(24153, 'para_ethylbenzenesulfonic_acid_solution', ParaEthylbenzenesulfonicAcid, Water, true)
        PropyleneGlycolMethylEtherAcetateSolution = genSolution(24154, 'propylene_glycol_methyl_ether_acetate_solution', PropyleneGlycolMethylEtherAcetate, Water, false)
        EthylLactateSolution = genSolution(24155, 'ethyl_lactate_solution', EthylLactate, Water, false)
        BisAzideCrosslinkerSolution = genSolution(24156, 'bis_azide_crosslinker_solution', BisAzideCrosslinker, Water, false)
        ParaAzidobenzaldehydeSolution = genSolution(24157, 'para_azidobenzaldehyde_solution', ParaAzidobenzaldehyde, SaltWater, false)
        NaphthalenedisulfonicAcidSolution = genSolution(24158, 'naphthalenedisulfonic_acid_solution', Naphthalene, Oleum, true)
        SodiumNaphtholSulfonateSolution = genSolution(24159, "sodium_naphthol_sulfonate_solution", SodiumOneNaphtholFiveSulfonate, Water, false)
        GallicAcidSolution = genSolution(24166, 'gallic_acid_solution', GallicAcid, Water, true)

        StyreneAnthracenylMaleimideSolution = new Material.Builder(24167, SuSyUtility.susyId('styrene_anthracenyl_maleimide_solution'))
                .liquid()
                .components(StyreneAnthracenylMaleimide, Water, Dimethylformamide)
                .colorAverage()
                .build()

        ProtectedPolyhydroxystyreneSolution = new Material.Builder(24168, SuSyUtility.susyId('protected_polyhydroxystyrene_solution'))
                .liquid()
                .components(ProtectedPolyhydroxystyrene, Tetrahydrofuran, Pyridine)
                .colorAverage()
                .build()

        AcrylateResistMixture = new Material.Builder(24169, SuSyUtility.susyId('acrylate_resist_mixture'))
                .liquid()
                .components(MichlersKetone, PolymethylMethacrylate, TrimethylolpropaneTriacrylate, Butanone)
                .color(0x5794d1)
                .build()

        DimethylanilineSolution = new Material.Builder(24170, SuSyUtility.susyId('dimethylaniline_solution'))
                .liquid()
                .components(Dimethylaniline, Water * 2, SulfuricAcid)
                .colorAverage()
                .build()

        NovolacLiftoffResist = new Material.Builder(24171, SuSyUtility.susyId('novolac_liftoff_resist'))
                .liquid()
                .components(PhenolicNovolacsResin, EthylLactate, PropyleneGlycolMethylEtherAcetate, BisAzideCrosslinker)
                .colorAverage()
                .build()

        ParaDiazoBenzaldehydeChlorideSolution = new Material.Builder(24172, SuSyUtility.susyId('para_diazobenzaldehyde_chloride_solution'))
                .liquid()
                .components(Carbon * 7, Nitrogen * 2, Hydrogen * 5, Oxygen * 1, Chlorine, Water * 8)
                .color(0xad9d58)
                .build()

        ParaDiazoBenzaldehydeChlorideSolution.setFormula("ClC7H5N2O", true)

        NovolacEBRSolvent = new Material.Builder(24173, SuSyUtility.susyId('novolac_ebr_solvent'))
                .liquid()
                .components(PropyleneGlycolMethylEther * 7, PropyleneGlycolMethylEtherAcetate * 3)
                .colorAverage()
                .build()

        DiazonaphthoquinoneFiveSulfonateEsterSolution = new Material.Builder(24174, SuSyUtility.susyId('diazonaphthoquinone_five_sulfonate_ester_solution'))
                .liquid()
                .components(DiazonaphthoquinoneFiveSulfonateEster, Acetone)
                .colorAverage()
                .build()

        NovolacResist = new Material.Builder(24175, SuSyUtility.susyId('novolac_resist'))
                .liquid()
                .components(DiazonaphthoquinoneFiveSulfonateEster * 10, PropyleneGlycolMethylEtherAcetate * 88, EthylLactate * 49, PhenolicNovolacsResin * 63)
                .colorAverage()
                .build()

        MethanesulfonicAcidSolution = new Material.Builder(24176, SuSyUtility.susyId('methanesulfonic_acid_solution'))
                .liquid()
                .components(MethanesulfonicAcid, Water)
                .colorAverage()
                .build()

        HexamethyldisilazaneSolution = genSolution(24177, "hexamethyldisilazane_solution", Hexamethyldisilazane, Hexane, false)

        PolyhydroxystyreneResist = new Material.Builder(24178, SuSyUtility.susyId('polyhydroxystyrene_resist'))
                .liquid()
                .components(ProtectedPolyhydroxystyrene, TriphenylsulfoniumTriflate, PropyleneGlycolMethylEtherAcetateSolution * 3, PropyleneGlycolMethylEtherAcetate, Triethanolamine)
                .colorAverage()
                .build()

        StyreneMaleicAnhydrideSolution = new Material.Builder(24179, SuSyUtility.susyId('styrene_maleic_anhydride_solution'))
                .liquid()
                .components(Azobisisobutyronitrile, MaleicAnhydride, Styrene, Dimethylformamide)
                .colorAverage()
                .build()

        AcidicParaTertButylnitrobenzeneMixture = new Material.Builder(24180, SuSyUtility.susyId('acidic_para_tert_butylnitrobenzene_mixture'))
                .liquid()
                .components(TertButylbenzene, NitrationMixture)
                .colorAverage()
                .build()

        ParaTertButylnitrobenzeneMixture = new Material.Builder(24181, SuSyUtility.susyId('para_tert_butylnitrobenzene_mixture'))
                .liquid()
                .components(TertButylbenzene, NitricAcid)
                .colorAverage()
                .build()

        ParaTertbutyliodobenzeneSolution = new Material.Builder(24182, SuSyUtility.susyId('para_tertbutyliodobenzene_solution'))
                .liquid()
                .components(ParaTertButylaniline, PotassiumIodide, SodiumNitrite, HydrochloricAcid)
                .colorAverage()
                .build()

        AllylAlcoholSolution = new Material.Builder(24183, SuSyUtility.susyId('allyl_alcohol_solution'))
                .liquid()
                .components(AllylAlcohol, Salt, Water)
                .colorAverage()
                .build()

        BisSulfopropylDisulfideSolution = genSolution(24184, "bis_sulfopropyl_disulfide_solution", BisSodiumSulfopropylDisulfide, Water, false)
        PropaneOneThreeSultoneSolution = genSolution(24185, "propane_one_three_sultone_solution", PropaneOneThreeSultone, Water, false)
        NonaflicAcidSolution = genSolution(24186, "nonaflic_acid_solution", NonaflicAcid, HydrofluoricAcid, true)

        KrFBottomAntireflectiveCoating = new Material.Builder(24187, SuSyUtility.susyId('krf_barc'))
                .liquid()
                .components(StyreneAnthracenylMaleimide, TripropylamineTriflate, Hexamethoxymethylmelamine, PropyleneGlycolMethylEtherAcetate)
                .colorAverage()
                .build()

        ParaAminobenzaldehydeSolution = genSolution(24188, "para_aminobenzaldehyde_solution", ParaAminobenzaldehyde, Water, false)
        
        TwoMethylTwoAdamantanolSolution = new Material.Builder(24189, SuSyUtility.susyId('two_methyl_two_adamantanol_solution'))
                .liquid()
                .components(TwoMethylTwoAdamantanol * 5, MagnesiumChlorideSolution * 2, Tetrahydrofuran * 3)
                .colorAverage()
                .build()

        OxidizedTwoEthylanthraquinoneSolution = new Material.Builder(24190, SuSyUtility.susyId('oxidized_two_ethylanthraquinone_solution'))
                .liquid()
                .components(TwoEthylanthraquinone, HydrogenPeroxide, TrisTwoEthylhexylPhosphate, Xylene)
                .colorAverage()
                .build()

        ButyraldolSolution = new Material.Builder(24191, SuSyUtility.susyId('butyraldol_solution'))
                .liquid()
                .components(Butyraldol, SodiumHydroxide, Water)
                .colorAverage()
                .build()

        LithiumDiisopropylamideSolution = new Material.Builder(24192, SuSyUtility.susyId('lithium_diisopropylamide_solution'))
                .liquid()
                .components(Lithium, Carbon * 6, Hydrogen * 14, Nitrogen, Tetrahydrofuran * 3)
                .color(0xa2e0df)
                .build()

        LithiumDiisopropylamideSolution.setFormula('(C6H14NLi)(C4H8O)3', true)

        TritonXOneHundredSolution = new Material.Builder(24193, SuSyUtility.susyId('triton_x_one_hundred_solution'))
                .liquid()
                .components(TritonXOneHundred * 2, SodiumHydroxide * 2, Water * 2, EthyleneOxide)
                .colorAverage()
                .build()

        TwoAminoethylHydrogenSulfateSolution = new Material.Builder(24194, SuSyUtility.susyId('two_aminoethyl_hydrogen_sulfate_solution'))
                .liquid()
                .components(Ethanolamine, SulfuricAcid, Water)
                .colorAverage()
                .build()

        TwoAminoethylHydrogenSulfateSolution.setFormula('(C2H8NSO3)(H2O)', true)

        PolyvinylpyrrolidoneSolution = new Material.Builder(24195, SuSyUtility.susyId('polyvinylpyrrolidone_solution'))
                .liquid()
                .components(Polyvinylpyrrolidone, Water)
                .colorAverage()
                .build()

        PolyethylenimineSolution = new Material.Builder(24196, SuSyUtility.susyId('polyethylenimine_solution'))
                .liquid()
                .components(Polyethylenimine, SulfuricAcid, Water)
                .colorAverage()
                .build()

        PolyethyleneGlycolSolution = new Material.Builder(24197, SuSyUtility.susyId('polyethylene_glycol_solution'))
                .liquid()
                .components(PolyethyleneGlycol, SodiumHydroxide, Water)
                .colorAverage()
                .build()

        NeutralizedPolyethyleneGlycolSolution = new Material.Builder(24198, SuSyUtility.susyId('neutralized_polyethylene_glycol_solution'))
                .liquid()
                .components(PolyethyleneGlycol, DisodiumPhosphate, Water * 2)
                .colorAverage()
                .build()

        DisproportionatedTolueneMixture = new Material.Builder(24199, SuSyUtility.susyId('disproportionated_toluene_mixture'))
                .liquid()
                .components(Toluene * 2, Benzene, Xylene)
                .colorAverage()
                .build()

        DimethoxymethaneSolution = new Material.Builder(24200, SuSyUtility.susyId('dimethoxymethane_solution'))
                .liquid()
                .components(Dimethoxymethane, SulfuricAcid, Water)
                .colorAverage()
                .build()

        DilutedTwoPyrrolidone = new Material.Builder(24201, SuSyUtility.susyId('diluted_two_pyrrolidone'))
                .liquid()
                .components(TwoPyrrolidone, Water * 2)
                .colorAverage()
                .build()

        NMethylTwoPyrrolidoneSolution = new Material.Builder(24202, SuSyUtility.susyId('n_methyl_two_pyrrolidone_solution'))
                .liquid()
                .components(NMethylTwoPyrrolidone, Water * 2)
                .colorAverage()
                .build()

        PolysulfoneSolution = new Material.Builder(24203, SuSyUtility.susyId('polysulfone_solution'))
                .liquid()
                .components(Polysulfone, NMethylTwoPyrrolidone)
                .build()

        EthylenimineSolution = new Material.Builder(24204, SuSyUtility.susyId('ethylenimine_solution'))
                .liquid()
                .components(Ethylenimine, SodiumSulfate, Water * 2)
                .colorAverage()
                .build()

        FluorinatedMethanesulfonicAcidMixture = genSolution(24205, 'fluorinated_methanesulfonic_acid_mixture', MethanesulfonicAcid, HydrogenFluoride, true)
        
        SodiumTriflateSolution = new Material.Builder(24206, SuSyUtility.susyId('sodium_triflate_solution'))
                .liquid()
                .components(SodiumTriflate, Water)
                .colorAverage()
                .build()

        TriflicAcidSolution = new Material.Builder(24207, SuSyUtility.susyId('triflic_acid_solution'))
                .liquid()
                .components(TriflicAcid, Water)
                .colorAverage()
                .build()

        LacticAcidSolution = new Material.Builder(24208, SuSyUtility.susyId('lactic_acid_solution'))
                .liquid()
                .components(LacticAcid, Water)
                .colorAverage()
                .build()

        TwoEthylOneThreeHexanediolMixture = genSolution(24209, "two_ethyl_one_three_hexanediol_mixture", TwoEthylOneThreeHexanediol, Water, false)

        TwoEthylanthrahydroquinoneSolution = new Material.Builder(24210, SuSyUtility.susyId('two_ethylanthrahydroquinone_solution'))
                .liquid()
                .components(TwoEthylanthraquinone, Hydrogen * 2, TrisTwoEthylhexylPhosphate, Xylene)
                .colorAverage()
                .build()

        TwoEthylanthrahydroquinoneSolution.setFormula('(C16H14O2)(C8H17O4P)(C8H18O4P)', true)

        TwoNitrosoOneNaphtholFiveSulfonicAcidSolution = new Material.Builder(24211, SuSyUtility.susyId('two_nitroso_one_naphthol_five_sulfonic_acid_solution'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 6, Nitrogen, Oxygen * 5, Sulfur, SodiumBisulfateSolution, Water)
                .color(0x5a878c)
                .build()

        TwoNitrosoOneNaphtholFiveSulfonicAcidSolution.setFormula('(C10H6NO5S)(NaHSO4)(H2O)2', true)

        TwoAminoOneNaphthalenoneFiveSulfonicAcidSolution = new Material.Builder(24212, SuSyUtility.susyId('two_amino_one_naphthalenone_five_sulfonic_acid_solution'))
                .liquid()
                .components(Carbon * 20, Hydrogen * 16, Nitrogen * 4, Oxygen * 8, Sulfur * 2, SodiumThiosulfate, SodiumBisulfateSolution * 4, Water)
                .colorAverage()
                .build()

        TwoAminoOneNaphthalenoneFiveSulfonicAcidSolution.setFormula('(C10H8N2SO4)2(Na2S2O3)(NaHSO4)4(H2O)5', true)

        DiazonaphthoquinoneFiveSulfonicAcidSolution = new Material.Builder(24213, SuSyUtility.susyId('diazonaphthoquinone_five_sulfonic_acid_solution'))
                .liquid()
                .components(DiazonaphthoquinoneFiveSulfonicAcid * 2, SodiumThiosulfate, SodiumBisulfateSolution * 4, Water * 5)
                .colorAverage()
                .build()

        DiazonaphthoquinoneFiveSulfonicAcidSolution.setFormula('(?)(C10H7N3O5S)2(Na2S2O3)(NaHSO4)4(H2O)5', true)

        PotassiumTertButoxideSolution = genSolution(24214, 'potassium_tert_butoxide_solution', PotassiumTertButoxide, TertButanol, false)

        LithiumDimethylamideSolution = new Material.Builder(24215, SuSyUtility.susyId('lithium_dimethylamide_solution'))
                .liquid()
                .components(Lithium, Carbon * 2, Hydrogen * 6, Nitrogen, DiethylEther)
                .color(0x8fd4e0)
                .build()

        LithiumDimethylamideSolution.setFormula('(LiN(CH3)2)(C4H10O)', true)

        TetrakisDimethylamidoHafniumSolution = new Material.Builder(24216, SuSyUtility.susyId('tetrakis_dimethylamido_hafnium_solution'))
                .liquid()
                .components(Hafnium, Nitrogen * 4, Carbon * 8, Hydrogen * 24, DiethylEther * 4)
                .color(0xe0c97a)
                .build()

        TetrakisDimethylamidoHafniumSolution.setFormula('(Hf(N(CH3)2)4)(C4H10O)4', true)

        LithiumAluminiumHydrideSolution = new Material.Builder(24217, SuSyUtility.susyId('lithium_aluminium_hydride_solution'))
                .liquid()
                .components(Lithium, Aluminium, Hydrogen * 4, DiethylEther)
                .color(0xd4d4b8)
                .build()

        LithiumAluminiumHydrideSolution.setFormula('(LiAlH4)(C4H10O)', true)

        GuanidiniumChlorideSolution = genSolution(24218, 'guanidinium_chloride_solution', GuanidiniumChloride, Water, false)

        TetrafluoroethaneMixture = new Material.Builder(24219, SuSyUtility.susyId('tetrafluoroethane_mixture'))
                .gas()
                .components(Tetrafluoroethane * 4, HydrogenChloride * 3)
                .colorAverage()
                .build()
        }
}
