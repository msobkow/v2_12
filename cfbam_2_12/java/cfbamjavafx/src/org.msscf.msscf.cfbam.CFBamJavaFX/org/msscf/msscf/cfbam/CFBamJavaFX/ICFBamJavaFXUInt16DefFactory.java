// Description: Java 11 JavaFX Display Element Factory Interface for UInt16Def.

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

package org.msscf.msscf.cfbam.CFBamJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/**
 *	ICFBamJavaFXUInt16DefFactory JavaFX Display Element Factory Interface
 *	for UInt16Def.
 */
public interface ICFBamJavaFXUInt16DefFactory
{
	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamUInt16DefObj javaFXFocus );

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamUInt16DefObj argFocus,
		Collection<ICFBamUInt16DefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain );

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamUInt16DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamUInt16DefObj> argDataCollection,
		ICFBamJavaFXUInt16DefChosen whenChosen );

	public CFTabPane newEltTabPane( ICFFormManager formManger, ICFBamUInt16DefObj javaFXFocus );

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamUInt16DefObj javaFXFocus, ICFDeleteCallback callback );

	public CFSplitPane newAddPane( ICFFormManager formManger, ICFBamUInt16DefObj javaFXFocus );

	public CFSplitPane newViewEditPane( ICFFormManager formManger, ICFBamUInt16DefObj javaFXFocus );

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamUInt16DefObj javaFXFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamUInt16DefObj> argDataCollection,
		ICFBamJavaFXUInt16DefChosen whenChosen );

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamUInt16DefObj javaFXFocus, ICFFormClosedCallback closeCallback, boolean allowSave );

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamUInt16DefObj javaFXFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd );
}
