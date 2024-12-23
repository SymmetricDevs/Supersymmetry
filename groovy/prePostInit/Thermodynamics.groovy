package prePostInit;

import classes.*;
import globals.Globals;

import java.lang.Math;

//REMOVALS

mods.gregtech.steam_turbine.removeByInput(32, null, [fluid('steam') * 640])
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

def WaterCoolant = new ICoolant("water", "warm_water");
WaterCoolant.setDurationRadiator(100);
WaterCoolant.setAmountToUse(1000);
WaterCoolant.setTimeFactor(10);

def SaltWaterCoolant = new ICoolant("salt_water", "warm_salt_water");
SaltWaterCoolant.setDurationRadiator(100);
SaltWaterCoolant.setAmountToUse(1000);
SaltWaterCoolant.setTimeFactor(15);

def BrineCoolant = new ICoolant("brine", "warm_brine");
BrineCoolant.setDurationRadiator(100);
BrineCoolant.setAmountToUse(1000);
BrineCoolant.setTimeFactor(15);

def LubricantCoolant = new ICoolant("lubricant", "warm_lubricant");
LubricantCoolant.setDurationRadiator(75);
LubricantCoolant.setAmountToUse(1000);
LubricantCoolant.setTimeFactor(6);

def SodiumPotassiumCoolant = new ICoolant("sodium_potassium", "warm_sodium_potassium");
SodiumPotassiumCoolant.setDurationRadiator(60);
SodiumPotassiumCoolant.setAmountToUse(2000);
SodiumPotassiumCoolant.setTimeFactor(5);

def EthyleneGlycolCoolant = new ICoolant("ethylene_glycol", "warm_ethylene_glycol");
EthyleneGlycolCoolant.setDurationRadiator(50);
EthyleneGlycolCoolant.setAmountToUse(2000);
EthyleneGlycolCoolant.setTimeFactor(4);

def PolychlorinatedBiphenylCoolant = new ICoolant("polychlorinated_biphenyl", "warm_polychlorinated_biphenyl");
PolychlorinatedBiphenylCoolant.setDurationRadiator(40);
PolychlorinatedBiphenylCoolant.setAmountToUse(1000);
PolychlorinatedBiphenylCoolant.setTimeFactor(2);

def Coolants = [
        WaterCoolant,
        SaltWaterCoolant,
        LubricantCoolant,
        SodiumPotassiumCoolant,
        EthyleneGlycolCoolant,
        PolychlorinatedBiphenylCoolant
];

def CryoHydrogen = new ICryoGas('hydrogen', 'hot_hp_hydrogen', 'hp_hydrogen', 'cold_hp_hydrogen', 'liquid_hydrogen');
CryoHydrogen.setEUt(240);
CryoHydrogen.setDuration(100);
CryoHydrogen.setPowerHX(100);
CryoHydrogen.setDurationHX(5);
CryoHydrogen.setDurationRadiator(200);
CryoHydrogen.setTemperature(14);

def CryoOxygen = new ICryoGas('oxygen', 'hot_hp_oxygen', 'hp_oxygen', 'cold_hp_oxygen', 'liquid_oxygen');
CryoOxygen.setEUt(30);
CryoOxygen.setDuration(100);
CryoOxygen.setPowerHX(100);
CryoOxygen.setDurationHX(5);
CryoOxygen.setDurationRadiator(200);
CryoOxygen.setTemperature(90);

def CryoHelium = new ICryoGas('helium', 'hot_hp_helium', 'hp_helium', 'cold_hp_helium', 'liquid_helium');
CryoHelium.setEUt(720);
CryoHelium.setDuration(100);
CryoHelium.setPowerHX(100);
CryoHelium.setDurationHX(5);
CryoHelium.setDurationRadiator(200);
CryoHelium.setTemperature(4);

def CryoNeon = new ICryoGas('neon', 'hot_hp_neon', 'hp_neon', 'cold_hp_neon', 'liquid_neon');
CryoNeon.setEUt(240);
CryoNeon.setDuration(100);
CryoNeon.setPowerHX(100);
CryoNeon.setDurationHX(5);
CryoNeon.setDurationRadiator(200);
CryoNeon.setTemperature(27);

