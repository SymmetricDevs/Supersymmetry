import static classes.materials.Materials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OreMaterials{
    public static void init() {
        Petalite = new Material.Builder(22000, "petalite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd2f7f6)
                .components(Lithium, 1, Aluminium, 1, Silicon, 4, Oxygen, 10)
                .build();

        Amblygonite = new Material.Builder(22001, "amblygonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xf7f5d2)
                .components(Lithium, 1, Sodium, 1, Aluminium, 1, Phosphorus, 1, Oxygen, 4, Fluorine, 1)
                .build()
                .setFormula("(Li,Na)AlPO4(F,OH)", true);

        Fluorite = new Material.Builder(22002, "amblygonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xf7f5d2)
                .components(Lithium, 1, Sodium, 1, Aluminium, 1, Phosphorus, 1, Oxygen, 4, Fluorine, 1)
                .build()
                .setFormula("(Li,Na)AlPO4(F,OH)", true);

        Thortveitite = new Material.Builder(22012, "thortveitite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xb38969)
                .components(Scandium, 1, Yttrium, 1, Silicon, 2, Oxygen, 7)
                .build()
                .setFormula("(Sc,Y)2Si2O7", true);

        Perovskite = new Material.Builder(22014, "perovskite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x0b3d1d)
                .components(Calcium, 1, Titanium, 1, Oxygen, 3)
                .build();

        Titanomagnetite = new Material.Builder(22016, "titanomagnetite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x555c45)
                .components(Iron, 1, Titanium, 1, Oxygen, 4)
                .build()
                .setFormula("Fe(Fe,Ti)2O4", true);

        Fluorapatite = new Material.Builder(22018, "fluorapatite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xcc9681)
                .components(Calcium, 5, Phophorus, 3, Oxygen, 12, Fluorine, 1)
                .build()
                .setFormula("Ca5(PO4)3F", true);

        VanadiferousTitanomagnetite = new Material.Builder(22019, "vanadiferous_titanomagnetite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x87685c)
                .components(Vanadium, 1, Iron, 1, Titanium, 1, Oxygen, 4)
                .build()
                .setFormula("(V,Fe,Ti)2O4", true);

        Armstrongite = new Material.Builder(22020, "armstrongite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3a4f43)
                .components(Calcium, 1, Zirconium, 1, Silicon, 6, Oxygen, 15, Water, 3)
                .build()
                .setFormula("CaZr[Si6O15] • (H2O)3", true);

        Vanadinite = new Material.Builder(22021, "vanadinite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xbf5915)
                .components(Lead, 5, Vanadium, 3, Oxygen, 12, Chlorine)
                .build()
                .setFormula("Pb5(VO4)3Cl", true);

        Cerussite = new Material.Builder(22022, "cerussite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xe0d9ba)
                .components(Lead, 1, Carbon, 1, Oxygen, 3)
                .build();

        Anglesite = new Material.Builder(22023, "anglesite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xe0ded5)
                .components(Lead, 1, Sulfur, 1, Oxygen, 4)
                .build();

        Enargite = new Material.Builder(22033, "enargite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xc9c7bd)
                .components(Copper, 3, Arsenic, 1, Sulfur, 4)
                .build();

        Smithsonite = new Material.Builder(22037, "smithsonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x6aadab)
                .components(Zinc, 1, Carbon, 1, Oxygen, 3)
                .build();

        Arsenopyrite = new Material.Builder(22038, "arsenopyrite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x7d7269)
                .components(Iron, 1, Arsenic, 1, Sulfur, 1)
                .build();

        Acanthite = new Material.Builder(22039, "acanthite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x2c332d)
                .components(Silver, 2, Sulfur, 1)
                .build();

        Pyrargyrite = new Material.Builder(22040, "pyrargyirte")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x362a2a)
                .components(Silver, 3, Antimony, 1, Sulfur, 3)
                .build();

        Stephanite = new Material.Builder(22041, "stephanite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x3d3d36)
                .components(Silver, 5, Antimony, 1, Sulfur, 4)
                .build();

        Proustite = new Material.Builder(22042, "proustite")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x73142d)
                .components(Silver, 3, Arsenic, 1, Sulfur, 3)
                .build();

        Celestine = new Material.Builder(22044, "celestine")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0xafe3e0)
                .iconSet(SHINY)
                .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
                .build();

        Strontianite = new Material.Builder(22045, "strontianite")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0xe3d3af)
                .iconSet(SHINY)
                .components(Strontium, 1, Carbon, 1, Oxygen, 3)
                .build();

        Witherite = new Material.Builder(22050, "witherite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd1d0bc)
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .build();

        Wolframite = new Material.Builder(22051, "wolframite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x1e1c36)
                .components(Iron, 1, Manganese, 1, Tungsten, 1, Oxygen, 4)
                .build()
                .setFormula("(Fe,Mn)WO4", true);

        Rhodplumsite = new Material.Builder(22053, "rhodplumsite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x292726)
                .components(Rhodium, 3, Lead, 2, Sulfur, 2)
                .build();

        Bowieite = new Material.Builder(22054, "bowieite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x323325)
                .components(Rhodium, 2, Sulfur, 3)
                .build()
                .setFormula("(Rh,Ir,Pt)2S3", true);

        Polarite = new Material.Builder(22055, "polarite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x2e360a)
                .components(Palladium, 1, Bismuth, 1, Lead, 1)
                .build()
                .setFormula("Pd(Bi,Pb)", true);

        Livingstonite = new Material.Builder(22057, "livingstonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x5e5654)
                .components(Mercury, 1, Antimony, 4, Sulfur, 8)
                .build();

        Bismuthinite = new Material.Builder(22058, "bismuthinite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x85795b)
                .components(Bismuth, 2, Sulfur, 3)
                .build();

        Lorandite = new Material.Builder(22060, "lorandite")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0x913111)
                .components(Thallium, 1, Arsenic, 1, Sulfur, 2)
                .build();

        Hutchinsonite = new Material.Builder(22061, "hutchinsonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x332f2e)
                .components(Thallium, 1, Lead, 1, Arsenic, 5, Sulfur, 9)
                .build()
                .setFormula("(Tl,Pb)2As5S9", true);

        Crookesite = new Material.Builder(22062, "crookesite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3e4a3f)
                .components(Copper, 7, Thallium, 1, Silver, 1, Selenium, 4)
                .build()
                .setFormula("Cu7(Tl,Ag)Se4", true);

        KimberliteOne = new Material.Builder(22066, "kimberlite_one")
                .dust()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x2e2323)
                .build();

        KimberliteTwo = new Material.Builder(22067, "kimberlite_two")
                .dust()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x272933)
                .build();

        Dilithium = new Material.Builder(30009, "dilithium")
                .gem().ore()
                .components(Lithium, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build();

        Lignite = new Material.Builder(30010, "lignite")
                .gem(1, 1200).ore(2, 1)
                .color(0x644646).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        Anthracite = new Material.Builder(30011, "anthracite")
                .gem(1, 2000).ore(2, 1)
                .color(0x241212).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

    }
}