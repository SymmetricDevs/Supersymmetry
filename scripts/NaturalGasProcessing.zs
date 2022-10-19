import mods.gregtech.recipe.RecipeMap;

//-------------------REMOVE OLD RECIPES----------------

// Butane * 60
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:refinery_gas> * 1000]).remove();

// Helium * 20
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 5})], [<liquid:refinery_gas> * 1000]).remove();

// Methane * 1400
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_hydrocracked_gas> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_steamcracked_gas> * 1000]).remove();

// Methane * 1400
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:severely_hydrocracked_gas> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillation_tower>.findRecipe(120, null, [<liquid:lightly_steamcracked_gas> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 5})], [<liquid:lightly_steamcracked_gas> * 1000]).remove();

// Helium * 20
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:lightly_hydrocracked_gas> * 1000]).remove();

// Helium * 20
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 3})], [<liquid:severely_hydrocracked_gas> * 1000]).remove();

// Tiny Pile of Carbon Dust * 1
<recipemap:distillery>.findRecipe(30, [<metaitem:circuit.integrated>.withTag({Configuration: 5})], [<liquid:severely_steamcracked_gas> * 1000]).remove();

// Hydrogen Sulfide * 1000
<recipemap:chemical_reactor>.findRecipe(30, null, [<liquid:natural_gas> * 16000, <liquid:hydrogen> * 2000]).remove();

// Small Pile of Rare Earth * 1
<recipemap:extractor>.findRecipe(64, [<metaitem:dustMonazite>], null).remove();


//---------------------RECIPE ADDITION--------------------

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:refinery_gas> * 1000])
.fluidOutputs([
    <liquid:methane> * 750,
    <liquid:butane> * 70,
    <liquid:propane> * 80,
    <liquid:ethane> * 50,
    <liquid:ethane> * 50
    ])
.duration(240)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_steamcracked_gas> * 1000])
.fluidOutputs([
    <liquid:methane> * 1026,
    <liquid:ethylene> * 85,
    <liquid:propene> * 45,
    <liquid:ethane> * 8
    ])
.outputs([<metaitem:dustTinyCarbon>])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_steamcracked_gas> * 1000])
.fluidOutputs([
    <liquid:methane> * 1020,
    <liquid:ethylene> * 92,
    <liquid:propene> * 8,
    <liquid:ethane> * 45
    ])
.outputs([<metaitem:dustTinyCarbon>])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:lightly_hydrocracked_gas> * 1000])
.fluidOutputs([
    <liquid:methane> * 1400,
    <liquid:hydrogen> * 1340
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:severely_hydrocracked_gas> * 1000])
.fluidOutputs([
    <liquid:methane> * 1400,
    <liquid:hydrogen> * 4340
    ])
.duration(120)
.EUt(120)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:natural_gas> * 1000])
.fluidOutputs([
    <liquid:oil_light> * 100,
    <liquid:separated_natural_gas> * 800,
    <liquid:steam> * 100
    ])
.duration(240)
.EUt(120)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([
    <liquid:separated_natural_gas> * 12000,
    <liquid:hydrogen> * 2000
    ])
.fluidOutputs([
    <liquid:treated_natural_gas> * 12000,
    <liquid:hydrogen_sulfide> * 1000
    ])
.duration(160)
.EUt(30)
.buildAndRegister();

mixer.recipeBuilder()
.inputs([
    <metaitem:dustCoke> * 7,
    <metaitem:dustSulfur>
    ])
.outputs([<metaitem:dustActivatedCarbon> * 8])
.duration(80)
.EUt(30)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:treated_natural_gas> * 12000])
.inputs([<gregtech:meta_dust:1215> * 8])
.fluidOutputs([<liquid:purified_natural_gas> * 12000])
.outputs([<gregtech:meta_dust:1216> * 9])
.duration(160)
.EUt(30)
.buildAndRegister();

dryer.recipeBuilder()
.inputs([<ore:dustMercuryCarbon> * 9])
.fluidOutputs([<liquid:mercury> * 200])
.duration(200)
.EUt(40)
.buildAndRegister();

distillation_tower.recipeBuilder()
.fluidInputs([<liquid:purified_natural_gas> * 1000])
.fluidOutputs([
    <liquid:methane> * 750,
    <liquid:butane> * 60,
    <liquid:propane> * 70,
    <liquid:ethane> * 100,
    <liquid:helium> * 20
    ])
.duration(240)
.EUt(120)
.buildAndRegister();