#!/bin/bash
#
export build_tag=$*
if [ "$build_tag" == "" ]; then
	echo "PackageKBaseMSS212.bash ERROR A single argument build tag must be specified"
else
	if [ "${MSSCFHOME}" == "" ]; then
		echo "PackageKBaseMSS212.bash ERROR MSSCFHOME environment variable not found or is empty"
	else
		if [ ! -d ${MSSCFHOME} ]; then
			echo "PackageKBaseMSS212.bash ERROR MSSCFHOME directory ${MSSCFHOME} does not exist"
		else
			pushd ${MSSCFHOME}
				aproj=msskbase
				if [ -d ${aproj}_2_12 ]; then
					pushd ${aproj}_2_12
						if [ ! -d installer ]; then
							mkdir installer
							chmod 755 installer
						fi
						archiveFileName="installer/${aproj}_2_12_${build_tag}-InternalUseOnly-msskbase.zip"
						if [ -f ${archiveFileName} ]; then
							rm -f ${archiveFileName}
						fi
						echo "Packaging ${archiveFileName} ..."
						find cartridge-2.12 -name 'mssprop-1.0.txt' -o -name LICENSE -o -name '*.xml' -o -name '*.ex' | grep -v build | zip '-q9@' ${archiveFileName}
						ls -l ${archiveFileName}
					popd
				fi
			popd
		fi
	fi
fi
