import globals.Globals

ASSEMBLER = recipemap('assembler')
PSA = recipemap('pressure_swing_adsorption')
AUTOCLAVE = recipemap('autoclave')
REACTION_FURNACE = recipemap('reaction_furnace')
BCR = recipemap('bubble_column_reactor')
RADIATOR = recipemap('radiator')
ROASTER = recipemap('roaster')
MIXER = recipemap('mixer')
DISTILLATION_TOWER = recipemap('distillation_tower')

ASSEMBLER.recipeBuilder()
    .circuitMeta(8)
    .inputs(ore('wireFineAluminium') * 8)
    .outputs(metaitem('zeolite_membrane_support'))
    .duration(180)
    .EUt(30)
    .buildAndRegister()

AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('distilled_water') * 1000)
    .inputs(ore('dustMolecularSieve') * 4)
    .inputs(metaitem('zeolite_membrane_support'))
    .outputs(metaitem('zeolite_membrane'))
    .duration(180)
    .EUt(30)
    .buildAndRegister()

PSA.recipeBuilder()
    .notConsumable(metaitem('zeolite_membrane'))
    .fluidInputs(fluid('air') * 10000)
    .fluidOutputs(fluid('nitrogen') * 7808)
    .fluidOutputs(fluid('oxygen') * 2095)
    .duration(100)
    .EUt(64)
    .buildAndRegister()

// Ammonia (Haber Process)

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hot_hp_air') * 1500)
    .fluidInputs(fluid('hydrogen') * 3000)
    .notConsumable(ore('dustWustiteCatalyst'))
    .fluidOutputs(fluid('ammonia_rich_gas') * 4000)
    .duration(160)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('hot_hp_nitrogen') * 1000)
    .fluidInputs(fluid('hydrogen') * 3000)
    .notConsumable(ore('dustWustiteCatalyst'))
    .fluidOutputs(fluid('ammonia_rich_gas') * 4000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .fluidInputs(fluid('ammonia_reaction_mix') * 4000)
    .notConsumable(ore('dustWustiteCatalyst'))
    .fluidOutputs(fluid('ammonia_rich_gas') * 4000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('ammonia_rich_gas') * 4000)
    .fluidInputs(fluid('water') * 500)
    .fluidOutputs(fluid('ammonia_solution') * 500)
    .fluidOutputs(fluid('ammonia_reaction_mix') * 2000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('ammonia_solution') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .fluidOutputs(fluid('ammonia') * 1000)
    .duration(150)
    .EUt(30)
    .buildAndRegister()

//Ostwald Process

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('mesh.platinum_rhodium') * 10)
    .fluidInputs(fluid('ammonia') * 5000)
    .fluidInputs(fluid('hot_hp_oxygen') * 10000)
    .fluidOutputs(fluid('nitric_oxide') * 4000)
    .fluidOutputs(fluid('water') * 6000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(metaitem('mesh.platinum') * 10)
    .fluidInputs(fluid('ammonia') * 5000)
    .fluidInputs(fluid('hot_hp_oxygen') * 10000)
    .fluidOutputs(fluid('nitric_oxide') * 3000)
    .fluidOutputs(fluid('water') * 6000)
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//Birkeland–Eyde Process

REACTION_FURNACE.recipeBuilder()
    .notConsumable(ore('stickCopper') * 2)
    .fluidInputs(fluid('nitrogen') * 1000)
    .fluidInputs(fluid('oxygen') * 1500)
    .fluidOutputs(fluid('hot_nitrogen_oxide_mixture') * 1000) //500L NO,500L NO2
    .duration(1200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

RADIATOR.recipeBuilder()
    .fluidInputs(fluid('hot_nitrogen_oxide_mixture') * 1000)
    .fluidOutputs(fluid('nitrogen_oxide_mixture') * 1000)
    .duration(20)
    .buildAndRegister();

ROASTER.recipeBuilder()
    .fluidInputs(fluid('oxygen') * 500)
    .fluidInputs(fluid('nitrogen_oxide_mixture') * 1000)
    .fluidOutputs(fluid('nitrogen_dioxide') * 1000)
    .duration(30)
    .EUt(30)
    .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
    .notConsumable(ore('stickCopper') * 2)
    .fluidInputs(fluid('air') * 10000) //assume this to be 8000L N, 2000L O
    .fluidInputs(fluid('oxygen') * 2800) //8000L N, 4800L O
    .fluidOutputs(fluid('hot_nitrogen_oxide_mixture_rich_air') * 10400) //8000L Air, 800L O, 800L NO, 800L NO2
    .duration(400)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

RADIATOR.recipeBuilder()
    .fluidInputs(fluid('hot_nitrogen_oxide_mixture_rich_air') * 1000)
    .fluidOutputs(fluid('nitrogen_oxide_mixture_rich_air') * 1000) 
    .duration(20)
    .buildAndRegister();

ROASTER.recipeBuilder()
    .fluidInputs(fluid('nitrogen_oxide_mixture_rich_air') * 5200)
    .fluidOutputs(fluid('nitrogen_dioxide_rich_air') * 4800) //4000L Air, 800L NO2
    .duration(15)
    .EUt(30)
    .buildAndRegister()

//Nitric Acid, Nitrogen Dioxide

BCR.recipeBuilder()
    .fluidInputs(fluid('water') * 50)
    .fluidInputs(fluid('nitrogen_dioxide') * 150)
    .fluidOutputs(fluid('nitric_acid') * 100)
    .fluidOutputs(fluid('nitric_oxide') * 50)
    .duration(12)
    .EUt(30)
    .buildAndRegister()

BCR.recipeBuilder()
    .fluidInputs(fluid('water') * 50)
    .fluidInputs(fluid('nitrogen_dioxide_rich_air') * 960) //150L NO2, 750L Air
    .fluidOutputs(fluid('nitric_acid') * 100)
    .fluidOutputs(fluid('nitric_oxide_rich_air') * 800) //50L NO, 750L Air - Waste gases
    .duration(12)
    .EUt(30)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('nitric_oxide') * 50)
    .fluidInputs(fluid('oxygen') * 50)
    .fluidOutputs(fluid('nitrogen_dioxide') * 50)
    .duration(8)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('diluted_nitric_acid') * 2000)
    .fluidOutputs(fluid('nitric_acid') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()