// Description: Java 11 Object interface for CFGenKb GelBoilerplate.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cfcore.MssCF.MssCFEngine;
import org.msscf.msscf.cfcore.MssCF.MssCFGenContext;

public interface ICFGenKbGelBoilerplateObj
	extends ICFGenKbGelInstructionObj
{
	/**
	 *	Get the current edition of this GelBoilerplate instance as a ICFGenKbGelBoilerplateEditObj.
	 *
	 *	@return	The ICFGenKbGelBoilerplateEditObj edition of this instance.
	 */
	ICFGenKbGelBoilerplateEditObj getEditAsGelBoilerplate();

	/**
	 *	Get the ICFGenKbGelBoilerplateTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelBoilerplateTableObj table cache which manages this instance.
	 */
	ICFGenKbGelBoilerplateTableObj getGelBoilerplateTable();

	/**
	 *	Get the CFGenKbGelBoilerplateBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelBoilerplateBuff instance which currently backs this object.
	 */
	CFGenKbGelBoilerplateBuff getGelBoilerplateBuff();

}
