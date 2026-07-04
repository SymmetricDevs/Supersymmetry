import static prePostInit.Recipemaps.*
import classes.*
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

import globals.Globals
import globals.semiconductors.Lithography
import globals.semiconductors.Etching
import globals.semiconductors.Deposition
import globals.semiconductors.Packaging
import globals.semiconductors.Doping
import globals.semiconductors.Mechanicals

// Lookup table for int to string conversion

// Superfill copper electrolyte

BLENDER.recipeBuilder()
    .fluidInputs(fluid('copper_sulfate_solution') * 2900)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 7000)
    .fluidInputs(fluid('polyethylene_glycol') * 100)
    .fluidInputs(fluid('hydrogen_chloride') * 100)
    .inputs(ore('dustTinyBisSodiumSulfopropylDisulfide'))
    .inputs(ore('dustTinyPolyvinylpyrrolidone'))
    .fluidOutputs(fluid('copper_superfill_electrolyte') * 10000)
    .duration(200)
    .EUt(VA[HV])
    .buildAndRegister()

// CMOS 45nm process fabrication chain

Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.p_doped', 'wafer.cmos.step_one', 400, true) // Protecting layer for P/NMOS well formation
Deposition.generateChemicalVaporDepositionRecipe('wafer.cmos.step_one', 'wafer.cmos.step_two', 2.0, 'silicon_nitride.silane') // CMP stop layer for STI formation
Lithography.generateCoatingRecipe('wafer.cmos.step_two', 'methacrylate_resist', true) // Coat with photoresist for STI patterning

