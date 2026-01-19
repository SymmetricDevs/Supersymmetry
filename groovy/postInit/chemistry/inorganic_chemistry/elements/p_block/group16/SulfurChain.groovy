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

// Sulfates and bisulfates

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_ammonium_sulfate_solution') * 1000)
    .outputs(metaitem('dustAmmoniumSulfate') * 15)
    .fluidOutputs(fluid('water') * 2000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAmmoniumSulfate') * 15)
    .fluidOutputs(fluid('ammonia') * 1000)
    .outputs(metaitem('dustAmmoniumBisulfate') * 11)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

// Sulfites and bisulfites

BCR.recipeBuilder()
    .fluidInputs(fluid('sulfur_dioxide') * 50)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 50)
    .fluidOutputs(fluid('sodium_bisulfite_solution') * 50)
    .duration(4)
    .EUt(VA[LV])
    .buildAndRegister()

// Polysulfides

BR.recipeBuilder()
    .notConsumable(fluid('argon') * 1000)
    .fluidInputs(fluid('sodium') * 288)
    .fluidInputs(fluid('sulfur') * 576)
    .outputs(metaitem('dustSodiumPolysulfide') * 6)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()
