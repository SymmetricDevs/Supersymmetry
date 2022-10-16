import mods.gregtech.recipe.RecipeMap;

//-------------REMOVE OLD RECIPES----------------
// Monocrystalline Silicon Boule * 1
<recipemap:electric_blast_furnace>.findRecipe(120, [<metaitem:dustSilicon> * 32, <metaitem:dustSmallGalliumArsenide>], null).remove();

// Silicon Wafer * 16
<recipemap:cutter>.findRecipe(64, [<metaitem:boule.silicon>], [<liquid:lubricant> * 20]).remove();

// Silicon Wafer * 16
<recipemap:cutter>.findRecipe(64, [<metaitem:boule.silicon>], [<liquid:distilled_water> * 60]).remove();

// Silicon Wafer * 16
<recipemap:cutter>.findRecipe(64, [<metaitem:boule.silicon>], [<liquid:water> * 80]).remove();

// Plastic Circuit Board * 2
<recipemap:chemical_reactor>.findRecipe(10, [<metaitem:platePolyvinylChloride>, <metaitem:foilCopper> * 4], [<liquid:sulfuric_acid> * 250]).remove();

// Plastic Circuit Board * 8
<recipemap:chemical_reactor>.findRecipe(10, [<metaitem:platePolybenzimidazole>, <metaitem:foilCopper> * 4], [<liquid:sulfuric_acid> * 250]).remove();

// Plastic Circuit Board * 1
<recipemap:chemical_reactor>.findRecipe(10, [<metaitem:platePlastic>, <metaitem:foilCopper> * 4], [<liquid:sulfuric_acid> * 250]).remove();

// Plastic Circuit Board * 4
<recipemap:chemical_reactor>.findRecipe(10, [<metaitem:platePolytetrafluoroethylene>, <metaitem:foilCopper> * 4], [<liquid:sulfuric_acid> * 250]).remove();

// Advanced Integrated Circuit * 1
<recipemap:circuit_assembler>.findRecipe(30, [<metaitem:circuit.good_integrated> * 2, <metaitem:plate.integrated_logic_circuit> * 2, <metaitem:plate.random_access_memory> * 2, <metaitem:component.transistor> * 4, <metaitem:wireFineElectrum> * 8, <metaitem:boltAnnealedCopper> * 8], [<liquid:tin> * 144]).remove();

// Advanced Integrated Circuit * 1
<recipemap:circuit_assembler>.findRecipe(30, [<metaitem:circuit.good_integrated> * 2, <metaitem:plate.integrated_logic_circuit> * 2, <metaitem:plate.random_access_memory> * 2, <metaitem:component.transistor> * 4, <metaitem:wireFineElectrum> * 8, <metaitem:boltAnnealedCopper> * 8], [<liquid:soldering_alloy> * 72]).remove();

// Plastic Circuit Board * 1
<recipemap:chemical_reactor>.findRecipe(30, [<metaitem:board.plastic>, <metaitem:foilCopper> * 6], [<liquid:sodium_persulfate> * 500]).remove();

// Plastic Circuit Board * 1
<recipemap:chemical_reactor>.findRecipe(30, [<metaitem:board.plastic>, <metaitem:foilCopper> * 6], [<liquid:iron_iii_chloride> * 250]).remove();

// Integrated Logic Circuit Wafer * 16
<recipemap:laser_engraver>.findRecipe(7680, [<metaitem:wafer.neutronium>, <metaitem:glass_lens.red>], null).remove();

// Integrated Logic Circuit Wafer * 8
<recipemap:laser_engraver>.findRecipe(1920, [<metaitem:wafer.naquadah>, <metaitem:glass_lens.red>], null).remove();

// Integrated Logic Circuit Wafer * 4
<recipemap:laser_engraver>.findRecipe(480, [<metaitem:wafer.glowstone>, <metaitem:glass_lens.red>], null).remove();

// Integrated Logic Circuit Wafer * 1
<recipemap:laser_engraver>.findRecipe(120, [<metaitem:wafer.silicon>, <metaitem:glass_lens.red>], null).remove();

