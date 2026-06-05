// Description: Java 11 JavaFX Display Element Factory Interface for PopSubDep1.

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
 *	ICFBamJavaFXPopSubDep1Factory JavaFX Display Element Factory Interface
 *	for PopSubDep1.
 */
public interface ICFBamJavaFXPopSubDep1Factory
{
	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamPopSubDep1Obj javaFXFocus );

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamPopTopDepObj argContainer,
		ICFBamPopSubDep1Obj argFocus,
		Collection<ICFBamPopSubDep1Obj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain );

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamPopSubDep1Obj argFocus,
		ICFBamPopTopDepObj argContainer,
		Collection<ICFBamPopSubDep1Obj> argDataCollection,
		ICFBamJavaFXPopSubDep1Chosen whenChosen );

	public CFTabPane newEltTabPane( ICFFormManager formManger, ICFBamPopSubDep1Obj javaFXFocus );

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamPopSubDep1Obj javaFXFocus, ICFDeleteCallback callback );

	public CFSplitPane newAddPane( ICFFormManager formManger, ICFBamPopSubDep1Obj javaFXFocus );

	public CFSplitPane newViewEditPane( ICFFormManager formManger, ICFBamPopSubDep1Obj javaFXFocus );

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamPopSubDep1Obj javaFXFocus,
		ICFBamPopTopDepObj argContainer,
		Collection<ICFBamPopSubDep1Obj> argDataCollection,
		ICFBamJavaFXPopSubDep1Chosen whenChosen );

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamPopSubDep1Obj javaFXFocus, ICFFormClosedCallback closeCallback, boolean allowSave );

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamPopSubDep1Obj javaFXFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd );
}
