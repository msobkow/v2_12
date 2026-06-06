// Description: Java 11 JavaFX Picker of Obj Pane implementation for Chain.

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
 *	CFBamJavaFXChainPickerPane JavaFX Pick Obj Pane implementation
 *	for Chain.
 */
public class CFBamJavaFXChainPickerPane
extends CFBorderPane
implements ICFBamJavaFXChainPaneList
{
	public static String S_FormName = "Choose Chain";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamChainObj> javafxDataCollection = null;
	protected ObservableList<ICFBamChainObj> observableListOfChain = null;
	protected TableColumn<ICFBamChainObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamChainObj, String> tableColumnName = null;
	protected TableColumn<ICFBamChainObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamChainObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamChainObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamChainObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamChainObj, String> tableColumnSuffix = null;
	protected TableColumn<ICFBamChainObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<ICFBamChainObj, ICFBamRelationObj> tableColumnLookupPrevRel = null;
	protected TableColumn<ICFBamChainObj, ICFBamRelationObj> tableColumnLookupNextRel = null;
	protected TableView<ICFBamChainObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXChainChosen invokeWhenChosen = null;
	protected ICFBamTableObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXChainPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamChainObj argFocus,
		ICFBamTableObj argContainer,
		Collection<ICFBamChainObj> argDataCollection,
		ICFBamJavaFXChainChosen whenChosen )
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
		dataTable = new TableView<ICFBamChainObj>();
		tableColumnId = new TableColumn<ICFBamChainObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamChainObj, Long> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamChainObj,Long>,TableCell<ICFBamChainObj,Long>>() {
			@Override public TableCell<ICFBamChainObj,Long> call(
				TableColumn<ICFBamChainObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamChainObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamChainObj, String> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamChainObj,String>,TableCell<ICFBamChainObj,String>>() {
			@Override public TableCell<ICFBamChainObj,String> call(
				TableColumn<ICFBamChainObj,String> arg)
			{
				return new CFStringTableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamChainObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamChainObj, String> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamChainObj,String>,TableCell<ICFBamChainObj,String>>() {
			@Override public TableCell<ICFBamChainObj,String> call(
				TableColumn<ICFBamChainObj,String> arg)
			{
				return new CFStringTableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamChainObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamChainObj, String> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamChainObj,String>,TableCell<ICFBamChainObj,String>>() {
			@Override public TableCell<ICFBamChainObj,String> call(
				TableColumn<ICFBamChainObj,String> arg)
			{
				return new CFStringTableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamChainObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamChainObj, String> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamChainObj,String>,TableCell<ICFBamChainObj,String>>() {
			@Override public TableCell<ICFBamChainObj,String> call(
				TableColumn<ICFBamChainObj,String> arg)
			{
				return new CFStringTableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamChainObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamChainObj, String> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamChainObj,String>,TableCell<ICFBamChainObj,String>>() {
			@Override public TableCell<ICFBamChainObj,String> call(
				TableColumn<ICFBamChainObj,String> arg)
			{
				return new CFStringTableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnSuffix = new TableColumn<ICFBamChainObj,String>( "Suffix" );
		tableColumnSuffix.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamChainObj, String> p ) {
				ICFBamChainObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalSuffix();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSuffix.setCellFactory( new Callback<TableColumn<ICFBamChainObj,String>,TableCell<ICFBamChainObj,String>>() {
			@Override public TableCell<ICFBamChainObj,String> call(
				TableColumn<ICFBamChainObj,String> arg)
			{
				return new CFStringTableCell<ICFBamChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSuffix );
		tableColumnLookupDefSchema = new TableColumn<ICFBamChainObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamChainObj, ICFBamSchemaDefObj> p ) {
				ICFBamChainObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamChainObj,ICFBamSchemaDefObj>,TableCell<ICFBamChainObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamChainObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamChainObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamChainObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupPrevRel = new TableColumn<ICFBamChainObj, ICFBamRelationObj>( "Previous Relation" );
		tableColumnLookupPrevRel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,ICFBamRelationObj>,ObservableValue<ICFBamRelationObj> >() {
			public ObservableValue<ICFBamRelationObj> call( CellDataFeatures<ICFBamChainObj, ICFBamRelationObj> p ) {
				ICFBamChainObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamRelationObj ref = obj.getRequiredLookupPrevRel();
					ReadOnlyObjectWrapper<ICFBamRelationObj> observable = new ReadOnlyObjectWrapper<ICFBamRelationObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupPrevRel.setCellFactory( new Callback<TableColumn<ICFBamChainObj,ICFBamRelationObj>,TableCell<ICFBamChainObj,ICFBamRelationObj>>() {
			@Override public TableCell<ICFBamChainObj,ICFBamRelationObj> call(
				TableColumn<ICFBamChainObj,ICFBamRelationObj> arg)
			{
				return new CFReferenceTableCell<ICFBamChainObj,ICFBamRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupPrevRel );
		tableColumnLookupNextRel = new TableColumn<ICFBamChainObj, ICFBamRelationObj>( "Next Relation" );
		tableColumnLookupNextRel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamChainObj,ICFBamRelationObj>,ObservableValue<ICFBamRelationObj> >() {
			public ObservableValue<ICFBamRelationObj> call( CellDataFeatures<ICFBamChainObj, ICFBamRelationObj> p ) {
				ICFBamChainObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFBamRelationObj ref = obj.getRequiredLookupNextRel();
					ReadOnlyObjectWrapper<ICFBamRelationObj> observable = new ReadOnlyObjectWrapper<ICFBamRelationObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupNextRel.setCellFactory( new Callback<TableColumn<ICFBamChainObj,ICFBamRelationObj>,TableCell<ICFBamChainObj,ICFBamRelationObj>>() {
			@Override public TableCell<ICFBamChainObj,ICFBamRelationObj> call(
				TableColumn<ICFBamChainObj,ICFBamRelationObj> arg)
			{
				return new CFReferenceTableCell<ICFBamChainObj,ICFBamRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupNextRel );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamChainObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamChainObj> observable,
					ICFBamChainObj oldValue,
					ICFBamChainObj newValue )
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
					invokeWhenChosen.choseChain( null );
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
					ICFBamChainObj selectedInstance = getJavaFXFocusAsChain();
					invokeWhenChosen.choseChain( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamChainObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamChainObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamChainObj getJavaFXFocusAsChain() {
		return( (ICFBamChainObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsChain( ICFBamChainObj value ) {
		setJavaFXFocus( value );
	}

	public class ChainByQualNameComparator
	implements Comparator<ICFBamChainObj>
	{
		public ChainByQualNameComparator() {
		}

		public int compare( ICFBamChainObj lhs, ICFBamChainObj rhs ) {
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

	protected ChainByQualNameComparator compareChainByQualName = new ChainByQualNameComparator();

	public Collection<ICFBamChainObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamChainObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfChain = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamChainObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfChain.add( iter.next() );
				}
				observableListOfChain.sort( compareChainByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfChain );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFBamTableObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamTableObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamChainObj selectedObj = getJavaFXFocusAsChain();
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

