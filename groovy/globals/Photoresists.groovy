package globals
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

class Photoresists {

    public static class Photoresist {
        String fluidName
        int amountUsed
        int timeUsed

        Photoresist(String fluidName, int amountUsed, float timeUsed) {
            this.fluidName = fluidName
            this.amountUsed = amountUsed
            this.timeUsed = timeUsed
        }
    }

    public static final photoresists = [
        new Photoresist("novolacs", 50, 300),
        new Photoresist("hydrogen_silsesquioxane_photoresist", 25, 200),
        new Photoresist("pmma", 16, 150),
        new Photoresist("su_eight", 16, 50)
    ]

    static void generatePatterningRecipes(String input, String product, String mask, 
                                         int voltageTier, int timeMultiplier, int outputMultiplier, 
                                         int circ, boolean cleanroom) {
        for (photoresist in photoresists) {
            def uvLightBoxRecipe = UV_LIGHT_BOX.recipeBuilder()
                        .inputs(metaitem(input))
                        .notConsumable(metaitem(mask))
                        .fluidInputs(fluid(photoresist.fluidName) * photoresist.amountUsed)
                        .outputs(metaitem(product) * outputMultiplier)
                        .duration(photoresist.timeUsed * timeMultiplier)
                        .EUt(VA[voltageTier]);
            def laserEngraverRecipe = LASER_ENGRAVER.recipeBuilder()
                        .inputs(metaitem(input))
                        .circuitMeta(circ)
                        .fluidInputs(fluid(photoresist.fluidName) * (photoresist.amountUsed / 4))
                        .outputs(metaitem(product) * outputMultiplier)
                        .duration((int) (photoresist.timeUsed * timeMultiplier / 10))
                        .EUt(VA[voltageTier]);

            if (cleanroom) {
                uvLightBoxRecipe = uvLightBoxRecipe.cleanroom(CleanroomType.CLEANROOM);
                laserEngraverRecipe = laserEngraverRecipe.cleanroom(CleanroomType.CLEANROOM);
            }
            uvLightBoxRecipe.buildAndRegister();
            laserEngraverRecipe.buildAndRegister();
        }
    }
}
