package classes

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
import supersymmetry.api.unification.material.properties.FiberProperty
import supersymmetry.api.unification.material.properties.SuSyPropertyKey

import static gregtech.api.unification.material.Materials.*
import static gregtech.api.unification.material.info.MaterialFlags.*
import static material.SuSyMaterials.*

//eventManager.listen(EventPriority.LOWEST)
class ChangeFlags {
	private static void setupSlurries(Material mat) {
		def property = new FluidProperty()
		property.enqueueRegistration(SusyFluidStorageKeys.SLURRY, new FluidBuilder())
		property.enqueueRegistration(SusyFluidStorageKeys.IMPURE_SLURRY, new FluidBuilder())

		mat.setProperty(PropertyKey.FLUID, property)
	}
	
	private static void setupFluidType(Material mat, FluidStorageKey key, int temp) {
        if (mat.getProperty(PropertyKey.FLUID) == null) {
            def property = new FluidProperty();
		    property.enqueueRegistration(key, new FluidBuilder().temperature(temp))
		    mat.setProperty(PropertyKey.FLUID, property)
        } else {
            def property = mat.getProperty(PropertyKey.FLUID)
            if (property.getQueuedBuilder(key) != null) {
                property.getQueuedBuilder(key).temperature(temp)
            } else {
                property.enqueueRegistration(key, new FluidBuilder().temperature(temp))
            }
        }
	}
	private static void setupFluidType(Material mat, FluidStorageKey key) {
        if (mat.getProperty(PropertyKey.FLUID) == null) {
            def property = new FluidProperty();
		    property.enqueueRegistration(key, new FluidBuilder())
		    mat.setProperty(PropertyKey.FLUID, property)
        } else {
            def property = mat.getProperty(PropertyKey.FLUID)
		    property.enqueueRegistration(key, new FluidBuilder())
        }
	}

