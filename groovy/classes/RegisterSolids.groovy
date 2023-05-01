import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.properties.*;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;


//ID 20000 - 30000 for solids
class RegisterSolids {

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

        new Material.Builder(20003, "green_coke")
                .gem(1, 2000).ore(2, 1)
                .color(0x424a34).iconSet(LIGNITE)
                .components(Carbon, 1)
                .flags(FLAMMABLE, NO_SMELTING, NO_SMASHING, MORTAR_GRINDABLE)
                .build();

        new Material.Builder(20004, "asphalt")
                .dust()
                .color(0x000000)
                .build();

        new Material.Builder(20002, 'iron_iii_sulfate')
            .dust()
            .color(0xb09d99)
            .components(Iron, 2, Sulfur, 3, Oxygen, 12)
            .flags(DECOMPOSITION_BY_ELECTROLYZING)
            .build()
            .setFormula("Fe2(SO4)3", true);

        Material AluminiumHydroxide = new Material.Builder(20005, 'aluminium_hydroxide')
                .dust()
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .colorAverage()
                .build()

        AluminiumHydroxide.setFormula("Al(OH)3", true);

        new Material.Builder(20006, 'aluminium_trifluoride')
                .dust()
                .components(Aluminium, 1, Fluorine, 3)
                .color(0x3d98bf)
                .build()

        new Material.Builder(20007, 'gallium_phosphate')
                .gem().iconSet(RUBY)
                .components(Gallium, 1, Phosphorus, 1, Oxygen, 4)
                .colorAverage()
                .build()

        new Material.Builder(20008, 'lithium_niobate')
                .gem().iconSet(RUBY)
                .components(Lithium, 1, Niobium, 1, Oxygen, 3)
                .colorAverage()
                .build()

        new Material.Builder(20009, 'lead_zirconate_titanate')
                .gem().iconSet(RUBY)
                .components(Lead, 2, Zirconium, 1, Titanium, 1, Oxygen, 6)
                .colorAverage()
                .build()

        new Material.Builder(20010, 'polyvinylidene_fluoride')
                .polymer(1)
                .color(0xfde3ff)
                .flags(GENERATE_FOIL)
                .components(Carbon, 2, Hydrogen, 2, Fluorine, 2)
                .fluidTemp(468)
                .build()

        new Material.Builder(32003, 'calcium_sulfate')
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        new Material.Builder(32004, 'iron_ii_sulfide')
                .dust()
                .components(Iron, 1, Sulfur, 1)
                .colorAverage()
                .build();

        new Material.Builder(32006, 'potassium_sulfate')
                .dust()
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        new Material.Builder(32007, 'wet_antimony_trifluoride')
                .dust()
                .components(Antimony, 1, Fluorine, 3)
                .colorAverage()
                .build();

        new Material.Builder(32008, 'black_ash')
                .dust()
                .color(0x000000)
                .colorAverage()
                .build();

        new Material.Builder(32010, 'calcium_sulfide')
                .dust()
                .components(Calcium, 1, Sulfur, 1)
                .colorAverage()
                .build();

        new Material.Builder(32012, 'calcium_sulfate')
                .dust()
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        new Material.Builder(32017, 'vanadium_pentoxide')
                .dust()
                .components(Vanadium, 2, Oxygen, 5)
                .colorAverage()
                .build();

        new Material.Builder(32018, 'phthalic_anhydride')
                .dust()
                .components(Carbon, 8, Hydrogen, 4, Oxygen, 3)
                .colorAverage()
                .build();

        new Material.Builder(32023, 'impure_caprolactam')
                .dust()
                .color(0x242119)
                .build();

        new Material.Builder(32025, 'nitrate_salt_mix')
                .dust()
                .components(AmmoniumChloride, 1, Saltpeter, 1)
                .colorAverage()
                .build();

        new Material.Builder(32027, 'potassium_persulfate')
                .dust()
                .components(Potassium, 2, Sulfur, 2, Oxygen, 8)
                .colorAverage()
                .build();

        new Material.Builder(32030, 'lithium_hydroxide')
                .dust()
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .colorAverage()
                .build();

        new Material.Builder(32031, 'molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x737373)
                .colorAverage()
                .build();

        new Material.Builder(32032, 'wet_molecular_sieve')
                .dust()
                .iconSet(SHINY)
                .color(0x5c5c5c)
                .colorAverage()
                .build();

        new Material.Builder(32038, 'calcium_carbide')
                .dust()
                .components(Calcium, 1, Carbon, 2)
                .colorAverage()
                .build();

        new Material.Builder(32039, 'iron_ii_chloride')
                .dust()
                .components(Iron, 1, Chlorine, 2)
                .color(0x9dad37)
                .build()

        new Material.Builder(32040, 'cuprous_oxide')
                .dust()
                .components(Copper, 2, Oxygen, 1)
                .color(0x822635)
                .build()

        new Material.Builder(32041, 'lithium_bromide')
                .dust()
                .components(Lithium, 1, Bromine, 1)
                .color(0xC5C5C5)
                .build()

        new Material.Builder(32042, 'iron_iii_oxide')
                .dust()
                .components(Iron, 2, Oxygen, 3)
                .flags(GENERATE_CATALYST_BED)
                .color(0x8F0C03)
                .build()

        new Material.Builder(32043, 'copper_ii_chloride')
                .dust()
                .components(Copper, 1, Chlorine, 2)
                .flags(GENERATE_CATALYST_BED)
                .color(0x12112c)
                .build()

        new Material.Builder(32044, 'silicon_carbide')
                .dust()
                .components(Silicon, 1, Carbon, 1)
                .color(0x404040)
                .build()

        new Material.Builder(32045, 'tungsten_trioxide')
                .dust()
                .components(Tungsten, 1, Oxygen, 3)
                .color(0x8a9734)
                .build()

        new Material.Builder(32047, 'alumina')
                .dust()
                .components(Aluminium, 2, Oxygen, 3)
                .color(0xd0cff7)
                .build()
        
        log.infoMC('Finished registering solids')
    }
}