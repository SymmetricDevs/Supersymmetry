import static prePostInit.Recipemaps.*
import globals.Carbons

import static gregtech.api.GTValues.*
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

// Cementite steel: see IronChain.groovy

// Galvanized cementite steel

SOLIDIFIER.recipeBuilder()
    .inputs(ore('wireFineSteel') * 8)
    .fluidInputs(fluid('zinc') * 18)
    .outputs(metaitem('wireFineGalvanizedSteel') * 8)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Austenitic stainless steel

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

    def iron_sources = [
        'dustIron'               : 24,
        'dustMagnetite'          : 8,
        'dustBandedIron'         : 12,
        'dustIronIiiOxide'       : 60,
        'dustGraniticMineralSand': 8
    ]

    iron_sources.each { iron, amount ->
        ERF.recipeBuilder()
            .inputs(ore(iron) * amount)
            .inputs(ore('dustNickel') * 4)
            .inputs(ore('dustManganese'))
            .fluidOutputs(fluid('carburized_stainless_steel') * 5760)
            .blastFurnaceTemp(1400)
            .duration(3200)
            .EUt(VA[MV] * 2)
            .buildAndRegister()
    }

    for (highPurityCombustible in Carbons.highPurityCombustibles()) {
        ERF.recipeBuilder()
            .inputs(ore('dustSiliconDioxide') * 9)
            .inputs(ore('dustIron'))
            .inputs(ore(highPurityCombustible.name) * highPurityCombustible.equivalent(6))
            .outputs(metaitem('dustFerrosilicon') * 4)
            .fluidOutputs(fluid('carbon_monoxide') * 6000)
            .duration(200 * highPurityCombustible.duration)
            .blastFurnaceTemp(1400)
            .EUt(VA[LV] * 2)
            .buildAndRegister()

        ERF.recipeBuilder()
            .inputs(ore('dustSiliconDioxide') * 27)
            .inputs(ore('dustMagnetite'))
            .inputs(ore(highPurityCombustible.name) * 22)
            .outputs(metaitem('dustFerrosilicon') * 12)
            .fluidOutputs(fluid('carbon_monoxide') * 22000)
            .duration(600 * highPurityCombustible.duration)
            .blastFurnaceTemp(1400)
            .EUt(VA[LV] * 2)
            .buildAndRegister()
    }

    // AOD Process

    def gases = [
        'argon'   : [amount: 2000, duration: 1600],
        'nitrogen': [amount: 4000, duration: 2400]
    ]

    gases.each { gas, data ->
        ADVANCED_ARC_FURNACE.recipeBuilder()
            .fluidInputs(fluid('oxygen') * 8000)
            .fluidInputs(fluid(gas) * data.amount)
            .fluidInputs(fluid('carburized_stainless_steel') * 5760)
            .inputs(ore('dustFerrosilicon') * 2)
            .inputs(ore('dustFerrochromium') * 12)
            .inputs(ore('dustQuicklime'))
            .inputs(ore('dustFluorite'))
            .fluidOutputs(fluid('stainless_steel') * 5760)
            .duration(data.duration)
            .EUt(VA[MV])
            .buildAndRegister()
    }

// Manganese steel

MIXER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustSteel') * 14)
    .inputs(ore('dustManganese') * 2)
    .outputs(metaitem('dustManganeseSteel') * 16)
    .duration(100)
    .EUt(VA[LV] * 2)
    .buildAndRegister()

// Tungsten steel

ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust 
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(VA[IV])
    .duration(22000) 
    .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('molten.steel') * 8640) //equal to 60 Steel dust
    .fluidInputs(fluid('argon') * 6000)
    .inputs(ore('dustTungsten') * 8)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustVanadium') * 1)
    .inputs(ore('dustMolybdenum') * 2)  
    .fluidOutputs(fluid('molten.tungsten_steel') * 10656) // 74 ingot 
    .EUt(VA[IV])
    .duration(17000) 
    .buildAndRegister()
