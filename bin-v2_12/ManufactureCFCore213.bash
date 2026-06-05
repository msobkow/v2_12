#!/bin/bash
cd $MSSCFHOME/v2_12/bin-v2_12
buildString=$1
toolsetNames="$2 $3 $4 $5 $6 $7 $8 $9"
./CFManufactureCode212.bash ${buildString} org-msscf-msscf-CFCore-2-13-CFGenKb org-msscf-msscf-212-cfengine ${toolsetNames}
cd $MSSCFHOME
