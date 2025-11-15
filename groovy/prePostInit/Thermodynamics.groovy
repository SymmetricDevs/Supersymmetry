package prePostInit

import static prePostInit.Recipemaps.*
import classes.*
import globals.Globals
import static gregtech.api.GTValues.*

import java.lang.Math

//REMOVALS

mods.gregtech.steam_turbine.removeByInput(32, null, [fluid('steam') * 640])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('refinery_gas')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('coal_gas')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('ethylene')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('natural_gas') * 8])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('sulfuric_naphtha') * 4])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('propene')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('wood_gas') * 8])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('methane') * 2])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('butene')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('phenol')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('lpg')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('benzene')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('ethane') * 4])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('sulfuric_gas') * 32])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('propane') * 4])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('butane') * 4])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('nitrobenzene')])
mods.gregtech.gas_turbine.removeByInput(32, null, [fluid('butadiene') * 16])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('octane') * 2])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('oil_light') * 32])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('sulfuric_light_fuel') * 4])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('ethanol')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('bio_diesel')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('methanol') * 4])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('light_fuel')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('toluene')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('naphtha')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('diesel')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('oil_medium') * 64])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('nitro_fuel') * 2])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('gasoline')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('gasoline_premium')])
mods.gregtech.combustion_generator.removeByInput(32, null, [fluid('rocket_fuel') * 16])

def WaterCoolant = new Coolant("water", "warm_water");
WaterCoolant.setDurationRadiator(100);
WaterCoolant.setAmountToUse(1000);
WaterCoolant.setTimeFactor(10);
WaterCoolant.setCircuit(1);

def ChilledWaterCoolant = new Coolant("chilled_water", "warm_water");
ChilledWaterCoolant.setDurationRadiator(50);
ChilledWaterCoolant.setAmountToUse(384);
ChilledWaterCoolant.setTimeFactor(5);
ChilledWaterCoolant.setCircuit(2);

def SaltWaterCoolant = new Coolant("salt_water", "warm_salt_water");
SaltWaterCoolant.setDurationRadiator(100);
SaltWaterCoolant.setAmountToUse(1000);
SaltWaterCoolant.setTimeFactor(15);

def BrineCoolant = new Coolant("brine", "warm_brine");
BrineCoolant.setDurationRadiator(100);
BrineCoolant.setAmountToUse(1000);
BrineCoolant.setTimeFactor(15);

def LubricantCoolant = new Coolant("lubricant", "warm_lubricant");
LubricantCoolant.setDurationRadiator(75);
LubricantCoolant.setAmountToUse(1000);
LubricantCoolant.setTimeFactor(6);

def SodiumPotassiumCoolant = new Coolant("sodium_potassium", "warm_sodium_potassium");
SodiumPotassiumCoolant.setDurationRadiator(60);
SodiumPotassiumCoolant.setAmountToUse(2000);
SodiumPotassiumCoolant.setTimeFactor(5);

def EthyleneGlycolCoolant = new Coolant("ethylene_glycol", "warm_ethylene_glycol");
EthyleneGlycolCoolant.setDurationRadiator(50);
EthyleneGlycolCoolant.setAmountToUse(2000);
EthyleneGlycolCoolant.setTimeFactor(4);

def PolychlorinatedBiphenylCoolant = new Coolant("polychlorinated_biphenyl", "warm_polychlorinated_biphenyl");
PolychlorinatedBiphenylCoolant.setDurationRadiator(40);
PolychlorinatedBiphenylCoolant.setAmountToUse(1000);
PolychlorinatedBiphenylCoolant.setTimeFactor(2);

def Coolants = [
        WaterCoolant,
        ChilledWaterCoolant,
        SaltWaterCoolant,
        BrineCoolant,
        LubricantCoolant,
        SodiumPotassiumCoolant,
        EthyleneGlycolCoolant,
        PolychlorinatedBiphenylCoolant
];

def CryoHydrogen = new CryoGas('hydrogen', 'hot_hp_hydrogen', 'hp_hydrogen', 'cold_hp_hydrogen', 'liquid_hydrogen');
CryoHydrogen.setEUt(240);
CryoHydrogen.setDuration(100);
CryoHydrogen.setPowerHX(100);
CryoHydrogen.setDurationHX(5);
CryoHydrogen.setDurationRadiator(200);
CryoHydrogen.setTemperature(14);

def CryoOxygen = new CryoGas('oxygen', 'hot_hp_oxygen', 'hp_oxygen', 'cold_hp_oxygen', 'liquid_oxygen');
CryoOxygen.setEUt(30);
CryoOxygen.setDuration(100);
CryoOxygen.setPowerHX(100);
CryoOxygen.setDurationHX(5);
CryoOxygen.setDurationRadiator(200);
CryoOxygen.setTemperature(90);

