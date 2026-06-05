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

public interface ICFBamUuidGenTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new UuidGen instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamUuidGenObj newInstance();

	/**
	 *	Instantiate a new UuidGen edition of the specified UuidGen instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamUuidGenEditObj newEditInstance( ICFBamUuidGenObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidGenObj realiseUuidGen( ICFBamUuidGenObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetUuidGen( ICFBamUuidGenObj Obj );
	void forgetUuidGen( ICFBamUuidGenObj Obj, boolean forgetSubObjects );
	void forgetUuidGenByIdIdx( long TenantId,
		long Id );

	void forgetUuidGenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetUuidGenByValTentIdx( long TenantId );

	void forgetUuidGenByScopeIdx( long TenantId,
		long ScopeId );

	void forgetUuidGenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetUuidGenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetUuidGenByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetUuidGenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetUuidGenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetUuidGenBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamUuidGenObj createUuidGen( ICFBamUuidGenObj Obj );

	/**
	 *	Read a UuidGen-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidGen-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidGenObj readUuidGen( CFBamValuePKey pkey );

	/**
	 *	Read a UuidGen-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The UuidGen-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamUuidGenObj readUuidGen( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidGenObj lockUuidGen( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the UuidGen-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidGenObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidGenObj> readAllUuidGen();

	/**
	 *	Return a sorted map of all the UuidGen-derived instances in the database.
	 *
	 *	@return	List of ICFBamUuidGenObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamUuidGenObj> readAllUuidGen( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidGenObj readUuidGenByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidGenObj readUuidGenByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidGenObj readUuidGenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamUuidGenObj readUuidGenByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamUuidTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamUuidGenObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamUuidGenObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamUuidGenObj> readUuidGenBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamUuidGenObj updateUuidGen( ICFBamUuidGenObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteUuidGen( ICFBamUuidGenObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argName	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The UuidGen key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The UuidGen key attribute of the instance generating the id.
	 */
	void deleteUuidGenBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamUuidGenObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidGenObj refreshed cache instance.
	 */
	ICFBamUuidGenObj moveUpUuidGen( ICFBamUuidGenObj Obj );

	/**
	 *	Move the CFBamUuidGenObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamUuidGenObj refreshed cache instance.
	 */
	ICFBamUuidGenObj moveDownUuidGen( ICFBamUuidGenObj Obj );
}
