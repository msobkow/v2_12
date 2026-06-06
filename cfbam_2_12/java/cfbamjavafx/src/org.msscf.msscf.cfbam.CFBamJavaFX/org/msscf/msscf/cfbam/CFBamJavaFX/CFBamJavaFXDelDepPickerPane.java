// Description: Java 11 JavaFX Picker of Obj Pane implementation for DelDep.

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
 *	CFBamJavaFXDelDepPickerPane JavaFX Pick Obj Pane implementation
 *	for DelDep.
 */
public class CFBamJavaFXDelDepPickerPane
extends CFBorderPane
implements ICFBamJavaFXDelDepPaneList
{
	public static String S_FormName = "Choose DelDep";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamDelDepObj> javafxDataCollection = null;
	protected ObservableList<ICFBamDelDepObj> observableListOfDelDep = null;
	protected TableColumn<ICFBamDelDepObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamDelDepObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamDelDepObj, ICFBamRelationObj> tableColumnLookupRelation = null;
	protected TableColumn<ICFBamDelDepObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<ICFBamDelDepObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXDelDepChosen invokeWhenChosen = null;
	protected ICFLibAnyObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXDelDepPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamDelDepObj argFocus,
		ICFLibAnyObj argContainer,
		Collection<ICFBamDelDepObj> argDataCollection,
		ICFBamJavaFXDelDepChosen whenChosen )
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
		dataTable = new TableView<ICFBamDelDepObj>();
		tableColumnObjKind = new TableColumn<ICFBamDelDepObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelDepObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamDelDepObj, String> p ) {
				ICFBamDelDepObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String classCode = obj.getClassCode();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( classCode );
					return( observable );
				}
			}
		});
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamDelDepObj,String>,TableCell<ICFBamDelDepObj,String>>() {
			@Override public TableCell<ICFBamDelDepObj,String> call(
				TableColumn<ICFBamDelDepObj,String> arg)
			{
				return new CFStringTableCell<ICFBamDelDepObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamDelDepObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelDepObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamDelDepObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamDelDepObj,Long>,TableCell<ICFBamDelDepObj,Long>>() {
			@Override public TableCell<ICFBamDelDepObj,Long> call(
				TableColumn<ICFBamDelDepObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamDelDepObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnLookupRelation = new TableColumn<ICFBamDelDepObj, ICFBamRelationObj>( "Relation" );
		tableColumnLookupRelation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelDepObj,ICFBamRelationObj>,ObservableValue<ICFBamRelationObj> >() {
			public ObservableValue<ICFBamRelationObj> call( CellDataFeatures<ICFBamDelDepObj, ICFBamRelationObj> p ) {
				ICFBamDelDepObj obj = p.getValue();
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
		tableColumnLookupRelation.setCellFactory( new Callback<TableColumn<ICFBamDelDepObj,ICFBamRelationObj>,TableCell<ICFBamDelDepObj,ICFBamRelationObj>>() {
			@Override public TableCell<ICFBamDelDepObj,ICFBamRelationObj> call(
				TableColumn<ICFBamDelDepObj,ICFBamRelationObj> arg)
			{
				return new CFReferenceTableCell<ICFBamDelDepObj,ICFBamRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupRelation );
		tableColumnLookupDefSchema = new TableColumn<ICFBamDelDepObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamDelDepObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamDelDepObj, ICFBamSchemaDefObj> p ) {
				ICFBamDelDepObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamDelDepObj,ICFBamSchemaDefObj>,TableCell<ICFBamDelDepObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamDelDepObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamDelDepObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamDelDepObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamDelDepObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamDelDepObj> observable,
					ICFBamDelDepObj oldValue,
					ICFBamDelDepObj newValue )
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
					invokeWhenChosen.choseDelDep( null );
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
					ICFBamDelDepObj selectedInstance = getJavaFXFocusAsDelDep();
					invokeWhenChosen.choseDelDep( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamDelDepObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamDelDepObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamDelDepObj getJavaFXFocusAsDelDep() {
		return( (ICFBamDelDepObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsDelDep( ICFBamDelDepObj value ) {
		setJavaFXFocus( value );
	}

	public class DelDepByQualNameComparator
	implements Comparator<ICFBamDelDepObj>
	{
		public DelDepByQualNameComparator() {
		}

		public int compare( ICFBamDelDepObj lhs, ICFBamDelDepObj rhs ) {
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

	protected DelDepByQualNameComparator compareDelDepByQualName = new DelDepByQualNameComparator();

	public Collection<ICFBamDelDepObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamDelDepObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfDelDep = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamDelDepObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfDelDep.add( iter.next() );
				}
				observableListOfDelDep.sort( compareDelDepByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfDelDep );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFLibAnyObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFLibAnyObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamDelDepObj selectedObj = getJavaFXFocusAsDelDep();
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

