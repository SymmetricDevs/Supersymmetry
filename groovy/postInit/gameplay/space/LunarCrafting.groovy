import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

SOLAR_FURNACE.recipeBuilder()
    .inputs(metaitem("dustSiliconDioxide") * 6)// SiO2 * 4, Al2O3 * 1, CaO * 1; based off https://nivitex.com/wp-content/uploads/2024/04/Fibreglass-Grades.pdf R-glass
    .inputs(metaitem("dustDemagnetizedAnorthosite") * 13)
    .fluidOutputs(fluid("lunar_r_glass") * 2736)
    .EUt(12000)
    .duration(360)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(metaitem("dustSiliconDioxide") * 9)
    .inputs(metaitem("dustAnorthosite") * 13)
    .fluidOutputs(fluid("lunar_r_glass") * 3456)
    .EUt(12000)
    .duration(360)
    .buildAndRegister()

EXTRUDER.recipeBuilder()
    .fluidInputs(fluid("lunar_r_glass") * 144)
    .notConsumable(metaitem("platinum_rhodium_bushing") * 1)
    .outputs(metaitem("lunar_r_glass_fibers") * 4)
    .EUt(VA[LV])
    .duration(40)
    .buildAndRegister()

EXTRUDER.recipeBuilder()
    .fluidInputs(fluid("lunar_r_glass") * 144)
    .notConsumable(metaitem("stainless_steel_bushing") * 1) //based off https://patents.google.com/patent/WO2008112978A1/en
    .outputs(metaitem("lunar_r_glass_fibers") * 2) // yes that was only for a specific glass composition but shhh
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("wireGtSingleAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers"))
    .outputs(metaitem("cableGtSingleAluminium"))
    .EUt(4)
    .duration(8)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("wireGtDoubleAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .outputs(metaitem("cableGtDoubleAluminium"))
    .EUt(4)
    .duration(12)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("wireGtQuadrupleAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 3)
    .outputs(metaitem("cableGtQuadrupleAluminium"))
    .EUt(4)
    .duration(16)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("wireGtOctalAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 4)
    .outputs(metaitem("cableGtOctalAluminium"))
    .EUt(4)
    .duration(20)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("wireGtHexAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 5)
    .outputs(metaitem("cableGtHexAluminium"))
    .EUt(4)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

crafting.addShaped("susy:crafting_table_moon_anorthosite", item('minecraft:crafting_table') * 1, [
    [item('susy:susy_stone_cobble', 11), item('susy:susy_stone_cobble', 11)],
    [item('susy:susy_stone_cobble', 11), item('susy:susy_stone_cobble', 11)],
])

crafting.addShaped("susy:crafting_table_moon_basalt", item('minecraft:crafting_table') * 1, [
    [item('susy:susy_stone_cobble', 12), item('susy:susy_stone_cobble', 12)],
    [item('susy:susy_stone_cobble', 12), item('susy:susy_stone_cobble', 12)],
])

crafting.addShaped("susy:ev_casing_moon", item('gregtech:machine_casing', 4) * 1, [
    [ore('plateAluminium'), metaitem('lunar_r_glass_fibers'), ore('plateAluminium')],
    [ore('plateTitanium'), null, ore('plateTitanium')],
    [ore('plateAluminium'), metaitem('lunar_r_glass_fibers'), ore('plateAluminium')]
])

crafting.addShaped("susy:ev_hull_moon", metaitem('hull.ev') * 1, [
    [null, null, null],
    [metaitem('lunar_r_glass_fibers'), ore('plateAluminium'), metaitem('lunar_r_glass_fibers')],
    [metaitem('cableGtSingleAluminium'), item('gregtech:machine_casing', 4), metaitem('cableGtSingleAluminium')]
])

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustAluminium"))
    .outputs(metaitem("ingotAluminium"))
    .duration(80)
    .EUt(8000)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustTitanium"))
    .outputs(metaitem("ingotTitanium"))
    .duration(200)
    .EUt(12000)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .fluidInputs(fluid('water') * 96)
    .fluidOutputs(fluid('steam') * 15360)
    .duration(120)
    .EUt(120)
    .buildAndRegister()

crafting.addShaped("susy:ev_conveyor_moon", metaitem('conveyor.module.ev') * 1, [
    [metaitem('lunar_r_glass_fibers'), metaitem('lunar_r_glass_fibers'), metaitem('lunar_r_glass_fibers')],
    [metaitem('electric.motor.ev'), metaitem('cableGtSingleAluminium'), metaitem('electric.motor.ev')],
    [metaitem('lunar_r_glass_fibers'), metaitem('lunar_r_glass_fibers'), metaitem('lunar_r_glass_fibers')]
])

crafting.addShaped("susy:item_filter_moon", metaitem('item_filter') * 1, [
    [metaitem('foilAluminium'), metaitem('lunar_r_glass_fibers'), metaitem('foilAluminium')],
    [metaitem('foilAluminium'), metaitem('lunar_r_glass_fibers'), metaitem('foilAluminium')],
    [metaitem('foilAluminium'), metaitem('lunar_r_glass_fibers'), metaitem('foilAluminium')]
])

crafting.addShaped("susy:fluid_filter_moon", metaitem('fluid_filter') * 1, [
    [metaitem('foilAluminium'), metaitem('foilAluminium'), metaitem('foilAluminium')],
    [metaitem('lunar_r_glass_fibers'), metaitem('lunar_r_glass_fibers'), metaitem('lunar_r_glass_fibers')],
    [metaitem('foilAluminium'), metaitem('foilAluminium'), metaitem('foilAluminium')]
])


crafting.addShaped("susy:restrictive_filter_moon", metaitem('susy:restrictive_filter') * 1, [
    [null, metaitem('foilAluminium'), null],
    [metaitem('foilAluminium'), metaitem('item_filter'), metaitem('foilAluminium')],
    [null, metaitem('foilAluminium'), null]
])

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustAluminium") * 4) //FIXME (maybe): use molten salt electrolysis instead?
    .inputs(ore("dustSiliconDioxide") * 9)
    .outputs(metaitem("dustSilicon") * 3)
    .outputs(metaitem("dustAlumina") * 10)
    .duration(80)
    .EUt(1000)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustAluminium") * 8) //according to wikipedia this is done somewhere
    .inputs(ore("dustChromite") * 21)
    .outputs(metaitem("dustFerrochromium") * 9)
    .outputs(metaitem("dustAlumina") * 20)
    .duration(140)
    .EUt(6000)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustIron") * 24)
    .inputs(ore("dustFerrochromium") * 12)
    .inputs(ore("dustNickel") * 4)
    .inputs(ore("dustManganese"))
    .inputs(ore("dustSilicon") * 2)
    .fluidOutputs(fluid("stainless_steel") * 6192)
    .duration(1600)
    .EUt(16000)
    .info('recipe.moon')
    .requireVacuum()
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("wireFineAluminium") * 2)
    .outputs(metaitem("cover.controller"))
    .EUt(7)
    .duration(24)
    .circuitMeta(1)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateIron"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("cableGtSingleAluminium") * 2)
    .inputs(ore("circuitLv"))
    .outputs(metaitem("cover.energy.detector"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateTitanium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("cableGtDoubleAluminium") * 2)
    .inputs(ore("circuitHv"))
    .outputs(metaitem("cover.energy.detector.advanced"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("wireFineAluminium") * 2)
    .inputs(ore("circuitLv"))
    .outputs(metaitem("cover.activity.detector"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateTitanium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("wireFineAluminium") * 2)
    .inputs(ore("circuitHv"))
    .outputs(metaitem("cover.activity.detector_advanced"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("pipeSmallItemMagnalium"))
    .inputs(metaitem("wireFineAluminium") * 2)
    .outputs(metaitem("cover.item.detector"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateTitanium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("pipeSmallItemMagnalium") * 2)
    .inputs(metaitem("wireFineAluminium") * 2)
    .outputs(metaitem("cover.item.detector.advanced"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateAluminium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("pipeTinyFluidAluminium"))
    .inputs(metaitem("wireFineAluminium") * 2)
    .outputs(metaitem("cover.fluid.detector"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateTitanium"))
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("pipeTinyFluidAluminium") * 2)
    .inputs(metaitem("wireFineAluminium") * 2)
    .outputs(metaitem("cover.fluid.detector.advanced"))
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("plateAluminium") * 4)
    .inputs(metaitem("lunar_r_glass_fibers") * 2)
    .inputs(metaitem("wireFineAluminium") * 2)
    .outputs(metaitem("cover.maintenance.detector"))
    .circuitMeta(2)
    .EUt(7)
    .duration(24)
    .info('recipe.moon')
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustSiliconDioxide") * 3)
    .outputs(metaitem("fused_quartz"))
    .duration(200)
    .EUt(16000)
    .circuitMeta(3)
    .info('recipe.moon')
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("plateTitanium"))
    .fluidInputs(fluid('carbon_monoxide') * 1000)
    .outputs(metaitem("plateHardenedTitanium"))
    .fluidOutputs(fluid("carbon_monoxide") * 950)
    .duration(200)
    .EUt(4000)
    .buildAndRegister()

crafting.addShaped("susy:hardened_titanium_grinding_head", metaitem('hardened_titanium_grinding_head') * 1, [
    [metaitem('plateHardenedTitanium'), metaitem('plateNickel'), metaitem('plateHardenedTitanium')],
    [metaitem('plateNickel'), metaitem('ringTitanium'), metaitem('plateNickel')],
    [metaitem('plateHardenedTitanium'), metaitem('plateNickel'), metaitem('plateHardenedTitanium')]
])

crafting.addShaped("susy:hardened_titanium_casing", item('susy:susy_multiblock_casing', 14) * 6, [
    [metaitem('plateHardenedTitanium'), ore('toolHammer'), metaitem('plateHardenedTitanium')],
    [metaitem('plateHardenedTitanium'), metaitem('frameTitanium'), metaitem('plateHardenedTitanium')],
    [metaitem('plateHardenedTitanium'), ore('toolWrench'), metaitem('plateHardenedTitanium')]
])

crafting.addShaped("susy:bwe_conveyor_belt", item('susy:bwe_conveyor_belt') * 12, [
    [metaitem('plateHardenedTitanium'), ore('plateHardenedTitanium'), metaitem('plateHardenedTitanium')],
    [metaitem('electric.motor.ev'), metaitem('frameSteel'), metaitem('electric.motor.ev')],
    [metaitem('plateHardenedTitanium'), ore('plateHardenedTitanium'), metaitem('plateHardenedTitanium')]
])

crafting.addShaped("susy:vehicle_track", item('susy:vehicle_track') * 16, [
    [metaitem('plateSteel'), ore('plateSteel'), metaitem('plateSteel')],
    [metaitem('electric.motor.ev'), metaitem('frameSteel'), metaitem('electric.motor.ev')],
    [metaitem('plateSteel'), ore('plateSteel'), metaitem('plateSteel')]
])

crafting.addShaped("susy:light_stainless_casing", item('susy:susy_multiblock_casing2') * 64, [
    [metaitem('plateStainlessSteel'), metaitem('lunar_r_glass_fibers'), metaitem('plateStainlessSteel')],
    [metaitem('plateStainlessSteel'), metaitem('frameStainlessSteel'), metaitem('plateStainlessSteel')],
    [metaitem('plateStainlessSteel'), metaitem('lunar_r_glass_fibers'), metaitem('plateStainlessSteel')]
])

ASSEMBLER.recipeBuilder()
    .inputs(metaitem("hull.ev"))
    .inputs(metaitem("electric.motor.ev") * 16)
    .inputs(metaitem("cableGtOctalAluminium") * 4)
    .inputs(ore("circuitEv") * 4)
    .outputs(metaitem('susy:lunar_bucket_wheel_excavator'))
    .EUt(VA[HV])
    .duration(320)
    .circuitMeta(4)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('cableGtSingleAluminium'))
        .inputs(ore('pipeNormalFluidTitanium'))
        .inputs(ore('screwStainlessSteel'))
        .inputs(ore('rotorStainlessSteel'))   
        .inputs(metaitem("lunar_r_glass_fibers") * 2)
        .inputs(metaitem('electric.motor.ev'))
        .outputs(metaitem('electric.pump.ev'))
        .duration(100)
        .EUt(VA[MV])
        .info('recipe.moon')
        .buildAndRegister();

crafting.addShaped('gregtech:machine_68_moon', item('gregtech:machine', 68), [
        [metaitem('electric.piston.ev'), metaitem('electric.motor.ev'), metaitem('hardened_titanium_grinding_head')],
        [ore('cableGtSingleAluminium'), ore('cableGtSingleAluminium'), metaitem('hull.ev')],
        [ore('circuitEv'), ore('circuitEv'), ore('cableGtSingleAluminium')]])        

crafting.addShaped('gregtech:machine_293_moon', item('gregtech:machine', 293), [
        [metaitem('conveyor.module.ev'), ore('cableGtSingleAluminium'), ore('wireGtQuadrupleKanthal')],
        [ore('cableGtSingleAluminium'), metaitem('hull.ev'), ore('stickStrontiumFerriteMagnetic')],
        [ore('circuitEv'), ore('cableGtSingleAluminium'), ore('wireGtQuadrupleKanthal')]]) 

crafting.addShaped('gregtech:machine_443_moon', item('gregtech:machine', 443), [
        [ore('cableGtSingleAluminium'), ore('circuitEv'), ore('cableGtSingleAluminium')],
        [metaitem('electric.motor.ev'), metaitem('hull.ev'), metaitem('hardened_titanium_grinding_head')],
        [ore('circuitEv'), ore('cableGtSingleAluminium'), metaitem('electric.piston.ev')]])  

crafting.addShaped('gregtech:machine_548_moon', item('gregtech:machine', 548), [
        [ore('wireGtQuadrupleKanthal'), ore('stickStrontiumFerriteMagnetic'), ore('wireGtQuadrupleKanthal')],
        [ore('cableGtSingleAluminium'), metaitem('hull.ev'), ore('cableGtSingleAluminium')],
        [ore('wireGtQuadrupleKanthal'), ore('stickStrontiumFerriteMagnetic'), ore('wireGtQuadrupleKanthal')]]) 

crafting.addShaped('gregtech:machine_668_moon', item('gregtech:machine', 668), [
        [metaitem('electric.piston.ev'), metaitem('electric.motor.ev'), metaitem('hardened_titanium_grinding_head')],
        [ore('cableGtSingleAluminium'), metaitem('hull.ev'), ore('cableGtSingleAluminium')],
        [item('gregtech:transparent_casing'), item('gregtech:transparent_casing'), item('gregtech:transparent_casing')]]) 

crafting.addShaped('gregtech:machine_1593_moon', item('gregtech:machine', 1593), [
        [metaitem('electric.motor.ev'), metaitem('hardened_titanium_grinding_head'), metaitem('electric.motor.ev')],
        [ore('circuitEv'), metaitem('hull.ev'), ore('circuitEv')],
        [ore('cableGtSingleAluminium'), metaitem('crate.aluminium'), ore('cableGtSingleAluminium')]]) 

crafting.addShaped('gregtech:machine_14557_moon', item('gregtech:machine', 14557), [
        [ore('pipeLargeFluidTitanium'), ore('rotorStainlessSteel'), ore('pipeLargeFluidTitanium')],
        [ore('cableGtSingleAluminium'), metaitem('electric.motor.ev'), ore('cableGtSingleAluminium')],
        [ore('circuitEv'), metaitem('hull.ev'), ore('circuitEv')]]) 

crafting.addShaped('gregtech:machine_14596_moon', item('gregtech:machine', 14596), [
        [ore('plateTitanium'), item('gregtech:transparent_casing'), ore('plateTitanium')],
        [ore('pipeLargeFluidTitanium'), metaitem('hull.ev'), ore('pipeLargeFluidTitanium')],
        [ore('circuitEv'), metaitem('electric.pump.ev'), ore('circuitEv')]])         

crafting.addShaped('gregtech:machine_14609_moon', item('gregtech:machine', 14609), [
        [ore('pipeLargeFluidTitanium'), ore('pipeLargeFluidTitanium'), ore('pipeLargeFluidTitanium')],
        [ore('cableGtSingleAluminium'), metaitem('electric.pump.ev'), ore('cableGtSingleAluminium')],
        [ore('circuitEv'), metaitem('hull.ev'), ore('circuitEv')]])   

crafting.addShaped('gregtech:machine_14669_moon', item('gregtech:machine', 14669), [
        [ore('circuitEv'), item('gregtech:transparent_casing'), ore('circuitEv')],
        [ore('stickStrontiumFerriteMagnetic'), metaitem('hull.ev'), ore('stickStrontiumFerriteMagnetic')],
        [ore('cableGtSingleAluminium'), ore('springKanthal'), ore('cableGtSingleAluminium')]])  

crafting.addShaped('gregtech:machine_14684_moon', item('gregtech:machine', 14684), [
        [ore('cableGtSingleAluminium'), metaitem('electric.pump.ev'), ore('cableGtSingleAluminium')],
        [ore('pipeLargeFluidTitanium'), metaitem('hull.ev'), ore('pipeLargeFluidTitanium')],
        [ore('circuitEv'), ore('cableGtSingleAluminium'), ore('circuitEv')]]) 

crafting.addShaped('gregtech:machine_398_moon', item('gregtech:machine', 398), [
        [metaitem('electric.pump.ev'), item('gregtech:transparent_casing'), metaitem('electric.pump.ev')],
        [ore('cableGtSingleAluminium'), metaitem('hull.ev'), ore('cableGtSingleAluminium')],
        [ore('circuitEv'), metaitem('crate.aluminium'), ore('circuitEv')]])

crafting.addShaped('gregtech:machine_503_moon', item('gregtech:machine', 503), [
        [metaitem('crate.aluminium'), ore('circuitEv'), metaitem('crate.aluminium')],
        [metaitem('robot.arm.ev'), metaitem('hull.ev'), metaitem('conveyor.module.ev')],
        [ore('cableGtSingleAluminium'), ore('circuitEv'), ore('cableGtSingleAluminium')]])     

crafting.addShaped('gregtech:machine_1397_moon', item('gregtech:machine', 1379), [
        [ore('wireGtQuadrupleAluminium'), metaitem('crate.aluminium'), ore('wireGtQuadrupleAluminium')],
        [ore('wireGtQuadrupleAluminium'), metaitem('hull.ev'), ore('wireGtQuadrupleAluminium')],
        [ore('cableGtSingleAluminium'), ore('circuitEv'), ore('cableGtSingleAluminium')]])  

crafting.addShaped('gregtech:machine_1319_moon', item('gregtech:machine', 1319), [
        [null, null, null],
        [ore('wireGtQuadrupleAluminium'), metaitem('crate.aluminium'), ore('wireGtQuadrupleAluminium')],
        [ore('wireGtQuadrupleAluminium'), metaitem('hull.ev'), ore('wireGtQuadrupleAluminium')]])

crafting.addShaped('gregtech:machine_1333_moon', item('gregtech:machine', 1333), [
        [null, null, null],
        [ore('wireGtOctalAluminium'), metaitem('crate.aluminium'), ore('wireGtOctalAluminium')],
        [ore('wireGtOctalAluminium'), metaitem('hull.ev'), ore('wireGtOctalAluminium')]])

crafting.addShaped('gregtech:machine_1347_moon', item('gregtech:machine', 1347), [
        [null, null, null],
        [ore('wireGtHexAluminium'), metaitem('crate.aluminium'), ore('wireGtHexAluminium')],
        [ore('wireGtHexAluminium'), metaitem('hull.ev'), ore('wireGtHexAluminium')]])

BR.recipeBuilder()
    .fluidInputs(fluid('aluminium') * 144)
    .notConsumable(fluid('nitrogen') * 10)
    .notConsumable(metaitem('ringSteel'))
    .outputs(metaitem('dustFineAluminium') * 1)
    .EUt(30)
    .duration(40)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(metaitem('dustIce') * 3)
    .inputs(metaitem('dustFineAluminium') * 2)
    .outputs(metaitem('dustAlice') * 5)
    .EUt(16)
    .duration(150)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder() // vaguely modeled after HSLA steel, no particular grade
    .inputs(metaitem("dustIron") * 50) // the titanium amount is prob way too high
    .inputs(metaitem("dustTinyManganese") * 3)
    .inputs(metaitem("dustTinyTitanium") * 1)
    .fluidOutputs(fluid("steel") * 3680)
    .EUt(16000)
    .duration(500)
    .info('recipe.moon')
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(metaitem("dustIron") * 5)
    .inputs(metaitem("dustNickel") * 3)
    .fluidOutputs(fluid("invar") * 1152)
    .EUt(14000)
    .duration(200)
    .info('recipe.moon')
    .buildAndRegister()

crafting.addShaped('susy:quarry_moon', item('gregtech:machine', 15063), [
    [metaitem('plateAluminium'), metaitem('electric.motor.ev'), metaitem('plateAluminium')],
    [ore('circuitEv'), metaitem('hull.ev'), ore('circuitEv')],
    [ore('wireGtSingleAluminium'), metaitem('hardened_titanium_grinding_head'), ore('wireGtSingleAluminium')]])

crafting.addShaped('susy:dumper_moon', metaitem('susy:dumper'), [
    [metaitem('plateAluminium'), metaitem('plateAluminium'), metaitem('plateAluminium')],
    [metaitem('electric.pump.ev'), metaitem('hull.ev'), metaitem('pipeHugeFluidAluminium')],
    [metaitem('plateAluminium'), metaitem('plateAluminium'), metaitem('plateAluminium')]])

crafting.addShaped('susy:smoke_stack_moon', metaitem('susy:smoke_stack'), [
    [null, metaitem('rotorAluminium'), null],
    [metaitem('pipeSmallFluidAluminium'), metaitem('hull.ev'), metaitem('pipeSmallFluidAluminium')],
    [null, metaitem('plateAluminium'), null]])

crafting.addShaped('susy:flare_stack_moon', metaitem('susy:flare_stack'), [
    [null, metaitem('rotorAluminium'), null],
    [metaitem('stickAluminium'), metaitem('hull.ev'), metaitem('stickAluminium')],
    [null, metaitem('plateAluminium'), null]])

crafting.addShaped('susy:reaction_furnace_moon', metaitem('susy:reaction_furnace'), [
    [metaitem('cableGtQuadrupleAluminium'), metaitem('springKanthal'), metaitem('cableGtQuadrupleAluminium')],
    [ore('circuitEv'), metaitem('hull.ev'), ore('circuitEv')],
    [metaitem('plateAluminium'), metaitem('plateAluminium'), metaitem('plateAluminium')]])

crafting.addShaped('susy:clarifier_moon', metaitem('susy:clarifier'), [
    [metaitem('cableGtSingleAluminium'), metaitem('rotorTitanium'), metaitem('cableGtSingleAluminium')],
    [metaitem('electric.pump.ev'), metaitem('hull.ev'), metaitem('electric.pump.ev')],
    [ore('circuitEv'), metaitem('electric.motor.ev'), ore('circuitEv')]])

crafting.addShaped('susy:froth_flotation_tank_moon', metaitem('susy:froth_flotation_tank'), [
    [metaitem('cableGtSingleAluminium'), metaitem('rotorStainlessSteel'), metaitem('cableGtSingleAluminium')],
    [metaitem('electric.pump.ev'), metaitem('hull.ev'), metaitem('electric.pump.ev')],
    [ore('circuitEv'), metaitem('electric.motor.ev'), ore('circuitEv')]])

crafting.addShaped('susy:phase_separator_moon', metaitem('susy:phase_separator'), [
    [null, null, null],
    [ore('frameGtAluminium'), metaitem('drum.aluminium'), metaitem('pipeSmallFluidAluminium')],
    [metaitem('pipeSmallFluidAluminium'), metaitem('hull.ev'), metaitem('pipeSmallFluidAluminium')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(4)
    .inputs(metaitem('hull.ev'))
    .inputs(metaitem('frameAluminium') * 12)
    .inputs(ore('circuitEv') * 6)
    .inputs(metaitem('electric.pump.ev') * 8)
    .inputs(ore('plateAluminium') * 4)
    .inputs(metaitem('lunar_r_glass_fibers') * 64)
    .outputs(metaitem('susy:high_pressure_cryogenic_distillation_plant'))
    .EUt(VA[LV])
    .duration(600)
    .info('recipe.moon')
    .buildAndRegister()

crafting.addShaped('susy:mixer_settler_v2_moon', metaitem('susy:mixer_settler_v2'), [
    [metaitem('electric.motor.ev'), ore('circuitEv'), metaitem('electric.motor.ev')],
    [metaitem('rotorTitanium'), metaitem('hull.ev'), metaitem('rotorTitanium')],
    [metaitem('electric.pump.ev'), metaitem('cableGtSingleAluminium'), metaitem('electric.pump.ev')]])

crafting.addShaped('susy:electrolytic_cell_moon', metaitem('susy:electrolytic_cell'), [
    [metaitem('plateAluminium'), ore('circuitEv'), metaitem('plateAluminium')],
    [metaitem('wireGtQuadrupleAluminium'), metaitem('hull.ev'), metaitem('wireGtQuadrupleAluminium')],
    [ore('circuitEv'), metaitem('cableGtSingleAluminium'), ore('circuitEv')]])

crafting.addShaped('susy:simple_condenser', metaitem('susy:simple_condenser'), [
    [null, metaitem('hull.ev'), null],
    [ore('frameGtAluminium'), metaitem('pipeSmallFluidAluminium'), ore('frameGtAluminium')],
    [ore('frameGtAluminium'), metaitem('pipeSmallFluidAluminium'), ore('frameGtAluminium')]])

crafting.addShaped('susy:drawer_1x_moon', item('storagedrawers:customdrawers') * 8, [
    [metaitem('stickAluminium'), metaitem('stickAluminium'), metaitem('stickAluminium')],
    [null, metaitem('crate.aluminium'), null],
    [metaitem('stickAluminium'), metaitem('stickAluminium'), metaitem('stickAluminium')]])

crafting.addShaped('susy:drawer_2x_moon', item('storagedrawers:customdrawers', 1) * 16, [
    [metaitem('stickAluminium'), metaitem('crate.aluminium'), metaitem('stickAluminium')],
    [metaitem('stickAluminium'), metaitem('plateAluminium'), metaitem('stickAluminium')],
    [metaitem('stickAluminium'), metaitem('crate.aluminium'), metaitem('stickAluminium')]])

crafting.addShaped('susy:drawer_4x_moon', item('storagedrawers:customdrawers', 2) * 32, [
    [metaitem('crate.aluminium'), metaitem('stickAluminium'), metaitem('crate.aluminium')],
    [metaitem('stickAluminium'), metaitem('plateAluminium'), metaitem('stickAluminium')],
    [metaitem('crate.aluminium'), metaitem('stickAluminium'), metaitem('crate.aluminium')]])

crafting.addShaped('susy:drawer_table_moon', item('storagedrawers:framingtable'), [
    [null, null, null],
    [metaitem('plateAluminium'), metaitem('plateAluminium'), metaitem('plateAluminium')],
    [metaitem('stickAluminium'), null, metaitem('stickAluminium')]])

crafting.addShaped('susy:maintenance_hatch_moon', metaitem('maintenance_hatch'), [
    [null, ore('toolWrench'), null],
    [null, metaitem('hull.ev'), null],
    [null, null, null]])

crafting.addShaped('susy:auto_maintenance_hatch_moon', metaitem('maintenance_hatch_full_auto'), [
    [ore('circuitEv'), metaitem('maintenance_hatch'), ore('circuitEv')],
    [metaitem('robot.arm.ev'), metaitem('hull.ev'), metaitem('robot.arm.ev')],
    [ore('circuitEv'), metaitem('maintenance_hatch'), ore('circuitEv')]])

ASSEMBLER.recipeBuilder()
    .circuitMeta(8)
    .inputs(metaitem('hull.ev'))
    .outputs(metaitem('maintenance_hatch'))
    .EUt(VA[ULV])
    .duration(20)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(1)
    .inputs(metaitem('hull.ev'))
    .inputs(metaitem('drum.aluminium'))
    .inputs(metaitem('lunar_r_glass_fibers') * 16)
    .outputs(metaitem('fluid_hatch.import.ev'))
    .EUt(VA[MV])
    .duration(20)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .circuitMeta(2)
    .inputs(metaitem('hull.ev'))
    .inputs(metaitem('drum.aluminium'))
    .inputs(metaitem('lunar_r_glass_fibers') * 16)
    .outputs(metaitem('fluid_hatch.export.ev'))
    .EUt(VA[MV])
    .duration(20)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fluid_hatch.import.ev'))
    .inputs(metaitem('pipeQuadrupleFluidTitanium'))
    .inputs(metaitem('lunar_r_glass_fibers') * 16)
    .outputs(metaitem('fluid_hatch.import_4x'))
    .EUt(VA[MV])
    .duration(20)
    .info('recipe.moon')
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('fluid_hatch.export.ev'))
    .inputs(metaitem('pipeQuadrupleFluidTitanium'))
    .inputs(metaitem('lunar_r_glass_fibers') * 16)
    .outputs(metaitem('fluid_hatch.export_4x'))
    .EUt(VA[MV])
    .duration(20)
    .info('recipe.moon')
    .buildAndRegister()

crafting.addShaped('susy:lv_energy_hatch_moon', metaitem('energy_hatch.input.lv'), [
    [null, metaitem('voltage_coil.lv'), null],
    [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('cableGtSingleAluminium')],
    [null, null, null]])

crafting.addShaped('susy:mv_energy_hatch_moon', metaitem('energy_hatch.input.mv'), [
    [null, metaitem('voltage_coil.mv'), null],
    [metaitem('cableGtSingleAluminium'), metaitem('hull.ev'), metaitem('cableGtSingleAluminium')],
    [null, metaitem('plate.ultra_low_power_integrated_circuit'), null]])

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('hull.ev'))
    .inputs(metaitem('robot.arm.ev') * 12)
    .inputs(metaitem('electric.piston.ev') * 16)
    .inputs(metaitem('cableGtQuadrupleAluminium') * 24)
    .inputs(ore('circuitEv') * 16)
    .outputs(metaitem('susy:lunar_launch_complex'))
    .EUt(VA[LV])
    .duration(600)
    .buildAndRegister()

crafting.addShaped('susy:air_disperser', metaitem('susy:air_disperser'), [
    [metaitem('plateAluminium'), metaitem('plateAluminium'), metaitem('plateAluminium')],
    [metaitem('stickAluminium'), metaitem('stickAluminium'), metaitem('stickAluminium')],
    [null, metaitem('pipeSmallFluidAluminium'), null]])

crafting.addShaped('susy:oxygen_sensor', metaitem('susy:oxygen_sensor'), [
    [metaitem('plateAluminium'), ore('circuitMv'), metaitem('plateAluminium')],
    [metaitem('plateAluminium'), metaitem('dustCalcium'), metaitem('stickAluminium')], // very vaguely based on an electrogalvanic oxygen sensor (they use lead and a bunch of other stuff tho)
    [metaitem('cableGtSingleAluminium'), metaitem('pipeTinyFluidAluminium'), metaitem('cableGtSingleAluminium')]])

MIXER.recipeBuilder()
    .inputs(metaitem('dustSiliconDioxide') * 21)
    .inputs(metaitem('dustSulfur') * 16)
    .outputs(metaitem('dustSilicaSulfurMix') * 37)
    .EUt(7)
    .duration(370)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(metaitem('dustBasalticRegolith') * 1)
    .fluidInputs(liquid('silica_sulfur_mix') * 144)
    .fluidOutputs(liquid('lunar_concrete') * 288)
    .EUt(7)
    .duration(12)
    .buildAndRegister()

SOLIDIFIER.recipeBuilder()
    .inputs(metaitem('lunar_r_glass_fibers') * 8)
    .fluidInputs(liquid('lunar_concrete') * 144)
    .outputs(item('susy:lunar_concrete') * 32)
    .EUt(7)
    .duration(64)
    .buildAndRegister()

mods.chisel.carving.addGroup("lunar_concrete")

mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete'))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 1))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 2))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 3))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 4))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 5))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 6))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 7))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 8))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 9))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 10))
mods.chisel.carving.addVariation("lunar_concrete", item('susy:lunar_concrete', 11))

// Hardened Titanium Dust * 9
mods.gregtech.macerator.removeByInput(2, [item('gregtech:meta_block_compressed_551')], null)
// Small Pile of Steel Dust * 18
mods.gregtech.macerator.removeByInput(8, [metaitem('toolHeadChainsawHardenedTitanium')], null)
// Hardened Titanium Dust * 4
mods.gregtech.macerator.removeByInput(2, [metaitem('toolHeadBuzzSawHardenedTitanium')], null)
// Hardened Titanium Dust * 4
mods.gregtech.macerator.removeByInput(8, [metaitem('toolHeadWrenchHardenedTitanium')], null)
// Hardened Titanium Dust * 1
mods.gregtech.macerator.removeByInput(2, [metaitem('plateHardenedTitanium')], null)
// Hardened Titanium Dust * 1
mods.gregtech.macerator.removeByInput(2, [metaitem('ingotHardenedTitanium')], null)
// Steel Dust * 4
mods.gregtech.macerator.removeByInput(8, [metaitem('toolHeadDrillHardenedTitanium')], null)
// Hardened Titanium Plate * 9
mods.gregtech.cutter.removeByInput(30, [item('gregtech:meta_block_compressed_551')], [fluid('water') * 35])
// Hardened Titanium Plate * 9
mods.gregtech.cutter.removeByInput(30, [item('gregtech:meta_block_compressed_551')], [fluid('distilled_water') * 26])
// Hardened Titanium Plate * 9
mods.gregtech.cutter.removeByInput(30, [item('gregtech:meta_block_compressed_551')], [fluid('lubricant') * 8])
// Hardened Titanium Ingot * 1
mods.gregtech.extruder.removeByInput(28, [metaitem('dustHardenedTitanium'), metaitem('shape.extruder.ingot')], null)
// Hardened Titanium Ingot * 2
mods.gregtech.extractor.removeByInput(120, [metaitem('toolHeadChainsawHardenedTitanium')], null)
// Hardened Titanium Ingot * 4
mods.gregtech.extractor.removeByInput(120, [metaitem('toolHeadWrenchHardenedTitanium')], null)
// Hardened Titanium Ingot * 4
mods.gregtech.extractor.removeByInput(120, [metaitem('toolHeadDrillHardenedTitanium')], null)
// Hardened Titanium Ingot * 1
mods.gregtech.alloy_smelter.removeByInput(7, [metaitem('nuggetHardenedTitanium') * 9, metaitem('shape.mold.ingot')], null)
// Hardened Titanium Ingot * 9
mods.gregtech.alloy_smelter.removeByInput(7, [item('gregtech:meta_block_compressed_551'), metaitem('shape.mold.ingot')], null)
// Hardened Titanium Ingot * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('nuggetHardenedTitanium') * 9], null)
// Block of Hardened Titanium * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('ingotHardenedTitanium') * 9], null)
// Block of Hardened Titanium * 1
mods.gregtech.alloy_smelter.removeByInput(28, [metaitem('ingotHardenedTitanium') * 9, metaitem('shape.mold.block')], null)
// Block of Hardened Titanium * 1
mods.gregtech.extruder.removeByInput(56, [metaitem('ingotHardenedTitanium') * 9, metaitem('shape.extruder.block')], null)
// Hardened Titanium Nugget * 9
mods.gregtech.alloy_smelter.removeByInput(7, [metaitem('ingotHardenedTitanium'), metaitem('shape.mold.nugget')], null)
