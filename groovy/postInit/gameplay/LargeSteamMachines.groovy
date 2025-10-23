import globals.Globals
import postInit.utils.RecyclingHelper

// Large Steam Hammer

RecyclingHelper.addShaped('susy:large_steam_hammer', metaitem('susy:large_steam_hammer'), [
    [item('gregtech:boiler_casing', 1), item('gregtech:metal_casing', 4), item('gregtech:boiler_casing', 1)],
    [ore('pipeNormalFluidSteel'), item('gregtech:metal_casing', 4), ore('pipeNormalFluidSteel')],
    [metaitem('steam.piston'), metaitem('steam.piston'), metaitem('steam.piston')]
])