def CryoHelium = new CryoGas('helium', 'hot_hp_helium', 'hp_helium', 'cold_hp_helium', 'liquid_helium');
CryoHelium.setEUt(720);
CryoHelium.setDuration(100);
CryoHelium.setPowerHX(100);
CryoHelium.setDurationHX(5);
CryoHelium.setDurationRadiator(200);
CryoHelium.setTemperature(4);

def CryoNeon = new CryoGas('neon', 'hot_hp_neon', 'hp_neon', 'cold_hp_neon', 'liquid_neon');
CryoNeon.setEUt(240);
CryoNeon.setDuration(100);
CryoNeon.setPowerHX(100);
CryoNeon.setDurationHX(5);
CryoNeon.setDurationRadiator(200);
CryoNeon.setTemperature(27);

def CryoArgon = new CryoGas('argon', 'hot_hp_argon', 'hp_argon', 'cold_hp_argon', 'liquid_argon');
CryoArgon.setEUt(120);
CryoArgon.setDuration(100);
CryoArgon.setPowerHX(100);
CryoArgon.setDurationHX(5);
CryoArgon.setDurationRadiator(200);
CryoArgon.setTemperature(87);

def CryoKrypton = new CryoGas('krypton', 'hot_hp_krypton', 'hp_krypton', 'cold_hp_krypton', 'liquid_krypton');
CryoKrypton.setEUt(120);
CryoKrypton.setDuration(100);
CryoKrypton.setPowerHX(100);
CryoKrypton.setDurationHX(5);
CryoKrypton.setDurationRadiator(200);
CryoKrypton.setTemperature(120);

def CryoXenon = new CryoGas('xenon', 'hot_hp_xenon', 'hp_xenon', 'cold_hp_xenon', 'liquid_xenon');
CryoXenon.setEUt(120);
CryoXenon.setDuration(100);
CryoXenon.setPowerHX(100);
CryoXenon.setDurationHX(5);
CryoXenon.setDurationRadiator(200);
CryoXenon.setTemperature(165);

def CryoAir = new CryoGas('air', 'hot_hp_air', 'hp_air', 'cold_hp_air', 'liquid_air');
CryoAir.setEUt(30);
CryoAir.setDuration(10);
CryoAir.setPowerHX(50);
CryoAir.setDurationHX(1);
CryoAir.setDurationRadiator(10);
CryoAir.setTemperature(80);

def CryoDecarburizedAir = new CryoGas('decarburized_air', 'hot_hp_decarburized_air', 'hp_decarburized_air', 'cold_hp_decarburized_air', 'liquid_decarburized_air');
CryoDecarburizedAir.setEUt(60);
CryoDecarburizedAir.setDuration(1);
CryoDecarburizedAir.setPowerHX(100);
CryoDecarburizedAir.setDurationHX(8);
CryoDecarburizedAir.setDurationRadiator(20);
CryoDecarburizedAir.setTemperature(80);

def CryoNitrogen = new CryoGas('nitrogen', 'hot_hp_nitrogen', 'hp_nitrogen', 'cold_hp_nitrogen', 'liquid_nitrogen');
CryoNitrogen.setEUt(60);
CryoNitrogen.setDuration(100);
CryoNitrogen.setPowerHX(100);
CryoNitrogen.setDurationHX(5);
CryoNitrogen.setDurationRadiator(200);
CryoNitrogen.setTemperature(77);

def CryoNetherAir = new CryoGas('nether_air', 'hot_hp_nether_air', 'hp_nether_air', 'cold_hp_nether_air', 'liquid_nether_air');
CryoNetherAir.setEUt(60);
CryoNetherAir.setDuration(100);
CryoNetherAir.setPowerHX(100);
CryoNetherAir.setDurationHX(5);
CryoNetherAir.setDurationRadiator(200);
CryoNetherAir.setTemperature(80);

def CryoNaturalGas = new CryoGas('natural_gas', 'hot_hp_natural_gas', 'hp_natural_gas', 'cold_hp_natural_gas', 'liquid_natural_gas');
CryoNaturalGas.setEUt(60);
CryoNaturalGas.setDuration(100);
CryoNaturalGas.setPowerHX(100);
CryoNaturalGas.setDurationHX(5);
CryoNaturalGas.setDurationRadiator(200);
CryoNaturalGas.setTemperature(80);

