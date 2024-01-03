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

//Add non traditional ore blocks to scanner

ore('oreBauxite').add(item('susy:resource_block:0'))
ore('oreSulfur').add(item('susy:resource_blocK:14'))

ore('oreOrthomagmaticDeposit').add(item('susy:deposit_block:0'))
ore('oreMetamorphicDeposit').add(item('susy:deposit_block:1'))
ore('oreSedimentaryDeposit').add(item('susy:deposit_block:2'))
ore('oreHydrothermalDeposit').add(item('susy:deposit_block:3'))
ore('oreAlluvialDeposit').add(item('susy:deposit_block:4'))
ore('oreMagmaticHydrothermalDeposit').add(item('susy:deposit_block:5'))

//Concrete

ore('dustCement').add(metaitem('cement.dust'))
ore('blockConcrete').add(item('industrialrenewal:concrete'))
ore('blockConcrete').add(item('engineersdecor:rebar_concrete'))
ore('blockConcrete').add(item('engineersdecor:rebar_concrete_tile'))
ore('blockConcrete').add(item('engineersdecor:gas_concrete'))
ore('blockConcrete').add(item('icbmclassic:concrete'))


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

//High purity oredicting
ore('dustLithium').add(metaitem('dustHighPurityLithium'))
ore('dustBeryllium').add(metaitem('dustHighPurityBeryllium'))
ore('dustBoron').add(metaitem('dustHighPurityBoron'))
ore('dustCarbon').add(metaitem('dustHighPurityCarbon'))
ore('dustSodium').add(metaitem('dustHighPuritySodium'))
ore('dustMagnesium').add(metaitem('dustHighPurityMagnesium'))
ore('dustAluminium').add(metaitem('dustHighPurityAluminium'))
ore('dustSilicon').add(metaitem('dustHighPuritySilicon'))
ore('dustPhosphorus').add(metaitem('dustHighPurityPhosphorus'))
ore('dustSulfur').add(metaitem('dustHighPuritySulfur'))
ore('dustPotassium').add(metaitem('dustHighPurityPotassium'))
ore('dustCalcium').add(metaitem('dustHighPurityCalcium'))
ore('dustScandium').add(metaitem('dustHighPurityScandium'))
ore('dustTitanium').add(metaitem('dustHighPurityTitanium'))
ore('dustVanadium').add(metaitem('dustHighPurityVanadium'))
ore('dustChrome').add(metaitem('dustHighPurityChrome'))
ore('dustManganese').add(metaitem('dustHighPurityManganese'))
ore('dustIron').add(metaitem('dustHighPurityIron'))
ore('dustCobalt').add(metaitem('dustHighPurityCobalt'))
ore('dustNickel').add(metaitem('dustHighPurityNickel'))
ore('dustCopper').add(metaitem('dustHighPurityCopper'))
ore('dustZinc').add(metaitem('dustHighPurityZinc'))
ore('dustGallium').add(metaitem('dustHighPurityGallium'))
ore('dustGermanium').add(metaitem('dustHighPurityGermanium'))
ore('dustArsenic').add(metaitem('dustHighPurityArsenic'))
ore('dustSelenium').add(metaitem('dustHighPuritySelenium'))
ore('dustRubidium').add(metaitem('dustHighPurityRubidium'))
ore('dustStrontium').add(metaitem('dustHighPurityStrontium'))
ore('dustYttrium').add(metaitem('dustHighPurityYttrium'))
ore('dustZirconium').add(metaitem('dustHighPurityZirconium'))
ore('dustNiobium').add(metaitem('dustHighPurityNiobium'))
ore('dustMolybdenum').add(metaitem('dustHighPurityMolybdenum'))
ore('dustTechnetium').add(metaitem('dustHighPurityTechnetium'))
ore('dustRhenium').add(metaitem('dustHighPurityRhenium'))
ore('dustRhodium').add(metaitem('dustHighPurityRhodium'))
ore('dustPalladium').add(metaitem('dustHighPurityPalladium'))
ore('dustSilver').add(metaitem('dustHighPuritySilver'))
ore('dustCadmium').add(metaitem('dustHighPurityCadmium'))
ore('dustIndium').add(metaitem('dustHighPurityIndium'))
ore('dustTin').add(metaitem('dustHighPurityTin'))
ore('dustAntimony').add(metaitem('dustHighPurityAntimony'))
ore('dustTellurium').add(metaitem('dustHighPurityTellurium'))
ore('dustIodine').add(metaitem('dustHighPurityIodine'))
ore('dustCaesium').add(metaitem('dustHighPurityCaesium'))
ore('dustBarium').add(metaitem('dustHighPurityBarium'))
ore('dustLanthanum').add(metaitem('dustHighPurityLanthanum'))
ore('dustHafnium').add(metaitem('dustHighPurityHafnium'))
ore('dustTantalum').add(metaitem('dustHighPurityTantalum'))
ore('dustTungsten').add(metaitem('dustHighPurityTungsten'))
ore('dustOsmium').add(metaitem('dustHighPurityOsmium'))
ore('dustIridium').add(metaitem('dustHighPurityIridium'))
ore('dustPlatinum').add(metaitem('dustHighPurityPlatinum'))
ore('dustGold').add(metaitem('dustHighPurityGold'))
ore('dustThallium').add(metaitem('dustHighPurityThallium'))
ore('dustLead').add(metaitem('dustHighPurityLead'))
ore('dustBismuth').add(metaitem('dustHighPurityBismuth'))
ore('dustCerium').add(metaitem('dustHighPurityCerium'))
ore('dustPraseodymium').add(metaitem('dustHighPurityPraseodymium'))
ore('dustNeodymium').add(metaitem('dustHighPurityNeodymium'))
ore('dustSamarium').add(metaitem('dustHighPuritySamarium'))
ore('dustEuropium').add(metaitem('dustHighPurityEuropium'))
ore('dustGadolinium').add(metaitem('dustHighPurityGadolinium'))
ore('dustTerbium').add(metaitem('dustHighPurityTerbium'))
ore('dustDysprosium').add(metaitem('dustHighPurityDysprosium'))
ore('dustHolmium').add(metaitem('dustHighPurityHolmium'))
ore('dustErbium').add(metaitem('dustHighPurityErbium'))
ore('dustThulium').add(metaitem('dustHighPurityThulium'))
ore('dustYtterbium').add(metaitem('dustHighPurityYtterbium'))
ore('dustLutetium').add(metaitem('dustHighPurityLutetium'))
ore('dustThorium').add(metaitem('dustHighPurityThorium'))

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
