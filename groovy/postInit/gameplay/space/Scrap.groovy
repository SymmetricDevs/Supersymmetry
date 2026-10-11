import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.chance.output.ChancedOutputLogic
import supersymmetry.api.space.Planetoid
// Earth
SALVAGING.recipeBuilder()
    .inputs(Planetoid.PLANETOIDS.inverse().get(0).getDisplayItem())
    .outputs(metaitem('susy:orbital.scrap.earth') * 60)
    .duration(6000)
    .buildAndRegister()

SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('susy:orbital.scrap.earth'))
    .outputs(metaitem('scrap.supply') * 2)
    .outputs(metaitem('scrap.commercial'))
    .outputs(metaitem('scrap.parts'))
    .chancedOutput(metaitem('scrap.supply'), 8000, 0)
    .chancedOutput(metaitem('scrap.parts'), 5000, 0)
    .chancedOutput(metaitem('scrap.military'), 2000, 0)
    .chancedOutput(metaitem('scrap.commercial'), 1000, 0)
    .chancedOutput(metaitem('scrap.parts') * 2, 500, 0)
    .chancedOutput(metaitem('scrap.military'), 200, 0)
    .duration(300)
    .EUt(VA[HV])
    .buildAndRegister()


// Have fun!
def robotArms = [metaitem('robot.arm.mv'), metaitem('robot.arm.hv'),
                 metaitem('robot.arm.ev'), metaitem('robot.arm.iv'),
                 metaitem('robot.arm.luv'), metaitem('robot.arm.zpm')];
def decreases = [-50, -100, -200, -400, -1000, -2000]

for (def i = 0; i < 6; i++) {
    SCRAP_RECYCLER.recipeBuilder()
        .inputs(metaitem('scrap.military'))
        .inputs(robotArms[i])
        .chancedOutput(metaitem('scrap.unusable'), 2000, decreases[i])
        .chancedOutput(metaitem('scrap.military.weaponry'), 4000, 500)
        .chancedOutput(metaitem('scrap.military.unknown'), 1000, 2000)
        .chancedOutput(metaitem('scrap.military.armor'), 1500, 5000)
        .chancedOutput(metaitem('scrap.military.unknown') * 2, 2000, 4000)
        .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
        .chancedOutputLogic(ChancedOutputLogic.XOR)
        .EUt(VA[HV])
        .duration(400 - 60 * i)
        .buildAndRegister()
}

SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('scrap.military'))
    .notConsumable(metaitem('sensor.hv'))
    .chancedOutput(metaitem('scrap.unusable'), 8500, -50)
    .chancedOutput(metaitem('scrap.military.weaponry'), 4000, 500)
    .chancedOutput(metaitem('scrap.military.unknown'), 1000, 2000)
    .chancedOutput(metaitem('scrap.military.armor'), 1500, 5000)
    .chancedOutput(metaitem('scrap.military.unknown') * 2, 2000, 4000)
    .chancedOutputLogic(ChancedOutputLogic.XOR)
    .EUt(VA[HV])
    .duration(500)
    .buildAndRegister()

SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('scrap.commercial'))
    .notConsumable(metaitem('sensor.hv'))
    .chancedOutput(metaitem('scrap.commercial.lootbox'), 7000, 10)
    .chancedOutput(metaitem('scrap.unusable'), 3000, -300)
    .chancedOutput(metaitem('scrap.commercial.food'), 5500, 10)
    .chancedOutput(metaitem('scrap.commercial.data'), 2000, 1000)
    .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
    .chancedOutputLogic(ChancedOutputLogic.XOR)
    .EUt(VA[HV])
    .duration(500)
    .buildAndRegister()

