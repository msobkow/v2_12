// Description: Java 11 Object interface for CFBam DelTopDep.

/*
 *	org.msscf.msscf.CFBam
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

public interface ICFBamDelTopDepObj
	extends ICFBamDelDepObj
{
	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamDelTopDepObj the reference to the moved and refreshed instance.
	 */
	ICFBamDelTopDepObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamDelTopDepObj the reference to the moved and refreshed instance.
	 */
	ICFBamDelTopDepObj moveDown();

	/**
	 *	Get the current edition of this DelTopDep instance as a ICFBamDelTopDepEditObj.
	 *
	 *	@return	The ICFBamDelTopDepEditObj edition of this instance.
	 */
	ICFBamDelTopDepEditObj getEditAsDelTopDep();

	/**
	 *	Get the ICFBamDelTopDepTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamDelTopDepTableObj table cache which manages this instance.
	 */
	ICFBamDelTopDepTableObj getDelTopDepTable();

	/**
	 *	Get the CFBamDelTopDepBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamDelTopDepBuff instance which currently backs this object.
	 */
	CFBamDelTopDepBuff getDelTopDepBuff();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

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
	 *	Get the array of optional ICFBamDelSubDep1Obj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelSubDep1Obj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelSubDep1Obj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional ICFBamDelSubDep1Obj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamDelSubDep1Obj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamDelSubDep1Obj> getOptionalComponentsDelDep( boolean forceRead );

	/**
	 *	Get the optional ICFBamDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj instance referenced by the Prev key.
	 */
	ICFBamDelTopDepObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj instance referenced by the Prev key.
	 */
	ICFBamDelTopDepObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamDelTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj instance referenced by the Next key.
	 */
	ICFBamDelTopDepObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamDelTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamDelTopDepObj instance referenced by the Next key.
	 */
	ICFBamDelTopDepObj getOptionalLookupNext( boolean forceRead );

}
