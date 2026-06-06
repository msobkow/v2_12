// Description: Java 11 JavaFX Display Element Factory for UInt32Col.

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
 *	CFBamJavaFXUInt32ColFactory JavaFX Display Element Factory
 *	for UInt32Col.
 */
public class CFBamJavaFXUInt32ColFactory
implements ICFBamJavaFXUInt32ColFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXUInt32ColFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamUInt32ColObj argFocus ) {
		CFBamJavaFXUInt32ColAttrPane retnew = new CFBamJavaFXUInt32ColAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamUInt32ColObj argFocus,
		Collection<ICFBamUInt32ColObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXUInt32ColListPane retnew = new CFBamJavaFXUInt32ColListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamUInt32ColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamUInt32ColObj> argDataCollection,
		ICFBamJavaFXUInt32ColChosen whenChosen )
	{
		CFBamJavaFXUInt32ColPickerPane retnew = new CFBamJavaFXUInt32ColPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamUInt32ColObj argFocus ) {
		CFBamJavaFXUInt32ColEltTabPane retnew = new CFBamJavaFXUInt32ColEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamUInt32ColObj argFocus ) {
		CFBamJavaFXUInt32ColAddPane retnew = new CFBamJavaFXUInt32ColAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamUInt32ColObj argFocus ) {
		CFBamJavaFXUInt32ColViewEditPane retnew = new CFBamJavaFXUInt32ColViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamUInt32ColObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXUInt32ColAskDeleteForm retnew = new CFBamJavaFXUInt32ColAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamUInt32ColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamUInt32ColObj> argDataCollection,
		ICFBamJavaFXUInt32ColChosen whenChosen )
	{
		CFBamJavaFXUInt32ColPickerForm retnew = new CFBamJavaFXUInt32ColPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamUInt32ColObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXUInt32ColAddForm retnew = new CFBamJavaFXUInt32ColAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamUInt32ColObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXUInt32ColViewEditForm retnew = new CFBamJavaFXUInt32ColViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