void scrapRecipes(Closure recipeBuilder) {
    def robotArms = [metaitem('robot.arm.mv'), metaitem('robot.arm.hv'),
                 metaitem('robot.arm.ev'), metaitem('robot.arm.iv'),
                 metaitem('robot.arm.luv'), metaitem('robot.arm.zpm')];
    def decreases = [-50, -100, -200, -400, -1000, -2000]
    for (def i = 0; i < 6; i++) {
        recipeBuilder.call(SCRAP_RECYCLER.recipeBuilder()
                .chancedOutput(metaitem('scrap.unusable'), 1600, decreases[i])
                .chancedOutputLogic(ChancedOutputLogic.XOR))
            .inputs(robotArms[i])
            .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
            .EUt(VA[HV])
            .duration(400 - 60 * i)
            .buildAndRegister()
    }

    recipeBuilder.call(SCRAP_RECYCLER.recipeBuilder()
                .chancedOutput(metaitem('scrap.unusable'), 3000, -25)
                .chancedOutputLogic(ChancedOutputLogic.XOR))
        .notConsumable(metaitem('sensor.hv'))
        .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
        .chancedOutputLogic(ChancedOutputLogic.XOR)
        .EUt(VA[HV])
        .duration(500)
        .buildAndRegister()
}

scrapRecipes(builder -> builder
        .inputs(metaitem('scrap.supply'))
        .chancedOutput(metaitem('scrap.supply.wiring'), 2500, 0)
        .chancedOutput(metaitem('scrap.supply.alloy'), 3000, 0)
        .chancedOutput(metaitem('scrap.supply.chemical'), 2000, 0)
        .chancedOutput(metaitem('scrap.supply.biological'), 2000, 0)
        .chancedOutput(metaitem('scrap.supply.circuitry'), 2000, 0)
        .chancedOutput(metaitem('scrap.supply.component'), 2000, 0))


scrapRecipes(builder -> builder
        .inputs(metaitem('scrap.parts'))
        .chancedOutput(metaitem('scrap.parts.cladding'), 2000, 0)
        .chancedOutput(metaitem('scrap.parts.engine'), 2000, 0)
        .chancedOutput(metaitem('scrap.parts.life_support'), 2000, 0)
        .chancedOutput(metaitem('scrap.parts.energy'), 2000, 0))

// Commercial
// TODO: actual lootboxes
SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('scrap.commercial.lootbox'))
    .notConsumable(metaitem('robot.arm.lv'))
    .chancedOutput(metaitem('scrap.unusable'), 6000, 0)
    .chancedOutput(metaitem('food.protein_paste'), 4000, 0)
    .chancedOutput(metaitem('food.cellulose_reformate'), 4000, 0)
    .chancedOutput(metaitem('food.glue_pizza'), 1000, 0)
    .chancedOutput(metaitem('coin.doge'), 1000, 0)
    .chancedOutput(metaitem('record.sus'), 1, 0)
    .chancedOutput(item('betterquesting:quest_book'), 1000, 0)
    .EUt(VA[MV])
    .duration(100)
    .buildAndRegister()

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.commercial.food'))
    .chancedOutput(metaitem('gregtechfoodoption:food.ice_cream.chip'), 1000, 10)
    .chancedOutput(metaitem('gregtechfoodoption:food.bruschetta'), 1000, 20)
    .chancedOutput(metaitem('gregtechfoodoption:food.kebab.soltani'), 1000, 30)
    .chancedOutput(metaitem('gregtechfoodoption:food.pizza.veggie'), 1000, 40)
    .chancedOutput(metaitem('gregtechfoodoption:food.full_breakfast'), 1000, 50)
    .chancedOutput(metaitem('gregtechfoodoption:food.pasta_all\'amogus'), 1000, 60)
    .chancedOutput(metaitem('food.organic_ocean_powder'), 1000, 70))

// TODO: data

