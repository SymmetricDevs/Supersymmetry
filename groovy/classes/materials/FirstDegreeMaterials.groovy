import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class FirstDegreeMaterials{

    public static void init() {

        CalciumHydroxide = new Material.Builder(32033, 'calcium_hydroxide')
                        .dust()
                        .components(Calcium, 1, Oxygen, 2, Hydrogen, 2)
                        .colorAverage()
                        .build();

        CalciumHydroxide.setFormula("Ca(OH)2", true)

        PotassiumHydroxide = new Material.Builder(32034, 'potassium_hydroxide')
                .dust()
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        PotassiumCarbonate =  new Material.Builder(32035, 'potassium_carbonate')
                .dust()
                .components(Potassium, 2, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumSilicate =  new Material.Builder(32036, 'sodium_silicate')
                .dust()
                .components(Sodium, 2, Silicon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumAluminate =  new Material.Builder(32037, 'sodium_aluminate')
                .dust()
                .components(Sodium, 1, Aluminium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        PotassiumBisulfate = new Material.Builder(32005, 'potassium_bisulfate')
                .dust().fluid()
                .components(Potassium, 1, Hydrogen, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SodiumBicarbonate = new Material.Builder(32009, 'sodium_bicarbonate')
                .dust()
                .components(Sodium, 1, Hydrogen, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        AmmoniumNitrate = new Material.Builder(32011, 'ammonium_nitrate')
                .dust()
                .components(Nitrogen, 2, Oxygen, 3, Hydrogen, 4)
                .colorAverage()
                .build();

        AmmoniumNitrate.setFormula("NH4NO3", true);

        AmmoniumSulfate = new Material.Builder(32022, 'ammonium_sulfate')
                .dust()
                .components(Nitrogen, 2, Hydrogen, 8, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        SodiumNitrate = new Material.Builder(32026, 'sodium_nitrate')
                .dust()
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .colorAverage()
                .build();

        SodiumFluoride = new Material.Builder(32046, 'sodium_fluoride')
                .fluid().dust()
                .components(Sodium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        PotassiumFluoride = new Material.Builder(32048, 'potassium_fluoride')
                .fluid().dust()
                .components(Potassium, 1, Fluorine, 1)
                .colorAverage()
                .build();
                
        PotassiumTetrafluoroborate = new Material.Builder(32050, 'potassium_tetrafluoroborate')
                .fluid().dust()
                .components(Potassium, 1, Boron, 1, Fluorine, 4)
                .color(0x8fb5a3)
                .build();

        SodiumBromide = new Material.Builder(32053, 'sodium_bromide')
                .dust()
                .components(Sodium, 1, Bromine, 1)
                .colorAverage()
                .build()
    }
}