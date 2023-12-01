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


public class PetrochemistryMaterials {
 
    public static void register() {

        log.infoMC('Registering Petrochemistry Materials!');
        
        DilutedOilLight = new Material.Builder(20000, SuSyUtility.susyId('diluted_oil_light'))
                .fluid()
                .color(0x2d2f3b)
                .build();

        DilutedOil = new Material.Builder(20001, SuSyUtility.susyId('diluted_oil'))
                .fluid()
                .color(0x2d2f3b)
                .build();

        DilutedOilHeavy = new Material.Builder(20002, SuSyUtility.susyId('diluted_oil_heavy'))
                .fluid()
                .color(0x2d2f3b)
                .build();

        DesaltedOilHeavy = new Material.Builder(20003, SuSyUtility.susyId('desalted_oil_heavy'))
                .fluid()
                .color(0x000000)
                .build();

        DesaltedOilLight = new Material.Builder(20004, SuSyUtility.susyId('desalted_oil_light'))
                .fluid()
                .color(0x000000)
                .build();

        DesaltedOil = new Material.Builder(20005, SuSyUtility.susyId('desalted_oil'))
                .fluid()
                .color(0x000000)
                .build();

        OilyBrine = new Material.Builder(20006, SuSyUtility.susyId('oily_brine'))
                .fluid()
                .color(0x69684e)
                .build();

        SulfuricOilResidue = new Material.Builder(20007, SuSyUtility.susyId('sulfuric_oil_residue'))
                .fluid()
                .color(0x59572b)
                .build();

        SulfuricFuelOil = new Material.Builder(20009, SuSyUtility.susyId('sulfuric_fuel_oil'))
                .fluid()
                .color(0x858135)
                .build();

        TreatedSulfuricFuelOil = new Material.Builder(20010, SuSyUtility.susyId('treated_sulfuric_fuel_oil'))
                .fluid()
                .color(0x9e9a4f)
                .build();

        CrudeNaturalGas = new Material.Builder(20011, SuSyUtility.susyId('crude_natural_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xc9c9b9)
                .build();

        SulfuricNaturalGas = new Material.Builder(20012, SuSyUtility.susyId('sulfuric_natural_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xe3e3d1)
                .build();

        TreatedSulfuricNaturalGas = new Material.Builder(20013, SuSyUtility.susyId('treated_sulfuric_natural_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xf7f7eb)
                .build();

        TreatedSulfuricRefineryGas = new Material.Builder(20014, SuSyUtility.susyId('treated_sulfuric_refinery_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xe3e3d8)
                .build();

        SourGas = new Material.Builder(20015, SuSyUtility.susyId('sour_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xebeba4)
                .build();

        SulfuricDiesel = new Material.Builder(20016, SuSyUtility.susyId('sulfuric_diesel'))
                .fluid()
                .color(0xa8a232)
                .build();

        TreatedSulfuricDiesel = new Material.Builder(20017, SuSyUtility.susyId('treated_sulfuric_diesel'))
                .fluid()
                .color(0xc2bb42)
                .build();

        SulfuricKerosene = new Material.Builder(20018, SuSyUtility.susyId('sulfuric_kerosene'))
                .fluid()
                .color(0xbfb82a)
                .build();

        TreatedSulfuricKerosene = new Material.Builder(20019, SuSyUtility.susyId('treated_sulfuric_kerosene'))
                .fluid()
                .color(0xd6cf3a)
                .build();

        Kerosene = new Material.Builder(20020, SuSyUtility.susyId('kerosene'))
                .fluid()
                .color(0xd6cf3a)
                .build();

        SulfuricGasoline = new Material.Builder(20021, SuSyUtility.susyId('sulfuric_gasoline'))
                .fluid()
                .color(0xe8df23)
                .build();

        TreatedSulfuricGasoline = new Material.Builder(20022, SuSyUtility.susyId('treated_sulfuric_gasoline'))
                .fluid()
                .color(0xf7ef40)
                .build();

        FuelOil = new Material.Builder(20023, SuSyUtility.susyId('fuel_oil'))
                .fluid()
                .color(0x9e9a4f)
                .build();

        LubricatingOil = new Material.Builder(20024, SuSyUtility.susyId('lubricating_oil'))
                .fluid()
                .color(0x858146)
                .build();

        SlackWax = new Material.Builder(20025, SuSyUtility.susyId('slack_wax'))
                .fluid()
                .color(0x7d7b59)
                .build();

        Resin = new Material.Builder(20026, SuSyUtility.susyId('resin'))
                .fluid()
                .color(0xb5803a)
                .build();

        UncatalyzedSulfurousGases = new Material.Builder(20027, SuSyUtility.susyId('uncatalyzed_sulfurous_gases'))
                .fluid(FluidTypes.GAS)
                .color(0xd6d372)
                .fluidTemp(773)
                .build();

        NaphthaReformate = new Material.Builder(20028, SuSyUtility.susyId('naphtha_reformate'))
                .fluid()
                .color(0xf2f2a0)
                .fluidTemp(773)
                .build();

        BtexExtract = new Material.Builder(20029, SuSyUtility.susyId('btex_extract'))
                .fluid()
                .color(0xa8a87d)
                .build();

        BTEX = new Material.Builder(20030, SuSyUtility.susyId('btex'))
                .fluid()
                .color(0x828267)
                .build();

        LightlySteamcrackedKerosene = new Material.Builder(20031, SuSyUtility.susyId('lightly_steamcracked_kerosene'))
                .fluid()
                .color(0xe3dd59)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedKerosene = new Material.Builder(20032, SuSyUtility.susyId('severely_steamcracked_kerosene'))
                .fluid()
                .color(0xf2ed83)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedKerosene = new Material.Builder(20033, SuSyUtility.susyId('lightly_hydrocracked_kerosene'))
                .fluid()
                .color(0xc4bf51)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedKerosene = new Material.Builder(20034, SuSyUtility.susyId('severely_hydrocracked_kerosene'))
                .fluid()
                .color(0xbab65f)
                .fluidTemp(773)
                .build();

        LightlySteamcrackedGasoline = new Material.Builder(20035, SuSyUtility.susyId('lightly_steamcracked_gasoline'))
                .fluid()
                .color(0xebe34d)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedGasoline = new Material.Builder(20036, SuSyUtility.susyId('severely_steamcracked_gasoline'))
                .fluid()
                .color(0xf5ed62)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedGasoline = new Material.Builder(20037, SuSyUtility.susyId('lightly_hydrocracked_gasoline'))
                .fluid()
                .color(0xccc43f)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedGasoline = new Material.Builder(20038, SuSyUtility.susyId('severely_hydrocracked_gasoline'))
                .fluid()
                .color(0xbdb648)
                .fluidTemp(773)
                .build();


        UpgradedLubricatingOilMix = new Material.Builder(20054, SuSyUtility.susyId('upgraded_lubricating_oil_mix'))
                .fluid()
                .color(0x948f43)
                .fluidTemp(773)
                .build();

        UpgradedFuelOilMix = new Material.Builder(20055, SuSyUtility.susyId('upgraded_fuel_oil_mix'))
                .fluid()
                .color(0x918d33)
                .fluidTemp(773)
                .build();

        UpgradedDieselMix = new Material.Builder(20056, SuSyUtility.susyId('upgraded_diesel_mix'))
                .fluid()
                .color(0xbab32f)
                .fluidTemp(773)
                .build();

        UpgradedKeroseneMix = new Material.Builder(20057, SuSyUtility.susyId('upgraded_kerosene_mix'))
                .fluid()
                .color(0xe3db30)
                .fluidTemp(773)
                .build();

        UpgradedNaphthaMix = new Material.Builder(20058, SuSyUtility.susyId('upgraded_naphtha_mix'))
                .fluid()
                .color(0xf0e83e)
                .fluidTemp(773)
                .build();

        AlkylatedNaturalGas = new Material.Builder(20059, SuSyUtility.susyId('alkylated_natural_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xe6e4c1)
                .build();

        AlkylatedRefineryGas = new Material.Builder(20060, SuSyUtility.susyId('alkylated_refinery_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xf7f5cb)
                .build();

        Syngas = new Material.Builder(20061, SuSyUtility.susyId('syngas'))
                .fluid(FluidTypes.GAS)
                .color(0xf2ecdc)
                .build()
                .setFormula('(H)6(CO)', true);

        ReformedSyngas = new Material.Builder(20062, SuSyUtility.susyId('reformed_syngas'))
                .fluid(FluidTypes.GAS)
                .color(0xfcf3d9)
                .fluidTemp(800)
                .build();

        SulfuricRefineryGas = new Material.Builder(20063, SuSyUtility.susyId('sulfuric_refinery_gas'))
                .fluid(FluidTypes.GAS)
                .color(0xe3e3d8)
                .build();

        TreatedSulfuricNaphtha = new Material.Builder(20064, SuSyUtility.susyId('treated_sulfuric_naphtha'))
                .fluid(FluidTypes.GAS)
                .color(0xcec929)
                .build();

        LightOilyBrine = new Material.Builder(20065, SuSyUtility.susyId('light_oily_brine'))
                .fluid()
                .color(0x7d7c61)
                .build();

        HeavyOilyBrine = new Material.Builder(20066, SuSyUtility.susyId('heavy_oily_brine'))
                .fluid()
                .color(0x4f4e37)
                .build();

        LightBitumenSolution = new Material.Builder(20067, SuSyUtility.susyId('light_bitumen_solution'))
                .fluid()
                .color(0x1e2021)
                .build();

        BitumenSolution = new Material.Builder(20068, SuSyUtility.susyId('bitumen_solution'))
                .fluid()
                .color(0x1e2021)
                .build();

        HeavyBitumenSolution = new Material.Builder(20069, SuSyUtility.susyId('heavy_bitumen_solution'))
                .fluid()
                .color(0x1e2021)
                .build();

        CrudeLubricatingOil = new Material.Builder(2007, SuSyUtility.susyId('lubrica'))
                .fluid()
                .color(0x80743c)
                .build();

        SolventLubricantMixture = new Material.Builder(2007, SuSyUtility.susyId('lubrica'))
                .fluid()
                .color(0x6e803c)
                .build();

        ColdSolventLubricantMixture = new Material.Builder(2007, SuSyUtility.susyId('lubrica'))
                .fluid()
                .color(0x5e8064)
                .build();

        DewaxedLubricantMixture = new Material.Builder(2007, SuSyUtility.susyId('lubrica'))
                .fluid()
                .color(0x7d782e)
                .build();

        SulfuricLubricatingOil = new Material.Builder(2007, SuSyUtility.susyId('lubrica'))
                .fluid()
                .color(0x7d782e)
                .build();
    }
}           