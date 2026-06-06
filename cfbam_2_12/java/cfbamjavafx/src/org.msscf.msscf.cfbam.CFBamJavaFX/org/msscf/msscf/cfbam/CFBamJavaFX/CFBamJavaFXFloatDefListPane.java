// Description: Java 11 JavaFX List of Obj Pane implementation for FloatDef.

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
 *	CFBamJavaFXFloatDefListPane JavaFX List of Obj Pane implementation
 *	for FloatDef.
 */
public class CFBamJavaFXFloatDefListPane
extends CFBorderPane
implements ICFBamJavaFXFloatDefPaneList
{
	public static String S_FormName = "List FloatDef";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamFloatDefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamFloatDefObj> observableListOfFloatDef = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected ScrollPane scrollMenuAdd = null;
	protected CFVBox vboxMenuAdd = null;
	protected CFButton buttonAdd = null;
	protected CFButton buttonCancelAdd = null;
	protected CFButton buttonAddFloatType = null;
	protected CFButton buttonAddFloatCol = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFBamFloatDefObj> dataTable = null;
	protected TableColumn<ICFBamFloatDefObj,String> tableColumnObjKind = null;
	protected TableColumn<ICFBamFloatDefObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnName = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamFloatDefObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamFloatDefObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamFloatDefObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamFloatDefObj, Float> tableColumnInitValue = null;
	protected TableColumn<ICFBamFloatDefObj, Float> tableColumnMinValue = null;
	protected TableColumn<ICFBamFloatDefObj, Float> tableColumnMaxValue = null;
	protected TableColumn<ICFBamFloatDefObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;

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


	public CFBamJavaFXFloatDefListPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamScopeObj argContainer,
		ICFBamFloatDefObj argFocus,
		Collection<ICFBamFloatDefObj> argDataCollection,
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
		dataTable = new TableView<ICFBamFloatDefObj>();
		tableColumnObjKind = new TableColumn<ICFBamFloatDefObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
				ICFBamFloatDefObj obj = p.getValue();
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
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<ICFBamFloatDefObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamFloatDefObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Long>,TableCell<ICFBamFloatDefObj,Long>>() {
			@Override public TableCell<ICFBamFloatDefObj,Long> call(
				TableColumn<ICFBamFloatDefObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamFloatDefObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamFloatDefObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamFloatDefObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamFloatDefObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamFloatDefObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamFloatDefObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamFloatDefObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamFloatDefObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Boolean>,TableCell<ICFBamFloatDefObj,Boolean>>() {
			@Override public TableCell<ICFBamFloatDefObj,Boolean> call(
				TableColumn<ICFBamFloatDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamFloatDefObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamFloatDefObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Boolean>,TableCell<ICFBamFloatDefObj,Boolean>>() {
			@Override public TableCell<ICFBamFloatDefObj,Boolean> call(
				TableColumn<ICFBamFloatDefObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamFloatDefObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamFloatDefObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,String>,TableCell<ICFBamFloatDefObj,String>>() {
			@Override public TableCell<ICFBamFloatDefObj,String> call(
				TableColumn<ICFBamFloatDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamFloatDefObj,Float>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatDefObj, Float> p ) {
				ICFBamFloatDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Float value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Float> observable = new ReadOnlyObjectWrapper<Float>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Float>,TableCell<ICFBamFloatDefObj,Float>>() {
			@Override public TableCell<ICFBamFloatDefObj,Float> call(
				TableColumn<ICFBamFloatDefObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamFloatDefObj,Float>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatDefObj, Float> p ) {
				ICFBamFloatDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Float value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Float> observable = new ReadOnlyObjectWrapper<Float>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Float>,TableCell<ICFBamFloatDefObj,Float>>() {
			@Override public TableCell<ICFBamFloatDefObj,Float> call(
				TableColumn<ICFBamFloatDefObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamFloatDefObj,Float>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,Float>,ObservableValue<Float> >() {
			public ObservableValue<Float> call( CellDataFeatures<ICFBamFloatDefObj, Float> p ) {
				ICFBamFloatDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Float value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Float> observable = new ReadOnlyObjectWrapper<Float>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,Float>,TableCell<ICFBamFloatDefObj,Float>>() {
			@Override public TableCell<ICFBamFloatDefObj,Float> call(
				TableColumn<ICFBamFloatDefObj,Float> arg)
			{
				return new CFFloatTableCell<ICFBamFloatDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamFloatDefObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamFloatDefObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamFloatDefObj, ICFBamSchemaDefObj> p ) {
				ICFBamFloatDefObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamFloatDefObj,ICFBamSchemaDefObj>,TableCell<ICFBamFloatDefObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamFloatDefObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamFloatDefObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamFloatDefObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamFloatDefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamFloatDefObj> observable,
					ICFBamFloatDefObj oldValue,
					ICFBamFloatDefObj newValue )
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
		if( observableListOfFloatDef != null ) {
			dataTable.setItems( observableListOfFloatDef );
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
		if( ( value == null ) || ( value instanceof ICFBamFloatDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamFloatDefObj" );
		}
		adjustListButtons();
	}

	public ICFBamFloatDefObj getJavaFXFocusAsFloatDef() {
		return( (ICFBamFloatDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsFloatDef( ICFBamFloatDefObj value ) {
		setJavaFXFocus( value );
	}

	public class FloatDefByQualNameComparator
	implements Comparator<ICFBamFloatDefObj>
	{
		public FloatDefByQualNameComparator() {
		}

		public int compare( ICFBamFloatDefObj lhs, ICFBamFloatDefObj rhs ) {
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

	protected FloatDefByQualNameComparator compareFloatDefByQualName = new FloatDefByQualNameComparator();

	public Collection<ICFBamFloatDefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamFloatDefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfFloatDef = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamFloatDefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfFloatDef.add( iter.next() );
				}
				observableListOfFloatDef.sort( compareFloatDefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfFloatDef );
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
					buttonAddFloatType = new CFButton();
					buttonAddFloatType.setMinWidth( 200 );
					buttonAddFloatType.setText( "Add FloatType" );
					buttonAddFloatType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
								ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)schemaObj.getFloatTypeTableObj().newInstance();
								CFBorderPane frame = javafxSchema.getFloatTypeFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
								ICFBamFloatTypeEditObj edit = (ICFBamFloatTypeEditObj)( obj.beginEdit() );
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
								ICFBamJavaFXFloatTypePaneCommon jpanelCommon = (ICFBamJavaFXFloatTypePaneCommon)frame;
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
						list.add( buttonAddFloatType );
					}
					buttonAddFloatCol = new CFButton();
					buttonAddFloatCol.setMinWidth( 200 );
					buttonAddFloatCol.setText( "Add FloatCol" );
					buttonAddFloatCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
								ICFBamFloatColObj obj = (ICFBamFloatColObj)schemaObj.getFloatColTableObj().newInstance();
								CFBorderPane frame = javafxSchema.getFloatColFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
								ICFBamFloatColEditObj edit = (ICFBamFloatColEditObj)( obj.beginEdit() );
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
								ICFBamJavaFXFloatColPaneCommon jpanelCommon = (ICFBamJavaFXFloatColPaneCommon)frame;
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
						list.add( buttonAddFloatCol );
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
						ICFBamFloatDefObj selectedInstance = getJavaFXFocusAsFloatDef();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "FLTD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getFloatDefFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXFloatDefPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "FLTT".equals( classCode ) ) {
								ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getFloatTypeFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXFloatTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "FLTC".equals( classCode ) ) {
								ICFBamFloatColObj obj = (ICFBamFloatColObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getFloatColFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXFloatColPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamFloatDefObj, ICFBamFloatTypeObj, ICFBamFloatColObj" );
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
						ICFBamFloatDefObj selectedInstance = getJavaFXFocusAsFloatDef();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "FLTD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getFloatDefFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXFloatDefPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else if( "FLTT".equals( classCode ) ) {
								ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getFloatTypeFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXFloatTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else if( "FLTC".equals( classCode ) ) {
								ICFBamFloatColObj obj = (ICFBamFloatColObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getFloatColFactory().newViewEditForm( cfFormManager, obj, getViewEditClosedCallback(), false );
								((ICFBamJavaFXFloatColPaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamFloatDefObj, ICFBamFloatTypeObj, ICFBamFloatColObj" );
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
						ICFBamFloatDefObj selectedInstance = getJavaFXFocusAsFloatDef();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "FLTD".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getFloatDefFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFBamJavaFXFloatDefPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "FLTT".equals( classCode ) ) {
								ICFBamFloatTypeObj obj = (ICFBamFloatTypeObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getFloatTypeFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
								((ICFBamJavaFXFloatTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else if( "FLTC".equals( classCode ) ) {
								ICFBamFloatColObj obj = (ICFBamFloatColObj)selectedInstance;
								CFBorderPane frame = javafxSchema.getFloatColFactory().newAskDeleteForm( cfFormManager, obj, getDeleteCallback() );
								((ICFBamJavaFXFloatColPaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamFloatDefObj, ICFBamFloatTypeObj, ICFBamFloatColObj" );
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
		ICFBamFloatDefObj selectedObj = getJavaFXFocusAsFloatDef();
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
