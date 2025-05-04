package classes

class IQuenchingFluid{

    public String hot_fluid = "";
    public String cold_fluid = "";
    public int amount;
    public float time;
    public boolean inert;
    public boolean has_recipe;
    public static ArrayList<IQuenchingFluid> quenching_fluids = new ArrayList<IQuenchingFluid>();

    public static void main(String[] args){
        //this is needed for some reason, otherwise it will error
    }

    public IQuenchingFluid() {
        //this is needed for some reason, otherwise it will error
    }

    public IQuenchingFluid(String ColdFluid2, String HotFluid2, int amount, float time, boolean inert){
        this.cold_fluid = ColdFluid2;
        this.hot_fluid = HotFluid2;
        this.amount = amount;
        this.time = time;
        this.inert = inert;
        quenching_fluids.add(this);
    }

    public String getColdFluid(){
        return this.cold_fluid;
    }

    public String getHotFluid(){
        return this.hot_fluid;
    }

    public float getDuration(){
        return this.time;
    }

    public boolean isInert(){
        return this.inert;
    }
}