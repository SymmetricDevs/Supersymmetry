import static globals.Globals.*

FLUID_SOLIDIFIER = recipemap('fluid_solidifier')
EBF = recipemap('electric_blast_furnace')
CENTRIFUGE = recipemap('centrifuge')
ROASTER = recipemap('roaster')
REACTION_FURNACE = recipemap('reaction_furnace')
BR = recipemap('batch_reactor')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
FLOTATION = recipemap('froth_flotation')
SINTERING_OVEN = recipemap('sintering_oven')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
DISTILLERY = recipemap('distillery')
FLUID_EXTRACTOR= recipemap('extractor')

def COAL_SOURCES = [
        "dustCarbon",
        "gemCoal",
        "dustCoal",
        "gemCharcoal",
        "dustCoke",
        "gemCoke",
        "dustCharcoal"
]

//REMOVAL
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustGalena')], [fluid('oxygen') * 3000])

//OPTIONAL FLOTATION
//GALENA
MIXER.recipeBuilder()
        .inputs(metaitem('dustImpureGalena') * 4)
        .fluidInputs(fluid('distilled_water') * 1000)
        .fluidOutputs(fluid('impure_galena_slurry') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(160)
        .buildAndRegister()

FLOTATION.recipeBuilder()
        .fluidInputs(fluid('impure_galena_slurry') * 1000)
        .notConsumable(metaitem('dustSodiumEthylXanthate'))
        .notConsumable(fluid('sodium_cyanide_solution') * 1000)
        .outputs(metaitem('dustGalena') * 8)
        .fluidOutputs(fluid('galena_byproducts_slurry') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(160)
        .buildAndRegister()

FLOTATION.recipeBuilder()
        .fluidInputs(fluid('galena_byproducts_slurry'))
        .notConsumable(metaitem('dustSodiumEthylXanthate'))
        .outputs(metaitem('dustSphalerite'))
        .fluidOutputs(fluid('wastewater') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(160)
        .buildAndRegister()

//CERUSSITE
FLOTATION.recipeBuilder()
        .inputs(metaitem('dustImpureCerussite') * 5)
        .notConsumable(metaitem('dustSodiumEthylXanthate'))
        .notConsumable(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustCerussite') * 10)
        .outputs(metaitem('dustSiliconDioxide'))
        .EUt(Globals.voltAmps[3])
        .duration(160)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustCerussite') * 1)
        .outputs(metaitem('dustMassicot') * 2)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

//ANGLESITE
FLOTATION.recipeBuilder()
        .inputs(metaitem('dustImpureAnglesite') * 5)
        //.notConsumable(metaitem('dustPotassiumAmylXanthate')) Implement when fusel alcohol and froth flotation agents are implemented
        .notConsumable(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustAnglesite') * 10)
        .outputs(metaitem('dustSiliconDioxide'))
        .EUt(Globals.voltAmps[3])
        .duration(160)
        .buildAndRegister()

//CONCENTRATE SINTERING
SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('dustMassicot') * 2)
        .outputs(metaitem('dustSinteredLeadConcentrate') * 2)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('dustGalena') * 1)
        .fluidInputs(fluid('oxygen') * 3000)
        .outputs(metaitem('dustSinteredLeadConcentrate') * 2)
        .fluidOutputs(fluid('sulfur_dioxide') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
        .inputs(metaitem('dustAnglesite') * 1)
        .outputs(metaitem('dustSinteredLeadConcentrate') * 2)
        .fluidOutputs(fluid('sulfur_trioxide') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

//SINTER-ROAST PROCESS (UNIVERSAL, 200%)
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
        new Combustible('dustCarbon', 1, 1),
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
            .inputs(ore('dustSinteredLeadConcentrate') * 2)
            .inputs(ore(combustible.name) * (combustible.amount_required))
            .inputs(ore('dustCalcite'))
            .outputs(metaitem('dustCadmiumRichFlueDust'))
            .outputs(metaitem('ingotCrudeLead') * 2)
            .outputs(metaitem(combustible.byproduct))
            .fluidOutputs(fluid('carbon_monoxide') * 1000)
            .EUt(120)
            .blastFurnaceTemp(850)
            .duration(160)
            .buildAndRegister()
}

//DECOPPERING
BR.recipeBuilder()
        .inputs(metaitem('dustSulfur'))
        .fluidInputs(fluid('crude_lead') * 3600)
        .outputs(metaitem('dustCopperDross') * 2)
        .fluidOutputs(fluid('decoppered_lead') * 3600) 
        .EUt(120)
        .duration(200)
        .buildAndRegister()

AUTOCLAVE.recipeBuilder()
        .inputs(metaitem('dustCopperDross') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidInputs(fluid('oxygen') * 3000)
        .fluidOutputs(fluid('copper_sulfate_solution') * 1000)
        //.fluidOutputs(fluid('sulfur_dioxide') * 1000) Add when susycore 0.0.14
        .EUt(120)
        .duration(200)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('copper_sulfate_solution') * 1000)
        .outputs(metaitem('dustCopperSulfate') * 6)
        .fluidOutputs(fluid('water') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

//SOFTENING (HARRIS PROCESS) (4% Sb, 2% As, 5% Sn)
REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('sodium_nitrate') * 144)
        .fluidInputs(fluid('decoppered_lead') * 1440)
        .fluidInputs(fluid('sodium_hydroxide') * 259)
        .outputs(metaitem('dustHarrisSlag'))
        .fluidOutputs(fluid('softened_lead') * 1440)
        .fluidOutputs(fluid('nitrogen') * 1000)
        .fluidOutputs(fluid('water') * 900)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustHarrisSlag'))
        .fluidInputs(fluid('distilled_water') * 10)
        .chancedOutput(metaitem('dustSodiumAntimonate'), 400, 0)
        .fluidOutputs(fluid('sodium_arsenate_stannate_solution') * 10)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('sodium_arsenate_stannate_solution') * 1000)
        .outputs(metaitem('dustSodiumArsenateStannateMixture') * 6)
        .fluidOutputs(fluid('water') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

FLUID_EXTRACTOR.recipeBuilder()
        .inputs(metaitem('dustSodiumArsenateStannateMixture') * 6)
        .fluidOutputs(fluid('sodium_arsenate') * 1152)
        .outputs(metaitem('dustSodiumStannate') * 25)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustSodiumArsenate') * 8)
        .fluidInputs(fluid('hydrochloric_acid') * 3000)
        .fluidOutputs(fluid('salty_arsenic_acid') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('salty_arsenic_acid') * 2000)
        .outputs(metaitem('dustSaltyArsenicPentoxide') * 7)
        .fluidOutputs(fluid('steam') * 9000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustSaltyArsenicPentoxide') * 7)
        .fluidInputs(fluid('water') * 6000)
        .outputs(metaitem('dustArsenicVOxide') * 7)
        .fluidOutputs(fluid('salt_water') * 6000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustSodiumStannate') * 6)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .fluidInputs(fluid('distilled_water') * 1000)
        .outputs(metaitem('dustTinIvOxide') * 3)
        .fluidOutputs(fluid('diluted_saltwater') * 2000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustSodiumAntimonate') * 10)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .outputs(metaitem('dustAntimonyVOxide') * 7)
        .fluidOutputs(fluid('salt_water') * 2000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

for (coal_source in COAL_SOURCES) {
    ROASTER.recipeBuilder()
            .inputs(metaitem('dustAntimonyVOxide') * 7)
            .inputs(ore(coal_source) * 5)
            .outputs(metaitem('dustAntimony') * 2)
            .fluidOutputs(fluid('carbon_monoxide') * 5000)
            .EUt(120)
            .duration(200)
            .buildAndRegister()

    ROASTER.recipeBuilder()
            .inputs(metaitem('dustTinIvOxide') * 3)
            .inputs(ore(coal_source) * 2)
            .outputs(metaitem('dustTin'))
            .fluidOutputs(fluid('carbon_monoxide') * 2000)
            .EUt(120)
            .duration(200)
            .buildAndRegister()

    ROASTER.recipeBuilder()
            .inputs(metaitem('dustLithargeSlag') * 10)
            .inputs(ore(coal_source) * 23)
            .outputs(metaitem('ingotBettsCrudeLead') * 10)
            .EUt(Globals.voltAmps[3])
            .duration(400)
            .buildAndRegister()
}

// Lead Dust * 1
mods.gregtech.centrifuge.removeByInput(30, null, [fluid('dezinced_lead') * 1000])

//SILVER REMOVAL (PARKES PROCESS)
CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('softened_lead') * 3600)
        .fluidInputs(fluid('zinc') * 144)
        .fluidOutputs(fluid('silver_free_lead') * 3600)
        .fluidOutputs(fluid('zinc_dross') * 216)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
        .fluidInputs(fluid('zinc_dross') * 432)
        .outputs(metaitem('dustSilver'))
        .fluidOutputs(fluid('zinc') * 288)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

//DEZINCING
VACUUM_CHAMBER.recipeBuilder()
        .fluidInputs(fluid('silver_free_lead') * 2880)
        .fluidOutputs(fluid('dezinced_lead') * 2880)
        .fluidOutputs(fluid('zinc') * 144)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

FLUID_SOLIDIFIER.recipeBuilder()
        .fluidInputs(fluid('dezinced_lead') * 100)
        .notConsumable(metaitem('shape.mold.ingot'))
        .outputs(metaitem('ingotLead'))
        .EUt(7)
        .duration(20)
        .buildAndRegister()

//DEBISMUTHIZING (KROLL-BETTERTON PROCESS)
REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('silver_free_lead') * 9600)
        .inputs(ore('dustMagnesium') * 6)
        .inputs(ore('dustCalcium') * 3)
        .fluidOutputs(fluid('lead') * 9600)
        .fluidOutputs(fluid('bismuth_dross') * 1440)
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

//HIGH PURITY LEAD (BETTS PROCESS)
ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('plateLead'))
        .notConsumable(fluid('hexafluorosilicic_acid') * 1000)
        .inputs(metaitem('plateCrudeLead') * 2)
        .fluidInputs(fluid('distilled_water') * 1000)
        .chancedOutput(metaitem('dustHighPurityLead') * 2, 9800, 0)
        .outputs(metaitem('lead_anode_slime'))
        .fluidOutputs(fluid('oxygen') * 1000)
        .EUt(256)
        .duration(400)
        .buildAndRegister()

//SLIME TREATMENT
ROASTER.recipeBuilder()
        .inputs(metaitem('lead_anode_slime'))
        .outputs(metaitem('dustBlackMetal'))
        .EUt(Globals.voltAmps[3])
        .duration(400)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(metaitem('dustBlackMetal') * 50)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustAntimonyArsenicFlueDust') * 3)
        .outputs(metaitem('dustBurnedBlackMetal') * 2)
        .EUt(Globals.voltAmps[3])
        .duration(400)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(metaitem('dustBurnedBlackMetal') * 2)
        .fluidInputs(fluid('oxygen') * 2500)
        .outputs(metaitem('dustSilver'))
        .outputs(metaitem('dustLithargeSlag') * 5)
        .EUt(Globals.voltAmps[3])
        .duration(400)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(metaitem('dustSulfur'))
        .fluidInputs(fluid('betts_crude_lead') * 1440)
        .outputs(metaitem('dustCopperDross') * 2)
        .fluidOutputs(fluid('decoppered_betts_lead') * 1296)
        .EUt(Globals.voltAmps[3])
        .duration(400)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('decoppered_betts_lead') * 2592)
        .inputs(ore('dustMagnesium') * 6)
        .inputs(ore('dustCalcium') * 3)
        .fluidOutputs(fluid('lead') * 1728)
        .fluidOutputs(fluid('bismuth_dross') * 2160)
        .EUt(Globals.voltAmps[3])
        .duration(800)
        .buildAndRegister()






        