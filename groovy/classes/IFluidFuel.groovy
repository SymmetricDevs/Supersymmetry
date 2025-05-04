package classes

class IFluidFuel{

    public String liquid_fuel;
    public String byproduct;

    public int duration;
    public int amount_to_burn;

    public int byproduct_amount = 1000;

    public boolean refined_fuel = false;
    public boolean gas_turbine = true;

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public IFluidFuel() {
        //this is needed for some reason, otherwise it will error
    }

    public IFluidFuel(String fuel_liquid, String byproduct_liquid) {
        this.liquid_fuel = fuel_liquid;
        this.byproduct = byproduct_liquid;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAmountToBurn(int amount_to_burn) {
        this.amount_to_burn = amount_to_burn;
    }

    public void setByproductAmount(int byproduct_amount) {
        this.byproduct_amount = byproduct_amount;
    }

    public void setIsRefinedFuel(boolean b) {
        this.refined_fuel = b;
    }

    public void setIsGasTurbineFuel(boolean b){
        this.gas_turbine = b;
    }
}