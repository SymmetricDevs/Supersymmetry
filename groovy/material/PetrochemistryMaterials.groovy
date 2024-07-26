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
                .flags(FLAMMABLE)
                .build();

        DilutedOil = new Material.Builder(20001, SuSyUtility.susyId('diluted_oil'))
                .liquid()
                .color(0x2d2f3b)
                .flags(FLAMMABLE)
                .build();

        DilutedOilHeavy = new Material.Builder(20002, SuSyUtility.susyId('diluted_oil_heavy'))
                .liquid()
                .color(0x2d2f3b)
                .build();

        DesaltedOilHeavy = new Material.Builder(20003, SuSyUtility.susyId('desalted_oil_heavy'))
                .liquid()
                .color(0x000000)
                .flags(FLAMMABLE)
                .build();

        DesaltedOilLight = new Material.Builder(20004, SuSyUtility.susyId('desalted_oil_light'))
                .liquid()
                .color(0x000000)
                .flags(FLAMMABLE)
                .build();

        DesaltedOil = new Material.Builder(20005, SuSyUtility.susyId('desalted_oil'))
                .liquid()
                .color(0x000000)
                .flags(FLAMMABLE)
                .build();

        OilyBrine = new Material.Builder(20006, SuSyUtility.susyId('oily_brine'))
                .liquid()
                .color(0x69684e)
                .flags(FLAMMABLE)
                .build();

        AtmosphericOilResidue = new Material.Builder(20007, SuSyUtility.susyId('atmospheric_oil_residue'))
                .liquid(new FluidBuilder().temperature(620))
                .color(0x59572b)
                .flags(FLAMMABLE)
                .build();

        SulfuricHeavyGasOil = new Material.Builder(20009, SuSyUtility.susyId('sulfuric_heavy_gas_oil'))
                .liquid()
                .color(0x858135)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricHeavyGasOil = new Material.Builder(20010, SuSyUtility.susyId('treated_sulfuric_heavy_gas_oil'))
                .liquid()
                .color(0x9e9a4f)
                .flags(FLAMMABLE)
                .build();

        CrudeNaturalGas = new Material.Builder(20011, SuSyUtility.susyId('crude_natural_gas'))
                .gas()
                .color(0xc9c9b9)
                .flags(FLAMMABLE)
                .build();

        SulfuricNaturalGas = new Material.Builder(20012, SuSyUtility.susyId('sulfuric_natural_gas'))
                .gas()
                .color(0xe3e3d1)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricNaturalGas = new Material.Builder(20013, SuSyUtility.susyId('treated_sulfuric_natural_gas'))
                .gas()
                .color(0xf7f7eb)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricRefineryGas = new Material.Builder(20014, SuSyUtility.susyId('treated_sulfuric_refinery_gas'))
                .gas()
                .color(0xe3e3d8)
                .flags(FLAMMABLE)
                .build();

        SourGas = new Material.Builder(20015, SuSyUtility.susyId('sour_gas'))
                .gas()
                .color(0xebeba4)
                .build();

        SulfuricLightGasOil = new Material.Builder(20016, SuSyUtility.susyId('sulfuric_light_gas_oil'))
                .liquid()
                .color(0xa8a232)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricLightGasOil = new Material.Builder(20017, SuSyUtility.susyId('treated_sulfuric_light_gas_oil'))
                .liquid()
                .color(0xc2bb42)
                .flags(FLAMMABLE)
                .build();

        SulfuricKerosene = new Material.Builder(20018, SuSyUtility.susyId('sulfuric_kerosene'))
                .liquid()
                .color(0xbfb82a)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricKerosene = new Material.Builder(20019, SuSyUtility.susyId('treated_sulfuric_kerosene'))
                .liquid()
                .color(0xd6cf3a)
                .flags(FLAMMABLE)
                .build();

        Kerosene = new Material.Builder(20020, SuSyUtility.susyId('kerosene'))
                .liquid()
                .color(0xd6cf3a)
                .flags(FLAMMABLE)
                .build();

        VacuumOilResidue = new Material.Builder(20021, SuSyUtility.susyId('vacuum_oil_residue'))
                .liquid(new FluidBuilder().temperature(770))
                .color(0x21211c)
                .flags(FLAMMABLE)
                .build();

        //FREE ID: 20022

        HeavyGasOil = new Material.Builder(20023, SuSyUtility.susyId('heavy_gas_oil'))
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
                .flags(FLAMMABLE)
                .build();

        Resin = new Material.Builder(20026, SuSyUtility.susyId('resin'))
                .liquid()
                .color(0xb5803a)
                .flags(FLAMMABLE)
                .build();

        UncatalyzedSulfurousGases = new Material.Builder(20027, SuSyUtility.susyId('uncatalyzed_sulfurous_gases'))
                .gas(new FluidBuilder().temperature(773))
                .color(0xd6d372)
                .build();

        NaphthaReformate = new Material.Builder(20028, SuSyUtility.susyId('naphtha_reformate'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf2f2a0)
                .flags(FLAMMABLE)
                .build();

        BtexExtract = new Material.Builder(20029, SuSyUtility.susyId('btex_extract'))
                .liquid()
                .color(0xa8a87d)
                .flags(FLAMMABLE)
                .build();

        BTEX = new Material.Builder(20030, SuSyUtility.susyId('btex'))
                .liquid()
                .color(0x828267)
                .flags(FLAMMABLE)
                .build();

        LightlySteamcrackedKerosene = new Material.Builder(20031, SuSyUtility.susyId('lightly_steamcracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xe3dd59)
                .flags(FLAMMABLE)
                .build();

        SeverelySteamcrackedKerosene = new Material.Builder(20032, SuSyUtility.susyId('severely_steamcracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf2ed83)
                .flags(FLAMMABLE)
                .build();

        LightlyHydrocrackedKerosene = new Material.Builder(20033, SuSyUtility.susyId('lightly_hydrocracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xc4bf51)
                .flags(FLAMMABLE)
                .build();

        SeverelyHydrocrackedKerosene = new Material.Builder(20034, SuSyUtility.susyId('severely_hydrocracked_kerosene'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbab65f)
                .flags(FLAMMABLE)
                .build();

        //FREE IDs: 20035-20054

        UpgradedHeavyGasOilMix = new Material.Builder(20055, SuSyUtility.susyId('upgraded_heavy_gas_oil_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x918d33)
                .flags(FLAMMABLE)
                .build();

        UpgradedLightGasOilMix = new Material.Builder(20056, SuSyUtility.susyId('upgraded_light_gas_oil_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xbab32f)
                .flags(FLAMMABLE)
                .build();

        UpgradedKeroseneMix = new Material.Builder(20057, SuSyUtility.susyId('upgraded_kerosene_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xe3db30)
                .flags(FLAMMABLE)
                .build();

        UpgradedNaphthaMix = new Material.Builder(20058, SuSyUtility.susyId('upgraded_naphtha_mix'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0xf0e83e)
                .flags(FLAMMABLE)
                .build();

        // FREE IDs: 20059-20060

        Syngas = new Material.Builder(20061, SuSyUtility.susyId('syngas'))
                .gas()
                .color(0xf2ecdc)
                .flags(FLAMMABLE)
                .build()
                .setFormula('(H2)3(CO)', true);

        ReformedSyngas = new Material.Builder(20062, SuSyUtility.susyId('reformed_syngas'))
                .gas(new FluidBuilder().temperature(800))
                .color(0xfcf3d9)
                .flags(FLAMMABLE)
                .build()
                .setFormula('(H2)4(CO2)', true);

        SulfuricRefineryGas = new Material.Builder(20063, SuSyUtility.susyId('sulfuric_refinery_gas'))
                .gas()
                .color(0xe3e3d8)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricNaphtha = new Material.Builder(20064, SuSyUtility.susyId('treated_sulfuric_naphtha'))
                .gas()
                .color(0xcec929)
                .flags(FLAMMABLE)
                .build();

        LightOilyBrine = new Material.Builder(20065, SuSyUtility.susyId('light_oily_brine'))
                .liquid()
                .color(0x7d7c61)
                .build();

        HeavyOilyBrine = new Material.Builder(20066, SuSyUtility.susyId('heavy_oily_brine'))
                .liquid()
                .color(0x4f4e37)
                .build();

        AsphalteneExtract = new Material.Builder(20067, SuSyUtility.susyId('asphaltene_extract'))
                .liquid()
                .color(0x1e2021)
                .flags(FLAMMABLE)
                .build();

        //FREE IDs: 20068-20069

        CrudeLubricatingOil = new Material.Builder(20070, SuSyUtility.susyId('crude_lubricating_oil'))
                .liquid()
                .color(0x80743c)
                .flags(FLAMMABLE)
                .build();

        SolventLubricantMixture = new Material.Builder(20071, SuSyUtility.susyId('solvent_lubricant_mixture'))
                .liquid()
                .color(0x6e803c)
                .flags(FLAMMABLE)
                .build();

        ColdSolventLubricantMixture = new Material.Builder(20072, SuSyUtility.susyId('cold_solvent_lubricant_mixture'))
                .liquid(new FluidBuilder().temperature(273))
                .color(0x5e8064)
                .flags(FLAMMABLE)
                .build();

        DewaxedLubricantMixture = new Material.Builder(20073, SuSyUtility.susyId('dewaxed_lubricant_mixture'))
                .liquid()
                .color(0x7d782e)
                .flags(FLAMMABLE)
                .build();

        SulfuricLubricatingOil = new Material.Builder(20074, SuSyUtility.susyId('sulfuric_lubricating_oil'))
                .liquid()
                .color(0x7d782e)
                .flags(FLAMMABLE)
                .build();

        CFiveFraction = new Material.Builder(20075, SuSyUtility.susyId('c_five_fraction'))
                .liquid()
                .color(0x9c8638)
                .flags(FLAMMABLE)
                .build();

        DimerizedCFiveFraction = new Material.Builder(20076, SuSyUtility.susyId('dimerized_c_five_fraction'))
                .liquid()
                .color(0x9c9538)
                .flags(FLAMMABLE)
                .build();

        CrudeKerosene = new Material.Builder(20077, SuSyUtility.susyId('crude_kerosene'))
                .liquid(new FluidBuilder().temperature(480))
                .color(0xa8a225)
                .flags(FLAMMABLE)
                .build();

        CrudeLightGasOil = new Material.Builder(20078, SuSyUtility.susyId('crude_light_gas_oil'))
                .liquid()
                .color(0x96912c)
                .flags(FLAMMABLE)
                .build();
        
        CrudeHeavyGasOil = new Material.Builder(20079, SuSyUtility.susyId('crude_heavy_gas_oil'))
                .liquid(new FluidBuilder().temperature(610))
                .color(0x706d2c)
                .flags(FLAMMABLE)
                .build();

        HeatedOilLight = new Material.Builder(20080, SuSyUtility.susyId('heated_oil_light'))
                .liquid()
                .color(0x2d2f3b)
                .flags(FLAMMABLE)
                .build();

        HeatedOil = new Material.Builder(20081, SuSyUtility.susyId('heated_oil'))
                .liquid()
                .color(0x2d2f3b)
                .flags(FLAMMABLE)
                .build();

        HeatedOilHeavy = new Material.Builder(20082, SuSyUtility.susyId('heated_oil_heavy'))
                .liquid()
                .color(0x2d2f3b)
                .flags(FLAMMABLE)
                .build();

        HeavyGasOil = new Material.Builder(20083, SuSyUtility.susyId('heavy_gas_oil'))
                .liquid()
                .color(0x878444)
                .flags(FLAMMABLE)
                .build();

        LightGasOil = new Material.Builder(20084, SuSyUtility.susyId('light_gas_oil'))
                .liquid(new FluidBuilder().temperature(540))
                .color(0xb0ac58)
                .flags(FLAMMABLE)
                .build();

        CrudeNaphtha = new Material.Builder(20085, SuSyUtility.susyId('crude_naphtha'))
                .liquid(new FluidBuilder().temperature(460))
                .color(0xa6a21f)
                .flags(FLAMMABLE)
                .build();

        AtmosphericOverheads = new Material.Builder(2008, SuSyUtility.susyId('atmospheric_overheads'))
                .gas(new FluidBuilder().temperature(460))
                .color(0xe3e6a3)
                .flags(FLAMMABLE)
                .build();

        HeavyAtmosphericOverheads = new Material.Builder(2008, SuSyUtility.susyId('heavy_atmospheric_overheads'))
                .gas(new FluidBuilder().temperature(460))
                .color(0xe8ebb5)
                .flags(FLAMMABLE)
                .build();

        LightAtmosphericOverheads = new Material.Builder(2008, SuSyUtility.susyId('light_atmospheric_overheads'))
                .gas(new FluidBuilder().temperature(460))
                .color(0xdce090)
                .flags(FLAMMABLE)
                .build();

        DebutanizedNaphtha = new Material.Builder(2009, SuSyUtility.susyId('debutanized_naphtha'))
                .liquid(new FluidBuilder().temperature(450))
                .color(0xeaff00)
                .flags(FLAMMABLE)
                .build();

        SulfuricLPG = new Material.Builder(2010, SuSyUtility.susyId('sulfuric_lpg'))
                .gas(new FluidBuilder().temperature(340))
                .color(0xccb20a)
                .flags(FLAMMABLE)
                .build();

        SulfuricButaneLPG = new Material.Builder(2011, SuSyUtility.susyId('sulfuric_butane_lpg'))
                .liquid()
                .color(0xcca50a)
                .flags(FLAMMABLE)
                .build();

        SulfuricPropaneLPG = new Material.Builder(2012, SuSyUtility.susyId('sulfuric_propane_lpg'))
                .gas()
                .color(0xe0d041)
                .flags(FLAMMABLE)
                .build();

        SulfuricLightNaphtha = new Material.Builder(2013, SuSyUtility.susyId('sulfuric_light_naphtha'))
                .liquid(new FluidBuilder().temperature(360))
                .color(0xfff812)
                .flags(FLAMMABLE)
                .build();

        SulfuricHeavyNaphtha = new Material.Builder(2014, SuSyUtility.susyId('sulfuric_heavy_naphtha'))
                .liquid(new FluidBuilder().temperature(340))
                .color(0xe3dc00)
                .flags(FLAMMABLE)
                .build();

        LightNaphtha = new Material.Builder(2015, SuSyUtility.susyId('light_naphtha'))
                .liquid()
                .color(0xfff512)
                .flags(FLAMMABLE)
                .build();

        HeavyNaphtha = new Material.Builder(2016, SuSyUtility.susyId('heavy_naphtha'))
                .liquid()
                .color(0xebe100)
                .flags(FLAMMABLE)
                .build();

        ButaneLPG = new Material.Builder(2017, SuSyUtility.susyId('butane_lpg'))
                .gas()
                .color(0xb64c1e)
                .flags(FLAMMABLE)
                .build();

        PropaneLPG = new Material.Builder(2018, SuSyUtility.susyId('propane_lpg'))
                .gas()
                .color(0xf5dc42)
                .flags(FLAMMABLE)
                .build();
        
        HeatedOilResidue = new Material.Builder(2019, SuSyUtility.susyId('heated_oil_residue'))
                .liquid(new FluidBuilder().temperature(680))
                .color(0x5c5628)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricLubricatingOil = new Material.Builder(20074, SuSyUtility.susyId('treated_sulfuric_lubricating_oil'))
                .liquid()
                .color(0x857f2c)
                .flags(FLAMMABLE)
                .build();
    }
}           