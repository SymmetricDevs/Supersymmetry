def name_removals = [
        "overloaded:blocks/basic/container/infinite_barrel",
        "overloaded:blocks/basic/container/infinite_tank",
        "overloaded:blocks/basic/container/infinite_capacitor",
        "overloaded:blocks/basic/hypertransfer/hyper_item_receiver",
        "overloaded:blocks/basic/hypertransfer/hyper_item_sender",
        "overloaded:blocks/basic/hypertransfer/hyper_fluid_receiver",
        "overloaded:blocks/basic/hypertransfer/hyper_fluid_sender",
        "overloaded:blocks/basic/hypertransfer/hyper_energy_receiver",
        "overloaded:blocks/basic/hypertransfer/hyper_energy_sender",
        "overloaded:blocks/basic/infinite_water_source",
        "overloaded:blocks/basic/energy_extractor",
        "overloaded:blocks/basic/item_interface",
        "overloaded:blocks/basic/player_interface",
        "overloaded:items/functional/linking_card",
        "overloaded:items/functional/multi_tool",
        "overloaded:items/crafting/energy_core",
        "overloaded:items/crafting/fluid_core",
        "overloaded:items/crafting/item_core",
        "overloaded:items/functional/armor/multi_helmet",
        "overloaded:items/functional/armor/multi_chestplate",
        "overloaded:items/functional/armor/multi_leggings",
        "overloaded:items/functional/armor/multi_boots",
        "overloaded:items/functional/rail_gun",
        "overloaded:items/functional/settings_editor"
]

for (item in name_removals) {
    crafting.remove(item);
}