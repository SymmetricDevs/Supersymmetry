import static prePostInit.Recipemaps.*
import globals.Globals
import static gregtech.api.GTValues.*



ASSEMBLER.recipeBuilder()
    .inputs(ore('cableGtSingleTin') * 2)
    .inputs(metaitem('graphite_electrode'))
    .inputs(metaitem('component.glass.tube') * 1)
    .outputs(metaitem('carbon_arc_lamp') * 1)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(item('minecraft:string') * 4)
    .inputs(metaitem('wireGtSingleCopper') * 2)
    .inputs(ore('dustDarkAsh'))
    .chancedOutput(metaitem('carbon_filament') * 4, 5000, 0)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(item('biomesoplenty:bamboo') * 2)
    .inputs(metaitem('wireGtSingleCopper') * 2)
    .inputs(ore('dustDarkAsh'))
    .chancedOutput(metaitem('carbon_filament') * 4, 7500, 0)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(item('minecraft:string') * 4)
    .inputs(metaitem('wireGtSingleCopper') * 2)
    .fluidInputs(fluid('coal_tar') * 200)
    .chancedOutput(metaitem('carbon_filament') * 4, 7500, 0)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

ROASTER.recipeBuilder()
    .inputs(item('biomesoplenty:bamboo') * 2)
    .inputs(metaitem('wireGtSingleCopper') * 2)
    .fluidInputs(fluid('coal_tar') * 200)
    .outputs(metaitem('carbon_filament') * 4)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube'))
    .inputs(metaitem('carbon_filament'))
    .inputs(ore('ringKovar'))
    .outputs(metaitem('incandescent_light') * 1)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube'))
    .inputs(ore('wireFineTungsten'))
    .inputs(ore('ringKovar'))
    .fluidInputs(fluid('nitrogen') * 100)
    .outputs(metaitem('incandescent_light') * 1)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
    .inputs(ore('dustTricalciumPhosphate') * 5)
    .inputs(ore('dustCalcite') * 4)
    .inputs(ore('dustFluorite') * 2)
    .inputs(metaitem('dustAmmoniumChloride') * 2)
    .inputs(ore('dustTinyManganese'))
    .inputs(ore('dustTinyAntimonyTrioxide'))
    .outputs(metaitem('dustHalophosphatePhosphor') * 13)
    .duration(800)
    .EUt(VA[MV])
    .buildAndRegister();

MIXER.recipeBuilder()
    .inputs(metaitem('dustHalophosphatePhosphor') * 13)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('halophosphate_phosphor_solution') * 1000)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube') * 12)
    .inputs(ore('wireFineCupronickel') * 6)
    .inputs(ore('componentInductor'))
    .inputs(ore('componentCapacitor'))
    .fluidInputs(fluid('mercury') * 10)
    .fluidInputs(fluid('halophosphate_phosphor_solution') * 500)
    .outputs(metaitem('fluorescent_light') * 6)
    .fluidOutputs(fluid('dense_steam') * 500)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube') * 8)
    .inputs(ore('wireFineTungsten') * 2)
    .inputs(ore('foilMolybdenum') * 2)
    .fluidInputs(fluid('nitrogen') * 500)
    .inputs(ore('dustSmallIodine'))
    .outputs(metaitem('halogen_light') * 8)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube') * 8)
    .inputs(ore('wireFineTungsten') * 2)
    .inputs(ore('foilMolybdenum') * 2)
    .fluidInputs(fluid('nitrogen') * 500)
    .fluidInputs(fluid('bromine') * 200)
    .outputs(metaitem('halogen_light') * 8)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube') * 16)
    .inputs(ore('wireFineTungsten') * 2)
    .inputs(ore('foilMolybdenum') * 2)
    .fluidInputs(fluid('argon') * 500)
    .inputs(ore('dustSmallIodine'))
    .outputs(metaitem('halogen_light') * 16)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('component.glass.tube') * 16)
    .inputs(ore('wireFineTungsten') * 2)
    .inputs(ore('foilMolybdenum') * 2)
    .fluidInputs(fluid('argon') * 500)
    .fluidInputs(fluid('bromine') * 200)
    .outputs(metaitem('halogen_light') * 16)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister();

//If someone working on the laser rework wants to replace this go ahead just replace the YAG:Ce in the actual LED recipe
TUBE_FURNACE.recipeBuilder()
    .inputs(metaitem('dustAlumina')*10)
    .inputs(metaitem('dustYttriumOxide')*6)
    .inputs(metaitem('dustTinyCeriumIvOxide'))
    .fluidInputs(fluid('hydrogen') * 40)
    .fluidOutputs(fluid('dense_steam') * 20)
    .outputs(metaitem('dustYttriumAluminiumGarnetCerium') * 16)
    .EUt(VA[HV])
    .duration(400)
    .buildAndRegister()

ASSEMBLER.recipeBuilder()
    .inputs(metaitem('led_chip') * 32)
    .inputs(metaitem('dustYttriumAluminiumGarnetCerium'))
    .inputs(metaitem('wireFineTin') * 8)
    .fluidInputs(fluid('glass') * 288)
    .outputs(metaitem('led_light')*32)
    .EUt(VA[HV])
    .duration(400)
    .buildAndRegister()

ERF.recipeBuilder()
    .notConsumable(metaitem('shape.extruder.pipe.small'))
    .inputs(ore('dustSiliconDioxide') * 3)
    .outputs(metaitem('fused_quartz_bulb'))
    .duration(200)
    .EUt(120)
    .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('fused_quartz_bulb'))
    .inputs(ore('wireGtSingleSteel') * 2)
    .inputs(metaitem('wireFineNickel') * 2)
    .inputs(metaitem('component.glass.tube') * 2)
    .fluidInputs(fluid('mercury') * 200)
    .outputs(metaitem('lamp.mercury.hp.unfilled') * 2)
    .duration(160)
    .EUt(120)
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('lamp.mercury.hp.unfilled'))
    .inputs(metaitem('plateMica'))
    .inputs(ore('ringKovar'))
    .fluidInputs(fluid('nitrogen') * 400)
    .outputs(metaitem('lamp.mercury.hp'))
    .duration(60)
    .EUt(30)
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('fused_quartz_bulb') * 2)
    .inputs(ore('wireGtSingleSteel') * 2)
    .inputs(metaitem('wireFineNickel') * 2)
    .fluidInputs(fluid('mercury') * 5)
    .fluidInputs(fluid('argon') * 200)
    .outputs(metaitem('lamp.mercury.lp') * 1)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister();

VACUUM_CHAMBER.recipeBuilder()
    .inputs(metaitem('fused_quartz_bulb') * 2)
    .inputs(ore('wireGtSingleSteel') * 2)
    .inputs(metaitem('wireFineNickel') * 2)
    .fluidInputs(fluid('mercury') * 10)
    .chancedOutput(metaitem('lamp.mercury.lp') * 1, 1000, 0)
    .duration(160)
    .EUt(VA[MV])
    .buildAndRegister();

crafting.addShapeless('BegoneArcLamp', metaitem('incandescent_light'), [metaitem('carbon_arc_lamp')]) 
