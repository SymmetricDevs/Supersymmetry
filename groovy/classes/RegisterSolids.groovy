import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;


//ID 20000 - 30000 for solids
class RegisterSolids{

    public static void init() {

        log.infoMC('Registering solids')

        new Material.Builder(20000, 'fluix')
            .gem().iconSet(RUBY)
            .components(Quartzite, 4, Naquadah, 1)
            .color(0x6503b6)
            .build();


        new Material.Builder(20001, 'pig_iron')
            .ingot().dust()
            .flags(GENERATE_PLATE)
            .color(0x99918A)
            .build();


        new Material.Builder(20002, 'iron_iii_sulfate')
            .dust()
            .color(0xb09d99)
            .components(Iron, 2, Sulfur, 3, Oxygen, 12)
            .flags(DECOMPOSITION_BY_ELECTROLYZING)
            .build()
            .setFormula("Fe2(SO4)3", true);

        log.infoMC('Finished registering solids')
    }
}