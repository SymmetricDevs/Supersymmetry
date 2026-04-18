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
        'aluminium': new SputteringTarget("aluminium", MV, 0.025), // corresponds to ~300 hours irl
        'copper': new SputteringTarget("copper", HV, 0.025),
        'titanium': new SputteringTarget("titanium", HV, 0.00375),
        'nickel': new SputteringTarget("nickel", HV, 0.008),
        'silver': new SputteringTarget("silver", HV, 0.0375),
        'gold': new SputteringTarget("gold", MV, 0.0375),
        'palladium': new SputteringTarget("palladium", EV, 0.0375),
        'tungsten': new SputteringTarget("tungsten", EV, 0.00375),
        'antimony': new SputteringTarget("antimony", MV, 0.025),
        'silicon': new SputteringTarget("silicon", MV, 0.05),
        'platinum': new SputteringTarget("platinum", EV, 0.025),
        'tantalum': new SputteringTarget("tantalum", EV, 0.00375),
        'chromium': new SputteringTarget("chromium", MV, 0.01)
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
        RESISTANCE_FURNACE.recipeBuilder()
            .notConsumable(ore('springCupronickel'))
            .inputs(metaitem(input))
            .fluidInputs(fluid('forming_gas') * 100)
            .outputs(metaitem(product))
            .cleanroom(CleanroomType.CLEANROOM)
            .duration(duration)
            .EUt(VA[voltageTier])
            .buildAndRegister();
    }

    public static class cvdRecipe {
        Map inputs
        Map offgases
        int voltageTier
        int duration
        int molar_volume
        double moles

        cvdRecipe(Map in, Map out, int vt, int duration, int mv, double moles) {
            this.inputs = in
            this.offgases = out
            this.voltageTier = vt
            this.duration = duration
            this.molar_volume = mv
            this.moles = moles
        }

        def generateRecipe(String input, String product, int thickness) {
            def tmp = CVD.recipeBuilder()
                .inputs(metaitem(input));
            for (gas in this.inputs) {
                tmp.fluidInputs(fluid(gas.key) * (int) (gas.value * thickness / this.molar_volume))
            }
            for (offgas in this.offgases) {
                tmp.fluidOutputs(fluid(offgas.key) * (int) (offgas.value * thickness / this.molar_volume))
            }

            tmp.outputs(metaitem(product))
                .duration((int) (duration * thickness / this.molar_volume))
                .EUt(VA[this.voltageTier])
                .buildAndRegister()
        }
    }

    public static final cvdRecipes = [
        "silicon": new cvdRecipe(['silane' : 5, 'hydrogen' : 50], ['hydrogen' : 70], HV, 50, 12, 0.005), // LPCVD in H2 carrier gas
        "n_doped_silicon": new cvdRecipe(['silane' : 49, 'phosphine' : 1, 'hydrogen' : 501], ['hydrogen' : 700], HV, 500, 12, 0.05), // LPCVD in H2 carrier gas with 2% PH3 for n-type doping
        "silicon_germanium": new cvdRecipe(['germane' : 5, 'silane' : 5, 'hydrogen' : 100], ['hydrogen' : 140], EV, 200, 13, 0.01), // SiGe LPCVD in H2 carrier gas
        "silicon_nitride.silane": new cvdRecipe(['silane' : 15, 'ammonia' : 20, 'hydrogen' : 350], ['hydrogen' : 470], HV, 300, 44, 0.005), // Silane LPCVD in H2 carrier gas with NH3
        "silicon_dioxide.teos": new cvdRecipe(['tetraethyl_orthosilicate' : 5], ['diethyl_ether' : 10], EV, 100, 23, 0.005), // LPCVD via TEOS decomposition
        "silicon_dioxide.silane": new cvdRecipe(['silane' : 5, 'oxygen' : 20], ['steam' : 10], HV, 50, 23, 0.005),  // LPCVD in O2 carrier gas via silane oxidation
        "fluorosilicate_glass": new cvdRecipe(['silane' : 15, 'silicon_tetrafluoride' : 5, 'oxygen' : 90], ['corrosive_gas' : 100], HV, 100, 23, 0.01), // PECVD in O2 carrier gas, SiF4 as fluorine source
        "phosphosilicate_glass": new cvdRecipe(['silane' : 18, 'phosphine' : 2, 'oxygen' : 80], ['steam' : 39], HV, 200, 23, 0.02), // PECVD in O2 carrier gas, PH3 as phosphorus source
        "tungsten": new cvdRecipe(['tungsten_hexafluoride' : 5, 'hydrogen' : 50], ['corrosive_gas' : 50], EV, 100, 10, 0.005), //  LPCVD via WF6 reduction in H2 carrier gas

    ]

    static void generateChemicalVaporDepositionRecipe(String input, String product, int duration, String recipe) {
        def cvd_process = cvdRecipes[recipe]
        if (cvd_process == null) {
            log.infoMC("cvd recipe for " + recipe + " does not exist")
        } else {
            cvd_process.generateRecipe(input, product, duration)
        }
    }

    public static class aldRecipe extends cvdRecipe {
        Map purgeGas

        aldRecipe(Map in, Map out, Map purgeGas, int vt, int dur, int mv, double moles) {
            super(in, out, vt, dur, mv, moles)
            this.purgeGas = purgeGas
        }

        def generateRecipe(String input, String product, int thickness) {
            def tmp = ALD.recipeBuilder()
                .inputs(metaitem(input));
            for (gas in this.inputs) {
                tmp.fluidInputs(fluid(gas.key) * (int) (gas.value * thickness / this.molar_volume))
                for (purge in this.purgeGas) {
                    tmp.fluidInputs(fluid(purge.key) * (int) (purge.value * thickness / this.molar_volume))
                }
            }
            for (offgas in this.offgases) {
                tmp.fluidOutputs(fluid(offgas.key) * (int) (offgas.value * thickness / this.molar_volume))
            }

            tmp.outputs(metaitem(product))
                .duration((int) (duration * thickness / this.molar_volume))
                .EUt(VA[this.voltageTier])
                .buildAndRegister()
        }
    }

    public static final aldRecipes = [
        "titanium_nitride": new aldRecipe(['titanium_tetrachloride' : 3, 'ammonia' : 4], ['corrosive_gas' : 60], ['nitrogen' : 48], EV, 200, 12, 0.003), // ALD via TiCl4 and NH3 reaction
        "titanium_aluminide": new aldRecipe(['titanium_tetrachloride' : 5, 'trimethylaluminium' : 5], ['corrosive_gas' : 65], ['nitrogen' : 50], EV, 200, 12, 0.003), // ALD via TiCl4 and TMA reaction
        "hafnium_dioxide" : new aldRecipe(['tetrakis_dimethylamido_hafnium' : 5, 'water' : 10], ['dimethylamine' : 20, 'nitrogen' : 50], ['nitrogen' : 50], EV, 200, 12, 0.003) // ALD via Hf(NMe2)4 and H2O reaction
    ]

    // ALD
    static void generateAtomicLayerDepositionRecipe(String input, String product, int duration, String recipe) {
        def ald_process = aldRecipes[recipe]
        if (ald_process == null) {
            log.infoMC("ald recipe for " + recipe + " does not exist")
        } else {
            ald_process.generateRecipe(input, product, duration)
        }
    }
}