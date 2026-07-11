import globals.Globals
import globals.Photoresists
import globals.Etchants

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.metatileentity.multiblock.CleanroomType

mods.jei.ingredient.yeet(
    metaitem('board.epoxy'),
    metaitem('board.fiber_reinforced'),
    metaitem('circuit_board.advanced'),
    metaitem('circuit_board.extreme')
)

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

// Copper Clad Laminate
FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.epoxy.prepreg'))
        .inputs(ore('foilHighPurityCopper') * 2)
        .outputs(metaitem('board.epoxy.copper_clad'))
        .EUt(VA[MV])
        .duration(100)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

// Patterned
Photoresists.generatePatterningRecipes("board.epoxy.copper_clad", "board.epoxy.patterned", "mask.pcb", EV, 2 /* double sided */, 1, 1, true)

// Etched
Etchants.generateEtchingRecipes("board.epoxy.patterned", "board.epoxy.etched", "copper", EV, 2 /* double sided */, true)

// Drilled
MILLING.recipeBuilder()
        .inputs(metaitem('board.epoxy.etched') * 4)
        .outputs(metaitem('board.epoxy.drilled') * 4)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

// Electroless Plating
// Source: 
//      https://www.nmfrc.org/pdf/p0295g.pdf
//      https://www.rsc.org/suppdata/d2/ee/d2ee01427k/d2ee01427k1.pdf
// (the upper one seems to have a typo: 2H2O instead of 2H2)
// Base reaction: HCHO + 3OH- + Cu+2 --EDTA-> HCOO- + 2H2O + Cu° 
LCR.recipeBuilder()
        .inputs(metaitem('board.epoxy.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('copper_sulfate_solution') * 1000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.epoxy.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 6144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

LCR.recipeBuilder()
        .inputs(metaitem('board.epoxy.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .inputs(ore('dustCopperIiChloride') * 3)
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.epoxy.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 5144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();
        
LCR.recipeBuilder()
        .inputs(metaitem('board.epoxy.drilled') * 4)
        .inputs(ore('dustTinyPalladiumChlorideDihydrate'))
        .inputs(ore('dustCopperIiNitrate') * 9)
        .fluidInputs(fluid('distilled_water') * 100)
        .fluidInputs(fluid('tetrasodium_ethylenediaminetetraacetate_solution') * 50)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
        .fluidInputs(fluid('formaldehyde') * 1000)
        .outputs(metaitem('board.epoxy.electroless') * 4)
        .fluidOutputs(fluid('wastewater') * 5144)
        .EUt(VA[MV])
        .duration(300)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

// Electrolytic Plating
// Reference for the mixture: https://patents.google.com/patent/US4242181A/en
ELECTROLYTIC_CELL.recipeBuilder()
        .inputs(metaitem('board.epoxy.electroless'))
        .fluidInputs(fluid('sulfuric_acid') * 2000)
        .fluidInputs(fluid('copper_sulfate_solution') * 600)
        .outputs(metaitem('board.epoxy.electrolytic'))
        .fluidOutputs(fluid('sulfuric_acid') * 2600)
        .fluidOutputs(fluid('oxygen') * 600)
        .EUt(VA[MV])
        .duration(400)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

// Masking
MIXER.recipeBuilder()
        .inputs(ore('dyeGreen'))
        .inputs(ore('dustBenzenediazoniumChloride'))
        .fluidInputs(fluid('epoxycyclohexane_carboxylate') * 8000)
        .fluidOutputs(fluid('green_epoxy_pcb_coating') * 8000)
        .EUt(VA[LV])
        .duration(40)
        .buildAndRegister();

CURTAIN_COATER.recipeBuilder()
        .inputs(metaitem('board.epoxy.electrolytic'))
        .fluidInputs(fluid('green_epoxy_pcb_coating') * 50)
        .outputs(metaitem('board.epoxy.wet_masked'))
        .EUt(VA[LV])
        .duration(20)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

UV_LIGHT_BOX.recipeBuilder()
        .notConsumable(metaitem('mask.pcb'))
        .inputs(metaitem('board.epoxy.wet_masked'))
        .outputs(metaitem('board.epoxy.mask_affixed'))
        .EUt(VA[MV])
        .duration(100)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();

CURTAIN_COATER.recipeBuilder()
        .inputs(metaitem('board.epoxy.mask_affixed'))
        .fluidInputs(fluid('soda_ash_solution') * 100)
        .outputs(metaitem('circuit_board.fr4'))
        .fluidOutputs(fluid('wastewater') * 100)
        .EUt(VA[LV])
        .duration(80)
        .cleanroom(CleanroomType.CLEANROOM)
        .buildAndRegister();