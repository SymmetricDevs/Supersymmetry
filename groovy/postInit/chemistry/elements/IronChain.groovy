import static globals.Globals.*
import static globals.CarbonGlobals.*

//RECIPE REMOVALS
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

class Blastable {
    String name
    int amount_required
    int amount_produced
    //In liters
    int reductant_required
    int duration

    Blastable(name, amount_required, amount_produced, reductant_required, duration) {
        this.name = name
        this.amount_required = amount_required
        this.amount_produced = amount_produced
        this.reductant_required = reductant_required
        this.duration = duration
    }
}

class Reductant {
    String name
    String byproduct
    int amount_required
    int byproduct_amount
    Reductant(name, byproduct, amount_required, byproduct_amount) {
        this.name = name
        this.byproduct = byproduct
        this.amount_required = 1000 * amount_required
        this.byproduct_amount = 1000 * byproduct_amount
    }
}

def PBF_RECIPES = recipemap("primitive_blast_furnace")
def EBF_RECIPES = recipemap("electric_blast_furnace")

def blastables = [
    new Blastable('dustMagnetite', 2, 6, 4, 80),
    new Blastable('dustBandedIron', 2, 4, 3, 80),
    new Blastable('dustHematite', 2, 4, 3, 80),
    new Blastable('dustIronIiiOxide', 5, 2, 3, 20),
    new Blastable('dustIronIiOxide', 2, 1, 1, 20),
    new Blastable('dustGraniticMineralSand', 2, 6, 4, 80),
    new Blastable('oreIron', 2, 2, 2, 60),
    new Blastable('oreMagnetite', 1, 3, 4, 60),
    new Blastable('oreBandedIron', 1, 2, 3, 60),
    new Blastable('oreNetherrackMagnetite', 1, 6, 4, 60),
    new Blastable('oreNetherrackBandedIron', 1, 4, 3, 60),
    new Blastable('oreEndstoneMagnetite', 1, 6, 4, 60),
    new Blastable('oreEndstoneBandedIron', 1, 4, 3, 60)
]

def reductants = [
    new Reductant('carbon_monoxide', 'carbon_dioxide', 1, 1),
    new Reductant('hydrogen', 'steam', 2, 1)
]

def combustibles = CarbonGlobals.combustibles()

for (blastable in blastables) {
    for (combustible in combustibles) {
        //BESSEMER PROCESS
        PBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .inputs(ore(combustible.name) * (combustible.equivalent(1) * blastable.reductant_required))
        .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
        .outputs(metaitem(combustible.byproduct) * (combustible.equivalent(1) * blastable.reductant_required))
        .duration((int) (combustible.duration * blastable.amount_produced * blastable.duration))
        .buildAndRegister()

        //MODERN BLAST FURNACE
        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .inputs(ore(combustible.name) * (combustible.equivalent(1) * blastable.reductant_required))
        .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
        .outputs(metaitem(combustible.byproduct) * (combustible.equivalent(1) * blastable.reductant_required))
        .duration((int) (combustible.duration * blastable.amount_produced * blastable.duration / 2))
        .blastFurnaceTemp(1750)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
    }

    //DIRECT REDUCED IRON
    for (reductant in reductants) {
        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .fluidInputs(fluid(reductant.name) * (blastable.reductant_required * reductant.amount_required))
        .outputs(item('minecraft:iron_ingot') * blastable.amount_produced)
        .chancedOutput(metaitem('dustSiliconDioxide'), 5000, 0)
        .fluidOutputs(fluid(reductant.byproduct) * (blastable.reductant_required * reductant.byproduct_amount))
        .duration((int) (blastable.amount_produced * blastable.duration / 4))
        .circuitMeta(1)
        .blastFurnaceTemp(1750)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .fluidInputs(fluid(reductant.name) * (blastable.reductant_required * reductant.amount_required))
        .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
        .fluidOutputs(fluid(reductant.byproduct) * (blastable.reductant_required * reductant.byproduct_amount))
        .duration((int)(blastable.amount_produced * blastable.duration / 4))
        .blastFurnaceTemp(1750)
        .circuitMeta(2)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()
    }
}

