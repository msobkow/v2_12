// Description: Java 11 JavaFX Picker of Obj Pane implementation for RelationCol.

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
 *	CFBamJavaFXRelationColPickerPane JavaFX Pick Obj Pane implementation
 *	for RelationCol.
 */
public class CFBamJavaFXRelationColPickerPane
extends CFBorderPane
implements ICFBamJavaFXRelationColPaneList
{
	public static String S_FormName = "Choose RelationCol";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamRelationColObj> javafxDataCollection = null;
	protected ObservableList<ICFBamRelationColObj> observableListOfRelationCol = null;
	protected TableColumn<ICFBamRelationColObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamRelationColObj, String> tableColumnName = null;
	protected TableColumn<ICFBamRelationColObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamRelationColObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamRelationColObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamRelationColObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamRelationColObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<ICFBamRelationColObj, ICFBamIndexColObj> tableColumnLookupFromCol = null;
	protected TableColumn<ICFBamRelationColObj, ICFBamIndexColObj> tableColumnLookupToCol = null;
	protected TableView<ICFBamRelationColObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXRelationColChosen invokeWhenChosen = null;
	protected ICFBamRelationObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXRelationColPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamRelationColObj argFocus,
		ICFBamRelationObj argContainer,
		Collection<ICFBamRelationColObj> argDataCollection,
		ICFBamJavaFXRelationColChosen whenChosen )
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
		dataTable = new TableView<ICFBamRelationColObj>();
		tableColumnId = new TableColumn<ICFBamRelationColObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamRelationColObj, Long> p ) {
				ICFBamRelationColObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,Long>,TableCell<ICFBamRelationColObj,Long>>() {
			@Override public TableCell<ICFBamRelationColObj,Long> call(
				TableColumn<ICFBamRelationColObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamRelationColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamRelationColObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamRelationColObj, String> p ) {
				ICFBamRelationColObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,String>,TableCell<ICFBamRelationColObj,String>>() {
			@Override public TableCell<ICFBamRelationColObj,String> call(
				TableColumn<ICFBamRelationColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamRelationColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamRelationColObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamRelationColObj, String> p ) {
				ICFBamRelationColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalShortName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,String>,TableCell<ICFBamRelationColObj,String>>() {
			@Override public TableCell<ICFBamRelationColObj,String> call(
				TableColumn<ICFBamRelationColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamRelationColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamRelationColObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamRelationColObj, String> p ) {
				ICFBamRelationColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalLabel();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,String>,TableCell<ICFBamRelationColObj,String>>() {
			@Override public TableCell<ICFBamRelationColObj,String> call(
				TableColumn<ICFBamRelationColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamRelationColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamRelationColObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamRelationColObj, String> p ) {
				ICFBamRelationColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalShortDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,String>,TableCell<ICFBamRelationColObj,String>>() {
			@Override public TableCell<ICFBamRelationColObj,String> call(
				TableColumn<ICFBamRelationColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamRelationColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamRelationColObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamRelationColObj, String> p ) {
				ICFBamRelationColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,String>,TableCell<ICFBamRelationColObj,String>>() {
			@Override public TableCell<ICFBamRelationColObj,String> call(
				TableColumn<ICFBamRelationColObj,String> arg)
			{
				return new CFStringTableCell<ICFBamRelationColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnLookupDefSchema = new TableColumn<ICFBamRelationColObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamRelationColObj, ICFBamSchemaDefObj> p ) {
				ICFBamRelationColObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,ICFBamSchemaDefObj>,TableCell<ICFBamRelationColObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamRelationColObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamRelationColObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamRelationColObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupFromCol = new TableColumn<ICFBamRelationColObj, ICFBamIndexColObj>( "From Column" );
		tableColumnLookupFromCol.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,ICFBamIndexColObj>,ObservableValue<ICFBamIndexColObj> >() {
			public ObservableValue<ICFBamIndexColObj> call( CellDataFeatures<ICFBamRelationColObj, ICFBamIndexColObj> p ) {
				ICFBamRelationColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamIndexColObj ref = obj.getRequiredLookupFromCol();
					ReadOnlyObjectWrapper<ICFBamIndexColObj> observable = new ReadOnlyObjectWrapper<ICFBamIndexColObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupFromCol.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,ICFBamIndexColObj>,TableCell<ICFBamRelationColObj,ICFBamIndexColObj>>() {
			@Override public TableCell<ICFBamRelationColObj,ICFBamIndexColObj> call(
				TableColumn<ICFBamRelationColObj,ICFBamIndexColObj> arg)
			{
				return new CFReferenceTableCell<ICFBamRelationColObj,ICFBamIndexColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupFromCol );
		tableColumnLookupToCol = new TableColumn<ICFBamRelationColObj, ICFBamIndexColObj>( "To Column" );
		tableColumnLookupToCol.setCellValueFactory( new Callback<CellDataFeatures<ICFBamRelationColObj,ICFBamIndexColObj>,ObservableValue<ICFBamIndexColObj> >() {
			public ObservableValue<ICFBamIndexColObj> call( CellDataFeatures<ICFBamRelationColObj, ICFBamIndexColObj> p ) {
				ICFBamRelationColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamIndexColObj ref = obj.getRequiredLookupToCol();
					ReadOnlyObjectWrapper<ICFBamIndexColObj> observable = new ReadOnlyObjectWrapper<ICFBamIndexColObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupToCol.setCellFactory( new Callback<TableColumn<ICFBamRelationColObj,ICFBamIndexColObj>,TableCell<ICFBamRelationColObj,ICFBamIndexColObj>>() {
			@Override public TableCell<ICFBamRelationColObj,ICFBamIndexColObj> call(
				TableColumn<ICFBamRelationColObj,ICFBamIndexColObj> arg)
			{
				return new CFReferenceTableCell<ICFBamRelationColObj,ICFBamIndexColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupToCol );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamRelationColObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamRelationColObj> observable,
					ICFBamRelationColObj oldValue,
					ICFBamRelationColObj newValue )
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
					invokeWhenChosen.choseRelationCol( null );
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
					ICFBamRelationColObj selectedInstance = getJavaFXFocusAsRelationCol();
					invokeWhenChosen.choseRelationCol( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamRelationColObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamRelationColObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamRelationColObj getJavaFXFocusAsRelationCol() {
		return( (ICFBamRelationColObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsRelationCol( ICFBamRelationColObj value ) {
		setJavaFXFocus( value );
	}

	public class RelationColByQualNameComparator
	implements Comparator<ICFBamRelationColObj>
	{
		public RelationColByQualNameComparator() {
		}

		public int compare( ICFBamRelationColObj lhs, ICFBamRelationColObj rhs ) {
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

	protected RelationColByQualNameComparator compareRelationColByQualName = new RelationColByQualNameComparator();

	public Collection<ICFBamRelationColObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamRelationColObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfRelationCol = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamRelationColObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfRelationCol.add( iter.next() );
				}
				observableListOfRelationCol.sort( compareRelationColByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfRelationCol );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamRelationObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamRelationObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamRelationColObj selectedObj = getJavaFXFocusAsRelationCol();
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

