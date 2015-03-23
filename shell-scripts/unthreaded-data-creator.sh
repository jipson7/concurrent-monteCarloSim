#!/bin/bash

LIMIT=4

for ((i=20; i <= (LIMIT*1000); i=i+20)); do
	
	echo "$i $(java TimeBoundedPi $i)" >> "partb-data.txt"

done
