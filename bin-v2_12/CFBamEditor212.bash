#!/bin/bash
cd $MSSCFHOME/msscf_2_11/java/bin
if [ "$LOG4J2_CONF" != "" ]; then
	export JAVA_LOG4J="-Dlog4j.configurationFile=$LOG4J2_CONF"
else
	export JAVA_LOG4J=""
fi
export PATH=".:$PATH"
"$JAVA" $JAVA_LOG4J -Xms1023M --module-path "$PATH_TO_FX${JSEP}./lib${JSEP}org.msscf.msscf.cflib.CFLib.jar${JSEP}org.msscf.msscf.cflib.CFLib.JavaFX.jar${JSEP}org.msscf.msscf.cfcore.jar${JSEP}org.msscf.msscf.cfsec.jar${JSEP}org.msscf.msscf.cfint.jar${JSEP}org.msscf.msscf.cfbam.jar${JSEP}org.msscf.msscf.cfsec.CFSecSaxLoader.jar${JSEP}org.msscf.msscf.cfint.CFIntSaxLoader.jar${JSEP}org.msscf.msscf.cfsec.CFSecJavaFX.jar${JSEP}org.msscf.msscf.cfint.CFIntJavaFX.jar${JSEP}org.msscf.msscf.cfbam.CFBamSaxLoader.jar${JSEP}org.msscf.msscf.cfbam.CFBamMssCF.jar${JSEP}org.msscf.msscf.cfbam.CFBamRam.jar${JSEP}org.msscf.msscf.cfbam.CFBamJavaFX.jar${JSEP}org.msscf.msscf.cfseccust.CFSecCust.jar${JSEP}org.msscf.msscf.cfintcust.CFIntCust.jar${JSEP}org.msscf.msscf.cfbamcust.MSSBamCF.jar${JSEP}org.msscf.msscf.cfbamcust.CFBamXmlLoader.jar${JSEP}org.msscf.msscf.cfbamcust.CFBamCust.jar${JSEP}org.msscf.msscf.cfbamcust.CFBamCustEditor.jar" -m org.msscf.msscf.cfbamcust.CFBamCustEditor/org.msscf.msscf.cfbamcust.CFBamCustEditor.CFBamCustEditor $@
cd $MSSCFHOME
