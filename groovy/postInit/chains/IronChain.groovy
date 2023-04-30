import static globals.Globals.*


class Blastable {
    String name
    int amount_required
    int amount_produced
    //In liters
    int reductant_required
    int duration
    boolean isNugget

    Blastable(name, amount_required, amount_produced, reductant_required, duration, isNugget = false) {
        this.name = name
        this.amount_required = amount_required
        this.amount_produced = amount_produced
        this.reductant_required = reductant_required
        this.duration = duration
        this.isNugget = isNugget
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
    new Blastable('dustMagnetite', 7 , 3, 4, 80),
    new Blastable('dustBandedIron', 5 , 2, 3, 80),
    new Blastable('dustIronIiiOxide', 5 , 2, 3, 80),
    new Blastable('dustGraniticMineralSand', 14 , 3, 4, 80),
    new Blastable('oreIron', 3, 2, 2, 60, true),
    new Blastable('oreMagnetite', 7 , 3, 4, 60, true),
    new Blastable('oreBandedIron', 5 , 2, 3, 60, true),
    new Blastable('oreNetherrackMagnetite', 7 , 6, 4, 60, true),
    new Blastable('oreNetherrackBandedIron', 5 , 4, 3, 60, true),
    new Blastable('oreEndstoneRackMagnetite', 7 , 6, 4, 60, true),
    new Blastable('oreEndstoneBandedIron', 5 , 4, 3, 60, true),
]

def reductants = [
    new Reductant('carbon_monoxide', 'carbon_dioxide', 1, 1),
    new Reductant('hydrogen', 'steam', 2, 1)
]

def combustibles = [
    new Combustible('gemCoke', 1, 3, 'dustTinyAsh'),
    new Combustible('dustCoke', 1, 3, 'dustTinyAsh'),
    new Combustible('gemCoal', 2, 4),
    new Combustible('dustCoal', 2, 4),
    new Combustible('gemCharcoal', 2, 4),
    new Combustible('dustCharcoal', 2, 4)
]


for (blastable in blastables) {
    for (combustible in combustibles) { 
        if(blastable.isNugget){
            PBF_RECIPES.recipeBuilder()
            .inputs(ore(blastable.name) * blastable.amount_required)
            .inputs(ore(combustible.name) * (combustible.amount_required * blastable.reductant_required))
            .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
            .outputs(metaitem(combustible.byproduct) * (combustible.amount_required * blastable.reductant_required))
            .duration(combustible.duration * blastable.amount_produced * blastable.duration)
            .buildAndRegister()
        } else {
            PBF_RECIPES.recipeBuilder()
            .inputs(ore(blastable.name) * blastable.amount_required)
            .inputs(ore(combustible.name) * (combustible.amount_required * blastable.reductant_required))
            .outputs(metaitem('ingotPigIron') * (blastable.amount_produced * 2))
            .outputs(metaitem(combustible.byproduct) * (combustible.amount_required * blastable.reductant_required))
            .duration(combustible.duration * blastable.amount_produced * blastable.duration)
            .buildAndRegister()
        }
    }

    for (reductant in reductants) {
        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .fluidInputs(fluid(reductant.name) * (blastable.reductant_required * reductant.amount_required))
        .outputs(metaitem('ingotPigIron') * blastable.amount_produced)
        .fluidOutputs(fluid(reductant.byproduct) * (blastable.reductant_required * reductant.byproduct_amount))
        .duration(blastable.amount_produced * blastable.duration)
        .EUt(Globals.voltAmps[1])
        .notConsumable(Globals.circuit(1))
        .buildAndRegister()

        EBF_RECIPES.recipeBuilder()
        .inputs(ore(blastable.name) * blastable.amount_required)
        .fluidInputs(fluid(reductant.name) * (blastable.reductant_required * reductant.amount_required))
        .outputs(item('minecraft:iron_ingot') * blastable.amount_produced)
        .fluidOutputs(fluid(reductant.byproduct) * (blastable.reductant_required * reductant.byproduct_amount))
        .duration(blastable.amount_produced * blastable.duration)
        .EUt(Globals.voltAmps[1])
        .notConsumable(Globals.circuit(0))
        .buildAndRegister()
    }
}

furnace.add(metaitem('dustBrownLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('dustYellowLimonite'), metaitem('dustBandedIron'))
furnace.add(metaitem('ingotPigIron'), item('minecraft:iron_ingot'))

def FORGE_HAMMER = recipemap('forge_hammer')

FORGE_HAMMER.recipeBuilder()
.inputs(metaitem('ingotPigIron'))
.outputs(metaitem('ingotWroughtIron'))
.duration(20)
.EUt(Globals.voltAmps[0])
.buildAndRegister()

crafting.addShapeless('hanmmer_pig_iron',metaitem('ingotWroughtIron'), [
    ore('craftingToolHardHammer'),
    metaitem('ingotPigIron')
])

// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCoke')], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('gemCoke')], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), item('minecraft:coal') * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCoal') * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), metaitem('dustCharcoal') * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [metaitem('ingotWroughtIron'), item('minecraft:coal', 1) * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('dustCoke')], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('gemCoke')], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('dustCoal') * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), metaitem('dustCharcoal') * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), item('minecraft:coal') * 2], null)
// Steel Ingot * 1
mods.gregtech.primitive_blast_furnace.removeByInput(1, [item('minecraft:iron_ingot'), item('minecraft:coal', 1) * 2], null)

for (combustible in combustibles) {
    PBF_RECIPES.recipeBuilder()
    .inputs(item('minecraft:iron_ingot'))
    .inputs(ore(combustible.name) * combustible.amount_required)
    .outputs(metaitem('ingotSteel'))
    .outputs(metaitem(combustible.byproduct) * combustible.amount_required)
    .duration(combustible.duration * 160)
    .buildAndRegister()

    PBF_RECIPES.recipeBuilder()
    .inputs(metaitem('ingotWroughtIron'))
    .inputs(ore(combustible.name) * combustible.amount_required)
    .outputs(metaitem('ingotSteel'))
    .outputs(metaitem(combustible.byproduct) * combustible.amount_required)
    .duration(combustible.duration * 120)
    .buildAndRegister()
}

//MV Electric Arc Furnace Steel Recipes

ARC_FURNACE.recipeBuilder()
.inputs(metaitem('ingotWroughtIron'))
.outputs(metaitem('ingotSteel'))
.EUt(120)
.duration(240)
.buildAndRegister()