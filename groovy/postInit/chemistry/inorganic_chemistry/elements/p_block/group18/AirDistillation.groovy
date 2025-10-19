import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

/*INFORMATION
STANDARD I/O LIQUID: 64L OF REGULAR GAS
LIQUIDS INTERMEDIATES: 48L OF REGULAR GAS
HIGH PRESSURE OUTPUT GAS: 6L OF REGULAR GAS
*/

//TIER ONE (OXYGEN + NITROGEN)

/*AIR PREPROCESSING
    //COMPRESSION
    FLUID_COMPRESSOR.recipeBuilder()
        .fluidInputs(fluid('air') * 6000)
        .fluidOutputs(fluid('compressed_air') * 1000)
        .duration(31)
        .EUt(VA[LV])
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
        .EUt(VA[LV])
        .buildAndRegister()*/

    //CO2 REMOVAL
    SIFTER.recipeBuilder()
        .inputs(ore('dustMolecularSieveX'))
        .fluidInputs(fluid('air') * 12000)
        .fluidOutputs(fluid('decarburized_air') * 12000)
        .outputs(metaitem('dustCarbonatedMolecularSieveX'))
        .duration(4)
        .EUt(VA[LV])
        .buildAndRegister()

    //VACUUM REHEATING FOR REGENERATION
    VACUUM_CHAMBER.recipeBuilder()
        .circuitMeta(1)
        .inputs(ore('dustCarbonatedMolecularSieveX'))
        .notConsumable(metaitem('springKanthal'))
        .outputs(metaitem('dustMolecularSieveX'))
        .fluidOutputs(fluid('carbon_dioxide') * 20)
        .duration(4)
        .EUt(VA[LV])
        .buildAndRegister()

    VACUUM_CHAMBER.recipeBuilder()
        .circuitMeta(2)
        .inputs(ore('dustCarbonatedMolecularSieveX') * 36)
        .notConsumable(metaitem('springKanthal'))
        .outputs(metaitem('dustMolecularSieveX') * 36)
        .fluidOutputs(fluid('carbon_dioxide') * 1280)
        .duration(10)
        .EUt(VA[LV])
        .buildAndRegister()

    HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('chilly_waste_gaseous_nitrogen') * 640)
        .fluidInputs(fluid('hp_decarburized_air') * 1000)
        .fluidOutputs(fluid('waste_gaseous_nitrogen') * 640)
        .fluidOutputs(fluid('cold_hp_decarburized_air') * 1000)
        .duration(1)
        .buildAndRegister()

//NETHER AIR PROCESSING
    SIFTER.recipeBuilder()
        .inputs(ore('dustMolecularSieveX'))
        .fluidInputs(fluid('nether_air') * 14000)
        .fluidOutputs(fluid('decarburized_air') * 12000)
        .outputs(metaitem('dustNetherMolecularSieveX'))
        .duration(4)
        .EUt(VA[LV])
        .buildAndRegister()

    VACUUM_CHAMBER.recipeBuilder()
        .inputs(ore('dustNetherMolecularSieveX'))
        .notConsumable(metaitem('springKanthal'))
        .outputs(metaitem('dustMolecularSieveX'))
        .fluidOutputs(fluid('heavy_nether_gases') * 2000)
        .duration(4)
        .EUt(VA[LV])
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(fluid('heavy_nether_gases') * 2000)
        .fluidOutputs(fluid('sulfur_dioxide') * 500)
        .fluidOutputs(fluid('hydrogen_sulfide') * 500)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .duration(100)
        .EUt(64)
        .buildAndRegister()

    //SIDESTREAM OF BOOSTED AIR FOR COLD GENERATION
    /*FLUID_COMPRESSOR.recipeBuilder()
        .fluidInputs(fluid('purified_air') * 1000)
        .fluidOutputs(fluid('boosted_air') * 300)
        .duration(114)
        .EUt(VA[LV])
        .buildAndRegister()

    //FIVE LANE HEAT EXCHANGER
    TAPPED_OFF_HEAT_EXCHANGER.recipeBuilder()
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
        .fluidOutputs(fluid('nitrogen') * 1200)
        .duration(5)
        .buildAndRegister()

    //STARTUP HEAT EXCHANGE
    HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('purified_air') * 500)
        .fluidInputs(fluid('liquid_oxygen') * 10)
        .fluidOutputs(fluid('gaseous_air_feedstock') * 500)
        .fluidOutputs(fluid('oxygen') * 640)
        .duration(5)
        .buildAndRegister()

    //FINAL PREPROCESSING
    FLUID_DECOMPRESSOR.recipeBuilder()
        .fluidInputs(fluid('chilled_boosted_air') * 150)
        .fluidOutputs(fluid('gaseous_air_feedstock') * 500)
        .duration(114)
        .EUt(VA[LV])
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('partially_liquified_air') * 150)
        .fluidOutputs(fluid('liquid_air_feedstock') * 50)
        .fluidOutputs(fluid('gaseous_air_feedstock') * 100)
        .duration(114)
        .buildAndRegister()*/

