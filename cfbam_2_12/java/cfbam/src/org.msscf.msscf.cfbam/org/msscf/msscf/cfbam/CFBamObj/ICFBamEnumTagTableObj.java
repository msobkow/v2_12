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

public interface ICFBamEnumTagTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new EnumTag instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamEnumTagObj newInstance();

	/**
	 *	Instantiate a new EnumTag edition of the specified EnumTag instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamEnumTagEditObj newEditInstance( ICFBamEnumTagObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumTagObj realiseEnumTag( ICFBamEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetEnumTag( ICFBamEnumTagObj Obj );
	void forgetEnumTag( ICFBamEnumTagObj Obj, boolean forgetSubObjects );
	void forgetEnumTagByIdIdx( long TenantId,
		long Id );

	void forgetEnumTagByEnumTagTenantIdx( long TenantId );

	void forgetEnumTagByEnumIdx( long TenantId,
		long EnumId );

	void forgetEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetEnumTagByEnumNameIdx( long TenantId,
		long EnumId,
		String Name );

	void forgetEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetEnumTagByNextIdx( Long NextTenantId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamEnumTagObj createEnumTag( ICFBamEnumTagObj Obj );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamEnumTagObj readEnumTag( CFBamEnumTagPKey pkey );

	/**
	 *	Read a EnumTag-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumTag-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamEnumTagObj readEnumTag( CFBamEnumTagPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumTagObj lockEnumTag( CFBamEnumTagPKey pkey );

	/**
	 *	Return a sorted list of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of ICFBamEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamEnumTagObj> readAllEnumTag();

	/**
	 *	Return a sorted map of all the EnumTag-derived instances in the database.
	 *
	 *	@return	List of ICFBamEnumTagObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamEnumTagObj> readAllEnumTag( boolean forceRead );

	/**
	 *	Get the CFBamEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamEnumTagObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTagObj readEnumTagByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamEnumTagObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamEnumTagObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTagObj readEnumTagByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate EnumTagTenantIdx key.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate EnumTagTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByEnumTagTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate EnumTagTenantIdx key.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate EnumTagTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByEnumTagTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByEnumIdx( long TenantId,
		long EnumId );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate EnumIdx key.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate EnumIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByEnumIdx( long TenantId,
		long EnumId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the CFBamEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamEnumTagObj cached instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTagObj readEnumTagByEnumNameIdx(long TenantId,
		long EnumId,
		String Name );

	/**
	 *	Get the CFBamEnumTagObj instance for the unique EnumNameIdx key.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	CFBamEnumTagObj refreshed instance for the unique EnumNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumTagObj readEnumTagByEnumNameIdx(long TenantId,
		long EnumId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamEnumTagObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumTagObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumTagObj> readEnumTagByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumTagObj updateEnumTag( ICFBamEnumTagObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteEnumTag( ICFBamEnumTagObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumTagTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumIdx( long TenantId,
		long EnumId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argEnumId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByEnumNameIdx(long TenantId,
		long EnumId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The EnumTag key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumTag key attribute of the instance generating the id.
	 */
	void deleteEnumTagByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Move the CFBamEnumTagObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumTagObj refreshed cache instance.
	 */
	ICFBamEnumTagObj moveUpEnumTag( ICFBamEnumTagObj Obj );

	/**
	 *	Move the CFBamEnumTagObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumTagObj refreshed cache instance.
	 */
	ICFBamEnumTagObj moveDownEnumTag( ICFBamEnumTagObj Obj );
}
