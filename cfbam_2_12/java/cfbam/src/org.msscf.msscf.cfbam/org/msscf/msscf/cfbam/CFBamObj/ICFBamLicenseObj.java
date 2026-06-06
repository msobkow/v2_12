// Description: Java 11 Object interface for CFBam License.

/*
 *	org.msscf.msscf.CFBam
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
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamLicenseObj
	extends ICFIntLicenseObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a License.
	 *
	 *	@return	CFIntLicenseObj instance which should be subsequently referenced.
	 */
	ICFIntLicenseObj realise();

	/**
	 *	Forget this instance from the cache.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 */
	void forget();
	void forget( boolean forgetSubObjects );

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFIntLicenseObj the reference to the cached or read (realised) instance.
	 */
	ICFIntLicenseObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFIntLicenseObj the reference to the cached or read (realised) instance.
	 */
	ICFIntLicenseObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this License instance.
	 *
	 *	@return	The newly locked ICFIntLicenseEditObj edition of this instance.
	 */
	ICFIntLicenseEditObj beginEdit();

	/**
	 *	End this edition of this License instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this License instance.
	 *
	 *	@return	The ICFIntLicenseEditObj edition of this instance.
	 */
	ICFIntLicenseEditObj getEdit();

	/**
	 *	Get the current edition of this License instance as a ICFIntLicenseEditObj.
	 *
	 *	@return	The ICFIntLicenseEditObj edition of this instance.
	 */
	ICFIntLicenseEditObj getEditAsLicense();

	/**
	 *	Get the ICFIntLicenseTableObj table cache which manages this instance.
	 *
	 *	@return	ICFIntLicenseTableObj table cache which manages this instance.
	 */
	ICFIntLicenseTableObj getLicenseTable();

	/**
	 *	Get the ICFIntSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFIntSchemaObj schema cache which manages this instance.
	 */
	ICFIntSchemaObj getSchema();

	/**
	 *	Get the CFIntLicenseBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntLicenseBuff instance which currently backs this object.
	 */
	CFIntLicenseBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFIntLicenseBuff value );

	/**
	 *	Get the CFIntLicenseBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntLicenseBuff instance which currently backs this object.
	 */
	CFIntLicenseBuff getLicenseBuff();

	/**
	 *	Is this a new instance?
	 *
	 *	@return	True if this is a new instance, otherwise false if it has
	 *		been read, locked, or created.
	 */
	boolean getIsNew();

	/**
	 *	Indicate whether this is a new instance.
	 *	<p>
	 *	This method should only be used by implementation internals.
	 *
	 *	@param	True if this is a new instance, otherwise false.
	 */
	void setIsNew( boolean value );

	/**
	 *	Get the required long attribute TenantId.
	 *
	 *	@return	The required long attribute TenantId.
	 */
	long getRequiredTenantId();

	/**
	 *	Get the required long attribute Id.
	 *
	 *	@return	The required long attribute Id.
	 */
	long getRequiredId();

	/**
	 *	Get the required long attribute TopDomainId.
	 *
	 *	@return	The required long attribute TopDomainId.
	 */
	long getRequiredTopDomainId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute Description.
	 *
	 *	@return	The optional String attribute Description.
	 */
	String getOptionalDescription();

	/**
	 *	Get the optional String attribute EmbeddedText.
	 *
	 *	@return	The optional String attribute EmbeddedText.
	 */
	String getOptionalEmbeddedText();

	/**
	 *	Get the optional String attribute FullText.
	 *
	 *	@return	The optional String attribute FullText.
	 */
	String getOptionalFullText();

	/**
	 *	Get the required ICFBamTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFBamTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant();

	/**
	 *	Get the required ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredOwnerTenant( boolean forceRead );

	/**
	 *	Get the required ICFBamTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The required ICFBamTopDomainObj instance referenced by the TopDomain key.
	 */
	ICFIntTopDomainObj getRequiredContainerTopDomain();

	/**
	 *	Get the required ICFIntTopDomainObj instance referenced by the TopDomain key.
	 *
	 *	@return	The required ICFIntTopDomainObj instance referenced by the TopDomain key.
	 */
	ICFIntTopDomainObj getRequiredContainerTopDomain( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
