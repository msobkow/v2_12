
// Description: Java 11 MssCF CFEngine for CFBam

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

package org.msscf.msscf.cfbam.CFBamMssCF;

import java.sql.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfcore.MssCF.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfbam.CFBam.*;
import org.msscf.msscf.cfbam.CFBamObj.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfcore.CFGenKbObj.*;

public abstract class CFBamMssCFEngine
	extends MssCFEngine
{
	private static final long serialVersionUID = 1L;
	public static final String ITEMNAME_TOP = "top";
	protected ICFBamSchemaObj cFBamSchema = null;

	public CFBamMssCFEngine() {
		super();
		setTargetRuleName( ITEMNAME_TOP );
	}

	public abstract String fixGenDefName( String rawName );

	public ICFBamSchemaObj getCFBamSchema() {
		return( cFBamSchema );
	}

	public void setCFBamSchema( ICFBamSchemaObj value ) {
		cFBamSchema = value;
	}

	public void init( String generatingBuild,
		ICFGenKbSchemaObj argCFGenKbSchema,
		ICFGenKbTenantObj argTenant,
		ICFBamSchemaObj argCFBamSchema,
		String strRootGenDir )
	{
		setCFBamSchema( argCFBamSchema );
		init( generatingBuild, argCFGenKbSchema, argTenant, strRootGenDir );
	}

	public void init( String generatingBuild,
		ICFGenKbSchemaObj argCFGenKbSchema,
		ICFGenKbTenantObj argTenant,
		String strRootGenDir )
	{
		super.init( generatingBuild, argCFGenKbSchema, argTenant, strRootGenDir );
		setGenContext( getGenContextFactory().newGenContext( generatingBuild,
			this,
			strRootGenDir,
			"any",
			"Object",
			"Object",
			getTargetRuleName() ) );
	}

	public ICFGenKbGenFileObj defineFile(
		String	definedNear,
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody,
		String	generateOnce,
		String	sourceBundle,
		String	moduleName,
		String	basePackageName,
		String	subPackageName,
		String	expansionClassName,
		String	expansionKeyName,
		String	expansionFileName )
	{
		return(
			super.defineFile( definedNear,
				toolsetName,
				fixGenDefName(scopeDefClassName),
				fixGenDefName(genDefClassName),
				itemName,
				expansionBody,
				generateOnce,
				sourceBundle,
				moduleName,
				basePackageName,
				subPackageName,
				expansionClassName,
				expansionKeyName,
				expansionFileName) );
	}

	public ICFGenKbGenRuleObj defineRule(
		String	definedNear,
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody )
	{
		return(
			super.defineRule( definedNear,
				toolsetName,
				fixGenDefName(scopeDefClassName),
				fixGenDefName(genDefClassName),
				itemName,
				expansionBody ) );
	}

	public ICFGenKbGenTruncObj defineTrunc(
		String	definedNear,
		String	toolsetName,
		String	scopeDefClassName,
		String	genDefClassName,
		String	itemName,
		String	expansionBody,
		int		truncAt  )
	{
		return(
			super.defineTrunc( definedNear,
				toolsetName,
				fixGenDefName(scopeDefClassName),
				fixGenDefName(genDefClassName),
				itemName,
				expansionBody,
				truncAt) );
	}

	public void bootstrapDefClasses() {
		ICFGenKbDefClassObj defClassObject = bootstrapDefClass( "Object", null );
		ICFGenKbDefClassObj defClassChain = bootstrapDefClass( "Chain", defClassObject );
		ICFGenKbDefClassObj defClassCluster = bootstrapDefClass( "Cluster", defClassObject );
		ICFGenKbDefClassObj defClassEnumTag = bootstrapDefClass( "EnumTag", defClassObject );
		ICFGenKbDefClassObj defClassHostNode = bootstrapDefClass( "HostNode", defClassObject );
		ICFGenKbDefClassObj defClassISOCcy = bootstrapDefClass( "ISOCcy", defClassObject );
		ICFGenKbDefClassObj defClassISOCtry = bootstrapDefClass( "ISOCtry", defClassObject );
		ICFGenKbDefClassObj defClassISOCtryCcy = bootstrapDefClass( "ISOCtryCcy", defClassObject );
		ICFGenKbDefClassObj defClassISOCtryLang = bootstrapDefClass( "ISOCtryLang", defClassObject );
		ICFGenKbDefClassObj defClassISOLang = bootstrapDefClass( "ISOLang", defClassObject );
		ICFGenKbDefClassObj defClassISOTZone = bootstrapDefClass( "ISOTZone", defClassObject );
		ICFGenKbDefClassObj defClassIndexCol = bootstrapDefClass( "IndexCol", defClassObject );
		ICFGenKbDefClassObj defClassLicense = bootstrapDefClass( "License", defClassObject );
		ICFGenKbDefClassObj defClassMajorVersion = bootstrapDefClass( "MajorVersion", defClassObject );
		ICFGenKbDefClassObj defClassMimeType = bootstrapDefClass( "MimeType", defClassObject );
		ICFGenKbDefClassObj defClassMinorVersion = bootstrapDefClass( "MinorVersion", defClassObject );
		ICFGenKbDefClassObj defClassParam = bootstrapDefClass( "Param", defClassObject );
		ICFGenKbDefClassObj defClassRelationCol = bootstrapDefClass( "RelationCol", defClassObject );
		ICFGenKbDefClassObj defClassScope = bootstrapDefClass( "Scope", defClassObject );
		ICFGenKbDefClassObj defClassSchemaDef = bootstrapDefClass( "SchemaDef", defClassScope );
		ICFGenKbDefClassObj defClassSchemaRef = bootstrapDefClass( "SchemaRef", defClassScope );
		ICFGenKbDefClassObj defClassServerMethod = bootstrapDefClass( "ServerMethod", defClassScope );
		ICFGenKbDefClassObj defClassServerObjFunc = bootstrapDefClass( "ServerObjFunc", defClassServerMethod );
		ICFGenKbDefClassObj defClassServerProc = bootstrapDefClass( "ServerProc", defClassServerMethod );
		ICFGenKbDefClassObj defClassServerListFunc = bootstrapDefClass( "ServerListFunc", defClassServerMethod );
		ICFGenKbDefClassObj defClassTable = bootstrapDefClass( "Table", defClassScope );
		ICFGenKbDefClassObj defClassClearDep = bootstrapDefClass( "ClearDep", defClassScope );
		ICFGenKbDefClassObj defClassClearSubDep1 = bootstrapDefClass( "ClearSubDep1", defClassClearDep );
		ICFGenKbDefClassObj defClassClearSubDep2 = bootstrapDefClass( "ClearSubDep2", defClassClearDep );
		ICFGenKbDefClassObj defClassClearSubDep3 = bootstrapDefClass( "ClearSubDep3", defClassClearDep );
		ICFGenKbDefClassObj defClassClearTopDep = bootstrapDefClass( "ClearTopDep", defClassClearDep );
		ICFGenKbDefClassObj defClassDelDep = bootstrapDefClass( "DelDep", defClassScope );
		ICFGenKbDefClassObj defClassDelSubDep1 = bootstrapDefClass( "DelSubDep1", defClassDelDep );
		ICFGenKbDefClassObj defClassDelSubDep2 = bootstrapDefClass( "DelSubDep2", defClassDelDep );
		ICFGenKbDefClassObj defClassDelSubDep3 = bootstrapDefClass( "DelSubDep3", defClassDelDep );
		ICFGenKbDefClassObj defClassDelTopDep = bootstrapDefClass( "DelTopDep", defClassDelDep );
		ICFGenKbDefClassObj defClassIndex = bootstrapDefClass( "Index", defClassScope );
		ICFGenKbDefClassObj defClassPopDep = bootstrapDefClass( "PopDep", defClassScope );
		ICFGenKbDefClassObj defClassPopSubDep1 = bootstrapDefClass( "PopSubDep1", defClassPopDep );
		ICFGenKbDefClassObj defClassPopSubDep2 = bootstrapDefClass( "PopSubDep2", defClassPopDep );
		ICFGenKbDefClassObj defClassPopSubDep3 = bootstrapDefClass( "PopSubDep3", defClassPopDep );
		ICFGenKbDefClassObj defClassPopTopDep = bootstrapDefClass( "PopTopDep", defClassPopDep );
		ICFGenKbDefClassObj defClassRelation = bootstrapDefClass( "Relation", defClassScope );
		ICFGenKbDefClassObj defClassSecApp = bootstrapDefClass( "SecApp", defClassObject );
		ICFGenKbDefClassObj defClassSecDevice = bootstrapDefClass( "SecDevice", defClassObject );
		ICFGenKbDefClassObj defClassSecForm = bootstrapDefClass( "SecForm", defClassObject );
		ICFGenKbDefClassObj defClassSecGroup = bootstrapDefClass( "SecGroup", defClassObject );
		ICFGenKbDefClassObj defClassSecGroupForm = bootstrapDefClass( "SecGroupForm", defClassObject );
		ICFGenKbDefClassObj defClassSecGrpInc = bootstrapDefClass( "SecGrpInc", defClassObject );
		ICFGenKbDefClassObj defClassSecGrpMemb = bootstrapDefClass( "SecGrpMemb", defClassObject );
		ICFGenKbDefClassObj defClassSecSession = bootstrapDefClass( "SecSession", defClassObject );
		ICFGenKbDefClassObj defClassSecUser = bootstrapDefClass( "SecUser", defClassObject );
		ICFGenKbDefClassObj defClassService = bootstrapDefClass( "Service", defClassObject );
		ICFGenKbDefClassObj defClassServiceType = bootstrapDefClass( "ServiceType", defClassObject );
		ICFGenKbDefClassObj defClassSubProject = bootstrapDefClass( "SubProject", defClassObject );
		ICFGenKbDefClassObj defClassSysCluster = bootstrapDefClass( "SysCluster", defClassObject );
		ICFGenKbDefClassObj defClassTSecGroup = bootstrapDefClass( "TSecGroup", defClassObject );
		ICFGenKbDefClassObj defClassTSecGrpInc = bootstrapDefClass( "TSecGrpInc", defClassObject );
		ICFGenKbDefClassObj defClassTSecGrpMemb = bootstrapDefClass( "TSecGrpMemb", defClassObject );
		ICFGenKbDefClassObj defClassTenant = bootstrapDefClass( "Tenant", defClassObject );
		ICFGenKbDefClassObj defClassTld = bootstrapDefClass( "Tld", defClassObject );
		ICFGenKbDefClassObj defClassTopDomain = bootstrapDefClass( "TopDomain", defClassObject );
		ICFGenKbDefClassObj defClassTopProject = bootstrapDefClass( "TopProject", defClassObject );
		ICFGenKbDefClassObj defClassURLProtocol = bootstrapDefClass( "URLProtocol", defClassObject );
		ICFGenKbDefClassObj defClassValue = bootstrapDefClass( "Value", defClassObject );
		ICFGenKbDefClassObj defClassAtom = bootstrapDefClass( "Atom", defClassValue );
		ICFGenKbDefClassObj defClassBlobDef = bootstrapDefClass( "BlobDef", defClassAtom );
		ICFGenKbDefClassObj defClassBlobType = bootstrapDefClass( "BlobType", defClassBlobDef );
		ICFGenKbDefClassObj defClassBlobCol = bootstrapDefClass( "BlobCol", defClassBlobDef );
		ICFGenKbDefClassObj defClassBoolDef = bootstrapDefClass( "BoolDef", defClassAtom );
		ICFGenKbDefClassObj defClassBoolType = bootstrapDefClass( "BoolType", defClassBoolDef );
		ICFGenKbDefClassObj defClassBoolCol = bootstrapDefClass( "BoolCol", defClassBoolDef );
		ICFGenKbDefClassObj defClassDateDef = bootstrapDefClass( "DateDef", defClassAtom );
		ICFGenKbDefClassObj defClassDateType = bootstrapDefClass( "DateType", defClassDateDef );
		ICFGenKbDefClassObj defClassDateCol = bootstrapDefClass( "DateCol", defClassDateDef );
		ICFGenKbDefClassObj defClassDoubleDef = bootstrapDefClass( "DoubleDef", defClassAtom );
		ICFGenKbDefClassObj defClassDoubleType = bootstrapDefClass( "DoubleType", defClassDoubleDef );
		ICFGenKbDefClassObj defClassDoubleCol = bootstrapDefClass( "DoubleCol", defClassDoubleDef );
		ICFGenKbDefClassObj defClassFloatDef = bootstrapDefClass( "FloatDef", defClassAtom );
		ICFGenKbDefClassObj defClassFloatType = bootstrapDefClass( "FloatType", defClassFloatDef );
		ICFGenKbDefClassObj defClassFloatCol = bootstrapDefClass( "FloatCol", defClassFloatDef );
		ICFGenKbDefClassObj defClassInt16Def = bootstrapDefClass( "Int16Def", defClassAtom );
		ICFGenKbDefClassObj defClassInt16Type = bootstrapDefClass( "Int16Type", defClassInt16Def );
		ICFGenKbDefClassObj defClassId16Gen = bootstrapDefClass( "Id16Gen", defClassInt16Type );
		ICFGenKbDefClassObj defClassEnumDef = bootstrapDefClass( "EnumDef", defClassInt16Def );
		ICFGenKbDefClassObj defClassEnumType = bootstrapDefClass( "EnumType", defClassEnumDef );
		ICFGenKbDefClassObj defClassInt16Col = bootstrapDefClass( "Int16Col", defClassInt16Def );
		ICFGenKbDefClassObj defClassInt32Def = bootstrapDefClass( "Int32Def", defClassAtom );
		ICFGenKbDefClassObj defClassInt32Type = bootstrapDefClass( "Int32Type", defClassInt32Def );
		ICFGenKbDefClassObj defClassId32Gen = bootstrapDefClass( "Id32Gen", defClassInt32Type );
		ICFGenKbDefClassObj defClassInt32Col = bootstrapDefClass( "Int32Col", defClassInt32Def );
		ICFGenKbDefClassObj defClassInt64Def = bootstrapDefClass( "Int64Def", defClassAtom );
		ICFGenKbDefClassObj defClassInt64Type = bootstrapDefClass( "Int64Type", defClassInt64Def );
		ICFGenKbDefClassObj defClassId64Gen = bootstrapDefClass( "Id64Gen", defClassInt64Type );
		ICFGenKbDefClassObj defClassInt64Col = bootstrapDefClass( "Int64Col", defClassInt64Def );
		ICFGenKbDefClassObj defClassNmTokenDef = bootstrapDefClass( "NmTokenDef", defClassAtom );
		ICFGenKbDefClassObj defClassNmTokenType = bootstrapDefClass( "NmTokenType", defClassNmTokenDef );
		ICFGenKbDefClassObj defClassNmTokenCol = bootstrapDefClass( "NmTokenCol", defClassNmTokenDef );
		ICFGenKbDefClassObj defClassNmTokensDef = bootstrapDefClass( "NmTokensDef", defClassAtom );
		ICFGenKbDefClassObj defClassNmTokensType = bootstrapDefClass( "NmTokensType", defClassNmTokensDef );
		ICFGenKbDefClassObj defClassNmTokensCol = bootstrapDefClass( "NmTokensCol", defClassNmTokensDef );
		ICFGenKbDefClassObj defClassNumberDef = bootstrapDefClass( "NumberDef", defClassAtom );
		ICFGenKbDefClassObj defClassNumberType = bootstrapDefClass( "NumberType", defClassNumberDef );
		ICFGenKbDefClassObj defClassNumberCol = bootstrapDefClass( "NumberCol", defClassNumberDef );
		ICFGenKbDefClassObj defClassStringDef = bootstrapDefClass( "StringDef", defClassAtom );
		ICFGenKbDefClassObj defClassStringType = bootstrapDefClass( "StringType", defClassStringDef );
		ICFGenKbDefClassObj defClassStringCol = bootstrapDefClass( "StringCol", defClassStringDef );
		ICFGenKbDefClassObj defClassTZDateDef = bootstrapDefClass( "TZDateDef", defClassAtom );
		ICFGenKbDefClassObj defClassTZDateType = bootstrapDefClass( "TZDateType", defClassTZDateDef );
		ICFGenKbDefClassObj defClassTZDateCol = bootstrapDefClass( "TZDateCol", defClassTZDateDef );
		ICFGenKbDefClassObj defClassTZTimeDef = bootstrapDefClass( "TZTimeDef", defClassAtom );
		ICFGenKbDefClassObj defClassTZTimeType = bootstrapDefClass( "TZTimeType", defClassTZTimeDef );
		ICFGenKbDefClassObj defClassTZTimeCol = bootstrapDefClass( "TZTimeCol", defClassTZTimeDef );
		ICFGenKbDefClassObj defClassTZTimestampDef = bootstrapDefClass( "TZTimestampDef", defClassAtom );
		ICFGenKbDefClassObj defClassTZTimestampType = bootstrapDefClass( "TZTimestampType", defClassTZTimestampDef );
		ICFGenKbDefClassObj defClassTZTimestampCol = bootstrapDefClass( "TZTimestampCol", defClassTZTimestampDef );
		ICFGenKbDefClassObj defClassTextDef = bootstrapDefClass( "TextDef", defClassAtom );
		ICFGenKbDefClassObj defClassTextType = bootstrapDefClass( "TextType", defClassTextDef );
		ICFGenKbDefClassObj defClassTextCol = bootstrapDefClass( "TextCol", defClassTextDef );
		ICFGenKbDefClassObj defClassTimeDef = bootstrapDefClass( "TimeDef", defClassAtom );
		ICFGenKbDefClassObj defClassTimeType = bootstrapDefClass( "TimeType", defClassTimeDef );
		ICFGenKbDefClassObj defClassTimeCol = bootstrapDefClass( "TimeCol", defClassTimeDef );
		ICFGenKbDefClassObj defClassTimestampDef = bootstrapDefClass( "TimestampDef", defClassAtom );
		ICFGenKbDefClassObj defClassTimestampType = bootstrapDefClass( "TimestampType", defClassTimestampDef );
		ICFGenKbDefClassObj defClassTimestampCol = bootstrapDefClass( "TimestampCol", defClassTimestampDef );
		ICFGenKbDefClassObj defClassTokenDef = bootstrapDefClass( "TokenDef", defClassAtom );
		ICFGenKbDefClassObj defClassTokenType = bootstrapDefClass( "TokenType", defClassTokenDef );
		ICFGenKbDefClassObj defClassTokenCol = bootstrapDefClass( "TokenCol", defClassTokenDef );
		ICFGenKbDefClassObj defClassUInt16Def = bootstrapDefClass( "UInt16Def", defClassAtom );
		ICFGenKbDefClassObj defClassUInt16Type = bootstrapDefClass( "UInt16Type", defClassUInt16Def );
		ICFGenKbDefClassObj defClassUInt16Col = bootstrapDefClass( "UInt16Col", defClassUInt16Def );
		ICFGenKbDefClassObj defClassUInt32Def = bootstrapDefClass( "UInt32Def", defClassAtom );
		ICFGenKbDefClassObj defClassUInt32Type = bootstrapDefClass( "UInt32Type", defClassUInt32Def );
		ICFGenKbDefClassObj defClassUInt32Col = bootstrapDefClass( "UInt32Col", defClassUInt32Def );
		ICFGenKbDefClassObj defClassUInt64Def = bootstrapDefClass( "UInt64Def", defClassAtom );
		ICFGenKbDefClassObj defClassUInt64Type = bootstrapDefClass( "UInt64Type", defClassUInt64Def );
		ICFGenKbDefClassObj defClassUInt64Col = bootstrapDefClass( "UInt64Col", defClassUInt64Def );
		ICFGenKbDefClassObj defClassUuidDef = bootstrapDefClass( "UuidDef", defClassAtom );
		ICFGenKbDefClassObj defClassUuidType = bootstrapDefClass( "UuidType", defClassUuidDef );
		ICFGenKbDefClassObj defClassUuidGen = bootstrapDefClass( "UuidGen", defClassUuidType );
		ICFGenKbDefClassObj defClassUuidCol = bootstrapDefClass( "UuidCol", defClassUuidDef );
		ICFGenKbDefClassObj defClassTableCol = bootstrapDefClass( "TableCol", defClassValue );
	}

	public void bootstrapBindings() {
		ICFGenKbGenBindObj bind = null;
		ICFGenKbGenBindEditObj editBind = null;
        ICFGenKbRuleCartObj ruleCart = this.getInternalRuleCart();
        ICFGenKbRuleTypeObj ruleTypeBind = this.getRuleTypeTableObj().readRuleTypeByNameIdx("Bind");

		bind = new CFBamMssCFBindAtomDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasAtomDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBlobColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBlobDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBlobDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasBlobDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBlobTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBoolColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBoolDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasBoolDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBoolDefFalseString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasBoolDefFalseString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBoolDefTrueString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasBoolDefTrueString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBoolDefNullString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasBoolDefNullString( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindBoolTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainPrevRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainPrevRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainNextRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindChainNextRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasChainDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearDepRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearDepDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep1ClearTopDepTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep1ClearTopDepId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep1Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep2ClearSubDep1TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep2ClearSubDep1Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep2Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep3ClearSubDep2TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep3ClearSubDep2Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearSubDep3Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepTableTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearTopDepPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearTopDepPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearTopDepNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClearTopDepNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearTopDepNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearTopDepPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasClearTopDepNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClusterFullDomName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindClusterDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDateColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDateDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDateDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDateTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelDepRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelDepRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelDepDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep1DelTopDepTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep1DelTopDepId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep1Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep2DelSubDep1TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep2DelSubDep1Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep2Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep3DelSubDep2TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep3DelSubDep2Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelSubDep3Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepTableTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelTopDepPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelTopDepPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelTopDepNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDelTopDepNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelTopDepNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelTopDepPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDelTopDepNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDoubleColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDoubleDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDoubleDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDoubleDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDoubleDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDoubleDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasDoubleDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindDoubleTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagEnumId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagEnumCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagEnumCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTagNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasEnumTagNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindEnumTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindFloatColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindFloatDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasFloatDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindFloatDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasFloatDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindFloatDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasFloatDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindFloatTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHostNodeClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHostNodeHostNodeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHostNodeDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHostNodeHostName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCcyISOCcyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCcyISOCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCcyName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCcyUnitSymbol( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasISOCcyUnitSymbol( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCcyPrecis( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryISOCtryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryISOCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryCcyISOCtryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryCcyISOCcyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryLangISOCtryId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOCtryLangISOLangId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOLangISOLangId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOLangISO6392Code( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOLangISO6391Code( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasISOLangISO6391Code( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOLangEnglishName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneISOTZoneId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneIso8601( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneTZName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneTZHourOffset( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneTZMinOffset( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindISOTZoneVisible( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId16GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId16GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId16GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId16GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId16GenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId16GenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId16GenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId32GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId32GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId32GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId32GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId32GenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId32GenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId32GenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId64GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId64GenDispenserTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId64GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId64GenDispenserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId64GenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindId64GenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasId64GenDispenser( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexIsUnique( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexIsDbMapped( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColColumnId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColIsAscending( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindIndexColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasIndexColNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt16ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt16TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt32ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt32TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt64ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindInt64TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseTopDomainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasLicenseDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseEmbeddedText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasLicenseEmbeddedText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindLicenseFullText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasLicenseFullText( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMajorVersionTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMajorVersionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMajorVersionSubProjectId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMajorVersionName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMajorVersionDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasMajorVersionDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMimeTypeMimeTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMimeTypeName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMimeTypeFileTypes( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasMimeTypeFileTypes( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMinorVersionTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMinorVersionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMinorVersionMajorVersionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMinorVersionName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindMinorVersionDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasMinorVersionDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokenColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokenDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasNmTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokenTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokensColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokensDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokensDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasNmTokensDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNmTokensTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberDefDigits( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberDefPrecis( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasNumberDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasNumberDefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasNumberDefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindNumberTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamServerMethodId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamIsNullable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamTypeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamTypeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindParamNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasParamNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasPopDepDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasPopDepDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopDepRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopDepRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasPopDepDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep1PopTopDepTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep1PopTopDepId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep1Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep2PopSubDep1TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep2PopSubDep1Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep2Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep3PopSubDep2TenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep3PopSubDep2Id( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopSubDep3Name( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopTopDepContRelationTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopTopDepContRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindPopTopDepName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationRelationType( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationFromIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationToTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationToIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationIsRequired( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationAllowAddendum( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationIsXsdContainer( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationIsLateResolver( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationNarrowedTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationNarrowedTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationNarrowedId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationNarrowedId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationNarrowed( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColRelationId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColFromColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColToColId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindRelationColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasRelationColNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefMinorVersionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefDefaultLicenseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefDefaultLicenseTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefDefaultLicenseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefDefaultLicenseId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCopyrightPeriod( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCopyrightHolder( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefAuthorEMail( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefProjectURL( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefPublishURI( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJDb2LUWSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJDb2LUWSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJMSSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJMSSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJMySqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJMySqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJOracleSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJOracleSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJPgSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJPgSqlSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJRamSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJRamSchemaObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgClientSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgClientSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefJXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefJXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppDb2LUWSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppDb2LUWSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppMSSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppMSSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppMySqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppMySqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppOracleSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppOracleSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppPgSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppPgSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppRamSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppRamSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgClientSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgClientSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRqstSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRqstSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRspnSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRspnSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCppXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCppXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppDb2LUWSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppDb2LUWSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppMSSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppMSSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppMySqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppMySqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppOracleSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppOracleSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppPgSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppPgSqlSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppRamSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppRamSchemaObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgClientSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgClientSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRqstSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRqstSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRspnSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRspnSchemaInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefHppXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefHppXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsSchemaObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsSchemaObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsDb2LUWSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsDb2LUWSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsDb2LUWSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsDb2LUWSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsMSSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsMSSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsMSSqlSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsMSSqlSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsMySqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsMySqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsMySqlSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsMySqlSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsOracleSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsOracleSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsOracleSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsOracleSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsPgSqlSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsPgSqlSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsPgSqlSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsPgSqlSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsRamSchemaObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsRamSchemaObjImpl( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsRamSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsRamSchemaObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgSchemaFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgClientSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgClientSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgClientSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRqstSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRqstSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRqstSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRqstSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRqstSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRqstSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRspnSchemaBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRspnSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRspnSchemaUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRspnSchemaWireParsers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRspnSchemaXsdElementList( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaDefCsXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefCsXMsgRspnSchemaXsdSpec( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaDefDefaultLicense( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefRefModelName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefIncludeRoot( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefRefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefRefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefRefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefRefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefPrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefPrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSchemaRefNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefRefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefPrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSchemaRefNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindScopeTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecAppClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecAppSecAppId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecAppJEEMountName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecDeviceSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecDeviceDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecDevicePubKey( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecDevicePubKey( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecFormClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecFormSecFormId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecFormSecAppId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecFormJEEServletMapName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupIsVisible( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupFormClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupFormSecGroupFormId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupFormSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupFormSecAppId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGroupFormSecFormId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpIncClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpIncSecGrpIncId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpIncSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpIncIncludeGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpMembClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpMembSecGrpMembId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpMembSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecGrpMembSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecSessionSecSessionId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecSessionSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecSessionSecDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecSessionSecDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecSessionStart( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecSessionFinish( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecSessionFinish( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecSessionSecProxyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecSessionSecProxyId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserLoginId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserEMailAddress( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserEMailConfirmUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecUserEMailConfirmUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserDfltDevUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecUserDfltDevUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserDfltDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecUserDfltDevName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserPasswordHash( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSecUserPasswordResetUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecUserPasswordResetUuid( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSecUserDefDev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerListFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerListFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerListFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerListFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerListFuncRetTable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodSuffix( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodIsInstanceMethod( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodIsClientMethod( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodJMethodBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodCppMethodBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerMethodCsMethodBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerMethodDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerObjFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerObjFuncRetTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerObjFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerObjFuncRetTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerObjFuncRetTable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServerProcDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServerProcDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceServiceId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceHostNodeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceServiceTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceHostPort( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServiceHost( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasServiceServiceType( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceTypeServiceTypeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindServiceTypeDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindStringColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindStringDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindStringDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasStringDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindStringTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSubProjectTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSubProjectId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSubProjectTopProjectId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSubProjectName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSubProjectDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasSubProjectDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSysClusterSingletonId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindSysClusterClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGroupTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGroupTSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGroupName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGroupIsVisible( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpIncTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpIncTSecGrpIncId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpIncTSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpIncIncludeGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpMembTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpMembTSecGrpMembId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpMembTSecGroupId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTSecGrpMembSecUserId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZDateColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZDateDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTZDateDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZDateTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZTimeColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZTimeDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTZTimeDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZTimeTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZTimestampColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZTimestampDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTZTimestampDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTZTimestampTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTablePageData( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTablePrimaryIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTablePrimaryIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTablePrimaryIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTablePrimaryIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableTableClassCode( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableLookupIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableLookupIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableLookupIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableLookupIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableAltIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableAltIndexTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableAltIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableAltIndexId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableQualifyingTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableQualifyingTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableQualifyingTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableQualifyingTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableIsInstantiable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHasHistory( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHasAuditColumns( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableLoaderBehaviour( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableSecScope( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJEditObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJEditObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableObjImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJDb2LUWTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJDb2LUWTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJMSSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJMSSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJMySqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJMySqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJOracleTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJOracleTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJPgSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJPgSqlTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJRamTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJRamTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJSaxLoaderImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJSaxLoaderImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgRqstTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgRqstTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgRspnTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgRspnTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgClientTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgClientTableImport( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableJXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableJXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppEditObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppEditObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppDb2LUWTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppDb2LUWTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppMSSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppMSSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppMySqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppMySqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppOracleTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppOracleTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppPgSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppPgSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppRamTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppRamTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppSaxLoaderInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppSaxLoaderInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgRqstTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgRqstTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgRspnTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgRspnTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgClientTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgClientTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCppXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCppXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppEditObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppEditObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableObjInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppDb2LUWTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppDb2LUWTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppMSSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppMSSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppMySqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppMySqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppOracleTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppOracleTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppPgSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppPgSqlTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppRamTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppRamTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppSaxLoaderInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppSaxLoaderInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgRqstTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgRqstTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgRspnTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgRspnTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgClientTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgClientTableInclude( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableHppXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableHppXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsEditObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsEditObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsEditObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsEditObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsEditObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableObjUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableObjMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableObjInterface( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsTableObjImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsDb2LUWTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsDb2LUWTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsDb2LUWTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsDb2LUWTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsMSSqlTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsMSSqlTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsMSSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsMSSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsMySqlTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsMySqlTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsMySqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsMySqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsOracleTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsOracleTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsOracleTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsOracleTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsPgSqlTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsPgSqlTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsPgSqlTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsPgSqlTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsRamTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsRamTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsRamTableMembers( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsRamTableImplementation( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsSaxLoaderUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsSaxLoaderUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsSaxLoaderStartElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsSaxLoaderEndElement( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgTableFormatters( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgRqstTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgRqstTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgRspnTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgRspnTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgClientTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgClientTableUsing( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgRqstTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgRspnTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableCsXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableCsXMsgClientTableBody( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableLookupIndex( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableAltIndex( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableQualTable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTablePrimaryIndex( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableColDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableColDbName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableColDataTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableColDataTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableColDataId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableColDataId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTableColXmlElementName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTableColXmlElementName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTenantClusterId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTenantTenantName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTextColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTextDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTextDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTextDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTextDefXmlElementName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTextDefXmlElementName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTextTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTimeColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTimeDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTimeDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTimeTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTimestampColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTimestampDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTimestampDefDummy( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTimestampTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTldTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTldId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTldName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTldDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTldDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTokenColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTokenDefMaxLen( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTokenDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTokenTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopDomainTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopDomainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopDomainTldId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopDomainName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopDomainDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTopDomainDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopProjectTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopProjectId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopProjectTopDomainId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopProjectName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindTopProjectDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasTopProjectDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt16ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt16DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt16DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt16DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt16TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt32ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt32DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt32DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt32DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt32TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt64ColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt64DefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt64DefMinValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUInt64DefMaxValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUInt64TypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindURLProtocolURLProtocolId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindURLProtocolName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindURLProtocolDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindURLProtocolIsSecure( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUuidColTableId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUuidDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasUuidDefInitValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUuidGenSlice( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUuidGenBlockSize( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindUuidTypeSchemaDefId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueScopeId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueDefSchemaTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueDefSchemaId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueShortName( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueLabel( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueShortDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueDescription( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueDefaultXmlValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueDefaultXmlValue( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueIsNullable( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueGenerateId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueGenerateId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValuePrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValuePrevTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValuePrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValuePrevId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueNextTenantId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindValueNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueNextId( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueDefSchema( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValuePrev( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

		bind = new CFBamMssCFBindHasValueNext( this );
		editBind = (ICFGenKbGenBindEditObj)bind.beginEdit();
		editBind.setRequiredContainerCartridge( ruleCart );
		editBind.setRequiredLookupRuleType( ruleTypeBind );
		editBind.create();
		editBind = null;

	}

	public void bootstrapIterators() {
		ICFGenKbGenIteratorObj iterator = null;
		ICFGenKbGenIteratorEditObj editIterator = null;
		ICFGenKbRuleCartObj ruleCart = this.getInternalRuleCart();
		ICFGenKbRuleTypeObj ruleTypeIterator = this.getRuleTypeTableObj().readRuleTypeByNameIdx("Iterator");

		iterator = new CFBamMssCFIterateClearSubDep1ClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClearSubDep2ClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClearTopDepClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClusterHostNode( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClusterTenant( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClusterSecApp( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClusterSecGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateClusterSysCluster( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateDelSubDep1DelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateDelSubDep2DelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateDelTopDepDelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateEnumDefTag( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateHostNodeService( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateISOCcyCtry( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateISOCtryCcy( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateISOCtryLang( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateISOLangCtry( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateIndexColumns( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateIndexColRefRelFromCol( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateIndexColRefRelToCol( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateMajorVersionMinorVer( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateMinorVersionSchemaDef( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIteratePopSubDep1PopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIteratePopSubDep2PopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIteratePopTopDepPopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateRelationColumns( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateRelationPopDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSchemaDefTables( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSchemaDefTypes( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSchemaDefSchemaRefs( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecAppForm( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecGroupInclude( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecGroupMember( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecGroupIncByGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecGroupForm( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecUserSecDev( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecUserSecSess( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecUserSecProxy( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecUserSecGrpMemb( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSecUserTSecGrpMemb( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateServerMethodParams( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateServiceTypeDeployed( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateSubProjectMajorVer( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTSecGroupInclude( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTSecGroupMember( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTSecGroupIncByGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableRelation( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableIndex( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableColumns( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableReverseRelations( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableChains( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableDelDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableClearDep( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableDispId16Gen( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableDispId32Gen( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableDispId64Gen( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTableServerMethods( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTenantTSecGroup( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTenantTld( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTenantSchema( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTldTopDomain( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTopDomainLicense( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTopDomainTopProject( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateTopProjectSubProject( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateValueRefTableCol( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

		iterator = new CFBamMssCFIterateValueRefIndexCol( this );
		editIterator = (ICFGenKbGenIteratorEditObj)iterator.beginEdit();
		editIterator.setRequiredContainerCartridge( ruleCart );
		editIterator.setRequiredLookupRuleType( ruleTypeIterator );
		editIterator.create();
		editIterator = null;

	}

	public void bootstrapReferences() {
		ICFGenKbGenReferenceObj refer = null;
		ICFGenKbGenReferenceEditObj editRefer = null;
		ICFGenKbRuleCartObj ruleCart = this.getInternalRuleCart();
		ICFGenKbRuleTypeObj ruleTypeReference = this.getRuleTypeTableObj().readRuleTypeByNameIdx("Reference");

		refer = new CFBamMssCFReferenceBlobColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceBlobTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceBoolColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceBoolTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceChainTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceChainTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceChainDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceChainPrevRel( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceChainNextRel( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearDepRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearDepDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearSubDep1ClearTopDep( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearSubDep2ClearSubDep1( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearSubDep3ClearSubDep2( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearTopDepTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearTopDepPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceClearTopDepNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDateColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDateTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelDepRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelDepDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelSubDep1DelTopDep( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelSubDep2DelSubDep1( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelSubDep3DelSubDep2( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelTopDepTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelTopDepPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDelTopDepNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDoubleColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceDoubleTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceEnumTagTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceEnumTagEnumDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceEnumTagDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceEnumTagPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceEnumTagNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceEnumTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceFloatColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceFloatTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceHostNodeCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceISOCtryCcyCtry( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceISOCtryCcyCcy( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceISOCtryLangCtry( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceISOCtryLangLang( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceId16GenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceId32GenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceId64GenDispenser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexIdxTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexColTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexColIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexColDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexColPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexColNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceIndexColColumn( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceInt16ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceInt16TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceInt32ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceInt32TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceInt64ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceInt64TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceLicenseTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceLicenseTopDomain( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceMajorVersionTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceMajorVersionParentSPrj( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceMinorVersionTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceMinorVersionParentMajVer( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceNmTokenColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceNmTokenTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceNmTokensColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceNmTokensTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceNumberColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceNumberTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceParamServerMeth( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceParamTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceParamDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceParamPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceParamNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceParamType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferencePopDepRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferencePopDepDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferencePopSubDep1ContPopTopDep( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferencePopSubDep2PopSubDep1( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferencePopSubDep3PopSubDep2( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferencePopTopDepContRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationFromTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationRelTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationFromIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationToTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationToIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationNarrowed( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColRelation( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColFromCol( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceRelationColToCol( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaDefMinorVersion( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaDefDefaultLicense( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaDefCTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaRefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaRefRefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaRefPrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSchemaRefNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceScopeTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecAppCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecDeviceSecUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecFormCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecFormApplication( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGroupCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGroupFormCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGroupFormGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGroupFormApp( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGroupFormForm( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGrpIncCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGrpIncGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGrpIncSubGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGrpMembCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGrpMembGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecGrpMembUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecSessionSecUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecSessionSecProxy( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSecUserDefDev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServerListFuncRetTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServerMethodDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServerMethodForTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServerObjFuncRetTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServiceCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServiceHost( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceServiceServiceType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceStringColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceStringTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSubProjectTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSubProjectParentTPrj( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceSysClusterCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGroupTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGrpIncTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGrpIncGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGrpIncSubGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGrpMembTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGrpMembGroup( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTSecGrpMembUser( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTZDateColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTZDateTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTZTimeColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTZTimeTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTZTimestampColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTZTimestampTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableLookupIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableAltIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableQualTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTablePrimaryIndex( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTableColDataType( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTenantCluster( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTextColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTextTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTimeColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTimeTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTimestampColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTimestampTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTldTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTokenColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTokenTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTopDomainTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTopDomainParentTld( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTopProjectTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceTopProjectParentSDom( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUInt16ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUInt16TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUInt32ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUInt32TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUInt64ColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUInt64TypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUuidColTable( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceUuidTypeSchemaDef( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceValueTenant( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceValueScope( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceValueDefSchema( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceValuePrev( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

		refer = new CFBamMssCFReferenceValueNext( this );
		editRefer = (ICFGenKbGenReferenceEditObj)refer.beginEdit();
		editRefer.setRequiredContainerCartridge( ruleCart );
		editRefer.setRequiredLookupRuleType( ruleTypeReference );
		editRefer.create();
		editRefer = null;

	}}
