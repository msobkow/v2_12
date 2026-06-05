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

public interface ICFBamTextTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TextType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamTextTypeObj newInstance();

	/**
	 *	Instantiate a new TextType edition of the specified TextType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamTextTypeEditObj newEditInstance( ICFBamTextTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamTextTypeObj realiseTextType( ICFBamTextTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTextType( ICFBamTextTypeObj Obj );
	void forgetTextType( ICFBamTextTypeObj Obj, boolean forgetSubObjects );
	void forgetTextTypeByIdIdx( long TenantId,
		long Id );

	void forgetTextTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetTextTypeByValTentIdx( long TenantId );

	void forgetTextTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetTextTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetTextTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetTextTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetTextTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetTextTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetTextTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamTextTypeObj createTextType( ICFBamTextTypeObj Obj );

	/**
	 *	Read a TextType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTextTypeObj readTextType( CFBamValuePKey pkey );

	/**
	 *	Read a TextType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TextType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamTextTypeObj readTextType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTextTypeObj lockTextType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the TextType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTextTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTextTypeObj> readAllTextType();

	/**
	 *	Return a sorted map of all the TextType-derived instances in the database.
	 *
	 *	@return	List of ICFBamTextTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamTextTypeObj> readAllTextType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextTypeObj readTextTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextTypeObj readTextTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextTypeObj readTextTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamTextTypeObj readTextTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamTextTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TextType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamTextTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamTextTypeObj> readTextTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamTextTypeObj updateTextType( ICFBamTextTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTextType( ICFBamTextTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TextType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The TextType key attribute of the instance generating the id.
	 */
	void deleteTextTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamTextTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTextTypeObj refreshed cache instance.
	 */
	ICFBamTextTypeObj moveUpTextType( ICFBamTextTypeObj Obj );

	/**
	 *	Move the CFBamTextTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamTextTypeObj refreshed cache instance.
	 */
	ICFBamTextTypeObj moveDownTextType( ICFBamTextTypeObj Obj );
}
