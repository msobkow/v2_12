#!/bin/bash
#
export build_tag=$*
if [ "$build_tag" == "" ]; then
	echo "ArchiveSourceCF212.bash ERROR A single argument build tag must be specified"
else
	if [ "${MSSCFHOME}" == "" ]; then
		echo "ArchiveSourceCF212.bash ERROR MSSCFHOME environment variable not found or is empty"
	else
		if [ ! -d ${MSSCFHOME} ]; then
			echo "ArchiveSourceCF212.bash ERROR MSSCFHOME directory ${MSSCFHOME} does not exist"
		else
			pushd ${MSSCFHOME}
				aproj=msscf
				if [ -d ${aproj}_2_12 ]; then
					pushd ${aproj}_2_12
						if [ ! -d installer ]; then
							mkdir installer
							chmod 755 installer
						fi
						archiveFileName="installer/${aproj}_2_12_${build_tag}-MixedLicensing-src.zip"
						if [ -f ${archiveFileName} ]; then
							rm -f ${archiveFileName}
						fi
						echo "Archiving ${archiveFileName} ..."
						find . -name 'README.md' -o -name '*.ex' -o -name 'Apache_V2.txt' -o -name 'gpl-3.0.txt' -o -name 'lgpl-3.0.txt' -o -name 'LICENSE' -o -name 'migratemodel.ex' -o -name '.gitattributes' -o -name '.gitignore' -o -name '*.bash' -o -name '*.bat' -o -name '*.cmd' -o -name '*.gif' -o -name '*.png' -o -name '*.wav' -o -name '*.xsd' -o -name '*.xml' -o -name '*.java' -o -name '*.cpp' -o -name '*.hpp' -o -name 'Makefile.am' -o -name 'configure.ac' -o -name '*.csproj' -o -name '*.cs' -o -name '*.sql' -o -name '*.tsql' -o -name '*.isql' -o -name '*.pgsql' -o -name '*.plsql' -o -name '*.mysql' | grep -v build | zip '-q9@' ${archiveFileName}
						ls -l ${archiveFileName}
					popd
				fi
			popd
		fi
	fi
fi
