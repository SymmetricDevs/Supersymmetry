import globals.RecyclingHelper
import gregtechfoodoption.utils.GTFOUtils

import static gregtechfoodoption.utils.GTFOUtils.*

// MACHINE RECIPES

RecyclingHelper.replaceShaped("gregtechfoodoption:gregtechfoodoption.machine.slicer.lv", metaitem('gregtechfoodoption:slicer.lv'), [
		[metaitem('electric.piston.lv'), ore('circuitLv'), ore('cableGtSingleTin')],
		[ore('toolHeadBuzzSawSteel'), metaitem('gregtech:hull.lv'), ore('circuitLv')],
		[ore('plateSteel'), metaitem('conveyor.module.lv'), ore('cableGtSingleTin')]
])

RecyclingHelper.replaceShaped("gregtechfoodoption:gregtechfoodoption.machine.slicer.mv", metaitem('gregtechfoodoption:slicer.mv'), [
		[metaitem('electric.piston.mv'), ore('circuitMv'), ore('cableGtSingleCopper')],
		[ore('toolHeadBuzzSawAluminium'), metaitem('gregtech:hull.mv'), ore('circuitMv')],
		[ore('plateAluminium'), metaitem('conveyor.module.mv'), ore('cableGtSingleCopper')]
])

RecyclingHelper.replaceShaped("gregtechfoodoption:gregtechfoodoption.machine.slicer.hv", metaitem('gregtechfoodoption:slicer.hv'), [
		[metaitem('electric.piston.hv'), ore('circuitHv'), ore('cableGtSingleGold')],
		[ore('toolHeadBuzzSawVanadiumSteel'), metaitem('gregtech:hull.hv'), ore('circuitHv')],
		[ore('plateVanadiumSteel'), metaitem('conveyor.module.hv'), ore('cableGtSingleGold')]
])

// Greenhouse * 1
mods.gregtech.assembler.removeByInput(120, [metaitem('hull.mv'), metaitem('electric.pump.mv') * 2, metaitem('circuit.advanced_integrated') * 4, metaitem('frameSteel'), metaitem('plateSterlingSilver') * 6, metaitem('circuit.integrated').withNbt(["Configuration": 3])], null)

mods.gregtech.assembler.recipeBuilder()
        .inputs(metaitem('hull.mv'))
        .inputs(metaitem('electric.pump.mv') * 2)
        .inputs(ore('circuitMv'))
        .inputs(metaitem('frameSteel'))
        .inputs(ore('plateSterlingSilver') * 6)
        .outputs(metaitem('gregtechfoodoption:greenhouse'))
        .duration(400)
        .EUt(120)
        .buildAndRegister()

// FOOD RECIPES

