import static globals.Globals.*

BATCH_REACTOR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
DISTILLATION_TOWER = recipemap('distillation_tower')
AUTOCLAVE = recipemap('autoclave')
ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
EBF = recipemap('electric_blast_furnace')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
CONDENSER = recipemap('condenser')
ZONE_REFINER = recipemap('zone_refiner')
COMPRESSOR = recipemap('compressor')
CENTRIFUGE = recipemap('centrifuge')
SIFTER = recipemap('sifter')
FLOTATION = recipemap('froth_flotation')
CLARIFIER = recipemap('clarifier')

//PRIMITIVE (LV)
AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustBone'))
    .fluidInputs(fluid('water') * 250)
    .outputs(metaitem('dustTricalciumPhosphate') * 13)
    .outputs(metaitem('gregtechfoodoption:fat_ingot'))
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustTricalciumPhosphate') * 13)
    .fluidInputs(fluid('sulfuric_acid') * 2000)
    .outputs(metaitem('dustMonocalciumPhosphate') * 15)
    .outputs(metaitem('dustCalciumSulfate') * 12)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustMonocalciumPhosphate') * 15)
    .outputs(metaitem('dustCalciumPhosphite') * 11)
    .fluidOutputs(fluid('steam') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustCalciumPhosphite') * 33)
    .inputs(ore('dustCarbon') * 10)
    .outputs(metaitem('dustTricalciumPhosphate') * 13)
    .outputs(metaitem('dustPhosphorus') * 4)
    .duration(360)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//UNIVERSAL (MV)
//REMOVE APATITE RECIPES
mods.gregtech.mixer.removeByInput(8, [item('minecraft:clay_ball'), metaitem('dustStone'), metaitem('dustApatite') * 2], null)

def apatites = [
        metaitem('dustChlorapatite'),
        metaitem('dustHydroxyapatite'),
        metaitem('dustFluorapatite'),
];

for (apatite in apatites) {
    MIXER.recipeBuilder()
        .inputs(apatite * 2)
        .inputs(item('minecraft:clay_ball'))
        .inputs(ore('dustStone'))
        .outputs(metaitem('gregtechfoodoption:bone_china_clay_dust') * 4)
        .duration(40)
        .EUt(8)
        .buildAndRegister()
}

//WET PROCESS
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustHydroxyapatite'))
    .fluidInputs(fluid('sulfuric_acid') * 5000)
    .outputs(metaitem('dustCalciumSulfate') * 6)
    .fluidOutputs(fluid('diluted_phosphoric_acid') * 4000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustFluorapatite'))
    .fluidInputs(fluid('sulfuric_acid') * 5000)
    .outputs(metaitem('dustCalciumSulfate') * 6)
    .fluidOutputs(fluid('phosphoric_acid') * 3000)
    .fluidOutputs(fluid('hydrogen_fluoride') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustChlorapatite'))
    .fluidInputs(fluid('sulfuric_acid') * 5000)
    .outputs(metaitem('dustCalciumSulfate') * 6)
    .fluidOutputs(fluid('phosphoric_acid') * 3000)
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('diluted_phosphoric_acid') * 4000)
    .fluidOutputs(fluid('phosphoric_acid') * 3000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//CONVERSION TO WHITE PHOSPHORUS
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustCalciumHydroxide') * 5)
    .fluidInputs(fluid('phosphoric_acid') * 2000)
    .outputs(metaitem('dustMonocalciumPhosphate') * 15)
    .fluidOutputs(fluid('water') * 2000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//SULFURIC ACID REGENERATION
ROASTER.recipeBuilder()
    .inputs(ore('dustCalciumSulfate') * 6)
    .inputs(ore('dustSiliconDioxide') * 3)
    .outputs(metaitem('dustCalciumMetasilicate') * 5)
    .fluidOutputs(fluid('sulfur_trioxide_reaction_mixture') * 2000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('sulfur_trioxide_reaction_mixture') * 1000)
    .notConsumable(ore('dustVanadiumPentoxide'))
    .fluidOutputs(fluid('sulfur_trioxide') * 1000)
    .duration(200)
    .EUt(7)
    .buildAndRegister()

//THERMAL PROCESS
EBF.recipeBuilder()
    .inputs(ore('dustFluorapatite') * 2)
    .inputs(ore('dustSiliconDioxide') * 27)
    .inputs(ore('dustCarbon') * 15)
    .outputs(metaitem('dustPhosphorus') * 6)
    .outputs(metaitem('dustCalciumMetasilicate') * 45)
    .outputs(metaitem('dustFluorite') * 3)
    .fluidOutputs(fluid('carbon_monoxide') * 15000)
    .blastFurnaceTemp(1200)
    .duration(720)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustChlorapatite') * 2)
    .inputs(ore('dustSiliconDioxide') * 27)
    .inputs(ore('dustCarbon') * 15)
    .outputs(metaitem('dustPhosphorus') * 6)
    .outputs(metaitem('dustCalciumMetasilicate') * 45)
    .outputs(metaitem('dustCalciumChloride') * 3)
    .fluidOutputs(fluid('carbon_monoxide') * 15000)
    .blastFurnaceTemp(1200)
    .duration(720)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustFluorapatite') * 2)
    .inputs(ore('dustSiliconDioxide') * 27)
    .inputs(ore('dustCarbon') * 15)
    .outputs(metaitem('dustPhosphorus') * 6)
    .outputs(metaitem('dustCalciumMetasilicate') * 45)
    .outputs(metaitem('dustCalciumHydroxide') * 5)
    .blastFurnaceTemp(1200)
    .duration(720)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//SPECIALIZED (HV)
MIXER.recipeBuilder()
    .inputs(ore('dustPhosphorite') * 2)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('phosphorite_slurry') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('phosphorite_slurry') * 1000)
    .outputs(metaitem('dustPhosphatePulp') * 2)
    .chancedOutput(metaitem('dustClay'), 5000, 0)
    .chancedOutput(metaitem('dustSiliconDioxide') * 3, 5000, 0)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(40)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .inputs(ore('dustPhosphatePulp'))
    .outputs(metaitem('dustFilteredPhosphatePulp'))
    .chancedOutput(metaitem('dustSiliconDioxide'), 2500, 0)
    .duration(20)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustFilteredPhosphatePulp') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('filtered_phosphate_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FLOTATION.recipeBuilder()
    .fluidInputs(fluid('filtered_phosphate_slurry') * 2000)
    .notConsumable(fluid('alkaline_sodium_oleate_solution') * 1000)
    .notConsumable(fluid('fuel_oil') * 100)
    .fluidOutputs(fluid('phosphate_concentrate_slurry') * 1000)
    .fluidOutputs(fluid('limestone_tailing_slurry') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('phosphate_concentrate_slurry') * 1000)
    .outputs(metaitem('dustPhosphateConcentrate') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustPhosphateConcentrate'))
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .outputs(metaitem('dustGypsum') * 4)
    .fluidOutputs(fluid('phosphoric_acid') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//HIGH PURITY
COMPRESSOR.recipeBuilder()
    .inputs(ore('dustPhosphorus'))
    .outputs(metaitem('ingotPhosphorus'))
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ZONE_REFINER.recipeBuilder()
    .inputs(ore('ingotPhosphorus'))
    .outputs(metaitem('ingotHighPurityPhosphorus'))
    .duration(400)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

AUTOCLAVE.recipeBuilder()
    .inputs(ore('dustPhosphorus'))
    .fluidInputs(fluid('water') * 250)
    .chancedOutput(metaitem('dustArsenic'), 500, 50)
    .fluidOutputs(fluid('high_purity_phosphorus_vapor_mixture') * 250)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('high_purity_phosphorus_vapor_mixture') * 1000)
    .fluidOutputs(fluid('high_purity_phosphorus') * 576)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('high_purity_phosphorus') * 144)
    .notConsumable(metaitem('shape.mold.ball'))
    .outputs(metaitem('dustHighPurityPhosphorus'))
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//CALCIUM METASILICATE-SILICA RECYCLING
BATCH_REACTOR.recipeBuilder()
    .inputs(ore('dustCalciumMetasilicate') * 5)
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .outputs(metaitem('dustCalcite') * 5)
    .outputs(metaitem('dustSiliconDioxide') * 3)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()


