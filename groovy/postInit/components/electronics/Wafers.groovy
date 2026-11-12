import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.recipes.chance.output.ChancedOutputLogic
import gregtech.api.metatileentity.multiblock.CleanroomType

mods.jei.ingredient.yeet(
    metaitem('boule.gallium_arsenide'),
    metaitem('boule.gallium_arsenide.n_doped'),
    metaitem('boule.silicon'),
    metaitem('boule.phosphorus'),
    metaitem('boule.naquadah'),
    metaitem('boule.neutronium'),
    metaitem('wafer.pattern.processor'),
    metaitem('wafer.pattern.memory'),
    metaitem('gallium_nitride_buffer_wafer'),
    metaitem('raw_led_wafer'),
    metaitem('patterned_led_wafer'),
    metaitem('etched_led_wafer'),
    metaitem('metallized_led_wafer'),
    metaitem('wafer.silicon'),
    metaitem('wafer.phosphorus'),
    metaitem('wafer.naquadah'),
    metaitem('wafer.neutronium'),
    metaitem('wafer.central_processing_unit'),
    metaitem('wafer.random_access_memory'),
    metaitem('wafer.integrated_logic_circuit'),
    metaitem('wafer.nano_central_processing_unit'),
    metaitem('wafer.qbit_central_processing_unit'),
    metaitem('wafer.simple_system_on_chip'),
    metaitem('wafer.system_on_chip'),
    metaitem('wafer.advanced_system_on_chip'),
    metaitem('wafer.highly_advanced_system_on_chip'),
    metaitem('wafer.nand_memory_chip'),
    metaitem('wafer.nor_memory_chip'),
    metaitem('wafer.ultra_low_power_integrated_circuit'),
    metaitem('wafer.low_power_integrated_circuit'),
    metaitem('wafer.power_integrated_circuit'),
    metaitem('wafer.high_power_integrated_circuit'),
    metaitem('wafer.ultra_high_power_integrated_circuit'),
    metaitem('plate.pattern.processor'),
    metaitem('plate.pattern.memory'),
    metaitem('led_chip'),
    metaitem('plate.central_processing_unit'),
    metaitem('plate.random_access_memory'),
    metaitem('plate.integrated_logic_circuit'),
    metaitem('plate.nano_central_processing_unit'),
    metaitem('plate.qbit_central_processing_unit'),
    metaitem('plate.simple_system_on_chip'),
    metaitem('plate.system_on_chip'),
    metaitem('plate.advanced_system_on_chip'),
    metaitem('plate.highly_advanced_system_on_chip'),
    metaitem('plate.nand_memory_chip'),
    metaitem('plate.nor_memory_chip'),
    item('gregtech:meta_item_2', 2759),
    item('gregtech:meta_item_2', 2760),
    item('gregtech:meta_item_2', 2761),
    item('gregtech:meta_item_2', 2762),
    item('gregtech:meta_item_2', 2763)
)

def cutterRemovals = [
    [metaitem: metaitem('boule.silicon'), EUt: 64, water: 900, distilled_water: 676, lubricant: 225],
    [metaitem: metaitem('boule.phosphorus'), EUt: 480, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('boule.naquadah'), EUt: 1920, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('boule.neutronium'), EUt: 7680, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.central_processing_unit'), EUt: 120, water: 337, distilled_water: 253, lubricant: 84],
    [metaitem: metaitem('wafer.random_access_memory'), EUt: 96, water: 270, distilled_water: 202, lubricant: 67],
    [metaitem: metaitem('wafer.integrated_logic_circuit'), EUt: 64, water: 180, distilled_water: 135, lubricant: 45],
    [metaitem: metaitem('wafer.nano_central_processing_unit'), EUt: 480, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.qbit_central_processing_unit'), EUt: 1920, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.simple_system_on_chip'), EUt: 64, water: 180, distilled_water: 135, lubricant: 45],
    [metaitem: metaitem('wafer.system_on_chip'), EUt: 480, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.advanced_system_on_chip'), EUt: 1920, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.highly_advanced_system_on_chip'), EUt: 7680, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.nand_memory_chip'), EUt: 192, water: 540, distilled_water: 405, lubricant: 135],
    [metaitem: metaitem('wafer.nor_memory_chip'), EUt: 192, water: 540, distilled_water: 405, lubricant: 135],
    [metaitem: metaitem('wafer.ultra_low_power_integrated_circuit'), EUt: 120, water: 337, distilled_water: 253, lubricant: 84],
    [metaitem: metaitem('wafer.low_power_integrated_circuit'), EUt: 480, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.power_integrated_circuit'), EUt: 1920, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.high_power_integrated_circuit'), EUt: 7680, water: 1000, distilled_water: 750, lubricant: 250],
    [metaitem: metaitem('wafer.ultra_high_power_integrated_circuit'), EUt: 30720, water: 1000, distilled_water: 750, lubricant: 250],
]

