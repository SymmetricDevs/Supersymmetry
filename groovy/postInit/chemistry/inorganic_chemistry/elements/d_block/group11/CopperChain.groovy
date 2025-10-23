import static prePostInit.Recipemaps.*
import globals.Carbons
import static gregtech.api.GTValues.*

// Cupric Oxide Dust * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustTetrahedrite')], [fluid('oxygen') * 3000])
// Cupric Oxide Dust * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustChalcopyrite'), metaitem('dustSiliconDioxide')], [fluid('oxygen') * 3000])

//MALACHITE
MIXER.recipeBuilder()
    .inputs(ore('dustImpureMalachite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_malachite_slurry') * 2000)
    .EUt(VA[HV])
    .duration(80)
    .buildAndRegister()

FROTH_FLOTATION.recipeBuilder()
    .fluidInputs(fluid('impure_malachite_slurry') * 2000)
    .notConsumable(metaitem('dustQuicklime'))
    .notConsumable(metaitem('dustPotassiumOctylHydroxamate'))
    .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
    .fluidOutputs(fluid('malachite_slurry') * 1000)
    .fluidOutputs(fluid('granite_tailing_slurry') * 1000)
    .EUt(VA[HV])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('malachite_slurry') * 1000)
    .outputs(metaitem('dustMalachite') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustMalachite'))
    .fluidInputs(fluid('sulfuric_acid') * 2000)
    .fluidOutputs(fluid('carbon_dioxide') * 1000)
    .fluidOutputs(fluid('malachite_leach') * 3000)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('malachite_leach') * 150)
    .fluidInputs(fluid('hydrogen_peroxide_solution') * 5)
    .fluidOutputs(fluid('oxidized_malachite_leach') * 150)
    .EUt(VA[LV])
    .duration(5)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('oxidized_malachite_leach') * 3000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 300)
    .chancedOutput(metaitem('dustIronIiiHydroxide') * 7, 1000, 0)
    .fluidOutputs(fluid('diluted_copper_sulfate_solution') * 3300)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_copper_sulfate_solution') * 3300)
    .outputs(metaitem('dustCopperSulfate') * 12)
    .fluidOutputs(fluid('water') * 3300)
    .circuitMeta(1)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('diluted_copper_sulfate_solution') * 3300)
    .fluidOutputs(fluid('copper_sulfate_solution') * 2000)
    .fluidOutputs(fluid('water') * 1300)
    .disableDistilleryRecipes()
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('malachite_leach') * 3000)
    .outputs(metaitem('dustCopperSulfate') * 8)
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000)
    .EUt(VA[LV])
    .duration(100)
    .buildAndRegister()

//SULFIDIC COPPER ORES

class CopperOre {
    String name
    int amount_produced
    boolean produces_iron

    CopperOre(name, amount_produced, produces_iron) {
        this.name = name
        this.amount_produced = amount_produced
        this.produces_iron = produces_iron
    }
}

def copperOres = [
    new CopperOre('Chalcopyrite', 1, true),
    new CopperOre('Bornite', 5, true),
    new CopperOre('Chalcocite', 2, false)
]

for (copperOre in copperOres) {
    MIXER.recipeBuilder()
        .inputs(ore('dustImpure' + copperOre.name) * 8)
        .fluidInputs(fluid('distilled_water') * ((copperOre.amount_produced * 1000) + 1000))
        .fluidOutputs(fluid('impure_' + copperOre.name.toLowerCase() + '_slurry') * ((copperOre.amount_produced * 1000) + 1000))
        .EUt(VA[HV])
        .duration(80)
        .buildAndRegister()

    if (copperOre.produces_iron) {
        FROTH_FLOTATION.recipeBuilder()
            .fluidInputs(fluid('impure_' + copperOre.name.toLowerCase() + '_slurry') * ((copperOre.amount_produced * 1000) + 1000))
            .notConsumable(metaitem('dustQuicklime'))
            .notConsumable(metaitem('dustSodiumEthylXanthate'))
            .notConsumable(fluid('sodium_cyanide_solution') * 100)
            .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
            .fluidOutputs(fluid('copper_concentrate_slurry') * (copperOre.amount_produced * 1000))
            .fluidOutputs(fluid('pyrite_slurry') * 1000)
            .EUt(VA[HV])
            .duration(80)
            .buildAndRegister()

    } else {
        FROTH_FLOTATION.recipeBuilder()
            .fluidInputs(fluid('impure_' + copperOre.name.toLowerCase() + '_slurry') * ((copperOre.amount_produced * 1000) + 1000))
            .notConsumable(metaitem('dustQuicklime'))
            .notConsumable(metaitem('dustSodiumEthylXanthate'))
            .notConsumable(fluid('sodium_cyanide_solution') * 100)
            .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
            .fluidOutputs(fluid('copper_concentrate_slurry') * (copperOre.amount_produced * 1000))
            .fluidOutputs(fluid('granite_tailing_slurry') * 1000)
            .EUt(VA[HV])
            .duration(80)
            .buildAndRegister()
    }
}

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('copper_concentrate_slurry') * 1000)
    .outputs(metaitem('dustCopperConcentrate') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('pyrite_slurry') * 1000)
    .outputs(metaitem('dustPyrite') * 2)
    .fluidOutputs(fluid('wastewater') * 1000)
    .EUt(VA[LV])
    .duration(20)
    .buildAndRegister()

