import static globals.Globals.*

import supersymmetry.common.blocks.SuSyBlocks
import supersymmetry.common.blocks.SusyStoneVariantBlock
import gregtech.common.blocks.MetaBlocks
import gregtech.common.blocks.StoneVariantBlock

import net.minecraftforge.oredict.OreDictionary

//Ore dict changes and unification

def unify (ore, p) {
    def pos = p
    def foundMod = false

    for (def item : ore) {
        foundMod = ( item.getItem().getRegistryName().getNamespace() == Globals.mod_priority[pos] && item.getItem().getRegistryName().getNamespace() != 'xtones' )
    }

    if (foundMod) {
        for (def item : ore) {
            if (item.getItem().getRegistryName().getNamespace() != Globals.mod_priority[pos]) {
                ore.remove(item)
                //mods.jei.hide(item)
            }
        }
    } else if (pos < Globals.mod_priority.size() - 1) {
        pos++
        unify(ore, pos)
    }
}

def unify_oredicts(ore_list) {
    for ( def ore : ore_list) {
        if (ore) {
            if (ore.size() > 1) {
                unify(ore, 0)
            }
        }
    }
}

def dicts_ingots = [
    ore('ingotCopper'),
    ore('ingotTin')
]

unify_oredicts(dicts_ingots)

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

//No tree punching knife fixes

ore('toolKnife').remove(item('notreepunching:knife/iron'))
ore('toolKnife').remove(item('notreepunching:knife/gold'))
ore('toolKnife').remove(item('notreepunching:knife/diamond'))