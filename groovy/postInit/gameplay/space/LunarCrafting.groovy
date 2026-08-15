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
    .duration(80)
    .EUt(8000)
    .buildAndRegister()

SOLAR_FURNACE.recipeBuilder()
    .inputs(ore("dustTitanium"))
    .outputs(metaitem("ingotTitanium"))
    .duration(200)
    .EUt(12000)
    .buildAndRegister()



