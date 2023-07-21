import classes.*;
//REMOVALS

mods.gregtech.steam_turbine.removeByInput(-32, null, [fluid('steam') * 640])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('coal_gas')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('ethylene')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('natural_gas') * 8])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('refinery_gas')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('sulfuric_naphtha') * 4])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('propene')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('wood_gas') * 8])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('methane') * 2])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('butene')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('phenol')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('lpg')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('benzene')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('ethane') * 4])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('sulfuric_gas') * 32])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('propane') * 4])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('butane') * 4])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('nitrobenzene')])
mods.gregtech.gas_turbine.removeByInput(-32, null, [fluid('butadiene') * 16])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('octane') * 2])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('oil_light') * 32])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('sulfuric_light_fuel') * 4])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('ethanol')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('bio_diesel')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('methanol') * 4])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('light_fuel')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('toluene')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('naphtha')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('diesel')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('oil_medium') * 64])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('nitro_fuel') * 2])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('gasoline')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('gasoline_premium')])
mods.gregtech.combustion_generator.removeByInput(-32, null, [fluid('rocket_fuel') * 16])

def WaterCoolant = new ICoolant("water", "warm_water");
WaterCoolant.setDurationRadiator(100);
WaterCoolant.setAmountToUse(1000);
WaterCoolant.setTimeFactor(10);

def SaltWaterCoolant = new ICoolant("salt_water", "warm_salt_water");
SaltWaterCoolant.setDurationRadiator(100);
SaltWaterCoolant.setAmountToUse(1000);
SaltWaterCoolant.setTimeFactor(8);

def BrineCoolant = new ICoolant("brine", "warm_brine");
BrineCoolant.setDurationRadiator(100);
BrineCoolant.setAmountToUse(1000);
BrineCoolant.setTimeFactor(8);

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

def CryoHydrogen = new ICryoGas('hydrogen', 'hot_hp_hydrogen', 'hp_hydrogen', 'cold_hp_hydrogen', 'liquid_hydrogen', true);
CryoHydrogen.setEUt(240);
CryoHydrogen.setDuration(100);
CryoHydrogen.setPowerHX(100);
CryoHydrogen.setDurationHX(5);
CryoHydrogen.setDurationRadiator(400);
CryoHydrogen.setTemperature(14);
CryoHydrogen.setAdvancedCooling(true);

def CryoOxygen = new ICryoGas('oxygen', 'hot_hp_oxygen', 'hp_oxygen', 'cold_hp_oxygen', 'liquid_oxygen', true);
CryoOxygen.setEUt(30);
CryoOxygen.setDuration(100);
CryoOxygen.setPowerHX(100);
CryoOxygen.setDurationHX(5);
CryoOxygen.setDurationRadiator(400);
CryoOxygen.setTemperature(54);

def CryoHelium = new ICryoGas('helium', 'hot_hp_helium', 'hp_helium', 'cold_hp_helium', 'liquid_helium', true);
CryoHelium.setEUt(720);
CryoHelium.setDuration(100);
CryoHelium.setPowerHX(100);
CryoHelium.setDurationHX(5);
CryoHelium.setDurationRadiator(400);
CryoHelium.setTemperature(4);
CryoHelium.setAdvancedCooling(true);

def CryoNeon = new ICryoGas('neon', 'hot_hp_neon', 'hp_neon', 'cold_hp_neon', 'liquid_neon', true);
CryoNeon.setEUt(240);
CryoNeon.setDuration(100);
CryoNeon.setPowerHX(100);
CryoNeon.setDurationHX(5);
CryoNeon.setDurationRadiator(400);
CryoNeon.setTemperature(27);
CryoNeon.setAdvancedCooling(true);

def CryoArgon = new ICryoGas('argon', 'hot_hp_argon', 'hp_argon', 'cold_hp_argon', 'liquid_argon', true);
CryoArgon.setEUt(120);
CryoArgon.setDuration(100);
CryoArgon.setPowerHX(100);
CryoArgon.setDurationHX(5);
CryoArgon.setDurationRadiator(400);
CryoArgon.setTemperature(83);

def CryoKrypton = new ICryoGas('krypton', 'hot_hp_krypton', 'hp_krypton', 'cold_hp_krypton', 'liquid_krypton', true);
CryoKrypton.setEUt(120);
CryoKrypton.setDuration(100);
CryoKrypton.setPowerHX(100);
CryoKrypton.setDurationHX(5);
CryoKrypton.setDurationRadiator(400);
CryoKrypton.setTemperature(120);

