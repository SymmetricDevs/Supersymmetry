import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*

ASSEMBLER.recipeBuilder()
        .circuitMeta(2)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('threadKevlar') * 32)
        .outputs(metaitem('parachute.drogue'))
        .duration(200)
        .EUt(VA[HV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .circuitMeta(3)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('threadKevlar') * 64)
        .inputs(metaitem('threadKevlar') * 32)
        .outputs(metaitem('parachute.main'))
        .duration(600)
        .EUt(VA[HV])
        .buildAndRegister();

ASSEMBLER.recipeBuilder()
        .circuitMeta(4)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolycaprolactam') * 64)
        .inputs(metaitem('foilPolyethyleneTerephthalate') * 64)
        .inputs(metaitem('foilPolyethyleneTerephthalate') * 64)
        .inputs(metaitem('threadKevlar') * 64)
        .inputs(metaitem('threadKevlar') * 32)
        .outputs(metaitem('parachute.supersonic_main'))
        .duration(600)
        .EUt(VA[HV])
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('formaldehyde') * 75)
        .fluidInputs(fluid('phenol') * 25)
        .notConsumable(fluid('sodium_hydroxide_solution') * 50)
        .fluidOutputs(fluid('resol_resin_mixture') * 100)
        .duration(4)
        .EUt(VA[MV])
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('isopropyl_alcohol') * 75)
        .fluidInputs(fluid('resol_resin_mixture') * 25)
        .fluidOutputs(fluid('resol_resin_infiltrant') * 100)
        .duration(2)
        .EUt(VA[MV])
        .buildAndRegister();

CHEMICAL_BATH.recipeBuilder()
        .inputs(metaitem('carbon.mesh'))
        .fluidInputs(fluid('resol_resin_infiltrant') * 4000)
        .outputs(metaitem('carbon.mesh.phenolic.moist'))
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister();

TUBE_FURNACE.recipeBuilder()
        .inputs(metaitem('carbon.mesh.phenolic.moist'))
        .fluidInputs(fluid('argon') * 500)
        .outputs(metaitem('carbon.mesh.phenolic.treated'))
        .duration(300)
        .EUt(VA[HV])
        .buildAndRegister();

CUTTER.recipeBuilder()
        .inputs(metaitem('carbon.mesh.phenolic.treated'))
        .outputs(metaitem('carbon.tile.phenolic.treated') * 8)
        .duration(200)
        .EUt(VA[MV])
        .buildAndRegister();

/*ASSEMBLER.recipeBuilder()
        .inputs(metaitem('carbon.tile.phenolic.treated') * 64)
        .inputs(metaitem('carbon.tile.phenolic.treated') * 64)
        .inputs(metaitem('carbon.tile.phenolic.treated') * 64)
        .inputs(metaitem('carbon.tile.phenolic.treated') * 64)
        .inputs(metaitem('plateAluminium') * 32)
        .fluidInputs(fluid('polydimethylsiloxane') * 8000)
        .outputs(metaitem('heat_shield.pica'))
        .duration(600)
        .EUt(VA[EV])
        .buildAndRegister();*/


