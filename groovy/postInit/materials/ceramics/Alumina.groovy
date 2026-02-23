import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import globals.CoolantGases
import globals.Sintering

// Synthetic Mullite Refractory

ERF.recipeBuilder()
        .inputs(ore('dustKyanite'))
        .outputs(metaitem('dustMullitizedKyanite'))
        .EUt(VA[MV])
        .blastFurnaceTemp(1200)
        .duration(100)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustMullitizedKyanite') * 2)
        .inputs(ore('dustBauxite') * 8)
        .inputs(ore('dustClay') * 4)
        .fluidInputs(fluid('water') * 2000)
        .outputs(metaitem('dustSyntheticMulliteRefractory') * 16)
        .EUt(VA[ULV])
        .duration(80)
        .buildAndRegister()

// For later
//FORMING_PRESS.recipeBuilder()
//        .inputs(ore('dustSyntheticMulliteRefractory'))
//        .outputs(metaitem('ingotSyntheticMulliteRefractory'))
//        .duration(100)
//        .EUt(VA[LV])
//        .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustSyntheticMulliteRefractory'))
        .outputs(metaitem('ingotSyntheticMulliteRefractory'))
        .EUt(VA[MV])
        .duration(50)
        .buildAndRegister()

crafting.addShaped("susy:synthetic_mullite_refractory", item('susy:susy_multiblock_casing', 11), [
        [ore('ingotSyntheticMulliteRefractory'), ore('ingotSyntheticMulliteRefractory')],
        [ore('ingotSyntheticMulliteRefractory'), ore('ingotSyntheticMulliteRefractory')]
])

// Tabular Alumina

Sintering.RotaryKiln.fuels.each { fuel ->
    Sintering.RotaryKiln.comburents.each { comburent ->
        ROTARY_KILN.recipeBuilder()
                .inputs(ore('dustAlumina'))
                .outputs(metaitem('dustTabularAlumina'))
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                .duration(fuel.duration + comburent.duration)
                .EUt(VA[HV])
                .buildAndRegister()
    }
}

// Reactive Alumina

BALL_MILL.recipeBuilder()
        .inputs(ore('dustAlumina'))
        .outputs(metaitem('dustReactiveAlumina'))
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()

// Calcium Aluminate Cement

Sintering.nonPlasmaFuels().each { fuel ->
    Sintering.comburents.each { comburent ->
        ROTARY_KILN.recipeBuilder()
                .inputs(ore('dustAlumina'))
                .inputs(ore('dustLimestone'))
                .circuitMeta(2)
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                .outputs(metaitem('hot_cac_clinker'))
                .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                .duration(fuel.duration + comburent.duration)
                .EUt(VA[ULV])
                .buildAndRegister()
    }
}

def gases = [
        new CoolantGases('air', 'hot_air', 100, 40)
]

for (gas in gases) {
    mods.gregtech.mixer.recipeBuilder()
            .inputs(metaitem('hot_cac_clinker'))
            .fluidInputs(fluid(gas.name) * gas.amount)
            .outputs(metaitem('cac_clinker'))
            .fluidOutputs(fluid(gas.byproduct) * gas.amount)
            .duration(gas.duration)
            .EUt(VA[ULV])
            .buildAndRegister()
}

MACERATOR.recipeBuilder()
        .inputs(metaitem('cac_clinker'))
        .outputs(metaitem('cac_dust') * 16)
        .duration(20)
        .EUt(VA[ULV])
        .buildAndRegister()

// Tabular Alumina Refractory

MIXER.recipeBuilder()
        .inputs(ore('dustTabularAlumina') * 21)
        .inputs(ore('dustAlumina') * 5)
        .inputs(ore('dustReactiveAlumina') * 3)
        .inputs(metaitem('cac_dust') * 9)
        .fluidInputs(fluid('water') * 1500)
        .outputs(metaitem('dustTabularAluminaRefractory') * 32)
        .duration(160)
        .EUt(VA[ULV])
        .buildAndRegister()

// For later
//FORMING_PRESS.recipeBuilder()
//        .inputs(ore('dustTabularAluminaRefractory'))
//        .outputs(metaitem('ingotTabularAluminaRefractory'))
//        .duration(100)
//        .EUt(VA[LV])
//        .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
        .inputs(ore('dustTabularAluminaRefractory'))
        .outputs(metaitem('ingotTabularAluminaRefractory'))
        .EUt(VA[EV])
        .duration(50)
        .buildAndRegister()

crafting.addShaped("susy:tabular_alumina_refractory", item('susy:susy_multiblock_casing', 9), [
        [ore('ingotTabularAluminaRefractory'), ore('ingotTabularAluminaRefractory')],
        [ore('ingotTabularAluminaRefractory'), ore('ingotTabularAluminaRefractory')]
])