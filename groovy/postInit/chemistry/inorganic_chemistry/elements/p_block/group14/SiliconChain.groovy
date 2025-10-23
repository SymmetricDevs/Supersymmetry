import static prePostInit.Recipemaps.*
import globals.Carbons
import globals.Sintering

import static gregtech.api.GTValues.*
import gregtech.api.recipes.ModHandler
import gregtech.api.unification.material.Materials
import gregtech.api.unification.ore.OrePrefix
import gregtech.api.unification.stack.UnificationEntry

// Silicon Carbide Plate * 1
mods.gregtech.compressor.removeByInput(2, [metaitem('dustSiliconCarbide')], null)
// Phosphorus-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(480, [metaitem('dustSilicon') * 64, metaitem('dustPhosphorus') * 8, metaitem('dustSmallGalliumArsenide') * 2], [fluid('nitrogen') * 8000])
// Naquadah-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(1920, [metaitem('blockSilicon') * 16, metaitem('ingotNaquadah'), metaitem('dustGalliumArsenide')], [fluid('argon') * 8000])
// Neutronium-doped Monocrystalline Silicon Boule * 1
mods.gregtech.electric_blast_furnace.removeByInput(7680, [metaitem('blockSilicon') * 32, metaitem('ingotNeutronium') * 4, metaitem('dustGalliumArsenide') * 2], [fluid('xenon') * 8000])
// Raw Silicon Wafer * 14
mods.gregtech.cutter.removeByInput(64, [metaitem('boule.silicon')], [fluid('lubricant') * 225])
// Raw Silicon Wafer * 14
mods.gregtech.cutter.removeByInput(64, [metaitem('boule.silicon')], [fluid('distilled_water') * 676])
// Raw Silicon Wafer * 14
mods.gregtech.cutter.removeByInput(64, [metaitem('boule.silicon')], [fluid('water') * 900])

// Fix Hot Silicon Ingot conflict with dust
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustSiliconDioxide') * 3, metaitem('dustCarbon') * 2], null)

//Silicon & Graphite

def quartz_dusts = [
        'dustSiliconDioxide',
        'dustCertusQuartz',
        'dustNetherQuartz',
        'dustQuartzite'
]

for (quartz in quartz_dusts) {
        for (carbon in Carbons.dusts()) {
                ARC_FURNACE.recipeBuilder()
                        .circuitMeta(1)
                        .fluidInputs(fluid('air') * 100)
                        .inputs(ore(quartz) * 3)
                        .inputs(ore(carbon.name) * carbon.equivalent(2))
                        .outputs(metaitem('dustSilicon'))
                        .fluidOutputs(fluid('carbon_monoxide') * 2000)
                        .EUt(VA[LV])
                        .duration(320)
                        .buildAndRegister()
                
                ADVANCED_ARC_FURNACE.recipeBuilder()
                        .circuitMeta(1)
                        .fluidInputs(fluid('air') * 100)
                        .inputs(ore(quartz) * 12)
                        .inputs(ore(carbon.name) * carbon.equivalent(8))
                        .outputs(metaitem('dustSilicon') * 4)
                        .fluidOutputs(fluid('carbon_monoxide') * 8000)
                        .EUt(VA[MV])
                        .duration(160)
                        .buildAndRegister()

                ARC_FURNACE.recipeBuilder()
                        .circuitMeta(2)
                        .fluidInputs(fluid('air') * 100)
                        .inputs(ore(quartz) * 3)
                        .inputs(ore(carbon.name) * carbon.equivalent(3))
                        .outputs(metaitem('dustSiliconCarbide') * 2)
                        .fluidOutputs(fluid('carbon_monoxide') * 2000)
                        .EUt(VA[MV])
                        .duration(200)
                        .buildAndRegister()
        }
}

