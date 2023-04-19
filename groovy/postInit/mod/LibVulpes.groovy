def name_removals = [
    "libvulpes:inputhatch",
    "libvulpes:outputhatch",
    "libvulpes:fluidinputhatch",
    "libvulpes:fluidoutputhatch",
    "libvulpes:structuremachine",
    "libvulpes:advstructuremachine",
    "libvulpes:forgepowerinput",
    "libvulpes:coalgenerator",
    "libvulpes:basicmotor",
    "libvulpes:advancedmotor",
    "libvulpes:enhancedmotor",
    "libvulpes:elitemotor",
    "libvulpes:blockgtplug",
    "libvulpes:linker",
    "libvulpes:battery",
    "libvulpes:advbattery"
]

for (name in name_removals) {
    crafting.remove(name)
}