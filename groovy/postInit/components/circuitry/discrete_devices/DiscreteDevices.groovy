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

    // Relay

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