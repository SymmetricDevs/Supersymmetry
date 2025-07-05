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
                .dust().ingot().liquid(new FluidBuilder().temperature(1600))
                .components(Aluminium * 5, Nickel * 4, Cobalt * 3, Copper, Iron * 11)
                .color(0xb2d8ed)
                .iconSet(METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_PLATE)
                .blastTemp(1600, GasTier.LOW, 480, 200)
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

        // TODO: add colors

        SodiumIodide = new Material.Builder(8722, SuSyUtility.susyId('sodium_iodide'))
                .dust()
                .components(Sodium, Iodine)
                .colorAverage()
                .build()
        
        SulfatedTitania = new Material.Builder(8723, SuSyUtility.susyId('sulfated_titania'))
                .dust()
                .components(Titanium * 1, Sulfur * 1, Oxygen * 6)
                .colorAverage()
                .build()
        SulfatedTitania.setFormula("TiO2/SO4²⁻", true);
                
        YttriumTrifluoride = new Material.Builder(8724, SuSyUtility.susyId('yttrium_trifluoride'))
                .dust()
                .components(Yttrium, Fluorine * 3)
                .colorAverage()
                .build()

        AluminiumNitrate = new Material.Builder(8725, SuSyUtility.susyId('aluminium_nitrate'))
                .dust()
                .components(Aluminium, Nitrogen * 3, Oxygen * 9)
                .colorAverage()
                .build()
        AluminiumNitrate.setFormula("Al(NO3)3", true);

        AluminiumNitrateSolution = new Material.Builder(8726, SuSyUtility.susyId('aluminium_nitrate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(AluminiumNitrate, Water * 3)
                .colorAverage()
                .build()

        YttriumNitrate = new Material.Builder(8727, SuSyUtility.susyId('yttrium_nitrate'))
                .dust()
                .components(Yttrium, Nitrogen * 3, Oxygen * 9)
                .colorAverage()
                .build()
        YttriumNitrate.setFormula("Y(NO3)3", true);

        YttriumNitrateSolution = new Material.Builder(8728, SuSyUtility.susyId('yttrium_nitrate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(YttriumNitrate * 2, Water * 3)
                .colorAverage()
                .build()

        NeodymiumNitrate = new Material.Builder(8729, SuSyUtility.susyId('neodymium_nitrate'))
                .dust()
                .components(Neodymium, Nitrogen * 3, Oxygen * 9)
                .colorAverage()
                .build()
        NeodymiumNitrate.setFormula("Nd(NO3)3", true);

        NeodymiumNitrateSolution = new Material.Builder(8730, SuSyUtility.susyId('neodymium_nitrate_solution'))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .components(NeodymiumNitrate * 2, Water * 3)
                .colorAverage()
                .build()

        AluminiumYttriumNeodymiumNitrateSolution = new Material.Builder(8731, SuSyUtility.susyId('aluminium_yttrium_neodymium_nitrate_solution'))
                .liquid()
                .color(0xffffff)
                .build()

        AmmoniaBicarbonate = new Material.Builder(8732, SuSyUtility.susyId('ammonia_bicarbonate'))
                .dust()
                .components(Carbon, Oxygen * 3, Nitrogen, Hydrogen * 1)
                .colorAverage()
                .build()
        AmmoniaBicarbonate.setFormula("NH4HCO3", true);
        

        AmmoniaBicarbonateSolution = new Material.Builder(8733, SuSyUtility.susyId('ammonia_bicarbonate_solution'))
                .liquid()
                .components(AmmoniaBicarbonate * 3, Water * 2)
                .colorAverage()
                .build()

        NdYagSuspensionSolution = new Material.Builder(8734, SuSyUtility.susyId('nd_yag_suspension_solution'))
                .liquid()
                .color(0xffffff)
                .build()

        // from literature, this is roughly solution of NH4AlY0.6(CO3)1.9(OH)2.0 . 8H2O
        NdYagPrecursorCake = new Material.Builder(8735, SuSyUtility.susyId('nd_yag_precursor_cake'))
                .dust()
                .color(0xffffff)
                .build()

        NdYagPrecursor = new Material.Builder(8736, SuSyUtility.susyId('nd_yag_precursor'))
                .dust()
                .color(0xffffff)
                .build()

        NdYagCeramic = new Material.Builder(8737, SuSyUtility.susyId('nd_yag_ceramic'))
                .dust()
                .flags(NO_UNIFICATION, GENERATE_ROD)
                .iconSet(SHINY)
                .components(Yttrium * 3, Aluminium * 5, Oxygen * 12)
                .color(0xffffff)
                .build()
        NdYagCeramic.setFormula("Nd:Y3Al5O12", true)

        NdYagGreenBody = new Material.Builder(8738, SuSyUtility.susyId('nd_yag_green_body'))
                .dust()
                .flags(NO_UNIFICATION, GENERATE_ROD)
                .components(NdYagCeramic)
                .color(0xffffff)
                .build()

        RawNdYag = new Material.Builder(8739, SuSyUtility.susyId('raw_nd_yag'))
                .dust()
                .components(NdYagCeramic)
                .color(0xffffff)
                .build()

    }
}