package prePostInit;

import static globals.Globals.*

import supersymmetry.common.blocks.SuSyBlocks
import supersymmetry.common.blocks.SusyStoneVariantBlock
import gregtech.common.blocks.MetaBlocks
import gregtech.common.blocks.StoneVariantBlock

import net.minecraftforge.oredict.OreDictionary

// Light oredict
ore('gtLight').add(metaitem('incandescent_light'))
ore('gtLight').add(metaitem('halogen_light'))
ore('gtLight').add(metaitem('fluorescent_light'))
ore('gtLight').add(metaitem('led_light'))
ore('gtLight').add(metaitem('lamp.mercury.hp'))

// Circuit oredict
ore('circuitZpm').add(metaitem('circuit.gooware_processor'))

ore('circuitUv').add(metaitem('circuit.gooware_assembly'))
ore('circuitUv').add(metaitem('circuit.optical_processor'))

ore('circuitUhv').add(metaitem('circuit.gooware_computer'))
ore('circuitUhv').add(metaitem('circuit.optical_assembly'))
ore('circuitUhv').add(metaitem('circuit.spintronic_processor'))

ore('circuitUev').add(metaitem('circuit.gooware_mainframe'))
ore('circuitUev').add(metaitem('circuit.optical_computer'))
ore('circuitUev').add(metaitem('circuit.spintronic_assembly'))
ore('circuitUev').add(metaitem('circuit.cosmic_processor'))

ore('circuitUiv').add(metaitem('circuit.optical_mainframe'))
ore('circuitUiv').add(metaitem('circuit.spintronic_computer'))
ore('circuitUiv').add(metaitem('circuit.cosmic_assembly'))
ore('circuitUiv').add(metaitem('circuit.supracausal_processor'))

ore('circuitUxv').add(metaitem('circuit.spintronic_mainframe'))
ore('circuitUxv').add(metaitem('circuit.cosmic_computer'))
ore('circuitUxv').add(metaitem('circuit.supracausal_assembly'))

ore('circuitOpv').add(metaitem('circuit.cosmic_mainframe'))
ore('circuitOpv').add(metaitem('circuit.supracausal_computer'))

ore('circuitMax').add(metaitem('circuit.supracausal_mainframe'))

ore('circuitUlv').add(metaitem('circuit.suprachronal.ulv'))
ore('circuitLv').add(metaitem('circuit.suprachronal.lv'))
ore('circuitMv').add(metaitem('circuit.suprachronal.mv'))
ore('circuitHv').add(metaitem('circuit.suprachronal.hv'))
ore('circuitEv').add(metaitem('circuit.suprachronal.ev'))
ore('circuitIv').add(metaitem('circuit.suprachronal.iv'))
ore('circuitLuv').add(metaitem('circuit.suprachronal.luv'))
ore('circuitZpm').add(metaitem('circuit.suprachronal.zpm'))
ore('circuitUv').add(metaitem('circuit.suprachronal.uv'))
ore('circuitUhv').add(metaitem('circuit.suprachronal.uhv'))
ore('circuitUev').add(metaitem('circuit.suprachronal.uev'))
ore('circuitUiv').add(metaitem('circuit.suprachronal.uiv'))
ore('circuitUxv').add(metaitem('circuit.suprachronal.uxv'))
ore('circuitOpv').add(metaitem('circuit.suprachronal.opv'))
ore('circuitMax').add(metaitem('circuit.suprachronal.max'))

// Dyes
ore('dyeBrown').add(metaitem('dustSienna'))
ore('dyeRed').add(metaitem('dustBurntSienna'))
ore('dyeRed').add(metaitem('dustCinnabar'))
ore('dyeYellow').add(metaitem('dustLeadChromate'))
ore('dyeGreen').add(metaitem('dustMalachite'))
ore('dyeBlue').add(metaitem('dustCobaltAluminate'))
ore('dyeWhite').add(metaitem('dustLeadNitrate'))
ore('dyeWhite').add(metaitem('dustTitaniumDioxide'))
ore('dyeBlack').add(metaitem('dustCarbon'))
ore('dyeGreen').add(metaitem('gregtechfoodoption:cupric_hydrogen_arsenite_dust'))
ore('dyeWhite').add(metaitem('dustTitaniumDioxide'))

// Concrete
ore('dustCement').add(metaitem('cement.dust'))
ore('blockConcrete').add(item('industrialrenewal:concrete'))
ore('blockConcrete').add(item('engineersdecor:rebar_concrete'))
ore('blockConcrete').add(item('engineersdecor:rebar_concrete_tile'))
ore('blockConcrete').add(item('engineersdecor:gas_concrete'))
ore('blockConcrete').add(item('icbmclassic:concrete'))

// Nitrogen Nutrients
ore('nutrientNitrogen').add(metaitem('dustAmmoniumChloride'))
ore('nutrientNitrogen').add(metaitem('dustAmmoniumNitrate'))
ore('nutrientNitrogen').add(metaitem('dustAmmoniumSulfate'))
ore('nutrientNitrogen').add(metaitem('dustUrea'))