ARC_FURNACE.recipeBuilder()
        .inputs(ore('dustSiliconCarbide') * 2)
        .outputs(metaitem('dustSilicon'))
        .outputs(metaitem('dustGraphite'))
        .EUt(60)
        .duration(270)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustSilicon'))
        .fluidInputs(fluid('chlorine') * 4000)
        .fluidOutputs(fluid('silicon_tetrachloride') * 1000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('silicon_tetrachloride') * 1000)
        .fluidOutputs(fluid('purified_silicon_tetrachloride') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('purified_silicon_tetrachloride') * 1000)
        .inputs(ore('dustAnyPurityZinc') * 2)
        .outputs(metaitem('dustHighPuritySilicon'))
        .fluidOutputs(fluid('zinc_chloride') * 864)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustSilicon'))
        .fluidInputs(fluid('hydrogen_chloride') * 3000)
        .fluidOutputs(fluid('trichlorosilane') * 1000)
        .fluidOutputs(fluid('hydrogen') * 2000)
        .duration(80)
        .EUt(VA[LV])
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('trichlorosilane') * 1000)
        .fluidOutputs(fluid('purified_trichlorosilane') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('purified_trichlorosilane') * 1000)
        .inputs(ore('dustAnyPurityZinc') * 1)
        .outputs(metaitem('dustHighPuritySilicon'))
        .fluidOutputs(fluid('zinc_chloride') * 432)
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .duration(100)
        .EUt(VA[LV])
        .buildAndRegister()

VACUUM_CHAMBER.recipeBuilder()
        .fluidInputs(fluid("silicon_dioxide") * 1008)
        .notConsumable(metaitem('shape.mold.crucible'))
        .outputs(metaitem('crucible.quartz'))
        .duration(1440)
        .EUt(VA[LV])
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('high_purity_silicon') * 4608)
        .inputs(metaitem('seed_crystal.silicon'))
        .notConsumable(metaitem('crucible.quartz'))
        .outputs(metaitem('unrefined_boule.silicon'))
        .duration(9000)
        .EUt(VA[MV])
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('high_purity_silicon') * 4608)
        .notConsumable(fluid('argon') * 8000)
        .inputs(metaitem('seed_crystal.silicon'))
        .notConsumable(metaitem('crucible.quartz'))
        .outputs(metaitem('unrefined_boule.silicon'))
        .duration(6750)
        .EUt(VA[MV])
        .buildAndRegister()

ZONE_REFINER.recipeBuilder()
        .inputs(metaitem('unrefined_boule.silicon'))
        .outputs(metaitem('boule.silicon'))
        .duration(120)
        .EUt(VA[LV])
        .buildAndRegister()

CUTTER.recipeBuilder()
        .inputs(metaitem('boule.silicon'))
        .fluidInputs(fluid('ultrapure_water') * 500)
        .outputs(metaitem('wafer.raw.silicon') * 14)
        .chancedOutput(metaitem('wafer.raw.silicon') * 2, 5000, 0)
        .outputs(metaitem('seed_crystal.silicon'))
        .duration(4500)
        .EUt(64)
        .buildAndRegister()

MIXER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('hydrochloric_acid') * 500)
        .fluidInputs(fluid('hydrofluoric_acid') * 500)
        .fluidOutputs(fluid('wafer_treatment_acid') * 1000)
        .duration(600)
        .EUt(64)
        .buildAndRegister()

