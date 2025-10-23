package classes

import gregtech.api.GTValues

class CryoGas {
    public String normal_gas;
    public String hot_high_pressure_gas;
    public String high_pressure_gas;
    public String cold_high_pressure_gas;
    public String liquid_gas;
    //public static ArrayList<CryoGas> cryo_gases = new ArrayList<CryoGas>();

    public int amount_to_use = 10000;

    public int EUt = GTValues.LV;
    public int duration = 20;

    public int power_heat_exchanger = 20;
    public int duration_heat_exchanger = 10;

    public int duration_radiator = 100;

    public int fluid_temperature = 300;

    public CryoGas(String gas_normal, String gas_hot_hp, String gas_hp, String gas_cold_hp, String gas_liquid) {
        normal_gas = gas_normal;
        hot_high_pressure_gas = gas_hot_hp;
        high_pressure_gas = gas_hp;
        cold_high_pressure_gas = gas_cold_hp;
        liquid_gas = gas_liquid;
    }

    public void setEUt(int power) {
        EUt = power;
    }

    public void setDuration(int time) {
        duration = time;
    }

    public void setPowerHX(int power_hx) {
        power_heat_exchanger = power_hx;
    }

    public void setDurationHX(int duration_hx) {
        duration_heat_exchanger = duration_hx;
    }

    public void setDurationRadiator(int duration_rad) {
        duration_radiator = duration_rad;
    }

    public String getGas() {
        return normal_gas;
    }

    public String getHotHPGas() {
        return hot_high_pressure_gas;
    }

    public String getHPGas() {
        return high_pressure_gas;
    }

    public String getColdHPGas() {
        return cold_high_pressure_gas;
    }

    public String getLiquidGas() {
        return liquid_gas;
    }

    public int getPowerToCompress() {
        return EUt;
    }

    public int getDurationToCompress() {
        return duration;
    }

    public void setTemperature(int temp) {
        this.fluid_temperature = temp;
    }

    public int getTemperature() {
        return this.fluid_temperature;
    }
}