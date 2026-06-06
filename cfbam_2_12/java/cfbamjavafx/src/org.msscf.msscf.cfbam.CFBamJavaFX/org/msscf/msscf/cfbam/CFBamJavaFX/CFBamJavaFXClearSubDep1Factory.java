// Description: Java 11 JavaFX Display Element Factory for ClearSubDep1.

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
 *	CFBamJavaFXClearSubDep1Factory JavaFX Display Element Factory
 *	for ClearSubDep1.
 */
public class CFBamJavaFXClearSubDep1Factory
implements ICFBamJavaFXClearSubDep1Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXClearSubDep1Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus ) {
		CFBamJavaFXClearSubDep1AttrPane retnew = new CFBamJavaFXClearSubDep1AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamClearTopDepObj argContainer,
		ICFBamClearSubDep1Obj argFocus,
		Collection<ICFBamClearSubDep1Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXClearSubDep1ListPane retnew = new CFBamJavaFXClearSubDep1ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamClearSubDep1Obj argFocus,
		ICFBamClearTopDepObj argContainer,
		Collection<ICFBamClearSubDep1Obj> argDataCollection,
		ICFBamJavaFXClearSubDep1Chosen whenChosen )
	{
		CFBamJavaFXClearSubDep1PickerPane retnew = new CFBamJavaFXClearSubDep1PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus ) {
		CFBamJavaFXClearSubDep1EltTabPane retnew = new CFBamJavaFXClearSubDep1EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus ) {
		CFBamJavaFXClearSubDep1AddPane retnew = new CFBamJavaFXClearSubDep1AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus ) {
		CFBamJavaFXClearSubDep1ViewEditPane retnew = new CFBamJavaFXClearSubDep1ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXClearSubDep1AskDeleteForm retnew = new CFBamJavaFXClearSubDep1AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamClearSubDep1Obj argFocus,
		ICFBamClearTopDepObj argContainer,
		Collection<ICFBamClearSubDep1Obj> argDataCollection,
		ICFBamJavaFXClearSubDep1Chosen whenChosen )
	{
		CFBamJavaFXClearSubDep1PickerForm retnew = new CFBamJavaFXClearSubDep1PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXClearSubDep1AddForm retnew = new CFBamJavaFXClearSubDep1AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamClearSubDep1Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXClearSubDep1ViewEditForm retnew = new CFBamJavaFXClearSubDep1ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
