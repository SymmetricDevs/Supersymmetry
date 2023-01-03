import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.properties.*;

eventManager.listen {
    GregTechAPI.MaterialEvent event ->

        println("Running ChangeFlags.groovy...")
        println("Groovy starting modifying flags")

        Steel.addFlags("generate_spring", "generate_spring_small");
        Titanium.addFlags("generate_foil", "generate_spring", "generate_spring_small");
        Lead.addFlags("generate_round");
        Aluminium.addFlags("generate_round");

        Iodine.dust().build();
        Hafnium.ingot().build();
        Strontium.ingot().build();

        println("Groovy finished modifying flags")
}