package material;

import static material.SuSyMaterials.*;
import static globals.Globals.*;

import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.fluids.store.FluidStorage;
import gregtech.api.unification.material.properties.*
import gregtech.api.GTValues;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;
import gregtech.api.unification.material.properties.BlastProperty.GasTier;
import static supersymmetry.api.unification.material.info.SuSyMaterialFlags.*;
import static gregtech.api.fluids.FluidConstants.*;

import supercritical.api.unification.material.properties.FissionFuelProperty;
import supercritical.api.unification.material.properties.SCPropertyKey;

public class FirstDegreeMaterialsB {
    public static void register() {

        log.infoMC('Registering First Degree Materials B!');

        Zircaloy4 = new Material.Builder(8710, SuSyUtility.susyId('zircaloy_4'))
                .ingot().liquid(new FluidBuilder().temperature(2200))
                .components(HighPurityZirconium * 18, Tin * 3, Iron * 2, Chrome)
                .color(0x566570)
                .iconSet(METALLIC)
                .flags(GENERATE_RING, GENERATE_RING, GENERATE_PLATE, GENERATE_FRAME, GENERATE_SPRING, GENERATE_BOLT_SCREW)
                .blastTemp(2200, GasTier.MID, GTValues.VA[GTValues.EV])
                .fluidPipeProperties(1500, 1500, true, true, true, false)
                .build()

        ReactorSteel = new Material.Builder(8711, SuSyUtility.susyId('reactor_steel'))
                .ingot().liquid(new FluidBuilder().temperature(1800))
                .iconSet(SHINY)
                .flags(GENERATE_DOUBLE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_BOLT_SCREW)
                .components(Iron * 113, Manganese * 10, Molybdenum * 2, Nickel * 3)
                .colorAverage()
                .blastTemp(1800, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        Inconel718 = new Material.Builder(8712, SuSyUtility.susyId('inconel_718'))
                .ingot().liquid(new FluidBuilder().temperature(1800))
                .colorAverage()
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_DOUBLE_PLATE, GENERATE_FRAME, GENERATE_SPRING, SUPERALLOY)
                .components(Nickel * 41, Iron * 19, Chrome * 20, Niobium * 3, Molybdenum * 2, Titanium, Aluminium * 2)
                .blastTemp(1800, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        SilverIndiumCadmium = new Material.Builder(8713, SuSyUtility.susyId('silver_indium_cadmium'))
                .ingot().liquid(new FluidBuilder().temperature(1100))
                .components(Silver * 17, Indium * 3, Cadmium * 1)
                .colorAverage()
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .blastTemp(1100, GasTier.MID, GTValues.VA[GTValues.EV])
                .build();

        MullitizedKyanite = new Material.Builder(8714, SuSyUtility.susyId('mullitized_kyanite'))
                .dust()
                .components(Aluminium * 2, Silicon * 1, Oxygen * 5)
                .color(0xb8cee0)
                .build();

        SodiumPhosphate = new Material.Builder(8715, SuSyUtility.susyId('sodium_phosphate'))
                .dust()
                .components(Sodium * 3, Phosphorus, Oxygen * 4)
                .color(0xdae69e)
                .build();

        AmmoniumAlum = new Material.Builder(8716, SuSyUtility.susyId('ammonium_alum'))
                .dust()
                .components(Aluminium * 1, Nitrogen * 1, Hydrogen * 4, Sulfur * 2, Oxygen * 8, Water * 12)
                .color(0x1673a6)
                .build(); 

        AmmoniumAlum.setFormula('(NH4)Al(SO4)2 * (H2O)12', true);
        
        PurifiedBerylliumHydroxide = new Material.Builder(8717, SuSyUtility.susyId('purified_beryllium_hydroxide')) 
                .dust()
                .iconSet(SHINY)
                .components(Beryllium, Oxygen * 2, Hydrogen * 2)
                .colorAverage()
                .build();
        
        PurifiedBerylliumHydroxide.setFormula("Be(OH)2", true);

        PurifiedBerylliumOxide = new Material.Builder(8718, SuSyUtility.susyId('purified_beryllium_oxide'))
                .dust()
                .iconSet(SHINY)
                .components(Beryllium, Oxygen)
                .colorAverage()
                .build();

        PurifiedBerylliumChloride = new Material.Builder(8719, SuSyUtility.susyId('purified_beryllium_chloride'))
                .dust().liquid(new FluidBuilder().temperature(672))
                .components(Beryllium, Chlorine * 2)
		.iconSet(SHINY)
                .colorAverage()
                .build();

        Alnico = new Material.Builder(8720, SuSyUtility.susyId('alnico'))
                .dust().ingot().liquid(new FluidBuilder().temperature(1800))
                .components(Aluminium * 5, Nickel * 4, Cobalt * 3, Copper, Iron * 11)
                .color(0xb2d8ed)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE)
                .blastTemp(1800, GasTier.LOW, 480, 200)
                .build()

        AlnicoMagnetic = new Material.Builder(8721, SuSyUtility.susyId('alnico_magnetic'))
                .ingot()
                .iconSet(MAGNETIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE, IS_MAGNETIC)
                .color(0xb2d8ed)
                .components(Alnico)
                .ingotSmeltInto(Alnico)
                .arcSmeltInto(Alnico)
                .macerateInto(Alnico)
                .build()
    }
}