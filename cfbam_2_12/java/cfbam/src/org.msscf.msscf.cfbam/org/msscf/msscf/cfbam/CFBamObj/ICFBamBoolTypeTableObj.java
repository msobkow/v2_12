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

public interface ICFBamBoolTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new BoolType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamBoolTypeObj newInstance();

	/**
	 *	Instantiate a new BoolType edition of the specified BoolType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamBoolTypeEditObj newEditInstance( ICFBamBoolTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamBoolTypeObj realiseBoolType( ICFBamBoolTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetBoolType( ICFBamBoolTypeObj Obj );
	void forgetBoolType( ICFBamBoolTypeObj Obj, boolean forgetSubObjects );
	void forgetBoolTypeByIdIdx( long TenantId,
		long Id );

	void forgetBoolTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetBoolTypeByValTentIdx( long TenantId );

	void forgetBoolTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetBoolTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetBoolTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetBoolTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetBoolTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetBoolTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetBoolTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamBoolTypeObj createBoolType( ICFBamBoolTypeObj Obj );

	/**
	 *	Read a BoolType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BoolType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBoolTypeObj readBoolType( CFBamValuePKey pkey );

	/**
	 *	Read a BoolType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BoolType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBoolTypeObj readBoolType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBoolTypeObj lockBoolType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the BoolType-derived instances in the database.
	 *
	 *	@return	List of ICFBamBoolTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBoolTypeObj> readAllBoolType();

	/**
	 *	Return a sorted map of all the BoolType-derived instances in the database.
	 *
	 *	@return	List of ICFBamBoolTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBoolTypeObj> readAllBoolType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolTypeObj readBoolTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolTypeObj readBoolTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolTypeObj readBoolTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBoolTypeObj readBoolTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamBoolTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBoolTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBoolTypeObj> readBoolTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBoolTypeObj updateBoolType( ICFBamBoolTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteBoolType( ICFBamBoolTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BoolType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The BoolType key attribute of the instance generating the id.
	 */
	void deleteBoolTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamBoolTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBoolTypeObj refreshed cache instance.
	 */
	ICFBamBoolTypeObj moveUpBoolType( ICFBamBoolTypeObj Obj );

	/**
	 *	Move the CFBamBoolTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBoolTypeObj refreshed cache instance.
	 */
	ICFBamBoolTypeObj moveDownBoolType( ICFBamBoolTypeObj Obj );
}
