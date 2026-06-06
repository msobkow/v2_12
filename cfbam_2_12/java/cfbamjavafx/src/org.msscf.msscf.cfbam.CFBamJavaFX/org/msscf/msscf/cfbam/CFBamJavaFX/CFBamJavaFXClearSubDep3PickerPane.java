// Description: Java 11 JavaFX Picker of Obj Pane implementation for ClearSubDep3.

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
 *	CFBamJavaFXClearSubDep3PickerPane JavaFX Pick Obj Pane implementation
 *	for ClearSubDep3.
 */
public class CFBamJavaFXClearSubDep3PickerPane
extends CFBorderPane
implements ICFBamJavaFXClearSubDep3PaneList
{
	public static String S_FormName = "Choose ClearSubDep3";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamClearSubDep3Obj> javafxDataCollection = null;
	protected ObservableList<ICFBamClearSubDep3Obj> observableListOfClearSubDep3 = null;
	protected TableColumn<ICFBamClearSubDep3Obj, Long> tableColumnId = null;
	protected TableColumn<ICFBamClearSubDep3Obj, String> tableColumnName = null;
	protected TableColumn<ICFBamClearSubDep3Obj, ICFBamRelationObj> tableColumnLookupRelation = null;
	protected TableColumn<ICFBamClearSubDep3Obj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamClearSubDep3Obj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXClearSubDep3Chosen invokeWhenChosen = null;
	protected ICFBamClearSubDep2Obj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXClearSubDep3PickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamClearSubDep3Obj argFocus,
		ICFBamClearSubDep2Obj argContainer,
		Collection<ICFBamClearSubDep3Obj> argDataCollection,
		ICFBamJavaFXClearSubDep3Chosen whenChosen )
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
		dataTable = new TableView<ICFBamClearSubDep3Obj>();
		tableColumnId = new TableColumn<ICFBamClearSubDep3Obj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep3Obj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamClearSubDep3Obj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep3Obj,Long>,TableCell<ICFBamClearSubDep3Obj,Long>>() {
			@Override public TableCell<ICFBamClearSubDep3Obj,Long> call(
				TableColumn<ICFBamClearSubDep3Obj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamClearSubDep3Obj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamClearSubDep3Obj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep3Obj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamClearSubDep3Obj, String> p ) {
				ICFBamClearSubDep3Obj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep3Obj,String>,TableCell<ICFBamClearSubDep3Obj,String>>() {
			@Override public TableCell<ICFBamClearSubDep3Obj,String> call(
				TableColumn<ICFBamClearSubDep3Obj,String> arg)
			{
				return new CFStringTableCell<ICFBamClearSubDep3Obj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnLookupRelation = new TableColumn<ICFBamClearSubDep3Obj, ICFBamRelationObj>( "Relation" );
		tableColumnLookupRelation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep3Obj,ICFBamRelationObj>,ObservableValue<ICFBamRelationObj> >() {
			public ObservableValue<ICFBamRelationObj> call( CellDataFeatures<ICFBamClearSubDep3Obj, ICFBamRelationObj> p ) {
				ICFBamClearSubDep3Obj obj = p.getValue();
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
		tableColumnLookupRelation.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep3Obj,ICFBamRelationObj>,TableCell<ICFBamClearSubDep3Obj,ICFBamRelationObj>>() {
			@Override public TableCell<ICFBamClearSubDep3Obj,ICFBamRelationObj> call(
				TableColumn<ICFBamClearSubDep3Obj,ICFBamRelationObj> arg)
			{
				return new CFReferenceTableCell<ICFBamClearSubDep3Obj,ICFBamRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupRelation );
		tableColumnLookupDefSchema = new TableColumn<ICFBamClearSubDep3Obj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep3Obj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamClearSubDep3Obj, ICFBamSchemaDefObj> p ) {
				ICFBamClearSubDep3Obj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep3Obj,ICFBamSchemaDefObj>,TableCell<ICFBamClearSubDep3Obj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamClearSubDep3Obj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamClearSubDep3Obj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamClearSubDep3Obj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamClearSubDep3Obj>() {
				@Override public void changed( ObservableValue<? extends ICFBamClearSubDep3Obj> observable,
					ICFBamClearSubDep3Obj oldValue,
					ICFBamClearSubDep3Obj newValue )
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
					invokeWhenChosen.choseClearSubDep3( null );
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
					ICFBamClearSubDep3Obj selectedInstance = getJavaFXFocusAsClearSubDep3();
					invokeWhenChosen.choseClearSubDep3( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamClearSubDep3Obj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamClearSubDep3Obj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamClearSubDep3Obj getJavaFXFocusAsClearSubDep3() {
		return( (ICFBamClearSubDep3Obj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsClearSubDep3( ICFBamClearSubDep3Obj value ) {
		setJavaFXFocus( value );
	}

	public class ClearSubDep3ByQualNameComparator
	implements Comparator<ICFBamClearSubDep3Obj>
	{
		public ClearSubDep3ByQualNameComparator() {
		}

		public int compare( ICFBamClearSubDep3Obj lhs, ICFBamClearSubDep3Obj rhs ) {
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

	protected ClearSubDep3ByQualNameComparator compareClearSubDep3ByQualName = new ClearSubDep3ByQualNameComparator();

	public Collection<ICFBamClearSubDep3Obj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamClearSubDep3Obj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfClearSubDep3 = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamClearSubDep3Obj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfClearSubDep3.add( iter.next() );
				}
				observableListOfClearSubDep3.sort( compareClearSubDep3ByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfClearSubDep3 );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamClearSubDep2Obj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamClearSubDep2Obj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamClearSubDep3Obj selectedObj = getJavaFXFocusAsClearSubDep3();
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