//PROCESSED AIR DISTILLATION
    //STARTUP DISTILLATION RECIPE
    HIGH_PRESSURE_CRYO_DT.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('liquid_decarburized_air') * 100)
        .fluidInputs(fluid('cold_hp_decarburized_air') * 5600)
        .fluidOutputs(fluid('oxygen_rich_liquid') * 50)
        .fluidOutputs(fluid('oxygen_rich_gas') * 200)
        .fluidOutputs(fluid('nitrogen_rich_gas') * 1560)
        .duration(20)
        .EUt(VA[HV])
        .buildAndRegister()

    //REFLUXED DISTILLATION RECIPE
    BATH_CONDENSER.recipeBuilder()
        .fluidInputs(fluid('nitrogen_rich_gas') * 800)
        .fluidOutputs(fluid('untreated_liquid_nitrogen') * 100)
        .duration(1)
        .buildAndRegister()

    HIGH_PRESSURE_CRYO_DT.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('untreated_liquid_nitrogen') * 25)
        .fluidInputs(fluid('liquid_decarburized_air') * 100)
        .fluidInputs(fluid('cold_hp_decarburized_air') * 5600)
        .fluidOutputs(fluid('oxygen_rich_liquid') * 50)
        .fluidOutputs(fluid('oxygen_rich_gas') * 200)
        .fluidOutputs(fluid('nitrogen_rich_gas') * 1760)
        .duration(5)
        .EUt(VA[HV])
        .buildAndRegister()

    //UPPER COLUMN FOR FINAL AIR SEPARATION
    //STARTUP
    LOW_PRESSURE_CRYO_DT.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('oxygen_rich_liquid') * 50)
        .fluidInputs(fluid('oxygen_rich_gas') * 200)
        .fluidInputs(fluid('nitrogen_rich_gas') * 960)
        .fluidOutputs(fluid('untreated_liquid_oxygen') * 30)
        .fluidOutputs(fluid('argon_rich_gas') * 1200)
        .fluidOutputs(fluid('cold_waste_gaseous_nitrogen') * 9360)
        .duration(20)
        .EUt(VA[HV])
        .buildAndRegister()

    //SUBCOOLED
    HEAT_EXCHANGER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('cold_waste_gaseous_nitrogen') * 240)
        .fluidInputs(fluid('untreated_liquid_nitrogen') * 50)
        .fluidOutputs(fluid('chilly_waste_gaseous_nitrogen') * 240)
        .fluidOutputs(fluid('subcooled_liquid_nitrogen') * 50)
        .duration(5)
        .buildAndRegister()

    HEAT_EXCHANGER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('untreated_liquid_nitrogen') * 25)
        .fluidInputs(fluid('untreated_liquid_oxygen') * 30)
        .fluidOutputs(fluid('subcooled_liquid_nitrogen') * 25)
        .fluidOutputs(fluid('liquid_oxygen_product') * 30)
        .duration(5)
        .buildAndRegister()

    LOW_PRESSURE_CRYO_DT.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('oxygen_rich_liquid') * 50)
        .fluidInputs(fluid('oxygen_rich_gas') * 200)
        .fluidInputs(fluid('nitrogen_rich_gas') * 800)
        .fluidInputs(fluid('subcooled_liquid_nitrogen') * 50)
        .fluidOutputs(fluid('untreated_liquid_oxygen') * 30)
        .fluidOutputs(fluid('argon_rich_gas') * 1200)
        .fluidOutputs(fluid('cold_waste_gaseous_nitrogen') * 240)
        .fluidOutputs(fluid('liquid_nitrogen_product') * 190)
        .duration(5)
        .EUt(VA[HV])
        .buildAndRegister()

