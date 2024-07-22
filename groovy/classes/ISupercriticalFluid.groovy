package classes

class ISupercriticalFluid {
    public String supercritical_fluid;
    public String starting_gas;
    public int critical_temp;

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public ISupercriticalFluid() {
        //this is needed for some reason, otherwise it will error
    }

    public ISupercriticalFluid(String starting_gas, String supercritical_fluid) {
        super.starting_gas = starting_gas;
        this.supercritical_fluid = supercritical_fluid
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

    public void setEUt(int power) {
        EUt = power;
    }

    public void setDuration(int time) {
        duration = time;
    }
}