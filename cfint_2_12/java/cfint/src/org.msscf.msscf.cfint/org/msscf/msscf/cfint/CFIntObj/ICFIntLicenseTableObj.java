// Description: Java 11 Table Object interface for CFInt.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntLicenseTableObj
{
	ICFIntSchemaObj getSchema();
	void setSchema( ICFIntSchemaObj value );

	void minimizeMemory();

	String getTableName();
	String getTableDbName();

	Class getObjQualifyingClass();

	/**
	 *	Instantiate a new License instance.
	 *
	 *	@return	A new instance.
	 */
	ICFIntLicenseObj newInstance();

	/**
	 *	Instantiate a new License edition of the specified License instance.
	 *
	 *	@return	A new edition.
	 */
	ICFIntLicenseEditObj newEditInstance( ICFIntLicenseObj orig );

	/**
	 *	Internal use only.
	 */
	ICFIntLicenseObj realiseLicense( ICFIntLicenseObj Obj );

	/**
	 *	Internal use only.
	 */
	void forgetLicense( ICFIntLicenseObj Obj );
	void forgetLicense( ICFIntLicenseObj Obj, boolean forgetSubObjects );
	void forgetLicenseByIdIdx( long TenantId,
		long Id );

	void forgetLicenseByLicnTenantIdx( long TenantId );

	void forgetLicenseByDomainIdx( long TenantId,
		long TopDomainId );

	void forgetLicenseByUNameIdx( long TenantId,
		long TopDomainId,
		String Name );


	/**
	 *	Internal use only.
	 */
	ICFIntLicenseObj createLicense( ICFIntLicenseObj Obj );

	/**
	 *	Read a License-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The License-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntLicenseObj readLicense( CFIntLicensePKey pkey );

	/**
	 *	Read a License-derived instance by it's primary key.
	 *
	 *	@param	pkey	The primary key identifying the instance to read.
	 *
	 *	@return	The License-derived instance identified by the primary key,
	 *		or null if no such key value exists.
	 */
	ICFIntLicenseObj readLicense( CFIntLicensePKey pkey,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntLicenseObj lockLicense( CFIntLicensePKey pkey );

	/**
	 *	Return a sorted list of all the License-derived instances in the database.
	 *
	 *	@return	List of ICFIntLicenseObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntLicenseObj> readAllLicense();

	/**
	 *	Return a sorted map of all the License-derived instances in the database.
	 *
	 *	@return	List of ICFIntLicenseObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	List<ICFIntLicenseObj> readAllLicense( boolean forceRead );

	/**
	 *	Get the CFIntLicenseObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argId	The License key attribute of the instance generating the id.
	 *
	 *	@return	CFIntLicenseObj cached instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntLicenseObj readLicenseByIdIdx( long TenantId,
		long Id );

	/**
	 *	Get the CFIntLicenseObj instance for the primary key attributes.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argId	The License key attribute of the instance generating the id.
	 *
	 *	@return	CFIntLicenseObj refreshed instance for the primary key, or
	 *		null if no such instance exists.
	 */
	ICFIntLicenseObj readLicenseByIdIdx( long TenantId,
		long Id,
		boolean forceRead );

	/**
	 *	Get the map of CFIntLicenseObj instances sorted by their primary keys for the duplicate LicnTenantIdx key.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntLicenseObj cached instances sorted by their primary keys for the duplicate LicnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntLicenseObj> readLicenseByLicnTenantIdx( long TenantId );

	/**
	 *	Get the map of CFIntLicenseObj instances sorted by their primary keys for the duplicate LicnTenantIdx key.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntLicenseObj cached instances sorted by their primary keys for the duplicate LicnTenantIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntLicenseObj> readLicenseByLicnTenantIdx( long TenantId,
		boolean forceRead );

	/**
	 *	Get the map of CFIntLicenseObj instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntLicenseObj cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntLicenseObj> readLicenseByDomainIdx( long TenantId,
		long TopDomainId );

	/**
	 *	Get the map of CFIntLicenseObj instances sorted by their primary keys for the duplicate DomainIdx key.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return	List of CFIntLicenseObj cached instances sorted by their primary keys for the duplicate DomainIdx key,
	 *		which may be an empty set.
	 */
	List<ICFIntLicenseObj> readLicenseByDomainIdx( long TenantId,
		long TopDomainId,
		boolean forceRead );

	/**
	 *	Get the CFIntLicenseObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argName	The License key attribute of the instance generating the id.
	 *
	 *	@return	CFIntLicenseObj cached instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntLicenseObj readLicenseByUNameIdx(long TenantId,
		long TopDomainId,
		String Name );

	/**
	 *	Get the CFIntLicenseObj instance for the unique UNameIdx key.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argName	The License key attribute of the instance generating the id.
	 *
	 *	@return	CFIntLicenseObj refreshed instance for the unique UNameIdx key, or
	 *		null if no such instance exists.
	 */
	ICFIntLicenseObj readLicenseByUNameIdx(long TenantId,
		long TopDomainId,
		String Name,
		boolean forceRead );

	/**
	 *	Internal use only.
	 */
	ICFIntLicenseObj updateLicense( ICFIntLicenseObj Obj );

	/**
	 *	Internal use only.
	 */
	void deleteLicense( ICFIntLicenseObj Obj );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByIdIdx( long TenantId,
		long Id );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByLicnTenantIdx( long TenantId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByDomainIdx( long TenantId,
		long TopDomainId );

	/**
	 *	Internal use only.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argName	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByUNameIdx(long TenantId,
		long TopDomainId,
		String Name );
}
