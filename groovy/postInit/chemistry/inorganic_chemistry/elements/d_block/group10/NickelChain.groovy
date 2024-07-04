import globals.Globals
import globals.CarbonGlobals
import static globals.CarbonGlobals.*

PRIMITIVEBLASTFURNACE = recipemap('primitive_blast_furnace')
EBF = recipemap('electric_blast_furnace')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')

// Garnierite Dust * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustPentlandite')], [fluid('oxygen') * 3000])

EBF.recipeBuilder()
        .inputs(ore('dustPentlandite'))
        .fluidInputs(fluid('oxygen') * 3000)
        .outputs(metaitem('dustGarnierite'))
        .fluidOutputs(fluid('sulfur_dioxide') * 1000)
        .EUt(30)
        .blastFurnaceTemp(1728)
        .duration(40)
        .buildAndRegister()

for (combustible in combustibles()) {
    PRIMITIVEBLASTFURNACE.recipeBuilder()
            .inputs(ore('dustAnyPurityNickel'))
            .inputs(ore(combustible.name) * combustible.equivalent(1))
            .outputs(metaitem('ingotNickel'))
            .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
            .duration(250)
            .buildAndRegister()

    PRIMITIVEBLASTFURNACE.recipeBuilder()
            .inputs(ore('dustGarnierite'))
            .inputs(ore(combustible.name) * combustible.equivalent(1))
            .outputs(metaitem('ingotNickel'))
            .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
            .duration(250)
            .buildAndRegister()

    PRIMITIVEBLASTFURNACE.recipeBuilder()
            .inputs(ore('dustPentlandite'))
            .inputs(ore(combustible.name) * combustible.equivalent(4))
            .outputs(metaitem('ingotNickel'))
            .outputs(metaitem(combustible.byproduct) * combustible.equivalent(4))
            .duration(250)
            .buildAndRegister()

    EBF.recipeBuilder()
            .inputs(ore('dustGarnierite'))
            .inputs(ore(combustible.name) * combustible.equivalent(1))
            .outputs(metaitem('ingotNickel'))
            .fluidOutputs(fluid('carbon_monoxide') * 1000)
            .EUt(30)
            .blastFurnaceTemp(1728)
            .duration(40)
            .buildAndRegister()
}

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('nickel_sulfate_solution') * 1000)
    .fluidInputs(fluid('water') * 2000)
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustNickel'))
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
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
        .fluidOutputs(fluid('carbon_monoxide') * 4000)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustGarnierite'))
        .fluidInputs(fluid('hydrogen') * 2000)
        .outputs(metaitem('dustNickel'))
        .fluidOutputs(fluid('dense_steam') * 1000)
        .EUt(30)
        .duration(40)
        .buildAndRegister()

