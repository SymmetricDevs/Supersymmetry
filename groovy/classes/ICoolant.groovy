package classes

class ICoolant{

    public String cold_coolant = "";
    public String warm_coolant = "";

    public int duration_radiator = 200;
    public int amount_to_use = 1000;
    public int hx_time_factor = 10;

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public ICoolant() {
        //this is needed for some reason, otherwise it will error
    }

    public ICoolant(String coolant_normal, String coolant_warm){
        this.cold_coolant = coolant_normal;
        this.warm_coolant = coolant_warm;
    }

    public void setDurationRadiator(int time) {
        this.duration_radiator = time;
    }

    public void setAmountToUse(int amount) {
        this.amount_to_use = amount;
    }

    public void setTimeFactor(int time) {
        this.hx_time_factor = time;
    }

    public int getTimeFactor() {
        return hx_time_factor;
    }

    public String getCoolant() {
        return cold_coolant;
    }

    public String getWarmCoolant() {
        return warm_coolant;
    }
}