import static globals.Globals.*

crafting.addShaped("susy:basic_structural_casing", item('susy:susy_multiblock_casing', 3) * 6, [
    [ore('screwWroughtIron'), ore('plateWroughtIron'), ore('craftingToolHardHammer')],
    [ore('plateWroughtIron'), null, ore('plateWroughtIron')],
    [ore('craftingToolScrewdriver'), ore('plateWroughtIron'), ore('screwWroughtIron')]
])

crafting.addShaped("susy:basic_serpentine", item('susy:serpentine') * 6, [
    [null, ore('plateSteel'), ore('craftingToolWrench')],
    [ore('pipeTinyFluidCopper'), ore('pipeTinyFluidCopper'), ore('pipeTinyFluidCopper')],
    [ore('craftingToolHardHammer'), ore('plateSteel'), null]
])

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateWroughtIron') * 4)
    .circuitMeta(2)
    .outputs(item('susy:susy_multiblock_casing', 3) * 6)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .inputs(ore('plateSteel') * 2)
    .inputs(ore('pipeTinyFluidCopper') * 2)
    .circuitMeta(2)
    .outputs(item('susy:serpentine') * 6)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(10)
    .inputs(metaitem('electric.motor.hv') * 2)
    .inputs(ore('gearStainlessSteel') * 4)
    .inputs(ore('rotorStainlessSteel') * 16)
    .inputs(ore('plateStainlessSteel') * 16)
    .outputs(item('susy:separator_rotor') * 5)
    .duration(240)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(9)
    .inputs(ore('plateStainlessSteel') * 9)
    .outputs(item('susy:susy_multiblock_casing', 2))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

mods.gregtech.assembler.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('plateStainlessSteel') * 4)
    .inputs(ore('frameStainlessSteel'))
    .outputs(item('susy:susy_multiblock_casing', 1))
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()