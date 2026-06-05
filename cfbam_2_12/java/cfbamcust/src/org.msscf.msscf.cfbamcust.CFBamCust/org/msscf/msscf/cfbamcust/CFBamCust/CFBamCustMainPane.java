// Description: Java 13 Cust JavaFX Schema.

/*
 *  MSS Code Factory CFBam 2.12 Cust
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
 */

package org.msscf.msscf.cfbamcust.CFBamCust;

import javafx.geometry.Orientation;
import javafx.scene.layout.AnchorPane;

import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfseccust.CFSecCust.*;
import org.msscf.msscf.cfintcust.CFIntCust.*;

public class CFBamCustMainPane
extends AnchorPane
implements ICFSecAuthorizationCallbacks
{
	protected ICFBamCustSchema custSchema = null;
	protected CFSplitPane splitPane = null;
	protected CFTitledPane appConsoleTitledPane = null;
	protected CFConsole appConsole = null;
	protected CFTabPane tabPane = null;
	protected CFTabFormManager tabSec = null;
	protected CFTabFormManager tabInt = null;
	protected CFTabFormManager tabBam = null;
	protected CFSecCustFacetPane paneSecFacet = null;
	protected CFIntCustFacetPane paneIntFacet = null;
	protected CFBamCustFacetPane paneBamFacet = null;

	public CFBamCustMainPane(
		ICFBamCustSchema argSchema )
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
				if( paneSecFacet == null ) {
					paneIntFacet = new CFIntCustFacetPane( tabSec, argSchema );
				}
				tabInt.setRootForm( paneIntFacet );
			}
		};
		tabInt.setText( "Int" );
		tabInt.setClosable( false );
		tabInt.setContent( paneIntFacet );
		tabInt.setDisable( true );
		tabPane.getTabs().add( tabInt );

		if( paneIntFacet == null ) {
			paneIntFacet = new CFIntCustFacetPane( tabInt, argSchema );
		}

		tabBam = new CFTabFormManager() {
			public void showRootMainForm() {
				if( paneBamFacet == null ) {
					paneBamFacet = new CFBamCustFacetPane( tabBam, argSchema );
				}
				tabBam.setRootForm( paneBamFacet );
			}
		};

		tabBam.setText( "Bam" );
		tabBam.setClosable( false );
		tabBam.setContent( paneBamFacet );
		tabBam.setDisable( true );
		tabPane.getTabs().add( tabBam );
		paneBamFacet = new CFBamCustFacetPane( tabBam, argSchema );
		tabBam.setRootForm( paneBamFacet );
		splitPane.setOrientation( Orientation.VERTICAL );
		splitPane.getItems().add( tabPane );
		splitPane.getItems().add( appConsoleTitledPane );
		setTopAnchor( splitPane, 0.0 );
		setLeftAnchor( splitPane, 0.0 );
		setRightAnchor( splitPane, 0.0 );
		setBottomAnchor( splitPane, 0.0 );
		getChildren().addAll( splitPane );
		tabBam.setDisable( true );

		paneBamFacet.showFacet();
		paneIntFacet.showFacet();
		paneSecFacet.showOpenKeystore();
	}

	public ICFBamCustSchema getCustSchema() {
		return( custSchema );
	}

	public void setCustSchema( ICFBamCustSchema argSchema ) {
		final String S_ProcName = "setCustSchema";
		final String S_ArgNameSchema = "argSchema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				S_ArgNameSchema );
		}
		if( ! ( argSchema instanceof ICFBamCustSchema ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				S_ArgNameSchema,
				argSchema,
				"ICFBamCustSchema" );
		}
		custSchema = (ICFBamCustSchema)argSchema;
		if( paneSecFacet != null ) {
			paneSecFacet.setCustSchema( custSchema );
		}
		if( paneIntFacet != null ) {
			paneIntFacet.setCustSchema( custSchema );
		}
		if( paneBamFacet != null ) {
			paneBamFacet.setCustSchema( custSchema );
		}
	}

	public void loggedIn() {
		tabSec.setDisable( false );
		tabInt.setDisable( false );
		tabBam.setDisable( false );
		paneIntFacet.showFacet();
		paneBamFacet.showFacet();
	}

	public void preLogout() {
		tabSec.setDisable( false );
		tabInt.setDisable( true );
		tabBam.setDisable( true );
		paneIntFacet.showFacet();
		paneBamFacet.showFacet();
	}
}
