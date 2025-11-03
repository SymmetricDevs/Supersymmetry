import static prePostInit.Recipemaps.*
import postInit.utils.RecyclingHelper
import static gregtech.api.GTValues.*
import gregtech.api.recipes.ingredients.nbtmatch.*

crafting.addShaped("susy:basic_structural_casing", item('susy:susy_multiblock_casing', 3) * 6, [
    [ore('screwWroughtIron'), ore('plateWroughtIron'), ore('craftingToolHardHammer')],
    [ore('plateWroughtIron'), null, ore('plateWroughtIron')],
    [ore('craftingToolScrewdriver'), ore('plateWroughtIron'), ore('screwWroughtIron')]
])

crafting.addShaped("susy:basic_serpentine", item('susy:serpentine') * 6, [
    [null, ore('plateSteel'), ore('craftingToolWrench')],
    [ore('pipeTinyFluidCopper'), ore('pipeTinyFluidCopper'), ore('pipeTinyFluidCopper')],
    [ore('craftingToolHardHammer'), ore('plateSteel'), null]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateWroughtIron') * 4)
    .circuitMeta(2)
    .outputs(item('susy:susy_multiblock_casing', 3) * 6)
    .duration(240)
    .EUt(VA[LV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 3) * 3, [ore('plateWroughtIron') * 2])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateSteel') * 2)
    .inputs(ore('pipeTinyFluidCopper') * 2)
    .circuitMeta(2)
    .outputs(item('susy:serpentine') * 6)
    .duration(240)
    .EUt(VA[LV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:serpentine') * 3, [item('gregtech:fluid_pipe_tiny', 25), ore('plateSteel')])

ASSEMBLER.recipeBuilder()
    .circuitMeta(10)
    .inputs(metaitem('electric.motor.hv') * 2)
    .inputs(ore('gearStainlessSteel') * 4)
    .inputs(ore('rotorStainlessSteel') * 16)
    .inputs(ore('plateStainlessSteel') * 16)
    .outputs(item('susy:separator_rotor') * 5)
    .duration(240)
    .EUt(VA[LV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:separator_rotor') * 5,
        [metaitem('electric.motor.hv') * 2, ore('gearStainlessSteel') * 4, ore('rotorStainlessSteel') * 16, ore('plateStainlessSteel') * 16]
)

ASSEMBLER.recipeBuilder()
    .circuitMeta(9)
    .inputs(ore('plateStainlessSteel') * 9)
    .outputs(item('susy:susy_multiblock_casing', 2))
    .duration(240)
    .EUt(VA[HV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 2), [ore('plateStainlessSteel') * 9])

ASSEMBLER.recipeBuilder()
    .circuitMeta(11)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('frameGtStainlessSteel'))
    .outputs(item('susy:susy_multiblock_casing', 1))
    .duration(240)
    .EUt(VA[HV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 1), [ore('plateStainlessSteel') * 4, ore('frameGtStainlessSteel')])

ASSEMBLER.recipeBuilder()
    .circuitMeta(13)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(item('gregtech:metal_casing', 4))
    .outputs(item('susy:susy_multiblock_casing', 10))
    .duration(240)
    .EUt(VA[HV])
    .buildAndRegister()

RecyclingHelper.handleRecycling(item('susy:susy_multiblock_casing', 10), [ore('plateStainlessSteel') * 4, item('gregtech:metal_casing', 4)])

RecyclingHelper.addShaped("susy:air_vent_w", item('susy:meta_item', 4), [
    [ore('craftingToolHardHammer'),ore('stickWroughtIron'),ore('craftingToolScrewdriver')],
    [ore('plateWroughtIron'),ore('stickWroughtIron'),ore('plateWroughtIron')],
    [ore('screwWroughtIron'),ore('stickWroughtIron'),ore('screwWroughtIron')]
])

crafting.addShaped("susy:air_vent_n", item('susy:meta_item', 4), [
    [ore('craftingToolHardHammer'),ore('stickIron'),ore('craftingToolScrewdriver')],
    [ore('plateIron'),ore('stickIron'),ore('plateIron')],
    [ore('screwIron'),ore('stickIron'),ore('screwIron')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateWroughtIron') * 2)
    .inputs(ore('stickWroughtIron') * 2)
    .inputs(ore('screwWroughtIron') * 2)
    .circuitMeta(13)
    .outputs(item('susy:meta_item', 4))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateIron') * 2)
    .inputs(ore('stickIron') * 2)
    .inputs(ore('screwIron') * 2)
    .circuitMeta(13)
    .outputs(item('susy:meta_item', 4))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// Restrictive Filters
ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSteel') * 8)
    .inputs(metaitem('item_filter'))
    .circuitMeta(1)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .duration(200)
    .outputs(item('susy:meta_item', 6))
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSteel') * 8)
    .inputs(metaitem('item_filter'))
    .circuitMeta(2)
    .fluidInputs(fluid('tin') * 144)
    .outputs(item('susy:meta_item', 6))
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

//Deposit stuff
// Crushed Sulfur Ore * 1
mods.gregtech.forge_hammer.removeByInput(16, [item('gregtech:ore_sulfur_0')], null)
// Crushed Sulfur Ore * 2
mods.gregtech.macerator.removeByInput(2, [item('gregtech:ore_sulfur_0')], null)

// Armors
crafting.addShaped("susy:simple_gas_mask", item('susy:susy_armor', 0).withNbt(['damage': 0.0D]), [
    [item('gregtech:meta_item_1', 438), item('minecraft:paper'), item('gregtech:meta_item_1', 438)],
    [ore('string'), ore('dustCharcoal'), ore('string')],
    [null, item('minecraft:paper'), null]
])

crafting.addShaped("susy:gas_mask", item('susy:susy_armor', 2), [
    [metaitem('bound_leather'), ore('plateGlass'), metaitem('bound_leather')],
    [metaitem('bound_leather'), metaitem('bound_leather'), metaitem('bound_leather')],
    [null, ore('pipeTinyFluidRubber'), ore('ringRubber')]
])
crafting.addShaped("susy:gas_tank", item('susy:susy_armor', 3).withNbt(['oxygen': 0.0D]), [
    [metaitem('bound_leather'), null, null],
    [metaitem('bound_leather'), ore('pipeTinyFluidRubber'), ore('ringRubber')],
    [metaitem('bound_leather'), metaitem('fluid_cell'), metaitem('bound_leather')]
])

crafting.addShaped("susy:easy_cell", metaitem('fluid_cell'), [
    [ore('craftingToolHardHammer'), null],
    [null, ore('plateSteel')]
])

crafting.addShapeless("susy:gas_tank_fill", item('susy:susy_armor', 3).withNbt(['oxygen': 1200.0D]), 
    [item('susy:susy_armor', 3),
    metaitem('fluid_cell').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 1000]])
])

ASSEMBLER.recipeBuilder()
    .circuitMeta(1)
    .inputs(item('minecraft:leather_helmet'))
    .inputs(ore('pipeTinyFluidRubber'))
    .inputs(ore('ringRubber'))
    .inputs(metaitem('mineral_wool') * 5)
    .inputs(ore('foilAsbestos') * 5)
    .fluidInputs(fluid('glass') * 144)
    .outputs(item('susy:susy_armor', 4).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(item('minecraft:leather_chestplate'))
    .inputs(ore('pipeTinyFluidRubber'))
    .inputs(ore('ringRubber'))
    .inputs(metaitem('mineral_wool') * 8)
    .inputs(ore('foilAsbestos') * 8)
    .inputs(metaitem('large_fluid_cell.steel'))
    .outputs(item('susy:susy_armor', 5).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

crafting.shapelessBuilder()
    .name("susy:asbestos_tank_fill")
    .output(item('susy:susy_armor', 5).withNbt(['oxygen': 1200.0D]))
    .input(item('susy:susy_armor', 5).mark('tank')) 
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .inputs(item('minecraft:leather_leggings'))
    .inputs(metaitem('mineral_wool') * 7)
    .inputs(ore('foilAsbestos') * 7)
    .outputs(item('susy:susy_armor', 6).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()
    
ASSEMBLER.recipeBuilder()
    .circuitMeta(4)
    .inputs(item('minecraft:leather_boots'))
    .inputs(metaitem('mineral_wool') * 4)
    .inputs(ore('foilAsbestos') * 4)
    .outputs(item('susy:susy_armor', 7).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(item('susy:meta_item', 1))
    .inputNBT(item('susy:susy_armor', 5), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 8).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister()
    
crafting.shapelessBuilder()
    .name("susy:rebreather_tank_fill")
    .output(item('susy:susy_armor', 8).withNbt(['oxygen': 3600.0D]))
    .input(item('susy:susy_armor', 8).mark('tank')) 
    .input(metaitem('dustLithiumHydroxide'))
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

CVD.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 4), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 9).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

CVD.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 5), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 10).withNbt(['damage': 0.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

crafting.shapelessBuilder()
    .name("susy:reflective_tank_fill")
    .output(item('susy:susy_armor', 10).withNbt(['oxygen': 1200.0D]))
    .input(item('susy:susy_armor', 10).mark('tank')) 
    .input(metaitem('large_fluid_cell.steel').withNbt(['Fluid': ['FluidName': 'air', 'Amount': 8000]])
        .transform({ _ -> metaitem('large_fluid_cell.steel')}))
    .recipeFunction { output, inputs, info -> 
        output.getTagCompound().setDouble("damage", inputs['tank'].getTagCompound().getDouble("damage"))
    }.register()

// Rebreather tanks can be upgraded too.
CVD.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 8), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 10).withNbt(['damage': 0.0D, 'oxygen': 0.0D]))
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

CVD.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 6), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 11).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

CVD.recipeBuilder()
    .inputs(metaitem('dustAluminium'))
    .inputNBT(item('susy:susy_armor', 7), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 12).withNbt(['damage': 0.0D]))
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