def CryoXenon = new ICryoGas('xenon', 'hot_hp_xenon', 'hp_xenon', 'cold_hp_xenon', 'liquid_xenon', true);
CryoXenon.setEUt(120);
CryoXenon.setDuration(100);
CryoXenon.setPowerHX(100);
CryoXenon.setDurationHX(5);
CryoXenon.setDurationRadiator(400);
CryoXenon.setTemperature(165);

def CryoAir = new ICryoGas('air', 'hot_hp_air', 'hp_air', 'cold_hp_air', 'liquid_air', false);
CryoAir.setEUt(60);
CryoAir.setDuration(100);
CryoAir.setPowerHX(100);
CryoAir.setDurationHX(5);
CryoAir.setDurationRadiator(400);
CryoAir.setTemperature(80);

def CryoNitrogen = new ICryoGas('nitrogen', 'hot_hp_nitrogen', 'hp_nitrogen', 'cold_hp_nitrogen', 'liquid_nitrogen', true);
CryoNitrogen.setEUt(60);
CryoNitrogen.setDuration(100);
CryoNitrogen.setPowerHX(100);
CryoNitrogen.setDurationHX(5);
CryoNitrogen.setDurationRadiator(400);
CryoNitrogen.setTemperature(77);

def CryoNetherAir = new ICryoGas('nether_air', 'hot_hp_nether_air', 'hp_nether_air', 'cold_hp_nether_air', 'liquid_nether_air', false);
CryoNetherAir.setEUt(60);
CryoNetherAir.setDuration(100);
CryoNetherAir.setPowerHX(100);
CryoNetherAir.setDurationHX(5);
CryoNetherAir.setDurationRadiator(400);
CryoNetherAir.setTemperature(80);

def CryoRefineryGas = new ICryoGas('refinery_gas', 'hot_hp_refinery_gas', 'hp_refinery_gas', 'cold_hp_refinery_gas', 'liquid_refinery_gas', false);
CryoRefineryGas.setEUt(60);
CryoRefineryGas.setDuration(100);
CryoRefineryGas.setPowerHX(100);
CryoRefineryGas.setDurationHX(5);
CryoRefineryGas.setDurationRadiator(400);
CryoRefineryGas.setTemperature(80);

def CryoNaturalGas = new ICryoGas('natural_gas', 'hot_hp_natural_gas', 'hp_natural_gas', 'cold_hp_natural_gas', 'liquid_natural_gas', false);
CryoNaturalGas.setEUt(60);
CryoNaturalGas.setDuration(100);
CryoNaturalGas.setPowerHX(100);
CryoNaturalGas.setDurationHX(5);
CryoNaturalGas.setDurationRadiator(400);
CryoNaturalGas.setTemperature(80);

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
        CryoNetherAir,
        CryoRefineryGas,
        CryoNaturalGas
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
CarbonDioxideRefrigerant.setTimeFactor(15);

def TrichlorofluoromethaneRefrigerant = new IRefrigerant("trichlorofluoromethane", 'hot_compressed_trichlorofluoromethane', 'compressed_trichlorofluoromethane', 'cold_trichlorofluoromethane');
TrichlorofluoromethaneRefrigerant.setPowerToCompress(180);
TrichlorofluoromethaneRefrigerant.setDurationToCompress(20);
TrichlorofluoromethaneRefrigerant.setDurationRadiator(10);
TrichlorofluoromethaneRefrigerant.setAmountToUse(1000);
TrichlorofluoromethaneRefrigerant.setTimeFactor(2);

def DichlorodifluoromethaneRefrigerant = new IRefrigerant("dichlorodifluoromethane", 'hot_compressed_dichlorodifluoromethane', 'compressed_dichlorodifluoromethane', 'cold_dichlorodifluoromethane');
DichlorodifluoromethaneRefrigerant.setPowerToCompress(180);
DichlorodifluoromethaneRefrigerant.setDurationToCompress(20);
DichlorodifluoromethaneRefrigerant.setDurationRadiator(10);
DichlorodifluoromethaneRefrigerant.setAmountToUse(1000);
DichlorodifluoromethaneRefrigerant.setTimeFactor(2);

