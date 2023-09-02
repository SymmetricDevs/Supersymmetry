package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;

public class SecondDegreeMaterials {
    public static void register() {

        log.infoMC("Registering Second Degree Materials!");

        NitrateSaltMix = new Material.Builder(13000, 'nitrate_salt_mix')
                .dust()
                .components(AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        AmmoniumChlorideSolution = new Material.Builder(13001, "ammonium_chloride_solution")
                .fluid()
                .components(Water, 1, AmmoniumChloride, 1)
                .colorAverage()
                .build();

        PotassiumChlorideSolution = new Material.Builder(13002, "potassium_chloride_solution")
                .fluid()
                .color(0x3b5eeb)
                .components(Water, 1, RockSalt, 1)
                .colorAverage()
                .build();

        PotassiumBisulfateSolution = new Material.Builder(13003, "potassium_bisulfate_solution")
                .fluid()
                .components(Water, 1, PotassiumBisulfate, 1)
                .colorAverage()
                .build();

        SodiumBisulfateSolution = new Material.Builder(13004, "sodium_bisulfate_solution")
                .fluid()
                .components(Water, 1, SodiumBisulfate, 1)
                .colorAverage()
                .build();

        CalciumChlorideSolution = new Material.Builder(13005, "calcium_chloride_solution")
                .fluid()
                .components(Water, 1, CalciumChloride, 1)
                .colorAverage()
                .build();

        SodaAshSolution = new Material.Builder(13006, "soda_ash_solution")
                .fluid()
                .components(Water, 1, SodaAsh, 1)
                .colorAverage()
                .build();

        SodiumBicarbonateSolution = new Material.Builder(13007, "sodium_bicarbonate_solution")
                .fluid()
                .color(0x252747)
                .build()
                .setFormula("(H2O)(NaHCO3)", true)

        AmmoniumNitrateSolution = new Material.Builder(13008, 'ammonium_nitrate_solution')
                .fluid()
                .components(Water, 1, material('ammonium_nitrate'), 1)
                .colorAverage()
                .build();

        NitrateSolution = new Material.Builder(13009, 'nitrate_solution')
                .fluid()
                .components(Water, 2, AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        SodiumNitrateSolution = new Material.Builder(13010, 'sodium_nitrate_solution')
                .fluid()
                .components(Water, 1, SodiumNitrate, 1)
                .colorAverage()
                .build();

        DilutedPotassiumCarbonateSolution = new Material.Builder(13011, "diluted_potassium_carbonate_solution")
                .fluid()
                .components(Water, 3, PotassiumCarbonate, 1)
                .colorAverage()
                .build();

        PotassiumHydroxideSolution = new Material.Builder(13012, "potassium_hydroxide_solution")
                .fluid()
                .components(Water, 1, PotassiumHydroxide, 1)
                .colorAverage()
                .build();

        CalciumHydroxideSolution = new Material.Builder(13013, "calcium_hydroxide_solution")
                .fluid()
                .components(Water, 1, material('calcium_hydroxide'), 1)
                .colorAverage()
                .build();

        SodiumSilicateSolution = new Material.Builder(13014, "sodium_silicate_solution")
                .fluid()
                .components(Water, 1, SodiumSilicate, 1)
                .colorAverage()
                .build();

        SodiumAluminateSolution = new Material.Builder(13015, "sodium_aluminate_solution")
                .fluid()
                .components(SodiumAluminate, 1, Water, 1)
                .color(0x3f71bf)
                .build();

        SodiumFluorideSolution = new Material.Builder(13016, "sodium_fluoride_solution")
                .fluid()
                .components(SodiumFluoride, 1, Water, 1)
                .colorAverage()
                .build();

        PotassiumFluorideSolution = new Material.Builder(13017, "potassium_fluoride_solution")
                .fluid()
                .components(Water, 1, PotassiumFluoride, 1)
                .colorAverage()
                .build();

        PotassiumTetrafluoroborateSolution = new Material.Builder(13018, "potassium_tetrafluoroborate_solution")
                .fluid()
                .components(Water, 7, PotassiumTetrafluoroborate, 2)
                .color(0x8fb5a3)
                .build();

        SodiumBromideSolution = new Material.Builder(13019, "sodium_bromide_solution")
                .fluid()
                .components(SodiumBromide, 1, Water, 1)
                .colorAverage()
                .build();

        WackerCatalyst = new Material.Builder(13020, "wacker_catalyst")
                .dust()
                .components(PalladiumChloride, 1, CopperIIChloride, 1)
                .colorAverage()
                .build();

        PotassiumIodideSolution = new Material.Builder(13021, "potassium_iodide_solution")
                .fluid()
                .components(Water, 1, PotassiumIodide, 1)
                .colorAverage()
                .build();

        SodiumSulfateSolution = new Material.Builder(13022, "sodium_sulfate_solution")
                .fluid()
                .color(0xb0b0bf)
                .build()
                .setFormula("(H2O)(Na2SO4)", true);

        ImpregnatedCopperOxideCatalyst = new Material.Builder(13023, "impregnated_copper_oxide_catalyst")
                .dust()
                .components(CupricOxide, 1, Alumina, 1)
                .colorAverage()
                .build()

        PhilipsCatalyst = new Material.Builder(13024, "philips_catalyst")
                .dust()
                .components(SiliconDioxide, 1, ChromiumTrioxide, 1)
                .colorAverage()
                .build()

        ZieglerNattaCatalyst = new Material.Builder(13025, "ziegler_natta_catalyst")
                .dust()
                .components(Triethylaluminium, 1, TitaniumTetrachloride, 1)
                .colorAverage()
                .build()

        HydrogenPeroxideSolution = new Material.Builder(13026, "hydrogen_peroxide_solution")
                .fluid()
                .components(Water, 1, HydrogenPeroxide, 1)
                .colorAverage()
                .build()

        AmmoniumAcetateSolution = new Material.Builder(13027, 'ammonium_acetate_solution')
                .fluid()
                .components(Water, 1, Carbon, 2, Hydrogen, 7, Nitrogen, 1, Oxygen, 2)
                .colorAverage()
                .build()

        TetramethylammoniumHydroxideSolution = new Material.Builder(13028, 'tetramethylammonium_hydroxide_solution')
                .fluid()
                .components(Methanol, 1, TetramethylammoniumHydroxide, 1)
                .colorAverage()
                .build()

        SodiumSulfiteSolution = new Material.Builder(13029, "sodium_sulfite_solution")
                .fluid()
                .components(SodiumSulfite, 1, Water, 1)
                .colorAverage()
                .build()

        PhosphorusSolution = new Material.Builder(13030, 'phosphorus_solution')
                .fluid()
                .components(PhosphorusTrichloride, 1, Phosphorus, 1)
                .colorAverage()
                .build()

        SodiumCyanideSolution = new Material.Builder(13031, 'sodium_cyanide_solution')
                .fluid()
                .components(Water, 2, SodiumCyanide, 1)
                .colorAverage()
                .build()

        BrominatedSulfurDioxide = new Material.Builder(13032, 'brominated_sulfur_dioxide')
                .fluid()
                .components(SulfuricAcid, 1, HydrobromicAcid, 2)
                .colorAverage()
                .build()

        SodiumThiosulfateSolution = new Material.Builder(13033, "sodium_thiosulfate_solution")
                .fluid()
                .components(SodiumThiosulfate, 1, Water, 1)
                .colorAverage()
                .build()

        SodiumPerchlorateSolution = new Material.Builder(13035, 'sodium_perchlorate_solution')
                .fluid()
                .color(0x5880c7)
                .build()

        SodiumPerchlorateSolution.setFormula("(H2O)(NaClO4)", true);

        SodiumChlorateSolution = new Material.Builder(13036, 'sodium_chlorate_solution')
                .fluid()
                .color(0x315fe8)
                .build()

        SodiumChlorateSolution.setFormula("(H2O)(NaClO3)", true);

        DilutedAniline = new Material.Builder(13037, 'diluted_aniline')
                .fluid()
                .color(0x5fb36e)
                .build()

        DilutedAniline.setFormula("(H2O)2(C6H5NH2)", true);

        DilutedIron3ChlorideSolution = new Material.Builder(13038, "diluted_iron_iii_chloride_solution")
                .fluid()
                .components(Iron3Chloride, 1, Water, 3)
                .colorAverage()
                .build()

        ChloroauricAcidSolution = new Material.Builder(13039, "chloroauric_acid_solution")
                .fluid()
                .components(ChloroauricAcid, 3, NitricAcid, 1, Water, 6)
                .color(0xd69129)
                .build();

        ZincChlorideSolution = new Material.Builder(13040, "zinc_chloride_solution")
                .fluid()
                .components(ZincChloride, 1, Water, 1)
                .colorAverage()
                .build();

        WohlwillElectrolyte = new Material.Builder(13041, "wohlwill_electrolyte")
                .fluid()
                .components(ChloroauricAcid, 1, Water, 1, HydrogenChloride, 2)
                .color(0xe8b833)
                .build();

        SpentWohlwilElectrolyte = new Material.Builder(13042, "spent_wohlwill_electrolyte")
                .fluid()
                .components(ChloroauricAcid, 1, Water, 1, HydrogenChloride, 2)
                .color(0xfacd50)
                .build();

        SpentWohlwilElectrolyte.setFormula("(?)(H[AuCl4])(H2O)(HCl)2", true)

        GoldOreSlurry = new Material.Builder(13043, "gold_ore_slurry")
                .fluid()
                .components(GoldConcentrate, 4, Water, 6)
                .colorAverage()
                .build();

        GoldEluent = new Material.Builder(13044, "gold_eluent")
                .fluid()
                .components(SodiumCyanide, 1, SodiumHydroxide, 1, Water, 27)
                .colorAverage()
                .build();

        GoldEluteSolution = new Material.Builder(13045, "gold_elute_solution")
                .fluid()
                .components(SodiumCyanide, 1, SodiumHydroxide, 1, Sodium, 27, Gold, 27, Carbon, 54, Nitrogen, 54, Water, 27)
                .color(0xbbcc64)
                .build();

        GoldEluteSolution.setFormula("(NaCN)(NaOH)(Na[Au(CN)2])27(H2O)27", true)

        PotassiumCarbonateSolution = new Material.Builder(13046, "potassium_carbonate_solution")
                .fluid()
                .components(PotassiumCarbonate, 1, Water, 1)
                .colorAverage()
                .build()

        PotassiumSulfateSolution = new Material.Builder(13047, "potassium_sulfate_solution")
                .fluid()
                .components(PotassiumSulfate, 1, Water, 1)
                .colorAverage()
                .build()

        PhosphoriteSlurry = new Material.Builder(13048, "phosphorite_slurry")
                .fluid()
                .components(Phosphorite, 2, Water, 1)
                .colorAverage()
                .build()
      
        DilutedHexafluorosilicicAcid = new Material.Builder(13049, "diluted_hexafluorosilicic_acid")
                .fluid()
                .components(Water, 8, HexafluorosilicicAcid, 1)
                .colorAverage()
                .build()

        LithiumSulfateSolution = new Material.Builder(13050, "lithium_sulfate_solution")
                .fluid()
                .components(Water, 1, LithiumSulfate, 1)
                .colorAverage()
                .build()

        DilutedSodiumSulfateSolution = new Material.Builder(13051, "diluted_sodium_sulfate_solution")
                .fluid()
                .color(0x9191b3)
                .build()
                .setFormula("(H2O)2(Na2SO4)", true);

        DilutedHydrofluoricAcid = new Material.Builder(13052, "diluted_hydrofluoric_acid")
                .fluid()
                .components(Water, 2, HydrogenFluoride, 1)
                .colorAverage()
                .build();

        FluorideFusedBeryl = new Material.Builder(13053, "fluoride_fused_beryl")
                .dust()
                .components(SodiumFluoroberyllate, 6, Alumina, 2, SiliconDioxide, 15)
                .color(0x424f3e)
                .build();

        SodiumFluoroberyllateSolution = new Material.Builder(13054, "sodium_fluoroberyllate_solution")
                .fluid()
                .components(SodiumFluoroberyllate, 1, Water, 1)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllateSolution = new Material.Builder(13055, "ammonium_fluoroberyllate_solution")
                .fluid()
                .components(AmmoniumFluoroberyllate, 1, Water, 3)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllateSolution.setFormula("(NH4)2(BeF4)(H2O)3", true)

        AmmoniumFluorideSolution = new Material.Builder(13056, "ammonium_fluoride_solution")
                .fluid()
                .components(AmmoniumFluoride, 1, Water, 1)
                .colorAverage()
                .build();

        AlkaliFusedBeryl = new Material.Builder(13057, "alkali_fused_beryl")
                .dust()
                .components(Emerald, 1, SodaAsh, 1)
                .colorAverage()
                .build();

        AluminiumSulfateSolution = new Material.Builder(13058, "aluminium_sulfate_solution")
                .fluid()
                .components(AluminiumSulfate, 1, Water, 6)
                .colorAverage()
                .build();

        DilutedBromooctane = new Material.Builder(13059, "diluted_bromooctane")
                .fluid()
                .components(Bromooctane, 1, Water, 1)
                .colorAverage()
                .build()

        CopperSulfateSolution = new Material.Builder(13060, "copper_sulfate_solution")
                .fluid()
                .components(CopperSulfate, 1, Water, 1)
                .color(0x2d3bcf)
                .build();

        BariumChlorideSolution = new Material.Builder(13061, "barium_chloride_solution")
                .fluid()
                .components(BariumChloride, 1, Water, 2)
                .colorAverage()
                .build();

        DilutedSodiumSilicateSolution = new Material.Builder(13062, "diluted_sodium_silicate_solution")
                .fluid()
                .components(Water, 4, SodiumSilicate, 1)
                .colorAverage()
                .build();

        SodiumDichromateSolution = new Material.Builder(13063, "sodium_dichromate_solution")
                .fluid()
                .components(SodiumDichromate, 1, Water, 1, SulfuricAcid, 1)
                .color(0xe0912f)
                .build();

        ChromiumSodaMixture = new Material.Builder(13064, "chromium_soda_mixture")
                .dust()
                .components(ChromiumIIIOxide, 1, SodaAsh, 1)
                .build();

        LeadChlorideSolution = new Material.Builder(13066, "lead_chloride_solution")
                .fluid()
                .fluidTemp(343)
                .components(Water, 1, LeadChloride, 1)
                .colorAverage()
                .build();

        AmmoniumSulfateSolution = new Material.Builder(13067, "ammonium_sulfate_solution")
                .fluid()
                .components(AmmoniumSulfate, 1, Water, 1)
                .colorAverage()
                .build();

        AmmoniumChromeAlumSolution = new Material.Builder(13068, "ammonium_chrome_alum_solution")
                .fluid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .build();

        AgedAmmoniumChromeAlumSolution = new Material.Builder(13069, "aged_ammonium_chrome_alum_solution")
                .fluid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .build();

        PurifiedAmmoniumChromeAlumSolution = new Material.Builder(13070, "purified_ammonium_chrome_alum_solution")
                .fluid()
                .components(AmmoniumChromeAlum, 1, Water, 1)
                .color(0x7643a3)
                .build();

        AmmoniumIronIISulfateSolution = new Material.Builder(13071, "ammonium_iron_ii_sulfate_solution")
                .fluid()
                .fluidTemp(343)
                .components(AmmoniumIronIISulfate, 1, Water, 1)
                .color(0x70cc6e)
                .build();

        DilutedDiTertButylPeroxide = new Material.Builder(13072, "diluted_di_tert_butyl_peroxide")
                .fluid()
                .components(DiTertButylPeroxide, 1, Water, 1)
                .colorAverage()
                .build();

        DilutedTwoEthylhexylNitrate = new Material.Builder(13073, "diluted_two_ethylhexyl_nitrate")
                .fluid()
                .components(TwoEthylhexylNitrate, 1, Water, 1, SulfuricAcid, 1)
                .colorAverage()
                .build();

        DilutedNitromethane = new Material.Builder(13074, "diluted_nitromethane")
                .fluid()
                .components(Nitromethane, 3, Water, 1)
                .colorAverage()
                .build();

        DilutedAmmoniumSulfateSolution = new Material.Builder(13075, "diluted_ammonium_sulfate_solution")
                .fluid()
                .components(AmmoniumSulfate, 1, Water, 2)
                .colorAverage()
                .build();

        PlatinumMotherLiquor = new Material.Builder(13076, "platinum_mother_liquor")
                .fluid()
                .components(AmmoniumChloride, 1, HydrogenChloride, 6, Water, 8)
                .colorAverage()
                .build();

        PlatinumMotherLiquor.setFormula("(?)(NH4Cl)(HCl)6(H2O)8", true)

        AmmoniacalSodiumBicarbonateSolution = new Material.Builder(13077, "ammoniacal_sodium_bicarbonate_solution")
                .fluid()
                .components(AmmoniumChloride, 1, SodiumBicarbonate, 1, Water, 1)
                .colorAverage()
                .build()

        VeryDilutedSodiumSulfateSolution = new Material.Builder(13078, "very_diluted_sodium_sulfate_solution")
                .fluid()
                .components(SodiumSulfate, 1, Water, 9)
                .colorAverage()
                .build()

        MolybdenicAcidSolution = new Material.Builder(13079, "molybdenic_acid_solution")
                .fluid()
                .components(Hydrogen, 2, Molybdenum, 1, Oxygen, 4, HydrogenChloride, 1, Water, 1)
                .colorAverage()
                .build()

        MolybdenicAcidSolution.setFormula("(H2MoO4)(HCl)(H2O)", true)

        NeutralizedAmmoniumMolybdateSolution = new Material.Builder(13080, "neutralized_ammonium_molybdate_solution")
                .fluid()
                .components(Nitrogen, 2, Hydrogen, 8, Molybdenum, 1, Oxygen, 4, AmmoniumChloride, 1, Water, 4)
                .colorAverage()
                .build()

        NeutralizedAmmoniumMolybdateSolution.setFormula("[(NH4)2MoO4](NH4Cl)(H2O)4")

        SublimatedMolybdenumTrioxide = new Material.Builder(13081, "sublimated_molybdenum_trioxide")
                .fluid()
                .components(PurifiedMolybdenumTrioxide, 1, Air, 1)
                .colorAverage()
                .build()

        AmmoniumThiocyanateSolution = new Material.Builder(13082, "ammonium_thiocyanate_solution")
                .fluid()
                .components(AmmoniumThiocyanate, 1, Water, 1)
                .colorAverage()
                .build();

        TantalumFluorideSolution = new Material.Builder(13083, "tantalum_fluoride_solution")
                .fluid()
                .components(TantalumFluoride, 1, Water, 2)
                .colorAverage()
                .build();

        AmmoniumPerrhenateSolution = new Material.Builder(13084, "ammonium_perrhenate_solution")
                .fluid()
                .components(AmmoniumPerrhenate, 1, Water, 1)
                .colorAverage()
                .build();
        
        AluminiumChlorideSolution = new Material.Builder(13085, "aluminium_chloride_solution")
                .fluid()
                .components(AluminiumChloride, 1, Water, 3)
                .colorAverage()
                .build();

        PalladiumMotherLiquor = new Material.Builder(13086, "palladium_mother_liquor")
                .fluid()
                .components(AmmoniumChloride, 1, Ammonia, 2, HydrogenChloride, 8, Water, 12)
                .colorAverage()
                .build();

        DivalentPalladiumSolution = new Material.Builder(13087, "divalent_palladium_solution")
                .fluid()
                .components(AmmoniumChloride, 1, HydrogenChloride, 6, Water, 8)
                .colorAverage()
                .build();

        DivalentPalladiumSolution.setFormula("(?)(NH4Cl)(HCl)6(H2O)8", true)
    }
}
