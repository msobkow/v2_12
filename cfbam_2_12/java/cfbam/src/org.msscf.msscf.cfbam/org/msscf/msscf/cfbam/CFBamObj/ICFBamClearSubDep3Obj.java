// Description: Java 11 Object interface for CFBam ClearSubDep3.

/*
 *	org.msscf.msscf.CFBam
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

public interface ICFBamClearSubDep3Obj
	extends ICFBamClearDepObj
{
	/**
	 *	Get the current edition of this ClearSubDep3 instance as a ICFBamClearSubDep3EditObj.
	 *
	 *	@return	The ICFBamClearSubDep3EditObj edition of this instance.
	 */
	ICFBamClearSubDep3EditObj getEditAsClearSubDep3();

	/**
	 *	Get the ICFBamClearSubDep3TableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamClearSubDep3TableObj table cache which manages this instance.
	 */
	ICFBamClearSubDep3TableObj getClearSubDep3Table();

	/**
	 *	Get the CFBamClearSubDep3Buff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamClearSubDep3Buff instance which currently backs this object.
	 */
	CFBamClearSubDep3Buff getClearSubDep3Buff();

	/**
	 *	Get the required long attribute ClearSubDep2TenantId.
	 *
	 *	@return	The required long attribute ClearSubDep2TenantId.
	 */
	long getRequiredClearSubDep2TenantId();

	/**
	 *	Get the required long attribute ClearSubDep2Id.
	 *
	 *	@return	The required long attribute ClearSubDep2Id.
	 */
	long getRequiredClearSubDep2Id();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ICFBamClearSubDep2Obj instance referenced by the ClearSubDep2 key.
	 *
	 *	@return	The required ICFBamClearSubDep2Obj instance referenced by the ClearSubDep2 key.
	 */
	ICFBamClearSubDep2Obj getRequiredContainerClearSubDep2();

	/**
	 *	Get the required ICFBamClearSubDep2Obj instance referenced by the ClearSubDep2 key.
	 *
	 *	@return	The required ICFBamClearSubDep2Obj instance referenced by the ClearSubDep2 key.
	 */
	ICFBamClearSubDep2Obj getRequiredContainerClearSubDep2( boolean forceRead );

}
