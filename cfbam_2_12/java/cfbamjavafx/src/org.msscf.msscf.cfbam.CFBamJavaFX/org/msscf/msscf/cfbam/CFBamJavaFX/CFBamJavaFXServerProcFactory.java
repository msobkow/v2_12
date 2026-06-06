// Description: Java 11 JavaFX Display Element Factory for ServerProc.

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
 *	CFBamJavaFXServerProcFactory JavaFX Display Element Factory
 *	for ServerProc.
 */
public class CFBamJavaFXServerProcFactory
implements ICFBamJavaFXServerProcFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXServerProcFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamServerProcObj argFocus ) {
		CFBamJavaFXServerProcAttrPane retnew = new CFBamJavaFXServerProcAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamServerProcObj argFocus,
		Collection<ICFBamServerProcObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXServerProcListPane retnew = new CFBamJavaFXServerProcListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamServerProcObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerProcObj> argDataCollection,
		ICFBamJavaFXServerProcChosen whenChosen )
	{
		CFBamJavaFXServerProcPickerPane retnew = new CFBamJavaFXServerProcPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamServerProcObj argFocus ) {
		CFBamJavaFXServerProcEltTabPane retnew = new CFBamJavaFXServerProcEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamServerProcObj argFocus ) {
		CFBamJavaFXServerProcAddPane retnew = new CFBamJavaFXServerProcAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamServerProcObj argFocus ) {
		CFBamJavaFXServerProcViewEditPane retnew = new CFBamJavaFXServerProcViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamServerProcObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXServerProcAskDeleteForm retnew = new CFBamJavaFXServerProcAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamServerProcObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerProcObj> argDataCollection,
		ICFBamJavaFXServerProcChosen whenChosen )
	{
		CFBamJavaFXServerProcPickerForm retnew = new CFBamJavaFXServerProcPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamServerProcObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXServerProcAddForm retnew = new CFBamJavaFXServerProcAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamServerProcObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXServerProcViewEditForm retnew = new CFBamJavaFXServerProcViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
