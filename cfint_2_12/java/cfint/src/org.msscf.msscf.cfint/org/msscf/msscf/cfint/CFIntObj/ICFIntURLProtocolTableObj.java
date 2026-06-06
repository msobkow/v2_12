// Description: Java 11 Table Object interface for CFInt.

/*
 *	org.msscf.msscf.CFInt
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
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

public interface ICFIntURLProtocolTableObj
{
	ICFIntSchemaObj getSchema();
	void setSchema( ICFIntSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new URLProtocol instance.
	 *
	 *	@return	A new instance.
	 */
	ICFIntURLProtocolObj newInstance();

	/**
	 *	Instantiate a new URLProtocol edition of the specified URLProtocol instance.
	 *
	 *	@return	A new edition.
	 */
	ICFIntURLProtocolEditObj newEditInstance( ICFIntURLProtocolObj orig );

	/**
	 *	Internal use only.
	 */
	ICFIntURLProtocolObj realiseURLProtocol( ICFIntURLProtocolObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetURLProtocol( ICFIntURLProtocolObj Obj );
	void forgetURLProtocol( ICFIntURLProtocolObj Obj, boolean forgetSubObjects );
	void forgetURLProtocolByIdIdx( int URLProtocolId );

	void forgetURLProtocolByUNameIdx( String Name );

	void forgetURLProtocolByIsSecureIdx( boolean IsSecure );


	/**
	 *	Internal use only.
	 */
	ICFIntURLProtocolObj createURLProtocol( ICFIntURLProtocolObj Obj );

	/**
	 *	Read a URLProtocol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The URLProtocol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntURLProtocolObj readURLProtocol( CFIntURLProtocolPKey pkey );

	/**
	 *	Read a URLProtocol-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The URLProtocol-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntURLProtocolObj readURLProtocol( CFIntURLProtocolPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntURLProtocolObj lockURLProtocol( CFIntURLProtocolPKey pkey );

	/**
	 *	Return a sorted list of all the URLProtocol-derived instances in the database.
	 *
	 *	@return	List of ICFIntURLProtocolObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntURLProtocolObj> readAllURLProtocol();

	/**
	 *	Return a sorted map of all the URLProtocol-derived instances in the database.
	 *
	 *	@return	List of ICFIntURLProtocolObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntURLProtocolObj> readAllURLProtocol( boolean forceRead );

	/**
	 *	Get the CFIntURLProtocolObj instance for the primary key attributes.
	 *
	 *	@param	argURLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	CFIntURLProtocolObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId );

	/**
	 *	Get the CFIntURLProtocolObj instance for the primary key attributes.
	 *
	 *	@param	argURLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	CFIntURLProtocolObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId,
		boolean forceRead );

	/**
	 *	Get the CFIntURLProtocolObj instance for the unique UNameIdx key.
	 *
	 *	@param	argName	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	CFIntURLProtocolObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntURLProtocolObj readURLProtocolByUNameIdx(String Name );

	/**
	 *	Get the CFIntURLProtocolObj instance for the unique UNameIdx key.
	 *
	 *	@param	argName	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	CFIntURLProtocolObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntURLProtocolObj readURLProtocolByUNameIdx(String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFIntURLProtocolObj instances sorted by their primary keys for the duplicate IsSecureIdx key.
	 *
	 *	@param	argIsSecure	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntURLProtocolObj cached instances sorted by their primary keys for the duplicate IsSecureIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure );

	/**
	 *	Get the map of CFIntURLProtocolObj instances sorted by their primary keys for the duplicate IsSecureIdx key.
	 *
	 *	@param	argIsSecure	The URLProtocol key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntURLProtocolObj cached instances sorted by their primary keys for the duplicate IsSecureIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntURLProtocolObj updateURLProtocol( ICFIntURLProtocolObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteURLProtocol( ICFIntURLProtocolObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argURLProtocolId	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByIdIdx( int URLProtocolId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByUNameIdx(String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argIsSecure	The URLProtocol key attribute of the instance generating the id.
	 */
	void deleteURLProtocolByIsSecureIdx( boolean IsSecure );
}
