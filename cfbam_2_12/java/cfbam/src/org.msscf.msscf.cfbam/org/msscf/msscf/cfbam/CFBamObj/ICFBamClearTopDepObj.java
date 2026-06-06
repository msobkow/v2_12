// Description: Java 11 Object interface for CFBam ClearTopDep.

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

public interface ICFBamClearTopDepObj
	extends ICFBamClearDepObj
{
	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamClearTopDepObj the reference to the moved and refreshed instance.
	 */
	ICFBamClearTopDepObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamClearTopDepObj the reference to the moved and refreshed instance.
	 */
	ICFBamClearTopDepObj moveDown();

	/**
	 *	Get the current edition of this ClearTopDep instance as a ICFBamClearTopDepEditObj.
	 *
	 *	@return	The ICFBamClearTopDepEditObj edition of this instance.
	 */
	ICFBamClearTopDepEditObj getEditAsClearTopDep();

	/**
	 *	Get the ICFBamClearTopDepTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamClearTopDepTableObj table cache which manages this instance.
	 */
	ICFBamClearTopDepTableObj getClearTopDepTable();

	/**
	 *	Get the CFBamClearTopDepBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamClearTopDepBuff instance which currently backs this object.
	 */
	CFBamClearTopDepBuff getClearTopDepBuff();

	/**
	 *	Get the required long attribute TableTenantId.
	 *
	 *	@return	The required long attribute TableTenantId.
	 */
	long getRequiredTableTenantId();

	/**
	 *	Get the required long attribute TableId.
	 *
	 *	@return	The required long attribute TableId.
	 */
	long getRequiredTableId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the optional Long attribute PrevTenantId.
	 *
	 *	@return	The optional Long attribute PrevTenantId.
	 */
	Long getOptionalPrevTenantId();

	/**
	 *	Get the optional Long attribute PrevId.
	 *
	 *	@return	The optional Long attribute PrevId.
	 */
	Long getOptionalPrevId();

	/**
	 *	Get the optional Long attribute NextTenantId.
	 *
	 *	@return	The optional Long attribute NextTenantId.
	 */
	Long getOptionalNextTenantId();

	/**
	 *	Get the optional Long attribute NextId.
	 *
	 *	@return	The optional Long attribute NextId.
	 */
	Long getOptionalNextId();

	/**
	 *	Get the required ICFBamTableObj instance referenced by the Table key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the Table key.
	 */
	ICFBamTableObj getRequiredContainerTable();

	/**
	 *	Get the required ICFBamTableObj instance referenced by the Table key.
	 *
	 *	@return	The required ICFBamTableObj instance referenced by the Table key.
	 */
	ICFBamTableObj getRequiredContainerTable( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamClearSubDep1Obj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearSubDep1Obj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearSubDep1Obj> getOptionalComponentsClearDep();

	/**
	 *	Get the array of optional ICFBamClearSubDep1Obj array of instances referenced by the ClearDep key.
	 *
	 *	@return	The optional ICFBamClearSubDep1Obj[] array of instances referenced by the ClearDep key.
	 */
	List<ICFBamClearSubDep1Obj> getOptionalComponentsClearDep( boolean forceRead );

	/**
	 *	Get the optional ICFBamClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj instance referenced by the Prev key.
	 */
	ICFBamClearTopDepObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj instance referenced by the Prev key.
	 */
	ICFBamClearTopDepObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamClearTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj instance referenced by the Next key.
	 */
	ICFBamClearTopDepObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamClearTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamClearTopDepObj instance referenced by the Next key.
	 */
	ICFBamClearTopDepObj getOptionalLookupNext( boolean forceRead );

}