def CryoArgon = new ICryoGas('argon', 'hot_hp_argon', 'hp_argon', 'cold_hp_argon', 'liquid_argon');
CryoArgon.setEUt(120);
CryoArgon.setDuration(100);
CryoArgon.setPowerHX(100);
CryoArgon.setDurationHX(5);
CryoArgon.setDurationRadiator(200);
CryoArgon.setTemperature(87);

def CryoKrypton = new ICryoGas('krypton', 'hot_hp_krypton', 'hp_krypton', 'cold_hp_krypton', 'liquid_krypton');
CryoKrypton.setEUt(120);
CryoKrypton.setDuration(100);
CryoKrypton.setPowerHX(100);
CryoKrypton.setDurationHX(5);
CryoKrypton.setDurationRadiator(200);
CryoKrypton.setTemperature(120);

def CryoXenon = new ICryoGas('xenon', 'hot_hp_xenon', 'hp_xenon', 'cold_hp_xenon', 'liquid_xenon');
CryoXenon.setEUt(120);
CryoXenon.setDuration(100);
CryoXenon.setPowerHX(100);
CryoXenon.setDurationHX(5);
CryoXenon.setDurationRadiator(200);
CryoXenon.setTemperature(165);

def CryoAir = new ICryoGas('air', 'hot_hp_air', 'hp_air', 'cold_hp_air', 'liquid_air');
CryoAir.setEUt(60);
CryoAir.setDuration(100);
CryoAir.setPowerHX(100);
CryoAir.setDurationHX(5);
CryoAir.setDurationRadiator(200);
CryoAir.setTemperature(80);

def CryoDecarburizedAir = new ICryoGas('decarburized_air', 'hot_hp_decarburized_air', 'hp_decarburized_air', 'cold_hp_decarburized_air', 'liquid_decarburized_air');
CryoDecarburizedAir.setEUt(60);
CryoDecarburizedAir.setDuration(1);
CryoDecarburizedAir.setPowerHX(100);
CryoDecarburizedAir.setDurationHX(8);
CryoDecarburizedAir.setDurationRadiator(20);
CryoDecarburizedAir.setTemperature(80);

def CryoNitrogen = new ICryoGas('nitrogen', 'hot_hp_nitrogen', 'hp_nitrogen', 'cold_hp_nitrogen', 'liquid_nitrogen');
CryoNitrogen.setEUt(60);
CryoNitrogen.setDuration(100);
CryoNitrogen.setPowerHX(100);
CryoNitrogen.setDurationHX(5);
CryoNitrogen.setDurationRadiator(200);
CryoNitrogen.setTemperature(77);

def CryoNetherAir = new ICryoGas('nether_air', 'hot_hp_nether_air', 'hp_nether_air', 'cold_hp_nether_air', 'liquid_nether_air');
CryoNetherAir.setEUt(60);
CryoNetherAir.setDuration(100);
CryoNetherAir.setPowerHX(100);
CryoNetherAir.setDurationHX(5);
CryoNetherAir.setDurationRadiator(200);
CryoNetherAir.setTemperature(80);

def CryoNaturalGas = new ICryoGas('natural_gas', 'hot_hp_natural_gas', 'hp_natural_gas', 'cold_hp_natural_gas', 'liquid_natural_gas');
CryoNaturalGas.setEUt(60);
CryoNaturalGas.setDuration(100);
CryoNaturalGas.setPowerHX(100);
CryoNaturalGas.setDurationHX(5);
CryoNaturalGas.setDurationRadiator(200);
CryoNaturalGas.setTemperature(80);

def CryoPetroleumGas = new ICryoGas('fuel_gas', 'hot_hp_fuel_gas', 'hp_fuel_gas', 'cold_hp_fuel_gas', 'lpg');
CryoNaturalGas.setEUt(60);
CryoNaturalGas.setDuration(100);
CryoNaturalGas.setPowerHX(100);
CryoNaturalGas.setDurationHX(5);
CryoNaturalGas.setDurationRadiator(200);
CryoNaturalGas.setTemperature(80);

def CryoMethane = new ICryoGas('methane', 'hot_hp_methane', 'hp_methane', 'cold_hp_methane', 'liquid_methane');
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

