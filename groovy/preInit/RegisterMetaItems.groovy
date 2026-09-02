package preInit

import globals.Batteries
import gregtech.api.GTValues
import gregtech.api.GregTechAPI
import gregtech.api.items.metaitem.ElectricStats
import gregtech.api.items.metaitem.StandardMetaItem
import gregtech.api.unification.material.event.PostMaterialEvent

def wordsFromNumber(int num) {
    def ones = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    def teens = ['ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'] // allocate it every time whatever
    def tens = ['', 'ten', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety']
    def hundreds = ['', 'one_hundred']
    String out = ""
    if (num < 10 && num > 0) {
        return ones[num];
    } else if (num >= 10 && num < 20) {
        return teens[num - 10]
    } else if (num < 100) {
        if (num % 10 == 0) {
            return tens[num / 10]
        }
        return tens[num / 10] + '_' + ones[num % 10];
    } else {
        if (num % 100 == 0) {
            return hundreds[num / 100];
        } else {
            return hundreds[num / 100] + '_' + wordsFromNumber(num % 100);
        }
    }
}

toadd_list = []

// Generic wafer-step metaitem registration for a single wafer namespace.
// opts (all optional): start (first step, default 2); photoresist / ashed / trilayer are arrays of
// step numbers needing those substep variants; mask + die register the component-level items.
def registerWaferSteps(String name, int stepCount, Map opts = [:]) {
    for (int i = opts.get('start', 2); i <= stepCount; i++) {
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(i))
    }
    for (step in opts.get('photoresist', [])) {
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".coated")
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".exposed")
    }
    for (step in opts.get('ashed', [])) {
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".ashed")
    }
    for (step in opts.get('trilayer', [])) { // SOC/SiON hardmask (ibarc) lithography intermediates
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".hardmasked")
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".ibarc")
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".developed")
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".etched")
    }
    for (step in opts.get('mandrel', [])) { // self-aligned Si mandrel on the ibarc hardmask (future pitch-split / spacer patterning); listed alongside trilayer
        toadd_list.add("wafer." + name + ".step_" + wordsFromNumber(step) + ".mandrel")
    }
    if (opts.get('mask', false)) {
        toadd_list.add("mask_set." + name)
    }
    if (opts.get('die', false)) {
        toadd_list.add("die." + name)
        toadd_list.add("die." + name + ".bonded")
    }
}

def registerNMOSMetaitems(String name, int stepCount = 25, List photoresist = [7, 12, 15, 21]) {
    registerWaferSteps(name, stepCount, [photoresist: photoresist, mask: true, die: true])
}

def registerCMOSMetaitems(String name) {
    // Step 2 is the STI split layer: the family forks off the shared cmos_base trunk at exposure,
    // so only step_two.exposed is per-family (step_two.coated belongs to cmos_base)
    toadd_list.add("wafer." + name + ".step_two.exposed")

    // FEOL/MEOL shares the main step namespace and carries the component die + mask
    registerWaferSteps(name, 74, [start: 3, mask: true, die: true,
        photoresist: [11, 14, 23, 28, 32, 39, 51, 59, 67],
        ashed:       [6, 13, 16, 27, 31, 35, 41, 53, 61, 70],
        trilayer:    [23, 59, 67]])

    // 9-layer damascene copper BEOL; layers 1-6 use trilayer (ibarc) resist
    for (int i = 1; i <= 9; i++) {
        def opts = (i <= 6) ? [start: 1, photoresist: [1], trilayer: [1], ashed: [3]]
                            : [start: 1, photoresist: [1]]
        registerWaferSteps(name + ".beol_" + wordsFromNumber(i), 8, opts)
    }

    // Sealing and packaging
    registerWaferSteps(name + ".pkg", 13, [start: 1, photoresist: [2, 7], ashed: [10]])
}