def generateCMOSFabrication(String componentName) {
    def numberTab = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'] // define it here since otherwise it breaks??
    // FEOL
    
    // Shallow trench isolation
    Lithography.generateSplitPhotolithographyRecipes('wafer.cmos.step_two', 'wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define STI pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 'silicon_nitride', 400) // Etch into silicon to form trenches
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 'silicon_dioxide', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 'silicon', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_six', 'wafer.' + componentName + '.step_seven', 1, true)
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 400, false) // Protective oxide growth after trench etching to repair etch damage
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_eight', 'wafer.' + componentName + '.step_nine', 3.0, 'silicon_dioxide.teos') // Fill trenches, TEOS has better gap-filling properties
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_nine', 'wafer.' + componentName + '.step_ten', 'basic_cmp_slurry', 400, HV) // CMP to planarize wafer
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_ten', 'wafer.' + componentName + '.step_eleven', 'silicon_nitride', 400, false) // Etch away silicon nitride CMP stop layer

    // NMOS well formation
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_eleven', 'wafer.' + componentName + '.step_twelve', 'methacrylate_resist', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_twelve', 'wafer.' + componentName + '.step_thirteen', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirteen', 'wafer.' + componentName + '.step_fourteen', 1, true)

    // PMOS well formation
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fourteen', 'wafer.' + componentName + '.step_fifteen', 'methacrylate_resist', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_fifteen', 'wafer.' + componentName + '.step_sixteen', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_sixteen', 'wafer.' + componentName + '.step_seventeen', 1, true)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_seventeen', 'wafer.' + componentName + '.step_eighteen', 100) // Shared drive-in of NMOS/CMOS wells

    // Dummy gate formation
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_eighteen', 'wafer.' + componentName + '.step_nineteen', 'silicon_dioxide', 400, false) // Remove protective oxide layer to expose silicon surface for gate formation
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_nineteen', 'wafer.' + componentName + '.step_twenty', 400, false) // Grow SiO2 interfacial layer for HfO2
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_twenty', 'wafer.' + componentName + '.step_twenty_one', 0.1, 'hafnium_dioxide') // Gate oxide deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_twenty_one', 'wafer.' + componentName + '.step_twenty_two', 3.0, 'silicon') // Grow dummy gate
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_twenty_two', 'wafer.' + componentName + '.step_twenty_three', 1.0, 'silicon_nitride.silane') // Hard mask layer for dummy gate
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_three', 'wafer.' + componentName + '.step_twenty_four', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define gate pattern FIXME: change to use ibarc.
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_four', 'wafer.' + componentName + '.step_twenty_five', 'silicon_nitride', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_five', 'wafer.' + componentName + '.step_twenty_six', 'silicon', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_six', 'wafer.' + componentName + '.step_twenty_seven', 'hafnium_dioxide', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twenty_seven', 'wafer.' + componentName + '.step_twenty_eight', 1, true)

    // Halo and extension implantation (NMOS)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_eight', 'wafer.' + componentName + '.step_twenty_nine', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define source/drain pattern for NMOS to form halo and extension implants
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_twenty_nine', 'wafer.' + componentName + '.step_thirty', 400, 'phosphine')
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty', 'wafer.' + componentName + '.step_thirty_one', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_one', 'wafer.' + componentName + '.step_thirty_two', 1, true)

    // Halo and extension implantation (PMOS)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_thirty_two', 'wafer.' + componentName + '.step_thirty_three', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define source/drain pattern for PMOS to form halo and extension implants
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty_three', 'wafer.' + componentName + '.step_thirty_four', 400, 'boron_trifluoride')
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty_four', 'wafer.' + componentName + '.step_thirty_five', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_five', 'wafer.' + componentName + '.step_thirty_six', 1, true)

    // Spacer formation, reduces short channel effects, parasitic capacitances, strain engineering for NMOS.
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_thirty_six', 'wafer.' + componentName + '.step_thirty_seven', 1.0, 'silicon_nitride.silane') // NOTE: original line specified TEOS for silicon nitride but this doesn't make sense?
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_thirty_seven', 'wafer.' + componentName + '.step_thirty_eight', 'methacrylate_resist', 'mask_set.' + componentName, true)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_thirty_eight', 'wafer.' + componentName + '.step_thirty_nine', 'silicon_nitride', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_nine', 'wafer.' + componentName + '.step_forty', 1, true)

    // PMOS compressive strain engineering with SiGe
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_forty', 'wafer.' + componentName + '.step_forty_one', 400, false)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_forty_one', 'wafer.' + componentName + '.step_forty_two', 'methacrylate_resist', 'mask_set.' + componentName, true) // Protect NMOS while etching PMOS source/drain areas
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_forty_two', 'wafer.' + componentName + '.step_forty_three', 'silicon_dioxide', 400) // Anisotropic etch to expose PMOS source/drain areas
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_forty_three', 'wafer.' + componentName + '.step_forty_four', 1, true)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_forty_four', 'wafer.' + componentName + '.step_forty_five', 'silicon', 400) // Etch into silicon to form recesses for SiGe deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_forty_five', 'wafer.' + componentName + '.step_forty_six', 1.0, 'silicon_germanium') // Epitaxial deposition of SiGe in PMOS source/drain recesses
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_forty_six', 'wafer.' + componentName + '.step_forty_seven', 400, 'boron_trifluoride') // Dope SiGe for good ohmic contact
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_forty_seven', 'wafer.' + componentName + '.step_forty_eight', 100) // Drive in dopants in SiGe

    // Nickel salicide process for contact formation
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_forty_eight', 'wafer.' + componentName + '.step_forty_nine', ['nickel' : 480, 'platinum' : 20]) // Deposit nickel for silicidation, platinum is added to improve thermal stability of silicide
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_forty_nine', 'wafer.' + componentName + '.step_fifty', 100, MV) // Anneal to form initial Ni2Si silicide phase for etch resistance
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty', 'wafer.' + componentName + '.step_fifty_one', 'nickel_silicide', 400, false) // Etch away unreacted nickel: H2SO4, H2O2.
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_fifty_one', 'wafer.' + componentName + '.step_fifty_two', 400, HV) // High temperature anneal to transform Ni2Si into low resistivity NiSi

    // T-CESL for NMOS strain engineering, interlayer dielectric.
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_fifty_two', 'wafer.' + componentName + '.step_fifty_three', 1.0, 'silicon_nitride.silane') // T-CESL
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fifty_three', 'wafer.' + componentName + '.step_fifty_four', 'methacrylate_resist', 'mask_set.' + componentName, true) // Remove T-CESL from PMOS areas
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_fifty_four', 'wafer.' + componentName + '.step_fifty_five', 'silicon_nitride', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_fifty_five', 'wafer.' + componentName + '.step_fifty_six', 1, true)
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_fifty_six', 'wafer.' + componentName + '.step_fifty_seven', 2.0, 'silicon') // Interlayer dielectric

    // Gate formation
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_fifty_seven', 'wafer.' + componentName + '.step_fifty_eight', 'basic_cmp_slurry', 400, HV) // CMP to planarize down to dummy gate hardmask
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty_eight', 'wafer.' + componentName + '.step_fifty_nine', 'silicon_nitride', 400, false) // Etch hardmask
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty_nine', 'wafer.' + componentName + '.step_sixty', 'silicon', 400, true) // TMAH etch of dummy gate
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_sixty', 'wafer.' + componentName + '.step_sixty_one', 0.1, 'titanium_nitride') // Deposit PMOS workfunction metal
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_sixty_one', 'wafer.' + componentName + '.step_sixty_two', 'methacrylate_resist', 'mask_set.' + componentName, true) // Mask PMOS areas to implant NMOS workfunction metal FIXME: change to use ibarc.
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_sixty_two', 'wafer.' + componentName + '.step_sixty_three', 'titanium_nitride', 400, false) // Etch titanium nitride from PMOS areas
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_sixty_three', 'wafer.' + componentName + '.step_sixty_four', 1, false)
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_sixty_four', 'wafer.' + componentName + '.step_sixty_five', 0.1, 'titanium_aluminide') // Deposit PMOS/NMOS workfunction metal
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_sixty_five', 'wafer.' + componentName + '.step_sixty_six', 400, 'aluminium') // Deposit aluminium gate fill
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_sixty_six', 'wafer.' + componentName + '.step_sixty_seven', 'basic_cmp_slurry', 400, HV) // CMP to planarize down to gate level
    
    // Plug formation
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixty_seven', 'wafer.' + componentName + '.step_sixty_eight', 2.0, 'silicon_nitride.silane') // Deposit CMP stop layer
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixty_eight', 'wafer.' + componentName + '.step_sixty_nine', 2.0, 'silicon_dioxide.silane') // Deposit interlayer dielectric
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_sixty_nine', 'wafer.' + componentName + '.step_seventy', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define plug pattern FIXME: change to use ibarc.
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_seventy', 'wafer.' + componentName + '.step_seventy_one', 'silicon_dioxide', 400) // CH3F
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_seventy_one', 'wafer.' + componentName + '.step_seventy_two', 'silicon_nitride', 400) // CH3F
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_seventy_two', 'wafer.' + componentName + '.step_seventy_three', 1, true)
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_seventy_three', 'wafer.' + componentName + '.step_seventy_four', 0.1, 'titanium_aluminide') // Barrier layer deposition for tungsten plugs
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_seventy_four', 'wafer.' + componentName + '.step_seventy_five', 2.0, 'tungsten') // Tungsten hexafluoride plug fill
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_seventy_five', 'wafer.' + componentName + '.step_seventy_six', 'oxidative_cmp_slurry', 400, HV) // CMP to planarize down to ILD level

    // Damascene copper BEOL, 9 layers
    
    for (l in 1..9) {
        String input
        if (l == 1) input = 'wafer.' + componentName + '.step_seventy_six'
        else input = 'wafer.' + componentName + '.beol_' + numberTab[l-1] + '.step_eight'
        def resist = l <= 3 ? 'methacrylate_resist' : (l <= 6 ? 'polyhydroxystyrene_resist' : 'novolac_resist')

        Deposition.generateChemicalVaporDepositionRecipe(input, 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_one', 400, 'silicon_oxycarbide_hydride') // Deposit low-k dielectric
        Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_one', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_two', resist, 'mask_set.' + componentName, false) // Define via and trench pattern for each metal layer FIXME: change steps 1-3 to use ibarc.
        Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_two', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_three', 'silicon_oxycarbide_hydride', 400) // Etch vias and trenches
        Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_three', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_four', 1, false, (resist == 'novolac_resist'))
        Deposition.generateSputteringRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_four', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_five', ['tantalum_nitride' : 50]) // Barrier layer deposition for copper interconnects
        Deposition.generateSputteringRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_five', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_six', ['tantalum' : 100, 'copper' : 100]) // Adhesion layer for copper, seed layer

        ELECTROLYTIC_CELL.recipeBuilder()
            .notConsumable(fluid('copper_superfill_electrolyte') * 1000)
            .inputs(metaitem('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_six'))
            .inputs(ore('foilPhosphorizedCopper'))
            .outputs(metaitem('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_seven'))
            .EUt(VA[MV])
            .duration(400)
            .buildAndRegister()

        Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_seven', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_eight', 'basic_cmp_slurry', 400, HV) // CMP down to ILD level
    }

    // Sealing and final packaging, flip chip.

    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.beol_nine.step_eight', 'wafer.' + componentName + '.step_one_hundred_forty_nine', 400, 'silicon_dioxide.silane') // Passivation layer deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_one_hundred_forty_nine', 'wafer.' + componentName + '.step_one_hundred_fifty', 400, 'silicon_nitride.silane')
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_one_hundred_fifty', 'wafer.' + componentName + '.step_one_hundred_fifty_one', 'novolac_resist', 'mask_set.' + componentName, true) // Define contact hole pattern in passivation layers
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_one_hundred_fifty_one', 'wafer.' + componentName + '.step_one_hundred_fifty_two', 'silicon_nitride', 400, false) // Etch silicon nitride passivation layer
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_one_hundred_fifty_two', 'wafer.' + componentName + '.step_one_hundred_fifty_three', 'silicon_dioxide', 400, false) // Etch silicon dioxide passivation layer
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_one_hundred_fifty_three', 'wafer.' + componentName + '.step_one_hundred_fifty_four', 1, false)
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_one_hundred_fifty_four', 'wafer.' + componentName + '.step_one_hundred_fifty_five', ['chromium' : 200, 'copper' : 200]) // Deposit under-bump metallization layers for solder bump attachment
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_one_hundred_fifty_five', 'wafer.' + componentName + '.step_one_hundred_fifty_six', 'novolac_resist', 'mask_set.' + componentName, false) // Define solder bump pattern

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('diluted_sulfuric_acid') * 4000)
        .notConsumable(fluid('copper_sulfate_solution') * 600)
        .inputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_six'))
        .inputs(ore('foilPhosphorizedCopper'))
        .outputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_seven'))
        .EUt(VA[MV])
        .duration(400)
        .buildAndRegister()

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('methanesulfonic_acid') * 1000)
        .inputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_seven'))
        .inputs(ore('foilLeadFreeSolder'))
        .outputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_eight'))
        .EUt(VA[MV])
        .duration(400)
        .buildAndRegister()
    
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_one_hundred_fifty_eight', 'wafer.' + componentName + '.step_one_hundred_fifty_nine', 1, true)
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_one_hundred_fifty_nine', 'wafer.' + componentName + '.step_one_hundred_sixty', 400, MV) // Reflow solder to form bumps
    Packaging.generateBackgrindingRecipe('wafer.' + componentName + '.step_one_hundred_sixty', 'wafer.' + componentName + '.step_one_hundred_sixty_one', 400, MV) // Backgrinding to reduce wafer thickness for flip chip bonding
    Packaging.generateDicingRecipe('wafer.' + componentName + '.step_one_hundred_sixty_one', 'die.' + componentName, 64, 400, HV) // Dicing wafer into individual dies
    Packaging.generateWireBondingRecipe('die.' + componentName, 'die.' + componentName + '.bonded', 'gold', 50, HV)
}

