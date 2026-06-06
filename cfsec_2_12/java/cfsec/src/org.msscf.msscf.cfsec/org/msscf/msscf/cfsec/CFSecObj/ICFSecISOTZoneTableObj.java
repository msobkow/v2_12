// Description: Java 11 Table Object interface for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public interface ICFSecISOTZoneTableObj
{
	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ISOTZone instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOTZoneObj newInstance();

	/**
	 *	Instantiate a new ISOTZone edition of the specified ISOTZone instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOTZoneEditObj newEditInstance( ICFSecISOTZoneObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj realiseISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetISOTZone( ICFSecISOTZoneObj Obj );
	void forgetISOTZone( ICFSecISOTZoneObj Obj, boolean forgetSubObjects );
	void forgetISOTZoneByIdIdx( short ISOTZoneId );

	void forgetISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	void forgetISOTZoneByUTZNameIdx( String TZName );

	void forgetISOTZoneByIso8601Idx( String Iso8601 );


	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj createISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Read a ISOTZone-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOTZone-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOTZoneObj readISOTZone( CFSecISOTZonePKey pkey );

	/**
	 *	Read a ISOTZone-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOTZone-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOTZoneObj readISOTZone( CFSecISOTZonePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj lockISOTZone( CFSecISOTZonePKey pkey );

	/**
	 *	Return a sorted list of all the ISOTZone-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOTZoneObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOTZoneObj> readAllISOTZone();

	/**
	 *	Return a sorted map of all the ISOTZone-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOTZoneObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOTZoneObj> readAllISOTZone( boolean forceRead );

	/**
	 *	Get the CFSecISOTZoneObj instance for the primary key attributes.
	 *
	 *	@param	argISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId );

	/**
	 *	Get the CFSecISOTZoneObj instance for the primary key attributes.
	 *
	 *	@param	argISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByIdIdx( short ISOTZoneId,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate OffsetIdx key.
	 *
	 *	@param	argTZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	argTZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate OffsetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate OffsetIdx key.
	 *
	 *	@param	argTZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	argTZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate OffsetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset,
		boolean forceRead );

	/**
	 *	Get the CFSecISOTZoneObj instance for the unique UTZNameIdx key.
	 *
	 *	@param	argTZName	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj cached instance for the unique UTZNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByUTZNameIdx(String TZName );

	/**
	 *	Get the CFSecISOTZoneObj instance for the unique UTZNameIdx key.
	 *
	 *	@param	argTZName	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOTZoneObj refreshed instance for the unique UTZNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOTZoneObj readISOTZoneByUTZNameIdx(String TZName,
		boolean forceRead );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate Iso8601Idx key.
	 *
	 *	@param	argIso8601	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate Iso8601Idx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601 );

	/**
	 *	Get the map of CFSecISOTZoneObj instances sorted by their primary keys for the duplicate Iso8601Idx key.
	 *
	 *	@param	argIso8601	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@return	List of CFSecISOTZoneObj cached instances sorted by their primary keys for the duplicate Iso8601Idx key,
	 *		which may be an empty set.
	 */
	List<ICFSecISOTZoneObj> readISOTZoneByIso8601Idx( String Iso8601,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecISOTZoneObj updateISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOTZone( ICFSecISOTZoneObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argISOTZoneId	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByIdIdx( short ISOTZoneId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTZHourOffset	The ISOTZone key attribute of the instance generating the id.
	 *
	 *	@param	argTZMinOffset	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByOffsetIdx( short TZHourOffset,
		short TZMinOffset );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTZName	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByUTZNameIdx(String TZName );

	/**
	 *	Internal use only.
	 *
	 *	@param	argIso8601	The ISOTZone key attribute of the instance generating the id.
	 */
	void deleteISOTZoneByIso8601Idx( String Iso8601 );
}
