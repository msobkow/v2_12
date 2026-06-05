// Description: Java 11 JavaFX Picker of Obj Pane implementation for SchemaDef.

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
 *	CFBamJavaFXSchemaDefPickerPane JavaFX Pick Obj Pane implementation
 *	for SchemaDef.
 */
public class CFBamJavaFXSchemaDefPickerPane
extends CFBorderPane
implements ICFBamJavaFXSchemaDefPaneList
{
	public static String S_FormName = "Choose SchemaDef";
	protected ICFBamJavaFXSchema javafxSchema = null;
	protected Collection<ICFBamSchemaDefObj> javafxDataCollection = null;
	protected ObservableList<ICFBamSchemaDefObj> observableListOfSchemaDef = null;
	protected TableColumn<ICFBamSchemaDefObj, Long> tableColumnId = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnName = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnDbName = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnShortName = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnLabel = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnShortDescription = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnDescription = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCopyrightPeriod = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCopyrightHolder = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnAuthorEMail = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnProjectURL = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnPublishURI = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJSchemaObjInterface = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJSchemaObjImplementation = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJDb2LUWSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJDb2LUWSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJDb2LUWSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJMSSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJMSSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJMSSqlSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJMySqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJMySqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJMySqlSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJOracleSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJOracleSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJOracleSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJPgSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJPgSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJPgSqlSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJRamSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJRamSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJRamSchemaObjImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgSchemaImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgSchemaFormatters = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgClientSchemaImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgClientSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRqstSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRqstSchemaImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRqstSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRqstSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRqstSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRspnSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRspnSchemaImport = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRspnSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRspnSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnJXMsgRspnSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppSchemaObjInterface = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppSchemaObjImplementation = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppDb2LUWSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppDb2LUWSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppDb2LUWSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppMSSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppMSSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppMSSqlSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppMySqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppMySqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppMySqlSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppOracleSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppOracleSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppOracleSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppPgSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppPgSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppPgSqlSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppRamSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppRamSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppRamSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgSchemaFormatters = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgClientSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgClientSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRqstSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRqstSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRqstSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRqstSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRqstSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRspnSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRspnSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRspnSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRspnSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCppXMsgRspnSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppSchemaObjInterface = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppSchemaObjImplementation = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppDb2LUWSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppDb2LUWSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppDb2LUWSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppMSSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppMSSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppMSSqlSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppMySqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppMySqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppMySqlSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppOracleSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppOracleSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppOracleSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppPgSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppPgSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppPgSqlSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppRamSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppRamSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppRamSchemaObjInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgSchemaFormatters = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgClientSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgClientSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRqstSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRqstSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRqstSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRqstSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRqstSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRspnSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRspnSchemaInclude = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRspnSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRspnSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnHppXMsgRspnSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsSchemaObjInterface = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsSchemaObjImplementation = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsDb2LUWSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsDb2LUWSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsDb2LUWSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsMSSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsMSSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsMSSqlSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsMySqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsMySqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsMySqlSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsOracleSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsOracleSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsOracleSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsPgSqlSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsPgSqlSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsPgSqlSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsRamSchemaObjMembers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsRamSchemaObjImpl = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsRamSchemaObjUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgSchemaUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgSchemaFormatters = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgClientSchemaUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgClientSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRqstSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRqstSchemaUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRqstSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRqstSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRqstSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRspnSchemaBody = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRspnSchemaUsing = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRspnSchemaWireParsers = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRspnSchemaXsdElementList = null;
	protected TableColumn<ICFBamSchemaDefObj, String> tableColumnCsXMsgRspnSchemaXsdSpec = null;
	protected TableColumn<ICFBamSchemaDefObj, ICFIntLicenseObj> tableColumnLookupDefaultLicense = null;
	protected TableView<ICFBamSchemaDefObj> dataTable = null;
	protected CFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected ICFFormManager cfFormManager = null;
	protected ICFBamJavaFXSchemaDefChosen invokeWhenChosen = null;
	protected ICFIntMinorVersionObj javafxContainer = null;
	protected CFButton buttonCancel = null;
	protected CFButton buttonChooseNone = null;
	protected CFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public CFBamJavaFXSchemaDefPickerPane( ICFFormManager formManager,
		ICFBamJavaFXSchema argSchema,
		ICFBamSchemaDefObj argFocus,
		ICFIntMinorVersionObj argContainer,
		Collection<ICFBamSchemaDefObj> argDataCollection,
		ICFBamJavaFXSchemaDefChosen whenChosen )
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
		dataTable = new TableView<ICFBamSchemaDefObj>();
		tableColumnId = new TableColumn<ICFBamSchemaDefObj,Long>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,Long>,ObservableValue<Long> >() {
			public ObservableValue<Long> call( CellDataFeatures<ICFBamSchemaDefObj, Long> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,Long>,TableCell<ICFBamSchemaDefObj,Long>>() {
			@Override public TableCell<ICFBamSchemaDefObj,Long> call(
				TableColumn<ICFBamSchemaDefObj,Long> arg)
			{
				return new CFInt64TableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<ICFBamSchemaDefObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDbName = new TableColumn<ICFBamSchemaDefObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnShortName = new TableColumn<ICFBamSchemaDefObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<ICFBamSchemaDefObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<ICFBamSchemaDefObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<ICFBamSchemaDefObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnCopyrightPeriod = new TableColumn<ICFBamSchemaDefObj,String>( "Copyright Period" );
		tableColumnCopyrightPeriod.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredCopyrightPeriod();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCopyrightPeriod.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCopyrightPeriod );
		tableColumnCopyrightHolder = new TableColumn<ICFBamSchemaDefObj,String>( "Copyright Holder" );
		tableColumnCopyrightHolder.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredCopyrightHolder();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCopyrightHolder.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCopyrightHolder );
		tableColumnAuthorEMail = new TableColumn<ICFBamSchemaDefObj,String>( "Author EMail" );
		tableColumnAuthorEMail.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredAuthorEMail();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnAuthorEMail.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnAuthorEMail );
		tableColumnProjectURL = new TableColumn<ICFBamSchemaDefObj,String>( "Project URL" );
		tableColumnProjectURL.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredProjectURL();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnProjectURL.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnProjectURL );
		tableColumnPublishURI = new TableColumn<ICFBamSchemaDefObj,String>( "Publish URI" );
		tableColumnPublishURI.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredPublishURI();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnPublishURI.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFStringTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPublishURI );
		tableColumnJSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JSchemaObjImport" );
		tableColumnJSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSchemaObjImport );
		tableColumnJSchemaObjInterface = new TableColumn<ICFBamSchemaDefObj,String>( "JSchemaObjInterface" );
		tableColumnJSchemaObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSchemaObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSchemaObjInterface.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSchemaObjInterface );
		tableColumnJSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JSchemaObjMembers" );
		tableColumnJSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSchemaObjMembers );
		tableColumnJSchemaObjImplementation = new TableColumn<ICFBamSchemaDefObj,String>( "JSchemaObjImplementation" );
		tableColumnJSchemaObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJSchemaObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJSchemaObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJSchemaObjImplementation );
		tableColumnJDb2LUWSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JDb2LUWSchemaObjMembers" );
		tableColumnJDb2LUWSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJDb2LUWSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJDb2LUWSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJDb2LUWSchemaObjMembers );
		tableColumnJDb2LUWSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "JDb2LUWSchemaObjImpl" );
		tableColumnJDb2LUWSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJDb2LUWSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJDb2LUWSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJDb2LUWSchemaObjImpl );
		tableColumnJDb2LUWSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JDb2LUWSchemaObjImport" );
		tableColumnJDb2LUWSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJDb2LUWSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJDb2LUWSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJDb2LUWSchemaObjImport );
		tableColumnJMSSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JMSSqlSchemaObjMembers" );
		tableColumnJMSSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMSSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMSSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMSSqlSchemaObjMembers );
		tableColumnJMSSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "JMSSqlSchemaObjImpl" );
		tableColumnJMSSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMSSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMSSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMSSqlSchemaObjImpl );
		tableColumnJMSSqlSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JMSSqlSchemaObjImport" );
		tableColumnJMSSqlSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMSSqlSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMSSqlSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMSSqlSchemaObjImport );
		tableColumnJMySqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JMySqlSchemaObjMembers" );
		tableColumnJMySqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMySqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMySqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMySqlSchemaObjMembers );
		tableColumnJMySqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "JMySqlSchemaObjImpl" );
		tableColumnJMySqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMySqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMySqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMySqlSchemaObjImpl );
		tableColumnJMySqlSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JMySqlSchemaObjImport" );
		tableColumnJMySqlSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJMySqlSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJMySqlSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJMySqlSchemaObjImport );
		tableColumnJOracleSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JOracleSchemaObjMembers" );
		tableColumnJOracleSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJOracleSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJOracleSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJOracleSchemaObjMembers );
		tableColumnJOracleSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "JOracleSchemaObjImpl" );
		tableColumnJOracleSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJOracleSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJOracleSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJOracleSchemaObjImpl );
		tableColumnJOracleSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JOracleSchemaObjImport" );
		tableColumnJOracleSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJOracleSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJOracleSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJOracleSchemaObjImport );
		tableColumnJPgSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JPgSqlSchemaObjMembers" );
		tableColumnJPgSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJPgSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJPgSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJPgSqlSchemaObjMembers );
		tableColumnJPgSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "JPgSqlSchemaObjImpl" );
		tableColumnJPgSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJPgSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJPgSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJPgSqlSchemaObjImpl );
		tableColumnJPgSqlSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JPgSqlSchemaObjImport" );
		tableColumnJPgSqlSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJPgSqlSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJPgSqlSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJPgSqlSchemaObjImport );
		tableColumnJRamSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "JRamSchemaObjMembers" );
		tableColumnJRamSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJRamSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJRamSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJRamSchemaObjMembers );
		tableColumnJRamSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "JRamSchemaObjImpl" );
		tableColumnJRamSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJRamSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJRamSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJRamSchemaObjImpl );
		tableColumnJRamSchemaObjImport = new TableColumn<ICFBamSchemaDefObj,String>( "JRamSchemaObjImport" );
		tableColumnJRamSchemaObjImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJRamSchemaObjImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJRamSchemaObjImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJRamSchemaObjImport );
		tableColumnJXMsgSchemaImport = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgSchemaImport" );
		tableColumnJXMsgSchemaImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgSchemaImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgSchemaImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgSchemaImport );
		tableColumnJXMsgSchemaFormatters = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgSchemaFormatters" );
		tableColumnJXMsgSchemaFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgSchemaFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgSchemaFormatters.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgSchemaFormatters );
		tableColumnJXMsgClientSchemaImport = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgClientSchemaImport" );
		tableColumnJXMsgClientSchemaImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgClientSchemaImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgClientSchemaImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgClientSchemaImport );
		tableColumnJXMsgClientSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgClientSchemaBody" );
		tableColumnJXMsgClientSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgClientSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgClientSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgClientSchemaBody );
		tableColumnJXMsgRqstSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRqstSchemaBody" );
		tableColumnJXMsgRqstSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstSchemaBody );
		tableColumnJXMsgRqstSchemaImport = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRqstSchemaImport" );
		tableColumnJXMsgRqstSchemaImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstSchemaImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstSchemaImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstSchemaImport );
		tableColumnJXMsgRqstSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRqstSchemaWireParsers" );
		tableColumnJXMsgRqstSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstSchemaWireParsers );
		tableColumnJXMsgRqstSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRqstSchemaXsdSpec" );
		tableColumnJXMsgRqstSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstSchemaXsdSpec );
		tableColumnJXMsgRqstSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRqstSchemaXsdElementList" );
		tableColumnJXMsgRqstSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRqstSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRqstSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRqstSchemaXsdElementList );
		tableColumnJXMsgRspnSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRspnSchemaBody" );
		tableColumnJXMsgRspnSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnSchemaBody );
		tableColumnJXMsgRspnSchemaImport = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRspnSchemaImport" );
		tableColumnJXMsgRspnSchemaImport.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnSchemaImport();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnSchemaImport.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnSchemaImport );
		tableColumnJXMsgRspnSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRspnSchemaWireParsers" );
		tableColumnJXMsgRspnSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnSchemaWireParsers );
		tableColumnJXMsgRspnSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRspnSchemaXsdElementList" );
		tableColumnJXMsgRspnSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnSchemaXsdElementList );
		tableColumnJXMsgRspnSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "JXMsgRspnSchemaXsdSpec" );
		tableColumnJXMsgRspnSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalJXMsgRspnSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnJXMsgRspnSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnJXMsgRspnSchemaXsdSpec );
		tableColumnCppSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppSchemaObjInclude" );
		tableColumnCppSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSchemaObjInclude );
		tableColumnCppSchemaObjInterface = new TableColumn<ICFBamSchemaDefObj,String>( "CppSchemaObjInterface" );
		tableColumnCppSchemaObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSchemaObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSchemaObjInterface.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSchemaObjInterface );
		tableColumnCppSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppSchemaObjMembers" );
		tableColumnCppSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSchemaObjMembers );
		tableColumnCppSchemaObjImplementation = new TableColumn<ICFBamSchemaDefObj,String>( "CppSchemaObjImplementation" );
		tableColumnCppSchemaObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppSchemaObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppSchemaObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppSchemaObjImplementation );
		tableColumnCppDb2LUWSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppDb2LUWSchemaObjMembers" );
		tableColumnCppDb2LUWSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppDb2LUWSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppDb2LUWSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppDb2LUWSchemaObjMembers );
		tableColumnCppDb2LUWSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CppDb2LUWSchemaObjImpl" );
		tableColumnCppDb2LUWSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppDb2LUWSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppDb2LUWSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppDb2LUWSchemaObjImpl );
		tableColumnCppDb2LUWSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppDb2LUWSchemaObjInclude" );
		tableColumnCppDb2LUWSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppDb2LUWSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppDb2LUWSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppDb2LUWSchemaObjInclude );
		tableColumnCppMSSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppMSSqlSchemaObjMembers" );
		tableColumnCppMSSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMSSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMSSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMSSqlSchemaObjMembers );
		tableColumnCppMSSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CppMSSqlSchemaObjImpl" );
		tableColumnCppMSSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMSSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMSSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMSSqlSchemaObjImpl );
		tableColumnCppMSSqlSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppMSSqlSchemaObjInclude" );
		tableColumnCppMSSqlSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMSSqlSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMSSqlSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMSSqlSchemaObjInclude );
		tableColumnCppMySqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppMySqlSchemaObjMembers" );
		tableColumnCppMySqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMySqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMySqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMySqlSchemaObjMembers );
		tableColumnCppMySqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CppMySqlSchemaObjImpl" );
		tableColumnCppMySqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMySqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMySqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMySqlSchemaObjImpl );
		tableColumnCppMySqlSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppMySqlSchemaObjInclude" );
		tableColumnCppMySqlSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppMySqlSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppMySqlSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppMySqlSchemaObjInclude );
		tableColumnCppOracleSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppOracleSchemaObjMembers" );
		tableColumnCppOracleSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppOracleSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppOracleSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppOracleSchemaObjMembers );
		tableColumnCppOracleSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CppOracleSchemaObjImpl" );
		tableColumnCppOracleSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppOracleSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppOracleSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppOracleSchemaObjImpl );
		tableColumnCppOracleSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppOracleSchemaObjInclude" );
		tableColumnCppOracleSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppOracleSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppOracleSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppOracleSchemaObjInclude );
		tableColumnCppPgSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppPgSqlSchemaObjMembers" );
		tableColumnCppPgSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppPgSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppPgSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppPgSqlSchemaObjMembers );
		tableColumnCppPgSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CppPgSqlSchemaObjImpl" );
		tableColumnCppPgSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppPgSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppPgSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppPgSqlSchemaObjImpl );
		tableColumnCppPgSqlSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppPgSqlSchemaObjInclude" );
		tableColumnCppPgSqlSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppPgSqlSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppPgSqlSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppPgSqlSchemaObjInclude );
		tableColumnCppRamSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CppRamSchemaObjMembers" );
		tableColumnCppRamSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppRamSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppRamSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppRamSchemaObjMembers );
		tableColumnCppRamSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CppRamSchemaObjImpl" );
		tableColumnCppRamSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppRamSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppRamSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppRamSchemaObjImpl );
		tableColumnCppRamSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppRamSchemaObjInclude" );
		tableColumnCppRamSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppRamSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppRamSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppRamSchemaObjInclude );
		tableColumnCppXMsgSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgSchemaInclude" );
		tableColumnCppXMsgSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgSchemaInclude );
		tableColumnCppXMsgSchemaFormatters = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgSchemaFormatters" );
		tableColumnCppXMsgSchemaFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgSchemaFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgSchemaFormatters.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgSchemaFormatters );
		tableColumnCppXMsgClientSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgClientSchemaInclude" );
		tableColumnCppXMsgClientSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgClientSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgClientSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgClientSchemaInclude );
		tableColumnCppXMsgClientSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgClientSchemaBody" );
		tableColumnCppXMsgClientSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgClientSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgClientSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgClientSchemaBody );
		tableColumnCppXMsgRqstSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRqstSchemaBody" );
		tableColumnCppXMsgRqstSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstSchemaBody );
		tableColumnCppXMsgRqstSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRqstSchemaInclude" );
		tableColumnCppXMsgRqstSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstSchemaInclude );
		tableColumnCppXMsgRqstSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRqstSchemaWireParsers" );
		tableColumnCppXMsgRqstSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstSchemaWireParsers );
		tableColumnCppXMsgRqstSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRqstSchemaXsdSpec" );
		tableColumnCppXMsgRqstSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstSchemaXsdSpec );
		tableColumnCppXMsgRqstSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRqstSchemaXsdElementList" );
		tableColumnCppXMsgRqstSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRqstSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRqstSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRqstSchemaXsdElementList );
		tableColumnCppXMsgRspnSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRspnSchemaBody" );
		tableColumnCppXMsgRspnSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnSchemaBody );
		tableColumnCppXMsgRspnSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRspnSchemaInclude" );
		tableColumnCppXMsgRspnSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnSchemaInclude );
		tableColumnCppXMsgRspnSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRspnSchemaWireParsers" );
		tableColumnCppXMsgRspnSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnSchemaWireParsers );
		tableColumnCppXMsgRspnSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRspnSchemaXsdElementList" );
		tableColumnCppXMsgRspnSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnSchemaXsdElementList );
		tableColumnCppXMsgRspnSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "CppXMsgRspnSchemaXsdSpec" );
		tableColumnCppXMsgRspnSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCppXMsgRspnSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCppXMsgRspnSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCppXMsgRspnSchemaXsdSpec );
		tableColumnHppSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppSchemaObjInclude" );
		tableColumnHppSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSchemaObjInclude );
		tableColumnHppSchemaObjInterface = new TableColumn<ICFBamSchemaDefObj,String>( "HppSchemaObjInterface" );
		tableColumnHppSchemaObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSchemaObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSchemaObjInterface.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSchemaObjInterface );
		tableColumnHppSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppSchemaObjMembers" );
		tableColumnHppSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSchemaObjMembers );
		tableColumnHppSchemaObjImplementation = new TableColumn<ICFBamSchemaDefObj,String>( "HppSchemaObjImplementation" );
		tableColumnHppSchemaObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppSchemaObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppSchemaObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppSchemaObjImplementation );
		tableColumnHppDb2LUWSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppDb2LUWSchemaObjMembers" );
		tableColumnHppDb2LUWSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppDb2LUWSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppDb2LUWSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppDb2LUWSchemaObjMembers );
		tableColumnHppDb2LUWSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "HppDb2LUWSchemaObjImpl" );
		tableColumnHppDb2LUWSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppDb2LUWSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppDb2LUWSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppDb2LUWSchemaObjImpl );
		tableColumnHppDb2LUWSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppDb2LUWSchemaObjInclude" );
		tableColumnHppDb2LUWSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppDb2LUWSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppDb2LUWSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppDb2LUWSchemaObjInclude );
		tableColumnHppMSSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppMSSqlSchemaObjMembers" );
		tableColumnHppMSSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMSSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMSSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMSSqlSchemaObjMembers );
		tableColumnHppMSSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "HppMSSqlSchemaObjImpl" );
		tableColumnHppMSSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMSSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMSSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMSSqlSchemaObjImpl );
		tableColumnHppMSSqlSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppMSSqlSchemaObjInclude" );
		tableColumnHppMSSqlSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMSSqlSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMSSqlSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMSSqlSchemaObjInclude );
		tableColumnHppMySqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppMySqlSchemaObjMembers" );
		tableColumnHppMySqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMySqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMySqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMySqlSchemaObjMembers );
		tableColumnHppMySqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "HppMySqlSchemaObjImpl" );
		tableColumnHppMySqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMySqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMySqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMySqlSchemaObjImpl );
		tableColumnHppMySqlSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppMySqlSchemaObjInclude" );
		tableColumnHppMySqlSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppMySqlSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppMySqlSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppMySqlSchemaObjInclude );
		tableColumnHppOracleSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppOracleSchemaObjMembers" );
		tableColumnHppOracleSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppOracleSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppOracleSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppOracleSchemaObjMembers );
		tableColumnHppOracleSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "HppOracleSchemaObjImpl" );
		tableColumnHppOracleSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppOracleSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppOracleSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppOracleSchemaObjImpl );
		tableColumnHppOracleSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppOracleSchemaObjInclude" );
		tableColumnHppOracleSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppOracleSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppOracleSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppOracleSchemaObjInclude );
		tableColumnHppPgSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppPgSqlSchemaObjMembers" );
		tableColumnHppPgSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppPgSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppPgSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppPgSqlSchemaObjMembers );
		tableColumnHppPgSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "HppPgSqlSchemaObjImpl" );
		tableColumnHppPgSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppPgSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppPgSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppPgSqlSchemaObjImpl );
		tableColumnHppPgSqlSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppPgSqlSchemaObjInclude" );
		tableColumnHppPgSqlSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppPgSqlSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppPgSqlSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppPgSqlSchemaObjInclude );
		tableColumnHppRamSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "HppRamSchemaObjMembers" );
		tableColumnHppRamSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppRamSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppRamSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppRamSchemaObjMembers );
		tableColumnHppRamSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "HppRamSchemaObjImpl" );
		tableColumnHppRamSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppRamSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppRamSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppRamSchemaObjImpl );
		tableColumnHppRamSchemaObjInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppRamSchemaObjInclude" );
		tableColumnHppRamSchemaObjInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppRamSchemaObjInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppRamSchemaObjInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppRamSchemaObjInclude );
		tableColumnHppXMsgSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgSchemaInclude" );
		tableColumnHppXMsgSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgSchemaInclude );
		tableColumnHppXMsgSchemaFormatters = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgSchemaFormatters" );
		tableColumnHppXMsgSchemaFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgSchemaFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgSchemaFormatters.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgSchemaFormatters );
		tableColumnHppXMsgClientSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgClientSchemaInclude" );
		tableColumnHppXMsgClientSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgClientSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgClientSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgClientSchemaInclude );
		tableColumnHppXMsgClientSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgClientSchemaBody" );
		tableColumnHppXMsgClientSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgClientSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgClientSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgClientSchemaBody );
		tableColumnHppXMsgRqstSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRqstSchemaBody" );
		tableColumnHppXMsgRqstSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstSchemaBody );
		tableColumnHppXMsgRqstSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRqstSchemaInclude" );
		tableColumnHppXMsgRqstSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstSchemaInclude );
		tableColumnHppXMsgRqstSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRqstSchemaWireParsers" );
		tableColumnHppXMsgRqstSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstSchemaWireParsers );
		tableColumnHppXMsgRqstSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRqstSchemaXsdSpec" );
		tableColumnHppXMsgRqstSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstSchemaXsdSpec );
		tableColumnHppXMsgRqstSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRqstSchemaXsdElementList" );
		tableColumnHppXMsgRqstSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRqstSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRqstSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRqstSchemaXsdElementList );
		tableColumnHppXMsgRspnSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRspnSchemaBody" );
		tableColumnHppXMsgRspnSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnSchemaBody );
		tableColumnHppXMsgRspnSchemaInclude = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRspnSchemaInclude" );
		tableColumnHppXMsgRspnSchemaInclude.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnSchemaInclude();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnSchemaInclude.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnSchemaInclude );
		tableColumnHppXMsgRspnSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRspnSchemaWireParsers" );
		tableColumnHppXMsgRspnSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnSchemaWireParsers );
		tableColumnHppXMsgRspnSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRspnSchemaXsdElementList" );
		tableColumnHppXMsgRspnSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnSchemaXsdElementList );
		tableColumnHppXMsgRspnSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "HppXMsgRspnSchemaXsdSpec" );
		tableColumnHppXMsgRspnSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalHppXMsgRspnSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnHppXMsgRspnSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHppXMsgRspnSchemaXsdSpec );
		tableColumnCsSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsSchemaObjUsing" );
		tableColumnCsSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSchemaObjUsing );
		tableColumnCsSchemaObjInterface = new TableColumn<ICFBamSchemaDefObj,String>( "CsSchemaObjInterface" );
		tableColumnCsSchemaObjInterface.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSchemaObjInterface();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSchemaObjInterface.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSchemaObjInterface );
		tableColumnCsSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsSchemaObjMembers" );
		tableColumnCsSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSchemaObjMembers );
		tableColumnCsSchemaObjImplementation = new TableColumn<ICFBamSchemaDefObj,String>( "CsSchemaObjImplementation" );
		tableColumnCsSchemaObjImplementation.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsSchemaObjImplementation();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsSchemaObjImplementation.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsSchemaObjImplementation );
		tableColumnCsDb2LUWSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsDb2LUWSchemaObjMembers" );
		tableColumnCsDb2LUWSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsDb2LUWSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsDb2LUWSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsDb2LUWSchemaObjMembers );
		tableColumnCsDb2LUWSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CsDb2LUWSchemaObjImpl" );
		tableColumnCsDb2LUWSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsDb2LUWSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsDb2LUWSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsDb2LUWSchemaObjImpl );
		tableColumnCsDb2LUWSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsDb2LUWSchemaObjUsing" );
		tableColumnCsDb2LUWSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsDb2LUWSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsDb2LUWSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsDb2LUWSchemaObjUsing );
		tableColumnCsMSSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsMSSqlSchemaObjMembers" );
		tableColumnCsMSSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMSSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMSSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMSSqlSchemaObjMembers );
		tableColumnCsMSSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CsMSSqlSchemaObjImpl" );
		tableColumnCsMSSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMSSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMSSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMSSqlSchemaObjImpl );
		tableColumnCsMSSqlSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsMSSqlSchemaObjUsing" );
		tableColumnCsMSSqlSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMSSqlSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMSSqlSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMSSqlSchemaObjUsing );
		tableColumnCsMySqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsMySqlSchemaObjMembers" );
		tableColumnCsMySqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMySqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMySqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMySqlSchemaObjMembers );
		tableColumnCsMySqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CsMySqlSchemaObjImpl" );
		tableColumnCsMySqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMySqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMySqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMySqlSchemaObjImpl );
		tableColumnCsMySqlSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsMySqlSchemaObjUsing" );
		tableColumnCsMySqlSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsMySqlSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsMySqlSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsMySqlSchemaObjUsing );
		tableColumnCsOracleSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsOracleSchemaObjMembers" );
		tableColumnCsOracleSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsOracleSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsOracleSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsOracleSchemaObjMembers );
		tableColumnCsOracleSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CsOracleSchemaObjImpl" );
		tableColumnCsOracleSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsOracleSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsOracleSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsOracleSchemaObjImpl );
		tableColumnCsOracleSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsOracleSchemaObjUsing" );
		tableColumnCsOracleSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsOracleSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsOracleSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsOracleSchemaObjUsing );
		tableColumnCsPgSqlSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsPgSqlSchemaObjMembers" );
		tableColumnCsPgSqlSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsPgSqlSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsPgSqlSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsPgSqlSchemaObjMembers );
		tableColumnCsPgSqlSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CsPgSqlSchemaObjImpl" );
		tableColumnCsPgSqlSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsPgSqlSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsPgSqlSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsPgSqlSchemaObjImpl );
		tableColumnCsPgSqlSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsPgSqlSchemaObjUsing" );
		tableColumnCsPgSqlSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsPgSqlSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsPgSqlSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsPgSqlSchemaObjUsing );
		tableColumnCsRamSchemaObjMembers = new TableColumn<ICFBamSchemaDefObj,String>( "CsRamSchemaObjMembers" );
		tableColumnCsRamSchemaObjMembers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsRamSchemaObjMembers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsRamSchemaObjMembers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsRamSchemaObjMembers );
		tableColumnCsRamSchemaObjImpl = new TableColumn<ICFBamSchemaDefObj,String>( "CsRamSchemaObjImpl" );
		tableColumnCsRamSchemaObjImpl.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsRamSchemaObjImpl();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsRamSchemaObjImpl.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsRamSchemaObjImpl );
		tableColumnCsRamSchemaObjUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsRamSchemaObjUsing" );
		tableColumnCsRamSchemaObjUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsRamSchemaObjUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsRamSchemaObjUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsRamSchemaObjUsing );
		tableColumnCsXMsgSchemaUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgSchemaUsing" );
		tableColumnCsXMsgSchemaUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgSchemaUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgSchemaUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgSchemaUsing );
		tableColumnCsXMsgSchemaFormatters = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgSchemaFormatters" );
		tableColumnCsXMsgSchemaFormatters.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgSchemaFormatters();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgSchemaFormatters.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgSchemaFormatters );
		tableColumnCsXMsgClientSchemaUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgClientSchemaUsing" );
		tableColumnCsXMsgClientSchemaUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgClientSchemaUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgClientSchemaUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgClientSchemaUsing );
		tableColumnCsXMsgClientSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgClientSchemaBody" );
		tableColumnCsXMsgClientSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgClientSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgClientSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgClientSchemaBody );
		tableColumnCsXMsgRqstSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRqstSchemaBody" );
		tableColumnCsXMsgRqstSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstSchemaBody );
		tableColumnCsXMsgRqstSchemaUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRqstSchemaUsing" );
		tableColumnCsXMsgRqstSchemaUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstSchemaUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstSchemaUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstSchemaUsing );
		tableColumnCsXMsgRqstSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRqstSchemaWireParsers" );
		tableColumnCsXMsgRqstSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstSchemaWireParsers );
		tableColumnCsXMsgRqstSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRqstSchemaXsdSpec" );
		tableColumnCsXMsgRqstSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstSchemaXsdSpec );
		tableColumnCsXMsgRqstSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRqstSchemaXsdElementList" );
		tableColumnCsXMsgRqstSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRqstSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRqstSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRqstSchemaXsdElementList );
		tableColumnCsXMsgRspnSchemaBody = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRspnSchemaBody" );
		tableColumnCsXMsgRspnSchemaBody.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnSchemaBody();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnSchemaBody.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnSchemaBody );
		tableColumnCsXMsgRspnSchemaUsing = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRspnSchemaUsing" );
		tableColumnCsXMsgRspnSchemaUsing.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnSchemaUsing();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnSchemaUsing.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnSchemaUsing );
		tableColumnCsXMsgRspnSchemaWireParsers = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRspnSchemaWireParsers" );
		tableColumnCsXMsgRspnSchemaWireParsers.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnSchemaWireParsers();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnSchemaWireParsers.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnSchemaWireParsers );
		tableColumnCsXMsgRspnSchemaXsdElementList = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRspnSchemaXsdElementList" );
		tableColumnCsXMsgRspnSchemaXsdElementList.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnSchemaXsdElementList();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnSchemaXsdElementList.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnSchemaXsdElementList );
		tableColumnCsXMsgRspnSchemaXsdSpec = new TableColumn<ICFBamSchemaDefObj,String>( "CsXMsgRspnSchemaXsdSpec" );
		tableColumnCsXMsgRspnSchemaXsdSpec.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ICFBamSchemaDefObj, String> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalCsXMsgRspnSchemaXsdSpec();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCsXMsgRspnSchemaXsdSpec.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,String>,TableCell<ICFBamSchemaDefObj,String>>() {
			@Override public TableCell<ICFBamSchemaDefObj,String> call(
				TableColumn<ICFBamSchemaDefObj,String> arg)
			{
				return new CFTextTableCell<ICFBamSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCsXMsgRspnSchemaXsdSpec );
		tableColumnLookupDefaultLicense = new TableColumn<ICFBamSchemaDefObj, ICFIntLicenseObj>( "Default License" );
		tableColumnLookupDefaultLicense.setCellValueFactory( new Callback<CellDataFeatures<ICFBamSchemaDefObj,ICFIntLicenseObj>,ObservableValue<ICFIntLicenseObj> >() {
			public ObservableValue<ICFIntLicenseObj> call( CellDataFeatures<ICFBamSchemaDefObj, ICFIntLicenseObj> p ) {
				ICFBamSchemaDefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ICFIntLicenseObj ref = obj.getOptionalLookupDefaultLicense();
					ReadOnlyObjectWrapper<ICFIntLicenseObj> observable = new ReadOnlyObjectWrapper<ICFIntLicenseObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupDefaultLicense.setCellFactory( new Callback<TableColumn<ICFBamSchemaDefObj,ICFIntLicenseObj>,TableCell<ICFBamSchemaDefObj,ICFIntLicenseObj>>() {
			@Override public TableCell<ICFBamSchemaDefObj,ICFIntLicenseObj> call(
				TableColumn<ICFBamSchemaDefObj,ICFIntLicenseObj> arg)
			{
				return new CFReferenceTableCell<ICFBamSchemaDefObj,ICFIntLicenseObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefaultLicense );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ICFBamSchemaDefObj>() {
				@Override public void changed( ObservableValue<? extends ICFBamSchemaDefObj> observable,
					ICFBamSchemaDefObj oldValue,
					ICFBamSchemaDefObj newValue )
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
					invokeWhenChosen.choseSchemaDef( null );
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
					ICFBamSchemaDefObj selectedInstance = getJavaFXFocusAsSchemaDef();
					invokeWhenChosen.choseSchemaDef( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ICFBamSchemaDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ICFBamSchemaDefObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ICFBamSchemaDefObj getJavaFXFocusAsSchemaDef() {
		return( (ICFBamSchemaDefObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSchemaDef( ICFBamSchemaDefObj value ) {
		setJavaFXFocus( value );
	}

	public class SchemaDefByQualNameComparator
	implements Comparator<ICFBamSchemaDefObj>
	{
		public SchemaDefByQualNameComparator() {
		}

		public int compare( ICFBamSchemaDefObj lhs, ICFBamSchemaDefObj rhs ) {
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

	protected SchemaDefByQualNameComparator compareSchemaDefByQualName = new SchemaDefByQualNameComparator();

	public Collection<ICFBamSchemaDefObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ICFBamSchemaDefObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfSchemaDef = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ICFBamSchemaDefObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfSchemaDef.add( iter.next() );
				}
				observableListOfSchemaDef.sort( compareSchemaDefByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfSchemaDef );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ICFIntMinorVersionObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ICFIntMinorVersionObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ICFBamSchemaDefObj selectedObj = getJavaFXFocusAsSchemaDef();
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