// Good Integrated Circuit * 2
<recipemap:circuit_assembler>.findRecipe(24, [<metaitem:circuit_board.good>, <metaitem:circuit.basic_integrated> * 2, <metaitem:component.resistor> * 4, <metaitem:component.diode> * 4, <metaitem:wireFineGold> * 4, <metaitem:boltSilver> * 4], [<liquid:tin> * 144]).remove();

// Good Integrated Circuit * 2
<recipemap:circuit_assembler>.findRecipe(24, [<metaitem:circuit_board.good>, <metaitem:circuit.basic_integrated> * 2, <metaitem:component.resistor> * 4, <metaitem:component.diode> * 4, <metaitem:wireFineGold> * 4, <metaitem:boltSilver> * 4], [<liquid:soldering_alloy> * 72]).remove();

// Integrated Logic Circuit * 2
<recipemap:circuit_assembler>.findRecipe(16, [<metaitem:circuit_board.basic>, <metaitem:plate.integrated_logic_circuit>, <metaitem:component.resistor> * 2, <metaitem:component.diode> * 2, <metaitem:wireFineCopper> * 2, <metaitem:boltTin> * 2], [<liquid:tin> * 144]).remove();

// Integrated Logic Circuit * 2
<recipemap:circuit_assembler>.findRecipe(16, [<metaitem:circuit_board.basic>, <metaitem:plate.integrated_logic_circuit>, <metaitem:component.resistor> * 2, <metaitem:component.diode> * 2, <metaitem:wireFineCopper> * 2, <metaitem:boltTin> * 2], [<liquid:soldering_alloy> * 72]).remove();

// Plastic Circuit Board * 1
<recipemap:large_chemical_reactor>.findRecipe(30, [<metaitem:board.plastic>, <metaitem:foilCopper> * 6], [<liquid:iron_iii_chloride> * 250]).remove();

// Plastic Circuit Board * 1
<recipemap:large_chemical_reactor>.findRecipe(30, [<metaitem:board.plastic>, <metaitem:foilCopper> * 6], [<liquid:sodium_persulfate> * 500]).remove();

// CPU Wafer * 1
<recipemap:laser_engraver>.findRecipe(120, [<metaitem:wafer.silicon>, <metaitem:glass_lens.light_blue>], null).remove();

// CPU Wafer * 4
<recipemap:laser_engraver>.findRecipe(480, [<metaitem:wafer.glowstone>, <metaitem:glass_lens.light_blue>], null).remove();

// CPU Wafer * 8
<recipemap:laser_engraver>.findRecipe(1920, [<metaitem:wafer.naquadah>, <metaitem:glass_lens.light_blue>], null).remove();

// CPU Wafer * 16
<recipemap:laser_engraver>.findRecipe(7680, [<metaitem:wafer.neutronium>, <metaitem:glass_lens.light_blue>], null).remove();

// Nano CPU Wafer * 1
<recipemap:chemical_reactor>.findRecipe(1920, [<metaitem:wafer.central_processing_unit>, <metaitem:carbon.fibers> * 16], [<liquid:glowstone> * 576]).remove();

// Nano CPU Wafer * 1
<recipemap:large_chemical_reactor>.findRecipe(1920, [<metaitem:wafer.central_processing_unit>, <metaitem:carbon.fibers> * 16], [<liquid:glowstone> * 576]).remove();

// Qubit CPU Wafer * 1
<recipemap:chemical_reactor>.findRecipe(1920, [<metaitem:wafer.nano_central_processing_unit>, <metaitem:quantumeye> * 2], [<liquid:gallium_arsenide> * 288]).remove();

// NOR Wafer * 8
<recipemap:laser_engraver>.findRecipe(7680, [<metaitem:wafer.neutronium>, <metaitem:glass_lens.pink>], null).remove();

// NOR Wafer * 4
<recipemap:laser_engraver>.findRecipe(1920, [<metaitem:wafer.naquadah>, <metaitem:glass_lens.pink>], null).remove();

// NOR Wafer * 1
<recipemap:laser_engraver>.findRecipe(480, [<metaitem:wafer.glowstone>, <metaitem:glass_lens.pink>], null).remove();

