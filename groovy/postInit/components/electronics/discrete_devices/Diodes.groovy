import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.cleanroom.CleanroomType
import globals.Lithography
import globals.Etching
import globals.Deposition
import globals.Packaging
import globals.Doping

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
Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.n_doped.', 'wafer.diode.planar.step_one', 400, true)
Lithography.generatePhotolithographyRecipes('wafer.diode.planar.step_one', 'wafer.diode.planar.step_two', 'novolacs_resist', 'mask.diode')
Etching.generateWetEtchingRecipes('wafer.diode.planar.step_two', 'wafer.diode.planar.step_three', 'silicon_dioxide', 100, false, false)
Lithography.generateResistStrippingRecipes('wafer.diode.planar.step_three', 'wafer.diode.planar.step_four', 'HV', 1)

// Doping of boron and drive-in
Doping.generateBoronDiffusionDopingRecipes('wafer.diode.planar.step_four', 'wafer.diode.planar.step_five', 400)
Doping.generateDriveInRecipe('wafer.diode.planar.step_five', 'wafer.diode.planar.step_six', 400)

// Implantation skip
Doping.generateIonImplantationRecipes('wafer.diode.planar.step_four', 'wafer.diode.planar.step_six', 1200, 'boron_trifluoride')

// Anode (p-side) metallization
// add nLOF resist
Deposition.generateSputteringRecipes('wafer.diode.planar.step_six', 'wafer.diode.planar.step_seven', 400, 'aluminium')

// Cathode (n-side) backgrinding and metallization
Packaging.generateBackgrindingRecipe('wafer.diode.planar.step_seven', 'wafer.diode.planar.step_eight', 400, HV)
Deposition.generateSputteringRecipes('wafer.diode.planar.step_eight', 'wafer.diode.planar.step_nine', [ 'titanium' : 100, 'nickel' : 200, 'silver' : 100 ])
Deposition.generateSinteringRecipe('wafer.diode.planar.step_nine', 'wafer.diode.planar.step_ten', 400, HV)
Packaging.generateDicingRecipe('wafer.diode.planar.step_ten', 'die.diode.planar', 32, 400, HV)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireFineCopper') * 2)
    .inputs(metaitem('die.diode.planar'))
    .fluidInputs(fluid('epoxy_molding_compound') * 72)
    .fluidInputs(fluid('high_temperature_solder') * 36)
    .outputs(metaitem('component.diode'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Planar power diodes (mesa diodes w/ drift layer)

// Deposit drift layer and dope p-side
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.n_doped.small', 'wafer.power_diode.step_one', "n_minus_silicon", 400)
Doping.generateIonImplantationRecipes('wafer.power_diode.step_one', 'wafer.power_diode.step_two', 1200, 'boron_trifluoride')

// Mask mesa/contact and etch
Deposition.generateChemicalVaporDepositionRecipe('wafer.power_diode.step_two', 'wafer.power_diode.step_three', "silicon_nitride", 400)
Lithography.generatePatterningRecipes('wafer.power_diode.step_three', 'wafer.power_diode.step_four', 'novolacs_resist', 'mask.power_diode_set')
Etching.generateWetEtchingRecipes('wafer.power_diode.step_four', 'wafer.power_diode.step_five', 'silicon_nitride', 400, false, false)
Lithography.generateResistStrippingRecipes('wafer.power_diode.step_five', 'wafer.power_diode.step_six', 'HV', 1)
Etching.generateWetEtchingRecipes('wafer.power_diode.step_six', 'wafer.power_diode.step_seven', 'silicon', 400, false, false)

// Grow passivation oxide
Deposition.generateSiliconDioxideGrowthRecipe('wafer.power_diode.step_seven', 'wafer.power_diode.step_eight', 400, true)

// Metallization
Etching.generateWetEtchingRecipes('wafer.power_diode.step_eight', 'wafer.power_diode.step_nine', 'silicon_nitride', 400, false, false)
Lithography.generatePatterningRecipes('wafer.power_diode.step_nine', 'wafer.power_diode.step_ten', 'novolacs_liftoff_resist', 'mask.power_diode_set')
Deposition.generateSputteringRecipes('wafer.power_diode.step_ten', 'wafer.power_diode.step_eleven', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Lithography.generateResistStrippingRecipes('wafer.power_diode.step_eleven', 'wafer.power_diode.step_twelve', 'HV', 1)
Packaging.generateBackgrindingRecipe('wafer.power_diode.step_twelve', 'wafer.power_diode.step_thirteen', 400, HV)
Deposition.generateSputteringRecipes('wafer.power_diode.step_thirteen', 'wafer.power_diode.step_fourteen', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Deposition.generateSinteringRecipe('wafer.power_diode.step_fourteen', 'wafer.power_diode.step_fifteen', 400, HV)
Packaging.generateDicingRecipe('wafer.power_diode.step_fifteen', 'die.power_diode', 4, 400, HV)

ASSEMBLER.recipeBuilder()
    .inputs(ore('wireGold') * 2)
    .inputs(metaitem('die.power_diode'))
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .fluidInputs(fluid('high_temperature_solder') * 72)
    .outputs(metaitem('component.power_diode'))
    .duration(50)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Photodiodes

// Light-emitting diodes

    // Infrared

    