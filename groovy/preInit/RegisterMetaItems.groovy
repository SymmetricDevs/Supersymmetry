import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.*;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;

eventManager.listen {
    GregTechAPI.PostMaterialEvent event ->

        log.infoMC("Adding metaitems...")

        StandardMetaItem customMetaItems = new StandardMetaItem((short)2);
        customMetaItems.setRegistryName("meta_item_2")

        customMetaItems.addItem(1, "rock.carbon")
        customMetaItems.addItem(2, "rock.carbonate")
        customMetaItems.addItem(3, "rock.clay")
        customMetaItems.addItem(4, "rock.oxide")
        customMetaItems.addItem(5, "rock.phosphate")
        customMetaItems.addItem(6, "rock.precious")
        customMetaItems.addItem(7, "rock.radioactive")
        customMetaItems.addItem(8, "rock.sedimentary")
        customMetaItems.addItem(9, "rock.silicate")
        customMetaItems.addItem(10, "rock.sulfur")

        customMetaItems.addItem(100, "cement.clinker")
        customMetaItems.addItem(101, "hot.cement.clinker")
        customMetaItems.addItem(102, "cement.dust")
        customMetaItems.addItem(103, "limestone.dust")
        customMetaItems.addItem(104, "shape.mold.rod")

        customMetaItems.addItem(150, "mudbrick_mix")
        customMetaItems.addItem(151, "slaked_lime")
        customMetaItems.addItem(152, "sand.dust")
        customMetaItems.addItem(153, "straw")

        customMetaItems.addItem(154, "washed_rotten_flesh");

        customMetaItems.addItem(155, "sugar_cane_dust");

        customMetaItems.addItem(156, "bitumen");

        customMetaItems.addItem(157, "bituminous_residue");

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
        customMetaItems.addItem(3000, "circuit.gooware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        customMetaItems.addItem(3001, "circuit.gooware_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        customMetaItems.addItem(3002, "circuit.gooware_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        customMetaItems.addItem(3003, "circuit.gooware_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);

        customMetaItems.addItem(3004,"circuit.optical_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        customMetaItems.addItem(3005,"circuit.optical_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        customMetaItems.addItem(3006,"circuit.optical_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        customMetaItems.addItem(3007,"circuit.optical_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);

        customMetaItems.addItem(3008, "circuit.spintronic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        customMetaItems.addItem(3009, "circuit.spintronic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        customMetaItems.addItem(3010, "circuit.spintronic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        customMetaItems.addItem(3011, "circuit.spintronic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);

        customMetaItems.addItem(3012, "circuit.cosmic_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        customMetaItems.addItem(3013, "circuit.cosmic_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        customMetaItems.addItem(3014, "circuit.cosmic_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        customMetaItems.addItem(3015, "circuit.cosmic_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);

        customMetaItems.addItem(3016, "circuit.supracausal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        customMetaItems.addItem(3017, "circuit.supracausal_assembly").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        customMetaItems.addItem(3018, "circuit.supracausal_computer").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        customMetaItems.addItem(3019, "circuit.supracausal_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        customMetaItems.addItem(3020, "circuit.suprachronal.ulv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ULV);
        customMetaItems.addItem(3021, "circuit.suprachronal.lv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LV);
        customMetaItems.addItem(3022, "circuit.suprachronal.mv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MV);
        customMetaItems.addItem(3023, "circuit.suprachronal.hv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.HV);
        customMetaItems.addItem(3024, "circuit.suprachronal.ev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.EV);
        customMetaItems.addItem(3025, "circuit.suprachronal.iv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.IV);
        customMetaItems.addItem(3026, "circuit.suprachronal.luv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.LuV);
        customMetaItems.addItem(3027, "circuit.suprachronal.zpm").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.ZPM);
        customMetaItems.addItem(3028, "circuit.suprachronal.uv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UV);
        customMetaItems.addItem(3029, "circuit.suprachronal.uhv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UHV);
        customMetaItems.addItem(3030, "circuit.suprachronal.uev").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UEV);
        customMetaItems.addItem(3031, "circuit.suprachronal.uiv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UIV);
        customMetaItems.addItem(3032, "circuit.suprachronal.uxv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.UXV);
        customMetaItems.addItem(3033, "circuit.suprachronal.opv").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.OpV);
        customMetaItems.addItem(3034, "circuit.suprachronal.max").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.MAX);

        customMetaItems.addItem(3035, "wafer.advanced_random_access_memory");
        customMetaItems.addItem(3036, "plate.advanced_random_access_memory");

        //Batteries 4000-4100
        customMetaItems.addItem(4000, "battery.lv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(120000, GTValues.LV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4001, "battery.mv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(480000, GTValues.MV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4002, "battery.hv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(1440000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // Lithium ion battery (MV)
        customMetaItems.addItem(4003, "battery.mv.lithium").addComponents(ElectricStats.createRechargeableBattery(600000, GTValues.MV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4004, "battery.hv.lithium").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4005, "battery.ev.lithium").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.EV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // Vanadium flow battery (HV)
        customMetaItems.addItem(4006, "battery.hv.vanadiumSUSY").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4007, "battery.ev.vanadiumSUSY").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.EV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4008, "battery.iv.vanadiumSUSY").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.IV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.IV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // Nickel-cadmium battery (EV)
        customMetaItems.addItem(4009, "battery.ev.nicad").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.EV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4010, "battery.iv.nicad").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.IV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.IV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4011, "battery.luv.nicad").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.LuV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LuV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // Nickel metal hydride battery (IV)
        customMetaItems.addItem(4012, "battery.iv.nimet").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.IV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.IV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4013, "battery.luv.nimet").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.LuV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LuV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4014, "battery.zpm.nimet").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.ZPM)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.ZPM).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // Nanoparticle enhanced lithium ion battery (LuV?)
        // reserved for now
        customMetaItems.addItem(4015, "battery.luv.magic").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.LuV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LuV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4016, "battery.zpm.magic").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.ZPM)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.ZPM).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        customMetaItems.addItem(4017, "battery.uv.magic").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.UV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.UV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);


        // components [30-60]
        customMetaItems.addItem(4030, "battery.hull.lithium.mv");
        customMetaItems.addItem(4031, "battery.hull.lithium.hv");
        customMetaItems.addItem(4032, "battery.hull.lithium.ev");
        
        customMetaItems.addItem(4033, "battery.hull.vanadiumSUSY.hv");
        customMetaItems.addItem(4034, "battery.hull.vanadiumSUSY.ev");
        customMetaItems.addItem(4035, "battery.hull.vanadiumSUSY.iv");

        customMetaItems.addItem(4036, "battery.hull.nicad.ev");
        customMetaItems.addItem(4037, "battery.hull.nicad.iv");
        customMetaItems.addItem(4038, "battery.hull.nicad.luv");

        customMetaItems.addItem(4039, "battery.hull.nimet.iv");
        customMetaItems.addItem(4040, "battery.hull.nimet.luv");
        customMetaItems.addItem(4041, "battery.hull.nimet.zpm");
        
        // reserved
        // customMetaItems.addItem(4062, "battery.hull.magic.luv");
        // customMetaItems.addItem(4063, "battery.hull.magic.zpm");
        // customMetaItems.addItem(4064, "battery.hull.magic.uv");

        // cathodes 
        customMetaItems.addItem(4060, "cathode.lead");
        customMetaItems.addItem(4061, "anode.lead");

        customMetaItems.addItem(4062, "cathode.lithium_cobalt_oxide");
        customMetaItems.addItem(4063, "anode.graphite");

        customMetaItems.addItem(4064, "cathode.graphine_in_graphine");
        customMetaItems.addItem(4065, "anode.graphine_in_graphine");

        customMetaItems.addItem(4066, "cathode.nickel_oxide_hydroxide");
        customMetaItems.addItem(4067, "anode.met_cadnium");

        // customMetaItems.addItem(4068, "cathode.nickel_oxide_hydroxide");
        customMetaItems.addItem(4068, "anode.lanthanum_nickel_oxide");

        customMetaItems.addItem(4101, "vacuum_tube_components");

        //Circuit Stuff 5000-6000

        customMetaItems.addItem(5000, "mask.ic");
        customMetaItems.addItem(5001, "mask.cpu");
        customMetaItems.addItem(5002, "mask.ram");
        customMetaItems.addItem(5003, "mask.pcb");
        customMetaItems.addItem(5004, "mask.ulpic");

        customMetaItems.addItem(5100, "patterned.ic");
        customMetaItems.addItem(5101, "patterned.cpu");
        customMetaItems.addItem(5102, "patterned.ram");
        customMetaItems.addItem(5103, "patterned.ulpic");
        customMetaItems.addItem(5150, "patterned.board.phenolic");
        customMetaItems.addItem(5151, "patterned.board.plastic");

        customMetaItems.addItem(5200, "laminated.board.phenolic");

        customMetaItems.addItem(5300, "wafer.doped.silicon");

        customMetaItems.addItem(5400, "etched.ic");
        customMetaItems.addItem(5401, "etched.cpu");
        customMetaItems.addItem(5402, "etched.ram");
        customMetaItems.addItem(5403, "etched.ulpic");

        customMetaItems.addItem(5500, "seed_crystal.silicon");

        //Light Sources 6000-6100
        customMetaItems.addItem(6000, "carbon_arc_lamp");
        customMetaItems.addItem(6001, "incandescent_light");
        customMetaItems.addItem(6002, "halogen_light");
        customMetaItems.addItem(6003, "fluorescent_light");
        customMetaItems.addItem(6004, "led_light");

        //Superconductors 6100-6200
        customMetaItems.addItem(6100, "assemblyManganesePhosphide");
        customMetaItems.addItem(6101, "baseManganesePhosphide");
        customMetaItems.addItem(6102, "cannedMagnesiumDiboride");
        customMetaItems.addItem(6103, "tubeMagnesiumDiboride");
        customMetaItems.addItem(6104, "baseMagnesiumDiboride");
        customMetaItems.addItem(6105, "cannedMercuryBariumCalciumCuprate");
        customMetaItems.addItem(6106, "tubeMercuryBariumCalciumCuprate");
        customMetaItems.addItem(6107, "baseMercuryBariumCalciumCuprate");
        customMetaItems.addItem(6108, "assemblyUraniumTriplatinum");
        customMetaItems.addItem(6109, "baseUraniumTriplatinum");
        customMetaItems.addItem(6110, "cannedSamariumIronArsenicOxide");
        customMetaItems.addItem(6111, "tubeSamariumIronArsenicOxide");
        customMetaItems.addItem(6112, "baseSamariumIronArsenicOxide");
        customMetaItems.addItem(6113, "assemblyIndiumTinBariumTitaniumCuprate");
        customMetaItems.addItem(6114, "baseIndiumTinBariumTitaniumCuprate");
        customMetaItems.addItem(6115, "assemblyUraniumRhodiumDinaquadide");
        customMetaItems.addItem(6116, "baseUraniumRhodiumDinaquadide");
        customMetaItems.addItem(6117, "assemblyEnrichedNaquadahTriniumEuropiumDuranide");
        customMetaItems.addItem(6118, "baseEnrichedNaquadahTriniumEuropiumDuranide");
        customMetaItems.addItem(6119, "assemblyRutheniumTriniumAmericiumNeutronate");
        customMetaItems.addItem(6120, "baseRutheniumTriniumAmericiumNeutronate");

        log.infoMC("Finished adding metaitems")
}