generateCMOSFabrication('cmos_cpu') // Includes on die SRAM
generateCMOSFabrication('cmos_gpu')

/* Bipolar-CMOS-DMOS (BCD) process for power management ICs

// N+ buried layer (NBL) plus epitaxial P- layer for isolation of high voltage devices
Doping.generateIonImplantationRecipes('wafer.silicon.p_doped', 'wafer.bcd.step_one', 400, 'purified_antimony_trioxide')
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd.step_one', 'wafer.bcd.step_two', 1.0, 'p-type_silicon')

// HV twin well formation to allow for both NMOS and PMOS high voltage devices
Lithography.generateCoatingRecipe('wafer.bcd.step_two', 'methacrylate_resist', true) // Coat with photoresist for buried layer patterning

def generateBCDFabrication(String componentName) {

    // FEOL

    // Deep N-well formation for PMOS high voltage devices
    Lithography.generateSplitPhotolithographyRecipes('wafer.bcd.step_two', 'wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define DNW pattern
    Doping.generateIonImplantationRecipes('wafer.bcd.step_two', 'wafer.' + componentName + '.step_one', 800, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 1, true)

    // Deep P-well formation for NMOS high voltage devices
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define DPW pattern
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_six', 800, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_seven', 1, true)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 100) // Shared HV well drive ins

    // Deep trench isolation (DTI)
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_eight', 'wafer.' + componentName + '.step_nine', 400, true) // Pad oxide growth for STI/DTI patterning
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_nine', 'wafer.' + componentName + '.step_ten', 4.0, 'silicon_nitride.silane') // CMP stop layer
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_ten', 'wafer.' + componentName + '.step_eleven', 'methacrylate_resist', 'mask_set.' + componentName, true, true) // Define DTI pattern 
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_eleven', 'wafer.' + componentName + '.step_twelve', 'silicon_nitride', 400) // Etch through silicon nitride to expose silicon for trench etching
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twelve', 'wafer.' + componentName + '.step_thirteen', 'silicon_dioxide', 400) // Etch through pad oxide to expose silicon for trench etching
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_thirteen', 'wafer.' + componentName + '.step_fourteen', 'silicon_bosch', 4000) // DRIE into silicon to form DTI trenches
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_fourteen', 'wafer.' + componentName + '.step_fifteen', 1, true)
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_fifteen', 'wafer.' + componentName + '.step_sixteen', 400, false) // Trench liner
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixteen', 'wafer.' + componentName + '.step_seventeen', 4.0, 'silicon') // Trench fill, w/ polysilicon.
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_seventeen', 'wafer.' + componentName + '.step_eighteen', 'basic_cmp_slurry', 400, HV) // CMP to planarize wafer after trench fill
    
    // Shallow trench isolation (STI)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_eighteen', 'wafer.' + componentName + '.step_nineteen', 'methacrylate_resist', 'mask_set.' + componentName, true, true) // Define STI pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_nineteen', 'wafer.' + componentName + '.step_twenty', 'silicon_nitride', 400) // Etch through silicon nitride to expose silicon for trench etching
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty', 'wafer.' + componentName + '.step_twenty_one', 'silicon_dioxide', 400) // Etch through pad oxide to expose silicon for trench etching
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_one', 'wafer.' + componentName + '.step_twenty_two', 'silicon', 400) // Etch into silicon to form STI trenches
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twenty_two', 'wafer.' + componentName + '.step_twenty_three', 1, true)
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_twenty_three', 'wafer.' + componentName + '.step_twenty_four', 400, false) // Trench liner
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_twenty_four', 'wafer.' + componentName + '.step_twenty_five', 4.0, 'silicon_dioxide.teos') // SiO2 trench fill from TEOS

    // p-body formation for nLDMOS devices
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_five', 'wafer.' + componentName + '.step_twenty_six', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define p-body pattern for nLDMOS devices
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_twenty_six', 'wafer.' + componentName + '.step_twenty_seven', 400, 'boron_trifluoride')
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_twenty_seven', 'wafer.' + componentName + '.step_twenty_eight', 100)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twenty_eight', 'wafer.' + componentName + '.step_twenty_nine', 1, true)

    // CMOS well formation (N-well)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_nine', 'wafer.' + componentName + '.step_thirty', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define N-well pattern for PMOS devices
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty', 'wafer.' + componentName + '.step_thirty_one', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_one', 'wafer.' + componentName + '.step_thirty_two', 1, true)

    // CMOS well formation (P-well)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_thirty_two', 'wafer.' + componentName + '.step_thirty_three', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define P-well pattern for NMOS devices
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty_three', 'wafer.' + componentName + '.step_thirty_four', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_four', 'wafer.' + componentName + '.step_thirty_five', 1, true)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_thirty_five', 'wafer.' + componentName + '.step_thirty_six', 100) // Shared drive-in of NMOS/PMOS wells

    */

// Cheaper clock generator
