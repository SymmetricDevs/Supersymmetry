package material;

import static material.SuSyMaterials.*;
import static globals.Globals.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.fluids.store.FluidStorage;
import gregtech.api.unification.material.properties.*

import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;
import static gregtech.api.fluids.FluidConstants.*;


public class FirstDegreeMaterials {
        
        private static Material generatePurifiedElement(Material material, int id, boolean generateLiquid, boolean generateIngot) {
                def color = material.materialRGB
                def builder = new Material.Builder(id, SuSyUtility.susyId('high_purity_' + material.toString()))
                        .dust()
                        .iconSet(SHINY)
                        .flags(DISABLE_DECOMPOSITION)
                        .color(color)
                        .components(material)

                if (generateLiquid) {
                        builder.liquid(new FluidBuilder().temperature(determineTemperatureLiquid(material)))
                }
        
                if (generateIngot) {
                        builder.ingot()
                }
        
                return builder.build()
        }



    public static void register() {

        log.infoMC('Registering First Degree Materials!');

        // IDs 8000-8100: Pure Elements

        HighPurityLithium = generatePurifiedElement(Lithium, 8000, false, false)
        HighPurityBeryllium = generatePurifiedElement(Beryllium, 8001, false, false)
        HighPurityBoron = generatePurifiedElement(Boron, 8002, false, false)
        HighPurityCarbon = generatePurifiedElement(Carbon, 8003, false, false)
        HighPuritySodium = generatePurifiedElement(Sodium, 8004, false, false)
        HighPurityMagnesium = generatePurifiedElement(Magnesium, 8005, false, false)
        HighPurityAluminium = generatePurifiedElement(Aluminium, 8006, false, false)
        HighPuritySilicon = generatePurifiedElement(Silicon, 8007, true, false)
        HighPurityPhosphorus = generatePurifiedElement(Phosphorus, 8008, true, true)
        HighPuritySulfur = generatePurifiedElement(Sulfur, 8009, false, false)
        HighPurityPotassium = generatePurifiedElement(Potassium, 8010, false, false)
        HighPurityCalcium = generatePurifiedElement(Calcium, 8011, false, false)
        HighPurityScandium = generatePurifiedElement(Scandium, 8012, false, false)
        HighPurityTitanium = generatePurifiedElement(Titanium, 8013, false, false)
        HighPurityVanadium = generatePurifiedElement(Vanadium, 8014, false, false)
        HighPurityChrome = generatePurifiedElement(Chrome, 8015, true, false)
        HighPurityManganese = generatePurifiedElement(Manganese, 8016, false, false)
        HighPurityIron = generatePurifiedElement(Iron, 8017, false, false)
        HighPurityNickel = generatePurifiedElement(Cobalt, 8018, false, false)
        HighPurityCobalt = generatePurifiedElement(Nickel, 8019, false, false)
        HighPurityCopper = generatePurifiedElement(Copper, 8020, false, false)
        HighPurityZinc = generatePurifiedElement(Zinc, 8021, false, false)
        HighPurityGallium = generatePurifiedElement(Gallium, 8022, true, false)
        HighPurityGermanium = generatePurifiedElement(Germanium, 8023, true, true)
        HighPurityArsenic = generatePurifiedElement(Arsenic, 8024, true, false)
        HighPuritySelenium = generatePurifiedElement(Selenium, 8025, true, false)
        HighPurityRubidium = generatePurifiedElement(Rubidium, 8026, false, false)
        HighPurityStronium = generatePurifiedElement(Strontium, 8027, false, false)
        HighPurityYttrium = generatePurifiedElement(Yttrium, 8028, false, false)
        HighPurityZirconium = generatePurifiedElement(Zirconium, 8029, false, false)
        HighPurityNiobium = generatePurifiedElement(Niobium, 8030, false, false)
        HighPurityMolybdenum = generatePurifiedElement(Molybdenum, 8031, false, false)
        HighPurityTechnetium = generatePurifiedElement(Technetium, 8032, false, false)
        HighPurityRuthenium = generatePurifiedElement(Ruthenium, 8033, false, false)
        HighPurityRhodium = generatePurifiedElement(Rhodium, 8034, false, false)
        HighPurityPalladium = generatePurifiedElement(Palladium, 8035, false, false)
        HighPuritySilver = generatePurifiedElement(Silver, 8036, false, false)
        HighPurityCadmium = generatePurifiedElement(Cadmium, 8037, false, false)
        HighPurityIndium = generatePurifiedElement(Indium, 8038, false, false).addFlags(GENERATE_PLATE)
        HighPurityTin = generatePurifiedElement(Tin, 8039, false, false)
        HighPurityAntimony = generatePurifiedElement(Antimony, 8040, false, false)
        HighPurityTellurium = generatePurifiedElement(Tellurium, 8041, false, true)
        HighPurityIodine = generatePurifiedElement(Iodine, 8042, false, false)
        HighPurityCaesium = generatePurifiedElement(Caesium, 8043, false, false)
        HighPurityBarium = generatePurifiedElement(Barium, 8044, false, false)
        HighPurityLanthanum = generatePurifiedElement(Lanthanum, 8045, false, false)
        HighPurityHafnium = generatePurifiedElement(Hafnium, 8046, false, false)
        HighPurityTantalum = generatePurifiedElement(Tantalum, 8047, false, false)
        HighPurityTungsten = generatePurifiedElement(Tungsten, 8048, false, false)
        HighPurityRhenium = generatePurifiedElement(Rhenium, 8049, false, false)
        HighPurityOsmium = generatePurifiedElement(Osmium, 8050, false, false)
        HighPurityIridium = generatePurifiedElement(Iridium, 8051, false, false)
        HighPurityPlatinum = generatePurifiedElement(Platinum, 8052, false, false)
        HighPurityGold = generatePurifiedElement(Gold, 8053, false, true).addFlags(GENERATE_FOIL, GENERATE_PLATE)
        HighPurityThallium = generatePurifiedElement(Thallium, 8054, false, false)
        HighPurityLead = generatePurifiedElement(Lead, 8055, false, false)
        HighPurityBismuth = generatePurifiedElement(Bismuth, 8056, false, false)
        HighPurityCerium = generatePurifiedElement(Cerium, 8057, false, false)
        HighPurityPraesodymium = generatePurifiedElement(Praseodymium, 8058, false, false)
        HighPurityNeodymium = generatePurifiedElement(Neodymium, 8059, false, false)
        HighPuritySamarium = generatePurifiedElement(Samarium, 8060, false, false)
        HighPurityEuropium = generatePurifiedElement(Europium, 8061, false, false)
        HighPurityGadolinium = generatePurifiedElement(Gadolinium, 8062, false, false)
        HighPurityTerbium = generatePurifiedElement(Terbium, 8063, false, false)
        HighPurityDysprosium = generatePurifiedElement(Dysprosium, 8064, false, false)
        HighPurityHolmium = generatePurifiedElement(Holmium, 8065, false, false)
        HighPurityErbium = generatePurifiedElement(Erbium, 8066, false, false)
        HighPurityThulium = generatePurifiedElement(Thulium, 8067, false, false)
        HighPurityYtterbium = generatePurifiedElement(Ytterbium, 8068, false, false)
        HighPurityLutetium = generatePurifiedElement(Lutetium, 8069, false, false)
        HighPurityThorium = generatePurifiedElement(Thorium, 8070, false, false)

        // IDs 8100+: Other first degree elements

        CalciumHydroxide = new Material.Builder(8100, SuSyUtility.susyId('calcium_hydroxide'))
                .dust()
                .components(Calcium, Oxygen * 2, Hydrogen * 2)
                .color(0xcfcabc)
                .build()
                .setFormula("Ca(OH)2", true);

        PotassiumHydroxide = new Material.Builder(8101, SuSyUtility.susyId('potassium_hydroxide'))
                .dust().liquid(new FluidBuilder().temperature(683))
                .components(Potassium, Oxygen, Hydrogen)
                .colorAverage()
                .build();

        PotassiumCarbonate = new Material.Builder(8102, SuSyUtility.susyId('potassium_carbonate'))
                .dust().liquid(new FluidBuilder().temperature(1164))
                .components(Potassium * 2, Carbon, Oxygen * 3)
                .colorAverage()
                .build();

        SodiumSilicate = new Material.Builder(8103, SuSyUtility.susyId('sodium_silicate'))
                .dust()
                .components(Sodium * 2, Silicon, Oxygen * 3)
                .colorAverage()
                .build();

        SodiumAluminate = new Material.Builder(8104, SuSyUtility.susyId('sodium_aluminate'))
                .dust()
                .components(Sodium, Aluminium, Oxygen * 2)
                .colorAverage()
                .build();

        PotassiumBisulfate = new Material.Builder(8105, SuSyUtility.susyId('potassium_bisulfate'))
                .dust().liquid(new FluidBuilder().temperature(470))
                .components(Potassium, Hydrogen, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        CobaltMatte = new Material.Builder(8106, SuSyUtility.susyId("cobalt_matte"))
                .ingot()
                .flags(NO_UNIFICATION)
                .color(0x7070d6)
                .build()
                .setFormula("(Co)(?)", true)

        AmmoniumNitrate = new Material.Builder(8107, SuSyUtility.susyId('ammonium_nitrate'))
                .dust()
                .components(Nitrogen * 2, Oxygen * 3, Hydrogen * 4)
                .colorAverage()
                .build()
                .setFormula("NH4NO3", true);

        AmmoniumSulfate = new Material.Builder(8108, SuSyUtility.susyId('ammonium_sulfate'))
                .dust()
                .components(Nitrogen * 2, Hydrogen * 8, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        AmmoniumSulfate.setFormula("(NH4)2SO4", true)

        SodiumNitrate = new Material.Builder(8109, SuSyUtility.susyId('sodium_nitrate'))
                .dust().liquid(new FluidBuilder().temperature(581))
                .components(Sodium, Nitrogen, Oxygen * 3)
                .colorAverage()
                .build();

        SodiumFluoride = new Material.Builder(8110, SuSyUtility.susyId('sodium_fluoride'))
                .dust().liquid(new FluidBuilder().temperature(1266))
                .components(Sodium, Fluorine)
                .colorAverage()
                .build();

        PotassiumFluoride = new Material.Builder(8111, SuSyUtility.susyId('potassium_fluoride'))
                .dust().liquid(new FluidBuilder().temperature(1131))
                .components(Potassium, Fluorine)
                .colorAverage()
                .build();

        PotassiumTetrafluoroborate = new Material.Builder(8112, SuSyUtility.susyId('potassium_tetrafluoroborate'))
                .dust().liquid(new FluidBuilder().temperature(803))
                .components(Potassium, Boron, Fluorine * 4)
                .color(0x8fb5a3)
                .build();

        SodiumBromide = new Material.Builder(8113, SuSyUtility.susyId('sodium_bromide'))
                .dust()
                .components(Sodium, Bromine)
                .colorAverage()
                .build();

        Fluix = new Material.Builder(8114, SuSyUtility.susyId('fluix'))
                .gem().iconSet(RUBY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_PLATE, GENERATE_LENS)
                .components(Quartzite * 4, Naquadah)
                .color(0x6503b6)
                .build();

        PigIron = new Material.Builder(8115, SuSyUtility.susyId('pig_iron'))
                .ingot().dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron)
                .color(0x99918A)
                .build();

        PigIron.setFormula("(Fe)(?)", true)

        GreenCoke = new Material.Builder(8116, SuSyUtility.susyId('green_coke'))
                .gem(1, 2000).ore(2, 1)
                .color(0x424a34).iconSet(LIGNITE)
                .components(Carbon)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        IronIIISulfate = new Material.Builder(8117, SuSyUtility.susyId('iron_iii_sulfate'))
                .dust()
                .color(0xb09d99)
                .components(Iron * 2, Sulfur * 3, Oxygen * 12)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .build()
                .setFormula("Fe2(SO4)3", true);

        AluminiumHydroxide = new Material.Builder(8118, SuSyUtility.susyId('aluminium_hydroxide'))
                .dust()
                .components(Aluminium, Oxygen * 3, Hydrogen * 3)
                .colorAverage()
                .build()
                .setFormula("Al(OH)3", true);

        AluminiumTrifluoride = new Material.Builder(8119, SuSyUtility.susyId('aluminium_trifluoride'))
                .dust()
                .components(Aluminium, Fluorine * 3)
                .color(0x3d98bf)
                .build()

        GalliumPhosphate = new Material.Builder(8120, SuSyUtility.susyId('gallium_phosphate'))
                .gem().iconSet(RUBY)
                .flags(CRYSTALLIZABLE)
                .components(Gallium, Phosphorus, Oxygen * 4)
                .colorAverage()
                .build()

        GalliumPhosphate.setFormula("GaPO4", true)

        LithiumNiobate = new Material.Builder(8121, SuSyUtility.susyId('lithium_niobate'))
                .dust().gem().iconSet(RUBY)
                .components(Lithium, Niobium, Oxygen * 3)
                .color(0xbcabde)
                .build()

        LeadZirconateTitanate = new Material.Builder(8122, SuSyUtility.susyId('lead_zirconate_titanate'))
                .gem().iconSet(RUBY)
                .components(Lead * 2, Zirconium, Titanium, Oxygen * 6)
                .colorAverage()
                .build()

        BoricAcid = new Material.Builder(8123, SuSyUtility.susyId('boric_acid'))
                .dust()
                .color(0xedece8)
                .components(Hydrogen * 3, Boron, Oxygen * 3)
                .build()

        AmorphousBoron = new Material.Builder(8124, SuSyUtility.susyId('amorphous_boron'))
                .dust()
                .color(0x47464b)
                .build()

        SulfurDichloride = new Material.Builder(8125, SuSyUtility.susyId('sulfur_dichloride'))
                .liquid()
                .components(Sulfur, Chlorine * 2)
                .color(0xd2042d)
                .build()

        BoronTrioxide = new Material.Builder(8126, SuSyUtility.susyId('boron_trioxide'))
                .dust().liquid(new FluidBuilder().temperature(723))
                .color(0xdfcfc2)
                .components(Boron * 2, Oxygen * 3)
                .build()

        ZincChloride = new Material.Builder(8127, SuSyUtility.susyId('zinc_chloride'))
                .dust().liquid(new FluidBuilder().temperature(563))
                .components(Zinc, Chlorine * 2)
                .colorAverage()
                .build()

        SodiumTetraborate = new Material.Builder(8128, SuSyUtility.susyId('sodium_tetraborate'))
                .dust()
                .components(Sodium * 2, Boron * 4, Oxygen * 7)
                .color(0xdbe7db)
                .build()

        ElectrolyticBoron = new Material.Builder(8129, SuSyUtility.susyId('electrolytic_boron'))
                .dust()
                .components(Boron)
                .color(0x9bd4af)
                .build()

        CalciumSulfate = new Material.Builder(8130, SuSyUtility.susyId('calcium_sulfate'))
                .dust()
                .components(Calcium, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        IronIISulfide = new Material.Builder(8131, SuSyUtility.susyId('iron_ii_sulfide'))
                .dust()
                .components(Iron, Sulfur)
                .colorAverage()
                .build();

        PotassiumSulfate = new Material.Builder(8132, SuSyUtility.susyId('potassium_sulfate'))
                .dust()
                .components(Potassium * 2, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        WetAntimonyTrifluoride = new Material.Builder(8133, SuSyUtility.susyId('wet_antimony_trifluoride'))
                .dust()
                .components(Antimony, Fluorine * 3)
                .colorAverage()
                .build();

        CalciumSulfide = new Material.Builder(8134, SuSyUtility.susyId('calcium_sulfide'))
                .dust()
                .components(Calcium, Sulfur)
                .colorAverage()
                .build();

        VanadiumPentoxide = new Material.Builder(8136, SuSyUtility.susyId('vanadium_pentoxide'))
                .dust()
                .components(Vanadium * 2, Oxygen * 5)
                .colorAverage()
                .build();

        PotassiumPersulfate = new Material.Builder(8137, SuSyUtility.susyId('potassium_persulfate'))
                .dust()
                .components(Potassium * 2, Sulfur * 2, Oxygen * 8)
                .colorAverage()
                .build();

        LithiumHydroxide = new Material.Builder(8138, SuSyUtility.susyId('lithium_hydroxide'))
                .dust()
                .components(Lithium, Oxygen, Hydrogen)
                .colorAverage()
                .build();

        CalciumCarbide = new Material.Builder(8139, SuSyUtility.susyId('calcium_carbide'))
                .dust()
                .components(Calcium, Carbon * 2)
                .color(0x87847c)
                .build();

        IronIIChloride = new Material.Builder(8140, SuSyUtility.susyId('iron_ii_chloride'))
                .dust()
                .components(Iron, Chlorine * 2)
                .color(0x9dad37)
                .build()

        CuprousOxide = new Material.Builder(8141, SuSyUtility.susyId('cuprous_oxide'))
                .dust()
                .components(Copper * 2, Oxygen)
                .flags(GENERATE_CATALYST_BED)
                .color(0x822635)
                .build()

        LithiumBromide = new Material.Builder(8142, SuSyUtility.susyId('lithium_bromide'))
                .dust()
                .components(Lithium, Bromine)
                .color(0xC5C5C5)
                .build()

        IronIIIOxide = new Material.Builder(8143, SuSyUtility.susyId('iron_iii_oxide'))
                .dust()
                .components(Iron * 2, Oxygen * 3)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8F0C03)
                .build()

        CopperIIChloride = new Material.Builder(8144, SuSyUtility.susyId('copper_ii_chloride'))
                .dust()
                .components(Copper, Chlorine * 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x12112c)
                .build()

        SiliconCarbide = new Material.Builder(8145, SuSyUtility.susyId('silicon_carbide'))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Silicon, Carbon)
                .color(0x404040)
                .build()

        TungstenTrioxide = new Material.Builder(8146, SuSyUtility.susyId('tungsten_trioxide'))
                .dust()
                .components(Tungsten, Oxygen * 3)
                .color(0x8a9734)
                .build()

        Alumina = new Material.Builder(8147, SuSyUtility.susyId('alumina'))
                .dust().liquid(new FluidBuilder().temperature(2345))
                .flags(GENERATE_PLATE)
                .components(Aluminium * 2, Oxygen * 3)
                .color(0xd0cff7)
                .build()

        BoronCarbide = new Material.Builder(8148, SuSyUtility.susyId('boron_carbide'))
                .dust()
                .components(Boron * 4, Carbon)
                .flags(GENERATE_ROD)
                .colorAverage()
                .build()

        SilverChloride = new Material.Builder(8149, SuSyUtility.susyId('silver_chloride'))
                .dust()
                .components(Silver, Chlorine)
                .colorAverage()
                .build()

        ArsenicIIISulfide = new Material.Builder(8150, SuSyUtility.susyId('arsenic_iii_sulfide'))
                .dust()
                .components(Arsenic * 2, Sulfur * 3)
                .colorAverage()
                .build()

        SodiumArsenide = new Material.Builder(8151, SuSyUtility.susyId('sodium_arsenide'))
                .dust()
                .components(Sodium * 3, Arsenic)
                .colorAverage()
                .build()

        ArsenicVSulfide = new Material.Builder(8152, SuSyUtility.susyId('arsenic_v_sulfide'))
                .dust()
                .components(Arsenic * 2, Sulfur * 5)
                .colorAverage()
                .build()

        CopperSulfate = new Material.Builder(8153, SuSyUtility.susyId('copper_sulfate'))
                .dust()
                .components(Copper, Sulfur, Oxygen * 4)
                .colorAverage()
                .build()

        RoastedSperrylite = new Material.Builder(8154, SuSyUtility.susyId('roasted_sperrylite'))
                .dust()
                .components(Platinum)
                .color(0x3b1754)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SAND)
                .build();

        EnargiteResidue = new Material.Builder(8155, SuSyUtility.susyId('enargite_residue'))
                .dust()
                .components(Copper * 2, Sulfur)
                .color(0x59183c)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(BRIGHT)
                .build()
                .setFormula("(?)Cu2S", true);

        HydrogenChloride = new Material.Builder(8156, SuSyUtility.susyId('hydrogen_chloride'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Chlorine)
                .colorAverage()
                .build();

        HydrogenFluoride = new Material.Builder(8157, SuSyUtility.susyId('hydrogen_fluoride'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Fluorine)
                .colorAverage()
                .build();

        DilutedSaltwater = new Material.Builder(8158, SuSyUtility.susyId('diluted_saltwater'))
                .liquid()
                .components(Salt, Water * 2)
                .color(0x3d61b8)
                .build();

        SodiumHydroxideSolution = new Material.Builder(8159, SuSyUtility.susyId('sodium_hydroxide_solution'))
                .liquid()
                .components(SodiumHydroxide, Water)
                .colorAverage()
                .build();

        IronIIIChlorideSolution = new Material.Builder(8160, SuSyUtility.susyId('iron_iii_chloride_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Iron3Chloride, Water)
                .colorAverage()
                .build();

        DilutedSaltpeterSolution = new Material.Builder(8161, SuSyUtility.susyId('diluted_saltpeter_solution'))
                .liquid()
                .components(Saltpeter, Water * 2)
                .colorAverage()
                .build();

        HydrogenBromide = new Material.Builder(8162, SuSyUtility.susyId('hydrogen_bromide'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Bromine)
                .colorAverage()
                .build();

        DilutedCalciumChlorideSolution = new Material.Builder(8163, SuSyUtility.susyId('diluted_calcium_chloride_solution'))
                .liquid()
                .components(CalciumChloride, Water * 2)
                .colorAverage()
                .build();

        DilutedRockSaltSolution = new Material.Builder(8164, SuSyUtility.susyId('diluted_rock_salt_solution'))
                .liquid()
                .components(RockSalt, Water * 2)
                .colorAverage()
                .build();

        SodiumThioantimoniteSolution = new Material.Builder(8165, SuSyUtility.susyId('sodium_thioantimonite_solution'))
                .liquid()
                .components(Sodium * 12, Antimony * 4, Sulfur * 12, Water * 12)
                .colorAverage()
                .build();

        SodiumThioantimoniteSolution.setFormula("(Na3SbS3)12(H2O)12", true)

        AmmoniaSolution = new Material.Builder(8166, SuSyUtility.susyId('ammonia_solution'))
                .liquid()
                .components(Ammonia, Water)
                .colorAverage()
                .build();

        SaltpeterSolution = new Material.Builder(8167, SuSyUtility.susyId('saltpeter_solution'))
                .liquid()
                .components(Saltpeter, Water)
                .colorAverage()
                .build();

        SaltySaltpeterSolution = new Material.Builder(8168, SuSyUtility.susyId('salty_saltpeter_solution'))
                .liquid()
                .components(Saltpeter, SaltWater)
                .colorAverage()
                .build();

        CarbonDisulfide = new Material.Builder(8169, SuSyUtility.susyId('carbon_disulfide'))
                .liquid()
                .components(Carbon, Sulfur * 2)
                .colorAverage()
                .build();

        CopperISulfide = new Material.Builder(8170, SuSyUtility.susyId('copper_i_sulfide'))
                .dust()
                .components(Copper * 2, Sulfur)
                .color(0x1a1101)
                .build();

        Cryolite = new Material.Builder(8171, SuSyUtility.susyId('cryolite'))
                .dust().liquid(new FluidBuilder().temperature(1285))
                .components(Sodium * 3, Aluminium, Fluorine * 6)
                .color(0x2497a6)
                .build();

        HeavyWater = new Material.Builder(8173, SuSyUtility.susyId('heavy_water'))
                .liquid()
                .components(Deuterium * 2, Oxygen)
                .color(0x2c37b0)
                .build();

        HeavyHydrogenSulfide = new Material.Builder(8174, SuSyUtility.susyId('heavy_hydrogen_sulfide'))
                .gas()
                .components(Deuterium * 2, Sulfur)
                .color(0xb09a2c)
                .build();

        SemiHeavyHydrogenSulfide = new Material.Builder(8175, SuSyUtility.susyId('semiheavy_hydrogen_sulfide'))
                .gas()
                .components(Hydrogen, Deuterium, Sulfur)
                .color(0xc29836)
                .build();

        SemiHeavyWater = new Material.Builder(8176, SuSyUtility.susyId('semiheavy_water'))
                .liquid()
                .components(Hydrogen, Deuterium, Oxygen)
                .color(0x364ec2)
                .build();

        ImpureSemiheavyWater = new Material.Builder(8177, SuSyUtility.susyId('impure_semiheavy_water'))
                .liquid()
                .components(SemiHeavyWater, Water)
                .colorAverage()
                .build();

        IsotopicallyPureHydrogenSulfide = new Material.Builder(8178, SuSyUtility.susyId('isotopically_pure_hydrogen_sulfide'))
                .gas()
                .components(HydrogenSulfide)
                .color(0xffab66)
                .build();

        ImpureSemiheavyHydrogenSulfide = new Material.Builder(8179, SuSyUtility.susyId('impure_semiheavy_hydrogen_sulfide'))
                .gas()
                .components(HydrogenSulfide, SemiHeavyHydrogenSulfide)
                .colorAverage()
                .build();

        ImpureHeavyHydrogenSulfide = new Material.Builder(8180, SuSyUtility.susyId('impure_heavy_hydrogen_sulfide'))
                .gas()
                .components(HydrogenSulfide, HeavyHydrogenSulfide)
                .colorAverage()
                .build();

        TetrafluoroboricAcid = new Material.Builder(8182, SuSyUtility.susyId('tetrafluoroboric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Boron, Fluorine * 4, Water * 3)
                .color(0xa4ab91)
                .build();

        BoronTrichloride = new Material.Builder(8183, SuSyUtility.susyId('boron_trichloride'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID)).plasma()
                .components(Boron, Chlorine * 3)
                .colorAverage()
                .build();

        ProustiteAlkalineLeachSolution = new Material.Builder(8184, SuSyUtility.susyId('proustite_alkaline_leach_solution'))
                .liquid()
                .components(Sodium * 3, Arsenic, Sulfur * 3, Water)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3AsS3)(H2O)", true)

        CrudeArsenicTrichloride = new Material.Builder(8185, SuSyUtility.susyId('crude_arsenic_trichloride'))
                .liquid()
                .components(Arsenic, Chlorine * 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(?)(AsCl3)", true)

        Arsine = new Material.Builder(8186, SuSyUtility.susyId('arsine'))
                .gas()
                .components(Arsenic, Hydrogen * 3)
                .colorAverage()
                .build()

        EnargiteSulfideLeachSolution = new Material.Builder(8187, SuSyUtility.susyId('enargite_sulfide_leach_solution'))
                .liquid()
                .components(Sodium * 3, Arsenic, Sulfur * 4, Water)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3AsS4)(H2O)", true)

        CobaltiteLeachSolution = new Material.Builder(8188, SuSyUtility.susyId('cobaltite_leach_solution'))
                .liquid()
                .components(Cobalt * 3, Nitrogen * 6, Oxygen * 30, Hydrogen * 9, Arsenic * 3, Water * 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Co(NO3)2)3(H3AsO4)3(H2O)3", true)

        ArsenopyriteLeachSolution = new Material.Builder(8189, SuSyUtility.susyId('arsenopyrite_leach_solution'))
                .liquid()
                .components(Iron * 3, Nitrogen * 6, Oxygen * 32, Hydrogen * 13, Arsenic * 3, Water * 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Fe(NO3)2)3(H3AsO4)3(H2O)3", true)

        CopperIISulfide = new Material.Builder(8190, SuSyUtility.susyId('copper_ii_sulfide'))
                .dust()
                .components(Copper, Sulfur)
                .color(0x262626)
                .build()

        ArsenicTrichloride = new Material.Builder(8191, SuSyUtility.susyId('arsenic_trichloride'))
                .liquid()
                .components(Arsenic, Chlorine * 3)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()

        PotassiumPermanganate = new Material.Builder(8192, SuSyUtility.susyId('potassium_permanganate'))
                .dust()
                .components(Potassium, Manganese, Oxygen * 4)
                .color(0x320354)
                .build();

        SperryliteWaste = new Material.Builder(8193, SuSyUtility.susyId('sperrylite_waste'))
                .liquid()
                .components(Chlorine * 4, Cobalt, Nickel, Water * 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("[(Ni,Co)Cl2](H2O)4", true)

        AcidicCopperSolution = new Material.Builder(8194, SuSyUtility.susyId('acidic_copper_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Copper * 2, Sulfur * 2, Oxygen * 8, NitricAcid * 2, Water * 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(CuSO4)2(HNO3)2(H2O)4", true)

        WustiteCatalyst = new Material.Builder(8195, SuSyUtility.susyId('wustite_catalyst'))
                .dust()
                .components(Iron, Oxygen)
                .color(0x696e62)
                .build()

        PalladiumChloride = new Material.Builder(8196, SuSyUtility.susyId('palladium_chloride'))
                .dust()
                .iconSet(SHINY)
                .components(Palladium, Chlorine * 2)
                .colorAverage()
                .build()

        HexachloroiridicAcid = new Material.Builder(8197, SuSyUtility.susyId('hexachloroiridic_acid'))
                .dust()
                .iconSet(SHINY)
                .components(Chlorine * 6, Hydrogen * 2, Iridium)
                .colorAverage()
                .build()

        PotassiumIodide = new Material.Builder(8198, SuSyUtility.susyId('potassium_iodide'))
                .dust()
                .components(Potassium, Iodine)
                .colorAverage()
                .build()

        IridiumIodide = new Material.Builder(8199, SuSyUtility.susyId('iridium_iodide'))
                .dust()
                .components(Iridium, Iodine * 4)
                .colorAverage()
                .build()

        PhosphorusTrichloride = new Material.Builder(8200, SuSyUtility.susyId('phosphorus_trichloride'))
                .liquid()
                .components(Phosphorus, Chlorine * 3)
                .colorAverage()
                .build()

        Diamminedichloropalladium = new Material.Builder(8201, SuSyUtility.susyId('diamminedichloropalladium'))
                .dust()
                .components(Palladium, Nitrogen * 2, Hydrogen * 6, Chlorine * 2)
                .color(0xd4d192)
                .build();

        Diamminedichloropalladium.setFormula("Pd(NH3)2Cl2", true)

        DecarburizedAir = new Material.Builder(8202, SuSyUtility.susyId('decarburized_air'))
                .gas()
                .components(Nitrogen * 78, Oxygen * 21, Argon)
                .color(0x90bbe0)
                .build();

        ZincOxide = new Material.Builder(8203, SuSyUtility.susyId("zinc_oxide"))
                .dust()
                .components(Zinc, Oxygen)
                .color(0xFFFFF5)
                .build();

        HydrogenSilsesquioxane = new Material.Builder(8204, SuSyUtility.susyId('hydrogen_silsesquioxane'))
                .dust()
                .color(0xC7C0CB)
                .components(Hydrogen * 8, Silicon * 8, Oxygen * 12)
                .build()

        SodiumDichromate = new Material.Builder(8205, SuSyUtility.susyId('sodium_dichromate'))
                .dust()
                .components(Sodium * 2, Chrome * 2, Oxygen * 7)
                .colorAverage()
                .build()

        RaneyNickel = new Material.Builder(8206, SuSyUtility.susyId('raney_nickel'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Nickel, Aluminium)
                .color(0x858aa1)
                .build()

        ActivatedRaneyNickel = new Material.Builder(8207, SuSyUtility.susyId('activated_raney_nickel'))
                .dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nickel, Aluminium)
                .color(0xa9aec4)
                .build()

        PurifiedAntimonyTrichloride = new Material.Builder(8208, SuSyUtility.susyId('purified_antimony_trichloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(347))
                .components(Antimony * 1, Chlorine * 3)
                .color(0x83b87b)
                .build();

        PurifiedAntimonyTrioxide = new Material.Builder(8209, SuSyUtility.susyId('purified_antimony_trioxide'))
                .dust()
                .components(Antimony * 2, Oxygen * 3)
                .color(0x92d1d4)
                .build();

        DicobaltOctacarbonyl = new Material.Builder(8210, SuSyUtility.susyId('dicobalt_octacarbonyl'))
                .dust()
                .components(Cobalt * 2, Cobalt * 8, Oxygen * 8)
                .colorAverage()
                .build()
                .setFormula("Co2(CO)8", true)

        ImpregnatedAluminaCatalyst = new Material.Builder(8211, SuSyUtility.susyId('impregnated_alumina_catalyst'))
                .dust()
                .components(SiliconDioxide, Alumina)
                .colorAverage()
                .build()

        BismuthCopper = new Material.Builder(8212, SuSyUtility.susyId('bismuth_copper'))
                .dust()
                .components(Bismuth, Copper)
                .flags(GENERATE_CATALYST_BED)
                .colorAverage()
                .build()

        Bromobenzene = new Material.Builder(8213, SuSyUtility.susyId('bromobenzene'))
                .liquid()
                .components(Carbon * 6, Hydrogen * 5, Bromine)
                .colorAverage()
                .build()

        ManganeseIISulfate = new Material.Builder(8214, SuSyUtility.susyId('manganese_ii_sulfate'))
                .dust()
                .components(Manganese, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        Triethylaluminium = new Material.Builder(8215, SuSyUtility.susyId('triethylaluminium'))
                .liquid()
                .components(Carbon * 12, Hydrogen * 30, Aluminium * 2)
                .colorAverage()
                .build()

        Triethylaluminium.setFormula("Al2(C2H5)6", true)

        HydrogenPeroxide = new Material.Builder(8216, SuSyUtility.susyId('hydrogen_peroxide'))
                .liquid()
                .components(Hydrogen * 2, Oxygen * 2)
                .colorAverage()
                .build()

        CarbonTetrabromide = new Material.Builder(8217, SuSyUtility.susyId('carbon_tetrabromide'))
                .dust()
                .components(Carbon, Bromine * 4)
                .colorAverage()
                .build()

        Bromomethane = new Material.Builder(8218, SuSyUtility.susyId('bromomethane'))
                .gas()
                .components(Carbon, Hydrogen * 3, Bromine)
                .colorAverage()
                .build()

        VeryDilutedSulfuricAcid = new Material.Builder(8219, SuSyUtility.susyId('very_diluted_sulfuric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid, Water * 2)
                .color(0x54362c)
                .build()

        HeavyNetherGases = new Material.Builder(8220, SuSyUtility.susyId('heavy_nether_gases'))
                .gas()
                .components(CarbonDioxide * 3, HydrogenSulfide)
                .colorAverage()
                .build();

        ThionylChloride = new Material.Builder(8221, SuSyUtility.susyId('thionyl_chloride'))
                .liquid()
                .components(Sulfur, Oxygen, Chlorine * 2)
                .colorAverage()
                .build()

        LithiumHydride = new Material.Builder(8222, SuSyUtility.susyId('lithium_hydride'))
                .dust()
                .components(Lithium, Hydrogen)
                .colorAverage()
                .build()

        BoronTrifluoride = new Material.Builder(8223, SuSyUtility.susyId('boron_trifluoride'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Boron, Fluorine * 3)
                .colorAverage()
                .build()

        Diborane = new Material.Builder(8224, SuSyUtility.susyId('diborane'))
                .gas()
                .components(Boron * 2, Hydrogen * 6)
                .color(0x524545)
                .build()

        LithiumFluoride = new Material.Builder(8225, SuSyUtility.susyId('lithium_fluoride'))
                .dust()
                .components(Lithium, Fluorine)
                .colorAverage()
                .build()

        LithiumTetrafluoroborate = new Material.Builder(8226, SuSyUtility.susyId('lithium_tetrafluoroborate'))
                .dust()
                .components(Lithium, Boron, Fluorine * 4)
                .colorAverage()
                .build()

        TetramethylammoniumChloride = new Material.Builder(8227, SuSyUtility.susyId('tetramethylammonium_chloride'))
                .dust()
                .components(Carbon * 4, Hydrogen * 12, Nitrogen, Chlorine)
                .colorAverage()
                .build()

        TetramethylammoniumHydroxide = new Material.Builder(8228, SuSyUtility.susyId('tetramethylammonium_hydroxide'))
                .dust()
                .components(Carbon * 4, Hydrogen * 13, Nitrogen, Oxygen)
                .colorAverage()
                .build()

        MethacrylamideSulfate = new Material.Builder(8229, SuSyUtility.susyId('methacrylamide_sulfate'))
                .dust()
                .components(Carbon * 4, Hydrogen * 9, Nitrogen, Oxygen * 5, Sulfur)
                .colorAverage()
                .build()

        AmmoniumBisulfate = new Material.Builder(8230, SuSyUtility.susyId('ammonium_bisulfate'))
                .dust().liquid(new FluidBuilder().temperature(563))
                .components(Nitrogen, Hydrogen * 5, Sulfur, Oxygen * 4)
                .colorAverage()
                .build()
                .setFormula("(NH4)HSO4", true)

        Phosphine = new Material.Builder(8231, SuSyUtility.susyId('phosphine'))
                .gas()
                .components(Phosphorus, Hydrogen * 3)
                .colorAverage()
                .build()

        PotassiumHypophosphite = new Material.Builder(8232, SuSyUtility.susyId('potassium_hypophosphite'))
                .dust()
                .components(Potassium, Phosphorus, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build()

        SodiumHypophosphite = new Material.Builder(8233, SuSyUtility.susyId('sodium_hypophosphite'))
                .dust()
                .components(Sodium, Phosphorus, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build()

        DipotassiumPhosphate = new Material.Builder(8234, SuSyUtility.susyId('dipotassium_phosphate'))
                .dust()
                .components(Potassium * 2, Hydrogen, Phosphorus, Oxygen * 4)
                .colorAverage()
                .build()

        DisodiumPhosphate = new Material.Builder(8235, SuSyUtility.susyId('disodium_phosphate'))
                .dust()
                .components(Sodium * 2, Hydrogen, Phosphorus, Oxygen * 4)
                .colorAverage()
                .build()

        SodiumCyanide = new Material.Builder(8236, SuSyUtility.susyId('sodium_cyanide'))
                .dust()
                .components(Sodium, Carbon, Nitrogen)
                .colorAverage()
                .build()

        PhosphorylChloride = new Material.Builder(8237, SuSyUtility.susyId('phosphoryl_chloride'))
                .liquid()
                .components(Phosphorus, Oxygen, Chlorine * 3)
                .colorAverage()
                .build()

        PhosphorusPentachloride = new Material.Builder(8238, SuSyUtility.susyId('phosphorus_pentachloride'))
                .dust()
                .components(Phosphorus, Chlorine * 5)
                .colorAverage()
                .build()

        AmmoniumIodide = new Material.Builder(8240, SuSyUtility.susyId('ammonium_iodide'))
                .dust().liquid(new FluidBuilder().temperature(824))
                .components(Nitrogen, Hydrogen * 4, Iodine)
                .colorAverage()
                .build()

        HydrobromicAcid = new Material.Builder(8241, SuSyUtility.susyId('hydrobromic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Bromine, Water)
                .colorAverage()
                .build()

        HydrobromicAcid.setFormula("(HBr)(H2O)", true)

        AluminiumChloride = new Material.Builder(8242, SuSyUtility.susyId('aluminium_chloride'))
                .dust().gas(new FluidBuilder().temperature(453))
                .flags(GENERATE_CATALYST_BED)
                .components(Aluminium, Chlorine * 3)
                .colorAverage()
                .build()

        SodiumSulfite = new Material.Builder(8243, SuSyUtility.susyId('sodium_sulfite'))
                .dust()
                .components(Sodium * 2, Sulfur, Oxygen * 3)
                .colorAverage()
                .build()

        SodiumThiosulfate = new Material.Builder(8244, SuSyUtility.susyId('sodium_thiosulfate'))
                .dust()
                .components(Sodium * 2, Sulfur * 2, Oxygen * 3)
                .color(0x879e21)
                .build()

        SulfidicSilverCyanideSolution = new Material.Builder(8247, SuSyUtility.susyId('sulfidic_silver_cyanide_solution'))
                .liquid()
                .components(Silver * 2, Carbon * 4, Nitrogen * 4, Sodium * 4, Sulfur, Water * 8)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na[Ag(CN)2])2(Na2S)(H2O)8", true)

        SilverCyanideSolution = new Material.Builder(8248, SuSyUtility.susyId('silver_cyanide_solution'))
                .liquid()
                .components(Silver * 2, Carbon * 4, Nitrogen * 4, Sodium * 4, Chlorine * 2, Water * 4)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na[Ag(CN)2])2(NaCl)2(H2O)4", true)

        SulfidicPyrargyriteCyanideLeachSolution = new Material.Builder(8249, SuSyUtility.susyId('sulfidic_pyrargyrite_cyanide_leach_solution'))
                .liquid()
                .components(Sodium * 6, Silver * 3, Carbon * 6, Nitrogen * 6, Antimony, Sulfur * 3, Water * 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na[Ag(CN)2])3(Na3SbS3)(H2O)12", true)

        PyrargyriteCyanideLeachSolution = new Material.Builder(8250, SuSyUtility.susyId('pyrargyrite_cyanide_leach_solution'))
                .liquid()
                .components(Sodium * 6, Silver * 3, Carbon * 6, Nitrogen * 6, Chlorine * 3, Water * 12)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na[Ag(CN)2])3(NaCl)3(H2O)12", true)

        PyrargyriteThiosulfateLeachSolution = new Material.Builder(8251, SuSyUtility.susyId('pyrargyrite_thiosulfate_leach_solution'))
                .liquid()
                .components(Sodium * 12, Silver * 3, Sulfur * 15, Oxygen * 18, Antimony, Water * 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3[Ag(S2O3)2])3(Na3SbS3)(H2O)5", true)

        ThiosulfateThioantimoniteSolution = new Material.Builder(8252, SuSyUtility.susyId('thiosulfate_thioantimonite_solution'))
                .liquid()
                .components(Sodium * 15, Sulfur * 15, Oxygen * 18, Antimony, Water * 5)
                .colorAverage()
                .build()
                .setFormula("(Na2S2O3)6(Na3SbS3)(H2O)5", true)

        ThiosulfateThioarseniteSolution = new Material.Builder(8253, SuSyUtility.susyId('thiosulfate_thioarsenite_solution'))
                .liquid()
                .components(Sodium * 15, Sulfur * 15, Oxygen * 18, Arsenic, Water * 5)
                .colorAverage()
                .build()
                .setFormula("(Na2S2O3)6(Na3AsS3)(H2O)5", true)

        SulfidicStephaniteCyanideLeachSolution = new Material.Builder(8254, SuSyUtility.susyId('sulfidic_stephanite_cyanide_leach_solution'))
                .liquid()
                .components(Sodium * 10, Silver * 5, Carbon * 10, Nitrogen * 10, Antimony, Sulfur * 4, Water * 10)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na[Ag(CN)2])5(Na3SbS3)(Na2S)(H2O)20", true)

        StephaniteCyanideLeachSolution = new Material.Builder(8255, SuSyUtility.susyId('stephanite_cyanide_leach_solution'))
                .liquid()
                .components(Sodium * 10, Silver * 5, Carbon * 10, Nitrogen * 10, Chlorine * 5, Water * 10)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na[Ag(CN)2])5(NaCl)3(H2O)20", true)

        ProustiteThiosulfateLeachSolution = new Material.Builder(8256, SuSyUtility.susyId('proustite_thiosulfate_leach_solution'))
                .liquid()
                .components(Sodium * 12, Silver * 3, Sulfur * 15, Oxygen * 18, Arsenic, Water * 5)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(Na3[Ag(S2O3)2])3(Na3AsS3)(H2O)5", true)

        AcidicArsenateVSolution = new Material.Builder(8257, SuSyUtility.susyId('acidic_arsenate_v_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 9, Arsenic * 3, Oxygen * 12, NitricAcid * 6)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build()
                .setFormula("(H3AsO4)3(HNO3)6", true)

        ArsenicVOxide = new Material.Builder(8258, SuSyUtility.susyId('arsenic_v_oxide'))
                .dust()
                .components(Arsenic * 2, Oxygen * 5)
                .colorAverage()
                .build()

        SilverOxide = new Material.Builder(8259, SuSyUtility.susyId('silver_oxide'))
                .dust()
                .components(Silver * 2, Oxygen)
                .colorAverage()
                .build()

        SilverSulfide = new Material.Builder(8260, SuSyUtility.susyId('silver_sulfide'))
                .dust()
                .components(Silver * 2, Sulfur)
                .colorAverage()
                .build()

        IronThioantimonite = new Material.Builder(8261, SuSyUtility.susyId('iron_thioantimonite'))
                .dust()
                .components(Iron, Antimony, Sulfur * 3)
                .colorAverage()
                .build()

        AntimonyIIISulfide = new Material.Builder(8262, SuSyUtility.susyId('antimony_iii_sulfide'))
                .dust()
                .components(Antimony * 2, Sulfur * 3)
                .colorAverage()
                .build()

        IronThioarsenite = new Material.Builder(8263, SuSyUtility.susyId('iron_thioarsenite'))
                .dust()
                .components(Iron, Arsenic, Sulfur * 3)
                .colorAverage()
                .build()

        ManganeseIIOxide = new Material.Builder(8265, SuSyUtility.susyId('manganese_ii_oxide'))
                .dust()
                .components(Manganese, Oxygen)
                .color(0x472400)
                .build()

        RaneyCobalt = new Material.Builder(8266, SuSyUtility.susyId('raney_cobalt'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Cobalt, Aluminium)
                .color(0x1858a1)
                .build();

        ActivatedRaneyCobalt = new Material.Builder(8267, SuSyUtility.susyId('activated_raney_cobalt'))
                .dust()
                .iconSet(SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Cobalt, Aluminium)
                .color(0x3274bf)
                .build();

        IronIIIHydroxide = new Material.Builder(8268, SuSyUtility.susyId('iron_iii_hydroxide'))
                .dust()
                .components(Iron, Oxygen * 3, Hydrogen * 3)
                .color(0xcc7e35)
                .iconSet(SAND)
                .build()
                .setFormula("Fe(OH)3", true)

        Cellulose = new Material.Builder(8269, SuSyUtility.susyId('cellulose'))
                .dust()
                .components(Carbon * 6, Hydrogen * 10, Oxygen * 5)
                .color(0x4a432f)
                .build()

        CrudeGalliumTrichloride = new Material.Builder(8270, SuSyUtility.susyId('crude_gallium_trichloride'))
                .dust().liquid(new FluidBuilder().temperature(351))
                .components(Gallium, Chlorine * 3)
                .colorAverage()
                .build()
                .setFormula("(?)GaCl3", true)

        GalliumTrichloride = new Material.Builder(8271, SuSyUtility.susyId('gallium_trichloride'))
                .liquid(new FluidBuilder().temperature(351))
                .components(Gallium, Chlorine * 3)
                .colorAverage()
                .build()
                .setFormula("GaCl3", true)

        MercuryIIChloride = new Material.Builder(8272, SuSyUtility.susyId('mercury_ii_chloride'))
                .dust()
                .components(Mercury, Chlorine * 2)
                .colorAverage()
                .build()

        BoronNitride = new Material.Builder(8273, SuSyUtility.susyId('boron_nitride'))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Boron, Nitrogen)
                .colorAverage()
                .build()

        CrudeIronPentacarbonyl = new Material.Builder(8275, SuSyUtility.susyId('crude_iron_pentacarbonyl'))
                .liquid()
                .components(Iron, Carbon * 5, Oxygen * 5)
                .color(0x362f2b)
                .build()
                .setFormula("Fe(CO)5", true)

        AluminiumSulfate = new Material.Builder(8276, SuSyUtility.susyId('aluminium_sulfate'))
                .dust()
                .components(Aluminium * 2, Sulfur * 3, Oxygen * 12)
                .colorAverage()
                .build()

        AluminiumSulfate.setFormula("Al2(SO4)3", true)

        DemineralizedWater = new Material.Builder(8277, SuSyUtility.susyId('demineralized_water'))
                .liquid()
                .components(Hydrogen * 2, Oxygen)
                .color(0x4761a8)
                .build()

        DeaeratedWater = new Material.Builder(8278, SuSyUtility.susyId('deaerated_water'))
                .liquid()
                .components(Hydrogen * 2, Oxygen)
                .color(0x5681b3)
                .build()

        FilteredWater = new Material.Builder(8279, SuSyUtility.susyId('filtered_water'))
                .liquid()
                .components(Hydrogen * 2, Oxygen)
                .color(0x62a0bd)
                .build()

        SterilizedWater = new Material.Builder(8280, SuSyUtility.susyId('sterilized_water'))
                .liquid()
                .components(Hydrogen * 2, Oxygen)
                .color(0x6cb3c4)
                .build()

        UltrapureWater = new Material.Builder(8281, SuSyUtility.susyId('ultrapure_water'))
                .liquid()
                .components(Hydrogen * 2, Oxygen)
                .color(0x7acacf)
                .build()

        Ferrochromium = new Material.Builder(8282, SuSyUtility.susyId('ferrochromium'))
                .dust()
                .components(Iron, Chrome * 2)
                .color(0x6b6552)
                .build()

        Ferrosilicon = new Material.Builder(8283, SuSyUtility.susyId('ferrosilicon'))
                .dust()
                .components(Iron, Silicon * 3)
                .iconSet(SHINY)
                .color(0x999a99)
                .build()

        ConcentratedSaltWater = new Material.Builder(8284, SuSyUtility.susyId('concentrated_salt_water'))
                .liquid()
                .components(Salt * 2, Water)
                .colorAverage()
                .build();

        HypersalineWater = new Material.Builder(8285, SuSyUtility.susyId('hypersaline_water'))
                .liquid()
                .components(Salt * 4, Water)
                .colorAverage()
                .build();

        CryogenicSolder = new Material.Builder(8286, SuSyUtility.susyId('cryogenic_solder'))
                .dust().ingot().liquid(new FluidBuilder().temperature(430))
                .components(Indium * 27, Silver * 1)
                .color(0x8967bf)
                .build();

        CryogenicSolder.setFormula("In97Ag3", true)


        LithiumCobaltOxide = new Material.Builder(8287, SuSyUtility.susyId('lithium_cobalt_oxide'))
                .dust()
                .components(Lithium, Cobalt, Oxygen * 2)
                .colorAverage()
                .build();

        SodiumCathodeAlloy = new Material.Builder(8288, SuSyUtility.susyId('sodium_cathode_alloy'))
                .dust()
                .components(Sodium * 4, Iron * 3, Manganese * 3, Oxygen * 12)
                .colorAverage()
                .build();

        LithiumHexafluorophosphate = new Material.Builder(8289, SuSyUtility.susyId('lithium_hexafluorophosphate'))
                .dust()
                .components(Lithium, Phosphorus, Fluorine * 6)
                .colorAverage()
                .build();

        NickelChloride = new Material.Builder(8290, SuSyUtility.susyId('nickel_chloride'))
                .dust()
                .components(Nickel, Chlorine * 2)
                .colorAverage()
                .build();

        NickelHydroxide = new Material.Builder(8291, SuSyUtility.susyId('nickel_hydroxide'))
                .dust()
                .components(Nickel, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build();

        NickelHydroxide.setFormula("Ni(OH)2", true)

        NickelOxideHydroxide = new Material.Builder(8292, SuSyUtility.susyId('nickel_oxide_hydroxide'))
                .dust()
                .components(Nickel, Oxygen * 3, Hydrogen * 2)
                .colorAverage()
                .build();

        NickelOxideHydroxide.setFormula("NiO(OH)2", true)

        SilverNitrateSolution = new Material.Builder(8293, SuSyUtility.susyId('silver_nitrate_solution'))
                .liquid()
                .components(Silver, Nitrogen, Oxygen * 3, Water)
                .colorAverage()
                .build();

        SilverNitrateSolution.setFormula("(AgNO3)(H2O)", true)

        ChloroauricAcid = new Material.Builder(8294, SuSyUtility.susyId('chloroauric_acid'))
                .dust()
                .components(Hydrogen, Gold, Chlorine * 4)
                .color(0xcc8821)
                .build();

        ChloroauricAcid.setFormula("H[AuCl4]", true)

        SpentMoebiusElectrolyte = new Material.Builder(8295, SuSyUtility.susyId('spent_moebius_electrolyte'))
                .liquid()
                .components(Silver, Nitrogen, Oxygen * 3, Water)
                .colorAverage()
                .build();

        SpentMoebiusElectrolyte.setFormula("(?)(AgNO3)(H2O)", true)

        ActivatedCarbon = new Material.Builder(8296, SuSyUtility.susyId('activated_carbon'))
                .dust()
                .components(Carbon)
                .color(0x38393b)
                .build();

        SulfuricPGMSolution = new Material.Builder(8297, SuSyUtility.susyId('sulfuric_pgm_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid * 3, HydrochloricAcid * 12, Water * 8)
                .colorAverage()
                .build();

        SulfuricPGMSolution.setFormula("(?)(H2SO4)3(HCl)12(H2O)8", true)

        PGMSolution = new Material.Builder(8298, SuSyUtility.susyId('pgm_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HydrochloricAcid * 12, Water * 12)
                .colorAverage()
                .build();

        PGMSolution.setFormula("(?)(HCl)12(H2O)12", true)

        GoldPlatedSteel = new Material.Builder(8299, SuSyUtility.susyId('gold_plated_steel'))
                .ingot()
                .components(Gold, Steel)
                .color(0xb8a639)
                .flags(GENERATE_FINE_WIRE)
                .build();

        GoldConcentrate = new Material.Builder(8300, SuSyUtility.susyId('gold_concentrate'))
                .dust()
                .components(SiliconDioxide * 4, Gold)
                .colorAverage()
                .iconSet(SAND)
                .build();

        LoadedCarbon = new Material.Builder(8301, SuSyUtility.susyId('loaded_carbon'))
                .dust()
                .components(Sodium, Gold, Carbon * 3, Nitrogen * 2)
                .color(0x44453b)
                .build();

        LoadedCarbon.setFormula("(Na[Au(CN)2])C", true)

        SpentActivatedCarbon = new Material.Builder(8302, SuSyUtility.susyId('spent_activated_carbon'))
                .dust()
                .components(Carbon)
                .color(0x262729)
                .build();

        WashedActivatedCarbon = new Material.Builder(8303, SuSyUtility.susyId('washed_activated_carbon'))
                .dust()
                .components(Carbon)
                .color(0x2d302b)
                .build();

        CalciumOrthosilicate = new Material.Builder(8304, SuSyUtility.susyId('calcium_orthosilicate'))
                .dust()
                .components(Calcium * 2, Silicon, Oxygen * 4)
                .colorAverage()
                .build();

        MagnesiumChlorideSolution = new Material.Builder(8305, SuSyUtility.susyId('magnesium_chloride_solution'))
                .liquid()
                .components(MagnesiumChloride, Water * 2)
                .colorAverage()
                .build();

        MagnesiumHydroxide = new Material.Builder(8306, SuSyUtility.susyId('magnesium_hydroxide'))
                .dust()
                .components(Magnesium, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build();

        MagnesiumHydroxide.setFormula("Mg(OH)2", true)

        MagnesiumSulfate = new Material.Builder(8307, SuSyUtility.susyId('magnesium_sulfate'))
                .dust()
                .components(Magnesium, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        CeriumIVOxide = new Material.Builder(8308, SuSyUtility.susyId('cerium_iv_oxide'))
                .dust()
                .components(Cerium, Oxygen * 2)
                .colorAverage()
                .build();

        CeriumIIIOxide = new Material.Builder(8309, SuSyUtility.susyId('cerium_iii_oxide'))
                .dust()
                .components(Cerium * 2, Oxygen * 3)
                .colorAverage()
                .build();

        IronSulfate = new Material.Builder(8310, SuSyUtility.susyId('iron_sulfate'))
                .dust()
                .components(Iron, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        RoastedPetalite = new Material.Builder(8311, SuSyUtility.susyId('roasted_petalite'))
                .dust()
                .color(0xabc9c9)
                .components(Lithium, Aluminium, Silicon * 4, Oxygen * 10)
                .iconSet(SAND)
                .build()
                .setFormula("(LiAlSi2O6)(SiO2)2", true)

        BetaSpodumene = new Material.Builder(8312, SuSyUtility.susyId('beta_spodumene'))
                .dust()
                .color(0xab7676)
                .components(Lithium, Aluminium, Silicon * 2, Oxygen * 6)
                .build();

        LithiumSulfate = new Material.Builder(8313, SuSyUtility.susyId('lithium_sulfate'))
                .dust()
                .components(Lithium * 2, Sulfur, Oxygen * 4)
                .colorAverage()
                .build();

        AluminiumPhosphate = new Material.Builder(8314, SuSyUtility.susyId('aluminium_phosphate'))
                .dust()
                .components(Aluminium, Phosphorus, Oxygen * 4)
                .colorAverage()
                .build();

        SiliconTetrafluoride = new Material.Builder(8315, SuSyUtility.susyId('silicon_tetrafluoride'))
                .gas()
                .components(Silicon, Fluorine * 4)
                .colorAverage()
                .build();

        SodiumFluoroberyllate = new Material.Builder(8316, SuSyUtility.susyId('sodium_fluoroberyllate'))
                .dust()
                .components(Sodium * 2, Beryllium, Fluorine * 4)
                .colorAverage()
                .build();

        SodiumFluorosilicate = new Material.Builder(8317, SuSyUtility.susyId('sodium_fluorosilicate'))
                .dust()
                .components(Sodium * 2, Silicon, Fluorine * 6)
                .colorAverage()
                .build();

        BerylliumHydroxide = new Material.Builder(8318, SuSyUtility.susyId('beryllium_hydroxide'))
                .dust()
                .components(Beryllium, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build()
                .setFormula("Be(OH)2", true);

        BerylliumOxide = new Material.Builder(8319, SuSyUtility.susyId('beryllium_oxide'))
                .dust().liquid(new FluidBuilder().temperature(2851))
                .flags(GENERATE_PLATE)
                .components(Beryllium, Oxygen)
                .colorAverage()
                .build();

        BerylliumChloride = new Material.Builder(8320, SuSyUtility.susyId('beryllium_chloride'))
                .dust().liquid(new FluidBuilder().temperature(672))
                .components(Beryllium, Chlorine * 2)
                .colorAverage()
                .build();

        AmmoniumFluoride = new Material.Builder(8321, SuSyUtility.susyId('ammonium_fluoride'))
                .dust()
                .components(Nitrogen, Hydrogen * 4, Fluorine)
                .colorAverage()
                .build();

        AmmoniumBifluoride = new Material.Builder(8322, SuSyUtility.susyId('ammonium_bifluoride'))
                .dust()
                .components(Nitrogen, Hydrogen * 5, Fluorine * 2)
                .colorAverage()
                .build();

        AmmoniumBifluoride.setFormula("[NH4][HF2]", true)

        AmmoniumFluoroberyllate = new Material.Builder(8323, SuSyUtility.susyId('ammonium_fluoroberyllate'))
                .dust()
                .components(Nitrogen * 2, Hydrogen * 8, Beryllium, Fluorine * 4)
                .colorAverage()
                .build();

        AmmoniumFluoroberyllate.setFormula("(NH4)2BeF4", true)

        ChromiumIIIHydroxide = new Material.Builder(8324, SuSyUtility.susyId('chromium_iii_hydroxide'))
                .dust()
                .components(Chrome, Oxygen * 3, Hydrogen * 3)
                .color(0x2e5207)
                .build();

        ChromiumIIIHydroxide.setFormula("Cr(OH)3", true)

        DisassociatedAmmoniumFluoride = new Material.Builder(8325, SuSyUtility.susyId('disassociated_ammonium_fluoride'))
                .gas(new FluidBuilder().temperature(1200))
                
                .components(Ammonia, HydrogenFluoride)
                .colorAverage()
                .build();

        BerylliumFluoride = new Material.Builder(8326, SuSyUtility.susyId('beryllium_fluoride'))
                .dust()
                .components(Beryllium, Fluorine * 2)
                .colorAverage()
                .build();

        MagnesiumFluoride = new Material.Builder(8327, SuSyUtility.susyId('magnesium_fluoride'))
                .dust()
                .components(Magnesium, Fluorine * 2)
                .colorAverage()
                .build();

        DissolvedMagnesiumFluoride = new Material.Builder(8328, SuSyUtility.susyId('dissolved_magnesium_fluoride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Magnesium, Chlorine * 2, HydrofluoricAcid * 2)
                .colorAverage()
                .build();

        DissolvedAlkaliBeryl = new Material.Builder(8329, SuSyUtility.susyId('dissolved_beryl'))
                .liquid()
                .components(Beryllium * 3, Aluminium * 2, Sodium * 2, Sulfur * 7, Oxygen * 28, Water * 7)
                .colorAverage()
                .build();

        DissolvedAlkaliBeryl.setFormula("(BeSO4)3(Al2(SO4)3)(Na2SO4)(H2O)7", true)

        PotassiumAlum = new Material.Builder(8330, SuSyUtility.susyId('potassium_alum'))
                .dust()
                .components(Potassium, Aluminium, Sulfur * 2, Oxygen * 8)
                .colorAverage()
                .build();

        PotassiumAlum.setFormula("KAl(SO4)2", true)

        BerylliumSulfateSolution = new Material.Builder(8331, SuSyUtility.susyId('beryllium_sulfate_solution'))
                .liquid()
                .components(Beryllium * 3, Sodium * 2, Sulfur * 4, Oxygen * 16, Water * 8)
                .colorAverage()
                .build();

        PotassiumManganate = new Material.Builder(8332, SuSyUtility.susyId('potassium_manganate'))
                .dust()
                .components(Potassium * 2, Manganese, Oxygen * 4)
                .color(0x071c06)
                .build();

        RutheniumIVOxide = new Material.Builder(8333, SuSyUtility.susyId('ruthenium_iv_oxide'))
                .dust()
                .components(Ruthenium, Oxygen * 2)
                .colorAverage()
                .build();

        Trichlorosilane = new Material.Builder(8334, SuSyUtility.susyId('trichlorosilane'))
                .liquid()
                .components(Hydrogen, Chlorine * 3, Silicon)
                .color(0x77979e)
                .build();

        PurifiedTrichlorosilane = new Material.Builder(8335, SuSyUtility.susyId('purified_trichlorosilane'))
                .liquid()
                .components(Hydrogen, Chlorine * 3, Silicon)
                .color(0x93b9c2)
                .build();

        HexafluorosilicicAcid = new Material.Builder(8336, SuSyUtility.susyId('hexafluorosilicic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 2, Silicon, Fluorine * 6)
                .colorAverage()
                .build();

        CrudeLead = new Material.Builder(8337, SuSyUtility.susyId('crude_lead'))
                .ingot().liquid(new FluidBuilder().temperature(600))
                .components(Lead)
                .color(0x1f1926)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .build();

        SilverFreeLead = new Material.Builder(8338, SuSyUtility.susyId('silver_free_lead'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Lead)
                .color(0x26202e)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        BismuthDross = new Material.Builder(8339, SuSyUtility.susyId('bismuth_dross'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Calcium, Magnesium * 2, Bismuth * 2)
                .color(0x292b45)
                .build();

        AntimonyDross = new Material.Builder(8340, SuSyUtility.susyId('antimony_dross'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Calcium, Magnesium * 2, Antimony * 2)
                .color(0x3c3a45)
                .build();

        ZincDross = new Material.Builder(8341, SuSyUtility.susyId('zinc_dross'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .components(Zinc * 2, Silver)
                .color(0xb7baa8)
                .build();

        PurifiedTinIIOxide = new Material.Builder(8342, SuSyUtility.susyId('purified_tin_ii_oxide'))
                .dust()
                .iconSet(SHINY)
                .components(Tin, Oxygen)
                .colorAverage()
                .build();

        AluminiumSilicate = new Material.Builder(8343, SuSyUtility.susyId('aluminium_silicate'))
                .dust()
                .components(Aluminium * 2, Silicon, Oxygen * 5)
                .colorAverage()
                .build();

        ChromiumIIIOxide = new Material.Builder(8344, SuSyUtility.susyId('chromium_iii_oxide'))
                .dust()
                .components(Chrome * 2, Oxygen * 3)
                .color(0xb3c99)
                .build();

        SodiumSulfateAcetoneSolution = new Material.Builder(8345, SuSyUtility.susyId('sodium_sulfate_acetone_solution'))
                .liquid()
                .components(Sodium * 12, Sulfur * 6, Oxygen * 24, Acetone, Water * 9)
                .color(0x2c733a)
                .build();

        LeadFreeSolder = new Material.Builder(8346, SuSyUtility.susyId('lead_free_solder'))
                .ingot().liquid(new FluidBuilder().temperature(411))
                .components(Bismuth * 6, Tin * 4)
                .colorAverage()
                .build()

        CopperDross = new Material.Builder(8347, SuSyUtility.susyId('copper_dross'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Copper, Sulfur)
                .color(0x000000)
                .build();

        DecopperedLead = new Material.Builder(8348, SuSyUtility.susyId('decoppered_lead'))
                .liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components(Lead)
                .color(0x886b9c)
                .build();

        DezincedLead = new Material.Builder(8349, SuSyUtility.susyId('dezinced_lead'))
                .liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components(Lead)
                .color(0x825d9c)
                .build();

        BettsCrudeLead = new Material.Builder(8350, SuSyUtility.susyId('betts_crude_lead'))
                .ingot().liquid(new FluidBuilder().temperature(600))
                .components(Bismuth * 3, Lead * 6, Copper)
                .flags(DISABLE_DECOMPOSITION)
                .color(0x393673)
                .build();

        DecopperedBettsLead = new Material.Builder(8351, SuSyUtility.susyId('decoppered_betts_lead'))
                .liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components(Bismuth * 3, Lead * 6)
                .color(0x2f2d63)
                .build();

        SoftenedLead = new Material.Builder(8352, SuSyUtility.susyId('softened_lead'))
                .dust().liquid(new FluidBuilder().temperature(600))
                .flags(DISABLE_DECOMPOSITION)
                .components(Lead)
                .color(0x9874b0)
                .build();

        SodiumAntimonate = new Material.Builder(8353, SuSyUtility.susyId('sodium_antimonate'))
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, Antimony, Oxygen * 3)
                .colorAverage()
                .build();

        SodiumArsenate = new Material.Builder(8354, SuSyUtility.susyId('sodium_arsenate'))
                .dust().liquid(new FluidBuilder().temperature(553))
                .components(Sodium * 3, Arsenic, Oxygen * 4)
                .colorAverage()
                .build();

        SodiumStannate = new Material.Builder(8355, SuSyUtility.susyId('sodium_stannate'))
                .dust()
                .components(Sodium * 2, Tin, Oxygen * 3)
                .colorAverage()
                .build();

        SaltyArsenicAcid = new Material.Builder(8356, SuSyUtility.susyId('salty_arsenic_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Salt * 3, Hydrogen * 3, Arsenic, Oxygen * 4, Water * 3)
                .colorAverage()
                .build();

        SaltyArsenicAcid.setFormula("(H3AsO4)(NaCl)3(H2O)3", true)

        SaltyArsenicPentoxide = new Material.Builder(8357, SuSyUtility.susyId('salty_arsenic_pentoxide'))
                .dust()
                .components(Salt * 6, Arsenic * 2, Oxygen * 5)
                .colorAverage()
                .build();

        TinIVOxide = new Material.Builder(8358, SuSyUtility.susyId('tin_iv_oxide'))
                .dust()
                .components(Tin, Oxygen * 2)
                .colorAverage()
                .build();

        AntimonyVOxide = new Material.Builder(8359, SuSyUtility.susyId('antimony_v_oxide'))
                .dust()
                .components(Antimony * 2, Oxygen * 5)
                .colorAverage()
                .build();

        ImpureCobaltOxide = new Material.Builder(8360, SuSyUtility.susyId('impure_cobalt_oxide'))
                .dust()
                .components(CobaltOxide)
                .color(0xd6e600)
                .build();

        ImpureCobaltOxide.setFormula("(CoO)(?)", true)

        CrudeTin = new Material.Builder(8361, SuSyUtility.susyId('crude_tin'))
                .liquid(new FluidBuilder().temperature(600))
                .components(Tin)
                .color(0xbfbfbf)
                .iconSet(DULL)
                .build();

        LeachedCassiteriteConcentrate = new Material.Builder(8362, SuSyUtility.susyId('leached_cassiterite_concentrate'))
                .dust()
                .components(Cassiterite)
                .colorAverage()
                .iconSet(DULL)
                .build();

        AmmoniumTungstateSolution = new Material.Builder(8363, SuSyUtility.susyId('ammonium_tungstate_solution'))
                .liquid()
                .components(Nitrogen * 2, Hydrogen * 8, Tungsten, Oxygen * 8, Water * 2)
                .colorAverage()
                .build();

        AmmoniumTungstateSolution.setFormula("[(NH4)2WO4](H2O)2", true)

        CopperMonosulfide = new Material.Builder(8364, SuSyUtility.susyId('copper_monosulfide'))
                .dust()
                .components(Copper, Sulfur)
                .color(0x1a1817)
                .build();

        PotassiumSaltMixture = new Material.Builder(8365, SuSyUtility.susyId('potassium_salt_mixture'))
                .liquid()
                .components(Potassium, Salt)
                .colorAverage()
                .build();

        PotassiumSulfide = new Material.Builder(8366, SuSyUtility.susyId('potassium_sulfide'))
                .dust()
                .components(Potassium * 2, Sulfur)
                .color(0xcbcfae)
                .build();

        WashedMagnesiumChlorideAmmoniate = new Material.Builder(8367, SuSyUtility.susyId('washed_magnesium_chloride_ammoniate'))
                .dust()
                .components(MagnesiumChloride, Ammonia * 6)
                .colorAverage()
                .iconSet(SHINY)
                .build();

        SaturatedAmmoniacalMethanol = new Material.Builder(8368, SuSyUtility.susyId('saturated_ammoniacal_methanol'))
                .liquid()
                .components(Methanol * 2, Ammonia)
                .colorAverage()
                .build();

        MagnesiumChlorideAmmoniate = new Material.Builder(8369, SuSyUtility.susyId('magnesium_chloride_ammoniate'))
                .dust()
                .components(MagnesiumChloride, Ammonia * 6)
                .colorAverage()
                .build();

        PurifiedMagnesiumChloride = new Material.Builder(8370, SuSyUtility.susyId('purified_magnesium_chloride'))
                .dust().liquid(new FluidBuilder().temperature(987))
                .components(MagnesiumChloride)
                .color(0xd40d5c)
                .iconSet(SHINY)
                .build();

        DecarburizedAir = new Material.Builder(8371, SuSyUtility.susyId('decarburized_air'))
                .gas()
                .components(Nitrogen * 78, Oxygen * 21, Argon)
                .color(0x90bbe0)
                .build();

        BariumChloride = new Material.Builder(8372, SuSyUtility.susyId('barium_chloride'))
                .dust()
                .components(Barium, Chlorine * 2)
                .colorAverage()
                .build();

        BariumOxide = new Material.Builder(8373, SuSyUtility.susyId('barium_oxide'))
                .dust()
                .components(Barium, Oxygen)
                .colorAverage()
                .build();

        BariumCarbonate = new Material.Builder(8374, SuSyUtility.susyId('barium_carbonate'))
                .dust()
                .components(Barium, Carbon, Oxygen * 3)
                .colorAverage()
                .build();

        IronPentacarbonyl = new Material.Builder(8375, SuSyUtility.susyId('iron_pentacarbonyl'))
                .liquid()
                .components(Iron, Carbon * 5, Oxygen * 5)
                .color(0x8c180d)
                .build();

        IronPentacarbonyl.setFormula("Fe(CO)5", true)

        IronTwoThreeOxide = new Material.Builder(8376, SuSyUtility.susyId('iron_two_three_oxide'))
                .dust()
                .color(0x141313)
                .components(Iron * 3, Oxygen * 4)
                .build()

        PurifiedIronTwoThreeOxide = new Material.Builder(8377, SuSyUtility.susyId('purified_iron_two_three_oxide'))
                .dust()
                .iconSet(SHINY)
                .color(0x141313)
                .components(Iron * 3, Oxygen * 4)
                .build()

        PurifiedIronIIIOxide = new Material.Builder(8378, SuSyUtility.susyId('purified_iron_iii_oxide'))
                .dust()
                .iconSet(SHINY)
                .color(0x8F0C03)
                .components(Iron * 2, Oxygen * 3)
                .build()

        NickelIIOxide = new Material.Builder(8379, SuSyUtility.susyId('nickel_ii_oxide'))
                .dust()
                .color(0x92a371)
                .components(Nickel, Oxygen)
                .build()

        CarbonTetrafluoride = new Material.Builder(8380, SuSyUtility.susyId('carbon_tetrafluoride'))
                .gas().plasma()
                .components(Carbon, Fluorine * 4)
                .colorAverage()
                .build()

        NitrogenTrifluoride = new Material.Builder(8381, SuSyUtility.susyId('nitrogen_trifluoride'))
                .gas().plasma()
                .components(Nitrogen, Fluorine * 3)
                .colorAverage()
                .build()

        CobaltFerrite = new Material.Builder(8382, SuSyUtility.susyId('cobalt_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Cobalt, Iron * 2, Oxygen * 4)
                .colorAverage()
                .build()

        StrontiumFerrite = new Material.Builder(8383, SuSyUtility.susyId('strontium_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Strontium, Iron * 12, Oxygen * 19)
                .colorAverage()
                .build()

        BariumFerrite = new Material.Builder(8384, SuSyUtility.susyId('barium_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Barium, Iron * 12, Oxygen * 19)
                .colorAverage()
                .build()

        ManganeseZincFerrite = new Material.Builder(8385, SuSyUtility.susyId('manganese_zinc_ferrite'))
                .ingot()
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Manganese, Zinc, Iron * 4, Oxygen * 8)
                .colorAverage()
                .build()

        StrontiumCarbonate = new Material.Builder(8386, SuSyUtility.susyId('strontium_carbonate'))
                .dust()
                .components(Strontium, Carbon, Oxygen * 3)
                .colorAverage()
                .build()

        LithiumOxide = new Material.Builder(8387, SuSyUtility.susyId('lithium_oxide'))
                .dust().liquid(new FluidBuilder().temperature(1711))
                .components(Lithium * 2, Oxygen)
                .colorAverage()
                .build();

        LeadOxide = new Material.Builder(8388, SuSyUtility.susyId('lead_oxide'))
                .dust().gas(new FluidBuilder().temperature(1750))
                .flags(NO_UNIFICATION)
                .components(Lead, Oxygen)
                .colorAverage()
                .build()

        TantalumNitride = new Material.Builder(8389, SuSyUtility.susyId('tantalum_nitride'))
                .dust()
                .components(Tantalum, Nitrogen)
                .colorAverage()
                .build()

        RutheniumIVOxide = new Material.Builder(8390, SuSyUtility.susyId('ruthenium_iv_oxide'))
                .dust()
                .components(Ruthenium, Oxygen * 2)
                .colorAverage()
                .build()

        BismuthIridate = new Material.Builder(8391, SuSyUtility.susyId('bismuth_iridate'))
                .dust()
                .components(Bismuth * 2, Iridium * 2, Oxygen * 7)
                .colorAverage()
                .build()

        SodiumBismuthate = new Material.Builder(8392, SuSyUtility.susyId('sodium_bismuthate'))
                .dust()
                .components(Sodium, Bismuth, Oxygen * 3)
                .colorAverage()
                .build()

        BismuthIIIOxide = new Material.Builder(8393, SuSyUtility.susyId('bismuth_iii_oxide'))
                .dust()
                .components(Bismuth * 2, Oxygen * 3)
                .colorAverage()
                .build()

        ManganeseIINitrate = new Material.Builder(8394, SuSyUtility.susyId('manganese_ii_nitrate'))
                .dust()
                .components(Manganese, Nitrogen * 2, Oxygen * 6)
                .colorAverage()
                .build()
                .setFormula("Mn(NO3)2", true)

        ManganeseDioxide = new Material.Builder(8395, SuSyUtility.susyId('manganese_dioxide'))
                .dust()
                .iconSet('SHINY')
                .components(Manganese, Oxygen * 2)
                .color(0x38251e)
                .build()

        BariumTitanate = new Material.Builder(8396, SuSyUtility.susyId('barium_titanate'))
                .gem().iconSet(RUBY)
                .components(Barium, Titanium, Oxygen * 3)
                .colorAverage()
                .build()

        HafniumTetrachloride = new Material.Builder(8397, SuSyUtility.susyId('hafnium_tetrachloride'))
                .dust().liquid(new FluidBuilder().temperature(705))
                .components(Hafnium, Chlorine * 4)
                .color(0xcae3cc)
                .build();

        AmmoniumThiocyanate = new Material.Builder(8398, SuSyUtility.susyId('ammonium_thiocyanate'))
                .dust()
                .components(Nitrogen * 2, Hydrogen * 4, Sulfur, Carbon)
                .colorAverage()
                .build();

        AmmoniumThiocyanate.setFormula("NH4SCN", true)

        RawElectrum = new Material.Builder(8399, SuSyUtility.susyId('raw_electrum'))
                .ore().liquid(new FluidBuilder().temperature(1300))
                .color(0xfcf403)
                .components(Silver, Gold)
                .build();

        NeodymiumAlloy = new Material.Builder(8400, SuSyUtility.susyId('neodymium_alloy'))
                .ingot()
                .color(0x2b2a2a).iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE)
                .components(Neodymium * 2, Iron * 14, Boron)
                .blastTemp(1297, GasTier.MID)
                .build();

        TreatedNeodymiumAlloy = new Material.Builder(8401, SuSyUtility.susyId('treated_neodymium_alloy'))
                .ingot()
                .color(0x2b2a2a).iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION)
                .components(NeodymiumAlloy)
                .ingotSmeltInto(NeodymiumAlloy)
                .arcSmeltInto(NeodymiumAlloy)
                .macerateInto(NeodymiumAlloy)
                .build();

        NeodymiumAlloyMagnetic = new Material.Builder(8402, SuSyUtility.susyId('neodymium_alloy_magnetic'))
                .ingot()
                .color(0x2b2a2a).iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION, IS_MAGNETIC)
                .components(NeodymiumAlloy)
                .ingotSmeltInto(NeodymiumAlloy)
                .arcSmeltInto(NeodymiumAlloy)
                .macerateInto(NeodymiumAlloy)
                .build();

        TreatedNeodymiumAlloy.getProperty(PropertyKey.INGOT).setMagneticMaterial(NeodymiumAlloyMagnetic);

        SamariumAlloy = new Material.Builder(8403, SuSyUtility.susyId('samarium_alloy'))
                .dust().ingot().liquid(new FluidBuilder().temperature(800))
                .color(0xb3d683).iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION)
                .components(Samarium, Cobalt * 5)
                .build();

        TreatedSamariumAlloy = new Material.Builder(8404, SuSyUtility.susyId('treated_samarium_alloy'))
                .ingot()
                .color(0xb3d683).iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION)
                .components(SamariumAlloy)
                .ingotSmeltInto(SamariumAlloy)
                .arcSmeltInto(SamariumAlloy)
                .macerateInto(SamariumAlloy)
                .build();

        SamariumAlloyMagnetic = new Material.Builder(8405, SuSyUtility.susyId('samarium_alloy_magnetic'))
                .ingot()
                .color(0xb3d683).iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, NO_UNIFICATION, IS_MAGNETIC)
                .components(SamariumAlloy)
                .ingotSmeltInto(SamariumAlloy)
                .arcSmeltInto(SamariumAlloy)
                .macerateInto(SamariumAlloy)
                .build();

        TreatedSamariumAlloy.getProperty(PropertyKey.INGOT).setMagneticMaterial(SamariumAlloyMagnetic);

        CobaltNitrateSolution = new Material.Builder(8406, SuSyUtility.susyId('cobalt_nitrate_solution'))
                .liquid()
                .components(Cobalt, Nitrogen * 2, Oxygen * 6, Water)
                .colorAverage()
                .build()
                .setFormula("(Co(NO3)2)(H2O)", true)

        Dichlorosilane = new Material.Builder(8407, SuSyUtility.susyId('dichlorosilane'))
                .gas()
                .components(Silicon, Hydrogen * 2, Chlorine * 2)
                .color(0x90ab84)
                .build()

        Chlorosilane = new Material.Builder(8408, SuSyUtility.susyId('chlorosilane'))
                .liquid()
                .components(Silicon, Hydrogen * 3, Chlorine)
                .color(0xa0ba95)
                .build()

        Silane = new Material.Builder(8409, SuSyUtility.susyId('silane'))
                .gas()
                .components(Silicon, Hydrogen * 4)
                .color(0xbbd1b2)
                .build()

        NickelCarbonyl = new Material.Builder(8410, SuSyUtility.susyId('nickel_carbonyl'))
                .gas(new FluidBuilder().temperature(400))
                .components(Nickel, Carbon * 4, Oxygen * 4)
                .colorAverage()
                .build()

        NickelCarbonyl.setFormula("Ni(CO)4", true)

        ChloroaceticAnhydride = new Material.Builder(8411, SuSyUtility.susyId('chloroacetic_anhydride'))
                .dust()
                .components(Carbon * 4, Hydrogen * 4, Oxygen * 3, Chlorine * 2)
                .colorAverage()
                .build()

        ZirconiumDioxide = new Material.Builder(8412, SuSyUtility.susyId('zirconium_dioxide'))
                .dust()
                .components(Zirconium, Oxygen * 2)
                .colorAverage()
                .build()

        CopperIINitrate = new Material.Builder(8413, SuSyUtility.susyId('copper_ii_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Copper, Nitrogen * 2, Oxygen * 6)
                .color(0x292fe3)
                .build()

        CopperIINitrate.setFormula("Cu(NO3)2", true)

        NickelIINitrate = new Material.Builder(8414, SuSyUtility.susyId('nickel_ii_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Nickel, Nitrogen * 2, Oxygen * 6)
                .color(0x236359)
                .build()

        NickelIINitrate.setFormula("Ni(NO3)2", true)

        ZincNitrate = new Material.Builder(8415, SuSyUtility.susyId('zinc_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Zinc, Nitrogen * 2, Oxygen * 6)
                .color(0xdfe6cf)
                .build()

        ZincNitrate.setFormula("Zn(NO3)2", true)

        MagnesiumNitrate = new Material.Builder(8416, SuSyUtility.susyId('magnesium_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Magnesium, Nitrogen * 2, Oxygen * 6)
                .color(0xe8d8e3)
                .build()

        MagnesiumNitrate.setFormula("Mg(NO3)2", true)

        YttriumOxide = new Material.Builder(8417, SuSyUtility.susyId('yttrium_oxide'))
                .dust()
                .components(Yttrium * 2, Oxygen * 3)
                .colorAverage()
                .build()

        NeodymiumOxide = new Material.Builder(8418, SuSyUtility.susyId('neodymium_oxide'))
                .dust()
                .components(Neodymium * 2, Oxygen * 3)
                .colorAverage()
                .build()

        Bromooctane = new Material.Builder(8419, SuSyUtility.susyId('bromooctane'))
                .liquid()
                .components(Carbon * 8, Hydrogen * 17, Bromine)
                .colorAverage()
                .build()

        LithiumDioctylcopper = new Material.Builder(8420, SuSyUtility.susyId('lithium_dioctylcopper'))
                .liquid()
                .components(Carbon * 16, Hydrogen * 34, Copper, Lithium)
                .colorAverage()
                .build()

        DecanoylChloride = new Material.Builder(8421, SuSyUtility.susyId('decanoyl_chloride'))
                .liquid()
                .components(Carbon * 10, Hydrogen * 19, Chlorine, Oxygen)
                .colorAverage()
                .build()

        SodiumCyanoborohydride = new Material.Builder(8422, SuSyUtility.susyId('sodium_cyanoborohydride'))
                .dust()
                .components(Sodium, Boron, Hydrogen * 3, Carbon, Nitrogen)
                .colorAverage()
                .build()

        SodiumCyanoborohydride.setFormula("Na[BH3(CN)]", true)

        DilutedSodiumHydroxideSolution = new Material.Builder(8423, SuSyUtility.susyId('diluted_sodium_hydroxide_solution'))
                .liquid()
                .components(SodiumHydroxide, Water * 2)
                .colorAverage()
                .build();

        Oleum = new Material.Builder(8425, SuSyUtility.susyId('oleum'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(SulfuricAcid * 10, SulfurTrioxide)
                .color(0xe8c3a5)
                .build();

        ChromiumSulfateSolution = new Material.Builder(8426, SuSyUtility.susyId('chromium_sulfate_solution'))
                .liquid()
                .components(Chrome * 4, Sulfur * 6, Oxygen * 24, Acetone, Water * 9)
                .color(0x2c733a)
                .build();

        MustardGas = new Material.Builder(8427, SuSyUtility.susyId('mustard_gas'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 8, Chlorine * 2, Sulfur)
                .color(0xcf7f3e)
                .build();

        Methyldichlorophosphine = new Material.Builder(8428, SuSyUtility.susyId('methyldichlorophosphine'))
                .liquid()
                .components(Carbon, Hydrogen * 3, Chlorine * 2, Phosphorus)
                .colorAverage()
                .build();

        SulfurylChloride = new Material.Builder(8429, SuSyUtility.susyId('sulfuryl_chloride'))
                .liquid()
                .components(Sulfur, Oxygen * 2, Chlorine * 2)
                .colorAverage()
                .build();

        MethylphosphonylDichloride = new Material.Builder(8430, SuSyUtility.susyId('methylphosphonyl_dichloride'))
                .liquid()
                .components(Carbon, Hydrogen * 3, Chlorine * 2, Oxygen, Phosphorus)
                .colorAverage()
                .build();

        MethylphosphonylDifluoride = new Material.Builder(8431, SuSyUtility.susyId('methylphosphonyl_difluoride'))
                .liquid()
                .components(Carbon, Hydrogen * 3, Phosphorus, Oxygen, Fluorine * 2)
                .colorAverage()
                .build();

        Sarin = new Material.Builder(8432, SuSyUtility.susyId('sarin'))
                .liquid()
                .components(Carbon * 4, Hydrogen * 10, Fluorine, Oxygen * 2, Phosphorus)
                .colorAverage()
                .build();

        MethylDiethylphosphinate = new Material.Builder(8433, SuSyUtility.susyId('methyl_diethylphosphinate'))
                .liquid()
                .components(Carbon * 5, Hydrogen * 13, Oxygen * 2, Phosphorus)
                .colorAverage()
                .build();

        DiisopropylaminoEthylEthylMethylphosphonite = new Material.Builder(8434, SuSyUtility.susyId('diisopropylamino_ethyl_ethyl_methylphosphonite'))
                .liquid()
                .components(Carbon * 11, Hydrogen * 26, Nitrogen, Oxygen * 2, Phosphorus)
                .colorAverage()
                .build();

        VX = new Material.Builder(8435, SuSyUtility.susyId('vx'))
                .liquid()
                .components(Carbon * 11, Hydrogen * 26, Nitrogen, Oxygen * 2, Phosphorus, Sulfur)
                .colorAverage()
                .build();

        TitaniumEthoxide = new Material.Builder(8436, SuSyUtility.susyId('titanium_ethoxide'))
                .liquid()
                .components(Titanium * 4, Carbon * 32, Hydrogen * 80, Oxygen * 16)
                .colorAverage()
                .build();

        DilutedPhosphoricAcid = new Material.Builder(8437, SuSyUtility.susyId('diluted_phosphoric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(PhosphoricAcid * 3, Water)
                .colorAverage()
                .build()

        MonocalciumPhosphate = new Material.Builder(8438, SuSyUtility.susyId('monocalcium_phosphate'))
                .dust()
                .components(Calcium, Hydrogen * 4, Phosphorus * 2, Oxygen * 8)
                .color(0xc2bc13)
                .iconSet(SAND)
                .build()

        MonocalciumPhosphate.setFormula("Ca(H2PO4)2", true)

        CalciumMetaphosphate = new Material.Builder(8439, SuSyUtility.susyId('calcium_metaphosphate'))
                .dust()
                .components(Calcium * 1, Phosphorus * 2, Oxygen * 6)
                .color(0xa2a832)
                .iconSet(CERTUS)
                .build()

        CalciumMetaphosphate.setFormula("Ca(PO3)2", true)

        SulfurTrioxideReactionMixture = new Material.Builder(8440, SuSyUtility.susyId('sulfur_trioxide_reaction_mixture'))
                .gas()
                .components(SulfurDioxide, Oxygen)
                .colorAverage()
                .build()

        CalciumMetasilicate = new Material.Builder(8441, SuSyUtility.susyId('calcium_metasilicate'))
                .dust()
                .components(Calcium, Silicon, Oxygen * 3)
                .colorAverage()
                .build()

        HighPurityPhosphorusVaporMixture = new Material.Builder(8442, SuSyUtility.susyId('high_purity_phosphorus_vapor_mixture'))
                .gas(new FluidBuilder().temperature(554))
                .components(Phosphorus * 4, Water)
                .colorAverage()
                .build()
                .setFormula("(P)(H2O)", true);

        PotassiumAmylXanthate = new Material.Builder(8443, SuSyUtility.susyId('potassium_amyl_xanthate'))
                .dust()
                .components(Carbon * 6, Hydrogen * 11, Potassium, Oxygen, Sulfur * 2)
                .colorAverage()
                .build()

        GoldAmalgam = new Material.Builder(8444, SuSyUtility.susyId('gold_amalgam'))
                .liquid()
                .components(Gold, Mercury)
                .colorAverage()
                .build();

        HotSulfuricAcid = new Material.Builder(8445, SuSyUtility.susyId('hot_sulfuric_acid'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(353))
                .components(Hydrogen * 2, Sulfur, Oxygen * 4)
                .color(0xff570f)
                .build()

        CadmiumSulfateSolution = new Material.Builder(8446, SuSyUtility.susyId('cadmium_sulfate_solution'))
                .liquid()
                .components(Cadmium, Sulfur, Oxygen * 4, Water)
                .colorAverage()
                .build()
        CadmiumSulfateSolution.setFormula("(CdSO4)(H2O)", true)

        MercuryOxide = new Material.Builder(8447, SuSyUtility.susyId('mercury_oxide'))
                .dust()
                .components(Mercury, Oxygen)
                .colorAverage()
                .build()

        IndiumChloride = new Material.Builder(8448, SuSyUtility.susyId('indium_chloride'))
                .dust()
                .components(Indium, Chlorine * 3)
                .colorAverage()
                .build()

        IndiumHydroxide = new Material.Builder(8449, SuSyUtility.susyId('indium_hydroxide'))
                .dust()
                .components(Indium, Oxygen * 3, Hydrogen * 3)
                .colorAverage()
                .build()

        IndiumHydroxide.setFormula("In(OH)3", true)

        TitaniumDioxide = new Material.Builder(8450, SuSyUtility.susyId('titanium_dioxide'))
                .dust()
                .components(Titanium, Oxygen * 2)
                .color(0xffffff)
                .iconSet(SHINY)
                .build()

        IndiumOxide = new Material.Builder(8451, SuSyUtility.susyId('indium_oxide'))
                .dust()
                .components(Indium * 2, Oxygen * 3)
                .colorAverage()
                .build()

        EthanolWaterAzeotrope = new Material.Builder(8452, SuSyUtility.susyId('ethanol_water_azeotrope'))
                .liquid()
                .components(Ethanol * 91, Water * 9)
                .color(0xad552f)
                .build();

        EntrainedEthanolWaterAzeotrope = new Material.Builder(8453, SuSyUtility.susyId('entrained_ethanol_water_azeotrope'))
                .liquid()
                .components(Ethanol * 91, Water * 9, Toluene * 10)
                .colorAverage()
                .build();

        CalciumSulfite = new Material.Builder(8454, SuSyUtility.susyId('calcium_sulfite'))
                .dust()
                .components(Calcium, Sulfur, Oxygen * 3)
                .colorAverage()
                .build();

        SilicaGel = new Material.Builder(8455, SuSyUtility.susyId('silica_gel'))
                .dust()
                .iconSet(SHINY)
                .components(Silicon, Oxygen * 2)
                .color(0x6d6e63)
                .build();

        WetSilicaGel = new Material.Builder(8456, SuSyUtility.susyId('wet_silica_gel'))
                .dust()
                .components(Silicon, Oxygen * 2)
                .color(0x585950)
                .build();

        PhosphoricAcidSilicaGel = new Material.Builder(8457, SuSyUtility.susyId('phosphoric_acid_silica_gel'))
                .dust()
                .iconSet(SHINY)
                .components(SilicaGel, PhosphoricAcid)
                .colorAverage()
                .build();

        SodiumChromateMixture = new Material.Builder(8458, SuSyUtility.susyId('sodium_chromate_mixture'))
                .dust()
                .components(Sodium, Chrome, Oxygen * 4, SodaAsh)
                .color(0xfaff7d)
                .build();

        SodiumChromateSolution = new Material.Builder(8459, SuSyUtility.susyId('sodium_chromate_solution'))
                .liquid()
                .components(Sodium, Chrome, Oxygen * 4, Water)
                .color(0xa4a839)
                .build();

        LeadChloride = new Material.Builder(8460, SuSyUtility.susyId('lead_chloride'))
                .dust().liquid(new FluidBuilder().temperature(774))
                .components(Lead, Chlorine * 2)
                .colorAverage()
                .build();

        SodiumVanadateSolution = new Material.Builder(8461, SuSyUtility.susyId('sodium_vanadate_solution'))
                .liquid()
                .components(Sodium, Vanadium, Oxygen * 3, Water)
                .colorAverage()
                .build();

        SodiumVanadateSolution.setFormula("(NaVO3)(H2O)", true)

        AmmoniumMetavanadate = new Material.Builder(8462, SuSyUtility.susyId('ammonium_metavanadate'))
                .dust()
                .components(Nitrogen, Hydrogen * 4, Vanadium, Oxygen * 3)
                .colorAverage()
                .build();

        CobaltAluminate = new Material.Builder(8463, SuSyUtility.susyId('cobalt_aluminate'))
                .dust()
                .iconSet(SHINY)
                .components(Cobalt, Aluminium * 2, Oxygen * 4)
                .color(0x1605ff)
                .build();

        LeadNitrate = new Material.Builder(8464, SuSyUtility.susyId('lead_nitrate'))
                .dust()
                .iconSet(SHINY)
                .components(Lead, Nitrogen * 2, Oxygen * 6)
                .color(0xffffff)
                .build();

        LeadNitrate.setFormula("Pb(NO3)2", true)

        AmmoniumChromeAlum = new Material.Builder(8465, SuSyUtility.susyId('ammonium_chrome_alum'))
                .dust()
                .components(Nitrogen, Hydrogen * 4, Chrome, Sulfur * 2, Oxygen * 8)
                .color(0x4e1554)
                .iconSet(SHINY)
                .build();

        AmmoniumChromeAlum.setFormula("NH4Cr(SO4)2", true)

        AmmoniumIronIISulfate = new Material.Builder(8466, SuSyUtility.susyId('ammonium_iron_ii_sulfate'))
                .dust()
                .components(Iron, Nitrogen * 2, Hydrogen * 8, Sulfur * 2, Oxygen * 8)
                .color(0x70cc6e)
                .iconSet(SHINY)
                .build();

        AmmoniumIronIISulfate.setFormula("Fe(NH4)2(SO4)2", true)

        ElectrolyticChromium = new Material.Builder(8467, SuSyUtility.susyId('electrolytic_chromium'))
                .dust().liquid(new FluidBuilder().temperature(2180))
                .components(Chrome)
                .colorAverage()
                .iconSet(SAND)
                .build();

        IronIIHydroxide = new Material.Builder(8468, SuSyUtility.susyId('iron_ii_hydroxide'))
                .dust()
                .components(Iron, Oxygen * 2, Hydrogen * 2)
                .color(0x072406)
                .build();

        IronIIHydroxide.setFormula("Fe(OH)2", true)

        SodiumAmide = new Material.Builder(8469, SuSyUtility.susyId('sodium_amide'))
                .dust()
                .components(Sodium, Nitrogen, Hydrogen * 2)
                .colorAverage()
                .build();

        LeadChromate = new Material.Builder(8470, SuSyUtility.susyId('lead_chromate'))
                .dust()
                .iconSet(SHINY)
                .components(Lead, Chrome, Oxygen * 4)
                .color(0xfffb00)
                .build();

        IronIIOxide = new Material.Builder(8471, SuSyUtility.susyId('iron_ii_oxide'))
                .dust()
                .components(Iron, Oxygen)
                .color(0x1c1c1c)
                .build();

        GalliumTrioxide = new Material.Builder(8472, SuSyUtility.susyId('gallium_trioxide'))
                .dust()
                .components(Gallium * 2, Oxygen * 3)
                .colorAverage()
                .build();

        AmmoniumDihydrogenPhosphate = new Material.Builder(8473, SuSyUtility.susyId('ammonium_dihydrogen_phosphate'))
                .dust()
                .components(Hydrogen * 6, Nitrogen, Oxygen * 4, Phosphorus)
                .colorAverage()
                .build();

        AmmoniumDihydrogenPhosphate.setFormula("NH4H2PO4", true)

        CrudeManganeseIIOxide = new Material.Builder(8474, SuSyUtility.susyId('crude_manganese_ii_oxide'))
                .dust()
                .components(Manganese, Oxygen)
                .color(0x472400)
                .iconSet(SAND)
                .build()
                .setFormula("(?)(MnO)", true)

        IronCarbonate = new Material.Builder(8475, SuSyUtility.susyId('iron_carbonate'))
                .dust()
                .components(Iron, Carbon, Oxygen * 3)
                .colorAverage()
                .build();

        AmmoniumDiuranate = new Material.Builder(8477, SuSyUtility.susyId('ammonium_diuranate'))
                .dust()
                .iconSet(SHINY)
                .components(Nitrogen * 2, Hydrogen * 8, Uranium238, Oxygen * 7)
                .color(0xe6be22)
                .build();

        AmmoniumDiuranate.setFormula("(NH4)2U2O7", true)

        MagnesiumCarbonate = new Material.Builder(8478, SuSyUtility.susyId('magnesium_carbonate'))
                .dust()
                .components(Magnesium, Carbon, Oxygen * 3)
                .colorAverage()
                .build();

        SodiumLeadAlloy = new Material.Builder(8479, SuSyUtility.susyId('sodium_lead_alloy'))
                .ingot()
                .components(Sodium, Lead)
                .colorAverage()
                .build();

        DenseSteam = new Material.Builder(8480, SuSyUtility.susyId('dense_steam'))
                .gas(new FluidBuilder().temperature(373))
                .components(Water)
                .color(0xcaddfa)
                .build();

        HeatedGreenCoke = new Material.Builder(8481, SuSyUtility.susyId('heated_green_coke'))
                .gem(1, 2000)
                .color(0x7b8752).iconSet(LIGNITE)
                .components(Carbon)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        ManganeseIINitrateSolution = new Material.Builder(8482, SuSyUtility.susyId('manganese_ii_nitrate_solution'))
                .liquid()
                .components(Manganese, Nitrogen * 2, Oxygen * 6, Water)
                .colorAverage()
                .build()
                .setFormula("(Mn(NO3)2)(H2O)", true)

        CrudeManganeseIINitrateSolution = new Material.Builder(8483, SuSyUtility.susyId('crude_manganese_ii_nitrate_solution'))
                .liquid()
                .components(Manganese, Nitrogen * 2, Oxygen * 6, Water)
                .colorAverage()
                .build()
                .setFormula("(?)(Mn(NO3)2)(H2O)", true)

        //FREE IDs: 8484-8485

        UltramaficTailingSlurry = new Material.Builder(8486, SuSyUtility.susyId('ultramafic_tailing_slurry'))
                .liquid()
                .components(UltramaficTailings, Water)
                .color(0x878170)
                .build();

        RutileSlurry = new Material.Builder(8487, SuSyUtility.susyId('rutile_slurry'))
                .liquid()
                .components(Rutile, Water)
                .color(0xe8e6e2)
                .build();

        RutileSlurry.setFormula("(H2O)(TiO2)(?)", true);

        ImpureTitaniumTetrachloride = new Material.Builder(8488, SuSyUtility.susyId('impure_titanium_tetrachloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TitaniumTetrachloride)
                .color(0x54474a)
                .build();

        ImpureTitaniumTetrachloride.setFormula("(TiCl4)(?)", true);

        DistilledTitaniumTetrachloride = new Material.Builder(8489, SuSyUtility.susyId('distilled_titanium_tetrachloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TitaniumTetrachloride)
                .color(0x8c6c73)
                .build();

        DistilledTitaniumTetrachloride.setFormula("(TiCl4)(?)", true);

        VanadiumFreeTitaniumTetrachloride = new Material.Builder(8490, SuSyUtility.susyId('vanadium_free_titanium_tetrachloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(TitaniumTetrachloride)
                .color(0xa16270)
                .build();

        VanadiumFreeTitaniumTetrachloride.setFormula("(TiCl4)(?)", true);

        VanadiumOxydichloride = new Material.Builder(8491, SuSyUtility.susyId('vanadium_oxydichloride'))
                .dust()
                .components(Vanadium, Oxygen, Chlorine * 2)
                .color(0x1c1294)
                .build();

        VanadiumOxytrichloride = new Material.Builder(8492, SuSyUtility.susyId('vanadium_oxytrichloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Vanadium, Oxygen, Chlorine * 3)
                .color(0xbda51b)
                .build();

        GaseousIronIIIChloride = new Material.Builder(8493, SuSyUtility.susyId('gaseous_iron_iii_chloride'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(590))
                .components(Iron3Chloride)
                .color(0xba8f49)
                .build();

        GaseousTitaniumTetrachloride = new Material.Builder(8494, SuSyUtility.susyId('gaseous_titanium_tetrachloride'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(1180))
                .components(TitaniumTetrachloride)
                .color(0x8f4064)
                .build();

        TinTetrachloride = new Material.Builder(8495, SuSyUtility.susyId('tin_tetrachloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Tin, Chlorine * 4)
                .color(0x887866)
                .build();

        //FREE IDs: 8496-8497

        NickelSulfate = new Material.Builder(8498, SuSyUtility.susyId('nickel_sulfate'))
                .dust()
                .components(Nickel * 1, Sulfur * 1, Oxygen * 4)
                .color(0xcad3a7)
                .build()

        SodiumNitrite = new Material.Builder(8499, SuSyUtility.susyId('sodium_nitrite'))
                .dust().liquid(new FluidBuilder().temperature(544))
                .components(Sodium, Nitrogen, Oxygen * 2)
                .color(0xe7e899)
                .build();

        SodiumOxide = new Material.Builder(8500, SuSyUtility.susyId('sodium_oxide'))
                .dust()
                .components(Sodium * 2, Oxygen)
                .colorAverage()
                .build();

        AlluvialPGMSolution = new Material.Builder(8501, SuSyUtility.susyId('alluvial_pgm_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Iron, Hydrogen * 6, Platinum * 3, Chlorine * 20, Water * 10)
                .color(0xe06624)
                .build();

        AlluvialPGMSolution.setFormula("(H2PtCl6)2(H2PdCl4)(FeCl2)(H2O)10", true)

        CementedAlluvialPGMSolution = new Material.Builder(8502, SuSyUtility.susyId('cemented_alluvial_pgm_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Zinc, Hydrogen * 6, Platinum * 3, Chlorine * 20, Water * 8)
                .color(0xb87627)
                .build();

        CementedAlluvialPGMSolution.setFormula("(H2PtCl6)2(H2PdCl4)(ZnCl2)(H2O)10", true)
        
        AmmoniumHexachloroplatinate = new Material.Builder(8503, SuSyUtility.susyId('ammonium_hexachloroplatinate'))
                .dust()
                .components(Nitrogen * 2, Hydrogen * 8, Platinum, Chlorine * 6)
                .color(0xe6c532)
                .build();

        AmmoniumHexachloroplatinate.setFormula("(NH4)2PtCl6", true)

        DilutedCopperSulfateSolution = new Material.Builder(8504, SuSyUtility.susyId('diluted_copper_sulfate_solution'))
                .liquid()
                .components(CopperSulfate * 2, Water * 3)
                .colorAverage()
                .build();

        NickelSulfateSolution = new Material.Builder(8505, SuSyUtility.susyId('nickel_sulfate_solution'))
                .liquid()
                .components(NickelSulfate, Water)
                .color(0x38add1)
                .build();

        DisulfurDichloride = new Material.Builder(8506, SuSyUtility.susyId('disulfur_dichloride'))
                .liquid()
                .components(Sulfur * 2, Chlorine * 2)
                .color(0xccc31d)
                .build();

        AcidWashedSiliconDioxide = new Material.Builder(8507, SuSyUtility.susyId('acid_washed_silicon_dioxide'))
                .dust()
                .components(SiliconDioxide)
                .color(0xc8c8c8)
                .iconSet(SHINY)
                .build();

        AluminiumNitride = new Material.Builder(8508, SuSyUtility.susyId('aluminium_nitride'))
                .dust()
                .components(Aluminium, Nitrogen)
                .colorAverage()
                .build();

        AluminiumOxynitride = new Material.Builder(8509, SuSyUtility.susyId('aluminium_oxynitride'))
                .dust()
                .flags(GENERATE_PLATE)
                .components(Aluminium * 23, Oxygen * 27, Nitrogen * 5)
                .color(0xc7dfed)
                .iconSet(GLASS)
                .build();

        HydrogenIodide = new Material.Builder(8510, SuSyUtility.susyId('hydrogen_iodide'))
                .gas(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Iodine)
                .colorAverage()
                .build();

        AntimonyTrichloride = new Material.Builder(8511, SuSyUtility.susyId('antimony_trichloride'))
                .dust().liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(347))
                .components(Antimony, Chlorine * 3)
                .colorAverage()
                .build();

        AntimonyPentachloride = new Material.Builder(8512, SuSyUtility.susyId('antimony_pentachloride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Antimony, Chlorine * 5)
                .colorAverage()
                .build();

        //FREE IDs: 8513-8516

        MolybdenumTrisulfide = new Material.Builder(8517, SuSyUtility.susyId('molybdenum_trisulfide'))
                .dust()
                .components(Molybdenum, Sulfur * 3)
                .colorAverage()
                .build();

        AmmoniumIsopolytungstateSolution = new Material.Builder(8518, SuSyUtility.susyId('ammonium_isopolytungstate_solution'))
                .liquid()
                .components(Nitrogen * 5, Hydrogen * 21, Tungsten * 6, Oxygen * 21, Water * 5)
                .colorAverage()
                .build();

        AmmoniumIsopolytungstateSolution.setFormula("[(NH4)5(HW6O21)](H2O)5", true)

        AmmoniumParatungstate = new Material.Builder(8519, SuSyUtility.susyId('ammonium_paratungstate'))
                .dust()
                .components(Nitrogen * 10, Hydrogen * 42, Tungsten * 12, Oxygen * 42, Water * 4)
                .colorAverage()
                .build();

        AmmoniumParatungstate.setFormula("(NH4)10(H2W12O42) * 4H2O", true)

        ManganeseIIHydroxide = new Material.Builder(8520, SuSyUtility.susyId('manganese_ii_hydroxide'))
                .dust()
                .components(Manganese, Oxygen * 2, Hydrogen * 2)
                .color(0xe4cfb1)
                .build();

        ManganeseIIHydroxide.setFormula("Mn(OH)2", true)

        SodiumTungstateSolution = new Material.Builder(8521, SuSyUtility.susyId('sodium_tungstate_solution'))
                .liquid()
                .components(Sodium * 2, Tungsten, Oxygen * 4, Water)
                .colorAverage()
                .build();

        SodiumTungstateSolution.setFormula("(?)(Na2WO4)(H2O)", true)

        ImpureMolybdenumTrioxide = new Material.Builder(8522, SuSyUtility.susyId('impure_molybdenum_trioxide'))
                .dust()
                .components(Molybdenum, Oxygen * 3)
                .color(0x154f25)
                .build();

        ImpureMolybdenumTrioxide.setFormula("(?)(MoO3)", true)

        AmmoniumDimolybdate = new Material.Builder(8523, SuSyUtility.susyId('ammonium_dimolybdate'))
                .dust()
                .components(Nitrogen * 2, Hydrogen * 8, Molybdenum * 2, Oxygen * 7)
                .colorAverage()
                .build();

        AmmoniumDimolybdate.setFormula("(NH4)2Mo2O7", true)

        PurifiedMolybdenumTrioxide = new Material.Builder(8524, SuSyUtility.susyId('purified_molybdenum_trioxide'))
                .dust()
                .components(Molybdenum, Oxygen * 3)
                .color(0x0f5c23)
                .iconSet(SHINY)
                .build();

        MolybdenumTrioxide = new Material.Builder(8525, SuSyUtility.susyId('molybdenum_trioxide'))
                .dust()
                .components(Molybdenum, Oxygen * 3)
                .color(0x0f5c23)
                .build();

        AmmoniumMolybdateSolution = new Material.Builder(8526, SuSyUtility.susyId('ammonium_molybdate_solution'))
                .liquid()
                .components(Nitrogen * 2, Hydrogen * 8, Molybdenum, Oxygen * 4, Water)
                .colorAverage()
                .build();

        AmmoniumMolybdateSolution.setFormula("[(NH4)2MoO4](H2O)", true)

        PhosphorusPentasulfide = new Material.Builder(8527, SuSyUtility.susyId('phosphorus_pentasulfide'))
                .dust()
                .components(Phosphorus * 2, Sulfur * 5)
                .colorAverage()
                .build();

        SodiumDithiophosphateSolution = new Material.Builder(8528, SuSyUtility.susyId('sodium_dithiophosphate_solution'))
                .liquid()
                .components(Sodium * 3, Phosphorus, Oxygen * 2, Sulfur * 2, Water * 2)
                .color(0xa69737)
                .build();

        SodiumDithiophosphateSolution.setFormula("(Na3PO2S2)(H2O)2", true)

        AlkaliFusedWulfenite = new Material.Builder(8529, SuSyUtility.susyId('alkali_fused_wulfenite'))
                .dust()
                .components(Lead, Molybdenum, Sodium * 2, Hydrogen * 2, Oxygen * 6)
                .color(0xff805e)
                .build();

        AlkaliFusedWulfenite.setFormula("[Pb(OH)2](Na2MoO4)", true)

        LeadIIHydroxide = new Material.Builder(8530, SuSyUtility.susyId('lead_ii_hydroxide'))
                .dust()
                .components(Lead, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build();

        LeadIIHydroxide.setFormula("Pb(OH)2", true)

        SodiumMolybdateSolution = new Material.Builder(8531, SuSyUtility.susyId('sodium_molybdate_solution'))
                .liquid()
                .components(Sodium * 2, Molybdenum, Oxygen * 4, Water)
                .colorAverage()
                .build();

        SodiumMolybdateSolution.setFormula("(Na2MoO4)(H2O)", true)

        // FREE ID: 8532-8533

        TitaniumIodide = new Material.Builder(8534, SuSyUtility.susyId('titanium_iodide'))
                .dust()
                .components(Titanium, Iodine * 4)
                .colorAverage()
                .build();

        //FREE IDs: 8535-8537

        FusedZirconia = new Material.Builder(8538, SuSyUtility.susyId('fused_zirconia'))
                .dust()
                .components(Zirconium, Oxygen * 2)
                .colorAverage()
                .iconSet(GLASS)
                .build();

        ImpureZirconiumTetrachloride = new Material.Builder(8539, SuSyUtility.susyId('impure_zirconium_tetrachloride'))
                .dust()
                .components(Zirconium, Chlorine * 4)
                .color(0x519c78)
                .build();

        ImpureZirconiumTetrachloride.setFormula("(ZrCl4)(?)", true)

        ZirconiumSulfateSolution = new Material.Builder(8540, SuSyUtility.susyId('zirconium_sulfate_solution'))
                .liquid()
                .components(Zirconium, Sulfur * 2, Oxygen * 8, Water * 3)
                .color(0x4fa15c)
                .build();

        ZirconiumSulfateSolution.setFormula("[Zr(SO4)2](H2O)3", true)

        ZirconylChlorideSolution = new Material.Builder(8541, SuSyUtility.susyId('zirconyl_chloride_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Zirconium, Oxygen, Chlorine * 2, HydrogenChloride * 2, Water * 2)
                .color(0x38a149)
                .build();

        ZirconylChlorideSolution.setFormula("(ZrOCl2)(HCl)2(H2O)2", true)

        PurifiedZirconylChlorideSolution = new Material.Builder(8542, SuSyUtility.susyId('purified_zirconyl_chloride_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Zirconium, Oxygen, Chlorine * 2, HydrogenChloride * 2, Water * 2)
                .color(0x4ab55c)
                .build();

        PurifiedZirconylChlorideSolution.setFormula("(ZrOCl2)(HCl)2(H2O)2", true)

        ZirconiumBasicSulfate = new Material.Builder(8543, SuSyUtility.susyId('zirconium_basic_sulfate'))
                .dust()
                .components(Zirconium * 5, Sulfur * 2, Oxygen * 16)
                .color(0x5fb54a)
                .build();

        ZirconiumBasicSulfate.setFormula("Zr5O8(SO4)2", true)

        ZirconiumTetrachloride = new Material.Builder(8544, SuSyUtility.susyId('zirconium_tetrachloride'))
                .dust().liquid(new FluidBuilder().attribute(FluidAttributes.ACID).temperature(710))
                .components(Zirconium, Chlorine * 4)
                .color(0x32ad72)
                .build();

        HafniumSulfateSolution = new Material.Builder(8545, SuSyUtility.susyId('hafnium_sulfate_solution'))
                .liquid()
                .components(Hafnium, Sulfur * 2, Oxygen * 8, Water * 2)
                .color(0xbbd1b0)
                .build();

        HafniumSulfateSolution.setFormula("[Hf(SO4)2](H2O)2", true)

        HafniumDioxide = new Material.Builder(8546, SuSyUtility.susyId('hafnium_dioxide'))
                .dust()
                .components(Hafnium, Oxygen * 2)
                .colorAverage()
                .build();

        ImpureHafniumTetrachloride = new Material.Builder(8547, SuSyUtility.susyId('impure_hafnium_tetrachloride'))
                .dust()
                .components(Hafnium, Chlorine * 4)
                .color(0xabccae)
                .build();

        ImpureHafniumTetrachloride.setFormula("(HfCl4)(?)", true)

        ZirconiumIodide = new Material.Builder(8548, SuSyUtility.susyId('zirconium_iodide'))
                .dust()
                .components(Zirconium, Iodine * 4)
                .colorAverage()
                .build();

        HafniumIodide = new Material.Builder(8549, SuSyUtility.susyId('hafnium_iodide'))
                .dust()
                .components(Hafnium, Iodine * 4)
                .colorAverage()
                .build();

        CalciumZirconate = new Material.Builder(8550, SuSyUtility.susyId('calcium_zirconate'))
                .dust()
                .components(Calcium, Zirconium, Oxygen * 3)
                .colorAverage()
                .build();

        NickelIINitrateSolution = new Material.Builder(8551, SuSyUtility.susyId('nickel_nitrate_solution'))
                .liquid()
                .components(Nickel, Nitrogen * 2, Oxygen * 6, Water)
                .colorAverage()
                .build();

        NickelIINitrateSolution.setFormula("[Ni(NO3)2](H2O)", true);

        FerroniobiumTantalum = new Material.Builder(8552, SuSyUtility.susyId('ferroniobium_tantalum'))
                .dust()
                .components(Iron * 2, Niobium * 7, Tantalum * 1)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .build();

        TantalumPentachloride = new Material.Builder(8553, SuSyUtility.susyId('tantalum_pentachloride'))
                .dust().gas(new FluidBuilder().temperature(513))
                .flags(NO_UNIFICATION)
                .components(Tantalum, Chlorine * 5)
                .colorAverage()
                .build();

        NiobiumPentachloride = new Material.Builder(8554, SuSyUtility.susyId('niobium_pentachloride'))
                .dust().gas(new FluidBuilder().temperature(521))
                .flags(NO_UNIFICATION)
                .components(Niobium, Chlorine * 5)
                .color(0xcfcf1d)
                .build();

        NiobiumOxideDihydrate = new Material.Builder(8555, SuSyUtility.susyId('niobium_oxide_dihydrate'))
                .dust()
                .components(Niobium * 2, Oxygen * 5, Water * 2)
                .colorAverage()
                .build();

        NiobiumOxideDihydrate.setFormula("Nb2O5 * (H2O)2", true)

        PurifiedFluoroniobicAcidSolution = new Material.Builder(8556, SuSyUtility.susyId('purified_fluoroniobic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 6, Niobium * 3, Fluorine * 9, Water * 6)
                .colorAverage()
                .build();

        PurifiedFluoroniobicAcidSolution.setFormula("(H2NbF7)1.35(H2O)6", true)

        NiobiumOxide = new Material.Builder(8557, SuSyUtility.susyId('niobium_oxide'))
                .dust()
                .components(Niobium * 2, Oxygen * 5)
                .colorAverage()
                .build();

        FluorotantalicAcidSolution = new Material.Builder(8558, SuSyUtility.susyId('fluorotantalic_acid_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 2, Tantalum, Fluorine * 7, Water)
                .colorAverage()
                .build();

        FluorotantalicAcidSolution.setFormula("(H2TaF7)0.9(H2O)", true)

        PotassiumHeptafluorotantalate = new Material.Builder(8559, SuSyUtility.susyId('potassium_heptafluorotantalate'))
                .dust()
                .components(Potassium * 2, Tantalum, Fluorine * 7)
                .colorAverage()
                .build();

        DilutedAmmoniaSolution = new Material.Builder(8560, SuSyUtility.susyId('diluted_ammonia_solution'))
                .liquid()
                .components(Ammonia, Water * 2)
                .colorAverage()
                .build();

        TantalumFluoride = new Material.Builder(8561, SuSyUtility.susyId('tantalum_fluoride'))
                .dust()
                .components(Tantalum, Fluorine * 5)
                .colorAverage()
                .build();

        AmmoniumPerrhenate = new Material.Builder(8562, SuSyUtility.susyId('ammonium_perrhenate'))
                .dust()
                .components(Nitrogen, Hydrogen * 4, Rhenium, Oxygen * 4)
                .color(0x2b6cb3)
                .build();

        //FREE ID: 8565

        NickelHydrotalcite = new Material.Builder(8564, SuSyUtility.susyId('nickel_hydrotalcite'))
                .dust()
                .components(Nickel * 3, Aluminium, Oxygen * 8, Hydrogen * 8, Chlorine)
                .color(0x9fb833)
                .build();

        NickelHydrotalcite.setFormula("[Ni3Al(OH)8]Cl", true)

        CalciumCyanamide = new Material.Builder(8565, SuSyUtility.susyId('calcium_cyanamide'))
                .dust()
                .components(Calcium, Carbon, Nitrogen * 2)
                .colorAverage()
                .build();

        AntimonyPentafluoride = new Material.Builder(8566, SuSyUtility.susyId('antimony_pentafluoride'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Antimony, Fluorine * 5)
                .colorAverage()
                .build();

        SodiumHexafluoroantimonate = new Material.Builder(8569, SuSyUtility.susyId('sodium_hexafluoroantimonate'))
                .dust()
                .components(Sodium, Antimony, Fluorine * 6)
                .colorAverage()
                .build();

        AlluvialPGM = new Material.Builder(8570, SuSyUtility.susyId('alluvial_pgm'))
                .dust().ingot()
                .flags(DISABLE_DECOMPOSITION)
                .components(Platinum * 2, Palladium, Iron)
                .colorAverage()
                .build();

        AmmoniumMetatungstate = new Material.Builder(8571, SuSyUtility.susyId('ammonium_metatungstate'))
                .dust()
                .components(Nitrogen * 6, Hydrogen * 26, Tungsten * 12, Oxygen * 40)
                .color(0x400959)
                .build();

        AmmoniumMetatungstate.setFormula("(NH4)6(H2W12O40)", true)

        ImpureBariumSulfide = new Material.Builder(8572, SuSyUtility.susyId("impure_barium_sulfide"))
                .dust()
                .components(Barium, Sulfur)
                .iconSet(DULL)
                .colorAverage()
                .build();

        ImpureBariumSulfide.setFormula("(?)(BaS)", true)

        ImpureStrontiumSulfide = new Material.Builder(8573, SuSyUtility.susyId("impure_strontium_sulfide"))
                .dust()
                .components(Strontium, Sulfur)
                .iconSet(DULL)
                .colorAverage()
                .build();

        ImpureStrontiumSulfide.setFormula("(?)(SrS)", true)

        StrontiumSulfideSolution = new Material.Builder(8574, SuSyUtility.susyId("strontium_sulfide_solution"))
                .liquid()
                .components(Strontium, Sulfur, Water)
                .colorAverage()
                .build();

        StrontiumSulfideSolution.setFormula("(SrS)(H2O)", true)

        StrontiumOxide = new Material.Builder(8575, SuSyUtility.susyId("strontium_oxide"))
                .dust()
                .components(Strontium, Oxygen)
                .colorAverage()
                .build();

        DilutedAceticAcid = new Material.Builder(8576, SuSyUtility.susyId("diluted_acetic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AceticAcid, Water)
                .colorAverage()
                .build();

        CobaltIIAcetate = new Material.Builder(8577, SuSyUtility.susyId("cobalt_ii_acetate"))
                .dust()
                .components(Cobalt, Carbon * 4, Oxygen * 6, Hydrogen * 4, Water * 4)
                .color(0xfc7e89)
                .build();

        CobaltIIAcetate.setFormula("Co(C2H3O2)2", true)

        PotassiumPyrosulfate = new Material.Builder(8578, SuSyUtility.susyId("potassium_pyrosulfate"))
                .dust()
                .components(Potassium * 2, Sulfur * 2, Oxygen * 7)
                .colorAverage()
                .build();

        IronIIINitrateSolution = new Material.Builder(8579, SuSyUtility.susyId("iron_iii_nitrate_solution"))
                .liquid()
                .components(Iron, Nitrogen * 3, Oxygen * 9, Water * 3)
                .colorAverage()
                .build();

        IronIIINitrateSolution.setFormula("(Fe(NO3)3)(H2O)3", true)
        
        ChlorosulfuricAcid = new Material.Builder(8580, SuSyUtility.susyId("chlorosulfuric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen, Sulfur, Oxygen * 3, Chlorine)
                .colorAverage()
                .build();

        ManganeseIIChloride = new Material.Builder(8581, SuSyUtility.susyId("manganese_ii_chloride"))
                .dust()
                .components(Manganese, Chlorine * 2)
                .colorAverage()
                .build();

        ChloroplatinicAcidSolution = new Material.Builder(8582, SuSyUtility.susyId("chloroplatinic_acid_solution"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Hydrogen * 2, Platinum, Chlorine * 6, Water * 4)
                .colorAverage()
                .build();

        MolybdenumDisulfide = new Material.Builder(8583, SuSyUtility.susyId("molybdenum_disulfide"))
                .dust()
                .components(Molybdenum, Sulfur * 2)
                .colorAverage()
                .build();

        FluorinatedGraphite = new Material.Builder(8584, SuSyUtility.susyId("fluorinated_graphite"))
                .dust()
                .components(Carbon, Fluorine)
                .colorAverage()
                .build();
      
        AcrylicCatalyst = new Material.Builder(8585, SuSyUtility.susyId("acrylic_catalyst"))
                .dust()
                .components(Copper, Nickel, Bromine * 4)
                .colorAverage()
                .build();

        GelatinSolution = new Material.Builder(8586, SuSyUtility.susyId("gelatin_solution"))
                .liquid(new FluidBuilder().temperature(323))
                .components(Gelatin, Water)
                .colorAverage()
                .build();

        PhosphomolybdicAcid = new Material.Builder(8587, SuSyUtility.susyId("phosphomolybdic_acid"))
                .dust()
                .components(Hydrogen * 3, Phosphorus, Molybdenum * 12, Oxygen * 40)
                .color(0xb39c07)
                .build();

        PhosphomolybdicAcid.setFormula("H3[PMo12O40]", true)
        
        UraniumDioxide = new Material.Builder(8588, SuSyUtility.susyId("uranium_dioxide"))
                .dust()
                .iconSet(SAND)
                .components(Uranium238, Oxygen * 2)
                .color(0x20291b)
                .build();

        UraniumDioxide.setFormula("UO2", true)

        UraniumTetrafluoride = new Material.Builder(8589, SuSyUtility.susyId("uranium_tetrafluoride"))
                .dust()
                .iconSet(SAND)
                .components(Uranium238, Fluorine * 4)
                .color(0x58826a)
                .build();

        UraniumTetrafluoride.setFormula("UF4", true)

        SiliconTetrachloride = new Material.Builder(8590, SuSyUtility.susyId('silicon_tetrachloride'))
                .liquid()
                .components(Silicon, Chlorine * 4)
                .color(0x63827f)
                .build();

        PurifiedSiliconTetrachloride = new Material.Builder(8591, SuSyUtility.susyId('purified_silicon_tetrachloride'))
                .liquid()
                .components(Silicon, Chlorine * 4)
                .color(0x7fa3a0)
                .build();

        SaltyHydrofluoricAcid = new Material.Builder(8592, SuSyUtility.susyId("salty_hydrofluoric_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(Salt, HydrofluoricAcid)
                .colorAverage()
                .build();

        WaferTreatmentAcid = new Material.Builder(8593, SuSyUtility.susyId("wafer_treatment_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(HydrochloricAcid * 9, HydrofluoricAcid * 9, AceticAcid * 2)
                .color(0x3e7d68)
                .build();

        ThalliumIChloride = new Material.Builder(8594, SuSyUtility.susyId("thallium_i_chloride"))
                .dust()
                .components(Thallium, Chlorine)
                .colorAverage()
                .build();

        AcidicThalliumSulfateSolution = new Material.Builder(8595, SuSyUtility.susyId("acidic_thallium_sulfate_solution"))
                .liquid()
                .components(Thallium * 2, Sulfur, Oxygen * 4, HydrogenChloride * 2, Water)
                .colorAverage()
                .build();

        AcidicThalliumSulfateSolution.setFormula("(Tl2SO4)(HCl)2(H2O)", true)

        ThalliumSulfateSolution = new Material.Builder(8596, SuSyUtility.susyId("thallium_sulfate_solution"))
                .liquid()
                .components(Thallium * 2, Sulfur, Oxygen * 4, Water)
                .colorAverage()
                .build();

        ThalliumSulfateSolution.setFormula("(Tl2SO4)(H2O)", true)

        ImpureCobaltSulfateSolution = new Material.Builder(8597, SuSyUtility.susyId("impure_cobalt_sulfate_solution"))
                .liquid()
                .components(Cobalt, Sulfur, Oxygen * 4, Water)
                .colorAverage()
                .build();

        ImpureCobaltSulfateSolution.setFormula("(CoSO4)(?)(H2O)", true)

        //FREE ID: 8598

        PurifiedCadmiumSolution = new Material.Builder(8599, SuSyUtility.susyId('purified_cadmium_solution'))
                .liquid()
                .components(Cadmium, Sulfur, Oxygen * 4, Water)
                .colorAverage()
                .build()

        GermaniumTetrachloride = new Material.Builder(8600, SuSyUtility.susyId('germanium_tetrachloride'))
                .liquid()
                .components(Germanium, Chlorine * 4)
                .color(0xbae6dd)
                .build()
        
        GermaniumDioxide = new Material.Builder(8601, SuSyUtility.susyId('germanium_dioxide'))
                .dust()
                .components(Germanium, Oxygen * 2)
                .color(0x4b9485)
                .build()

        IronOxalateDihydrate = new Material.Builder(8602, SuSyUtility.susyId('iron_oxalate_dihydrate'))
                .dust()
                .components(Iron, Carbon * 2, Oxygen * 4, Water * 2)
                .colorAverage()
                .build()

        IndiumIIISulfateSolution = new Material.Builder(8603, SuSyUtility.susyId('indium_iii_sulfate_solution'))
                .liquid()
                .components(Indium * 2, Sulfur * 3, Oxygen * 12, Water * 6)
                .color(0x8d18ad)
                .build()

        IndiumIIISulfateSolution.setFormula("(In2(SO4)3)(H2O)6", true);

        ZincSulfateSolution = new Material.Builder(8604, SuSyUtility.susyId('zinc_sulfate_solution'))
                .liquid()
                .components(Zinc, Sulfur, Oxygen * 4, Water * 2)
                .colorAverage()
                .build()

        ZincSulfateSolution.setFormula("(ZnSO4)(H2O)2", true);

        SodiumSelenateSolution = new Material.Builder(8605, SuSyUtility.susyId('sodium_selenate_solution'))
                .liquid()
                .components(Sodium * 2, Selenium, Oxygen * 4, Water)
                .color(0xb0bf97)
                .build()

        SodiumSelenateSolution.setFormula("(Na2SeO4)(H2O)", true);

        SodiumSeleniteSolution = new Material.Builder(8606, SuSyUtility.susyId('sodium_selenite_solution'))
                .liquid()
                .components(Sodium * 2, Selenium, Oxygen * 3, Water)
                .color(0x96a67c)
                .build()

        SodiumSeleniteSolution.setFormula("(Na2SeO3)(H2O)", true);

        HydrogenSelenide = new Material.Builder(8607, SuSyUtility.susyId('hydrogen_selenide'))
                .gas()
                .components(Hydrogen * 2, Selenium)
                .color(0xcadb93)
                .build()

        TelluriumDioxide = new Material.Builder(8608, SuSyUtility.susyId('tellurium_dioxide'))
                .dust()
                .components(Tellurium, Oxygen * 2)
                .color(0xb1d4b0)
                .build()

        SodiumTelluriteSolution = new Material.Builder(8609, SuSyUtility.susyId('sodium_tellurite_solution'))
                .liquid()
                .components(Sodium * 2, Tellurium, Oxygen * 3, Water * 3)
                .color(0xb0d4c6)
                .build()

        SodiumTelluriteSolution.setFormula("(Na2TeO3)(H2O)3", true)

        SodiumAlum = new Material.Builder(8610, SuSyUtility.susyId("sodium_alum"))
                .dust()
                .components(Sodium, Aluminium, Sulfur * 2, Oxygen * 8)
                .colorAverage()
                .build()

        SodiumAlum.setFormula("NaAl(SO4)2", true)

        CaesiumAlum = new Material.Builder(8611, SuSyUtility.susyId("caesium_alum"))
                .dust()
                .components(Caesium, Aluminium, Sulfur * 2, Oxygen * 8)
                .color(0x293c9e)
                .build()

        CaesiumAlum.setFormula("CsAl(SO4)2", true)

        RubidiumAlum = new Material.Builder(8612, SuSyUtility.susyId("rubidium_alum"))
                .dust()
                .components(Rubidium, Aluminium, Sulfur * 2, Oxygen * 8)
                .color(0xc72882)
                .build()

        RubidiumAlum.setFormula("RbAl(SO4)2", true)

        CaesiumSulfateSolution = new Material.Builder(8613, SuSyUtility.susyId("caesium_sulfate_solution"))
                .liquid()
                .components(Caesium * 2, Sulfur, Oxygen * 4)
                .color(0x8528c7)
                .build()

        CaesiumChloride = new Material.Builder(8614, SuSyUtility.susyId("caesium_chloride"))
                .dust()
                .components(Caesium, Chlorine)
                .color(0x2885c7)
                .build()

        ReducedCaesiumMixture = new Material.Builder(8615, SuSyUtility.susyId("reduced_caesium_mixture"))
                .dust()
                .components(Caesium * 2, CalciumChloride)
                .color(0xf7f7d0)
                .build()

        CaesiumHydroxideSolution = new Material.Builder(8616, SuSyUtility.susyId("caesium_hydroxide_solution"))
                .liquid()
                .components(Caesium, Oxygen, Hydrogen, Water)
                .color(0x5458bf)
                .build()

        CaesiumHydroxideSolution.setFormula("(CsOH)(H2O)", true)

        CaesiumFormateSolution = new Material.Builder(8617, SuSyUtility.susyId("caesium_formate_solution"))
                .liquid()
                .components(Caesium, Carbon, Hydrogen, Oxygen * 2)
                .color(0x7b54bf)
                .build()

        RubidiumHydroxide = new Material.Builder(8618, SuSyUtility.susyId("rubidium_hydroxide"))
                .dust()
                .components(Rubidium, Oxygen, Hydrogen)
                .color(0xbf54bb)
                .build()

        Kovar = new Material.Builder(8619, SuSyUtility.susyId('kovar'))
                .ingot()
                .iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Iron * 2, Nickel * 1, Cobalt * 1)
                .colorAverage()
                .blastTemp(1723, GasTier.LOW, 120, 24)
                .build();

        Kovar.setFormula("Fe10Ni5Co3", true)

        ImpureLithiumCarbonate = new Material.Builder(8621, SuSyUtility.susyId("impure_lithium_carbonate"))
                .dust().liquid(new FluidBuilder().temperature(1000))
                .components(Carbon * 2, Lithium * 2, Oxygen * 3)
                .color(0x4f5c6c)
                .build()
                .setFormula("(C)(Li2CO3)", true);

        WashedGraphene = new Material.Builder(8622, SuSyUtility.susyId("washed_graphene"))
                .dust()
                .components(Carbon)
                .color(0x595999)
                .build();

        DistilledGraphene = new Material.Builder(8623, SuSyUtility.susyId("distilled_graphene"))
                .dust()
                .components(Carbon)
                .color(0x595959)
                .build();

        DriedGraphene = new Material.Builder(8624, SuSyUtility.susyId("dried_graphene"))
                .dust()
                .components(Carbon)
                .color(0x797979)
                .build();

        MoistArgon = new Material.Builder(8625, SuSyUtility.susyId("moist_argon"))
                .gas()
                .components(Argon, Water)
                .colorAverage()
                .build()
                .setFormula("(Ar)(H2O)", true)

        ArgonHydrogenMixture = new Material.Builder(8626, SuSyUtility.susyId("argon_hydrogen_mixture"))
                .gas()
                .components(Argon, Hydrogen * 4)
                .color(0x20a291)
                .build()
                .setFormula("(Ar)(H)", true)

        IncoloyTwenty = new Material.Builder(8627, SuSyUtility.susyId("incoloy_twenty"))
                .ingot().liquid(new FluidBuilder().temperature(1675))
                .iconSet(SHINY)
                .components(Iron * 12, Nickel * 8, Chrome * 12, Manganese, Copper * 2, Niobium, Tantalum, Molybdenum * 2)
                .colorAverage()
                .flags(GENERATE_ROD, GENERATE_PLATE)
                .build()

        IncoloyEightTwoFive = new Material.Builder(8628, SuSyUtility.susyId("incoloy_eight_two_five"))
                .ingot().liquid(new FluidBuilder().temperature(1675))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .components(Iron * 9, Nickel * 16, Chrome * 7, Manganese, Copper * 2, Aluminium, Titanium, Molybdenum * 2)
                .colorAverage()
                .build()

        IncoloyNineZeroEight = new Material.Builder(8629, SuSyUtility.susyId("incoloy_nine_zero_eight"))
                .ingot().liquid(new FluidBuilder().temperature(1685))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .components(Iron * 20, Nickel * 30, Cobalt, Chrome * 3, Aluminium, Titanium * 2, Tungsten, Niobium * 2)
                .colorAverage()
                .build()

        ReneN = new Material.Builder(8630, SuSyUtility.susyId("rene"))
                .ingot().liquid(new FluidBuilder().temperature(1780))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_ROTOR)
                .components(Nickel * 22, Cobalt * 4, Chrome * 3, Aluminium * 3, Tungsten * 2, Hafnium, Rhenium * 2, Tantalum * 3)
                .colorAverage()
                .build()

        MonelFiveHundred = new Material.Builder(8631, SuSyUtility.susyId("monel"))
                .ingot().liquid(new FluidBuilder().temperature(1625))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .components(Nickel * 23, Manganese * 2, Copper * 10, Aluminium * 4, Titanium)
                .colorAverage()
                .build()

        StelliteJ = new Material.Builder(8632, SuSyUtility.susyId("stellite_j"))
                .ingot().liquid(new FluidBuilder().temperature(1575))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .components(Iron * 2, Nickel * 2, Cobalt * 15, Chrome * 13, Manganese, Tungsten * 7)
                .colorAverage()
                .build()

        StelliteSix = new Material.Builder(8633, SuSyUtility.susyId("stellite_six"))
                .ingot().liquid(new FluidBuilder().temperature(1630))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .components(Nickel, Cobalt * 24, Chrome * 10, Manganese, Tungsten * 3, Molybdenum)
                .colorAverage()
                .build()

        HSLAEightyX = new Material.Builder(8634, SuSyUtility.susyId("hsla_eighty_x"))
                .ingot().liquid(new FluidBuilder().temperature(1770))
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD)
                .components(Iron * 39, Manganese)
                .colorAverage()
                .build()
                .setFormula("Fe99Mn", true)

        FoodGradeStainlessSteel = new Material.Builder(8635, SuSyUtility.susyId("food_grade_stainless_steel"))
                .ingot().liquid(new FluidBuilder().temperature(1780))
                .iconSet(SHINY)
                .flags(GENERATE_ROD, GENERATE_PLATE, GENERATE_RING, GENERATE_LONG_ROD)
                .components(Iron * 24, Nickel * 5, Chrome * 8, Manganese, Molybdenum * 2)
                .colorAverage()
                .build()

        CobaltSulfate = new Material.Builder(8636, SuSyUtility.susyId('cobalt_sulfate'))
                .dust()
                .components(Cobalt * 1, Sulfur * 1, Oxygen * 4)
                .color(0xbb7694)
                .build()

        CobaltSulfateSolution = new Material.Builder(8637, SuSyUtility.susyId('cobalt_sulfate_solution'))
                .liquid()
                .components(CobaltSulfate * 1, Water * 1)
                .colorAverage()
                .build()

        // 8638: Co3O4

        LithiumNitrate = new Material.Builder(8639, SuSyUtility.susyId('lithium_nitrate'))
                .dust()
                .components(Lithium * 1, Nitrogen * 1, Oxygen * 3)
                .color(0xffffff)
                .build()

        LithiumNitrateSolution = new Material.Builder(8640, SuSyUtility.susyId('lithium_nitrate_solution'))
                .liquid()
                .components(LithiumNitrate * 2, Water * 1)
                .colorAverage()
                .build()
    }
}
