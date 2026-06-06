// Description: Java 11 Object interface for CFBam PopSubDep3.

/*
 *	org.msscf.msscf.CFBam
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

public interface ICFBamPopSubDep3Obj
	extends ICFBamPopDepObj
{
	/**
	 *	Get the current edition of this PopSubDep3 instance as a ICFBamPopSubDep3EditObj.
	 *
	 *	@return	The ICFBamPopSubDep3EditObj edition of this instance.
	 */
	ICFBamPopSubDep3EditObj getEditAsPopSubDep3();

	/**
	 *	Get the ICFBamPopSubDep3TableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamPopSubDep3TableObj table cache which manages this instance.
	 */
	ICFBamPopSubDep3TableObj getPopSubDep3Table();

	/**
	 *	Get the CFBamPopSubDep3Buff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamPopSubDep3Buff instance which currently backs this object.
	 */
	CFBamPopSubDep3Buff getPopSubDep3Buff();

	/**
	 *	Get the required long attribute PopSubDep2TenantId.
	 *
	 *	@return	The required long attribute PopSubDep2TenantId.
	 */
	long getRequiredPopSubDep2TenantId();

	/**
	 *	Get the required long attribute PopSubDep2Id.
	 *
	 *	@return	The required long attribute PopSubDep2Id.
	 */
	long getRequiredPopSubDep2Id();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 *
	 *	@return	The required ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 */
	ICFBamPopSubDep2Obj getRequiredContainerPopSubDep2();

	/**
	 *	Get the required ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 *
	 *	@return	The required ICFBamPopSubDep2Obj instance referenced by the PopSubDep2 key.
	 */
	ICFBamPopSubDep2Obj getRequiredContainerPopSubDep2( boolean forceRead );

}
