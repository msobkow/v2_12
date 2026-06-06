// Description: Java 11 Object interface for CFGenKb Tool.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbToolObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a Tool.
	 *
	 *	@return	CFGenKbToolObj instance which should be subsequently referenced.
	 */
	ICFGenKbToolObj realise();

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
	 *	@return	ICFGenKbToolObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbToolObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbToolObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbToolObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this Tool instance.
	 *
	 *	@return	The newly locked ICFGenKbToolEditObj edition of this instance.
	 */
	ICFGenKbToolEditObj beginEdit();

	/**
	 *	End this edition of this Tool instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this Tool instance.
	 *
	 *	@return	The ICFGenKbToolEditObj edition of this instance.
	 */
	ICFGenKbToolEditObj getEdit();

	/**
	 *	Get the current edition of this Tool instance as a ICFGenKbToolEditObj.
	 *
	 *	@return	The ICFGenKbToolEditObj edition of this instance.
	 */
	ICFGenKbToolEditObj getEditAsTool();

	/**
	 *	Get the ICFGenKbToolTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbToolTableObj table cache which manages this instance.
	 */
	ICFGenKbToolTableObj getToolTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbToolBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbToolBuff instance which currently backs this object.
	 */
	CFGenKbToolBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbToolBuff value );

	/**
	 *	Get the CFGenKbToolBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbToolBuff instance which currently backs this object.
	 */
	CFGenKbToolBuff getToolBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbToolPKey primary key for this instance.
	 */
	CFGenKbToolPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbToolPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbToolPKey value );

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
	 *	Get the required short attribute Id.
	 *
	 *	@return	The required short attribute Id.
	 */
	short getRequiredId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional Short attribute ReplacesId.
	 *
	 *	@return	The optional Short attribute ReplacesId.
	 */
	Short getOptionalReplacesId();

	/**
	 *	Get the required boolean attribute IsSupported.
	 *
	 *	@return	The required boolean attribute IsSupported.
	 */
	boolean getRequiredIsSupported();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Replaces key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Replaces key.
	 */
	ICFGenKbToolObj getOptionalLookupReplaces();

	/**
	 *	Get the optional ICFGenKbToolObj instance referenced by the Replaces key.
	 *
	 *	@return	The optional ICFGenKbToolObj instance referenced by the Replaces key.
	 */
	ICFGenKbToolObj getOptionalLookupReplaces( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
