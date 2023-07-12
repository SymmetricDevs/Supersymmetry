package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*
import gregtech.api.util.GTUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

public class UnknownCompositionMaterials {
 
    public static void register() {

        log.infoMC("Registering Unknown Composition Materials!");

        EarthGreenhouseGas = new Material.Builder(4000, GTUtility.gregtechId("greenhouse_gases"))
            .fluid(FluidTypes.GAS)
            .color(0x95cade)
            .build();

        Asphalt = new Material.Builder(4001, GTUtility.gregtechId("asphalt"))
                .dust()
                .color(0x000000)
                .build();

        BlackAsh = new Material.Builder(4002, GTUtility.gregtechId('black_ash'))
                .dust()
                .color(0x000000)
                .colorAverage()
                .build();

        MolecularSieve = new Material.Builder(4003, GTUtility.gregtechId('molecular_sieve'))
                .dust()
                .iconSet(SHINY)
                .color(0x737373)
                .colorAverage()
                .build();

        WetMolecularSieve = new Material.Builder(4004, GTUtility.gregtechId('wet_molecular_sieve'))
                .dust()
                .iconSet(SHINY)
                .color(0x5c5c5c)
                .colorAverage()
                .build();

        RawMolecularSieve = new Material.Builder(4005, GTUtility.gregtechId("raw_molecular_sieve"))
                .fluid()
                .color(0x8c94a8)
                .build();

        FlueGas = new Material.Builder(4006, GTUtility.gregtechId('flue_gas'))
                .fluid(FluidTypes.GAS)
                .color(0x484a48)
                .fluidTemp(1000)
                .build();

        ExhaustSteam = new Material.Builder(4007, GTUtility.gregtechId('exhaust_steam'))
                .fluid(FluidTypes.GAS)
                .color(0xc4c4c4)
                .fluidTemp(373)
                .build();

        SmokeBombMix = new Material.Builder(4008, GTUtility.gregtechId('smoke_bomb_mix'))
                .fluid(FluidTypes.GAS)
                .color(0x515443)
                .build();

        SugaryWater = new Material.Builder(4009, GTUtility.gregtechId("sugary_water"))
                .fluid()
                .color(0x8fbf9b)
                .build();

        ClarifiedSugaryWater = new Material.Builder(4010, GTUtility.gregtechId("clarified_sugary_water"))
                .fluid()
                .color(0xa7d6b3)
                .build();

        Brine = new Material.Builder(4011, GTUtility.gregtechId("brine"))
                .fluid()
                .color(0xd1d08e)
                .build();

        ImpureSodiumAluminateSolution = new Material.Builder(4012, GTUtility.gregtechId("impure_sodium_aluminate_solution"))
                .fluid()
                .color(0x5b80ba)
                .build();

        RedMud = new Material.Builder(4013, GTUtility.gregtechId("red_mud"))
                .fluid()
                .color(0x913f2d)
                .build();

        ImpureSodaAshSolution = new Material.Builder(4014, GTUtility.gregtechId("impure_soda_ash_solution"))
                .fluid()
                .color(0x91919b)
                .build();

        ImpureSodiumHydroxideSolution = new Material.Builder(4015, GTUtility.gregtechId("impure_sodium_hydroxide_solution"))
                .fluid()
                .color(0x3a4991)
                .build();

        ConcentratedRedMud = new Material.Builder(4016, GTUtility.gregtechId("concentrated_red_mud"))
                .fluid()
                .color(0x824133)
                .build();

        AmmoniaReactionMix = new Material.Builder(4017, GTUtility.gregtechId("ammonia_reaction_mix"))
                .fluid(FluidTypes.GAS)
                .color(0x38478a)
                .fluidTemp(400)
                .build();

        AmmoniaRichGas = new Material.Builder(4018, GTUtility.gregtechId("ammonia_rich_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x345691)
                .fluidTemp(400)
                .build();

        PalladiumContainingSolution = new Material.Builder(4019, GTUtility.gregtechId("palladium_containing_solution"))
                .fluid()
                .color(0x808080)
                .build();

        Mash = new Material.Builder(4020, GTUtility.gregtechId("mash"))
                .fluid()
                .color(0x9e8660)
                .build();

        WeedKiller = new Material.Builder(4021, GTUtility.gregtechId("weed_killer"))
                .fluid()
                .color(0xade677)
                .build();

        Pesticide = new Material.Builder(4022, GTUtility.gregtechId("pesticide"))
                .fluid()
                .color(0xc0c77d)
                .build();

        GrainSolution = new Material.Builder(4023, GTUtility.gregtechId("grain_solution"))
                .fluid()
                .color(0xc2cc9d)
                .build();

        YeastSolution = new Material.Builder(4024, GTUtility.gregtechId("yeast_solution"))
                .fluid()
                .color(0xe6e3aa)
                .build();

        ImpureEthanol = new Material.Builder(4025, GTUtility.gregtechId("impure_ethanol"))
                .fluid()
                .color(0xbf9c77)
                .build();

        BorateLiquor = new Material.Builder(4026, GTUtility.gregtechId("borate_liquor"))
                .fluid()
                .color(0xacbbac)
                .build();

        ImpureAcetaldehyde = new Material.Builder(4027, GTUtility.gregtechId("impure_acetaldehyde"))
                .fluid()
                .color(0x6e6e6e)
                .build();

        CativaProcessPreparation = new Material.Builder(4028, GTUtility.gregtechId("cativa_process_preparation"))
                .fluid()
                .color(0x9c8275)
                .build();

        CativaProcessSolution = new Material.Builder(4029, GTUtility.gregtechId("cativa_process_solution"))
                .fluid()
                .color(0x75665e)
                .build();

        AcidicCumene = new Material.Builder(4030, GTUtility.gregtechId("acidic_cumene"))
                .fluid()
                .color(0x571a0b)
                .build()

        RearrangedCumene = new Material.Builder(4031, GTUtility.gregtechId("rearranged_cumene"))
                .fluid()
                .color(0x4f2f27)
                .build();

        AlkylatedButane = new Material.Builder(4032, GTUtility.gregtechId("alkylated_butane"))
                .fluid()
                .color(0x6e4c2c)
                .build();

        ImpureKaptonK = new Material.Builder(4033, GTUtility.gregtechId("impure_kapton_k"))
                .fluid()
                .color(0xe0b53f)
                .build();

        ImpureKaptonE = new Material.Builder(4034, GTUtility.gregtechId("impure_kapton_e"))
                .fluid()
                .color(0xcad96f)
                .build();

        KaptonEPreparation = new Material.Builder(4035, GTUtility.gregtechId("kapton_e_preparation"))
                .fluid()
                .color(0x899444)
                .build();

        ImpureDiiodobenzene = new Material.Builder(4036, GTUtility.gregtechId("impure_diiodobenzene"))
                .fluid()
                .color(0x736c63)
                .build();

        ImpureEthyleneOxide = new Material.Builder(4037, GTUtility.gregtechId("impure_ethylene_oxide"))
                .fluid(FluidTypes.GAS)
                .color(0x52755c)
                .build();

        AmocoProcessCatalyst = new Material.Builder(4038, GTUtility.gregtechId("amoco_process_catalyst"))
                .dust()
                .iconSet(SHINY)
                .color(0xdea68c)
                .build();

        GraniteTailings = new Material.Builder(4039, GTUtility.gregtechId("granite_tailings"))
                .dust()
                .color(0x302323)
                .build();

        LimestoneTailings = new Material.Builder(4040, GTUtility.gregtechId("limestone_tailings"))
                .dust()
                .color(0x68695d)
                .build();

        PegmatiteTailings = new Material.Builder(4041, GTUtility.gregtechId("pegmatite_tailings"))
                .dust()
                .color(0x1f1c1c)
                .build();

        UltramaficTailings = new Material.Builder(4042, GTUtility.gregtechId("ultramafic_tailings"))
                .dust()
                .color(0x141414)
                .build();

        Corundum = new Material.Builder(4043, GTUtility.gregtechId("corundum"))
                .dust()
                .iconSet(SHINY)
                .color(0x7a4261)
                .build();

        Tourmaline = new Material.Builder(4044, GTUtility.gregtechId("tourmaline"))
                .dust().gem()
                .iconSet(SHINY)
                .color(0x8c613f)
                .build();

        NonMarineEvaporite = new Material.Builder(4045, GTUtility.gregtechId("non_marine_evaporite"))
                .dust()
                .color(0x78756d)
                .build();

        HalideEvaporite = new Material.Builder(4046, GTUtility.gregtechId("halide_evaporite"))
                .dust()
                .color(0x99867c)
                .build();

        CarbonateEvaporite = new Material.Builder(4047, GTUtility.gregtechId("carbonate_evaporite"))
                .dust()
                .color(0xe3e3e3)
                .build();

        SulfateEvaporite = new Material.Builder(4048, GTUtility.gregtechId("sulfate_evaporite"))
                .dust()
                .color(0xc7c0b1)
                .build();

        Vinegar = new Material.Builder(4049, GTUtility.gregtechId("vinegar"))
                .fluid()
                .color(0xc3c4b3)
                .build();

        RawCellulose = new Material.Builder(4050, GTUtility.gregtechId("raw_cellulose"))
                .dust()
                .color(0x302b1a)
                .build();

        WhiteLiquor = new Material.Builder(4051, GTUtility.gregtechId("white_liquor"))
                .fluid()
                .color(0xd9d3c1)
                .build();

        BlackLiquor = new Material.Builder(4052, GTUtility.gregtechId("black_liquor"))
                .fluid()
                .color(0x2e2a1f)
                .build();

        ConcentratedBlackLiquor = new Material.Builder(4053, GTUtility.gregtechId("concentrated_black_liquor"))
                .fluid()
                .color(0x1f1d18)
                .build();

        GreenLiquor = new Material.Builder(4054, GTUtility.gregtechId("green_liquor"))
                .fluid()
                .color(0x2b4536)
                .build();

        AcidicCelluloseSolution = new Material.Builder(4055, GTUtility.gregtechId("acidic_cellulose_solution"))
                .fluid()
                .color(0xb7bd60)
                .build();

        Wastewater = new Material.Builder(4056, GTUtility.gregtechId("wastewater"))
                .fluid()
                .color(0x2d402f)
                .build();

        HeatedWastewater = new Material.Builder(4057, GTUtility.gregtechId("heated_wastewater"))
                .fluid()
                .fluidTemp(340)
                .color(0x435e46)
                .build();

        FlocculatedWastewater = new Material.Builder(4058, GTUtility.gregtechId("flocculated_wastewater"))
                .fluid()
                .color(0x435e46)
                .build();

        FilteredWastewater = new Material.Builder(4059, GTUtility.gregtechId("filtered_wastewater"))
                .fluid()
                .color(0x457568)
                .build();

        WastewaterSludge = new Material.Builder(4060, GTUtility.gregtechId("wastewater_sludge"))
                .fluid()
                .color(0x2b1e1e)
                .build();

        CarburizedStainlessSteel = new Material.Builder(4061, GTUtility.gregtechId('carburized_stainless_steel'))
                .dust().fluid()
                .fluidTemp(1500)
                .color(0x6b6552)
                .build()

        UnscrubbedWoodGas = new Material.Builder(4062, GTUtility.gregtechId("unscrubbed_wood_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x85806f)
                .build();

        LightOil = new Material.Builder(4063, GTUtility.gregtechId("light_oil"))
                .fluid()
                .color(0x5e5e4d)
                .build();

        NaphthaleneOil = new Material.Builder(4065, GTUtility.gregtechId("naphthalene_oil"))
                .fluid()
                .color(0x2e2926)
                .build();

        AnthraceneOil = new Material.Builder(4066, GTUtility.gregtechId("anthracene_oil"))
                .fluid()
                .color(0x211f1e)
                .build();

        AlkalineNaphthaleneOil = new Material.Builder(4067, GTUtility.gregtechId("alkaline_naphthalene_oil"))
                .fluid()
                .color(0x403833)
                .build();

        PurifiedNaphthaleneOil = new Material.Builder(4068, GTUtility.gregtechId("purified_naphthalene_oil"))
                .fluid()
                .color(0x595542)
                .build();

        AcidicLightOil = new Material.Builder(4069, GTUtility.gregtechId("acidic_light_oil"))
                .fluid()
                .color(0x87816c)
                .build();

        CrudePyridiniumSulfate = new Material.Builder(4070, GTUtility.gregtechId("crude_pyridinium_sulfate"))
                .fluid()
                .color(0x48523b)
                .build();

        ImpurePyridine = new Material.Builder(4071, GTUtility.gregtechId("impure_pyridine"))
                .fluid()
                .color(0x233326)
                .build();

        AcidicAnthraceneOil = new Material.Builder(4072, GTUtility.gregtechId("acidic_anthracene_oil"))
                .fluid()
                .color(0x87816c)
                .build();

        AnthraceneExtract = new Material.Builder(4073, GTUtility.gregtechId("anthracene_extract"))
                .fluid()
                .color(0x211c1c)
                .build();

        CrudeQuinoliniumSulfate = new Material.Builder(4074, GTUtility.gregtechId("crude_quinolinium_sulfate"))
                .fluid()
                .color(0x1b1c0a)
                .build();

        ImpureQuinoline = new Material.Builder(4075, GTUtility.gregtechId("impure_quinoline"))
                .fluid()
                .color(0x222418)
                .build();

        ConcentratedBrine = new Material.Builder(4076, GTUtility.gregtechId("concentrated_brine"))
                .fluid()
                .color(0xa6a444)
                .build();

        BoronFreeBrine = new Material.Builder(4078, GTUtility.gregtechId("boron_free_brine"))
                .fluid()
                .color(0xa68a44)
                .build();

        LithiumFreeBrine = new Material.Builder(4079, GTUtility.gregtechId("lithium_free_brine"))
                .fluid()
                .color(0xa17a4c)
                .build();

        ChlorinatedBrine = new Material.Builder(4080, GTUtility.gregtechId("chlorinated_brine"))
                .fluid()
                .color(0xa3b560)
                .build();

        ImpureBromine = new Material.Builder(4081, GTUtility.gregtechId("impure_bromine"))
                .fluid(FluidTypes.GAS)
                .color(0x572d2b)
                .build();

        ChilledLava = new Material.Builder(4082, GTUtility.gregtechId("chilled_lava"))
                .color(0x4d2d25)
                .fluidTemp(400)
                .build();

        ChilledFlueGas = new Material.Builder(4083, GTUtility.gregtechId("chilled_flue_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x171717)
                .fluidTemp(400)
                .build();

        WoodAsh = new Material.Builder(4084, GTUtility.gregtechId("wood_ash"))
                .dust()
                .color(0x242221)
                .build();

        VeryConcentratedBrine = new Material.Builder(4085, GTUtility.gregtechId("very_concentrated_brine"))
                .fluid()
                .color(0xb5b226)
                .build();

        LangbeiniteLeach = new Material.Builder(4086, GTUtility.gregtechId("langbeinite_leach"))
                .fluid()
                .color(0x9c9a87)
                .build();

        PolyhaliteLeach = new Material.Builder(4087, GTUtility.gregtechId("polyhalite_leach"))
                .fluid()
                .color(0xb3a094)
                .build();

        TinDross = new Material.Builder(4088, GTUtility.gregtechId("tin_dross"))
                .dust().fluid()
                .fluidTemp(600)
                .color(0x2a2e2e)
                .build();

        DecopperizedTin = new Material.Builder(4089, GTUtility.gregtechId("decopperized_tin"))
                .dust().fluid()
                .fluidTemp(600)
                .color(0xb5b7c9)
                .build();

        KainiteLeach = new Material.Builder(4090, GTUtility.gregtechId("kainite_leach"))
                .fluid()
                .color(0xadb07f)
                .build();

        Zeolite13X = new Material.Builder(4091, GTUtility.gregtechId("zeolite_13"))
                .dust()
                .iconSet(SHINY)
                .color(0xe4e8bc)
                .build();

        Zeolite13XSolution = new Material.Builder(4092, GTUtility.gregtechId("zeolite_13_solution"))
                .fluid()
                .color(0xe4e8bc)
                .build();

        LTSCatalyst = new Material.Builder(4093, GTUtility.gregtechId("lts_catalyst"))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .color(0x756857)
                .build();

        HTSCatalyst = new Material.Builder(4094, GTUtility.gregtechId("hts_catalyst"))
                .dust()
                .color(0x5e4f4f)
                .build();

        SpentBismuthCatalyst = new Material.Builder(4095, GTUtility.gregtechId("spent_bismuth_catalyst"))
                .dust()
                .color(0x31403f)
                .build();

        AlkalineSodiumOleateSolution = new Material.Builder(4096, GTUtility.gregtechId("alkaline_sodium_oleate_solution"))
                .fluid()
                .color(0xa6b584)
                .build();

        FattyAcidSolution = new Material.Builder(4097, GTUtility.gregtechId("fatty_acid_solution"))
                .fluid()
                .color(0xa1ad5c)
                .build();

        OleicAcidSolution = new Material.Builder(4098, GTUtility.gregtechId("oleic_acid_solution"))
                .fluid()
                .color(0x8dbf67)
                .build();

        AluminiumSilicateLeach = new Material.Builder(4099, GTUtility.gregtechId("aluminium_silicate_leach"))
                .fluid()
                .color(0x587682)
                .build();

        AlkaliAlumMix = new Material.Builder(4100, GTUtility.gregtechId("alkali_alum_mix"))
                .iconSet(SHINY)
                .dust()
                .color(0xe34949)
                .build();

        AmblygoniteLeach = new Material.Builder(4101, GTUtility.gregtechId("amblygonite_leach"))
                .fluid()
                .color(0xbaced6)
                .build();

        RoastedLepidolite = new Material.Builder(4102, GTUtility.gregtechId("roasted_lepidolite"))
                .dust()
                .color(0x443b45)
                .iconSet(SAND)
                .build();

        LepidoliteLeach = new Material.Builder(4103, GTUtility.gregtechId("lepidolite_leach"))
                .fluid()
                .color(0x805066)
                .build();

        NeutralizedLepidoliteLeach = new Material.Builder(4104, GTUtility.gregtechId("neutralized_lepidolite_leach"))
                .fluid()
                .color(0x675d85)
                .build();

        AluminiumFreeLepidoliteLeach = new Material.Builder(4105, GTUtility.gregtechId("aluminium_free_lepidolite_leach"))
                .fluid()
                .color(0x557365)
                .build();

        GoldLeachSolution = new Material.Builder(4106, GTUtility.gregtechId("gold_leach_solution"))
                .fluid()
                .color(0x9c8a46)
                .build();

        PhosphatePulp = new Material.Builder(4107, GTUtility.gregtechId("phosphate_pulp"))
                .dust()
                .color(0x8c7e2a)
                .iconSet(SAND)
                .build();

        FilteredPhosphatePulp = new Material.Builder(4108, GTUtility.gregtechId("filtered_phosphate_pulp"))
                .dust()
                .color(0x8c7e2a)
                .iconSet(SHINY)
                .build();

        PhosphateConcentrate = new Material.Builder(4109, GTUtility.gregtechId("phosphate_concentrate"))
                .dust()
                .color(0xd1b615)
                .iconSet(SHINY)
                .build();

        Phosphogypsum = new Material.Builder(4110, GTUtility.gregtechId("phosphogypsum"))
                .dust()
                .color(0xd1cba7)
                .iconSet(DULL)
                .build();
      
        ImpureAmmoniumFluoroberyllateSolution = new Material.Builder(4111, GTUtility.gregtechId("ammonium_fluoroberyllate_solution"))
                .fluid()
                .color(0x1b8541)
                .build();

        //ImpureAmmoniumFluoroberyllateSolution.setFormula("(?)(NH4)2(BeF4)(H2O)3", true)

        ImpureBerylliumSulfateSolution = new Material.Builder(4112, GTUtility.gregtechId("impure_beryllium_sulfate_solution"))
                .fluid()
                .color(0x608726)
                .build();

        ImpureLithiumSulfateSolution = new Material.Builder(4113, GTUtility.gregtechId("impure_lithium_sulfate_solution"))
                .fluid()
                .color(0xf0bc89)
                .build();

        GalenaByproductsSlurry = new Material.Builder(4114, GTUtility.gregtechId("galena_byproducts_slurry"))
                .fluid()
                .color(0x592880)
                .build();

        SinteredLeadConcentrate = new Material.Builder(4115, GTUtility.gregtechId("sintered_lead_concentrate"))
                .dust()
                .color(0x3a1954)
                .iconSet(SAND)
                .build();

        CadmiumRichFlueDust = new Material.Builder(4116, GTUtility.gregtechId("cadmium_rich_flue_dust"))
                .dust()
                .color(0x757061)
                .iconSet(DULL)
                .build();

        BlackMetal = new Material.Builder(4117, GTUtility.gregtechId("black_metal"))
                .dust()
                .color(0x3d3440)
                .build();

        AntimonyArsenicFlueDust = new Material.Builder(4118, GTUtility.gregtechId("antimony_arsenic_flue_dust"))
                .dust()
                .color(0x707063)
                .iconSet(DULL)
                .build();

        BurnedBlackMetal = new Material.Builder(4119, GTUtility.gregtechId("burned_black_metal"))
                .dust()
                .color(0x3d3440)
                .iconSet(DULL)
                .build();

        LithargeSlag = new Material.Builder(4120, GTUtility.gregtechId("litharge_slag"))
                .dust()
                .color(0xb5443c)
                .iconSet(DULL)
                .build();

        HarrisSlag = new Material.Builder(4121, GTUtility.gregtechId("harris_slag"))
                .dust()
                .color(0xabb074)
                .iconSet(DULL)
                .build();

        SodiumArsenateStannateSolution = new Material.Builder(4122, GTUtility.gregtechId("sodium_arsenate_stannate_solution"))
                .fluid()
                .color(0x5c3a23)
                .build();
        
        SodiumArsenateStannateMixture = new Material.Builder(4123, GTUtility.gregtechId("sodium_arsenate_stannate_mixture"))
                .dust()
                .color(0x784c2f)
                .build();

        ImpureEthyleneGlycol = new Material.Builder(4124, GTUtility.gregtechId("impure_ethylene_glycol"))
                .fluid()
                .color(0xc8c8e0)
                .build();

        ImpureSaturatedAmmoniacalMethanol = new Material.Builder(4125, GTUtility.gregtechId("impure_saturated_ammoniacal_methanol"))
                .fluid()
                .color(0xad8653)
                .build();

        CarnalliteLeach = new Material.Builder(4126, GTUtility.gregtechId("carnallite_leach"))
                .fluid()
                .color(0xc1c499)
                .build();

        HaliteLeach = new Material.Builder(4127, GTUtility.gregtechId("halite_leach"))
                .fluid()
                .color(0x9bbdbc)
                .build();

        EthylenediaminePyrocatechol = new Material.Builder(4128, GTUtility.gregtechId("ethylenediamine_pyrocatechol"))
                .fluid()
                .color(0x42392f)
                .build();

        CeramicThickFilmPaste = new Material.Builder(4129, GTUtility.gregtechId("ceramic_thick_film_paste"))
                .fluid()
                .color(0x000000)
                .build();

        BoraxElectrolyte = new Material.Builder(4130, GTUtility.gregtechId("borax_electrolyte"))
                .fluid()
                .color(0x85806b)
                .build();

        FerroelectricCeramicBinding = new Material.Builder(4131, GTUtility.gregtechId("ferroelectric_ceramic_binding"))
                .fluid()
                .color(0xede772)
                .build();

        DisproportionatedTrichlorosilane = new Material.Builder(4132, GTUtility.gregtechId('disproportionated_trichlorosilane'))
                .fluid()
                .color(0x849169)
                .build()

        DisproportionatedDichlorosilane = new Material.Builder(4133, GTUtility.gregtechId('disproportionated_dichlorosilane'))
                .fluid()
                .color(0xa1ad86)
                .build()

        DisproportionatedChlorosilane = new Material.Builder(4134, GTUtility.gregtechId('disproportionated_chlorosilane'))
                .fluid()
                .color(0xb5bf9b)
                .build()
      
        MetalNitrateSolution = new Material.Builder(4135, GTUtility.gregtechId("metal_nitrate_solution"))
                .fluid()
                .color(0x663422)
                .build();

        NeutralizedMetalNitrateSolution = new Material.Builder(4136, GTUtility.gregtechId("neutralized_metal_nitrate_solution"))
                .fluid()
                .color(0x734d3f)
                .build();

        MetalNitrateCatalyst = new Material.Builder(4137, GTUtility.gregtechId("metal_nitrate_catalyst"))
                .dust()
                .iconSet(SHINY)
                .color(0xb58877)
                .build();

        TwoEthylhexylPhosphoricAcidMix = new Material.Builder(4138, GTUtility.gregtechId("two_ethylhexyl_phosphoric_acid_mix"))
                .fluid()
                .color(0xd1bb75)
                .build();

        RareEarthCatalystYNd = new Material.Builder(4139, GTUtility.gregtechId("rare_earth_catalyst_y_nd"))
                .dust()
                .color(0x2e2a2a)
                .build();

        DilutedPrimaryAmineN = new Material.Builder(4140, GTUtility.gregtechId("diluted_primary_amine_n"))
                .fluid()
                .color(0x704a9e)
                .build();

        CrosslinkedPolystyrene = new Material.Builder(4141, GTUtility.gregtechId("crosslinked_polystyrene"))
                .ingot().fluid()
                .flags(GENERATE_ROUND)
                .color(0xa7a9d6)
                .build();

        EthyleneGlycolMix = new Material.Builder(4142, GTUtility.gregtechId("ethylene_glycol_mix"))
                .fluid()
                .color(0x2eafc9)
                .build();

        PalladiumDopedCrosslinkedPolystyrene = new Material.Builder(4143, GTUtility.gregtechId("palladium_doped_crosslinked_polystyrene"))
                .ingot().fluid()
                .flags(GENERATE_ROUND)
                .color(0xe0e6bc)
                .build();

        TrialkylaluminiumMixture = new Material.Builder(4144, GTUtility.gregtechId('trialkylaluminium_mixture'))
                .fluid()
                .color(0x6b777d)
                .build()

        //TrialkylaluminiumMixture.setFormula("AlR3", true)

        AluminiumAlkoxideMixture = new Material.Builder(4145, GTUtility.gregtechId('aluminium_alkoxide_mixture'))
                .dust()
                .color(0x657780)
                .build()

        //AluminiumAlkoxideMixture.setFormula("Al(OR)3", true)

        ZieglerAlcoholMixture = new Material.Builder(4146, GTUtility.gregtechId('ziegler_alcohol_mixture'))
                .fluid()
                .color(0xc47631)
                .build()

        AluminiumAlkoxideSolution = new Material.Builder(4148, GTUtility.gregtechId('aluminium_alkoxide_solution'))
                .fluid()
                .color(0x657780)
                .build()

        //AluminiumAlkoxideSolution.setFormula("[(C2H5)2O]Al(OR)3", true)

        CapsaicinSolution = new Material.Builder(4149, GTUtility.gregtechId('capsaicin_solution'))
                .fluid()
                .color(0xd43b2a)
                .build()

        TearGas = new Material.Builder(4150, GTUtility.gregtechId('tear_gas'))
                .fluid()
                .color(0xd1ba5c)
                .build()

        HydratedPropene = new Material.Builder(4151, GTUtility.gregtechId('hydrated_propene'))
                .fluid()
                .color(0xc9997d)
                .build()

        EthylamineMix = new Material.Builder(4152, GTUtility.gregtechId('ethylamine_mix'))
                .fluid()
                .color(0xdbaf48)
                .build()

        ImpureSphaleriteSlurry = new Material.Builder(4153, GTUtility.gregtechId('impure_sphalerite_slurry'))
                .fluid()
                .color(0xa5a690)
                .build()

        UnprocessedSphaleriteSlurry = new Material.Builder(4154, GTUtility.gregtechId('unprocessed_sphalerite_slurry'))
                .fluid()
                .color(0xc7c991)
                .build()

        GalenaSlurry = new Material.Builder(4155, GTUtility.gregtechId('galena_slurry'))
                .fluid()
                .color(0x513d59)
                .build()

        SphaleriteSlurry = new Material.Builder(4156, GTUtility.gregtechId('sphalerite_slurry'))
                .fluid()
                .color(0xb7ba63)
                .build()

        ThalliumRichFlue = new Material.Builder(4157, GTUtility.gregtechId('thallium_rich_flue'))
                .dust()
                .color(0x26222e)
                .build()

        CrudeZinc = new Material.Builder(4158, GTUtility.gregtechId('crude_zinc'))
                .fluid()
                .color(0x565863)
                .build()

        CadmiumRichZinc = new Material.Builder(4159, GTUtility.gregtechId('cadmium_rich_zinc'))
                .fluid()
                .color(0x80849c)
                .build()

        ImpureSmithsoniteSlurry = new Material.Builder(4160, GTUtility.gregtechId('impure_smithsonite_slurry'))
                .fluid()
                .color(0x83a899)
                .build()

        SmithsoniteSlurry = new Material.Builder(4161, GTUtility.gregtechId('smithsonite_slurry'))
                .fluid()
                .color(0x89c9af)
                .build()

        ZincLeach = new Material.Builder(4162, GTUtility.gregtechId('zinc_leach'))
                .fluid()
                .color(0x8c6f58)
                .build()

        ZincLeachResidue = new Material.Builder(4163, GTUtility.gregtechId('zinc_leach_residue'))
                .dust()
                .color(0x33281f)
                .build()

        HotZincLeach = new Material.Builder(4164, GTUtility.gregtechId('hot_zinc_leach'))
                .fluid()
                .fluidTemp(353)
                .color(0xb89e8a)
                .build()

        HotZincLeachResidue = new Material.Builder(4165, GTUtility.gregtechId('hot_zinc_leach_residue'))
                .dust()
                .color(0x3b332d)
                .build()

        ZincRichSlag = new Material.Builder(4166, GTUtility.gregtechId('zinc_rich_slag'))
                .dust()
                .color(0x242323)
                .build()

        ReducedZincLeach = new Material.Builder(4167, GTUtility.gregtechId('reduced_zinc_leach'))
                .fluid()
                .color(0xb38764)
                .build()

        WaelzOxide = new Material.Builder(4168, GTUtility.gregtechId('waelz_oxide'))
                .dust().fluid()
                .color(0x475453)
                .build()

        GermaniumRichSlag = new Material.Builder(4169, GTUtility.gregtechId('germanium_rich_slag'))
                .dust()
                .color(0x2d2e27)
                .build()

        ZincCementationSlurry = new Material.Builder(4170, GTUtility.gregtechId('zinc_cementation_slurry'))
                .fluid()
                .color(0x4f5663)
                .build()

        PrecipitatedZincLeach = new Material.Builder(4171, GTUtility.gregtechId('precipitated_zinc_leach'))
                .fluid()
                .color(0x756d54)
                .build()

        CopperCadmiumResidue = new Material.Builder(4172, GTUtility.gregtechId('copper_cadmium_residue'))
                .dust()
                .color(0x47271d)
                .build()

        HotPrecipitatedZincLeach = new Material.Builder(4173, GTUtility.gregtechId('hot_precipitated_zinc_leach'))
                .fluid()
                .fluidTemp(353)
                .color(0x918a71)
                .build()

        ReprecipitatedZincLeach = new Material.Builder(4174, GTUtility.gregtechId('reprecipitated_zinc_leach'))
                .fluid()
                .color(0x756e54)
                .build()

        CobaltResidue = new Material.Builder(4175, GTUtility.gregtechId('cobalt_residue'))
                .dust()
                .color(0x373b6b)
                .build()
      
        FuselOil = new Material.Builder(4176, GTUtility.gregtechId('fusel_oil'))
                .fluid()
                .color(0xa62403)
                .build()

        AshSlurry = new Material.Builder(4177, GTUtility.gregtechId('ash_slurry'))
                .fluid()
                .color(0x252526)
                .build()

        DesulfurizedFlueGas = new Material.Builder(4178, GTUtility.gregtechId('desulfurized_flue_gas'))
                .fluid(FluidTypes.GAS)
                .color(0x151521)
                .fluidTemp(1000)
                .build()

        CadmiumRichFlueGas = new Material.Builder(4179, GTUtility.gregtechId("cadmium_rich_flue_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x757061)
                .fluidTemp(1000)
                .build();

        AntimonyArsenicFlueGas = new Material.Builder(4180, GTUtility.gregtechId("antimony_arsenic_flue_gas"))
                .fluid(FluidTypes.GAS)
                .color(0x707063)
                .fluidTemp(1000)
                .build();

        ThalliumRichFlueGas = new Material.Builder(4181, GTUtility.gregtechId('thallium_rich_flue_gas'))
                .fluid(FluidTypes.GAS)
                .color(0x26222e)
                .fluidTemp(1000)
                .build()

        FluorinatedOctanoylChlorideMixture = new Material.Builder(4182, GTUtility.gregtechId('fluorinated_octanoyl_chloride_mixture'))
                .fluid()
                .color(0x458583)
                .build()

        ButyraldehydeMixture = new Material.Builder(4183, GTUtility.gregtechId("butyraldehyde_mixture"))
                .fluid()
                .color(0x96920e)
                .build();

        PentanalMixture = new Material.Builder(4184, GTUtility.gregtechId("pentanal_mixture"))
                .fluid()
                .color(0x968450)
                .build();

        SaltRoastedVanadinite = new Material.Builder(4185, GTUtility.gregtechId("salt_roasted_vanadinite"))
                .dust()
                .color(0x2e2b28)
                .build();

        SodaAshRoastedVanadinite = new Material.Builder(4186, GTUtility.gregtechId("soda_ash_roasted_vanadinite"))
                .dust()
                .color(0x38342f)
                .build();

        LeachedSaltRoastedVanadinite = new Material.Builder(4187, GTUtility.gregtechId("leached_salt_roasted_vanadinite"))
                .dust()
                .color(0x403c37)
                .build();

        LeachedSodaAshRoastedVanadinite = new Material.Builder(4188, GTUtility.gregtechId("leached_soda_ash_roasted_vanadinite"))
                .dust()
                .color(0x4d463f)
                .build();

        DissolvedFerrochromium = new Material.Builder(4189, GTUtility.gregtechId("dissolved_ferrochromium"))
                .fluid()
                .color(0xd17979)
                .build();

        CrudeAmmoniumIronIISulfate = new Material.Builder(4190, GTUtility.gregtechId("crude_ammonium_iron_ii_sulfate"))
                .dust()
                .color(0x96cf70)
                .build();

        MohrMotherLiquor = new Material.Builder(4191, GTUtility.gregtechId("mohr_mother_liquor"))
                .fluid()
                .color(0x43a375)
                .build();

        CrudeAmmoniumIronIISulfateSolution = new Material.Builder(4192, GTUtility.gregtechId("crude_ammonium_iron_ii_sulfate_solution"))
                .fluid()
                .fluidTemp(343)
                .color(0x96cf70)
                .build();

        ChromiumAnolyte = new Material.Builder(4193, GTUtility.gregtechId("chromium_anolyte"))
                .fluid()
                .color(0xd97777)
                .build();

        ChromiumCatholyte = new Material.Builder(4194, GTUtility.gregtechId("chromium_catholyte"))
                .fluid()
                .color(0xc45e4f)
                .build();

        ChromiumMotherLiquor = new Material.Builder(4195, GTUtility.gregtechId("chromium_mother_liquor"))
                .fluid()
                .color(0xeb94d1)
                .build();

        ReducedChromiumAnolyte = new Material.Builder(4196, GTUtility.gregtechId("reduced_chromium_anolyte"))
                .fluid()
                .color(0xd9b077)
                .build();
      
        Sienna = new Material.Builder(4197, GTUtility.gregtechId("sienna"))
                .dust()
                .color(0x4a3724)
                .build();

        BurntSienna = new Material.Builder(4198, GTUtility.gregtechId("burnt_sienna"))
                .dust()
                .color(0x662e2e)
                .build();

        ImpureVTMSlurry = new Material.Builder(4199, GTUtility.gregtechId("impure_vtm_slurry"))
                .fluid()
                .color(0x2e1213)
                .build();

        VTMSlurry = new Material.Builder(4200, GTUtility.gregtechId("vtm_slurry"))
                .fluid()
                .color(0x52191b)
                .build();

        SiliconDioxideSlurry = new Material.Builder(4201, GTUtility.gregtechId("silicon_dioxide_slurry"))
                .fluid()
                .color(0x69675b)
                .build();

        VTMConcentrate = new Material.Builder(4202, GTUtility.gregtechId("vtm_concentrate"))
                .dust()
                .color(0x691e21)
                .build();

        VTSlag = new Material.Builder(4203, GTUtility.gregtechId("vt_slag"))
                .dust()
                .color(0x302222)
                .build();

        AlkaliVTSlag = new Material.Builder(4204, GTUtility.gregtechId("alkali_vt_slag"))
                .dust()
                .color(0x3b2531)
                .build();

        TitaniaSlag = new Material.Builder(4205, GTUtility.gregtechId("titania_slag"))
                .dust()
                .color(0x4f2b3f)
                .build();

        RutileSlurry = new Material.Builder(4207, GTUtility.gregtechId("rutile_slurry"))
                .fluid()
                .color(0x575544)
                .build();

        CarnotiteLeach = new Material.Builder(4208, GTUtility.gregtechId("carnotite_leach"))
                .fluid()
                .color(0x929c5c)
                .build();

        ReducedCarnotiteLeach = new Material.Builder(4209, GTUtility.gregtechId("reduced_carnotite_leach"))
                .fluid()
                .color(0x696840)
                .build();

        UraniumVanadiumExtractionMixture = new Material.Builder(4210, GTUtility.gregtechId("uranium_vanadium_extraction_mixture"))
                .fluid()
                .color(0xd4d03f)
                .build();

        UraniumVanadiumExtract = new Material.Builder(4211, GTUtility.gregtechId("uranium_vanadium_extract"))
                .fluid()
                .color(0x505e3a)
                .build();

        UraniumExtract = new Material.Builder(4212, GTUtility.gregtechId("uranium_extract"))
                .fluid()
                .color(0x4a6e3b)
                .build();

        AcidicVanadylSolution = new Material.Builder(4213, GTUtility.gregtechId("acidic_vanadyl_solution"))
                .fluid()
                .color(0x804221)
                .build();

        ImpureUranylCarbonateSolution = new Material.Builder(4214, GTUtility.gregtechId("impure_uranyl_carbonate_solution"))
                .fluid()
                .color(0x9cad37)
                .build();

        UranylCarbonateSolution = new Material.Builder(4215, GTUtility.gregtechId("uranyl_carbonate_solution"))
                .fluid()
                .color(0xbed14d)
                .build();

        UranylSulfateSolution = new Material.Builder(4216, GTUtility.gregtechId("uranyl_sulfate_solution"))
                .fluid()
                .color(0xb5a638)
                .build();

        TetraethylleadSludge = new Material.Builder(4217, GTUtility.gregtechId("tetraethyllead_sludge"))
                .fluid()
                .color(0x2b1e1e)
                .build();

        GasolineOxygenates = new Material.Builder(4218, GTUtility.gregtechId("gasoline_oxygenates"))
                .fluid()
                .color(0xb4c5e0)
                .build();

        GasolineAntioxidants = new Material.Builder(4219, GTUtility.gregtechId("gasoline_antioxidants"))
                .fluid()
                .color(0x380b0d)
                .build();

        GasolineAntiknock = new Material.Builder(4220, GTUtility.gregtechId("gasoline_antiknock"))
                .fluid()
                .color(0x48485e)
                .build();

        GasolineGeneralAdditives = new Material.Builder(4221, GTUtility.gregtechId("gasoline_general_additives"))
                .fluid()
                .color(0x718072)
                .build();

        MidgradeGasoline = new Material.Builder(4222, GTUtility.gregtechId("midgrade_gasoline"))
                .fluid()
                .color(0xc49735)
                .build();

        PremiumGasoline = new Material.Builder(4223, GTUtility.gregtechId("premium_gasoline"))
                .fluid()
                .color(0xdb8427)
                .build();

        SupremeGasoline = new Material.Builder(4224, GTUtility.gregtechId("supreme_gasoline"))
                .fluid()
                .color(0xf26d1b)
                .build();

        PotassiumMolecularSieve = new Material.Builder(4225, GTUtility.gregtechId('potassium_molecular_sieve'))
                .dust()
                .iconSet(SHINY)
                .color(0x7c8e94)
                .build();

        CesiumMolecularSieve = new Material.Builder(4226, GTUtility.gregtechId('cesium_molecular_sieve'))
                .dust()
                .iconSet(SHINY)
                .color(0x9c7f73)
                .build();

        SaturatedPotassiumMolecularSieve = new Material.Builder(4227, GTUtility.gregtechId('saturated_potassium_molecular_sieve'))
                .dust()
                .color(0x7c8e94)
                .build();

        SaturatedCesiumMolecularSieve = new Material.Builder(4228, GTUtility.gregtechId('saturated_cesium_molecular_sieve'))
                .dust()
                .color(0x9c7f73)
                .build();

        ImpureIlmeniteSlurry = new Material.Builder(4229, GTUtility.gregtechId("impure_ilmenite_slurry"))
                .fluid()
                .color(0x4a474c)
                .build();

        //ImpureIlmeniteSlurry.setFormula("(H2O)(FeTiO3)(?)", true);

        ImpureIlmeniteConcentrate = new Material.Builder(4230, GTUtility.gregtechId("impure_ilmenite_concentrate"))
                .dust()
                .color(0x4a474c).iconSet(ROUGH)
                .build();

        //ImpureIlmeniteConcentrate.setFormula("(FeTiO3)(?)", true);

        IlmeniteSlurry = new Material.Builder(4231, GTUtility.gregtechId("ilmenite_slurry"))
                .fluid()
                .color(0x6c7078)
                .build();

        //IlmeniteSlurry.setFormula("(H2O)(FeTiO3)(?)", true);

        TitanylSulfateSolution = new Material.Builder(4232, GTUtility.gregtechId("titanyl_sulfate_solution"))
                .fluid()
                .color(0x74561d)
                .build();

        //TitanylSulfateSolution.setFormula("(H20)(TiO[SO4])(?)", true);

        AcidicWastewater = new Material.Builder(4233, GTUtility.gregtechId("acidic_wastewater"))
                .fluid()
                .color(0xc88a41)
                .build();

        //AcidicWastewater.setFormula("(H20)(?)", true);

        DirtyMolecularSieve = new Material.Builder(4234, GTUtility.gregtechId('dirty_molecular_sieve'))
                .dust()
                .color(0x737373)
                .iconSet(DULL)
                .build();
      
        PotashConcentrate = new Material.Builder(4235, GTUtility.gregtechId("potash_concentrate"))
                .dust()
                .color(0xb39a9a)
                .build();

        ImpurePotashSlurry = new Material.Builder(4236, GTUtility.gregtechId("impure_potash_slurry"))
                .fluid()
                .color(0xb39a9a)
                .build();

        PotashSlurry = new Material.Builder(4237, GTUtility.gregtechId("potash_slurry"))
                .fluid()
                .color(0xd4b2b2)
                .build();

        SupersaturatedBrine = new Material.Builder(4238, GTUtility.gregtechId("supersaturated_brine"))
                .fluid()
                .color(0xdbb56e)
                .build();
        
        OligomericBisphenolSolution = new Material.Builder(4239, GTUtility.gregtechId("oligomeric_bisphenol_solution"))
                .fluid()
                .color(0xcfa532)
                .build();

        ImpureBariteSlurry = new Material.Builder(4240, GTUtility.gregtechId("impure_barite_slurry"))
                .fluid()
                .color(0x87a2ab)
                .build();

        BariteSlurry = new Material.Builder(4241, GTUtility.gregtechId("barite_slurry"))
                .fluid()
                .color(0x8fb3bf)
                .build();

        GraniteTailingSlurry = new Material.Builder(4242, GTUtility.gregtechId("granite_tailing_slurry"))
                .fluid()
                .color(0xc48072)
                .build();

        GalenaSlurry = new Material.Builder(4243, GTUtility.gregtechId("galena_slurry"))
                .fluid()
                .color(0x6a3678)
                .build();

        ByproductSphaleriteSlurry = new Material.Builder(4244, GTUtility.gregtechId("byproduct_sphalerite_slurry"))
                .fluid()
                .color(0x9f97a1)
                .build();

        ImpureCerussiteSlurry = new Material.Builder(4245, GTUtility.gregtechId("impure_cerussite_slurry"))
                .fluid()
                .color(0xe5a6f5)
                .build();

        CerussiteSlurry = new Material.Builder(4246, GTUtility.gregtechId("cerussite_slurry"))
                .fluid()
                .color(0xdf8cf5)
                .build();

        ImpureAnglesiteSlurry = new Material.Builder(4247, GTUtility.gregtechId("impure_anglesite_slurry"))
                .fluid()
                .color(0x8f60d1)
                .build();

        AnglesiteSlurry = new Material.Builder(4248, GTUtility.gregtechId("anglesite_slurry"))
                .fluid()
                .color(0x854ad9)
                .build();

        ImpureSpodumeneSlurry = new Material.Builder(4249, GTUtility.gregtechId("impure_spodumene_slurry"))
                .fluid()
                .color(0xde9eb6)
                .build();

        SpodumeneSlurry = new Material.Builder(4250, GTUtility.gregtechId("spodumene_slurry"))
                .fluid()
                .color(0xffb5d1)
                .build();
                
        PegmatiteTailingSlurry = new Material.Builder(4251, GTUtility.gregtechId("pegmatite_tailing_slurry"))
                .fluid()
                .color(0x2c4a2d)
                .build();

        FilteredPhosphateSlurry = new Material.Builder(4252, GTUtility.gregtechId("filtered_phosphate_slurry"))
                .fluid()
                .color(0x918e27)
                .build();

        PhosphateConcentrateSlurry = new Material.Builder(4253, GTUtility.gregtechId("phosphate_concentrate_slurry"))
                .fluid()
                .color(0xadaa32)
                .build();

        ImpureCassiteriteSlurry = new Material.Builder(4254, GTUtility.gregtechId("impure_cassiterite_slurry"))
                .fluid()
                .color(0xbdbdbd)
                .build();

        CassiteriteSlurry = new Material.Builder(4255, GTUtility.gregtechId("cassiterite_slurry"))
                .fluid()
                .color(0xdcdcdc)
                .build();

        LimestoneTailingSlurry = new Material.Builder(4256, GTUtility.gregtechId("limestone_tailing_slurry"))
                .fluid()
                .color(0x68695d)
                .build();

        ImpureMalachiteSlurry = new Material.Builder(4257, GTUtility.gregtechId("impure_malachite_slurry"))
                .fluid()
                .color(0x104006)
                .build();

        MalachiteSlurry = new Material.Builder(4258, GTUtility.gregtechId("malachite_slurry"))
                .fluid()
                .color(0x155f05)
                .build();

        ImpureChalcopyriteSlurry = new Material.Builder(4259, GTUtility.gregtechId("impure_chalcopyrite_slurry"))
                .fluid()
                .color(0x856119)
                .build();

        ChalcopyriteSlurry = new Material.Builder(4260, GTUtility.gregtechId("chalcopyrite_slurry"))
                .fluid()
                .color(0xa07828)
                .build();

        ImpureBorniteSlurry = new Material.Builder(4261, GTUtility.gregtechId("impure_bornite_slurry"))
                .fluid()
                .color(0x7d511d)
                .build();

        BorniteSlurry = new Material.Builder(4262, GTUtility.gregtechId("bornite_slurry"))
                .fluid()
                .color(0x97662b)
                .build();

        ImpureChalcociteSlurry = new Material.Builder(4263, GTUtility.gregtechId("impure_chalcocite_slurry"))
                .fluid()
                .color(0x262424)
                .build();

        ChalcociteSlurry = new Material.Builder(4264, GTUtility.gregtechId("chalcocite_slurry"))
                .fluid()
                .color(0x353535)
                .build();

        MalachiteLeach = new Material.Builder(4265, GTUtility.gregtechId("malachite_leach"))
                .fluid()
                .color(0x0f6880)
                .build();

        OxidizedMalachiteLeach = new Material.Builder(4266, GTUtility.gregtechId("oxidized_malachite_leach"))
                .fluid()
                .color(0x1a728a)
                .build();

        PyriteSlurry = new Material.Builder(4267, GTUtility.gregtechId("pyrite_slurry"))
                .fluid()
                .color(0x967828)
                .build();

        CopperConcentrateSlurry = new Material.Builder(4268, GTUtility.gregtechId("copper_concentrate_slurry"))
                .fluid()
                .color(0xff6400)
                .build();

        CopperConcentrate = new Material.Builder(4269, GTUtility.gregtechId("copper_concentrate"))
                .dust()
                .color(0xff6400)
                .iconSet(SAND)
                .build();

        CopperMatte = new Material.Builder(4270, GTUtility.gregtechId("copper_matte"))
                .dust()
                .color(0x5c3d08)
                .build();

        BlisterCopper = new Material.Builder(4271, GTUtility.gregtechId("blister_copper"))
                .ingot()
                .flags(GENERATE_PLATE)
                .color(0x6e4c14)
                .iconSet(SHINY)
                .build();

        CopperMatteFlueDust = new Material.Builder(4272, GTUtility.gregtechId("copper_matte_flue_dust"))
                .dust()
                .color(0x3e146e)
                .iconSet(DULL)
                .build();

        CopperMatteFlueGas = new Material.Builder(4273, GTUtility.gregtechId("copper_matte_flue_gas"))
                .fluid()
                .color(0x3e146e)
                .build();

        ImpureCinnabarSlurry = new Material.Builder(4274, GTUtility.gregtechId("impure_cinnabar_slurry"))
                .fluid()
                .color(0x820000)
                .build();

        CinnabarSlurry = new Material.Builder(4275, GTUtility.gregtechId("cinnabar_slurry"))
                .fluid()
                .color(0x960000)
                .build();

        ChlorofluoromethaneMix = new Material.Builder(4276, GTUtility.gregtechId("chlorofluoromethane_mix"))
                .fluid()
                .color(0xb03f5d)
                .build();
    }
}