package classes

class OreRock{
    public String input_rock;
    public String input_fluid;
    public String output_fluid;
    public int starting_tier;
    public def ore_lists;

    public OreRock(String rock, String inputFluid, String outputFluid, def oreLists, int startingTier) {
        this.input_rock = rock;
        this.input_fluid = inputFluid;
        this.output_fluid = outputFluid;
        this.ore_lists = oreLists;
        this.starting_tier = startingTier;
    }

    public String getFluidIn() {
        return this.input_fluid;
    }

    public String getFluidOut() {
        return this.output_fluid;
    }

    public String getRock() {
        return this.rock;
    }

    public int getStartingTier() {
        return starting_tier;
    }

    public def getOreLists() {
        return ore_lists;
    }
}