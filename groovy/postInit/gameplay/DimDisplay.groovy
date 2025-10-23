package postInit.gameplay

import dev.tianmi.sussypatches.common.helper.DimDisplayRegistry

def display_items = [
        0: metaitem('display.overworld'),
        (-1): metaitem('display.nether'),
        10: metaitem('display.beneath'),
        800: metaitem('display.moon'),
]

display_items.each { dim, display ->
    DimDisplayRegistry.setDisplayItem(dim, display)
}
