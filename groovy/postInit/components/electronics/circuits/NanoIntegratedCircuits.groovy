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

// Damascene copper BEOL

def generateBEOLProcess(String componentName, String resist, String starter, int beol_step, int iterations, boolean split = false) {
    def numberTab = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for (l in 1..iterations) {
        String input
        int beol_name = beol_step + l - 1
        if (l == 1) input = starter
        else input = 'wafer.' + componentName + '.beol_' + numberTab[beol_name - 1] + '.step_eight'

        if (split && l == 1) {
            Lithography.generateSplitPhotolithographyRecipes(input, 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_one', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_two', resist, 'mask_set.' + componentName, false) // Define via and trench pattern for each metal layer
        } else {
            Deposition.generateChemicalVaporDepositionRecipe(input, 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_one', 2.0, 'silicon_oxycarbide_hydride') // Deposit low-k dielectric
            Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_one', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_two', resist, 'mask_set.' + componentName, false) // Define via and trench pattern for each metal layer
        }
        
        Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_two', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_three', 'silicon_oxycarbide_hydride', 400) // Etch vias and trenches

        if (resist.endsWith('_trilayer')) {
            Lithography.generateSOCStrippingRecipes('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_three', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_four', 1, false) // Trilayer leaves an SOC/SiON hardmask rather than conventional resist
        } else {
            Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_three', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_four', 2, false, (resist == 'novolac_resist'))
        }

        Deposition.generateSputteringRecipe('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_four', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_five', ['tantalum_nitride' : 50]) // Barrier layer deposition for copper interconnects
        Deposition.generateSputteringRecipe('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_five', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_six', ['tantalum' : 100, 'copper' : 100]) // Adhesion layer for copper, seed layer

        ELECTROLYTIC_CELL.recipeBuilder()
            .notConsumable(fluid('copper_superfill_electrolyte') * 1000)
            .inputs(metaitem('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_six'))
            .inputs(ore('foilPhosphorizedCopper'))
            .outputs(metaitem('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_seven'))
            .EUt(VA[MV])
            .duration(400)
            .buildAndRegister()

        Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_seven', 'wafer.' + componentName + '.beol_' + numberTab[beol_name] + '.step_eight', 'basic_cmp_slurry', 400, HV) // CMP down to ILD level
    }
}

// Sealing and final packaging, flip chip
def generatePackaging(String componentName, String starter) {
    Deposition.generateChemicalVaporDepositionRecipe(starter, 'wafer.' + componentName + '.pkg.step_one', 400, 'silicon_dioxide.silane') // Passivation layer deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.pkg.step_one', 'wafer.' + componentName + '.pkg.step_two', 400, 'silicon_nitride.silane')
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.pkg.step_two', 'wafer.' + componentName + '.pkg.step_three', 'novolac_resist', 'mask_set.' + componentName, true) // Define contact hole pattern in passivation layers
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.pkg.step_three', 'wafer.' + componentName + '.pkg.step_four', 'silicon_nitride', 400, false) // Etch silicon nitride passivation layer
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.pkg.step_four', 'wafer.' + componentName + '.pkg.step_five', 'silicon_dioxide', 400, false) // Etch silicon dioxide passivation layer
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.pkg.step_five', 'wafer.' + componentName + '.pkg.step_six', 1, false)
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.pkg.step_six', 'wafer.' + componentName + '.pkg.step_seven', ['chromium' : 200, 'copper' : 200]) // Deposit under-bump metallization layers for solder bump attachment
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.pkg.step_seven', 'wafer.' + componentName + '.pkg.step_eight', 'novolac_resist', 'mask_set.' + componentName, false) // Define solder bump pattern

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('diluted_sulfuric_acid') * 4000)
        .notConsumable(fluid('copper_sulfate_solution') * 600)
        .inputs(metaitem('wafer.' + componentName + '.pkg.step_eight'))
        .inputs(ore('foilPhosphorizedCopper'))
        .outputs(metaitem('wafer.' + componentName + '.pkg.step_nine'))
        .EUt(VA[MV])
        .duration(400)
        .buildAndRegister()

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(fluid('methanesulfonic_acid') * 1000)
        .inputs(metaitem('wafer.' + componentName + '.pkg.step_nine'))
        .inputs(ore('foilLeadFreeSolder'))
        .outputs(metaitem('wafer.' + componentName + '.pkg.step_ten'))
        .EUt(VA[MV])
        .duration(400)
        .buildAndRegister()

    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.pkg.step_ten', 'wafer.' + componentName + '.pkg.step_eleven', 1, true)
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.pkg.step_eleven', 'wafer.' + componentName + '.pkg.step_twelve', 400, MV) // Reflow solder to form bumps
    Packaging.generateBackgrindingRecipe('wafer.' + componentName + '.pkg.step_twelve', 'wafer.' + componentName + '.pkg.step_thirteen', 400, MV) // Backgrinding to reduce wafer thickness for flip chip bonding
    Packaging.generateDicingRecipe('wafer.' + componentName + '.pkg.step_thirteen', 'die.' + componentName, 64, 400, HV) // Dicing wafer into individual dies
    Packaging.generateWireBondingRecipe('die.' + componentName, 'die.' + componentName + '.bonded', 'gold', 50, HV)
}

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

