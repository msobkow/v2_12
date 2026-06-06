// Description: Java 11 Table Object interface for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntTopDomainTableObj
{
	ICFIntSchemaObj getSchema();
	void setSchema( ICFIntSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new TopDomain instance.
	 *
	 *	@return	A new instance.
	 */
	ICFIntTopDomainObj newInstance();

	/**
	 *	Instantiate a new TopDomain edition of the specified TopDomain instance.
	 *
	 *	@return	A new edition.
	 */
	ICFIntTopDomainEditObj newEditInstance( ICFIntTopDomainObj orig );

	/**
	 *	Internal use only.
	 */
	ICFIntTopDomainObj realiseTopDomain( ICFIntTopDomainObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTopDomain( ICFIntTopDomainObj Obj );
	void forgetTopDomain( ICFIntTopDomainObj Obj, boolean forgetSubObjects );
	void forgetTopDomainByIdIdx( long TenantId,
		long Id );

	void forgetTopDomainByTenantIdx( long TenantId );

	void forgetTopDomainByTldIdx( long TenantId,
		long TldId );

	void forgetTopDomainByNameIdx( long TenantId,
		long TldId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFIntTopDomainObj createTopDomain( ICFIntTopDomainObj Obj );

	/**
	 *	Read a TopDomain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopDomain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntTopDomainObj readTopDomain( CFIntTopDomainPKey pkey );

	/**
	 *	Read a TopDomain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The TopDomain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntTopDomainObj readTopDomain( CFIntTopDomainPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntTopDomainObj lockTopDomain( CFIntTopDomainPKey pkey );

	/**
	 *	Return a sorted list of all the TopDomain-derived instances in the database.
	 *
	 *	@return	List of ICFIntTopDomainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntTopDomainObj> readAllTopDomain();

	/**
	 *	Return a sorted map of all the TopDomain-derived instances in the database.
	 *
	 *	@return	List of ICFIntTopDomainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntTopDomainObj> readAllTopDomain( boolean forceRead );

	/**
	 *	Get the CFIntTopDomainObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopDomainObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopDomainObj readTopDomainByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFIntTopDomainObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopDomainObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopDomainObj readTopDomainByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFIntTopDomainObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopDomainObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopDomainObj> readTopDomainByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFIntTopDomainObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopDomainObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopDomainObj> readTopDomainByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFIntTopDomainObj instances sorted by their primary keys for the duplicate TldIdx key.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argTldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopDomainObj cached instances sorted by their primary keys for the duplicate TldIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopDomainObj> readTopDomainByTldIdx( long TenantId,
		long TldId );

	/**
	 *	Get the map of CFIntTopDomainObj instances sorted by their primary keys for the duplicate TldIdx key.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argTldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTopDomainObj cached instances sorted by their primary keys for the duplicate TldIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTopDomainObj> readTopDomainByTldIdx( long TenantId,
		long TldId,
		boolean forceRead );

	/**
	 *	Get the CFIntTopDomainObj instance for the unique NameIdx key.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argTldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopDomainObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopDomainObj readTopDomainByNameIdx(long TenantId,
		long TldId,
		String Name );

	/**
	 *	Get the CFIntTopDomainObj instance for the unique NameIdx key.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argTldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTopDomainObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntTopDomainObj readTopDomainByNameIdx(long TenantId,
		long TldId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntTopDomainObj updateTopDomain( ICFIntTopDomainObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTopDomain( ICFIntTopDomainObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argTldId	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByTldIdx( long TenantId,
		long TldId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argTldId	The TopDomain key attribute of the instance generating the id.
	 *
	 *	@param	argName	The TopDomain key attribute of the instance generating the id.
	 */
	void deleteTopDomainByNameIdx(long TenantId,
		long TldId,
		String Name );
}
