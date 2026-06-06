// Description: Java 11 JavaFX Display Element Factory for DelSubDep1.

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
 *	CFBamJavaFXDelSubDep1Factory JavaFX Display Element Factory
 *	for DelSubDep1.
 */
public class CFBamJavaFXDelSubDep1Factory
implements ICFBamJavaFXDelSubDep1Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXDelSubDep1Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus ) {
		CFBamJavaFXDelSubDep1AttrPane retnew = new CFBamJavaFXDelSubDep1AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamDelTopDepObj argContainer,
		ICFBamDelSubDep1Obj argFocus,
		Collection<ICFBamDelSubDep1Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXDelSubDep1ListPane retnew = new CFBamJavaFXDelSubDep1ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamDelSubDep1Obj argFocus,
		ICFBamDelTopDepObj argContainer,
		Collection<ICFBamDelSubDep1Obj> argDataCollection,
		ICFBamJavaFXDelSubDep1Chosen whenChosen )
	{
		CFBamJavaFXDelSubDep1PickerPane retnew = new CFBamJavaFXDelSubDep1PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus ) {
		CFBamJavaFXDelSubDep1EltTabPane retnew = new CFBamJavaFXDelSubDep1EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus ) {
		CFBamJavaFXDelSubDep1AddPane retnew = new CFBamJavaFXDelSubDep1AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus ) {
		CFBamJavaFXDelSubDep1ViewEditPane retnew = new CFBamJavaFXDelSubDep1ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXDelSubDep1AskDeleteForm retnew = new CFBamJavaFXDelSubDep1AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamDelSubDep1Obj argFocus,
		ICFBamDelTopDepObj argContainer,
		Collection<ICFBamDelSubDep1Obj> argDataCollection,
		ICFBamJavaFXDelSubDep1Chosen whenChosen )
	{
		CFBamJavaFXDelSubDep1PickerForm retnew = new CFBamJavaFXDelSubDep1PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXDelSubDep1AddForm retnew = new CFBamJavaFXDelSubDep1AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamDelSubDep1Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXDelSubDep1ViewEditForm retnew = new CFBamJavaFXDelSubDep1ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
