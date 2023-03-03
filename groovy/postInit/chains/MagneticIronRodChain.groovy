import static globals.Globals.*

def electrolyte_paper_ingredients = [
    item('forge:bucketfilled').withNbt([FluidName: "salt_water", Amount: 1000]),
    item('minecraft:paper')
]

def voltaic_pile_ingredients = [
    [null, metaitem('electrolyte_paper'), null],
    [null, metaitem('plateZinc'), null],
    [null, metaitem('plateCopper'), null]
]

def magnetic_rod_ingredients = [
    [metaitem('voltaic_pile'),  metaitem('wireGtSingleCopper'), metaitem('springCopper')],
    [null, null, metaitem('hot_iron_rod')],
    [null, null, null]
]

furnace.add(metaitem('stickIron'), metaitem('hot_iron_rod'))

crafting.addShapeless(metaitem('electrolyte_paper'), electrolyte_paper_ingredients) 
crafting.addShaped(metaitem('voltaic_pile'), voltaic_pile_ingredients) 

crafting.removeByOutput(metaitem('stickIronMagnetic')) 
crafting.addShapeless(metaitem('stickIronMagnetic') * 2, [metaitem('hot_iron_rod'), metaitem('stickIronMagnetic')])
crafting.addShaped(metaitem('stickIronMagnetic'), magnetic_rod_ingredients)
