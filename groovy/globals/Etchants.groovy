package globals
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

class Etchants {

    static class Etchant {
        String fluidName
        int amountUsed
        int timeUsed
        boolean isPlasma

        Etchant(String fluidName, int amountUsed, int timeUsed, boolean isPlasma) {
            this.fluidName = fluidName
            this.amountUsed = amountUsed
            this.timeUsed = timeUsed
            this.isPlasma = isPlasma
        }

        Etchant(String fluidName, int amountUsed, int timeUsed) {
            this(fluidName, amountUsed, timeUsed, false)
        }
    }

    public static final etchants = [
        aluminium: [
            new Etchant("plasma.chlorine", 10, 80, true),
            new Etchant("plasma.carbon_tetrafluoride", 10, 60, true),
            new Etchant("plasma.boron_trichloride", 10, 60, true),
            new Etchant("phosphoric_acid", 50, 700),
        ],
        gallium_arsenide: [
            new Etchant("plasma.chlorine", 10, 80, true),
            new Etchant("plasma.carbon_tetrafluoride",  10, 60, true),
            new Etchant("plasma.boron_trichloride", 10, 60, true),
            new Etchant("hydrogen_peroxide", 50, 700),
        ],
        photoresist: [
            new Etchant("plasma.oxygen", 10, 60, true),
            new Etchant("hydrogen_peroxide", 50, 500),
        ],
        silicon: [
            new Etchant("plasma.chlorine", 10, 80, true),
            new Etchant("plasma.carbon_tetrafluoride", 10, 60, true),
            new Etchant("ethylenediamine_pyrocatechol", 40, 80),
            new Etchant("tetramethylammonium_hydroxide_solution", 40, 80),
            new Etchant("nitric_acid", 80, 700),
            new Etchant("hydrofluoric_acid", 40, 500)
        ],
        silicon_advanced: [
            new Etchant("ethylenediamine_pyrocatechol", 40, 80),
            new Etchant("tetramethylammonium_hydroxide_solution", 40, 80),
        ],
        silicon_dioxide: [
            new Etchant("plasma.carbon_tetrafluoride", 10, 60, true),
            new Etchant("plasma.nitrogen_trifluoride", 10, 60, true),
            new Etchant("hydrofluoric_acid", 40, 600),
        ],
        silicon_nitride: [
            new Etchant("plasma.carbon_tetrafluoride", 10, 60, true),
            new Etchant("plasma.nitrogen_trifluoride", 10, 60, true),
            new Etchant("phosphoric_acid", 40, 600),
        ],
        titanium: [
            new Etchant("plasma.boron_trichloride", 10, 60, true),
            new Etchant("hydrofluoric_acid", 50, 700),
        ],
        nickel: [
            new Etchant("plasma.boron_trichloride", 10, 60, true),
            new Etchant("hydrofluoric_acid", 50, 700),
        ],
        tungsten: [
            new Etchant("plasma.carbon_tetrafluoride", 10, 60, true),
            new Etchant("hydrogen_peroxide", 50, 700),
        ],
        copper: [
            new Etchant("iron_iii_chloride_solution", 100, 100),
            new Etchant("sodium_bisulfate_solution", 100, 100),
        ],
        indium_tin_oxide: [
            new Etchant("nitration_mixture", 50, 700),
        ],
        chrome: [
            new Etchant("hydrochloric_acid", 50, 700),
        ],
        gold: [
            new Etchant("aqua_regia", 50, 700),
        ],
        platinum: [
            new Etchant("aqua_regia", 50, 700),
        ],
        titanium_nitride: [
            new Etchant("nitric_acid", 50, 700),
            new Etchant("hydrofluoric_acid", 50, 700),
        ]
    ]


    static void generateEtchingRecipes(String input, String product, String materialEtched, int voltageTier, int timeMultiplier, boolean cleanroom) {
        if (!etchants.containsKey(materialEtched)) {    
            log.warn("Attempted adding etching recipe with no matching etchant: " + materialEtched + ". No recipe is generated");
            return;
        }
        for (etchant in etchants[materialEtched]) {
            def baseRecipeBuilder = CHEMICAL_BATH.recipeBuilder()
                        .inputs(metaitem(input))
                        .fluidInputs(fluid(etchant.fluidName) * etchant.amountUsed)
                        .outputs(metaitem(product))
                        .duration(etchant.timeUsed * timeMultiplier)
                        .EUt(VA[voltageTier]);
            if (cleanroom) {
                baseRecipeBuilder = baseRecipeBuilder.cleanroom(CleanroomType.CLEANROOM)
            }
            baseRecipeBuilder.buildAndRegister()
        }
    }

}
