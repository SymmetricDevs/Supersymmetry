import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Zeolite membranes (Gas separation)

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustSodiumHydroxide') * 36)
    .inputs(metaitem('membrane.support.alumina'))
    .fluidInputs(fluid('sodium_aluminate_solution') * 750)
    .fluidInputs(fluid('sodium_silicate_solution') * 1500)
    .fluidInputs(fluid('distilled_water') * 4750)
    .outputs(metaitem('membrane.zeolite'))
    .duration(180)
    .EUt(VA[LV])
    .buildAndRegister()

// Cellulose acetate membranes (RO)

CHEMICAL_BATH.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .fluidInputs(fluid('cellulose_acetate_solution') * 1000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .outputs(metaitem('membrane.cellulose_acetate'))
    .fluidOutputs(fluid('diluted_acetone') * 2000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

// Polysulfone membranes (ultrafiltration)

MIXER.recipeBuilder()
    .inputs(ore('dustPolysulfone'))
    .fluidInputs(fluid('n_methyl_two_pyrrolidone') * 1000)
    .fluidOutputs(fluid('polysulfone_solution') * 1000)
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .notConsumable(metaitem('shape.mold.plate'))
    .fluidInputs(fluid('polyethylene_glycol') * 100)
    .fluidInputs(fluid('polysulfone_solution') * 1000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .outputs(metaitem('membrane.polysulfone'))
    .fluidOutputs(fluid('diluted_n_methyl_two_pyrrolidone') * 2000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister() 

// Ion exchange membranes

    // Proton exchange membrane --> Nafion chain

    // Anion exchange membrane: PS-DVB functionalized with quaternary ammonium groups

    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('plateFunctionalizableCrosslinkedPolystyrene'))
        .fluidInputs(fluid('trimethylamine') * 100)
        .outputs(metaitem('membrane.anion_exchange'))
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

    // Cation exchange membrane: PS-DVB functionalized with sulfonic acid groups

    CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('plateCrosslinkedPolystyrene'))
        .fluidInputs(fluid('oleum') * 300)
        .outputs(metaitem('membrane.cation_exchange'))
        .fluidOutputs(fluid('sulfuric_acid') * 200)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()