// Filtered tank
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('dustMolecularSieveX'))
    .inputs(metaitem('plateStainlessSteel') * 4)
    .inputs(item('susy:meta_item', 1))
    .inputNBT(item('susy:susy_armor', 10), NBTMatcher.ANY, NBTCondition.ANY)
    .outputs(item('susy:susy_armor', 13).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('threadPolybenzimidazole') * 10)
    .inputs(metaitem('plateNomex') * 5)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate'))
    .fluidInputs(fluid('e_glass') * 288)
    .outputs(item('susy:susy_armor', 14))
    .duration(400)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(3)
    .inputs(metaitem('plateNomex') * 8)
    .inputs(ore('threadPolybenzimidazole') * 20)
    .inputs(metaitem('dustMolecularSieveX') * 4)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('electric.piston.ev'))
    .inputs(metaitem('rotorStainlessSteel'))
    .inputs(metaitem('large_fluid_cell.stainless_steel'))
    .outputs(item('susy:susy_armor', 15))
    .duration(400)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(4)
    .inputs(ore('threadPolybenzimidazole') * 16)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 3)
    .inputs(metaitem('plateNomex') * 7)
    .outputs(item('susy:susy_armor', 16).withNbt(['oxygen': 0.0D]))
    .duration(400)
    .EUt(VA[EV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('threadPolybenzimidazole') * 14)
    .inputs(metaitem('pipeSmallFluidEthyleneVinylAcetate') * 2)
    .inputs(metaitem('plateNomex') * 4)
    .inputs(metaitem('electric.pump.ev'))
    .outputs(item('susy:susy_armor', 17))
    .duration(400)
    .EUt(VA[EV])
    .buildAndRegister()

// Concrete Dust * 1 (remove Industrial Concrete recycling)
mods.gregtech.macerator.removeByInput(2, [item('susy:susy_stone_smooth', 9)], null)
// Concrete Dust * 1
mods.gregtech.macerator.removeByInput(2, [item('susy:susy_stone_cobble', 9)], null)

//Custom Susy Blocks for Nether Complex structure

// Asbestos Fiber
EXTRUDER.recipeBuilder()
    .inputs(metaitem('dustAsbestos'))
    .notConsumable(metaitem('shape.extruder.wire'))
    .outputs(metaitem('fiberAsbestos') * 4)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

// Asbestos Plate * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('circuit.integrated').withNbt(['Configuration': 1]), metaitem('threadAsbestos') * 8], null)

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('threadAsbestos'))
    .outputs(item('susy:fake_wool') * 8)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