// Supply
scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.wiring'))
    .chancedOutput(metaitem('foilStyreneButadieneRubber') * 32, 2500, 10)
    .chancedOutput(metaitem('foilPolyvinylChloride') * 32, 1500, 20)
    .chancedOutput(metaitem('cableGtDoubleCopper') * 64, 3000, 100)
    .chancedOutput(metaitem('cableGtSingleSilver') * 4, 1000, 100)
    .chancedOutput(metaitem('cableGtSingleAluminium') * 64, 3000, 100)
    .chancedOutput(metaitem('cableGtOctalAluminium') * 8, 1500, 100)
    .chancedOutput(metaitem('energy_hatch.input.ev'), 400, 40)
    .chancedOutput(metaitem('energy_hatch.input.iv'), 150, 10)
    .chancedOutput(metaitem('susy:substation_energy_hatch.output_64a.ev'), 100, 10)
    .chancedOutput(metaitem('transformer.hi_amp.ev'), 200, 50)
    .chancedOutput(metaitem('wireGtOctalUraniumTriplatinum') * 8, 2000, 240)
    .chancedOutput(metaitem('wireGtQuadrupleSamariumIronArsenicOxide') * 8, 1000, 120)
    .chancedOutput(metaitem('wireGtDoubleIndiumTinBariumTitaniumCuprate') * 8, 500, 60)
    .chancedOutput(item('industrialrenewal:coil_hv') * 8, 1000, 70))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.component'))
    .chancedOutput(metaitem('stickLongNeodymiumAlloyMagnetic') * 8, 1500, 10)
    .chancedOutput(metaitem('stickLongSamariumAlloyMagnetic') * 4, 500, 20)
    .chancedOutput(metaitem('electric.motor.ev') * 8, 2400, 320)
    .chancedOutput(metaitem('electric.motor.iv') * 4, 1500, 50)
    .chancedOutput(metaitem('electric.motor.luv') * 2, 300, 30)
    .chancedOutput(metaitem('electric.piston.luv') * 1, 200, 30)
    .chancedOutput(metaitem('electric.pump.ev'), 2700, 90)
    .chancedOutput(metaitem('electric.pump.iv'), 900, 40)
    .chancedOutput(metaitem('electric.pump.luv'), 150, 20)
    .chancedOutput(metaitem('field.generator.iv'), 200, 60)
    .chancedOutput(metaitem('zpm'), 1, 1))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.circuitry'))
    .chancedOutput(metaitem('component.resistor.carbon_film') * 32, 2500, 10)
    .chancedOutput(metaitem('component.bme_cap') * 32, 2500, 10)
    .chancedOutput(metaitem('component.transistor.vdmos') * 16, 2000, 10)
    .chancedOutput(metaitem('component.diode.planar') * 16, 2000, 10)
    .chancedOutput(metaitem('component.smd.inductor') * 16, 2000, 10)
    .chancedOutput(metaitem('component.nmos_cpu') * 12, 1500, 30)
    .chancedOutput(metaitem('plate.power_integrated_circuit') * 3, 900, 50)
    .chancedOutput(metaitem('plate.high_power_integrated_circuit'), 350, 30)
    .chancedOutput(metaitem('circuit.nano_processor') * 8, 350, 20)
    .chancedOutput(metaitem('circuit.quantum_processor') * 1, 50, 40))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.chemical'))
    .chancedOutput(metaitem('dustSulfur') * 32, 1000, 10)
    .chancedOutput(metaitem('dustPhosphorus') * 32, 1000, 20)
    .chancedOutput(metaitem('dustSodiumHydroxide') * 32, 1000, 40)
    .chancedOutput(metaitem('dustAmmoniumNitrate') * 32, 1000, 50)
    .chancedOutput(metaitem('dustFluorite') * 32, 1000, 60)
    .chancedOutput(metaitem('dustRockSalt') * 32, 1000, 60)
    .chancedOutput(metaitem('dustSodiumBromide') * 8, 750, 50)
    .chancedOutput(metaitem('dustTungstenTrioxide') * 12, 400, 40)
    .chancedOutput(metaitem('dustZirconiumTetrachloride') * 8, 300, 30)
    .chancedOutput(metaitem('wireFinePlatinumRhodium') * 8, 100, 20)
    .chancedOutput(metaitem('dustTinyAmmoniumHexachloroiridate') * 2, 100, 20)
    .chancedFluidOutput(fluid('alfol_trialkylaluminium_mixture') * 32000, 1500, 40)
    .chancedFluidOutput(fluid('sulfuric_acid') * 48000, 1500, 40)
    .chancedFluidOutput(fluid('ethylene') * 32000, 1500, 40))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.alloy'))
    .chancedOutput(metaitem('ingotHsla980X') * 64, 2500, 10)
    .chancedOutput(metaitem('ingotMonel500') * 32, 1500, 20)
    .chancedOutput(metaitem('ingotGrcop84') * 32, 1500, 30)
    .chancedOutput(metaitem('ingotMarM246') * 32, 1500, 30)
    .chancedOutput(metaitem('ingotZircaloy4') * 32, 2500, 40)
    .chancedOutput(metaitem('ingotReneN5') * 32, 1500, 50)
    .chancedOutput(metaitem('ingotHaynes230') * 8, 1500, 50))

