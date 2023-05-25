import net.minecraftforge.fml.common.eventhandler.EventPriority

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.*;

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
        Tantalum.addFlags("generate_rod");
        Tantalum.addFlags("generate_catalyst_bed");
        ChromiumTrioxide.addFlags("generate_catalyst_bed");
        Iron3Chloride.addFlags("generate_catalyst_bed");
      
		Borax.setProperty(PropertyKey.ORE, new OreProperty());

        ManganesePhosphide.addFlags("generate_fine_wire");
        UraniumTriplatinum.addFlags("generate_fine_wire");
        RutheniumTriniumAmericiumNeutronate.addFlags("generate_fine_wire");

        Silver.setProperty(PropertyKey.FLUID_PIPE, new FluidPipeProperties(1234, 50, false, false, true, false));

        log.infoMC("Finished modifying flags")
    }
}