def dyes = [
    'orange'     : 1,
    'magenta'    : 2,
    'light_blue' : 3,
    'yellow'     : 4,
    'lime'       : 5,
    'pink'       : 6,
    'gray'       : 7,
    'light_gray' : 8,
    'cyan'       : 9,
    'purple'     : 10,
    'blue'       : 11,
    'brown'      : 12,
    'green'      : 13,
    'red'        : 14,
    'black'      : 15
]

dyes.each { dye, number ->
    CHEMICAL_BATH.recipeBuilder()
        .inputs(item('susy:fake_wool'))
        .fluidInputs(fluid('dye_' + dye) * 144)
        .outputs(item('susy:fake_wool', + number))
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()
}

//Custom Susy Blocks for Black Mesa style Research Facility

//Industrial Concrete
def concretes = [1, 2, 3]

concretes.each { number ->
    ASSEMBLER.recipeBuilder()
        .circuitMeta(number)
        .inputs(metaitem('frameSteel'))
        .inputs(metaitem('dustStone'))
        .fluidInputs(fluid('concrete') * 144)
        .outputs(item('susy:random_concrete', number) * 8)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()
}

ASSEMBLER.recipeBuilder()
    .circuitMeta(4)
    .inputs(metaitem('frameSteel')) 
    .inputs(metaitem('dustStone'))
    .fluidInputs(fluid('concrete') * 144) 
    .outputs(item('susy:random_concrete') * 8) 
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(5)
    .inputs(metaitem('frameSteel')) 
    .inputs(metaitem('dustStone'))
    .fluidInputs(fluid('concrete') * 144) 
    .outputs(item('susy:susy_stone_smooth', 9) * 8)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

