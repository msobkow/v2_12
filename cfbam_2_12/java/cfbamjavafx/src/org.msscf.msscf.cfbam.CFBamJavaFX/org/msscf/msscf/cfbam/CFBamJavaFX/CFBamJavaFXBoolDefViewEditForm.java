// Description: Java 11 JavaFX View/Edit Form implementation for BoolDef.

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
 *	CFBamJavaFXBoolDefViewEditForm JavaFX View/Edit Form implementation
 *	for BoolDef.
 */
public class CFBamJavaFXBoolDefViewEditForm
extends CFBorderPane
implements ICFBamJavaFXBoolDefPaneCommon,
	ICFForm
{
	public static String S_FormName = "View/Edit BoolDef";
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected ICFFormClosedCallback formClosedCallback = null;
	protected boolean dataChanged = false;
	protected CFSplitPane javafxViewEditPane = null;
	protected CFButton buttonEdit = null;
	protected CFButton buttonSave = null;
	protected CFButton buttonClose = null;
	protected CFButton buttonCancel = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;

	public CFBamJavaFXBoolDefViewEditForm( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamBoolDefObj argFocus, ICFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		super();
		final String S_ProcName = "construct-schema-focus";
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
			argFocus = (ICFBamBoolDefObj)argFocus.read( true );
			javaFXFocus = argFocus;
		}
		javafxViewEditPane = argSchema.getBoolDefFactory().newViewEditPane( cfFormManager, argFocus );

		if( cameFromAdd ) {
			dataChanged = true;
		}

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getHBoxMenu() );

		setTop( scrollMenu );
		setCenter( javafxViewEditPane );
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
		ICFBamBoolDefObj focus = getJavaFXFocusAsBoolDef();
		if( focus != null ) {
			ICFBamBoolDefEditObj editObj = (ICFBamBoolDefEditObj)focus.getEdit();
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

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamBoolDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamBoolDefObj" );
		}
		((ICFBamJavaFXBoolDefPaneCommon)javafxViewEditPane).setJavaFXFocus( value );
		ICFBamBoolDefObj argFocus = (ICFBamBoolDefObj)value;
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ICFBamBoolDefObj)argFocus.read( true );
			super.setJavaFXFocus( argFocus );
		}
	}

	public ICFBamBoolDefObj getJavaFXFocusAsBoolDef() {
		return( (ICFBamBoolDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsBoolDef( ICFBamBoolDefObj value ) {
		setJavaFXFocus( value );
	}

	public CFHBox getHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );
			buttonEdit = new CFButton();
			buttonEdit.setMinWidth( 200 );
			buttonEdit.setText( "Edit" );
			buttonEdit.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						if( getJavaFXFocusAsBoolDef() != null ) {
							if( null == getJavaFXFocusAsBoolDef().getEdit() ) {
								setPaneMode( CFPane.PaneMode.Edit );
							}
							else {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Cannot begin an edit of an object already edited by another window instance" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
					adjustButtons();
				}
			});
			hboxMenu.getChildren().add( buttonEdit );

			buttonSave = new CFButton();
			buttonSave.setMinWidth( 200 );
			buttonSave.setText( "Save" );
			buttonSave.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamBoolDefObj focus = getJavaFXFocusAsBoolDef();
						if( focus != null ) {
							ICFBamBoolDefEditObj editObj = (ICFBamBoolDefEditObj)( focus.getEdit() );
							if( editObj == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"editObj" );
							}

							CFPane.PaneMode oldMode = getPaneMode();
							try {
								setPaneMode( CFPane.PaneMode.Update );
								setPaneMode( CFPane.PaneMode.View );
							}
							catch( Throwable t ) {
								setPaneMode( oldMode );
								throw t;
							}
						}
						else {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"focus" );
						}
						dataChanged = true;
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
					adjustButtons();
				}
			});
			hboxMenu.getChildren().add( buttonSave );

			buttonClose = new CFButton();
			buttonClose.setMinWidth( 200 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamBoolDefObj focus = getJavaFXFocusAsBoolDef();
						if( focus != null ) {
							ICFBamBoolDefEditObj editObj = (ICFBamBoolDefEditObj)( focus.getEdit() );
							if( editObj == null ) {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"editObj" );
							}

							CFPane.PaneMode oldMode = getPaneMode();
							try {
								setPaneMode( CFPane.PaneMode.Update );
							}
							catch( Throwable t ) {
								setPaneMode( oldMode );
								throw t;
							}
							dataChanged = true;
						}
						else {
							throw new CFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"focus" );
						}
						cfFormManager.closeCurrentForm();
						if( formClosedCallback != null ) {
							focus = getJavaFXFocusAsBoolDef();
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
						ICFBamBoolDefObj focus = getJavaFXFocusAsBoolDef();
						if( focus != null ) {
							ICFBamBoolDefEditObj editObj = (ICFBamBoolDefEditObj)focus.getEdit();
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
							if( dataChanged ) {
								focus = getJavaFXFocusAsBoolDef();
							}
							else {
								focus = null;
							}
							formClosedCallback.formClosed( focus );
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
			((ICFBamJavaFXBoolDefPaneCommon)javafxViewEditPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldMode );
			((ICFBamJavaFXBoolDefPaneCommon)javafxViewEditPane).setPaneMode( oldMode );
			throw t;
		}
		adjustButtons();
	}

	public void adjustButtons() {
		CFPane.PaneMode value = getPaneMode();
		if( value == CFPane.PaneMode.View ) {
			if( buttonEdit != null ) {
				buttonEdit.setDisable( false );
			}
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
			if( buttonEdit != null ) {
				buttonEdit.setDisable( true );
			}
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
			if( buttonEdit != null ) {
				buttonEdit.setDisable( true );
			}
			if( buttonSave != null ) {
				buttonSave.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( false );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
		}
		else {
			if( buttonEdit != null ) {
				buttonEdit.setDisable( true );
			}
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
