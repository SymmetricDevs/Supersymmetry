#norun
#priority 1000

//Script based on the ore_dict.zs script from the Gregicality Community Pack

import crafttweaker.oredict.IOreDictEntry;
import crafttweaker.item.IItemStack;
import crafttweaker.item.IIngredient;
import crafttweaker.item.IItemDefinition;
import mods.jei.JEI;

static mods as string[] = ["minecraft", "gregtech", "nuclearcraft", "gcys", "advancedrocketry", "libvulpes", "biomesoplenty"];
static size as int = mods.length - 1;

<ore:dustRadium>.add(<metaitem:dustRadium225>);
<ore:dustPolonium>.add(<metaitem:dustPolonium210>);

<ore:ingotUranium238Carbide>.add(<metaitem:ingotUraniumCarbide>);
<ore:ingotUranium238Oxide>.add(<metaitem:ingotUraniumOxide>);
<ore:ingotUranium238Nitride>.add(<metaitem:ingotUraniumNitride>);
<ore:ingotUranium238All>.add(<metaitem:ingotUraniumZA>);
<ore:ingotPlutonium239Carbide>.add(<metaitem:ingotPlutoniumCarbide>);
<ore:ingotPlutonium239Oxide>.add(<metaitem:ingotPlutoniumOxide>);
<ore:ingotPlutonium239Nitride>.add(<metaitem:ingotPlutoniumNitride>);
<ore:ingotPlutonium239All>.add(<metaitem:ingotPlutoniumZA>);

<ore:blockUranium238>.add(<gregtech:meta_block_compressed_7:4>);

<ore:sheetTitaniumAluminide>.add(<metaitem:foilTitaniumAluminide>);
<ore:sheetTitaniumIridium>.add(<metaitem:foilTitaniumIridium>);
<ore:sheetIron>.add(<metaitem:plateIron>);
<ore:sheetCopper>.add(<metaitem:foilCopper>);
<ore:sheetTitanium>.add(<metaitem:foilTitanium>);
<ore:sheetSteel>.add(<metaitem:foilSteel>);

function unify_oredicts (oredict as [IOreDictEntry]) {
    for ore in oredict {

        // Checks if Ore Dict is empty, true = stop
        if (ore.empty != true) { 

            // If more than 1 item in ore dict
            if (ore.itemArray.length > 1) { 
                unify(ore, 0);
            }
        }
    }
}

function unify (ore as IOreDictEntry, p as int) {
    var pos = p;
    var foundMod as bool = false;

    // For every item in the ore dict, check if one is from the <mod>
    for item in ore.itemArray { 

        // check any item is from current mod
        if (item.definition.owner == mods[pos] && item.definition.owner != "xtones") {
            foundMod = true;
        }
    }
    
    // If it is from <mod>, remove everything except the item from <mod>, else try next mod until all mods are exhausted
    if (foundMod) {
        for item in ore.itemArray {
            if (item.definition.owner != mods[pos]) {
                ore.remove(item);
                JEI.hide(item);
            }
        }
    } else if (pos < size) {
        pos += 1;
        unify(ore, pos);
    }
}

// Remove Wrong Aluminium
<ore:blockAluminum>.remove(<ore:blockAluminum>.firstItem);
<ore:blockAluminum>.remove(<libvulpes:metal0:9>);
<ore:ingotAluminum>.remove(<ore:ingotAluminum>.firstItem);

// Certus Compatability
<ore:crystalCertusQuartz>.add(<metaitem:gemCertusQuartz>);
<ore:gemCertusQuartz>.remove(<ore:gemCertusQuartz>.firstItem);

// Silicon Compatability
<ore:itemSilicon>.add(<metaitem:plateSilicon>);
<ore:itemSilicon>.remove(<ore:itemSilicon>.firstItem);

// Ender Pearl Powder Compatability
<ore:nuggetEnderpearl>.add(<ore:dustTinyEnderPearl>.firstItem);

// Remove LazyAE2 Coal Dust
<ore:dustCoal>.remove(<threng:material:3>);

// Nuclearcraft Ores
<ore:oreCopper>.remove(<nuclearcraft:ore>);
JEI.hide(<nuclearcraft:ore>);
<ore:oreTin>.remove(<nuclearcraft:ore:1>);
JEI.hide(<nuclearcraft:ore:1>);
<ore:oreLead>.remove(<nuclearcraft:ore:2>);
JEI.hide(<nuclearcraft:ore:2>);
<ore:oreThorium>.remove(<nuclearcraft:ore:3>);
JEI.hide(<nuclearcraft:ore:3>);
<ore:oreUranium>.remove(<nuclearcraft:ore:4>);
JEI.hide(<nuclearcraft:ore:4>);
<ore:oreBoron>.remove(<nuclearcraft:ore:5>);
JEI.hide(<nuclearcraft:ore:5>);
<ore:oreLithium>.remove(<nuclearcraft:ore:6>);
JEI.hide(<nuclearcraft:ore:6>);
<ore:oreMagnesium>.remove(<nuclearcraft:ore:7>);
JEI.hide(<nuclearcraft:ore:7>);

<ore:mineralRockCarbon>.add(<metaitem:rock.carbon>);
<ore:mineralRockCarbonate>.add(<metaitem:rock.carbonate>);
<ore:mineralRockClay>.add(<metaitem:rock.clay>);
<ore:mineralRockOxide>.add(<metaitem:rock.oxide>);
<ore:mineralRockPhosphate>.add(<metaitem:rock.phosphate>);
<ore:mineralRockPrecious>.add(<metaitem:rock.precious>);
<ore:mineralRockRadioactive>.add(<metaitem:rock.radioactive>);
<ore:mineralRockSedimentary>.add(<metaitem:rock.sedimentary>);
<ore:mineralRockSilicate>.add(<metaitem:rock.silicate>);
<ore:mineralRockSulfur>.add(<metaitem:rock.sulfur>);

//Concrete
//<ore:concrete>.add(<gregtech:concrete:0>);

unify_oredicts(<ore:ingot*>);
unify_oredicts(<ore:ore*>);
unify_oredicts(<ore:plate*>);
unify_oredicts(<ore:block*>);
unify_oredicts(<ore:dust*>);
unify_oredicts(<ore:gear*>);
unify_oredicts(<ore:stick*>);
unify_oredicts(<ore:crystal*>);
unify_oredicts(<ore:nugget*>);
unify_oredicts(<ore:egg*>);
unify_oredicts(<ore:sheet*>);

unify(<ore:bioplastic>, 0);
unify(<ore:itemSilicon>, 0);

