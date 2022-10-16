import mods.gregtech.recipe.RecipeMap;

//-------------------REMOVE OLD RECIPES----------------
// Sulfuric Heavy Fuel * 10
<recipemap:distillation_tower>.findRecipe(96, null, [<liquid:oil_light> * 150]).remove();

// Sulfuric Heavy Fuel * 15
<recipemap:distillation_tower>.findRecipe(96, null, [<liquid:oil_medium> * 100]).remove();

// Sulfuric Heavy Fuel * 15
<recipemap:distillation_tower>.findRecipe(96, null, [<liquid:oil> * 50]).remove();

// Sulfuric Heavy Fuel * 250
<recipemap:distillation_tower>.findRecipe(288, null, [<liquid:oil_heavy> * 100]).remove();

// Lightly Hydro-Cracked Heavy Naphtha * 1000
<recipemap:cracker>.findRecipe(120, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:naphtha> * 1000, <liquid:hydrogen> * 2000]).remove();

// Lightly Steam-Cracked Heavy Naphtha * 1000
<recipemap:cracker>.findRecipe(240, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:naphtha> * 1000, <liquid:steam> * 1000]).remove();

// Severely Hydro-Cracked Heavy Naphtha * 1000
<recipemap:cracker>.findRecipe(240, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:naphtha> * 1000, <liquid:hydrogen> * 6000]).remove();

// Severely Steam-Cracked Heavy Naphtha * 1000
<recipemap:cracker>.findRecipe(480, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:naphtha> * 1000, <liquid:steam> * 1000]).remove();

// Lightly Steam-Cracked Heavy Naphtha * 500
<recipemap:chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:naphtha> * 1000, <liquid:steam> * 1000]).remove();

// Lightly Hydro-Cracked Heavy Naphtha * 250
<recipemap:chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:naphtha> * 500, <liquid:hydrogen> * 1000]).remove();

// Severely Hydro-Cracked Heavy Naphtha * 250
<recipemap:chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:naphtha> * 500, <liquid:hydrogen> * 3000]).remove();

// Severely Steam-Cracked Heavy Naphtha * 500
<recipemap:chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:naphtha> * 1000, <liquid:steam> * 1000]).remove();

// Butane * 32
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:lightly_hydrocracked_naphtha> * 40]).remove();

// Ethane * 25
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:lightly_hydrocracked_naphtha> * 100]).remove();

// Methane * 25
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 4})], [<liquid:lightly_hydrocracked_naphtha> * 100]).remove();

// Propane * 30
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:lightly_hydrocracked_naphtha> * 100]).remove();

// Methane * 60
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 4})], [<liquid:severely_hydrocracked_naphtha> * 40]).remove();

// Ethane * 60
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:severely_hydrocracked_naphtha> * 40]).remove();

// Propane * 25
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:severely_hydrocracked_naphtha> * 200]).remove();

// Butane * 25
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:severely_hydrocracked_naphtha> * 200]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 11})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 10})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 9})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 8})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 7})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 6})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 5})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 4})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 11})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 10})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 9})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 8})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 7})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 6})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 5})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 4})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Kerosene * 600
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_hydrocracked_heavy_fuel> * 1000]).remove();

// Kerosene * 200
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_hydrocracked_heavy_fuel> * 1000]).remove();

// Heavy Naphtha * 800
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_hydrocracked_light_fuel> * 1000]).remove();

// Heavy Naphtha * 200
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_hydrocracked_light_fuel> * 1000]).remove();

// Lightly Steam-Cracked Heavy Naphtha * 500
<recipemap:large_chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:naphtha> * 1000, <liquid:steam> * 1000]).remove();

// Lightly Hydro-Cracked Heavy Naphtha * 250
<recipemap:large_chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:naphtha> * 500, <liquid:hydrogen> * 1000]).remove();

// Severely Hydro-Cracked Heavy Naphtha * 250
<recipemap:large_chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:naphtha> * 500, <liquid:hydrogen> * 3000]).remove();

// Severely Steam-Cracked Heavy Naphtha * 500
<recipemap:large_chemical_reactor>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:naphtha> * 1000, <liquid:steam> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_steamcracked_heavy_fuel> * 1000]).remove();

// Tiny Pile of Carbon Dust * 3
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_steamcracked_heavy_fuel> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_steamcracked_light_fuel> * 1000]).remove();

// Tiny Pile of Carbon Dust * 3
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_steamcracked_light_fuel> * 1000]).remove();

// Butane * 800
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_hydrocracked_naphtha> * 1000]).remove();

// Butane * 125
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_hydrocracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_steamcracked_naphtha> * 1000]).remove();

