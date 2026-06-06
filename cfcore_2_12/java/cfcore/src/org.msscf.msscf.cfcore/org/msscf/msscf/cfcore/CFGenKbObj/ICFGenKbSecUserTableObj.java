// Description: Java 11 Table Object interface for CFGenKb.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbSecUserTableObj
{
	ICFGenKbSchemaObj getSchema();
	void setSchema( ICFGenKbSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SecUser instance.
	 *
	 *	@return	A new instance.
	 */
	ICFGenKbSecUserObj newInstance();

	/**
	 *	Instantiate a new SecUser edition of the specified SecUser instance.
	 *
	 *	@return	A new edition.
	 */
	ICFGenKbSecUserEditObj newEditInstance( ICFGenKbSecUserObj orig );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecUserObj realiseSecUser( ICFGenKbSecUserObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSecUser( ICFGenKbSecUserObj Obj );
	void forgetSecUser( ICFGenKbSecUserObj Obj, boolean forgetSubObjects );
	void forgetSecUserByIdIdx( UUID SecUserId );

	void forgetSecUserByULoginIdx( String LoginId );

	void forgetSecUserByEMConfIdx( UUID EMailConfirmUuid );

	void forgetSecUserByPwdResetIdx( UUID PasswordResetUuid );

	void forgetSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName );


	/**
	 *	Internal use only.
	 */
	ICFGenKbSecUserObj createSecUser( ICFGenKbSecUserObj Obj );

	/**
	 *	Read a SecUser-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUser-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecUserObj readSecUser( CFGenKbSecUserPKey pkey );

	/**
	 *	Read a SecUser-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SecUser-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFGenKbSecUserObj readSecUser( CFGenKbSecUserPKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecUserObj lockSecUser( CFGenKbSecUserPKey pkey );

	/**
	 *	Return a sorted list of all the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecUserObj> readAllSecUser();

	/**
	 *	Return a sorted map of all the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecUserObj> readAllSecUser( boolean forceRead );

	/**
	 *	Return a sorted map of a page of the SecUser-derived instances in the database.
	 *
	 *	@return	List of ICFGenKbSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFGenKbSecUserObj> pageAllSecUser(UUID priorSecUserId );

	/**
	 *	Get the CFGenKbSecUserObj instance for the primary key attributes.
	 *
	 *	@param	argSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecUserObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecUserObj readSecUserByIdIdx( UUID SecUserId );

	/**
	 *	Get the CFGenKbSecUserObj instance for the primary key attributes.
	 *
	 *	@param	argSecUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecUserObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecUserObj readSecUserByIdIdx( UUID SecUserId,
		boolean forceRead );

	/**
	 *	Get the CFGenKbSecUserObj instance for the unique ULoginIdx key.
	 *
	 *	@param	argLoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecUserObj cached instance for the unique ULoginIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecUserObj readSecUserByULoginIdx(String LoginId );

	/**
	 *	Get the CFGenKbSecUserObj instance for the unique ULoginIdx key.
	 *
	 *	@param	argLoginId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	CFGenKbSecUserObj refreshed instance for the unique ULoginIdx key, or
	 *		null if no such instance exists.
	 */
	ICFGenKbSecUserObj readSecUserByULoginIdx(String LoginId,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecUserObj instances sorted by their primary keys for the duplicate EMConfIdx key.
	 *
	 *	@param	argEMailConfirmUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecUserObj cached instances sorted by their primary keys for the duplicate EMConfIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmUuid );

	/**
	 *	Get the map of CFGenKbSecUserObj instances sorted by their primary keys for the duplicate EMConfIdx key.
	 *
	 *	@param	argEMailConfirmUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecUserObj cached instances sorted by their primary keys for the duplicate EMConfIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> readSecUserByEMConfIdx( UUID EMailConfirmUuid,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecUserObj instances sorted by their primary keys for the duplicate PwdResetIdx key.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecUserObj cached instances sorted by their primary keys for the duplicate PwdResetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid );

	/**
	 *	Get the map of CFGenKbSecUserObj instances sorted by their primary keys for the duplicate PwdResetIdx key.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecUserObj cached instances sorted by their primary keys for the duplicate PwdResetIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> readSecUserByPwdResetIdx( UUID PasswordResetUuid,
		boolean forceRead );

	/**
	 *	Get the map of CFGenKbSecUserObj instances sorted by their primary keys for the duplicate DefDevIdx key.
	 *
	 *	@param	argDfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecUserObj cached instances sorted by their primary keys for the duplicate DefDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> readSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName );

	/**
	 *	Get the map of CFGenKbSecUserObj instances sorted by their primary keys for the duplicate DefDevIdx key.
	 *
	 *	@param	argDfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	List of CFGenKbSecUserObj cached instances sorted by their primary keys for the duplicate DefDevIdx key,
	 *		which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> readSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName,
		boolean forceRead );

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate EMConfIdx key attributes.
	 *
	 *	@param	argEMailConfirmUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> pageSecUserByEMConfIdx( UUID EMailConfirmUuid,
		UUID priorSecUserId );

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate PwdResetIdx key attributes.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> pageSecUserByPwdResetIdx( UUID PasswordResetUuid,
		UUID priorSecUserId );

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate DefDevIdx key attributes.
	 *
	 *	@param	argDfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDfltDevName	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	List<ICFGenKbSecUserObj> pageSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName,
		UUID priorSecUserId );

	/**
	 *	Internal use only.
	 */
	ICFGenKbSecUserObj updateSecUser( ICFGenKbSecUserObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSecUser( ICFGenKbSecUserObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argSecUserId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByIdIdx( UUID SecUserId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argLoginId	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByULoginIdx(String LoginId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argEMailConfirmUuid	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByEMConfIdx( UUID EMailConfirmUuid );

	/**
	 *	Internal use only.
	 *
	 *	@param	argPasswordResetUuid	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByPwdResetIdx( UUID PasswordResetUuid );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDfltDevUserId	The SecUser key attribute of the instance generating the id.
	 *
	 *	@param	argDfltDevName	The SecUser key attribute of the instance generating the id.
	 */
	void deleteSecUserByDefDevIdx( UUID DfltDevUserId,
		String DfltDevName );

	ICFGenKbSecUserObj getSystemUser();
}
