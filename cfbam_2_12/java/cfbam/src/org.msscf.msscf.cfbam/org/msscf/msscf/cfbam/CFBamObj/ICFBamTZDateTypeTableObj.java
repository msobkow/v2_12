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

public interface ICFBamTZDateTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TZDateType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTZDateTypeObj newInstance();

	/**
	 *	Instantiate a new TZDateType edition of the specified TZDateType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTZDateTypeEditObj newEditInstance( ICFBamTZDateTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTZDateTypeObj realiseTZDateType( ICFBamTZDateTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTZDateType( ICFBamTZDateTypeObj Obj );
	void forgetTZDateType( ICFBamTZDateTypeObj Obj, boolean forgetSubObjects );
	void forgetTZDateTypeByIdIdx( long TenantId,
		long Id );

	void forgetTZDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTZDateTypeByValTentIdx( long TenantId );

	void forgetTZDateTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTZDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTZDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTZDateTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTZDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTZDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTZDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamTZDateTypeObj createTZDateType( ICFBamTZDateTypeObj Obj );

	/**
	 *	Read a TZDateType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZDateType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZDateTypeObj readTZDateType( CFBamValuePKey pkey );

	/**
	 *	Read a TZDateType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZDateType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZDateTypeObj readTZDateType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZDateTypeObj lockTZDateType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TZDateType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZDateTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZDateTypeObj> readAllTZDateType();

	/**
	 *	Return a sorted map of all the TZDateType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZDateTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZDateTypeObj> readAllTZDateType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateTypeObj readTZDateTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateTypeObj readTZDateTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateTypeObj readTZDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZDateTypeObj readTZDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTZDateTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZDateTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZDateTypeObj> readTZDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZDateTypeObj updateTZDateType( ICFBamTZDateTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTZDateType( ICFBamTZDateTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZDateType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TZDateType key attribute of the instance generating the id.
	 */
	void deleteTZDateTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamTZDateTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZDateTypeObj refreshed cache instance.
	 */
	ICFBamTZDateTypeObj moveUpTZDateType( ICFBamTZDateTypeObj Obj );

	/**
	 *	Move the CFBamTZDateTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZDateTypeObj refreshed cache instance.
	 */
	ICFBamTZDateTypeObj moveDownTZDateType( ICFBamTZDateTypeObj Obj );
}
