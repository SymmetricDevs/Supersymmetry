package globals

import classes.Battery
import gregtech.api.GTValues

class Batteries {
    // seconds of work capacity for first and second batteries per tier
    private static final secs = [125, 175, 250]

    static list = [
        new Battery('lead_acid', GTValues.LV, secs[0]),
        new Battery('lead_acid.mv', GTValues.MV, secs[0]),
        new Battery('ni_fe.lv', GTValues.LV, secs[1]),
        new Battery('ni_fe', GTValues.MV, secs[1]),
        new Battery('ni_fe.hv', GTValues.HV, secs[0]),
        new Battery('ni_cd.mv', GTValues.MV, secs[2]),
        new Battery('ni_cd.hv', GTValues.HV, secs[1]),
        new Battery('ni_cd.ev', GTValues.EV, secs[0]),
        new Battery('ni_mh.hv', GTValues.HV, secs[2]),
        new Battery('ni_mh.ev', GTValues.EV, secs[1]),
        new Battery('ni_mh.iv', GTValues.IV, secs[0]),
    ]

    public static def getAt(String name) { list.find { it.name == name } }
    public static def getAt(int tier) { list.findAll { it.tier == tier } }
}
