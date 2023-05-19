import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//ID 30000 - 30500 for ores
class RegisterOres{

    public static Material Sperrylite;
    public static Material Enargite;
    public static Material Proustite;
    public static Material Arsenopyrite;

    public static void init() {

        log.infoMC('Registering ores')

        Enargite = new Material.Builder(30000, "enargite")
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

/*        new Material.Builder(30003, "dolomite")
                .ore()
                .components(Calcium, 1, Magnesium, 1, Carbon, 3, Oxygen, 6)
                .colorAverage()
                .build();
*/ 
// Dolomite will be a normal stone, not this 

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
                .build();

        new Material.Builder(30010, "lignite")
                .gem(1, 1200).ore(2, 1)
                .color(0x644646).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        new Material.Builder(30011, "anthracite")
                .gem(1, 2000).ore(2, 1)
                .color(0x241212).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        new Material.Builder(30012, "anglesite")
                .ore()
                .addOreByproducts(Galena)
                .components(Lead, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();
				
        new Material.Builder(30013, "celestine")
                .ore()
                .components(Strontium, 1, Sulfur, 1, Oxygen, 4)
                .color(0xC8D4D4)
                .build();

        new Material.Builder(30014, "azurite")
                .ore()
                .components(Copper, 3, Carbon, 2, Oxygen, 8, Hydrogen, 2)
                .color(0x161446)
                .build()
                .setFormula("Cu3(CO3)2(OH)2", true);

        new Material.Builder(30015, "hydrozincite")
                .ore()
                .components(Zinc, 5, Carbon, 2, Oxygen, 12, Hydrogen, 6)
                .colorAverage()
                .build()
                .setFormula("Zn5(CO3)2(OH)6", true);

        new Material.Builder(30016, "cerussite")
                .ore()
                .components(Lead, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        Proustite = new Material.Builder(30017, "proustite")
                .ore()
                .components(Silver, 3, Arsenic, 1, Sulfur, 3)
                .colorAverage()
                .build();

        new Material.Builder(30018, "stephanite")
                .ore()
                .components(Silver, 5, Antimony, 1, Sulfur, 4)
                .colorAverage()
                .build();

        Arsenopyrite = new Material.Builder(30019, "arsenopyrite")
                .ore()
                .addOreByproducts(Pyrite)
                .components(Iron, 1, Arsenic, 1, Sulfur, 1)
                .colorAverage()
                .build();

        Sperrylite = new Material.Builder(30020, "sperrylite")
                .ore()
                .components(Platinum, 1, Arsenic, 2)
                .colorAverage()
                .build();

        new Material.Builder(30021, "smithsonite")
                .ore()
                .components(Zinc, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        new Material.Builder(30022, "acanthite")
                .ore()
                .components(Silver, 2, Sulfur, 1)
                .colorAverage()
                .build();

        new Material.Builder(30023, "thortveitite")
                .ore()
                .components(Scandium, 1, Yttrium, 1, Silicon, 2, Oxygen, 7)
                .colorAverage()
                .build()
                .setFormula("ScY2Si2O7", true);

        log.infoMC('Finished registering ores')

    }

}