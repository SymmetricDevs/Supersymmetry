package globals

import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.fluids.store.FluidStorage;
import gregtech.api.unification.material.properties.*
import gregtech.api.unification.material.Material;


import static gregtech.api.fluids.FluidConstants.*;

class Globals {

    public static void main (String[] args) {

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
        "libvulpes",
        "techguns",
        "advancedrocketry",
        "biomesoplenty"
    ]

    public static class InertGas {
        String name
        int amount_required
        int duration
        InertGas(name, amount_required, duration) {
            this.name = name
            this.amount_required = amount_required
            this.duration = duration
        }
    }

    public static inertGases = [
        new InertGas('nitrogen', 8000, 4),
        new InertGas('helium', 4000, 2),
        new InertGas('argon', 1000, 1)
    ]

    public static class Lubricant {
        String name
        int amount_required
        double boost
        Lubricant(name, amount_required, boost) {
            this.name = name
            this.amount_required = amount_required
            this.boost = boost
        }
    }

    public static lubricants = [
        new Lubricant('lubricating_oil', 1, 1.1),
        new Lubricant('lubricant', 2, 1.2),
        new Lubricant('midgrade_lubricant', 2, 1.3),
        new Lubricant('premium_lubricant', 1, 1.4),
        new Lubricant('supreme_lubricant', 1, 1.5)
    ]

    public static int determineTemperatureGas(Material material) {
    	if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS) != null) {
    		def current = material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS).temperature
  		if (current != -1) {
    			return current
    		}
    	}
        BlastProperty property = material.getProperty(PropertyKey.BLAST)
       	if (property == null) {
        	return ROOM_TEMPERATURE
    	} else {
        	return property.getBlastTemperature() + GAS_TEMPERATURE_OFFSET
    	}
    }

    private static int determineTemperatureLiquid(Material material) {
    	if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID) != null) {
    		def current = material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID).temperature
  		if (current != -1) {
    			return current
    		}
    	}
        BlastProperty property = material.getProperty(PropertyKey.BLAST);
        if (property == null) {
        	if (material.hasProperty(PropertyKey.DUST)) {
           		return SOLID_LIQUID_TEMPERATURE;
        	}
        	return ROOM_TEMPERATURE;
        } else {
        	return property.getBlastTemperature() + LIQUID_TEMPERATURE_OFFSET
        }
    }
}