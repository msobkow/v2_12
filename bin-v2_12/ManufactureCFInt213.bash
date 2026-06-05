#!/bin/bash
cd $MSSCFHOME/v2_12/bin-v2_12
buildString=$1
toolsetNames="$2 $3 $4 $5 $6 $7 $8 $9"
./CFManufactureCode212.bash ${buildString} org-msscf-msscf-CFInt-2-13-CFInt org-msscf-msscf-212-stack-java ${toolsetNames}
cd $MSSCFHOME
