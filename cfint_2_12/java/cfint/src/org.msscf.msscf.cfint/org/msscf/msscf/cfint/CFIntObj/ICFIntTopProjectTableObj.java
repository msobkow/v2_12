// Description: Java 11 Table Object interface for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntTopProjectTableObj
{
	ICFIntSchemaObj getSchema();
	void setSchema( ICFIntSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TopProject instance.
	 *
	 *	@return	A new instance.
	 */
	ICFIntTopProjectObj newInstance();

	/**
	 *	Instantiate a new TopProject edition of the specified TopProject instance.
	 *
	 *	@return	A new edition.
	 */
	ICFIntTopProjectEditObj newEditInstance( ICFIntTopProjectObj orig );

	/**
	 *	Internal use only.
	 */
	ICFIntTopProjectObj realiseTopProject( ICFIntTopProjectObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTopProject( ICFIntTopProjectObj Obj );
	void forgetTopProject( ICFIntTopProjectObj Obj, boolean forgetSubObjects );
	void forgetTopProjectByIdIdx( long TenantId,
		long Id );

	void forgetTopProjectByTenantIdx( long TenantId );

	void forgetTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId );

	void forgetTopProjectByNameIdx( long TenantId,
		long TopDomainId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFIntTopProjectObj createTopProject( ICFIntTopProjectObj Obj );

	/**
	 *	Read a TopProject-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopProject-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntTopProjectObj readTopProject( CFIntTopProjectPKey pkey );

	/**
	 *	Read a TopProject-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopProject-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntTopProjectObj readTopProject( CFIntTopProjectPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntTopProjectObj lockTopProject( CFIntTopProjectPKey pkey );

	/**
	 *	Return a sorted list of all the TopProject-derived instances in the database.
	 *
	 *	@return	List of ICFIntTopProjectObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntTopProjectObj> readAllTopProject();

	/**
	 *	Return a sorted map of all the TopProject-derived instances in the database.
	 *
	 *	@return	List of ICFIntTopProjectObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntTopProjectObj> readAllTopProject( boolean forceRead );

	/**
	 *	Get the CFIntTopProjectObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopProjectObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopProjectObj readTopProjectByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFIntTopProjectObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopProjectObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopProjectObj readTopProjectByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFIntTopProjectObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopProjectObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopProjectObj> readTopProjectByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFIntTopProjectObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopProjectObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopProjectObj> readTopProjectByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFIntTopProjectObj instances sorted by their primary keys for the duplicate TopDomainIdx key.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopProjectObj cached instances sorted by their primary keys for the duplicate TopDomainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopProjectObj> readTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId );

	/**
	 *	Get the map of CFIntTopProjectObj instances sorted by their primary keys for the duplicate TopDomainIdx key.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopProjectObj cached instances sorted by their primary keys for the duplicate TopDomainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopProjectObj> readTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId,
		boolean forceRead );

	/**
	 *	Get the CFIntTopProjectObj instance for the unique NameIdx key.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopProjectObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopProjectObj readTopProjectByNameIdx(long TenantId,
		long TopDomainId,
		String Name );

	/**
	 *	Get the CFIntTopProjectObj instance for the unique NameIdx key.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TopProject key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopProjectObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopProjectObj readTopProjectByNameIdx(long TenantId,
		long TopDomainId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntTopProjectObj updateTopProject( ICFIntTopProjectObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTopProject( ICFIntTopProjectObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByTopDomainIdx( long TenantId,
		long TopDomainId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The TopProject key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TopProject key attribute of the instance generating the id.
	 */
	void deleteTopProjectByNameIdx(long TenantId,
		long TopDomainId,
		String Name );
}