// TODO: Biological scrap

// Parts
scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.life_support'))
    .chancedOutput(metaitem('dustLithiumHydroxide') * 4, 2000, 40)
    .chancedOutput(metaitem('dustLithiumPeroxide') * 4, 2000, 40)
    .chancedOutput(metaitem('susy:air_disperser'), 1000, 40)
    .chancedOutput(metaitem('space_suit.plss'), 100, 40)
    .chancedOutput(metaitem('susy:astronaut_helmet'), 35, 10)
    .chancedOutput(metaitem('susy:astronaut_chestplate'), 35, 10)
    .chancedOutput(metaitem('susy:astronaut_leggings'), 35, 10)
    .chancedOutput(metaitem('susy:astronaut_boots'), 35, 10)
    .chancedFluidOutput(fluid('nitrogen') * 32000, 1500, 40)
    .chancedFluidOutput(fluid('oxygen') * 32000, 1500, 40)
    .chancedFluidOutput(fluid('coolant') * 4000, 1000, 40))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.engine'))
    .chancedOutput(metaitem('fuel_injector') * 1, 4000, 40)
    .chancedOutput(metaitem('rotorMarM246') * 1, 1500, 80)
    .chancedOutput(metaitem('turbine_rotor').withNbt(['GT.PartStats': ['Material': 'susy:mar_m_246']]), 500, 40)
    .chancedOutput(item('susy:rocket_nozzle') * 8, 1000, 40)
    .chancedOutput(metaitem('gas_turbine_blade') * 4, 300, 20)
    .chancedOutput(metaitem('lunar_module_engine'), 100, 40)
    .chancedOutput(item('susy:rocket_combustion_chamber'), 2000, 80)
    .chancedOutput(item('susy:rocket_turbopump') * 2, 2000, 80)
    .chancedOutput(item('susy:rocket_turbopump', 4), 1000, 40)
    .chancedOutput(item('susy:rocket_turbopump', 8), 500, 20))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.cladding'))
    .chancedOutput(metaitem('frangible_nut') * 4, 4000, 40)
    .chancedOutput(metaitem('plateAluminiumAlloy7075') * 64, 3000, 30)
    .chancedOutput(metaitem('plateAluminiumAlloyMg6') * 64, 3000, 30)
    .chancedOutput(metaitem('plateAluminiumAlloy2195') * 32, 1000, 30)
    .chancedOutput(metaitem('foilMetallizedBopet') * 16, 1000, 30)
    .chancedOutput(item('susy:rocket_tank_shell') * 16, 4000, 40)
    .chancedOutput(item('susy:rocket_fairing_connector') * 4, 2000, 40)
    .chancedOutput(item('susy:rocket_interstage') * 4, 2000, 40)
    .chancedOutput(metaitem('carbon.tile.phenolic.treated') * 8, 1000, 20)
    .chancedOutput(metaitem('parachute.main') * 1, 250, 10))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.energy'))
    .chancedOutput(metaitem('battery.ni_cd.hv') * 8, 4000, 40)
    .chancedOutput(metaitem('battery.ni_mh.ev') * 4, 3000, 40)
    .chancedOutput(metaitem('battery.ni_mh.iv') * 2, 2000, 40)
    .chancedOutput(item('susy:spacecraft_instrument', 5), 2000, 40) // spacecraft battery
    .chancedOutput(item('susy:spacecraft_instrument', 3), 4000, 40) // spacecraft solar panel
    .chancedOutput(item('susy:spacecraft_instrument', 9), 1000, 20) // spacecraft fuel cell
    .chancedOutput(item('susy:spacecraft_instrument', 7), 30, 2) // spacecraft nuclear reactor
    .chancedOutput(metaitem('cell.multijunction_photovoltaic'), 500, 80)
    .chancedOutput(metaitem('susy:rtg.lv'), 400, 60)
    .chancedOutput(metaitem('susy:rtg.mv'), 60, 6))

