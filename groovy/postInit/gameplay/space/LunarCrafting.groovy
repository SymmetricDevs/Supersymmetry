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

crafting.addShapeless('susy:crafting_table_moon_anorthosite', item('minecraft:crafting_table'), [
    item('susy:susy_stone_bricks', 11)
])

crafting.addShapeless('susy:crafting_table_moon_basalt', item('minecraft:crafting_table'), [
    item('susy:susy_stone_bricks', 12)
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
    .requireVacuum()
    .duration(80)
    .EUt(8000)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustTitanium"))
    .outputs(metaitem("ingotTitanium"))
    .requireVacuum()
    .duration(200)
    .EUt(12000)
    .requireVacuum()
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