Deposition.generateSiliconDioxideGrowthRecipe('wafer.silicon.p_doped', 'wafer.cmos_base.step_one', 400, true) // Protecting layer for P/NMOS well formation
Deposition.generateChemicalVaporDepositionRecipe('wafer.cmos_base.step_one', 'wafer.cmos_base.step_two', 2.0, 'silicon_nitride.silane') // CMP stop layer for STI formation
Lithography.generateCoatingRecipe('wafer.cmos_base.step_two', 'methacrylate_resist', true) // Coat with photoresist for STI patterning

def generateCMOSFabrication(String componentName) {
    def numberTab = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'] // define it here since otherwise it breaks??
    // FEOL
    
    // Shallow trench isolation
    Lithography.generateSplitPhotolithographyRecipes('wafer.cmos_base.step_two', 'wafer.' + componentName + '.step_two', 'wafer.' + componentName + '.step_three', 'methacrylate_resist', 'mask_set.' + componentName, true) // Define STI pattern
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
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_twenty_three', 'wafer.' + componentName + '.step_twenty_four', 'methacrylate_resist_trilayer', 'mask_set.' + componentName, true) // Define gate pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_four', 'wafer.' + componentName + '.step_twenty_five', 'silicon_nitride', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_five', 'wafer.' + componentName + '.step_twenty_six', 'silicon', 400)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_twenty_six', 'wafer.' + componentName + '.step_twenty_seven', 'hafnium_dioxide', 400)
    Lithography.generateSOCStrippingRecipes('wafer.' + componentName + '.step_twenty_seven', 'wafer.' + componentName + '.step_twenty_eight', 1, true)

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
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_thirty_seven', 'wafer.' + componentName + '.step_thirty_eight', 'silicon_nitride', 400) // Blanket anisotropic etch forms spacers, no patterning required

    // PMOS compressive strain engineering with SiGe
    Deposition.generateSiliconDioxideGrowthRecipe('wafer.' + componentName + '.step_thirty_eight', 'wafer.' + componentName + '.step_thirty_nine', 400, false)
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_thirty_nine', 'wafer.' + componentName + '.step_forty', 'methacrylate_resist', 'mask_set.' + componentName, true) // Protect NMOS while etching PMOS source/drain areas
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_forty', 'wafer.' + componentName + '.step_forty_one', 'silicon_dioxide', 400) // Anisotropic etch to expose PMOS source/drain areas
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_forty_one', 'wafer.' + componentName + '.step_forty_two', 1, true)
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_forty_two', 'wafer.' + componentName + '.step_forty_three', 'silicon', 400) // Etch into silicon to form recesses for SiGe deposition
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_forty_three', 'wafer.' + componentName + '.step_forty_four', 1.0, 'silicon_germanium') // Epitaxial deposition of SiGe in PMOS source/drain recesses
    Doping.generateIonImplantationRecipes('wafer.' + componentName + '.step_forty_four', 'wafer.' + componentName + '.step_forty_five', 400, 'boron_trifluoride') // Dope SiGe for good ohmic contact
    Doping.generateDriveInRecipe('wafer.' + componentName + '.step_forty_five', 'wafer.' + componentName + '.step_forty_six', 100) // Drive in dopants in SiGe

    // Nickel salicide process for contact formation
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_forty_six', 'wafer.' + componentName + '.step_forty_seven', ['nickel' : 120, 'platinum' : 5]) // Deposit nickel for silicidation, platinum is added to improve thermal stability of silicide
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_forty_seven', 'wafer.' + componentName + '.step_forty_eight', 100, MV) // Anneal to form initial Ni2Si silicide phase for etch resistance
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_forty_eight', 'wafer.' + componentName + '.step_forty_nine', 'nickel_silicide', 100, false) // Etch away unreacted nickel silicide w/ H3PO4
    Deposition.generateSinteringRecipe('wafer.' + componentName + '.step_forty_nine', 'wafer.' + componentName + '.step_fifty', 400, HV) // High temperature anneal to transform Ni2Si into low resistivity NiSi

    // T-CESL for NMOS strain engineering, interlayer dielectric.
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_fifty', 'wafer.' + componentName + '.step_fifty_one', 1.0, 'silicon_nitride.silane') // T-CESL
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fifty_one', 'wafer.' + componentName + '.step_fifty_two', 'methacrylate_resist', 'mask_set.' + componentName, true) // Remove T-CESL from PMOS areas
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_fifty_two', 'wafer.' + componentName + '.step_fifty_three', 'silicon_nitride', 400)
    Lithography.generateResistStrippingRecipes('wafer.' + componentName + '.step_fifty_three', 'wafer.' + componentName + '.step_fifty_four', 1, true)
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_fifty_four', 'wafer.' + componentName + '.step_fifty_five', 2.0, 'silicon_dioxide.teos') // Interlayer dielectric

    // Gate formation
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_fifty_five', 'wafer.' + componentName + '.step_fifty_six', 'basic_cmp_slurry', 400, HV) // CMP to planarize down to dummy gate hardmask
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty_six', 'wafer.' + componentName + '.step_fifty_seven', 'silicon_nitride', 400, false) // Etch hardmask
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_fifty_seven', 'wafer.' + componentName + '.step_fifty_eight', 'silicon', 400, true) // TMAH etch of dummy gate
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_fifty_eight', 'wafer.' + componentName + '.step_fifty_nine', 0.1, 'titanium_nitride') // Deposit PMOS workfunction metal
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_fifty_nine', 'wafer.' + componentName + '.step_sixty', 'methacrylate_resist_trilayer', 'mask_set.' + componentName, true) // Mask PMOS areas to implant NMOS workfunction metal
    Etching.generateWetEtchingRecipe('wafer.' + componentName + '.step_sixty', 'wafer.' + componentName + '.step_sixty_one', 'titanium_nitride', 400, false) // Etch titanium nitride from PMOS areas
    Lithography.generateSOCStrippingRecipes('wafer.' + componentName + '.step_sixty_one', 'wafer.' + componentName + '.step_sixty_two', 1, true)
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_sixty_two', 'wafer.' + componentName + '.step_sixty_three', 0.1, 'titanium_aluminide') // Deposit PMOS/NMOS workfunction metal
    Deposition.generateSputteringRecipe('wafer.' + componentName + '.step_sixty_three', 'wafer.' + componentName + '.step_sixty_four', 400, 'aluminium') // Deposit aluminium gate fill
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_sixty_four', 'wafer.' + componentName + '.step_sixty_five', 'basic_cmp_slurry', 400, HV) // CMP to planarize down to gate level
    
    // ILD0/Plug formation
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixty_five', 'wafer.' + componentName + '.step_sixty_six', 2.0, 'silicon_nitride.silane') // Deposit etch stop layer
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_sixty_six', 'wafer.' + componentName + '.step_sixty_seven', 2.0, 'borophosphosilicate_glass') // Deposit interlayer dielectric
    Lithography.generatePhotolithographyRecipes('wafer.' + componentName + '.step_sixty_seven', 'wafer.' + componentName + '.step_sixty_eight', 'methacrylate_resist_trilayer', 'mask_set.' + componentName, true) // Define plug pattern
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_sixty_eight', 'wafer.' + componentName + '.step_sixty_nine', 'borophosphosilicate_glass', 400) // CH3F
    Etching.generateReactiveIonEtchingRecipe('wafer.' + componentName + '.step_sixty_nine', 'wafer.' + componentName + '.step_seventy', 'silicon_nitride', 400) // CH3F
    Lithography.generateSOCStrippingRecipes('wafer.' + componentName + '.step_seventy', 'wafer.' + componentName + '.step_seventy_one', 1, false)
    Deposition.generateAtomicLayerDepositionRecipe('wafer.' + componentName + '.step_seventy_one', 'wafer.' + componentName + '.step_seventy_two', 0.1, 'titanium_nitride') // Barrier layer deposition for tungsten plugs
    Deposition.generateChemicalVaporDepositionRecipe('wafer.' + componentName + '.step_seventy_two', 'wafer.' + componentName + '.step_seventy_three', 4.0, 'tungsten') // Tungsten hexafluoride plug fill
    Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.' + componentName + '.step_seventy_three', 'wafer.' + componentName + '.step_seventy_four', 'oxidative_cmp_slurry', 400, HV) // CMP to planarize down to ILD level

    // BEOL resist definition
    generateBEOLProcess(componentName, 'methacrylate_resist_trilayer', 'wafer.' + componentName + '.step_seventy_four', 1, 3)
    generateBEOLProcess(componentName, 'polyhydroxystyrene_resist_trilayer', 'wafer.' + componentName + '.beol_three.step_eight', 4, 3)
    generateBEOLProcess(componentName, 'novolac_resist', 'wafer.' + componentName + '.beol_six.step_eight', 7, 3)

    // Sealing and final packaging, flip chip.
    generatePackaging(componentName, 'wafer.' + componentName + '.beol_nine.step_eight')
}

