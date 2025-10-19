import static prePostInit.Recipemaps.*
import globals.Carbons

import static gregtech.api.GTValues.*
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

//REMOVE OLD RECIPES

// Stainless Steel Dust * 9
mods.gregtech.mixer.removeByInput(120, [metaitem('dustIron') * 6, metaitem('dustNickel'), metaitem('dustManganese'), metaitem('dustChrome'), metaitem('circuit.integrated').withNbt(["Configuration": 3])], null)
mods.gregtech.blender.removeByInput(120, [metaitem('dustIron') * 6, metaitem('dustNickel'), metaitem('dustManganese'), metaitem('dustChrome'), metaitem('circuit.integrated').withNbt(["Configuration": 3])], null)
// Stainless Steel Dust * 9
mods.gregtech.mixer.removeByInput(120, [metaitem('dustIron') * 4, metaitem('dustInvar') * 3, metaitem('dustManganese'), metaitem('dustChrome'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
mods.gregtech.blender.removeByInput(120, [metaitem('dustIron') * 4, metaitem('dustInvar') * 3, metaitem('dustManganese'), metaitem('dustChrome'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Liquid Stainless Steel * 1296
mods.gregtech.advanced_arc_furnace.removeByInput(480, [metaitem('dustIron') * 6, metaitem('dustChrome'), metaitem('dustManganese'), metaitem('dustNickel'), metaitem('circuit.integrated').withNbt(['Configuration': 14])], [fluid('nitrogen') * 9000 * 9000, fluid('refractory_gunning_mixture') * 500])
// Liquid Stainless Steel * 1296
mods.gregtech.advanced_arc_furnace.removeByInput(480, [metaitem('dustIron') * 6, metaitem('dustChrome'), metaitem('dustManganese'), metaitem('dustNickel'), metaitem('circuit.integrated').withNbt(['Configuration': 4])], [fluid('refractory_gunning_mixture') * 800])

ERF.recipeBuilder()
    .inputs(ore('dustIron') * 24)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustManganese'))
    .fluidOutputs(fluid('carburized_stainless_steel') * 5760)
    .blastFurnaceTemp(1400)
    .duration(3200)
    .EUt(VA[MV] * 2)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustMagnetite') * 8)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustManganese'))
    .fluidOutputs(fluid('carburized_stainless_steel') * 5760)
    .blastFurnaceTemp(1400)
    .duration(3200)
    .EUt(VA[MV] * 2)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustBandedIron') * 12)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustManganese'))
    .fluidOutputs(fluid('carburized_stainless_steel') * 5760)
    .blastFurnaceTemp(1400)
    .duration(3200)
    .EUt(VA[MV] * 2)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustIronIiiOxide') * 60)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustManganese'))
    .fluidOutputs(fluid('carburized_stainless_steel') * 5760)
    .blastFurnaceTemp(1400)
    .duration(3200)
    .EUt(VA[MV] * 2)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustGraniticMineralSand') * 8)
    .inputs(ore('dustNickel') * 4)
    .inputs(ore('dustManganese'))
    .fluidOutputs(fluid('carburized_stainless_steel') * 5760)
    .blastFurnaceTemp(1400)
    .duration(3200)
    .EUt(VA[MV] * 2)
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
//     .EUt(VA[HV])
//     .buildAndRegister()

for (highPurityCombustible in Carbons.highPurityCombustibles()) {
    ERF.recipeBuilder()
    .inputs(ore('dustSiliconDioxide') * 9)
    .inputs(ore('dustIron'))
    .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(6))
    .outputs(metaitem('dustFerrosilicon') * 4)
    .fluidOutputs(fluid('carbon_monoxide') * 6000)
    .blastFurnaceTemp(1400)
    .duration(200 * highPurityCombustible.duration)
    .EUt(VA[LV] * 2)
    .buildAndRegister()
}

MIXER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustIron'))
    .inputs(ore('dustChrome') * 2)
    .outputs(metaitem('dustFerrochromium') * 3)
    .duration(100)
    .EUt(VA[LV] * 2)
    .buildAndRegister()

// AOD Process
ADVANCED_ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 8000)
    .fluidInputs(fluid('argon') * 2000)
    .fluidInputs(fluid('carburized_stainless_steel') * 5760)
    .inputs(ore('dustFerrosilicon') * 2)
    .inputs(ore('dustFerrochromium') * 12)
    .inputs(ore('dustQuicklime'))
    .inputs(ore('dustFluorite'))
    .fluidOutputs(fluid('stainless_steel') * 5760)
    .duration(1600)
    .EUt(VA[MV])
    .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 8000)
    .fluidInputs(fluid('nitrogen') * 4000)
    .fluidInputs(fluid('carburized_stainless_steel') * 5760)
    .inputs(ore('dustFerrosilicon') * 2)
    .inputs(ore('dustFerrochromium') * 12)
    .inputs(ore('dustQuicklime'))
    .inputs(ore('dustFluorite'))
    .fluidOutputs(fluid('stainless_steel') * 5760)
    .duration(2400)
    .EUt(VA[MV])
    .buildAndRegister()

// Vanadiumsteel
/*
ADVANCED_ARC_FURNACE.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 2000)
    .fluidInputs(fluid('argon') * 500)
    .fluidInputs(fluid('carburized_stainless_steel') * 1440)
    .inputs(ore('dustVanadium') * 2)
    .inputs(ore('dustFerrochromium') * 3)
    .inputs(ore('dustIron') * 6)
    .inputs(ore('dustSmallQuicklime'))
    .fluidOutputs(fluid('stainless_steel') * 2592) //this isn't vanadiumsteel?
    .duration(600)
    .EUt(VA[MV])
    .buildAndRegister()'
*/
