// Description: Java 11 JavaFX Display Element Factory for DateDef.

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
 *	CFBamJavaFXDateDefFactory JavaFX Display Element Factory
 *	for DateDef.
 */
public class CFBamJavaFXDateDefFactory
implements ICFBamJavaFXDateDefFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXDateDefFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamDateDefObj argFocus ) {
		CFBamJavaFXDateDefAttrPane retnew = new CFBamJavaFXDateDefAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamScopeObj argContainer,
		ICFBamDateDefObj argFocus,
		Collection<ICFBamDateDefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXDateDefListPane retnew = new CFBamJavaFXDateDefListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamDateDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamDateDefObj> argDataCollection,
		ICFBamJavaFXDateDefChosen whenChosen )
	{
		CFBamJavaFXDateDefPickerPane retnew = new CFBamJavaFXDateDefPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamDateDefObj argFocus ) {
		CFBamJavaFXDateDefEltTabPane retnew = new CFBamJavaFXDateDefEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamDateDefObj argFocus ) {
		CFBamJavaFXDateDefAddPane retnew = new CFBamJavaFXDateDefAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamDateDefObj argFocus ) {
		CFBamJavaFXDateDefViewEditPane retnew = new CFBamJavaFXDateDefViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamDateDefObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXDateDefAskDeleteForm retnew = new CFBamJavaFXDateDefAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamDateDefObj argFocus,
		ICFBamScopeObj argContainer,
		Collection<ICFBamDateDefObj> argDataCollection,
		ICFBamJavaFXDateDefChosen whenChosen )
	{
		CFBamJavaFXDateDefPickerForm retnew = new CFBamJavaFXDateDefPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamDateDefObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXDateDefAddForm retnew = new CFBamJavaFXDateDefAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamDateDefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXDateDefViewEditForm retnew = new CFBamJavaFXDateDefViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
