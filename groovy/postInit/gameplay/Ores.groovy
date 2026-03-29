// Ore Removal

// total = unused ores and material
// partial = ores that are unused but the material can be obtained
// default = ores that only generate their default ore
// nether = ores that only generate their nether ore
// both = ores that generate both ore variants

def oreMap = [
        [name: 'Orthomagmatic', type: 'deposit'],
        [name: 'Metamorphic', type: 'deposit'],
        [name: 'Sedimentary', type: 'deposit'],
        [name: 'Hydrothermal', type: 'deposit'],
        [name: 'Alluvial', type: 'deposit'],
        [name: 'MagmaticHydrothermal', type: 'deposit'],
        [name: 'Coal', type: 'deposit'],
        [name: 'NativeCopper', type: 'deposit'],
        [name: 'Anthracite', type: 'deposit'],
        [name: 'Lignite', type: 'deposit'],
        [name: 'NonMarineEvaporite', type: 'deposit'],
        [name: 'HalideEvaporite', type: 'deposit'],
        [name: 'SulfateEvaporite', type: 'deposit'],
        [name: 'CarbonateEvaporite', type: 'deposit'],
        [name: 'PlatinumPlacer', type: 'deposit'],
        [name: 'Phosphorite', type: 'deposit'],
        [name: 'Potash', type: 'deposit'],
        [name: 'Plutonium', type: 'total'],
        [name: 'Naquadah', type: 'total'],
        [name: 'CertusQuartz', type: 'partial'],
        [name: 'Almandine', type: 'partial'],
        [name: 'Asbestos', type: 'default'],
        [name: 'BandedIron', type: 'both'],
        [name: 'BlueTopaz', type: 'total'],
        [name: 'BrownLimonite', type: 'total'],
        [name: 'Calcite', type: 'both'],
        [name: 'Cassiterite', type: 'both'],
        [name: 'Chalcopyrite', type: 'both'],
        [name: 'Chromite', type: 'default'],
        [name: 'Cinnabar', type: 'both'],
        [name: 'Coal', type: 'partial'],
        [name: 'Cobaltite', type: 'default'],
        [name: 'Cooperite', type: 'default'],
        [name: 'Diamond', type: 'partial'],
        [name: 'Electrum', type: 'partial'],
        [name: 'Emerald', type: 'partial'],
        [name: 'Galena', type: 'both'],
        [name: 'Garnierite', type: 'both'],
        [name: 'GreenSapphire', type: 'total'],
        [name: 'Grossular', type: 'total'],
        [name: 'Ilmenite', type: 'default'],
        [name: 'Lazurite', type: 'partial'],
        [name: 'Magnesite', type: 'both'],
        [name: 'Magnetite', type: 'both'],
        [name: 'Molybdenite', type: 'default'],
        [name: 'Powellite', type: 'total'],
        [name: 'Pyrite', type: 'both'],
        [name: 'Pyrolusite', type: 'default'],
        [name: 'Pyrope', type: 'partial'],
        [name: 'RockSalt', type: 'partial'],
        [name: 'Ruby', type: 'partial'],
        [name: 'Salt', type: 'partial'],
        [name: 'Saltpeter', type: 'default'],
        [name: 'Sapphire', type: 'partial'],
        [name: 'Scheelite', type: 'nether'],
        [name: 'Sodalite', type: 'default'],
        [name: 'Tantalite', type: 'nether'],
        [name: 'Spessartine', type: 'total'],
        [name: 'Sphalerite', type: 'both'],
        [name: 'Stibnite', type: 'default'],
        [name: 'Tetrahedrite', type: 'both'],
        [name: 'Topaz', type: 'total'],
        [name: 'Tungstate', type: 'total'],
        [name: 'Uraninite', type: 'total'],
        [name: 'Wulfenite', type: 'nether'],
        [name: 'YellowLimonite', type: 'total'],
        [name: 'NetherQuartz', type: 'nether'],
        [name: 'Graphite', type: 'both'],
        [name: 'Bornite', type: 'both'],
        [name: 'Chalcocite', type: 'default'],
        [name: 'Realgar', type: 'default'],
        [name: 'Bastnasite', type: 'default'],
        [name: 'Pentlandite', type: 'both'],
        [name: 'Spodumene', type: 'both'],
        [name: 'Lepidolite', type: 'total'],
        [name: 'GlauconiteSand', type: 'total'],
        [name: 'Malachite', type: 'both'],
        [name: 'Barite', type: 'nether'],
        [name: 'Alunite', type: 'nether'],
        [name: 'Kyanite', type: 'partial'],
        [name: 'Pyrochlore', type: 'nether'],
        [name: 'Oilsands', type: 'total'],
        [name: 'Borax', type: 'partial'],
        [name: 'Olivine', type: 'default'],
        [name: 'Opal', type: 'total'],
        [name: 'Amethyst', type: 'total'],
        [name: 'Lapis', type: 'default'],
        [name: 'Apatite', type: 'total'],
        [name: 'TricalciumPhosphate', type: 'partial'],
        [name: 'GarnetRed', type: 'total'],
        [name: 'GarnetYellow', type: 'total'],
        [name: 'VanadiumMagnetite', type: 'total'],
        [name: 'Pollucite', type: 'default'],
        [name: 'FullersEarth', type: 'total'],
        [name: 'Monazite', type: 'partial'],
        [name: 'Trona', type: 'partial'],
        [name: 'Gypsum', type: 'partial'],
        [name: 'Zeolite', type: 'total'],
        [name: 'Redstone', type: 'both'],
        [name: 'Electrotine', type: 'partial'],
        [name: 'Diatomite', type: 'default'],
        [name: 'GraniticMineralSand', type: 'partial'],
        [name: 'GarnetSand', type: 'total'],
        [name: 'BasalticMineralSand', type: 'total'],
        [name: 'Petalite', type: 'total'],
        [name: 'Amblygonite', type: 'total'],
        [name: 'Thortveitite', type: 'total'],
        [name: 'Perovskite', type: 'default'],
        [name: 'Titanomagnetite', type: 'default'],
        [name: 'Fluorapatite', type: 'default'],
        [name: 'VanadiferousTitanomagnetite', type: 'default'],
        [name: 'Baddeleyite', type: 'default'],
        [name: 'Vanadinite', type: 'nether'],
        [name: 'Cerussite', type: 'default'],
        [name: 'Anglesite', type: 'default'],
        [name: 'Enargite', type: 'default'],
        [name: 'Smithsonite', type: 'nether'],
        [name: 'Arsenopyrite', type: 'default'],
        [name: 'Acanthite', type: 'default'],
        [name: 'Pyrargyrite', type: 'default'],
        [name: 'Stephanite', type: 'default'],
        [name: 'Proustite', type: 'default'],
        [name: 'Celestine', type: 'default'],
        [name: 'Strontianite', type: 'partial'],
        [name: 'Witherite', type: 'total'],
        [name: 'Wolframite', type: 'both'],
        [name: 'Rhodplumsite', type: 'total'],
        [name: 'Bowieite', type: 'total'],
        [name: 'Polarite', type: 'total'],
        [name: 'Livingstonite', type: 'total'],
        [name: 'Bismuthinite', type: 'both'],
        [name: 'Lorandite', type: 'total'],
        [name: 'Hutchinsonite', type: 'total'],
        [name: 'Crookesite', type: 'total'],
        [name: 'Dilithium', type: 'total'],
        [name: 'Lignite', type: 'partial'],
        [name: 'Anthracite', type: 'partial'],
        [name: 'Phosphorite', type: 'default'],
        [name: 'Sperrylite', type: 'default'],
        [name: 'Zircon', type: 'default'],
        [name: 'Chlorapatite', type: 'default'],
        [name: 'Columbite', type: 'both'],
        [name: 'Braggite', type: 'default'],
        [name: 'Hydroxyapatite', type: 'default'],
        [name: 'Rhodochrosite', type: 'nether'],
        [name: 'Carnotite', type: 'default'],
        [name: 'AlluvialPgmSand', type: 'partial'],
        [name: 'Bertrandite', type: 'default'],
        [name: 'RawElectrum', type: 'default'],
        [name: 'Fluorite', type: 'both'],
        [name: 'CassiteriteSand', type: 'total'],
        [name: 'Talc', type: 'default'],
        [name: 'Bentonite', type: 'total'],
        [name: 'Pitchblende', type: 'default'],
]

