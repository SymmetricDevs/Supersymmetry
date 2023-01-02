package classes

class IWorkingFluid{

    public String normal_fluid;
    public String heated_fluid;
    public String leftover_fluid;

    public int duration;
    public int amount_to_use;

    public int conversion_factor = 160;

    public int efficiency = 1;

    public int temp;

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public IWorkingFluid() {
        //this is needed for some reason, otherwise it will error
    }

    public IWorkingFluid(String fluid_normal, String fluid_heated, String fluid_leftover) {
        this.normal_fluid = fluid_normal;
        this.heated_fluid = fluid_heated;
        this.leftover_fluid = fluid_leftover;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmountToUse(int amount_to_use) {
        this.amount_to_use = amount_to_use;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public void setConversionFactor(int conversion_factor) {
        this.conversion_factor = conversion_factor;
    }

    public String getHeatedFluid() {
        return this.heated_fluid;
    }

    public String getNormalFluid() {
        return this.normal_fluid;
    }

    public String getLeftOver() {
        return this.leftover_fluid;
    }
}