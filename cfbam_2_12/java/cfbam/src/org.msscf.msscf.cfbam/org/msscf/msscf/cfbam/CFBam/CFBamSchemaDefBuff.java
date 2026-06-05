// Description: Java 11 implementation of a SchemaDef buffer object.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
 */

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFBamSchemaDefBuff
	extends CFBamScopeBuff
	implements Comparable<Object>,
		Serializable
{
	public final static String CLASS_CODE = "SCHM";
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final long MINORVERSIONID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final long DEFAULTLICENSETENANTID_INIT_VALUE = 0L;
	public static final long DEFAULTLICENSEID_INIT_VALUE = 0L;
	public static final String COPYRIGHTPERIOD_INIT_VALUE = new String( "2014" );
	public static final String COPYRIGHTHOLDER_INIT_VALUE = new String( "YourNameHere" );
	public static final String AUTHOREMAIL_INIT_VALUE = new String( "" );
	public static final String PROJECTURL_INIT_VALUE = new String( "" );
	public static final String PUBLISHURI_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JSCHEMAOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JDB2LUWSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JDB2LUWSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JDB2LUWSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JMSSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMSSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JMSSQLSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JMYSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMYSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JMYSQLSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JORACLESCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JORACLESCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JORACLESCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JPGSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JPGSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JPGSQLSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JRAMSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JRAMSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String JRAMSCHEMAOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGSCHEMAFORMATTERS_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String CPPSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPSCHEMAOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CPPSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPSCHEMAOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPDB2LUWSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPDB2LUWSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CPPDB2LUWSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPMSSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPMSSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CPPMSSQLSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPMYSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPMYSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CPPMYSQLSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPORACLESCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPORACLESCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CPPORACLESCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPPGSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPPGSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CPPPGSQLSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPRAMSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPRAMSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CPPRAMSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGSCHEMAFORMATTERS_INIT_VALUE = new String( "" );
	public static final String CPPXMSGCLIENTSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGCLIENTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String HPPSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPSCHEMAOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String HPPSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPSCHEMAOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPDB2LUWSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPDB2LUWSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String HPPDB2LUWSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPMSSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPMSSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String HPPMSSQLSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPMYSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPMYSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String HPPMYSQLSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPORACLESCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPORACLESCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String HPPORACLESCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPPGSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPPGSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String HPPPGSQLSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPRAMSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPRAMSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String HPPRAMSCHEMAOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGSCHEMAFORMATTERS_INIT_VALUE = new String( "" );
	public static final String HPPXMSGCLIENTSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGCLIENTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNSCHEMAINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String CSSCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSSCHEMAOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CSSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSSCHEMAOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSDB2LUWSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSDB2LUWSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CSDB2LUWSCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSMSSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSMSSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CSMSSQLSCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSMYSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSMYSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CSMYSQLSCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSORACLESCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSORACLESCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CSORACLESCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSPGSQLSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSPGSQLSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CSPGSQLSCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSRAMSCHEMAOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSRAMSCHEMAOBJIMPL_INIT_VALUE = new String( "" );
	public static final String CSRAMSCHEMAOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGSCHEMAUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGSCHEMAFORMATTERS_INIT_VALUE = new String( "" );
	public static final String CSXMSGCLIENTSCHEMAUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGCLIENTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTSCHEMAUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNSCHEMABODY_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNSCHEMAUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNSCHEMAWIREPARSERS_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNSCHEMAXSDELEMENTLIST_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNSCHEMAXSDSPEC_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long MINORVERSIONID_MIN_VALUE = 0L;
	public static final long DEFAULTLICENSETENANTID_MIN_VALUE = 0L;
	public static final long DEFAULTLICENSEID_MIN_VALUE = 0L;
	protected long requiredMinorVersionId;
	protected String requiredName;
	protected String optionalDbName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected Long optionalDefaultLicenseTenantId;
	protected Long optionalDefaultLicenseId;
	protected String requiredCopyrightPeriod;
	protected String requiredCopyrightHolder;
	protected String requiredAuthorEMail;
	protected String requiredProjectURL;
	protected String requiredPublishURI;
	protected String optionalJSchemaObjImport;
	protected String optionalJSchemaObjInterface;
	protected String optionalJSchemaObjMembers;
	protected String optionalJSchemaObjImplementation;
	protected String optionalJDb2LUWSchemaObjMembers;
	protected String optionalJDb2LUWSchemaObjImpl;
	protected String optionalJDb2LUWSchemaObjImport;
	protected String optionalJMSSqlSchemaObjMembers;
	protected String optionalJMSSqlSchemaObjImpl;
	protected String optionalJMSSqlSchemaObjImport;
	protected String optionalJMySqlSchemaObjMembers;
	protected String optionalJMySqlSchemaObjImpl;
	protected String optionalJMySqlSchemaObjImport;
	protected String optionalJOracleSchemaObjMembers;
	protected String optionalJOracleSchemaObjImpl;
	protected String optionalJOracleSchemaObjImport;
	protected String optionalJPgSqlSchemaObjMembers;
	protected String optionalJPgSqlSchemaObjImpl;
	protected String optionalJPgSqlSchemaObjImport;
	protected String optionalJRamSchemaObjMembers;
	protected String optionalJRamSchemaObjImpl;
	protected String optionalJRamSchemaObjImport;
	protected String optionalJXMsgSchemaImport;
	protected String optionalJXMsgSchemaFormatters;
	protected String optionalJXMsgClientSchemaImport;
	protected String optionalJXMsgClientSchemaBody;
	protected String optionalJXMsgRqstSchemaBody;
	protected String optionalJXMsgRqstSchemaImport;
	protected String optionalJXMsgRqstSchemaWireParsers;
	protected String optionalJXMsgRqstSchemaXsdSpec;
	protected String optionalJXMsgRqstSchemaXsdElementList;
	protected String optionalJXMsgRspnSchemaBody;
	protected String optionalJXMsgRspnSchemaImport;
	protected String optionalJXMsgRspnSchemaWireParsers;
	protected String optionalJXMsgRspnSchemaXsdElementList;
	protected String optionalJXMsgRspnSchemaXsdSpec;
	protected String optionalCppSchemaObjInclude;
	protected String optionalCppSchemaObjInterface;
	protected String optionalCppSchemaObjMembers;
	protected String optionalCppSchemaObjImplementation;
	protected String optionalCppDb2LUWSchemaObjMembers;
	protected String optionalCppDb2LUWSchemaObjImpl;
	protected String optionalCppDb2LUWSchemaObjInclude;
	protected String optionalCppMSSqlSchemaObjMembers;
	protected String optionalCppMSSqlSchemaObjImpl;
	protected String optionalCppMSSqlSchemaObjInclude;
	protected String optionalCppMySqlSchemaObjMembers;
	protected String optionalCppMySqlSchemaObjImpl;
	protected String optionalCppMySqlSchemaObjInclude;
	protected String optionalCppOracleSchemaObjMembers;
	protected String optionalCppOracleSchemaObjImpl;
	protected String optionalCppOracleSchemaObjInclude;
	protected String optionalCppPgSqlSchemaObjMembers;
	protected String optionalCppPgSqlSchemaObjImpl;
	protected String optionalCppPgSqlSchemaObjInclude;
	protected String optionalCppRamSchemaObjMembers;
	protected String optionalCppRamSchemaObjImpl;
	protected String optionalCppRamSchemaObjInclude;
	protected String optionalCppXMsgSchemaInclude;
	protected String optionalCppXMsgSchemaFormatters;
	protected String optionalCppXMsgClientSchemaInclude;
	protected String optionalCppXMsgClientSchemaBody;
	protected String optionalCppXMsgRqstSchemaBody;
	protected String optionalCppXMsgRqstSchemaInclude;
	protected String optionalCppXMsgRqstSchemaWireParsers;
	protected String optionalCppXMsgRqstSchemaXsdSpec;
	protected String optionalCppXMsgRqstSchemaXsdElementList;
	protected String optionalCppXMsgRspnSchemaBody;
	protected String optionalCppXMsgRspnSchemaInclude;
	protected String optionalCppXMsgRspnSchemaWireParsers;
	protected String optionalCppXMsgRspnSchemaXsdElementList;
	protected String optionalCppXMsgRspnSchemaXsdSpec;
	protected String optionalHppSchemaObjInclude;
	protected String optionalHppSchemaObjInterface;
	protected String optionalHppSchemaObjMembers;
	protected String optionalHppSchemaObjImplementation;
	protected String optionalHppDb2LUWSchemaObjMembers;
	protected String optionalHppDb2LUWSchemaObjImpl;
	protected String optionalHppDb2LUWSchemaObjInclude;
	protected String optionalHppMSSqlSchemaObjMembers;
	protected String optionalHppMSSqlSchemaObjImpl;
	protected String optionalHppMSSqlSchemaObjInclude;
	protected String optionalHppMySqlSchemaObjMembers;
	protected String optionalHppMySqlSchemaObjImpl;
	protected String optionalHppMySqlSchemaObjInclude;
	protected String optionalHppOracleSchemaObjMembers;
	protected String optionalHppOracleSchemaObjImpl;
	protected String optionalHppOracleSchemaObjInclude;
	protected String optionalHppPgSqlSchemaObjMembers;
	protected String optionalHppPgSqlSchemaObjImpl;
	protected String optionalHppPgSqlSchemaObjInclude;
	protected String optionalHppRamSchemaObjMembers;
	protected String optionalHppRamSchemaObjImpl;
	protected String optionalHppRamSchemaObjInclude;
	protected String optionalHppXMsgSchemaInclude;
	protected String optionalHppXMsgSchemaFormatters;
	protected String optionalHppXMsgClientSchemaInclude;
	protected String optionalHppXMsgClientSchemaBody;
	protected String optionalHppXMsgRqstSchemaBody;
	protected String optionalHppXMsgRqstSchemaInclude;
	protected String optionalHppXMsgRqstSchemaWireParsers;
	protected String optionalHppXMsgRqstSchemaXsdSpec;
	protected String optionalHppXMsgRqstSchemaXsdElementList;
	protected String optionalHppXMsgRspnSchemaBody;
	protected String optionalHppXMsgRspnSchemaInclude;
	protected String optionalHppXMsgRspnSchemaWireParsers;
	protected String optionalHppXMsgRspnSchemaXsdElementList;
	protected String optionalHppXMsgRspnSchemaXsdSpec;
	protected String optionalCsSchemaObjUsing;
	protected String optionalCsSchemaObjInterface;
	protected String optionalCsSchemaObjMembers;
	protected String optionalCsSchemaObjImplementation;
	protected String optionalCsDb2LUWSchemaObjMembers;
	protected String optionalCsDb2LUWSchemaObjImpl;
	protected String optionalCsDb2LUWSchemaObjUsing;
	protected String optionalCsMSSqlSchemaObjMembers;
	protected String optionalCsMSSqlSchemaObjImpl;
	protected String optionalCsMSSqlSchemaObjUsing;
	protected String optionalCsMySqlSchemaObjMembers;
	protected String optionalCsMySqlSchemaObjImpl;
	protected String optionalCsMySqlSchemaObjUsing;
	protected String optionalCsOracleSchemaObjMembers;
	protected String optionalCsOracleSchemaObjImpl;
	protected String optionalCsOracleSchemaObjUsing;
	protected String optionalCsPgSqlSchemaObjMembers;
	protected String optionalCsPgSqlSchemaObjImpl;
	protected String optionalCsPgSqlSchemaObjUsing;
	protected String optionalCsRamSchemaObjMembers;
	protected String optionalCsRamSchemaObjImpl;
	protected String optionalCsRamSchemaObjUsing;
	protected String optionalCsXMsgSchemaUsing;
	protected String optionalCsXMsgSchemaFormatters;
	protected String optionalCsXMsgClientSchemaUsing;
	protected String optionalCsXMsgClientSchemaBody;
	protected String optionalCsXMsgRqstSchemaBody;
	protected String optionalCsXMsgRqstSchemaUsing;
	protected String optionalCsXMsgRqstSchemaWireParsers;
	protected String optionalCsXMsgRqstSchemaXsdSpec;
	protected String optionalCsXMsgRqstSchemaXsdElementList;
	protected String optionalCsXMsgRspnSchemaBody;
	protected String optionalCsXMsgRspnSchemaUsing;
	protected String optionalCsXMsgRspnSchemaWireParsers;
	protected String optionalCsXMsgRspnSchemaXsdElementList;
	protected String optionalCsXMsgRspnSchemaXsdSpec;
	public CFBamSchemaDefBuff() {
		super();
		requiredMinorVersionId = CFBamSchemaDefBuff.MINORVERSIONID_INIT_VALUE;
		requiredName = new String( CFBamSchemaDefBuff.NAME_INIT_VALUE );
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		optionalDefaultLicenseTenantId = null;
		optionalDefaultLicenseId = null;
		requiredCopyrightPeriod = new String( CFBamSchemaDefBuff.COPYRIGHTPERIOD_INIT_VALUE );
		requiredCopyrightHolder = new String( CFBamSchemaDefBuff.COPYRIGHTHOLDER_INIT_VALUE );
		requiredAuthorEMail = new String( CFBamSchemaDefBuff.AUTHOREMAIL_INIT_VALUE );
		requiredProjectURL = new String( CFBamSchemaDefBuff.PROJECTURL_INIT_VALUE );
		requiredPublishURI = new String( CFBamSchemaDefBuff.PUBLISHURI_INIT_VALUE );
		optionalJSchemaObjImport = null;
		optionalJSchemaObjInterface = null;
		optionalJSchemaObjMembers = null;
		optionalJSchemaObjImplementation = null;
		optionalJDb2LUWSchemaObjMembers = null;
		optionalJDb2LUWSchemaObjImpl = null;
		optionalJDb2LUWSchemaObjImport = null;
		optionalJMSSqlSchemaObjMembers = null;
		optionalJMSSqlSchemaObjImpl = null;
		optionalJMSSqlSchemaObjImport = null;
		optionalJMySqlSchemaObjMembers = null;
		optionalJMySqlSchemaObjImpl = null;
		optionalJMySqlSchemaObjImport = null;
		optionalJOracleSchemaObjMembers = null;
		optionalJOracleSchemaObjImpl = null;
		optionalJOracleSchemaObjImport = null;
		optionalJPgSqlSchemaObjMembers = null;
		optionalJPgSqlSchemaObjImpl = null;
		optionalJPgSqlSchemaObjImport = null;
		optionalJRamSchemaObjMembers = null;
		optionalJRamSchemaObjImpl = null;
		optionalJRamSchemaObjImport = null;
		optionalJXMsgSchemaImport = null;
		optionalJXMsgSchemaFormatters = null;
		optionalJXMsgClientSchemaImport = null;
		optionalJXMsgClientSchemaBody = null;
		optionalJXMsgRqstSchemaBody = null;
		optionalJXMsgRqstSchemaImport = null;
		optionalJXMsgRqstSchemaWireParsers = null;
		optionalJXMsgRqstSchemaXsdSpec = null;
		optionalJXMsgRqstSchemaXsdElementList = null;
		optionalJXMsgRspnSchemaBody = null;
		optionalJXMsgRspnSchemaImport = null;
		optionalJXMsgRspnSchemaWireParsers = null;
		optionalJXMsgRspnSchemaXsdElementList = null;
		optionalJXMsgRspnSchemaXsdSpec = null;
		optionalCppSchemaObjInclude = null;
		optionalCppSchemaObjInterface = null;
		optionalCppSchemaObjMembers = null;
		optionalCppSchemaObjImplementation = null;
		optionalCppDb2LUWSchemaObjMembers = null;
		optionalCppDb2LUWSchemaObjImpl = null;
		optionalCppDb2LUWSchemaObjInclude = null;
		optionalCppMSSqlSchemaObjMembers = null;
		optionalCppMSSqlSchemaObjImpl = null;
		optionalCppMSSqlSchemaObjInclude = null;
		optionalCppMySqlSchemaObjMembers = null;
		optionalCppMySqlSchemaObjImpl = null;
		optionalCppMySqlSchemaObjInclude = null;
		optionalCppOracleSchemaObjMembers = null;
		optionalCppOracleSchemaObjImpl = null;
		optionalCppOracleSchemaObjInclude = null;
		optionalCppPgSqlSchemaObjMembers = null;
		optionalCppPgSqlSchemaObjImpl = null;
		optionalCppPgSqlSchemaObjInclude = null;
		optionalCppRamSchemaObjMembers = null;
		optionalCppRamSchemaObjImpl = null;
		optionalCppRamSchemaObjInclude = null;
		optionalCppXMsgSchemaInclude = null;
		optionalCppXMsgSchemaFormatters = null;
		optionalCppXMsgClientSchemaInclude = null;
		optionalCppXMsgClientSchemaBody = null;
		optionalCppXMsgRqstSchemaBody = null;
		optionalCppXMsgRqstSchemaInclude = null;
		optionalCppXMsgRqstSchemaWireParsers = null;
		optionalCppXMsgRqstSchemaXsdSpec = null;
		optionalCppXMsgRqstSchemaXsdElementList = null;
		optionalCppXMsgRspnSchemaBody = null;
		optionalCppXMsgRspnSchemaInclude = null;
		optionalCppXMsgRspnSchemaWireParsers = null;
		optionalCppXMsgRspnSchemaXsdElementList = null;
		optionalCppXMsgRspnSchemaXsdSpec = null;
		optionalHppSchemaObjInclude = null;
		optionalHppSchemaObjInterface = null;
		optionalHppSchemaObjMembers = null;
		optionalHppSchemaObjImplementation = null;
		optionalHppDb2LUWSchemaObjMembers = null;
		optionalHppDb2LUWSchemaObjImpl = null;
		optionalHppDb2LUWSchemaObjInclude = null;
		optionalHppMSSqlSchemaObjMembers = null;
		optionalHppMSSqlSchemaObjImpl = null;
		optionalHppMSSqlSchemaObjInclude = null;
		optionalHppMySqlSchemaObjMembers = null;
		optionalHppMySqlSchemaObjImpl = null;
		optionalHppMySqlSchemaObjInclude = null;
		optionalHppOracleSchemaObjMembers = null;
		optionalHppOracleSchemaObjImpl = null;
		optionalHppOracleSchemaObjInclude = null;
		optionalHppPgSqlSchemaObjMembers = null;
		optionalHppPgSqlSchemaObjImpl = null;
		optionalHppPgSqlSchemaObjInclude = null;
		optionalHppRamSchemaObjMembers = null;
		optionalHppRamSchemaObjImpl = null;
		optionalHppRamSchemaObjInclude = null;
		optionalHppXMsgSchemaInclude = null;
		optionalHppXMsgSchemaFormatters = null;
		optionalHppXMsgClientSchemaInclude = null;
		optionalHppXMsgClientSchemaBody = null;
		optionalHppXMsgRqstSchemaBody = null;
		optionalHppXMsgRqstSchemaInclude = null;
		optionalHppXMsgRqstSchemaWireParsers = null;
		optionalHppXMsgRqstSchemaXsdSpec = null;
		optionalHppXMsgRqstSchemaXsdElementList = null;
		optionalHppXMsgRspnSchemaBody = null;
		optionalHppXMsgRspnSchemaInclude = null;
		optionalHppXMsgRspnSchemaWireParsers = null;
		optionalHppXMsgRspnSchemaXsdElementList = null;
		optionalHppXMsgRspnSchemaXsdSpec = null;
		optionalCsSchemaObjUsing = null;
		optionalCsSchemaObjInterface = null;
		optionalCsSchemaObjMembers = null;
		optionalCsSchemaObjImplementation = null;
		optionalCsDb2LUWSchemaObjMembers = null;
		optionalCsDb2LUWSchemaObjImpl = null;
		optionalCsDb2LUWSchemaObjUsing = null;
		optionalCsMSSqlSchemaObjMembers = null;
		optionalCsMSSqlSchemaObjImpl = null;
		optionalCsMSSqlSchemaObjUsing = null;
		optionalCsMySqlSchemaObjMembers = null;
		optionalCsMySqlSchemaObjImpl = null;
		optionalCsMySqlSchemaObjUsing = null;
		optionalCsOracleSchemaObjMembers = null;
		optionalCsOracleSchemaObjImpl = null;
		optionalCsOracleSchemaObjUsing = null;
		optionalCsPgSqlSchemaObjMembers = null;
		optionalCsPgSqlSchemaObjImpl = null;
		optionalCsPgSqlSchemaObjUsing = null;
		optionalCsRamSchemaObjMembers = null;
		optionalCsRamSchemaObjImpl = null;
		optionalCsRamSchemaObjUsing = null;
		optionalCsXMsgSchemaUsing = null;
		optionalCsXMsgSchemaFormatters = null;
		optionalCsXMsgClientSchemaUsing = null;
		optionalCsXMsgClientSchemaBody = null;
		optionalCsXMsgRqstSchemaBody = null;
		optionalCsXMsgRqstSchemaUsing = null;
		optionalCsXMsgRqstSchemaWireParsers = null;
		optionalCsXMsgRqstSchemaXsdSpec = null;
		optionalCsXMsgRqstSchemaXsdElementList = null;
		optionalCsXMsgRspnSchemaBody = null;
		optionalCsXMsgRspnSchemaUsing = null;
		optionalCsXMsgRspnSchemaWireParsers = null;
		optionalCsXMsgRspnSchemaXsdElementList = null;
		optionalCsXMsgRspnSchemaXsdSpec = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public long getRequiredMinorVersionId() {
		return( requiredMinorVersionId );
	}

	public void setRequiredMinorVersionId( long value ) {
		if( value < CFBamSchemaDefBuff.MINORVERSIONID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredMinorVersionId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.MINORVERSIONID_MIN_VALUE );
		}
		requiredMinorVersionId = value;
	}

	public String getRequiredName() {
		return( requiredName );
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	public String getOptionalDbName() {
		return( optionalDbName );
	}

	public void setOptionalDbName( String value ) {
		if( value == null ) {
			optionalDbName = null;
		}
		else if( value.length() > 12 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				12 );
		}
		else {
			optionalDbName = value;
		}
	}

	public String getOptionalShortName() {
		return( optionalShortName );
	}

	public void setOptionalShortName( String value ) {
		if( value == null ) {
			optionalShortName = null;
		}
		else if( value.length() > 16 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		else {
			optionalShortName = value;
		}
	}

	public String getOptionalLabel() {
		return( optionalLabel );
	}

	public void setOptionalLabel( String value ) {
		if( value == null ) {
			optionalLabel = null;
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		else {
			optionalLabel = value;
		}
	}

	public String getOptionalShortDescription() {
		return( optionalShortDescription );
	}

	public void setOptionalShortDescription( String value ) {
		if( value == null ) {
			optionalShortDescription = null;
		}
		else if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		else {
			optionalShortDescription = value;
		}
	}

	public String getOptionalDescription() {
		return( optionalDescription );
	}

	public void setOptionalDescription( String value ) {
		if( value == null ) {
			optionalDescription = null;
		}
		else if( value.length() > 1023 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		else {
			optionalDescription = value;
		}
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( optionalDefaultLicenseTenantId );
	}

	public void setOptionalDefaultLicenseTenantId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseTenantId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseTenantId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSETENANTID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseTenantId = value;
		}
	}

	public Long getOptionalDefaultLicenseId() {
		return( optionalDefaultLicenseId );
	}

	public void setOptionalDefaultLicenseId( Long value ) {
		if( value == null ) {
			optionalDefaultLicenseId = null;
		}
		else if( value < CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefaultLicenseId",
				1,
				"value",
				value,
				CFBamSchemaDefBuff.DEFAULTLICENSEID_MIN_VALUE );
		}
		else {
			optionalDefaultLicenseId = value;
		}
	}

	public String getRequiredCopyrightPeriod() {
		return( requiredCopyrightPeriod );
	}

	public void setRequiredCopyrightPeriod( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value" );
		}
		if( value.length() > 10 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value.length()",
				value.length(),
				10 );
		}
		requiredCopyrightPeriod = value;
	}

	public String getRequiredCopyrightHolder() {
		return( requiredCopyrightHolder );
	}

	public void setRequiredCopyrightHolder( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value" );
		}
		if( value.length() > 511 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value.length()",
				value.length(),
				511 );
		}
		requiredCopyrightHolder = value;
	}

	public String getRequiredAuthorEMail() {
		return( requiredAuthorEMail );
	}

	public void setRequiredAuthorEMail( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredAuthorEMail",
				1,
				"value" );
		}
		if( value.length() > 512 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredAuthorEMail",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredAuthorEMail = value;
	}

	public String getRequiredProjectURL() {
		return( requiredProjectURL );
	}

	public void setRequiredProjectURL( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredProjectURL",
				1,
				"value" );
		}
		if( value.length() > 1024 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredProjectURL",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredProjectURL = value;
	}

	public String getRequiredPublishURI() {
		return( requiredPublishURI );
	}

	public void setRequiredPublishURI( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredPublishURI",
				1,
				"value" );
		}
		if( value.length() > 512 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredPublishURI",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredPublishURI = value;
	}

	public String getOptionalJSchemaObjImport() {
		return( optionalJSchemaObjImport );
	}

	public void setOptionalJSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjImport = value;
		}
	}

	public String getOptionalJSchemaObjInterface() {
		return( optionalJSchemaObjInterface );
	}

	public void setOptionalJSchemaObjInterface( String value ) {
		if( value == null ) {
			optionalJSchemaObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjInterface = value;
		}
	}

	public String getOptionalJSchemaObjMembers() {
		return( optionalJSchemaObjMembers );
	}

	public void setOptionalJSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjMembers = value;
		}
	}

	public String getOptionalJSchemaObjImplementation() {
		return( optionalJSchemaObjImplementation );
	}

	public void setOptionalJSchemaObjImplementation( String value ) {
		if( value == null ) {
			optionalJSchemaObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSchemaObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSchemaObjImplementation = value;
		}
	}

	public String getOptionalJDb2LUWSchemaObjMembers() {
		return( optionalJDb2LUWSchemaObjMembers );
	}

	public void setOptionalJDb2LUWSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJDb2LUWSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWSchemaObjMembers = value;
		}
	}

	public String getOptionalJDb2LUWSchemaObjImpl() {
		return( optionalJDb2LUWSchemaObjImpl );
	}

	public void setOptionalJDb2LUWSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJDb2LUWSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWSchemaObjImpl = value;
		}
	}

	public String getOptionalJDb2LUWSchemaObjImport() {
		return( optionalJDb2LUWSchemaObjImport );
	}

	public void setOptionalJDb2LUWSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJDb2LUWSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWSchemaObjImport = value;
		}
	}

	public String getOptionalJMSSqlSchemaObjMembers() {
		return( optionalJMSSqlSchemaObjMembers );
	}

	public void setOptionalJMSSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJMSSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMSSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalJMSSqlSchemaObjImpl() {
		return( optionalJMSSqlSchemaObjImpl );
	}

	public void setOptionalJMSSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJMSSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMSSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalJMSSqlSchemaObjImport() {
		return( optionalJMSSqlSchemaObjImport );
	}

	public void setOptionalJMSSqlSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJMSSqlSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMSSqlSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlSchemaObjImport = value;
		}
	}

	public String getOptionalJMySqlSchemaObjMembers() {
		return( optionalJMySqlSchemaObjMembers );
	}

	public void setOptionalJMySqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJMySqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMySqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlSchemaObjMembers = value;
		}
	}

	public String getOptionalJMySqlSchemaObjImpl() {
		return( optionalJMySqlSchemaObjImpl );
	}

	public void setOptionalJMySqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJMySqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMySqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlSchemaObjImpl = value;
		}
	}

	public String getOptionalJMySqlSchemaObjImport() {
		return( optionalJMySqlSchemaObjImport );
	}

	public void setOptionalJMySqlSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJMySqlSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMySqlSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlSchemaObjImport = value;
		}
	}

	public String getOptionalJOracleSchemaObjMembers() {
		return( optionalJOracleSchemaObjMembers );
	}

	public void setOptionalJOracleSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJOracleSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJOracleSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleSchemaObjMembers = value;
		}
	}

	public String getOptionalJOracleSchemaObjImpl() {
		return( optionalJOracleSchemaObjImpl );
	}

	public void setOptionalJOracleSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJOracleSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJOracleSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleSchemaObjImpl = value;
		}
	}

	public String getOptionalJOracleSchemaObjImport() {
		return( optionalJOracleSchemaObjImport );
	}

	public void setOptionalJOracleSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJOracleSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJOracleSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleSchemaObjImport = value;
		}
	}

	public String getOptionalJPgSqlSchemaObjMembers() {
		return( optionalJPgSqlSchemaObjMembers );
	}

	public void setOptionalJPgSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJPgSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJPgSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalJPgSqlSchemaObjImpl() {
		return( optionalJPgSqlSchemaObjImpl );
	}

	public void setOptionalJPgSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJPgSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJPgSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalJPgSqlSchemaObjImport() {
		return( optionalJPgSqlSchemaObjImport );
	}

	public void setOptionalJPgSqlSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJPgSqlSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJPgSqlSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlSchemaObjImport = value;
		}
	}

	public String getOptionalJRamSchemaObjMembers() {
		return( optionalJRamSchemaObjMembers );
	}

	public void setOptionalJRamSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalJRamSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJRamSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamSchemaObjMembers = value;
		}
	}

	public String getOptionalJRamSchemaObjImpl() {
		return( optionalJRamSchemaObjImpl );
	}

	public void setOptionalJRamSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalJRamSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJRamSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamSchemaObjImpl = value;
		}
	}

	public String getOptionalJRamSchemaObjImport() {
		return( optionalJRamSchemaObjImport );
	}

	public void setOptionalJRamSchemaObjImport( String value ) {
		if( value == null ) {
			optionalJRamSchemaObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJRamSchemaObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamSchemaObjImport = value;
		}
	}

	public String getOptionalJXMsgSchemaImport() {
		return( optionalJXMsgSchemaImport );
	}

	public void setOptionalJXMsgSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgSchemaImport = value;
		}
	}

	public String getOptionalJXMsgSchemaFormatters() {
		return( optionalJXMsgSchemaFormatters );
	}

	public void setOptionalJXMsgSchemaFormatters( String value ) {
		if( value == null ) {
			optionalJXMsgSchemaFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgSchemaFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgSchemaFormatters = value;
		}
	}

	public String getOptionalJXMsgClientSchemaImport() {
		return( optionalJXMsgClientSchemaImport );
	}

	public void setOptionalJXMsgClientSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgClientSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientSchemaImport = value;
		}
	}

	public String getOptionalJXMsgClientSchemaBody() {
		return( optionalJXMsgClientSchemaBody );
	}

	public void setOptionalJXMsgClientSchemaBody( String value ) {
		if( value == null ) {
			optionalJXMsgClientSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientSchemaBody = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaBody() {
		return( optionalJXMsgRqstSchemaBody );
	}

	public void setOptionalJXMsgRqstSchemaBody( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaBody = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaImport() {
		return( optionalJXMsgRqstSchemaImport );
	}

	public void setOptionalJXMsgRqstSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaImport = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaWireParsers() {
		return( optionalJXMsgRqstSchemaWireParsers );
	}

	public void setOptionalJXMsgRqstSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaWireParsers = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdSpec() {
		return( optionalJXMsgRqstSchemaXsdSpec );
	}

	public void setOptionalJXMsgRqstSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaXsdSpec = value;
		}
	}

	public String getOptionalJXMsgRqstSchemaXsdElementList() {
		return( optionalJXMsgRqstSchemaXsdElementList );
	}

	public void setOptionalJXMsgRqstSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalJXMsgRqstSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstSchemaXsdElementList = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaBody() {
		return( optionalJXMsgRspnSchemaBody );
	}

	public void setOptionalJXMsgRspnSchemaBody( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaBody = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaImport() {
		return( optionalJXMsgRspnSchemaImport );
	}

	public void setOptionalJXMsgRspnSchemaImport( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaImport = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaWireParsers() {
		return( optionalJXMsgRspnSchemaWireParsers );
	}

	public void setOptionalJXMsgRspnSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaWireParsers = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdElementList() {
		return( optionalJXMsgRspnSchemaXsdElementList );
	}

	public void setOptionalJXMsgRspnSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaXsdElementList = value;
		}
	}

	public String getOptionalJXMsgRspnSchemaXsdSpec() {
		return( optionalJXMsgRspnSchemaXsdSpec );
	}

	public void setOptionalJXMsgRspnSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalJXMsgRspnSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnSchemaXsdSpec = value;
		}
	}

	public String getOptionalCppSchemaObjInclude() {
		return( optionalCppSchemaObjInclude );
	}

	public void setOptionalCppSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSchemaObjInclude = value;
		}
	}

	public String getOptionalCppSchemaObjInterface() {
		return( optionalCppSchemaObjInterface );
	}

	public void setOptionalCppSchemaObjInterface( String value ) {
		if( value == null ) {
			optionalCppSchemaObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSchemaObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSchemaObjInterface = value;
		}
	}

	public String getOptionalCppSchemaObjMembers() {
		return( optionalCppSchemaObjMembers );
	}

	public void setOptionalCppSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSchemaObjMembers = value;
		}
	}

	public String getOptionalCppSchemaObjImplementation() {
		return( optionalCppSchemaObjImplementation );
	}

	public void setOptionalCppSchemaObjImplementation( String value ) {
		if( value == null ) {
			optionalCppSchemaObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSchemaObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSchemaObjImplementation = value;
		}
	}

	public String getOptionalCppDb2LUWSchemaObjMembers() {
		return( optionalCppDb2LUWSchemaObjMembers );
	}

	public void setOptionalCppDb2LUWSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppDb2LUWSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppDb2LUWSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppDb2LUWSchemaObjMembers = value;
		}
	}

	public String getOptionalCppDb2LUWSchemaObjImpl() {
		return( optionalCppDb2LUWSchemaObjImpl );
	}

	public void setOptionalCppDb2LUWSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCppDb2LUWSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppDb2LUWSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppDb2LUWSchemaObjImpl = value;
		}
	}

	public String getOptionalCppDb2LUWSchemaObjInclude() {
		return( optionalCppDb2LUWSchemaObjInclude );
	}

	public void setOptionalCppDb2LUWSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppDb2LUWSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppDb2LUWSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppDb2LUWSchemaObjInclude = value;
		}
	}

	public String getOptionalCppMSSqlSchemaObjMembers() {
		return( optionalCppMSSqlSchemaObjMembers );
	}

	public void setOptionalCppMSSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppMSSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMSSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMSSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalCppMSSqlSchemaObjImpl() {
		return( optionalCppMSSqlSchemaObjImpl );
	}

	public void setOptionalCppMSSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCppMSSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMSSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMSSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalCppMSSqlSchemaObjInclude() {
		return( optionalCppMSSqlSchemaObjInclude );
	}

	public void setOptionalCppMSSqlSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppMSSqlSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMSSqlSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMSSqlSchemaObjInclude = value;
		}
	}

	public String getOptionalCppMySqlSchemaObjMembers() {
		return( optionalCppMySqlSchemaObjMembers );
	}

	public void setOptionalCppMySqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppMySqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMySqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMySqlSchemaObjMembers = value;
		}
	}

	public String getOptionalCppMySqlSchemaObjImpl() {
		return( optionalCppMySqlSchemaObjImpl );
	}

	public void setOptionalCppMySqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCppMySqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMySqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMySqlSchemaObjImpl = value;
		}
	}

	public String getOptionalCppMySqlSchemaObjInclude() {
		return( optionalCppMySqlSchemaObjInclude );
	}

	public void setOptionalCppMySqlSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppMySqlSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMySqlSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMySqlSchemaObjInclude = value;
		}
	}

	public String getOptionalCppOracleSchemaObjMembers() {
		return( optionalCppOracleSchemaObjMembers );
	}

	public void setOptionalCppOracleSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppOracleSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppOracleSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppOracleSchemaObjMembers = value;
		}
	}

	public String getOptionalCppOracleSchemaObjImpl() {
		return( optionalCppOracleSchemaObjImpl );
	}

	public void setOptionalCppOracleSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCppOracleSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppOracleSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppOracleSchemaObjImpl = value;
		}
	}

	public String getOptionalCppOracleSchemaObjInclude() {
		return( optionalCppOracleSchemaObjInclude );
	}

	public void setOptionalCppOracleSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppOracleSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppOracleSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppOracleSchemaObjInclude = value;
		}
	}

	public String getOptionalCppPgSqlSchemaObjMembers() {
		return( optionalCppPgSqlSchemaObjMembers );
	}

	public void setOptionalCppPgSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppPgSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppPgSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppPgSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalCppPgSqlSchemaObjImpl() {
		return( optionalCppPgSqlSchemaObjImpl );
	}

	public void setOptionalCppPgSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCppPgSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppPgSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppPgSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalCppPgSqlSchemaObjInclude() {
		return( optionalCppPgSqlSchemaObjInclude );
	}

	public void setOptionalCppPgSqlSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppPgSqlSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppPgSqlSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppPgSqlSchemaObjInclude = value;
		}
	}

	public String getOptionalCppRamSchemaObjMembers() {
		return( optionalCppRamSchemaObjMembers );
	}

	public void setOptionalCppRamSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCppRamSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppRamSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppRamSchemaObjMembers = value;
		}
	}

	public String getOptionalCppRamSchemaObjImpl() {
		return( optionalCppRamSchemaObjImpl );
	}

	public void setOptionalCppRamSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCppRamSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppRamSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppRamSchemaObjImpl = value;
		}
	}

	public String getOptionalCppRamSchemaObjInclude() {
		return( optionalCppRamSchemaObjInclude );
	}

	public void setOptionalCppRamSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalCppRamSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppRamSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppRamSchemaObjInclude = value;
		}
	}

	public String getOptionalCppXMsgSchemaInclude() {
		return( optionalCppXMsgSchemaInclude );
	}

	public void setOptionalCppXMsgSchemaInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgSchemaInclude = value;
		}
	}

	public String getOptionalCppXMsgSchemaFormatters() {
		return( optionalCppXMsgSchemaFormatters );
	}

	public void setOptionalCppXMsgSchemaFormatters( String value ) {
		if( value == null ) {
			optionalCppXMsgSchemaFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgSchemaFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgSchemaFormatters = value;
		}
	}

	public String getOptionalCppXMsgClientSchemaInclude() {
		return( optionalCppXMsgClientSchemaInclude );
	}

	public void setOptionalCppXMsgClientSchemaInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgClientSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgClientSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgClientSchemaInclude = value;
		}
	}

	public String getOptionalCppXMsgClientSchemaBody() {
		return( optionalCppXMsgClientSchemaBody );
	}

	public void setOptionalCppXMsgClientSchemaBody( String value ) {
		if( value == null ) {
			optionalCppXMsgClientSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgClientSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgClientSchemaBody = value;
		}
	}

	public String getOptionalCppXMsgRqstSchemaBody() {
		return( optionalCppXMsgRqstSchemaBody );
	}

	public void setOptionalCppXMsgRqstSchemaBody( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstSchemaBody = value;
		}
	}

	public String getOptionalCppXMsgRqstSchemaInclude() {
		return( optionalCppXMsgRqstSchemaInclude );
	}

	public void setOptionalCppXMsgRqstSchemaInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstSchemaInclude = value;
		}
	}

	public String getOptionalCppXMsgRqstSchemaWireParsers() {
		return( optionalCppXMsgRqstSchemaWireParsers );
	}

	public void setOptionalCppXMsgRqstSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstSchemaWireParsers = value;
		}
	}

	public String getOptionalCppXMsgRqstSchemaXsdSpec() {
		return( optionalCppXMsgRqstSchemaXsdSpec );
	}

	public void setOptionalCppXMsgRqstSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstSchemaXsdSpec = value;
		}
	}

	public String getOptionalCppXMsgRqstSchemaXsdElementList() {
		return( optionalCppXMsgRqstSchemaXsdElementList );
	}

	public void setOptionalCppXMsgRqstSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstSchemaXsdElementList = value;
		}
	}

	public String getOptionalCppXMsgRspnSchemaBody() {
		return( optionalCppXMsgRspnSchemaBody );
	}

	public void setOptionalCppXMsgRspnSchemaBody( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnSchemaBody = value;
		}
	}

	public String getOptionalCppXMsgRspnSchemaInclude() {
		return( optionalCppXMsgRspnSchemaInclude );
	}

	public void setOptionalCppXMsgRspnSchemaInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnSchemaInclude = value;
		}
	}

	public String getOptionalCppXMsgRspnSchemaWireParsers() {
		return( optionalCppXMsgRspnSchemaWireParsers );
	}

	public void setOptionalCppXMsgRspnSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnSchemaWireParsers = value;
		}
	}

	public String getOptionalCppXMsgRspnSchemaXsdElementList() {
		return( optionalCppXMsgRspnSchemaXsdElementList );
	}

	public void setOptionalCppXMsgRspnSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnSchemaXsdElementList = value;
		}
	}

	public String getOptionalCppXMsgRspnSchemaXsdSpec() {
		return( optionalCppXMsgRspnSchemaXsdSpec );
	}

	public void setOptionalCppXMsgRspnSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnSchemaXsdSpec = value;
		}
	}

	public String getOptionalHppSchemaObjInclude() {
		return( optionalHppSchemaObjInclude );
	}

	public void setOptionalHppSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSchemaObjInclude = value;
		}
	}

	public String getOptionalHppSchemaObjInterface() {
		return( optionalHppSchemaObjInterface );
	}

	public void setOptionalHppSchemaObjInterface( String value ) {
		if( value == null ) {
			optionalHppSchemaObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSchemaObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSchemaObjInterface = value;
		}
	}

	public String getOptionalHppSchemaObjMembers() {
		return( optionalHppSchemaObjMembers );
	}

	public void setOptionalHppSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSchemaObjMembers = value;
		}
	}

	public String getOptionalHppSchemaObjImplementation() {
		return( optionalHppSchemaObjImplementation );
	}

	public void setOptionalHppSchemaObjImplementation( String value ) {
		if( value == null ) {
			optionalHppSchemaObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSchemaObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSchemaObjImplementation = value;
		}
	}

	public String getOptionalHppDb2LUWSchemaObjMembers() {
		return( optionalHppDb2LUWSchemaObjMembers );
	}

	public void setOptionalHppDb2LUWSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppDb2LUWSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppDb2LUWSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppDb2LUWSchemaObjMembers = value;
		}
	}

	public String getOptionalHppDb2LUWSchemaObjImpl() {
		return( optionalHppDb2LUWSchemaObjImpl );
	}

	public void setOptionalHppDb2LUWSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalHppDb2LUWSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppDb2LUWSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppDb2LUWSchemaObjImpl = value;
		}
	}

	public String getOptionalHppDb2LUWSchemaObjInclude() {
		return( optionalHppDb2LUWSchemaObjInclude );
	}

	public void setOptionalHppDb2LUWSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppDb2LUWSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppDb2LUWSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppDb2LUWSchemaObjInclude = value;
		}
	}

	public String getOptionalHppMSSqlSchemaObjMembers() {
		return( optionalHppMSSqlSchemaObjMembers );
	}

	public void setOptionalHppMSSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppMSSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMSSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMSSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalHppMSSqlSchemaObjImpl() {
		return( optionalHppMSSqlSchemaObjImpl );
	}

	public void setOptionalHppMSSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalHppMSSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMSSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMSSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalHppMSSqlSchemaObjInclude() {
		return( optionalHppMSSqlSchemaObjInclude );
	}

	public void setOptionalHppMSSqlSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppMSSqlSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMSSqlSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMSSqlSchemaObjInclude = value;
		}
	}

	public String getOptionalHppMySqlSchemaObjMembers() {
		return( optionalHppMySqlSchemaObjMembers );
	}

	public void setOptionalHppMySqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppMySqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMySqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMySqlSchemaObjMembers = value;
		}
	}

	public String getOptionalHppMySqlSchemaObjImpl() {
		return( optionalHppMySqlSchemaObjImpl );
	}

	public void setOptionalHppMySqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalHppMySqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMySqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMySqlSchemaObjImpl = value;
		}
	}

	public String getOptionalHppMySqlSchemaObjInclude() {
		return( optionalHppMySqlSchemaObjInclude );
	}

	public void setOptionalHppMySqlSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppMySqlSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMySqlSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMySqlSchemaObjInclude = value;
		}
	}

	public String getOptionalHppOracleSchemaObjMembers() {
		return( optionalHppOracleSchemaObjMembers );
	}

	public void setOptionalHppOracleSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppOracleSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppOracleSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppOracleSchemaObjMembers = value;
		}
	}

	public String getOptionalHppOracleSchemaObjImpl() {
		return( optionalHppOracleSchemaObjImpl );
	}

	public void setOptionalHppOracleSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalHppOracleSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppOracleSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppOracleSchemaObjImpl = value;
		}
	}

	public String getOptionalHppOracleSchemaObjInclude() {
		return( optionalHppOracleSchemaObjInclude );
	}

	public void setOptionalHppOracleSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppOracleSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppOracleSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppOracleSchemaObjInclude = value;
		}
	}

	public String getOptionalHppPgSqlSchemaObjMembers() {
		return( optionalHppPgSqlSchemaObjMembers );
	}

	public void setOptionalHppPgSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppPgSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppPgSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppPgSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalHppPgSqlSchemaObjImpl() {
		return( optionalHppPgSqlSchemaObjImpl );
	}

	public void setOptionalHppPgSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalHppPgSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppPgSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppPgSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalHppPgSqlSchemaObjInclude() {
		return( optionalHppPgSqlSchemaObjInclude );
	}

	public void setOptionalHppPgSqlSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppPgSqlSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppPgSqlSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppPgSqlSchemaObjInclude = value;
		}
	}

	public String getOptionalHppRamSchemaObjMembers() {
		return( optionalHppRamSchemaObjMembers );
	}

	public void setOptionalHppRamSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalHppRamSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppRamSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppRamSchemaObjMembers = value;
		}
	}

	public String getOptionalHppRamSchemaObjImpl() {
		return( optionalHppRamSchemaObjImpl );
	}

	public void setOptionalHppRamSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalHppRamSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppRamSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppRamSchemaObjImpl = value;
		}
	}

	public String getOptionalHppRamSchemaObjInclude() {
		return( optionalHppRamSchemaObjInclude );
	}

	public void setOptionalHppRamSchemaObjInclude( String value ) {
		if( value == null ) {
			optionalHppRamSchemaObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppRamSchemaObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppRamSchemaObjInclude = value;
		}
	}

	public String getOptionalHppXMsgSchemaInclude() {
		return( optionalHppXMsgSchemaInclude );
	}

	public void setOptionalHppXMsgSchemaInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgSchemaInclude = value;
		}
	}

	public String getOptionalHppXMsgSchemaFormatters() {
		return( optionalHppXMsgSchemaFormatters );
	}

	public void setOptionalHppXMsgSchemaFormatters( String value ) {
		if( value == null ) {
			optionalHppXMsgSchemaFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgSchemaFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgSchemaFormatters = value;
		}
	}

	public String getOptionalHppXMsgClientSchemaInclude() {
		return( optionalHppXMsgClientSchemaInclude );
	}

	public void setOptionalHppXMsgClientSchemaInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgClientSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgClientSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgClientSchemaInclude = value;
		}
	}

	public String getOptionalHppXMsgClientSchemaBody() {
		return( optionalHppXMsgClientSchemaBody );
	}

	public void setOptionalHppXMsgClientSchemaBody( String value ) {
		if( value == null ) {
			optionalHppXMsgClientSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgClientSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgClientSchemaBody = value;
		}
	}

	public String getOptionalHppXMsgRqstSchemaBody() {
		return( optionalHppXMsgRqstSchemaBody );
	}

	public void setOptionalHppXMsgRqstSchemaBody( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstSchemaBody = value;
		}
	}

	public String getOptionalHppXMsgRqstSchemaInclude() {
		return( optionalHppXMsgRqstSchemaInclude );
	}

	public void setOptionalHppXMsgRqstSchemaInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstSchemaInclude = value;
		}
	}

	public String getOptionalHppXMsgRqstSchemaWireParsers() {
		return( optionalHppXMsgRqstSchemaWireParsers );
	}

	public void setOptionalHppXMsgRqstSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstSchemaWireParsers = value;
		}
	}

	public String getOptionalHppXMsgRqstSchemaXsdSpec() {
		return( optionalHppXMsgRqstSchemaXsdSpec );
	}

	public void setOptionalHppXMsgRqstSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstSchemaXsdSpec = value;
		}
	}

	public String getOptionalHppXMsgRqstSchemaXsdElementList() {
		return( optionalHppXMsgRqstSchemaXsdElementList );
	}

	public void setOptionalHppXMsgRqstSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstSchemaXsdElementList = value;
		}
	}

	public String getOptionalHppXMsgRspnSchemaBody() {
		return( optionalHppXMsgRspnSchemaBody );
	}

	public void setOptionalHppXMsgRspnSchemaBody( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnSchemaBody = value;
		}
	}

	public String getOptionalHppXMsgRspnSchemaInclude() {
		return( optionalHppXMsgRspnSchemaInclude );
	}

	public void setOptionalHppXMsgRspnSchemaInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnSchemaInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnSchemaInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnSchemaInclude = value;
		}
	}

	public String getOptionalHppXMsgRspnSchemaWireParsers() {
		return( optionalHppXMsgRspnSchemaWireParsers );
	}

	public void setOptionalHppXMsgRspnSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnSchemaWireParsers = value;
		}
	}

	public String getOptionalHppXMsgRspnSchemaXsdElementList() {
		return( optionalHppXMsgRspnSchemaXsdElementList );
	}

	public void setOptionalHppXMsgRspnSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnSchemaXsdElementList = value;
		}
	}

	public String getOptionalHppXMsgRspnSchemaXsdSpec() {
		return( optionalHppXMsgRspnSchemaXsdSpec );
	}

	public void setOptionalHppXMsgRspnSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnSchemaXsdSpec = value;
		}
	}

	public String getOptionalCsSchemaObjUsing() {
		return( optionalCsSchemaObjUsing );
	}

	public void setOptionalCsSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSchemaObjUsing = value;
		}
	}

	public String getOptionalCsSchemaObjInterface() {
		return( optionalCsSchemaObjInterface );
	}

	public void setOptionalCsSchemaObjInterface( String value ) {
		if( value == null ) {
			optionalCsSchemaObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSchemaObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSchemaObjInterface = value;
		}
	}

	public String getOptionalCsSchemaObjMembers() {
		return( optionalCsSchemaObjMembers );
	}

	public void setOptionalCsSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSchemaObjMembers = value;
		}
	}

	public String getOptionalCsSchemaObjImplementation() {
		return( optionalCsSchemaObjImplementation );
	}

	public void setOptionalCsSchemaObjImplementation( String value ) {
		if( value == null ) {
			optionalCsSchemaObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSchemaObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSchemaObjImplementation = value;
		}
	}

	public String getOptionalCsDb2LUWSchemaObjMembers() {
		return( optionalCsDb2LUWSchemaObjMembers );
	}

	public void setOptionalCsDb2LUWSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsDb2LUWSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsDb2LUWSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsDb2LUWSchemaObjMembers = value;
		}
	}

	public String getOptionalCsDb2LUWSchemaObjImpl() {
		return( optionalCsDb2LUWSchemaObjImpl );
	}

	public void setOptionalCsDb2LUWSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCsDb2LUWSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsDb2LUWSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsDb2LUWSchemaObjImpl = value;
		}
	}

	public String getOptionalCsDb2LUWSchemaObjUsing() {
		return( optionalCsDb2LUWSchemaObjUsing );
	}

	public void setOptionalCsDb2LUWSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsDb2LUWSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsDb2LUWSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsDb2LUWSchemaObjUsing = value;
		}
	}

	public String getOptionalCsMSSqlSchemaObjMembers() {
		return( optionalCsMSSqlSchemaObjMembers );
	}

	public void setOptionalCsMSSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsMSSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMSSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMSSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalCsMSSqlSchemaObjImpl() {
		return( optionalCsMSSqlSchemaObjImpl );
	}

	public void setOptionalCsMSSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCsMSSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMSSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMSSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalCsMSSqlSchemaObjUsing() {
		return( optionalCsMSSqlSchemaObjUsing );
	}

	public void setOptionalCsMSSqlSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsMSSqlSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMSSqlSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMSSqlSchemaObjUsing = value;
		}
	}

	public String getOptionalCsMySqlSchemaObjMembers() {
		return( optionalCsMySqlSchemaObjMembers );
	}

	public void setOptionalCsMySqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsMySqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMySqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMySqlSchemaObjMembers = value;
		}
	}

	public String getOptionalCsMySqlSchemaObjImpl() {
		return( optionalCsMySqlSchemaObjImpl );
	}

	public void setOptionalCsMySqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCsMySqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMySqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMySqlSchemaObjImpl = value;
		}
	}

	public String getOptionalCsMySqlSchemaObjUsing() {
		return( optionalCsMySqlSchemaObjUsing );
	}

	public void setOptionalCsMySqlSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsMySqlSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMySqlSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMySqlSchemaObjUsing = value;
		}
	}

	public String getOptionalCsOracleSchemaObjMembers() {
		return( optionalCsOracleSchemaObjMembers );
	}

	public void setOptionalCsOracleSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsOracleSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsOracleSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsOracleSchemaObjMembers = value;
		}
	}

	public String getOptionalCsOracleSchemaObjImpl() {
		return( optionalCsOracleSchemaObjImpl );
	}

	public void setOptionalCsOracleSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCsOracleSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsOracleSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsOracleSchemaObjImpl = value;
		}
	}

	public String getOptionalCsOracleSchemaObjUsing() {
		return( optionalCsOracleSchemaObjUsing );
	}

	public void setOptionalCsOracleSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsOracleSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsOracleSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsOracleSchemaObjUsing = value;
		}
	}

	public String getOptionalCsPgSqlSchemaObjMembers() {
		return( optionalCsPgSqlSchemaObjMembers );
	}

	public void setOptionalCsPgSqlSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsPgSqlSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsPgSqlSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsPgSqlSchemaObjMembers = value;
		}
	}

	public String getOptionalCsPgSqlSchemaObjImpl() {
		return( optionalCsPgSqlSchemaObjImpl );
	}

	public void setOptionalCsPgSqlSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCsPgSqlSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsPgSqlSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsPgSqlSchemaObjImpl = value;
		}
	}

	public String getOptionalCsPgSqlSchemaObjUsing() {
		return( optionalCsPgSqlSchemaObjUsing );
	}

	public void setOptionalCsPgSqlSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsPgSqlSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsPgSqlSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsPgSqlSchemaObjUsing = value;
		}
	}

	public String getOptionalCsRamSchemaObjMembers() {
		return( optionalCsRamSchemaObjMembers );
	}

	public void setOptionalCsRamSchemaObjMembers( String value ) {
		if( value == null ) {
			optionalCsRamSchemaObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsRamSchemaObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsRamSchemaObjMembers = value;
		}
	}

	public String getOptionalCsRamSchemaObjImpl() {
		return( optionalCsRamSchemaObjImpl );
	}

	public void setOptionalCsRamSchemaObjImpl( String value ) {
		if( value == null ) {
			optionalCsRamSchemaObjImpl = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsRamSchemaObjImpl",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsRamSchemaObjImpl = value;
		}
	}

	public String getOptionalCsRamSchemaObjUsing() {
		return( optionalCsRamSchemaObjUsing );
	}

	public void setOptionalCsRamSchemaObjUsing( String value ) {
		if( value == null ) {
			optionalCsRamSchemaObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsRamSchemaObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsRamSchemaObjUsing = value;
		}
	}

	public String getOptionalCsXMsgSchemaUsing() {
		return( optionalCsXMsgSchemaUsing );
	}

	public void setOptionalCsXMsgSchemaUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgSchemaUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgSchemaUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgSchemaUsing = value;
		}
	}

	public String getOptionalCsXMsgSchemaFormatters() {
		return( optionalCsXMsgSchemaFormatters );
	}

	public void setOptionalCsXMsgSchemaFormatters( String value ) {
		if( value == null ) {
			optionalCsXMsgSchemaFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgSchemaFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgSchemaFormatters = value;
		}
	}

	public String getOptionalCsXMsgClientSchemaUsing() {
		return( optionalCsXMsgClientSchemaUsing );
	}

	public void setOptionalCsXMsgClientSchemaUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgClientSchemaUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgClientSchemaUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgClientSchemaUsing = value;
		}
	}

	public String getOptionalCsXMsgClientSchemaBody() {
		return( optionalCsXMsgClientSchemaBody );
	}

	public void setOptionalCsXMsgClientSchemaBody( String value ) {
		if( value == null ) {
			optionalCsXMsgClientSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgClientSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgClientSchemaBody = value;
		}
	}

	public String getOptionalCsXMsgRqstSchemaBody() {
		return( optionalCsXMsgRqstSchemaBody );
	}

	public void setOptionalCsXMsgRqstSchemaBody( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstSchemaBody = value;
		}
	}

	public String getOptionalCsXMsgRqstSchemaUsing() {
		return( optionalCsXMsgRqstSchemaUsing );
	}

	public void setOptionalCsXMsgRqstSchemaUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstSchemaUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstSchemaUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstSchemaUsing = value;
		}
	}

	public String getOptionalCsXMsgRqstSchemaWireParsers() {
		return( optionalCsXMsgRqstSchemaWireParsers );
	}

	public void setOptionalCsXMsgRqstSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstSchemaWireParsers = value;
		}
	}

	public String getOptionalCsXMsgRqstSchemaXsdSpec() {
		return( optionalCsXMsgRqstSchemaXsdSpec );
	}

	public void setOptionalCsXMsgRqstSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstSchemaXsdSpec = value;
		}
	}

	public String getOptionalCsXMsgRqstSchemaXsdElementList() {
		return( optionalCsXMsgRqstSchemaXsdElementList );
	}

	public void setOptionalCsXMsgRqstSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstSchemaXsdElementList = value;
		}
	}

	public String getOptionalCsXMsgRspnSchemaBody() {
		return( optionalCsXMsgRspnSchemaBody );
	}

	public void setOptionalCsXMsgRspnSchemaBody( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnSchemaBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnSchemaBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnSchemaBody = value;
		}
	}

	public String getOptionalCsXMsgRspnSchemaUsing() {
		return( optionalCsXMsgRspnSchemaUsing );
	}

	public void setOptionalCsXMsgRspnSchemaUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnSchemaUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnSchemaUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnSchemaUsing = value;
		}
	}

	public String getOptionalCsXMsgRspnSchemaWireParsers() {
		return( optionalCsXMsgRspnSchemaWireParsers );
	}

	public void setOptionalCsXMsgRspnSchemaWireParsers( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnSchemaWireParsers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnSchemaWireParsers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnSchemaWireParsers = value;
		}
	}

	public String getOptionalCsXMsgRspnSchemaXsdElementList() {
		return( optionalCsXMsgRspnSchemaXsdElementList );
	}

	public void setOptionalCsXMsgRspnSchemaXsdElementList( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnSchemaXsdElementList = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnSchemaXsdElementList",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnSchemaXsdElementList = value;
		}
	}

	public String getOptionalCsXMsgRspnSchemaXsdSpec() {
		return( optionalCsXMsgRspnSchemaXsdSpec );
	}

	public void setOptionalCsXMsgRspnSchemaXsdSpec( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnSchemaXsdSpec = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnSchemaXsdSpec",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnSchemaXsdSpec = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredMinorVersionId() != rhs.getRequiredMinorVersionId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
				return( false );
			}
			if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
				return( false );
			}
			if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
				return( false );
			}
			if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					if( ! getOptionalJSchemaObjImport().equals( rhs.getOptionalJSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					if( ! getOptionalJSchemaObjInterface().equals( rhs.getOptionalJSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					if( ! getOptionalJSchemaObjMembers().equals( rhs.getOptionalJSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					if( ! getOptionalJSchemaObjImplementation().equals( rhs.getOptionalJSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjMembers().equals( rhs.getOptionalJDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImpl().equals( rhs.getOptionalJDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImport().equals( rhs.getOptionalJDb2LUWSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMSSqlSchemaObjMembers().equals( rhs.getOptionalJMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImpl().equals( rhs.getOptionalJMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImport().equals( rhs.getOptionalJMSSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMySqlSchemaObjMembers().equals( rhs.getOptionalJMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMySqlSchemaObjImpl().equals( rhs.getOptionalJMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					if( ! getOptionalJMySqlSchemaObjImport().equals( rhs.getOptionalJMySqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					if( ! getOptionalJOracleSchemaObjMembers().equals( rhs.getOptionalJOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					if( ! getOptionalJOracleSchemaObjImpl().equals( rhs.getOptionalJOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					if( ! getOptionalJOracleSchemaObjImport().equals( rhs.getOptionalJOracleSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJPgSqlSchemaObjMembers().equals( rhs.getOptionalJPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImpl().equals( rhs.getOptionalJPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImport().equals( rhs.getOptionalJPgSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					if( ! getOptionalJRamSchemaObjMembers().equals( rhs.getOptionalJRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					if( ! getOptionalJRamSchemaObjImpl().equals( rhs.getOptionalJRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					if( ! getOptionalJRamSchemaObjImport().equals( rhs.getOptionalJRamSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					if( ! getOptionalJXMsgSchemaImport().equals( rhs.getOptionalJXMsgSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					if( ! getOptionalJXMsgSchemaFormatters().equals( rhs.getOptionalJXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					if( ! getOptionalJXMsgClientSchemaImport().equals( rhs.getOptionalJXMsgClientSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					if( ! getOptionalJXMsgClientSchemaBody().equals( rhs.getOptionalJXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalJXMsgRqstSchemaBody().equals( rhs.getOptionalJXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					if( ! getOptionalJXMsgRqstSchemaImport().equals( rhs.getOptionalJXMsgRqstSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRqstSchemaWireParsers().equals( rhs.getOptionalJXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalJXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalJXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalJXMsgRspnSchemaBody().equals( rhs.getOptionalJXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					if( ! getOptionalJXMsgRspnSchemaImport().equals( rhs.getOptionalJXMsgRspnSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRspnSchemaWireParsers().equals( rhs.getOptionalJXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalJXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalJXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					if( ! getOptionalCppSchemaObjInclude().equals( rhs.getOptionalCppSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjInterface() != null ) {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					if( ! getOptionalCppSchemaObjInterface().equals( rhs.getOptionalCppSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					if( ! getOptionalCppSchemaObjMembers().equals( rhs.getOptionalCppSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					if( ! getOptionalCppSchemaObjImplementation().equals( rhs.getOptionalCppSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalCppDb2LUWSchemaObjMembers().equals( rhs.getOptionalCppDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalCppDb2LUWSchemaObjImpl().equals( rhs.getOptionalCppDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					if( ! getOptionalCppDb2LUWSchemaObjInclude().equals( rhs.getOptionalCppDb2LUWSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCppMSSqlSchemaObjMembers().equals( rhs.getOptionalCppMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCppMSSqlSchemaObjImpl().equals( rhs.getOptionalCppMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					if( ! getOptionalCppMSSqlSchemaObjInclude().equals( rhs.getOptionalCppMSSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalCppMySqlSchemaObjMembers().equals( rhs.getOptionalCppMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalCppMySqlSchemaObjImpl().equals( rhs.getOptionalCppMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					if( ! getOptionalCppMySqlSchemaObjInclude().equals( rhs.getOptionalCppMySqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					if( ! getOptionalCppOracleSchemaObjMembers().equals( rhs.getOptionalCppOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					if( ! getOptionalCppOracleSchemaObjImpl().equals( rhs.getOptionalCppOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					if( ! getOptionalCppOracleSchemaObjInclude().equals( rhs.getOptionalCppOracleSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCppPgSqlSchemaObjMembers().equals( rhs.getOptionalCppPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCppPgSqlSchemaObjImpl().equals( rhs.getOptionalCppPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					if( ! getOptionalCppPgSqlSchemaObjInclude().equals( rhs.getOptionalCppPgSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					if( ! getOptionalCppRamSchemaObjMembers().equals( rhs.getOptionalCppRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					if( ! getOptionalCppRamSchemaObjImpl().equals( rhs.getOptionalCppRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					if( ! getOptionalCppRamSchemaObjInclude().equals( rhs.getOptionalCppRamSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgSchemaInclude().equals( rhs.getOptionalCppXMsgSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					if( ! getOptionalCppXMsgSchemaFormatters().equals( rhs.getOptionalCppXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgClientSchemaInclude().equals( rhs.getOptionalCppXMsgClientSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					if( ! getOptionalCppXMsgClientSchemaBody().equals( rhs.getOptionalCppXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaBody().equals( rhs.getOptionalCppXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaInclude().equals( rhs.getOptionalCppXMsgRqstSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaWireParsers().equals( rhs.getOptionalCppXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaBody().equals( rhs.getOptionalCppXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaInclude().equals( rhs.getOptionalCppXMsgRspnSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaWireParsers().equals( rhs.getOptionalCppXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					if( ! getOptionalHppSchemaObjInclude().equals( rhs.getOptionalHppSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjInterface() != null ) {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					if( ! getOptionalHppSchemaObjInterface().equals( rhs.getOptionalHppSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					if( ! getOptionalHppSchemaObjMembers().equals( rhs.getOptionalHppSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					if( ! getOptionalHppSchemaObjImplementation().equals( rhs.getOptionalHppSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalHppDb2LUWSchemaObjMembers().equals( rhs.getOptionalHppDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalHppDb2LUWSchemaObjImpl().equals( rhs.getOptionalHppDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					if( ! getOptionalHppDb2LUWSchemaObjInclude().equals( rhs.getOptionalHppDb2LUWSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalHppMSSqlSchemaObjMembers().equals( rhs.getOptionalHppMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalHppMSSqlSchemaObjImpl().equals( rhs.getOptionalHppMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					if( ! getOptionalHppMSSqlSchemaObjInclude().equals( rhs.getOptionalHppMSSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalHppMySqlSchemaObjMembers().equals( rhs.getOptionalHppMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalHppMySqlSchemaObjImpl().equals( rhs.getOptionalHppMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					if( ! getOptionalHppMySqlSchemaObjInclude().equals( rhs.getOptionalHppMySqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					if( ! getOptionalHppOracleSchemaObjMembers().equals( rhs.getOptionalHppOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					if( ! getOptionalHppOracleSchemaObjImpl().equals( rhs.getOptionalHppOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					if( ! getOptionalHppOracleSchemaObjInclude().equals( rhs.getOptionalHppOracleSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalHppPgSqlSchemaObjMembers().equals( rhs.getOptionalHppPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalHppPgSqlSchemaObjImpl().equals( rhs.getOptionalHppPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					if( ! getOptionalHppPgSqlSchemaObjInclude().equals( rhs.getOptionalHppPgSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					if( ! getOptionalHppRamSchemaObjMembers().equals( rhs.getOptionalHppRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					if( ! getOptionalHppRamSchemaObjImpl().equals( rhs.getOptionalHppRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					if( ! getOptionalHppRamSchemaObjInclude().equals( rhs.getOptionalHppRamSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgSchemaInclude().equals( rhs.getOptionalHppXMsgSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					if( ! getOptionalHppXMsgSchemaFormatters().equals( rhs.getOptionalHppXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgClientSchemaInclude().equals( rhs.getOptionalHppXMsgClientSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					if( ! getOptionalHppXMsgClientSchemaBody().equals( rhs.getOptionalHppXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaBody().equals( rhs.getOptionalHppXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaInclude().equals( rhs.getOptionalHppXMsgRqstSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaWireParsers().equals( rhs.getOptionalHppXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaBody().equals( rhs.getOptionalHppXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaInclude().equals( rhs.getOptionalHppXMsgRspnSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaWireParsers().equals( rhs.getOptionalHppXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					if( ! getOptionalCsSchemaObjUsing().equals( rhs.getOptionalCsSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjInterface() != null ) {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					if( ! getOptionalCsSchemaObjInterface().equals( rhs.getOptionalCsSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					if( ! getOptionalCsSchemaObjMembers().equals( rhs.getOptionalCsSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					if( ! getOptionalCsSchemaObjImplementation().equals( rhs.getOptionalCsSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalCsDb2LUWSchemaObjMembers().equals( rhs.getOptionalCsDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalCsDb2LUWSchemaObjImpl().equals( rhs.getOptionalCsDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					if( ! getOptionalCsDb2LUWSchemaObjUsing().equals( rhs.getOptionalCsDb2LUWSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCsMSSqlSchemaObjMembers().equals( rhs.getOptionalCsMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCsMSSqlSchemaObjImpl().equals( rhs.getOptionalCsMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					if( ! getOptionalCsMSSqlSchemaObjUsing().equals( rhs.getOptionalCsMSSqlSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalCsMySqlSchemaObjMembers().equals( rhs.getOptionalCsMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalCsMySqlSchemaObjImpl().equals( rhs.getOptionalCsMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					if( ! getOptionalCsMySqlSchemaObjUsing().equals( rhs.getOptionalCsMySqlSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					if( ! getOptionalCsOracleSchemaObjMembers().equals( rhs.getOptionalCsOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					if( ! getOptionalCsOracleSchemaObjImpl().equals( rhs.getOptionalCsOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					if( ! getOptionalCsOracleSchemaObjUsing().equals( rhs.getOptionalCsOracleSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCsPgSqlSchemaObjMembers().equals( rhs.getOptionalCsPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCsPgSqlSchemaObjImpl().equals( rhs.getOptionalCsPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					if( ! getOptionalCsPgSqlSchemaObjUsing().equals( rhs.getOptionalCsPgSqlSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					if( ! getOptionalCsRamSchemaObjMembers().equals( rhs.getOptionalCsRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					if( ! getOptionalCsRamSchemaObjImpl().equals( rhs.getOptionalCsRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					if( ! getOptionalCsRamSchemaObjUsing().equals( rhs.getOptionalCsRamSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgSchemaUsing().equals( rhs.getOptionalCsXMsgSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					if( ! getOptionalCsXMsgSchemaFormatters().equals( rhs.getOptionalCsXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgClientSchemaUsing().equals( rhs.getOptionalCsXMsgClientSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					if( ! getOptionalCsXMsgClientSchemaBody().equals( rhs.getOptionalCsXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaBody().equals( rhs.getOptionalCsXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaUsing().equals( rhs.getOptionalCsXMsgRqstSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaWireParsers().equals( rhs.getOptionalCsXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaBody().equals( rhs.getOptionalCsXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaUsing().equals( rhs.getOptionalCsXMsgRspnSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaWireParsers().equals( rhs.getOptionalCsXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefHBuff ) {
			CFBamSchemaDefHBuff rhs = (CFBamSchemaDefHBuff)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			if( getRequiredMinorVersionId() != rhs.getRequiredMinorVersionId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
				return( false );
			}
			if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
				return( false );
			}
			if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
				return( false );
			}
			if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					if( ! getOptionalJSchemaObjImport().equals( rhs.getOptionalJSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					if( ! getOptionalJSchemaObjInterface().equals( rhs.getOptionalJSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					if( ! getOptionalJSchemaObjMembers().equals( rhs.getOptionalJSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					if( ! getOptionalJSchemaObjImplementation().equals( rhs.getOptionalJSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjMembers().equals( rhs.getOptionalJDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImpl().equals( rhs.getOptionalJDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					if( ! getOptionalJDb2LUWSchemaObjImport().equals( rhs.getOptionalJDb2LUWSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMSSqlSchemaObjMembers().equals( rhs.getOptionalJMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImpl().equals( rhs.getOptionalJMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					if( ! getOptionalJMSSqlSchemaObjImport().equals( rhs.getOptionalJMSSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalJMySqlSchemaObjMembers().equals( rhs.getOptionalJMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalJMySqlSchemaObjImpl().equals( rhs.getOptionalJMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					if( ! getOptionalJMySqlSchemaObjImport().equals( rhs.getOptionalJMySqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					if( ! getOptionalJOracleSchemaObjMembers().equals( rhs.getOptionalJOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					if( ! getOptionalJOracleSchemaObjImpl().equals( rhs.getOptionalJOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					if( ! getOptionalJOracleSchemaObjImport().equals( rhs.getOptionalJOracleSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalJPgSqlSchemaObjMembers().equals( rhs.getOptionalJPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImpl().equals( rhs.getOptionalJPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					if( ! getOptionalJPgSqlSchemaObjImport().equals( rhs.getOptionalJPgSqlSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					if( ! getOptionalJRamSchemaObjMembers().equals( rhs.getOptionalJRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					if( ! getOptionalJRamSchemaObjImpl().equals( rhs.getOptionalJRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					if( ! getOptionalJRamSchemaObjImport().equals( rhs.getOptionalJRamSchemaObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					if( ! getOptionalJXMsgSchemaImport().equals( rhs.getOptionalJXMsgSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					if( ! getOptionalJXMsgSchemaFormatters().equals( rhs.getOptionalJXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					if( ! getOptionalJXMsgClientSchemaImport().equals( rhs.getOptionalJXMsgClientSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					if( ! getOptionalJXMsgClientSchemaBody().equals( rhs.getOptionalJXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalJXMsgRqstSchemaBody().equals( rhs.getOptionalJXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					if( ! getOptionalJXMsgRqstSchemaImport().equals( rhs.getOptionalJXMsgRqstSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRqstSchemaWireParsers().equals( rhs.getOptionalJXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalJXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalJXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalJXMsgRspnSchemaBody().equals( rhs.getOptionalJXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					if( ! getOptionalJXMsgRspnSchemaImport().equals( rhs.getOptionalJXMsgRspnSchemaImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalJXMsgRspnSchemaWireParsers().equals( rhs.getOptionalJXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalJXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalJXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalJXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					if( ! getOptionalCppSchemaObjInclude().equals( rhs.getOptionalCppSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjInterface() != null ) {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					if( ! getOptionalCppSchemaObjInterface().equals( rhs.getOptionalCppSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					if( ! getOptionalCppSchemaObjMembers().equals( rhs.getOptionalCppSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					if( ! getOptionalCppSchemaObjImplementation().equals( rhs.getOptionalCppSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalCppDb2LUWSchemaObjMembers().equals( rhs.getOptionalCppDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalCppDb2LUWSchemaObjImpl().equals( rhs.getOptionalCppDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					if( ! getOptionalCppDb2LUWSchemaObjInclude().equals( rhs.getOptionalCppDb2LUWSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCppMSSqlSchemaObjMembers().equals( rhs.getOptionalCppMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCppMSSqlSchemaObjImpl().equals( rhs.getOptionalCppMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					if( ! getOptionalCppMSSqlSchemaObjInclude().equals( rhs.getOptionalCppMSSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalCppMySqlSchemaObjMembers().equals( rhs.getOptionalCppMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalCppMySqlSchemaObjImpl().equals( rhs.getOptionalCppMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					if( ! getOptionalCppMySqlSchemaObjInclude().equals( rhs.getOptionalCppMySqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					if( ! getOptionalCppOracleSchemaObjMembers().equals( rhs.getOptionalCppOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					if( ! getOptionalCppOracleSchemaObjImpl().equals( rhs.getOptionalCppOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					if( ! getOptionalCppOracleSchemaObjInclude().equals( rhs.getOptionalCppOracleSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCppPgSqlSchemaObjMembers().equals( rhs.getOptionalCppPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCppPgSqlSchemaObjImpl().equals( rhs.getOptionalCppPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					if( ! getOptionalCppPgSqlSchemaObjInclude().equals( rhs.getOptionalCppPgSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					if( ! getOptionalCppRamSchemaObjMembers().equals( rhs.getOptionalCppRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					if( ! getOptionalCppRamSchemaObjImpl().equals( rhs.getOptionalCppRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					if( ! getOptionalCppRamSchemaObjInclude().equals( rhs.getOptionalCppRamSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgSchemaInclude().equals( rhs.getOptionalCppXMsgSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					if( ! getOptionalCppXMsgSchemaFormatters().equals( rhs.getOptionalCppXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgClientSchemaInclude().equals( rhs.getOptionalCppXMsgClientSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					if( ! getOptionalCppXMsgClientSchemaBody().equals( rhs.getOptionalCppXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaBody().equals( rhs.getOptionalCppXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaInclude().equals( rhs.getOptionalCppXMsgRqstSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaWireParsers().equals( rhs.getOptionalCppXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalCppXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaBody().equals( rhs.getOptionalCppXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaInclude().equals( rhs.getOptionalCppXMsgRspnSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaWireParsers().equals( rhs.getOptionalCppXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalCppXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					if( ! getOptionalHppSchemaObjInclude().equals( rhs.getOptionalHppSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjInterface() != null ) {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					if( ! getOptionalHppSchemaObjInterface().equals( rhs.getOptionalHppSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					if( ! getOptionalHppSchemaObjMembers().equals( rhs.getOptionalHppSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					if( ! getOptionalHppSchemaObjImplementation().equals( rhs.getOptionalHppSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalHppDb2LUWSchemaObjMembers().equals( rhs.getOptionalHppDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalHppDb2LUWSchemaObjImpl().equals( rhs.getOptionalHppDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					if( ! getOptionalHppDb2LUWSchemaObjInclude().equals( rhs.getOptionalHppDb2LUWSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalHppMSSqlSchemaObjMembers().equals( rhs.getOptionalHppMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalHppMSSqlSchemaObjImpl().equals( rhs.getOptionalHppMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					if( ! getOptionalHppMSSqlSchemaObjInclude().equals( rhs.getOptionalHppMSSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalHppMySqlSchemaObjMembers().equals( rhs.getOptionalHppMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalHppMySqlSchemaObjImpl().equals( rhs.getOptionalHppMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					if( ! getOptionalHppMySqlSchemaObjInclude().equals( rhs.getOptionalHppMySqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					if( ! getOptionalHppOracleSchemaObjMembers().equals( rhs.getOptionalHppOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					if( ! getOptionalHppOracleSchemaObjImpl().equals( rhs.getOptionalHppOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					if( ! getOptionalHppOracleSchemaObjInclude().equals( rhs.getOptionalHppOracleSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalHppPgSqlSchemaObjMembers().equals( rhs.getOptionalHppPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalHppPgSqlSchemaObjImpl().equals( rhs.getOptionalHppPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					if( ! getOptionalHppPgSqlSchemaObjInclude().equals( rhs.getOptionalHppPgSqlSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					if( ! getOptionalHppRamSchemaObjMembers().equals( rhs.getOptionalHppRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					if( ! getOptionalHppRamSchemaObjImpl().equals( rhs.getOptionalHppRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					if( ! getOptionalHppRamSchemaObjInclude().equals( rhs.getOptionalHppRamSchemaObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgSchemaInclude().equals( rhs.getOptionalHppXMsgSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					if( ! getOptionalHppXMsgSchemaFormatters().equals( rhs.getOptionalHppXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgClientSchemaInclude().equals( rhs.getOptionalHppXMsgClientSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					if( ! getOptionalHppXMsgClientSchemaBody().equals( rhs.getOptionalHppXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaBody().equals( rhs.getOptionalHppXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaInclude().equals( rhs.getOptionalHppXMsgRqstSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaWireParsers().equals( rhs.getOptionalHppXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalHppXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaBody().equals( rhs.getOptionalHppXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaInclude().equals( rhs.getOptionalHppXMsgRspnSchemaInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaWireParsers().equals( rhs.getOptionalHppXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalHppXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					if( ! getOptionalCsSchemaObjUsing().equals( rhs.getOptionalCsSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjInterface() != null ) {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					if( ! getOptionalCsSchemaObjInterface().equals( rhs.getOptionalCsSchemaObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					if( ! getOptionalCsSchemaObjMembers().equals( rhs.getOptionalCsSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					if( ! getOptionalCsSchemaObjImplementation().equals( rhs.getOptionalCsSchemaObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					if( ! getOptionalCsDb2LUWSchemaObjMembers().equals( rhs.getOptionalCsDb2LUWSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					if( ! getOptionalCsDb2LUWSchemaObjImpl().equals( rhs.getOptionalCsDb2LUWSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					if( ! getOptionalCsDb2LUWSchemaObjUsing().equals( rhs.getOptionalCsDb2LUWSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCsMSSqlSchemaObjMembers().equals( rhs.getOptionalCsMSSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCsMSSqlSchemaObjImpl().equals( rhs.getOptionalCsMSSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					if( ! getOptionalCsMSSqlSchemaObjUsing().equals( rhs.getOptionalCsMSSqlSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					if( ! getOptionalCsMySqlSchemaObjMembers().equals( rhs.getOptionalCsMySqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					if( ! getOptionalCsMySqlSchemaObjImpl().equals( rhs.getOptionalCsMySqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					if( ! getOptionalCsMySqlSchemaObjUsing().equals( rhs.getOptionalCsMySqlSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					if( ! getOptionalCsOracleSchemaObjMembers().equals( rhs.getOptionalCsOracleSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					if( ! getOptionalCsOracleSchemaObjImpl().equals( rhs.getOptionalCsOracleSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					if( ! getOptionalCsOracleSchemaObjUsing().equals( rhs.getOptionalCsOracleSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					if( ! getOptionalCsPgSqlSchemaObjMembers().equals( rhs.getOptionalCsPgSqlSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					if( ! getOptionalCsPgSqlSchemaObjImpl().equals( rhs.getOptionalCsPgSqlSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					if( ! getOptionalCsPgSqlSchemaObjUsing().equals( rhs.getOptionalCsPgSqlSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					if( ! getOptionalCsRamSchemaObjMembers().equals( rhs.getOptionalCsRamSchemaObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					if( ! getOptionalCsRamSchemaObjImpl().equals( rhs.getOptionalCsRamSchemaObjImpl() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					if( ! getOptionalCsRamSchemaObjUsing().equals( rhs.getOptionalCsRamSchemaObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgSchemaUsing().equals( rhs.getOptionalCsXMsgSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					if( ! getOptionalCsXMsgSchemaFormatters().equals( rhs.getOptionalCsXMsgSchemaFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgClientSchemaUsing().equals( rhs.getOptionalCsXMsgClientSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					if( ! getOptionalCsXMsgClientSchemaBody().equals( rhs.getOptionalCsXMsgClientSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaBody().equals( rhs.getOptionalCsXMsgRqstSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaUsing().equals( rhs.getOptionalCsXMsgRqstSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaWireParsers().equals( rhs.getOptionalCsXMsgRqstSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaXsdSpec().equals( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					if( ! getOptionalCsXMsgRqstSchemaXsdElementList().equals( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaBody().equals( rhs.getOptionalCsXMsgRspnSchemaBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaUsing().equals( rhs.getOptionalCsXMsgRspnSchemaUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaWireParsers().equals( rhs.getOptionalCsXMsgRspnSchemaWireParsers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaXsdElementList().equals( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					if( ! getOptionalCsXMsgRspnSchemaXsdSpec().equals( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByCTenantIdxKey ) {
			CFBamSchemaDefByCTenantIdxKey rhs = (CFBamSchemaDefByCTenantIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByMinorVersionIdxKey ) {
			CFBamSchemaDefByMinorVersionIdxKey rhs = (CFBamSchemaDefByMinorVersionIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredMinorVersionId() != rhs.getRequiredMinorVersionId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByUNameIdxKey ) {
			CFBamSchemaDefByUNameIdxKey rhs = (CFBamSchemaDefByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredMinorVersionId() != rhs.getRequiredMinorVersionId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;
			if( getOptionalDefaultLicenseTenantId() != null ) {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					if( ! getOptionalDefaultLicenseTenantId().equals( rhs.getOptionalDefaultLicenseTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					if( ! getOptionalDefaultLicenseId().equals( rhs.getOptionalDefaultLicenseId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByAuthEMailIdxKey ) {
			CFBamSchemaDefByAuthEMailIdxKey rhs = (CFBamSchemaDefByAuthEMailIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByProjectURLIdxKey ) {
			CFBamSchemaDefByProjectURLIdxKey rhs = (CFBamSchemaDefByProjectURLIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamSchemaDefByPubURIIdxKey ) {
			CFBamSchemaDefByPubURIIdxKey rhs = (CFBamSchemaDefByPubURIIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
				return( false );
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredMinorVersionId() );
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		if( getOptionalDefaultLicenseTenantId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseTenantId().hashCode();
		}
		if( getOptionalDefaultLicenseId() != null ) {
			hashCode = hashCode + getOptionalDefaultLicenseId().hashCode();
		}
		if( getRequiredCopyrightPeriod() != null ) {
			hashCode = hashCode + getRequiredCopyrightPeriod().hashCode();
		}
		if( getRequiredCopyrightHolder() != null ) {
			hashCode = hashCode + getRequiredCopyrightHolder().hashCode();
		}
		if( getRequiredAuthorEMail() != null ) {
			hashCode = hashCode + getRequiredAuthorEMail().hashCode();
		}
		if( getRequiredProjectURL() != null ) {
			hashCode = hashCode + getRequiredProjectURL().hashCode();
		}
		if( getRequiredPublishURI() != null ) {
			hashCode = hashCode + getRequiredPublishURI().hashCode();
		}
		if( getOptionalJSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjImport().hashCode();
		}
		if( getOptionalJSchemaObjInterface() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjInterface().hashCode();
		}
		if( getOptionalJSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjMembers().hashCode();
		}
		if( getOptionalJSchemaObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJSchemaObjImplementation().hashCode();
		}
		if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWSchemaObjMembers().hashCode();
		}
		if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWSchemaObjImpl().hashCode();
		}
		if( getOptionalJDb2LUWSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWSchemaObjImport().hashCode();
		}
		if( getOptionalJMSSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJMSSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalJMSSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJMSSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalJMSSqlSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJMSSqlSchemaObjImport().hashCode();
		}
		if( getOptionalJMySqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJMySqlSchemaObjMembers().hashCode();
		}
		if( getOptionalJMySqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJMySqlSchemaObjImpl().hashCode();
		}
		if( getOptionalJMySqlSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJMySqlSchemaObjImport().hashCode();
		}
		if( getOptionalJOracleSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJOracleSchemaObjMembers().hashCode();
		}
		if( getOptionalJOracleSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJOracleSchemaObjImpl().hashCode();
		}
		if( getOptionalJOracleSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJOracleSchemaObjImport().hashCode();
		}
		if( getOptionalJPgSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJPgSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalJPgSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJPgSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalJPgSqlSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJPgSqlSchemaObjImport().hashCode();
		}
		if( getOptionalJRamSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalJRamSchemaObjMembers().hashCode();
		}
		if( getOptionalJRamSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalJRamSchemaObjImpl().hashCode();
		}
		if( getOptionalJRamSchemaObjImport() != null ) {
			hashCode = hashCode + getOptionalJRamSchemaObjImport().hashCode();
		}
		if( getOptionalJXMsgSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgSchemaImport().hashCode();
		}
		if( getOptionalJXMsgSchemaFormatters() != null ) {
			hashCode = hashCode + getOptionalJXMsgSchemaFormatters().hashCode();
		}
		if( getOptionalJXMsgClientSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientSchemaImport().hashCode();
		}
		if( getOptionalJXMsgClientSchemaBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientSchemaBody().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaBody().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaImport().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaWireParsers().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaXsdSpec().hashCode();
		}
		if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstSchemaXsdElementList().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaBody().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaImport().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaWireParsers().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaXsdElementList().hashCode();
		}
		if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnSchemaXsdSpec().hashCode();
		}
		if( getOptionalCppSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppSchemaObjInclude().hashCode();
		}
		if( getOptionalCppSchemaObjInterface() != null ) {
			hashCode = hashCode + getOptionalCppSchemaObjInterface().hashCode();
		}
		if( getOptionalCppSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppSchemaObjMembers().hashCode();
		}
		if( getOptionalCppSchemaObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCppSchemaObjImplementation().hashCode();
		}
		if( getOptionalCppDb2LUWSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppDb2LUWSchemaObjMembers().hashCode();
		}
		if( getOptionalCppDb2LUWSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCppDb2LUWSchemaObjImpl().hashCode();
		}
		if( getOptionalCppDb2LUWSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppDb2LUWSchemaObjInclude().hashCode();
		}
		if( getOptionalCppMSSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppMSSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalCppMSSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCppMSSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalCppMSSqlSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppMSSqlSchemaObjInclude().hashCode();
		}
		if( getOptionalCppMySqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppMySqlSchemaObjMembers().hashCode();
		}
		if( getOptionalCppMySqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCppMySqlSchemaObjImpl().hashCode();
		}
		if( getOptionalCppMySqlSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppMySqlSchemaObjInclude().hashCode();
		}
		if( getOptionalCppOracleSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppOracleSchemaObjMembers().hashCode();
		}
		if( getOptionalCppOracleSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCppOracleSchemaObjImpl().hashCode();
		}
		if( getOptionalCppOracleSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppOracleSchemaObjInclude().hashCode();
		}
		if( getOptionalCppPgSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppPgSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalCppPgSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCppPgSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalCppPgSqlSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppPgSqlSchemaObjInclude().hashCode();
		}
		if( getOptionalCppRamSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppRamSchemaObjMembers().hashCode();
		}
		if( getOptionalCppRamSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCppRamSchemaObjImpl().hashCode();
		}
		if( getOptionalCppRamSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppRamSchemaObjInclude().hashCode();
		}
		if( getOptionalCppXMsgSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgSchemaInclude().hashCode();
		}
		if( getOptionalCppXMsgSchemaFormatters() != null ) {
			hashCode = hashCode + getOptionalCppXMsgSchemaFormatters().hashCode();
		}
		if( getOptionalCppXMsgClientSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgClientSchemaInclude().hashCode();
		}
		if( getOptionalCppXMsgClientSchemaBody() != null ) {
			hashCode = hashCode + getOptionalCppXMsgClientSchemaBody().hashCode();
		}
		if( getOptionalCppXMsgRqstSchemaBody() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstSchemaBody().hashCode();
		}
		if( getOptionalCppXMsgRqstSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstSchemaInclude().hashCode();
		}
		if( getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstSchemaWireParsers().hashCode();
		}
		if( getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstSchemaXsdSpec().hashCode();
		}
		if( getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstSchemaXsdElementList().hashCode();
		}
		if( getOptionalCppXMsgRspnSchemaBody() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnSchemaBody().hashCode();
		}
		if( getOptionalCppXMsgRspnSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnSchemaInclude().hashCode();
		}
		if( getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnSchemaWireParsers().hashCode();
		}
		if( getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnSchemaXsdElementList().hashCode();
		}
		if( getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnSchemaXsdSpec().hashCode();
		}
		if( getOptionalHppSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppSchemaObjInclude().hashCode();
		}
		if( getOptionalHppSchemaObjInterface() != null ) {
			hashCode = hashCode + getOptionalHppSchemaObjInterface().hashCode();
		}
		if( getOptionalHppSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppSchemaObjMembers().hashCode();
		}
		if( getOptionalHppSchemaObjImplementation() != null ) {
			hashCode = hashCode + getOptionalHppSchemaObjImplementation().hashCode();
		}
		if( getOptionalHppDb2LUWSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppDb2LUWSchemaObjMembers().hashCode();
		}
		if( getOptionalHppDb2LUWSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalHppDb2LUWSchemaObjImpl().hashCode();
		}
		if( getOptionalHppDb2LUWSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppDb2LUWSchemaObjInclude().hashCode();
		}
		if( getOptionalHppMSSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppMSSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalHppMSSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalHppMSSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalHppMSSqlSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppMSSqlSchemaObjInclude().hashCode();
		}
		if( getOptionalHppMySqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppMySqlSchemaObjMembers().hashCode();
		}
		if( getOptionalHppMySqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalHppMySqlSchemaObjImpl().hashCode();
		}
		if( getOptionalHppMySqlSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppMySqlSchemaObjInclude().hashCode();
		}
		if( getOptionalHppOracleSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppOracleSchemaObjMembers().hashCode();
		}
		if( getOptionalHppOracleSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalHppOracleSchemaObjImpl().hashCode();
		}
		if( getOptionalHppOracleSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppOracleSchemaObjInclude().hashCode();
		}
		if( getOptionalHppPgSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppPgSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalHppPgSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalHppPgSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalHppPgSqlSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppPgSqlSchemaObjInclude().hashCode();
		}
		if( getOptionalHppRamSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppRamSchemaObjMembers().hashCode();
		}
		if( getOptionalHppRamSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalHppRamSchemaObjImpl().hashCode();
		}
		if( getOptionalHppRamSchemaObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppRamSchemaObjInclude().hashCode();
		}
		if( getOptionalHppXMsgSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgSchemaInclude().hashCode();
		}
		if( getOptionalHppXMsgSchemaFormatters() != null ) {
			hashCode = hashCode + getOptionalHppXMsgSchemaFormatters().hashCode();
		}
		if( getOptionalHppXMsgClientSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgClientSchemaInclude().hashCode();
		}
		if( getOptionalHppXMsgClientSchemaBody() != null ) {
			hashCode = hashCode + getOptionalHppXMsgClientSchemaBody().hashCode();
		}
		if( getOptionalHppXMsgRqstSchemaBody() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstSchemaBody().hashCode();
		}
		if( getOptionalHppXMsgRqstSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstSchemaInclude().hashCode();
		}
		if( getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstSchemaWireParsers().hashCode();
		}
		if( getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstSchemaXsdSpec().hashCode();
		}
		if( getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstSchemaXsdElementList().hashCode();
		}
		if( getOptionalHppXMsgRspnSchemaBody() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnSchemaBody().hashCode();
		}
		if( getOptionalHppXMsgRspnSchemaInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnSchemaInclude().hashCode();
		}
		if( getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnSchemaWireParsers().hashCode();
		}
		if( getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnSchemaXsdElementList().hashCode();
		}
		if( getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnSchemaXsdSpec().hashCode();
		}
		if( getOptionalCsSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsSchemaObjUsing().hashCode();
		}
		if( getOptionalCsSchemaObjInterface() != null ) {
			hashCode = hashCode + getOptionalCsSchemaObjInterface().hashCode();
		}
		if( getOptionalCsSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsSchemaObjMembers().hashCode();
		}
		if( getOptionalCsSchemaObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCsSchemaObjImplementation().hashCode();
		}
		if( getOptionalCsDb2LUWSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsDb2LUWSchemaObjMembers().hashCode();
		}
		if( getOptionalCsDb2LUWSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCsDb2LUWSchemaObjImpl().hashCode();
		}
		if( getOptionalCsDb2LUWSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsDb2LUWSchemaObjUsing().hashCode();
		}
		if( getOptionalCsMSSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsMSSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalCsMSSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCsMSSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalCsMSSqlSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsMSSqlSchemaObjUsing().hashCode();
		}
		if( getOptionalCsMySqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsMySqlSchemaObjMembers().hashCode();
		}
		if( getOptionalCsMySqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCsMySqlSchemaObjImpl().hashCode();
		}
		if( getOptionalCsMySqlSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsMySqlSchemaObjUsing().hashCode();
		}
		if( getOptionalCsOracleSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsOracleSchemaObjMembers().hashCode();
		}
		if( getOptionalCsOracleSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCsOracleSchemaObjImpl().hashCode();
		}
		if( getOptionalCsOracleSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsOracleSchemaObjUsing().hashCode();
		}
		if( getOptionalCsPgSqlSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsPgSqlSchemaObjMembers().hashCode();
		}
		if( getOptionalCsPgSqlSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCsPgSqlSchemaObjImpl().hashCode();
		}
		if( getOptionalCsPgSqlSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsPgSqlSchemaObjUsing().hashCode();
		}
		if( getOptionalCsRamSchemaObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsRamSchemaObjMembers().hashCode();
		}
		if( getOptionalCsRamSchemaObjImpl() != null ) {
			hashCode = hashCode + getOptionalCsRamSchemaObjImpl().hashCode();
		}
		if( getOptionalCsRamSchemaObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsRamSchemaObjUsing().hashCode();
		}
		if( getOptionalCsXMsgSchemaUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgSchemaUsing().hashCode();
		}
		if( getOptionalCsXMsgSchemaFormatters() != null ) {
			hashCode = hashCode + getOptionalCsXMsgSchemaFormatters().hashCode();
		}
		if( getOptionalCsXMsgClientSchemaUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgClientSchemaUsing().hashCode();
		}
		if( getOptionalCsXMsgClientSchemaBody() != null ) {
			hashCode = hashCode + getOptionalCsXMsgClientSchemaBody().hashCode();
		}
		if( getOptionalCsXMsgRqstSchemaBody() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstSchemaBody().hashCode();
		}
		if( getOptionalCsXMsgRqstSchemaUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstSchemaUsing().hashCode();
		}
		if( getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstSchemaWireParsers().hashCode();
		}
		if( getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstSchemaXsdSpec().hashCode();
		}
		if( getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstSchemaXsdElementList().hashCode();
		}
		if( getOptionalCsXMsgRspnSchemaBody() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnSchemaBody().hashCode();
		}
		if( getOptionalCsXMsgRspnSchemaUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnSchemaUsing().hashCode();
		}
		if( getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnSchemaWireParsers().hashCode();
		}
		if( getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnSchemaXsdElementList().hashCode();
		}
		if( getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnSchemaXsdSpec().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamSchemaDefBuff ) {
			CFBamSchemaDefBuff rhs = (CFBamSchemaDefBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredMinorVersionId() < rhs.getRequiredMinorVersionId() ) {
				return( -1 );
			}
			else if( getRequiredMinorVersionId() > rhs.getRequiredMinorVersionId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					int cmp = getOptionalJSchemaObjImport().compareTo( rhs.getOptionalJSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					int cmp = getOptionalJSchemaObjInterface().compareTo( rhs.getOptionalJSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					int cmp = getOptionalJSchemaObjMembers().compareTo( rhs.getOptionalJSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					int cmp = getOptionalJSchemaObjImplementation().compareTo( rhs.getOptionalJSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalJDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalJDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjImport().compareTo( rhs.getOptionalJDb2LUWSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjMembers().compareTo( rhs.getOptionalJMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjImpl().compareTo( rhs.getOptionalJMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjImport().compareTo( rhs.getOptionalJMSSqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJMySqlSchemaObjMembers().compareTo( rhs.getOptionalJMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJMySqlSchemaObjImpl().compareTo( rhs.getOptionalJMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					int cmp = getOptionalJMySqlSchemaObjImport().compareTo( rhs.getOptionalJMySqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalJOracleSchemaObjMembers().compareTo( rhs.getOptionalJOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalJOracleSchemaObjImpl().compareTo( rhs.getOptionalJOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					int cmp = getOptionalJOracleSchemaObjImport().compareTo( rhs.getOptionalJOracleSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjMembers().compareTo( rhs.getOptionalJPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjImpl().compareTo( rhs.getOptionalJPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjImport().compareTo( rhs.getOptionalJPgSqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					int cmp = getOptionalJRamSchemaObjMembers().compareTo( rhs.getOptionalJRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					int cmp = getOptionalJRamSchemaObjImpl().compareTo( rhs.getOptionalJRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					int cmp = getOptionalJRamSchemaObjImport().compareTo( rhs.getOptionalJRamSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					int cmp = getOptionalJXMsgSchemaImport().compareTo( rhs.getOptionalJXMsgSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalJXMsgSchemaFormatters().compareTo( rhs.getOptionalJXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					int cmp = getOptionalJXMsgClientSchemaImport().compareTo( rhs.getOptionalJXMsgClientSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalJXMsgClientSchemaBody().compareTo( rhs.getOptionalJXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaBody().compareTo( rhs.getOptionalJXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaImport().compareTo( rhs.getOptionalJXMsgRqstSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalJXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalJXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalJXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaBody().compareTo( rhs.getOptionalJXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaImport().compareTo( rhs.getOptionalJXMsgRspnSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalJXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalJXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalJXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					int cmp = getOptionalCppSchemaObjInclude().compareTo( rhs.getOptionalCppSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjInterface() != null ) {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					int cmp = getOptionalCppSchemaObjInterface().compareTo( rhs.getOptionalCppSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					int cmp = getOptionalCppSchemaObjMembers().compareTo( rhs.getOptionalCppSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					int cmp = getOptionalCppSchemaObjImplementation().compareTo( rhs.getOptionalCppSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalCppDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalCppDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalCppDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalCppDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					int cmp = getOptionalCppDb2LUWSchemaObjInclude().compareTo( rhs.getOptionalCppDb2LUWSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCppMSSqlSchemaObjMembers().compareTo( rhs.getOptionalCppMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCppMSSqlSchemaObjImpl().compareTo( rhs.getOptionalCppMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalCppMSSqlSchemaObjInclude().compareTo( rhs.getOptionalCppMSSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCppMySqlSchemaObjMembers().compareTo( rhs.getOptionalCppMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCppMySqlSchemaObjImpl().compareTo( rhs.getOptionalCppMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					int cmp = getOptionalCppMySqlSchemaObjInclude().compareTo( rhs.getOptionalCppMySqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalCppOracleSchemaObjMembers().compareTo( rhs.getOptionalCppOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalCppOracleSchemaObjImpl().compareTo( rhs.getOptionalCppOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					int cmp = getOptionalCppOracleSchemaObjInclude().compareTo( rhs.getOptionalCppOracleSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCppPgSqlSchemaObjMembers().compareTo( rhs.getOptionalCppPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCppPgSqlSchemaObjImpl().compareTo( rhs.getOptionalCppPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalCppPgSqlSchemaObjInclude().compareTo( rhs.getOptionalCppPgSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					int cmp = getOptionalCppRamSchemaObjMembers().compareTo( rhs.getOptionalCppRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					int cmp = getOptionalCppRamSchemaObjImpl().compareTo( rhs.getOptionalCppRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					int cmp = getOptionalCppRamSchemaObjInclude().compareTo( rhs.getOptionalCppRamSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgSchemaInclude().compareTo( rhs.getOptionalCppXMsgSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalCppXMsgSchemaFormatters().compareTo( rhs.getOptionalCppXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgClientSchemaInclude().compareTo( rhs.getOptionalCppXMsgClientSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalCppXMsgClientSchemaBody().compareTo( rhs.getOptionalCppXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaBody().compareTo( rhs.getOptionalCppXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaInclude().compareTo( rhs.getOptionalCppXMsgRqstSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalCppXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaBody().compareTo( rhs.getOptionalCppXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaInclude().compareTo( rhs.getOptionalCppXMsgRspnSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalCppXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					int cmp = getOptionalHppSchemaObjInclude().compareTo( rhs.getOptionalHppSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjInterface() != null ) {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					int cmp = getOptionalHppSchemaObjInterface().compareTo( rhs.getOptionalHppSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					int cmp = getOptionalHppSchemaObjMembers().compareTo( rhs.getOptionalHppSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					int cmp = getOptionalHppSchemaObjImplementation().compareTo( rhs.getOptionalHppSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalHppDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalHppDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalHppDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalHppDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					int cmp = getOptionalHppDb2LUWSchemaObjInclude().compareTo( rhs.getOptionalHppDb2LUWSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalHppMSSqlSchemaObjMembers().compareTo( rhs.getOptionalHppMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalHppMSSqlSchemaObjImpl().compareTo( rhs.getOptionalHppMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalHppMSSqlSchemaObjInclude().compareTo( rhs.getOptionalHppMSSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalHppMySqlSchemaObjMembers().compareTo( rhs.getOptionalHppMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalHppMySqlSchemaObjImpl().compareTo( rhs.getOptionalHppMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					int cmp = getOptionalHppMySqlSchemaObjInclude().compareTo( rhs.getOptionalHppMySqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalHppOracleSchemaObjMembers().compareTo( rhs.getOptionalHppOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalHppOracleSchemaObjImpl().compareTo( rhs.getOptionalHppOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					int cmp = getOptionalHppOracleSchemaObjInclude().compareTo( rhs.getOptionalHppOracleSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalHppPgSqlSchemaObjMembers().compareTo( rhs.getOptionalHppPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalHppPgSqlSchemaObjImpl().compareTo( rhs.getOptionalHppPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalHppPgSqlSchemaObjInclude().compareTo( rhs.getOptionalHppPgSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					int cmp = getOptionalHppRamSchemaObjMembers().compareTo( rhs.getOptionalHppRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					int cmp = getOptionalHppRamSchemaObjImpl().compareTo( rhs.getOptionalHppRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					int cmp = getOptionalHppRamSchemaObjInclude().compareTo( rhs.getOptionalHppRamSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgSchemaInclude().compareTo( rhs.getOptionalHppXMsgSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalHppXMsgSchemaFormatters().compareTo( rhs.getOptionalHppXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgClientSchemaInclude().compareTo( rhs.getOptionalHppXMsgClientSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalHppXMsgClientSchemaBody().compareTo( rhs.getOptionalHppXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaBody().compareTo( rhs.getOptionalHppXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaInclude().compareTo( rhs.getOptionalHppXMsgRqstSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalHppXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaBody().compareTo( rhs.getOptionalHppXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaInclude().compareTo( rhs.getOptionalHppXMsgRspnSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalHppXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					int cmp = getOptionalCsSchemaObjUsing().compareTo( rhs.getOptionalCsSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjInterface() != null ) {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					int cmp = getOptionalCsSchemaObjInterface().compareTo( rhs.getOptionalCsSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					int cmp = getOptionalCsSchemaObjMembers().compareTo( rhs.getOptionalCsSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					int cmp = getOptionalCsSchemaObjImplementation().compareTo( rhs.getOptionalCsSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalCsDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalCsDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalCsDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalCsDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					int cmp = getOptionalCsDb2LUWSchemaObjUsing().compareTo( rhs.getOptionalCsDb2LUWSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCsMSSqlSchemaObjMembers().compareTo( rhs.getOptionalCsMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCsMSSqlSchemaObjImpl().compareTo( rhs.getOptionalCsMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					int cmp = getOptionalCsMSSqlSchemaObjUsing().compareTo( rhs.getOptionalCsMSSqlSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCsMySqlSchemaObjMembers().compareTo( rhs.getOptionalCsMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCsMySqlSchemaObjImpl().compareTo( rhs.getOptionalCsMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					int cmp = getOptionalCsMySqlSchemaObjUsing().compareTo( rhs.getOptionalCsMySqlSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalCsOracleSchemaObjMembers().compareTo( rhs.getOptionalCsOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalCsOracleSchemaObjImpl().compareTo( rhs.getOptionalCsOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					int cmp = getOptionalCsOracleSchemaObjUsing().compareTo( rhs.getOptionalCsOracleSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCsPgSqlSchemaObjMembers().compareTo( rhs.getOptionalCsPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCsPgSqlSchemaObjImpl().compareTo( rhs.getOptionalCsPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					int cmp = getOptionalCsPgSqlSchemaObjUsing().compareTo( rhs.getOptionalCsPgSqlSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					int cmp = getOptionalCsRamSchemaObjMembers().compareTo( rhs.getOptionalCsRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					int cmp = getOptionalCsRamSchemaObjImpl().compareTo( rhs.getOptionalCsRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					int cmp = getOptionalCsRamSchemaObjUsing().compareTo( rhs.getOptionalCsRamSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgSchemaUsing().compareTo( rhs.getOptionalCsXMsgSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalCsXMsgSchemaFormatters().compareTo( rhs.getOptionalCsXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgClientSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgClientSchemaUsing().compareTo( rhs.getOptionalCsXMsgClientSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalCsXMsgClientSchemaBody().compareTo( rhs.getOptionalCsXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaBody().compareTo( rhs.getOptionalCsXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaUsing().compareTo( rhs.getOptionalCsXMsgRqstSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalCsXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaBody().compareTo( rhs.getOptionalCsXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaUsing().compareTo( rhs.getOptionalCsXMsgRspnSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalCsXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamScopePKey ) {
			CFBamScopePKey rhs = (CFBamScopePKey)obj;
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamScopeHPKey ) {
			CFBamScopeHPKey rhs = (CFBamScopeHPKey)obj;
			{
				int lhsRequiredRevision = getRequiredRevision();
				int rhsRequiredRevision = rhs.getRequiredRevision();
				if( lhsRequiredRevision < rhsRequiredRevision ) {
					return( -1 );
				}
				else if( lhsRequiredRevision > rhsRequiredRevision ) {
					return( 1 );
				}
			}
			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredId() < rhs.getRequiredId() ) {
				return( -1 );
			}
			else if( getRequiredId() > rhs.getRequiredId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefHBuff ) {
			CFBamSchemaDefHBuff rhs = (CFBamSchemaDefHBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			if( getRequiredMinorVersionId() < rhs.getRequiredMinorVersionId() ) {
				return( -1 );
			}
			else if( getRequiredMinorVersionId() > rhs.getRequiredMinorVersionId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					int cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					int cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					int cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					int cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					int cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalJSchemaObjImport() != null ) {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					int cmp = getOptionalJSchemaObjImport().compareTo( rhs.getOptionalJSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjInterface() != null ) {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					int cmp = getOptionalJSchemaObjInterface().compareTo( rhs.getOptionalJSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjMembers() != null ) {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					int cmp = getOptionalJSchemaObjMembers().compareTo( rhs.getOptionalJSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSchemaObjImplementation() != null ) {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					int cmp = getOptionalJSchemaObjImplementation().compareTo( rhs.getOptionalJSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalJDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalJDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWSchemaObjImport() != null ) {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					int cmp = getOptionalJDb2LUWSchemaObjImport().compareTo( rhs.getOptionalJDb2LUWSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjMembers().compareTo( rhs.getOptionalJMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjImpl().compareTo( rhs.getOptionalJMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					int cmp = getOptionalJMSSqlSchemaObjImport().compareTo( rhs.getOptionalJMSSqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJMySqlSchemaObjMembers().compareTo( rhs.getOptionalJMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJMySqlSchemaObjImpl().compareTo( rhs.getOptionalJMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					int cmp = getOptionalJMySqlSchemaObjImport().compareTo( rhs.getOptionalJMySqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalJOracleSchemaObjMembers().compareTo( rhs.getOptionalJOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalJOracleSchemaObjImpl().compareTo( rhs.getOptionalJOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleSchemaObjImport() != null ) {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					int cmp = getOptionalJOracleSchemaObjImport().compareTo( rhs.getOptionalJOracleSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjMembers().compareTo( rhs.getOptionalJPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjImpl().compareTo( rhs.getOptionalJPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlSchemaObjImport() != null ) {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					int cmp = getOptionalJPgSqlSchemaObjImport().compareTo( rhs.getOptionalJPgSqlSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					int cmp = getOptionalJRamSchemaObjMembers().compareTo( rhs.getOptionalJRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					int cmp = getOptionalJRamSchemaObjImpl().compareTo( rhs.getOptionalJRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamSchemaObjImport() != null ) {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					int cmp = getOptionalJRamSchemaObjImport().compareTo( rhs.getOptionalJRamSchemaObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamSchemaObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					int cmp = getOptionalJXMsgSchemaImport().compareTo( rhs.getOptionalJXMsgSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalJXMsgSchemaFormatters().compareTo( rhs.getOptionalJXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					int cmp = getOptionalJXMsgClientSchemaImport().compareTo( rhs.getOptionalJXMsgClientSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalJXMsgClientSchemaBody().compareTo( rhs.getOptionalJXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaBody().compareTo( rhs.getOptionalJXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaImport().compareTo( rhs.getOptionalJXMsgRqstSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalJXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalJXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalJXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalJXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaBody().compareTo( rhs.getOptionalJXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaImport() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaImport().compareTo( rhs.getOptionalJXMsgRspnSchemaImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalJXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalJXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalJXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalJXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					int cmp = getOptionalCppSchemaObjInclude().compareTo( rhs.getOptionalCppSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjInterface() != null ) {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					int cmp = getOptionalCppSchemaObjInterface().compareTo( rhs.getOptionalCppSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					int cmp = getOptionalCppSchemaObjMembers().compareTo( rhs.getOptionalCppSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					int cmp = getOptionalCppSchemaObjImplementation().compareTo( rhs.getOptionalCppSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalCppDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalCppDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalCppDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalCppDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					int cmp = getOptionalCppDb2LUWSchemaObjInclude().compareTo( rhs.getOptionalCppDb2LUWSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCppMSSqlSchemaObjMembers().compareTo( rhs.getOptionalCppMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCppMSSqlSchemaObjImpl().compareTo( rhs.getOptionalCppMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalCppMSSqlSchemaObjInclude().compareTo( rhs.getOptionalCppMSSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCppMySqlSchemaObjMembers().compareTo( rhs.getOptionalCppMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCppMySqlSchemaObjImpl().compareTo( rhs.getOptionalCppMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					int cmp = getOptionalCppMySqlSchemaObjInclude().compareTo( rhs.getOptionalCppMySqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalCppOracleSchemaObjMembers().compareTo( rhs.getOptionalCppOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalCppOracleSchemaObjImpl().compareTo( rhs.getOptionalCppOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					int cmp = getOptionalCppOracleSchemaObjInclude().compareTo( rhs.getOptionalCppOracleSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCppPgSqlSchemaObjMembers().compareTo( rhs.getOptionalCppPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCppPgSqlSchemaObjImpl().compareTo( rhs.getOptionalCppPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalCppPgSqlSchemaObjInclude().compareTo( rhs.getOptionalCppPgSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					int cmp = getOptionalCppRamSchemaObjMembers().compareTo( rhs.getOptionalCppRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					int cmp = getOptionalCppRamSchemaObjImpl().compareTo( rhs.getOptionalCppRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					int cmp = getOptionalCppRamSchemaObjInclude().compareTo( rhs.getOptionalCppRamSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgSchemaInclude().compareTo( rhs.getOptionalCppXMsgSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalCppXMsgSchemaFormatters().compareTo( rhs.getOptionalCppXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgClientSchemaInclude().compareTo( rhs.getOptionalCppXMsgClientSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalCppXMsgClientSchemaBody().compareTo( rhs.getOptionalCppXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaBody().compareTo( rhs.getOptionalCppXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaInclude().compareTo( rhs.getOptionalCppXMsgRqstSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalCppXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalCppXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaBody().compareTo( rhs.getOptionalCppXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaInclude().compareTo( rhs.getOptionalCppXMsgRspnSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalCppXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalCppXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					int cmp = getOptionalHppSchemaObjInclude().compareTo( rhs.getOptionalHppSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjInterface() != null ) {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					int cmp = getOptionalHppSchemaObjInterface().compareTo( rhs.getOptionalHppSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					int cmp = getOptionalHppSchemaObjMembers().compareTo( rhs.getOptionalHppSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSchemaObjImplementation() != null ) {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					int cmp = getOptionalHppSchemaObjImplementation().compareTo( rhs.getOptionalHppSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalHppDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalHppDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalHppDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalHppDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					int cmp = getOptionalHppDb2LUWSchemaObjInclude().compareTo( rhs.getOptionalHppDb2LUWSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalHppMSSqlSchemaObjMembers().compareTo( rhs.getOptionalHppMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalHppMSSqlSchemaObjImpl().compareTo( rhs.getOptionalHppMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalHppMSSqlSchemaObjInclude().compareTo( rhs.getOptionalHppMSSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalHppMySqlSchemaObjMembers().compareTo( rhs.getOptionalHppMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalHppMySqlSchemaObjImpl().compareTo( rhs.getOptionalHppMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					int cmp = getOptionalHppMySqlSchemaObjInclude().compareTo( rhs.getOptionalHppMySqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalHppOracleSchemaObjMembers().compareTo( rhs.getOptionalHppOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalHppOracleSchemaObjImpl().compareTo( rhs.getOptionalHppOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					int cmp = getOptionalHppOracleSchemaObjInclude().compareTo( rhs.getOptionalHppOracleSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalHppPgSqlSchemaObjMembers().compareTo( rhs.getOptionalHppPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalHppPgSqlSchemaObjImpl().compareTo( rhs.getOptionalHppPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					int cmp = getOptionalHppPgSqlSchemaObjInclude().compareTo( rhs.getOptionalHppPgSqlSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					int cmp = getOptionalHppRamSchemaObjMembers().compareTo( rhs.getOptionalHppRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					int cmp = getOptionalHppRamSchemaObjImpl().compareTo( rhs.getOptionalHppRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamSchemaObjInclude() != null ) {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					int cmp = getOptionalHppRamSchemaObjInclude().compareTo( rhs.getOptionalHppRamSchemaObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamSchemaObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgSchemaInclude().compareTo( rhs.getOptionalHppXMsgSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalHppXMsgSchemaFormatters().compareTo( rhs.getOptionalHppXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgClientSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgClientSchemaInclude().compareTo( rhs.getOptionalHppXMsgClientSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalHppXMsgClientSchemaBody().compareTo( rhs.getOptionalHppXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaBody().compareTo( rhs.getOptionalHppXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaInclude().compareTo( rhs.getOptionalHppXMsgRqstSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalHppXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalHppXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaBody().compareTo( rhs.getOptionalHppXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaInclude().compareTo( rhs.getOptionalHppXMsgRspnSchemaInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalHppXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalHppXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					int cmp = getOptionalCsSchemaObjUsing().compareTo( rhs.getOptionalCsSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjInterface() != null ) {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					int cmp = getOptionalCsSchemaObjInterface().compareTo( rhs.getOptionalCsSchemaObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					int cmp = getOptionalCsSchemaObjMembers().compareTo( rhs.getOptionalCsSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSchemaObjImplementation() != null ) {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					int cmp = getOptionalCsSchemaObjImplementation().compareTo( rhs.getOptionalCsSchemaObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSchemaObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					int cmp = getOptionalCsDb2LUWSchemaObjMembers().compareTo( rhs.getOptionalCsDb2LUWSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					int cmp = getOptionalCsDb2LUWSchemaObjImpl().compareTo( rhs.getOptionalCsDb2LUWSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					int cmp = getOptionalCsDb2LUWSchemaObjUsing().compareTo( rhs.getOptionalCsDb2LUWSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCsMSSqlSchemaObjMembers().compareTo( rhs.getOptionalCsMSSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCsMSSqlSchemaObjImpl().compareTo( rhs.getOptionalCsMSSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					int cmp = getOptionalCsMSSqlSchemaObjUsing().compareTo( rhs.getOptionalCsMSSqlSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCsMySqlSchemaObjMembers().compareTo( rhs.getOptionalCsMySqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCsMySqlSchemaObjImpl().compareTo( rhs.getOptionalCsMySqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					int cmp = getOptionalCsMySqlSchemaObjUsing().compareTo( rhs.getOptionalCsMySqlSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					int cmp = getOptionalCsOracleSchemaObjMembers().compareTo( rhs.getOptionalCsOracleSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					int cmp = getOptionalCsOracleSchemaObjImpl().compareTo( rhs.getOptionalCsOracleSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					int cmp = getOptionalCsOracleSchemaObjUsing().compareTo( rhs.getOptionalCsOracleSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					int cmp = getOptionalCsPgSqlSchemaObjMembers().compareTo( rhs.getOptionalCsPgSqlSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					int cmp = getOptionalCsPgSqlSchemaObjImpl().compareTo( rhs.getOptionalCsPgSqlSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					int cmp = getOptionalCsPgSqlSchemaObjUsing().compareTo( rhs.getOptionalCsPgSqlSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamSchemaObjMembers() != null ) {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					int cmp = getOptionalCsRamSchemaObjMembers().compareTo( rhs.getOptionalCsRamSchemaObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamSchemaObjImpl() != null ) {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					int cmp = getOptionalCsRamSchemaObjImpl().compareTo( rhs.getOptionalCsRamSchemaObjImpl() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjImpl() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamSchemaObjUsing() != null ) {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					int cmp = getOptionalCsRamSchemaObjUsing().compareTo( rhs.getOptionalCsRamSchemaObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamSchemaObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgSchemaUsing().compareTo( rhs.getOptionalCsXMsgSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgSchemaFormatters() != null ) {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					int cmp = getOptionalCsXMsgSchemaFormatters().compareTo( rhs.getOptionalCsXMsgSchemaFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgSchemaFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgClientSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgClientSchemaUsing().compareTo( rhs.getOptionalCsXMsgClientSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgClientSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					int cmp = getOptionalCsXMsgClientSchemaBody().compareTo( rhs.getOptionalCsXMsgClientSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaBody().compareTo( rhs.getOptionalCsXMsgRqstSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaUsing().compareTo( rhs.getOptionalCsXMsgRqstSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaWireParsers().compareTo( rhs.getOptionalCsXMsgRqstSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaXsdSpec().compareTo( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					int cmp = getOptionalCsXMsgRqstSchemaXsdElementList().compareTo( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaBody().compareTo( rhs.getOptionalCsXMsgRspnSchemaBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaUsing().compareTo( rhs.getOptionalCsXMsgRspnSchemaUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaWireParsers().compareTo( rhs.getOptionalCsXMsgRspnSchemaWireParsers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaWireParsers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaXsdElementList().compareTo( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdElementList() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					int cmp = getOptionalCsXMsgRspnSchemaXsdSpec().compareTo( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnSchemaXsdSpec() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByCTenantIdxKey ) {
			CFBamSchemaDefByCTenantIdxKey rhs = (CFBamSchemaDefByCTenantIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByMinorVersionIdxKey ) {
			CFBamSchemaDefByMinorVersionIdxKey rhs = (CFBamSchemaDefByMinorVersionIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredMinorVersionId() < rhs.getRequiredMinorVersionId() ) {
				return( -1 );
			}
			else if( getRequiredMinorVersionId() > rhs.getRequiredMinorVersionId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByUNameIdxKey ) {
			CFBamSchemaDefByUNameIdxKey rhs = (CFBamSchemaDefByUNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredMinorVersionId() < rhs.getRequiredMinorVersionId() ) {
				return( -1 );
			}
			else if( getRequiredMinorVersionId() > rhs.getRequiredMinorVersionId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByDefLcnIdxKey ) {
			CFBamSchemaDefByDefLcnIdxKey rhs = (CFBamSchemaDefByDefLcnIdxKey)obj;

			if( getOptionalDefaultLicenseTenantId() != null ) {
				Long lhsDefaultLicenseTenantId = getOptionalDefaultLicenseTenantId();
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					Long rhsDefaultLicenseTenantId = rhs.getOptionalDefaultLicenseTenantId();
					int cmp = lhsDefaultLicenseTenantId.compareTo( rhsDefaultLicenseTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefaultLicenseId() != null ) {
				Long lhsDefaultLicenseId = getOptionalDefaultLicenseId();
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					Long rhsDefaultLicenseId = rhs.getOptionalDefaultLicenseId();
					int cmp = lhsDefaultLicenseId.compareTo( rhsDefaultLicenseId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultLicenseId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByAuthEMailIdxKey ) {
			CFBamSchemaDefByAuthEMailIdxKey rhs = (CFBamSchemaDefByAuthEMailIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByProjectURLIdxKey ) {
			CFBamSchemaDefByProjectURLIdxKey rhs = (CFBamSchemaDefByProjectURLIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamSchemaDefByPubURIIdxKey ) {
			CFBamSchemaDefByPubURIIdxKey rhs = (CFBamSchemaDefByPubURIIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else {
			int retval = super.compareTo( obj );
			return( retval );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamSchemaDefBuff ) {
			setSchemaDefBuff( (CFBamSchemaDefBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamSchemaDefBuff" );
		}
	}

	public void setSchemaDefBuff( CFBamSchemaDefBuff src ) {
		super.setScopeBuff( src );
		setRequiredMinorVersionId( src.getRequiredMinorVersionId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setOptionalDefaultLicenseTenantId( src.getOptionalDefaultLicenseTenantId() );
		setOptionalDefaultLicenseId( src.getOptionalDefaultLicenseId() );
		setRequiredCopyrightPeriod( src.getRequiredCopyrightPeriod() );
		setRequiredCopyrightHolder( src.getRequiredCopyrightHolder() );
		setRequiredAuthorEMail( src.getRequiredAuthorEMail() );
		setRequiredProjectURL( src.getRequiredProjectURL() );
		setRequiredPublishURI( src.getRequiredPublishURI() );
		setOptionalJSchemaObjImport( src.getOptionalJSchemaObjImport() );
		setOptionalJSchemaObjInterface( src.getOptionalJSchemaObjInterface() );
		setOptionalJSchemaObjMembers( src.getOptionalJSchemaObjMembers() );
		setOptionalJSchemaObjImplementation( src.getOptionalJSchemaObjImplementation() );
		setOptionalJDb2LUWSchemaObjMembers( src.getOptionalJDb2LUWSchemaObjMembers() );
		setOptionalJDb2LUWSchemaObjImpl( src.getOptionalJDb2LUWSchemaObjImpl() );
		setOptionalJDb2LUWSchemaObjImport( src.getOptionalJDb2LUWSchemaObjImport() );
		setOptionalJMSSqlSchemaObjMembers( src.getOptionalJMSSqlSchemaObjMembers() );
		setOptionalJMSSqlSchemaObjImpl( src.getOptionalJMSSqlSchemaObjImpl() );
		setOptionalJMSSqlSchemaObjImport( src.getOptionalJMSSqlSchemaObjImport() );
		setOptionalJMySqlSchemaObjMembers( src.getOptionalJMySqlSchemaObjMembers() );
		setOptionalJMySqlSchemaObjImpl( src.getOptionalJMySqlSchemaObjImpl() );
		setOptionalJMySqlSchemaObjImport( src.getOptionalJMySqlSchemaObjImport() );
		setOptionalJOracleSchemaObjMembers( src.getOptionalJOracleSchemaObjMembers() );
		setOptionalJOracleSchemaObjImpl( src.getOptionalJOracleSchemaObjImpl() );
		setOptionalJOracleSchemaObjImport( src.getOptionalJOracleSchemaObjImport() );
		setOptionalJPgSqlSchemaObjMembers( src.getOptionalJPgSqlSchemaObjMembers() );
		setOptionalJPgSqlSchemaObjImpl( src.getOptionalJPgSqlSchemaObjImpl() );
		setOptionalJPgSqlSchemaObjImport( src.getOptionalJPgSqlSchemaObjImport() );
		setOptionalJRamSchemaObjMembers( src.getOptionalJRamSchemaObjMembers() );
		setOptionalJRamSchemaObjImpl( src.getOptionalJRamSchemaObjImpl() );
		setOptionalJRamSchemaObjImport( src.getOptionalJRamSchemaObjImport() );
		setOptionalJXMsgSchemaImport( src.getOptionalJXMsgSchemaImport() );
		setOptionalJXMsgSchemaFormatters( src.getOptionalJXMsgSchemaFormatters() );
		setOptionalJXMsgClientSchemaImport( src.getOptionalJXMsgClientSchemaImport() );
		setOptionalJXMsgClientSchemaBody( src.getOptionalJXMsgClientSchemaBody() );
		setOptionalJXMsgRqstSchemaBody( src.getOptionalJXMsgRqstSchemaBody() );
		setOptionalJXMsgRqstSchemaImport( src.getOptionalJXMsgRqstSchemaImport() );
		setOptionalJXMsgRqstSchemaWireParsers( src.getOptionalJXMsgRqstSchemaWireParsers() );
		setOptionalJXMsgRqstSchemaXsdSpec( src.getOptionalJXMsgRqstSchemaXsdSpec() );
		setOptionalJXMsgRqstSchemaXsdElementList( src.getOptionalJXMsgRqstSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaBody( src.getOptionalJXMsgRspnSchemaBody() );
		setOptionalJXMsgRspnSchemaImport( src.getOptionalJXMsgRspnSchemaImport() );
		setOptionalJXMsgRspnSchemaWireParsers( src.getOptionalJXMsgRspnSchemaWireParsers() );
		setOptionalJXMsgRspnSchemaXsdElementList( src.getOptionalJXMsgRspnSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaXsdSpec( src.getOptionalJXMsgRspnSchemaXsdSpec() );
		setOptionalCppSchemaObjInclude( src.getOptionalCppSchemaObjInclude() );
		setOptionalCppSchemaObjInterface( src.getOptionalCppSchemaObjInterface() );
		setOptionalCppSchemaObjMembers( src.getOptionalCppSchemaObjMembers() );
		setOptionalCppSchemaObjImplementation( src.getOptionalCppSchemaObjImplementation() );
		setOptionalCppDb2LUWSchemaObjMembers( src.getOptionalCppDb2LUWSchemaObjMembers() );
		setOptionalCppDb2LUWSchemaObjImpl( src.getOptionalCppDb2LUWSchemaObjImpl() );
		setOptionalCppDb2LUWSchemaObjInclude( src.getOptionalCppDb2LUWSchemaObjInclude() );
		setOptionalCppMSSqlSchemaObjMembers( src.getOptionalCppMSSqlSchemaObjMembers() );
		setOptionalCppMSSqlSchemaObjImpl( src.getOptionalCppMSSqlSchemaObjImpl() );
		setOptionalCppMSSqlSchemaObjInclude( src.getOptionalCppMSSqlSchemaObjInclude() );
		setOptionalCppMySqlSchemaObjMembers( src.getOptionalCppMySqlSchemaObjMembers() );
		setOptionalCppMySqlSchemaObjImpl( src.getOptionalCppMySqlSchemaObjImpl() );
		setOptionalCppMySqlSchemaObjInclude( src.getOptionalCppMySqlSchemaObjInclude() );
		setOptionalCppOracleSchemaObjMembers( src.getOptionalCppOracleSchemaObjMembers() );
		setOptionalCppOracleSchemaObjImpl( src.getOptionalCppOracleSchemaObjImpl() );
		setOptionalCppOracleSchemaObjInclude( src.getOptionalCppOracleSchemaObjInclude() );
		setOptionalCppPgSqlSchemaObjMembers( src.getOptionalCppPgSqlSchemaObjMembers() );
		setOptionalCppPgSqlSchemaObjImpl( src.getOptionalCppPgSqlSchemaObjImpl() );
		setOptionalCppPgSqlSchemaObjInclude( src.getOptionalCppPgSqlSchemaObjInclude() );
		setOptionalCppRamSchemaObjMembers( src.getOptionalCppRamSchemaObjMembers() );
		setOptionalCppRamSchemaObjImpl( src.getOptionalCppRamSchemaObjImpl() );
		setOptionalCppRamSchemaObjInclude( src.getOptionalCppRamSchemaObjInclude() );
		setOptionalCppXMsgSchemaInclude( src.getOptionalCppXMsgSchemaInclude() );
		setOptionalCppXMsgSchemaFormatters( src.getOptionalCppXMsgSchemaFormatters() );
		setOptionalCppXMsgClientSchemaInclude( src.getOptionalCppXMsgClientSchemaInclude() );
		setOptionalCppXMsgClientSchemaBody( src.getOptionalCppXMsgClientSchemaBody() );
		setOptionalCppXMsgRqstSchemaBody( src.getOptionalCppXMsgRqstSchemaBody() );
		setOptionalCppXMsgRqstSchemaInclude( src.getOptionalCppXMsgRqstSchemaInclude() );
		setOptionalCppXMsgRqstSchemaWireParsers( src.getOptionalCppXMsgRqstSchemaWireParsers() );
		setOptionalCppXMsgRqstSchemaXsdSpec( src.getOptionalCppXMsgRqstSchemaXsdSpec() );
		setOptionalCppXMsgRqstSchemaXsdElementList( src.getOptionalCppXMsgRqstSchemaXsdElementList() );
		setOptionalCppXMsgRspnSchemaBody( src.getOptionalCppXMsgRspnSchemaBody() );
		setOptionalCppXMsgRspnSchemaInclude( src.getOptionalCppXMsgRspnSchemaInclude() );
		setOptionalCppXMsgRspnSchemaWireParsers( src.getOptionalCppXMsgRspnSchemaWireParsers() );
		setOptionalCppXMsgRspnSchemaXsdElementList( src.getOptionalCppXMsgRspnSchemaXsdElementList() );
		setOptionalCppXMsgRspnSchemaXsdSpec( src.getOptionalCppXMsgRspnSchemaXsdSpec() );
		setOptionalHppSchemaObjInclude( src.getOptionalHppSchemaObjInclude() );
		setOptionalHppSchemaObjInterface( src.getOptionalHppSchemaObjInterface() );
		setOptionalHppSchemaObjMembers( src.getOptionalHppSchemaObjMembers() );
		setOptionalHppSchemaObjImplementation( src.getOptionalHppSchemaObjImplementation() );
		setOptionalHppDb2LUWSchemaObjMembers( src.getOptionalHppDb2LUWSchemaObjMembers() );
		setOptionalHppDb2LUWSchemaObjImpl( src.getOptionalHppDb2LUWSchemaObjImpl() );
		setOptionalHppDb2LUWSchemaObjInclude( src.getOptionalHppDb2LUWSchemaObjInclude() );
		setOptionalHppMSSqlSchemaObjMembers( src.getOptionalHppMSSqlSchemaObjMembers() );
		setOptionalHppMSSqlSchemaObjImpl( src.getOptionalHppMSSqlSchemaObjImpl() );
		setOptionalHppMSSqlSchemaObjInclude( src.getOptionalHppMSSqlSchemaObjInclude() );
		setOptionalHppMySqlSchemaObjMembers( src.getOptionalHppMySqlSchemaObjMembers() );
		setOptionalHppMySqlSchemaObjImpl( src.getOptionalHppMySqlSchemaObjImpl() );
		setOptionalHppMySqlSchemaObjInclude( src.getOptionalHppMySqlSchemaObjInclude() );
		setOptionalHppOracleSchemaObjMembers( src.getOptionalHppOracleSchemaObjMembers() );
		setOptionalHppOracleSchemaObjImpl( src.getOptionalHppOracleSchemaObjImpl() );
		setOptionalHppOracleSchemaObjInclude( src.getOptionalHppOracleSchemaObjInclude() );
		setOptionalHppPgSqlSchemaObjMembers( src.getOptionalHppPgSqlSchemaObjMembers() );
		setOptionalHppPgSqlSchemaObjImpl( src.getOptionalHppPgSqlSchemaObjImpl() );
		setOptionalHppPgSqlSchemaObjInclude( src.getOptionalHppPgSqlSchemaObjInclude() );
		setOptionalHppRamSchemaObjMembers( src.getOptionalHppRamSchemaObjMembers() );
		setOptionalHppRamSchemaObjImpl( src.getOptionalHppRamSchemaObjImpl() );
		setOptionalHppRamSchemaObjInclude( src.getOptionalHppRamSchemaObjInclude() );
		setOptionalHppXMsgSchemaInclude( src.getOptionalHppXMsgSchemaInclude() );
		setOptionalHppXMsgSchemaFormatters( src.getOptionalHppXMsgSchemaFormatters() );
		setOptionalHppXMsgClientSchemaInclude( src.getOptionalHppXMsgClientSchemaInclude() );
		setOptionalHppXMsgClientSchemaBody( src.getOptionalHppXMsgClientSchemaBody() );
		setOptionalHppXMsgRqstSchemaBody( src.getOptionalHppXMsgRqstSchemaBody() );
		setOptionalHppXMsgRqstSchemaInclude( src.getOptionalHppXMsgRqstSchemaInclude() );
		setOptionalHppXMsgRqstSchemaWireParsers( src.getOptionalHppXMsgRqstSchemaWireParsers() );
		setOptionalHppXMsgRqstSchemaXsdSpec( src.getOptionalHppXMsgRqstSchemaXsdSpec() );
		setOptionalHppXMsgRqstSchemaXsdElementList( src.getOptionalHppXMsgRqstSchemaXsdElementList() );
		setOptionalHppXMsgRspnSchemaBody( src.getOptionalHppXMsgRspnSchemaBody() );
		setOptionalHppXMsgRspnSchemaInclude( src.getOptionalHppXMsgRspnSchemaInclude() );
		setOptionalHppXMsgRspnSchemaWireParsers( src.getOptionalHppXMsgRspnSchemaWireParsers() );
		setOptionalHppXMsgRspnSchemaXsdElementList( src.getOptionalHppXMsgRspnSchemaXsdElementList() );
		setOptionalHppXMsgRspnSchemaXsdSpec( src.getOptionalHppXMsgRspnSchemaXsdSpec() );
		setOptionalCsSchemaObjUsing( src.getOptionalCsSchemaObjUsing() );
		setOptionalCsSchemaObjInterface( src.getOptionalCsSchemaObjInterface() );
		setOptionalCsSchemaObjMembers( src.getOptionalCsSchemaObjMembers() );
		setOptionalCsSchemaObjImplementation( src.getOptionalCsSchemaObjImplementation() );
		setOptionalCsDb2LUWSchemaObjMembers( src.getOptionalCsDb2LUWSchemaObjMembers() );
		setOptionalCsDb2LUWSchemaObjImpl( src.getOptionalCsDb2LUWSchemaObjImpl() );
		setOptionalCsDb2LUWSchemaObjUsing( src.getOptionalCsDb2LUWSchemaObjUsing() );
		setOptionalCsMSSqlSchemaObjMembers( src.getOptionalCsMSSqlSchemaObjMembers() );
		setOptionalCsMSSqlSchemaObjImpl( src.getOptionalCsMSSqlSchemaObjImpl() );
		setOptionalCsMSSqlSchemaObjUsing( src.getOptionalCsMSSqlSchemaObjUsing() );
		setOptionalCsMySqlSchemaObjMembers( src.getOptionalCsMySqlSchemaObjMembers() );
		setOptionalCsMySqlSchemaObjImpl( src.getOptionalCsMySqlSchemaObjImpl() );
		setOptionalCsMySqlSchemaObjUsing( src.getOptionalCsMySqlSchemaObjUsing() );
		setOptionalCsOracleSchemaObjMembers( src.getOptionalCsOracleSchemaObjMembers() );
		setOptionalCsOracleSchemaObjImpl( src.getOptionalCsOracleSchemaObjImpl() );
		setOptionalCsOracleSchemaObjUsing( src.getOptionalCsOracleSchemaObjUsing() );
		setOptionalCsPgSqlSchemaObjMembers( src.getOptionalCsPgSqlSchemaObjMembers() );
		setOptionalCsPgSqlSchemaObjImpl( src.getOptionalCsPgSqlSchemaObjImpl() );
		setOptionalCsPgSqlSchemaObjUsing( src.getOptionalCsPgSqlSchemaObjUsing() );
		setOptionalCsRamSchemaObjMembers( src.getOptionalCsRamSchemaObjMembers() );
		setOptionalCsRamSchemaObjImpl( src.getOptionalCsRamSchemaObjImpl() );
		setOptionalCsRamSchemaObjUsing( src.getOptionalCsRamSchemaObjUsing() );
		setOptionalCsXMsgSchemaUsing( src.getOptionalCsXMsgSchemaUsing() );
		setOptionalCsXMsgSchemaFormatters( src.getOptionalCsXMsgSchemaFormatters() );
		setOptionalCsXMsgClientSchemaUsing( src.getOptionalCsXMsgClientSchemaUsing() );
		setOptionalCsXMsgClientSchemaBody( src.getOptionalCsXMsgClientSchemaBody() );
		setOptionalCsXMsgRqstSchemaBody( src.getOptionalCsXMsgRqstSchemaBody() );
		setOptionalCsXMsgRqstSchemaUsing( src.getOptionalCsXMsgRqstSchemaUsing() );
		setOptionalCsXMsgRqstSchemaWireParsers( src.getOptionalCsXMsgRqstSchemaWireParsers() );
		setOptionalCsXMsgRqstSchemaXsdSpec( src.getOptionalCsXMsgRqstSchemaXsdSpec() );
		setOptionalCsXMsgRqstSchemaXsdElementList( src.getOptionalCsXMsgRqstSchemaXsdElementList() );
		setOptionalCsXMsgRspnSchemaBody( src.getOptionalCsXMsgRspnSchemaBody() );
		setOptionalCsXMsgRspnSchemaUsing( src.getOptionalCsXMsgRspnSchemaUsing() );
		setOptionalCsXMsgRspnSchemaWireParsers( src.getOptionalCsXMsgRspnSchemaWireParsers() );
		setOptionalCsXMsgRspnSchemaXsdElementList( src.getOptionalCsXMsgRspnSchemaXsdElementList() );
		setOptionalCsXMsgRspnSchemaXsdSpec( src.getOptionalCsXMsgRspnSchemaXsdSpec() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamSchemaDefHBuff ) {
			setSchemaDefBuff( (CFBamSchemaDefHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamSchemaDefHBuff" );
		}
	}

	public void setSchemaDefBuff( CFBamSchemaDefHBuff src ) {
		super.setScopeBuff( src );
		setRequiredMinorVersionId( src.getRequiredMinorVersionId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setOptionalDefaultLicenseTenantId( src.getOptionalDefaultLicenseTenantId() );
		setOptionalDefaultLicenseId( src.getOptionalDefaultLicenseId() );
		setRequiredCopyrightPeriod( src.getRequiredCopyrightPeriod() );
		setRequiredCopyrightHolder( src.getRequiredCopyrightHolder() );
		setRequiredAuthorEMail( src.getRequiredAuthorEMail() );
		setRequiredProjectURL( src.getRequiredProjectURL() );
		setRequiredPublishURI( src.getRequiredPublishURI() );
		setOptionalJSchemaObjImport( src.getOptionalJSchemaObjImport() );
		setOptionalJSchemaObjInterface( src.getOptionalJSchemaObjInterface() );
		setOptionalJSchemaObjMembers( src.getOptionalJSchemaObjMembers() );
		setOptionalJSchemaObjImplementation( src.getOptionalJSchemaObjImplementation() );
		setOptionalJDb2LUWSchemaObjMembers( src.getOptionalJDb2LUWSchemaObjMembers() );
		setOptionalJDb2LUWSchemaObjImpl( src.getOptionalJDb2LUWSchemaObjImpl() );
		setOptionalJDb2LUWSchemaObjImport( src.getOptionalJDb2LUWSchemaObjImport() );
		setOptionalJMSSqlSchemaObjMembers( src.getOptionalJMSSqlSchemaObjMembers() );
		setOptionalJMSSqlSchemaObjImpl( src.getOptionalJMSSqlSchemaObjImpl() );
		setOptionalJMSSqlSchemaObjImport( src.getOptionalJMSSqlSchemaObjImport() );
		setOptionalJMySqlSchemaObjMembers( src.getOptionalJMySqlSchemaObjMembers() );
		setOptionalJMySqlSchemaObjImpl( src.getOptionalJMySqlSchemaObjImpl() );
		setOptionalJMySqlSchemaObjImport( src.getOptionalJMySqlSchemaObjImport() );
		setOptionalJOracleSchemaObjMembers( src.getOptionalJOracleSchemaObjMembers() );
		setOptionalJOracleSchemaObjImpl( src.getOptionalJOracleSchemaObjImpl() );
		setOptionalJOracleSchemaObjImport( src.getOptionalJOracleSchemaObjImport() );
		setOptionalJPgSqlSchemaObjMembers( src.getOptionalJPgSqlSchemaObjMembers() );
		setOptionalJPgSqlSchemaObjImpl( src.getOptionalJPgSqlSchemaObjImpl() );
		setOptionalJPgSqlSchemaObjImport( src.getOptionalJPgSqlSchemaObjImport() );
		setOptionalJRamSchemaObjMembers( src.getOptionalJRamSchemaObjMembers() );
		setOptionalJRamSchemaObjImpl( src.getOptionalJRamSchemaObjImpl() );
		setOptionalJRamSchemaObjImport( src.getOptionalJRamSchemaObjImport() );
		setOptionalJXMsgSchemaImport( src.getOptionalJXMsgSchemaImport() );
		setOptionalJXMsgSchemaFormatters( src.getOptionalJXMsgSchemaFormatters() );
		setOptionalJXMsgClientSchemaImport( src.getOptionalJXMsgClientSchemaImport() );
		setOptionalJXMsgClientSchemaBody( src.getOptionalJXMsgClientSchemaBody() );
		setOptionalJXMsgRqstSchemaBody( src.getOptionalJXMsgRqstSchemaBody() );
		setOptionalJXMsgRqstSchemaImport( src.getOptionalJXMsgRqstSchemaImport() );
		setOptionalJXMsgRqstSchemaWireParsers( src.getOptionalJXMsgRqstSchemaWireParsers() );
		setOptionalJXMsgRqstSchemaXsdSpec( src.getOptionalJXMsgRqstSchemaXsdSpec() );
		setOptionalJXMsgRqstSchemaXsdElementList( src.getOptionalJXMsgRqstSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaBody( src.getOptionalJXMsgRspnSchemaBody() );
		setOptionalJXMsgRspnSchemaImport( src.getOptionalJXMsgRspnSchemaImport() );
		setOptionalJXMsgRspnSchemaWireParsers( src.getOptionalJXMsgRspnSchemaWireParsers() );
		setOptionalJXMsgRspnSchemaXsdElementList( src.getOptionalJXMsgRspnSchemaXsdElementList() );
		setOptionalJXMsgRspnSchemaXsdSpec( src.getOptionalJXMsgRspnSchemaXsdSpec() );
		setOptionalCppSchemaObjInclude( src.getOptionalCppSchemaObjInclude() );
		setOptionalCppSchemaObjInterface( src.getOptionalCppSchemaObjInterface() );
		setOptionalCppSchemaObjMembers( src.getOptionalCppSchemaObjMembers() );
		setOptionalCppSchemaObjImplementation( src.getOptionalCppSchemaObjImplementation() );
		setOptionalCppDb2LUWSchemaObjMembers( src.getOptionalCppDb2LUWSchemaObjMembers() );
		setOptionalCppDb2LUWSchemaObjImpl( src.getOptionalCppDb2LUWSchemaObjImpl() );
		setOptionalCppDb2LUWSchemaObjInclude( src.getOptionalCppDb2LUWSchemaObjInclude() );
		setOptionalCppMSSqlSchemaObjMembers( src.getOptionalCppMSSqlSchemaObjMembers() );
		setOptionalCppMSSqlSchemaObjImpl( src.getOptionalCppMSSqlSchemaObjImpl() );
		setOptionalCppMSSqlSchemaObjInclude( src.getOptionalCppMSSqlSchemaObjInclude() );
		setOptionalCppMySqlSchemaObjMembers( src.getOptionalCppMySqlSchemaObjMembers() );
		setOptionalCppMySqlSchemaObjImpl( src.getOptionalCppMySqlSchemaObjImpl() );
		setOptionalCppMySqlSchemaObjInclude( src.getOptionalCppMySqlSchemaObjInclude() );
		setOptionalCppOracleSchemaObjMembers( src.getOptionalCppOracleSchemaObjMembers() );
		setOptionalCppOracleSchemaObjImpl( src.getOptionalCppOracleSchemaObjImpl() );
		setOptionalCppOracleSchemaObjInclude( src.getOptionalCppOracleSchemaObjInclude() );
		setOptionalCppPgSqlSchemaObjMembers( src.getOptionalCppPgSqlSchemaObjMembers() );
		setOptionalCppPgSqlSchemaObjImpl( src.getOptionalCppPgSqlSchemaObjImpl() );
		setOptionalCppPgSqlSchemaObjInclude( src.getOptionalCppPgSqlSchemaObjInclude() );
		setOptionalCppRamSchemaObjMembers( src.getOptionalCppRamSchemaObjMembers() );
		setOptionalCppRamSchemaObjImpl( src.getOptionalCppRamSchemaObjImpl() );
		setOptionalCppRamSchemaObjInclude( src.getOptionalCppRamSchemaObjInclude() );
		setOptionalCppXMsgSchemaInclude( src.getOptionalCppXMsgSchemaInclude() );
		setOptionalCppXMsgSchemaFormatters( src.getOptionalCppXMsgSchemaFormatters() );
		setOptionalCppXMsgClientSchemaInclude( src.getOptionalCppXMsgClientSchemaInclude() );
		setOptionalCppXMsgClientSchemaBody( src.getOptionalCppXMsgClientSchemaBody() );
		setOptionalCppXMsgRqstSchemaBody( src.getOptionalCppXMsgRqstSchemaBody() );
		setOptionalCppXMsgRqstSchemaInclude( src.getOptionalCppXMsgRqstSchemaInclude() );
		setOptionalCppXMsgRqstSchemaWireParsers( src.getOptionalCppXMsgRqstSchemaWireParsers() );
		setOptionalCppXMsgRqstSchemaXsdSpec( src.getOptionalCppXMsgRqstSchemaXsdSpec() );
		setOptionalCppXMsgRqstSchemaXsdElementList( src.getOptionalCppXMsgRqstSchemaXsdElementList() );
		setOptionalCppXMsgRspnSchemaBody( src.getOptionalCppXMsgRspnSchemaBody() );
		setOptionalCppXMsgRspnSchemaInclude( src.getOptionalCppXMsgRspnSchemaInclude() );
		setOptionalCppXMsgRspnSchemaWireParsers( src.getOptionalCppXMsgRspnSchemaWireParsers() );
		setOptionalCppXMsgRspnSchemaXsdElementList( src.getOptionalCppXMsgRspnSchemaXsdElementList() );
		setOptionalCppXMsgRspnSchemaXsdSpec( src.getOptionalCppXMsgRspnSchemaXsdSpec() );
		setOptionalHppSchemaObjInclude( src.getOptionalHppSchemaObjInclude() );
		setOptionalHppSchemaObjInterface( src.getOptionalHppSchemaObjInterface() );
		setOptionalHppSchemaObjMembers( src.getOptionalHppSchemaObjMembers() );
		setOptionalHppSchemaObjImplementation( src.getOptionalHppSchemaObjImplementation() );
		setOptionalHppDb2LUWSchemaObjMembers( src.getOptionalHppDb2LUWSchemaObjMembers() );
		setOptionalHppDb2LUWSchemaObjImpl( src.getOptionalHppDb2LUWSchemaObjImpl() );
		setOptionalHppDb2LUWSchemaObjInclude( src.getOptionalHppDb2LUWSchemaObjInclude() );
		setOptionalHppMSSqlSchemaObjMembers( src.getOptionalHppMSSqlSchemaObjMembers() );
		setOptionalHppMSSqlSchemaObjImpl( src.getOptionalHppMSSqlSchemaObjImpl() );
		setOptionalHppMSSqlSchemaObjInclude( src.getOptionalHppMSSqlSchemaObjInclude() );
		setOptionalHppMySqlSchemaObjMembers( src.getOptionalHppMySqlSchemaObjMembers() );
		setOptionalHppMySqlSchemaObjImpl( src.getOptionalHppMySqlSchemaObjImpl() );
		setOptionalHppMySqlSchemaObjInclude( src.getOptionalHppMySqlSchemaObjInclude() );
		setOptionalHppOracleSchemaObjMembers( src.getOptionalHppOracleSchemaObjMembers() );
		setOptionalHppOracleSchemaObjImpl( src.getOptionalHppOracleSchemaObjImpl() );
		setOptionalHppOracleSchemaObjInclude( src.getOptionalHppOracleSchemaObjInclude() );
		setOptionalHppPgSqlSchemaObjMembers( src.getOptionalHppPgSqlSchemaObjMembers() );
		setOptionalHppPgSqlSchemaObjImpl( src.getOptionalHppPgSqlSchemaObjImpl() );
		setOptionalHppPgSqlSchemaObjInclude( src.getOptionalHppPgSqlSchemaObjInclude() );
		setOptionalHppRamSchemaObjMembers( src.getOptionalHppRamSchemaObjMembers() );
		setOptionalHppRamSchemaObjImpl( src.getOptionalHppRamSchemaObjImpl() );
		setOptionalHppRamSchemaObjInclude( src.getOptionalHppRamSchemaObjInclude() );
		setOptionalHppXMsgSchemaInclude( src.getOptionalHppXMsgSchemaInclude() );
		setOptionalHppXMsgSchemaFormatters( src.getOptionalHppXMsgSchemaFormatters() );
		setOptionalHppXMsgClientSchemaInclude( src.getOptionalHppXMsgClientSchemaInclude() );
		setOptionalHppXMsgClientSchemaBody( src.getOptionalHppXMsgClientSchemaBody() );
		setOptionalHppXMsgRqstSchemaBody( src.getOptionalHppXMsgRqstSchemaBody() );
		setOptionalHppXMsgRqstSchemaInclude( src.getOptionalHppXMsgRqstSchemaInclude() );
		setOptionalHppXMsgRqstSchemaWireParsers( src.getOptionalHppXMsgRqstSchemaWireParsers() );
		setOptionalHppXMsgRqstSchemaXsdSpec( src.getOptionalHppXMsgRqstSchemaXsdSpec() );
		setOptionalHppXMsgRqstSchemaXsdElementList( src.getOptionalHppXMsgRqstSchemaXsdElementList() );
		setOptionalHppXMsgRspnSchemaBody( src.getOptionalHppXMsgRspnSchemaBody() );
		setOptionalHppXMsgRspnSchemaInclude( src.getOptionalHppXMsgRspnSchemaInclude() );
		setOptionalHppXMsgRspnSchemaWireParsers( src.getOptionalHppXMsgRspnSchemaWireParsers() );
		setOptionalHppXMsgRspnSchemaXsdElementList( src.getOptionalHppXMsgRspnSchemaXsdElementList() );
		setOptionalHppXMsgRspnSchemaXsdSpec( src.getOptionalHppXMsgRspnSchemaXsdSpec() );
		setOptionalCsSchemaObjUsing( src.getOptionalCsSchemaObjUsing() );
		setOptionalCsSchemaObjInterface( src.getOptionalCsSchemaObjInterface() );
		setOptionalCsSchemaObjMembers( src.getOptionalCsSchemaObjMembers() );
		setOptionalCsSchemaObjImplementation( src.getOptionalCsSchemaObjImplementation() );
		setOptionalCsDb2LUWSchemaObjMembers( src.getOptionalCsDb2LUWSchemaObjMembers() );
		setOptionalCsDb2LUWSchemaObjImpl( src.getOptionalCsDb2LUWSchemaObjImpl() );
		setOptionalCsDb2LUWSchemaObjUsing( src.getOptionalCsDb2LUWSchemaObjUsing() );
		setOptionalCsMSSqlSchemaObjMembers( src.getOptionalCsMSSqlSchemaObjMembers() );
		setOptionalCsMSSqlSchemaObjImpl( src.getOptionalCsMSSqlSchemaObjImpl() );
		setOptionalCsMSSqlSchemaObjUsing( src.getOptionalCsMSSqlSchemaObjUsing() );
		setOptionalCsMySqlSchemaObjMembers( src.getOptionalCsMySqlSchemaObjMembers() );
		setOptionalCsMySqlSchemaObjImpl( src.getOptionalCsMySqlSchemaObjImpl() );
		setOptionalCsMySqlSchemaObjUsing( src.getOptionalCsMySqlSchemaObjUsing() );
		setOptionalCsOracleSchemaObjMembers( src.getOptionalCsOracleSchemaObjMembers() );
		setOptionalCsOracleSchemaObjImpl( src.getOptionalCsOracleSchemaObjImpl() );
		setOptionalCsOracleSchemaObjUsing( src.getOptionalCsOracleSchemaObjUsing() );
		setOptionalCsPgSqlSchemaObjMembers( src.getOptionalCsPgSqlSchemaObjMembers() );
		setOptionalCsPgSqlSchemaObjImpl( src.getOptionalCsPgSqlSchemaObjImpl() );
		setOptionalCsPgSqlSchemaObjUsing( src.getOptionalCsPgSqlSchemaObjUsing() );
		setOptionalCsRamSchemaObjMembers( src.getOptionalCsRamSchemaObjMembers() );
		setOptionalCsRamSchemaObjImpl( src.getOptionalCsRamSchemaObjImpl() );
		setOptionalCsRamSchemaObjUsing( src.getOptionalCsRamSchemaObjUsing() );
		setOptionalCsXMsgSchemaUsing( src.getOptionalCsXMsgSchemaUsing() );
		setOptionalCsXMsgSchemaFormatters( src.getOptionalCsXMsgSchemaFormatters() );
		setOptionalCsXMsgClientSchemaUsing( src.getOptionalCsXMsgClientSchemaUsing() );
		setOptionalCsXMsgClientSchemaBody( src.getOptionalCsXMsgClientSchemaBody() );
		setOptionalCsXMsgRqstSchemaBody( src.getOptionalCsXMsgRqstSchemaBody() );
		setOptionalCsXMsgRqstSchemaUsing( src.getOptionalCsXMsgRqstSchemaUsing() );
		setOptionalCsXMsgRqstSchemaWireParsers( src.getOptionalCsXMsgRqstSchemaWireParsers() );
		setOptionalCsXMsgRqstSchemaXsdSpec( src.getOptionalCsXMsgRqstSchemaXsdSpec() );
		setOptionalCsXMsgRqstSchemaXsdElementList( src.getOptionalCsXMsgRqstSchemaXsdElementList() );
		setOptionalCsXMsgRspnSchemaBody( src.getOptionalCsXMsgRspnSchemaBody() );
		setOptionalCsXMsgRspnSchemaUsing( src.getOptionalCsXMsgRspnSchemaUsing() );
		setOptionalCsXMsgRspnSchemaWireParsers( src.getOptionalCsXMsgRspnSchemaWireParsers() );
		setOptionalCsXMsgRspnSchemaXsdElementList( src.getOptionalCsXMsgRspnSchemaXsdElementList() );
		setOptionalCsXMsgRspnSchemaXsdSpec( src.getOptionalCsXMsgRspnSchemaXsdSpec() );
	}
}
