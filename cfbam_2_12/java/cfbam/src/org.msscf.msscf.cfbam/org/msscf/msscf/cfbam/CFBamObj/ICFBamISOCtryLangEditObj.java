// Description: Java 11 Instance Edit Object interface for CFBam ISOCtryLang.

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
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;

public interface ICFBamISOCtryLangEditObj
	extends ICFBamISOCtryLangObj,
		ICFSecISOCtryLangEditObj,
		ICFIntISOCtryLangEditObj
{
	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ICFSecISOCtryLangObj create();

	/*
	 *	Update the instance.
	 */
	CFSecISOCtryLangEditObj update();

	/**
	 *	Get the ICFSecISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The ICFSecISOCtryObj instance referenced by the Ctry key.
	 */
	ICFSecISOCtryObj getRequiredContainerCtry();

	/**
	 *	Set the ICFSecISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@param	value	the ICFSecISOCtryObj instance to be referenced by the Ctry key.
	 */
	void setRequiredContainerCtry( ICFSecISOCtryObj value );

	/**
	 *	Get the ICFSecISOLangObj instance referenced by the Lang key.
	 *
	 *	@return	The ICFSecISOLangObj instance referenced by the Lang key.
	 */
	ICFSecISOLangObj getRequiredParentLang();

	/**
	 *	Set the ICFSecISOLangObj instance referenced by the Lang key.
	 *
	 *	@param	value	the ICFSecISOLangObj instance to be referenced by the Lang key.
	 */
	void setRequiredParentLang( ICFSecISOLangObj value );
}
