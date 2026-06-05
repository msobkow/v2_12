#!/bin/bash
#
Revision=$1
if [ ! -d ../installer ]; then
	mkdir ../installer
fi
if [ "$Revision" == "" ]; then
	echo "ERROR: Revision (argument 1) not specified" 1>&2
else
	archiveFile="../installer/cfcore_2_12_${Revision}-DualGPLv3-java-installer.zip"
	rm -f ${archiveFile}
	zip -q9 ${archiveFile} gpl-3.0.txt LICENSE bin/*.jar bin/lib/*.jar bin/gpl-3.0.txt bin/xsd/*.xsd
	echo "Packaged ${archiveFile}"
	ls -l ${archiveFile}
fi
