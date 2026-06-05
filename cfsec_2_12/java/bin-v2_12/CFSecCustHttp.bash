#!/bin/bash
ScriptDir=`echo "$0" | sed -e 's,^\(/[-a-zA-Z0-9/\.]*\)/.*,\1,'`
pushd $ScriptDir
JVMTUNE="-Xms1023M"
export PATH=".:$PATH"
$JAVA ${JVMTUNE} --module-path "$PATH_TO_FX${JSEP}./lib${JSEP}cfsec_2_11-custhttp.jar${JSEP}cfsec_2_11-cust.jar${JSEP}cfsec_2_11-javafx.jar${JSEP}cfsec_2_11.jar${JSEP}cfsec_2_11-xmsg.jar${JSEP}cfsec_2_11-xmsgrspn.jar${JSEP}cfsec_2_11-xmsgclient.jar${JSEP}net-sourceforge-MssCF-CFLib-2-9-14117.jar${JSEP}org.apache.httpcomponents.httpent_4.5.2.jar${JSEP}org.apache.httpcomponents.httpcore_4.4.5.jar${JSEP}commons-logging-1.2.jar${JSEP}commons-io-2.5.jar${JSEP}commons-codec-1.10.jar${JSEP}log4j-1.2.17.jar${JSEP}xercesImpl-2.11.0.jar" -m com.github.msobkow.cfseccust.v2_10.CFSecCustHttp.CFSecCustHttp $@ 
popd
