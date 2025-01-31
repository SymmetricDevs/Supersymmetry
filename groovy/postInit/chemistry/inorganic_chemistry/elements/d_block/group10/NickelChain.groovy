import globals.Globals
import globals.CarbonGlobals
import static globals.CarbonGlobals.*

PRIMITIVEBLASTFURNACE = recipemap('primitive_blast_furnace')
EBF = recipemap('electric_blast_furnace')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
MIXER = recipemap('mixer')

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

// NiCl2

ROASTER.recipeBuilder()
        .inputs(ore('dustNickel') * 1)
        .fluidInputs(fluid('chlorine') * 2000)
        .outputs(metaitem('dustNickelChloride') * 3)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

// Ni(OH)2

BR.recipeBuilder()
        .inputs(ore('dustNickelChloride') * 3)
        .fluidInputs(fluid('potassium_hydroxide_solution') * 2000)
        .outputs(metaitem('dustNickelHydroxide') * 5)
        .fluidOutputs(fluid('potassium_chloride_solution') * 2000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

// NiO

ROASTER.recipeBuilder()
        .inputs(ore('dustNickel'))
        .fluidInputs(fluid('oxygen') * 1000)
        .outputs(metaitem('dustNickelIiOxide') * 2)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustNickelHydroxide') * 5)
        .outputs(metaitem('dustNickelIiOxide') * 2)
        .fluidOutputs(fluid('dense_steam') * 1000)
        .EUt(30)
        .duration(200)
        .buildAndRegister()

// NiSO4

BR.recipeBuilder()
        .inputs(ore('dustNickelIiOxide') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('nickel_sulfate_solution') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('nickel_sulfate_solution') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .outputs(metaitem('dustNickelSulfate') * 6)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustNickelSulfate') * 6)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('nickel_sulfate_solution') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()
