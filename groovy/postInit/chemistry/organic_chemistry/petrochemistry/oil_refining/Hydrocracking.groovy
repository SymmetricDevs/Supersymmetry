import petrochemistry.Petrochemistry
CRACKER = recipemap('cracker')

crackables.each { _, crackable -> {
    if (crackable.hydro_crackable) {

        CRACKER.recipeBuilder()
            .fluidInputs(crackable.get(1000))
            .fluidInputs(fluid('hot_hp_steam') * 1000)
            .fluidOutputs(crackable.getSteam(1000))
            .duration(80)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()  
        
    }
}}