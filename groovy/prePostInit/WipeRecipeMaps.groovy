import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.GTRecipeHandler;
import gregtechfoodoption.recipe.GTFORecipeMaps;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.recipes.GTRecipeHandler.*;

//Removed to make way for overhauls
removeAllRecipes(RecipeMaps.DISTILLERY_RECIPES);
removeAllRecipes(RecipeMaps.DISTILLATION_RECIPES);
removeAllRecipes(RecipeMaps.CRACKING_RECIPES);
removeAllRecipes(RecipeMaps.BREWING_RECIPES);
removeAllRecipes(RecipeMaps.CHEMICAL_RECIPES);
removeAllRecipes(RecipeMaps.LARGE_CHEMICAL_RECIPES);
removeAllRecipes(RecipeMaps.FERMENTING_RECIPES);
removeAllRecipes(RecipeMaps.PYROLYSE_RECIPES);
removeAllRecipes(RecipeMaps.IMPLOSION_RECIPES);
removeAllRecipes(RecipeMaps.LASER_ENGRAVER_RECIPES);
removeAllRecipes(GTFORecipeMaps.GREENHOUSE_RECIPES);
removeAllRecipes(RecipeMaps.VACUUM_RECIPES);
removeAllRecipes(RecipeMaps.ELECTROLYZER_RECIPES);

//Removed due to infinite stone being unrealistic
removeAllRecipes(recipemap('rock_breaker'));

//Removal of certain centrifuging recipes

