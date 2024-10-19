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

        DeasphaltedOil = new Material.Builder(20022, SuSyUtility.susyId('deasphalted_oil'))
                .liquid()
                .color(0x24261c)
                .flags(FLAMMABLE)
                .build();

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

        SteamcrackedLightNaphtha = new Material.Builder(20031, SuSyUtility.susyId('steamcracked_light_naphtha'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0xe3dd59)
                .flags(FLAMMABLE)
                .build();

        SteamcrackedHeavyNaphtha = new Material.Builder(20032, SuSyUtility.susyId('steamcracked_heavy_naphtha'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0xf2ed83)
                .flags(FLAMMABLE)
                .build();

        HydrocrackedLightNaphtha = new Material.Builder(20033, SuSyUtility.susyId('hydrocracked_light_naphtha'))
                .gas(new FluidBuilder().temperature(573))
                .color(0xc4bf51)
                .flags(FLAMMABLE)
                .build();

        HydrocrackedHeavyNaphtha = new Material.Builder(20034, SuSyUtility.susyId('hydrocracked_heavy_naphtha'))
                .gas(new FluidBuilder().temperature(573))
                .color(0xbab65f)
                .flags(FLAMMABLE)
                .build();

        SteamcrackedLightGasOil = new Material.Builder(20035, SuSyUtility.susyId('steamcracked_light_gas_oil'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0xb09046)
                .flags(FLAMMABLE)
                .build();

        SteamcrackedHeavyGasOil = new Material.Builder(20036, SuSyUtility.susyId('steamcracked_heavy_gas_oil'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0x997b37)
                .flags(FLAMMABLE)
                .build();

        HydrocrackedLightGasOil = new Material.Builder(20037, SuSyUtility.susyId('hydrocracked_light_gas_oil'))
                .gas(new FluidBuilder().temperature(573))
                .color(0xb0ac64)
                .flags(FLAMMABLE)
                .build()

        HydrocrackedHeavyGasOil = new Material.Builder(20038, SuSyUtility.susyId('hydrocracked_heavy_gas_oil'))
                .gas(new FluidBuilder().temperature(573))
                .color(0x9e9a64)
                .flags(FLAMMABLE)
                .build()
        
        CatalyticallyCrackedHeavyGasOil = new Material.Builder(20039, SuSyUtility.susyId('catalytically_cracked_heavy_gas_oil'))
                .gas(new FluidBuilder().temperature(773))
                .color(0xb8b24d)
                .flags(FLAMMABLE)
                .build()

        CatalyticallyCrackedAtmosphericOilResidue = new Material.Builder(20040, SuSyUtility.susyId('catalytically_cracked_atmospheric_oil_residue'))
                .gas(new FluidBuilder().temperature(773))
                .color(0x666328)
                .flags(FLAMMABLE)
                .build()

        CatalyticallyCrackedVacuumOilResidue = new Material.Builder(20041, SuSyUtility.susyId('catalytically_cracked_vacuum_oil_residue'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x26261b)
                .flags(FLAMMABLE)
                .build()
                
        HydrocrackedAtmosphericOilResidue = new Material.Builder(20042, SuSyUtility.susyId('hydrocracked_atmospheric_oil_residue'))
                .liquid(new FluidBuilder().temperature(573))
                .color(0x595746)
                .flags(FLAMMABLE)
                .build()

        HydrocrackedVacuumOilResidue = new Material.Builder(20043, SuSyUtility.susyId('hydrocracked_vacuum_oil_residue'))
                .liquid(new FluidBuilder().temperature(573))
                .color(0x212126)
                .flags(FLAMMABLE)
                .build()

        ThermallyCrackedAtmosphericOilResidue = new Material.Builder(20044, SuSyUtility.susyId('thermally_cracked_atmospheric_oil_residue'))
                .gas(new FluidBuilder().temperature(873))
                .color(0x5c5812)
                .flags(FLAMMABLE)
                .build()

        ThermallyCrackedVacuumOilResidue = new Material.Builder(20045, SuSyUtility.susyId('thermally_cracked_vacuum_oil_residue'))
                .gas(new FluidBuilder().temperature(873))
                .color(0x333318)
                .flags(FLAMMABLE)
                .build()

        SteamcrackedEthane = new Material.Builder(20046, SuSyUtility.susyId('steamcracked_ethane'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0xd7d7fc)
                .flags(FLAMMABLE)
                .build()

        SteamcrackedPropane = new Material.Builder(20047, SuSyUtility.susyId('steamcracked_propane'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0xfcec86)
                .flags(FLAMMABLE)
                .build()

        SteamcrackedButane = new Material.Builder(20048, SuSyUtility.susyId('steamcracked_butane'))
                .gas(new FluidBuilder().temperature(1223))
                .color(0xcc614b)
                .flags(FLAMMABLE)
                .build()

        HydrocrackedLightCycleOil = new Material.Builder(20049, SuSyUtility.susyId('hydrocracked_light_cycle_oil'))
                .gas(new FluidBuilder().temperature(573))
                .color(0xdec5a0)
                .flags(FLAMMABLE)
                .build()

        HydrocrackedHeavyCycleOil = new Material.Builder(20050, SuSyUtility.susyId('hydrocracked_heavy_cycle_oil'))
                .gas(new FluidBuilder().temperature(573))
                .color(0xc4ac8c)
                .flags(FLAMMABLE)
                .build()

        HydrocrackedDeasphaltedOil = new Material.Builder(20051, SuSyUtility,susyId('hydrocracked_deasphalted_oil'))
                .liquid(new Fluid.Builder().temperature(573))
                .color(0x24262a)
                .flags(FLAMMABLE)
                .build()

        HydrocrackedSlurryOil = new Material.Builder(20052, SuSyUtility.susyId('hydrocracked_slurry_oil'))
                .liquid(new Fluid.Builder().temperature(573))
                .color(0x29212c)
                .flags(FLAMMABLE)
                .build()

        CrudeCatalyticallyCrackedHeavyGasOil = new Material.Builder(20053, SuSyUtility.susyId('crude_catalytically_cracked_heavy_gas_oil'))
                .gas(new FluidBuilder().temperature(773))
                .color(0xaba64d)
                .flags(FLAMMABLE)
                .build()

        CrudeCatalyticallyCrackedAtmosphericOilResidue = new Material.Builder(20054, SuSyUtility.susyId('crude_catalytically_cracked_atmospheric_oil_residue'))
                .gas(new FluidBuilder().temperature(773))
                .color(0x575425)
                .flags(FLAMMABLE)
                .build()

        CrudeCatalyticallyCrackedVacuumOilResidue = new Material.Builder(20055, SuSyUtility.susyId('crude_catalytically_cracked_vacuum_oil_residue'))
                .liquid(new FluidBuilder().temperature(773))
                .color(0x1f1f17)
                .flags(FLAMMABLE)
                .build()

        //FREE IDs: 20056-20060

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

        PyrolysisGasoline = new Material.Builder(20068, SuSyUtility.susyId('pyrolysis_gasoline'))
                .liquid()
                .color(0xe6ba5c)
                .flags(FLAMMABLE)
                .build();

        //FREE ID: 20069

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

        AtmosphericOverheads = new Material.Builder(20086, SuSyUtility.susyId('atmospheric_overheads'))
                .gas(new FluidBuilder().temperature(460))
                .color(0xe3e6a3)
                .flags(FLAMMABLE)
                .build();

        HeavyAtmosphericOverheads = new Material.Builder(20087, SuSyUtility.susyId('heavy_atmospheric_overheads'))
                .gas(new FluidBuilder().temperature(460))
                .color(0xe8ebb5)
                .flags(FLAMMABLE)
                .build();

        LightAtmosphericOverheads = new Material.Builder(20088, SuSyUtility.susyId('light_atmospheric_overheads'))
                .gas(new FluidBuilder().temperature(460))
                .color(0xdce090)
                .flags(FLAMMABLE)
                .build();

        DebutanizedNaphtha = new Material.Builder(20089, SuSyUtility.susyId('debutanized_naphtha'))
                .liquid(new FluidBuilder().temperature(450))
                .color(0xeaff00)
                .flags(FLAMMABLE)
                .build();

        SulfuricFuelGas = new Material.Builder(20090, SuSyUtility.susyId('sulfuric_fuel_gas'))
                .gas(new FluidBuilder().temperature(340))
                .color(0xccb20a)
                .flags(FLAMMABLE)
                .build();

        SulfuricButaneFuelGas = new Material.Builder(20091, SuSyUtility.susyId('sulfuric_butane_fuel_gas'))
                .liquid()
                .color(0xcca50a)
                .flags(FLAMMABLE)
                .build();

        SulfuricPropaneFuelGas = new Material.Builder(20092, SuSyUtility.susyId('sulfuric_propane_fuel_gas'))
                .gas()
                .color(0xe0d041)
                .flags(FLAMMABLE)
                .build();

        SulfuricLightNaphtha = new Material.Builder(20093, SuSyUtility.susyId('sulfuric_light_naphtha'))
                .liquid(new FluidBuilder().temperature(360))
                .color(0xfff812)
                .flags(FLAMMABLE)
                .build();

        SulfuricHeavyNaphtha = new Material.Builder(20094, SuSyUtility.susyId('sulfuric_heavy_naphtha'))
                .liquid(new FluidBuilder().temperature(340))
                .color(0xe3dc00)
                .flags(FLAMMABLE)
                .build();

        LightNaphtha = new Material.Builder(20095, SuSyUtility.susyId('light_naphtha'))
                .liquid()
                .color(0xfff512)
                .flags(FLAMMABLE)
                .build();

        HeavyNaphtha = new Material.Builder(20096, SuSyUtility.susyId('heavy_naphtha'))
                .liquid()
                .color(0xebe100)
                .flags(FLAMMABLE)
                .build();

        ButaneFuelGas = new Material.Builder(20097, SuSyUtility.susyId('butane_fuel_gas'))
                .gas()
                .color(0xb64c1e)
                .flags(FLAMMABLE)
                .build();

        PropaneFuelGas = new Material.Builder(20098, SuSyUtility.susyId('propane_fuel_gas'))
                .gas()
                .color(0xf5dc42)
                .flags(FLAMMABLE)
                .build();
        
        SlurryOil = new Material.Builder(20099, SuSyUtility.susyId('slurry_oil'))
                .liquid()
                .color(0x292116)
                .flags(FLAMMABLE)
                .build();

        TreatedSulfuricLubricatingOil = new Material.Builder(20100, SuSyUtility.susyId('treated_sulfuric_lubricating_oil'))
                .liquid()
                .color(0x857f2c)
                .flags(FLAMMABLE)
                .build();

        SulfuricDebutanizedNaphtha = new Material.Builder(20101, SuSyUtility.susyId('sulfuric_ebutanized_naphtha'))
                .liquid(new FluidBuilder().temperature(450))
                .color(0xeaff00)
                .flags(FLAMMABLE)
                .build();

        FuelGas = new Material.Builder(20102, SuSyUtility.susyId('fuel_gas'))
                .gas()
                .color(0xcca20a)
                .flags(FLAMMABLE)
                .build();

        LightCycleOil = new Material.Builder(20103, SuSyUtility.susyId('light_cycle_oil'))
                .liquid()
                .color(0xdec587)
                .flags(FLAMMABLE)
                .build();

        HeavyCycleOil = new Material.Builder(20104, SuSyUtility.susyId('heavy_cycle_oil'))
                .liquid()
                .color(0xc4ac70)
                .flags(FLAMMABLE)
                .build();

        SulfuricCatalyticOverheads = new Material.Builder(20105, SuSyUtility.susyId('sulfuric_catalytic_overheads'))
                .gas(new FluidBuilder().temperature(773))
                .color(0xf9ffcc)
                .flags(FLAMMABLE)
                .build();

        CatalyticOverheads = new Material.Builder(20106, SuSyUtility.susyId('catalytic_overheads'))
                .gas(new FluidBuilder().temperature(773))
                .color(0xf4f7df)
                .flags(FLAMMABLE)
                .build();

        ReformingLiquids = new Material.Builder(20107, SuSyUtility.susyId('reforming_liquids'))
                .liquid()
                .color(0xcfc369)
                .flags(FLAMMABLE)
                .build();

        Reformate = new Material.Builder(20108, SuSyUtility.susyId('reformate'))
                .liquid()
                .color(0xd1a63b)
                .flags(FLAMMABLE)
                .build();

        ReformateRaffinate = new Material.Builder(20109, SuSyUtility.susyId('reformate_raffinate'))
                .liquid()
                .color(0xf0e171)
                .flags(FLAMMABLE)
                .build();
    }
}          