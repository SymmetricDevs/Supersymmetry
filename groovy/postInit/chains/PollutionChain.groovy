import static globals.Globals.*

SMOKE_STACK = recipemap('smoke_stack')
FLARE_STACK = recipemap('flare_stack')

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('carbon_dioxide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('carbon_monoxide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('steam') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('sulfur_trioxide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('sulfur_dioxide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('nitric_oxide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('nitrogen_dioxide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('hydrogen_sulfide') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('nitrogen') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('unscrubbed_wood_gas') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('chilled_flue_gas') * 1000)
        .duration(10)
        .buildAndRegister()