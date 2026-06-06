// Description: Java 11 Object interface for CFInt ISOCtry.

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

public interface ICFIntISOCtryObj
	extends ICFSecISOCtryObj
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
	 *	Realise this instance of a ISOCtry.
	 *
	 *	@return	CFSecISOCtryObj instance which should be subsequently referenced.
	 */
	ICFSecISOCtryObj realise();

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
	 *	@return	ICFSecISOCtryObj the reference to the cached or read (realised) instance.
	 */
	ICFSecISOCtryObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFSecISOCtryObj the reference to the cached or read (realised) instance.
	 */
	ICFSecISOCtryObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this ISOCtry instance.
	 *
	 *	@return	The newly locked ICFSecISOCtryEditObj edition of this instance.
	 */
	ICFSecISOCtryEditObj beginEdit();

	/**
	 *	End this edition of this ISOCtry instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this ISOCtry instance.
	 *
	 *	@return	The ICFSecISOCtryEditObj edition of this instance.
	 */
	ICFSecISOCtryEditObj getEdit();

	/**
	 *	Get the current edition of this ISOCtry instance as a ICFSecISOCtryEditObj.
	 *
	 *	@return	The ICFSecISOCtryEditObj edition of this instance.
	 */
	ICFSecISOCtryEditObj getEditAsISOCtry();

	/**
	 *	Get the ICFSecISOCtryTableObj table cache which manages this instance.
	 *
	 *	@return	ICFSecISOCtryTableObj table cache which manages this instance.
	 */
	ICFSecISOCtryTableObj getISOCtryTable();

	/**
	 *	Get the ICFSecSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFSecSchemaObj schema cache which manages this instance.
	 */
	ICFSecSchemaObj getSchema();

	/**
	 *	Get the CFSecISOCtryBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecISOCtryBuff instance which currently backs this object.
	 */
	CFSecISOCtryBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFSecISOCtryBuff value );

	/**
	 *	Get the CFSecISOCtryBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecISOCtryBuff instance which currently backs this object.
	 */
	CFSecISOCtryBuff getISOCtryBuff();

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
	 *	Get the required short attribute ISOCtryId.
	 *
	 *	@return	The required short attribute ISOCtryId.
	 */
	short getRequiredISOCtryId();

	/**
	 *	Get the required String attribute ISOCode.
	 *
	 *	@return	The required String attribute ISOCode.
	 */
	String getRequiredISOCode();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the array of optional ICFSecISOCtryCcyObj array of instances referenced by the Ccy key.
	 *
	 *	@return	The optional ICFSecISOCtryCcyObj[] array of instances referenced by the Ccy key.
	 */
	List<ICFSecISOCtryCcyObj> getOptionalComponentsCcy();

	/**
	 *	Get the array of optional ICFSecISOCtryCcyObj array of instances referenced by the Ccy key.
	 *
	 *	@return	The optional ICFSecISOCtryCcyObj[] array of instances referenced by the Ccy key.
	 */
	List<ICFSecISOCtryCcyObj> getOptionalComponentsCcy( boolean forceRead );

	/**
	 *	Get the array of optional ICFSecISOCtryLangObj array of instances referenced by the Lang key.
	 *
	 *	@return	The optional ICFSecISOCtryLangObj[] array of instances referenced by the Lang key.
	 */
	List<ICFSecISOCtryLangObj> getOptionalComponentsLang();

	/**
	 *	Get the array of optional ICFSecISOCtryLangObj array of instances referenced by the Lang key.
	 *
	 *	@return	The optional ICFSecISOCtryLangObj[] array of instances referenced by the Lang key.
	 */
	List<ICFSecISOCtryLangObj> getOptionalComponentsLang( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
