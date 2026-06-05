// Description: Java 11 Table Object interface for CFSec.

/*
 *	org.msscf.msscf.CFSec
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

package org.msscf.msscf.cfsec.CFSecObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;

public interface ICFSecISOCcyTableObj
{
	ICFSecSchemaObj getSchema();
	void setSchema( ICFSecSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new ISOCcy instance.
	 *
	 *	@return	A new instance.
	 */
	ICFSecISOCcyObj newInstance();

	/**
	 *	Instantiate a new ISOCcy edition of the specified ISOCcy instance.
	 *
	 *	@return	A new edition.
	 */
	ICFSecISOCcyEditObj newEditInstance( ICFSecISOCcyObj orig );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj realiseISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetISOCcy( ICFSecISOCcyObj Obj );
	void forgetISOCcy( ICFSecISOCcyObj Obj, boolean forgetSubObjects );
	void forgetISOCcyByIdIdx( short ISOCcyId );

	void forgetISOCcyByCcyCdIdx( String ISOCode );

	void forgetISOCcyByCcyNmIdx( String Name );


	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj createISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Read a ISOCcy-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCcyObj readISOCcy( CFSecISOCcyPKey pkey );

	/**
	 *	Read a ISOCcy-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The ISOCcy-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFSecISOCcyObj readISOCcy( CFSecISOCcyPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj lockISOCcy( CFSecISOCcyPKey pkey );

	/**
	 *	Return a sorted list of all the ISOCcy-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCcyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCcyObj> readAllISOCcy();

	/**
	 *	Return a sorted map of all the ISOCcy-derived instances in the database.
	 *
	 *	@return	List of ICFSecISOCcyObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFSecISOCcyObj> readAllISOCcy( boolean forceRead );

	/**
	 *	Get the CFSecISOCcyObj instance for the primary key attributes.
	 *
	 *	@param	argISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByIdIdx( short ISOCcyId );

	/**
	 *	Get the CFSecISOCcyObj instance for the primary key attributes.
	 *
	 *	@param	argISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByIdIdx( short ISOCcyId,
		boolean forceRead );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyCdIdx key.
	 *
	 *	@param	argISOCode	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj cached instance for the unique CcyCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyCdIdx(String ISOCode );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyCdIdx key.
	 *
	 *	@param	argISOCode	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj refreshed instance for the unique CcyCdIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyCdIdx(String ISOCode,
		boolean forceRead );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyNmIdx key.
	 *
	 *	@param	argName	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj cached instance for the unique CcyNmIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyNmIdx(String Name );

	/**
	 *	Get the CFSecISOCcyObj instance for the unique CcyNmIdx key.
	 *
	 *	@param	argName	The ISOCcy key attribute of the instance generating the id.
	 *
	 *	@return	CFSecISOCcyObj refreshed instance for the unique CcyNmIdx key, or
	 *		null if no such instance exists.
	 */
	ICFSecISOCcyObj readISOCcyByCcyNmIdx(String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFSecISOCcyObj updateISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteISOCcy( ICFSecISOCcyObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argISOCcyId	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByIdIdx( short ISOCcyId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argISOCode	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByCcyCdIdx(String ISOCode );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The ISOCcy key attribute of the instance generating the id.
	 */
	void deleteISOCcyByCcyNmIdx(String Name );
}
