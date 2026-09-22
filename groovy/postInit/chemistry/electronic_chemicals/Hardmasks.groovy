import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

import gregtech.api.metatileentity.multiblock.CleanroomType

// Naphthol-modified phenolic novolacs spin on carbon

CSTR.recipeBuilder()
    .fluidInputs(fluid('pyridine') * 50)
    .fluidInputs(fluid('tosylic_acid_solution') * 50)
    .fluidOutputs(fluid('pyridinium_tosylate_solution') * 50)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('pyridinium_tosylate_solution') * 1000)
    .outputs(metaitem('dustPyridiniumTosylate') * 30)
    .fluidOutputs(fluid('water') * 1000)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

BLENDER.recipeBuilder()
    .inputs(ore('dustPyridiniumTosylate') * 2)
    .inputs(ore('dustHexamethoxymethylmelamine') * 11)
    .fluidInputs(fluid('naphthol_modified_phenolic_novolacs_oligomer') * 6700)
    .fluidInputs(fluid('nonionic_fluorosurfactant') * 10)
    .fluidInputs(fluid('propylene_glycol_methyl_ether_acetate') * 27290)
    .fluidOutputs(fluid('spin_on_carbon') * 34000)
    .cleanroom(CleanroomType.CLEANROOM)
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()