def AmmoniaRefrigerant = new IRefrigerant("ammonia", 'hot_compressed_ammonia', 'compressed_ammonia', 'cold_ammonia');
AmmoniaRefrigerant.setPowerToCompress(120);
AmmoniaRefrigerant.setDurationToCompress(20);
AmmoniaRefrigerant.setDurationRadiator(20);
AmmoniaRefrigerant.setAmountToUse(1000);
AmmoniaRefrigerant.setTimeFactor(10);

def PropaneRefrigerant = new IRefrigerant('propane', 'hot_compressed_propane', 'compressed_propane', 'cold_propane');
PropaneRefrigerant.setPowerToCompress(60);
PropaneRefrigerant.setDurationToCompress(30);
PropaneRefrigerant.setDurationRadiator(10);
PropaneRefrigerant.setAmountToUse(2000);
PropaneRefrigerant.setTimeFactor(15);

def CarbonDioxideRefrigerant = new IRefrigerant('carbon_dioxide', 'hot_compressed_carbon_dioxide', 'compressed_carbon_dioxide', 'cold_carbon_dioxide');
CarbonDioxideRefrigerant.setPowerToCompress(30);
CarbonDioxideRefrigerant.setDurationToCompress(60);
CarbonDioxideRefrigerant.setDurationRadiator(10);
CarbonDioxideRefrigerant.setAmountToUse(3000);
CarbonDioxideRefrigerant.setTimeFactor(20);

def TrichlorofluoromethaneRefrigerant = new IRefrigerant("trichlorofluoromethane", 'hot_compressed_trichlorofluoromethane', 'compressed_trichlorofluoromethane', 'cold_trichlorofluoromethane');
TrichlorofluoromethaneRefrigerant.setPowerToCompress(180);
TrichlorofluoromethaneRefrigerant.setDurationToCompress(4);
TrichlorofluoromethaneRefrigerant.setDurationRadiator(2);
TrichlorofluoromethaneRefrigerant.setAmountToUse(1000);
TrichlorofluoromethaneRefrigerant.setTimeFactor(2);

def DichlorodifluoromethaneRefrigerant = new IRefrigerant("dichlorodifluoromethane", 'hot_compressed_dichlorodifluoromethane', 'compressed_dichlorodifluoromethane', 'cold_dichlorodifluoromethane');
DichlorodifluoromethaneRefrigerant.setPowerToCompress(180);
DichlorodifluoromethaneRefrigerant.setDurationToCompress(4);
DichlorodifluoromethaneRefrigerant.setDurationRadiator(2);
DichlorodifluoromethaneRefrigerant.setAmountToUse(1000);
DichlorodifluoromethaneRefrigerant.setTimeFactor(2);

def ChlorotrifluoromethaneRefrigerant = new IRefrigerant("chlorotrifluoromethane", 'hot_compressed_chlorotrifluoromethane', 'compressed_chlorotrifluoromethane', 'cold_chlorotrifluoromethane');
ChlorotrifluoromethaneRefrigerant.setPowerToCompress(180);
ChlorotrifluoromethaneRefrigerant.setDurationToCompress(4);
ChlorotrifluoromethaneRefrigerant.setDurationRadiator(2);
ChlorotrifluoromethaneRefrigerant.setAmountToUse(1000);
ChlorotrifluoromethaneRefrigerant.setTimeFactor(2);

def ChlorodifluoromethaneRefrigerant = new IRefrigerant("chlorodifluoromethane", 'hot_compressed_chlorodifluoromethane', 'compressed_chlorodifluoromethane', 'cold_chlorodifluoromethane');
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

def CarbonDioxideSupercritical = new ISupercriticalFluid("compressed_carbon_dioxide", "supercritical_carbon_dioxide");
CarbonDioxideSupercritical.setPowerToCompress(240);
CarbonDioxideSupercritical.setDurationToCompress(200);
CarbonDioxideSupercritical.setCriticalTemperature(304);

def PropaneSupercritical = new ISupercriticalFluid("compressed_propane", "supercritical_propane");
PropaneSupercritical.setPowerToCompress(480);
PropaneSupercritical.setDurationToCompress(100);
PropaneSupercritical.setCriticalTemperature(370);

