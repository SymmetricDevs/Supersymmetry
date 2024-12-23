import globals.Globals
import static globals.CarbonGlobals.*

ROASTER = recipemap('roaster')
EBF = recipemap('electric_blast_furnace')
PBF_RECIPES = recipemap("primitive_blast_furnace")
FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
MIXER = recipemap('mixer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')

//ROAST RECOVERY OF As2O3
//COBALTITE MODIFICATION
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCobaltite')], [fluid('oxygen') * 3000])


EBF.recipeBuilder()
        .inputs(ore('dustCobaltite') * 2)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustImpureCobaltOxide') * 2)
        .chancedOutput(metaitem('dustArsenicTrioxide') * 5, 7500, 0)
        .fluidOutputs(fluid('sulfur_dioxide') * 2000)
        .EUt(Globals.voltAmps[1])
        .blastFurnaceTemp(1023)
        .duration(240)
        .buildAndRegister()

FLUIDIZEDBR.recipeBuilder()
        .inputs(ore('dustCobaltite') * 2)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustImpureCobaltOxide') * 4)
        .chancedOutput(metaitem('dustArsenicTrioxide') * 5, 9000, 0)
        .fluidOutputs(fluid('sulfur_dioxide') * 2000)
        .EUt(Globals.voltAmps[2])
        .duration(120)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustImpureCobaltOxide'))
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('impure_cobalt_sulfate_solution') * 1000)
        .EUt(Globals.voltAmps[1])
        .duration(240)
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('stickCobalt'))
        .notConsumable(metaitem('graphite_electrode'))
        .fluidInputs(fluid('impure_cobalt_sulfate_solution') * 1000)
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('oxygen') * 1000)
        .EUt(Globals.voltAmps[2])
        .duration(240)
        .buildAndRegister()

for (combustible in combustibles()) {
    EBF.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .blastFurnaceTemp(1200)
        .duration(240)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
}

// Primitive ways for getting impure cobalt (cobalt matte) for Kovar.
def cobalt_matte_recipes = [
        ["oreCobaltite", 1],
        ["oreNetherrackCobaltite", 2],
        ["oreEndstoneCobaltite", 2],
        ["dustCobaltite", 1],
]

cobalt_matte_recipes.forEach { recipe ->
    combustibles().forEach { combustible ->
        PBF_RECIPES.recipeBuilder()
                .inputs(ore(recipe[0]))
                .inputs(ore(combustible.name) * (combustible.equivalent(2)))
                .outputs(metaitem('ingotCobaltMatte') * recipe[1])
                .duration(80 * recipe[1])
                .buildAndRegister()
    }
}

// CoO

ROASTER.recipeBuilder()
        .inputs(ore('dustCobalt'))
        .fluidInputs(fluid('oxygen') * 1000)
        .outputs(metaitem('dustCobaltOxide') * 2)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

// CoSO4

BR.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('cobalt_sulfate_solution') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('cobalt_sulfate_solution') * 1000)
        .outputs(metaitem('dustCobaltSulfate') * 6)
        .fluidOutputs(fluid('water') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustCobaltSulfate') * 6)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('cobalt_sulfate_solution') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()
