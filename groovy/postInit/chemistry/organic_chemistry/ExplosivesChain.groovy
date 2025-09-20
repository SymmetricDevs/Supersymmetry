import globals.Globals

WEAPONS_FACTORY = recipemap('weapons_factory');
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
LCR = recipemap('large_chemical_reactor')
CRYSTALLIZER = recipemap('crystallizer')
DT = recipemap('distillation_tower')

// Nitroglycerin

BR.recipeBuilder()
    .fluidInputs(fluid('glycerol') * 1000)
    .fluidInputs(fluid('nitration_mixture') * 6000)
    .fluidOutputs(fluid('glyceryl_trinitrate') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 6000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

WEAPONS_FACTORY.recipeBuilder()
	.inputs(item('minecraft:paper'))
	.inputs(item('minecraft:string'))
	.inputs(ore('dustDiatomite') * 4)
	.fluidInputs(fluid('glyceryl_trinitrate') * 100)
	.outputs(metaitem('dynamite') * 4)
	.EUt(30)
	.duration(60)
	.buildAndRegister()

// TNT

BR.recipeBuilder()
    .fluidInputs(fluid('toluene') * 1000)
    .fluidInputs(fluid('nitration_mixture') * 6000)
    .fluidOutputs(fluid('tnt_slurry') * 3000)
    .duration(200)
    .EUt(24)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('tnt_slurry') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
    .outputs(metaitem('dustTnt') * 7)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

// Picric acid (TNP)

BR.recipeBuilder()
    .fluidInputs(fluid('phenol') * 1000)
    .fluidInputs(fluid('nitration_mixture') * 6000)
    .fluidOutputs(fluid('tnp_slurry') * 3000)
    .duration(200)
    .EUt(24)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('tnp_slurry') * 1000)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
    .outputs(metaitem('dustPicricAcid') * 7)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

// PETN

CSTR.recipeBuilder()
	.fluidInputs(fluid('sodium_hydroxide_solution') * 50)
	.fluidInputs(fluid('gtfo_acetaldehyde') * 50)
	.fluidInputs(fluid('formaldehyde') * 200)
	.fluidOutputs(fluid('pentaerythritol_solution') * 50)
	.duration(10)
	.EUt(30)
	.buildAndRegister()

CRYSTALLIZER.recipeBuilder()
	.fluidInputs(fluid('pentaerythritol_solution') * 1000)
	.outputs(metaitem('dustPentaerythritol') * 21)
	.fluidOutputs(fluid('wastewater') * 1000)
	.duration(200)
	.EUt(30)
	.buildAndRegister()

BR.recipeBuilder()
	.inputs(ore('dustPentaerythritol') * 21)
	.fluidInputs(fluid('nitric_acid') * 3000)
	.outputs(metaitem('dustCrudePentaerythritolTetranitrate') * 29)
	.fluidOutputs(fluid('wastewater') * 3000)
	.duration(200)
	.EUt(30)
	.buildAndRegister()

CRYSTALLIZER.recipeBuilder()
	.inputs(metaitem('dustCrudePentaerythritolTetranitrate') * 29)
	.fluidInputs(fluid('acetone') * 1000)
	.fluidInputs(fluid('distilled_water') * 1000)
	.outputs(metaitem('dustPentaerythritolTetranitrate') * 29)
	.fluidOutputs(fluid('diluted_acetone') * 2000)
	.duration(200)
	.EUt(30)
	.buildAndRegister()

DT.recipeBuilder()
	.fluidInputs(fluid('diluted_acetone') * 2000)
	.fluidOutputs(fluid('water') * 1000)
	.fluidOutputs(fluid('acetone') * 1000)
	.duration(100)
	.EUt(30)
	.buildAndRegister()

// RDX & HMX

DT.recipeBuilder()
    .fluidInputs(fluid('hexamethylenetetramine_solution') * 4000)
	.outputs(metaitem('dustHexamethylenetetramine') * 22)
	.fluidOutputs(fluid('water') * 4000)
	.duration(200)
	.EUt(30)
	.buildAndRegister()

LCR.recipeBuilder()
	.inputs(ore('dustHexamethylenetetramine') * 22)
	.fluidInputs(fluid('acetic_acid') * 1650)
	.fluidInputs(fluid('ammonium_nitrate_solution') * 1500)
	.fluidInputs(fluid('nitric_acid') * 2000)
	.fluidInputs(fluid('gtfo_acetic_anhydride') * 5200)
	.fluidInputs(fluid('distilled_water') * 2650)
	.outputs(metaitem('dustRdx') * 17)
	.fluidOutputs(fluid('acidic_wastewater') * 10000)
	.duration(1000)
	.EUt(1920)
	.buildAndRegister()

// Composition B

BLENDER.recipeBuilder()
	.inputs(ore('dustRdx') * 50)
	.inputs(ore('dustTnt') * 11)
	.inputs(metaitem('paraffin_wax') * 3)
	.outputs(metaitem('dustCompositionB') * 64)
	.duration(100)
	.EUt(30)
	.buildAndRegister()

// Baratol

BLENDER.recipeBuilder()
	.inputs(ore('dustTnt') * 7)
	.inputs(ore('dustBariumNitrate') * 27)
	.inputs(metaitem('paraffin_wax') * 2)
	.outputs(metaitem('dustBaratol') * 32)
	.duration(100)
	.EUt(30)
	.buildAndRegister()

// Detonator

// Slapper detonator
/*WEAPONS_FACTORY.recipeBuilder()
	.inputs(metaitem('metallized_plastic_film'))
	.inputs(ore('wireFineAluminium'))
	.inputs(ore('componentCapacitor'))
	.inputs(ore('dustPentaerythritolTetranitrate') * 4)
	.inputs(ore('pipeSmallFluidStainlessSteel'))
	.outputs(metaitem('slapper_detonator'))
	.duration(200)
	.EUt(1920)
	.buildAndRegister()*/
