import classes.*;
//TODO: CHANGE GAS TURBINE RECIPES TO OUTPUT AN AMOUNT OF FLUE GAS THAT IS PROPORTIONAL TO THE DURATION OF THE RECIPE
//REMOVALS

mods.gregtech.vacuum_freezer.removeByInput(1920, null, [fluid('nether_air') * 4000])
mods.gregtech.vacuum_freezer.removeByInput(480, null, [fluid('air') * 4000])
mods.gregtech.vacuum_freezer.removeByInput(7680, null, [fluid('ender_air') * 4000])
mods.gregtech.vacuum_freezer.removeByInput(30, null, [fluid('water') * 1000])
mods.gregtech.vacuum_freezer.removeByInput(1920, null, [fluid('oxygen') * 1000])

mods.gregtech.steam_turbine.removeByInput(-32, null, [fluid('steam') * 640])

def WaterCoolant = new ICoolant("water", "warm_water");
WaterCoolant.setDurationRadiator(100);
WaterCoolant.setAmountToUse(1000);
WaterCoolant.setTimeFactor(10);

/*
def EthyleneGlycolCoolant = ICoolant("ethylene_glycol", "warm_ethylene_glycol");
EthyleneGlycolCoolant.setDurationRadiator(50);
EthyleneGlycolCoolant.setAmountToUse(2000);
EthyleneGlycolCoolant.setTimeFactor(5);
 */

def Coolants = [
        WaterCoolant
        //EthyleneGlycolCoolant
];

def CryoHydrogen = new ICryoGas('hydrogen', 'hot_hp_hydrogen', 'hp_hydrogen', 'cold_hp_hydrogen', 'liquid_hydrogen');
CryoHydrogen.setEUt(200);
CryoHydrogen.setDuration(100);
CryoHydrogen.setPowerHX(100);
CryoHydrogen.setDurationHX(5);
CryoHydrogen.setDurationRadiator(400);
CryoHydrogen.setTemperature(20);

def CryoOxygen = new ICryoGas('oxygen', 'hot_hp_oxygen', 'hp_oxygen', 'cold_hp_oxygen', 'liquid_oxygen');
CryoOxygen.setEUt(200);
CryoOxygen.setDuration(100);
CryoOxygen.setPowerHX(100);
CryoOxygen.setDurationHX(5);
CryoOxygen.setDurationRadiator(400);
CryoOxygen.setTemperature(90);

def CryoHelium = new ICryoGas('helium', 'hot_hp_helium', 'hp_helium', 'cold_hp_helium', 'liquid_helium');
CryoHelium.setEUt(200);
CryoHelium.setDuration(100);
CryoHelium.setPowerHX(100);
CryoHelium.setDurationHX(5);
CryoHelium.setDurationRadiator(400);
CryoHelium.setTemperature(4);

def CryoNeon = new ICryoGas('neon', 'hot_hp_neon', 'hp_neon', 'cold_hp_neon', 'liquid_neon');
CryoNeon.setEUt(200);
CryoNeon.setDuration(100);
CryoNeon.setPowerHX(100);
CryoNeon.setDurationHX(5);
CryoNeon.setDurationRadiator(400);
CryoNeon.setTemperature(27);

def CryoArgon = new ICryoGas('argon', 'hot_hp_argon', 'hp_argon', 'cold_hp_argon', 'liquid_argon');
CryoArgon.setEUt(200);
CryoArgon.setDuration(100);
CryoArgon.setPowerHX(100);
CryoArgon.setDurationHX(5);
CryoArgon.setDurationRadiator(400);
CryoArgon.setTemperature(87);

def CryoKrypton = new ICryoGas('krypton', 'hot_hp_krypton', 'hp_krypton', 'cold_hp_krypton', 'liquid_krypton');
CryoKrypton.setEUt(200);
CryoKrypton.setDuration(100);
CryoKrypton.setPowerHX(100);
CryoKrypton.setDurationHX(5);
CryoKrypton.setDurationRadiator(400);
CryoKrypton.setTemperature(120);

