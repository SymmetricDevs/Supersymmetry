import globals.Globals

ABS = recipemap('alloy_blast_smelter')

ABS.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('dustIron') * 12)
    .inputs(ore('dustNickel') * 8)
    .inputs(ore('dustChrome') * 12)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustCopper') * 2)
    .inputs(ore('dustNiobium') * 1)
    .inputs(ore('dustTantalum') * 1)
    .inputs(ore('dustMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_twenty') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(6)
    .inputs(ore('dustIron') * 9)
    .inputs(ore('dustNickel') * 16)
    .inputs(ore('dustChrome') * 7)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustCopper') * 2)
    .inputs(ore('dustAluminium') * 1)
    .inputs(ore('dustTitanium') * 1)
    .inputs(ore('dustMolybdenum') * 2)
    .fluidOutputs(fluid('incoloy_eight_two_five') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('dustAluminium') * 1)
    .inputs(ore('dustCobalt') * 1)
    .inputs(ore('dustIron') * 20)
    .inputs(ore('dustNickel') * 30)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustTitanium') * 2)
    .inputs(ore('dustTungsten') * 1)
    .inputs(ore('dustNiobium') * 2)
    .fluidOutputs(fluid('incoloy_nine_zero_eight') * 8640)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(7)
    .inputs(ore('dustAluminium') * 3)
    .inputs(ore('dustCobalt') * 4)
    .inputs(ore('dustNickel') * 22)
    .inputs(ore('dustChrome') * 3)
    .inputs(ore('dustTungsten') * 2)
    .inputs(ore('dustHafnium') * 1)
    .inputs(ore('dustRhenium') * 2)
    .inputs(ore('dustTantalum') * 3)
    .fluidOutputs(fluid('rene') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('dustNickel') * 23)
    .inputs(ore('dustManganese') * 2)
    .inputs(ore('dustCopper') * 10)
    .inputs(ore('dustAluminium') * 4)
    .inputs(ore('dustTitanium') * 1)
    .fluidOutputs(fluid('monel') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('dustIron') * 2)
    .inputs(ore('dustNickel') * 2)
    .inputs(ore('dustCobalt') * 15)
    .inputs(ore('dustChrome') * 13)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustTungsten') * 7)
    .fluidOutputs(fluid('stellite_j') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('dustNickel') * 1)
    .inputs(ore('dustCobalt') * 24)
    .inputs(ore('dustChrome') * 10)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustTungsten') * 3)
    .inputs(ore('dustMolybdenum') * 1)
    .fluidOutputs(fluid('stellite_six') * 5760)
        .blastFurnaceTemp(3000)
    .duration(4000)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(16)
    .inputs(ore('dustIron') * 39)
    .inputs(ore('dustManganese') * 1)
    .fluidOutputs(fluid('hsla_eighty_x') * 5760)
        .blastFurnaceTemp(2600)
    .duration(3000)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ABS.recipeBuilder()
    .circuitMeta(5)
    .inputs(ore('dustIron') * 24)
    .inputs(ore('dustNickel') * 5)
    .inputs(ore('dustChrome') * 8)
    .inputs(ore('dustManganese') * 1)
    .inputs(ore('dustMolybdenum') * 2)
    .fluidOutputs(fluid('food_grade_stainless_steel') * 5760)
        .blastFurnaceTemp(2600)
    .duration(3000)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

static def removeItemsOfAlloy(String itemCategory) {
    mods.jei.ingredient.removeAndHide(metaitem('ingot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('ingotHot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dust' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustSmall' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustTiny' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('plate' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('stick' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('nugget' + itemCategory));
}

static def removeItemsOfAlloyNoRod(String itemCategory) {
    mods.jei.ingredient.removeAndHide(metaitem('ingot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('ingotHot' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dust' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustSmall' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('dustTiny' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('plate' + itemCategory));
    mods.jei.ingredient.removeAndHide(metaitem('nugget' + itemCategory));
}

removeItemsOfAlloy('HastelloyC276');
removeItemsOfAlloy('HastelloyX');
removeItemsOfAlloy('IncoloyMa956');
removeItemsOfAlloy('MaragingSteel300');
removeItemsOfAlloy('WatertightSteel');
removeItemsOfAlloyNoRod('Stellite100');
removeItemsOfAlloyNoRod('Zeron100');

mods.jei.ingredient.removeAndHide(metaitem('ingotHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustSmallHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('dustTinyHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('plateHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('stickHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('nuggetHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('springHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('stickLongHslaSteel'));
mods.jei.ingredient.removeAndHide(metaitem('plateDoubleHslaSteel'));

/*
    Blocks from GT superalloys need to be removed (block, frame, sheeted frame) and liquids
    Recipes for GCYM casings need to be changed to use SuSy superalloys, currently they still have recipes with old ones
 */