// Tiny Pile of Carbon Dust * 3
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_steamcracked_naphtha> * 1000]).remove();

// Heavy Naphtha * 32
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:lightly_hydrocracked_light_fuel> * 40]).remove();

// Heavy Naphtha * 25
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:severely_hydrocracked_heavy_fuel> * 100]).remove();

// Heavy Naphtha * 40
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 1})], [<liquid:severely_hydrocracked_light_fuel> * 200]).remove();

// Heavy Naphtha * 50
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:lightly_hydrocracked_heavy_fuel> * 500]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:lightly_steamcracked_heavy_fuel> * 1000]).remove();

// Tiny Pile of Carbon Dust * 3
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:severely_steamcracked_light_fuel> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:lightly_steamcracked_light_fuel> * 1000]).remove();

// Tiny Pile of Carbon Dust * 3
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 2})], [<liquid:severely_steamcracked_heavy_fuel> * 1000]).remove();

// Sulfuric Heavy Naphtha * 20
<recipemap:distillery>.findRecipe(24, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:oil> * 50]).remove();

// Sulfuric Heavy Naphtha * 30
<recipemap:distillery>.findRecipe(24, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:oil_light> * 150]).remove();

// Sulfuric Heavy Naphtha * 20
<recipemap:distillery>.findRecipe(24, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:oil_medium> * 100]).remove();

// Sulfuric Heavy Naphtha * 15
<recipemap:distillery>.findRecipe(72, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:oil_heavy> * 100]).remove();



//---------------------ADD NEW RECIPES--------------------

//----------------------DESALTING OIL--------------------
electrolyzer.recipeBuilder()
.fluidInputs([
    <liquid:water> * 100,
    <liquid:oil_light> * 1000
    ])
.fluidOutputs([
    <liquid:salt_water> * 100,
    <liquid:desalted_light_oil> * 1000
    ])
.duration(160)
.EUt(24)
.buildAndRegister();

electrolyzer.recipeBuilder()
.fluidInputs([
    <liquid:water> * 100,
    <liquid:oil> * 1000
    ])
.fluidOutputs([
    <liquid:salt_water> * 100,
    <liquid:desalted_oil> * 1000
    ])
.duration(160)
.EUt(24)
.buildAndRegister();

electrolyzer.recipeBuilder()
.fluidInputs([
    <liquid:water> * 100,
    <liquid:oil_heavy> * 1000
    ])
.fluidOutputs([
    <liquid:salt_water> * 100,
    <liquid:desalted_heavy_oil> * 1000
    ])
.duration(160)
.EUt(24)
.buildAndRegister();

electrolyzer.recipeBuilder()
.fluidInputs([
    <liquid:water> * 100,
    <liquid:oil_medium> * 1000
    ])
.fluidOutputs([
    <liquid:salt_water> * 100,
    <liquid:desalted_medium_oil> * 1000
    ])
.duration(160)
.EUt(24)
.buildAndRegister();

//----------------------DISTILLING OIL--------------------

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:desalted_medium_oil> * 100])
.fluidOutputs([
    <liquid:oil_residue> * 10,
    <liquid:naphtha_mix> * 60,
    <liquid:sulfuric_heavy_fuel> * 16,
    <liquid:sulfuric_light_fuel> * 50,
    <liquid:sulfuric_lubricant> * 10,
    <liquid:sulfuric_gas> * 60
    ])
.outputs([<metaitem:dustAsphalt>])
.duration(40)
.EUt(96)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:desalted_oil> * 50])
.fluidOutputs([
    <liquid:oil_residue> * 10,
    <liquid:naphtha_mix> * 60,
    <liquid:sulfuric_heavy_fuel> * 16,
    <liquid:sulfuric_light_fuel> * 50,
    <liquid:sulfuric_lubricant> * 10,
    <liquid:sulfuric_gas> * 60
    ])
.outputs([<metaitem:dustAsphalt>])
.duration(40)
.EUt(96)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:desalted_heavy_oil> * 100])
.fluidOutputs([
    <liquid:oil_residue> * 20,
    <liquid:naphtha_mix> * 80,
    <liquid:sulfuric_heavy_fuel> * 60,
    <liquid:sulfuric_light_fuel> * 30,
    <liquid:sulfuric_lubricant> * 10,
    <liquid:sulfuric_gas> * 60
    ])
.outputs([<metaitem:dustAsphalt>])
.duration(40)
.EUt(96)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:desalted_light_oil> * 100])
.fluidOutputs([
    <liquid:oil_residue> * 10,
    <liquid:naphtha_mix> * 40,
    <liquid:sulfuric_heavy_fuel> * 20,
    <liquid:sulfuric_light_fuel> * 80,
    <liquid:sulfuric_lubricant> * 20,
    <liquid:sulfuric_gas> * 120
    ])
