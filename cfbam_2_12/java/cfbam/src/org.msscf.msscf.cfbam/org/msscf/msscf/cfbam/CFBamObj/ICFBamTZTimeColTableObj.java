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

public interface ICFBamTZTimeColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TZTimeCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTZTimeColObj newInstance();

	/**
	 *	Instantiate a new TZTimeCol edition of the specified TZTimeCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTZTimeColEditObj newEditInstance( ICFBamTZTimeColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeColObj realiseTZTimeCol( ICFBamTZTimeColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTZTimeCol( ICFBamTZTimeColObj Obj );
	void forgetTZTimeCol( ICFBamTZTimeColObj Obj, boolean forgetSubObjects );
	void forgetTZTimeColByIdIdx( long TenantId,
		long Id );

	void forgetTZTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTZTimeColByValTentIdx( long TenantId );

	void forgetTZTimeColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTZTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTZTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTZTimeColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTZTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTZTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTZTimeColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeColObj createTZTimeCol( ICFBamTZTimeColObj Obj );

	/**
	 *	Read a TZTimeCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimeCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimeColObj readTZTimeCol( CFBamValuePKey pkey );

	/**
	 *	Read a TZTimeCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TZTimeCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTZTimeColObj readTZTimeCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeColObj lockTZTimeCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TZTimeCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimeColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimeColObj> readAllTZTimeCol();

	/**
	 *	Return a sorted map of all the TZTimeCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTZTimeColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTZTimeColObj> readAllTZTimeCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeColObj readTZTimeColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeColObj readTZTimeColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeColObj readTZTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTZTimeColObj readTZTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamTZTimeColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTZTimeColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTZTimeColObj> readTZTimeColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTZTimeColObj updateTZTimeCol( ICFBamTZTimeColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTZTimeCol( ICFBamTZTimeColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TZTimeCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TZTimeCol key attribute of the instance generating the id.
	 */
	void deleteTZTimeColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamTZTimeColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimeColObj refreshed cache instance.
	 */
	ICFBamTZTimeColObj moveUpTZTimeCol( ICFBamTZTimeColObj Obj );

	/**
	 *	Move the CFBamTZTimeColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTZTimeColObj refreshed cache instance.
	 */
	ICFBamTZTimeColObj moveDownTZTimeCol( ICFBamTZTimeColObj Obj );
}