def DISTILLERY = recipemap('distillery');
def MIXER = recipemap('mixer');
def LCR = recipemap('large_chemical_reactor')
def BR = recipemap('batch_reactor')
def CSTR = recipemap('continuous_stirred_tank_reactor');
def FERMENTER = recipemap('vat_fermentation');
def ELECTROLYZER = recipemap('electrolyzer');
def CENTRIFUGE = recipemap('centrifuge');
def ROASTER = recipemap('roaster')
def CHEMICAL_BATH = recipemap('chemical_bath')
def BCR = recipemap('bubble_column_reactor')
def FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
def FBR = recipemap('fixed_bed_reactor')
def PYROLYSE_OVEN = recipemap('pyrolyse_oven');

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('gtfo_red_grapes_must') * 8000)
        .fluidOutputs(fluid('gtfo_fermented_red_grapes_must') * 8000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('gtfo_alcoholic_red_grape_juice') * 8000)
        .fluidOutputs(fluid('gtfo_red_wine') * 8000)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(item('minecraft:potato'))
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('gtfo_potato_juice') * 1000)
        .duration(1000)
        .EUt(7)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('gtfo_potato_juice') * 2000)
        .fluidOutputs(fluid('gtfo_vodka') * 2000)
        .duration(3000)
        .EUt(7)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .inputs(item('minecraft:sugar') * 24)
        .fluidInputs(fluid('water') * 16000)
        .fluidInputs(fluid('grain_solution') * 1000)
        .fluidOutputs(fluid('gtfo_poor_quality_beer') * 16000)
        .circuitMeta(4)
        .duration(2400)
        .EUt(16)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:food.white_grapes'))
        .fluidInputs(fluid('water') * 4000)
        .fluidOutputs(fluid('gtfo_macerated_white_grapes') * 4000)
        .duration(500)
        .EUt(4)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('gtfo_clarified_white_wort') * 8000)
        .fluidOutputs(fluid('gtfo_white_wine') * 8000)
        .circuitMeta(4)
        .duration(8000)
        .EUt(2)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .notConsumable(metaitem('stickNickel'))
        .notConsumable(metaitem('graphite_electrode'))
        .fluidInputs(fluid('sodium_chlorate_solution') * 2000)
        .fluidOutputs(fluid('sodium_perchlorate_solution') * 1000)
        .fluidOutputs(fluid('hydrogen') * 2000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('sodium_perchlorate_solution') * 50)
        .fluidInputs(fluid('hydrogen_chloride') * 50)
        .fluidOutputs(fluid('salt_water') * 50)
        .fluidOutputs(fluid('gtfo_perchloric_acid') * 50)
        .duration(1)
        .EUt(7)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('gtfo_perchloric_acid') * 1000)
        .fluidInputs(fluid('ammonia') * 1000)
        .outputs(metaitem('gregtechfoodoption:ammonium_perchlorate_dust') * 10)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('gtfo_alkaline_extract') * 1000)
        .inputs(metaitem('gregtechfoodoption:ammonium_perchlorate_dust') * 10)
        .fluidOutputs(fluid('gtfo_sludge') * 1000)
        .outputs(metaitem('gregtechfoodoption:potassium_perchlorate_dust') * 6)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:potassium_perchlorate_dust') * 6)
        .fluidOutputs(fluid('oxygen') * 4000)
        .outputs(metaitem('dustRockSalt') * 2)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:seed.pea'))
        .fluidInputs(fluid('gtfo_baking_soda_solution') * 500)
        .outputs(metaitem('gregtechfoodoption:food.mushy_peas'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

for (ItemStack fish : GTFOUtils.getFish()) {
    CHEMICAL_BATH.recipeBuilder()
            .fluidInputs(fluid('gtfo_beer_batter') * 40)
            .inputs(fish)
            .outputs(metaitem('gregtechfoodoption:food.fried_fish'))
            .EUt(16)
            .duration(400)
            .buildAndRegister();

    FERMENTER.recipeBuilder()
            .fluidInputs(fluid('water') * 100)
            .inputs(fish)
            .outputs(metaitem('gregtechfoodoption:food.fish_rotten'))
            .EUt(7)
            .duration(100)
            .buildAndRegister();
}

MIXER.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:component.beef_slice') * 4)
        .fluidInputs(fluid('salt_water') * 1000)
        .fluidInputs(fluid('acetic_acid') * 100)
        .fluidOutputs(fluid('gtfo_crude_rennet_solution') * 500)
        .duration(300)
        .EUt(7)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('gtfo_crude_rennet_solution') * 1)
        .fluidInputs(fluid('milk') * 3000)
        .outputs(metaitem('gregtechfoodoption:coagulated_milk_curd_nugget'))
        .fluidOutputs(fluid('gtfo_whey') * 600)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:component.brined_parmigiano_roll') * 64)
        .fluidInputs(fluid('air') * 10000)
        .outputs(metaitem('gregtechfoodoption:component.aged_parmigiano_roll') * 64)
        .duration(36000)
        .EUt(2)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(item('minecraft:sugar'))
        .fluidInputs(fluid('gtfo_coffee') * 10)
        .fluidOutputs(fluid('gtfo_energized_coffee') * 10)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

BCR.recipeBuilder()
        .fluidInputs(fluid('propene') * 50)
        .fluidInputs(fluid('hydrogen_chloride') * 50)
        .fluidOutputs(fluid('gtfo_isopropyl_chloride') * 50)
        .duration(1)
        .EUt(7)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:coffee_grounds_dust'))
        .inputs(metaitem('gregtechfoodoption:component.paper_cone'))
        .fluidInputs(fluid('steam') * 1000)
        .outputs(metaitem('dustPaper'))
        .fluidOutputs(fluid('gtfo_coffee') * 15)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('gtfo_apple_extract') * 100)
        .fluidOutputs(fluid('gtfo_apple_cider') * 100)
        .duration(150)
        .EUt(2)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .notConsumable(metaitem('stickNickel'))
        .notConsumable(metaitem('graphite_electrode'))
        .inputs(ore('dustGold') * 2)
        .fluidInputs(fluid('hydrochloric_acid') * 8000)
        .fluidOutputs(fluid('gtfo_chloroauric_acid') * 6000)
        .fluidOutputs(fluid('hydrogen') * 6000)
        .duration(200)
        .EUt(30)
        .buildAndRegister()

