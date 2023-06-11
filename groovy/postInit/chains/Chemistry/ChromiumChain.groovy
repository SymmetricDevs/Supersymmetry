import static globals.Globals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;


ARC_FURNACE = recipemap('arc_furnace')

ARC_FURNACE.recipeBuilder()
.inputs(ore('dustChromite') * 7)
.inputs(ore('dustCarbon') * 4)
.outputs(ore('dustFerrochromium').first() * 3)
.fluidOutputs(fluid('carbon_monoxide') * 4000)
.duration(200)
.EUt(Globals.voltAmps[2])
.buildAndRegister()

