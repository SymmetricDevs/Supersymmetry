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

        log.infoMC("Finished modifying flags")
    }
}