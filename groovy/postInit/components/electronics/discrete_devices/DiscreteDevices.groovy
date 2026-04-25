import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Packaging

MIXER.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('dustSiliconDioxide') * 12)
    .inputs(ore('dustSmallCarbon'))
    .inputs(ore('dustTinyTwoMethylimidazole'))
    .inputs(ore('dustEpoxyCresolNovolacs'))
    .fluidInputs(fluid('phenolic_novolacs_resin') * 250)
    .fluidOutputs(fluid('epoxy_molding_compound') * 720)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

// Miscellaneous discrete devices

// Solenoid

crafting.addShaped("gregtech:solenoid", metaitem('component.solenoid'), [
    [ore('wireFineCopper'), ore('wireFineCopper'), ore('wireFineCopper')],
    [ore('wireFineCopper'), ore('stickSteel'), ore('wireFineCopper')],
    [ore('wireFineCopper'), ore('wireFineCopper'), ore('wireFineCopper')]
])

ASSEMBLER.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('stickSteel'))
    .inputs(ore('wireFineCopper') * 8)
    .outputs(metaitem('component.solenoid'))
    .duration(120)
    .EUt(VA[ULV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('boltPermendur'))
    .inputs(ore('wireFineEnameledCopper') * 4)
    .outputs(metaitem('component.solenoid'))
    .duration(120)
    .EUt(VA[ULV])
    .buildAndRegister()

// Relay

crafting.addShaped("gregtech:relay", metaitem('component.relay'), [
    [ore('plateSteel'), ore('wireFineCopper'), ore('wireGtSingleCopper')],
    [ore('springSmallSteel'), metaitem('component.solenoid'),  ore('boltSilver')],
    [ore('plateSteel'), ore('wireFineCopper'), ore('wireGtSingleCopper')]
])

ASSEMBLER.recipeBuilder()
    .inputs(ore('plateSteel') * 2)
    .inputs(ore('wireFineCopper') * 2)
    .inputs(ore('wireGtSingleCopper') * 2)
    .inputs(ore('springSmallSteel'))
    .inputs(ore('boltIron'))
    .inputs(ore('boltSilver'))
    .outputs(metaitem('component.relay'))
    .duration(120)
    .EUt(VA[ULV])
    .buildAndRegister()

// SMD Contacts: BeCu, Ni-plated.

FORMING_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.pin'))
    .inputs(ore('plateBerylliumCopper'))
    .outputs(metaitem('pinBerylliumCopper') * 64)
    .duration(60)
    .EUt(VA[MV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(fluid('watts_bath_electrolyte') * 1000)
    .inputs(ore('foilNickel'))
    .inputs(ore('pinBerylliumCopper') * 64)
    .outputs(metaitem('component.smd.contact') * 64)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

// Thyristor

def generateThyristorFabrication(String componentName, int circ) {

    // P doping Sandwich
    Lithography.generatePhotolithographyRecipes('wafer.silicon.n_doped', 'wafer.' + componentName + '.step_one', 'novolac_resist', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_one', 'wafer.' + componentName + '.step_two', 400, 'boron')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 1)

    // Cathode N doping
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 'novolac_resist', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 400, 'phosphorus')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 1)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_six', 'wafer.' + componentName + '.step_seven', 100) // Drive-in Process

    // Contact pad
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 'novolac_resist', 'mask_set.' + componentName, true)
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_eight', 'wafer.' + componentName + '.step_nine', 400, 'aluminium') // Aluminium Metallization
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_nine', 'wafer.' + componentName + '.step_ten', 1)
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_ten', 'wafer.' + componentName + '.step_eleven', 400, HV) // CMP for electrode contact
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_eleven', 'wafer.' + componentName, 400, true) // Passivation

}

generateThyristorFabrication('thyristor', 1)

FORMING_PRESS.recipeBuilder()
        .inputs(ore('wafer.thyristor'))
        .inputs(ore('plateMolybdenum') * 2)
        .inputs(ore('plateCopper') * 2)
        .outputs(metaitem('component.thyristor.assembly'))
        .duration(80)
        .EUt(VA[HV])
        .buildAndRegister()
    
VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('thyristor_assembly'))
    .inputs(metaitem('ceramic_casing'))
    .fluidInputs(fluid('nitrogen') * 1000)
    .outputs(metaitem('component.thyristor'))
    .EUt(VA[HV])
    .duration(200)
    .buildAndRegister()