import petrochemistry.Petrochemistry

CRACKER = recipemap('cracker')
DT = recipemap('distillation_tower')
COKING = recipemap('coking_tower')
TUBE_FURNACE = recipemap('tube_furnace')
FLBR = recipemap('fluidized_bed_reactors')
PHASE_SEPARATOR = recipemap('phase_separator')

// Thermal Cracking
crackables.each { _, crackable -> {
        if crackable.thermal_crackable {
            ROASTER.recipeBuilder()
                .fluidInputs(crackable.get(1000))
                .fluidOutputs(crackable.getThermallyCracked(700))
                .duration(400)
                .EUt(Globals.voltAmps[3])
                .buildAndRegister()

            CRACKER.recipeBuilder()
                .fluidInputs(crackable.get(1000))
                .fluidOutputs(crackable.getThermallyCracked(1000))
                .duration(200)
                .EUt(Globals.voltAmps[3] * 2)
                .buildAndRegister()

            // Visbreaking
            MIXER.recipeBuilder()
                .fluidInputs(crackable.getThermallyCracked(250))
                .fluidInputs(crackable.get(600))
                .fluidInputs(fractions.heavy_gas_oil.getCrude(150))
                .fluidOutputs(crackable.getQuenched(1000))
                .duration(40)
                .EUt(30)
                .buildAndRegister()
        }
    }
}

// Visbreaking Separation 
        DT.recipeBuilder()
            .fluidInputs(crackables.atmospheric_oil_residue.getQuenched(1000))
            .fluidOutputs(fluid('visbreaking_residue') * 570)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(150))
            .fluidOutputs(fractions.light_gas_oil.getCrude(260))
            .fluidOutputs(fractions.naphtha.getCrude(370))
            .fluidOutputs(fractions.refinery_gas.getSulfuric(300))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(crackables.atmospheric_oil_residue.getQuenched(1000))
            .fluidOutputs(fluid('visbreaking_residue') * 650)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(150))
            .fluidOutputs(fractions.light_gas_oil.getCrude(320))
            .fluidOutputs(fractions.naphtha.getCrude(320))
            .fluidOutputs(fractions.refinery_gas.getSulfuric(260))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

/* Coking
    // Delayed Coking
        VACUUM_DT.recipeBuilder()
            .fluidInputs(crackables.atmospheric_oil_residue.get(1000))
            .fluidOutputs(fluid('coking_residue'))
            .fluidOutputs(fractions.heavy_gas_oil.getCrude())
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(400)
            .EUt(30)
            .buildAndRegister()

        VACUUM_DT.recipeBuilder()
            .fluidInputs(fluid('slurry_oil') * 1000)
            .fluidOutputs(fluid('coking_residue'))
            .fluidOutputs(fractions.heavy_gas_oil.getCrude())
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(400)
            .EUt(30)
            .buildAndRegister()

        TUBE_FURNACE.recipeBuilder()
            .fluidInputs(fluid('coking_residue') * 1000)
            .fluidOutputs(fluid('heated_coking_residue') * 1000)
            .duration(400)
            .EUt(480)
            .buildAndRegister()

        COKER.recipeBuilder()
            .fluidInputs(fluid('heated_coking_residue') * 1000)
            .fluidInputs(fluid('water'))
            .outputs(metaitem('dustGreenCoke') * 32)
            .duration(400)
            .EUt(30)
            .buildAndRegister()
            
    // Fluid Coking
        FLBR.recipeBuilder()
            .fluidInputs(crackables.vacuum_oil_residue.getSulfuric(1000))
            .inputs(ore('dustHeatedGreenCoke'))
            .fluidOutputs(fluid('coke_fines'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

        FLBR.recipeBuilder()
            .fluidInputs(fluid('slurry_oil') * 1000)
            .inputs(ore('dustHeatedGreenCoke'))
            .fluidOutputs(fluid('coke_fines'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

        PHASE_SEPARATOR.recipeBuilder()
            .fluidInputs(fluid('coke_fines'))
            .outputs(metaitem('dustGreenCoke'))
            .fluidOutputs(fluid('fluid_cracked_vacuum_oil_residue'))
            .duration(20)
            .buildAndRegister()

        TUBE_FURNACE.recipeBuilder()
            .inputs(ore('dustGreenCoke'))
            .outputs(ore('dustHeatedGreenCoke'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('fluid_cracked_vacuum_oil_residue') * 1000)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude())
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(200)
            .EUt(30)
            .buildAndRegister()

    // Flexicoking
        PYROLYSE_OVEN.recipeBuilder()
            .inputs(ore('dustGreenCoke'))
            .outputs(ore('dustHeatedGreenCoke'))
            .fluidOutputs(fluid('syngas'))
            .duration(200)
            .EUt(30)
            .buildAndRegister()
*/