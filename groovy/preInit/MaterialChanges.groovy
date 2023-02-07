import net.minecraftforge.fml.common.eventhandler.EventPriority
import gregtech.api.GregTechAPI

import static classes.RegisterFluids.*
import static classes.ChangeFlags.*

log.infoMC("Registering new material event listener")

eventManager.listen(/*EventPriority.LOWEST*/) {
    GregTechAPI.MaterialEvent event ->

        log.infoMC("Starting new material registration")

        RegisterFluids.init()
        ChangeFlags.init()

}
