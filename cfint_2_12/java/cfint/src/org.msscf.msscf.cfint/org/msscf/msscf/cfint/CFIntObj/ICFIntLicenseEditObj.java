// Description: Java 11 Instance Edit Object interface for CFInt License.

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

public interface ICFIntLicenseEditObj
	extends ICFIntLicenseObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ICFIntLicenseObj.
	 */
	ICFIntLicenseObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ICFIntLicenseObj.
	 */
	ICFIntLicenseObj getOrigAsLicense();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFIntLicenseObj create();

	/*
	 *	Update the instance.
	 */
	CFIntLicenseEditObj update();

	/*
	 *	Delete the instance.
	 */
	CFIntLicenseEditObj deleteInstance();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The String value of the attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param	value	the String value of the attribute Name.
	 */
	void setRequiredName( String value );

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The String value of the attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Set the optional String attribute Description.
	 *
	 *	@param	value	the String value of the attribute Description.
	 */
	void setOptionalDescription( String value );

	/**
	 *	Get the optional String attribute EmbeddedText.
	 *
	 *	@return	The String value of the attribute EmbeddedText.
	 */
	String getOptionalEmbeddedText();

	/**
	 *	Set the optional String attribute EmbeddedText.
	 *
	 *	@param	value	the String value of the attribute EmbeddedText.
	 */
	void setOptionalEmbeddedText( String value );

	/**
	 *	Get the optional String attribute FullText.
	 *
	 *	@return	The String value of the attribute FullText.
	 */
	String getOptionalFullText();

	/**
	 *	Set the optional String attribute FullText.
	 *
	 *	@param	value	the String value of the attribute FullText.
	 */
	void setOptionalFullText( String value );

	/**
	 *	Get the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant();

	/**
	 *	Set the ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@param	value	the ICFSecTenantObj instance to be referenced by the Tenant key.
	 */
	void setRequiredOwnerTenant( ICFSecTenantObj value );

	/**
	 *	Get the ICFIntTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The ICFIntTopDomainObj instance referenced by the TopDomain key.
	 */
	ICFIntTopDomainObj getRequiredContainerTopDomain();

	/**
	 *	Set the ICFIntTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@param	value	the ICFIntTopDomainObj instance to be referenced by the TopDomain key.
	 */
	void setRequiredContainerTopDomain( ICFIntTopDomainObj value );
}
