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

public interface ICFGenKbSecGrpIncTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecGrpInc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSecGrpIncObj newInstance();

	/**
	 *	Instantiate a new SecGrpInc edition of the specified SecGrpInc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSecGrpIncEditObj newEditInstance( ICFGenKbSecGrpIncObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpIncObj realiseSecGrpInc( ICFGenKbSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecGrpInc( ICFGenKbSecGrpIncObj Obj );
	void forgetSecGrpInc( ICFGenKbSecGrpIncObj Obj, boolean forgetSubObjects );
	void forgetSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId );

	void forgetSecGrpIncByClusterIdx( long ClusterId );

	void forgetSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId );

	void forgetSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	void forgetSecGrpIncByUIncludeIdx( long ClusterId,
		int SecGroupId,
		int IncludeGroupId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpIncObj createSecGrpInc( ICFGenKbSecGrpIncObj Obj );

	/**
	 *	Read a SecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecGrpIncObj readSecGrpInc( CFGenKbSecGrpIncPKey pkey );

	/**
	 *	Read a SecGrpInc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecGrpInc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecGrpIncObj readSecGrpInc( CFGenKbSecGrpIncPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpIncObj lockSecGrpInc( CFGenKbSecGrpIncPKey pkey );

	/**
	 *	Return a sorted list of all the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readAllSecGrpInc();

	/**
	 *	Return a sorted map of all the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readAllSecGrpInc( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecGrpInc-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecGrpIncObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> pageAllSecGrpInc(Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Get the CFGenKbSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpIncObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpIncObj readSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId );

	/**
	 *	Get the CFGenKbSecGrpIncObj instance for the primary key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpIncObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpIncObj readSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecGrpIncObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpIncObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFGenKbSecGrpIncObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpIncObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readSecGrpIncByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Get the map of CFGenKbSecGrpIncObj instances sorted by their primary keys for the duplicate GroupIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpIncObj cached instances sorted by their primary keys for the duplicate GroupIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	/**
	 *	Get the map of CFGenKbSecGrpIncObj instances sorted by their primary keys for the duplicate IncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecGrpIncObj cached instances sorted by their primary keys for the duplicate IncludeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> readSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpIncObj cached instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpIncObj readSecGrpIncByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId );

	/**
	 *	Get the CFGenKbSecGrpIncObj instance for the unique UIncludeIdx key.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecGrpIncObj refreshed instance for the unique UIncludeIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecGrpIncObj readSecGrpIncByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ClusterIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> pageSecGrpIncByClusterIdx( long ClusterId,
		Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate GroupIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> pageSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Read a page of data as a List of SecGrpInc-derived instances sorted by their primary keys,
	 *	as identified by the duplicate IncludeIdx key attributes.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecGrpInc-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecGrpIncObj> pageSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId,
		Long priorClusterId,
		Long priorSecGrpIncId );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecGrpIncObj updateSecGrpInc( ICFGenKbSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecGrpInc( ICFGenKbSecGrpIncObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGrpIncId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIdIdx( long ClusterId,
		long SecGrpIncId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByClusterIdx( long ClusterId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByGroupIdx( long ClusterId,
		int SecGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByIncludeIdx( long ClusterId,
		int IncludeGroupId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argSecGroupId	The SecGrpInc key attribute of the instance generating the id.
	 *
	 *	@param	argIncludeGroupId	The SecGrpInc key attribute of the instance generating the id.
	 */
	void deleteSecGrpIncByUIncludeIdx(long ClusterId,
		int SecGroupId,
		int IncludeGroupId );
}
