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

// Silicon & Graphite

// Metallurgical silicon

for (carbon in Carbons.dusts()) {
    ARC_FURNACE.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('air') * 100)
        .inputs(ore('silicaSource') * 3)
        .inputs(ore(carbon.name) * carbon.equivalent(2))
        .outputs(metaitem('dustSilicon'))
        .fluidOutputs(fluid('carbon_monoxide') * 2000)
        .EUt(VA[LV])
        .duration(320)
        .buildAndRegister()
    
    ADVANCED_ARC_FURNACE.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('air') * 100)
        .inputs(ore('silicaSource') * 12)
        .inputs(ore(carbon.name) * carbon.equivalent(8))
        .outputs(metaitem('dustSilicon') * 4)
        .fluidOutputs(fluid('carbon_monoxide') * 8000)
        .EUt(VA[MV])
        .duration(160)
        .buildAndRegister()
}

// Semiconductor silicon precursors

ROASTER.recipeBuilder()
    .inputs(ore('dustSilicon'))
    .fluidInputs(fluid('chlorine') * 4000)
    .fluidOutputs(fluid('silicon_tetrachloride') * 1000)
    .duration(200)
    .EUt(VA[LV])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustSilicon'))
    .fluidInputs(fluid('hydrogen_chloride') * 3100)
    .fluidOutputs(fluid('gaseous_chlorosilane_mixture') * 3100)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

FLUIDIZED_BR.recipeBuilder()
    .inputs(ore('dustSilicon'))
    .fluidInputs(fluid('hydrogen_chloride') * 3100)
    .fluidOutputs(fluid('chlorosilane_mixture') * 3100)
    .duration(20)
    .EUt(VA[LV])
    .buildAndRegister()

CONDENSER.recipeBuilder()
    .fluidInputs(fluid('gaseous_chlorosilane_mixture') * 3100)
    .fluidOutputs(fluid('chlorosilane_mixture') * 1000)
    .fluidOutputs(fluid('hydrogen') * 2100)
    .duration(5)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('chlorosilane_mixture') * 100)
    .fluidOutputs(fluid('chlorosilane') * 900)
    .duration(100)
    .EUt(VA[LV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('chlorosilane_mixture') * 3100)
    .fluidOutputs(fluid('silicon_tetrachloride') * 100)
    .fluidOutputs(fluid('trichlorosilane') * 900)
    .duration(20)
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

// Silane

FIXED_BR.recipeBuilder()
    .fluidInputs(fluid('trichlorosilane') * 2000)
    .notConsumable(metaitem('catalystBedSupportedAluminiumChloride'))
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
    .notConsumable(metaitem('catalystBedSupportedAluminiumChloride'))
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
    .notConsumable(metaitem('catalystBedSupportedAluminiumChloride'))
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

// Siemens Process

CVD.recipeBuilder() // Bootstrap. 25% single-pass conversion
    .notConsumable(metaitem('graphite_electrode') * 3)
    .fluidInputs(fluid('trichlorosilane') * 4800)
    .fluidInputs(fluid('hydrogen') * 4800)
    .chancedOutput(metaitem('dustHighPuritySilicon'), 875, 0)
    .fluidOutputs(fluid('silicon_cvd_offgas') * 9750)
    .duration(1000)
    .EUt(VA[MV])
    .buildAndRegister()

CVD.recipeBuilder() // 25% single-pass conversion
    .inputs(ore('stickHighPuritySilicon') * 7)
    .fluidInputs(fluid('trichlorosilane') * 19200)
    .fluidInputs(fluid('hydrogen') * 19200)
    .outputs(metaitem('ingotHighPuritySilicon') * 7)
    .fluidOutputs(fluid('silicon_cvd_offgas') * 39000)
    .duration(100)
    .EUt(VA[MV])
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('silicon_cvd_offgas') * 9750)
    .fluidOutputs(fluid('silicon_tetrachloride') * 150)
    .fluidOutputs(fluid('trichlorosilane') * 3775)
    .fluidOutputs(fluid('hydrogen_chloride') * 2475)
    .fluidOutputs(fluid('hydrogen') * 3350)
    .duration(50)
    .EUt(VA[LV])
    .buildAndRegister()

// Silicon carbide

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

// CVD Precursors

    // TEOS

    CSTR.recipeBuilder()
        .fluidInputs(fluid('silicon_tetrachloride') * 50)
        .fluidInputs(fluid('ethanol') * 200)
        .fluidOutputs(fluid('tetraethyl_orthosilicate') * 50)
        .fluidOutputs(fluid('hydrogen_chloride') * 200)
        .duration(5)
        .EUt(VA[MV])
        .buildAndRegister()

    // SiF4

    ROASTER.recipeBuilder()
        .inputs(ore('dustSodiumHexafluorosilicate') * 9)
        .outputs(metaitem('dustSodiumFluoride') * 4)
        .fluidOutputs(fluid('silicon_tetrafluoride') * 1000)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister()

    // Trimethylsilane

    CSTR.recipeBuilder()
        .fluidInputs(fluid('trimethylsilyl_chloride') * 50)
        .fluidInputs(fluid('lithium_aluminium_hydride_solution') * 50)
        .fluidOutputs(fluid('trimethylsilane') * 50)
        .fluidOutputs(fluid('wastewater') * 50)
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