// Description: Java 13 Cust JavaFX Schema.

/*
 *	CF Int Cust JavaFX Implementation
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

package org.msscf.msscf.cfintcust.CFIntCust;


import javafx.geometry.Orientation;
import javafx.scene.layout.AnchorPane;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;

public class CFIntCustMainPane
extends AnchorPane
implements ICFSecAuthorizationCallbacks
{
	protected ICFIntCustSchema custSchema = null;
	protected CFSplitPane splitPane = null;
	protected CFTitledPane appConsoleTitledPane = null;
	protected CFConsole appConsole = null;
	protected CFTabPane tabPane = null;
	protected CFTabFormManager tabSec = null;
	protected CFTabFormManager tabInt = null;
	protected CFSecCustFacetPane paneSecFacet = null;
	protected CFIntCustFacetPane paneIntFacet = null;

	public CFIntCustMainPane(
		ICFIntCustSchema argSchema )
	{
		super();
		custSchema = argSchema;
		setMinHeight( 480 );
		setMinWidth( 800 );
		splitPane = new CFSplitPane();

		appConsoleTitledPane = new CFTitledPane();
		appConsoleTitledPane.setText( "Console Log" );

		appConsole = new CFConsole();
		appConsole.setMinHeight( 60 );
		appConsoleTitledPane.setContent( appConsole );

		tabPane = new CFTabPane();

		tabSec = new CFTabFormManager() {
			public void showRootMainForm() {
				if( paneSecFacet == null ) {
					paneSecFacet = new CFSecCustFacetPane( tabSec, argSchema );
				}
				tabSec.setRootForm( paneSecFacet );
			}
		};
		tabSec.setText( "Sec" );
		tabSec.setClosable( false );
		tabSec.setContent( paneSecFacet );
		tabPane.getTabs().add( tabSec );

		if( paneSecFacet == null ) {
			paneSecFacet = new CFSecCustFacetPane( tabSec, argSchema );
		}
		paneSecFacet.setAuthorizationCallbacks( this );

		tabInt = new CFTabFormManager() {
			public void showRootMainForm() {
				if( paneIntFacet == null ) {
					paneIntFacet = new CFIntCustFacetPane( tabInt, argSchema );
				}
				tabInt.setRootForm( paneIntFacet );
			}
		};

		tabInt.setText( "Int" );
		tabInt.setClosable( false );
		tabInt.setContent( paneIntFacet );
		tabInt.setDisable( true );
		tabPane.getTabs().add( tabInt );
		paneIntFacet = new CFIntCustFacetPane( tabInt, argSchema );
		tabInt.setRootForm( paneIntFacet );
		splitPane.setOrientation( Orientation.VERTICAL );
		splitPane.getItems().add( tabPane );
		splitPane.getItems().add( appConsoleTitledPane );
		setTopAnchor( splitPane, 0.0 );
		setLeftAnchor( splitPane, 0.0 );
		setRightAnchor( splitPane, 0.0 );
		setBottomAnchor( splitPane, 0.0 );
		getChildren().addAll( splitPane );
		tabInt.setDisable( true );

		paneIntFacet.showFacet();
		paneSecFacet.showOpenKeystore();
	}

	public ICFIntCustSchema getCustSchema() {
		return( custSchema );
	}

	public void setCustSchema( ICFIntCustSchema argSchema ) {
		final String S_ProcName = "setCustSchema";
		final String S_ArgNameSchema = "argSchema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				S_ArgNameSchema );
		}
		if( ! ( argSchema instanceof ICFIntCustSchema ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				S_ArgNameSchema,
				argSchema,
				"ICFIntCustSchema" );
		}
		custSchema = (ICFIntCustSchema)argSchema;
		if( paneSecFacet != null ) {
			paneSecFacet.setCustSchema( custSchema );
		}
		if( paneIntFacet != null ) {
			paneIntFacet.setCustSchema( custSchema );
		}
	}

	public void loggedIn() {
		tabSec.setDisable( false );
		tabInt.setDisable( false );
		paneIntFacet.showFacet();
	}

	public void preLogout() {
		tabSec.setDisable( false );
		tabInt.setDisable( true );
		paneIntFacet.showFacet();
	}
}
