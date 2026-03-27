package globals.semiconductors

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

class Deposition {

    // Thermal oxidation of silicon dioxide

    static void generateSiliconDioxideGrowthRecipe(String input, String output, int duration, boolean wet) {
        def growthRecipe = TUBE_FURNACE.recipeBuilder()
            .inputs(ore(input))
            .fluidInputs(fluid('oxygen') * 100)
            .outputs(metaitem(output))
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[HV])

        if (wet) {
            growthRecipe.fluidInputs(fluid('dense_steam') * 200)
            growthRecipe.fluidOutputs(fluid('hydrogen') * 200)
        }
        
        growthRecipe.buildAndRegister();
    }

    // Evaporation

    public static class EvaporationSource {
        String material
        int voltageTier

        EvaporationSource(String material, int voltageTier) {
            this.material = material
            this.voltageTier = voltageTier
        }

        def generateRecipe(String input, String product, int duration, boolean cleanroom) {
            def evaporationRecipe = EVAPORATION.recipeBuilder()
                .inputs(metaitem(input))
                .inputs(ore('nugget' + this.material.capitalize()))
                .outputs(metaitem(product))
                .duration(duration)
                .EUt(VA[this.voltageTier])
                
            if (cleanroom) {evaporationRecipe.cleanroom(CleanroomType.CLEANROOM)}
            evaporationRecipe.buildAndRegister();
        }
    }

    public static final evaporationSources = [
        new EvaporationSource("aluminium", MV),
        new EvaporationSource("gold_antimony", MV),
        new EvaporationSource("silver", HV),
    ]

    static void generateEvaporationRecipe(String input, String product, int duration, String targetMaterial, boolean cleanroom) {
        for (evaporationSource in evaporationSources) {
            if (evaporationSource.material == targetMaterial)
                evaporationSource.generateRecipe(input, product, duration, cleanroom)
        }
    }

    /* Sputtering
     Data for important applications
    // Ti-Ni/Pd-Ag metallization for n-doped substrates.
    Ti: 1-3 min
    Ni: 3-6 min
    Pd: 1-3 min
    Ag: 4-8 min
    // Contacts/interconnects
    Al: 10-25 min
    Cu: 
    Au:
    W:
    // Target lifetimes
    Ti/W: 2000+ hours
    Ni: 500-1000 hours
    Pd/Au/Ag: 100-300 hours
    Si: 100-200 hours
    Al/Cu: 100-500 hours*/

    public static class SputteringTarget {
        String targetMaterial
        int voltageTier
        float consumptionRate

        SputteringTarget(String targetMaterial, int voltageTier, float consumptionRate) {
            this.targetMaterial = targetMaterial
            this.voltageTier = voltageTier
            this.consumptionRate = consumptionRate // per tick of duration
        }

        def calculateReuseChance(int duration) {
            return Math.max(1, (10000 - ((int) (consumptionRate * duration))))
        }

        def generateRecipe(String input, String product, int duration) { // For standalone sputtering (no co-sputtering or sequential sputtering)
            def reuseChance = Math.max(1, (10000 - ((int) (consumptionRate * duration))))

            SPUTTERER.recipeBuilder()
                .inputs(metaitem(input))
                .inputs(metaitem('target.' + this.targetMaterial))
                .outputs(metaitem(product))
                .chancedOutput(metaitem('target.' + this.targetMaterial), reuseChance, 0)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(duration)
                .EUt(VA[this.voltageTier])
                .buildAndRegister();
        }
    }

    public static final sputteringTargets = [
        new SputteringTarget("aluminium", MV, 0.025),
        new SputteringTarget("copper", HV, 0.025),
        new SputteringTarget("titanium", HV, 0.00375),
        new SputteringTarget("nickel", HV, 0.008),
        new SputteringTarget("silver", HV, 0.0375),
        new SputteringTarget("gold", MV, 0.0375),
        new SputteringTarget("palladium", EV, 0.0375),
        new SputteringTarget("tungsten", EV, 0.00375),
        new SputteringTarget("antimony", MV, 0.025),
        new SputteringTarget("silicon", MV, 0.05)
    ]

    static void generateSputteringRecipe(String input, String product, int duration, String targetMaterial) {
        for (sputteringTarget in sputteringTargets) {
            if (sputteringTarget.targetMaterial == targetMaterial)
                sputteringTarget.generateRecipe(input, product, duration)
        }
    }

    // feed keys as material paired with duration, for co-sputtering and sequential sputtering
    static void generateSputteringRecipe(String input, String product, Map targetDurationMap) {
        int totalDuration = 0
        int power = 0

        def sputteringRecipe = SPUTTERER.recipeBuilder()
            .inputs(metaitem(input))
            .outputs(metaitem(product))
            .cleanroom(CleanroomType.CLEANROOM)
        
        for (pair in targetDurationMap) {
            String material = pair.key
            int duration = pair.value
            totalDuration += duration

            for (sputteringTarget in sputteringTargets) {
                if (sputteringTarget.targetMaterial == material) {
                    power = Math.max(power, VA[sputteringTarget.voltageTier])
                    sputteringRecipe.inputs(metaitem('target.' + material))
                    sputteringRecipe.chancedOutput(metaitem('target.' + material), sputteringTarget.calculateReuseChance(duration), 0)
                }
            }
        }

        sputteringRecipe.duration(totalDuration).EUt(power).buildAndRegister();
    }

    static void generateSinteringRecipe(String input, String product, int duration, int voltageTier) {
        SINTERING_OVEN.recipeBuilder()
            .notConsumable(ore('springCupronickel'))
            .inputs(metaitem(input))
            .fluidInputs(fluid('forming_gas') * 100)
            .outputs(metaitem(product))
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

    static void generateChemicalVaporDepositionRecipe(String input, String product, int duration, Map sources, Map offgases, int voltageTier) {
        def tmp = CVD.recipeBuilder()
            .inputs(metaitem(input));
        for (gas in sources) {
            tmp.fluidInputs(fluid(gas.key) * gas.value)
        }
        for (offgas in offgases) {
            tmp.fluidOutputs(fluid(offgas.key) * offgas.value)
        }

        tmp.outputs(metaitem(product))
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister()
    }

    // ALD; implement ts
    static void generateAtomicLayerDepositionRecipe(String input, String output, int duration, String depositMaterial) {
        // IMPLEMENT
    }
}

// CVD SECTION
