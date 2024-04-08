import globals.Globals

def voltaic_pile_ingredients = [
    [null, metaitem('electrolyte_paper'), null],
    [null, metaitem('plateZinc'), null],
    [null, metaitem('plateCopper'), null]
]

def magnetic_rod_ingredients = [
    [metaitem('voltaic_pile').reuse(), metaitem('wireGtSingleCopper').reuse(), metaitem('springCopper').reuse()],
    [null, null, metaitem('hot_iron_rod')],
    [null, null, null]
]

oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.lime'))
oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.lemon'))
oreDict.add('electrolyteFruit', metaitem('gregtechfoodoption:food.orange'))

crafting.removeByOutput(metaitem('stickIronMagnetic')) 

furnace.add(metaitem('stickIron'), metaitem('hot_iron_rod'))

crafting.addShapeless('ElectrolytePaperSalt',metaitem('electrolyte_paper'), [
    item('forge:bucketfilled').withNbt([FluidName: "salt_water", Amount: 1000]),
    item('minecraft:paper')
]) 
crafting.addShapeless('ElectrolytePaperFruit',metaitem('electrolyte_paper'), [
    ore('electrolyteFruit'),
    item('minecraft:paper'),
    ore('craftingToolMortar')
]) 
crafting.addShapeless('MagneticIronDuplication',metaitem('stickIronMagnetic') * 2, [
    metaitem('hot_iron_rod'), 
    metaitem('stickIronMagnetic')
])
crafting.addShapeless('MagneticIronMagentite',metaitem('stickIronMagnetic'), [
    metaitem('hot_iron_rod'), 
    metaitem('chunk.magnetite')
])
crafting.addShaped('MagneticRodVoltaic',metaitem('stickIronMagnetic'), magnetic_rod_ingredients)
crafting.addShaped('VoltaicPileCrafting',metaitem('voltaic_pile'), voltaic_pile_ingredients)
