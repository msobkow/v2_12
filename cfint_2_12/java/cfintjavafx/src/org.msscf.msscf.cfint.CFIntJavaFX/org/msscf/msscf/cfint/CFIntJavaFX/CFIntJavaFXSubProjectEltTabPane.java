// Description: Java 11 JavaFX Element TabPane implementation for SubProject.

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
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;

/**
 *	CFIntJavaFXSubProjectEltTabPane JavaFX Element TabPane implementation
 *	for SubProject.
 */
public class CFIntJavaFXSubProjectEltTabPane
extends CFTabPane
implements ICFIntJavaFXSubProjectPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFIntJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsMajorVerList = "Optional Components Major Version";
	protected CFTab tabComponentsMajorVer = null;
	protected CFBorderPane tabViewComponentsMajorVerListPane = null;

	public CFIntJavaFXSubProjectEltTabPane( ICFFormManager formManager, ICFIntJavaFXSchema argSchema, ICFIntSubProjectObj argFocus ) {
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
		setJavaFXFocusAsSubProject( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsMajorVer = new CFTab();
		tabComponentsMajorVer.setText( LABEL_TabComponentsMajorVerList );
		tabComponentsMajorVer.setContent( getTabViewComponentsMajorVerListPane() );
		getTabs().add( tabComponentsMajorVer );
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

	public ICFIntJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFIntSubProjectObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntSubProjectObj" );
		}
	}

	public void setJavaFXFocusAsSubProject( ICFIntSubProjectObj value ) {
		setJavaFXFocus( value );
	}

	public ICFIntSubProjectObj getJavaFXFocusAsSubProject() {
		return( (ICFIntSubProjectObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsMajorVerList
	implements ICFRefreshCallback
	{
		public RefreshComponentsMajorVerList() {
		}

		public void refreshMe() {
			Collection<ICFIntMajorVersionObj> dataCollection;
			ICFIntSubProjectObj focus = (ICFIntSubProjectObj)getJavaFXFocusAsSubProject();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsMajorVer( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			CFBorderPane pane = getTabViewComponentsMajorVerListPane();
			ICFIntJavaFXMajorVersionPaneList jpList = (ICFIntJavaFXMajorVersionPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public CFBorderPane getTabViewComponentsMajorVerListPane() {
		if( tabViewComponentsMajorVerListPane == null ) {
			ICFIntSubProjectObj focus = (ICFIntSubProjectObj)getJavaFXFocusAsSubProject();
			Collection<ICFIntMajorVersionObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsMajorVer( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ICFIntSubProjectObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ICFIntSubProjectObj ) ) {
				javafxContainer = (ICFIntSubProjectObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsMajorVerListPane = javafxSchema.getMajorVersionFactory().newListPane( cfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsMajorVerList(), false );
		}
		return( tabViewComponentsMajorVerListPane );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsMajorVerListPane != null ) {
			((ICFIntJavaFXMajorVersionPaneCommon)tabViewComponentsMajorVerListPane).setPaneMode( value );
		}
	}
}
