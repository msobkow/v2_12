// Description: Java 11 JavaFX List of Obj Pane implementation for TZTimeType.

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
 *	CFBamJavaFXTZTimeTypeListPane JavaFX List of Obj Pane implementation
 *	for TZTimeType.
 */
public class CFBamJavaFXTZTimeTypeListPane
extends CFBorderPane
implements ICFBamJavaFXTZTimeTypePaneList
{
	public static String S_FormName = "List TZTimeType";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamTZTimeTypeObj> javafxDataCollection = null;
	protected ObservableList<ICFBamTZTimeTypeObj> observableListOfTZTimeType = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected CFButton buttonAddTZTimeType = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFBamTZTimeTypeObj> dataTable = null;
	protected TableColumn<ICFBamTZTimeTypeObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnName = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamTZTimeTypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamTZTimeTypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamTZTimeTypeObj, String> tableColumnDummy = null;
	protected TableColumn<ICFBamTZTimeTypeObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;

	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected ICFBamSchemaDefObj javafxContainer = null;
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


	public CFBamJavaFXTZTimeTypeListPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamSchemaDefObj argContainer,
		ICFBamTZTimeTypeObj argFocus,
		Collection<ICFBamTZTimeTypeObj> argDataCollection,
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
		dataTable = new TableView<ICFBamTZTimeTypeObj>();
		tableColumnId = new TableColumn<ICFBamTZTimeTypeObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamTZTimeTypeObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,Long>,TableCell<ICFBamTZTimeTypeObj,Long>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,Long> call(
				TableColumn<ICFBamTZTimeTypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamTZTimeTypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamTZTimeTypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamTZTimeTypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamTZTimeTypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamTZTimeTypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamTZTimeTypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamTZTimeTypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTZTimeTypeObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,Boolean>,TableCell<ICFBamTZTimeTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,Boolean> call(
				TableColumn<ICFBamTZTimeTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamTZTimeTypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamTZTimeTypeObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,Boolean>,TableCell<ICFBamTZTimeTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,Boolean> call(
				TableColumn<ICFBamTZTimeTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamTZTimeTypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnDummy = new TableColumn<ICFBamTZTimeTypeObj,String>( "Dummy" );
		tableColumnDummy.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamTZTimeTypeObj, String> p ) {
				ICFBamTZTimeDefObj obj = p.getValue();
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
		tableColumnDummy.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,String>,TableCell<ICFBamTZTimeTypeObj,String>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,String> call(
				TableColumn<ICFBamTZTimeTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamTZTimeTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDummy );
		tableColumnLookupDefSchema = new TableColumn<ICFBamTZTimeTypeObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamTZTimeTypeObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamTZTimeTypeObj, ICFBamSchemaDefObj> p ) {
				ICFBamTZTimeTypeObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamTZTimeTypeObj,ICFBamSchemaDefObj>,TableCell<ICFBamTZTimeTypeObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamTZTimeTypeObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamTZTimeTypeObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamTZTimeTypeObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamTZTimeTypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamTZTimeTypeObj> observable,
					ICFBamTZTimeTypeObj oldValue,
					ICFBamTZTimeTypeObj newValue )
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
		if( observableListOfTZTimeType != null ) {
			dataTable.setItems( observableListOfTZTimeType );
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
		if( ( value == null ) || ( value instanceof ICFBamTZTimeTypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamTZTimeTypeObj" );
		}
		adjustListButtons();
	}

	public ICFBamTZTimeTypeObj getJavaFXFocusAsTZTimeType() {
		return( (ICFBamTZTimeTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTZTimeType( ICFBamTZTimeTypeObj value ) {
		setJavaFXFocus( value );
	}

	public class TZTimeTypeByQualNameComparator
	implements Comparator<ICFBamTZTimeTypeObj>
	{
		public TZTimeTypeByQualNameComparator() {
		}

		public int compare( ICFBamTZTimeTypeObj lhs, ICFBamTZTimeTypeObj rhs ) {
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

	protected TZTimeTypeByQualNameComparator compareTZTimeTypeByQualName = new TZTimeTypeByQualNameComparator();

	public Collection<ICFBamTZTimeTypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamTZTimeTypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTZTimeType = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamTZTimeTypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTZTimeType.add( iter.next() );
				}
				observableListOfTZTimeType.sort( compareTZTimeTypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTZTimeType );
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
			buttonAddTZTimeType = new CFButton();
			buttonAddTZTimeType.setMinWidth( 200 );
			buttonAddTZTimeType.setText( "Add TZTimeType" );
			buttonAddTZTimeType.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						ICFBamTZTimeTypeObj obj = (ICFBamTZTimeTypeObj)schemaObj.getTZTimeTypeTableObj().newInstance();
						ICFBamTZTimeTypeEditObj edit = (ICFBamTZTimeTypeEditObj)( obj.beginEdit() );
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
						CFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
						ICFBamJavaFXTZTimeTypePaneCommon jpanelCommon = (ICFBamJavaFXTZTimeTypePaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddTZTimeType );
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
						ICFBamTZTimeTypeObj selectedInstance = getJavaFXFocusAsTZTimeType();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TMZT".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimeTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTZTimeTypeObj" );
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
						ICFBamTZTimeTypeObj selectedInstance = getJavaFXFocusAsTZTimeType();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TMZT".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXTZTimeTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTZTimeTypeObj" );
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
						ICFBamTZTimeTypeObj selectedInstance = getJavaFXFocusAsTZTimeType();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "TMZT".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFBamJavaFXTZTimeTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamTZTimeTypeObj" );
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

	public ICFBamSchemaDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFBamSchemaDefObj value ) {
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
		ICFBamTZTimeTypeObj selectedObj = getJavaFXFocusAsTZTimeType();
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
		if( buttonAddTZTimeType != null ) {
			buttonAddTZTimeType.setDisable( ! allowAdds );
		}

	}
}
