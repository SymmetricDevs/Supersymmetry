import static globals.Globals.*

ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
CRYSTALLIZER = recipemap('crystallizer')
EBF = recipemap('electric_blast_furnace')
SIFTER = recipemap('sifter')
FF = recipemap('froth_flotation')

// MOLYBDENITE BENEFICIATION

MIXER.recipeBuilder()
        .inputs(ore('dustMolybdenite') * 8)
        .fluidInputs(fluid('distilled_water') * 2500)
        .fluidOutputs(fluid('impure_molybdenite_slurry') * 2500)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

FF.recipeBuilder()
        .fluidInputs(fluid('impure_molybdenite_slurry') * 2500)
        .notConsumable(metaitem('dustQuicklime'))
        .notConsumable(metaitem('dustSodiumIsopropylXanthate'))
        .notConsumable(fluid('hydrogen_peroxide_solution') * 100)
        .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
        .fluidOutputs(fluid('copper_concentrate_slurry') * 500)
        .fluidOutputs(fluid('molybdenite_slurry') * 1000)
        .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

FF.recipeBuilder()
        .fluidInputs(fluid('impure_molybdenite_slurry') * 3000)
        .notConsumable(metaitem('dustQuicklime'))
        .notConsumable(metaitem('dustPotassiumAmylXanthate'))
        .notConsumable(fluid('hydrogen_peroxide_solution') * 100)
        .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
        .fluidOutputs(fluid('copper_concentrate_slurry') * 500)
        .fluidOutputs(fluid('molybdenite_slurry') * 1000)
        .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

CLARIFIER.recipeBuilder()
        .fluidInputs(fluid('molybdenite_slurry') * 1000)
        .outputs(metaitem('dustFlotatedMolybdenite') * 16)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(20)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

// PURIFICATION

ROASTER.recipeBuilder()
        .inputs(ore('dustFlotatedMolybdenite') * 3)
        .fluidInputs(fluid('oxygen') * 7000)
        .outputs(metaitem('dustMolybdenumTrioxide') * 4)
        .fluidOutputs(fluid('sulfur_dioxide') * 2000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustMolybdenumTrioxide') * 4)
        .fluidInputs(fluid('ammonia_solution') * 2000)
        .fluidOutputs(fluid('ammonium_molybdate_solution') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .notConsumable(item('gregtech:wire_coil', 2))
        .fluidInputs(fluid('ammonium_molybdate_solution') * 2000)
        .outputs(metaitem('dustAmmoniumDimolybdate') * 19)
        .fluidOutputs(fluid('ammonia') * 2000)
        .fluidOutputs(fluid('steam') * 2000)
        .fluidOutputs(fluid('wastewater') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

// TUNGSTEN BYPRODUCT PROCESSING

ROASTER.recipeBuilder()
        .inputs(ore('dustMolybdenumTrisulfide') * 4)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustImpureMolybdenumTrioxide') * 4)
        .fluidOutputs(fluid('sulfur_dioxide') * 3000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustImpureMolybdenumTrioxide') * 4)
        .fluidInputs(fluid('hydrochloric_acid') * 1000)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidOutputs(fluid('molybdenic_acid_solution') * 1000) // 1x H2MoO4, 1x HCl, 1x H2O
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('molybdenic_acid_solution') * 1000)
        .fluidInputs(fluid('ammonia_solution') * 3000)
        .fluidOutputs(fluid('neutralized_ammonium_molybdate_solution') * 4000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .notConsumable(item('gregtech:wire_coil', 2))
        .fluidInputs(fluid('neutralized_ammonium_molybdate_solution') * 8000)
        .outputs(metaitem('dustAmmoniumDimolybdate') * 19)
        .fluidOutputs(fluid('ammonia') * 2000)
        .fluidOutputs(fluid('steam') * 7000)
        .fluidOutputs(fluid('ammonium_chloride_solution') * 2000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

// FINAL PROCESSING

ROASTER.recipeBuilder()
        .inputs(ore('dustAmmoniumDimolybdate') * 19)
        .outputs(metaitem('dustPurifiedMolybdenumTrioxide') * 8)
        .fluidOutputs(fluid('steam') * 1000)
        .fluidOutputs(fluid('ammonia') * 2000)
        .duration(100)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

// BYPASS (95% yield)

EBF.recipeBuilder()
        .inputs(ore('dustImpureMolybdenumTrioxide') * 4)
        .fluidInputs(fluid('air') * 1000)
        .fluidOutputs(fluid('sublimated_molybdenum_trioxide') * 1000)
        .blastFurnaceTemp(1400)
        .duration(100)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()
        
EBF.recipeBuilder()
        .inputs(ore('dustMolybdenumTrioxide') * 4)
        .fluidInputs(fluid('air') * 1000)
        .fluidOutputs(fluid('sublimated_molybdenum_trioxide') * 1000)
        .blastFurnaceTemp(1400)
        .duration(100)
        .EUt(Globals.voltAmps[5])
        .buildAndRegister()

SIFTER.recipeBuilder()
        .notConsumable(metaitem('item_filter'))
        .fluidInputs(fluid('sublimated_molybdenum_trioxide') * 1000)
        .chancedOutput(metaitem('dustPurifiedMolybdenumTrioxide') * 4, 9500, 0)
        .fluidOutputs(fluid('air') * 1000)
        .duration(100)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

// REDUCTION TO PURE METAL

REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('hydrogen') * 6000)
        .inputs(ore('dustPurifiedMolybdenumTrioxide') * 4)
        .fluidOutputs(fluid('steam') * 3000)
        .outputs(metaitem('dustMolybdenum'))
        .duration(100)
        .EUt(Globals.voltAmps[4])
        .buildAndRegister()