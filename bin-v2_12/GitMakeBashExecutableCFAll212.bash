#!/bin/bash
cd $MSSCFHOME
pushd v2_12/cflib_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
pushd v2_12/cfcore_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
pushd v2_12/cfsec_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
pushd v2_12/cfint_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
pushd v2_12/cfbam_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
pushd v2_12/msscf_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
pushd v2_12/cfkbase_2_12
chmod 755 `find . -name '*.bash'`
$GIT add `find . -name '.gitignore' -o -name '*.bash'`
$GIT update-index --add --chmod=+x `find . -name '*.bash'`
popd
cd $MSSCFHOME
