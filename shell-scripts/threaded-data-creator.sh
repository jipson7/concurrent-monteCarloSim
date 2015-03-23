#!/bin/bash

ARRAY=(2 4 6 8 16 32)

for j in "${ARRAY[@]}"; do

	LIMIT=4
	THREADS=$j

	for ((i=20; i <= (LIMIT*1000); i=i+20)); do
		
		echo "$i $(java ThreadedTimeBoundedPi $i $THREADS)" >> "partd-data-$THREADS.txt"

	done

done
