// Description: Java 11 Object interface for CFGenKb GenTrunc.

/*
 *	org.msscf.msscf.CFCore
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

package org.msscf.msscf.cfcore.CFGenKbObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cfcore.CFGenKb.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.CFGenKb.*;

public interface ICFGenKbGenTruncObj
	extends ICFGenKbGenRuleObj
{
	/**
	 *	Get the current edition of this GenTrunc instance as a ICFGenKbGenTruncEditObj.
	 *
	 *	@return	The ICFGenKbGenTruncEditObj edition of this instance.
	 */
	ICFGenKbGenTruncEditObj getEditAsGenTrunc();

	/**
	 *	Get the ICFGenKbGenTruncTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGenTruncTableObj table cache which manages this instance.
	 */
	ICFGenKbGenTruncTableObj getGenTruncTable();

	/**
	 *	Get the CFGenKbGenTruncBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGenTruncBuff instance which currently backs this object.
	 */
	CFGenKbGenTruncBuff getGenTruncBuff();

	/**
	 *	Get the required int attribute TruncateAt.
	 *
	 *	@return	The required int attribute TruncateAt.
	 */
	int getRequiredTruncateAt();

}