// Qubit CPU Wafer * 1
<recipemap:large_chemical_reactor>.findRecipe(1920, [<metaitem:wafer.nano_central_processing_unit>, <metaitem:quantumeye> * 2], [<liquid:gallium_arsenide> * 288]).remove();

// Qubit CPU Wafer * 1
<recipemap:chemical_reactor>.findRecipe(1920, [<metaitem:wafer.nano_central_processing_unit>, <metaitem:dustIndiumGalliumPhosphide>], [<liquid:radon> * 50]).remove();

// Qubit CPU Wafer * 1
<recipemap:large_chemical_reactor>.findRecipe(1920, [<metaitem:wafer.nano_central_processing_unit>, <metaitem:dustIndiumGalliumPhosphide>], [<liquid:radon> * 50]).remove();


//-------------ADD NEW RECIPES-------------------

//-------------SILICON PURIFICATION--------------
mixer.recipeBuilder()
.inputs([<ore:dustSilicon>])
.fluidInputs([
    <liquid:hydrofluoric_acid> * 1000,
    <liquid:ethanol> * 100
    ])
.fluidOutputs([<liquid:silicon_solution> * 1000])
.duration(100)
.EUt(20)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.notConsumable([<metaitem:emitter.mv>])
.fluidInputs([
    <liquid:silicon_solution> * 1000
    ])
.outputs([<metaitem:dustNanosilicon> * 1])
.duration(250)
.EUt(120)
.buildAndRegister();

sifter.recipeBuilder()
.inputs([<metaitem:dustNanosilicon> * 1])
.outputs([<metaitem:dustRefinedsilicon> * 1])
.duration(400)
.EUt(32)
.buildAndRegister();

//--------------SILICON BOULE------------------
ebf.recipeBuilder()
.property("temperature", 1784)
.inputs([
    <gregtech:meta_seed_crystal:99> * 1,
    <metaitem:dustRefinedsilicon> * 32
    ])
.outputs([<metaitem:boule.silicon>])
.duration(9000)
.EUt(120)
.buildAndRegister();

//--------------LITHOGRAPHY PLATE---------------
assembler.recipeBuilder()
.fluidInputs([<liquid:dye_black> * 100])
.inputs([<ore:plateGlass>])
.outputs([<contenttweaker:lithography_mask>])
.duration(600)
.EUt(24)
.buildAndRegister();


//--------------SILICON WAFERS-----------------
cutting_saw.recipeBuilder()
.fluidInputs([<liquid:lubricant> * 20])
.inputs([<metaitem:boule.silicon>])
.outputs([
    <metaitem:wafer.silicon> * 16,
    <gregtech:meta_seed_crystal:99>
    ])
.duration(400)
.EUt(64)
.buildAndRegister();

cutting_saw.recipeBuilder()
.fluidInputs([<liquid:distilled_water> * 60])
.inputs([<metaitem:boule.silicon>])
.outputs([
    <metaitem:wafer.silicon> * 16,
    <gregtech:meta_seed_crystal:99>
    ])
.duration(600)
.EUt(64)
.buildAndRegister();

cutting_saw.recipeBuilder()
.fluidInputs([<liquid:water> * 80])
.inputs([<metaitem:boule.silicon>])
.outputs([
    <metaitem:wafer.silicon> * 16,
    <gregtech:meta_seed_crystal:99>
    ])
.duration(800)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:oxygen> * 250])
.inputs([<metaitem:wafer.silicon>])
.outputs([<contenttweaker:silicon_dioxide_wafer>])
.duration(100)
.EUt(64)
.buildAndRegister();

chemical_bath.recipeBuilder()
.fluidInputs([<liquid:novolacs> * 250])
.inputs([<contenttweaker:silicon_dioxide_wafer>])
.outputs([<contenttweaker:photocoated_wafer>])
.duration(200)
.EUt(10)
.buildAndRegister();

laser_engraver.recipeBuilder()
.notConsumable([<contenttweaker:lithography_mask>])
.inputs([<contenttweaker:photocoated_wafer>])
.outputs([<contenttweaker:engraved_wafer>])
.duration(900)
.EUt(120)
.buildAndRegister();

