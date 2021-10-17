#loader gregtech

import mods.gtadditions.recipe.Utils;
import mods.contenttweaker.Fluid;
import mods.contenttweaker.VanillaFactory;
import mods.gregtech.material.MaterialRegistry;

val ManganesePhosphide = MaterialRegistry.createIngotMaterial(660, "manganese_phosphide", 0xce4c01, "shiny", 1, [<material:manganese>*1, <material:phosphorus>*1], 1.0, 0, 1200);
ManganesePhosphide.setCableProperties(32, 2, 4);
val LVSuperconductor = MaterialRegistry.createIngotMaterial(661, "lv_superconductor", 0xce4c01, "shiny", 1, [<material:manganese>*1, <material:phosphorus>*1], 1.0, 0, 1200);
LVSuperconductor.setCableProperties(32, 2, 0);