def CryoXenon = new ICryoGas('xenon', 'hot_hp_xenon', 'hp_xenon', 'cold_hp_xenon', 'liquid_xenon');
CryoXenon.setEUt(200);
CryoXenon.setDuration(100);
CryoXenon.setPowerHX(100);
CryoXenon.setDurationHX(5);
CryoXenon.setDurationRadiator(400);
CryoXenon.setTemperature(165);

def CryoAir = new ICryoGas('air', 'hot_hp_air', 'hp_air', 'cold_hp_air', 'liquid_air');
CryoAir.setEUt(60);
CryoAir.setDuration(100);
CryoAir.setPowerHX(100);
CryoAir.setDurationHX(5);
CryoAir.setDurationRadiator(400);
CryoAir.setTemperature(80);

def CryoNitrogen = new ICryoGas('nitrogen', 'hot_hp_nitrogen', 'hp_nitrogen', 'cold_hp_nitrogen', 'liquid_nitrogen');
CryoNitrogen.setEUt(200);
CryoNitrogen.setDuration(100);
CryoNitrogen.setPowerHX(100);
CryoNitrogen.setDurationHX(5);
CryoNitrogen.setDurationRadiator(400);
CryoNitrogen.setTemperature(77);

def CryoNetherAir = new ICryoGas('nether_air', 'hot_hp_nether_air', 'hp_nether_air', 'cold_hp_nether_air', 'liquid_nether_air');
CryoNetherAir.setEUt(60);
CryoNetherAir.setDuration(100);
CryoNetherAir.setPowerHX(100);
CryoNetherAir.setDurationHX(5);
CryoNetherAir.setDurationRadiator(400);
CryoNetherAir.setTemperature(80);

def CryoRefineryGas = new ICryoGas('refinery_gas', 'hot_hp_refinery_gas', 'hp_refinery_gas', 'cold_hp_refinery_gas', 'liquid_refinery_gas');
CryoRefineryGas.setEUt(60);
CryoRefineryGas.setDuration(100);
CryoRefineryGas.setPowerHX(100);
CryoRefineryGas.setDurationHX(5);
CryoRefineryGas.setDurationRadiator(400);
CryoRefineryGas.setTemperature(80);

def CryoNaturalGas = new ICryoGas('natural_gas', 'hot_hp_natural_gas', 'hp_natural_gas', 'cold_hp_natural_gas', 'liquid_natural_gas');
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
AmmoniaRefrigerant.setPowerToCompress(500);
AmmoniaRefrigerant.setDurationToCompress(20);
AmmoniaRefrigerant.setDurationRadiator(20);
AmmoniaRefrigerant.setAmountToUse(1000);
AmmoniaRefrigerant.setTimeFactor(5);

def PropaneRefrigerant = new IRefrigerant('propane', 'hot_compressed_propane', 'compressed_propane', 'cold_propane');
PropaneRefrigerant.setPowerToCompress(200);
PropaneRefrigerant.setDurationToCompress(30);
PropaneRefrigerant.setDurationRadiator(10);
PropaneRefrigerant.setAmountToUse(2000);
PropaneRefrigerant.setTimeFactor(10);

def CarbonDioxideRefrigerant = new IRefrigerant('carbon_dioxide', 'hot_compressed_carbon_dioxide', 'compressed_carbon_dioxide', 'cold_carbon_dioxide');
CarbonDioxideRefrigerant.setPowerToCompress(60);
CarbonDioxideRefrigerant.setDurationToCompress(60);
CarbonDioxideRefrigerant.setDurationRadiator(10);
CarbonDioxideRefrigerant.setAmountToUse(3000);
CarbonDioxideRefrigerant.setTimeFactor(10);

def Refrigerants = [
        AmmoniaRefrigerant,
        PropaneRefrigerant,
        CarbonDioxideRefrigerant
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
            .EUt(8)
            .buildAndRegister();

}

