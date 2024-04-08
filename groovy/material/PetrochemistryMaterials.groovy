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


public class PetrochemistryMaterials {
 
    public static void register() {

        log.infoMC('Registering Petrochemistry Materials!');
        
        DilutedOilLight = new Material.Builder(20000, SuSyUtility.susyId('diluted_oil_light'))
                .liquid()
                .color(0x2d2f3b)
                .build();

        DilutedOil = new Material.Builder(20001, SuSyUtility.susyId('diluted_oil'))
                .liquid()
                .color(0x2d2f3b)
                .build();

        DilutedOilHeavy = new Material.Builder(20002, SuSyUtility.susyId('diluted_oil_heavy'))
                .liquid()
                .color(0x2d2f3b)
                .build();

        DesaltedOilHeavy = new Material.Builder(20003, SuSyUtility.susyId('desalted_oil_heavy'))
                .liquid()
                .color(0x000000)
                .build();

        DesaltedOilLight = new Material.Builder(20004, SuSyUtility.susyId('desalted_oil_light'))
                .liquid()
                .color(0x000000)
                .build();

        DesaltedOil = new Material.Builder(20005, SuSyUtility.susyId('desalted_oil'))
                .liquid()
                .color(0x000000)
                .build();

        OilyBrine = new Material.Builder(20006, SuSyUtility.susyId('oily_brine'))
                .liquid()
                .color(0x69684e)
                .build();

        SulfuricOilResidue = new Material.Builder(20007, SuSyUtility.susyId('sulfuric_oil_residue'))
                .liquid()
                .color(0x59572b)
                .build();

        SulfuricFuelOil = new Material.Builder(20009, SuSyUtility.susyId('sulfuric_fuel_oil'))
                .liquid()
                .color(0x858135)
                .build();

        TreatedSulfuricFuelOil = new Material.Builder(20010, SuSyUtility.susyId('treated_sulfuric_fuel_oil'))
                .liquid()
                .color(0x9e9a4f)
                .build();

        CrudeNaturalGas = new Material.Builder(20011, SuSyUtility.susyId('crude_natural_gas'))
                .gas()
                .color(0xc9c9b9)
                .build();

        SulfuricNaturalGas = new Material.Builder(20012, SuSyUtility.susyId('sulfuric_natural_gas'))
                .gas()
                .color(0xe3e3d1)
                .build();

        TreatedSulfuricNaturalGas = new Material.Builder(20013, SuSyUtility.susyId('treated_sulfuric_natural_gas'))
                .gas()
                .color(0xf7f7eb)
                .build();

        TreatedSulfuricRefineryGas = new Material.Builder(20014, SuSyUtility.susyId('treated_sulfuric_refinery_gas'))
                .gas()
                .color(0xe3e3d8)
                .build();

        SourGas = new Material.Builder(20015, SuSyUtility.susyId('sour_gas'))
                .gas()
                .color(0xebeba4)
                .build();

        SulfuricDiesel = new Material.Builder(20016, SuSyUtility.susyId('sulfuric_diesel'))
                .liquid()
                .color(0xa8a232)
                .build();

        TreatedSulfuricDiesel = new Material.Builder(20017, SuSyUtility.susyId('treated_sulfuric_diesel'))
                .liquid()
                .color(0xc2bb42)
                .build();

        SulfuricKerosene = new Material.Builder(20018, SuSyUtility.susyId('sulfuric_kerosene'))
                .liquid()
                .color(0xbfb82a)
                .build();

        TreatedSulfuricKerosene = new Material.Builder(20019, SuSyUtility.susyId('treated_sulfuric_kerosene'))
                .liquid()
                .color(0xd6cf3a)
                .build();

        Kerosene = new Material.Builder(20020, SuSyUtility.susyId('kerosene'))
                .liquid()
                .color(0xd6cf3a)
                .flags(FLAMMABLE)
                .build();

        SulfuricGasoline = new Material.Builder(20021, SuSyUtility.susyId('sulfuric_gasoline'))
                .liquid()
                .color(0xe8df23)
                .build();

        TreatedSulfuricGasoline = new Material.Builder(20022, SuSyUtility.susyId('treated_sulfuric_gasoline'))
                .liquid()
                .color(0xf7ef40)
                .build();

        FuelOil = new Material.Builder(20023, SuSyUtility.susyId('fuel_oil'))
                .liquid()
                .color(0x9e9a4f)
                .flags(FLAMMABLE)
                .build();

        LubricatingOil = new Material.Builder(20024, SuSyUtility.susyId('lubricating_oil'))
                .liquid()
                .color(0x858146)
                .flags(FLAMMABLE)
                .build();

        SlackWax = new Material.Builder(20025, SuSyUtility.susyId('slack_wax'))
                .liquid()
                .color(0x7d7b59)
                .build();

        Resin = new Material.Builder(20026, SuSyUtility.susyId('resin'))
                .liquid()
                .color(0xb5803a)
                .build();

        UncatalyzedSulfurousGases = new Material.Builder(20027, SuSyUtility.susyId('uncatalyzed_sulfurous_gases'))
                .gas(new FluidBuilder().temperature(773))
                .color(0xd6d372)
                .build();

        NaphthaReformate = new Material.Builder(20028, SuSyUtility.susyId('naphtha_reformate'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf2f2a0)
                .build();

        BtexExtract = new Material.Builder(20029, SuSyUtility.susyId('btex_extract'))
                .liquid()
                .color(0xa8a87d)
                .build();

        BTEX = new Material.Builder(20030, SuSyUtility.susyId('btex'))
                .liquid()
                .color(0x828267)
                .build();

        LightlySteamcrackedKerosene = new Material.Builder(20031, SuSyUtility.susyId('lightly_steamcracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xe3dd59)
                .build();

        SeverelySteamcrackedKerosene = new Material.Builder(20032, SuSyUtility.susyId('severely_steamcracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf2ed83)
                .build();

        LightlyHydrocrackedKerosene = new Material.Builder(20033, SuSyUtility.susyId('lightly_hydrocracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xc4bf51)
                .build();

        SeverelyHydrocrackedKerosene = new Material.Builder(20034, SuSyUtility.susyId('severely_hydrocracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbab65f)
                .build();

        LightlySteamcrackedGasoline = new Material.Builder(20035, SuSyUtility.susyId('lightly_steamcracked_gasoline'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xebe34d)
                .build();

        SeverelySteamcrackedGasoline = new Material.Builder(20036, SuSyUtility.susyId('severely_steamcracked_gasoline'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf5ed62)
                .build();

        LightlyHydrocrackedGasoline = new Material.Builder(20037, SuSyUtility.susyId('lightly_hydrocracked_gasoline'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xccc43f)
                .build();

        SeverelyHydrocrackedGasoline = new Material.Builder(20038, SuSyUtility.susyId('severely_hydrocracked_gasoline'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbdb648)
                .build();

        UpgradedLubricatingOilMix = new Material.Builder(20054, SuSyUtility.susyId('upgraded_lubricating_oil_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x948f43)
                .build();

        UpgradedFuelOilMix = new Material.Builder(20055, SuSyUtility.susyId('upgraded_fuel_oil_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x918d33)
                .build();

        UpgradedDieselMix = new Material.Builder(20056, SuSyUtility.susyId('upgraded_diesel_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbab32f)
                .build();

        UpgradedKeroseneMix = new Material.Builder(20057, SuSyUtility.susyId('upgraded_kerosene_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xe3db30)
                .build();

        UpgradedNaphthaMix = new Material.Builder(20058, SuSyUtility.susyId('upgraded_naphtha_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf0e83e)
                .build();

        AlkylatedNaturalGas = new Material.Builder(20059, SuSyUtility.susyId('alkylated_natural_gas'))
                .gas()
                .color(0xe6e4c1)
                .build();

        AlkylatedRefineryGas = new Material.Builder(20060, SuSyUtility.susyId('alkylated_refinery_gas'))
                .gas()
                .color(0xf7f5cb)
                .build();

        Syngas = new Material.Builder(20061, SuSyUtility.susyId('syngas'))
                .gas()
                .color(0xf2ecdc)
                .flags(FLAMMABLE)
                .build()
                .setFormula('(H)6(CO)', true);

        ReformedSyngas = new Material.Builder(20062, SuSyUtility.susyId('reformed_syngas'))
                .gas(new FluidBuilder().temperature(800))
                .color(0xfcf3d9)
                .build();

        SulfuricRefineryGas = new Material.Builder(20063, SuSyUtility.susyId('sulfuric_refinery_gas'))
                .gas()
                .color(0xe3e3d8)
                .build();

        TreatedSulfuricNaphtha = new Material.Builder(20064, SuSyUtility.susyId('treated_sulfuric_naphtha'))
                .gas()
                .color(0xcec929)
                .build();

        LightOilyBrine = new Material.Builder(20065, SuSyUtility.susyId('light_oily_brine'))
                .liquid()
                .color(0x7d7c61)
                .build();

        HeavyOilyBrine = new Material.Builder(20066, SuSyUtility.susyId('heavy_oily_brine'))
                .liquid()
                .color(0x4f4e37)
                .build();

        LightBitumenSolution = new Material.Builder(20067, SuSyUtility.susyId('light_bitumen_solution'))
                .liquid()
                .color(0x1e2021)
                .build();

        BitumenSolution = new Material.Builder(20068, SuSyUtility.susyId('bitumen_solution'))
                .liquid()
                .color(0x1e2021)
                .build();

        HeavyBitumenSolution = new Material.Builder(20069, SuSyUtility.susyId('heavy_bitumen_solution'))
                .liquid()
                .color(0x1e2021)
                .build();

        CrudeLubricatingOil = new Material.Builder(20070, SuSyUtility.susyId('crude_lubricating_oil'))
                .liquid()
                .color(0x80743c)
                .build();

        SolventLubricantMixture = new Material.Builder(20071, SuSyUtility.susyId('solvent_lubricant_mixture'))
                .liquid()
                .color(0x6e803c)
                .build();

        ColdSolventLubricantMixture = new Material.Builder(20072, SuSyUtility.susyId('cold_solvent_lubricant_mixture'))
                .liquid(new FluidBuilder().temperature(273))
                .color(0x5e8064)
                .build();

        DewaxedLubricantMixture = new Material.Builder(20073, SuSyUtility.susyId('dewaxed_lubricant_mixture'))
                .liquid()
                .color(0x7d782e)
                .build();

        SulfuricLubricatingOil = new Material.Builder(20074, SuSyUtility.susyId('sulfuric_lubricating_oil'))
                .liquid()
                .color(0x7d782e)
                .build();

        CFiveFraction = new Material.Builder(20075, SuSyUtility.susyId('c_five_fraction'))
                .liquid()
                .color(0x9c8638)
                .build();

        DimerizedCFiveFraction = new Material.Builder(20076, SuSyUtility.susyId('dimerized_c_five_fraction'))
                .liquid()
                .color(0x9c9538)
                .build();
    }
}           