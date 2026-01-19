import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.chance.output.ChancedOutputLogic;

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

// Boules

// Doped mixtures

MIXER.recipeBuilder()
    .inputs(ore('dustTinyHighPurityBoron'))
    .inputs(ore('dustSilicon') * 64)
    .outputs(metaitem('dustHeavilyPDopedPolysilicon'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustTinyHighPurityPhosphorus'))
    .inputs(ore('dustSilicon') * 64)
    .outputs(metaitem('dustHeavilyNDopedPolysilicon'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Float zone refining process (Small pieces, needed MV+)

ZONE_REFINER.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(metaitem('induction_coil'))
    .fluidInputs(fluid('phosphine'))
    .inputs(ore('seed_crystal.silicon'))
    .inputs(ore('ingotHighPuritySilicon'))
    .outputs(metaitem('boule.silicon.fz.n_doped'))
    .duration(1200)
    .EUt(VA[MV])
    .buildAndRegister()

ZONE_REFINER.recipeBuilder()
    .circuitMeta(2)
    .notConsumable(metaitem('induction_coil'))
    .notConsumable(fluid('argon') * 8000)
    .fluidInputs(fluid('phosphine'))
    .inputs(ore('seed_crystal.silicon'))
    .inputs(ore('ingotHighPuritySilicon'))
    .outputs(metaitem('boule.silicon.fz.n_doped'))
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

ZONE_REFINER.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(metaitem('induction_coil'))
    .fluidInputs(fluid('phosphine') * 100)
    .inputs(ore('seed_crystal.silicon'))
    .inputs(ore('ingotHighPuritySilicon'))
    .outputs(metaitem('boule.silicon.fz.heavily_n_doped'))
    .duration(1200)
    .EUt(VA[MV])
    .buildAndRegister()

ZONE_REFINER.recipeBuilder()
    .circuitMeta(2)
    .notConsumable(metaitem('induction_coil'))
    .notConsumable(fluid('argon') * 8000)
    .fluidInputs(fluid('phosphine') * 100)
    .inputs(ore('seed_crystal.silicon'))
    .inputs(ore('ingotHighPuritySilicon'))
    .outputs(metaitem('boule.silicon.fz.heavily_n_doped'))
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

// Czochiralski Process (Large wafers, needed HV+)

CRYSTALLIZER.recipeBuilder()
    .notConsumable(fluid('argon') * 8000)
    .fluidInputs(fluid('high_purity_silicon') * 4608)
    .inputs(metaitem('seed_crystal.silicon'))
    .notConsumable(metaitem('crucible.quartz'))
    .outputs(metaitem('boule.silicon.cz'))
    .duration(6750)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .notConsumable(fluid('argon') * 8000)
    .fluidInputs(fluid('heavily_p_doped_polysilicon'))
    .fluidInputs(fluid('high_purity_silicon') * 4607)
    .inputs(metaitem('seed_crystal.silicon'))
    .notConsumable(metaitem('crucible.quartz'))
    .outputs(metaitem('boule.silicon.cz.p_doped'))
    .duration(6750)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

// Wafer preparation

public static class Wafer {
    String boule_name
    String wafer_name
    boolean small

    // Property getters

    def isSmall() {
        return small
    }

    // Itemstack getters
    
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

    Wafer(String boule_name, String wafer_name, boolean small) {
        this.boule_name = boule_name
        this.wafer_name = wafer_name
        this.small = small
    }
}

public static final wafers = [
    new Wafer('boule.silicon.cz', 'wafer.silicon', false),
    new Wafer('boule.silicon.cz.p_doped', 'wafer.silicon.p_doped', false),
    new Wafer('boule.silicon.cz.n_doped', 'wafer.silicon.n_doped', false),
    new Wafer('boule.silicon.fz.n_doped', 'wafer.small.silicon.n_doped', true),
    new Wafer('boule.silicon.fz.heavily_n_doped', 'wafer.small.silicon.heavily_n_doped', true)
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
    .fluidOutputs(fluid('standard_clean_two'))
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('ultrapure_water') * 980)
    .fluidInputs(fluid('hydrogen_peroxide') * 20)
    .fluidInputs(fluid('hydrogen_chloride') * 25)
    .fluidOutputs(fluid('standard_clean_two'))
    .duration(100)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide'))
    .inputs(ore('dustSiliconDioxide') * 3)
    .fluidInputs(fluid('ultrapure_water') * 1000)
    .fluidOutputs(fluid('silicon_dioxide_slurry') * 1000)
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustTinyPotassiumHydroxide'))
    .inputs(ore('dustSiliconDioxide') * 30)
    .fluidInputs(fluid('ultrapure_water') * 10000)
    .fluidOutputs(fluid('silicon_dioxide_slurry') * 10000)
    .duration(200)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustTinyPotassiumHydroxide'))
    .inputs(ore('dustSiliconDioxide') * 30)
    .fluidInputs(fluid('ultrapure_water') * 10000)
    .fluidOutputs(fluid('silicon_dioxide_slurry') * 10000)
    .duration(100)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

for (wafer in wafers) {
    def cuttingRecipe = CUTTER.recipeBuilder()
        .inputs(wafer.getBoule())
        .outputs(metaitem('seed_crystal.silicon'))
        .outputs(wafer.getRawWafer() * 14)
        .chancedOutput(wafer.getRawWafer() * 2, 5000, 0)
        .chancedOutput(metaitem('dustSilicon') * 2, 5000, 0)
        .chancedOutputLogic(ChancedOutputLogic.XOR)

    if (wafer.isSmall()) {
        cuttingRecipe.fluidInputs(fluid('ultrapure_water') * 500)
        cuttingRecipe.duration(4500).EUt(VA[MV])
    } else {
        cuttingRecipe.fluidInputs(fluid('ultrapure_water') * 2000)
        cuttingRecipe.duration(9000).EUt(VA[HV])
        cuttingRecipe.cleanroom(CleanroomType.CLEANROOM)
    }

    cuttingRecipe.buildAndRegister()

    def polishingRecipe = POLISHING_MACHINE.recipeBuilder() // Lapping + CMP
        .inputs(wafer.getRawWafer())
        .outputs(wafer.getPolishedWafer())

    if (wafer.isSmall()) {
        polishingRecipe.fluidInputs(fluid('silicon_dioxide_slurry') * 50)
        polishingRecipe.duration(300).EUt(VA[MV])
    } else {
        polishingRecipe.fluidInputs(fluid('silicon_dioxide_slurry') * 200)
        polishingRecipe.duration(600).EUt(VA[HV])
        polishingRecipe.cleanroom(CleanroomType.CLEANROOM)
    }

    polishingRecipe.buildAndRegister()
    
    def treatmentRecipe = CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('wafer.silicon.raw'))
        .outputs(metaitem('wafer.silicon.treated'))
        .buildAndRegister()

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
}