    public static void init() {
    //MaterialEvent event ->

        log.infoMC("Modifying flags...")

        RecipeMaps.BLAST_RECIPES.setMaxFluidInputs(2);
        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.setMaxFluidInputs(3);
        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.setMaxInputs(12);

        // Properties

        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Tellurium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Cadmium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Asbestos.setProperty(PropertyKey.INGOT, new IngotProperty());

        BisphenolA.setProperty(PropertyKey.DUST, new DustProperty());

        Silver.setProperty(PropertyKey.FLUID_PIPE, new FluidPipeProperties(1234, 50, false, false, true, false));
        
        setupFluidType(AntimonyTrifluoride, FluidStorageKeys.LIQUID, 565)
        setupFluidType(LithiumChloride, FluidStorageKeys.LIQUID, 890)
        setupFluidType(SiliconDioxide, FluidStorageKeys.LIQUID, 1986)
        setupFluidType(Caesium, FluidStorageKeys.LIQUID, 302)
        setupFluidType(Cadmium, FluidStorageKeys.LIQUID, 600)
        setupFluidType(BisphenolA, FluidStorageKeys.LIQUID, 428)
        setupFluidType(Iodine, FluidStorageKeys.GAS, 460)
        setupFluidType(Chlorine, FluidStorageKeys.PLASMA)
        setupFluidType(Selenium, FluidStorageKeys.LIQUID, 494)
        //setupFluidType(Iron3Chloride, FluidStorageKeys.GAS, 590) 

        setupFluidType(CarbonDioxide, SusyFluidStorageKeys.SUPERCRITICAL, 304)
        setupFluidType(Propane, SusyFluidStorageKeys.SUPERCRITICAL, 370)

        Polybenzimidazole.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, true))
        Polytetrafluoroethylene.setProperty(SuSyPropertyKey.FIBER, new FiberProperty(false, true, false))
        Polydimethylsiloxane.setProperty(PropertyKey.FLUID, new FluidProperty(FluidStorageKeys.LIQUID, new FluidBuilder()));

        Tantalum.setProperty(PropertyKey.BLAST, new BlastProperty(3293, GasTier.MID, 480, 240, -1, -1));
        Molybdenum.setProperty(PropertyKey.BLAST, new BlastProperty(2890, GasTier.MID, 480, 240, -1, -1));
        Platinum.setProperty(PropertyKey.BLAST, new BlastProperty(2045, GasTier.LOW, 480, 240, -1, -1));
        Thorium.setProperty(PropertyKey.BLAST, new BlastProperty(2028, GasTier.LOW, 480, 240, -1, -1));
        Cobalt.setProperty(PropertyKey.BLAST, new BlastProperty(1750, GasTier.LOW, 120, 200, -1, -1));
        Beryllium.setProperty(PropertyKey.BLAST, new BlastProperty(1560, GasTier.LOW, 120, 200, -1, -1));
        Nickel.setProperty(PropertyKey.BLAST, new BlastProperty(1728, GasTier.LOW, 120, 120, -1, -1));

        // Supercons, max amps multiplied by 4.
        ManganesePhosphide.getProperty(PropertyKey.WIRE).setAmperage(8);
        MagnesiumDiboride.getProperty(PropertyKey.WIRE).setAmperage(16);
        MercuryBariumCalciumCuprate.getProperty(PropertyKey.WIRE).setAmperage(16);
        UraniumTriplatinum.getProperty(PropertyKey.WIRE).setAmperage(24);
        SamariumIronArsenicOxide.getProperty(PropertyKey.WIRE).setAmperage(24);
        IndiumTinBariumTitaniumCuprate.getProperty(PropertyKey.WIRE).setAmperage(32);
        UraniumRhodiumDinaquadide.getProperty(PropertyKey.WIRE).setAmperage(32);
        EnrichedNaquadahTriniumEuropiumDuranide.getProperty(PropertyKey.WIRE).setAmperage(64);
        RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE).setAmperage(96);

        // Allow PE & PTFE to carry acidic/cyro fluids. Used in plastic cans
        Polyethylene.getProperty(PropertyKey.FLUID_PIPE).setCryoProof(true);
        Polyethylene.getProperty(PropertyKey.FLUID_PIPE).setCanContain(FluidAttributes.ACID, true);
        Polytetrafluoroethylene.getProperty(PropertyKey.FLUID_PIPE).setCryoProof(true);

        // Flags

        Asbestos.addFlags("generate_foil");
        Tellurium.addFlags("generate_plate");
        Steel.addFlags("generate_spring", "generate_spring_small");
        Titanium.addFlags("generate_foil", "generate_spring", "generate_spring_small");
        Lead.addFlags("generate_round");
        Nickel.addFlags("generate_rod", "generate_foil");
        Aluminium.addFlags("generate_round", "generate_rotor");
        Tungsten.addFlags("generate_fine_wire");
        Molybdenum.addFlags("generate_fine_wire");
        Tantalum.addFlags("generate_rod");
        Tantalum.addFlags("generate_fine_wire");
        Titanium.addFlags("generate_fine_wire");
        Tantalum.addFlags("generate_catalyst_bed");
        ChromiumTrioxide.addFlags("generate_catalyst_bed");
        Iron3Chloride.addFlags("generate_catalyst_bed");
        Platinum.addFlags("generate_catalyst_bed");
        Alumina.addFlags("generate_catalyst_bed");
        Silver.addFlags("generate_catalyst_bed");
        Nickel.addFlags("generate_catalyst_bed");
        Magnesia.addFlags("generate_catalyst_bed");
        Brass.addFlags("generate_ring");
        Indium.addFlags("generate_plate");
        BisphenolA.addFlags("no_unification");
        Phosphorus.addFlags("no_smelting");
        Tetrahedrite.addFlags("no_smelting");
        Gold.addFlags("generate_gear");

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

        ManganesePhosphide.addFlags("generate_fine_wire");
        UraniumTriplatinum.addFlags("generate_fine_wire");
        RutheniumTriniumAmericiumNeutronate.addFlags("generate_fine_wire");

        //Colors

        Phosphorus.setMaterialRGB(0xfffed6);

        // Formulae

        DilutedHydrochloricAcid.setFormula("(H2O)2(HCl)", true);
        DilutedSulfuricAcid.setFormula("(H2SO4)(H2O)", true);
        AquaRegia.setFormula("(HNO3)(HCl)3", true);
        Tantalite.setFormula("(Fe,Mn)Ta2O6", true);
        Lepidolite.setFormula("(K,Rb)AlLi2Si4O10(OH,F)2", true);
        Tetrahedrite.setFormula("Cu12Sb4S13", true);
        IndiumGalliumPhosphide.setFormula("InGaP2", true);
        NetherAir.setFormula("(N78O21Ar9)24(CO2)2(H2S)(SO2)", true);
        Diatomite.setFormula("(SiO2)8(Fe2O3)(Al2O3)", true);

        // Ore Processing
        
        Borax.setProperty(PropertyKey.ORE, new OreProperty());
        Scheelite.addFlags("generate_sifted", "generate_flotated");
		setupSlurries(Scheelite)
        Pyrochlore.addFlags("generate_sifted", "generate_flotated", "generate_concentrate");
		setupSlurries(Pyrochlore)
        Molybdenite.addFlags("generate_flotated");
		setupSlurries(Molybdenite)
        Tantalite.addFlags("generate_sifted", "generate_flotated", "generate_concentrate");
        setupSlurries(Tantalite)
        setupSlurries(Galena)
        setupSlurries(Stibnite)
        setupSlurries(Cinnabar)
        Ilmenite.addFlags("generate_flotated", "generate_concentrate");
        setupSlurries(Ilmenite)
        setupSlurries(Barite)
        setupSlurries(Spodumene)
        Cassiterite.addFlags("generate_concentrate");
        setupSlurries(Cassiterite)
        setupSlurries(Malachite)
        Rutile.addFlags("generate_concentrate");
        setupSlurries(Sphalerite)
        setupSlurries(Pollucite)
        setupSlurries(Arsenopyrite)

        setupFluidType(PolyvinylAcetate, FluidStorageKeys.LIQUID, 385)

        OreProperty oreProp = Petalite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Aluminium.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Beryllium.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Cobalt.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Copper.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Gold.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Iron.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Lead.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Lithium.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Molybdenum.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Neodymium.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Nickel.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Palladium.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Platinum.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Plutonium239.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Silver.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Sulfur.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Thorium.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Tin.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Naquadah.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();

        oreProp = CertusQuartz.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Almandine.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Asbestos.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = BandedIron.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = BlueTopaz.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = BrownLimonite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = YellowLimonite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Calcite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Cassiterite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = CassiteriteSand.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Chalcopyrite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Chromite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Cinnabar.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Coal.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Cobaltite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Cooperite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Diamond.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Electrum.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Emerald.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Galena.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Garnierite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = GreenSapphire.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Grossular.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Ilmenite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Bauxite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Lapis.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Magnesite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Magnetite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Molybdenite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Powellite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Scheelite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Pyrite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Pyrolusite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Pyrope.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = RockSalt.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Ruby.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Salt.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Saltpeter.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Sapphire.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Sodalite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Tantalite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Spessartine.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Sphalerite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Stibnite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Tetrahedrite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Topaz.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Tungstate.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Uraninite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Wulfenite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = NetherQuartz.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Graphite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Bornite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Chalcocite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Realgar.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Bastnasite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Pentlandite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Spodumene.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Lepidolite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = GlauconiteSand.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Malachite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Alunite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Talc.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Kyanite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Pyrochlore.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Borax.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Olivine.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Opal.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Amethyst.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Apatite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = TricalciumPhosphate.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = GarnetRed.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = GarnetYellow.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = VanadiumMagnetite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Pollucite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Pitchblende.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Bentonite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(Clay, Clay, Clay, Clay);

        oreProp = FullersEarth.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(Clay, Clay, Clay, Clay);

        oreProp = Monazite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Trona.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Gypsum.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Zeolite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Redstone.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Electrotine.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Diatomite.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = GraniticMineralSand.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = GarnetSand.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = BasalticMineralSand.getProperty(PropertyKey.ORE);
        oreProp.getOreByProducts().clear();
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Thortveitite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Titanomagnetite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = VanadiferousTitanomagnetite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Perovskite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Arsenopyrite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Smithsonite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);
        oreProp.setDirectSmeltResult(Zinc);

        oreProp = Enargite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Proustite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Celestine.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Strontianite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Acanthite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Stephanite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Pyrargyrite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Barite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Witherite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Wolframite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Sperrylite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(UltramaficTailings, UltramaficTailings, UltramaficTailings, UltramaficTailings);

        oreProp = Cerussite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Anglesite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Bismuthinite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Amblygonite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

        oreProp = Vanadinite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(LimestoneTailings, LimestoneTailings, LimestoneTailings, LimestoneTailings);

        oreProp = Carnotite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(GraniteTailings, GraniteTailings, GraniteTailings, GraniteTailings);

        oreProp = Cerussite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(Lead);

        oreProp = Anglesite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(Lead);

        oreProp = Pyrolusite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Platinum.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Molybdenum.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Molybdenite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Beryllium.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Cobaltite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Cobalt.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Thorium.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Nickel.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Pentlandite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Garnierite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Ilmenite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Powellite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Uraninite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        oreProp = Magnesite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);

        // Flammables

        Naphtha.addFlags("flammable");
        NaturalGas.addFlags("flammable");
        Methane.addFlags("flammable");
        Propane.addFlags("flammable");
        Butane.addFlags("flammable");
        Butadiene.addFlags("flammable");
        Toluene.addFlags("flammable");
        WoodGas.addFlags("flammable");
        CoalGas.addFlags("flammable");
        Ethylene.addFlags("flammable");
        RefineryGas.addFlags("flammable");
        Ammonia.addFlags("flammable");
        Propene.addFlags("flammable");
        Butene.addFlags("flammable");
        Phenol.addFlags("flammable");
        Benzene.addFlags("flammable");
        Hydrogen.addFlags("flammable");
        Methanol.addFlags("flammable");
        Ethanol.addFlags("flammable");
        log.infoMC("Finished modifying flags")
    }
}