//INTERMEDIATES --> PRODUCTS
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('liquid_nitrogen_product') * 100)
    .fluidOutputs(fluid('liquid_nitrogen') * 75)
    .duration(1)
    .EUt(VA[ULV])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('liquid_oxygen_product') * 100)
    .fluidOutputs(fluid('liquid_oxygen') * 75)
    .duration(1)
    .EUt(VA[ULV])
    .buildAndRegister()

//TIER TWO: ADDED ARGON

//NO GAS TAPOFF
HIGH_PRESSURE_CRYO_DT.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 50)
    .fluidInputs(fluid('liquid_decarburized_air') * 200)
    .fluidInputs(fluid('cold_hp_decarburized_air') * 11200)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 150)
    .fluidOutputs(fluid('nitrogen_rich_gas') * 3520)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

//ARGON COARSE SEPARATION
    //STARTUP DISTILLATION
    SINGLE_COLUMN_CRYO_DT.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('argon_rich_gas') * 2400)
        .fluidOutputs(fluid('oxygen_rich_liquid') * 45)
        .fluidOutputs(fluid('crude_argon_vapor') * 240)
        .duration(40)
        .EUt(VA[LV])
        .buildAndRegister()

    //REFLUXED DISTILLATION
    SINGLE_COLUMN_CRYO_DT.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('liquid_crude_argon') * 5)
        .fluidInputs(fluid('argon_rich_gas') * 2400)
        .fluidOutputs(fluid('oxygen_rich_liquid') * 45)
        .fluidOutputs(fluid('crude_argon_vapor') * 480)
        .duration(10)
        .EUt(VA[LV])
        .buildAndRegister()

    //CONDENSATION
    BATH_CONDENSER.recipeBuilder()
        .fluidInputs(fluid('subcooled_oxygen_rich_liquid') * 150)
        .fluidInputs(fluid('crude_argon_vapor') * 240)
        .fluidOutputs(fluid('liquid_crude_argon') * 10)
        .fluidOutputs(fluid('oxygen_rich_liquid') * 100)
        .fluidOutputs(fluid('oxygen_rich_gas') * 400)
        .duration(1)
        .buildAndRegister()

    //DEOXYGENATION
    FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('liquid_crude_argon') * 50)
        .fluidInputs(fluid('hydrogen') * 24)
        .notConsumable(metaitem('catalystBedSupportedPlatinum'))
        .chancedOutput(metaitem('dustIce'), 120, 0)
        .fluidOutputs(fluid('liquid_deoxygenated_argon') * 50)
        .duration(20)
        .EUt(VA[LV])
        .buildAndRegister()

