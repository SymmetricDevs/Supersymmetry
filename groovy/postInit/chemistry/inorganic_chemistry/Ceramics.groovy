import globals.Globals
import static globals.SinteringGlobals.*

BR = recipemap('batch_reactor')
BCR = recipemap('bubble_column_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
CVD = recipemap('cvd')
DRYER = recipemap('dryer')
DT = recipemap('distillation_tower')
FORMING_PRESS = recipemap('forming_press')
HOT_ISOSTATIC_PRESS = recipemap('hot_isostatic_press')
MACERATOR = recipemap('macerator')
MIXER = recipemap('mixer')
SINTERING_OVEN = recipemap('sintering_oven')
ROASTER = recipemap('roaster')
VACUUM_CHAMBER = recipemap('vacuum_chamber')

// PVA binder

MIXER.recipeBuilder()
    .inputs(ore('dustPolyvinylAlcohol'))
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('polyvinyl_alcohol_binder') * 1000)
    .duration(100)
    .EUt(30)
    .buildAndRegister()

// Alumina

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .inputs(ore('dustAlumina') * 10)
    .fluidInputs(fluid('polyvinyl_alcohol_binder') * 200)
    .notConsumable(metaitem('shape.mold.ring'))
    .outputs(metaitem('sintered_alumina.insulator'))
    .duration(500)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Zirconia

HOT_ISOSTATIC_PRESS.recipeBuilder()
    .inputs(ore('dustBoronNitride') * 12)
    .fluidInputs(fluid('polyvinyl_alcohol_binder') * 400)
    .outputs(metaitem('nozzle.boron_nitride'))
    .duration(600)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

// Boron carbide

ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustBoronTrioxide') * 10)
    .inputs(ore('dustAnyPurityCarbon') * 7)
    .outputs(metaitem('dustBoronCarbide') * 5)
    .fluidOutputs(fluid('carbon_monoxide') * 6000)
    .duration(300)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

for (blanket in sintering_blankets) {
    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustBoronCarbide'))
        .fluidInputs(fluid('novolacs') * 100)
        .notConsumable(metaitem('shape.mold.rod'))
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('stickBoronCarbide') * 2)
        .circuitMeta(1)
        .duration(blanket.duration)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}

// Long Boron Carbide Rod * 1
mods.gregtech.forge_hammer.removeByInput(16, [metaitem('stickBoronCarbide') * 2], null)

for (blanket in sintering_blankets) {
    SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustBoronCarbide'))
        .fluidInputs(fluid('novolacs') * 100)
        .notConsumable(metaitem('shape.mold.rod'))
        .fluidInputs(fluid(blanket.name) * blanket.amountRequired)
        .outputs(metaitem('stickLongBoronCarbide'))
        .circuitMeta(2)
        .duration(blanket.duration)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()
}

// Boron nitride

