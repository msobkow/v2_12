#!/bin/bash
cd $MSSCFHOME/v2_12/bin-v2_12
./ManufactureCFCore213.bash $*
cd $MSSCFHOME/v2_12/bin-v2_12
./ManufactureCFSec213.bash $*
cd $MSSCFHOME/v2_12/bin-v2_12
./ManufactureCFInt213.bash $*
cd $MSSCFHOME/v2_12/bin-v2_12
./ManufactureCFBam213.bash $*
cd $MSSCFHOME
