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

        Asphalt = new Material.Builder(20004, "asphalt")
                .dust()
                .color(0x000000)
                .build();

        BlackAsh = new Material.Builder(32008, 'black_ash')
                .dust()
                .color(0x000000)
                .colorAverage()
                .build();

        MolecularSieve = new Material.Builder(32031, 'molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x737373)
                .colorAverage()
                .build();

        WetMolecularSieve = new Material.Builder(32032, 'wet_molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x5c5c5c)
                .colorAverage()
                .build();

        RawMolecularSieve = new Material.Builder(11091, "raw_molecular_sieve")
                .fluid()
                .color(0x8c94a8)
                .build();

        FlueGas = new Material.Builder(12000, 'flue_gas')
                .fluid(FluidTypes.GAS)
                .color(0x484a48)
                .fluidTemp(1000)
                .build();

        ExhaustSteam = new Material.Builder(12001, 'exhaust_steam')
                .fluid(FluidTypes.GAS)
                .color(0xc4c4c4)
                .fluidTemp(1000)
                .build();

        SmokeBombMix = new Material.Builder(12002, 'smoke_bomb_mix')
                .fluid(FluidTypes.GAS)
                .color(0x515443)
                .build();

        SugaryWater = new Material.Builder(12014, "sugary_water")
                .fluid()
                .color(0x8fbf9b)
                .build();

        ClarifiedSugaryWater = new Material.Builder(12015, "clarified_sugary_water")
                .fluid()
                .color(0xa7d6b3)
                .build();

        Brine = new Material.Builder(12022, "brine")
                .fluid()
                .color(0xd1d08e)
                .build();

        ImpureSodiumAluminateSolution = new Material.Builder(12084, "impure_sodium_aluminate_solution")
                .fluid()
                .color(0x5b80ba)
                .build();

        RedMud = new Material.Builder(12086, "red_mud")
                .fluid()
                .color(0x913f2d)
                .build();

        ImpureSodaAshSolution = new Material.Builder(12087, "impure_soda_ash_solution")
                .fluid()
                .color(0x91919b)
                .build();

        ImpureSodiumHydroxideSolution = new Material.Builder(12088, "impure_sodium_hydroxide_solution")
                .fluid()
                .color(0x3a4991)
                .build();

        ConcentratedRedMud = new Material.Builder(12091, "concentrated_red_mud")
                .fluid()
                .color(0x824133)
                .build();

        AmmoniaReactionMix = new Material.Builder(12095, "ammonia_reaction_mix")
                .fluid(FluidTypes.GAS)
                .color(0x38478a)
                .fluidTemp(400)
                .build();

        AmmoniaRichGas = new Material.Builder(12096, "ammonia_rich_gas")
                .fluid(FluidTypes.GAS)
                .color(0x345691)
                .fluidTemp(400)
                .build();

        GraphiteMix = new Material.Builder(12098, "graphite_mix")
                .fluid()
                .color(0x080808)
                .build();

        Mash = new Material.Builder(12104, "mash")
                .fluid()
                .color(0x9e8660)
                .build();

        WeedKiller = new Material.Builder(12105, "weed_killer")
                .fluid()
                .color(0xade677)
                .build();

        Pesticide = new Material.Builder(12106, "pesticide")
                .fluid()
                .color(0xc0c77d)
                .build();

        GrainSolution = new Material.Builder(12108, "grain_solution")
                .fluid()
                .color(0xc2cc9d)
                .build();

        YeastSolution = new Material.Builder(12109, "yeast_solution")
                .fluid()
                .color(0xe6e3aa)
                .build();

        ImpureEthanol = new Material.Builder(12110, "impure_ethanol")
                .fluid()
                .color(0xbf9c77)
                .build();

        BorateLiquor = new Material.Builder(12113, "borate_liquor")
                .fluid()
                .color(0xacbbac)
                .build();

    }

}           