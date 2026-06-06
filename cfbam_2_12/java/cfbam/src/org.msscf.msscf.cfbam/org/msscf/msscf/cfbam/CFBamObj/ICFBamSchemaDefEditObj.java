// Description: Java 11 Instance Edit Object interface for CFBam SchemaDef.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamSchemaDefEditObj
	extends ICFBamSchemaDefObj,
		ICFBamScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamSchemaDefObj.
	 */
	ICFBamSchemaDefObj getOrigAsSchemaDef();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The String value of the attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param	value	the String value of the attribute Name.
	 */
	void setRequiredName( String value );

	/**
	 *	Get the optional String attribute DbName.
	 *
	 *	@return	The String value of the attribute DbName.
	 */
	String getOptionalDbName();

	/**
	 *	Set the optional String attribute DbName.
	 *
	 *	@param	value	the String value of the attribute DbName.
	 */
	void setOptionalDbName( String value );

	/**
	 *	Get the optional String attribute ShortName.
	 *
	 *	@return	The String value of the attribute ShortName.
	 */
	String getOptionalShortName();

	/**
	 *	Set the optional String attribute ShortName.
	 *
	 *	@param	value	the String value of the attribute ShortName.
	 */
	void setOptionalShortName( String value );

	/**
	 *	Get the optional String attribute Label.
	 *
	 *	@return	The String value of the attribute Label.
	 */
	String getOptionalLabel();

	/**
	 *	Set the optional String attribute Label.
	 *
	 *	@param	value	the String value of the attribute Label.
	 */
	void setOptionalLabel( String value );

	/**
	 *	Get the optional String attribute ShortDescription.
	 *
	 *	@return	The String value of the attribute ShortDescription.
	 */
	String getOptionalShortDescription();

	/**
	 *	Set the optional String attribute ShortDescription.
	 *
	 *	@param	value	the String value of the attribute ShortDescription.
	 */
	void setOptionalShortDescription( String value );

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The String value of the attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Set the optional String attribute Description.
	 *
	 *	@param	value	the String value of the attribute Description.
	 */
	void setOptionalDescription( String value );

	/**
	 *	Get the required String attribute CopyrightPeriod.
	 *
	 *	@return	The String value of the attribute CopyrightPeriod.
	 */
	String getRequiredCopyrightPeriod();

	/**
	 *	Set the required String attribute CopyrightPeriod.
	 *
	 *	@param	value	the String value of the attribute CopyrightPeriod.
	 */
	void setRequiredCopyrightPeriod( String value );

	/**
	 *	Get the required String attribute CopyrightHolder.
	 *
	 *	@return	The String value of the attribute CopyrightHolder.
	 */
	String getRequiredCopyrightHolder();

	/**
	 *	Set the required String attribute CopyrightHolder.
	 *
	 *	@param	value	the String value of the attribute CopyrightHolder.
	 */
	void setRequiredCopyrightHolder( String value );

	/**
	 *	Get the required String attribute AuthorEMail.
	 *
	 *	@return	The String value of the attribute AuthorEMail.
	 */
	String getRequiredAuthorEMail();

	/**
	 *	Set the required String attribute AuthorEMail.
	 *
	 *	@param	value	the String value of the attribute AuthorEMail.
	 */
	void setRequiredAuthorEMail( String value );

	/**
	 *	Get the required String attribute ProjectURL.
	 *
	 *	@return	The String value of the attribute ProjectURL.
	 */
	String getRequiredProjectURL();

	/**
	 *	Set the required String attribute ProjectURL.
	 *
	 *	@param	value	the String value of the attribute ProjectURL.
	 */
	void setRequiredProjectURL( String value );

	/**
	 *	Get the required String attribute PublishURI.
	 *
	 *	@return	The String value of the attribute PublishURI.
	 */
	String getRequiredPublishURI();

	/**
	 *	Set the required String attribute PublishURI.
	 *
	 *	@param	value	the String value of the attribute PublishURI.
	 */
	void setRequiredPublishURI( String value );

	/**
	 *	Get the optional String attribute JSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JSchemaObjImport.
	 */
	String getOptionalJSchemaObjImport();

	/**
	 *	Set the optional String attribute JSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjImport.
	 */
	void setOptionalJSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JSchemaObjInterface.
	 *
	 *	@return	The String value of the attribute JSchemaObjInterface.
	 */
	String getOptionalJSchemaObjInterface();

	/**
	 *	Set the optional String attribute JSchemaObjInterface.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjInterface.
	 */
	void setOptionalJSchemaObjInterface( String value );

	/**
	 *	Get the optional String attribute JSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JSchemaObjMembers.
	 */
	String getOptionalJSchemaObjMembers();

	/**
	 *	Set the optional String attribute JSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjMembers.
	 */
	void setOptionalJSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JSchemaObjImplementation.
	 *
	 *	@return	The String value of the attribute JSchemaObjImplementation.
	 */
	String getOptionalJSchemaObjImplementation();

	/**
	 *	Set the optional String attribute JSchemaObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JSchemaObjImplementation.
	 */
	void setOptionalJSchemaObjImplementation( String value );

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JDb2LUWSchemaObjMembers.
	 */
	String getOptionalJDb2LUWSchemaObjMembers();

	/**
	 *	Set the optional String attribute JDb2LUWSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWSchemaObjMembers.
	 */
	void setOptionalJDb2LUWSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JDb2LUWSchemaObjImpl.
	 */
	String getOptionalJDb2LUWSchemaObjImpl();

	/**
	 *	Set the optional String attribute JDb2LUWSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWSchemaObjImpl.
	 */
	void setOptionalJDb2LUWSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JDb2LUWSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JDb2LUWSchemaObjImport.
	 */
	String getOptionalJDb2LUWSchemaObjImport();

	/**
	 *	Set the optional String attribute JDb2LUWSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWSchemaObjImport.
	 */
	void setOptionalJDb2LUWSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JMSSqlSchemaObjMembers.
	 */
	String getOptionalJMSSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute JMSSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JMSSqlSchemaObjMembers.
	 */
	void setOptionalJMSSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JMSSqlSchemaObjImpl.
	 */
	String getOptionalJMSSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute JMSSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JMSSqlSchemaObjImpl.
	 */
	void setOptionalJMSSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JMSSqlSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JMSSqlSchemaObjImport.
	 */
	String getOptionalJMSSqlSchemaObjImport();

	/**
	 *	Set the optional String attribute JMSSqlSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JMSSqlSchemaObjImport.
	 */
	void setOptionalJMSSqlSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JMySqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JMySqlSchemaObjMembers.
	 */
	String getOptionalJMySqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute JMySqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JMySqlSchemaObjMembers.
	 */
	void setOptionalJMySqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JMySqlSchemaObjImpl.
	 */
	String getOptionalJMySqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute JMySqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JMySqlSchemaObjImpl.
	 */
	void setOptionalJMySqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JMySqlSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JMySqlSchemaObjImport.
	 */
	String getOptionalJMySqlSchemaObjImport();

	/**
	 *	Set the optional String attribute JMySqlSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JMySqlSchemaObjImport.
	 */
	void setOptionalJMySqlSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JOracleSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JOracleSchemaObjMembers.
	 */
	String getOptionalJOracleSchemaObjMembers();

	/**
	 *	Set the optional String attribute JOracleSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JOracleSchemaObjMembers.
	 */
	void setOptionalJOracleSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JOracleSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JOracleSchemaObjImpl.
	 */
	String getOptionalJOracleSchemaObjImpl();

	/**
	 *	Set the optional String attribute JOracleSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JOracleSchemaObjImpl.
	 */
	void setOptionalJOracleSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JOracleSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JOracleSchemaObjImport.
	 */
	String getOptionalJOracleSchemaObjImport();

	/**
	 *	Set the optional String attribute JOracleSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JOracleSchemaObjImport.
	 */
	void setOptionalJOracleSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JPgSqlSchemaObjMembers.
	 */
	String getOptionalJPgSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute JPgSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JPgSqlSchemaObjMembers.
	 */
	void setOptionalJPgSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JPgSqlSchemaObjImpl.
	 */
	String getOptionalJPgSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute JPgSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JPgSqlSchemaObjImpl.
	 */
	void setOptionalJPgSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JPgSqlSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JPgSqlSchemaObjImport.
	 */
	String getOptionalJPgSqlSchemaObjImport();

	/**
	 *	Set the optional String attribute JPgSqlSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JPgSqlSchemaObjImport.
	 */
	void setOptionalJPgSqlSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JRamSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute JRamSchemaObjMembers.
	 */
	String getOptionalJRamSchemaObjMembers();

	/**
	 *	Set the optional String attribute JRamSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute JRamSchemaObjMembers.
	 */
	void setOptionalJRamSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute JRamSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute JRamSchemaObjImpl.
	 */
	String getOptionalJRamSchemaObjImpl();

	/**
	 *	Set the optional String attribute JRamSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute JRamSchemaObjImpl.
	 */
	void setOptionalJRamSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute JRamSchemaObjImport.
	 *
	 *	@return	The String value of the attribute JRamSchemaObjImport.
	 */
	String getOptionalJRamSchemaObjImport();

	/**
	 *	Set the optional String attribute JRamSchemaObjImport.
	 *
	 *	@param	value	the String value of the attribute JRamSchemaObjImport.
	 */
	void setOptionalJRamSchemaObjImport( String value );

	/**
	 *	Get the optional String attribute JXMsgSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgSchemaImport.
	 */
	String getOptionalJXMsgSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgSchemaImport.
	 */
	void setOptionalJXMsgSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgSchemaFormatters.
	 *
	 *	@return	The String value of the attribute JXMsgSchemaFormatters.
	 */
	String getOptionalJXMsgSchemaFormatters();

	/**
	 *	Set the optional String attribute JXMsgSchemaFormatters.
	 *
	 *	@param	value	the String value of the attribute JXMsgSchemaFormatters.
	 */
	void setOptionalJXMsgSchemaFormatters( String value );

	/**
	 *	Get the optional String attribute JXMsgClientSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgClientSchemaImport.
	 */
	String getOptionalJXMsgClientSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgClientSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientSchemaImport.
	 */
	void setOptionalJXMsgClientSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgClientSchemaBody.
	 *
	 *	@return	The String value of the attribute JXMsgClientSchemaBody.
	 */
	String getOptionalJXMsgClientSchemaBody();

	/**
	 *	Set the optional String attribute JXMsgClientSchemaBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientSchemaBody.
	 */
	void setOptionalJXMsgClientSchemaBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaBody.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaBody.
	 */
	String getOptionalJXMsgRqstSchemaBody();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaBody.
	 */
	void setOptionalJXMsgRqstSchemaBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaImport.
	 */
	String getOptionalJXMsgRqstSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaImport.
	 */
	void setOptionalJXMsgRqstSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaWireParsers.
	 */
	String getOptionalJXMsgRqstSchemaWireParsers();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaWireParsers.
	 */
	void setOptionalJXMsgRqstSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalJXMsgRqstSchemaXsdSpec();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaXsdSpec.
	 */
	void setOptionalJXMsgRqstSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute JXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalJXMsgRqstSchemaXsdElementList();

	/**
	 *	Set the optional String attribute JXMsgRqstSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstSchemaXsdElementList.
	 */
	void setOptionalJXMsgRqstSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaBody.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaBody.
	 */
	String getOptionalJXMsgRspnSchemaBody();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaBody.
	 */
	void setOptionalJXMsgRspnSchemaBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaImport.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaImport.
	 */
	String getOptionalJXMsgRspnSchemaImport();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaImport.
	 */
	void setOptionalJXMsgRspnSchemaImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaWireParsers.
	 */
	String getOptionalJXMsgRspnSchemaWireParsers();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaWireParsers.
	 */
	void setOptionalJXMsgRspnSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalJXMsgRspnSchemaXsdElementList();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaXsdElementList.
	 */
	void setOptionalJXMsgRspnSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute JXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalJXMsgRspnSchemaXsdSpec();

	/**
	 *	Set the optional String attribute JXMsgRspnSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnSchemaXsdSpec.
	 */
	void setOptionalJXMsgRspnSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute CppSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppSchemaObjInclude.
	 */
	String getOptionalCppSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppSchemaObjInclude.
	 */
	void setOptionalCppSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppSchemaObjInterface.
	 *
	 *	@return	The String value of the attribute CppSchemaObjInterface.
	 */
	String getOptionalCppSchemaObjInterface();

	/**
	 *	Set the optional String attribute CppSchemaObjInterface.
	 *
	 *	@param	value	the String value of the attribute CppSchemaObjInterface.
	 */
	void setOptionalCppSchemaObjInterface( String value );

	/**
	 *	Get the optional String attribute CppSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppSchemaObjMembers.
	 */
	String getOptionalCppSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppSchemaObjMembers.
	 */
	void setOptionalCppSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppSchemaObjImplementation.
	 *
	 *	@return	The String value of the attribute CppSchemaObjImplementation.
	 */
	String getOptionalCppSchemaObjImplementation();

	/**
	 *	Set the optional String attribute CppSchemaObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CppSchemaObjImplementation.
	 */
	void setOptionalCppSchemaObjImplementation( String value );

	/**
	 *	Get the optional String attribute CppDb2LUWSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppDb2LUWSchemaObjMembers.
	 */
	String getOptionalCppDb2LUWSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppDb2LUWSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppDb2LUWSchemaObjMembers.
	 */
	void setOptionalCppDb2LUWSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppDb2LUWSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CppDb2LUWSchemaObjImpl.
	 */
	String getOptionalCppDb2LUWSchemaObjImpl();

	/**
	 *	Set the optional String attribute CppDb2LUWSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CppDb2LUWSchemaObjImpl.
	 */
	void setOptionalCppDb2LUWSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CppDb2LUWSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppDb2LUWSchemaObjInclude.
	 */
	String getOptionalCppDb2LUWSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppDb2LUWSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppDb2LUWSchemaObjInclude.
	 */
	void setOptionalCppDb2LUWSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppMSSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppMSSqlSchemaObjMembers.
	 */
	String getOptionalCppMSSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppMSSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppMSSqlSchemaObjMembers.
	 */
	void setOptionalCppMSSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppMSSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CppMSSqlSchemaObjImpl.
	 */
	String getOptionalCppMSSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute CppMSSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CppMSSqlSchemaObjImpl.
	 */
	void setOptionalCppMSSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CppMSSqlSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppMSSqlSchemaObjInclude.
	 */
	String getOptionalCppMSSqlSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppMSSqlSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppMSSqlSchemaObjInclude.
	 */
	void setOptionalCppMSSqlSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppMySqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppMySqlSchemaObjMembers.
	 */
	String getOptionalCppMySqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppMySqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppMySqlSchemaObjMembers.
	 */
	void setOptionalCppMySqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppMySqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CppMySqlSchemaObjImpl.
	 */
	String getOptionalCppMySqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute CppMySqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CppMySqlSchemaObjImpl.
	 */
	void setOptionalCppMySqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CppMySqlSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppMySqlSchemaObjInclude.
	 */
	String getOptionalCppMySqlSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppMySqlSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppMySqlSchemaObjInclude.
	 */
	void setOptionalCppMySqlSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppOracleSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppOracleSchemaObjMembers.
	 */
	String getOptionalCppOracleSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppOracleSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppOracleSchemaObjMembers.
	 */
	void setOptionalCppOracleSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppOracleSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CppOracleSchemaObjImpl.
	 */
	String getOptionalCppOracleSchemaObjImpl();

	/**
	 *	Set the optional String attribute CppOracleSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CppOracleSchemaObjImpl.
	 */
	void setOptionalCppOracleSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CppOracleSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppOracleSchemaObjInclude.
	 */
	String getOptionalCppOracleSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppOracleSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppOracleSchemaObjInclude.
	 */
	void setOptionalCppOracleSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppPgSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppPgSqlSchemaObjMembers.
	 */
	String getOptionalCppPgSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppPgSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppPgSqlSchemaObjMembers.
	 */
	void setOptionalCppPgSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppPgSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CppPgSqlSchemaObjImpl.
	 */
	String getOptionalCppPgSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute CppPgSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CppPgSqlSchemaObjImpl.
	 */
	void setOptionalCppPgSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CppPgSqlSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppPgSqlSchemaObjInclude.
	 */
	String getOptionalCppPgSqlSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppPgSqlSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppPgSqlSchemaObjInclude.
	 */
	void setOptionalCppPgSqlSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppRamSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CppRamSchemaObjMembers.
	 */
	String getOptionalCppRamSchemaObjMembers();

	/**
	 *	Set the optional String attribute CppRamSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppRamSchemaObjMembers.
	 */
	void setOptionalCppRamSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CppRamSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CppRamSchemaObjImpl.
	 */
	String getOptionalCppRamSchemaObjImpl();

	/**
	 *	Set the optional String attribute CppRamSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CppRamSchemaObjImpl.
	 */
	void setOptionalCppRamSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CppRamSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute CppRamSchemaObjInclude.
	 */
	String getOptionalCppRamSchemaObjInclude();

	/**
	 *	Set the optional String attribute CppRamSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppRamSchemaObjInclude.
	 */
	void setOptionalCppRamSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgSchemaInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgSchemaInclude.
	 */
	String getOptionalCppXMsgSchemaInclude();

	/**
	 *	Set the optional String attribute CppXMsgSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgSchemaInclude.
	 */
	void setOptionalCppXMsgSchemaInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgSchemaFormatters.
	 *
	 *	@return	The String value of the attribute CppXMsgSchemaFormatters.
	 */
	String getOptionalCppXMsgSchemaFormatters();

	/**
	 *	Set the optional String attribute CppXMsgSchemaFormatters.
	 *
	 *	@param	value	the String value of the attribute CppXMsgSchemaFormatters.
	 */
	void setOptionalCppXMsgSchemaFormatters( String value );

	/**
	 *	Get the optional String attribute CppXMsgClientSchemaInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgClientSchemaInclude.
	 */
	String getOptionalCppXMsgClientSchemaInclude();

	/**
	 *	Set the optional String attribute CppXMsgClientSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgClientSchemaInclude.
	 */
	void setOptionalCppXMsgClientSchemaInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgClientSchemaBody.
	 *
	 *	@return	The String value of the attribute CppXMsgClientSchemaBody.
	 */
	String getOptionalCppXMsgClientSchemaBody();

	/**
	 *	Set the optional String attribute CppXMsgClientSchemaBody.
	 *
	 *	@param	value	the String value of the attribute CppXMsgClientSchemaBody.
	 */
	void setOptionalCppXMsgClientSchemaBody( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaBody.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstSchemaBody.
	 */
	String getOptionalCppXMsgRqstSchemaBody();

	/**
	 *	Set the optional String attribute CppXMsgRqstSchemaBody.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstSchemaBody.
	 */
	void setOptionalCppXMsgRqstSchemaBody( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstSchemaInclude.
	 */
	String getOptionalCppXMsgRqstSchemaInclude();

	/**
	 *	Set the optional String attribute CppXMsgRqstSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstSchemaInclude.
	 */
	void setOptionalCppXMsgRqstSchemaInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstSchemaWireParsers.
	 */
	String getOptionalCppXMsgRqstSchemaWireParsers();

	/**
	 *	Set the optional String attribute CppXMsgRqstSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstSchemaWireParsers.
	 */
	void setOptionalCppXMsgRqstSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalCppXMsgRqstSchemaXsdSpec();

	/**
	 *	Set the optional String attribute CppXMsgRqstSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstSchemaXsdSpec.
	 */
	void setOptionalCppXMsgRqstSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalCppXMsgRqstSchemaXsdElementList();

	/**
	 *	Set the optional String attribute CppXMsgRqstSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstSchemaXsdElementList.
	 */
	void setOptionalCppXMsgRqstSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaBody.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnSchemaBody.
	 */
	String getOptionalCppXMsgRspnSchemaBody();

	/**
	 *	Set the optional String attribute CppXMsgRspnSchemaBody.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnSchemaBody.
	 */
	void setOptionalCppXMsgRspnSchemaBody( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnSchemaInclude.
	 */
	String getOptionalCppXMsgRspnSchemaInclude();

	/**
	 *	Set the optional String attribute CppXMsgRspnSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnSchemaInclude.
	 */
	void setOptionalCppXMsgRspnSchemaInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnSchemaWireParsers.
	 */
	String getOptionalCppXMsgRspnSchemaWireParsers();

	/**
	 *	Set the optional String attribute CppXMsgRspnSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnSchemaWireParsers.
	 */
	void setOptionalCppXMsgRspnSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalCppXMsgRspnSchemaXsdElementList();

	/**
	 *	Set the optional String attribute CppXMsgRspnSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnSchemaXsdElementList.
	 */
	void setOptionalCppXMsgRspnSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalCppXMsgRspnSchemaXsdSpec();

	/**
	 *	Set the optional String attribute CppXMsgRspnSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnSchemaXsdSpec.
	 */
	void setOptionalCppXMsgRspnSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute HppSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppSchemaObjInclude.
	 */
	String getOptionalHppSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppSchemaObjInclude.
	 */
	void setOptionalHppSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppSchemaObjInterface.
	 *
	 *	@return	The String value of the attribute HppSchemaObjInterface.
	 */
	String getOptionalHppSchemaObjInterface();

	/**
	 *	Set the optional String attribute HppSchemaObjInterface.
	 *
	 *	@param	value	the String value of the attribute HppSchemaObjInterface.
	 */
	void setOptionalHppSchemaObjInterface( String value );

	/**
	 *	Get the optional String attribute HppSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppSchemaObjMembers.
	 */
	String getOptionalHppSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppSchemaObjMembers.
	 */
	void setOptionalHppSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppSchemaObjImplementation.
	 *
	 *	@return	The String value of the attribute HppSchemaObjImplementation.
	 */
	String getOptionalHppSchemaObjImplementation();

	/**
	 *	Set the optional String attribute HppSchemaObjImplementation.
	 *
	 *	@param	value	the String value of the attribute HppSchemaObjImplementation.
	 */
	void setOptionalHppSchemaObjImplementation( String value );

	/**
	 *	Get the optional String attribute HppDb2LUWSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppDb2LUWSchemaObjMembers.
	 */
	String getOptionalHppDb2LUWSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppDb2LUWSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppDb2LUWSchemaObjMembers.
	 */
	void setOptionalHppDb2LUWSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppDb2LUWSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute HppDb2LUWSchemaObjImpl.
	 */
	String getOptionalHppDb2LUWSchemaObjImpl();

	/**
	 *	Set the optional String attribute HppDb2LUWSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute HppDb2LUWSchemaObjImpl.
	 */
	void setOptionalHppDb2LUWSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute HppDb2LUWSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppDb2LUWSchemaObjInclude.
	 */
	String getOptionalHppDb2LUWSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppDb2LUWSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppDb2LUWSchemaObjInclude.
	 */
	void setOptionalHppDb2LUWSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppMSSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppMSSqlSchemaObjMembers.
	 */
	String getOptionalHppMSSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppMSSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppMSSqlSchemaObjMembers.
	 */
	void setOptionalHppMSSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppMSSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute HppMSSqlSchemaObjImpl.
	 */
	String getOptionalHppMSSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute HppMSSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute HppMSSqlSchemaObjImpl.
	 */
	void setOptionalHppMSSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute HppMSSqlSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppMSSqlSchemaObjInclude.
	 */
	String getOptionalHppMSSqlSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppMSSqlSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppMSSqlSchemaObjInclude.
	 */
	void setOptionalHppMSSqlSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppMySqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppMySqlSchemaObjMembers.
	 */
	String getOptionalHppMySqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppMySqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppMySqlSchemaObjMembers.
	 */
	void setOptionalHppMySqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppMySqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute HppMySqlSchemaObjImpl.
	 */
	String getOptionalHppMySqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute HppMySqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute HppMySqlSchemaObjImpl.
	 */
	void setOptionalHppMySqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute HppMySqlSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppMySqlSchemaObjInclude.
	 */
	String getOptionalHppMySqlSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppMySqlSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppMySqlSchemaObjInclude.
	 */
	void setOptionalHppMySqlSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppOracleSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppOracleSchemaObjMembers.
	 */
	String getOptionalHppOracleSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppOracleSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppOracleSchemaObjMembers.
	 */
	void setOptionalHppOracleSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppOracleSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute HppOracleSchemaObjImpl.
	 */
	String getOptionalHppOracleSchemaObjImpl();

	/**
	 *	Set the optional String attribute HppOracleSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute HppOracleSchemaObjImpl.
	 */
	void setOptionalHppOracleSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute HppOracleSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppOracleSchemaObjInclude.
	 */
	String getOptionalHppOracleSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppOracleSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppOracleSchemaObjInclude.
	 */
	void setOptionalHppOracleSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppPgSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppPgSqlSchemaObjMembers.
	 */
	String getOptionalHppPgSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppPgSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppPgSqlSchemaObjMembers.
	 */
	void setOptionalHppPgSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppPgSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute HppPgSqlSchemaObjImpl.
	 */
	String getOptionalHppPgSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute HppPgSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute HppPgSqlSchemaObjImpl.
	 */
	void setOptionalHppPgSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute HppPgSqlSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppPgSqlSchemaObjInclude.
	 */
	String getOptionalHppPgSqlSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppPgSqlSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppPgSqlSchemaObjInclude.
	 */
	void setOptionalHppPgSqlSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppRamSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute HppRamSchemaObjMembers.
	 */
	String getOptionalHppRamSchemaObjMembers();

	/**
	 *	Set the optional String attribute HppRamSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppRamSchemaObjMembers.
	 */
	void setOptionalHppRamSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute HppRamSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute HppRamSchemaObjImpl.
	 */
	String getOptionalHppRamSchemaObjImpl();

	/**
	 *	Set the optional String attribute HppRamSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute HppRamSchemaObjImpl.
	 */
	void setOptionalHppRamSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute HppRamSchemaObjInclude.
	 *
	 *	@return	The String value of the attribute HppRamSchemaObjInclude.
	 */
	String getOptionalHppRamSchemaObjInclude();

	/**
	 *	Set the optional String attribute HppRamSchemaObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppRamSchemaObjInclude.
	 */
	void setOptionalHppRamSchemaObjInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgSchemaInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgSchemaInclude.
	 */
	String getOptionalHppXMsgSchemaInclude();

	/**
	 *	Set the optional String attribute HppXMsgSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgSchemaInclude.
	 */
	void setOptionalHppXMsgSchemaInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgSchemaFormatters.
	 *
	 *	@return	The String value of the attribute HppXMsgSchemaFormatters.
	 */
	String getOptionalHppXMsgSchemaFormatters();

	/**
	 *	Set the optional String attribute HppXMsgSchemaFormatters.
	 *
	 *	@param	value	the String value of the attribute HppXMsgSchemaFormatters.
	 */
	void setOptionalHppXMsgSchemaFormatters( String value );

	/**
	 *	Get the optional String attribute HppXMsgClientSchemaInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgClientSchemaInclude.
	 */
	String getOptionalHppXMsgClientSchemaInclude();

	/**
	 *	Set the optional String attribute HppXMsgClientSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgClientSchemaInclude.
	 */
	void setOptionalHppXMsgClientSchemaInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgClientSchemaBody.
	 *
	 *	@return	The String value of the attribute HppXMsgClientSchemaBody.
	 */
	String getOptionalHppXMsgClientSchemaBody();

	/**
	 *	Set the optional String attribute HppXMsgClientSchemaBody.
	 *
	 *	@param	value	the String value of the attribute HppXMsgClientSchemaBody.
	 */
	void setOptionalHppXMsgClientSchemaBody( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaBody.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstSchemaBody.
	 */
	String getOptionalHppXMsgRqstSchemaBody();

	/**
	 *	Set the optional String attribute HppXMsgRqstSchemaBody.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstSchemaBody.
	 */
	void setOptionalHppXMsgRqstSchemaBody( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstSchemaInclude.
	 */
	String getOptionalHppXMsgRqstSchemaInclude();

	/**
	 *	Set the optional String attribute HppXMsgRqstSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstSchemaInclude.
	 */
	void setOptionalHppXMsgRqstSchemaInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstSchemaWireParsers.
	 */
	String getOptionalHppXMsgRqstSchemaWireParsers();

	/**
	 *	Set the optional String attribute HppXMsgRqstSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstSchemaWireParsers.
	 */
	void setOptionalHppXMsgRqstSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalHppXMsgRqstSchemaXsdSpec();

	/**
	 *	Set the optional String attribute HppXMsgRqstSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstSchemaXsdSpec.
	 */
	void setOptionalHppXMsgRqstSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalHppXMsgRqstSchemaXsdElementList();

	/**
	 *	Set the optional String attribute HppXMsgRqstSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstSchemaXsdElementList.
	 */
	void setOptionalHppXMsgRqstSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaBody.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnSchemaBody.
	 */
	String getOptionalHppXMsgRspnSchemaBody();

	/**
	 *	Set the optional String attribute HppXMsgRspnSchemaBody.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnSchemaBody.
	 */
	void setOptionalHppXMsgRspnSchemaBody( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnSchemaInclude.
	 */
	String getOptionalHppXMsgRspnSchemaInclude();

	/**
	 *	Set the optional String attribute HppXMsgRspnSchemaInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnSchemaInclude.
	 */
	void setOptionalHppXMsgRspnSchemaInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnSchemaWireParsers.
	 */
	String getOptionalHppXMsgRspnSchemaWireParsers();

	/**
	 *	Set the optional String attribute HppXMsgRspnSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnSchemaWireParsers.
	 */
	void setOptionalHppXMsgRspnSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalHppXMsgRspnSchemaXsdElementList();

	/**
	 *	Set the optional String attribute HppXMsgRspnSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnSchemaXsdElementList.
	 */
	void setOptionalHppXMsgRspnSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalHppXMsgRspnSchemaXsdSpec();

	/**
	 *	Set the optional String attribute HppXMsgRspnSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnSchemaXsdSpec.
	 */
	void setOptionalHppXMsgRspnSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute CsSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsSchemaObjUsing.
	 */
	String getOptionalCsSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsSchemaObjUsing.
	 */
	void setOptionalCsSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsSchemaObjInterface.
	 *
	 *	@return	The String value of the attribute CsSchemaObjInterface.
	 */
	String getOptionalCsSchemaObjInterface();

	/**
	 *	Set the optional String attribute CsSchemaObjInterface.
	 *
	 *	@param	value	the String value of the attribute CsSchemaObjInterface.
	 */
	void setOptionalCsSchemaObjInterface( String value );

	/**
	 *	Get the optional String attribute CsSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsSchemaObjMembers.
	 */
	String getOptionalCsSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsSchemaObjMembers.
	 */
	void setOptionalCsSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsSchemaObjImplementation.
	 *
	 *	@return	The String value of the attribute CsSchemaObjImplementation.
	 */
	String getOptionalCsSchemaObjImplementation();

	/**
	 *	Set the optional String attribute CsSchemaObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CsSchemaObjImplementation.
	 */
	void setOptionalCsSchemaObjImplementation( String value );

	/**
	 *	Get the optional String attribute CsDb2LUWSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsDb2LUWSchemaObjMembers.
	 */
	String getOptionalCsDb2LUWSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsDb2LUWSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsDb2LUWSchemaObjMembers.
	 */
	void setOptionalCsDb2LUWSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsDb2LUWSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CsDb2LUWSchemaObjImpl.
	 */
	String getOptionalCsDb2LUWSchemaObjImpl();

	/**
	 *	Set the optional String attribute CsDb2LUWSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CsDb2LUWSchemaObjImpl.
	 */
	void setOptionalCsDb2LUWSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CsDb2LUWSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsDb2LUWSchemaObjUsing.
	 */
	String getOptionalCsDb2LUWSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsDb2LUWSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsDb2LUWSchemaObjUsing.
	 */
	void setOptionalCsDb2LUWSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsMSSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsMSSqlSchemaObjMembers.
	 */
	String getOptionalCsMSSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsMSSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsMSSqlSchemaObjMembers.
	 */
	void setOptionalCsMSSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsMSSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CsMSSqlSchemaObjImpl.
	 */
	String getOptionalCsMSSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute CsMSSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CsMSSqlSchemaObjImpl.
	 */
	void setOptionalCsMSSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CsMSSqlSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsMSSqlSchemaObjUsing.
	 */
	String getOptionalCsMSSqlSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsMSSqlSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsMSSqlSchemaObjUsing.
	 */
	void setOptionalCsMSSqlSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsMySqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsMySqlSchemaObjMembers.
	 */
	String getOptionalCsMySqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsMySqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsMySqlSchemaObjMembers.
	 */
	void setOptionalCsMySqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsMySqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CsMySqlSchemaObjImpl.
	 */
	String getOptionalCsMySqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute CsMySqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CsMySqlSchemaObjImpl.
	 */
	void setOptionalCsMySqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CsMySqlSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsMySqlSchemaObjUsing.
	 */
	String getOptionalCsMySqlSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsMySqlSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsMySqlSchemaObjUsing.
	 */
	void setOptionalCsMySqlSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsOracleSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsOracleSchemaObjMembers.
	 */
	String getOptionalCsOracleSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsOracleSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsOracleSchemaObjMembers.
	 */
	void setOptionalCsOracleSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsOracleSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CsOracleSchemaObjImpl.
	 */
	String getOptionalCsOracleSchemaObjImpl();

	/**
	 *	Set the optional String attribute CsOracleSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CsOracleSchemaObjImpl.
	 */
	void setOptionalCsOracleSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CsOracleSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsOracleSchemaObjUsing.
	 */
	String getOptionalCsOracleSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsOracleSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsOracleSchemaObjUsing.
	 */
	void setOptionalCsOracleSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsPgSqlSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsPgSqlSchemaObjMembers.
	 */
	String getOptionalCsPgSqlSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsPgSqlSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsPgSqlSchemaObjMembers.
	 */
	void setOptionalCsPgSqlSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsPgSqlSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CsPgSqlSchemaObjImpl.
	 */
	String getOptionalCsPgSqlSchemaObjImpl();

	/**
	 *	Set the optional String attribute CsPgSqlSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CsPgSqlSchemaObjImpl.
	 */
	void setOptionalCsPgSqlSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CsPgSqlSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsPgSqlSchemaObjUsing.
	 */
	String getOptionalCsPgSqlSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsPgSqlSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsPgSqlSchemaObjUsing.
	 */
	void setOptionalCsPgSqlSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsRamSchemaObjMembers.
	 *
	 *	@return	The String value of the attribute CsRamSchemaObjMembers.
	 */
	String getOptionalCsRamSchemaObjMembers();

	/**
	 *	Set the optional String attribute CsRamSchemaObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsRamSchemaObjMembers.
	 */
	void setOptionalCsRamSchemaObjMembers( String value );

	/**
	 *	Get the optional String attribute CsRamSchemaObjImpl.
	 *
	 *	@return	The String value of the attribute CsRamSchemaObjImpl.
	 */
	String getOptionalCsRamSchemaObjImpl();

	/**
	 *	Set the optional String attribute CsRamSchemaObjImpl.
	 *
	 *	@param	value	the String value of the attribute CsRamSchemaObjImpl.
	 */
	void setOptionalCsRamSchemaObjImpl( String value );

	/**
	 *	Get the optional String attribute CsRamSchemaObjUsing.
	 *
	 *	@return	The String value of the attribute CsRamSchemaObjUsing.
	 */
	String getOptionalCsRamSchemaObjUsing();

	/**
	 *	Set the optional String attribute CsRamSchemaObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsRamSchemaObjUsing.
	 */
	void setOptionalCsRamSchemaObjUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgSchemaUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgSchemaUsing.
	 */
	String getOptionalCsXMsgSchemaUsing();

	/**
	 *	Set the optional String attribute CsXMsgSchemaUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgSchemaUsing.
	 */
	void setOptionalCsXMsgSchemaUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgSchemaFormatters.
	 *
	 *	@return	The String value of the attribute CsXMsgSchemaFormatters.
	 */
	String getOptionalCsXMsgSchemaFormatters();

	/**
	 *	Set the optional String attribute CsXMsgSchemaFormatters.
	 *
	 *	@param	value	the String value of the attribute CsXMsgSchemaFormatters.
	 */
	void setOptionalCsXMsgSchemaFormatters( String value );

	/**
	 *	Get the optional String attribute CsXMsgClientSchemaUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgClientSchemaUsing.
	 */
	String getOptionalCsXMsgClientSchemaUsing();

	/**
	 *	Set the optional String attribute CsXMsgClientSchemaUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgClientSchemaUsing.
	 */
	void setOptionalCsXMsgClientSchemaUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgClientSchemaBody.
	 *
	 *	@return	The String value of the attribute CsXMsgClientSchemaBody.
	 */
	String getOptionalCsXMsgClientSchemaBody();

	/**
	 *	Set the optional String attribute CsXMsgClientSchemaBody.
	 *
	 *	@param	value	the String value of the attribute CsXMsgClientSchemaBody.
	 */
	void setOptionalCsXMsgClientSchemaBody( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaBody.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstSchemaBody.
	 */
	String getOptionalCsXMsgRqstSchemaBody();

	/**
	 *	Set the optional String attribute CsXMsgRqstSchemaBody.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstSchemaBody.
	 */
	void setOptionalCsXMsgRqstSchemaBody( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstSchemaUsing.
	 */
	String getOptionalCsXMsgRqstSchemaUsing();

	/**
	 *	Set the optional String attribute CsXMsgRqstSchemaUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstSchemaUsing.
	 */
	void setOptionalCsXMsgRqstSchemaUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstSchemaWireParsers.
	 */
	String getOptionalCsXMsgRqstSchemaWireParsers();

	/**
	 *	Set the optional String attribute CsXMsgRqstSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstSchemaWireParsers.
	 */
	void setOptionalCsXMsgRqstSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstSchemaXsdSpec.
	 */
	String getOptionalCsXMsgRqstSchemaXsdSpec();

	/**
	 *	Set the optional String attribute CsXMsgRqstSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstSchemaXsdSpec.
	 */
	void setOptionalCsXMsgRqstSchemaXsdSpec( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstSchemaXsdElementList.
	 */
	String getOptionalCsXMsgRqstSchemaXsdElementList();

	/**
	 *	Set the optional String attribute CsXMsgRqstSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstSchemaXsdElementList.
	 */
	void setOptionalCsXMsgRqstSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaBody.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnSchemaBody.
	 */
	String getOptionalCsXMsgRspnSchemaBody();

	/**
	 *	Set the optional String attribute CsXMsgRspnSchemaBody.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnSchemaBody.
	 */
	void setOptionalCsXMsgRspnSchemaBody( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnSchemaUsing.
	 */
	String getOptionalCsXMsgRspnSchemaUsing();

	/**
	 *	Set the optional String attribute CsXMsgRspnSchemaUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnSchemaUsing.
	 */
	void setOptionalCsXMsgRspnSchemaUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaWireParsers.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnSchemaWireParsers.
	 */
	String getOptionalCsXMsgRspnSchemaWireParsers();

	/**
	 *	Set the optional String attribute CsXMsgRspnSchemaWireParsers.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnSchemaWireParsers.
	 */
	void setOptionalCsXMsgRspnSchemaWireParsers( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaXsdElementList.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnSchemaXsdElementList.
	 */
	String getOptionalCsXMsgRspnSchemaXsdElementList();

	/**
	 *	Set the optional String attribute CsXMsgRspnSchemaXsdElementList.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnSchemaXsdElementList.
	 */
	void setOptionalCsXMsgRspnSchemaXsdElementList( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnSchemaXsdSpec.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnSchemaXsdSpec.
	 */
	String getOptionalCsXMsgRspnSchemaXsdSpec();

	/**
	 *	Set the optional String attribute CsXMsgRspnSchemaXsdSpec.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnSchemaXsdSpec.
	 */
	void setOptionalCsXMsgRspnSchemaXsdSpec( String value );

	/**
	 *	Get the ICFIntMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@return	The ICFIntMinorVersionObj instance referenced by the MinorVersion key.
	 */
	ICFIntMinorVersionObj getRequiredContainerMinorVersion();

	/**
	 *	Set the ICFIntMinorVersionObj instance referenced by the MinorVersion key.
	 *
	 *	@param	value	the ICFIntMinorVersionObj instance to be referenced by the MinorVersion key.
	 */
	void setRequiredContainerMinorVersion( ICFIntMinorVersionObj value );

	/**
	 *	Get the ICFIntLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@return	The ICFIntLicenseObj instance referenced by the DefaultLicense key.
	 */
	ICFIntLicenseObj getOptionalLookupDefaultLicense();

	/**
	 *	Set the ICFIntLicenseObj instance referenced by the DefaultLicense key.
	 *
	 *	@param	value	the ICFIntLicenseObj instance to be referenced by the DefaultLicense key.
	 */
	void setOptionalLookupDefaultLicense( ICFIntLicenseObj value );

	/**
	 *	Get the ICFSecTenantObj instance referenced by the CTenant key.
	 *
	 *	@return	The ICFSecTenantObj instance referenced by the CTenant key.
	 */
	ICFSecTenantObj getRequiredOwnerCTenant();

	/**
	 *	Set the ICFSecTenantObj instance referenced by the CTenant key.
	 *
	 *	@param	value	the ICFSecTenantObj instance to be referenced by the CTenant key.
	 */
	void setRequiredOwnerCTenant( ICFSecTenantObj value );
}