def CryoPetroleumGas = new CryoGas('fuel_gas', 'hot_hp_fuel_gas', 'hp_fuel_gas', 'cold_hp_fuel_gas', 'lpg');
CryoNaturalGas.setEUt(60);
CryoNaturalGas.setDuration(100);
CryoNaturalGas.setPowerHX(100);
CryoNaturalGas.setDurationHX(5);
CryoNaturalGas.setDurationRadiator(200);
CryoNaturalGas.setTemperature(80);

def CryoMethane = new CryoGas('methane', 'hot_hp_methane', 'hp_methane', 'cold_hp_methane', 'liquid_methane');
CryoMethane.setEUt(60);
CryoMethane.setDuration(100);
CryoMethane.setPowerHX(100);
CryoMethane.setDurationHX(5);
CryoMethane.setDurationRadiator(200);
CryoMethane.setTemperature(80);

def CryoGases = [
        CryoHydrogen,
        CryoOxygen,
        CryoHelium,
        CryoNeon,
        CryoArgon,
        CryoKrypton,
        CryoXenon,
        CryoNitrogen,
        CryoAir,
        CryoDecarburizedAir,
        CryoNetherAir,
        CryoNaturalGas,
        CryoPetroleumGas,
        CryoMethane
];

def AmmoniaRefrigerant = new Refrigerant("ammonia", 'hot_compressed_ammonia', 'compressed_ammonia', 'cold_ammonia');
AmmoniaRefrigerant.setPowerToCompress(120);
AmmoniaRefrigerant.setDurationToCompress(20);
AmmoniaRefrigerant.setDurationRadiator(20);
AmmoniaRefrigerant.setAmountToUse(1000);
AmmoniaRefrigerant.setTimeFactor(10);

def PropaneRefrigerant = new Refrigerant('propane', 'hot_compressed_propane', 'compressed_propane', 'cold_propane');
PropaneRefrigerant.setPowerToCompress(60);
PropaneRefrigerant.setDurationToCompress(30);
PropaneRefrigerant.setDurationRadiator(10);
PropaneRefrigerant.setAmountToUse(2000);
PropaneRefrigerant.setTimeFactor(15);

def CarbonDioxideRefrigerant = new Refrigerant('carbon_dioxide', 'hot_compressed_carbon_dioxide', 'compressed_carbon_dioxide', 'cold_carbon_dioxide');
CarbonDioxideRefrigerant.setPowerToCompress(30);
CarbonDioxideRefrigerant.setDurationToCompress(60);
CarbonDioxideRefrigerant.setDurationRadiator(10);
CarbonDioxideRefrigerant.setAmountToUse(3000);
CarbonDioxideRefrigerant.setTimeFactor(20);

def TrichlorofluoromethaneRefrigerant = new Refrigerant("trichlorofluoromethane", 'hot_compressed_trichlorofluoromethane', 'compressed_trichlorofluoromethane', 'cold_trichlorofluoromethane');
TrichlorofluoromethaneRefrigerant.setPowerToCompress(180);
TrichlorofluoromethaneRefrigerant.setDurationToCompress(4);
TrichlorofluoromethaneRefrigerant.setDurationRadiator(2);
TrichlorofluoromethaneRefrigerant.setAmountToUse(1000);
TrichlorofluoromethaneRefrigerant.setTimeFactor(2);

def DichlorodifluoromethaneRefrigerant = new Refrigerant("dichlorodifluoromethane", 'hot_compressed_dichlorodifluoromethane', 'compressed_dichlorodifluoromethane', 'cold_dichlorodifluoromethane');
DichlorodifluoromethaneRefrigerant.setPowerToCompress(180);
DichlorodifluoromethaneRefrigerant.setDurationToCompress(4);
DichlorodifluoromethaneRefrigerant.setDurationRadiator(2);
DichlorodifluoromethaneRefrigerant.setAmountToUse(1000);
DichlorodifluoromethaneRefrigerant.setTimeFactor(2);

def ChlorotrifluoromethaneRefrigerant = new Refrigerant("chlorotrifluoromethane", 'hot_compressed_chlorotrifluoromethane', 'compressed_chlorotrifluoromethane', 'cold_chlorotrifluoromethane');
ChlorotrifluoromethaneRefrigerant.setPowerToCompress(180);
ChlorotrifluoromethaneRefrigerant.setDurationToCompress(4);
ChlorotrifluoromethaneRefrigerant.setDurationRadiator(2);
ChlorotrifluoromethaneRefrigerant.setAmountToUse(1000);
ChlorotrifluoromethaneRefrigerant.setTimeFactor(2);

