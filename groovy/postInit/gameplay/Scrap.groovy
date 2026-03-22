import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*
import gregtech.api.recipes.chance.output.ChancedOutputLogic

// Earth
SALVAGING.recipeBuilder()
    .inputs(Planetoid.PLANETOIDS.inverse().get(0).getDisplayItem())
    .outputs(metaitem('scrap.commercial') * 2)
    .outputs(metaitem('scrap.parts'))
    .chancedOutput(metaitem('scrap.supply'), 8000, 0)
    .chancedOutput(metaitem('scrap.commercial'), 3000, 0)
    .chancedOutput(metaitem('scrap.supply'), 2000, 0)
    .chancedOutput(metaitem('scrap.military'), 1000, 0)
    .chancedOutput(metaitem('scrap.parts'), 500, 0)
    .chancedOutput(metaitem('scrap.commercial') * 3, 200, 0)
    .chancedOutput(metaitem('scrap.military'), 100, 0)
    .duration(5000)
    .buildAndRegister()

// Moon
SALVAGING.recipeBuilder()
    .inputs(Planetoid.PLANETOIDS.inverse().get(800).getDisplayItem())
    .outputs(metaitem('scrap.supply') * 2)
    .outputs(metaitem('scrap.commercial'))
    .outputs(metaitem('scrap.parts'))
    .chancedOutput(metaitem('scrap.supply'), 8000, 0)
    .chancedOutput(metaitem('scrap.parts'), 5000, 0)
    .chancedOutput(metaitem('scrap.military'), 2000, 0)
    .chancedOutput(metaitem('scrap.commercial'), 1000, 0)
    .chancedOutput(metaitem('scrap.parts') * 2, 500, 0)
    .chancedOutput(metaitem('scrap.military'), 200, 0)
    .duration(6000)
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
        .duration(600 - 5 * i)
        .buildAndRegister()
}

SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('scrap.military'))
    .notConsumed(metaitem('sensor.hv'))
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
    .notConsumed(metaitem('sensor.hv'))
    .chancedOutput(metaitem('scrap.commercial.lootbox'), 8700, 10)
    .chancedOutput(metaitem('scrap.unusable'), 3000, -300)
    .chancedOutput(metaitem('scrap.commercial.food'), 7000, 10)    
    .chancedOutput(metaitem('scrap.commercial.data'), 2000, 1000)
    .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
    .chancedOutputLogic(ChancedOutputLogic.XOR)
    .EUt(VA[HV])
    .duration(500)
    .buildAndRegister()

void scrapRecipes(Closure recipeBuilder) {
    for (def i = 0; i < 6; i++) {
        recipeBuilder.call(SCRAP_RECYCLER.recipeBuilder()
                .chancedOutput(metaitem('scrap.unusable'), 1600, decreases[i])
                .chancedOutputLogic(ChancedOutputLogic.XOR))
            .inputs(robotArms[i])
            .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
            .EUt(VA[HV])
            .duration(600 - 5 * i)
            .buildAndRegister()
    }

    recipeBuilder.call(SCRAP_RECYCLER.recipeBuilder()
                .chancedOutput(metaitem('scrap.unusable'), 3000, -25)
                .chancedOutputLogic(ChancedOutputLogic.XOR))
        .notConsumed(metaitem('sensor.hv'))
        .chancedOutput(metaitem('scrap.unusable'), 10000, 0)
        .chancedOutputLogic(ChancedOutputLogic.XOR)
        .EUt(VA[HV])
        .duration(500)
        .buildAndRegister()
}

scrapRecipes(builder -> builder
        .inputs(metaitem('scrap.supply'))
        .chancedOutput(metaitem('scrap.unusable'), 1600, decreases[i])
        .chancedOutput(metaitem('scrap.supply.wiring'), 6000, 0)
        .chancedOutput(metaitem('scrap.supply.alloy'), 7000, 0)    
        .chancedOutput(metaitem('scrap.supply.chemical'), 2000, 0)
        .chancedOutput(metaitem('scrap.supply.biological'), 2000, 0)
        .chancedOutput(metaitem('scrap.supply.circuitry'), 2000, 0)
        .chancedOutput(metaitem('scrap.supply.component'), 2000, 0))


