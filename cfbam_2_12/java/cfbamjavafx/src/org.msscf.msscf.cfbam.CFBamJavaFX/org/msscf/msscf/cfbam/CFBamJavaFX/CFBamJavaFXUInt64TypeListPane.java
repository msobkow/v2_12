// Description: Java 11 JavaFX List of Obj Pane implementation for UInt64Type.

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
 *	CFBamJavaFXUInt64TypeListPane JavaFX List of Obj Pane implementation
 *	for UInt64Type.
 */
public class CFBamJavaFXUInt64TypeListPane
extends CFBorderPane
implements ICFBamJavaFXUInt64TypePaneList
{
	public static String S_FormName = "List UInt64Type";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamUInt64TypeObj> javafxDataCollection = null;
	protected ObservableList<ICFBamUInt64TypeObj> observableListOfUInt64Type = null;
	protected ScrollPane scrollMenu = null;
	protected CFHBox hboxMenu = null;
	protected CFButton buttonAddUInt64Type = null;
	protected CFButton buttonViewSelected = null;
	protected CFButton buttonEditSelected = null;
	protected CFButton buttonDeleteSelected = null;
	protected TableView<ICFBamUInt64TypeObj> dataTable = null;
	protected TableColumn<ICFBamUInt64TypeObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnName = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<ICFBamUInt64TypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<ICFBamUInt64TypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<ICFBamUInt64TypeObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamUInt64TypeObj, BigDecimal> tableColumnInitValue = null;
	protected TableColumn<ICFBamUInt64TypeObj, BigDecimal> tableColumnMinValue = null;
	protected TableColumn<ICFBamUInt64TypeObj, BigDecimal> tableColumnMaxValue = null;
	protected TableColumn<ICFBamUInt64TypeObj, ICFBamSchemaDefObj> tableColumnLookupDefSchema = null;

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


	public CFBamJavaFXUInt64TypeListPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamSchemaDefObj argContainer,
		ICFBamUInt64TypeObj argFocus,
		Collection<ICFBamUInt64TypeObj> argDataCollection,
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
		dataTable = new TableView<ICFBamUInt64TypeObj>();
		tableColumnId = new TableColumn<ICFBamUInt64TypeObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamUInt64TypeObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,Long>,TableCell<ICFBamUInt64TypeObj,Long>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,Long> call(
				TableColumn<ICFBamUInt64TypeObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamUInt64TypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<ICFBamUInt64TypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamUInt64TypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamUInt64TypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamUInt64TypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<ICFBamUInt64TypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<ICFBamUInt64TypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamUInt64TypeObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,Boolean>,TableCell<ICFBamUInt64TypeObj,Boolean>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,Boolean> call(
				TableColumn<ICFBamUInt64TypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<ICFBamUInt64TypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ICFBamUInt64TypeObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,Boolean>,TableCell<ICFBamUInt64TypeObj,Boolean>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,Boolean> call(
				TableColumn<ICFBamUInt64TypeObj,Boolean> arg)
			{
				return new CFBoolTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnDbName = new TableColumn<ICFBamUInt64TypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamUInt64TypeObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,String>,TableCell<ICFBamUInt64TypeObj,String>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,String> call(
				TableColumn<ICFBamUInt64TypeObj,String> arg)
			{
				return new CFStringTableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<ICFBamUInt64TypeObj,BigDecimal>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,BigDecimal>,ObservableValue<BigDecimal> >() {
			public ObservableValue<BigDecimal> call( CellDataFeatures<ICFBamUInt64TypeObj, BigDecimal> p ) {
				ICFBamUInt64DefObj obj = p.getValue();
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
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,BigDecimal>,TableCell<ICFBamUInt64TypeObj,BigDecimal>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,BigDecimal> call(
				TableColumn<ICFBamUInt64TypeObj,BigDecimal> arg)
			{
				return new CFUInt64TableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<ICFBamUInt64TypeObj,BigDecimal>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,BigDecimal>,ObservableValue<BigDecimal> >() {
			public ObservableValue<BigDecimal> call( CellDataFeatures<ICFBamUInt64TypeObj, BigDecimal> p ) {
				ICFBamUInt64DefObj obj = p.getValue();
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
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,BigDecimal>,TableCell<ICFBamUInt64TypeObj,BigDecimal>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,BigDecimal> call(
				TableColumn<ICFBamUInt64TypeObj,BigDecimal> arg)
			{
				return new CFUInt64TableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<ICFBamUInt64TypeObj,BigDecimal>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,BigDecimal>,ObservableValue<BigDecimal> >() {
			public ObservableValue<BigDecimal> call( CellDataFeatures<ICFBamUInt64TypeObj, BigDecimal> p ) {
				ICFBamUInt64DefObj obj = p.getValue();
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
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,BigDecimal>,TableCell<ICFBamUInt64TypeObj,BigDecimal>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,BigDecimal> call(
				TableColumn<ICFBamUInt64TypeObj,BigDecimal> arg)
			{
				return new CFUInt64TableCell<ICFBamUInt64TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<ICFBamUInt64TypeObj, ICFBamSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<ICFBamUInt64TypeObj,ICFBamSchemaDefObj>,ObservableValue<ICFBamSchemaDefObj> >() {
			public ObservableValue<ICFBamSchemaDefObj> call( CellDataFeatures<ICFBamUInt64TypeObj, ICFBamSchemaDefObj> p ) {
				ICFBamUInt64TypeObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<ICFBamUInt64TypeObj,ICFBamSchemaDefObj>,TableCell<ICFBamUInt64TypeObj,ICFBamSchemaDefObj>>() {
			@Override public TableCell<ICFBamUInt64TypeObj,ICFBamSchemaDefObj> call(
				TableColumn<ICFBamUInt64TypeObj,ICFBamSchemaDefObj> arg)
			{
				return new CFReferenceTableCell<ICFBamUInt64TypeObj,ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamUInt64TypeObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamUInt64TypeObj> observable,
					ICFBamUInt64TypeObj oldValue,
					ICFBamUInt64TypeObj newValue )
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
		if( observableListOfUInt64Type != null ) {
			dataTable.setItems( observableListOfUInt64Type );
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
		if( ( value == null ) || ( value instanceof ICFBamUInt64TypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamUInt64TypeObj" );
		}
		adjustListButtons();
	}

	public ICFBamUInt64TypeObj getJavaFXFocusAsUInt64Type() {
		return( (ICFBamUInt64TypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsUInt64Type( ICFBamUInt64TypeObj value ) {
		setJavaFXFocus( value );
	}

	public class UInt64TypeByQualNameComparator
	implements Comparator<ICFBamUInt64TypeObj>
	{
		public UInt64TypeByQualNameComparator() {
		}

		public int compare( ICFBamUInt64TypeObj lhs, ICFBamUInt64TypeObj rhs ) {
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

	protected UInt64TypeByQualNameComparator compareUInt64TypeByQualName = new UInt64TypeByQualNameComparator();

	public Collection<ICFBamUInt64TypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamUInt64TypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfUInt64Type = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamUInt64TypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfUInt64Type.add( iter.next() );
				}
				observableListOfUInt64Type.sort( compareUInt64TypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfUInt64Type );
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
			buttonAddUInt64Type = new CFButton();
			buttonAddUInt64Type.setMinWidth( 200 );
			buttonAddUInt64Type.setText( "Add UInt64Type" );
			buttonAddUInt64Type.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ICFBamSchemaObj schemaObj = (ICFBamSchemaObj)javafxSchema.getSchema();
						ICFBamUInt64TypeObj obj = (ICFBamUInt64TypeObj)schemaObj.getUInt64TypeTableObj().newInstance();
						ICFBamUInt64TypeEditObj edit = (ICFBamUInt64TypeEditObj)( obj.beginEdit() );
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
						CFBorderPane frame = javafxSchema.getUInt64TypeFactory().newAddForm( cfFormManager, obj, getViewEditClosedCallback(), true );
						ICFBamJavaFXUInt64TypePaneCommon jpanelCommon = (ICFBamJavaFXUInt64TypePaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( CFPane.PaneMode.Add );
						cfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						CFConsole.formException( S_FormName, ((CFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddUInt64Type );
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
						ICFBamUInt64TypeObj selectedInstance = getJavaFXFocusAsUInt64Type();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "U64T".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getUInt64TypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXUInt64TypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamUInt64TypeObj" );
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
						ICFBamUInt64TypeObj selectedInstance = getJavaFXFocusAsUInt64Type();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "U64T".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getUInt64TypeFactory().newViewEditForm( cfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ICFBamJavaFXUInt64TypePaneCommon)frame).setPaneMode( CFPane.PaneMode.Edit );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamUInt64TypeObj" );
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
						ICFBamUInt64TypeObj selectedInstance = getJavaFXFocusAsUInt64Type();
						if( selectedInstance != null ) {
							String classCode = selectedInstance.getClassCode();
							if( "U64T".equals( classCode ) ) {
								CFBorderPane frame = javafxSchema.getUInt64TypeFactory().newAskDeleteForm( cfFormManager, selectedInstance, getDeleteCallback() );
								((ICFBamJavaFXUInt64TypePaneCommon)frame).setPaneMode( CFPane.PaneMode.View );
								cfFormManager.pushForm( frame );
							}
							else {
								throw new CFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ICFBamUInt64TypeObj" );
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
		ICFBamUInt64TypeObj selectedObj = getJavaFXFocusAsUInt64Type();
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
		if( buttonAddUInt64Type != null ) {
			buttonAddUInt64Type.setDisable( ! allowAdds );
		}

	}
}
