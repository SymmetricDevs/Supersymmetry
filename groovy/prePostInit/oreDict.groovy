import static globals.Globals.*

//Ore dict changes and unification

def get_ore_dicts(List<String> list) {
    def out = []
    for (name in list) {
        out.add(ore(name))
    }
    return out
}

def unify (ore, p) {
    def pos = p
    def foundMod = false

    for (item in ore) {
        foundMod = ( item.getItem().getRegistryName().getNamespace() == Globals.mod_priority[pos] && item.getItem().getRegistryName().getNamespace() != 'xtones' )
    }

    if (foundMod) {
        for (item in ore) {
            if (item.getItem().getRegistryName().getNamespace() != Globals.mod_priority[pos]) {
                ore.remove(item)
                //mods.jei.hide(item)
            }
        }
    } else if (pos < Globals.mod_priority.size() - 1) {
        pos++
        unify(ore, pos)
    }
}

def unify_oredicts(ore_list) {
    for (ore in ore_list) {
        if (ore) {
            if (ore.size() > 1) {
                unify(ore, 0)
            }
        }
    }
}

def dicts_ingots = get_ore_dicts(ore('ingot*').getMatchingOreDictionaries())

unify_oredicts(dicts_ingots)