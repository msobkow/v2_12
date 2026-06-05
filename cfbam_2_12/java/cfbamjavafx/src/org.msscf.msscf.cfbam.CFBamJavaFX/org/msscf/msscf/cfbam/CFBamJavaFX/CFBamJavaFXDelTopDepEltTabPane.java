// Description: Java 11 JavaFX Element TabPane implementation for DelTopDep.

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
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
 *	CFBamJavaFXDelTopDepEltTabPane JavaFX Element TabPane implementation
 *	for DelTopDep.
 */
public class CFBamJavaFXDelTopDepEltTabPane
extends CFTabPane
implements ICFBamJavaFXDelTopDepPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsDelDepList = "Optional Components Deletion Dependency";
	protected CFTab tabComponentsDelDep = null;
	protected CFBorderPane tabViewComponentsDelDepListPane = null;

	public CFBamJavaFXDelTopDepEltTabPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamDelTopDepObj argFocus ) {
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
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		setJavaFXFocusAsDelTopDep( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsDelDep = new CFTab();
		tabComponentsDelDep.setText( LABEL_TabComponentsDelDepList );
		tabComponentsDelDep.setContent( getTabViewComponentsDelDepListPane() );
		getTabs().add( tabComponentsDelDep );
		javafxIsInitializing = false;
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

	public ICFBamJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamDelTopDepObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDelTopDepObj" );
		}
	}

	public void setJavaFXFocusAsDelTopDep( ICFBamDelTopDepObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamDelTopDepObj getJavaFXFocusAsDelTopDep() {
		return( (ICFBamDelTopDepObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsDelDepList
	implements ICFRefreshCallback
	{
		public RefreshComponentsDelDepList() {
		}

		public void refreshMe() {
			Collection<ICFBamDelSubDep1Obj> dataCollection;
			ICFBamDelTopDepObj focus = (ICFBamDelTopDepObj)getJavaFXFocusAsDelTopDep();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsDelDepListPane();
			ICFBamJavaFXDelSubDep1PaneList jpList = (ICFBamJavaFXDelSubDep1PaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsDelDepListPane() {
		if( tabViewComponentsDelDepListPane == null ) {
			ICFBamDelTopDepObj focus = (ICFBamDelTopDepObj)getJavaFXFocusAsDelTopDep();
			Collection<ICFBamDelSubDep1Obj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFBamDelTopDepObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFBamDelTopDepObj ) ) {
				javafxContainer = (ICFBamDelTopDepObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsDelDepListPane = javafxSchema.getDelSubDep1Factory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsDelDepList(), false );
		}
		return( tabViewComponentsDelDepListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsDelDepListPane != null ) {
			((ICFBamJavaFXDelSubDep1PaneCommon)tabViewComponentsDelDepListPane).setPaneMode( value );
		}
	}
}
