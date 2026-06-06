// Description: Java 11 JavaFX List of Obj Pane implementation for TZTimestampDef.

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
import java.util.*;
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
 *	CFBamJavaFXTZTimestampDefListPane JavaFX List of Obj Pane implementation
 *	for TZTimestampDef.
 */
public class CFBamJavaFXTZTimestampDefListPane
extends CFBorderPane
implements ICFBamJavaFXTZTimestampDefPaneList
{
	public static String S_FormName = "List TZTimestampDef";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTZTimestampDefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTZTimestampDefObj> observableListOfTZTimestampDef = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected ScrollPane scrollMenuAdd = null;
	protected CFVBox vboxMenuAdd = null;
	protected CFButton buttonAdd = null;
	protected CFButton buttonCancelAdd = null;
	protected CFButton buttonAddTZTimestampType = null;
	protected CFButton buttonAddTZTimestampCol = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFBamTZTimestampDefObj> dataTable = null;
	protected TableColumn<ICFBamTZTimestampDefObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamTZTimestampDefObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnName = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamTZTimestampDefObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamTZTimestampDefObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamTZTimestampDefObj, String> tableColumnDummy = null;
	protected TableColumn<ICFBamTZTimestampDefObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;

	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected ICFBamScopeObj javafxContainer = null;
	protected ICFRefreshCallback javafxRefreshCallback = null;
	class ViewEditClosedCallback implements ICFFormClosedCallback {
		public ViewEditClosedCallback() {
		}

		@Override
		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected ViewEditClosedCallback viewEditClosedCallback = null;

	public ICFFormClosedCallback getViewEditClosedCallback() {
		if( viewEditClosedCallback == null ) {
			viewEditClosedCallback = new ViewEditClosedCallback();
		}
		return( viewEditClosedCallback );
	}

	class DeleteCallback implements ICFDeleteCallback {
		public DeleteCallback() {
		}
		@Override
		public void deleted( ICFLibAnyObj deletedObject ) {
			if( deletedObject != null ) {
				refreshMe();
			}
		}

		@Override
		public void formClosed( ICFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected DeleteCallback deleteCallback = null;

	public ICFDeleteCallback getDeleteCallback() {
		if( deleteCallback == null ) {
			deleteCallback = new DeleteCallback();
		}
		return( deleteCallback );
	}


	public CFBamJavaFXTZTimestampDefListPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamScopeObj argContainer,
		ICFBamTZTimestampDefObj argFocus,
		Collection<ICFBamTZTimestampDefObj> argDataCollection,
		ICFRefreshCallback refreshCallback,
		boolean sortByChain )
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
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		javafxRefreshCallback = refreshCallback;
		javafxSortByChain = sortByChain;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<ICFBamTZTimestampDefObj>();
		tableColumnObjKind = new TableColumn<ICFBamTZTimestampDefObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamTZTimestampDefObj obj = p.getValue();
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
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamTZTimestampDefObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamTZTimestampDefObj, Long> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,Long>,TableCell<ICFBamTZTimestampDefObj,Long>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,Long> call(
				TableColumn<ICFBamTZTimestampDefObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTZTimestampDefObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamTZTimestampDefObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTZTimestampDefObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTZTimestampDefObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTZTimestampDefObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamTZTimestampDefObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDefaultXmlValue();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamTZTimestampDefObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTZTimestampDefObj, Boolean> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsNullable();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,Boolean>,TableCell<ICFBamTZTimestampDefObj,Boolean>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,Boolean> call(
				TableColumn<ICFBamTZTimestampDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamTZTimestampDefObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTZTimestampDefObj, Boolean> p ) {
				ICFBamValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Boolean value = obj.getOptionalGenerateId();
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,Boolean>,TableCell<ICFBamTZTimestampDefObj,Boolean>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,Boolean> call(
				TableColumn<ICFBamTZTimestampDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamTZTimestampDefObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamAtomObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDbName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnDummy = new TableColumn<ICFBamTZTimestampDefObj,String>( "Dummy" );
		tableColumnDummy.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimestampDefObj, String> p ) {
				ICFBamTZTimestampDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDummy();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDummy.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,String>,TableCell<ICFBamTZTimestampDefObj,String>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,String> call(
				TableColumn<ICFBamTZTimestampDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimestampDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDummy );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTZTimestampDefObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimestampDefObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTZTimestampDefObj, ICFBamSchemaDefObj> p ) {
				ICFBamTZTimestampDefObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTZTimestampDefObj,ICFBamSchemaDefObj>,TableCell<ICFBamTZTimestampDefObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTZTimestampDefObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTZTimestampDefObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTZTimestampDefObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTZTimestampDefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTZTimestampDefObj> observable,
					ICFBamTZTimestampDefObj oldValue,
					ICFBamTZTimestampDefObj newValue )
				{
					setJavaFXFocus( newValue );
				}
			});

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getPanelHBoxMenu() );

		setTop( scrollMenu );
		setCenter( dataTable );
		javafxIsInitializing = false;
		if( observableListOfTZTimestampDef != null ) {
			dataTable.setItems( observableListOfTZTimestampDef );
		}
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

	public void setPaneMode( CFPane.PaneMode value ) {
		super.setPaneMode( value );
		adjustListButtons();
	}

	public void setJavaFXFocus( ICFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ICFBamTZTimestampDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTZTimestampDefObj" );
		}
		adjustListButtons();
	}

	public ICFBamTZTimestampDefObj getJavaFXFocusAsTZTimestampDef() {
		return( (ICFBamTZTimestampDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTZTimestampDef( ICFBamTZTimestampDefObj value ) {
		setJavaFXFocus( value );
	}

	public class TZTimestampDefByQualNameComparator
	implements Comparator<ICFBamTZTimestampDefObj>
	{
		public TZTimestampDefByQualNameComparator() {
		}

		public int compare( ICFBamTZTimestampDefObj lhs, ICFBamTZTimestampDefObj rhs ) {
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

	protected TZTimestampDefByQualNameComparator compareTZTimestampDefByQualName = new TZTimestampDefByQualNameComparator();

	public Collection<ICFBamTZTimestampDefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTZTimestampDefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTZTimestampDef = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTZTimestampDefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTZTimestampDef.add( iter.next() );
				}
				observableListOfTZTimestampDef.sort( compareTZTimestampDefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTZTimestampDef );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	protected class CompareCFButtonByText
	implements Comparator<CFButton>
	{
		public CompareCFButtonByText() {
		}

		@Override public int compare( CFButton lhs, CFButton rhs ) {
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
				int retval = lhs.getText().compareTo( rhs.getText() );
				return( retval );
			}
		}
	}

	public CFHBox getPanelHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new CFHBox( 10 );
				LinkedList<CFButton> list = new LinkedList<CFButton>();

				vboxMenuAdd = new CFVBox( 10 );
					buttonAddTZTimestampType = new CFButton();
					buttonAddTZTimestampType.setMinWidth( 200 );
					buttonAddTZTimestampType.setText( "Add TZTimestampType" );
					buttonAddTZTimestampType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
								ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)schemaObj.getTZTimestampTypeTableObj().newInstance();
								CFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
								ICFBamTZTimestampTypeEditObj edit = (ICFBamTZTimestampTypeEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new CFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								ICFSecTenantObj secTenant = schemaObj.getSecTenant();
								edit.setRequiredOwnerTenant( secTenant );
								ICFBamSchemaDefObj container = (ICFBamSchemaDefObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new CFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerSchemaDef( container );
								ICFBamJavaFXTZTimestampTypePaneCommon jpanelCommon = (ICFBamJavaFXTZTimestampTypePaneCommon)frame;
								jpanelCommon.setJavaFXFocus( obj );
								jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
								cfFormManager.pushForm( frame );
								setLeft( null );
								adjustListButtons();
							}
							catch( Throwable t ) {
								CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
							}
						}
					});
					if( javafxContainer instanceof ICFBamSchemaDefObj ) {
						list.add( buttonAddTZTimestampType );
					}
					buttonAddTZTimestampCol = new CFButton();
					buttonAddTZTimestampCol.setMinWidth( 200 );
					buttonAddTZTimestampCol.setText( "Add TZTimestampCol" );
					buttonAddTZTimestampCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
								ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)schemaObj.getTZTimestampColTableObj().newInstance();
								CFBorderPane frame = javafxSchema.getTZTimestampColFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
								ICFBamTZTimestampColEditObj edit = (ICFBamTZTimestampColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new CFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								ICFSecTenantObj secTenant = schemaObj.getSecTenant();
								edit.setRequiredOwnerTenant( secTenant );
								ICFBamTableObj container = (ICFBamTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new CFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								ICFBamJavaFXTZTimestampColPaneCommon jpanelCommon = (ICFBamJavaFXTZTimestampColPaneCommon)frame;
								jpanelCommon.setJavaFXFocus( obj );
								jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
								cfFormManager.pushForm( frame );
								setLeft( null );
								adjustListButtons();
							}
							catch( Throwable t ) {
								CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
							}
						}
					});
					if( javafxContainer instanceof ICFBamTableObj ) {
						list.add( buttonAddTZTimestampCol );
					}

				int len = list.size();
				CFButton arr[] = new CFButton[len];
				Iterator<CFButton> iter = list.iterator();
				int idx = 0;
				while( iter.hasNext() ) {
					arr[idx++] = iter.next();
				}
				Arrays.sort( arr, new CompareCFButtonByText() );
				for( idx = 0; idx < len; idx ++ ) {
					vboxMenuAdd.getChildren().add( arr[idx] );
				}

				buttonCancelAdd = new CFButton();
				buttonCancelAdd.setMinWidth( 200 );
				buttonCancelAdd.setText( "Cancel Add..." );
				buttonCancelAdd.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							setLeft( null );
							adjustListButtons();
						}
						catch( Throwable t ) {
							CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
						}
					}
				});
				vboxMenuAdd.getChildren().add( buttonCancelAdd );

				scrollMenuAdd = new ScrollPane();
				scrollMenuAdd.setMinWidth( 240 );
				scrollMenuAdd.setMaxWidth( 240 );
				scrollMenuAdd.setFitToWidth( true );
				scrollMenuAdd.setHbarPolicy( ScrollBarPolicy.NEVER );
				scrollMenuAdd.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
				scrollMenuAdd.setContent( vboxMenuAdd );

			buttonAdd = new CFButton();
			buttonAdd.setMinWidth( 200 );
			buttonAdd.setText( "Add..." );
			buttonAdd.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						setLeft( scrollMenuAdd );
						adjustListButtons();
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAdd );

			buttonViewSelected = new CFButton();
			buttonViewSelected.setMinWidth( 200 );
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
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
						ICFBamTZTimestampDefObj selectedInstance = getJavaFXFocusAsTZTimestampDef();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "ZSTD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTZTimestampDefFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimestampDefPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "ZSTT".equals( classCode ) ) {
								ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimestampTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "ZSTC".equals( classCode ) ) {
								ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getTZTimestampColFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimestampColPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTZTimestampDefObj, ICFBamTZTimestampTypeObj, ICFBamTZTimestampColObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonViewSelected );

			buttonEditSelected = new CFButton();
			buttonEditSelected.setMinWidth( 200 );
			buttonEditSelected.setText( "Edit Selected" );
			buttonEditSelected.setOnAction( new EventHandler<ActionEvent>() {
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
						ICFBamTZTimestampDefObj selectedInstance = getJavaFXFocusAsTZTimestampDef();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "ZSTD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTZTimestampDefFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimestampDefPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else if( "ZSTT".equals( classCode ) ) {
								ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimestampTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else if( "ZSTC".equals( classCode ) ) {
								ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getTZTimestampColFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimestampColPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTZTimestampDefObj, ICFBamTZTimestampTypeObj, ICFBamTZTimestampColObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonEditSelected );

			buttonDeleteSelected = new CFButton();
			buttonDeleteSelected.setMinWidth( 200 );
			buttonDeleteSelected.setText( "Delete Selected" );
			buttonDeleteSelected.setOnAction( new EventHandler<ActionEvent>() {
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
						ICFBamTZTimestampDefObj selectedInstance = getJavaFXFocusAsTZTimestampDef();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "ZSTD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTZTimestampDefFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFBamJavaFXTZTimestampDefPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "ZSTT".equals( classCode ) ) {
								ICFBamTZTimestampTypeObj obj = (ICFBamTZTimestampTypeObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
								((ICFBamJavaFXTZTimestampTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "ZSTC".equals( classCode ) ) {
								ICFBamTZTimestampColObj obj = (ICFBamTZTimestampColObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getTZTimestampColFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
								((ICFBamJavaFXTZTimestampColPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTZTimestampDefObj, ICFBamTZTimestampTypeObj, ICFBamTZTimestampColObj" );
							}
						}
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonDeleteSelected );

		}
		return( hboxMenu );
	}

	public ICFBamScopeObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamScopeObj value ) {
		javafxContainer = value;
	}

	public void refreshMe() {
		if( javafxRefreshCallback != null ) {
			javafxRefreshCallback.refreshMe();
		}
	}

	public void adjustListButtons() {
		boolean enableState;
		boolean inEditState;
		boolean allowAdds;
		boolean inAddMode = false;
		ICFBamTZTimestampDefObj selectedObj = getJavaFXFocusAsTZTimestampDef();
		CFPane.PaneMode mode = getPaneMode();
		if( mode == CFPane.PaneMode.Edit ) {
			inEditState = true;
			allowAdds = false;
		}
		else {
			inEditState = false;
			if( getJavaFXContainer() != null ) {
				if( getLeft() != null ) {
					allowAdds = false;
					inAddMode = true;
				}
				else {
					allowAdds = true;
				}
			}
			else {
				allowAdds = false;
			}
		}
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			if( ( ! inAddMode ) && ( ! inEditState ) ) {
				enableState = true;
			}
			else {
				enableState = false;
			}
		}

		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( ! enableState );
		}
		if( buttonEditSelected != null ) {
			if( inEditState ) {
				buttonEditSelected.setDisable( true );
			}
			else {
				buttonEditSelected.setDisable( ! enableState );
			}
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( ! enableState );
		}

		if( buttonAdd != null ) {
			buttonAdd.setDisable( ! allowAdds );
		}
	}
}