.outputs([<metaitem:dustAsphalt>])
.duration(40)
.EUt(96)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:oil_residue> * 100])
.fluidOutputs([
    <liquid:naphtha_mix> * 40,
    <liquid:sulfuric_heavy_fuel> * 30,
    <liquid:sulfuric_light_fuel> * 20,
    <liquid:sulfuric_lubricant> * 10,
    <liquid:sulfuric_gas> * 40
    ])
.outputs([<metaitem:dustAsphalt>])
.duration(40)
.EUt(96)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:naphtha_mix> * 100])
.fluidOutputs([
    <liquid:sulfuric_naphtha> * 50,
    <liquid:sulfuric_light_naphtha> * 50
    ])
.duration(40)
.EUt(96)
.buildAndRegister();

cracker.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 1})])
.fluidInputs([
    <liquid:light_naphtha> * 1000,
    <liquid:hydrogen> * 2000
    ])
.fluidOutputs([
    <liquid:lightly_hydrocracked_light_naphtha> * 1000
    ])
.duration(80)
.EUt(120)
.buildAndRegister();

cracker.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 2})])
.fluidInputs([
    <liquid:light_naphtha> * 1000,
    <liquid:hydrogen> * 6000
    ])
.fluidOutputs([
    <liquid:severely_hydrocracked_light_naphtha> * 1000
    ])
.duration(160)
.EUt(240)
.buildAndRegister();

cracker.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 1})])
.fluidInputs([
    <liquid:light_naphtha> * 1000,
    <liquid:steam> * 1000
    ])
.fluidOutputs([
    <liquid:lightly_steamcracked_light_naphtha> * 1000
    ])
.duration(80)
.EUt(240)
.buildAndRegister();

cracker.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 3})])
.fluidInputs([
    <liquid:light_naphtha> * 1000,
    <liquid:steam> * 1000
    ])
.fluidOutputs([
    <liquid:severely_steamcracked_light_naphtha> * 1000
    ])
.duration(160)
.EUt(480)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 3})])
.fluidInputs([
    <liquid:light_naphtha> * 1000,
    <liquid:steam> * 1000
    ])
.fluidOutputs([
    <liquid:severely_steamcracked_light_naphtha> * 500
    ])
.duration(240)
.EUt(30)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 1})])
.fluidInputs([
    <liquid:light_naphtha> * 500,
    <liquid:hydrogen> * 1000
    ])
.fluidOutputs([
    <liquid:lightly_hydrocracked_light_naphtha> * 250
    ])
.duration(80)
.EUt(30)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 2})])
.fluidInputs([
    <liquid:light_naphtha> * 500,
    <liquid:hydrogen> * 3000
    ])
.fluidOutputs([
    <liquid:severely_hydrocracked_light_naphtha> * 250
    ])
.duration(160)
.EUt(30)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.notConsumable([<metaitem:circuit.integrated>.withTag({Configuration: 1})])
.fluidInputs([
    <liquid:light_naphtha> * 1000,
    <liquid:steam> * 1000
    ])
.fluidOutputs([
    <liquid:lightly_steamcracked_light_naphtha> * 500
    ])
.duration(30)
.EUt(30)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_hydrocracked_light_naphtha> * 1000])
.fluidOutputs([
    <liquid:butane> * 800,
    <liquid:propane> * 300,
    <liquid:ethane> * 250,
    <liquid:methane> * 250
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_hydrocracked_light_naphtha> * 1000])
.fluidOutputs([
    <liquid:butane> * 125,
    <liquid:propane> * 125,
    <liquid:ethane> * 1500,
    <liquid:methane> * 1500
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_steamcracked_light_naphtha> * 1000])
.fluidOutputs([
    <liquid:heavy_fuel> * 75,
    <liquid:light_fuel> * 150,
    <liquid:toluene> * 40,
    <liquid:benzene> * 150,
    <liquid:butene> * 80,
    <liquid:butadiene> * 150,
    <liquid:propane> * 15,
    <liquid:propene> * 200,
    <liquid:ethane> * 35,
    <liquid:ethylene> * 200,
    <liquid:methane> * 200
    ])
.outputs([<metaitem:dustTinyCarbon>])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_steamcracked_light_naphtha> * 1000])
.fluidOutputs([
    <liquid:heavy_fuel> * 25,
    <liquid:light_fuel> * 50,
    <liquid:toluene> * 20,
    <liquid:benzene> * 100,
    <liquid:butene> * 50,
    <liquid:butadiene> * 50,
    <liquid:propane> * 15,
    <liquid:propene> * 300,
    <liquid:ethane> * 65,
    <liquid:ethylene> * 500,
    <liquid:methane> * 500
    ])
