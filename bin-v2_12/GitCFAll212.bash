#!/bin/bash
cd $MSSCFHOME
pushd v2_12/cflib_2_12
$GIT $*
popd
pushd v2_12/cfcore_2_12
$GIT $*
popd
pushd v2_12/cfsec_2_12
$GIT $*
popd
pushd v2_12/cfint_2_12
$GIT $*
popd
pushd v2_12/cfbam_2_12
$GIT $*
popd
pushd v2_12/msscf_2_12
$GIT $*
popd
pushd v2_12/cfkbase_2_12
$GIT $*
popd
pushd v2_12/cfmodel_2_12
$GIT $*
popd
cd $MSSCFHOME
