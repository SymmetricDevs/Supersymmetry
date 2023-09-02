import static globals.Globals.*

import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

//REMOVE OLD RECIPES
// Stainless Steel Dust * 9
mods.gregtech.mixer.removeByInput(120, [metaitem('dustIron') * 6, metaitem('dustNickel'), metaitem('dustManganese'), metaitem('dustChrome'), metaitem('circuit.integrated').withNbt(["Configuration": 3])], null)
// Stainless Steel Dust * 9
mods.gregtech.mixer.removeByInput(120, [metaitem('dustIron') * 4, metaitem('dustInvar') * 3, metaitem('dustManganese'), metaitem('dustChrome'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Stainless Steel * 1296
mods.gregtech.alloy_blast_smelter.removeByInput(480, [metaitem('dustIron') * 6, metaitem('dustChrome'), metaitem('dustManganese'), metaitem('dustNickel'), metaitem('circuit.integrated').withNbt(["Configuration": 14])], [fluid('nitrogen') * 9000])
// Stainless Steel * 1296
mods.gregtech.alloy_blast_smelter.removeByInput(480, [metaitem('dustIron') * 6, metaitem('dustChrome'), metaitem('dustManganese'), metaitem('dustNickel'), metaitem('circuit.integrated').withNbt(["Configuration": 4])], null)


EBF = recipemap('electric_blast_furnace')
MIXER = recipemap('mixer')
ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')

EBF.recipeBuilder()
    .inputs(ore('dustIron') * 6)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustTinyManganese') * 2)
    .fluidOutputs(fluid('carburized_stainless_steel') * 1440)
        .blastFurnaceTemp(1400)
    .duration(800)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustMagnetite') * 14)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustTinyManganese') * 2)
    .fluidOutputs(fluid('carburized_stainless_steel') * 1440)
        .blastFurnaceTemp(1400)
    .duration(800)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustBandedIron') * 15)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustTinyManganese') * 2)
    .fluidOutputs(fluid('carburized_stainless_steel') * 1440)
         .blastFurnaceTemp(1400)
    .duration(800)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustIronIiiOxide') * 15)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustTinyManganese') * 2)
    .fluidOutputs(fluid('carburized_stainless_steel') * 1440)
         .blastFurnaceTemp(1400)
    .duration(800)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustGraniticMineralSand') * 30)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustTinyManganese') * 2)
    .fluidOutputs(fluid('carburized_stainless_steel') * 1440)
         .blastFurnaceTemp(1400)
    .duration(800)
    .EUt(Globals.voltAmps[2] * 2)
    .buildAndRegister()   

// VACUUM.recipeBuilder()
//     .fluidInputs(fluid('oxygen') * 2000)
//     .fluidInputs(fluid('carburized_stainless_steel') * 1440)
//     .inputs(ore('dustSmallFerrosilicon') * 2)
//    .inputs(ore('dustFerrochromium') * 3)
//    .inputs(ore('dustSmallQuicklime'))
//    .inputs(ore('dustSmallFluorite'))
//     .fluidOutputs(fluid('stainless_steel') * 1440)
//     .duration(400)
//     .EUt(Globals.voltAmps[3])
//     .buildAndRegister()

for (highPurityCombustible in Globals.highPurityCombustibles) {
    EBF.recipeBuilder()
    .inputs(ore('dustSiliconDioxide') * 3)
    .inputs(ore('dustIron') * 3)
    .inputs(ore(highPurityCombustible.name) * 2)
    .outputs(metaitem('dustFerrosilicon') * 4)
    .fluidOutputs(fluid('carbon_monoxide') * 2000)
    .blastFurnaceTemp(1400)
    .duration(200 * highPurityCombustible.duration)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()
}

MIXER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustIron'))
    .inputs(ore('dustChrome') * 2)
    .outputs(metaitem('dustFerrochromium') * 3)
    .duration(100)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

// AOD Process
ADVANCED_ARC_FURNACE.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 2000)
        .fluidInputs(fluid('argon') * 500)
        .fluidInputs(fluid('carburized_stainless_steel') * 1440)
        .inputs(ore('dustSmallFerrosilicon') * 2)
        .inputs(ore('dustFerrochromium') * 3)
        .inputs(ore('dustSmallQuicklime'))
        .inputs(ore('dustSmallFluorite'))
        .fluidOutputs(fluid('stainless_steel') * 1440)
        .duration(400)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 2000)
        .fluidInputs(fluid('nitrogen') * 1000)
        .fluidInputs(fluid('carburized_stainless_steel') * 1440)
        .inputs(ore('dustSmallFerrosilicon') * 2)
        .inputs(ore('dustFerrochromium') * 3)
        .inputs(ore('dustSmallQuicklime'))
        .inputs(ore('dustSmallFluorite'))
        .fluidOutputs(fluid('stainless_steel') * 1440)
        .duration(600)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

// Vanadiumsteel

ADVANCED_ARC_FURNACE.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 2000)
        .fluidInputs(fluid('argon') * 500)
        .fluidInputs(fluid('carburized_stainless_steel') * 1440)
        .inputs(ore('dustVanadium') * 2)
        .inputs(ore('dustFerrochromium') * 3)
        .inputs(ore('dustIron') * 6)
        .inputs(ore('dustSmallQuicklime'))
        .fluidOutputs(fluid('stainless_steel') * 2592)
        .duration(600)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()