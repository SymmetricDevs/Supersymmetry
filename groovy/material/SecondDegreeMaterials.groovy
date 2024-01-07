package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
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
                .components(AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        AmmoniumChlorideSolution = new Material.Builder(13001, SuSyUtility.susyId('ammonium_chloride_solution'))
                .fluid()
                .components(AmmoniumChloride, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumChlorideSolution = new Material.Builder(13002, SuSyUtility.susyId('potassium_chloride_solution'))
                .fluid()
                .color(0x3b5eeb)
                .components(RockSalt, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumBisulfateSolution = new Material.Builder(13003, SuSyUtility.susyId('potassium_bisulfate_solution'))
                .fluid()
                .components(PotassiumBisulfate, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumBisulfateSolution = new Material.Builder(13004, SuSyUtility.susyId('sodium_bisulfate_solution'))
                .fluid()
                .components(SodiumBisulfate, 1, Water, 1)
                .colorAverage()
                .build();

        CalciumChlorideSolution = new Material.Builder(13005, SuSyUtility.susyId('calcium_chloride_solution'))
                .fluid()
                .components(CalciumChloride, 1, Water, 1)
                .colorAverage()
                .build();

        SodaAshSolution = new Material.Builder(13006, SuSyUtility.susyId('soda_ash_solution'))
                .fluid()
                .components(SodaAsh, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumBicarbonateSolution = new Material.Builder(13007, SuSyUtility.susyId('sodium_bicarbonate_solution'))
                .fluid()
                .color(0x252747)
                .build()
                .setFormula('(H2O)(NaHCO3)', true)

        AmmoniumNitrateSolution = new Material.Builder(13008, SuSyUtility.susyId('ammonium_nitrate_solution'))
                .fluid()
                .components(material('ammonium_nitrate'), 1, Water, 1)
                .colorAverage()
                .build();

        NitrateSolution = new Material.Builder(13009, SuSyUtility.susyId('nitrate_solution'))
                .fluid()
                .components(AmmoniumChloride, 1, Saltpeter, 1, Water, 2)
                .colorAverage()
                .build();

        SodiumNitrateSolution = new Material.Builder(13010, SuSyUtility.susyId('sodium_nitrate_solution'))
                .fluid()
                .components(SodiumNitrate, 1, Water, 1)
                .colorAverage()
                .build();

        DilutedPotassiumCarbonateSolution = new Material.Builder(13011, SuSyUtility.susyId('diluted_potassium_carbonate_solution'))
                .fluid()
                .components(PotassiumCarbonate, 1, Water, 3)
                .colorAverage()
                .build();

        PotassiumHydroxideSolution = new Material.Builder(13012, SuSyUtility.susyId('potassium_hydroxide_solution'))
                .fluid()
                .components(PotassiumHydroxide, 1, Water, 1)
                .colorAverage()
                .build();

        CalciumHydroxideSolution = new Material.Builder(13013, SuSyUtility.susyId('calcium_hydroxide_solution'))
                .fluid()
                .components(material('calcium_hydroxide'), 1, Water, 1)
                .colorAverage()
                .build();

        SodiumSilicateSolution = new Material.Builder(13014, SuSyUtility.susyId('sodium_silicate_solution'))
                .fluid()
                .components(SodiumSilicate, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumAluminateSolution = new Material.Builder(13015, SuSyUtility.susyId('sodium_aluminate_solution'))
                .fluid()
                .components(SodiumAluminate, 1, Water, 1)
                .color(0x3f71bf)
                .build();

        SodiumFluorideSolution = new Material.Builder(13016, SuSyUtility.susyId('sodium_fluoride_solution'))
                .fluid()
                .components(SodiumFluoride, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumFluorideSolution = new Material.Builder(13017, SuSyUtility.susyId('potassium_fluoride_solution'))
                .fluid()
                .components(PotassiumFluoride, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumTetrafluoroborateSolution = new Material.Builder(13018, SuSyUtility.susyId('potassium_tetrafluoroborate_solution'))
                .fluid()
                .components(PotassiumTetrafluoroborate, 2, Water, 7)
                .color(0x8fb5a3)
                .build();

        SodiumBromideSolution = new Material.Builder(13019, SuSyUtility.susyId('sodium_bromide_solution'))
                .fluid()
                .components(SodiumBromide, 1, Water, 1)
                .colorAverage()
                .build();

        WackerCatalyst = new Material.Builder(13020, SuSyUtility.susyId('wacker_catalyst'))
                .dust()
                .components(PalladiumChloride, 1, CopperIIChloride, 1)
                .colorAverage()
                .build();

        PotassiumIodideSolution = new Material.Builder(13021, SuSyUtility.susyId('potassium_iodide_solution'))
                .fluid()
                .components(PotassiumIodide, 1, Water, 1)
                .colorAverage()
                .build();

        SodiumSulfateSolution = new Material.Builder(13022, SuSyUtility.susyId('sodium_sulfate_solution'))
                .fluid()
                .color(0xb0b0bf)
                .build()
                .setFormula('(H2O)(Na2SO4)', true);

        ImpregnatedCopperOxideCatalyst = new Material.Builder(13023, SuSyUtility.susyId('impregnated_copper_oxide_catalyst'))
                .dust()
                .components(CupricOxide, 1, Alumina, 1)
                .colorAverage()
                .build()

        PhilipsCatalyst = new Material.Builder(13024, SuSyUtility.susyId('philips_catalyst'))
                .dust()
                .components(SiliconDioxide, 1, ChromiumTrioxide, 1)
                .colorAverage()
                .build()

        ZieglerNattaCatalyst = new Material.Builder(13025, SuSyUtility.susyId('ziegler_natta_catalyst'))
                .dust()
                .components(Triethylaluminium, 1, TitaniumTetrachloride, 1)
                .colorAverage()
                .build()

        HydrogenPeroxideSolution = new Material.Builder(13026, SuSyUtility.susyId('hydrogen_peroxide_solution'))
                .fluid()
                .components(HydrogenPeroxide, 1, Water, 1)
                .colorAverage()
                .build()

        AmmoniumAcetateSolution = new Material.Builder(13027, SuSyUtility.susyId('ammonium_acetate_solution'))
                .fluid()
                .components(Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 2, Water, 1)
                .colorAverage()
                .build()

        TetramethylammoniumHydroxideSolution = new Material.Builder(13028, SuSyUtility.susyId('tetramethylammonium_hydroxide_solution'))
                .fluid()
                .components(Methanol, 1, TetramethylammoniumHydroxide, 1)
                .colorAverage()
                .build()

        SodiumSulfiteSolution = new Material.Builder(13029, SuSyUtility.susyId('sodium_sulfite_solution'))
                .fluid()
                .components(SodiumSulfite, 1, Water, 1)
                .colorAverage()
                .build()

        PhosphorusSolution = new Material.Builder(13030, SuSyUtility.susyId('phosphorus_solution'))
                .fluid()
                .components(PhosphorusTrichloride, 1, Phosphorus, 1)
                .colorAverage()
                .build()

        SodiumCyanideSolution = new Material.Builder(13031, SuSyUtility.susyId('sodium_cyanide_solution'))
                .fluid()
                .components(SodiumCyanide, 1, Water, 2)
                .colorAverage()
                .build()

        BrominatedSulfurDioxide = new Material.Builder(13032, SuSyUtility.susyId('brominated_sulfur_dioxide'))
                .fluid(FluidTypes.ACID)
                .components(SulfuricAcid, 1, HydrobromicAcid, 2)
                .colorAverage()
                .build()

        SodiumThiosulfateSolution = new Material.Builder(13033, SuSyUtility.susyId('sodium_thiosulfate_solution'))
                .fluid()
                .components(SodiumThiosulfate, 1, Water, 1)
                .colorAverage()
                .build()

        SodiumPerchlorateSolution = new Material.Builder(13035, SuSyUtility.susyId('sodium_perchlorate_solution'))
                .fluid()
                .color(0x5880c7)
                .build()

        SodiumPerchlorateSolution.setFormula('(H2O)(NaClO4)', true);

        SodiumChlorateSolution = new Material.Builder(13036, SuSyUtility.susyId('sodium_chlorate_solution'))
                .fluid()
                .color(0x315fe8)
                .build()

        SodiumChlorateSolution.setFormula('(H2O)(NaClO3)', true);

        DilutedAniline = new Material.Builder(13037, SuSyUtility.susyId('diluted_aniline'))
                .fluid()
                .color(0x5fb36e)
                .build()

        DilutedAniline.setFormula('(H2O)2(C6H5NH2)', true);

        DilutedIron3ChlorideSolution = new Material.Builder(13038, SuSyUtility.susyId('diluted_iron_iii_chloride_solution'))
                .fluid()
                .components(Iron3Chloride, 1, Water, 3)
                .colorAverage()
                .build()

        ChloroauricAcidSolution = new Material.Builder(13039, SuSyUtility.susyId('chloroauric_acid_solution'))
                .fluid(FluidTypes.ACID)
                .components(ChloroauricAcid, 3, NitricAcid, 1, Water, 6)
                .color(0xd69129)
                .build();

        ZincChlorideSolution = new Material.Builder(13040, SuSyUtility.susyId('zinc_chloride_solution'))
                .fluid()
                .components(ZincChloride, 1, Water, 1)
                .colorAverage()
                .build();

        WohlwillElectrolyte = new Material.Builder(13041, SuSyUtility.susyId('wohlwill_electrolyte'))
                .fluid(FluidTypes.ACID)
                .components(ChloroauricAcid, 1, Water, 1, HydrogenChloride, 2)
                .color(0xe8b833)
                .build();

        SpentWohlwilElectrolyte = new Material.Builder(13042, SuSyUtility.susyId('spent_wohlwill_electrolyte'))
                .fluid(FluidTypes.ACID)
                .components(ChloroauricAcid, 1, Water, 1, HydrogenChloride, 2)
                .color(0xfacd50)
                .build();

        SpentWohlwilElectrolyte.setFormula('(?)(H[AuCl4])(H2O)(HCl)2', true)

        GoldOreSlurry = new Material.Builder(13043, SuSyUtility.susyId('gold_ore_slurry'))
                .fluid()
                .components(GoldConcentrate, 4, Water, 6)
                .colorAverage()
                .build();

        GoldEluent = new Material.Builder(13044, SuSyUtility.susyId('gold_eluent'))
                .fluid()
                .components(SodiumCyanide, 1, SodiumHydroxide, 1, Water, 27)
                .colorAverage()
                .build();

        GoldEluteSolution = new Material.Builder(13045, SuSyUtility.susyId('gold_elute_solution'))
                .fluid()
                .components(SodiumCyanide, 1, SodiumHydroxide, 1, Sodium, 27, Gold, 27, Carbon, 54, Nitrogen, 54, Water, 27)
                .color(0xbbcc64)
                .build();

        GoldEluteSolution.setFormula('(NaCN)(NaOH)(Na[Au(CN)2])27(H2O)27', true)

        PotassiumCarbonateSolution = new Material.Builder(13046, SuSyUtility.susyId('potassium_carbonate_solution'))
                .fluid()
                .components(PotassiumCarbonate, 1, Water, 1)
                .colorAverage()
                .build()

        PotassiumSulfateSolution = new Material.Builder(13047, SuSyUtility.susyId('potassium_sulfate_solution'))
                .fluid()
                .components(PotassiumSulfate, 1, Water, 1)
                .colorAverage()
                .build()

        PhosphoriteSlurry = new Material.Builder(13048, SuSyUtility.susyId('phosphorite_slurry'))
                .fluid()
                .components(Phosphorite, 2, Water, 1)
                .colorAverage()
                .build()
      
        DilutedHexafluorosilicicAcid = new Material.Builder(13049, SuSyUtility.susyId('diluted_hexafluorosilicic_acid'))
                .fluid(FluidTypes.ACID)
                .components(HexafluorosilicicAcid, 1, Water, 8)
                .colorAverage()
                .build()

        LithiumSulfateSolution = new Material.Builder(13050, SuSyUtility.susyId('lithium_sulfate_solution'))
                .fluid()
                .components(LithiumSulfate, 1, Water, 1)
                .colorAverage()
                .build()

        DilutedSodiumSulfateSolution = new Material.Builder(13051, SuSyUtility.susyId('diluted_sodium_sulfate_solution'))
                .fluid()
                .color(0x9191b3)
                .build()
                .setFormula('(H2O)2(Na2SO4)', true);

        DilutedHydrofluoricAcid = new Material.Builder(13052, SuSyUtility.susyId('diluted_hydrofluoric_acid'))
                .fluid(FluidTypes.ACID)
                .components(HydrogenFluoride, 1, Water, 2)
                .colorAverage()
                .build();

        FluorideFusedBeryl = new Material.Builder(13053, SuSyUtility.susyId('fluoride_fused_beryl'))
                .dust()
                .components(SodiumFluoroberyllate, 6, Alumina, 2, SiliconDioxide, 15)
                .color(0x424f3e)
                .build();

        SodiumFluoroberyllateSolution = new Material.Builder(13054, SuSyUtility.susyId('sodium_fluoroberyllate_solution'))
                .fluid()
                .components(SodiumFluoroberyllate, 1, Water, 1)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllateSolution = new Material.Builder(13055, SuSyUtility.susyId('ammonium_fluoroberyllate_solution'))
                .fluid()
                .components(AmmoniumFluoroberyllate, 1, Water, 3)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllateSolution.setFormula('(NH4)2(BeF4)(H2O)3', true)

        AmmoniumFluorideSolution = new Material.Builder(13056, SuSyUtility.susyId('ammonium_fluoride_solution'))
                .fluid()
                .components(AmmoniumFluoride, 1, Water, 1)
                .colorAverage()
                .build();

        AlkaliFusedBeryl = new Material.Builder(13057, SuSyUtility.susyId('alkali_fused_beryl'))
                .dust()
                .components(Emerald, 1, SodaAsh, 1)
                .colorAverage()
                .build();

        AluminiumSulfateSolution = new Material.Builder(13058, SuSyUtility.susyId('aluminium_sulfate_solution'))
                .fluid()
                .components(AluminiumSulfate, 1, Water, 6)
                .colorAverage()
                .build();

        DilutedBromooctane = new Material.Builder(13059, SuSyUtility.susyId('diluted_bromooctane'))
                .fluid()
                .components(Bromooctane, 1, Water, 1)
                .colorAverage()
                .build()

        CopperSulfateSolution = new Material.Builder(13060, SuSyUtility.susyId('copper_sulfate_solution'))
                .fluid()
                .components(CopperSulfate, 1, Water, 1)
                .color(0x2d3bcf)
                .build();

        BariumChlorideSolution = new Material.Builder(13061, SuSyUtility.susyId('barium_chloride_solution'))
                .fluid()
                .components(BariumChloride, 1, Water, 2)
                .colorAverage()
                .build();

        DilutedSodiumSilicateSolution = new Material.Builder(13062, SuSyUtility.susyId('diluted_sodium_silicate_solution'))
                .fluid()
                .components(SodiumSilicate, 1, Water, 4)
                .colorAverage()
                .build();

        SodiumDichromateSolution = new Material.Builder(13063, SuSyUtility.susyId('sodium_dichromate_solution'))
                .fluid(FluidTypes.ACID)
                .components(SodiumDichromate, 1, Water, 1, SulfuricAcid, 1)
                .color(0xe0912f)
                .build();

        ChromiumSodaMixture = new Material.Builder(13064, SuSyUtility.susyId('chromium_soda_mixture'))
                .dust()
                .components(ChromiumIIIOxide, 1, SodaAsh, 1)
                .build();

        LeadChlorideSolution = new Material.Builder(13066, SuSyUtility.susyId('lead_chloride_solution'))
                .fluid()
                .fluidTemp(343)
                .components(LeadChloride, 1, Water, 1)
                .colorAverage()
                .build();

        AmmoniumSulfateSolution = new Material.Builder(13067, SuSyUtility.susyId('ammonium_sulfate_solution'))
                .fluid()
                .components(AmmoniumSulfate, 1, Water, 1)
                .colorAverage()
                .build();

        AmmoniumChromeAlumSolution = new Material.Builder(13068, SuSyUtility.susyId('ammonium_chrome_alum_solution'))
                .fluid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .build();

        AgedAmmoniumChromeAlumSolution = new Material.Builder(13069, SuSyUtility.susyId('aged_ammonium_chrome_alum_solution'))
                .fluid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .build();

        PurifiedAmmoniumChromeAlumSolution = new Material.Builder(13070, SuSyUtility.susyId('purified_ammonium_chrome_alum_solution'))
                .fluid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .build();

        AmmoniumIronIISulfateSolution = new Material.Builder(13071, SuSyUtility.susyId('ammonium_iron_ii_sulfate_solution'))
                .fluid()
                .fluidTemp(343)
                .components(AmmoniumIronIISulfate, 1, Water, 1)
                .color(0x70cc6e)
                .build();

        DilutedDiTertButylPeroxide = new Material.Builder(13072, SuSyUtility.susyId('diluted_di_tert_butyl_peroxide'))
                .fluid()
                .components(DiTertButylPeroxide, 1, Water, 1)
                .colorAverage()
                .build();

        DilutedTwoEthylhexylNitrate = new Material.Builder(13073, SuSyUtility.susyId('diluted_two_ethylhexyl_nitrate'))
                .fluid(FluidTypes.ACID)
                .components(TwoEthylhexylNitrate, 1, Water, 1, SulfuricAcid, 1)
                .colorAverage()
                .build();

        DilutedNitromethane = new Material.Builder(13074, SuSyUtility.susyId('diluted_nitromethane'))
                .fluid()
                .components(Nitromethane, 3, Water, 1)
                .colorAverage()
                .build();

        DilutedAmmoniumSulfateSolution = new Material.Builder(13075, SuSyUtility.susyId('diluted_ammonium_sulfate_solution'))
                .fluid()
                .components(AmmoniumSulfate, 1, Water, 2)
                .colorAverage()
                .build();

        AlluvialPlatinumMotherLiquor = new Material.Builder(13076, SuSyUtility.susyId('alluvial_platinum_mother_liquor'))
                .fluid()
                .components(Hydrogen, 2, Palladium, 1, Chlorine, 4, ZincChloride, 1, HydrogenChloride, 4, Water, 14)
                .colorAverage()
                .build();

        AlluvialPlatinumMotherLiquor.setFormula('(H2PdCl4)(ZnCl2)(HCl)4(H2O)14', true)

        AmmoniacalSodiumBicarbonateSolution = new Material.Builder(13077, SuSyUtility.susyId('ammoniacal_sodium_bicarbonate_solution'))
                .fluid()
                .components(AmmoniumChloride, 1, SodiumBicarbonate, 1, Water, 1)
                .colorAverage()
                .build();

        VeryDilutedSodiumSulfateSolution = new Material.Builder(13078, SuSyUtility.susyId('very_diluted_sodium_sulfate_solution'))
                .fluid()
                .components(SodiumSulfate, 1, Water, 9)
                .colorAverage()
                .build()

        MolybdicAcidSolution = new Material.Builder(13079, SuSyUtility.susyId('molybdic_acid_solution'))
                .fluid(FluidTypes.ACID)
                .components(Hydrogen, 2, Molybdenum, 1, Oxygen, 4, HydrogenChloride, 1, Water, 1)
                .colorAverage()
                .build()

        MolybdicAcidSolution.setFormula('(H2MoO4)(HCl)(H2O)', true)

        NeutralizedAmmoniumMolybdateSolution = new Material.Builder(13080, SuSyUtility.susyId('neutralized_ammonium_molybdate_solution'))
                .fluid()
                .components(Nitrogen, 2, Hydrogen, 8, Molybdenum, 1, Oxygen, 4, AmmoniumChloride, 1, Water, 4)
                .colorAverage()
                .build()

        NeutralizedAmmoniumMolybdateSolution.setFormula('[(NH4)2MoO4](NH4Cl)(H2O)4')

        SublimatedMolybdenumTrioxide = new Material.Builder(13081, SuSyUtility.susyId('sublimated_molybdenum_trioxide'))
                .fluid()
                .components(PurifiedMolybdenumTrioxide, 1, Air, 1)
                .colorAverage()
                .build()

        AmmoniumThiocyanateSolution = new Material.Builder(13082, SuSyUtility.susyId('ammonium_thiocyanate_solution'))
                .fluid()
                .components(AmmoniumThiocyanate, 1, Water, 1)
                .colorAverage()
                .build();

        TantalumFluorideSolution = new Material.Builder(13083, SuSyUtility.susyId('tantalum_fluoride_solution'))
                .fluid()
                .components(TantalumFluoride, 1, Water, 2)
                .colorAverage()
                .build();

        AmmoniumPerrhenateSolution = new Material.Builder(13084, SuSyUtility.susyId('ammonium_perrhenate_solution'))
                .fluid()
                .components(AmmoniumPerrhenate, 1, Water, 1)
                .colorAverage()
                .build();
        
        AluminiumChlorideSolution = new Material.Builder(13085, SuSyUtility.susyId('aluminium_chloride_solution'))
                .fluid()
                .components(AluminiumChloride, 1, Water, 3)
                .colorAverage()
                .build();

        DilutedSodiumSulfiteSolution = new Material.Builder(13086, SuSyUtility.susyId('diluted_sodium_sulfite_solution'))
                .fluid()
                .components(SodiumSulfite, 1, Water, 14)
                .color(0x75745a)
                .build();

        EGlass = new Material.Builder(13088, SuSyUtility.susyId('e_glass'))
                .dust().fluid()
                .components(SiliconDioxide, 6, Alumina, 1, BoronTrioxide, 1, Quicklime, 2)
                .color(0x778f8b)
                .build();

        AlluvialPalladiumMotherLiquor = new Material.Builder(13089, SuSyUtility.susyId('alluvial_palladium_mother_liquor'))
                .fluid()
                .components(AmmoniumChloride, 2, ZincChloride, 1, HydrogenChloride, 4, Water, 16)
                .colorAverage()
                .build();

        AlluvialDivalentPalladiumSolution = new Material.Builder(13090, SuSyUtility.susyId('alluvial_divalent_palladium_solution'))
                .fluid()
                .components(Hydrogen, 2, Palladium, 1, Chlorine, 4, ZincChloride, 1, HydrogenChloride, 4, Water, 14)
                .colorAverage()
                .build();

        AlluvialPlatinumMotherLiquor.setFormula('(H2PdCl4)(ZnCl2)(HCl)4(H2O)14', true)

        PlatinumPrecursorSolution = new Material.Builder(13091, SuSyUtility.susyId('platinum_precursor_solution'))
                .fluid()
                .components(AmmoniumHexachloroplatinate, 1, PhosphoricAcid, 1)
                .colorAverage()
                .build();

        SupportedPlatinum = new Material.Builder(13092, SuSyUtility.susyId('supported_platinum'))
                .dust()
                .components(Alumina, 1, Platinum, 1, Chlorine, 4)
                .flags(GENERATE_CATALYST_BED)
                .build()

        CrudeManganeseIISulfateSolution = new Material.Builder(13093, SuSyUtility.susyId('crude_manganese_ii_sulfate_solution'))
                .fluid()
                .components(ManganeseIISulfate, 1, Water, 1)
                .colorAverage()
                .build()
                .setFormula('(?)(MnSO4)(H2O)', true)

        ManganeseIISulfateSolution = new Material.Builder(13094, SuSyUtility.susyId('manganese_ii_sulfate_solution'))
                .fluid()
                .components(ManganeseIISulfate, 1, Water, 1)
                .colorAverage()
                .build()
                .setFormula('(MnSO4)(H2O)', true)

        DilutedZincChlorideSolution = new Material.Builder(13095, SuSyUtility.susyId("diluted_zinc_chloride_solution"))
                .fluid()
                .components(ZincChloride, 1, Water, 2)
                .colorAverage()
                .build();

        TrichlorosilaneSolution = new Material.Builder(13096, SuSyUtility.susyId("trichlorosilane_solution"))
                .fluid()
                .components(Trichlorosilane, 1, Toluene, 6)
                .colorAverage()
                .build();

        ImpureBariumSulfideSolution = new Material.Builder(13097, SuSyUtility.susyId("impure_barium_sulfide_solution"))
                .fluid()
                .components(ImpureBariumSulfide, 1, Water, 1)
                .colorAverage()
                .build();

        ImpureStrontiumSulfideSlurry = new Material.Builder(13098, SuSyUtility.susyId("impure_strontium_sulfide_slurry"))
                .fluid()
                .components(ImpureStrontiumSulfide, 1, Water, 1, SiliconDioxide, 1)
                .colorAverage()
                .build();

        DilutedSodiumCarbonateSolution = new Material.Builder(13099, SuSyUtility.susyId("diluted_sodium_carbonate_solution"))
                .fluid()
                .components(SodaAsh, 1, Water, 3)
                .colorAverage()
                .build();

        PalladiumOnCarbon = new Material.Builder(13100, SuSyUtility.susyId("palladium_on_carbon"))
                .dust()
                .components(Palladium, 1, ActivatedCarbon, 4)
                .colorAverage()
                .build();

        ManganeseIIChlorideSolution = new Material.Builder(13101, SuSyUtility.susyId("manganese_ii_chloride_solution"))
                .fluid()
                .components(ManganeseIIChloride, 1, Water, 3)
                .colorAverage()
                .build();

        DilutedManganeseIIChlorideSolution = new Material.Builder(13102, SuSyUtility.susyId("diluted_manganese_ii_chloride_solution"))
                .fluid()
                .components(ManganeseIIChloride, 1, Water, 6)
                .colorAverage()
                .build();

        PalladiumPrecursorSolution = new Material.Builder(13103, SuSyUtility.susyId("palladium_precursor_solution"))
                .fluid(FluidTypes.ACID)
                .components(PalladiumChloride, 1, PhosphoricAcid, 1)
                .colorAverage()
                .build();

        SupportedPalladium = new Material.Builder(13104, SuSyUtility.susyId("supported_palladium"))
                .dust()
                .components(PalladiumChloride, 1, Alumina, 1)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build();

        MixedCyanideSolution = new Material.Builder(13105, SuSyUtility.susyId("mixed_cyanide_solution"))
                .fluid()
                .components(SodiumCyanide, 2, Hydrogen, 2, Carbon, 2, Nitrogen, 2, Water, 1)
                .colorAverage()
                .build();

        MixedCyanideSolution.setFormula("(NaCN)2(HCN)2(H2O)", true)
    }
}
