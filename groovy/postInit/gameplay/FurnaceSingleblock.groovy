import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

def heatingElements = [
        [material: metaitem('springCupronickel'), duration: 100],
        [material: metaitem('springKanthal'), duration: 75],
        [material: metaitem('springNichrome'), duration: 60]
]

def mapRange = { idIn, idOut, range ->
    range.collect { meta ->
        [input: item(idIn, meta), output: item(idOut, meta)]
    }
}

def nonMetals = [
        [input: item('minecraft:cobblestone'), output: item('minecraft:stone')],
        [input: item('minecraft:stone_slab', 3), output: item('minecraft:stone_slab')],
        [input: item('minecraft:stonebrick'), output: item('minecraft:stonebrick', 2)],
        [input: item('pyrotech:cobblestone', 0), output: item('minecraft:stone', 5)],
        [input: item('pyrotech:cobblestone', 1), output: item('minecraft:stone', 3)],
        [input: item('pyrotech:cobblestone', 2), output: item('minecraft:stone', 1)],
        [input: metaitem('dustSienna'), output: metaitem('dustBurntSienna')],
        [input: ore('blockClay'), output: item('minecraft:hardened_clay')],
        [input: item('minecraft:stained_hardened_clay'), output: item('minecraft:white_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 1), output: item('minecraft:orange_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 2), output: item('minecraft:magenta_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 3), output: item('minecraft:light_blue_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 4), output: item('minecraft:yellow_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 5), output: item('minecraft:lime_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 6), output: item('minecraft:pink_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 7), output: item('minecraft:gray_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 8), output: item('minecraft:silver_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 9), output: item('minecraft:cyan_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 10), output: item('minecraft:purple_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 11), output: item('minecraft:blue_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 12), output: item('minecraft:brown_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 13), output: item('minecraft:green_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 14), output: item('minecraft:red_glazed_terracotta')],
        [input: item('minecraft:stained_hardened_clay', 15), output: item('minecraft:black_glazed_terracotta')],
        [input: item('biomesoplenty:mudball'), output: item('biomesoplenty:mud_brick')],
        [input: item('biomesoplenty:mud'), output: item('minecraft:dirt')],
        [input: metaitem('gregtechfoodoption:brick.adobe'), output: metaitem('gregtechfoodoption:brick.adobe_fired')],
        [input: metaitem('compressed.clay'), output: item('minecraft:brick')],
        [input: metaitem('compressed.coke_clay'), output: metaitem('brick.coke')],
        [input: metaitem('compressed.fireclay'), output: metaitem('brick.fireclay')],
        [input: item('pyrotech:bucket_clay_unfired'), output: item('pyrotech:bucket_clay')],
        [input: item('minecraft:dye', 15), output: metaitem('gregtechfoodoption:bone_ash_dust')],
        [input: metaitem('dustLimestone'), output: metaitem('dustQuicklime')],
        [input: item('projectred-core:resource_item', 250), output: item('projectred-core:resource_item', 300)],
        [input: item('projectred-core:resource_item', 251), output: item('projectred-core:resource_item', 103)],
        [input: item('projectred-core:resource_item', 252), output: item('projectred-core:resource_item', 104)],
        [input: item('projectred-core:resource_item', 310), output: item('projectred-core:resource_item', 320)],
        [input: item('projectred-core:resource_item', 311), output: item('projectred-core:resource_item', 341)],
        [input: metaitem('ingotIronMagnetic'), output: item('minecraft:iron_ingot')],
        [input: metaitem('stickIronMagnetic'), output: metaitem('stickIron')],
        [input: metaitem('ingotSteelMagnetic'), output: metaitem('ingotSteel')],
        [input: metaitem('stickSteelMagnetic'), output: metaitem('stickSteel')],
        [input: metaitem('stickIron'), output: metaitem('hot_iron_rod')],
        [input: metaitem('stickSteel'), output: metaitem('hot_steel_rod')],
        [input: metaitem('plateSteel'), output: metaitem('hot_steel_plate')],
        [input: metaitem('brush.unfired'), output: metaitem('brush')],
        [input: item('minecraft:cactus'), output: item('minecraft:dye', 2)],
        [input: item('biomesoplenty:plant_1', 6), output: item('minecraft:dye', 2)],
        [input: metaitem('gregtechfoodoption:component.coconut'), output: metaitem('copra')],
        [input: metaitem('raw_electrode'), output: metaitem('carbon_electrode')],
        [input: metaitem('raw_carbon_crucible'), output: metaitem('carbon_crucible')],
        [input: metaitem('raw_clay_graphite_crucible'), output: metaitem('clay_graphite_crucible')],
        [input: ore('blockGreenCarbon'), output: ore('blockBakedCarbon').first()]
]

nonMetals += mapRange('susy:susy_stone_cobble', 'susy:susy_stone_smooth', 0..11)
nonMetals += mapRange('gregtech:stone_cobble', 'gregtech:stone_smooth', 0..5)
nonMetals += mapRange('gregtech:stone_smooth', 'gregtech:stone_polished', 1..5)

