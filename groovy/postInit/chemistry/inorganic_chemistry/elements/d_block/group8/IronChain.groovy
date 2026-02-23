import static prePostInit.Recipemaps.*
import globals.Carbons
import static gregtech.api.GTValues.*

// Pyrometallurgical processing

// Removals
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCoke')], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('gemCoke')], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), item('minecraft:coal') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCoal') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCharcoal') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), item('minecraft:coal', 1) * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('dustCoke')], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('gemCoke')], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('dustCoal') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('dustCharcoal') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), item('minecraft:coal') * 2], null)
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), item('minecraft:coal', 1) * 2], null)
mods.gregtech.electric_blast_furnace.removeByInput(120, [item('minecraft:iron_ingot')], [fluid('oxygen') * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustIron'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('oxygen') * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('ingotWroughtIron')], [fluid('oxygen') * 200])
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustWroughtIron'), metaitem('circuit.integrated').withNbt(["Configuration": 2])], [fluid('oxygen') * 200])
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustIron') * 4, metaitem('dustCarbon')], null)
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('dustWroughtIron') * 4, metaitem('dustCarbon')], null)

// Should replace inner classes with closures if possible
record BlastableIron(
    String name,
    int amount_required,
    int amount_produced,
    //In liters
    int reductant_required,
    int duration) {}

// Should replace inner classes with closures if possible
class ReductantIron {
    String name
    String byproduct
    int amount_required
    int byproduct_amount

    ReductantIron(name, byproduct, amount_required, byproduct_amount) {
        this.name = name
        this.byproduct = byproduct
        this.amount_required = 1000 * amount_required
        this.byproduct_amount = 1000 * byproduct_amount
    }
}

class ReductantCarbon {
    String name
    int consumption
    float duration_multiplier
    ReductantCarbon(String name, int consumption, float multiplier) {
        this.name = name
        this.consumption = consumption
        this.duration_multiplier = multiplier
    }
}


def blastables = [
    new BlastableIron('dustMagnetite', 2, 6, 4, 80),
    new BlastableIron('dustBandedIron', 2, 4, 3, 80),
    new BlastableIron('dustHematite', 2, 4, 3, 80),
    new BlastableIron('dustIronIiiOxide', 5, 2, 3, 20),
    new BlastableIron('dustIronIiOxide', 2, 1, 1, 20),
    new BlastableIron('dustGraniticMineralSand', 2, 6, 4, 80),
    new BlastableIron('oreIron', 2, 2, 2, 60),
    new BlastableIron('oreMagnetite', 1, 3, 4, 60),
    new BlastableIron('oreBandedIron', 1, 2, 3, 60),
    new BlastableIron('oreNetherrackMagnetite', 1, 6, 4, 60),
    new BlastableIron('oreNetherrackBandedIron', 1, 4, 3, 60),
    new BlastableIron('oreEndstoneMagnetite', 1, 6, 4, 60),
    new BlastableIron('oreEndstoneBandedIron', 1, 4, 3, 60)
]

def reductants = [
    new ReductantIron('carbon_monoxide', 'carbon_dioxide', 1, 1),
    new ReductantIron('hydrogen', 'dense_steam', 2, 1)
]

