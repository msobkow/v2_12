// Description: Java 11 JavaFX Display Element Factory for DelSubDep3.

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
 *	CFBamJavaFXDelSubDep3Factory JavaFX Display Element Factory
 *	for DelSubDep3.
 */
public class CFBamJavaFXDelSubDep3Factory
implements ICFBamJavaFXDelSubDep3Factory
{
	protected ICFBamJavaFXSchema javafxSchema = null;

	public CFBamJavaFXDelSubDep3Factory( ICFBamJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus ) {
		CFBamJavaFXDelSubDep3AttrPane retnew = new CFBamJavaFXDelSubDep3AttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamDelSubDep2Obj argContainer,
		ICFBamDelSubDep3Obj argFocus,
		Collection<ICFBamDelSubDep3Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		CFBamJavaFXDelSubDep3ListPane retnew = new CFBamJavaFXDelSubDep3ListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamDelSubDep3Obj argFocus,
		ICFBamDelSubDep2Obj argContainer,
		Collection<ICFBamDelSubDep3Obj> argDataCollection,
		ICFBamJavaFXDelSubDep3Chosen whenChosen )
	{
		CFBamJavaFXDelSubDep3PickerPane retnew = new CFBamJavaFXDelSubDep3PickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFTabPane newEltTabPane( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus ) {
		CFBamJavaFXDelSubDep3EltTabPane retnew = new CFBamJavaFXDelSubDep3EltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newAddPane( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus ) {
		CFBamJavaFXDelSubDep3AddPane retnew = new CFBamJavaFXDelSubDep3AddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFSplitPane newViewEditPane( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus ) {
		CFBamJavaFXDelSubDep3ViewEditPane retnew = new CFBamJavaFXDelSubDep3ViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus, ICFDeleteCallback callback ) {
		CFBamJavaFXDelSubDep3AskDeleteForm retnew = new CFBamJavaFXDelSubDep3AskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamDelSubDep3Obj argFocus,
		ICFBamDelSubDep2Obj argContainer,
		Collection<ICFBamDelSubDep3Obj> argDataCollection,
		ICFBamJavaFXDelSubDep3Chosen whenChosen )
	{
		CFBamJavaFXDelSubDep3PickerForm retnew = new CFBamJavaFXDelSubDep3PickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus, ICFFormClosedCallback closeCallback, boolean allowSave ) {
		CFBamJavaFXDelSubDep3AddForm retnew = new CFBamJavaFXDelSubDep3AddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamDelSubDep3Obj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		CFBamJavaFXDelSubDep3ViewEditForm retnew = new CFBamJavaFXDelSubDep3ViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
