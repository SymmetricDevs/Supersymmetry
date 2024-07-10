import petrochemistry.Petrochemistry

VACUUM_DT = recipemap('vacuum_distillation')
CRYSTALLIZER = recipemap('crystallizer')
EXTRACTOR = recipemap('extractor')
MIXER = recipemap('mixer')
CENTRIFUGE = recipemap('centrifuge')
ROTARY_KILN = recipemap('rotary_kiln')
COKING = recipemap('coking_tower')

// Sulfuric Oil Residue Processing

    // Solvent Dewaxing
    VACUUM_DT.recipeBuilder()
        .fluidInputs(fluid('sulfuric_oil_residue') * 1000)
        .outputs(metaitem('bituminous_residue'))
        .fluidOutputs(fluid('crude_lubricating_oil') * 850)
        .fluidOutputs(fractions.fuel_oil.getSulfuric(200))
        .fluidOutputs(fractions.diesel.getSulfuric(200))
        .fluidOutputs(fractions.kerosene.getSulfuric(150))
        .fluidOutputs(fractions.naphtha.getSulfuric(100))
        .duration(300)
        .EUt(30)
        .buildAndRegister()

// Slack wax Processing

CRYSTALLIZER.recipeBuilder()
.fluidInputs(fluid('slack_wax') * 1000)
.fluidOutputs(fluid('lubricating_oil') * 250)
.outputs(metaitem('paraffin_wax') * 4)
.duration(300)
.EUt(30)
.buildAndRegister()

crafting.addShaped("treated_wood_planks_paraffin", item('gregtech:planks', 1) * 8, [
    [ore('plankWood'),ore('plankWood'),ore('plankWood')],
    [ore('plankWood'),metaitem('paraffin_wax'),ore('plankWood')],
    [ore('plankWood'),ore('plankWood'),ore('plankWood')]
])

EXTRACTOR.recipeBuilder()
.inputs(metaitem('paraffin_wax'))
.circuitMeta(1)
.fluidOutputs(fluid('lubricating_oil') * 250)
.duration(100)
.EUt(30)
.buildAndRegister()

EXTRACTOR.recipeBuilder()
.inputs(metaitem('paraffin_wax'))
.circuitMeta(2)
.fluidOutputs(fluid('resin') * 1000)
.duration(100)
.EUt(30)
.buildAndRegister()

// Bituminous Residue Processing

MIXER.recipeBuilder()
.fluidInputs(fluid('oil') * 500)
.inputs(metaitem('bitumen'))
.fluidOutputs(fluid('bitumen_solution') * 1000)
.duration(100)
.EUt(Globals.voltAmps[1])
.buildAndRegister()

CENTRIFUGE.recipeBuilder()
.fluidInputs(fluid('bitumen_solution') * 1000)
.fluidOutputs(fluid('oil') * 650)
.outputs(metaitem('dustAsphalt') * 4)
.duration(150)
.EUt(Globals.voltAmps[0])
.buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('oil_light') * 500)
        .inputs(metaitem('bitumen'))
        .fluidOutputs(fluid('light_bitumen_solution') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('light_bitumen_solution') * 1000)
        .fluidOutputs(fluid('oil_light') * 650)
        .outputs(metaitem('dustAsphalt') * 4)
        .duration(150)
        .EUt(Globals.voltAmps[0])
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('oil_heavy') * 500)
        .inputs(metaitem('bitumen'))
        .fluidOutputs(fluid('heavy_bitumen_solution') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('heavy_bitumen_solution') * 1000)
        .fluidOutputs(fluid('oil_heavy') * 650)
        .outputs(metaitem('dustAsphalt') * 4)
        .duration(150)
        .EUt(Globals.voltAmps[0])
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustAsphalt'))
        .fluidInputs(fluid('concrete') * 144)
        .outputs(item('gregtech:asphalt') * 2)
        .duration(30)
        .EUt(16)
        .buildAndRegister()

// Bituminous Residue -> Coke

COKING.recipeBuilder()
.fluidInputs(fluid('steam') * 1000)
.inputs(metaitem('bituminous_residue'))
.fluidOutputs(fluid('sulfuric_oil_residue') * 150)
.outputs(metaitem('dustGreenCoke') * 4)
.duration(300)
.EUt(Globals.voltAmps[1] * 2)
.buildAndRegister()

for (fuel in sintering_fuels) {
    if (!fuel.isPlasma) {
        for (comburent in sintering_comburents) {
            ROTARY_KILN.recipeBuilder()
                    .inputs(ore('dustGreenCoke'))
                    .outputs(metaitem('dustCoke'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(60)
                    .buildAndRegister()

            ROTARY_KILN.recipeBuilder()
                    .inputs(metaitem('bituminous_residue'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('bitumen'))
                    .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(60)
                    .buildAndRegister()
        }
    }
}