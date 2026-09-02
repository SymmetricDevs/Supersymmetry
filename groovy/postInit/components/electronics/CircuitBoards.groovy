import globals.Globals
import globals.semiconductors.Etching

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.metatileentity.multiblock.CleanroomType

mods.jei.ingredient.yeet(
    metaitem('board.coated'),
    metaitem('board.plastic'),
    metaitem('board.epoxy'),
    metaitem('board.fiber_reinforced'),
    metaitem('circuit_board.plastic'),
    metaitem('circuit_board.advanced'),
    metaitem('circuit_board.extreme')
)

// LV circuit board

crafting.removeByOutput(metaitem('circuit_board.basic'))
mods.gregtech.assembler.removeByInput(7, [metaitem('foilCopper') * 4, metaitem('plateWood')], [fluid('glue') * 100])

crafting.addShaped("lv_board", metaitem('circuit_board.basic'), [
    [ore('foilCopper'), ore('foilCopper'), ore('foilCopper')],
    [metaitem('rubber_drop'), metaitem('rubber_drop'), metaitem('rubber_drop')],
    [ore('craftingToolKnife'), metaitem('plateTreatedWood'), null]
]);

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('plateTreatedWood'))
    .inputs(metaitem('foilCopper') * 2)
    .fluidInputs(fluid('glue') * 100)
    .outputs(metaitem('circuit_board.basic'))
    .circuitMeta(1)
    .duration(30)
    .EUt(VA[ULV])
    .buildAndRegister();

// MV circuit board

crafting.removeByOutput(metaitem('circuit_board.good'))
mods.gregtech.assembler.removeByInput(30, [metaitem('dustWood'), metaitem('circuit.integrated').withNbt(['Configuration': 1])], [fluid('glue') * 50])

CHEMICAL_BATH.recipeBuilder()
    .inputs(ore('paper'))
    .inputs(ore('dustSmallHexamethylenetetramine'))
    .fluidInputs(fluid('phenolic_novolacs_oligomer') * 100)
    .outputs(metaitem('board.phenolic'))
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister();

