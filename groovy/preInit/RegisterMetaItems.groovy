package preInit;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.*;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.util.text.TextFormatting;
import gregtech.api.unification.material.event.PostMaterialEvent;
import gregtech.common.items.behaviors.TooltipBehavior;

eventManager.listen {
    PostMaterialEvent event ->

        log.infoMC("Adding metaitems...")

        StandardMetaItem customMetaItems = new StandardMetaItem((short)2);
        customMetaItems.setRegistryName("meta_item_2")

        customMetaItems.addItem(1, "rock.orthomagmatic")
        customMetaItems.addItem(2, "rock.metamorphic")
        customMetaItems.addItem(3, "rock.magmatic_hydrothermal")
        customMetaItems.addItem(4, "rock.sedimentary")
        customMetaItems.addItem(5, "rock.hydrothermal")
        customMetaItems.addItem(6, "rock.alluvial")

        customMetaItems.addItem(100, "cement.clinker")
        customMetaItems.addItem(101, "hot.cement.clinker")
        customMetaItems.addItem(102, "cement.dust")
        customMetaItems.addItem(103, "limestone.dust")
        customMetaItems.addItem(104, "shape.mold.rod")
        customMetaItems.addItem(105, "shape.mold.crucible")
        customMetaItems.addItem(106, "crucible.boron.nitride")
        customMetaItems.addItem(107, "crucible.quartz")
        customMetaItems.addItem(108, "crucible.graphite")
        customMetaItems.addItem(109, "shape.mold.long_rod")
        customMetaItems.addItem(110, "shape.mold.ring")

        customMetaItems.addItem(150, "mudbrick_mix")
        customMetaItems.addItem(151, "slaked_lime")
        customMetaItems.addItem(152, "sand.dust")
        customMetaItems.addItem(153, "native_copper")

        customMetaItems.addItem(154, "washed_rotten_flesh");

        customMetaItems.addItem(155, "sugar_cane_dust");

        customMetaItems.addItem(156, "bitumen");
        customMetaItems.addItem(157, "hydrocracking_catalyst")
        customMetaItems.addItem(158, "paraffin_wax");
        customMetaItems.addItem(159, "spent_cracking_catalyst");

        customMetaItems.addItem(160, "red_mud_slag");
        customMetaItems.addItem(161, "leached_red_mud_slag");

        customMetaItems.addItem(162, "pitch_binder");
        customMetaItems.addItem(163, "raw_electrode");
        customMetaItems.addItem(164, "graphite_electrode");

        customMetaItems.addItem(165, "rydberg_atom_array");

        customMetaItems.addItem(166, "malted_grain");

        customMetaItems.addItem(167, "mineral_wool");

        customMetaItems.addItem(168, "hepa_filter");

        customMetaItems.addItem(169, "cracking_catalyst");

        customMetaItems.addItem(170, "raw_diamond");

        customMetaItems.addItem(171, "cellulose_acetate_mesh");

        customMetaItems.addItem(177, "zeolite_membrane_support");
        customMetaItems.addItem(178, "zeolite_membrane");

        customMetaItems.addItem(180, "patterned_thick_film_substrate_wafer");
        customMetaItems.addItem(181, "thick_film_resistor_wafer");
        customMetaItems.addItem(182, "metallized_plastic_film");
        customMetaItems.addItem(183, "metallized_plastic_square");
        customMetaItems.addItem(184, "raw_smd_capacitor");
        customMetaItems.addItem(185, "raw_capacitor_roll");
        customMetaItems.addItem(186, "aluminium_electrolytic_capacitor");
        customMetaItems.addItem(187, "tantalum_chip");
        customMetaItems.addItem(188, "anodized_tantalum_chip");
        customMetaItems.addItem(189, "manganized_tantalum_chip");
        customMetaItems.addItem(190, "ferroelectric_ceramic_foil");
        customMetaItems.addItem(191, "stacked_ceramic_capacitor");
        customMetaItems.addItem(192, "raw_ceramic_capacitor");

        customMetaItems.addItem(193, "chip.insulated_silicon");
        customMetaItems.addItem(194, "chip.insulated_silicon_germanium");
        customMetaItems.addItem(195, "chip.n_doped_silicon");
        customMetaItems.addItem(196, "chip.silicon_dioxide");

        customMetaItems.addItem(197, "fused_quartz");

        customMetaItems.addItem(200, "thick_film_substrate_wafer");

        customMetaItems.addItem(201, "vti_rich_pig_iron");
        customMetaItems.addItem(202, "vt_slag");

	    customMetaItems.addItem(210, "bound_leather")

        customMetaItems.addItem(212, "drone.lv").setMaxStackSize(1).addComponents(ElectricStats.createRechargeableBattery(10000, GTValues.LV)).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(213, "glass_fibers")
        customMetaItems.addItem(214, "epoxy_lamina")

        customMetaItems.addItem(250, "beads.amberlyst_ch");
        customMetaItems.addItem(251, "beads.ag_fifty_w_x_eight");
        customMetaItems.addItem(252, "beads.rhenium_ion_exchange")
        customMetaItems.addItem(253, "beads.loaded_rhenium_ion_exchange")

        customMetaItems.addItem(300, "mylar")
        customMetaItems.addItem(301, "spinneret")

        customMetaItems.addItem(1000, "chunk.magnetite")
        customMetaItems.addItem(1001, "hot_iron_rod")
        customMetaItems.addItem(1002, "voltaic_pile").setMaxStackSize(1);
        customMetaItems.addItem(1003, "electrolyte_paper")
        
        customMetaItems.addItem(1100, "steam.piston")
        customMetaItems.addItem(1101, "steam.motor")

        customMetaItems.addItem(2000, "spaceship.me.scrap")

        customMetaItems.addItem(2001, "wafer.pattern.processor")
        customMetaItems.addItem(2002, "wafer.pattern.memory")

        customMetaItems.addItem(2003, "plate.pattern.processor")
        customMetaItems.addItem(2004, "plate.pattern.memory")

        customMetaItems.addItem(2005, "pattern.processor")
        customMetaItems.addItem(2006, "pattern.memory")

        customMetaItems.addItem(2007, "storage.segment")

        customMetaItems.addItem(2500, "gun.barrel.steel")

        //Placeholders until GCYS is available
        customMetaItems.addItem(3000, "circuit.gooware_processor")
        customMetaItems.addItem(3001, "circuit.gooware_assembly")
        customMetaItems.addItem(3002, "circuit.gooware_computer")
        customMetaItems.addItem(3003, "circuit.gooware_mainframe")

        customMetaItems.addItem(3004,"circuit.optical_processor")
        customMetaItems.addItem(3005,"circuit.optical_assembly")
        customMetaItems.addItem(3006,"circuit.optical_computer")
        customMetaItems.addItem(3007,"circuit.optical_mainframe")

        customMetaItems.addItem(3008, "circuit.spintronic_processor")
        customMetaItems.addItem(3009, "circuit.spintronic_assembly")
        customMetaItems.addItem(3010, "circuit.spintronic_computer")
        customMetaItems.addItem(3011, "circuit.spintronic_mainframe")

        customMetaItems.addItem(3012, "circuit.cosmic_processor")
        customMetaItems.addItem(3013, "circuit.cosmic_assembly")
        customMetaItems.addItem(3014, "circuit.cosmic_computer")
        customMetaItems.addItem(3015, "circuit.cosmic_mainframe")

        customMetaItems.addItem(3016, "circuit.supracausal_processor")
        customMetaItems.addItem(3017, "circuit.supracausal_assembly")
        customMetaItems.addItem(3018, "circuit.supracausal_computer")
        customMetaItems.addItem(3019, "circuit.supracausal_mainframe")

        customMetaItems.addItem(3020, "circuit.suprachronal.ulv")
        customMetaItems.addItem(3021, "circuit.suprachronal.lv")
        customMetaItems.addItem(3022, "circuit.suprachronal.mv")
        customMetaItems.addItem(3023, "circuit.suprachronal.hv")
        customMetaItems.addItem(3024, "circuit.suprachronal.ev")
        customMetaItems.addItem(3025, "circuit.suprachronal.iv")
        customMetaItems.addItem(3026, "circuit.suprachronal.luv")
        customMetaItems.addItem(3027, "circuit.suprachronal.zpm")
        customMetaItems.addItem(3028, "circuit.suprachronal.uv")
        customMetaItems.addItem(3029, "circuit.suprachronal.uhv")
        customMetaItems.addItem(3030, "circuit.suprachronal.uev")
        customMetaItems.addItem(3031, "circuit.suprachronal.uiv")
        customMetaItems.addItem(3032, "circuit.suprachronal.uxv")
        customMetaItems.addItem(3033, "circuit.suprachronal.opv")
        customMetaItems.addItem(3034, "circuit.suprachronal.max")

        customMetaItems.addItem(3035, "wafer.advanced_random_access_memory");
        customMetaItems.addItem(3036, "plate.advanced_random_access_memory");

        //Organics 3500-4000
        customMetaItems.addItem(3500, "copra")

        //Batteries 4000-4100
        customMetaItems.addItem(4000, "battery.lead_acid").addComponents(ElectricStats.createRechargeableBattery(120000, GTValues.LV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4001, "cathode.lead");
        customMetaItems.addItem(4002, "anode.lead");
        //customMetaItems.addItem(4003, "battery.mv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(480000, GTValues.MV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        //customMetaItems.addItem(4004, "battery.hv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(1440000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        //customMetaItems.addItem(4005, "battery.mv.lithium_ion").addComponents(ElectricStats.createRechargeableBattery(600000, GTValues.MV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        //customMetaItems.addItem(4006, "battery.hv.lithium_ion").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        //customMetaItems.addItem(4007, "battery.ev.lithium_ion").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.EV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4101, "vacuum_tube_components");

        //Dusts & Pulps 4500-4999
        
        //Circuit Stuff 5000-6000
        //Photomasks 5000-5099
        customMetaItems.addItem(5000, "rubylith")
        customMetaItems.addItem(5001, "rubylith_film")
        customMetaItems.addItem(5002, "stencil.ic")
        customMetaItems.addItem(5003, "stencil.cpu")
        customMetaItems.addItem(5004, "stencil.ram")
        customMetaItems.addItem(5005, "stencil.pcb")
        customMetaItems.addItem(5006, "stencil.ulpic")
        customMetaItems.addItem(5007, "stencil.lpic")
        customMetaItems.addItem(5020, "mask.blank")
        customMetaItems.addItem(5021, "mask.ic");
        customMetaItems.addItem(5022, "mask.cpu");
        customMetaItems.addItem(5023, "mask.ram");
        customMetaItems.addItem(5024, "mask.pcb");
        customMetaItems.addItem(5025, "mask.ulpic");
        customMetaItems.addItem(5026, "mask.lpic");
        customMetaItems.addItem(5027, "mask.nand");
        customMetaItems.addItem(5028, "mask.nor");
        customMetaItems.addItem(5029, "mask.advanced");
        customMetaItems.addItem(5100, "patterned.ic");
        customMetaItems.addItem(5101, "patterned.cpu");
        customMetaItems.addItem(5102, "patterned.ram");
        customMetaItems.addItem(5103, "patterned.ulpic");
        customMetaItems.addItem(5104, "patterned.lpic");
        customMetaItems.addItem(5105, "patterned.silicon_dioxide");
        customMetaItems.addItem(5106, "patterned.polysilicon");
        customMetaItems.addItem(5107, "patterned.silicon_nitride");
        customMetaItems.addItem(5108, "patterned.nand");
        customMetaItems.addItem(5109, "patterned.nor");
        customMetaItems.addItem(5150, "patterned.board.phenolic");
        customMetaItems.addItem(5151, "patterned.board.plastic");
        customMetaItems.addItem(5200, "laminated.board.phenolic");
        customMetaItems.addItem(5300, "etched.ic");
        customMetaItems.addItem(5301, "etched.cpu");
        customMetaItems.addItem(5302, "etched.ram");
        customMetaItems.addItem(5303, "etched.ulpic");
        customMetaItems.addItem(5304, "etched.lpic");
        customMetaItems.addItem(5305, "etched.silicon_dioxide");
        customMetaItems.addItem(5306, "etched.polysilicon");
        customMetaItems.addItem(5307, "etched.silicon_nitride");
        
        //Good Circuit Components 5900-6000
        customMetaItems.addItem(5900, "op_amp");
        customMetaItems.addItem(5901, "heat_sink");
        customMetaItems.addItem(5902, "protector_chip");
        customMetaItems.addItem(5903, "zener_diode");
        customMetaItems.addItem(5904, "fuse.hv");
        customMetaItems.addItem(5905, "voltage_regulator.hv.unsealed");
        customMetaItems.addItem(5906, "voltage_regulator.mv");
        customMetaItems.addItem(5907, "voltage_regulator.hv");

        //Light Sources 6000-6100
        customMetaItems.addItem(6000, "carbon_arc_lamp");
        customMetaItems.addItem(6001, "incandescent_light");
        customMetaItems.addItem(6002, "halogen_light");
        customMetaItems.addItem(6003, "fluorescent_light");
        customMetaItems.addItem(6004, "led_light");

        //Superconductors 6100-6200
        customMetaItems.addItem(6100, "assemblymanganesephosphide");
        customMetaItems.addItem(6101, "basemanganesephosphide");
        customMetaItems.addItem(6102, "cannedmagnesiumdiboride");
        customMetaItems.addItem(6103, "tubemagnesiumdiboride");
        customMetaItems.addItem(6104, "basemagnesiumdiboride");
        customMetaItems.addItem(6105, "cannedmercurybariumcalciumcuprate");
        customMetaItems.addItem(6106, "tubemercurybariumcalciumcuprate");
        customMetaItems.addItem(6107, "basemercurybariumcalciumcuprate");
        customMetaItems.addItem(6108, "assemblyuraniumtriplatinum");
        customMetaItems.addItem(6109, "baseuraniumtriplatinum");
        customMetaItems.addItem(6110, "cannedsamariumironarsenicoxide");
        customMetaItems.addItem(6111, "tubesamariumironarsenicoxide");
        customMetaItems.addItem(6112, "basesamariumironarsenicoxide");
        customMetaItems.addItem(6113, "assemblyindiumtinbariumtitaniumcuprate");
        customMetaItems.addItem(6114, "baseindiumtinbariumtitaniumcuprate");
        customMetaItems.addItem(6115, "assemblyuraniumrhodiumdinaquadide");
        customMetaItems.addItem(6116, "baseuraniumrhodiumdinaquadide");
        customMetaItems.addItem(6117, "assemblyenrichednaquadahtriniumeuropiumduranide");
        customMetaItems.addItem(6118, "baseenrichednaquadahtriniumeuropiumduranide");
        customMetaItems.addItem(6119, "assemblyrutheniumtriniumamericiumneutronate");
        customMetaItems.addItem(6120, "baserutheniumtriniumamericiumneutronate");

        //Metal sponges 6200-6300
        customMetaItems.addItem(6200, "sponge.titanium")
        customMetaItems.addItem(6201, "sponge.titanium.crude")
        customMetaItems.addItem(6202, "sponge.zirconium")
        customMetaItems.addItem(6203, "sponge.zirconium.crude")
        customMetaItems.addItem(6204, "sponge.hafnium")
        customMetaItems.addItem(6205, "sponge.hafnium.crude")
        customMetaItems.addItem(6206, "sponge.platinum")
        customMetaItems.addItem(6207, "sponge.cadmium")
        customMetaItems.addItem(6208, "sponge.indium")

        // Anode slimes 6300-6400
        customMetaItems.addItem(6300, "anode_slime.gold")
        customMetaItems.addItem(6301, "anode_slime.silver")
        customMetaItems.addItem(6302, "anode_slime.lead")
        customMetaItems.addItem(6303, "anode_slime.copper")
        customMetaItems.addItem(6304, "anode_slime.decopperized")

        //Seed crystals 7000-7500

        customMetaItems.addItem(7000, "seed_crystal.silicon");
        customMetaItems.addItem(7001, "seed_crystal.gallium_arsenide");
        customMetaItems.addItem(7002, "seed_crystal.alumina");
        customMetaItems.addItem(7003, "seed_crystal.beryllium_oxide");
        customMetaItems.addItem(7004, "seed_crystal.emerald");
        customMetaItems.addItem(7005, "seed_crystal.lithium_niobate");

        //Boules 7500-8000

        customMetaItems.addItem(7500, "unrefined_boule.silicon");
        customMetaItems.addItem(7501, "boule.gallium_arsenide");
        customMetaItems.addItem(7502, "unrefined_boule.gallium_arsenide");
        customMetaItems.addItem(7503, "boule.alumina");
        customMetaItems.addItem(7504, "boule.beryllium_oxide");
        customMetaItems.addItem(7505, "boule.emerald");
        customMetaItems.addItem(7506, "boule.sapphire");
        customMetaItems.addItem(7507, "boule.ruby");
        customMetaItems.addItem(7508, "boule.silicon_germanium");
        customMetaItems.addItem(7509, "boule.lithium_niobate");

        //Wafers 8000-9000

        customMetaItems.addItem(8000, "wafer.doped.silicon");
        customMetaItems.addItem(8001, "wafer.n_doped.silicon");
        customMetaItems.addItem(8002, "wafer.silicon_dioxide");
        customMetaItems.addItem(8003, "wafer.alumina");
        customMetaItems.addItem(8004, "wafer.beryllium_oxide");
        customMetaItems.addItem(8005, "wafer.silicon_germanium");
        customMetaItems.addItem(8006, "wafer.insulated_silicon");
        customMetaItems.addItem(8007, "wafer.insulated_silicon_germanium");
        customMetaItems.addItem(8008, "wafer.doped.silicon_dioxide");
        customMetaItems.addItem(8009, "wafer.polysilicon");
        customMetaItems.addItem(8010, "wafer.doped.polysilicon");
        customMetaItems.addItem(8011, "wafer.silicon_nitride");
        customMetaItems.addItem(8012, "wafer.nickel");
        customMetaItems.addItem(8013, "wafer.gallium_arsenide");
        customMetaItems.addItem(8014, "wafer.raw.silicon");
        customMetaItems.addItem(8015, "wafer.treated.silicon");

        //Crops 9000-10000

        // 9000 & 9001
        customMetaItems.addItem(9000, "stem.cotton");

        // Train Stuff 10000-10100

        customMetaItems.addItem(10000, "tunnelbore.axle")
        customMetaItems.addItem(10001, "tunnelbore.engine")
        customMetaItems.addItem(10002, "tunnelbore.drillhead")

        // Misc Crafting Components 10100-10200
        customMetaItems.addItem(10100, "turbojet.small")
        customMetaItems.addItem(10101, "wing_panel.fiber_reinforced_epoxy")
        customMetaItems.addItem(10102, "wing.small")

        log.infoMC("Finished adding metaitems")
}