def SupercriticalFluids = [
        CarbonDioxideSupercritical,
        PropaneSupercritical
]

//Refrigerant recipes generation
for (refrigerant in Refrigerants) {
    //Compression
    recipemap('fluid_compressor').recipeBuilder()
            .fluidInputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.hot_refrigerant) * refrigerant.amount_to_use)
            .EUt(refrigerant.EUt)
            .duration(refrigerant.duration)
            .buildAndRegister();

    //Decompression
    recipemap('fluid_decompressor').recipeBuilder()
            .fluidInputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .EUt(Globals.voltAmps[0])
            .duration(refrigerant.duration)
            .buildAndRegister();

    //Radiative Cooling
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(refrigerant.hot_refrigerant) * (refrigerant.amount_to_use / 10))
            .fluidOutputs(liquid(refrigerant.comp_refrigerant) * (refrigerant.amount_to_use / 10))
            .duration(refrigerant.duration_radiator)
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(refrigerant.hot_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .duration((int) (refrigerant.duration_radiator / 2))
            .EUt(Globals.voltAmps[3])
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .duration((int) (refrigerant.duration_radiator / 2))
            .EUt(Globals.voltAmps[3])
            .buildAndRegister();
}

//Coolant recipes generation
for (coolant in Coolants) {
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * (coolant.amount_to_use / 10))
            .fluidOutputs(liquid(coolant.cold_coolant) * (coolant.amount_to_use / 10))
            .duration(coolant.duration_radiator)
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * coolant.amount_to_use)
            .fluidOutputs(liquid(coolant.cold_coolant) * coolant.amount_to_use)
            .duration((int) (coolant.duration_radiator / 2))
            .EUt(Globals.voltAmps[3])
            .buildAndRegister();
}

//Heat exchanger recipes generation
for (cryogas in CryoGases) {
    for (coolant in Coolants) {
        recipemap('heat_exchanger').recipeBuilder()
                .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * cryogas.amount_to_use)
                .fluidInputs(liquid(coolant.cold_coolant) * coolant.amount_to_use)
                .fluidOutputs(liquid(coolant.warm_coolant) * coolant.amount_to_use)
                .fluidOutputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                .duration((int)((cryogas.duration_heat_exchanger + coolant.hx_time_factor) / 2))
                .buildAndRegister();
    }
    for (refrigerant in Refrigerants) {
        recipemap('heat_exchanger').recipeBuilder()
                .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
                .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
                .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
                .duration((int)((cryogas.duration_heat_exchanger + refrigerant.hx_time_factor) / 2))
                .buildAndRegister();
    }

    recipemap('fluid_compressor').recipeBuilder()
            .fluidInputs(liquid(cryogas.normal_gas) * 1280)
            .fluidOutputs(liquid(cryogas.hot_high_pressure_gas) * 1280)
            .duration(cryogas.duration)
            .EUt(cryogas.EUt)
            .buildAndRegister();

    //Decompression
    recipemap('fluid_decompressor').recipeBuilder()
            .fluidInputs(liquid(cryogas.cold_high_pressure_gas) * 1280)
            .fluidOutputs(liquid(cryogas.liquid_gas) * 20)
            .duration(20)
            .EUt(Globals.voltAmps[0])
            .buildAndRegister();

    //Reheating
    recipemap('fluid_heater').recipeBuilder()
            .circuitMeta(1)
            .fluidInputs(liquid(cryogas.liquid_gas) * 20)
            .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * 1280)
            .duration(20)
            .EUt(Globals.voltAmps[0])
            .buildAndRegister();

    //Boiling
    recipemap('fluid_heater').recipeBuilder()
            .circuitMeta(2)
            .fluidInputs(liquid(cryogas.liquid_gas) * 20)
            .fluidOutputs(liquid(cryogas.normal_gas) * 1280)
            .duration(2)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister();

    //Radiative Cooling
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * (cryogas.amount_to_use / 10))
            .fluidOutputs(liquid(cryogas.high_pressure_gas) * (cryogas.amount_to_use / 10))
            .duration((int)(cryogas.duration_heat_exchanger * 5 / 2))
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * cryogas.amount_to_use)
            .fluidOutputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
            .duration(cryogas.duration_heat_exchanger)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister();

    /*if (!cryogas.needsAdvancedCooling) {
    recipemap('cooling_unit').recipeBuilder()
        .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
        .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
        .duration(cryogas.duration_heat_exchanger * 2)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister();

    } else {
        for (CryoGas in ICryoGas.cryo_gases) {
            recipemap('heat_exchanger').recipeBuilder()
                    .fluidInputs(liquid(cryogas.high_pressure_gas) * (int) (cryogas.amount_to_use / 4))
                    .fluidInputs(liquid(CryoGas.liquid_gas) * 100)              
                    .fluidOutputs(liquid(CryoGas.normal_gas) * 6400)
                    .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * (int) (cryogas.amount_to_use / 4))
                    .duration(cryogas.duration_heat_exchanger * 4)
                    .buildAndRegister();
        }
    }
    */
}

