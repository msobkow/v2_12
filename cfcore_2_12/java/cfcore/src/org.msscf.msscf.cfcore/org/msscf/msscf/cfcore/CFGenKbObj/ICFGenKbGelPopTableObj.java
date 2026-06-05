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

public interface ICFGenKbGelPopTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelPop instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelPopObj newInstance();

	/**
	 *	Instantiate a new GelPop edition of the specified GelPop instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelPopEditObj newEditInstance( ICFGenKbGelPopObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelPopObj realiseGelPop( ICFGenKbGelPopObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelPop( ICFGenKbGelPopObj Obj );
	void forgetGelPop( ICFGenKbGelPopObj Obj, boolean forgetSubObjects );
	void forgetGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelPopByTenantIdx( long TenantId );

	void forgetGelPopByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	void forgetGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelPopObj createGelPop( ICFGenKbGelPopObj Obj );

	/**
	 *	Read a GelPop-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelPop-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelPopObj readGelPop( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelPop-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelPop-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelPopObj readGelPop( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelPopObj lockGelPop( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelPop-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelPopObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelPopObj> readAllGelPop();

	/**
	 *	Return a sorted map of all the GelPop-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelPopObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelPopObj> readAllGelPop( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelPopObj readGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelPopObj readGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelPopObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelPopObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelPopObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelPopObj instances sorted by their primary keys for the duplicate RemainderIdx key.
	 *
	 *	@param	argRemainderTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate RemainderIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );

	/**
	 *	Get the map of CFGenKbGelPopObj instances sorted by their primary keys for the duplicate RemainderIdx key.
	 *
	 *	@param	argRemainderTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelPopObj cached instances sorted by their primary keys for the duplicate RemainderIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelPopObj> readGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelPopObj updateGelPop( ICFGenKbGelPopObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelPop( ICFGenKbGelPopObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argRemainderTenantId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderGelCacheId	The GelPop key attribute of the instance generating the id.
	 *
	 *	@param	argRemainderInstId	The GelPop key attribute of the instance generating the id.
	 */
	void deleteGelPopByRemainderIdx( Long RemainderTenantId,
		long RemainderGelCacheId,
		Long RemainderInstId );
}
