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

public interface ICFBamInt16TypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Int16Type instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamInt16TypeObj newInstance();

	/**
	 *	Instantiate a new Int16Type edition of the specified Int16Type instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamInt16TypeEditObj newEditInstance( ICFBamInt16TypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamInt16TypeObj realiseInt16Type( ICFBamInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetInt16Type( ICFBamInt16TypeObj Obj );
	void forgetInt16Type( ICFBamInt16TypeObj Obj, boolean forgetSubObjects );
	void forgetInt16TypeByIdIdx( long TenantId,
		long Id );

	void forgetInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetInt16TypeByValTentIdx( long TenantId );

	void forgetInt16TypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetInt16TypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamInt16TypeObj createInt16Type( ICFBamInt16TypeObj Obj );

	/**
	 *	Read a Int16Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt16TypeObj readInt16Type( CFBamValuePKey pkey );

	/**
	 *	Read a Int16Type-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int16Type-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt16TypeObj readInt16Type( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt16TypeObj lockInt16Type( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Int16Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt16TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt16TypeObj> readAllInt16Type();

	/**
	 *	Return a sorted map of all the Int16Type-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt16TypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt16TypeObj> readAllInt16Type( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16TypeObj readInt16TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16TypeObj readInt16TypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16TypeObj readInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt16TypeObj readInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamInt16TypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt16TypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt16TypeObj> readInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt16TypeObj updateInt16Type( ICFBamInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt16Type( ICFBamInt16TypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int16Type key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The Int16Type key attribute of the instance generating the id.
	 */
	void deleteInt16TypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamInt16TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16TypeObj refreshed cache instance.
	 */
	ICFBamInt16TypeObj moveUpInt16Type( ICFBamInt16TypeObj Obj );

	/**
	 *	Move the CFBamInt16TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt16TypeObj refreshed cache instance.
	 */
	ICFBamInt16TypeObj moveDownInt16Type( ICFBamInt16TypeObj Obj );
}
