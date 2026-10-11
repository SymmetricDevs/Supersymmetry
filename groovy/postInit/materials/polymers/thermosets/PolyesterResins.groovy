import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

POLYMERIZATION_TANK.recipeBuilder()
    .notConsumable(fluid('nitrogen') * 8000)
    .fluidInputs(fluid('propylene_glycol') * 1100)
    .inputs(ore('dustAdipicAcid') * 20)
    .fluidOutputs(fluid('oligomeric_polyester_mixture') * 4100)
    .duration(400)
    .EUt(VA[HV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('oligomeric_polyester_mixture') * 4100)
    .fluidOutputs(fluid('polyester_melt') * 2100)
    .fluidOutputs(fluid('water') * 2000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustTinyHydroquinone'))
    .fluidInputs(fluid('polyester_melt') * 4200)
    .fluidInputs(fluid('styrene') * 800)
    .fluidOutputs(fluid('polyester_resin') * 5000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()