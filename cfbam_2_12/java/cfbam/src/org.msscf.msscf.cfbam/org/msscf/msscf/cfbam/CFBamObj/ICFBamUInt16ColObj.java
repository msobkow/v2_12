// Description: Java 11 Object interface for CFBam UInt16Col.

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

public interface ICFBamUInt16ColObj
	extends ICFBamUInt16DefObj
{
	/**
	 *	Get the current edition of this UInt16Col instance as a ICFBamUInt16ColEditObj.
	 *
	 *	@return	The ICFBamUInt16ColEditObj edition of this instance.
	 */
	ICFBamUInt16ColEditObj getEditAsUInt16Col();

	/**
	 *	Get the ICFBamUInt16ColTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamUInt16ColTableObj table cache which manages this instance.
	 */
	ICFBamUInt16ColTableObj getUInt16ColTable();

	/**
	 *	Get the CFBamUInt16ColBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamUInt16ColBuff instance which currently backs this object.
	 */
	CFBamUInt16ColBuff getUInt16ColBuff();

	/**
	 *	Get the required long attribute TableId.
	 *
	 *	@return	The required long attribute TableId.
	 */
	long getRequiredTableId();

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

}
