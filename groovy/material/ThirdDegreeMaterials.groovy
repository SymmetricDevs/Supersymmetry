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

        FurfuralSolution = new Material.Builder(21000, "furfural_solution")
                .fluid()
                .components(Water, 3, SulfuricAcid, 1, Furfural, 1)
                .colorAverage()
                .build();


        DiethylEtherSolution = new Material.Builder(21001, 'diethyl_ether_solution')
                .fluid()
                .components(Water, 1, SulfuricAcid, 1, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        LithiumSolution = new Material.Builder(21002, 'lithium_solution')
                .fluid()
                .components(Lithium, 2, material('diethyl_ether'), 1)
                .colorAverage()
                .build();

        DimethylacetamideSolution = new Material.Builder(21003, 'dimethylacetamide_solution')
                .fluid()
                .components(Water, 1, Dimethylacetamide, 1)
                .colorAverage()
                .build();

    }
}