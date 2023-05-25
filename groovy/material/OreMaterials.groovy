package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OreMaterials{
    public static void register() {

        log.infoMC("Registering Ore Materials!");


        Petalite = new Material.Builder(7000, "petalite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd2f7f6)
                .components(Lithium, 1, Aluminium, 1, Silicon, 4, Oxygen, 10)
                .build();

        Amblygonite = new Material.Builder(7001, "amblygonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xf7f5d2)
                .components(Lithium, 1, Sodium, 1, Aluminium, 1, Phosphorus, 1, Oxygen, 4, Fluorine, 1)
                .build()
                .setFormula("(Li,Na)AlPO4(F,OH)", true);

        Thortveitite = new Material.Builder(7002, "thortveitite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xb38969)
                .components(Scandium, 1, Yttrium, 1, Silicon, 2, Oxygen, 7)
                .build()
                .setFormula("(Sc,Y)2Si2O7", true);

        Perovskite = new Material.Builder(7003, "perovskite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x0b3d1d)
                .components(Calcium, 1, Titanium, 1, Oxygen, 3)
                .build();

        Titanomagnetite = new Material.Builder(7004, "titanomagnetite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x555c45)
                .components(Iron, 1, Titanium, 1, Oxygen, 4)
                .build()
                .setFormula("Fe(Fe,Ti)2O4", true);

        Fluorapatite = new Material.Builder(7005, "fluorapatite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xcc9681)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 12, Fluorine, 1)
                .build()
                .setFormula("Ca5(PO4)3F", true);

        VanadiferousTitanomagnetite = new Material.Builder(7006, "vanadiferous_titanomagnetite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x87685c)
                .components(Vanadium, 1, Iron, 1, Titanium, 1, Oxygen, 4)
                .build()
                .setFormula("(V,Fe,Ti)2O4", true);

        Armstrongite = new Material.Builder(7007, "armstrongite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3a4f43)
                .components(Calcium, 1, Zirconium, 1, Silicon, 6, Oxygen, 15, Water, 3)
                .build()
                .setFormula("CaZr[Si6O15] • (H2O)3", true);

        Vanadinite = new Material.Builder(7008, "vanadinite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xbf5915)
                .components(Lead, 5, Vanadium, 3, Oxygen, 12, Chlorine, 1)
                .build()
                .setFormula("Pb5(VO4)3Cl", true);

        Cerussite = new Material.Builder(7009, "cerussite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xe0d9ba)
                .components(Lead, 1, Carbon, 1, Oxygen, 3)
                .build();

        Anglesite = new Material.Builder(7010, "anglesite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xe0ded5)
                .components(Lead, 1, Sulfur, 1, Oxygen, 4)
                .build();

        Enargite = new Material.Builder(7011, "enargite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xc9c7bd)
                .components(Copper, 3, Arsenic, 1, Sulfur, 4)
                .build();

        Smithsonite = new Material.Builder(7012, "smithsonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x6aadab)
                .components(Zinc, 1, Carbon, 1, Oxygen, 3)
                .build();

        Arsenopyrite = new Material.Builder(7013, "arsenopyrite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x7d7269)
                .components(Iron, 1, Arsenic, 1, Sulfur, 1)
                .build();

        Acanthite = new Material.Builder(7014, "acanthite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x2c332d)
                .components(Silver, 2, Sulfur, 1)
                .build();

        Pyrargyrite = new Material.Builder(7015, "pyrargyirte")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x362a2a)
                .components(Silver, 3, Antimony, 1, Sulfur, 3)
                .build();

        Stephanite = new Material.Builder(7016, "stephanite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x3d3d36)
                .components(Silver, 5, Antimony, 1, Sulfur, 4)
                .build();

        Proustite = new Material.Builder(7017, "proustite")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x73142d)
                .components(Silver, 3, Arsenic, 1, Sulfur, 3)
                .build();

        Celestine = new Material.Builder(7018, "celestine")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0xafe3e0)
                .iconSet(SHINY)
                .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
                .build();

        Strontianite = new Material.Builder(7019, "strontianite")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0xe3d3af)
                .iconSet(SHINY)
                .components(Strontium, 1, Carbon, 1, Oxygen, 3)
                .build();

        Witherite = new Material.Builder(7020, "witherite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd1d0bc)
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .build();

        Wolframite = new Material.Builder(7021, "wolframite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x1e1c36)
                .components(Iron, 1, Manganese, 1, Tungsten, 1, Oxygen, 4)
                .build()
                .setFormula("(Fe,Mn)WO4", true);

        Rhodplumsite = new Material.Builder(7022, "rhodplumsite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x292726)
                .components(Rhodium, 3, Lead, 2, Sulfur, 2)
                .build();

        Bowieite = new Material.Builder(7023, "bowieite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x323325)
                .components(Rhodium, 2, Sulfur, 3)
                .build()
                .setFormula("(Rh,Ir,Pt)2S3", true);

        Polarite = new Material.Builder(7024, "polarite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x2e360a)
                .components(Palladium, 1, Bismuth, 1, Lead, 1)
                .build()
                .setFormula("Pd(Bi,Pb)", true);

        Livingstonite = new Material.Builder(7025, "livingstonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x5e5654)
                .components(Mercury, 1, Antimony, 4, Sulfur, 8)
                .build();

        Bismuthinite = new Material.Builder(7026, "bismuthinite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x85795b)
                .components(Bismuth, 2, Sulfur, 3)
                .build();

        Lorandite = new Material.Builder(7027, "lorandite")
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0x913111)
                .components(Thallium, 1, Arsenic, 1, Sulfur, 2)
                .build();

        Hutchinsonite = new Material.Builder(7028, "hutchinsonite")
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x332f2e)
                .components(Thallium, 1, Lead, 1, Arsenic, 5, Sulfur, 9)
                .build()
                .setFormula("(Tl,Pb)2As5S9", true);

        Crookesite = new Material.Builder(7029, "crookesite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3e4a3f)
                .components(Copper, 7, Thallium, 1, Silver, 1, Selenium, 4)
                .build()
                .setFormula("Cu7(Tl,Ag)Se4", true);

        Dilithium = new Material.Builder(7032, "dilithium")
                .gem().ore()
                .components(Lithium, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build();

        Lignite = new Material.Builder(7033, "lignite")
                .gem(1, 1200).ore(2, 1)
                .color(0x644646).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        Anthracite = new Material.Builder(7034, "anthracite")
                .gem(1, 2000).ore(2, 1)
                .color(0x241212).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        Phosphorite = new Material.Builder(7035, "phosphorite")
                .gem().ore()
                .iconSet(SHINY)
                .color(0x8a6e42)
                .build();

    }
}