chemical_bath.recipeBuilder()
.fluidInputs([<liquid:sulfuric_acid> * 500])
.inputs([<contenttweaker:engraved_wafer>])
.outputs([<contenttweaker:etched_wafer>])
.duration(200)
.EUt(30)
.buildAndRegister();

electrolyzer.recipeBuilder()
.fluidInputs([<liquid:copper_sulfate> * 1000])
.inputs([
    <contenttweaker:etched_wafer>,
    <ore:foilCopper> * 2
    ])
.outputs([<metaitem:wafer.integrated_logic_circuit>])
.duration(300)
.EUt(64)
.buildAndRegister();

//---------------CIRCUIT BOARDS--------------

electrolyzer.recipeBuilder()
.fluidInputs([<liquid:copper_sulfate> * 1000])
.inputs([
    <ore:platePlastic>,
    <ore:foilCopper>
    ])
.outputs([<metaitem:board.plastic>])
.duration(500)
.EUt(10)
.buildAndRegister();

chemical_bath.recipeBuilder()
.fluidInputs([<liquid:novolacs> * 250])
.inputs([<metaitem:board.plastic>])
.outputs([<contenttweaker:photocoated_board>])
.duration(200)
.EUt(10)
.buildAndRegister();

laser_engraver.recipeBuilder()
.notConsumable([<contenttweaker:lithography_mask>])
.inputs([<contenttweaker:photocoated_board>])
.outputs([<contenttweaker:engraved_board>])
.duration(900)
.EUt(120)
.buildAndRegister();

chemical_bath.recipeBuilder()
.fluidInputs([<liquid:iron_iii_chloride> * 500])
.inputs([<contenttweaker:engraved_board>])
.outputs([<metaitem:circuit_board.plastic>])
.duration(200)
.EUt(30)
.buildAndRegister();

//------------------INTEGRATED CIRCUITS-----------------

for solder in soldering_alloys {
    circuit_assembler.recipeBuilder()
    .fluidInputs([solder])
    .inputs([
        <metaitem:circuit_board.plastic>,
        <metaitem:circuit.good_integrated> * 2,
        <metaitem:plate.integrated_logic_circuit> * 2,
        <metaitem:component.transistor> * 4,
        <metaitem:wireFineElectrum> * 8,
        <metaitem:boltAnnealedCopper> * 8
        ])
    .outputs([<metaitem:circuit.advanced_integrated>])
    .duration(800)
    .EUt(30)
    .buildAndRegister();

    circuit_assembler.recipeBuilder()
    .fluidInputs([solder])
    .inputs([
        <metaitem:circuit_board.plastic>,
        <metaitem:circuit.basic_integrated> * 2,
        <metaitem:component.resistor> * 4,
        <metaitem:component.diode> * 4,
        <metaitem:wireFineGold> * 4,
        <metaitem:boltSilver> * 4
        ])
    .outputs([<metaitem:circuit.good_integrated> * 2])
    .duration(400)
    .EUt(24)
    .buildAndRegister();

    circuit_assembler.recipeBuilder()
    .fluidInputs([solder])
    .inputs([
        <metaitem:circuit_board.plastic>,
        <metaitem:plate.integrated_logic_circuit>,
        <metaitem:component.resistor> * 2,
        <metaitem:component.diode> * 2,
        <metaitem:wireFineCopper> * 2,
        <metaitem:boltTin> * 2
        ])
    .outputs([<metaitem:circuit.basic_integrated> * 2])
    .duration(200)
    .EUt(16)
    .buildAndRegister();
}

//----------------CPU AND RAM----------------------

chemical_bath.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:polytetrafluoroethylene> * 250])
.inputs([<metaitem:wafer.integrated_logic_circuit>])
.outputs([<contenttweaker:coated_logic_circuit>])
.duration(200)
.EUt(10)
.buildAndRegister();

