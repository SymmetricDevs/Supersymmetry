#!/bin/bash

# If you are having problems, make sure your java version is 1.8.0_xx with java -version

RAM='2048M'
FORGEJAR="forge-1.12.2-14.23.5.2860.jar"
JAVA_CMD="java" # you can change it to like /usr/lib/jvm/java-8-openjdk/bin/java  if you need a different version without changing the global one

PARAMS="-server -Xms$RAM -Xmx$RAM -jar $FORGEJAR nogui"

# Check Java version is 8
java_version=$($JAVA_CMD -version 2>&1 | grep '^.*version ".*"' | cut -d'"' -f2)

if [[ FORGEJAR == "cleanroom"* ]]; then
    if [[ "$java_version" != "21.0"* ]]; then
        echo "java version is not 21, and you are running cleanroom, please make sure you know what you are doing!!!"
    fi

  else
    if [[ "$java_version" != "1.8"* ]]; then
        echo "java version is not 1.8, please make sure you know what you are doing!!!"
    fi
fi


if [[ -f missing_mods.txt ]]; then
    echo "missing mods:"
    cat missing_mods.txt
    echo "please install these from the website, or get them from your client"
    echo "delete the missing_mods.txt file to continue"
    exit 1
fi


echo "$JAVA_CMD $PARAMS"
$JAVA_CMD $PARAMS
