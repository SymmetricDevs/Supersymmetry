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
            growthRecipe.fluidInputs(fluid('ultrapure_steam') * 200)
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
        'aluminium': new SputteringTarget("aluminium", MV, 0.025),
        'copper': new SputteringTarget("copper", HV, 0.025),
        'titanium': new SputteringTarget("titanium", HV, 0.00375),
        'nickel': new SputteringTarget("nickel", HV, 0.008),
        'silver': new SputteringTarget("silver", HV, 0.0375),
        'gold': new SputteringTarget("gold", MV, 0.0375),
        'palladium': new SputteringTarget("palladium", EV, 0.0375),
        'tungsten': new SputteringTarget("tungsten", EV, 0.00375),
        'antimony': new SputteringTarget("antimony", MV, 0.025),
        'silicon': new SputteringTarget("silicon", MV, 0.05),

        'platinum': new SputteringTarget("platinum", EV, 0.025), // all of these numbers are made up by me double check if its balanced pls
        'tantalum': new SputteringTarget("tantalum", EV, 0.03),
        'chromium': new SputteringTarget("chromium", MV, 0.05)
    ]

    static void generateSputteringRecipe(String input, String product, int duration, String targetMaterial) {
        sputteringTargets[targetMaterial].generateRecipe(input, product, duration)
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
            
            def sputteringTarget = sputteringTargets[material]
            if (sputteringTarget == null) {
                log.infoMC("Material " + material + " not defined as a sputtering target")
            }
            power = Math.max(power, VA[sputteringTarget.voltageTier])
            sputteringRecipe.inputs(metaitem('target.' + material))
            sputteringRecipe.chancedOutput(metaitem('target.' + material), sputteringTarget.calculateReuseChance(duration), 0)
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

    public static class CVDReagents {
        Map inputs
        Map offgases
        int voltageTier

        CVDReagents(Map in, Map out, Map vt) {
            inputs = in
            offgases = out
            voltageTier = vt
        }

        static void generateRecipe(String input, String product, int duration) {
            def tmp = CVD.recipeBuailder()
                .inputs(metaitem(input));
            for (gas in inputs) {
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
    }

    public static final cvdRecipes = [
        "silicon_nitride.silane": CVDReagents(['silane' : 100, 'ammonia' : 100], ['hydrogen' : 100, 'silicon_cvd_offgas' : 150], HV),
        "silicon": CVDReagents(['silane':100], ['hydrogen' : 50, 'silicon_cvd_offgas' : 150], HV),
        "silicon_dioxide.teos": CVDReagents(['tetraethoxysilane' : 25], ['diethyl_ether' : 50], EV),
        "silicon_germanium": CVDReagents(['germanium_tetrahydride':50, 'silane' : 50], ['hydrogen' : 100, 'silicon_cvd_offgas' : 100], EV),
        "tungsten": CVDReagents(['tungsten_hexafluoride' : 50, 'hydrogen' : 150], ['hydrogen_fluoride' : 300], EV),
        "fluorosilicate_glass": CVDReagents(['tetraethoxysilane' : 30, 'silicon_tetrafluoride' : 10], ['diethyl_ether' : 60], HV),
        "n_doped_silicon": CVDReagents(['silane' : 50, 'phosphine' : 2], ['hydrogen' : 75, 'silicon_cvd_offgas' : 125], HV),
        "phosphosilicate_glass": CVDReagents(['tetraethoxysilane' : 50, 'phosphine' : 10], ['hydrogen' : 50, 'silicon_cvd_offgas' : 100], HV),
        "silicon_dioxide.silane": CVDReagents(['silane' : 100, 'oxygen' : 100], ['steam' : 50, 'silicon_cvd_offgas' : 50], HV),
        "titanium_nitride": CVDReagents(['titanium_tetrachloride' : 30, 'ammonia' : 40], ['hydrogen_chloride' : 120], EV)
    ]

    static void generateChemicalVaporDepositionRecipe(String input, String product, int duration, String recipe) {
        def cvd_process = cvdRecipes[recipe]
        if (cvd_process == null) {
            log.infoMC("cvd recipe for " + recipe + " does not exist")
        } else {
            cvd_process.generateRecipe(input, product, duration)
        }
    }

    // ALD; implement ts
    static void generateAtomicLayerDepositionRecipe(String input, String output, int duration, String depositMaterial) {
        // IMPLEMENT
    }
}

// CVD SECTION
