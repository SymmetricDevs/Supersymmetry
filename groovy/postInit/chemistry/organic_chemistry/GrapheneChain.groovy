import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.MarkerMaterials;
import static gregtech.api.unification.ore.OrePrefix.dye;

//Molten Salt Method

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(metaitem("graphite_electrode"))
    .notConsumable(metaitem('stickMolybdenum'))
    .notConsumable(metaitem('crucible.graphite'))
    .fluidInputs(fluid('lithium_chloride') * 576)
    .fluidInputs(fluid('moist_argon') * 1000)
    .fluidOutputs(fluid('impure_lithium_carbonate') * 1008)
    .fluidOutputs(fluid('acidic_argon_hydrogen_mixture') * 2000)
    .duration(600)
    .EUt(VA[EV])
    .buildAndRegister()

SOLIDIFIER.recipeBuilder()
    .notConsumable(metaitem('shape.mold.ball'))
    .fluidInputs(fluid('impure_lithium_carbonate') * 144)
    .outputs(metaitem('dustImpureLithiumCarbonate'))
    .duration(80)
    .EUt(16)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustImpureLithiumCarbonate') * 7)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('impure_lithium_carbonate_solution') * 1000)
    .duration(80)
    .EUt(VA[MV])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('impure_lithium_carbonate_solution') * 10000)
    .outputs(metaitem('dustWashedGraphene') * 10)
    .fluidOutputs(fluid('lithium_carbonate_solution') * 10000)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

VACUUM_DT.recipeBuilder()
    .inputs(ore('dustWashedGraphene'))
    .outputs(metaitem('dustDistilledGraphene'))
    .duration(20)
    .EUt(VA[HV])
    .buildAndRegister()

DRYER.recipeBuilder()
    .inputs(ore('dustDistilledGraphene'))
    .outputs(metaitem('dustDriedGraphene'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister()

TUBE_FURNACE.recipeBuilder()
    .inputs(ore('dustDriedGraphene'))
    .fluidInputs(fluid('argon') * 50)
    .outputs(metaitem('dustGraphene'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('lithium_carbonate_solution') * 1000)
    .outputs(metaitem('gregtechfoodoption:lithium_carbonate_dust') * 6)
    .fluidOutputs(fluid('water') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

//Argon preparation and recycling

BCR.recipeBuilder()
    .fluidInputs(fluid('argon') * 50)
    .fluidInputs(fluid('water') * 50)
    .fluidOutputs(fluid('moist_argon') * 100)
    .duration(2)
    .EUt(16)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('acidic_argon_hydrogen_mixture') * 1000)
    .fluidInputs(fluid('ammonia') * 2000)
    .outputs(metaitem('dustAmmoniumChloride') * 6)
    .fluidOutputs(fluid('ammoniacal_argon_hydrogen_mixture') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

VACUUM_FREEZER.recipeBuilder()
    .fluidInputs(fluid('ammoniacal_argon_hydrogen_mixture') * 1000)
    .fluidOutputs(fluid('cold_ammoniacal_argon_hydrogen_mixture') * 875)
    .duration(200)
    .EUt(60)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('cold_ammoniacal_argon_hydrogen_mixture') * 875)
    .fluidOutputs(fluid('cold_ammonia') * 500)
    .fluidOutputs(fluid('cold_argon_hydrogen_mixture') * 320)
    .duration(20)
    .buildAndRegister()

VACUUM_FREEZER.recipeBuilder()
    .fluidInputs(fluid('cold_argon_hydrogen_mixture') * 1280)
    .fluidOutputs(fluid('partially_liquefied_argon_hydrogen_mixture') * 1000)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister();

SINGLE_COLUMN_CRYO_DT.recipeBuilder()
    .fluidInputs(fluid('partially_liquefied_argon_hydrogen_mixture') * 16000)
    .fluidOutputs(fluid('liquid_argon') * 125)
    .fluidOutputs(fluid('hydrogen') * 16000)
    .duration(40)
    .EUt(VA[HV])
    .buildAndRegister()

//Source (graphene oxide):  https://onlinelibrary.wiley.com/doi/full/10.1002/smll.202408972

// Electrolytic oxidation
ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('stickPlatinum'))
        .inputs(metaitem('carbon.fibers') * 16)
        .fluidInputs(fluid('nitric_acid') * 50)
        .fluidInputs(fluid('water') * 950)
        .fluidOutputs(fluid('graphene_oxide_dispersion') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

DRYER.recipeBuilder()
        .fluidInputs(fluid('graphene_oxide_dispersion') * 1000)
        .outputs(metaitem('dustGrapheneOxide'))
        .fluidOutputs(fluid('dense_steam') * 1000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

// Hummer's method (chemical oxidation)
BR.recipeBuilder()
        .inputs(ore('dustGraphite'))
        .inputs(ore('dustSmallSodiumNitrate') * 2)
        .inputs(ore('dustPotassiumPermanganate') * 2)
        .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
        .outputs(metaitem('dustGrapheneOxide'))
        .fluidOutputs(fluid('acidic_wastewater') * 2000)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()