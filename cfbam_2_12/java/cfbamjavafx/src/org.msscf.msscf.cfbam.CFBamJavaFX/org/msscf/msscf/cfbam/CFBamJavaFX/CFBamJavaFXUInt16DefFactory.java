// Description: Java 11 JavaFX Display Element Factory for UInt16Def.

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
 *	CFBamJavaFXUInt16DefFactory JavaFX Display Element Factory
 *	for UInt16Def.
 */
public class CFBamJavaFXUInt16DefFactory
implements ICFBamJavaFXUInt16DefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXUInt16DefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamUInt16DefObj argFocus ) {
		CFBamJavaFXUInt16DefAttrPane retnew = new CFBamJavaFXUInt16DefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamUInt16DefObj argFocus,
		Collection<ICFBamUInt16DefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXUInt16DefListPane retnew = new CFBamJavaFXUInt16DefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamUInt16DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamUInt16DefObj> argDataCollection,
		ICFBamJavaFXUInt16DefChosen whenChosen )
	{
		CFBamJavaFXUInt16DefPickerPane retnew = new CFBamJavaFXUInt16DefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamUInt16DefObj argFocus ) {
		CFBamJavaFXUInt16DefEltTabPane retnew = new CFBamJavaFXUInt16DefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamUInt16DefObj argFocus ) {
		CFBamJavaFXUInt16DefAddPane retnew = new CFBamJavaFXUInt16DefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamUInt16DefObj argFocus ) {
		CFBamJavaFXUInt16DefViewEditPane retnew = new CFBamJavaFXUInt16DefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamUInt16DefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXUInt16DefAskDeleteForm retnew = new CFBamJavaFXUInt16DefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamUInt16DefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamUInt16DefObj> argDataCollection,
		ICFBamJavaFXUInt16DefChosen whenChosen )
	{
		CFBamJavaFXUInt16DefPickerForm retnew = new CFBamJavaFXUInt16DefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamUInt16DefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXUInt16DefAddForm retnew = new CFBamJavaFXUInt16DefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamUInt16DefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXUInt16DefViewEditForm retnew = new CFBamJavaFXUInt16DefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
