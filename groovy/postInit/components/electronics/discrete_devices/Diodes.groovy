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

// Standard signal diodes

oreDict.add('componentDiodeSignal', metaitem('component.diode.alloy_junction'))
oreDict.add('componentDiodeSignal', metaitem('component.diode.planar'))

// Alloy junction signal diodes

RESISTANCE_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('nuggetAluminium') * 4)
    .inputs(metaitem('wafer.silicon.small.n_doped'))
    .outputs(metaitem('wafer.diode.alloy.step_one'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister();

Deposition.generateEvaporationRecipe('wafer.diode.alloy.step_one', 'wafer.diode.alloy.step_two', 400, 'gold_antimony', false)
Packaging.generateDicingRecipe('wafer.diode.alloy.step_two', 'die.diode.alloy', 4, 400, LV)

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

// Alloy junction zener diode

RESISTANCE_FURNACE.recipeBuilder()
    .circuitMeta(1)
    .notConsumable(ore('springCupronickel'))
    .inputs(ore('nuggetAluminium') * 4)
    .inputs(metaitem('wafer.silicon.small.heavily_n_doped'))
    .outputs(metaitem('wafer.zener_diode.alloy.step_one'))
    .duration(400)
    .EUt(VA[MV])
    .buildAndRegister();

Deposition.generateEvaporationRecipe('wafer.zener_diode.alloy.step_one', 'wafer.zener_diode.alloy.step_two', 400, 'gold_antimony', false)
Packaging.generateDicingRecipe('wafer.zener_diode.alloy.step_two', 'die.zener_diode.alloy', 4, 400, LV)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineDumet') * 2)
    .inputs(metaitem('die.zener_diode.alloy'))
    .fluidInputs(fluid('glass') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .fluidInputs(fluid('nitrogen') * 50)
    .outputs(metaitem('component.zener_diode'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

// Planar diodes

// Generate SiO2 doping mask and etch holes into it for doped regions
Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.n_doped', 'wafer.diode.planar.step_one', 400, true)
Lithography.generatePhotolithographyRecipes('wafer.diode.planar.step_one', 'wafer.diode.planar.step_two', 'novolac_resist', 'mask.diode.planar', false)
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
    .outputs(metaitem('component.smd.diode'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Planar power diodes (mesa diodes w/ drift layer)

// Deposit drift layer and dope p-side
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.small.n_doped', 'wafer.diode.drift.step_one', 1, 'phosphosilicate_glass')
Doping.generateIonImplantationRecipes('wafer.diode.drift.step_one', 'wafer.diode.power.step_two', 1200, 'boron_trifluoride')

// Mask mesa/contact and etch
Deposition.generateChemicalVaporDepositionRecipe('wafer.diode.power.step_two', 'wafer.diode.power.step_three', 1, 'silicon_nitride.silane')
Lithography.generatePhotolithographyRecipes('wafer.diode.power.step_three', 'wafer.diode.power.step_four', 'novolac_resist', 'mask_set.diode.power', false)
Etching.generateWetEtchingRecipe('wafer.diode.power.step_four', 'wafer.diode.power.step_five', 'silicon_nitride', 400, false)
Lithography.generateResistStrippingRecipes('wafer.diode.power.step_five', 'wafer.diode.power.step_six', 1, false, true)
Etching.generateWetEtchingRecipe('wafer.diode.power.step_six', 'wafer.diode.power.step_seven', 'silicon', 400, false)

// Grow passivation oxide
Deposition.generateSiliconDioxideGrowthRecipe('wafer.diode.power.step_seven', 'wafer.diode.power.step_eight', 400, true)

// Metallization
Etching.generateWetEtchingRecipe('wafer.diode.power.step_eight', 'wafer.diode.power.step_nine', 'silicon_nitride', 400, false)
Lithography.generatePhotolithographyRecipes('wafer.diode.power.step_nine', 'wafer.diode.power.step_ten', 'novolacs_liftoff_resist', 'mask_set.diode.power', false)
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

// Schottky diodes

// n- epi layer, p+ guard ring
Lithography.generatePhotolithographyRecipes('wafer.diode.drift.step_one', 'wafer.diode.schottky.step_two', 'novolac_resist', 'mask_set.diode.schottky', false)
Doping.generateIonImplantationRecipes('wafer.diode.schottky.step_two', 'wafer.diode.schottky.step_three', 100, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.diode.schottky.step_three', 'wafer.diode.schottky.step_four', 1, false, true)

// Deposit passivation oxide
Deposition.generateChemicalVaporDepositionRecipe('wafer.diode.schottky.step_four', 'wafer.diode.schottky.step_five', 1, 'silicon_dioxide.silane')
Lithography.generatePhotolithographyRecipes('wafer.diode.schottky.step_five', 'wafer.diode.schottky.step_six', 'novolac_resist', 'mask_set.diode.schottky', false)
Etching.generateWetEtchingRecipe('wafer.diode.schottky.step_six', 'wafer.diode.schottky.step_seven', 'silicon_dioxide', 400, false)
Lithography.generateResistStrippingRecipes('wafer.diode.schottky.step_seven', 'wafer.diode.schottky.step_eight', 1, false, true)

// Anode metallization with titanium for Schottky barrier
Lithography.generatePhotolithographyRecipes('wafer.diode.schottky.step_eight', 'wafer.diode.schottky.step_nine', 'novolacs_liftoff_resist', 'mask_set.diode.schottky', false)
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

// Photodiodes

// Light-emitting diodes

    // Infrared

    
