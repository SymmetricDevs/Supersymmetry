import petrochemistry.Petrochemistry

BCR = recipemap("bubble_column_reactor")
CRACKER = recipemap("cracker")
ROASTER = recipemap("roaster")
DT = recipemap("distillation_tower")

// Standard FCC

/*fractions.each { _, fraction -> {
        if (fraction.isUpgradable) {
            CRACKER.recipeBuilder()
                .fluidInputs(fraction.get(1000))
                .inputs(metaitem('cracking_catalyst'))
                .fluidOutputs(fraction.getCatalyticallyCrackedMix(1000))
                .duration(200)
                .EUt(Globals.voltAmps[1] * 2)
                .buildAndRegister()

            BCR.recipeBuilder()
                .fluidInputs(fraction.getCatalyticallyCrackedMix(500))
                .fluidInputs(fluid('dense_steam') * 50)
                .fluidOutputs(fraction.getCatalyticallyCracked(500))
                .outputs(metaitem('spent_cracking_catalyst'))
                .duration(100)
                .EUt(Globals.voltAmps[1])
                .buildAndRegister()
        }
    }
}

ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 1000)
    .inputs(metaitem('spent_cracking_catalyst') * 4)
    .fluidOutputs(fluid('flue_gas') * 1000)
    .outputs(metaitem('cracking_catalyst') * 4)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('catalytically_cracked_heavy_gas_oil') * 1000)
    .fluidOutputs(fluid('cycle_oil')* 100)
    .fluidOutputs(fluid('catalytic_gasoline') * 500)
    .fluidOutputs(fluid('butene') * 100)
    .fluidOutputs(fluid('lpg') * 100)
    .fluidOutputs(fluid('propylene') * 100)
    .fluidOutputs(fluid('ethylene') * 100)
    .duration(200)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('catalytically_cracked_atmospheric_oil_residue') * 1000)
    .fluidOutputs(fluid('slurry_oil') * 100)
    .fluidOutputs(fluid('cycle_oil')* 200)
    .fluidOutputs(fluid('catalytic_gasoline') * 400)
    .fluidOutputs(fluid('butene') * 75)
    .fluidOutputs(fluid('propylene') * 75)
    .fluidOutputs(fluid('ethylene') * 50)
    .fluidOutputs(fluid('lpg') * 100)
    .duration(200)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('catalytically_cracked_vacuum_oil_residue') * 1000)
    .fluidOutputs(fluid('slurry_oil') * 150)
    .fluidOutputs(fluid('cycle_oil')* 250)
    .fluidOutputs(fluid('catalytic_gasoline') * 300)
    .fluidOutputs(fluid('butene') * 75)
    .fluidOutputs(fluid('propylene') * 75)
    .fluidOutputs(fluid('ethylene') * 50)
    .fluidOutputs(fluid('lpg') * 100)
    .duration(200)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()