package classes

class IRefrigerant{

    String normal_refrigerant;
    String hot_refrigerant;
    String comp_refrigerant;
    String cold_refrigerant;

    int EUt = 30;
    int duration = 20;

    int duration_radiator = 20;
    int amount_to_use = 1000;

    int hx_time_factor = 10;

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public IRefrigerant() {
        //this is needed for some reason, otherwise it will error
    }

    public IRefrigerant(String refrigerant_normal, String refrigerant_hot, String refrigerant_comp, String refrigerant_cold) {
        normal_refrigerant = refrigerant_normal;
        hot_refrigerant = refrigerant_hot;
        comp_refrigerant = refrigerant_comp;
        cold_refrigerant = refrigerant_cold;
    }

    public void setPowerToCompress(int power) {
        EUt = power;
    }

    public void setDurationToCompress(int time) {
        duration = time;
    }

    public void setDurationRadiator(int time) {
        duration_radiator = time;
    }

    public void setAmountToUse(int amount) {
        amount_to_use = amount;
    }

    public void setTimeFactor(int time) {
        hx_time_factor = time;
    }

    public int getTimeFactor() {
        return hx_time_factor;
    }

    public String getColdRefrigerant() {
        return cold_refrigerant;
    }

    public String getRefrigerant() {
        return normal_refrigerant;
    }

    public String getHotRefrigerant() {
        return hot_refrigerant;
    }

    public String getCompRefrigerant() {
        return comp_refrigerant;
    }
}