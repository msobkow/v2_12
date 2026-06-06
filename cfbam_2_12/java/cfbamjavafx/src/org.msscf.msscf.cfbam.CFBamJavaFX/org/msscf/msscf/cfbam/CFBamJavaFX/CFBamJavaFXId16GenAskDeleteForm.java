// Description: Java 11 JavaFX Ask Delete Pane implementation for Id16Gen.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamJavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;

/**
 *	CFBamJavaFXId16GenAskDeleteForm JavaFX Ask Delete Pane implementation
 *	for Id16Gen.
 */
public class CFBamJavaFXId16GenAskDeleteForm
extends CFBorderPane
implements ICFBamJavaFXId16GenPaneCommon,
	ICFForm
{
	public static String S_FormName = "Ask Delete Id16Gen";
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected ICFDeleteCallback deleteCallback = null;
	protected CFTextArea textAreaMessage = null;
	protected CFHBox hboxButtons = null;
	protected CFButton buttonOk = null;
	protected CFButton buttonCancel = null;
	protected ScrollPane scrollPane = null;
	protected CFGridPane attrPane = null;

	public CFBamJavaFXId16GenAskDeleteForm( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamId16GenObj argFocus, ICFDeleteCallback callback ) {
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
		javaFXFocus = argFocus;
		deleteCallback = callback;
		// Construct the various objects
		textAreaMessage = new CFTextArea();
		textAreaMessage.setText( "Are you sure you want to delete this Id16Gen?" );
		hboxButtons = new CFHBox( 10 );
		buttonOk = new CFButton();
		buttonOk.setMinWidth( 200 );
		buttonOk.setText( "Ok" );
		buttonOk.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "actionOkPerformed";
				try {
					ICFBamId16GenObj obj = getJavaFXFocusAsId16Gen();
					ICFBamId16GenEditObj editObj = (ICFBamId16GenEditObj)obj.beginEdit();
					editObj.deleteInstance();
					editObj = null;
					cfFormManager.closeCurrentForm();
					if( deleteCallback != null ) {
						deleteCallback.formClosed( null );
						deleteCallback.deleted( obj );
					}
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		buttonCancel = new CFButton();
		buttonCancel.setMinWidth( 200 );
		buttonCancel.setText( "Cancel" );
		buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "actionCancelPerformed";
				try {
					cfFormManager.closeCurrentForm();
					if( deleteCallback != null ) {
						deleteCallback.formClosed( null );
					}
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxButtons.getChildren().addAll( buttonOk, buttonCancel );
		attrPane = argSchema.getId16GenFactory().newAttrPane( cfFormManager, argFocus );
		scrollPane = new ScrollPane();
		scrollPane.setFitToWidth( true );
		scrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
		scrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollPane.setContent( attrPane );
		setTop( textAreaMessage );
		setCenter( scrollPane );
		setBottom( hboxButtons );
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
		if( ( value == null ) || ( value instanceof ICFBamId16GenObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamId16GenObj" );
		}
	}

	public ICFBamId16GenObj getJavaFXFocusAsId16Gen() {
		return( (ICFBamId16GenObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsId16Gen( ICFBamId16GenObj value ) {
		javaFXFocus = value;
		if( attrPane != null ) {
			((ICFBamJavaFXId16GenPaneCommon)attrPane).setJavaFXFocus( value );
		}
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		CFPane.PaneMode oldMode = getPaneMode();
		if( oldMode == value ) {
			return;
		}
		if( ( value != CFPane.PaneMode.Unknown )
		 && ( value != CFPane.PaneMode.View )
		 && ( value != CFPane.PaneMode.Delete ) )
		{
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"AskDeleteForms only support PaneMode Unknown, View or Delete" );
		}
		super.setPaneMode( value );
		if( attrPane != null ) {
			((ICFBamJavaFXId16GenPaneCommon)attrPane).setPaneMode( value );
		}
	}

	public void forceCancelAndClose() {
		ICFBamId16GenObj focus = getJavaFXFocusAsId16Gen();
		if( cfFormManager != null ) {
			if( cfFormManager.getCurrentForm() == this ) {
				cfFormManager.closeCurrentForm();
			}
		}
		if( deleteCallback != null ) {
			deleteCallback.formClosed( null );
		}
	}
}
