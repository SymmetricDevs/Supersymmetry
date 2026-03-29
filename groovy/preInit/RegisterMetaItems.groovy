package preInit

import globals.Batteries
import gregtech.api.GTValues
import gregtech.api.GregTechAPI
import gregtech.api.items.metaitem.ElectricStats
import gregtech.api.items.metaitem.StandardMetaItem
import gregtech.api.unification.material.event.PostMaterialEvent

eventManager.listen { PostMaterialEvent event ->

    log.infoMC("Adding metaitems...")

    new StandardMetaItem(2 as short).with {
        setRegistryName("meta_item_2")

        addItem(1, "rock.orthomagmatic")
        addItem(2, "rock.metamorphic")
        addItem(3, "rock.magmatic_hydrothermal")
        addItem(4, "rock.sedimentary")
        addItem(5, "rock.hydrothermal")
        addItem(6, "rock.alluvial")

        addItem(100, "cement.clinker")
        addItem(101, "hot.cement.clinker")
        addItem(102, "cement.dust")

        // Free ID: 103

        addItem(104, "shape.mold.rod")
        addItem(105, "shape.mold.crucible")
        addItem(106, "crucible.boron.nitride")
        addItem(107, "crucible.quartz")
        addItem(109, "shape.mold.long_rod")
        addItem(110, "shape.mold.ring")
        addItem(111, "crucible.tantalum")

        addItem(150, "mudbrick_mix")
        addItem(151, "slaked_lime")
        addItem(152, "sand.dust")
        addItem(153, "native_copper")
        addItem(154, "washed_rotten_flesh")
        addItem(155, "sugar_cane_dust")

        // FREE ID: 156

        addItem(157, "hydrocracking_catalyst")
        addItem(158, "paraffin_wax")
        addItem(159, "spent_cracking_catalyst")

        addItem(160, "red_mud_slag")
        addItem(161, "leached_red_mud_slag")

        addItem(162, "carbon_paste")

        addItem(165, "rydberg_atom_array")

        addItem(166, "malted_grain")

        addItem(167, "mineral_wool")

        addItem(168, "hepa_filter")

        addItem(169, "cracking_catalyst")

        addItem(170, "raw_diamond")

        addItem(171, "membrane.cellulose_acetate")
        addItem(172, "mesh.platinum")
        addItem(173, "mesh.platinum_rhodium")

        addItem(177, "membrane.support.alumina")
        addItem(178, "membrane.zeolite")

        addItem(180, "patterned_thick_film_substrate_wafer")
        addItem(181, "thick_film_resistor_wafer")
        addItem(182, "metallized_plastic_film")
        addItem(183, "metallized_plastic_square")
        addItem(184, "raw_smd_capacitor")
        addItem(185, "raw_capacitor_roll")
        addItem(186, "aluminium_electrolytic_capacitor")
        addItem(187, "tantalum_chip")
        addItem(188, "anodized_tantalum_chip")
        addItem(189, "manganized_tantalum_chip")
        addItem(190, "ferroelectric_ceramic_foil")
        addItem(191, "stacked_ceramic_capacitor")
        addItem(192, "raw_ceramic_capacitor")

        addItem(193, "chip.insulated_silicon")
        addItem(194, "chip.insulated_silicon_germanium")
        addItem(195, "chip.n_doped_silicon")
        addItem(196, "chip.silicon_dioxide")

        addItem(197, "fused_quartz")

        addItem(200, "thick_film_substrate_wafer")

        addItem(201, "vti_rich_pig_iron")
        addItem(202, "vt_slag")

        addItem(203, "white_matte")
        addItem(210, "bound_leather")

        addItem(212, "drone.lv").setMaxStackSize(1).addComponents(ElectricStats.createRechargeableBattery(10000, GTValues.LV)).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        addItem(213, "glass_fibers")
        addItem(214, "titanium_cylinder");

        addItem(215, "commutator")
        addItem(216, "brush.unfired")
        addItem(217, "brush")

        addItem(250, "beads.amberlyst_ch")
        addItem(251, "beads.strong_acidic_cation_exchange")
        addItem(252, "beads.weak_basic_anion_exchange")
        addItem(253, "beads.loaded_rhenium_anion_exchange")
        addItem(254, "beads.strong_basic_anion_exchange")
        addItem(255, "beads.loaded_uranium_anion_exchange")
        addItem(256, "beads.rare_earth_cation_exchange")
        addItem(257, "beads.loaded_lutetium_cation_exchange")

        addItem(300, "mylar")
        addItem(301, "spinneret")
        addItem(302, "fiber.oxidized_polyacrylonitrile")
        addItem(303, "carbon.mesh.treated")
        addItem(304, "proton_exchange_membrane_fuel_cell")

        addItem(400, "engine.spark_plug.iridium")
        addItem(401, "engine.piston")
        addItem(402, "engine.crankshaft")
        addItem(403, "engine.spark_plug.palladium")

        addItem(500, "sintered_alumina.insulator")

        addItem(1000, "chunk.magnetite")
        addItem(1001, "hot_iron_rod")
        addItem(1002, "voltaic_pile").setMaxStackSize(1)
        addItem(1003, "electrolyte_paper")
        addItem(1004, "hot_steel_plate")
        addItem(1005, "hot_steel_rod")

        addItem(1100, "steam.piston")
        addItem(1101, "steam.motor")

        addItem(2000, "spaceship.me.scrap")

        addItem(2001, "wafer.pattern.processor")
        addItem(2002, "wafer.pattern.memory")

        addItem(2003, "plate.pattern.processor")
        addItem(2004, "plate.pattern.memory")

        addItem(2005, "pattern.processor")
        addItem(2006, "pattern.memory")

        addItem(2007, "storage.segment")

        addItem(2500, "gun.barrel.steel")

        //Placeholders until GCYS is available
        addItem(3000, "circuit.gooware_processor")
        addItem(3001, "circuit.gooware_assembly")
        addItem(3002, "circuit.gooware_computer")
        addItem(3003, "circuit.gooware_mainframe")

        addItem(3004, "circuit.optical_processor")
        addItem(3005, "circuit.optical_assembly")
        addItem(3006, "circuit.optical_computer")
        addItem(3007, "circuit.optical_mainframe")

        addItem(3008, "circuit.spintronic_processor")
        addItem(3009, "circuit.spintronic_assembly")
        addItem(3010, "circuit.spintronic_computer")
        addItem(3011, "circuit.spintronic_mainframe")

        addItem(3012, "circuit.cosmic_processor")
        addItem(3013, "circuit.cosmic_assembly")
        addItem(3014, "circuit.cosmic_computer")
        addItem(3015, "circuit.cosmic_mainframe")

        addItem(3016, "circuit.supracausal_processor")
        addItem(3017, "circuit.supracausal_assembly")
        addItem(3018, "circuit.supracausal_computer")
        addItem(3019, "circuit.supracausal_mainframe")

        addItem(3020, "circuit.suprachronal.ulv")
        addItem(3021, "circuit.suprachronal.lv")
        addItem(3022, "circuit.suprachronal.mv")
        addItem(3023, "circuit.suprachronal.hv")
        addItem(3024, "circuit.suprachronal.ev")
        addItem(3025, "circuit.suprachronal.iv")
        addItem(3026, "circuit.suprachronal.luv")
        addItem(3027, "circuit.suprachronal.zpm")
        addItem(3028, "circuit.suprachronal.uv")
        addItem(3029, "circuit.suprachronal.uhv")
        addItem(3030, "circuit.suprachronal.uev")
        addItem(3031, "circuit.suprachronal.uiv")
        addItem(3032, "circuit.suprachronal.uxv")
        addItem(3033, "circuit.suprachronal.opv")
        addItem(3034, "circuit.suprachronal.max")

        addItem(3035, "wafer.advanced_random_access_memory")
        addItem(3036, "plate.advanced_random_access_memory")

        //Organics 3500-3900
        addItem(3500, "copra")

        // Battery hulls 3900-4000
        addItem(3900, "battery.primitivehull.lv")
        addItem(3901, "battery.primitivehull.mv")
        addItem(3902, "battery.steel_hull.lv")
        addItem(3903, "battery.steel_hull.mv")
        addItem(3904, "battery.steel_hull.hv")
        addItem(3905, "battery.ni_fe_hull.lv")
        addItem(3906, "battery.ni_fe_hull.mv")
        addItem(3907, "battery.ni_fe_hull.hv")

        //Batteries 4000-4100
        Batteries['lead_acid'].register(it, 4000)
        addItem(4001, "cathode.lead")
        addItem(4002, "anode.lead")
        addItem(4003, "cathode.lead_paste")
        addItem(4004, "cathode.lead_frame")
        Batteries['lead_acid.mv'].register(it,4005)
        addItem(4006, "electrode.steel_frame")
        addItem(4007, "electrode.nickeled_steel_frame")
        Batteries['ni_zn.mv'].register(it, 4008)
        Batteries['ni_zn.hv'].register(it, 4009)
        addItem(4010, "anode.zinc_oxide")
        addItem(4011, "cathode.nioh2")
        Batteries['ni_fe.lv'].register(it, 4012)
        Batteries['ni_fe'].register(it, 4013)
        Batteries['ni_fe.hv'].register(it, 4014)

        addItem(4101, "vacuum_tube_components")

        //Dusts & Pulps 4500-4999

        //Circuit Stuff 5000-6000
        //Photomasks 5000-5099
        addItem(5000, "rubylith")
        addItem(5001, "rubylith_film")
        addItem(5002, "stencil.ic")
        addItem(5003, "stencil.cpu")
        addItem(5004, "stencil.ram")
        addItem(5005, "stencil.pcb")
        addItem(5006, "stencil.ulpic")
        addItem(5007, "stencil.lpic")
        addItem(5020, "mask.blank")
        addItem(5021, "mask.ic")
        addItem(5022, "mask.cpu")
        addItem(5023, "mask.ram")
        addItem(5024, "mask.pcb")
        addItem(5025, "mask.ulpic")
        addItem(5026, "mask.lpic")
        addItem(5027, "mask.nand")
        addItem(5028, "mask.nor")
        addItem(5029, "mask.advanced")
        addItem(5100, "patterned.ic")
        addItem(5101, "patterned.cpu")
        addItem(5102, "patterned.ram")
        addItem(5103, "patterned.ulpic")
        addItem(5104, "patterned.lpic")
        addItem(5105, "patterned.silicon_dioxide")
        addItem(5106, "patterned.polysilicon")
        addItem(5107, "patterned.silicon_nitride")
        addItem(5108, "patterned.nand")
        addItem(5109, "patterned.nor")
        addItem(5150, "patterned.board.phenolic")
        addItem(5151, "patterned.board.plastic")
        addItem(5200, "laminated.board.phenolic")
        addItem(5300, "etched.ic")
        addItem(5301, "etched.cpu")
        addItem(5302, "etched.ram")
        addItem(5303, "etched.ulpic")
        addItem(5304, "etched.lpic")
        addItem(5305, "etched.silicon_dioxide")
        addItem(5306, "etched.polysilicon")
        addItem(5307, "etched.silicon_nitride")

        //Epoxy Circuit Board + Components 5800-5900
        addItem(5800, "board.epoxy.prepreg")
        addItem(5801, "board.epoxy.copper_clad");
        addItem(5802, "board.epoxy.patterned");
        addItem(5803, "board.epoxy.etched");
        addItem(5804, "board.epoxy.drilled");
        addItem(5805, "board.epoxy.electroless");
        addItem(5806, "board.epoxy.electrolytic");
        addItem(5807, "board.epoxy.wet_masked");
        addItem(5808, "board.epoxy.mask_affixed"); 
        addItem(5809, "circuit_board.fr4");


        //Good Circuit Components 5900-6000
        addItem(5900, "op_amp")
        addItem(5901, "heat_sink")
        addItem(5902, "protector_chip")
        addItem(5903, "zener_diode")
        addItem(5904, "fuse.hv")
        addItem(5905, "voltage_regulator.hv.unsealed")
        addItem(5906, "voltage_regulator.mv")
        addItem(5907, "voltage_regulator.hv")

        //Light Sources 6000-6100
        addItem(6000, "carbon_arc_lamp")
        addItem(6001, "incandescent_light")
        addItem(6002, "halogen_light")
        addItem(6003, "fluorescent_light")
        addItem(6004, "led_light")

        //Superconductors 6100-6200
        addItem(6100, "assemblymanganesephosphide")
        addItem(6101, "basemanganesephosphide")
        addItem(6102, "cannedmagnesiumdiboride")
        addItem(6103, "tubemagnesiumdiboride")
        addItem(6104, "basemagnesiumdiboride")
        addItem(6105, "cannedmercurybariumcalciumcuprate")
        addItem(6106, "tubemercurybariumcalciumcuprate")
        addItem(6107, "basemercurybariumcalciumcuprate")
        addItem(6108, "assemblyuraniumtriplatinum")
        addItem(6109, "baseuraniumtriplatinum")
        addItem(6110, "cannedsamariumironarsenicoxide")
        addItem(6111, "tubesamariumironarsenicoxide")
        addItem(6112, "basesamariumironarsenicoxide")
        addItem(6113, "assemblyindiumtinbariumtitaniumcuprate")
        addItem(6114, "baseindiumtinbariumtitaniumcuprate")
        addItem(6115, "assemblyuraniumrhodiumdinaquadide")
        addItem(6116, "baseuraniumrhodiumdinaquadide")
        addItem(6117, "assemblyenrichednaquadahtriniumeuropiumduranide")
        addItem(6118, "baseenrichednaquadahtriniumeuropiumduranide")
        addItem(6119, "assemblyrutheniumtriniumamericiumneutronate")
        addItem(6120, "baserutheniumtriniumamericiumneutronate")

        //Metal sponges 6200-6300
        addItem(6200, "sponge.titanium")
        addItem(6201, "sponge.titanium.crude")
        addItem(6202, "sponge.zirconium")
        addItem(6203, "sponge.zirconium.crude")
        addItem(6204, "sponge.hafnium")
        addItem(6205, "sponge.hafnium.crude")
        addItem(6206, "sponge.platinum")
        addItem(6207, "sponge.cadmium")
        addItem(6208, "sponge.indium")
        addItem(6209, "sponge.osmium")
        addItem(6210, "sponge.ruthenium")
        addItem(6211, "sponge.rhodium")
        addItem(6212, "sponge.iridium")

        // Anode slimes 6300-6400
        addItem(6300, "anode_slime.gold")
        addItem(6301, "anode_slime.silver")
        addItem(6302, "anode_slime.lead")
        addItem(6303, "anode_slime.copper")
        addItem(6304, "anode_slime.decopperized")

        // Metallurgy 6400-6500
        addItem(6400, "work_roll.unfinished")
        addItem(6401, "nozzle.boron_nitride")

        //Seed crystals 7000-7500

        addItem(7000, "seed_crystal.silicon")
        addItem(7001, "seed_crystal.gallium_arsenide")
        addItem(7002, "seed_crystal.alumina")
        addItem(7003, "seed_crystal.beryllium_oxide")
        addItem(7004, "seed_crystal.emerald")
        addItem(7005, "seed_crystal.lithium_niobate")

        //Boules 7500-8000

        addItem(7500, "unrefined_boule.silicon")
        addItem(7501, "boule.gallium_arsenide")
        addItem(7502, "unrefined_boule.gallium_arsenide")
        addItem(7503, "boule.alumina")
        addItem(7504, "boule.beryllium_oxide")
        addItem(7505, "boule.emerald")
        addItem(7506, "boule.sapphire")
        addItem(7507, "boule.ruby")
        addItem(7508, "boule.silicon_germanium")
        addItem(7509, "boule.lithium_niobate")

        //Wafers 8000-9000

        addItem(8000, "wafer.doped.silicon")
        addItem(8001, "wafer.n_doped.silicon")
        addItem(8002, "wafer.silicon_dioxide")
        addItem(8003, "wafer.alumina")
        addItem(8004, "wafer.beryllium_oxide")
        addItem(8005, "wafer.silicon_germanium")
        addItem(8006, "wafer.insulated_silicon")
        addItem(8007, "wafer.insulated_silicon_germanium")
        addItem(8008, "wafer.doped.silicon_dioxide")
        addItem(8009, "wafer.polysilicon")
        addItem(8010, "wafer.doped.polysilicon")
        addItem(8011, "wafer.silicon_nitride")
        addItem(8012, "wafer.nickel")
        addItem(8013, "wafer.gallium_arsenide")
        addItem(8014, "wafer.raw.silicon")
        addItem(8015, "wafer.treated.silicon")

        //Crops 9000-10000

        // 9000 & 9001
        addItem(9000, "stem.cotton")

        // Train Stuff 10000-10100

        addItem(10000, "tunnelbore.axle")
        addItem(10001, "tunnelbore.engine")
        addItem(10002, "tunnelbore.drillhead")

        // Misc Crafting Components 10100-10200
        addItem(10100, "turbojet.small")
        addItem(10101, "wing_panel.fiber_reinforced_epoxy")
        addItem(10102, "wing.small")

        // Dimension Display items 10200-10250
        addItem(10200, 'display.overworld')
        addItem(10201, 'display.nether')
        addItem(10202, 'display.beneath')
        addItem(10203, 'display.moon')
        addItem(10204, 'display.mercury')
        addItem(10205, 'display.mars')
        
        // Space Components 10250-10300
        addItem(10250, "parachute.drogue")
        addItem(10251, "parachute.main")
        addItem(10252, "parachute.supersonic_main")
        addItem(10253, "carbon.mesh.phenolic.moist")
        addItem(10254, "carbon.mesh.phenolic.treated")
        addItem(10255, "carbon.tile.phenolic.treated")

        // Induction Furnace 10300-10310
        addItem(10300, "coated_copper_coil")
        addItem(10301, "cured_coated_coil")
        addItem(10302, "copper_coil")

        // Graphite Crucibles and Electrodes 10310-10330
        addItem(10310, "raw_electrode")
        addItem(10311, "carbon_electrode")
        addItem(10312, "graphite_electrode")
        addItem(10313, "raw_carbon_crucible")
        addItem(10314, "carbon_crucible")
        addItem(10315, "crucible.graphite")
        addItem(10316, "clay_graphite_paste")
        addItem(10317, "clay_graphite_crucible")
        addItem(10318, "raw_clay_graphite_crucible")

        // Alumina Refractories 10330-10340
        addItem(10330, "cac_clinker")
        addItem(10331, "hot_cac_clinker")
        addItem(10332, "cac_dust")
      
        // Lighting Components 10400-10420

        addItem(10401, "carbon_filament")
        addItem(10402, "gallium_nitride_buffer_wafer")
        addItem(10403, "raw_led_wafer")
        addItem(10404, "patterned_led_wafer")
        addItem(10405, "etched_led_wafer")
        addItem(10406, "metallized_led_wafer")
        addItem(10407, "led_chip")
        addItem(10408, "fused_quartz_bulb")
        addItem(10409, "lamp.mercury.hp.unfilled")
        addItem(10410, "lamp.mercury.hp")
        addItem(10411, "lamp.mercury.lp")
    }

    log.infoMC("Finished adding metaitems")
}
