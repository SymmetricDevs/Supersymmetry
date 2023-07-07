def name_removals = [
        'cyberware:blueprint_archive',
        'cyberware:component_box',
        'cyberware:surgery_chamber',
        'cyberware:charger',
        'cyberware:engineering_table',
        'cyberware:scanner',
        'cyberware:scanner_1',
        'cyberware:beacon',
        'cyberware:radio_post'
]

for (name in name_removals) {
    crafting.remove(name)
}