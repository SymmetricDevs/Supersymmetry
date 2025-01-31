package material;

import static material.SuSyMaterials.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.api.util.SuSyUtility;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

public class OreMaterials{
    public static void register() {

        log.infoMC('Registering Ore Materials!');


        Petalite = new Material.Builder(7000, SuSyUtility.susyId('petalite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd2f7f6)
                .components(Lithium, Aluminium, Silicon * 4, Oxygen * 10)
                .build();

        Amblygonite = new Material.Builder(7001, SuSyUtility.susyId('amblygonite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xf7f5d2)
                .components(Lithium, Aluminium, Phosphorus, Oxygen * 4, Fluorine)
                .build()

        Amblygonite.setFormula('(Li,Na)AlPO4(F,OH)', true);

        Thortveitite = new Material.Builder(7002, SuSyUtility.susyId('thortveitite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xb38969)
                .components(Scandium, Yttrium, Silicon * 2, Oxygen * 7)
                .build()

        Thortveitite.setFormula('(Sc,Y)2Si2O7', true);

        Perovskite = new Material.Builder(7003, SuSyUtility.susyId('perovskite'))
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x0b3d1d)
                .components(Calcium, Titanium, Oxygen * 3)
                .build();

        Titanomagnetite = new Material.Builder(7004, SuSyUtility.susyId('titanomagnetite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x555c45)
                .components(Iron, Titanium, Oxygen * 4)
                .build()

        Titanomagnetite.setFormula('Fe(Fe,Ti)2O4', true);

        Fluorapatite = new Material.Builder(7005, SuSyUtility.susyId('fluorapatite'))
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xcc9681)
                .components(Calcium * 5, Phosphorus * 3, Oxygen * 12, Fluorine)
                .build()

        Fluorapatite.setFormula('Ca5(PO4)3F', true);

        VanadiferousTitanomagnetite = new Material.Builder(7006, SuSyUtility.susyId('vanadiferous_titanomagnetite'))
                .dust().ore().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING, GENERATE_FLOTATED)
                .color(0x87685c)
                .components(Vanadium, Iron, Titanium, Oxygen * 4)
                .build()

        VanadiferousTitanomagnetite.setFormula('(V,Fe,Ti)2O4', true);

        Baddeleyite = new Material.Builder(7007, SuSyUtility.susyId('baddeleyite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3a4f43)
                .components(Zirconium, Oxygen * 2)
                .build()

        Baddeleyite.setFormula('ZrO2', true);

        Vanadinite = new Material.Builder(7008, SuSyUtility.susyId('vanadinite'))
                .gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xbf5915)
                .components(Lead * 5, Vanadium * 3, Oxygen * 12, Chlorine)
                .build()

        Vanadinite.setFormula('Pb5(VO4)3Cl', true);

        Cerussite = new Material.Builder(7009, SuSyUtility.susyId('cerussite'))
                .dust().ore().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING)
                .color(0xe0d9ba)
                .components(Lead, Carbon, Oxygen * 3)
                .build();

        Anglesite = new Material.Builder(7010, SuSyUtility.susyId('anglesite'))
                .dust().ore().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING)
                .color(0xe0ded5)
                .components(Lead, Sulfur, Oxygen * 4)
                .build();

        Enargite = new Material.Builder(7011, SuSyUtility.susyId('enargite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0xc9c7bd)
                .components(Copper * 3, Arsenic, Sulfur * 4)
                .build();

        Smithsonite = new Material.Builder(7012, SuSyUtility.susyId('smithsonite'))
                .dust().ore().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING)
                .color(0x6aadab)
                .components(Zinc, Carbon, Oxygen * 3)
                .build();

        Arsenopyrite = new Material.Builder(7013, SuSyUtility.susyId('arsenopyrite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x7d7269)
                .components(Iron, Arsenic, Sulfur)
                .build();

        Acanthite = new Material.Builder(7014, SuSyUtility.susyId('acanthite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x2c332d)
                .components(Silver * 2, Sulfur)
                .build();

        Pyrargyrite = new Material.Builder(7015, SuSyUtility.susyId('pyrargyrite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x362a2a)
                .components(Silver * 3, Antimony, Sulfur * 3)
                .build();

        Stephanite = new Material.Builder(7016, SuSyUtility.susyId('stephanite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x3d3d36)
                .components(Silver * 5, Antimony, Sulfur * 4)
                .build();

        Proustite = new Material.Builder(7017, SuSyUtility.susyId('proustite'))
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x73142d)
                .components(Silver * 3, Arsenic, Sulfur * 3)
                .build();

        Celestine = new Material.Builder(7018, SuSyUtility.susyId('celestine'))
                .dust().gem().ore()
                .flags(NO_SMELTING, GENERATE_SIFTED, GENERATE_FLOTATED)
                .color(0xafe3e0)
                .iconSet(SHINY)
                .components(Strontium, Sulfur, Oxygen * 4)
                .build();

        Strontianite = new Material.Builder(7019, SuSyUtility.susyId('strontianite'))
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0xe3d3af)
                .iconSet(SHINY)
                .components(Strontium, Carbon, Oxygen * 3)
                .build();

        Witherite = new Material.Builder(7020, SuSyUtility.susyId('witherite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0xd1d0bc)
                .components(Barium, Carbon, Oxygen * 3)
                .build();

        Wolframite = new Material.Builder(7021, SuSyUtility.susyId('wolframite'))
                .dust().ore().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .flags(NO_SMELTING, GENERATE_SIFTED, GENERATE_FLOTATED)
                .color(0x1e1c36)
                .components(Iron, Manganese, Tungsten, Oxygen * 4)
                .build()

        Wolframite.setFormula('(Fe,Mn)WO4', true);

        Rhodplumsite = new Material.Builder(7022, SuSyUtility.susyId('rhodplumsite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x292726)
                .components(Rhodium * 3, Lead * 2, Sulfur * 2)
                .build();

        Bowieite = new Material.Builder(7023, SuSyUtility.susyId('bowieite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x323325)
                .components(Rhodium * 2, Sulfur * 3)
                .build()

        Bowieite.setFormula('(Rh,Ir,Pt)2S3', true);

        Polarite = new Material.Builder(7024, SuSyUtility.susyId('polarite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x2e360a)
                .components(Palladium, Bismuth, Lead)
                .build()
                .setFormula('Pd(Bi,Pb)', true);

        Livingstonite = new Material.Builder(7025, SuSyUtility.susyId('livingstonite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x5e5654)
                .components(Mercury, Antimony * 4, Sulfur * 8)
                .build();

        Bismuthinite = new Material.Builder(7026, SuSyUtility.susyId('bismuthinite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x85795b)
                .components(Bismuth * 2, Sulfur * 3)
                .build();

        Lorandite = new Material.Builder(7027, SuSyUtility.susyId('lorandite'))
                .dust().gem().ore()
                .flags(NO_SMELTING)
                .color(0x913111)
                .components(Thallium, Arsenic, Sulfur * 2)
                .build();

        Hutchinsonite = new Material.Builder(7028, SuSyUtility.susyId('hutchinsonite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .iconSet(SHINY)
                .color(0x332f2e)
                .components(Thallium, Lead, Arsenic * 5, Sulfur * 9)
                .build()

        Hutchinsonite.setFormula('(Tl,Pb)2As5S9', true);

        Crookesite = new Material.Builder(7029, SuSyUtility.susyId('crookesite'))
                .dust().ore()
                .flags(NO_SMELTING)
                .color(0x3e4a3f)
                .components(Copper * 7, Thallium, Silver, Selenium * 4)
                .build()

        Crookesite.setFormula('Cu7(Tl,Ag)Se4', true);

        Dilithium = new Material.Builder(7032, SuSyUtility.susyId('dilithium'))
                .gem().ore()
                .components(Lithium * 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build();

        Lignite = new Material.Builder(7033, SuSyUtility.susyId('lignite'))
                .gem(1, 600).ore(2, 1)
                .color(0x644646).iconSet(LIGNITE)
                .components(Carbon)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        Anthracite = new Material.Builder(7034, SuSyUtility.susyId('anthracite'))
                .gem(1, 2000).ore(2, 1)
                .color(0x241212).iconSet(LIGNITE)
                .components(Carbon)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        Phosphorite = new Material.Builder(7035, SuSyUtility.susyId('phosphorite'))
                .ore()
                .iconSet(SHINY)
                .color(0x8a6e42)
                .build();

        Sperrylite = new Material.Builder(7036, SuSyUtility.susyId('sperrylite'))
                .gem().ore()
                .components(Platinum, Arsenic * 2)
                .iconSet(SHINY)
                .color(0xb3af86)
                .build();

        Kernite = new Material.Builder(7037, SuSyUtility.susyId('kernite'))
                .dust()
                .color(0xd9c1a0)
                .components(Sodium * 2, Boron * 4, Oxygen * 8, Hydrogen * 2, Water * 3)
                .build()
                .setFormula('Na2B4O6(OH)2 * (H2O)3', true);

        Colemanite = new Material.Builder(7038, SuSyUtility.susyId('colemanite'))
                .dust()
                .color(0xdbcd8f)
                .components(Calcium * 2, Boron * 6, Oxygen * 11, Water * 5)
                .build()
                .setFormula('Ca2B6O11 * (H2O)5', true);

        Ulexite = new Material.Builder(7039, SuSyUtility.susyId('ulexite'))
                .dust()
                .color(0xc2aba1)
                .components(Sodium, Calcium, Boron * 5, Oxygen * 12, Hydrogen * 6, Water * 5)
                .build()
                .setFormula('NaCaB5O6(OH)6 * (H2O)5', true);

        Carnallite = new Material.Builder(7040, SuSyUtility.susyId('carnallite'))
                .dust()
                .iconSet(SHINY)
                .color(0xffffff)
                .components(Potassium, Magnesium, Chlorine * 3, Water * 6)
                .build()
                .setFormula('KCl.MgCl2 * (H2O)6', true);

        Kainite = new Material.Builder(7041, SuSyUtility.susyId('kainite'))
                .dust()
                .iconSet(SHINY)
                .color(0xfff7c4)
                .components(Potassium, Magnesium, Sulfur, Oxygen * 4, Chlorine, Water * 3)
                .build()
                .setFormula('KMg(SO4)Cl * (H2O)3', true);

        Kieserite = new Material.Builder(7042, SuSyUtility.susyId('kieserite'))
                .dust()
                .color(0xdccade)
                .components(Magnesium, Sulfur, Oxygen * 4, Water)
                .build()
                .setFormula('MgSO4 * H2O', true);

        Polyhalite = new Material.Builder(7043, SuSyUtility.susyId('polyhalite'))
                .dust()
                .color(0xe0b2a4)
                .components(Potassium * 2, Calcium * 2, Magnesium, Sulfur * 4, Oxygen * 16, Water * 2)
                .build()
                .setFormula('K2Ca2Mg(SO4)4 * (H2O)2', true);

        Titanite = new Material.Builder(7045, SuSyUtility.susyId('titanite'))
                .gem()
                .iconSet(SHINY)
                .color(0x967051)
                .components(Calcium, Titanium, Silicon, Oxygen * 5)
                .build();

        Leucoxene = new Material.Builder(7046, SuSyUtility.susyId('leucoxene'))
                .dust()
                .iconSet(SHINY)
                .color(0xb987c4)
                .components(Titanium, Oxygen * 2)
                .build();

        Zircon = new Material.Builder(7047, SuSyUtility.susyId('zircon')) // TODO: remove liquid for 2.8.6
                .gem().ore().liquid().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .iconSet(SHINY)
                .flags(GENERATE_SIFTED, GENERATE_FLOTATED, GENERATE_CONCENTRATE)
                .color(0xf05c51)
                .components(Zirconium, Silicon, Oxygen * 4)
                .build();

        Mimetite = new Material.Builder(7048, SuSyUtility.susyId('mimetite'))
                .dust()
                .iconSet(SHINY)
                .color(0xe8aa2e)
                .components(Lead * 5, Arsenic * 3, Oxygen * 12, Chlorine)
                .build()
                .setFormula('Pb5(AsO4)3Cl', true);

        Pyromorphite = new Material.Builder(7049, SuSyUtility.susyId('pyromorphite'))
                .dust()
                .iconSet(SHINY)
                .color(0xd7e632)
                .components(Lead * 5, Phosphorus * 4, Oxygen * 12, Chlorine)
                .build()
                .setFormula('Pb5(PO4)3Cl', true);

        Descloizite = new Material.Builder(7050, SuSyUtility.susyId('descloizite'))
                .dust()
                .iconSet(SHINY)
                .color(0x5e5d41)
                .components(Lead, Zinc, Vanadium, Oxygen * 5, Hydrogen)
                .build()
                .setFormula('(Pb,Zn)2VO4OH', true);

        Mottramite = new Material.Builder(7051, SuSyUtility.susyId('mottramite'))
                .dust()
                .color(0x53730a)
                .components(Lead, Copper, Vanadium, Oxygen * 5, Hydrogen)
                .build()
                .setFormula('PbCu(VO4)(OH)', true);

        Chlorapatite = new Material.Builder(7052, SuSyUtility.susyId('chlorapatite'))
                .dust().gem().ore()
                .iconSet(SHINY)
                .color(0xc7af85)
                .components(Calcium * 5, Phosphorus * 3, Oxygen * 12, Chlorine)
                .build()
                .setFormula('Ca5(PO4)3Cl', true);

        Hematite = new Material.Builder(7053, SuSyUtility.susyId('hematite'))
                .dust()
                .color(0x240f0f)
                .components(Iron * 2, Oxygen * 3)
                .build();

        Skutterudite = new Material.Builder(7054, SuSyUtility.susyId('skutterudite'))
                .dust()
                .iconSet(SHINY)
                .color(0xabbec2)
                .components(Cobalt, Arsenic * 3)
                .build();

        Allanite = new Material.Builder(7055, SuSyUtility.susyId('allanite'))
                .dust()
                .iconSet(SHINY)
                .color(0x6b7a7d)
                .components(Cerium, Calcium, Yttrium, Lanthanum, Aluminium, Iron, Silicon * 3, Oxygen * 13, Hydrogen)
                .build()
                .setFormula('(Ce,Ca,Y,La)2(Al,Fe)3(SiO4)3(OH)', true);

        Azurite = new Material.Builder(7056, SuSyUtility.susyId('azurite'))
                .dust().gem()
                .iconSet(SHINY)
                .color(0x2216c9)
                .components(Copper * 3, Carbon * 2, Oxygen * 8, Hydrogen * 2)
                .build()
                .setFormula('Cu3(CO3)2(OH)2', true);

        Goethite = new Material.Builder(7057, SuSyUtility.susyId('goethite'))
                .dust()
                .color(0x30251f)
                .components(Iron, Oxygen * 2, Hydrogen)
                .build()
                .setFormula('α-FeO(OH)', true);

        Hydrozincite = new Material.Builder(7058, SuSyUtility.susyId('hydrozincite'))
                .dust()
                .color(0xebd5ca)
                .components(Zinc * 5, Carbon * 2, Oxygen * 12, Hydrogen * 6)
                .build()
                .setFormula('Zn5(CO3)2(OH)6', true);

        Chlorargyrite = new Material.Builder(7059, SuSyUtility.susyId('chlorargyrite'))
                .dust()
                .color(0x524728)
                .components(Silver, Chlorine)
                .build();

        Columbite = new Material.Builder(7060, SuSyUtility.susyId('columbite'))
                .ore().dust().fluid(SusyFluidStorageKeys.SLURRY, new FluidBuilder()).fluid(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())
                .color(0x574f2f)
                .iconSet(SHINY)
                .flags(GENERATE_SIFTED, GENERATE_FLOTATED, GENERATE_CONCENTRATE)
                .components(Iron, Manganese, Niobium * 2, Oxygen * 6)
                .build()
                .setFormula('(Fe,Mn)Nb2O6', true);

        Ferrimolybdite = new Material.Builder(7061, SuSyUtility.susyId('ferrimolybdite'))
                .dust()
                .color(0xc1c71c)
                .components(Iron * 2, Molybdenum * 3, Oxygen * 12, Water * 8)
                .build()
                .setFormula('Fe2(MoO4)3 * (H2O)8', true);

        Aguilarite = new Material.Builder(7062, SuSyUtility.susyId('aguilarite'))
                .dust().gem()
                .color(0x303030)
                .iconSet(SHINY)
                .components(Silver * 4, Selenium, Sulfur)
                .build();

        Orpiment = new Material.Builder(7063, SuSyUtility.susyId('orpiment'))
                .dust().gem()
                .color(0xc28034)
                .iconSet(SHINY)
                .components(Arsenic * 2, Sulfur * 3)
                .build();

        Braggite = new Material.Builder(7064, SuSyUtility.susyId('braggite'))
                .ore()
                .color(0x686b5f)
                .components(Platinum, Palladium, Nickel, Sulfur)
                .build()
                .setFormula('(Pt,Pd,Ni)S', true);

        Stannite = new Material.Builder(7065, SuSyUtility.susyId('stannite'))
                .dust()
                .color(0x474f3e)
                .components(Copper * 2, Iron, Tin, Sulfur * 4)
                .build();

        Euxenite = new Material.Builder(7066, SuSyUtility.susyId('euxenite'))
                .dust()
                .color(0x9c973e)
                .components(Yttrium, Calcium, Cerium, Thorium, Niobium, Tantalum, Titanium, Oxygen * 6)
                .build()
                .setFormula('(Y,Ca,Ce,U,Th)(Nb,Ta,Ti)2O6', true);

        Xenotime = new Material.Builder(7067, SuSyUtility.susyId('xenotime'))
                .dust()
                .iconSet(SHINY)
                .color(0x6e572e)
                .components(Yttrium, Phosphorus, Oxygen * 4)
                .build();

        Caliche = new Material.Builder(7068, SuSyUtility.susyId('caliche'))
                .dust()
                .color(0xb3ae98)
                .components(Calcium, Carbon, Oxygen * 3)
                .build();

        Lauterite = new Material.Builder(7069, SuSyUtility.susyId('lauterite'))
                .dust()
                .components(Calcium, Iodine * 2, Oxygen * 6)
                .colorAverage()
                .build()
                .setFormula('Ca(IO3)2', true);

        Langbeinite = new Material.Builder(7070, SuSyUtility.susyId('langbeinite'))
                .dust()
                .components(Potassium * 2, Magnesium * 2, Sulfur * 3, Oxygen * 12)
                .colorAverage()
                .build()
                .setFormula('K2Mg2(SO4)3', true);

        Hydroxyapatite = new Material.Builder(7071, SuSyUtility.susyId('hydroxyapatite'))
                .dust().gem().ore()
                .iconSet(SHINY)
                .color(0xc7afaa)
                .components(Calcium * 5, Phosphorus * 3, Oxygen * 13, Hydrogen)
                .build()
                .setFormula('Ca5(PO4)3OH', true);
        
        Rhodochrosite = new Material.Builder(7072, SuSyUtility.susyId('rhodochrosite'))
                .ore()
                .iconSet(SHINY)
                .components(Manganese, Carbon, Oxygen * 3)
                .colorAverage()
                .build();

        Carnotite = new Material.Builder(7073, SuSyUtility.susyId('carnotite'))
                .ore()
                .components(Potassium * 2, Uranium235 * 2, Oxygen * 12, Vanadium * 2, Water * 3)
                .colorAverage()
                .build();

        Carnotite.setFormula('K2(UO2)2(VO4)2 * 3H2O', true)

        AlluvialPGMSand = new Material.Builder(7074, SuSyUtility.susyId('alluvial_pgm_sand'))
                .ore()
                .color(0x948a5d)
                .build();

        LigniteCoke = new Material.Builder(7075, SuSyUtility.susyId('lignite_coke'))
                .gem(1, 1200)
                .color(0x8f7070).iconSet(LIGNITE)
                .components(Carbon)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        OrthomagmaticDeposit = new Material.Builder(7076, SuSyUtility.susyId("orthomagmatic_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x80081e)
                .build();

        MetamorphicDeposit = new Material.Builder(7077, SuSyUtility.susyId("metamorphic_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x21011c)
                .build();

        SedimentaryDeposit = new Material.Builder(7078, SuSyUtility.susyId("sedimentary_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xfce46d)
                .build();

        HydrothermalDeposit = new Material.Builder(7079, SuSyUtility.susyId("hydrothermal_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xe8e1c1)
                .build();

        AlluvialDeposit = new Material.Builder(7080, SuSyUtility.susyId("alluvial_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xb59e35)
                .build();

        MagmaticHydrothermalDeposit = new Material.Builder(7081, SuSyUtility.susyId("magmatic_hydrothermal_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x91835d)
                .build();

        CoalDeposit = new Material.Builder(7082, SuSyUtility.susyId("coal_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x2c2c2c)
                .build();

        NativeCopperDeposit = new Material.Builder(7083, SuSyUtility.susyId("native_copper_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0xbb5f09)
                .build();

        AnthraciteDeposit = new Material.Builder(7084, SuSyUtility.susyId("anthracite_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x241212)
                .build();

        LigniteDeposit = new Material.Builder(7085, SuSyUtility.susyId("lignite_deposit"))
                .ore()
                .flags(NO_UNIFICATION)
                .color(0x644646)
                .build();
    }
}