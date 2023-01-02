import gregtech.api.unification.material.Material;
import gregtech.api.GregTechAPI;
import gregtech.api.fluids.fluidType.FluidTypes;
import static gregtech.api.unification.material.info.MaterialIconSet.*;

import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.Materials.*;

//IDs 20000-30000+ RESERVED FOR SOLIDS

eventManager.listen {
    GregTechAPI.MaterialEvent event ->

        new Material.Builder(20000, "zircon")
                .dust()
                .components(Zirconium, 1, Silicon, 1, Oxygen, 4)
                .iconSet(SHINY)
                .build();

        new Material.Builder(20001, "witherite")
                .dust()
                .components(Barium, 1, Carbon, 1, Oxygen, 3)
                .colorAverage()
                .build();

        new Material.Builder(22000, "copper_oxide")
                .dust()
                .components(Copper, 1, Oxygen, 1)
                .colorAverage()
                .build();

        new Material.Builder(22001, "hafnium_oxide")
                .dust()
                .components(Hafnium, 1, Oxygen, 2)
                .colorAverage()
                .build();

        new Material.Builder(22002, "strontium_chloride")
                .dust()
                .components(Strontium, 1, Chlorine, 2)
                .colorAverage()
                .build();

        new Material.Builder(22003, "barium_nitrate")
                .dust()
                .components(Barium, 1, Nitrogen, 2, Oxygen, 6)
                .colorAverage()
                .build();

        new Material.Builder(22004, "barium_oxide")
                .dust()
                .components(Barium, 1, Oxygen, 1)
                .colorAverage()
                .build();

        new Material.Builder(22005, "manganese_oxide")
                .dust()
                .ingot()
                .components(Manganese, 1, Oxygen, 1)
                .colorAverage()
                .build();

        new Material.Builder(22006, "manganese_dioxide")
                .dust()
                .ingot()
                .components(Manganese, 1, Oxygen, 2)
                .colorAverage()
                .build();

        new Material.Builder(22007, "alugentum")
                .dust()
                .components(Aluminium, 4, Silver, 1)
                .colorAverage()
                .build();

        new Material.Builder(22008, "calcium_sulfate")
                .dust()
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Sulfur, 1, Oxygen, 4)
                .colorAverage()
                .build();

        new Material.Builder(22009, "sodium_fluoride")
                .dust()
                .components(Sodium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        new Material.Builder(22010, "potassium_fluoride")
                .dust()
                .components(Potassium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        new Material.Builder(22011, "fluorite")
                .dust()
                .fluid()
                .components(Calcium, 1, Fluorine, 2)
                .colorAverage()
                .build();

        new Material.Builder(22012, "villiaumite")
                .dust()
                .fluid()
                .components(Sodium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        new Material.Builder(22013, "carobbiite")
                .dust()
                .fluid()
                .components(Potassium, 1, Fluorine, 1)
                .colorAverage()
                .build();

        new Material.Builder(23000, "bscco")
                .dust()
                .components(Copper, 3, Bismuth, 2, Strontium, 2, Calcium, 2, Oxygen, 11)
                .colorAverage()
                .build();

        new Material.Builder(23001, "titanium_aluminide")
                .ingot()
                .components(Titanium, 1, Aluminium, 1)
                .colorAverage()
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_FOIL)
                .build();

        new Material.Builder(23002, "titanium_iridium")
                .ingot()
                .components(Titanium, 1, Iridium, 1)
                .colorAverage()
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_GEAR, GENERATE_FOIL)
                .build();

        new Material.Builder(23003, "lithium_6_deuteride")
                .ingot()
                .components(Lithium6, 1, Deuterium, 1)
                .colorAverage()
                .build();

        new Material.Builder(23004, "zirconium_molybdenum")
                .ingot()
                .iconSet(SHINY)
                .components(Zirconium, 1, Molybdenum, 1)
                .colorAverage()
                .build();

        new Material.Builder(23005, "niobium_tin")
                .ingot()
                .components(Niobium, 3, Tin, 1)
                .colorAverage()
                .build();

        new Material.Builder(23006, "super_alloy")
                .ingot()
                .components(Nichrome, 2, NiobiumTitanium, 1)
                .colorAverage()
                .build();

        new Material.Builder(23007, "hafnium_carbide")
                .dust()
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Hafnium, 1, Carbon, 1)
                .colorAverage()
                .build();

        new Material.Builder(23008, "zircaloy")
                .dust()
                .fluid()
                .ingot()
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Zirconium, 16, Niobium, 1, Tin, 1, Chrome, 1, Nickel, 1)
                .colorAverage()
                .build();

        new Material.Builder(23009, "ferroboron")
                .ingot()
                .components(Steel, 1, Boron, 1)
                .colorAverage()
                .build();

        new Material.Builder(23010, "tough")
                .ingot()
                .components(Ferroboron, 1, Lithium, 1)
                .colorAverage()
                .build();

        new Material.Builder(23011, "hard_carbon")
                .ingot()
                .components(Carbon, 1)
                .colorAverage()
                .build();

        new Material.Builder(23012, "lithium_manganese_dioxide")
                .ingot()
                .components(Lithium, 1, Manganese, 1, Oxygen, 2)
                .colorAverage()
                .build();

        new Material.Builder(23013, "shibuichi")
                .ingot()
                .components(Copper, 3, Silver, 1)
                .colorAverage()
                .build();

        new Material.Builder(23014, "tin_silver")
                .ingot()
                .components(Tin, 3, Silver, 1)
                .colorAverage()
                .build();

        new Material.Builder(23015, "lead_platinum")
                .ingot()
                .components(Lead, 3, Platinum, 1)
                .colorAverage()
                .build();

        new Material.Builder(23016, "thermoconducting")
                .ingot()
                .components(Boron, 1, Arsenic, 1)
                .colorAverage()
                .build();

        new Material.Builder(23017, "carbon_manganese")
                .dust()
                .components(Carbon, 1, Manganese, 1)
                .colorAverage()
                .build();

        new Material.Builder(23018, "energetic")
                .dust()
                .components(Redstone, 1, Glowstone, 1)
                .colorAverage()
                .build();

        new Material.Builder(23019, "dimensional")
                .dust()
                .components(Obsidian, 4, Endstone, 1)
                .colorAverage()
                .build();

        new Material.Builder(23020, "extreme")
                .dust()
                .fluid()
                .ingot()
                .fluidTemp(4120)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME, GENERATE_LONG_ROD, GENERATE_RING, GENERATE_ROUND, GENERATE_SCREW)
                .components(HafniumCarbide, 4, Rhenium, 1, TantalumCarbide, 4, HastelloyX, 16)
                .colorAverage()
                .build();

        new Material.Builder(23021, "vacuumsteel")
                .ingot()
                .color(0xC8C8DC)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_BOLT_SCREW, GENERATE_FRAME, EXCLUDE_BLOCK_CRAFTING_RECIPES, EXCLUSE_PLATE_COMPRESSOR_RECIPES, EXCLUSE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .build();

        println("Groovy finished modifying solids")
}