for (ItemStack meat : GTFOUtils.getMeat()) {
    FERMENTER.recipeBuilder()
            .fluidInputs(fluid('water') * 100)
            .inputs(meat)
            .outputs(metaitem('gregtechfoodoption:food.meat_rotten'))
            .EUt(7)
            .duration(100)
            .buildAndRegister();

    LCR.recipeBuilder()
            .fluidInputs(fluid('methanol') * 4000)
            .fluidInputs(fluid('chloroform') * 4000)
            .inputs(meat * 32)
            .outputs(metaitem('dustMeat') * 40)
            .outputs(item('minecraft:dye', 15) * 16)
            .fluidOutputs(fluid('gtfo_stearin') * 3200)
            .fluidOutputs(fluid('gtfo_sludge') * 12000)
            .EUt(256)
            .duration(1000)
            .buildAndRegister();
}

LCR.recipeBuilder()
        .fluidInputs(fluid('methanol') * 4000)
        .fluidInputs(fluid('chloroform') * 4000)
        .inputs(metaitem('gregtechfoodoption:component.scrap_meat') * 32)
        .outputs(metaitem('dustMeat') * 32)
        .outputs(item('minecraft:dye', 15) * 20)
        .fluidOutputs(fluid('gtfo_stearin') * 3500)
        .fluidOutputs(fluid('gtfo_sludge') * 16000)
        .EUt(256)
        .duration(1000)
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:component.scrap_meat'))
        .fluidInputs(fluid('chloroform') * 100)
        .outputs(metaitem('dustMeat'))
        .fluidOutputs(fluid('gtfo_sludge') * 40)
        .duration(600)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustSodaAsh'))
        .fluidInputs(fluid('fish_oil') * 8000)
        .fluidOutputs(fluid('gtfo_stearin') * 4000)
        .duration(1200)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustSodaAsh'))
        .fluidInputs(fluid('seed_oil') * 8000)
        .fluidOutputs(fluid('gtfo_stearin') * 4000)
        .duration(1200)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustSodaAsh'))
        .fluidInputs(fluid('gtfo_olive_oil') * 8000)
        .fluidOutputs(fluid('gtfo_stearin') * 4000)
        .duration(1200)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('gtfo_stearin') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .fluidOutputs(fluid('gtfo_sodium_stearate') * 3000)
        .duration(60)
        .EUt(120)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('gtfo_sludge') * 500)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('biomass') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

FERMENTER.recipeBuilder()
        .fluidInputs(fluid('milk') * 10000)
        .fluidOutputs(fluid('gtfo_butter') * 9000)
        .duration(1200)
        .EUt(15)
        .buildAndRegister()

FLUIDIZEDBR.recipeBuilder()
        .fluidInputs(fluid('dimethylamine') * 1000)
        .fluidInputs(fluid('gtfo_x_phenothiazine_ii_propyl_chloride') * 1000)
        .notConsumable(metaitem('dustCopper'))
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .outputs(metaitem('gregtechfoodoption:promethazine_dust'))
        .duration(120)
        .EUt(2000)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('gtfo_isopropyl_chloride') * 1000)
        .inputs(metaitem('gregtechfoodoption:phenothiazine_dust') * 23)
        .fluidOutputs(fluid('gtfo_x_phenothiazine_ii_propyl_chloride') * 1000)
        .duration(120)
        .EUt(240)
        .buildAndRegister()

BR.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('gtfo_aniline') * 2000)
        .fluidInputs(fluid('hydrogen_chloride') * 1000)
        .outputs(metaitem('gregtechfoodoption:diphenylamine_dust') * 24)
        .outputs(metaitem('dustAmmoniumChloride') * 6)
        .duration(120)
        .EUt(480)
        .buildAndRegister()

BCR.recipeBuilder()
        .fluidInputs(fluid('hydrogen') * 300)
        .fluidInputs(fluid('nitrobenzene') * 50)
        .notConsumable(metaitem('dustActivatedRaneyNickel'))
        .fluidOutputs(fluid('diluted_aniline') * 150)
        .duration(1)
        .EUt(120)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('diluted_aniline') * 600)
        .fluidOutputs(fluid('gtfo_aniline') * 200)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('gtfo_acetaldehyde') * 2000)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('gtfo_glyoxal') * 2000)
        .fluidOutputs(fluid('nitrogen_dioxide') * 1000)
        .fluidOutputs(fluid('water') * 3000)
        .duration(120)
        .EUt(60)
        .buildAndRegister()

FBR.recipeBuilder()
        .notConsumable(ore('catalystBedSilver'))
        .fluidInputs(fluid('ethylene_glycol') * 50)
        .fluidInputs(fluid('oxygen') * 100)
        .fluidOutputs(fluid('gtfo_glyoxal') * 50)
        .fluidOutputs(fluid('water') * 100)
        .duration(6)
        .EUt(60)
        .buildAndRegister()

