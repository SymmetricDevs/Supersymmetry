import static globals.Globals.*

ION_EXCHANGE = recipemap('ion_exchange_column')
FLUID_EXTRACTOR = recipemap('extractor')
CSTR = recipemap('continuous_stirred_tank_reactor')
BCR = recipemap('bubble_column_reactor')
BR = recipemap('batch_reactor')
DISTILLATION_TOWER = recipemap('distillation_tower')
LCR = recipemap('large_chemical_reactor')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
PHASE_SEPARATOR = recipemap('phase_separator')
POLYMERIZATION = recipemap('polymerization_tank')
EBF = recipemap('electric_blast_furnace')
FLUID_SOLIDIFER = recipemap('fluid_solidifier')
CHEMICAL_BATH = recipemap('chemical_bath')

// Fiber-Reinforced Epoxy Resin Sheet * 1
mods.gregtech.chemical_bath.removeByInput(16, [metaitem('wireFineBorosilicateGlass')], [fluid('epoxy') * 144])
// Fiber-Reinforced Epoxy Resin Sheet * 1
mods.gregtech.chemical_bath.removeByInput(16, [metaitem('carbon.fibers')], [fluid('epoxy') * 144])

// Curing agents
class CuringAgent {
    String name
    boolean liquid
    int amount_required
    double duration
    CuringAgent(name, liquid, amount_required, duration) {
        this.name = name
        this.liquid = liquid
        this.amount_required = amount_required
        this.duration = duration
    }
}

curingAgents = [
    new CuringAgent('diethylenetriamine', true, 100, 1),
    new CuringAgent('triethylenetetramine', true, 50, 1),
    new CuringAgent('aminoethylpiperazine', true, 50, 1),
    new CuringAgent('dustDicyandiamide', false, 2, 2),
    new CuringAgent('dustPhthalicAnhydride', false, 1, 2),
    new CuringAgent('dustEpoxyCuringMixture', false, 1, 0.25)
]

// BPA

ION_EXCHANGE.recipeBuilder()
    .fluidInputs(fluid('phenol') * 2000)
    .fluidInputs(fluid('acetone') * 1000)
    .notConsumable(metaitem('beads.ag_fifty_w_x_eight'))
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustBisphenolA'))
    .EUt(480)
    .duration(100)
    .buildAndRegister()

FLUID_EXTRACTOR.recipeBuilder()
    .inputs(ore('dustBisphenolA'))
    .fluidOutputs(fluid('bisphenol_a') * 1000)
    .EUt(30)
    .duration(100)
    .buildAndRegister()

// Epichlorohydrin

CSTR.recipeBuilder()
    .fluidInputs(fluid('glycerol') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 100)
    .fluidInputs(fluid('acetic_acid') * 10)
    .fluidOutputs(fluid('chlorinated_glycerol') * 50)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('chlorinated_glycerol') * 4000)
    .inputs(ore('dustSodiumHydroxide') * 3)
    .fluidOutputs(fluid('epichlorohydrin_solution') * 5000)
    .duration(120)
    .EUt(30)
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('epichlorohydrin_solution') * 5000)
    .fluidOutputs(fluid('acetic_acid') * 200)
    .fluidOutputs(fluid('epichlorohydrin') * 1000)
    .fluidOutputs(fluid('water') * 3000)
    .outputs(metaitem('dustSalt') * 2)
    .duration(120)
    .EUt(30)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('allyl_chloride') * 50)
    .fluidInputs(fluid('hypochlorous_acid') * 50)
    .fluidOutputs(fluid('allyl_alcohol_mix') * 50)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('allyl_alcohol_mix') * 1000)
    .inputs(ore('dustSodiumHydroxide') * 3)
    .fluidOutputs(fluid('diluted_epichlorohydrin') * 2000)
    .duration(120)
    .EUt(30)
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('diluted_epichlorohydrin') * 2000)
    .fluidOutputs(fluid('epichlorohydrin') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustSalt') * 2)
    .duration(160)
    .EUt(30)
    .buildAndRegister()

// Unmodified DGEBPA

for (curingAgent in curingAgents) {
    if (curingAgent.liquid) {
        POLYMERIZATION.recipeBuilder()
        .inputs(ore('dustBisphenolA'))
        .fluidInputs(fluid('epichlorohydrin') * 1200) //excess epichlorohydrin to control degree of polymerization
        .fluidInputs(fluid(curingAgent.name) * curingAgent.amount_required)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .outputs(metaitem('dustWetEpoxy') * 7)
        .fluidOutputs(fluid('diluted_saltwater') * 2000)
        .duration((int) (100 * curingAgent.duration))
        .EUt(480)
        .buildAndRegister()
    } else {
        POLYMERIZATION.recipeBuilder()
        .inputs(ore('dustBisphenolA') * 4)
        .fluidInputs(fluid('epichlorohydrin') * 4800)
        .inputs(ore(curingAgent.name) * curingAgent.amount_required)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 4000)
        .outputs(metaitem('dustWetEpoxy') * 28)
        .fluidOutputs(fluid('diluted_saltwater') * 8000)
        .duration((int) (100 * curingAgent.duration))
        .EUt(480)
        .buildAndRegister()
    }
}

VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustWetEpoxy') * 7)
    .notConsumable(ore('springNichrome'))
    .outputs(metaitem('dustEpoxy') * 7)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Flame retardant DGEBA

// Catalyst preparation
BR.recipeBuilder()
    .inputs(ore('dustAluminiumHydroxide') * 7)
    .fluidInputs(fluid('hydrochloric_acid') * 3000)
    .fluidOutputs(fluid('aluminium_chloride_solution') * 3000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustNickelChloride') * 9)
    .inputs(ore('dustAluminiumChloride') * 4)
    .fluidInputs(fluid('demineralized_water') * 4000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 8000)
    .outputs(metaitem('dustNickelHydrotalcite'))
    .fluidOutputs(fluid('salt_water') * 8000)
    .duration(100)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustNickelHydrotalcite'))
    .fluidInputs(fluid('sodium_tungstate_solution') * 100)
    .outputs(metaitem('dustBisphenolBrominationCatalyst'))
    .fluidOutputs(fluid('wastewater') * 100)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Bromination

BR.recipeBuilder()
    .inputs(ore('dustBisphenolA'))
    .notConsumable(ore('dustBisphenolBrominationCatalyst'))
    .fluidInputs(fluid('dichloroethane') * 6000)
    .fluidInputs(fluid('hydrogen_peroxide_solution') * 2000)
    .fluidInputs(fluid('bromine') * 4000)
    .fluidOutputs(fluid('impure_brominated_bisphenol_emulsion') * 10000)
    .duration(160)
    .EUt(1920)
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('impure_brominated_bisphenol_emulsion') * 10000)
    .fluidOutputs(fluid('impure_brominated_bisphenol_solution') * 6000)
    .fluidOutputs(fluid('water') * 4000)
    .duration(160)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('water') * 6500)
    .fluidInputs(fluid('sodium_sulfite_solution') * 500)
    .fluidOutputs(fluid('diluted_sodium_sulfite_solution') * 7000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('impure_brominated_bisphenol_solution') * 6000)
    .fluidInputs(fluid('diluted_sodium_sulfite_solution') * 7000)
    .fluidOutputs(fluid('tetrabromobisphenol_a_solution') * 6000)
    .fluidOutputs(fluid('water') * 7000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('tetrabromobisphenol_a_solution') * 6000)
    .outputs(metaitem('dustTetrabromobisphenolA'))
    .fluidOutputs(fluid('dichloroethane') * 6000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Curing agents
// Dicyanimide
BR.recipeBuilder()
    .inputs(ore('dustCalciumCyanamide') * 4)
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .outputs(metaitem('dustCalcite') * 5)
    .outputs(metaitem('dustCyanamide') * 5)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCyanamide') * 10)
    .notConsumable(fluid('sodium_hydroxide_solution') * 1000)
    .outputs(metaitem('dustDicyandiamide') * 10)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// 2-methylimidazole (Debus–Radziszewski imidazole synthesis)
LCR.recipeBuilder()
    .fluidInputs(fluid('gtfo_glyoxal') * 1000)
    .fluidInputs(fluid('ammonia') * 2000)
    .fluidInputs(fluid('gtfo_acetaldehyde') * 1000)
    .outputs(metaitem('dustTwoMethylimidazole') * 12)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustTwoMethylimidazole'))
    .inputs(ore('dustDicyandiamide') * 2)
    .inputs(ore('dustPhthalicAnhydride'))
    .outputs(metaitem('dustEpoxyCuringMixture'))
    .duration(20)
    .EUt(30)
    .buildAndRegister()

POLYMERIZATION.recipeBuilder()
    .inputs(ore('dustTetrabromobisphenolA') * 4)
    .fluidInputs(fluid('epichlorohydrin') * 4800)
    .inputs(ore('dustEpoxyCuringMixture'))
    .fluidInputs(fluid('sodium_hydroxide_solution') * 4000)
    .outputs(metaitem('dustWetFlameRetardantEpoxy') * 28)
    .fluidOutputs(fluid('diluted_saltwater') * 8000)
    .duration(100)
    .EUt(1920)
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustWetFlameRetardantEpoxy') * 7)
    .notConsumable(ore('springNichrome'))
    .outputs(metaitem('dustFlameRetardantEpoxy') * 7)
    .duration(25)
    .EUt(30)
    .buildAndRegister()

// Fiber reinforced epoxy

// E glass
MIXER.recipeBuilder()
    .inputs(ore('dustSiliconDioxide') * 3)
    .fluidInputs(fluid('sulfuric_acid') * 10)
    .outputs(metaitem('dustAcidWashedSiliconDioxide') * 3)
    .duration(10)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustAcidWashedSiliconDioxide') * 18)
    .inputs(ore('dustAlumina') * 5)
    .inputs(ore('dustBoronTrioxide') * 5)
    .inputs(ore('dustQuicklime') * 4)
    .outputs(metaitem('dustEGlass') * 10)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

EBF.recipeBuilder()
    .inputs(ore('dustEGlass'))
    .fluidOutputs(fluid('e_glass') * 144)
    .blastFurnaceTemp(1000)
    .EUt(120)
    .duration(10)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .notConsumable(ore('stickSteel'))
    .inputs(ore('wireFineKevlar'))
    .fluidInputs(fluid('e_glass') * 144)
    .outputs(metaitem('glass_fibers'))
    .EUt(120)
    .duration(10)
    .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
    .inputs(metaitem('glass_fibers'))
    .fluidInputs(fluid('flame_retardant_epoxy') * 144)
    .outputs(metaitem('epoxy_lamina'))
    .EUt(120)
    .duration(10)
    .buildAndRegister()

DRYER.recipeBuilder()
    .inputs(metaitem('epoxy_lamina'))
    .outputs(metaitem('plateReinforcedEpoxyResin'))
    .EUt(120)
    .duration(100)
    .buildAndRegister()

// SU-8 photoresist

// Bisphenol A Novolac Epoxy
POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('epoxy') * 1008)
    .fluidInputs(fluid('formaldehyde') * 3000)
    .outputs(metaitem('dustBisphenolANovolacEpoxy') * 7)
    .duration(100)
    .EUt(1920)
    .buildAndRegister()