laser_engraver.recipeBuilder()
.property("cleanroom", "cleanroom")
.notConsumable([<contenttweaker:lithography_mask>])
.inputs([<contenttweaker:coated_logic_circuit>])
.outputs([<contenttweaker:engraved_logic_circuit>])
.duration(900)
.EUt(256)
.buildAndRegister();

electrolyzer.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:gold_chloride> * 1000])
.inputs([
    <contenttweaker:engraved_logic_circuit>,
    <ore:foilGold> * 2
    ])
.outputs([<metaitem:wafer.random_access_memory>])
.duration(300)
.EUt(120)
.buildAndRegister();

electrolyzer.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:copper_sulfate> * 1000])
.inputs([
    <contenttweaker:engraved_logic_circuit>,
    <ore:foilCopper> * 2
    ])
.outputs([<metaitem:wafer.central_processing_unit>])
.duration(300)
.EUt(120)
.buildAndRegister();


//--------------NANO CPU---------------

cvd.recipeBuilder()
.property("cleanroom", "cleanroom")
.property("pressure", 25)
.inputs([
    <contenttweaker:engraved_logic_circuit>,
    <metaitem:dustSmallIndiumGalliumPhosphide>
    ])
.outputs([<contenttweaker:doped_logic_circuit>])
.duration(400)
.EUt(1920)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:hydrofluoric_acid> * 1000])
.inputs([
    <contenttweaker:doped_logic_circuit>,
    <ore:foilTungsten> * 3
    ])
.outputs([<contenttweaker:tungsten_logic_circuit>])
.duration(200)
.EUt(1920)
.buildAndRegister();

forming_press.recipeBuilder()
.property("cleanroom", "cleanroom")
.inputs([
    <contenttweaker:tungsten_logic_circuit>,
    <metaitem:dustSmallSiliconCarbide>
    ])
.outputs([<metaitem:wafer.nano_central_processing_unit>])
.duration(600)
.EUt(1920)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:hydrofluoric_acid> * 1000])
.inputs([
    <contenttweaker:doped_logic_circuit>,
    <ore:foilPlatinum> * 3
    ])
.outputs([<contenttweaker:platinum_logic_circuit>])
.duration(200)
.EUt(1920)
.buildAndRegister();

forming_press.recipeBuilder()
.property("cleanroom", "cleanroom")
.inputs([
    <contenttweaker:platinum_logic_circuit>,
    <metaitem:dustSmallSiliconCarbide>
    ])
.outputs([<metaitem:wafer.nor_memory_chip>])
.duration(600)
.EUt(1920)
.buildAndRegister();

//---------------------QUANTUM CPU---------------------

//NOTE: BASED ON https://en.wikipedia.org/wiki/Superconducting_quantum_computing
//ALSO: https://en.wikipedia.org/wiki/Niemeyer%E2%80%93Dolan_technique

cvd.recipeBuilder()
.property("cleanroom", "cleanroom")
.property("pressure", 25)
.property("temperature", 1073)
.inputs([
    <metaitem:dustSmallIndiumGalliumPhosphide>,
    <contenttweaker:etched_wafer>
    ])
.fluidInputs([
    <liquid:nitrogen> * 700,
    <liquid:silane> * 300
    ])
.outputs([<contenttweaker:polycrystalline_silicon_wafer>])
.duration(400)
.EUt(1920)
.buildAndRegister();

laser_engraver.recipeBuilder()
.property("cleanroom", "cleanroom")
.notConsumable([<contenttweaker:lithography_mask>])
.inputs([<contenttweaker:polycrystalline_silicon_wafer>])
.outputs([<contenttweaker:engraved_polycrystalline_wafer>])
.duration(400)
.EUt(1920)
.buildAndRegister();

cvd.recipeBuilder()
.property("cleanroom", "cleanroom")
.property("pressure", 1)
.notConsumable([<contenttweaker:evaporation_mask>])
.fluidInputs([<liquid:yttrium_barium_cuprate> * 48])
.inputs([
    <contenttweaker:engraved_polycrystalline_wafer>,
    ])
.outputs([<gregtech:meta_item_1:570>])
.duration(900)
.EUt(1920)
.buildAndRegister();