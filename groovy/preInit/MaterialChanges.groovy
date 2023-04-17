import net.minecraftforge.fml.common.eventhandler.EventPriority
import gregtech.api.GregTechAPI

import classes.RegisterFluids
import classes.RegisterSolids
import classes.RegisterOres
import classes.ChangeFlags

log.infoMC("Registering new material event listener")

eventManager.listen(/*EventPriority.LOWEST*/) {
    GregTechAPI.MaterialEvent event ->

        log.infoMC("Starting new material registration")

        RegisterFluids.init()
        RegisterSolids.init()
        RegisterOres.init()

        log.infoMC("Finished new material registration")

        ChangeFlags.init()

}
