import static globals.Globals.*

CONTACT_COOLER = recipemap('contact_cooler')
SIFTER = recipemap('sifter')
VACUUM_CHAMBER = recipemap('vacuum_chamber')
FLUID_COMPRESSOR = recipemap('fluid_compressor')
FLUID_DECOMPRESSOR = recipemap('fluid_decompressor')
HEAT_EXCHANGER = recipemap('heat_exchanger')
PHASE_SEPARATOR = recipemap('phase_separator')
LOW_PRESSURE_DISTILLATION_TOWER = recipemap('low_pressure_distillation_tower')
HIGH_PRESSURE_DISTILLATION_TOWER = recipemap('high_pressure_distillation_tower')
SINGLE_COLUMN_CRYOGENIC_DISTILLATION_PLANT = recipemap('single_column_cryogenic_distillation_plant')
VENT = recipemap('smoke_stack')
BATH_CONDENSER = recipemap('bath_condenser')
SMOKE_STACK = recipemap('smoke_stack')

//TIER ONE (OXYGEN + NITROGEN)

//AIR PREPROCESSING
//COMPRESSION
FLUID_COMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('air') * 6000)
    .fluidOutputs(fluid('compressed_air') * 1000)
    .duration(31)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//WATER COOLING
HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('liquid_nitrogen') * 10)
    .fluidInputs(fluid('water') * 1280)
    .fluidOutputs(fluid('nitrogen') * 640)
    .fluidOutputs(fluid('cold_water') * 1280)
    .duration(31)
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('purified_waste_gaseous_nitrogen') * 640)
    .fluidInputs(fluid('water') * 1280)
    .fluidOutputs(fluid('nitrogen') * 640)
    .fluidOutputs(fluid('cold_water') * 1280)
    .duration(5)
    .buildAndRegister()

//AIR WASHING AND PRECOOLING
CONTACT_COOLER.recipeBuilder()
    .fluidInputs(fluid('compressed_air') * 1000)
    .fluidInputs(fluid('cold_water') * 640)
    .fluidOutputs(fluid('chilled_air') * 1000)
    .fluidOutputs(fluid('water') * 640)
    .duration(31)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//CO2 REMOVAL
SIFTER.recipeBuilder()
    .inputs(ore('dustSmallMolecularSieve'))
    .fluidInputs(fluid('chilled_air') * 25000)
    .fluidOutputs(fluid('purified_air') * 25000)
    .outputs(metaitem('dustSmallDirtyMolecularSieve'))
    .duration(775)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//VACUUM REHEATING FOR REGENERATION
VACUUM_CHAMBER.recipeBuilder()
    .inputs(ore('dustSmallDirtyMolecularSieve'))
    .notConsumable(metaitem('springKanthal'))
    .outputs(metaitem('dustSmallMolecularSieve'))
    .fluidOutputs(fluid('carbon_dioxide') * 25)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//SIDESTREAM OF BOOSTED AIR FOR COLD GENERATION
FLUID_COMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('purified_air') * 1000)
    .fluidOutputs(fluid('boosted_air') * 300)
    .duration(114)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//FIVE LANE HEAT EXCHANGER
HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('boosted_air') * 300)
    .fluidInputs(fluid('purified_air') * 500)
    .fluidOutputs(fluid('chilled_boosted_air') * 150)
    .fluidOutputs(fluid('partially_liquefied_air') * 150)
    .fluidOutputs(fluid('gaseous_air_feedstock') * 500)
    .duration(5)
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('purified_air') * 500)
    .fluidInputs(fluid('untreated_liquid_oxygen') * 15)
    .fluidOutputs(fluid('gaseous_air_feedstock') * 500)
    .fluidOutputs(fluid('oxygen') * 720)
    .duration(5)
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('untreated_liquid_oxygen') * 10)
    .fluidInputs(fluid('chilly_waste_gaseous_nitrogen') * 320)
    .fluidOutputs(fluid('oxygen') * 480)
    .fluidOutputs(fluid('waste_gaseous_nitrogen') * 320)
    .duration(5)
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('chilly_waste_gaseous_nitrogen') * 320)
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 25)
    .fluidOutputs(fluid('waste_gaseous_nitrogen') * 320)
    .fluidOutputs(fluid('nitrogen') * 1200L)
    .duration(5)
    .buildAndRegister()