def metals = [
        [input: metaitem('dustTin'), output: fluid('tin')],
        [input: metaitem('dustLead'), output: fluid('lead')],
        [input: metaitem('dustZinc'), output: fluid('zinc')],
        [input: metaitem('dustAntimony'), output: fluid('antimony')],
        [input: metaitem('dustBismuth'), output: fluid('bismuth')],
        [input: metaitem('dustBatteryAlloy'), output: fluid('battery_alloy')],
        [input: metaitem('dustSolderingAlloy'), output: fluid('soldering_alloy')],
        [input: metaitem('dustCopper'), output: fluid('copper')],
        [input: metaitem('dustBronze'), output: fluid('bronze')],
        [input: metaitem('dustBrass'), output: fluid('brass')],
        [input: metaitem('dustCupronickel'), output: fluid('cupronickel')],
        [input: metaitem('dustPotin'), output: fluid('potin')],
        [input: metaitem('dustGold'), output: fluid('gold')],
        [input: metaitem('dustSilver'), output: fluid('silver')],
        [input: metaitem('dustAluminium'), output: fluid('aluminium')],
        [input: metaitem('dustAluminiumAlloy6061'), output: fluid('aluminium_alloy_6061')],
        [input: metaitem('dustAluminiumAlloy7075'), output: fluid('aluminium_alloy_7075')],
        [input: metaitem('dustCadmium'), output: fluid('cadmium')],
        [input: metaitem('dustIndium'), output: fluid('indium')],
        [input: metaitem('dustRedAlloy'), output: fluid('red_alloy')]
]

heatingElements.each { heatingElement ->
    nonMetals.each {nonMetal ->
        RESISTANCE_FURNACE.recipeBuilder()
                .notConsumable(heatingElement.material)
                .inputs(nonMetal.input)
                .outputs(nonMetal.output)
                .duration(heatingElement.duration)
                .EUt(4)
                .buildAndRegister()
    }

    metals.each {metal ->
        RESISTANCE_FURNACE.recipeBuilder()
                .notConsumable(metaitem('clay_graphite_crucible'))
                .notConsumable(heatingElement.material)
                .inputs(metal.input)
                .fluidOutputs(metal.output * 144)
                .duration(heatingElement.duration)
                .EUt(4)
                .buildAndRegister()
    }
}

// Acheson Process

ore('dustSilicaSand').add(
        metaitem('dustQuartzite'),
        metaitem('dustCertusQuartz'),
        metaitem('dustNetherQuartz'),
        metaitem('dustSiliconDioxide')
)

ore('carbonSource').add(
        metaitem('dustCharcoal'),
        metaitem('dustGreenCoke'),
        metaitem('dustCoke')
)

RESISTANCE_FURNACE.recipeBuilder()
        .notConsumable(metaitem('graphite_electrode'))
        .notConsumable(ore('dustSilicaSand') * 3)
        .notConsumable(ore('carbonSource') * 3)
        .inputs(ore('dustSilicaSand') * 6)
        .inputs(ore('carbonSource') * 6)
        .outputs(metaitem('dustSiliconCarbide') * 4)
        .fluidOutputs(fluid('carbon_monoxide') * 4000)
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

ore('insulatingCarbon').add(
        metaitem('dustCoke'),
        metaitem('dustHeatedGreenCoke'),
        metaitem('dustAnthracite')
)

RESISTANCE_FURNACE.recipeBuilder()
        .circuitMeta(1)
        .inputs(metaitem('carbon_electrode') * 2)
        .inputs(ore('insulatingCarbon') * 4)
        .notConsumable(ore('insulatingCarbon') * 16)
        .outputs(metaitem('graphite_electrode'))
        .duration(160)
        .EUt(VA[LV])
        .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
        .circuitMeta(2)
        .inputs(metaitem('carbon_electrode'))
        .inputs(ore('insulatingCarbon') * 4)
        .notConsumable(ore('insulatingCarbon') * 16)
        .notConsumable(metaitem('graphite_electrode'))
        .outputs(metaitem('graphite_electrode'))
        .duration(120)
        .EUt(VA[LV])
        .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
        .inputs(metaitem('carbon_crucible'))
        .inputs(ore('insulatingCarbon') * 4)
        .notConsumable(ore('insulatingCarbon') * 16)
        .notConsumable(metaitem('graphite_electrode'))
        .outputs(metaitem('crucible.graphite'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

RESISTANCE_FURNACE.recipeBuilder()
        .inputs(ore('blockBakedCarbon'))
        .inputs(ore('insulatingCarbon') * 4)
        .notConsumable(ore('insulatingCarbon') * 16)
        .notConsumable(metaitem('graphite_electrode'))
        .outputs(metaitem('blockGraphite'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

// Being nice

for (i = 1; i <= 8; i++) {
    crafting.addShapeless("susy:resistance_furnace." + Globals.voltageTiers[i] + "_convert", metaitem('susy:resistance_furnace.' + Globals.voltageTiers[i]), [
            metaitem('electric_furnace.' + Globals.voltageTiers[i])
    ])
}
