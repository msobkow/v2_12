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

public interface ICFBamPopDepTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new PopDep instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamPopDepObj newInstance();

	/**
	 *	Instantiate a new PopDep edition of the specified PopDep instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamPopDepEditObj newEditInstance( ICFBamPopDepObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamPopDepObj realisePopDep( ICFBamPopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetPopDep( ICFBamPopDepObj Obj );
	void forgetPopDep( ICFBamPopDepObj Obj, boolean forgetSubObjects );
	void forgetPopDepByIdIdx( long TenantId,
		long Id );

	void forgetPopDepByTenantIdx( long TenantId );

	void forgetPopDepByRelationIdx( long RelationTenantId,
		long RelationId );

	void forgetPopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );


	/**
	 *	Internal use only.
	 */
	ICFBamPopDepObj createPopDep( ICFBamPopDepObj Obj );

	/**
	 *	Read a PopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopDepObj readPopDep( CFBamScopePKey pkey );

	/**
	 *	Read a PopDep-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The PopDep-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamPopDepObj readPopDep( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopDepObj lockPopDep( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the PopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopDepObj> readAllPopDep();

	/**
	 *	Return a sorted map of all the PopDep-derived instances in the database.
	 *
	 *	@return	List of ICFBamPopDepObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamPopDepObj> readAllPopDep( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopDepObj readPopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamPopDepObj readPopDepByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopDepObj> readPopDepByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopDepObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopDepObj> readPopDepByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopDepObj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopDepObj> readPopDepByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate RelationIdx key.
	 *
	 *	@param	argRelationTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopDepObj cached instances sorted by their primary keys for the duplicate RelationIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopDepObj> readPopDepByRelationIdx( long RelationTenantId,
		long RelationId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopDepObj> readPopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamPopDepObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamPopDepObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamPopDepObj> readPopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamPopDepObj updatePopDep( ICFBamPopDepObj Obj );

	/**
	 *	Internal use only.
	 */
	void deletePopDep( ICFBamPopDepObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argId	The PopDep key attribute of the instance generating the id.
	 */
	void deletePopDepByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The PopDep key attribute of the instance generating the id.
	 */
	void deletePopDepByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRelationTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argRelationId	The PopDep key attribute of the instance generating the id.
	 */
	void deletePopDepByRelationIdx( long RelationTenantId,
		long RelationId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The PopDep key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The PopDep key attribute of the instance generating the id.
	 */
	void deletePopDepByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );
}
