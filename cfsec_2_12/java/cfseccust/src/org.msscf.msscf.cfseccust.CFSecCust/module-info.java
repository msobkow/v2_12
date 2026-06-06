/*
 *  MSS Code Factory CFSec 2.12
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

module org.msscf.msscf.cfseccust.CFSecCust {
	exports org.msscf.msscf.cfseccust.CFSecCust;
	requires transitive org.msscf.msscf.cflib.CFLib;
	requires transitive org.msscf.msscf.cflib.CFLib.JavaFX;
	requires transitive org.msscf.msscf.cfsec;
	requires transitive org.msscf.msscf.cfsec.CFSecJavaFX;
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

