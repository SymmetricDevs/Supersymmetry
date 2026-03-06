import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

// From brine

BCR.recipeBuilder()
    .fluidInputs(fluid('bromine_rich_mother_liquor') * 1000)
    .fluidInputs(fluid('chlorine') * 100)
    .fluidOutputs(fluid('chlorinated_mother_liquor') * 1000)
    .duration(180)
    .EUt(VA[MV])
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('steam') * 100)
    .fluidInputs(fluid('chlorinated_mother_liquor') * 1000)
    .fluidOutputs(fluid('impure_bromine') * 100)
    .fluidOutputs(fluid('wastewater_sludge') * 1000)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('impure_bromine') * 1000)
    .fluidOutputs(fluid('bromine') * 1000)
    .chancedOutput(metaitem('dustIodine'), 1000, 100)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

// From sea water bitterns

BCR.recipeBuilder()
    .fluidInputs(fluid('desulfatized_sea_bittern') * 200)
    .fluidInputs(fluid('chlorine') * 15)
    .fluidOutputs(fluid('chlorinated_sea_bittern') * 200)
    .duration(120)
    .EUt(VA[MV])
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .fluidInputs(fluid('steam') * 75)
    .fluidInputs(fluid('chlorinated_sea_bittern') * 1000)
    .fluidOutputs(fluid('impure_bromine') * 75)
    .fluidOutputs(fluid('debrominated_sea_bittern') * 1000)
    .duration(600)
    .EUt(VA[MV])
    .buildAndRegister()