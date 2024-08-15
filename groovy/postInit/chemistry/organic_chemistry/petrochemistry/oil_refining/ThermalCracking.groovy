import petrochemistry.Petrochemistry

CRACKER = recipemap('cracker')
DT = recipemap('distillation_tower')
COKING = recipemap('coking_tower')
TUBE_FURNACE = recipemap('tube_furnace')
FLBR = recipemap('fluidized_bed_reactors')
PHASE_SEPARATOR = recipemap('phase_separator')

/*fractions.each { _, fraction -> {
        if fraction.thermal_crackable {
            CRACKER.recipeBuilder()
                .fluidInputs(fraction.get(1000))
                .fluidOutputs(fraction.getThermallyCracked(1000))
                .duration(200)
                .EUt(Globals.voltAmps[3] * 2)
                .buildAndRegister()
        }
    }
}*/

/* Thermal Cracking
    // Single Stage
        DT.recipeBuilder()
            .fluidInputs(fractions.atmospheric_oil_residue.getThermallyCracked(1000))
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(200)
            .EUt(30)
            .buildAndRegister()

    // Two Stage
        CRACKER.recipeBuilder()
            .fluidInputs(fractions.heavy_gas_oil.getThermallyCracked(1000))
            .fluidOutputs(fluid('doubly_cracked_heavy_gas_oil') * 1000)
            .duration(200)
            .EUt(Globals.voltAmps[3] * 2)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('thermally_cracked_atmospheric_oil_residue') * 1000)
            .fluidInputs(fluid('doubly_cracked_heavy_gas_oil') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(200)
            .EUt(30)
            .buildAndRegister()
*/

/* Visbreaking
    // Single Stage  
        MIXER.recipeBuilder()
            .fluidInputs(fractions.vacuum_oil_residue.getThermallyCracked(1000))
            .fluidInputs(fractions.vacuum_oil_residue.get(1000))
            .fluidOutputs(fluid('quenched_vacuum_oil_residue') * 2000)
            .duration(40)
            .EUt(30)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('quenched_vacuum_oil_residue') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(200)
            .EUt(30)
            .buildAndRegister()

    // Two Stage
        DT.recipeBuilder()
            .fluidInputs(fluid('quenched_vacuum_oil_residue') * 1000)
            .fluidInputs(fluid('doubly_cracked_heavy_gas_oil') * 1000)
            .fluidOutputs(fluid('thermal_cracking_residue'))
            .fluidOutputs(fluid('cracked_heavy_gas_oil'))
            .fluidOutputs(fractions.light_gas_oil.getCrude())
            .fluidOutputs(fractions.naphtha.getCrude())
            .fluidOutputs(fractions.refinery_gas.getSulfuric())
            .duration(200)
            .EUt(30)
            .buildAndRegister()
*/

/* Coking
    // Delayed Coking
        VACUUM_DT.recipeBuilder()
            .fluidInputs(fractions.atmospheric_oil_residue.get(1000))
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
            .fluidInputs(fractions.vacuum_oil_residue.get(1000))
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