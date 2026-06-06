// Description: Java 11 Instance Edit Object interface for CFInt ISOCtryLang.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFInt.*;

public interface ICFIntISOCtryLangEditObj
	extends ICFIntISOCtryLangObj,
		ICFSecISOCtryLangEditObj
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
