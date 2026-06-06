// Description: Java 11 Table Object interface for CFBam.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	These files are part of MSS Code Factory Version 2.12.
 *
 *	MSS Code Factory is available under the terms of the GNU General Public License,
 *	Version 3 or later.
 *
 *	MSS Code Factory is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
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

public interface ICFBamBlobTypeTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new BlobType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamBlobTypeObj newInstance();

	/**
	 *	Instantiate a new BlobType edition of the specified BlobType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamBlobTypeEditObj newEditInstance( ICFBamBlobTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamBlobTypeObj realiseBlobType( ICFBamBlobTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetBlobType( ICFBamBlobTypeObj Obj );
	void forgetBlobType( ICFBamBlobTypeObj Obj, boolean forgetSubObjects );
	void forgetBlobTypeByIdIdx( long TenantId,
		long Id );

	void forgetBlobTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetBlobTypeByValTentIdx( long TenantId );

	void forgetBlobTypeByScopeIdx( long TenantId,
		long ScopeId );

	void forgetBlobTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetBlobTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetBlobTypeByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetBlobTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetBlobTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetBlobTypeBySchemaIdx( long TenantId,
		long SchemaDefId );


	/**
	 *	Internal use only.
	 */
	ICFBamBlobTypeObj createBlobType( ICFBamBlobTypeObj Obj );

	/**
	 *	Read a BlobType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BlobType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBlobTypeObj readBlobType( CFBamValuePKey pkey );

	/**
	 *	Read a BlobType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BlobType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBlobTypeObj readBlobType( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBlobTypeObj lockBlobType( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the BlobType-derived instances in the database.
	 *
	 *	@return	List of ICFBamBlobTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBlobTypeObj> readAllBlobType();

	/**
	 *	Return a sorted map of all the BlobType-derived instances in the database.
	 *
	 *	@return	List of ICFBamBlobTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBlobTypeObj> readAllBlobType( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobTypeObj readBlobTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobTypeObj readBlobTypeByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobTypeObj readBlobTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobTypeObj readBlobTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Get the map of CFBamBlobTypeObj instances sorted by their primary keys for the duplicate SchemaIdx key.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobTypeObj cached instances sorted by their primary keys for the duplicate SchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobTypeObj> readBlobTypeBySchemaIdx( long TenantId,
		long SchemaDefId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBlobTypeObj updateBlobType( ICFBamBlobTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteBlobType( ICFBamBlobTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobType key attribute of the instance generating the id.
	 *
	 *	@param	argSchemaDefId	The BlobType key attribute of the instance generating the id.
	 */
	void deleteBlobTypeBySchemaIdx( long TenantId,
		long SchemaDefId );

	/**
	 *	Move the CFBamBlobTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBlobTypeObj refreshed cache instance.
	 */
	ICFBamBlobTypeObj moveUpBlobType( ICFBamBlobTypeObj Obj );

	/**
	 *	Move the CFBamBlobTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBlobTypeObj refreshed cache instance.
	 */
	ICFBamBlobTypeObj moveDownBlobType( ICFBamBlobTypeObj Obj );
}