furnace.add(metaitem('dustBrownLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('dustYellowLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('ingotWroughtIron'), item('minecraft:iron_ingot'))

//Deleting old Steel Dust -> Steel Ingot recipe
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSteel')], null)
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSteelMagnetic')], null)


//Readding Steel Dust -> Steel Ingot recipe

EBF_RECIPES.recipeBuilder()
		.inputs(ore('dustSteel'))
		.outputs(metaitem('ingotSteel'))
		.duration(60)
		.blastFurnaceTemp(1750)
		.EUt(60)
		.buildAndRegister()
EBF_RECIPES.recipeBuilder()
		.inputs(ore('dustSteelMagnetic'))
		.outputs(metaitem('ingotSteel'))
		.duration(60)
		.blastFurnaceTemp(1750)
		.EUt(60)
		.buildAndRegister()

//SLAG REMOVAL BY HAMMER
crafting.addShapeless('pig_iron_shearing', metaitem('ingotWroughtIron'), [
    ore('craftingToolHardHammer'),
    metaitem('ingotPigIron')
])

def FORGE_HAMMER = recipemap('forge_hammer')

FORGE_HAMMER.recipeBuilder()
.inputs(ore('ingotPigIron'))
.outputs(metaitem('ingotWroughtIron'))
.duration(20)
.EUt(Globals.voltAmps[0])
.buildAndRegister()

//BASIC OXYGEN PROCESS
EBF_RECIPES.recipeBuilder()
.inputs(ore('ingotPigIron'))
.fluidInputs(fluid('oxygen') * 50)
.outputs(metaitem('ingotSteel'))
.blastFurnaceTemp(1750)
.EUt(Globals.voltAmps[1])
.duration(10)
.circuitMeta(1)
.buildAndRegister()

EBF_RECIPES.recipeBuilder()
.inputs(ore('ingotPigIron'))
.fluidInputs(fluid('oxygen') * 50)
.outputs(item('minecraft:iron_ingot'))
.blastFurnaceTemp(1750)
.EUt(Globals.voltAmps[1])
.duration(10)
.circuitMeta(2)
.buildAndRegister()

//CEMENTED STEEL

for (combustible in combustibles) {
    PBF_RECIPES.recipeBuilder()
    .inputs(item('minecraft:iron_ingot'))
    .inputs(ore(combustible.name) * combustible.equivalent(1))
    .outputs(metaitem('ingotSteel'))
    .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
    .duration(combustible.duration * 120)
    .buildAndRegister()

    PBF_RECIPES.recipeBuilder()
    .inputs(ore('ingotWroughtIron'))
    .inputs(ore(combustible.name) * combustible.equivalent(1))
    .outputs(metaitem('ingotSteel'))
    .outputs(metaitem(combustible.byproduct) * combustible.equivalent(1))
    .duration(combustible.duration * 60)
    .buildAndRegister()
}

//High Purity Iron Chain

RF = recipemap('reaction_furnace')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')

RF.recipeBuilder()
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
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('iron_pentacarbonyl') * 1000)
    .outputs(metaitem('dustHighPurityIron'))
    .fluidOutputs(fluid('carbon_monoxide') * 5000)
    .duration(300)
    .EUt(30)
	.buildAndRegister()

EBF_RECIPES.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustAnyPurityIron'))
        .outputs(item('minecraft:iron_ingot'))
        .duration(60)
        .blastFurnaceTemp(1750)
        .EUt(60)
        .buildAndRegister()

//HYDROXIDE PROCESSING
def ROASTER = recipemap('roaster')

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiiHydroxide') * 14)
    .outputs(metaitem('dustIronIiiOxide') * 5)
    .fluidOutputs(fluid('steam') * 3000)
    .duration(80)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustIronIiHydroxide') * 5)
    .outputs(metaitem('dustIronIiOxide') * 2)
    .fluidOutputs(fluid('steam') * 1000)
    .EUt(Globals.voltAmps[1])
    .duration(200)
    .buildAndRegister()
