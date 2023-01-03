import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//IDs 30000-30500 RESERVED FOR ORES

eventManager.listen {
    GregTechAPI.MaterialEvent event ->

        println("Running RegisterOres.groovy...")

        println("Groovy starting modifying ores")

        new Material.Builder(30000, "enargite")
                .ore()
                .addOreByproducts(Pyrite, Sphalerite)
                .components(Copper, 3, Arsenic, 1, Sulfur, 4)
                .colorAverage()
                .build();

        new Material.Builder(30002, "tenorite")
                .ore()
                .addOreByproducts(Malachite, Manganese)
                .components(Copper, 1, Oxygen, 1)
                .colorAverage()
                .build();

        new Material.Builder(30003, "dolomite")
                .ore()
                .components(Calcium, 1, Magnesium, 1, Carbon, 3, Oxygen, 6)
                .colorAverage()
                .build();

        new Material.Builder(30004, "fluorapatite")
                .ore()
                .addOreByproducts(TricalciumPhosphate)
                .components(Calcium, 5, Phosphorus, 3, Oxygen, 12, Fluorine, 1)
                .colorAverage()
                .build();

        new Material.Builder(30005, "precious_metal")
                .ore()
                .color(0xdbd821)
                .build();

        new Material.Builder(30006, "kaolinite")
                .ore()
                .components(Aluminium, 2, Silicon, 2, Oxygen, 9, Hydrogen, 4)
                .colorAverage()
                .build();

        new Material.Builder(30008, "cuprite")
                .ore()
                .components(Copper, 2, Oxygen, 1)
                .colorAverage()
                .build();

        new Material.Builder(30009, "dilithium")
                .gem().ore()
                .components(Lithium, 2)
                .flags(DISABLE_DECOMPOSITION)
                .colorAverage()
                .iconSet(SHINY)
                .build();

        println("Groovy finished modifying ores")
}