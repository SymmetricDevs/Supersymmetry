import static globals.Globals.*

ASSEMBLER = recipemap('assembler')
FORMING_PRESS = recipemap('forming_press')
UV_LIGHT_BOX = recipemap('uv_light_box')
CHEMICAL_BATH = recipemap('chemical_bath')
MIXER = recipemap('mixer')
LASER_ENGRAVER = recipemap('laser_engraver')
ION_IMPLANTER = recipemap('ion_implantation')
ELECTROLYZER = recipemap('electrolyzer')

//TODO: ENABLE THIS WHEN SUSYCORE 0.0.9 RELEASES

//TODO: ADD PLASMA ETCHANTS (CHLORINE PLASMA, FLUORINE PLASMA, CARBON TETRACHLORIDE PLASMA)
/*
Etchants used:
- Aluminum: Phosphoric Acid, chlorine plasma
- Indium Tin Oxide: Nitration mixture, fluorine plasma
- Chromium: Hydrochloric acid, fluorine plasma
- GaAs: Hydrogen Peroxide,  chlorine plasma
- Gold & Platinum: Aqua Regia, fluorine plasma
- Photoresist: Sulfuric Acid, oxygen plasma
- Silicon: Nitric Acid or Hydrofluoric Acid,  chlorine plasma
- Silica: Hydrofluoric acid, CF4 plasma
- Silicon nitride: phosphoric acid, CF4 plasma
- Titanium: hydrofluoric acid, BCl3 plasma
- Tungsten: Hydrogen peroxide, CF4 plasma
- Copper: Iron III chloride or Sodium bisulfite, fluorine plasma
 */

