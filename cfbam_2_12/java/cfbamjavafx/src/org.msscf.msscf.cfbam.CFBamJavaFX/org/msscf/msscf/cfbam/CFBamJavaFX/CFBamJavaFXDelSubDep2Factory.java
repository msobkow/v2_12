// Description: Java 11 JavaFX Display Element Factory for DelSubDep2.

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
 *	CFBamJavaFXDelSubDep2Factory JavaFX Display Element Factory
 *	for DelSubDep2.
 */
public class CFBamJavaFXDelSubDep2Factory
implements ICFBamJavaFXDelSubDep2Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXDelSubDep2Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus ) {
		CFBamJavaFXDelSubDep2AttrPane retnew = new CFBamJavaFXDelSubDep2AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamDelSubDep1Obj argContainer,
		ICFBamDelSubDep2Obj argFocus,
		Collection<ICFBamDelSubDep2Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXDelSubDep2ListPane retnew = new CFBamJavaFXDelSubDep2ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamDelSubDep2Obj argFocus,
		ICFBamDelSubDep1Obj argContainer,
		Collection<ICFBamDelSubDep2Obj> argDataCollection,
		ICFBamJavaFXDelSubDep2Chosen whenChosen )
	{
		CFBamJavaFXDelSubDep2PickerPane retnew = new CFBamJavaFXDelSubDep2PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus ) {
		CFBamJavaFXDelSubDep2EltTabPane retnew = new CFBamJavaFXDelSubDep2EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus ) {
		CFBamJavaFXDelSubDep2AddPane retnew = new CFBamJavaFXDelSubDep2AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus ) {
		CFBamJavaFXDelSubDep2ViewEditPane retnew = new CFBamJavaFXDelSubDep2ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXDelSubDep2AskDeleteForm retnew = new CFBamJavaFXDelSubDep2AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamDelSubDep2Obj argFocus,
		ICFBamDelSubDep1Obj argContainer,
		Collection<ICFBamDelSubDep2Obj> argDataCollection,
		ICFBamJavaFXDelSubDep2Chosen whenChosen )
	{
		CFBamJavaFXDelSubDep2PickerForm retnew = new CFBamJavaFXDelSubDep2PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXDelSubDep2AddForm retnew = new CFBamJavaFXDelSubDep2AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamDelSubDep2Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXDelSubDep2ViewEditForm retnew = new CFBamJavaFXDelSubDep2ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