//Water cooling
for (refrigerant in Refrigerants) {
    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid('water') * 1000)
            .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid('ice') * 1000)
            .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
            .duration(60)
            .buildAndRegister();
}

def NaturalGas = new IFluidFuel('natural_gas', 'flue_gas');
NaturalGas.setDuration(100);
NaturalGas.setAmountToBurn(160);
NaturalGas.setByproductAmount(750);

def Methane = new IFluidFuel('methane', 'flue_gas');
Methane.setDuration(80);
Methane.setAmountToBurn(160);
Methane.setByproductAmount(500);

def Ethane = new IFluidFuel('ethane', 'flue_gas');
Ethane.setDuration(85);
Ethane.setAmountToBurn(160);
Ethane.setByproductAmount(500);

def Butadiene = new IFluidFuel('butadiene', 'flue_gas');
Butadiene.setDuration(100);
Butadiene.setAmountToBurn(160);
Butadiene.setByproductAmount(600);

def Propane = new IFluidFuel('propane', 'flue_gas');
Propane.setDuration(90);
Propane.setAmountToBurn(160);
Propane.setByproductAmount(500);

def Butane = new IFluidFuel('butane', 'flue_gas');
Butane.setDuration(95);
Butane.setAmountToBurn(160);
Butane.setByproductAmount(500);

def Toluene = new IFluidFuel('toluene', 'flue_gas');
Toluene.setDuration(160);
Toluene.setAmountToBurn(10);
Toluene.setByproductAmount(1000);

def WoodGas = new IFluidFuel('wood_gas', 'flue_gas');
WoodGas.setDuration(80);
WoodGas.setAmountToBurn(160);
WoodGas.setByproductAmount(750);

def CoalGas = new IFluidFuel('coal_gas', 'flue_gas');
CoalGas.setDuration(90);
CoalGas.setAmountToBurn(160);
CoalGas.setByproductAmount(750);

def Syngas = new IFluidFuel('syngas', 'flue_gas');
Syngas.setDuration(200);
Syngas.setAmountToBurn(160);
Syngas.setByproductAmount(1500);

def Ethylene = new IFluidFuel('ethylene', 'flue_gas');
Ethylene.setDuration(85);
Ethylene.setAmountToBurn(160);
Ethylene.setByproductAmount(500);

def Ammonia = new IFluidFuel('ammonia', 'nitrogen');
Ammonia.setDuration(70);
Ammonia.setAmountToBurn(160);
Ammonia.setByproductAmount(500);

def Propene = new IFluidFuel('propene', 'flue_gas');
Propene.setDuration(85);
Propene.setAmountToBurn(160);
Propene.setByproductAmount(500);

def Butene = new IFluidFuel('butene', 'flue_gas');
Butene.setDuration(90);
Butene.setAmountToBurn(160);
Butene.setByproductAmount(500);

def Phenol = new IFluidFuel('phenol', 'flue_gas');
Phenol.setDuration(120);
Phenol.setAmountToBurn(10);
Phenol.setByproductAmount(750);

def Benzene = new IFluidFuel('benzene', 'flue_gas');
Benzene.setDuration(120);
Benzene.setAmountToBurn(10);
Benzene.setByproductAmount(750);

