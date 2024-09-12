import globals.Globals
import static globals.CarbonGlobals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;


FLUID_SOLIDIFIER = recipemap('fluid_solidifier')

FLUID_SOLIDIFIER.recipeBuilder()
    .inputs(ore('wireFineSteel') * 64)
    .fluidInputs(fluid('zinc') * 144)
    .outputs(metaitem('wireFineGalvanizedSteel') * 64)
    .duration(800)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()