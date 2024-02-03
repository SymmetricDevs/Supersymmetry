crafting.replaceShaped('xtones:zome', item('xtones:zome') * 8, [
        [item('xtones:base'), item('xtones:base'), item('xtones:base')],
        [item('xtones:base'), ore('cobblestone'), item('xtones:base')],
        [item('xtones:base'), item('xtones:base'), item('xtones:base')]
])

crafting.replaceShaped('xtones:zoea', item('xtones:zoea') * 8, [
        [item('xtones:base'), item('xtones:base'), item('xtones:base')],
        [item('xtones:base'), ore('wool'), item('xtones:base')],
        [item('xtones:base'), item('xtones:base'), item('xtones:base')]
])

crafting.replaceShaped('xtones:iszm', item('xtones:iszm') * 8, [
        [item('xtones:base'), item('xtones:base'), item('xtones:base')],
        [item('xtones:base'), ore('stone'), item('xtones:base')],
        [item('xtones:base'), item('xtones:base'), item('xtones:base')]
])

crafting.replaceShaped('xtones:lair', item('xtones:lair') * 8, [
        [item('xtones:base'), item('xtones:base'), item('xtones:base')],
        [item('xtones:base'), ore('netherrack'), item('xtones:base')],
        [item('xtones:base'), item('xtones:base'), item('xtones:base')]
])

crafting.replaceShaped('xtones:vena', item('xtones:vena') * 8, [
        [item('xtones:base'), item('xtones:base'), item('xtones:base')],
        [item('xtones:base'), ore('plankWood'), item('xtones:base')],
        [item('xtones:base'), item('xtones:base'), item('xtones:base')]
])

crafting.replaceShaped('xtones:base', item('xtones:base') * 32, [
        [ore('slabStone'), ore('slabStone'), null],
        [ore('slabStone'), ore('stone'), ore('slabStone')],
        [null, ore('slabStone'), ore('slabStone')]
])

ASSEMBLER = recipemap('assembler')

ASSEMBLER.recipeBuilder()
        .inputs(ore('stone'))
        .inputs(item('minecraft:stone_slab') * 6)
        .outputs(item('xtones:base') * 32)
        .duration(20)
        .EUt(7)
        .buildAndRegister();

for (var i = 1; i < 17; i++) {
    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:stick'))
            .outputs(item('xtones:zyth', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeLightGray'))
            .outputs(item('xtones:ztyl', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:clay'))
            .outputs(item('xtones:zorg', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:stone_slab', 3))
            .outputs(item('xtones:zone', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('cobblestone'))
            .outputs(item('xtones:zome', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('wool'))
            .outputs(item('xtones:zoea', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:bone'))
            .outputs(item('xtones:zkul', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:torch'))
            .outputs(item('xtones:zion', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:string'))
            .outputs(item('xtones:zeta', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:snowball'))
            .outputs(item('xtones:zest', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:coal', 1))
            .outputs(item('xtones:zech', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:clay_ball'))
            .outputs(item('xtones:zane', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('plankWood'))
            .outputs(item('xtones:vena', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeBlack'))
            .outputs(item('xtones:vect', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeGray'))
            .outputs(item('xtones:tank', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeGreen'))
            .outputs(item('xtones:sync', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeYellow'))
            .outputs(item('xtones:sols', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('sand'))
            .outputs(item('xtones:roen', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:reeds'))
            .outputs(item('xtones:reed', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeRed'))
            .outputs(item('xtones:reds', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:snow'))
            .outputs(item('xtones:myst', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeLime'))
            .outputs(item('xtones:mint', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeLightBlue'))
            .outputs(item('xtones:lave', i - 1) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('netherrack'))
            .outputs(item('xtones:lair', i - 17) * 8)
            .circuitMeta(i)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:dirt'))
            .outputs(item('xtones:kryp', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:gravel'))
            .outputs(item('xtones:korp', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeOrange'))
            .outputs(item('xtones:jelt', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('stone'))
            .outputs(item('xtones:iszm', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('blockGlass'))
            .outputs(item('xtones:glaxx', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:brick'))
            .outputs(item('xtones:fort', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:hardened_clay'))
            .outputs(item('xtones:cray', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:coal'))
            .outputs(item('xtones:bitt', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(ore('dyeBlue'))
            .outputs(item('xtones:azur', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();

    ASSEMBLER.recipeBuilder()
            .inputs(item('xtones:base') * 8)
            .inputs(item('minecraft:stone_slab'))
            .outputs(item('xtones:agon', i - 17) * 8)
            .circuitMeta(i + 16)
            .duration(20)
            .EUt(7)
            .buildAndRegister();
}