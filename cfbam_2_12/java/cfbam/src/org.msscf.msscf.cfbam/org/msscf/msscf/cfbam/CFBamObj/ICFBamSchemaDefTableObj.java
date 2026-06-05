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

public interface ICFBamSchemaDefTableObj
{
	ICFBamSchemaObj getSchema();
	void setSchema( ICFBamSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new SchemaDef instance.
	 *
	 *	@return	A new instance.
	 */
	ICFBamSchemaDefObj newInstance();

	/**
	 *	Instantiate a new SchemaDef edition of the specified SchemaDef instance.
	 *
	 *	@return	A new edition.
	 */
	ICFBamSchemaDefEditObj newEditInstance( ICFBamSchemaDefObj orig );

	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj realiseSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetSchemaDef( ICFBamSchemaDefObj Obj );
	void forgetSchemaDef( ICFBamSchemaDefObj Obj, boolean forgetSubObjects );
	void forgetSchemaDefByIdIdx( long TenantId,
		long Id );

	void forgetSchemaDefByTenantIdx( long TenantId );

	void forgetSchemaDefByCTenantIdx( long TenantId );

	void forgetSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId );

	void forgetSchemaDefByUNameIdx( long TenantId,
		long MinorVersionId,
		String Name );

	void forgetSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId );

	void forgetSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail );

	void forgetSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL );

	void forgetSchemaDefByPubURIIdx( long TenantId,
		String PublishURI );


	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj createSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Read a SchemaDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey );

	/**
	 *	Read a SchemaDef-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The SchemaDef-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFBamSchemaDefObj readSchemaDef( CFBamScopePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj lockSchemaDef( CFBamScopePKey pkey );

	/**
	 *	Return a sorted list of all the SchemaDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamSchemaDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSchemaDefObj> readAllSchemaDef();

	/**
	 *	Return a sorted map of all the SchemaDef-derived instances in the database.
	 *
	 *	@return	List of ICFBamSchemaDefObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFBamSchemaDefObj> readAllSchemaDef( boolean forceRead );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFBamScopeObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamScopeObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFBamScopeObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate TenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate TenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate CTenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate CTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate CTenantIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate CTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByCTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate MinorVersionIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argMinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate MinorVersionIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate MinorVersionIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argMinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate MinorVersionIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId,
		boolean forceRead );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argMinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByUNameIdx(long TenantId,
		long MinorVersionId,
		String Name );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argMinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByUNameIdx(long TenantId,
		long MinorVersionId,
		String Name,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DefLcnIdx key.
	 *
	 *	@param	argDefaultLicenseTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultLicenseId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DefLcnIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate DefLcnIdx key.
	 *
	 *	@param	argDefaultLicenseTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultLicenseId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate DefLcnIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate AuthEMailIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argAuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate AuthEMailIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate AuthEMailIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argAuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate AuthEMailIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail,
		boolean forceRead );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate ProjectURLIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argProjectURL	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate ProjectURLIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL );

	/**
	 *	Get the map of CFBamSchemaDefObj instances sorted by their primary keys for the duplicate ProjectURLIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argProjectURL	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	List of CFBamSchemaDefObj cached instances sorted by their primary keys for the duplicate ProjectURLIdx key,
	 *		which may be an empty set.
	 */
	List<ICFBamSchemaDefObj> readSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL,
		boolean forceRead );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique PubURIIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argPublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj cached instance for the unique PubURIIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByPubURIIdx(long TenantId,
		String PublishURI );

	/**
	 *	Get the CFBamSchemaDefObj instance for the unique PubURIIdx key.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argPublishURI	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@return	CFBamSchemaDefObj refreshed instance for the unique PubURIIdx key, or
	 *		null if no such instance exists.
	 */
	ICFBamSchemaDefObj readSchemaDefByPubURIIdx(long TenantId,
		String PublishURI,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFBamSchemaDefObj updateSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteSchemaDef( ICFBamSchemaDefObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByCTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argMinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByMinorVersionIdx( long TenantId,
		long MinorVersionId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argMinorVersionId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argName	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByUNameIdx(long TenantId,
		long MinorVersionId,
		String Name );

	/**
	 *	Internal use only.
	 *
	 *	@param	argDefaultLicenseTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argDefaultLicenseId	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByDefLcnIdx( Long DefaultLicenseTenantId,
		Long DefaultLicenseId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argAuthorEMail	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByAuthEMailIdx( long TenantId,
		String AuthorEMail );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argProjectURL	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByProjectURLIdx( long TenantId,
		String ProjectURL );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The SchemaDef key attribute of the instance generating the id.
	 *
	 *	@param	argPublishURI	The SchemaDef key attribute of the instance generating the id.
	 */
	void deleteSchemaDefByPubURIIdx(long TenantId,
		String PublishURI );
}
