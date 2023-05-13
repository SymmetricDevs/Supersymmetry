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
DISTILLERY = recipemap('distillery')
EBF = recipemap('electric_blast_furnace')
ARC_FURNACE = recipemap('arc_furnace')
MIXER = recipemap('mixer')
CSTR = recipemap('continuous_stirred_tank_reactor')

//COBALTITE MODIFICATION
mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustCobaltite')], [fluid('oxygen') * 3000])

EBF.recipeBuilder()
    .inputs(ore('dustCobaltite') * 6)
    .fluidInputs(fluid('oxygen') * (3000 + 4000))
    .outputs(ore('dustRoastedCobaltite').first())
    .outputs(ore('dustArsenicTrioxide').first() * 5)
    .property('temperature', 1200)
    .duration(120)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//SPERRYLITE ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustSperrylite') * 3)
    .fluidInputs(fluid('oxygen') * 3000)
    .outputs(ore('dustRoastedSperrylite').first())
    .outputs(ore('dustArsenicTrioxide').first() * 5)
    .property("temperature", 1200)
    .duration(120)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//REALGAR ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustRealgar') * 8)
    .fluidInputs(fluid('oxygen') * (6000 + 8000))
    .outputs(ore('dustArsenicTrioxide').first() * 10)
    .fluidOutputs(fluid('sulfur_dioxide') * 4000)
    .property("temperature", 1200)
    .duration(240)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//ARSENOPYRITE ROASTING
EBF.recipeBuilder()
    .inputs(ore('dustArsenopyrite') * 6)
    .fluidInputs(fluid('oxygen') * (3000 + 4000))
    .outputs(ore('dustIron').first() * 2)
    .outputs(ore('dustArsenicTrioxide').first() * 5)
    .fluidOutputs(fluid('sulfur_dioxide') * 2000)
    .property("temperature", 1200)
    .duration(120)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

//NOTE: ENARGITE CANNOT BE PYROMETALLURGICALLY TREATED TO FORM ARSENIC TRIOXIDE.

//ARSENIC TRIOXIDE REDUCTION (75% EFFICIENCY)
ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustCarbon') * 3)
    .inputs(ore('dustArsenicTrioxide') * 5)
    .outputs(ore('dustSmallArsenic').first() * 6)
    .fluidOutputs(fluid('carbon_monoxide') * 3000)
    .duration(30)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ORE ARRAY
def arsenicOres = ["Cobaltite", "Sperrylite", "Realgar", "Arsenopyrite", "Enargite"]

//ORE UTIL FUNCTIONS
int getComponentAmount(Material material, Material component) {
    for (mat in material.getMaterialComponents()) {
        if (mat.material == component) {
            return mat.amount;
        }
    }
    return -1;
}

int getNumberOfComponents(Material material) {
    int num = 0
    for (mat in material.getMaterialComponents()) {
        num += mat.amount;
    }
    return num
}

int

//ALKALINE SULFIDE LEACHING
for (a in arsenicOres) {
    def oreSize = getNumberOfComponents(material(a.toLowerCase()))
    def arsenicAmount = getComponentAmount(material(a.toLowerCase()), Arsenic)
    def sulfurAmount = getComponentAmount(material(a.toLowerCase()), Sulfur)

    MIXER.recipeBuilder()
            .inputs(metaitem('dust' + a) * oreSize)
            .inputs(metaitem('dustSodiumHydroxide') * Math.max(sulfurAmount, 1))
            .inputs(metaitem('dustSodiumSulfide') * Math.max(arsenicAmount * 3 - sulfurAmount, 1))
            .fluidInputs(fluid('distilled_water') * (1000 * arsenicAmount))
            .outputs(metaitem('dust' + a + 'Residue') * Math.max((oreSize - arsenicAmount - sulfurAmount), 1))
            .fluidOutputs(fluid('thioarsenite_solution') * (1000 * arsenicAmount))
            .duration(720)
            .EUt(Globals.voltAmps[3])
            .buildAndRegister();
}

//PROUSTITE
    MIXER.recipeBuilder()
        .inputs(ore('dustProustite') * 7)
        .inputs(ore('dustSodiumHydroxide'))
        .inputs(ore('dustSodiumSulfide') * 3)
        .fluidInputs(fluid('salt_water') * 3000)
        .outputs(ore('dustSilverChloride').first() * 6)
        .fluidOutputs(fluid('thioarsenite_solution') * 1000)
        .duration(720)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

//SEPARATION OF ARSENIC FROM ANTIMONY
MIXER.recipeBuilder()
    .fluidInputs(fluid('thioarsenite_solution') * 2000)
    .fluidInputs(fluid('hydrochloric_acid') * 10000)
    .outputs(ore('dustArsenicIiiSulfide').first() * 5)
    .fluidOutputs(fluid('tetrachloroantimonate_solution') * 2000)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//REDUCTION OF ARSENIC SULFIDE
ARC_FURNACE.recipeBuilder()
    .inputs(ore('dustArsenicIiiSulfide') * 5)
    .fluidInputs(fluid('hydrogen') * 6000)
    .outputs(ore('dustArsenic').first() * 2)
    .fluidOutputs(fluid('hydrogen_sulfide') * 3000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//ELECTROLYSIS OF ANTIMONY
ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('tetrachloroantimonate_solution') * 4000)
    .notConsumable(metaitem('stickAluminium'))
    .notConsumable(metaitem('graphite_electrode'))
    .outputs(ore('dustAntimony').first())
    .fluidOutputs(fluid('hydrochloric_acid') * 4000)
    .fluidOutputs(fluid('chlorine') * 16000)
    .fluidOutputs(fluid('hydrogen') * 4000)
    .duration(120)
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
