import static globals.Globals.*
import static globals.SinteringGlobals.*

ABS = recipemap('alloy_blast_smelter')
FORMING_PRESS = recipemap("forming_press")

//REMOVALS
def name_removals = [
        'gregtech:stick_long_neodymium_alloy_magnetic',
        'gregtech:stick_neodymium_alloy_magnetic',
        'gregtech:stick_long_stick_neodymium_alloy_magnetic',
        'gregtech:ring_neodymium_alloy_magnetic',
        'gregtech:stick_long_treated_neodymium_alloy',
        'gregtech:stick_treated_neodymium_alloy',
        'gregtech:stick_long_stick_treated_neodymium_alloy',
        'gregtech:ring_treated_neodymium_alloy',
        'gregtech:stick_long_samarium_alloy',
        'gregtech:stick_samarium_alloy',
        'gregtech:stick_long_stick_samarium_alloy',
        'gregtech:ring_samarium_alloy',
        'gregtech:plate_double_samarium_alloy',
        'gregtech:stick_treated_samarium_alloy',
        'gregtech:plate_double_treated_samarium_alloy',
        'gregtech:stick_long_stick_treated_samarium_alloy',
        'gregtech:ring_treated_samarium_alloy',
        'gregtech:stick_long_treated_samarium_alloy',
        'gregtech:stick_samarium_alloy_magnetic',
        'gregtech:plate_double_samarium_alloy_magnetic',
        'gregtech:stick_long_stick_samarium_alloy_magnetic',
        'gregtech:ring_samarium_alloy_magnetic',
        'gregtech:stick_long_samarium_alloy_magnetic'
]

for (name in name_removals) {
    crafting.remove(name)
}

def ore_smelting_removals = [
        'dustTreatedNeodymiumAlloy',
        'dustSamariumAlloy',
        'dustTreatedSamariumAlloy'
]

for (name in ore_smelting_removals) {
    furnace.removeByInput(metaitem(name))
}

//NEODYMIUM MAGNETS

