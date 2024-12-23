import globals.Globals
import globals.GroovyUtils
import globals.RecyclingHelper
import gregtech.common.blocks.MetaBlocks
import gregtech.common.blocks.MetaBlocks.*
import net.minecraft.init.Blocks

log.infoMC("Running GregTech.groovy...")

//REMOVALS

// Note Block * 1
mods.gregtech.assembler.removeByInput(16, [metaitem('plateWood') * 8, item('minecraft:redstone'), metaitem('circuit.integrated').withNbt(['Configuration': 9])], null)
// Wood Pulp * 8
mods.gregtech.macerator.removeByInput(2, [item('minecraft:noteblock')], null)
// Carbon Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustCoal')], null)
// Small Pile of Rare Earth * 1
mods.gregtech.extractor.removeByInput(64, [metaitem('dustMonazite')], null)
// Graphene Dust * 1
mods.gregtech.mixer.removeByInput(480, [metaitem('dustGraphite'), metaitem('dustSilicon'), metaitem('dustCarbon') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
mods.gregtech.blender.removeByInput(480, [metaitem('dustGraphite'), metaitem('dustSilicon'), metaitem('dustCarbon') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)
// Wrought Iron Ingot * 2
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustIlmenite') * 10, metaitem('dustCarbon') * 4], null)
// Stone Slab * 2
mods.gregtech.cutter.removeByInput(7, [item('minecraft:stone')], [fluid('lubricant')])
// Stone Slab * 2
mods.gregtech.cutter.removeByInput(7, [item('minecraft:stone')], [fluid('distilled_water') * 3])
// Cobblestone Slab * 2
mods.gregtech.cutter.removeByInput(7, [item('minecraft:cobblestone')], [fluid('lubricant')])
// Cobblestone Slab * 2
mods.gregtech.cutter.removeByInput(7, [item('minecraft:cobblestone')], [fluid('distilled_water') * 3])
// Hot Titanium Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustTitaniumTrifluoride') * 4], [fluid('hydrogen') * 3000])
// Heated Water * 1000
mods.gregtech.fluid_heater.removeByInput(120, [metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('water') * 1000])
// Beryllium Oxide Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('beryllium_oxide') * 144])
// Beryllium Oxide Plate * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('dustBerylliumOxide')], null)
// Laminated Glass * 1
mods.gregtech.forming_press.removeByInput(480, [item('gregtech:transparent_casing') * 2, metaitem('platePolyvinylButyral')], null)
// Magnalium Ingot * 3
mods.gregtech.arc_furnace.removeByInput(30, [item('gregtech:turbine_casing', 5)], [fluid('oxygen') * 150])
// Magnalium Dust * 3
mods.gregtech.macerator.removeByInput(8, [item('gregtech:turbine_casing', 5)], null)
// Gelatin Mixture * 4000
mods.gregtech.mixer.removeByInput(480, [metaitem('dustCollagen') * 4], [fluid('phosphoric_acid') * 1000, fluid('water') * 3000])
mods.gregtech.blender.removeByInput(480, [metaitem('dustCollagen') * 4], [fluid('phosphoric_acid') * 1000, fluid('water') * 3000])
// Phosphorus Dust * 1
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('gelatin_mixture') * 6000])
// Reservoir Hatch * 1
mods.gregtech.assembler.removeByInput(1920, [metaitem('cover.infinite_water'), metaitem('fluid_hatch.import.ev'), metaitem('electric.pump.ev')], null)
// White Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool') * 3, metaitem('plateWood') * 3], null)
// Orange Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 1) * 3, metaitem('plateWood') * 3], null)
// Magenta Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 2) * 3, metaitem('plateWood') * 3], null)
// Light Blue Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 3) * 3, metaitem('plateWood') * 3], null)
// Yellow Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 4) * 3, metaitem('plateWood') * 3], null)
// Lime Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 5) * 3, metaitem('plateWood') * 3], null)
// Pink Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 6) * 3, metaitem('plateWood') * 3], null)
// Gray Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 7) * 3, metaitem('plateWood') * 3], null)
// Light Gray Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 8) * 3, metaitem('plateWood') * 3], null)
// Cyan Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 9) * 3, metaitem('plateWood') * 3], null)
// Purple Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 10) * 3, metaitem('plateWood') * 3], null)
// Blue Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 11) * 3, metaitem('plateWood') * 3], null)
// Brown Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 12) * 3, metaitem('plateWood') * 3], null)
// Green Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 13) * 3, metaitem('plateWood') * 3], null)
// Red Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 14) * 3, metaitem('plateWood') * 3], null)
// Black Bed * 1
mods.gregtech.assembler.removeByInput(7, [item('minecraft:wool', 15) * 3, metaitem('plateWood') * 3], null)

def name_removals = [
	'gregtech:cover_fluid_voiding',
	'gregtech:cover_item_voiding',
	'gregtech:fluid_filter_lapis',
	'gregtech:fluid_filter_sodalite',
	'gregtech:fluid_filter_lazurite',
	'gregtech:comparator_certus',
	'gregtech:nano_helmet',
	'gregtech:nano_chestplate',
	'gregtech:nano_leggings',
	'gregtech:nano_boots',
	'gregtech:super_chest_lv',
	'gregtech:super_chest_mv',
	'gregtech:super_chest_hv',
	'gregtech:super_chest_ev',
	'gregtech:super_tank_lv',
	'gregtech:super_tank_mv',
	'gregtech:super_tank_hv',
	'gregtech:super_tank_ev',
	'gregtech:quantum_chest_iv',
	'gregtech:quantum_chest_luv',
	'gregtech:quantum_chest_zpm',
	'gregtech:quantum_chest_uv',
	'gregtech:quantum_chest_uhv',
	'gregtech:quantum_tank_iv',
	'gregtech:quantum_tank_luv',
	'gregtech:quantum_tank_zpm',
	'gregtech:quantum_tank_uv',
	'gregtech:quantum_tank_uhv',
	'gregtech:large_combustion_engine',
	'gregtech:extreme_combustion_engine',
	'gregtech:gregtech.machine.fisher.lv',
	'gregtech:gregtech.machine.fisher.mv',
	'gregtech:gregtech.machine.fisher.hv',
	'gregtech:gregtech.machine.fisher.ev'
]

for (name in name_removals) {
    crafting.remove(name)
}

furnace.removeByInput(item('minecraft:iron_nugget'))

def ore_smelting_removals = [
        'lapis',
        'emerald',
        'almandine',
        'lazurite',
        'pyrope',
        'spessartine',
        'sodalite',
        'grossular',
        'garnet_red',
        'apatite',
        'blue_topaz',
        'certus_quartz',
        'garnet_yellow',
        'olivine',
        'monazite',
        'vanadinite',
        'celestine',
        'green_sapphire',
        'sperrylite',
        'sapphire',
        'ruby',
        'proustite',
        'topaz',
        'lorandite',
        'fluorite',
        'realgar',
        'amethyst',
        'opal',
        'perovskite',
        'cinnabar',
        'fluorapatite',
        'diamond'
]

for (name in ore_smelting_removals) {
    furnace.removeByInput(item('gregtech:ore_' + name + '_0', 0))
    furnace.removeByInput(item('gregtech:ore_' + name + '_0', 1))
    furnace.removeByInput(item('gregtech:ore_' + name + '_0', 2))
}

// Malachite Ore
furnace.removeByInput(item('gregtech:ore_malachite_0', 0))
furnace.add(item('gregtech:ore_malachite_0', 0), metaitem('ingotCopper') * 2, 0.5)

// Polycaprolactam Bar * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCaprolactam')], [fluid('nitrogen') * 1000])
// Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSilicon') * 32, metaitem('dustSmallGalliumArsenide'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Cupronickel Coil Block * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('wireGtDoubleCupronickel') * 8, metaitem('foilBronze') * 8], [fluid('tin_alloy') * 144])
// Kanthal Coil Block * 1
mods.gregtech.assembler.removeByInput(120, [metaitem('wireGtDoubleKanthal') * 8, metaitem('foilAluminium') * 8], [fluid('copper') * 144])
// Nichrome Coil Block * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('wireGtDoubleNichrome') * 8, metaitem('foilStainlessSteel') * 8], [fluid('aluminium') * 144])
// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('gemRuby')], null)
// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('gemSapphire')], null)
// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('gemGreenSapphire')], null)
// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('dustGreenSapphire')], null)
// Aluminium Nugget * 3
mods.gregtech.electric_blast_furnace.removeByInput(100, [metaitem('dustSapphire')], null)
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustFerrochromium') * 3], null)
// Iron Dust * 6
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustStainlessSteel') * 9], null)
// Aluminium Ingot * 21
mods.gregtech.arc_furnace.removeByInput(30, [metaitem('pyrolyse_oven')], [fluid('oxygen') * 2493])
// Aluminium Dust * 21
mods.gregtech.macerator.removeByInput(8, [metaitem('pyrolyse_oven')], null)
// Lapotron Crystal * 1
mods.gregtech.assembler.removeByInput(1920, [metaitem('gemLapotron'), metaitem('circuit.advanced_integrated') * 2], null)

//ADDITIONS

//CONSUMES IRON BUCKET ONLY BECAUSE THE OUTPUT IS IN AN IRON BUCKET
crafting.addShapeless('gregtech:salt_water_bucket', item('forge:bucketfilled').withNbt(["FluidName": "salt_water", "Amount": 1000]), [item('minecraft:water_bucket').noreturn(), metaitem('dustSalt'), metaitem('dustSalt')])

RecyclingHelper.replaceShaped('gregtech:large_steel_boiler', metaitem('large_boiler.steel'), [
		[ore('cableGtSingleCopper'), ore('circuitMv'), ore('cableGtSingleCopper')],
		[ore('circuitMv'), item('gregtech:boiler_firebox_casing', 1), ore('circuitMv')],
		[ore('cableGtSingleCopper'), ore('circuitMv'), ore('cableGtSingleCopper')]
])

RecyclingHelper.replaceShaped('gregtech:bronze_primitive_blast_furnace', metaitem('primitive_blast_furnace.bronze'), [
    [ore('craftingToolHardHammer'), ore('stickBronze'), ore('screwBronze')],
    [ore('plateBronze'), item('gregtech:metal_casing:1'), ore('stickBronze')],
    [ore('craftingToolScrewdriver'), ore('stickBronze'), ore('screwBronze')]
])

RecyclingHelper.addShaped('gregtech:high_pressure_latex_extractor', metaitem('latex_collector.steel'), [
        [metaitem('pipeSmallFluidSteel'), metaitem('susy:pump.steam'), metaitem('pipeSmallFluidSteel')],
        [metaitem('plateSteel'), metaitem('latex_collector.bronze'), metaitem('plateSteel')],
        [metaitem('plateWroughtIron'), metaitem('plateWroughtIron'), metaitem('plateWroughtIron')]
])

RecyclingHelper.replaceShaped('gregtech:steam_macerator_bronze', metaitem('steam_macerator_bronze'), [
    [metaitem('toolHeadBuzzSawSteel'), metaitem('pipeSmallFluidBronze'), metaitem('toolHeadBuzzSawSteel')],
    [metaitem('pipeSmallFluidBronze'), item('gregtech:steam_casing'), metaitem('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), metaitem('pipeSmallFluidBronze'), metaitem('steam.piston')]
])

RecyclingHelper.replaceShaped('gregtech:coke_oven', metaitem('coke_oven'), [
    [item('gregtech:metal_casing:8'), ore('plateBronze'), item('gregtech:metal_casing:8')],
    [ore('plateBronze'), ore('craftingToolWrench'), ore('plateBronze')],
    [item('gregtech:metal_casing:8'), ore('plateBronze'), item('gregtech:metal_casing:8')]
])

RecyclingHelper.replaceShaped('gregtech:wooden_barrel', metaitem('drum.wood'), [
    [ore('craftingToolSoftHammer'), metaitem('rubber_drop'), ore('craftingToolSaw')],
    [ore('plankWood'), ore('stickLongBronze'), ore('plankWood')],
    [ore('plankWood'), ore('stickLongBronze'), ore('plankWood')]
])

crafting.addShaped("pig_iron_tiny_pile_manual", metaitem('dustTinyPigIron'), [
        [ore('craftingToolHardHammer'), null],
        [null, metaitem('nuggetPigIron')]
]);

//Steam Piston

RecyclingHelper.addShaped("gregtech:steam_piston", metaitem('steam.piston'), [
    [ore('plateBronze'), ore('plateBronze'), ore('plateBronze')],
    [ore('pipeTinyFluidBronze'), ore('stickBronze'), ore('stickBronze')],
    [ore('pipeTinyFluidBronze'), ore('craftingToolHardHammer'), ore('gearSmallBronze')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateBronze') * 3)
        .inputs(ore('stickBronze') * 2)
        .inputs(ore('gearSmallBronze') * 1)
        .inputs(ore('pipeTinyFluidBronze') * 2)
        .outputs(metaitem('steam.piston'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//Steam Motor

RecyclingHelper.addShaped("gregtech:steam_motor", metaitem('steam.motor'), [
    [ore('plateBronze'), ore('stickBronze'), ore('plateBronze')],
    [metaitem('gearSmallBronze'), ore('stickBronze'), metaitem('gearSmallBronze')],
    [metaitem('steam.piston'), ore('stickBronze'), metaitem('steam.piston')]
]);

RecyclingHelper.addShaped("gregtech:steam_conveyor", metaitem('susy:conveyor.steam'), [
    [ore('plateRubber'), ore('plateRubber'), ore('plateRubber')],
    [metaitem('steam.motor'), ore('gearSmallBronze'), metaitem('steam.motor')],
    [ore('plateRubber'), ore('plateRubber'), ore('plateRubber')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateBronze') * 2)
        .inputs(ore('stickBronze') * 3)
        .inputs(ore('gearSmallBronze') * 2)
        .inputs(metaitem('steam.piston') * 2)
        .outputs(metaitem('steam.motor'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

RecyclingHelper.addShaped("gregtech:steam_pump", metaitem('susy:pump.steam'), [
    [ore('screwBronze'), ore('rotorBronze'), ore('ringIron')],
    [ore('toolScrewdriver'), ore('pipeTinyFluidBronze'), ore('toolWrench')],
    [ore('ringIron'), metaitem('steam.motor'), ore('pipeTinyFluidBronze')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('screwBronze'))
        .inputs(ore('rotorBronze'))
        .inputs(ore('ringIron')*2)
        .inputs(metaitem('steam.motor'))
        .inputs(ore('pipeTinyFluidBronze') * 2)
        .outputs(metaitem('susy:pump.steam'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//Steam Conveyor (no recipe for now)


RecyclingHelper.replaceShaped("gregtech:steam_extractor_bronze", metaitem('steam_extractor_bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), item('gregtech:steam_casing'), ore('blockGlass')],
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

RecyclingHelper.replaceShaped("gregtech:steam_vacuum_chamber", metaitem('vacuum_chamber.bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('susy:pump.steam'), item('gregtech:steam_casing'), ore('blockGlass')],
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

RecyclingHelper.replaceShaped("gregtech:steam_compressor_bronze", metaitem('steam_compressor_bronze'), [
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
    [metaitem('steam.piston'), item('gregtech:steam_casing'), metaitem('steam.piston')],
    [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

RecyclingHelper.replaceShaped("gregtech:steam_hammer_bronze", metaitem('steam_hammer_bronze'), [
    [ore('pipeSmallFluidBronze'), metaitem('steam.piston'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')],
    [ore('pipeSmallFluidBronze'), ore('craftingAnvil'), ore('pipeSmallFluidBronze')]
])

RecyclingHelper.replaceShaped("gregtech:steam_rock_breaker_bronze", metaitem('steam_rock_breaker_bronze'), [
    [metaitem('steam.piston'), ore('pipeSmallFluidBronze'), metaitem('steam.piston')],
    [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing'), ore('pipeSmallFluidBronze')],
    [ore('gemDiamond'), ore('pipeSmallFluidBronze'), ore('gemDiamond')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.lathe.lv", metaitem('gregtech:lathe.lv'), [
    [metaitem('cableGtSingleTin'),  ore('circuitLv'), metaitem('cableGtSingleTin')],
    [metaitem('electric.motor.lv'), metaitem('gregtech:hull.lv'), metaitem('toolHeadDrillSteel')],
    [ore('circuitLv'), metaitem('cableGtSingleTin'), metaitem('electric.piston.lv')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.macerator.lv", metaitem('gregtech:macerator.lv'), [
    [metaitem('electric.piston.lv'), metaitem('electric.motor.lv') , metaitem('toolHeadBuzzSawSteel')],
    [metaitem('cableGtSingleTin'), metaitem('cableGtSingleTin'), metaitem('gregtech:hull.lv')],
    [ore('circuitLv'), ore('circuitLv'), metaitem('cableGtSingleTin')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.cutter.lv", metaitem('gregtech:cutter.lv'), [
    [metaitem('cableGtSingleTin'), ore('circuitLv'), ore('blockGlass')],
	[metaitem('conveyor.module.lv'), metaitem('gregtech:hull.lv'), metaitem('toolHeadBuzzSawSteel')],
	[ore('circuitLv'), metaitem('cableGtSingleTin'), metaitem('electric.motor.lv')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.cutter.mv", metaitem('gregtech:cutter.mv'), [
    [metaitem('cableGtSingleCopper'), ore('circuitMv'), ore('blockGlass')],
	[metaitem('conveyor.module.mv'), metaitem('gregtech:hull.mv'), metaitem('toolHeadBuzzSawAluminium')],
	[ore('circuitMv'), metaitem('cableGtSingleCopper'), metaitem('electric.motor.mv')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.cutter.hv", metaitem('gregtech:cutter.hv'), [
    [metaitem('cableGtSingleGold'), ore('circuitHv'), item('gregtech:transparent_casing')],
	[metaitem('conveyor.module.hv'), metaitem('gregtech:hull.hv'), metaitem('toolHeadBuzzSawVanadiumSteel')],
	[ore('circuitHv'), metaitem('cableGtSingleGold'), metaitem('electric.motor.hv')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.electrolyzer.lv", metaitem('gregtech:electrolyzer.lv'), [
		[metaitem('wireGtSingleSilver'), ore('blockGlass'), metaitem('wireGtSingleSilver')],
		[metaitem('wireGtSingleSilver'), metaitem('gregtech:hull.lv'), metaitem('wireGtSingleSilver')],
		[ore('circuitLv'), metaitem('cableGtSingleTin'), ore('circuitLv')]
])

RecyclingHelper.replaceShaped("gregtech:gregtech.machine.electrolyzer.mv", metaitem('gregtech:electrolyzer.mv'), [
		[metaitem('wireGtSingleGold'), ore('blockGlass'), metaitem('wireGtSingleGold')],
		[metaitem('wireGtSingleGold'), metaitem('gregtech:hull.mv'), metaitem('wireGtSingleGold')],
		[ore('circuitMv'), metaitem('cableGtSingleCopper'), ore('circuitMv')]
])

// Steam machine recipes (due to furnace removal)
RecyclingHelper.replaceShaped("gregtech:steam_boiler_coal_bronze", item('gregtech:machine', 1), [
        [ore('plateBronze'), ore('plateBronze'), ore('plateBronze')],
        [ore('plateBronze'), ore('toolWrench'), ore('plateBronze')],
        [ore('blockBrick'), ore('blockBrick'), ore('blockBrick')]
])

RecyclingHelper.replaceShaped("gregtech:steam_boiler_coal_steel", item('gregtech:machine', 2), [
        [ore('plateSteel'), ore('plateSteel'), ore('plateSteel')],
        [ore('plateSteel'), ore('toolWrench'), ore('plateSteel')],
        [ore('blockBrick'), ore('blockBrick'), ore('blockBrick')]
])

RecyclingHelper.replaceShaped("gregtech:steam_furnace_bronze", item('gregtech:machine', 15), [
        [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
        [ore('pipeSmallFluidBronze'), ore('plateBronze'), ore('pipeSmallFluidBronze')],
        [ore('pipeSmallFluidBronze'), item('gregtech:steam_casing', 1), ore('pipeSmallFluidBronze')]
])

RecyclingHelper.replaceShaped("gregtech:steam_alloy_smelter_bronze", item('gregtech:machine', 17), [
        [ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')],
        [ore('plateBronze'), item('gregtech:steam_casing', 1),  ore('plateBronze')],
		[ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze'), ore('pipeSmallFluidBronze')]
])

// Multi smelter recipe (due to furnace removal)
RecyclingHelper.replaceShaped("gregtech:multi_furnace", item('gregtech:machine', 1006), [
		[ore('frameGtInvar'), ore('frameGtInvar'), ore('frameGtInvar')],
		[ore('circuitHv'), item('gregtech:metal_casing', 2),  ore('circuitHv')],
		[ore('cableGtSingleCopper'), ore('circuitHv'), ore('cableGtSingleCopper')]
])

// crafting.addShaped("rubber_rod_manual", metaitem('stickRubber'), [
//     [ore('craftingToolFile'), null, null],
//     [null, ore('ingotRubber'), null],
//     [null, null, null]
// ]);

//Manual chad for early paper

// ModHandler.addShapedRecipe("manual_chad", metaitem('dustPaper'), 
//     new UnificationEntry(OrePrefix.dust, Materials.Wood), 
//     new UnificationEntry(OrePrefix.dust, Materials.Wood),
//     item('minecraft:water_bucket')
// );

// mods.gregtech.alloy_smelter.recipeBuilder()
//         .inputs(ore('dustRawRubber') * 6)
//         .inputs(ore('dustSulfur'))
//         .outputs(metaitem('dustRubber'))
//         .duration(400)
//         .EUt(7)
//         .buildAndRegister();

//TechGuns carbon plate removal
// Carbon Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('carbon') * 144])

//Remove old rubber recipes
// Rubber Bar * 1
mods.gregtech.alloy_smelter.removeByInput(7, [metaitem('dustSulfur'), metaitem('dustRawRubber') * 3], null)

//Remove Magic

// Item Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('screwSteel') * 2, metaitem('cover.item.detector'), metaitem('pipeNormalItemBrass'), item('minecraft:ender_pearl')], null)
// Fluid Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('screwSteel') * 2, metaitem('cover.fluid.detector'), metaitem('pipeNormalFluidBronze'), item('minecraft:ender_pearl')], null)
// Infinite Water Cover * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('electric.pump.hv') * 2, item('minecraft:cauldron'), metaitem('circuit.assembly')], null)
// Advanced Fluid Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cover.fluid.voiding'), metaitem('circuit.processor')], null)
// Advanced Item Voiding Cover * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('cover.item.voiding'), metaitem('circuit.processor')], null)
// Ender Fluid Link Cover * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('plateEnderPearl') * 9, metaitem('plateDoubleStainlessSteel'), metaitem('sensor.hv'), metaitem('emitter.hv'), metaitem('electric.pump.hv')], [fluid('plastic') * 288])

//Slaked Lime

crafting.addShapeless('convert_old_slaked_lime', metaitem('dustCalciumHydroxide'), [metaitem('slaked_lime')])

mods.gregtech.mixer.recipeBuilder()
        .inputs(ore('dustQuicklime') * 2)
        .circuitMeta(1)
        .fluidInputs(fluid('water') * 1000)
        .outputs(metaitem('dustCalciumHydroxide') * 5)
        .duration(20)
        .EUt(30)
        .buildAndRegister();

//Iron III chloride

mods.gregtech.fluid_solidifier.recipeBuilder()
        .fluidInputs(fluid('iron_iii_chloride') * 144)
        .outputs(metaitem('dustIronIiiChloride') * 1)
        .duration(30)
        .EUt(16)
        .buildAndRegister();

//Lava

mods.gregtech.fluid_solidifier.recipeBuilder()
        .fluidInputs(fluid('chilled_lava') * 1000)
        .notConsumable(metaitem('shape.mold.block'))
        .outputs(item('minecraft:obsidian') * 1)
        .duration(210)
        .EUt(16)
        .buildAndRegister();

//Coils

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('lava') * 1000)
        .notConsumable(metaitem('stickSteel'))
        .outputs(metaitem('mineral_wool') * 16)
        .duration(500)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('chilled_lava') * 1000)
        .notConsumable(ore('stickSteel'))
        .outputs(metaitem('mineral_wool') * 16)
        .duration(400)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('tin_alloy') * 144)
        .inputs(ore('wireGtDoubleCupronickel') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(ore('foilBronze') * 8)
        .outputs(item('gregtech:wire_coil'))
        .duration(200)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('copper') * 144)
        .inputs(ore('wireGtDoubleKanthal') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(ore('foilAluminium') * 8)
        .outputs(item('gregtech:wire_coil', 1))
        .duration(300)
        .EUt(120)
        .buildAndRegister();

mods.gregtech.assembler.recipeBuilder()
        .fluidInputs(fluid('aluminium') * 144)
        .inputs(ore('wireGtDoubleNichrome') * 8)
        .inputs(metaitem('mineral_wool') * 8)
        .inputs(ore('foilStainlessSteel') * 8)
        .outputs(item('gregtech:wire_coil', 2))
        .duration(400)
        .EUt(480)
        .buildAndRegister();

//Cleanroom Filter Casings

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plateSteel') * 4)
        .inputs(ore('foilAluminium') * 8)
        .inputs(ore('foilPolypropylene') * 8)
        .outputs(metaitem('hepa_filter'))
        .duration(80)
        .EUt(120)
        .buildAndRegister();

RecyclingHelper.replaceShaped('gregtech:filter_casing', item('gregtech:cleanroom_casing', 1) * 2, [
        [item('minecraft:iron_bars'), item('minecraft:iron_bars'), item('minecraft:iron_bars')],
        [metaitem('electric.motor.mv'), metaitem('rotorSteel'), metaitem('electric.pump.mv')],
        [metaitem('frameSteel'), metaitem('hepa_filter'), metaitem('frameSteel')]
])

//Beds

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('stickLongWood') * 4)
        .inputs(ore('plateWood') * 8)
        .inputs(ore('platePolyurethane') * 16)
        .inputs(ore('threadRayon') * 64)
        .inputs(ore('springSmallSteel') * 8)
        .outputs(item('minecraft:bed'))
        .duration(400)
        .EUt(960)
        .buildAndRegister();

//Lights

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('cableGtSingleTin') * 2)
        .inputs(metaitem('graphite_electrode'))
        .inputs(metaitem('component.glass.tube') * 8)
        .outputs(metaitem('carbon_arc_lamp') * 8)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

//Ore Recipes

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block'))
        .outputs(metaitem('crushedBauxite') * 4)
        .chancedOutput(metaitem('dustStone'), 6700, 800)
        .duration(400)
        .EUt(2)
        .buildAndRegister();

//Mud

mods.gregtech.centrifuge.recipeBuilder()
        .fluidInputs(fluid('mud') * 1000)
        .chancedOutput(item('minecraft:clay'), 2500, 250)
        .chancedOutput(item('minecraft:sand'), 2500, 250)
        .chancedOutput(item('minecraft:gravel'), 2500, 250)
        .chancedOutput(metaitem('dustLimestone'), 2500, 250)
        .duration(20)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.fluid_solidifier.recipeBuilder()
        .fluidInputs(fluid('mud') * 250)
        .notConsumable(metaitem('shape.mold.ball'))
        .outputs(item('biomesoplenty:mudball') * 1)
        .duration(40)
        .EUt(4)
        .buildAndRegister();

// Home block
crafting.replaceShaped('susy:home_block', item('susy:home_block'), [
        [null, null, null],
        [ore('toolHammer'), ore('stoneSmooth'), null],
        [null, null, null]
])

crafting.addShapeless('susy:home_block_1', item('susy:home_block', 4), [item('susy:home_block', 0)])
crafting.addShapeless('susy:home_block_2', item('susy:home_block', 8), [item('susy:home_block', 4)])
crafting.addShapeless('susy:home_block_3', item('susy:home_block', 12), [item('susy:home_block', 8)])
crafting.addShapeless('susy:home_block_4', item('susy:home_block', 0), [item('susy:home_block', 12)])

// Inter-conversion using Chisel
mods.chisel.carving.addGroup("home_blocks")
mods.chisel.carving.addVariation("home_blocks", item('susy:home_block', 0))
mods.chisel.carving.addVariation("home_blocks", item('susy:home_block', 4))
mods.chisel.carving.addVariation("home_blocks", item('susy:home_block', 8))
mods.chisel.carving.addVariation("home_blocks", item('susy:home_block', 12))

// Acetone * 200
mods.gregtech.fluid_heater.removeByInput(30, [metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('dissolved_calcium_acetate') * 200])

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustPegmatiteTailings') * 3)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(item('minecraft:emerald'), 1000, 250)
        .chancedOutput(metaitem('gemTourmaline'), 1000, 250)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustGraniteTailings') * 3)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustLimestoneTailings') * 3)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .chancedOutput(metaitem('dustLimestone'), 5000, 500)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustUltramaficTailings') * 3)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustQuartzite'), 5000, 500)
        .chancedOutput(metaitem('dustMagnesia'), 2000, 500)
        .chancedOutput(metaitem('dustMagnetite'), 1000, 500)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustKimberlite'))
        .chancedOutput(metaitem('dustUltramaficTailings'), 7500, 500)
        .chancedOutput(item('minecraft:diamond'), 1000, 500)
        .chancedOutput(metaitem('gemPyrope'), 500, 250)
        .chancedOutput(metaitem('gemAlmandine'), 500, 250)
        .chancedOutput(item('minecraft:dye', 4), 500, 250)
        .chancedOutput(metaitem('dustChromite'), 500, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustCorundum'))
        .chancedOutput(metaitem('dustUltramaficTailings'), 7500, 500)
        .chancedOutput(metaitem('gemRuby'), 1000, 250)
        .chancedOutput(metaitem('gemSapphire'), 1000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 2))
        .outputs(metaitem('dustNonMarineEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 4))
        .outputs(metaitem('dustSulfateEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 5))
        .outputs(metaitem('dustCarbonateEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 3))
        .outputs(metaitem('dustHalideEvaporite') * 4)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 12))
        .outputs(metaitem('dustPhosphorite') * 8)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('susy:resource_block', 13))
        .outputs(metaitem('dustPotashConcentrate') * 8)
        .duration(240)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
		.inputs(item('susy:resource_block', 14))
		.outputs(metaitem('dustSulfur') * 8)
		.duration(240)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
		.inputs(item('susy:resource_block', 15))
		.outputs(metaitem('dustCoal') * 8)
		.duration(240)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
		.inputs(item('susy:resource_block', 15))
		.outputs(item('minecraft:coal') * 8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
		.inputs(item('susy:resource_block_1'))
		.outputs(metaitem('dustCopper') * 8)
		.duration(240)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
		.inputs(item('susy:resource_block_1', 1))
		.outputs(metaitem('gemAnthracite') * 8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
		.inputs(item('susy:resource_block_1', 1))
		.outputs(metaitem('dustAnthracite') * 8)
		.duration(240)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
		.inputs(item('susy:resource_block_1', 2))
		.outputs(metaitem('gemLignite') * 8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
		.inputs(item('susy:resource_block_1', 2))
		.outputs(metaitem('dustLignite') * 8)
		.duration(240)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
		.inputs(metaitem('native_copper'))
		.outputs(metaitem('dustCopper'))
		.duration(30)
		.EUt(7)
		.buildAndRegister();

mods.gregtech.forge_hammer.recipeBuilder()
		.inputs(item('susy:resource_block_1'))
		.outputs(metaitem('native_copper') * 8)
		.duration(10)
		.EUt(16)
		.buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustNonMarineEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustBorax'), 7000, 250)
        .chancedOutput(metaitem('dustTrona'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustSulfateEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustGypsum'), 5000, 250)
        .chancedOutput(metaitem('dustKieserite'), 5000, 250)
        .chancedOutput(metaitem('dustLangbeinite'), 5000, 250)
        .chancedOutput(metaitem('dustPolyhalite'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustCarbonateEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustDolomite'), 5000, 250)
        .chancedOutput(metaitem('dustCalcite'), 5000, 250)
        .chancedOutput(metaitem('dustMagnesite'), 5000, 250)
        .chancedOutput(metaitem('dustTrona'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.sifter.recipeBuilder()
        .inputs(ore('dustHalideEvaporite'))
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustSalt'), 8000, 500)
        .chancedOutput(metaitem('dustCarnallite'), 7000, 250)
        .chancedOutput(metaitem('dustKainite'), 5000, 250)
        .duration(60)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.centrifuge.recipeBuilder()
        .inputs(ore('dustLimestone'))
        .outputs(metaitem('dustCalcite'))
        .duration(40)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.packer.recipeBuilder()
        .inputs(item('minecraft:sand'))
        .outputs(metaitem('sand.dust') * 4)
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.packer.recipeBuilder()
        .inputs(metaitem('sand.dust') * 4)
        .outputs(item('minecraft:sand'))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

RecyclingHelper.removeRecyclingRecipes(metaitem('fluid_filter'))

RecyclingHelper.addShaped('gregtech:fluid_filter_brass', metaitem('fluid_filter'), [
        [ore('foilZinc'), ore('foilZinc'), ore('foilZinc')],
        [ore('foilZinc'), ore('plateBrass'), ore('foilZinc')],
        [ore('foilZinc'), ore('foilZinc'), ore('foilZinc')]
])

// SuSy drums
RecyclingHelper.addShaped("drum_lead", metaitem('drum.lead'), [
		[null,ore('craftingToolHardHammer'),null],
		[metaitem('plateLead'),metaitem('stickLongLead'),metaitem('plateLead')],
		[metaitem('plateLead'),metaitem('stickLongLead'),metaitem('plateLead')]
])

RecyclingHelper.addShaped('gregtech:brass_drum', metaitem('drum.brass'), [
		[null, ore('craftingToolHardHammer'), null],
		[metaitem('plateBrass'), metaitem('stickLongBrass'), metaitem('plateBrass')],
		[metaitem('plateBrass'), metaitem('stickLongBrass'), metaitem('plateBrass')]
])

RecyclingHelper.handleRecycling(metaitem('drum.pe'), [metaitem('platePlastic') * 6])

RecyclingHelper.handleRecycling(metaitem('drum.pp'), [metaitem('platePolypropylene') * 6])

RecyclingHelper.handleRecycling(metaitem('drum.ptfe'), [metaitem('platePolytetrafluoroethylene') * 6])

RecyclingHelper.handleRecycling(metaitem('drum.uhmwpe'), [metaitem('plateUltraHighMolecularWeightPolyethylene') * 6])

//ModHandler.addShapelessNBTClearingRecipe("drum_nbt_lead", metaitem('drum.lead'),
//		metaitem('drum.lead')
//)
//ModHandler.addShapelessNBTClearingRecipe("drum_nbt_brass", metaitem('drum.brass'),
//		metaitem('drum.brass')
//)

// ModHandler.addShapelessNBTClearingRecipe() is not reloadable, just using these seems fine, and we indeed have tooltips.
crafting.addShapeless("drum_nbt_lead", metaitem('drum.lead'), [
		metaitem('drum.lead').noreturn()
]);

crafting.addShapeless("drum_nbt_brass", metaitem('drum.brass'), [
		metaitem('drum.brass').noreturn()
]);

crafting.addShapeless("drum_nbt_pe", metaitem('drum.pe'), [
		metaitem('drum.pe').noreturn()
]);

crafting.addShapeless("drum_nbt_pp", metaitem('drum.pp'), [
		metaitem('drum.pp').noreturn()
]);

crafting.addShapeless("drum_nbt_ptfe", metaitem('drum.ptfe'), [
		metaitem('drum.ptfe').noreturn()
]);

crafting.addShapeless("drum_nbt_uhmwpe", metaitem('drum.uhmwpe'), [
		metaitem('drum.uhmwpe').noreturn()
]);

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('stickLongLead') * 2)
		.inputs(ore('plateLead') * 4)
		.outputs(metaitem('drum.lead'))
		.duration(200)
		.EUt(16)
		.circuitMeta(2)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(ore('stickLongBrass') * 2)
		.inputs(ore('plateBrass') * 4)
		.outputs(metaitem('drum.brass'))
		.duration(200)
		.EUt(16)
		.circuitMeta(2)
		.buildAndRegister()

mods.gregtech.extruder.recipeBuilder()
		.notConsumable(metaitem('shape.extruder.cell'))
		.fluidInputs(fluid('plastic') * 864)
		.outputs(metaitem('drum.pe'))
		.duration(200)
		.EUt(16)
		.buildAndRegister()

mods.gregtech.extruder.recipeBuilder()
		.notConsumable(metaitem('shape.extruder.cell'))
		.fluidInputs(fluid('polypropylene') * 864)
		.outputs(metaitem('drum.pp'))
		.duration(200)
		.EUt(16)
		.buildAndRegister()

mods.gregtech.extruder.recipeBuilder()
		.notConsumable(metaitem('shape.extruder.cell'))
		.fluidInputs(fluid('polytetrafluoroethylene') * 864)
		.outputs(metaitem('drum.ptfe'))
		.duration(200)
		.EUt(16)
		.buildAndRegister()

mods.gregtech.extruder.recipeBuilder()
		.notConsumable(metaitem('shape.extruder.cell'))
		.fluidInputs(fluid('ultra_high_molecular_weight_polyethylene') * 864)
		.outputs(metaitem('drum.uhmwpe'))
		.duration(200)
		.EUt(16)
		.buildAndRegister()

// Logistics
RecyclingHelper.addShaped('gregtech:extender.inv', metaitem('extender.inv'), [
		[null, ore('craftingToolHardHammer'), metaitem('pipeNormalItemNickel')],
		[null, metaitem('hull.lv'), null],
		[metaitem('pipeNormalItemNickel'), ore('craftingToolWrench'), null]
])

RecyclingHelper.addShaped('gregtech:extender.tank', metaitem('extender.tank'), [
		[metaitem('pipeNormalFluidSteel'), ore('craftingToolHardHammer'), null],
		[null, metaitem('hull.lv'), null],
		[null, ore('craftingToolWrench'), metaitem('pipeNormalFluidSteel')]
])

RecyclingHelper.addShaped('gregtech:extender.inv_tank', metaitem('extender.inv_tank'), [
		[metaitem('pipeNormalFluidSteel'), ore('craftingToolHardHammer'), metaitem('pipeNormalItemNickel')],
		[null, metaitem('hull.lv'), null],
		[metaitem('pipeNormalItemNickel'), ore('craftingToolWrench'), metaitem('pipeNormalFluidSteel')]
])

RecyclingHelper.addShaped('gregtech:extender.universal', metaitem('extender.universal'), [
		[metaitem('pipeNormalFluidAluminium'), ore('rotorAluminium'), metaitem('pipeNormalItemElectrum')],
		[ore('circuitLv'), metaitem('hull.mv'), ore('gearAluminium')],
		[metaitem('pipeNormalItemElectrum'), ore('springAluminium'), metaitem('pipeNormalFluidAluminium')]
])

RecyclingHelper.addShaped('gregtech:bridge.inv', metaitem('bridge.inv'), [
		[ore('craftingToolHardHammer'), metaitem('pipeNormalItemNickel'), null],
		[null, metaitem('hull.lv'), null],
		[null, metaitem('pipeNormalItemNickel'), ore('craftingToolWrench')]
])

RecyclingHelper.addShaped('gregtech:bridge.tank', metaitem('bridge.tank'), [
		[ore('craftingToolHardHammer'), null, null],
		[metaitem('pipeNormalFluidSteel'), metaitem('hull.lv'), metaitem('pipeNormalFluidSteel')],
		[null, null, ore('craftingToolWrench')]
])

RecyclingHelper.addShaped('gregtech:bridge.inv_tank', metaitem('bridge.inv_tank'), [
		[ore('craftingToolHardHammer'), metaitem('pipeNormalItemNickel'), null],
		[metaitem('pipeNormalFluidSteel'), metaitem('hull.lv'), metaitem('pipeNormalFluidSteel')],
		[null, metaitem('pipeNormalItemNickel'), ore('craftingToolWrench')]
])

RecyclingHelper.addShaped('gregtech:bridge.universal', metaitem('bridge.universal'), [
		[ore('springAluminium'), metaitem('pipeNormalItemElectrum'), ore('rotorAluminium')],
		[metaitem('pipeNormalFluidAluminium'), metaitem('hull.mv'), metaitem('pipeNormalFluidAluminium')],
		[ore('circuitLv'), metaitem('pipeNormalItemElectrum'), ore('gearAluminium')]
])

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalItemNickel') * 2)
		.inputs(metaitem('hull.lv'))
		.outputs(metaitem('extender.inv'))
		.duration(200)
		.EUt(16)
		.circuitMeta(2)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalFluidSteel') * 2)
		.inputs(metaitem('hull.lv'))
		.outputs(metaitem('extender.tank'))
		.duration(200)
		.EUt(16)
		.circuitMeta(2)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalItemNickel') * 2)
		.inputs(metaitem('pipeNormalFluidSteel') * 2)
		.inputs(metaitem('hull.lv'))
		.outputs(metaitem('extender.inv_tank'))
		.duration(200)
		.EUt(16)
		.circuitMeta(3)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalItemElectrum') * 2)
		.inputs(metaitem('pipeNormalFluidAluminium') * 2)
		.inputs(ore('rotorAluminium'))
		.inputs(ore('gearAluminium'))
		.inputs(ore('springAluminium'))
		.inputs(metaitem('hull.mv'))
		.outputs(metaitem('extender.universal'))
		.duration(200)
		.EUt(64)
		.circuitMeta(3)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalItemNickel') * 2)
		.inputs(metaitem('hull.lv'))
		.outputs(metaitem('bridge.inv'))
		.duration(200)
		.EUt(16)
		.circuitMeta(4)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalFluidSteel') * 2)
		.inputs(metaitem('hull.lv'))
		.outputs(metaitem('bridge.tank'))
		.duration(200)
		.EUt(16)
		.circuitMeta(4)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalItemNickel') * 2)
		.inputs(metaitem('pipeNormalFluidSteel') * 2)
		.inputs(metaitem('hull.lv'))
		.outputs(metaitem('bridge.inv_tank'))
		.duration(200)
		.EUt(16)
		.circuitMeta(5)
		.buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('pipeNormalItemElectrum') * 2)
		.inputs(metaitem('pipeNormalFluidAluminium') * 2)
		.inputs(ore('rotorAluminium'))
		.inputs(ore('gearAluminium'))
		.inputs(ore('springAluminium'))
		.inputs(metaitem('hull.mv'))
		.outputs(metaitem('bridge.universal'))
		.duration(200)
		.EUt(64)
		.circuitMeta(5)
		.buildAndRegister()

// Electrolytic Cell
RecyclingHelper.addShaped('gregtech:electrolytic_cell', metaitem('electrolytic_cell'), [
        [ore('plateSteel'), ore('circuitLv'), ore('plateSteel')],
        [ore('wireGtQuadrupleTin'), metaitem('hull.lv'), ore('wireGtQuadrupleTin')],
        [ore('circuitLv'), ore('cableGtSingleTin'), ore('circuitLv')]
])

// Prospector
crafting.addShaped('gregtech:prospector_lead_acid', metaitem('prospector.lv'), [
        [metaitem('emitter.lv'), ore('plateSteel'), metaitem('sensor.lv')],
        [ore('circuitLv'), ore('plateGlass'), ore('circuitLv')],
        [ore('plateSteel'), metaitem('battery.lead_acid'), ore('plateSteel')]
])

LATEX_COLLECTOR = recipemap('latex_collector')

LATEX_COLLECTOR.recipeBuilder()
        .notConsumable(fluid('water') * 10)
        .fluidOutputs(fluid('latex') * 100)
        .blockStates("latex_logs", MetaBlocks.RUBBER_LOG.getBlockState())
        .duration(20)
        .EUt(7)
        .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
        .notConsumable(fluid('distilled_water') * 10)
        .fluidOutputs(fluid('resin') * 100)
        .blockStates("extractable_logs_1", Blocks.LOG.getBlockState())
        .duration(20)
        .EUt(7)
        .buildAndRegister();

LATEX_COLLECTOR.recipeBuilder()
        .notConsumable(fluid('lubricant') * 10)
        .fluidOutputs(fluid('resin') * 100)
        .blockStates("extractable_logs_2", Blocks.LOG2.getBlockState())
        .duration(20)
        .EUt(7)
        .buildAndRegister();

//TODO: ADD GRAVITY SEPARATOR STUFF
// Construction Foam * 8000
mods.gregtech.mixer.removeByInput(16, [metaitem('dustRawRubber')], [fluid('concrete') * 576])
mods.gregtech.blender.removeByInput(16, [metaitem('dustRawRubber')], [fluid('concrete') * 576])

MIXER.recipeBuilder()
        .inputs(ore('dustRubber'))
        .fluidInputs(fluid('concrete') * 576)
        .fluidOutputs(fluid('construction_foam') * 8000)
        .duration(20)
        .EUt(16)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustAnthracite'))
        .chancedOutput(metaitem('dustCarbon'), 9000, 0)
        .duration(80)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustCoal'))
        .chancedOutput(metaitem('dustCarbon'), 7500, 0)
        .duration(80)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustCharcoal'))
        .chancedOutput(metaitem('dustCarbon'), 6000, 0)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustCoke'))
        .outputs(metaitem('dustCarbon'))
        .duration(60)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustDiamond'))
        .outputs(metaitem('dustCarbon'))
        .duration(40)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustGraphite'))
        .outputs(metaitem('dustCarbon'))
        .duration(40)
        .EUt(30)
        .buildAndRegister();

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustMagnalium') * 3)
        .outputs(metaitem('dustMagnesium'))
        .outputs(metaitem('dustAluminium') * 2)
        .duration(72)
        .EUt(30)
        .buildAndRegister();

// Fix distillation tower being too difficult (4 EV circuits? Seriously?)

RecyclingHelper.replaceShaped('gregtech:distillation_tower', metaitem('distillation_tower'), [
        [ore('circuitHv'), metaitem('pipeLargeFluidStainlessSteel'), ore('circuitHv')],
        [metaitem('electric.pump.hv'), metaitem('hull.mv'), metaitem('electric.pump.hv')],
        [ore('circuitHv'), metaitem('pipeLargeFluidStainlessSteel'), ore('circuitHv')]
])

// Item Magnet with Lead Acid battery

crafting.replaceShaped('gregtech:lv_magnet_lead_acid', metaitem('item_magnet.lv'), [
        [ore('stickSteelMagnetic'), ore('toolWrench'), ore('stickSteelMagnetic')],
        [ore('stickSteelMagnetic'), metaitem('battery.lead_acid'), ore('stickSteelMagnetic')],
        [ore('cableGtSingleTin'), ore('plateSteel'), ore('cableGtSingleTin')]
])

// Power Unit with Lead Acid Battery

crafting.replaceShaped('gregtech:lv_power_unit_lead_acid', metaitem('power_unit.lv'), [
        [ore('screwSteel'), null, ore('toolScrewdriver')],
        [ore('gearSmallSteel'), metaitem('electric.motor.lv'), ore('gearSmallSteel')],
        [ore('plateSteel'), metaitem('battery.lead_acid'), ore('plateSteel')]
])

// Stone oredict stuff

// Stone Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('minecraft:cobblestone')], null)

mods.gregtech.macerator.recipeBuilder()
        .inputs(ore('cobblestone'))
        .outputs(metaitem('dustStone'))
        .duration(98)
        .EUt(2)
        .buildAndRegister();

// Stone Slab * 2
mods.gregtech.cutter.removeByInput(7, [item('minecraft:stone')], [fluid('water') * 4])

mods.gregtech.cutter.recipeBuilder()
        .inputs(ore('stone'))
        .outputs(item('minecraft:stone_slab') * 2)
        .duration(25)
        .EUt(7)
        .buildAndRegister();

// Cobblestone Slab * 2
mods.gregtech.cutter.removeByInput(7, [item('minecraft:cobblestone')], [fluid('water') * 4])

mods.gregtech.cutter.recipeBuilder()
        .inputs(ore('cobblestone'))
        .outputs(item('minecraft:stone_slab', 3) * 2)
        .duration(25)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.gas_collector.recipeBuilder()
        .circuitMeta(4)
        .fluidOutputs(fluid('air') * 10000)
        .dimension(10)
        .duration(200)
        .EUt(16)
        .buildAndRegister();

mods.gregtech.forming_press.recipeBuilder()
        .inputs(item('gregtech:transparent_casing') * 2)
        .inputs(ore('platePolyvinylButyral') * 2)
        .inputs(ore('platePolycarbonate') * 2)
        .outputs(item('gregtech:transparent_casing', 2))
        .duration(200)
        .EUt(480)
        .buildAndRegister();

// Cobblestone * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('minecraft:stone')], null)

mods.gregtech.forming_press.recipeBuilder()
		.inputs(item('minecraft:stone'))
		.outputs(item('minecraft:cobblestone'))
		.duration(10)
		.EUt(16)
		.buildAndRegister();

// Nickel Zinc Ferrite * 864
mods.gregtech.alloy_blast_smelter.removeByInput(120, [metaitem('dustNickel'), metaitem('dustZinc'), metaitem('dustIron') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 6])], [fluid('oxygen') * 8000])
// Molten Yttrium Barium Cuprate * 1872
mods.gregtech.alloy_blast_smelter.removeByInput(7680, [metaitem('dustYttrium'), metaitem('dustBarium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 14])], [fluid('oxygen') * 7000, fluid('argon') * 650])
// Molten Yttrium Barium Cuprate * 1872
mods.gregtech.alloy_blast_smelter.removeByInput(7680, [metaitem('dustYttrium'), metaitem('dustBarium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 7000])

// Molten Mercury Barium Calcium Cuprate * 2304
mods.gregtech.alloy_blast_smelter.removeByInput(480, [metaitem('dustBarium') * 2, metaitem('dustCalcium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 5])], [fluid('mercury') * 1000, fluid('oxygen') * 8000])
// Molten Mercury Barium Calcium Cuprate * 2304
mods.gregtech.alloy_blast_smelter.removeByInput(480, [metaitem('dustBarium') * 2, metaitem('dustCalcium') * 2, metaitem('dustCopper') * 3, metaitem('circuit.integrated').withNbt(["Configuration": 15])], [fluid('mercury') * 1000, fluid('oxygen') * 8000, fluid('nitrogen') * 16000])
// Molten Indium Tin Barium Titanium Cuprate * 2304
mods.gregtech.alloy_blast_smelter.removeByInput(7680, [metaitem('dustIndium') * 4, metaitem('dustTin') * 2, metaitem('dustBarium') * 2, metaitem('dustTitanium'), metaitem('dustCopper') * 7, metaitem('circuit.integrated').withNbt(["Configuration": 16])], [fluid('oxygen') * 14000, fluid('argon') * 800])
// Molten Indium Tin Barium Titanium Cuprate * 2304
mods.gregtech.alloy_blast_smelter.removeByInput(7680, [metaitem('dustIndium') * 4, metaitem('dustTin') * 2, metaitem('dustBarium') * 2, metaitem('dustTitanium'), metaitem('dustCopper') * 7, metaitem('circuit.integrated').withNbt(["Configuration": 6])], [fluid('oxygen') * 14000])
// Molten Samarium Iron Arsenic Oxide * 576
mods.gregtech.alloy_blast_smelter.removeByInput(1920, [metaitem('dustSamarium'), metaitem('dustIron'), metaitem('dustArsenic'), metaitem('circuit.integrated').withNbt(["Configuration": 14])], [fluid('oxygen') * 1000, fluid('helium') * 400])
// Molten Samarium Iron Arsenic Oxide * 576
mods.gregtech.alloy_blast_smelter.removeByInput(1920, [metaitem('dustSamarium'), metaitem('dustIron'), metaitem('dustArsenic'), metaitem('circuit.integrated').withNbt(["Configuration": 4])], [fluid('oxygen') * 1000])

// NAND Chip * 8
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.good'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('soldering_alloy') * 72])
// NAND Chip * 8
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.good'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('tin') * 144])
// NAND Chip * 12
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('soldering_alloy') * 72])
// NAND Chip * 12
mods.gregtech.circuit_assembler.removeByInput(120, [metaitem('circuit_board.plastic'), metaitem('plate.simple_system_on_chip'), metaitem('boltRedAlloy') * 2, metaitem('wireFineTin') * 2], [fluid('tin') * 144])
// Microprocessor * 6
mods.gregtech.circuit_assembler.removeByInput(600, [metaitem('circuit_board.plastic'), metaitem('plate.system_on_chip'), metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('soldering_alloy') * 72])
// Microprocessor * 6
mods.gregtech.circuit_assembler.removeByInput(600, [metaitem('circuit_board.plastic'), metaitem('plate.system_on_chip'), metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('tin') * 144])

Globals.solders.each { key, val ->
        mods.gregtech.circuit_assembler.recipeBuilder()
                .inputs(metaitem('circuit_board.good'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(ore('boltRedAlloy') * 2)
                .inputs(ore('wireFineTin') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.nand_chip') * 16)
                .duration(10)
                .EUt(16)
                .buildAndRegister();
}

Globals.solders.each { key, val ->
        mods.gregtech.circuit_assembler.recipeBuilder()
                .inputs(metaitem('circuit_board.plastic'))
                .inputs(metaitem('plate.integrated_logic_circuit'))
                .inputs(ore('boltRedAlloy') * 2)
                .inputs(ore('wireFineTin') * 2)
                .fluidInputs(fluid(key) * val)
                .outputs(metaitem('circuit.nand_chip') * 24)
                .duration(10)
                .EUt(16)
                .buildAndRegister();
}

Globals.solders.each { key, val ->
	mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('circuit_board.plastic'))
		.inputs(metaitem('plate.central_processing_unit'))
		.inputs(ore('componentResistor') * 2)
		.inputs(ore('componentCapacitor') * 2)
		.inputs(ore('componentTransistor') * 2)
		.inputs(ore('wireFineCopper') * 2)
		.fluidInputs(fluid(key) * val)
		.outputs(metaitem('circuit.microprocessor') * 8)
		.duration(200)
		.EUt(60)
		.buildAndRegister();
}

Globals.solders.each { key, val ->
	mods.gregtech.circuit_assembler.recipeBuilder()
		.inputs(metaitem('circuit_board.plastic'))
		.inputs(metaitem('plate.system_on_chip'))
		.inputs(ore('wireFineCopper') * 2)
		.inputs(ore('boltTin') * 2)
		.fluidInputs(fluid(key) * val)
		.outputs(metaitem('circuit.microprocessor') * 12)
		.duration(50)
		.EUt(600)
		.buildAndRegister();
}


mods.gregtech.centrifuge.recipeBuilder()
		.fluidInputs(fluid('gtfo_soybean_oil') * 1000)
		.fluidOutputs(fluid('seed_oil') * 1000)
		.duration(160)
		.EUt(30)
		.buildAndRegister();2

// Steel Turbine Casing * 2
mods.gregtech.assembler.removeByInput(16, [metaitem('plateMagnalium') * 6, metaitem('frameBlueSteel'), metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)

mods.gregtech.assembler.recipeBuilder()
		.circuitMeta(6)
		.inputs(ore('stickLongSteel') * 2)
		.inputs(ore('plateSteel') * 4)
		.inputs(item('gregtech:stone_smooth', 4))
		.outputs(item('gregtech:turbine_casing', 5) * 4)
		.duration(50)
		.EUt(16)
		.buildAndRegister();

// Ashes * 1
mods.gregtech.centrifuge.removeByInput(6, [metaitem('dustDarkAsh')], null)

mods.gregtech.centrifuge.recipeBuilder()
		.inputs(ore('dustDarkAsh'))
		.outputs(metaitem('dustAsh'))
		.outputs(metaitem('dustCarbon'))
		.duration(100)
		.EUt(6)
		.buildAndRegister();

// Add more semi fluid fuel options
mods.gregtech.semi_fluid_generator.removeByInput(32, null, [fluid('sulfuric_heavy_fuel') * 16])
mods.gregtech.semi_fluid_generator.removeByInput(32, null, [fluid('heavy_fuel') * 8])

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('diesel') * 8)
		.duration(15)
		.EUt(-32)
		.buildAndRegister();

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('sulfuric_heavy_gas_oil') * 16)
		.duration(7)
		.EUt(-32)
		.buildAndRegister();

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('heavy_gas_oil') * 8)
		.duration(21)
		.EUt(-32)
		.buildAndRegister();

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('sulfuric_natural_gas') * 16)
		.duration(4)
		.EUt(-32)
		.buildAndRegister();

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('natural_gas') * 8)
		.duration(12)
		.EUt(-32)
		.buildAndRegister();

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('propane') * 8)
		.duration(15)
		.EUt(-32)
		.buildAndRegister();

mods.gregtech.semi_fluid_generator.recipeBuilder()
		.fluidInputs(fluid('gtfo_stearin') * 8)
		.duration(15)
		.EUt(-32)
		.buildAndRegister();

// Light Concrete * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.block')], [fluid('concrete') * 144])

mods.gregtech.fluid_solidifier.recipeBuilder()
        .notConsumable(metaitem('shape.mold.block'))
        .fluidInputs(fluid('concrete') * 144)
        .outputs(item('gregtech:stone_smooth', 4))
        .duration(20)
        .EUt(7)
        .buildAndRegister();

mods.gregtech.arc_furnace.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 150)
        .inputs(item('gregtech:turbine_casing', 5) * 4)
        .outputs(metaitem('ingotSteel') * 6)
        .outputs(item('gregtech:stone_smooth', 4))
        .duration(150)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('gregtech:turbine_casing', 5) * 4)
        .outputs(metaitem('dustSteel') * 6)
        .outputs(metaitem('dustConcrete'))
        .duration(150)
        .EUt(7)
        .buildAndRegister();
        
// Wireless Digital Interface * 1
mods.gregtech.assembler.removeByInput(480, [metaitem('cover.digital'), metaitem('wireless')], [fluid('plastic') * 144])

// Stainless Steel Ingot * 3
mods.gregtech.arc_furnace.removeByInput(30, [item('gregtech:turbine_casing', 7)], [fluid('oxygen') * 234])
// Titanium Ingot * 3
mods.gregtech.arc_furnace.removeByInput(30, [item('gregtech:turbine_casing', 6)], [fluid('oxygen') * 213])
// Tungstensteel Ingot * 3
mods.gregtech.arc_furnace.removeByInput(30, [item('gregtech:turbine_casing', 8)], [fluid('oxygen') * 426])

// ---------- Multiblock components rebalance ----------

// Solid Steel Machine Casing * 2
mods.gregtech.assembler.removeByInput(16, [metaitem('plateSteel') * 6, metaitem('frameSteel'), metaitem('circuit.integrated').withNbt(["Configuration": 6])], null)

RecyclingHelper.replaceShaped("gregtech:casing_steel_solid", item('gregtech:metal_casing', 4) * 4, [
        [ore('plateSteel'), ore('craftingToolHardHammer'), ore('plateSteel')],
        [ore('plateSteel'), ore('frameGtSteel'), ore('plateSteel')],
        [ore('plateSteel'), ore('craftingToolWrench'), ore('plateSteel')]
])

mods.gregtech.assembler.recipeBuilder()
        .circuitMeta(6)
        .inputs(ore('plateSteel') * 6)
        .inputs(ore('frameGtSteel'))
        .outputs(item('gregtech:metal_casing', 4) * 4)
        .EUt(16)
        .duration(50)
        .buildAndRegister()

//Steel Pipe Casing
RecyclingHelper.replaceShaped("gregtech:casing_steel_pipe", item('gregtech:boiler_casing', 1) * 4, [
        [ore('plateSteel'), ore('pipeNormalFluidSteel'), ore('plateSteel')],
        [ore('pipeNormalFluidSteel'), ore('frameGtSteel'), ore('pipeNormalFluidSteel')],
        [ore('plateSteel'), ore('pipeNormalFluidSteel'), ore('plateSteel')]
])

//Steel Firebox Casing
RecyclingHelper.replaceShaped("gregtech:casing_steel_firebox", item('gregtech:boiler_firebox_casing', 1) * 4, [
        [ore('plateSteel'), ore('stickSteel'), ore('plateSteel')],
        [ore('stickSteel'), ore('frameGtSteel'), ore('stickSteel')],
        [ore('plateSteel'), ore('stickSteel'), ore('plateSteel')]
])

// Tapes
mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('foilPlastic') * 4)
        .fluidInputs(fluid('glue') * 250)
        .outputs(metaitem('basic_tape') * 8)
        .duration(100)
        .EUt(7)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('foilPolypropylene') * 4)
        .fluidInputs(fluid('glue') * 250)
        .outputs(metaitem('basic_tape') * 16)
        .duration(100)
        .EUt(7)
        .buildAndRegister()

// Hatches

// ULV Input Bus * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polybenzimidazole') * 4])

crafting.addShaped("gregtech:item_bus.import.ulv", metaitem('item_bus.import.ulv'), [
		[null, ore('chestWood'), null],
		[null, metaitem('hull.ulv'), null],
		[null, null, null]
])

// ULV Output Bus * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:chest'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polybenzimidazole') * 4])

crafting.addShaped("gregtech:item_bus.export.ulv", metaitem('item_bus.export.ulv'), [
		[null, null, null],
		[null, metaitem('hull.ulv'), null],
		[null, ore('chestWood'), null]
])

// ULV Input Hatch * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 1])], [fluid('polybenzimidazole') * 4])

crafting.addShaped("gregtech:fluid_hatch.import.ulv", metaitem('fluid_hatch.import.ulv'), [
		[null, ore('blockGlass'), null],
		[null, metaitem('hull.ulv'), null],
		[null, null, null]
])

// ULV Output Hatch * 1
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('glue') * 250])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('plastic') * 72])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polytetrafluoroethylene') * 36])
mods.gregtech.assembler.removeByInput(7, [metaitem('hull.ulv'), item('minecraft:glass'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('polybenzimidazole') * 4])

crafting.addShaped("gregtech:fluid_hatch.export.ulv", metaitem('fluid_hatch.export.ulv'), [
		[null, null, null],
		[null, metaitem('hull.ulv'), null],
		[null, ore('blockGlass'), null]
])

// Black Granite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('gregtech:stone_smooth')], null)

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('gregtech:stone_smooth'))
        .outputs(metaitem('dustGraniteBlack'))
        .duration(150)
        .EUt(2)
        .buildAndRegister()

// Red Granite Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('gregtech:stone_smooth', 1)], null)

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('gregtech:stone_smooth',01))
        .outputs(metaitem('dustGraniteRed'))
        .duration(150)
        .EUt(2)
        .buildAndRegister()

// Multiblock Builder

RecyclingHelper.replaceShaped("gregtech:multiblock_builder", metaitem('tool.multiblock_builder'), [
        [ore('craftingToolWrench'), metaitem('robot.arm.ev'), metaitem('field.generator.hv')],
        [ore('screwStainlessSteel'), ore('stickPolytetrafluoroethylene'), metaitem('robot.arm.ev')],
        [ore('stickPolytetrafluoroethylene'), ore('screwStainlessSteel'), ore('craftingToolScrewdriver')]
])

// Glue * 2500
mods.gregtech.mixer.removeByInput(7, null, [fluid('polyvinyl_acetate') * 1000, fluid('methyl_acetate') * 1500])
mods.gregtech.blender.removeByInput(7, null, [fluid('polyvinyl_acetate') * 1000, fluid('methyl_acetate') * 1500])
// Glue * 2500
mods.gregtech.mixer.removeByInput(7, null, [fluid('polyvinyl_acetate') * 1000, fluid('acetone') * 1500])
mods.gregtech.blender.removeByInput(7, null, [fluid('polyvinyl_acetate') * 1000, fluid('acetone') * 1500])

MIXER.recipeBuilder()
        .fluidInputs(fluid('polyvinyl_acetate') * 144)
        .fluidInputs(fluid('methyl_acetate') * 1500)
        .fluidOutputs(fluid('glue') * 1500)
        .duration(50)
        .EUt(7)
        .buildAndRegister();

GroovyUtils.removeRecipesContainingFluid(mods.gregtech.assembler, fluid('polybenzimidazole'))
GroovyUtils.removeRecipesContainingFluid(mods.gregtech.autoclave, fluid('polybenzimidazole'))
GroovyUtils.removeRecipesContainingFluid(mods.gregtech.fluid_solidifier, fluid('polybenzimidazole'))
GroovyUtils.removeRecipesContainingFluid(mods.gregtech.assembly_line, fluid('polybenzimidazole'))

crafting.addShaped('gregtech:electric_jetpack1', metaitem('gregtech:electric_jetpack'), [
    [ore('toolWireCutter'), ore('circuitMv'), ore('toolScrewdriver')],
    [metaitem('power_thruster'), metaitem('battery.re.mv.cadmium'), metaitem('power_thruster')],
    [ore('wireGtDoubleAnnealedCopper'), null, ore('wireGtDoubleAnnealedCopper')]
])

crafting.addShaped('gregtech:electric_jetpack2', metaitem('gregtech:electric_jetpack'), [
    [ore('toolWireCutter'), ore('circuitMv'), ore('toolScrewdriver')],
    [metaitem('power_thruster'), metaitem('battery.re.mv.sodium'), metaitem('power_thruster')],
    [ore('wireGtDoubleAnnealedCopper'), null, ore('wireGtDoubleAnnealedCopper')]
])

crafting.replaceShaped('gregtech:electric_jetpack_advanced', metaitem('advanced_electric_jetpack'), [
    [ore('toolWireCutter'), metaitem('electric_jetpack'), ore('toolScrewdriver')],
    [metaitem('power_thruster_advanced'), metaitem('battery.re.hv.sodium'), metaitem('power_thruster_advanced')],
    [metaitem('wireGtQuadrupleGold'), ore('circuitHv'), metaitem('wireGtQuadrupleGold')]
])

crafting.addShaped('gregtech:electric_jetpack_advanced1', metaitem('advanced_electric_jetpack'), [
    [ore('toolWireCutter'), metaitem('electric_jetpack'), ore('toolScrewdriver')],
    [metaitem('power_thruster_advanced'), metaitem('battery.re.hv.lithium'), metaitem('power_thruster_advanced')],
    [metaitem('wireGtQuadrupleGold'), ore('circuitHv'), metaitem('wireGtQuadrupleGold')]
])

crafting.addShaped('gregtech:electric_jetpack_advanced2', metaitem('advanced_electric_jetpack'), [
    [ore('toolWireCutter'), metaitem('electric_jetpack'), ore('toolScrewdriver')],
    [metaitem('power_thruster_advanced'), metaitem('battery.re.hv.cadmium'), metaitem('power_thruster_advanced')],
    [metaitem('wireGtQuadrupleGold'), ore('circuitHv'), metaitem('wireGtQuadrupleGold')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(ore('plankWood') * 4)
        .inputs(ore('stickIronMagnetic') * 1)
        .inputs(ore('wireFineRedAlloy') * 2)
        .inputs(item('minecraft:leather') * 2)
        .circuitMeta(9)
        .outputs(item('minecraft:noteblock'))
        .duration(100)
        .EUt(30)
        .buildAndRegister();

mods.gregtech.macerator.recipeBuilder()
        .inputs(item('minecraft:noteblock'))
        .outputs(metaitem('dustWood') * 4)
        .outputs(metaitem('dustSmallIron') * 2)
        .outputs(metaitem('dustSmallRedAlloy'))
        .duration(869)
        .EUt(2)
        .buildAndRegister();

// MV Alternate Energy Handling
crafting.addShaped('gregtech:energy_hatch.mv2', item('gregtech:machine', 1212), [
    [null, metaitem('voltage_coil.mv'), null],
    [ore('cableGtSingleCopper'), item('gregtech:machine', 987), ore('cableGtSingleCopper')],
    [null, metaitem('voltage_regulator.mv'), null]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('hull.mv'))
        .inputs(ore('cableGtSingleCopper') * 2)
        .inputs(metaitem('voltage_regulator.mv'))
        .inputs(metaitem('voltage_coil.mv'))
        .outputs(metaitem('energy_hatch.input.mv'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

crafting.addShaped('gregtech:dynamo_hatch.mv2', item('gregtech:machine', 1227), [
    [null, metaitem('voltage_coil.mv'), null],
    [ore('springCopper'), item('gregtech:machine', 987), ore('springCopper')],
    [null, metaitem('voltage_regulator.mv'), null]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('hull.mv'))
        .inputs(ore('springCopper') * 2)
        .inputs(metaitem('voltage_regulator.mv'))
        .inputs(metaitem('voltage_coil.mv'))
        .outputs(metaitem('energy_hatch.output.mv'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

crafting.addShaped('gregtech:transformer.mv2', item('gregtech:machine', 1272), [
    [metaitem('voltage_regulator.mv'), ore('cableGtSingleCopper'), ore('cableGtSingleCopper')],
    [ore('cableGtSingleGold'), item('gregtech:machine', 987), null],
    [metaitem('voltage_regulator.mv'), ore('cableGtSingleCopper'), ore('cableGtSingleCopper')]
])

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('transformer.mv'))
        .inputs(metaitem('energy_hatch.output.mv'))
        .inputs(metaitem('voltage_regulator.mv'))
        .inputs(metaitem('voltage_coil.mv'))
        .inputs(ore('cableGtQuadrupleCopper') * 2)
        .outputs(metaitem('energy_hatch.output_4a.mv'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('transformer.adjustable.mv'))
        .inputs(metaitem('energy_hatch.output_4a.mv'))
        .inputs(metaitem('voltage_regulator.mv') * 2)
        .inputs(metaitem('voltage_coil.mv'))
        .inputs(ore('cableGtOctalCopper') * 2)
        .outputs(metaitem('energy_hatch.output_16a.mv'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()
// Jet Wingpack recipes
// Wing panel
mods.gregtech.autoclave.recipeBuilder()
		.notConsumable(metaitem('shape.mold.plate'))
		.notConsumable(ore('foilPolyethyleneTerephthalate'))
		.fluidInputs(fluid('reinforced_epoxy_resin') * 288)
		.outputs(metaitem('wing_panel.fiber_reinforced_epoxy'))
		.duration(600)
		.EUt(480)
		.buildAndRegister()

RecyclingHelper.handleRecycling(metaitem('wing_panel.fiber_reinforced_epoxy'), [
		ore('ingotReinforcedEpoxyResin') * 2
])

// Small wing
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('wing_panel.fiber_reinforced_epoxy') * 2)
		.inputs(ore('boltTitanium') * 8)
		.inputs(ore('plateTitanium') * 2)
		.circuitMeta(3)
		.outputs(metaitem('wing.small'))
		.duration(100)
		.EUt(480)
		.buildAndRegister();

RecyclingHelper.handleRecycling(metaitem('wing.small'), [
		metaitem('wing_panel.fiber_reinforced_epoxy') * 2,
		ore('boltTitanium') * 8,
		ore('plateTitanium') * 2
])

// Small turbojet
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('rotorRene') * 4)
		.inputs(ore('stickLongTitanium'))
		.inputs(ore('plateTitanium') * 2)
		.inputs(ore('boltTitanium') * 4)
		.inputs(metaitem('pipeTinyFluidTitanium') * 8)
		.circuitMeta(5)
		.outputs(metaitem('turbojet.small'))
		.duration(100)
		.EUt(480)
		.buildAndRegister();

RecyclingHelper.handleRecycling(metaitem('turbojet.small'), [
		metaitem('rotorRene') * 4,
		ore('stickLongTitanium'),
		ore('plateTitanium') * 2,
		ore('boltTitanium') * 4,
		metaitem('pipeTinyFluidTitanium') * 8
])

// Jet wingpack
mods.gregtech.assembler.recipeBuilder()
		.inputs(metaitem('turbojet.small') * 4)
		.inputs(metaitem('wing.small') * 2)
		.inputs(metaitem('electric.pump.ev'))
		.inputs(metaitem('large_fluid_cell.titanium') * 2)
		.inputs(ore('circuitHv') * 2)
		.inputs(ore('plateTitanium') * 2)
		.inputs(ore('boltTitanium') * 8)
		.outputs(metaitem('susy:jet_wingpack'))
		.duration(200)
		.EUt(480)
		.buildAndRegister();

RecyclingHelper.handleRecycling(metaitem('susy:jet_wingpack'), [
		metaitem('turbojet.small') * 4,
		metaitem('wing.small') * 2,
		metaitem('electric.pump.ev'),
		metaitem('large_fluid_cell.titanium') * 2,
		ore('plateTitanium') * 2,
		ore('boltTitanium') * 8
])

// Register Jet Wingpack fuels
JET_WINGPACK = recipemap('jet_wingpack_fuels')

mods.jei.catalyst.add('gregtech:jet_wingpack_fuels', metaitem('susy:jet_wingpack'))

JET_WINGPACK.recipeBuilder()
		.fluidInputs(fluid('kerosene') * 1)
		.duration(20)
		.buildAndRegister()

JET_WINGPACK.recipeBuilder()
		.fluidInputs(fluid('midgrade_kerosene') * 1)
		.duration(40)
		.buildAndRegister()

JET_WINGPACK.recipeBuilder()
		.fluidInputs(fluid('premium_kerosene') * 1)
		.duration(60)
		.buildAndRegister()

JET_WINGPACK.recipeBuilder()
		.fluidInputs(fluid('supreme_kerosene') * 1)
		.duration(80)
		.buildAndRegister()
