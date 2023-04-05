def oreDictSmeltingRemovals = [

    ore('oreIron'),
	ore('oreNetherrackIron'),
	ore('oreEndstoneIron'),
	ore('crushedIron'),
	ore('crushedPurifiedIron'),
	ore('crushedCentrifugedIron'),
	ore('dustImpureIron'),
	ore('dustPureIron'),
	ore('dustIron'),

	ore('oreBandedIron'),
	ore('oreNetherrackBandedIron'),
	ore('oreEndstoneBandedIron'),
	ore('crushedBandedIron'),
	ore('crushedPurifiedBandedIron'),
	ore('crushedCentrifugedBandedIron'),
	ore('dustImpureBandedIron'),
	ore('dustPureBandedIron'),
	ore('dustBandedIron'),

	ore('orePyrite'),
	ore('oreNetherrackPyrite'),
	ore('oreEndstonePyrite'),
	ore('crushedPyrite'),
	ore('crushedPurifiedPyrite'),
	ore('crushedCentrifugedPyrite'),
	ore('dustImpurePyrite'),
	ore('dustPurePyrite'),

	ore('oreYellowLimonite'),
	ore('oreNetherrackYellowLimonite'),
	ore('oreEndstoneYellowLimonite'),
	ore('crushedYellowLimonite'),
	ore('crushedPurifiedYellowLimonite'),
	ore('crushedCentrifugedYellowLimonite'),
	ore('dustImpureYellowLimonite'),
	ore('dustPureYellowLimonite'),

	ore('oreBrownLimonite'),
	ore('oreNetherrackBrownLimonite'),
	ore('oreEndstoneBrownLimonite'),
	ore('crushedBrownLimonite'),
	ore('crushedPurifiedBrownLimonite'),
	ore('crushedCentrifugedBrownLimonite'),
	ore('dustImpureBrownLimonite'),
	ore('dustPureBrownLimonite'),

	ore('oreMagnetite'),
	ore('oreNetherrackMagnetite'),
	ore('oreEndstoneMagnetite'),
	ore('crushedMagnetite'),
	ore('crushedPurifiedMagnetite'),
	ore('crushedCentrifugedMagnetite'),
	ore('dustImpureMagnetite'),
	ore('dustPureMagnetite'),

	ore('oreGraniticMineralSand'),
	ore('oreNetherrackGraniticMineralSand'),
	ore('oreEndstoneGraniticMineralSand'),
	ore('crushedGraniticMineralSand'),
	ore('crushedPurifiedGraniticMineralSand'),
	ore('crushedCentrifugedGraniticMineralSand'),
	ore('dustImpureGraniticMineralSand'),
	ore('dustPureGraniticMineralSand'),

	ore('oreBasalticMineralSand'),
	ore('oreNetherrackBasalticMineralSand'),
	ore('oreEndstoneBasalticMineralSand'),
	ore('crushedBasalticMineralSand'),
	ore('crushedPurifiedBasalticMineralSand'),
	ore('crushedCentrifugedBasalticMineralSand'),
	ore('dustImpureBasalticMineralSand'),
	ore('dustPureBasalticMineralSand'),
	ore('dustBasalticMineralSand')
]

for (entry in oreDictSmeltingRemovals) {
    for(item in entry.getMatchingStacks()) {
        furnace.removeByInput(item)
    }
}

def itemSmeltingRemovals = [
		//item('minecraft:clay_ball'),
		item('techguns:itemshared', 38),
		item('techguns:itemshared', 99),
		item('techguns:itemshared', 46)
]

for (item in itemSmeltingRemovals) {
	furnace.removeByInput(item);
}