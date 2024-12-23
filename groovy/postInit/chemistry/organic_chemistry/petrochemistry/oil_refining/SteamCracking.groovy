import globals.Globals
import static globals.Petrochemistry.*

ROASTER = recipemap('roaster')
CRACKER = recipemap('cracker')
DT = recipemap('sieve_distillation')

crackables.each { _, crackable -> 
    if (crackable.steam_crackable) {

        ROASTER.recipeBuilder()
            .fluidInputs(crackable.get(1000))
            .fluidInputs(fluid('hot_hp_steam') * 1000)
            .fluidOutputs(crackable.getSteam(700))
            .duration(300)
            .EUt(Globals.voltAmps[1])
            .buildAndRegister()

        CRACKER.recipeBuilder()
            .fluidInputs(crackable.get(1000))
            .fluidInputs(fluid('hot_hp_steam') * 1000)
            .fluidOutputs(crackable.getSteam(1000))
            .duration(80)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()  
        
    }
}

/* ASSUMPTIONS:
- Pyrolysis gas: 7 carbons per mol
- Light gas oil: 12 carbons per mol
- Heavy gas oil: 16.5 carbons per mol
- Light naphtha: 5.5 carbons per mol
- Heavy naphtha: 9 carbons per mol */

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_ethane') * 1000)
    .fluidOutputs(fluid('ethylene') * 890)
    .fluidOutputs(fluid('methane') * 220)
    .fluidOutputs(fluid('hydrogen') * 3330)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_propane') * 1000)
    .fluidOutputs(fluid('pyrolysis_gasoline') * 30)
    .fluidOutputs(fluid('butadiene') * 40)
    .fluidOutputs(fluid('propene') * 210)
    .fluidOutputs(fluid('ethylene') * 660)
    .fluidOutputs(fluid('methane') * 680)
    .fluidOutputs(fluid('hydrogen') * 1845)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_butane') * 1000)
    .fluidOutputs(fluid('pyrolysis_gasoline') * 45)
    .fluidOutputs(fluid('butadiene') * 45)
    .fluidOutputs(fluid('butene') * 65)
    .fluidOutputs(fluid('propene') * 220)
    .fluidOutputs(fluid('ethylene') * 820)
    .fluidOutputs(fluid('methane') * 945)
    .fluidOutputs(fluid('hydrogen') * 2310)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_light_naphtha') * 1000)
    .fluidOutputs(fluid('light_gas_oil') * 25)
    .fluidOutputs(fluid('pyrolysis_gasoline') * 185)
    .fluidOutputs(fluid('butadiene') * 70)
    .fluidOutputs(fluid('butene') * 45)
    .fluidOutputs(fluid('propene') * 300)
    .fluidOutputs(fluid('ethylene') * 860)
    .fluidOutputs(fluid('methane') * 825)
    .fluidOutputs(fluid('hydrogen') * 2320)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_heavy_naphtha') * 1000)
    .fluidOutputs(fluid('light_gas_oil') * 30)
    .fluidOutputs(fluid('pyrolysis_gasoline') * 310)
    .fluidOutputs(fluid('butadiene') * 155)
    .fluidOutputs(fluid('butene') * 125)
    .fluidOutputs(fluid('propene') * 500)
    .fluidOutputs(fluid('ethylene') * 1350)
    .fluidOutputs(fluid('methane') * 1150)
    .fluidOutputs(fluid('hydrogen') * 2585)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_light_gas_oil') * 1000)
    .fluidOutputs(fluid('light_gas_oil') * 235)
    .fluidOutputs(fluid('pyrolysis_gasoline') * 295)
    .fluidOutputs(fluid('butadiene') * 175)
    .fluidOutputs(fluid('butene') * 115)
    .fluidOutputs(fluid('propene') * 615)
    .fluidOutputs(fluid('ethylene') * 1410)
    .fluidOutputs(fluid('methane') * 1290)
    .fluidOutputs(fluid('hydrogen') * 1730)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('steamcracked_heavy_gas_oil') * 1000)
    .fluidOutputs(fluid('light_gas_oil') * 355)
    .fluidOutputs(fluid('pyrolysis_gasoline') * 565)
    .fluidOutputs(fluid('butadiene') * 175)
    .fluidOutputs(fluid('butene') * 250)
    .fluidOutputs(fluid('propene') * 780)
    .fluidOutputs(fluid('ethylene') * 1560)
    .fluidOutputs(fluid('methane') * 1125)
    .fluidOutputs(fluid('hydrogen') * 2265)
    .duration(160)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()