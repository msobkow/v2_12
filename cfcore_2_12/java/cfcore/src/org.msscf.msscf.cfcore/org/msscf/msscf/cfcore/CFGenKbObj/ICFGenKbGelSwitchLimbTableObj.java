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

public interface ICFGenKbGelSwitchLimbTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelSwitchLimb instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelSwitchLimbObj newInstance();

	/**
	 *	Instantiate a new GelSwitchLimb edition of the specified GelSwitchLimb instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelSwitchLimbEditObj newEditInstance( ICFGenKbGelSwitchLimbObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSwitchLimbObj realiseGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj );
	void forgetGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj, boolean forgetSubObjects );
	void forgetGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName );

	void forgetGelSwitchLimbByTenantIdx( long TenantId );

	void forgetGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSwitchLimbObj createGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj );

	/**
	 *	Read a GelSwitchLimb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelSwitchLimb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelSwitchLimbObj readGelSwitchLimb( CFGenKbGelSwitchLimbPKey pkey );

	/**
	 *	Read a GelSwitchLimb-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelSwitchLimb-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelSwitchLimbObj readGelSwitchLimb( CFGenKbGelSwitchLimbPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSwitchLimbObj lockGelSwitchLimb( CFGenKbGelSwitchLimbPKey pkey );

	/**
	 *	Return a sorted list of all the GelSwitchLimb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelSwitchLimbObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelSwitchLimbObj> readAllGelSwitchLimb();

	/**
	 *	Return a sorted map of all the GelSwitchLimb-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelSwitchLimbObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelSwitchLimbObj> readAllGelSwitchLimb( boolean forceRead );

	/**
	 *	Get the CFGenKbGelSwitchLimbObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argLimbName	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelSwitchLimbObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelSwitchLimbObj readGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName );

	/**
	 *	Get the CFGenKbGelSwitchLimbObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argLimbName	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelSwitchLimbObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelSwitchLimbObj readGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSwitchLimbObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSwitchLimbObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelSwitchLimbObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSwitchLimbObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelSwitchLimbObj instances sorted by their primary keys for the duplicate SwitchIdx key.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSwitchLimbObj cached instances sorted by their primary keys for the duplicate SwitchIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the map of CFGenKbGelSwitchLimbObj instances sorted by their primary keys for the duplicate SwitchIdx key.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelSwitchLimbObj cached instances sorted by their primary keys for the duplicate SwitchIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelSwitchLimbObj> readGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelSwitchLimbObj updateGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelSwitchLimb( ICFGenKbGelSwitchLimbObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argLimbName	The GelSwitchLimb key attribute of the instance generating the id.
	 */
	void deleteGelSwitchLimbByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		String LimbName );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 */
	void deleteGelSwitchLimbByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelSwitchLimb key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelSwitchLimb key attribute of the instance generating the id.
	 */
	void deleteGelSwitchLimbBySwitchIdx( long TenantId,
		long GelCacheId,
		long GelInstId );
}
