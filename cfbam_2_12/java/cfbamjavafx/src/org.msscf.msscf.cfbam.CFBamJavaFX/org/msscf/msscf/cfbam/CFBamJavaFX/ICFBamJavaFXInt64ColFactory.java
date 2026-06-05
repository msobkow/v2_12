// Description: Java 11 JavaFX Display Element Factory Interface for Int64Col.

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
 *	ICFBamJavaFXInt64ColFactory JavaFX Display Element Factory Interface
 *	for Int64Col.
 */
public interface ICFBamJavaFXInt64ColFactory
{
	public CFGridPane newAttrPane( ICFFormManager formManager, ICFBamInt64ColObj javaFXFocus );

	public CFBorderPane newListPane( ICFFormManager formManager,
		ICFBamTableObj argContainer,
		ICFBamInt64ColObj argFocus,
		Collection<ICFBamInt64ColObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain );

	public CFBorderPane newPickerPane( ICFFormManager formManager,
		ICFBamInt64ColObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamInt64ColObj> argDataCollection,
		ICFBamJavaFXInt64ColChosen whenChosen );

	public CFTabPane newEltTabPane( ICFFormManager formManger, ICFBamInt64ColObj javaFXFocus );

	public CFBorderPane newAskDeleteForm( ICFFormManager formManager, ICFBamInt64ColObj javaFXFocus, ICFDeleteCallback callback );

	public CFSplitPane newAddPane( ICFFormManager formManger, ICFBamInt64ColObj javaFXFocus );

	public CFSplitPane newViewEditPane( ICFFormManager formManger, ICFBamInt64ColObj javaFXFocus );

	public CFBorderPane newPickerForm( ICFFormManager formManager,
		ICFBamInt64ColObj javaFXFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamInt64ColObj> argDataCollection,
		ICFBamJavaFXInt64ColChosen whenChosen );

	public CFBorderPane newAddForm( ICFFormManager formManager, ICFBamInt64ColObj javaFXFocus, ICFFormClosedCallback closeCallback, boolean allowSave );

	public CFBorderPane newViewEditForm( ICFFormManager formManager, ICFBamInt64ColObj javaFXFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd );
}
