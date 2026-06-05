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

public interface ICFGenKbGelInstructionTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new GelInstruction instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbGelInstructionObj newInstance();

	/**
	 *	Instantiate a new GelInstruction edition of the specified GelInstruction instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbGelInstructionEditObj newEditInstance( ICFGenKbGelInstructionObj orig );

	/**
	 *	Construct an appropriate subclass instance based on the specified class code.
	 *
	 *	@param	argClassCode	The class code used to identify the proposed instance class.
	 *
	 *	@return	ICFGenKbGelInstructionObj instance, which may be a subclass of a GelInstruction instance.
	 */
	ICFGenKbGelInstructionObj constructByClassCode( String argClassCode );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelInstructionObj realiseGelInstruction( ICFGenKbGelInstructionObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetGelInstruction( ICFGenKbGelInstructionObj Obj );
	void forgetGelInstruction( ICFGenKbGelInstructionObj Obj, boolean forgetSubObjects );
	void forgetGelInstructionByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	void forgetGelInstructionByTenantIdx( long TenantId );

	void forgetGelInstructionByGelCacheIdx( long TenantId,
		long GelCacheId );

	void forgetGelInstructionByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );


	/**
	 *	Internal use only.
	 */
	ICFGenKbGelInstructionObj createGelInstruction( ICFGenKbGelInstructionObj Obj );

	/**
	 *	Read a GelInstruction-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelInstruction-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelInstructionObj readGelInstruction( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Read a GelInstruction-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The GelInstruction-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbGelInstructionObj readGelInstruction( CFGenKbGelInstructionPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelInstructionObj lockGelInstruction( CFGenKbGelInstructionPKey pkey );

	/**
	 *	Return a sorted list of all the GelInstruction-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelInstructionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readAllGelInstruction();

	/**
	 *	Return a sorted map of all the GelInstruction-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbGelInstructionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readAllGelInstruction( boolean forceRead );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelInstructionObj readGelInstructionByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Get the CFGenKbGelInstructionObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbGelInstructionObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbGelInstructionObj readGelInstructionByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelInstructionObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readGelInstructionByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelInstructionObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readGelInstructionByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelInstructionObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readGelInstructionByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate GelCacheIdx key.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelInstructionObj cached instances sorted by their primary keys for the duplicate GelCacheIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readGelInstructionByGelCacheIdx( long TenantId,
		long GelCacheId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelInstructionObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readGelInstructionByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );

	/**
	 *	Get the map of CFGenKbGelInstructionObj instances sorted by their primary keys for the duplicate ChainIdx key.
	 *
	 *	@param	argChainInstTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbGelInstructionObj cached instances sorted by their primary keys for the duplicate ChainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbGelInstructionObj> readGelInstructionByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbGelInstructionObj updateGelInstruction( ICFGenKbGelInstructionObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteGelInstruction( ICFGenKbGelInstructionObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelInstId	The GelInstruction key attribute of the instance generating the id.
	 */
	void deleteGelInstructionByPIdx( long TenantId,
		long GelCacheId,
		long GelInstId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 */
	void deleteGelInstructionByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 */
	void deleteGelInstructionByGelCacheIdx( long TenantId,
		long GelCacheId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argChainInstTenantId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelCacheId	The GelInstruction key attribute of the instance generating the id.
	 *
	 *	@param	argChainInstGelInstId	The GelInstruction key attribute of the instance generating the id.
	 */
	void deleteGelInstructionByChainIdx( Long ChainInstTenantId,
		Long ChainInstGelCacheId,
		Long ChainInstGelInstId );
}
