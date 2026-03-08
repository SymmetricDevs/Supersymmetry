import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

def name_removals = [
        "industrialrenewal:concrete",
        "icbmclassic:concrete",
        "icbmclassic:concrete.1",
        "icbmclassic:concrete.2",
]

for (name in name_removals) {
    crafting.remove(name)
}

// Industrial Renewal
ASSEMBLER.recipeBuilder()
        .circuitMeta(6)
        .fluidInputs(fluid('water') * 500)
        .inputs(ore('dustCement') * 1)
        .inputs(ore('dustStone') * 3)
        .inputs(ore('wireFineSteel') * 16)
        .inputs(ore('sand') * 2)
        .outputs(item('industrialrenewal:concrete') * 4)
        .duration(40)
        .EUt(VA[ULV])
        .buildAndRegister();

MIXER.recipeBuilder()
        .fluidInputs(fluid('water') * 250)
        .inputs(ore('dustConcrete'))
        .inputs(ore('dustCement'))
        .inputs(ore('wireFineSteel') * 8)
        .outputs(item('industrialrenewal:concrete') * 2)
        .duration(60)
        .EUt(VA[ULV])
        .buildAndRegister();

// ICBM
ASSEMBLER.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('water') * 500)
        .inputs(ore('dustObsidian'))
        .inputs(ore('dustCement'))
        .inputs(ore('dustStone') * 4)
        .outputs(item('icbmclassic:concrete', 0) * 4)
        .duration(160)
        .EUt(24)
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .circuitMeta(2)
        .fluidInputs(fluid('water') * 500)
        .inputs(ore('dustObsidian'))
        .inputs(ore('dustPolypropylene'))
        .inputs(ore('dustCement'))
        .inputs(ore('dustStone') * 4)
        .inputs(ore('frameGtSteel'))
        .outputs(item('icbmclassic:concrete', 1) * 4)
        .duration(160)
        .EUt(96)
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .circuitMeta(3)
        .fluidInputs(fluid('water') * 500)
        .inputs(ore('dustObsidian'))
        .inputs(ore('dustBoronNitride'))
        .inputs(ore('dustCement'))
        .inputs(ore('dustStone') * 4)
        .inputs(ore('frameGtStainlessSteel'))
        .outputs(item('icbmclassic:concrete', 2) * 4)
        .duration(160)
        .EUt(384)
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .circuitMeta(3)
        .fluidInputs(fluid('water') * 500)
        .inputs(ore('dustObsidian'))
        .inputs(ore('dustBorosilicateGlass'))
        .inputs(ore('dustCement'))
        .inputs(ore('dustStone') * 4)
        .inputs(ore('frameGtStainlessSteel'))
        .outputs(item('icbmclassic:concrete', 2) * 4)
        .duration(160)
        .EUt(384)
        .buildAndRegister();

// Supersymmetry

EXTRUDER.recipeBuilder()
        .inputs(metaitem('frameSteel'))
        .notConsumable(metaitem('shape.extruder.block'))
        .fluidInputs(fluid('concrete') * 576)
        .outputs(item('susy:structural_block') * 32)
        .duration(200)
        .EUt(VA[LV])
        .buildAndRegister();
