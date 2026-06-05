#!/bin/bash
cd $MSSCFHOME
pushd v2_12/cflib_2_12/java
./Pack* $*
popd
pushd v2_12/cfcore_2_12/java
./Pack* $*
popd
pushd v2_12/cfsec_2_12/java
./Pack* $*
popd
pushd v2_12/cfint_2_12/java
./Pack* $*
popd
pushd v2_12/cfbam_2_12/java
./Pack* $*
popd
pushd v2_12/msscf_2_12/java
./Pack* $*
popd
pushd v2_12/cfkbase_2_12
./Pack* $*
popd
pushd v2_12/cfmodel_2_12
./Pack* $*
popd
cd $MSSCFHOME
