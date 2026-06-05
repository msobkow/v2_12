#!/bin/bash
cd $MSSCFHOME/v2_11/msscf_2_11/java/bin
./ManufactureCFCore212.bash $*
cd $MSSCFHOME/v2_11/msscf_2_11/java/bin
./ManufactureCFSec212.bash $*
cd $MSSCFHOME/v2_11/msscf_2_11/java/bin
./ManufactureCFInt212.bash $*
cd $MSSCFHOME/v2_11/msscf_2_11/java/bin
./ManufactureCFBam212.bash $*
cd $MSSCFHOME
