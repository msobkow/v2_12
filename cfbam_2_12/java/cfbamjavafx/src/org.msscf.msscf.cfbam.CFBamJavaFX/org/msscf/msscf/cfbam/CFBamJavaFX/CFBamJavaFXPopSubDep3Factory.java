// Description: Java 11 JavaFX Display Element Factory for PopSubDep3.

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
 *	CFBamJavaFXPopSubDep3Factory JavaFX Display Element Factory
 *	for PopSubDep3.
 */
public class CFBamJavaFXPopSubDep3Factory
implements ICFBamJavaFXPopSubDep3Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXPopSubDep3Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus ) {
		CFBamJavaFXPopSubDep3AttrPane retnew = new CFBamJavaFXPopSubDep3AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamPopSubDep2Obj argContainer,
		ICFBamPopSubDep3Obj argFocus,
		Collection<ICFBamPopSubDep3Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXPopSubDep3ListPane retnew = new CFBamJavaFXPopSubDep3ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamPopSubDep3Obj argFocus,
		ICFBamPopSubDep2Obj argContainer,
		Collection<ICFBamPopSubDep3Obj> argDataCollection,
		ICFBamJavaFXPopSubDep3Chosen whenChosen )
	{
		CFBamJavaFXPopSubDep3PickerPane retnew = new CFBamJavaFXPopSubDep3PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus ) {
		CFBamJavaFXPopSubDep3EltTabPane retnew = new CFBamJavaFXPopSubDep3EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus ) {
		CFBamJavaFXPopSubDep3AddPane retnew = new CFBamJavaFXPopSubDep3AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus ) {
		CFBamJavaFXPopSubDep3ViewEditPane retnew = new CFBamJavaFXPopSubDep3ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXPopSubDep3AskDeleteForm retnew = new CFBamJavaFXPopSubDep3AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamPopSubDep3Obj argFocus,
		ICFBamPopSubDep2Obj argContainer,
		Collection<ICFBamPopSubDep3Obj> argDataCollection,
		ICFBamJavaFXPopSubDep3Chosen whenChosen )
	{
		CFBamJavaFXPopSubDep3PickerForm retnew = new CFBamJavaFXPopSubDep3PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXPopSubDep3AddForm retnew = new CFBamJavaFXPopSubDep3AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamPopSubDep3Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXPopSubDep3ViewEditForm retnew = new CFBamJavaFXPopSubDep3ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
