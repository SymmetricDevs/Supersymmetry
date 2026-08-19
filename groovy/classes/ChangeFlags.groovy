package classes

import gregicality.multiblocks.api.unification.properties.GCYMPropertyKey
import gregtech.api.fluids.FluidBuilder
import gregtech.api.fluids.attribute.FluidAttributes
import gregtech.api.fluids.store.FluidStorageKey
import gregtech.api.fluids.store.FluidStorageKeys
import gregtech.api.recipes.RecipeMaps
import gregtech.api.unification.material.Material
import gregtech.api.unification.material.properties.*
import gregtech.api.unification.material.properties.BlastProperty.GasTier
import gregtech.api.unification.material.properties.OreProperty
import gregtech.api.unification.material.properties.PropertyKey
import supersymmetry.api.fluids.SusyFluidStorageKeys
import supersymmetry.api.recipes.SuSyRecipeMaps
import supersymmetry.api.unification.material.properties.DummyABSProperty
import supersymmetry.api.unification.material.properties.FiberProperty
import supersymmetry.api.unification.material.properties.MillBallProperty
import supersymmetry.api.unification.material.properties.SuSyPropertyKey

import static gregtech.api.unification.material.Materials.*
import static gregtech.api.unification.material.info.MaterialFlags.*
import static supersymmetry.common.materials.SusyMaterials.*
import static material.SuSyMaterials.*

import supercritical.api.unification.material.properties.FissionFuelProperty
import supercritical.api.unification.material.properties.ModeratorProperty
import supercritical.api.unification.material.properties.SCPropertyKey
import supersymmetry.integration.groovyscript.SuSyExpansions
import postInit.materials.polymers.fibers.PolybenzimidazoleChain

//eventManager.listen(EventPriority.LOWEST)SS
class ChangeFlags {

