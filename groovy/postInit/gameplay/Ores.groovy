def RedundantOreRemovals = [

        ore('oreOrthomagmaticDeposit'),
        ore('oreNetherrackOrthomagmaticDeposit'),
        ore('oreEndstoneOrthomagmaticDeposit'),
        ore('crushedOrthomagmaticDeposit'),
        ore('crushedPurifiedOrthomagmaticDeposit'),
        ore('crushedCentrifugedOrthomagmaticDeposit'),
        ore('dustImpureOrthomagmaticDeposit'),
        ore('dustPureOrthomagmaticDeposit'),
        ore('dustOrthomagmaticDeposit'),
        ore('dustSmallOrthomagmaticDeposit'),
        ore('dustTinyOrthomagmaticDeposit'),

        ore('oreMetamorphicDeposit'),
        ore('oreNetherrackMetamorphicDeposit'),
        ore('oreEndstoneMetamorphicDeposit'),
        ore('crushedMetamorphicDeposit'),
        ore('crushedPurifiedMetamorphicDeposit'),
        ore('crushedCentrifugedMetamorphicDeposit'),
        ore('dustImpureMetamorphicDeposit'),
        ore('dustPureMetamorphicDeposit'),
        ore('dustMetamorphicDeposit'),
        ore('dustSmallMetamorphicDeposit'),
        ore('dustTinyMetamorphicDeposit'),

        ore('oreSedimentaryDeposit'),
        ore('oreNetherrackSedimentaryDeposit'),
        ore('oreEndstoneSedimentaryDeposit'),
        ore('crushedSedimentaryDeposit'),
        ore('crushedPurifiedSedimentaryDeposit'),
        ore('crushedCentrifugedSedimentaryDeposit'),
        ore('dustImpureSedimentaryDeposit'),
        ore('dustPureSedimentaryDeposit'),
        ore('dustSedimentaryDeposit'),
        ore('dustSmallSedimentaryDeposit'),
        ore('dustTinySedimentaryDeposit'),

        ore('oreHydrothermalDeposit'),
        ore('oreNetherrackHydrothermalDeposit'),
        ore('oreEndstoneHydrothermalDeposit'),
        ore('crushedHydrothermalDeposit'),
        ore('crushedPurifiedHydrothermalDeposit'),
        ore('crushedCentrifugedHydrothermalDeposit'),
        ore('dustImpureHydrothermalDeposit'),
        ore('dustPureHydrothermalDeposit'),
        ore('dustHydrothermalDeposit'),
        ore('dustSmallHydrothermalDeposit'),
        ore('dustTinyHydrothermalDeposit'),

        ore('oreAlluvialDeposit'),
        ore('oreNetherrackAlluvialDeposit'),
        ore('oreEndstoneAlluvialDeposit'),
        ore('crushedAlluvialDeposit'),
        ore('crushedPurifiedAlluvialDeposit'),
        ore('crushedCentrifugedAlluvialDeposit'),
        ore('dustImpureAlluvialDeposit'),
        ore('dustPureAlluvialDeposit'),
        ore('dustAlluvialDeposit'),
        ore('dustSmallAlluvialDeposit'),
        ore('dustTinyAlluvialDeposit'),

        ore('oreMagmaticHydrothermalDeposit'),
        ore('oreNetherrackMagmaticHydrothermalDeposit'),
        ore('oreEndstoneMagmaticHydrothermalDeposit'),
        ore('crushedMagmaticHydrothermalDeposit'),
        ore('crushedPurifiedMagmaticHydrothermalDeposit'),
        ore('crushedCentrifugedMagmaticHydrothermalDeposit'),
        ore('dustImpureMagmaticHydrothermalDeposit'),
        ore('dustPureMagmaticHydrothermalDeposit'),
        ore('dustMagmaticHydrothermalDeposit'),
        ore('dustSmallMagmaticHydrothermalDeposit'),
        ore('dustTinyMagmaticHydrothermalDeposit')

]

for (entry in RedundantOreRemovals) {
    for (item in entry.getMatchingStacks()) {
        mods.jei.removeAndHide(item)
    }
}
