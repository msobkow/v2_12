#!/bin/bash
Revision=$1
if [ "$Revision" == "" ]; then
	echo "ERROR: Revision (argument 1) not specified" 1>&2
else
	export Revision
	cd $MSSCFHOME/cflib_2_12/cplus
	if [ ! -d ../installer ]; then
		mkdir ../installer
	fi
	chmod 755 ../installer
	ZipFile="../installer/cflib_2_12_${Revision}-wsl-installer.zip"
	export ZipFile
	rm -f ${ZipFile}
	rm -Rf cflib-2.12.${Revision}-wsl
	mkdir cflib-2.12.${Revision}-wsl
	chmod 755 cflib-2.12.${Revision}-wsl
	echo "Preparing cflib-2.12.${Revision}-wsl ..."
	pushd cflib-2.12.${Revision}-wsl
		mkdir bin
		chmod 755 bin
		mkdir bin/msobkow
		chmod 755 bin/msobkow
		mkdir bin/msobkow/2.0.12
		chmod 755 bin/msobkow/2.0.12
		cp /usr/bin/msobkow/2.0.12/testcflib bin/msobkow/2.0.12
		chmod 755 bin/msobkow/2.0.12/*cflib*
		mkdir lib
		chmod 755 lib
		cp /usr/lib/libcflib.la /usr/lib/libcflib.so.2.0.12 lib
		chmod 755 lib/*.so.*
		chmod 644 lib/*.la
		strip bin/msobkow/2.0.12/*cf* lib/*.so.*
		mkdir include
		chmod 755 include
		mkdir include/msobkow
		chmod 755 include/msobkow
		mkdir include/msobkow/2.0.12
		chmod 755 include/msobkow/2.0.12
		mkdir include/msobkow/2.0.12/cflib
		chmod 755 include/msobkow/2.0.12/cflib
		cp /usr/include/msobkow/2.0.12/cflib/*.hpp include/msobkow/2.0.12/cflib
		chmod 644 include/msobkow/2.0.12/cflib*/*.hpp
		mkdir share
		chmod 755 share
		mkdir share/msobkow
		chmod 755 share/msobkow
		mkdir share/msobkow/2.0.12
		chmod 755 share/msobkow/2.0.12
		mkdir share/msobkow/2.0.12/xsd
		chmod 755 share/msobkow/2.0.12/xsd
		cp /usr/share/msobkow/2.0.12/xsd/cftip*.xsd share/msobkow/2.0.12/xsd
		chmod 644 share/msobkow/2.0.12/xsd/*.xsd
	popd
	echo "Packaging cflib-2.12.${Revision}-wsl ..."
	zip -q9r ${ZipFile} cflib-2.12.${Revision}-wsl
	rm -Rf cflib-2.12.${Revision}-wsl
	echo "Packaged ${ZipFile}"
	ls -l ${ZipFile}
fi
