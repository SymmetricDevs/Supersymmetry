package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

public class UnknownCompositionMaterials {
 
    public static void register() {

        log.infoMC("Registering Unknown Composition Materials!");

        EarthGreenhouseGas = new Material.Builder(4000, "greenhouse_gases")
            .fluid(FluidTypes.GAS)
            .color(0x95cade)
            .build();

        Asphalt = new Material.Builder(4001, "asphalt")
                .dust()
                .color(0x000000)
                .build();

        BlackAsh = new Material.Builder(4002, 'black_ash')
                .dust()
                .color(0x000000)
                .colorAverage()
                .build();

        MolecularSieve = new Material.Builder(4003, 'molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x737373)
                .colorAverage()
                .build();

        WetMolecularSieve = new Material.Builder(4004, 'wet_molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x5c5c5c)
                .colorAverage()
                .build();

        RawMolecularSieve = new Material.Builder(4005, "raw_molecular_sieve")
                .fluid()
                .color(0x8c94a8)
                .build();

        FlueGas = new Material.Builder(4006, 'flue_gas')
                .fluid(FluidTypes.GAS)
                .color(0x484a48)
                .fluidTemp(1000)
                .build();

        ExhaustSteam = new Material.Builder(4007, 'exhaust_steam')
                .fluid(FluidTypes.GAS)
                .color(0xc4c4c4)
                .fluidTemp(400)
                .build();

        SmokeBombMix = new Material.Builder(4008, 'smoke_bomb_mix')
                .fluid(FluidTypes.GAS)
                .color(0x515443)
                .build();

        SugaryWater = new Material.Builder(4009, "sugary_water")
                .fluid()
                .color(0x8fbf9b)
                .build();

        ClarifiedSugaryWater = new Material.Builder(4010, "clarified_sugary_water")
                .fluid()
                .color(0xa7d6b3)
                .build();

        Brine = new Material.Builder(4011, "brine")
                .fluid()
                .color(0xd1d08e)
                .build();

        ImpureSodiumAluminateSolution = new Material.Builder(4012, "impure_sodium_aluminate_solution")
                .fluid()
                .color(0x5b80ba)
                .build();

        RedMud = new Material.Builder(4013, "red_mud")
                .fluid()
                .color(0x913f2d)
                .build();

        ImpureSodaAshSolution = new Material.Builder(4014, "impure_soda_ash_solution")
                .fluid()
                .color(0x91919b)
                .build();

        ImpureSodiumHydroxideSolution = new Material.Builder(4015, "impure_sodium_hydroxide_solution")
                .fluid()
                .color(0x3a4991)
                .build();

        ConcentratedRedMud = new Material.Builder(4016, "concentrated_red_mud")
                .fluid()
                .color(0x824133)
                .build();

        AmmoniaReactionMix = new Material.Builder(4017, "ammonia_reaction_mix")
                .fluid(FluidTypes.GAS)
                .color(0x38478a)
                .fluidTemp(400)
                .build();

        AmmoniaRichGas = new Material.Builder(4018, "ammonia_rich_gas")
                .fluid(FluidTypes.GAS)
                .color(0x345691)
                .fluidTemp(400)
                .build();

        PalladiumContainingSolution = new Material.Builder(4019, "palladium_containing_solution")
                .fluid()
                .color(0x808080)
                .build();

        Mash = new Material.Builder(4020, "mash")
                .fluid()
                .color(0x9e8660)
                .build();

        WeedKiller = new Material.Builder(4021, "weed_killer")
                .fluid()
                .color(0xade677)
                .build();

        Pesticide = new Material.Builder(4022, "pesticide")
                .fluid()
                .color(0xc0c77d)
                .build();

        GrainSolution = new Material.Builder(4023, "grain_solution")
                .fluid()
                .color(0xc2cc9d)
                .build();

        YeastSolution = new Material.Builder(4024, "yeast_solution")
                .fluid()
                .color(0xe6e3aa)
                .build();

        ImpureEthanol = new Material.Builder(4025, "impure_ethanol")
                .fluid()
                .color(0xbf9c77)
                .build();

        BorateLiquor = new Material.Builder(4026, "borate_liquor")
                .fluid()
                .color(0xacbbac)
                .build();

        ImpureAcetaldehyde = new Material.Builder(4027, "impure_acetaldehyde")
                .fluid()
                .color(0x6e6e6e)
                .build();

        CativaProcessPreparation = new Material.Builder(4028, "cativa_process_preparation")
                .fluid()
                .color(0x9c8275)
                .build();

        CativaProcessSolution = new Material.Builder(4029, "cativa_process_solution")
                .fluid()
                .color(0x75665e)
                .build();

        AcidicCumene = new Material.Builder(4030, "acidic_cumene")
                .fluid()
                .color(0x571a0b)
                .build()

        RearrangedCumene = new Material.Builder(4031, "rearranged_cumene")
                .fluid()
                .color(0x4f2f27)
                .build();

        AlkylatedButane = new Material.Builder(4032, "alkylated_butane")
                .fluid()
                .color(0x6e4c2c)
                .build();

        ImpureKaptonK = new Material.Builder(4033, "impure_kapton_k")
                .fluid()
                .color(0xe0b53f)
                .build();

        ImpureKaptonE = new Material.Builder(4034, "impure_kapton_e")
                .fluid()
                .color(0xcad96f)
                .build();

        KaptonEPreparation = new Material.Builder(4035, "kapton_e_preparation")
                .fluid()
                .color(0x899444)
                .build();

        ImpureDiiodobenzene = new Material.Builder(4036, "impure_diiodobenzene")
                .fluid()
                .color(0x736c63)
                .build();

        ImpureEthyleneOxide = new Material.Builder(4037, "impure_ethylene_oxide")
                .fluid(FluidTypes.GAS)
                .color(0x52755c)
                .build();

        AmocoProcessCatalyst = new Material.Builder(4038, "amoco_process_catalyst")
                .dust()
                .iconSet(SHINY)
                .color(0xdea68c)
                .build();

        GraniteTailings = new Material.Builder(4039, "granite_tailings")
                .dust()
                .color(0x302323)
                .build();

        LimestoneTailings = new Material.Builder(4040, "limestone_tailings")
                .dust()
                .color(0x68695d)
                .build();

        PegmatiteTailings = new Material.Builder(4041, "pegmatite_tailings")
                .dust()
                .color(0x1f1c1c)
                .build();

        UltramaficTailings = new Material.Builder(4042, "ultramafic_tailings")
                .dust()
                .color(0x141414)
                .build();

        Corundum = new Material.Builder(4043, "corundum")
                .dust()
                .iconSet(SHINY)
                .color(0x7a4261)
                .build();

        Tourmaline = new Material.Builder(4044, "tourmaline")
                .dust().gem()
                .iconSet(SHINY)
                .color(0x8c613f)
                .build();

        NonMarineEvaporite = new Material.Builder(4045, "non_marine_evaporite")
                .dust()
                .color(0x78756d)
                .build();

        HalideEvaporite = new Material.Builder(4046, "halide_evaporite")
                .dust()
                .color(0x99867c)
                .build();

        CarbonateEvaporite = new Material.Builder(4047, "carbonate_evaporite")
                .dust()
                .color(0xe3e3e3)
                .build();

        SulfateEvaporite = new Material.Builder(4048, "sulfate_evaporite")
                .dust()
                .color(0xc7c0b1)
                .build();

        Vinegar = new Material.Builder(4049, "vinegar")
                .fluid()
                .color(0xc3c4b3)
                .build();

        RawCellulose = new Material.Builder(4050, "raw_cellulose")
                .dust()
                .color(0x302b1a)
                .build();

        WhiteLiquor = new Material.Builder(4051, "white_liquor")
                .fluid()
                .color(0xd9d3c1)
                .build();

        BlackLiquor = new Material.Builder(4052, "black_liquor")
                .fluid()
                .color(0x2e2a1f)
                .build();

        ConcentratedBlackLiquor = new Material.Builder(4053, "concentrated_black_liquor")
                .fluid()
                .color(0x1f1d18)
                .build();

        GreenLiquor = new Material.Builder(4054, "green_liquor")
                .fluid()
                .color(0x2b4536)
                .build();

        AcidicCelluloseSolution = new Material.Builder(4055, "acidic_cellulose_solution")
                .fluid()
                .color(0xb7bd60)
                .build();

        Wastewater = new Material.Builder(4056, "wastewater")
                .fluid()
                .color(0x2d402f)
                .build();

        HeatedWastewater = new Material.Builder(4057, "heated_wastewater")
                .fluid()
                .fluidTemp(340)
                .color(0x435e46)
                .build();

        FlocculatedWastewater = new Material.Builder(4058, "flocculated_wastewater")
                .fluid()
                .color(0x435e46)
                .build();

        FilteredWastewater = new Material.Builder(4059, "filtered_wastewater")
                .fluid()
                .color(0x457568)
                .build();

        WastewaterSludge = new Material.Builder(4060, "wastewater_sludge")
                .fluid()
                .color(0x2b1e1e)
                .build();

        CarburizedStainlessSteel = new Material.Builder(4061, 'carburized_stainless_steel')
                .dust().fluid()
                .fluidTemp(1500)
                .color(0x6b6552)
                .build()

        UnscrubbedWoodGas = new Material.Builder(4062, "unscrubbed_wood_gas")
                .fluid(FluidTypes.GAS)
                .color(0x85806f)
                .build();

        LightOil = new Material.Builder(4063, "light_oil")
                .fluid()
                .color(0x5e5e4d)
                .build();

        NaphthaleneOil = new Material.Builder(4065, "naphthalene_oil")
                .fluid()
                .color(0x2e2926)
                .build();

        AnthraceneOil = new Material.Builder(4066, "anthracene_oil")
                .fluid()
                .color(0x211f1e)
                .build();

        AlkalineNaphthaleneOil = new Material.Builder(4067, "alkaline_naphthalene_oil")
                .fluid()
                .color(0x403833)
                .build();

        PurifiedNaphthaleneOil = new Material.Builder(4068, "purified_naphthalene_oil")
                .fluid()
                .color(0x595542)
                .build();

        AcidicLightOil = new Material.Builder(4069, "acidic_light_oil")
                .fluid()
                .color(0x87816c)
                .build();

        CrudePyridiniumSulfate = new Material.Builder(4070, "crude_pyridinium_sulfate")
                .fluid()
                .color(0x48523b)
                .build();

        ImpurePyridine = new Material.Builder(4071, "impure_pyridine")
                .fluid()
                .color(0x233326)
                .build();

        AcidicAnthraceneOil = new Material.Builder(4072, "acidic_anthracene_oil")
                .fluid()
                .color(0x87816c)
                .build();

        AnthraceneExtract = new Material.Builder(4073, "anthracene_extract")
                .fluid()
                .color(0x211c1c)
                .build();

        CrudeQuinoliniumSulfate = new Material.Builder(4074, "crude_quinolinium_sulfate")
                .fluid()
                .color(0x1b1c0a)
                .build();

        ImpureQuinoline = new Material.Builder(4075, "impure_quinoline")
                .fluid()
                .color(0x222418)
                .build();

        ConcentratedBrine = new Material.Builder(4076, "concentrated_brine")
                .fluid()
                .color(0xa6a444)
                .build();

        BoronFreeBrine = new Material.Builder(4078, "boron_free_brine")
                .fluid()
                .color(0xa68a44)
                .build();

        LithiumFreeBrine = new Material.Builder(4079, "lithium_free_brine")
                .fluid()
                .color(0xa17a4c)
                .build();

        ChlorinatedBrine = new Material.Builder(4080, "chlorinated_brine")
                .fluid()
                .color(0xa3b560)
                .build();

        ImpureBromine = new Material.Builder(4081, "impure_bromine")
                .fluid(FluidTypes.GAS)
                .color(0x572d2b)
                .build();

        ChilledLava = new Material.Builder(4082, "chilled_lava")
                .color(0x4d2d25)
                .fluidTemp(400)
                .build();

        ChilledFlueGas = new Material.Builder(4083, "chilled_flue_gas")
                .fluid(FluidTypes.GAS)
                .color(0x171717)
                .fluidTemp(400)
                .build();

        WoodAsh = new Material.Builder(4084, "wood_ash")
                .dust()
                .color(0x242221)
                .build();

        VeryConcentratedBrine = new Material.Builder(4085, "very_concentrated_brine")
                .fluid()
                .color(0xb5b226)
                .build();

        LangbeiniteLeach = new Material.Builder(4086, "langbeinite_leach")
                .fluid()
                .color(0x9c9a87)
                .build();

        PolyhaliteLeach = new Material.Builder(4087, "polyhalite_leach")
                .fluid()
                .color(0xb3a094)
                .build();

        TinDross = new Material.Builder(4088, "tin_dross")
                .dust().fluid()
                .fluidTemp(600)
                .color(0x2a2e2e)
                .build();

        DecopperizedTin = new Material.Builder(4089, "decopperized_tin")
                .dust().fluid()
                .fluidTemp(600)
                .color(0xb5b7c9)
                .build();

        KainiteLeach = new Material.Builder(4090, "kainite_leach")
                .fluid()
                .color(0xadb07f)
                .build();

        Zeolite13X = new Material.Builder(4091, "zeolite_13")
                .dust()
                .iconSet(SHINY)
                .color(0xe4e8bc)
                .build();

        Zeolite13XSolution = new Material.Builder(4092, "zeolite_13_solution")
                .fluid()
                .color(0xe4e8bc)
                .build();

        LTSCatalyst = new Material.Builder(4093, "lts_catalyst")
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x756857)
                .build();

        HTSCatalyst = new Material.Builder(4094, "hts_catalyst")
                .dust()
                .color(0x5e4f4f)
                .build();

        SpentBismuthCatalyst = new Material.Builder(4095, "spent_bismuth_catalyst")
                .dust()
                .color(0x31403f)
                .build();

        AlkalineSodiumOleateSolution = new Material.Builder(4096, "alkaline_sodium_oleate_solution")
                .fluid()
                .color(0xa6b584)
                .build();

        FattyAcidSolution = new Material.Builder(4097, "fatty_acid_solution")
                .fluid()
                .color(0xa1ad5c)
                .build();

        OleicAcidSolution = new Material.Builder(4098, "oleic_acid_solution")
                .fluid()
                .color(0x8dbf67)
                .build();

        AluminiumSilicateLeach = new Material.Builder(4099, "aluminium_silicate_leach")
                .fluid()
                .color(0x587682)
                .build();

        AlkaliAlumMix = new Material.Builder(4100, "alkali_alum_mix")
                .iconSet(SHINY)
                .dust()
                .color(0xe34949)
                .build();

        AmblygoniteLeach = new Material.Builder(4101, "amblygonite_leach")
                .fluid()
                .color(0xbaced6)
                .build();

        RoastedLepidolite = new Material.Builder(4102, "roasted_lepidolite")
                .dust()
                .color(0x443b45)
                .iconSet(SAND)
                .build();

        LepidoliteLeach = new Material.Builder(4103, "lepidolite_leach")
                .fluid()
                .color(0x805066)
                .build();

        NeutralizedLepidoliteLeach = new Material.Builder(4104, "neutralized_lepidolite_leach")
                .fluid()
                .color(0x675d85)
                .build();

        AluminiumFreeLepidoliteLeach = new Material.Builder(4105, "aluminium_free_lepidolite_leach")
                .fluid()
                .color(0x557365)
                .build();

        GoldLeachSolution = new Material.Builder(4106, "gold_leach_solution")
                .fluid()
                .color(0x9c8a46)
                .build();

        PhosphatePulp = new Material.Builder(4107, "phosphate_pulp")
                .dust()
                .color(0x8c7e2a)
                .iconSet(SAND)
                .build();

        FilteredPhosphatePulp = new Material.Builder(4108, "filtered_phosphate_pulp")
                .dust()
                .color(0x8c7e2a)
                .iconSet(SHINY)
                .build();

        PhosphateConcentrate = new Material.Builder(4109, "phosphate_concentrate")
                .dust()
                .color(0xd1b615)
                .iconSet(SHINY)
                .build();

        PropanalMixture = new Material.Builder(4110, "propanal_mixture")
                .fluid()
                .color(0x84910f)
                .build();
      
        ImpureAmmoniumFluoroberyllateSolution = new Material.Builder(4111, "ammonium_fluoroberyllate_solution")
                .fluid()
                .color(0x1b8541)
                .build();

        ImpureAmmoniumFluoroberyllateSolution.setFormula("(?)(NH4)2(BeF4)(H2O)3", true)

        ImpureBerylliumSulfateSolution = new Material.Builder(4112, "impure_beryllium_sulfate_solution")
                .fluid()
                .color(0x608726)
                .build();

        ImpureLithiumSulfateSolution = new Material.Builder(4113, "impure_lithium_sulfate_solution")
                .fluid()
                .color(0xf0bc89)
                .build();

        GalenaByproductsSlurry = new Material.Builder(4114, "galena_byproducts_slurry")
                .fluid()
                .color(0x592880)
                .build();

        SinteredLeadConcentrate = new Material.Builder(4115, "sintered_lead_concentrate")
                .dust()
                .color(0x3a1954)
                .iconSet(SAND)
                .build();

        CadmiumRichFlueDust = new Material.Builder(4116, "cadmium_rich_flue_dust")
                .dust()
                .color(0x757061)
                .iconSet(DULL)
                .build();

        BlackMetal = new Material.Builder(4117, "black_metal")
                .dust()
                .color(0x3d3440)
                .build();

        AntimonyArsenicFlueDust = new Material.Builder(4118, "antimony_arsenic_flue_dust")
                .dust()
                .color(0x707063)
                .iconSet(DULL)
                .build();

        BurnedBlackMetal = new Material.Builder(4119, "burned_black_metal")
                .dust()
                .color(0x3d3440)
                .iconSet(DULL)
                .build();

        LithargeSlag = new Material.Builder(4120, "litharge_slag")
                .dust()
                .color(0xb5443c)
                .iconSet(DULL)
                .build();

        HarrisSlag = new Material.Builder(4121, "harris_slag")
                .dust()
                .color(0xabb074)
                .iconSet(DULL)
                .build();

        SodiumArsenateStannateSolution = new Material.Builder(4122, "sodium_arsenate_stannate_solution")
                .fluid()
                .color(0x5c3a23)
                .build();
        
        SodiumArsenateStannateMixture = new Material.Builder(4123, "sodium_arsenate_stannate_mixture")
                .dust()
                .color(0x784c2f)
                .build();

        ImpureEthyleneGlycol = new Material.Builder(4124, "impure_ethylene_glycol")
                .fluid()
                .color(0xc8c8e0)
                .build();

        ImpureSaturatedAmmoniacalMethanol = new Material.Builder(4125, "impure_saturated_ammoniacal_methanol")
                .fluid()
                .color(0xad8653)
                .build();

        CarnalliteLeach = new Material.Builder(4126, "carnallite_leach")
                .fluid()
                .color(0xc1c499)
                .build();

        HaliteLeach = new Material.Builder(4127, "halite_leach")
                .fluid()
                .color(0x9bbdbc)
                .build();

        EthylenediaminePyrocatechol = new Material.Builder(4128, "ethylenediamine_pyrocatechol")
                .fluid()
                .color(0x42392f)
                .build();

        CeramicThickFilmPaste = new Material.Builder(4129, "ceramic_thick_film_paste")
                .fluid()
                .color(0x000000)
                .build();

        BoraxElectrolyte = new Material.Builder(4130, "borax_electrolyte")
                .fluid()
                .color(0x85806b)
                .build();

        FerroelectricCeramicBinding = new Material.Builder(4131, "ferroelectric_ceramic_binding")
                .fluid()
                .color(0xede772)
                .build();

        DisproportionatedTrichlorosilane = new Material.Builder(4132, 'disproportionated_trichlorosilane')
                .fluid()
                .color(0x849169)
                .build()

        DisproportionatedDichlorosilane = new Material.Builder(4133, 'disproportionated_dichlorosilane')
                .fluid()
                .color(0xa1ad86)
                .build()

        DisproportionatedChlorosilane = new Material.Builder(4134, 'disproportionated_chlorosilane')
                .fluid()
                .color(0xb5bf9b)
                .build()
      
        ChlorofluoromethaneMix = new Material.Builder(4135, "chlorofluoromethane_mix")
                .fluid()
                .color(0xb03f5d)
                .build();

        CinnabarSlurry = new Material.Builder(4136, "cinnabar_slurry")
                .fluid()
                .color(0x960000)
                .build();

        ImpureCinnabarSlurry = new Material.Builder(4137, "impure_cinnabar_slurry")
                .fluid()
                .color(0x820000)
                .build();

        TwoEthylhexylPhosphoricAcidMix = new Material.Builder(4138, "two_ethylhexyl_phosphoric_acid_mix")
                .fluid()
                .color(0xd1bb75)
                .build();

        RareEarthCatalystYNd = new Material.Builder(4139, "rare_earth_catalyst_y_nd")
                .dust()
                .color(0x2e2a2a)
                .build();

        DilutedPrimaryAmineN = new Material.Builder(4140, "diluted_primary_amine_n")
                .fluid()
                .color(0x704a9e)
                .build();

        CrosslinkedPolystyrene = new Material.Builder(4141, "crosslinked_polystyrene")
                .ingot().fluid()
                .flags(GENERATE_ROUND)
                .color(0xa7a9d6)
                .build();

        EthyleneGlycolMix = new Material.Builder(4142, "ethylene_glycol_mix")
                .fluid()
                .color(0x2eafc9)
                .build();

        PalladiumDopedCrosslinkedPolystyrene = new Material.Builder(4143, "palladium_doped_crosslinked_polystyrene")
                .ingot().fluid()
                .flags(GENERATE_ROUND)
                .color(0xe0e6bc)
                .build();

        AlfolTrialkylaluminiumMixture = new Material.Builder(4144, 'alfol_trialkylaluminium_mixture')
                .fluid()
                .color(0x6b777d)
                .build()

        AlfolTrialkylaluminiumMixture.setFormula("AlR3", true)

        AluminiumAlkoxideMixture = new Material.Builder(4145, 'aluminium_alkoxide_mixture')
                .dust()
                .color(0x657780)
                .build()

        AluminiumAlkoxideMixture.setFormula("Al(OR)3", true)

        ZieglerAlfolMixture = new Material.Builder(4146, 'ziegler_alfol_mixture')
                .fluid()
                .color(0xc47631)
                .build()

        AluminiumAlkoxideSolution = new Material.Builder(4148, 'aluminium_alkoxide_solution')
                .fluid()
                .color(0x657780)
                .build()

        AluminiumAlkoxideSolution.setFormula("[(C2H5)2O]Al(OR)3", true)

        CapsaicinSolution = new Material.Builder(4149, 'capsaicin_solution')
                .fluid()
                .color(0xd43b2a)
                .build()

        TearGas = new Material.Builder(4150, 'tear_gas')
                .fluid()
                .color(0xd1ba5c)
                .build()

        HydratedPropene = new Material.Builder(4151, 'hydrated_propene')
                .fluid()
                .color(0xc9997d)
                .build()

        EthylamineMix = new Material.Builder(4152, 'ethylamine_mix')
                .fluid()
                .color(0xdbaf48)
                .build()

        ImpureSphaleriteSlurry = new Material.Builder(4153, 'impure_sphalerite_slurry')
                .fluid()
                .color(0xa5a690)
                .build()

        UnprocessedSphaleriteSlurry = new Material.Builder(4154, 'unprocessed_sphalerite_slurry')
                .fluid()
                .color(0xc7c991)
                .build()

        GalenaSlurry = new Material.Builder(4155, 'galena_slurry')
                .fluid()
                .color(0x513d59)
                .build()

        SphaleriteSlurry = new Material.Builder(4156, 'sphalerite_slurry')
                .fluid()
                .color(0xb7ba63)
                .build()

        ThalliumRichFlue = new Material.Builder(4157, 'thallium_rich_flue')
                .dust()
                .color(0x26222e)
                .build()

        CrudeZinc = new Material.Builder(4158, 'crude_zinc')
                .fluid()
                .color(0x565863)
                .build()

        CadmiumRichZinc = new Material.Builder(4159, 'cadmium_rich_zinc')
                .fluid()
                .color(0x80849c)
                .build()

        ImpureSmithsoniteSlurry = new Material.Builder(4160, 'impure_smithsonite_slurry')
                .fluid()
                .color(0x83a899)
                .build()

        SmithsoniteSlurry = new Material.Builder(4161, 'smithsonite_slurry')
                .fluid()
                .color(0x89c9af)
                .build()

        ZincLeach = new Material.Builder(4162, 'zinc_leach')
                .fluid()
                .color(0x8c6f58)
                .build()

        ZincLeachResidue = new Material.Builder(4163, 'zinc_leach_residue')
                .dust()
                .color(0x33281f)
                .build()

        HotZincLeach = new Material.Builder(4164, 'hot_zinc_leach')
                .fluid()
                .fluidTemp(353)
                .color(0xb89e8a)
                .build()

        HotZincLeachResidue = new Material.Builder(4165, 'hot_zinc_leach_residue')
                .dust()
                .color(0x3b332d)
                .build()

        ZincRichSlag = new Material.Builder(4166, 'zinc_rich_slag')
                .dust()
                .color(0x242323)
                .build()

        ReducedZincLeach = new Material.Builder(4167, 'reduced_zinc_leach')
                .fluid()
                .color(0xb38764)
                .build()

        WaelzOxide = new Material.Builder(4168, 'waelz_oxide')
                .dust().fluid()
                .color(0x475453)
                .build()

        GermaniumRichSlag = new Material.Builder(4169, 'germanium_rich_slag')
                .dust()
                .color(0x2d2e27)
                .build()

        ZincCementationSlurry = new Material.Builder(4170, 'zinc_cementation_slurry')
                .fluid()
                .color(0x4f5663)
                .build()

        PrecipitatedZincLeach = new Material.Builder(4171, 'precipitated_zinc_leach')
                .fluid()
                .color(0x756d54)
                .build()

        CopperCadmiumResidue = new Material.Builder(4172, 'copper_cadmium_residue')
                .dust()
                .color(0x47271d)
                .build()

        HotPrecipitatedZincLeach = new Material.Builder(4173, 'hot_precipitated_zinc_leach')
                .fluid()
                .fluidTemp(353)
                .color(0x918a71)
                .build()

        ReprecipitatedZincLeach = new Material.Builder(4174, 'reprecipitated_zinc_leach')
                .fluid()
                .color(0x756e54)
                .build()

        CobaltResidue = new Material.Builder(4175, 'cobalt_residue')
                .dust()
                .color(0x373b6b)
                .build()
      
        FuselOil = new Material.Builder(4176, 'fusel_oil')
                .fluid()
                .color(0xa62403)
                .build()

        AshSlurry = new Material.Builder(4177, 'ash_slurry')
                .fluid()
                .color(0x252526)
                .build()

        DesulfurizedFlueGas = new Material.Builder(4178, 'desulfurized_flue_gas')
                .fluid(FluidTypes.GAS)
                .color(0x151521)
                .fluidTemp(1000)
                .build()

        CadmiumRichFlueGas = new Material.Builder(4179, "cadmium_rich_flue_gas")
                .fluid(FluidTypes.GAS)
                .color(0x757061)
                .fluidTemp(1000)
                .build();

        AntimonyArsenicFlueGas = new Material.Builder(4180, "antimony_arsenic_flue_gas")
                .fluid(FluidTypes.GAS)
                .color(0x707063)
                .fluidTemp(1000)
                .build();

        ThalliumRichFlueGas = new Material.Builder(4181, 'thallium_rich_flue_gas')
                .fluid(FluidTypes.GAS)
                .color(0x26222e)
                .fluidTemp(1000)
                .build()

        FluorinatedOctanoylChlorideMixture = new Material.Builder(4182, 'fluorinated_octanoyl_chloride_mixture')
                .fluid()
                .color(0x458583)
                .build()

        ButyraldehydeMixture = new Material.Builder(4183, "butyraldehyde_mixture")
                .fluid()
                .color(0x96920e)
                .build();

        PentanalMixture = new Material.Builder(4184, "pentanal_mixture")
                .fluid()
                .color(0x968450)
                .build();

        SaltRoastedVanadinite = new Material.Builder(4185, "salt_roasted_vanadinite")
                .dust()
                .color(0x2e2b28)
                .build();

        SodaAshRoastedVanadinite = new Material.Builder(4186, "soda_ash_roasted_vanadinite")
                .dust()
                .color(0x38342f)
                .build();

        LeachedSaltRoastedVanadinite = new Material.Builder(4187, "leached_salt_roasted_vanadinite")
                .dust()
                .color(0x403c37)
                .build();

        LeachedSodaAshRoastedVanadinite = new Material.Builder(4188, "leached_soda_ash_roasted_vanadinite")
                .dust()
                .color(0x4d463f)
                .build();

        DissolvedFerrochromium = new Material.Builder(4189, "dissolved_ferrochromium")
                .fluid()
                .color(0xd17979)
                .build();

        CrudeAmmoniumIronIISulfate = new Material.Builder(4190, "crude_ammonium_iron_ii_sulfate")
                .dust()
                .color(0x96cf70)
                .build();

        MohrMotherLiquor = new Material.Builder(4191, "mohr_mother_liquor")
                .fluid()
                .color(0x43a375)
                .build();

        CrudeAmmoniumIronIISulfateSolution = new Material.Builder(4192, "crude_ammonium_iron_ii_sulfate_solution")
                .fluid()
                .fluidTemp(343)
                .color(0x96cf70)
                .build();

        ChromiumAnolyte = new Material.Builder(4193, "chromium_anolyte")
                .fluid()
                .color(0xd97777)
                .build();

        ChromiumCatholyte = new Material.Builder(4194, "chromium_catholyte")
                .fluid()
                .color(0xc45e4f)
                .build();

        ChromiumMotherLiquor = new Material.Builder(4195, "chromium_mother_liquor")
                .fluid()
                .color(0xeb94d1)
                .build();

        ReducedChromiumAnolyte = new Material.Builder(4196, "reduced_chromium_anolyte")
                .fluid()
                .color(0xd9b077)
                .build();
      
        Sienna = new Material.Builder(4197, "sienna")
                .dust()
                .color(0x4a3724)
                .build();

        BurntSienna = new Material.Builder(4198, "burnt_sienna")
                .dust()
                .color(0x662e2e)
                .build();

        ImpureVTMSlurry = new Material.Builder(4199, "impure_vtm_slurry")
                .fluid()
                .color(0x2e1213)
                .build();

        VTMSlurry = new Material.Builder(4200, "vtm_slurry")
                .fluid()
                .color(0x52191b)
                .build();

        SiliconDioxideSlurry = new Material.Builder(4201, "silicon_dioxide_slurry")
                .fluid()
                .color(0x69675b)
                .build();

        VTMConcentrate = new Material.Builder(4202, "vtm_concentrate")
                .dust()
                .color(0x691e21)
                .build();

        VTSlag = new Material.Builder(4203, "vt_slag")
                .dust()
                .color(0x302222)
                .build();

        AlkaliVTSlag = new Material.Builder(4204, "alkali_vt_slag")
                .dust()
                .color(0x3b2531)
                .build();

        TitaniaSlag = new Material.Builder(4205, "titania_slag")
                .dust()
                .color(0x4f2b3f)
                .build();

        RutileSlurry = new Material.Builder(4207, "rutile_slurry")
                .fluid()
                .color(0x575544)
                .build();

        CarnotiteLeach = new Material.Builder(4208, "carnotite_leach")
                .fluid()
                .color(0x929c5c)
                .build();

        ReducedCarnotiteLeach = new Material.Builder(4209, "reduced_carnotite_leach")
                .fluid()
                .color(0x696840)
                .build();

        UraniumVanadiumExtractionMixture = new Material.Builder(4210, "uranium_vanadium_extraction_mixture")
                .fluid()
                .color(0xd4d03f)
                .build();

        UraniumVanadiumExtract = new Material.Builder(4211, "uranium_vanadium_extract")
                .fluid()
                .color(0x505e3a)
                .build();

        UraniumExtract = new Material.Builder(4212, "uranium_extract")
                .fluid()
                .color(0x4a6e3b)
                .build();

        AcidicVanadylSolution = new Material.Builder(4213, "acidic_vanadyl_solution")
                .fluid()
                .color(0x804221)
                .build();

        ImpureUranylCarbonateSolution = new Material.Builder(4214, "impure_uranyl_carbonate_solution")
                .fluid()
                .color(0x9cad37)
                .build();

        UranylCarbonateSolution = new Material.Builder(4215, "uranyl_carbonate_solution")
                .fluid()
                .color(0xbed14d)
                .build();

        UranylSulfateSolution = new Material.Builder(4216, "uranyl_sulfate_solution")
                .fluid()
                .color(0xb5a638)
                .build();

        TetraethylleadSludge = new Material.Builder(4217, "tetraethyllead_sludge")
                .fluid()
                .color(0x2b1e1e)
                .build();

        GasolineOxygenates = new Material.Builder(4218, "gasoline_oxygenates")
                .fluid()
                .color(0xb4c5e0)
                .build();

        GasolineAntioxidants = new Material.Builder(4219, "gasoline_antioxidants")
                .fluid()
                .color(0x380b0d)
                .build();

        GasolineAntiknock = new Material.Builder(4220, "gasoline_antiknock")
                .fluid()
                .color(0x48485e)
                .build();

        GasolineGeneralAdditives = new Material.Builder(4221, "gasoline_general_additives")
                .fluid()
                .color(0x718072)
                .build();

        MidgradeGasoline = new Material.Builder(4222, "midgrade_gasoline")
                .fluid()
                .color(0xc49735)
                .build();

        PremiumGasoline = new Material.Builder(4223, "premium_gasoline")
                .fluid()
                .color(0xdb8427)
                .build();

        SupremeGasoline = new Material.Builder(4224, "supreme_gasoline")
                .fluid()
                .color(0xf26d1b)
                .build();

        PotassiumMolecularSieve = new Material.Builder(4225, 'potassium_molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x7c8e94)
                .build();

        CesiumMolecularSieve = new Material.Builder(4226, 'cesium_molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x9c7f73)
                .build();

        SaturatedPotassiumMolecularSieve = new Material.Builder(4227, 'saturated_potassium_molecular_sieve')
                .dust()
                .color(0x7c8e94)
                .build();

        SaturatedCesiumMolecularSieve = new Material.Builder(4228, 'saturated_cesium_molecular_sieve')
                .dust()
                .color(0x9c7f73)
                .build();

        ImpureIlmeniteSlurry = new Material.Builder(4229, "impure_ilmenite_slurry")
                .fluid()
                .color(0x4a474c)
                .build();

        ImpureIlmeniteSlurry.setFormula("(H2O)(FeTiO3)(?)", true);

        ImpureIlmeniteConcentrate = new Material.Builder(4230, "impure_ilmenite_concentrate")
                .dust()
                .color(0x4a474c).iconSet(ROUGH)
                .build();

        ImpureIlmeniteConcentrate.setFormula("(FeTiO3)(?)", true);

        IlmeniteSlurry = new Material.Builder(4231, "ilmenite_slurry")
                .fluid()
                .color(0x6c7078)
                .build();

        IlmeniteSlurry.setFormula("(H2O)(FeTiO3)(?)", true);

        TitanylSulfateSolution = new Material.Builder(4232, "titanyl_sulfate_solution")
                .fluid()
                .color(0x74561d)
                .build();

        TitanylSulfateSolution.setFormula("(H20)(TiO[SO4])(?)", true);

        AcidicWastewater = new Material.Builder(4233, "acidic_wastewater")
                .fluid()
                .color(0xc88a41)
                .build();

        AcidicWastewater.setFormula("(H20)(?)", true);

        DirtyMolecularSieve = new Material.Builder(4234, 'dirty_molecular_sieve')
                .dust()
                .color(0x737373)
                .iconSet(DULL)
                .build();
      
        PotashConcentrate = new Material.Builder(4235, "potash_concentrate")
                .dust()
                .color(0xb39a9a)
                .build();

        ImpurePotashSlurry = new Material.Builder(4236, "impure_potash_slurry")
                .fluid()
                .color(0xb39a9a)
                .build();

        PotashSlurry = new Material.Builder(4237, "potash_slurry")
                .fluid()
                .color(0xd4b2b2)
                .build();

        SupersaturatedBrine = new Material.Builder(4238, "supersaturated_brine")
                .fluid()
                .color(0xdbb56e)
                .build();
        
        OligomericBisphenolSolution = new Material.Builder(4239, "oligomeric_bisphenol_solution")
                .fluid()
                .color(0xcfa532)
                .build();

        ImpureBariteSlurry = new Material.Builder(4240, "impure_barite_slurry")
                .fluid()
                .color(0x87a2ab)
                .build();

        BariteSlurry = new Material.Builder(4241, "barite_slurry")
                .fluid()
                .color(0x8fb3bf)
                .build();

        GraniteTailingSlurry = new Material.Builder(4242, "granite_tailing_slurry")
                .fluid()
                .color(0xc48072)
                .build();

        GalenaSlurry = new Material.Builder(4243, "galena_slurry")
                .fluid()
                .color(0x6a3678)
                .build();

        ByproductSphaleriteSlurry = new Material.Builder(4244, "byproduct_sphalerite_slurry")
                .fluid()
                .color(0x9f97a1)
                .build();

        ImpureCerussiteSlurry = new Material.Builder(4245, "impure_cerussite_slurry")
                .fluid()
                .color(0xe5a6f5)
                .build();

        CerussiteSlurry = new Material.Builder(4246, "cerussite_slurry")
                .fluid()
                .color(0xdf8cf5)
                .build();

        ImpureAnglesiteSlurry = new Material.Builder(4247, "impure_anglesite_slurry")
                .fluid()
                .color(0x8f60d1)
                .build();

        AnglesiteSlurry = new Material.Builder(4248, "anglesite_slurry")
                .fluid()
                .color(0x854ad9)
                .build();

        ImpureSpodumeneSlurry = new Material.Builder(4249, "impure_spodumene_slurry")
                .fluid()
                .color(0xde9eb6)
                .build();

        SpodumeneSlurry = new Material.Builder(4250, "spodumene_slurry")
                .fluid()
                .color(0xffb5d1)
                .build();
                
        PegmatiteTailingSlurry = new Material.Builder(4251, "pegmatite_tailing_slurry")
                .fluid()
                .color(0x2c4a2d)
                .build();

        FilteredPhosphateSlurry = new Material.Builder(4252, "filtered_phosphate_slurry")
                .fluid()
                .color(0x918e27)
                .build();

        PhosphateConcentrateSlurry = new Material.Builder(4253, "phosphate_concentrate_slurry")
                .fluid()
                .color(0xadaa32)
                .build();

        ImpureCassiteriteSlurry = new Material.Builder(4254, "impure_cassiterite_slurry")
                .fluid()
                .color(0xbdbdbd)
                .build();

        CassiteriteSlurry = new Material.Builder(4255, "cassiterite_slurry")
                .fluid()
                .color(0xdcdcdc)
                .build();

        LimestoneTailingSlurry = new Material.Builder(4256, "limestone_tailing_slurry")
                .fluid()
                .color(0x68695d)
                .build();

        ImpureMalachiteSlurry = new Material.Builder(4257, "impure_malachite_slurry")
                .fluid()
                .color(0x104006)
                .build();

        MalachiteSlurry = new Material.Builder(4258, "malachite_slurry")
                .fluid()
                .color(0x155f05)
                .build();

        ImpureChalcopyriteSlurry = new Material.Builder(4259, "impure_chalcopyrite_slurry")
                .fluid()
                .color(0x856119)
                .build();

        CopperMatteFlueDust = new Material.Builder(4260, "copper_matte_flue")
                .dust()
                .color(0x3e146e)
                .iconSet(DULL)
                .build();

        ImpureBorniteSlurry = new Material.Builder(4261, "impure_bornite_slurry")
                .fluid()
                .color(0x7d511d)
                .build();

        CopperMatteFlueGas = new Material.Builder(4262, "copper_matte_flue_gas")
                .fluid()
                .color(0x3e146e)
                .build();

        ImpureChalcociteSlurry = new Material.Builder(4263, "impure_chalcocite_slurry")
                .fluid()
                .color(0x262424)
                .build();

        ZSMFive = new Material.Builder(4264, "zsm_five")
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x739133)
                .build();

        MalachiteLeach = new Material.Builder(4265, "malachite_leach")
                .fluid()
                .color(0x0f6880)
                .build();

        OxidizedMalachiteLeach = new Material.Builder(4266, "oxidized_malachite_leach")
                .fluid()
                .color(0x1a728a)
                .build();

        PyriteSlurry = new Material.Builder(4267, "pyrite_slurry")
                .fluid()
                .color(0x967828)
                .build();

        CopperConcentrateSlurry = new Material.Builder(4268, "copper_concentrate_slurry")
                .fluid()
                .color(0xff6400)
                .build();

        CopperConcentrate = new Material.Builder(4269, "copper_concentrate")
                .dust()
                .color(0xff6400)
                .iconSet(SAND)
                .build();

        CopperMatte = new Material.Builder(4270, "copper_matte")
                .dust()
                .color(0x5c3d08)
                .build();

        BlisterCopper = new Material.Builder(4271, "blister_copper")
                .ingot()
                .flags(GENERATE_PLATE)
                .color(0x6e4c14)
                .iconSet(SHINY)
                .build();

        SiftedScheelite = new Material.Builder(4272, "sifted_scheelite")
                .dust()
                .color(0xc88c14)
                .iconSet(SAND)
                .build();

        ImpureScheeliteSlurry = new Material.Builder(4273, "impure_scheelite_slurry")
                .fluid()
                .color(0xb37d12)
                .build();

        ScheeliteSlurry = new Material.Builder(4274, "scheelite_slurry")
                .fluid()
                .color(0xc88c14)
                .build();

        FlotatedScheelite = new Material.Builder(4275, "flotated_scheelite")
                .dust()
                .color(0xc88c14)
                .iconSet(SHINY)
                .build();

        CalcinedScheelite = new Material.Builder(4276, "calcined_scheelite")
                .dust()
                .color(0xc88c14)
                .iconSet(FLINT)
                .build();

        SiftedWolframite = new Material.Builder(4277, "sifted_wolframite")
                .dust()
                .color(0x1e1c36)
                .iconSet(SAND)
                .build();

        ImpureWolframiteSlurry = new Material.Builder(4278, "impure_wolframite_slurry")
                .fluid()
                .color(0x373559)
                .build();

        WolframiteSlurry = new Material.Builder(4279, "wolframite_slurry")
                .fluid()
                .color(0x1e1c36)
                .build();

        FlotatedWolframite = new Material.Builder(4280, "flotated_wolframite")
                .dust()
                .color(0x1e1c36)
                .iconSet(SHINY)
                .build();

        SilicateFreeTungstateSolution = new Material.Builder(4281, "silicate_free_tungstate_solution")
                .fluid()
                .color(0x2c8576)
                .build();

        MolybdenumFreeTungstateSolution = new Material.Builder(4282, "molybdenum_free_tungstate_solution")
                .fluid()
                .color(0x25889c)
                .build();

        IsodecanalMixture = new Material.Builder(4283, "isodecanal_mixture")
                .fluid()
                .color(0xadad45)
                .build();

        TungstenExtractionMixture = new Material.Builder(4284, "tungsten_extraction_mixture")
                .fluid()
                .color(0xbfb341)
                .build();

        TungstenExtract = new Material.Builder(4285, "tungsten_extract")
                .fluid()
                .color(0x9e7c2e)
                .build();

        ScrubbedTungstenExtract = new Material.Builder(4286, "scrubbed_tungsten_extract")
                .fluid()
                .color(0x85a825)
                .build();

        ImpureMolybdeniteSlurry = new Material.Builder(4287, "impure_molybdenite_slurry")
                .fluid()
                .color(0x131313)
                .build();

        MolybdeniteSlurry = new Material.Builder(4288, "molybdenite_slurry")
                .fluid()
                .color(0x191919)
                .build();

        FlotatedMolybdenite = new Material.Builder(4289, "flotated_molybdenite")
                .dust()
                .color(0x191919)
                .iconSet(SHINY)
                .build();

        CopperMolybdeniteSlurry = new Material.Builder(4290, "copper_molybdenite_slurry")
                .fluid()
                .color(0x2e2419)
                .build();

        ImpureZirconSlurry = new Material.Builder(4291, "impure_zircon_slurry")
                .fluid()
                .color(0xdb6960)
                .build();

        ZirconSlurry = new Material.Builder(4292, "zircon_slurry")
                .fluid()
                .color(0xf05c51)
                .build();

        HafniumExtractionMixture = new Material.Builder(4293, "hafnium_extraction_mixture")
                .fluid()
                .color(0xc1e3d3)
                .build();

        HafniumExtract = new Material.Builder(4294, "hafnium_extract")
                .fluid()
                .color(0xc1e3d9)
                .build();

        AminatedEthyleneMixture = new Material.Builder(4295, "aminated_ethylene_mixture")
      		.fluid()
      		.color(0xb9a9db)
      		.build();
             
      	NeutralizedAminatedEthyleneMixture = new Material.Builder(4296, "neutralized_aminated_ethylene_mixture")
      		.fluid()
      		.color(0x8a819c)
      		.build();

        SiftedPyrochlore = new Material.Builder(4297, "sifted_pyrochlore")
                .dust()
                .color(0x2b1100)
                .iconSet(SAND)
                .build();

        PyrochloreConcentrate = new Material.Builder(4298, "pyrochlore_concentrate")
                .dust()
                .color(0x2b1100)
                .iconSet(DULL)
                .build();

        ImpurePyrochloreSlurry = new Material.Builder(4299, "impure_pyrochlore_slurry")
                .fluid()
                .color(0x230300)
                .build();

        PyrochloreSlurry = new Material.Builder(4300, "pyrochlore_slurry")
                .fluid()
                .color(0x2b1100)
                .build();

        FlotatedPyrochlore = new Material.Builder(4301, "flotated_pyrochlore")
                .dust()
                .color(0x2b1100)
                .iconSet(SHINY)
                .build();

        RoastedPyrochlore = new Material.Builder(4302, "roasted_pyrochlore")
                .dust()
                .color(0x230300)
                .iconSet(DULL)
                .build();

        DigestedPyrochlore = new Material.Builder(4303, "digested_pyrochlore")
                .dust()
                .color(0x230300)
                .iconSet(QUARTZ)
                .build();

        ImpureNiobiumPentachloride = new Material.Builder(4304, "impure_niobium_pentachloride")
                .fluid()
                .color(0xb0c8b8)
                .build();

        SiftedColumbite = new Material.Builder(4305, "sifted_columbite")
                .dust()
                .color(0x574f2f)
                .iconSet(SAND)
                .build();

        ColumbiteConcentrate = new Material.Builder(4306, "columbite_concentrate")
                .dust()
                .color(0x574f2f)
                .iconSet(DULL)
                .build();

        ImpureColumbiteSlurry = new Material.Builder(4307, "impure_columbite_slurry")
                .fluid()
                .color(0x3d3720)
                .build();

        ColumbiteSlurry = new Material.Builder(4308, "columbite_slurry")
                .fluid()
                .color(0x574f2f)
                .build();

        FlotatedColumbite = new Material.Builder(4309, "flotated_columbite")
                .dust()
                .color(0x574f2f)
                .iconSet(SHINY)
                .build();

        ImpureFluoroniobicAcidSolution = new Material.Builder(4310, "impure_fluoroniobic_acid_solution")
                .fluid()
                .color(0x502b75)
                .build();

        NiobiumRichExtract = new Material.Builder(4311, "niobium_rich_extract")
                .fluid()
                .color(0x4a2894)
                .build();

        MetalSulfateWaste = new Material.Builder(4312, "metal_sulfate_waste")
                .fluid()
                .color(0x947728)
                .build();

        ScrubbedNiobiumRichExtract = new Material.Builder(4313, "scrubbed_niobium_rich_extract")
                .fluid()
                .color(0x5a34ad)
                .build();

        DilutedTantalumExtract = new Material.Builder(4314, "diluted_tantalum_extract")
                .fluid()
                .color(0xd99152)
                .build();

        FluoroniobicAcidSolution = new Material.Builder(4315, "fluoroniobic_acid_solution")
                .fluid()
                .color(0x48147d)
                .build();

        DilutedNiobiumExtract = new Material.Builder(4316, "diluted_niobium_extract")
                .fluid()
                .color(0xa46edb)
                .build();

        SiftedTantalite = new Material.Builder(4317, "sifted_tantalite")
                .dust()
                .color(0x915028)
                .iconSet(SAND)
                .build();

        TantaliteConcentrate = new Material.Builder(4318, "tantalite_concentrate")
                .dust()
                .color(0x915028)
                .iconSet(DULL)
                .build();

        ImpureTantaliteSlurry = new Material.Builder(4319, "impure_tantalite_slurry")
                .fluid()
                .color(0x915028)
                .build();

        TantaliteSlurry = new Material.Builder(4320, "tantalite_slurry")
                .fluid()
                .color(0x915028)
                .build();

        FlotatedTantalite = new Material.Builder(4321, "flotated_tantalite")
                .dust()
                .color(0x915028)
                .iconSet(SHINY)
                .build();

        ImpureFluorotantalicAcidSolution = new Material.Builder(4322, "impure_fluorotantalic_acid_solution")
                .fluid()
                .color(0x753a10)
                .build();

        TantalumRichExtract = new Material.Builder(4323, "tantalum_rich_extract")
                .fluid()
                .color(0x9c5625)
                .build();

        ScrubbedTantalumRichExtract = new Material.Builder(4324, "scrubbed_tantalum_rich_extract")
                .fluid()
                .color(0xb56731)
                .build();

        HydrofluoricAmmoniaMixture = new Material.Builder(4325, "hydrofluoric_ammonia_mixture")
                .fluid()
                .color(0x5247b5)
                .build();

        MolybdeniteFlueGas = new Material.Builder(4326, "molybdenite_flue_gas")
                .fluid()
                .color(0x464e61)
                .build();

        RheniumRichFlue = new Material.Builder(4327, "rhenium_rich_flue")
                .dust()
                .color(0x384b75)
                .build();

        ScrubbedPerrhenateSolution = new Material.Builder(4328, "scrubbed_perrhenate_solution")
                .fluid()
                .color(0x3c70bd)
                .build();

        AlphaOlefinMixture = new Material.Builder(4329, "alpha_olefin_mixture")
                .fluid()
                .color(0xd15298)
                .build();
                
        EightTwentyOlefinMixture = new Material.Builder(4330, "eight_twenty_olefin_mixture")
                .fluid()
                .color(0xa31d53)
                .build();
                
        NineTwentyOneAldehydeMixture = new Material.Builder(4331, "nine_twenty_one_aldehyde_mixture")
                .fluid()
                .color(0x911da3)
                .build();
                
        NineTwentyOneFattyAcidMixture = new Material.Builder(4332, "nine_twenty_one_fatty_acid_mixture")
                .fluid()
                .color(0xa37b1d)
                .build();
        
        HZSMFive = new Material.Builder(4333, "hzsm_five")
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x75a118)
                .build();

        FunctionalizableCrosslinkedPolystyrene = new Material.Builder(4334, "functionalizable_crosslinked_polystyrene")
                .ingot().fluid()
                .flags(GENERATE_ROUND)
                .color(0x8689cf)
                .build();

        TantalumExtract = new Material.Builder(4335, "tantalum_extract")
                .fluid()
                .color(0xc97328)
                .build();
    }
}