import globals.Globals

CVD = recipemap('cvd')
CUTTER = recipemap('cutter')
CRYSTALLIZER = recipemap('crystallizer')
SOLIDIFIER = recipemap('fluid_solidifier')
CUTTER = recipemap('cutter')
FORGE_HAMMER = recipemap('forge_hammer')
AUTOCLAVE = recipemap('autoclave')
BR = recipemap('batch_reactor')
ROASTER = recipemap('roaster')
TUBE_FURNACE = recipemap('tube_furnace')
MACERATOR = recipemap('macerator')

// Lithium Niobate Dust * 4
mods.gregtech.macerator.removeByInput(2, [metaitem('gemExquisiteLithiumNiobate')], null)
// Flawless Lithium Niobate * 2
mods.gregtech.cutter.removeByInput(16, [metaitem('gemExquisiteLithiumNiobate')], [fluid('water') * 4])
// Flawless Lithium Niobate * 2
mods.gregtech.cutter.removeByInput(16, [metaitem('gemExquisiteLithiumNiobate')], [fluid('distilled_water') * 3])
// Flawless Lithium Niobate * 2
mods.gregtech.cutter.removeByInput(16, [metaitem('gemExquisiteLithiumNiobate')], [fluid('lubricant')])
// Lithium Niobate * 2
mods.gregtech.cutter.removeByInput(16, [metaitem('gemFlawlessLithiumNiobate')], [fluid('water') * 4])
// Lithium Niobate * 2
mods.gregtech.cutter.removeByInput(16, [metaitem('gemFlawlessLithiumNiobate')], [fluid('distilled_water') * 3])
// Lithium Niobate * 2
mods.gregtech.cutter.removeByInput(16, [metaitem('gemFlawlessLithiumNiobate')], [fluid('lubricant')])
// Lithium Niobate Dust * 2
mods.gregtech.macerator.removeByInput(2, [metaitem('gemFlawlessLithiumNiobate')], null)

CVD.recipeBuilder()
        .notConsumable(metaitem('wafer.silicon'))
        .fluidInputs(fluid('methane') * 100)
        .fluidInputs(fluid('hydrogen') * 9900)
        .chancedOutput(metaitem('raw_diamond'), 1000, 0)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('raw_diamond'))
        .chancedOutput(item('minecraft:diamond'), 8000, 0)
        .chancedOutput(metaitem('gemExquisiteDiamond'), 500, 0)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

SOLIDIFIER.recipeBuilder()
        .fluidInputs(fluid('alumina') * 36)
        .notConsumable(metaitem('shape.mold.ball'))
        .chancedOutput(metaitem('seed_crystal.alumina'), 1000, 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('seed_crystal.alumina'))
        .inputs(ore('dustChromiumIiiOxide'))
        .fluidInputs(fluid('alumina') * 4608)
        .outputs(metaitem('boule.ruby'))
        .duration(400)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('boule.ruby'))
        .outputs(metaitem('seed_crystal.alumina'))
        .outputs(metaitem('gemExquisiteRuby') * 4)
        .duration(400)
        .EUt(120)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('seed_crystal.alumina'))
        .inputs(ore('dustTinyIronIiOxide'))
        .inputs(ore('dustTinyRutile'))
        .fluidInputs(fluid('alumina') * 4608)
        .outputs(metaitem('boule.sapphire'))
        .duration(400)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('boule.sapphire'))
        .outputs(metaitem('seed_crystal.alumina'))
        .outputs(metaitem('gemExquisiteSapphire') * 4)
        .duration(400)
        .EUt(120)
        .buildAndRegister()

FORGE_HAMMER.recipeBuilder()
        .inputs(item('minecraft:emerald'))
        .outputs(metaitem('seed_crystal.emerald') * 9)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('seed_crystal.emerald'))
        .inputs(ore('dustSiliconDioxide') * 18)
        .fluidInputs(fluid('alumina') * 720)
        .fluidInputs(fluid('beryllium_oxide') * 432)
        .outputs(metaitem('boule.emerald'))
        .duration(400)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('boule.emerald'))
        .outputs(metaitem('seed_crystal.emerald'))
        .outputs(metaitem('gemExquisiteEmerald') * 6)
        .duration(400)
        .EUt(120)
        .buildAndRegister()

AUTOCLAVE.recipeBuilder()
        .inputs(ore('dustBariumCarbonate') * 5)
        .inputs(ore('dustRutile') * 3)
        .fluidInputs(fluid('water') * 1000)
        .outputs(metaitem('gemExquisiteBariumTitanate'))
        .duration(200)
        .EUt(120)
        .buildAndRegister()

// Gallium Phosphate

ROASTER.recipeBuilder()
        .inputs(ore('dustGallium') * 2)
        .fluidInputs(fluid('oxygen') * 3000)
        .outputs(metaitem('dustGalliumTrioxide') * 5)
        .duration(200)
        .EUt(30)
        .buildAndRegister();

BR.recipeBuilder()
        .fluidInputs(fluid('phosphoric_acid') * 1000)
        .fluidInputs(fluid('ammonia') * 1000)
        .outputs(metaitem('dustAmmoniumDihydrogenPhosphate') * 12)
        .duration(200)
        .EUt(30)
        .buildAndRegister();

BR.recipeBuilder()
        .inputs(ore('dustGalliumTrioxide') * 5)
        .inputs(ore('dustAmmoniumDihydrogenPhosphate') * 24)
        .fluidOutputs(fluid('water') * 3000)
        .fluidOutputs(fluid('ammonia') * 2000)
        .outputs(metaitem('dustGalliumPhosphate') * 12)
        .duration(200)
        .EUt(120)
        .buildAndRegister();

// Lithium Niobate

TUBE_FURNACE.recipeBuilder()
        .inputs(ore('dustNiobiumOxide') * 7)
        .inputs(ore('dustLithiumOxide') * 32)
        .chancedOutput(metaitem('seed_crystal.lithium_niobate'), 5000, 1000)
        .duration(200)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .inputs(metaitem('seed_crystal.lithium_niobate'))
        .inputs(ore('dustNiobiumOxide') * 14)
        .fluidInputs(fluid('lithium_oxide') * 864)
        .outputs(metaitem('boule.lithium_niobate'))
        .duration(400)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('boule.lithium_niobate'))
        .outputs(metaitem('seed_crystal.lithium_niobate'))
        .outputs(metaitem('gemExquisiteLithiumNiobate') * 5)
        .duration(400)
        .EUt(120)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(ore('gemExquisiteLithiumNiobate'))
        .fluidInputs(fluid('water') * 8)
        .outputs(metaitem('gemLithiumNiobate') * 4)
        .duration(80)
        .EUt(16)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(ore('gemExquisiteLithiumNiobate'))
        .fluidInputs(fluid('distilled_water') * 6)
        .outputs(metaitem('gemLithiumNiobate') * 4)
        .duration(60)
        .EUt(16)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(ore('gemExquisiteLithiumNiobate'))
        .fluidInputs(fluid('lubricant') * 2)
        .outputs(metaitem('gemLithiumNiobate') * 4)
        .duration(40)
        .EUt(16)
        .buildAndRegister()

// Lead Zirconate Titanate

