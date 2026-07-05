package globals.semiconductors
import globals.Globals

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

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

class Etching {

    static class Etchant {
        Map fluidArr = [:]
        Map wasteArr = [:]
        int voltageTier
        int amountUsed
        double etchingRate
        boolean anisotropic
        boolean isPlasma

        Etchant(String fluidName, String wasteName, int voltageTier, int amountUsed, double etchingRate, boolean anisotropic, boolean isPlasma) {
            this.fluidArr = [(fluidName): amountUsed]
            this.wasteArr = [(wasteName): amountUsed]
            this.voltageTier = voltageTier
            this.etchingRate = etchingRate
            this.anisotropic = anisotropic
            this.isPlasma = isPlasma
        }

        Etchant(Map fluidArr, Map wasteArr, int voltageTier, double etchingRate, boolean anisotropic, boolean isPlasma) {
            this.fluidArr = fluidArr
            this.wasteArr = wasteArr
            this.voltageTier = voltageTier
            this.etchingRate = etchingRate
            this.anisotropic = anisotropic
            this.isPlasma = isPlasma
        }
    }

    public static final etchants = [ //FIXME: Replace all RIE etchants with proper mixtures
        aluminium: [
            // Cl2/BCl3/N2: standard anisotropic Al interconnect etch. BCl3 breaks through the native oxide
            // and scavenges moisture, Cl2 etches Al as volatile AlCl3, N2 forms the sidewall passivation polymer.
            // Reference recipe ~80:30:15 sccm Cl2:BCl3:N2 (Lee et al., Micromachines 2024); US6248252 (BCl3 15-30, Cl2 50-70, N2 ~20 sccm)
            new Etchant(["chlorine" : 55, "boron_trichloride" : 25, "nitrogen" : 20], ["corrosive_gas" : 100], EV, 0.0167, true, true),
            new Etchant("aluminium_etchant", "acidic_wastewater", MV, 50, 0.00125, false, false),
        ],
        gallium_arsenide: [
            //new Etchant("plasma.chlorine", EV, 10, 0.0125, true, true),
            //new Etchant("plasma.carbon_tetrafluoride",  EV, 10, 0.0167, true, true),
            //new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("ultrapure_hydrogen_peroxide_solution", "wastewater", MV, 50, 0.00125, false, false),
        ],
        silicon: [
            // HBr/Cl2/O2 in He carrier: standard anisotropic poly-Si/gate etch, ~100:1 selectivity over SiO2.
            // O2 forms a brominated silicon oxide passivation layer protecting sidewalls and the gate oxide.
            // Donnelly & Kornblit, JVST A 31, 050825 (2013); US6358859B1; US5007982A
            new Etchant(["hydrogen_bromide" : 50, "chlorine" : 30, "helium" : 15, "oxygen" : 5], ["corrosive_gas" : 100], EV, 0.0167, true, true),
            new Etchant("tetramethylammonium_hydroxide_solution", "wastewater", MV, 40, 0.004, true, false),
            new Etchant("ultrapure_hydrofluoric_acid", "acidic_wastewater", MV, 40, 0.002, false, false)
        ],
        silicon_dioxide: [
            // CHF3/CF4/Ar: classic anisotropic fluorocarbon oxide etch; CHF3-rich for polymerization and selectivity to Si.
            // UCSB Nanofab standard SiO2 recipe (CF4/CHF3); Donnelly & Kornblit, JVST A 31, 050825 (2013)
            new Etchant(["fluoroform" : 35, "carbon_tetrafluoride" : 15, "argon" : 50], ["corrosive_gas" : 100], EV, 0.0167, true, true),
            new Etchant("buffered_oxide_etchant", "acidic_wastewater", MV, 40, 0.004, false, false),
        ],
        silicon_nitride: [
            // CH3F/O2 at ~1:3 in He carrier: anisotropic nitride etch highly selective to Si and SiO2.
            // US5786276 (optimum ~20 sccm CH3F : 60 sccm O2, O2:CH3F > 3:1); Kaler et al., JVST A 34, 041301 (2016)
            new Etchant(["fluoroform" : 20, "oxygen" : 60, "helium" : 20], ["corrosive_gas" : 100], EV, 0.0167, true, true),
            new Etchant("phosphoric_acid", "acidic_wastewater", MV, 40, 0.004, false, false),
        ],
        titanium: [
            //new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("ultrapure_hydrofluoric_acid", "acidic_wastewater", MV, 40, 0.004, false, false),
        ],
        nickel: [
            //new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("ultrapure_hydrofluoric_acid", "acidic_wastewater", MV, 40, 0.004, false, false),
        ],
        tungsten: [
            //new Etchant("plasma.carbon_tetrafluoride", EV, 10, 0.0167, true, true),
            new Etchant("hydrogen_peroxide_solution", "wastewater", MV, 40, 0.004, false, false),
        ],
        copper: [
            new Etchant("ultrapure_iron_iii_chloride_solution", "acidic_wastewater", MV, 100, 0.01, false, false),
            new Etchant("sodium_bisulfate_solution", "wastewater", MV, 100, 0.01, false, false),
        ],
        indium_tin_oxide: [
            new Etchant("nitration_mixture", "acidic_wastewater", MV, 50, 0.004, false, false),
        ],
        chrome: [
            new Etchant("hydrochloric_acid", "acidic_wastewater", MV, 50, 0.004, false, false),
        ],
        gold: [
            new Etchant("aqua_regia", "acidic_wastewater", MV, 50, 0.004, false, false),
        ],
        platinum: [
            new Etchant("aqua_regia", "acidic_wastewater", MV, 50, 0.002, false, false),
        ],
        titanium_nitride: [
            new Etchant("nitric_acid", "acidic_wastewater", MV, 50, 0.002, false, false),
            new Etchant("ultrapure_hydrofluoric_acid", "acidic_wastewater", MV, 50, 0.004, false, false),
        ],
        hafnium_dioxide: [
            // BCl3/Cl2/Ar: standard high-k gate dielectric etch, >100:1 selectivity over Si; volatile HfCl4/HfBxCly
            // products. Fluorocarbons are unsuitable since HfF4 is involatile. Sungauer et al., JVST B 25, 1640 (2007);
            // Martin & Chang, JVST A 26, 597 (2008)
            new Etchant(["boron_trichloride" : 60, "chlorine" : 20, "argon" : 20], ["corrosive_gas" : 100], EV, 0.008, true, true),
        ],
        nickel_silicide: [
            new Etchant("phosphoric_acid", "acidic_wastewater", HV, 50, 0.01, false, false)
        ],
        silicon_bosch: [
            new Etchant(["sulfur_hexafluoride" : 50, "octafluorocyclobutane" : 30, "argon" : 20], ["corrosive_gas" : 100], EV, 4, true, true)
        ],
        zirconia: [
            // BCl3/Ar with a small Cl2 addition: ZrO2 etch rate peaks at ~30-35% Ar dilution, and minor Cl2
            // improves selectivity to SiO2/Si3N4. Kim et al., Microelectron. Eng. 84 (2007); Ferroelectrics 384 (2009)
            new Etchant(["boron_trichloride" : 60, "argon" : 30, "chlorine" : 10], ["corrosive_gas" : 100], EV, 0.0167, true, true)
        ],
        alumina: [
            new Etchant("boron_trichloride", "corrosive_gas", EV, 100, 0.0167, true, true)
        ],
        zirconia_alumina_coetch: [
            new Etchant(["boron_trichloride" : 60, "chlorine" : 20, "argon" : 20], ["corrosive_gas" : 100], EV, 0.004, true, true)
        ],
        borophosphosilicate_glass: [
            new Etchant(["octafluorocyclobutane" : 25, "carbon_tetrafluoride" : 20, "oxygen" : 10, "argon" : 45], ["corrosive_gas" : 100], EV, 0.0167, true, true)
        ],
        silicon_oxycarbide_hydride: [
            new Etchant(["octafluorocyclobutane" : 15, "argon" : 80, "oxygen" : 5], ["corrosive_gas" : 100], EV, 0.0167, true, true)
        ],
        silicon_oxynitride: [
            new Etchant(["carbon_tetrafluoride" : 30, "fluoroform" : 20, "argon" : 50], ["corrosive_gas" : 100], EV, 0.0167, true, true)
        ],
        silicon_silica_coetch: [
            new Etchant(["hexafluorobutadiene" : 15, "carbon_tetrafluoride" : 25, "argon" : 50, "oxygen" : 10], ["corrosive_gas" : 100], EV, 0.004, true, true)
        ],
        silicon_nitride_silica_coetch: [
            new Etchant(["hexafluorobutyne" : 15, "carbon_tetrafluoride" : 25, "argon" : 50, "oxygen" : 10], ["corrosive_gas" : 100], EV, 0.004, true, true)
        ],
        nichrome: [
            new Etchant("ultrapure_iron_iii_chloride_solution", "acidic_wastewater", MV, 100, 0.01, false, false)
        ]
    ]


