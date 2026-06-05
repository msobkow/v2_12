// Description: Java 11 Instance Edit Object interface for CFBam Table.

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

public interface ICFBamTableEditObj
	extends ICFBamTableObj,
		ICFBamScopeEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFBamTableObj.
	 */
	ICFBamTableObj getOrigAsTable();

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
	 *	Get the required boolean attribute PageData.
	 *
	 *	@return	The boolean value of the attribute PageData.
	 */
	boolean getRequiredPageData();

	/**
	 *	Set the required boolean attribute PageData.
	 *
	 *	@param	value	the boolean value of the attribute PageData.
	 */
	void setRequiredPageData( boolean value );

	/**
	 *	Get the required String attribute TableClassCode.
	 *
	 *	@return	The String value of the attribute TableClassCode.
	 */
	String getRequiredTableClassCode();

	/**
	 *	Set the required String attribute TableClassCode.
	 *
	 *	@param	value	the String value of the attribute TableClassCode.
	 */
	void setRequiredTableClassCode( String value );

	/**
	 *	Get the required boolean attribute IsInstantiable.
	 *
	 *	@return	The boolean value of the attribute IsInstantiable.
	 */
	boolean getRequiredIsInstantiable();

	/**
	 *	Set the required boolean attribute IsInstantiable.
	 *
	 *	@param	value	the boolean value of the attribute IsInstantiable.
	 */
	void setRequiredIsInstantiable( boolean value );

	/**
	 *	Get the required boolean attribute HasHistory.
	 *
	 *	@return	The boolean value of the attribute HasHistory.
	 */
	boolean getRequiredHasHistory();

	/**
	 *	Set the required boolean attribute HasHistory.
	 *
	 *	@param	value	the boolean value of the attribute HasHistory.
	 */
	void setRequiredHasHistory( boolean value );

	/**
	 *	Get the required boolean attribute HasAuditColumns.
	 *
	 *	@return	The boolean value of the attribute HasAuditColumns.
	 */
	boolean getRequiredHasAuditColumns();

	/**
	 *	Set the required boolean attribute HasAuditColumns.
	 *
	 *	@param	value	the boolean value of the attribute HasAuditColumns.
	 */
	void setRequiredHasAuditColumns( boolean value );

	/**
	 *	Get the required ICFBamSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@return	The ICFBamSchema.LoaderBehaviourEnum value of the attribute LoaderBehaviour.
	 */
	ICFBamSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour();

	/**
	 *	Set the required ICFBamSchema.LoaderBehaviourEnum attribute LoaderBehaviour.
	 *
	 *	@param	value	the ICFBamSchema.LoaderBehaviourEnum value of the attribute LoaderBehaviour.
	 */
	void setRequiredLoaderBehaviour( ICFBamSchema.LoaderBehaviourEnum value );

	/**
	 *	Get the required ICFBamSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@return	The ICFBamSchema.SecScopeEnum value of the attribute SecScope.
	 */
	ICFBamSchema.SecScopeEnum getRequiredSecScope();

	/**
	 *	Set the required ICFBamSchema.SecScopeEnum attribute SecScope.
	 *
	 *	@param	value	the ICFBamSchema.SecScopeEnum value of the attribute SecScope.
	 */
	void setRequiredSecScope( ICFBamSchema.SecScopeEnum value );

	/**
	 *	Get the optional String attribute JObjMembers.
	 *
	 *	@return	The String value of the attribute JObjMembers.
	 */
	String getOptionalJObjMembers();

	/**
	 *	Set the optional String attribute JObjMembers.
	 *
	 *	@param	value	the String value of the attribute JObjMembers.
	 */
	void setOptionalJObjMembers( String value );

	/**
	 *	Get the optional String attribute JObjInterface.
	 *
	 *	@return	The String value of the attribute JObjInterface.
	 */
	String getOptionalJObjInterface();

	/**
	 *	Set the optional String attribute JObjInterface.
	 *
	 *	@param	value	the String value of the attribute JObjInterface.
	 */
	void setOptionalJObjInterface( String value );

	/**
	 *	Get the optional String attribute JObjImport.
	 *
	 *	@return	The String value of the attribute JObjImport.
	 */
	String getOptionalJObjImport();

	/**
	 *	Set the optional String attribute JObjImport.
	 *
	 *	@param	value	the String value of the attribute JObjImport.
	 */
	void setOptionalJObjImport( String value );

	/**
	 *	Get the optional String attribute JObjImplementation.
	 *
	 *	@return	The String value of the attribute JObjImplementation.
	 */
	String getOptionalJObjImplementation();

	/**
	 *	Set the optional String attribute JObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JObjImplementation.
	 */
	void setOptionalJObjImplementation( String value );

	/**
	 *	Get the optional String attribute JEditObjMembers.
	 *
	 *	@return	The String value of the attribute JEditObjMembers.
	 */
	String getOptionalJEditObjMembers();

	/**
	 *	Set the optional String attribute JEditObjMembers.
	 *
	 *	@param	value	the String value of the attribute JEditObjMembers.
	 */
	void setOptionalJEditObjMembers( String value );

	/**
	 *	Get the optional String attribute JEditObjInterface.
	 *
	 *	@return	The String value of the attribute JEditObjInterface.
	 */
	String getOptionalJEditObjInterface();

	/**
	 *	Set the optional String attribute JEditObjInterface.
	 *
	 *	@param	value	the String value of the attribute JEditObjInterface.
	 */
	void setOptionalJEditObjInterface( String value );

	/**
	 *	Get the optional String attribute JEditObjImport.
	 *
	 *	@return	The String value of the attribute JEditObjImport.
	 */
	String getOptionalJEditObjImport();

	/**
	 *	Set the optional String attribute JEditObjImport.
	 *
	 *	@param	value	the String value of the attribute JEditObjImport.
	 */
	void setOptionalJEditObjImport( String value );

	/**
	 *	Get the optional String attribute JEditObjImplementation.
	 *
	 *	@return	The String value of the attribute JEditObjImplementation.
	 */
	String getOptionalJEditObjImplementation();

	/**
	 *	Set the optional String attribute JEditObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JEditObjImplementation.
	 */
	void setOptionalJEditObjImplementation( String value );

	/**
	 *	Get the optional String attribute JTableImport.
	 *
	 *	@return	The String value of the attribute JTableImport.
	 */
	String getOptionalJTableImport();

	/**
	 *	Set the optional String attribute JTableImport.
	 *
	 *	@param	value	the String value of the attribute JTableImport.
	 */
	void setOptionalJTableImport( String value );

	/**
	 *	Get the optional String attribute JTableMembers.
	 *
	 *	@return	The String value of the attribute JTableMembers.
	 */
	String getOptionalJTableMembers();

	/**
	 *	Set the optional String attribute JTableMembers.
	 *
	 *	@param	value	the String value of the attribute JTableMembers.
	 */
	void setOptionalJTableMembers( String value );

	/**
	 *	Get the optional String attribute JTableInterface.
	 *
	 *	@return	The String value of the attribute JTableInterface.
	 */
	String getOptionalJTableInterface();

	/**
	 *	Set the optional String attribute JTableInterface.
	 *
	 *	@param	value	the String value of the attribute JTableInterface.
	 */
	void setOptionalJTableInterface( String value );

	/**
	 *	Get the optional String attribute JTableImplementation.
	 *
	 *	@return	The String value of the attribute JTableImplementation.
	 */
	String getOptionalJTableImplementation();

	/**
	 *	Set the optional String attribute JTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JTableImplementation.
	 */
	void setOptionalJTableImplementation( String value );

	/**
	 *	Get the optional String attribute JTableObjImport.
	 *
	 *	@return	The String value of the attribute JTableObjImport.
	 */
	String getOptionalJTableObjImport();

	/**
	 *	Set the optional String attribute JTableObjImport.
	 *
	 *	@param	value	the String value of the attribute JTableObjImport.
	 */
	void setOptionalJTableObjImport( String value );

	/**
	 *	Get the optional String attribute JTableObjMembers.
	 *
	 *	@return	The String value of the attribute JTableObjMembers.
	 */
	String getOptionalJTableObjMembers();

	/**
	 *	Set the optional String attribute JTableObjMembers.
	 *
	 *	@param	value	the String value of the attribute JTableObjMembers.
	 */
	void setOptionalJTableObjMembers( String value );

	/**
	 *	Get the optional String attribute JTableObjInterface.
	 *
	 *	@return	The String value of the attribute JTableObjInterface.
	 */
	String getOptionalJTableObjInterface();

	/**
	 *	Set the optional String attribute JTableObjInterface.
	 *
	 *	@param	value	the String value of the attribute JTableObjInterface.
	 */
	void setOptionalJTableObjInterface( String value );

	/**
	 *	Get the optional String attribute JTableObjImplementation.
	 *
	 *	@return	The String value of the attribute JTableObjImplementation.
	 */
	String getOptionalJTableObjImplementation();

	/**
	 *	Set the optional String attribute JTableObjImplementation.
	 *
	 *	@param	value	the String value of the attribute JTableObjImplementation.
	 */
	void setOptionalJTableObjImplementation( String value );

	/**
	 *	Get the optional String attribute JDb2LUWTableImport.
	 *
	 *	@return	The String value of the attribute JDb2LUWTableImport.
	 */
	String getOptionalJDb2LUWTableImport();

	/**
	 *	Set the optional String attribute JDb2LUWTableImport.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWTableImport.
	 */
	void setOptionalJDb2LUWTableImport( String value );

	/**
	 *	Get the optional String attribute JDb2LUWTableMembers.
	 *
	 *	@return	The String value of the attribute JDb2LUWTableMembers.
	 */
	String getOptionalJDb2LUWTableMembers();

	/**
	 *	Set the optional String attribute JDb2LUWTableMembers.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWTableMembers.
	 */
	void setOptionalJDb2LUWTableMembers( String value );

	/**
	 *	Get the optional String attribute JDb2LUWTableImplementation.
	 *
	 *	@return	The String value of the attribute JDb2LUWTableImplementation.
	 */
	String getOptionalJDb2LUWTableImplementation();

	/**
	 *	Set the optional String attribute JDb2LUWTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JDb2LUWTableImplementation.
	 */
	void setOptionalJDb2LUWTableImplementation( String value );

	/**
	 *	Get the optional String attribute JMSSqlTableImport.
	 *
	 *	@return	The String value of the attribute JMSSqlTableImport.
	 */
	String getOptionalJMSSqlTableImport();

	/**
	 *	Set the optional String attribute JMSSqlTableImport.
	 *
	 *	@param	value	the String value of the attribute JMSSqlTableImport.
	 */
	void setOptionalJMSSqlTableImport( String value );

	/**
	 *	Get the optional String attribute JMSSqlTableMembers.
	 *
	 *	@return	The String value of the attribute JMSSqlTableMembers.
	 */
	String getOptionalJMSSqlTableMembers();

	/**
	 *	Set the optional String attribute JMSSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute JMSSqlTableMembers.
	 */
	void setOptionalJMSSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute JMSSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute JMSSqlTableImplementation.
	 */
	String getOptionalJMSSqlTableImplementation();

	/**
	 *	Set the optional String attribute JMSSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JMSSqlTableImplementation.
	 */
	void setOptionalJMSSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute JMySqlTableImport.
	 *
	 *	@return	The String value of the attribute JMySqlTableImport.
	 */
	String getOptionalJMySqlTableImport();

	/**
	 *	Set the optional String attribute JMySqlTableImport.
	 *
	 *	@param	value	the String value of the attribute JMySqlTableImport.
	 */
	void setOptionalJMySqlTableImport( String value );

	/**
	 *	Get the optional String attribute JMySqlTableMembers.
	 *
	 *	@return	The String value of the attribute JMySqlTableMembers.
	 */
	String getOptionalJMySqlTableMembers();

	/**
	 *	Set the optional String attribute JMySqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute JMySqlTableMembers.
	 */
	void setOptionalJMySqlTableMembers( String value );

	/**
	 *	Get the optional String attribute JMySqlTableImplementation.
	 *
	 *	@return	The String value of the attribute JMySqlTableImplementation.
	 */
	String getOptionalJMySqlTableImplementation();

	/**
	 *	Set the optional String attribute JMySqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JMySqlTableImplementation.
	 */
	void setOptionalJMySqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute JOracleTableImport.
	 *
	 *	@return	The String value of the attribute JOracleTableImport.
	 */
	String getOptionalJOracleTableImport();

	/**
	 *	Set the optional String attribute JOracleTableImport.
	 *
	 *	@param	value	the String value of the attribute JOracleTableImport.
	 */
	void setOptionalJOracleTableImport( String value );

	/**
	 *	Get the optional String attribute JOracleTableMembers.
	 *
	 *	@return	The String value of the attribute JOracleTableMembers.
	 */
	String getOptionalJOracleTableMembers();

	/**
	 *	Set the optional String attribute JOracleTableMembers.
	 *
	 *	@param	value	the String value of the attribute JOracleTableMembers.
	 */
	void setOptionalJOracleTableMembers( String value );

	/**
	 *	Get the optional String attribute JOracleTableImplementation.
	 *
	 *	@return	The String value of the attribute JOracleTableImplementation.
	 */
	String getOptionalJOracleTableImplementation();

	/**
	 *	Set the optional String attribute JOracleTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JOracleTableImplementation.
	 */
	void setOptionalJOracleTableImplementation( String value );

	/**
	 *	Get the optional String attribute JPgSqlTableImport.
	 *
	 *	@return	The String value of the attribute JPgSqlTableImport.
	 */
	String getOptionalJPgSqlTableImport();

	/**
	 *	Set the optional String attribute JPgSqlTableImport.
	 *
	 *	@param	value	the String value of the attribute JPgSqlTableImport.
	 */
	void setOptionalJPgSqlTableImport( String value );

	/**
	 *	Get the optional String attribute JPgSqlTableMembers.
	 *
	 *	@return	The String value of the attribute JPgSqlTableMembers.
	 */
	String getOptionalJPgSqlTableMembers();

	/**
	 *	Set the optional String attribute JPgSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute JPgSqlTableMembers.
	 */
	void setOptionalJPgSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute JPgSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute JPgSqlTableImplementation.
	 */
	String getOptionalJPgSqlTableImplementation();

	/**
	 *	Set the optional String attribute JPgSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JPgSqlTableImplementation.
	 */
	void setOptionalJPgSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute JRamTableImport.
	 *
	 *	@return	The String value of the attribute JRamTableImport.
	 */
	String getOptionalJRamTableImport();

	/**
	 *	Set the optional String attribute JRamTableImport.
	 *
	 *	@param	value	the String value of the attribute JRamTableImport.
	 */
	void setOptionalJRamTableImport( String value );

	/**
	 *	Get the optional String attribute JRamTableMembers.
	 *
	 *	@return	The String value of the attribute JRamTableMembers.
	 */
	String getOptionalJRamTableMembers();

	/**
	 *	Set the optional String attribute JRamTableMembers.
	 *
	 *	@param	value	the String value of the attribute JRamTableMembers.
	 */
	void setOptionalJRamTableMembers( String value );

	/**
	 *	Get the optional String attribute JRamTableImplementation.
	 *
	 *	@return	The String value of the attribute JRamTableImplementation.
	 */
	String getOptionalJRamTableImplementation();

	/**
	 *	Set the optional String attribute JRamTableImplementation.
	 *
	 *	@param	value	the String value of the attribute JRamTableImplementation.
	 */
	void setOptionalJRamTableImplementation( String value );

	/**
	 *	Get the optional String attribute JSaxLoaderImport.
	 *
	 *	@return	The String value of the attribute JSaxLoaderImport.
	 */
	String getOptionalJSaxLoaderImport();

	/**
	 *	Set the optional String attribute JSaxLoaderImport.
	 *
	 *	@param	value	the String value of the attribute JSaxLoaderImport.
	 */
	void setOptionalJSaxLoaderImport( String value );

	/**
	 *	Get the optional String attribute JSaxLoaderStartElement.
	 *
	 *	@return	The String value of the attribute JSaxLoaderStartElement.
	 */
	String getOptionalJSaxLoaderStartElement();

	/**
	 *	Set the optional String attribute JSaxLoaderStartElement.
	 *
	 *	@param	value	the String value of the attribute JSaxLoaderStartElement.
	 */
	void setOptionalJSaxLoaderStartElement( String value );

	/**
	 *	Get the optional String attribute JSaxLoaderEndElement.
	 *
	 *	@return	The String value of the attribute JSaxLoaderEndElement.
	 */
	String getOptionalJSaxLoaderEndElement();

	/**
	 *	Set the optional String attribute JSaxLoaderEndElement.
	 *
	 *	@param	value	the String value of the attribute JSaxLoaderEndElement.
	 */
	void setOptionalJSaxLoaderEndElement( String value );

	/**
	 *	Get the optional String attribute JXMsgTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgTableImport.
	 */
	String getOptionalJXMsgTableImport();

	/**
	 *	Set the optional String attribute JXMsgTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgTableImport.
	 */
	void setOptionalJXMsgTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgTableFormatters.
	 *
	 *	@return	The String value of the attribute JXMsgTableFormatters.
	 */
	String getOptionalJXMsgTableFormatters();

	/**
	 *	Set the optional String attribute JXMsgTableFormatters.
	 *
	 *	@param	value	the String value of the attribute JXMsgTableFormatters.
	 */
	void setOptionalJXMsgTableFormatters( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgRqstTableImport.
	 */
	String getOptionalJXMsgRqstTableImport();

	/**
	 *	Set the optional String attribute JXMsgRqstTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstTableImport.
	 */
	void setOptionalJXMsgRqstTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgRspnTableImport.
	 */
	String getOptionalJXMsgRspnTableImport();

	/**
	 *	Set the optional String attribute JXMsgRspnTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnTableImport.
	 */
	void setOptionalJXMsgRspnTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgClientTableImport.
	 *
	 *	@return	The String value of the attribute JXMsgClientTableImport.
	 */
	String getOptionalJXMsgClientTableImport();

	/**
	 *	Set the optional String attribute JXMsgClientTableImport.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientTableImport.
	 */
	void setOptionalJXMsgClientTableImport( String value );

	/**
	 *	Get the optional String attribute JXMsgRqstTableBody.
	 *
	 *	@return	The String value of the attribute JXMsgRqstTableBody.
	 */
	String getOptionalJXMsgRqstTableBody();

	/**
	 *	Set the optional String attribute JXMsgRqstTableBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRqstTableBody.
	 */
	void setOptionalJXMsgRqstTableBody( String value );

	/**
	 *	Get the optional String attribute JXMsgRspnTableBody.
	 *
	 *	@return	The String value of the attribute JXMsgRspnTableBody.
	 */
	String getOptionalJXMsgRspnTableBody();

	/**
	 *	Set the optional String attribute JXMsgRspnTableBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgRspnTableBody.
	 */
	void setOptionalJXMsgRspnTableBody( String value );

	/**
	 *	Get the optional String attribute JXMsgClientTableBody.
	 *
	 *	@return	The String value of the attribute JXMsgClientTableBody.
	 */
	String getOptionalJXMsgClientTableBody();

	/**
	 *	Set the optional String attribute JXMsgClientTableBody.
	 *
	 *	@param	value	the String value of the attribute JXMsgClientTableBody.
	 */
	void setOptionalJXMsgClientTableBody( String value );

	/**
	 *	Get the optional String attribute CppObjMembers.
	 *
	 *	@return	The String value of the attribute CppObjMembers.
	 */
	String getOptionalCppObjMembers();

	/**
	 *	Set the optional String attribute CppObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppObjMembers.
	 */
	void setOptionalCppObjMembers( String value );

	/**
	 *	Get the optional String attribute CppObjInterface.
	 *
	 *	@return	The String value of the attribute CppObjInterface.
	 */
	String getOptionalCppObjInterface();

	/**
	 *	Set the optional String attribute CppObjInterface.
	 *
	 *	@param	value	the String value of the attribute CppObjInterface.
	 */
	void setOptionalCppObjInterface( String value );

	/**
	 *	Get the optional String attribute CppObjInclude.
	 *
	 *	@return	The String value of the attribute CppObjInclude.
	 */
	String getOptionalCppObjInclude();

	/**
	 *	Set the optional String attribute CppObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppObjInclude.
	 */
	void setOptionalCppObjInclude( String value );

	/**
	 *	Get the optional String attribute CppObjImplementation.
	 *
	 *	@return	The String value of the attribute CppObjImplementation.
	 */
	String getOptionalCppObjImplementation();

	/**
	 *	Set the optional String attribute CppObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CppObjImplementation.
	 */
	void setOptionalCppObjImplementation( String value );

	/**
	 *	Get the optional String attribute CppEditObjMembers.
	 *
	 *	@return	The String value of the attribute CppEditObjMembers.
	 */
	String getOptionalCppEditObjMembers();

	/**
	 *	Set the optional String attribute CppEditObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppEditObjMembers.
	 */
	void setOptionalCppEditObjMembers( String value );

	/**
	 *	Get the optional String attribute CppEditObjInterface.
	 *
	 *	@return	The String value of the attribute CppEditObjInterface.
	 */
	String getOptionalCppEditObjInterface();

	/**
	 *	Set the optional String attribute CppEditObjInterface.
	 *
	 *	@param	value	the String value of the attribute CppEditObjInterface.
	 */
	void setOptionalCppEditObjInterface( String value );

	/**
	 *	Get the optional String attribute CppEditObjInclude.
	 *
	 *	@return	The String value of the attribute CppEditObjInclude.
	 */
	String getOptionalCppEditObjInclude();

	/**
	 *	Set the optional String attribute CppEditObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppEditObjInclude.
	 */
	void setOptionalCppEditObjInclude( String value );

	/**
	 *	Get the optional String attribute CppEditObjImplementation.
	 *
	 *	@return	The String value of the attribute CppEditObjImplementation.
	 */
	String getOptionalCppEditObjImplementation();

	/**
	 *	Set the optional String attribute CppEditObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CppEditObjImplementation.
	 */
	void setOptionalCppEditObjImplementation( String value );

	/**
	 *	Get the optional String attribute CppTableInclude.
	 *
	 *	@return	The String value of the attribute CppTableInclude.
	 */
	String getOptionalCppTableInclude();

	/**
	 *	Set the optional String attribute CppTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppTableInclude.
	 */
	void setOptionalCppTableInclude( String value );

	/**
	 *	Get the optional String attribute CppTableMembers.
	 *
	 *	@return	The String value of the attribute CppTableMembers.
	 */
	String getOptionalCppTableMembers();

	/**
	 *	Set the optional String attribute CppTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppTableMembers.
	 */
	void setOptionalCppTableMembers( String value );

	/**
	 *	Get the optional String attribute CppTableInterface.
	 *
	 *	@return	The String value of the attribute CppTableInterface.
	 */
	String getOptionalCppTableInterface();

	/**
	 *	Set the optional String attribute CppTableInterface.
	 *
	 *	@param	value	the String value of the attribute CppTableInterface.
	 */
	void setOptionalCppTableInterface( String value );

	/**
	 *	Get the optional String attribute CppTableImplementation.
	 *
	 *	@return	The String value of the attribute CppTableImplementation.
	 */
	String getOptionalCppTableImplementation();

	/**
	 *	Set the optional String attribute CppTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppTableImplementation.
	 */
	void setOptionalCppTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppTableObjInclude.
	 *
	 *	@return	The String value of the attribute CppTableObjInclude.
	 */
	String getOptionalCppTableObjInclude();

	/**
	 *	Set the optional String attribute CppTableObjInclude.
	 *
	 *	@param	value	the String value of the attribute CppTableObjInclude.
	 */
	void setOptionalCppTableObjInclude( String value );

	/**
	 *	Get the optional String attribute CppTableObjMembers.
	 *
	 *	@return	The String value of the attribute CppTableObjMembers.
	 */
	String getOptionalCppTableObjMembers();

	/**
	 *	Set the optional String attribute CppTableObjMembers.
	 *
	 *	@param	value	the String value of the attribute CppTableObjMembers.
	 */
	void setOptionalCppTableObjMembers( String value );

	/**
	 *	Get the optional String attribute CppTableObjInterface.
	 *
	 *	@return	The String value of the attribute CppTableObjInterface.
	 */
	String getOptionalCppTableObjInterface();

	/**
	 *	Set the optional String attribute CppTableObjInterface.
	 *
	 *	@param	value	the String value of the attribute CppTableObjInterface.
	 */
	void setOptionalCppTableObjInterface( String value );

	/**
	 *	Get the optional String attribute CppTableObjImplementation.
	 *
	 *	@return	The String value of the attribute CppTableObjImplementation.
	 */
	String getOptionalCppTableObjImplementation();

	/**
	 *	Set the optional String attribute CppTableObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CppTableObjImplementation.
	 */
	void setOptionalCppTableObjImplementation( String value );

	/**
	 *	Get the optional String attribute CppDb2LUWTableInclude.
	 *
	 *	@return	The String value of the attribute CppDb2LUWTableInclude.
	 */
	String getOptionalCppDb2LUWTableInclude();

	/**
	 *	Set the optional String attribute CppDb2LUWTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppDb2LUWTableInclude.
	 */
	void setOptionalCppDb2LUWTableInclude( String value );

	/**
	 *	Get the optional String attribute CppDb2LUWTableMembers.
	 *
	 *	@return	The String value of the attribute CppDb2LUWTableMembers.
	 */
	String getOptionalCppDb2LUWTableMembers();

	/**
	 *	Set the optional String attribute CppDb2LUWTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppDb2LUWTableMembers.
	 */
	void setOptionalCppDb2LUWTableMembers( String value );

	/**
	 *	Get the optional String attribute CppDb2LUWTableImplementation.
	 *
	 *	@return	The String value of the attribute CppDb2LUWTableImplementation.
	 */
	String getOptionalCppDb2LUWTableImplementation();

	/**
	 *	Set the optional String attribute CppDb2LUWTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppDb2LUWTableImplementation.
	 */
	void setOptionalCppDb2LUWTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppMSSqlTableInclude.
	 *
	 *	@return	The String value of the attribute CppMSSqlTableInclude.
	 */
	String getOptionalCppMSSqlTableInclude();

	/**
	 *	Set the optional String attribute CppMSSqlTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppMSSqlTableInclude.
	 */
	void setOptionalCppMSSqlTableInclude( String value );

	/**
	 *	Get the optional String attribute CppMSSqlTableMembers.
	 *
	 *	@return	The String value of the attribute CppMSSqlTableMembers.
	 */
	String getOptionalCppMSSqlTableMembers();

	/**
	 *	Set the optional String attribute CppMSSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppMSSqlTableMembers.
	 */
	void setOptionalCppMSSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute CppMSSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute CppMSSqlTableImplementation.
	 */
	String getOptionalCppMSSqlTableImplementation();

	/**
	 *	Set the optional String attribute CppMSSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppMSSqlTableImplementation.
	 */
	void setOptionalCppMSSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppMySqlTableInclude.
	 *
	 *	@return	The String value of the attribute CppMySqlTableInclude.
	 */
	String getOptionalCppMySqlTableInclude();

	/**
	 *	Set the optional String attribute CppMySqlTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppMySqlTableInclude.
	 */
	void setOptionalCppMySqlTableInclude( String value );

	/**
	 *	Get the optional String attribute CppMySqlTableMembers.
	 *
	 *	@return	The String value of the attribute CppMySqlTableMembers.
	 */
	String getOptionalCppMySqlTableMembers();

	/**
	 *	Set the optional String attribute CppMySqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppMySqlTableMembers.
	 */
	void setOptionalCppMySqlTableMembers( String value );

	/**
	 *	Get the optional String attribute CppMySqlTableImplementation.
	 *
	 *	@return	The String value of the attribute CppMySqlTableImplementation.
	 */
	String getOptionalCppMySqlTableImplementation();

	/**
	 *	Set the optional String attribute CppMySqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppMySqlTableImplementation.
	 */
	void setOptionalCppMySqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppOracleTableInclude.
	 *
	 *	@return	The String value of the attribute CppOracleTableInclude.
	 */
	String getOptionalCppOracleTableInclude();

	/**
	 *	Set the optional String attribute CppOracleTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppOracleTableInclude.
	 */
	void setOptionalCppOracleTableInclude( String value );

	/**
	 *	Get the optional String attribute CppOracleTableMembers.
	 *
	 *	@return	The String value of the attribute CppOracleTableMembers.
	 */
	String getOptionalCppOracleTableMembers();

	/**
	 *	Set the optional String attribute CppOracleTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppOracleTableMembers.
	 */
	void setOptionalCppOracleTableMembers( String value );

	/**
	 *	Get the optional String attribute CppOracleTableImplementation.
	 *
	 *	@return	The String value of the attribute CppOracleTableImplementation.
	 */
	String getOptionalCppOracleTableImplementation();

	/**
	 *	Set the optional String attribute CppOracleTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppOracleTableImplementation.
	 */
	void setOptionalCppOracleTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppPgSqlTableInclude.
	 *
	 *	@return	The String value of the attribute CppPgSqlTableInclude.
	 */
	String getOptionalCppPgSqlTableInclude();

	/**
	 *	Set the optional String attribute CppPgSqlTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppPgSqlTableInclude.
	 */
	void setOptionalCppPgSqlTableInclude( String value );

	/**
	 *	Get the optional String attribute CppPgSqlTableMembers.
	 *
	 *	@return	The String value of the attribute CppPgSqlTableMembers.
	 */
	String getOptionalCppPgSqlTableMembers();

	/**
	 *	Set the optional String attribute CppPgSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppPgSqlTableMembers.
	 */
	void setOptionalCppPgSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute CppPgSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute CppPgSqlTableImplementation.
	 */
	String getOptionalCppPgSqlTableImplementation();

	/**
	 *	Set the optional String attribute CppPgSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppPgSqlTableImplementation.
	 */
	void setOptionalCppPgSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppRamTableInclude.
	 *
	 *	@return	The String value of the attribute CppRamTableInclude.
	 */
	String getOptionalCppRamTableInclude();

	/**
	 *	Set the optional String attribute CppRamTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppRamTableInclude.
	 */
	void setOptionalCppRamTableInclude( String value );

	/**
	 *	Get the optional String attribute CppRamTableMembers.
	 *
	 *	@return	The String value of the attribute CppRamTableMembers.
	 */
	String getOptionalCppRamTableMembers();

	/**
	 *	Set the optional String attribute CppRamTableMembers.
	 *
	 *	@param	value	the String value of the attribute CppRamTableMembers.
	 */
	void setOptionalCppRamTableMembers( String value );

	/**
	 *	Get the optional String attribute CppRamTableImplementation.
	 *
	 *	@return	The String value of the attribute CppRamTableImplementation.
	 */
	String getOptionalCppRamTableImplementation();

	/**
	 *	Set the optional String attribute CppRamTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CppRamTableImplementation.
	 */
	void setOptionalCppRamTableImplementation( String value );

	/**
	 *	Get the optional String attribute CppSaxLoaderInclude.
	 *
	 *	@return	The String value of the attribute CppSaxLoaderInclude.
	 */
	String getOptionalCppSaxLoaderInclude();

	/**
	 *	Set the optional String attribute CppSaxLoaderInclude.
	 *
	 *	@param	value	the String value of the attribute CppSaxLoaderInclude.
	 */
	void setOptionalCppSaxLoaderInclude( String value );

	/**
	 *	Get the optional String attribute CppSaxLoaderStartElement.
	 *
	 *	@return	The String value of the attribute CppSaxLoaderStartElement.
	 */
	String getOptionalCppSaxLoaderStartElement();

	/**
	 *	Set the optional String attribute CppSaxLoaderStartElement.
	 *
	 *	@param	value	the String value of the attribute CppSaxLoaderStartElement.
	 */
	void setOptionalCppSaxLoaderStartElement( String value );

	/**
	 *	Get the optional String attribute CppSaxLoaderEndElement.
	 *
	 *	@return	The String value of the attribute CppSaxLoaderEndElement.
	 */
	String getOptionalCppSaxLoaderEndElement();

	/**
	 *	Set the optional String attribute CppSaxLoaderEndElement.
	 *
	 *	@param	value	the String value of the attribute CppSaxLoaderEndElement.
	 */
	void setOptionalCppSaxLoaderEndElement( String value );

	/**
	 *	Get the optional String attribute CppXMsgTableInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgTableInclude.
	 */
	String getOptionalCppXMsgTableInclude();

	/**
	 *	Set the optional String attribute CppXMsgTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgTableInclude.
	 */
	void setOptionalCppXMsgTableInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgTableFormatters.
	 *
	 *	@return	The String value of the attribute CppXMsgTableFormatters.
	 */
	String getOptionalCppXMsgTableFormatters();

	/**
	 *	Set the optional String attribute CppXMsgTableFormatters.
	 *
	 *	@param	value	the String value of the attribute CppXMsgTableFormatters.
	 */
	void setOptionalCppXMsgTableFormatters( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstTableInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstTableInclude.
	 */
	String getOptionalCppXMsgRqstTableInclude();

	/**
	 *	Set the optional String attribute CppXMsgRqstTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstTableInclude.
	 */
	void setOptionalCppXMsgRqstTableInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnTableInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnTableInclude.
	 */
	String getOptionalCppXMsgRspnTableInclude();

	/**
	 *	Set the optional String attribute CppXMsgRspnTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnTableInclude.
	 */
	void setOptionalCppXMsgRspnTableInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgClientTableInclude.
	 *
	 *	@return	The String value of the attribute CppXMsgClientTableInclude.
	 */
	String getOptionalCppXMsgClientTableInclude();

	/**
	 *	Set the optional String attribute CppXMsgClientTableInclude.
	 *
	 *	@param	value	the String value of the attribute CppXMsgClientTableInclude.
	 */
	void setOptionalCppXMsgClientTableInclude( String value );

	/**
	 *	Get the optional String attribute CppXMsgRqstTableBody.
	 *
	 *	@return	The String value of the attribute CppXMsgRqstTableBody.
	 */
	String getOptionalCppXMsgRqstTableBody();

	/**
	 *	Set the optional String attribute CppXMsgRqstTableBody.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRqstTableBody.
	 */
	void setOptionalCppXMsgRqstTableBody( String value );

	/**
	 *	Get the optional String attribute CppXMsgRspnTableBody.
	 *
	 *	@return	The String value of the attribute CppXMsgRspnTableBody.
	 */
	String getOptionalCppXMsgRspnTableBody();

	/**
	 *	Set the optional String attribute CppXMsgRspnTableBody.
	 *
	 *	@param	value	the String value of the attribute CppXMsgRspnTableBody.
	 */
	void setOptionalCppXMsgRspnTableBody( String value );

	/**
	 *	Get the optional String attribute CppXMsgClientTableBody.
	 *
	 *	@return	The String value of the attribute CppXMsgClientTableBody.
	 */
	String getOptionalCppXMsgClientTableBody();

	/**
	 *	Set the optional String attribute CppXMsgClientTableBody.
	 *
	 *	@param	value	the String value of the attribute CppXMsgClientTableBody.
	 */
	void setOptionalCppXMsgClientTableBody( String value );

	/**
	 *	Get the optional String attribute HppObjMembers.
	 *
	 *	@return	The String value of the attribute HppObjMembers.
	 */
	String getOptionalHppObjMembers();

	/**
	 *	Set the optional String attribute HppObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppObjMembers.
	 */
	void setOptionalHppObjMembers( String value );

	/**
	 *	Get the optional String attribute HppObjInterface.
	 *
	 *	@return	The String value of the attribute HppObjInterface.
	 */
	String getOptionalHppObjInterface();

	/**
	 *	Set the optional String attribute HppObjInterface.
	 *
	 *	@param	value	the String value of the attribute HppObjInterface.
	 */
	void setOptionalHppObjInterface( String value );

	/**
	 *	Get the optional String attribute HppObjInclude.
	 *
	 *	@return	The String value of the attribute HppObjInclude.
	 */
	String getOptionalHppObjInclude();

	/**
	 *	Set the optional String attribute HppObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppObjInclude.
	 */
	void setOptionalHppObjInclude( String value );

	/**
	 *	Get the optional String attribute HppObjImplementation.
	 *
	 *	@return	The String value of the attribute HppObjImplementation.
	 */
	String getOptionalHppObjImplementation();

	/**
	 *	Set the optional String attribute HppObjImplementation.
	 *
	 *	@param	value	the String value of the attribute HppObjImplementation.
	 */
	void setOptionalHppObjImplementation( String value );

	/**
	 *	Get the optional String attribute HppEditObjMembers.
	 *
	 *	@return	The String value of the attribute HppEditObjMembers.
	 */
	String getOptionalHppEditObjMembers();

	/**
	 *	Set the optional String attribute HppEditObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppEditObjMembers.
	 */
	void setOptionalHppEditObjMembers( String value );

	/**
	 *	Get the optional String attribute HppEditObjInterface.
	 *
	 *	@return	The String value of the attribute HppEditObjInterface.
	 */
	String getOptionalHppEditObjInterface();

	/**
	 *	Set the optional String attribute HppEditObjInterface.
	 *
	 *	@param	value	the String value of the attribute HppEditObjInterface.
	 */
	void setOptionalHppEditObjInterface( String value );

	/**
	 *	Get the optional String attribute HppEditObjInclude.
	 *
	 *	@return	The String value of the attribute HppEditObjInclude.
	 */
	String getOptionalHppEditObjInclude();

	/**
	 *	Set the optional String attribute HppEditObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppEditObjInclude.
	 */
	void setOptionalHppEditObjInclude( String value );

	/**
	 *	Get the optional String attribute HppEditObjImplementation.
	 *
	 *	@return	The String value of the attribute HppEditObjImplementation.
	 */
	String getOptionalHppEditObjImplementation();

	/**
	 *	Set the optional String attribute HppEditObjImplementation.
	 *
	 *	@param	value	the String value of the attribute HppEditObjImplementation.
	 */
	void setOptionalHppEditObjImplementation( String value );

	/**
	 *	Get the optional String attribute HppTableInclude.
	 *
	 *	@return	The String value of the attribute HppTableInclude.
	 */
	String getOptionalHppTableInclude();

	/**
	 *	Set the optional String attribute HppTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppTableInclude.
	 */
	void setOptionalHppTableInclude( String value );

	/**
	 *	Get the optional String attribute HppTableMembers.
	 *
	 *	@return	The String value of the attribute HppTableMembers.
	 */
	String getOptionalHppTableMembers();

	/**
	 *	Set the optional String attribute HppTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppTableMembers.
	 */
	void setOptionalHppTableMembers( String value );

	/**
	 *	Get the optional String attribute HppTableInterface.
	 *
	 *	@return	The String value of the attribute HppTableInterface.
	 */
	String getOptionalHppTableInterface();

	/**
	 *	Set the optional String attribute HppTableInterface.
	 *
	 *	@param	value	the String value of the attribute HppTableInterface.
	 */
	void setOptionalHppTableInterface( String value );

	/**
	 *	Get the optional String attribute HppTableImplementation.
	 *
	 *	@return	The String value of the attribute HppTableImplementation.
	 */
	String getOptionalHppTableImplementation();

	/**
	 *	Set the optional String attribute HppTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppTableImplementation.
	 */
	void setOptionalHppTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppTableObjInclude.
	 *
	 *	@return	The String value of the attribute HppTableObjInclude.
	 */
	String getOptionalHppTableObjInclude();

	/**
	 *	Set the optional String attribute HppTableObjInclude.
	 *
	 *	@param	value	the String value of the attribute HppTableObjInclude.
	 */
	void setOptionalHppTableObjInclude( String value );

	/**
	 *	Get the optional String attribute HppTableObjMembers.
	 *
	 *	@return	The String value of the attribute HppTableObjMembers.
	 */
	String getOptionalHppTableObjMembers();

	/**
	 *	Set the optional String attribute HppTableObjMembers.
	 *
	 *	@param	value	the String value of the attribute HppTableObjMembers.
	 */
	void setOptionalHppTableObjMembers( String value );

	/**
	 *	Get the optional String attribute HppTableObjInterface.
	 *
	 *	@return	The String value of the attribute HppTableObjInterface.
	 */
	String getOptionalHppTableObjInterface();

	/**
	 *	Set the optional String attribute HppTableObjInterface.
	 *
	 *	@param	value	the String value of the attribute HppTableObjInterface.
	 */
	void setOptionalHppTableObjInterface( String value );

	/**
	 *	Get the optional String attribute HppTableObjImplementation.
	 *
	 *	@return	The String value of the attribute HppTableObjImplementation.
	 */
	String getOptionalHppTableObjImplementation();

	/**
	 *	Set the optional String attribute HppTableObjImplementation.
	 *
	 *	@param	value	the String value of the attribute HppTableObjImplementation.
	 */
	void setOptionalHppTableObjImplementation( String value );

	/**
	 *	Get the optional String attribute HppDb2LUWTableInclude.
	 *
	 *	@return	The String value of the attribute HppDb2LUWTableInclude.
	 */
	String getOptionalHppDb2LUWTableInclude();

	/**
	 *	Set the optional String attribute HppDb2LUWTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppDb2LUWTableInclude.
	 */
	void setOptionalHppDb2LUWTableInclude( String value );

	/**
	 *	Get the optional String attribute HppDb2LUWTableMembers.
	 *
	 *	@return	The String value of the attribute HppDb2LUWTableMembers.
	 */
	String getOptionalHppDb2LUWTableMembers();

	/**
	 *	Set the optional String attribute HppDb2LUWTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppDb2LUWTableMembers.
	 */
	void setOptionalHppDb2LUWTableMembers( String value );

	/**
	 *	Get the optional String attribute HppDb2LUWTableImplementation.
	 *
	 *	@return	The String value of the attribute HppDb2LUWTableImplementation.
	 */
	String getOptionalHppDb2LUWTableImplementation();

	/**
	 *	Set the optional String attribute HppDb2LUWTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppDb2LUWTableImplementation.
	 */
	void setOptionalHppDb2LUWTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppMSSqlTableInclude.
	 *
	 *	@return	The String value of the attribute HppMSSqlTableInclude.
	 */
	String getOptionalHppMSSqlTableInclude();

	/**
	 *	Set the optional String attribute HppMSSqlTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppMSSqlTableInclude.
	 */
	void setOptionalHppMSSqlTableInclude( String value );

	/**
	 *	Get the optional String attribute HppMSSqlTableMembers.
	 *
	 *	@return	The String value of the attribute HppMSSqlTableMembers.
	 */
	String getOptionalHppMSSqlTableMembers();

	/**
	 *	Set the optional String attribute HppMSSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppMSSqlTableMembers.
	 */
	void setOptionalHppMSSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute HppMSSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute HppMSSqlTableImplementation.
	 */
	String getOptionalHppMSSqlTableImplementation();

	/**
	 *	Set the optional String attribute HppMSSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppMSSqlTableImplementation.
	 */
	void setOptionalHppMSSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppMySqlTableInclude.
	 *
	 *	@return	The String value of the attribute HppMySqlTableInclude.
	 */
	String getOptionalHppMySqlTableInclude();

	/**
	 *	Set the optional String attribute HppMySqlTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppMySqlTableInclude.
	 */
	void setOptionalHppMySqlTableInclude( String value );

	/**
	 *	Get the optional String attribute HppMySqlTableMembers.
	 *
	 *	@return	The String value of the attribute HppMySqlTableMembers.
	 */
	String getOptionalHppMySqlTableMembers();

	/**
	 *	Set the optional String attribute HppMySqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppMySqlTableMembers.
	 */
	void setOptionalHppMySqlTableMembers( String value );

	/**
	 *	Get the optional String attribute HppMySqlTableImplementation.
	 *
	 *	@return	The String value of the attribute HppMySqlTableImplementation.
	 */
	String getOptionalHppMySqlTableImplementation();

	/**
	 *	Set the optional String attribute HppMySqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppMySqlTableImplementation.
	 */
	void setOptionalHppMySqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppOracleTableInclude.
	 *
	 *	@return	The String value of the attribute HppOracleTableInclude.
	 */
	String getOptionalHppOracleTableInclude();

	/**
	 *	Set the optional String attribute HppOracleTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppOracleTableInclude.
	 */
	void setOptionalHppOracleTableInclude( String value );

	/**
	 *	Get the optional String attribute HppOracleTableMembers.
	 *
	 *	@return	The String value of the attribute HppOracleTableMembers.
	 */
	String getOptionalHppOracleTableMembers();

	/**
	 *	Set the optional String attribute HppOracleTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppOracleTableMembers.
	 */
	void setOptionalHppOracleTableMembers( String value );

	/**
	 *	Get the optional String attribute HppOracleTableImplementation.
	 *
	 *	@return	The String value of the attribute HppOracleTableImplementation.
	 */
	String getOptionalHppOracleTableImplementation();

	/**
	 *	Set the optional String attribute HppOracleTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppOracleTableImplementation.
	 */
	void setOptionalHppOracleTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppPgSqlTableInclude.
	 *
	 *	@return	The String value of the attribute HppPgSqlTableInclude.
	 */
	String getOptionalHppPgSqlTableInclude();

	/**
	 *	Set the optional String attribute HppPgSqlTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppPgSqlTableInclude.
	 */
	void setOptionalHppPgSqlTableInclude( String value );

	/**
	 *	Get the optional String attribute HppPgSqlTableMembers.
	 *
	 *	@return	The String value of the attribute HppPgSqlTableMembers.
	 */
	String getOptionalHppPgSqlTableMembers();

	/**
	 *	Set the optional String attribute HppPgSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppPgSqlTableMembers.
	 */
	void setOptionalHppPgSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute HppPgSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute HppPgSqlTableImplementation.
	 */
	String getOptionalHppPgSqlTableImplementation();

	/**
	 *	Set the optional String attribute HppPgSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppPgSqlTableImplementation.
	 */
	void setOptionalHppPgSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppRamTableInclude.
	 *
	 *	@return	The String value of the attribute HppRamTableInclude.
	 */
	String getOptionalHppRamTableInclude();

	/**
	 *	Set the optional String attribute HppRamTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppRamTableInclude.
	 */
	void setOptionalHppRamTableInclude( String value );

	/**
	 *	Get the optional String attribute HppRamTableMembers.
	 *
	 *	@return	The String value of the attribute HppRamTableMembers.
	 */
	String getOptionalHppRamTableMembers();

	/**
	 *	Set the optional String attribute HppRamTableMembers.
	 *
	 *	@param	value	the String value of the attribute HppRamTableMembers.
	 */
	void setOptionalHppRamTableMembers( String value );

	/**
	 *	Get the optional String attribute HppRamTableImplementation.
	 *
	 *	@return	The String value of the attribute HppRamTableImplementation.
	 */
	String getOptionalHppRamTableImplementation();

	/**
	 *	Set the optional String attribute HppRamTableImplementation.
	 *
	 *	@param	value	the String value of the attribute HppRamTableImplementation.
	 */
	void setOptionalHppRamTableImplementation( String value );

	/**
	 *	Get the optional String attribute HppSaxLoaderInclude.
	 *
	 *	@return	The String value of the attribute HppSaxLoaderInclude.
	 */
	String getOptionalHppSaxLoaderInclude();

	/**
	 *	Set the optional String attribute HppSaxLoaderInclude.
	 *
	 *	@param	value	the String value of the attribute HppSaxLoaderInclude.
	 */
	void setOptionalHppSaxLoaderInclude( String value );

	/**
	 *	Get the optional String attribute HppSaxLoaderStartElement.
	 *
	 *	@return	The String value of the attribute HppSaxLoaderStartElement.
	 */
	String getOptionalHppSaxLoaderStartElement();

	/**
	 *	Set the optional String attribute HppSaxLoaderStartElement.
	 *
	 *	@param	value	the String value of the attribute HppSaxLoaderStartElement.
	 */
	void setOptionalHppSaxLoaderStartElement( String value );

	/**
	 *	Get the optional String attribute HppSaxLoaderEndElement.
	 *
	 *	@return	The String value of the attribute HppSaxLoaderEndElement.
	 */
	String getOptionalHppSaxLoaderEndElement();

	/**
	 *	Set the optional String attribute HppSaxLoaderEndElement.
	 *
	 *	@param	value	the String value of the attribute HppSaxLoaderEndElement.
	 */
	void setOptionalHppSaxLoaderEndElement( String value );

	/**
	 *	Get the optional String attribute HppXMsgTableInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgTableInclude.
	 */
	String getOptionalHppXMsgTableInclude();

	/**
	 *	Set the optional String attribute HppXMsgTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgTableInclude.
	 */
	void setOptionalHppXMsgTableInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgTableFormatters.
	 *
	 *	@return	The String value of the attribute HppXMsgTableFormatters.
	 */
	String getOptionalHppXMsgTableFormatters();

	/**
	 *	Set the optional String attribute HppXMsgTableFormatters.
	 *
	 *	@param	value	the String value of the attribute HppXMsgTableFormatters.
	 */
	void setOptionalHppXMsgTableFormatters( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstTableInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstTableInclude.
	 */
	String getOptionalHppXMsgRqstTableInclude();

	/**
	 *	Set the optional String attribute HppXMsgRqstTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstTableInclude.
	 */
	void setOptionalHppXMsgRqstTableInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnTableInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnTableInclude.
	 */
	String getOptionalHppXMsgRspnTableInclude();

	/**
	 *	Set the optional String attribute HppXMsgRspnTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnTableInclude.
	 */
	void setOptionalHppXMsgRspnTableInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgClientTableInclude.
	 *
	 *	@return	The String value of the attribute HppXMsgClientTableInclude.
	 */
	String getOptionalHppXMsgClientTableInclude();

	/**
	 *	Set the optional String attribute HppXMsgClientTableInclude.
	 *
	 *	@param	value	the String value of the attribute HppXMsgClientTableInclude.
	 */
	void setOptionalHppXMsgClientTableInclude( String value );

	/**
	 *	Get the optional String attribute HppXMsgRqstTableBody.
	 *
	 *	@return	The String value of the attribute HppXMsgRqstTableBody.
	 */
	String getOptionalHppXMsgRqstTableBody();

	/**
	 *	Set the optional String attribute HppXMsgRqstTableBody.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRqstTableBody.
	 */
	void setOptionalHppXMsgRqstTableBody( String value );

	/**
	 *	Get the optional String attribute HppXMsgRspnTableBody.
	 *
	 *	@return	The String value of the attribute HppXMsgRspnTableBody.
	 */
	String getOptionalHppXMsgRspnTableBody();

	/**
	 *	Set the optional String attribute HppXMsgRspnTableBody.
	 *
	 *	@param	value	the String value of the attribute HppXMsgRspnTableBody.
	 */
	void setOptionalHppXMsgRspnTableBody( String value );

	/**
	 *	Get the optional String attribute HppXMsgClientTableBody.
	 *
	 *	@return	The String value of the attribute HppXMsgClientTableBody.
	 */
	String getOptionalHppXMsgClientTableBody();

	/**
	 *	Set the optional String attribute HppXMsgClientTableBody.
	 *
	 *	@param	value	the String value of the attribute HppXMsgClientTableBody.
	 */
	void setOptionalHppXMsgClientTableBody( String value );

	/**
	 *	Get the optional String attribute CsObjMembers.
	 *
	 *	@return	The String value of the attribute CsObjMembers.
	 */
	String getOptionalCsObjMembers();

	/**
	 *	Set the optional String attribute CsObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsObjMembers.
	 */
	void setOptionalCsObjMembers( String value );

	/**
	 *	Get the optional String attribute CsObjInterface.
	 *
	 *	@return	The String value of the attribute CsObjInterface.
	 */
	String getOptionalCsObjInterface();

	/**
	 *	Set the optional String attribute CsObjInterface.
	 *
	 *	@param	value	the String value of the attribute CsObjInterface.
	 */
	void setOptionalCsObjInterface( String value );

	/**
	 *	Get the optional String attribute CsObjUsing.
	 *
	 *	@return	The String value of the attribute CsObjUsing.
	 */
	String getOptionalCsObjUsing();

	/**
	 *	Set the optional String attribute CsObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsObjUsing.
	 */
	void setOptionalCsObjUsing( String value );

	/**
	 *	Get the optional String attribute CsObjImplementation.
	 *
	 *	@return	The String value of the attribute CsObjImplementation.
	 */
	String getOptionalCsObjImplementation();

	/**
	 *	Set the optional String attribute CsObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CsObjImplementation.
	 */
	void setOptionalCsObjImplementation( String value );

	/**
	 *	Get the optional String attribute CsEditObjMembers.
	 *
	 *	@return	The String value of the attribute CsEditObjMembers.
	 */
	String getOptionalCsEditObjMembers();

	/**
	 *	Set the optional String attribute CsEditObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsEditObjMembers.
	 */
	void setOptionalCsEditObjMembers( String value );

	/**
	 *	Get the optional String attribute CsEditObjInterface.
	 *
	 *	@return	The String value of the attribute CsEditObjInterface.
	 */
	String getOptionalCsEditObjInterface();

	/**
	 *	Set the optional String attribute CsEditObjInterface.
	 *
	 *	@param	value	the String value of the attribute CsEditObjInterface.
	 */
	void setOptionalCsEditObjInterface( String value );

	/**
	 *	Get the optional String attribute CsEditObjUsing.
	 *
	 *	@return	The String value of the attribute CsEditObjUsing.
	 */
	String getOptionalCsEditObjUsing();

	/**
	 *	Set the optional String attribute CsEditObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsEditObjUsing.
	 */
	void setOptionalCsEditObjUsing( String value );

	/**
	 *	Get the optional String attribute CsEditObjImplementation.
	 *
	 *	@return	The String value of the attribute CsEditObjImplementation.
	 */
	String getOptionalCsEditObjImplementation();

	/**
	 *	Set the optional String attribute CsEditObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CsEditObjImplementation.
	 */
	void setOptionalCsEditObjImplementation( String value );

	/**
	 *	Get the optional String attribute CsTableUsing.
	 *
	 *	@return	The String value of the attribute CsTableUsing.
	 */
	String getOptionalCsTableUsing();

	/**
	 *	Set the optional String attribute CsTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsTableUsing.
	 */
	void setOptionalCsTableUsing( String value );

	/**
	 *	Get the optional String attribute CsTableMembers.
	 *
	 *	@return	The String value of the attribute CsTableMembers.
	 */
	String getOptionalCsTableMembers();

	/**
	 *	Set the optional String attribute CsTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsTableMembers.
	 */
	void setOptionalCsTableMembers( String value );

	/**
	 *	Get the optional String attribute CsTableInterface.
	 *
	 *	@return	The String value of the attribute CsTableInterface.
	 */
	String getOptionalCsTableInterface();

	/**
	 *	Set the optional String attribute CsTableInterface.
	 *
	 *	@param	value	the String value of the attribute CsTableInterface.
	 */
	void setOptionalCsTableInterface( String value );

	/**
	 *	Get the optional String attribute CsTableImplementation.
	 *
	 *	@return	The String value of the attribute CsTableImplementation.
	 */
	String getOptionalCsTableImplementation();

	/**
	 *	Set the optional String attribute CsTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsTableImplementation.
	 */
	void setOptionalCsTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsTableObjUsing.
	 *
	 *	@return	The String value of the attribute CsTableObjUsing.
	 */
	String getOptionalCsTableObjUsing();

	/**
	 *	Set the optional String attribute CsTableObjUsing.
	 *
	 *	@param	value	the String value of the attribute CsTableObjUsing.
	 */
	void setOptionalCsTableObjUsing( String value );

	/**
	 *	Get the optional String attribute CsTableObjMembers.
	 *
	 *	@return	The String value of the attribute CsTableObjMembers.
	 */
	String getOptionalCsTableObjMembers();

	/**
	 *	Set the optional String attribute CsTableObjMembers.
	 *
	 *	@param	value	the String value of the attribute CsTableObjMembers.
	 */
	void setOptionalCsTableObjMembers( String value );

	/**
	 *	Get the optional String attribute CsTableObjInterface.
	 *
	 *	@return	The String value of the attribute CsTableObjInterface.
	 */
	String getOptionalCsTableObjInterface();

	/**
	 *	Set the optional String attribute CsTableObjInterface.
	 *
	 *	@param	value	the String value of the attribute CsTableObjInterface.
	 */
	void setOptionalCsTableObjInterface( String value );

	/**
	 *	Get the optional String attribute CsTableObjImplementation.
	 *
	 *	@return	The String value of the attribute CsTableObjImplementation.
	 */
	String getOptionalCsTableObjImplementation();

	/**
	 *	Set the optional String attribute CsTableObjImplementation.
	 *
	 *	@param	value	the String value of the attribute CsTableObjImplementation.
	 */
	void setOptionalCsTableObjImplementation( String value );

	/**
	 *	Get the optional String attribute CsDb2LUWTableUsing.
	 *
	 *	@return	The String value of the attribute CsDb2LUWTableUsing.
	 */
	String getOptionalCsDb2LUWTableUsing();

	/**
	 *	Set the optional String attribute CsDb2LUWTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsDb2LUWTableUsing.
	 */
	void setOptionalCsDb2LUWTableUsing( String value );

	/**
	 *	Get the optional String attribute CsDb2LUWTableMembers.
	 *
	 *	@return	The String value of the attribute CsDb2LUWTableMembers.
	 */
	String getOptionalCsDb2LUWTableMembers();

	/**
	 *	Set the optional String attribute CsDb2LUWTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsDb2LUWTableMembers.
	 */
	void setOptionalCsDb2LUWTableMembers( String value );

	/**
	 *	Get the optional String attribute CsDb2LUWTableImplementation.
	 *
	 *	@return	The String value of the attribute CsDb2LUWTableImplementation.
	 */
	String getOptionalCsDb2LUWTableImplementation();

	/**
	 *	Set the optional String attribute CsDb2LUWTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsDb2LUWTableImplementation.
	 */
	void setOptionalCsDb2LUWTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsMSSqlTableUsing.
	 *
	 *	@return	The String value of the attribute CsMSSqlTableUsing.
	 */
	String getOptionalCsMSSqlTableUsing();

	/**
	 *	Set the optional String attribute CsMSSqlTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsMSSqlTableUsing.
	 */
	void setOptionalCsMSSqlTableUsing( String value );

	/**
	 *	Get the optional String attribute CsMSSqlTableMembers.
	 *
	 *	@return	The String value of the attribute CsMSSqlTableMembers.
	 */
	String getOptionalCsMSSqlTableMembers();

	/**
	 *	Set the optional String attribute CsMSSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsMSSqlTableMembers.
	 */
	void setOptionalCsMSSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute CsMSSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute CsMSSqlTableImplementation.
	 */
	String getOptionalCsMSSqlTableImplementation();

	/**
	 *	Set the optional String attribute CsMSSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsMSSqlTableImplementation.
	 */
	void setOptionalCsMSSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsMySqlTableUsing.
	 *
	 *	@return	The String value of the attribute CsMySqlTableUsing.
	 */
	String getOptionalCsMySqlTableUsing();

	/**
	 *	Set the optional String attribute CsMySqlTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsMySqlTableUsing.
	 */
	void setOptionalCsMySqlTableUsing( String value );

	/**
	 *	Get the optional String attribute CsMySqlTableMembers.
	 *
	 *	@return	The String value of the attribute CsMySqlTableMembers.
	 */
	String getOptionalCsMySqlTableMembers();

	/**
	 *	Set the optional String attribute CsMySqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsMySqlTableMembers.
	 */
	void setOptionalCsMySqlTableMembers( String value );

	/**
	 *	Get the optional String attribute CsMySqlTableImplementation.
	 *
	 *	@return	The String value of the attribute CsMySqlTableImplementation.
	 */
	String getOptionalCsMySqlTableImplementation();

	/**
	 *	Set the optional String attribute CsMySqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsMySqlTableImplementation.
	 */
	void setOptionalCsMySqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsOracleTableUsing.
	 *
	 *	@return	The String value of the attribute CsOracleTableUsing.
	 */
	String getOptionalCsOracleTableUsing();

	/**
	 *	Set the optional String attribute CsOracleTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsOracleTableUsing.
	 */
	void setOptionalCsOracleTableUsing( String value );

	/**
	 *	Get the optional String attribute CsOracleTableMembers.
	 *
	 *	@return	The String value of the attribute CsOracleTableMembers.
	 */
	String getOptionalCsOracleTableMembers();

	/**
	 *	Set the optional String attribute CsOracleTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsOracleTableMembers.
	 */
	void setOptionalCsOracleTableMembers( String value );

	/**
	 *	Get the optional String attribute CsOracleTableImplementation.
	 *
	 *	@return	The String value of the attribute CsOracleTableImplementation.
	 */
	String getOptionalCsOracleTableImplementation();

	/**
	 *	Set the optional String attribute CsOracleTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsOracleTableImplementation.
	 */
	void setOptionalCsOracleTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsPgSqlTableUsing.
	 *
	 *	@return	The String value of the attribute CsPgSqlTableUsing.
	 */
	String getOptionalCsPgSqlTableUsing();

	/**
	 *	Set the optional String attribute CsPgSqlTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsPgSqlTableUsing.
	 */
	void setOptionalCsPgSqlTableUsing( String value );

	/**
	 *	Get the optional String attribute CsPgSqlTableMembers.
	 *
	 *	@return	The String value of the attribute CsPgSqlTableMembers.
	 */
	String getOptionalCsPgSqlTableMembers();

	/**
	 *	Set the optional String attribute CsPgSqlTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsPgSqlTableMembers.
	 */
	void setOptionalCsPgSqlTableMembers( String value );

	/**
	 *	Get the optional String attribute CsPgSqlTableImplementation.
	 *
	 *	@return	The String value of the attribute CsPgSqlTableImplementation.
	 */
	String getOptionalCsPgSqlTableImplementation();

	/**
	 *	Set the optional String attribute CsPgSqlTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsPgSqlTableImplementation.
	 */
	void setOptionalCsPgSqlTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsRamTableUsing.
	 *
	 *	@return	The String value of the attribute CsRamTableUsing.
	 */
	String getOptionalCsRamTableUsing();

	/**
	 *	Set the optional String attribute CsRamTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsRamTableUsing.
	 */
	void setOptionalCsRamTableUsing( String value );

	/**
	 *	Get the optional String attribute CsRamTableMembers.
	 *
	 *	@return	The String value of the attribute CsRamTableMembers.
	 */
	String getOptionalCsRamTableMembers();

	/**
	 *	Set the optional String attribute CsRamTableMembers.
	 *
	 *	@param	value	the String value of the attribute CsRamTableMembers.
	 */
	void setOptionalCsRamTableMembers( String value );

	/**
	 *	Get the optional String attribute CsRamTableImplementation.
	 *
	 *	@return	The String value of the attribute CsRamTableImplementation.
	 */
	String getOptionalCsRamTableImplementation();

	/**
	 *	Set the optional String attribute CsRamTableImplementation.
	 *
	 *	@param	value	the String value of the attribute CsRamTableImplementation.
	 */
	void setOptionalCsRamTableImplementation( String value );

	/**
	 *	Get the optional String attribute CsSaxLoaderUsing.
	 *
	 *	@return	The String value of the attribute CsSaxLoaderUsing.
	 */
	String getOptionalCsSaxLoaderUsing();

	/**
	 *	Set the optional String attribute CsSaxLoaderUsing.
	 *
	 *	@param	value	the String value of the attribute CsSaxLoaderUsing.
	 */
	void setOptionalCsSaxLoaderUsing( String value );

	/**
	 *	Get the optional String attribute CsSaxLoaderStartElement.
	 *
	 *	@return	The String value of the attribute CsSaxLoaderStartElement.
	 */
	String getOptionalCsSaxLoaderStartElement();

	/**
	 *	Set the optional String attribute CsSaxLoaderStartElement.
	 *
	 *	@param	value	the String value of the attribute CsSaxLoaderStartElement.
	 */
	void setOptionalCsSaxLoaderStartElement( String value );

	/**
	 *	Get the optional String attribute CsSaxLoaderEndElement.
	 *
	 *	@return	The String value of the attribute CsSaxLoaderEndElement.
	 */
	String getOptionalCsSaxLoaderEndElement();

	/**
	 *	Set the optional String attribute CsSaxLoaderEndElement.
	 *
	 *	@param	value	the String value of the attribute CsSaxLoaderEndElement.
	 */
	void setOptionalCsSaxLoaderEndElement( String value );

	/**
	 *	Get the optional String attribute CsXMsgTableUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgTableUsing.
	 */
	String getOptionalCsXMsgTableUsing();

	/**
	 *	Set the optional String attribute CsXMsgTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgTableUsing.
	 */
	void setOptionalCsXMsgTableUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgTableFormatters.
	 *
	 *	@return	The String value of the attribute CsXMsgTableFormatters.
	 */
	String getOptionalCsXMsgTableFormatters();

	/**
	 *	Set the optional String attribute CsXMsgTableFormatters.
	 *
	 *	@param	value	the String value of the attribute CsXMsgTableFormatters.
	 */
	void setOptionalCsXMsgTableFormatters( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstTableUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstTableUsing.
	 */
	String getOptionalCsXMsgRqstTableUsing();

	/**
	 *	Set the optional String attribute CsXMsgRqstTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstTableUsing.
	 */
	void setOptionalCsXMsgRqstTableUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnTableUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnTableUsing.
	 */
	String getOptionalCsXMsgRspnTableUsing();

	/**
	 *	Set the optional String attribute CsXMsgRspnTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnTableUsing.
	 */
	void setOptionalCsXMsgRspnTableUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgClientTableUsing.
	 *
	 *	@return	The String value of the attribute CsXMsgClientTableUsing.
	 */
	String getOptionalCsXMsgClientTableUsing();

	/**
	 *	Set the optional String attribute CsXMsgClientTableUsing.
	 *
	 *	@param	value	the String value of the attribute CsXMsgClientTableUsing.
	 */
	void setOptionalCsXMsgClientTableUsing( String value );

	/**
	 *	Get the optional String attribute CsXMsgRqstTableBody.
	 *
	 *	@return	The String value of the attribute CsXMsgRqstTableBody.
	 */
	String getOptionalCsXMsgRqstTableBody();

	/**
	 *	Set the optional String attribute CsXMsgRqstTableBody.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRqstTableBody.
	 */
	void setOptionalCsXMsgRqstTableBody( String value );

	/**
	 *	Get the optional String attribute CsXMsgRspnTableBody.
	 *
	 *	@return	The String value of the attribute CsXMsgRspnTableBody.
	 */
	String getOptionalCsXMsgRspnTableBody();

	/**
	 *	Set the optional String attribute CsXMsgRspnTableBody.
	 *
	 *	@param	value	the String value of the attribute CsXMsgRspnTableBody.
	 */
	void setOptionalCsXMsgRspnTableBody( String value );

	/**
	 *	Get the optional String attribute CsXMsgClientTableBody.
	 *
	 *	@return	The String value of the attribute CsXMsgClientTableBody.
	 */
	String getOptionalCsXMsgClientTableBody();

	/**
	 *	Set the optional String attribute CsXMsgClientTableBody.
	 *
	 *	@param	value	the String value of the attribute CsXMsgClientTableBody.
	 */
	void setOptionalCsXMsgClientTableBody( String value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 */
	ICFBamSchemaDefObj getRequiredContainerSchemaDef();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the SchemaDef key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the SchemaDef key.
	 */
	void setRequiredContainerSchemaDef( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@return	The ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 */
	ICFBamSchemaDefObj getOptionalLookupDefSchema();

	/**
	 *	Set the ICFBamSchemaDefObj instance referenced by the DefSchema key.
	 *
	 *	@param	value	the ICFBamSchemaDefObj instance to be referenced by the DefSchema key.
	 */
	void setOptionalLookupDefSchema( ICFBamSchemaDefObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the LookupIndex key.
	 */
	ICFBamIndexObj getOptionalLookupLookupIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the LookupIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the LookupIndex key.
	 */
	void setOptionalLookupLookupIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the AltIndex key.
	 */
	ICFBamIndexObj getOptionalLookupAltIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the AltIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the AltIndex key.
	 */
	void setOptionalLookupAltIndex( ICFBamIndexObj value );

	/**
	 *	Get the ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@return	The ICFBamTableObj instance referenced by the QualTable key.
	 */
	ICFBamTableObj getOptionalLookupQualTable();

	/**
	 *	Set the ICFBamTableObj instance referenced by the QualTable key.
	 *
	 *	@param	value	the ICFBamTableObj instance to be referenced by the QualTable key.
	 */
	void setOptionalLookupQualTable( ICFBamTableObj value );

	/**
	 *	Get the ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@return	The ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 */
	ICFBamIndexObj getOptionalLookupPrimaryIndex();

	/**
	 *	Set the ICFBamIndexObj instance referenced by the PrimaryIndex key.
	 *
	 *	@param	value	the ICFBamIndexObj instance to be referenced by the PrimaryIndex key.
	 */
	void setOptionalLookupPrimaryIndex( ICFBamIndexObj value );
}