def elementMap = elements.collect { [name: it, type: 'partial'] } // Piggybacks of the list of elements from OreDict.groovy
oreMap.addAll(elementMap)

oreMap.each { material ->
    def name = material.name
    def type = material.type

    def toRemove = []
    def suffix = ''
    def prefixes = []

    if (type == 'deposit') {
        suffix = 'Deposit'
        prefixes = ['dust', 'dustSmall', 'dustTiny', 'dustImpure', 'dustPure', 'crushed',
                    'crushedPurified', 'crushedCentrifuged', 'oreNetherrack', 'oreEndstone']

        // Handle the edge case
        def registryName = name.replaceAll(/([a-z0-9])([A-Z])/, '$1_$2').toLowerCase()
        toRemove << item("gregtech:ore_${registryName}_deposit_0")
    }
    else if (type == 'total') {
        prefixes = ['dust', 'dustSmall', 'dustTiny', 'dustImpure', 'dustPure', 'crushed',
                    'ground', 'crushedPurified', 'crushedCentrifuged', 'gem', 'gemFlawless',
                    'gemExquisite', 'block',  'ore', 'oreNetherrack', 'oreEndstone']
    }
    else if (type == 'partial') {
        prefixes = ['dustImpure', 'dustPure', 'crushed', 'ground', 'crushedPurified', 'gemFlawless',
                    'gemExquisite', 'crushedCentrifuged', 'ore', 'oreNetherrack', 'oreEndstone']
    }
    else if (type == 'nether') {
        prefixes = ['ore', 'oreEndstone']
    }
    else if (type == 'default') {
        prefixes = ['oreNetherack', 'oreEndstone']
    }
    else if (type == 'both') {
        prefixes = ['oreEndstone']
    }

    //One loop to rule them all
    for (pre in prefixes) {
        toRemove << ore(pre + name + suffix)
    }

    for (entry in toRemove) {
        if (entry != null) {
            for (stack in entry.getMatchingStacks()) {
                mods.jei.ingredient.yeet(stack)
            }
        }
    }
}