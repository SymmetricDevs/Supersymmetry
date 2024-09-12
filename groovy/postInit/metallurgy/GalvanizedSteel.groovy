

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;


FLUID_SOLIDIFIER = recipemap('fluid_solidifier')

FLUID_SOLIDIFIER.recipeBuilder()
    .inputs(ore('wireFineSteel') * 8)
    .fluidInputs(fluid('zinc') * 18)
    .outputs(metaitem('wireFineGalvanizedSteel') * 8)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()