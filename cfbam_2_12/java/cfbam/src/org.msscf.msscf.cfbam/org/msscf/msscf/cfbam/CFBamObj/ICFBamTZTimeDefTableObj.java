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

public interface ICFBamTZTimeDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TZTimeDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTZTimeDefObj newInstance();

	/**
	 *	Instantiate a new TZTimeDef edition of the specified TZTimeDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTZTimeDefEditObj newEditInstance( ICFBamTZTimeDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeDefObj realiseTZTimeDef( ICFBamTZTimeDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTZTimeDef( ICFBamTZTimeDefObj Obj );
	void forgetTZTimeDef( ICFBamTZTimeDefObj Obj, boolean forgetSubObjects );
	void forgetTZTimeDefByIdIdx( long TenantId,
		long Id );

	void forgetTZTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTZTimeDefByValTentIdx( long TenantId );

	void forgetTZTimeDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTZTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTZTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTZTimeDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTZTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTZTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeDefObj createTZTimeDef( ICFBamTZTimeDefObj Obj );

	/**
	 *	Read a TZTimeDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimeDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimeDefObj readTZTimeDef( CFBamValuePKey pkey );

	/**
	 *	Read a TZTimeDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimeDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimeDefObj readTZTimeDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeDefObj lockTZTimeDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TZTimeDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimeDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimeDefObj> readAllTZTimeDef();

	/**
	 *	Return a sorted map of all the TZTimeDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimeDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimeDefObj> readAllTZTimeDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeDefObj readTZTimeDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeDefObj readTZTimeDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeDefObj readTZTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeDefObj readTZTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimeDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeDefObj> readTZTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeDefObj updateTZTimeDef( ICFBamTZTimeDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTZTimeDef( ICFBamTZTimeDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeDef key attribute of the instance generating the id.
	 */
	void deleteTZTimeDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamTZTimeDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimeDefObj refreshed cache instance.
	 */
	ICFBamTZTimeDefObj moveUpTZTimeDef( ICFBamTZTimeDefObj Obj );

	/**
	 *	Move the CFBamTZTimeDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimeDefObj refreshed cache instance.
	 */
	ICFBamTZTimeDefObj moveDownTZTimeDef( ICFBamTZTimeDefObj Obj );
}
