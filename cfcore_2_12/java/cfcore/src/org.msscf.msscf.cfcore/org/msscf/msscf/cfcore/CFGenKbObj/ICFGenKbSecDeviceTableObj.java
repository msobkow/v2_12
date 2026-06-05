// Description: Java 11 Table Object interface for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbSecDeviceTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecDevice instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSecDeviceObj newInstance();

	/**
	 *	Instantiate a new SecDevice edition of the specified SecDevice instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSecDeviceEditObj newEditInstance( ICFGenKbSecDeviceObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecDeviceObj realiseSecDevice( ICFGenKbSecDeviceObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecDevice( ICFGenKbSecDeviceObj Obj );
	void forgetSecDevice( ICFGenKbSecDeviceObj Obj, boolean forgetSubObjects );
	void forgetSecDeviceByIdIdx( UUID SecUserId,
		String DevName );

	void forgetSecDeviceByNameIdx( UUID SecUserId,
		String DevName );

	void forgetSecDeviceByUserIdx( UUID SecUserId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSecDeviceObj createSecDevice( ICFGenKbSecDeviceObj Obj );

	/**
	 *	Read a SecDevice-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecDevice-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecDeviceObj readSecDevice( CFGenKbSecDevicePKey pkey );

	/**
	 *	Read a SecDevice-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecDevice-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecDeviceObj readSecDevice( CFGenKbSecDevicePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecDeviceObj lockSecDevice( CFGenKbSecDevicePKey pkey );

	/**
	 *	Return a sorted list of all the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecDeviceObj> readAllSecDevice();

	/**
	 *	Return a sorted map of all the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecDeviceObj> readAllSecDevice( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecDevice-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecDeviceObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecDeviceObj> pageAllSecDevice(UUID priorSecUserId,
		String priorDevName );

	/**
	 *	Get the CFGenKbSecDeviceObj instance for the primary key attributes.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	argDevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecDeviceObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecDeviceObj readSecDeviceByIdIdx( UUID SecUserId,
		String DevName );

	/**
	 *	Get the CFGenKbSecDeviceObj instance for the primary key attributes.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	argDevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecDeviceObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecDeviceObj readSecDeviceByIdIdx( UUID SecUserId,
		String DevName,
		boolean forceRead );

	/**
	 *	Get the CFGenKbSecDeviceObj instance for the unique NameIdx key.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	argDevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecDeviceObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecDeviceObj readSecDeviceByNameIdx(UUID SecUserId,
		String DevName );

	/**
	 *	Get the CFGenKbSecDeviceObj instance for the unique NameIdx key.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	argDevName	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecDeviceObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecDeviceObj readSecDeviceByNameIdx(UUID SecUserId,
		String DevName,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecDeviceObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecDeviceObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecDeviceObj> readSecDeviceByUserIdx( UUID SecUserId );

	/**
	 *	Get the map of CFGenKbSecDeviceObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecDeviceObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecDeviceObj> readSecDeviceByUserIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecDevice-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecDevice-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecDeviceObj> pageSecDeviceByUserIdx( UUID SecUserId,
		UUID priorSecUserId,
		String priorDevName );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecDeviceObj updateSecDevice( ICFGenKbSecDeviceObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecDevice( ICFGenKbSecDeviceObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	argDevName	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByIdIdx( UUID SecUserId,
		String DevName );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 *
	 *	@param	argDevName	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByNameIdx(UUID SecUserId,
		String DevName );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecDevice key attribute of the instance generating the id.
	 */
	void deleteSecDeviceByUserIdx( UUID SecUserId );
}
