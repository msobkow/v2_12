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

public interface ICFBamInt64ColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Int64Col instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamInt64ColObj newInstance();

	/**
	 *	Instantiate a new Int64Col edition of the specified Int64Col instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamInt64ColEditObj newEditInstance( ICFBamInt64ColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64ColObj realiseInt64Col( ICFBamInt64ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetInt64Col( ICFBamInt64ColObj Obj );
	void forgetInt64Col( ICFBamInt64ColObj Obj, boolean forgetSubObjects );
	void forgetInt64ColByIdIdx( long TenantId,
		long Id );

	void forgetInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetInt64ColByValTentIdx( long TenantId );

	void forgetInt64ColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetInt64ColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetInt64ColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamInt64ColObj createInt64Col( ICFBamInt64ColObj Obj );

	/**
	 *	Read a Int64Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt64ColObj readInt64Col( CFBamValuePKey pkey );

	/**
	 *	Read a Int64Col-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Int64Col-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamInt64ColObj readInt64Col( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64ColObj lockInt64Col( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the Int64Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt64ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt64ColObj> readAllInt64Col();

	/**
	 *	Return a sorted map of all the Int64Col-derived instances in the database.
	 *
	 *	@return	List of ICFBamInt64ColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamInt64ColObj> readAllInt64Col( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64ColObj readInt64ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64ColObj readInt64ColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64ColObj readInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamInt64ColObj readInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamInt64ColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamInt64ColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamInt64ColObj> readInt64ColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamInt64ColObj updateInt64Col( ICFBamInt64ColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteInt64Col( ICFBamInt64ColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Int64Col key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Int64Col key attribute of the instance generating the id.
	 */
	void deleteInt64ColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamInt64ColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt64ColObj refreshed cache instance.
	 */
	ICFBamInt64ColObj moveUpInt64Col( ICFBamInt64ColObj Obj );

	/**
	 *	Move the CFBamInt64ColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamInt64ColObj refreshed cache instance.
	 */
	ICFBamInt64ColObj moveDownInt64Col( ICFBamInt64ColObj Obj );
}