// Potassium Nutrients
ore('nutrientPotassium').add(metaitem('dustAsh'))
ore('nutrientPotassium').add(metaitem('dustCharcoal'))
ore('nutrientPotassium').add(metaitem('dustRockSalt'))
ore('nutrientPotassium').add(metaitem('dustPotassiumCarbonate'))
ore('nutrientPotassium').add(metaitem('dustPotash'))

// Phosphorous Nutrients
ore('nutrientPhosphorous').add(metaitem('dustChlorapatite'))
ore('nutrientPhosphorous').add(metaitem('dustHydroxyapatite'))
ore('nutrientPhosphorous').add(metaitem('dustFluorapatite'))
ore('nutrientPhosphorous').add(metaitem('dustTricalciumPhosphate'))
ore('nutrientPhosphorous').add(metaitem('dustPhosphorus'))
ore('nutrientPhosphorous').add(metaitem('dustPhosphorite'))
ore('nutrientPhosphorous').add(item('minecraft:dye', 15))

// Uranium Isotopes
ore('dustIsotopesUranium').add(metaitem('dustNaturalUranium'))
ore('dustIsotopesUranium').add(metaitem('dustUranium235'))
ore('dustIsotopesUranium').add(metaitem('dustLeu235'))
ore('dustIsotopesUranium').add(metaitem('dustHaleu235'))
ore('dustIsotopesUranium').add(metaitem('dustHeu235'))
ore('dustIsotopesUranium').add(metaitem('dustWeaponsGradeUranium'))
ore('dustIsotopesUranium').add(metaitem('dustUranium'))

// Flocculants
ore('dustFlocculant').add(metaitem('dustPotassiumAlum'))
ore('dustFlocculant').add(metaitem('dustSodiumAlum'))
ore('dustFlocculant').add(metaitem('dustAluminiumSulfate'))

// Gears/Cogs
ore('gearDiamond').add(item('pyrotech:cog_diamond'))
ore('gearGold').add(item('pyrotech:cog_gold'))
ore('gearIron').add(item('pyrotech:cog_iron'))
ore('gearStone').add(item('pyrotech:cog_stone'))

// Zinc Residues
ore('dustZincResidues').add(metaitem('dustZincLeachResidue'))
ore('dustZincResidues').add(metaitem('dustZincHydrochloricLeachResidue'))

// Electrolyte Fruit
ore('electrolyteFruit').add(metaitem('gregtechfoodoption:food.orange'))
ore('electrolyteFruit').add(metaitem('gregtechfoodoption:food.lemon'))
ore('electrolyteFruit').add(metaitem('gregtechfoodoption:food.lime'))

// Add ore dict to non traditional ore blocks
ore('oreCaliche').add(item('susy:resource_block:1'))

ore('oreNonMarineEvaporiteDeposit').add(item('susy:resource_block:2'))
ore('oreHalideEvaporiteDeposit').add(item('susy:resource_block:3'))
ore('oreSulfateEvaporiteDeposit').add(item('susy:resource_block:4'))
ore('oreCarbonateEvaporiteDeposit').add(item('susy:resource_block:5'))

ore('oreAlluvialMonaziteDeposit').add(item('susy:resource_block:6'))
ore('oreAlluvialEuxeniteDeposit').add(item('susy:resource_block:8'))
ore('orePlatinumPlacerDeposit').add(item('susy:resource_block:10'))
ore('oreAlluvialGoldDeposit').add(item('susy:resource_block:11'))
ore('orePhosphoriteDeposit').add(item('susy:resource_block:12'))
ore('orePotashDeposit').add(item('susy:resource_block:13'))

ore('oreCoalDeposit').add(item('susy:resource_block:15'))
ore('oreNativeCopperDeposit').add(item('susy:resource_block_1:0'))
ore('oreAnthraciteDeposit').add(item('susy:resource_block_1:1'))
ore('oreLigniteDeposit').add(item('susy:resource_block_1:2'))

ore('oreOrthomagmaticDeposit').add(item('susy:deposit_block:0'))
ore('oreMetamorphicDeposit').add(item('susy:deposit_block:1'))
ore('oreSedimentaryDeposit').add(item('susy:deposit_block:2'))
ore('oreHydrothermalDeposit').add(item('susy:deposit_block:3'))
ore('oreAlluvialDeposit').add(item('susy:deposit_block:4'))
ore('oreMagmaticHydrothermalDeposit').add(item('susy:deposit_block:5'))

// Bauxite the special little snowflake
ore('oreBauxite').add(item('susy:resource_block:0'))
ore('oreBauxite').remove(item('gregtech:ore_bauxite_0'))

// Crushed Bauxite Ore * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('susy:resource_block')], null)
// Crushed Bauxite Ore * 2
mods.gregtech.macerator.removeByInput(2, [item('susy:resource_block')], null)

for (i in 0..2) {
    mods.jei.ingredient.yeet(item('gregtech:ore_bauxite_0', i))
}

// OreDict Removal + Hide from JEI

