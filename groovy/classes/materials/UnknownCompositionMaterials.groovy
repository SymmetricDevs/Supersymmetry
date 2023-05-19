import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;


public class UnknownCompositionMaterials {
 
    public static void init() {

        EarthGreenhouseGas = new Material.Builder(10400, "greenhouse_gases")
            .fluid(FluidTypes.GAS)
            .color(0x95cade)
            .build();
    
    }

}           