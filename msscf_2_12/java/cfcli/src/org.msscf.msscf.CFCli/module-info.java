/*
 *  MSS Code Factory MssCF 2.12 CLI
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	These files are part of MSS Code Factory Version 2.12.
 *
 *	MSS Code Factory is available under the terms of the GNU General Public License,
 *	Version 3 or later.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 */

module org.msscf.msscf.CFCli {
	exports org.msscf.msscf.CFCli;
	requires transitive org.msscf.msscf.cflib.CFLib;
	requires transitive org.msscf.msscf.cfcore;
	requires transitive org.msscf.msscf.cfsec;
	requires transitive org.msscf.msscf.cfint;
	requires transitive org.msscf.msscf.cfbam;
	requires transitive org.msscf.msscf.cfbam.CFBamMssCF;
	requires transitive org.msscf.msscf.cfbam.CFBamRam;
	requires transitive org.msscf.msscf.cfbamcust.MSSBamCF;
	requires transitive org.msscf.msscf.cfbamcust.CFBamXmlLoader;
	requires transitive java.rmi;
	requires transitive java.sql;
	requires org.apache.commons.io;
	requires org.apache.commons.logging;
	requires org.apache.logging.log4j;
	requires org.apache.logging.log4j.core;
	requires org.apache.xercesImpl.xml.schema;
	requires org.eclipse.wst.xml.xpath2.processor;
	requires org.apache.httpcomponents.httpclient;
	requires org.apache.httpcomponents.httpcore;
}

