// Description: Java 11 JavaFX Display Element Factory Interface for StringDef.

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
 *	ICFBamJavaFXStringDefFactory JavaFX Display Element Factory Interface
 *	for StringDef.
 */
public interface ICFBamJavaFXStringDefFactory
{
	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamStringDefObj javaFXFocus );

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamStringDefObj argFocus,
		Collection<ICFBamStringDefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain );

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamStringDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamStringDefObj> argDataCollection,
		ICFBamJavaFXStringDefChosen whenChosen );

	public CFTabPane newEltTabPane( ICFFormManager formManger, ICFBamStringDefObj javaFXFocus );

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamStringDefObj javaFXFocus, ICFDeleteCallback callback );

	public CFSplitPane newAddPane( ICFFormManager formManger, ICFBamStringDefObj javaFXFocus );

	public CFSplitPane newViewEditPane( ICFFormManager formManger, ICFBamStringDefObj javaFXFocus );

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamStringDefObj javaFXFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamStringDefObj> argDataCollection,
		ICFBamJavaFXStringDefChosen whenChosen );

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamStringDefObj javaFXFocus, ICFFormClosedCallback closeCallback, boolean allowSave );

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamStringDefObj javaFXFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd );
}