//Coolant recipes generation
for (coolant in Coolants) {
    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(coolant.warm_coolant) * coolant.amount_to_use)
            .fluidOutputs(liquid(coolant.cold_coolant) * coolant.amount_to_use)
            .duration(coolant.duration_radiator)
            .EUt(8)
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
                .EUt(cryogas.power_heat_exchanger)
                .buildAndRegister();
    }
    for (refrigerant in Refrigerants) {
        recipemap('heat_exchanger').recipeBuilder()
                .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
                .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
                .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
                .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
                .duration(cryogas.duration_heat_exchanger + refrigerant.hx_time_factor)
                .EUt(cryogas.power_heat_exchanger)
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
            .EUt(8)
            .buildAndRegister();
}

//Water cooling
for (refrigerant in Refrigerants) {
    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid('water') * 1000)
            .fluidInputs(liquid(refrigerant.cold_refrigerant) * refrigerant.amount_to_use)
            .fluidOutputs(liquid('ice') * 1000)
            .fluidOutputs(liquid(refrigerant.normal_refrigerant) * refrigerant.amount_to_use)
            .duration(60)
            .EUt(8)
            .buildAndRegister();
}

def Gasoline = new IFluidFuel('gasoline', 'flue_gas');
Gasoline.setDuration(136);
Gasoline.setAmountToBurn(8 * 40);
Gasoline.setByproductAmount(1000);

def SulfuricGas = new IFluidFuel('sulfuric_gas', 'flue_gas');
SulfuricGas.setDuration(26);
SulfuricGas.setAmountToBurn(32 * 40);
SulfuricGas.setByproductAmount(1000);

def Methane = new IFluidFuel('methane', 'flue_gas');
Methane.setDuration(14);
Methane.setAmountToBurn(4 * 40);
Methane.setByproductAmount(1000);

def Ethane = new IFluidFuel('ethane', 'flue_gas');
Ethane.setDuration(22);
Ethane.setAmountToBurn(4 * 40);
Ethane.setByproductAmount(1000);

def Butadiene = new IFluidFuel('butadiene', 'flue_gas');
Butadiene.setDuration(104);
Butadiene.setAmountToBurn(16 * 40);
Butadiene.setByproductAmount(1000);

def Propane = new IFluidFuel('propane', 'flue_gas');
Propane.setDuration(30);
Propane.setAmountToBurn(4 * 40);
Propane.setByproductAmount(1000);

def Butane = new IFluidFuel('butane', 'flue_gas');
Butane.setDuration(38);
Butane.setAmountToBurn(4 * 40);
Butane.setByproductAmount(1000);

def LPG = new IFluidFuel('lpg', 'flue_gas');
LPG.setDuration(10);
LPG.setAmountToBurn(1 * 40);
LPG.setByproductAmount(1000);

def Naphtha = new IFluidFuel('naphtha', 'flue_gas');
Naphtha.setDuration(10);
Naphtha.setAmountToBurn(1 * 40);
Naphtha.setByproductAmount(1000);

def Toluene = new IFluidFuel('toluene', 'flue_gas');
Toluene.setDuration(42);
Toluene.setAmountToBurn(4 * 40);
Toluene.setByproductAmount(1000);

def NaturalGas = new IFluidFuel('natural_gas', 'flue_gas');
NaturalGas.setDuration(14);
NaturalGas.setAmountToBurn(20 * 40);
NaturalGas.setByproductAmount(1000);

def Hydrogen = new IFluidFuel('hydrogen', 'exhaust_steam');
Hydrogen.setDuration(2);
Hydrogen.setAmountToBurn(20 * 40);
Hydrogen.setByproductAmount(1600);

def CarbonMonoxide = new IFluidFuel('carbon_monoxide', 'flue_gas');
CarbonMonoxide.setDuration(16);
CarbonMonoxide.setAmountToBurn(20 * 40);
CarbonMonoxide.setByproductAmount(1000);

def WoodGas = new IFluidFuel('wood_gas', 'flue_gas');
WoodGas.setDuration(16);
WoodGas.setAmountToBurn(20 * 40);
WoodGas.setByproductAmount(1000);

def SulfuricNaphtha = new IFluidFuel('sulfuric_naphtha', 'flue_gas');
SulfuricNaphtha.setDuration(10);
SulfuricNaphtha.setAmountToBurn(8 * 40);
SulfuricNaphtha.setByproductAmount(1000);

