import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

BR.recipeBuilder()
        .inputs(ore('dustLeadIiOxide') * 2)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .outputs(metaitem('dustLeadNitrate') * 9)
        .fluidOutputs(fluid('water') * 1000)
        .EUt(VA[LV])
        .duration(200)
        .buildAndRegister()

def mn_ii_oxides = ['dustManganeseIiOxide', 'dustCrudeManganeseIiOxide']
for (mn_ii_oxide in mn_ii_oxides) {
    MIXER.recipeBuilder()
            .inputs(ore(mn_ii_oxide))
            .inputs(ore('dustIronIiiOxide'))
            .outputs(metaitem('dustSienna') * 2)
            .EUt(VA[LV])
            .duration(200)
            .buildAndRegister()
}

furnace.add(metaitem('dustSienna'), metaitem('dustBurntSienna'))

BR.recipeBuilder()
        .inputs(ore('dustArsenicTrioxide') * 5)
        .fluidInputs(fluid('soda_ash_solution') * 1000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .fluidOutputs(fluid('gtfo_sodium_arsenite_solution') * 1000)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustCopper') * 2)
        .fluidInputs(fluid('sulfuric_acid') * 2000)
        .fluidInputs(fluid('gtfo_sodium_arsenite_solution') * 1000)
        .outputs(metaitem('gregtechfoodoption:cupric_hydrogen_arsenite_dust') * 12)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

ERF.recipeBuilder()
        .inputs(ore('dustAlumina') * 5)
        .inputs(ore('dustCobaltOxide') * 2)
        .outputs(metaitem('dustCobaltAluminate') * 7)
        .blastFurnaceTemp(1100)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustLeadNitrate') * 9)
        .fluidInputs(fluid('sodium_chromate_solution') * 1000)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('sodium_nitrate_solution') * 2000)
        .outputs(metaitem('dustLeadChromate') * 6)
        .EUt(VA[MV])
        .duration(200)
        .buildAndRegister()
