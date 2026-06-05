#!/bin/bash
cd $MSSCFHOME/cfbam_2_12/java/bin
if [ "$LOG4J2_CONF" != "" ]; then
	export JAVA_LOG4J="-Dlog4j.configurationFile=$LOG4J2_CONF"
else
	export JAVA_LOG4J=""
fi
export PATH=".:$PATH"
$JAVA $JAVA_LOG4J -Xms1023M --module-path "$PATH_TO_FX${JSEP}./lib${JSEP}com.github.msobkow.cfbamcust.CFBamCustEditor.jar${JSEP}com.github.msobkow.cfbam.CFBamMssCF.jar${JSEP}com.github.msobkow.cfbamcust.MSSBamCF.jar${JSEP}com.github.msobkow.cfbam.CFBamSaxLoader.jar${JSEP}com.github.msobkow.cfbamcust.CFBamXmlLoader.jar${JSEP}com.github.msobkow.cfbamcust.CFBamCust.jar${JSEP}com.github.msobkow.cfbam.CFBamJavaFX.jar${JSEP}com.github.msobkow.cfbam.jar${JSEP}com.github.msobkow.cfbam.CFBamRam.jar${JSEP}com.github.msobkow.cfintcust.CFIntCust.jar${JSEP}com.github.msobkow.cfint.CFIntJavaFX.jar${JSEP}com.github.msobkow.cfint.CFIntSaxLoader.jar${JSEP}com.github.msobkow.cfint.jar${JSEP}com.github.msobkow.cfseccust.CFSecCust.jar${JSEP}com.github.msobkow.cfsec.CFSecJavaFX.jar${JSEP}com.github.msobkow.cfsec.CFSecSaxLoader.jar${JSEP}com.github.msobkow.cfsec.jar${JSEP}com.github.msobkow.cfcore.jar${JSEP}com.github.msobkow.cflib.CFLib.JavaFX.jar${JSEP}com.github.msobkow.cflib.CFLib.jar" -m com.github.msobkow.cfbamcust.CFBamCustEditor/com.github.msobkow.cfbamcust.CFBamCustEditor.CFBamCustEditor $@ 
