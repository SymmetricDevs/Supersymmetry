def name_removals = [
    "cd4017be_lib:dimstack/dim_pipe"
]

for (name in name_removals) {
    crafting.remove(name)
}

crafting.addShaped("interdimensional_pipe", item('dimstack:dim_pipe'), [
        [ore('frameGtSteel'), ore('gemNetherQuartz'), ore('frameGtSteel')],
        [ore('frameGtSteel'), metaitem('crate.wood'), ore('frameGtSteel')],
        [ore('frameGtSteel'), ore('gemNetherQuartz'), ore('frameGtSteel')]
]);