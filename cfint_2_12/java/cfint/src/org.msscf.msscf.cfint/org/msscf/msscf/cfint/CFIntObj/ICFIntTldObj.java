// Description: Java 11 Object interface for CFInt Tld.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntTldObj
	extends ICFLibAnyObj
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
	 *	Realise this instance of a Tld.
	 *
	 *	@return	CFIntTldObj instance which should be subsequently referenced.
	 */
	ICFIntTldObj realise();

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
	 *	@return	ICFIntTldObj the reference to the cached or read (realised) instance.
	 */
	ICFIntTldObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFIntTldObj the reference to the cached or read (realised) instance.
	 */
	ICFIntTldObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Tld instance.
	 *
	 *	@return	The newly locked ICFIntTldEditObj edition of this instance.
	 */
	ICFIntTldEditObj beginEdit();

	/**
	 *	End this edition of this Tld instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Tld instance.
	 *
	 *	@return	The ICFIntTldEditObj edition of this instance.
	 */
	ICFIntTldEditObj getEdit();

	/**
	 *	Get the current edition of this Tld instance as a ICFIntTldEditObj.
	 *
	 *	@return	The ICFIntTldEditObj edition of this instance.
	 */
	ICFIntTldEditObj getEditAsTld();

	/**
	 *	Get the ICFIntTldTableObj table cache which manages this instance.
	 *
	 *	@return	ICFIntTldTableObj table cache which manages this instance.
	 */
	ICFIntTldTableObj getTldTable();

	/**
	 *	Get the ICFIntSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFIntSchemaObj schema cache which manages this instance.
	 */
	ICFIntSchemaObj getSchema();

	/**
	 *	Get the CFIntTldBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntTldBuff instance which currently backs this object.
	 */
	CFIntTldBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFIntTldBuff value );

	/**
	 *	Get the CFIntTldBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntTldBuff instance which currently backs this object.
	 */
	CFIntTldBuff getTldBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFIntTldPKey primary key for this instance.
	 */
	CFIntTldPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFIntTldPKey primary key value for this instance.
	 */
	void setPKey( CFIntTldPKey value );

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
	 *	Get the required ICFIntTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFIntTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredContainerTenant();

	/**
	 *	Get the required ICFSecTenantObj instance referenced by the Tenant key.
	 *
	 *	@return	The required ICFSecTenantObj instance referenced by the Tenant key.
	 */
	ICFSecTenantObj getRequiredContainerTenant( boolean forceRead );

	/**
	 *	Get the array of optional ICFIntTopDomainObj array of instances referenced by the TopDomain key.
	 *
	 *	@return	The optional ICFIntTopDomainObj[] array of instances referenced by the TopDomain key.
	 */
	List<ICFIntTopDomainObj> getOptionalComponentsTopDomain();

	/**
	 *	Get the array of optional ICFIntTopDomainObj array of instances referenced by the TopDomain key.
	 *
	 *	@return	The optional ICFIntTopDomainObj[] array of instances referenced by the TopDomain key.
	 */
	List<ICFIntTopDomainObj> getOptionalComponentsTopDomain( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
