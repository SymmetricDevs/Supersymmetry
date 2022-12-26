#norun
import mods.gregtech.recipe.Utils;
import mods.nuclearcraft.Radiation as radiation;

radiation.setRadiationLevel(<metaitem:dustTechnetium99>, 0.0000042);
radiation.setRadiationLevel(<metaitem:dustPolonium210>, 2);
radiation.setRadiationLevel(<metaitem:dustAstatine209>, 552);
radiation.setRadiationLevel(<metaitem:dustAstatine210>, 826);
radiation.setRadiationLevel(<metaitem:dustAstatine211>, 735);
radiation.setRadiationLevel(<metaitem:dustFrancium212>, 9936);
radiation.setRadiationLevel(<metaitem:dustFrancium221>, 39744);
radiation.setRadiationLevel(<metaitem:dustFrancium222>, 13248);
radiation.setRadiationLevel(<metaitem:dustFrancium223>, 8565);
radiation.setRadiationLevel(<metaitem:dustRadium223>, 28);
radiation.setRadiationLevel(<metaitem:dustRadium224>, 80);
radiation.setRadiationLevel(<metaitem:dustRadium225>, 19);
radiation.setRadiationLevel(<metaitem:dustRadium226>, 0.000523);
radiation.setRadiationLevel(<metaitem:dustRadium228>, 0.139);
radiation.setRadiationLevel(<metaitem:dustActinium225>, 28);
radiation.setRadiationLevel(<metaitem:dustActinium226>, 240);
radiation.setRadiationLevel(<metaitem:dustActinium227>, 0.037);

function addRadiation (materialName as string, baseRadiation as double){
    var baseIngot = Utils.metaitem("ingot" + materialName);

    radiation.setRadiationLevel(Utils.metaitem("dust" + materialName), baseRadiation);
    radiation.setRadiationLevel(Utils.metaitem("dustSmall" + materialName), baseRadiation / 4.0);
    radiation.setRadiationLevel(Utils.metaitem("dustTiny" + materialName), baseRadiation / 9.0);
    radiation.setRadiationLevel(Utils.metaitem("chunk" + materialName), baseRadiation / 4.0);
    radiation.setRadiationLevel(Utils.metaitem("nugget" + materialName), baseRadiation / 9.0);
    radiation.setRadiationLevel(Utils.metaitem("block" + materialName), baseRadiation * 9.0);
}



addRadiation("Sodium22", 0.384);
addRadiation("Uranium234", 0.000004);
addRadiation("Cobalt60", 0.19);
addRadiation("Iridium192", 4);
addRadiation("Strontium90", 0.034);
addRadiation("Ruthenium106", 0.98);
addRadiation("Caesium137", 0.033);
addRadiation("Promethium147", 0.38);
addRadiation("Europium155", 0.21);
addRadiation("Gold198", 135);

function addIsotopeRadiation (materialName as string, baseRadiation as double){
    addRadiation(materialName, baseRadiation);
    addRadiation(materialName + "Carbide", baseRadiation);
    addRadiation(materialName + "Oxide", baseRadiation);
    addRadiation(materialName + "Nitride", baseRadiation);
    addRadiation(materialName + "ZA", baseRadiation);
}

addIsotopeRadiation("Uranium233", 0.000006);
addIsotopeRadiation("Uranium", 0.000000000225);
addIsotopeRadiation("Uranium235", 0.000000001);
addIsotopeRadiation("Neptunium236", 0.000006);
addIsotopeRadiation("Neptunium237", 0.00000047);
addIsotopeRadiation("Plutonium238", 0.11);
addIsotopeRadiation("Plutonium", 0.000041);
addIsotopeRadiation("Plutonium242", 0.000002);
addIsotopeRadiation("Plutonium241", 0.071);
addIsotopeRadiation("Americium241", 0.002);
addIsotopeRadiation("Americium242", 0.007);
addIsotopeRadiation("Americium243", 0.000139);
addIsotopeRadiation("Curium243", 0.034);
addIsotopeRadiation("Curium245", 0.00012);
addIsotopeRadiation("Curium246", 0.000215);
addIsotopeRadiation("Curium247", 0.000000064);
addIsotopeRadiation("Berkelium247", 0.000000725);
addIsotopeRadiation("Berkelium248", 0.003);
addIsotopeRadiation("Californium249", 0.002);
addIsotopeRadiation("Californium250", 0.076);
addIsotopeRadiation("Californium251", 0.001);
addIsotopeRadiation("Californium252", 0.38);
addIsotopeRadiation("Copernicium291", 0.000833);

function addNuclearFuelRadiation (materialName as string, baseRadiation as double, depletedRadiation as double){
    addRadiation(materialName, baseRadiation);
    addRadiation(materialName + "Carbide", baseRadiation);
    addRadiation(materialName + "Oxide", baseRadiation);
    addRadiation(materialName + "Nitride", baseRadiation);
    addRadiation(materialName + "ZA", baseRadiation);
    addRadiation(materialName + "TRISO", baseRadiation);
    addRadiation("Depleted" + materialName + "Oxide", depletedRadiation);
    addRadiation("Depleted" + materialName + "Nitride", depletedRadiation);
    addRadiation("Depleted" + materialName + "ZA", depletedRadiation);
    addRadiation("Depleted" + materialName + "TRISO", depletedRadiation);
}

addNuclearFuelRadiation("LEU233", 0.0000007, 0.009);
addNuclearFuelRadiation("HEU233", 0.000002, 0.005);
addNuclearFuelRadiation("LEU235", 0.000000000361, 0.000937);
addNuclearFuelRadiation("HEU235", 0.000000000633, 0.002);
addNuclearFuelRadiation("LEN236", 0.000001, 0.008);
addNuclearFuelRadiation("HEN236", 0.000002, 0.011);
addNuclearFuelRadiation("LEP239", 0.000007, 0.012);
addNuclearFuelRadiation("HEP239", 0.000015, 0.047);
addNuclearFuelRadiation("LEP241", 0.007, 0.011);
addNuclearFuelRadiation("HEP241", 0.023, 0.043);
addNuclearFuelRadiation("LEA242", 0.000913, 0.011);
addNuclearFuelRadiation("HEA242", 0.002, 0.035);
addNuclearFuelRadiation("LECm243", 0.004, 0.011);
addNuclearFuelRadiation("HECm243", 0.011, 0.032);
addNuclearFuelRadiation("LECm245", 0.000204, 0.005);
addNuclearFuelRadiation("HECm245", 0.000183, 0.014);
addNuclearFuelRadiation("LECm247", 0.000191, 0.005);
addNuclearFuelRadiation("HECm247", 0.000143, 0.015);
addNuclearFuelRadiation("LEB248", 0.001, 0.042);
addNuclearFuelRadiation("HEB248", 0.001, 0.25);
addNuclearFuelRadiation("LECf249", 0.338, 0.378);
addNuclearFuelRadiation("HECf249", 0.254, 0.385);
addNuclearFuelRadiation("LECf251", 0.337, 0.375);
addNuclearFuelRadiation("HECf251", 0.253, 0.407);
addNuclearFuelRadiation("MIX239", 0.000004, 0.019);
addNuclearFuelRadiation("MIX241", 0.007, 0.019);
addNuclearFuelRadiation("MIX291", 0.000833, 0.119);
addNuclearFuelRadiation("TBU", 0.00000035, 0.001);