generateCMOSFabrication('cmos_cpu') // Includes on die SRAM
generateCMOSFabrication('cmos_gpu')

//Bipolar-CMOS-DMOS (BCD) process for power management ICs, ~180nm process.

// N+ buried layer (NBL) plus epitaxial P- layer for isolation of high voltage devices
Doping.generateIonImplantationRecipes('wafer.silicon.p_doped', 'wafer.bcd_base.step_one', 400, 'purified_antimony_trioxide')
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_one', 'wafer.bcd_base.step_two', 1.0, 'p-type_silicon')

// FEOL

// HV twin well formation to allow for both NMOS and PMOS high voltage devices
// Deep N-well formation for PMOS high voltage devices
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_two', 'wafer.bcd_base.step_three', 'novolac_resist', 'mask_set.bcd_base', true) // Define DNW pattern
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_three', 'wafer.bcd_base.step_four', 800, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_four', 'wafer.bcd_base.step_five', 1, true)

// Deep P-well formation for NMOS high voltage devices
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_five', 'wafer.bcd_base.step_six', 'novolac_resist', 'mask_set.bcd_base', true) // Define DPW pattern
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_six', 'wafer.bcd_base.step_seven', 800, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_seven', 'wafer.bcd_base.step_eight', 1, true)
Doping.generateDriveInRecipe('wafer.bcd_base.step_eight', 'wafer.bcd_base.step_nine', 100) // Shared HV well drive ins