def Hydrogen = new IFluidFuel('hydrogen', "steam")
Hydrogen.setDuration(10);
Hydrogen.setAmountToBurn(160);
Hydrogen.setByproductAmount(80);

def Methanol = new IFluidFuel('methanol', 'flue_gas');
Methanol.setDuration(40);
Methanol.setAmountToBurn(10);
Methanol.setByproductAmount(1000);
Methanol.setIsRefinedFuel(true);

def Ethanol = new IFluidFuel('ethanol', 'flue_gas');
Ethanol.setDuration(48);
Ethanol.setAmountToBurn(10);
Ethanol.setByproductAmount(1200);
Ethanol.setIsRefinedFuel(true);

def LiquidNaturalGas = new IFluidFuel('liquid_natural_gas', 'flue_gas');
LiquidNaturalGas.setDuration(120);
LiquidNaturalGas.setAmountToBurn(10);
LiquidNaturalGas.setByproductAmount(1250);
LiquidNaturalGas.setIsRefinedFuel(true);

def FuelOil = new IFluidFuel('fuel_oil', 'flue_gas');
FuelOil.setDuration(150);
FuelOil.setAmountToBurn(10);
FuelOil.setByproductAmount(2000);
FuelOil.setIsRefinedFuel(true);

def BioDiesel = new IFluidFuel('bio_diesel', 'flue_gas');
BioDiesel.setDuration(75);
BioDiesel.setAmountToBurn(10);
BioDiesel.setByproductAmount(1500);
BioDiesel.setIsRefinedFuel(true);

def Diesel = new IFluidFuel('diesel', 'flue_gas');
Diesel.setDuration(100);
Diesel.setAmountToBurn(10);
Diesel.setByproductAmount(2000);
Diesel.setIsRefinedFuel(true);

def MidgradeDiesel = new IFluidFuel('midgrade_diesel', 'flue_gas');
MidgradeDiesel.setDuration(150);
MidgradeDiesel.setAmountToBurn(10);
MidgradeDiesel.setByproductAmount(3000);
MidgradeDiesel.setIsRefinedFuel(true);

def PremiumDiesel = new IFluidFuel('premium_diesel', 'flue_gas');
PremiumDiesel.setDuration(200);
PremiumDiesel.setAmountToBurn(10);
PremiumDiesel.setByproductAmount(4000);
PremiumDiesel.setIsRefinedFuel(true);

def SupremeDiesel = new IFluidFuel('supreme_diesel', 'flue_gas');
SupremeDiesel.setDuration(250);
SupremeDiesel.setAmountToBurn(10);
SupremeDiesel.setByproductAmount(5000);
SupremeDiesel.setIsRefinedFuel(true);

def Gasoline = new IFluidFuel('gasoline', 'flue_gas');
Gasoline.setDuration(100);
Gasoline.setAmountToBurn(10);
Gasoline.setByproductAmount(2000);
Gasoline.setIsRefinedFuel(true);

def MidgradeGasoline = new IFluidFuel('midgrade_gasoline', 'flue_gas');
MidgradeGasoline.setDuration(150);
MidgradeGasoline.setAmountToBurn(10);
MidgradeGasoline.setByproductAmount(3000);
MidgradeGasoline.setIsRefinedFuel(true);

def PremiumGasoline = new IFluidFuel('premium_gasoline', 'flue_gas');
PremiumGasoline.setDuration(200);
PremiumGasoline.setAmountToBurn(10);
PremiumGasoline.setByproductAmount(4000);
PremiumGasoline.setIsRefinedFuel(true);

def SupremeGasoline = new IFluidFuel('supreme_gasoline', 'flue_gas');
SupremeGasoline.setDuration(250);
SupremeGasoline.setAmountToBurn(10);
SupremeGasoline.setByproductAmount(5000);
SupremeGasoline.setIsRefinedFuel(true);

def Kerosene = new IFluidFuel('kerosene', 'flue_gas');
Kerosene.setDuration(100);
Kerosene.setAmountToBurn(10);
Kerosene.setByproductAmount(1000);
Kerosene.setIsRefinedFuel(true);

