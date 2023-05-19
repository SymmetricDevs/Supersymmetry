import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OrangicChemistryMaterials {
    public static void init() {
        
        FourNitrochlorobenzene = new Material.Builder(32013, 'four_nitrochlorobenzene')
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 1, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .build();

        FourNitroaniline = new Material.Builder(32014, 'four_nitroaniline')
                .dust()
                .components(Carbon, 6, Hydrogen, 6, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build();

        ParaPhenylenediamine = new Material.Builder(32015, 'para_phenylenediamine')
                .dust()
                .components(Carbon, 6, Hydrogen, 8, Nitrogen, 2)
                .colorAverage()
                .build();

        TwoTwoDichlorohydrazobenzene = new Material.Builder(32016, 'two_two_dichlorohydrazobenzene')
                .dust()
                .components(Carbon, 12, Hydrogen, 10, Chlorine, 2, Nitrogen, 2)
                .colorAverage()
                .build();

        SodiumPhenoxide = new Material.Builder(32019, 'sodium_phenoxide')
                .dust()
                .components(Carbon, 6, Hydrogen, 5, Sodium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        PhthaloylDichloride = new Material.Builder(32020, 'phthaloyl_dichloride')
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Chlorine, 2, Oxygen, 2)
                .colorAverage()
                .build();

        CaprolactamOxime = new Material.Builder(32021, 'caprolactam_oxime')
                .dust()
                .components(Carbon, 6, Hydrogen, 11, Nitrogen, 1, Oxygen, 1)
                .colorAverage()
                .build();

        TNT = new Material.Builder(32024, 'tnt')
                .dust()
                .components(Carbon, 7, Hydrogen, 5, Nitrogen, 3, Oxygen, 6)
                .color(0xacb38d)
                .build();

        Polystyrene = new Material.Builder(32028, 'polystyrene')
                .dust()
                .components(Carbon, 8, Hydrogen, 8)
                .color(0xa2a389)
                .build();

        OneTwoDichlorobenzene = new Material.Builder(32029, 'one_two_dichlorobenzene')
                .dust()
                .components(Carbon, 6, Hydrogen, 4, Chlorine, 2)
                .colorAverage()
                .build();
                
    }
}