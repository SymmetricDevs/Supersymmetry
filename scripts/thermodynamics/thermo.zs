#norun
#priority 497


import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemStack;
import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.liquid.ILiquidStack;
import crafttweaker.liquid.ILiquidDefinition;

import scripts.thermodynamics.ICryoGas.ICryoGas;
import scripts.thermodynamics.ICoolant.ICoolant;
import scripts.thermodynamics.IRefrigerant.IRefrigerant;

import scripts.thermodynamics.IFluidFuel.IFluidFuel;
import scripts.thermodynamics.IWorkingFluid.IWorkingFluid;

//REMOVALS

<recipemap:steam_turbine>.findRecipe(-32, null, [<liquid:steam> * 640]).remove();
<recipemap:vacuum_freezer>.findRecipe(1920, null, [<liquid:nether_air> * 4000]).remove();
<recipemap:vacuum_freezer>.findRecipe(480, null, [<liquid:air> * 4000]).remove();
<recipemap:vacuum_freezer>.findRecipe(7680, null, [<liquid:ender_air> * 4000]).remove();
<recipemap:vacuum_freezer>.findRecipe(1920, null, [<liquid:oxygen> * 1000]).remove();
<recipemap:vacuum_freezer>.findRecipe(30, null, [<liquid:water> * 1000]).remove();

//ADDITIONS (AKA EVERYTHING ELSE)

static CryoHydrogen as ICryoGas = ICryoGas(<liquid:hydrogen>, <liquid:hot_hp_hydrogen>, <liquid:hp_hydrogen>, <liquid:cold_hp_hydrogen>, <liquid:liquid_gt_hydrogen>);
CryoHydrogen.setEUt(200);
CryoHydrogen.setDuration(100);
CryoHydrogen.setPowerHX(100);
CryoHydrogen.setDurationHX(5);
CryoHydrogen.setDurationRadiator(400);
CryoHydrogen.setTemperature(20);

static CryoOxygen as ICryoGas = ICryoGas(<liquid:oxygen>, <liquid:hot_hp_oxygen>, <liquid:hp_oxygen>, <liquid:cold_hp_oxygen>, <liquid:liquid_oxygen>);
CryoOxygen.setEUt(200);
CryoOxygen.setDuration(100);
CryoOxygen.setPowerHX(100);
CryoOxygen.setDurationHX(5);
CryoOxygen.setDurationRadiator(400);
CryoOxygen.setTemperature(90);

static CryoHelium as ICryoGas = ICryoGas(<liquid:helium>, <liquid:hot_hp_helium>, <liquid:hp_helium>, <liquid:cold_hp_helium>, <liquid:liquid_gt_helium>);
CryoHelium.setEUt(200);
CryoHelium.setDuration(100);
CryoHelium.setPowerHX(100);
CryoHelium.setDurationHX(5);
CryoHelium.setDurationRadiator(400);
CryoHelium.setTemperature(4);

static CryoNeon as ICryoGas = ICryoGas(<liquid:neon>, <liquid:hot_hp_neon>, <liquid:hp_neon>, <liquid:cold_hp_neon>, <liquid:liquid_gt_neon>);
CryoNeon.setEUt(200);
CryoNeon.setDuration(100);
CryoNeon.setPowerHX(100);
CryoNeon.setDurationHX(5);
CryoNeon.setDurationRadiator(400);
CryoNeon.setTemperature(27);

static CryoArgon as ICryoGas = ICryoGas(<liquid:argon>, <liquid:hot_hp_argon>, <liquid:hp_argon>, <liquid:cold_hp_argon>, <liquid:liquid_gt_argon>);
CryoArgon.setEUt(200);
CryoArgon.setDuration(100);
CryoArgon.setPowerHX(100);
CryoArgon.setDurationHX(5);
CryoArgon.setDurationRadiator(400);
CryoArgon.setTemperature(87);

static CryoKrypton as ICryoGas = ICryoGas(<liquid:krypton>, <liquid:hot_hp_krypton>, <liquid:hp_krypton>, <liquid:cold_hp_krypton>, <liquid:liquid_krypton>);
CryoKrypton.setEUt(200);
CryoKrypton.setDuration(100);
CryoKrypton.setPowerHX(100);
CryoKrypton.setDurationHX(5);
CryoKrypton.setDurationRadiator(400);
CryoKrypton.setTemperature(120);

static CryoXenon as ICryoGas = ICryoGas(<liquid:xenon>, <liquid:hot_hp_xenon>, <liquid:hp_xenon>, <liquid:cold_hp_xenon>, <liquid:liquid_xenon>);
CryoXenon.setEUt(200);
CryoXenon.setDuration(100);
CryoXenon.setPowerHX(100);
CryoXenon.setDurationHX(5);
CryoXenon.setDurationRadiator(400);
CryoXenon.setTemperature(165);

