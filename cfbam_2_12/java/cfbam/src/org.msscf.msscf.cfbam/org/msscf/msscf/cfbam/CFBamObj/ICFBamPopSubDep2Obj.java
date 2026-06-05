// Description: Java 11 Object interface for CFBam PopSubDep2.

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

public interface ICFBamPopSubDep2Obj
	extends ICFBamPopDepObj
{
	/**
	 *	Get the current edition of this PopSubDep2 instance as a ICFBamPopSubDep2EditObj.
	 *
	 *	@return	The ICFBamPopSubDep2EditObj edition of this instance.
	 */
	ICFBamPopSubDep2EditObj getEditAsPopSubDep2();

	/**
	 *	Get the ICFBamPopSubDep2TableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamPopSubDep2TableObj table cache which manages this instance.
	 */
	ICFBamPopSubDep2TableObj getPopSubDep2Table();

	/**
	 *	Get the CFBamPopSubDep2Buff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamPopSubDep2Buff instance which currently backs this object.
	 */
	CFBamPopSubDep2Buff getPopSubDep2Buff();

	/**
	 *	Get the required long attribute PopSubDep1TenantId.
	 *
	 *	@return	The required long attribute PopSubDep1TenantId.
	 */
	long getRequiredPopSubDep1TenantId();

	/**
	 *	Get the required long attribute PopSubDep1Id.
	 *
	 *	@return	The required long attribute PopSubDep1Id.
	 */
	long getRequiredPopSubDep1Id();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ICFBamPopSubDep1Obj instance referenced by the PopSubDep1 key.
	 *
	 *	@return	The required ICFBamPopSubDep1Obj instance referenced by the PopSubDep1 key.
	 */
	ICFBamPopSubDep1Obj getRequiredContainerPopSubDep1();

	/**
	 *	Get the required ICFBamPopSubDep1Obj instance referenced by the PopSubDep1 key.
	 *
	 *	@return	The required ICFBamPopSubDep1Obj instance referenced by the PopSubDep1 key.
	 */
	ICFBamPopSubDep1Obj getRequiredContainerPopSubDep1( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPopSubDep3Obj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional ICFBamPopSubDep3Obj[] array of instances referenced by the PopDep key.
	 */
	List<ICFBamPopSubDep3Obj> getOptionalComponentsPopDep();

	/**
	 *	Get the array of optional ICFBamPopSubDep3Obj array of instances referenced by the PopDep key.
	 *
	 *	@return	The optional ICFBamPopSubDep3Obj[] array of instances referenced by the PopDep key.
	 */
	List<ICFBamPopSubDep3Obj> getOptionalComponentsPopDep( boolean forceRead );

}
