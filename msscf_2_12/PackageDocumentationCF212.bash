#!/bin/bash
#
export build_tag=$*
if [ "$build_tag" == "" ]; then
	echo "PackageDocumentationCF212.bash ERROR A single argument build tag must be specified"
else
	if [ "${MSSCFHOME}" == "" ]; then
		echo "PackageDocumentationCF212.bash ERROR MSSCFHOME environment variable not found or is empty"
	else
		if [ ! -d ${MSSCFHOME} ]; then
			echo "PackageDocumentationCF212.bash ERROR MSSCFHOME directory ${MSSCFHOME} does not exist"
		else
			pushd ${MSSCFHOME}
				aproj=msscf
				if [ -d ${aproj}_2_12 ]; then

					pushd ${aproj}_2_12
						if [ ! -d installer ]; then
							mkdir installer
							chmod 755 installer
						fi
						archiveFileName="`pwd`/installer/${aproj}_2_12_${build_tag}-DualGPLv3-doc.zip"
						if [ -f ${archiveFileName} ]; then
							rm -f ${archiveFileName}
						fi
						echo "Packaging ${archiveFileName} ..."
						if [ -d ${MSSCFHOME}/msscforg/htdocs/msscf.org/msscf/2.0.12/documentation-2.12 ]; then
							pushd ${MSSCFHOME}/msscforg/htdocs/msscf.org/msscf/2.0.12
								find documentation-2.12 -name 'gpl-3.0.txt' -o -name 'Apache_V2.txt' -o -name LICENSE -o -name '.htaccess' -o -name '*.css' -o -name '*.html' -o -name '*.txt' -o -name '*.xml' -o -name '*.xsd' -o -name '*.jpg' -o -name '*.gif' -o -name '*.png' -o -name '*.bash' | grep -v build | zip '-q9@' ${archiveFileName}
							popd
						fi
						ls -l ${archiveFileName}
					popd
				fi
			popd
		fi
	fi
fi
