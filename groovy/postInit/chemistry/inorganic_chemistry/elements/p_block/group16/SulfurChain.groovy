import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ROASTER.recipeBuilder()
    .inputs(ore('dustPyrite') * 2)
    .outputs(metaitem('dustIronIiiSulfate'))
    .outputs(metaitem('dustSulfur'))
    .duration(80)
    .EUt(VA[ULV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiiSulfate'))
    .outputs(metaitem('dustBandedIron'))
    .fluidOutputs(fluid('sulfur_trioxide') * 3000)
    .info("recipe.iron_iii_sulfate.roasting")
    .duration(160)
    .EUt(VA[ULV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('air') * 15000) //air is composed of ~21% oxygen
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .outputs(metaitem('dustSulfur') * 2)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

// Sodium bisulfite

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfur_dioxide') * 50)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 50)
    .fluidOutputs(fluid('sodium_bisulfite_solution') * 50)
    .duration(4)
    .EUt(VA[LV])
    .buildAndRegister()

// Sodium dithionite

BR.recipeBuilder()
    .inputs(ore('dustAnyPurityZinc'))
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('sulfur_dioxide') * 2000)
    .fluidOutputs(fluid('zinc_dithionite_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 6)
    .fluidInputs(fluid('zinc_dithionite_solution') * 1000)
    .fluidOutputs(fluid('sodium_dithionite_solution') * 1000)
    .outputs(metaitem('dustZincHydroxide') * 5)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_dithionite_solution') * 1000)
    .outputs(metaitem('dustSodiumDithionite') * 7)
    .fluidOutputs(fluid('water') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()