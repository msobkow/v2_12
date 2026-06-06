// Description: Java 11 Object interface for CFBam ISOLang.

/*
 *	org.msscf.msscf.CFBam
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

public interface ICFBamISOLangObj
	extends ICFSecISOLangObj,
		ICFIntISOLangObj
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
	 *	Realise this instance of a ISOLang.
	 *
	 *	@return	CFSecISOLangObj instance which should be subsequently referenced.
	 */
	ICFSecISOLangObj realise();

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
	 *	@return	ICFSecISOLangObj the reference to the cached or read (realised) instance.
	 */
	ICFSecISOLangObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFSecISOLangObj the reference to the cached or read (realised) instance.
	 */
	ICFSecISOLangObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this ISOLang instance.
	 *
	 *	@return	The newly locked ICFSecISOLangEditObj edition of this instance.
	 */
	ICFSecISOLangEditObj beginEdit();

	/**
	 *	End this edition of this ISOLang instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this ISOLang instance.
	 *
	 *	@return	The ICFSecISOLangEditObj edition of this instance.
	 */
	ICFSecISOLangEditObj getEdit();

	/**
	 *	Get the current edition of this ISOLang instance as a ICFSecISOLangEditObj.
	 *
	 *	@return	The ICFSecISOLangEditObj edition of this instance.
	 */
	ICFSecISOLangEditObj getEditAsISOLang();

	/**
	 *	Get the ICFSecISOLangTableObj table cache which manages this instance.
	 *
	 *	@return	ICFSecISOLangTableObj table cache which manages this instance.
	 */
	ICFSecISOLangTableObj getISOLangTable();

	/**
	 *	Get the ICFSecSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFSecSchemaObj schema cache which manages this instance.
	 */
	ICFSecSchemaObj getSchema();

	/**
	 *	Get the CFSecISOLangBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecISOLangBuff instance which currently backs this object.
	 */
	CFSecISOLangBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFSecISOLangBuff value );

	/**
	 *	Get the CFSecISOLangBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFSecISOLangBuff instance which currently backs this object.
	 */
	CFSecISOLangBuff getISOLangBuff();

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
	 *	Get the required short attribute ISOLangId.
	 *
	 *	@return	The required short attribute ISOLangId.
	 */
	short getRequiredISOLangId();

	/**
	 *	Get the required String attribute ISO6392Code.
	 *
	 *	@return	The required String attribute ISO6392Code.
	 */
	String getRequiredISO6392Code();

	/**
	 *	Get the optional String attribute ISO6391Code.
	 *
	 *	@return	The optional String attribute ISO6391Code.
	 */
	String getOptionalISO6391Code();

	/**
	 *	Get the required String attribute EnglishName.
	 *
	 *	@return	The required String attribute EnglishName.
	 */
	String getRequiredEnglishName();

	/**
	 *	Get the array of optional ICFSecISOCtryLangObj array of instances referenced by the Ctry key.
	 *
	 *	@return	The optional ICFSecISOCtryLangObj[] array of instances referenced by the Ctry key.
	 */
	List<ICFSecISOCtryLangObj> getOptionalChildrenCtry();

	/**
	 *	Get the array of optional ICFSecISOCtryLangObj array of instances referenced by the Ctry key.
	 *
	 *	@return	The optional ICFSecISOCtryLangObj[] array of instances referenced by the Ctry key.
	 */
	List<ICFSecISOCtryLangObj> getOptionalChildrenCtry( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
