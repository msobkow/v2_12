// Description: Java 11 JavaFX Display Element Factory for License.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/**
 *	CFIntJavaFXLicenseFactory JavaFX Display Element Factory
 *	for License.
 */
public class CFIntJavaFXLicenseFactory
implements ICFIntJavaFXLicenseFactory
{
	protected ICFIntJavaFXSchema javafxSchema = null;

	public CFIntJavaFXLicenseFactory( ICFIntJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFIntLicenseObj argFocus ) {
		CFIntJavaFXLicenseAttrPane retnew = new CFIntJavaFXLicenseAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFIntTopDomainObj argContainer,
		ICFIntLicenseObj argFocus,
		Collection<ICFIntLicenseObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFIntJavaFXLicenseListPane retnew = new CFIntJavaFXLicenseListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFIntLicenseObj argFocus,
		ICFIntTopDomainObj argContainer,
		Collection<ICFIntLicenseObj> argDataCollection,
		ICFIntJavaFXLicenseChosen whenChosen )
	{
		CFIntJavaFXLicensePickerPane retnew = new CFIntJavaFXLicensePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFIntLicenseObj argFocus ) {
		CFIntJavaFXLicenseEltTabPane retnew = new CFIntJavaFXLicenseEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFIntLicenseObj argFocus ) {
		CFIntJavaFXLicenseAddPane retnew = new CFIntJavaFXLicenseAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFIntLicenseObj argFocus ) {
		CFIntJavaFXLicenseViewEditPane retnew = new CFIntJavaFXLicenseViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFIntLicenseObj argFocus, ICFDeleteCallback callback ) {
		CFIntJavaFXLicenseAskDeleteForm retnew = new CFIntJavaFXLicenseAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFIntLicenseObj argFocus,
		ICFIntTopDomainObj argContainer,
		Collection<ICFIntLicenseObj> argDataCollection,
		ICFIntJavaFXLicenseChosen whenChosen )
	{
		CFIntJavaFXLicensePickerForm retnew = new CFIntJavaFXLicensePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFIntLicenseObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFIntJavaFXLicenseAddForm retnew = new CFIntJavaFXLicenseAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFIntLicenseObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFIntJavaFXLicenseViewEditForm retnew = new CFIntJavaFXLicenseViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