MIXER.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('hydrochloric_acid') * 450)
        .fluidInputs(fluid('hydrofluoric_acid') * 450)
        .fluidInputs(fluid('acetic_acid') * 100)
        .fluidOutputs(fluid('wafer_treatment_acid') * 1000)
        .duration(200)
        .EUt(64)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('wafer.raw.silicon'))
        .fluidInputs(fluid('wafer_treatment_acid') * 50)
        .outputs(metaitem('wafer.treated.silicon'))
        .fluidOutputs(fluid('acidic_wastewater') * 50)
        .duration(225)
        .EUt(64)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide'))
        .inputs(ore('dustSiliconDioxide') * 3)
        .fluidInputs(fluid('ultrapure_water') * 1000)
        .fluidOutputs(fluid('silicon_dioxide_slurry') * 1000)
        .duration(200)
        .EUt(64)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustTinyPotassiumHydroxide'))
        .inputs(ore('dustSiliconDioxide') * 30)
        .fluidInputs(fluid('ultrapure_water') * 10000)
        .fluidOutputs(fluid('silicon_dioxide_slurry') * 10000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

POLISHING_MACHINE.recipeBuilder()
        .inputs(metaitem('wafer.treated.silicon'))
        .fluidInputs(fluid('silicon_dioxide_slurry') * 50)
        .outputs(metaitem('wafer.silicon'))
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister()

AUTOCLAVE.recipeBuilder()
        .fluidInputs(fluid('distilled_water') * 1000)
        .inputs(ore('dustHighPuritySilicon'))
        .chancedOutput(metaitem('seed_crystal.silicon'), 1000, 500)
        .duration(1200)
        .EUt(VA[LV])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('silicon_tetrachloride') * 3000)
        .fluidInputs(fluid('hydrogen') * 4000)
        .inputs(ore('dustSilicon'))
        .fluidOutputs(fluid('trichlorosilane') * 4000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('trichlorosilane') * 2000)
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidOutputs(fluid('disproportionated_trichlorosilane') * 2000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('disproportionated_trichlorosilane') * 2000)
        .fluidOutputs(fluid('silicon_tetrachloride') * 1000)
        .fluidOutputs(fluid('dichlorosilane') * 1000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('dichlorosilane') * 2000)
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidOutputs(fluid('disproportionated_dichlorosilane') * 2000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('disproportionated_dichlorosilane') * 2000)
        .fluidOutputs(fluid('trichlorosilane') * 1000)
        .fluidOutputs(fluid('chlorosilane') * 1000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

FIXED_BR.recipeBuilder()
        .fluidInputs(fluid('chlorosilane') * 2000)
        .notConsumable(metaitem('catalystBedAluminiumChloride'))
        .fluidOutputs(fluid('disproportionated_chlorosilane') * 2000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('disproportionated_chlorosilane') * 2000)
        .fluidOutputs(fluid('dichlorosilane') * 1000)
        .fluidOutputs(fluid('silane') * 1000)
        .duration(100)
        .EUt(VA[MV])
        .buildAndRegister()

Sintering.plasmaFuels().each { fuel ->
    SINTERING_OVEN.recipeBuilder()
        .notConsumable(metaitem('shape.mold.plate'))
        .inputs(ore('dustSiliconCarbide'))
        .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
        .outputs(metaitem('plateSiliconCarbide'))
        .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
        .duration(fuel.duration)
        .EUt(VA[HV])
        .buildAndRegister()
}
Sintering.nonPlasmaFuels().each { fuel ->
    Sintering.comburents.each { comburent ->
        SINTERING_OVEN.recipeBuilder()
            .notConsumable(metaitem('shape.mold.plate'))
            .inputs(ore('dustSiliconCarbide'))
            .fluidInputs(fluid(fuel.name) * fuel.amountRequired)
            .fluidInputs(fluid(comburent.name) * comburent.amountRequired)
            .outputs(metaitem('plateSiliconCarbide'))
            .fluidOutputs(fluid(fuel.byproduct) * fuel.byproductAmount)
            .duration(fuel.duration + comburent.duration)
            .EUt(VA[LV])
            .buildAndRegister()
    }
}

// TEOS

CSTR.recipeBuilder()
        .fluidInputs(fluid('silicon_tetrachloride') * 50)
        .fluidInputs(fluid('ethanol') * 200)
        .fluidOutputs(fluid('tetraethyl_orthosilicate') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 200)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

// Silicates

BR.recipeBuilder()
    .inputs(ore('dustCalciumMetasilicate') * 5)
    .fluidInputs(fluid('carbon_dioxide') * 1000)
    .outputs(metaitem('dustCalcite') * 5)
    .outputs(metaitem('dustSiliconDioxide') * 3)
    .duration(120)
    .EUt(VA[LV])
    .buildAndRegister()
