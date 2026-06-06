// Description: Java 11 JavaFX Add Form implementation for Int32Def.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamJavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 *	CFBamJavaFXInt32DefAddForm JavaFX Add Form implementation
 *	for Int32Def.
 */
public class CFBamJavaFXInt32DefAddForm
extends CFBorderPane
implements ICFBamJavaFXInt32DefPaneCommon,
	ICFForm
{
	public static String S_FormName = "Add Int32Def";
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected ICFFormClosedCallback formClosedCallback = null;
	protected boolean allowSave = true;
	protected CFSplitPane javafxAddPane = null;
	protected CFButton buttonSave = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonClose = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;

	public CFBamJavaFXInt32DefAddForm( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamInt32DefObj argFocus, ICFFormClosedCallback closeCallback, boolean argAllowSave ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		allowSave = argAllowSave;
		if( formManager == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		cfFormManager = formManager;
		formClosedCallback = closeCallback;
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
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ICFBamInt32DefObj)argFocus.read( true );
			javaFXFocus = argFocus;
		}
		javafxAddPane = argSchema.getInt32DefFactory().newAddPane( cfFormManager, argFocus );

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getHBoxMenu() );

		setTop( scrollMenu );
		setCenter( javafxAddPane );
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
		ICFBamInt32DefObj focus = getJavaFXFocusAsInt32Def();
		if( focus != null ) {
			ICFBamInt32DefEditObj editObj = (ICFBamInt32DefEditObj)focus.getEdit();
			if( editObj != null ) {
				if( editObj.getIsNew() ) {
					editObj.endEdit();
					editObj = null;
					setJavaFXFocus( null );
					setPaneMode( CFPane.PaneMode.Unknown );
				}
				else {
					editObj.endEdit();
					editObj = null;
					setPaneMode( CFPane.PaneMode.View );
				}
			}
		}
		if( cfFormManager != null ) {
			if( cfFormManager.getCurrentForm() == this ) {
				cfFormManager.closeCurrentForm();
			}
		}
		if( formClosedCallback != null ) {
			formClosedCallback.formClosed( null );
		}
	}

	public ICFBamJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public ICFLibAnyObj getJavaFXFocus() {
		ICFLibAnyObj obj;
		if( javafxAddPane != null ) {
			obj = javafxAddPane.getJavaFXFocus();
		}
		else {
			obj = null;
		}
		return( obj );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamInt32DefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamInt32DefObj" );
		}
		((ICFBamJavaFXInt32DefPaneCommon)javafxAddPane).setJavaFXFocus( value );
		ICFBamInt32DefObj argFocus = (ICFBamInt32DefObj)value;
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ICFBamInt32DefObj)argFocus.read( true );
			super.setJavaFXFocus( argFocus );
		}
	}

	public ICFBamInt32DefObj getJavaFXFocusAsInt32Def() {
		return( (ICFBamInt32DefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsInt32Def( ICFBamInt32DefObj value ) {
		setJavaFXFocus( value );
	}

	public CFHBox getHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );
			buttonSave = new CFButton();
			buttonSave.setMinWidth( 200 );
			buttonSave.setText( "Save" );
			buttonSave.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamInt32DefObj focus = getJavaFXFocusAsInt32Def();
						if( focus != null ) {
							ICFBamInt32DefEditObj editObj = (ICFBamInt32DefEditObj)( focus.getEdit() );
							if( editObj != null ) {
								setPaneMode( CFPane.PaneMode.Update );
							}
							else {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Cannot save an object that isn't being edited" );
							}
						}
						// If an object was added, the focus will change to the persisted instance
						focus = getJavaFXFocusAsInt32Def();
						CFBorderPane frame = javafxSchema.getInt32DefFactory().newViewEditForm( cfFormManager, focus, formClosedCallback, true );
						((ICFBamJavaFXInt32DefPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
						cfFormManager.closeCurrentForm();
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			if( allowSave ) {
				hboxMenu.getChildren().add( buttonSave );
			}

			buttonClose = new CFButton();
			buttonClose.setMinWidth( 200 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamInt32DefObj focus = getJavaFXFocusAsInt32Def();
						if( focus != null ) {
							ICFBamInt32DefEditObj editObj = (ICFBamInt32DefEditObj)( focus.getEdit() );
							if( editObj != null ) {
								setPaneMode( CFPane.PaneMode.Update );
							}
							else {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Cannot save an object that isn't being edited" );
							}
						}
						// If an object was added, the focus will change to the persisted instance
						focus = getJavaFXFocusAsInt32Def();
						cfFormManager.closeCurrentForm();
						if( formClosedCallback != null ) {
							formClosedCallback.formClosed( focus );
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonClose );

			buttonCancel = new CFButton();
			buttonCancel.setMinWidth( 200 );
			buttonCancel.setText( "Cancel" );
			buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamInt32DefObj focus = getJavaFXFocusAsInt32Def();
						if( focus != null ) {
							ICFBamInt32DefEditObj editObj = (ICFBamInt32DefEditObj)focus.getEdit();
							if( editObj != null ) {
								if( editObj.getIsNew() ) {
									editObj.endEdit();
									editObj = null;
									setJavaFXFocus( null );
									setPaneMode( CFPane.PaneMode.Unknown );
								}
								else {
									editObj.endEdit();
									editObj = null;
									setPaneMode( CFPane.PaneMode.View );
								}
							}
						}
						cfFormManager.closeCurrentForm();
						if( formClosedCallback != null ) {
							formClosedCallback.formClosed( null );
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonCancel );

		}
		return( hboxMenu );
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		CFPane.PaneMode oldMode = getPaneMode();
		if( oldMode == value ) {
			return;
		}
		try {
			super.setPaneMode( value );
			((ICFBamJavaFXInt32DefPaneCommon)javafxAddPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldMode );
			((ICFBamJavaFXInt32DefPaneCommon)javafxAddPane).setPaneMode( oldMode );
			throw t;
		}
		if( value == CFPane.PaneMode.View ) {
			if( buttonSave != null ) {
				buttonSave.setDisable( true );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( true );
			}
		}
		else if( value == CFPane.PaneMode.Edit ) {
			if( buttonSave != null ) {
				buttonSave.setDisable( false );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( false );
			}
		}
		else if( value == CFPane.PaneMode.Add ) {
			if( buttonSave != null ) {
				buttonSave.setDisable( false );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( false );
			}
		}
		else {
			if( buttonSave != null ) {
				buttonSave.setDisable( true );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( true );
			}
		}
	}
}