def ChlorodifluoromethaneRefrigerant = new Refrigerant("chlorodifluoromethane", 'hot_compressed_chlorodifluoromethane', 'compressed_chlorodifluoromethane', 'cold_chlorodifluoromethane');
ChlorodifluoromethaneRefrigerant.setPowerToCompress(180);
ChlorodifluoromethaneRefrigerant.setDurationToCompress(4);
ChlorodifluoromethaneRefrigerant.setDurationRadiator(2);
ChlorodifluoromethaneRefrigerant.setAmountToUse(1000);
ChlorodifluoromethaneRefrigerant.setTimeFactor(2);

def Refrigerants = [
        AmmoniaRefrigerant,
        PropaneRefrigerant,
        CarbonDioxideRefrigerant,
        TrichlorofluoromethaneRefrigerant,
        DichlorodifluoromethaneRefrigerant,
        ChlorotrifluoromethaneRefrigerant,
        ChlorodifluoromethaneRefrigerant
];

def CarbonDioxideSupercritical = new SupercriticalFluid("compressed_carbon_dioxide", "supercritical_carbon_dioxide");
CarbonDioxideSupercritical.setPowerToCompress(240);
CarbonDioxideSupercritical.setDurationToCompress(200);
CarbonDioxideSupercritical.setCriticalTemperature(304);

def PropaneSupercritical = new SupercriticalFluid("compressed_propane", "supercritical_propane");
PropaneSupercritical.setPowerToCompress(480);
PropaneSupercritical.setDurationToCompress(100);
PropaneSupercritical.setCriticalTemperature(370);

def SupercriticalFluids = [
        CarbonDioxideSupercritical,
        PropaneSupercritical
]

// Natural draft water cooling

COOLING_TOWER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(liquid('warm_water') * 1536)
        .fluidOutputs(liquid('chilled_water') * 1152)
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

COOLING_TOWER.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(liquid('warm_water') * 1536)
        .fluidOutputs(liquid('water') * 1152)
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

COOLING_TOWER.recipeBuilder()
        .fluidInputs(liquid('water') * 1536)
        .fluidOutputs(liquid('chilled_water') * 1152)
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

//Refrigerant recipes generation
for (refrigerant in Refrigerants) {
    //Compression
    FLUID_COMPRESSOR.recipeBuilder()
            .fluidInputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.hot_refrigerant) * refrigerant.amount_to_use)
            .EUt(refrigerant.EUt)
            .duration(refrigerant.duration)
            .buildAndRegister();

    //Decompression
    FLUID_DECOMPRESSOR.recipeBuilder()
            .fluidInputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .EUt(VA[ULV])
            .duration(refrigerant.duration)
            .buildAndRegister();

    //Radiative Cooling
    RADIATOR.recipeBuilder()
            .fluidInputs(liquid(refrigerant.hot_refrigerant) * (refrigerant.amount_to_use / 10))
            .fluidOutputs(liquid(refrigerant.comp_refrigerant) * (refrigerant.amount_to_use / 10))
            .duration(refrigerant.duration_radiator)
            .buildAndRegister();

    //Water Secondary Loop
    HEAT_EXCHANGER.recipeBuilder()
            .fluidInputs(liquid(refrigerant.hot_refrigerant) * refrigerant.amount_to_use)
            .fluidInputs(liquid('chilled_water') * (int)(refrigerant.amount_to_use * 0.384))
            .fluidOutputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid('warm_water') * (int)(refrigerant.amount_to_use * 0.384))
            .duration((int) (refrigerant.duration_radiator / 2))
            .EUt(VA[HV])
            .buildAndRegister();
}

//Coolant recipes generation
    
for (coolant in Coolants) {
    if (coolant.circuit != 0) {
        RADIATOR.recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * (coolant.amount_to_use / 10))
            .fluidOutputs(liquid(coolant.cold_coolant) * (coolant.amount_to_use / 10))
            .duration(coolant.duration_radiator)
            .circuitMeta(coolant.getCircuit())
            .buildAndRegister();
    }
    else {
        RADIATOR.recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * (coolant.amount_to_use / 10))
            .fluidOutputs(liquid(coolant.cold_coolant) * (coolant.amount_to_use / 10))
            .duration(coolant.duration_radiator)
            .buildAndRegister();
    }
}