// Propylene Carbonate
CSTR.recipeBuilder()
    .fluidInputs(fluid('propene') * 100)
    .fluidInputs(fluid('chlorine') * 100)
    .fluidInputs(fluid('water') * 50)
    .fluidOutputs(fluid('propylene_chlorohydrin') * 100)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCalciumHydroxide') * 5)
    .fluidInputs(fluid('propylene_chlorohydrin') * 2000)
    .fluidOutputs(fluid('propylene_oxide_solution') * 2000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('propylene_oxide_solution') * 2000)
    .outputs(metaitem('dustCalciumChloride') * 3)
    .fluidOutputs(fluid('water') * 2000)
    .fluidOutputs(fluid('propylene_oxide') * 2000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('propylene_oxide') * 50)
    .fluidInputs(fluid('carbon_dioxide') * 50)
    .fluidOutputs(fluid('propylene_carbonate') * 50)
    .duration(5)
    .EUt(30)
    .buildAndRegister()

// Triarylsulfonium Hexafluoroantimonate
BR.recipeBuilder()
    .inputs(ore('dustSulfur') * 2)
    .fluidInputs(fluid('chlorine') * 2000)
    .fluidOutputs(fluid('disulfur_dichloride') * 1000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('benzene') * 2000)
    .fluidInputs(fluid('disulfur_dichloride') * 1000)
    .outputs(metaitem('dustSulfur'))
    .outputs(metaitem('dustDiphenylSulfide'))
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(ore('dustAluminiumChloride'))
    .fluidInputs(fluid('benzene') * 2000)
    .fluidInputs(fluid('sulfur_dioxide') * 1000)
    .outputs(metaitem('dustDiphenylSulfoxide'))
    .duration(80)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidInputs(fluid('methane') * 8000)
    .fluidInputs(fluid('oleum') * 8000)
    .fluidOutputs(fluid('methanesulfonic_acid') * 8000)
    .duration(100)
    .EUt(480)
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(ore('dustAluminiumChloride'))
    .fluidInputs(fluid('benzene') * 2000)
    .fluidInputs(fluid('sulfur_dioxide') * 1000)
    .outputs(metaitem('dustDiphenylSulfoxide'))
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidInputs(fluid('methane') * 8000)
    .fluidInputs(fluid('oleum') * 8000)
    .fluidOutputs(fluid('methanesulfonic_acid') * 8000)
    .duration(100)
    .EUt(480)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPhosphorusPentoxide'))
    .fluidInputs(fluid('methanesulfonic_acid') * 4000)
    .fluidOutputs(fluid('sulfonium_preparation_mixture') * 4000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustDiphenylSulfoxide'))
    .inputs(ore('dustDiphenylSulfide'))
    .inputs(ore('dustSodiumHexafluoroantimonate') * 8)
    .notConsumable(fluid('sulfonium_preparation_mixture') * 28000)
    .outputs(metaitem('dustTriarylsulfoniumHexafluoroantimonate') * 52)
    .duration(100)
    .EUt(480)
    .buildAndRegister()

/*
Bisphenol-A Novolac Epoxy
    Average Molar Mass: 900 g/mol
    Percent Weight: 50%
Gamma-Butyrolactone
    Molar Mass: 86.090 g/mol
    Percent Weight: 45%
Propylene Carbonate
    Molar Mass: 102.089 g/mol
    Percent Weight: 2.5%
Triarylsulfonium Hexafluoroantimonate
    Molar Mass: 607.29 g/mol
    Percent Weight: 2.5%

Assume 100g of material.
    50g Novolac
    45g Gamma Butyrolactone
    2.5g Propylene Carbonate
    2.5g Triarylsulfonium Hexafluoroantimonate

    55.6 mmol Bisphenol-A Novolac Epoxy
    523 mmol Gamma-Butyrolactone
    24.5 mmol Propylene Carbonate
    4.12 mmol Triarylsulfonium Hexafluoroantimonate

Total: 607.22 mmol.
    9.16% Bisphenol-A Novolac Epoxy
    86.1% Gamma-Butyrolactone
    4.03% Propylene Carbonate
    0.678% Triarylsulfonium Hexafluoroantimonate
*/

LCR.recipeBuilder()
    .inputs(ore('dustTriarylsulfoniumHexafluoroantimonate') * 26)
    .inputs(ore('dustBisphenolANovolacEpoxy') * 47)
    .fluidInputs(fluid('propylene_carbonate') * 3000)
    .fluidInputs(fluid('gamma_butyrolactone') * 63500)
    .fluidOutputs(fluid('su_eight') * 66500)
    .duration(670)
    .EUt(1920)
    .buildAndRegister()