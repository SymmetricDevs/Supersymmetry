import static prePostInit.Recipemaps.*
import globals.Sintering
import static gregtech.api.GTValues.*
import gregtech.api.metatileentity.multiblock.CleanroomType

// Inductor * 2
mods.gregtech.assembler.removeByInput(120, [metaitem('ringSteel'), metaitem('wireFineCopper') * 2], [fluid('plastic') * 36])
// Inductor * 4
mods.gregtech.assembler.removeByInput(120, [metaitem('ringSteel'), metaitem('wireFineAnnealedCopper') * 2], [fluid('plastic') * 36])

// SMD Transistor * 16
mods.gregtech.assembler.removeByInput(480, [metaitem('foilGallium'), metaitem('wireFineAnnealedCopper') * 8], [fluid('plastic') * 144])
// SMD Transistor * 32
mods.gregtech.assembler.removeByInput(480, [metaitem('foilGallium'), metaitem('wireFineTantalum') * 8], [fluid('plastic') * 144])

// Ferrite Mixture Dust * 6
mods.gregtech.mixer.removeByInput(120, [metaitem('dustNickel'), metaitem('dustZinc'), metaitem('dustIron') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)
mods.gregtech.blender.removeByInput(120, [metaitem('dustNickel'), metaitem('dustZinc'), metaitem('dustIron') * 4, metaitem('circuit.integrated').withNbt(["Configuration": 2])], null)

// Nickel Zinc Ferrite Ingot * 1
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustFerriteMixture')], [fluid('oxygen') * 2000])

// Alumina Plate * 1
mods.gregtech.fluid_solidifier.removeByInput(7, [metaitem('shape.mold.plate')], [fluid('alumina') * 144])
// Alumina Plate * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('dustAlumina')], null)

// Advanced SMD Transistor * 16
mods.gregtech.assembler.removeByInput(3840, [metaitem('foilVanadiumGallium'), metaitem('wireFineHssg') * 8], [fluid('polybenzimidazole') * 144])

