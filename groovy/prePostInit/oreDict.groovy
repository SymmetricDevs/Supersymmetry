import static globals.Globals.*

import supersymmetry.common.blocks.SuSyBlocks
import supersymmetry.common.blocks.SusyStoneVariantBlock
import gregtech.common.blocks.MetaBlocks
import gregtech.common.blocks.StoneVariantBlock

import net.minecraftforge.oredict.OreDictionary

//Prevent TechGuns from crashing servers
ore('ingotCopper').remove(item('techguns:itemshared', 79))
ore('ingotTin').remove(item('techguns:itemshared', 80))
ore('ingotSteel').remove(item('techguns:itemshared', 83))
ore('ingotTitanium').remove(item('techguns:itemshared', 85))

//Force stick to exist
ore('stickWood').add(item('minecraft:stick'))

//Light oredict
ore('gtLight').add(metaitem('incandescent_light'))
ore('gtLight').add(metaitem('halogen_light'))
ore('gtLight').add(metaitem('fluorescent_light'))
ore('gtLight').add(metaitem('led_light'))
ore('gtLight').add(metaitem('carbon_arc_lamp'))

//Dyes

ore('dyeBrown').add(metaitem('dustSienna'))
ore('dyeRed').add(metaitem('dustBurntSienna'))
ore('dyeRed').add(metaitem('dustCinnabar'))
ore('dyeYellow').add(metaitem('dustLeadChromate'))
ore('dyeGreen').add(metaitem('dustMalachite'))
ore('dyeBlue').add(metaitem('dustCobaltAluminate'))
ore('dyeWhite').add(metaitem('dustLeadNitrate'))
ore('dyeBlack').add(metaitem('dustCarbon'))
ore('dyeGreen').add(metaitem('cupric_hydrogen_arsenite_dust'))

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

//Saw oredict

ore('toolSaw').remove(item('notreepunching:saw/iron'))
ore('toolSaw').remove(item('notreepunching:saw/gold'))
ore('toolSaw').remove(item('notreepunching:saw/diamond'))

//No tree punching knife fixes

ore('toolKnife').remove(item('notreepunching:knife/iron'))
ore('toolKnife').remove(item('notreepunching:knife/gold'))
ore('toolKnife').remove(item('notreepunching:knife/diamond'))

//Manual Fixes
ore('stickWood').add(item('minecraft:stick'))
ore('blockConcrete').add(item('industrialrenewal:concrete'))
ore('stickIron').remove(item('industrialrenewal:stick_iron'))
ore('stickSteel').remove(item('industrialrenewal:stick_steel'))
ore('ingotSteel').remove(item('industrialrenewal:ingot_steel'))

//Misc Fixes

ore('dustCoal').remove(item('threng:material', 3))
ore('dustCinnabar').remove(item('tardis:cinnabar'))
ore('dustSaltpeter').remove(item('icbmclassic:saltpeter'))

//Hide ALL TechGuns recipes, they are impossible anyways since the machines needed are uncraftable
mods.jei.hideCategory('minecraft.brewing')
mods.jei.hideCategory('techguns.ammopress')
mods.jei.hideCategory('techguns.metalpress')
mods.jei.hideCategory('techguns.chemlab')
mods.jei.hideCategory('techguns.fabricator')
mods.jei.hideCategory('techguns.chargingstation')
mods.jei.hideCategory('techguns.reactionchamber')
mods.jei.hideCategory('techguns.oredrill')
mods.jei.hideCategory('techguns.blastfurnace')
mods.jei.hideCategory('techguns.grinder')
mods.jei.hideCategory('techguns.camobench')
mods.jei.hideCategory('techguns.upgradebench')

mods.jei.hideCategory('minecraft.anvil')

//NTP knives
/* //custom oredicts break with custom transforms, will report this bug today
def name_knifeNTP = [
    'notreepunching:knife/flint',
    'notreepunching:knife/iron',
    'notreepunching:knife/gold',
    'notreepunching:knife/diamond',
]
for (knife in name_knifeNTP) {
    ore('knifeNTP').add(item(knife))
}
*/