#!/bin/bash
cd $MSSCFHOME/v2_12/msscf_2_12/java/bin-v2_12
if [ "$LOG4J2_CONF" != "" ]; then
	export JAVA_LOG4J="-Dlog4j.configurationFile=$LOG4J2_CONF"
else
	export JAVA_LOG4J=""
fi
"$JAVA" $JAVA_LOG4J -Xms1023M --module-path "./lib${JSEP}org.msscf.msscf.cflib.CFLib.jar${JSEP}org.msscf.msscf.cfcore.jar${JSEP}org.msscf.msscf.cfsec.jar${JSEP}org.msscf.msscf.cfint.jar${JSEP}org.msscf.msscf.cfbam.jar${JSEP}org.msscf.msscf.cfsec.CFSecSaxLoader.jar${JSEP}org.msscf.msscf.cfint.CFIntSaxLoader.jar${JSEP}org.msscf.msscf.cfbam.CFBamSaxLoader.jar${JSEP}org.msscf.msscf.cfbam.CFBamMssCF.jar${JSEP}org.msscf.msscf.cfbam.CFBamRam.jar${JSEP}org.msscf.msscf.cfbamcust.MSSBamCF.jar${JSEP}org.msscf.msscf.cfbamcust.CFBamXmlLoader.jar${JSEP}org.msscf.msscf.CFCli.jar" -m org.msscf.msscf.CFCli/org.msscf.msscf.CFCli.CFCli $@
cd $MSSCFHOME