    public static void init() {
    //MaterialEvent event ->

        log.infoMC("Modifying flags...")

        RecipeMaps.BLAST_RECIPES.setMaxFluidInputs(2)
        RecipeMaps.PYROLYSE_RECIPES.setMaxFluidInputs(2)
        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.setMaxFluidInputs(3)
        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.setMaxInputs(12)

        // Properties
        Stone.setProperty(PropertyKey.TOOL, new ToolProperty(4.0F, 1.0F, 131, 1));
        Granite.setProperty(PropertyKey.TOOL, new ToolProperty(4.0F, 1.0F, 191, 1));

        Germanium.addIngot()
        Tellurium.addIngot()
        Cadmium.addIngot()
        Magnesium.addIngot()
        Asbestos.addIngot()
        Potassium.addIngot()

        BisphenolA.addDust()
        Polonium.addDust()
        
        Silver.addFluidPipes(1234, 50, false, false, true, false, true)
        Rubber.addFluidPipes(593, 6, true, false, false, false, false)
        Iron.addFluidPipes(1811, 40, true, false, false, false, false)

        AntimonyTrifluoride.setupFluidTypes(565, FluidStorageKeys.LIQUID)
        LithiumChloride.setupFluidTypes(890, FluidStorageKeys.LIQUID)
        SiliconDioxide.setupFluidTypes(1986, FluidStorageKeys.LIQUID)
        Caesium.setupFluidTypes(302, FluidStorageKeys.LIQUID)
        Cadmium.setupFluidTypes(600, FluidStorageKeys.LIQUID)
        BisphenolA.setupFluidTypes(428, FluidStorageKeys.LIQUID)
        Iodine.setupFluidTypes(460, FluidStorageKeys.GAS)
        Chlorine.getProperty(PropertyKey.FLUID).enqueueRegistration(FluidStorageKeys.PLASMA, new FluidBuilder())
        Selenium.setupFluidTypes(494, FluidStorageKeys.LIQUID)
        OsmiumTetroxide.setupFluidTypes(404, FluidStorageKeys.GAS)
        OsmiumTetroxide.addFlags("NO_UNIFICATION")
        //Iron3Chloride.setupFluidTypes(590, FluidStorageKeys.GAS) 

        Sodium.setupFluidTypes(371, FluidStorageKeys.LIQUID)
        SodiumHydroxide.setupFluidTypes(591, FluidStorageKeys.LIQUID)
        Polydimethylsiloxane.setupFluidTypes(293, FluidStorageKeys.LIQUID)
        Glass.setupFluidTypes(1800, FluidStorageKeys.LIQUID)
        PolyvinylButyral.setupFluidTypes(440, FluidStorageKeys.LIQUID)
        Nitrochlorobenzene.setupFluidTypes(326, FluidStorageKeys.LIQUID)
        Iron3Chloride.setupFluidTypes(585, FluidStorageKeys.LIQUID)
        Dichlorobenzidine.setupFluidTypes(438, FluidStorageKeys.LIQUID)
        Diaminobenzidine.setupFluidTypes(450, FluidStorageKeys.LIQUID)
        PhthalicAcid.setupFluidTypes(480, FluidStorageKeys.LIQUID)
        DiphenylIsophtalate.setupFluidTypes(410, FluidStorageKeys.LIQUID)
        Dichlorobenzene.setupFluidTypes(256, FluidStorageKeys.LIQUID)
        SiliconeRubber.setupFluidTypes(400, FluidStorageKeys.LIQUID)
        StyreneButadieneRubber.setupFluidTypes(450, FluidStorageKeys.LIQUID)
        HighPurityGermanium.setupFluidTypes(1211, FluidStorageKeys.LIQUID)
        HighPurityArsenic.setupFluidTypes(1090, FluidStorageKeys.LIQUID)
        HighPuritySelenium.setupFluidTypes(494, FluidStorageKeys.LIQUID)
        BlackSteel.setupFluidTypes(1728, FluidStorageKeys.LIQUID)
        Polytetrafluoroethylene.setupFluidTypes(293, FluidStorageKeys.LIQUID)

        CarbonDioxide.setupFluidTypes(304, SusyFluidStorageKeys.SUPERCRITICAL)
        Propane.setupFluidTypes(370, SusyFluidStorageKeys.SUPERCRITICAL)

        Polybenzimidazole.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, true))
        Polytetrafluoroethylene.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, false))
        Asbestos.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, true))

        Tantalum.addBlastProperty(1700, "MID", 480, 240, -1, -1)
        Molybdenum.addBlastProperty(1700, "MID", 480, 240, -1, -1)
        Platinum.addBlastProperty(1400, "LOW", 480, 240, -1, -1)
        Thorium.addBlastProperty(1400, "LOW", 480, 240, -1, -1)
        Cobalt.addBlastProperty(800, "LOW", 120, 200, -1, -1)
        Beryllium.addBlastProperty(800, "LOW", 120, 200, -1, -1)
        Nickel.addBlastProperty(800, "LOW", 120, 120, -1, -1)
        Hafnium.addBlastProperty(1400, "LOW", 120, 120, -1, -1)

        // Supercons, max amps multiplied by 4.
        ManganesePhosphide.getProperty(PropertyKey.WIRE).setAmperage(8)
        MagnesiumDiboride.getProperty(PropertyKey.WIRE).setAmperage(16)
        MercuryBariumCalciumCuprate.getProperty(PropertyKey.WIRE).setAmperage(16)
        UraniumTriplatinum.getProperty(PropertyKey.WIRE).setAmperage(24)
        SamariumIronArsenicOxide.getProperty(PropertyKey.WIRE).setAmperage(24)
        IndiumTinBariumTitaniumCuprate.getProperty(PropertyKey.WIRE).setAmperage(32)
        UraniumRhodiumDinaquadide.getProperty(PropertyKey.WIRE).setAmperage(32)
        EnrichedNaquadahTriniumEuropiumDuranide.getProperty(PropertyKey.WIRE).setAmperage(64)
        RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE).setAmperage(96)

        // Allow PE & PTFE to carry acidic/cyro fluids. Used in plastic cans
        Polyethylene.getProperty(PropertyKey.FLUID_PIPE).setCryoProof(true)
        Polyethylene.getProperty(PropertyKey.FLUID_PIPE).setCanContain(FluidAttributes.ACID, true)
        Polyethylene.setBaseProof(true)
        Polytetrafluoroethylene.getProperty(PropertyKey.FLUID_PIPE).setCryoProof(true)
        Polytetrafluoroethylene.setBaseProof(true)

        // Base-proof
        Chrome.setBaseProof(true)
        Copper.setBaseProof(true)
        Gold.setBaseProof(true)
        Iridium.setBaseProof(true)
        Titanium.setBaseProof(true)
        Neutronium.setBaseProof(true)
        Duranium.setBaseProof(true)
        NiobiumTitanium.setBaseProof(true)
        StainlessSteel.setBaseProof(true)
        Steel.setBaseProof(true)
        TungstenCarbide.setBaseProof(true)
        Tungsten.setBaseProof(true)
        Polybenzimidazole.setBaseProof(true)

        // :Acidic:
        TitaniumTetrachloride.setAcidic(FluidStorageKeys.LIQUID)
        Iron3Chloride.setAcidic(FluidStorageKeys.LIQUID)
        SulfurDioxide.setAcidic(FluidStorageKeys.GAS)
        SulfurTrioxide.setAcidic(FluidStorageKeys.GAS)

        // :Basic:
        Ammonia.setBasic(FluidStorageKeys.GAS)
        Dimethylamine.setBasic(FluidStorageKeys.GAS)
        Dimethylhydrazine.setBasic(FluidStorageKeys.LIQUID)

        // Dummy properties for continuous casting
        Steel.setProperty(GCYMPropertyKey.ALLOY_BLAST, new DummyABSProperty())
        Aluminium.setProperty(GCYMPropertyKey.ALLOY_BLAST, new DummyABSProperty())

        // Flags

        Asbestos.addFlags("generate_foil");
        Magnesium.addFlags("generate_rod", "generate_plate");
        Tellurium.addFlags("generate_plate");
        Steel.addFlags("generate_spring", "generate_spring_small", "continuously_cast");
        Titanium.addFlags("generate_foil", "generate_spring", "generate_spring_small");
        Lead.addFlags("generate_round");
        Nickel.addFlags("generate_rod", "generate_foil", "generate_fine_wire");
        Aluminium.addFlags("generate_round", "generate_rotor", "continuously_cast");
        Tungsten.addFlags("generate_fine_wire", "hip_pressed");
        Molybdenum.addFlags("generate_fine_wire", "generate_ring");
        Tantalum.addFlags("generate_rod", "generate_fine_wire", "generate_catalyst_bed", "generate_plate");
        Titanium.addFlags("generate_fine_wire");
        ChromiumTrioxide.addFlags("generate_catalyst_bed");
        Iron3Chloride.addFlags("generate_catalyst_bed");
        Alumina.addFlags("generate_catalyst_bed");
        Silver.addFlags("generate_catalyst_bed");
        Nickel.addFlags("generate_catalyst_bed");
        Magnesia.addFlags("generate_catalyst_bed");
        CupricOxide.addFlags("generate_catalyst_bed");
        Brass.addFlags("generate_ring");
        Indium.addFlags("generate_plate");
        BisphenolA.addFlags("no_unification");
        Phosphorus.addFlags("no_smelting");
        Tetrahedrite.addFlags("no_smelting");
        Gold.addFlags("generate_gear");
        IronMagnetic.addFlags("generate_ring");
        SteelMagnetic.addFlags("generate_plate")
        StainlessSteel.addFlags("generate_round");
        Hafnium.addFlags("generate_long_rod", "generate_rod");
        VanadiumSteel.addFlags("generate_round");
        Mica.addFlags("generate_plate", "no_unification");
        Rubber.addFlags("generate_plate");
        TungstenCarbide.addFlags("hip_pressed");
        Polycaprolactam.addFlags("generate_foil");
        Palladium.addFlags("generate_bolt_screw");
        Copper.addFlags("continuously_cast");
        AluminiumAlloy7075.addFlags("generate_long_rod", "generate_rod");
        Graphite.addFlags("generate_plate");
        Germanium.addFlags("generate_plate");
        Magnalium.addFlags("generate_ring", "generate_rotor")
        ReinforcedEpoxyResin.addFlags("generate_rotor")
        Beryllium.addFlags("generate_rod")
        Bronze.addFlags("disable_decomposition")
        Brass.addFlags("disable_decomposition")
        Cupronickel.addFlags("disable_decomposition")
        Invar.addFlags("disable_decomposition")
        Nichrome.addFlags("disable_decomposition")
        Kanthal.addFlags("disable_decomposition")

        /*
        ManganesePhosphide.addFlags("no_smashing", "no_smelting")
        MagnesiumDiboride.addFlags("no_smashing", "no_smelting")
        MercuryBariumCalciumCuprate.addFlags("no_smashing", "no_smelting")
        UraniumTriplatinum.addFlags("no_smashing", "no_smelting")
        SamariumIronArsenicOxide.addFlags("no_smashing", "no_smelting")
        IndiumTinBariumTitaniumCuprate.addFlags("no_smashing", "no_smelting")
        UraniumRhodiumDinaquadide.addFlags("no_smashing", "no_smelting")
        EnrichedNaquadahTriniumEuropiumDuranide.addFlags("no_smashing", "no_smelting")
        RutheniumTriniumAmericiumNeutronate.addFlags("no_smashing", "no_smelting")
        */

        ManganesePhosphide.addFlags("generate_fine_wire")
        UraniumTriplatinum.addFlags("generate_fine_wire")
        RutheniumTriniumAmericiumNeutronate.addFlags("generate_fine_wire")

        // Colors

        Phosphorus.setMaterialRGB(0xfffed6)
        Terbium.setMaterialRGB(0x4b9c70)
        Dysprosium.setMaterialRGB(0xbfc25f)
        Holmium.setMaterialRGB(0xe3b16b)
        Erbium.setMaterialRGB(0xc07ede)
        Thulium.setMaterialRGB(0xe86666)
        Mica.setMaterialRGB(0xe8e7ba)

        // Formulae

        DilutedHydrochloricAcid.setFormula("(H2O)2(HCl)", true)
        DilutedSulfuricAcid.setFormula("(H2SO4)(H2O)", true)
        AquaRegia.setFormula("(HNO3)(HCl)3", true)
        Tantalite.setFormula("(Fe,Mn)Ta2O6", true)
        Lepidolite.setFormula("(K,Rb)AlLi2Si4O10(OH,F)2", true)
        Tetrahedrite.setFormula("Cu12Sb4S13", true)
        IndiumGalliumPhosphide.setFormula("InGaP2", true)
        NetherAir.setFormula("(N78O21Ar9)24(CO2)2(H2S)(SO2)", true)
        Diatomite.setFormula("(SiO2)8(Fe2O3)(Al2O3)", true)
        Pollucite.setFormula("(Cs,Na)2Al2Si4O12(H2O)2", true)
        Pitchblende.setFormula("(?)UO2", true)
        Bastnasite.setFormula("(REE)CO3F", true)
        Monazite.setFormula("(REE,Th)PO4", true)
        Gypsum.setFormula("(CaSO4)*(H2O)2", true)
        Polyethylene.setFormula("[C2H4]n", true)
        PolyvinylChloride.setFormula("[C2H3Cl]n", true)
        Rubber.setFormula("[C5H8]n", true)
        Polycaprolactam.setFormula("[C6H11NO]n", true)
        Polytetrafluoroethylene.setFormula("[C2F4]n", true)
        SiliconeRubber.setFormula("[SiC2H6O]n", true)
        StyreneButadieneRubber.setFormula("[C40H44]n", true)
        PolyphenyleneSulfide.setFormula("[C6H4S]n", true)
        Polybenzimidazole.setFormula("[C20H12N4]n", true)
        PolyvinylAcetate.setFormula("[C4H6O2]n", true)
        PolyvinylButyral.setFormula("[C8H14O2]n", true)
        TungstenSteel.setFormula("Fe60W8Cr3Mo2V", true)
        StainlessSteel.setFormula("Fe28Cr8Ni4Si2Mn", true)
        Magnalium.setFormula("MgAl19", true)
        Bronze.setFormula("Cu14Sn", true)
        Brass.setFormula("Cu5Zn2", true)
        Cupronickel.setFormula("Cu8Ni", true)
        Invar.setFormula("Fe5Ni3", true)
        Nichrome.setFormula("Ni7Cr2", true)
        Kanthal.setFormula("Fe27Cr8Al4", true)

        // Ore Processing
        
        Pitchblende.addFlags("disable_decomposition")
        Borax.addOre()
        Scheelite.addFlags("generate_sifted", "generate_flotated")
        Scheelite.setupSlurries()
        Pyrochlore.addFlags("generate_sifted", "generate_flotated", "generate_concentrate")
        Pyrochlore.setupSlurries()
        Molybdenite.addFlags("generate_flotated")
        Molybdenite.setupSlurries()
        Tantalite.addFlags("generate_sifted", "generate_flotated", "generate_concentrate")
        Tantalite.setupSlurries()
        Galena.setupSlurries()
        Stibnite.setupSlurries()
        Cinnabar.setupSlurries()
        Ilmenite.addFlags("generate_flotated", "generate_concentrate")
        Ilmenite.setupSlurries()
        Barite.setupSlurries()
        Spodumene.setupSlurries()
        Cassiterite.addFlags("generate_concentrate")
        Cassiterite.setupSlurries()
        Malachite.setupSlurries()
        Rutile.addFlags("generate_concentrate")
        Sphalerite.setupSlurries()
        Pollucite.setupSlurries()
        Pentlandite.addFlags("generate_sifted", "generate_flotated")
        Pentlandite.setupSlurries()
        Bastnasite.addFlags("generate_sifted", "generate_flotated")
        Bastnasite.setupSlurries()
        Monazite.addFlags("generate_concentrate")

        PolyvinylAcetate.setupFluidTypes(385, FluidStorageKeys.LIQUID)


        Petalite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Aluminium.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Beryllium.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Cobalt.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Copper.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Gold.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Iron.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Lead.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Lithium.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Molybdenum.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Neodymium.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Nickel.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Palladium.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Platinum.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Plutonium239.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Silver.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Sulfur.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Thorium.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Tin.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Naquadah.getProperty(PropertyKey.ORE).getOreByProducts().clear()

        CertusQuartz.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Almandine.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Asbestos.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        BandedIron.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        BlueTopaz.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        BrownLimonite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        YellowLimonite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Calcite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Cassiterite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        CassiteriteSand.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Chalcopyrite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Chromite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Cinnabar.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Coal.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Cobaltite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Cooperite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Diamond.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Electrum.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Emerald.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Galena.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Garnierite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        GreenSapphire.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Grossular.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Ilmenite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Bauxite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Lapis.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Magnesite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Magnetite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Molybdenite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Powellite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Scheelite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Pyrite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Pyrolusite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Pyrope.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        RockSalt.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Ruby.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Salt.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Saltpeter.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Sapphire.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Sodalite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Tantalite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Spessartine.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Sphalerite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Stibnite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Tetrahedrite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Topaz.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Tungstate.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Uraninite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Wulfenite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        NetherQuartz.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Graphite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Bornite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Chalcocite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Realgar.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Bastnasite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Pentlandite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Spodumene.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Lepidolite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        GlauconiteSand.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Malachite.getProperty(PropertyKey.ORE).setOreMultiplier(2)
        Malachite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Alunite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Talc.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Kyanite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Pyrochlore.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Borax.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Olivine.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Opal.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Amethyst.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Apatite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        TricalciumPhosphate.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        GarnetRed.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        GarnetYellow.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        VanadiumMagnetite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Pollucite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Pitchblende.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Bentonite.setOreByProducts(Clay, Clay, Clay, Clay)

        FullersEarth.setOreByProducts(Clay, Clay, Clay, Clay)

        Monazite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Trona.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Gypsum.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Zeolite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Redstone.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Electrotine.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Diatomite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        GraniticMineralSand.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        GarnetSand.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        BasalticMineralSand.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Thortveitite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Titanomagnetite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        VanadiferousTitanomagnetite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Perovskite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Arsenopyrite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Smithsonite.getProperty(PropertyKey.ORE).setDirectSmeltResult(Zinc)
        Smithsonite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Enargite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Proustite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Celestine.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Strontianite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Acanthite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Stephanite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Pyrargyrite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Barite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Witherite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Wolframite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Sperrylite.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings)

        Cerussite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Anglesite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Bismuthinite.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings)

        Amblygonite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Vanadinite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Carnotite.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings)

        Bertrandite.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings)

        Cerussite.getProperty(PropertyKey.ORE).setDirectSmeltResult(Lead)

        Anglesite.getProperty(PropertyKey.ORE).setDirectSmeltResult(Lead)

        Pyrolusite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Platinum.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Molybdenum.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Molybdenite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Beryllium.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Cobaltite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Cobalt.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Thorium.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Nickel.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Pentlandite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Garnierite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Ilmenite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Powellite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Uraninite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        Magnesite.getProperty(PropertyKey.ORE).setDirectSmeltResult(null)

        // Flammables

        Naphtha.addFlags("flammable")
        NaturalGas.addFlags("flammable")
        Methane.addFlags("flammable")
        Ethane.addFlags("flammable")
        Propane.addFlags("flammable")
        Butane.addFlags("flammable")
        Butadiene.addFlags("flammable")
        Toluene.addFlags("flammable")
        WoodGas.addFlags("flammable")
        CoalGas.addFlags("flammable")
        Ethylene.addFlags("flammable")
        RefineryGas.addFlags("flammable")
        Ammonia.addFlags("flammable")
        Propene.addFlags("flammable")
        Butene.addFlags("flammable")
        Phenol.addFlags("flammable")
        Benzene.addFlags("flammable")
        Hydrogen.addFlags("flammable")
        Methanol.addFlags("flammable")
        Ethanol.addFlags("flammable")
        log.infoMC("Finished modifying flags")

        // Nuclear

        Bismuth.setProperty(SCPropertyKey.FISSION_FUEL, FissionFuelProperty.builder(Bismuth.getRegistryName(), 560, 5000, 5)
                .slowNeutronCaptureCrossSection(0.2)
                .requiredNeutrons(1)
                .releasedNeutrons(0)
                .releasedHeatEnergy(0.005)
                .build())

        Graphite.setProperty(SCPropertyKey.MODERATOR, ModeratorProperty.builder()
                .maxTemperature(3650)
                .absorptionFactor(0.0625)
                .moderationFactor(3).build())
        Graphite.addFlags("force_generate_block")

        Beryllium.setProperty(SCPropertyKey.MODERATOR, ModeratorProperty.builder()
                .maxTemperature(1500)
                .absorptionFactor(0.015625)
                .moderationFactor(5).build())
        Beryllium.addFlags("force_generate_block")

        // Mill balls
        Steel.addMillBall(7680)
        StainlessSteel.addMillBall(17280)
    }
}