static CryoAir as ICryoGas = ICryoGas(<liquid:air>, <liquid:hot_hp_air>, <liquid:hp_air>, <liquid:cold_hp_air>, <liquid:liquid_air>);
CryoAir.setEUt(60);
CryoAir.setDuration(100);
CryoAir.setPowerHX(100);
CryoAir.setDurationHX(5);
CryoAir.setDurationRadiator(400);
CryoAir.setTemperature(80);

static CryoFilteredAir as ICryoGas = ICryoGas(<liquid:filtered_air>, <liquid:hot_hp_filtered_air>, <liquid:hp_filtered_air>, <liquid:cold_hp_filtered_air>, <liquid:liquid_filtered_air>);
CryoFilteredAir.setEUt(60);
CryoFilteredAir.setDuration(100);
CryoFilteredAir.setPowerHX(100);
CryoFilteredAir.setDurationHX(5);
CryoFilteredAir.setDurationRadiator(400);
CryoFilteredAir.setTemperature(80);

static CryoNitrogen as ICryoGas = ICryoGas(<liquid:nitrogen>, <liquid:hot_hp_nitrogen>, <liquid:hp_nitrogen>, <liquid:cold_hp_nitrogen>, <liquid:liquid_gt_nitrogen>);
CryoNitrogen.setEUt(200);
CryoNitrogen.setDuration(100);
CryoNitrogen.setPowerHX(100);
CryoNitrogen.setDurationHX(5);
CryoNitrogen.setDurationRadiator(400);
CryoNitrogen.setTemperature(77);

static CryoNetherAir as ICryoGas = ICryoGas(<liquid:nether_air>, <liquid:hot_hp_nether_air>, <liquid:hp_nether_air>, <liquid:cold_hp_nether_air>, <liquid:liquid_nether_air>);
CryoNetherAir.setEUt(60);
CryoNetherAir.setDuration(100);
CryoNetherAir.setPowerHX(100);
CryoNetherAir.setDurationHX(5);
CryoNetherAir.setDurationRadiator(400);
CryoNetherAir.setTemperature(80);

static CryoEnderAir as ICryoGas = ICryoGas(<liquid:ender_air>, <liquid:hot_hp_ender_air>, <liquid:hp_ender_air>, <liquid:cold_hp_ender_air>, <liquid:liquid_ender_air>);
CryoEnderAir.setEUt(60);
CryoEnderAir.setDuration(100);
CryoEnderAir.setPowerHX(100);
CryoEnderAir.setDurationHX(5);
CryoEnderAir.setDurationRadiator(400);
CryoEnderAir.setTemperature(80);

static CryoGases as ICryoGas[] = [
	CryoHydrogen,
	CryoOxygen,
	CryoHelium,
	CryoNeon,
	CryoArgon,
	CryoKrypton,
	CryoXenon,
	CryoAir,
	CryoNitrogen,
	CryoFilteredAir,
	CryoNetherAir,
	CryoEnderAir
];

val WaterCoolant = ICoolant(<liquid:water>, <liquid:warm_water>);
WaterCoolant.setDurationRadiator(100);
WaterCoolant.setAmountToUse(1000);
WaterCoolant.setTimeFactor(10);

val EthyleneGlycolCoolant = ICoolant(<liquid:ethylene_glycol>, <liquid:warm_ethylene_glycol>);
EthyleneGlycolCoolant.setDurationRadiator(50);
EthyleneGlycolCoolant.setAmountToUse(2000);
EthyleneGlycolCoolant.setTimeFactor(5);

val Coolants as ICoolant[] = [
	WaterCoolant, 
	EthyleneGlycolCoolant
];

var AmmoniaRefrigerant = IRefrigerant(<liquid:ammonia>, <liquid:hot_compressed_ammonia>, <liquid:compressed_ammonia>, <liquid:cold_ammonia>);
AmmoniaRefrigerant.setPowerToCompress(500);
AmmoniaRefrigerant.setDurationToCompress(20);
AmmoniaRefrigerant.setDurationRadiator(20);
AmmoniaRefrigerant.setAmountToUse(1000);
AmmoniaRefrigerant.setTimeFactor(5);

var PropaneRefrigerant = IRefrigerant(<liquid:propane>, <liquid:hot_compressed_propane>, <liquid:compressed_propane>, <liquid:cold_propane>);
PropaneRefrigerant.setPowerToCompress(200);
PropaneRefrigerant.setDurationToCompress(30);
PropaneRefrigerant.setDurationRadiator(10);
PropaneRefrigerant.setAmountToUse(2000);
PropaneRefrigerant.setTimeFactor(10);

