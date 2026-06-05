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

public interface ICFBamDelTopDepTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DelTopDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDelTopDepObj newInstance();

	/**
	 *	Instantiate a new DelTopDep edition of the specified DelTopDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDelTopDepEditObj newEditInstance( ICFBamDelTopDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDelTopDepObj realiseDelTopDep( ICFBamDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDelTopDep( ICFBamDelTopDepObj Obj );
	void forgetDelTopDep( ICFBamDelTopDepObj Obj, boolean forgetSubObjects );
	void forgetDelTopDepByIdIdx( long TenantId,
		long Id );

	void forgetDelTopDepByTenantIdx( long TenantId );

	void forgetDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId );

	void forgetDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId );

	void forgetDelTopDepByUNameIdx( long TableTenantId,
		long TableId,
		String Name );

	void forgetDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetDelTopDepByNextIdx( Long NextTenantId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamDelTopDepObj createDelTopDep( ICFBamDelTopDepObj Obj );

	/**
	 *	Read a DelTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDelTopDepObj readDelTopDep( CFBamScopePKey pkey );

	/**
	 *	Read a DelTopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelTopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDelTopDepObj readDelTopDep( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDelTopDepObj lockDelTopDep( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the DelTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamDelTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDelTopDepObj> readAllDelTopDep();

	/**
	 *	Return a sorted map of all the DelTopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamDelTopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDelTopDepObj> readAllDelTopDep( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelTopDepObj readDelTopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelTopDepObj readDelTopDepByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	argRelationTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	argRelationTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate DelTopDepTblIdx key.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate DelTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate DelTopDepTblIdx key.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate DelTopDepTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the CFBamDelTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamDelTopDepObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelTopDepObj readDelTopDepByUNameIdx(long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamDelTopDepObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamDelTopDepObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelTopDepObj readDelTopDepByUNameIdx(long TableTenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamDelTopDepObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelTopDepObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelTopDepObj> readDelTopDepByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDelTopDepObj updateDelTopDep( ICFBamDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelTopDep( ICFBamDelTopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelDepIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByDelTopDepTblIdx( long TableTenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTableTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByUNameIdx(long TableTenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The DelTopDep key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DelTopDep key attribute of the instance generating the id.
	 */
	void deleteDelTopDepByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Move the CFBamDelTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDelTopDepObj refreshed cache instance.
	 */
	ICFBamDelTopDepObj moveUpDelTopDep( ICFBamDelTopDepObj Obj );

	/**
	 *	Move the CFBamDelTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDelTopDepObj refreshed cache instance.
	 */
	ICFBamDelTopDepObj moveDownDelTopDep( ICFBamDelTopDepObj Obj );
}
