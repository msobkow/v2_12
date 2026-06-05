#!/bin/bash
#
export build_tag=$*
if [ "$build_tag" == "" ]; then
	echo "PackageModelCF212.bash ERROR A single argument build tag must be specified"
else
	if [ "${MSSCFHOME}" == "" ]; then
		echo "PackageModelCF212.bash ERROR MSSCFHOME environment variable not found or is empty"
	else
		if [ ! -d ${MSSCFHOME} ]; then
			echo "PackageModelCF212.bash ERROR MSSCFHOME directory ${MSSCFHOME} does not exist"
		else
			pushd ${MSSCFHOME}
				aproj=cfmodel
				if [ -d ${aproj}_2_12 ]; then
					pushd ${aproj}_2_12
						if [ ! -d installer ]; then
							mkdir installer
							chmod 755 installer
						fi
						archiveFileName="installer/${aproj}_2_12_${build_tag}-MixedLicensing.zip"
						if [ -f ${archiveFileName} ]; then
							rm -f ${archiveFileName}
						fi
						echo "Packaging ${archiveFileName} ..."
						find model-2.12 -name 'mssdual*.txt' -o -name 'lgpl-3.0.txt' -o -name 'gpl-3.0.txt' -o -name 'Apache_V2.txt' -o -name LICENSE -o -name '*.xml' -o -name '*.ex' | grep -v build | zip '-q9@' ${archiveFileName}
						ls -l ${archiveFileName}
					popd
				fi
			popd
		fi
	fi
fi
