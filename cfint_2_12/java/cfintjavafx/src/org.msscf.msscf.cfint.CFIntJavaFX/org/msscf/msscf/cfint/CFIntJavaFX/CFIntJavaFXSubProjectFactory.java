// Description: Java 11 JavaFX Display Element Factory for SubProject.

/*
 *	org.msscf.msscf.CFInt
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
 *	CFIntJavaFXSubProjectFactory JavaFX Display Element Factory
 *	for SubProject.
 */
public class CFIntJavaFXSubProjectFactory
implements ICFIntJavaFXSubProjectFactory
{
	protected ICFIntJavaFXSchema javafxSchema = null;

	public CFIntJavaFXSubProjectFactory( ICFIntJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFIntSubProjectObj argFocus ) {
		CFIntJavaFXSubProjectAttrPane retnew = new CFIntJavaFXSubProjectAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFIntTopProjectObj argContainer,
		ICFIntSubProjectObj argFocus,
		Collection<ICFIntSubProjectObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFIntJavaFXSubProjectListPane retnew = new CFIntJavaFXSubProjectListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFIntSubProjectObj argFocus,
		ICFIntTopProjectObj argContainer,
		Collection<ICFIntSubProjectObj> argDataCollection,
		ICFIntJavaFXSubProjectChosen whenChosen )
	{
		CFIntJavaFXSubProjectPickerPane retnew = new CFIntJavaFXSubProjectPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFIntSubProjectObj argFocus ) {
		CFIntJavaFXSubProjectEltTabPane retnew = new CFIntJavaFXSubProjectEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFIntSubProjectObj argFocus ) {
		CFIntJavaFXSubProjectAddPane retnew = new CFIntJavaFXSubProjectAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFIntSubProjectObj argFocus ) {
		CFIntJavaFXSubProjectViewEditPane retnew = new CFIntJavaFXSubProjectViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFIntSubProjectObj argFocus, ICFDeleteCallback callback ) {
		CFIntJavaFXSubProjectAskDeleteForm retnew = new CFIntJavaFXSubProjectAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFIntSubProjectObj argFocus,
		ICFIntTopProjectObj argContainer,
		Collection<ICFIntSubProjectObj> argDataCollection,
		ICFIntJavaFXSubProjectChosen whenChosen )
	{
		CFIntJavaFXSubProjectPickerForm retnew = new CFIntJavaFXSubProjectPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFIntSubProjectObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFIntJavaFXSubProjectAddForm retnew = new CFIntJavaFXSubProjectAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFIntSubProjectObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFIntJavaFXSubProjectViewEditForm retnew = new CFIntJavaFXSubProjectViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
