// Description: Java 11 JavaFX Display Element Factory for ClearSubDep2.

/*
 *	org.msscf.msscf.CFBam
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
 *	CFBamJavaFXClearSubDep2Factory JavaFX Display Element Factory
 *	for ClearSubDep2.
 */
public class CFBamJavaFXClearSubDep2Factory
implements ICFBamJavaFXClearSubDep2Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXClearSubDep2Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus ) {
		CFBamJavaFXClearSubDep2AttrPane retnew = new CFBamJavaFXClearSubDep2AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamClearSubDep1Obj argContainer,
		ICFBamClearSubDep2Obj argFocus,
		Collection<ICFBamClearSubDep2Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXClearSubDep2ListPane retnew = new CFBamJavaFXClearSubDep2ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamClearSubDep2Obj argFocus,
		ICFBamClearSubDep1Obj argContainer,
		Collection<ICFBamClearSubDep2Obj> argDataCollection,
		ICFBamJavaFXClearSubDep2Chosen whenChosen )
	{
		CFBamJavaFXClearSubDep2PickerPane retnew = new CFBamJavaFXClearSubDep2PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus ) {
		CFBamJavaFXClearSubDep2EltTabPane retnew = new CFBamJavaFXClearSubDep2EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus ) {
		CFBamJavaFXClearSubDep2AddPane retnew = new CFBamJavaFXClearSubDep2AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus ) {
		CFBamJavaFXClearSubDep2ViewEditPane retnew = new CFBamJavaFXClearSubDep2ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXClearSubDep2AskDeleteForm retnew = new CFBamJavaFXClearSubDep2AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamClearSubDep2Obj argFocus,
		ICFBamClearSubDep1Obj argContainer,
		Collection<ICFBamClearSubDep2Obj> argDataCollection,
		ICFBamJavaFXClearSubDep2Chosen whenChosen )
	{
		CFBamJavaFXClearSubDep2PickerForm retnew = new CFBamJavaFXClearSubDep2PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXClearSubDep2AddForm retnew = new CFBamJavaFXClearSubDep2AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamClearSubDep2Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXClearSubDep2ViewEditForm retnew = new CFBamJavaFXClearSubDep2ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
