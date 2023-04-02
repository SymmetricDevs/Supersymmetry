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

        GregTechAPI.MaterialRegistry.get("fluix").addFlags("disable_decomposition", "generate_plate", "generate_lens")

        //Iodine.dust().build();
        //Hafnium.ingot().build();
        //Strontium.ingot().build();

        log.infoMC("Finished modifying flags")
    }
}