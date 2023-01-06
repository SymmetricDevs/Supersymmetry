import com.cleanroommc.groovyscript.api.GroovyLog

println("Running AppliedEnergistics.groovy...")

def circuit(x) {
        return metaitem('circuit.integrated').withNbt([Configuration: x])
}

def name_removals = [
        'appliedenergistics2:misc/grindstone_woodengear',
        'appliedenergistics2:decorative/quartz_glass',
        'appliedenergistics2:decorative/quartz_vibrant_glass',
        'appliedenergistics2:misc/meteors_sky_compass',
        'appliedenergistics2:network/blocks/crystal_processing_charger'
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.replaceShaped('appliedenergistics2:misc/grindstone', item('appliedenergistics2:grindstone'), [
        [ore('stone'), ore('gearWood'), ore('stone')],
        [ore('gemFlint'), ore('stone'), ore('gemFlint')],
        [ore('cobblestone'), ore('gemFlint'), ore('cobblestone')]
])

crafting.replaceShaped('appliedenergistics2:decorative/quartz_fixture', item('appliedenergistics2:quartz_fixture') * 1, [
        [null, null, null],
        [item('appliedenergistics2:material'), ore('ringIron'), null],
        [null, null, null]
])

crafting.replaceShaped('appliedenergistics2:decorative/light_detector', item('appliedenergistics2:light_detector') * 1, [
        [null, null, null],
        [ore('gemNetherQuartz'), ore('ringIron'), null],
        [null, null, null]
])

//GT Machines Recipes

def quartz_dusts = [
        'dustCertusQuartz',
        'dustNetherQuartz',
        'dustQuartzite'
]

for(quartz in quartz_dusts) {
        mods.gregtech.electric_blast_furnace.recipeBuilder()
                .inputs(ore(quartz) * 60)
                .notConsumable(circuit(1))
                .outputs(item('appliedenergistics2:quartz_glass') * 60)
                .blastFurnaceTemp(2500)
                .duration(1200)
                .EUt(60)
                .buildAndRegister();

        mods.gregtech.electric_blast_furnace.recipeBuilder()
                .inputs(ore(quartz) * 60)
                .inputs(ore('dustGlowstone') * 1)
                .outputs(item('appliedenergistics2:quartz_vibrant_glass') * 60)
                .blastFurnaceTemp(2500)
                .duration(1200)
                .EUt(60)
                .buildAndRegister();
}