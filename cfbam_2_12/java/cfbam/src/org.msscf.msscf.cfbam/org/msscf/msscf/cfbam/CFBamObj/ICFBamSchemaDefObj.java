// Description: Java 11 Object interface for CFBam SchemaDef.

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

public interface ICFBamSchemaDefObj
	extends ICFBamScopeObj
{
	/**
	 *	Get the current edition of this SchemaDef instance as a ICFBamSchemaDefEditObj.
	 *
	 *	@return	The ICFBamSchemaDefEditObj edition of this instance.
	 */
	ICFBamSchemaDefEditObj getEditAsSchemaDef();

	/**
	 *	Get the ICFBamSchemaDefTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamSchemaDefTableObj table cache which manages this instance.
	 */
	ICFBamSchemaDefTableObj getSchemaDefTable();

	/**
	 *	Get the CFBamSchemaDefBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamSchemaDefBuff instance which currently backs this object.
	 */
	CFBamSchemaDefBuff getSchemaDefBuff();

	/**
	 *	Get the required long attribute MinorVersionId.
	 *
	 *	@return	The required long attribute MinorVersionId.
	 */
	long getRequiredMinorVersionId();

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
	 *	Get the optional Long attribute DefaultLicenseTenantId.
	 *
	 *	@return	The optional Long attribute DefaultLicenseTenantId.
	 */
	Long getOptionalDefaultLicenseTenantId();

	/**
	 *	Get the optional Long attribute DefaultLicenseId.
	 *
	 *	@return	The optional Long attribute DefaultLicenseId.
	 */
	Long getOptionalDefaultLicenseId();

	/**
	 *	Get the required String attribute CopyrightPeriod.
	 *
	 *	@return	The required String attribute CopyrightPeriod.
	 */
	String getRequiredCopyrightPeriod();

	/**
	 *	Get the required String attribute CopyrightHolder.
	 *
	 *	@return	The required String attribute CopyrightHolder.
	 */
	String getRequiredCopyrightHolder();

	/**
	 *	Get the required String attribute AuthorEMail.
	 *
	 *	@return	The required String attribute AuthorEMail.
	 */
	String getRequiredAuthorEMail();

	/**
	 *	Get the required String attribute ProjectURL.
	 *
	 *	@return	The required String attribute ProjectURL.
	 */
	String getRequiredProjectURL();

	/**
	 *	Get the required String attribute PublishURI.
	 *
	 *	@return	The required String attribute PublishURI.
	 */
	String getRequiredPublishURI();

	/**
	 *	Get the optional String attribute JSchemaObjImport.
	 *
	 *	@return	The optional String attribute JSchemaObjImport.
	 */
	String getOptionalJSchemaObjImport();

	/**
	 *	Get the optional String attribute JSchemaObjInterface.
	 *
	 *	@return	The optional String attribute JSchemaObjInterface.
	 */
	String getOptionalJSchemaObjInterface();

	/**
	 *	Get the optional String attribute JSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JSchemaObjMembers.
	 */
	String getOptionalJSchemaObjMembers();

	/**
	 *	Get the optional String attribute JSchemaObjImplementation.
	 *
	 *	@return	The optional String attribute JSchemaObjImplementation.
	 */
	String getOptionalJSchemaObjImplementation();

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JDb2LUWSchemaObjMembers.
	 */
	String getOptionalJDb2LUWSchemaObjMembers();

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JDb2LUWSchemaObjImpl.
	 */
	String getOptionalJDb2LUWSchemaObjImpl();

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImport.
	 *
	 *	@return	The optional String attribute JDb2LUWSchemaObjImport.
	 */
	String getOptionalJDb2LUWSchemaObjImport();

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JMSSqlSchemaObjMembers.
	 */
	String getOptionalJMSSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JMSSqlSchemaObjImpl.
	 */
	String getOptionalJMSSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImport.
	 *
	 *	@return	The optional String attribute JMSSqlSchemaObjImport.
	 */
	String getOptionalJMSSqlSchemaObjImport();

	/**
	 *	Get the optional String attribute JMySqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JMySqlSchemaObjMembers.
	 */
	String getOptionalJMySqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JMySqlSchemaObjImpl.
	 */
	String getOptionalJMySqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImport.
	 *
	 *	@return	The optional String attribute JMySqlSchemaObjImport.
	 */
	String getOptionalJMySqlSchemaObjImport();

	/**
	 *	Get the optional String attribute JOracleSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JOracleSchemaObjMembers.
	 */
	String getOptionalJOracleSchemaObjMembers();

	/**
	 *	Get the optional String attribute JOracleSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JOracleSchemaObjImpl.
	 */
	String getOptionalJOracleSchemaObjImpl();

	/**
	 *	Get the optional String attribute JOracleSchemaObjImport.
	 *
	 *	@return	The optional String attribute JOracleSchemaObjImport.
	 */
	String getOptionalJOracleSchemaObjImport();

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JPgSqlSchemaObjMembers.
	 */
	String getOptionalJPgSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JPgSqlSchemaObjImpl.
	 */
	String getOptionalJPgSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImport.
	 *
	 *	@return	The optional String attribute JPgSqlSchemaObjImport.
	 */
	String getOptionalJPgSqlSchemaObjImport();

	/**
	 *	Get the optional String attribute JRamSchemaObjMembers.
	 *
	 *	@return	The optional String attribute JRamSchemaObjMembers.
	 */
	String getOptionalJRamSchemaObjMembers();

	/**
	 *	Get the optional String attribute JRamSchemaObjImpl.
	 *
	 *	@return	The optional String attribute JRamSchemaObjImpl.
	 */
	String getOptionalJRamSchemaObjImpl();

	/**
	 *	Get the optional String attribute JRamSchemaObjImport.
	 *
	 *	@return	The optional String attribute JRamSchemaObjImport.
	 */
	String getOptionalJRamSchemaObjImport();

	/**
	 *	Get the optional String attribute JXMsgSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgSchemaImport.
	 */
	String getOptionalJXMsgSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgSchemaFormatters.
	 *
	 *	@return	The optional String attribute JXMsgSchemaFormatters.
	 */
	String getOptionalJXMsgSchemaFormatters();

	/**
	 *	Get the optional String attribute JXMsgClientSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgClientSchemaImport.
	 */
	String getOptionalJXMsgClientSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgClientSchemaBody.
	 *
	 *	@return	The optional String attribute JXMsgClientSchemaBody.
	 */
	String getOptionalJXMsgClientSchemaBody();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaBody.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaBody.
	 */
	String getOptionalJXMsgRqstSchemaBody();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaImport.
	 */
	String getOptionalJXMsgRqstSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaWireParsers.
	 */
	String getOptionalJXMsgRqstSchemaWireParsers();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalJXMsgRqstSchemaXsdSpec();

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute JXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalJXMsgRqstSchemaXsdElementList();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaBody.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaBody.
	 */
	String getOptionalJXMsgRspnSchemaBody();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaImport.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaImport.
	 */
	String getOptionalJXMsgRspnSchemaImport();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaWireParsers.
	 */
	String getOptionalJXMsgRspnSchemaWireParsers();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalJXMsgRspnSchemaXsdElementList();

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute JXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalJXMsgRspnSchemaXsdSpec();

	/**
	 *	Get the optional String attribute CppSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppSchemaObjInclude.
	 */
	String getOptionalCppSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppSchemaObjInterface.
	 *
	 *	@return	The optional String attribute CppSchemaObjInterface.
	 */
	String getOptionalCppSchemaObjInterface();

	/**
	 *	Get the optional String attribute CppSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppSchemaObjMembers.
	 */
	String getOptionalCppSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppSchemaObjImplementation.
	 *
	 *	@return	The optional String attribute CppSchemaObjImplementation.
	 */
	String getOptionalCppSchemaObjImplementation();

	/**
	 *	Get the optional String attribute CppDb2LUWSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppDb2LUWSchemaObjMembers.
	 */
	String getOptionalCppDb2LUWSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppDb2LUWSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CppDb2LUWSchemaObjImpl.
	 */
	String getOptionalCppDb2LUWSchemaObjImpl();

	/**
	 *	Get the optional String attribute CppDb2LUWSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppDb2LUWSchemaObjInclude.
	 */
	String getOptionalCppDb2LUWSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppMSSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppMSSqlSchemaObjMembers.
	 */
	String getOptionalCppMSSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppMSSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CppMSSqlSchemaObjImpl.
	 */
	String getOptionalCppMSSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute CppMSSqlSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppMSSqlSchemaObjInclude.
	 */
	String getOptionalCppMSSqlSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppMySqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppMySqlSchemaObjMembers.
	 */
	String getOptionalCppMySqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppMySqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CppMySqlSchemaObjImpl.
	 */
	String getOptionalCppMySqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute CppMySqlSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppMySqlSchemaObjInclude.
	 */
	String getOptionalCppMySqlSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppOracleSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppOracleSchemaObjMembers.
	 */
	String getOptionalCppOracleSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppOracleSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CppOracleSchemaObjImpl.
	 */
	String getOptionalCppOracleSchemaObjImpl();

	/**
	 *	Get the optional String attribute CppOracleSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppOracleSchemaObjInclude.
	 */
	String getOptionalCppOracleSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppPgSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppPgSqlSchemaObjMembers.
	 */
	String getOptionalCppPgSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppPgSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CppPgSqlSchemaObjImpl.
	 */
	String getOptionalCppPgSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute CppPgSqlSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppPgSqlSchemaObjInclude.
	 */
	String getOptionalCppPgSqlSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppRamSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CppRamSchemaObjMembers.
	 */
	String getOptionalCppRamSchemaObjMembers();

	/**
	 *	Get the optional String attribute CppRamSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CppRamSchemaObjImpl.
	 */
	String getOptionalCppRamSchemaObjImpl();

	/**
	 *	Get the optional String attribute CppRamSchemaObjInclude.
	 *
	 *	@return	The optional String attribute CppRamSchemaObjInclude.
	 */
	String getOptionalCppRamSchemaObjInclude();

	/**
	 *	Get the optional String attribute CppXMsgSchemaInclude.
	 *
	 *	@return	The optional String attribute CppXMsgSchemaInclude.
	 */
	String getOptionalCppXMsgSchemaInclude();

	/**
	 *	Get the optional String attribute CppXMsgSchemaFormatters.
	 *
	 *	@return	The optional String attribute CppXMsgSchemaFormatters.
	 */
	String getOptionalCppXMsgSchemaFormatters();

	/**
	 *	Get the optional String attribute CppXMsgClientSchemaInclude.
	 *
	 *	@return	The optional String attribute CppXMsgClientSchemaInclude.
	 */
	String getOptionalCppXMsgClientSchemaInclude();

	/**
	 *	Get the optional String attribute CppXMsgClientSchemaBody.
	 *
	 *	@return	The optional String attribute CppXMsgClientSchemaBody.
	 */
	String getOptionalCppXMsgClientSchemaBody();

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaBody.
	 *
	 *	@return	The optional String attribute CppXMsgRqstSchemaBody.
	 */
	String getOptionalCppXMsgRqstSchemaBody();

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaInclude.
	 *
	 *	@return	The optional String attribute CppXMsgRqstSchemaInclude.
	 */
	String getOptionalCppXMsgRqstSchemaInclude();

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The optional String attribute CppXMsgRqstSchemaWireParsers.
	 */
	String getOptionalCppXMsgRqstSchemaWireParsers();

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute CppXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalCppXMsgRqstSchemaXsdSpec();

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute CppXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalCppXMsgRqstSchemaXsdElementList();

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaBody.
	 *
	 *	@return	The optional String attribute CppXMsgRspnSchemaBody.
	 */
	String getOptionalCppXMsgRspnSchemaBody();

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaInclude.
	 *
	 *	@return	The optional String attribute CppXMsgRspnSchemaInclude.
	 */
	String getOptionalCppXMsgRspnSchemaInclude();

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The optional String attribute CppXMsgRspnSchemaWireParsers.
	 */
	String getOptionalCppXMsgRspnSchemaWireParsers();

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute CppXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalCppXMsgRspnSchemaXsdElementList();

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute CppXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalCppXMsgRspnSchemaXsdSpec();

	/**
	 *	Get the optional String attribute HppSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppSchemaObjInclude.
	 */
	String getOptionalHppSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppSchemaObjInterface.
	 *
	 *	@return	The optional String attribute HppSchemaObjInterface.
	 */
	String getOptionalHppSchemaObjInterface();

	/**
	 *	Get the optional String attribute HppSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppSchemaObjMembers.
	 */
	String getOptionalHppSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppSchemaObjImplementation.
	 *
	 *	@return	The optional String attribute HppSchemaObjImplementation.
	 */
	String getOptionalHppSchemaObjImplementation();

	/**
	 *	Get the optional String attribute HppDb2LUWSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppDb2LUWSchemaObjMembers.
	 */
	String getOptionalHppDb2LUWSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppDb2LUWSchemaObjImpl.
	 *
	 *	@return	The optional String attribute HppDb2LUWSchemaObjImpl.
	 */
	String getOptionalHppDb2LUWSchemaObjImpl();

	/**
	 *	Get the optional String attribute HppDb2LUWSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppDb2LUWSchemaObjInclude.
	 */
	String getOptionalHppDb2LUWSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppMSSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppMSSqlSchemaObjMembers.
	 */
	String getOptionalHppMSSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppMSSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute HppMSSqlSchemaObjImpl.
	 */
	String getOptionalHppMSSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute HppMSSqlSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppMSSqlSchemaObjInclude.
	 */
	String getOptionalHppMSSqlSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppMySqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppMySqlSchemaObjMembers.
	 */
	String getOptionalHppMySqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppMySqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute HppMySqlSchemaObjImpl.
	 */
	String getOptionalHppMySqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute HppMySqlSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppMySqlSchemaObjInclude.
	 */
	String getOptionalHppMySqlSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppOracleSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppOracleSchemaObjMembers.
	 */
	String getOptionalHppOracleSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppOracleSchemaObjImpl.
	 *
	 *	@return	The optional String attribute HppOracleSchemaObjImpl.
	 */
	String getOptionalHppOracleSchemaObjImpl();

	/**
	 *	Get the optional String attribute HppOracleSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppOracleSchemaObjInclude.
	 */
	String getOptionalHppOracleSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppPgSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppPgSqlSchemaObjMembers.
	 */
	String getOptionalHppPgSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppPgSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute HppPgSqlSchemaObjImpl.
	 */
	String getOptionalHppPgSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute HppPgSqlSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppPgSqlSchemaObjInclude.
	 */
	String getOptionalHppPgSqlSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppRamSchemaObjMembers.
	 *
	 *	@return	The optional String attribute HppRamSchemaObjMembers.
	 */
	String getOptionalHppRamSchemaObjMembers();

	/**
	 *	Get the optional String attribute HppRamSchemaObjImpl.
	 *
	 *	@return	The optional String attribute HppRamSchemaObjImpl.
	 */
	String getOptionalHppRamSchemaObjImpl();

	/**
	 *	Get the optional String attribute HppRamSchemaObjInclude.
	 *
	 *	@return	The optional String attribute HppRamSchemaObjInclude.
	 */
	String getOptionalHppRamSchemaObjInclude();

	/**
	 *	Get the optional String attribute HppXMsgSchemaInclude.
	 *
	 *	@return	The optional String attribute HppXMsgSchemaInclude.
	 */
	String getOptionalHppXMsgSchemaInclude();

	/**
	 *	Get the optional String attribute HppXMsgSchemaFormatters.
	 *
	 *	@return	The optional String attribute HppXMsgSchemaFormatters.
	 */
	String getOptionalHppXMsgSchemaFormatters();

	/**
	 *	Get the optional String attribute HppXMsgClientSchemaInclude.
	 *
	 *	@return	The optional String attribute HppXMsgClientSchemaInclude.
	 */
	String getOptionalHppXMsgClientSchemaInclude();

	/**
	 *	Get the optional String attribute HppXMsgClientSchemaBody.
	 *
	 *	@return	The optional String attribute HppXMsgClientSchemaBody.
	 */
	String getOptionalHppXMsgClientSchemaBody();

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaBody.
	 *
	 *	@return	The optional String attribute HppXMsgRqstSchemaBody.
	 */
	String getOptionalHppXMsgRqstSchemaBody();

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaInclude.
	 *
	 *	@return	The optional String attribute HppXMsgRqstSchemaInclude.
	 */
	String getOptionalHppXMsgRqstSchemaInclude();

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The optional String attribute HppXMsgRqstSchemaWireParsers.
	 */
	String getOptionalHppXMsgRqstSchemaWireParsers();

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute HppXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalHppXMsgRqstSchemaXsdSpec();

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute HppXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalHppXMsgRqstSchemaXsdElementList();

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaBody.
	 *
	 *	@return	The optional String attribute HppXMsgRspnSchemaBody.
	 */
	String getOptionalHppXMsgRspnSchemaBody();

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaInclude.
	 *
	 *	@return	The optional String attribute HppXMsgRspnSchemaInclude.
	 */
	String getOptionalHppXMsgRspnSchemaInclude();

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The optional String attribute HppXMsgRspnSchemaWireParsers.
	 */
	String getOptionalHppXMsgRspnSchemaWireParsers();

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute HppXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalHppXMsgRspnSchemaXsdElementList();

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute HppXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalHppXMsgRspnSchemaXsdSpec();

	/**
	 *	Get the optional String attribute CsSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsSchemaObjUsing.
	 */
	String getOptionalCsSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsSchemaObjInterface.
	 *
	 *	@return	The optional String attribute CsSchemaObjInterface.
	 */
	String getOptionalCsSchemaObjInterface();

	/**
	 *	Get the optional String attribute CsSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsSchemaObjMembers.
	 */
	String getOptionalCsSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsSchemaObjImplementation.
	 *
	 *	@return	The optional String attribute CsSchemaObjImplementation.
	 */
	String getOptionalCsSchemaObjImplementation();

	/**
	 *	Get the optional String attribute CsDb2LUWSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsDb2LUWSchemaObjMembers.
	 */
	String getOptionalCsDb2LUWSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsDb2LUWSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CsDb2LUWSchemaObjImpl.
	 */
	String getOptionalCsDb2LUWSchemaObjImpl();

	/**
	 *	Get the optional String attribute CsDb2LUWSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsDb2LUWSchemaObjUsing.
	 */
	String getOptionalCsDb2LUWSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsMSSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsMSSqlSchemaObjMembers.
	 */
	String getOptionalCsMSSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsMSSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CsMSSqlSchemaObjImpl.
	 */
	String getOptionalCsMSSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute CsMSSqlSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsMSSqlSchemaObjUsing.
	 */
	String getOptionalCsMSSqlSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsMySqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsMySqlSchemaObjMembers.
	 */
	String getOptionalCsMySqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsMySqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CsMySqlSchemaObjImpl.
	 */
	String getOptionalCsMySqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute CsMySqlSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsMySqlSchemaObjUsing.
	 */
	String getOptionalCsMySqlSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsOracleSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsOracleSchemaObjMembers.
	 */
	String getOptionalCsOracleSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsOracleSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CsOracleSchemaObjImpl.
	 */
	String getOptionalCsOracleSchemaObjImpl();

	/**
	 *	Get the optional String attribute CsOracleSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsOracleSchemaObjUsing.
	 */
	String getOptionalCsOracleSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsPgSqlSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsPgSqlSchemaObjMembers.
	 */
	String getOptionalCsPgSqlSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsPgSqlSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CsPgSqlSchemaObjImpl.
	 */
	String getOptionalCsPgSqlSchemaObjImpl();

	/**
	 *	Get the optional String attribute CsPgSqlSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsPgSqlSchemaObjUsing.
	 */
	String getOptionalCsPgSqlSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsRamSchemaObjMembers.
	 *
	 *	@return	The optional String attribute CsRamSchemaObjMembers.
	 */
	String getOptionalCsRamSchemaObjMembers();

	/**
	 *	Get the optional String attribute CsRamSchemaObjImpl.
	 *
	 *	@return	The optional String attribute CsRamSchemaObjImpl.
	 */
	String getOptionalCsRamSchemaObjImpl();

	/**
	 *	Get the optional String attribute CsRamSchemaObjUsing.
	 *
	 *	@return	The optional String attribute CsRamSchemaObjUsing.
	 */
	String getOptionalCsRamSchemaObjUsing();

	/**
	 *	Get the optional String attribute CsXMsgSchemaUsing.
	 *
	 *	@return	The optional String attribute CsXMsgSchemaUsing.
	 */
	String getOptionalCsXMsgSchemaUsing();

	/**
	 *	Get the optional String attribute CsXMsgSchemaFormatters.
	 *
	 *	@return	The optional String attribute CsXMsgSchemaFormatters.
	 */
	String getOptionalCsXMsgSchemaFormatters();

	/**
	 *	Get the optional String attribute CsXMsgClientSchemaUsing.
	 *
	 *	@return	The optional String attribute CsXMsgClientSchemaUsing.
	 */
	String getOptionalCsXMsgClientSchemaUsing();

	/**
	 *	Get the optional String attribute CsXMsgClientSchemaBody.
	 *
	 *	@return	The optional String attribute CsXMsgClientSchemaBody.
	 */
	String getOptionalCsXMsgClientSchemaBody();

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaBody.
	 *
	 *	@return	The optional String attribute CsXMsgRqstSchemaBody.
	 */
	String getOptionalCsXMsgRqstSchemaBody();

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaUsing.
	 *
	 *	@return	The optional String attribute CsXMsgRqstSchemaUsing.
	 */
	String getOptionalCsXMsgRqstSchemaUsing();

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The optional String attribute CsXMsgRqstSchemaWireParsers.
	 */
	String getOptionalCsXMsgRqstSchemaWireParsers();

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute CsXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalCsXMsgRqstSchemaXsdSpec();

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute CsXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalCsXMsgRqstSchemaXsdElementList();

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaBody.
	 *
	 *	@return	The optional String attribute CsXMsgRspnSchemaBody.
	 */
	String getOptionalCsXMsgRspnSchemaBody();

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaUsing.
	 *
	 *	@return	The optional String attribute CsXMsgRspnSchemaUsing.
	 */
	String getOptionalCsXMsgRspnSchemaUsing();

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The optional String attribute CsXMsgRspnSchemaWireParsers.
	 */
	String getOptionalCsXMsgRspnSchemaWireParsers();

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The optional String attribute CsXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalCsXMsgRspnSchemaXsdElementList();

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The optional String attribute CsXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalCsXMsgRspnSchemaXsdSpec();

	/**
	 *	Get the required ICFBamMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required ICFBamMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Get the required ICFIntMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The required ICFIntMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional ICFBamTableObj[] array of instances referenced by the Tables key.
	 */
	List<ICFBamTableObj> getOptionalComponentsTables();

	/**
	 *	Get the array of optional ICFBamTableObj array of instances referenced by the Tables key.
	 *
	 *	@return	The optional ICFBamTableObj[] array of instances referenced by the Tables key.
	 */
	List<ICFBamTableObj> getOptionalComponentsTables( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Types key.
	 */
	List<ICFBamValueObj> getOptionalComponentsTypes();

	/**
	 *	Get the array of optional ICFBamValueObj array of instances referenced by the Types key.
	 *
	 *	@return	The optional ICFBamValueObj[] array of instances referenced by the Types key.
	 */
	List<ICFBamValueObj> getOptionalComponentsTypes( boolean forceRead );

	/**
	 *	Get the optional ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@return	The optional ICFBamLicenseObj instance referenced by the DefaultLicense key.
	 */
	ICFIntLicenseObj getOptionalLookupDefaultLicense();

	/**
	 *	Get the optional ICFIntLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@return	The optional ICFIntLicenseObj instance referenced by the DefaultLicense key.
	 */
	ICFIntLicenseObj getOptionalLookupDefaultLicense( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs();

	/**
	 *	Get the array of optional ICFBamSchemaRefObj array of instances referenced by the SchemaRefs key.
	 *
	 *	@return	The optional ICFBamSchemaRefObj[] array of instances referenced by the SchemaRefs key.
	 */
	List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead );

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the CTenant key.
	 */
	ICFSecTenantObj getRequiredOwnerCTenant();

	/**
	 *	Get the required ICFSecTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The required ICFSecTenantObj instance referenced by the CTenant key.
	 */
	ICFSecTenantObj getRequiredOwnerCTenant( boolean forceRead );

}
