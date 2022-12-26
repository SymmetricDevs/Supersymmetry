#norun
import mods.gregtech.recipe.RecipeMap;



//-------------------REMOVE OLD RECIPES----------------

//---------------------ADD NEW RECIPES--------------------

//----------------------FORMALDEHYDE--------------------
fluid_heater.recipeBuilder()
.fluidInputs([<liquid:methanol> * 1000])
.notConsumable([<ore:plateSilver>])
.fluidOutputs([<liquid:formaldehyde> * 1000])
.duration(120)
.EUt(30)
.buildAndRegister();

//-----------------NOVOLACS (PHOTOPOLYMER)-------------------
mixer.recipeBuilder()
.fluidInputs([<liquid:phenol> * 1000, <liquid:formaldehyde> * 1000])
.fluidOutputs([<liquid:novolacs> * 2000])
.duration(200)
.EUt(30)
.buildAndRegister();

//-----------------ELECTROPLATING SOLUTIONS-----------------------------
chemical_reactor.recipeBuilder()
.inputs([<metaitem:dustCopper>])
.fluidInputs([<liquid:sulfuric_acid> * 1000])
.fluidOutputs([<liquid:copper_sulfate> * 1000])
.duration(200)
.EUt(30)
.buildAndRegister();

fluid_heater.recipeBuilder()
.inputs([<metaitem:dustGold> * 2])
.fluidInputs([<liquid:chlorine> * 6000])
.fluidOutputs([<liquid:gold_chloride> * 1000])
.duration(200)
.EUt(30)
.buildAndRegister();

//-------------------SILANE CHAIN-------------------

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.inputs([<metaitem:dustRefinedsilicon>])
.fluidInputs([<liquid:hydrochloric_acid> * 3000])
.fluidOutputs([
    <liquid:trichlorosilane_solution> * 1000,
    <liquid:hydrogen> * 2000
    ])
.duration(160)
.EUt(64)
.buildAndRegister();

distillery.recipeBuilder()
.property("cleanroom", "cleanroom")
.notConsumable([<gregtech:meta_item_1:461>.withTag({Configuration: 0})])
.fluidInputs([<liquid:trichlorosilane_solution> * 1000])
.fluidOutputs([<liquid:trichlorosilane> * 850])
.duration(160)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:trichlorosilane> * 2000])
.fluidOutputs([
    <liquid:dichlorosilane> * 1000,
    <liquid:silicon_tetrachloride> * 1000
    ])
.duration(160)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.inputs([<metaitem:dustRefinedsilicon>])
.fluidInputs([
    <liquid:silicon_tetrachloride> * 3000,
    <liquid:hydrogen> * 2000
    ])
.fluidOutputs([<liquid:trichlorosilane> * 1000])
.duration(160)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:dichlorosilane> * 2000])
.fluidOutputs([
    <liquid:chlorosilane> * 1000,
    <liquid:trichlorosilane> * 1000
    ])
.duration(160)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.property("cleanroom", "cleanroom")
.fluidInputs([<liquid:chlorosilane> * 2000])
.fluidOutputs([
    <liquid:silane> * 1000,
    <liquid:dichlorosilane> * 1000
    ])
.duration(160)
.EUt(64)
.buildAndRegister();

//-------------------------MOLECULAR SIEVES (gt-ideas issue 7)-------------------------

chemical_reactor.recipeBuilder()
.inputs([
    <metaitem:dustSodiumHydroxide> * 6,
    <metaitem:dustSiliconDioxide> * 3
    ])
.outputs([<metaitem:dustSodiumSilicate> * 4])
.fluidOutputs([<liquid:water> * 1000])
.duration(160)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.inputs([
    <metaitem:dustAluminiumHydroxide> * 7,
    <metaitem:dustSodiumHydroxide> * 3
    ])
.outputs([<metaitem:dustSodiumAluminate> * 4])
.fluidOutputs([<liquid:water> * 2000])
.duration(160)
.EUt(64)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.inputs([
    <metaitem:dustSodiumAluminate> * 4,
    <metaitem:dustSodiumSilicate> * 4
    ])
.fluidInputs([
    <liquid:water> * 2500,
    <liquid:oxygen> * 1000
    ])
.outputs([
    <metaitem:dustMediumMolecularSieveWet> * 4,
    <metaitem:dustSodiumOxide> * 3
    ])
.duration(240)
.EUt(256)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.inputs([
    <metaitem:dustMediumMolecularSieve> * 2,
    <metaitem:dustPotash> * 1
    ])
.outputs([
    <metaitem:dustSmallMolecularSieve> * 2,
    <metaitem:dustSodiumOxide> * 1
    ])
.duration(240)
.EUt(256)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.inputs([
    <metaitem:dustMediumMolecularSieve> * 6,
    <metaitem:dustQuicklime> * 1
    ])
.outputs([
    <metaitem:dustLargeMolecularSieve> * 6,
    <metaitem:dustSodiumOxide> * 3
    ])
.duration(240)
.EUt(256)
.buildAndRegister();

dryer.recipeBuilder()
.inputs([<metaitem:dustSmallMolecularSieveWet>])
.outputs([<metaitem:dustSmallMolecularSieve>])
.duration(200)
.EUt(64)
.buildAndRegister();

dryer.recipeBuilder()
.inputs([<metaitem:dustMediumMolecularSieveWet>])
.outputs([<metaitem:dustMediumMolecularSieve>])
.duration(200)
.EUt(64)
.buildAndRegister();

dryer.recipeBuilder()
.inputs([<metaitem:dustLargeMolecularSieveWet>])
.outputs([<metaitem:dustLargeMolecularSieve>])
.duration(200)
.EUt(64)
.buildAndRegister();

//---------------------2-ETHYLHEXANOL------------------------

chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:hydrogen> * 8000, <liquid:propene> * 2000, <liquid:carbon_monoxide> * 2000])
.fluidOutputs([<liquid:water> * 1000, <liquid:ethylhexanol> * 3000])
.duration(400)
.EUt(480)
.buildAndRegister();

//-------------------------METHYL ISOBUTYL KETONE----------------------

chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:acetone> * 2000])
.notConsumable([<metaitem:dustBarium>])
.fluidOutputs([<liquid:mesityl_oxide> * 1000, <liquid:water> * 1000])
.duration(200)
.EUt(120)
.buildAndRegister();

chemical_reactor.recipeBuilder()
.fluidInputs([<liquid:mesityl_oxide> * 1000, <liquid:water> * 1000])
.notConsumable([<metaitem:platePalladium>])
.inputs([<metaitem:dustCarbon>])
.fluidOutputs([<liquid:methyl_isobutyl_ketone> * 1000, <liquid:carbon_monoxide> * 1000])
.duration(150)
.EUt(480)
.buildAndRegister();