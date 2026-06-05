
// Description: Java 11 DbIO interface for License.

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

package org.msscf.msscf.cfint.CFInt;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/*
 *	CFIntLicenseTable database interface for License
 */
public interface ICFIntLicenseTable
{

	/**
	 *	Create the instance in the database, and update the specified buffer
	 *	with the assigned primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be created.
	 */
	void createLicense( CFSecAuthorization Authorization,
		CFIntLicenseBuff Buff );


	/**
	 *	Update the instance in the database, and update the specified buffer
	 *	with any calculated changes imposed by the associated stored procedure.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be updated.
	 */
	void updateLicense( CFSecAuthorization Authorization,
		CFIntLicenseBuff Buff );


	/**
	 *	Delete the instance from the database.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	Buff	The buffer to be deleted.
	 */
	void deleteLicense( CFSecAuthorization Authorization,
		CFIntLicenseBuff Buff );
	/**
	 *	Delete the License instance identified by the primary key attributes.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByIdIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argId );

	/**
	 *	Delete the License instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The primary key identifying the instance to be deleted.
	 */
	void deleteLicenseByIdIdx( CFSecAuthorization Authorization,
		CFIntLicensePKey argKey );
	/**
	 *	Delete the License instances identified by the key LicnTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByLicnTenantIdx( CFSecAuthorization Authorization,
		long argTenantId );

	/**
	 *	Delete the License instances identified by the key LicnTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteLicenseByLicnTenantIdx( CFSecAuthorization Authorization,
		CFIntLicenseByLicnTenantIdxKey argKey );
	/**
	 *	Delete the License instances identified by the key DomainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByDomainIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTopDomainId );

	/**
	 *	Delete the License instances identified by the key DomainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteLicenseByDomainIdx( CFSecAuthorization Authorization,
		CFIntLicenseByDomainIdxKey argKey );
	/**
	 *	Delete the License instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argName	The License key attribute of the instance generating the id.
	 */
	void deleteLicenseByUNameIdx( CFSecAuthorization Authorization,
		long argTenantId,
		long argTopDomainId,
		String argName );

	/**
	 *	Delete the License instances identified by the key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argKey	The key identifying the instances to be deleted.
	 */
	void deleteLicenseByUNameIdx( CFSecAuthorization Authorization,
		CFIntLicenseByUNameIdxKey argKey );


	/**
	 *	Read the derived License buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the License instance to be read.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntLicenseBuff readDerived( CFSecAuthorization Authorization,
		CFIntLicensePKey PKey );

	/**
	 *	Lock the derived License buffer instance by primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the License instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 */
	CFIntLicenseBuff lockDerived( CFSecAuthorization Authorization,
		CFIntLicensePKey PKey );

	/**
	 *	Read all License instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return An array of derived buffer instances, potentially with 0 elements in the set.
	 */
	CFIntLicenseBuff[] readAllDerived( CFSecAuthorization Authorization );

	/**
	 *	Read the derived License buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argId	The License key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntLicenseBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the derived License buffer instances identified by the duplicate key LicnTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntLicenseBuff[] readDerivedByLicnTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the derived License buffer instances identified by the duplicate key DomainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 */
	CFIntLicenseBuff[] readDerivedByDomainIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TopDomainId );

	/**
	 *	Read the derived License buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argName	The License key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 */
	CFIntLicenseBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TopDomainId,
		String Name );

	/**
	 *	Read the specific License buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the License instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntLicenseBuff readBuff( CFSecAuthorization Authorization,
		CFIntLicensePKey PKey );

	/**
	 *	Lock the specific License buffer instance identified by the primary key.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	PKey	The primary key of the License instance to be locked.
	 *
	 *	@return The buffer instance for the specified primary key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntLicenseBuff lockBuff( CFSecAuthorization Authorization,
		CFIntLicensePKey PKey );

	/**
	 *	Read all the specific License buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific License instances in the database accessible for the Authorization.
	 */
	CFIntLicenseBuff[] readAllBuff( CFSecAuthorization Authorization );

	/**
	 *	Read the specific License buffer instance identified by the unique key IdIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argId	The License key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntLicenseBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long TenantId,
		long Id );

	/**
	 *	Read an array of the specific License buffer instances identified by the duplicate key LicnTenantIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntLicenseBuff[] readBuffByLicnTenantIdx( CFSecAuthorization Authorization,
		long TenantId );

	/**
	 *	Read an array of the specific License buffer instances identified by the duplicate key DomainIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntLicenseBuff[] readBuffByDomainIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TopDomainId );

	/**
	 *	Read the specific License buffer instance identified by the unique key UNameIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argTenantId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argTopDomainId	The License key attribute of the instance generating the id.
	 *
	 *	@param	argName	The License key attribute of the instance generating the id.
	 *
	 *	@return The buffer instance for the specified key, or null if there is
	 *		no such existing key value.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	CFIntLicenseBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long TenantId,
		long TopDomainId,
		String Name );

	/**
	 *	Release any prepared statements allocated by this instance.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	void releasePreparedStatements();
}
