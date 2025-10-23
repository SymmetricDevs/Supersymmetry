package globals

import com.cleanroommc.groovyscript.api.IIngredient
import gregtech.api.GTValues
import gregtech.api.fluids.store.FluidStorageKeys
import gregtech.api.fluids.store.FluidStorage
import gregtech.api.unification.material.properties.*
import gregtech.api.unification.material.Material

import static gregtech.api.fluids.FluidConstants.*

class Globals {
    public static voltageTiers = GTValues.VN.collect { it.toLowerCase() }

    public static dimensions = ["Overworld": 0, "Beneath": 10, "Nether": -1]

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

    record InertGas(String name, int amount_required, int duration) {}
    public static inertGases = [
        new InertGas('nitrogen', 8000, 4),
        new InertGas('helium', 4000, 2),
        new InertGas('argon', 1000, 1)
    ]

    record Lubricant (String name, int amount_required, double boost) {}
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