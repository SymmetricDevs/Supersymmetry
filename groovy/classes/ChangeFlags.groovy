import net.minecraftforge.fml.common.eventhandler.EventPriority

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.*;
import gregtech.api.unification.material.properties.OreProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import static material.SuSyMaterials.*

//eventManager.listen(EventPriority.LOWEST) 
class ChangeFlags {
    public static void init() {
    //GregTechAPI.MaterialEvent event ->

        log.infoMC("Modifying flags...")

        Steel.addFlags("generate_spring", "generate_spring_small");
        Titanium.addFlags("generate_foil", "generate_spring", "generate_spring_small");
        Lead.addFlags("generate_round");
        Aluminium.addFlags("generate_round");
        Nickel.addFlags("generate_rod");
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
      
		Borax.setProperty(PropertyKey.ORE, new OreProperty());
        DilutedHydrochloricAcid.setFormula("(H2O)2(HCl)", true);

        ManganesePhosphide.addFlags("generate_fine_wire");
        UraniumTriplatinum.addFlags("generate_fine_wire");
        RutheniumTriniumAmericiumNeutronate.addFlags("generate_fine_wire");

        Silver.setProperty(PropertyKey.FLUID_PIPE, new FluidPipeProperties(1234, 50, false, false, true, false));

        Chlorine.setProperty(PropertyKey.PLASMA, new PlasmaProperty());

        Polydimethylsiloxane.setProperty(PropertyKey.FLUID, new FluidProperty());

        OreProperty oreProp = Petalite.getProperty(PropertyKey.ORE);
        oreProp.setOreByProducts(PegmatiteTailings, PegmatiteTailings, PegmatiteTailings, PegmatiteTailings);

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

        log.infoMC("Finished modifying flags")
    }
}