import gregtech.api.unification.material.properties.*;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.material.Materials.*;
import static globals.Globals.*
import static RegisterOres;
import static RegisterSolids;

ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
ELECTROLYZER = recipemap('electrolyzer')
EBF = recipemap('electric_blast_furnace')
ARC_FURNACE = recipemap('arc_furnace')
MIXER = recipemap('mixer')
CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')

//COBALTITE MODIFICATION
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCobaltite')], [fluid('oxygen') * 3000])

EBF.recipeBuilder()
    .inputs(ore('dustCobaltite') * 6)
    .fluidInputs(fluid('oxygen') * (3000 + 4000 + 2000))
    .outputs(ore('dustCobaltOxide').first())
    .outputs(ore('dustArsenicTrioxide').first() * 5)
    .property('temperature', 1200)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//SPERRYLITE ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustSperrylite') * 3)
    .fluidInputs(fluid('oxygen') * 3000)
    .outputs(ore('dustRoastedSperrylite').first())
    .outputs(ore('dustArsenicTrioxide').first() * 5)
    .property("temperature", 1200)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//REALGAR ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustRealgar') * 8)
    .fluidInputs(fluid('oxygen') * (6000 + 8000))
    .outputs(ore('dustArsenicTrioxide').first() * 10)
    .fluidOutputs(fluid('sulfur_dioxide') * 4000)
    .property("temperature", 1200)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ARSENOPYRITE ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustArsenopyrite') * 6)
    .fluidInputs(fluid('oxygen') * (3000 + 4000 + 3000))
    .outputs(ore('dustIronIiiOxide').first() * 2)
    .outputs(ore('dustArsenicTrioxide').first() * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 2000)
    .property("temperature", 1200)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//NOTE: ENARGITE AND PROUSTITE CANNOT BE PYROMETALLURGICALLY TREATED TO FORM ARSENIC TRIOXIDE.

//ARSENIC TRIOXIDE REDUCTION (75% EFFICIENCY)
ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustCarbon') * 3)
    .inputs(ore('dustArsenicTrioxide') * 5)
    .outputs(ore('dustSmallArsenic').first() * 6)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .duration(30)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ARSENOPYRITE AND COBALTITE ACID LEACHING
def tab_MAsS = ["Cobaltite", "Arsenopyrite"]
for (ore in tab_MAsS) {
    def metal = null
    
    for (mat in material(ore.toLowerCase()).getMaterialComponents()) {
        if (mat.material == Cobalt){metal = "Cobalt"; break}
        if (mat.material == Iron){metal = "Iron"; break}
    }

    MIXER.recipeBuilder()
        .inputs(metaitem('dust' + ore) * 9)
        .fluidInputs(fluid('nitric_acid') * 13000)
        .outputs(metaitem('dustTinyStone'))
        .fluidOutputs(fluid(ore.toLowerCase() + "_leach_solution") * 1000)
        .fluidOutputs(fluid('nitric_oxide') * 7000)
        .duration(240)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister();

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('stick' + metal))
        .notConsumable(metaitem('graphite_electrode'))
        .fluidInputs(fluid(ore.toLowerCase() + "_leach_solution") * 1000)
        .outputs(metaitem('dustArsenic') * 3)
        .outputs(metaitem('dust' + metal) * 3)
        .fluidOutputs(fluid('oxygen') * 7500)
        .fluidOutputs(fluid('water') * 2000)
        .duration(240)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister();

}

//PROUSTITE ALKALINE LEACHING
    MIXER.recipeBuilder()
        .inputs(ore('dustProustite') * 7)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .outputs(ore('dustSilverChloride').first() * 6)
        .fluidOutputs(fluid('thioarsenite_solution') * 1000)
        .duration(240)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

//ENARGITE ALKALINE SULFIDE LEACHING
        MIXER.recipeBuilder()
        .inputs(ore('dustEnargite') * 14)
        .inputs(ore('dustSodiumSulfide') * 9)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
        .outputs(ore('dustEnargiteResidue').first() * 6)
        .fluidOutputs(fluid('thioarsenate_solution') * 1000)
        .duration(240)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

