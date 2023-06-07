FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
EBF = recipemap('electric_blast_furnace')
CENTRIFUGE = recipemap('centrifuge')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')
ELECTROLYZER = recipemap('electrolyzer')

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

for (combustible in combustibles) {
    EBF.recipeBuilder()
            .inputs(ore('dustCerussite'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_lead') * 216)
            .EUt(120)
            .blastFurnaceTemp(850)
            .duration(160)
            .buildAndRegister()

    EBF.recipeBuilder()
            .inputs(ore('dustGalena'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_lead') * 216)
            .EUt(120)
            .blastFurnaceTemp(850)
            .duration(160)
            .buildAndRegister()

    EBF.recipeBuilder()
            .inputs(ore('dustAnglesite'))
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .fluidOutputs(fluid('crude_lead') * 216)
            .EUt(120)
            .blastFurnaceTemp(850)
            .duration(160)
            .buildAndRegister()
}

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('crude_lead') * 2000)
        .fluidInputs(fluid('zinc') * 144)
        .fluidOutputs(fluid('silver_free_lead') * 2000)
        .fluidOutputs(fluid('zinc_dross') * 432)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('zinc_dross') * 432)
        .outputs(metaitem('dustHighPuritySilver') * 2)
        .fluidOutputs(fluid('zinc') * 144)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('silver_free_lead') * 2000)
        .inputs(ore('dustMagnesium') * 2)
        .inputs(ore('dustCalcium') * 1)
        .fluidOutputs(fluid('lead') * 2000)
        .fluidOutputs(fluid('bismuth_dross') * 720)
        .fluidOutputs(fluid('antimony_dross') * 720)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('bismuth_dross') * 720)
        .fluidInputs(fluid('chlorine') * 6000)
        .outputs(metaitem('dustBismuth') * 2)
        .outputs(metaitem('dustMagnesiumChloride') * 6)
        .outputs(metaitem('dustCalciumChloride') * 3)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('antimony_dross') * 720)
        .fluidInputs(fluid('chlorine') * 6000)
        .outputs(metaitem('dustAntimony') * 2)
        .outputs(metaitem('dustMagnesiumChloride') * 6)
        .outputs(metaitem('dustCalciumChloride') * 3)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .fluidInputs(fluid('crude_lead') * 216)
        .outputs(metaitem('ingotLead'))
        .EUt(7)
        .duration(20)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .notConsumable(metaitem('shape.mold.ingot'))
        .fluidInputs(fluid('silver_free_lead') * 180)
        .outputs(metaitem('ingotLead'))
        .EUt(7)
        .duration(20)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .notConsumable(metaitem('stickLongLead'))
        .notConsumable(fluid('hexafluorosilicic_acid') * 1000)
        .inputs(metaitem('stickLead'))
        .outputs(metaitem('dustHighPurityLead'))
        .EUt(256)
        .duration(80)
        .buildAndRegister()