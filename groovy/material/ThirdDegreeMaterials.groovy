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

    }
}