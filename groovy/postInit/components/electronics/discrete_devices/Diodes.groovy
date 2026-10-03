import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType
import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping
import globals.semiconductors.Mechanicals

// SMD Diode * 32
mods.gregtech.assembler.removeByInput(480, [metaitem('dustGalliumArsenide'), metaitem('wireFinePlatinum') * 8], [fluid('plastic') * 288])
// Diode * 2
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineAnnealedCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('glass') * 144])
// Diode * 1
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('glass') * 144])
// Diode * 4
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineAnnealedCopper') * 4, metaitem('wafer.silicon')], [fluid('plastic') * 144])
// Diode * 2
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineCopper') * 4, metaitem('wafer.silicon')], [fluid('plastic') * 144])
// Diode * 4
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineAnnealedCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('plastic') * 144])
// Diode * 2
mods.gregtech.assembler.removeByInput(30, [metaitem('wireFineCopper') * 4, metaitem('dustSmallGalliumArsenide')], [fluid('plastic') * 144])

// Alloy junction signal diodes (MV)

RESISTANCE_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('nuggetAluminium') * 4)
    .inputs(metaitem('wafer.small.silicon.n_doped'))
    .outputs(metaitem('wafer.diode.alloy.step_one'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister();

Deposition.generateEvaporationRecipe('wafer.diode.alloy.step_one', 'wafer.diode.alloy.step_two', 400, 'gold_antimony', false)
Packaging.generateDicingRecipe('wafer.diode.alloy.step_two', 'die.diode.alloy', 4, 400, LV, false)

ELECTROLYZER.recipeBuilder()
    .inputs(ore('wireFineInvar') * 32)
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('copper_sulfate_solution') * 1000)
    .outputs(metaitem('wireFineDumet') * 32)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .EUt(VA[MV])
    .duration(80)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineDumet') * 2)
    .inputs(metaitem('die.diode.alloy'))
    .fluidInputs(fluid('glass') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .outputs(metaitem('component.diode'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

// Alloy junction zener diode (MV)

RESISTANCE_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('nuggetAluminium') * 4)
    .inputs(metaitem('wafer.small.silicon.heavily_n_doped'))
    .outputs(metaitem('wafer.zener_diode.alloy.step_one'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister();

Deposition.generateEvaporationRecipe('wafer.zener_diode.alloy.step_one', 'wafer.zener_diode.alloy.step_two', 400, 'gold_antimony', false)
Packaging.generateDicingRecipe('wafer.zener_diode.alloy.step_two', 'die.zener_diode.alloy', 4, 400, LV, false)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineDumet') * 2)
    .inputs(metaitem('die.zener_diode.alloy'))
    .fluidInputs(fluid('glass') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('nitrogen') * 50)
    .outputs(metaitem('component.diode.zener'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

// Planar diodes (HV, SMD)

// Generate SiO2 doping mask and etch holes into it for doped regions
Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.n_doped', 'wafer.diode.planar.step_one', 400, true)
Lithography.generatePhotolithographyRecipes('wafer.diode.planar.step_one', 'wafer.diode.planar.step_two', 'novolac_resist', 'mask.diode.planar', true)
Etching.generateWetEtchingRecipe('wafer.diode.planar.step_two', 'wafer.diode.planar.step_three', 'silicon_dioxide', 100, false)
Lithography.generateResistStrippingRecipes('wafer.diode.planar.step_three', 'wafer.diode.planar.step_four', 1, false, true)

// Doping of boron and drive-in
Doping.generateBoronDiffusionDopingRecipes('wafer.diode.planar.step_four', 'wafer.diode.planar.step_five', 400)
Doping.generateDriveInRecipe('wafer.diode.planar.step_five', 'wafer.diode.planar.step_six', 400)

// Implantation skip
Doping.generateIonImplantationRecipes('wafer.diode.planar.step_four', 'wafer.diode.planar.step_six', 1200, 'boron_trifluoride')

// Anode (p-side) metallization
// add nLOF resist
Deposition.generateSputteringRecipe('wafer.diode.planar.step_six', 'wafer.diode.planar.step_seven', 400, 'aluminium')

// Cathode (n-side) backgrinding and metallization
Mechanicals.generateBackgrindingRecipe('wafer.diode.planar.step_seven', 'wafer.diode.planar.step_eight', 400, HV)
Deposition.generateSputteringRecipe('wafer.diode.planar.step_eight', 'wafer.diode.planar.step_nine', [ 'titanium' : 100, 'nickel' : 200, 'silver' : 100 ])
Deposition.generateSinteringRecipe('wafer.diode.planar.step_nine', 'wafer.diode.planar.step_ten', 400, HV)
Packaging.generateDicingRecipe('wafer.diode.planar.step_ten', 'die.diode.planar', 32, 400, HV)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineCopper') * 2)
    .inputs(metaitem('die.diode.planar'))
    .inputs(metaitem('component.smd.contact') * 2)
    .fluidInputs(fluid('epoxy_molding_compound') * 36)
    .fluidInputs(fluid('high_temperature_solder') * 18)
    .outputs(metaitem('component.diode.planar'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Planar power diodes (mesa diodes w/ drift layer)

// Deposit drift layer and dope p-side
Deposition.generateChemicalVaporDepositionRecipe('wafer.small.silicon.n_doped', 'wafer.diode.drift.step_one', 1, 'phosphosilicate_glass')
Doping.generateIonImplantationRecipes('wafer.diode.drift.step_one', 'wafer.diode.power.step_two', 1200, 'boron_trifluoride')

// Mask mesa/contact and etch
Deposition.generateChemicalVaporDepositionRecipe('wafer.diode.power.step_two', 'wafer.diode.power.step_three', 1, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.diode.power.step_three', 'wafer.diode.power.step_four', 'novolac_resist', 'mask_set.diode.power', true)
Etching.generateWetEtchingRecipe('wafer.diode.power.step_four', 'wafer.diode.power.step_five', 'silicon_nitride', 400, false)
Lithography.generateResistStrippingRecipes('wafer.diode.power.step_five', 'wafer.diode.power.step_six', 1, false, true)
Etching.generateWetEtchingRecipe('wafer.diode.power.step_six', 'wafer.diode.power.step_seven', 'silicon', 400, false)

// Grow passivation oxide
Deposition.generateSiliconDioxideGrowthRecipe('wafer.diode.power.step_seven', 'wafer.diode.power.step_eight', 400, true)

// Metallization
Etching.generateWetEtchingRecipe('wafer.diode.power.step_eight', 'wafer.diode.power.step_nine', 'silicon_nitride', 400, false)
Lithography.generatePhotolithographyRecipes('wafer.diode.power.step_nine', 'wafer.diode.power.step_ten', 'novolac_liftoff_resist', 'mask_set.diode.power', true)
Deposition.generateSputteringRecipe('wafer.diode.power.step_nine.exposed', 'wafer.diode.power.step_nine.deposited', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Lithography.generateResistStrippingRecipes('wafer.diode.power.step_ten', 'wafer.diode.power.step_eleven', 1, false, true)
Mechanicals.generateBackgrindingRecipe('wafer.diode.power.step_eleven', 'wafer.diode.power.step_twelve', 400, HV)
Deposition.generateSputteringRecipe('wafer.diode.power.step_twelve', 'wafer.diode.power.step_thirteen', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Deposition.generateSinteringRecipe('wafer.diode.power.step_thirteen', 'wafer.diode.power.step_fourteen', 400, HV)
Packaging.generateDicingRecipe('wafer.diode.power.step_fourteen', 'die.diode.power', 4, 400, HV)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineGold') * 2)
    .inputs(metaitem('die.diode.power'))
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .outputs(metaitem('component.diode.power'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Schottky diodes (HV)

// n- epi layer, p+ guard ring
Lithography.generatePhotolithographyRecipes('wafer.diode.drift.step_one', 'wafer.diode.schottky.step_two', 'novolac_resist', 'mask_set.diode.schottky', true)
Doping.generateIonImplantationRecipes('wafer.diode.schottky.step_two', 'wafer.diode.schottky.step_three', 100, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.diode.schottky.step_three', 'wafer.diode.schottky.step_four', 1, false, true)

// Deposit passivation oxide
Deposition.generateChemicalVaporDepositionRecipe('wafer.diode.schottky.step_four', 'wafer.diode.schottky.step_five', 1, 'silicon_dioxide.silane')
Lithography.generatePhotolithographyRecipes('wafer.diode.schottky.step_five', 'wafer.diode.schottky.step_six', 'novolac_resist', 'mask_set.diode.schottky', true)
Etching.generateWetEtchingRecipe('wafer.diode.schottky.step_six', 'wafer.diode.schottky.step_seven', 'silicon_dioxide', 400, false)
Lithography.generateResistStrippingRecipes('wafer.diode.schottky.step_seven', 'wafer.diode.schottky.step_eight', 1, false, true)

// Anode metallization with titanium for Schottky barrier
Lithography.generatePhotolithographyRecipes('wafer.diode.schottky.step_eight', 'wafer.diode.schottky.step_nine', 'novolac_liftoff_resist', 'mask_set.diode.schottky', false)
Deposition.generateSputteringRecipe('wafer.diode.schottky.step_eight.exposed', 'wafer.diode.schottky.step_eight.deposited', ['titanium': 200, 'nickel' : 400, 'silver' : 200])
Lithography.generateResistStrippingRecipes('wafer.diode.schottky.step_nine', 'wafer.diode.schottky.step_ten', 1, false, true)

// Cathode metallization
Mechanicals.generateBackgrindingRecipe('wafer.diode.schottky.step_ten', 'wafer.diode.schottky.step_eleven', 400, HV)
Deposition.generateSputteringRecipe('wafer.diode.schottky.step_eleven', 'wafer.diode.schottky.step_twelve', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Deposition.generateSinteringRecipe('wafer.diode.schottky.step_twelve', 'wafer.diode.schottky.step_thirteen', 400, HV)
Packaging.generateDicingRecipe('wafer.diode.schottky.step_thirteen', 'die.diode.schottky', 32, 400, HV)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineCopper') * 2)
    .inputs(metaitem('die.diode.schottky'))
    .fluidInputs(fluid('epoxy_molding_compound') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 36)
    .outputs(metaitem('component.diode.schottky'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Photodiodes          Source: https://patents.google.com/patent/US4477964A/en
//Indium phosphide

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustHighPurityIndium') * 4)
    .fluidInputs(fluid('high_purity_phosphorus') * 576)
    .outputs(metaitem('seed_crystal.indium_phosphide'))
    .duration(1200)
    .EUt(VA[HV])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .inputs(ore('dustHighPurityIndium'))
    .fluidInputs(fluid('high_purity_phosphorus') * 144)
    .notConsumable(fluid('boron_trioxide') * 720)
    .inputs(metaitem('seed_crystal.indium_phosphide'))
    .notConsumable(metaitem('crucible.boron.nitride'))
    .outputs(metaitem('boule.indium_phosphide'))
    .duration(300)
    .EUt(VA[HV])
    .buildAndRegister()

Doping.generateSealedDiffusionRecipe('wafer.indium_phosphide', 'wafer.photodiode.step_one', 400, HV, "Cadmium", "Indium") // Diffuse Cd into the wafer w/ In additive to aid process
Lithography.generatePhotolithographyRecipes('wafer.photodiode.step_one', 'wafer.photodiode.step_two', 'novolac_resist', 'mask.photodiode', true)
Etching.generateWetEtchingRecipe('wafer.photodiode.step_two', 'wafer.photodiode.step_three', 'indium_phosphide', 200, false) // InP need bromomethane
Lithography.generateResistStrippingRecipes('wafer.photodiode.step_three', 'wafer.photodiode.step_four', 1, false, true)
Deposition.generateSputteringRecipe('wafer.photodiode.step_four', 'wafer.photodiode.step_five', 400, 'gold') // Pure gold contacts because i think its too early for the 1% beryllium in the patent
Packaging.generateDicingRecipe('wafer.photodiode.step_five', 'die.photodiode', 16, 400, HV)
Packaging.generateWireBondingRecipe('die.photodiode', 'die.photodiode.bonded', 'gold', 50, HV)
ASSEMBLER.recipeBuilder()
    .inputs(metaitem('die.photodiode.bonded'))
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .outputs(metaitem('component.photodiode'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister()

// Light-emitting diodes

    // Infrared

    
