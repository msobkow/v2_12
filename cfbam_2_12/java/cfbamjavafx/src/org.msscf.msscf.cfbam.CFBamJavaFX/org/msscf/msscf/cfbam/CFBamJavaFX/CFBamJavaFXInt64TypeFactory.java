// Description: Java 11 JavaFX Display Element Factory for Int64Type.

/*
 *	org.msscf.msscf.CFBam
 *
 *	Copyright (c) 2020 Mark Stephen Sobkow
 *	
 *	This file is part of MSS Code Factory.
 *	
 *	MSS Code Factory is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	MSS Code Factory is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with MSS Code Factory.  If not, see https://www.gnu.org/licenses/.
 *	
 *	Donations to support MSS Code Factory can be made at
 *	https://www.paypal.com/paypalme2/MarkSobkow
 *	
 *	Contact Mark Stephen Sobkow at msobkow@sasktel.net for commercial licensing.
 *
 *	Manufactured by MSS Code Factory 2.11
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
 *	CFBamJavaFXInt64TypeFactory JavaFX Display Element Factory
 *	for Int64Type.
 */
public class CFBamJavaFXInt64TypeFactory
implements ICFBamJavaFXInt64TypeFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXInt64TypeFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamInt64TypeObj argFocus ) {
		CFBamJavaFXInt64TypeAttrPane retnew = new CFBamJavaFXInt64TypeAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamSchemaDefObj argContainer,
		ICFBamInt64TypeObj argFocus,
		Collection<ICFBamInt64TypeObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXInt64TypeListPane retnew = new CFBamJavaFXInt64TypeListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamInt64TypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamInt64TypeObj> argDataCollection,
		ICFBamJavaFXInt64TypeChosen whenChosen )
	{
		CFBamJavaFXInt64TypePickerPane retnew = new CFBamJavaFXInt64TypePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamInt64TypeObj argFocus ) {
		CFBamJavaFXInt64TypeEltTabPane retnew = new CFBamJavaFXInt64TypeEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamInt64TypeObj argFocus ) {
		CFBamJavaFXInt64TypeAddPane retnew = new CFBamJavaFXInt64TypeAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamInt64TypeObj argFocus ) {
		CFBamJavaFXInt64TypeViewEditPane retnew = new CFBamJavaFXInt64TypeViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamInt64TypeObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXInt64TypeAskDeleteForm retnew = new CFBamJavaFXInt64TypeAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamInt64TypeObj argFocus,
		ICFBamSchemaDefObj argContainer,
		Collection<ICFBamInt64TypeObj> argDataCollection,
		ICFBamJavaFXInt64TypeChosen whenChosen )
	{
		CFBamJavaFXInt64TypePickerForm retnew = new CFBamJavaFXInt64TypePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamInt64TypeObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXInt64TypeAddForm retnew = new CFBamJavaFXInt64TypeAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamInt64TypeObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXInt64TypeViewEditForm retnew = new CFBamJavaFXInt64TypeViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
