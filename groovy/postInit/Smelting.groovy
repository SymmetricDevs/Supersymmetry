

def smeltingRemovals = [
    ore('ingotIron'),
	ore('chunkIron'),
    ore('oreIron'),
	ore('nuggetIron'),
	ore('ingotNickel'),
	ore('chunkNickel'),
	ore('nuggetNickel'),
	ore('ingotAluminium'),
	ore('chunkAluminium'),
	ore('nuggetAluminium'),
	ore('ingotAluminum'),
	ore('nuggetAluminum'),
	ore('ingotConstantan'),
	ore('nuggetConstantan'),
	ore('ingotSteel'),
	ore('chunkSteel'),
	ore('nuggetSteel'),
	ore('ingotPlatinum'),
	ore('chunkPlatinum'),
	ore('nuggetPlatinum'),
	ore('ingotIronMagnetic'),
	ore('gemCharcoal'),
	ore('ingotTitanium')
]

for (entry in smeltingRemovals) {
    for(item in entry.getMatchingStacks()) {
        //furnace.removeByInput(item)
    }
}