for (combustible in Carbons.combustibles()) {
    REVERBERATORY_FURNACE.recipeBuilder()
        .inputs(ore('dustCopperConcentrate') * 4)
        .inputs(ore(combustible.name) * combustible.equivalent(1))
        .chancedOutput(metaitem('dustCopperMatte') * 4, 9000, 0)
        .duration(320)
        .buildAndRegister()
    }

ERF.recipeBuilder()
    .inputs(ore('dustCopperConcentrate'))
    .notConsumable(item('gregtech:fluid_pipe_tiny', 323) * 2)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidInputs(fluid('natural_gas') * 50)
    .outputs(metaitem('dustCopperMatte'))
    .fluidOutputs(fluid('copper_matte_flue_gas') * 500)
    .blastFurnaceTemp(1200)
    .EUt(VA[HV])
    .duration(10)
    .buildAndRegister()

METALLURGICAL_CONVERTER.recipeBuilder()
    .inputs(ore('dustCopperConcentrate') * 10)
    .notConsumable(item('gregtech:fluid_pipe_small', 323) * 2)
    .fluidInputs(fluid('oxygen') * 5000)
    .fluidInputs(fluid('natural_gas') * 5000)
    .outputs(metaitem('dustCopperMatte') * 10)
    .fluidOutputs(fluid('copper_matte_flue_gas') * 5000)
    .EUt(VA[HV])
    .duration(100)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .inputs(ore('dustCalcite') * 5)
    .fluidInputs(fluid('copper_matte_flue_gas') * 3000)
    .outputs(metaitem('dustCalciumSulfite') * 5)
    .fluidOutputs(fluid('desulfurized_flue_gas') * 2000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustCopperMatte'))
    .fluidInputs(fluid('oxygen') * 2000)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .outputs(metaitem('dustCopperMatteFlue'))
    .outputs(metaitem('ingotBlisterCopper'))
    .EUt(VA[HV])
    .duration(10)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .inputs(ore('dustCopperMatteFlue'))
    .chancedOutput(metaitem('dustArsenicTrioxide'), 1000, 0)
    .chancedOutput(metaitem('dustAntimonyTrioxide'), 1000, 0)
    .chancedOutput(metaitem('dustBismuthIiiOxide'), 1000, 0)
    .chancedOutput(metaitem('dustTinIvOxide'), 1000, 0)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('plateBlisterCopper') * 4)
    .notConsumable(metaitem('plateStainlessSteel') * 4)
    .notConsumable(fluid('copper_sulfate_solution') * 1000)
    .fluidInputs(fluid('diluted_sulfuric_acid') * 320)
    .outputs(metaitem('dustCopper') * 4)
    .chancedOutput(metaitem('anode_slime.copper'), 1000, 0)
    .fluidOutputs(fluid('nickel_sulfate_solution') * 160)
    .EUt(VA[HV])
    .duration(40)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('copper_matte_flue_gas') * 1000)
    .notConsumable(metaitem('item_filter'))
    .outputs(metaitem('dustCopperMatteFlue'))
    .fluidOutputs(fluid('flue_gas') * 1000)
    .EUt(VA[HV])
    .duration(10)
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .inputs(ore('dustCopperMatteFlue'))
    .chancedOutput(metaitem('dustZincOxide') * 2, 2000, 0)
    .chancedOutput(metaitem('dustMassicot') * 2, 2000, 0)
    .chancedOutput(metaitem('dustCassiterite') * 2, 2000, 0)
    .EUt(VA[HV])
    .duration(10)
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('dustCopperSulfate') * 6)
    .notConsumable(metaitem('stickCopper'))
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('water') * 2000)
    .outputs(metaitem('dustCopper'))
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 2000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(240)
    .EUt(VA[MV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustCopperISulfide') * 3)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustCopper') * 2)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .EUt(VA[MV])
    .duration(80)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustCopperIiSulfide') * 2)
    .fluidInputs(fluid('oxygen') * 2000)
    .outputs(metaitem('dustCopper'))
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .EUt(VA[MV])
    .duration(80)
    .buildAndRegister()
