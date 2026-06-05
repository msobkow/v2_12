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

public interface ICFBamDoubleDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new DoubleDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamDoubleDefObj newInstance();

	/**
	 *	Instantiate a new DoubleDef edition of the specified DoubleDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamDoubleDefEditObj newEditInstance( ICFBamDoubleDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamDoubleDefObj realiseDoubleDef( ICFBamDoubleDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetDoubleDef( ICFBamDoubleDefObj Obj );
	void forgetDoubleDef( ICFBamDoubleDefObj Obj, boolean forgetSubObjects );
	void forgetDoubleDefByIdIdx( long TenantId,
		long Id );

	void forgetDoubleDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetDoubleDefByValTentIdx( long TenantId );

	void forgetDoubleDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetDoubleDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetDoubleDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetDoubleDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetDoubleDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetDoubleDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamDoubleDefObj createDoubleDef( ICFBamDoubleDefObj Obj );

	/**
	 *	Read a DoubleDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDoubleDefObj readDoubleDef( CFBamValuePKey pkey );

	/**
	 *	Read a DoubleDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The DoubleDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamDoubleDefObj readDoubleDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDoubleDefObj lockDoubleDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the DoubleDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamDoubleDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDoubleDefObj> readAllDoubleDef();

	/**
	 *	Return a sorted map of all the DoubleDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamDoubleDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamDoubleDefObj> readAllDoubleDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleDefObj readDoubleDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleDefObj readDoubleDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleDefObj readDoubleDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamDoubleDefObj readDoubleDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamDoubleDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamDoubleDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamDoubleDefObj> readDoubleDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamDoubleDefObj updateDoubleDef( ICFBamDoubleDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteDoubleDef( ICFBamDoubleDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The DoubleDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The DoubleDef key attribute of the instance generating the id.
	 */
	void deleteDoubleDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamDoubleDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDoubleDefObj refreshed cache instance.
	 */
	ICFBamDoubleDefObj moveUpDoubleDef( ICFBamDoubleDefObj Obj );

	/**
	 *	Move the CFBamDoubleDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamDoubleDefObj refreshed cache instance.
	 */
	ICFBamDoubleDefObj moveDownDoubleDef( ICFBamDoubleDefObj Obj );
}
