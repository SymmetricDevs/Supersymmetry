import globals.Globals

FF = recipemap('froth_flotation')
GRAVITY_SEPARATOR = recipemap('gravity_separator')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
ROASTER = recipemap('roaster')
AUTOCLAVE = recipemap('autoclave')
CENTRIFUGE = recipemap('centrifuge')
ADVANCED_ARC_FURNACE = recipemap('advanced_arc_furnace')
FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
BR = recipemap('batch_reactor')
MIXER = recipemap('mixer')
CLARIFIER = recipemap('clarifier')
CHEMICAL_BATH = recipemap('chemical_bath')
REACTION_FURNACE = recipemap('reaction_furnace')

// Beneficiation

// Pyrochlore
// EM Sep, FF, roast with CaO/CaCl2, calcine with H2SO4

GRAVITY_SEPARATOR.recipeBuilder() // Sifted Pyrochlore
    .inputs(ore('dustPyrochlore'))
    .outputs(metaitem('dustSiftedPyrochlore'))
    .chancedOutput(metaitem('dustLimestoneTailings'), 2500, 0)
    .chancedOutput(metaitem('dustCalcite'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(40)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder() // Pyrochlore Concentrate
    .inputs(ore('dustSiftedPyrochlore'))
    .outputs(metaitem('dustConcentratePyrochlore'))
    .chancedOutput(metaitem('dustLimestoneTailings'), 2500, 0)
    .chancedOutput(metaitem('dustCalcite'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

MIXER.recipeBuilder() // Impure Pyrochlore Slurry
    .inputs(ore('dustConcentratePyrochlore') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_pyrochlore_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FF.recipeBuilder() // Pyrochlore Slurry
    .notConsumable(ore('dustOxalicAcid'))
    .fluidInputs(fluid('impure_pyrochlore_slurry') * 2000)
    .notConsumable(fluid('hexafluorosilicic_acid') * 100)
    .notConsumable(fluid('one_amidoethyl_two_alkyl_two_imidazoline') * 100)
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .fluidOutputs(fluid('pyrochlore_slurry') * 1000)
    .fluidOutputs(fluid('limestone_tailing_slurry') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder() // Flotated Pyrochlore
    .fluidInputs(fluid('pyrochlore_slurry') * 1000)
    .outputs(metaitem('dustFlotatedPyrochlore') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder() // Roasted Pyrochlore
    .inputs(ore('dustFlotatedPyrochlore') * 16)
    .inputs(ore('dustQuicklime'))
    .outputs(metaitem('dustRoastedPyrochlore') * 16)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder() // Digested Pyrochlore
    .inputs(ore('dustRoastedPyrochlore') * 16)
    .fluidInputs(fluid('hot_sulfuric_acid') * 1000)
    .outputs(metaitem('dustDigestedPyrochlore') * 16)
    .fluidOutputs(fluid('sulfuric_acid') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder() // Ferroniobium-tantalum
    .inputs(ore('dustIronIiiOxide') * 5)
    .inputs(ore('dustDigestedPyrochlore') * 2)
    .inputs(ore('dustAnyPurityAluminium') * 12)
    .fluidInputs(fluid('sodium_nitrate') * 720)
    .outputs(metaitem('dustFerroniobiumTantalum') * 5)
    .outputs(metaitem('dustAlumina') * 30)
    .outputs(metaitem('dustCalcium') * 4)
    .fluidOutputs(fluid('sodium_nitrite') * 576)
    .duration(800)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

// Fe2O3 + 2 Ca2Nb1.75Ta0.25O7 + 12 Al + NaNO3 -> 0.5 Fe2Nb7Ta + 6 Al2O3 + 4 Ca + 1 NaNO2

FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('sodium_nitrite') * 144)
    .outputs(metaitem('dustSodiumNitrite'))
    .duration(40)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder() // Impure Niobium Pentachloride
    .inputs(ore('dustFerroniobiumTantalum') * 5)
    .fluidInputs(fluid('chlorine') * 23000)
    .notConsumable(fluid('salt') * 1440)
    .notConsumable(fluid('iron_iii_chloride') * 1440)
    .fluidOutputs(fluid('iron_iii_chloride') * 576)
    .fluidOutputs(fluid('impure_niobium_pentachloride') * 8000)
    .duration(400)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder() // Niobium Pentachloride
    .fluidInputs(fluid('impure_niobium_pentachloride') * 8000)
    .fluidOutputs(fluid('tantalum_pentachloride') * 1000)
    .fluidOutputs(fluid('niobium_pentachloride') * 7000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
    .fluidInputs(fluid('niobium_pentachloride') * 1000)
    .outputs(metaitem('dustNiobiumPentachloride') * 6)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder() // Niobium Oxide Dihydrate
    .inputs(ore('dustNiobiumPentachloride') * 12)
    .fluidInputs(fluid('distilled_water') * 17000)
    .outputs(metaitem('dustNiobiumOxideDihydrate') * 9)
    .fluidOutputs(fluid('hydrochloric_acid') * 10000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Columbite
// FF, autoclave with HF & H2SO4, dissolve, MIBK solv extr.

GRAVITY_SEPARATOR.recipeBuilder() // Sifted Columbite
    .inputs(ore('dustColumbite'))
    .outputs(metaitem('dustSiftedColumbite'))
    .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 0)
    .chancedOutput(metaitem('dustNetherQuartz'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(40)
    .buildAndRegister()

ELECTROMAGNETIC_SEPARATOR.recipeBuilder() // Columbite Concentrate
    .inputs(ore('dustSiftedColumbite'))
    .outputs(metaitem('dustConcentrateColumbite'))
    .chancedOutput(metaitem('dustPegmatiteTailings'), 2500, 0)
    .chancedOutput(metaitem('dustNetherQuartz'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

MIXER.recipeBuilder() // Impure Columbite Slurry
    .inputs(ore('dustConcentrateColumbite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_columbite_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FF.recipeBuilder() // Columbite Slurry
    .notConsumable(ore('dustSodiumFluorosilicate'))
    .fluidInputs(fluid('impure_columbite_slurry') * 2000)
    .notConsumable(fluid('one_amidoethyl_two_alkyl_two_imidazoline') * 100)
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .notConsumable(fluid('hydrochloric_acid') * 100)
    .fluidOutputs(fluid('columbite_slurry') * 1000)
    .fluidOutputs(fluid('pegmatite_tailing_slurry') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder() // Flotated Columbite
    .fluidInputs(fluid('columbite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedColumbite') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

AUTOCLAVE.recipeBuilder() // Impure Fluoroniobic Acid Solution
    .inputs(ore('dustFlotatedColumbite') * 1)
    .fluidInputs(fluid('hydrogen_fluoride') * 14000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 2000)
    .fluidOutputs(fluid('impure_fluoroniobic_acid_solution') * 1000)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Niobium-rich Extract
    .fluidInputs(fluid('impure_fluoroniobic_acid_solution') * 1000)
    .fluidInputs(fluid('methyl_isobutyl_ketone') * 6000)
    .fluidOutputs(fluid('niobium_rich_extract') * 6000)
    .fluidOutputs(fluid('metal_sulfate_waste') * 1000)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Scrubbed Niobium-rich Extract
    .fluidInputs(fluid('niobium_rich_extract') * 500)
    .notConsumable(fluid('sulfuric_acid') * 500)
    .fluidOutputs(fluid('scrubbed_niobium_rich_extract') * 500)
    .duration(5)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Fluoroniobic Acid Solution
    .fluidInputs(fluid('scrubbed_niobium_rich_extract') * 500)
    .fluidInputs(fluid('distilled_water') * 500)
    .fluidOutputs(fluid('diluted_tantalum_extract') * 500)
    .fluidOutputs(fluid('fluoroniobic_acid_solution') * 500)
    .duration(5)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder() // Purified Fluoroniobic Acid Solution
    .fluidInputs(fluid('fluoroniobic_acid_solution') * 6000)
    .fluidInputs(fluid('methyl_isobutyl_ketone') * 1500)
    .fluidOutputs(fluid('purified_fluoroniobic_acid_solution') * 6000)
    .fluidOutputs(fluid('niobium_rich_extract') * 1500)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

BR.recipeBuilder() // Niobium Oxide Dihydrate (2 H2NbF7 + 14 NH3 + 5 H2O --> 14 NH4F + Nb2O5)
    .fluidInputs(fluid('purified_fluoroniobic_acid_solution') * 6000) // 27/20 mol Nb
    .fluidInputs(fluid('ammonia_solution') * 9450)
    .fluidInputs(fluid('distilled_water') * 4725)
    .chancedOutput(metaitem('dustNiobiumOxideDihydrate') * 9, 6750, 0)
    .fluidOutputs(fluid('ammonium_fluoride_solution') * 9450)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .circuitMeta(2)
    .inputs(ore('dustAmmoniumFluoride') * 6)
    .fluidOutputs(fluid('ammonia') * 1000)
    .fluidOutputs(fluid('hydrogen_fluoride') * 1000)
    .EUt(Globals.voltAmps[1])
    .duration(20)
    .buildAndRegister()

ROASTER.recipeBuilder() // Niobium Oxide
    .inputs(ore('dustNiobiumOxideDihydrate') * 9)
    .outputs(metaitem('dustNiobiumOxide') * 7)
    .fluidOutputs(fluid('dense_steam') * 2000)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder() // Niobium
    .inputs(ore('dustNiobiumOxide') * 21)
    .inputs(ore('dustAnyPurityAluminium') * 10)
    .outputs(metaitem('dustAlumina') * 25)
    .fluidOutputs(fluid('niobium') * 864)
    .duration(240)
    .EUt(Globals.voltAmps[4])
    .buildAndRegister()

// From tantalite
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('diluted_niobium_extract') * 9000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('methyl_isobutyl_ketone') * 9000)
    .fluidOutputs(fluid('purified_fluoroniobic_acid_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('metal_sulfate_waste') * 1000)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .chancedOutput(metaitem('dustIronSulfate') * 6, 5000, 0)
    .chancedOutput(metaitem('dustManganeseIiSulfate') * 6, 5000, 0)
    .duration(80)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()