def ChlorotrifluoromethaneRefrigerant = new IRefrigerant("chlorotrifluoromethane", 'hot_compressed_chlorotrifluoromethane', 'compressed_chlorotrifluoromethane', 'cold_chlorotrifluoromethane');
ChlorotrifluoromethaneRefrigerant.setPowerToCompress(180);
ChlorotrifluoromethaneRefrigerant.setDurationToCompress(20);
ChlorotrifluoromethaneRefrigerant.setDurationRadiator(10);
ChlorotrifluoromethaneRefrigerant.setAmountToUse(1000);
ChlorotrifluoromethaneRefrigerant.setTimeFactor(2);

def ChlorodifluoromethaneRefrigerant = new IRefrigerant("chlorodifluoromethane", 'hot_compressed_chlorodifluoromethane', 'compressed_chlorodifluoromethane', 'cold_chlorodifluoromethane');
ChlorodifluoromethaneRefrigerant.setPowerToCompress(180);
ChlorodifluoromethaneRefrigerant.setDurationToCompress(20);
ChlorodifluoromethaneRefrigerant.setDurationRadiator(10);
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
            .EUt(8)
            .duration(refrigerant.duration)
            .buildAndRegister();

    //Radiative Cooling
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(refrigerant.hot_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .duration(refrigerant.duration_radiator)
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(refrigerant.hot_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .duration((int) (refrigerant.duration_radiator / 2))
            .EUt(480)
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(refrigerant.comp_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .duration((int) (refrigerant.duration_radiator / 2))
            .EUt(480)
            .buildAndRegister();
}

//Coolant recipes generation
for (coolant in Coolants) {
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * coolant.amount_to_use)
            .fluidOutputs(liquid(coolant.cold_coolant) * coolant.amount_to_use)
            .duration(coolant.duration_radiator)
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * coolant.amount_to_use)
            .fluidOutputs(liquid(coolant.cold_coolant) * coolant.amount_to_use)
            .duration((int) (coolant.duration_radiator / 2))
            .EUt(480)
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
                .duration(cryogas.duration_heat_exchanger + coolant.hx_time_factor)
                .buildAndRegister();
    }

    recipemap('fluid_compressor').recipeBuilder()
            .fluidInputs(liquid(cryogas.normal_gas) * 1280)
            .fluidOutputs(liquid(cryogas.hot_high_pressure_gas) * 1280)
            .duration(cryogas.duration)
            .EUt(cryogas.EUt)
            .buildAndRegister();

    //Radiator Cooling

    //Decompression
    recipemap('fluid_decompressor').recipeBuilder()
            .fluidInputs(liquid(cryogas.cold_high_pressure_gas) * 1280)
            .fluidOutputs(liquid(cryogas.liquid_gas) * 20)
            .duration(20)
            .EUt(8)
            .buildAndRegister();

    //Radiative Cooling
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * cryogas.amount_to_use)
            .fluidOutputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
            .duration(cryogas.duration_heat_exchanger*5)
            .buildAndRegister();

    recipemap('cooling_unit').recipeBuilder()
            .fluidInputs(liquid(cryogas.hot_high_pressure_gas) * cryogas.amount_to_use)
            .fluidOutputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
            .duration(cryogas.duration_heat_exchanger*2)
            .EUt(480)
            .buildAndRegister();

    if (!cryogas.needsAdvancedCooling) {
        recipemap('cooling_unit').recipeBuilder()
                .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
                .duration(cryogas.duration_heat_exchanger * 2)
                .EUt(480)
                .buildAndRegister();

        for (refrigerant in Refrigerants) {
            recipemap('heat_exchanger').recipeBuilder()
                    .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                    .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
                    .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
                    .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
                    .duration(cryogas.duration_heat_exchanger + refrigerant.hx_time_factor)
                    .buildAndRegister();
        }
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

def Naphtha = new IFluidFuel('naphtha', 'flue_gas');
Naphtha.setDuration(120);
Naphtha.setAmountToBurn(10);
Naphtha.setByproductAmount(1000);

def SulfuricNaphtha = new IFluidFuel('sulfuric_naphtha', 'flue_gas');
SulfuricNaphtha.setDuration(12);
SulfuricNaphtha.setAmountToBurn(8);
SulfuricNaphtha.setByproductAmount(800);

def Gasoline = new IFluidFuel('gasoline', 'flue_gas');
Gasoline.setDuration(140);
Gasoline.setAmountToBurn(10);
Gasoline.setByproductAmount(1000);
Gasoline.setIsGasoline(true);

def SulfuricGasoline = new IFluidFuel('sulfuric_gasoline', 'flue_gas');
SulfuricGasoline.setDuration(14);
SulfuricGasoline.setAmountToBurn(8);
SulfuricGasoline.setByproductAmount(80);

def Methanol = new IFluidFuel('methanol', 'flue_gas');
Methanol.setDuration(16);
Methanol.setAmountToBurn(8);
Methanol.setByproductAmount(800);

def Ethanol = new IFluidFuel('ethanol', 'flue_gas');
Ethanol.setDuration(12);
Ethanol.setAmountToBurn(8);
Ethanol.setByproductAmount(800);

def SulfuricRefineryGas = new IFluidFuel('sulfuric_refinery_gas', 'flue_gas');
SulfuricRefineryGas.setDuration(5);
SulfuricRefineryGas.setAmountToBurn(6);
SulfuricRefineryGas.setByproductAmount(600);

def SulfuricNaturalGas = new IFluidFuel('sulfuric_natural_gas', 'flue_gas');
SulfuricNaturalGas.setDuration(5);
SulfuricNaturalGas.setAmountToBurn(6);
SulfuricNaturalGas.setByproductAmount(600);

def Methane = new IFluidFuel('methane', 'flue_gas');
Methane.setDuration(21);
Methane.setAmountToBurn(6);
Methane.setByproductAmount(600);

def Ethane = new IFluidFuel('ethane', 'flue_gas');
Ethane.setDuration(40);
Ethane.setAmountToBurn(8);
Ethane.setByproductAmount(800);

def Butadiene = new IFluidFuel('butadiene', 'flue_gas');
Butadiene.setDuration(44);
Butadiene.setAmountToBurn(8);
Butadiene.setByproductAmount(800);

def Propane = new IFluidFuel('propane', 'flue_gas');
Propane.setDuration(52);
Propane.setAmountToBurn(8);
Propane.setByproductAmount(800);

def Butane = new IFluidFuel('butane', 'flue_gas');
Butane.setDuration(64);
Butane.setAmountToBurn(8);
Butane.setByproductAmount(800);

def Toluene = new IFluidFuel('toluene', 'flue_gas');
Toluene.setDuration(68);
Toluene.setAmountToBurn(8);
Toluene.setByproductAmount(800);

def NaturalGas = new IFluidFuel('natural_gas', 'flue_gas');
NaturalGas.setDuration(15);
NaturalGas.setAmountToBurn(6);
NaturalGas.setByproductAmount(600);

def Hydrogen = new IFluidFuel('hydrogen', 'steam');
Hydrogen.setDuration(120);
Hydrogen.setAmountToBurn(12);
Hydrogen.setByproductAmount(960);

def WoodGas = new IFluidFuel('wood_gas', 'flue_gas');
WoodGas.setDuration(6);
WoodGas.setAmountToBurn(8);
WoodGas.setByproductAmount(800);

def CoalGas = new IFluidFuel('coal_gas', 'flue_gas');
CoalGas.setDuration(10);
CoalGas.setAmountToBurn(6);
CoalGas.setByproductAmount(600);

def Ethylene = new IFluidFuel('ethylene', 'flue_gas');
Ethylene.setDuration(28);
Ethylene.setAmountToBurn(8);
Ethylene.setByproductAmount(800);

def RefineryGas = new IFluidFuel('refinery_gas', 'flue_gas');
RefineryGas.setDuration(15);
RefineryGas.setAmountToBurn(6);
RefineryGas.setByproductAmount(600);

def BioDiesel = new IFluidFuel('bio_diesel', 'flue_gas');
BioDiesel.setDuration(100);
BioDiesel.setAmountToBurn(10);
BioDiesel.setByproductAmount(1000);
BioDiesel.setIsDiesel(true);

def Kerosene = new IFluidFuel('kerosene', 'flue_gas');
Kerosene.setDuration(100);
Kerosene.setAmountToBurn(10);
Kerosene.setByproductAmount(1000);
Kerosene.setIsDiesel(true);

def SulfuricKerosene = new IFluidFuel('sulfuric_kerosene', 'flue_gas');
SulfuricKerosene.setDuration(10);
SulfuricKerosene.setAmountToBurn(8);
SulfuricKerosene.setByproductAmount(800);

def Diesel = new IFluidFuel('diesel', 'flue_gas');
Diesel.setDuration(80);
Diesel.setAmountToBurn(10);
Diesel.setByproductAmount(1000);
Diesel.setIsDiesel(true);

def SulfuricDiesel = new IFluidFuel('sulfuric_diesel', 'flue_gas');
SulfuricDiesel.setDuration(8);
SulfuricDiesel.setAmountToBurn(8);
SulfuricDiesel.setByproductAmount(800);

def FuelOil = new IFluidFuel('fuel_oil', 'flue_gas');
FuelOil.setDuration(60);
FuelOil.setAmountToBurn(10);
FuelOil.setByproductAmount(1000);
FuelOil.setIsDiesel(true);

def SulfuricFuelOil = new IFluidFuel('sulfuric_fuel_oil', 'flue_gas');
SulfuricFuelOil.setDuration(6);
SulfuricFuelOil.setAmountToBurn(8);
SulfuricFuelOil.setByproductAmount(800);

def Syngas = new IFluidFuel('syngas', 'flue_gas');
Syngas.setDuration(10);
Syngas.setAmountToBurn(8);
Syngas.setByproductAmount(800);

def MidgradeGasoline = new IFluidFuel('midgrade_gasoline', 'flue_gas');
MidgradeGasoline.setDuration(500);
MidgradeGasoline.setAmountToBurn(10);
MidgradeGasoline.setByproductAmount(1000);
MidgradeGasoline.setIsGasoline(true);

def PremiumGasoline = new IFluidFuel('premium_gasoline', 'flue_gas');
PremiumGasoline.setDuration(750);
PremiumGasoline.setAmountToBurn(10);
PremiumGasoline.setByproductAmount(1000);
PremiumGasoline.setIsGasoline(true);

def SupremeGasoline = new IFluidFuel('supreme_gasoline', 'flue_gas');
SupremeGasoline.setDuration(1000);
SupremeGasoline.setAmountToBurn(10);
SupremeGasoline.setByproductAmount(1000);
SupremeGasoline.setIsGasoline(true);

def Ammonia = new IFluidFuel('ammonia', 'flue_gas');
Ammonia.setDuration(32);
Ammonia.setAmountToBurn(6);
Ammonia.setByproductAmount(600);

def Propene = new IFluidFuel('propene', 'flue_gas');
Propene.setDuration(48);
Propene.setAmountToBurn(8);
Propene.setByproductAmount(800);

def Butene = new IFluidFuel('butene', 'flue_gas');
Butene.setDuration(64);
Butene.setAmountToBurn(8);
Butene.setByproductAmount(800);

def Phenol = new IFluidFuel('phenol', 'flue_gas');
Phenol.setDuration(42);
Phenol.setAmountToBurn(6);
Phenol.setByproductAmount(600);

def Benzene = new IFluidFuel('benzene', 'flue_gas');
Benzene.setDuration(72);
Benzene.setAmountToBurn(8);
Benzene.setByproductAmount(800);

def NitroFuel = new IFluidFuel('nitro_fuel', 'flue_gas');
NitroFuel.setDuration(400);
NitroFuel.setAmountToBurn(10);
NitroFuel.setByproductAmount(1000);
NitroFuel.setIsDiesel(true);

def Oil = new IFluidFuel('oil', 'flue_gas');
Oil.setDuration(15);
Oil.setAmountToBurn(48);
Oil.setByproductAmount(4800);
Oil.setIsDiesel(true);

def LightOil = new IFluidFuel('oil_light', 'flue_gas');
LightOil.setDuration(15);
LightOil.setAmountToBurn(24);
LightOil.setByproductAmount(2400);
LightOil.setIsDiesel(true);

def FluidFuels = [
        Naphtha,
        SulfuricNaphtha,
        Gasoline,
        SulfuricGasoline,
        Methanol,
        Ethanol,
        SulfuricRefineryGas,
        SulfuricNaturalGas,
        Methane,
        Ethane,
        Butadiene,
        Propane,
        Butane,
        Toluene,
        NaturalGas,
        Hydrogen,
        WoodGas,
        CoalGas,
        Ethylene,
        RefineryGas,
        BioDiesel,
        Kerosene,
        SulfuricKerosene,
        Diesel,
        SulfuricDiesel,
        FuelOil,
        SulfuricFuelOil,
        Syngas,
        MidgradeGasoline,
        PremiumGasoline,
        SupremeGasoline,
        Ammonia,
        Propene,
        Butene,
        Phenol,
        Benzene,
        NitroFuel,
        Oil,
        LightOil
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
        if (FluidFuel.diesel) {
                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('air') * 100)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                        .duration(FluidFuel.duration)
                        .EUt(-64)
                        .buildAndRegister();

                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('oxygen') * 25)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                        .duration((int) (FluidFuel.duration * 1.1))
                        .EUt(-64)
                        .buildAndRegister();
        } else if (FluidFuel.gasoline) {
                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('air') * 100)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                        .duration(FluidFuel.duration)
                        .EUt(-128)
                        .buildAndRegister();

                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('oxygen') * 25)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                        .duration((int) (FluidFuel.duration * 1.1))
                        .EUt(-128)
                        .buildAndRegister();
        } else {
                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('air') * 100)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                        .duration(FluidFuel.duration)
                        .EUt(-32)
                        .buildAndRegister();

                recipemap('gas_turbine').recipeBuilder()
                        .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                        .fluidInputs(liquid('oxygen') * 25)
                        .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                        .duration((int) (FluidFuel.duration * 1.1))
                        .EUt(-32)
                        .buildAndRegister();
        }
                
    }

    recipemap('flare_stack').recipeBuilder()
            .fluidInputs(liquid(FluidFuel.liquid_fuel) * 1000)
            .duration(30)
            .EUt(7)
            .buildAndRegister();

    //THIS IS ONLY ADDED SO THAT IT IS A VALID JETPACK FUEL
    recipemap('combustion_generator').recipeBuilder()
            .fluidInputs(liquid(FluidFuel.liquid_fuel) * 25)
            .duration(100)
            .EUt(-1)
            .buildAndRegister();

    recipemap('canner').recipeBuilder()
            .fluidInputs(liquid(FluidFuel.liquid_fuel) * 500)
            .inputs(item('techguns:itemshared', 28))
            .outputs(item('techguns:itemshared', 27))
            .duration(80)
            .EUt(7)
            .buildAndRegister();
}

