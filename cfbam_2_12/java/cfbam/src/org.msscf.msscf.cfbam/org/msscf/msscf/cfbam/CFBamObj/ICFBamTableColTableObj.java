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

public interface ICFBamTableColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TableCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTableColObj newInstance();

	/**
	 *	Instantiate a new TableCol edition of the specified TableCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTableColEditObj newEditInstance( ICFBamTableColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTableColObj realiseTableCol( ICFBamTableColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTableCol( ICFBamTableColObj Obj );
	void forgetTableCol( ICFBamTableColObj Obj, boolean forgetSubObjects );
	void forgetTableColByIdIdx( long TenantId,
		long Id );

	void forgetTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTableColByValTentIdx( long TenantId );

	void forgetTableColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTableColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTableColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTableColByTableIdx( long TenantId,
		long TableId );

	void forgetTableColByDataIdx( Long DataTenantId,
		Long DataId );


	/**
	 *	Internal use only.
	 */
	ICFBamTableColObj createTableCol( ICFBamTableColObj Obj );

	/**
	 *	Read a TableCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TableCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTableColObj readTableCol( CFBamValuePKey pkey );

	/**
	 *	Read a TableCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TableCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTableColObj readTableCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTableColObj lockTableCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TableCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTableColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTableColObj> readAllTableCol();

	/**
	 *	Return a sorted map of all the TableCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamTableColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTableColObj> readAllTableCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableColObj readTableColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableColObj readTableColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableColObj readTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTableColObj readTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate DataIdx key.
	 *
	 *	@param	argDataTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argDataId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate DataIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByDataIdx( Long DataTenantId,
		Long DataId );

	/**
	 *	Get the map of CFBamTableColObj instances sorted by their primary keys for the duplicate DataIdx key.
	 *
	 *	@param	argDataTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argDataId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTableColObj cached instances sorted by their primary keys for the duplicate DataIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTableColObj> readTableColByDataIdx( Long DataTenantId,
		Long DataId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTableColObj updateTableCol( ICFBamTableColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTableCol( ICFBamTableColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDataTenantId	The TableCol key attribute of the instance generating the id.
	 *
	 *	@param	argDataId	The TableCol key attribute of the instance generating the id.
	 */
	void deleteTableColByDataIdx( Long DataTenantId,
		Long DataId );

	/**
	 *	Move the CFBamTableColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTableColObj refreshed cache instance.
	 */
	ICFBamTableColObj moveUpTableCol( ICFBamTableColObj Obj );

	/**
	 *	Move the CFBamTableColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTableColObj refreshed cache instance.
	 */
	ICFBamTableColObj moveDownTableCol( ICFBamTableColObj Obj );
}
