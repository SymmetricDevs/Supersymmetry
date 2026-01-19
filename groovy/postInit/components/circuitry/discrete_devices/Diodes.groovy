import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.cleanroom.CleanroomType
import globals.Lithography
import globals.Etchants
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

Deposition.generateEvaporationRecipe('wafer.diode.alloy.step_one', 'wafer.diode.alloy.step_two', [ 'gold' : 365, 'antimony' : 35 ])
Packaging.generateDicingRecipe('wafer.diode.alloy.step_two', 'die.diode.alloy', 4, 400, LV)

ELECTROLYZER.recipeBuilder()
    .inputs(ore('wireFineInvar') * 8)
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('copper_sulfate_solution') * 1000)
    .outputs(metaitem('wireFineDumet') * 8)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .EUt(VA[MV])
    .duration(20)
    .buildAndRegister();

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('glass') * 72)
    .inputs(ore('wireFineDumet') * 2)
    .inputs(metaitem('die.diode.alloy'))
    .outputs(metaitem('component.diode'))
    .duration(400)
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

Deposition.generateEvaporationRecipe('wafer.zener_diode.alloy.step_one', 'wafer.zener_diode.alloy.step_two', [ 'gold' : 365, 'antimony' : 35 ])
Packaging.generateDicingRecipe('wafer.zener_diode.alloy.step_two', 'die.zener_diode.alloy', 4, 400, LV)

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('glass') * 72)
    .inputs(ore('wireFineDumet') * 2)
    .inputs(metaitem('die.zener_diode.alloy'))
    .outputs(metaitem('component.zener_diode'))
    .duration(400)
    .EUt(VA[LV])
    .buildAndRegister();

// Planar diodes

// Generate SiO2 doping mask and etch holes into it for doped regions
Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.n_doped.', 'wafer.diode.planar.step_one', 400, true)
Lithography.generatePhotolithographyRecipes('wafer.diode.planar.step_one', 'wafer.diode.planar.step_two', 'novolacs_resist', 'mask.diode')
Etchants.generateEtchingRecipes('wafer.diode.planar.step_two', 'wafer.diode.planar.step_three', 'silicon_dioxide', LV, 1, false)
Lithography.generateResistStrippingRecipes('wafer.diode.planar.step_three', 'wafer.diode.planar.step_four', 'HV', 1)

// Doping of boron and drive-in
Doping.generateBoronplanarDopingRecipes('wafer.diode.planar.step_four', 'wafer.diode.planar.step_five', 400)
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
    .fluidInputs(fluid('epoxy_molding_compound') * 72)
    .inputs(ore('wireFineGold') * 2)
    .inputs(metaitem('die.diode.planar'))
    .outputs(metaitem('component.diode'))
    .duration(200)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();

// Planar power diodes (mesa diodes w/ drift layer)

// Deposit drift layer and dope p-side
Deposition.generateChemicalVaporDepositionRecipe('wafer.silicon.n_doped.', 'wafer.power_diode.step_one', "n_minus_silicon", 400)
Doping.generateIonImplantationRecipes('wafer.power_diode.step_one', 'wafer.power_diode.step_two', 1200, 'boron_trifluoride')

// Mask mesa/contact and etch
Deposition.generateChemicalVaporDepositionRecipe('wafer.power_diode.step_two', 'wafer.power_diode.step_three', "silicon_nitride", 400)
Lithography.generatePatterningRecipes('wafer.power_diode.step_three', 'wafer.power_diode.step_four', 'novolacs_resist', 'mask.power_diode_set')
Etchants.generateEtchingRecipes('wafer.power_diode.step_four', 'wafer.power_diode.step_five', 'silicon_nitride', LV, 1, false)
Lithography.generateResistStrippingRecipes('wafer.power_diode.step_five', 'wafer.power_diode.step_six', 'HV', 1)
Etchants.generateEtchingRecipes('wafer.power_diode.step_six', 'wafer.power_diode.step_seven', 'silicon', LV, 1, false)

// Grow passivation oxide
Deposition.generateSiliconDioxideGrowthRecipe('wafer.power_diode.step_seven', 'wafer.power_diode.step_eight', 400, true)

// Metallization
Etchants.generateEtchingRecipes('wafer.power_diode.step_eight', 'wafer.power_diode.step_nine', 'silicon_nitride', LV, 1, false)
Lithography.generatePatterningRecipes('wafer.power_diode.step_nine', 'wafer.power_diode.step_ten', 'novolacs_liftoff_resist', 'mask.power_diode_set')
Deposition.generateSputteringRecipes('wafer.power_diode.step_ten', 'wafer.power_diode.step_eleven', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Lithography.generateResistStrippingRecipes('wafer.power_diode.step_eleven', 'wafer.power_diode.step_twelve', 'HV', 1)
Packaging.generateBackgrindingRecipe('wafer.power_diode.step_twelve', 'wafer.power_diode.step_thirteen', 400, HV)
Deposition.generateSputteringRecipes('wafer.power_diode.step_thirteen', 'wafer.power_diode.step_fourteen', [ 'titanium' : 200, 'nickel' : 400, 'silver' : 200 ])
Deposition.generateSinteringRecipe('wafer.power_diode.step_fourteen', 'wafer.power_diode.step_fifteen', 400, HV)
Packaging.generateDicingRecipe('wafer.power_diode.step_fifteen', 'die.power_diode', 8, 400, HV)

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .inputs(ore('wireGold') * 2)
    .inputs(metaitem('die.power_diode'))
    .outputs(metaitem('component.power_diode'))
    .duration(200)
    .EUt(VA[HV])
    .cleanroom(CleanroomType.CLEANROOM)
    .buildAndRegister();