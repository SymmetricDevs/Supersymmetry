import static globals.Globals.*

PRIMITIVEBLASTFURNACE = recipemap('primitive_blast_furnace')
EBF = recipemap('electric_blast_furnace')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')

for (combustible in Globals.combustibles) {
    PRIMITIVEBLASTFURNACE.recipeBuilder()
            .inputs(ore('dustNickel'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .outputs(metaitem('ingotNickel'))
            .outputs(metaitem(combustible.byproduct) * (combustible.amount_required))
            .duration(200)
            .buildAndRegister()

    PRIMITIVEBLASTFURNACE.recipeBuilder()
            .inputs(ore('dustGarnierite'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .outputs(metaitem('ingotNickel'))
            .outputs(metaitem(combustible.byproduct) * (combustible.amount_required))
            .duration(200)
            .buildAndRegister()

    PRIMITIVEBLASTFURNACE.recipeBuilder()
            .inputs(ore('dustPentlandite'))
            .inputs(ore(combustible.name) * (combustible.amount_required) * 4)
            .outputs(metaitem('ingotNickel') * 9)
            .outputs(metaitem(combustible.byproduct) * (combustible.amount_required) * 4)
            .duration(1200)
            .buildAndRegister()

    EBF.recipeBuilder()
            .inputs(ore('dustGarnierite'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .outputs(metaitem('ingotNickel'))
            .fluidOutputs(fluid('carbon_monoxide') * 1000)
            .EUt(30)
            .blastFurnaceTemp(1728)
            .duration(100)
            .buildAndRegister()
}

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('nickel_sulfate_solution') * 1000)
    .fluidInputs(fluid('water') * 500)
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('water') * 1500)
    .outputs(ore('dustNickel').first())
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 500)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//MOND PROCESS

BR.recipeBuilder()
        .inputs(ore('dustNickel'))
        .fluidInputs(fluid('carbon_monoxide') * 4000)
        .fluidOutputs(fluid('nickel_carbonyl') * 1000)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('nickel_carbonyl') * 1000)
        .outputs(metaitem('dustHighPurityNickel'))
        .fluidOutputs(fluid('carbon_monoxide') * 4000)\
        .EUt(30)
        .duration(200)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustGarnierite'))
        .fluidInputs(fluid('hydrogen') * 2000)
        .outputs(metaitem('dustNickel'))
        .fluidOutputs(fluid('steam') * 1000)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

