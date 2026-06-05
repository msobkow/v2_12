#!/bin/bash
pushd $MSSCFHOME
mkdir -p $MSSCFHOME/v2_12/bin-v2_12
cd $MSSCFHOME/v2_12/cflib_2_12/java
ant
cd $MSSCFHOME/v2_12/cfcore_2_12/java
ant
cd $MSSCFHOME/v2_12/cfsec_2_12/java
ant
cd $MSSCFHOME/v2_12/cfint_2_12/java
ant
cd $MSSCFHOME/v2_12/cfbam_2_12/java
ant
cd $MSSCFHOME/v2_12/msscf_2_12/java
ant
popd
