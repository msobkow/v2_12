// Description: Java 11 JavaFX Picker of Obj Pane implementation for ClearSubDep2.

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
 *	CFBamJavaFXClearSubDep2PickerPane JavaFX Pick Obj Pane implementation
 *	for ClearSubDep2.
 */
public class CFBamJavaFXClearSubDep2PickerPane
extends CFBorderPane
implements ICFBamJavaFXClearSubDep2PaneList
{
	public static String S_FormName = "Choose ClearSubDep2";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamClearSubDep2Obj> javafxDataCollection = null;
	protected ObservableList<ICFBamClearSubDep2Obj> observableListOfClearSubDep2 = null;
	protected TableColumn<ICFBamClearSubDep2Obj, Long> tableColumnId = null;
	protected TableColumn<ICFBamClearSubDep2Obj, String> tableColumnName = null;
	protected TableColumn<ICFBamClearSubDep2Obj, ICFBamRelationObj> tableColumnLookupRelation = null;
	protected TableColumn<ICFBamClearSubDep2Obj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamClearSubDep2Obj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXClearSubDep2Chosen invokeWhenChosen = null;
	protected ICFBamClearSubDep1Obj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXClearSubDep2PickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamClearSubDep2Obj argFocus,
		ICFBamClearSubDep1Obj argContainer,
		Collection<ICFBamClearSubDep2Obj> argDataCollection,
		ICFBamJavaFXClearSubDep2Chosen whenChosen )
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
		dataTable = new TableView<ICFBamClearSubDep2Obj>();
		tableColumnId = new TableColumn<ICFBamClearSubDep2Obj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep2Obj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamClearSubDep2Obj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep2Obj,Long>,TableCell<ICFBamClearSubDep2Obj,Long>>() {
			@Override public TableCell<ICFBamClearSubDep2Obj,Long> call(
				TableColumn<ICFBamClearSubDep2Obj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamClearSubDep2Obj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamClearSubDep2Obj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep2Obj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamClearSubDep2Obj, String> p ) {
				ICFBamClearSubDep2Obj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep2Obj,String>,TableCell<ICFBamClearSubDep2Obj,String>>() {
			@Override public TableCell<ICFBamClearSubDep2Obj,String> call(
				TableColumn<ICFBamClearSubDep2Obj,String> arg)
			{
				return new CFStringTableCell<ICFBamClearSubDep2Obj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnLookupRelation = new TableColumn<ICFBamClearSubDep2Obj, ICFBamRelationObj>( "Relation" );
		tableColumnLookupRelation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep2Obj,ICFBamRelationObj>,ObservableValue<ICFBamRelationObj> >() {
			public ObservableValue<ICFBamRelationObj> call( CellDataFeatures<ICFBamClearSubDep2Obj, ICFBamRelationObj> p ) {
				ICFBamClearSubDep2Obj obj = p.getValue();
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
		tableColumnLookupRelation.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep2Obj,ICFBamRelationObj>,TableCell<ICFBamClearSubDep2Obj,ICFBamRelationObj>>() {
			@Override public TableCell<ICFBamClearSubDep2Obj,ICFBamRelationObj> call(
				TableColumn<ICFBamClearSubDep2Obj,ICFBamRelationObj> arg)
			{
				return new CFReferenceTableCell<ICFBamClearSubDep2Obj,ICFBamRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupRelation );
		tableColumnLookupDefSchema = new TableColumn<ICFBamClearSubDep2Obj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamClearSubDep2Obj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamClearSubDep2Obj, ICFBamSchemaDefObj> p ) {
				ICFBamClearSubDep2Obj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamClearSubDep2Obj,ICFBamSchemaDefObj>,TableCell<ICFBamClearSubDep2Obj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamClearSubDep2Obj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamClearSubDep2Obj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamClearSubDep2Obj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamClearSubDep2Obj>() {
				@Override public void changed( ObservableValue<? extends ICFBamClearSubDep2Obj> observable,
					ICFBamClearSubDep2Obj oldValue,
					ICFBamClearSubDep2Obj newValue )
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
					invokeWhenChosen.choseClearSubDep2( null );
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
					ICFBamClearSubDep2Obj selectedInstance = getJavaFXFocusAsClearSubDep2();
					invokeWhenChosen.choseClearSubDep2( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamClearSubDep2Obj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamClearSubDep2Obj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamClearSubDep2Obj getJavaFXFocusAsClearSubDep2() {
		return( (ICFBamClearSubDep2Obj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsClearSubDep2( ICFBamClearSubDep2Obj value ) {
		setJavaFXFocus( value );
	}

	public class ClearSubDep2ByQualNameComparator
	implements Comparator<ICFBamClearSubDep2Obj>
	{
		public ClearSubDep2ByQualNameComparator() {
		}

		public int compare( ICFBamClearSubDep2Obj lhs, ICFBamClearSubDep2Obj rhs ) {
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

	protected ClearSubDep2ByQualNameComparator compareClearSubDep2ByQualName = new ClearSubDep2ByQualNameComparator();

	public Collection<ICFBamClearSubDep2Obj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamClearSubDep2Obj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfClearSubDep2 = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamClearSubDep2Obj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfClearSubDep2.add( iter.next() );
				}
				observableListOfClearSubDep2.sort( compareClearSubDep2ByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfClearSubDep2 );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamClearSubDep1Obj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamClearSubDep1Obj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamClearSubDep2Obj selectedObj = getJavaFXFocusAsClearSubDep2();
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

