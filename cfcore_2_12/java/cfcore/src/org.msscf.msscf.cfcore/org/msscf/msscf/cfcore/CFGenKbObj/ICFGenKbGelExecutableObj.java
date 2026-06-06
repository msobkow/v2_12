// Description: Java 11 Object interface for CFGenKb GelExecutable.

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

public interface ICFGenKbGelExecutableObj
	extends ICFGenKbGelSequenceObj
{
	/**
	 *	Get the current edition of this GelExecutable instance as a ICFGenKbGelExecutableEditObj.
	 *
	 *	@return	The ICFGenKbGelExecutableEditObj edition of this instance.
	 */
	ICFGenKbGelExecutableEditObj getEditAsGelExecutable();

	/**
	 *	Get the ICFGenKbGelExecutableTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelExecutableTableObj table cache which manages this instance.
	 */
	ICFGenKbGelExecutableTableObj getGelExecutableTable();

	/**
	 *	Get the CFGenKbGelExecutableBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelExecutableBuff instance which currently backs this object.
	 */
	CFGenKbGelExecutableBuff getGelExecutableBuff();

	/**
	 *	Get the required long attribute GenItemId.
	 *
	 *	@return	The required long attribute GenItemId.
	 */
	long getRequiredGenItemId();

	public void addCalledInstruction( ICFGenKbGelCacheObj gelCache, ICFGenKbGelInstructionObj calledInstruction );
	public String expand( MssCFGenContext genContext );
}
