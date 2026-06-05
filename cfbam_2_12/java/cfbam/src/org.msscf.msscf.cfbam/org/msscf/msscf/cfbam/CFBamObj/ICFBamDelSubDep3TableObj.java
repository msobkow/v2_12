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

public interface ICFBamDelSubDep3TableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DelSubDep3 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDelSubDep3Obj newInstance();

	/**
	 *	Instantiate a new DelSubDep3 edition of the specified DelSubDep3 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDelSubDep3EditObj newEditInstance( ICFBamDelSubDep3Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDelSubDep3Obj realiseDelSubDep3( ICFBamDelSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDelSubDep3( ICFBamDelSubDep3Obj Obj );
	void forgetDelSubDep3( ICFBamDelSubDep3Obj Obj, boolean forgetSubObjects );
	void forgetDelSubDep3ByIdIdx( long TenantId,
		long Id );

	void forgetDelSubDep3ByTenantIdx( long TenantId );

	void forgetDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDelSubDep3ByDelDepIdx( long RelationTenantId,
		long RelationId );

	void forgetDelSubDep3ByDelSubDep2Idx( long DelSubDep2TenantId,
		long DelSubDep2Id );

	void forgetDelSubDep3ByUNameIdx( long DelSubDep2TenantId,
		long DelSubDep2Id,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamDelSubDep3Obj createDelSubDep3( ICFBamDelSubDep3Obj Obj );

	/**
	 *	Read a DelSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDelSubDep3Obj readDelSubDep3( CFBamScopePKey pkey );

	/**
	 *	Read a DelSubDep3-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DelSubDep3-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDelSubDep3Obj readDelSubDep3( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDelSubDep3Obj lockDelSubDep3( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the DelSubDep3-derived instances in the database.
	 *
	 *	@return	List of ICFBamDelSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readAllDelSubDep3();

	/**
	 *	Return a sorted map of all the DelSubDep3-derived instances in the database.
	 *
	 *	@return	List of ICFBamDelSubDep3Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readAllDelSubDep3( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelSubDep3Obj readDelSubDep3ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelSubDep3Obj readDelSubDep3ByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamDelSubDep3Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDelSubDep3Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelDepObj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	argRelationTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByDelDepIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamDelSubDep3Obj instances sorted by their primary keys for the duplicate DelDepIdx key.
	 *
	 *	@param	argRelationTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate DelDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByDelDepIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamDelSubDep3Obj instances sorted by their primary keys for the duplicate DelSubDep2Idx key.
	 *
	 *	@param	argDelSubDep2TenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDelSubDep2Id	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate DelSubDep2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByDelSubDep2Idx( long DelSubDep2TenantId,
		long DelSubDep2Id );

	/**
	 *	Get the map of CFBamDelSubDep3Obj instances sorted by their primary keys for the duplicate DelSubDep2Idx key.
	 *
	 *	@param	argDelSubDep2TenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDelSubDep2Id	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDelSubDep3Obj cached instances sorted by their primary keys for the duplicate DelSubDep2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDelSubDep3Obj> readDelSubDep3ByDelSubDep2Idx( long DelSubDep2TenantId,
		long DelSubDep2Id,
		boolean forceRead );

	/**
	 *	Get the CFBamDelSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argDelSubDep2TenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDelSubDep2Id	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamDelSubDep3Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelSubDep3Obj readDelSubDep3ByUNameIdx(long DelSubDep2TenantId,
		long DelSubDep2Id,
		String Name );

	/**
	 *	Get the CFBamDelSubDep3Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argDelSubDep2TenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDelSubDep2Id	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamDelSubDep3Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDelSubDep3Obj readDelSubDep3ByUNameIdx(long DelSubDep2TenantId,
		long DelSubDep2Id,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDelSubDep3Obj updateDelSubDep3( ICFBamDelSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDelSubDep3( ICFBamDelSubDep3Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DelSubDep3 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep3ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep3ByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DelSubDep3 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep3ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The DelSubDep3 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep3ByDelDepIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDelSubDep2TenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDelSubDep2Id	The DelSubDep3 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep3ByDelSubDep2Idx( long DelSubDep2TenantId,
		long DelSubDep2Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDelSubDep2TenantId	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argDelSubDep2Id	The DelSubDep3 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DelSubDep3 key attribute of the instance generating the id.
	 */
	void deleteDelSubDep3ByUNameIdx(long DelSubDep2TenantId,
		long DelSubDep2Id,
		String Name );
}