//Heat exchanger recipes generation
for (cryogas in CryoGases) {
    for (coolant in Coolants) {
        HEAT_EXCHANGER.recipeBuilder()
                .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * cryogas.amount_to_use)
                .fluidInputs(liquid(coolant.cold_coolant) * coolant.amount_to_use)
                .fluidOutputs(liquid(coolant.warm_coolant) * coolant.amount_to_use)
                .fluidOutputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                .duration((int)((cryogas.duration_heat_exchanger + coolant.hx_time_factor) / 2))
                .buildAndRegister();
    }
    for (refrigerant in Refrigerants) {
        HEAT_EXCHANGER.recipeBuilder()
                .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
                .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
                .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
                .info('recipe.refrigeration')
                .duration((int)((cryogas.duration_heat_exchanger + refrigerant.hx_time_factor) / 2))
                .buildAndRegister();
    }

    FLUID_COMPRESSOR.recipeBuilder()
            .fluidInputs(liquid(cryogas.normal_gas) * 1280)
            .fluidOutputs(liquid(cryogas.hot_high_pressure_gas) * 1280)
            .duration(cryogas.duration)
            .EUt(cryogas.EUt)
            .buildAndRegister();

    //Decompression
    FLUID_DECOMPRESSOR.recipeBuilder()
            .fluidInputs(liquid(cryogas.cold_high_pressure_gas) * 1280)
            .fluidOutputs(liquid(cryogas.liquid_gas) * 20)
            .duration(20)
            .EUt(VA[ULV])
            .buildAndRegister();

    //Reheating
    FLUID_HEATER.recipeBuilder()
            .circuitMeta(1)
            .fluidInputs(liquid(cryogas.liquid_gas) * 20)
            .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * 1280)
            .duration(20)
            .EUt(VA[ULV])
            .buildAndRegister();

    //Boiling
    FLUID_HEATER.recipeBuilder()
            .circuitMeta(2)
            .fluidInputs(liquid(cryogas.liquid_gas) * 20)
            .fluidOutputs(liquid(cryogas.normal_gas) * 1280)
            .duration(2)
            .EUt(VA[HV])
            .buildAndRegister();

    //Radiative Cooling
    RADIATOR.recipeBuilder()
            .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * (cryogas.amount_to_use / 10))
            .fluidOutputs(liquid(cryogas.high_pressure_gas) * (cryogas.amount_to_use / 10))
            .duration((int)(cryogas.duration_heat_exchanger * 5 / 2))
            .buildAndRegister();
}

//Water cooling
for (refrigerant in Refrigerants) {
    HEAT_EXCHANGER.recipeBuilder()
            .fluidInputs(liquid('water') * 1000)
            .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid('ice') * 1000)
            .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
            .duration(60)
            .buildAndRegister();
}

def Gasoline = new FluidFuel('gasoline');
Gasoline.setDuration(1625);
Gasoline.setFuelAmount(160);
Gasoline.setFlueAmount(1300);
Gasoline.setIsFuelCellFuel(true);

def MidgradeGasoline = new FluidFuel('midgrade_gasoline');
MidgradeGasoline.setDuration(1950);
MidgradeGasoline.setFuelAmount(160);
MidgradeGasoline.setFlueAmount(1560);

def PremiumGasoline = new FluidFuel('premium_gasoline');
PremiumGasoline.setDuration(2275);
PremiumGasoline.setFuelAmount(160);
PremiumGasoline.setFlueAmount(1820);

def SupremeGasoline = new FluidFuel('supreme_gasoline');
SupremeGasoline.setDuration(2600);
SupremeGasoline.setFuelAmount(160);
SupremeGasoline.setFlueAmount(2080);

def Kerosene = new FluidFuel('kerosene');
Kerosene.setDuration(2875);
Kerosene.setFuelAmount(160);
Kerosene.setFlueAmount(2300);
Kerosene.setIsFuelCellFuel(true);

def MidgradeKerosene = new FluidFuel('midgrade_kerosene');
MidgradeKerosene.setDuration(3450);
MidgradeKerosene.setFuelAmount(160);
MidgradeKerosene.setFlueAmount(2760);

def PremiumKerosene = new FluidFuel('premium_kerosene');
PremiumKerosene.setDuration(4025);
PremiumKerosene.setFuelAmount(160);
PremiumKerosene.setFlueAmount(3220);

def SupremeKerosene = new FluidFuel('supreme_kerosene');
SupremeKerosene.setDuration(4600);
SupremeKerosene.setFuelAmount(160);
SupremeKerosene.setFlueAmount(3680);

def Diesel = new FluidFuel('diesel');
Diesel.setDuration(3875);
Diesel.setFuelAmount(160);
Diesel.setFlueAmount(3100);
Diesel.setIsFuelCellFuel(true);

def MidgradeDiesel = new FluidFuel('midgrade_diesel');
MidgradeDiesel.setDuration(4650);
MidgradeDiesel.setFuelAmount(160);
MidgradeDiesel.setFlueAmount(3720);

def PremiumDiesel = new FluidFuel('premium_diesel');
PremiumDiesel.setDuration(5425);
PremiumDiesel.setFuelAmount(160);
PremiumDiesel.setFlueAmount(4340);

