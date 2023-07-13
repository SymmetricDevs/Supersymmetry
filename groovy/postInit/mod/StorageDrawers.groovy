def name_removals = [
    'storagedrawers:compacting_drawer',
    'storagedrawers:controller',
    'storagedrawers:controller_slave',
    'storagedrawers:upgrade_storage_gold',
    'storagedrawers:upgrade_storage_diamond',
    'storagedrawers:upgrade_storage_emerald',
    'storagedrawers:upgrade_void',
    'storagedrawers:upgrade_conversion',
    'storagedrawers:key_drawer',
	'storagedrawers:key_concealment',
	'storagedrawers:key_personal',
    'storagedrawers:key_quantify',
	'storagedrawers:keybutton_drawer',
    'storagedrawers:keybutton_concealment',
    'storagedrawers:keybutton_personal',
    'storagedrawers:keybutton_quantify'

]

for (name in name_removals) {
    crafting.remove(name)
}