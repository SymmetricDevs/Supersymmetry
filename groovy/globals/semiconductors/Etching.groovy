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
        String fluidName
        int voltageTier
        int amountUsed
        double etchingRate
        boolean anisotropic
        boolean isPlasma

        Etchant(String fluidName, int voltageTier, int amountUsed, double etchingRate, boolean anisotropic, boolean isPlasma) {
            this.fluidName = fluidName
            this.voltageTier = voltageTier
            this.amountUsed = amountUsed
            this.etchingRate = etchingRate
            this.anisotropic = anisotropic
            this.isPlasma = isPlasma
        }
    }

    public static final etchants = [
        aluminium: [
            new Etchant("plasma.chlorine", EV, 10, 0.0125, true, true),
            new Etchant("plasma.carbon_tetrafluoride", EV, 10, 0.0167, true, true),
            new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("aluminium_etchant", MV, 50, 0.00125, false, false),
        ],
        gallium_arsenide: [
            new Etchant("plasma.chlorine", EV, 10, 0.0125, true, true),
            new Etchant("plasma.carbon_tetrafluoride",  EV, 10, 0.0167, true, true),
            new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("ultrapure_hydrogen_peroxide_solution", MV, 50, 0.00125, false, false),
        ],
        silicon: [
            new Etchant("plasma.chlorine", EV, 10, 0.0125, true, true),
            new Etchant("plasma.carbon_tetrafluoride", EV, 10, 0.0167, true, true),
            new Etchant("tetramethylammonium_hydroxide_solution", MV, 40, 0.004, true, false),
            new Etchant("ultrapure_hydrofluoric_acid", MV, 40, 0.002, false, false)
        ],
        silicon_dioxide: [
            new Etchant("plasma.carbon_tetrafluoride", EV, 10, 0.0167, true, true),
            new Etchant("plasma.nitrogen_trifluoride", EV, 10, 0.0167, true, true),
            new Etchant("buffered_oxide_etchant", MV, 40, 0.004, false, false),
        ],
        silicon_nitride: [
            new Etchant("plasma.carbon_tetrafluoride", EV, 10, 0.0167, true, true),
            new Etchant("plasma.nitrogen_trifluoride", EV, 10, 0.0167, true, true),
            new Etchant("phosphoric_acid", MV, 40, 0.004, false, false),
        ],
        titanium: [
            new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("ultrapure_hydrofluoric_acid", MV, 40, 0.004, false, false),
        ],
        nickel: [
            new Etchant("plasma.boron_trichloride", EV, 10, 0.0167, true, true),
            new Etchant("ultrapure_hydrofluoric_acid", MV, 40, 0.004, false, false),
        ],
        tungsten: [
            new Etchant("plasma.carbon_tetrafluoride", EV, 10, 0.0167, true, true),
            new Etchant("hydrogen_peroxide_solution", MV, 40, 0.004, false, false),
        ],
        copper: [
            new Etchant("ultrapure_iron_iii_chloride_solution", MV, 100, 0.01, false, false),
            new Etchant("sodium_bisulfate_solution", MV, 100, 0.01, false, false),
        ],
        indium_tin_oxide: [
            new Etchant("nitration_mixture", MV, 50, 0.004, false, false),
        ],
        chrome: [
            new Etchant("hydrochloric_acid", MV, 50, 0.004, false, false),
        ],
        gold: [
            new Etchant("aqua_regia", MV, 50, 0.004, false, false),
        ],
        platinum: [
            new Etchant("aqua_regia", MV, 50, 0.002, false, false),
        ],
        titanium_nitride: [
            new Etchant("nitric_acid", MV, 50, 0.002, false, false),
            new Etchant("ultrapure_hydrofluoric_acid", MV, 50, 0.004, false, false),
        ]
    ]


    static void generateWetEtchingRecipe(String input, String product, String materialEtched, int duration, boolean anisotropic) {
        if (!etchants.containsKey(materialEtched)) {    
            log.warn("Attempted adding etching recipe with no matching etchant: " + materialEtched + ". No recipe is generated");
            return;
        }
        for (etchant in etchants[materialEtched]) {
            if (anisotropic == etchant.anisotropic && !etchant.isPlasma) {
                CHEMICAL_BATH.recipeBuilder()
                    .inputs(metaitem(input))
                    .fluidInputs(fluid(etchant.fluidName) * etchant.amountUsed)
                    .outputs(metaitem(product))
                    .duration((int) (1/etchant.etchingRate * duration))
                    .EUt(VA[etchant.voltageTier])
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister()
            }
        }
    }

    static void generateReactiveIonEtchingRecipe(String input, String product, String materialEtched, int duration) {
        if (!etchants.containsKey(materialEtched)) {    
            log.warn("Attempted adding etching recipe with no matching etchant: " + materialEtched + ". No recipe is generated");
            return;
        }
        for (etchant in etchants[materialEtched]) {
            if (etchant.isPlasma) {
                REACTIVE_ION_ETCHER.recipeBuilder()
                    .inputs(metaitem(input))
                    .fluidInputs(fluid(etchant.fluidName) * etchant.amountUsed)
                    .outputs(metaitem(product))
                    .duration((int) (1/etchant.etchingRate * duration))
                    .EUt(VA[etchant.voltageTier])
                    .cleanroom(CleanroomType.CLEANROOM)
                    .buildAndRegister()
            }
        }
    }
}