// LPG * 370
mods.gregtech.centrifuge.removeByInput(5, null, [fluid('butane') * 320])
// LPG * 290
mods.gregtech.centrifuge.removeByInput(5, null, [fluid('propane') * 320])
// Clay Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustBrick')], null)
// Epoxy Resin Pulp * 1
mods.gregtech.centrifuge.removeByInput(5, [metaitem('dustReinforcedEpoxyResin')], null)
// Water * 1000
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('gtfo_baking_soda_solution') * 1000])
// Clay Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustFireclay') * 2], null)
//Red sand centrifuging
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:sand', 1)], null)
// Nitrogen Dioxide * 3900
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('ender_air') * 10000])
mods.gregtech.centrifuge.removeByInput(320, [metaitem('dustPlutonium')], null)
// Carbon Monoxide * 3900
mods.gregtech.centrifuge.removeByInput(120, null, [fluid('nether_air') * 10000])
// Nitrogen * 3900
mods.gregtech.centrifuge.removeByInput(7, null, [fluid('air') * 10000])
// Silicon Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:redstone') * 10], null)
// Small Pile of Banded Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(900, [metaitem('dustMetalMixture')], null)
// Silicon Dioxide Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustPlatinumSludgeResidue') * 5], null)
mods.gregtech.centrifuge.removeByInput(320, [metaitem('dustUranium')], null)
// Lead Dust * 1
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('lead_zinc_solution') * 1000])
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:mycelium')], null)
// Antimony Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustStibnite') * 5], null)
// Raw Platinum Powder * 3
mods.gregtech.centrifuge.removeByInput(480, [metaitem('dustPlatinumGroupSludge') * 6], [fluid('aqua_regia') * 1200])
// Small Pile of Redstone Dust * 2
mods.gregtech.centrifuge.removeByInput(80, [item('minecraft:glowstone_dust')], null)
// Small Pile of Quartzite Dust * 1
mods.gregtech.centrifuge.removeByInput(120, [metaitem('dustStone')], null)
// Raw Rubber Pulp * 3
mods.gregtech.centrifuge.removeByInput(5, [metaitem('rubber_drop')], null)
// Sulfur Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustCinnabar') * 2], null)
// Aluminium Dust * 2
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('green_sapphire_slurry') * 3000])
// Aluminium Dust * 2
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('sapphire_slurry') * 3000])
// Aluminium Dust * 2
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('ruby_slurry') * 3000])
// Helium * 120
mods.gregtech.centrifuge.removeByInput(20, [metaitem('dustEndstone')], null)
// Biomass * 200
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustMeat') * 3], null)
//Centrifuging dirt or grass
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:dirt')], null)
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:grass')], null)
// Magnesium Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustMarble') * 8], null)
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustAsh')], null)
// Calcium Dust * 3
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustTricalciumPhosphate') * 5], null)
// Samarium Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustSamariumMagnetic')], null)
// Neodymium Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustNeodymiumMagnetic')], null)
// Phosphorus Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustPhosphorusPentoxide') * 7], null)
// Iridium Chloride Dust * 4
mods.gregtech.centrifuge.removeByInput(120, [metaitem('dustIridiumMetalResidue') * 5], null)
// Oil * 80
mods.gregtech.centrifuge.removeByInput(80, [item('minecraft:soul_sand')], null)
// Methane * 60
mods.gregtech.centrifuge.removeByInput(20, [item('gregtech:rubber_log')], null)
// Methane * 4000
mods.gregtech.centrifuge.removeByInput(5, null, [fluid('refinery_gas') * 8000])
// Enriched Uranium Hexafluoride * 100
mods.gregtech.centrifuge.removeByInput(480, null, [fluid('uranium_hexafluoride') * 1000])
// Tritium * 40
mods.gregtech.centrifuge.removeByInput(80, null, [fluid('deuterium') * 160])
// Helium-3 * 5
mods.gregtech.centrifuge.removeByInput(80, null, [fluid('helium') * 80])
//Centrifuging nether rack dust
mods.gregtech.centrifuge.removeByInput(20, [metaitem('dustNetherrack')], null)
// Deuterium * 40
mods.gregtech.centrifuge.removeByInput(20, null, [fluid('hydrogen') * 160])
// Arsenic Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustRealgar') * 2], null)
// Silicon Dioxide Dust * 4
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustGranite') * 5], null)
// Silicon Dioxide Dust * 4
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustGraniteBlack') * 5], null)
//Rare Earth
mods.gregtech.centrifuge.removeByInput(20, [metaitem('dustRareEarth')], null)
// Dark Ashes * 1
mods.gregtech.centrifuge.removeByInput(30, [item('minecraft:blaze_powder') * 2], null)
//Lava
mods.gregtech.centrifuge.removeByInput(80, null, [fluid('lava') * 100])
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustIronMagnetic')], null)
// Steel Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustSteelMagnetic')], null)
// Steel Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustDamascusSteel')], null)
// Calcite Dust * 2
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustRedrock') * 3], null)
// Copper Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustAnnealedCopper')], null)
// Methane * 54
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:persimmon')], null)
// Methane * 35
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:porkchop')], null)
// Methane * 94
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:pumpkin_pie')], null)
// Methane * 126
mods.gregtech.centrifuge.removeByInput(5, [item('quark:golden_frog_leg')], null)
// Methane * 144
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:rabbit_stew')], null)
// Methane * 35
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:beef')], null)
// Methane * 12
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:potato')], null)
// Methane * 58
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:pear')], null)
// Methane * 130
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_porkchop')], null)
// Methane * 35
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:rabbit')], null)
// Methane * 40
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:rotten_flesh')], null)
// Methane * 18
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:red_mushroom')], null)
// Methane * 14
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:beetroot')], null)
// Methane * 119
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:golden_carrot')], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:mutton')], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:berries')], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:melon')], null)
// Methane * 18
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:nether_wart')], null)
// Methane * 47
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:apple')], null)
// Methane * 20
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish')], null)
// Methane * 20
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish', 1)], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish', 2)], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:fish', 3)], null)
// Methane * 38
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:filled_honeycomb')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:3')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:17')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:18')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:73')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:76')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:77')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:78')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:122')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:123')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:125')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:126')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:160')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:201')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:206')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:208')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:233')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:234')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:235')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:267')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:269')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:270')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:308')], null)
// Methane * 34
mods.gregtech.centrifuge.removeByInput(5, [item('gregtechfoodoption:gtfo_meta_item:309')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:bread')], null)
// Methane * 47
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:chorus_fruit')], null)
// Methane * 81
mods.gregtech.centrifuge.removeByInput(5, [item('quark:cooked_frog_leg')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_fish')], null)
// Methane * 97
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_fish', 1)], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:chicken')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_rabbit')], null)
// Methane * 79
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:golden_apple')], null)
// Methane * 79
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:golden_apple', 1)], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('quark:frog_leg')], null)
// Methane * 130
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_beef')], null)
// Methane * 10
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:shroompowder')], null)
// Methane * 18
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:brown_mushroom')], null)
// Methane * 86
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_chicken')], null)
// Methane * 12
mods.gregtech.centrifuge.removeByInput(5, [item('quark:crab_leg')], null)
// Methane * 54
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:peach')], null)
// Methane * 86
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:mushroom_stew')], null)
// Methane * 130
mods.gregtech.centrifuge.removeByInput(5, [item('quark:cooked_crab_leg')], null)
// Methane * 72
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:baked_potato')], null)
// Methane * 86
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:beetroot_soup')], null)
// Methane * 29
mods.gregtech.centrifuge.removeByInput(5, [item('biomesoplenty:ricebowl')], null)
// Methane * 23
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:poisonous_potato')], null)
// Methane * 32
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:spider_eye')], null)
// Methane * 20
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cookie')], null)
// Methane * 97
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:cooked_mutton')], null)
// Methane * 43
mods.gregtech.centrifuge.removeByInput(5, [item('minecraft:carrot')], null)
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustYellowLimonite') * 4], null)
// Iron Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustBrownLimonite') * 4], null)

recipemap('vacuum_freezer').recipeBuilder()
        .inputs(item('gregtechfoodoption:gtfo_oredict_item:1048'))
        .outputs(item('gregtechfoodoption:gtfo_oredict_item:1049'))
        .EUt(16)
        .duration(20)
        .buildAndRegister()

recipemap('vacuum_freezer').recipeBuilder()
        .inputs(item('gregtechfoodoption:gtfo_oredict_item:1084'))
        .outputs(item('gregtechfoodoption:gtfo_meta_item:14'))
        .EUt(16)
        .duration(200)
        .buildAndRegister()