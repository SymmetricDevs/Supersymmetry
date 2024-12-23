import gregtech.api.unification.material.properties.*;
import gregtech.api.GregTechAPI;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.unification.material.Materials.*;
import globals.Globals
import static RegisterOres;
import static RegisterSolids;

ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
ELECTROLYZER = recipemap('electrolyzer')
EBF = recipemap('electric_blast_furnace')
ARC_FURNACE = recipemap('arc_furnace')
BATCH_REACTOR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')
DISTILLERY = recipemap('distillery')
DT = recipemap('distillation_tower')

//BENEFICIATION

MIXER.recipeBuilder()
        .inputs(ore('dustImpureArsenopyrite') * 8)
        .fluidInputs(fluid('distilled_water') * 2000)
        .fluidOutputs(fluid('impure_arsenopyrite_slurry') * 2000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

FLOTATION.recipeBuilder()
        .fluidInputs(fluid('impure_arsenopyrite_slurry') * 2000)
        .notConsumable(metaitem('dustSodiumEthylXanthate'))
        .notConsumable(metaitem('dustPotassiumPermanganate') * 6)
        .fluidOutputs(fluid('arsenopyrite_slurry') * 1000)
        .fluidOutputs(fluid('pyrite_slurry') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

CLARIFIER.recipeBuilder()
        .fluidInputs(fluid('arsenopyrite_slurry') * 1000)
        .outputs(metaitem('dustArsenopyrite') * 16)
        .fluidOutputs(fluid('wastewater') * 1000)
        .EUt(Globals.voltAmps[1])
        .duration(20)
        .buildAndRegister()

//SPERRYLITE ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustSperrylite'))
    .fluidInputs(fluid('oxygen') * 3000)
    .outputs(metaitem('dustRoastedSperrylite'))
    .chancedOutput(metaitem('dustArsenicTrioxide') * 5, 7500, 0)
    .blastFurnaceTemp(1200)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//REALGAR ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustRealgar'))
    .fluidInputs(fluid('oxygen') * (6000 + 8000))
    .chancedOutput(metaitem('dustArsenicTrioxide') * 10, 7500, 0)
    .fluidOutputs(fluid('sulfur_dioxide') * 4000)
    .blastFurnaceTemp(1200)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ARSENOPYRITE ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustArsenopyrite') * 2)
    .fluidInputs(fluid('oxygen') * (3000 + 4000 + 3000))
    .outputs(metaitem('dustIronIiiOxide') * 5)
    .chancedOutput(metaitem('dustArsenicTrioxide') * 5, 7500, 0)
    .fluidOutputs(fluid('sulfur_dioxide') * 2000)
    .blastFurnaceTemp(1200)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ENARGITE SMELTING
EBF.recipeBuilder()
    .inputs(ore('dustEnargite') * 2)
    .fluidInputs(fluid('oxygen') * 19000)
    .outputs(metaitem('ingotBlisterCopper'))
    .outputs(metaitem('dustArsenicTrioxide') * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 8000)
    .blastFurnaceTemp(1200)
    .EUt(480)
    .duration(40)
    .buildAndRegister()

//NOTE: PROUSTITE CANNOT BE PYROMETALLURGICALLY TREATED TO FORM SIGNIFICANT QUANTITES OF ARSENIC TRIOXIDE.

//ARSENOPYRITE AND COBALTITE ACID LEACHING
def tab_MAsS = ["Cobaltite", "Arsenopyrite"]
for (ore in tab_MAsS) {
    def metal = null

    for (mat in material(ore.toLowerCase()).getMaterialComponents()) {
        if (mat.material == Cobalt){metal = "Cobalt"; break}
        if (mat.material == Iron){metal = "Iron"; break}
    }

    BATCH_REACTOR.recipeBuilder()
        .inputs(metaitem('dust' + ore) * 3)
        .fluidInputs(fluid('nitric_acid') * 13000)
        .fluidInputs(fluid('distilled_water') * 3000)
        .outputs(metaitem('dustSulfur') * 3)
        .fluidOutputs(fluid(ore.toLowerCase() + "_leach_solution") * 1000)
        .fluidOutputs(fluid('nitric_oxide') * 7000)
        .duration(240)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister();

    ELECTROLYTIC_CELL.recipeBuilder()
        .notConsumable(metaitem('stick' + metal))
        .notConsumable(metaitem('graphite_electrode'))
        .fluidInputs(fluid(ore.toLowerCase() + "_leach_solution") * 1000)
        .outputs(metaitem('dust' + metal) * 3)
        .fluidOutputs(fluid('oxygen') * 3000)
        .fluidOutputs(fluid('acidic_arsenate_v_solution') * 1000)
        .duration(240)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister();
}

//ARSENATE PROCESSING
ROASTER.recipeBuilder()
        .fluidInputs(fluid('acidic_arsenate_v_solution') * 2000)
        .outputs(metaitem('dustArsenicVOxide') * 21)
        .fluidOutputs(fluid('dense_steam') * 15000)
        .fluidOutputs(fluid('nitrogen_dioxide') * 12000)
        .fluidOutputs(fluid('oxygen') * 6000)
        .duration(120)
        .EUt(360)
        .buildAndRegister();

//ARSENIC OXIDES REDUCTION
ROASTER.recipeBuilder()
        .inputs(ore('dustAnyPurityCarbon') * 3)
        .inputs(ore('dustArsenicTrioxide') * 5)
        .outputs(metaitem('dustArsenic') * 2)
        .fluidOutputs(fluid('carbon_monoxide') * 3000)
        .duration(60)
        .EUt(30)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustAnyPurityCarbon') * 5)
        .inputs(ore('dustArsenicVOxide') * 7)
        .outputs(metaitem('dustArsenic') * 2)
        .fluidOutputs(fluid('carbon_monoxide') * 5000)
        .duration(60)
        .EUt(30)
        .buildAndRegister()

//PROUSTITE ALKALINE LEACHING (90% EFFICIENT)
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustProustite') * 1)
        .inputs(ore('dustSalt') * 6)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .fluidInputs(fluid('distilled_water') * 5000) 
		//where does the distilled water go in the fluid output? 
        .outputs(metaitem('dustSilverChloride') * 6) //TO SILVER PROCESSING
        .fluidOutputs(fluid('proustite_alkaline_leach_solution') * 1000)
        .duration(240)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//ENARGITE ALKALINE SULFIDE LEACHING
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustEnargite') * 2)
        .inputs(ore('dustSodiumSulfide') * 9)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
        .fluidInputs(fluid('distilled_water') * 4000)
        .outputs(metaitem('dustEnargiteResidue') * 6)
        .fluidOutputs(fluid('enargite_sulfide_leach_solution') * 2000)
        .duration(240)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//SEPARATION OF ARSENIC FROM ANTIMONY
BATCH_REACTOR.recipeBuilder()
        .fluidInputs(fluid('proustite_alkaline_leach_solution') * 2000)
        .fluidInputs(fluid('hydrochloric_acid') * 6000)
        .outputs(metaitem('dustArsenicIiiSulfide') * 5)
        .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
        .fluidOutputs(fluid('diluted_saltwater') * 6000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
        .fluidInputs(fluid('enargite_sulfide_leach_solution') * 2000)
        .fluidInputs(fluid('hydrochloric_acid') * 6000)
        .outputs(metaitem('dustArsenicVSulfide') * 7)
        .fluidOutputs(fluid('hydrogen_sulfide') * 4500)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//REDUCTION OF ARSENIC SULFIDES
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustArsenicIiiSulfide') * 5)
        .fluidInputs(fluid('hydrogen') * 6000)
        .outputs(metaitem('dustArsenic') * 2)
        .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustArsenicVSulfide') * 5)
        .fluidInputs(fluid('hydrogen') * 10000)
        .outputs(metaitem('dustArsenic') * 2)
        .fluidOutputs(fluid('hydrogen_sulfide') * 5000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustArsenicVSulfide') * 7)
        .fluidInputs(fluid('oxygen') * 15000)
        .outputs(metaitem('dustArsenicVOxide') * 7)
        .fluidOutputs(fluid('sulfur_dioxide') * 3000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustArsenicIiiSulfide') * 5)
        .fluidInputs(fluid('oxygen') * 9000)
        .outputs(metaitem('dustArsenicTrioxide') * 5)
        .fluidOutputs(fluid('sulfur_dioxide') * 3000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//SEMICONDUCTOR GRADE ARSENIC
//ARSENIC TRICHLORIDE DISTILLATION
ROASTER.recipeBuilder()
        .inputs(ore('dustArsenicTrioxide') * 5)
        .fluidInputs(fluid('hydrogen_chloride') * 6500)
        .fluidOutputs(fluid('crude_arsenic_trichloride') * 2000)
        .fluidOutputs(fluid('water') * 3000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustArsenic'))
        .fluidInputs(fluid('chlorine') * 3000)
        .fluidOutputs(fluid('crude_arsenic_trichloride') * 1000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

DT.recipeBuilder()
        .fluidInputs(fluid('crude_arsenic_trichloride') * 2000)
        .fluidOutputs(fluid('arsenic_trichloride') * 2000)
        .fluidOutputs(fluid('sulfur_dichloride') * 250)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
        .fluidInputs(fluid('sulfur_dichloride') * 1000)
        .fluidInputs(fluid('hydrogen') * 2000)
        .outputs(metaitem('dustSulfur'))
        .fluidOutputs(fluid('hydrogen_chloride') * 2000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BATCH_REACTOR.recipeBuilder()
        .fluidInputs(fluid('arsenic_trichloride') * 1000)
        .fluidInputs(fluid('hydrogen') * 3000)
        .outputs(metaitem('dustHighPurityArsenic'))
        .fluidOutputs(fluid('hydrogen_chloride') * 3000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ARC_FURNACE.recipeBuilder()
        .inputs(ore('dustAnyPuritySodium') * 3)
        .inputs(ore('dustHighPurityArsenic'))
        .outputs(metaitem('dustSodiumArsenide') * 4)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

//Arsine gas is used for chemical vapor deposition of high purity arsenic.
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustSodiumArsenide') * 4)
        .fluidInputs(fluid('water') * 3000)
        .outputs(metaitem('dustSodiumHydroxide') * 9)
        .fluidOutputs(fluid('arsine') * 1000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//BROMINE REGENERATION
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustSodiumBromide') * 2)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('sodium_bromide_solution') * 2000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('sodium_bromide_solution') * 100)
        .fluidInputs(fluid('chlorine') * 100)
        .fluidOutputs(fluid('bromine') * 100)
        .fluidOutputs(fluid('salt_water') * 100)
        .duration(6)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//ROASTED ORE PROCESSING
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustRoastedSperrylite'))
        .fluidInputs(fluid('hydrochloric_acid') * 500)
        .outputs(metaitem('dustPlatinum'))
        .fluidOutputs(fluid('sperrylite_waste') * 750)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

ELECTROLYZER.recipeBuilder()
        .fluidInputs(fluid('sperrylite_waste') * 6000)
        .notConsumable(metaitem('stickNickel'))
        .notConsumable(metaitem('graphite_electrode'))
        .outputs(metaitem('dustCobalt'))
        .outputs(metaitem('dustNickel'))
        .fluidOutputs(fluid('chlorine') * 4000)
        .fluidOutputs(fluid('water') * 6000)
        .duration(120)
        .EUt(Globals.voltAmps[2])
        .buildAndRegister()

//LEACH RESIDUE PROCESSING
BATCH_REACTOR.recipeBuilder()
        .inputs(ore('dustEnargiteResidue') * 3)
        .fluidInputs(fluid('nitric_acid') * 8000)
        .outputs(metaitem('dustSmallGold'))
        .fluidOutputs(fluid('nitrogen_dioxide') * 2000)
        .fluidOutputs(fluid('acidic_copper_solution') * 1000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

ROASTER.recipeBuilder()
        .fluidInputs(fluid('acidic_copper_solution') * 2000)
        .outputs(metaitem('dustCopperSulfate') * 24)
        .fluidOutputs(fluid('dense_steam') * (8000 + 2000))
        .fluidOutputs(fluid('oxygen') * 1000)
        .fluidOutputs(fluid('nitrogen_dioxide') * 4000)
        .duration(120)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
