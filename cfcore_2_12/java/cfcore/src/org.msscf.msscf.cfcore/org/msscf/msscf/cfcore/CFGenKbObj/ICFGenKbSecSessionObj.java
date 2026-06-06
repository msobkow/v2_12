// Description: Java 11 Object interface for CFGenKb SecSession.

/*
 *	org.msscf.msscf.CFCore
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

public interface ICFGenKbSecSessionObj
	extends ICFLibAnyObj
{
	String getClassCode();
	/**
	 *	Realise this instance of a SecSession.
	 *
	 *	@return	CFGenKbSecSessionObj instance which should be subsequently referenced.
	 */
	ICFGenKbSecSessionObj realise();

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
	 *	@return	ICFGenKbSecSessionObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecSessionObj read();

	/**
	 *	Re-read this instance by it's primary key.
	 *
	 *	@return	ICFGenKbSecSessionObj the reference to the cached or read (realised) instance.
	 */
	ICFGenKbSecSessionObj read( boolean forceRead );

	/**
	 *	Initialize and return a locked edition of this SecSession instance.
	 *
	 *	@return	The newly locked ICFGenKbSecSessionEditObj edition of this instance.
	 */
	ICFGenKbSecSessionEditObj beginEdit();

	/**
	 *	End this edition of this SecSession instance.
	 *
	 *	@throws	CFLibNotSupportedException if you try to end a read-only view.
	 */
	void endEdit();

	/**
	 *	Get the current edition of this SecSession instance.
	 *
	 *	@return	The ICFGenKbSecSessionEditObj edition of this instance.
	 */
	ICFGenKbSecSessionEditObj getEdit();

	/**
	 *	Get the current edition of this SecSession instance as a ICFGenKbSecSessionEditObj.
	 *
	 *	@return	The ICFGenKbSecSessionEditObj edition of this instance.
	 */
	ICFGenKbSecSessionEditObj getEditAsSecSession();

	/**
	 *	Get the ICFGenKbSecSessionTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbSecSessionTableObj table cache which manages this instance.
	 */
	ICFGenKbSecSessionTableObj getSecSessionTable();

	/**
	 *	Get the ICFGenKbSchemaObj schema cache which manages this instance.
	 *
	 *	@return	ICFGenKbSchemaObj schema cache which manages this instance.
	 */
	ICFGenKbSchemaObj getSchema();

	/**
	 *	Get the CFGenKbSecSessionBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecSessionBuff instance which currently backs this object.
	 */
	CFGenKbSecSessionBuff getBuff();

	/**
	 *	Internal use only.
	 */
	void setBuff( CFGenKbSecSessionBuff value );

	/**
	 *	Get the CFGenKbSecSessionBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbSecSessionBuff instance which currently backs this object.
	 */
	CFGenKbSecSessionBuff getSecSessionBuff();

	/**
	 *	Get the primary key of this instance.
	 *
	 *	@return	CFGenKbSecSessionPKey primary key for this instance.
	 */
	CFGenKbSecSessionPKey getPKey();

	/**
	 *	Set the primary key of this instance.
	 *	<p>
	 *	This method should only be invoked by implementation internals.
	 *
	 *	@param CFGenKbSecSessionPKey primary key value for this instance.
	 */
	void setPKey( CFGenKbSecSessionPKey value );

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
	 *	Get the required UUID attribute SecSessionId.
	 *
	 *	@return	The required UUID attribute SecSessionId.
	 */
	UUID getRequiredSecSessionId();

	/**
	 *	Get the required UUID attribute SecUserId.
	 *
	 *	@return	The required UUID attribute SecUserId.
	 */
	UUID getRequiredSecUserId();

	/**
	 *	Get the optional String attribute SecDevName.
	 *
	 *	@return	The optional String attribute SecDevName.
	 */
	String getOptionalSecDevName();

	/**
	 *	Get the required Calendar attribute Start.
	 *
	 *	@return	The required Calendar attribute Start.
	 */
	Calendar getRequiredStart();

	/**
	 *	Get the optional Calendar attribute Finish.
	 *
	 *	@return	The optional Calendar attribute Finish.
	 */
	Calendar getOptionalFinish();

	/**
	 *	Get the optional UUID attribute SecProxyId.
	 *
	 *	@return	The optional UUID attribute SecProxyId.
	 */
	UUID getOptionalSecProxyId();

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 */
	ICFGenKbSecUserObj getRequiredContainerSecUser();

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the SecUser key.
	 */
	ICFGenKbSecUserObj getRequiredContainerSecUser( boolean forceRead );

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the SecProxy key.
	 */
	ICFGenKbSecUserObj getRequiredParentSecProxy();

	/**
	 *	Get the required ICFGenKbSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The required ICFGenKbSecUserObj instance referenced by the SecProxy key.
	 */
	ICFGenKbSecUserObj getRequiredParentSecProxy( boolean forceRead );

	/**
	 *	Internal use only.
	 */
	void copyPKeyToBuff();

	/**
	 *	Internal use only.
	 */
	void copyBuffToPKey();

}
