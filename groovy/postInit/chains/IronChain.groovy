import static globals.Globals.*


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

class Combustible {
    String name
    String byproduct
    int amount_required
    int duration
    Combustible(name, amount_required, duration, byproduct = 'dustTinyDarkAsh') {
        this.name = name
        this.amount_required = amount_required
        this.duration = duration
        this.byproduct = byproduct
    }
}

def PBF_RECIPES = recipemap("primitive_blast_furnace")
def EBF_RECIPES = recipemap("electric_blast_furnace")

def blastables = [
    new Blastable('dustMagnetite', 7 , 6, 4, 80),
    new Blastable('dustBandedIron', 5 , 4, 3, 80),
    new Blastable('dustIronIiiOxide', 5, 4, 3, 80),
    new Blastable('dustIronIiOxide', 2, 2, 1, 20),
    new Blastable('dustGraniticMineralSand', 14, 6, 4, 80),
    new Blastable('oreIron', 3, 2, 2, 60),
    new Blastable('oreMagnetite', 7, 3, 4, 60),
    new Blastable('oreBandedIron', 5, 2, 3, 60),
    new Blastable('oreNetherrackMagnetite', 7, 6, 4, 60),
    new Blastable('oreNetherrackBandedIron', 5, 4, 3, 60),
    new Blastable('oreEndstoneRackMagnetite', 7, 6, 4, 60),
    new Blastable('oreEndstoneBandedIron', 5, 4, 3, 60)
]

def reductants = [
    new Reductant('carbon_monoxide', 'carbon_dioxide', 1, 1),
    new Reductant('hydrogen', 'steam', 2, 1)
]

def combustibles = [
    new Combustible('gemCoke', 1, 3, 'dustTinyAsh'),
    new Combustible('dustCoke', 1, 3, 'dustTinyAsh'),
    new Combustible('gemAnthracite', 1, 2, 'dustTinyAsh'),
    new Combustible('dustAnthracite', 1, 2, 'dustTinyAsh'),
    new Combustible('gemCoal', 2, 4),
    new Combustible('dustCoal', 2, 4),
    new Combustible('gemCharcoal', 2, 4),
    new Combustible('dustCharcoal', 2, 4)
]


for (blastable in blastables) {
    for (combustible in combustibles) {
        //BESSEMER PROCESS
        PBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .inputs(ore(combustible.name) * (combustible.amount_required * blastable.reductant_required))
        .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
        .outputs(metaitem(combustible.byproduct) * (combustible.amount_required * blastable.reductant_required))
        .duration(combustible.duration * blastable.amount_produced * blastable.duration)
        .buildAndRegister()

        //MODERN BLAST FURNACE
        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .inputs(ore(combustible.name) * (combustible.amount_required * blastable.reductant_required))
        .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
        .outputs(metaitem(combustible.byproduct) * (combustible.amount_required * blastable.reductant_required))
        .duration(intValue(combustible.duration * blastable.amount_produced * blastable.duration / 2))
        .blastFurnaceTemp(1750)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
    }

    //DIRECT REDUCED IRON
    for (reductant in reductants) {
        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .fluidInputs(fluid(reductant.name) * (blastable.reductant_required * reductant.amount_required))
        .outputs(metaitem('ingotIron') * blastable.amount_produced)
        .chancedOutput(metaitem('dustSiliconDioxide'), 5000, 0)
        .fluidOutputs(fluid(reductant.byproduct) * (blastable.reductant_required * reductant.byproduct_amount))
        .duration((int) (blastable.amount_produced * blastable.duration / 4))
        .notConsumable(Globals.circuit(1))
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
        .notConsumable(Globals.circuit(2))
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()
    }
}

furnace.add(metaitem('dustBrownLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('dustYellowLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('ingotWroughtIron'), item('minecraft:iron_ingot'))

//SLAG REMOVAL BY HAMMER
crafting.addShapeless('hammer_pig_iron',metaitem('ingotWroughtIron'), [
    ore('craftingToolHardHammer'),
    metaitem('ingotPigIron'),
])

def FORGE_HAMMER = recipemap('forge_hammer')

FORGE_HAMMER.recipeBuilder()
.inputs(metaitem('ingotPigIron'))
.outputs(metaitem('ingotWroughtIron'))
.duration(20)
.EUt(Globals.voltAmps[0])
.buildAndRegister()

//BASIC OXYGEN PROCESS
EBF_RECIPES.recipeBuilder()
.inputs(metaitem('ingotPigIron'))
.fluidInputs(fluid('oxygen') * 50)
.outputs(metaitem('ingotSteel'))
.blastFurnaceTemp(1750)
.EUt(Globals.voltAmps[1])
.duration(10)
.notConsumable(Globals.circuit(1))
.buildAndRegister()

EBF_RECIPES.recipeBuilder()
.inputs(metaitem('ingotPigIron'))
.fluidInputs(fluid('oxygen') * 50)
.outputs(metaitem('ingotIron'))
.blastFurnaceTemp(1750)
.EUt(Globals.voltAmps[1])
.duration(10)
.notConsumable(Globals.circuit(2))
.buildAndRegister()

//CEMENTED STEEL
for (combustible in combustibles) {
    PBF_RECIPES.recipeBuilder()
    .inputs(item('minecraft:iron_ingot'))
    .inputs(ore(combustible.name) * combustible.amount_required)
    .outputs(metaitem('ingotSteel'))
    .outputs(metaitem(combustible.byproduct) * combustible.amount_required)
    .duration(combustible.duration * 120)
    .buildAndRegister()

    PBF_RECIPES.recipeBuilder()
    .inputs(metaitem('ingotWroughtIron'))
    .inputs(ore(combustible.name) * combustible.amount_required)
    .outputs(metaitem('ingotSteel'))
    .outputs(metaitem(combustible.byproduct) * combustible.amount_required)
    .duration(combustible.duration * 60)
    .buildAndRegister()
}

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

//High Purity Iron Chain

BR = recipemap('batch_reactor')
RF = recipemap('reaction_furnace')
DISTILLERY = recipemap('distillery')

RF.recipeBuilder()
    .inputs(metaitem('dustIron'))
    .fluidInputs(fluid('carbon_monoxide') * 5000)
    .fluidOutputs(fluid('crude_iron_pentacarbonyl') * 1000)
    .duration(200)
    .EUt(60)
	.buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('crude_iron_pentacarbonyl') * 1000)
        .fluidOutputs(fluid('iron_pentacarbonyl') * 900)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('iron_pentacarbonyl') * 1000)
    .outputs(metaitem('dustHighPurityIron'))
    .duration(300)
    .fluidOutputs(fluid('carbon_monoxide') * 5000)
    .EUt(30)
	.buildAndRegister()

EBF_RECIPES.recipeBuilder()
        .notConsumable(Globals.circuit(1))
        .inputs(metaitem('dustIron'))
        .outputs(item('minecraft:iron_ingot'))
        .duration(60)
        .blastFurnaceTemp(1750)
        .EUt(60)
        .buildAndRegister()

EBF_RECIPES.recipeBuilder()
        .notConsumable(Globals.circuit(1))
        .inputs(metaitem('ingotPigIron'))
        .outputs(item('minecraft:iron_ingot'))
        .duration(80)
        .blastFurnaceTemp(1200)
        .EUt(30)
        .buildAndRegister()