// Description: Java 11 Table Object interface for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamServerProcTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ServerProc instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamServerProcObj newInstance();

	/**
	 *	Instantiate a new ServerProc edition of the specified ServerProc instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamServerProcEditObj newEditInstance( ICFBamServerProcObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamServerProcObj realiseServerProc( ICFBamServerProcObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetServerProc( ICFBamServerProcObj Obj );
	void forgetServerProc( ICFBamServerProcObj Obj, boolean forgetSubObjects );
	void forgetServerProcByIdIdx( long TenantId,
		long Id );

	void forgetServerProcByTenantIdx( long TenantId );

	void forgetServerProcByUNameIdx( long TenantId,
		long TableId,
		String Name );

	void forgetServerProcByMethTableIdx( long TenantId,
		long TableId );

	void forgetServerProcByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );


	/**
	 *	Internal use only.
	 */
	ICFBamServerProcObj createServerProc( ICFBamServerProcObj Obj );

	/**
	 *	Read a ServerProc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerProc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServerProcObj readServerProc( CFBamScopePKey pkey );

	/**
	 *	Read a ServerProc-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ServerProc-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamServerProcObj readServerProc( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServerProcObj lockServerProc( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the ServerProc-derived instances in the database.
	 *
	 *	@return	List of ICFBamServerProcObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServerProcObj> readAllServerProc();

	/**
	 *	Return a sorted map of all the ServerProc-derived instances in the database.
	 *
	 *	@return	List of ICFBamServerProcObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamServerProcObj> readAllServerProc( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerProcObj readServerProcByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerProcObj readServerProcByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerProcObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerProcObj> readServerProcByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamServerProcObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerProcObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerProcObj> readServerProcByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the CFBamServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServerMethodObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerProcObj readServerProcByUNameIdx( long TenantId,
		long TableId,
		String Name );

	/**
	 *	Get the CFBamServerMethodObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	CFBamServerMethodObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamServerProcObj readServerProcByUNameIdx( long TenantId,
		long TableId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerProcObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerProcObj> readServerProcByMethTableIdx( long TenantId,
		long TableId );

	/**
	 *	Get the map of CFBamServerProcObj instances sorted by their primary keys for the duplicate MethTableIdx key.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerProcObj cached instances sorted by their primary keys for the duplicate MethTableIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerProcObj> readServerProcByMethTableIdx( long TenantId,
		long TableId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamServerMethodObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerProcObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerProcObj> readServerProcByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamServerProcObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamServerProcObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamServerProcObj> readServerProcByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamServerProcObj updateServerProc( ICFBamServerProcObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteServerProc( ICFBamServerProcObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argId	The ServerProc key attribute of the instance generating the id.
	 */
	void deleteServerProcByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 */
	void deleteServerProcByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argName	The ServerProc key attribute of the instance generating the id.
	 */
	void deleteServerProcByUNameIdx( long TenantId,
		long TableId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argTableId	The ServerProc key attribute of the instance generating the id.
	 */
	void deleteServerProcByMethTableIdx( long TenantId,
		long TableId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The ServerProc key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The ServerProc key attribute of the instance generating the id.
	 */
	void deleteServerProcByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );
}