LCR.recipeBuilder()
        .fluidInputs(fluid('gtfo_glyoxal') * 2000)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('gtfo_glyoxylic_acid') * 2000)
        .fluidOutputs(fluid('nitrogen_dioxide') * 1000)
        .fluidOutputs(fluid('nitrous_oxide') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(30)
        .EUt(240)
        .buildAndRegister()

BR.recipeBuilder()
        .notConsumable(metaitem('dustSodiumHydroxide'))
        .fluidInputs(fluid('gtfo_guaiacol') * 1000)
        .fluidInputs(fluid('gtfo_glyoxylic_acid') * 1000)
        .outputs(metaitem('gregtechfoodoption:vanillylmandelic_acid_dust') * 24)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .notConsumable(metaitem('dustSodiumHydroxide'))
        .fluidInputs(fluid('oxygen') * 1000)
        .inputs(metaitem('gregtechfoodoption:vanillylmandelic_acid_dust') * 24)
        .fluidOutputs(fluid('water') * 1000)
        .outputs(metaitem('gregtechfoodoption:vanilglycolic_acid_dust') * 22)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

LCR.recipeBuilder()
        .fluidInputs(fluid('hydrochloric_acid') * 1000)
        .inputs(metaitem('gregtechfoodoption:vanilglycolic_acid_dust') * 22)
        .fluidOutputs(fluid('diluted_hydrochloric_acid') * 1000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .outputs(metaitem('gregtechfoodoption:vanillin_dust') * 19)
        .duration(240)
        .EUt(120)
        .buildAndRegister()

// Replace mozzarella recipes to make it obtainable
ROASTER.recipeBuilder()
        .inputs(metaitem('gregtechfoodoption:dried_mozzarella_curd_nugget'))
        .outputs(metaitem('gregtechfoodoption:solidified_mozzarella_curd_nugget'))
        .fluidOutputs(fluid('gtfo_whey') * 50)
        .duration(200)
        .EUt(16)
        .buildAndRegister()
		
MIXER.recipeBuilder()
        .fluidInputs(fluid('milk') * 6000)
        .fluidInputs(fluid('gtfo_crude_rennet_solution'))
        .fluidInputs(fluid('gtfo_whey') * 400)
        .outputs(metaitem('gregtechfoodoption:large_mozzarella_curd_nugget'))
        .duration(160)
        .EUt(7)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .circuitMeta(1)
        .inputs(item('minecraft:dye', 3) * 8)
        .outputs(metaitem('gregtechfoodoption:component.roasted_beans') * 8)
        .fluidOutputs(fluid('steam') * 1000)
        .EUt(120)
        .duration(30)
        .buildAndRegister()
		
// Gelatin
CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('dustBone') * 1)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .outputs(metaitem('dustCollagen') * 1)
        .fluidOutputs(fluid('wastewater') * 2000)
        .duration(160)
        .EUt(7)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(item('minecraft:leather'))
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .outputs(metaitem('dustCollagen') * 1)
        .fluidOutputs(fluid('wastewater') * 2000)
        .duration(160)
        .EUt(7)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('dustCollagen'))
        .fluidInputs(fluid('sodium_hydroxide_solution') * 250)
        .outputs(metaitem('dustTreatedCollagen'))
        .fluidOutputs(fluid('wastewater') * 250)
        .duration(160)
        .EUt(7)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustTreatedCollagen'))
        .fluidInputs(fluid('gtfo_heated_water') * 1000)
        .fluidOutputs(fluid('gelatin_solution') * 1000)
        .duration(160)
        .EUt(7)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('gelatin_solution') * 1000)
        .outputs(metaitem('dustGelatin'))
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(160)
        .EUt(7)
        .buildAndRegister()

//Re-added the roasted coffee bean recipes
PYROLYSE_OVEN.recipeBuilder()
	.inputs(ore('gemChippedGradedCoffeeSmall'))
	.outputs(item('gregtechfoodoption:gtfo_oredict_item:1018'))
	.fluidOutputs(fluid('water') * 100)
	.duration(40)
	.EUt(120)
	.buildAndRegister()
	
PYROLYSE_OVEN.recipeBuilder()
	.inputs(ore('gemChippedGradedCoffeeLarge'))
	.outputs(item('gregtechfoodoption:gtfo_oredict_item:1019'))
	.fluidOutputs(fluid('water') * 200)
	.duration(80)
	.EUt(120)
	.buildAndRegister()
	
// Force GTFO skewers to be made with only long rods
// Skewer * 16
mods.gregtech.lathe.removeByInput(200, [metaitem('stickTitanium')], null)

// Skewer * 4
mods.gregtech.lathe.removeByInput(30, [metaitem('stickSteel')], null)

// Skewer * 8
mods.gregtech.lathe.removeByInput(40, [metaitem('stickStainlessSteel')], null)

// Baking Soda Solution * 1000
mods.gregtech.blender.removeByInput(8, [metaitem('dustSodiumBicarbonate')], [fluid('water') * 1000])
