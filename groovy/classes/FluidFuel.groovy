package classes

class FluidFuel{
    public String liquid_fuel;

    public int duration;
    public int fuel_amount;
    public int flue_amount;

    public boolean gaseous = false;
    public boolean fuel_cell = false;


    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public FluidFuel() {
        //this is needed for some reason, otherwise it will error
    }

    public FluidFuel(String fuel_liquid) {
        this.liquid_fuel = fuel_liquid;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFuelAmount(int fuel_amount) {
        this.fuel_amount = fuel_amount;
    }

    public void setFlueAmount(int flue_amount) {
        this.flue_amount = flue_amount;
    }

    public void setGaseous(boolean b) {
        this.gaseous = b;
    }

    public void setIsFuelCellFuel(boolean b) {
        this.fuel_cell = b;
    }
}