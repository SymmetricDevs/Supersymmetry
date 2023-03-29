import gregtech.integration.groovy.GroovyScriptCompat

import com.cleanroommc.groovyscript.api.IIngredient

class Globals {

    public static void main (String[] args) {

    }

    public static IIngredient circuit(int x) {
        return GroovyScriptCompat.getMetaItem('circuit.integrated').withNbt([Configuration: x])
    }

    public static voltageTiers = ["ulv", "lv", "mv", "hv", "ev", "iv", "luv", "zpm", "uv", "uhv", "uev", "uiv", "uxv", "opv", "max"];

    public static voltageTiersInt = [8, 32, 128, 512, 2048, 8192, 32768, 131072, 524288, 2097152, 8388608, 33554432, 134217728, 536870912, 2147483647];
    public static voltAmps =        [7, 30, 120, 480, 1920, 7680, 30720, 122880, 491520, 1966080, 7864320, 31457280, 125829120, 503316480, 2013265920];

    public static solders = [
        'tin': 144,
        'soldering_alloy': 72
    ]

    public static wireCoatings = [
        'rubber': 144,
        'silicone_rubber': 72,
        'styrene_butadiene_rubber': 36
    ]

    public static mod_priority = [
        "minecraft", 
        "gregtech", 
        "gcym", 
        "advancedrocketry", 
        "libvulpes", 
        "biomesoplenty"
    ]
             
}