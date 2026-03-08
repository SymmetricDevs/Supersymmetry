import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Packaging

MIXER.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('dustSiliconDioxide') * 12)
    .inputs(ore('dustSmallCarbon'))
    .inputs(ore('dustTinyTwoMethylimidazole'))
    .fluidInputs(fluid('epoxy_cresol_novolacs') * 144)
    .fluidInputs(fluid('phenolic_novolac_resin') * 250)
    .fluidOutputs(fluid('epoxy_molding_compound') * 720)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister();

// Miscellaneous discrete devices

    // Solenoid

    crafting.addShaped("gregtech:solenoid", metaitem('component.solenoid'), [
        [ore('wireFineCopper'), ore('wireFineCopper'), ore('wireFineCopper')],
        [ore('wireFineCopper'), ore('stickSteel'), ore('wireFineCopper')],
        [ore('wireFineCopper'), ore('wireFineCopper'), ore('wireFineCopper')]])

    ASSEMBLER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('stickSteel'))
        .inputs(ore('wireFineCopper') * 8)
        .outputs(metaitem('component.solenoid'))
        .duration(120)
        .EUt(VA[ULV])
        .buildAndRegister();

    ASSEMBLER.recipeBuilder()
        .inputs(ore('boltPermendur'))
        .inputs(ore('wireFineEnamelledCopper') * 4)
        .outputs(metaitem('component.solenoid'))
        .duration(120)
        .EUt(VA[ULV])
        .buildAndRegister();

    // Relay

    crafting.addShaped("gregtech:relay", metaitem('component.relay'), [
        [ore('plateSteel'), ore('wireFineCopper'), ore('wireGtSingleCopper')],
        [ore('springSmallSteel'), metaitem('component.solenoid'),  ore('boltSilver')],
        [ore('plateSteel'), ore('wireFineCopper'), , ore('wireGtSingleCopper')]])

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
        .buildAndRegister();

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
    .inputs(inputs(ore('pinBerylliumCopper') * 64))
    .outputs(metaitem('component.smd.contact') * 64)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()