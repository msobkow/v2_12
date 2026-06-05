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

public interface ICFBamBlobColTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new BlobCol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamBlobColObj newInstance();

	/**
	 *	Instantiate a new BlobCol edition of the specified BlobCol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamBlobColEditObj newEditInstance( ICFBamBlobColObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamBlobColObj realiseBlobCol( ICFBamBlobColObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetBlobCol( ICFBamBlobColObj Obj );
	void forgetBlobCol( ICFBamBlobColObj Obj, boolean forgetSubObjects );
	void forgetBlobColByIdIdx( long TenantId,
		long Id );

	void forgetBlobColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetBlobColByValTentIdx( long TenantId );

	void forgetBlobColByScopeIdx( long TenantId,
		long ScopeId );

	void forgetBlobColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetBlobColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetBlobColByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetBlobColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetBlobColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	void forgetBlobColByTableIdx( long TenantId,
		long TableId );


	/**
	 *	Internal use only.
	 */
	ICFBamBlobColObj createBlobCol( ICFBamBlobColObj Obj );

	/**
	 *	Read a BlobCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BlobCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBlobColObj readBlobCol( CFBamValuePKey pkey );

	/**
	 *	Read a BlobCol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The BlobCol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamBlobColObj readBlobCol( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBlobColObj lockBlobCol( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the BlobCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamBlobColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBlobColObj> readAllBlobCol();

	/**
	 *	Return a sorted map of all the BlobCol-derived instances in the database.
	 *
	 *	@return	List of ICFBamBlobColObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamBlobColObj> readAllBlobCol( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobColObj readBlobColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobColObj readBlobColByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobColObj readBlobColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamBlobColObj readBlobColByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamBlobColObj instances sorted by their primary keys for the duplicate TableIdx key.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamBlobColObj cached instances sorted by their primary keys for the duplicate TableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamBlobColObj> readBlobColByTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamBlobColObj updateBlobCol( ICFBamBlobColObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteBlobCol( ICFBamBlobColObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argName	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The BlobCol key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The BlobCol key attribute of the instance generating the id.
	 */
	void deleteBlobColByTableIdx( long TenantId,
		long TableId );

	/**
	 *	Move the CFBamBlobColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBlobColObj refreshed cache instance.
	 */
	ICFBamBlobColObj moveUpBlobCol( ICFBamBlobColObj Obj );

	/**
	 *	Move the CFBamBlobColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamBlobColObj refreshed cache instance.
	 */
	ICFBamBlobColObj moveDownBlobCol( ICFBamBlobColObj Obj );
}
