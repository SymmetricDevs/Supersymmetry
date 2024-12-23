package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

public class SecondDegreeMaterials {
    public static void register() {

        log.infoMC('Registering Second Degree Materials!');

        NitrateSaltMix = new Material.Builder(13000, SuSyUtility.susyId('nitrate_salt_mix'))
                .dust()
                .components(AmmoniumChloride * 1, Saltpeter * 1)
                .colorAverage()
                .build();

        AmmoniumChlorideSolution = new Material.Builder(13001, SuSyUtility.susyId('ammonium_chloride_solution'))
                .liquid()
                .components(AmmoniumChloride * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumChlorideSolution = new Material.Builder(13002, SuSyUtility.susyId('potassium_chloride_solution'))
                .liquid()
                .color(0x3b5eeb)
                .components(RockSalt * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumBisulfateSolution = new Material.Builder(13003, SuSyUtility.susyId('potassium_bisulfate_solution'))
                .liquid()
                .components(PotassiumBisulfate * 1, Water * 1)
                .colorAverage()
                .build();

        SodiumBisulfateSolution = new Material.Builder(13004, SuSyUtility.susyId('sodium_bisulfate_solution'))
                .liquid()
                .components(SodiumBisulfate * 1, Water * 1)
                .colorAverage()
                .build();

        CalciumChlorideSolution = new Material.Builder(13005, SuSyUtility.susyId('calcium_chloride_solution'))
                .liquid()
                .components(CalciumChloride * 1, Water * 1)
                .colorAverage()
                .build();

        SodaAshSolution = new Material.Builder(13006, SuSyUtility.susyId('soda_ash_solution'))
                .liquid()
                .components(SodaAsh * 1, Water * 1)
                .colorAverage()
                .build();

        SodiumBicarbonateSolution = new Material.Builder(13007, SuSyUtility.susyId('sodium_bicarbonate_solution'))
                .liquid()
                .color(0x252747)
                .build()
                .setFormula('(H2O)(NaHCO3)', true)

        AmmoniumNitrateSolution = new Material.Builder(13008, SuSyUtility.susyId('ammonium_nitrate_solution'))
                .liquid()
                .components(material('ammonium_nitrate'), Water * 1)
                .colorAverage()
                .build();

        NitrateSolution = new Material.Builder(13009, SuSyUtility.susyId('nitrate_solution'))
                .liquid()
                .components(AmmoniumChloride * 1, Saltpeter * 1, Water * 2)
                .colorAverage()
                .build();

        SodiumNitrateSolution = new Material.Builder(13010, SuSyUtility.susyId('sodium_nitrate_solution'))
                .liquid()
                .components(SodiumNitrate * 1, Water * 1)
                .colorAverage()
                .build();

        DilutedPotassiumCarbonateSolution = new Material.Builder(13011, SuSyUtility.susyId('diluted_potassium_carbonate_solution'))
                .liquid()
                .components(PotassiumCarbonate * 1, Water * 3)
                .colorAverage()
                .build();

        PotassiumHydroxideSolution = new Material.Builder(13012, SuSyUtility.susyId('potassium_hydroxide_solution'))
                .liquid()
                .components(PotassiumHydroxide * 1, Water * 1)
                .colorAverage()
                .build();

        CalciumHydroxideSlurry = new Material.Builder(13013, SuSyUtility.susyId('calcium_hydroxide_slurry'))
                .liquid()
                .components(material('calcium_hydroxide'), Water * 1)
                .colorAverage()
                .build();

        SodiumSilicateSolution = new Material.Builder(13014, SuSyUtility.susyId('sodium_silicate_solution'))
                .liquid()
                .components(SodiumSilicate * 1, Water * 1)
                .colorAverage()
                .build();

        SodiumAluminateSolution = new Material.Builder(13015, SuSyUtility.susyId('sodium_aluminate_solution'))
                .liquid()
                .components(SodiumAluminate * 1, Water * 1)
                .color(0x3f71bf)
                .build();

        SodiumFluorideSolution = new Material.Builder(13016, SuSyUtility.susyId('sodium_fluoride_solution'))
                .liquid()
                .components(SodiumFluoride * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumFluorideSolution = new Material.Builder(13017, SuSyUtility.susyId('potassium_fluoride_solution'))
                .liquid()
                .components(PotassiumFluoride * 1, Water * 1)
                .colorAverage()
                .build();

        PotassiumTetrafluoroborateSolution = new Material.Builder(13018, SuSyUtility.susyId('potassium_tetrafluoroborate_solution'))
                .liquid()
                .components(PotassiumTetrafluoroborate * 2, Water * 7)
                .color(0x8fb5a3)
                .build();

        SodiumBromideSolution = new Material.Builder(13019, SuSyUtility.susyId('sodium_bromide_solution'))
                .liquid()
                .components(SodiumBromide * 1, Water * 1)
                .colorAverage()
                .build();

        WackerCatalyst = new Material.Builder(13020, SuSyUtility.susyId('wacker_catalyst'))
                .dust()
                .components(PalladiumChloride * 1, CopperIIChloride * 1)
                .colorAverage()
                .build();

        PotassiumIodideSolution = new Material.Builder(13021, SuSyUtility.susyId('potassium_iodide_solution'))
                .liquid()
                .components(PotassiumIodide * 1, Water * 1)
                .colorAverage()
                .build();

        SodiumSulfateSolution = new Material.Builder(13022, SuSyUtility.susyId('sodium_sulfate_solution'))
                .liquid()
                .components(SodiumSulfate * 1, Water * 1)
                .color(0xb0b0bf)
                .build()

        ImpregnatedCopperOxideCatalyst = new Material.Builder(13023, SuSyUtility.susyId('impregnated_copper_oxide_catalyst'))
                .dust()
                .components(CupricOxide * 1, Alumina * 1)
                .colorAverage()
                .build()

        PhilipsCatalyst = new Material.Builder(13024, SuSyUtility.susyId('philips_catalyst'))
                .dust()
                .components(SiliconDioxide * 1, ChromiumTrioxide * 1)
                .colorAverage()
                .build()

        ZieglerNattaCatalyst = new Material.Builder(13025, SuSyUtility.susyId('ziegler_natta_catalyst'))
                .dust()
                .components(Triethylaluminium * 1, TitaniumTetrachloride * 1)
                .colorAverage()
                .build()

        HydrogenPeroxideSolution = new Material.Builder(13026, SuSyUtility.susyId('hydrogen_peroxide_solution'))
                .liquid()
                .components(HydrogenPeroxide * 1, Water * 1)
                .colorAverage()
                .build()

        AmmoniumAcetateSolution = new Material.Builder(13027, SuSyUtility.susyId('ammonium_acetate_solution'))
                .liquid()
                .components(Carbon * 2, Hydrogen * 7, Nitrogen * 1, Oxygen * 2, Water * 1)
                .colorAverage()
                .build()

        TetramethylammoniumHydroxideSolution = new Material.Builder(13028, SuSyUtility.susyId('tetramethylammonium_hydroxide_solution'))
                .liquid()
                .components(Methanol * 1, TetramethylammoniumHydroxide * 1)
                .colorAverage()
                .build()

        SodiumSulfiteSolution = new Material.Builder(13029, SuSyUtility.susyId('sodium_sulfite_solution'))
                .liquid()
                .components(SodiumSulfite * 1, Water * 1)
                .colorAverage()
                .build()

        PhosphorusSolution = new Material.Builder(13030, SuSyUtility.susyId('phosphorus_solution'))
                .liquid()
                .components(PhosphorusTrichloride * 1, Phosphorus * 1)
                .colorAverage()
                .build()

        SodiumCyanideSolution = new Material.Builder(13031, SuSyUtility.susyId('sodium_cyanide_solution'))
                .liquid()
                .components(SodiumCyanide * 1, Water * 2)
                .colorAverage()
                .build()

        BrominatedSulfurDioxide = new Material.Builder(13032, SuSyUtility.susyId('brominated_sulfur_dioxide'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid * 1, HydrobromicAcid * 2)
                .colorAverage()
                .build()

        SodiumThiosulfateSolution = new Material.Builder(13033, SuSyUtility.susyId('sodium_thiosulfate_solution'))
                .liquid()
                .components(SodiumThiosulfate * 1, Water * 1)
                .colorAverage()
                .build()

        SodiumPerchlorateSolution = new Material.Builder(13035, SuSyUtility.susyId('sodium_perchlorate_solution'))
                .liquid()
                .color(0x5880c7)
                .build()

        SodiumPerchlorateSolution.setFormula('(H2O)(NaClO4)', true);

        SodiumChlorateSolution = new Material.Builder(13036, SuSyUtility.susyId('sodium_chlorate_solution'))
                .liquid()
                .color(0x315fe8)
                .build()

        SodiumChlorateSolution.setFormula('(H2O)(NaClO3)', true);

        DilutedAniline = new Material.Builder(13037, SuSyUtility.susyId('diluted_aniline'))
                .liquid()
                .color(0x5fb36e)
                .build()

        DilutedAniline.setFormula('(H2O)2(C6H5NH2)', true);

        DilutedIronIIIChlorideSolution = new Material.Builder(13038, SuSyUtility.susyId('diluted_iron_iii_chloride_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Iron3Chloride * 1, Water * 3)
                .colorAverage()
                .build()

        ChloroauricAcidSolution = new Material.Builder(13039, SuSyUtility.susyId('chloroauric_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroauricAcid * 3, NitricAcid * 1, Water * 6)
                .color(0xd69129)
                .build();

        ZincChlorideSolution = new Material.Builder(13040, SuSyUtility.susyId('zinc_chloride_solution'))
                .liquid()
                .components(ZincChloride * 1, Water * 1)
                .colorAverage()
                .build();

        WohlwillElectrolyte = new Material.Builder(13041, SuSyUtility.susyId('wohlwill_electrolyte'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroauricAcid * 1, Water * 1, HydrogenChloride * 2)
                .color(0xe8b833)
                .build();

        SpentWohlwilElectrolyte = new Material.Builder(13042, SuSyUtility.susyId('spent_wohlwill_electrolyte'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(ChloroauricAcid * 1, Water * 1, HydrogenChloride * 2)
                .color(0xfacd50)
                .build();

        SpentWohlwilElectrolyte.setFormula('(?)(H[AuCl4])(H2O)(HCl)2', true)

        GoldOreSlurry = new Material.Builder(13043, SuSyUtility.susyId('gold_ore_slurry'))
                .liquid()
                .components(GoldConcentrate * 4, Water * 6)
                .colorAverage()
                .build();

        GoldEluent = new Material.Builder(13044, SuSyUtility.susyId('gold_eluent'))
                .liquid()
                .components(SodiumCyanide * 1, SodiumHydroxide * 1, Water * 27)
                .colorAverage()
                .build();

        GoldEluteSolution = new Material.Builder(13045, SuSyUtility.susyId('gold_elute_solution'))
                .liquid()
                .components(SodiumCyanide * 1, SodiumHydroxide * 1, Sodium * 27, Gold * 27, Carbon * 54, Nitrogen * 54, Water * 27)
                .color(0xbbcc64)
                .build();

        GoldEluteSolution.setFormula('(NaCN)(NaOH)(Na[Au(CN)2])27(H2O)27', true)

        PotassiumCarbonateSolution = new Material.Builder(13046, SuSyUtility.susyId('potassium_carbonate_solution'))
                .liquid()
                .components(PotassiumCarbonate * 1, Water * 1)
                .colorAverage()
                .build()

        PotassiumSulfateSolution = new Material.Builder(13047, SuSyUtility.susyId('potassium_sulfate_solution'))
                .liquid()
                .components(PotassiumSulfate * 1, Water * 1)
                .colorAverage()
                .build()

        PhosphoriteSlurry = new Material.Builder(13048, SuSyUtility.susyId('phosphorite_slurry'))
                .liquid()
                .components(Phosphorite * 2, Water * 1)
                .colorAverage()
                .build()
      
        DilutedHexafluorosilicicAcid = new Material.Builder(13049, SuSyUtility.susyId('diluted_hexafluorosilicic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HexafluorosilicicAcid * 1, Water * 8)
                .colorAverage()
                .build()

        LithiumSulfateSolution = new Material.Builder(13050, SuSyUtility.susyId('lithium_sulfate_solution'))
                .liquid()
                .components(LithiumSulfate * 1, Water * 1)
                .colorAverage()
                .build()

        DilutedSodiumSulfateSolution = new Material.Builder(13051, SuSyUtility.susyId('diluted_sodium_sulfate_solution'))
                .liquid()
                .components(SodiumSulfate * 1, Water * 2)
                .color(0x9191b3)
                .build()

        DilutedHydrofluoricAcid = new Material.Builder(13052, SuSyUtility.susyId('diluted_hydrofluoric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HydrogenFluoride * 1, Water * 2)
                .colorAverage()
                .build();

        FluorideFusedBeryl = new Material.Builder(13053, SuSyUtility.susyId('fluoride_fused_beryl'))
                .dust()
                .components(SodiumFluoroberyllate * 6, Alumina * 2, SiliconDioxide * 15)
                .color(0x424f3e)
                .build();

        SodiumFluoroberyllateSolution = new Material.Builder(13054, SuSyUtility.susyId('sodium_fluoroberyllate_solution'))
                .liquid()
                .components(SodiumFluoroberyllate * 1, Water * 1)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllateSolution = new Material.Builder(13055, SuSyUtility.susyId('ammonium_fluoroberyllate_solution'))
                .liquid()
                .components(AmmoniumFluoroberyllate * 1, Water * 3)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllateSolution.setFormula('(NH4)2(BeF4)(H2O)3', true)

        AmmoniumFluorideSolution = new Material.Builder(13056, SuSyUtility.susyId('ammonium_fluoride_solution'))
                .liquid()
                .components(AmmoniumFluoride * 1, Water * 1)
                .colorAverage()
                .build();

        AlkaliFusedBeryl = new Material.Builder(13057, SuSyUtility.susyId('alkali_fused_beryl'))
                .dust()
                .components(Emerald * 1, SodaAsh * 1)
                .colorAverage()
                .build();

        AluminiumSulfateSolution = new Material.Builder(13058, SuSyUtility.susyId('aluminium_sulfate_solution'))
                .liquid()
                .components(AluminiumSulfate * 1, Water * 6)
                .colorAverage()
                .build();
        
        OxidizedManganateSolution = new Material.Builder(13059, SuSyUtility.susyId('oxidized_manganate_solution'))
                .liquid()
                .components(PotassiumPermanganate, PotassiumHydroxide, Water)
                .color(0x48065e)
                .build();

        CopperSulfateSolution = new Material.Builder(13060, SuSyUtility.susyId('copper_sulfate_solution'))
                .liquid()
                .components(CopperSulfate * 1, Water * 1)
                .color(0x2d3bcf)
                .build();

        BariumChlorideSolution = new Material.Builder(13061, SuSyUtility.susyId('barium_chloride_solution'))
                .liquid()
                .components(BariumChloride * 1, Water * 2)
                .colorAverage()
                .build();

        DilutedSodiumSilicateSolution = new Material.Builder(13062, SuSyUtility.susyId('diluted_sodium_silicate_solution'))
                .liquid()
                .components(SodiumSilicate * 1, Water * 4)
                .colorAverage()
                .build();

        SodiumDichromateSolution = new Material.Builder(13063, SuSyUtility.susyId('sodium_dichromate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SodiumDichromate * 1, Water * 1, SulfuricAcid * 1)
                .color(0xe0912f)
                .build();

        ChromiumSodaMixture = new Material.Builder(13064, SuSyUtility.susyId('chromium_soda_mixture'))
                .dust()
                .components(ChromiumIIIOxide * 1, SodaAsh * 1)
                .build();

        LeadChlorideSolution = new Material.Builder(13066, SuSyUtility.susyId('lead_chloride_solution'))
                .liquid(new FluidBuilder().temperature(343))
                .components(LeadChloride * 1, Water * 1)
                .colorAverage()
                .build();

        AmmoniumSulfateSolution = new Material.Builder(13067, SuSyUtility.susyId('ammonium_sulfate_solution'))
                .liquid()
                .components(AmmoniumSulfate * 1, Water * 1)
                .colorAverage()
                .build();

        AmmoniumChromeAlumSolution = new Material.Builder(13068, SuSyUtility.susyId('ammonium_chrome_alum_solution'))
                .liquid()
                .components(AmmoniumChromeAlum * 1, Water * 1)
                .color(0x7643a3)
                .build();

        AgedAmmoniumChromeAlumSolution = new Material.Builder(13069, SuSyUtility.susyId('aged_ammonium_chrome_alum_solution'))
                .liquid()
                .components(AmmoniumChromeAlum * 1, Water * 1)
                .color(0x7643a3)
                .build();

        PurifiedAmmoniumChromeAlumSolution = new Material.Builder(13070, SuSyUtility.susyId('purified_ammonium_chrome_alum_solution'))
                .liquid()
                .components(AmmoniumChromeAlum * 1, Water * 1)
                .color(0x7643a3)
                .build();

        AmmoniumIronIISulfateSolution = new Material.Builder(13071, SuSyUtility.susyId('ammonium_iron_ii_sulfate_solution'))
                .liquid(new FluidBuilder().temperature(343))
                .components(AmmoniumIronIISulfate * 1, Water * 1)
                .color(0x70cc6e)
                .build();

        SupportedNickel = new Material.Builder(13072, SuSyUtility.susyId('supported_nickel'))
                .dust()
                .components(NickelIINitrate * 1, Alumina * 1)
                .colorAverage()
                .flags(GENERATE_CATALYST_BED)
                .build()

        AmmoniumMetatungstateSolution = new Material.Builder(13073, SuSyUtility.susyId('ammonium_metatungstate_solution'))
                .liquid()
                .components(AmmoniumMetatungstate, Ammonia * 4, Water * 4)
                .color(0x340959)
                .build()

        //FREE IDs: 13074

        DilutedAmmoniumSulfateSolution = new Material.Builder(13075, SuSyUtility.susyId('diluted_ammonium_sulfate_solution'))
                .liquid()
                .components(AmmoniumSulfate * 1, Water * 2)
                .colorAverage()
                .build();

        AlluvialPlatinumMotherLiquor = new Material.Builder(13076, SuSyUtility.susyId('alluvial_platinum_mother_liquor'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 2, Palladium * 1, Chlorine * 4, ZincChloride * 1, HydrogenChloride * 4, Water * 14)
                .colorAverage()
                .build();

        AlluvialPlatinumMotherLiquor.setFormula('(H2PdCl4)(ZnCl2)(HCl)4(H2O)14', true)

        AmmoniacalSodiumBicarbonateSolution = new Material.Builder(13077, SuSyUtility.susyId('ammoniacal_sodium_bicarbonate_solution'))
                .liquid()
                .components(AmmoniumChloride * 1, SodiumBicarbonate * 1, Water * 1)
                .colorAverage()
                .build();

        VeryDilutedSodiumSulfateSolution = new Material.Builder(13078, SuSyUtility.susyId('very_diluted_sodium_sulfate_solution'))
                .liquid()
                .components(SodiumSulfate * 1, Water * 9)
                .colorAverage()
                .build()

        MolybdicAcidSolution = new Material.Builder(13079, SuSyUtility.susyId('molybdic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 2, Molybdenum * 1, Oxygen * 4, HydrogenChloride * 1, Water * 1)
                .colorAverage()
                .build()

        MolybdicAcidSolution.setFormula('(H2MoO4)(HCl)(H2O)', true)

        NeutralizedAmmoniumMolybdateSolution = new Material.Builder(13080, SuSyUtility.susyId('neutralized_ammonium_molybdate_solution'))
                .liquid()
                .components(Nitrogen * 2, Hydrogen * 8, Molybdenum * 1, Oxygen * 4, AmmoniumChloride * 1, Water * 4)
                .colorAverage()
                .build()

        NeutralizedAmmoniumMolybdateSolution.setFormula('[(NH4)2MoO4](NH4Cl)(H2O)4', true)

        SublimatedMolybdenumTrioxide = new Material.Builder(13081, SuSyUtility.susyId('sublimated_molybdenum_trioxide'))
                .liquid()
                .components(PurifiedMolybdenumTrioxide * 1, Air * 1)
                .colorAverage()
                .build()

        AmmoniumThiocyanateSolution = new Material.Builder(13082, SuSyUtility.susyId('ammonium_thiocyanate_solution'))
                .liquid()
                .components(AmmoniumThiocyanate * 1, Water * 1)
                .colorAverage()
                .build();

        TantalumFluorideSolution = new Material.Builder(13083, SuSyUtility.susyId('tantalum_fluoride_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TantalumFluoride * 1, Water * 2)
                .colorAverage()
                .build();

        AmmoniumPerrhenateSolution = new Material.Builder(13084, SuSyUtility.susyId('ammonium_perrhenate_solution'))
                .liquid()
                .components(AmmoniumPerrhenate * 1, Water * 1)
                .colorAverage()
                .build();
        
        AluminiumChlorideSolution = new Material.Builder(13085, SuSyUtility.susyId('aluminium_chloride_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AluminiumChloride * 1, Water * 3)
                .colorAverage()
                .build();

        DilutedSodiumSulfiteSolution = new Material.Builder(13086, SuSyUtility.susyId('diluted_sodium_sulfite_solution'))
                .liquid()
                .components(SodiumSulfite * 1, Water * 14)
                .color(0x75745a)
                .build();

        EGlass = new Material.Builder(13088, SuSyUtility.susyId('e_glass'))
                .dust().liquid(new FluidBuilder().temperature(2300))
                .components(SiliconDioxide * 6, Alumina * 1, BoronTrioxide * 1, Quicklime * 2)
                .color(0x778f8b)
                .build();

        AlluvialPalladiumMotherLiquor = new Material.Builder(13089, SuSyUtility.susyId('alluvial_palladium_mother_liquor'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AmmoniumChloride * 2, ZincChloride * 1, HydrogenChloride * 4, Water * 16)
                .colorAverage()
                .build();

        AlluvialDivalentPalladiumSolution = new Material.Builder(13090, SuSyUtility.susyId('alluvial_divalent_palladium_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 2, Palladium * 1, Chlorine * 4, ZincChloride * 1, HydrogenChloride * 4, Water * 14)
                .colorAverage()
                .build();

        AlluvialPlatinumMotherLiquor.setFormula('(H2PdCl4)(ZnCl2)(HCl)4(H2O)14', true)

        PlatinumPrecursorSolution = new Material.Builder(13091, SuSyUtility.susyId('platinum_precursor_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AmmoniumHexachloroplatinate * 1, PhosphoricAcid * 1)
                .colorAverage()
                .build();

        SupportedPlatinum = new Material.Builder(13092, SuSyUtility.susyId('supported_platinum'))
                .dust()
                .components(Alumina * 1, Platinum * 1, Chlorine * 4)
                .colorAverage()
                .flags(GENERATE_CATALYST_BED)
                .build()

        CrudeManganeseIISulfateSolution = new Material.Builder(13093, SuSyUtility.susyId('crude_manganese_ii_sulfate_solution'))
                .liquid()
                .components(ManganeseIISulfate * 1, Water * 1)
                .colorAverage()
                .build()
                .setFormula('(?)(MnSO4)(H2O)', true)

        ManganeseIISulfateSolution = new Material.Builder(13094, SuSyUtility.susyId('manganese_ii_sulfate_solution'))
                .liquid()
                .components(ManganeseIISulfate * 1, Water * 1)
                .colorAverage()
                .build()
                .setFormula('(MnSO4)(H2O)', true)

        DilutedZincChlorideSolution = new Material.Builder(13095, SuSyUtility.susyId("diluted_zinc_chloride_solution"))
                .liquid()
                .components(ZincChloride * 1, Water * 3)
                .colorAverage()
                .build();

        TrichlorosilaneSolution = new Material.Builder(13096, SuSyUtility.susyId("trichlorosilane_solution"))
                .liquid()
                .components(Trichlorosilane * 1, Toluene * 6)
                .colorAverage()
                .build();

        ImpureBariumSulfideSolution = new Material.Builder(13097, SuSyUtility.susyId("impure_barium_sulfide_solution"))
                .liquid()
                .components(ImpureBariumSulfide * 1, Water * 1)
                .colorAverage()
                .build();

        ImpureStrontiumSulfideSlurry = new Material.Builder(13098, SuSyUtility.susyId("impure_strontium_sulfide_slurry"))
                .liquid()
                .components(ImpureStrontiumSulfide * 1, Water * 1, SiliconDioxide * 1)
                .colorAverage()
                .build();

        DilutedSodiumCarbonateSolution = new Material.Builder(13099, SuSyUtility.susyId("diluted_sodium_carbonate_solution"))
                .liquid()
                .components(SodaAsh * 1, Water * 3)
                .colorAverage()
                .build();

        PalladiumOnCarbon = new Material.Builder(13100, SuSyUtility.susyId("palladium_on_carbon"))
                .dust()
                .components(Palladium * 1, ActivatedCarbon * 4)
                .colorAverage()
                .build();

        ManganeseIIChlorideSolution = new Material.Builder(13101, SuSyUtility.susyId("manganese_ii_chloride_solution"))
                .liquid()
                .components(ManganeseIIChloride * 1, Water * 3)
                .colorAverage()
                .build();

        DilutedManganeseIIChlorideSolution = new Material.Builder(13102, SuSyUtility.susyId("diluted_manganese_ii_chloride_solution"))
                .liquid()
                .components(ManganeseIIChloride * 1, Water * 6)
                .colorAverage()
                .build();

        PalladiumPrecursorSolution = new Material.Builder(13103, SuSyUtility.susyId("palladium_precursor_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PalladiumChloride * 1, PhosphoricAcid * 1)
                .colorAverage()
                .build();

        SupportedPalladium = new Material.Builder(13104, SuSyUtility.susyId("supported_palladium"))
                .dust()
                .components(PalladiumChloride * 1, Alumina * 1)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build();

        MixedCyanideSolution = new Material.Builder(13105, SuSyUtility.susyId("mixed_cyanide_solution"))
                .liquid()
                .components(SodiumCyanide * 2, Hydrogen * 2, Carbon * 2, Nitrogen * 2, Water * 1)
                .colorAverage()
                .build();

        MixedCyanideSolution.setFormula("(NaCN)2(HCN)2(H2O)", true)

        ChlorinatedBeryl = new Material.Builder(13106, SuSyUtility.susyId('chlorinated_beryl'))
                .gas(new FluidBuilder().temperature(1100))
                .components(BerylliumChloride * 3, AluminiumChloride * 2, SiliconTetrachloride * 6, CarbonMonoxide * 18)
                .colorAverage()
                .build();

        SupportedMolybdenumVanadium = new Material.Builder(13107, SuSyUtility.susyId("supported_molybdenum_vanadium"))
                .dust()
                .flags(GENERATE_CATALYST_BED)
                .components(MolybdenumTrioxide * 1, VanadiumPentoxide * 1, Alumina * 1)
                .colorAverage()
                .build();

        IndiumChlorideSolution = new Material.Builder(13108, SuSyUtility.susyId("indium_chloride_solution"))
                .liquid()
                .components(IndiumChloride * 1, Water * 1)
                .colorAverage()
                .build();

        TelluriumLiquor = new Material.Builder(13109, SuSyUtility.susyId("tellurium_liquor"))
                .liquid()
                .components(Hydrogen * 2, Tellurium * 1, Oxygen * 4, SodiumSulfate * 1, Water * 1)
                .color(0x97bfb5)
                .build();

        CaesiumAluminaMixture = new Material.Builder(13110, SuSyUtility.susyId("caesium_alumina_mixture"))
                .dust()
                .components(Caesium * 2, Oxygen * 1, Alumina * 1)
                .color(0x776ed4)
                .build();

        CaesiumChlorideSolution = new Material.Builder(13111, SuSyUtility.susyId("caesium_chloride_solution"))
                .liquid()
                .components(CaesiumChloride * 2, Water * 3)
                .colorAverage()
                .build();

        RubidiumHydroxideSolution = new Material.Builder(13112, SuSyUtility.susyId("rubidium_hydroxide_solution"))
                .liquid()
                .components(RubidiumHydroxide * 1, Water * 4)
                .colorAverage()
                .build();

        SodiumAlumSolution = new Material.Builder(13113, SuSyUtility.susyId("sodium_alum_solution"))
                .liquid()
                .components(SodiumAlum * 1, Water * 4)
                .colorAverage()
                .build();

        GalvanizedSteel = new Material.Builder(13114, SuSyUtility.susyId("galvanized_steel"))
                .dust().flags(GENERATE_FINE_WIRE)
                .components(Iron * 8, Zinc * 1)
                .colorAverage()
                .build();

        ImpureLithiumCarbonateSolution = new Material.Builder(13115, SuSyUtility.susyId("impure_lithium_carbonate_solution"))
                .liquid()
                .components(Carbon * 2, Lithium * 2, Oxygen * 3, Water)
                .colorAverage()
                .build()
                .setFormula("(C)(Li2CO3)(H2O)", true);

        LithiumCarbonateSolution = new Material.Builder(13116, SuSyUtility.susyId("lithium_carbonate_solution"))
                .liquid()
                .components(Lithium * 2, Carbon * 1, Oxygen * 3, Water)
                .colorAverage()
                .build()
                .setFormula("(Li2CO3)(H2O)", true);

        AcidicArgonHydrogenMixture = new Material.Builder(13117, SuSyUtility.susyId("acidic_argon_hydrogen_mixture"))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Argon, Hydrogen * 4, HydrogenChloride)
                .colorAverage()
                .build()
                .setFormula("(Ar)(HCl)(H)", true);

        AmmoniacalArgonHydrogenMixture = new Material.Builder(13118, SuSyUtility.susyId("ammoniacal_argon_hydrogen_mixture"))
                .gas()
                .components(Argon, Hydrogen * 4, Ammonia)
                .colorAverage()
                .build()
                .setFormula("(Ar)(NH3)(H)", true)
    }
}
