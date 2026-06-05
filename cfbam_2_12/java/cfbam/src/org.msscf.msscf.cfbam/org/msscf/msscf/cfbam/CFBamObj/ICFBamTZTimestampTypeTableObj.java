// Description: Java 11 Table Object interface for CFBam.

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

public interface ICFBamTZTimestampTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TZTimestampType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTZTimestampTypeObj newInstance();

	/**
	 *	Instantiate a new TZTimestampType edition of the specified TZTimestampType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTZTimestampTypeEditObj newEditInstance( ICFBamTZTimestampTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampTypeObj realiseTZTimestampType( ICFBamTZTimestampTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTZTimestampType( ICFBamTZTimestampTypeObj Obj );
	void forgetTZTimestampType( ICFBamTZTimestampTypeObj Obj, boolean forgetSubObjects );
	void forgetTZTimestampTypeByIdIdx( long TenantId,
		long Id );

	void forgetTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTZTimestampTypeByValTentIdx( long TenantId );

	void forgetTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampTypeObj createTZTimestampType( ICFBamTZTimestampTypeObj Obj );

	/**
	 *	Read a TZTimestampType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimestampType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimestampTypeObj readTZTimestampType( CFBamValuePKey pkey );

	/**
	 *	Read a TZTimestampType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimestampType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimestampTypeObj readTZTimestampType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampTypeObj lockTZTimestampType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TZTimestampType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimestampTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readAllTZTimestampType();

	/**
	 *	Return a sorted map of all the TZTimestampType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimestampTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readAllTZTimestampType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampTypeObj readTZTimestampTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampTypeObj readTZTimestampTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampTypeObj readTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimestampTypeObj readTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTZTimestampTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimestampTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimestampTypeObj> readTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimestampTypeObj updateTZTimestampType( ICFBamTZTimestampTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTZTimestampType( ICFBamTZTimestampTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimestampType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TZTimestampType key attribute of the instance generating the id.
	 */
	void deleteTZTimestampTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamTZTimestampTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampTypeObj refreshed cache instance.
	 */
	ICFBamTZTimestampTypeObj moveUpTZTimestampType( ICFBamTZTimestampTypeObj Obj );

	/**
	 *	Move the CFBamTZTimestampTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimestampTypeObj refreshed cache instance.
	 */
	ICFBamTZTimestampTypeObj moveDownTZTimestampType( ICFBamTZTimestampTypeObj Obj );
}
