import static globals.Globals.*

SMOKE_STACK = recipemap('smoke_stack')
FLARE_STACK = recipemap('flare_stack')
MIXER = recipemap('mixer')
DUMPER = recipemap('dumping')
SIFTER = recipemap('sifter')
ROASTER = recipemap('roaster')

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
        .fluidInputs(fluid('steam') * 4000)
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
        .fluidInputs(fluid('nitrogen') * 4000)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('exhaust_steam') * 1000)
        .duration(2)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('flue_gas') * 1000)
        .duration(2)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('coal_gas') * 1000)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('desulfurized_flue_gas') * 1000)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('unscrubbed_wood_gas') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('chilled_flue_gas') * 1000)
        .duration(2)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('sour_gas') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('coal_gas') * 500)
        .duration(20)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('nitrosyl_chloride') * 500)
        .duration(10)
        .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('carbon_tetrachloride') * 500)
        .duration(10)
        .buildAndRegister()

FLARE_STACK.recipeBuilder()
        .fluidInputs(fluid('lubricating_oil') * 500)
        .duration(10)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 100)
        .inputs(ore('dustTinyAsh'))
        .fluidOutputs(fluid('ash_slurry') * 100)
        .duration(5)
        .EUt(7)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 100)
        .inputs(ore('dustTinyDarkAsh'))
        .fluidOutputs(fluid('ash_slurry') * 100)
        .duration(5)
        .EUt(7)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .inputs(ore('dustAsh'))
        .fluidOutputs(fluid('ash_slurry') * 1000)
        .duration(40)
        .EUt(7)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .inputs(ore('dustDarkAsh'))
        .fluidOutputs(fluid('ash_slurry') * 1000)
        .duration(40)
        .EUt(7)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('ash_slurry') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('red_mud') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('concentrated_red_mud') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('chilled_lava') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('coal_tar') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('water') * 1000)
        .duration(5)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('sea_water') * 1000)
        .duration(5)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('salt_water') * 1000)
        .duration(5)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('ammonia_solution') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('crude_pyridinium_sulfate') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('naphthalene_oil') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('anthracene_oil') * 1000)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('triethylenetetramine') * 100)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('aminoethylpiperazine') * 50)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('diethylenetriamine') * 300)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('ethylenediamine') * 500)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('piperazine') * 50)
        .duration(20)
        .buildAndRegister()

DUMPER.recipeBuilder()
        .fluidInputs(fluid('wastewater') * 5000)
        .duration(4)
        .buildAndRegister()
        
DUMPER.recipeBuilder()
        .fluidInputs(fluid('metal_sulfate_waste') * 20000)
        .duration(20)
        .buildAndRegister()

SIFTER.recipeBuilder()
        .fluidInputs(fluid('flue_gas') * 16000)
        .inputs(ore('dustCalcite') * 5)
        .fluidOutputs(fluid('desulfurized_flue_gas') * 16000)
        .outputs(metaitem('dustCalciumSulfite') * 5)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustCalciumSulfite') * 5)
        .circuitMeta(1)
        .fluidOutputs(fluid('sulfur_dioxide') * 1000)
        .outputs(metaitem('dustQuicklime') * 2)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('air') * 1500)
        .inputs(ore('dustCalciumSulfite') * 5)
        .outputs(metaitem('dustCalciumSulfate') * 6)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('oxygen') * 1000)
        .inputs(ore('dustCalciumSulfite') * 5)
        .outputs(metaitem('dustCalciumSulfate') * 6)
        .duration(80)
        .EUt(30)
        .buildAndRegister()