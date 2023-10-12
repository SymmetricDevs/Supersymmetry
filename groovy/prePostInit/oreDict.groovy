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

//Coke block

ore('blockCoalCoke').add(metaitem('blockCoke'))

//Circuit oredict

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

//Dyes

ore('dyeBrown').add(metaitem('dustSienna'))
ore('dyeRed').add(metaitem('dustBurntSienna'))
ore('dyeRed').add(metaitem('dustCinnabar'))
ore('dyeYellow').add(metaitem('dustLeadChromate'))
ore('dyeGreen').add(metaitem('dustMalachite'))
ore('dyeBlue').add(metaitem('dustCobaltAluminate'))
ore('dyeWhite').add(metaitem('dustLeadNitrate'))
ore('dyeBlack').add(metaitem('dustCarbon'))
ore('dyeGreen').add(metaitem('gregtechfoodoption:cupric_hydrogen_arsenite_dust'))

//Ore dict changes and unification
//DISABLED FOR NOW DUE TO SERVER CRASHES

/*
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

 */

//MANUAL OREDICT REMOVAL DUE TO THE ABOVE CODE CRASHING SERVERS

oreDictRemovals = [
        'sgcraft:naquadahingot': 'ingotNaquadahAlloy',
        'appliedenergistics2:material:2': 'dustCertusQuartz',
        'appliedenergistics2:material:3': 'dustNetherQuartz',
        'appliedenergistics2:material:8': 'dustFluix',
        'appliedenergistics2:material:46': 'dustEnderPearl',
        'appliedenergistics2:material:49': 'dustIron',
        'appliedenergistics2:material:51': 'dustGold',
        'portalgun:item_dust_ender_pearl': 'dustEnderPearl',
]

oreDictRemovals.each { key, val ->
    ore(val).remove(item(key))
    mods.jei.hide(item(key))
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

mods.jei.hideCategory('gregtech:combustion_generator')

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