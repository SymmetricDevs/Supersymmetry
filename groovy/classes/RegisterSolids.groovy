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

    private static void generatePurifiedElement(Material material, int id, boolean generateLiquid) {
        var color = material.materialRGB;

        if (generateLiquid) {
            new Material.Builder(id, "high_purity_" + material.toString())
                    .dust().fluid()
                    .iconSet(SHINY)
                    .fluidTemp(material.getProperties().getProperty(PropertyKey.FLUID).getFluidTemperature())
                    .color(color)
                    .components(material, 1)
                    .build();
        } else {
            new Material.Builder(id, "high_purity_" + material.toString())
                    .dust()
                    .iconSet(SHINY)
                    .color(color)
                    .components(material, 1)
                    .build();
        }
    }
    
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
				
        new Material.Builder(20011, 'boric_acid')
                .dust()
                .color(0xedece8)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build()
		
	new Material.Builder(20012, 'amorphous_boron')
                .dust()
                .color(0x47464b)
                .build()
			
	new Material.Builder(20013, 'magnesium_oxide')
                .dust()
                .color(0xf5f5f5)
	        .components(Magnesium, 1, Oxygen, 1)
                .build()
		
	Material BoronTrioxide = new Material.Builder(20014, 'boron_trioxide')
                .dust()
                .color(0xdfcfc2)
                .components(Boron, 2, Oxygen, 3)
                .build()

        new Material.Builder(20015, 'methylenedianiline')
                .dust()
                .components(Carbon, 13, Hydrogen, 14, Nitrogen, 2)
                .colorAverage()
                .build()

        new Material.Builder(20016, 'methylene_diphenyl_diisocyanate')
                .dust()
                .components(Carbon, 15, Hydrogen, 10, Nitrogen, 2, Oxygen, 2)
                .colorAverage()
                .build()

        new Material.Builder(20017, 'triethylenediamine')
                .dust()
                .components(Carbon, 6, Hydrogen, 12, Nitrogen, 2)
                .colorAverage()
                .build()

        Material Polyurethane = new Material.Builder(20018, 'polyurethane')
                .polymer(1)
                .components(Carbon, 17, Hydrogen, 16, Nitrogen, 2, Oxygen, 4)
                .color(0xd1d1d1)
                .flags(GENERATE_FINE_WIRE)
                .fluidTemp(438)
                .build()

        Polyurethane.setFormula("(C15H10N2O2)(C2H6O2)", true);

        new Material.Builder(20019, 'memory_foam')
                .polymer(1)
                .flags(GENERATE_PLATE)
                .color(0xFFFFFF)
                .fluidTemp(438)
                .build()

        Material Rayon = new Material.Builder(20020, 'rayon')
                .polymer(1)
                .components(Carbon, 6, Hydrogen, 10, Oxygen, 5)
                .flags(GENERATE_FINE_WIRE)
                .color(0xaee8d9)
                .fluidTemp(438)
                .build()

        Rayon.setFormula("C6H5(OH)4OH", true);

        new Material.Builder(20021, 'alkali_cellulose')
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Sodium, 1)
                .color(0x7d6547)
                .build()

        new Material.Builder(20022, 'sodium_cellulose_xanthate')
                .dust()
                .components(Carbon, 6, Hydrogen, 9, Oxygen, 5, Carbon, 1, Sulfur, 2, Sodium, 1)
                .color(0x7d6057)
                .build()

        new Material.Builder(20200, 'pmma')
                .polymer(1)
                .color(0x72e0c9)
                .flags(GENERATE_FOIL)
                .components(Carbon, 5, Oxygen, 2, Hydrogen, 8)
                .fluidTemp(438)
                .build()

        new Material.Builder(20201, 'zinc_chloride')
                .dust().fluid()
                .components(Zinc, 1, Chlorine, 2)
                .colorAverage()
                .build()

        new Material.Builder(20202, 'polypropylene')
                .polymer(1)
                .color(0xf7f2c6)
                .flags(GENERATE_FOIL)
                .components(Carbon, 3, Hydrogen, 6)
                .fluidTemp(468)
                .build()

        new Material.Builder(20203, 'sodium_tetraborate')
                .dust()
                .components(Sodium, 2, Boron, 4, Oxygen, 7)
                .color(0xdbe7db)
                .build()
        
        new Material.Builder(20204, 'electrolytic_boron')
                .dust()
                .components(Boron, 1)
                .color(0x9bd4af)
                .build()

        generatePurifiedElement(Lithium, 22000, false)
        generatePurifiedElement(Beryllium, 22001, false)
        generatePurifiedElement(Boron, 22002, false)
        generatePurifiedElement(Carbon, 22003, false)
        generatePurifiedElement(Sodium, 22004, false)
        generatePurifiedElement(Magnesium, 22005, false)
        generatePurifiedElement(Aluminium, 22006, false)
        generatePurifiedElement(Silicon, 22007, true)
        generatePurifiedElement(Phosphorus, 22008, false)
        generatePurifiedElement(Sulfur, 22009, false)
        generatePurifiedElement(Potassium, 22010, false)
        generatePurifiedElement(Calcium, 22011, false)
        generatePurifiedElement(Scandium, 22012, false)
        generatePurifiedElement(Titanium, 22013, false)
        generatePurifiedElement(Vanadium, 22014, false)
        generatePurifiedElement(Chrome, 22015, false)
        generatePurifiedElement(Manganese, 22016, false)
        generatePurifiedElement(Iron, 22017, false)
        generatePurifiedElement(Cobalt, 22018, false)
        generatePurifiedElement(Nickel, 22019, false)
        generatePurifiedElement(Copper, 22020, false)
        generatePurifiedElement(Zinc, 22021, false)
        generatePurifiedElement(Gallium, 22022, false)
        generatePurifiedElement(Germanium, 22023, false)
        generatePurifiedElement(Arsenic, 22024, false)
        generatePurifiedElement(Selenium, 22025, false)
        generatePurifiedElement(Rubidium, 22026, false)
        generatePurifiedElement(Strontium, 22027, false)
        generatePurifiedElement(Yttrium, 22028, false)
        generatePurifiedElement(Zirconium, 22029, false)
        generatePurifiedElement(Niobium, 22030, false)
        generatePurifiedElement(Molybdenum, 22031, false)
        generatePurifiedElement(Technetium, 22032, false)
        generatePurifiedElement(Ruthenium, 22033, false)
        generatePurifiedElement(Rhodium, 22034, false)
        generatePurifiedElement(Palladium, 22035, false)
        generatePurifiedElement(Silver, 22036, false)
        generatePurifiedElement(Cadmium, 22037, false)
        generatePurifiedElement(Indium, 22038, false)
        generatePurifiedElement(Tin, 22039, false)
        generatePurifiedElement(Antimony, 22040, false)
        generatePurifiedElement(Tellurium, 22041, false)
        generatePurifiedElement(Iodine, 22042, false)
        generatePurifiedElement(Caesium, 22043, false)
        generatePurifiedElement(Barium, 22044, false)
        generatePurifiedElement(Lanthanum, 22045, false)
        generatePurifiedElement(Hafnium, 22046, false)
        generatePurifiedElement(Tantalum, 22047, false)
        generatePurifiedElement(Tungsten, 22048, false)
        generatePurifiedElement(Rhenium, 22049, false)
        generatePurifiedElement(Osmium, 22050, false)
        generatePurifiedElement(Iridium, 22051, false)
        generatePurifiedElement(Platinum, 22052, false)
        generatePurifiedElement(Gold, 22053, false)
        generatePurifiedElement(Thallium, 22054, false)
        generatePurifiedElement(Lead, 22055, false)
        generatePurifiedElement(Bismuth, 22056, false)
        generatePurifiedElement(Cerium, 22057, false)
        generatePurifiedElement(Praseodymium, 22058, false)
        generatePurifiedElement(Neodymium, 22059, false)
        generatePurifiedElement(Samarium, 22060, false)
        generatePurifiedElement(Europium, 22061, false)
        generatePurifiedElement(Gadolinium, 22062, false)
        generatePurifiedElement(Terbium, 22063, false)
        generatePurifiedElement(Dysprosium, 2164, false)
        generatePurifiedElement(Holmium, 22065, false)
        generatePurifiedElement(Erbium, 22066, false)
        generatePurifiedElement(Thulium, 22067, false)
        generatePurifiedElement(Ytterbium, 22068, false)
        generatePurifiedElement(Lutetium, 22069, false)
        generatePurifiedElement(Thorium, 22070, false)

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

        new Material.Builder(32049, 'boron_carbide')
                .dust()
                .components(Boron, 4, Carbon, 1)
                .flags(GENERATE_ROD)
                .colorAverage()
                .build()
        
        new Material.Builder(32054, 'silver_chloride')
                .dust()
                .components(Silver, 1, Chlorine, 1)
                .colorAverage()
                .build()

        new Material.Builder(32055, 'arsenic_iii_sulfide')
                .dust()
                .components(Arsenic, 2, Sulfur, 3)
                .colorAverage()
                .build()

        new Material.Builder(32056, 'sodium_arsenide')
                .dust()
                .components(Sodium, 3, Arsenic, 1)
                .colorAverage()
                .build()

        new Material.Builder(32057, 'arsenic_v_sulfide')
                .dust()
                .components(Arsenic, 2, Sulfur, 5)
                .colorAverage()
                .build()
                
        new Material.Builder(32058, 'copper_sulfate')
                .dust()
                .components(Copper, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build()

        //ROASTED ORES ID: 32500-32600

        new Material.Builder(32500, 'roasted_sperrylite')
                .dust()
                .components(Platinum, 1)
                .color(0x3b1754)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(SAND)
                .build();

        //ORE LEACH RESIDUE ID: 32600-32700

        new Material.Builder(32600, 'enargite_residue')
                .dust()
                .components(Copper, 2, Sulfur, 1)
                .color(0x59183c)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(BRIGHT)
                .build()
                .setFormula("(?)Cu2S", true);
        
        log.infoMC('Finished registering solids')
    }
}
