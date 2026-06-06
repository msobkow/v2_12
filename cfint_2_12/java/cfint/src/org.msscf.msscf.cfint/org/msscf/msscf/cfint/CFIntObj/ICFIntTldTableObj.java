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

public interface ICFIntTldTableObj
{
	ICFIntSchemaObj getSchema();
	void setSchema( ICFIntSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new Tld instance.
	 *
	 *	@return	A new instance.
	 */
	ICFIntTldObj newInstance();

	/**
	 *	Instantiate a new Tld edition of the specified Tld instance.
	 *
	 *	@return	A new edition.
	 */
	ICFIntTldEditObj newEditInstance( ICFIntTldObj orig );

	/**
	 *	Internal use only.
	 */
	ICFIntTldObj realiseTld( ICFIntTldObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetTld( ICFIntTldObj Obj );
	void forgetTld( ICFIntTldObj Obj, boolean forgetSubObjects );
	void forgetTldByIdIdx( long TenantId,
		long Id );

	void forgetTldByTenantIdx( long TenantId );

	void forgetTldByNameIdx( long TenantId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFIntTldObj createTld( ICFIntTldObj Obj );

	/**
	 *	Read a Tld-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tld-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntTldObj readTld( CFIntTldPKey pkey );

	/**
	 *	Read a Tld-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The Tld-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntTldObj readTld( CFIntTldPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntTldObj lockTld( CFIntTldPKey pkey );

	/**
	 *	Return a sorted list of all the Tld-derived instances in the database.
	 *
	 *	@return	List of ICFIntTldObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntTldObj> readAllTld();

	/**
	 *	Return a sorted map of all the Tld-derived instances in the database.
	 *
	 *	@return	List of ICFIntTldObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntTldObj> readAllTld( boolean forceRead );

	/**
	 *	Get the CFIntTldObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTldObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntTldObj readTldByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFIntTldObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTldObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntTldObj readTldByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFIntTldObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTldObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTldObj> readTldByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFIntTldObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntTldObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntTldObj> readTldByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the CFIntTldObj instance for the unique NameIdx key.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTldObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntTldObj readTldByNameIdx(long TenantId,
		String Name );

	/**
	 *	Get the CFIntTldObj instance for the unique NameIdx key.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Tld key attribute of the instance generating the id.
	 *
	 *	@return	CFIntTldObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntTldObj readTldByNameIdx(long TenantId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntTldObj updateTld( ICFIntTldObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteTld( ICFIntTldObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@param	argId	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The Tld key attribute of the instance generating the id.
	 *
	 *	@param	argName	The Tld key attribute of the instance generating the id.
	 */
	void deleteTldByNameIdx(long TenantId,
		String Name );
}
