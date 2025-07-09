package material;

import static material.SuSyMaterials.*;
import static globals.Globals.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.properties.*
import gregtech.api.unification.Elements;
import gregtech.api.GTValues;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import supercritical.api.unification.SCElements;

public class IsotopeMaterials {

    public static void register() {

        log.infoMC("Registering Isotope Materials!");

        NaturalUranium = new Material.Builder(31000, SuSyUtility.susyId("natural_uranium"))
            .dust()
            .components(Uranium235 * 7, Uranium238 * 993)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x30a82a)
            .element(Elements.U)
            .build();

        LEU235 = new Material.Builder(31001, SuSyUtility.susyId("leu_235"))
            .dust()
            .components(Uranium235 * 5, Uranium238 * 95)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x31bd2a)
            .build();

        HALEU235 = new Material.Builder(31002, SuSyUtility.susyId("haleu_235"))
            .dust()
            .components(Uranium235 * 10, Uranium238 * 90)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x2dcc25)
            .build();

        HEU235 = new Material.Builder(31003, SuSyUtility.susyId("heu_235"))
            .dust()
            .components(Uranium235 * 20, Uranium238 * 80)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x1ede14)
            .build();

        WeaponsGradeUranium = new Material.Builder(31004, SuSyUtility.susyId("weapons_grade_uranium"))
            .dust()
            .components(Uranium235 * 90, Uranium238 * 10)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x0fe50e)
            .build();

        Uranium234 = new Material.Builder(31005, SuSyUtility.susyId("uranium_234"))
            .flags(DISABLE_DECOMPOSITION)
            .color(0x076e18)
            .element(SCElements.U234)
            .build();

        Uranium236 = new Material.Builder(31006, SuSyUtility.susyId("uranium_236"))
            .flags(DISABLE_DECOMPOSITION)
            .color(0x043013)
            .element(SCElements.U236)
            .build();

        ReprocessedUranium = new Material.Builder(31007, SuSyUtility.susyId("reprocessed_uranium"))
            .components(Uranium235 * 9, Uranium236 * 5, Uranium238 * 986)
            .flags(DISABLE_DECOMPOSITION)
            .color(0x31bd2a)
            .element(Elements.U)
            .build();

        Plutonium238 = new Material.Builder(31008, SuSyUtility.susyId("plutonium_238"))
            .color(0xF03232)
            .iconSet(METALLIC)
            .element(SCElements.Pu238)
            .build();

        Plutonium240 = new Material.Builder(31009, SuSyUtility.susyId("plutonium_240"))
            .color(0xF03232)
            .iconSet(METALLIC)
            .element(SCElements.Pu240)
            .build();

        Plutonium242 = new Material.Builder(31010, SuSyUtility.susyId("plutonium_242"))
            .color(0xF03232)
            .iconSet(METALLIC)
            .element(SCElements.Pu242)
            .build();

        Plutonium244 = new Material.Builder(31011, SuSyUtility.susyId("plutonium_244"))
            .color(0xF03232)
            .iconSet(METALLIC)
            .element(SCElements.Pu244)
            .build();

        ReactorGradePlutonium = new Material.Builder(31012, SuSyUtility.susyId("reactor_grade_plutonium"))
            .dust()
            .iconSet(METALLIC)
            .components(Plutonium238 * 2, Plutonium239 * 57, Plutonium240 * 24, Plutonium241 * 11, Plutonium242 * 6)
            .flags(DISABLE_DECOMPOSITION)
            .colorAverage()
            .element(Elements.Pu)
            .build();
    }
}