scrapRecipes(builder -> builder
        .inputs(metaitem('scrap.parts'))
        .chancedOutput(metaitem('scrap.parts.cladding'), 2000, 0)
        .chancedOutput(metaitem('scrap.parts.engine'), 4000, 0)
        .chancedOutput(metaitem('scrap.parts.life_support'), 6000, 0)
        .chancedOutput(metaitem('scrap.parts.energy'), 2000, 0))

// Commercial
// TODO: actual lootboxes
SCRAP_RECYCLER.recipeBuilder()
    .inputs(metaitem('scrap.commercial.lootbox'))
    .notConsumed(metaitem('robot.arm.lv'))
    .chancedOutput(metaitem('scrap.unusable'), 6000, 0)
    .chancedOutput(metaitem('food.protein_paste'), 4000, 0)
    .chancedOutput(metaitem('food.cellulose_reformate'), 4000, 0)
    .chancedOutput(metaitem('food.glue_pizza'), 1000, 0)
    .chancedOutput(metaitem('coin.doge'), 1000, 0)
    .chancedOutput(item('betterquesting:guide_book', 1000, 0))
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
    .chancedOutput(metaitem('foilPolyvinylChloride') * 8, 1500, 20)
    .chancedOutput(metaitem('cableGtOctalAluminium') * 8, 3500, 100)
    .chancedOutput(metaitem('energy_hatch.input.ev'), 400, 40)
    .chancedOutput(metaitem('transformer.hi_amp.ev'), 200, 50)
    .chancedOutput(metaitem('wireGtDoubleIndiumTinBariumTitaniumCuprate') * 8, 500, 60)
    .chancedOutput(item('industrialrenewal:coil_hv') * 8, 1000, 70))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.component'))
    .chancedOutput(metaitem('stickLongNeodymiumAlloyMagnetic') * 8, 1500, 10)
    .chancedOutput(metaitem('stickLongSamariumAlloyMagnetic') * 4, 500, 20)
    .chancedOutput(metaitem('electric.motor.ev') * 2, 1500, 30)
    .chancedOutput(metaitem('electric.pump.hv'), 1500, 40)
    .chancedOutput(metaitem('electric.motor.luv'), 200, 50)
    .chancedOutput(metaitem('field.generator.iv'), 200, 60)
    .chancedOutput(metaitem('zpm'), 50, 5))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.circuitry'))
    .chancedOutput(metaitem('component.smd.diode') * 32, 1500, 10)
    .chancedOutput(metaitem('circuit.microprocessor') * 16, 1000, 20)
    .chancedOutput(metaitem('plate.power_integrated_circuit'), 1500, 30)
    .chancedOutput(metaitem('die.cmos_cpu') * 8, 1500, 40)
    .chancedOutput(metaitem('circuit.crystal_processor'), 1500, 50)
    .chancedOutput(metaitem('circuit.crystal_computer'), 200, 60))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.circuitry'))
    .chancedOutput(metaitem('component.smd.diode') * 32, 1500, 10)
    .chancedOutput(metaitem('circuit.microprocessor') * 16, 1000, 20)
    .chancedOutput(metaitem('plate.power_integrated_circuit'), 1500, 30)
    .chancedOutput(metaitem('die.cmos_cpu') * 8, 1500, 40)
    .chancedOutput(metaitem('circuit.crystal_processor'), 1500, 50)
    .chancedOutput(metaitem('circuit.crystal_computer'), 200, 60))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.chemical'))
    .chancedOutput(metaitem('dustSulfur') * 32, 1500, 10)
    .chancedOutput(metaitem('dustPhosphorus') * 32, 1500, 20)
    .chancedOutput(metaitem('dustAlumina') * 32, 1500, 30)
    .chancedOutput(metaitem('dustSodiumHydroxide') * 32, 1500, 40)
    .chancedOutput(metaitem('dustAmmoniumNitrate') * 32, 1500, 50)
    .chancedOutput(metaitem('dustSodiumCyanide') * 32, 1500, 60)
    .chancedFluidOutput(fluid('alfol_trialkylaluminium_mixture') * 32000, 1500, 40)
    .chancedFluidOutput(fluid('sulfuric_acid') * 48000, 1500, 40)
    .chancedFluidOutput(fluid('ethylene') * 32000, 1500, 40))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.supply.alloy'))
    .chancedOutput(metaitem('ingotHsla980x') * 64, 2500, 10)
    .chancedOutput(metaitem('ingotMonel500') * 32, 1500, 20)
    .chancedOutput(metaitem('ingotAluminiumAlloy7075') * 32, 1500, 30)
    .chancedOutput(metaitem('ingotZircaloy4') * 32, 1500, 40)
    .chancedOutput(metaitem('ingotScandiumAlloy') * 8, 500, 10)
    .chancedOutput(metaitem('ingotReneN5') * 32, 1500, 50))