/*
//REMOVALS

// Silicon Wafer * 16
mods.gregtech.cutter.removeByInput(64, [metaitem('boule.silicon')], [fluid('lubricant') * 20])
// Silicon Wafer * 16
mods.gregtech.cutter.removeByInput(64, [metaitem('boule.silicon')], [fluid('distilled_water') * 60])
// Silicon Wafer * 16
mods.gregtech.cutter.removeByInput(64, [metaitem('boule.silicon')], [fluid('water') * 80])
// CPU * 8
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.central_processing_unit')], [fluid('lubricant') * 84])
// CPU * 8
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.central_processing_unit')], [fluid('distilled_water') * 253])
// CPU * 8
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.central_processing_unit')], [fluid('water') * 337])
// RAM * 32
mods.gregtech.cutter.removeByInput(96, [metaitem('wafer.random_access_memory')], [fluid('lubricant') * 67])
// RAM * 32
mods.gregtech.cutter.removeByInput(96, [metaitem('wafer.random_access_memory')], [fluid('distilled_water') * 202])
// RAM * 32
mods.gregtech.cutter.removeByInput(96, [metaitem('wafer.random_access_memory')], [fluid('water') * 270])
// ULPIC * 6
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.ultra_low_power_integrated_circuit')], [fluid('lubricant') * 84])
// ULPIC * 6
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.ultra_low_power_integrated_circuit')], [fluid('distilled_water') * 253])
// ULPIC * 6
mods.gregtech.cutter.removeByInput(120, [metaitem('wafer.ultra_low_power_integrated_circuit')], [fluid('water') * 337])
// Integrated Circuit * 8
mods.gregtech.cutter.removeByInput(64, [metaitem('wafer.integrated_logic_circuit')], [fluid('lubricant') * 45])
// Integrated Circuit * 8
mods.gregtech.cutter.removeByInput(64, [metaitem('wafer.integrated_logic_circuit')], [fluid('distilled_water') * 135])
// Integrated Circuit * 8
mods.gregtech.cutter.removeByInput(64, [metaitem('wafer.integrated_logic_circuit')], [fluid('water') * 180])

//FEEL FREE TO ADD MORE AS YOU FIND THEM

class Photoresist {
    String fluidName
    int amountUsed
    int timeUsed
    public static ArrayList<Photoresist> photoresists = new ArrayList<Photoresist>();

    public Photoresist(String fluidName, int amountUsed, float timeUsed) {
        this.fluidName = fluidName
        this.amountUsed = amountUsed
        this.timeUsed = timeUsed
        photoresists.add(this)
    }
}

class Etchant {
    String fluidName
    String materialEtched
    int amountUsed
    int timeUsed
    public static ArrayList<Etchant> etchants = new ArrayList<Etchant>();

    public Etchant(String fluidName, String materialEtched, int amountUsed, int timeUsed) {
        this.fluidName = fluidName
        this.materialEtched = materialEtched
        this.amountUsed = amountUsed
        this.timeUsed = timeUsed
        etchants.add(this)
    }
}

class PDopant {
    String metaItemName
    int efficiency
    public static ArrayList<PDopant> pdopants = new ArrayList<PDopant>();

    public PDopant(String metaItemName, int efficiency) {
        this.metaItemName = metaItemName
        this.efficiency = efficiency
        pdopants.add(this)
    }
}

class NDopant {
    String metaItemName
    int efficiency
    public static ArrayList<NDopant> ndopants = new ArrayList<NDopant>();

    public NDopant(String metaItemName, int efficiency) {
        this.metaItemName = metaItemName
        this.efficiency = efficiency
        ndopants.add(this)
    }
}

//FEEL FREE TO ADD MORE IF YOU FIND THEM

new Photoresist("novolacs", 50, 300)
new Photoresist("pmma", 16, 150)

new Etchant("iron_iii_chloride_solution", "copper", 100, 100)
new Etchant("sodium_bisulfate_solution", "copper", 100, 100)
new Etchant("nitric_acid", "silicon", 80, 100)
new Etchant("hydrofluoric_acid", "silicon", 40, 75)
new Etchant("phosphoric_acid", "aluminium", 50, 100)
new Etchant("nitration_mixture", "indium_tin_oxide", 50, 100)
new Etchant("hydrochloric_acid", "chrome", 50, 100)
new Etchant("hydrogen_peroxide", "gallium_arsenide", 50, 100)
new Etchant("aqua_regia", "gold", 50, 100)
new Etchant("aqua_regia", "platinum", 50, 100)
new Etchant("aqua_regia", "gold", 50, 100)
new Etchant("hydrofluoric_acid", "silicon_dioxide", 40, 75)
new Etchant("phosphoric_acid", "silicon_nitride", 40, 75)
new Etchant("hydrofluoric_acid", "titanium", 50, 100)
new Etchant("hydrogen_peroxide", "tungsten", 50, 100)

new NDopant("dustHighPurityBoron", 1)
new NDopant("dustHighPurityGallium", 2)
new NDopant("dustHighPurityAluminium", 2)
new NDopant("dustHighPurityIndium", 8)

new PDopant("dustHighPurityAntimony", 1)
new PDopant("dustHighPurityPhosphorus", 2)
new PDopant("dustHighPurityArsenic", 3)

def generatePatterningRecipes(input, product, mask, voltageTier, timeMultiplier, int circ) {
    for (photoresist in Photoresist.photoresists) {
        UV_LIGHT_BOX.recipeBuilder()
                .inputs(metaitem(input))
                .notConsumable(metaitem(mask))
                .fluidInputs(fluid(photoresist.fluidName) * photoresist.amountUsed)
                .outputs(metaitem(product))
                .duration(photoresist.timeUsed * timeMultiplier)
                .EUt(Globals.voltAmps[voltageTier])
                .buildAndRegister()

        LASER_ENGRAVER.recipeBuilder()
                .inputs(metaitem(input))
                .notConsumable(Globals.circuit(circ))
                .fluidInputs(fluid(photoresist.fluidName) * (photoresist.amountUsed / 4))
                .outputs(metaitem(product))
                .duration((int) (photoresist.timeUsed * timeMultiplier / 10))
                .EUt(Globals.voltAmps[voltageTier])
                .buildAndRegister()
    }
}

def generateEtchingRecipes(input, product, materialEtched, voltageTier, timeMultiplier) {
    float ok = 0.5f;

    for (etchant in Etchant.etchants) {
        if (etchant.materialEtched == materialEtched) {
            CHEMICAL_BATH.recipeBuilder()
                    .inputs(metaitem(input))
                    .fluidInputs(fluid(etchant.fluidName) * etchant.amountUsed)
                    .outputs(metaitem(product))
                    .duration(etchant.timeUsed * timeMultiplier)
                    .EUt(Globals.voltAmps[voltageTier])
                    .buildAndRegister()
        }
    }
}

//LITHOGRAPHY MASKS

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateGlass'))
        .notConsumable(Globals.circuit(0))
        .fluidInputs(fluid('dye_black')*100)
        .outputs(metaitem('mask.cpu'))
        .duration(200)
        .EUt(7)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateGlass'))
        .notConsumable(Globals.circuit(1))
        .fluidInputs(fluid('dye_black')*100)
        .outputs(metaitem('mask.ram'))
        .duration(200)
        .EUt(7)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateGlass'))
        .notConsumable(Globals.circuit(2))
        .fluidInputs(fluid('dye_black')*100)
        .outputs(metaitem('mask.ic'))
        .duration(200)
        .EUt(7)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateGlass'))
        .notConsumable(Globals.circuit(3))
        .fluidInputs(fluid('dye_black')*100)
        .outputs(metaitem('mask.pcb'))
        .duration(200)
        .EUt(7)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(metaitem('plateGlass'))
        .notConsumable(Globals.circuit(4))
        .fluidInputs(fluid('dye_black')*100)
        .outputs(metaitem('mask.ulpic'))
        .duration(200)
        .EUt(7)
        .buildAndRegister()

//NOVOLACS

MIXER.recipeBuilder()
        .fluidInputs(fluid('formaldehyde')*1000)
        .fluidInputs(fluid('phenol')*1000)
        .fluidOutputs(fluid('novolacs')*2000)
        .duration(200)
        .EUt(7)
        .buildAndRegister()

//DOPING

for (pdopant in PDopant.pdopants) {
    for (ndopant in NDopant.ndopants) {
        int batchSize = pdopant.efficiency * ndopant.efficiency

        ION_IMPLANTER.recipeBuilder()
                .inputs(metaitem('wafer.silicon') * batchSize)
                .inputs(metaitem(pdopant.metaItemName))
                .inputs(metaitem(ndopant.metaItemName))
                .outputs(metaitem('wafer.doped.silicon') * batchSize)
                .duration(400)
                .EUt(60)
                .buildAndRegister()
    }
}

//WAFERS

generatePatterningRecipes('wafer.doped.silicon', 'patterned.ic', 'mask.ic', 2, 4, 0)
generatePatterningRecipes('wafer.doped.silicon', 'patterned.cpu', 'mask.cpu', 2, 4, 1)
generatePatterningRecipes('wafer.doped.silicon', 'patterned.ram', 'mask.ram', 2, 4, 2)
generatePatterningRecipes('wafer.doped.silicon', 'patterned.ulpic', 'mask.ulpic', 2, 4, 3)

generateEtchingRecipes('patterned.ic', 'etched.ic', 'silicon', 1, 1)
generateEtchingRecipes('patterned.cpu', 'etched.cpu', 'silicon', 1, 1)
generateEtchingRecipes('patterned.ram', 'etched.ram', 'silicon', 1, 1)
generateEtchingRecipes('patterned.ulpic', 'etched.ulpic', 'silicon', 1, 1)

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.ic'))
        .inputs(metaitem('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.integrated_logic_circuit'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.cpu'))
        .inputs(metaitem('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.central_processing_unit'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.ram'))
        .inputs(metaitem('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.random_access_memory'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .inputs(metaitem('etched.ulpic'))
        .inputs(metaitem('foilCopper'))
        .fluidInputs(fluid('sulfuric_acid') * 100)
        .outputs(metaitem('wafer.ultra_low_power_integrated_circuit'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .fluidInputs(fluid('high_purity_water') * 100)
        .inputs(metaitem('wafer.central_processing_unit'))
        .outputs(metaitem('plate.central_processing_unit') * 8)
        .duration(900)
        .EUt(64)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .fluidInputs(fluid('high_purity_water') * 100)
        .inputs(metaitem('wafer.ultra_low_power_integrated_circuit'))
        .outputs(metaitem('plate.ultra_low_power_integrated_circuit') * 6)
        .duration(900)
        .EUt(64)
        .buildAndRegister()

CUTTER.recipeBuilder()
        .fluidInputs(fluid('high_purity_water') * 100)
        .inputs(metaitem('wafer.integrated_logic_circuit'))
        .outputs(metaitem('plate.integrated_logic_circuit') * 8)
        .duration(900)
        .EUt(64)
        .buildAndRegister()


CUTTER.recipeBuilder()
        .fluidInputs(fluid('high_purity_water') * 100)
        .inputs(metaitem('wafer.random_access_memory'))
        .outputs(metaitem('plate.random_access_memory') * 32)
        .duration(900)
        .EUt(64)
        .buildAndRegister()

//PHENOLIC BOARD (TIER 2)

FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('board.phenolic'))
        .inputs(metaitem('foilCopper'))
        .outputs(metaitem('laminated.board.phenolic'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

generatePatterningRecipes('laminated.board.phenolic', 'patterned.board.phenolic', 'mask.pcb', 1, 1, 0)
generateEtchingRecipes('patterned.board.phenolic', 'circuit_board.good', 'copper', 1, 1)

//PLASTIC CIRCUIT BOARD (TIER 3)

FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('platePlastic'))
        .inputs(metaitem('foilCopper'))
        .outputs(metaitem('board.plastic'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('platePolyvinylChloride'))
        .inputs(metaitem('foilCopper'))
        .outputs(metaitem('board.plastic') * 2)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('platePolytetrafluoroethylene'))
        .inputs(metaitem('foilCopper'))
        .outputs(metaitem('board.plastic') * 4)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

FORMING_PRESS.recipeBuilder()
        .inputs(metaitem('platePolybenzimidazole'))
        .inputs(metaitem('foilCopper'))
        .outputs(metaitem('board.plastic') * 8)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

generatePatterningRecipes('board.plastic', 'patterned.board.plastic', 'mask.pcb', 2, 1, 0)
generateEtchingRecipes('patterned.board.plastic', 'circuit_board.plastic', 'copper', 2, 1)

 */
