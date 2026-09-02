import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType
import globals.semiconductors.Lithography
import globals.semiconductors.Doping
import globals.semiconductors.Deposition
import globals.semiconductors.Mechanicals

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

// P doping sandwich
Lithography.generatePhotolithographyRecipes('wafer.silicon.n_doped', 'wafer.thyristor.step_one', 'novolac_resist', 'mask_set.thyristor', true)
Doping.generateIonImplantationRecipes('wafer.thyristor.step_one', 'wafer.thyristor.step_two', 400, 'boron')
Lithography.generateResistStrippingRecipes('wafer.thyristor.step_two', 'wafer.thyristor.step_three', 1, false, true)

// Cathode N doping
Lithography.generatePhotolithographyRecipes('wafer.thyristor.step_three', 'wafer.thyristor.step_four', 'novolac_resist', 'mask_set.thyristor', true)
Doping.generateIonImplantationRecipes('wafer.thyristor.step_four', 'wafer.thyristor.step_five', 400, 'phosphorus')
Lithography.generateResistStrippingRecipes('wafer.thyristor.step_five', 'wafer.thyristor.step_six', 1, false, true)
Doping.generateDriveInRecipe('wafer.thyristor.step_six', 'wafer.thyristor.step_seven', 100) // Drive-in Process

// Contact pad
Lithography.generatePhotolithographyRecipes('wafer.thyristor.step_seven', 'wafer.thyristor.step_eight', 'novolac_liftoff_resist', 'mask_set.thyristor', false)
Deposition.generateSputteringRecipe('wafer.thyristor.step_eight', 'wafer.thyristor.step_nine', 400, 'aluminium') // Aluminium metallization & liftoff
Lithography.generateResistStrippingRecipes('wafer.thyristor.step_nine', 'wafer.thyristor.step_ten', 1, false, true)
Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.thyristor.step_ten', 'wafer.thyristor.step_eleven', 'silicon_dioxide', 400, HV) // CMP for electrode contact
Deposition.generateSiliconDioxideGrowthRecipe('wafer.thyristor.step_eleven', 'wafer.thyristor', 400, true) // Passivation

FORMING_PRESS.recipeBuilder()
    .inputs(metaitem('wafer.thyristor'))
    .inputs(ore('plateMolybdenum') * 2)
    .inputs(ore('plateCopper') * 2)
    .outputs(metaitem('component.thyristor.assembly'))
    .duration(80)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.thyristor.assembly'))
    .inputs(metaitem('ceramic_casing'))
    .fluidInputs(fluid('nitrogen') * 1000)
    .outputs(metaitem('component.thyristor'))
    .duration(200)
    .EUt(VA[MV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()