def registerBCDMetaitems() {
    // Shared bcd_base trunk: FEOL/MEOL steps 1-82 (uses mask_set.bcd_base; the trunk itself is never diced)
    registerWaferSteps("bcd_base", 82, [start: 1, mask: true,
        photoresist: [2, 5, 11, 20, 27, 31, 34, 39, 43, 47, 50, 53, 58, 61, 70, 75],
        ashed:       [4, 7, 16, 24, 29, 33, 36, 49, 52, 55, 60, 63, 72, 78],
        trilayer:    [11],   // DTI patterning
        mandrel:     [11]])  // DTI patterning uses a self-aligned mandrel

    // Shared lower metal M1-M3 (M1-M2 trilayer, M3 novolac)
    for (int i = 1; i <= 3; i++) {
        def opts = (i <= 2) ? [start: 1, photoresist: [1], trilayer: [1], ashed: [3]]
                            : [start: 1, photoresist: [1]]
        registerWaferSteps("bcd_base.beol_" + wordsFromNumber(i), 8, opts)
    }

    // Shared M4 dielectric + coat: the fork point each tier splits from
    toadd_list.add("wafer.bcd_base.beol_four.step_one")
    toadd_list.add("wafer.bcd_base.beol_four.step_one.coated")

    // Tiers diverge at M4 and finish at their top metal layer (HV=4, EV=5, IV=6)
    def tiers = ['bcd_lpic': 4, 'bcd_pic': 5, 'bcd_hpic': 6]
    tiers.each { tier, topLayer ->
        // M4 is the split layer: only step_one.exposed (from the split) plus steps 2-8
        registerWaferSteps(tier + ".beol_four", 8, [start: 2])
        toadd_list.add("wafer." + tier + ".beol_four.step_one.exposed")
        // M5..top are ordinary novolac damascene layers
        for (int i = 5; i <= topLayer; i++) {
            registerWaferSteps(tier + ".beol_" + wordsFromNumber(i), 8, [start: 1, photoresist: [1]])
        }
        // Sealing/packaging carries this tier's die + mask
        registerWaferSteps(tier + ".pkg", 13, [start: 1, mask: true, die: true, photoresist: [2, 7], ashed: [10]])
    }
}

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
        addItem(103, "graphite_paper")
        addItem(104, "shape.mold.rod")
        addItem(105, "shape.mold.crucible")
        addItem(106, "crucible.boron.nitride")
        addItem(107, "crucible.quartz")
        addItem(109, "shape.mold.long_rod")
        addItem(110, "shape.mold.ring")
        addItem(111, "crucible.tantalum")
        addItem(112, "shape.mold.pin")
        addItem(113, "shape.mold.leadframe")
        addItem(114, "shape.mold.bolt")

        addItem(150, "mudbrick_mix")
        addItem(151, "slaked_lime")
        addItem(152, "sand.dust")
        addItem(153, "native_copper")
        addItem(154, "washed_rotten_flesh")
        addItem(155, "sugar_cane_dust")

        addItem(156, "laminated_dry_film_photoresist")

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
        addItem(174, "membrane.polysulfone")
        addItem(175, "membrane.cation_exchange")
        addItem(176, "membrane.anion_exchange")

        addItem(177, "membrane.support.alumina")
        addItem(178, "membrane.zeolite")

        addItem(179, "dry_film_photoresist")

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

        addItem(215, "component.commutator")
        addItem(216, "component.brush.unfired")
        addItem(217, "component.brush")

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
        addItem(501, "ceramic_casing")

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

        // circuit overhaul metaitems: 2750 - 3000
        // FREE ID: 2750 - 2755
        addItem(2756, "component.transistor.alloy_junction")
        addItem(2757, "plate.ultra_low_power_integrated_circuit")
        addItem(2758, "plate.low_power_integrated_circuit")
        addItem(2759, "plate.power_integrated_circuit")
        addItem(2760, "plate.high_power_integrated_circuit")
        addItem(2761, "component.quartz_oscillator")
        // FREE ID: 2762 - 2764
        addItem(2765, "component.clock_generator")
        addItem(2766, "component.crystal_oscillator")
        addItem(2767, "component.diode.schottky")
        addItem(2768, "component.floppy_controller")
        addItem(2769, "component.floppy_disk")
        addItem(2770, "component.floppy_drive")
        addItem(2771, "component.floppy_head")
        addItem(2772, "component.heat_sink")
        addItem(2773, "component.leadframe")
        addItem(2774, "component.nmos_bus_controller")
        addItem(2775, "component.nmos_cpu")
        addItem(2776, "component.nmos_dram")
        addItem(2777, "component.nmos_expansion_bus")
        addItem(2778, "component.nmos_mask_rom")
        addItem(2779, "component.nmos_sram")
        addItem(2780, "component.nmos_uart")
        addItem(2781, "component.solenoid")
        addItem(2782, "component.capacitor.film")
        addItem(2783, "component.fuse.hv")
        addItem(2784, "component.op_amp")
        addItem(2785, "component.protector_circuit")
        addItem(2786, "component.resistor.carbon_film")
        addItem(2787, "component.zener_diode")
        addItem(2788, "component.relay")
        addItem(2789, "component.capacitor.film.core")
        addItem(2790, "component.capacitor.film.metallized_film")
        addItem(2791, "component.capacitor.film.metallized_film.impregnated")
        addItem(2792, "component.capacitor.silver_mica")
        addItem(2793, "component.diode.alloy_junction")
        addItem(2794, "component.diode.planar")
        addItem(2795, "component.diode.power")
        addItem(2796, "component.smd.contact")
        addItem(2797, "component.resistor.carbon_composite")
        addItem(2798, "component.resistor.carbon_composite.fired")
        addItem(2799, "component.resistor.carbon_composite.unfired")
        addItem(2800, "component.resistor.carbon_film.core")
        addItem(2801, "component.resistor.carbon_film.cut_substrate")
        addItem(2802, "component.transistor.alloy_junction.core")
        addItem(2803, "circuit.power.lv")
        addItem(2804, "circuit.power.mv")
        addItem(2805, "circuit.power.hv")
        addItem(2806, "circuit.power.ev")
        addItem(2807, "barium_titanate_paste")
        addItem(2808, "doped_barium_titanate_paste")
        addItem(2809, "sheet.barium_titanate")
        addItem(2810, "sheet.doped_barium_titanate")
        addItem(2811, "component.bme_cap.layer")
        addItem(2812, "component.bme_cap.wafer")
        addItem(2813, "component.bme_cap.unfired")
        addItem(2814, "component.bme_cap.fired")
        addItem(2815, "component.bme_cap.polished")
        addItem(2816, "component.bme_cap.dipped")
        addItem(2817, "component.bme_cap.terminated")
        addItem(2818, "component.bme_cap.plated")
        addItem(2819, "component.bme_cap")
        addItem(2820, "component.pme_cap.layer")
        addItem(2821, "component.pme_cap.wafer")
        addItem(2822, "component.pme_cap.unfired")
        addItem(2823, "component.pme_cap.fired")
        addItem(2824, "component.pme_cap.polished")
        addItem(2825, "component.pme_cap.dipped")
        addItem(2826, "component.pme_cap.terminated")
        addItem(2827, "component.pme_cap.plated")
        addItem(2828, "component.pme_cap")
        addItem(2829, "screen_printing.pattern.mlcc")
        addItem(2830, "mesh.stainless_steel")
        addItem(2831, "screen_printing.pattern.resistor_pads")
        addItem(2832, "screen_printing.pattern.resistor")
        addItem(2833, "component.resistor.wafer.printed_pads")
        addItem(2834, "component.resistor.wafer.pads")
        addItem(2835, "component.thick_film_resistor.wafer.printed")
        addItem(2836, "component.thick_film_resistor.wafer.fired")
        addItem(2837, "component.thick_film_resistor.wafer.etched")
        addItem(2838, "component.thick_film_resistor.wafer.printed_coating")
        addItem(2839, "component.thick_film_resistor.wafer")
        addItem(2840, "component.thick_film_resistor.unterminated")
        addItem(2841, "component.thick_film_resistor.polished")
        addItem(2842, "component.thick_film_resistor.dipped")
        addItem(2843, "component.thick_film_resistor.terminated")
        addItem(2844, "component.thick_film_resistor.plated")
        addItem(2846, "component.thick_film_resistor")
        addItem(2847, "component.thin_film_resistor.wafer.coated")
        addItem(2848, "component.thin_film_resistor.wafer.exposed")
        addItem(2849, "component.thin_film_resistor.wafer.patterned")
        addItem(2850, "component.thin_film_resistor.wafer")
        addItem(2851, "component.thin_film_resistor.wafer.stripped")
        addItem(2852, "component.thin_film_resistor.wafer.etched")
        addItem(2853, "component.thin_film_resistor.wafer.tuned")
        addItem(2854, "component.thin_film_resistor.unterminated")
        addItem(2855, "component.thin_film_resistor.polished")
        addItem(2856, "component.thin_film_resistor.dipped")
        addItem(2857, "component.thin_film_resistor.terminated")
        addItem(2858, "component.thin_film_resistor.plated")
        addItem(2860, "component.thin_film_resistor")

        addItem(2861, "edlc_electrode_powder")
        addItem(2862, "edlc_electrode_coated")
        addItem(2863, "edlc_electrode")
        addItem(2864, "component.capacitor.edlc")
        addItem(2865, "component.thyristor.assembly")
        addItem(2866, "component.thyristor")

        addItem(2867, "circuit.power.iv")

        // circuit overhaul dies 2950 - 3000
        addItem(2954, "die.diode.alloy")
        addItem(2955, "die.diode.planar")
        addItem(2956, "die.diode.power")
        addItem(2957, "die.diode.schottky")
        addItem(2958, "die.zener_diode.alloy")
        addItem(2959, "die.alloy_junction_transistor.step_one")
        addItem(2960, "die.alloy_junction_transistor.step_two")
        addItem(2961, "die.alloy_junction_transistor.step_three")



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
        addItem(3501, "zest.orange")
        addItem(3502, "zest.lemon")
        addItem(3503, "zest.lime")

        // Battery hulls 3900-4000
        addItem(3900, "battery.primitivehull.lv")
        addItem(3901, "battery.primitivehull.mv")
        addItem(3902, "battery.steel_hull.lv")
        addItem(3903, "battery.steel_hull.mv")
        addItem(3904, "battery.steel_hull.hv")
        addItem(3905, "battery.ni_fe_hull.lv")
        addItem(3906, "battery.ni_fe_hull.mv")
        addItem(3907, "battery.ni_fe_hull.hv")
        addItem(3908, "battery.stainless_steel_hull.hv")
        addItem(3909, "battery.stainless_steel_hull.ev")
        addItem(3910, "battery.stainless_steel_hull.iv")

        //Batteries 4000-4100
        Batteries['lead_acid'].register(it, 4000)
        addItem(4001, "cathode.lead")
        addItem(4002, "anode.lead")
        addItem(4003, "cathode.lead_paste")
        addItem(4004, "cathode.lead_frame")
        Batteries['lead_acid.mv'].register(it, 4005)
        addItem(4006, "electrode.steel_frame")
        addItem(4007, "electrode.nickeled_steel_frame")
        Batteries['ni_fe.lv'].register(it, 4008)
        Batteries['ni_fe'].register(it, 4009)
        Batteries['ni_fe.hv'].register(it, 4010)
        addItem(4011, "cathode.nioh2")
        Batteries['ni_cd.mv'].register(it, 4012)
        Batteries['ni_cd.hv'].register(it, 4013)
        Batteries['ni_cd.ev'].register(it, 4014)
        addItem(4015, "anode.cadmium_oxide")
        Batteries['ni_mh.hv'].register(it, 4016)
        Batteries['ni_mh.ev'].register(it, 4017)
        Batteries['ni_mh.iv'].register(it, 4018)
        addItem(4019, "electrode.nickeled_steel_foil")
        addItem(4020, "membrane.caprolactam")
        addItem(4021, "membrane.caprolactam_wet")
        addItem(4022, "anode.mh")
        addItem(4023, "membrane.cast_film")


        addItem(4101, "vacuum_tube_components")
        //Flow batteries 4200-4300
        addItem(4200, "needle.steel")
        addItem(4201, "needle.steel.barbed")
        addItem(4202, "needle_assembly.steel.barbed")
        addItem(4203, "membrane.vanadium_battery")
        addItem(4204, "expanded_graphite_worms")
        addItem(4205, "foil.punched_polyacrylonitrile")
        addItem(4206, "foil.carbon_felt")
        addItem(4207, "foil.activated_carbon_felt")
        addItem(4208, "paste.lubricated_ptfe")
        addItem(4209, "preform.lubricated_ptfe")
        addItem(4210, "foil.extruded_ptfe")
        addItem(4211, "foil.stretched_ptfe")

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
        addItem(5008, "stencil.resistor")
        addItem(5009, "stencil.capacitor")
        addItem(5010, "stencil.resistor_pads")

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
        addItem(5030, "mask.diode.planar")
        addItem(5031, "mask_set.diode.power")
        addItem(5032, "mask_set.diode.schottky")
        addItem(5033, "mask.resistor")

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
        addItem(5800, "board.fr4.prepreg")
        addItem(5801, "board.fr4.copper_clad");
        addItem(5802, "board.fr4.patterned");
        addItem(5803, "board.fr4.etched");
        addItem(5804, "board.fr4.drilled");
        addItem(5805, "board.fr4.electroless");
        addItem(5806, "board.fr4.electrolytic");
        addItem(5807, "board.fr4.wet_masked");
        addItem(5808, "board.fr4.mask_affixed");
        addItem(5809, "circuit_board.fr4")
        addItem(5810, "board.fr4.resist")
        addItem(5811, "board.fr4.developed")

        addItem(5812, "board.g10.prepreg")
        addItem(5813, "board.g10.copper_clad");
        addItem(5814, "board.g10.resist")
        addItem(5815, "board.g10.patterned");
        addItem(5816, "board.g10.etched");
        addItem(5817, "board.g10.drilled");
        addItem(5818, "board.g10.electroless");
        addItem(5819, "board.g10.electrolytic");
        addItem(5820, "board.g10.wet_masked");
        addItem(5821, "board.g10.mask_affixed");
        addItem(5822, "circuit_board.g10")
        addItem(5823, "board.g10.developed")

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
        addItem(7006, "seed_crystal.germanium")

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
        addItem(7510, "boule.germanium.n_doped")
        // overhaul boules
        addItem(7511, "boule.silicon.cz")
        addItem(7512, "boule.silicon.cz.n_doped")
        addItem(7513, "boule.silicon.cz.p_doped")
        addItem(7514, "boule.silicon.fz.n_doped")
        addItem(7515, "boule.silicon.fz.heavily_n_doped")
        addItem(7516, "boule.germanium.n_doped")
        addItem(7517, "boule.gallium_arsenide.n_doped")

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

        // new wafers in overhaul; not going to delete any already existing materials
        addItem(8016, "wafer.quartz.at_cut.tuned")
        addItem(8017, "wafer.quartz.at_cut")
        addItem(8018, "wafer.diode.alloy.step_one")
        addItem(8019, "wafer.silicon.small.heavily_n_doped")
        addItem(8020, "wafer.silicon.small.n_doped")
        addItem(8021, "wafer.zener_diode.alloy.step_one")

        addItem(8022, "wafer.silicon")
        addItem(8023, "wafer.silicon.polished")
        addItem(8024, "wafer.silicon.raw")
        addItem(8025, "wafer.silicon.p_doped")
        addItem(8026, "wafer.silicon.p_doped.polished")
        addItem(8027, "wafer.silicon.p_doped.raw")
        addItem(8028, "wafer.silicon.n_doped")
        addItem(8029, "wafer.silicon.n_doped.polished")
        addItem(8030, "wafer.silicon.n_doped.raw")
        addItem(8031, "wafer.small.silicon.n_doped")
        addItem(8032, "wafer.small.silicon.n_doped.polished")
        addItem(8033, "wafer.small.silicon.n_doped.raw")
        addItem(8034, "wafer.small.silicon.heavily_n_doped")
        addItem(8035, "wafer.small.silicon.heavily_n_doped.polished")
        addItem(8036, "wafer.small.silicon.heavily_n_doped.raw")
        addItem(8037, "wafer.germanium.n_doped")
        addItem(8038, "wafer.germanium.n_doped.polished")
        addItem(8039, "wafer.germanium.n_doped.raw")
        addItem(8040, "wafer.gallium_arsenide.n_doped")
        addItem(8041, "wafer.gallium_arsenide.n_doped.polished")
        addItem(8042, "wafer.gallium_arsenide.n_doped.raw")

        addItem(8043, "wafer.nmos.step_one") // the suffering begins
        // its cmos time baby
        addItem(8044, "wafer.cmos_base.step_one")
        addItem(8045, "wafer.cmos_base.step_two")
        addItem(8046, "wafer.cmos_base.step_two.coated")
        // FREE ID: 8047 - 8048 (per-family step_two.exposed now comes from registerCMOSMetaitems)

        registerNMOSMetaitems("nmos_cpu")
        registerNMOSMetaitems("nmos_sram")
        registerNMOSMetaitems("nmos_uart")
        registerNMOSMetaitems("nmos_mask_rom")
        registerNMOSMetaitems("nmos_bus_controller")
        registerNMOSMetaitems("nmos_dram", 22, [9, 12, 18])
        registerWaferSteps("bjt_pic_base", 17, [start: 1, mask: true, photoresist: [5, 9, 13, 17]])
        registerWaferSteps("bjt_ulpic", 5, [start: 1, mask: true, die: true, photoresist: [1]])
        registerWaferSteps("bjt_lpic", 19, [start: 1, mask: true, die: true, photoresist: [5, 10, 15]])
        registerWaferSteps("bjt_pic", 17, [start: 1, mask: true, die: true, photoresist: [5, 9, 13]])
        registerCMOSMetaitems("cmos_cpu")
        registerWaferSteps("diode.planar", 10, [start: 1, mask: true])
        registerWaferSteps("diode.power", 14, [mask: true])
        registerWaferSteps("diode.schottky", 13, [mask: true])
        registerWaferSteps("thyristor", 11, [start: 1, mask: true])
        registerCMOSMetaitems("cmos_gpu")
        registerBCDMetaitems() // enable together with the BCD recipe chain (still commented in NanoIntegratedCircuits.groovy)

        // Monocrystalline silicon photovoltaic cells (mask./cell. naming, not mask_set./die.)
        registerWaferSteps("monosilicon_photovoltaic", 8, [start: 1, photoresist: [4]])
        toadd_list.add("mask.monosilicon_photovoltaic")
        toadd_list.add("cell.monosilicon_photovoltaic")

        // EV logic die families; ride the same 45nm CMOS flow as cmos_cpu/cmos_gpu
        registerCMOSMetaitems("cmos_chipset") // PCIe root complex / memory controller
        registerCMOSMetaitems("cmos_phy")     // Ethernet/USB serdes I/O

        addItem(8049, "wafer.diode.alloy.step_two")
        addItem(8050, "wafer.zener_diode.alloy.step_two")
        addItem(8051, "wafer.diode.drift.step_one")
        addItem(8052, "wafer.diode.planar.step_four.bsg")
        addItem(8053, "wafer.diode.power.step_three.coated")
        addItem(8054, "wafer.diode.power.step_three.exposed")
        addItem(8055, "wafer.diode.power.step_nine.coated")
        addItem(8056, "wafer.diode.power.step_nine.exposed")
        addItem(8057, "wafer.diode.power.step_nine.deposited")
        addItem(8058, "wafer.diode.planar.step_one.coated")
        addItem(8059, "wafer.diode.planar.step_one.exposed")
        addItem(8060, "wafer.diode.schottky.step_eight.coated")
        addItem(8061, "wafer.diode.schottky.step_eight.exposed")
        addItem(8062, "wafer.diode.schottky.step_eight.deposited")
        addItem(8063, "wafer.diode.power.step_nine.exposed")
        // FREE ID: 8064
        addItem(8065, "wafer.silicon.n_doped.coated")
        addItem(8066, "wafer.silicon.n_doped.exposed")
        addItem(8067, "wafer.thyristor.step_one.coated")
        addItem(8068, "wafer.thyristor.step_one.exposed")
        addItem(8069, "wafer.thyristor.step_three.coated")
        addItem(8070, "wafer.thyristor.step_three.exposed")
        addItem(8073, "wafer.thyristor.step_seven.coated")
        addItem(8074, "wafer.thyristor.step_seven.exposed")
        addItem(8075, "wafer.thyristor.step_seven.deposited")
        addItem(8076, "wafer.thyristor")
        addItem(8077, "wafer.nmos.step_one.coated")
        addItem(8078, "wafer.nmos_cpu.step_one.exposed")
        addItem(8079, "wafer.nmos_sram.step_one.exposed")
        addItem(8080, "wafer.nmos_uart.step_one.exposed")
        addItem(8081, "wafer.nmos_mask_rom.step_one.exposed")
        addItem(8082, "wafer.nmos_bus_controller.step_one.exposed")
        addItem(8083, "wafer.nmos_dram.step_one.exposed")
        addItem(8084, "wafer.silicon.p_doped.coated")
        addItem(8085, "wafer.silicon.p_doped.exposed")
        addItem(8086, "wafer.diode.drift.step_one.coated")
        addItem(8087, "wafer.diode.drift.step_one.exposed")
        addItem(8088, "wafer.diode.schottky.step_five.coated")
        addItem(8089, "wafer.diode.schottky.step_five.exposed")

        log.infoMC("adding " + toadd_list.size() + " wafer metaitems")
        def start = 8250
        for (name in toadd_list) {
            if (start == 8975) start = 11000 // skip reserved 8975-9000 (sputtering targets + crops)
            addItem(start, name)
            start++
        }

        // 8975-9000 sputtering targets
        addItem(8975, "target.aluminium")
        addItem(8976, "target.copper")
        addItem(8977, "target.titanium")
        addItem(8978, "target.nickel")
        addItem(8979, "target.silver")
        addItem(8980, "target.gold")
        addItem(8981, "target.palladium")
        addItem(8982, "target.tungsten")
        addItem(8983, "target.antimony")
        addItem(8984, "target.silicon")
        addItem(8985, "target.platinum")
        addItem(8986, "target.tantalum")
        addItem(8987, "target.chromium")
        addItem(8988, "target.tantalum_nitride")

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
        addItem(10319, "raw_carbon_plate")
        addItem(10320, "carbon_plate")
        addItem(10321, "graphite_plate")

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
