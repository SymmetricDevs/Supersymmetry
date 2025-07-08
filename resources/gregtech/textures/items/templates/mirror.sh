#!/usr/bin/env bash

print_usage() {
    echo -e 'Usage: ./mirror.sh texture_file base_color reflection_color'
    echo -e 'Examples:'
    echo -e '\t./mirror.sh ../metaitems/mirror.10_6_micron.png FFE650 FFD97F'
    echo -e '\t./mirror.sh ../metaitems/mirror.hafina_silica.png E1D4AA FFFFFF'
    echo -e '\t./mirror.sh ../metaitems/mirror.molybdenum_silicon.png 3C3C50 B4B4DC'
}

if [[ $# -ne 3 ]]
then
    print_usage
    exit 1
fi
if ! command -v convert >/dev/null 2>&1
then
    echo 'You need Imagemagick "convert" to run this script.'
    exit 1
fi


TEXTURE_PATH=$1
BASE_COLOR=$2
REFLECTION_COLOR=$3

WORK_DIR=`mktemp -d`
convert ./mirror.png \
        -size 16x16 \( xc:"#$2" \) \
        -compose multiply -channel rgba \
        -composite ${WORK_DIR}/base.png 
convert ./mirror_overlay.png \
        -size 16x16 \( xc:"#$3" \) \
        -compose multiply -channel rgba \
        -composite ${WORK_DIR}/overlay.png 
convert ${WORK_DIR}/base.png ${WORK_DIR}/overlay.png \
        -compose over -composite $1