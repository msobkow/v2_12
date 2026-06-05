/*
 *  MSS Code Factory CFBam 2.12
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *
 *	This file is part of MSS Code Factory.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU Lesser General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU Lesser General Public License for more details.
 *
 *	You should have received a copy of the GNU Lesser General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 */

module org.msscf.msscf.cfbam.CFBamJavaFX {
	exports org.msscf.msscf.cfbam.CFBamJavaFX;
	requires transitive org.msscf.msscf.cflib.CFLib;
	requires transitive org.msscf.msscf.cflib.CFLib.JavaFX;
	requires transitive org.msscf.msscf.cfsec;
	requires transitive org.msscf.msscf.cfint;
	requires transitive org.msscf.msscf.cfsec.CFSecSaxLoader;
	requires transitive org.msscf.msscf.cfsec.CFSecJavaFX;
	requires transitive org.msscf.msscf.cfint.CFIntSaxLoader;
	requires transitive org.msscf.msscf.cfint.CFIntJavaFX;
	requires transitive org.msscf.msscf.cfbam;
	requires transitive org.msscf.msscf.cfbam.CFBamSaxLoader;
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