    static void generateWetEtchingRecipe(String input, String product, String materialEtched, int depth, boolean anisotropic) {
        if (!etchants.containsKey(materialEtched)) {    
            log.warn("Attempted adding etching recipe with no matching etchant: " + materialEtched + ". No recipe is generated");
            return;
        }
        for (etchant in etchants[materialEtched]) {
            if (anisotropic == etchant.anisotropic && !etchant.isPlasma) {
                def etchingRecipe = CHEMICAL_BATH.recipeBuilder()
                    .inputs(metaitem(input))
                    .outputs(metaitem(product))
                    .duration((int) (depth / etchant.etchingRate))
                    .EUt(VA[etchant.voltageTier])
                    .cleanroom(CleanroomType.CLEANROOM)

                for (entry in etchant.fluidArr) {
                    etchingRecipe.fluidInputs(fluid(entry.key) * entry.value)
                }
                for (entry in etchant.wasteArr) {
                    etchingRecipe.fluidOutputs(fluid(entry.key) * entry.value)
                }
                etchingRecipe.buildAndRegister()
            }
        }
    }

    static void generateReactiveIonEtchingRecipe(String input, String product, String materialEtched, int depth) {
        if (!etchants.containsKey(materialEtched)) {    
            log.warn("Attempted adding etching recipe with no matching etchant: " + materialEtched + ". No recipe is generated");
            return;
        }
        for (etchant in etchants[materialEtched]) {
            if (etchant.isPlasma) {
                def etchingRecipe = REACTIVE_ION_ETCHER.recipeBuilder()
                    .inputs(metaitem(input))
                    .outputs(metaitem(product))
                    .duration((int) (depth / etchant.etchingRate))
                    .EUt(VA[etchant.voltageTier])
                    .cleanroom(CleanroomType.CLEANROOM)

                for (entry in etchant.fluidArr) {
                    etchingRecipe.fluidInputs(fluid(entry.key) * entry.value)
                }
                for (entry in etchant.wasteArr) {
                    etchingRecipe.fluidOutputs(fluid(entry.key) * entry.value)
                }
                etchingRecipe.buildAndRegister()
            }
        }
    }
}
