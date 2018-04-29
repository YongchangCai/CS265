#!/bin/bash

for i in *;do
output=$(wc -l -w "$i");
echo "$i ${output%"$i"}";
done
