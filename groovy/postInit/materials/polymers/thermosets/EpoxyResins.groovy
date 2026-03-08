import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// Fiber-Reinforced Epoxy Resin Sheet * 1
mods.gregtech.chemical_bath.removeByInput(16, [metaitem('wireFineBorosilicateGlass')], [fluid('epoxy') * 144])
// Fiber-Reinforced Epoxy Resin Sheet * 1
mods.gregtech.chemical_bath.removeByInput(16, [metaitem('carbon.fibers')], [fluid('epoxy') * 144])

// Curing agents
record CuringAgent (
    String name,
    boolean liquid,
    int amount_required,
    double duration
) {}

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
    .notConsumable(metaitem('beads.strong_acidic_cation_exchange'))
    .fluidOutputs(fluid('water') * 1000)
    .outputs(metaitem('dustBisphenolA'))
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

EXTRACTOR.recipeBuilder()
    .inputs(ore('dustBisphenolA'))
    .fluidOutputs(fluid('bisphenol_a') * 1000)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

// Unmodified DGEBA

for (curingAgent in curingAgents) {
    if (curingAgent.liquid) {
        POLYMERIZATION_TANK.recipeBuilder()
            .inputs(ore('dustBisphenolA'))
            .fluidInputs(fluid('epichlorohydrin') * 1200) //excess epichlorohydrin to control degree of polymerization
            .fluidInputs(fluid(curingAgent.name) * curingAgent.amount_required)
            .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
            .outputs(metaitem('dustWetEpoxy') * 2)
            .fluidOutputs(fluid('diluted_salt_water') * 2000)
            .duration((int) (100 * curingAgent.duration))
            .EUt(VA[HV])
            .buildAndRegister()
    } else {
        POLYMERIZATION_TANK.recipeBuilder()
            .inputs(ore('dustBisphenolA') * 4)
            .fluidInputs(fluid('epichlorohydrin') * 4800)
            .inputs(ore(curingAgent.name) * curingAgent.amount_required)
            .fluidInputs(fluid('sodium_hydroxide_solution') * 4000)
            .outputs(metaitem('dustWetEpoxy') * 8)
            .fluidOutputs(fluid('diluted_salt_water') * 8000)
            .duration((int) (100 * curingAgent.duration))
            .EUt(VA[HV])
            .buildAndRegister()
    }
}

VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustWetEpoxy') * 8)
    .notConsumable(ore('springNichrome'))
    .outputs(metaitem('dustEpoxy') * 8)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

