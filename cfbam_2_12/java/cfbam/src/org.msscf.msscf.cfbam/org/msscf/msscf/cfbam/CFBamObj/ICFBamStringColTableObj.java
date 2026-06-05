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

public interface ICFBamStringColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new StringCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamStringColObj newInstance();

	/**
	 *	Instantiate a new StringCol edition of the specified StringCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamStringColEditObj newEditInstance( ICFBamStringColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamStringColObj realiseStringCol( ICFBamStringColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetStringCol( ICFBamStringColObj Obj );
	void forgetStringCol( ICFBamStringColObj Obj, boolean forgetSubObjects );
	void forgetStringColByIdIdx( long TenantId,
		long Id );

	void forgetStringColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetStringColByValTentIdx( long TenantId );

	void forgetStringColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetStringColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetStringColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetStringColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetStringColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetStringColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetStringColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamStringColObj createStringCol( ICFBamStringColObj Obj );

	/**
	 *	Read a StringCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The StringCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamStringColObj readStringCol( CFBamValuePKey pkey );

	/**
	 *	Read a StringCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The StringCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamStringColObj readStringCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamStringColObj lockStringCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the StringCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamStringColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamStringColObj> readAllStringCol();

	/**
	 *	Return a sorted map of all the StringCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamStringColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamStringColObj> readAllStringCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringColObj readStringColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringColObj readStringColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringColObj readStringColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamStringColObj readStringColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamStringColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamStringColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamStringColObj> readStringColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamStringColObj updateStringCol( ICFBamStringColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteStringCol( ICFBamStringColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The StringCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The StringCol key attribute of the instance generating the id.
	 */
	void deleteStringColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamStringColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamStringColObj refreshed cache instance.
	 */
	ICFBamStringColObj moveUpStringCol( ICFBamStringColObj Obj );

	/**
	 *	Move the CFBamStringColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamStringColObj refreshed cache instance.
	 */
	ICFBamStringColObj moveDownStringCol( ICFBamStringColObj Obj );
}
