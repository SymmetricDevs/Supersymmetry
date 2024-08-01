import petrochemistry.Petrochemistry

CRACKER = recipemap('cracker')
DT = recipemap('distillation_tower')
COKING = recipemap('coking_tower')

/* Thermal Cracking
    // Single Stage
        CRACKER.recipeBuilder()
            .fluidInputs(fluid('atmospheric_oil_residue') * 1000)
            .fluidOutputs(fluid('thermally_cracked_atmospheric_oil_residue') * 1000)
            .duration(200)
            .EUt(Globals.voltAmps[3] * 2)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('thermally_cracked_atmospheric_oil_residue') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fluid('crude_light_gas_oil'))
            .fluidOutputs(fluid('crude_naphtha'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

    // Two Stage
        CRACKER.recipeBuilder()
            .fluidInputs(fluid('cracked_heavy_gas_oil') * 1000)
            .fluidOutputs(fluid('doubly_cracked_heavy_gas_oil') * 1000)
            .duration(200)
            .EUt(Globals.voltAmps[3] * 2)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('thermally_cracked_atmospheric_oil_residue') * 1000)
            .fluidInputs(fluid('doubly_cracked_heavy_gas_oil') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fluid('crude_light_gas_oil'))
            .fluidOutputs(fluid('crude_naphtha'))
            .fluidOutputs(fluid('sulfuric_refinery_gas'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()
*/

/* Visbreaking
    // Single Stage
        CRACKER.recipeBuilder()
            .fluidInputs(fluid('vacuum_oil_residue') * 1000)
            .fluidOutputs(fluid('thermally_cracked_vacuum_oil_residue') * 1000)
            .duration(200)
            .EUt(Globals.voltAmps[3] * 2)
            .buildAndRegister()
        
        MIXER.recipeBuilder()
            .fluidInputs(fluid('thermally_cracked_vacuum_oil_residue') * 1000)
            .fluidInputs(fluid('vacuum_oil_residue') * 1000)
            .fluidOutputs(fluid('quenched_vacuum_oil_residue') * 2000)
            .duration(40)
            .EUt(30)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('quenched_vacuum_oil_residue') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fluid('crude_light_gas_oil'))
            .fluidOutputs(fluid('crude_naphtha'))
            .fluidOutputs(fluid('sulfuric_refinery_gas'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

    // Two Stage
        DT.recipeBuilder()
            .fluidInputs(fluid('quenched_vacuum_oil_residue') * 1000)
            .fluidInputs(fluid('doubly_cracked_heavy_gas_oil') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fluid('crude_light_gas_oil'))
            .fluidOutputs(fluid('crude_naphtha'))
            .fluidOutputs(fluid('sulfuric_refinery_gas'))
            .duration(400)
            .EUt(30)
            .buildAndRegister()
*/

// Coking