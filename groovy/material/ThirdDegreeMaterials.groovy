package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class ThirdDegreeMaterials {
    public static void register() {

        log.infoMC("Registering Third Degree Materials!");

        DiethylEtherSolution = new Material.Builder(24000, 'diethyl_ether_solution')
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        LithiumSolution = new Material.Builder(24001, 'lithium_solution')
                .fluid()
                .components(Lithium, 2, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        DimethylacetamideSolution = new Material.Builder(24002, 'dimethylacetamide_solution')
                .fluid()
                .components(Water, 1, Dimethylacetamide, 1)
                .colorAverage()
                .build();

        FurfuralSolution = new Material.Builder(24003, "furfural_solution")
                .fluid()
                .components(Water, 3, SulfuricAcid, 1, Furfural, 1)
                .colorAverage()
                .build();

        WackerCatalystSolution = new Material.Builder(24004, "wacker_catalyst_solution")
                .fluid()
                .components(Water, 1, WackerCatalyst, 1)
                .colorAverage()
                .build();

        TwoEthylanthraquinoneSolution = new Material.Builder(24005, "two_ethylanthraquinone_solution")
                .fluid()
                .components(TwoEthylanthraquinone, 1, HydrogenPeroxide, 3)
                .colorAverage()
                .build();

        AcetamideSolution = new Material.Builder(24006, "acetamide_solution")
                .fluid()
                .components(Butanone, 1, Acetamide, 1)
                .colorAverage()
                .build();

        HydrazineSolution = new Material.Builder(24007, "hydrazine_solution")
                .fluid()
                .components(Water, 4, Hydrazine, 1, Ammonia, 2)
                .colorAverage()
                .build();

        EthylenediamineSolution = new Material.Builder(24008, 'ethylenediamine_solution')
                .fluid()
                .components(Ethylenediamine, 1, HydrogenChloride, 1)
                .colorAverage()
                .build()

        DeacidifiedEthylenediamine = new Material.Builder(24009, 'deacidified_ethylenediamine')
                .fluid()
                .components(Ethylenediamine, 1, Water, 2, Salt, 1)
                .colorAverage()
                .build()

        EthylenediaminetetraaceticAcidSolution = new Material.Builder(24010, 'ethylenediaminetetraacetic_acid_solution')
                .fluid()
                .components(Water, 1, EthylenediaminetetraaceticAcid, 1)
                .colorAverage()
                .build()

        TetrasodiumEthylenediaminetetraaceticAcidSolution = new Material.Builder(24011, 'tetrasodium_ethylenediaminetetraacetic_acid_solution')
                .fluid()
                .components(SaltWater, 1, TetrasodiumEthylenediaminetetraaceticAcid, 1)
                .colorAverage()
                .build()

        UreaSolution = new Material.Builder(24012, 'urea_solution')
                .fluid()
                .components(Water, 1, Urea, 1)
                .colorAverage()
                .build()

        DiiodobenzeneSolution = new Material.Builder(24013, 'diiodobenzene_solution')
                .fluid()
                .components(Ethanol, 1, Diiodobenzene, 1)
                .colorAverage()
                .build()

        ImpureFourFourOxydianiline = new Material.Builder(24014, 'impure_four_four_oxydianiline')
                .fluid()
                .components(Ethanol, 2, Water, 5, FourFourOxydianiline, 1, AmmoniumIodide, 4)
                .colorAverage()
                .build()

        EthyleneGlycolSolution = new Material.Builder(24015, 'ethylene_glycol_solution')
                .fluid()
                .components(EthyleneGlycol, 1, Water, 2, SodiumHydroxide, 3)
                .colorAverage()
                .build()

        TerephthalicAcidSolution = new Material.Builder(24016, 'terephthalic_acid_solution')
                .fluid()
                .components(AceticAcid, 1, Water, 1, TerephthalicAcid, 1)
                .colorAverage()
                .build()

        CelluloseAcetateSolution = new Material.Builder(24017, 'cellulose_acetate_solution')
                .fluid()
                .components(Acetone, 1, CelluloseAcetate, 1)
                .colorAverage()
                .build()

        TwoButanolSolution = new Material.Builder(24018, 'two_butanol_solution')
                .fluid()
                .components(SulfuricAcid, 1, TwoButanol, 1)
                .colorAverage()
                .build()

        FourFourOxydianilineSolution = new Material.Builder(24019, 'four_four_oxydianiline_solution')
                .fluid()
                .components(Water, 5, FourFourOxydianiline, 1)
                .colorAverage()
                .build()

        DiglycolicAcidSolution = new Material.Builder(24020, 'diglycolic_acid_solution')
                .fluid()
                .components(DiglycolicAcid, 1, AmmoniaSolution, 1, Ethanol, 1)
                .colorAverage()
                .build()

        DiTwoEthylhexylPhosphoricAcidSolution = new Material.Builder(24021, 'di_two_ethylhexyl_phosphoric_acid_solution')
                .fluid()
                .components(DiTwoEthylhexylPhosphoricAcid, 1, Hexane, 1)
                .colorAverage()
                .build()

        DilutedChloroaceticAnhydride = new Material.Builder(24022, "diluted_chloroacetic_anhydride")
                .fluid()
                .components(ChloroaceticAnhydride, 1, Pyridine, 1, Water, 1)
                .colorAverage()
                .build()

        ZirconiumTetrachlorideTetrahydrofuranComplex = new Material.Builder(24023, "zirconium_tetrachloride_tetrahydrofuran_complex")
                .dust()
                .components(ZirconiumTetrachloride, 1, Tetrahydrofuran, 2)
                .colorAverage()
                .build();

        DilutedTwoEthylTwoHexenal = new Material.Builder(24024, "diluted_two_ethyl_two_hexenal")
                .fluid()
                .components(TwoEthylTwoHexenal, 1, DilutedSodiumHydroxideSolution, 1)
                .colorAverage()
                .build()

        PotassiumButylXanthateSolution = new Material.Builder(24025, "potassium_butyl_xanthate_solution")
                .fluid()
                .components(PotassiumButylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        DilutedMethylIsobutylKetone = new Material.Builder(24026, 'diluted_methyl_isobutyl_ketone')
                .fluid()
                .components(MethylIsobutylKetone, 1, Water, 1)
                .colorAverage()
                .build()

        ChlorinatedBeryl = new Material.Builder(24027, "chlorinated_beryl")
                .fluid(FluidTypes.GAS)
                .fluidTemp(1100)
                .components(BerylliumChloride, 3, AluminiumChloride, 2, SiliconTetrachloride, 6, CarbonMonoxide, 18)
                .colorAverage()
                .build();

        HydratedMagnesiumChlorideGlycolate = new Material.Builder(24028, "hydrated_magnesium_chloride_glycolate")
                .fluid()
                .components(MagnesiumChloride, 1, Water, 2, EthyleneGlycol, 3)
                .colorAverage()
                .build();

        MagnesiumChlorideGlycolate = new Material.Builder(24029, "magnesium_chloride_glycolate")
                .fluid()
                .components(MagnesiumChloride, 1, EthyleneGlycol, 3)
                .colorAverage()
                .build();

        DilutedDiisopropylamine = new Material.Builder(24030, 'diluted_diisopropylamine')
                .fluid()
                .components(Diisopropylamine, 1, Water, 2)
                .colorAverage()
                .build()

        PerfluorooctanoicAcidMixture = new Material.Builder(24031, 'perfluorooctanoic_acid_mixture')
                .fluid()
                .components(PerfluorooctanoicAcid, 1, HydrofluoricAcid, 1)
                .colorAverage()
                .build()

        FluorinatedSurfactantMixture = new Material.Builder(24032, "fluorinated_surfactant_mixture")
                .fluid()
                .components(PerfluorooctanoicAcid, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumEthylXanthateSolution = new Material.Builder(24033, "sodium_ethyl_xanthate_solution")
                .fluid()
                .components(SodiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumAmylXanthateSolution = new Material.Builder(24034, "potassium_amyl_xanthate_solution")
                .fluid()
                .components(PotassiumAmylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumIsobutylXanthateSolution = new Material.Builder(24035, "sodium_isobutyl_xanthate_solution")
                .fluid()
                .components(SodiumIsobutylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumIsopropylXanthateSolution = new Material.Builder(24036, "potassium_isopropyl_xanthate_solution")
                .fluid()
                .components(PotassiumIsopropylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumEthylXanthateSolution = new Material.Builder(24037, "potassium_ethyl_xanthate_solution")
                .fluid()
                .components(PotassiumEthylXanthate, 1, Water, 1)
                .colorAverage()
                .build();

        AcidicTributylPhosphate = new Material.Builder(24038, "acidic_tributyl_phosphate")
                .fluid()
                .components(TributylPhosphate, 1, HydrogenChloride, 3)
                .colorAverage()
                .build();

        PhosgeneSolution = new Material.Builder(24039, "phosgene_solution")
                .fluid()
                .components(Phosgene, 1, Dichloromethane, 1)
                .colorAverage()
                .build();

        TriethylamineSolution = new Material.Builder(24040, "triethylamine_solution")
                .fluid()
                .components(Triethylamine, 1, Dichloromethane, 4)
                .colorAverage()
                .build();

        KaminskyCatalyst = new Material.Builder(24041, "kaminsky_catalyst")
                .dust()
                .components(ZirconoceneDichloride, 1, Methylaluminoxane, 1)
                .colorAverage()
                .build();

        TNPSolution = new Material.Builder(24042, 'tnp_solution')
                .fluid()
                .components(PicricAcid, 1, DilutedSulfuricAcid, 1)
                .colorAverage()
                .build();

        IsophthaloylDichlorideSolution = new Material.Builder(24043, 'isophthaloyl_dichloride_solution')
                .fluid()
                .components(AceticAcid, 1, Water, 1, IsophthaloylDichloride, 1)
                .colorAverage()
                .build();

        IsophthalicAcidSolution = new Material.Builder(24044, 'isophthalic_acid_solution')
                .fluid()
                .components(AceticAcid, 1, Water, 1, IsophthalicAcid, 1)
                .colorAverage()
                .build()

        DichloroethaneIsophthalicAcidSolution = new Material.Builder(24045, 'dichloroethane_isophthalic_acid_solution')
                .fluid()
                .components(Dichloroethane, 1, IsophthalicAcid, 1)
                .colorAverage()
                .build()

        TetrahydrofuranSolution = new Material.Builder(24046, "tetrahydrofuran_solution")
                .fluid()
                .components(Tetrahydrofuran, 1, SulfuricAcid, 1, Water, 1)
                .colorAverage()
                .build()

        AcidicTriethylPhosphate = new Material.Builder(24047, "acidic_triethyl_phosphate")
      		.fluid()
                .components(TriethylPhosphate, 1, HydrogenChloride, 3)
      		.color(0x4639ee)
      		.build();

        NickelIIBisacetylacetonateSolution = new Material.Builder(24048, "nickel_ii_bisacetylacetonate_solution")
      		.fluid()
      		.components(NickelIIBisacetylacetonate, 1, SodiumNitrate, 2, Water, 2)
      		.color(0x3e5051)
      		.build();

        ShellHigherOlefinCatalystSolution = new Material.Builder(24049, "shell_higher_olefin_catalyst_solution")
                .fluid()
                .components(Nickel, 1, DiphenylphosphinoaceticAcid, 1, Cyclooctadiene, 2, EthyleneGlycol, 1)
                .color(0x9c1012)
                .build();

        CrudeNitrobenzene = new Material.Builder(24050, "crude_nitrobenzene")
                .fluid()
                .components(Nitrobenzene, 2, Benzene, 1)
                .colorAverage()
                .build();

        DichlorobistriphenylphosphinenickelII = new Material.Builder(24051, "dichlorobistriphenylphosphinenickel_ii")
                .dust()
                .components(Nickel, 1, Chlorine, 2, TriphenylPhosphine, 2)
                .colorAverage()
                .build();

        DichlorobistriphenylphosphinenickelII.setFormula("NiCl2(PPh3)2", true)

        DicarbonylbistriphenylphosphinenickelZero = new Material.Builder(24052, "dicarbonylbistriphenylphosphinenickel_zero")
                .dust()
                .components(Nickel, 1, Carbon, 2, Oxygen, 2, TriphenylPhosphine, 2)
                .colorAverage()
                .build();

        DicarbonylbistriphenylphosphinenickelZero.setFormula("Ni(CO)2(PPh)2", true)
    }
}