//ARGON PURIFICATION
    //STARTUP DISTILLATION
    SINGLE_COLUMN_CRYO_DT.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('liquid_deoxygenated_argon') * 200)
        .fluidOutputs(fluid('liquid_argon_product') * 200)
        .fluidOutputs(fluid('cold_waste_gaseous_nitrogen') * 96)
        .duration(400)
        .EUt(VA[LV])
        .buildAndRegister()

    //REFLUXED DISTILLATION
    BATH_CONDENSER.recipeBuilder()
        .notConsumable(fluid('subcooled_oxygen_rich_liquid') * 150)
        .fluidInputs(fluid('cold_waste_gaseous_nitrogen') * 48)
        .fluidOutputs(fluid('liquid_waste_nitrogen') * 1)
        .duration(1)
        .buildAndRegister()

    SINGLE_COLUMN_CRYO_DT.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('liquid_deoxygenated_argon') * 200)
        .fluidInputs(fluid('argon') * 2400)
        .fluidInputs(fluid('liquid_waste_nitrogen'))
        .fluidOutputs(fluid('liquid_argon_product') * 250)
        .fluidOutputs(fluid('cold_waste_gaseous_nitrogen') * 144)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

    //STARTUP SUBCOOLING
    HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('oxygen_rich_liquid') * 150)
        .fluidInputs(fluid('liquid_nitrogen') * 150)
        .fluidOutputs(fluid('subcooled_oxygen_rich_liquid') * 150)
        .fluidOutputs(fluid('nitrogen') * 9600)
        .duration(5)
        .buildAndRegister()

    //NORMAL SUBCOOLING
    HEAT_EXCHANGER.recipeBuilder()
        .fluidInputs(fluid('oxygen_rich_liquid') * 150)
        .fluidInputs(fluid('liquid_argon_product') * 5)
        .fluidOutputs(fluid('subcooled_oxygen_rich_liquid') * 150)
        .fluidOutputs(fluid('partially_liquefied_argon') * 52)
        .duration(5)
        .buildAndRegister()

    PHASE_SEPARATOR.recipeBuilder()
        .fluidInputs(fluid('partially_liquefied_argon') * 2600)
        .fluidOutputs(fluid('argon') * 2400)
        .fluidOutputs(fluid('liquid_argon_product') * 200)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()
    
    CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('liquid_argon_product') * 100)
        .fluidOutputs(fluid('liquid_argon') * 75)
        .duration(1)
        .EUt(VA[ULV])
        .buildAndRegister()

//ADAPTED LOW PRESSURE RECIPE
LOW_PRESSURE_CRYO_DT.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('oxygen_rich_liquid') * 145)
    .fluidInputs(fluid('oxygen_rich_gas') * 400)
    .fluidInputs(fluid('nitrogen_rich_gas') * 1920)
    .fluidInputs(fluid('subcooled_liquid_nitrogen') * 150)
    .fluidOutputs(fluid('untreated_liquid_oxygen') * 105)
    .fluidOutputs(fluid('argon_rich_gas') * 2400) 
    .fluidOutputs(fluid('cold_waste_gaseous_nitrogen') * 480) 
    .fluidOutputs(fluid('liquid_nitrogen_product') * 380)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

//ADAPTED HEAT EXCHANGE (SUBCOOLING)
HEAT_EXCHANGER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('cold_waste_gaseous_nitrogen') * 480)
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 75)
    .fluidOutputs(fluid('chilly_waste_gaseous_nitrogen') * 480)
    .fluidOutputs(fluid('subcooled_liquid_nitrogen') * 75)
    .duration(5)
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .circuitMeta(2)
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 75)
    .fluidInputs(fluid('untreated_liquid_oxygen') * 105)
    .fluidOutputs(fluid('subcooled_liquid_nitrogen') * 75)
    .fluidOutputs(fluid('liquid_oxygen_product') * 105)
    .duration(5)
    .buildAndRegister()

//TIER THREE: RARE NOBLE GASES
/*per 24000 air charge:
0.432 Ne
0.12 He
0.0264 Kr
0.00216 Xe*/

//ADAPATED RECIPES
HIGH_PRESSURE_CRYO_DT.recipeBuilder()
    .circuitMeta(4)
    .fluidInputs(fluid('treated_liquid_nitrogen') * 50)
    .fluidInputs(fluid('liquid_decarburized_air') * 200)
    .fluidInputs(fluid('cold_hp_decarburized_air') * 11200)
    .fluidOutputs(fluid('oxygen_rich_liquid') * 150)
    .fluidOutputs(fluid('nitrogen_rich_gas') * 3520)
    .duration(10)
    .EUt(VA[LV])
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('cold_waste_gaseous_nitrogen') * 480)
    .fluidInputs(fluid('treated_liquid_nitrogen') * 75)
    .fluidOutputs(fluid('chilly_waste_gaseous_nitrogen') * 480)
    .fluidOutputs(fluid('subcooled_liquid_nitrogen') * 75)
    .duration(5)
    .buildAndRegister()

HEAT_EXCHANGER.recipeBuilder()
    .circuitMeta(3)
    .fluidInputs(fluid('treated_liquid_nitrogen') * 75)
    .fluidInputs(fluid('treated_liquid_oxygen') * 105)
    .fluidOutputs(fluid('subcooled_liquid_nitrogen') * 75)
    .fluidOutputs(fluid('liquid_oxygen_product') * 105)
    .duration(5)
    .buildAndRegister()