def MidgradeKerosene = new IFluidFuel('midgrade_kerosene', 'flue_gas');
MidgradeKerosene.setDuration(150);
MidgradeKerosene.setAmountToBurn(10);
MidgradeKerosene.setByproductAmount(3000);
MidgradeKerosene.setIsRefinedFuel(true);

def PremiumKerosene = new IFluidFuel('premium_kerosene', 'flue_gas');
PremiumKerosene.setDuration(200);
PremiumKerosene.setAmountToBurn(10);
PremiumKerosene.setByproductAmount(4000);
PremiumKerosene.setIsRefinedFuel(true);

def SupremeKerosene = new IFluidFuel('supreme_kerosene', 'flue_gas');
SupremeKerosene.setDuration(250);
SupremeKerosene.setAmountToBurn(10);
SupremeKerosene.setByproductAmount(5000);
SupremeKerosene.setIsRefinedFuel(true);

def FluidFuels = [
        NaturalGas,
        Methane,
        Ethane,
        Butadiene,
        Propane,
        Butane,
        Toluene,
        WoodGas,
        CoalGas,
        Syngas,
        Ethylene,
        Ammonia,
        Propene,
        Butene,
        Phenol,
        Benzene,
        Hydrogen,
        Methanol,
        Ethanol,
        LiquidNaturalGas,
        FuelOil,
        BioDiesel,
        Diesel,
        MidgradeDiesel,
        PremiumDiesel,
        SupremeDiesel,
        Gasoline,
        MidgradeGasoline,
        PremiumGasoline,
        SupremeGasoline,
        Kerosene,
        MidgradeKerosene,
        PremiumKerosene,
        SupremeKerosene
];

def WaterWF = new IWorkingFluid('water', 'steam', 'exhaust_steam');
WaterWF.setDuration(10);
WaterWF.setAmountToUse(6);
WaterWF.setEfficiency(1);
WaterWF.setConversionFactor(160);

def WorkingFluids = [
        WaterWF
];

for (FluidFuel in FluidFuels) {
    if (FluidFuel.gas_turbine) {
        if (FluidFuel.refined_fuel) {
            recipemap('gas_turbine').recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                    .fluidInputs(liquid('air') * 100)
                    .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                    .duration(FluidFuel.duration)
                    .EUt(128)
                    .buildAndRegister();

            recipemap('gas_turbine').recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                    .fluidInputs(liquid('oxygen') * 20)
                    .fluidOutputs(liquid(FluidFuel.byproduct) * ((int) (FluidFuel.byproduct_amount * 1.5)))
                    .duration((int) (FluidFuel.duration * 1.5))
                    .EUt(128)
                    .buildAndRegister();
        } else {
            recipemap('gas_turbine').recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                    .fluidInputs(liquid('air') * 100)
                    .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                    .duration(FluidFuel.duration)
                    .EUt(32)
                    .buildAndRegister();

            recipemap('gas_turbine').recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                    .fluidInputs(liquid('oxygen') * 20)
                    .fluidOutputs(liquid(FluidFuel.byproduct) * ((int) (FluidFuel.byproduct_amount * 1.5)))
                    .duration((int) (FluidFuel.duration * 1.5))
                    .EUt(32)
                    .buildAndRegister();
        }

        for (lubricant in Globals.lubricants) {
            if (FluidFuel.refined_fuel) {
                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(lubricant.name) * lubricant.amount_required)
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('oxygen') * 20)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * ((int) (FluidFuel.byproduct_amount * 1.5)))
                        .duration((int) (FluidFuel.duration * lubricant.boost * 1.5))
                        .EUt(128)
                        .buildAndRegister();
            } else {
                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(lubricant.name) * lubricant.amount_required)
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('oxygen') * 20)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * ((int) (FluidFuel.byproduct_amount * 1.5)))
                        .duration((int) (FluidFuel.duration * lubricant.boost * 1.5))
                        .EUt(32)
                        .buildAndRegister();
            }
        }
    }

    //THIS IS ONLY ADDED SO THAT IT IS A VALID JETPACK FUEL
    recipemap('combustion_generator').recipeBuilder()
            .fluidInputs(liquid(FluidFuel.liquid_fuel) * 25)
            .duration(100)
            .EUt(1)
            .buildAndRegister();

    recipemap('canner').recipeBuilder()
            .fluidInputs(liquid(FluidFuel.liquid_fuel) * 500)
            .inputs(item('techguns:itemshared', 28))
            .outputs(item('techguns:itemshared', 27))
            .duration(80)
            .EUt(7)
            .buildAndRegister();
}

