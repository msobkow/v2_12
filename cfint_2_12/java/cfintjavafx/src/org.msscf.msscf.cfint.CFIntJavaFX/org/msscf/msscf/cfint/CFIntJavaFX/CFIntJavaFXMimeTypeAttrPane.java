// Description: Java 11 JavaFX Attribute Pane implementation for MimeType.

/*
 *	org.msscf.msscf.CFInt
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

package org.msscf.msscf.cfint.CFIntJavaFX;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.CFReferenceEditor.ICFReferenceCallback;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;

/**
 *	CFIntJavaFXMimeTypeAttrPane JavaFX Attribute Pane implementation
 *	for MimeType.
 */
public class CFIntJavaFXMimeTypeAttrPane
extends CFGridPane
implements ICFIntJavaFXMimeTypePaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFIntJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class MimeTypeIdCFLabel
		extends CFLabel
	{
		public MimeTypeIdCFLabel() {
			super();
			setText( "MIME Type Id" );
		}
	}

	protected class MimeTypeIdEditor
		extends CFInt32Editor
	{
		public MimeTypeIdEditor() {
			super();
			setMinValue( CFIntMimeTypeBuff.MIMETYPEID_MIN_VALUE );
			setFieldName( "MIME Type Id" );
		}
	}

	protected class NameCFLabel
		extends CFLabel
	{
		public NameCFLabel() {
			super();
			setText( "Name" );
		}
	}

	protected class NameEditor
		extends CFStringEditor
	{
		public NameEditor() {
			super();
			setMaxLen( 128 );
			setFieldName( "Name" );
		}
	}

	protected class FileTypesCFLabel
		extends CFLabel
	{
		public FileTypesCFLabel() {
			super();
			setText( "FileTypes" );
		}
	}

	protected class FileTypesEditor
		extends CFStringEditor
	{
		public FileTypesEditor() {
			super();
			setMaxLen( 128 );
			setFieldName( "FileTypes" );
		}
	}

	protected MimeTypeIdCFLabel javafxLabelMimeTypeId = null;
	protected MimeTypeIdEditor javafxEditorMimeTypeId = null;
	protected NameCFLabel javafxLabelName = null;
	protected NameEditor javafxEditorName = null;
	protected FileTypesCFLabel javafxLabelFileTypes = null;
	protected FileTypesEditor javafxEditorFileTypes = null;

	public CFIntJavaFXMimeTypeAttrPane( ICFFormManager formManager, ICFIntJavaFXSchema argSchema, ICFIntMimeTypeObj argFocus ) {
		super();
		Control ctrl;
		CFLabel label;
		CFReferenceEditor reference;
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
		setJavaFXFocusAsMimeType( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints( 125 );
		ColumnConstraints column2 = new ColumnConstraints( 125, 300, 500 );
		column2.setHgrow( Priority.ALWAYS );
		getColumnConstraints().addAll( column1, column2 );
		int gridRow = 0;
		label = getJavaFXLabelMimeTypeId();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		ctrl = getJavaFXEditorMimeTypeId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 1, gridRow );

		gridRow ++;

		label = getJavaFXLabelName();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		ctrl = getJavaFXEditorName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 1, gridRow );

		gridRow ++;

		label = getJavaFXLabelFileTypes();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		ctrl = getJavaFXEditorFileTypes();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 1, gridRow );

		gridRow ++;

		populateFields();
		adjustComponentEnableStates();
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
		if( ( value == null ) || ( value instanceof ICFIntMimeTypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFIntMimeTypeObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFIntMimeTypeObj getJavaFXFocusAsMimeType() {
		return( (ICFIntMimeTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsMimeType( ICFIntMimeTypeObj value ) {
		setJavaFXFocus( value );
	}

	public ICFIntMimeTypeObj getEffJavaFXFocus() {
		ICFIntMimeTypeObj eff = (ICFIntMimeTypeObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ICFIntMimeTypeObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public MimeTypeIdCFLabel getJavaFXLabelMimeTypeId() {
		if( javafxLabelMimeTypeId == null ) {
			javafxLabelMimeTypeId = new MimeTypeIdCFLabel();
		}
		return( javafxLabelMimeTypeId );
	}

	public void setJavaFXLabelMimeTypeId( MimeTypeIdCFLabel value ) {
		javafxLabelMimeTypeId = value;
	}

	public MimeTypeIdEditor getJavaFXEditorMimeTypeId() {
		if( javafxEditorMimeTypeId == null ) {
			javafxEditorMimeTypeId = new MimeTypeIdEditor();
		}
		return( javafxEditorMimeTypeId );
	}

	public void setJavaFXEditorMimeTypeId( MimeTypeIdEditor value ) {
		javafxEditorMimeTypeId = value;
	}

	public NameCFLabel getJavaFXLabelName() {
		if( javafxLabelName == null ) {
			javafxLabelName = new NameCFLabel();
		}
		return( javafxLabelName );
	}

	public void setJavaFXLabelName( NameCFLabel value ) {
		javafxLabelName = value;
	}

	public NameEditor getJavaFXEditorName() {
		if( javafxEditorName == null ) {
			javafxEditorName = new NameEditor();
		}
		return( javafxEditorName );
	}

	public void setJavaFXEditorName( NameEditor value ) {
		javafxEditorName = value;
	}

	public FileTypesCFLabel getJavaFXLabelFileTypes() {
		if( javafxLabelFileTypes == null ) {
			javafxLabelFileTypes = new FileTypesCFLabel();
		}
		return( javafxLabelFileTypes );
	}

	public void setJavaFXLabelFileTypes( FileTypesCFLabel value ) {
		javafxLabelFileTypes = value;
	}

	public FileTypesEditor getJavaFXEditorFileTypes() {
		if( javafxEditorFileTypes == null ) {
			javafxEditorFileTypes = new FileTypesEditor();
		}
		return( javafxEditorFileTypes );
	}

	public void setJavaFXEditorFileTypes( FileTypesEditor value ) {
		javafxEditorFileTypes = value;
	}

	public void populateFields()
	{
		ICFIntMimeTypeObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == CFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorMimeTypeId().setInt32Value( null );
		}
		else {
			getJavaFXEditorMimeTypeId().setInt32Value( popObj.getRequiredMimeTypeId() );
		}

		if( popObj == null ) {
			getJavaFXEditorName().setStringValue( null );
		}
		else {
			getJavaFXEditorName().setStringValue( popObj.getRequiredName() );
		}

		if( popObj == null ) {
			getJavaFXEditorFileTypes().setStringValue( null );
		}
		else {
			getJavaFXEditorFileTypes().setStringValue( popObj.getOptionalFileTypes() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFIntMimeTypeObj focus = getJavaFXFocusAsMimeType();
		ICFIntMimeTypeEditObj editObj;
		if( focus != null ) {
			editObj = (ICFIntMimeTypeEditObj)(focus.getEdit());
		}
		else {
			editObj = null;
		}
		if( editObj == null ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Pane is unfocused or is not editing the focus object" );
		}

		if( getJavaFXEditorName().getStringValue() == null ) {
			editObj.setRequiredName( "" );
		}
		else {
			editObj.setRequiredName( getJavaFXEditorName().getStringValue() );
		}

		if( ( getJavaFXEditorFileTypes().getStringValue() != null ) && ( getJavaFXEditorFileTypes().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalFileTypes( null );
		}
		else {
			editObj.setOptionalFileTypes( getJavaFXEditorFileTypes().getStringValue() );
		}
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		CFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ICFIntMimeTypeObj focus = getJavaFXFocusAsMimeType();
		if( ( value != CFPane.PaneMode.Unknown ) && ( value != CFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ICFIntMimeTypeEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFIntMimeTypeEditObj)focus.getEdit();
		}
		else {
			editObj = null;
		}
		switch( value ) {
			case Unknown:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
							editObj = null;
						}
						break;
				}
				break;
			case Add:
				switch( oldValue ) {
					case Unknown:
					case Add:
					case View:
						if( editObj == null ) {
							if( focus != null ) {
								if( ! focus.getIsNew() ) {
									throw new CFLibUsageException( getClass(),
										S_ProcName,
										"Transitioning to PaneMode Add requires Focus.getIsNew() to be true" );
								}
								editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw new CFLibUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
							else {
								throw new CFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"focus" );
							}
						}
						break;
					case Edit:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode Edit to Add" );
					case Update:
						if( ( editObj == null ) || ( ! editObj.getIsNew() ) ) {
							throw new CFLibUsageException( getClass(),
								S_ProcName,
								"Cannot transition PaneMode Update to Add" );
						}
						break;
					case Delete:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode Delete to Add" );
					default:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode default to Add" );
				}
				break;
			case View:
				switch( oldValue ) {
					case Unknown:
						break;
					case View:
						break;
					case Edit:
						break;
					case Update:
						break;
					case Delete:
						break;
					default:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode " + oldValue + " to View" );
				}
				if( editObj != null ) {
					editObj.endEdit();
					editObj = null;
				}
				break;
			case Edit:
				switch( oldValue ) {
					case Unknown:
						if( editObj == null ) {
							editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Update:
						if( editObj == null ) {
							throw new CFLibUsageException( getClass(),
								S_ProcName,
								"Cannot transition PaneMode " + oldValue + " to Edit" ); 
						}
						break;
					default:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode " + oldValue + " to Edit" ); 
				}
				break;
			case Update:
				if( ( oldValue != CFPane.PaneMode.Edit ) && ( oldValue != CFPane.PaneMode.Add ) ) {
					throw new CFLibUsageException( getClass(),
						S_ProcName,
						"Cannot transition from mode " + oldValue + " to Update" );
				}
				super.setPaneMode( value );
				if( editObj != null ) {
					postFields();
					if( editObj.getIsNew() ) {
						focus = (ICFIntMimeTypeObj)editObj.create();
						setJavaFXFocus( focus );
					}
					else {
						editObj.update();
					}
					editObj = null;
				}
				setPaneMode( CFPane.PaneMode.View );
				break;
			case Delete:
				switch( oldValue ) {
					case View:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw new CFLibUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
						}
						break;
					case Edit:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw new CFLibUsageException( getClass(),
										S_ProcName,
										"Expected beginEdit() to return a new edition of the focus object" );
								}
							}
						}
						break;
					case Update:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode Update to Delete" ); 
					case Delete:
						if( editObj == null ) {
							editObj = (ICFIntMimeTypeEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					default:
						throw new CFLibUsageException( getClass(),
							S_ProcName,
							"Cannot transition PaneMode " + oldValue + " to Delete" ); 
				}
				editObj.deleteInstance();
				editObj = null;
				setJavaFXFocus( null );
				setPaneMode( CFPane.PaneMode.Unknown );
				break;
			default:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
							editObj = null;
						}
						break;
				}
				break;
		}
		super.setPaneMode( value );
		populateFields();
		adjustComponentEnableStates();
	}

	public void adjustComponentEnableStates() {
		CFPane.PaneMode mode = getPaneMode();
		boolean isEditing;
		switch( mode ) {
			case Unknown:
			case View:
			case Delete:
				isEditing = false;
				break;
			case Add:
			case Edit:
			case Update:
				isEditing = true;
				break;
			default:
				isEditing = false;
				break;
		}
		if( isEditing ) {
			ICFIntMimeTypeObj focus = getJavaFXFocusAsMimeType();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorMimeTypeId != null ) {
			javafxEditorMimeTypeId.setDisable( true );
		}
		if( javafxEditorName != null ) {
			javafxEditorName.setDisable( ! isEditing );
		}
		if( javafxEditorFileTypes != null ) {
			javafxEditorFileTypes.setDisable( ! isEditing );
		}
	}
}
