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

public interface ICFGenKbGelConstrainTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelConstrain instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelConstrainObj newInstance();

	/**
	 *	Instantiate a new GelConstrain edition of the specified GelConstrain instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelConstrainEditObj newEditInstance( ICFGenKbGelConstrainObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelConstrainObj realiseGelConstrain( ICFGenKbGelConstrainObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelConstrain( ICFGenKbGelConstrainObj Obj );
	void forgetGelConstrain( ICFGenKbGelConstrainObj Obj, boolean forgetSubObjects );
	void forgetGelConstrainByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelConstrainByTenantIdx( long TenantId );

	void forgetGelConstrainByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelConstrainByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	void forgetGelConstrainByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelConstrainObj createGelConstrain( ICFGenKbGelConstrainObj Obj );

	/**
	 *	Read a GelConstrain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelConstrain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelConstrainObj readGelConstrain( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelConstrain-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelConstrain-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelConstrainObj readGelConstrain( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelConstrainObj lockGelConstrain( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelConstrain-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelConstrainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readAllGelConstrain();

	/**
	 *	Return a sorted map of all the GelConstrain-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelConstrainObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readAllGelConstrain( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelConstrainObj readGelConstrainByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelConstrainObj readGelConstrainByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelConstrainObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelConstrainObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelConstrainObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelConstrainObj instances sorted by their primary keys for the duplicate RemainderIdx key.
	 *
	 *	@param	argRemainderTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate RemainderIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );

	/**
	 *	Get the map of CFGenKbGelConstrainObj instances sorted by their primary keys for the duplicate RemainderIdx key.
	 *
	 *	@param	argRemainderTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelConstrainObj cached instances sorted by their primary keys for the duplicate RemainderIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelConstrainObj> readGelConstrainByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelConstrainObj updateGelConstrain( ICFGenKbGelConstrainObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelConstrain( ICFGenKbGelConstrainObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelConstrain key attribute of the instance generating the id.
	 */
	void deleteGelConstrainByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 */
	void deleteGelConstrainByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 */
	void deleteGelConstrainByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelConstrain key attribute of the instance generating the id.
	 */
	void deleteGelConstrainByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRemainderTenantId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelConstrain key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelConstrain key attribute of the instance generating the id.
	 */
	void deleteGelConstrainByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );
}