.outputs([<metaitem:dustTinyCarbon>])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_hydrocracked_heavy_fuel> * 1000])
.fluidOutputs([
    <liquid:light_fuel> * 600,
    <liquid:naphtha_mix> * 100,
    <liquid:butane> * 100,
    <liquid:propane> * 100,
    <liquid:ethane> * 75,
    <liquid:methane> * 75
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_hydrocracked_heavy_fuel> * 1000])
.fluidOutputs([
    <liquid:light_fuel> * 200,
    <liquid:naphtha_mix> * 250,
    <liquid:butane> * 300,
    <liquid:propane> * 300,
    <liquid:ethane> * 175,
    <liquid:methane> * 175
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_hydrocracked_light_fuel> * 1000])
.fluidOutputs([
    <liquid:naphtha_mix> * 800,
    <liquid:octane> * 100,
    <liquid:butane> * 150,
    <liquid:propane> * 200,
    <liquid:ethane> * 125,
    <liquid:methane> * 125
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_hydrocracked_light_fuel> * 1000])
.fluidOutputs([
    <liquid:naphtha_mix> * 200,
    <liquid:octane> * 20,
    <liquid:butane> * 125,
    <liquid:propane> * 125,
    <liquid:ethane> * 1500,
    <liquid:methane> * 1500
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_steamcracked_heavy_fuel> * 1000])
.fluidOutputs([
    <liquid:light_fuel> * 300,
    <liquid:light_naphtha> * 50,
    <liquid:toluene> * 25,
    <liquid:benzene> * 125,
    <liquid:butene> * 25,
    <liquid:butadiene> * 15,
    <liquid:propane> * 3,
    <liquid:propene> * 30,
    <liquid:ethane> * 5,
    <liquid:ethylene> * 50,
    <liquid:methane> * 50
    ])
.outputs([<metaitem:dustTinyCarbon>])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_steamcracked_heavy_fuel> * 1000])
.fluidOutputs([
    <liquid:light_fuel> * 100,
    <liquid:light_naphtha> * 125,
    <liquid:toluene> * 80,
    <liquid:benzene> * 400,
    <liquid:butene> * 80,
    <liquid:butadiene> * 50,
    <liquid:propane> * 10,
    <liquid:propene> * 100,
    <liquid:ethane> * 15,
    <liquid:ethylene> * 150,
    <liquid:methane> * 150
    ])
.outputs([<metaitem:dustTinyCarbon> * 3])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_steamcracked_light_fuel> * 1000])
.fluidOutputs([
    <liquid:heavy_fuel> * 150,
    <liquid:light_naphtha> * 400,
    <liquid:toluene> * 40,
    <liquid:benzene> * 200,
    <liquid:butene> * 75,
    <liquid:butadiene> * 60,
    <liquid:propane> * 20,
    <liquid:propene> * 150,
    <liquid:ethane> * 10,
    <liquid:ethylene> * 50,
    <liquid:methane> * 50
    ])
.outputs([<metaitem:dustTinyCarbon> * 1])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_steamcracked_light_fuel> * 1000])
.fluidOutputs([
    <liquid:heavy_fuel> * 50,
    <liquid:light_naphtha> * 100,
    <liquid:toluene> * 30,
    <liquid:benzene> * 150,
    <liquid:butene> * 65,
    <liquid:butadiene> * 50,
    <liquid:propane> * 50,
    <liquid:propene> * 250,
    <liquid:ethane> * 50,
    <liquid:ethylene> * 250,
    <liquid:methane> * 250
    ])
.outputs([<metaitem:dustTinyCarbon> * 3])
.duration(120)
.EUt(120)
.buildAndRegister();

//-----------------COKE--------------------------

ebf.recipeBuilder()
.inputs([<metaitem:dustPetcoke>])
.fluidOutputs([<liquid:sulfuric_gas> * 30])
.outputs([<metaitem:dustCoke>])
.duration(100)
.EUt(48)
.buildAndRegister();

//--------------DESULFURIZING-----------------

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:sulfuric_light_naphtha> * 12000,
    <liquid:hydrogen> * 2000
    ])
.fluidOutputs([
    <liquid:light_naphtha> * 12000,
    <liquid:hydrogen_sulfide> * 1000
    ])
.duration(160)
.EUt(30)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:sulfuric_lubricant> * 12000,
    <liquid:hydrogen> * 2000
    ])
.fluidOutputs([
    <liquid:lubricant> * 12000,
    <liquid:hydrogen_sulfide> * 1000
    ])
.duration(160)
.EUt(30)
.buildAndRegister();