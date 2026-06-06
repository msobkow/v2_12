// Description: Java 11 JavaFX Display Element Factory for PopSubDep1.

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
 *	CFBamJavaFXPopSubDep1Factory JavaFX Display Element Factory
 *	for PopSubDep1.
 */
public class CFBamJavaFXPopSubDep1Factory
implements ICFBamJavaFXPopSubDep1Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXPopSubDep1Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus ) {
		CFBamJavaFXPopSubDep1AttrPane retnew = new CFBamJavaFXPopSubDep1AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamPopTopDepObj argContainer,
		ICFBamPopSubDep1Obj argFocus,
		Collection<ICFBamPopSubDep1Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXPopSubDep1ListPane retnew = new CFBamJavaFXPopSubDep1ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamPopSubDep1Obj argFocus,
		ICFBamPopTopDepObj argContainer,
		Collection<ICFBamPopSubDep1Obj> argDataCollection,
		ICFBamJavaFXPopSubDep1Chosen whenChosen )
	{
		CFBamJavaFXPopSubDep1PickerPane retnew = new CFBamJavaFXPopSubDep1PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus ) {
		CFBamJavaFXPopSubDep1EltTabPane retnew = new CFBamJavaFXPopSubDep1EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus ) {
		CFBamJavaFXPopSubDep1AddPane retnew = new CFBamJavaFXPopSubDep1AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus ) {
		CFBamJavaFXPopSubDep1ViewEditPane retnew = new CFBamJavaFXPopSubDep1ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXPopSubDep1AskDeleteForm retnew = new CFBamJavaFXPopSubDep1AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamPopSubDep1Obj argFocus,
		ICFBamPopTopDepObj argContainer,
		Collection<ICFBamPopSubDep1Obj> argDataCollection,
		ICFBamJavaFXPopSubDep1Chosen whenChosen )
	{
		CFBamJavaFXPopSubDep1PickerForm retnew = new CFBamJavaFXPopSubDep1PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXPopSubDep1AddForm retnew = new CFBamJavaFXPopSubDep1AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamPopSubDep1Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXPopSubDep1ViewEditForm retnew = new CFBamJavaFXPopSubDep1ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
