package globals

import classes.Battery
import gregtech.api.GTValues

class Batteries {
    static list = [
        new Battery('lead_acid', GTValues.LV, 80000L),
        new Battery('ni_fe', GTValues.MV, 320000L)
    ]

    public static def getAt(String name) { list.find { it.name == name } }
    public static def getAt(int tier) { list.findAll { it.tier == tier } }
}
