import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class SecondDegreeMaterials {
    public static void init() {
        NitrateSaltMix = new Material.Builder(32025, 'nitrate_salt_mix')
                .dust()
                .components(AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        AmmoniumChlorideSolution = new Material.Builder(11000, "ammonium_chloride_solution")
                .fluid()
                .components(Water, 1, AmmoniumChloride, 1)
                .colorAverage()
                .build();

        PotassiumChlorideSolution = new Material.Builder(11004, "potassium_chloride_solution")
                .fluid()
                .color(0x3b5eeb)
                .components(Water, 1, RockSalt, 1)
                .colorAverage()
                .build();

        PotassiumBisulfateSolution = new Material.Builder(11005, "potassium_bisulfate_solution")
                .fluid()
                .components(Water, 1, PotassiumBisulfate, 1)
                .colorAverage()
                .build();

        SodiumBisulfateSolution = new Material.Builder(11006, "sodium_bisulfate_solution")
                .fluid()
                .components(Water, 1, SodiumBisulfate, 1)
                .colorAverage()
                .build();

        CalciumChlorideSolution = new Material.Builder(11011, "calcium_chloride_solution")
                .fluid()
                .components(Water, 1, CalciumChloride, 1)
                .colorAverage()
                .build();

        SodaAshSolution = new Material.Builder(11012, "soda_ash_solution")
                .fluid()
                .components(Water, 1, SodaAsh, 1)
                .colorAverage()
                .build();

        SodiumBicarbonateSolution = new Material.Builder(11014, "sodium_bicarbonate_solution")
                .fluid()
                .components(Water, 1, SodiumBicarbonate, 1)
                .colorAverage()
                .build();

        AmmoniumNitrateSolution = new Material.Builder(11060, 'ammonium_nitrate_solution')
                .fluid()
                .components(Water, 1, AmmoniumNitrate, 1)
                .colorAverage()
                .build();

        NitrateSolution = new Material.Builder(11061, 'nitrate_solution')
                .fluid()
                .components(Water, 2, AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        SodiumNitrateSolution = new Material.Builder(11063, 'sodium_nitrate_solution')
                .fluid()
                .components(Water, 1, SodiumNitrate, 1)
                .colorAverage()
                .build();

        LithiumSolution = new Material.Builder(11078, 'lithium_solution')
                .fluid()
                .components(Lithium, 2, DiethylEther, 1)
                .colorAverage()
                .build();

        DilutePotassiumCarbonateSolution = new Material.Builder(11087, "dilute_potassium_carbonate_solution")
                .fluid()
                .components(Water, 3, PotassiumCarbonate, 1)
                .colorAverage()
                .build();

        PotassiumHydroxideSolution = new Material.Builder(11088, "potassium_hydroxide_solution")
                .fluid()
                .components(Water, 1, PotassiumHydroxide, 1)
                .colorAverage()
                .build();

        CalciumHydroxideSolution = new Material.Builder(11089, "calcium_hydroxide_solution")
                .fluid()
                .components(Water, 1, CalciumHydroxide, 1)
                .colorAverage()
                .build();

        SodiumSilicateSolution = new Material.Builder(11090, "sodium_silicate_solution")
                .fluid()
                .components(Water, 4, SodiumSilicate, 1)
                .colorAverage()
                .build();

        SodiumAluminateSolution = new Material.Builder(12085, "sodium_aluminate_solution")
                .fluid()
                .components(SodiumAluminate, 1, Water, 1)
                .color(0x3f71bf)
                .build();

        SodiumFluorideSolution = new Material.Builder(12090, "sodium_fluoride_solution")
                .fluid()
                .components(SodiumFluoride, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumFluorideSolution = new Material.Builder(12209, "potassium_fluoride_solution")
                .fluid()
                .components(Water, 1, PotassiumFluoride, 1)
                .colorAverage()
                .build();

        PotassiumTetrafluoroborateSolution = new Material.Builder(12211, "potassium_tetrafluoroborate_solution")
                .fluid()
                .components(Water, 7, PotassiumTetrafluoroborate, 2)
                .color(0x8fb5a3)
                .build();

        SodiumBromideSolution = new Material.Builder(12216, "sodium_bromide_solution")
                .fluid()
                .components(SodiumBromide, 1, Water, 1)
                .colorAverage()
                .build();

    }
}