def Ethylene = new IFluidFuel('ethylene', 'flue_gas');
Ethylene.setDuration(20);
Ethylene.setAmountToBurn(5 * 40);
Ethylene.setByproductAmount(1000);

def RefineryGas = new IFluidFuel('refinery_gas', 'flue_gas');
RefineryGas.setDuration(10);
RefineryGas.setAmountToBurn(2 * 40);
RefineryGas.setByproductAmount(1000);

def Propene = new IFluidFuel('propene', 'flue_gas');
Propene.setDuration(60);
Propene.setAmountToBurn(10 * 40);
Propene.setByproductAmount(1000);

def Butene = new IFluidFuel('butene', 'flue_gas');
Butene.setDuration(80);
Butene.setAmountToBurn(10 * 40);
Butene.setByproductAmount(1000);

def Phenol = new IFluidFuel('phenol', 'flue_gas');
Phenol.setDuration(90);
Phenol.setAmountToBurn(10 * 40);
Phenol.setByproductAmount(1000);

def Benzene = new IFluidFuel('benzene', 'flue_gas');
Benzene.setDuration(90);
Benzene.setAmountToBurn(10 * 40);
Benzene.setByproductAmount(1000);

def NitroDiesel = new IFluidFuel('nitro_fuel', 'flue_gas');
NitroDiesel.setDuration(46);
NitroDiesel.setAmountToBurn(2 * 40);
NitroDiesel.setByproductAmount(1000);
NitroDiesel.setIsDiesel(true);

def BioDiesel = new IFluidFuel('bio_diesel', 'flue_gas');
BioDiesel.setDuration(14);
BioDiesel.setAmountToBurn(2 * 40);
BioDiesel.setByproductAmount(1000);
BioDiesel.setIsDiesel(true);

def Kerosene = new IFluidFuel('kerosene', 'flue_gas');
Kerosene.setDuration(16);
Kerosene.setAmountToBurn(1 * 40);
Kerosene.setByproductAmount(1000);
Kerosene.setIsDiesel(true);

def Diesel = new IFluidFuel('diesel', 'flue_gas');
Diesel.setDuration(18);
Diesel.setAmountToBurn(1 * 40);
Diesel.setByproductAmount(1000);
Diesel.setIsDiesel(true);

def FuelOil = new IFluidFuel('fuel_oil', 'flue_gas');
FuelOil.setDuration(20);
FuelOil.setAmountToBurn(1 * 40);
FuelOil.setByproductAmount(1000);
FuelOil.setIsDiesel(true);

def Syngas = new IFluidFuel('syngas', 'flue_gas');
Syngas.setDuration(10);
Syngas.setAmountToBurn(4 * 40);
Syngas.setByproductAmount(1000);

def FluidFuels = [
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
        NitroDiesel,
        BioDiesel,
        Diesel,
        Syngas,
        FuelOil,
        Kerosene
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
    if(FluidFuel.gas_turbine){
        recipemap('gas_turbine_new').recipeBuilder()
                .fluidInputs(liquid(FluidFuel.liquid_fuel) * FluidFuel.amount_to_burn)
                .fluidInputs(liquid('air') * 1000)
                .fluidOutputs(liquid(FluidFuel.byproduct) * FluidFuel.byproduct_amount)
                .duration(FluidFuel.duration)
                .EUt(-32)
                .buildAndRegister();
    }
}

for (WorkingFluid in WorkingFluids) {
    recipemap('heat_exchanger').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.normal_fluid) * WorkingFluid.amount_to_use)
            .fluidInputs(liquid('flue_gas')*1000)
            .fluidOutputs(liquid(WorkingFluid.heated_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .duration(WorkingFluid.duration)
            .EUt(8)
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
            .duration(WorkingFluid.duration)
            .EUt(8)
            .buildAndRegister();

    recipemap('radiator').recipeBuilder()
            .fluidInputs(liquid(WorkingFluid.leftover_fluid) * (WorkingFluid.amount_to_use * WorkingFluid.conversion_factor))
            .fluidOutputs(liquid(WorkingFluid.normal_fluid) * WorkingFluid.amount_to_use)
            .duration(WorkingFluid.duration*8)
            .EUt(8)
            .buildAndRegister();
}
