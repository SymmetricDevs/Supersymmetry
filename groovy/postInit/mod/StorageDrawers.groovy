def name_removals = [
    'storagedrawers:compacting_drawer',
    'storagedrawers:controller',
    'storagedrawers:controller_slave',
    'storagedrawers:upgrade_storage_gold',
    'storagedrawers:upgrade_storage_diamond',
    'storagedrawers:upgrade_storage_emerald',
    'storagedrawers:upgrade_void',
    'storagedrawers:upgrade_conversion'
]

for (name in name_removals) {
    crafting.remove(name)
}