
import static supersymmetry.api.chisel.ExtendedChiselAPI.*

import static prePostInit.Recipemaps.*
import static gregtech.api.GTValues.*



crafting.addShaped(item('gregtech:machine',18528),
        [[item('minecraft:paper'),item('opencomputers:material', 27),item('minecraft:paper')],
         [metaitem('electric.motor.lv'), metaitem('hull.lv'), ore('circuitLv')],
         [ore('plateIron'),ore('plateIron'),ore('plateIron')]])





// ---------------------------------------------------------------------------
// Extended Chisel Maker API
//
// Groups and locations are independent:
//   - addItemToGroup / addItemsToGroup  = recipe memberships. Any block of a
//     group crafts into any other block of the same group (1:1, no template).
//     A block may belong to several groups.
//   - addLocationsToItem                = placement ONLY. These Extended
//     Location Identifiers (folder paths) decide where the block appears in
//     the machine's folder browser and what its search text is. They never
//     affect recipes.
// ---------------------------------------------------------------------------

// 1) Create your own groups and add blocks to them (recipe membership).
def myFacadeGroup = createExtendedChiselGroup('susy.facades')
addItemToGroup('susy.facades', item('chisel:marble'))
addItemToGroup('susy.facades', item('chisel:marble', 1))
addItemToGroup('susy.facades', item('minecraft:stone'))
addItemToGroup('susy.facades', item('minecraft:brick_block'))

// 2) Place them in the browser, completely independently of the group above.
addLocationsToItem(item('chisel:marble'), 'susy/facades/Stone-like')
addLocationsToItem(item('chisel:marble', 1), 'susy/facades/Stone-like', 'decor/bricks')
addLocationsToItem(item('minecraft:stone'), 'susy/facades/Stone-like')
addLocationsToItem(item('minecraft:brick_block'), 'susy/facades/Masonry')




def BMRF_GROUP = createExtendedChiselGroup('BMRF_blocks')


for (int i = 0; i < 16; i++) {
    addItemToGroup('BMRF_blocks', item('susy:bmrf_blocks', i))
}

for (int j = 2; j < 17; j++) {
    for (int i = 0; i < 16; i++) {
        addItemToGroup('BMRF_blocks', item('susy:s'+j+'bmrf_blocks', i))
    }
}




def addLocationBMRF(folder,i_bmrf){
    location_i = (i_bmrf-1)%16
    location_j = (i_bmrf-1).intdiv(16)+1
    if (location_j==1){
        log.info(i_bmrf+' '+location_j+' '+location_i)
        addLocationsToItem(item('susy:bmrf_blocks', location_i), folder) 
    }else{
        log.info(i_bmrf+' '+location_j+' '+location_i)
        addLocationsToItem(item('susy:s'+location_j+'bmrf_blocks', location_i), folder)
    }
}


def addLocationsRangeBMRF(folder,i_start,i_end) {
    for (int i = i_start; i < i_end+1; i++){
        addLocationBMRF(folder,i)
    }
}


//addLocationsRangeBMRF('VALVE/BMRF',2,256)


//BY LOCATION
addLocationsRangeBMRF('VALVE/BMRF/Legacy',1,32)
addLocationsRangeBMRF('VALVE/BMRF/Legacy',37,41)
addLocationsRangeBMRF('VALVE/BMRF/Unforeseen Consequences',33,36)
addLocationsRangeBMRF('VALVE/BMRF/Unforeseen Consequences',42,62)
addLocationsRangeBMRF('VALVE/BMRF/Unforeseen Consequences',217,220)



addLocationsRangeBMRF('VALVE/BMRF/Office Complex',63,76)

addLocationsRangeBMRF('VALVE/BMRF/We Got Hostiles',77,93)

addLocationBMRF('VALVE/BMRF/Blast Pit',79)
addLocationBMRF('VALVE/BMRF/Blast Pit',81)
addLocationsRangeBMRF('VALVE/BMRF/Blast Pit',91,107)

addLocationsRangeBMRF('VALVE/BMRF/Power Up',108,136)

addLocationsRangeBMRF('VALVE/BMRF/On A Rail',130,136)
addLocationsRangeBMRF('VALVE/BMRF/On A Rail',158,159)

addLocationsRangeBMRF('VALVE/BMRF/Apprehension',137,157)
addLocationsRangeBMRF('VALVE/BMRF/Apprehension',51,52)
addLocationsRangeBMRF('VALVE/BMRF/Apprehension',181,187)


