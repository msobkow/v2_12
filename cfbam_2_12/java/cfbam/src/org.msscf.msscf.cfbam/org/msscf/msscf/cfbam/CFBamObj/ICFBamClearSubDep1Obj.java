// Description: Java 11 Object interface for CFBam ClearSubDep1.

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

public interface ICFBamClearSubDep1Obj
	extends ICFBamClearDepObj
{
	/**
	 *	Get the current edition of this ClearSubDep1 instance as a ICFBamClearSubDep1EditObj.
	 *
	 *	@return	The ICFBamClearSubDep1EditObj edition of this instance.
	 */
	ICFBamClearSubDep1EditObj getEditAsClearSubDep1();

	/**
	 *	Get the ICFBamClearSubDep1TableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamClearSubDep1TableObj table cache which manages this instance.
	 */
	ICFBamClearSubDep1TableObj getClearSubDep1Table();

	/**
	 *	Get the CFBamClearSubDep1Buff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamClearSubDep1Buff instance which currently backs this object.
	 */
	CFBamClearSubDep1Buff getClearSubDep1Buff();

	/**
	 *	Get the required long attribute ClearTopDepTenantId.
	 *
	 *	@return	The required long attribute ClearTopDepTenantId.
	 */
	long getRequiredClearTopDepTenantId();

	/**
	 *	Get the required long attribute ClearTopDepId.
	 *
	 *	@return	The required long attribute ClearTopDepId.
	 */
	long getRequiredClearTopDepId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required ICFBamClearTopDepObj instance referenced by the ClearTopDep key.
	 *
	 *	@return	The required ICFBamClearTopDepObj instance referenced by the ClearTopDep key.
	 */
	ICFBamClearTopDepObj getRequiredContainerClearTopDep();

	/**
	 *	Get the required ICFBamClearTopDepObj instance referenced by the ClearTopDep key.
	 *
	 *	@return	The required ICFBamClearTopDepObj instance referenced by the ClearTopDep key.
	 */
	ICFBamClearTopDepObj getRequiredContainerClearTopDep( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamClearSubDep2Obj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearSubDep2Obj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearSubDep2Obj> getOptionalComponentsClearDep();

	/**
	 *	Get the array of optional ICFBamClearSubDep2Obj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearSubDep2Obj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearSubDep2Obj> getOptionalComponentsClearDep( boolean forceRead );

}
