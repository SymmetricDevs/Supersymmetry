import globals.Globals
import static globals.Petrochemistry.*

BCR = recipemap("bubble_column_reactor")
CRACKER = recipemap("cracker")
ROASTER = recipemap("roaster")
DT = recipemap("sieve_distillation")
ELECTROSTATIC_SEPARATOR = recipemap('electrostatic_separator')

/* Data:
- Slurry oil: 40 carbons
- Catalytic overheads: 1.825 carbons
*/

// Standard FCC

crackables.each { _, crackable -> 
    if (crackable.catalytic_crackable) {
        CRACKER.recipeBuilder()
            .fluidInputs(crackable.get(4000))
            .inputs(metaitem('cracking_catalyst'))
            .fluidOutputs(crackable.getCrudeCatalyticallyCracked(4000))
            .duration(200)
            .EUt(Globals.voltAmps[1] * 2)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(crackable.getCrudeCatalyticallyCracked(4000))
            .fluidInputs(fluid('dense_steam') * 400)
            .fluidOutputs(crackable.getCatalyticallyCracked(4000))
            .chancedOutput(metaitem('spent_cracking_catalyst'), 9000, 0)
            .duration(200)
            .EUt(Globals.voltAmps[1])
            .buildAndRegister()
    }
}

ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 1000)
    .inputs(metaitem('spent_cracking_catalyst'))
    .fluidOutputs(fluid('flue_gas') * 1000)
    .outputs(metaitem('cracking_catalyst'))
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('catalytically_cracked_heavy_gas_oil') * 1000)
    .fluidOutputs(fractions.light_cycle_oil.get(355))
    .fluidOutputs(fractions.naphtha.get(2015))
    .fluidOutputs(fluid('catalytic_overheads') * 1580)
    .duration(50)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('catalytically_cracked_atmospheric_oil_residue') * 1000)
    .fluidOutputs(fluid('slurry_oil') * 500)
    .fluidOutputs(fractions.light_cycle_oil.getSulfuric(575))
    .fluidOutputs(fractions.naphtha.getCrude(1690))
    .fluidOutputs(fluid('sulfuric_catalytic_overheads') * 1180)
    .duration(50)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('catalytically_cracked_vacuum_oil_residue') * 1000)
    .fluidOutputs(fluid('slurry_oil') * 680)
    .fluidOutputs(fractions.light_cycle_oil.getSulfuric(680))
    .fluidOutputs(fractions.naphtha.getCrude(1195))
    .fluidOutputs(fluid('sulfuric_catalytic_overheads') * 1092)
    .duration(50)
    .EUt(Globals.voltAmps[1] * 2)
    .buildAndRegister()

ELECTROSTATIC_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('slurry_oil') * 1000)
    .fluidOutputs(fluid('clarified_slurry_oil') * 1000)
    .chancedOutput(metaitem('spent_cracking_catalyst'), 1000, 0)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()