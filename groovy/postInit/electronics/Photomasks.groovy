import static globals.Globals.*

ASSEMBLER = recipemap('assembler')

ASSEMBLER.recipeBuilder()
    .inputs(ore('foilMylar'))
    .inputs(ore('foilPlastic'))
    .fluidInputs(fluid('glue') * 100)
    .fluidInputs(fluid('dye_red') * 100)
    .outputs(metaitem('rubylith'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()