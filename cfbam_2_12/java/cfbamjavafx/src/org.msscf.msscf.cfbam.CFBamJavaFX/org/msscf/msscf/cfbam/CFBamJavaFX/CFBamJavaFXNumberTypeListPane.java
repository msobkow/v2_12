// Description: Java 11 JavaFX List of Obj Pane implementation for NumberType.

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
 *	CFBamJavaFXNumberTypeListPane JavaFX List of Obj Pane implementation
 *	for NumberType.
 */
public class CFBamJavaFXNumberTypeListPane
extends CFBorderPane
implements ICFBamJavaFXNumberTypePaneList
{
	public static String S_FormName = "List NumberType";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamNumberTypeObj> javafxDataCollection = null;
	protected ObservableList<ICFBamNumberTypeObj> observableListOfNumberType = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected CFButton buttonAddNumberType = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFBamNumberTypeObj> dataTable = null;
	protected TableColumn<ICFBamNumberTypeObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnName = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamNumberTypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamNumberTypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamNumberTypeObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamNumberTypeObj, Short> tableColumnDigits = null;
	protected TableColumn<ICFBamNumberTypeObj, Short> tableColumnPrecis = null;
	protected TableColumn<ICFBamNumberTypeObj, BigDecimal> tableColumnInitValue = null;
	protected TableColumn<ICFBamNumberTypeObj, BigDecimal> tableColumnMinValue = null;
	protected TableColumn<ICFBamNumberTypeObj, BigDecimal> tableColumnMaxValue = null;
	protected TableColumn<ICFBamNumberTypeObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;

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


	public CFBamJavaFXNumberTypeListPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamSchemaDefObj argContainer,
		ICFBamNumberTypeObj argFocus,
		Collection<ICFBamNumberTypeObj> argDataCollection,
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
		dataTable = new TableView<ICFBamNumberTypeObj>();
		tableColumnId = new TableColumn<ICFBamNumberTypeObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamNumberTypeObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,Long>,TableCell<ICFBamNumberTypeObj,Long>>() {
			@Override public TableCell<ICFBamNumberTypeObj,Long> call(
				TableColumn<ICFBamNumberTypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamNumberTypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamNumberTypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamNumberTypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamNumberTypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamNumberTypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamNumberTypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamNumberTypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamNumberTypeObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,Boolean>,TableCell<ICFBamNumberTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamNumberTypeObj,Boolean> call(
				TableColumn<ICFBamNumberTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamNumberTypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamNumberTypeObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,Boolean>,TableCell<ICFBamNumberTypeObj,Boolean>>() {
			@Override public TableCell<ICFBamNumberTypeObj,Boolean> call(
				TableColumn<ICFBamNumberTypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamNumberTypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamNumberTypeObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,String>,TableCell<ICFBamNumberTypeObj,String>>() {
			@Override public TableCell<ICFBamNumberTypeObj,String> call(
				TableColumn<ICFBamNumberTypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnDigits = new TableColumn<ICFBamNumberTypeObj,Short>( "Digits" );
		tableColumnDigits.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamNumberTypeObj, Short> p ) {
				ICFBamNumberDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredDigits();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnDigits.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,Short>,TableCell<ICFBamNumberTypeObj,Short>>() {
			@Override public TableCell<ICFBamNumberTypeObj,Short> call(
				TableColumn<ICFBamNumberTypeObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDigits );
		tableColumnPrecis = new TableColumn<ICFBamNumberTypeObj,Short>( "Precision" );
		tableColumnPrecis.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ICFBamNumberTypeObj, Short> p ) {
				ICFBamNumberDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredPrecis();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnPrecis.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,Short>,TableCell<ICFBamNumberTypeObj,Short>>() {
			@Override public TableCell<ICFBamNumberTypeObj,Short> call(
				TableColumn<ICFBamNumberTypeObj,Short> arg)
			{
				return new CFInt16TableCell<ICFBamNumberTypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPrecis );
		tableColumnInitValue = new TableColumn<ICFBamNumberTypeObj,BigDecimal>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,BigDecimal>,ObservableValue<BigDecimal> >() {
			public ObservableValue<BigDecimal> call( CellDataFeatures<ICFBamNumberTypeObj, BigDecimal> p ) {
				ICFBamNumberDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					BigDecimal value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<BigDecimal> observable = new ReadOnlyObjectWrapper<BigDecimal>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,BigDecimal>,TableCell<ICFBamNumberTypeObj,BigDecimal>>() {
			@Override public TableCell<ICFBamNumberTypeObj,BigDecimal> call(
				TableColumn<ICFBamNumberTypeObj,BigDecimal> arg)
			{
				return new CFNumberTableCell<ICFBamNumberTypeObj>( 31, 5 );
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamNumberTypeObj,BigDecimal>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,BigDecimal>,ObservableValue<BigDecimal> >() {
			public ObservableValue<BigDecimal> call( CellDataFeatures<ICFBamNumberTypeObj, BigDecimal> p ) {
				ICFBamNumberDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					BigDecimal value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<BigDecimal> observable = new ReadOnlyObjectWrapper<BigDecimal>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,BigDecimal>,TableCell<ICFBamNumberTypeObj,BigDecimal>>() {
			@Override public TableCell<ICFBamNumberTypeObj,BigDecimal> call(
				TableColumn<ICFBamNumberTypeObj,BigDecimal> arg)
			{
				return new CFNumberTableCell<ICFBamNumberTypeObj>( 31, 5 );
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamNumberTypeObj,BigDecimal>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,BigDecimal>,ObservableValue<BigDecimal> >() {
			public ObservableValue<BigDecimal> call( CellDataFeatures<ICFBamNumberTypeObj, BigDecimal> p ) {
				ICFBamNumberDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					BigDecimal value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<BigDecimal> observable = new ReadOnlyObjectWrapper<BigDecimal>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,BigDecimal>,TableCell<ICFBamNumberTypeObj,BigDecimal>>() {
			@Override public TableCell<ICFBamNumberTypeObj,BigDecimal> call(
				TableColumn<ICFBamNumberTypeObj,BigDecimal> arg)
			{
				return new CFNumberTableCell<ICFBamNumberTypeObj>( 31, 5 );
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamNumberTypeObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamNumberTypeObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamNumberTypeObj, ICFBamSchemaDefObj> p ) {
				ICFBamNumberTypeObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamNumberTypeObj,ICFBamSchemaDefObj>,TableCell<ICFBamNumberTypeObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamNumberTypeObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamNumberTypeObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamNumberTypeObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamNumberTypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamNumberTypeObj> observable,
					ICFBamNumberTypeObj oldValue,
					ICFBamNumberTypeObj newValue )
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
		if( observableListOfNumberType != null ) {
			dataTable.setItems( observableListOfNumberType );
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
		if( ( value == null ) || ( value instanceof ICFBamNumberTypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamNumberTypeObj" );
		}
		adjustListButtons();
	}

	public ICFBamNumberTypeObj getJavaFXFocusAsNumberType() {
		return( (ICFBamNumberTypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsNumberType( ICFBamNumberTypeObj value ) {
		setJavaFXFocus( value );
	}

	public class NumberTypeByQualNameComparator
	implements Comparator<ICFBamNumberTypeObj>
	{
		public NumberTypeByQualNameComparator() {
		}

		public int compare( ICFBamNumberTypeObj lhs, ICFBamNumberTypeObj rhs ) {
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

	protected NumberTypeByQualNameComparator compareNumberTypeByQualName = new NumberTypeByQualNameComparator();

	public Collection<ICFBamNumberTypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamNumberTypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfNumberType = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamNumberTypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfNumberType.add( iter.next() );
				}
				observableListOfNumberType.sort( compareNumberTypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfNumberType );
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
			buttonAddNumberType = new CFButton();
			buttonAddNumberType.setMinWidth( 200 );
			buttonAddNumberType.setText( "Add NumberType" );
			buttonAddNumberType.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						ICFBamNumberTypeObj obj = (ICFBamNumberTypeObj)schemaObj.getNumberTypeTableObj().newInstance();
						ICFBamNumberTypeEditObj edit = (ICFBamNumberTypeEditObj)( obj.beginEdit() );
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
						CFBorderPane frame = javafxSchema.getNumberTypeFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
						ICFBamJavaFXNumberTypePaneCommon jpanelCommon = (ICFBamJavaFXNumberTypePaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddNumberType );
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
						ICFBamNumberTypeObj selectedInstance = getJavaFXFocusAsNumberType();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "NUMT".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getNumberTypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXNumberTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamNumberTypeObj" );
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
						ICFBamNumberTypeObj selectedInstance = getJavaFXFocusAsNumberType();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "NUMT".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getNumberTypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXNumberTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamNumberTypeObj" );
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
						ICFBamNumberTypeObj selectedInstance = getJavaFXFocusAsNumberType();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "NUMT".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getNumberTypeFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFBamJavaFXNumberTypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamNumberTypeObj" );
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
		ICFBamNumberTypeObj selectedObj = getJavaFXFocusAsNumberType();
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
		if( buttonAddNumberType != null ) {
			buttonAddNumberType.setDisable( ! allowAdds );
		}

	}
}