//SEPARATION OF ARSENIC FROM ANTIMONY
MIXER.recipeBuilder()
    .fluidInputs(fluid('thioarsenite_solution') * 2000)
    .fluidInputs(fluid('hydrochloric_acid') * 9000)
    .outputs(ore('dustArsenicIiiSulfide').first() * 5)
    .fluidOutputs(fluid('tetrachloroantimonate_solution') * 1000)
    .fluidOutputs(fluid('hydrogen_sulfide') * 4500)
    .duration(120)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('thioarsenate_solution') * 2000)
    .fluidInputs(fluid('hydrochloric_acid') * 9000)
    .outputs(ore('dustArsenicVSulfide').first() * 7)
    .fluidOutputs(fluid('tetrachloroantimonate_solution') * 1000)
    .fluidOutputs(fluid('hydrogen_sulfide') * 4500)
    .duration(120)  
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//REDUCTION OF ARSENIC SULFIDES
ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustArsenicIiiSulfide') * 5)
    .fluidInputs(fluid('hydrogen') * 6000)
    .outputs(ore('dustArsenic').first() * 2)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustArsenicIiiSulfide') * 5)
    .fluidInputs(fluid('hydrogen') * 10000)
    .outputs(ore('dustArsenic').first() * 2)
    .fluidOutputs(fluid('hydrogen_sulfide') * 5000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ELECTROLYTIC REDUCTION METHOD
MIXER.recipeBuilder()
    .inputs(ore('dustArsenicVSulfide') * 7)
    .fluidInputs(fluid('warm_water') * 6000)
    .outputs(ore('dustSulfur').first() * 2)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .fluidOutputs(fluid('arsenous_acid') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustArsenicIiiSulfide') * 5)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 6000)
    .fluidOutputs(fluid('alkaline_arsenite_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('alkaline_arsenite_solution') * 2000)
    .fluidInputs(fluid('hydrochloric_acid') * 12000)
    .outputs(ore('dustArsenicIiiSulfide').first() * 5)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .fluidOutputs(fluid('salty_arsenous_acid') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('arsenous_acid') * 4000)
    .notConsumable(metaitem('stickSteel'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustArsenic').first() * 4)
    .fluidOutputs(fluid('oxygen') * 6000)
    .fluidOutputs(fluid('water') * 6000)
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('salty_arsenous_acid') * 1000)
    .notConsumable(metaitem('stickSteel'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustArsenic').first() * 2)
    .fluidOutputs(fluid('hydrogen') * 6000)
    .fluidOutputs(fluid('chlorine') * 12000)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 6000)
    .duration(480)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//ELECTROLYSIS OF ANTIMONY
ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('tetrachloroantimonate_solution') * 2000)
    .notConsumable(metaitem('stickAluminium'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustAntimony').first())
    .fluidOutputs(fluid('hydrogen') * 15000)
    .fluidOutputs(fluid('chlorine') * 18000)
    .fluidOutputs(fluid('sodium_hydroxide_solution') * 15000)
    .fluidOutputs(fluid('water') * 7000)
    .duration(600)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//SEMICONDUCTOR GRADE ARSENIC
ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustSodium') * 3)
    .inputs(ore('dustArsenic'))
    .outputs(ore('dustSodiumArsenide').first() * 4)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//Arsine gas is used for chemical vapor deposition of high purity arsenic.
MIXER.recipeBuilder()
    .inputs(ore('dustSodiumArsenide') * 4)
    .fluidInputs(fluid('hydrogen_bromide') * 3000)
    .outputs(ore('dustSodiumBromide').first() * 6)
    .fluidOutputs(fluid('arsine') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//BROMINE REGENERATION
MIXER.recipeBuilder()
    .inputs(ore('dustSodiumBromide') * 2)
    .fluidInputs(fluid('water') * 1000)
    .fluidOutputs(fluid('sodium_bromide_solution') * 2000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('sodium_bromide_solution') * 100)
    .fluidInputs(fluid('chlorine') * 100)
    .fluidOutputs(fluid('bromine') * 100)
    .fluidOutputs(fluid('salt_water') * 100)
    .duration(6)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ROASTED ORE PROCESSING
MIXER.recipeBuilder()
    .inputs(ore('dustRoastedSperrylite'))
    .fluidInputs(fluid('hydrochloric_acid') * 500)
    .outputs(ore('dustPlatinum').first() * 1)
    .fluidOutputs(fluid('sperrylite_waste') * 250)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYZER.recipeBuilder()
    .fluidInputs(fluid('sperrylite_waste') * 1000)
    .notConsumable(metaitem('stickNickel'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustCobalt').first())
    .outputs(ore('dustNickel').first())
    .fluidOutputs(fluid('chlorine') * 4000)
    .fluidOutputs(fluid('water') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustCobaltOxide') * 2)
    .inputs(ore('dustCoke'))
    .outputs(metaitem('dustSmallCobalt') * 3)
    .fluidOutputs(fluid('carbon_monoxide') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//LEACH RESIDUE PROCESSING
ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('dustSilverChloride') * 6)
    .notConsumable(metaitem('stickSilver'))
    .notConsumable(metaitem('graphite_electrode'))
    .notConsumable(fluid('ammonia_solution') * 6000)
    .outputs(ore('dustSilver').first() * 3)
    .fluidOutputs(fluid('chlorine') * 3000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustEnargiteResidue') * 3)
    .fluidInputs(fluid('nitric_acid') * 8000)
    .outputs(ore('dustSmallGold').first())
    .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
    .fluidOutputs(fluid('acidic_copper_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .fluidInputs(fluid('acidic_copper_solution') * 2000)
    .outputs(ore('dustCopperSulfate').first() * 24)
    .fluidOutputs(fluid('steam') * (8000 + 2000))
    .fluidOutputs(fluid('oxygen') * 1000)
    .fluidOutputs(fluid('nitrogen_dioxide') * 4000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ELECTROLYTIC_CELL.recipeBuilder()
    .inputs(ore('dustCopperSulfate') * 6)
    .notConsumable(metaitem('stickCopper'))
    .notConsumable(metaitem('graphite_electrode'))
    .fluidInputs(fluid('water') * 1500)
    .outputs(ore('dustCopper').first())
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 500)
    .fluidOutputs(fluid('oxygen') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()