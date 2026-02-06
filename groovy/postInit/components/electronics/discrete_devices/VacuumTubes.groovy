import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.recipeproperties.RecipeProperty;
import gregtech.api.recipes.RecipeBuilder;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.*

crafting.remove("gregtech:vacuum_tube")

// Vacuum Tube * 4
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleAnnealedCopper') * 2], [fluid('red_alloy') * 18])
// Vacuum Tube * 3
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2], [fluid('red_alloy') * 18])
// Vacuum Tube * 2
mods.gregtech.assembler.removeByInput(7, [metaitem('component.glass.tube'), metaitem('boltSteel') * 2, metaitem('wireGtSingleCopper') * 2, metaitem('circuit.integrated').withNbt(["Configuration": 1])], null)

crafting.addShapeless("vacuum_tube_components", metaitem('vacuum_tube_components') * 4, [
    metaitem('carbon_filament'),
    ore('wireFineCopper') * 4,
    ore('foilNickel')
])

MIXER.recipeBuilder()
    .inputs(ore('dustInvar') * 15)
    .inputs(ore('dustCobalt') * 3)
    .outputs(metaitem('dustKovar') * 18)
    .circuitMeta(2)
    .duration(220)
    .EUt(VA[LV])
    .buildAndRegister();

// This is faster, and the previous recipe catches people not paying attention. :)

MIXER.recipeBuilder()
    .inputs(ore('dustIron') * 10)
    .inputs(ore('dustNickel') * 5)
    .inputs(ore('dustCobalt') * 3)
    .outputs(metaitem('dustKovar') * 18)
    .circuitMeta(4)
    .duration(800)
    .EUt(VA[LV])
    .buildAndRegister();

// Kovar AAF recipes because GCYM somehow generated a conflicted recipe with invar

ADVANCED_ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustIron') * 2)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustCobalt'))
    .circuitMeta(19)
    .fluidInputs(fluid('nitrogen') * 4000)
    .fluidOutputs(fluid('kovar') * 576)
    .duration(45)
    .EUt(VA[MV])
    .buildAndRegister()

ADVANCED_ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustIron') * 2)
    .inputs(ore('dustNickel'))
    .inputs(ore('dustCobalt'))
    .circuitMeta(9)
    .fluidOutputs(fluid('kovar') * 576)
    .duration(67)
    .EUt(VA[MV])
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube'))
    .inputs(metaitem('vacuum_tube_components'))
    .inputs(ore('ringKovar'))
    .outputs(metaitem('circuit.vacuum_tube'))
    .EUt(VA[ULV])
    .duration(200)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('carbon_filament'))
    .inputs(ore('wireFineCopper') * 4)
    .inputs(ore('foilNickel'))
    .outputs(metaitem('vacuum_tube_components') * 8)
    .EUt(16)
    .duration(400)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('wireFineTungsten'))
    .inputs(ore('wireFineCopper') * 4)
    .inputs(ore('foilNickel'))
    .outputs(metaitem('vacuum_tube_components') * 12)
    .EUt(16)
    .duration(400)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('wireFineTungsten'))
    .inputs(ore('wireFineCopper') * 4)
    .inputs(metaitem('foilMolybdenum'))
    .outputs(metaitem('vacuum_tube_components') * 16)
    .EUt(16)
    .duration(400)
    .buildAndRegister()