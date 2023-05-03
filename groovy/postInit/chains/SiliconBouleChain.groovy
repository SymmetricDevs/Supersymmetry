import static globals.Globals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def ROASTER = recipemap('roaster');
def DISTILLERY = recipemap('distillery');
def MIXER = recipemap('mixer');
def ELECTROLYZER = recipemap('electrolyzer');
def CRYSTALLIZER = recipemap('crystallizer');
def CUTTER = recipemap('cutter');
def AUTOCLAVE = recipemap('autoclave');

ROASTER.recipeBuilder()
.inputs(metaitem('dustSilicon'))
.fluidInputs(fluid('chlorine') * 4000)
.fluidOutputs(fluid('silicon_tetrachloride') * 1000)
.duration(80)
.EUt(30)
.buildAndRegister()

DISTILLERY.recipeBuilder()
.fluidInputs(fluid('silicon_tetrachloride') * 1000)
.fluidOutputs(fluid('purified_silicon_tetrachloride') * 1000)
.duration(100)
.EUt(30)
.buildAndRegister()

ROASTER.recipeBuilder()
.fluidInputs(fluid('purified_silicon_tetrachloride') * 1000)
.inputs(metaitem('dustZinc') * 2)
.outputs(metaitem('dustHighPuritySilicon'))
.fluidOutputs(fluid('zinc_chloride') * 864)
.duration(100)
.EUt(30)
.buildAndRegister()

ELECTROLYZER.recipeBuilder()
.fluidInputs(fluid('zinc_chloride') * 432)
.notConsumable(metaitem('stickIron'))
.notConsumable(metaitem('stickNickel'))
.outputs(metaitem('dustZinc'))
.fluidOutputs(fluid('chlorine') * 2000)
.duration(100)
.EUt(30)
.buildAndRegister()

CRYSTALLIZER.recipeBuilder()
.fluidInputs(fluid('high_purity_silicon') * 4608)
.inputs(metaitem('seed_crystal.silicon'))
.outputs(metaitem('boule.silicon'))
.duration(9000)
.EUt(120)
.buildAndRegister()

CUTTER.recipeBuilder()
.fluidInputs(fluid('high_purity_water') * 100)
.inputs(metaitem('boule.silicon'))
.outputs(metaitem('wafer.silicon') * 16)
.outputs(metaitem('seed_crystal.silicon'))
.duration(400)
.EUt(64)
.buildAndRegister()

AUTOCLAVE.recipeBuilder()
.fluidInputs(fluid('distilled_water') * 1000)
.inputs(metaitem('dustHighPuritySilicon'))
.chancedOutput(metaitem('seed_crystal.silicon'), 1000, 500)
.duration(1200)
.EUt(30)
.buildAndRegister()