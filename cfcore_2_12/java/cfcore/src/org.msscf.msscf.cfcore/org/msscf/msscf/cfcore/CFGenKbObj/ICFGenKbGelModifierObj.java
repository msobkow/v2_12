// Description: Java 11 Object interface for CFGenKb GelModifier.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public interface ICFGenKbGelModifierObj
	extends ICFGenKbGelInstructionObj
{
	/**
	 *	Get the current edition of this GelModifier instance as a ICFGenKbGelModifierEditObj.
	 *
	 *	@return	The ICFGenKbGelModifierEditObj edition of this instance.
	 */
	ICFGenKbGelModifierEditObj getEditAsGelModifier();

	/**
	 *	Get the ICFGenKbGelModifierTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelModifierTableObj table cache which manages this instance.
	 */
	ICFGenKbGelModifierTableObj getGelModifierTable();

	/**
	 *	Get the CFGenKbGelModifierBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelModifierBuff instance which currently backs this object.
	 */
	CFGenKbGelModifierBuff getGelModifierBuff();

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