CVD.recipeBuilder()
    .fluidInputs(fluid('boron_trichloride') * 1000)
    .fluidInputs(fluid('ammonia') * 1000)
    .outputs(metaitem('dustBoronNitride') * 2)
    .fluidOutputs(fluid('hydrogen_chloride') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

FORMING_PRESS.recipeBuilder()
    .inputs(ore('dustBoronNitride') * 14)
    .notConsumable(metaitem('shape.mold.crucible'))
    .outputs(metaitem('crucible.boron.nitride'))
    .duration(2000)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

/// Nd:YAG (polycrystalline ceramic route)
/*
Reason of why Czochralski method is not used:
1.  Czochralski method is harder to control (in terms of doping quality)
2.  Czochralski method is much simpler (gameplay-wise), 
    if Nd:YAG is going to be used a lot, that method can be used as a skip.
*/
// TODO: set voltage and duration

BR.recipeBuilder()
    .inputs(ore('dustAluminiumHydroxide') * 7)
    .fluidInputs(fluid('nitric_acid') * 3000)
    .fluidOutputs(fluid('aluminium_nitrate_solution') * 3000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('aluminium_nitrate_solution') * 3000)
    .outputs(ore('dustAluminiumNitrate').first() * 13)
    .fluidOutputs(fluid('water') * 3000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustYttriumOxide') * 5)
    .fluidInputs(fluid('nitric_acid') * 6000)
    .fluidOutputs(fluid('yttrium_nitrate_solution') * 3000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('yttrium_nitrate_solution') * 3000)
    .outputs(ore('dustYttriumNitrate').first() * 26)
    .fluidOutputs(fluid('water') * 3000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustNeodymiumOxide') * 5)
    .fluidInputs(fluid('nitric_acid') * 6000)
    .fluidOutputs(fluid('neodymium_nitrate_solution') * 3000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('neodymium_nitrate_solution') * 3000)
    .outputs(ore('dustNeodymiumNitrate').first() * 26)
    .fluidOutputs(fluid('water') * 3000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Based on [1], conentrated than the literature for gameplay
MIXER.recipeBuilder()
    .inputs(ore('dustAluminiumNitrate') * (26 * 5))
    .inputs(ore('dustYttriumNitrate') * (26 * 3))
    .inputs(ore('dustTinyNeodymiumNitrate') * 7) // (26 * 3) * 9 * 0.01 = 7.02
    .fluidInputs(fluid('distilled_water') * 1000)
    .fluidOutputs(fluid('aluminium_yttrium_neodymium_nitrate_solution') * 1000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .fluidInputs(fluid('ammonia') * 1000)
    .fluidInputs(fluid('distilled_water') * 1000)
    .outputs(ore('dustAmmoniumBicarbonate').first() * 10)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Based on [1], 1.5M ammonium bicarbonate sol
MIXER.recipeBuilder()
    .inputs(ore('dustAmmoniumBicarbonate') * 30)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('ammonium_bicarbonate_solution') * 2000)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Based on [1], salt solution slowly poured into ammonium bicarbonate 
CSTR.recipeBuilder()
    .fluidInputs(fluid('aluminium_yttrium_neodymium_nitrate_solution') * 200)
    .fluidInputs(fluid('ammonium_bicarbonate_solution') * 320)
    .fluidOutputs(fluid('nd_yag_suspension_solution') * 520)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder() // filtration
    .fluidInputs(fluid('nd_yag_suspension_solution') * 2600)
    .outputs(metaitem('nd_yag_precursor_cake') * 1)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

MACERATOR.recipeBuilder() // crushing
    .inputs(metaitem('nd_yag_precursor_cake') * 1)
    .outputs(ore('dustNdYagPrecursor').first() * 1)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder() // calcination
    .inputs(ore('dustNdYagPrecursor') * 1)
    .fluidInputs(fluid('oxygen') * 500)
    .outputs(ore('dustRawNdYag').first() * 1)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Nd:YAG raw powder + rod mold -> Nd:YAG green body rod
HOT_ISOSTATIC_PRESS.recipeBuilder()
    .inputs(ore('dustRawNdYag') * 1)
    .notConsumable(metaitem('shape.mold.rod'))
    .outputs(ore('stickNdYagGreenBody').first() * 1)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// vacuum sintering
// Nd:YAG green body rod -> Nd:YAG ceramic rod
SINTERING_OVEN.recipeBuilder()
    .inputs(ore('stickNdYagGreenBody') * 1)
    .outputs(ore('stickNdYagCeramic').first() * 1)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

/*
References:
[1] Ji-Guang Li, Takayasu Ikegami, Jong-Heun Lee, Toshiyuki Mori, Yoshiyuki Yajima,  Co-precipitation synthesis and sintering of yttrium aluminum garnet (YAG) powders: the effect of precipitant, Journal of the European Ceramic Society, Volume 20, Issues 14–15, 2000, Pages 2395-2405, ISSN 0955-2219, https://doi.org/10.1016/S0955-2219(00)00116-3.
*/