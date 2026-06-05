// Description: Java 11 JavaFX Display Element Factory for ServerListFunc.

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
 *	CFBamJavaFXServerListFuncFactory JavaFX Display Element Factory
 *	for ServerListFunc.
 */
public class CFBamJavaFXServerListFuncFactory
implements ICFBamJavaFXServerListFuncFactory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXServerListFuncFactory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamServerListFuncObj argFocus ) {
		CFBamJavaFXServerListFuncAttrPane retnew = new CFBamJavaFXServerListFuncAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamServerListFuncObj argFocus,
		Collection<ICFBamServerListFuncObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXServerListFuncListPane retnew = new CFBamJavaFXServerListFuncListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamServerListFuncObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerListFuncObj> argDataCollection,
		ICFBamJavaFXServerListFuncChosen whenChosen )
	{
		CFBamJavaFXServerListFuncPickerPane retnew = new CFBamJavaFXServerListFuncPickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamServerListFuncObj argFocus ) {
		CFBamJavaFXServerListFuncEltTabPane retnew = new CFBamJavaFXServerListFuncEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamServerListFuncObj argFocus ) {
		CFBamJavaFXServerListFuncAddPane retnew = new CFBamJavaFXServerListFuncAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamServerListFuncObj argFocus ) {
		CFBamJavaFXServerListFuncViewEditPane retnew = new CFBamJavaFXServerListFuncViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamServerListFuncObj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXServerListFuncAskDeleteForm retnew = new CFBamJavaFXServerListFuncAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamServerListFuncObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamServerListFuncObj> argDataCollection,
		ICFBamJavaFXServerListFuncChosen whenChosen )
	{
		CFBamJavaFXServerListFuncPickerForm retnew = new CFBamJavaFXServerListFuncPickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamServerListFuncObj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXServerListFuncAddForm retnew = new CFBamJavaFXServerListFuncAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamServerListFuncObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXServerListFuncViewEditForm retnew = new CFBamJavaFXServerListFuncViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
