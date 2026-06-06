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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfint.CFIntJavaFX.ICFIntJavaFXSchema;

public class CFIntCustFacetPane
extends CFBorderPane
implements ICFForm
{
	protected final String S_FormName = "Int";
	protected ICFFormManager cfFormManager = null;
	protected ICFIntCustSchema custSchema = null;

	protected CFLabel labelTitle = null;
	protected ScrollPane scrollButtons = null;
	protected CFVBox vboxButtons = null;
	protected CFButton buttonHierarchy = null;
	protected CFButton buttonMimeType = null;
	protected CFButton buttonURLProtocol = null;

	public CFIntCustFacetPane(
		ICFFormManager formManager, 
		ICFIntCustSchema argSchema )
	{
		super();
		final String S_ProcName = "construct";
		if( formManager == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		cfFormManager = formManager;
		custSchema = argSchema;
		setMinWidth( 640.0 );

		labelTitle = new CFLabel();
		labelTitle.setText( "Maintain Int Tables" );
		Font f = labelTitle.getFont();
		Font largeBold = Font.font( f.getFamily(), FontWeight.BOLD, 20 );
		labelTitle.setFont( largeBold );
		labelTitle.setMinHeight( 35 );
		labelTitle.setMaxHeight( 35 );
		labelTitle.setMinWidth( 200 );
		labelTitle.setAlignment( Pos.CENTER );

		vboxButtons = new CFVBox( 10 );
		vboxButtons.setMinWidth( 220 );
		vboxButtons.setAlignment( Pos.TOP_CENTER );

		buttonHierarchy = new CFButton();
		buttonHierarchy.setVisible( true );
		buttonHierarchy.setMinWidth( 200 );
		buttonHierarchy.setMaxWidth( 200 );
		buttonHierarchy.setPrefWidth( 200 );
		buttonHierarchy.setMinHeight( 25 );
		buttonHierarchy.setMaxHeight( 25 );
		buttonHierarchy.setPrefHeight( 25 );
		vboxButtons.getChildren().add( buttonHierarchy );
		buttonHierarchy.setText( "Hierarchy..." );
		buttonHierarchy.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				try {
					CFBorderPane hierarchyForm = new CFIntCustHierarchyPane( formManager, argSchema );
					cfFormManager.pushForm( hierarchyForm );
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});

		buttonMimeType = new CFButton();
		buttonMimeType.setVisible( true );
		buttonMimeType.setMinWidth( 200 );
		buttonMimeType.setMaxWidth( 200 );
		buttonMimeType.setPrefWidth( 200 );
		buttonMimeType.setMinHeight( 25 );
		buttonMimeType.setMaxHeight( 25 );
		buttonMimeType.setPrefHeight( 25 );
		vboxButtons.getChildren().add( buttonMimeType );
		buttonMimeType.setText( "Mime Type..." );
		buttonMimeType.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				try {
					CFBorderPane finderForm = ((ICFIntJavaFXSchema)custSchema.getJavaFXSchema()).getMimeTypeFactory().newFinderForm( cfFormManager );
					cfFormManager.pushForm( finderForm );
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});

		buttonURLProtocol = new CFButton();
		buttonURLProtocol.setVisible( true );
		buttonURLProtocol.setMinWidth( 200 );
		buttonURLProtocol.setMaxWidth( 200 );
		buttonURLProtocol.setPrefWidth( 200 );
		buttonURLProtocol.setMinHeight( 25 );
		buttonURLProtocol.setMaxHeight( 25 );
		buttonURLProtocol.setPrefHeight( 25 );
		vboxButtons.getChildren().add( buttonURLProtocol );
		buttonURLProtocol.setText( "URL Protocol..." );
		buttonURLProtocol.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				try {
					CFBorderPane finderForm = ((ICFIntJavaFXSchema)custSchema.getJavaFXSchema()).getURLProtocolFactory().newFinderForm( cfFormManager );
					cfFormManager.pushForm( finderForm );
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});

		scrollButtons = new ScrollPane();
		scrollButtons.setMinWidth( 240 );
		scrollButtons.setMaxWidth( 240 );
		scrollButtons.setFitToWidth( true );
		scrollButtons.setHbarPolicy( ScrollBarPolicy.NEVER );
		scrollButtons.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollButtons.setContent( vboxButtons );

		setTop( labelTitle );
		setCenter( scrollButtons );
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
		custSchema = argSchema;
	}

	public void showFacet() {
		cfFormManager.setRootForm( this );
	}
}