// Military
scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.military.weaponry'))
    .chancedOutput(metaitem('dustRdx') * 32, 2000, 40)
    .chancedOutput(item('techguns:itemshared', 17) * 32, 2000, 40) // minigun drum
    .chancedOutput(item('susy:spacecraft_instrument', 5), 300, 40) // spacecraft arm
    .chancedOutput(item('techguns:itemshared', 143) * 32, 2000, 60) // explosive as50 mag
    .chancedOutput(item('openmodularturrets:ammo_meta', 4) * 32, 2000, 60) // rocket turret ammo
    .chancedOutput(item('openmodularturrets:turret_base', 4), 100, 30) // t5 turret base
    .chancedOutput(item('openmodularturrets:laser_turret'), 100, 30)
    .chancedOutput(item('icbmclassic:explosives', 15) * 1, 1, 0) // we do a little trolling...
    .chancedOutput(item('techguns:biogun') * 1, 100, 4)
    .chancedOutput(item('techguns:itemshared', 29) * 1, 250, 10) // energy cell
    .chancedOutput(item('techguns:itemshared', 25) * 4, 500, 12) // bio tank
    .chancedOutput(item('techguns:laserpistol') * 1, 1, 1))


scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.military.armor'))
    .chancedOutput(metaitem('plateUltraHighMolecularWeightPolyethylene') * 8, 1500, 30)
    .chancedOutput(metaitem('plateKevlar') * 4, 1500, 30)
    .chancedOutput(metaitem('plateNomex') * 4, 1000, 30)
    .chancedOutput(metaitem('plateBoronNitride') * 8, 1500, 30)
    .chancedOutput(metaitem('plateTungsten') * 2, 1500, 30)
    .chancedOutput(item('techguns:riot_shield'), 200, 30)
    .chancedOutput(item('ompd:hardened', 4) * 16, 1000, 30)
    .chancedOutput(item('techguns:t3_power_helmet') * 1, 5, 1)
    .chancedOutput(item('techguns:t3_power_chestplate') * 1, 5, 1)
    .chancedOutput(item('techguns:t3_power_leggings') * 1, 5, 1)
    .chancedOutput(item('techguns:t3_power_boots') * 1, 5, 1))

for (def i = 0; i < 6; i++) {
    SCRAP_RECYCLER.recipeBuilder()
        .inputs(metaitem('scrap.military.unknown'))
        .chancedOutput(metaitem('scrap.unusable'), 2000, decreases[i])
        .chancedOutputLogic(ChancedOutputLogic.OR)
        .inputs(robotArms[i])
        //.chancedOutput(metaitem('susy:fluix_energy_core'))
        .chancedOutput(item('appliedenergistics2:part:16') * 8, 2000, 50)
        .chancedOutput(item('appliedenergistics2:material:43'), 2000, 50)
        .chancedOutput(item('appliedenergistics2:material:44'), 2000, 50)
        .chancedOutput(metaitem('storage.segment'), 2000, 50)
        .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
        .EUt(VA[EV])
        .duration(1000 - 150 * i)
        .buildAndRegister()
}
SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('scrap.military.unknown'))
    .chancedOutput(metaitem('scrap.unusable'), 5000, -25)
    .chancedOutputLogic(ChancedOutputLogic.OR)
    .notConsumable(metaitem('sensor.iv'))
     //.chancedOutput(metaitem('susy:fluix_energy_core'))
    .chancedOutput(item('appliedenergistics2:part:16') * 8, 2000, 50)
    .chancedOutput(item('appliedenergistics2:material:43'), 3000, 50)
    .chancedOutput(item('appliedenergistics2:material:44'), 3000, 60)
    .chancedOutput(metaitem('storage.segment'), 2000, 50)
    .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
    .EUt(VA[EV])
    .duration(500)
    .buildAndRegister()

ARC_FURNACE.recipeBuilder()
    .inputs(metaitem('scrap.unusable'))
    .fluidInputs(fluid('oxygen') * 1000)
    .chancedOutput(metaitem('ingotSteel') * 6, 5000, 0)
    .chancedOutput(metaitem('ingotAnnealedCopper') * 3, 5000, 0)
    .chancedOutput(metaitem('ingotAluminium') * 3, 3000, 0)
    .chancedOutput(metaitem('dustDarkAsh') * 3, 8000, 0)
    .EUt(VA[LV])
    .duration(91)
    .buildAndRegister()