//Dotted Panels
def panels = [4, 5, 6, 7]

panels.each { number ->
    ASSEMBLER.recipeBuilder()
        .circuitMeta(number)
        .inputs(metaitem('plateWroughtIron') * 4)
        .inputs(metaitem('screwWroughtIron') * 2)
        .outputs(item('susy:random_concrete', number) * 8)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()
}

//Industrial Cinder Bricks
def cinders = [8, 9, 10, 11, 12, 13]

cinders.each { number ->
    EXTRUDER.recipeBuilder()
        .circuitMeta(number)
        .notConsumable(metaitem('shape.extruder.block'))
        .fluidInputs(fluid('concrete') * 144)
        .outputs(item('susy:random_concrete', number) * 8)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()
} 

//Smooth Industrial Concretes
def smooths = [14, 15]

smooths.each { number ->
    EXTRUDER.recipeBuilder()
        .circuitMeta(number)
        .inputs(metaitem('frameSteel'))
        .fluidInputs(fluid('concrete') * 144)
        .outputs(item('susy:random_concrete', number) * 8)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()
} 

EXTRUDER.recipeBuilder()
    .circuitMeta(16)
    .inputs(metaitem('frameSteel'))
    .fluidInputs(fluid('concrete') * 144)
    .outputs(item('susy:random_concrete1') * 8)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()