// Deep trench isolation (DTI)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.bcd_base.step_nine', 'wafer.bcd_base.step_ten', 400, true) // Pad oxide growth for STI/DTI patterning
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_ten', 'wafer.bcd_base.step_eleven', 4.0, 'silicon_nitride.silane') // CMP stop layer
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_eleven', 'wafer.bcd_base.step_twelve', 'polyhydroxystyrene_resist_trilayer', 'mask_set.bcd_base', true, true) // Define DTI pattern
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_twelve', 'wafer.bcd_base.step_thirteen', 'silicon_nitride', 400) // Etch through silicon nitride to expose silicon for trench etching
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_thirteen', 'wafer.bcd_base.step_fourteen', 'silicon_dioxide', 400) // Etch through pad oxide to expose silicon for trench etching
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_fourteen', 'wafer.bcd_base.step_fifteen', 'silicon_bosch', 4000) // DRIE into silicon to form DTI trenches
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_fifteen', 'wafer.bcd_base.step_sixteen', 400, 'boron_trifluoride') // Field stop implantation to reduce leakage current between DTI trenches
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_sixteen', 'wafer.bcd_base.step_seventeen', 1, true)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.bcd_base.step_seventeen', 'wafer.bcd_base.step_eighteen', 400, false) // Trench liner
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_eighteen', 'wafer.bcd_base.step_nineteen', 4.0, 'silicon') // Trench fill, w/ polysilicon.
Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.bcd_base.step_nineteen', 'wafer.bcd_base.step_twenty', 'basic_cmp_slurry', 400, HV) // CMP to planarize wafer after trench fill

