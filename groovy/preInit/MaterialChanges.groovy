import net.minecraftforge.fml.common.eventhandler.EventPriority
import gregtech.api.GregTechAPI
import gregtech.api.unification.material.event.MaterialEvent;

import material.SuSyMaterials
import classes.ChangeFlags

log.infoMC("Registering new material event listener")

eventManager.listen(EventPriority.LOWEST) {
    MaterialEvent event ->
        log.infoMC("Starting new material registration")
        
        SuSyMaterials.init()

        log.infoMC("Finished new material registration")

        log.infoMC("Starting modifying material flags")

        ChangeFlags.init()

        log.infoMC("Finished modifying material flags")
}
