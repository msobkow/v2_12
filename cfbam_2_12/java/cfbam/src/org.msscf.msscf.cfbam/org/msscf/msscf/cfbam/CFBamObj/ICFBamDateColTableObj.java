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

public interface ICFBamDateColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DateCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDateColObj newInstance();

	/**
	 *	Instantiate a new DateCol edition of the specified DateCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDateColEditObj newEditInstance( ICFBamDateColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDateColObj realiseDateCol( ICFBamDateColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDateCol( ICFBamDateColObj Obj );
	void forgetDateCol( ICFBamDateColObj Obj, boolean forgetSubObjects );
	void forgetDateColByIdIdx( long TenantId,
		long Id );

	void forgetDateColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetDateColByValTentIdx( long TenantId );

	void forgetDateColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetDateColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDateColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetDateColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetDateColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetDateColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetDateColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamDateColObj createDateCol( ICFBamDateColObj Obj );

	/**
	 *	Read a DateCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DateCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDateColObj readDateCol( CFBamValuePKey pkey );

	/**
	 *	Read a DateCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DateCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDateColObj readDateCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDateColObj lockDateCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the DateCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamDateColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDateColObj> readAllDateCol();

	/**
	 *	Return a sorted map of all the DateCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamDateColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDateColObj> readAllDateCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateColObj readDateColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateColObj readDateColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateColObj readDateColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDateColObj readDateColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamDateColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDateColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDateColObj> readDateColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDateColObj updateDateCol( ICFBamDateColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDateCol( ICFBamDateColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DateCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DateCol key attribute of the instance generating the id.
	 */
	void deleteDateColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamDateColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDateColObj refreshed cache instance.
	 */
	ICFBamDateColObj moveUpDateCol( ICFBamDateColObj Obj );

	/**
	 *	Move the CFBamDateColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDateColObj refreshed cache instance.
	 */
	ICFBamDateColObj moveDownDateCol( ICFBamDateColObj Obj );
}
