import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//IDs 31000-32000 RESERVED FOR ELEMENTS

eventManager.listen {
    GregTechAPI.MaterialEvent event ->

        println("Running RegisterElements.groovy...")
        println("Groovy starting modifying isotopes")

        def mystery = new Material.Builder(32000, "mystery")
                .dust()
                .color(0x141414)
                .build();

        mystery.setFormula("?", false);

        println("Groovy finished modifying isotopes")
}