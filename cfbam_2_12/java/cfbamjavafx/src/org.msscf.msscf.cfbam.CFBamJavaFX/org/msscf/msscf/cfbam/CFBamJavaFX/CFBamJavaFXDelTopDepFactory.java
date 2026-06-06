// Description: Java 11 JavaFX Display Element Factory for DelTopDep.

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
 *	CFBamJavaFXDelTopDepFactory JavaFX Display Element Factory
 *	for DelTopDep.
 */
public class CFBamJavaFXDelTopDepFactory
implements ICFBamJavaFXDelTopDepFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXDelTopDepFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamDelTopDepObj argFocus ) {
		CFBamJavaFXDelTopDepAttrPane retnew = new CFBamJavaFXDelTopDepAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamDelTopDepObj argFocus,
		Collection<ICFBamDelTopDepObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXDelTopDepListPane retnew = new CFBamJavaFXDelTopDepListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamDelTopDepObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamDelTopDepObj> argDataCollection,
		ICFBamJavaFXDelTopDepChosen whenChosen )
	{
		CFBamJavaFXDelTopDepPickerPane retnew = new CFBamJavaFXDelTopDepPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamDelTopDepObj argFocus ) {
		CFBamJavaFXDelTopDepEltTabPane retnew = new CFBamJavaFXDelTopDepEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamDelTopDepObj argFocus ) {
		CFBamJavaFXDelTopDepAddPane retnew = new CFBamJavaFXDelTopDepAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamDelTopDepObj argFocus ) {
		CFBamJavaFXDelTopDepViewEditPane retnew = new CFBamJavaFXDelTopDepViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamDelTopDepObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXDelTopDepAskDeleteForm retnew = new CFBamJavaFXDelTopDepAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamDelTopDepObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamDelTopDepObj> argDataCollection,
		ICFBamJavaFXDelTopDepChosen whenChosen )
	{
		CFBamJavaFXDelTopDepPickerForm retnew = new CFBamJavaFXDelTopDepPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamDelTopDepObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXDelTopDepAddForm retnew = new CFBamJavaFXDelTopDepAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamDelTopDepObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXDelTopDepViewEditForm retnew = new CFBamJavaFXDelTopDepViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
