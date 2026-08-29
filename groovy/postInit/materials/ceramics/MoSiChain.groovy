import static prePostInit.Recipemaps.*
import globals.Sintering
import static gregtech.api.GTValues.*

//Aluminosilicate Mix

MIXER.recipeBuilder()
        .inputs(ore('dustSiliconDioxide') * 30)
        .inputs(ore('dustAlumina') * 3)
        .inputs(ore('dustMagnesia') * 2)
        .inputs(ore('dustSodiumOxide'))
        .inputs(ore('dustTinyQuicklime') * 7)
        .inputs(ore('dustTinyIronIiiOxide') * 2)
        .outputs(metaitem('dustAluminosilicateMix') * 37)
        .EUt(VA[MV])
        .duration(80)
        .buildAndRegister()

//Mo-Si Slurry

BALL_MILL.recipeBuilder()
        .inputs(ore('dustAluminosilicateMix'))
        .inputs(ore('dustMolybdenum') * 8)
        .inputs(ore('dustSilicon') * 16)
        .fluidInputs(fluid('ethanol') * 32000)
        .fluidOutputs(fluid('mo_si_slurry') * 57000)
        .EUt(VA[HV])
        .duration(600)
        .buildAndRegister()

//Mo-Si Precursor

VACUUM_CHAMBER.recipeBuilder()
        .fluidInputs(fluid('mo_si_slurry') * 11400)
        .fluidOutputs(fluid('ethanol') * 6400)
        .outputs(metaitem('dustMoSiPrecursor') *5)
        .EUt(VA[MV])
        .duration(80)
        .buildAndRegister()

//Wet Mo-Si Rod

EXTRUDER.recipeBuilder()
        .notConsumable(metaitem('shape.extruder.rod'))
        .inputs(ore('dustMoSiPrecursor'))
        .fluidInputs(fluid('water') * 40)
        .outputs(metaitem('mo_si_rod.wet'))
        .EUt(VA[MV])
        .duration(50)
        .buildAndRegister()

//Unsintered Mo-Si Rod

DRYER.recipeBuilder()
        .inputs(metaitem('mo_si_rod.wet'))
        .outputs(metaitem('mo_si_rod.unsintered'))
        .EUt(VA[MV])
        .duration(100)
        .buildAndRegister()

//Molybdenum Disilicide Rod

SINTERING_OVEN.recipeBuilder()
        .notConsumable(metaitem('graphite_boat'))
        .inputs(metaitem('mo_si_rod.unsintered'))
        .fluidInputs(fluid('hydrogen') * 20)
        .outputs(metaitem('stickMolybdenumDisilicide'))
        .duration(100)
        .EUt(VA[HV])
        .buildAndRegister()

// Graphite Boat

MILLING.recipeBuilder()
        .inputs(ore("blockGraphite"))
        .outputs(metaitem("graphite_boat"))
        .duration(1200)
        .EUt(VA[HV])
        .buildAndRegister()