//FINAL PREPROCESSING
FLUID_DECOMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('chilled_boosted_air') * 150)
    .fluidOutputs(fluid('gaseous_air_feedstock') * 500)
    .duration(114)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

PHASE_SEPARATOR.recipeBuilder()
    .fluidInputs(fluid('partially_liquified_air') * 150)
    .fluidOutputs(fluid('liquid_air_feedstock') * 50)
    .fluidOutputs(fluid('gaseous_air_feedstock') * 100)
    .duration(114)
    .buildAndRegister()

//STARTUP DISTILLATION RECIPE
HIGH_PRESSURE_DISTILLATION_TOWER.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('liquid_air_feedstock') * 50)
    .fluidInputs(fluid('gaseous_air_feedstock') * 1600)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 50)
    .fluidOutputs(fluid('oxygen_rich_gas') * 200)
    .fluidOutputs(fluid('nitrogen_rich_gas') * 1400)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//REFLUXED DISTILLATION RECIPE
BATH_CONDENSER.recipeBuilder()
    .fluidInputs(fluid('nitrogen_rich_gas') * 200)
    .fluidOutputs(fluid('untreated_liquid_nitrogen') * 25)
    .cleanroom(CleanroomType.LOW_PRESSURE_DISTILLATION_TOWER)
    .duration(7)
    .buildAndRegister()

HIGH_PRESSURE_DISTILLATION_TOWER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 25)
    .fluidInputs(fluid('liquid_air_feedstock') * 50)
    .fluidInputs(fluid('gaseous_air_feedstock') * 1600)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 50)
    .fluidOutputs(fluid('oxygen_rich_gas') * 200)
    .fluidOutputs(fluid('nitrogen_rich_gas') * 1600)
    .duration(29)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//UPPER COLUMN FOR FINAL AIR SEPARATION
LOW_PRESSURE_DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('oxygen_rich_liquid') * 50)
    .fluidInputs(fluid('lp_oxygen_rich_gas') * 800)
    .fluidInputs(fluid('lp_nitrogen_rich_gas') * 3200)
    .fluidInputs(fluid('subcooled_liquid_nitrogen') * 50)
    .fluidOutputs(fluid('untreated_liquid_oxygen') * 50)
    .fluidOutputs(fluid('cold_waste_gaseous_nitrogen') * 640)
    .fluidOutputs(fluid('liquid_nitrogen_product') * 150)
    .fluidOutputs(fluid('argon_rich_gas') * 200)
    .duration(29)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SMOKE_STACK.recipeBuilder()
        .fluidInputs(fluid('argon_rich_gas') * 200)
        .duration(29)
        .buildAndRegister()

//TIER TWO: ADDED ARGON

//NO GAS TAPOFF
HIGH_PRESSURE_DISTILLATION_TOWER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 25)
    .fluidInputs(fluid('liquid_air_feedstock') * 50)
    .fluidInputs(fluid('gaseous_air_feedstock') * 1600)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 75)
    .fluidOutputs(fluid('nitrogen_rich_gas') * 1600)
    .duration(29)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//STARTUP DISTILLATION
SINGLE_COLUMN_CRYOGENIC_DISTILLATION_PLANT.recipeBuilder()
    .fluidInputs(fluid('argon_rich_gas') * 200)
    .fluidOutputs(fluid('crude_argon_vapor') * 40)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 45)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//REFLUXED DISTILLATION
SINGLE_COLUMN_CRYOGENIC_DISTILLATION_PLANT.recipeBuilder()
    .fluidInputs(fluid('liquid_crude_argon'))
    .fluidInputs(fluid('argon_rich_gas') * 200)
    .fluidOutputs(fluid('crude_argon_vapor') * 40)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 45)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//STARTUP
HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('oxygen_rich_liquid') * 75)
    .fluidInputs(fluid('liquid_nitrogen') * 150)
    .fluidOutputs(fluid('subcooled_oxygen_rich_liquid') * 75)
    .fluidOutputs(fluid('nitrogen') * 9600)
    .duration(5)
    .buildAndRegister()

//NORMAL HEAT EXCHANGE
HEAT_EXCHANGER.recipeBuilder()
    .fluidInputs(fluid('oxygen_rich_liquid') * 75)
    .fluidInputs(fluid('liquid_argon') * 100)
    .fluidOutputs(fluid('subcooled_oxygen_rich_liquid') * 75)
    .fluidOutputs(fluid('partially_liquefied_argon') * 450)
    .duration(5)
    .buildAndRegister()

