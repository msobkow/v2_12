// Description: Java 11 Object interface for CFBam Id32Gen.

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

public interface ICFBamId32GenObj
	extends ICFBamInt32TypeObj
{
	/**
	 *	Get the current edition of this Id32Gen instance as a ICFBamId32GenEditObj.
	 *
	 *	@return	The ICFBamId32GenEditObj edition of this instance.
	 */
	ICFBamId32GenEditObj getEditAsId32Gen();

	/**
	 *	Get the ICFBamId32GenTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamId32GenTableObj table cache which manages this instance.
	 */
	ICFBamId32GenTableObj getId32GenTable();

	/**
	 *	Get the CFBamId32GenBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamId32GenBuff instance which currently backs this object.
	 */
	CFBamId32GenBuff getId32GenBuff();

	/**
	 *	Get the optional Long attribute DispenserTenantId.
	 *
	 *	@return	The optional Long attribute DispenserTenantId.
	 */
	Long getOptionalDispenserTenantId();

	/**
	 *	Get the optional Long attribute DispenserId.
	 *
	 *	@return	The optional Long attribute DispenserId.
	 */
	Long getOptionalDispenserId();

	/**
	 *	Get the required short attribute Slice.
	 *
	 *	@return	The required short attribute Slice.
	 */
	short getRequiredSlice();

	/**
	 *	Get the required int attribute BlockSize.
	 *
	 *	@return	The required int attribute BlockSize.
	 */
	int getRequiredBlockSize();

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the Dispenser key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the Dispenser key.
	 */
	ICFBamTableObj getOptionalLookupDispenser();

	/**
	 *	Get the optional ICFBamTableObj instance referenced by the Dispenser key.
	 *
	 *	@return	The optional ICFBamTableObj instance referenced by the Dispenser key.
	 */
	ICFBamTableObj getOptionalLookupDispenser( boolean forceRead );

}