furnace.add(metaitem('dustBrownLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('dustYellowLimonite'), metaitem('dustBandedIron'))

// Primary reduction

for (blastable in blastables) {
    for (combustible in Carbons.combustibles()) {
        // Bessemer process
        PBF.recipeBuilder()
            .inputs(ore(blastable.name) * blastable.amount_required)
            .inputs(ore(combustible.name) * (combustible.equivalent(1) * blastable.reductant_required))
            .inputs(ore('dustSmallLimestone'))
            .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
            .outputs(metaitem(combustible.byproduct) * (combustible.equivalent(1) * blastable.reductant_required))
            .duration((int) (combustible.duration * blastable.amount_produced * blastable.duration))
            .buildAndRegister()

        // Modern blast furnace
        ERF.recipeBuilder()
            .inputs(ore(blastable.name) * blastable.amount_required)
            .inputs(ore(combustible.name) * (combustible.equivalent(1) * blastable.reductant_required))
            .inputs(ore('dustSmallLimestone'))
            .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
            .outputs(metaitem(combustible.byproduct) * (combustible.equivalent(1) * blastable.reductant_required))
            .duration((int) (combustible.duration * blastable.amount_produced * blastable.duration / 2))
            .blastFurnaceTemp(1750)
            .EUt(VA[LV])
            .buildAndRegister()
    }

    // Direct reduced iron
    for (reductant in reductants) {
        ERF.recipeBuilder()
            .inputs(ore(blastable.name) * blastable.amount_required)
            .fluidInputs(fluid(reductant.name) * (blastable.reductant_required * reductant.amount_required))
            .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
            .fluidOutputs(fluid(reductant.byproduct) * (blastable.reductant_required * reductant.byproduct_amount))
            .duration((int)(blastable.amount_produced * blastable.duration / 4))
            .blastFurnaceTemp(1750)
            .circuitMeta(2)
            .EUt(VA[HV])
            .buildAndRegister()
    }
}

// Refining processes

    // Slag removal via hammer
    crafting.addShapeless('pig_iron_shearing', metaitem('ingotWroughtIron'), [
        ore('craftingToolHardHammer'),
        metaitem('ingotPigIron')
    ])

    FORGE_HAMMER.recipeBuilder()
        .inputs(ore('ingotPigIron'))
        .outputs(metaitem('ingotWroughtIron'))
        .duration(60)
        .EUt(VA[ULV])
        .buildAndRegister()

    // Puddling
    for (combustible in Carbons.combustibles()) {
        REVERBERATORY_FURNACE.recipeBuilder()
            .inputs(ore('ingotPigIron') * 16)
            .inputs(ore(combustible.name) * combustible.equivalent(1))
            .outputs(metaitem('ingotWroughtIron') * 16)
            .duration(80)
            .buildAndRegister()
    }

    // Cemented steel
    for (combustible in Carbons.combustibles()) {
        PBF.recipeBuilder()
            .inputs(item('minecraft:iron_ingot'))
            .inputs(ore(combustible.name) * combustible.equivalent(1))
            .outputs(metaitem('ingotSteel'))
            .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
            .duration(combustible.duration * 120)
            .buildAndRegister()

        PBF.recipeBuilder()
            .inputs(ore('ingotWroughtIron'))
            .inputs(ore(combustible.name) * combustible.equivalent(1))
            .outputs(metaitem('ingotSteel'))
            .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
            .duration(combustible.duration * 60)
            .info('recipe.steel.production')
            .buildAndRegister()
    }

    // Basic oxygen process
    ERF.recipeBuilder()
        .inputs(ore('ingotPigIron') * 10)
        .inputs(ore('dustQuicklime'))
        .fluidInputs(fluid('oxygen') * 500)
        .outputs(metaitem('ingotSteel') * 10)
        .blastFurnaceTemp(1750)
        .EUt(VA[LV])
        .duration(100)
        .circuitMeta(1)
        .buildAndRegister()

    ERF.recipeBuilder()
        .inputs(ore('ingotPigIron') * 10)
        .inputs(ore('dustQuicklime'))
        .fluidInputs(fluid('oxygen') * 500)
        .outputs(item('minecraft:iron_ingot') * 10)
        .blastFurnaceTemp(1750)
        .EUt(VA[LV])
        .duration(100)
        .circuitMeta(2)
        .buildAndRegister()

def carbon_reductants = [
        new ReductantCarbon("charcoal", 9, 1),
        new ReductantCarbon("gemCoal", 8, 1), // Standard consumption, 10 = 8 + 2
        new ReductantCarbon("gemLigniteCoke", 9, 1.2),
        new ReductantCarbon("fuelCoke", 6, 0.8),
        new ReductantCarbon("gemAnthracite", 6, 0.75),
        new ReductantCarbon("dustCharcoal", 9, 0.95),
        new ReductantCarbon("dustCoal", 8, 0.9),
        new ReductantCarbon("dustLigniteCoke", 9, 1),
        new ReductantCarbon("dustCoke", 6, 0.75),
        new ReductantCarbon("dustAnthracite", 6, 0.7)
]
    for (carbon_reductant in carbon_reductants) {
        //cast iron in cupola furnace; primitive age
        CUPOLA_FURNACE.recipeBuilder()
            .inputs(ore('ingotPigIron') * 8)
            .inputs(ore('dustSmallLimestone'))
            .inputs(ore(carbon_reductant.name) * carbon_reductant.consumption)
            .outputs(item('minecraft:iron_ingot') * 8)
            .duration((200 * carbon_reductant.duration_multiplier).toInteger())
            .buildAndRegister()
    }

    METALLURGICAL_CONVERTER.recipeBuilder()
        .inputs(ore('ingotPigIron') * 10)
        .inputs(ore('dustQuicklime'))
        .fluidInputs(fluid('oxygen') * 500)
        .fluidOutputs(fluid('molten.steel') * 1440)
        .EUt(VA[LV])
        .duration(100)
        .buildAndRegister()

// Continuous casting

ADVANCED_ARC_FURNACE.recipeBuilder()
    .circuitMeta(20)
    .inputs(ore('dustSteel') * 10)
    .fluidOutputs(fluid('molten.steel') * 1440)
    .EUt(VA[MV])
    .duration(10) // Give a good number of overclocks
    .buildAndRegister()

// Deleting old Steel Dust -> Steel Ingot recipe

mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSteel')], null)
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSteelMagnetic')], null)

// Readding Steel Dust -> Steel Ingot recipe

ERF.recipeBuilder()
    .inputs(ore('dustSteel'))
    .outputs(metaitem('ingotSteel'))
    .duration(60)
    .blastFurnaceTemp(1750)
    .EUt(60)
    .buildAndRegister()

ERF.recipeBuilder()
    .inputs(ore('dustSteelMagnetic'))
    .outputs(metaitem('ingotSteel'))
    .duration(60)
    .blastFurnaceTemp(1750)
    .EUt(60)
    .buildAndRegister()

// High purity iron

REACTION_FURNACE.recipeBuilder()
    .inputs(ore('dustIron'))
    .fluidInputs(fluid('carbon_monoxide') * 5000)
    .fluidOutputs(fluid('crude_iron_pentacarbonyl') * 1000)
    .duration(200)
    .EUt(60)
	.buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('crude_iron_pentacarbonyl') * 1000)
    .fluidOutputs(fluid('iron_pentacarbonyl') * 1000)
    .duration(300)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('iron_pentacarbonyl') * 1000)
    .outputs(metaitem('dustHighPurityIron'))
    .fluidOutputs(fluid('carbon_monoxide') * 5000)
    .duration(300)
    .EUt(VA[LV])
	.buildAndRegister()

