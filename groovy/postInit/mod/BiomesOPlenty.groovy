
def name_removals = [
        "biomesoplenty:mud_from_dirt"
]

for (item in name_removals) {
    crafting.remove(item);
}

crafting.addShapeless("gregtech:mud_block_to_ball", item('biomesoplenty:mudball') * 4, [
        item('biomesoplenty:mud')
])

crafting.addShapeless("gregtech:mud_from_dirt", item('biomesoplenty:mud'), [
        fluid('water') * 1000,
        ore('dirt')
])

item('biomesoplenty:mudball').Item.setMaxStackSize(64)