mods.gregtech.mixer.recipeBuilder()
        .inputs(ore('dustNeodymium') * 2)
        .inputs(ore('dustIron') * 14)
        .inputs(ore('dustBoron') * 1)
        .outputs(metaitem('dustNeodymiumAlloy') * 17)
        .duration(400)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ingotNeodymiumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('ingotTreatedNeodymiumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('plateNeodymiumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('plateTreatedNeodymiumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickNeodymiumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('stickTreatedNeodymiumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickLongNeodymiumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('stickLongTreatedNeodymiumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ringNeodymiumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('ringTreatedNeodymiumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

//SAMARIUM MAGNETS

ABS.recipeBuilder()
        .inputs(ore('dustSamarium'))
        .inputs(ore('dustCobalt') * 5)
        .fluidInputs(fluid('argon') * 300)
        .fluidOutputs(fluid('samarium_alloy') * 864)
        .blastFurnaceTemp(1800)
        .duration(300)
        .EUt(1920)
        .buildAndRegister();

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.long_rod'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('stickLongSamariumAlloy'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ring'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('ringSamariumAlloy') * 4)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.rod'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('stickSamariumAlloy') * 2)
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.plate'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('plateSamariumAlloy'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .inputs(ore('dustSamariumAlloy'))
        .outputs(metaitem('ingotSamariumAlloy'))
        .duration(200)
        .EUt(240)
        .buildAndRegister()

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ingotSamariumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('ingotTreatedSamariumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('plateSamariumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('plateTreatedSamariumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickSamariumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('stickTreatedSamariumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('stickLongSamariumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('stickLongTreatedSamariumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

mods.gregtech.electrolyzer.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .inputs(ore('ringSamariumAlloy') * 4)
        .inputs(ore('dustNickel') * 1)
        .notConsumable(ore('dustBoricAcid') * 1)
        .outputs(metaitem('ringTreatedSamariumAlloy') * 4)
        .duration(120)
        .EUt(256)
        .buildAndRegister();

//REMOVE AUTOGENERATED STUFF

// Magnetic Neodymium Alloy Rod * 2
mods.gregtech.lathe.removeByInput(16, [metaitem('ingotNeodymiumAlloyMagnetic')], null)
// Magnetic Neodymium Alloy Rod * 2
mods.gregtech.cutter.removeByInput(4, [metaitem('stickLongNeodymiumAlloyMagnetic')], [fluid('lubricant')])
// Magnetic Neodymium Alloy Rod * 2
mods.gregtech.cutter.removeByInput(4, [metaitem('stickLongNeodymiumAlloyMagnetic')], [fluid('distilled_water') * 3])
// Magnetic Neodymium Alloy Rod * 2
mods.gregtech.cutter.removeByInput(4, [metaitem('stickLongNeodymiumAlloyMagnetic')], [fluid('water') * 4])
// Long Magnetic Neodymium Alloy Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickNeodymiumAlloyMagnetic') * 2], null)
// Long Magnetic Neodymium Alloy Rod * 1
mods.gregtech.extruder.removeByInput(64, [metaitem('ingotNeodymiumAlloyMagnetic'), metaitem('shape.extruder.rod_long')], null)
// Magnetic Neodymium Alloy Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotNeodymiumAlloyMagnetic'), metaitem('shape.extruder.ring')], null)
// Block of Treated Neodymium Alloy * 1
mods.gregtech.extruder.removeByInput(56, [metaitem('ingotTreatedNeodymiumAlloy') * 9, metaitem('shape.extruder.block')], null)
// Long Treated Neodymium Alloy Rod * 1
mods.gregtech.extruder.removeByInput(64, [metaitem('ingotTreatedNeodymiumAlloy'), metaitem('shape.extruder.rod_long')], null)
// Treated Neodymium Alloy Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotTreatedNeodymiumAlloy'), metaitem('shape.extruder.ring')], null)
// Double Treated Neodymium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('ingotTreatedNeodymiumAlloy') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Treated Neodymium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockTreatedNeodymiumAlloy')], [fluid('lubricant') * 11])
// Treated Neodymium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockTreatedNeodymiumAlloy')], [fluid('distilled_water') * 35])
// Treated Neodymium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockTreatedNeodymiumAlloy')], [fluid('water') * 47])
// Treated Neodymium Alloy Rod * 2
mods.gregtech.lathe.removeByInput(16, [metaitem('ingotTreatedNeodymiumAlloy')], null)
// Treated Neodymium Alloy Rod * 2
mods.gregtech.cutter.removeByInput(4, [metaitem('stickLongTreatedNeodymiumAlloy')], [fluid('lubricant')])
// Treated Neodymium Alloy Rod * 2
mods.gregtech.cutter.removeByInput(4, [metaitem('stickLongTreatedNeodymiumAlloy')], [fluid('distilled_water') * 3])
// Treated Neodymium Alloy Rod * 2
mods.gregtech.cutter.removeByInput(4, [metaitem('stickLongTreatedNeodymiumAlloy')], [fluid('water') * 4])
// Long Treated Neodymium Alloy Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickTreatedNeodymiumAlloy') * 2], null)
// Samarium Alloy Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('samarium_alloy') * 144])
// Samarium Alloy Nugget * 9
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.nugget')], [fluid('samarium_alloy') * 144])
// Block of Samarium Alloy * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.block')], [fluid('samarium_alloy') * 1296])
// Samarium Alloy Rod * 2
mods.gregtech.lathe.removeByInput(16, [metaitem('ingotSamariumAlloy')], null)
// Long Samarium Alloy Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickSamariumAlloy') * 2], null)
// Long Samarium Alloy Rod * 1
mods.gregtech.extruder.removeByInput(64, [metaitem('ingotSamariumAlloy'), metaitem('shape.extruder.rod_long')], null)
// Samarium Alloy Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotSamariumAlloy'), metaitem('shape.extruder.ring')], null)
// Samarium Alloy * 16
mods.gregtech.extractor.removeByInput(30, [metaitem('nuggetSamariumAlloy')], null)
// Samarium Alloy * 16
mods.gregtech.extractor.removeByInput(30, [metaitem('nuggetTreatedSamariumAlloy')], null)
// Samarium Alloy * 16
mods.gregtech.extractor.removeByInput(30, [metaitem('nuggetSamariumAlloyMagnetic')], null)
// Samarium Alloy * 36
mods.gregtech.extractor.removeByInput(30, [metaitem('ringSamariumAlloy')], null)
// Samarium Alloy * 36
mods.gregtech.extractor.removeByInput(30, [metaitem('ringTreatedSamariumAlloy')], null)
// Samarium Alloy * 36
mods.gregtech.extractor.removeByInput(30, [metaitem('ringSamariumAlloyMagnetic')], null)
// Samarium Alloy * 72
mods.gregtech.extractor.removeByInput(30, [metaitem('stickSamariumAlloy')], null)
// Samarium Alloy * 72
mods.gregtech.extractor.removeByInput(30, [metaitem('stickTreatedSamariumAlloy')], null)
// Samarium Alloy * 72
mods.gregtech.extractor.removeByInput(30, [metaitem('stickSamariumAlloyMagnetic')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustTreatedSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('dustSamariumAlloyMagnetic')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('plateSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('plateTreatedSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('plateSamariumAlloyMagnetic')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('stickLongSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('stickLongTreatedSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('stickLongSamariumAlloyMagnetic')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('ingotSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('ingotTreatedSamariumAlloy')], null)
// Samarium Alloy * 144
mods.gregtech.extractor.removeByInput(30, [metaitem('ingotSamariumAlloyMagnetic')], null)
// Samarium Alloy * 288
mods.gregtech.extractor.removeByInput(30, [metaitem('plateDoubleSamariumAlloy')], null)
// Samarium Alloy * 288
mods.gregtech.extractor.removeByInput(30, [metaitem('plateDoubleTreatedSamariumAlloy')], null)
// Samarium Alloy * 288
mods.gregtech.extractor.removeByInput(30, [metaitem('plateDoubleSamariumAlloyMagnetic')], null)
// Samarium Alloy * 1296
mods.gregtech.extractor.removeByInput(30, [metaitem('blockSamariumAlloy')], null)
// Samarium Alloy * 1296
mods.gregtech.extractor.removeByInput(30, [metaitem('blockTreatedSamariumAlloy')], null)
// Samarium Alloy * 1296
mods.gregtech.extractor.removeByInput(30, [metaitem('blockSamariumAlloyMagnetic')], null)
// Double Samarium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('ingotSamariumAlloy') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('plateSamariumAlloy')], [fluid('oxygen') * 74])
// Double Samarium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('plateSamariumAlloy') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Samarium Alloy Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('stickSamariumAlloy')], [fluid('oxygen') * 32])
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('stickLongSamariumAlloy')], [fluid('oxygen') * 74])
// Samarium Alloy Nugget * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('ringSamariumAlloy')], [fluid('oxygen') * 16])
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('dustTreatedSamariumAlloy')], [fluid('oxygen') * 74])
// Treated Samarium Alloy Rod * 2
mods.gregtech.lathe.removeByInput(16, [metaitem('ingotTreatedSamariumAlloy')], null)
// Long Treated Samarium Alloy Rod * 1
mods.gregtech.extruder.removeByInput(64, [metaitem('ingotTreatedSamariumAlloy'), metaitem('shape.extruder.rod_long')], null)
// Treated Samarium Alloy Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotTreatedSamariumAlloy'), metaitem('shape.extruder.ring')], null)
// Double Treated Samarium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('ingotTreatedSamariumAlloy') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('plateTreatedSamariumAlloy')], [fluid('oxygen') * 74])
// Double Treated Samarium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('plateTreatedSamariumAlloy') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Long Treated Samarium Alloy Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickTreatedSamariumAlloy') * 2], null)
// Samarium Alloy Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('stickTreatedSamariumAlloy')], [fluid('oxygen') * 32])
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('stickLongTreatedSamariumAlloy')], [fluid('oxygen') * 74])
// Samarium Alloy Nugget * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('ringTreatedSamariumAlloy')], [fluid('oxygen') * 16])
// Magnetic Samarium Alloy Rod * 2
mods.gregtech.lathe.removeByInput(16, [metaitem('ingotSamariumAlloyMagnetic')], null)
// Long Magnetic Samarium Alloy Rod * 1
mods.gregtech.extruder.removeByInput(64, [metaitem('ingotSamariumAlloyMagnetic'), metaitem('shape.extruder.rod_long')], null)
// Magnetic Samarium Alloy Ring * 4
mods.gregtech.extruder.removeByInput(42, [metaitem('ingotSamariumAlloyMagnetic'), metaitem('shape.extruder.ring')], null)
// Double Magnetic Samarium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('ingotSamariumAlloyMagnetic') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('plateSamariumAlloyMagnetic')], [fluid('oxygen') * 74])
// Double Magnetic Samarium Alloy Plate * 1
mods.gregtech.bender.removeByInput(96, [metaitem('plateSamariumAlloyMagnetic') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Long Magnetic Samarium Alloy Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickSamariumAlloyMagnetic') * 2], null)
// Samarium Alloy Nugget * 4
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('stickSamariumAlloyMagnetic')], [fluid('oxygen') * 32])
// Samarium Alloy Nugget * 2
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('ringSamariumAlloyMagnetic')], [fluid('oxygen') * 16])
// Samarium Alloy Ingot * 1
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('dustSamariumAlloy')], [fluid('oxygen') * 74])
// Magnetic Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockSamariumAlloyMagnetic')], [fluid('lubricant') * 13])
// Magnetic Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockSamariumAlloyMagnetic')], [fluid('distilled_water') * 41])
// Magnetic Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockSamariumAlloyMagnetic')], [fluid('water') * 55])
// Treated Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockTreatedSamariumAlloy')], [fluid('lubricant') * 13])
// Treated Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockTreatedSamariumAlloy')], [fluid('distilled_water') * 41])
// Treated Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockTreatedSamariumAlloy')], [fluid('water') * 55])
// Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockSamariumAlloy')], [fluid('lubricant') * 13])
// Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockSamariumAlloy')], [fluid('distilled_water') * 41])
// Samarium Alloy Plate * 9
mods.gregtech.cutter.removeByInput(30, [metaitem('blockSamariumAlloy')], [fluid('water') * 55])
// Magnetic Samarium Alloy Ingot * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('ingotTreatedSamariumAlloy')], null)
// Magnetic Samarium Alloy Plate * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('plateTreatedSamariumAlloy')], null)
// Magnetic Samarium Alloy Rod * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('stickTreatedSamariumAlloy')], null)
// Long Magnetic Samarium Alloy Rod * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('stickLongTreatedSamariumAlloy')], null)
// Magnetic Samarium Alloy Ring * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('ringTreatedSamariumAlloy')], null)
// Magnetic Neodymium Alloy Ingot * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('ingotTreatedNeodymiumAlloy')], null)
// Magnetic Neodymium Alloy Plate * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('plateTreatedNeodymiumAlloy')], null)
// Magnetic Neodymium Alloy Rod * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('stickTreatedNeodymiumAlloy')], null)
// Long Magnetic Neodymium Alloy Rod * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('stickLongTreatedNeodymiumAlloy')], null)
// Magnetic Neodymium Alloy Ring * 1
mods.gregtech.polarizer.removeByInput(16, [metaitem('ringTreatedNeodymiumAlloy')], null)

