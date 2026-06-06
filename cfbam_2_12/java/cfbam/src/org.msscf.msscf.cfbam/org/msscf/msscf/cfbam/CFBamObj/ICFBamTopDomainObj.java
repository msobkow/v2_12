// Description: Java 11 Object interface for CFBam TopDomain.

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

public interface ICFBamTopDomainObj
	extends ICFIntTopDomainObj
{
	String getClassCode();
	/**
	 *	Get the user who created this instance.
	 *
	 *	@return	The ICFSecSecUserObj instance who created this instance.
	 */
	ICFSecSecUserObj getCreatedBy();

	/**
	 *	Get the Calendar date-time this instance was created.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getCreatedAt();

	/**
	 *	Get the user who updated this instance.
	 *
	 *	@return	The ICFSecSecUserObj instance who updated this instance.
	 */
	ICFSecSecUserObj getUpdatedBy();

	/**
	 *	Get the Calendar date-time this instance was updated.
	 *
	 *	@return	The Calendar value for the create time of the instance.
	 */
	Calendar getUpdatedAt();
	/**
	 *	Realise this instance of a TopDomain.
	 *
	 *	@return	CFIntTopDomainObj instance which should be subsequently referenced.
	 */
	ICFIntTopDomainObj realise();

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
	 *	@return	ICFIntTopDomainObj the reference to the cached or read (realised) instance.
	 */
	ICFIntTopDomainObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFIntTopDomainObj the reference to the cached or read (realised) instance.
	 */
	ICFIntTopDomainObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this TopDomain instance.
	 *
	 *	@return	The newly locked ICFIntTopDomainEditObj edition of this instance.
	 */
	ICFIntTopDomainEditObj beginEdit();

	/**
	 *	End this edition of this TopDomain instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this TopDomain instance.
	 *
	 *	@return	The ICFIntTopDomainEditObj edition of this instance.
	 */
	ICFIntTopDomainEditObj getEdit();

	/**
	 *	Get the current edition of this TopDomain instance as a ICFIntTopDomainEditObj.
	 *
	 *	@return	The ICFIntTopDomainEditObj edition of this instance.
	 */
	ICFIntTopDomainEditObj getEditAsTopDomain();

	/**
	 *	Get the ICFIntTopDomainTableObj table cache which manages this instance.
	 *
	 *	@return	ICFIntTopDomainTableObj table cache which manages this instance.
	 */
	ICFIntTopDomainTableObj getTopDomainTable();

	/**
	 *	Get the ICFIntSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFIntSchemaObj schema cache which manages this instance.
	 */
	ICFIntSchemaObj getSchema();

	/**
	 *	Get the CFIntTopDomainBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntTopDomainBuff instance which currently backs this object.
	 */
	CFIntTopDomainBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFIntTopDomainBuff value );

	/**
	 *	Get the CFIntTopDomainBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntTopDomainBuff instance which currently backs this object.
	 */
	CFIntTopDomainBuff getTopDomainBuff();

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
	 *	Get the required long attribute TldId.
	 *
	 *	@return	The required long attribute TldId.
	 */
	long getRequiredTldId();

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
	 *	Get the required ICFBamTldObj instance referenced by the ParentTld key.
	 *
	 *	@return	The required ICFBamTldObj instance referenced by the ParentTld key.
	 */
	ICFIntTldObj getRequiredContainerParentTld();

	/**
	 *	Get the required ICFIntTldObj instance referenced by the ParentTld key.
	 *
	 *	@return	The required ICFIntTldObj instance referenced by the ParentTld key.
	 */
	ICFIntTldObj getRequiredContainerParentTld( boolean forceRead );

	/**
	 *	Get the array of optional ICFIntLicenseObj array of instances referenced by the License key.
	 *
	 *	@return	The optional ICFIntLicenseObj[] array of instances referenced by the License key.
	 */
	List<ICFIntLicenseObj> getOptionalComponentsLicense();

	/**
	 *	Get the array of optional ICFIntLicenseObj array of instances referenced by the License key.
	 *
	 *	@return	The optional ICFIntLicenseObj[] array of instances referenced by the License key.
	 */
	List<ICFIntLicenseObj> getOptionalComponentsLicense( boolean forceRead );

	/**
	 *	Get the array of optional ICFIntTopProjectObj array of instances referenced by the TopProject key.
	 *
	 *	@return	The optional ICFIntTopProjectObj[] array of instances referenced by the TopProject key.
	 */
	List<ICFIntTopProjectObj> getOptionalComponentsTopProject();

	/**
	 *	Get the array of optional ICFIntTopProjectObj array of instances referenced by the TopProject key.
	 *
	 *	@return	The optional ICFIntTopProjectObj[] array of instances referenced by the TopProject key.
	 */
	List<ICFIntTopProjectObj> getOptionalComponentsTopProject( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
