#!/bin/bash
build_tag=$*
export build_tag
if [ "$build_tag" == "" ]; then
	echo "PackageDbScripts212.bash ERROR A single argument build tag must be specified"
else
	if [ ! -d installer ]; then
		mkdir installer
		chmod 755 installer
	fi
	archiveFileName="installer/cfsec_2_12_${build_tag}-DualGPLv3-db_scripts.zip"
	if [ -f ${archiveFileName} ]; then
		rm -f ${archiveFileName}
	fi
	if [ -d dbcreate ]; then
		echo "Packaging ${archiveFileName} ..."
		find dbcreate -name 'gpl-3.0.txt' -o -name 'LICENSE' -o -name '*.bash' -o -name '*.bat' -o -name '*.cmd' -o -name '*.xsd' -o -name '*.xml' -o -name '*.sql' -o -name '*.tsql' -o -name '*.isql' -o -name '*.pgsql' -o -name '*.plsql' -o -name '*.mysql' | grep -v build | zip '-q9@' ${archiveFileName}
		ls -l ${archiveFileName}
	fi
fi
