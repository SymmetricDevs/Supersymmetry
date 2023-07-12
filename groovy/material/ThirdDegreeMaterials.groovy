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

public class ThirdDegreeMaterials {
    public static void register() {

        log.infoMC("Registering Third Degree Materials!");

        DiethylEtherSolution = new Material.Builder(24000, GTUtility.gregtechId('diethyl_ether_solution'))
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        LithiumSolution = new Material.Builder(24001, GTUtility.gregtechId('lithium_solution'))
                .fluid()
                .components(Lithium, 2, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        DimethylacetamideSolution = new Material.Builder(24002, GTUtility.gregtechId('dimethylacetamide_solution'))
                .fluid()
                .components(Water, 1, Dimethylacetamide, 1)
                .colorAverage()
                .build();

        FurfuralSolution = new Material.Builder(24003, GTUtility.gregtechId("furfural_solution"))
                .fluid()
                .components(Water, 3, SulfuricAcid, 1, Furfural, 1)
                .colorAverage()
                .build();

        WackerCatalystSolution = new Material.Builder(24004, GTUtility.gregtechId("wacker_catalyst_solution"))
                .fluid()
                .components(Water, 1, WackerCatalyst, 1)
                .colorAverage()
                .build();

        TwoEthylanthraquinoneSolution = new Material.Builder(24005, GTUtility.gregtechId("two_ethylanthraquinone_solution"))
                .fluid()
                .components(TwoEthylanthraquinone, 1, HydrogenPeroxide, 3)
                .colorAverage()
                .build();

        AcetamideSolution = new Material.Builder(24006, GTUtility.gregtechId("acetamide_solution"))
                .fluid()
                .components(Butanone, 1, Acetamide, 1)
                .colorAverage()
                .build();

        HydrazineSolution = new Material.Builder(24007, GTUtility.gregtechId("hydrazine_solution"))
                .fluid()
                .components(Water, 4, Hydrazine, 1, Ammonia, 2)
                .colorAverage()
                .build();

        EthylenediamineSolution = new Material.Builder(24008, GTUtility.gregtechId('ethylenediamine_solution'))
                .fluid()
                .components(Ethylenediamine, 1, HydrogenChloride, 1)
                .colorAverage()
                .build()

        DeacidifiedEthylenediamine = new Material.Builder(24009, GTUtility.gregtechId('deacidified_ethylenediamine'))
                .fluid()
                .components(Ethylenediamine, 1, Water, 2, Salt, 1)
                .colorAverage()
                .build()

        EthylenediaminetetraaceticAcidSolution = new Material.Builder(24010, GTUtility.gregtechId('ethylenediaminetetraacetic_acid_solution'))
                .fluid()
                .components(Water, 1, EthylenediaminetetraaceticAcid, 1)
                .colorAverage()
                .build()

        TetrasodiumEthylenediaminetetraaceticAcidSolution = new Material.Builder(24011, GTUtility.gregtechId('tetrasodium_ethylenediaminetetraacetic_acid_solution'))
                .fluid()
                .components(SaltWater, 1, TetrasodiumEthylenediaminetetraaceticAcid, 1)
                .colorAverage()
                .build()

        UreaSolution = new Material.Builder(24012, GTUtility.gregtechId('urea_solution'))
                .fluid()
                .components(Water, 1, Urea, 1)
                .colorAverage()
                .build()

        DiiodobenzeneSolution = new Material.Builder(24013, GTUtility.gregtechId('diiodobenzene_solution'))
                .fluid()
                .components(Ethanol, 1, Diiodobenzene, 1)
                .colorAverage()
                .build()

        ImpureFourFourOxydianiline = new Material.Builder(24014, GTUtility.gregtechId('impure_four_four_oxydianiline'))
                .fluid()
                .components(Ethanol, 2, Water, 5, FourFourOxydianiline, 1, AmmoniumIodide, 4)
                .colorAverage()
                .build()

        EthyleneGlycolSolution = new Material.Builder(24015, GTUtility.gregtechId('ethylene_glycol_solution'))
                .fluid()
                .components(EthyleneGlycol, 1, Water, 2, SodiumHydroxide, 3)
                .colorAverage()
                .build()

        TerephthalicAcidSolution = new Material.Builder(24016, GTUtility.gregtechId('terephthalic_acid_solution'))
                .fluid()
                .components(AceticAcid, 1, Water, 1, TerephthalicAcid, 1)
                .colorAverage()
                .build()

        CelluloseAcetateSolution = new Material.Builder(24017, GTUtility.gregtechId('cellulose_acetate_solution'))
                .fluid()
                .components(Acetone, 1, CelluloseAcetate, 1)
                .colorAverage()
                .build()

        TwoButanolSolution = new Material.Builder(24018, GTUtility.gregtechId('two_butanol_solution'))
                .fluid()
                .components(SulfuricAcid, 1, TwoButanol, 1)
                .colorAverage()
                .build()

        FourFourOxydianilineSolution = new Material.Builder(24019, GTUtility.gregtechId('four_four_oxydianiline_solution'))
                .fluid()
                .components(Water, 5, FourFourOxydianiline, 1)
                .colorAverage()
                .build()

        DiglycolicAcidSolution = new Material.Builder(24020, GTUtility.gregtechId('diglycolic_acid_solution'))
                .fluid()
                .components(DiglycolicAcid, 1, AmmoniaSolution, 1, Ethanol, 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcidSolution = new Material.Builder(24021, GTUtility.gregtechId('di_two_ethylhexyl_phosphoric_acid_solution'))
                .fluid()
                .components(DiTwoEthylhexylPhosphoricAcid, 1, Hexane, 1)
                .colorAverage()
                .build()

        DilutedChloroaceticAnhydride = new Material.Builder(24022, GTUtility.gregtechId("diluted_chloroacetic_anhydride"))
                .fluid()
                .components(ChloroaceticAnhydride, 1, Pyridine, 1, Water, 1)
                .colorAverage()
                .build()

        DilutedTetraoctylDiglycolamide = new Material.Builder(24023, GTUtility.gregtechId("diluted_tetraoctyl_diglycolamide"))
                .fluid()
                .components(TetraoctylDiglycolamide, 1, SaltWater, 2)
                .colorAverage()
                .build()

        DilutedTwoEthylTwoHexenal = new Material.Builder(24024, GTUtility.gregtechId("diluted_two_ethyl_two_hexenal"))
                .fluid()
                .components(TwoEthylTwoHexenal, 1, DilutedSodiumHydroxideSolution, 1)
                .colorAverage()
                .build()

        DilutedOctylamine = new Material.Builder(24025, GTUtility.gregtechId('diluted_octylamine'))
                .fluid()
                .components(NOctylamine, 1, Water, 1)
                .colorAverage()
                .build()

        DilutedMethylIsobutylKetone = new Material.Builder(24026, GTUtility.gregtechId('diluted_methyl_isobutyl_ketone'))
                .fluid()
                .components(MethylIsobutylKetone, 1, Water, 1)
                .colorAverage()
                .build()

        ChlorinatedBeryl = new Material.Builder(24027, GTUtility.gregtechId("chlorinated_beryl"))
                .fluid(FluidTypes.GAS)
                .fluidTemp(1100)
                .components(BerylliumChloride, 3, AluminiumChloride, 2, SiliconTetrachloride, 6, CarbonMonoxide, 18)
                .colorAverage()
                .build();

        HydratedMagnesiumChlorideGlycolate = new Material.Builder(24028, GTUtility.gregtechId("hydrated_magnesium_chloride_glycolate"))
                .fluid()
                .components(MagnesiumChloride, 1, Water, 2, EthyleneGlycol, 3)
                .colorAverage()
                .build();

        MagnesiumChlorideGlycolate = new Material.Builder(24029, GTUtility.gregtechId("magnesium_chloride_glycolate"))
                .fluid()
                .components(MagnesiumChloride, 1, EthyleneGlycol, 3)
                .colorAverage()
                .build();

        DilutedDiisopropylamine = new Material.Builder(24030, GTUtility.gregtechId('diluted_diisopropylamine'))
                .fluid()
                .components(Diisopropylamine, 1, Water, 2)
                .colorAverage()
                .build()

        PerfluorooctanoicAcidMixture = new Material.Builder(24031, GTUtility.gregtechId('perfluorooctanoic_acid_mixture'))
                .fluid()
                .components(PerfluorooctanoicAcid, 1, HydrofluoricAcid, 1)
                .colorAverage()
                .build()

        FluorinatedSurfactantMixture = new Material.Builder(24032, GTUtility.gregtechId("fluorinated_surfactant_mixture"))
                .fluid()
                .components(PerfluorooctanoicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumEthylXanthateSolution = new Material.Builder(24033, GTUtility.gregtechId("sodium_ethyl_xanthate_solution"))
                .fluid()
                .components(SodiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumAmylXanthateSolution = new Material.Builder(24034, GTUtility.gregtechId("potassium_amyl_xanthate_solution"))
                .fluid()
                .components(PotassiumAmylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumIsobutylXanthateSolution = new Material.Builder(24035, GTUtility.gregtechId("sodium_isobutyl_xanthate_solution"))
                .fluid()
                .components(SodiumIsobutylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumIsopropylXanthateSolution = new Material.Builder(24036, GTUtility.gregtechId("potassium_isopropyl_xanthate_solution"))
                .fluid()
                .components(PotassiumIsopropylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumEthylXanthateSolution = new Material.Builder(24037, GTUtility.gregtechId("potassium_ethyl_xanthate_solution"))
                .fluid()
                .components(PotassiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        AcidicTributylPhosphate = new Material.Builder(24038, GTUtility.gregtechId("acidic_tributyl_phosphate"))
                .fluid()
                .components(TributylPhosphate, 1, HydrogenChloride, 3)
                .colorAverage()
                .build();

        PhosgeneSolution = new Material.Builder(24039, GTUtility.gregtechId("phosgene_solution"))
                .fluid()
                .components(Phosgene, 1, Dichloromethane, 1)
                .colorAverage()
                .build();

        TriethylamineSolution = new Material.Builder(24040, GTUtility.gregtechId("triethylamine_solution"))
                .fluid()
                .components(Triethylamine, 1, Dichloromethane, 4)
                .colorAverage()
                .build();

        KaminskyCatalyst = new Material.Builder(24041, GTUtility.gregtechId("kaminsky_catalyst"))
                .dust()
                .components(ZirconoceneDichloride, 1, Methylaluminoxane, 1)
                .colorAverage()
                .build();

        ZirconiumTetrachlorideTetrahydrofuranComplex = new Material.Builder(24042, GTUtility.gregtechId("zirconium_tetrachloride_tetrahydrofuran_complex"))
                .dust()
                .components(ZirconiumTetrachloride, 1, Tetrahydrofuran, 2)
                .colorAverage()
                .build();

        PotassiumButylXanthateSolution = new Material.Builder(24043, GTUtility.gregtechId("potassium_butyl_xanthate_solution"))
                .fluid()
                .components(PotassiumButylXanthate, 1, Water, 1)
                .colorAverage()
                .build();
    }
}