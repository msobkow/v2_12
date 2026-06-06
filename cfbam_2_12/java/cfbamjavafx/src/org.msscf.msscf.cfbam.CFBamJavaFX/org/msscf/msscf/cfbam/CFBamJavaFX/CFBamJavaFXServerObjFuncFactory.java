// Description: Java 11 JavaFX Display Element Factory for ServerObjFunc.

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
 *	CFBamJavaFXServerObjFuncFactory JavaFX Display Element Factory
 *	for ServerObjFunc.
 */
public class CFBamJavaFXServerObjFuncFactory
implements ICFBamJavaFXServerObjFuncFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXServerObjFuncFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus ) {
		CFBamJavaFXServerObjFuncAttrPane retnew = new CFBamJavaFXServerObjFuncAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamServerObjFuncObj argFocus,
		Collection<ICFBamServerObjFuncObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXServerObjFuncListPane retnew = new CFBamJavaFXServerObjFuncListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamServerObjFuncObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerObjFuncObj> argDataCollection,
		ICFBamJavaFXServerObjFuncChosen whenChosen )
	{
		CFBamJavaFXServerObjFuncPickerPane retnew = new CFBamJavaFXServerObjFuncPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus ) {
		CFBamJavaFXServerObjFuncEltTabPane retnew = new CFBamJavaFXServerObjFuncEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus ) {
		CFBamJavaFXServerObjFuncAddPane retnew = new CFBamJavaFXServerObjFuncAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus ) {
		CFBamJavaFXServerObjFuncViewEditPane retnew = new CFBamJavaFXServerObjFuncViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXServerObjFuncAskDeleteForm retnew = new CFBamJavaFXServerObjFuncAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamServerObjFuncObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerObjFuncObj> argDataCollection,
		ICFBamJavaFXServerObjFuncChosen whenChosen )
	{
		CFBamJavaFXServerObjFuncPickerForm retnew = new CFBamJavaFXServerObjFuncPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXServerObjFuncAddForm retnew = new CFBamJavaFXServerObjFuncAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamServerObjFuncObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXServerObjFuncViewEditForm retnew = new CFBamJavaFXServerObjFuncViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
