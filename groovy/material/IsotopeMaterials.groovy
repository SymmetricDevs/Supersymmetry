package material;

import static material.SuSyMaterials.*;
import static globals.Globals.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.properties.*
import gregtech.api.GTValues;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class IsotopeMaterials {

    public static void register() {

        log.infoMC("Registering Isotope Materials!");

        NaturalUranium = new Material.Builder(31000, SuSyUtility.susyId("natural_uranium"))
            .dust()
            .components(Uranium235 * 7, Uranium238 * 993)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x30a82a)
            .build();

        NaturalUranium.setFormula("U", true)

        LEU235 = new Material.Builder(31001, SuSyUtility.susyId("leu_235"))
            .dust()
            .components(Uranium235 * 5, Uranium238 * 95)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x31bd2a)
            .build();

        LEU235.setFormula("U", true)

        HALEU235 = new Material.Builder(31002, SuSyUtility.susyId("haleu_235"))
            .dust()
            .components(Uranium235 * 10, Uranium238 * 90)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x2dcc25)
            .build();

        HALEU235.setFormula("U", true)

        HEU235 = new Material.Builder(31003, SuSyUtility.susyId("heu_235"))
            .dust()
            .components(Uranium235 * 20, Uranium238 * 80)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x1ede14)
            .build();

        HEU235.setFormula("U", true)

        WeaponsGradeUranium = new Material.Builder(31004, SuSyUtility.susyId("weapons_grade_uranium"))
            .dust()
            .components(Uranium235 * 90, Uranium238 * 10)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x0fe50e)
            .build();

        WeaponsGradeUranium.setFormula("U", true)

    }

}