def SupremeDiesel = new FluidFuel('supreme_diesel');
SupremeDiesel.setDuration(6200);
SupremeDiesel.setFuelAmount(160);
SupremeDiesel.setFlueAmount(4960);

def FuelOil = new FluidFuel('fuel_oil');
FuelOil.setDuration(5000);
FuelOil.setFuelAmount(160);
FuelOil.setFlueAmount(4000);
FuelOil.setIsFuelCellFuel(true);

def BioDiesel = new FluidFuel('bio_diesel');
BioDiesel.setDuration(4750);
BioDiesel.setFuelAmount(160);
BioDiesel.setFlueAmount(3800);

def LiquidNaturalGas = new FluidFuel('liquid_natural_gas');
LiquidNaturalGas.setDuration(725);
LiquidNaturalGas.setFuelAmount(5);
LiquidNaturalGas.setFlueAmount(580);
LiquidNaturalGas.setIsFuelCellFuel(true);

def LiquidPetroleumGas = new FluidFuel('lpg');
LiquidPetroleumGas.setDuration(1780);
LiquidPetroleumGas.setFuelAmount(5);
LiquidPetroleumGas.setFlueAmount(1424);
LiquidPetroleumGas.setIsFuelCellFuel(true);

def Methanol = new FluidFuel('methanol');
Methanol.setDuration(205);
Methanol.setFuelAmount(160);
Methanol.setFlueAmount(164);
Methanol.setIsFuelCellFuel(true);

def Ethanol = new FluidFuel('ethanol');
Ethanol.setDuration(440);
Ethanol.setFuelAmount(160);
Ethanol.setFlueAmount(352);
Ethanol.setIsFuelCellFuel(true);

def HydrogenRichSyngas = new FluidFuel('hydrogen_rich_syngas');
HydrogenRichSyngas.setDuration(125);
HydrogenRichSyngas.setFuelAmount(480);
HydrogenRichSyngas.setFlueAmount(100);
HydrogenRichSyngas.setIsFuelCellFuel(true);
HydrogenRichSyngas.setGaseous(true);

def MonoxideRichSyngas = new FluidFuel('monoxide_rich_syngas');
MonoxideRichSyngas.setDuration(50);
MonoxideRichSyngas.setFuelAmount(160);
MonoxideRichSyngas.setFlueAmount(40);
MonoxideRichSyngas.setIsFuelCellFuel(true);
MonoxideRichSyngas.setGaseous(true);

def NaturalGas = new FluidFuel('natural_gas');
NaturalGas.setDuration(725);
NaturalGas.setFuelAmount(320);
NaturalGas.setFlueAmount(580);
NaturalGas.setIsFuelCellFuel(true);
NaturalGas.setGaseous(true);

def FuelGas = new FluidFuel('fuel_gas');
FuelGas.setDuration(890);
FuelGas.setFuelAmount(160);
FuelGas.setFlueAmount(712);
FuelGas.setIsFuelCellFuel(true);
FuelGas.setGaseous(true);

def CoalGas = new FluidFuel('coal_gas');
CoalGas.setDuration(40);
CoalGas.setFuelAmount(160);
CoalGas.setFlueAmount(32);
CoalGas.setIsFuelCellFuel(true);
CoalGas.setGaseous(true);

def WoodGas = new FluidFuel('wood_gas');
WoodGas.setDuration(28);
WoodGas.setFuelAmount(160);
WoodGas.setFlueAmount(22);
WoodGas.setIsFuelCellFuel(true);
WoodGas.setGaseous(true);

def Methane = new FluidFuel('methane');
Methane.setDuration(250);
Methane.setFuelAmount(160);
Methane.setFlueAmount(200);
Methane.setIsFuelCellFuel(true);
Methane.setGaseous(true);

def Ethane = new FluidFuel('ethane');
Ethane.setDuration(500);
Ethane.setFuelAmount(160);
Ethane.setFlueAmount(400);
Ethane.setIsFuelCellFuel(true);
Ethane.setGaseous(true);

def Propane = new FluidFuel('propane');
Propane.setDuration(750);
Propane.setFuelAmount(160);
Propane.setFlueAmount(600);
Propane.setIsFuelCellFuel(true);
Propane.setGaseous(true);

def Butane = new FluidFuel('butane');
Butane.setDuration(1000);
Butane.setFuelAmount(160);
Butane.setFlueAmount(800);
Butane.setIsFuelCellFuel(true);
Butane.setGaseous(true);

