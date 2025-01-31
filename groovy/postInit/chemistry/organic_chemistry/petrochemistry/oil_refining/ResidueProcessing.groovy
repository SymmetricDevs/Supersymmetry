import globals.Globals
import static globals.Petrochemistry.*

VACUUM_DT = recipemap('vacuum_distillation')
CRYSTALLIZER = recipemap('crystallizer')
EXTRACTOR = recipemap('extractor')
MIXER = recipemap('mixer')
PHASE_SEPARATOR = recipemap('phase_separator')
ROTARY_KILN = recipemap('rotary_kiln')

// Atmospheric residue processing

VACUUM_DT.recipeBuilder()
    .fluidInputs(fluid('atmospheric_oil_residue') * 1000)
    .fluidOutputs(fluid('vacuum_oil_residue') * 1000)
    .fluidOutputs(fluid('crude_lubricating_oil') * 300)
    .fluidOutputs(fractions.heavy_gas_oil.getSulfuric(250))
    .fluidOutputs(fractions.light_gas_oil.getSulfuric(150))
    .circuitMeta(1)
    .duration(100)
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

// Deasphalting

MIXER.recipeBuilder()
    .fluidInputs(fluid('vacuum_oil_residue') * 300)
    .fluidInputs(fluid('supercritical_propane') * 300)
    .fluidOutputs(fluid('asphaltene_extract') * 300)
    .fluidOutputs(fluid('deasphalted_oil') * 250)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('asphaltene_extract') * 300)
    .outputs(metaitem('dustAsphalt') * 4)
    .fluidOutputs(fluid('supercritical_propane') * 300)
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

// Carbon black production

def residues = [
    'atmospheric_oil_residue',
    'vacuum_oil_residue',
    'visbreaking_residue',
    'deasphalted_oil',
    'clarified_slurry_oil'
]

for (residue in residues) {
    ROTARY_KILN.recipeBuilder()
        .fluidInputs(fluid(residue) * 1000)
        .fluidInputs(fluid('natural_gas') * 10)
        .fluidInputs(fluid('oxygen') * 20)
        .outputs(metaitem('dustCarbonBlack') * 30)
        .fluidOutputs(fluid('flue_gas') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

    ROTARY_KILN.recipeBuilder()
        .fluidInputs(fluid(residue) * 1000)
        .fluidInputs(fluid('methane') * 35)
        .fluidInputs(fluid('oxygen') * 70)
        .outputs(metaitem('dustCarbonBlack') * 30)
        .fluidOutputs(fluid('carbon_dioxide') * 10000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()
}

oreDict.add('dyeBlack', metaitem('dustCarbonBlack'))