//REPLACE MAGNETIC STUFF IN RECIPES

// IV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleTungsten') * 2, metaitem('stickTungstenSteel') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleGraphene') * 4], null)
// EV Electric Motor * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cableGtDoubleAluminium') * 2, metaitem('stickTitanium') * 2, metaitem('stickNeodymiumMagnetic'), metaitem('wireGtDoubleKanthal') * 4], null)
// Extreme Voltage Coil * 1
mods.gregtech.assembler.removeByInput(1920, [metaitem('stickNeodymiumMagnetic'), metaitem('wireFineTungstenSteel') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Insane Voltage Coil * 1
mods.gregtech.assembler.removeByInput(7680, [metaitem('stickNeodymiumMagnetic'), metaitem('wireFineIridium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Ludicrous Voltage Coil * 1
mods.gregtech.assembler.removeByInput(30720, [metaitem('stickSamariumMagnetic'), metaitem('wireFineOsmiridium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Zero Point Module Voltage Coil * 1
mods.gregtech.assembler.removeByInput(122880, [metaitem('stickSamariumMagnetic'), metaitem('wireFineEuropium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Ultimate Voltage Coil * 1
mods.gregtech.assembler.removeByInput(491520, [metaitem('stickSamariumMagnetic'), metaitem('wireFineTritanium') * 16, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// LuV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(6000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongHsss') * 2, metaitem('ringHsss') * 2, metaitem('roundHsss') * 4, metaitem('wireFineRuridit') * 64, metaitem('cableGtSingleNiobiumTitanium') * 2], [fluid('soldering_alloy') * 144, fluid('lubricant') * 250])
// ZPM Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(24000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongOsmiridium') * 4, metaitem('ringOsmiridium') * 4, metaitem('roundOsmiridium') * 8, metaitem('wireFineEuropium') * 64, metaitem('wireFineEuropium') * 32, metaitem('cableGtSingleVanadiumGallium') * 2], [fluid('soldering_alloy') * 288, fluid('lubricant') * 500])
// UV Electric Motor * 1
mods.gregtech.assembly_line.removeByInput(100000, [metaitem('stickLongSamariumMagnetic'), metaitem('stickLongTritanium') * 4, metaitem('ringTritanium') * 4, metaitem('roundTritanium') * 8, metaitem('wireFineAmericium') * 64, metaitem('wireFineAmericium') * 64, metaitem('cableGtSingleYttriumBariumCuprate') * 2], [fluid('soldering_alloy') * 576, fluid('lubricant') * 1000, fluid('naquadria') * 576])

crafting.replaceShaped('gregtech:electric_motor_ev', metaitem('electric.motor.ev'), [
        [metaitem('cableGtDoubleAluminium'), metaitem('wireGtDoubleKanthal'), metaitem('stickTitanium')],
        [metaitem('wireGtDoubleKanthal'), metaitem('stickSteelMagnetic'), metaitem('wireGtDoubleKanthal')],
        [metaitem('stickTitanium'), metaitem('wireGtDoubleKanthal'), metaitem('cableGtDoubleAluminium')]
])

crafting.replaceShaped('gregtech:electric_motor_iv', metaitem('electric.motor.iv'), [
        [metaitem('cableGtDoubleTungsten'), metaitem('wireGtDoubleGraphene'), metaitem('stickTungstenSteel')],
        [metaitem('wireGtDoubleGraphene'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtDoubleGraphene')],
        [metaitem('stickTungstenSteel'), metaitem('wireGtDoubleGraphene'), metaitem('cableGtDoubleTungsten')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.sodium', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.sodium'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.lithium', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.lithium'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_battery.re.hv.cadmium', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('battery.re.hv.cadmium'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:magnet_hv_energy_crystal', metaitem('item_magnet.hv'), [
        [metaitem('stickNeodymiumAlloyMagnetic'), ore('toolWrench'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('stickNeodymiumAlloyMagnetic'), metaitem('energy_crystal'), metaitem('stickNeodymiumAlloyMagnetic')],
        [metaitem('wireGtSingleGold'), metaitem('plateStainlessSteel'), metaitem('wireGtSingleGold')]
])

crafting.replaceShaped('gregtech:gregtech.machine.electromagnetic_separator.ev', metaitem('electromagnetic_separator.ev'), [
        [metaitem('conveyor.module.ev'), metaitem('cableGtSingleAluminium'), metaitem('wireGtQuadrupleNichrome')],
        [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('stickSteelMagnetic')],
        [ore('circuitEv'), metaitem('cableGtSingleAluminium'), metaitem('wireGtQuadrupleNichrome')]
])

crafting.replaceShaped('gregtech:gregtech.machine.electromagnetic_separator.iv', metaitem('electromagnetic_separator.iv'), [
        [metaitem('conveyor.module.iv'), metaitem('cableGtSinglePlatinum'), metaitem('wireGtQuadrupleTungstenSteel')],
        [metaitem('cableGtSinglePlatinum'), metaitem('hull.iv'), metaitem('stickNeodymiumAlloyMagnetic')],
        [ore('circuitIv'), metaitem('cableGtSinglePlatinum'), metaitem('wireGtQuadrupleTungstenSteel')]
])

crafting.replaceShaped('gregtech:gregtech.machine.polarizer.ev', metaitem('polarizer.ev'), [
        [metaitem('wireGtQuadrupleNichrome'), metaitem('stickSteelMagnetic'), metaitem('wireGtQuadrupleNichrome')],
        [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('cableGtSingleAluminium')],
        [metaitem('wireGtQuadrupleNichrome'), metaitem('stickSteelMagnetic'), metaitem('wireGtQuadrupleNichrome')]
])

crafting.replaceShaped('gregtech:gregtech.machine.polarizer.iv', metaitem('polarizer.iv'), [
        [metaitem('wireGtQuadrupleTungstenSteel'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtQuadrupleTungstenSteel')],
        [metaitem('cableGtSinglePlatinum'), metaitem('hull.iv'), metaitem('cableGtSinglePlatinum')],
        [metaitem('wireGtQuadrupleTungstenSteel'), metaitem('stickNeodymiumAlloyMagnetic'), metaitem('wireGtQuadrupleTungstenSteel')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('cableGtDoubleAluminium') * 2)
        .inputs(ore('stickTitanium') * 2)
        .inputs(ore('stickSteelMagnetic') * 1)
        .inputs(ore('wireGtDoubleKanthal') * 4)
        .outputs(metaitem('electric.motor.ev'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('cableGtDoubleTungsten') * 2)
        .inputs(ore('stickTungstenSteel') * 2)
        .inputs(ore('stickNeodymiumAlloyMagnetic') * 1)
        .inputs(ore('wireGtDoubleGraphene') * 4)
        .outputs(metaitem('electric.motor.iv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSteelMagnetic') * 1)
        .inputs(ore('wireFineTungstenSteel') * 16)
        .outputs(metaitem('voltage_coil.ev'))
        .duration(200)
        .EUt(1920)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickNeodymiumAlloyMagnetic') * 1)
        .inputs(ore('wireFineIridium') * 16)
        .outputs(metaitem('voltage_coil.iv'))
        .duration(200)
        .EUt(7680)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSamariumAlloyMagnetic') * 1)
        .inputs(ore('wireFineOsmiridium') * 16)
        .outputs(metaitem('voltage_coil.luv'))
        .duration(200)
        .EUt(30720)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSamariumAlloyMagnetic') * 1)
        .inputs(ore('wireFineEuropium') * 16)
        .outputs(metaitem('voltage_coil.zpm'))
        .duration(200)
        .EUt(122880)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickSamariumAlloyMagnetic') * 1)
        .inputs(ore('wireFineTritanium') * 16)
        .outputs(metaitem('voltage_coil.uv'))
        .duration(200)
        .EUt(491520)
        .buildAndRegister();

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(ore('stickLongSamariumAlloyMagnetic'))
        .inputs(ore('stickLongHsss') * 2)
        .inputs(ore('ringHsss') * 2)
        .inputs(ore('roundHsss') * 4)
        .inputs(ore('wireFineRuridit') * 64)
        .inputs(ore('cableGtSingleNiobiumTitanium') * 2)
        .fluidInputs(fluid('soldering_alloy') * 144)
        .fluidInputs(fluid('lubricant') * 250)
        .outputs(metaitem('electric.motor.luv'))
        .duration(600)
        .EUt(6000)
        .buildAndRegister();

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(ore('stickLongSamariumAlloyMagnetic'))
        .inputs(ore('stickLongOsmiridium') * 4)
        .inputs(ore('ringOsmiridium') * 4)
        .inputs(ore('roundOsmiridium') * 8)
        .inputs(ore('wireFineEuropium') * 64)
        .inputs(ore('wireFineEuropium') * 32)
        .inputs(ore('cableGtSingleVanadiumGallium') * 2)
        .fluidInputs(fluid('soldering_alloy') * 288)
        .fluidInputs(fluid('lubricant') * 500)
        .outputs(metaitem('electric.motor.zpm'))
        .duration(600)
        .EUt(24000)
        .buildAndRegister();

mods.gregtech.assembly_line.recipeBuilder()
        .inputs(ore('stickLongSamariumAlloyMagnetic'))
        .inputs(ore('stickLongTritanium') * 4)
        .inputs(ore('ringTritanium') * 4)
        .inputs(ore('roundTritanium') * 8)
        .inputs(ore('wireFineAmericium') * 64)
        .inputs(ore('wireFineAmericium') * 64)
        .inputs(ore('cableGtSingleYttriumBariumCuprate') * 2)
        .fluidInputs(fluid('soldering_alloy') * 576)
        .fluidInputs(fluid('lubricant') * 1000)
        .fluidInputs(fluid('naquadria') * 576)
        .outputs(metaitem('electric.motor.uv'))
        .duration(600)
        .EUt(100000)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickLongTreatedSamariumAlloy'))
        .outputs(metaitem('stickLongSamariumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickTreatedSamariumAlloy'))
        .outputs(metaitem('stickSamariumAlloyMagnetic'))
        .duration(75)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ringTreatedSamariumAlloy'))
        .outputs(metaitem('ringSamariumAlloyMagnetic'))
        .duration(40)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ingotTreatedSamariumAlloy'))
        .outputs(metaitem('ingotSamariumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('plateTreatedSamariumAlloy'))
        .outputs(metaitem('plateSamariumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickLongTreatedNeodymiumAlloy'))
        .outputs(metaitem('stickLongNeodymiumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('stickTreatedNeodymiumAlloy'))
        .outputs(metaitem('stickNeodymiumAlloyMagnetic'))
        .duration(75)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ringTreatedNeodymiumAlloy'))
        .outputs(metaitem('ringNeodymiumAlloyMagnetic'))
        .duration(40)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('ingotTreatedNeodymiumAlloy'))
        .outputs(metaitem('ingotNeodymiumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();

mods.gregtech.polarizer.recipeBuilder()
        .inputs(ore('plateTreatedNeodymiumAlloy'))
        .outputs(metaitem('plateNeodymiumAlloyMagnetic'))
        .duration(150)
        .EUt(240)
        .buildAndRegister();