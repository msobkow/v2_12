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

public interface ICFBamRelationTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Relation instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamRelationObj newInstance();

	/**
	 *	Instantiate a new Relation edition of the specified Relation instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamRelationEditObj newEditInstance( ICFBamRelationObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamRelationObj realiseRelation( ICFBamRelationObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetRelation( ICFBamRelationObj Obj );
	void forgetRelation( ICFBamRelationObj Obj, boolean forgetSubObjects );
	void forgetRelationByIdIdx( long TenantId,
		long Id );

	void forgetRelationByTenantIdx( long TenantId );

	void forgetRelationByUNameIdx( long TenantId,
		long TableId,
		String Name );

	void forgetRelationByRelnTenantIdx( long TenantId );

	void forgetRelationByRelTableIdx( long TenantId,
		long TableId );

	void forgetRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetRelationByFromKeyIdx( long TenantId,
		long FromIndexId );

	void forgetRelationByToTblIdx( long TenantId,
		long ToTableId );

	void forgetRelationByToKeyIdx( long TenantId,
		long ToIndexId );

	void forgetRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId );


	/**
	 *	Internal use only.
	 */
	ICFBamRelationObj createRelation( ICFBamRelationObj Obj );

	/**
	 *	Read a Relation-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Relation-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamRelationObj readRelation( CFBamScopePKey pkey );

	/**
	 *	Read a Relation-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Relation-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamRelationObj readRelation( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamRelationObj lockRelation( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the Relation-derived instances in the database.
	 *
	 *	@return	List of ICFBamRelationObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamRelationObj> readAllRelation();

	/**
	 *	Return a sorted map of all the Relation-derived instances in the database.
	 *
	 *	@return	List of ICFBamRelationObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamRelationObj> readAllRelation( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamRelationObj readRelationByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamRelationObj readRelationByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the CFBamRelationObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	CFBamRelationObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamRelationObj readRelationByUNameIdx(long TenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamRelationObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	CFBamRelationObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamRelationObj readRelationByUNameIdx(long TenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate RelnTenantIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate RelnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByRelnTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate RelnTenantIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate RelnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByRelnTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate RelTableIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate RelTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByRelTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate RelTableIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate RelTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByRelTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate FromKeyIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argFromIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate FromKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByFromKeyIdx( long TenantId,
		long FromIndexId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate FromKeyIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argFromIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate FromKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByFromKeyIdx( long TenantId,
		long FromIndexId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate ToTblIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argToTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate ToTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByToTblIdx( long TenantId,
		long ToTableId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate ToTblIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argToTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate ToTblIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByToTblIdx( long TenantId,
		long ToTableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate ToKeyIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argToIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate ToKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByToKeyIdx( long TenantId,
		long ToIndexId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate ToKeyIdx key.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argToIndexId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate ToKeyIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByToKeyIdx( long TenantId,
		long ToIndexId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate NarrowedIdx key.
	 *
	 *	@param	argNarrowedTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argNarrowedId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate NarrowedIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId );

	/**
	 *	Get the map of CFBamRelationObj instances sorted by their primary keys for the duplicate NarrowedIdx key.
	 *
	 *	@param	argNarrowedTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argNarrowedId	The Relation key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamRelationObj cached instances sorted by their primary keys for the duplicate NarrowedIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamRelationObj> readRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamRelationObj updateRelation( ICFBamRelationObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteRelation( ICFBamRelationObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByUNameIdx(long TenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByRelnTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByRelTableIdx( long TenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argFromIndexId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByFromKeyIdx( long TenantId,
		long FromIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argToTableId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByToTblIdx( long TenantId,
		long ToTableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argToIndexId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByToKeyIdx( long TenantId,
		long ToIndexId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNarrowedTenantId	The Relation key attribute of the instance generating the id.
	 *
	 *	@param	argNarrowedId	The Relation key attribute of the instance generating the id.
	 */
	void deleteRelationByNarrowedIdx( Long NarrowedTenantId,
		Long NarrowedId );
}
