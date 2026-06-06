// Description: Java 11 Object interface for CFBam Table.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamTableObj
	extends ICFBamScopeObj
{
	/**
	 *	Get the current edition of this Table instance as a ICFBamTableEditObj.
	 *
	 *	@return	The ICFBamTableEditObj edition of this instance.
	 */
	ICFBamTableEditObj getEditAsTable();

	/**
	 *	Get the ICFBamTableTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamTableTableObj table cache which manages this instance.
	 */
	ICFBamTableTableObj getTableTable();

	/**
	 *	Get the CFBamTableBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamTableBuff instance which currently backs this object.
	 */
	CFBamTableBuff getTableBuff();

	/**
	 *	Get the required long attribute SchemaDefId.
	 *
	 *	@return	The required long attribute SchemaDefId.
	 */
	long getRequiredSchemaDefId();

	/**
	 *	Get the optional Long attribute DefSchemaTenantId.
	 *
	 *	@return	The optional Long attribute DefSchemaTenantId.
	 */
	Long getOptionalDefSchemaTenantId();

	/**
	 *	Get the optional Long attribute DefSchemaId.
	 *
	 *	@return	The optional Long attribute DefSchemaId.
	 */
	Long getOptionalDefSchemaId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The optional String attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The optional String attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The optional String attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The optional String attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the required boolean attribute PageData.
	 *
	 *	@return	The required boolean attribute PageData.
	 */
	boolean getRequiredPageData();

	/**
	 *	Get the optional Long attribute PrimaryIndexTenantId.
	 *
	 *	@return	The optional Long attribute PrimaryIndexTenantId.
	 */
	Long getOptionalPrimaryIndexTenantId();

	/**
	 *	Get the optional Long attribute PrimaryIndexId.
	 *
	 *	@return	The optional Long attribute PrimaryIndexId.
	 */
	Long getOptionalPrimaryIndexId();

	/**
	 *	Get the required String attribute TableClassCode.
	 *
	 *	@return	The required String attribute TableClassCode.
	 */
	String getRequiredTableClassCode();

	/**
	 *	Get the optional Long attribute LookupIndexTenantId.
	 *
	 *	@return	The optional Long attribute LookupIndexTenantId.
	 */
	Long getOptionalLookupIndexTenantId();

	/**
	 *	Get the optional Long attribute LookupIndexId.
	 *
	 *	@return	The optional Long attribute LookupIndexId.
	 */
	Long getOptionalLookupIndexId();

	/**
	 *	Get the optional Long attribute AltIndexTenantId.
	 *
	 *	@return	The optional Long attribute AltIndexTenantId.
	 */
	Long getOptionalAltIndexTenantId();

	/**
	 *	Get the optional Long attribute AltIndexId.
	 *
	 *	@return	The optional Long attribute AltIndexId.
	 */
	Long getOptionalAltIndexId();

	/**
	 *	Get the optional Long attribute QualifyingTenantId.
	 *
	 *	@return	The optional Long attribute QualifyingTenantId.
	 */
	Long getOptionalQualifyingTenantId();

	/**
	 *	Get the optional Long attribute QualifyingTableId.
	 *
	 *	@return	The optional Long attribute QualifyingTableId.
	 */
	Long getOptionalQualifyingTableId();

	/**
	 *	Get the required boolean attribute IsInstantiable.
	 *
	 *	@return	The required boolean attribute IsInstantiable.
	 */
	boolean getRequiredIsInstantiable();

	/**
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The required boolean attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Get the required boolean attribute HasAuditColumns.
	 *
	 *	@return	The required boolean attribute HasAuditColumns.
	 */
	boolean getRequiredHasAuditColumns();

	/**
	 *	Get the required ICFBamSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@return	The required ICFBamSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 */
	ICFBamSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();

	/**
	 *	Get the required ICFBamSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@return	The required ICFBamSchema.SecScopeEnum attribute SecScope.
	 */
	ICFBamSchema.SecScopeEnum getRequiredSecScope();

	/**
	 *	Get the optional String attribute JObjMembers.
	 *
	 *	@return	The optional String attribute JObjMembers.
	 */
	String getOptionalJObjMembers();

	/**
	 *	Get the optional String attribute JObjInterface.
	 *
	 *	@return	The optional String attribute JObjInterface.
	 */
	String getOptionalJObjInterface();

	/**
	 *	Get the optional String attribute JObjImport.
	 *
	 *	@return	The optional String attribute JObjImport.
	 */
	String getOptionalJObjImport();

	/**
	 *	Get the optional String attribute JObjImplementation.
	 *
	 *	@return	The optional String attribute JObjImplementation.
	 */
	String getOptionalJObjImplementation();

	/**
	 *	Get the optional String attribute JEditObjMembers.
	 *
	 *	@return	The optional String attribute JEditObjMembers.
	 */
	String getOptionalJEditObjMembers();

	/**
	 *	Get the optional String attribute JEditObjInterface.
	 *
	 *	@return	The optional String attribute JEditObjInterface.
	 */
	String getOptionalJEditObjInterface();

	/**
	 *	Get the optional String attribute JEditObjImport.
	 *
	 *	@return	The optional String attribute JEditObjImport.
	 */
	String getOptionalJEditObjImport();

	/**
	 *	Get the optional String attribute JEditObjImplementation.
	 *
	 *	@return	The optional String attribute JEditObjImplementation.
	 */
	String getOptionalJEditObjImplementation();

	/**
	 *	Get the optional String attribute JTableImport.
	 *
	 *	@return	The optional String attribute JTableImport.
	 */
	String getOptionalJTableImport();

	/**
	 *	Get the optional String attribute JTableMembers.
	 *
	 *	@return	The optional String attribute JTableMembers.
	 */
	String getOptionalJTableMembers();

	/**
	 *	Get the optional String attribute JTableInterface.
	 *
	 *	@return	The optional String attribute JTableInterface.
	 */
	String getOptionalJTableInterface();

	/**
	 *	Get the optional String attribute JTableImplementation.
	 *
	 *	@return	The optional String attribute JTableImplementation.
	 */
	String getOptionalJTableImplementation();

	/**
	 *	Get the optional String attribute JTableObjImport.
	 *
	 *	@return	The optional String attribute JTableObjImport.
	 */
	String getOptionalJTableObjImport();

	/**
	 *	Get the optional String attribute JTableObjMembers.
	 *
	 *	@return	The optional String attribute JTableObjMembers.
	 */
	String getOptionalJTableObjMembers();

	/**
	 *	Get the optional String attribute JTableObjInterface.
	 *
	 *	@return	The optional String attribute JTableObjInterface.
	 */
	String getOptionalJTableObjInterface();

	/**
	 *	Get the optional String attribute JTableObjImplementation.
	 *
	 *	@return	The optional String attribute JTableObjImplementation.
	 */
	String getOptionalJTableObjImplementation();

	/**
	 *	Get the optional String attribute JDb2LUWTableImport.
	 *
	 *	@return	The optional String attribute JDb2LUWTableImport.
	 */
	String getOptionalJDb2LUWTableImport();

	/**
	 *	Get the optional String attribute JDb2LUWTableMembers.
	 *
	 *	@return	The optional String attribute JDb2LUWTableMembers.
	 */
	String getOptionalJDb2LUWTableMembers();

	/**
	 *	Get the optional String attribute JDb2LUWTableImplementation.
	 *
	 *	@return	The optional String attribute JDb2LUWTableImplementation.
	 */
	String getOptionalJDb2LUWTableImplementation();

	/**
	 *	Get the optional String attribute JMSSqlTableImport.
	 *
	 *	@return	The optional String attribute JMSSqlTableImport.
	 */
	String getOptionalJMSSqlTableImport();

	/**
	 *	Get the optional String attribute JMSSqlTableMembers.
	 *
	 *	@return	The optional String attribute JMSSqlTableMembers.
	 */
	String getOptionalJMSSqlTableMembers();

	/**
	 *	Get the optional String attribute JMSSqlTableImplementation.
	 *
	 *	@return	The optional String attribute JMSSqlTableImplementation.
	 */
	String getOptionalJMSSqlTableImplementation();

	/**
	 *	Get the optional String attribute JMySqlTableImport.
	 *
	 *	@return	The optional String attribute JMySqlTableImport.
	 */
	String getOptionalJMySqlTableImport();

	/**
	 *	Get the optional String attribute JMySqlTableMembers.
	 *
	 *	@return	The optional String attribute JMySqlTableMembers.
	 */
	String getOptionalJMySqlTableMembers();

	/**
	 *	Get the optional String attribute JMySqlTableImplementation.
	 *
	 *	@return	The optional String attribute JMySqlTableImplementation.
	 */
	String getOptionalJMySqlTableImplementation();

	/**
	 *	Get the optional String attribute JOracleTableImport.
	 *
	 *	@return	The optional String attribute JOracleTableImport.
	 */
	String getOptionalJOracleTableImport();

	/**
	 *	Get the optional String attribute JOracleTableMembers.
	 *
	 *	@return	The optional String attribute JOracleTableMembers.
	 */
	String getOptionalJOracleTableMembers();

	/**
	 *	Get the optional String attribute JOracleTableImplementation.
	 *
	 *	@return	The optional String attribute JOracleTableImplementation.
	 */
	String getOptionalJOracleTableImplementation();

	/**
	 *	Get the optional String attribute JPgSqlTableImport.
	 *
	 *	@return	The optional String attribute JPgSqlTableImport.
	 */
	String getOptionalJPgSqlTableImport();

	/**
	 *	Get the optional String attribute JPgSqlTableMembers.
	 *
	 *	@return	The optional String attribute JPgSqlTableMembers.
	 */
	String getOptionalJPgSqlTableMembers();

	/**
	 *	Get the optional String attribute JPgSqlTableImplementation.
	 *
	 *	@return	The optional String attribute JPgSqlTableImplementation.
	 */
	String getOptionalJPgSqlTableImplementation();

	/**
	 *	Get the optional String attribute JRamTableImport.
	 *
	 *	@return	The optional String attribute JRamTableImport.
	 */
	String getOptionalJRamTableImport();

	/**
	 *	Get the optional String attribute JRamTableMembers.
	 *
	 *	@return	The optional String attribute JRamTableMembers.
	 */
	String getOptionalJRamTableMembers();

	/**
	 *	Get the optional String attribute JRamTableImplementation.
	 *
	 *	@return	The optional String attribute JRamTableImplementation.
	 */
	String getOptionalJRamTableImplementation();

	/**
	 *	Get the optional String attribute JSaxLoaderImport.
	 *
	 *	@return	The optional String attribute JSaxLoaderImport.
	 */
	String getOptionalJSaxLoaderImport();

	/**
	 *	Get the optional String attribute JSaxLoaderStartElement.
	 *
	 *	@return	The optional String attribute JSaxLoaderStartElement.
	 */
	String getOptionalJSaxLoaderStartElement();

	/**
	 *	Get the optional String attribute JSaxLoaderEndElement.
	 *
	 *	@return	The optional String attribute JSaxLoaderEndElement.
	 */
	String getOptionalJSaxLoaderEndElement();

	/**
	 *	Get the optional String attribute JXMsgTableImport.
	 *
	 *	@return	The optional String attribute JXMsgTableImport.
	 */
	String getOptionalJXMsgTableImport();

	/**
	 *	Get the optional String attribute JXMsgTableFormatters.
	 *
	 *	@return	The optional String attribute JXMsgTableFormatters.
	 */
	String getOptionalJXMsgTableFormatters();

	/**
	 *	Get the optional String attribute JXMsgRqstTableImport.
	 *
	 *	@return	The optional String attribute JXMsgRqstTableImport.
	 */
	String getOptionalJXMsgRqstTableImport();

	/**
	 *	Get the optional String attribute JXMsgRspnTableImport.
	 *
	 *	@return	The optional String attribute JXMsgRspnTableImport.
	 */
	String getOptionalJXMsgRspnTableImport();

	/**
	 *	Get the optional String attribute JXMsgClientTableImport.
	 *
	 *	@return	The optional String attribute JXMsgClientTableImport.
	 */
	String getOptionalJXMsgClientTableImport();

	/**
	 *	Get the optional String attribute JXMsgRqstTableBody.
	 *
	 *	@return	The optional String attribute JXMsgRqstTableBody.
	 */
	String getOptionalJXMsgRqstTableBody();

	/**
	 *	Get the optional String attribute JXMsgRspnTableBody.
	 *
	 *	@return	The optional String attribute JXMsgRspnTableBody.
	 */
	String getOptionalJXMsgRspnTableBody();

	/**
	 *	Get the optional String attribute JXMsgClientTableBody.
	 *
	 *	@return	The optional String attribute JXMsgClientTableBody.
	 */
	String getOptionalJXMsgClientTableBody();

	/**
	 *	Get the optional String attribute CppObjMembers.
	 *
	 *	@return	The optional String attribute CppObjMembers.
	 */
	String getOptionalCppObjMembers();

	/**
	 *	Get the optional String attribute CppObjInterface.
	 *
	 *	@return	The optional String attribute CppObjInterface.
	 */
	String getOptionalCppObjInterface();

	/**
	 *	Get the optional String attribute CppObjInclude.
	 *
	 *	@return	The optional String attribute CppObjInclude.
	 */
	String getOptionalCppObjInclude();

	/**
	 *	Get the optional String attribute CppObjImplementation.
	 *
	 *	@return	The optional String attribute CppObjImplementation.
	 */
	String getOptionalCppObjImplementation();

	/**
	 *	Get the optional String attribute CppEditObjMembers.
	 *
	 *	@return	The optional String attribute CppEditObjMembers.
	 */
	String getOptionalCppEditObjMembers();

	/**
	 *	Get the optional String attribute CppEditObjInterface.
	 *
	 *	@return	The optional String attribute CppEditObjInterface.
	 */
	String getOptionalCppEditObjInterface();

	/**
	 *	Get the optional String attribute CppEditObjInclude.
	 *
	 *	@return	The optional String attribute CppEditObjInclude.
	 */
	String getOptionalCppEditObjInclude();

	/**
	 *	Get the optional String attribute CppEditObjImplementation.
	 *
	 *	@return	The optional String attribute CppEditObjImplementation.
	 */
	String getOptionalCppEditObjImplementation();

	/**
	 *	Get the optional String attribute CppTableInclude.
	 *
	 *	@return	The optional String attribute CppTableInclude.
	 */
	String getOptionalCppTableInclude();

	/**
	 *	Get the optional String attribute CppTableMembers.
	 *
	 *	@return	The optional String attribute CppTableMembers.
	 */
	String getOptionalCppTableMembers();

	/**
	 *	Get the optional String attribute CppTableInterface.
	 *
	 *	@return	The optional String attribute CppTableInterface.
	 */
	String getOptionalCppTableInterface();

	/**
	 *	Get the optional String attribute CppTableImplementation.
	 *
	 *	@return	The optional String attribute CppTableImplementation.
	 */
	String getOptionalCppTableImplementation();

	/**
	 *	Get the optional String attribute CppTableObjInclude.
	 *
	 *	@return	The optional String attribute CppTableObjInclude.
	 */
	String getOptionalCppTableObjInclude();

	/**
	 *	Get the optional String attribute CppTableObjMembers.
	 *
	 *	@return	The optional String attribute CppTableObjMembers.
	 */
	String getOptionalCppTableObjMembers();

	/**
	 *	Get the optional String attribute CppTableObjInterface.
	 *
	 *	@return	The optional String attribute CppTableObjInterface.
	 */
	String getOptionalCppTableObjInterface();

	/**
	 *	Get the optional String attribute CppTableObjImplementation.
	 *
	 *	@return	The optional String attribute CppTableObjImplementation.
	 */
	String getOptionalCppTableObjImplementation();

	/**
	 *	Get the optional String attribute CppDb2LUWTableInclude.
	 *
	 *	@return	The optional String attribute CppDb2LUWTableInclude.
	 */
	String getOptionalCppDb2LUWTableInclude();

	/**
	 *	Get the optional String attribute CppDb2LUWTableMembers.
	 *
	 *	@return	The optional String attribute CppDb2LUWTableMembers.
	 */
	String getOptionalCppDb2LUWTableMembers();

	/**
	 *	Get the optional String attribute CppDb2LUWTableImplementation.
	 *
	 *	@return	The optional String attribute CppDb2LUWTableImplementation.
	 */
	String getOptionalCppDb2LUWTableImplementation();

	/**
	 *	Get the optional String attribute CppMSSqlTableInclude.
	 *
	 *	@return	The optional String attribute CppMSSqlTableInclude.
	 */
	String getOptionalCppMSSqlTableInclude();

	/**
	 *	Get the optional String attribute CppMSSqlTableMembers.
	 *
	 *	@return	The optional String attribute CppMSSqlTableMembers.
	 */
	String getOptionalCppMSSqlTableMembers();

	/**
	 *	Get the optional String attribute CppMSSqlTableImplementation.
	 *
	 *	@return	The optional String attribute CppMSSqlTableImplementation.
	 */
	String getOptionalCppMSSqlTableImplementation();

	/**
	 *	Get the optional String attribute CppMySqlTableInclude.
	 *
	 *	@return	The optional String attribute CppMySqlTableInclude.
	 */
	String getOptionalCppMySqlTableInclude();

	/**
	 *	Get the optional String attribute CppMySqlTableMembers.
	 *
	 *	@return	The optional String attribute CppMySqlTableMembers.
	 */
	String getOptionalCppMySqlTableMembers();

	/**
	 *	Get the optional String attribute CppMySqlTableImplementation.
	 *
	 *	@return	The optional String attribute CppMySqlTableImplementation.
	 */
	String getOptionalCppMySqlTableImplementation();

	/**
	 *	Get the optional String attribute CppOracleTableInclude.
	 *
	 *	@return	The optional String attribute CppOracleTableInclude.
	 */
	String getOptionalCppOracleTableInclude();

	/**
	 *	Get the optional String attribute CppOracleTableMembers.
	 *
	 *	@return	The optional String attribute CppOracleTableMembers.
	 */
	String getOptionalCppOracleTableMembers();

	/**
	 *	Get the optional String attribute CppOracleTableImplementation.
	 *
	 *	@return	The optional String attribute CppOracleTableImplementation.
	 */
	String getOptionalCppOracleTableImplementation();

	/**
	 *	Get the optional String attribute CppPgSqlTableInclude.
	 *
	 *	@return	The optional String attribute CppPgSqlTableInclude.
	 */
	String getOptionalCppPgSqlTableInclude();

	/**
	 *	Get the optional String attribute CppPgSqlTableMembers.
	 *
	 *	@return	The optional String attribute CppPgSqlTableMembers.
	 */
	String getOptionalCppPgSqlTableMembers();

	/**
	 *	Get the optional String attribute CppPgSqlTableImplementation.
	 *
	 *	@return	The optional String attribute CppPgSqlTableImplementation.
	 */
	String getOptionalCppPgSqlTableImplementation();

	/**
	 *	Get the optional String attribute CppRamTableInclude.
	 *
	 *	@return	The optional String attribute CppRamTableInclude.
	 */
	String getOptionalCppRamTableInclude();

	/**
	 *	Get the optional String attribute CppRamTableMembers.
	 *
	 *	@return	The optional String attribute CppRamTableMembers.
	 */
	String getOptionalCppRamTableMembers();

	/**
	 *	Get the optional String attribute CppRamTableImplementation.
	 *
	 *	@return	The optional String attribute CppRamTableImplementation.
	 */
	String getOptionalCppRamTableImplementation();

	/**
	 *	Get the optional String attribute CppSaxLoaderInclude.
	 *
	 *	@return	The optional String attribute CppSaxLoaderInclude.
	 */
	String getOptionalCppSaxLoaderInclude();

	/**
	 *	Get the optional String attribute CppSaxLoaderStartElement.
	 *
	 *	@return	The optional String attribute CppSaxLoaderStartElement.
	 */
	String getOptionalCppSaxLoaderStartElement();

	/**
	 *	Get the optional String attribute CppSaxLoaderEndElement.
	 *
	 *	@return	The optional String attribute CppSaxLoaderEndElement.
	 */
	String getOptionalCppSaxLoaderEndElement();

	/**
	 *	Get the optional String attribute CppXMsgTableInclude.
	 *
	 *	@return	The optional String attribute CppXMsgTableInclude.
	 */
	String getOptionalCppXMsgTableInclude();

	/**
	 *	Get the optional String attribute CppXMsgTableFormatters.
	 *
	 *	@return	The optional String attribute CppXMsgTableFormatters.
	 */
	String getOptionalCppXMsgTableFormatters();

	/**
	 *	Get the optional String attribute CppXMsgRqstTableInclude.
	 *
	 *	@return	The optional String attribute CppXMsgRqstTableInclude.
	 */
	String getOptionalCppXMsgRqstTableInclude();

	/**
	 *	Get the optional String attribute CppXMsgRspnTableInclude.
	 *
	 *	@return	The optional String attribute CppXMsgRspnTableInclude.
	 */
	String getOptionalCppXMsgRspnTableInclude();

	/**
	 *	Get the optional String attribute CppXMsgClientTableInclude.
	 *
	 *	@return	The optional String attribute CppXMsgClientTableInclude.
	 */
	String getOptionalCppXMsgClientTableInclude();

	/**
	 *	Get the optional String attribute CppXMsgRqstTableBody.
	 *
	 *	@return	The optional String attribute CppXMsgRqstTableBody.
	 */
	String getOptionalCppXMsgRqstTableBody();

	/**
	 *	Get the optional String attribute CppXMsgRspnTableBody.
	 *
	 *	@return	The optional String attribute CppXMsgRspnTableBody.
	 */
	String getOptionalCppXMsgRspnTableBody();

	/**
	 *	Get the optional String attribute CppXMsgClientTableBody.
	 *
	 *	@return	The optional String attribute CppXMsgClientTableBody.
	 */
	String getOptionalCppXMsgClientTableBody();

	/**
	 *	Get the optional String attribute HppObjMembers.
	 *
	 *	@return	The optional String attribute HppObjMembers.
	 */
	String getOptionalHppObjMembers();

	/**
	 *	Get the optional String attribute HppObjInterface.
	 *
	 *	@return	The optional String attribute HppObjInterface.
	 */
	String getOptionalHppObjInterface();

	/**
	 *	Get the optional String attribute HppObjInclude.
	 *
	 *	@return	The optional String attribute HppObjInclude.
	 */
	String getOptionalHppObjInclude();

	/**
	 *	Get the optional String attribute HppObjImplementation.
	 *
	 *	@return	The optional String attribute HppObjImplementation.
	 */
	String getOptionalHppObjImplementation();

	/**
	 *	Get the optional String attribute HppEditObjMembers.
	 *
	 *	@return	The optional String attribute HppEditObjMembers.
	 */
	String getOptionalHppEditObjMembers();

	/**
	 *	Get the optional String attribute HppEditObjInterface.
	 *
	 *	@return	The optional String attribute HppEditObjInterface.
	 */
	String getOptionalHppEditObjInterface();

	/**
	 *	Get the optional String attribute HppEditObjInclude.
	 *
	 *	@return	The optional String attribute HppEditObjInclude.
	 */
	String getOptionalHppEditObjInclude();

	/**
	 *	Get the optional String attribute HppEditObjImplementation.
	 *
	 *	@return	The optional String attribute HppEditObjImplementation.
	 */
	String getOptionalHppEditObjImplementation();

	/**
	 *	Get the optional String attribute HppTableInclude.
	 *
	 *	@return	The optional String attribute HppTableInclude.
	 */
	String getOptionalHppTableInclude();

	/**
	 *	Get the optional String attribute HppTableMembers.
	 *
	 *	@return	The optional String attribute HppTableMembers.
	 */
	String getOptionalHppTableMembers();

	/**
	 *	Get the optional String attribute HppTableInterface.
	 *
	 *	@return	The optional String attribute HppTableInterface.
	 */
	String getOptionalHppTableInterface();

	/**
	 *	Get the optional String attribute HppTableImplementation.
	 *
	 *	@return	The optional String attribute HppTableImplementation.
	 */
	String getOptionalHppTableImplementation();

	/**
	 *	Get the optional String attribute HppTableObjInclude.
	 *
	 *	@return	The optional String attribute HppTableObjInclude.
	 */
	String getOptionalHppTableObjInclude();

	/**
	 *	Get the optional String attribute HppTableObjMembers.
	 *
	 *	@return	The optional String attribute HppTableObjMembers.
	 */
	String getOptionalHppTableObjMembers();

	/**
	 *	Get the optional String attribute HppTableObjInterface.
	 *
	 *	@return	The optional String attribute HppTableObjInterface.
	 */
	String getOptionalHppTableObjInterface();

	/**
	 *	Get the optional String attribute HppTableObjImplementation.
	 *
	 *	@return	The optional String attribute HppTableObjImplementation.
	 */
	String getOptionalHppTableObjImplementation();

	/**
	 *	Get the optional String attribute HppDb2LUWTableInclude.
	 *
	 *	@return	The optional String attribute HppDb2LUWTableInclude.
	 */
	String getOptionalHppDb2LUWTableInclude();

	/**
	 *	Get the optional String attribute HppDb2LUWTableMembers.
	 *
	 *	@return	The optional String attribute HppDb2LUWTableMembers.
	 */
	String getOptionalHppDb2LUWTableMembers();

	/**
	 *	Get the optional String attribute HppDb2LUWTableImplementation.
	 *
	 *	@return	The optional String attribute HppDb2LUWTableImplementation.
	 */
	String getOptionalHppDb2LUWTableImplementation();

	/**
	 *	Get the optional String attribute HppMSSqlTableInclude.
	 *
	 *	@return	The optional String attribute HppMSSqlTableInclude.
	 */
	String getOptionalHppMSSqlTableInclude();

	/**
	 *	Get the optional String attribute HppMSSqlTableMembers.
	 *
	 *	@return	The optional String attribute HppMSSqlTableMembers.
	 */
	String getOptionalHppMSSqlTableMembers();

	/**
	 *	Get the optional String attribute HppMSSqlTableImplementation.
	 *
	 *	@return	The optional String attribute HppMSSqlTableImplementation.
	 */
	String getOptionalHppMSSqlTableImplementation();

	/**
	 *	Get the optional String attribute HppMySqlTableInclude.
	 *
	 *	@return	The optional String attribute HppMySqlTableInclude.
	 */
	String getOptionalHppMySqlTableInclude();

	/**
	 *	Get the optional String attribute HppMySqlTableMembers.
	 *
	 *	@return	The optional String attribute HppMySqlTableMembers.
	 */
	String getOptionalHppMySqlTableMembers();

	/**
	 *	Get the optional String attribute HppMySqlTableImplementation.
	 *
	 *	@return	The optional String attribute HppMySqlTableImplementation.
	 */
	String getOptionalHppMySqlTableImplementation();

	/**
	 *	Get the optional String attribute HppOracleTableInclude.
	 *
	 *	@return	The optional String attribute HppOracleTableInclude.
	 */
	String getOptionalHppOracleTableInclude();

	/**
	 *	Get the optional String attribute HppOracleTableMembers.
	 *
	 *	@return	The optional String attribute HppOracleTableMembers.
	 */
	String getOptionalHppOracleTableMembers();

	/**
	 *	Get the optional String attribute HppOracleTableImplementation.
	 *
	 *	@return	The optional String attribute HppOracleTableImplementation.
	 */
	String getOptionalHppOracleTableImplementation();

	/**
	 *	Get the optional String attribute HppPgSqlTableInclude.
	 *
	 *	@return	The optional String attribute HppPgSqlTableInclude.
	 */
	String getOptionalHppPgSqlTableInclude();

	/**
	 *	Get the optional String attribute HppPgSqlTableMembers.
	 *
	 *	@return	The optional String attribute HppPgSqlTableMembers.
	 */
	String getOptionalHppPgSqlTableMembers();

	/**
	 *	Get the optional String attribute HppPgSqlTableImplementation.
	 *
	 *	@return	The optional String attribute HppPgSqlTableImplementation.
	 */
	String getOptionalHppPgSqlTableImplementation();

	/**
	 *	Get the optional String attribute HppRamTableInclude.
	 *
	 *	@return	The optional String attribute HppRamTableInclude.
	 */
	String getOptionalHppRamTableInclude();

	/**
	 *	Get the optional String attribute HppRamTableMembers.
	 *
	 *	@return	The optional String attribute HppRamTableMembers.
	 */
	String getOptionalHppRamTableMembers();

	/**
	 *	Get the optional String attribute HppRamTableImplementation.
	 *
	 *	@return	The optional String attribute HppRamTableImplementation.
	 */
	String getOptionalHppRamTableImplementation();

	/**
	 *	Get the optional String attribute HppSaxLoaderInclude.
	 *
	 *	@return	The optional String attribute HppSaxLoaderInclude.
	 */
	String getOptionalHppSaxLoaderInclude();

	/**
	 *	Get the optional String attribute HppSaxLoaderStartElement.
	 *
	 *	@return	The optional String attribute HppSaxLoaderStartElement.
	 */
	String getOptionalHppSaxLoaderStartElement();

	/**
	 *	Get the optional String attribute HppSaxLoaderEndElement.
	 *
	 *	@return	The optional String attribute HppSaxLoaderEndElement.
	 */
	String getOptionalHppSaxLoaderEndElement();

	/**
	 *	Get the optional String attribute HppXMsgTableInclude.
	 *
	 *	@return	The optional String attribute HppXMsgTableInclude.
	 */
	String getOptionalHppXMsgTableInclude();

	/**
	 *	Get the optional String attribute HppXMsgTableFormatters.
	 *
	 *	@return	The optional String attribute HppXMsgTableFormatters.
	 */
	String getOptionalHppXMsgTableFormatters();

	/**
	 *	Get the optional String attribute HppXMsgRqstTableInclude.
	 *
	 *	@return	The optional String attribute HppXMsgRqstTableInclude.
	 */
	String getOptionalHppXMsgRqstTableInclude();

	/**
	 *	Get the optional String attribute HppXMsgRspnTableInclude.
	 *
	 *	@return	The optional String attribute HppXMsgRspnTableInclude.
	 */
	String getOptionalHppXMsgRspnTableInclude();

	/**
	 *	Get the optional String attribute HppXMsgClientTableInclude.
	 *
	 *	@return	The optional String attribute HppXMsgClientTableInclude.
	 */
	String getOptionalHppXMsgClientTableInclude();

	/**
	 *	Get the optional String attribute HppXMsgRqstTableBody.
	 *
	 *	@return	The optional String attribute HppXMsgRqstTableBody.
	 */
	String getOptionalHppXMsgRqstTableBody();

	/**
	 *	Get the optional String attribute HppXMsgRspnTableBody.
	 *
	 *	@return	The optional String attribute HppXMsgRspnTableBody.
	 */
	String getOptionalHppXMsgRspnTableBody();

	/**
	 *	Get the optional String attribute HppXMsgClientTableBody.
	 *
	 *	@return	The optional String attribute HppXMsgClientTableBody.
	 */
	String getOptionalHppXMsgClientTableBody();

	/**
	 *	Get the optional String attribute CsObjMembers.
	 *
	 *	@return	The optional String attribute CsObjMembers.
	 */
	String getOptionalCsObjMembers();

	/**
	 *	Get the optional String attribute CsObjInterface.
	 *
	 *	@return	The optional String attribute CsObjInterface.
	 */
	String getOptionalCsObjInterface();

	/**
	 *	Get the optional String attribute CsObjUsing.
	 *
	 *	@return	The optional String attribute CsObjUsing.
	 */
	String getOptionalCsObjUsing();

	/**
	 *	Get the optional String attribute CsObjImplementation.
	 *
	 *	@return	The optional String attribute CsObjImplementation.
	 */
	String getOptionalCsObjImplementation();

	/**
	 *	Get the optional String attribute CsEditObjMembers.
	 *
	 *	@return	The optional String attribute CsEditObjMembers.
	 */
	String getOptionalCsEditObjMembers();

	/**
	 *	Get the optional String attribute CsEditObjInterface.
	 *
	 *	@return	The optional String attribute CsEditObjInterface.
	 */
	String getOptionalCsEditObjInterface();

	/**
	 *	Get the optional String attribute CsEditObjUsing.
	 *
	 *	@return	The optional String attribute CsEditObjUsing.
	 */
	String getOptionalCsEditObjUsing();

	/**
	 *	Get the optional String attribute CsEditObjImplementation.
	 *
	 *	@return	The optional String attribute CsEditObjImplementation.
	 */
	String getOptionalCsEditObjImplementation();

	/**
	 *	Get the optional String attribute CsTableUsing.
	 *
	 *	@return	The optional String attribute CsTableUsing.
	 */
	String getOptionalCsTableUsing();

	/**
	 *	Get the optional String attribute CsTableMembers.
	 *
	 *	@return	The optional String attribute CsTableMembers.
	 */
	String getOptionalCsTableMembers();

	/**
	 *	Get the optional String attribute CsTableInterface.
	 *
	 *	@return	The optional String attribute CsTableInterface.
	 */
	String getOptionalCsTableInterface();

	/**
	 *	Get the optional String attribute CsTableImplementation.
	 *
	 *	@return	The optional String attribute CsTableImplementation.
	 */
	String getOptionalCsTableImplementation();

	/**
	 *	Get the optional String attribute CsTableObjUsing.
	 *
	 *	@return	The optional String attribute CsTableObjUsing.
	 */
	String getOptionalCsTableObjUsing();

	/**
	 *	Get the optional String attribute CsTableObjMembers.
	 *
	 *	@return	The optional String attribute CsTableObjMembers.
	 */
	String getOptionalCsTableObjMembers();

	/**
	 *	Get the optional String attribute CsTableObjInterface.
	 *
	 *	@return	The optional String attribute CsTableObjInterface.
	 */
	String getOptionalCsTableObjInterface();

	/**
	 *	Get the optional String attribute CsTableObjImplementation.
	 *
	 *	@return	The optional String attribute CsTableObjImplementation.
	 */
	String getOptionalCsTableObjImplementation();

	/**
	 *	Get the optional String attribute CsDb2LUWTableUsing.
	 *
	 *	@return	The optional String attribute CsDb2LUWTableUsing.
	 */
	String getOptionalCsDb2LUWTableUsing();

	/**
	 *	Get the optional String attribute CsDb2LUWTableMembers.
	 *
	 *	@return	The optional String attribute CsDb2LUWTableMembers.
	 */
	String getOptionalCsDb2LUWTableMembers();

	/**
	 *	Get the optional String attribute CsDb2LUWTableImplementation.
	 *
	 *	@return	The optional String attribute CsDb2LUWTableImplementation.
	 */
	String getOptionalCsDb2LUWTableImplementation();

	/**
	 *	Get the optional String attribute CsMSSqlTableUsing.
	 *
	 *	@return	The optional String attribute CsMSSqlTableUsing.
	 */
	String getOptionalCsMSSqlTableUsing();

	/**
	 *	Get the optional String attribute CsMSSqlTableMembers.
	 *
	 *	@return	The optional String attribute CsMSSqlTableMembers.
	 */
	String getOptionalCsMSSqlTableMembers();

	/**
	 *	Get the optional String attribute CsMSSqlTableImplementation.
	 *
	 *	@return	The optional String attribute CsMSSqlTableImplementation.
	 */
	String getOptionalCsMSSqlTableImplementation();

	/**
	 *	Get the optional String attribute CsMySqlTableUsing.
	 *
	 *	@return	The optional String attribute CsMySqlTableUsing.
	 */
	String getOptionalCsMySqlTableUsing();

	/**
	 *	Get the optional String attribute CsMySqlTableMembers.
	 *
	 *	@return	The optional String attribute CsMySqlTableMembers.
	 */
	String getOptionalCsMySqlTableMembers();

	/**
	 *	Get the optional String attribute CsMySqlTableImplementation.
	 *
	 *	@return	The optional String attribute CsMySqlTableImplementation.
	 */
	String getOptionalCsMySqlTableImplementation();

	/**
	 *	Get the optional String attribute CsOracleTableUsing.
	 *
	 *	@return	The optional String attribute CsOracleTableUsing.
	 */
	String getOptionalCsOracleTableUsing();

	/**
	 *	Get the optional String attribute CsOracleTableMembers.
	 *
	 *	@return	The optional String attribute CsOracleTableMembers.
	 */
	String getOptionalCsOracleTableMembers();

	/**
	 *	Get the optional String attribute CsOracleTableImplementation.
	 *
	 *	@return	The optional String attribute CsOracleTableImplementation.
	 */
	String getOptionalCsOracleTableImplementation();

	/**
	 *	Get the optional String attribute CsPgSqlTableUsing.
	 *
	 *	@return	The optional String attribute CsPgSqlTableUsing.
	 */
	String getOptionalCsPgSqlTableUsing();

	/**
	 *	Get the optional String attribute CsPgSqlTableMembers.
	 *
	 *	@return	The optional String attribute CsPgSqlTableMembers.
	 */
	String getOptionalCsPgSqlTableMembers();

	/**
	 *	Get the optional String attribute CsPgSqlTableImplementation.
	 *
	 *	@return	The optional String attribute CsPgSqlTableImplementation.
	 */
	String getOptionalCsPgSqlTableImplementation();

	/**
	 *	Get the optional String attribute CsRamTableUsing.
	 *
	 *	@return	The optional String attribute CsRamTableUsing.
	 */
	String getOptionalCsRamTableUsing();

	/**
	 *	Get the optional String attribute CsRamTableMembers.
	 *
	 *	@return	The optional String attribute CsRamTableMembers.
	 */
	String getOptionalCsRamTableMembers();

	/**
	 *	Get the optional String attribute CsRamTableImplementation.
	 *
	 *	@return	The optional String attribute CsRamTableImplementation.
	 */
	String getOptionalCsRamTableImplementation();

	/**
	 *	Get the optional String attribute CsSaxLoaderUsing.
	 *
	 *	@return	The optional String attribute CsSaxLoaderUsing.
	 */
	String getOptionalCsSaxLoaderUsing();

	/**
	 *	Get the optional String attribute CsSaxLoaderStartElement.
	 *
	 *	@return	The optional String attribute CsSaxLoaderStartElement.
	 */
	String getOptionalCsSaxLoaderStartElement();

	/**
	 *	Get the optional String attribute CsSaxLoaderEndElement.
	 *
	 *	@return	The optional String attribute CsSaxLoaderEndElement.
	 */
	String getOptionalCsSaxLoaderEndElement();

	/**
	 *	Get the optional String attribute CsXMsgTableUsing.
	 *
	 *	@return	The optional String attribute CsXMsgTableUsing.
	 */
	String getOptionalCsXMsgTableUsing();

	/**
	 *	Get the optional String attribute CsXMsgTableFormatters.
	 *
	 *	@return	The optional String attribute CsXMsgTableFormatters.
	 */
	String getOptionalCsXMsgTableFormatters();

	/**
	 *	Get the optional String attribute CsXMsgRqstTableUsing.
	 *
	 *	@return	The optional String attribute CsXMsgRqstTableUsing.
	 */
	String getOptionalCsXMsgRqstTableUsing();

	/**
	 *	Get the optional String attribute CsXMsgRspnTableUsing.
	 *
	 *	@return	The optional String attribute CsXMsgRspnTableUsing.
	 */
	String getOptionalCsXMsgRspnTableUsing();

	/**
	 *	Get the optional String attribute CsXMsgClientTableUsing.
	 *
	 *	@return	The optional String attribute CsXMsgClientTableUsing.
	 */
	String getOptionalCsXMsgClientTableUsing();

	/**
	 *	Get the optional String attribute CsXMsgRqstTableBody.
	 *
	 *	@return	The optional String attribute CsXMsgRqstTableBody.
	 */
	String getOptionalCsXMsgRqstTableBody();

	/**
	 *	Get the optional String attribute CsXMsgRspnTableBody.
	 *
	 *	@return	The optional String attribute CsXMsgRspnTableBody.
	 */
	String getOptionalCsXMsgRspnTableBody();

	/**
	 *	Get the optional String attribute CsXMsgClientTableBody.
	 *
	 *	@return	The optional String attribute CsXMsgClientTableBody.
	 */
	String getOptionalCsXMsgClientTableBody();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Get the required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The required ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead );

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Get the optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The optional ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the Relation key.
	 */
	List<ICFBamRelationObj> getOptionalComponentsRelation();

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the Relation key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the Relation key.
	 */
	List<ICFBamRelationObj> getOptionalComponentsRelation( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamIndexObj getOptionalLookupLookupIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamIndexObj getOptionalLookupAltIndex();

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamIndexObj getOptionalLookupAltIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the QualTable key.
	 */
	ICFBamTableObj getOptionalLookupQualTable();

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the QualTable key.
	 */
	ICFBamTableObj getOptionalLookupQualTable( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional ICFBamIndexObj[] array of instances referenced by the Index key.
	 */
	List<ICFBamIndexObj> getOptionalComponentsIndex();

	/**
	 *	Get the array of optional ICFBamIndexObj array of instances referenced by the Index key.
	 *
	 *	@return	The optional ICFBamIndexObj[] array of instances referenced by the Index key.
	 */
	List<ICFBamIndexObj> getOptionalComponentsIndex( boolean forceRead );

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Get the optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The optional ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamIndexObj getOptionalLookupPrimaryIndex( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamValueObj> getOptionalComponentsColumns();

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Columns key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Columns key.
	 */
	List<ICFBamValueObj> getOptionalComponentsColumns( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<ICFBamRelationObj> getOptionalChildrenReverseRelations();

	/**
	 *	Get the array of optional ICFBamRelationObj array of instances referenced by the ReverseRelations key.
	 *
	 *	@return	The optional ICFBamRelationObj[] array of instances referenced by the ReverseRelations key.
	 */
	List<ICFBamRelationObj> getOptionalChildrenReverseRelations( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional ICFBamChainObj[] array of instances referenced by the Chains key.
	 */
	List<ICFBamChainObj> getOptionalComponentsChains();

	/**
	 *	Get the array of optional ICFBamChainObj array of instances referenced by the Chains key.
	 *
	 *	@return	The optional ICFBamChainObj[] array of instances referenced by the Chains key.
	 */
	List<ICFBamChainObj> getOptionalComponentsChains( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelTopDepObj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional ICFBamDelTopDepObj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearTopDepObj> getOptionalComponentsClearDep();

	/**
	 *	Get the array of optional ICFBamClearTopDepObj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamId16GenObj array of instances referenced by the DispId16Gen key.
	 *
	 *	@return	The optional ICFBamId16GenObj[] array of instances referenced by the DispId16Gen key.
	 */
	List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen();

	/**
	 *	Get the array of optional ICFBamId16GenObj array of instances referenced by the DispId16Gen key.
	 *
	 *	@return	The optional ICFBamId16GenObj[] array of instances referenced by the DispId16Gen key.
	 */
	List<ICFBamId16GenObj> getOptionalChildrenDispId16Gen( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamId32GenObj array of instances referenced by the DispId32Gen key.
	 *
	 *	@return	The optional ICFBamId32GenObj[] array of instances referenced by the DispId32Gen key.
	 */
	List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen();

	/**
	 *	Get the array of optional ICFBamId32GenObj array of instances referenced by the DispId32Gen key.
	 *
	 *	@return	The optional ICFBamId32GenObj[] array of instances referenced by the DispId32Gen key.
	 */
	List<ICFBamId32GenObj> getOptionalChildrenDispId32Gen( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamId64GenObj array of instances referenced by the DispId64Gen key.
	 *
	 *	@return	The optional ICFBamId64GenObj[] array of instances referenced by the DispId64Gen key.
	 */
	List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen();

	/**
	 *	Get the array of optional ICFBamId64GenObj array of instances referenced by the DispId64Gen key.
	 *
	 *	@return	The optional ICFBamId64GenObj[] array of instances referenced by the DispId64Gen key.
	 */
	List<ICFBamId64GenObj> getOptionalChildrenDispId64Gen( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional ICFBamServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<ICFBamServerMethodObj> getOptionalComponentsServerMethods();

	/**
	 *	Get the array of optional ICFBamServerMethodObj array of instances referenced by the ServerMethods key.
	 *
	 *	@return	The optional ICFBamServerMethodObj[] array of instances referenced by the ServerMethods key.
	 */
	List<ICFBamServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead );

	List<ICFBamRelationObj> getOnlyOwnerRelations();
	List<ICFBamRelationObj> getContainerOwnerRelations();
	ICFBamRelationObj getContainerRelation();
	ICFBamRelationObj getInheritedContainerRelation();
	ICFBamRelationObj getOwnerRelation();
	ICFBamRelationObj getInheritedOwnerRelation();
	List<ICFBamRelationObj> getOwnerLookupRelations();
	List<ICFBamRelationObj> getOwnerContainerNamedLookupChainRelations();
	List<ICFBamAtomObj> getChildrenAtoms();
	ICFBamRelationObj getSuperClassRelation();
	List<ICFBamRelationObj> getSubClassRelations();
	ICFBamIndexObj getPrimaryKeyIndex();
	List<ICFBamRelationObj> getFactoryOwnerRelations();
	List<ICFBamIndexObj> getInheritedIndexes();
	List<ICFBamIndexObj> getChildrenIndexes();
	List<ICFBamRelationObj> getInheritedRelations();
	List<ICFBamRelationObj> getChildrenRelations();

}
