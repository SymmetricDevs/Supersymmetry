AUTOCLAVE = recipemap('autoclave')
ROASTER = recipemap('roaster')
FLOTATION = recipemap('froth_flotation')
EM_SEPARATOR = recipemap('electromagnetic_separator')
BR = recipemap('batch_reactor')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
REACTION_FURNACE = recipemap('reaction_furnace')
CENTRIFUGE = recipemap('centrifuge')
CRYSTALLIZER = recipemap('crystallizer')

// Tin Dust * 1
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('crude_tin') * 1000])

//CASSITERITE BENEFICIATION
FLOTATION.recipeBuilder()
        .inputs(metaitem('dustImpureCassiterite') * 30)
        .notConsumable(metaitem('dustSodiumFluorosilicate'))
        .notConsumable(fluid('oleic_acid') * 144)
        //.notConsumable(fluid('methyl_isobutyl_carbitol') * 100) //ADD WHEN MIBK IS IMPLEMENTED
        .notConsumable(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustCassiterite') * 60)
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
        .EUt(1920)
        .duration(100)
        .buildAndRegister()

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
    REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustCassiteriteConcentrate'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_tin') * 190)
            .fluidOutputs(fluid('tin_dross') * 25)
            .fluidOutputs(fluid('carbon_dioxide') * 1000)
            .EUt(120)
            .duration(160)
            .buildAndRegister()

    REACTION_FURNACE.recipeBuilder()
            .inputs(ore('dustLeachedCassiteriteConcentrate'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_tin') * 190)
            .fluidOutputs(fluid('tin_dross') * 25)
            .fluidOutputs(fluid('carbon_dioxide') * 1000)
            .EUt(120)
            .duration(160)
            .buildAndRegister()
}

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('tin_dross') * 100)
        .fluidOutputs(fluid('crude_tin') * 85)
        .fluidOutputs(fluid('iron') * 15)
        .EUt(32)
        .duration(80)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .fluidInputs(fluid('crude_tin') * 216)
        .outputs(metaitem('ingotTin'))
        .EUt(7)
        .duration(20)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .fluidInputs(fluid('decopperized_tin') * 180)
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

ROASTER.recipeBuilder()
        .fluidInputs(fluid('ammonium_tungstate_solution') * 1000)
        .outputs(metaitem('dustTungstenTrioxide') * 4)
        .fluidOutputs(fluid('steam') * 3000)
        .fluidOutputs(fluid('ammonia') * 2000)
        .EUt(1920)
        .duration(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(metaitem('dustSulfur'))
        .fluidInputs(fluid('crude_tin') * 5760)
        .fluidOutputs(fluid('decopperized_tin') * 5760)
        .outputs(metaitem('dustCopperMonosulfide') * 2)
        .EUt(32)
        .duration(300)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 2000)
        .inputs(metaitem('dustCopperMonosulfide') * 2)
        .outputs(metaitem('dustCopper'))
        .fluidOutputs(fluid('sulfur_dioxide') * 1000)
        .EUt(32)
        .duration(120)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('decopperized_tin') * 2880)
        .notConsumable(metaitem('wireFineAluminium'))
        .chancedOutput(metaitem('dustAntimony'), 500, 0)
        .chancedOutput(metaitem('dustBismuth'), 500, 0)
        .fluidOutputs(fluid('tin') * 2880)
        .EUt(32)
        .duration(160)
        .buildAndRegister()