// Description: Java 11 JavaFX Picker of Obj Pane implementation for DelSubDep1.

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

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.JavaFX.*;
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
 *	CFBamJavaFXDelSubDep1PickerPane JavaFX Pick Obj Pane implementation
 *	for DelSubDep1.
 */
public class CFBamJavaFXDelSubDep1PickerPane
extends CFBorderPane
implements ICFBamJavaFXDelSubDep1PaneList
{
	public static String S_FormName = "Choose DelSubDep1";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamDelSubDep1Obj> javafxDataCollection = null;
	protected ObservableList<ICFBamDelSubDep1Obj> observableListOfDelSubDep1 = null;
	protected TableColumn<ICFBamDelSubDep1Obj, Long> tableColumnId = null;
	protected TableColumn<ICFBamDelSubDep1Obj, String> tableColumnName = null;
	protected TableColumn<ICFBamDelSubDep1Obj, ICFBamRelationObj> tableColumnLookupRelation = null;
	protected TableColumn<ICFBamDelSubDep1Obj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamDelSubDep1Obj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXDelSubDep1Chosen invokeWhenChosen = null;
	protected ICFBamDelTopDepObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXDelSubDep1PickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamDelSubDep1Obj argFocus,
		ICFBamDelTopDepObj argContainer,
		Collection<ICFBamDelSubDep1Obj> argDataCollection,
		ICFBamJavaFXDelSubDep1Chosen whenChosen )
	{
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
		if( whenChosen == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				6,
				"whenChosen" );
		}
		invokeWhenChosen = whenChosen;
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<ICFBamDelSubDep1Obj>();
		tableColumnId = new TableColumn<ICFBamDelSubDep1Obj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelSubDep1Obj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamDelSubDep1Obj, Long> p ) {
				ICFBamScopeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					long value = obj.getRequiredId();
					Long wrapped = Long.valueOf( value );
					ReadOnlyObjectWrapper<Long> observable = new ReadOnlyObjectWrapper<Long>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamDelSubDep1Obj,Long>,TableCell<ICFBamDelSubDep1Obj,Long>>() {
			@Override public TableCell<ICFBamDelSubDep1Obj,Long> call(
				TableColumn<ICFBamDelSubDep1Obj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamDelSubDep1Obj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamDelSubDep1Obj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelSubDep1Obj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamDelSubDep1Obj, String> p ) {
				ICFBamDelSubDep1Obj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamDelSubDep1Obj,String>,TableCell<ICFBamDelSubDep1Obj,String>>() {
			@Override public TableCell<ICFBamDelSubDep1Obj,String> call(
				TableColumn<ICFBamDelSubDep1Obj,String> arg)
			{
				return new CFStringTableCell<ICFBamDelSubDep1Obj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnLookupRelation = new TableColumn<ICFBamDelSubDep1Obj, ICFBamRelationObj>( "Relation" );
		tableColumnLookupRelation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelSubDep1Obj,ICFBamRelationObj>,ObservableValue<ICFBamRelationObj> >() {
			public ObservableValue<ICFBamRelationObj> call( CellDataFeatures<ICFBamDelSubDep1Obj, ICFBamRelationObj> p ) {
				ICFBamDelSubDep1Obj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamRelationObj ref = obj.getRequiredLookupRelation();
					ReadOnlyObjectWrapper<ICFBamRelationObj> observable = new ReadOnlyObjectWrapper<ICFBamRelationObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupRelation.setCellFactory( new Callback<TableColumn<ICFBamDelSubDep1Obj,ICFBamRelationObj>,TableCell<ICFBamDelSubDep1Obj,ICFBamRelationObj>>() {
			@Override public TableCell<ICFBamDelSubDep1Obj,ICFBamRelationObj> call(
				TableColumn<ICFBamDelSubDep1Obj,ICFBamRelationObj> arg)
			{
				return new CFReferenceTableCell<ICFBamDelSubDep1Obj,ICFBamRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupRelation );
		tableColumnLookupDefSchema = new TableColumn<ICFBamDelSubDep1Obj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelSubDep1Obj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamDelSubDep1Obj, ICFBamSchemaDefObj> p ) {
				ICFBamDelSubDep1Obj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamSchemaDefObj ref = obj.getOptionalLookupDefSchema();
					ReadOnlyObjectWrapper<ICFBamSchemaDefObj> observable = new ReadOnlyObjectWrapper<ICFBamSchemaDefObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamDelSubDep1Obj,ICFBamSchemaDefObj>,TableCell<ICFBamDelSubDep1Obj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamDelSubDep1Obj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamDelSubDep1Obj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamDelSubDep1Obj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamDelSubDep1Obj>() {
				@Override public void changed( ObservableValue<? extends ICFBamDelSubDep1Obj> observable,
					ICFBamDelSubDep1Obj oldValue,
					ICFBamDelSubDep1Obj newValue )
				{
					setJavaFXFocus( newValue );
					if( buttonChooseSelected != null ) {
						if( newValue != null ) {
							buttonChooseSelected.setDisable( false );
						}
						else {
							buttonChooseSelected.setDisable( true );
						}
					}
				}
			});
		hboxMenu = new CFHBox( 10 );
		buttonCancel = new CFButton();
		buttonCancel.setMinWidth( 200 );
		buttonCancel.setText( "Cancel" );
		buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonCancel );
		buttonChooseNone = new CFButton();
		buttonChooseNone.setMinWidth( 200 );
		buttonChooseNone.setText( "ChooseNone" );
		buttonChooseNone.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					invokeWhenChosen.choseDelSubDep1( null );
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseNone );
		buttonChooseSelected = new CFButton();
		buttonChooseSelected.setMinWidth( 200 );
		buttonChooseSelected.setText( "ChooseSelected" );
		buttonChooseSelected.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new CFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					ICFBamDelSubDep1Obj selectedInstance = getJavaFXFocusAsDelSubDep1();
					invokeWhenChosen.choseDelSubDep1( selectedInstance );
					cfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseSelected );
		if( argFocus != null ) {
			dataTable.getSelectionModel().select( argFocus );
		}

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( hboxMenu );

		setTop( scrollMenu );
		setCenter( dataTable );
		adjustListButtons();
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
		if( ( value == null ) || ( value instanceof ICFBamDelSubDep1Obj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDelSubDep1Obj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamDelSubDep1Obj getJavaFXFocusAsDelSubDep1() {
		return( (ICFBamDelSubDep1Obj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsDelSubDep1( ICFBamDelSubDep1Obj value ) {
		setJavaFXFocus( value );
	}

	public class DelSubDep1ByQualNameComparator
	implements Comparator<ICFBamDelSubDep1Obj>
	{
		public DelSubDep1ByQualNameComparator() {
		}

		public int compare( ICFBamDelSubDep1Obj lhs, ICFBamDelSubDep1Obj rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				String lhsValue = lhs.getObjQualifiedName();
				String rhsValue = rhs.getObjQualifiedName();
				if( lhsValue == null ) {
					if( rhsValue == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhsValue == null ) {
					return( 1 );
				}
				else {
					return( lhsValue.compareTo( rhsValue ) );
				}
			}
		}
	}

	protected DelSubDep1ByQualNameComparator compareDelSubDep1ByQualName = new DelSubDep1ByQualNameComparator();

	public Collection<ICFBamDelSubDep1Obj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamDelSubDep1Obj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfDelSubDep1 = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamDelSubDep1Obj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfDelSubDep1.add( iter.next() );
				}
				observableListOfDelSubDep1.sort( compareDelSubDep1ByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfDelSubDep1 );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamDelTopDepObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamDelTopDepObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamDelSubDep1Obj selectedObj = getJavaFXFocusAsDelSubDep1();
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( buttonChooseSelected != null ) {
			buttonChooseSelected.setDisable( ! enableState );
		}
		if( buttonChooseNone != null ) {
			buttonChooseNone.setDisable( false );
		}
		if( buttonCancel != null ) {
			buttonCancel.setDisable( false );
		}

	}
}