recipemap('flare_stack').recipeBuilder()
        .fluidInputs(liquid('creosote') * 100)
        .duration(30)
        .EUt(7)
        .buildAndRegister();

for (WorkingFluid in WorkingFluids) {
    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.normal_fluid) * (WorkingFluid.amount_to_use))
            .fluidInputs(liquid('desulfurized_flue_gas')*1000)
            .fluidOutputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid('chilled_flue_gas') * 1000)
            .duration(WorkingFluid.duration)
            .buildAndRegister();

    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.normal_fluid) * (WorkingFluid.amount_to_use))
            .fluidInputs(liquid('flue_gas')*1000)
            .fluidOutputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid('chilled_flue_gas') * 1000)
            .duration(WorkingFluid.duration)
            .buildAndRegister();

    recipemap('steam_turbine').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .duration(WorkingFluid.duration * WorkingFluid.efficiency)
            .EUt(32)
            .buildAndRegister();

    recipemap('cooling_tower').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidInputs(liquid('water') * 1000)
            .fluidOutputs(liquid(WorkingFluid.normal_fluid) * WorkingFluid.amount_to_use)
            .fluidOutputs(liquid('water') * 750)
            .duration((int) (WorkingFluid.duration / 10))
            .EUt(8)
            .buildAndRegister();

    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid(WorkingFluid.normal_fluid) * WorkingFluid.amount_to_use)
            .duration(WorkingFluid.duration)
            .EUt(8)
            .buildAndRegister();
}

recipemap('fluid_compressor').recipeBuilder()
        .fluidInputs(liquid('steam') * 1000)
        .fluidOutputs(liquid('hot_hp_steam') * 400)
        .duration(80)
        .EUt(120)
        .buildAndRegister();

recipemap('heat_exchanger').recipeBuilder()
        .fluidInputs(liquid('water') * 6)
        .fluidInputs(liquid('lava') * 20)
        .fluidOutputs(liquid('steam') * 960)
        .fluidOutputs(liquid('chilled_lava') * 20)
        .duration(10)
        .buildAndRegister();