addLocationsRangeBMRF('VALVE/BMRF/Residue Processing',160,163)

addLocationsRangeBMRF('VALVE/BMRF/Questionable Ethics',164,180)

addLocationsRangeBMRF('VALVE/BMRF/Surface Tension',185,186)
addLocationsRangeBMRF('VALVE/BMRF/Surface Tension',188,191)
addLocationBMRF('VALVE/BMRF/Surface Tension',194)


addLocationsRangeBMRF('VALVE/BMRF/Lambda Core',192,193)
addLocationsRangeBMRF('VALVE/BMRF/Lambda Core',195,216)
addLocationsRangeBMRF('VALVE/BMRF/Lambda Core',225,228)
addLocationBMRF('VALVE/BMRF/Lambda Core',229)



addLocationsRangeBMRF('VALVE/BMRF Blue Shift/Sector G Hydro',217,224)
addLocationsRangeBMRF('VALVE/BMRF Blue Shift/Sector G Hydro',230,256)




//BY TYPE
def ids = [17,22, 23, 24, 29, 33, 35, 40, 42, 43, 52, 54, 60, 65, 72, 79, 80, 84, 85, 90, 96, 114, 118, 135,137,139, 142, 145, 148, 154, 156, 164, 180, 185, 187, 188, 198, 201, 204, 208, 209, 211, 218, 219, 232, 233, 246, 248, 250, 253, 255, 256]

for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Walls/Solids/BMRF',ids[i])
}

ids = [19,21, 69, 70, 236]

for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Walls/Bricks/BMRF',ids[i])
}

ids = [11,25,34, 36, 41, 44, 51, 67, 68, 73, 74, 77, 83, 87, 88, 91, 94, 95, 103, 104, 138, 143, 146, 149, 150, 151, 155, 165..170, 225..229, 234, 236, 238, 244, 245, 247].flatten()

for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Walls/Floor Connectors/BMRF',ids[i])
}

ids = [32,61, 66, 71, 78, 82, 86, 89, 101, 102, 105, 106, 107, 111, 112, 116, 117, 115, 131, 132, 133, 134, 140, 144, 147, 152, 153, 157, 181, 182, 183, 184, 190, 192, 194, 199, 203, 205, 207, 210, 212, 214, 215, 216, 220, 235, 239, 240, 242, 243, 249, 113]

for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Walls/Connectors/BMRF',ids[i])
}

ids = [4,5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 26, 27, 28, 30, 31, 37, 38, 39, 46, 47, 56, 55, 63, 75, 76, 97, 98, 99, 100, 108, 119..129, 141, 158, 159, 160, 161, 162, 163, 178, 179, 186, 189, 191, 200, 202, 206, 213, 214, 215, 217, 224, 241, 251, 254].flatten()

for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Walls/Misc/BMRF',ids[i])
}


ids = [109, 110, 130..134, 136].flatten()
for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Doors/BMRF',ids[i])
}

ids = [1, 2, 3, 37, 38, 39, 42, 43, 45, 48, 49, 53, 57, 58, 59, 63, 81, 92, 93, 171, 172, 173, 174..177, 193, 195, 196, 197, 221, 222, 230, 231].flatten()

for (int i = 0; i < ids.size(); i++) {
    addLocationBMRF('Floors/BMRF',ids[i])
}








// The same block may mirror other groups and keep several locations.
//def allenKeyGroup = createExtendedChiselGroup('chisel.allenkey')
//addItemToGroup('chisel.allenkey', item('chisel:marble', 1))

// 3) Bulk: raise several blocks into one group (recipe membership only).
//addItemsToGroup('susy.facades',
//    [item('minecraft:stone'), item('minecraft:stonebrick')] as ItemStack[])

// 4) Inspect what Chisel offers, before deciding what to convert.
//def chiselGroupNames = getAllChiselGroups()
//log.info('Chisel groups available: ' + chiselGroupNames)

// 5) Auto-convert every Chisel group into an extended group (best-effort, it
//    never touches the Chisel registry), except the ones you exclude.
//excludeChiselGroups('cluster')          // leave the 'cluster' group alone
//excludeChiselGroups('voidstone')        // and this one too
convertChiselGroups()                   // converts everything else

// Every converted item lands under chisel/{group}/{block} in the browser.