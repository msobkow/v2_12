// Description: Java 11 Object interface for CFGenKb GelReference.

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
import org.msscf.msscf.cfcore.MssCF.*;

public interface ICFGenKbGelReferenceObj
	extends ICFGenKbGelInstructionObj
{
	/**
	 *	Get the current edition of this GelReference instance as a ICFGenKbGelReferenceEditObj.
	 *
	 *	@return	The ICFGenKbGelReferenceEditObj edition of this instance.
	 */
	ICFGenKbGelReferenceEditObj getEditAsGelReference();

	/**
	 *	Get the ICFGenKbGelReferenceTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelReferenceTableObj table cache which manages this instance.
	 */
	ICFGenKbGelReferenceTableObj getGelReferenceTable();

	/**
	 *	Get the CFGenKbGelReferenceBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelReferenceBuff instance which currently backs this object.
	 */
	CFGenKbGelReferenceBuff getGelReferenceBuff();

	/**
	 *	Get the required String attribute ReferenceName.
	 *
	 *	@return	The required String attribute ReferenceName.
	 */
	String getRequiredReferenceName();

	/**
	 *	Get the optional Long attribute RemainderTenantId.
	 *
	 *	@return	The optional Long attribute RemainderTenantId.
	 */
	Long getOptionalRemainderTenantId();

	/**
	 *	Get the required long attribute RemainderGelCacheId.
	 *
	 *	@return	The required long attribute RemainderGelCacheId.
	 */
	long getRequiredRemainderGelCacheId();

	/**
	 *	Get the optional Long attribute RemainderInstId.
	 *
	 *	@return	The optional Long attribute RemainderInstId.
	 */
	Long getOptionalRemainderInstId();

	/**
	 *	Get the optional ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 *
	 *	@return	The optional ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupRemainder();

	/**
	 *	Get the optional ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 *
	 *	@return	The optional ICFGenKbGelInstructionObj instance referenced by the Remainder key.
	 */
	ICFGenKbGelInstructionObj getOptionalLookupRemainder( boolean forceRead );

}