//HELIUM & NEON
SINGLE_COLUMN_CRYO_DT.recipeBuilder()
    .fluidInputs(fluid('untreated_liquid_nitrogen') * 200)
    .fluidOutputs(fluid('treated_liquid_nitrogen') * 199)
    .fluidOutputs(fluid('helium_neon_concentrate') * 48)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

//DEHYDROGENATION
FIXED_BR.recipeBuilder()
    .notConsumable(metaitem('catalystBedSupportedPlatinum'))
    .fluidInputs(fluid('helium_neon_concentrate') * 6000)
    .fluidInputs(fluid('oxygen') * 4)
    .fluidOutputs(fluid('dehydrogenated_helium_neon_concentrate') * 6000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .inputs(ore('dustMolecularSieveA'))
    .fluidInputs(fluid('dehydrogenated_helium_neon_concentrate') * 6000)
    .outputs(metaitem('dustWetMolecularSieveA'))
    .fluidOutputs(fluid('demoisturized_helium_neon_concentrate') * 6000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

FLUID_COMPRESSOR.recipeBuilder()
    .fluidInputs(fluid('demoisturized_helium_neon_concentrate') * 6000)
    .fluidOutputs(fluid('compressed_helium_neon_concentrate') * 250)
    .duration(500)
    .EUt(VA[HV])
    .buildAndRegister()

BATH_CONDENSER.recipeBuilder()
    .fluidInputs(fluid('liquid_nitrogen') * 125)
    .fluidOutputs(fluid('nitrogen') * 8000)
    .fluidInputs(fluid('compressed_helium_neon_concentrate') * 250)
    .fluidOutputs(fluid('treated_liquid_nitrogen') * 125)
    .fluidOutputs(fluid('helium_neon_mixture') * 69)
    .duration(100)
    .buildAndRegister()

PSA.recipeBuilder()
    .notConsumable(metaitem('membrane.zeolite'))
    .fluidInputs(fluid('helium_neon_mixture') * 69)
    .fluidOutputs(fluid('helium') * 54)
    .fluidOutputs(fluid('neon') * 15)
    .duration(500)
    .EUt(VA[HV])
    .buildAndRegister()
    
//KRYPTON & XENON
SINGLE_COLUMN_CRYO_DT.recipeBuilder()
    .fluidInputs(fluid('untreated_liquid_oxygen') * 105)
    .fluidOutputs(fluid('krypton_xenon_rich_liquid')) // Contains 0.0264 Kr and 0.00216 Xe gas
    .fluidOutputs(fluid('treated_liquid_oxygen') * 105)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('krypton_xenon_rich_liquid'))
    .fluidInputs(fluid('oxygen') * 10)
    .fluidOutputs(fluid('combusted_krypton_xenon_concentrate') * 48)
    .duration(5)
    .EUt(VA[LV])
    .buildAndRegister()

PSA.recipeBuilder()
    .notConsumable(metaitem('membrane.zeolite'))
    .fluidInputs(fluid('combusted_krypton_xenon_concentrate') * 22224)
    .fluidOutputs(fluid('purified_krypton_xenon_concentrate') * 22224)
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

SINGLE_COLUMN_CRYO_DT.recipeBuilder()
    .fluidInputs(fluid('purified_krypton_xenon_concentrate') * 22224)
    .fluidOutputs(fluid('krypton') * 12)
    .chancedFluidOutput(fluid('krypton'), 2222, 0)
    .fluidOutputs(fluid('liquid_crude_xenon'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('liquid_crude_xenon'))
    .fluidInputs(fluid('oxygen') * 10)
    .fluidOutputs(fluid('oxidized_xenon'))
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

PSA.recipeBuilder()
    .notConsumable(metaitem('membrane.zeolite'))
    .fluidInputs(fluid('oxidized_xenon'))
    .fluidOutputs(fluid('xenon'))
    .duration(100)
    .EUt(VA[HV])
    .buildAndRegister()