FORMING_PRESS.recipeBuilder()
    .inputs(metaitem('board.phenolic'))
    .inputs(metaitem('foilCopper'))
    .outputs(metaitem('laminated.board.phenolic'))
    .duration(40)
    .EUt(VA[LV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('laminated.board.phenolic'))
    .notConsumable(metaitem('toolHeadDrillSteel'))
    .outputs(metaitem('patterned.board.phenolic'))
    .duration(60)
    .EUt(VA[MV])
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('patterned.board.phenolic'))
    .inputs(metaitem('foilCopper'))
    .fluidInputs(fluid('glue') * 50)
    .outputs(metaitem('circuit_board.good'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

// Roughly follows https://medium.com/@raypcb/how-are-fr4-pcbs-manufactured-c571fd1e4a29

// Epoxy Prepreg 
// (in Epoxy Chain)

// Titanium Cylinder Drum

FORMING_PRESS.recipeBuilder()
    .notConsumable(metaitem('shape.mold.cylinder'))
    .inputs(ore('ingotTitanium') * 8)
    .outputs(metaitem('titanium_cylinder') * 1)
    .EUt(VA[MV])
    .duration(320)
    .buildAndRegister();

// ED Copper Foil

ELECTROLYTIC_CELL.recipeBuilder()
    .notConsumable(metaitem('titanium_cylinder'))
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('copper_sulfate_solution') * 1000)
    .outputs(metaitem('foilHighPurityCopper') * 4)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister();

// HV Board

    // CCopper lamination

    FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.g10.prepreg'))
        .inputs(ore('foilHighPurityCopper'))
        .outputs(metaitem('board.g10.copper_clad'))
        .EUt(VA[MV])
        .duration(50)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Patterning

    FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.g10.copper_clad'))
        .inputs(metaitem('dry_film_photoresist'))
        .outputs(metaitem('board.g10.resist'))
        .EUt(VA[MV])
        .duration(50)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    UV_LIGHT_BOX.recipeBuilder()
        .inputs(metaitem('board.g10.resist'))
        .notConsumable(metaitem('mask.pcb'))
        .outputs(metaitem('board.g10.patterned'))
        .duration(50)
        .EUt(VA[MV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('board.g10.patterned'))
        .fluidInputs(fluid('diluted_potassium_carbonate_solution') * 100)
        .outputs(metaitem('board.g10.developed'))
        .fluidOutputs(fluid('wastewater') * 100)
        .duration(50)
        .EUt(VA[MV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Etching
    Etching.generateWetEtchingRecipe("board.g10.developed", "board.g10.etched", "copper", 50, false)

    // Drilled

    MILLING.recipeBuilder()
        .inputs(metaitem('board.g10.etched') * 4)
        .outputs(metaitem('board.g10.drilled') * 4)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Electroless plating
    // Source:
    //      https://www.nmfrc.org/pdf/p0295g.pdf
    //      https://www.rsc.org/suppdata/d2/ee/d2ee01427k/d2ee01427k1.pdf
    // (the upper one seems to have a typo: 2H2O instead of 2H2)
    // Base reaction: HCHO + 3OH- + Cu+2 --EDTA-> HCOO- + 2H2O + Cu°

    LCR.recipeBuilder()
        .inputs(metaitem('board.g10.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('copper_sulfate_solution') * 1000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.g10.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 6144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    LCR.recipeBuilder()
        .inputs(metaitem('board.g10.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .inputs(ore('dustCopperIiChloride') * 3)
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.g10.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 5144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    LCR.recipeBuilder()
        .inputs(metaitem('board.g10.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .inputs(ore('dustCopperIiNitrate') * 9)
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.g10.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 5144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Electrolytic plating
    // Reference for the mixture: https://patents.google.com/patent/US4242181A/en

    ELECTROLYTIC_CELL.recipeBuilder()
        .inputs(metaitem('board.g10.electroless'))
        .inputs(ore('foilPhosphorizedCopper'))
        .notConsumable(fluid('diluted_sulfuric_acid') * 4000)
        .notConsumable(fluid('copper_sulfate_solution') * 600)
        .outputs(metaitem('board.g10.electrolytic'))
        .EUt(VA[MV])
        .duration(400)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Masking

    MIXER.recipeBuilder()
        .inputs(ore('dyeWhite'))
        .inputs(ore('dustTriarylsulfoniumHexafluoroantimonate'))
        .fluidInputs(fluid('epoxycyclohexane_carboxylate') * 8000)
        .fluidOutputs(fluid('white_epoxy_pcb_coating') * 8000)
        .EUt(VA[LV])
        .duration(40)
        .buildAndRegister();

    CURTAIN_COATER.recipeBuilder()
        .inputs(metaitem('board.g10.electrolytic'))
        .fluidInputs(fluid('white_epoxy_pcb_coating') * 50)
        .outputs(metaitem('board.g10.wet_masked'))
        .EUt(VA[LV])
        .duration(20)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    UV_LIGHT_BOX.recipeBuilder()
        .notConsumable(metaitem('mask.pcb'))
        .inputs(metaitem('board.g10.wet_masked'))
        .outputs(metaitem('board.g10.mask_affixed'))
        .EUt(VA[MV])
        .duration(100)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    CURTAIN_COATER.recipeBuilder()
        .inputs(metaitem('board.g10.mask_affixed'))
        .fluidInputs(fluid('soda_ash_solution') * 100)
        .outputs(metaitem('circuit_board.g10'))
        .fluidOutputs(fluid('wastewater') * 100)
        .EUt(VA[LV])
        .duration(80)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

// EV Board

    // Copper lamination

    FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.fr4.prepreg'))
        .inputs(ore('foilHighPurityCopper') * 2)
        .outputs(metaitem('board.fr4.copper_clad'))
        .EUt(VA[MV])
        .duration(100)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Patterning

    FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.fr4.copper_clad'))
        .inputs(metaitem('dry_film_photoresist') * 2)
        .outputs(metaitem('board.fr4.resist'))
        .EUt(VA[MV])
        .duration(100)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    UV_LIGHT_BOX.recipeBuilder()
        .inputs(metaitem('board.fr4.resist'))
        .notConsumable(metaitem('mask.pcb'))
        .outputs(metaitem('board.fr4.patterned'))
        .duration(100)
        .EUt(VA[MV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('board.fr4.patterned'))
        .fluidInputs(fluid('diluted_potassium_carbonate_solution') * 100)
        .outputs(metaitem('board.fr4.developed'))
        .fluidOutputs(fluid('wastewater') * 100)
        .duration(100)
        .EUt(VA[MV])
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Etching
    Etching.generateWetEtchingRecipe("board.fr4.developed", "board.fr4.etched", "copper", 100, false)

    // Drilling

    MILLING.recipeBuilder()
        .inputs(metaitem('board.fr4.etched') * 4)
        .outputs(metaitem('board.fr4.drilled') * 4)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Electroless plating
    // Source: 
    //      https://www.nmfrc.org/pdf/p0295g.pdf
    //      https://www.rsc.org/suppdata/d2/ee/d2ee01427k/d2ee01427k1.pdf
    // (the upper one seems to have a typo: 2H2O instead of 2H2)
    // Base reaction: HCHO + 3OH- + Cu+2 --EDTA-> HCOO- + 2H2O + Cu° 

    LCR.recipeBuilder()
        .inputs(metaitem('board.fr4.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('copper_sulfate_solution') * 1000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.fr4.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 6144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    LCR.recipeBuilder()
        .inputs(metaitem('board.fr4.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .inputs(ore('dustCopperIiChloride') * 3)
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.fr4.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 5144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();
        
    LCR.recipeBuilder()
        .inputs(metaitem('board.fr4.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .inputs(ore('dustCopperIiNitrate') * 9)
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.fr4.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 5144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Electrolytic plating
    // Reference for the mixture: https://patents.google.com/patent/US4242181A/en

    ELECTROLYTIC_CELL.recipeBuilder()
        .inputs(metaitem('board.fr4.electroless'))
        .inputs(ore('foilPhosphorizedCopper'))
        .notConsumable(fluid('diluted_sulfuric_acid') * 4000)
        .notConsumable(fluid('copper_sulfate_solution') * 600)
        .outputs(metaitem('board.fr4.electrolytic'))
        .EUt(VA[MV])
        .duration(400)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    // Masking

    MIXER.recipeBuilder()
        .inputs(ore('dyeGreen'))
        .inputs(ore('dustTriarylsulfoniumHexafluoroantimonate'))
        .fluidInputs(fluid('epoxycyclohexane_carboxylate') * 8000)
        .fluidOutputs(fluid('green_epoxy_pcb_coating') * 8000)
        .EUt(VA[LV])
        .duration(40)
        .buildAndRegister();

    CURTAIN_COATER.recipeBuilder()
        .inputs(metaitem('board.fr4.electrolytic'))
        .fluidInputs(fluid('green_epoxy_pcb_coating') * 50)
        .outputs(metaitem('board.fr4.wet_masked'))
        .EUt(VA[LV])
        .duration(20)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    UV_LIGHT_BOX.recipeBuilder()
        .notConsumable(metaitem('mask.pcb'))
        .inputs(metaitem('board.fr4.wet_masked'))
        .outputs(metaitem('board.fr4.mask_affixed'))
        .EUt(VA[MV])
        .duration(100)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

    CURTAIN_COATER.recipeBuilder()
        .inputs(metaitem('board.fr4.mask_affixed'))
        .fluidInputs(fluid('soda_ash_solution') * 100)
        .outputs(metaitem('circuit_board.fr4'))
        .fluidOutputs(fluid('wastewater') * 100)
        .EUt(VA[LV])
        .duration(80)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();