// Flame retardant DGEBA
    // Catalyst preparation
    BR.recipeBuilder()
        .inputs(ore('dustAluminiumHydroxide') * 7)
        .fluidInputs(fluid('hydrochloric_acid') * 3000)
        .fluidOutputs(fluid('aluminium_chloride_solution') * 3000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustNickelChloride') * 9)
        .inputs(ore('dustAluminiumChloride') * 4)
        .fluidInputs(fluid('deionized_water') * 4000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 8000)
        .outputs(metaitem('dustNickelHydrotalcite'))
        .fluidOutputs(fluid('salt_water') * 8000)
        .duration(100)
        .EUt(VA[HV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustNickelHydrotalcite'))
        .fluidInputs(fluid('sodium_tungstate_solution') * 100)
        .outputs(metaitem('dustBisphenolBrominationCatalyst'))
        .fluidOutputs(fluid('wastewater') * 100)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    // Bromination
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
        .EUt(VA[LV])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustBisphenolA'))
        .notConsumable(ore('dustBisphenolBrominationCatalyst'))
        .fluidInputs(fluid('one_two_dichloroethane') * 6000)
        .fluidInputs(fluid('hydrogen_peroxide_solution') * 2000)
        .fluidInputs(fluid('bromine') * 4000)
        .fluidOutputs(fluid('impure_brominated_bisphenol_emulsion') * 10000)
        .duration(160)
        .EUt(VA[EV])
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('impure_brominated_bisphenol_solution') * 6000)
        .fluidInputs(fluid('diluted_sodium_sulfite_solution') * 7000)
        .fluidOutputs(fluid('tetrabromobisphenol_a_solution') * 6000)
        .fluidOutputs(fluid('water') * 7000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('tetrabromobisphenol_a_solution') * 6000)
        .outputs(metaitem('dustTetrabromobisphenolA'))
        .fluidOutputs(fluid('one_two_dichloroethane') * 6000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    POLYMERIZATION_TANK.recipeBuilder()
        .inputs(ore('dustTetrabromobisphenolA') * 4)
        .fluidInputs(fluid('epichlorohydrin') * 4800)
        .inputs(ore('dustEpoxyCuringMixture'))
        .fluidInputs(fluid('sodium_hydroxide_solution') * 4000)
        .outputs(metaitem('dustWetFlameRetardantEpoxy') * 8)
        .fluidOutputs(fluid('diluted_salt_water') * 8000)
        .duration(100)
        .EUt(VA[EV])
        .buildAndRegister()

    VACUUM_CHAMBER.recipeBuilder()
        .inputs(ore('dustWetFlameRetardantEpoxy') * 8)
        .notConsumable(ore('springNichrome'))
        .outputs(metaitem('dustFlameRetardantEpoxy') * 8)
        .duration(30)
        .EUt(VA[HV])
        .buildAndRegister()

// Epoxy Cresol Novolacs (ECN)

BR.recipeBuilder()
    .fluidInputs(fluid('epichlorohydrin') * 1000)
    .fluidInputs(fluid('cresol_novolacs_oligomer') * 1000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .outputs(metaitem('dustWetEpoxyCresolNovolacs'))
    .fluidOutputs(fluid('hydrochloric_acid') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustWetEpoxyCresolNovolacs'))
    .notConsumable(ore('springCupronickel'))
    .outputs(metaitem('dustEpoxyCresolNovolacs'))
    .duration(25)
    .EUt(VA[LV])
    .buildAndRegister()

// Fiber reinforced epoxy
    // E glass
    MIXER.recipeBuilder()
        .inputs(ore('dustSiliconDioxide') * 3)
        .fluidInputs(fluid('sulfuric_acid') * 10)
        .outputs(metaitem('dustAcidWashedSiliconDioxide') * 3)
        .duration(10)
        .EUt(VA[LV])
        .buildAndRegister()

    MIXER.recipeBuilder()
        .inputs(ore('dustAcidWashedSiliconDioxide') * 18)
        .inputs(ore('dustAlumina') * 5)
        .inputs(ore('dustBoronTrioxide') * 5)
        .inputs(ore('dustQuicklime') * 4)
        .outputs(metaitem('dustEGlass') * 10)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    CENTRIFUGE.recipeBuilder()
        .notConsumable(ore('stickSteel'))
        .inputs(ore('fiberKevlar'))
        .fluidInputs(fluid('e_glass') * 144)
        .outputs(metaitem('glass_fibers'))
        .EUt(VA[MV])
        .duration(10)
        .buildAndRegister()

    // Curing
    CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('glass_fibers'))
        .fluidInputs(fluid('flame_retardant_epoxy') * 144)
        .outputs(metaitem('board.epoxy.prepreg'))
        .EUt(VA[MV])
        .duration(10)
        .buildAndRegister()
            
    CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('glass_fibers'))
        .fluidInputs(fluid('epoxy') * 144)
        .outputs(metaitem('plateReinforcedEpoxyResin'))
        .EUt(VA[MV])
        .duration(160)
        .buildAndRegister()

// Cycloaliphatic Epoxy Resins

CSTR.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .fluidInputs(fluid('acrolein') * 50)
    .fluidInputs(fluid('butadiene') * 50)
    .fluidOutputs(fluid('tetrahydrobenzaldehyde') * 50)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

LCR.recipeBuilder()
    .notConsumable(fluid('sodium_hydroxide_solution') * 1000)
    .fluidInputs(fluid('tetrahydrobenzaldehyde') * 2000)
    .fluidInputs(fluid('peracetic_acid_solution') * 4000)
    .fluidOutputs(fluid('epoxycyclohexane_carboxylate') * 1000)
    .fluidOutputs(fluid('diluted_acetic_acid') * 4000)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()
