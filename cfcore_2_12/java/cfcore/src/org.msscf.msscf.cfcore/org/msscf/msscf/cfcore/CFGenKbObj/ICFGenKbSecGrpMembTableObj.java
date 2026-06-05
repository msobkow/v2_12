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

public interface ICFGenKbSecGrpMembTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecGrpMemb instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSecGrpMembObj newInstance();

	/**
	 *	Instantiate a new SecGrpMemb edition of the specified SecGrpMemb instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSecGrpMembEditObj newEditInstance( ICFGenKbSecGrpMembObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpMembObj realiseSecGrpMemb( ICFGenKbSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecGrpMemb( ICFGenKbSecGrpMembObj Obj );
	void forgetSecGrpMemb( ICFGenKbSecGrpMembObj Obj, boolean forgetSubObjects );
	void forgetSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId );

	void forgetSecGrpMembByClusterIdx( long ClusterId );

	void forgetSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId );

	void forgetSecGrpMembByUserIdx( UUID SecUserId );

	void forgetSecGrpMembByUUserIdx( long ClusterId,
		int SecGroupId,
		UUID SecUserId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpMembObj createSecGrpMemb( ICFGenKbSecGrpMembObj Obj );

	/**
	 *	Read a SecGrpMemb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpMemb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecGrpMembObj readSecGrpMemb( CFGenKbSecGrpMembPKey pkey );

	/**
	 *	Read a SecGrpMemb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpMemb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecGrpMembObj readSecGrpMemb( CFGenKbSecGrpMembPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpMembObj lockSecGrpMemb( CFGenKbSecGrpMembPKey pkey );

	/**
	 *	Return a sorted list of all the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readAllSecGrpMemb();

	/**
	 *	Return a sorted map of all the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readAllSecGrpMemb( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecGrpMemb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpMembObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> pageAllSecGrpMemb(Long priorClusterId,
		Long priorSecGrpMembId );

	/**
	 *	Get the CFGenKbSecGrpMembObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpMembObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpMembObj readSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId );

	/**
	 *	Get the CFGenKbSecGrpMembObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpMembObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpMembObj readSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecGrpMembObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpMembObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFGenKbSecGrpMembObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpMembObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readSecGrpMembByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecGrpMembObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpMembObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Get the map of CFGenKbSecGrpMembObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpMembObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecGrpMembObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpMembObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readSecGrpMembByUserIdx( UUID SecUserId );

	/**
	 *	Get the map of CFGenKbSecGrpMembObj instances sorted by their primary keys for the duplicate UserIdx key.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpMembObj cached instances sorted by their primary keys for the duplicate UserIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> readSecGrpMembByUserIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbSecGrpMembObj instance for the unique UUserIdx key.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpMembObj cached instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpMembObj readSecGrpMembByUUserIdx(long ClusterId,
		int SecGroupId,
		UUID SecUserId );

	/**
	 *	Get the CFGenKbSecGrpMembObj instance for the unique UUserIdx key.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpMembObj refreshed instance for the unique UUserIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpMembObj readSecGrpMembByUUserIdx(long ClusterId,
		int SecGroupId,
		UUID SecUserId,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> pageSecGrpMembByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGrpMembId );

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> pageSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpMembId );

	/**
	 *	Read a page of data as a List of SecGrpMemb-derived instances sorted by their primary keys,
	 *	as identified by the duplicate UserIdx key attributes.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpMemb-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecGrpMembObj> pageSecGrpMembByUserIdx( UUID SecUserId,
		Long priorClusterId,
		Long priorSecGrpMembId );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpMembObj updateSecGrpMemb( ICFGenKbSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGrpMemb( ICFGenKbSecGrpMembObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpMembId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByIdIdx( long ClusterId,
		long SecGrpMembId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByUserIdx( UUID SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpMemb key attribute of the instance generating the id.
	 *
	 *	@param	argSecUserId	The SecGrpMemb key attribute of the instance generating the id.
	 */
	void deleteSecGrpMembByUUserIdx(long ClusterId,
		int SecGroupId,
		UUID SecUserId );
}
