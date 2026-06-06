// Description: Java 11 implementation of a Table history buffer object.

/*
 *	org.msscf.msscf.CFBam
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

public class CFBamTableHBuff
	extends CFBamScopeHBuff
	implements Comparable<Object>,
		Serializable
{
	public static final long TENANTID_INIT_VALUE = 0L;
	public static final long SCHEMADEFID_INIT_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_INIT_VALUE = 0L;
	public static final long DEFSCHEMAID_INIT_VALUE = 0L;
	public static final long ID_INIT_VALUE = 0L;
	public static final String NAME_INIT_VALUE = new String( "" );
	public final static boolean PAGEDATA_INIT_VALUE = false;
	public static final long PRIMARYINDEXTENANTID_INIT_VALUE = 0L;
	public static final long PRIMARYINDEXID_INIT_VALUE = 0L;
	public static final String TABLECLASSCODE_INIT_VALUE = new String( "" );
	public static final long LOOKUPINDEXTENANTID_INIT_VALUE = 0L;
	public static final long LOOKUPINDEXID_INIT_VALUE = 0L;
	public static final long ALTINDEXTENANTID_INIT_VALUE = 0L;
	public static final long ALTINDEXID_INIT_VALUE = 0L;
	public static final long QUALIFYINGTENANTID_INIT_VALUE = 0L;
	public static final long QUALIFYINGTABLEID_INIT_VALUE = 0L;
	public final static boolean ISINSTANTIABLE_INIT_VALUE = true;
	public final static boolean HASHISTORY_INIT_VALUE = false;
	public final static boolean HASAUDITCOLUMNS_INIT_VALUE = false;
	public static final ICFBamSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_INIT_VALUE = CFBamSchema.ordinalToLoaderBehaviourEnum( 0 );
	public static final ICFBamSchema.SecScopeEnum SECSCOPE_INIT_VALUE = CFBamSchema.ordinalToSecScopeEnum( 0 );
	public static final String JOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JEDITOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JEDITOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JEDITOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JEDITOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JTABLEINTERFACE_INIT_VALUE = new String( "" );
	public static final String JTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJIMPORT_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String JTABLEOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JDB2LUWTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JDB2LUWTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JDB2LUWTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JMSSQLTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JMSSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMSSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JMYSQLTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JMYSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JMYSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JORACLETABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JORACLETABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JORACLETABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JPGSQLTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JPGSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JPGSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JRAMTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JRAMTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String JRAMTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String JSAXLOADERIMPORT_INIT_VALUE = new String( "" );
	public static final String JSAXLOADERSTARTELEMENT_INIT_VALUE = new String( "" );
	public static final String JSAXLOADERENDELEMENT_INIT_VALUE = new String( "" );
	public static final String JXMSGTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGTABLEFORMATTERS_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTTABLEIMPORT_INIT_VALUE = new String( "" );
	public static final String JXMSGRQSTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String JXMSGRSPNTABLEBODY_INIT_VALUE = new String( "" );
	public static final String JXMSGCLIENTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String CPPOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CPPOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPEDITOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPEDITOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CPPEDITOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPEDITOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPTABLEINTERFACE_INIT_VALUE = new String( "" );
	public static final String CPPTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPTABLEOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPTABLEOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPTABLEOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CPPTABLEOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPDB2LUWTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPDB2LUWTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPDB2LUWTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPMSSQLTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPMSSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPMSSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPMYSQLTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPMYSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPMYSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPORACLETABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPORACLETABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPORACLETABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPPGSQLTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPPGSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPPGSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPRAMTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPRAMTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CPPRAMTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CPPSAXLOADERINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPSAXLOADERSTARTELEMENT_INIT_VALUE = new String( "" );
	public static final String CPPSAXLOADERENDELEMENT_INIT_VALUE = new String( "" );
	public static final String CPPXMSGTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGTABLEFORMATTERS_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGCLIENTTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRQSTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String CPPXMSGRSPNTABLEBODY_INIT_VALUE = new String( "" );
	public static final String CPPXMSGCLIENTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String HPPOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String HPPOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPEDITOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPEDITOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String HPPEDITOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPEDITOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPTABLEINTERFACE_INIT_VALUE = new String( "" );
	public static final String HPPTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPTABLEOBJINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPTABLEOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPTABLEOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String HPPTABLEOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPDB2LUWTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPDB2LUWTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPDB2LUWTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPMSSQLTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPMSSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPMSSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPMYSQLTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPMYSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPMYSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPORACLETABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPORACLETABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPORACLETABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPPGSQLTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPPGSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPPGSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPRAMTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPRAMTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String HPPRAMTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String HPPSAXLOADERINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPSAXLOADERSTARTELEMENT_INIT_VALUE = new String( "" );
	public static final String HPPSAXLOADERENDELEMENT_INIT_VALUE = new String( "" );
	public static final String HPPXMSGTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGTABLEFORMATTERS_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGCLIENTTABLEINCLUDE_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRQSTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String HPPXMSGRSPNTABLEBODY_INIT_VALUE = new String( "" );
	public static final String HPPXMSGCLIENTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String CSOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CSOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSEDITOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSEDITOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CSEDITOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSEDITOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSTABLEINTERFACE_INIT_VALUE = new String( "" );
	public static final String CSTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSTABLEOBJUSING_INIT_VALUE = new String( "" );
	public static final String CSTABLEOBJMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSTABLEOBJINTERFACE_INIT_VALUE = new String( "" );
	public static final String CSTABLEOBJIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSDB2LUWTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSDB2LUWTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSDB2LUWTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSMSSQLTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSMSSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSMSSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSMYSQLTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSMYSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSMYSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSORACLETABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSORACLETABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSORACLETABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSPGSQLTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSPGSQLTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSPGSQLTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSRAMTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSRAMTABLEMEMBERS_INIT_VALUE = new String( "" );
	public static final String CSRAMTABLEIMPLEMENTATION_INIT_VALUE = new String( "" );
	public static final String CSSAXLOADERUSING_INIT_VALUE = new String( "" );
	public static final String CSSAXLOADERSTARTELEMENT_INIT_VALUE = new String( "" );
	public static final String CSSAXLOADERENDELEMENT_INIT_VALUE = new String( "" );
	public static final String CSXMSGTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGTABLEFORMATTERS_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGCLIENTTABLEUSING_INIT_VALUE = new String( "" );
	public static final String CSXMSGRQSTTABLEBODY_INIT_VALUE = new String( "" );
	public static final String CSXMSGRSPNTABLEBODY_INIT_VALUE = new String( "" );
	public static final String CSXMSGCLIENTTABLEBODY_INIT_VALUE = new String( "" );
	public static final long TENANTID_MIN_VALUE = 0L;
	public static final long SCHEMADEFID_MIN_VALUE = 0L;
	public static final long DEFSCHEMATENANTID_MIN_VALUE = 0L;
	public static final long DEFSCHEMAID_MIN_VALUE = 0L;
	public static final long ID_MIN_VALUE = 0L;
	public static final long PRIMARYINDEXTENANTID_MIN_VALUE = 0L;
	public static final long PRIMARYINDEXID_MIN_VALUE = 0L;
	public static final long LOOKUPINDEXTENANTID_MIN_VALUE = 0L;
	public static final long LOOKUPINDEXID_MIN_VALUE = 0L;
	public static final long ALTINDEXTENANTID_MIN_VALUE = 0L;
	public static final long ALTINDEXID_MIN_VALUE = 0L;
	public static final long QUALIFYINGTENANTID_MIN_VALUE = 0L;
	public static final long QUALIFYINGTABLEID_MIN_VALUE = 0L;
	public static final ICFBamSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_MIN_VALUE = ICFBamSchema.LoaderBehaviourEnum.Insert;
	public static final ICFBamSchema.SecScopeEnum SECSCOPE_MIN_VALUE = ICFBamSchema.SecScopeEnum.None;
	public static final ICFBamSchema.LoaderBehaviourEnum LOADERBEHAVIOUR_MAX_VALUE = ICFBamSchema.LoaderBehaviourEnum.Replace;
	public static final ICFBamSchema.SecScopeEnum SECSCOPE_MAX_VALUE = ICFBamSchema.SecScopeEnum.Tenant;

	protected long requiredSchemaDefId;
	protected Long optionalDefSchemaTenantId;
	protected Long optionalDefSchemaId;
	protected String requiredName;
	protected String optionalDbName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected boolean requiredPageData;
	protected Long optionalPrimaryIndexTenantId;
	protected Long optionalPrimaryIndexId;
	protected String requiredTableClassCode;
	protected Long optionalLookupIndexTenantId;
	protected Long optionalLookupIndexId;
	protected Long optionalAltIndexTenantId;
	protected Long optionalAltIndexId;
	protected Long optionalQualifyingTenantId;
	protected Long optionalQualifyingTableId;
	protected boolean requiredIsInstantiable;
	protected boolean requiredHasHistory;
	protected boolean requiredHasAuditColumns;
	protected ICFBamSchema.LoaderBehaviourEnum requiredLoaderBehaviour;
	protected ICFBamSchema.SecScopeEnum requiredSecScope;
	protected String optionalJObjMembers;
	protected String optionalJObjInterface;
	protected String optionalJObjImport;
	protected String optionalJObjImplementation;
	protected String optionalJEditObjMembers;
	protected String optionalJEditObjInterface;
	protected String optionalJEditObjImport;
	protected String optionalJEditObjImplementation;
	protected String optionalJTableImport;
	protected String optionalJTableMembers;
	protected String optionalJTableInterface;
	protected String optionalJTableImplementation;
	protected String optionalJTableObjImport;
	protected String optionalJTableObjMembers;
	protected String optionalJTableObjInterface;
	protected String optionalJTableObjImplementation;
	protected String optionalJDb2LUWTableImport;
	protected String optionalJDb2LUWTableMembers;
	protected String optionalJDb2LUWTableImplementation;
	protected String optionalJMSSqlTableImport;
	protected String optionalJMSSqlTableMembers;
	protected String optionalJMSSqlTableImplementation;
	protected String optionalJMySqlTableImport;
	protected String optionalJMySqlTableMembers;
	protected String optionalJMySqlTableImplementation;
	protected String optionalJOracleTableImport;
	protected String optionalJOracleTableMembers;
	protected String optionalJOracleTableImplementation;
	protected String optionalJPgSqlTableImport;
	protected String optionalJPgSqlTableMembers;
	protected String optionalJPgSqlTableImplementation;
	protected String optionalJRamTableImport;
	protected String optionalJRamTableMembers;
	protected String optionalJRamTableImplementation;
	protected String optionalJSaxLoaderImport;
	protected String optionalJSaxLoaderStartElement;
	protected String optionalJSaxLoaderEndElement;
	protected String optionalJXMsgTableImport;
	protected String optionalJXMsgTableFormatters;
	protected String optionalJXMsgRqstTableImport;
	protected String optionalJXMsgRspnTableImport;
	protected String optionalJXMsgClientTableImport;
	protected String optionalJXMsgRqstTableBody;
	protected String optionalJXMsgRspnTableBody;
	protected String optionalJXMsgClientTableBody;
	protected String optionalCppObjMembers;
	protected String optionalCppObjInterface;
	protected String optionalCppObjInclude;
	protected String optionalCppObjImplementation;
	protected String optionalCppEditObjMembers;
	protected String optionalCppEditObjInterface;
	protected String optionalCppEditObjInclude;
	protected String optionalCppEditObjImplementation;
	protected String optionalCppTableInclude;
	protected String optionalCppTableMembers;
	protected String optionalCppTableInterface;
	protected String optionalCppTableImplementation;
	protected String optionalCppTableObjInclude;
	protected String optionalCppTableObjMembers;
	protected String optionalCppTableObjInterface;
	protected String optionalCppTableObjImplementation;
	protected String optionalCppDb2LUWTableInclude;
	protected String optionalCppDb2LUWTableMembers;
	protected String optionalCppDb2LUWTableImplementation;
	protected String optionalCppMSSqlTableInclude;
	protected String optionalCppMSSqlTableMembers;
	protected String optionalCppMSSqlTableImplementation;
	protected String optionalCppMySqlTableInclude;
	protected String optionalCppMySqlTableMembers;
	protected String optionalCppMySqlTableImplementation;
	protected String optionalCppOracleTableInclude;
	protected String optionalCppOracleTableMembers;
	protected String optionalCppOracleTableImplementation;
	protected String optionalCppPgSqlTableInclude;
	protected String optionalCppPgSqlTableMembers;
	protected String optionalCppPgSqlTableImplementation;
	protected String optionalCppRamTableInclude;
	protected String optionalCppRamTableMembers;
	protected String optionalCppRamTableImplementation;
	protected String optionalCppSaxLoaderInclude;
	protected String optionalCppSaxLoaderStartElement;
	protected String optionalCppSaxLoaderEndElement;
	protected String optionalCppXMsgTableInclude;
	protected String optionalCppXMsgTableFormatters;
	protected String optionalCppXMsgRqstTableInclude;
	protected String optionalCppXMsgRspnTableInclude;
	protected String optionalCppXMsgClientTableInclude;
	protected String optionalCppXMsgRqstTableBody;
	protected String optionalCppXMsgRspnTableBody;
	protected String optionalCppXMsgClientTableBody;
	protected String optionalHppObjMembers;
	protected String optionalHppObjInterface;
	protected String optionalHppObjInclude;
	protected String optionalHppObjImplementation;
	protected String optionalHppEditObjMembers;
	protected String optionalHppEditObjInterface;
	protected String optionalHppEditObjInclude;
	protected String optionalHppEditObjImplementation;
	protected String optionalHppTableInclude;
	protected String optionalHppTableMembers;
	protected String optionalHppTableInterface;
	protected String optionalHppTableImplementation;
	protected String optionalHppTableObjInclude;
	protected String optionalHppTableObjMembers;
	protected String optionalHppTableObjInterface;
	protected String optionalHppTableObjImplementation;
	protected String optionalHppDb2LUWTableInclude;
	protected String optionalHppDb2LUWTableMembers;
	protected String optionalHppDb2LUWTableImplementation;
	protected String optionalHppMSSqlTableInclude;
	protected String optionalHppMSSqlTableMembers;
	protected String optionalHppMSSqlTableImplementation;
	protected String optionalHppMySqlTableInclude;
	protected String optionalHppMySqlTableMembers;
	protected String optionalHppMySqlTableImplementation;
	protected String optionalHppOracleTableInclude;
	protected String optionalHppOracleTableMembers;
	protected String optionalHppOracleTableImplementation;
	protected String optionalHppPgSqlTableInclude;
	protected String optionalHppPgSqlTableMembers;
	protected String optionalHppPgSqlTableImplementation;
	protected String optionalHppRamTableInclude;
	protected String optionalHppRamTableMembers;
	protected String optionalHppRamTableImplementation;
	protected String optionalHppSaxLoaderInclude;
	protected String optionalHppSaxLoaderStartElement;
	protected String optionalHppSaxLoaderEndElement;
	protected String optionalHppXMsgTableInclude;
	protected String optionalHppXMsgTableFormatters;
	protected String optionalHppXMsgRqstTableInclude;
	protected String optionalHppXMsgRspnTableInclude;
	protected String optionalHppXMsgClientTableInclude;
	protected String optionalHppXMsgRqstTableBody;
	protected String optionalHppXMsgRspnTableBody;
	protected String optionalHppXMsgClientTableBody;
	protected String optionalCsObjMembers;
	protected String optionalCsObjInterface;
	protected String optionalCsObjUsing;
	protected String optionalCsObjImplementation;
	protected String optionalCsEditObjMembers;
	protected String optionalCsEditObjInterface;
	protected String optionalCsEditObjUsing;
	protected String optionalCsEditObjImplementation;
	protected String optionalCsTableUsing;
	protected String optionalCsTableMembers;
	protected String optionalCsTableInterface;
	protected String optionalCsTableImplementation;
	protected String optionalCsTableObjUsing;
	protected String optionalCsTableObjMembers;
	protected String optionalCsTableObjInterface;
	protected String optionalCsTableObjImplementation;
	protected String optionalCsDb2LUWTableUsing;
	protected String optionalCsDb2LUWTableMembers;
	protected String optionalCsDb2LUWTableImplementation;
	protected String optionalCsMSSqlTableUsing;
	protected String optionalCsMSSqlTableMembers;
	protected String optionalCsMSSqlTableImplementation;
	protected String optionalCsMySqlTableUsing;
	protected String optionalCsMySqlTableMembers;
	protected String optionalCsMySqlTableImplementation;
	protected String optionalCsOracleTableUsing;
	protected String optionalCsOracleTableMembers;
	protected String optionalCsOracleTableImplementation;
	protected String optionalCsPgSqlTableUsing;
	protected String optionalCsPgSqlTableMembers;
	protected String optionalCsPgSqlTableImplementation;
	protected String optionalCsRamTableUsing;
	protected String optionalCsRamTableMembers;
	protected String optionalCsRamTableImplementation;
	protected String optionalCsSaxLoaderUsing;
	protected String optionalCsSaxLoaderStartElement;
	protected String optionalCsSaxLoaderEndElement;
	protected String optionalCsXMsgTableUsing;
	protected String optionalCsXMsgTableFormatters;
	protected String optionalCsXMsgRqstTableUsing;
	protected String optionalCsXMsgRspnTableUsing;
	protected String optionalCsXMsgClientTableUsing;
	protected String optionalCsXMsgRqstTableBody;
	protected String optionalCsXMsgRspnTableBody;
	protected String optionalCsXMsgClientTableBody;
	public CFBamTableHBuff() {
		super();
		requiredSchemaDefId = CFBamTableBuff.SCHEMADEFID_INIT_VALUE;
		optionalDefSchemaTenantId = null;
		optionalDefSchemaId = null;
		requiredName = new String( CFBamTableBuff.NAME_INIT_VALUE );
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredPageData = CFBamTableBuff.PAGEDATA_INIT_VALUE;
		optionalPrimaryIndexTenantId = null;
		optionalPrimaryIndexId = null;
		requiredTableClassCode = new String( CFBamTableBuff.TABLECLASSCODE_INIT_VALUE );
		optionalLookupIndexTenantId = null;
		optionalLookupIndexId = null;
		optionalAltIndexTenantId = null;
		optionalAltIndexId = null;
		optionalQualifyingTenantId = null;
		optionalQualifyingTableId = null;
		requiredIsInstantiable = CFBamTableBuff.ISINSTANTIABLE_INIT_VALUE;
		requiredHasHistory = CFBamTableBuff.HASHISTORY_INIT_VALUE;
		requiredHasAuditColumns = CFBamTableBuff.HASAUDITCOLUMNS_INIT_VALUE;
		requiredLoaderBehaviour = CFBamTableBuff.LOADERBEHAVIOUR_INIT_VALUE;
		requiredSecScope = CFBamTableBuff.SECSCOPE_INIT_VALUE;
		optionalJObjMembers = null;
		optionalJObjInterface = null;
		optionalJObjImport = null;
		optionalJObjImplementation = null;
		optionalJEditObjMembers = null;
		optionalJEditObjInterface = null;
		optionalJEditObjImport = null;
		optionalJEditObjImplementation = null;
		optionalJTableImport = null;
		optionalJTableMembers = null;
		optionalJTableInterface = null;
		optionalJTableImplementation = null;
		optionalJTableObjImport = null;
		optionalJTableObjMembers = null;
		optionalJTableObjInterface = null;
		optionalJTableObjImplementation = null;
		optionalJDb2LUWTableImport = null;
		optionalJDb2LUWTableMembers = null;
		optionalJDb2LUWTableImplementation = null;
		optionalJMSSqlTableImport = null;
		optionalJMSSqlTableMembers = null;
		optionalJMSSqlTableImplementation = null;
		optionalJMySqlTableImport = null;
		optionalJMySqlTableMembers = null;
		optionalJMySqlTableImplementation = null;
		optionalJOracleTableImport = null;
		optionalJOracleTableMembers = null;
		optionalJOracleTableImplementation = null;
		optionalJPgSqlTableImport = null;
		optionalJPgSqlTableMembers = null;
		optionalJPgSqlTableImplementation = null;
		optionalJRamTableImport = null;
		optionalJRamTableMembers = null;
		optionalJRamTableImplementation = null;
		optionalJSaxLoaderImport = null;
		optionalJSaxLoaderStartElement = null;
		optionalJSaxLoaderEndElement = null;
		optionalJXMsgTableImport = null;
		optionalJXMsgTableFormatters = null;
		optionalJXMsgRqstTableImport = null;
		optionalJXMsgRspnTableImport = null;
		optionalJXMsgClientTableImport = null;
		optionalJXMsgRqstTableBody = null;
		optionalJXMsgRspnTableBody = null;
		optionalJXMsgClientTableBody = null;
		optionalCppObjMembers = null;
		optionalCppObjInterface = null;
		optionalCppObjInclude = null;
		optionalCppObjImplementation = null;
		optionalCppEditObjMembers = null;
		optionalCppEditObjInterface = null;
		optionalCppEditObjInclude = null;
		optionalCppEditObjImplementation = null;
		optionalCppTableInclude = null;
		optionalCppTableMembers = null;
		optionalCppTableInterface = null;
		optionalCppTableImplementation = null;
		optionalCppTableObjInclude = null;
		optionalCppTableObjMembers = null;
		optionalCppTableObjInterface = null;
		optionalCppTableObjImplementation = null;
		optionalCppDb2LUWTableInclude = null;
		optionalCppDb2LUWTableMembers = null;
		optionalCppDb2LUWTableImplementation = null;
		optionalCppMSSqlTableInclude = null;
		optionalCppMSSqlTableMembers = null;
		optionalCppMSSqlTableImplementation = null;
		optionalCppMySqlTableInclude = null;
		optionalCppMySqlTableMembers = null;
		optionalCppMySqlTableImplementation = null;
		optionalCppOracleTableInclude = null;
		optionalCppOracleTableMembers = null;
		optionalCppOracleTableImplementation = null;
		optionalCppPgSqlTableInclude = null;
		optionalCppPgSqlTableMembers = null;
		optionalCppPgSqlTableImplementation = null;
		optionalCppRamTableInclude = null;
		optionalCppRamTableMembers = null;
		optionalCppRamTableImplementation = null;
		optionalCppSaxLoaderInclude = null;
		optionalCppSaxLoaderStartElement = null;
		optionalCppSaxLoaderEndElement = null;
		optionalCppXMsgTableInclude = null;
		optionalCppXMsgTableFormatters = null;
		optionalCppXMsgRqstTableInclude = null;
		optionalCppXMsgRspnTableInclude = null;
		optionalCppXMsgClientTableInclude = null;
		optionalCppXMsgRqstTableBody = null;
		optionalCppXMsgRspnTableBody = null;
		optionalCppXMsgClientTableBody = null;
		optionalHppObjMembers = null;
		optionalHppObjInterface = null;
		optionalHppObjInclude = null;
		optionalHppObjImplementation = null;
		optionalHppEditObjMembers = null;
		optionalHppEditObjInterface = null;
		optionalHppEditObjInclude = null;
		optionalHppEditObjImplementation = null;
		optionalHppTableInclude = null;
		optionalHppTableMembers = null;
		optionalHppTableInterface = null;
		optionalHppTableImplementation = null;
		optionalHppTableObjInclude = null;
		optionalHppTableObjMembers = null;
		optionalHppTableObjInterface = null;
		optionalHppTableObjImplementation = null;
		optionalHppDb2LUWTableInclude = null;
		optionalHppDb2LUWTableMembers = null;
		optionalHppDb2LUWTableImplementation = null;
		optionalHppMSSqlTableInclude = null;
		optionalHppMSSqlTableMembers = null;
		optionalHppMSSqlTableImplementation = null;
		optionalHppMySqlTableInclude = null;
		optionalHppMySqlTableMembers = null;
		optionalHppMySqlTableImplementation = null;
		optionalHppOracleTableInclude = null;
		optionalHppOracleTableMembers = null;
		optionalHppOracleTableImplementation = null;
		optionalHppPgSqlTableInclude = null;
		optionalHppPgSqlTableMembers = null;
		optionalHppPgSqlTableImplementation = null;
		optionalHppRamTableInclude = null;
		optionalHppRamTableMembers = null;
		optionalHppRamTableImplementation = null;
		optionalHppSaxLoaderInclude = null;
		optionalHppSaxLoaderStartElement = null;
		optionalHppSaxLoaderEndElement = null;
		optionalHppXMsgTableInclude = null;
		optionalHppXMsgTableFormatters = null;
		optionalHppXMsgRqstTableInclude = null;
		optionalHppXMsgRspnTableInclude = null;
		optionalHppXMsgClientTableInclude = null;
		optionalHppXMsgRqstTableBody = null;
		optionalHppXMsgRspnTableBody = null;
		optionalHppXMsgClientTableBody = null;
		optionalCsObjMembers = null;
		optionalCsObjInterface = null;
		optionalCsObjUsing = null;
		optionalCsObjImplementation = null;
		optionalCsEditObjMembers = null;
		optionalCsEditObjInterface = null;
		optionalCsEditObjUsing = null;
		optionalCsEditObjImplementation = null;
		optionalCsTableUsing = null;
		optionalCsTableMembers = null;
		optionalCsTableInterface = null;
		optionalCsTableImplementation = null;
		optionalCsTableObjUsing = null;
		optionalCsTableObjMembers = null;
		optionalCsTableObjInterface = null;
		optionalCsTableObjImplementation = null;
		optionalCsDb2LUWTableUsing = null;
		optionalCsDb2LUWTableMembers = null;
		optionalCsDb2LUWTableImplementation = null;
		optionalCsMSSqlTableUsing = null;
		optionalCsMSSqlTableMembers = null;
		optionalCsMSSqlTableImplementation = null;
		optionalCsMySqlTableUsing = null;
		optionalCsMySqlTableMembers = null;
		optionalCsMySqlTableImplementation = null;
		optionalCsOracleTableUsing = null;
		optionalCsOracleTableMembers = null;
		optionalCsOracleTableImplementation = null;
		optionalCsPgSqlTableUsing = null;
		optionalCsPgSqlTableMembers = null;
		optionalCsPgSqlTableImplementation = null;
		optionalCsRamTableUsing = null;
		optionalCsRamTableMembers = null;
		optionalCsRamTableImplementation = null;
		optionalCsSaxLoaderUsing = null;
		optionalCsSaxLoaderStartElement = null;
		optionalCsSaxLoaderEndElement = null;
		optionalCsXMsgTableUsing = null;
		optionalCsXMsgTableFormatters = null;
		optionalCsXMsgRqstTableUsing = null;
		optionalCsXMsgRspnTableUsing = null;
		optionalCsXMsgClientTableUsing = null;
		optionalCsXMsgRqstTableBody = null;
		optionalCsXMsgRspnTableBody = null;
		optionalCsXMsgClientTableBody = null;
	}

	public String getClassCode() {
		return( CFBamTableBuff.CLASS_CODE );
	}

	public long getRequiredSchemaDefId() {
		return( requiredSchemaDefId );
	}

	public void setRequiredSchemaDefId( long value ) {
		if( value < CFBamTableBuff.SCHEMADEFID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredSchemaDefId",
				1,
				"value",
				value,
				CFBamTableBuff.SCHEMADEFID_MIN_VALUE );
		}
		requiredSchemaDefId = value;
	}

	public Long getOptionalDefSchemaTenantId() {
		return( optionalDefSchemaTenantId );
	}

	public void setOptionalDefSchemaTenantId( Long value ) {
		if( value == null ) {
			optionalDefSchemaTenantId = null;
		}
		else if( value < CFBamTableBuff.DEFSCHEMATENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.DEFSCHEMATENANTID_MIN_VALUE );
		}
		else {
			optionalDefSchemaTenantId = value;
		}
	}

	public Long getOptionalDefSchemaId() {
		return( optionalDefSchemaId );
	}

	public void setOptionalDefSchemaId( Long value ) {
		if( value == null ) {
			optionalDefSchemaId = null;
		}
		else if( value < CFBamTableBuff.DEFSCHEMAID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalDefSchemaId",
				1,
				"value",
				value,
				CFBamTableBuff.DEFSCHEMAID_MIN_VALUE );
		}
		else {
			optionalDefSchemaId = value;
		}
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
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				32 );
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
		else if( value.length() > 50 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				50 );
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
		else if( value.length() > 100 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				100 );
		}
		else {
			optionalDescription = value;
		}
	}

	public boolean getRequiredPageData() {
		return( requiredPageData );
	}

	public void setRequiredPageData( boolean value ) {
		requiredPageData = value;
	}

	public Long getOptionalPrimaryIndexTenantId() {
		return( optionalPrimaryIndexTenantId );
	}

	public void setOptionalPrimaryIndexTenantId( Long value ) {
		if( value == null ) {
			optionalPrimaryIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.PRIMARYINDEXTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrimaryIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.PRIMARYINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalPrimaryIndexTenantId = value;
		}
	}

	public Long getOptionalPrimaryIndexId() {
		return( optionalPrimaryIndexId );
	}

	public void setOptionalPrimaryIndexId( Long value ) {
		if( value == null ) {
			optionalPrimaryIndexId = null;
		}
		else if( value < CFBamTableBuff.PRIMARYINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalPrimaryIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.PRIMARYINDEXID_MIN_VALUE );
		}
		else {
			optionalPrimaryIndexId = value;
		}
	}

	public String getRequiredTableClassCode() {
		return( requiredTableClassCode );
	}

	public void setRequiredTableClassCode( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredTableClassCode",
				1,
				"value" );
		}
		if( value.length() > 4 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredTableClassCode",
				1,
				"value.length()",
				value.length(),
				4 );
		}
		requiredTableClassCode = value;
	}

	public Long getOptionalLookupIndexTenantId() {
		return( optionalLookupIndexTenantId );
	}

	public void setOptionalLookupIndexTenantId( Long value ) {
		if( value == null ) {
			optionalLookupIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.LOOKUPINDEXTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLookupIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.LOOKUPINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalLookupIndexTenantId = value;
		}
	}

	public Long getOptionalLookupIndexId() {
		return( optionalLookupIndexId );
	}

	public void setOptionalLookupIndexId( Long value ) {
		if( value == null ) {
			optionalLookupIndexId = null;
		}
		else if( value < CFBamTableBuff.LOOKUPINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalLookupIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.LOOKUPINDEXID_MIN_VALUE );
		}
		else {
			optionalLookupIndexId = value;
		}
	}

	public Long getOptionalAltIndexTenantId() {
		return( optionalAltIndexTenantId );
	}

	public void setOptionalAltIndexTenantId( Long value ) {
		if( value == null ) {
			optionalAltIndexTenantId = null;
		}
		else if( value < CFBamTableBuff.ALTINDEXTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalAltIndexTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.ALTINDEXTENANTID_MIN_VALUE );
		}
		else {
			optionalAltIndexTenantId = value;
		}
	}

	public Long getOptionalAltIndexId() {
		return( optionalAltIndexId );
	}

	public void setOptionalAltIndexId( Long value ) {
		if( value == null ) {
			optionalAltIndexId = null;
		}
		else if( value < CFBamTableBuff.ALTINDEXID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalAltIndexId",
				1,
				"value",
				value,
				CFBamTableBuff.ALTINDEXID_MIN_VALUE );
		}
		else {
			optionalAltIndexId = value;
		}
	}

	public Long getOptionalQualifyingTenantId() {
		return( optionalQualifyingTenantId );
	}

	public void setOptionalQualifyingTenantId( Long value ) {
		if( value == null ) {
			optionalQualifyingTenantId = null;
		}
		else if( value < CFBamTableBuff.QUALIFYINGTENANTID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalQualifyingTenantId",
				1,
				"value",
				value,
				CFBamTableBuff.QUALIFYINGTENANTID_MIN_VALUE );
		}
		else {
			optionalQualifyingTenantId = value;
		}
	}

	public Long getOptionalQualifyingTableId() {
		return( optionalQualifyingTableId );
	}

	public void setOptionalQualifyingTableId( Long value ) {
		if( value == null ) {
			optionalQualifyingTableId = null;
		}
		else if( value < CFBamTableBuff.QUALIFYINGTABLEID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setOptionalQualifyingTableId",
				1,
				"value",
				value,
				CFBamTableBuff.QUALIFYINGTABLEID_MIN_VALUE );
		}
		else {
			optionalQualifyingTableId = value;
		}
	}

	public boolean getRequiredIsInstantiable() {
		return( requiredIsInstantiable );
	}

	public void setRequiredIsInstantiable( boolean value ) {
		requiredIsInstantiable = value;
	}

	public boolean getRequiredHasHistory() {
		return( requiredHasHistory );
	}

	public void setRequiredHasHistory( boolean value ) {
		requiredHasHistory = value;
	}

	public boolean getRequiredHasAuditColumns() {
		return( requiredHasAuditColumns );
	}

	public void setRequiredHasAuditColumns( boolean value ) {
		requiredHasAuditColumns = value;
	}

	public ICFBamSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour() {
		return( requiredLoaderBehaviour );
	}

	public void setRequiredLoaderBehaviour( ICFBamSchema.LoaderBehaviourEnum value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredLoaderBehaviour",
				1,
				"value" );
		}
		requiredLoaderBehaviour = value;
	}

	public ICFBamSchema.SecScopeEnum getRequiredSecScope() {
		return( requiredSecScope );
	}

	public void setRequiredSecScope( ICFBamSchema.SecScopeEnum value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecScope",
				1,
				"value" );
		}
		requiredSecScope = value;
	}

	public String getOptionalJObjMembers() {
		return( optionalJObjMembers );
	}

	public void setOptionalJObjMembers( String value ) {
		if( value == null ) {
			optionalJObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjMembers = value;
		}
	}

	public String getOptionalJObjInterface() {
		return( optionalJObjInterface );
	}

	public void setOptionalJObjInterface( String value ) {
		if( value == null ) {
			optionalJObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjInterface = value;
		}
	}

	public String getOptionalJObjImport() {
		return( optionalJObjImport );
	}

	public void setOptionalJObjImport( String value ) {
		if( value == null ) {
			optionalJObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjImport = value;
		}
	}

	public String getOptionalJObjImplementation() {
		return( optionalJObjImplementation );
	}

	public void setOptionalJObjImplementation( String value ) {
		if( value == null ) {
			optionalJObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJObjImplementation = value;
		}
	}

	public String getOptionalJEditObjMembers() {
		return( optionalJEditObjMembers );
	}

	public void setOptionalJEditObjMembers( String value ) {
		if( value == null ) {
			optionalJEditObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJEditObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjMembers = value;
		}
	}

	public String getOptionalJEditObjInterface() {
		return( optionalJEditObjInterface );
	}

	public void setOptionalJEditObjInterface( String value ) {
		if( value == null ) {
			optionalJEditObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJEditObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjInterface = value;
		}
	}

	public String getOptionalJEditObjImport() {
		return( optionalJEditObjImport );
	}

	public void setOptionalJEditObjImport( String value ) {
		if( value == null ) {
			optionalJEditObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJEditObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjImport = value;
		}
	}

	public String getOptionalJEditObjImplementation() {
		return( optionalJEditObjImplementation );
	}

	public void setOptionalJEditObjImplementation( String value ) {
		if( value == null ) {
			optionalJEditObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJEditObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJEditObjImplementation = value;
		}
	}

	public String getOptionalJTableImport() {
		return( optionalJTableImport );
	}

	public void setOptionalJTableImport( String value ) {
		if( value == null ) {
			optionalJTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableImport = value;
		}
	}

	public String getOptionalJTableMembers() {
		return( optionalJTableMembers );
	}

	public void setOptionalJTableMembers( String value ) {
		if( value == null ) {
			optionalJTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableMembers = value;
		}
	}

	public String getOptionalJTableInterface() {
		return( optionalJTableInterface );
	}

	public void setOptionalJTableInterface( String value ) {
		if( value == null ) {
			optionalJTableInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableInterface = value;
		}
	}

	public String getOptionalJTableImplementation() {
		return( optionalJTableImplementation );
	}

	public void setOptionalJTableImplementation( String value ) {
		if( value == null ) {
			optionalJTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableImplementation = value;
		}
	}

	public String getOptionalJTableObjImport() {
		return( optionalJTableObjImport );
	}

	public void setOptionalJTableObjImport( String value ) {
		if( value == null ) {
			optionalJTableObjImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableObjImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjImport = value;
		}
	}

	public String getOptionalJTableObjMembers() {
		return( optionalJTableObjMembers );
	}

	public void setOptionalJTableObjMembers( String value ) {
		if( value == null ) {
			optionalJTableObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjMembers = value;
		}
	}

	public String getOptionalJTableObjInterface() {
		return( optionalJTableObjInterface );
	}

	public void setOptionalJTableObjInterface( String value ) {
		if( value == null ) {
			optionalJTableObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjInterface = value;
		}
	}

	public String getOptionalJTableObjImplementation() {
		return( optionalJTableObjImplementation );
	}

	public void setOptionalJTableObjImplementation( String value ) {
		if( value == null ) {
			optionalJTableObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJTableObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJTableObjImplementation = value;
		}
	}

	public String getOptionalJDb2LUWTableImport() {
		return( optionalJDb2LUWTableImport );
	}

	public void setOptionalJDb2LUWTableImport( String value ) {
		if( value == null ) {
			optionalJDb2LUWTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWTableImport = value;
		}
	}

	public String getOptionalJDb2LUWTableMembers() {
		return( optionalJDb2LUWTableMembers );
	}

	public void setOptionalJDb2LUWTableMembers( String value ) {
		if( value == null ) {
			optionalJDb2LUWTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWTableMembers = value;
		}
	}

	public String getOptionalJDb2LUWTableImplementation() {
		return( optionalJDb2LUWTableImplementation );
	}

	public void setOptionalJDb2LUWTableImplementation( String value ) {
		if( value == null ) {
			optionalJDb2LUWTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJDb2LUWTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJDb2LUWTableImplementation = value;
		}
	}

	public String getOptionalJMSSqlTableImport() {
		return( optionalJMSSqlTableImport );
	}

	public void setOptionalJMSSqlTableImport( String value ) {
		if( value == null ) {
			optionalJMSSqlTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMSSqlTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlTableImport = value;
		}
	}

	public String getOptionalJMSSqlTableMembers() {
		return( optionalJMSSqlTableMembers );
	}

	public void setOptionalJMSSqlTableMembers( String value ) {
		if( value == null ) {
			optionalJMSSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMSSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlTableMembers = value;
		}
	}

	public String getOptionalJMSSqlTableImplementation() {
		return( optionalJMSSqlTableImplementation );
	}

	public void setOptionalJMSSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalJMSSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMSSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMSSqlTableImplementation = value;
		}
	}

	public String getOptionalJMySqlTableImport() {
		return( optionalJMySqlTableImport );
	}

	public void setOptionalJMySqlTableImport( String value ) {
		if( value == null ) {
			optionalJMySqlTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMySqlTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlTableImport = value;
		}
	}

	public String getOptionalJMySqlTableMembers() {
		return( optionalJMySqlTableMembers );
	}

	public void setOptionalJMySqlTableMembers( String value ) {
		if( value == null ) {
			optionalJMySqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMySqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlTableMembers = value;
		}
	}

	public String getOptionalJMySqlTableImplementation() {
		return( optionalJMySqlTableImplementation );
	}

	public void setOptionalJMySqlTableImplementation( String value ) {
		if( value == null ) {
			optionalJMySqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJMySqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJMySqlTableImplementation = value;
		}
	}

	public String getOptionalJOracleTableImport() {
		return( optionalJOracleTableImport );
	}

	public void setOptionalJOracleTableImport( String value ) {
		if( value == null ) {
			optionalJOracleTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJOracleTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleTableImport = value;
		}
	}

	public String getOptionalJOracleTableMembers() {
		return( optionalJOracleTableMembers );
	}

	public void setOptionalJOracleTableMembers( String value ) {
		if( value == null ) {
			optionalJOracleTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJOracleTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleTableMembers = value;
		}
	}

	public String getOptionalJOracleTableImplementation() {
		return( optionalJOracleTableImplementation );
	}

	public void setOptionalJOracleTableImplementation( String value ) {
		if( value == null ) {
			optionalJOracleTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJOracleTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJOracleTableImplementation = value;
		}
	}

	public String getOptionalJPgSqlTableImport() {
		return( optionalJPgSqlTableImport );
	}

	public void setOptionalJPgSqlTableImport( String value ) {
		if( value == null ) {
			optionalJPgSqlTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJPgSqlTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlTableImport = value;
		}
	}

	public String getOptionalJPgSqlTableMembers() {
		return( optionalJPgSqlTableMembers );
	}

	public void setOptionalJPgSqlTableMembers( String value ) {
		if( value == null ) {
			optionalJPgSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJPgSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlTableMembers = value;
		}
	}

	public String getOptionalJPgSqlTableImplementation() {
		return( optionalJPgSqlTableImplementation );
	}

	public void setOptionalJPgSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalJPgSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJPgSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJPgSqlTableImplementation = value;
		}
	}

	public String getOptionalJRamTableImport() {
		return( optionalJRamTableImport );
	}

	public void setOptionalJRamTableImport( String value ) {
		if( value == null ) {
			optionalJRamTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJRamTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamTableImport = value;
		}
	}

	public String getOptionalJRamTableMembers() {
		return( optionalJRamTableMembers );
	}

	public void setOptionalJRamTableMembers( String value ) {
		if( value == null ) {
			optionalJRamTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJRamTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamTableMembers = value;
		}
	}

	public String getOptionalJRamTableImplementation() {
		return( optionalJRamTableImplementation );
	}

	public void setOptionalJRamTableImplementation( String value ) {
		if( value == null ) {
			optionalJRamTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJRamTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJRamTableImplementation = value;
		}
	}

	public String getOptionalJSaxLoaderImport() {
		return( optionalJSaxLoaderImport );
	}

	public void setOptionalJSaxLoaderImport( String value ) {
		if( value == null ) {
			optionalJSaxLoaderImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSaxLoaderImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSaxLoaderImport = value;
		}
	}

	public String getOptionalJSaxLoaderStartElement() {
		return( optionalJSaxLoaderStartElement );
	}

	public void setOptionalJSaxLoaderStartElement( String value ) {
		if( value == null ) {
			optionalJSaxLoaderStartElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSaxLoaderStartElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSaxLoaderStartElement = value;
		}
	}

	public String getOptionalJSaxLoaderEndElement() {
		return( optionalJSaxLoaderEndElement );
	}

	public void setOptionalJSaxLoaderEndElement( String value ) {
		if( value == null ) {
			optionalJSaxLoaderEndElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJSaxLoaderEndElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJSaxLoaderEndElement = value;
		}
	}

	public String getOptionalJXMsgTableImport() {
		return( optionalJXMsgTableImport );
	}

	public void setOptionalJXMsgTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgTableImport = value;
		}
	}

	public String getOptionalJXMsgTableFormatters() {
		return( optionalJXMsgTableFormatters );
	}

	public void setOptionalJXMsgTableFormatters( String value ) {
		if( value == null ) {
			optionalJXMsgTableFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgTableFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgTableFormatters = value;
		}
	}

	public String getOptionalJXMsgRqstTableImport() {
		return( optionalJXMsgRqstTableImport );
	}

	public void setOptionalJXMsgRqstTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgRqstTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstTableImport = value;
		}
	}

	public String getOptionalJXMsgRspnTableImport() {
		return( optionalJXMsgRspnTableImport );
	}

	public void setOptionalJXMsgRspnTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgRspnTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnTableImport = value;
		}
	}

	public String getOptionalJXMsgClientTableImport() {
		return( optionalJXMsgClientTableImport );
	}

	public void setOptionalJXMsgClientTableImport( String value ) {
		if( value == null ) {
			optionalJXMsgClientTableImport = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientTableImport",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientTableImport = value;
		}
	}

	public String getOptionalJXMsgRqstTableBody() {
		return( optionalJXMsgRqstTableBody );
	}

	public void setOptionalJXMsgRqstTableBody( String value ) {
		if( value == null ) {
			optionalJXMsgRqstTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRqstTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRqstTableBody = value;
		}
	}

	public String getOptionalJXMsgRspnTableBody() {
		return( optionalJXMsgRspnTableBody );
	}

	public void setOptionalJXMsgRspnTableBody( String value ) {
		if( value == null ) {
			optionalJXMsgRspnTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgRspnTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgRspnTableBody = value;
		}
	}

	public String getOptionalJXMsgClientTableBody() {
		return( optionalJXMsgClientTableBody );
	}

	public void setOptionalJXMsgClientTableBody( String value ) {
		if( value == null ) {
			optionalJXMsgClientTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalJXMsgClientTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalJXMsgClientTableBody = value;
		}
	}

	public String getOptionalCppObjMembers() {
		return( optionalCppObjMembers );
	}

	public void setOptionalCppObjMembers( String value ) {
		if( value == null ) {
			optionalCppObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppObjMembers = value;
		}
	}

	public String getOptionalCppObjInterface() {
		return( optionalCppObjInterface );
	}

	public void setOptionalCppObjInterface( String value ) {
		if( value == null ) {
			optionalCppObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppObjInterface = value;
		}
	}

	public String getOptionalCppObjInclude() {
		return( optionalCppObjInclude );
	}

	public void setOptionalCppObjInclude( String value ) {
		if( value == null ) {
			optionalCppObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppObjInclude = value;
		}
	}

	public String getOptionalCppObjImplementation() {
		return( optionalCppObjImplementation );
	}

	public void setOptionalCppObjImplementation( String value ) {
		if( value == null ) {
			optionalCppObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppObjImplementation = value;
		}
	}

	public String getOptionalCppEditObjMembers() {
		return( optionalCppEditObjMembers );
	}

	public void setOptionalCppEditObjMembers( String value ) {
		if( value == null ) {
			optionalCppEditObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppEditObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppEditObjMembers = value;
		}
	}

	public String getOptionalCppEditObjInterface() {
		return( optionalCppEditObjInterface );
	}

	public void setOptionalCppEditObjInterface( String value ) {
		if( value == null ) {
			optionalCppEditObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppEditObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppEditObjInterface = value;
		}
	}

	public String getOptionalCppEditObjInclude() {
		return( optionalCppEditObjInclude );
	}

	public void setOptionalCppEditObjInclude( String value ) {
		if( value == null ) {
			optionalCppEditObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppEditObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppEditObjInclude = value;
		}
	}

	public String getOptionalCppEditObjImplementation() {
		return( optionalCppEditObjImplementation );
	}

	public void setOptionalCppEditObjImplementation( String value ) {
		if( value == null ) {
			optionalCppEditObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppEditObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppEditObjImplementation = value;
		}
	}

	public String getOptionalCppTableInclude() {
		return( optionalCppTableInclude );
	}

	public void setOptionalCppTableInclude( String value ) {
		if( value == null ) {
			optionalCppTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableInclude = value;
		}
	}

	public String getOptionalCppTableMembers() {
		return( optionalCppTableMembers );
	}

	public void setOptionalCppTableMembers( String value ) {
		if( value == null ) {
			optionalCppTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableMembers = value;
		}
	}

	public String getOptionalCppTableInterface() {
		return( optionalCppTableInterface );
	}

	public void setOptionalCppTableInterface( String value ) {
		if( value == null ) {
			optionalCppTableInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableInterface = value;
		}
	}

	public String getOptionalCppTableImplementation() {
		return( optionalCppTableImplementation );
	}

	public void setOptionalCppTableImplementation( String value ) {
		if( value == null ) {
			optionalCppTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableImplementation = value;
		}
	}

	public String getOptionalCppTableObjInclude() {
		return( optionalCppTableObjInclude );
	}

	public void setOptionalCppTableObjInclude( String value ) {
		if( value == null ) {
			optionalCppTableObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableObjInclude = value;
		}
	}

	public String getOptionalCppTableObjMembers() {
		return( optionalCppTableObjMembers );
	}

	public void setOptionalCppTableObjMembers( String value ) {
		if( value == null ) {
			optionalCppTableObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableObjMembers = value;
		}
	}

	public String getOptionalCppTableObjInterface() {
		return( optionalCppTableObjInterface );
	}

	public void setOptionalCppTableObjInterface( String value ) {
		if( value == null ) {
			optionalCppTableObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableObjInterface = value;
		}
	}

	public String getOptionalCppTableObjImplementation() {
		return( optionalCppTableObjImplementation );
	}

	public void setOptionalCppTableObjImplementation( String value ) {
		if( value == null ) {
			optionalCppTableObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppTableObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppTableObjImplementation = value;
		}
	}

	public String getOptionalCppDb2LUWTableInclude() {
		return( optionalCppDb2LUWTableInclude );
	}

	public void setOptionalCppDb2LUWTableInclude( String value ) {
		if( value == null ) {
			optionalCppDb2LUWTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppDb2LUWTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppDb2LUWTableInclude = value;
		}
	}

	public String getOptionalCppDb2LUWTableMembers() {
		return( optionalCppDb2LUWTableMembers );
	}

	public void setOptionalCppDb2LUWTableMembers( String value ) {
		if( value == null ) {
			optionalCppDb2LUWTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppDb2LUWTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppDb2LUWTableMembers = value;
		}
	}

	public String getOptionalCppDb2LUWTableImplementation() {
		return( optionalCppDb2LUWTableImplementation );
	}

	public void setOptionalCppDb2LUWTableImplementation( String value ) {
		if( value == null ) {
			optionalCppDb2LUWTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppDb2LUWTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppDb2LUWTableImplementation = value;
		}
	}

	public String getOptionalCppMSSqlTableInclude() {
		return( optionalCppMSSqlTableInclude );
	}

	public void setOptionalCppMSSqlTableInclude( String value ) {
		if( value == null ) {
			optionalCppMSSqlTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMSSqlTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMSSqlTableInclude = value;
		}
	}

	public String getOptionalCppMSSqlTableMembers() {
		return( optionalCppMSSqlTableMembers );
	}

	public void setOptionalCppMSSqlTableMembers( String value ) {
		if( value == null ) {
			optionalCppMSSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMSSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMSSqlTableMembers = value;
		}
	}

	public String getOptionalCppMSSqlTableImplementation() {
		return( optionalCppMSSqlTableImplementation );
	}

	public void setOptionalCppMSSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalCppMSSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMSSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMSSqlTableImplementation = value;
		}
	}

	public String getOptionalCppMySqlTableInclude() {
		return( optionalCppMySqlTableInclude );
	}

	public void setOptionalCppMySqlTableInclude( String value ) {
		if( value == null ) {
			optionalCppMySqlTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMySqlTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMySqlTableInclude = value;
		}
	}

	public String getOptionalCppMySqlTableMembers() {
		return( optionalCppMySqlTableMembers );
	}

	public void setOptionalCppMySqlTableMembers( String value ) {
		if( value == null ) {
			optionalCppMySqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMySqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMySqlTableMembers = value;
		}
	}

	public String getOptionalCppMySqlTableImplementation() {
		return( optionalCppMySqlTableImplementation );
	}

	public void setOptionalCppMySqlTableImplementation( String value ) {
		if( value == null ) {
			optionalCppMySqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppMySqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppMySqlTableImplementation = value;
		}
	}

	public String getOptionalCppOracleTableInclude() {
		return( optionalCppOracleTableInclude );
	}

	public void setOptionalCppOracleTableInclude( String value ) {
		if( value == null ) {
			optionalCppOracleTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppOracleTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppOracleTableInclude = value;
		}
	}

	public String getOptionalCppOracleTableMembers() {
		return( optionalCppOracleTableMembers );
	}

	public void setOptionalCppOracleTableMembers( String value ) {
		if( value == null ) {
			optionalCppOracleTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppOracleTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppOracleTableMembers = value;
		}
	}

	public String getOptionalCppOracleTableImplementation() {
		return( optionalCppOracleTableImplementation );
	}

	public void setOptionalCppOracleTableImplementation( String value ) {
		if( value == null ) {
			optionalCppOracleTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppOracleTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppOracleTableImplementation = value;
		}
	}

	public String getOptionalCppPgSqlTableInclude() {
		return( optionalCppPgSqlTableInclude );
	}

	public void setOptionalCppPgSqlTableInclude( String value ) {
		if( value == null ) {
			optionalCppPgSqlTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppPgSqlTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppPgSqlTableInclude = value;
		}
	}

	public String getOptionalCppPgSqlTableMembers() {
		return( optionalCppPgSqlTableMembers );
	}

	public void setOptionalCppPgSqlTableMembers( String value ) {
		if( value == null ) {
			optionalCppPgSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppPgSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppPgSqlTableMembers = value;
		}
	}

	public String getOptionalCppPgSqlTableImplementation() {
		return( optionalCppPgSqlTableImplementation );
	}

	public void setOptionalCppPgSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalCppPgSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppPgSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppPgSqlTableImplementation = value;
		}
	}

	public String getOptionalCppRamTableInclude() {
		return( optionalCppRamTableInclude );
	}

	public void setOptionalCppRamTableInclude( String value ) {
		if( value == null ) {
			optionalCppRamTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppRamTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppRamTableInclude = value;
		}
	}

	public String getOptionalCppRamTableMembers() {
		return( optionalCppRamTableMembers );
	}

	public void setOptionalCppRamTableMembers( String value ) {
		if( value == null ) {
			optionalCppRamTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppRamTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppRamTableMembers = value;
		}
	}

	public String getOptionalCppRamTableImplementation() {
		return( optionalCppRamTableImplementation );
	}

	public void setOptionalCppRamTableImplementation( String value ) {
		if( value == null ) {
			optionalCppRamTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppRamTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppRamTableImplementation = value;
		}
	}

	public String getOptionalCppSaxLoaderInclude() {
		return( optionalCppSaxLoaderInclude );
	}

	public void setOptionalCppSaxLoaderInclude( String value ) {
		if( value == null ) {
			optionalCppSaxLoaderInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSaxLoaderInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSaxLoaderInclude = value;
		}
	}

	public String getOptionalCppSaxLoaderStartElement() {
		return( optionalCppSaxLoaderStartElement );
	}

	public void setOptionalCppSaxLoaderStartElement( String value ) {
		if( value == null ) {
			optionalCppSaxLoaderStartElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSaxLoaderStartElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSaxLoaderStartElement = value;
		}
	}

	public String getOptionalCppSaxLoaderEndElement() {
		return( optionalCppSaxLoaderEndElement );
	}

	public void setOptionalCppSaxLoaderEndElement( String value ) {
		if( value == null ) {
			optionalCppSaxLoaderEndElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppSaxLoaderEndElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppSaxLoaderEndElement = value;
		}
	}

	public String getOptionalCppXMsgTableInclude() {
		return( optionalCppXMsgTableInclude );
	}

	public void setOptionalCppXMsgTableInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgTableInclude = value;
		}
	}

	public String getOptionalCppXMsgTableFormatters() {
		return( optionalCppXMsgTableFormatters );
	}

	public void setOptionalCppXMsgTableFormatters( String value ) {
		if( value == null ) {
			optionalCppXMsgTableFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgTableFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgTableFormatters = value;
		}
	}

	public String getOptionalCppXMsgRqstTableInclude() {
		return( optionalCppXMsgRqstTableInclude );
	}

	public void setOptionalCppXMsgRqstTableInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstTableInclude = value;
		}
	}

	public String getOptionalCppXMsgRspnTableInclude() {
		return( optionalCppXMsgRspnTableInclude );
	}

	public void setOptionalCppXMsgRspnTableInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnTableInclude = value;
		}
	}

	public String getOptionalCppXMsgClientTableInclude() {
		return( optionalCppXMsgClientTableInclude );
	}

	public void setOptionalCppXMsgClientTableInclude( String value ) {
		if( value == null ) {
			optionalCppXMsgClientTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgClientTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgClientTableInclude = value;
		}
	}

	public String getOptionalCppXMsgRqstTableBody() {
		return( optionalCppXMsgRqstTableBody );
	}

	public void setOptionalCppXMsgRqstTableBody( String value ) {
		if( value == null ) {
			optionalCppXMsgRqstTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRqstTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRqstTableBody = value;
		}
	}

	public String getOptionalCppXMsgRspnTableBody() {
		return( optionalCppXMsgRspnTableBody );
	}

	public void setOptionalCppXMsgRspnTableBody( String value ) {
		if( value == null ) {
			optionalCppXMsgRspnTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgRspnTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgRspnTableBody = value;
		}
	}

	public String getOptionalCppXMsgClientTableBody() {
		return( optionalCppXMsgClientTableBody );
	}

	public void setOptionalCppXMsgClientTableBody( String value ) {
		if( value == null ) {
			optionalCppXMsgClientTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCppXMsgClientTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCppXMsgClientTableBody = value;
		}
	}

	public String getOptionalHppObjMembers() {
		return( optionalHppObjMembers );
	}

	public void setOptionalHppObjMembers( String value ) {
		if( value == null ) {
			optionalHppObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppObjMembers = value;
		}
	}

	public String getOptionalHppObjInterface() {
		return( optionalHppObjInterface );
	}

	public void setOptionalHppObjInterface( String value ) {
		if( value == null ) {
			optionalHppObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppObjInterface = value;
		}
	}

	public String getOptionalHppObjInclude() {
		return( optionalHppObjInclude );
	}

	public void setOptionalHppObjInclude( String value ) {
		if( value == null ) {
			optionalHppObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppObjInclude = value;
		}
	}

	public String getOptionalHppObjImplementation() {
		return( optionalHppObjImplementation );
	}

	public void setOptionalHppObjImplementation( String value ) {
		if( value == null ) {
			optionalHppObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppObjImplementation = value;
		}
	}

	public String getOptionalHppEditObjMembers() {
		return( optionalHppEditObjMembers );
	}

	public void setOptionalHppEditObjMembers( String value ) {
		if( value == null ) {
			optionalHppEditObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppEditObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppEditObjMembers = value;
		}
	}

	public String getOptionalHppEditObjInterface() {
		return( optionalHppEditObjInterface );
	}

	public void setOptionalHppEditObjInterface( String value ) {
		if( value == null ) {
			optionalHppEditObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppEditObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppEditObjInterface = value;
		}
	}

	public String getOptionalHppEditObjInclude() {
		return( optionalHppEditObjInclude );
	}

	public void setOptionalHppEditObjInclude( String value ) {
		if( value == null ) {
			optionalHppEditObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppEditObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppEditObjInclude = value;
		}
	}

	public String getOptionalHppEditObjImplementation() {
		return( optionalHppEditObjImplementation );
	}

	public void setOptionalHppEditObjImplementation( String value ) {
		if( value == null ) {
			optionalHppEditObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppEditObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppEditObjImplementation = value;
		}
	}

	public String getOptionalHppTableInclude() {
		return( optionalHppTableInclude );
	}

	public void setOptionalHppTableInclude( String value ) {
		if( value == null ) {
			optionalHppTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableInclude = value;
		}
	}

	public String getOptionalHppTableMembers() {
		return( optionalHppTableMembers );
	}

	public void setOptionalHppTableMembers( String value ) {
		if( value == null ) {
			optionalHppTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableMembers = value;
		}
	}

	public String getOptionalHppTableInterface() {
		return( optionalHppTableInterface );
	}

	public void setOptionalHppTableInterface( String value ) {
		if( value == null ) {
			optionalHppTableInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableInterface = value;
		}
	}

	public String getOptionalHppTableImplementation() {
		return( optionalHppTableImplementation );
	}

	public void setOptionalHppTableImplementation( String value ) {
		if( value == null ) {
			optionalHppTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableImplementation = value;
		}
	}

	public String getOptionalHppTableObjInclude() {
		return( optionalHppTableObjInclude );
	}

	public void setOptionalHppTableObjInclude( String value ) {
		if( value == null ) {
			optionalHppTableObjInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableObjInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableObjInclude = value;
		}
	}

	public String getOptionalHppTableObjMembers() {
		return( optionalHppTableObjMembers );
	}

	public void setOptionalHppTableObjMembers( String value ) {
		if( value == null ) {
			optionalHppTableObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableObjMembers = value;
		}
	}

	public String getOptionalHppTableObjInterface() {
		return( optionalHppTableObjInterface );
	}

	public void setOptionalHppTableObjInterface( String value ) {
		if( value == null ) {
			optionalHppTableObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableObjInterface = value;
		}
	}

	public String getOptionalHppTableObjImplementation() {
		return( optionalHppTableObjImplementation );
	}

	public void setOptionalHppTableObjImplementation( String value ) {
		if( value == null ) {
			optionalHppTableObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppTableObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppTableObjImplementation = value;
		}
	}

	public String getOptionalHppDb2LUWTableInclude() {
		return( optionalHppDb2LUWTableInclude );
	}

	public void setOptionalHppDb2LUWTableInclude( String value ) {
		if( value == null ) {
			optionalHppDb2LUWTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppDb2LUWTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppDb2LUWTableInclude = value;
		}
	}

	public String getOptionalHppDb2LUWTableMembers() {
		return( optionalHppDb2LUWTableMembers );
	}

	public void setOptionalHppDb2LUWTableMembers( String value ) {
		if( value == null ) {
			optionalHppDb2LUWTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppDb2LUWTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppDb2LUWTableMembers = value;
		}
	}

	public String getOptionalHppDb2LUWTableImplementation() {
		return( optionalHppDb2LUWTableImplementation );
	}

	public void setOptionalHppDb2LUWTableImplementation( String value ) {
		if( value == null ) {
			optionalHppDb2LUWTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppDb2LUWTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppDb2LUWTableImplementation = value;
		}
	}

	public String getOptionalHppMSSqlTableInclude() {
		return( optionalHppMSSqlTableInclude );
	}

	public void setOptionalHppMSSqlTableInclude( String value ) {
		if( value == null ) {
			optionalHppMSSqlTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMSSqlTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMSSqlTableInclude = value;
		}
	}

	public String getOptionalHppMSSqlTableMembers() {
		return( optionalHppMSSqlTableMembers );
	}

	public void setOptionalHppMSSqlTableMembers( String value ) {
		if( value == null ) {
			optionalHppMSSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMSSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMSSqlTableMembers = value;
		}
	}

	public String getOptionalHppMSSqlTableImplementation() {
		return( optionalHppMSSqlTableImplementation );
	}

	public void setOptionalHppMSSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalHppMSSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMSSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMSSqlTableImplementation = value;
		}
	}

	public String getOptionalHppMySqlTableInclude() {
		return( optionalHppMySqlTableInclude );
	}

	public void setOptionalHppMySqlTableInclude( String value ) {
		if( value == null ) {
			optionalHppMySqlTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMySqlTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMySqlTableInclude = value;
		}
	}

	public String getOptionalHppMySqlTableMembers() {
		return( optionalHppMySqlTableMembers );
	}

	public void setOptionalHppMySqlTableMembers( String value ) {
		if( value == null ) {
			optionalHppMySqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMySqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMySqlTableMembers = value;
		}
	}

	public String getOptionalHppMySqlTableImplementation() {
		return( optionalHppMySqlTableImplementation );
	}

	public void setOptionalHppMySqlTableImplementation( String value ) {
		if( value == null ) {
			optionalHppMySqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppMySqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppMySqlTableImplementation = value;
		}
	}

	public String getOptionalHppOracleTableInclude() {
		return( optionalHppOracleTableInclude );
	}

	public void setOptionalHppOracleTableInclude( String value ) {
		if( value == null ) {
			optionalHppOracleTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppOracleTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppOracleTableInclude = value;
		}
	}

	public String getOptionalHppOracleTableMembers() {
		return( optionalHppOracleTableMembers );
	}

	public void setOptionalHppOracleTableMembers( String value ) {
		if( value == null ) {
			optionalHppOracleTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppOracleTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppOracleTableMembers = value;
		}
	}

	public String getOptionalHppOracleTableImplementation() {
		return( optionalHppOracleTableImplementation );
	}

	public void setOptionalHppOracleTableImplementation( String value ) {
		if( value == null ) {
			optionalHppOracleTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppOracleTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppOracleTableImplementation = value;
		}
	}

	public String getOptionalHppPgSqlTableInclude() {
		return( optionalHppPgSqlTableInclude );
	}

	public void setOptionalHppPgSqlTableInclude( String value ) {
		if( value == null ) {
			optionalHppPgSqlTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppPgSqlTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppPgSqlTableInclude = value;
		}
	}

	public String getOptionalHppPgSqlTableMembers() {
		return( optionalHppPgSqlTableMembers );
	}

	public void setOptionalHppPgSqlTableMembers( String value ) {
		if( value == null ) {
			optionalHppPgSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppPgSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppPgSqlTableMembers = value;
		}
	}

	public String getOptionalHppPgSqlTableImplementation() {
		return( optionalHppPgSqlTableImplementation );
	}

	public void setOptionalHppPgSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalHppPgSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppPgSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppPgSqlTableImplementation = value;
		}
	}

	public String getOptionalHppRamTableInclude() {
		return( optionalHppRamTableInclude );
	}

	public void setOptionalHppRamTableInclude( String value ) {
		if( value == null ) {
			optionalHppRamTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppRamTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppRamTableInclude = value;
		}
	}

	public String getOptionalHppRamTableMembers() {
		return( optionalHppRamTableMembers );
	}

	public void setOptionalHppRamTableMembers( String value ) {
		if( value == null ) {
			optionalHppRamTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppRamTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppRamTableMembers = value;
		}
	}

	public String getOptionalHppRamTableImplementation() {
		return( optionalHppRamTableImplementation );
	}

	public void setOptionalHppRamTableImplementation( String value ) {
		if( value == null ) {
			optionalHppRamTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppRamTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppRamTableImplementation = value;
		}
	}

	public String getOptionalHppSaxLoaderInclude() {
		return( optionalHppSaxLoaderInclude );
	}

	public void setOptionalHppSaxLoaderInclude( String value ) {
		if( value == null ) {
			optionalHppSaxLoaderInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSaxLoaderInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSaxLoaderInclude = value;
		}
	}

	public String getOptionalHppSaxLoaderStartElement() {
		return( optionalHppSaxLoaderStartElement );
	}

	public void setOptionalHppSaxLoaderStartElement( String value ) {
		if( value == null ) {
			optionalHppSaxLoaderStartElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSaxLoaderStartElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSaxLoaderStartElement = value;
		}
	}

	public String getOptionalHppSaxLoaderEndElement() {
		return( optionalHppSaxLoaderEndElement );
	}

	public void setOptionalHppSaxLoaderEndElement( String value ) {
		if( value == null ) {
			optionalHppSaxLoaderEndElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppSaxLoaderEndElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppSaxLoaderEndElement = value;
		}
	}

	public String getOptionalHppXMsgTableInclude() {
		return( optionalHppXMsgTableInclude );
	}

	public void setOptionalHppXMsgTableInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgTableInclude = value;
		}
	}

	public String getOptionalHppXMsgTableFormatters() {
		return( optionalHppXMsgTableFormatters );
	}

	public void setOptionalHppXMsgTableFormatters( String value ) {
		if( value == null ) {
			optionalHppXMsgTableFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgTableFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgTableFormatters = value;
		}
	}

	public String getOptionalHppXMsgRqstTableInclude() {
		return( optionalHppXMsgRqstTableInclude );
	}

	public void setOptionalHppXMsgRqstTableInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstTableInclude = value;
		}
	}

	public String getOptionalHppXMsgRspnTableInclude() {
		return( optionalHppXMsgRspnTableInclude );
	}

	public void setOptionalHppXMsgRspnTableInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnTableInclude = value;
		}
	}

	public String getOptionalHppXMsgClientTableInclude() {
		return( optionalHppXMsgClientTableInclude );
	}

	public void setOptionalHppXMsgClientTableInclude( String value ) {
		if( value == null ) {
			optionalHppXMsgClientTableInclude = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgClientTableInclude",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgClientTableInclude = value;
		}
	}

	public String getOptionalHppXMsgRqstTableBody() {
		return( optionalHppXMsgRqstTableBody );
	}

	public void setOptionalHppXMsgRqstTableBody( String value ) {
		if( value == null ) {
			optionalHppXMsgRqstTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRqstTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRqstTableBody = value;
		}
	}

	public String getOptionalHppXMsgRspnTableBody() {
		return( optionalHppXMsgRspnTableBody );
	}

	public void setOptionalHppXMsgRspnTableBody( String value ) {
		if( value == null ) {
			optionalHppXMsgRspnTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgRspnTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgRspnTableBody = value;
		}
	}

	public String getOptionalHppXMsgClientTableBody() {
		return( optionalHppXMsgClientTableBody );
	}

	public void setOptionalHppXMsgClientTableBody( String value ) {
		if( value == null ) {
			optionalHppXMsgClientTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalHppXMsgClientTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalHppXMsgClientTableBody = value;
		}
	}

	public String getOptionalCsObjMembers() {
		return( optionalCsObjMembers );
	}

	public void setOptionalCsObjMembers( String value ) {
		if( value == null ) {
			optionalCsObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsObjMembers = value;
		}
	}

	public String getOptionalCsObjInterface() {
		return( optionalCsObjInterface );
	}

	public void setOptionalCsObjInterface( String value ) {
		if( value == null ) {
			optionalCsObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsObjInterface = value;
		}
	}

	public String getOptionalCsObjUsing() {
		return( optionalCsObjUsing );
	}

	public void setOptionalCsObjUsing( String value ) {
		if( value == null ) {
			optionalCsObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsObjUsing = value;
		}
	}

	public String getOptionalCsObjImplementation() {
		return( optionalCsObjImplementation );
	}

	public void setOptionalCsObjImplementation( String value ) {
		if( value == null ) {
			optionalCsObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsObjImplementation = value;
		}
	}

	public String getOptionalCsEditObjMembers() {
		return( optionalCsEditObjMembers );
	}

	public void setOptionalCsEditObjMembers( String value ) {
		if( value == null ) {
			optionalCsEditObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsEditObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsEditObjMembers = value;
		}
	}

	public String getOptionalCsEditObjInterface() {
		return( optionalCsEditObjInterface );
	}

	public void setOptionalCsEditObjInterface( String value ) {
		if( value == null ) {
			optionalCsEditObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsEditObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsEditObjInterface = value;
		}
	}

	public String getOptionalCsEditObjUsing() {
		return( optionalCsEditObjUsing );
	}

	public void setOptionalCsEditObjUsing( String value ) {
		if( value == null ) {
			optionalCsEditObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsEditObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsEditObjUsing = value;
		}
	}

	public String getOptionalCsEditObjImplementation() {
		return( optionalCsEditObjImplementation );
	}

	public void setOptionalCsEditObjImplementation( String value ) {
		if( value == null ) {
			optionalCsEditObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsEditObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsEditObjImplementation = value;
		}
	}

	public String getOptionalCsTableUsing() {
		return( optionalCsTableUsing );
	}

	public void setOptionalCsTableUsing( String value ) {
		if( value == null ) {
			optionalCsTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableUsing = value;
		}
	}

	public String getOptionalCsTableMembers() {
		return( optionalCsTableMembers );
	}

	public void setOptionalCsTableMembers( String value ) {
		if( value == null ) {
			optionalCsTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableMembers = value;
		}
	}

	public String getOptionalCsTableInterface() {
		return( optionalCsTableInterface );
	}

	public void setOptionalCsTableInterface( String value ) {
		if( value == null ) {
			optionalCsTableInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableInterface = value;
		}
	}

	public String getOptionalCsTableImplementation() {
		return( optionalCsTableImplementation );
	}

	public void setOptionalCsTableImplementation( String value ) {
		if( value == null ) {
			optionalCsTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableImplementation = value;
		}
	}

	public String getOptionalCsTableObjUsing() {
		return( optionalCsTableObjUsing );
	}

	public void setOptionalCsTableObjUsing( String value ) {
		if( value == null ) {
			optionalCsTableObjUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableObjUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableObjUsing = value;
		}
	}

	public String getOptionalCsTableObjMembers() {
		return( optionalCsTableObjMembers );
	}

	public void setOptionalCsTableObjMembers( String value ) {
		if( value == null ) {
			optionalCsTableObjMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableObjMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableObjMembers = value;
		}
	}

	public String getOptionalCsTableObjInterface() {
		return( optionalCsTableObjInterface );
	}

	public void setOptionalCsTableObjInterface( String value ) {
		if( value == null ) {
			optionalCsTableObjInterface = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableObjInterface",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableObjInterface = value;
		}
	}

	public String getOptionalCsTableObjImplementation() {
		return( optionalCsTableObjImplementation );
	}

	public void setOptionalCsTableObjImplementation( String value ) {
		if( value == null ) {
			optionalCsTableObjImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsTableObjImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsTableObjImplementation = value;
		}
	}

	public String getOptionalCsDb2LUWTableUsing() {
		return( optionalCsDb2LUWTableUsing );
	}

	public void setOptionalCsDb2LUWTableUsing( String value ) {
		if( value == null ) {
			optionalCsDb2LUWTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsDb2LUWTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsDb2LUWTableUsing = value;
		}
	}

	public String getOptionalCsDb2LUWTableMembers() {
		return( optionalCsDb2LUWTableMembers );
	}

	public void setOptionalCsDb2LUWTableMembers( String value ) {
		if( value == null ) {
			optionalCsDb2LUWTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsDb2LUWTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsDb2LUWTableMembers = value;
		}
	}

	public String getOptionalCsDb2LUWTableImplementation() {
		return( optionalCsDb2LUWTableImplementation );
	}

	public void setOptionalCsDb2LUWTableImplementation( String value ) {
		if( value == null ) {
			optionalCsDb2LUWTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsDb2LUWTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsDb2LUWTableImplementation = value;
		}
	}

	public String getOptionalCsMSSqlTableUsing() {
		return( optionalCsMSSqlTableUsing );
	}

	public void setOptionalCsMSSqlTableUsing( String value ) {
		if( value == null ) {
			optionalCsMSSqlTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMSSqlTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMSSqlTableUsing = value;
		}
	}

	public String getOptionalCsMSSqlTableMembers() {
		return( optionalCsMSSqlTableMembers );
	}

	public void setOptionalCsMSSqlTableMembers( String value ) {
		if( value == null ) {
			optionalCsMSSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMSSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMSSqlTableMembers = value;
		}
	}

	public String getOptionalCsMSSqlTableImplementation() {
		return( optionalCsMSSqlTableImplementation );
	}

	public void setOptionalCsMSSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalCsMSSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMSSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMSSqlTableImplementation = value;
		}
	}

	public String getOptionalCsMySqlTableUsing() {
		return( optionalCsMySqlTableUsing );
	}

	public void setOptionalCsMySqlTableUsing( String value ) {
		if( value == null ) {
			optionalCsMySqlTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMySqlTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMySqlTableUsing = value;
		}
	}

	public String getOptionalCsMySqlTableMembers() {
		return( optionalCsMySqlTableMembers );
	}

	public void setOptionalCsMySqlTableMembers( String value ) {
		if( value == null ) {
			optionalCsMySqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMySqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMySqlTableMembers = value;
		}
	}

	public String getOptionalCsMySqlTableImplementation() {
		return( optionalCsMySqlTableImplementation );
	}

	public void setOptionalCsMySqlTableImplementation( String value ) {
		if( value == null ) {
			optionalCsMySqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsMySqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsMySqlTableImplementation = value;
		}
	}

	public String getOptionalCsOracleTableUsing() {
		return( optionalCsOracleTableUsing );
	}

	public void setOptionalCsOracleTableUsing( String value ) {
		if( value == null ) {
			optionalCsOracleTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsOracleTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsOracleTableUsing = value;
		}
	}

	public String getOptionalCsOracleTableMembers() {
		return( optionalCsOracleTableMembers );
	}

	public void setOptionalCsOracleTableMembers( String value ) {
		if( value == null ) {
			optionalCsOracleTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsOracleTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsOracleTableMembers = value;
		}
	}

	public String getOptionalCsOracleTableImplementation() {
		return( optionalCsOracleTableImplementation );
	}

	public void setOptionalCsOracleTableImplementation( String value ) {
		if( value == null ) {
			optionalCsOracleTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsOracleTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsOracleTableImplementation = value;
		}
	}

	public String getOptionalCsPgSqlTableUsing() {
		return( optionalCsPgSqlTableUsing );
	}

	public void setOptionalCsPgSqlTableUsing( String value ) {
		if( value == null ) {
			optionalCsPgSqlTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsPgSqlTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsPgSqlTableUsing = value;
		}
	}

	public String getOptionalCsPgSqlTableMembers() {
		return( optionalCsPgSqlTableMembers );
	}

	public void setOptionalCsPgSqlTableMembers( String value ) {
		if( value == null ) {
			optionalCsPgSqlTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsPgSqlTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsPgSqlTableMembers = value;
		}
	}

	public String getOptionalCsPgSqlTableImplementation() {
		return( optionalCsPgSqlTableImplementation );
	}

	public void setOptionalCsPgSqlTableImplementation( String value ) {
		if( value == null ) {
			optionalCsPgSqlTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsPgSqlTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsPgSqlTableImplementation = value;
		}
	}

	public String getOptionalCsRamTableUsing() {
		return( optionalCsRamTableUsing );
	}

	public void setOptionalCsRamTableUsing( String value ) {
		if( value == null ) {
			optionalCsRamTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsRamTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsRamTableUsing = value;
		}
	}

	public String getOptionalCsRamTableMembers() {
		return( optionalCsRamTableMembers );
	}

	public void setOptionalCsRamTableMembers( String value ) {
		if( value == null ) {
			optionalCsRamTableMembers = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsRamTableMembers",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsRamTableMembers = value;
		}
	}

	public String getOptionalCsRamTableImplementation() {
		return( optionalCsRamTableImplementation );
	}

	public void setOptionalCsRamTableImplementation( String value ) {
		if( value == null ) {
			optionalCsRamTableImplementation = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsRamTableImplementation",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsRamTableImplementation = value;
		}
	}

	public String getOptionalCsSaxLoaderUsing() {
		return( optionalCsSaxLoaderUsing );
	}

	public void setOptionalCsSaxLoaderUsing( String value ) {
		if( value == null ) {
			optionalCsSaxLoaderUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSaxLoaderUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSaxLoaderUsing = value;
		}
	}

	public String getOptionalCsSaxLoaderStartElement() {
		return( optionalCsSaxLoaderStartElement );
	}

	public void setOptionalCsSaxLoaderStartElement( String value ) {
		if( value == null ) {
			optionalCsSaxLoaderStartElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSaxLoaderStartElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSaxLoaderStartElement = value;
		}
	}

	public String getOptionalCsSaxLoaderEndElement() {
		return( optionalCsSaxLoaderEndElement );
	}

	public void setOptionalCsSaxLoaderEndElement( String value ) {
		if( value == null ) {
			optionalCsSaxLoaderEndElement = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsSaxLoaderEndElement",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsSaxLoaderEndElement = value;
		}
	}

	public String getOptionalCsXMsgTableUsing() {
		return( optionalCsXMsgTableUsing );
	}

	public void setOptionalCsXMsgTableUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgTableUsing = value;
		}
	}

	public String getOptionalCsXMsgTableFormatters() {
		return( optionalCsXMsgTableFormatters );
	}

	public void setOptionalCsXMsgTableFormatters( String value ) {
		if( value == null ) {
			optionalCsXMsgTableFormatters = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgTableFormatters",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgTableFormatters = value;
		}
	}

	public String getOptionalCsXMsgRqstTableUsing() {
		return( optionalCsXMsgRqstTableUsing );
	}

	public void setOptionalCsXMsgRqstTableUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstTableUsing = value;
		}
	}

	public String getOptionalCsXMsgRspnTableUsing() {
		return( optionalCsXMsgRspnTableUsing );
	}

	public void setOptionalCsXMsgRspnTableUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnTableUsing = value;
		}
	}

	public String getOptionalCsXMsgClientTableUsing() {
		return( optionalCsXMsgClientTableUsing );
	}

	public void setOptionalCsXMsgClientTableUsing( String value ) {
		if( value == null ) {
			optionalCsXMsgClientTableUsing = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgClientTableUsing",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgClientTableUsing = value;
		}
	}

	public String getOptionalCsXMsgRqstTableBody() {
		return( optionalCsXMsgRqstTableBody );
	}

	public void setOptionalCsXMsgRqstTableBody( String value ) {
		if( value == null ) {
			optionalCsXMsgRqstTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRqstTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRqstTableBody = value;
		}
	}

	public String getOptionalCsXMsgRspnTableBody() {
		return( optionalCsXMsgRspnTableBody );
	}

	public void setOptionalCsXMsgRspnTableBody( String value ) {
		if( value == null ) {
			optionalCsXMsgRspnTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgRspnTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgRspnTableBody = value;
		}
	}

	public String getOptionalCsXMsgClientTableBody() {
		return( optionalCsXMsgClientTableBody );
	}

	public void setOptionalCsXMsgClientTableBody( String value ) {
		if( value == null ) {
			optionalCsXMsgClientTableBody = null;
		}
		else if( value.length() > 2000000 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalCsXMsgClientTableBody",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		else {
			optionalCsXMsgClientTableBody = value;
		}
	}

	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof CFBamTableHBuff ) {
			CFBamTableHBuff rhs = (CFBamTableHBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
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
			if( getRequiredPageData() != rhs.getRequiredPageData() ) {
				return( false );
			}
			if( getOptionalPrimaryIndexTenantId() != null ) {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					if( ! getOptionalPrimaryIndexTenantId().equals( rhs.getOptionalPrimaryIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
				return( false );
			}
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexTenantId() != null ) {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					if( ! getOptionalAltIndexTenantId().equals( rhs.getOptionalAltIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTenantId() != null ) {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					if( ! getOptionalQualifyingTenantId().equals( rhs.getOptionalQualifyingTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( ! getRequiredLoaderBehaviour().equals( rhs.getRequiredLoaderBehaviour() ) ) {
				return( false );
			}
			if( ! getRequiredSecScope().equals( rhs.getRequiredSecScope() ) ) {
				return( false );
			}
			if( getOptionalJObjMembers() != null ) {
				if( rhs.getOptionalJObjMembers() != null ) {
					if( ! getOptionalJObjMembers().equals( rhs.getOptionalJObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjInterface() != null ) {
				if( rhs.getOptionalJObjInterface() != null ) {
					if( ! getOptionalJObjInterface().equals( rhs.getOptionalJObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImport() != null ) {
				if( rhs.getOptionalJObjImport() != null ) {
					if( ! getOptionalJObjImport().equals( rhs.getOptionalJObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImplementation() != null ) {
				if( rhs.getOptionalJObjImplementation() != null ) {
					if( ! getOptionalJObjImplementation().equals( rhs.getOptionalJObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjMembers() != null ) {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					if( ! getOptionalJEditObjMembers().equals( rhs.getOptionalJEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjInterface() != null ) {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					if( ! getOptionalJEditObjInterface().equals( rhs.getOptionalJEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImport() != null ) {
				if( rhs.getOptionalJEditObjImport() != null ) {
					if( ! getOptionalJEditObjImport().equals( rhs.getOptionalJEditObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImplementation() != null ) {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					if( ! getOptionalJEditObjImplementation().equals( rhs.getOptionalJEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImport() != null ) {
				if( rhs.getOptionalJTableImport() != null ) {
					if( ! getOptionalJTableImport().equals( rhs.getOptionalJTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableMembers() != null ) {
				if( rhs.getOptionalJTableMembers() != null ) {
					if( ! getOptionalJTableMembers().equals( rhs.getOptionalJTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableInterface() != null ) {
				if( rhs.getOptionalJTableInterface() != null ) {
					if( ! getOptionalJTableInterface().equals( rhs.getOptionalJTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImplementation() != null ) {
				if( rhs.getOptionalJTableImplementation() != null ) {
					if( ! getOptionalJTableImplementation().equals( rhs.getOptionalJTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImport() != null ) {
				if( rhs.getOptionalJTableObjImport() != null ) {
					if( ! getOptionalJTableObjImport().equals( rhs.getOptionalJTableObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjMembers() != null ) {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					if( ! getOptionalJTableObjMembers().equals( rhs.getOptionalJTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjInterface() != null ) {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					if( ! getOptionalJTableObjInterface().equals( rhs.getOptionalJTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImplementation() != null ) {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					if( ! getOptionalJTableObjImplementation().equals( rhs.getOptionalJTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImport() != null ) {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					if( ! getOptionalJDb2LUWTableImport().equals( rhs.getOptionalJDb2LUWTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					if( ! getOptionalJDb2LUWTableMembers().equals( rhs.getOptionalJDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					if( ! getOptionalJDb2LUWTableImplementation().equals( rhs.getOptionalJDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImport() != null ) {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					if( ! getOptionalJMSSqlTableImport().equals( rhs.getOptionalJMSSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableMembers() != null ) {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					if( ! getOptionalJMSSqlTableMembers().equals( rhs.getOptionalJMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					if( ! getOptionalJMSSqlTableImplementation().equals( rhs.getOptionalJMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImport() != null ) {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					if( ! getOptionalJMySqlTableImport().equals( rhs.getOptionalJMySqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableMembers() != null ) {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					if( ! getOptionalJMySqlTableMembers().equals( rhs.getOptionalJMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImplementation() != null ) {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					if( ! getOptionalJMySqlTableImplementation().equals( rhs.getOptionalJMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImport() != null ) {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					if( ! getOptionalJOracleTableImport().equals( rhs.getOptionalJOracleTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableMembers() != null ) {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					if( ! getOptionalJOracleTableMembers().equals( rhs.getOptionalJOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImplementation() != null ) {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					if( ! getOptionalJOracleTableImplementation().equals( rhs.getOptionalJOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImport() != null ) {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					if( ! getOptionalJPgSqlTableImport().equals( rhs.getOptionalJPgSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableMembers() != null ) {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					if( ! getOptionalJPgSqlTableMembers().equals( rhs.getOptionalJPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					if( ! getOptionalJPgSqlTableImplementation().equals( rhs.getOptionalJPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImport() != null ) {
				if( rhs.getOptionalJRamTableImport() != null ) {
					if( ! getOptionalJRamTableImport().equals( rhs.getOptionalJRamTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableMembers() != null ) {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					if( ! getOptionalJRamTableMembers().equals( rhs.getOptionalJRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImplementation() != null ) {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					if( ! getOptionalJRamTableImplementation().equals( rhs.getOptionalJRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderImport() != null ) {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					if( ! getOptionalJSaxLoaderImport().equals( rhs.getOptionalJSaxLoaderImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					if( ! getOptionalJSaxLoaderStartElement().equals( rhs.getOptionalJSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					if( ! getOptionalJSaxLoaderEndElement().equals( rhs.getOptionalJSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableImport() != null ) {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					if( ! getOptionalJXMsgTableImport().equals( rhs.getOptionalJXMsgTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableFormatters() != null ) {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					if( ! getOptionalJXMsgTableFormatters().equals( rhs.getOptionalJXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableImport() != null ) {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					if( ! getOptionalJXMsgRqstTableImport().equals( rhs.getOptionalJXMsgRqstTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableImport() != null ) {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					if( ! getOptionalJXMsgRspnTableImport().equals( rhs.getOptionalJXMsgRspnTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableImport() != null ) {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					if( ! getOptionalJXMsgClientTableImport().equals( rhs.getOptionalJXMsgClientTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					if( ! getOptionalJXMsgRqstTableBody().equals( rhs.getOptionalJXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					if( ! getOptionalJXMsgRspnTableBody().equals( rhs.getOptionalJXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableBody() != null ) {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					if( ! getOptionalJXMsgClientTableBody().equals( rhs.getOptionalJXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjMembers() != null ) {
				if( rhs.getOptionalCppObjMembers() != null ) {
					if( ! getOptionalCppObjMembers().equals( rhs.getOptionalCppObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjInterface() != null ) {
				if( rhs.getOptionalCppObjInterface() != null ) {
					if( ! getOptionalCppObjInterface().equals( rhs.getOptionalCppObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjInclude() != null ) {
				if( rhs.getOptionalCppObjInclude() != null ) {
					if( ! getOptionalCppObjInclude().equals( rhs.getOptionalCppObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjImplementation() != null ) {
				if( rhs.getOptionalCppObjImplementation() != null ) {
					if( ! getOptionalCppObjImplementation().equals( rhs.getOptionalCppObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjMembers() != null ) {
				if( rhs.getOptionalCppEditObjMembers() != null ) {
					if( ! getOptionalCppEditObjMembers().equals( rhs.getOptionalCppEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjInterface() != null ) {
				if( rhs.getOptionalCppEditObjInterface() != null ) {
					if( ! getOptionalCppEditObjInterface().equals( rhs.getOptionalCppEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjInclude() != null ) {
				if( rhs.getOptionalCppEditObjInclude() != null ) {
					if( ! getOptionalCppEditObjInclude().equals( rhs.getOptionalCppEditObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjImplementation() != null ) {
				if( rhs.getOptionalCppEditObjImplementation() != null ) {
					if( ! getOptionalCppEditObjImplementation().equals( rhs.getOptionalCppEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableInclude() != null ) {
				if( rhs.getOptionalCppTableInclude() != null ) {
					if( ! getOptionalCppTableInclude().equals( rhs.getOptionalCppTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableMembers() != null ) {
				if( rhs.getOptionalCppTableMembers() != null ) {
					if( ! getOptionalCppTableMembers().equals( rhs.getOptionalCppTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableInterface() != null ) {
				if( rhs.getOptionalCppTableInterface() != null ) {
					if( ! getOptionalCppTableInterface().equals( rhs.getOptionalCppTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableImplementation() != null ) {
				if( rhs.getOptionalCppTableImplementation() != null ) {
					if( ! getOptionalCppTableImplementation().equals( rhs.getOptionalCppTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjInclude() != null ) {
				if( rhs.getOptionalCppTableObjInclude() != null ) {
					if( ! getOptionalCppTableObjInclude().equals( rhs.getOptionalCppTableObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjMembers() != null ) {
				if( rhs.getOptionalCppTableObjMembers() != null ) {
					if( ! getOptionalCppTableObjMembers().equals( rhs.getOptionalCppTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjInterface() != null ) {
				if( rhs.getOptionalCppTableObjInterface() != null ) {
					if( ! getOptionalCppTableObjInterface().equals( rhs.getOptionalCppTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjImplementation() != null ) {
				if( rhs.getOptionalCppTableObjImplementation() != null ) {
					if( ! getOptionalCppTableObjImplementation().equals( rhs.getOptionalCppTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWTableInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWTableInclude() != null ) {
					if( ! getOptionalCppDb2LUWTableInclude().equals( rhs.getOptionalCppDb2LUWTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWTableMembers() != null ) {
					if( ! getOptionalCppDb2LUWTableMembers().equals( rhs.getOptionalCppDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalCppDb2LUWTableImplementation() != null ) {
					if( ! getOptionalCppDb2LUWTableImplementation().equals( rhs.getOptionalCppDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlTableInclude() != null ) {
				if( rhs.getOptionalCppMSSqlTableInclude() != null ) {
					if( ! getOptionalCppMSSqlTableInclude().equals( rhs.getOptionalCppMSSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlTableMembers() != null ) {
				if( rhs.getOptionalCppMSSqlTableMembers() != null ) {
					if( ! getOptionalCppMSSqlTableMembers().equals( rhs.getOptionalCppMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalCppMSSqlTableImplementation() != null ) {
					if( ! getOptionalCppMSSqlTableImplementation().equals( rhs.getOptionalCppMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlTableInclude() != null ) {
				if( rhs.getOptionalCppMySqlTableInclude() != null ) {
					if( ! getOptionalCppMySqlTableInclude().equals( rhs.getOptionalCppMySqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlTableMembers() != null ) {
				if( rhs.getOptionalCppMySqlTableMembers() != null ) {
					if( ! getOptionalCppMySqlTableMembers().equals( rhs.getOptionalCppMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlTableImplementation() != null ) {
				if( rhs.getOptionalCppMySqlTableImplementation() != null ) {
					if( ! getOptionalCppMySqlTableImplementation().equals( rhs.getOptionalCppMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleTableInclude() != null ) {
				if( rhs.getOptionalCppOracleTableInclude() != null ) {
					if( ! getOptionalCppOracleTableInclude().equals( rhs.getOptionalCppOracleTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleTableMembers() != null ) {
				if( rhs.getOptionalCppOracleTableMembers() != null ) {
					if( ! getOptionalCppOracleTableMembers().equals( rhs.getOptionalCppOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleTableImplementation() != null ) {
				if( rhs.getOptionalCppOracleTableImplementation() != null ) {
					if( ! getOptionalCppOracleTableImplementation().equals( rhs.getOptionalCppOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlTableInclude() != null ) {
				if( rhs.getOptionalCppPgSqlTableInclude() != null ) {
					if( ! getOptionalCppPgSqlTableInclude().equals( rhs.getOptionalCppPgSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlTableMembers() != null ) {
				if( rhs.getOptionalCppPgSqlTableMembers() != null ) {
					if( ! getOptionalCppPgSqlTableMembers().equals( rhs.getOptionalCppPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalCppPgSqlTableImplementation() != null ) {
					if( ! getOptionalCppPgSqlTableImplementation().equals( rhs.getOptionalCppPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamTableInclude() != null ) {
				if( rhs.getOptionalCppRamTableInclude() != null ) {
					if( ! getOptionalCppRamTableInclude().equals( rhs.getOptionalCppRamTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamTableMembers() != null ) {
				if( rhs.getOptionalCppRamTableMembers() != null ) {
					if( ! getOptionalCppRamTableMembers().equals( rhs.getOptionalCppRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamTableImplementation() != null ) {
				if( rhs.getOptionalCppRamTableImplementation() != null ) {
					if( ! getOptionalCppRamTableImplementation().equals( rhs.getOptionalCppRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSaxLoaderInclude() != null ) {
				if( rhs.getOptionalCppSaxLoaderInclude() != null ) {
					if( ! getOptionalCppSaxLoaderInclude().equals( rhs.getOptionalCppSaxLoaderInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalCppSaxLoaderStartElement() != null ) {
					if( ! getOptionalCppSaxLoaderStartElement().equals( rhs.getOptionalCppSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalCppSaxLoaderEndElement() != null ) {
					if( ! getOptionalCppSaxLoaderEndElement().equals( rhs.getOptionalCppSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgTableInclude() != null ) {
					if( ! getOptionalCppXMsgTableInclude().equals( rhs.getOptionalCppXMsgTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgTableFormatters() != null ) {
				if( rhs.getOptionalCppXMsgTableFormatters() != null ) {
					if( ! getOptionalCppXMsgTableFormatters().equals( rhs.getOptionalCppXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstTableInclude() != null ) {
					if( ! getOptionalCppXMsgRqstTableInclude().equals( rhs.getOptionalCppXMsgRqstTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnTableInclude() != null ) {
					if( ! getOptionalCppXMsgRspnTableInclude().equals( rhs.getOptionalCppXMsgRspnTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientTableInclude() != null ) {
					if( ! getOptionalCppXMsgClientTableInclude().equals( rhs.getOptionalCppXMsgClientTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstTableBody() != null ) {
					if( ! getOptionalCppXMsgRqstTableBody().equals( rhs.getOptionalCppXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnTableBody() != null ) {
					if( ! getOptionalCppXMsgRspnTableBody().equals( rhs.getOptionalCppXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientTableBody() != null ) {
				if( rhs.getOptionalCppXMsgClientTableBody() != null ) {
					if( ! getOptionalCppXMsgClientTableBody().equals( rhs.getOptionalCppXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjMembers() != null ) {
				if( rhs.getOptionalHppObjMembers() != null ) {
					if( ! getOptionalHppObjMembers().equals( rhs.getOptionalHppObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjInterface() != null ) {
				if( rhs.getOptionalHppObjInterface() != null ) {
					if( ! getOptionalHppObjInterface().equals( rhs.getOptionalHppObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjInclude() != null ) {
				if( rhs.getOptionalHppObjInclude() != null ) {
					if( ! getOptionalHppObjInclude().equals( rhs.getOptionalHppObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjImplementation() != null ) {
				if( rhs.getOptionalHppObjImplementation() != null ) {
					if( ! getOptionalHppObjImplementation().equals( rhs.getOptionalHppObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjMembers() != null ) {
				if( rhs.getOptionalHppEditObjMembers() != null ) {
					if( ! getOptionalHppEditObjMembers().equals( rhs.getOptionalHppEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjInterface() != null ) {
				if( rhs.getOptionalHppEditObjInterface() != null ) {
					if( ! getOptionalHppEditObjInterface().equals( rhs.getOptionalHppEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjInclude() != null ) {
				if( rhs.getOptionalHppEditObjInclude() != null ) {
					if( ! getOptionalHppEditObjInclude().equals( rhs.getOptionalHppEditObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjImplementation() != null ) {
				if( rhs.getOptionalHppEditObjImplementation() != null ) {
					if( ! getOptionalHppEditObjImplementation().equals( rhs.getOptionalHppEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableInclude() != null ) {
				if( rhs.getOptionalHppTableInclude() != null ) {
					if( ! getOptionalHppTableInclude().equals( rhs.getOptionalHppTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableMembers() != null ) {
				if( rhs.getOptionalHppTableMembers() != null ) {
					if( ! getOptionalHppTableMembers().equals( rhs.getOptionalHppTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableInterface() != null ) {
				if( rhs.getOptionalHppTableInterface() != null ) {
					if( ! getOptionalHppTableInterface().equals( rhs.getOptionalHppTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableImplementation() != null ) {
				if( rhs.getOptionalHppTableImplementation() != null ) {
					if( ! getOptionalHppTableImplementation().equals( rhs.getOptionalHppTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjInclude() != null ) {
				if( rhs.getOptionalHppTableObjInclude() != null ) {
					if( ! getOptionalHppTableObjInclude().equals( rhs.getOptionalHppTableObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjMembers() != null ) {
				if( rhs.getOptionalHppTableObjMembers() != null ) {
					if( ! getOptionalHppTableObjMembers().equals( rhs.getOptionalHppTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjInterface() != null ) {
				if( rhs.getOptionalHppTableObjInterface() != null ) {
					if( ! getOptionalHppTableObjInterface().equals( rhs.getOptionalHppTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjImplementation() != null ) {
				if( rhs.getOptionalHppTableObjImplementation() != null ) {
					if( ! getOptionalHppTableObjImplementation().equals( rhs.getOptionalHppTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWTableInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWTableInclude() != null ) {
					if( ! getOptionalHppDb2LUWTableInclude().equals( rhs.getOptionalHppDb2LUWTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWTableMembers() != null ) {
					if( ! getOptionalHppDb2LUWTableMembers().equals( rhs.getOptionalHppDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalHppDb2LUWTableImplementation() != null ) {
					if( ! getOptionalHppDb2LUWTableImplementation().equals( rhs.getOptionalHppDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlTableInclude() != null ) {
				if( rhs.getOptionalHppMSSqlTableInclude() != null ) {
					if( ! getOptionalHppMSSqlTableInclude().equals( rhs.getOptionalHppMSSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlTableMembers() != null ) {
				if( rhs.getOptionalHppMSSqlTableMembers() != null ) {
					if( ! getOptionalHppMSSqlTableMembers().equals( rhs.getOptionalHppMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalHppMSSqlTableImplementation() != null ) {
					if( ! getOptionalHppMSSqlTableImplementation().equals( rhs.getOptionalHppMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlTableInclude() != null ) {
				if( rhs.getOptionalHppMySqlTableInclude() != null ) {
					if( ! getOptionalHppMySqlTableInclude().equals( rhs.getOptionalHppMySqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlTableMembers() != null ) {
				if( rhs.getOptionalHppMySqlTableMembers() != null ) {
					if( ! getOptionalHppMySqlTableMembers().equals( rhs.getOptionalHppMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlTableImplementation() != null ) {
				if( rhs.getOptionalHppMySqlTableImplementation() != null ) {
					if( ! getOptionalHppMySqlTableImplementation().equals( rhs.getOptionalHppMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleTableInclude() != null ) {
				if( rhs.getOptionalHppOracleTableInclude() != null ) {
					if( ! getOptionalHppOracleTableInclude().equals( rhs.getOptionalHppOracleTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleTableMembers() != null ) {
				if( rhs.getOptionalHppOracleTableMembers() != null ) {
					if( ! getOptionalHppOracleTableMembers().equals( rhs.getOptionalHppOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleTableImplementation() != null ) {
				if( rhs.getOptionalHppOracleTableImplementation() != null ) {
					if( ! getOptionalHppOracleTableImplementation().equals( rhs.getOptionalHppOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlTableInclude() != null ) {
				if( rhs.getOptionalHppPgSqlTableInclude() != null ) {
					if( ! getOptionalHppPgSqlTableInclude().equals( rhs.getOptionalHppPgSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlTableMembers() != null ) {
				if( rhs.getOptionalHppPgSqlTableMembers() != null ) {
					if( ! getOptionalHppPgSqlTableMembers().equals( rhs.getOptionalHppPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalHppPgSqlTableImplementation() != null ) {
					if( ! getOptionalHppPgSqlTableImplementation().equals( rhs.getOptionalHppPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamTableInclude() != null ) {
				if( rhs.getOptionalHppRamTableInclude() != null ) {
					if( ! getOptionalHppRamTableInclude().equals( rhs.getOptionalHppRamTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamTableMembers() != null ) {
				if( rhs.getOptionalHppRamTableMembers() != null ) {
					if( ! getOptionalHppRamTableMembers().equals( rhs.getOptionalHppRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamTableImplementation() != null ) {
				if( rhs.getOptionalHppRamTableImplementation() != null ) {
					if( ! getOptionalHppRamTableImplementation().equals( rhs.getOptionalHppRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSaxLoaderInclude() != null ) {
				if( rhs.getOptionalHppSaxLoaderInclude() != null ) {
					if( ! getOptionalHppSaxLoaderInclude().equals( rhs.getOptionalHppSaxLoaderInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalHppSaxLoaderStartElement() != null ) {
					if( ! getOptionalHppSaxLoaderStartElement().equals( rhs.getOptionalHppSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalHppSaxLoaderEndElement() != null ) {
					if( ! getOptionalHppSaxLoaderEndElement().equals( rhs.getOptionalHppSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgTableInclude() != null ) {
					if( ! getOptionalHppXMsgTableInclude().equals( rhs.getOptionalHppXMsgTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgTableFormatters() != null ) {
				if( rhs.getOptionalHppXMsgTableFormatters() != null ) {
					if( ! getOptionalHppXMsgTableFormatters().equals( rhs.getOptionalHppXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstTableInclude() != null ) {
					if( ! getOptionalHppXMsgRqstTableInclude().equals( rhs.getOptionalHppXMsgRqstTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnTableInclude() != null ) {
					if( ! getOptionalHppXMsgRspnTableInclude().equals( rhs.getOptionalHppXMsgRspnTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientTableInclude() != null ) {
					if( ! getOptionalHppXMsgClientTableInclude().equals( rhs.getOptionalHppXMsgClientTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstTableBody() != null ) {
					if( ! getOptionalHppXMsgRqstTableBody().equals( rhs.getOptionalHppXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnTableBody() != null ) {
					if( ! getOptionalHppXMsgRspnTableBody().equals( rhs.getOptionalHppXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientTableBody() != null ) {
				if( rhs.getOptionalHppXMsgClientTableBody() != null ) {
					if( ! getOptionalHppXMsgClientTableBody().equals( rhs.getOptionalHppXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjMembers() != null ) {
				if( rhs.getOptionalCsObjMembers() != null ) {
					if( ! getOptionalCsObjMembers().equals( rhs.getOptionalCsObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjInterface() != null ) {
				if( rhs.getOptionalCsObjInterface() != null ) {
					if( ! getOptionalCsObjInterface().equals( rhs.getOptionalCsObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjUsing() != null ) {
				if( rhs.getOptionalCsObjUsing() != null ) {
					if( ! getOptionalCsObjUsing().equals( rhs.getOptionalCsObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjImplementation() != null ) {
				if( rhs.getOptionalCsObjImplementation() != null ) {
					if( ! getOptionalCsObjImplementation().equals( rhs.getOptionalCsObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjMembers() != null ) {
				if( rhs.getOptionalCsEditObjMembers() != null ) {
					if( ! getOptionalCsEditObjMembers().equals( rhs.getOptionalCsEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjInterface() != null ) {
				if( rhs.getOptionalCsEditObjInterface() != null ) {
					if( ! getOptionalCsEditObjInterface().equals( rhs.getOptionalCsEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjUsing() != null ) {
				if( rhs.getOptionalCsEditObjUsing() != null ) {
					if( ! getOptionalCsEditObjUsing().equals( rhs.getOptionalCsEditObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjImplementation() != null ) {
				if( rhs.getOptionalCsEditObjImplementation() != null ) {
					if( ! getOptionalCsEditObjImplementation().equals( rhs.getOptionalCsEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableUsing() != null ) {
				if( rhs.getOptionalCsTableUsing() != null ) {
					if( ! getOptionalCsTableUsing().equals( rhs.getOptionalCsTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableMembers() != null ) {
				if( rhs.getOptionalCsTableMembers() != null ) {
					if( ! getOptionalCsTableMembers().equals( rhs.getOptionalCsTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableInterface() != null ) {
				if( rhs.getOptionalCsTableInterface() != null ) {
					if( ! getOptionalCsTableInterface().equals( rhs.getOptionalCsTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableImplementation() != null ) {
				if( rhs.getOptionalCsTableImplementation() != null ) {
					if( ! getOptionalCsTableImplementation().equals( rhs.getOptionalCsTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjUsing() != null ) {
				if( rhs.getOptionalCsTableObjUsing() != null ) {
					if( ! getOptionalCsTableObjUsing().equals( rhs.getOptionalCsTableObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjMembers() != null ) {
				if( rhs.getOptionalCsTableObjMembers() != null ) {
					if( ! getOptionalCsTableObjMembers().equals( rhs.getOptionalCsTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjInterface() != null ) {
				if( rhs.getOptionalCsTableObjInterface() != null ) {
					if( ! getOptionalCsTableObjInterface().equals( rhs.getOptionalCsTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjImplementation() != null ) {
				if( rhs.getOptionalCsTableObjImplementation() != null ) {
					if( ! getOptionalCsTableObjImplementation().equals( rhs.getOptionalCsTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWTableUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWTableUsing() != null ) {
					if( ! getOptionalCsDb2LUWTableUsing().equals( rhs.getOptionalCsDb2LUWTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWTableMembers() != null ) {
					if( ! getOptionalCsDb2LUWTableMembers().equals( rhs.getOptionalCsDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalCsDb2LUWTableImplementation() != null ) {
					if( ! getOptionalCsDb2LUWTableImplementation().equals( rhs.getOptionalCsDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlTableUsing() != null ) {
				if( rhs.getOptionalCsMSSqlTableUsing() != null ) {
					if( ! getOptionalCsMSSqlTableUsing().equals( rhs.getOptionalCsMSSqlTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlTableMembers() != null ) {
				if( rhs.getOptionalCsMSSqlTableMembers() != null ) {
					if( ! getOptionalCsMSSqlTableMembers().equals( rhs.getOptionalCsMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalCsMSSqlTableImplementation() != null ) {
					if( ! getOptionalCsMSSqlTableImplementation().equals( rhs.getOptionalCsMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlTableUsing() != null ) {
				if( rhs.getOptionalCsMySqlTableUsing() != null ) {
					if( ! getOptionalCsMySqlTableUsing().equals( rhs.getOptionalCsMySqlTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlTableMembers() != null ) {
				if( rhs.getOptionalCsMySqlTableMembers() != null ) {
					if( ! getOptionalCsMySqlTableMembers().equals( rhs.getOptionalCsMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlTableImplementation() != null ) {
				if( rhs.getOptionalCsMySqlTableImplementation() != null ) {
					if( ! getOptionalCsMySqlTableImplementation().equals( rhs.getOptionalCsMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleTableUsing() != null ) {
				if( rhs.getOptionalCsOracleTableUsing() != null ) {
					if( ! getOptionalCsOracleTableUsing().equals( rhs.getOptionalCsOracleTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleTableMembers() != null ) {
				if( rhs.getOptionalCsOracleTableMembers() != null ) {
					if( ! getOptionalCsOracleTableMembers().equals( rhs.getOptionalCsOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleTableImplementation() != null ) {
				if( rhs.getOptionalCsOracleTableImplementation() != null ) {
					if( ! getOptionalCsOracleTableImplementation().equals( rhs.getOptionalCsOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlTableUsing() != null ) {
				if( rhs.getOptionalCsPgSqlTableUsing() != null ) {
					if( ! getOptionalCsPgSqlTableUsing().equals( rhs.getOptionalCsPgSqlTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlTableMembers() != null ) {
				if( rhs.getOptionalCsPgSqlTableMembers() != null ) {
					if( ! getOptionalCsPgSqlTableMembers().equals( rhs.getOptionalCsPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalCsPgSqlTableImplementation() != null ) {
					if( ! getOptionalCsPgSqlTableImplementation().equals( rhs.getOptionalCsPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamTableUsing() != null ) {
				if( rhs.getOptionalCsRamTableUsing() != null ) {
					if( ! getOptionalCsRamTableUsing().equals( rhs.getOptionalCsRamTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamTableMembers() != null ) {
				if( rhs.getOptionalCsRamTableMembers() != null ) {
					if( ! getOptionalCsRamTableMembers().equals( rhs.getOptionalCsRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamTableImplementation() != null ) {
				if( rhs.getOptionalCsRamTableImplementation() != null ) {
					if( ! getOptionalCsRamTableImplementation().equals( rhs.getOptionalCsRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSaxLoaderUsing() != null ) {
				if( rhs.getOptionalCsSaxLoaderUsing() != null ) {
					if( ! getOptionalCsSaxLoaderUsing().equals( rhs.getOptionalCsSaxLoaderUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalCsSaxLoaderStartElement() != null ) {
					if( ! getOptionalCsSaxLoaderStartElement().equals( rhs.getOptionalCsSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalCsSaxLoaderEndElement() != null ) {
					if( ! getOptionalCsSaxLoaderEndElement().equals( rhs.getOptionalCsSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgTableUsing() != null ) {
					if( ! getOptionalCsXMsgTableUsing().equals( rhs.getOptionalCsXMsgTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgTableFormatters() != null ) {
				if( rhs.getOptionalCsXMsgTableFormatters() != null ) {
					if( ! getOptionalCsXMsgTableFormatters().equals( rhs.getOptionalCsXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstTableUsing() != null ) {
					if( ! getOptionalCsXMsgRqstTableUsing().equals( rhs.getOptionalCsXMsgRqstTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnTableUsing() != null ) {
					if( ! getOptionalCsXMsgRspnTableUsing().equals( rhs.getOptionalCsXMsgRspnTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientTableUsing() != null ) {
					if( ! getOptionalCsXMsgClientTableUsing().equals( rhs.getOptionalCsXMsgClientTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstTableBody() != null ) {
					if( ! getOptionalCsXMsgRqstTableBody().equals( rhs.getOptionalCsXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnTableBody() != null ) {
					if( ! getOptionalCsXMsgRspnTableBody().equals( rhs.getOptionalCsXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientTableBody() != null ) {
				if( rhs.getOptionalCsXMsgClientTableBody() != null ) {
					if( ! getOptionalCsXMsgClientTableBody().equals( rhs.getOptionalCsXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBuff ) {
			CFBamTableBuff rhs = (CFBamTableBuff)obj;
			if( ! super.equals( obj ) ) {
				return( false );
			}
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredId() != rhs.getRequiredId() ) {
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
			if( getRequiredPageData() != rhs.getRequiredPageData() ) {
				return( false );
			}
			if( getOptionalPrimaryIndexTenantId() != null ) {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					if( ! getOptionalPrimaryIndexTenantId().equals( rhs.getOptionalPrimaryIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
				return( false );
			}
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexTenantId() != null ) {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					if( ! getOptionalAltIndexTenantId().equals( rhs.getOptionalAltIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTenantId() != null ) {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					if( ! getOptionalQualifyingTenantId().equals( rhs.getOptionalQualifyingTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			if( getRequiredIsInstantiable() != rhs.getRequiredIsInstantiable() ) {
				return( false );
			}
			if( getRequiredHasHistory() != rhs.getRequiredHasHistory() ) {
				return( false );
			}
			if( getRequiredHasAuditColumns() != rhs.getRequiredHasAuditColumns() ) {
				return( false );
			}
			if( ! getRequiredLoaderBehaviour().equals( rhs.getRequiredLoaderBehaviour() ) ) {
				return( false );
			}
			if( ! getRequiredSecScope().equals( rhs.getRequiredSecScope() ) ) {
				return( false );
			}
			if( getOptionalJObjMembers() != null ) {
				if( rhs.getOptionalJObjMembers() != null ) {
					if( ! getOptionalJObjMembers().equals( rhs.getOptionalJObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjInterface() != null ) {
				if( rhs.getOptionalJObjInterface() != null ) {
					if( ! getOptionalJObjInterface().equals( rhs.getOptionalJObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImport() != null ) {
				if( rhs.getOptionalJObjImport() != null ) {
					if( ! getOptionalJObjImport().equals( rhs.getOptionalJObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJObjImplementation() != null ) {
				if( rhs.getOptionalJObjImplementation() != null ) {
					if( ! getOptionalJObjImplementation().equals( rhs.getOptionalJObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjMembers() != null ) {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					if( ! getOptionalJEditObjMembers().equals( rhs.getOptionalJEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjInterface() != null ) {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					if( ! getOptionalJEditObjInterface().equals( rhs.getOptionalJEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImport() != null ) {
				if( rhs.getOptionalJEditObjImport() != null ) {
					if( ! getOptionalJEditObjImport().equals( rhs.getOptionalJEditObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJEditObjImplementation() != null ) {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					if( ! getOptionalJEditObjImplementation().equals( rhs.getOptionalJEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImport() != null ) {
				if( rhs.getOptionalJTableImport() != null ) {
					if( ! getOptionalJTableImport().equals( rhs.getOptionalJTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableMembers() != null ) {
				if( rhs.getOptionalJTableMembers() != null ) {
					if( ! getOptionalJTableMembers().equals( rhs.getOptionalJTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableInterface() != null ) {
				if( rhs.getOptionalJTableInterface() != null ) {
					if( ! getOptionalJTableInterface().equals( rhs.getOptionalJTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableImplementation() != null ) {
				if( rhs.getOptionalJTableImplementation() != null ) {
					if( ! getOptionalJTableImplementation().equals( rhs.getOptionalJTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImport() != null ) {
				if( rhs.getOptionalJTableObjImport() != null ) {
					if( ! getOptionalJTableObjImport().equals( rhs.getOptionalJTableObjImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjMembers() != null ) {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					if( ! getOptionalJTableObjMembers().equals( rhs.getOptionalJTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjInterface() != null ) {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					if( ! getOptionalJTableObjInterface().equals( rhs.getOptionalJTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalJTableObjImplementation() != null ) {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					if( ! getOptionalJTableObjImplementation().equals( rhs.getOptionalJTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImport() != null ) {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					if( ! getOptionalJDb2LUWTableImport().equals( rhs.getOptionalJDb2LUWTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					if( ! getOptionalJDb2LUWTableMembers().equals( rhs.getOptionalJDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					if( ! getOptionalJDb2LUWTableImplementation().equals( rhs.getOptionalJDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImport() != null ) {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					if( ! getOptionalJMSSqlTableImport().equals( rhs.getOptionalJMSSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableMembers() != null ) {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					if( ! getOptionalJMSSqlTableMembers().equals( rhs.getOptionalJMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					if( ! getOptionalJMSSqlTableImplementation().equals( rhs.getOptionalJMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImport() != null ) {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					if( ! getOptionalJMySqlTableImport().equals( rhs.getOptionalJMySqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableMembers() != null ) {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					if( ! getOptionalJMySqlTableMembers().equals( rhs.getOptionalJMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJMySqlTableImplementation() != null ) {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					if( ! getOptionalJMySqlTableImplementation().equals( rhs.getOptionalJMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImport() != null ) {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					if( ! getOptionalJOracleTableImport().equals( rhs.getOptionalJOracleTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableMembers() != null ) {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					if( ! getOptionalJOracleTableMembers().equals( rhs.getOptionalJOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJOracleTableImplementation() != null ) {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					if( ! getOptionalJOracleTableImplementation().equals( rhs.getOptionalJOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImport() != null ) {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					if( ! getOptionalJPgSqlTableImport().equals( rhs.getOptionalJPgSqlTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableMembers() != null ) {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					if( ! getOptionalJPgSqlTableMembers().equals( rhs.getOptionalJPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					if( ! getOptionalJPgSqlTableImplementation().equals( rhs.getOptionalJPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImport() != null ) {
				if( rhs.getOptionalJRamTableImport() != null ) {
					if( ! getOptionalJRamTableImport().equals( rhs.getOptionalJRamTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableMembers() != null ) {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					if( ! getOptionalJRamTableMembers().equals( rhs.getOptionalJRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalJRamTableImplementation() != null ) {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					if( ! getOptionalJRamTableImplementation().equals( rhs.getOptionalJRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderImport() != null ) {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					if( ! getOptionalJSaxLoaderImport().equals( rhs.getOptionalJSaxLoaderImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					if( ! getOptionalJSaxLoaderStartElement().equals( rhs.getOptionalJSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					if( ! getOptionalJSaxLoaderEndElement().equals( rhs.getOptionalJSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableImport() != null ) {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					if( ! getOptionalJXMsgTableImport().equals( rhs.getOptionalJXMsgTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgTableFormatters() != null ) {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					if( ! getOptionalJXMsgTableFormatters().equals( rhs.getOptionalJXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableImport() != null ) {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					if( ! getOptionalJXMsgRqstTableImport().equals( rhs.getOptionalJXMsgRqstTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableImport() != null ) {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					if( ! getOptionalJXMsgRspnTableImport().equals( rhs.getOptionalJXMsgRspnTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableImport() != null ) {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					if( ! getOptionalJXMsgClientTableImport().equals( rhs.getOptionalJXMsgClientTableImport() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					if( ! getOptionalJXMsgRqstTableBody().equals( rhs.getOptionalJXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					if( ! getOptionalJXMsgRspnTableBody().equals( rhs.getOptionalJXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalJXMsgClientTableBody() != null ) {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					if( ! getOptionalJXMsgClientTableBody().equals( rhs.getOptionalJXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjMembers() != null ) {
				if( rhs.getOptionalCppObjMembers() != null ) {
					if( ! getOptionalCppObjMembers().equals( rhs.getOptionalCppObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjInterface() != null ) {
				if( rhs.getOptionalCppObjInterface() != null ) {
					if( ! getOptionalCppObjInterface().equals( rhs.getOptionalCppObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjInclude() != null ) {
				if( rhs.getOptionalCppObjInclude() != null ) {
					if( ! getOptionalCppObjInclude().equals( rhs.getOptionalCppObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppObjImplementation() != null ) {
				if( rhs.getOptionalCppObjImplementation() != null ) {
					if( ! getOptionalCppObjImplementation().equals( rhs.getOptionalCppObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjMembers() != null ) {
				if( rhs.getOptionalCppEditObjMembers() != null ) {
					if( ! getOptionalCppEditObjMembers().equals( rhs.getOptionalCppEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjInterface() != null ) {
				if( rhs.getOptionalCppEditObjInterface() != null ) {
					if( ! getOptionalCppEditObjInterface().equals( rhs.getOptionalCppEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjInclude() != null ) {
				if( rhs.getOptionalCppEditObjInclude() != null ) {
					if( ! getOptionalCppEditObjInclude().equals( rhs.getOptionalCppEditObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppEditObjImplementation() != null ) {
				if( rhs.getOptionalCppEditObjImplementation() != null ) {
					if( ! getOptionalCppEditObjImplementation().equals( rhs.getOptionalCppEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableInclude() != null ) {
				if( rhs.getOptionalCppTableInclude() != null ) {
					if( ! getOptionalCppTableInclude().equals( rhs.getOptionalCppTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableMembers() != null ) {
				if( rhs.getOptionalCppTableMembers() != null ) {
					if( ! getOptionalCppTableMembers().equals( rhs.getOptionalCppTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableInterface() != null ) {
				if( rhs.getOptionalCppTableInterface() != null ) {
					if( ! getOptionalCppTableInterface().equals( rhs.getOptionalCppTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableImplementation() != null ) {
				if( rhs.getOptionalCppTableImplementation() != null ) {
					if( ! getOptionalCppTableImplementation().equals( rhs.getOptionalCppTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjInclude() != null ) {
				if( rhs.getOptionalCppTableObjInclude() != null ) {
					if( ! getOptionalCppTableObjInclude().equals( rhs.getOptionalCppTableObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjMembers() != null ) {
				if( rhs.getOptionalCppTableObjMembers() != null ) {
					if( ! getOptionalCppTableObjMembers().equals( rhs.getOptionalCppTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjInterface() != null ) {
				if( rhs.getOptionalCppTableObjInterface() != null ) {
					if( ! getOptionalCppTableObjInterface().equals( rhs.getOptionalCppTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCppTableObjImplementation() != null ) {
				if( rhs.getOptionalCppTableObjImplementation() != null ) {
					if( ! getOptionalCppTableObjImplementation().equals( rhs.getOptionalCppTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWTableInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWTableInclude() != null ) {
					if( ! getOptionalCppDb2LUWTableInclude().equals( rhs.getOptionalCppDb2LUWTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWTableMembers() != null ) {
					if( ! getOptionalCppDb2LUWTableMembers().equals( rhs.getOptionalCppDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalCppDb2LUWTableImplementation() != null ) {
					if( ! getOptionalCppDb2LUWTableImplementation().equals( rhs.getOptionalCppDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlTableInclude() != null ) {
				if( rhs.getOptionalCppMSSqlTableInclude() != null ) {
					if( ! getOptionalCppMSSqlTableInclude().equals( rhs.getOptionalCppMSSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlTableMembers() != null ) {
				if( rhs.getOptionalCppMSSqlTableMembers() != null ) {
					if( ! getOptionalCppMSSqlTableMembers().equals( rhs.getOptionalCppMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalCppMSSqlTableImplementation() != null ) {
					if( ! getOptionalCppMSSqlTableImplementation().equals( rhs.getOptionalCppMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlTableInclude() != null ) {
				if( rhs.getOptionalCppMySqlTableInclude() != null ) {
					if( ! getOptionalCppMySqlTableInclude().equals( rhs.getOptionalCppMySqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlTableMembers() != null ) {
				if( rhs.getOptionalCppMySqlTableMembers() != null ) {
					if( ! getOptionalCppMySqlTableMembers().equals( rhs.getOptionalCppMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppMySqlTableImplementation() != null ) {
				if( rhs.getOptionalCppMySqlTableImplementation() != null ) {
					if( ! getOptionalCppMySqlTableImplementation().equals( rhs.getOptionalCppMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleTableInclude() != null ) {
				if( rhs.getOptionalCppOracleTableInclude() != null ) {
					if( ! getOptionalCppOracleTableInclude().equals( rhs.getOptionalCppOracleTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleTableMembers() != null ) {
				if( rhs.getOptionalCppOracleTableMembers() != null ) {
					if( ! getOptionalCppOracleTableMembers().equals( rhs.getOptionalCppOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppOracleTableImplementation() != null ) {
				if( rhs.getOptionalCppOracleTableImplementation() != null ) {
					if( ! getOptionalCppOracleTableImplementation().equals( rhs.getOptionalCppOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlTableInclude() != null ) {
				if( rhs.getOptionalCppPgSqlTableInclude() != null ) {
					if( ! getOptionalCppPgSqlTableInclude().equals( rhs.getOptionalCppPgSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlTableMembers() != null ) {
				if( rhs.getOptionalCppPgSqlTableMembers() != null ) {
					if( ! getOptionalCppPgSqlTableMembers().equals( rhs.getOptionalCppPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalCppPgSqlTableImplementation() != null ) {
					if( ! getOptionalCppPgSqlTableImplementation().equals( rhs.getOptionalCppPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamTableInclude() != null ) {
				if( rhs.getOptionalCppRamTableInclude() != null ) {
					if( ! getOptionalCppRamTableInclude().equals( rhs.getOptionalCppRamTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamTableMembers() != null ) {
				if( rhs.getOptionalCppRamTableMembers() != null ) {
					if( ! getOptionalCppRamTableMembers().equals( rhs.getOptionalCppRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCppRamTableImplementation() != null ) {
				if( rhs.getOptionalCppRamTableImplementation() != null ) {
					if( ! getOptionalCppRamTableImplementation().equals( rhs.getOptionalCppRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSaxLoaderInclude() != null ) {
				if( rhs.getOptionalCppSaxLoaderInclude() != null ) {
					if( ! getOptionalCppSaxLoaderInclude().equals( rhs.getOptionalCppSaxLoaderInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalCppSaxLoaderStartElement() != null ) {
					if( ! getOptionalCppSaxLoaderStartElement().equals( rhs.getOptionalCppSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCppSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalCppSaxLoaderEndElement() != null ) {
					if( ! getOptionalCppSaxLoaderEndElement().equals( rhs.getOptionalCppSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgTableInclude() != null ) {
					if( ! getOptionalCppXMsgTableInclude().equals( rhs.getOptionalCppXMsgTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgTableFormatters() != null ) {
				if( rhs.getOptionalCppXMsgTableFormatters() != null ) {
					if( ! getOptionalCppXMsgTableFormatters().equals( rhs.getOptionalCppXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstTableInclude() != null ) {
					if( ! getOptionalCppXMsgRqstTableInclude().equals( rhs.getOptionalCppXMsgRqstTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnTableInclude() != null ) {
					if( ! getOptionalCppXMsgRspnTableInclude().equals( rhs.getOptionalCppXMsgRspnTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientTableInclude() != null ) {
					if( ! getOptionalCppXMsgClientTableInclude().equals( rhs.getOptionalCppXMsgClientTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstTableBody() != null ) {
					if( ! getOptionalCppXMsgRqstTableBody().equals( rhs.getOptionalCppXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnTableBody() != null ) {
					if( ! getOptionalCppXMsgRspnTableBody().equals( rhs.getOptionalCppXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCppXMsgClientTableBody() != null ) {
				if( rhs.getOptionalCppXMsgClientTableBody() != null ) {
					if( ! getOptionalCppXMsgClientTableBody().equals( rhs.getOptionalCppXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjMembers() != null ) {
				if( rhs.getOptionalHppObjMembers() != null ) {
					if( ! getOptionalHppObjMembers().equals( rhs.getOptionalHppObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjInterface() != null ) {
				if( rhs.getOptionalHppObjInterface() != null ) {
					if( ! getOptionalHppObjInterface().equals( rhs.getOptionalHppObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjInclude() != null ) {
				if( rhs.getOptionalHppObjInclude() != null ) {
					if( ! getOptionalHppObjInclude().equals( rhs.getOptionalHppObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppObjImplementation() != null ) {
				if( rhs.getOptionalHppObjImplementation() != null ) {
					if( ! getOptionalHppObjImplementation().equals( rhs.getOptionalHppObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjMembers() != null ) {
				if( rhs.getOptionalHppEditObjMembers() != null ) {
					if( ! getOptionalHppEditObjMembers().equals( rhs.getOptionalHppEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjInterface() != null ) {
				if( rhs.getOptionalHppEditObjInterface() != null ) {
					if( ! getOptionalHppEditObjInterface().equals( rhs.getOptionalHppEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjInclude() != null ) {
				if( rhs.getOptionalHppEditObjInclude() != null ) {
					if( ! getOptionalHppEditObjInclude().equals( rhs.getOptionalHppEditObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppEditObjImplementation() != null ) {
				if( rhs.getOptionalHppEditObjImplementation() != null ) {
					if( ! getOptionalHppEditObjImplementation().equals( rhs.getOptionalHppEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableInclude() != null ) {
				if( rhs.getOptionalHppTableInclude() != null ) {
					if( ! getOptionalHppTableInclude().equals( rhs.getOptionalHppTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableMembers() != null ) {
				if( rhs.getOptionalHppTableMembers() != null ) {
					if( ! getOptionalHppTableMembers().equals( rhs.getOptionalHppTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableInterface() != null ) {
				if( rhs.getOptionalHppTableInterface() != null ) {
					if( ! getOptionalHppTableInterface().equals( rhs.getOptionalHppTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableImplementation() != null ) {
				if( rhs.getOptionalHppTableImplementation() != null ) {
					if( ! getOptionalHppTableImplementation().equals( rhs.getOptionalHppTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjInclude() != null ) {
				if( rhs.getOptionalHppTableObjInclude() != null ) {
					if( ! getOptionalHppTableObjInclude().equals( rhs.getOptionalHppTableObjInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjMembers() != null ) {
				if( rhs.getOptionalHppTableObjMembers() != null ) {
					if( ! getOptionalHppTableObjMembers().equals( rhs.getOptionalHppTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjInterface() != null ) {
				if( rhs.getOptionalHppTableObjInterface() != null ) {
					if( ! getOptionalHppTableObjInterface().equals( rhs.getOptionalHppTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalHppTableObjImplementation() != null ) {
				if( rhs.getOptionalHppTableObjImplementation() != null ) {
					if( ! getOptionalHppTableObjImplementation().equals( rhs.getOptionalHppTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWTableInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWTableInclude() != null ) {
					if( ! getOptionalHppDb2LUWTableInclude().equals( rhs.getOptionalHppDb2LUWTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWTableMembers() != null ) {
					if( ! getOptionalHppDb2LUWTableMembers().equals( rhs.getOptionalHppDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalHppDb2LUWTableImplementation() != null ) {
					if( ! getOptionalHppDb2LUWTableImplementation().equals( rhs.getOptionalHppDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlTableInclude() != null ) {
				if( rhs.getOptionalHppMSSqlTableInclude() != null ) {
					if( ! getOptionalHppMSSqlTableInclude().equals( rhs.getOptionalHppMSSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlTableMembers() != null ) {
				if( rhs.getOptionalHppMSSqlTableMembers() != null ) {
					if( ! getOptionalHppMSSqlTableMembers().equals( rhs.getOptionalHppMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalHppMSSqlTableImplementation() != null ) {
					if( ! getOptionalHppMSSqlTableImplementation().equals( rhs.getOptionalHppMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlTableInclude() != null ) {
				if( rhs.getOptionalHppMySqlTableInclude() != null ) {
					if( ! getOptionalHppMySqlTableInclude().equals( rhs.getOptionalHppMySqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlTableMembers() != null ) {
				if( rhs.getOptionalHppMySqlTableMembers() != null ) {
					if( ! getOptionalHppMySqlTableMembers().equals( rhs.getOptionalHppMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppMySqlTableImplementation() != null ) {
				if( rhs.getOptionalHppMySqlTableImplementation() != null ) {
					if( ! getOptionalHppMySqlTableImplementation().equals( rhs.getOptionalHppMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleTableInclude() != null ) {
				if( rhs.getOptionalHppOracleTableInclude() != null ) {
					if( ! getOptionalHppOracleTableInclude().equals( rhs.getOptionalHppOracleTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleTableMembers() != null ) {
				if( rhs.getOptionalHppOracleTableMembers() != null ) {
					if( ! getOptionalHppOracleTableMembers().equals( rhs.getOptionalHppOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppOracleTableImplementation() != null ) {
				if( rhs.getOptionalHppOracleTableImplementation() != null ) {
					if( ! getOptionalHppOracleTableImplementation().equals( rhs.getOptionalHppOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlTableInclude() != null ) {
				if( rhs.getOptionalHppPgSqlTableInclude() != null ) {
					if( ! getOptionalHppPgSqlTableInclude().equals( rhs.getOptionalHppPgSqlTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlTableMembers() != null ) {
				if( rhs.getOptionalHppPgSqlTableMembers() != null ) {
					if( ! getOptionalHppPgSqlTableMembers().equals( rhs.getOptionalHppPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalHppPgSqlTableImplementation() != null ) {
					if( ! getOptionalHppPgSqlTableImplementation().equals( rhs.getOptionalHppPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamTableInclude() != null ) {
				if( rhs.getOptionalHppRamTableInclude() != null ) {
					if( ! getOptionalHppRamTableInclude().equals( rhs.getOptionalHppRamTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamTableMembers() != null ) {
				if( rhs.getOptionalHppRamTableMembers() != null ) {
					if( ! getOptionalHppRamTableMembers().equals( rhs.getOptionalHppRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalHppRamTableImplementation() != null ) {
				if( rhs.getOptionalHppRamTableImplementation() != null ) {
					if( ! getOptionalHppRamTableImplementation().equals( rhs.getOptionalHppRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSaxLoaderInclude() != null ) {
				if( rhs.getOptionalHppSaxLoaderInclude() != null ) {
					if( ! getOptionalHppSaxLoaderInclude().equals( rhs.getOptionalHppSaxLoaderInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalHppSaxLoaderStartElement() != null ) {
					if( ! getOptionalHppSaxLoaderStartElement().equals( rhs.getOptionalHppSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalHppSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalHppSaxLoaderEndElement() != null ) {
					if( ! getOptionalHppSaxLoaderEndElement().equals( rhs.getOptionalHppSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgTableInclude() != null ) {
					if( ! getOptionalHppXMsgTableInclude().equals( rhs.getOptionalHppXMsgTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgTableFormatters() != null ) {
				if( rhs.getOptionalHppXMsgTableFormatters() != null ) {
					if( ! getOptionalHppXMsgTableFormatters().equals( rhs.getOptionalHppXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstTableInclude() != null ) {
					if( ! getOptionalHppXMsgRqstTableInclude().equals( rhs.getOptionalHppXMsgRqstTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnTableInclude() != null ) {
					if( ! getOptionalHppXMsgRspnTableInclude().equals( rhs.getOptionalHppXMsgRspnTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientTableInclude() != null ) {
					if( ! getOptionalHppXMsgClientTableInclude().equals( rhs.getOptionalHppXMsgClientTableInclude() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientTableInclude() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstTableBody() != null ) {
					if( ! getOptionalHppXMsgRqstTableBody().equals( rhs.getOptionalHppXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnTableBody() != null ) {
					if( ! getOptionalHppXMsgRspnTableBody().equals( rhs.getOptionalHppXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalHppXMsgClientTableBody() != null ) {
				if( rhs.getOptionalHppXMsgClientTableBody() != null ) {
					if( ! getOptionalHppXMsgClientTableBody().equals( rhs.getOptionalHppXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjMembers() != null ) {
				if( rhs.getOptionalCsObjMembers() != null ) {
					if( ! getOptionalCsObjMembers().equals( rhs.getOptionalCsObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjInterface() != null ) {
				if( rhs.getOptionalCsObjInterface() != null ) {
					if( ! getOptionalCsObjInterface().equals( rhs.getOptionalCsObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjUsing() != null ) {
				if( rhs.getOptionalCsObjUsing() != null ) {
					if( ! getOptionalCsObjUsing().equals( rhs.getOptionalCsObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsObjImplementation() != null ) {
				if( rhs.getOptionalCsObjImplementation() != null ) {
					if( ! getOptionalCsObjImplementation().equals( rhs.getOptionalCsObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjMembers() != null ) {
				if( rhs.getOptionalCsEditObjMembers() != null ) {
					if( ! getOptionalCsEditObjMembers().equals( rhs.getOptionalCsEditObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjInterface() != null ) {
				if( rhs.getOptionalCsEditObjInterface() != null ) {
					if( ! getOptionalCsEditObjInterface().equals( rhs.getOptionalCsEditObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjUsing() != null ) {
				if( rhs.getOptionalCsEditObjUsing() != null ) {
					if( ! getOptionalCsEditObjUsing().equals( rhs.getOptionalCsEditObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsEditObjImplementation() != null ) {
				if( rhs.getOptionalCsEditObjImplementation() != null ) {
					if( ! getOptionalCsEditObjImplementation().equals( rhs.getOptionalCsEditObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsEditObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableUsing() != null ) {
				if( rhs.getOptionalCsTableUsing() != null ) {
					if( ! getOptionalCsTableUsing().equals( rhs.getOptionalCsTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableMembers() != null ) {
				if( rhs.getOptionalCsTableMembers() != null ) {
					if( ! getOptionalCsTableMembers().equals( rhs.getOptionalCsTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableInterface() != null ) {
				if( rhs.getOptionalCsTableInterface() != null ) {
					if( ! getOptionalCsTableInterface().equals( rhs.getOptionalCsTableInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableImplementation() != null ) {
				if( rhs.getOptionalCsTableImplementation() != null ) {
					if( ! getOptionalCsTableImplementation().equals( rhs.getOptionalCsTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjUsing() != null ) {
				if( rhs.getOptionalCsTableObjUsing() != null ) {
					if( ! getOptionalCsTableObjUsing().equals( rhs.getOptionalCsTableObjUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjMembers() != null ) {
				if( rhs.getOptionalCsTableObjMembers() != null ) {
					if( ! getOptionalCsTableObjMembers().equals( rhs.getOptionalCsTableObjMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjInterface() != null ) {
				if( rhs.getOptionalCsTableObjInterface() != null ) {
					if( ! getOptionalCsTableObjInterface().equals( rhs.getOptionalCsTableObjInterface() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjInterface() != null ) {
					return( false );
				}
			}
			if( getOptionalCsTableObjImplementation() != null ) {
				if( rhs.getOptionalCsTableObjImplementation() != null ) {
					if( ! getOptionalCsTableObjImplementation().equals( rhs.getOptionalCsTableObjImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsTableObjImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWTableUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWTableUsing() != null ) {
					if( ! getOptionalCsDb2LUWTableUsing().equals( rhs.getOptionalCsDb2LUWTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWTableMembers() != null ) {
					if( ! getOptionalCsDb2LUWTableMembers().equals( rhs.getOptionalCsDb2LUWTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalCsDb2LUWTableImplementation() != null ) {
					if( ! getOptionalCsDb2LUWTableImplementation().equals( rhs.getOptionalCsDb2LUWTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlTableUsing() != null ) {
				if( rhs.getOptionalCsMSSqlTableUsing() != null ) {
					if( ! getOptionalCsMSSqlTableUsing().equals( rhs.getOptionalCsMSSqlTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlTableMembers() != null ) {
				if( rhs.getOptionalCsMSSqlTableMembers() != null ) {
					if( ! getOptionalCsMSSqlTableMembers().equals( rhs.getOptionalCsMSSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalCsMSSqlTableImplementation() != null ) {
					if( ! getOptionalCsMSSqlTableImplementation().equals( rhs.getOptionalCsMSSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlTableUsing() != null ) {
				if( rhs.getOptionalCsMySqlTableUsing() != null ) {
					if( ! getOptionalCsMySqlTableUsing().equals( rhs.getOptionalCsMySqlTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlTableMembers() != null ) {
				if( rhs.getOptionalCsMySqlTableMembers() != null ) {
					if( ! getOptionalCsMySqlTableMembers().equals( rhs.getOptionalCsMySqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsMySqlTableImplementation() != null ) {
				if( rhs.getOptionalCsMySqlTableImplementation() != null ) {
					if( ! getOptionalCsMySqlTableImplementation().equals( rhs.getOptionalCsMySqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleTableUsing() != null ) {
				if( rhs.getOptionalCsOracleTableUsing() != null ) {
					if( ! getOptionalCsOracleTableUsing().equals( rhs.getOptionalCsOracleTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleTableMembers() != null ) {
				if( rhs.getOptionalCsOracleTableMembers() != null ) {
					if( ! getOptionalCsOracleTableMembers().equals( rhs.getOptionalCsOracleTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsOracleTableImplementation() != null ) {
				if( rhs.getOptionalCsOracleTableImplementation() != null ) {
					if( ! getOptionalCsOracleTableImplementation().equals( rhs.getOptionalCsOracleTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlTableUsing() != null ) {
				if( rhs.getOptionalCsPgSqlTableUsing() != null ) {
					if( ! getOptionalCsPgSqlTableUsing().equals( rhs.getOptionalCsPgSqlTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlTableMembers() != null ) {
				if( rhs.getOptionalCsPgSqlTableMembers() != null ) {
					if( ! getOptionalCsPgSqlTableMembers().equals( rhs.getOptionalCsPgSqlTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalCsPgSqlTableImplementation() != null ) {
					if( ! getOptionalCsPgSqlTableImplementation().equals( rhs.getOptionalCsPgSqlTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamTableUsing() != null ) {
				if( rhs.getOptionalCsRamTableUsing() != null ) {
					if( ! getOptionalCsRamTableUsing().equals( rhs.getOptionalCsRamTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamTableMembers() != null ) {
				if( rhs.getOptionalCsRamTableMembers() != null ) {
					if( ! getOptionalCsRamTableMembers().equals( rhs.getOptionalCsRamTableMembers() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamTableMembers() != null ) {
					return( false );
				}
			}
			if( getOptionalCsRamTableImplementation() != null ) {
				if( rhs.getOptionalCsRamTableImplementation() != null ) {
					if( ! getOptionalCsRamTableImplementation().equals( rhs.getOptionalCsRamTableImplementation() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsRamTableImplementation() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSaxLoaderUsing() != null ) {
				if( rhs.getOptionalCsSaxLoaderUsing() != null ) {
					if( ! getOptionalCsSaxLoaderUsing().equals( rhs.getOptionalCsSaxLoaderUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalCsSaxLoaderStartElement() != null ) {
					if( ! getOptionalCsSaxLoaderStartElement().equals( rhs.getOptionalCsSaxLoaderStartElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderStartElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCsSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalCsSaxLoaderEndElement() != null ) {
					if( ! getOptionalCsSaxLoaderEndElement().equals( rhs.getOptionalCsSaxLoaderEndElement() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderEndElement() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgTableUsing() != null ) {
					if( ! getOptionalCsXMsgTableUsing().equals( rhs.getOptionalCsXMsgTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgTableFormatters() != null ) {
				if( rhs.getOptionalCsXMsgTableFormatters() != null ) {
					if( ! getOptionalCsXMsgTableFormatters().equals( rhs.getOptionalCsXMsgTableFormatters() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgTableFormatters() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstTableUsing() != null ) {
					if( ! getOptionalCsXMsgRqstTableUsing().equals( rhs.getOptionalCsXMsgRqstTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnTableUsing() != null ) {
					if( ! getOptionalCsXMsgRspnTableUsing().equals( rhs.getOptionalCsXMsgRspnTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientTableUsing() != null ) {
					if( ! getOptionalCsXMsgClientTableUsing().equals( rhs.getOptionalCsXMsgClientTableUsing() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientTableUsing() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstTableBody() != null ) {
					if( ! getOptionalCsXMsgRqstTableBody().equals( rhs.getOptionalCsXMsgRqstTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnTableBody() != null ) {
					if( ! getOptionalCsXMsgRspnTableBody().equals( rhs.getOptionalCsXMsgRspnTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnTableBody() != null ) {
					return( false );
				}
			}
			if( getOptionalCsXMsgClientTableBody() != null ) {
				if( rhs.getOptionalCsXMsgClientTableBody() != null ) {
					if( ! getOptionalCsXMsgClientTableBody().equals( rhs.getOptionalCsXMsgClientTableBody() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientTableBody() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBySchemaDefIdxKey ) {
			CFBamTableBySchemaDefIdxKey rhs = (CFBamTableBySchemaDefIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByDefSchemaIdxKey ) {
			CFBamTableByDefSchemaIdxKey rhs = (CFBamTableByDefSchemaIdxKey)obj;
			if( getOptionalDefSchemaTenantId() != null ) {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					if( ! getOptionalDefSchemaTenantId().equals( rhs.getOptionalDefSchemaTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByUNameIdxKey ) {
			CFBamTableByUNameIdxKey rhs = (CFBamTableByUNameIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableBySchemaCdIdxKey ) {
			CFBamTableBySchemaCdIdxKey rhs = (CFBamTableBySchemaCdIdxKey)obj;
			if( getRequiredTenantId() != rhs.getRequiredTenantId() ) {
				return( false );
			}
			if( getRequiredSchemaDefId() != rhs.getRequiredSchemaDefId() ) {
				return( false );
			}
			if( ! getRequiredTableClassCode().equals( rhs.getRequiredTableClassCode() ) ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByPrimaryIndexIdxKey ) {
			CFBamTableByPrimaryIndexIdxKey rhs = (CFBamTableByPrimaryIndexIdxKey)obj;
			if( getOptionalPrimaryIndexTenantId() != null ) {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					if( ! getOptionalPrimaryIndexTenantId().equals( rhs.getOptionalPrimaryIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					if( ! getOptionalPrimaryIndexId().equals( rhs.getOptionalPrimaryIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByLookupIndexIdxKey ) {
			CFBamTableByLookupIndexIdxKey rhs = (CFBamTableByLookupIndexIdxKey)obj;
			if( getOptionalLookupIndexTenantId() != null ) {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					if( ! getOptionalLookupIndexTenantId().equals( rhs.getOptionalLookupIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				if( rhs.getOptionalLookupIndexId() != null ) {
					if( ! getOptionalLookupIndexId().equals( rhs.getOptionalLookupIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByAltIndexIdxKey ) {
			CFBamTableByAltIndexIdxKey rhs = (CFBamTableByAltIndexIdxKey)obj;
			if( getOptionalAltIndexTenantId() != null ) {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					if( ! getOptionalAltIndexTenantId().equals( rhs.getOptionalAltIndexTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				if( rhs.getOptionalAltIndexId() != null ) {
					if( ! getOptionalAltIndexId().equals( rhs.getOptionalAltIndexId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof CFBamTableByQualTableIdxKey ) {
			CFBamTableByQualTableIdxKey rhs = (CFBamTableByQualTableIdxKey)obj;
			if( getOptionalQualifyingTenantId() != null ) {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					if( ! getOptionalQualifyingTenantId().equals( rhs.getOptionalQualifyingTenantId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( false );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					if( ! getOptionalQualifyingTableId().equals( rhs.getOptionalQualifyingTableId() ) ) {
						return( false );
					}
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( super.equals( obj ) );
		}
	}

	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + (int)( getRequiredSchemaDefId() );
		if( getOptionalDefSchemaTenantId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaTenantId().hashCode();
		}
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
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
		if( getRequiredPageData() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalPrimaryIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalPrimaryIndexTenantId().hashCode();
		}
		if( getOptionalPrimaryIndexId() != null ) {
			hashCode = hashCode + getOptionalPrimaryIndexId().hashCode();
		}
		if( getRequiredTableClassCode() != null ) {
			hashCode = hashCode + getRequiredTableClassCode().hashCode();
		}
		if( getOptionalLookupIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexTenantId().hashCode();
		}
		if( getOptionalLookupIndexId() != null ) {
			hashCode = hashCode + getOptionalLookupIndexId().hashCode();
		}
		if( getOptionalAltIndexTenantId() != null ) {
			hashCode = hashCode + getOptionalAltIndexTenantId().hashCode();
		}
		if( getOptionalAltIndexId() != null ) {
			hashCode = hashCode + getOptionalAltIndexId().hashCode();
		}
		if( getOptionalQualifyingTenantId() != null ) {
			hashCode = hashCode + getOptionalQualifyingTenantId().hashCode();
		}
		if( getOptionalQualifyingTableId() != null ) {
			hashCode = hashCode + getOptionalQualifyingTableId().hashCode();
		}
		if( getRequiredIsInstantiable() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredHasHistory() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getRequiredHasAuditColumns() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredLoaderBehaviour().ordinal();
		hashCode = ( hashCode * 0x10000 ) + getRequiredSecScope().ordinal();
		if( getOptionalJObjMembers() != null ) {
			hashCode = hashCode + getOptionalJObjMembers().hashCode();
		}
		if( getOptionalJObjInterface() != null ) {
			hashCode = hashCode + getOptionalJObjInterface().hashCode();
		}
		if( getOptionalJObjImport() != null ) {
			hashCode = hashCode + getOptionalJObjImport().hashCode();
		}
		if( getOptionalJObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJObjImplementation().hashCode();
		}
		if( getOptionalJEditObjMembers() != null ) {
			hashCode = hashCode + getOptionalJEditObjMembers().hashCode();
		}
		if( getOptionalJEditObjInterface() != null ) {
			hashCode = hashCode + getOptionalJEditObjInterface().hashCode();
		}
		if( getOptionalJEditObjImport() != null ) {
			hashCode = hashCode + getOptionalJEditObjImport().hashCode();
		}
		if( getOptionalJEditObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJEditObjImplementation().hashCode();
		}
		if( getOptionalJTableImport() != null ) {
			hashCode = hashCode + getOptionalJTableImport().hashCode();
		}
		if( getOptionalJTableMembers() != null ) {
			hashCode = hashCode + getOptionalJTableMembers().hashCode();
		}
		if( getOptionalJTableInterface() != null ) {
			hashCode = hashCode + getOptionalJTableInterface().hashCode();
		}
		if( getOptionalJTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJTableImplementation().hashCode();
		}
		if( getOptionalJTableObjImport() != null ) {
			hashCode = hashCode + getOptionalJTableObjImport().hashCode();
		}
		if( getOptionalJTableObjMembers() != null ) {
			hashCode = hashCode + getOptionalJTableObjMembers().hashCode();
		}
		if( getOptionalJTableObjInterface() != null ) {
			hashCode = hashCode + getOptionalJTableObjInterface().hashCode();
		}
		if( getOptionalJTableObjImplementation() != null ) {
			hashCode = hashCode + getOptionalJTableObjImplementation().hashCode();
		}
		if( getOptionalJDb2LUWTableImport() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWTableImport().hashCode();
		}
		if( getOptionalJDb2LUWTableMembers() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWTableMembers().hashCode();
		}
		if( getOptionalJDb2LUWTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJDb2LUWTableImplementation().hashCode();
		}
		if( getOptionalJMSSqlTableImport() != null ) {
			hashCode = hashCode + getOptionalJMSSqlTableImport().hashCode();
		}
		if( getOptionalJMSSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalJMSSqlTableMembers().hashCode();
		}
		if( getOptionalJMSSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJMSSqlTableImplementation().hashCode();
		}
		if( getOptionalJMySqlTableImport() != null ) {
			hashCode = hashCode + getOptionalJMySqlTableImport().hashCode();
		}
		if( getOptionalJMySqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalJMySqlTableMembers().hashCode();
		}
		if( getOptionalJMySqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJMySqlTableImplementation().hashCode();
		}
		if( getOptionalJOracleTableImport() != null ) {
			hashCode = hashCode + getOptionalJOracleTableImport().hashCode();
		}
		if( getOptionalJOracleTableMembers() != null ) {
			hashCode = hashCode + getOptionalJOracleTableMembers().hashCode();
		}
		if( getOptionalJOracleTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJOracleTableImplementation().hashCode();
		}
		if( getOptionalJPgSqlTableImport() != null ) {
			hashCode = hashCode + getOptionalJPgSqlTableImport().hashCode();
		}
		if( getOptionalJPgSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalJPgSqlTableMembers().hashCode();
		}
		if( getOptionalJPgSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJPgSqlTableImplementation().hashCode();
		}
		if( getOptionalJRamTableImport() != null ) {
			hashCode = hashCode + getOptionalJRamTableImport().hashCode();
		}
		if( getOptionalJRamTableMembers() != null ) {
			hashCode = hashCode + getOptionalJRamTableMembers().hashCode();
		}
		if( getOptionalJRamTableImplementation() != null ) {
			hashCode = hashCode + getOptionalJRamTableImplementation().hashCode();
		}
		if( getOptionalJSaxLoaderImport() != null ) {
			hashCode = hashCode + getOptionalJSaxLoaderImport().hashCode();
		}
		if( getOptionalJSaxLoaderStartElement() != null ) {
			hashCode = hashCode + getOptionalJSaxLoaderStartElement().hashCode();
		}
		if( getOptionalJSaxLoaderEndElement() != null ) {
			hashCode = hashCode + getOptionalJSaxLoaderEndElement().hashCode();
		}
		if( getOptionalJXMsgTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgTableImport().hashCode();
		}
		if( getOptionalJXMsgTableFormatters() != null ) {
			hashCode = hashCode + getOptionalJXMsgTableFormatters().hashCode();
		}
		if( getOptionalJXMsgRqstTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstTableImport().hashCode();
		}
		if( getOptionalJXMsgRspnTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnTableImport().hashCode();
		}
		if( getOptionalJXMsgClientTableImport() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientTableImport().hashCode();
		}
		if( getOptionalJXMsgRqstTableBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRqstTableBody().hashCode();
		}
		if( getOptionalJXMsgRspnTableBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgRspnTableBody().hashCode();
		}
		if( getOptionalJXMsgClientTableBody() != null ) {
			hashCode = hashCode + getOptionalJXMsgClientTableBody().hashCode();
		}
		if( getOptionalCppObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppObjMembers().hashCode();
		}
		if( getOptionalCppObjInterface() != null ) {
			hashCode = hashCode + getOptionalCppObjInterface().hashCode();
		}
		if( getOptionalCppObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppObjInclude().hashCode();
		}
		if( getOptionalCppObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCppObjImplementation().hashCode();
		}
		if( getOptionalCppEditObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppEditObjMembers().hashCode();
		}
		if( getOptionalCppEditObjInterface() != null ) {
			hashCode = hashCode + getOptionalCppEditObjInterface().hashCode();
		}
		if( getOptionalCppEditObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppEditObjInclude().hashCode();
		}
		if( getOptionalCppEditObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCppEditObjImplementation().hashCode();
		}
		if( getOptionalCppTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppTableInclude().hashCode();
		}
		if( getOptionalCppTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppTableMembers().hashCode();
		}
		if( getOptionalCppTableInterface() != null ) {
			hashCode = hashCode + getOptionalCppTableInterface().hashCode();
		}
		if( getOptionalCppTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppTableImplementation().hashCode();
		}
		if( getOptionalCppTableObjInclude() != null ) {
			hashCode = hashCode + getOptionalCppTableObjInclude().hashCode();
		}
		if( getOptionalCppTableObjMembers() != null ) {
			hashCode = hashCode + getOptionalCppTableObjMembers().hashCode();
		}
		if( getOptionalCppTableObjInterface() != null ) {
			hashCode = hashCode + getOptionalCppTableObjInterface().hashCode();
		}
		if( getOptionalCppTableObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCppTableObjImplementation().hashCode();
		}
		if( getOptionalCppDb2LUWTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppDb2LUWTableInclude().hashCode();
		}
		if( getOptionalCppDb2LUWTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppDb2LUWTableMembers().hashCode();
		}
		if( getOptionalCppDb2LUWTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppDb2LUWTableImplementation().hashCode();
		}
		if( getOptionalCppMSSqlTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppMSSqlTableInclude().hashCode();
		}
		if( getOptionalCppMSSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppMSSqlTableMembers().hashCode();
		}
		if( getOptionalCppMSSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppMSSqlTableImplementation().hashCode();
		}
		if( getOptionalCppMySqlTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppMySqlTableInclude().hashCode();
		}
		if( getOptionalCppMySqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppMySqlTableMembers().hashCode();
		}
		if( getOptionalCppMySqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppMySqlTableImplementation().hashCode();
		}
		if( getOptionalCppOracleTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppOracleTableInclude().hashCode();
		}
		if( getOptionalCppOracleTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppOracleTableMembers().hashCode();
		}
		if( getOptionalCppOracleTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppOracleTableImplementation().hashCode();
		}
		if( getOptionalCppPgSqlTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppPgSqlTableInclude().hashCode();
		}
		if( getOptionalCppPgSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppPgSqlTableMembers().hashCode();
		}
		if( getOptionalCppPgSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppPgSqlTableImplementation().hashCode();
		}
		if( getOptionalCppRamTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppRamTableInclude().hashCode();
		}
		if( getOptionalCppRamTableMembers() != null ) {
			hashCode = hashCode + getOptionalCppRamTableMembers().hashCode();
		}
		if( getOptionalCppRamTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCppRamTableImplementation().hashCode();
		}
		if( getOptionalCppSaxLoaderInclude() != null ) {
			hashCode = hashCode + getOptionalCppSaxLoaderInclude().hashCode();
		}
		if( getOptionalCppSaxLoaderStartElement() != null ) {
			hashCode = hashCode + getOptionalCppSaxLoaderStartElement().hashCode();
		}
		if( getOptionalCppSaxLoaderEndElement() != null ) {
			hashCode = hashCode + getOptionalCppSaxLoaderEndElement().hashCode();
		}
		if( getOptionalCppXMsgTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgTableInclude().hashCode();
		}
		if( getOptionalCppXMsgTableFormatters() != null ) {
			hashCode = hashCode + getOptionalCppXMsgTableFormatters().hashCode();
		}
		if( getOptionalCppXMsgRqstTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstTableInclude().hashCode();
		}
		if( getOptionalCppXMsgRspnTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnTableInclude().hashCode();
		}
		if( getOptionalCppXMsgClientTableInclude() != null ) {
			hashCode = hashCode + getOptionalCppXMsgClientTableInclude().hashCode();
		}
		if( getOptionalCppXMsgRqstTableBody() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRqstTableBody().hashCode();
		}
		if( getOptionalCppXMsgRspnTableBody() != null ) {
			hashCode = hashCode + getOptionalCppXMsgRspnTableBody().hashCode();
		}
		if( getOptionalCppXMsgClientTableBody() != null ) {
			hashCode = hashCode + getOptionalCppXMsgClientTableBody().hashCode();
		}
		if( getOptionalHppObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppObjMembers().hashCode();
		}
		if( getOptionalHppObjInterface() != null ) {
			hashCode = hashCode + getOptionalHppObjInterface().hashCode();
		}
		if( getOptionalHppObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppObjInclude().hashCode();
		}
		if( getOptionalHppObjImplementation() != null ) {
			hashCode = hashCode + getOptionalHppObjImplementation().hashCode();
		}
		if( getOptionalHppEditObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppEditObjMembers().hashCode();
		}
		if( getOptionalHppEditObjInterface() != null ) {
			hashCode = hashCode + getOptionalHppEditObjInterface().hashCode();
		}
		if( getOptionalHppEditObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppEditObjInclude().hashCode();
		}
		if( getOptionalHppEditObjImplementation() != null ) {
			hashCode = hashCode + getOptionalHppEditObjImplementation().hashCode();
		}
		if( getOptionalHppTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppTableInclude().hashCode();
		}
		if( getOptionalHppTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppTableMembers().hashCode();
		}
		if( getOptionalHppTableInterface() != null ) {
			hashCode = hashCode + getOptionalHppTableInterface().hashCode();
		}
		if( getOptionalHppTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppTableImplementation().hashCode();
		}
		if( getOptionalHppTableObjInclude() != null ) {
			hashCode = hashCode + getOptionalHppTableObjInclude().hashCode();
		}
		if( getOptionalHppTableObjMembers() != null ) {
			hashCode = hashCode + getOptionalHppTableObjMembers().hashCode();
		}
		if( getOptionalHppTableObjInterface() != null ) {
			hashCode = hashCode + getOptionalHppTableObjInterface().hashCode();
		}
		if( getOptionalHppTableObjImplementation() != null ) {
			hashCode = hashCode + getOptionalHppTableObjImplementation().hashCode();
		}
		if( getOptionalHppDb2LUWTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppDb2LUWTableInclude().hashCode();
		}
		if( getOptionalHppDb2LUWTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppDb2LUWTableMembers().hashCode();
		}
		if( getOptionalHppDb2LUWTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppDb2LUWTableImplementation().hashCode();
		}
		if( getOptionalHppMSSqlTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppMSSqlTableInclude().hashCode();
		}
		if( getOptionalHppMSSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppMSSqlTableMembers().hashCode();
		}
		if( getOptionalHppMSSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppMSSqlTableImplementation().hashCode();
		}
		if( getOptionalHppMySqlTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppMySqlTableInclude().hashCode();
		}
		if( getOptionalHppMySqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppMySqlTableMembers().hashCode();
		}
		if( getOptionalHppMySqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppMySqlTableImplementation().hashCode();
		}
		if( getOptionalHppOracleTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppOracleTableInclude().hashCode();
		}
		if( getOptionalHppOracleTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppOracleTableMembers().hashCode();
		}
		if( getOptionalHppOracleTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppOracleTableImplementation().hashCode();
		}
		if( getOptionalHppPgSqlTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppPgSqlTableInclude().hashCode();
		}
		if( getOptionalHppPgSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppPgSqlTableMembers().hashCode();
		}
		if( getOptionalHppPgSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppPgSqlTableImplementation().hashCode();
		}
		if( getOptionalHppRamTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppRamTableInclude().hashCode();
		}
		if( getOptionalHppRamTableMembers() != null ) {
			hashCode = hashCode + getOptionalHppRamTableMembers().hashCode();
		}
		if( getOptionalHppRamTableImplementation() != null ) {
			hashCode = hashCode + getOptionalHppRamTableImplementation().hashCode();
		}
		if( getOptionalHppSaxLoaderInclude() != null ) {
			hashCode = hashCode + getOptionalHppSaxLoaderInclude().hashCode();
		}
		if( getOptionalHppSaxLoaderStartElement() != null ) {
			hashCode = hashCode + getOptionalHppSaxLoaderStartElement().hashCode();
		}
		if( getOptionalHppSaxLoaderEndElement() != null ) {
			hashCode = hashCode + getOptionalHppSaxLoaderEndElement().hashCode();
		}
		if( getOptionalHppXMsgTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgTableInclude().hashCode();
		}
		if( getOptionalHppXMsgTableFormatters() != null ) {
			hashCode = hashCode + getOptionalHppXMsgTableFormatters().hashCode();
		}
		if( getOptionalHppXMsgRqstTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstTableInclude().hashCode();
		}
		if( getOptionalHppXMsgRspnTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnTableInclude().hashCode();
		}
		if( getOptionalHppXMsgClientTableInclude() != null ) {
			hashCode = hashCode + getOptionalHppXMsgClientTableInclude().hashCode();
		}
		if( getOptionalHppXMsgRqstTableBody() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRqstTableBody().hashCode();
		}
		if( getOptionalHppXMsgRspnTableBody() != null ) {
			hashCode = hashCode + getOptionalHppXMsgRspnTableBody().hashCode();
		}
		if( getOptionalHppXMsgClientTableBody() != null ) {
			hashCode = hashCode + getOptionalHppXMsgClientTableBody().hashCode();
		}
		if( getOptionalCsObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsObjMembers().hashCode();
		}
		if( getOptionalCsObjInterface() != null ) {
			hashCode = hashCode + getOptionalCsObjInterface().hashCode();
		}
		if( getOptionalCsObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsObjUsing().hashCode();
		}
		if( getOptionalCsObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCsObjImplementation().hashCode();
		}
		if( getOptionalCsEditObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsEditObjMembers().hashCode();
		}
		if( getOptionalCsEditObjInterface() != null ) {
			hashCode = hashCode + getOptionalCsEditObjInterface().hashCode();
		}
		if( getOptionalCsEditObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsEditObjUsing().hashCode();
		}
		if( getOptionalCsEditObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCsEditObjImplementation().hashCode();
		}
		if( getOptionalCsTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsTableUsing().hashCode();
		}
		if( getOptionalCsTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsTableMembers().hashCode();
		}
		if( getOptionalCsTableInterface() != null ) {
			hashCode = hashCode + getOptionalCsTableInterface().hashCode();
		}
		if( getOptionalCsTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsTableImplementation().hashCode();
		}
		if( getOptionalCsTableObjUsing() != null ) {
			hashCode = hashCode + getOptionalCsTableObjUsing().hashCode();
		}
		if( getOptionalCsTableObjMembers() != null ) {
			hashCode = hashCode + getOptionalCsTableObjMembers().hashCode();
		}
		if( getOptionalCsTableObjInterface() != null ) {
			hashCode = hashCode + getOptionalCsTableObjInterface().hashCode();
		}
		if( getOptionalCsTableObjImplementation() != null ) {
			hashCode = hashCode + getOptionalCsTableObjImplementation().hashCode();
		}
		if( getOptionalCsDb2LUWTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsDb2LUWTableUsing().hashCode();
		}
		if( getOptionalCsDb2LUWTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsDb2LUWTableMembers().hashCode();
		}
		if( getOptionalCsDb2LUWTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsDb2LUWTableImplementation().hashCode();
		}
		if( getOptionalCsMSSqlTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsMSSqlTableUsing().hashCode();
		}
		if( getOptionalCsMSSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsMSSqlTableMembers().hashCode();
		}
		if( getOptionalCsMSSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsMSSqlTableImplementation().hashCode();
		}
		if( getOptionalCsMySqlTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsMySqlTableUsing().hashCode();
		}
		if( getOptionalCsMySqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsMySqlTableMembers().hashCode();
		}
		if( getOptionalCsMySqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsMySqlTableImplementation().hashCode();
		}
		if( getOptionalCsOracleTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsOracleTableUsing().hashCode();
		}
		if( getOptionalCsOracleTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsOracleTableMembers().hashCode();
		}
		if( getOptionalCsOracleTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsOracleTableImplementation().hashCode();
		}
		if( getOptionalCsPgSqlTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsPgSqlTableUsing().hashCode();
		}
		if( getOptionalCsPgSqlTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsPgSqlTableMembers().hashCode();
		}
		if( getOptionalCsPgSqlTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsPgSqlTableImplementation().hashCode();
		}
		if( getOptionalCsRamTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsRamTableUsing().hashCode();
		}
		if( getOptionalCsRamTableMembers() != null ) {
			hashCode = hashCode + getOptionalCsRamTableMembers().hashCode();
		}
		if( getOptionalCsRamTableImplementation() != null ) {
			hashCode = hashCode + getOptionalCsRamTableImplementation().hashCode();
		}
		if( getOptionalCsSaxLoaderUsing() != null ) {
			hashCode = hashCode + getOptionalCsSaxLoaderUsing().hashCode();
		}
		if( getOptionalCsSaxLoaderStartElement() != null ) {
			hashCode = hashCode + getOptionalCsSaxLoaderStartElement().hashCode();
		}
		if( getOptionalCsSaxLoaderEndElement() != null ) {
			hashCode = hashCode + getOptionalCsSaxLoaderEndElement().hashCode();
		}
		if( getOptionalCsXMsgTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgTableUsing().hashCode();
		}
		if( getOptionalCsXMsgTableFormatters() != null ) {
			hashCode = hashCode + getOptionalCsXMsgTableFormatters().hashCode();
		}
		if( getOptionalCsXMsgRqstTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstTableUsing().hashCode();
		}
		if( getOptionalCsXMsgRspnTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnTableUsing().hashCode();
		}
		if( getOptionalCsXMsgClientTableUsing() != null ) {
			hashCode = hashCode + getOptionalCsXMsgClientTableUsing().hashCode();
		}
		if( getOptionalCsXMsgRqstTableBody() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRqstTableBody().hashCode();
		}
		if( getOptionalCsXMsgRspnTableBody() != null ) {
			hashCode = hashCode + getOptionalCsXMsgRspnTableBody().hashCode();
		}
		if( getOptionalCsXMsgClientTableBody() != null ) {
			hashCode = hashCode + getOptionalCsXMsgClientTableBody().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	public int compareTo( Object obj ) {
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof CFBamTableBuff ) {
			CFBamTableBuff rhs = (CFBamTableBuff)obj;
			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			return( 0 );
		}
		else if( obj instanceof CFBamTableBySchemaDefIdxKey ) {
			CFBamTableBySchemaDefIdxKey rhs = (CFBamTableBySchemaDefIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByDefSchemaIdxKey ) {
			CFBamTableByDefSchemaIdxKey rhs = (CFBamTableByDefSchemaIdxKey)obj;

			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByUNameIdxKey ) {
			CFBamTableByUNameIdxKey rhs = (CFBamTableByUNameIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredName().compareTo( rhs.getRequiredName() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableBySchemaCdIdxKey ) {
			CFBamTableBySchemaCdIdxKey rhs = (CFBamTableBySchemaCdIdxKey)obj;

			if( getRequiredTenantId() < rhs.getRequiredTenantId() ) {
				return( -1 );
			}
			else if( getRequiredTenantId() > rhs.getRequiredTenantId() ) {
				return( 1 );
			}
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}
			{
				int cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByPrimaryIndexIdxKey ) {
			CFBamTableByPrimaryIndexIdxKey rhs = (CFBamTableByPrimaryIndexIdxKey)obj;

			if( getOptionalPrimaryIndexTenantId() != null ) {
				Long lhsPrimaryIndexTenantId = getOptionalPrimaryIndexTenantId();
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					Long rhsPrimaryIndexTenantId = rhs.getOptionalPrimaryIndexTenantId();
					int cmp = lhsPrimaryIndexTenantId.compareTo( rhsPrimaryIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				Long lhsPrimaryIndexId = getOptionalPrimaryIndexId();
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					Long rhsPrimaryIndexId = rhs.getOptionalPrimaryIndexId();
					int cmp = lhsPrimaryIndexId.compareTo( rhsPrimaryIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByLookupIndexIdxKey ) {
			CFBamTableByLookupIndexIdxKey rhs = (CFBamTableByLookupIndexIdxKey)obj;

			if( getOptionalLookupIndexTenantId() != null ) {
				Long lhsLookupIndexTenantId = getOptionalLookupIndexTenantId();
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					Long rhsLookupIndexTenantId = rhs.getOptionalLookupIndexTenantId();
					int cmp = lhsLookupIndexTenantId.compareTo( rhsLookupIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				Long lhsLookupIndexId = getOptionalLookupIndexId();
				if( rhs.getOptionalLookupIndexId() != null ) {
					Long rhsLookupIndexId = rhs.getOptionalLookupIndexId();
					int cmp = lhsLookupIndexId.compareTo( rhsLookupIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByAltIndexIdxKey ) {
			CFBamTableByAltIndexIdxKey rhs = (CFBamTableByAltIndexIdxKey)obj;

			if( getOptionalAltIndexTenantId() != null ) {
				Long lhsAltIndexTenantId = getOptionalAltIndexTenantId();
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					Long rhsAltIndexTenantId = rhs.getOptionalAltIndexTenantId();
					int cmp = lhsAltIndexTenantId.compareTo( rhsAltIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				Long lhsAltIndexId = getOptionalAltIndexId();
				if( rhs.getOptionalAltIndexId() != null ) {
					Long rhsAltIndexId = rhs.getOptionalAltIndexId();
					int cmp = lhsAltIndexId.compareTo( rhsAltIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableByQualTableIdxKey ) {
			CFBamTableByQualTableIdxKey rhs = (CFBamTableByQualTableIdxKey)obj;

			if( getOptionalQualifyingTenantId() != null ) {
				Long lhsQualifyingTenantId = getOptionalQualifyingTenantId();
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					Long rhsQualifyingTenantId = rhs.getOptionalQualifyingTenantId();
					int cmp = lhsQualifyingTenantId.compareTo( rhsQualifyingTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				Long lhsQualifyingTableId = getOptionalQualifyingTableId();
				if( rhs.getOptionalQualifyingTableId() != null ) {
					Long rhsQualifyingTableId = rhs.getOptionalQualifyingTableId();
					int cmp = lhsQualifyingTableId.compareTo( rhsQualifyingTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof CFBamTableHBuff ) {
			CFBamTableHBuff rhs = (CFBamTableHBuff)obj;

			int retval = super.compareTo( rhs );
			if( retval != 0 ) {
				return( retval );
			}
			{
				long lhsAuditClusterId = getAuditClusterId();
				long rhsAuditClusterId = rhs.getAuditClusterId();
				if( lhsAuditClusterId < rhsAuditClusterId ) {
					return( -1 );
				}
				else if( lhsAuditClusterId > rhsAuditClusterId ) {
					return( 1 );
				}
			}
			{
				Calendar lhsAuditStamp = getAuditStamp();
				Calendar rhsAuditStamp = rhs.getAuditStamp();
				if( lhsAuditStamp == null ) {
					if( rhsAuditStamp != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditStamp == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditStamp.compareTo( rhsAuditStamp );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
				}
			}
			{
				short lhsAuditActionId = getAuditActionId();
				short rhsAuditActionId = rhs.getAuditActionId();
				if( lhsAuditActionId < rhsAuditActionId ) {
					return( -1 );
				}
				else if( lhsAuditActionId > rhsAuditActionId ) {
					return( 1 );
				}
			}
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
			{
				UUID lhsAuditSessionId = getAuditSessionId();
				UUID rhsAuditSessionId = rhs.getAuditSessionId();
				if( lhsAuditSessionId == null ) {
					if( rhsAuditSessionId != null ) {
						return( -1 );
					}
				}
				else if( rhsAuditSessionId == null ) {
					return( 1 );
				}
				else {
					int cmpstat = lhsAuditSessionId.compareTo( rhsAuditSessionId );
					if( cmpstat != 0 ) {
						return( cmpstat );
					}
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
			if( getRequiredSchemaDefId() < rhs.getRequiredSchemaDefId() ) {
				return( -1 );
			}
			else if( getRequiredSchemaDefId() > rhs.getRequiredSchemaDefId() ) {
				return( 1 );
			}
			if( getOptionalDefSchemaTenantId() != null ) {
				Long lhsDefSchemaTenantId = getOptionalDefSchemaTenantId();
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					Long rhsDefSchemaTenantId = rhs.getOptionalDefSchemaTenantId();
					int cmp = lhsDefSchemaTenantId.compareTo( rhsDefSchemaTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				Long lhsDefSchemaId = getOptionalDefSchemaId();
				if( rhs.getOptionalDefSchemaId() != null ) {
					Long rhsDefSchemaId = rhs.getOptionalDefSchemaId();
					int cmp = lhsDefSchemaId.compareTo( rhsDefSchemaId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
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
			if( getRequiredPageData() ) {
				if( ! rhs.getRequiredPageData() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredPageData() ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexTenantId() != null ) {
				Long lhsPrimaryIndexTenantId = getOptionalPrimaryIndexTenantId();
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					Long rhsPrimaryIndexTenantId = rhs.getOptionalPrimaryIndexTenantId();
					int cmp = lhsPrimaryIndexTenantId.compareTo( rhsPrimaryIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrimaryIndexId() != null ) {
				Long lhsPrimaryIndexId = getOptionalPrimaryIndexId();
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					Long rhsPrimaryIndexId = rhs.getOptionalPrimaryIndexId();
					int cmp = lhsPrimaryIndexId.compareTo( rhsPrimaryIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrimaryIndexId() != null ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredTableClassCode().compareTo( rhs.getRequiredTableClassCode() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalLookupIndexTenantId() != null ) {
				Long lhsLookupIndexTenantId = getOptionalLookupIndexTenantId();
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					Long rhsLookupIndexTenantId = rhs.getOptionalLookupIndexTenantId();
					int cmp = lhsLookupIndexTenantId.compareTo( rhsLookupIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLookupIndexId() != null ) {
				Long lhsLookupIndexId = getOptionalLookupIndexId();
				if( rhs.getOptionalLookupIndexId() != null ) {
					Long rhsLookupIndexId = rhs.getOptionalLookupIndexId();
					int cmp = lhsLookupIndexId.compareTo( rhsLookupIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLookupIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexTenantId() != null ) {
				Long lhsAltIndexTenantId = getOptionalAltIndexTenantId();
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					Long rhsAltIndexTenantId = rhs.getOptionalAltIndexTenantId();
					int cmp = lhsAltIndexTenantId.compareTo( rhsAltIndexTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalAltIndexId() != null ) {
				Long lhsAltIndexId = getOptionalAltIndexId();
				if( rhs.getOptionalAltIndexId() != null ) {
					Long rhsAltIndexId = rhs.getOptionalAltIndexId();
					int cmp = lhsAltIndexId.compareTo( rhsAltIndexId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalAltIndexId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTenantId() != null ) {
				Long lhsQualifyingTenantId = getOptionalQualifyingTenantId();
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					Long rhsQualifyingTenantId = rhs.getOptionalQualifyingTenantId();
					int cmp = lhsQualifyingTenantId.compareTo( rhsQualifyingTenantId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTenantId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalQualifyingTableId() != null ) {
				Long lhsQualifyingTableId = getOptionalQualifyingTableId();
				if( rhs.getOptionalQualifyingTableId() != null ) {
					Long rhsQualifyingTableId = rhs.getOptionalQualifyingTableId();
					int cmp = lhsQualifyingTableId.compareTo( rhsQualifyingTableId );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalQualifyingTableId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsInstantiable() ) {
				if( ! rhs.getRequiredIsInstantiable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsInstantiable() ) {
					return( -1 );
				}
			}
			if( getRequiredHasHistory() ) {
				if( ! rhs.getRequiredHasHistory() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasHistory() ) {
					return( -1 );
				}
			}
			if( getRequiredHasAuditColumns() ) {
				if( ! rhs.getRequiredHasAuditColumns() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredHasAuditColumns() ) {
					return( -1 );
				}
			}
			{
				int cmp = getRequiredLoaderBehaviour().compareTo( rhs.getRequiredLoaderBehaviour() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			{
				int cmp = getRequiredSecScope().compareTo( rhs.getRequiredSecScope() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getOptionalJObjMembers() != null ) {
				if( rhs.getOptionalJObjMembers() != null ) {
					int cmp = getOptionalJObjMembers().compareTo( rhs.getOptionalJObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjInterface() != null ) {
				if( rhs.getOptionalJObjInterface() != null ) {
					int cmp = getOptionalJObjInterface().compareTo( rhs.getOptionalJObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjImport() != null ) {
				if( rhs.getOptionalJObjImport() != null ) {
					int cmp = getOptionalJObjImport().compareTo( rhs.getOptionalJObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJObjImplementation() != null ) {
				if( rhs.getOptionalJObjImplementation() != null ) {
					int cmp = getOptionalJObjImplementation().compareTo( rhs.getOptionalJObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjMembers() != null ) {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					int cmp = getOptionalJEditObjMembers().compareTo( rhs.getOptionalJEditObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjInterface() != null ) {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					int cmp = getOptionalJEditObjInterface().compareTo( rhs.getOptionalJEditObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjImport() != null ) {
				if( rhs.getOptionalJEditObjImport() != null ) {
					int cmp = getOptionalJEditObjImport().compareTo( rhs.getOptionalJEditObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJEditObjImplementation() != null ) {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					int cmp = getOptionalJEditObjImplementation().compareTo( rhs.getOptionalJEditObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJEditObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableImport() != null ) {
				if( rhs.getOptionalJTableImport() != null ) {
					int cmp = getOptionalJTableImport().compareTo( rhs.getOptionalJTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableMembers() != null ) {
				if( rhs.getOptionalJTableMembers() != null ) {
					int cmp = getOptionalJTableMembers().compareTo( rhs.getOptionalJTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableInterface() != null ) {
				if( rhs.getOptionalJTableInterface() != null ) {
					int cmp = getOptionalJTableInterface().compareTo( rhs.getOptionalJTableInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableImplementation() != null ) {
				if( rhs.getOptionalJTableImplementation() != null ) {
					int cmp = getOptionalJTableImplementation().compareTo( rhs.getOptionalJTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjImport() != null ) {
				if( rhs.getOptionalJTableObjImport() != null ) {
					int cmp = getOptionalJTableObjImport().compareTo( rhs.getOptionalJTableObjImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjMembers() != null ) {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					int cmp = getOptionalJTableObjMembers().compareTo( rhs.getOptionalJTableObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjInterface() != null ) {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					int cmp = getOptionalJTableObjInterface().compareTo( rhs.getOptionalJTableObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJTableObjImplementation() != null ) {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					int cmp = getOptionalJTableObjImplementation().compareTo( rhs.getOptionalJTableObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJTableObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWTableImport() != null ) {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					int cmp = getOptionalJDb2LUWTableImport().compareTo( rhs.getOptionalJDb2LUWTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					int cmp = getOptionalJDb2LUWTableMembers().compareTo( rhs.getOptionalJDb2LUWTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					int cmp = getOptionalJDb2LUWTableImplementation().compareTo( rhs.getOptionalJDb2LUWTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJDb2LUWTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlTableImport() != null ) {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					int cmp = getOptionalJMSSqlTableImport().compareTo( rhs.getOptionalJMSSqlTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlTableMembers() != null ) {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					int cmp = getOptionalJMSSqlTableMembers().compareTo( rhs.getOptionalJMSSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					int cmp = getOptionalJMSSqlTableImplementation().compareTo( rhs.getOptionalJMSSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMSSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlTableImport() != null ) {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					int cmp = getOptionalJMySqlTableImport().compareTo( rhs.getOptionalJMySqlTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlTableMembers() != null ) {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					int cmp = getOptionalJMySqlTableMembers().compareTo( rhs.getOptionalJMySqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJMySqlTableImplementation() != null ) {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					int cmp = getOptionalJMySqlTableImplementation().compareTo( rhs.getOptionalJMySqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJMySqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleTableImport() != null ) {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					int cmp = getOptionalJOracleTableImport().compareTo( rhs.getOptionalJOracleTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleTableMembers() != null ) {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					int cmp = getOptionalJOracleTableMembers().compareTo( rhs.getOptionalJOracleTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJOracleTableImplementation() != null ) {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					int cmp = getOptionalJOracleTableImplementation().compareTo( rhs.getOptionalJOracleTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJOracleTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlTableImport() != null ) {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					int cmp = getOptionalJPgSqlTableImport().compareTo( rhs.getOptionalJPgSqlTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlTableMembers() != null ) {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					int cmp = getOptionalJPgSqlTableMembers().compareTo( rhs.getOptionalJPgSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					int cmp = getOptionalJPgSqlTableImplementation().compareTo( rhs.getOptionalJPgSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJPgSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamTableImport() != null ) {
				if( rhs.getOptionalJRamTableImport() != null ) {
					int cmp = getOptionalJRamTableImport().compareTo( rhs.getOptionalJRamTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamTableMembers() != null ) {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					int cmp = getOptionalJRamTableMembers().compareTo( rhs.getOptionalJRamTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJRamTableImplementation() != null ) {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					int cmp = getOptionalJRamTableImplementation().compareTo( rhs.getOptionalJRamTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJRamTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSaxLoaderImport() != null ) {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					int cmp = getOptionalJSaxLoaderImport().compareTo( rhs.getOptionalJSaxLoaderImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					int cmp = getOptionalJSaxLoaderStartElement().compareTo( rhs.getOptionalJSaxLoaderStartElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderStartElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					int cmp = getOptionalJSaxLoaderEndElement().compareTo( rhs.getOptionalJSaxLoaderEndElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJSaxLoaderEndElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgTableImport() != null ) {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					int cmp = getOptionalJXMsgTableImport().compareTo( rhs.getOptionalJXMsgTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgTableFormatters() != null ) {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					int cmp = getOptionalJXMsgTableFormatters().compareTo( rhs.getOptionalJXMsgTableFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgTableFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstTableImport() != null ) {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					int cmp = getOptionalJXMsgRqstTableImport().compareTo( rhs.getOptionalJXMsgRqstTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnTableImport() != null ) {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					int cmp = getOptionalJXMsgRspnTableImport().compareTo( rhs.getOptionalJXMsgRspnTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientTableImport() != null ) {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					int cmp = getOptionalJXMsgClientTableImport().compareTo( rhs.getOptionalJXMsgClientTableImport() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableImport() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					int cmp = getOptionalJXMsgRqstTableBody().compareTo( rhs.getOptionalJXMsgRqstTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRqstTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					int cmp = getOptionalJXMsgRspnTableBody().compareTo( rhs.getOptionalJXMsgRspnTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgRspnTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalJXMsgClientTableBody() != null ) {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					int cmp = getOptionalJXMsgClientTableBody().compareTo( rhs.getOptionalJXMsgClientTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalJXMsgClientTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppObjMembers() != null ) {
				if( rhs.getOptionalCppObjMembers() != null ) {
					int cmp = getOptionalCppObjMembers().compareTo( rhs.getOptionalCppObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppObjInterface() != null ) {
				if( rhs.getOptionalCppObjInterface() != null ) {
					int cmp = getOptionalCppObjInterface().compareTo( rhs.getOptionalCppObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppObjInclude() != null ) {
				if( rhs.getOptionalCppObjInclude() != null ) {
					int cmp = getOptionalCppObjInclude().compareTo( rhs.getOptionalCppObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppObjImplementation() != null ) {
				if( rhs.getOptionalCppObjImplementation() != null ) {
					int cmp = getOptionalCppObjImplementation().compareTo( rhs.getOptionalCppObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppEditObjMembers() != null ) {
				if( rhs.getOptionalCppEditObjMembers() != null ) {
					int cmp = getOptionalCppEditObjMembers().compareTo( rhs.getOptionalCppEditObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppEditObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppEditObjInterface() != null ) {
				if( rhs.getOptionalCppEditObjInterface() != null ) {
					int cmp = getOptionalCppEditObjInterface().compareTo( rhs.getOptionalCppEditObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppEditObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppEditObjInclude() != null ) {
				if( rhs.getOptionalCppEditObjInclude() != null ) {
					int cmp = getOptionalCppEditObjInclude().compareTo( rhs.getOptionalCppEditObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppEditObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppEditObjImplementation() != null ) {
				if( rhs.getOptionalCppEditObjImplementation() != null ) {
					int cmp = getOptionalCppEditObjImplementation().compareTo( rhs.getOptionalCppEditObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppEditObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableInclude() != null ) {
				if( rhs.getOptionalCppTableInclude() != null ) {
					int cmp = getOptionalCppTableInclude().compareTo( rhs.getOptionalCppTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableMembers() != null ) {
				if( rhs.getOptionalCppTableMembers() != null ) {
					int cmp = getOptionalCppTableMembers().compareTo( rhs.getOptionalCppTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableInterface() != null ) {
				if( rhs.getOptionalCppTableInterface() != null ) {
					int cmp = getOptionalCppTableInterface().compareTo( rhs.getOptionalCppTableInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableImplementation() != null ) {
				if( rhs.getOptionalCppTableImplementation() != null ) {
					int cmp = getOptionalCppTableImplementation().compareTo( rhs.getOptionalCppTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableObjInclude() != null ) {
				if( rhs.getOptionalCppTableObjInclude() != null ) {
					int cmp = getOptionalCppTableObjInclude().compareTo( rhs.getOptionalCppTableObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableObjMembers() != null ) {
				if( rhs.getOptionalCppTableObjMembers() != null ) {
					int cmp = getOptionalCppTableObjMembers().compareTo( rhs.getOptionalCppTableObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableObjInterface() != null ) {
				if( rhs.getOptionalCppTableObjInterface() != null ) {
					int cmp = getOptionalCppTableObjInterface().compareTo( rhs.getOptionalCppTableObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppTableObjImplementation() != null ) {
				if( rhs.getOptionalCppTableObjImplementation() != null ) {
					int cmp = getOptionalCppTableObjImplementation().compareTo( rhs.getOptionalCppTableObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppTableObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWTableInclude() != null ) {
				if( rhs.getOptionalCppDb2LUWTableInclude() != null ) {
					int cmp = getOptionalCppDb2LUWTableInclude().compareTo( rhs.getOptionalCppDb2LUWTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalCppDb2LUWTableMembers() != null ) {
					int cmp = getOptionalCppDb2LUWTableMembers().compareTo( rhs.getOptionalCppDb2LUWTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalCppDb2LUWTableImplementation() != null ) {
					int cmp = getOptionalCppDb2LUWTableImplementation().compareTo( rhs.getOptionalCppDb2LUWTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppDb2LUWTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlTableInclude() != null ) {
				if( rhs.getOptionalCppMSSqlTableInclude() != null ) {
					int cmp = getOptionalCppMSSqlTableInclude().compareTo( rhs.getOptionalCppMSSqlTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlTableMembers() != null ) {
				if( rhs.getOptionalCppMSSqlTableMembers() != null ) {
					int cmp = getOptionalCppMSSqlTableMembers().compareTo( rhs.getOptionalCppMSSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalCppMSSqlTableImplementation() != null ) {
					int cmp = getOptionalCppMSSqlTableImplementation().compareTo( rhs.getOptionalCppMSSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMSSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlTableInclude() != null ) {
				if( rhs.getOptionalCppMySqlTableInclude() != null ) {
					int cmp = getOptionalCppMySqlTableInclude().compareTo( rhs.getOptionalCppMySqlTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlTableMembers() != null ) {
				if( rhs.getOptionalCppMySqlTableMembers() != null ) {
					int cmp = getOptionalCppMySqlTableMembers().compareTo( rhs.getOptionalCppMySqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppMySqlTableImplementation() != null ) {
				if( rhs.getOptionalCppMySqlTableImplementation() != null ) {
					int cmp = getOptionalCppMySqlTableImplementation().compareTo( rhs.getOptionalCppMySqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppMySqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleTableInclude() != null ) {
				if( rhs.getOptionalCppOracleTableInclude() != null ) {
					int cmp = getOptionalCppOracleTableInclude().compareTo( rhs.getOptionalCppOracleTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleTableMembers() != null ) {
				if( rhs.getOptionalCppOracleTableMembers() != null ) {
					int cmp = getOptionalCppOracleTableMembers().compareTo( rhs.getOptionalCppOracleTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppOracleTableImplementation() != null ) {
				if( rhs.getOptionalCppOracleTableImplementation() != null ) {
					int cmp = getOptionalCppOracleTableImplementation().compareTo( rhs.getOptionalCppOracleTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppOracleTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlTableInclude() != null ) {
				if( rhs.getOptionalCppPgSqlTableInclude() != null ) {
					int cmp = getOptionalCppPgSqlTableInclude().compareTo( rhs.getOptionalCppPgSqlTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlTableMembers() != null ) {
				if( rhs.getOptionalCppPgSqlTableMembers() != null ) {
					int cmp = getOptionalCppPgSqlTableMembers().compareTo( rhs.getOptionalCppPgSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalCppPgSqlTableImplementation() != null ) {
					int cmp = getOptionalCppPgSqlTableImplementation().compareTo( rhs.getOptionalCppPgSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppPgSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamTableInclude() != null ) {
				if( rhs.getOptionalCppRamTableInclude() != null ) {
					int cmp = getOptionalCppRamTableInclude().compareTo( rhs.getOptionalCppRamTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamTableMembers() != null ) {
				if( rhs.getOptionalCppRamTableMembers() != null ) {
					int cmp = getOptionalCppRamTableMembers().compareTo( rhs.getOptionalCppRamTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppRamTableImplementation() != null ) {
				if( rhs.getOptionalCppRamTableImplementation() != null ) {
					int cmp = getOptionalCppRamTableImplementation().compareTo( rhs.getOptionalCppRamTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppRamTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSaxLoaderInclude() != null ) {
				if( rhs.getOptionalCppSaxLoaderInclude() != null ) {
					int cmp = getOptionalCppSaxLoaderInclude().compareTo( rhs.getOptionalCppSaxLoaderInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalCppSaxLoaderStartElement() != null ) {
					int cmp = getOptionalCppSaxLoaderStartElement().compareTo( rhs.getOptionalCppSaxLoaderStartElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderStartElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalCppSaxLoaderEndElement() != null ) {
					int cmp = getOptionalCppSaxLoaderEndElement().compareTo( rhs.getOptionalCppSaxLoaderEndElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppSaxLoaderEndElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgTableInclude() != null ) {
					int cmp = getOptionalCppXMsgTableInclude().compareTo( rhs.getOptionalCppXMsgTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgTableFormatters() != null ) {
				if( rhs.getOptionalCppXMsgTableFormatters() != null ) {
					int cmp = getOptionalCppXMsgTableFormatters().compareTo( rhs.getOptionalCppXMsgTableFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgTableFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgRqstTableInclude() != null ) {
					int cmp = getOptionalCppXMsgRqstTableInclude().compareTo( rhs.getOptionalCppXMsgRqstTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgRspnTableInclude() != null ) {
					int cmp = getOptionalCppXMsgRspnTableInclude().compareTo( rhs.getOptionalCppXMsgRspnTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgClientTableInclude() != null ) {
				if( rhs.getOptionalCppXMsgClientTableInclude() != null ) {
					int cmp = getOptionalCppXMsgClientTableInclude().compareTo( rhs.getOptionalCppXMsgClientTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalCppXMsgRqstTableBody() != null ) {
					int cmp = getOptionalCppXMsgRqstTableBody().compareTo( rhs.getOptionalCppXMsgRqstTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRqstTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalCppXMsgRspnTableBody() != null ) {
					int cmp = getOptionalCppXMsgRspnTableBody().compareTo( rhs.getOptionalCppXMsgRspnTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgRspnTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCppXMsgClientTableBody() != null ) {
				if( rhs.getOptionalCppXMsgClientTableBody() != null ) {
					int cmp = getOptionalCppXMsgClientTableBody().compareTo( rhs.getOptionalCppXMsgClientTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCppXMsgClientTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppObjMembers() != null ) {
				if( rhs.getOptionalHppObjMembers() != null ) {
					int cmp = getOptionalHppObjMembers().compareTo( rhs.getOptionalHppObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppObjInterface() != null ) {
				if( rhs.getOptionalHppObjInterface() != null ) {
					int cmp = getOptionalHppObjInterface().compareTo( rhs.getOptionalHppObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppObjInclude() != null ) {
				if( rhs.getOptionalHppObjInclude() != null ) {
					int cmp = getOptionalHppObjInclude().compareTo( rhs.getOptionalHppObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppObjImplementation() != null ) {
				if( rhs.getOptionalHppObjImplementation() != null ) {
					int cmp = getOptionalHppObjImplementation().compareTo( rhs.getOptionalHppObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppEditObjMembers() != null ) {
				if( rhs.getOptionalHppEditObjMembers() != null ) {
					int cmp = getOptionalHppEditObjMembers().compareTo( rhs.getOptionalHppEditObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppEditObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppEditObjInterface() != null ) {
				if( rhs.getOptionalHppEditObjInterface() != null ) {
					int cmp = getOptionalHppEditObjInterface().compareTo( rhs.getOptionalHppEditObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppEditObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppEditObjInclude() != null ) {
				if( rhs.getOptionalHppEditObjInclude() != null ) {
					int cmp = getOptionalHppEditObjInclude().compareTo( rhs.getOptionalHppEditObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppEditObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppEditObjImplementation() != null ) {
				if( rhs.getOptionalHppEditObjImplementation() != null ) {
					int cmp = getOptionalHppEditObjImplementation().compareTo( rhs.getOptionalHppEditObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppEditObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableInclude() != null ) {
				if( rhs.getOptionalHppTableInclude() != null ) {
					int cmp = getOptionalHppTableInclude().compareTo( rhs.getOptionalHppTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableMembers() != null ) {
				if( rhs.getOptionalHppTableMembers() != null ) {
					int cmp = getOptionalHppTableMembers().compareTo( rhs.getOptionalHppTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableInterface() != null ) {
				if( rhs.getOptionalHppTableInterface() != null ) {
					int cmp = getOptionalHppTableInterface().compareTo( rhs.getOptionalHppTableInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableImplementation() != null ) {
				if( rhs.getOptionalHppTableImplementation() != null ) {
					int cmp = getOptionalHppTableImplementation().compareTo( rhs.getOptionalHppTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableObjInclude() != null ) {
				if( rhs.getOptionalHppTableObjInclude() != null ) {
					int cmp = getOptionalHppTableObjInclude().compareTo( rhs.getOptionalHppTableObjInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableObjInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableObjMembers() != null ) {
				if( rhs.getOptionalHppTableObjMembers() != null ) {
					int cmp = getOptionalHppTableObjMembers().compareTo( rhs.getOptionalHppTableObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableObjInterface() != null ) {
				if( rhs.getOptionalHppTableObjInterface() != null ) {
					int cmp = getOptionalHppTableObjInterface().compareTo( rhs.getOptionalHppTableObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppTableObjImplementation() != null ) {
				if( rhs.getOptionalHppTableObjImplementation() != null ) {
					int cmp = getOptionalHppTableObjImplementation().compareTo( rhs.getOptionalHppTableObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppTableObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWTableInclude() != null ) {
				if( rhs.getOptionalHppDb2LUWTableInclude() != null ) {
					int cmp = getOptionalHppDb2LUWTableInclude().compareTo( rhs.getOptionalHppDb2LUWTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalHppDb2LUWTableMembers() != null ) {
					int cmp = getOptionalHppDb2LUWTableMembers().compareTo( rhs.getOptionalHppDb2LUWTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalHppDb2LUWTableImplementation() != null ) {
					int cmp = getOptionalHppDb2LUWTableImplementation().compareTo( rhs.getOptionalHppDb2LUWTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppDb2LUWTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlTableInclude() != null ) {
				if( rhs.getOptionalHppMSSqlTableInclude() != null ) {
					int cmp = getOptionalHppMSSqlTableInclude().compareTo( rhs.getOptionalHppMSSqlTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlTableMembers() != null ) {
				if( rhs.getOptionalHppMSSqlTableMembers() != null ) {
					int cmp = getOptionalHppMSSqlTableMembers().compareTo( rhs.getOptionalHppMSSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalHppMSSqlTableImplementation() != null ) {
					int cmp = getOptionalHppMSSqlTableImplementation().compareTo( rhs.getOptionalHppMSSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMSSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlTableInclude() != null ) {
				if( rhs.getOptionalHppMySqlTableInclude() != null ) {
					int cmp = getOptionalHppMySqlTableInclude().compareTo( rhs.getOptionalHppMySqlTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlTableMembers() != null ) {
				if( rhs.getOptionalHppMySqlTableMembers() != null ) {
					int cmp = getOptionalHppMySqlTableMembers().compareTo( rhs.getOptionalHppMySqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppMySqlTableImplementation() != null ) {
				if( rhs.getOptionalHppMySqlTableImplementation() != null ) {
					int cmp = getOptionalHppMySqlTableImplementation().compareTo( rhs.getOptionalHppMySqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppMySqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleTableInclude() != null ) {
				if( rhs.getOptionalHppOracleTableInclude() != null ) {
					int cmp = getOptionalHppOracleTableInclude().compareTo( rhs.getOptionalHppOracleTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleTableMembers() != null ) {
				if( rhs.getOptionalHppOracleTableMembers() != null ) {
					int cmp = getOptionalHppOracleTableMembers().compareTo( rhs.getOptionalHppOracleTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppOracleTableImplementation() != null ) {
				if( rhs.getOptionalHppOracleTableImplementation() != null ) {
					int cmp = getOptionalHppOracleTableImplementation().compareTo( rhs.getOptionalHppOracleTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppOracleTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlTableInclude() != null ) {
				if( rhs.getOptionalHppPgSqlTableInclude() != null ) {
					int cmp = getOptionalHppPgSqlTableInclude().compareTo( rhs.getOptionalHppPgSqlTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlTableMembers() != null ) {
				if( rhs.getOptionalHppPgSqlTableMembers() != null ) {
					int cmp = getOptionalHppPgSqlTableMembers().compareTo( rhs.getOptionalHppPgSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalHppPgSqlTableImplementation() != null ) {
					int cmp = getOptionalHppPgSqlTableImplementation().compareTo( rhs.getOptionalHppPgSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppPgSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamTableInclude() != null ) {
				if( rhs.getOptionalHppRamTableInclude() != null ) {
					int cmp = getOptionalHppRamTableInclude().compareTo( rhs.getOptionalHppRamTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamTableMembers() != null ) {
				if( rhs.getOptionalHppRamTableMembers() != null ) {
					int cmp = getOptionalHppRamTableMembers().compareTo( rhs.getOptionalHppRamTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppRamTableImplementation() != null ) {
				if( rhs.getOptionalHppRamTableImplementation() != null ) {
					int cmp = getOptionalHppRamTableImplementation().compareTo( rhs.getOptionalHppRamTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppRamTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSaxLoaderInclude() != null ) {
				if( rhs.getOptionalHppSaxLoaderInclude() != null ) {
					int cmp = getOptionalHppSaxLoaderInclude().compareTo( rhs.getOptionalHppSaxLoaderInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalHppSaxLoaderStartElement() != null ) {
					int cmp = getOptionalHppSaxLoaderStartElement().compareTo( rhs.getOptionalHppSaxLoaderStartElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderStartElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalHppSaxLoaderEndElement() != null ) {
					int cmp = getOptionalHppSaxLoaderEndElement().compareTo( rhs.getOptionalHppSaxLoaderEndElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppSaxLoaderEndElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgTableInclude() != null ) {
					int cmp = getOptionalHppXMsgTableInclude().compareTo( rhs.getOptionalHppXMsgTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgTableFormatters() != null ) {
				if( rhs.getOptionalHppXMsgTableFormatters() != null ) {
					int cmp = getOptionalHppXMsgTableFormatters().compareTo( rhs.getOptionalHppXMsgTableFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgTableFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgRqstTableInclude() != null ) {
					int cmp = getOptionalHppXMsgRqstTableInclude().compareTo( rhs.getOptionalHppXMsgRqstTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgRspnTableInclude() != null ) {
					int cmp = getOptionalHppXMsgRspnTableInclude().compareTo( rhs.getOptionalHppXMsgRspnTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgClientTableInclude() != null ) {
				if( rhs.getOptionalHppXMsgClientTableInclude() != null ) {
					int cmp = getOptionalHppXMsgClientTableInclude().compareTo( rhs.getOptionalHppXMsgClientTableInclude() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientTableInclude() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalHppXMsgRqstTableBody() != null ) {
					int cmp = getOptionalHppXMsgRqstTableBody().compareTo( rhs.getOptionalHppXMsgRqstTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRqstTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalHppXMsgRspnTableBody() != null ) {
					int cmp = getOptionalHppXMsgRspnTableBody().compareTo( rhs.getOptionalHppXMsgRspnTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgRspnTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalHppXMsgClientTableBody() != null ) {
				if( rhs.getOptionalHppXMsgClientTableBody() != null ) {
					int cmp = getOptionalHppXMsgClientTableBody().compareTo( rhs.getOptionalHppXMsgClientTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalHppXMsgClientTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsObjMembers() != null ) {
				if( rhs.getOptionalCsObjMembers() != null ) {
					int cmp = getOptionalCsObjMembers().compareTo( rhs.getOptionalCsObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsObjInterface() != null ) {
				if( rhs.getOptionalCsObjInterface() != null ) {
					int cmp = getOptionalCsObjInterface().compareTo( rhs.getOptionalCsObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsObjUsing() != null ) {
				if( rhs.getOptionalCsObjUsing() != null ) {
					int cmp = getOptionalCsObjUsing().compareTo( rhs.getOptionalCsObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsObjImplementation() != null ) {
				if( rhs.getOptionalCsObjImplementation() != null ) {
					int cmp = getOptionalCsObjImplementation().compareTo( rhs.getOptionalCsObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsEditObjMembers() != null ) {
				if( rhs.getOptionalCsEditObjMembers() != null ) {
					int cmp = getOptionalCsEditObjMembers().compareTo( rhs.getOptionalCsEditObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsEditObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsEditObjInterface() != null ) {
				if( rhs.getOptionalCsEditObjInterface() != null ) {
					int cmp = getOptionalCsEditObjInterface().compareTo( rhs.getOptionalCsEditObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsEditObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsEditObjUsing() != null ) {
				if( rhs.getOptionalCsEditObjUsing() != null ) {
					int cmp = getOptionalCsEditObjUsing().compareTo( rhs.getOptionalCsEditObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsEditObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsEditObjImplementation() != null ) {
				if( rhs.getOptionalCsEditObjImplementation() != null ) {
					int cmp = getOptionalCsEditObjImplementation().compareTo( rhs.getOptionalCsEditObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsEditObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableUsing() != null ) {
				if( rhs.getOptionalCsTableUsing() != null ) {
					int cmp = getOptionalCsTableUsing().compareTo( rhs.getOptionalCsTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableMembers() != null ) {
				if( rhs.getOptionalCsTableMembers() != null ) {
					int cmp = getOptionalCsTableMembers().compareTo( rhs.getOptionalCsTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableInterface() != null ) {
				if( rhs.getOptionalCsTableInterface() != null ) {
					int cmp = getOptionalCsTableInterface().compareTo( rhs.getOptionalCsTableInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableImplementation() != null ) {
				if( rhs.getOptionalCsTableImplementation() != null ) {
					int cmp = getOptionalCsTableImplementation().compareTo( rhs.getOptionalCsTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableObjUsing() != null ) {
				if( rhs.getOptionalCsTableObjUsing() != null ) {
					int cmp = getOptionalCsTableObjUsing().compareTo( rhs.getOptionalCsTableObjUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableObjUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableObjMembers() != null ) {
				if( rhs.getOptionalCsTableObjMembers() != null ) {
					int cmp = getOptionalCsTableObjMembers().compareTo( rhs.getOptionalCsTableObjMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableObjMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableObjInterface() != null ) {
				if( rhs.getOptionalCsTableObjInterface() != null ) {
					int cmp = getOptionalCsTableObjInterface().compareTo( rhs.getOptionalCsTableObjInterface() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableObjInterface() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsTableObjImplementation() != null ) {
				if( rhs.getOptionalCsTableObjImplementation() != null ) {
					int cmp = getOptionalCsTableObjImplementation().compareTo( rhs.getOptionalCsTableObjImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsTableObjImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWTableUsing() != null ) {
				if( rhs.getOptionalCsDb2LUWTableUsing() != null ) {
					int cmp = getOptionalCsDb2LUWTableUsing().compareTo( rhs.getOptionalCsDb2LUWTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWTableMembers() != null ) {
				if( rhs.getOptionalCsDb2LUWTableMembers() != null ) {
					int cmp = getOptionalCsDb2LUWTableMembers().compareTo( rhs.getOptionalCsDb2LUWTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsDb2LUWTableImplementation() != null ) {
				if( rhs.getOptionalCsDb2LUWTableImplementation() != null ) {
					int cmp = getOptionalCsDb2LUWTableImplementation().compareTo( rhs.getOptionalCsDb2LUWTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsDb2LUWTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlTableUsing() != null ) {
				if( rhs.getOptionalCsMSSqlTableUsing() != null ) {
					int cmp = getOptionalCsMSSqlTableUsing().compareTo( rhs.getOptionalCsMSSqlTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlTableMembers() != null ) {
				if( rhs.getOptionalCsMSSqlTableMembers() != null ) {
					int cmp = getOptionalCsMSSqlTableMembers().compareTo( rhs.getOptionalCsMSSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMSSqlTableImplementation() != null ) {
				if( rhs.getOptionalCsMSSqlTableImplementation() != null ) {
					int cmp = getOptionalCsMSSqlTableImplementation().compareTo( rhs.getOptionalCsMSSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMSSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlTableUsing() != null ) {
				if( rhs.getOptionalCsMySqlTableUsing() != null ) {
					int cmp = getOptionalCsMySqlTableUsing().compareTo( rhs.getOptionalCsMySqlTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlTableMembers() != null ) {
				if( rhs.getOptionalCsMySqlTableMembers() != null ) {
					int cmp = getOptionalCsMySqlTableMembers().compareTo( rhs.getOptionalCsMySqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsMySqlTableImplementation() != null ) {
				if( rhs.getOptionalCsMySqlTableImplementation() != null ) {
					int cmp = getOptionalCsMySqlTableImplementation().compareTo( rhs.getOptionalCsMySqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsMySqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleTableUsing() != null ) {
				if( rhs.getOptionalCsOracleTableUsing() != null ) {
					int cmp = getOptionalCsOracleTableUsing().compareTo( rhs.getOptionalCsOracleTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleTableMembers() != null ) {
				if( rhs.getOptionalCsOracleTableMembers() != null ) {
					int cmp = getOptionalCsOracleTableMembers().compareTo( rhs.getOptionalCsOracleTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsOracleTableImplementation() != null ) {
				if( rhs.getOptionalCsOracleTableImplementation() != null ) {
					int cmp = getOptionalCsOracleTableImplementation().compareTo( rhs.getOptionalCsOracleTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsOracleTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlTableUsing() != null ) {
				if( rhs.getOptionalCsPgSqlTableUsing() != null ) {
					int cmp = getOptionalCsPgSqlTableUsing().compareTo( rhs.getOptionalCsPgSqlTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlTableMembers() != null ) {
				if( rhs.getOptionalCsPgSqlTableMembers() != null ) {
					int cmp = getOptionalCsPgSqlTableMembers().compareTo( rhs.getOptionalCsPgSqlTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsPgSqlTableImplementation() != null ) {
				if( rhs.getOptionalCsPgSqlTableImplementation() != null ) {
					int cmp = getOptionalCsPgSqlTableImplementation().compareTo( rhs.getOptionalCsPgSqlTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsPgSqlTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamTableUsing() != null ) {
				if( rhs.getOptionalCsRamTableUsing() != null ) {
					int cmp = getOptionalCsRamTableUsing().compareTo( rhs.getOptionalCsRamTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamTableMembers() != null ) {
				if( rhs.getOptionalCsRamTableMembers() != null ) {
					int cmp = getOptionalCsRamTableMembers().compareTo( rhs.getOptionalCsRamTableMembers() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamTableMembers() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsRamTableImplementation() != null ) {
				if( rhs.getOptionalCsRamTableImplementation() != null ) {
					int cmp = getOptionalCsRamTableImplementation().compareTo( rhs.getOptionalCsRamTableImplementation() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsRamTableImplementation() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSaxLoaderUsing() != null ) {
				if( rhs.getOptionalCsSaxLoaderUsing() != null ) {
					int cmp = getOptionalCsSaxLoaderUsing().compareTo( rhs.getOptionalCsSaxLoaderUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSaxLoaderStartElement() != null ) {
				if( rhs.getOptionalCsSaxLoaderStartElement() != null ) {
					int cmp = getOptionalCsSaxLoaderStartElement().compareTo( rhs.getOptionalCsSaxLoaderStartElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderStartElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsSaxLoaderEndElement() != null ) {
				if( rhs.getOptionalCsSaxLoaderEndElement() != null ) {
					int cmp = getOptionalCsSaxLoaderEndElement().compareTo( rhs.getOptionalCsSaxLoaderEndElement() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsSaxLoaderEndElement() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgTableUsing() != null ) {
					int cmp = getOptionalCsXMsgTableUsing().compareTo( rhs.getOptionalCsXMsgTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgTableFormatters() != null ) {
				if( rhs.getOptionalCsXMsgTableFormatters() != null ) {
					int cmp = getOptionalCsXMsgTableFormatters().compareTo( rhs.getOptionalCsXMsgTableFormatters() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgTableFormatters() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgRqstTableUsing() != null ) {
					int cmp = getOptionalCsXMsgRqstTableUsing().compareTo( rhs.getOptionalCsXMsgRqstTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgRspnTableUsing() != null ) {
					int cmp = getOptionalCsXMsgRspnTableUsing().compareTo( rhs.getOptionalCsXMsgRspnTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgClientTableUsing() != null ) {
				if( rhs.getOptionalCsXMsgClientTableUsing() != null ) {
					int cmp = getOptionalCsXMsgClientTableUsing().compareTo( rhs.getOptionalCsXMsgClientTableUsing() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientTableUsing() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRqstTableBody() != null ) {
				if( rhs.getOptionalCsXMsgRqstTableBody() != null ) {
					int cmp = getOptionalCsXMsgRqstTableBody().compareTo( rhs.getOptionalCsXMsgRqstTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRqstTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgRspnTableBody() != null ) {
				if( rhs.getOptionalCsXMsgRspnTableBody() != null ) {
					int cmp = getOptionalCsXMsgRspnTableBody().compareTo( rhs.getOptionalCsXMsgRspnTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgRspnTableBody() != null ) {
					return( -1 );
				}
			}
			if( getOptionalCsXMsgClientTableBody() != null ) {
				if( rhs.getOptionalCsXMsgClientTableBody() != null ) {
					int cmp = getOptionalCsXMsgClientTableBody().compareTo( rhs.getOptionalCsXMsgClientTableBody() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalCsXMsgClientTableBody() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			return( super.compareTo( obj ) );
		}
	}

	public void set( CFBamScopeBuff src ) {
		if( src instanceof CFBamTableBuff ) {
			setTableBuff( (CFBamTableBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTableBuff" );
		}
	}

	public void setTableBuff( CFBamTableBuff src ) {
		super.setScopeBuff( src );
		setRequiredSchemaDefId( src.getRequiredSchemaDefId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredPageData( src.getRequiredPageData() );
		setOptionalPrimaryIndexTenantId( src.getOptionalPrimaryIndexTenantId() );
		setOptionalPrimaryIndexId( src.getOptionalPrimaryIndexId() );
		setRequiredTableClassCode( src.getRequiredTableClassCode() );
		setOptionalLookupIndexTenantId( src.getOptionalLookupIndexTenantId() );
		setOptionalLookupIndexId( src.getOptionalLookupIndexId() );
		setOptionalAltIndexTenantId( src.getOptionalAltIndexTenantId() );
		setOptionalAltIndexId( src.getOptionalAltIndexId() );
		setOptionalQualifyingTenantId( src.getOptionalQualifyingTenantId() );
		setOptionalQualifyingTableId( src.getOptionalQualifyingTableId() );
		setRequiredIsInstantiable( src.getRequiredIsInstantiable() );
		setRequiredHasHistory( src.getRequiredHasHistory() );
		setRequiredHasAuditColumns( src.getRequiredHasAuditColumns() );
		setRequiredLoaderBehaviour( src.getRequiredLoaderBehaviour() );
		setRequiredSecScope( src.getRequiredSecScope() );
		setOptionalJObjMembers( src.getOptionalJObjMembers() );
		setOptionalJObjInterface( src.getOptionalJObjInterface() );
		setOptionalJObjImport( src.getOptionalJObjImport() );
		setOptionalJObjImplementation( src.getOptionalJObjImplementation() );
		setOptionalJEditObjMembers( src.getOptionalJEditObjMembers() );
		setOptionalJEditObjInterface( src.getOptionalJEditObjInterface() );
		setOptionalJEditObjImport( src.getOptionalJEditObjImport() );
		setOptionalJEditObjImplementation( src.getOptionalJEditObjImplementation() );
		setOptionalJTableImport( src.getOptionalJTableImport() );
		setOptionalJTableMembers( src.getOptionalJTableMembers() );
		setOptionalJTableInterface( src.getOptionalJTableInterface() );
		setOptionalJTableImplementation( src.getOptionalJTableImplementation() );
		setOptionalJTableObjImport( src.getOptionalJTableObjImport() );
		setOptionalJTableObjMembers( src.getOptionalJTableObjMembers() );
		setOptionalJTableObjInterface( src.getOptionalJTableObjInterface() );
		setOptionalJTableObjImplementation( src.getOptionalJTableObjImplementation() );
		setOptionalJDb2LUWTableImport( src.getOptionalJDb2LUWTableImport() );
		setOptionalJDb2LUWTableMembers( src.getOptionalJDb2LUWTableMembers() );
		setOptionalJDb2LUWTableImplementation( src.getOptionalJDb2LUWTableImplementation() );
		setOptionalJMSSqlTableImport( src.getOptionalJMSSqlTableImport() );
		setOptionalJMSSqlTableMembers( src.getOptionalJMSSqlTableMembers() );
		setOptionalJMSSqlTableImplementation( src.getOptionalJMSSqlTableImplementation() );
		setOptionalJMySqlTableImport( src.getOptionalJMySqlTableImport() );
		setOptionalJMySqlTableMembers( src.getOptionalJMySqlTableMembers() );
		setOptionalJMySqlTableImplementation( src.getOptionalJMySqlTableImplementation() );
		setOptionalJOracleTableImport( src.getOptionalJOracleTableImport() );
		setOptionalJOracleTableMembers( src.getOptionalJOracleTableMembers() );
		setOptionalJOracleTableImplementation( src.getOptionalJOracleTableImplementation() );
		setOptionalJPgSqlTableImport( src.getOptionalJPgSqlTableImport() );
		setOptionalJPgSqlTableMembers( src.getOptionalJPgSqlTableMembers() );
		setOptionalJPgSqlTableImplementation( src.getOptionalJPgSqlTableImplementation() );
		setOptionalJRamTableImport( src.getOptionalJRamTableImport() );
		setOptionalJRamTableMembers( src.getOptionalJRamTableMembers() );
		setOptionalJRamTableImplementation( src.getOptionalJRamTableImplementation() );
		setOptionalJSaxLoaderImport( src.getOptionalJSaxLoaderImport() );
		setOptionalJSaxLoaderStartElement( src.getOptionalJSaxLoaderStartElement() );
		setOptionalJSaxLoaderEndElement( src.getOptionalJSaxLoaderEndElement() );
		setOptionalJXMsgTableImport( src.getOptionalJXMsgTableImport() );
		setOptionalJXMsgTableFormatters( src.getOptionalJXMsgTableFormatters() );
		setOptionalJXMsgRqstTableImport( src.getOptionalJXMsgRqstTableImport() );
		setOptionalJXMsgRspnTableImport( src.getOptionalJXMsgRspnTableImport() );
		setOptionalJXMsgClientTableImport( src.getOptionalJXMsgClientTableImport() );
		setOptionalJXMsgRqstTableBody( src.getOptionalJXMsgRqstTableBody() );
		setOptionalJXMsgRspnTableBody( src.getOptionalJXMsgRspnTableBody() );
		setOptionalJXMsgClientTableBody( src.getOptionalJXMsgClientTableBody() );
		setOptionalCppObjMembers( src.getOptionalCppObjMembers() );
		setOptionalCppObjInterface( src.getOptionalCppObjInterface() );
		setOptionalCppObjInclude( src.getOptionalCppObjInclude() );
		setOptionalCppObjImplementation( src.getOptionalCppObjImplementation() );
		setOptionalCppEditObjMembers( src.getOptionalCppEditObjMembers() );
		setOptionalCppEditObjInterface( src.getOptionalCppEditObjInterface() );
		setOptionalCppEditObjInclude( src.getOptionalCppEditObjInclude() );
		setOptionalCppEditObjImplementation( src.getOptionalCppEditObjImplementation() );
		setOptionalCppTableInclude( src.getOptionalCppTableInclude() );
		setOptionalCppTableMembers( src.getOptionalCppTableMembers() );
		setOptionalCppTableInterface( src.getOptionalCppTableInterface() );
		setOptionalCppTableImplementation( src.getOptionalCppTableImplementation() );
		setOptionalCppTableObjInclude( src.getOptionalCppTableObjInclude() );
		setOptionalCppTableObjMembers( src.getOptionalCppTableObjMembers() );
		setOptionalCppTableObjInterface( src.getOptionalCppTableObjInterface() );
		setOptionalCppTableObjImplementation( src.getOptionalCppTableObjImplementation() );
		setOptionalCppDb2LUWTableInclude( src.getOptionalCppDb2LUWTableInclude() );
		setOptionalCppDb2LUWTableMembers( src.getOptionalCppDb2LUWTableMembers() );
		setOptionalCppDb2LUWTableImplementation( src.getOptionalCppDb2LUWTableImplementation() );
		setOptionalCppMSSqlTableInclude( src.getOptionalCppMSSqlTableInclude() );
		setOptionalCppMSSqlTableMembers( src.getOptionalCppMSSqlTableMembers() );
		setOptionalCppMSSqlTableImplementation( src.getOptionalCppMSSqlTableImplementation() );
		setOptionalCppMySqlTableInclude( src.getOptionalCppMySqlTableInclude() );
		setOptionalCppMySqlTableMembers( src.getOptionalCppMySqlTableMembers() );
		setOptionalCppMySqlTableImplementation( src.getOptionalCppMySqlTableImplementation() );
		setOptionalCppOracleTableInclude( src.getOptionalCppOracleTableInclude() );
		setOptionalCppOracleTableMembers( src.getOptionalCppOracleTableMembers() );
		setOptionalCppOracleTableImplementation( src.getOptionalCppOracleTableImplementation() );
		setOptionalCppPgSqlTableInclude( src.getOptionalCppPgSqlTableInclude() );
		setOptionalCppPgSqlTableMembers( src.getOptionalCppPgSqlTableMembers() );
		setOptionalCppPgSqlTableImplementation( src.getOptionalCppPgSqlTableImplementation() );
		setOptionalCppRamTableInclude( src.getOptionalCppRamTableInclude() );
		setOptionalCppRamTableMembers( src.getOptionalCppRamTableMembers() );
		setOptionalCppRamTableImplementation( src.getOptionalCppRamTableImplementation() );
		setOptionalCppSaxLoaderInclude( src.getOptionalCppSaxLoaderInclude() );
		setOptionalCppSaxLoaderStartElement( src.getOptionalCppSaxLoaderStartElement() );
		setOptionalCppSaxLoaderEndElement( src.getOptionalCppSaxLoaderEndElement() );
		setOptionalCppXMsgTableInclude( src.getOptionalCppXMsgTableInclude() );
		setOptionalCppXMsgTableFormatters( src.getOptionalCppXMsgTableFormatters() );
		setOptionalCppXMsgRqstTableInclude( src.getOptionalCppXMsgRqstTableInclude() );
		setOptionalCppXMsgRspnTableInclude( src.getOptionalCppXMsgRspnTableInclude() );
		setOptionalCppXMsgClientTableInclude( src.getOptionalCppXMsgClientTableInclude() );
		setOptionalCppXMsgRqstTableBody( src.getOptionalCppXMsgRqstTableBody() );
		setOptionalCppXMsgRspnTableBody( src.getOptionalCppXMsgRspnTableBody() );
		setOptionalCppXMsgClientTableBody( src.getOptionalCppXMsgClientTableBody() );
		setOptionalHppObjMembers( src.getOptionalHppObjMembers() );
		setOptionalHppObjInterface( src.getOptionalHppObjInterface() );
		setOptionalHppObjInclude( src.getOptionalHppObjInclude() );
		setOptionalHppObjImplementation( src.getOptionalHppObjImplementation() );
		setOptionalHppEditObjMembers( src.getOptionalHppEditObjMembers() );
		setOptionalHppEditObjInterface( src.getOptionalHppEditObjInterface() );
		setOptionalHppEditObjInclude( src.getOptionalHppEditObjInclude() );
		setOptionalHppEditObjImplementation( src.getOptionalHppEditObjImplementation() );
		setOptionalHppTableInclude( src.getOptionalHppTableInclude() );
		setOptionalHppTableMembers( src.getOptionalHppTableMembers() );
		setOptionalHppTableInterface( src.getOptionalHppTableInterface() );
		setOptionalHppTableImplementation( src.getOptionalHppTableImplementation() );
		setOptionalHppTableObjInclude( src.getOptionalHppTableObjInclude() );
		setOptionalHppTableObjMembers( src.getOptionalHppTableObjMembers() );
		setOptionalHppTableObjInterface( src.getOptionalHppTableObjInterface() );
		setOptionalHppTableObjImplementation( src.getOptionalHppTableObjImplementation() );
		setOptionalHppDb2LUWTableInclude( src.getOptionalHppDb2LUWTableInclude() );
		setOptionalHppDb2LUWTableMembers( src.getOptionalHppDb2LUWTableMembers() );
		setOptionalHppDb2LUWTableImplementation( src.getOptionalHppDb2LUWTableImplementation() );
		setOptionalHppMSSqlTableInclude( src.getOptionalHppMSSqlTableInclude() );
		setOptionalHppMSSqlTableMembers( src.getOptionalHppMSSqlTableMembers() );
		setOptionalHppMSSqlTableImplementation( src.getOptionalHppMSSqlTableImplementation() );
		setOptionalHppMySqlTableInclude( src.getOptionalHppMySqlTableInclude() );
		setOptionalHppMySqlTableMembers( src.getOptionalHppMySqlTableMembers() );
		setOptionalHppMySqlTableImplementation( src.getOptionalHppMySqlTableImplementation() );
		setOptionalHppOracleTableInclude( src.getOptionalHppOracleTableInclude() );
		setOptionalHppOracleTableMembers( src.getOptionalHppOracleTableMembers() );
		setOptionalHppOracleTableImplementation( src.getOptionalHppOracleTableImplementation() );
		setOptionalHppPgSqlTableInclude( src.getOptionalHppPgSqlTableInclude() );
		setOptionalHppPgSqlTableMembers( src.getOptionalHppPgSqlTableMembers() );
		setOptionalHppPgSqlTableImplementation( src.getOptionalHppPgSqlTableImplementation() );
		setOptionalHppRamTableInclude( src.getOptionalHppRamTableInclude() );
		setOptionalHppRamTableMembers( src.getOptionalHppRamTableMembers() );
		setOptionalHppRamTableImplementation( src.getOptionalHppRamTableImplementation() );
		setOptionalHppSaxLoaderInclude( src.getOptionalHppSaxLoaderInclude() );
		setOptionalHppSaxLoaderStartElement( src.getOptionalHppSaxLoaderStartElement() );
		setOptionalHppSaxLoaderEndElement( src.getOptionalHppSaxLoaderEndElement() );
		setOptionalHppXMsgTableInclude( src.getOptionalHppXMsgTableInclude() );
		setOptionalHppXMsgTableFormatters( src.getOptionalHppXMsgTableFormatters() );
		setOptionalHppXMsgRqstTableInclude( src.getOptionalHppXMsgRqstTableInclude() );
		setOptionalHppXMsgRspnTableInclude( src.getOptionalHppXMsgRspnTableInclude() );
		setOptionalHppXMsgClientTableInclude( src.getOptionalHppXMsgClientTableInclude() );
		setOptionalHppXMsgRqstTableBody( src.getOptionalHppXMsgRqstTableBody() );
		setOptionalHppXMsgRspnTableBody( src.getOptionalHppXMsgRspnTableBody() );
		setOptionalHppXMsgClientTableBody( src.getOptionalHppXMsgClientTableBody() );
		setOptionalCsObjMembers( src.getOptionalCsObjMembers() );
		setOptionalCsObjInterface( src.getOptionalCsObjInterface() );
		setOptionalCsObjUsing( src.getOptionalCsObjUsing() );
		setOptionalCsObjImplementation( src.getOptionalCsObjImplementation() );
		setOptionalCsEditObjMembers( src.getOptionalCsEditObjMembers() );
		setOptionalCsEditObjInterface( src.getOptionalCsEditObjInterface() );
		setOptionalCsEditObjUsing( src.getOptionalCsEditObjUsing() );
		setOptionalCsEditObjImplementation( src.getOptionalCsEditObjImplementation() );
		setOptionalCsTableUsing( src.getOptionalCsTableUsing() );
		setOptionalCsTableMembers( src.getOptionalCsTableMembers() );
		setOptionalCsTableInterface( src.getOptionalCsTableInterface() );
		setOptionalCsTableImplementation( src.getOptionalCsTableImplementation() );
		setOptionalCsTableObjUsing( src.getOptionalCsTableObjUsing() );
		setOptionalCsTableObjMembers( src.getOptionalCsTableObjMembers() );
		setOptionalCsTableObjInterface( src.getOptionalCsTableObjInterface() );
		setOptionalCsTableObjImplementation( src.getOptionalCsTableObjImplementation() );
		setOptionalCsDb2LUWTableUsing( src.getOptionalCsDb2LUWTableUsing() );
		setOptionalCsDb2LUWTableMembers( src.getOptionalCsDb2LUWTableMembers() );
		setOptionalCsDb2LUWTableImplementation( src.getOptionalCsDb2LUWTableImplementation() );
		setOptionalCsMSSqlTableUsing( src.getOptionalCsMSSqlTableUsing() );
		setOptionalCsMSSqlTableMembers( src.getOptionalCsMSSqlTableMembers() );
		setOptionalCsMSSqlTableImplementation( src.getOptionalCsMSSqlTableImplementation() );
		setOptionalCsMySqlTableUsing( src.getOptionalCsMySqlTableUsing() );
		setOptionalCsMySqlTableMembers( src.getOptionalCsMySqlTableMembers() );
		setOptionalCsMySqlTableImplementation( src.getOptionalCsMySqlTableImplementation() );
		setOptionalCsOracleTableUsing( src.getOptionalCsOracleTableUsing() );
		setOptionalCsOracleTableMembers( src.getOptionalCsOracleTableMembers() );
		setOptionalCsOracleTableImplementation( src.getOptionalCsOracleTableImplementation() );
		setOptionalCsPgSqlTableUsing( src.getOptionalCsPgSqlTableUsing() );
		setOptionalCsPgSqlTableMembers( src.getOptionalCsPgSqlTableMembers() );
		setOptionalCsPgSqlTableImplementation( src.getOptionalCsPgSqlTableImplementation() );
		setOptionalCsRamTableUsing( src.getOptionalCsRamTableUsing() );
		setOptionalCsRamTableMembers( src.getOptionalCsRamTableMembers() );
		setOptionalCsRamTableImplementation( src.getOptionalCsRamTableImplementation() );
		setOptionalCsSaxLoaderUsing( src.getOptionalCsSaxLoaderUsing() );
		setOptionalCsSaxLoaderStartElement( src.getOptionalCsSaxLoaderStartElement() );
		setOptionalCsSaxLoaderEndElement( src.getOptionalCsSaxLoaderEndElement() );
		setOptionalCsXMsgTableUsing( src.getOptionalCsXMsgTableUsing() );
		setOptionalCsXMsgTableFormatters( src.getOptionalCsXMsgTableFormatters() );
		setOptionalCsXMsgRqstTableUsing( src.getOptionalCsXMsgRqstTableUsing() );
		setOptionalCsXMsgRspnTableUsing( src.getOptionalCsXMsgRspnTableUsing() );
		setOptionalCsXMsgClientTableUsing( src.getOptionalCsXMsgClientTableUsing() );
		setOptionalCsXMsgRqstTableBody( src.getOptionalCsXMsgRqstTableBody() );
		setOptionalCsXMsgRspnTableBody( src.getOptionalCsXMsgRspnTableBody() );
		setOptionalCsXMsgClientTableBody( src.getOptionalCsXMsgClientTableBody() );
	}

	public void set( CFBamScopeHBuff src ) {
		if( src instanceof CFBamTableHBuff ) {
			setTableBuff( (CFBamTableHBuff)src );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamTableHBuff" );
		}
	}

	public void setTableBuff( CFBamTableHBuff src ) {
		super.setScopeBuff( src );
		setRequiredSchemaDefId( src.getRequiredSchemaDefId() );
		setOptionalDefSchemaTenantId( src.getOptionalDefSchemaTenantId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalDbName( src.getOptionalDbName() );
		setOptionalShortName( src.getOptionalShortName() );
		setOptionalLabel( src.getOptionalLabel() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredPageData( src.getRequiredPageData() );
		setOptionalPrimaryIndexTenantId( src.getOptionalPrimaryIndexTenantId() );
		setOptionalPrimaryIndexId( src.getOptionalPrimaryIndexId() );
		setRequiredTableClassCode( src.getRequiredTableClassCode() );
		setOptionalLookupIndexTenantId( src.getOptionalLookupIndexTenantId() );
		setOptionalLookupIndexId( src.getOptionalLookupIndexId() );
		setOptionalAltIndexTenantId( src.getOptionalAltIndexTenantId() );
		setOptionalAltIndexId( src.getOptionalAltIndexId() );
		setOptionalQualifyingTenantId( src.getOptionalQualifyingTenantId() );
		setOptionalQualifyingTableId( src.getOptionalQualifyingTableId() );
		setRequiredIsInstantiable( src.getRequiredIsInstantiable() );
		setRequiredHasHistory( src.getRequiredHasHistory() );
		setRequiredHasAuditColumns( src.getRequiredHasAuditColumns() );
		setRequiredLoaderBehaviour( src.getRequiredLoaderBehaviour() );
		setRequiredSecScope( src.getRequiredSecScope() );
		setOptionalJObjMembers( src.getOptionalJObjMembers() );
		setOptionalJObjInterface( src.getOptionalJObjInterface() );
		setOptionalJObjImport( src.getOptionalJObjImport() );
		setOptionalJObjImplementation( src.getOptionalJObjImplementation() );
		setOptionalJEditObjMembers( src.getOptionalJEditObjMembers() );
		setOptionalJEditObjInterface( src.getOptionalJEditObjInterface() );
		setOptionalJEditObjImport( src.getOptionalJEditObjImport() );
		setOptionalJEditObjImplementation( src.getOptionalJEditObjImplementation() );
		setOptionalJTableImport( src.getOptionalJTableImport() );
		setOptionalJTableMembers( src.getOptionalJTableMembers() );
		setOptionalJTableInterface( src.getOptionalJTableInterface() );
		setOptionalJTableImplementation( src.getOptionalJTableImplementation() );
		setOptionalJTableObjImport( src.getOptionalJTableObjImport() );
		setOptionalJTableObjMembers( src.getOptionalJTableObjMembers() );
		setOptionalJTableObjInterface( src.getOptionalJTableObjInterface() );
		setOptionalJTableObjImplementation( src.getOptionalJTableObjImplementation() );
		setOptionalJDb2LUWTableImport( src.getOptionalJDb2LUWTableImport() );
		setOptionalJDb2LUWTableMembers( src.getOptionalJDb2LUWTableMembers() );
		setOptionalJDb2LUWTableImplementation( src.getOptionalJDb2LUWTableImplementation() );
		setOptionalJMSSqlTableImport( src.getOptionalJMSSqlTableImport() );
		setOptionalJMSSqlTableMembers( src.getOptionalJMSSqlTableMembers() );
		setOptionalJMSSqlTableImplementation( src.getOptionalJMSSqlTableImplementation() );
		setOptionalJMySqlTableImport( src.getOptionalJMySqlTableImport() );
		setOptionalJMySqlTableMembers( src.getOptionalJMySqlTableMembers() );
		setOptionalJMySqlTableImplementation( src.getOptionalJMySqlTableImplementation() );
		setOptionalJOracleTableImport( src.getOptionalJOracleTableImport() );
		setOptionalJOracleTableMembers( src.getOptionalJOracleTableMembers() );
		setOptionalJOracleTableImplementation( src.getOptionalJOracleTableImplementation() );
		setOptionalJPgSqlTableImport( src.getOptionalJPgSqlTableImport() );
		setOptionalJPgSqlTableMembers( src.getOptionalJPgSqlTableMembers() );
		setOptionalJPgSqlTableImplementation( src.getOptionalJPgSqlTableImplementation() );
		setOptionalJRamTableImport( src.getOptionalJRamTableImport() );
		setOptionalJRamTableMembers( src.getOptionalJRamTableMembers() );
		setOptionalJRamTableImplementation( src.getOptionalJRamTableImplementation() );
		setOptionalJSaxLoaderImport( src.getOptionalJSaxLoaderImport() );
		setOptionalJSaxLoaderStartElement( src.getOptionalJSaxLoaderStartElement() );
		setOptionalJSaxLoaderEndElement( src.getOptionalJSaxLoaderEndElement() );
		setOptionalJXMsgTableImport( src.getOptionalJXMsgTableImport() );
		setOptionalJXMsgTableFormatters( src.getOptionalJXMsgTableFormatters() );
		setOptionalJXMsgRqstTableImport( src.getOptionalJXMsgRqstTableImport() );
		setOptionalJXMsgRspnTableImport( src.getOptionalJXMsgRspnTableImport() );
		setOptionalJXMsgClientTableImport( src.getOptionalJXMsgClientTableImport() );
		setOptionalJXMsgRqstTableBody( src.getOptionalJXMsgRqstTableBody() );
		setOptionalJXMsgRspnTableBody( src.getOptionalJXMsgRspnTableBody() );
		setOptionalJXMsgClientTableBody( src.getOptionalJXMsgClientTableBody() );
		setOptionalCppObjMembers( src.getOptionalCppObjMembers() );
		setOptionalCppObjInterface( src.getOptionalCppObjInterface() );
		setOptionalCppObjInclude( src.getOptionalCppObjInclude() );
		setOptionalCppObjImplementation( src.getOptionalCppObjImplementation() );
		setOptionalCppEditObjMembers( src.getOptionalCppEditObjMembers() );
		setOptionalCppEditObjInterface( src.getOptionalCppEditObjInterface() );
		setOptionalCppEditObjInclude( src.getOptionalCppEditObjInclude() );
		setOptionalCppEditObjImplementation( src.getOptionalCppEditObjImplementation() );
		setOptionalCppTableInclude( src.getOptionalCppTableInclude() );
		setOptionalCppTableMembers( src.getOptionalCppTableMembers() );
		setOptionalCppTableInterface( src.getOptionalCppTableInterface() );
		setOptionalCppTableImplementation( src.getOptionalCppTableImplementation() );
		setOptionalCppTableObjInclude( src.getOptionalCppTableObjInclude() );
		setOptionalCppTableObjMembers( src.getOptionalCppTableObjMembers() );
		setOptionalCppTableObjInterface( src.getOptionalCppTableObjInterface() );
		setOptionalCppTableObjImplementation( src.getOptionalCppTableObjImplementation() );
		setOptionalCppDb2LUWTableInclude( src.getOptionalCppDb2LUWTableInclude() );
		setOptionalCppDb2LUWTableMembers( src.getOptionalCppDb2LUWTableMembers() );
		setOptionalCppDb2LUWTableImplementation( src.getOptionalCppDb2LUWTableImplementation() );
		setOptionalCppMSSqlTableInclude( src.getOptionalCppMSSqlTableInclude() );
		setOptionalCppMSSqlTableMembers( src.getOptionalCppMSSqlTableMembers() );
		setOptionalCppMSSqlTableImplementation( src.getOptionalCppMSSqlTableImplementation() );
		setOptionalCppMySqlTableInclude( src.getOptionalCppMySqlTableInclude() );
		setOptionalCppMySqlTableMembers( src.getOptionalCppMySqlTableMembers() );
		setOptionalCppMySqlTableImplementation( src.getOptionalCppMySqlTableImplementation() );
		setOptionalCppOracleTableInclude( src.getOptionalCppOracleTableInclude() );
		setOptionalCppOracleTableMembers( src.getOptionalCppOracleTableMembers() );
		setOptionalCppOracleTableImplementation( src.getOptionalCppOracleTableImplementation() );
		setOptionalCppPgSqlTableInclude( src.getOptionalCppPgSqlTableInclude() );
		setOptionalCppPgSqlTableMembers( src.getOptionalCppPgSqlTableMembers() );
		setOptionalCppPgSqlTableImplementation( src.getOptionalCppPgSqlTableImplementation() );
		setOptionalCppRamTableInclude( src.getOptionalCppRamTableInclude() );
		setOptionalCppRamTableMembers( src.getOptionalCppRamTableMembers() );
		setOptionalCppRamTableImplementation( src.getOptionalCppRamTableImplementation() );
		setOptionalCppSaxLoaderInclude( src.getOptionalCppSaxLoaderInclude() );
		setOptionalCppSaxLoaderStartElement( src.getOptionalCppSaxLoaderStartElement() );
		setOptionalCppSaxLoaderEndElement( src.getOptionalCppSaxLoaderEndElement() );
		setOptionalCppXMsgTableInclude( src.getOptionalCppXMsgTableInclude() );
		setOptionalCppXMsgTableFormatters( src.getOptionalCppXMsgTableFormatters() );
		setOptionalCppXMsgRqstTableInclude( src.getOptionalCppXMsgRqstTableInclude() );
		setOptionalCppXMsgRspnTableInclude( src.getOptionalCppXMsgRspnTableInclude() );
		setOptionalCppXMsgClientTableInclude( src.getOptionalCppXMsgClientTableInclude() );
		setOptionalCppXMsgRqstTableBody( src.getOptionalCppXMsgRqstTableBody() );
		setOptionalCppXMsgRspnTableBody( src.getOptionalCppXMsgRspnTableBody() );
		setOptionalCppXMsgClientTableBody( src.getOptionalCppXMsgClientTableBody() );
		setOptionalHppObjMembers( src.getOptionalHppObjMembers() );
		setOptionalHppObjInterface( src.getOptionalHppObjInterface() );
		setOptionalHppObjInclude( src.getOptionalHppObjInclude() );
		setOptionalHppObjImplementation( src.getOptionalHppObjImplementation() );
		setOptionalHppEditObjMembers( src.getOptionalHppEditObjMembers() );
		setOptionalHppEditObjInterface( src.getOptionalHppEditObjInterface() );
		setOptionalHppEditObjInclude( src.getOptionalHppEditObjInclude() );
		setOptionalHppEditObjImplementation( src.getOptionalHppEditObjImplementation() );
		setOptionalHppTableInclude( src.getOptionalHppTableInclude() );
		setOptionalHppTableMembers( src.getOptionalHppTableMembers() );
		setOptionalHppTableInterface( src.getOptionalHppTableInterface() );
		setOptionalHppTableImplementation( src.getOptionalHppTableImplementation() );
		setOptionalHppTableObjInclude( src.getOptionalHppTableObjInclude() );
		setOptionalHppTableObjMembers( src.getOptionalHppTableObjMembers() );
		setOptionalHppTableObjInterface( src.getOptionalHppTableObjInterface() );
		setOptionalHppTableObjImplementation( src.getOptionalHppTableObjImplementation() );
		setOptionalHppDb2LUWTableInclude( src.getOptionalHppDb2LUWTableInclude() );
		setOptionalHppDb2LUWTableMembers( src.getOptionalHppDb2LUWTableMembers() );
		setOptionalHppDb2LUWTableImplementation( src.getOptionalHppDb2LUWTableImplementation() );
		setOptionalHppMSSqlTableInclude( src.getOptionalHppMSSqlTableInclude() );
		setOptionalHppMSSqlTableMembers( src.getOptionalHppMSSqlTableMembers() );
		setOptionalHppMSSqlTableImplementation( src.getOptionalHppMSSqlTableImplementation() );
		setOptionalHppMySqlTableInclude( src.getOptionalHppMySqlTableInclude() );
		setOptionalHppMySqlTableMembers( src.getOptionalHppMySqlTableMembers() );
		setOptionalHppMySqlTableImplementation( src.getOptionalHppMySqlTableImplementation() );
		setOptionalHppOracleTableInclude( src.getOptionalHppOracleTableInclude() );
		setOptionalHppOracleTableMembers( src.getOptionalHppOracleTableMembers() );
		setOptionalHppOracleTableImplementation( src.getOptionalHppOracleTableImplementation() );
		setOptionalHppPgSqlTableInclude( src.getOptionalHppPgSqlTableInclude() );
		setOptionalHppPgSqlTableMembers( src.getOptionalHppPgSqlTableMembers() );
		setOptionalHppPgSqlTableImplementation( src.getOptionalHppPgSqlTableImplementation() );
		setOptionalHppRamTableInclude( src.getOptionalHppRamTableInclude() );
		setOptionalHppRamTableMembers( src.getOptionalHppRamTableMembers() );
		setOptionalHppRamTableImplementation( src.getOptionalHppRamTableImplementation() );
		setOptionalHppSaxLoaderInclude( src.getOptionalHppSaxLoaderInclude() );
		setOptionalHppSaxLoaderStartElement( src.getOptionalHppSaxLoaderStartElement() );
		setOptionalHppSaxLoaderEndElement( src.getOptionalHppSaxLoaderEndElement() );
		setOptionalHppXMsgTableInclude( src.getOptionalHppXMsgTableInclude() );
		setOptionalHppXMsgTableFormatters( src.getOptionalHppXMsgTableFormatters() );
		setOptionalHppXMsgRqstTableInclude( src.getOptionalHppXMsgRqstTableInclude() );
		setOptionalHppXMsgRspnTableInclude( src.getOptionalHppXMsgRspnTableInclude() );
		setOptionalHppXMsgClientTableInclude( src.getOptionalHppXMsgClientTableInclude() );
		setOptionalHppXMsgRqstTableBody( src.getOptionalHppXMsgRqstTableBody() );
		setOptionalHppXMsgRspnTableBody( src.getOptionalHppXMsgRspnTableBody() );
		setOptionalHppXMsgClientTableBody( src.getOptionalHppXMsgClientTableBody() );
		setOptionalCsObjMembers( src.getOptionalCsObjMembers() );
		setOptionalCsObjInterface( src.getOptionalCsObjInterface() );
		setOptionalCsObjUsing( src.getOptionalCsObjUsing() );
		setOptionalCsObjImplementation( src.getOptionalCsObjImplementation() );
		setOptionalCsEditObjMembers( src.getOptionalCsEditObjMembers() );
		setOptionalCsEditObjInterface( src.getOptionalCsEditObjInterface() );
		setOptionalCsEditObjUsing( src.getOptionalCsEditObjUsing() );
		setOptionalCsEditObjImplementation( src.getOptionalCsEditObjImplementation() );
		setOptionalCsTableUsing( src.getOptionalCsTableUsing() );
		setOptionalCsTableMembers( src.getOptionalCsTableMembers() );
		setOptionalCsTableInterface( src.getOptionalCsTableInterface() );
		setOptionalCsTableImplementation( src.getOptionalCsTableImplementation() );
		setOptionalCsTableObjUsing( src.getOptionalCsTableObjUsing() );
		setOptionalCsTableObjMembers( src.getOptionalCsTableObjMembers() );
		setOptionalCsTableObjInterface( src.getOptionalCsTableObjInterface() );
		setOptionalCsTableObjImplementation( src.getOptionalCsTableObjImplementation() );
		setOptionalCsDb2LUWTableUsing( src.getOptionalCsDb2LUWTableUsing() );
		setOptionalCsDb2LUWTableMembers( src.getOptionalCsDb2LUWTableMembers() );
		setOptionalCsDb2LUWTableImplementation( src.getOptionalCsDb2LUWTableImplementation() );
		setOptionalCsMSSqlTableUsing( src.getOptionalCsMSSqlTableUsing() );
		setOptionalCsMSSqlTableMembers( src.getOptionalCsMSSqlTableMembers() );
		setOptionalCsMSSqlTableImplementation( src.getOptionalCsMSSqlTableImplementation() );
		setOptionalCsMySqlTableUsing( src.getOptionalCsMySqlTableUsing() );
		setOptionalCsMySqlTableMembers( src.getOptionalCsMySqlTableMembers() );
		setOptionalCsMySqlTableImplementation( src.getOptionalCsMySqlTableImplementation() );
		setOptionalCsOracleTableUsing( src.getOptionalCsOracleTableUsing() );
		setOptionalCsOracleTableMembers( src.getOptionalCsOracleTableMembers() );
		setOptionalCsOracleTableImplementation( src.getOptionalCsOracleTableImplementation() );
		setOptionalCsPgSqlTableUsing( src.getOptionalCsPgSqlTableUsing() );
		setOptionalCsPgSqlTableMembers( src.getOptionalCsPgSqlTableMembers() );
		setOptionalCsPgSqlTableImplementation( src.getOptionalCsPgSqlTableImplementation() );
		setOptionalCsRamTableUsing( src.getOptionalCsRamTableUsing() );
		setOptionalCsRamTableMembers( src.getOptionalCsRamTableMembers() );
		setOptionalCsRamTableImplementation( src.getOptionalCsRamTableImplementation() );
		setOptionalCsSaxLoaderUsing( src.getOptionalCsSaxLoaderUsing() );
		setOptionalCsSaxLoaderStartElement( src.getOptionalCsSaxLoaderStartElement() );
		setOptionalCsSaxLoaderEndElement( src.getOptionalCsSaxLoaderEndElement() );
		setOptionalCsXMsgTableUsing( src.getOptionalCsXMsgTableUsing() );
		setOptionalCsXMsgTableFormatters( src.getOptionalCsXMsgTableFormatters() );
		setOptionalCsXMsgRqstTableUsing( src.getOptionalCsXMsgRqstTableUsing() );
		setOptionalCsXMsgRspnTableUsing( src.getOptionalCsXMsgRspnTableUsing() );
		setOptionalCsXMsgClientTableUsing( src.getOptionalCsXMsgClientTableUsing() );
		setOptionalCsXMsgRqstTableBody( src.getOptionalCsXMsgRqstTableBody() );
		setOptionalCsXMsgRspnTableBody( src.getOptionalCsXMsgRspnTableBody() );
		setOptionalCsXMsgClientTableBody( src.getOptionalCsXMsgClientTableBody() );
	}
}
