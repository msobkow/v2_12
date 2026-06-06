// Description: Java 11 Table Object interface for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbToolSetTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ToolSet instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbToolSetObj newInstance();

	/**
	 *	Instantiate a new ToolSet edition of the specified ToolSet instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbToolSetEditObj newEditInstance( ICFGenKbToolSetObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbToolSetObj realiseToolSet( ICFGenKbToolSetObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetToolSet( ICFGenKbToolSetObj Obj );
	void forgetToolSet( ICFGenKbToolSetObj Obj, boolean forgetSubObjects );
	void forgetToolSetByIdIdx( short Id );

	void forgetToolSetByNameIdx( String Name );

	void forgetToolSetByTool0Idx( short ToolId0 );

	void forgetToolSetByTool1Idx( Short ToolId1 );

	void forgetToolSetByTool2Idx( Short ToolId2 );

	void forgetToolSetByTool3Idx( Short ToolId3 );

	void forgetToolSetByTool4Idx( Short ToolId4 );

	void forgetToolSetByTool5Idx( Short ToolId5 );

	void forgetToolSetByTool6Idx( Short ToolId6 );

	void forgetToolSetByTool7Idx( Short ToolId7 );


	/**
	 *	Internal use only.
	 */
	ICFGenKbToolSetObj createToolSet( ICFGenKbToolSetObj Obj );

	/**
	 *	Read a ToolSet-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ToolSet-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbToolSetObj readToolSet( CFGenKbToolSetPKey pkey );

	/**
	 *	Read a ToolSet-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ToolSet-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbToolSetObj readToolSet( CFGenKbToolSetPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbToolSetObj lockToolSet( CFGenKbToolSetPKey pkey );

	/**
	 *	Return a sorted list of all the ToolSet-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbToolSetObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbToolSetObj> readAllToolSet();

	/**
	 *	Return a sorted map of all the ToolSet-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbToolSetObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbToolSetObj> readAllToolSet( boolean forceRead );

	/**
	 *	Get the CFGenKbToolSetObj instance for the primary key attributes.
	 *
	 *	@param	argId	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbToolSetObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbToolSetObj readToolSetByIdIdx( short Id );

	/**
	 *	Get the CFGenKbToolSetObj instance for the primary key attributes.
	 *
	 *	@param	argId	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbToolSetObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbToolSetObj readToolSetByIdIdx( short Id,
		boolean forceRead );

	/**
	 *	Get the CFGenKbToolSetObj instance for the unique NameIdx key.
	 *
	 *	@param	argName	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbToolSetObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbToolSetObj readToolSetByNameIdx(String Name );

	/**
	 *	Get the CFGenKbToolSetObj instance for the unique NameIdx key.
	 *
	 *	@param	argName	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbToolSetObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbToolSetObj readToolSetByNameIdx(String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool0Idx key.
	 *
	 *	@param	argToolId0	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool0Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool0Idx( short ToolId0 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool0Idx key.
	 *
	 *	@param	argToolId0	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool0Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool0Idx( short ToolId0,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool1Idx key.
	 *
	 *	@param	argToolId1	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool1Idx( Short ToolId1 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool1Idx key.
	 *
	 *	@param	argToolId1	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool1Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool1Idx( Short ToolId1,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool2Idx key.
	 *
	 *	@param	argToolId2	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool2Idx( Short ToolId2 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool2Idx key.
	 *
	 *	@param	argToolId2	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool2Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool2Idx( Short ToolId2,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool3Idx key.
	 *
	 *	@param	argToolId3	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool3Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool3Idx( Short ToolId3 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool3Idx key.
	 *
	 *	@param	argToolId3	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool3Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool3Idx( Short ToolId3,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool4Idx key.
	 *
	 *	@param	argToolId4	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool4Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool4Idx( Short ToolId4 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool4Idx key.
	 *
	 *	@param	argToolId4	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool4Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool4Idx( Short ToolId4,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool5Idx key.
	 *
	 *	@param	argToolId5	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool5Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool5Idx( Short ToolId5 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool5Idx key.
	 *
	 *	@param	argToolId5	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool5Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool5Idx( Short ToolId5,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool6Idx key.
	 *
	 *	@param	argToolId6	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool6Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool6Idx( Short ToolId6 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool6Idx key.
	 *
	 *	@param	argToolId6	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool6Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool6Idx( Short ToolId6,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool7Idx key.
	 *
	 *	@param	argToolId7	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool7Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool7Idx( Short ToolId7 );

	/**
	 *	Get the map of CFGenKbToolSetObj instances sorted by their primary keys for the duplicate Tool7Idx key.
	 *
	 *	@param	argToolId7	The ToolSet key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbToolSetObj cached instances sorted by their primary keys for the duplicate Tool7Idx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbToolSetObj> readToolSetByTool7Idx( Short ToolId7,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbToolSetObj updateToolSet( ICFGenKbToolSetObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteToolSet( ICFGenKbToolSetObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argId	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByIdIdx( short Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByNameIdx(String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId0	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool0Idx( short ToolId0 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId1	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool1Idx( Short ToolId1 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId2	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool2Idx( Short ToolId2 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId3	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool3Idx( Short ToolId3 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId4	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool4Idx( Short ToolId4 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId5	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool5Idx( Short ToolId5 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId6	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool6Idx( Short ToolId6 );

	/**
	 *	Internal use only.
	 *
	 *	@param	argToolId7	The ToolSet key attribute of the instance generating the id.
	 */
	void deleteToolSetByTool7Idx( Short ToolId7 );
}
