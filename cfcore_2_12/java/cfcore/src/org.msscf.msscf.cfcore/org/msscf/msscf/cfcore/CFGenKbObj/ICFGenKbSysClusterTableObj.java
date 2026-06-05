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

public interface ICFGenKbSysClusterTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SysCluster instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSysClusterObj newInstance();

	/**
	 *	Instantiate a new SysCluster edition of the specified SysCluster instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSysClusterEditObj newEditInstance( ICFGenKbSysClusterObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSysClusterObj realiseSysCluster( ICFGenKbSysClusterObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSysCluster( ICFGenKbSysClusterObj Obj );
	void forgetSysCluster( ICFGenKbSysClusterObj Obj, boolean forgetSubObjects );
	void forgetSysClusterByIdIdx( int SingletonId );

	void forgetSysClusterByClusterIdx( long ClusterId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSysClusterObj createSysCluster( ICFGenKbSysClusterObj Obj );

	/**
	 *	Read a SysCluster-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SysCluster-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSysClusterObj readSysCluster( CFGenKbSysClusterPKey pkey );

	/**
	 *	Read a SysCluster-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SysCluster-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSysClusterObj readSysCluster( CFGenKbSysClusterPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSysClusterObj lockSysCluster( CFGenKbSysClusterPKey pkey );

	/**
	 *	Return a sorted list of all the SysCluster-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSysClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSysClusterObj> readAllSysCluster();

	/**
	 *	Return a sorted map of all the SysCluster-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSysClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSysClusterObj> readAllSysCluster( boolean forceRead );

	/**
	 *	Get the CFGenKbSysClusterObj instance for the primary key attributes.
	 *
	 *	@param	argSingletonId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSysClusterObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSysClusterObj readSysClusterByIdIdx( int SingletonId );

	/**
	 *	Get the CFGenKbSysClusterObj instance for the primary key attributes.
	 *
	 *	@param	argSingletonId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSysClusterObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSysClusterObj readSysClusterByIdIdx( int SingletonId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSysClusterObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSysClusterObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSysClusterObj> readSysClusterByClusterIdx( long ClusterId );

	/**
	 *	Get the map of CFGenKbSysClusterObj instances sorted by their primary keys for the duplicate ClusterIdx key.
	 *
	 *	@param	argClusterId	The SysCluster key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSysClusterObj cached instances sorted by their primary keys for the duplicate ClusterIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSysClusterObj> readSysClusterByClusterIdx( long ClusterId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSysClusterObj updateSysCluster( ICFGenKbSysClusterObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSysCluster( ICFGenKbSysClusterObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSingletonId	The SysCluster key attribute of the instance generating the id.
	 */
	void deleteSysClusterByIdIdx( int SingletonId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argClusterId	The SysCluster key attribute of the instance generating the id.
	 */
	void deleteSysClusterByClusterIdx( long ClusterId );
}
