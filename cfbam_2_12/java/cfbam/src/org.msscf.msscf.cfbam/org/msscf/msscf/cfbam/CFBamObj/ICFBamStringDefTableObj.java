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

public interface ICFBamStringDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new StringDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamStringDefObj newInstance();

	/**
	 *	Instantiate a new StringDef edition of the specified StringDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamStringDefEditObj newEditInstance( ICFBamStringDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamStringDefObj realiseStringDef( ICFBamStringDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetStringDef( ICFBamStringDefObj Obj );
	void forgetStringDef( ICFBamStringDefObj Obj, boolean forgetSubObjects );
	void forgetStringDefByIdIdx( long TenantId,
		long Id );

	void forgetStringDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetStringDefByValTentIdx( long TenantId );

	void forgetStringDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetStringDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetStringDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetStringDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetStringDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetStringDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamStringDefObj createStringDef( ICFBamStringDefObj Obj );

	/**
	 *	Read a StringDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The StringDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamStringDefObj readStringDef( CFBamValuePKey pkey );

	/**
	 *	Read a StringDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The StringDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamStringDefObj readStringDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamStringDefObj lockStringDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the StringDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamStringDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamStringDefObj> readAllStringDef();

	/**
	 *	Return a sorted map of all the StringDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamStringDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamStringDefObj> readAllStringDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringDefObj readStringDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringDefObj readStringDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringDefObj readStringDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringDefObj readStringDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamStringDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringDefObj> readStringDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamStringDefObj updateStringDef( ICFBamStringDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteStringDef( ICFBamStringDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringDef key attribute of the instance generating the id.
	 */
	void deleteStringDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamStringDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamStringDefObj refreshed cache instance.
	 */
	ICFBamStringDefObj moveUpStringDef( ICFBamStringDefObj Obj );

	/**
	 *	Move the CFBamStringDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamStringDefObj refreshed cache instance.
	 */
	ICFBamStringDefObj moveDownStringDef( ICFBamStringDefObj Obj );
}
