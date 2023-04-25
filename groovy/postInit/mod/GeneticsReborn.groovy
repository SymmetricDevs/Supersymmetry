def name_removals = [
    'geneticsreborn:cellanalyser',
    'geneticsreborn:dnaextractor',
    'geneticsreborn:dnadecrypter',
    'geneticsreborn:plasmidinfuser',
    'geneticsreborn:bloodpurifier',
    'geneticsreborn:plasmidinjector',
    'geneticsreborn:cloningmachine',
    'geneticsreborn:antifieldblock',
    'geneticsreborn:coalgenerator',
    'geneticsreborn:incubator',
    'geneticsreborn:advincubator',
    'geneticsreborn:airdispersal',
    'geneticsreborn:glasssyringe',
    'geneticsreborn:metalsyringe',
    'geneticsreborn:metalscraper',
    'geneticsreborn:advancedscraper',
    'geneticsreborn:overclocker',
    'geneticsreborn:antifield',
    'geneticsreborn:dragonhealthcrystal'
]

for (name in name_removals) {
    crafting.remove(name)
}