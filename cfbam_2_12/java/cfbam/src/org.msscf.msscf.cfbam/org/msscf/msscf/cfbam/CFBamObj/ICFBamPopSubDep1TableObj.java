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

public interface ICFBamPopSubDep1TableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new PopSubDep1 instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPopSubDep1Obj newInstance();

	/**
	 *	Instantiate a new PopSubDep1 edition of the specified PopSubDep1 instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPopSubDep1EditObj newEditInstance( ICFBamPopSubDep1Obj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep1Obj realisePopSubDep1( ICFBamPopSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetPopSubDep1( ICFBamPopSubDep1Obj Obj );
	void forgetPopSubDep1( ICFBamPopSubDep1Obj Obj, boolean forgetSubObjects );
	void forgetPopSubDep1ByIdIdx( long TenantId,
		long Id );

	void forgetPopSubDep1ByTenantIdx( long TenantId );

	void forgetPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId );

	void forgetPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetPopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId );

	void forgetPopSubDep1ByUNameIdx( long PopTopDepTenantId,
		long PopTopDepId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep1Obj createPopSubDep1( ICFBamPopSubDep1Obj Obj );

	/**
	 *	Read a PopSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopSubDep1Obj readPopSubDep1( CFBamScopePKey pkey );

	/**
	 *	Read a PopSubDep1-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopSubDep1-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopSubDep1Obj readPopSubDep1( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep1Obj lockPopSubDep1( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the PopSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readAllPopSubDep1();

	/**
	 *	Return a sorted map of all the PopSubDep1-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopSubDep1Obj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readAllPopSubDep1( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep1Obj readPopSubDep1ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep1Obj readPopSubDep1ByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamPopSubDep1Obj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamPopSubDep1Obj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamPopSubDep1Obj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopSubDep1Obj instances sorted by their primary keys for the duplicate PopTopDepIdx key.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate PopTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId );

	/**
	 *	Get the map of CFBamPopSubDep1Obj instances sorted by their primary keys for the duplicate PopTopDepIdx key.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopSubDep1Obj cached instances sorted by their primary keys for the duplicate PopTopDepIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopSubDep1Obj> readPopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId,
		boolean forceRead );

	/**
	 *	Get the CFBamPopSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPopSubDep1Obj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep1Obj readPopSubDep1ByUNameIdx(long PopTopDepTenantId,
		long PopTopDepId,
		String Name );

	/**
	 *	Get the CFBamPopSubDep1Obj instance for the unique UNameIdx key.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@return	CFBamPopSubDep1Obj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopSubDep1Obj readPopSubDep1ByUNameIdx(long PopTopDepTenantId,
		long PopTopDepId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopSubDep1Obj updatePopSubDep1( ICFBamPopSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 */
	void deletePopSubDep1( ICFBamPopSubDep1Obj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByPopTopDepIdx( long PopTopDepTenantId,
		long PopTopDepId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPopTopDepTenantId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argPopTopDepId	The PopSubDep1 key attribute of the instance generating the id.
	 *
	 *	@param	argName	The PopSubDep1 key attribute of the instance generating the id.
	 */
	void deletePopSubDep1ByUNameIdx(long PopTopDepTenantId,
		long PopTopDepId,
		String Name );
}
