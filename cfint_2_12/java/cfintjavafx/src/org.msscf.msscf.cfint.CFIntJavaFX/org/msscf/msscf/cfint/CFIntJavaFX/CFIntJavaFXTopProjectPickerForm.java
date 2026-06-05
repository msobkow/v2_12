// Description: Java 11 JavaFX Picker Form implementation for TopProject.

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
 *	CFIntJavaFXTopProjectPickerForm JavaFX Picker Form implementation
 *	for TopProject.
 */
public class CFIntJavaFXTopProjectPickerForm
extends CFBorderPane
implements ICFIntJavaFXTopProjectPaneList,
	ICFForm
{
	protected ICFFormManager cfFormManager = null;
	protected CFBorderPane javafxPickerPane = null;
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected Collection<ICFIntTopProjectObj> javafxDataCollection = null;

	public CFIntJavaFXTopProjectPickerForm( ICFFormManager formManager,
		ICFIntJavaFXSchema argSchema,
		ICFIntTopProjectObj argFocus,
		ICFIntTopDomainObj argContainer,
		Collection<ICFIntTopProjectObj> argDataCollection,
		ICFIntJavaFXTopProjectChosen whenChosen )
	{
		super();
		final String S_ProcName = "construct-schema-focus";
		if( formManager == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		cfFormManager = formManager;
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argSchema" );
		}
		if( whenChosen == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				6,
				"whenChosen" );
		}
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javafxPickerPane = argSchema.getTopProjectFactory().newPickerPane( cfFormManager, argFocus, argContainer, argDataCollection, whenChosen );
		setJavaFXFocusAsTopProject( argFocus );
		setJavaFXDataCollection( argDataCollection );
		setJavaFXContainer( argContainer );
		setCenter( javafxPickerPane );
		setPaneMode( CFPane.PaneMode.View );
	}

	public ICFFormManager getCFFormManager() {
		return( cfFormManager );
	}

	public void setCFFormManager( ICFFormManager value ) {
		final String S_ProcName = "setCFFormManager";
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		cfFormManager = value;
	}

	public void forceCancelAndClose() {
		if( cfFormManager != null ) {
			if( cfFormManager.getCurrentForm() == this ) {
				cfFormManager.closeCurrentForm();
			}
		}
	}

	public ICFIntJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFIntTopProjectObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntTopProjectObj" );
		}
		((ICFIntJavaFXTopProjectPaneCommon)javafxPickerPane).setJavaFXFocus( (ICFIntTopProjectObj)value );
	}

	public ICFIntTopProjectObj getJavaFXFocusAsTopProject() {
		return( (ICFIntTopProjectObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTopProject( ICFIntTopProjectObj value ) {
		setJavaFXFocus( value );
	}

	public Collection<ICFIntTopProjectObj> getJavaFXDataCollection() {
		ICFIntJavaFXTopProjectPaneList jplPicker = (ICFIntJavaFXTopProjectPaneList)javafxPickerPane;
		Collection<ICFIntTopProjectObj> cltn = jplPicker.getJavaFXDataCollection();
		return( cltn );
	}

	public void setJavaFXDataCollection( Collection<ICFIntTopProjectObj> value ) {
		ICFIntJavaFXTopProjectPaneList jplPicker = (ICFIntJavaFXTopProjectPaneList)javafxPickerPane;
		jplPicker.setJavaFXDataCollection( value );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		CFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		if( value != CFPane.PaneMode.View ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"PickerForms only support PaneMode View" );
		}
		super.setPaneMode( value );
		if( javafxPickerPane != null ) {
			ICFIntJavaFXTopProjectPaneCommon jpanelCommon = (ICFIntJavaFXTopProjectPaneCommon)javafxPickerPane;
			jpanelCommon.setPaneMode( value );
		}
	}

	public ICFIntTopDomainObj getJavaFXContainer() {
		ICFIntJavaFXTopProjectPaneList jplPicker = (ICFIntJavaFXTopProjectPaneList)javafxPickerPane;
		ICFIntTopDomainObj cnt = jplPicker.getJavaFXContainer();
		return( cnt );
	}

	public void setJavaFXContainer( ICFIntTopDomainObj value ) {
		ICFIntJavaFXTopProjectPaneList jplPicker = (ICFIntJavaFXTopProjectPaneList)javafxPickerPane;
		jplPicker.setJavaFXContainer( value );
	}
}