var CarbonDioxideRefrigerant = IRefrigerant(<liquid:carbon_dioxide>, <liquid:hot_compressed_carbon_dioxide>, <liquid:compressed_carbon_dioxide>, <liquid:cold_carbon_dioxide>);
CarbonDioxideRefrigerant.setPowerToCompress(60);
CarbonDioxideRefrigerant.setDurationToCompress(60);
CarbonDioxideRefrigerant.setDurationRadiator(10);
CarbonDioxideRefrigerant.setAmountToUse(3000);
CarbonDioxideRefrigerant.setTimeFactor(10);

val Refrigerants as IRefrigerant[] = [
	AmmoniaRefrigerant, 
	PropaneRefrigerant,
	CarbonDioxideRefrigerant
];

//Refrigerant recipes generation
for refrigerant in Refrigerants {
	refrigerant.GenerateRecipes();
}

//Coolant recipes generation
for coolant in Coolants {
	coolant.GenerateRecipes();
}

//Heat exchanger recipes generation
for cryogas in CryoGases {
	for coolant in Coolants {
		cryogas.GenerateHXCooling(coolant);
	}
	for refrigerant in Refrigerants {
		cryogas.GenerateHXRefrigeration(refrigerant);
	}
	cryogas.GenerateRecipes();
}

//Water cooling
for refrigerant in Refrigerants {
    heat_exchanger_recipes.recipeBuilder()
    .fluidInputs([<liquid:water> * 1000, refrigerant.getColdRefrigerant()])
    .fluidOutputs([refrigerant.getRefrigerant(), <liquid:ice> * 1000])
    .duration(60)
    .EUt(8)
    .buildAndRegister();
}

var Gasoline = IFluidFuel(<liquid:gasoline>, <liquid:flue_gas>);
Gasoline.setDuration(136);
Gasoline.setAmountToBurn(8 * 40);
Gasoline.setByproductAmount(1000);

var SulfuricGas = IFluidFuel(<liquid:sulfuric_gas>, <liquid:flue_gas>);
SulfuricGas.setDuration(26);
SulfuricGas.setAmountToBurn(32 * 40);
SulfuricGas.setByproductAmount(1000);

var Methane = IFluidFuel(<liquid:methane>, <liquid:flue_gas>);
Methane.setDuration(14);
Methane.setAmountToBurn(4 * 40);
Methane.setByproductAmount(1000);

var Ethane = IFluidFuel(<liquid:ethane>, <liquid:flue_gas>);
Ethane.setDuration(22);
Ethane.setAmountToBurn(4 * 40);
Ethane.setByproductAmount(1000);

var Butadiene = IFluidFuel(<liquid:butadiene>, <liquid:flue_gas>);
Butadiene.setDuration(104);
Butadiene.setAmountToBurn(16 * 40);
Butadiene.setByproductAmount(1000);

var Propane = IFluidFuel(<liquid:propane>, <liquid:flue_gas>);
Propane.setDuration(30);
Propane.setAmountToBurn(4 * 40);
Propane.setByproductAmount(1000);

var Butane = IFluidFuel(<liquid:butane>, <liquid:flue_gas>);
Butane.setDuration(38);
Butane.setAmountToBurn(4 * 40);
Butane.setByproductAmount(1000);

var LPG = IFluidFuel(<liquid:lpg>, <liquid:flue_gas>);
LPG.setDuration(10);
LPG.setAmountToBurn(1 * 40);
LPG.setByproductAmount(1000);

var Naphtha = IFluidFuel(<liquid:naphtha>, <liquid:flue_gas>);
Naphtha.setDuration(10);
Naphtha.setAmountToBurn(1 * 40);
Naphtha.setByproductAmount(1000);

var Toluene = IFluidFuel(<liquid:toluene>, <liquid:flue_gas>);
Toluene.setDuration(42);
Toluene.setAmountToBurn(4 * 40);
Toluene.setByproductAmount(1000);

var NaturalGas = IFluidFuel(<liquid:natural_gas>, <liquid:flue_gas>);
NaturalGas.setDuration(14);
NaturalGas.setAmountToBurn(20 * 40);
NaturalGas.setByproductAmount(1000);

var Hydrogen = IFluidFuel(<liquid:hydrogen>, <liquid:exhaust_steam>);
Hydrogen.setDuration(2);
Hydrogen.setAmountToBurn(20 * 40);
Hydrogen.setByproductAmount(1600);

var CarbonMonoxide = IFluidFuel(<liquid:carbon_monoxide>, <liquid:flue_gas>);
CarbonMonoxide.setDuration(16);
CarbonMonoxide.setAmountToBurn(20 * 40);
CarbonMonoxide.setByproductAmount(1000);