for (WorkingFluid in WorkingFluids) {
    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.normal_fluid) * ((WorkingFluid.amount_to_use)))
            .fluidInputs(liquid('desulfurized_flue_gas') * 500)
            .fluidOutputs(liquid(WorkingFluid.heated_fluid) * ((WorkingFluid.amount_to_use * WorkingFluid.conversion_factor)))
            .fluidOutputs(liquid('chilled_flue_gas') * 500)
            .duration((int) (WorkingFluid.duration * 0.75))
            .buildAndRegister();

    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.normal_fluid) * ((WorkingFluid.amount_to_use)))
            .fluidInputs(liquid('flue_gas') * 500)
            .fluidOutputs(liquid(WorkingFluid.heated_fluid) * ((WorkingFluid.amount_to_use * WorkingFluid.conversion_factor)))
            .fluidOutputs(liquid('chilled_flue_gas') * 500)
            .duration((int) (WorkingFluid.duration))
            .buildAndRegister();

    recipemap('steam_turbine').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .duration(WorkingFluid.duration * WorkingFluid.efficiency)
            .EUt(32)
            .buildAndRegister()

    recipemap('large_steam_turbine').recipeBuilder()
            .circuitMeta(1)
            .fluidInputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .duration(WorkingFluid.duration * WorkingFluid.efficiency)
            .EUt(32)
            .buildAndRegister()

    for (lubricant in Globals.lubricants) {
        recipemap('large_steam_turbine').recipeBuilder()
                .fluidInputs(liquid(lubricant.name) * lubricant.amount_required)
                .fluidInputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
                .fluidOutputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
                .duration((int) (WorkingFluid.duration * WorkingFluid.efficiency * lubricant.boost))
                .EUt(32)
                .buildAndRegister()
    }

    recipemap('cooling_tower').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor * 64))
            .fluidInputs(liquid('water') * 1000)
            .fluidOutputs(liquid(WorkingFluid.normal_fluid) * (WorkingFluid.amount_to_use * 64))
            .fluidOutputs(liquid('water') * 750)
            .duration(WorkingFluid.duration)
            .EUt(8)
            .buildAndRegister();

    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor * 2))
            .fluidOutputs(liquid(WorkingFluid.normal_fluid) * (WorkingFluid.amount_to_use * 2))
            .duration(WorkingFluid.duration)
            .EUt(8)
            .buildAndRegister();
}

recipemap('fluid_compressor').recipeBuilder()
        .fluidInputs(liquid('benzene') * 1280)
        .fluidOutputs(liquid('hot_hp_benzene') * 1280)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

recipemap('fluid_compressor').recipeBuilder()
        .fluidInputs(liquid('propene') * 1280)
        .fluidOutputs(liquid('hot_hp_propene') * 1280)
        .duration(100)
        .EUt(30)
        .buildAndRegister();

recipemap('fluid_compressor').recipeBuilder()
        .fluidInputs(liquid('steam') * 1000)
        .fluidOutputs(liquid('hot_hp_steam') * 400)
        .duration(80)
        .EUt(120)
        .buildAndRegister();

recipemap('heat_exchanger').recipeBuilder()
        .fluidInputs(liquid('water') * 96)
        .fluidInputs(liquid('lava') * 3)
        .fluidOutputs(liquid('steam') * 15360)
        .fluidOutputs(liquid('chilled_lava') * 3)
        .duration(10)
        .buildAndRegister();

// Supercritical fluid compression

for (scfluid in SupercriticalFluids) {
        recipemap('fluid_compressor').recipeBuilder()
            .fluidInputs(fluid(scfluid.getStartingGas()) * 1280)
            .fluidOutputs(fluid(scfluid.getSupercriticalFluid()) * 20)
            .EUt(scfluid.getPowerToCompress())
            .duration(scfluid.getDurationToCompress())
            .buildAndRegister();
}