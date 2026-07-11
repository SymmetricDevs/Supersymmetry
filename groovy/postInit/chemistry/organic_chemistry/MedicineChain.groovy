import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Paracetamol

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustFourChloronitrobenzene'))
    .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 2000)
    .outputs(metaitem('dustFourNitrophenol') * 15)
    .fluidOutputs(fluid('diluted_salt_water') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

TBR.recipeBuilder()
    .inputs(ore('dustFourNitrophenol') * 15)
    .fluidInputs(fluid('hydrogen') * 6000)
    .fluidInputs(fluid('isopropyl_alcohol') * 1000)
    .notConsumable(metaitem('dustActivatedRaneyNickel'))
    .fluidOutputs(fluid('four_aminophenol_solution') * 3000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

LCR.recipeBuilder()
    .notConsumable(ore('dustActivatedRaneyCopper'))
    .notConsumable(fluid('diluted_sulfuric_acid') * 2000)
    .notConsumable(fluid('isopropyl_alcohol') * 1000)
    .fluidInputs(fluid('nitrobenzene') * 1000)
    .fluidInputs(fluid('hydrogen') * 5000)
    .outputs(metaitem('dustFourAminophenol') * 15)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('four_aminophenol_solution') * 3000)
    .outputs(metaitem('dustFourAminophenol') * 15)
    .fluidOutputs(fluid('water') * 2000)
    .fluidOutputs(fluid('isopropyl_alcohol') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustFourAminophenol') * 15)
    .fluidInputs(fluid('gtfo_acetic_anhydride') * 1000)
    .outputs(metaitem('dustParacetamol') * 20)
    .fluidOutputs(fluid('acetic_acid') * 2000)
    .duration(100)
    .EUt(VA[EV])
    .buildAndRegister()

// Paracetamol Caplet * 1
mods.gregtech.forming_press.removeByInput(30, [metaitem('gregtechfoodoption:component.caplet_body'), metaitem('dustSmallParacetamol'), metaitem('gregtechfoodoption:component.caplet_cap'), metaitem('circuit.integrated').withNbt(['Configuration': 3])], null)

FORMING_PRESS.recipeBuilder() 
    .inputs(metaitem('gregtechfoodoption:component.caplet_body') * 8)
    .inputs(ore('dustParacetamol') * 1)
    .inputs(metaitem('gregtechfoodoption:component.caplet_cap') * 8)
    .outputs(metaitem('gregtechfoodoption:food.paracetamol_caplet') * 8)
    .duration(40)
    .EUt(VA[IV])
    .buildAndRegister() 
