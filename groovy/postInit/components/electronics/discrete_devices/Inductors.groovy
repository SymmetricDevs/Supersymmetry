import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

mods.jei.ingredient.yeet(metaitem('component.advanced_smd.inductor'))

// Ferrite Mixture Dust * 6
mods.gregtech.mixer.removeByInput(120, [metaitem('dustNickel'), metaitem('dustZinc'), metaitem('dustIron') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Ferrite Mixture Dust * 6
mods.gregtech.blender.removeByInput(120, [metaitem('dustNickel'), metaitem('dustZinc'), metaitem('dustIron') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
// Nickel Zinc Ferrite Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustFerriteMixture')], [fluid('oxygen') * 2000])
// Inductor * 2
mods.gregtech.assembler.removeByInput(120, [metaitem('ringSteel'), metaitem('wireFineCopper') * 2], [fluid('plastic') * 36])
// Inductor * 4
mods.gregtech.assembler.removeByInput(120, [metaitem('ringSteel'), metaitem('wireFineAnnealedCopper') * 2], [fluid('plastic') * 36])
// SMD Inductor * 16
mods.gregtech.assembler.removeByInput(480, [metaitem('ringNickelZincFerrite'), metaitem('wireFineCupronickel') * 4], [fluid('plastic') * 144])
// SMD Inductor * 32
mods.gregtech.assembler.removeByInput(480, [metaitem('ringNickelZincFerrite'), metaitem('wireFineTantalum') * 4], [fluid('plastic') * 144])

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 36)
    .inputs(ore('ringManganeseZincFerrite'))
    .inputs(ore('wireFineAnnealedCopper') * 2)
    .outputs(metaitem('component.inductor'))
    .duration(320)
    .EUt(VA[MV])
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .inputs(metaitem('component.smd.contact') * 16)
    .inputs(ore('ringManganeseZincFerrite'))
    .inputs(ore('wireFineCupronickel') * 4)
    .outputs(metaitem('component.smd.inductor') * 8)
    .duration(400)
    .EUt(240)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .inputs(metaitem('component.smd.contact') * 16)
    .inputs(ore('ringNickelZincFerrite'))
    .inputs(ore('wireFineCupronickel') * 4)
    .outputs(metaitem('component.smd.inductor') * 8)
    .duration(400)
    .EUt(240)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .inputs(metaitem('component.smd.contact') * 24)
    .inputs(ore('ringCobaltFerrite'))
    .inputs(ore('wireFineCupronickel') * 4)
    .outputs(metaitem('component.smd.inductor') * 12)
    .duration(200)
    .EUt(240)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .inputs(metaitem('component.smd.contact') * 32)
    .inputs(ore('ringBariumFerrite'))
    .inputs(ore('wireFineCupronickel') * 4)
    .outputs(metaitem('component.smd.inductor') * 16)
    .duration(100)
    .EUt(240)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .fluidInputs(fluid('epoxy_molding_compound') * 144)
    .inputs(metaitem('component.smd.contact') * 40)
    .inputs(ore('ringStrontiumFerrite'))
    .inputs(ore('wireFineCupronickel') * 4)
    .outputs(metaitem('component.smd.inductor') * 20)
    .duration(40)
    .EUt(240)
    .buildAndRegister()