def FluidFuels = [
        Gasoline,
        MidgradeGasoline,
        PremiumGasoline,
        SupremeGasoline,
        Kerosene,
        MidgradeKerosene,
        PremiumKerosene,
        SupremeKerosene,
        Diesel,
        MidgradeDiesel,
        PremiumDiesel,
        SupremeDiesel,
        FuelOil,
        BioDiesel,
        LiquidNaturalGas,
        LiquidPetroleumGas,
        Methanol,
        Ethanol,
        HydrogenRichSyngas,
        MonoxideRichSyngas,
        NaturalGas,
        FuelGas,
        CoalGas,
        WoodGas,
        Methane,
        Ethane,
        Propane,
        Butane
];

def WaterWF = new WorkingFluid('water', 'steam', 'exhaust_steam');
WaterWF.setDuration(10);
WaterWF.setAmountToUse(6);
WaterWF.setEfficiency(1);
WaterWF.setConversionFactor(160);

def WorkingFluids = [
        WaterWF
];

for (fluid_fuel in FluidFuels) {
        if (fluid_fuel.gaseous) {
                GAS_TURBINE.recipeBuilder()
                        .fluidInputs(liquid(fluid_fuel.liquid_fuel) * fluid_fuel.fuel_amount)
                        .fluidOutputs(fluid('flue_gas') * (int) (fluid_fuel.flue_amount * 1.5))
                        .duration((int) (fluid_fuel.duration * 1.5))
                        .EUt(32)
                        .info('recipe.power_generation.multiblock_rotation')
                        .buildAndRegister();
        } else {
                COMBUSTION_GENERATOR.recipeBuilder()
                        .fluidInputs(liquid(fluid_fuel.liquid_fuel) * fluid_fuel.fuel_amount)
                        .duration(fluid_fuel.duration)
                        .EUt(32)
                        .info('recipe.power_generation.combustion')
                        .buildAndRegister();

                GAS_TURBINE.recipeBuilder()
                        .fluidInputs(liquid(fluid_fuel.liquid_fuel) * fluid_fuel.fuel_amount)
                        .fluidOutputs(fluid('flue_gas') * (int) (fluid_fuel.flue_amount * 1.5))
                        .duration((int) (fluid_fuel.duration * 1.5))
                        .EUt(32)
                        .info('recipe.power_generation.multiblock_rotation')
                        .buildAndRegister();
        }

        if (fluid_fuel.fuel_cell) {
                FUEL_CELL.recipeBuilder()
                        .fluidInputs(liquid(fluid_fuel.liquid_fuel) * fluid_fuel.fuel_amount)
                        .fluidInputs(fluid('preheated_air') * 100)
                        .duration(fluid_fuel.duration * 2)
                        .EUt(32)
                        .info('recipe.power_generation.fuel_cell')
                        .buildAndRegister();
        }
}

FLUID_HEATER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('air') * 1000)
        .fluidOutputs(fluid('preheated_air') * 1000)
        .duration(5)
        .EUt(VA[EV])
        .buildAndRegister();

// Combined Cycle
// Flue gas is 10,000 EU/mol or 10 EU/L
HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('deionized_water') * 640) 
        .fluidInputs(fluid('desulfurized_flue_gas') * 32768)
        .fluidOutputs(fluid('hp_steam') * 640)
        .fluidOutputs(fluid('chilled_flue_gas') * 32768)
        .duration(5)
        .info('recipe.power_generation.combined_cycle')
        .buildAndRegister();

HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('deionized_water') * 640)
        .fluidInputs(fluid('flue_gas') * 32768)
        .fluidOutputs(fluid('hp_steam') * 640)
        .fluidOutputs(fluid('chilled_flue_gas') * 32768)
        .duration(5)
        .info('recipe.power_generation.combined_cycle')
        .buildAndRegister();

for (working_fluid in WorkingFluids) {
        STEAM_TURBINE.recipeBuilder()
                .fluidInputs(liquid(working_fluid.heated_fluid) * (working_fluid.amount_to_use * working_fluid.conversion_factor))
                .fluidOutputs(liquid(working_fluid.leftover_fluid) * (working_fluid.amount_to_use * working_fluid.conversion_factor))
                .duration(working_fluid.duration * working_fluid.efficiency)
                .EUt(32)
                .buildAndRegister()

        LARGE_STEAM_TURBINE.recipeBuilder()
                .fluidInputs(liquid(working_fluid.heated_fluid) * (working_fluid.amount_to_use * working_fluid.conversion_factor))
                .fluidOutputs(liquid(working_fluid.leftover_fluid) * (working_fluid.amount_to_use * working_fluid.conversion_factor))
                .duration(working_fluid.duration * working_fluid.efficiency)
                .EUt(32)
                .info('recipe.power_generation.multiblock_rotation')
                .buildAndRegister()

        RADIATOR.recipeBuilder()
                .fluidInputs(liquid(working_fluid.leftover_fluid) * (working_fluid.amount_to_use * working_fluid.conversion_factor * 2))
                .fluidOutputs(liquid(working_fluid.normal_fluid) * (working_fluid.amount_to_use * 2))
                .duration(working_fluid.duration)
                .EUt(8)
                .buildAndRegister();
}

