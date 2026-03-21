package globals.semiconductors
import globals.Globals
import globals.semiconductors.Etching

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

class Doping {

    // Ion implantation
    public static class IonSource {
        String sourceName
        String ionName

        IonSource(String sourceName, String ionName) {
            this.sourceName = sourceName
            this.ionName = ionName
        }

        def generateRecipe(String input, String product, int duration) {
            ION_IMPLANTER.recipeBuilder()
                .inputs(metaitem(input))
                .fluidInputs(fluid(this.sourceName) * 50)
                .outputs(metaitem(product))
                .duration(duration)
                .cleanroom(CleanroomType.CLEANROOM)
                .EUt(VA[HV])
                .buildAndRegister();
        }
    }

    public static final ionSources = [
        new IonSource("boron_trifluoride", "boron"),
        new IonSource("phosphine", "phosphorus"),
        new IonSource("arsine", "arsenic"),
        new IonSource("purified_antimony_trioxide", "antimony")
    ]

    static void generateIonImplantationRecipes(String input, String product, int duration, String sourceName) {
        for (ionSource in ionSources) {
            if (ionSource.sourceName == sourceName)
                ionSource.generateRecipe(input, product, duration)
        }
    }

    // Diffusion doping

    static void generateBoronDiffusionDopingRecipes(String input, String product, int duration) {
        RESISTANCE_FURNACE.recipeBuilder() // BCl3 gaseous diffusion doping
            .notConsumable(metaitem('tube.quartz'))
            .inputs(metaitem(input))
            .fluidInputs(fluid('boron_trichloride') * 50)
            .fluidInputs(fluid('oxygen') * 300)
            .fluidInputs(fluid('nitrogen') * 3000)
            .outputs(metaitem(input + '.bsg'))
            .fluidOutputs(fluid('corrosive_gas') * 450)
            .duration(duration)
            .cleanroom(CleanroomType.CLEANROOM)
            .EUt(VA[HV])
            .buildAndRegister();

        // Remove BSG
        Etching.generateEtchingRecipes(input + '.bsg', product, 'silicon_dioxide', LV, 1, false)
    }

    static void generatePhosphorusDiffusionDopingRecipes(String input, String product, int duration) {
        RESISTANCE_FURNACE.recipeBuilder() // POCl3 gaseous diffusion doping
            .notConsumable(metaitem('tube.quartz'))
            .inputs(metaitem(input))
            .fluidInputs(fluid('phosphoryl_chloride') * 50)
            .fluidInputs(fluid('oxygen') * 300)
            .fluidInputs(fluid('nitrogen') * 3000)
            .outputs(metaitem(input + '.psg'))
            .fluidOutputs(fluid('corrosive_gas') * 450)
            .duration(duration)
            .cleanroom(CleanroomType.CLEANROOM)
            .EUt(VA[HV])
            .buildAndRegister();

        // Remove PSG
        Etching.generateEtchingRecipes(input + '.psg', product, 'silicon_dioxide', LV, 1, false)
    }

    static void generateDriveInRecipe(String input, String product, int duration) {
        RESISTANCE_FURNACE.recipeBuilder() // Drive-in of diffusant
            .notConsumable(ore('springCupronickel'))
            .fluidInputs(fluid('nitrogen') * 100)
            .inputs(metaitem(input))
            .outputs(metaitem(product))
            .duration(duration)
            .cleanroom(CleanroomType.CLEANROOM)
            .EUt(VA[HV])
            .buildAndRegister();
    }

    
}