ERF.recipeBuilder()
    .circuitMeta(1)
    .inputs(ore('dustAnyPurityIron'))
    .outputs(item('minecraft:iron_ingot'))
    .duration(60)
    .blastFurnaceTemp(1750)
    .EUt(60)
    .buildAndRegister()

// Fe(OH)2

BR.recipeBuilder()
    .fluidInputs(fluid('iron_ii_chloride_solution') * 2000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .outputs(metaitem('dustIronIiHydroxide') * 5)
    .fluidOutputs(fluid('diluted_salt_water') * 4000)
    .duration(100)
    .EUt(16)
    .buildAndRegister()

// FeCl2

BR.recipeBuilder()
    .inputs(ore('dustIron'))
    .fluidInputs(fluid('hydrochloric_acid') * 2000)
    .fluidOutputs(fluid('iron_ii_chloride_solution') * 2000)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .duration(100)
    .EUt(16)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustIronIiChloride') * 3)
    .fluidInputs(fluid('water') * 2000)
    .fluidOutputs(fluid('iron_ii_chloride_solution') * 2000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

// FeCl3

ROASTER.recipeBuilder()
    .fluidInputs(fluid('chlorine') * 1000)
    .inputs(ore('dustIronIiChloride') * 3)
    .outputs(metaitem('dustIronIiiChloride') * 4)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('chlorine') * 3000)
    .inputs(ore('dustAnyPurityIron'))
    .outputs(metaitem('dustIronIiiChloride') * 4)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('water') * 1000)
    .inputs(ore('dustIronIiiChloride') * 4)
    .fluidOutputs(fluid('iron_iii_chloride_solution') * 1000)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustIronIiiChloride') * 4)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 3000)
    .outputs(metaitem('dustIronIiiHydroxide') * 7)
    .fluidOutputs(fluid('salt_water') * 3000)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

// FeO

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiHydroxide') * 5)
    .outputs(metaitem('dustIronIiOxide') * 2)
    .fluidOutputs(fluid('dense_steam') * 1000)
    .EUt(VA[LV])
    .duration(200)
    .buildAndRegister()

// Fe3O4

ROASTER.recipeBuilder()
    .inputs(ore('dustIron') * 3)
    .fluidInputs(fluid('oxygen') * 4000)
    .outputs(metaitem('dustIronTwoThreeOxide') * 7)
    .duration(160)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('water') * 4000)
    .inputs(ore('dustIron') * 3)
    .outputs(metaitem('dustIronTwoThreeOxide') * 7)
    .fluidOutputs(fluid('hydrogen') * 8000)
    .duration(160)
    .EUt(60)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('water') * 4000)
    .inputs(ore('dustHighPurityIron') * 3)
    .outputs(metaitem('dustPurifiedIronTwoThreeOxide') * 7)
    .fluidOutputs(fluid('hydrogen') * 8000)
    .duration(160)
    .EUt(60)
    .buildAndRegister()

// Fe2O3

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiiHydroxide') * 14)
    .outputs(metaitem('dustIronIiiOxide') * 5)
    .fluidOutputs(fluid('dense_steam') * 3000)
    .duration(80)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 1000)
    .inputs(ore('dustIronTwoThreeOxide') * 14)
    .outputs(metaitem('dustIronIiiOxide') * 15)
    .duration(160)
    .EUt(60)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 1000)
    .inputs(ore('dustPurifiedIronTwoThreeOxide') * 14)
    .outputs(metaitem('dustPurifiedIronIiiOxide') * 15)
    .duration(160)
    .EUt(60)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustIronSulfate') * 12)
    .outputs(metaitem('dustIronIiiOxide') * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 1000)
    .fluidOutputs(fluid('sulfur_trioxide') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

// FeSO4

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .inputs(ore('dustIronIiSulfide') * 2)
    .outputs(metaitem('dustIronSulfate') * 6)
    .fluidOutputs(fluid('hydrogen_sulfide') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .inputs(ore('dustAnyPurityIron') * 1)
    .outputs(metaitem('dustIronSulfate') * 6)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

