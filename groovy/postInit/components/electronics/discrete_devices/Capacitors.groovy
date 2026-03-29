import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

oreDict.add('componentCapacitorMedium', metaitem('component.capacitor.silver_mica'))
oreDict.add('componentCapacitorMedium', metaitem('component.capacitor.film'))

// Silver mica capacitors

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSilver') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('glue') * 200)
    .outputs(metaitem('component.capacitor.silver_mica'))
    .duration(360)
    .EUt(VA[LV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilSilver') * 2)
    .inputs(ore('plateMica'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('phenolic_novolac_resin') * 50)
    .outputs(metaitem('component.capacitor.silver_mica'))
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()

// Plastic film capacitors

oreDict.add('capacitorFilm', metaitem('mylar'))
oreDict.add('capacitorFilm', metaitem('foilPolypropylene'))

EVAPORATION.recipeBuilder()
    .inputs(ore('nuggetAluminium'))
    .inputs(ore('capacitorFilm') * 8)
    .outputs(metaitem('component.capacitor.film.metallized_film'))
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.capacitor.film.metallized_film') * 2)
    .fluidInputs(fluid('aluminium') * 18)
    .fluidInputs(fluid('silicone_oil') * 50)
    .outputs(metaitem('component.capacitor.film.core'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('component.capacitor.film.metallized_film.impregnated'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .fluidInputs(fluid('soldering_alloy') * 72)
    .fluidInputs(fluid('epoxy_resin') * 16)
    .outputs(metaitem('component.capacitor.film'))
    .duration(40)
    .EUt(VA[MV])
    .buildAndRegister()
