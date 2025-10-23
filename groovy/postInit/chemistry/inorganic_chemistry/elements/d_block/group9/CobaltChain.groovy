import static prePostInit.Recipemaps.*
import globals.Carbons
import static gregtech.api.GTValues.*

//ROAST RECOVERY OF As2O3
//COBALTITE MODIFICATION
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCobaltite')], [fluid('oxygen') * 3000])

ERF.recipeBuilder()
        .inputs(ore('dustCobaltite') * 2)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustCobaltOxide') * 2)
        .chancedOutput(metaitem('dustArsenicTrioxide') * 5, 7500, 0)
        .fluidOutputs(fluid('sulfur_dioxide') * 2000)
        .EUt(VA[LV])
        .blastFurnaceTemp(1023)
        .duration(240)
        .buildAndRegister()

FLUIDIZED_BR.recipeBuilder()
        .inputs(ore('dustCobaltite') * 2)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustCobaltOxide') * 4)
        .chancedOutput(metaitem('dustArsenicTrioxide') * 5, 9000, 0)
        .fluidOutputs(fluid('sulfur_dioxide') * 2000)
        .EUt(VA[MV])
        .duration(120)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('cobalt_sulfate_solution') * 1000)
        .EUt(VA[LV])
        .duration(240)
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .circuitMeta(1)
        .notConsumable(metaitem('stickCobalt'))
        .notConsumable(metaitem('graphite_electrode'))
        .fluidInputs(fluid('cobalt_sulfate_solution') * 1000)
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('oxygen') * 1000)
        .EUt(VA[MV])
        .duration(240)
        .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
        .circuitMeta(2)
        .notConsumable(metaitem('stickCobalt'))
        .notConsumable(metaitem('graphite_electrode'))
        .fluidInputs(fluid('cobalt_sulfate_solution') * 1000)
        .outputs(metaitem('dustHighPurityCobalt'))
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .fluidOutputs(fluid('oxygen') * 1000)
        .EUt(VA[MV])
        .duration(240)
        .buildAndRegister()

for (combustible in Carbons.combustibles()) {
    ERF.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .outputs(metaitem('dustCobalt'))
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .blastFurnaceTemp(1200)
        .duration(240)
        .EUt(VA[LV])
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
    Carbons.combustibles().forEach { combustible ->
        PBF.recipeBuilder()
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
        .EUt(VA[LV])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustHighPurityCobalt'))
        .fluidInputs(fluid('oxygen') * 1000)
        .outputs(metaitem('dustHighPurityCobaltOxide') * 2)
        .duration(120)
        .EUt(VA[LV])
        .buildAndRegister()

// CoSO4

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('cobalt_sulfate_solution') * 1000)
        .outputs(metaitem('dustCobaltSulfate') * 6)
        .fluidOutputs(fluid('water') * 1000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustCobaltSulfate') * 6)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('cobalt_sulfate_solution') * 1000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()
