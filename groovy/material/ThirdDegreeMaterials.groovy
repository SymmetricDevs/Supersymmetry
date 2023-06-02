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
    }
}