// Water WF cooling tower

COOLING_TOWER.recipeBuilder()
        .fluidInputs(liquid('exhaust_steam') * (6 * 160 * 64))
        .fluidOutputs(liquid('water') * (6 * 64))
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

// Supercritical fluid compression

for (scfluid in SupercriticalFluids) {
        FLUID_COMPRESSOR.recipeBuilder()
            .fluidInputs(fluid(scfluid.getStartingGas()) * 1280)
            .fluidOutputs(fluid(scfluid.getSupercriticalFluid()) * 20)
            .EUt(scfluid.getPowerToCompress())
            .duration(scfluid.getDurationToCompress())
            .buildAndRegister();
}

// Misc processing

FLUID_COMPRESSOR.recipeBuilder()
        .fluidInputs(liquid('benzene') * 1280)
        .fluidOutputs(liquid('hot_hp_benzene') * 1280)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

FLUID_COMPRESSOR.recipeBuilder()
        .fluidInputs(liquid('propene') * 1280)
        .fluidOutputs(liquid('hot_hp_propene') * 1280)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister();

HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(liquid('water') * 96)
        .fluidInputs(liquid('lava') * 10)
        .fluidOutputs(liquid('steam') * 15360)
        .fluidOutputs(liquid('chilled_lava') * 10)
        .duration(10)
        .buildAndRegister();

FLUID_HEATER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

CONDENSER.recipeBuilder()
    .fluidInputs(fluid('dense_steam') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(5)
    .buildAndRegister()

// Nuclear coolant cycles

// PWR pressurizer & steam generator

FLUID_COMPRESSOR.recipeBuilder()
        .notConsumable(ore('springNichrome'))
        .fluidInputs(liquid('deionized_water') * 1536)
        .fluidOutputs(liquid('pressurized_water') * 1536)
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

FLUID_HEATER.recipeBuilder()
        .fluidInputs(liquid('heavy_water') * 1536)
        .fluidOutputs(liquid('pressurized_heavy_water') * 1536)
        .duration(2000)
        .EUt(VA[HV])
        .buildAndRegister();

HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(liquid('hot_pressurized_water') * 1536)
        .fluidInputs(liquid('deionized_water') * 1640)
        .fluidOutputs(liquid('deionized_water') * 1536)
        .fluidOutputs(fluid('hp_steam') * 1640)
        .duration(1)
        .buildAndRegister();

HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(liquid('hot_pressurized_heavy_water') * 1536)
        .fluidInputs(liquid('deionized_water') * 1490)
        .fluidOutputs(liquid('tritiated_heavy_water') * 1536)
        .fluidOutputs(fluid('hp_steam') * 1490)
        .duration(1)
        .buildAndRegister();

// BWR bootstrap

FLUID_HEATER.recipeBuilder()
        .circuitMeta(4)
        .fluidInputs(liquid('deionized_water') * 1536)
        .fluidOutputs(liquid('boiling_water') * 1536)
        .duration(2000)
        .EUt(VA[HV])
        .buildAndRegister();

// AST

// PWR
ADV_STEAM_TURBINE.recipeBuilder()
        .fluidInputs(liquid('hp_steam') * 40)
        .fluidOutputs(liquid('hp_exhaust_steam') * 40)
        .duration(10)
        .EUt(2048)
        .buildAndRegister()

// BWR
ADV_STEAM_TURBINE.recipeBuilder()
        .fluidInputs(liquid('hp_wet_steam') * 40)
        .fluidOutputs(liquid('hp_wet_exhaust_steam') * 40)
        .duration(10)
        .EUt(2048)
        .buildAndRegister()

// Coolant reclamation

HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(liquid('hp_exhaust_steam') * 1536)
        .fluidInputs(liquid('chilled_water') * 192)
        .fluidOutputs(liquid('deionized_water') * 1536)
        .fluidOutputs(liquid('warm_water') * 192)
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(liquid('hp_wet_exhaust_steam') * 1536)
        .fluidInputs(liquid('chilled_water') * 192)
        .fluidOutputs(liquid('boiling_water') * 1536)
        .fluidOutputs(liquid('warm_water') * 192)
        .duration(1)
        .EUt(VA[HV])
        .buildAndRegister();

//Hot Air

FLUID_HEATER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(liquid('air') * 1000)
        .fluidOutputs(liquid('hot_air') * 1000)
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister();
