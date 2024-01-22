def oreDictSmeltingRemovals = [

    ore('oreIron'),
	ore('oreNetherrackIron'),
	ore('oreEndstoneIron'),
	ore('crushedIron'),
	ore('crushedPurifiedIron'),
	ore('crushedCentrifugedIron'),
	ore('dustImpureIron'),
	ore('dustPureIron'),
	metaitem('dustIron'),

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
	ore('dustPyrite'),

	ore('oreYellowLimonite'),
	ore('oreNetherrackYellowLimonite'),
	ore('oreEndstoneYellowLimonite'),
	ore('crushedYellowLimonite'),
	ore('crushedPurifiedYellowLimonite'),
	ore('crushedCentrifugedYellowLimonite'),
	ore('dustImpureYellowLimonite'),
	ore('dustPureYellowLimonite'),
	ore('dustYellowLimonite'),

	ore('oreBrownLimonite'),
	ore('oreNetherrackBrownLimonite'),
	ore('oreEndstoneBrownLimonite'),
	ore('crushedBrownLimonite'),
	ore('crushedPurifiedBrownLimonite'),
	ore('crushedCentrifugedBrownLimonite'),
	ore('dustImpureBrownLimonite'),
	ore('dustPureBrownLimonite'),
	ore('dustBrownLimonite'),

	ore('oreMagnetite'),
	ore('oreNetherrackMagnetite'),
	ore('oreEndstoneMagnetite'),
	ore('crushedMagnetite'),
	ore('crushedPurifiedMagnetite'),
	ore('crushedCentrifugedMagnetite'),
	ore('dustImpureMagnetite'),
	ore('dustPureMagnetite'),
	ore('dustMagnetite'),

	ore('oreGraniticMineralSand'),
	ore('oreNetherrackGraniticMineralSand'),
	ore('oreEndstoneGraniticMineralSand'),
	ore('crushedGraniticMineralSand'),
	ore('crushedPurifiedGraniticMineralSand'),
	ore('crushedCentrifugedGraniticMineralSand'),
	ore('dustImpureGraniticMineralSand'),
	ore('dustPureGraniticMineralSand'),
	ore('dustGraniticMineralSand'),

	ore('oreBasalticMineralSand'),
	ore('oreNetherrackBasalticMineralSand'),
	ore('oreEndstoneBasalticMineralSand'),
	ore('crushedBasalticMineralSand'),
	ore('crushedPurifiedBasalticMineralSand'),
	ore('crushedCentrifugedBasalticMineralSand'),
	ore('dustImpureBasalticMineralSand'),
	ore('dustPureBasalticMineralSand'),
	ore('dustBasalticMineralSand'),
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
		item('techguns:itemshared', 46),
		item('techguns:itemshared', 95),
		item('techguns:itemshared', 96),
		item('techguns:itemshared', 39),
		item('biomesoplenty:white_sand'),
		item('biomesoplenty:log_0', 4),
		item('biomesoplenty:log_0', 5),
		item('biomesoplenty:log_0', 6),
		item('biomesoplenty:log_0', 7),
		item('biomesoplenty:log_1', 4),
		item('biomesoplenty:log_1', 5),
		item('biomesoplenty:log_1', 6),
		item('biomesoplenty:log_1', 7),
		item('biomesoplenty:log_2', 4),
		item('biomesoplenty:log_2', 5),
		item('biomesoplenty:log_2', 6),
		item('biomesoplenty:log_2', 7),
		item('biomesoplenty:log_3', 4),
		item('biomesoplenty:log_3', 5),
		item('biomesoplenty:log_3', 6),
		item('biomesoplenty:log_3', 7),
		item('biomesoplenty:log_4', 5)
]

for (item in itemSmeltingRemovals) {
	furnace.removeByInput(item);
}