// Shallow trench isolation (STI)
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_twenty', 'wafer.bcd_base.step_twenty_one', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', false) // Define STI pattern
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_twenty_one', 'wafer.bcd_base.step_twenty_two', 'silicon_nitride', 400) // Etch through silicon nitride to expose silicon for trench etching
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_twenty_two', 'wafer.bcd_base.step_twenty_three', 'silicon_dioxide', 400) // Etch through pad oxide to expose silicon for trench etching
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_twenty_three', 'wafer.bcd_base.step_twenty_four', 'silicon', 400) // Etch into silicon to form STI trenches
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_twenty_four', 'wafer.bcd_base.step_twenty_five', 1, true)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.bcd_base.step_twenty_five', 'wafer.bcd_base.step_twenty_six', 400, false) // Trench liner
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_twenty_six', 'wafer.bcd_base.step_twenty_seven', 4.0, 'silicon_dioxide.teos') // SiO2 trench fill from TEOS

// p-body formation for nLDMOS devices
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_twenty_seven', 'wafer.bcd_base.step_twenty_eight', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define p-body pattern for nLDMOS devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_twenty_eight', 'wafer.bcd_base.step_twenty_nine', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_twenty_nine', 'wafer.bcd_base.step_thirty', 1, true)
Doping.generateDriveInRecipe('wafer.bcd_base.step_thirty', 'wafer.bcd_base.step_thirty_one', 100)

// LV/MV well formation and VT adjust
// CMOS well formation (N-well)
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_thirty_one', 'wafer.bcd_base.step_thirty_two', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define N-well pattern for PMOS devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_thirty_two', 'wafer.bcd_base.step_thirty_three', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_thirty_three', 'wafer.bcd_base.step_thirty_four', 1, true)

// CMOS well formation (P-well)
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_thirty_four', 'wafer.bcd_base.step_thirty_five', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define P-well pattern for NMOS devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_thirty_five', 'wafer.bcd_base.step_thirty_six', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_thirty_six', 'wafer.bcd_base.step_thirty_seven', 1, true)
Doping.generateDriveInRecipe('wafer.bcd_base.step_thirty_seven', 'wafer.bcd_base.step_thirty_eight', 100) // Shared drive-in of NMOS/PMOS wells

