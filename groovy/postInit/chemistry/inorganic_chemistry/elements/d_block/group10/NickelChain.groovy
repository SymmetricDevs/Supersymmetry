import static prePostInit.Recipemaps.*
import globals.Carbons
import static gregtech.api.GTValues.*

// Garnierite Dust * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustPentlandite')], [fluid('oxygen') * 3000])

// Beneficiation

//MODERN SEPARATION PROCESSES
GRAVITY_SEPARATOR.recipeBuilder() 
    .inputs(ore('dustPentlandite'))
    .outputs(metaitem('dustSiftedPentlandite'))
    .chancedOutput(metaitem('dustUltramaficTailings'), 2500, 0)
    .EUt(VA[LV])
    .duration(40)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSiftedPentlandite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_pentlandite_slurry') * 2000)
    .EUt(VA[HV])
    .duration(80)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .fluidInputs(fluid('impure_pentlandite_slurry') * 2000)
    .notConsumable(ore('dustSodiumIsobutylXanthate'))
    .notConsumable(fluid('copper_sulfate_solution') * 100)
    .notConsumable(fluid('cresol') * 100)
    .fluidOutputs(fluid('pentlandite_slurry') * 1000)
    .fluidOutputs(fluid('ultramafic_tailing_slurry') * 1000)
    .EUt(VA[HV])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('pentlandite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedPentlandite') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

// Furnace conversion

ERF.recipeBuilder()
    .inputs(ore('dustPentlandite'))
    .fluidInputs(fluid('oxygen') * 3000)
    .outputs(metaitem('dustGarnierite'))
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .EUt(VA[LV])
    .blastFurnaceTemp(1728)
    .duration(40)
    .buildAndRegister()

ERF.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustFlotatedPentlandite'))
    .fluidInputs(fluid('oxygen') * 3000)
    .outputs(metaitem('dustGarnierite'))
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .EUt(VA[LV])
    .blastFurnaceTemp(1728)
    .duration(40)
    .buildAndRegister()

for (combustible in Carbons.combustibles()) {
    PBF.recipeBuilder()
        .inputs(ore('dustAnyPurityNickel'))
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .outputs(metaitem('ingotNickel'))
        .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
        .duration(250)
        .buildAndRegister()

    PBF.recipeBuilder()
        .inputs(ore('dustGarnierite'))
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .outputs(metaitem('ingotNickel'))
        .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
        .duration(250)
        .buildAndRegister()

    PBF.recipeBuilder()
        .inputs(ore('dustPentlandite'))
        .inputs(ore(combustible.name) * combustible.equivalent(4))
        .outputs(metaitem('ingotNickel'))
        .outputs(metaitem(combustible.byproduct) * combustible.equivalent(4))
        .duration(250)
        .buildAndRegister()

    ERF.recipeBuilder()
        .inputs(ore('dustGarnierite'))
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .outputs(metaitem('ingotNickel'))
        .fluidOutputs(fluid('carbon_monoxide') * 1000)
        .EUt(VA[LV])
        .blastFurnaceTemp(1728)
        .duration(40)
        .buildAndRegister()
}

ELECTROLYTIC_CELL.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('nickel_sulfate_solution') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustNickel'))
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('nickel_sulfate_solution') * 1000)
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(metaitem('dustNickel'))
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()

//MOND PROCESS

BR.recipeBuilder()
    .inputs(ore('dustNickel'))
    .fluidInputs(fluid('carbon_monoxide') * 4000)
    .fluidOutputs(fluid('nickel_carbonyl') * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('nickel_carbonyl') * 1000)
    .outputs(metaitem('dustHighPurityNickel'))
    .fluidOutputs(fluid('carbon_monoxide') * 4000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustGarnierite'))
    .fluidInputs(fluid('hydrogen') * 2000)
    .outputs(metaitem('dustNickel'))
    .fluidOutputs(fluid('dense_steam') * 1000)
    .EUt(VA[LV])
    .duration(40)
    .buildAndRegister()

// NiCl2

ROASTER.recipeBuilder()
    .inputs(ore('dustNickel') * 1)
    .fluidInputs(fluid('chlorine') * 2000)
    .outputs(metaitem('dustNickelChloride') * 3)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('nickel_chloride_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustNickelChloride') * 3)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustNickelChloride') * 3)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('nickel_chloride_solution') * 1000)
    .duration(80)
    .EUt(VA[ULV])
    .buildAndRegister()

// Ni(OH)2

BR.recipeBuilder()
    .inputs(ore('dustNickelChloride') * 3)
    .fluidInputs(fluid('potassium_hydroxide_solution') * 2000)
    .outputs(metaitem('dustNickelHydroxide') * 5)
    .fluidOutputs(fluid('potassium_chloride_solution') * 2000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// NiO

ROASTER.recipeBuilder()
    .inputs(ore('dustNickel'))
    .fluidInputs(fluid('oxygen') * 1000)
    .outputs(metaitem('dustNickelIiOxide') * 2)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustNickelHydroxide') * 5)
    .outputs(metaitem('dustNickelIiOxide') * 2)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

// NiSO4

BR.recipeBuilder()
    .inputs(ore('dustNickelIiOxide') * 2)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('nickel_sulfate_solution') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('nickel_sulfate_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustNickelSulfate') * 6)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustNickelSulfate') * 6)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('nickel_sulfate_solution') * 1000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

