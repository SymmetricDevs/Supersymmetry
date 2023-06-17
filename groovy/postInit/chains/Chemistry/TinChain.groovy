AUTOCLAVE = recipemap('autoclave')
ROASTER = recipemap('roaster')
FLOTATION = recipemap('froth_flotation')
EM_SEPARATOR = recipemap('electromagnetic_separator')
BR = recipemap('batch_reactor')

//CASSITERITE BENEFICIATION
FLOTATION.recipeBuilder()
        .inputs(metaitem('dustImpureCassiterite') * 30)
        .inputs(metaitem('dustSodiumFluorosilicate'))
        .notConsumable(fluid('oleic_acid') * 144)
        //.notConsumable(fluid('methyl_isobutyl_carbitol') * 100) //ADD WHEN MIBK IS IMPLEMENTED
        .notConsumable(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustCassiterite') * 60)
        .chancedOutput(metaitem('dustSodiumFluorosilicate'), 9999, 0)
        .EUt(480)
        .duration(800)
        .buildAndRegister()

EM_SEPARATOR.recipeBuilder()
        .inputs(metaitem('dustCassiterite'))
        .outputs(metaitem('dustCassiteriteConcentrate'))
        .chancedOutput(metaitem('dustHematite'), 2500, 0)
        .EUt(7)
        .duration(100)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustCassiteriteConcentrate'))
        .fluidInputs(fluid('ammonia_solution') * 60)
        .fluidOutputs(fluid('ammonium_tungstate_solution') * 60)
        .outputs(metaitem('dustLeachedCassiteriteConcentrate'))

//SMELTING
class Combustible {
    String name
    String byproduct
    int amount_required
    int duration
    Combustible(name, amount_required, duration, byproduct = 'dustTinyDarkAsh') {
        this.name = name
        this.amount_required = amount_required
        this.duration = duration
        this.byproduct = byproduct
    }
}

def combustibles = [
        new Combustible('gemCoke', 1, 3, 'dustTinyAsh'),
        new Combustible('dustCoke', 1, 3, 'dustTinyAsh'),
        new Combustible('gemAnthracite', 1, 2, 'dustTinyAsh'),
        new Combustible('dustAnthracite', 1, 2, 'dustTinyAsh'),
        new Combustible('gemCoal', 2, 4),
        new Combustible('dustCoal', 2, 4),
        new Combustible('gemCharcoal', 2, 4),
        new Combustible('dustCharcoal', 2, 4)
]

for (combustible in combustibles) {
    EBF.recipeBuilder()
            .inputs(ore('dustCassiteriteConcentrate'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_tin') * 144)
            .fluidOutputs(fluid('carbon_dioxide') * 1000)
            .EUt(120)
            .blastFurnaceTemp(1100)
            .duration(160)
            .buildAndRegister()

            .inputs(ore('dustLeachedCassiteriteConcentrate'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_tin') * 144)
            .fluidOutputs(fluid('carbon_dioxide') * 1000)
            .EUt(120)
            .blastFurnaceTemp(1100)
            .duration(160)
            .buildAndRegister()
}

FLUID_SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .fluidInputs(fluid('crude_tin') * 216)
        .outputs(metaitem('ingotTin'))
        .EUt(7)
        .duration(20)
        .buildAndRegister()


AUTOCLAVE.recipeBuilder()
        .notConsumable(fluid('sulfuric_acid') * 1000)
        .fluidInputs(fluid('hot_hp_oxygen') * 1000)
        .inputs(metaitem('dustTin'))
        .outputs(metaitem('dustPurifiedTinIiOxide') * 2)
        .EUt(480)
        .duration(120)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustPurifiedTinIiOxide') * 2)
        .fluidInputs(fluid('hydrogen') * 2000)
        .outputs(metaitem('dustHighPurityTin'))
        .fluidOutputs(fluid('steam') * 1000)
        .EUt(120)
        .duration(120)
        .buildAndRegister()