// Twin gate oxide formation
// Thick oxide formation for HV devices
Deposition.generateSiliconDioxideGrowthRecipe('wafer.bcd_base.step_thirty_eight', 'wafer.bcd_base.step_thirty_nine', 400, false) // Grow initial thick gate oxide for HV devices
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_thirty_nine', 'wafer.bcd_base.step_forty', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define thick gate oxide pattern for HV devices
Etching.generateWetEtchingRecipe('wafer.bcd_base.step_forty', 'wafer.bcd_base.step_forty_one', 'silicon_dioxide', 400, false) // Etch away thick gate oxide from LV/MV device areas
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_forty_one', 'wafer.bcd_base.step_forty_two', 1, false)
Deposition.generateSiliconDioxideGrowthRecipe('wafer.bcd_base.step_forty_two', 'wafer.bcd_base.step_forty_three', 400, false) // Grow thin gate oxide for LV/MV devices, continue growth of thick gate oxide for HV devices
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_forty_three', 'wafer.bcd_base.step_forty_four', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define thin gate oxide pattern for LV/MV devices
Etching.generateWetEtchingRecipe('wafer.bcd_base.step_forty_four', 'wafer.bcd_base.step_forty_five', 'silicon_dioxide', 400, false) // Etch away non-gate oxide silicon dioxide
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_forty_five', 'wafer.bcd_base.step_forty_six', 1, false)

// Polysilicon gate formation
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_forty_six', 'wafer.bcd_base.step_forty_seven', 3.0, 'silicon') // Polysilicon gate deposition
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_forty_seven', 'wafer.bcd_base.step_forty_eight', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define gate pattern for all devices
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_forty_eight', 'wafer.bcd_base.step_forty_nine', 'silicon', 400) // Etch polysilicon gates
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_forty_nine', 'wafer.bcd_base.step_fifty', 1, true)

// Extension implantation for LV/MV devices (also known as lightly doped drain or LDD)
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_fifty', 'wafer.bcd_base.step_fifty_one', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define source/drain pattern for LV/MV devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_fifty_one', 'wafer.bcd_base.step_fifty_two', 100, 'boron_trifluoride') // PMOS extension implantation
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_fifty_two', 'wafer.bcd_base.step_fifty_three', 1, true)
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_fifty_three', 'wafer.bcd_base.step_fifty_four', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define source/drain pattern for LV/MV devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_fifty_four', 'wafer.bcd_base.step_fifty_five', 100, 'phosphine') // NMOS extension implantation
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_fifty_five', 'wafer.bcd_base.step_fifty_six', 1, true)

// Si3N4 spacer formation
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_fifty_six', 'wafer.bcd_base.step_fifty_seven', 1.0, 'silicon_nitride.silane') // Si3N4 spacer deposition
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_fifty_seven', 'wafer.bcd_base.step_fifty_eight', 'silicon_nitride', 400) // Anisotropic etch to form spacers

// Source/drain implantation
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_fifty_eight', 'wafer.bcd_base.step_fifty_nine', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define source/drain pattern for LV/MV devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_fifty_nine', 'wafer.bcd_base.step_sixty', 400, 'boron_trifluoride')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_sixty', 'wafer.bcd_base.step_sixty_one', 1, true)
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_sixty_one', 'wafer.bcd_base.step_sixty_two', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define source/drain pattern for LV/MV devices
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_sixty_two', 'wafer.bcd_base.step_sixty_three', 400, 'phosphine')
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_sixty_three', 'wafer.bcd_base.step_sixty_four', 1, true)

// Cobalt salicide process for contact formation
Deposition.generateSputteringRecipe('wafer.bcd_base.step_sixty_four', 'wafer.bcd_base.step_sixty_five', ['cobalt' : 100]) // Deposit cobalt for silicidation
Deposition.generateSinteringRecipe('wafer.bcd_base.step_sixty_five', 'wafer.bcd_base.step_sixty_six', 100, MV) // Anneal to form initial Co2Si/CoSi silicide phase for etch resistance
Etching.generateWetEtchingRecipe('wafer.bcd_base.step_sixty_six', 'wafer.bcd_base.step_sixty_seven', 'cobalt_silicide', 100, false) // Etch away unreacted cobalt silicide w/ H3PO4
Deposition.generateSinteringRecipe('wafer.bcd_base.step_sixty_seven', 'wafer.bcd_base.step_sixty_eight', 400, HV) // High temperature anneal to transform Co2Si/CoSi into low resistivity CoSi2

