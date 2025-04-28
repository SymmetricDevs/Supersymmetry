#!/bin/bash
while true; do
	echo "What file should be created? (Do not include extension)"
	read NAME
	if [[ -n $VAR ]]; then
		exit
	fi

	# NAME="${NAME//./\/}"
	
	# Copy PNG
	PNGFILEPATH="./textures/items/metaitems/"$NAME".png"
	PNGFOLDERPATH=${PNGFILEPATH%\/*}
	mkdir -p $PNGFOLDERPATH
	chmod 777 $PNGFOLDERPATH
	cp -n "blankitem.png" $PNGFILEPATH
	chmod 777 $PNGFILEPATH
	chown -R bruberu $PNGFOLDERPATH
	echo "Created " $PNGFILEPATH
	
	# Copy JSON
	JSONFILEPATH="./models/item/metaitems/"$NAME".json"
	JSONFOLDERPATH=${JSONFILEPATH%\/*}
	mkdir -p $JSONFOLDERPATH
	chmod 777 $JSONFOLDERPATH
	cp "blankmodel.txt" $JSONFILEPATH
	
	# Escapes all characters within the filename, so that sed does not weirdly view the replacement function
	SAFENAME=$(printf '%s\n' "$NAME" | sed -e 's/[\/&]/\\&/g')
	SEDFUNC="s/REPLACE/"$SAFENAME"/"
	# Points the model to the correct texture
	sed -i $SEDFUNC $JSONFILEPATH
	chmod 777 $JSONFILEPATH
	chown -R bruberu $JSONFOLDERPATH
	echo "Created " $JSONFILEPATH
done
