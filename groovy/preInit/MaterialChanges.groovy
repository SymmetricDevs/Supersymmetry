package preInit;

import net.minecraftforge.fml.common.eventhandler.EventPriority
import gregtech.api.unification.material.event.MaterialEvent;

import material.SuSyMaterials
import classes.ChangeFlags
import gregtech.api.unification.material.properties.MaterialProperties;
import supersymmetry.api.unification.material.properties.FiberProperty;
import supersymmetry.api.unification.material.properties.SuSyPropertyKey;

log.infoMC("Registering new material event listener")

eventManager.listen(EventPriority.LOWEST) {
    MaterialEvent event ->
        log.infoMC("Registering new properties")

        MaterialProperties.addBaseType(SuSyPropertyKey.FIBER)

        log.infoMC("Starting new material registration")
        
        SuSyMaterials.init()

        log.infoMC("Finished new material registration")

        log.infoMC("Starting modifying material flags")

        ChangeFlags.init()

        log.infoMC("Finished modifying material flags")
}