cutterRemovals.each { entry ->
    mods.gregtech.cutter.removeByInput(entry.EUt, [entry.metaitem], [fluid('water') * entry.water])
    mods.gregtech.cutter.removeByInput(entry.EUt, [entry.metaitem], [fluid('distilled_water') * entry.distilled_water])
    mods.gregtech.cutter.removeByInput(entry.EUt, [entry.metaitem], [fluid('lubricant') * entry.lubricant])
}

// Phosphorus-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustSilicon') * 64, metaitem('dustPhosphorus') * 8, metaitem('dustSmallGalliumArsenide') * 2], [fluid('nitrogen') * 8000])
// Naquadah-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('blockSilicon') * 16, metaitem('ingotNaquadah'), metaitem('dustGalliumArsenide')], [fluid('argon') * 8000])
// Neutronium-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(7680, [metaitem('blockSilicon') * 32, metaitem('ingotNeutronium') * 4, metaitem('dustGalliumArsenide') * 2], [fluid('xenon') * 8000])

// Seed crystal from Bridgman-Stockbarger growth

VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid("silicon_dioxide") * 1008)
    .notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('crucible.quartz'))
    .duration(1440)
    .EUt(VA[LV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(metaitem('crucible.quartz'))
    .notConsumable(ore('springCupronickel') * 2)
    .fluidInputs(fluid('high_purity_silicon') * 576)
    .outputs(metaitem('seed_crystal.silicon'))
    .duration(840)
    .EUt(VA[MV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(metaitem('crucible.quartz'))
    .notConsumable(ore('springCupronickel') * 2)
    .fluidInputs(fluid('high_purity_germanium') * 576)
    .outputs(metaitem('seed_crystal.germanium'))
    .duration(840)
    .EUt(VA[MV])
    .buildAndRegister()

// Boules

// Doped mixtures

// Float zone refining process (Small pieces, needed MV+)
def induction_coils = [
    metaitem('coated_copper_coil'),
    metaitem('cured_coated_coil'),
    metaitem('copper_coil')
]

for (induction_coil in induction_coils) {
    ZONE_REFINER.recipeBuilder()
        .circuitMeta(1)
        .notConsumable(induction_coil)
        .fluidInputs(fluid('phosphine'))
        .inputs(metaitem('seed_crystal.silicon'))
        .inputs(ore('blockHighPuritySilicon'))
        .outputs(metaitem('boule.silicon.fz.n_doped'))
        .duration(9600)
        .EUt(VA[MV])
        .buildAndRegister()

    ZONE_REFINER.recipeBuilder()
        .circuitMeta(2)
        .notConsumable(induction_coil)
        .notConsumable(fluid('argon') * 100)
        .fluidInputs(fluid('phosphine'))
        .inputs(metaitem('seed_crystal.silicon'))
        .inputs(ore('blockHighPuritySilicon'))
        .outputs(metaitem('boule.silicon.fz.n_doped'))
        .duration(1200)
        .EUt(VA[MV])
        .buildAndRegister()

    ZONE_REFINER.recipeBuilder()
        .circuitMeta(3) 
        .notConsumable(induction_coil)
        .fluidInputs(fluid('phosphine') * 100)
        .inputs(metaitem('seed_crystal.silicon'))
        .inputs(ore('blockHighPuritySilicon'))
        .outputs(metaitem('boule.silicon.fz.heavily_n_doped'))
        .duration(9600)
        .EUt(VA[MV])
        .buildAndRegister()

    ZONE_REFINER.recipeBuilder()
        .circuitMeta(4)
        .notConsumable(induction_coil)
        .notConsumable(fluid('argon') * 100)
        .fluidInputs(fluid('phosphine') * 100)
        .inputs(metaitem('seed_crystal.silicon'))
        .inputs(ore('blockHighPuritySilicon'))
        .outputs(metaitem('boule.silicon.fz.heavily_n_doped'))
        .duration(1200)
        .EUt(VA[MV])
        .buildAndRegister()
}

// Small scale Czochiralski process

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('phosphine'))
    .notConsumable(metaitem('crucible.graphite'))
    .notConsumable(metaitem('electric.pump.mv'))
    .inputs(metaitem('seed_crystal.germanium'))
    .inputs(ore('blockHighPurityGermanium'))
    .outputs(metaitem('boule.germanium.n_doped'))
    .duration(9600)
    .EUt(VA[MV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('argon') * 100)
    .fluidInputs(fluid('phosphine'))
    .notConsumable(metaitem('crucible.graphite'))
    .inputs(metaitem('seed_crystal.germanium'))
    .inputs(ore('blockHighPurityGermanium'))
    .outputs(metaitem('boule.germanium.n_doped'))
    .duration(1200)
    .EUt(VA[MV])
    .buildAndRegister()

// Czochiralski Process (Large wafers, needed HV+)

CRYSTALLIZER.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(fluid('argon') * 1000)
    .fluidInputs(fluid('high_purity_silicon') * 5184)
    .notConsumable(metaitem('crucible.quartz'))
    .inputs(metaitem('seed_crystal.silicon'))
    .outputs(metaitem('boule.silicon.cz'))
    .duration(6750)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .circuitMeta(2)
    .notConsumable(fluid('argon') * 1000)
    .fluidInputs(fluid('phosphine') * 4)
    .notConsumable(metaitem('crucible.quartz'))
    .fluidInputs(fluid('high_purity_silicon') * 5184)
    .inputs(metaitem('seed_crystal.silicon'))
    .outputs(metaitem('boule.silicon.cz.n_doped'))
    .duration(6750)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .circuitMeta(2)
    .notConsumable(fluid('argon') * 1000)
    .fluidInputs(fluid('boron_trioxide') * 4)
    .notConsumable(metaitem('crucible.quartz'))
    .fluidInputs(fluid('high_purity_silicon') * 5184)
    .inputs(metaitem('seed_crystal.silicon'))
    .outputs(metaitem('boule.silicon.cz.p_doped'))
    .duration(6750)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

//CRYSTALLIZER.recipeBuilder()
//    .fluidInputs(fluid('high_purity_gallium') * 2592)
//    .fluidInputs(fluid('high_purity_arsenic') * 2592)
//    .notConsumable(fluid('boron_trioxide') * 720)
//    .inputs(metaitem('seed_crystal.gallium_arsenide'))
//    .notConsumable(metaitem('crucible.boron.nitride'))
//    .outputs(metaitem('boule.gallium_arsenide'))
//    .duration(240)
//    .EUt(VA[LV])
//    .buildAndRegister()

// Indium phosphide

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustHighPurityIndium') * 4)
    .fluidInputs(fluid('high_purity_phosphorus') * 576)
    .outputs(metaitem('seed_crystal.indium_phosphide'))
    .circuitMeta(1)
    .duration(1200)
    .EUt(VA[HV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustHighPurityIndium'))
    .fluidInputs(fluid('high_purity_phosphorus') * 144)
    .notConsumable(fluid('boron_trioxide') * 720)
    .inputs(metaitem('seed_crystal.indium_phosphide'))
    .notConsumable(metaitem('crucible.boron.nitride'))
    .outputs(metaitem('boule.indium_phosphide'))
    .duration(300)
    .EUt(VA[HV])
    .buildAndRegister()

// Wafer preparation

class Wafer {
    String boule_name
    String wafer_name
    String seed_name
    String dust_name
    boolean small

    // Property getters

    def isSmall() {
        return small
    }

    // Itemstack getters
    
    def getSeed(int count = 1) {
        return metaitem(seed_name) * count
    }

    def getBoule(int count = 1) {
        return metaitem(boule_name) * count
    }

    def getRawWafer(int count = 1) {
        return metaitem(wafer_name + '.raw') * count
    }

    def getPolishedWafer(int count = 1) {
        return metaitem(wafer_name + '.polished') * count
    }

    def getWafer(int count = 1) {
        return metaitem(wafer_name) * count
    }

    def getDust(int count = 1) {
        return metaitem(dust_name) * count
    }

    Wafer(String boule_name, String wafer_name, String seed_name, String dust_name, boolean small) {
        this.boule_name = boule_name
        this.wafer_name = wafer_name
        this.seed_name = seed_name
        this.dust_name = dust_name
        this.small = small
    }
}

def wafers = [
    new Wafer('boule.silicon.cz', 'wafer.silicon', 'seed_crystal.silicon', 'dustSilicon', false),
    new Wafer('boule.silicon.cz.p_doped', 'wafer.silicon.p_doped', 'seed_crystal.silicon', 'dustSilicon', false),
    new Wafer('boule.silicon.cz.n_doped', 'wafer.silicon.n_doped', 'seed_crystal.silicon', 'dustSilicon', false),
    new Wafer('boule.silicon.fz.n_doped', 'wafer.small.silicon.n_doped', 'seed_crystal.silicon', 'dustSilicon', true),
    new Wafer('boule.silicon.fz.heavily_n_doped', 'wafer.small.silicon.heavily_n_doped', 'seed_crystal.silicon', 'dustSilicon', true),
    new Wafer('boule.germanium.n_doped', 'wafer.germanium.n_doped', 'seed_crystal.germanium', 'dustGermanium', true),
//    new Wafer('boule.gallium_arsenide.n_doped', 'wafer.gallium_arsenide.n_doped', 'seed_crystal.gallium_arsenide', 'dustGalliumArsenide', true),
    new Wafer('boule.indium_phosphide', 'wafer.indium_phosphide', 'seed_crystal.indium_phosphide', 'dustIndiumPhosphide', false)
]

// CMP slurry & RCA clean solutions.

MIXER.recipeBuilder() // Piranha solution
    .circuitMeta(1)
    .fluidInputs(fluid('ultrapure_water') * 975)
    .fluidInputs(fluid('hydrogen_peroxide') * 25)
    .fluidInputs(fluid('ammonia') * 45)
    .fluidOutputs(fluid('standard_clean_one') * 1000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('ultrapure_water') * 975)
    .fluidInputs(fluid('hydrogen_peroxide') * 25)
    .fluidInputs(fluid('ammonia') * 45)
    .fluidOutputs(fluid('standard_clean_one') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('ultrapure_water') * 980)
    .fluidInputs(fluid('hydrogen_peroxide') * 20)
    .fluidInputs(fluid('hydrogen_chloride') * 25)
    .fluidOutputs(fluid('standard_clean_two') * 1000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('ultrapure_water') * 980)
    .fluidInputs(fluid('hydrogen_peroxide') * 20)
    .fluidInputs(fluid('hydrogen_chloride') * 25)
    .fluidOutputs(fluid('standard_clean_two') * 1000)
    .duration(100)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide'))
    .inputs(ore('dustSiliconDioxide') * 3)
    .fluidInputs(fluid('ultrapure_water') * 1000)
    .fluidOutputs(fluid('basic_cmp_slurry') * 1000)
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustTinyPotassiumHydroxide'))
    .inputs(ore('dustSiliconDioxide') * 30)
    .fluidInputs(fluid('ultrapure_water') * 10000)
    .fluidOutputs(fluid('basic_cmp_slurry') * 10000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustTinyPotassiumHydroxide'))
    .inputs(ore('dustSiliconDioxide') * 30)
    .fluidInputs(fluid('ultrapure_water') * 10000)
    .fluidOutputs(fluid('basic_cmp_slurry') * 10000)
    .duration(100)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

BLENDER.recipeBuilder()
    .fluidInputs(fluid('iron_iii_nitrate_solution'))
    .fluidInputs(fluid('ammonium_persulfate_solution') * 100)
    .fluidInputs(fluid('ultrapure_hydrogen_peroxide_solution') * 140)
    .fluidInputs(fluid('colloidal_silica') * 560)
    .fluidInputs(fluid('ultrapure_water') * 24199)
    .fluidOutputs(fluid('oxidative_cmp_slurry') * 25000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

for (wafer in wafers) {
    def cuttingRecipe = CUTTER.recipeBuilder()
        .inputs(wafer.getBoule())
        .outputs(wafer.getSeed())
        .chancedOutputLogic(ChancedOutputLogic.XOR)

    if (wafer.isSmall()) {
        cuttingRecipe.outputs(wafer.getRawWafer(34))
        cuttingRecipe.chancedOutput(wafer.getDust(), 5000, 0)
        cuttingRecipe.chancedOutput(wafer.getRawWafer(2), 10000, 0)
        cuttingRecipe.fluidInputs(fluid('ultrapure_water') * 500)
        cuttingRecipe.duration(4500).EUt(VA[MV])
    } else {
        cuttingRecipe.outputs(wafer.getRawWafer(64))
        cuttingRecipe.chancedOutput(wafer.getDust() * 4, 5000, 0)
        cuttingRecipe.chancedOutput(wafer.getRawWafer(8), 10000, 0)
        cuttingRecipe.fluidInputs(fluid('ultrapure_water') * 2000)
        cuttingRecipe.duration(9000).EUt(VA[HV])
        cuttingRecipe.cleanroom(CleanroomType.CLEANROOM)
    }

    cuttingRecipe.buildAndRegister()

    def polishingRecipe = POLISHING_MACHINE.recipeBuilder() // Lapping + CMP
        .inputs(wafer.getRawWafer())
        .outputs(wafer.getPolishedWafer())

    if (wafer.isSmall()) {
        polishingRecipe.fluidInputs(fluid('basic_cmp_slurry') * 50)
        polishingRecipe.duration(300).EUt(VA[MV])
    } else {
        polishingRecipe.fluidInputs(fluid('basic_cmp_slurry') * 200)
        polishingRecipe.duration(600).EUt(VA[HV])
        polishingRecipe.cleanroom(CleanroomType.CLEANROOM)
    }

    polishingRecipe.buildAndRegister()
    
    def treatmentRecipe = CHEMICAL_BATH.recipeBuilder()
        .inputs(wafer.getPolishedWafer())
        .outputs(wafer.getWafer())

    if (wafer.isSmall()) {
        treatmentRecipe.fluidInputs(fluid('standard_clean_one') * 50)
        treatmentRecipe.fluidInputs(fluid('hydrofluoric_acid') * 50)
        treatmentRecipe.fluidInputs(fluid('standard_clean_two') * 50)
        treatmentRecipe.fluidOutputs(fluid('acidic_wastewater') * 150)
        treatmentRecipe.duration(300).EUt(VA[MV])
    } else {
        treatmentRecipe.fluidInputs(fluid('standard_clean_one') * 200)
        treatmentRecipe.fluidInputs(fluid('hydrofluoric_acid') * 200)
        treatmentRecipe.fluidInputs(fluid('standard_clean_two') * 200)
        treatmentRecipe.fluidOutputs(fluid('acidic_wastewater') * 600)
        treatmentRecipe.duration(600).EUt(VA[HV])
    }

    treatmentRecipe.buildAndRegister()
}
