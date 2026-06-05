// Description: Java 11 Object interface for CFBam Id64Gen.

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

public interface ICFBamId64GenObj
	extends ICFBamInt64TypeObj
{
	/**
	 *	Get the current edition of this Id64Gen instance as a ICFBamId64GenEditObj.
	 *
	 *	@return	The ICFBamId64GenEditObj edition of this instance.
	 */
	ICFBamId64GenEditObj getEditAsId64Gen();

	/**
	 *	Get the ICFBamId64GenTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamId64GenTableObj table cache which manages this instance.
	 */
	ICFBamId64GenTableObj getId64GenTable();

	/**
	 *	Get the CFBamId64GenBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFBamId64GenBuff instance which currently backs this object.
	 */
	CFBamId64GenBuff getId64GenBuff();

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
	 *	Get the required long attribute BlockSize.
	 *
	 *	@return	The required long attribute BlockSize.
	 */
	long getRequiredBlockSize();

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
