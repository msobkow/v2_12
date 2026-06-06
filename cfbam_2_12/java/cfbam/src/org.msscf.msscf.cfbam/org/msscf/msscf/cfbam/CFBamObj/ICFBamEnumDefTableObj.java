// Description: Java 11 Table Object interface for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

public interface ICFBamEnumDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new EnumDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamEnumDefObj newInstance();

	/**
	 *	Instantiate a new EnumDef edition of the specified EnumDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamEnumDefEditObj newEditInstance( ICFBamEnumDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumDefObj realiseEnumDef( ICFBamEnumDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetEnumDef( ICFBamEnumDefObj Obj );
	void forgetEnumDef( ICFBamEnumDefObj Obj, boolean forgetSubObjects );
	void forgetEnumDefByIdIdx( long TenantId,
		long Id );

	void forgetEnumDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	void forgetEnumDefByValTentIdx( long TenantId );

	void forgetEnumDefByScopeIdx( long TenantId,
		long ScopeId );

	void forgetEnumDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	void forgetEnumDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	void forgetEnumDefByNextIdx( Long NextTenantId,
		Long NextId );

	void forgetEnumDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	void forgetEnumDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );


	/**
	 *	Internal use only.
	 */
	ICFBamEnumDefObj createEnumDef( ICFBamEnumDefObj Obj );

	/**
	 *	Read a EnumDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamEnumDefObj readEnumDef( CFBamValuePKey pkey );

	/**
	 *	Read a EnumDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The EnumDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamEnumDefObj readEnumDef( CFBamValuePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumDefObj lockEnumDef( CFBamValuePKey pkey );

	/**
	 *	Return a sorted list of all the EnumDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamEnumDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamEnumDefObj> readAllEnumDef();

	/**
	 *	Return a sorted map of all the EnumDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamEnumDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamEnumDefObj> readAllEnumDef( boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumDefObj readEnumDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamValueObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumDefObj readEnumDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumDefObj readEnumDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Get the CFBamValueObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamValueObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamEnumDefObj readEnumDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByValTentIdx( long TenantId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate ValTentIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ValTentIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByValTentIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate ScopeIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ScopeIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByScopeIdx( long TenantId,
		long ScopeId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate DefSchemaIdx key.
	 *
	 *	@param	argDefSchemaTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate DefSchemaIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate PrevIdx key.
	 *
	 *	@param	argPrevTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate PrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByPrevIdx( Long PrevTenantId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate NextIdx key.
	 *
	 *	@param	argNextTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate NextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByNextIdx( Long NextTenantId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate ContPrevIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ContPrevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamValueObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Get the map of CFBamEnumDefObj instances sorted by their primary keys for the duplicate ContNextIdx key.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamEnumDefObj cached instances sorted by their primary keys for the duplicate ContNextIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamEnumDefObj> readEnumDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamEnumDefObj updateEnumDef( ICFBamEnumDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteEnumDef( ICFBamEnumDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByUNameIdx( long TenantId,
		long ScopeId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByValTentIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByScopeIdx( long TenantId,
		long ScopeId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefSchemaTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefSchemaId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByDefSchemaIdx( Long DefSchemaTenantId,
		Long DefSchemaId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPrevTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByPrevIdx( Long PrevTenantId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argNextTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByNextIdx( Long NextTenantId,
		Long NextId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argPrevId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByContPrevIdx( long TenantId,
		long ScopeId,
		Long PrevId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argScopeId	The EnumDef key attribute of the instance generating the id.
	 *
	 *	@param	argNextId	The EnumDef key attribute of the instance generating the id.
	 */
	void deleteEnumDefByContNextIdx( long TenantId,
		long ScopeId,
		Long NextId );

	/**
	 *	Move the CFBamEnumDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumDefObj refreshed cache instance.
	 */
	ICFBamEnumDefObj moveUpEnumDef( ICFBamEnumDefObj Obj );

	/**
	 *	Move the CFBamEnumDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	CFBamEnumDefObj refreshed cache instance.
	 */
	ICFBamEnumDefObj moveDownEnumDef( ICFBamEnumDefObj Obj );
}
