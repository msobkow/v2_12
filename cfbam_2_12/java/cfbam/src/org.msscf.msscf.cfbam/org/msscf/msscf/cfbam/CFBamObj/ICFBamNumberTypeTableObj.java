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

public interface ICFBamNumberTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new NumberType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamNumberTypeObj newInstance();

	/**
	 *	Instantiate a new NumberType edition of the specified NumberType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamNumberTypeEditObj newEditInstance( ICFBamNumberTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamNumberTypeObj realiseNumberType( ICFBamNumberTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetNumberType( ICFBamNumberTypeObj Obj );
	void forgetNumberType( ICFBamNumberTypeObj Obj, boolean forgetSubObjects );
	void forgetNumberTypeByIdIdx( long TenantId,
		long Id );

	void forgetNumberTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetNumberTypeByValTentIdx( long TenantId );

	void forgetNumberTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetNumberTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetNumberTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetNumberTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetNumberTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetNumberTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetNumberTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamNumberTypeObj createNumberType( ICFBamNumberTypeObj Obj );

	/**
	 *	Read a NumberType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNumberTypeObj readNumberType( CFBamValuePKey pkey );

	/**
	 *	Read a NumberType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The NumberType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamNumberTypeObj readNumberType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNumberTypeObj lockNumberType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the NumberType-derived instances in the database.
	 *
	 *	@return	List of ICFBamNumberTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNumberTypeObj> readAllNumberType();

	/**
	 *	Return a sorted map of all the NumberType-derived instances in the database.
	 *
	 *	@return	List of ICFBamNumberTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamNumberTypeObj> readAllNumberType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNumberTypeObj readNumberTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamNumberTypeObj readNumberTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNumberTypeObj readNumberTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamNumberTypeObj readNumberTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamNumberTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamNumberTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamNumberTypeObj> readNumberTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamNumberTypeObj updateNumberType( ICFBamNumberTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteNumberType( ICFBamNumberTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The NumberType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The NumberType key attribute of the instance generating the id.
	 */
	void deleteNumberTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamNumberTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNumberTypeObj refreshed cache instance.
	 */
	ICFBamNumberTypeObj moveUpNumberType( ICFBamNumberTypeObj Obj );

	/**
	 *	Move the CFBamNumberTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamNumberTypeObj refreshed cache instance.
	 */
	ICFBamNumberTypeObj moveDownNumberType( ICFBamNumberTypeObj Obj );
}
