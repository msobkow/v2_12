// Description: Java 11 Object interface for CFInt MimeType.

/*
 *	org.msscf.msscf.CFInt
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

public interface ICFIntMimeTypeObj
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
	 *	Realise this instance of a MimeType.
	 *
	 *	@return	CFIntMimeTypeObj instance which should be subsequently referenced.
	 */
	ICFIntMimeTypeObj realise();

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
	 *	@return	ICFIntMimeTypeObj the reference to the cached or read (realised) instance.
	 */
	ICFIntMimeTypeObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFIntMimeTypeObj the reference to the cached or read (realised) instance.
	 */
	ICFIntMimeTypeObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this MimeType instance.
	 *
	 *	@return	The newly locked ICFIntMimeTypeEditObj edition of this instance.
	 */
	ICFIntMimeTypeEditObj beginEdit();

	/**
	 *	End this edition of this MimeType instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this MimeType instance.
	 *
	 *	@return	The ICFIntMimeTypeEditObj edition of this instance.
	 */
	ICFIntMimeTypeEditObj getEdit();

	/**
	 *	Get the current edition of this MimeType instance as a ICFIntMimeTypeEditObj.
	 *
	 *	@return	The ICFIntMimeTypeEditObj edition of this instance.
	 */
	ICFIntMimeTypeEditObj getEditAsMimeType();

	/**
	 *	Get the ICFIntMimeTypeTableObj table cache which manages this instance.
	 *
	 *	@return	ICFIntMimeTypeTableObj table cache which manages this instance.
	 */
	ICFIntMimeTypeTableObj getMimeTypeTable();

	/**
	 *	Get the ICFIntSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFIntSchemaObj schema cache which manages this instance.
	 */
	ICFIntSchemaObj getSchema();

	/**
	 *	Get the CFIntMimeTypeBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntMimeTypeBuff instance which currently backs this object.
	 */
	CFIntMimeTypeBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFIntMimeTypeBuff value );

	/**
	 *	Get the CFIntMimeTypeBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFIntMimeTypeBuff instance which currently backs this object.
	 */
	CFIntMimeTypeBuff getMimeTypeBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFIntMimeTypePKey primary key for this instance.
	 */
	CFIntMimeTypePKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFIntMimeTypePKey primary key value for this instance.
	 */
	void setPKey( CFIntMimeTypePKey value );

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
	 *	Get the required int attribute MimeTypeId.
	 *
	 *	@return	The required int attribute MimeTypeId.
	 */
	int getRequiredMimeTypeId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional String attribute FileTypes.
	 *
	 *	@return	The optional String attribute FileTypes.
	 */
	String getOptionalFileTypes();

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