// Polysilicon resistor formation
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_sixty_eight', 'wafer.bcd_base.step_sixty_nine', 0.1, 'silicon') // Polysilicon resistor deposition
Doping.generateIonImplantationRecipes('wafer.bcd_base.step_sixty_nine', 'wafer.bcd_base.step_seventy', 100, 'phosphine') // Lightly n-dope polysilicon resistor for low resistance
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_seventy', 'wafer.bcd_base.step_seventy_one', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define polysilicon resistor pattern
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_seventy_one', 'wafer.bcd_base.step_seventy_two', 'silicon', 400) // Etch polysilicon resistors
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_seventy_two', 'wafer.bcd_base.step_seventy_three', 1, true)

// ILD0/Plug formation
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_seventy_three', 'wafer.bcd_base.step_seventy_four', 2.0, 'silicon_nitride.silane') // Deposit etch stop layer
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_seventy_four', 'wafer.bcd_base.step_seventy_five', 2.0, 'borophosphosilicate_glass') // Deposit interlayer dielectric
Lithography.generatePhotolithographyRecipes('wafer.bcd_base.step_seventy_five', 'wafer.bcd_base.step_seventy_six', 'polyhydroxystyrene_resist', 'mask_set.bcd_base', true) // Define plug pattern
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_seventy_six', 'wafer.bcd_base.step_seventy_seven', 'borophosphosilicate_glass', 400) // CH3F
Etching.generateReactiveIonEtchingRecipe('wafer.bcd_base.step_seventy_seven', 'wafer.bcd_base.step_seventy_eight', 'silicon_nitride', 400) // CH3F
Lithography.generateResistStrippingRecipes('wafer.bcd_base.step_seventy_eight', 'wafer.bcd_base.step_seventy_nine', 1, true)
Deposition.generateAtomicLayerDepositionRecipe('wafer.bcd_base.step_seventy_nine', 'wafer.bcd_base.step_eighty', 0.1, 'titanium_nitride') // Barrier layer deposition for tungsten plugs
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.step_eighty', 'wafer.bcd_base.step_eighty_one', 4.0, 'tungsten') // Tungsten hexafluoride plug fill
Mechanicals.generateChemicalMechanicalPolishingRecipe('wafer.bcd_base.step_eighty_one', 'wafer.bcd_base.step_eighty_two', 'oxidative_cmp_slurry', 400, HV) // CMP to planarize down to ILD level

// BEOL/MIM capacitor formation

// Shared metallization layers
generateBEOLProcess('bcd_base', 'polyhydroxystyrene_resist_trilayer', 'wafer.bcd_base.step_eighty_two', 1, 2)
generateBEOLProcess('bcd_base', 'novolac_resist', 'wafer.bcd_base.beol_two.step_eight', 3, 1)

// M4 BCD branchpoint
Deposition.generateChemicalVaporDepositionRecipe('wafer.bcd_base.beol_three.step_eight', 'wafer.bcd_base.beol_four.step_one', 2.0, 'silicon_oxycarbide_hydride')
Lithography.generateCoatingRecipe('wafer.bcd_base.beol_four.step_one', 'novolac_resist', true)

generateBEOLProcess('bcd_lpic', 'novolac_resist', 'wafer.bcd_base.beol_four.step_one', 4, 1, true)
generateBEOLProcess('bcd_pic', 'novolac_resist', 'wafer.bcd_base.beol_four.step_one', 4, 2, true)
generateBEOLProcess('bcd_hpic', 'novolac_resist', 'wafer.bcd_base.beol_four.step_one', 4, 3, true)

generatePackaging('bcd_lpic', 'wafer.bcd_lpic.beol_four.step_eight')
generatePackaging('bcd_pic', 'wafer.bcd_pic.beol_five.step_eight')
generatePackaging('bcd_hpic', 'wafer.bcd_hpic.beol_six.step_eight')

// Cheaper clock generator
