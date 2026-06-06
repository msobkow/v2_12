// Description: Java 11 Object interface for CFGenKb GelSwitch.

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
import org.msscf.msscf.cfcore.MssCF.*;

public interface ICFGenKbGelSwitchObj
	extends ICFGenKbGelInstructionObj
{
	/**
	 *	Get the current edition of this GelSwitch instance as a ICFGenKbGelSwitchEditObj.
	 *
	 *	@return	The ICFGenKbGelSwitchEditObj edition of this instance.
	 */
	ICFGenKbGelSwitchEditObj getEditAsGelSwitch();

	/**
	 *	Get the ICFGenKbGelSwitchTableObj table cache which manages this instance.
	 *
	 *	@return	ICFGenKbGelSwitchTableObj table cache which manages this instance.
	 */
	ICFGenKbGelSwitchTableObj getGelSwitchTable();

	/**
	 *	Get the CFGenKbGelSwitchBuff instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	CFGenKbGelSwitchBuff instance which currently backs this object.
	 */
	CFGenKbGelSwitchBuff getGelSwitchBuff();

	/**
	 *	Get the required String attribute ValueExpansion.
	 *
	 *	@return	The required String attribute ValueExpansion.
	 */
	String getRequiredValueExpansion();

	/**
	 *	Get the optional String attribute NilExpansion.
	 *
	 *	@return	The optional String attribute NilExpansion.
	 */
	String getOptionalNilExpansion();

	/**
	 *	Get the optional String attribute EmptyExpansion.
	 *
	 *	@return	The optional String attribute EmptyExpansion.
	 */
	String getOptionalEmptyExpansion();

	/**
	 *	Get the required String attribute DefaultExpansion.
	 *
	 *	@return	The required String attribute DefaultExpansion.
	 */
	String getRequiredDefaultExpansion();

	/**
	 *	Get the array of optional ICFGenKbGelSwitchLimbObj array of instances referenced by the SwitchLimb key.
	 *
	 *	@return	The optional ICFGenKbGelSwitchLimbObj[] array of instances referenced by the SwitchLimb key.
	 */
	List<ICFGenKbGelSwitchLimbObj> getOptionalChildrenSwitchLimb();

	/**
	 *	Get the array of optional ICFGenKbGelSwitchLimbObj array of instances referenced by the SwitchLimb key.
	 *
	 *	@return	The optional ICFGenKbGelSwitchLimbObj[] array of instances referenced by the SwitchLimb key.
	 */
	List<ICFGenKbGelSwitchLimbObj> getOptionalChildrenSwitchLimb( boolean forceRead );

}
