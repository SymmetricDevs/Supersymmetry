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
Deposition.generateChemicalVaporDepositionRecipe('wafer.cmos.step_one', 'wafer.cmos.step_two', 400, 'silicon_nitride.silane') // CMP stop layer for STI formation

def generateCMOSFabrication(String componentName, int circ) {
    // Lookup table for int to string conversion
    def numberTab = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']

    // FEOL
    
    // Shallow trench isolation
    Lithography.generatePhotolithographyRecipes('wafer.cmos.step_two', 'wafer.' + componentName + '.step_three', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Define STI pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_three', 'wafer.' + componentName + '.step_four', 'silicon_nitride', 400) // Etch into silicon to form trenches
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_four', 'wafer.' + componentName + '.step_five', 'silicon_dioxide', 400)
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 'silicon', 400, false)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_five', 'wafer.' + componentName + '.step_six', 1, true)
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_six', 'wafer.' + componentName + '.step_seven', 400, true) // Protective oxide growth after trench etching to repair etch damage
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_seven', 'wafer.' + componentName + '.step_eight', 400, 'silicon_dioxide.teos') // Fill trenches, TEOS has better gap-filling properties
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_eight', 'wafer.' + componentName + '.step_nine', 400, HV) // CMP to planarize wafer
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_nine', 'wafer.' + componentName + '.step_ten', 'silicon_nitride', 400, false) // Etch away silicon nitride CMP stop layer

    // NMOS well formation
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_ten', 'wafer.' + componentName + '.step_eleven', 'acrylate_resist_mixture', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_eleven', 'wafer.' + componentName + '.step_twelve', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twelve', 'wafer.' + componentName + '.step_thirteen', 1, true)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_thirteen', 'wafer.' + componentName + '.step_fourteen', 100)

    // PMOS well formation
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fourteen', 'wafer.' + componentName + '.step_fifteen', 'acrylate_resist_mixture', 'mask_set.' + componentName, true)
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_fifteen', 'wafer.' + componentName + '.step_sixteen', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_sixteen', 'wafer.' + componentName + '.step_seventeen', 1, true)
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_seventeen', 'wafer.' + componentName + '.step_eighteen', 100)

    // Dummy gate formation
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_eighteen', 'wafer.' + componentName + '.step_nineteen', 'silicon_dioxide', 400, false) // Remove protective oxide layer to expose silicon surface for gate formation
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_nineteen', 'wafer.' + componentName + '.step_twenty', 400, false) // Grow SiO2 interfacial layer for HfO2
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_twenty', 'wafer.' + componentName + '.step_twenty_one', 400, 'hafnium_dioxide') // Gate oxide deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_twenty_one', 'wafer.' + componentName + '.step_twenty_two', 400, 'silicon') // Grow dummy gate
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_twenty_two', 'wafer.' + componentName + '.step_twenty_three', 400, 'silicon_nitride.silane') // Hard mask layer for dummy gate
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_three', 'wafer.' + componentName + '.step_twenty_four', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Define gate pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_four', 'wafer.' + componentName + '.step_twenty_five', 'silicon_nitride', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_five', 'wafer.' + componentName + '.step_twenty_six', 'silicon', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_six', 'wafer.' + componentName + '.step_twenty_seven', 'hafnium_dioxide', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_twenty_seven', 'wafer.' + componentName + '.step_twenty_eight', 1, true)

    // Halo and extension implantation (NMOS)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_eight', 'wafer.' + componentName + '.step_twenty_nine', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Define source/drain pattern for NMOS to form halo and extension implants
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_twenty_nine', 'wafer.' + componentName + '.step_thirty', 400, 'phosphine')
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty', 'wafer.' + componentName + '.step_thirty_one', 400, 'boron_trifluoride')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_one', 'wafer.' + componentName + '.step_thirty_two', 1, true)

    // Halo and extension implantation (PMOS)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_thirty_two', 'wafer.' + componentName + '.step_thirty_three', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Define source/drain pattern for PMOS to form halo and extension implants
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty_three', 'wafer.' + componentName + '.step_thirty_four', 400, 'boron_trifluoride')
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_thirty_four', 'wafer.' + componentName + '.step_thirty_five', 400, 'phosphine')
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_five', 'wafer.' + componentName + '.step_thirty_six', 1, true)

    // Spacer formation, reduces short channel effects, parasitic capacitances, strain engineering for NMOS.
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_thirty_six', 'wafer.' + componentName + '.step_thirty_seven', 400, 'silicon_nitride.silane') // NOTE: original line specified TEOS for silicon nitride but this doesn't make sense?
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_thirty_seven', 'wafer.' + componentName + '.step_thirty_eight', 'acrylate_resist_mixture', 'mask_set.' + componentName, true)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_thirty_eight', 'wafer.' + componentName + '.step_thirty_nine', 'silicon_nitride', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_thirty_eight', 'wafer.' + componentName + '.step_thirty_nine', 1, true)

    // PMOS compressive strain engineering with SiGe
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_thirty_nine', 'wafer.' + componentName + '.step_forty', 400, false)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_forty', 'wafer.' + componentName + '.step_forty_one', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Protect NMOS while etching PMOS source/drain areas
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_forty_one', 'wafer.' + componentName + '.step_forty_two', 'silicon_dioxide', 400) // Anisotropic etch to expose PMOS source/drain areas
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_forty_two', 'wafer.' + componentName + '.step_forty_three', 1, true)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_forty_three', 'wafer.' + componentName + '.step_forty_four', 'silicon', 400) // Etch into silicon to form recesses for SiGe deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_forty_four', 'wafer.' + componentName + '.step_forty_five', 400, 'silicon_germanium') // Epitaxial deposition of SiGe in PMOS source/drain recesses
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_forty_five', 'wafer.' + componentName + '.step_forty_six', 400, 'boron_trifluoride') // Dope SiGe for good ohmic contact
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_forty_six', 'wafer.' + componentName + '.step_forty_seven', 100) // Drive in dopants in SiGe

    // Nickel salicide process for contact formation
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_forty_seven', 'wafer.' + componentName + '.step_forty_eight', ['nickel' : 480, 'platinum' : 20]) // Deposit nickel for silicidation, platinum is added to improve thermal stability of silicide
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_forty_eight', 'wafer.' + componentName + '.step_forty_nine', 100, MV) // Anneal to form initial Ni2Si silicide phase for etch resistance
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_forty_nine', 'wafer.' + componentName + '.step_fifty', 'nickel_silicide', 400, false) // Etch away unreacted nickel: H2SO4, H2O2.
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_fifty', 'wafer.' + componentName + '.step_fifty_one', 400, HV) // High temperature anneal to transform Ni2Si into low resistivity NiSi

    // T-CESL for NMOS strain engineering, interlayer dielectric.
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_fifty_one', 'wafer.' + componentName + '.step_fifty_two', 400, 'silicon_nitride.silane') // T-CESL
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fifty_two', 'wafer.' + componentName + '.step_fifty_three', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Remove T-CESL from PMOS areas
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_fifty_three', 'wafer.' + componentName + '.step_fifty_four', 'silicon_nitride', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_fifty_four', 'wafer.' + componentName + '.step_fifty_five', 1, true)
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_fifty_five', 'wafer.' + componentName + '.step_fifty_six', 400, 'silicon') // Interlayer dielectric

    // Gate formation
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_fifty_six', 'wafer.' + componentName + '.step_fifty_seven', 400, HV) // CMP to planarize down to dummy gate hardmask
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty_seven', 'wafer.' + componentName + '.step_fifty_eight', 'silicon_nitride', 400, false) // Etch hardmask
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty_eight', 'wafer.' + componentName + '.step_fifty_nine', 'silicon', 400, true) // TMAH etch of dummy gate
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_fifty_nine', 'wafer.' + componentName + '.step_sixty', 400, 'titanium_nitride') // Deposit PMOS workfunction metal
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_sixty', 'wafer.' + componentName + '.step_sixty_one', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Mask PMOS areas to implant NMOS workfunction metal
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_sixty_one', 'wafer.' + componentName + '.step_sixty_two', 'titanium_nitride', 400, false) // Etch titanium nitride from PMOS areas
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_sixty_two', 'wafer.' + componentName + '.step_sixty_three', 1, false)
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_sixty_three', 'wafer.' + componentName + '.step_sixty_four', 400, 'titanium_aluminide') // Deposit PMOS/NMOS workfunction metal
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_sixty_four', 'wafer.' + componentName + '.step_sixty_five', 400, 'aluminium') // Deposit aluminium gate fill
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_sixty_five', 'wafer.' + componentName + '.step_sixty_six', 400, HV) // CMP to planarize down to gate level
    
    // Plug formation
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixty_six', 'wafer.' + componentName + '.step_sixty_seven', 400, 'silicon_nitride.silane') // Deposit CMP stop layer
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixty_seven', 'wafer.' + componentName + '.step_sixty_eight', 400, 'silicon_dioxide.silane') // Deposit interlayer dielectric
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_sixty_eight', 'wafer.' + componentName + '.step_sixty_nine', 'acrylate_resist_mixture', 'mask_set.' + componentName, true) // Define plug pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_sixty_nine', 'wafer.' + componentName + '.step_seventy', 'silicon_dioxide', 400) // CH3F
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_seventy', 'wafer.' + componentName + '.step_seventy_one', 'silicon_nitride', 400) // CH3F
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_seventy_one', 'wafer.' + componentName + '.step_seventy_two', 1, true)
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_seventy_two', 'wafer.' + componentName + '.step_seventy_three', 400, 'titanium_aluminide') // Barrier layer deposition for tungsten plugs
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_seventy_three', 'wafer.' + componentName + '.step_seventy_four', 400, 'tungsten') // Tungsten hexafluoride plug fill
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_seventy_four', 'wafer.' + componentName + '.step_seventy_five', 400, HV) // CMP to planarize down to ILD level

    // Damascene copper BEOL, 9 layers
    
    for (l in 1..9) {
        String input
        if (l == 1) input = 'wafer.' + componentName + '.step_seventy_five'
        else input = 'wafer.' + componentName + '.beol_' + numberTab[l-1] + '.step_seven'
        def resist = l <= 3 ? 'acrylate_resist_mixture' : (l <= 6 ? 'polyhydroxystyrene_resist' : 'novolac_resist')

        Deposition.generateChemicalVaporDepositionRecipe(input, 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_one', 400, 'fluorosilicate_glass') // Deposit low-k dielectric
        Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_one', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_two', resist, 'mask_set.' + componentName, true) // Define via and trench pattern for each metal layer
        Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_two', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_three', 'silicon_dioxide', 400) // Etch vias and trenches
        Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_two', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_three', 1, false, (resist == 'novolacs_resist'))
        Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_three', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_four', 400, 'tantalum_nitride') // Barrier layer deposition for copper interconnects
        Deposition.generateSputteringRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_four', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_five', ['tantalum' : 100, 'copper' : 100]) // Adhesion layer for copper, seed layer

        ELECTROLYTIC_CELL.recipeBuilder()
            .notConsumable(fluid('copper_superfill_electrolyte') * 1000)
            .inputs(metaitem('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_five'))
            .inputs(ore('foilPhosphorizedCopper'))
            .outputs(metaitem('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_six'))
            .EUt(VA[MV])
            .duration(400)
            .buildAndRegister()

        Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.beol_' + numberTab[l] + '.step_six', 'wafer.' + componentName + '.beol_' + numberTab[l] + '.step_seven', 400, HV) // CMP down to ILD level
    }

    // Sealing and final packaging, flip chip.

    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.beol_nine.step_seven', 'wafer.' + componentName + '.step_one_hundred_forty_eight', 400, 'silicon_dioxide.silane') // Passivation layer deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_one_hundred_forty_eight', 'wafer.' + componentName + '.step_one_hundred_forty_nine', 400, 'silicon_nitride.silane')
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_one_hundred_forty_nine', 'wafer.' + componentName + '.step_one_hundred_fifty', 'novolac_resist', 'mask_set.' + componentName, true) // Define contact hole pattern in passivation layers
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_one_hundred_fifty', 'wafer.' + componentName + '.step_one_hundred_fifty_one', 'silicon_nitride', 400, false) // Etch silicon nitride passivation layer
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_one_hundred_fifty_one', 'wafer.' + componentName + '.step_one_hundred_fifty_two', 'silicon_dioxide', 400, false) // Etch silicon dioxide passivation layer
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_one_hundred_fifty_two', 'wafer.' + componentName + '.step_one_hundred_fifty_three', 1, false)
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_one_hundred_fifty_three', 'wafer.' + componentName + '.step_one_hundred_fifty_four', ['chromium' : 200, 'copper' : 200]) // Deposit under-bump metallization layers for solder bump attachment
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_one_hundred_fifty_four', 'wafer.' + componentName + '.step_one_hundred_fifty_five', 'novolac_resist', 'mask_set.' + componentName, true) // Define solder bump pattern

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('diluted_sulfuric_acid') * 4000)
        .notConsumable(fluid('copper_sulfate_solution') * 600)
        .inputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_five'))
        .inputs(ore('foilPhosphorizedCopper'))
        .outputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_six'))
        .EUt(VA[MV])
        .duration(400)
        .buildAndRegister()

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('methanesulfonic_acid') * 1000)
        .inputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_six'))
        .inputs(ore('foilLeadFreeSolder'))
        .outputs(metaitem('wafer.' + componentName + '.step_one_hundred_fifty_seven'))
        .EUt(VA[MV])
        .duration(400)
        .buildAndRegister()
    
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_one_hundred_fifty_seven', 'wafer.' + componentName + '.step_one_hundred_fifty_eight', 1, true)
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_one_hundred_fifty_eight', 'wafer.' + componentName + '.step_one_hundred_fifty_nine', 400, MV) // Reflow solder to form bumps
    Packaging.generateBackgrindingRecipe('wafer.' + componentName + '.step_one_hundred_fifty_nine', 'wafer.' + componentName + '.step_one_hundred_sixty', 400, MV) // Backgrinding to reduce wafer thickness for flip chip bonding
    Packaging.generateDicingRecipe('wafer.' + componentName + '.step_one_hundred_sixty', 'die.' + componentName, 64, 400, HV) // Dicing wafer into individual dies
    Packaging.generateWireBondingRecipe('die.' + componentName, 'die.' + componentName + '.bonded', 'gold', 50, HV)
}

generateCMOSFabrication('cmos_cpu', 1)