oreDictRemovals = [
        'sgcraft:naquadahingot': 'ingotNaquadahAlloy',
        'appliedenergistics2:material:2': 'dustCertusQuartz',
        'appliedenergistics2:material:3': 'dustNetherQuartz',
        'appliedenergistics2:material:8': 'dustFluix',
        'appliedenergistics2:material:46': 'dustEnderPearl',
        'appliedenergistics2:material:49': 'dustIron',
        'appliedenergistics2:material:51': 'dustGold',
        'portalgun:item_dust_ender_pearl': 'dustEnderPearl',
        'techguns:itemshared:79': 'ingotCopper',
        'techguns:itemshared:80': 'ingotTin',
        'techguns:itemshared:83': 'ingotSteel',
        'techguns:itemshared:85': 'ingotTitanium',
        'biomesoplenty:gem:5': 'gemMalachite',
        'biomesoplenty:gem:1': 'gemRuby',
        'biomesoplenty:gem:6': 'gemSapphire',
        'biomesoplenty:gem_block:5': 'blockMalachite',
        'biomesoplenty:gem_block:1': 'blockRuby',
        'biomesoplenty:gem_block:6': 'blockSapphire',
        'biomesoplenty:gem_ore:5': 'oreMalachite',
        'biomesoplenty:gem_ore:1': 'oreRuby',
        'biomesoplenty:gem_ore:6': 'oreSapphire',
        'minecraft:lapis_ore': 'oreLapis',
        'minecraft:redstone_ore': 'oreRedstone',
        'industrialrenewal:stick_iron': 'stickIron',
        'industrialrenewal:stick_steel': 'stickSteel',
        'industrialrenewal:ingot_steel': 'ingotSteel',
        'pyrotech:material:27': 'stickStone',
        'microblockcbe:stone_rod': 'stickStone',
        'threng:material:3': 'dustCoal',
        'tardis:cinnabar': 'dustCinnabar',
        'icbmclassic:saltpeter': 'dustSaltpeter',
        'gaspunk:sulfur': 'dustSulfur',
        'icbmclassic:sulfurdust': 'dustSulfur',
        'gregtechfoodoption:gtfo_oredict_item:1138': 'dustSodiumCyanide',
]

oreDictRemovals.each { key, val ->
    ore(val).remove(item(key))
    mods.jei.ingredient.yeet(item(key))
}

susycobble = SuSyBlocks.SUSY_STONE_BLOCKS.get(SusyStoneVariantBlock.StoneVariant.COBBLE)

for (type in SusyStoneVariantBlock.StoneType.values()) {
    variant = susycobble.getItemVariant(type)

    OreDictionary.registerOre('cobblestone', variant)
}

gtcobble = MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.COBBLE)

for (type in StoneVariantBlock.StoneType.values()) {
    variant = gtcobble.getItemVariant(type)

    OreDictionary.registerOre('cobblestone', variant)
}

susysmooth = SuSyBlocks.SUSY_STONE_BLOCKS.get(SusyStoneVariantBlock.StoneVariant.SMOOTH)

for (type in SusyStoneVariantBlock.StoneType.values()) {
    variant = susysmooth.getItemVariant(type)

    OreDictionary.registerOre('stone', variant)
}

gtsmooth = MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH)

for (type in StoneVariantBlock.StoneType.values()) {
    variant = gtsmooth.getItemVariant(type)

    OreDictionary.registerOre('stone', variant)
}

// Misc Fixes
ore('stickWood').add(item('minecraft:stick'))
ore('blockCoalCoke').add(metaitem('blockCoke'))
ore('blockCoalCoke').add(item('pyrotech:coal_coke_block'))
ore('foilMylar').add(metaitem('mylar'))
ore('blockConcrete').remove(item('susy:susy_stone_smooth:9'))
ore('stone').remove(item('susy:susy_stone_smooth:9'))
ore('cobblestone').remove(item('susy:susy_stone_cobble:9'))

//Dust oredicting
elementList.each { element ->
    String anyPurityDust = "dustAnyPurity${element}"
    String highPurityDust = "dustHighPurity${element}"
    String normalDust = "dust${element}"

    String anyPuritySmallDust = "dustAnyPurity${element}"
    String highPuritySmallDust = "dustHighPurity${element}"
    String normalSmallDust = "dust${element}"

    String anyPurityTinyDust = "dustAnyPurity${element}"
    String highPurityTinyDust = "dustHighPurity${element}"
    String normalTinyDust = "dust${element}"

    // Add both high purity and normal dust to the anyPurity dust ore dictionary entry
    ore(anyPurityDust).add(metaitem(highPurityDust))
    ore(anyPurityDust).add(metaitem(normalDust))

    ore(anyPuritySmallDust).add(metaitem(highPuritySmallDust))
    ore(anyPuritySmallDust).add(metaitem(normalSmallDust))

    ore(anyPurityTinyDust).add(metaitem(highPurityTinyDust))
    ore(anyPurityTinyDust).add(metaitem(normalTinyDust))
}
