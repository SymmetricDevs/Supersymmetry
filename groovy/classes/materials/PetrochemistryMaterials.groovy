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
        DilutedOilLight = new Material.Builder(12016, "diluted_oil_light")
                .fluid()
                .color(0x2d2f3b)
                .build();

        DilutedOil = new Material.Builder(12017, "diluted_oil")
                .fluid()
                .color(0x2d2f3b)
                .build();

        DilutedOilHeavy = new Material.Builder(12018, "diluted_oil_heavy")
                .fluid()
                .color(0x2d2f3b)
                .build();

        DesaltedOilHeavy = new Material.Builder(12021, "desalted_oil_heavy")
                .fluid()
                .color(0x000000)
                .build();

        DesaltedOilLight = new Material.Builder(12019, "desalted_oil_light")
                .fluid()
                .color(0x000000)
                .build();

        DesaltedOil = new Material.Builder(12020, "desalted_oil")
                .fluid()
                .color(0x000000)
                .build();

        OilyBrine = new Material.Builder(12023, "oily_brine")
                .fluid()
                .color(0x69684e)
                .build();

        SulfuricOilResidue = new Material.Builder(12024, "sulfuric_oil_residue")
                .fluid()
                .color(0x59572b)
                .build();

        DissolvedBitumen = new Material.Builder(12027, "dissolved_bitumen")
                .fluid()
                .color(0x1e2021)
                .build();

        SulfuricFuelOil = new Material.Builder(12028, "sulfuric_fuel_oil")
                .fluid()
                .color(0x858135)
                .build();

        TreatedSulfuricFuelOil = new Material.Builder(12029, "treated_sulfuric_fuel_oil")
                .fluid()
                .color(0x9e9a4f)
                .build();

        CrudeNaturalGas = new Material.Builder(12030, "crude_natural_gas")
                .fluid(FluidTypes.GAS)
                .color(0xc9c9b9)
                .build();

        SulfuricNaturalGas = new Material.Builder(12031, "sulfuric_natural_gas")
                .fluid(FluidTypes.GAS)
                .color(0xe3e3d1)
                .build();

        TreatedSulfuricNaturalGas = new Material.Builder(12032, "treated_sulfuric_natural_gas")
                .fluid(FluidTypes.GAS)
                .color(0xf7f7eb)
                .build();

        TreatedSulfuricRefineryGas = new Material.Builder(12033, "treated_sulfuric_refinery_gas")
                .fluid(FluidTypes.GAS)
                .color(0xe3e3d8)
                .build();

        SourGas = new Material.Builder(12034, "sour_gas")
                .fluid(FluidTypes.GAS)
                .color(0xebeba4)
                .build();

        SulfuricDiesel = new Material.Builder(12035, "sulfuric_diesel")
                .fluid()
                .color(0xa8a232)
                .build();

        TreatedSulfuricDiesel = new Material.Builder(12036, "treated_sulfuric_diesel")
                .fluid()
                .color(0xc2bb42)
                .build();

        SulfuricKerosene = new Material.Builder(12037, "sulfuric_kerosene")
                .fluid()
                .color(0xbfb82a)
                .build();

        TreatedSulfuricKerosene = new Material.Builder(12038, "treated_sulfuric_kerosene")
                .fluid()
                .color(0xd6cf3a)
                .build();

        Kerosene = new Material.Builder(12039, "kerosene")
                .fluid()
                .color(0xd6cf3a)
                .build();

        SulfuricGasoline = new Material.Builder(12040, "sulfuric_gasoline")
                .fluid()
                .color(0xe8df23)
                .build();

        TreatedSulfuricGasoline = new Material.Builder(12041, "treated_sulfuric_gasoline")
                .fluid()
                .color(0xf7ef40)
                .build();

        FuelOil = new Material.Builder(12042, "fuel_oil")
                .fluid()
                .color(0x9e9a4f)
                .build();

        LubricatingOil = new Material.Builder(12043, "lubricating_oil")
                .fluid()
                .color(0x858146)
                .build();

        SlackWax = new Material.Builder(12044, "slack_wax")
                .fluid()
                .color(0x7d7b59)
                .build();

        Resin = new Material.Builder(12045, "resin")
                .fluid()
                .color(0xb5803a)
                .build();

        UncatalyzedSulfurousGases = new Material.Builder(12049, 'uncatalyzed_sulfurous_gases')
                .fluid(FluidTypes.GAS)
                .color(0xd6d372)
                .fluidTemp(773)
                .build();

        NaphthaReformate = new Material.Builder(12052, 'naphtha_reformate')
                .fluid()
                .color(0xf2f2a0)
                .fluidTemp(773)
                .build();

        BtexExtract = new Material.Builder(12054, 'btex_extract')
                .fluid()
                .color(0xa8a87d)
                .build();

        BTEX = new Material.Builder(12055, 'btex')
                .fluid()
                .color(0x828267)
                .build();

        LightlySteamcrackedKerosene = new Material.Builder(12057, "lightly_steamcracked_kerosene")
                .fluid()
                .color(0xe3dd59)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedKerosene = new Material.Builder(12058, "severely_steamcracked_kerosene")
                .fluid()
                .color(0xf2ed83)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedKerosene = new Material.Builder(12059, "lightly_hydrocracked_kerosene")
                .fluid()
                .color(0xc4bf51)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedKerosene = new Material.Builder(12060, "severely_hydrocracked_kerosene")
                .fluid()
                .color(0xbab65f)
                .fluidTemp(773)
                .build();

        LightlySteamcrackedGasoline = new Material.Builder(12061, "lightly_steamcracked_gasoline")
                .fluid()
                .color(0xebe34d)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedGasoline = new Material.Builder(12062, "severely_steamcracked_gasoline")
                .fluid()
                .color(0xf5ed62)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedGasoline = new Material.Builder(12063, "lightly_hydrocracked_gasoline")
                .fluid()
                .color(0xccc43f)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedGasoline = new Material.Builder(12064, "severely_hydrocracked_gasoline")
                .fluid()
                .color(0xbdb648)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedKeroseneMix = new Material.Builder(12066, "severely_steamcracked_kerosene_mix")
                .fluid()
                .color(0xf2ed83)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedKeroseneMix = new Material.Builder(12067, "lightly_hydrocracked_kerosene_mix")
                .fluid()
                .color(0xc4bf51)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedKeroseneMix = new Material.Builder(12068, "severely_hydrocracked_kerosene_mix")
                .fluid()
                .color(0xbab65f)
                .fluidTemp(773)
                .build();

        LightlySteamcrackedGasolineMix = new Material.Builder(12069, "lightly_steamcracked_gasoline_mix")
                .fluid()
                .color(0xebe34d)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedGasolineMix = new Material.Builder(12070, "severely_steamcracked_gasoline_mix")
                .fluid()
                .color(0xf5ed62)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedGasolineMix = new Material.Builder(12071, "lightly_hydrocracked_gasoline_mix")
                .fluid()
                .color(0xccc43f)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedGasolineMix = new Material.Builder(12072, "severely_hydrocracked_gasoline_mix")
                .fluid()
                .color(0xbdb648)
                .fluidTemp(773)
                .build();

        LightlySteamcrackedNaphthaMix = new Material.Builder(12073, "lightly_steamcracked_naphtha_mix")
                .fluid()
                .color(0xdbd556)
                .fluidTemp(773)
                .build();

        SeverelySteamcrackedNaphthaMix = new Material.Builder(12074, "severely_steamcracked_naphtha_mix")
                .fluid()
                .color(0xe3dd68)
                .fluidTemp(773)
                .build();

        LightlyHydrocrackedNaphthaMix = new Material.Builder(12075, "lightly_hydrocracked_naphtha_mix")
                .fluid()
                .color(0xc4be49)
                .fluidTemp(773)
                .build();

        SeverelyHydrocrackedNaphthaMix = new Material.Builder(12076, "severely_hydrocracked_naphtha_mix")
                .fluid()
                .color(0xb5b050)
                .fluidTemp(773)
                .build();

        UpgradedLubricatingOilMix = new Material.Builder(12077, "upgraded_lubricating_oil_mix")
                .fluid()
                .color(0x948f43)
                .fluidTemp(773)
                .build();

        UpgradedFuelOilMix = new Material.Builder(12078, "upgraded_fuel_oil_mix")
                .fluid()
                .color(0x918d33)
                .fluidTemp(773)
                .build();

        UpgradedDieselMix = new Material.Builder(12079, "upgraded_diesel_mix")
                .fluid()
                .color(0xbab32f)
                .fluidTemp(773)
                .build();

        UpgradedKeroseneMix = new Material.Builder(12080, "upgraded_kerosene_mix")
                .fluid()
                .color(0xe3db30)
                .fluidTemp(773)
                .build();

        UpgradedNaphthaMix = new Material.Builder(12081, "upgraded_naphtha_mix")
                .fluid()
                .color(0xf0e83e)
                .fluidTemp(773)
                .build();

        AlkylatedNaturalGas = new Material.Builder(12082, "alkylated_natural_gas")
                .fluid(FluidTypes.GAS)
                .color(0xe6e4c1)
                .build();

        AlkylatedRefineryGas = new Material.Builder(12083, "alkylated_refinery_gas")
                .fluid(FluidTypes.GAS)
                .color(0xf7f5cb)
                .build();

        Syngas = new Material.Builder(12093, "syngas")
                .fluid(FluidTypes.GAS)
                .color(0xf2ecdc)
                .build();

        ReformedSyngas = new Material.Builder(12094, "reformed_syngas")
                .fluid(FluidTypes.GAS)
                .color(0xfcf3d9)
                .fluidTemp(800)
                .build();

        SulfuricRefineryGas = new Material.Builder(12111, "sulfuric_refinery_gas")
                .fluid(FluidTypes.GAS)
                .color(0xe3e3d8)
                .build();

        TreatedSulfuricNaphtha = new Material.Builder(12112, "treated_sulfuric_naphtha")
                .fluid(FluidTypes.GAS)
                .color(0xcec929)
                .build();

    }

}           