// TODO: Biological scrap

// Parts
scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.life_support'))
    .chancedOutput(metaitem('dustLithiumPeroxide') * 16, 4000, 40)
    .chancedOutput(metaitem('susy:air_disperser'), 4000, 40)
    .chancedFluidOutput(fluid('nitrogen') * 32000, 1500, 40)
    .chancedFluidOutput(fluid('oxygen') * 32000, 1500, 40))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.engine'))
    .chancedOutput(metaitem('frangible_nut') * 16, 4000, 40)
    .chancedOutput(metaitem('fuel_injector') * 4, 4000, 40)
    .chancedOutput(metaitem('turbine_rotor').withNbt(['GT.PartStats': ['Material': 'susy:mar_m_246']]), 3000, 40)
    .chancedOutput(item('susy:rocket_nozzle'), 2000, 40)
    .chancedOutput(item('susy:rocket_turbopump'), 2000, 80))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.cladding'))
    .chancedOutput(metaitem('frangible_nut') * 16, 4000, 40)
    .chancedOutput(item('susy:rocket_tank_shell', 6) * 16, 4000, 40)
    .chancedOutput(item('susy:rocket_fairing_connector'), 2000, 40)
    .chancedOutput(item('susy:rocket_interstage'), 2000, 40))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.parts.energy'))
    .chancedOutput(item('susy:spacecraft_instrument', 6), 4000, 40)
    .chancedOutput(metaitem('battery.ni_zn.hv') * 3, 4000, 40)
    .chancedOutput(item('susy:spacecraft_instrument', 5), 2000, 40)
    .chancedOutput(metaitem('cover.solar.panel.lv'), 100, 60)
    .chancedOutput(metaitem('cover.solar.panel.mv'), 10, 60)
    .chancedOutput(metaitem('susy:rtg.lv'), 20, 60))

// Military
scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.military.weaponry'))
    .chancedOutput(item('techguns:itemshared', 17) * 32, 2000, 40)
    .chancedOutput(metaitem('battery.ni_zn.hv') * 3, 2000, 40)
    .chancedOutput(item('susy:spacecraft_instrument', 5), 2000, 40)
    .chancedOutput(item('techguns:itemshared', 143) * 32, 2000, 60)
    .chancedOutput(item('openmodularturrets:turret_base', 4), 100, 30))

scrapRecipes(builder -> builder
    .inputs(metaitem('scrap.military.armor'))
    .chancedOutput(metaitem('plateUltraHighMolecularWeightPolyethylene') * 32, 1500, 30)
    .chancedOutput(metaitem('plateKevlar') * 16, 1500, 30)
    .chancedOutput(metaitem('plateNomex') * 16, 1000, 30)
    .chancedOutput(metaitem('plateBoronNitride') * 32, 1500, 30)
    .chancedOutput(item('techguns:riot_shield'), 1000, 30)
    .chancedOutput(item('techguns:grimreaper'), 500, 30))

for (def i = 0; i < 6; i++) {
    SCRAP_RECYCLER.recipeBuilder()
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
        .duration(1000 - 5 * i)
        .buildAndRegister()
}
SCRAP_RECYCLER.recipeBuilder()
    .chancedOutput(metaitem('scrap.unusable'), 5000, -25)
    .chancedOutputLogic(ChancedOutputLogic.OR)
    .notConsumed(metaitem('sensor.hv'))
     //.chancedOutput(metaitem('susy:fluix_energy_core'))
    .chancedOutput(item('appliedenergistics2:part:16') * 8, 2000, 50)
    .chancedOutput(item('appliedenergistics2:material:43'), 2000, 50)
    .chancedOutput(item('appliedenergistics2:material:44'), 2000, 50)
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
    .chancedOutput(metaitem('dustDarkAsh') * 3, 8000, 0)
    .EUt(VA[LV])
    .duration(91)
    .buildAndRegister()