var WoodGas = IFluidFuel(<liquid:wood_gas>, <liquid:flue_gas>);
WoodGas.setDuration(16);
WoodGas.setAmountToBurn(20 * 40);
WoodGas.setByproductAmount(1000);

var SulfuricNaphtha = IFluidFuel(<liquid:sulfuric_naphtha>, <liquid:flue_gas>);
SulfuricNaphtha.setDuration(10);
SulfuricNaphtha.setAmountToBurn(8 * 40);
SulfuricNaphtha.setByproductAmount(1000);

var Ethylene = IFluidFuel(<liquid:ethylene>, <liquid:flue_gas>);
Ethylene.setDuration(20);
Ethylene.setAmountToBurn(5 * 40);
Ethylene.setByproductAmount(1000);

var RefineryGas = IFluidFuel(<liquid:refinery_gas>, <liquid:flue_gas>);
RefineryGas.setDuration(10);
RefineryGas.setAmountToBurn(2 * 40);
RefineryGas.setByproductAmount(1000);

var Propene = IFluidFuel(<liquid:propene>, <liquid:flue_gas>);
Propene.setDuration(60);
Propene.setAmountToBurn(10 * 40);
Propene.setByproductAmount(1000);

var Butene = IFluidFuel(<liquid:butene>, <liquid:flue_gas>);
Butene.setDuration(80);
Butene.setAmountToBurn(10 * 40);
Butene.setByproductAmount(1000);

var Phenol = IFluidFuel(<liquid:phenol>, <liquid:flue_gas>);
Phenol.setDuration(90);
Phenol.setAmountToBurn(10 * 40);
Phenol.setByproductAmount(1000);

var Benzene = IFluidFuel(<liquid:benzene>, <liquid:flue_gas>);
Benzene.setDuration(90);
Benzene.setAmountToBurn(10 * 40);
Benzene.setByproductAmount(1000);

/*
var NaquadahGas = IFluidFuel(<liquid:naquadah_gas>, <liquid:flue_gas>);
NaquadahGas.setDuration(8000);
NaquadahGas.setAmountToBurn(1 * 40);
NaquadahGas.setByproductAmount(1000);

var LightNaquadahGas = IFluidFuel(<liquid:light_naquadah_fuel>, <liquid:flue_gas>);
LightNaquadahGas.setDuration(4000);
LightNaquadahGas.setAmountToBurn(1 * 40);
LightNaquadahGas.setByproductAmount(1000);

var LightEnrichedNaquadahGas = IFluidFuel(<liquid:light_e_naquadah_fuel>, <liquid:flue_gas>);
LightEnrichedNaquadahGas.setDuration(10000);
LightEnrichedNaquadahGas.setAmountToBurn(1 * 40);
LightEnrichedNaquadahGas.setByproductAmount(1000);
*/

var NitroDiesel = IFluidFuel(<liquid:nitro_fuel>, <liquid:flue_gas>);
NitroDiesel.setDuration(46);
NitroDiesel.setAmountToBurn(2 * 40);
NitroDiesel.setByproductAmount(1000);
NitroDiesel.setIsDiesel(true);

var BioDiesel = IFluidFuel(<liquid:bio_diesel>, <liquid:flue_gas>);
BioDiesel.setDuration(14);
BioDiesel.setAmountToBurn(2 * 40);
BioDiesel.setByproductAmount(1000);
BioDiesel.setIsDiesel(true);

var Diesel = IFluidFuel(<liquid:diesel>, <liquid:flue_gas>);
Diesel.setDuration(16);
Diesel.setAmountToBurn(1 * 40);
Diesel.setByproductAmount(1000);
Diesel.setIsDiesel(true);

val FluidFuels as IFluidFuel[] = [
	Gasoline,
	SulfuricGas,
	Methane,
	Ethane,
	Butadiene,
	Propane,
	Butane,
	LPG,
	Naphtha,
	Toluene,
	NaturalGas,
	Hydrogen,
	CarbonMonoxide,
	WoodGas,
	SulfuricNaphtha,
	Ethylene,
	RefineryGas,
	Propene,
	Butene,
	Phenol,
	Benzene,
	//NaquadahGas,
	//LightNaquadahGas,
	//LightEnrichedNaquadahGas,
	NitroDiesel,
	BioDiesel,
	Diesel
];

var WaterWF = IWorkingFluid(<liquid:water>, <liquid:steam>, <liquid:exhauststeam>);
WaterWF.setDuration(10);
WaterWF.setAmountToUse(6);
WaterWF.setEfficiency(1);
WaterWF.setConversionFactor(160);

val WorkingFluids as IWorkingFluid[] = [
	WaterWF
];

for FluidFuel in FluidFuels {
	FluidFuel.GenerateRecipes();
}

for WorkingFluid in WorkingFluids {
	WorkingFluid.GenerateRecipes();
}