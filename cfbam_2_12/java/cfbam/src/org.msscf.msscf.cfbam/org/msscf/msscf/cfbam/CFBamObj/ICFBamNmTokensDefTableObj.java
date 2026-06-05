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

public interface ICFBamNmTokensDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new NmTokensDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamNmTokensDefObj newInstance();

	/**
	 *	Instantiate a new NmTokensDef edition of the specified NmTokensDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamNmTokensDefEditObj newEditInstance( ICFBamNmTokensDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensDefObj realiseNmTokensDef( ICFBamNmTokensDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetNmTokensDef( ICFBamNmTokensDefObj Obj );
	void forgetNmTokensDef( ICFBamNmTokensDefObj Obj, boolean forgetSubObjects );
	void forgetNmTokensDefByIdIdx( long TenantId,
		long Id );

	void forgetNmTokensDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetNmTokensDefByValTentIdx( long TenantId );

	void forgetNmTokensDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetNmTokensDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetNmTokensDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetNmTokensDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetNmTokensDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetNmTokensDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensDefObj createNmTokensDef( ICFBamNmTokensDefObj Obj );

	/**
	 *	Read a NmTokensDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokensDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokensDefObj readNmTokensDef( CFBamValuePKey pkey );

	/**
	 *	Read a NmTokensDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NmTokensDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNmTokensDefObj readNmTokensDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensDefObj lockNmTokensDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the NmTokensDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokensDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokensDefObj> readAllNmTokensDef();

	/**
	 *	Return a sorted map of all the NmTokensDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamNmTokensDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNmTokensDefObj> readAllNmTokensDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensDefObj readNmTokensDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensDefObj readNmTokensDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensDefObj readNmTokensDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNmTokensDefObj readNmTokensDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamNmTokensDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNmTokensDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNmTokensDefObj> readNmTokensDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNmTokensDefObj updateNmTokensDef( ICFBamNmTokensDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNmTokensDef( ICFBamNmTokensDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NmTokensDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NmTokensDef key attribute of the instance generating the id.
	 */
	void deleteNmTokensDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamNmTokensDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokensDefObj refreshed cache instance.
	 */
	ICFBamNmTokensDefObj moveUpNmTokensDef( ICFBamNmTokensDefObj Obj );

	/**
	 *	Move the CFBamNmTokensDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNmTokensDefObj refreshed cache instance.
	 */
	ICFBamNmTokensDefObj moveDownNmTokensDef( ICFBamNmTokensDefObj Obj );
}
