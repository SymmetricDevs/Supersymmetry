package classes

class ISupercriticalFluid {

    public String supercritical_fluid;
    public String starting_gas;
    public int critical_temp;
    public int EUt;
    public int duration;

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public ISupercriticalFluid() {
        //this is needed for some reason, otherwise it will error
    }

    public ISupercriticalFluid(String gas_starting, String fluid_supercritical) {
        this.starting_gas = gas_starting;
        this.supercritical_fluid = fluid_supercritical;
    }

    public String getSupercriticalFluid() {
        return supercritical_fluid;
    }

    public String getStartingGas() {
        return starting_gas;
    }

    public int getCriticalTemperature() {
        return critical_temp;
    }

    public int getPowerToCompress() {
        return EUt;
    }

    public int getDurationToCompress() {
        return duration;
    }

    public void setCriticalTemperature(int temp){
        critical_temp = temp;
    }

    public void setPowerToCompress(int power) {
        EUt = power;
    }

    public void setDurationToCompress(int time) {
        duration = time;
    }
}