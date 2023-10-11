import static globals.Globals.*
import static globals.SinteringGlobals.*

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;

def ROASTER = recipemap('roaster');
def DISTILLERY = recipemap('distillery');
def DT = recipemap('distillation_tower');
def MIXER = recipemap('mixer');
def ELECTROLYZER = recipemap('electrolyzer');
def CRYSTALLIZER = recipemap('crystallizer');
def CUTTER = recipemap('cutter');
def AUTOCLAVE = recipemap('autoclave');
def ZONEREFINER = recipemap('zone_refiner');
def VACUUMCHAMBER = recipemap('vacuum_chamber')
def FBR = recipemap('fixed_bed_reactor')
def SINTERING_RECIPES = recipemap("sintering_oven")
def EBF = recipemap('electric_blast_furnace')

// Silicon Carbide Plate * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('dustSiliconCarbide')], null)
// Phosphorus-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustSilicon') * 64, metaitem('dustPhosphorus') * 8, metaitem('dustSmallGalliumArsenide') * 2], [fluid('nitrogen') * 8000])
// Naquadah-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('blockSilicon') * 16, metaitem('ingotNaquadah'), metaitem('dustGalliumArsenide')], [fluid('argon') * 8000])
// Neutronium-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(7680, [metaitem('blockSilicon') * 32, metaitem('ingotNeutronium') * 4, metaitem('dustGalliumArsenide') * 2], [fluid('xenon') * 8000])

// Fix Hot Silicon Ingot conflict with dust
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSiliconDioxide') * 3, metaitem('dustCarbon') * 2], null)

EBF.recipeBuilder()
        .circuitMeta(2)
        .inputs(ore('dustSiliconDioxide') * 3)
        .inputs(ore('dustCarbon') * 2)
        .outputs(metaitem('dustSilicon'))
        .outputs(metaitem('dustTinyAsh'))
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .blastFurnaceTemp(1200)
        .duration(240)
        .EUt(120)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustSilicon'))
        .fluidInputs(fluid('chlorine') * 4000)
        .fluidOutputs(fluid('silicon_tetrachloride') * 1000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('silicon_tetrachloride') * 1000)
        .fluidOutputs(fluid('purified_silicon_tetrachloride') * 1000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('purified_silicon_tetrachloride') * 1000)
        .inputs(ore('dustZinc') * 2)
        .outputs(metaitem('dustHighPuritySilicon'))
        .fluidOutputs(fluid('zinc_chloride') * 864)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustSilicon'))
        .fluidInputs(fluid('hydrogen_chloride') * 3000)
        .fluidOutputs(fluid('trichlorosilane') * 1000)
        .fluidOutputs(fluid('hydrogen') * 2000)
        .duration(80)
        .EUt(30)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('trichlorosilane') * 1000)
        .fluidOutputs(fluid('purified_trichlorosilane') * 1000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('purified_trichlorosilane') * 1000)
        .inputs(ore('dustZinc') * 1)
        .outputs(metaitem('dustHighPuritySilicon'))
        .fluidOutputs(fluid('zinc_chloride') * 432)
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .fluidInputs(fluid('zinc_chloride') * 432)
        .notConsumable(metaitem('stickIron'))
        .notConsumable(metaitem('stickNickel'))
        .outputs(metaitem('dustZinc'))
        .fluidOutputs(fluid('chlorine') * 2000)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

VACUUMCHAMBER.recipeBuilder()
        .fluidInputs(fluid("silicon_dioxide") * 1008)
        .notConsumable(metaitem('shape.mold.crucible'))
        .outputs(metaitem('crucible.quartz'))
        .duration(1440)
        .EUt(30)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('high_purity_silicon') * 4608)
        .inputs(metaitem('seed_crystal.silicon'))
        .notConsumable(metaitem('crucible.quartz'))
        .outputs(metaitem('unrefined_boule.silicon'))
        .duration(9000)
        .EUt(120)
        .buildAndRegister()

ZONEREFINER.recipeBuilder()
        .inputs(metaitem('unrefined_boule.silicon'))
        .outputs(metaitem('boule.silicon'))
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

CUTTER.recipeBuilder()
        .fluidInputs(fluid('ultrapure_water') * 100)
        .inputs(metaitem('boule.silicon'))
        .outputs(metaitem('wafer.silicon') * 16)
        .outputs(metaitem('seed_crystal.silicon'))
        .duration(400)
        .EUt(64)
        .buildAndRegister()

AUTOCLAVE.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 1000)
        .inputs(ore('dustHighPuritySilicon'))
        .chancedOutput(metaitem('seed_crystal.silicon'), 1000, 500)
        .duration(1200)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('silicon_tetrachloride') * 3000)
        .fluidInputs(fluid('hydrogen') * 4000)
        .inputs(ore('dustSilicon'))
        .fluidOutputs(fluid('trichlorosilane') * 4000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .fluidInputs(fluid('trichlorosilane') * 2000)
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidOutputs(fluid('disproportionated_trichlorosilane') * 2000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('disproportionated_trichlorosilane') * 2000)
        .fluidOutputs(fluid('dichlorosilane') * 1000)
        .fluidOutputs(fluid('silicon_tetrachloride') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .fluidInputs(fluid('dichlorosilane') * 2000)
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidOutputs(fluid('disproportionated_dichlorosilane') * 2000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('disproportionated_dichlorosilane') * 2000)
        .fluidOutputs(fluid('trichlorosilane') * 1000)
        .fluidOutputs(fluid('chlorosilane') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .fluidInputs(fluid('chlorosilane') * 2000)
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidOutputs(fluid('disproportionated_chlorosilane') * 2000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('disproportionated_chlorosilane') * 2000)
        .fluidOutputs(fluid('dichlorosilane') * 1000)
        .fluidOutputs(fluid('silane') * 1000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

for (fuel in sintering_fuels) {
    if (fuel.isPlasma) {
        SINTERING_RECIPES.recipeBuilder()
                .notConsumable(metaitem('shape.mold.plate'))
                .inputs(ore('dustSiliconCarbide'))
                .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                .outputs(metaitem('plateSiliconCarbide'))
                .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                .duration(fuel.duration)
                .EUt(Globals.voltAmps[3])
                .buildAndRegister()

    } else {
        for (comburent in sintering_comburents) {
            SINTERING_RECIPES.recipeBuilder()
                    .notConsumable(metaitem('shape.mold.plate'))
                    .inputs(ore('dustSiliconCarbide'))
                    .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
                    .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
                    .outputs(metaitem('plateSiliconCarbide'))
                    .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
                    .duration(fuel.duration + comburent.duration)
                    .EUt(Globals.voltAmps[1])
                    .buildAndRegister()
        }
    }
}