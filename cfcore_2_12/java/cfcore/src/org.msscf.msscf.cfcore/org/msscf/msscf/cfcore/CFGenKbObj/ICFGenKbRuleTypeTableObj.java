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

public interface ICFGenKbRuleTypeTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new RuleType instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbRuleTypeObj newInstance();

	/**
	 *	Instantiate a new RuleType edition of the specified RuleType instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbRuleTypeEditObj newEditInstance( ICFGenKbRuleTypeObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbRuleTypeObj realiseRuleType( ICFGenKbRuleTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetRuleType( ICFGenKbRuleTypeObj Obj );
	void forgetRuleType( ICFGenKbRuleTypeObj Obj, boolean forgetSubObjects );
	void forgetRuleTypeByIdIdx( short Id );

	void forgetRuleTypeByNameIdx( String Name );


	/**
	 *	Internal use only.
	 */
	ICFGenKbRuleTypeObj createRuleType( ICFGenKbRuleTypeObj Obj );

	/**
	 *	Read a RuleType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The RuleType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbRuleTypeObj readRuleType( CFGenKbRuleTypePKey pkey );

	/**
	 *	Read a RuleType-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The RuleType-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbRuleTypeObj readRuleType( CFGenKbRuleTypePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbRuleTypeObj lockRuleType( CFGenKbRuleTypePKey pkey );

	/**
	 *	Return a sorted list of all the RuleType-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbRuleTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbRuleTypeObj> readAllRuleType();

	/**
	 *	Return a sorted map of all the RuleType-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbRuleTypeObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbRuleTypeObj> readAllRuleType( boolean forceRead );

	/**
	 *	Get the CFGenKbRuleTypeObj instance for the primary key attributes.
	 *
	 *	@param	argId	The RuleType key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbRuleTypeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbRuleTypeObj readRuleTypeByIdIdx( short Id );

	/**
	 *	Get the CFGenKbRuleTypeObj instance for the primary key attributes.
	 *
	 *	@param	argId	The RuleType key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbRuleTypeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbRuleTypeObj readRuleTypeByIdIdx( short Id,
		boolean forceRead );

	/**
	 *	Get the CFGenKbRuleTypeObj instance for the unique NameIdx key.
	 *
	 *	@param	argName	The RuleType key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbRuleTypeObj cached instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbRuleTypeObj readRuleTypeByNameIdx(String Name );

	/**
	 *	Get the CFGenKbRuleTypeObj instance for the unique NameIdx key.
	 *
	 *	@param	argName	The RuleType key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbRuleTypeObj refreshed instance for the unique NameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbRuleTypeObj readRuleTypeByNameIdx(String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbRuleTypeObj updateRuleType( ICFGenKbRuleTypeObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteRuleType( ICFGenKbRuleTypeObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argId	The RuleType key attribute of the instance generating the id.
	 */
	void deleteRuleTypeByIdIdx( short Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argName	The RuleType key attribute of the instance generating the id.
	 */
	void deleteRuleTypeByNameIdx(String Name );
}
