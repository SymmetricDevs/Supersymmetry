import static globals.Globals.*

import supersymmetry.common.blocks.SuSyBlocks
import supersymmetry.common.blocks.SusyStoneVariantBlock
import gregtech.common.blocks.MetaBlocks
import gregtech.common.blocks.StoneVariantBlock

import net.minecraftforge.oredict.OreDictionary

//Ore dict changes and unification

def get_ore_dicts(List<String> list) {
    def out = []
    for (name in list) {
        out.add(ore(name))
    }
    return out
}

def unify (ore, p) {
    def pos = p
    def foundMod = false

    for (item in ore) {
        String namespace = item.getItem().getRegistryName().getNamespace()
        if (namespace == Globals.mod_priority[pos]) {
            foundMod = true
            break
        }
    }

    if (foundMod) {
        for (int i = 0; i < ore.size(); i++) {
            ItemStack item = ore.getAt(i)
            if (item.getItem().getRegistryName().getNamespace() != Globals.mod_priority[pos]) {
                ore.remove(item)
                mods.jei.hide(item)
            }
        }
    } else if (pos < Globals.mod_priority.size() - 1) {
        pos++
        unify(ore, pos)
    }
}

def unify_oredicts(ore_list) {
    for (ore in ore_list) {
        if (ore) {
            if (ore.size() > 1) {
                unify(ore, 0)
            }
        }
    }
}

def dicts_ingots = get_ore_dicts(ore('ingot*').getMatchingOreDictionaries())
def dicts_plates = get_ore_dicts(ore('plate*').getMatchingOreDictionaries())
def dicts_sticks = get_ore_dicts(ore('stick*').getMatchingOreDictionaries())
def dicts_blocks = get_ore_dicts(ore('block*').getMatchingOreDictionaries())
def dicts_dusts = get_ore_dicts(ore('dust*').getMatchingOreDictionaries())
def dicts_gears = get_ore_dicts(ore('gear*').getMatchingOreDictionaries())

unify_oredicts(dicts_ingots)
unify_oredicts(dicts_plates)
unify_oredicts(dicts_sticks)
unify_oredicts(dicts_blocks)
unify_oredicts(dicts_dusts)
unify_oredicts(dicts_gears)

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

//Manual Fixes

ore('blockConcrete').add(item('industrialrenewal:concrete'))

ore('stickIron').remove(item('industrialrenewal:stick_iron'))
ore('stickSteel').remove(item('industrialrenewal:stick_steel'))
ore('ingotSteel').remove(item('industrialrenewal:ingot_steel'))

//Misc Fixes

ore('dustCoal').remove(item('threng:material', 3))
ore('dustCinnabar').remove(item('tardis:cinnabar'))
ore('dustSaltpeter').remove(item('icbmclassic:saltpeter'))
