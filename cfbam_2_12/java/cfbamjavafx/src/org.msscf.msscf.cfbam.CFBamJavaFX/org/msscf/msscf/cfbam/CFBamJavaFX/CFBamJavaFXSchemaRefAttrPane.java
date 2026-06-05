// Description: Java 11 JavaFX Attribute Pane implementation for SchemaRef.

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
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecJavaFX.*;
import org.msscf.msscf.cfint.CFIntJavaFX.*;

/**
 *	CFBamJavaFXSchemaRefAttrPane JavaFX Attribute Pane implementation
 *	for SchemaRef.
 */
public class CFBamJavaFXSchemaRefAttrPane
extends CFGridPane
implements ICFBamJavaFXSchemaRefPaneCommon
{
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class RefSchemaCFLabel
		extends CFLabel
	{
		public RefSchemaCFLabel() {
			super();
			setText( "Referenced Schema" );
		}
	}

	protected class CallbackRefSchemaChosen
	implements ICFBamJavaFXSchemaDefChosen
	{
		public CallbackRefSchemaChosen() {
		}

		public void choseSchemaDef( ICFBamSchemaDefObj value ) {
			if( javafxReferenceLookupRefSchema != null ) {
				ICFBamSchemaRefObj cur = getJavaFXFocusAsSchemaRef();
				if( cur != null ) {
					ICFBamSchemaRefEditObj editObj = (ICFBamSchemaRefEditObj)cur.getEdit();
					if( null != editObj ) {
						CFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == CFPane.PaneMode.Add ) || ( curMode == CFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupRefSchema.setReferencedObject( value );
							editObj.setOptionalLookupRefSchema( value );
						}
					}
				}
			}
		}
	}

	protected class RefSchemaReferenceCallback
	implements ICFReferenceCallback
	{
		public void chose( ICFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
			ICFBamSchemaRefObj focus = getEffJavaFXFocus();
			ICFBamSchemaDefObj referencedObj = (ICFBamSchemaDefObj)javafxReferenceLookupRefSchema.getReferencedObject();
			java.util.List<ICFBamSchemaDefObj> listOfSchemaDef = null;
			Collection<ICFBamSchemaDefObj> cltn = null;
			CFBorderPane form = javafxSchema.getSchemaDefFactory().newPickerForm( cfFormManager, referencedObj, null, cltn, new CallbackRefSchemaChosen() );
			((ICFBamJavaFXSchemaDefPaneCommon)form).setPaneMode( CFPane.PaneMode.View );
			cfFormManager.pushForm( form );
		}

		public void view( ICFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			ICFBamSchemaRefObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				ICFBamSchemaDefObj referencedObj = (ICFBamSchemaDefObj)javafxReferenceLookupRefSchema.getReferencedObject();
				CFBorderPane form = null;
				if( referencedObj != null ) {
					String classCode = referencedObj.getClassCode();
					if( "SCHM".equals( classCode ) ) {
						form = javafxSchema.getSchemaDefFactory().newAddForm( cfFormManager, referencedObj, null, true );
						ICFBamJavaFXSchemaDefPaneCommon spec = (ICFBamJavaFXSchemaDefPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( CFPane.PaneMode.View );
					}
					else {
						throw new CFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"ICFBamSchemaDefObj" );
					}
					cfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class RefSchemaCFReferenceEditor
		extends CFReferenceEditor
	{
		public RefSchemaCFReferenceEditor() {
			super( new RefSchemaReferenceCallback() );
			setFieldName( "Referenced Schema" );
		}
	}

	protected class IdCFLabel
		extends CFLabel
	{
		public IdCFLabel() {
			super();
			setText( "Id" );
		}
	}

	protected class IdEditor
		extends CFInt64Editor
	{
		public IdEditor() {
			super();
			setMinValue( CFBamScopeBuff.ID_MIN_VALUE );
			setFieldName( "Id" );
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
			setMaxLen( 192 );
			setFieldName( "Name" );
		}
	}

	protected class RefModelNameCFLabel
		extends CFLabel
	{
		public RefModelNameCFLabel() {
			super();
			setText( "Ref. Model Name" );
		}
	}

	protected class RefModelNameEditor
		extends CFStringEditor
	{
		public RefModelNameEditor() {
			super();
			setMaxLen( 1024 );
			setFieldName( "Ref. Model Name" );
		}
	}

	protected class IncludeRootCFLabel
		extends CFLabel
	{
		public IncludeRootCFLabel() {
			super();
			setText( "Include Root" );
		}
	}

	protected class IncludeRootEditor
		extends CFStringEditor
	{
		public IncludeRootEditor() {
			super();
			setMaxLen( 1024 );
			setFieldName( "Include Root" );
		}
	}

	protected ICFBamSchemaDefObj javafxLookupRefSchemaObj = null;
	protected RefSchemaCFLabel javafxLabelLookupRefSchema = null;
	protected RefSchemaCFReferenceEditor javafxReferenceLookupRefSchema = null;
	protected IdCFLabel javafxLabelId = null;
	protected IdEditor javafxEditorId = null;
	protected NameCFLabel javafxLabelName = null;
	protected NameEditor javafxEditorName = null;
	protected RefModelNameCFLabel javafxLabelRefModelName = null;
	protected RefModelNameEditor javafxEditorRefModelName = null;
	protected IncludeRootCFLabel javafxLabelIncludeRoot = null;
	protected IncludeRootEditor javafxEditorIncludeRoot = null;

	public CFBamJavaFXSchemaRefAttrPane( ICFFormManager formManager, ICFBamJavaFXSchema argSchema, ICFBamSchemaRefObj argFocus ) {
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
		setJavaFXFocusAsSchemaRef( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints( 125 );
		ColumnConstraints column2 = new ColumnConstraints( 125, 300, 500 );
		column2.setHgrow( Priority.ALWAYS );
		getColumnConstraints().addAll( column1, column2 );
		int gridRow = 0;
		label = getJavaFXLabelLookupRefSchema();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		reference = getJavaFXReferenceLookupRefSchema();
		setHalignment( reference, HPos.LEFT );
		add( reference, 1, gridRow );

		gridRow ++;

		label = getJavaFXLabelId();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		ctrl = getJavaFXEditorId();
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

		label = getJavaFXLabelRefModelName();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		ctrl = getJavaFXEditorRefModelName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 1, gridRow );

		gridRow ++;

		label = getJavaFXLabelIncludeRoot();
		setHalignment( label, HPos.LEFT );
		add( label, 0, gridRow );

		ctrl = getJavaFXEditorIncludeRoot();
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

	public ICFBamJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamSchemaRefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSchemaRefObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ICFBamSchemaRefObj getJavaFXFocusAsSchemaRef() {
		return( (ICFBamSchemaRefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSchemaRef( ICFBamSchemaRefObj value ) {
		setJavaFXFocus( value );
	}

	public ICFBamSchemaRefObj getEffJavaFXFocus() {
		ICFBamSchemaRefObj eff = (ICFBamSchemaRefObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ICFBamSchemaRefObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ICFBamSchemaDefObj getJavaFXLookupRefSchemaObj() {
		return( javafxLookupRefSchemaObj );
	}

	public void setJavaFXLookupRefSchemaObj( ICFBamSchemaDefObj value ) {
		javafxLookupRefSchemaObj = value;
	}

	public CFLabel getJavaFXLabelLookupRefSchema() {
		if( javafxLabelLookupRefSchema == null ) {
			javafxLabelLookupRefSchema = new RefSchemaCFLabel();
		}
		return( javafxLabelLookupRefSchema );
	}

	public CFReferenceEditor getJavaFXReferenceLookupRefSchema() {
		if( javafxReferenceLookupRefSchema == null ) {
			javafxReferenceLookupRefSchema = new RefSchemaCFReferenceEditor();
		}
		return( javafxReferenceLookupRefSchema );
	}

	public void setJavaFXReferenceLookupRefSchema( RefSchemaCFReferenceEditor value ) {
		javafxReferenceLookupRefSchema = value;
	}

	public IdCFLabel getJavaFXLabelId() {
		if( javafxLabelId == null ) {
			javafxLabelId = new IdCFLabel();
		}
		return( javafxLabelId );
	}

	public void setJavaFXLabelId( IdCFLabel value ) {
		javafxLabelId = value;
	}

	public IdEditor getJavaFXEditorId() {
		if( javafxEditorId == null ) {
			javafxEditorId = new IdEditor();
		}
		return( javafxEditorId );
	}

	public void setJavaFXEditorId( IdEditor value ) {
		javafxEditorId = value;
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

	public RefModelNameCFLabel getJavaFXLabelRefModelName() {
		if( javafxLabelRefModelName == null ) {
			javafxLabelRefModelName = new RefModelNameCFLabel();
		}
		return( javafxLabelRefModelName );
	}

	public void setJavaFXLabelRefModelName( RefModelNameCFLabel value ) {
		javafxLabelRefModelName = value;
	}

	public RefModelNameEditor getJavaFXEditorRefModelName() {
		if( javafxEditorRefModelName == null ) {
			javafxEditorRefModelName = new RefModelNameEditor();
		}
		return( javafxEditorRefModelName );
	}

	public void setJavaFXEditorRefModelName( RefModelNameEditor value ) {
		javafxEditorRefModelName = value;
	}

	public IncludeRootCFLabel getJavaFXLabelIncludeRoot() {
		if( javafxLabelIncludeRoot == null ) {
			javafxLabelIncludeRoot = new IncludeRootCFLabel();
		}
		return( javafxLabelIncludeRoot );
	}

	public void setJavaFXLabelIncludeRoot( IncludeRootCFLabel value ) {
		javafxLabelIncludeRoot = value;
	}

	public IncludeRootEditor getJavaFXEditorIncludeRoot() {
		if( javafxEditorIncludeRoot == null ) {
			javafxEditorIncludeRoot = new IncludeRootEditor();
		}
		return( javafxEditorIncludeRoot );
	}

	public void setJavaFXEditorIncludeRoot( IncludeRootEditor value ) {
		javafxEditorIncludeRoot = value;
	}

	public void populateFields()
	{
		ICFBamSchemaRefObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == CFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			javafxLookupRefSchemaObj = null;
		}
		else {
			javafxLookupRefSchemaObj = (ICFBamSchemaDefObj)popObj.getOptionalLookupRefSchema( javafxIsInitializing );
		}
		if( javafxReferenceLookupRefSchema != null ) {
			javafxReferenceLookupRefSchema.setReferencedObject( javafxLookupRefSchemaObj );
		}

		if( popObj == null ) {
			getJavaFXEditorId().setInt64Value( null );
		}
		else {
			getJavaFXEditorId().setInt64Value( popObj.getRequiredId() );
		}

		if( popObj == null ) {
			getJavaFXEditorName().setStringValue( null );
		}
		else {
			getJavaFXEditorName().setStringValue( popObj.getRequiredName() );
		}

		if( popObj == null ) {
			getJavaFXEditorRefModelName().setStringValue( null );
		}
		else {
			getJavaFXEditorRefModelName().setStringValue( popObj.getRequiredRefModelName() );
		}

		if( popObj == null ) {
			getJavaFXEditorIncludeRoot().setStringValue( null );
		}
		else {
			getJavaFXEditorIncludeRoot().setStringValue( popObj.getRequiredIncludeRoot() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ICFBamSchemaRefObj focus = getJavaFXFocusAsSchemaRef();
		ICFBamSchemaRefEditObj editObj;
		if( focus != null ) {
			editObj = (ICFBamSchemaRefEditObj)(focus.getEdit());
		}
		else {
			editObj = null;
		}
		if( editObj == null ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Pane is unfocused or is not editing the focus object" );
		}

		javafxLookupRefSchemaObj = (ICFBamSchemaDefObj)( javafxReferenceLookupRefSchema.getReferencedObject() );
		editObj.setOptionalLookupRefSchema( javafxLookupRefSchemaObj );

		if( getJavaFXEditorName().getStringValue() == null ) {
			editObj.setRequiredName( "" );
		}
		else {
			editObj.setRequiredName( getJavaFXEditorName().getStringValue() );
		}

		if( getJavaFXEditorRefModelName().getStringValue() == null ) {
			editObj.setRequiredRefModelName( "" );
		}
		else {
			editObj.setRequiredRefModelName( getJavaFXEditorRefModelName().getStringValue() );
		}

		if( getJavaFXEditorIncludeRoot().getStringValue() == null ) {
			editObj.setRequiredIncludeRoot( "" );
		}
		else {
			editObj.setRequiredIncludeRoot( getJavaFXEditorIncludeRoot().getStringValue() );
		}
	}

	public void setPaneMode( CFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		CFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ICFBamSchemaRefObj focus = getJavaFXFocusAsSchemaRef();
		if( ( value != CFPane.PaneMode.Unknown ) && ( value != CFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new CFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ICFBamSchemaRefEditObj editObj;
		if( focus != null ) {
			editObj  = (ICFBamSchemaRefEditObj)focus.getEdit();
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
								editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
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
							editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new CFLibUsageException( getClass(),
									S_ProcName,
									"Expected beginEdit() to return a new edition of the focus object" );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
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
						focus = (ICFBamSchemaRefObj)editObj.create();
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
								editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
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
								editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
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
							editObj = (ICFBamSchemaRefEditObj)focus.beginEdit();
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
			ICFBamSchemaRefObj focus = getJavaFXFocusAsSchemaRef();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxReferenceLookupRefSchema != null ) {
			javafxReferenceLookupRefSchema.setCustomDisable( ! isEditing );
		}
		if( javafxEditorId != null ) {
			javafxEditorId.setDisable( true );
		}
		if( javafxEditorName != null ) {
			javafxEditorName.setDisable( ! isEditing );
		}
		if( javafxEditorRefModelName != null ) {
			javafxEditorRefModelName.setDisable( ! isEditing );
		}
		if( javafxEditorIncludeRoot != null ) {
			javafxEditorIncludeRoot.setDisable( ! isEditing );
		}
	}
}
