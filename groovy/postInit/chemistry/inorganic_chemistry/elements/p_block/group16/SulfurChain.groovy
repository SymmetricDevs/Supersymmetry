import globals.Globals

ROASTER = recipemap('roaster');
REACTION_FURNACE = recipemap('reaction_furnace')
CRYSTALLIZER = recipemap('crystallizer')
BR = recipemap('batch_reactor')

// Banded Iron Dust * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustPyrite')], [fluid('oxygen') * 3000])


//Steam-Age source of SO3/H2SO4
ROASTER.recipeBuilder()
	.inputs(ore('dustAnglesite'))
	.outputs(metaitem('dustMassicot') * 2)
	.fluidOutputs(fluid('sulfur_trioxide') * 1000)
	.duration(400)
	.EUt(30)
	.buildAndRegister()

//Pyrite roasting for SO2
ROASTER.recipeBuilder()
	.circuitMeta(1)
	.inputs(ore('dustPyrite') * 1)
	.outputs(metaitem('dustIronIISulfide') * 2)
	.outputs(metaitem('dustSulfur'))
	.duration(80)
	.EUt(16)
	.buildAndRegister()

ROASTER.recipeBuilder()
	.circuitMeta(1)
	.inputs(ore('dustIronIISulfide') * 2)
	.fluidInputs(fluid('oxygen') * 3000)
	.outputs(metaitem('dustBandedIron') * 2)
	.fluidOutputs(fluid('sulfur_dioxide') * 1000)
	.duration(80)
	.EUt(30)
	.buildAndRegister()

ROASTER.recipeBuilder()
	.inputs(ore('dustPyrite') * 1)
	.fluidInputs(fluid('oxygen') * 5000)
	.outputs(metaitem('dustBandedIron') * 2)
	.fluidOutputs(fluid('sulfur_dioxide') * 2000)
	.duration(160)
	.EUt(30)
	.buildAndRegister()

//Wet Oxidation of Pyrite
CRYSTALLIZER.recipeBuilder()
	.inputs(ore('dustPyrite') * 2)
	//.fluidInputs(fluid('oxygen') * 15000) //technically this process is done by using air but you can't fit 45k air or 15k oxygen into an LV crystallizer
	.outputs(metaitem('dustIronIiiSulfate') * 17)
	.fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
	.duration(160)
	.EUt(30)
	.buildAndRegister()

ROASTER.recipeBuilder()
	.inputs(ore('dustIronIiiSulfate') * 17)
	.outputs(metaitem('dustBandedIron') * 2)
	.fluidOutputs(fluid('sulfur_trioxide') * 3000)
	.duration(160)
	.EUt(30)
	.buildAndRegister()

// Sulfur Trioxide

ROASTER.recipeBuilder()
	.fluidInputs(fluid('oxygen') * 4000)
	.fluidInputs(fluid('sulfur_dioxide') * 4000)
	.notConsumable(ore('dustVanadiumPentoxide'))
	.fluidOutputs(fluid('sulfur_trioxide') * 4000)
	.duration(40)
	.EUt(30)
	.buildAndRegister()

//Lead chamber process

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidInputs(fluid('dense_steam') * 3000)
    .fluidInputs(fluid('sulfur_dioxide') * 1000)
    .fluidInputs(fluid('nitrogen_dioxide') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 4000)
    .fluidOutputs(fluid('nitric_oxide') * 1000)
    .duration(320)
    .EUt(7)

/*ROASTER.recipeBuilder()
    .inputs(ore('dustPyrite') * 2)
    .outputs(metaitem('dustIronIiiSulfate'))
    .outputs(metaitem('dustSulfur'))
    .duration(80)
    .EUt(7)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiiSulfate'))
    .outputs(metaitem('dustBandedIron'))
    .fluidOutputs(fluid('sulfur_trioxide') * 3000)
    .duration(160)
    .EUt(7)
    .buildAndRegister()*/

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('oxygen') * 3000)
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hydrogen_sulfide') * 3000)
    .fluidInputs(fluid('air') * 15000) //air is composed of ~21% oxygen
    .fluidOutputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .outputs(metaitem('dustSulfur'))
    .duration(40)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('uncatalyzed_sulfurous_gases') * 3000)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .outputs(metaitem('dustSulfur') * 2)
    .duration(40)
    .EUt(30)
    .buildAndRegister()