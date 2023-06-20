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
                .components(Lithium, 1, Aluminium, 1, Phosphorus, 1, Oxygen, 4, Fluorine, 1)
                .build()

        Amblygonite.setFormula("(Li,Na)AlPO4(F,OH)", true);

        Thortveitite = new Material.Builder(7002, "thortveitite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xb38969)
                .components(Scandium, 1, Yttrium, 1, Silicon, 2, Oxygen, 7)
                .build()

        Thortveitite.setFormula("(Sc,Y)2Si2O7", true);

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

        Titanomagnetite.setFormula("Fe(Fe,Ti)2O4", true);

        Fluorapatite = new Material.Builder(7005, "fluorapatite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xcc9681)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 12, Fluorine, 1)
                .build()

        Fluorapatite.setFormula("Ca5(PO4)3F", true);

        VanadiferousTitanomagnetite = new Material.Builder(7006, "vanadiferous_titanomagnetite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x87685c)
                .components(Vanadium, 1, Iron, 1, Titanium, 1, Oxygen, 4)
                .build()

        VanadiferousTitanomagnetite.setFormula("(V,Fe,Ti)2O4", true);

        Armstrongite = new Material.Builder(7007, "armstrongite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3a4f43)
                .components(Calcium, 1, Zirconium, 1, Silicon, 6, Oxygen, 15, Water, 3)
                .build()

        Armstrongite.setFormula("CaZr[Si6O15] * (H2O)3", true);

        Vanadinite = new Material.Builder(7008, "vanadinite")
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xbf5915)
                .components(Lead, 5, Vanadium, 3, Oxygen, 12, Chlorine, 1)
                .build()

        Vanadinite.setFormula("Pb5(VO4)3Cl", true);

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

        Pyrargyrite = new Material.Builder(7015, "pyrargyrite")
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

        Wolframite.setFormula("(Fe,Mn)WO4", true);

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

        Bowieite.setFormula("(Rh,Ir,Pt)2S3", true);

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

        Hutchinsonite.setFormula("(Tl,Pb)2As5S9", true);

        Crookesite = new Material.Builder(7029, "crookesite")
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3e4a3f)
                .components(Copper, 7, Thallium, 1, Silver, 1, Selenium, 4)
                .build()

        Crookesite.setFormula("Cu7(Tl,Ag)Se4", true);

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
                .dust()
                .iconSet(SHINY)
                .color(0x8a6e42)
                .build();

        Sperrylite = new Material.Builder(7036, "sperrylite")
                .gem().ore()
                .components(Platinum, 1, Arsenic, 2)
                .iconSet(SHINY)
                .color(0xb3af86)
                .build();

        Kernite = new Material.Builder(7037, "kernite")
                .dust()
                .color(0xd9c1a0)
                .components(Sodium, 2, Boron, 4, Oxygen, 8, Hydrogen, 2, Water, 3)
                .build()
                .setFormula("Na2B4O6(OH)2 * (H2O)3", true);

        Colemanite = new Material.Builder(7038, "colemanite")
                .dust()
                .color(0xdbcd8f)
                .components(Calcium, 2, Boron, 6, Oxygen, 11, Water, 5)
                .build()
                .setFormula("Ca2B6O11 * (H2O)5", true);

        Ulexite = new Material.Builder(7039, "ulexite")
                .dust()
                .color(0xc2aba1)
                .components(Sodium, 1, Calcium, 1, Boron, 5, Oxygen, 12, Hydrogen, 6, Water, 5)
                .build()
                .setFormula("NaCaB5O6(OH)6 * (H2O)5", true);

        Carnallite = new Material.Builder(7040, "carnallite")
                .dust()
                .iconSet(SHINY)
                .color(0xffffff)
                .components(Potassium, 1, Magnesium, 1, Chlorine, 3, Water, 6)
                .build()
                .setFormula("KCl.MgCl2 * (H2O)6", true);

        Kainite = new Material.Builder(7041, "kainite")
                .dust()
                .iconSet(SHINY)
                .color(0xfff7c4)
                .components(Potassium, 1, Magnesium, 1, Sulfur, 1, Oxygen, 4, Chlorine, 1, Water, 3)
                .build()
                .setFormula("KMg(SO4)Cl * (H2O)3", true);

        Kieserite = new Material.Builder(7042, "kieserite")
                .dust()
                .color(0xdccade)
                .components(Magnesium, 1, Sulfur, 1, Oxygen, 4, Water, 1)
                .build()
                .setFormula("MgSO4 * H2O", true);

        Polyhalite = new Material.Builder(7043, "polyhalite")
                .dust()
                .color(0xe0b2a4)
                .components(Potassium, 2, Calcium, 2, Magnesium, 1, Sulfur, 4, Oxygen, 16, Water, 2)
                .build()
                .setFormula("K2Ca2Mg(SO4)4 * (H2O)2", true);

        Titanite = new Material.Builder(7045, "titanite")
                .gem()
                .iconSet(SHINY)
                .color(0x967051)
                .components(Calcium, 1, Titanium, 1, Silicon, 1, Oxygen, 5)
                .build();

        Leucoxene = new Material.Builder(7046, "leucoxene")
                .dust()
                .iconSet(SHINY)
                .color(0xb987c4)
                .components(Titanium, 1, Oxygen, 2)
                .build();

        Zircon = new Material.Builder(7047, "zircon")
                .gem()
                .iconSet(SHINY)
                .color(0xf05c51)
                .components(Zirconium, 1, Silicon, 1, Oxygen, 4)
                .build();

        Mimetite = new Material.Builder(7048, "mimetite")
                .dust()
                .iconSet(SHINY)
                .color(0xe8aa2e)
                .components(Lead, 5, Arsenic, 3, Oxygen, 12, Chlorine, 1)
                .build()
                .setFormula("Pb5(AsO4)3Cl", true);

        Pyromorphite = new Material.Builder(7049, "pyromorphite")
                .dust()
                .iconSet(SHINY)
                .color(0xd7e632)
                .components(Lead, 5, Phosphorus, 4, Oxygen, 12, Chlorine, 1)
                .build()
                .setFormula("Pb5(PO4)3Cl", true);

        Descloizite = new Material.Builder(7050, "descloizite")
                .dust()
                .iconSet(SHINY)
                .color(0x5e5d41)
                .components(Lead, 1, Zinc, 1, Vanadium, 1, Oxygen, 5, Hydrogen, 1)
                .build()
                .setFormula("(Pb,Zn)2VO4OH", true);

        Mottramite = new Material.Builder(7051, "mottramite")
                .dust()
                .color(0x53730a)
                .components(Lead, 1, Copper, 1, Vanadium, 1, Oxygen, 5, Hydrogen, 1)
                .build()
                .setFormula("PbCu(VO4)(OH)", true);

        Chlorapatite = new Material.Builder(7052, "chlorapatite")
                .dust().gem().ore()
                .iconSet(SHINY)
                .color(0xc7af85)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 12, Chlorine, 1)
                .build()
                .setFormula("Ca5(PO4)3Cl", true);

        Hematite = new Material.Builder(7053, "hematite")
                .dust()
                .color(0x240f0f)
                .components(Iron, 2, Oxygen, 3)
                .build();

        Skutterudite = new Material.Builder(7054, "skutterudite")
                .dust()
                .iconSet(SHINY)
                .color(0xabbec2)
                .components(Cobalt, 1, Arsenic, 3)
                .build();

        Allanite = new Material.Builder(7055, "allanite")
                .dust()
                .iconSet(SHINY)
                .color(0x6b7a7d)
                .components(Cerium, 1, Calcium, 1, Yttrium, 1, Lanthanum, 1, Aluminium, 1, Iron, 1, Silicon, 3, Oxygen, 13, Hydrogen, 1)
                .build()
                .setFormula("(Ce,Ca,Y,La)2(Al,Fe)3(SiO4)3(OH)", true);

        Azurite = new Material.Builder(7056, "azurite")
                .dust().gem()
                .iconSet(SHINY)
                .color(0x2216c9)
                .components(Copper, 3, Carbon, 2, Oxygen, 8, Hydrogen, 2)
                .build()
                .setFormula("Cu3(CO3)2(OH)2", true);

        Goethite = new Material.Builder(7057, "goethite")
                .dust()
                .color(0x30251f)
                .components(Iron, 1, Oxygen, 2, Hydrogen, 1)
                .build()
                .setFormula("α-FeO(OH)", true);

        Hydrozincite = new Material.Builder(7058, "hydrozincite")
                .dust()
                .color(0xebd5ca)
                .components(Zinc, 5, Carbon, 2, Oxygen, 12, Hydrogen, 6)
                .build()
                .setFormula("Zn5(CO3)2(OH)6", true);

        Chlorargyrite = new Material.Builder(7059, "chlorargyrite")
                .dust()
                .color(0x524728)
                .components(Silver, 1, Chlorine, 1)
                .build();

        Columbite = new Material.Builder(7060, "columbite")
                .dust()
                .color(0x574f2f)
                .iconSet(SHINY)
                .components(Iron, 1, Manganese, 1, Niobium, 2, Oxygen, 6)
                .build()
                .setFormula("(Fe,Mn)Nb2O6)", true);

        Ferrimolybdite = new Material.Builder(7061, "ferrimolybdite")
                .dust()
                .color(0xc1c71c)
                .components(Iron, 2, Molybdenum, 3, Oxygen, 12, Water, 8)
                .build()
                .setFormula("Fe2(MoO4)3 * (H2O)8", true);

        Aguilarite = new Material.Builder(7062, "aguilarite")
                .dust().gem()
                .color(0x303030)
                .iconSet(SHINY)
                .components(Silver, 4, Selenium, 1, Sulfur, 1)
                .build();

        Orpiment = new Material.Builder(7063, "orpiment")
                .dust().gem()
                .color(0xc28034)
                .iconSet(SHINY)
                .components(Arsenic, 2, Sulfur, 3)
                .build();

        Braggite = new Material.Builder(7064, "braggite")
                .dust()
                .color(0x686b5f)
                .components(Platinum, 1, Palladium, 1, Nickel, 1, Sulfur, 1)
                .build()
                .setFormula("(Pt,Pd,Ni)S", true);

        Stannite = new Material.Builder(7065, "stannite")
                .dust()
                .color(0x474f3e)
                .components(Copper, 2, Iron, 1, Tin, 1, Sulfur, 4)
                .build();

        Euxenite = new Material.Builder(7066, "euxenite")
                .dust()
                .color(0x9c973e)
                .components(Yttrium, 1, Calcium, 1, Cerium, 1, Thorium, 1, Niobium, 1, Tantalum, 1, Titanium, 1, Oxygen, 6)
                .build()
                .setFormula("(Y,Ca,Ce,U,Th)(Nb,Ta,Ti)2O6", true);

        Xenotime = new Material.Builder(7067, "xenotime")
                .dust()
                .iconSet(SHINY)
                .color(0x6e572e)
                .components(Yttrium, 1, Phosphorus, 1, Oxygen, 4)
                .build();

        Caliche = new Material.Builder(7068, "caliche")
                .dust()
                .color(0xb3ae98)
                .components(Calcium, 1, Carbon, 1, Oxygen, 3)
                .build();

        Lauterite = new Material.Builder(7069, "lauterite")
                .dust()
                .components(Calcium, 1, Iodine, 2, Oxygen, 6)
                .colorAverage()
                .build()
                .setFormula("Ca(IO3)2", true);

        Langbeinite = new Material.Builder(7070, "langbeinite")
                .dust()
                .components(Potassium, 2, Magnesium, 2, Sulfur, 3, Oxygen, 12)
                .colorAverage()
                .build()
                .setFormula("K2Mg2(SO4)3", true);

        Hydroxyapatite = new Material.Builder(7071, "hydroxyapatite")
                .dust().gem()
                .iconSet(SHINY)
                .color(0xc7afaa)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 13, Hydrogen, 1)
                .build()
                .setFormula("Ca5(PO4)3OH", true);
        
        Rhodochrosite = new Material.Builder(7072, "rhodochrosite")
                .ore()
                .iconSet(SHINY)
                .components(Manganese, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();
    }
}