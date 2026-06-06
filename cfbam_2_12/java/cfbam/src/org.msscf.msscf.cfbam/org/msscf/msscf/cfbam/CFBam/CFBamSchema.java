// Description: Java 11 implementation of a CFBam schema.

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

package org.msscf.msscf.cfbam.CFBam;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cflib.CFLib.Tip.CFTipClientHandler;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;

public class CFBamSchema
	implements ICFBamSchema,
		ICFSecSchema,
		ICFIntSchema
{
	protected CFSecAuthorization authorization;
	protected ICFSecTablePerms tablePerms;
	protected CFSecConfigurationFile configuration;
	protected String jndiName;
	protected String schemaDbName = "CFBam212";
	protected String lowerDbSchemaName = schemaDbName.toLowerCase();

	static HashMap<String,LoaderBehaviourEnum> lookupLoaderBehaviourEnum = null;

	public static LoaderBehaviourEnum parseLoaderBehaviourEnum( String value ) {
		LoaderBehaviourEnum retval = parseLoaderBehaviourEnum( CFBamSchema.class.getName(), value );
		return( retval );
	}

	public static LoaderBehaviourEnum parseLoaderBehaviourEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseLoaderBehaviourEnum";
		if( lookupLoaderBehaviourEnum == null ) {
			HashMap<String,LoaderBehaviourEnum> newMap = new HashMap<String,LoaderBehaviourEnum>();
			newMap.put( "Insert", LoaderBehaviourEnum.Insert );
			newMap.put( "Update", LoaderBehaviourEnum.Update );
			newMap.put( "Replace", LoaderBehaviourEnum.Replace );
			lookupLoaderBehaviourEnum = newMap;
		}
		LoaderBehaviourEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupLoaderBehaviourEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Invalid enum limb argument " + value );
			}
		}
		return( retval );
	}

	static HashMap<Integer,LoaderBehaviourEnum> lookupOrdinalLoaderBehaviourEnum = null;

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( String fieldOrClassName, Short value ) {
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToLoaderBehaviourEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( Short value ) {
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToLoaderBehaviourEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( Integer value ) {
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToLoaderBehaviourEnum( CFBamSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static LoaderBehaviourEnum ordinalToLoaderBehaviourEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToLoaderBehaviourEnum";
		if( lookupOrdinalLoaderBehaviourEnum == null ) {
			HashMap<Integer,LoaderBehaviourEnum> newMap = new HashMap<Integer,LoaderBehaviourEnum>();
			newMap.put( Integer.valueOf( LoaderBehaviourEnum.Insert.ordinal() ), LoaderBehaviourEnum.Insert );
			newMap.put( Integer.valueOf( LoaderBehaviourEnum.Update.ordinal() ), LoaderBehaviourEnum.Update );
			newMap.put( Integer.valueOf( LoaderBehaviourEnum.Replace.ordinal() ), LoaderBehaviourEnum.Replace );
			lookupOrdinalLoaderBehaviourEnum = newMap;
		}
		LoaderBehaviourEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalLoaderBehaviourEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Invalid enum ordinal argument " + value.toString() );
			}
		}
		return( retval );
	}

	static HashMap<String,RelationTypeEnum> lookupRelationTypeEnum = null;

	public static RelationTypeEnum parseRelationTypeEnum( String value ) {
		RelationTypeEnum retval = parseRelationTypeEnum( CFBamSchema.class.getName(), value );
		return( retval );
	}

	public static RelationTypeEnum parseRelationTypeEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseRelationTypeEnum";
		if( lookupRelationTypeEnum == null ) {
			HashMap<String,RelationTypeEnum> newMap = new HashMap<String,RelationTypeEnum>();
			newMap.put( "Unknown", RelationTypeEnum.Unknown );
			newMap.put( "Lookup", RelationTypeEnum.Lookup );
			newMap.put( "Superclass", RelationTypeEnum.Superclass );
			newMap.put( "Container", RelationTypeEnum.Container );
			newMap.put( "Components", RelationTypeEnum.Components );
			newMap.put( "Owner", RelationTypeEnum.Owner );
			newMap.put( "Parent", RelationTypeEnum.Parent );
			newMap.put( "Children", RelationTypeEnum.Children );
			lookupRelationTypeEnum = newMap;
		}
		RelationTypeEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupRelationTypeEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Invalid enum limb argument " + value );
			}
		}
		return( retval );
	}

	static HashMap<Integer,RelationTypeEnum> lookupOrdinalRelationTypeEnum = null;

	public static RelationTypeEnum ordinalToRelationTypeEnum( String fieldOrClassName, Short value ) {
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRelationTypeEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RelationTypeEnum ordinalToRelationTypeEnum( Short value ) {
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRelationTypeEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RelationTypeEnum ordinalToRelationTypeEnum( Integer value ) {
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToRelationTypeEnum( CFBamSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static RelationTypeEnum ordinalToRelationTypeEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToRelationTypeEnum";
		if( lookupOrdinalRelationTypeEnum == null ) {
			HashMap<Integer,RelationTypeEnum> newMap = new HashMap<Integer,RelationTypeEnum>();
			newMap.put( Integer.valueOf( RelationTypeEnum.Unknown.ordinal() ), RelationTypeEnum.Unknown );
			newMap.put( Integer.valueOf( RelationTypeEnum.Lookup.ordinal() ), RelationTypeEnum.Lookup );
			newMap.put( Integer.valueOf( RelationTypeEnum.Superclass.ordinal() ), RelationTypeEnum.Superclass );
			newMap.put( Integer.valueOf( RelationTypeEnum.Container.ordinal() ), RelationTypeEnum.Container );
			newMap.put( Integer.valueOf( RelationTypeEnum.Components.ordinal() ), RelationTypeEnum.Components );
			newMap.put( Integer.valueOf( RelationTypeEnum.Owner.ordinal() ), RelationTypeEnum.Owner );
			newMap.put( Integer.valueOf( RelationTypeEnum.Parent.ordinal() ), RelationTypeEnum.Parent );
			newMap.put( Integer.valueOf( RelationTypeEnum.Children.ordinal() ), RelationTypeEnum.Children );
			lookupOrdinalRelationTypeEnum = newMap;
		}
		RelationTypeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalRelationTypeEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Invalid enum ordinal argument " + value.toString() );
			}
		}
		return( retval );
	}

	static HashMap<String,SecScopeEnum> lookupSecScopeEnum = null;

	public static SecScopeEnum parseSecScopeEnum( String value ) {
		SecScopeEnum retval = parseSecScopeEnum( CFBamSchema.class.getName(), value );
		return( retval );
	}

	public static SecScopeEnum parseSecScopeEnum( String fieldOrClassName, String value ) {
		final String S_ProcName = "parseSecScopeEnum";
		if( lookupSecScopeEnum == null ) {
			HashMap<String,SecScopeEnum> newMap = new HashMap<String,SecScopeEnum>();
			newMap.put( "None", SecScopeEnum.None );
			newMap.put( "System", SecScopeEnum.System );
			newMap.put( "Cluster", SecScopeEnum.Cluster );
			newMap.put( "Tenant", SecScopeEnum.Tenant );
			lookupSecScopeEnum = newMap;
		}
		SecScopeEnum retval;
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			retval = null;
		}
		else {
			retval = lookupSecScopeEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Invalid enum limb argument " + value );
			}
		}
		return( retval );
	}

	static HashMap<Integer,SecScopeEnum> lookupOrdinalSecScopeEnum = null;

	public static SecScopeEnum ordinalToSecScopeEnum( String fieldOrClassName, Short value ) {
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecScopeEnum( fieldOrClassName, Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecScopeEnum ordinalToSecScopeEnum( Short value ) {
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecScopeEnum( Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecScopeEnum ordinalToSecScopeEnum( Integer value ) {
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = ordinalToSecScopeEnum( CFBamSchema.class.getName(), Integer.valueOf( value.shortValue() ) );
		}
		return( retval );
	}

	public static SecScopeEnum ordinalToSecScopeEnum( String fieldOrClassName, Integer value ) {
		final String S_ProcName = "ordinalToSecScopeEnum";
		if( lookupOrdinalSecScopeEnum == null ) {
			HashMap<Integer,SecScopeEnum> newMap = new HashMap<Integer,SecScopeEnum>();
			newMap.put( Integer.valueOf( SecScopeEnum.None.ordinal() ), SecScopeEnum.None );
			newMap.put( Integer.valueOf( SecScopeEnum.System.ordinal() ), SecScopeEnum.System );
			newMap.put( Integer.valueOf( SecScopeEnum.Cluster.ordinal() ), SecScopeEnum.Cluster );
			newMap.put( Integer.valueOf( SecScopeEnum.Tenant.ordinal() ), SecScopeEnum.Tenant );
			lookupOrdinalSecScopeEnum = newMap;
		}
		SecScopeEnum retval;
		if( value == null ) {
			retval = null;
		}
		else {
			retval = lookupOrdinalSecScopeEnum.get( value );
			if( retval == null ) {
				throw new CFLibInvalidArgumentException( fieldOrClassName,
					S_ProcName,
					1,
					"value",
					"Invalid enum ordinal argument " + value.toString() );
			}
		}
		return( retval );
	}

	protected ICFBamAtomTable tableAtom;
	protected ICFBamBlobColTable tableBlobCol;
	protected ICFBamBlobDefTable tableBlobDef;
	protected ICFBamBlobTypeTable tableBlobType;
	protected ICFBamBoolColTable tableBoolCol;
	protected ICFBamBoolDefTable tableBoolDef;
	protected ICFBamBoolTypeTable tableBoolType;
	protected ICFBamChainTable tableChain;
	protected ICFBamClearDepTable tableClearDep;
	protected ICFBamClearSubDep1Table tableClearSubDep1;
	protected ICFBamClearSubDep2Table tableClearSubDep2;
	protected ICFBamClearSubDep3Table tableClearSubDep3;
	protected ICFBamClearTopDepTable tableClearTopDep;
	protected ICFSecClusterTable tableCluster;
	protected ICFBamDateColTable tableDateCol;
	protected ICFBamDateDefTable tableDateDef;
	protected ICFBamDateTypeTable tableDateType;
	protected ICFBamDelDepTable tableDelDep;
	protected ICFBamDelSubDep1Table tableDelSubDep1;
	protected ICFBamDelSubDep2Table tableDelSubDep2;
	protected ICFBamDelSubDep3Table tableDelSubDep3;
	protected ICFBamDelTopDepTable tableDelTopDep;
	protected ICFBamDoubleColTable tableDoubleCol;
	protected ICFBamDoubleDefTable tableDoubleDef;
	protected ICFBamDoubleTypeTable tableDoubleType;
	protected ICFBamEnumDefTable tableEnumDef;
	protected ICFBamEnumTagTable tableEnumTag;
	protected ICFBamEnumTypeTable tableEnumType;
	protected ICFBamFloatColTable tableFloatCol;
	protected ICFBamFloatDefTable tableFloatDef;
	protected ICFBamFloatTypeTable tableFloatType;
	protected ICFSecHostNodeTable tableHostNode;
	protected ICFSecISOCcyTable tableISOCcy;
	protected ICFSecISOCtryTable tableISOCtry;
	protected ICFSecISOCtryCcyTable tableISOCtryCcy;
	protected ICFSecISOCtryLangTable tableISOCtryLang;
	protected ICFSecISOLangTable tableISOLang;
	protected ICFSecISOTZoneTable tableISOTZone;
	protected ICFBamId16GenTable tableId16Gen;
	protected ICFBamId32GenTable tableId32Gen;
	protected ICFBamId64GenTable tableId64Gen;
	protected ICFBamIndexTable tableIndex;
	protected ICFBamIndexColTable tableIndexCol;
	protected ICFBamInt16ColTable tableInt16Col;
	protected ICFBamInt16DefTable tableInt16Def;
	protected ICFBamInt16TypeTable tableInt16Type;
	protected ICFBamInt32ColTable tableInt32Col;
	protected ICFBamInt32DefTable tableInt32Def;
	protected ICFBamInt32TypeTable tableInt32Type;
	protected ICFBamInt64ColTable tableInt64Col;
	protected ICFBamInt64DefTable tableInt64Def;
	protected ICFBamInt64TypeTable tableInt64Type;
	protected ICFIntLicenseTable tableLicense;
	protected ICFIntMajorVersionTable tableMajorVersion;
	protected ICFIntMimeTypeTable tableMimeType;
	protected ICFIntMinorVersionTable tableMinorVersion;
	protected ICFBamNmTokenColTable tableNmTokenCol;
	protected ICFBamNmTokenDefTable tableNmTokenDef;
	protected ICFBamNmTokenTypeTable tableNmTokenType;
	protected ICFBamNmTokensColTable tableNmTokensCol;
	protected ICFBamNmTokensDefTable tableNmTokensDef;
	protected ICFBamNmTokensTypeTable tableNmTokensType;
	protected ICFBamNumberColTable tableNumberCol;
	protected ICFBamNumberDefTable tableNumberDef;
	protected ICFBamNumberTypeTable tableNumberType;
	protected ICFBamParamTable tableParam;
	protected ICFBamPopDepTable tablePopDep;
	protected ICFBamPopSubDep1Table tablePopSubDep1;
	protected ICFBamPopSubDep2Table tablePopSubDep2;
	protected ICFBamPopSubDep3Table tablePopSubDep3;
	protected ICFBamPopTopDepTable tablePopTopDep;
	protected ICFBamRelationTable tableRelation;
	protected ICFBamRelationColTable tableRelationCol;
	protected ICFBamSchemaDefTable tableSchemaDef;
	protected ICFBamSchemaRefTable tableSchemaRef;
	protected ICFBamScopeTable tableScope;
	protected ICFSecSecAppTable tableSecApp;
	protected ICFSecSecDeviceTable tableSecDevice;
	protected ICFSecSecFormTable tableSecForm;
	protected ICFSecSecGroupTable tableSecGroup;
	protected ICFSecSecGroupFormTable tableSecGroupForm;
	protected ICFSecSecGrpIncTable tableSecGrpInc;
	protected ICFSecSecGrpMembTable tableSecGrpMemb;
	protected ICFSecSecSessionTable tableSecSession;
	protected ICFSecSecUserTable tableSecUser;
	protected ICFBamServerListFuncTable tableServerListFunc;
	protected ICFBamServerMethodTable tableServerMethod;
	protected ICFBamServerObjFuncTable tableServerObjFunc;
	protected ICFBamServerProcTable tableServerProc;
	protected ICFSecServiceTable tableService;
	protected ICFSecServiceTypeTable tableServiceType;
	protected ICFBamStringColTable tableStringCol;
	protected ICFBamStringDefTable tableStringDef;
	protected ICFBamStringTypeTable tableStringType;
	protected ICFIntSubProjectTable tableSubProject;
	protected ICFSecSysClusterTable tableSysCluster;
	protected ICFSecTSecGroupTable tableTSecGroup;
	protected ICFSecTSecGrpIncTable tableTSecGrpInc;
	protected ICFSecTSecGrpMembTable tableTSecGrpMemb;
	protected ICFBamTZDateColTable tableTZDateCol;
	protected ICFBamTZDateDefTable tableTZDateDef;
	protected ICFBamTZDateTypeTable tableTZDateType;
	protected ICFBamTZTimeColTable tableTZTimeCol;
	protected ICFBamTZTimeDefTable tableTZTimeDef;
	protected ICFBamTZTimeTypeTable tableTZTimeType;
	protected ICFBamTZTimestampColTable tableTZTimestampCol;
	protected ICFBamTZTimestampDefTable tableTZTimestampDef;
	protected ICFBamTZTimestampTypeTable tableTZTimestampType;
	protected ICFBamTableTable tableTable;
	protected ICFBamTableColTable tableTableCol;
	protected ICFSecTenantTable tableTenant;
	protected ICFBamTextColTable tableTextCol;
	protected ICFBamTextDefTable tableTextDef;
	protected ICFBamTextTypeTable tableTextType;
	protected ICFBamTimeColTable tableTimeCol;
	protected ICFBamTimeDefTable tableTimeDef;
	protected ICFBamTimeTypeTable tableTimeType;
	protected ICFBamTimestampColTable tableTimestampCol;
	protected ICFBamTimestampDefTable tableTimestampDef;
	protected ICFBamTimestampTypeTable tableTimestampType;
	protected ICFIntTldTable tableTld;
	protected ICFBamTokenColTable tableTokenCol;
	protected ICFBamTokenDefTable tableTokenDef;
	protected ICFBamTokenTypeTable tableTokenType;
	protected ICFIntTopDomainTable tableTopDomain;
	protected ICFIntTopProjectTable tableTopProject;
	protected ICFBamUInt16ColTable tableUInt16Col;
	protected ICFBamUInt16DefTable tableUInt16Def;
	protected ICFBamUInt16TypeTable tableUInt16Type;
	protected ICFBamUInt32ColTable tableUInt32Col;
	protected ICFBamUInt32DefTable tableUInt32Def;
	protected ICFBamUInt32TypeTable tableUInt32Type;
	protected ICFBamUInt64ColTable tableUInt64Col;
	protected ICFBamUInt64DefTable tableUInt64Def;
	protected ICFBamUInt64TypeTable tableUInt64Type;
	protected ICFIntURLProtocolTable tableURLProtocol;
	protected ICFBamUuidColTable tableUuidCol;
	protected ICFBamUuidDefTable tableUuidDef;
	protected ICFBamUuidGenTable tableUuidGen;
	protected ICFBamUuidTypeTable tableUuidType;
	protected ICFBamValueTable tableValue;

	protected ICFBamAtomFactory factoryAtom;
	protected ICFBamBlobColFactory factoryBlobCol;
	protected ICFBamBlobDefFactory factoryBlobDef;
	protected ICFBamBlobTypeFactory factoryBlobType;
	protected ICFBamBoolColFactory factoryBoolCol;
	protected ICFBamBoolDefFactory factoryBoolDef;
	protected ICFBamBoolTypeFactory factoryBoolType;
	protected ICFBamChainFactory factoryChain;
	protected ICFBamClearDepFactory factoryClearDep;
	protected ICFBamClearSubDep1Factory factoryClearSubDep1;
	protected ICFBamClearSubDep2Factory factoryClearSubDep2;
	protected ICFBamClearSubDep3Factory factoryClearSubDep3;
	protected ICFBamClearTopDepFactory factoryClearTopDep;
	protected ICFSecClusterFactory factoryCluster;
	protected ICFBamDateColFactory factoryDateCol;
	protected ICFBamDateDefFactory factoryDateDef;
	protected ICFBamDateTypeFactory factoryDateType;
	protected ICFBamDelDepFactory factoryDelDep;
	protected ICFBamDelSubDep1Factory factoryDelSubDep1;
	protected ICFBamDelSubDep2Factory factoryDelSubDep2;
	protected ICFBamDelSubDep3Factory factoryDelSubDep3;
	protected ICFBamDelTopDepFactory factoryDelTopDep;
	protected ICFBamDoubleColFactory factoryDoubleCol;
	protected ICFBamDoubleDefFactory factoryDoubleDef;
	protected ICFBamDoubleTypeFactory factoryDoubleType;
	protected ICFBamEnumDefFactory factoryEnumDef;
	protected ICFBamEnumTagFactory factoryEnumTag;
	protected ICFBamEnumTypeFactory factoryEnumType;
	protected ICFBamFloatColFactory factoryFloatCol;
	protected ICFBamFloatDefFactory factoryFloatDef;
	protected ICFBamFloatTypeFactory factoryFloatType;
	protected ICFSecHostNodeFactory factoryHostNode;
	protected ICFSecISOCcyFactory factoryISOCcy;
	protected ICFSecISOCtryFactory factoryISOCtry;
	protected ICFSecISOCtryCcyFactory factoryISOCtryCcy;
	protected ICFSecISOCtryLangFactory factoryISOCtryLang;
	protected ICFSecISOLangFactory factoryISOLang;
	protected ICFSecISOTZoneFactory factoryISOTZone;
	protected ICFBamId16GenFactory factoryId16Gen;
	protected ICFBamId32GenFactory factoryId32Gen;
	protected ICFBamId64GenFactory factoryId64Gen;
	protected ICFBamIndexFactory factoryIndex;
	protected ICFBamIndexColFactory factoryIndexCol;
	protected ICFBamInt16ColFactory factoryInt16Col;
	protected ICFBamInt16DefFactory factoryInt16Def;
	protected ICFBamInt16TypeFactory factoryInt16Type;
	protected ICFBamInt32ColFactory factoryInt32Col;
	protected ICFBamInt32DefFactory factoryInt32Def;
	protected ICFBamInt32TypeFactory factoryInt32Type;
	protected ICFBamInt64ColFactory factoryInt64Col;
	protected ICFBamInt64DefFactory factoryInt64Def;
	protected ICFBamInt64TypeFactory factoryInt64Type;
	protected ICFIntLicenseFactory factoryLicense;
	protected ICFIntMajorVersionFactory factoryMajorVersion;
	protected ICFIntMimeTypeFactory factoryMimeType;
	protected ICFIntMinorVersionFactory factoryMinorVersion;
	protected ICFBamNmTokenColFactory factoryNmTokenCol;
	protected ICFBamNmTokenDefFactory factoryNmTokenDef;
	protected ICFBamNmTokenTypeFactory factoryNmTokenType;
	protected ICFBamNmTokensColFactory factoryNmTokensCol;
	protected ICFBamNmTokensDefFactory factoryNmTokensDef;
	protected ICFBamNmTokensTypeFactory factoryNmTokensType;
	protected ICFBamNumberColFactory factoryNumberCol;
	protected ICFBamNumberDefFactory factoryNumberDef;
	protected ICFBamNumberTypeFactory factoryNumberType;
	protected ICFBamParamFactory factoryParam;
	protected ICFBamPopDepFactory factoryPopDep;
	protected ICFBamPopSubDep1Factory factoryPopSubDep1;
	protected ICFBamPopSubDep2Factory factoryPopSubDep2;
	protected ICFBamPopSubDep3Factory factoryPopSubDep3;
	protected ICFBamPopTopDepFactory factoryPopTopDep;
	protected ICFBamRelationFactory factoryRelation;
	protected ICFBamRelationColFactory factoryRelationCol;
	protected ICFBamSchemaDefFactory factorySchemaDef;
	protected ICFBamSchemaRefFactory factorySchemaRef;
	protected ICFBamScopeFactory factoryScope;
	protected ICFSecSecAppFactory factorySecApp;
	protected ICFSecSecDeviceFactory factorySecDevice;
	protected ICFSecSecFormFactory factorySecForm;
	protected ICFSecSecGroupFactory factorySecGroup;
	protected ICFSecSecGroupFormFactory factorySecGroupForm;
	protected ICFSecSecGrpIncFactory factorySecGrpInc;
	protected ICFSecSecGrpMembFactory factorySecGrpMemb;
	protected ICFSecSecSessionFactory factorySecSession;
	protected ICFSecSecUserFactory factorySecUser;
	protected ICFBamServerListFuncFactory factoryServerListFunc;
	protected ICFBamServerMethodFactory factoryServerMethod;
	protected ICFBamServerObjFuncFactory factoryServerObjFunc;
	protected ICFBamServerProcFactory factoryServerProc;
	protected ICFSecServiceFactory factoryService;
	protected ICFSecServiceTypeFactory factoryServiceType;
	protected ICFBamStringColFactory factoryStringCol;
	protected ICFBamStringDefFactory factoryStringDef;
	protected ICFBamStringTypeFactory factoryStringType;
	protected ICFIntSubProjectFactory factorySubProject;
	protected ICFSecSysClusterFactory factorySysCluster;
	protected ICFSecTSecGroupFactory factoryTSecGroup;
	protected ICFSecTSecGrpIncFactory factoryTSecGrpInc;
	protected ICFSecTSecGrpMembFactory factoryTSecGrpMemb;
	protected ICFBamTZDateColFactory factoryTZDateCol;
	protected ICFBamTZDateDefFactory factoryTZDateDef;
	protected ICFBamTZDateTypeFactory factoryTZDateType;
	protected ICFBamTZTimeColFactory factoryTZTimeCol;
	protected ICFBamTZTimeDefFactory factoryTZTimeDef;
	protected ICFBamTZTimeTypeFactory factoryTZTimeType;
	protected ICFBamTZTimestampColFactory factoryTZTimestampCol;
	protected ICFBamTZTimestampDefFactory factoryTZTimestampDef;
	protected ICFBamTZTimestampTypeFactory factoryTZTimestampType;
	protected ICFBamTableFactory factoryTable;
	protected ICFBamTableColFactory factoryTableCol;
	protected ICFSecTenantFactory factoryTenant;
	protected ICFBamTextColFactory factoryTextCol;
	protected ICFBamTextDefFactory factoryTextDef;
	protected ICFBamTextTypeFactory factoryTextType;
	protected ICFBamTimeColFactory factoryTimeCol;
	protected ICFBamTimeDefFactory factoryTimeDef;
	protected ICFBamTimeTypeFactory factoryTimeType;
	protected ICFBamTimestampColFactory factoryTimestampCol;
	protected ICFBamTimestampDefFactory factoryTimestampDef;
	protected ICFBamTimestampTypeFactory factoryTimestampType;
	protected ICFIntTldFactory factoryTld;
	protected ICFBamTokenColFactory factoryTokenCol;
	protected ICFBamTokenDefFactory factoryTokenDef;
	protected ICFBamTokenTypeFactory factoryTokenType;
	protected ICFIntTopDomainFactory factoryTopDomain;
	protected ICFIntTopProjectFactory factoryTopProject;
	protected ICFBamUInt16ColFactory factoryUInt16Col;
	protected ICFBamUInt16DefFactory factoryUInt16Def;
	protected ICFBamUInt16TypeFactory factoryUInt16Type;
	protected ICFBamUInt32ColFactory factoryUInt32Col;
	protected ICFBamUInt32DefFactory factoryUInt32Def;
	protected ICFBamUInt32TypeFactory factoryUInt32Type;
	protected ICFBamUInt64ColFactory factoryUInt64Col;
	protected ICFBamUInt64DefFactory factoryUInt64Def;
	protected ICFBamUInt64TypeFactory factoryUInt64Type;
	protected ICFIntURLProtocolFactory factoryURLProtocol;
	protected ICFBamUuidColFactory factoryUuidCol;
	protected ICFBamUuidDefFactory factoryUuidDef;
	protected ICFBamUuidGenFactory factoryUuidGen;
	protected ICFBamUuidTypeFactory factoryUuidType;
	protected ICFBamValueFactory factoryValue;


	public CFBamSchema() {
		configuration = null;
		jndiName = null;

		tableAtom = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableHostNode = null;
		tableISOCcy = null;
		tableISOCtry = null;
		tableISOCtryCcy = null;
		tableISOCtryLang = null;
		tableISOLang = null;
		tableISOTZone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableRelation = null;
		tableRelationCol = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableScope = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGrpInc = null;
		tableSecGrpMemb = null;
		tableSecSession = null;
		tableSecUser = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableService = null;
		tableServiceType = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGrpInc = null;
		tableTSecGrpMemb = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;

		factoryAtom = new CFBamAtomDefaultFactory();
		factoryBlobCol = new CFBamBlobColDefaultFactory();
		factoryBlobDef = new CFBamBlobDefDefaultFactory();
		factoryBlobType = new CFBamBlobTypeDefaultFactory();
		factoryBoolCol = new CFBamBoolColDefaultFactory();
		factoryBoolDef = new CFBamBoolDefDefaultFactory();
		factoryBoolType = new CFBamBoolTypeDefaultFactory();
		factoryChain = new CFBamChainDefaultFactory();
		factoryClearDep = new CFBamClearDepDefaultFactory();
		factoryClearSubDep1 = new CFBamClearSubDep1DefaultFactory();
		factoryClearSubDep2 = new CFBamClearSubDep2DefaultFactory();
		factoryClearSubDep3 = new CFBamClearSubDep3DefaultFactory();
		factoryClearTopDep = new CFBamClearTopDepDefaultFactory();
		factoryCluster = new CFBamClusterDefaultFactory();
		factoryDateCol = new CFBamDateColDefaultFactory();
		factoryDateDef = new CFBamDateDefDefaultFactory();
		factoryDateType = new CFBamDateTypeDefaultFactory();
		factoryDelDep = new CFBamDelDepDefaultFactory();
		factoryDelSubDep1 = new CFBamDelSubDep1DefaultFactory();
		factoryDelSubDep2 = new CFBamDelSubDep2DefaultFactory();
		factoryDelSubDep3 = new CFBamDelSubDep3DefaultFactory();
		factoryDelTopDep = new CFBamDelTopDepDefaultFactory();
		factoryDoubleCol = new CFBamDoubleColDefaultFactory();
		factoryDoubleDef = new CFBamDoubleDefDefaultFactory();
		factoryDoubleType = new CFBamDoubleTypeDefaultFactory();
		factoryEnumDef = new CFBamEnumDefDefaultFactory();
		factoryEnumTag = new CFBamEnumTagDefaultFactory();
		factoryEnumType = new CFBamEnumTypeDefaultFactory();
		factoryFloatCol = new CFBamFloatColDefaultFactory();
		factoryFloatDef = new CFBamFloatDefDefaultFactory();
		factoryFloatType = new CFBamFloatTypeDefaultFactory();
		factoryHostNode = new CFBamHostNodeDefaultFactory();
		factoryISOCcy = new CFBamISOCcyDefaultFactory();
		factoryISOCtry = new CFBamISOCtryDefaultFactory();
		factoryISOCtryCcy = new CFBamISOCtryCcyDefaultFactory();
		factoryISOCtryLang = new CFBamISOCtryLangDefaultFactory();
		factoryISOLang = new CFBamISOLangDefaultFactory();
		factoryISOTZone = new CFBamISOTZoneDefaultFactory();
		factoryId16Gen = new CFBamId16GenDefaultFactory();
		factoryId32Gen = new CFBamId32GenDefaultFactory();
		factoryId64Gen = new CFBamId64GenDefaultFactory();
		factoryIndex = new CFBamIndexDefaultFactory();
		factoryIndexCol = new CFBamIndexColDefaultFactory();
		factoryInt16Col = new CFBamInt16ColDefaultFactory();
		factoryInt16Def = new CFBamInt16DefDefaultFactory();
		factoryInt16Type = new CFBamInt16TypeDefaultFactory();
		factoryInt32Col = new CFBamInt32ColDefaultFactory();
		factoryInt32Def = new CFBamInt32DefDefaultFactory();
		factoryInt32Type = new CFBamInt32TypeDefaultFactory();
		factoryInt64Col = new CFBamInt64ColDefaultFactory();
		factoryInt64Def = new CFBamInt64DefDefaultFactory();
		factoryInt64Type = new CFBamInt64TypeDefaultFactory();
		factoryLicense = new CFBamLicenseDefaultFactory();
		factoryMajorVersion = new CFBamMajorVersionDefaultFactory();
		factoryMimeType = new CFBamMimeTypeDefaultFactory();
		factoryMinorVersion = new CFBamMinorVersionDefaultFactory();
		factoryNmTokenCol = new CFBamNmTokenColDefaultFactory();
		factoryNmTokenDef = new CFBamNmTokenDefDefaultFactory();
		factoryNmTokenType = new CFBamNmTokenTypeDefaultFactory();
		factoryNmTokensCol = new CFBamNmTokensColDefaultFactory();
		factoryNmTokensDef = new CFBamNmTokensDefDefaultFactory();
		factoryNmTokensType = new CFBamNmTokensTypeDefaultFactory();
		factoryNumberCol = new CFBamNumberColDefaultFactory();
		factoryNumberDef = new CFBamNumberDefDefaultFactory();
		factoryNumberType = new CFBamNumberTypeDefaultFactory();
		factoryParam = new CFBamParamDefaultFactory();
		factoryPopDep = new CFBamPopDepDefaultFactory();
		factoryPopSubDep1 = new CFBamPopSubDep1DefaultFactory();
		factoryPopSubDep2 = new CFBamPopSubDep2DefaultFactory();
		factoryPopSubDep3 = new CFBamPopSubDep3DefaultFactory();
		factoryPopTopDep = new CFBamPopTopDepDefaultFactory();
		factoryRelation = new CFBamRelationDefaultFactory();
		factoryRelationCol = new CFBamRelationColDefaultFactory();
		factorySchemaDef = new CFBamSchemaDefDefaultFactory();
		factorySchemaRef = new CFBamSchemaRefDefaultFactory();
		factoryScope = new CFBamScopeDefaultFactory();
		factorySecApp = new CFBamSecAppDefaultFactory();
		factorySecDevice = new CFBamSecDeviceDefaultFactory();
		factorySecForm = new CFBamSecFormDefaultFactory();
		factorySecGroup = new CFBamSecGroupDefaultFactory();
		factorySecGroupForm = new CFBamSecGroupFormDefaultFactory();
		factorySecGrpInc = new CFBamSecGrpIncDefaultFactory();
		factorySecGrpMemb = new CFBamSecGrpMembDefaultFactory();
		factorySecSession = new CFBamSecSessionDefaultFactory();
		factorySecUser = new CFBamSecUserDefaultFactory();
		factoryServerListFunc = new CFBamServerListFuncDefaultFactory();
		factoryServerMethod = new CFBamServerMethodDefaultFactory();
		factoryServerObjFunc = new CFBamServerObjFuncDefaultFactory();
		factoryServerProc = new CFBamServerProcDefaultFactory();
		factoryService = new CFBamServiceDefaultFactory();
		factoryServiceType = new CFBamServiceTypeDefaultFactory();
		factoryStringCol = new CFBamStringColDefaultFactory();
		factoryStringDef = new CFBamStringDefDefaultFactory();
		factoryStringType = new CFBamStringTypeDefaultFactory();
		factorySubProject = new CFBamSubProjectDefaultFactory();
		factorySysCluster = new CFBamSysClusterDefaultFactory();
		factoryTSecGroup = new CFBamTSecGroupDefaultFactory();
		factoryTSecGrpInc = new CFBamTSecGrpIncDefaultFactory();
		factoryTSecGrpMemb = new CFBamTSecGrpMembDefaultFactory();
		factoryTZDateCol = new CFBamTZDateColDefaultFactory();
		factoryTZDateDef = new CFBamTZDateDefDefaultFactory();
		factoryTZDateType = new CFBamTZDateTypeDefaultFactory();
		factoryTZTimeCol = new CFBamTZTimeColDefaultFactory();
		factoryTZTimeDef = new CFBamTZTimeDefDefaultFactory();
		factoryTZTimeType = new CFBamTZTimeTypeDefaultFactory();
		factoryTZTimestampCol = new CFBamTZTimestampColDefaultFactory();
		factoryTZTimestampDef = new CFBamTZTimestampDefDefaultFactory();
		factoryTZTimestampType = new CFBamTZTimestampTypeDefaultFactory();
		factoryTable = new CFBamTableDefaultFactory();
		factoryTableCol = new CFBamTableColDefaultFactory();
		factoryTenant = new CFBamTenantDefaultFactory();
		factoryTextCol = new CFBamTextColDefaultFactory();
		factoryTextDef = new CFBamTextDefDefaultFactory();
		factoryTextType = new CFBamTextTypeDefaultFactory();
		factoryTimeCol = new CFBamTimeColDefaultFactory();
		factoryTimeDef = new CFBamTimeDefDefaultFactory();
		factoryTimeType = new CFBamTimeTypeDefaultFactory();
		factoryTimestampCol = new CFBamTimestampColDefaultFactory();
		factoryTimestampDef = new CFBamTimestampDefDefaultFactory();
		factoryTimestampType = new CFBamTimestampTypeDefaultFactory();
		factoryTld = new CFBamTldDefaultFactory();
		factoryTokenCol = new CFBamTokenColDefaultFactory();
		factoryTokenDef = new CFBamTokenDefDefaultFactory();
		factoryTokenType = new CFBamTokenTypeDefaultFactory();
		factoryTopDomain = new CFBamTopDomainDefaultFactory();
		factoryTopProject = new CFBamTopProjectDefaultFactory();
		factoryUInt16Col = new CFBamUInt16ColDefaultFactory();
		factoryUInt16Def = new CFBamUInt16DefDefaultFactory();
		factoryUInt16Type = new CFBamUInt16TypeDefaultFactory();
		factoryUInt32Col = new CFBamUInt32ColDefaultFactory();
		factoryUInt32Def = new CFBamUInt32DefDefaultFactory();
		factoryUInt32Type = new CFBamUInt32TypeDefaultFactory();
		factoryUInt64Col = new CFBamUInt64ColDefaultFactory();
		factoryUInt64Def = new CFBamUInt64DefDefaultFactory();
		factoryUInt64Type = new CFBamUInt64TypeDefaultFactory();
		factoryURLProtocol = new CFBamURLProtocolDefaultFactory();
		factoryUuidCol = new CFBamUuidColDefaultFactory();
		factoryUuidDef = new CFBamUuidDefDefaultFactory();
		factoryUuidGen = new CFBamUuidGenDefaultFactory();
		factoryUuidType = new CFBamUuidTypeDefaultFactory();
		factoryValue = new CFBamValueDefaultFactory();	}

	public CFBamSchema( CFSecConfigurationFile conf ) {
		if( conf == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"CFBamSchema-constructor",
				1,
				"conf" );
		}
		configuration = conf;
		jndiName = null;

		tableAtom = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableHostNode = null;
		tableISOCcy = null;
		tableISOCtry = null;
		tableISOCtryCcy = null;
		tableISOCtryLang = null;
		tableISOLang = null;
		tableISOTZone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableRelation = null;
		tableRelationCol = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableScope = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGrpInc = null;
		tableSecGrpMemb = null;
		tableSecSession = null;
		tableSecUser = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableService = null;
		tableServiceType = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGrpInc = null;
		tableTSecGrpMemb = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;

		factoryAtom = new CFBamAtomDefaultFactory();
		factoryBlobCol = new CFBamBlobColDefaultFactory();
		factoryBlobDef = new CFBamBlobDefDefaultFactory();
		factoryBlobType = new CFBamBlobTypeDefaultFactory();
		factoryBoolCol = new CFBamBoolColDefaultFactory();
		factoryBoolDef = new CFBamBoolDefDefaultFactory();
		factoryBoolType = new CFBamBoolTypeDefaultFactory();
		factoryChain = new CFBamChainDefaultFactory();
		factoryClearDep = new CFBamClearDepDefaultFactory();
		factoryClearSubDep1 = new CFBamClearSubDep1DefaultFactory();
		factoryClearSubDep2 = new CFBamClearSubDep2DefaultFactory();
		factoryClearSubDep3 = new CFBamClearSubDep3DefaultFactory();
		factoryClearTopDep = new CFBamClearTopDepDefaultFactory();
		factoryCluster = new CFBamClusterDefaultFactory();
		factoryDateCol = new CFBamDateColDefaultFactory();
		factoryDateDef = new CFBamDateDefDefaultFactory();
		factoryDateType = new CFBamDateTypeDefaultFactory();
		factoryDelDep = new CFBamDelDepDefaultFactory();
		factoryDelSubDep1 = new CFBamDelSubDep1DefaultFactory();
		factoryDelSubDep2 = new CFBamDelSubDep2DefaultFactory();
		factoryDelSubDep3 = new CFBamDelSubDep3DefaultFactory();
		factoryDelTopDep = new CFBamDelTopDepDefaultFactory();
		factoryDoubleCol = new CFBamDoubleColDefaultFactory();
		factoryDoubleDef = new CFBamDoubleDefDefaultFactory();
		factoryDoubleType = new CFBamDoubleTypeDefaultFactory();
		factoryEnumDef = new CFBamEnumDefDefaultFactory();
		factoryEnumTag = new CFBamEnumTagDefaultFactory();
		factoryEnumType = new CFBamEnumTypeDefaultFactory();
		factoryFloatCol = new CFBamFloatColDefaultFactory();
		factoryFloatDef = new CFBamFloatDefDefaultFactory();
		factoryFloatType = new CFBamFloatTypeDefaultFactory();
		factoryHostNode = new CFBamHostNodeDefaultFactory();
		factoryISOCcy = new CFBamISOCcyDefaultFactory();
		factoryISOCtry = new CFBamISOCtryDefaultFactory();
		factoryISOCtryCcy = new CFBamISOCtryCcyDefaultFactory();
		factoryISOCtryLang = new CFBamISOCtryLangDefaultFactory();
		factoryISOLang = new CFBamISOLangDefaultFactory();
		factoryISOTZone = new CFBamISOTZoneDefaultFactory();
		factoryId16Gen = new CFBamId16GenDefaultFactory();
		factoryId32Gen = new CFBamId32GenDefaultFactory();
		factoryId64Gen = new CFBamId64GenDefaultFactory();
		factoryIndex = new CFBamIndexDefaultFactory();
		factoryIndexCol = new CFBamIndexColDefaultFactory();
		factoryInt16Col = new CFBamInt16ColDefaultFactory();
		factoryInt16Def = new CFBamInt16DefDefaultFactory();
		factoryInt16Type = new CFBamInt16TypeDefaultFactory();
		factoryInt32Col = new CFBamInt32ColDefaultFactory();
		factoryInt32Def = new CFBamInt32DefDefaultFactory();
		factoryInt32Type = new CFBamInt32TypeDefaultFactory();
		factoryInt64Col = new CFBamInt64ColDefaultFactory();
		factoryInt64Def = new CFBamInt64DefDefaultFactory();
		factoryInt64Type = new CFBamInt64TypeDefaultFactory();
		factoryLicense = new CFBamLicenseDefaultFactory();
		factoryMajorVersion = new CFBamMajorVersionDefaultFactory();
		factoryMimeType = new CFBamMimeTypeDefaultFactory();
		factoryMinorVersion = new CFBamMinorVersionDefaultFactory();
		factoryNmTokenCol = new CFBamNmTokenColDefaultFactory();
		factoryNmTokenDef = new CFBamNmTokenDefDefaultFactory();
		factoryNmTokenType = new CFBamNmTokenTypeDefaultFactory();
		factoryNmTokensCol = new CFBamNmTokensColDefaultFactory();
		factoryNmTokensDef = new CFBamNmTokensDefDefaultFactory();
		factoryNmTokensType = new CFBamNmTokensTypeDefaultFactory();
		factoryNumberCol = new CFBamNumberColDefaultFactory();
		factoryNumberDef = new CFBamNumberDefDefaultFactory();
		factoryNumberType = new CFBamNumberTypeDefaultFactory();
		factoryParam = new CFBamParamDefaultFactory();
		factoryPopDep = new CFBamPopDepDefaultFactory();
		factoryPopSubDep1 = new CFBamPopSubDep1DefaultFactory();
		factoryPopSubDep2 = new CFBamPopSubDep2DefaultFactory();
		factoryPopSubDep3 = new CFBamPopSubDep3DefaultFactory();
		factoryPopTopDep = new CFBamPopTopDepDefaultFactory();
		factoryRelation = new CFBamRelationDefaultFactory();
		factoryRelationCol = new CFBamRelationColDefaultFactory();
		factorySchemaDef = new CFBamSchemaDefDefaultFactory();
		factorySchemaRef = new CFBamSchemaRefDefaultFactory();
		factoryScope = new CFBamScopeDefaultFactory();
		factorySecApp = new CFBamSecAppDefaultFactory();
		factorySecDevice = new CFBamSecDeviceDefaultFactory();
		factorySecForm = new CFBamSecFormDefaultFactory();
		factorySecGroup = new CFBamSecGroupDefaultFactory();
		factorySecGroupForm = new CFBamSecGroupFormDefaultFactory();
		factorySecGrpInc = new CFBamSecGrpIncDefaultFactory();
		factorySecGrpMemb = new CFBamSecGrpMembDefaultFactory();
		factorySecSession = new CFBamSecSessionDefaultFactory();
		factorySecUser = new CFBamSecUserDefaultFactory();
		factoryServerListFunc = new CFBamServerListFuncDefaultFactory();
		factoryServerMethod = new CFBamServerMethodDefaultFactory();
		factoryServerObjFunc = new CFBamServerObjFuncDefaultFactory();
		factoryServerProc = new CFBamServerProcDefaultFactory();
		factoryService = new CFBamServiceDefaultFactory();
		factoryServiceType = new CFBamServiceTypeDefaultFactory();
		factoryStringCol = new CFBamStringColDefaultFactory();
		factoryStringDef = new CFBamStringDefDefaultFactory();
		factoryStringType = new CFBamStringTypeDefaultFactory();
		factorySubProject = new CFBamSubProjectDefaultFactory();
		factorySysCluster = new CFBamSysClusterDefaultFactory();
		factoryTSecGroup = new CFBamTSecGroupDefaultFactory();
		factoryTSecGrpInc = new CFBamTSecGrpIncDefaultFactory();
		factoryTSecGrpMemb = new CFBamTSecGrpMembDefaultFactory();
		factoryTZDateCol = new CFBamTZDateColDefaultFactory();
		factoryTZDateDef = new CFBamTZDateDefDefaultFactory();
		factoryTZDateType = new CFBamTZDateTypeDefaultFactory();
		factoryTZTimeCol = new CFBamTZTimeColDefaultFactory();
		factoryTZTimeDef = new CFBamTZTimeDefDefaultFactory();
		factoryTZTimeType = new CFBamTZTimeTypeDefaultFactory();
		factoryTZTimestampCol = new CFBamTZTimestampColDefaultFactory();
		factoryTZTimestampDef = new CFBamTZTimestampDefDefaultFactory();
		factoryTZTimestampType = new CFBamTZTimestampTypeDefaultFactory();
		factoryTable = new CFBamTableDefaultFactory();
		factoryTableCol = new CFBamTableColDefaultFactory();
		factoryTenant = new CFBamTenantDefaultFactory();
		factoryTextCol = new CFBamTextColDefaultFactory();
		factoryTextDef = new CFBamTextDefDefaultFactory();
		factoryTextType = new CFBamTextTypeDefaultFactory();
		factoryTimeCol = new CFBamTimeColDefaultFactory();
		factoryTimeDef = new CFBamTimeDefDefaultFactory();
		factoryTimeType = new CFBamTimeTypeDefaultFactory();
		factoryTimestampCol = new CFBamTimestampColDefaultFactory();
		factoryTimestampDef = new CFBamTimestampDefDefaultFactory();
		factoryTimestampType = new CFBamTimestampTypeDefaultFactory();
		factoryTld = new CFBamTldDefaultFactory();
		factoryTokenCol = new CFBamTokenColDefaultFactory();
		factoryTokenDef = new CFBamTokenDefDefaultFactory();
		factoryTokenType = new CFBamTokenTypeDefaultFactory();
		factoryTopDomain = new CFBamTopDomainDefaultFactory();
		factoryTopProject = new CFBamTopProjectDefaultFactory();
		factoryUInt16Col = new CFBamUInt16ColDefaultFactory();
		factoryUInt16Def = new CFBamUInt16DefDefaultFactory();
		factoryUInt16Type = new CFBamUInt16TypeDefaultFactory();
		factoryUInt32Col = new CFBamUInt32ColDefaultFactory();
		factoryUInt32Def = new CFBamUInt32DefDefaultFactory();
		factoryUInt32Type = new CFBamUInt32TypeDefaultFactory();
		factoryUInt64Col = new CFBamUInt64ColDefaultFactory();
		factoryUInt64Def = new CFBamUInt64DefDefaultFactory();
		factoryUInt64Type = new CFBamUInt64TypeDefaultFactory();
		factoryURLProtocol = new CFBamURLProtocolDefaultFactory();
		factoryUuidCol = new CFBamUuidColDefaultFactory();
		factoryUuidDef = new CFBamUuidDefDefaultFactory();
		factoryUuidGen = new CFBamUuidGenDefaultFactory();
		factoryUuidType = new CFBamUuidTypeDefaultFactory();
		factoryValue = new CFBamValueDefaultFactory();	}

	public CFBamSchema( String argJndiName ) {
		if( ( argJndiName == null ) || ( argJndiName.length() <= 0 ) ) {
			throw new CFLibEmptyArgumentException( getClass(),
				"CFBamSchema-constructor",
				1,
				"argJndiName" );
		}
		configuration = null;
		jndiName = argJndiName;

		tableAtom = null;
		tableBlobCol = null;
		tableBlobDef = null;
		tableBlobType = null;
		tableBoolCol = null;
		tableBoolDef = null;
		tableBoolType = null;
		tableChain = null;
		tableClearDep = null;
		tableClearSubDep1 = null;
		tableClearSubDep2 = null;
		tableClearSubDep3 = null;
		tableClearTopDep = null;
		tableCluster = null;
		tableDateCol = null;
		tableDateDef = null;
		tableDateType = null;
		tableDelDep = null;
		tableDelSubDep1 = null;
		tableDelSubDep2 = null;
		tableDelSubDep3 = null;
		tableDelTopDep = null;
		tableDoubleCol = null;
		tableDoubleDef = null;
		tableDoubleType = null;
		tableEnumDef = null;
		tableEnumTag = null;
		tableEnumType = null;
		tableFloatCol = null;
		tableFloatDef = null;
		tableFloatType = null;
		tableHostNode = null;
		tableISOCcy = null;
		tableISOCtry = null;
		tableISOCtryCcy = null;
		tableISOCtryLang = null;
		tableISOLang = null;
		tableISOTZone = null;
		tableId16Gen = null;
		tableId32Gen = null;
		tableId64Gen = null;
		tableIndex = null;
		tableIndexCol = null;
		tableInt16Col = null;
		tableInt16Def = null;
		tableInt16Type = null;
		tableInt32Col = null;
		tableInt32Def = null;
		tableInt32Type = null;
		tableInt64Col = null;
		tableInt64Def = null;
		tableInt64Type = null;
		tableLicense = null;
		tableMajorVersion = null;
		tableMimeType = null;
		tableMinorVersion = null;
		tableNmTokenCol = null;
		tableNmTokenDef = null;
		tableNmTokenType = null;
		tableNmTokensCol = null;
		tableNmTokensDef = null;
		tableNmTokensType = null;
		tableNumberCol = null;
		tableNumberDef = null;
		tableNumberType = null;
		tableParam = null;
		tablePopDep = null;
		tablePopSubDep1 = null;
		tablePopSubDep2 = null;
		tablePopSubDep3 = null;
		tablePopTopDep = null;
		tableRelation = null;
		tableRelationCol = null;
		tableSchemaDef = null;
		tableSchemaRef = null;
		tableScope = null;
		tableSecApp = null;
		tableSecDevice = null;
		tableSecForm = null;
		tableSecGroup = null;
		tableSecGroupForm = null;
		tableSecGrpInc = null;
		tableSecGrpMemb = null;
		tableSecSession = null;
		tableSecUser = null;
		tableServerListFunc = null;
		tableServerMethod = null;
		tableServerObjFunc = null;
		tableServerProc = null;
		tableService = null;
		tableServiceType = null;
		tableStringCol = null;
		tableStringDef = null;
		tableStringType = null;
		tableSubProject = null;
		tableSysCluster = null;
		tableTSecGroup = null;
		tableTSecGrpInc = null;
		tableTSecGrpMemb = null;
		tableTZDateCol = null;
		tableTZDateDef = null;
		tableTZDateType = null;
		tableTZTimeCol = null;
		tableTZTimeDef = null;
		tableTZTimeType = null;
		tableTZTimestampCol = null;
		tableTZTimestampDef = null;
		tableTZTimestampType = null;
		tableTable = null;
		tableTableCol = null;
		tableTenant = null;
		tableTextCol = null;
		tableTextDef = null;
		tableTextType = null;
		tableTimeCol = null;
		tableTimeDef = null;
		tableTimeType = null;
		tableTimestampCol = null;
		tableTimestampDef = null;
		tableTimestampType = null;
		tableTld = null;
		tableTokenCol = null;
		tableTokenDef = null;
		tableTokenType = null;
		tableTopDomain = null;
		tableTopProject = null;
		tableUInt16Col = null;
		tableUInt16Def = null;
		tableUInt16Type = null;
		tableUInt32Col = null;
		tableUInt32Def = null;
		tableUInt32Type = null;
		tableUInt64Col = null;
		tableUInt64Def = null;
		tableUInt64Type = null;
		tableURLProtocol = null;
		tableUuidCol = null;
		tableUuidDef = null;
		tableUuidGen = null;
		tableUuidType = null;
		tableValue = null;

		factoryAtom = new CFBamAtomDefaultFactory();
		factoryBlobCol = new CFBamBlobColDefaultFactory();
		factoryBlobDef = new CFBamBlobDefDefaultFactory();
		factoryBlobType = new CFBamBlobTypeDefaultFactory();
		factoryBoolCol = new CFBamBoolColDefaultFactory();
		factoryBoolDef = new CFBamBoolDefDefaultFactory();
		factoryBoolType = new CFBamBoolTypeDefaultFactory();
		factoryChain = new CFBamChainDefaultFactory();
		factoryClearDep = new CFBamClearDepDefaultFactory();
		factoryClearSubDep1 = new CFBamClearSubDep1DefaultFactory();
		factoryClearSubDep2 = new CFBamClearSubDep2DefaultFactory();
		factoryClearSubDep3 = new CFBamClearSubDep3DefaultFactory();
		factoryClearTopDep = new CFBamClearTopDepDefaultFactory();
		factoryCluster = new CFBamClusterDefaultFactory();
		factoryDateCol = new CFBamDateColDefaultFactory();
		factoryDateDef = new CFBamDateDefDefaultFactory();
		factoryDateType = new CFBamDateTypeDefaultFactory();
		factoryDelDep = new CFBamDelDepDefaultFactory();
		factoryDelSubDep1 = new CFBamDelSubDep1DefaultFactory();
		factoryDelSubDep2 = new CFBamDelSubDep2DefaultFactory();
		factoryDelSubDep3 = new CFBamDelSubDep3DefaultFactory();
		factoryDelTopDep = new CFBamDelTopDepDefaultFactory();
		factoryDoubleCol = new CFBamDoubleColDefaultFactory();
		factoryDoubleDef = new CFBamDoubleDefDefaultFactory();
		factoryDoubleType = new CFBamDoubleTypeDefaultFactory();
		factoryEnumDef = new CFBamEnumDefDefaultFactory();
		factoryEnumTag = new CFBamEnumTagDefaultFactory();
		factoryEnumType = new CFBamEnumTypeDefaultFactory();
		factoryFloatCol = new CFBamFloatColDefaultFactory();
		factoryFloatDef = new CFBamFloatDefDefaultFactory();
		factoryFloatType = new CFBamFloatTypeDefaultFactory();
		factoryHostNode = new CFBamHostNodeDefaultFactory();
		factoryISOCcy = new CFBamISOCcyDefaultFactory();
		factoryISOCtry = new CFBamISOCtryDefaultFactory();
		factoryISOCtryCcy = new CFBamISOCtryCcyDefaultFactory();
		factoryISOCtryLang = new CFBamISOCtryLangDefaultFactory();
		factoryISOLang = new CFBamISOLangDefaultFactory();
		factoryISOTZone = new CFBamISOTZoneDefaultFactory();
		factoryId16Gen = new CFBamId16GenDefaultFactory();
		factoryId32Gen = new CFBamId32GenDefaultFactory();
		factoryId64Gen = new CFBamId64GenDefaultFactory();
		factoryIndex = new CFBamIndexDefaultFactory();
		factoryIndexCol = new CFBamIndexColDefaultFactory();
		factoryInt16Col = new CFBamInt16ColDefaultFactory();
		factoryInt16Def = new CFBamInt16DefDefaultFactory();
		factoryInt16Type = new CFBamInt16TypeDefaultFactory();
		factoryInt32Col = new CFBamInt32ColDefaultFactory();
		factoryInt32Def = new CFBamInt32DefDefaultFactory();
		factoryInt32Type = new CFBamInt32TypeDefaultFactory();
		factoryInt64Col = new CFBamInt64ColDefaultFactory();
		factoryInt64Def = new CFBamInt64DefDefaultFactory();
		factoryInt64Type = new CFBamInt64TypeDefaultFactory();
		factoryLicense = new CFBamLicenseDefaultFactory();
		factoryMajorVersion = new CFBamMajorVersionDefaultFactory();
		factoryMimeType = new CFBamMimeTypeDefaultFactory();
		factoryMinorVersion = new CFBamMinorVersionDefaultFactory();
		factoryNmTokenCol = new CFBamNmTokenColDefaultFactory();
		factoryNmTokenDef = new CFBamNmTokenDefDefaultFactory();
		factoryNmTokenType = new CFBamNmTokenTypeDefaultFactory();
		factoryNmTokensCol = new CFBamNmTokensColDefaultFactory();
		factoryNmTokensDef = new CFBamNmTokensDefDefaultFactory();
		factoryNmTokensType = new CFBamNmTokensTypeDefaultFactory();
		factoryNumberCol = new CFBamNumberColDefaultFactory();
		factoryNumberDef = new CFBamNumberDefDefaultFactory();
		factoryNumberType = new CFBamNumberTypeDefaultFactory();
		factoryParam = new CFBamParamDefaultFactory();
		factoryPopDep = new CFBamPopDepDefaultFactory();
		factoryPopSubDep1 = new CFBamPopSubDep1DefaultFactory();
		factoryPopSubDep2 = new CFBamPopSubDep2DefaultFactory();
		factoryPopSubDep3 = new CFBamPopSubDep3DefaultFactory();
		factoryPopTopDep = new CFBamPopTopDepDefaultFactory();
		factoryRelation = new CFBamRelationDefaultFactory();
		factoryRelationCol = new CFBamRelationColDefaultFactory();
		factorySchemaDef = new CFBamSchemaDefDefaultFactory();
		factorySchemaRef = new CFBamSchemaRefDefaultFactory();
		factoryScope = new CFBamScopeDefaultFactory();
		factorySecApp = new CFBamSecAppDefaultFactory();
		factorySecDevice = new CFBamSecDeviceDefaultFactory();
		factorySecForm = new CFBamSecFormDefaultFactory();
		factorySecGroup = new CFBamSecGroupDefaultFactory();
		factorySecGroupForm = new CFBamSecGroupFormDefaultFactory();
		factorySecGrpInc = new CFBamSecGrpIncDefaultFactory();
		factorySecGrpMemb = new CFBamSecGrpMembDefaultFactory();
		factorySecSession = new CFBamSecSessionDefaultFactory();
		factorySecUser = new CFBamSecUserDefaultFactory();
		factoryServerListFunc = new CFBamServerListFuncDefaultFactory();
		factoryServerMethod = new CFBamServerMethodDefaultFactory();
		factoryServerObjFunc = new CFBamServerObjFuncDefaultFactory();
		factoryServerProc = new CFBamServerProcDefaultFactory();
		factoryService = new CFBamServiceDefaultFactory();
		factoryServiceType = new CFBamServiceTypeDefaultFactory();
		factoryStringCol = new CFBamStringColDefaultFactory();
		factoryStringDef = new CFBamStringDefDefaultFactory();
		factoryStringType = new CFBamStringTypeDefaultFactory();
		factorySubProject = new CFBamSubProjectDefaultFactory();
		factorySysCluster = new CFBamSysClusterDefaultFactory();
		factoryTSecGroup = new CFBamTSecGroupDefaultFactory();
		factoryTSecGrpInc = new CFBamTSecGrpIncDefaultFactory();
		factoryTSecGrpMemb = new CFBamTSecGrpMembDefaultFactory();
		factoryTZDateCol = new CFBamTZDateColDefaultFactory();
		factoryTZDateDef = new CFBamTZDateDefDefaultFactory();
		factoryTZDateType = new CFBamTZDateTypeDefaultFactory();
		factoryTZTimeCol = new CFBamTZTimeColDefaultFactory();
		factoryTZTimeDef = new CFBamTZTimeDefDefaultFactory();
		factoryTZTimeType = new CFBamTZTimeTypeDefaultFactory();
		factoryTZTimestampCol = new CFBamTZTimestampColDefaultFactory();
		factoryTZTimestampDef = new CFBamTZTimestampDefDefaultFactory();
		factoryTZTimestampType = new CFBamTZTimestampTypeDefaultFactory();
		factoryTable = new CFBamTableDefaultFactory();
		factoryTableCol = new CFBamTableColDefaultFactory();
		factoryTenant = new CFBamTenantDefaultFactory();
		factoryTextCol = new CFBamTextColDefaultFactory();
		factoryTextDef = new CFBamTextDefDefaultFactory();
		factoryTextType = new CFBamTextTypeDefaultFactory();
		factoryTimeCol = new CFBamTimeColDefaultFactory();
		factoryTimeDef = new CFBamTimeDefDefaultFactory();
		factoryTimeType = new CFBamTimeTypeDefaultFactory();
		factoryTimestampCol = new CFBamTimestampColDefaultFactory();
		factoryTimestampDef = new CFBamTimestampDefDefaultFactory();
		factoryTimestampType = new CFBamTimestampTypeDefaultFactory();
		factoryTld = new CFBamTldDefaultFactory();
		factoryTokenCol = new CFBamTokenColDefaultFactory();
		factoryTokenDef = new CFBamTokenDefDefaultFactory();
		factoryTokenType = new CFBamTokenTypeDefaultFactory();
		factoryTopDomain = new CFBamTopDomainDefaultFactory();
		factoryTopProject = new CFBamTopProjectDefaultFactory();
		factoryUInt16Col = new CFBamUInt16ColDefaultFactory();
		factoryUInt16Def = new CFBamUInt16DefDefaultFactory();
		factoryUInt16Type = new CFBamUInt16TypeDefaultFactory();
		factoryUInt32Col = new CFBamUInt32ColDefaultFactory();
		factoryUInt32Def = new CFBamUInt32DefDefaultFactory();
		factoryUInt32Type = new CFBamUInt32TypeDefaultFactory();
		factoryUInt64Col = new CFBamUInt64ColDefaultFactory();
		factoryUInt64Def = new CFBamUInt64DefDefaultFactory();
		factoryUInt64Type = new CFBamUInt64TypeDefaultFactory();
		factoryURLProtocol = new CFBamURLProtocolDefaultFactory();
		factoryUuidCol = new CFBamUuidColDefaultFactory();
		factoryUuidDef = new CFBamUuidDefDefaultFactory();
		factoryUuidGen = new CFBamUuidGenDefaultFactory();
		factoryUuidType = new CFBamUuidTypeDefaultFactory();
		factoryValue = new CFBamValueDefaultFactory();	}

	/**
	 *	The majority of cases do not have a CFTipClientHandler
	 *	associated with it's persistence implementation.
	 *	Only the XMsg client implementations overload this
	 *	to return the actual CFTipClientHandler associated
	 *	with the connection instance.
	 */
	public CFTipClientHandler getCFTipClientHandler() {
		return( null );
	}

	public String getServerURL() {
		return( null );
	}

	public void setServerURL( String value ) {
	}

	public CFSecConfigurationFile getConfigurationFile() {
		return( configuration );
	}

	public void setConfigurationFile( CFSecConfigurationFile value ) {
		if( value == null ) {
			configuration = null;
		}
		else {
			configuration = value;
			jndiName = null;
		}
	}

	public CFSecAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( CFSecAuthorization value ) {
		authorization = value;
	}

	public String getJndiName() {
		return( jndiName );
	}

	public void setJndiName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			jndiName = null;
		}
		else {
			configuration = null;
			jndiName = value;
		}
	}

	public boolean isConnected() {
		throw new CFLibMustOverrideException( getClass(), "isConnected" );
	}

	public boolean connect() {
		throw new CFLibMustOverrideException( getClass(), "connect" );
	}

	public boolean connect( String username, String password ) {
		throw new CFLibMustOverrideException( getClass(), "connect-userpw" );
	}

	public boolean connect( String loginId, String password, String clusterName, String tenantName ) {
		throw new CFLibMustOverrideException( getClass(), "connect-full" );
	}

	public void disconnect( boolean doCommit ) {
		throw new CFLibMustOverrideException( getClass(), "disconnect" );
	}

	public void logout( CFSecAuthorization auth ) {
		throw new CFLibMustOverrideException( getClass(), "logout" );
	}

	public ICFBamSchema newSchema() {
		throw new CFLibMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Import the contents of the specified file name
	 *	and file contents by applying a SAX Loader parse.
	 */
	public String fileImport( CFSecAuthorization auth, String fileName, String fileContent ) {
		final String S_ProcName = "fileImport";
		throw new CFLibNotImplementedYetException( getClass(),
			S_ProcName,
			"You must overload this method to apply a SAX Parser to the file contents" );
	}

	public short nextISOCtryIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextISOCtryIdGen" );
	}

	public short nextISOCcyIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextISOCcyIdGen" );
	}

	public short nextISOLangIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextISOLangIdGen" );
	}

	public short nextISOTZoneIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextISOTZoneIdGen" );
	}

	public int nextServiceTypeIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextServiceTypeIdGen" );
	}

	public int nextMimeTypeIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextMimeTypeIdGen" );
	}

	public int nextURLProtocolIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextURLProtocolIdGen" );
	}

	public long nextClusterIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextClusterIdGen" );
	}

	public long nextTenantIdGen() {
		throw new CFLibNotImplementedYetException( getClass(), "nextTenantIdGen" );
	}

	public UUID nextSecSessionIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public UUID nextSecUserIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public ICFBamAtomTable getTableAtom() {
		return( tableAtom );
	}

	public void setTableAtom( ICFBamAtomTable value ) {
		tableAtom = value;
	}

	public ICFBamAtomFactory getFactoryAtom() {
		return( factoryAtom );
	}

	public void setFactoryAtom( ICFBamAtomFactory value ) {
		factoryAtom = value;
	}

	public ICFBamBlobColTable getTableBlobCol() {
		return( tableBlobCol );
	}

	public void setTableBlobCol( ICFBamBlobColTable value ) {
		tableBlobCol = value;
	}

	public ICFBamBlobColFactory getFactoryBlobCol() {
		return( factoryBlobCol );
	}

	public void setFactoryBlobCol( ICFBamBlobColFactory value ) {
		factoryBlobCol = value;
	}

	public ICFBamBlobDefTable getTableBlobDef() {
		return( tableBlobDef );
	}

	public void setTableBlobDef( ICFBamBlobDefTable value ) {
		tableBlobDef = value;
	}

	public ICFBamBlobDefFactory getFactoryBlobDef() {
		return( factoryBlobDef );
	}

	public void setFactoryBlobDef( ICFBamBlobDefFactory value ) {
		factoryBlobDef = value;
	}

	public ICFBamBlobTypeTable getTableBlobType() {
		return( tableBlobType );
	}

	public void setTableBlobType( ICFBamBlobTypeTable value ) {
		tableBlobType = value;
	}

	public ICFBamBlobTypeFactory getFactoryBlobType() {
		return( factoryBlobType );
	}

	public void setFactoryBlobType( ICFBamBlobTypeFactory value ) {
		factoryBlobType = value;
	}

	public ICFBamBoolColTable getTableBoolCol() {
		return( tableBoolCol );
	}

	public void setTableBoolCol( ICFBamBoolColTable value ) {
		tableBoolCol = value;
	}

	public ICFBamBoolColFactory getFactoryBoolCol() {
		return( factoryBoolCol );
	}

	public void setFactoryBoolCol( ICFBamBoolColFactory value ) {
		factoryBoolCol = value;
	}

	public ICFBamBoolDefTable getTableBoolDef() {
		return( tableBoolDef );
	}

	public void setTableBoolDef( ICFBamBoolDefTable value ) {
		tableBoolDef = value;
	}

	public ICFBamBoolDefFactory getFactoryBoolDef() {
		return( factoryBoolDef );
	}

	public void setFactoryBoolDef( ICFBamBoolDefFactory value ) {
		factoryBoolDef = value;
	}

	public ICFBamBoolTypeTable getTableBoolType() {
		return( tableBoolType );
	}

	public void setTableBoolType( ICFBamBoolTypeTable value ) {
		tableBoolType = value;
	}

	public ICFBamBoolTypeFactory getFactoryBoolType() {
		return( factoryBoolType );
	}

	public void setFactoryBoolType( ICFBamBoolTypeFactory value ) {
		factoryBoolType = value;
	}

	public ICFBamChainTable getTableChain() {
		return( tableChain );
	}

	public void setTableChain( ICFBamChainTable value ) {
		tableChain = value;
	}

	public ICFBamChainFactory getFactoryChain() {
		return( factoryChain );
	}

	public void setFactoryChain( ICFBamChainFactory value ) {
		factoryChain = value;
	}

	public ICFBamClearDepTable getTableClearDep() {
		return( tableClearDep );
	}

	public void setTableClearDep( ICFBamClearDepTable value ) {
		tableClearDep = value;
	}

	public ICFBamClearDepFactory getFactoryClearDep() {
		return( factoryClearDep );
	}

	public void setFactoryClearDep( ICFBamClearDepFactory value ) {
		factoryClearDep = value;
	}

	public ICFBamClearSubDep1Table getTableClearSubDep1() {
		return( tableClearSubDep1 );
	}

	public void setTableClearSubDep1( ICFBamClearSubDep1Table value ) {
		tableClearSubDep1 = value;
	}

	public ICFBamClearSubDep1Factory getFactoryClearSubDep1() {
		return( factoryClearSubDep1 );
	}

	public void setFactoryClearSubDep1( ICFBamClearSubDep1Factory value ) {
		factoryClearSubDep1 = value;
	}

	public ICFBamClearSubDep2Table getTableClearSubDep2() {
		return( tableClearSubDep2 );
	}

	public void setTableClearSubDep2( ICFBamClearSubDep2Table value ) {
		tableClearSubDep2 = value;
	}

	public ICFBamClearSubDep2Factory getFactoryClearSubDep2() {
		return( factoryClearSubDep2 );
	}

	public void setFactoryClearSubDep2( ICFBamClearSubDep2Factory value ) {
		factoryClearSubDep2 = value;
	}

	public ICFBamClearSubDep3Table getTableClearSubDep3() {
		return( tableClearSubDep3 );
	}

	public void setTableClearSubDep3( ICFBamClearSubDep3Table value ) {
		tableClearSubDep3 = value;
	}

	public ICFBamClearSubDep3Factory getFactoryClearSubDep3() {
		return( factoryClearSubDep3 );
	}

	public void setFactoryClearSubDep3( ICFBamClearSubDep3Factory value ) {
		factoryClearSubDep3 = value;
	}

	public ICFBamClearTopDepTable getTableClearTopDep() {
		return( tableClearTopDep );
	}

	public void setTableClearTopDep( ICFBamClearTopDepTable value ) {
		tableClearTopDep = value;
	}

	public ICFBamClearTopDepFactory getFactoryClearTopDep() {
		return( factoryClearTopDep );
	}

	public void setFactoryClearTopDep( ICFBamClearTopDepFactory value ) {
		factoryClearTopDep = value;
	}

	public ICFSecClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ICFSecClusterTable value ) {
		tableCluster = value;
	}

	public ICFSecClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	public void setFactoryCluster( ICFSecClusterFactory value ) {
		factoryCluster = value;
	}

	public ICFBamDateColTable getTableDateCol() {
		return( tableDateCol );
	}

	public void setTableDateCol( ICFBamDateColTable value ) {
		tableDateCol = value;
	}

	public ICFBamDateColFactory getFactoryDateCol() {
		return( factoryDateCol );
	}

	public void setFactoryDateCol( ICFBamDateColFactory value ) {
		factoryDateCol = value;
	}

	public ICFBamDateDefTable getTableDateDef() {
		return( tableDateDef );
	}

	public void setTableDateDef( ICFBamDateDefTable value ) {
		tableDateDef = value;
	}

	public ICFBamDateDefFactory getFactoryDateDef() {
		return( factoryDateDef );
	}

	public void setFactoryDateDef( ICFBamDateDefFactory value ) {
		factoryDateDef = value;
	}

	public ICFBamDateTypeTable getTableDateType() {
		return( tableDateType );
	}

	public void setTableDateType( ICFBamDateTypeTable value ) {
		tableDateType = value;
	}

	public ICFBamDateTypeFactory getFactoryDateType() {
		return( factoryDateType );
	}

	public void setFactoryDateType( ICFBamDateTypeFactory value ) {
		factoryDateType = value;
	}

	public ICFBamDelDepTable getTableDelDep() {
		return( tableDelDep );
	}

	public void setTableDelDep( ICFBamDelDepTable value ) {
		tableDelDep = value;
	}

	public ICFBamDelDepFactory getFactoryDelDep() {
		return( factoryDelDep );
	}

	public void setFactoryDelDep( ICFBamDelDepFactory value ) {
		factoryDelDep = value;
	}

	public ICFBamDelSubDep1Table getTableDelSubDep1() {
		return( tableDelSubDep1 );
	}

	public void setTableDelSubDep1( ICFBamDelSubDep1Table value ) {
		tableDelSubDep1 = value;
	}

	public ICFBamDelSubDep1Factory getFactoryDelSubDep1() {
		return( factoryDelSubDep1 );
	}

	public void setFactoryDelSubDep1( ICFBamDelSubDep1Factory value ) {
		factoryDelSubDep1 = value;
	}

	public ICFBamDelSubDep2Table getTableDelSubDep2() {
		return( tableDelSubDep2 );
	}

	public void setTableDelSubDep2( ICFBamDelSubDep2Table value ) {
		tableDelSubDep2 = value;
	}

	public ICFBamDelSubDep2Factory getFactoryDelSubDep2() {
		return( factoryDelSubDep2 );
	}

	public void setFactoryDelSubDep2( ICFBamDelSubDep2Factory value ) {
		factoryDelSubDep2 = value;
	}

	public ICFBamDelSubDep3Table getTableDelSubDep3() {
		return( tableDelSubDep3 );
	}

	public void setTableDelSubDep3( ICFBamDelSubDep3Table value ) {
		tableDelSubDep3 = value;
	}

	public ICFBamDelSubDep3Factory getFactoryDelSubDep3() {
		return( factoryDelSubDep3 );
	}

	public void setFactoryDelSubDep3( ICFBamDelSubDep3Factory value ) {
		factoryDelSubDep3 = value;
	}

	public ICFBamDelTopDepTable getTableDelTopDep() {
		return( tableDelTopDep );
	}

	public void setTableDelTopDep( ICFBamDelTopDepTable value ) {
		tableDelTopDep = value;
	}

	public ICFBamDelTopDepFactory getFactoryDelTopDep() {
		return( factoryDelTopDep );
	}

	public void setFactoryDelTopDep( ICFBamDelTopDepFactory value ) {
		factoryDelTopDep = value;
	}

	public ICFBamDoubleColTable getTableDoubleCol() {
		return( tableDoubleCol );
	}

	public void setTableDoubleCol( ICFBamDoubleColTable value ) {
		tableDoubleCol = value;
	}

	public ICFBamDoubleColFactory getFactoryDoubleCol() {
		return( factoryDoubleCol );
	}

	public void setFactoryDoubleCol( ICFBamDoubleColFactory value ) {
		factoryDoubleCol = value;
	}

	public ICFBamDoubleDefTable getTableDoubleDef() {
		return( tableDoubleDef );
	}

	public void setTableDoubleDef( ICFBamDoubleDefTable value ) {
		tableDoubleDef = value;
	}

	public ICFBamDoubleDefFactory getFactoryDoubleDef() {
		return( factoryDoubleDef );
	}

	public void setFactoryDoubleDef( ICFBamDoubleDefFactory value ) {
		factoryDoubleDef = value;
	}

	public ICFBamDoubleTypeTable getTableDoubleType() {
		return( tableDoubleType );
	}

	public void setTableDoubleType( ICFBamDoubleTypeTable value ) {
		tableDoubleType = value;
	}

	public ICFBamDoubleTypeFactory getFactoryDoubleType() {
		return( factoryDoubleType );
	}

	public void setFactoryDoubleType( ICFBamDoubleTypeFactory value ) {
		factoryDoubleType = value;
	}

	public ICFBamEnumDefTable getTableEnumDef() {
		return( tableEnumDef );
	}

	public void setTableEnumDef( ICFBamEnumDefTable value ) {
		tableEnumDef = value;
	}

	public ICFBamEnumDefFactory getFactoryEnumDef() {
		return( factoryEnumDef );
	}

	public void setFactoryEnumDef( ICFBamEnumDefFactory value ) {
		factoryEnumDef = value;
	}

	public ICFBamEnumTagTable getTableEnumTag() {
		return( tableEnumTag );
	}

	public void setTableEnumTag( ICFBamEnumTagTable value ) {
		tableEnumTag = value;
	}

	public ICFBamEnumTagFactory getFactoryEnumTag() {
		return( factoryEnumTag );
	}

	public void setFactoryEnumTag( ICFBamEnumTagFactory value ) {
		factoryEnumTag = value;
	}

	public ICFBamEnumTypeTable getTableEnumType() {
		return( tableEnumType );
	}

	public void setTableEnumType( ICFBamEnumTypeTable value ) {
		tableEnumType = value;
	}

	public ICFBamEnumTypeFactory getFactoryEnumType() {
		return( factoryEnumType );
	}

	public void setFactoryEnumType( ICFBamEnumTypeFactory value ) {
		factoryEnumType = value;
	}

	public ICFBamFloatColTable getTableFloatCol() {
		return( tableFloatCol );
	}

	public void setTableFloatCol( ICFBamFloatColTable value ) {
		tableFloatCol = value;
	}

	public ICFBamFloatColFactory getFactoryFloatCol() {
		return( factoryFloatCol );
	}

	public void setFactoryFloatCol( ICFBamFloatColFactory value ) {
		factoryFloatCol = value;
	}

	public ICFBamFloatDefTable getTableFloatDef() {
		return( tableFloatDef );
	}

	public void setTableFloatDef( ICFBamFloatDefTable value ) {
		tableFloatDef = value;
	}

	public ICFBamFloatDefFactory getFactoryFloatDef() {
		return( factoryFloatDef );
	}

	public void setFactoryFloatDef( ICFBamFloatDefFactory value ) {
		factoryFloatDef = value;
	}

	public ICFBamFloatTypeTable getTableFloatType() {
		return( tableFloatType );
	}

	public void setTableFloatType( ICFBamFloatTypeTable value ) {
		tableFloatType = value;
	}

	public ICFBamFloatTypeFactory getFactoryFloatType() {
		return( factoryFloatType );
	}

	public void setFactoryFloatType( ICFBamFloatTypeFactory value ) {
		factoryFloatType = value;
	}

	public ICFSecHostNodeTable getTableHostNode() {
		return( tableHostNode );
	}

	public void setTableHostNode( ICFSecHostNodeTable value ) {
		tableHostNode = value;
	}

	public ICFSecHostNodeFactory getFactoryHostNode() {
		return( factoryHostNode );
	}

	public void setFactoryHostNode( ICFSecHostNodeFactory value ) {
		factoryHostNode = value;
	}

	public ICFSecISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ICFSecISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ICFSecISOCcyFactory getFactoryISOCcy() {
		return( factoryISOCcy );
	}

	public void setFactoryISOCcy( ICFSecISOCcyFactory value ) {
		factoryISOCcy = value;
	}

	public ICFSecISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ICFSecISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ICFSecISOCtryFactory getFactoryISOCtry() {
		return( factoryISOCtry );
	}

	public void setFactoryISOCtry( ICFSecISOCtryFactory value ) {
		factoryISOCtry = value;
	}

	public ICFSecISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ICFSecISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ICFSecISOCtryCcyFactory getFactoryISOCtryCcy() {
		return( factoryISOCtryCcy );
	}

	public void setFactoryISOCtryCcy( ICFSecISOCtryCcyFactory value ) {
		factoryISOCtryCcy = value;
	}

	public ICFSecISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ICFSecISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ICFSecISOCtryLangFactory getFactoryISOCtryLang() {
		return( factoryISOCtryLang );
	}

	public void setFactoryISOCtryLang( ICFSecISOCtryLangFactory value ) {
		factoryISOCtryLang = value;
	}

	public ICFSecISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ICFSecISOLangTable value ) {
		tableISOLang = value;
	}

	public ICFSecISOLangFactory getFactoryISOLang() {
		return( factoryISOLang );
	}

	public void setFactoryISOLang( ICFSecISOLangFactory value ) {
		factoryISOLang = value;
	}

	public ICFSecISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ICFSecISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public ICFSecISOTZoneFactory getFactoryISOTZone() {
		return( factoryISOTZone );
	}

	public void setFactoryISOTZone( ICFSecISOTZoneFactory value ) {
		factoryISOTZone = value;
	}

	public ICFBamId16GenTable getTableId16Gen() {
		return( tableId16Gen );
	}

	public void setTableId16Gen( ICFBamId16GenTable value ) {
		tableId16Gen = value;
	}

	public ICFBamId16GenFactory getFactoryId16Gen() {
		return( factoryId16Gen );
	}

	public void setFactoryId16Gen( ICFBamId16GenFactory value ) {
		factoryId16Gen = value;
	}

	public ICFBamId32GenTable getTableId32Gen() {
		return( tableId32Gen );
	}

	public void setTableId32Gen( ICFBamId32GenTable value ) {
		tableId32Gen = value;
	}

	public ICFBamId32GenFactory getFactoryId32Gen() {
		return( factoryId32Gen );
	}

	public void setFactoryId32Gen( ICFBamId32GenFactory value ) {
		factoryId32Gen = value;
	}

	public ICFBamId64GenTable getTableId64Gen() {
		return( tableId64Gen );
	}

	public void setTableId64Gen( ICFBamId64GenTable value ) {
		tableId64Gen = value;
	}

	public ICFBamId64GenFactory getFactoryId64Gen() {
		return( factoryId64Gen );
	}

	public void setFactoryId64Gen( ICFBamId64GenFactory value ) {
		factoryId64Gen = value;
	}

	public ICFBamIndexTable getTableIndex() {
		return( tableIndex );
	}

	public void setTableIndex( ICFBamIndexTable value ) {
		tableIndex = value;
	}

	public ICFBamIndexFactory getFactoryIndex() {
		return( factoryIndex );
	}

	public void setFactoryIndex( ICFBamIndexFactory value ) {
		factoryIndex = value;
	}

	public ICFBamIndexColTable getTableIndexCol() {
		return( tableIndexCol );
	}

	public void setTableIndexCol( ICFBamIndexColTable value ) {
		tableIndexCol = value;
	}

	public ICFBamIndexColFactory getFactoryIndexCol() {
		return( factoryIndexCol );
	}

	public void setFactoryIndexCol( ICFBamIndexColFactory value ) {
		factoryIndexCol = value;
	}

	public ICFBamInt16ColTable getTableInt16Col() {
		return( tableInt16Col );
	}

	public void setTableInt16Col( ICFBamInt16ColTable value ) {
		tableInt16Col = value;
	}

	public ICFBamInt16ColFactory getFactoryInt16Col() {
		return( factoryInt16Col );
	}

	public void setFactoryInt16Col( ICFBamInt16ColFactory value ) {
		factoryInt16Col = value;
	}

	public ICFBamInt16DefTable getTableInt16Def() {
		return( tableInt16Def );
	}

	public void setTableInt16Def( ICFBamInt16DefTable value ) {
		tableInt16Def = value;
	}

	public ICFBamInt16DefFactory getFactoryInt16Def() {
		return( factoryInt16Def );
	}

	public void setFactoryInt16Def( ICFBamInt16DefFactory value ) {
		factoryInt16Def = value;
	}

	public ICFBamInt16TypeTable getTableInt16Type() {
		return( tableInt16Type );
	}

	public void setTableInt16Type( ICFBamInt16TypeTable value ) {
		tableInt16Type = value;
	}

	public ICFBamInt16TypeFactory getFactoryInt16Type() {
		return( factoryInt16Type );
	}

	public void setFactoryInt16Type( ICFBamInt16TypeFactory value ) {
		factoryInt16Type = value;
	}

	public ICFBamInt32ColTable getTableInt32Col() {
		return( tableInt32Col );
	}

	public void setTableInt32Col( ICFBamInt32ColTable value ) {
		tableInt32Col = value;
	}

	public ICFBamInt32ColFactory getFactoryInt32Col() {
		return( factoryInt32Col );
	}

	public void setFactoryInt32Col( ICFBamInt32ColFactory value ) {
		factoryInt32Col = value;
	}

	public ICFBamInt32DefTable getTableInt32Def() {
		return( tableInt32Def );
	}

	public void setTableInt32Def( ICFBamInt32DefTable value ) {
		tableInt32Def = value;
	}

	public ICFBamInt32DefFactory getFactoryInt32Def() {
		return( factoryInt32Def );
	}

	public void setFactoryInt32Def( ICFBamInt32DefFactory value ) {
		factoryInt32Def = value;
	}

	public ICFBamInt32TypeTable getTableInt32Type() {
		return( tableInt32Type );
	}

	public void setTableInt32Type( ICFBamInt32TypeTable value ) {
		tableInt32Type = value;
	}

	public ICFBamInt32TypeFactory getFactoryInt32Type() {
		return( factoryInt32Type );
	}

	public void setFactoryInt32Type( ICFBamInt32TypeFactory value ) {
		factoryInt32Type = value;
	}

	public ICFBamInt64ColTable getTableInt64Col() {
		return( tableInt64Col );
	}

	public void setTableInt64Col( ICFBamInt64ColTable value ) {
		tableInt64Col = value;
	}

	public ICFBamInt64ColFactory getFactoryInt64Col() {
		return( factoryInt64Col );
	}

	public void setFactoryInt64Col( ICFBamInt64ColFactory value ) {
		factoryInt64Col = value;
	}

	public ICFBamInt64DefTable getTableInt64Def() {
		return( tableInt64Def );
	}

	public void setTableInt64Def( ICFBamInt64DefTable value ) {
		tableInt64Def = value;
	}

	public ICFBamInt64DefFactory getFactoryInt64Def() {
		return( factoryInt64Def );
	}

	public void setFactoryInt64Def( ICFBamInt64DefFactory value ) {
		factoryInt64Def = value;
	}

	public ICFBamInt64TypeTable getTableInt64Type() {
		return( tableInt64Type );
	}

	public void setTableInt64Type( ICFBamInt64TypeTable value ) {
		tableInt64Type = value;
	}

	public ICFBamInt64TypeFactory getFactoryInt64Type() {
		return( factoryInt64Type );
	}

	public void setFactoryInt64Type( ICFBamInt64TypeFactory value ) {
		factoryInt64Type = value;
	}

	public ICFIntLicenseTable getTableLicense() {
		return( tableLicense );
	}

	public void setTableLicense( ICFIntLicenseTable value ) {
		tableLicense = value;
	}

	public ICFIntLicenseFactory getFactoryLicense() {
		return( factoryLicense );
	}

	public void setFactoryLicense( ICFIntLicenseFactory value ) {
		factoryLicense = value;
	}

	public ICFIntMajorVersionTable getTableMajorVersion() {
		return( tableMajorVersion );
	}

	public void setTableMajorVersion( ICFIntMajorVersionTable value ) {
		tableMajorVersion = value;
	}

	public ICFIntMajorVersionFactory getFactoryMajorVersion() {
		return( factoryMajorVersion );
	}

	public void setFactoryMajorVersion( ICFIntMajorVersionFactory value ) {
		factoryMajorVersion = value;
	}

	public ICFIntMimeTypeTable getTableMimeType() {
		return( tableMimeType );
	}

	public void setTableMimeType( ICFIntMimeTypeTable value ) {
		tableMimeType = value;
	}

	public ICFIntMimeTypeFactory getFactoryMimeType() {
		return( factoryMimeType );
	}

	public void setFactoryMimeType( ICFIntMimeTypeFactory value ) {
		factoryMimeType = value;
	}

	public ICFIntMinorVersionTable getTableMinorVersion() {
		return( tableMinorVersion );
	}

	public void setTableMinorVersion( ICFIntMinorVersionTable value ) {
		tableMinorVersion = value;
	}

	public ICFIntMinorVersionFactory getFactoryMinorVersion() {
		return( factoryMinorVersion );
	}

	public void setFactoryMinorVersion( ICFIntMinorVersionFactory value ) {
		factoryMinorVersion = value;
	}

	public ICFBamNmTokenColTable getTableNmTokenCol() {
		return( tableNmTokenCol );
	}

	public void setTableNmTokenCol( ICFBamNmTokenColTable value ) {
		tableNmTokenCol = value;
	}

	public ICFBamNmTokenColFactory getFactoryNmTokenCol() {
		return( factoryNmTokenCol );
	}

	public void setFactoryNmTokenCol( ICFBamNmTokenColFactory value ) {
		factoryNmTokenCol = value;
	}

	public ICFBamNmTokenDefTable getTableNmTokenDef() {
		return( tableNmTokenDef );
	}

	public void setTableNmTokenDef( ICFBamNmTokenDefTable value ) {
		tableNmTokenDef = value;
	}

	public ICFBamNmTokenDefFactory getFactoryNmTokenDef() {
		return( factoryNmTokenDef );
	}

	public void setFactoryNmTokenDef( ICFBamNmTokenDefFactory value ) {
		factoryNmTokenDef = value;
	}

	public ICFBamNmTokenTypeTable getTableNmTokenType() {
		return( tableNmTokenType );
	}

	public void setTableNmTokenType( ICFBamNmTokenTypeTable value ) {
		tableNmTokenType = value;
	}

	public ICFBamNmTokenTypeFactory getFactoryNmTokenType() {
		return( factoryNmTokenType );
	}

	public void setFactoryNmTokenType( ICFBamNmTokenTypeFactory value ) {
		factoryNmTokenType = value;
	}

	public ICFBamNmTokensColTable getTableNmTokensCol() {
		return( tableNmTokensCol );
	}

	public void setTableNmTokensCol( ICFBamNmTokensColTable value ) {
		tableNmTokensCol = value;
	}

	public ICFBamNmTokensColFactory getFactoryNmTokensCol() {
		return( factoryNmTokensCol );
	}

	public void setFactoryNmTokensCol( ICFBamNmTokensColFactory value ) {
		factoryNmTokensCol = value;
	}

	public ICFBamNmTokensDefTable getTableNmTokensDef() {
		return( tableNmTokensDef );
	}

	public void setTableNmTokensDef( ICFBamNmTokensDefTable value ) {
		tableNmTokensDef = value;
	}

	public ICFBamNmTokensDefFactory getFactoryNmTokensDef() {
		return( factoryNmTokensDef );
	}

	public void setFactoryNmTokensDef( ICFBamNmTokensDefFactory value ) {
		factoryNmTokensDef = value;
	}

	public ICFBamNmTokensTypeTable getTableNmTokensType() {
		return( tableNmTokensType );
	}

	public void setTableNmTokensType( ICFBamNmTokensTypeTable value ) {
		tableNmTokensType = value;
	}

	public ICFBamNmTokensTypeFactory getFactoryNmTokensType() {
		return( factoryNmTokensType );
	}

	public void setFactoryNmTokensType( ICFBamNmTokensTypeFactory value ) {
		factoryNmTokensType = value;
	}

	public ICFBamNumberColTable getTableNumberCol() {
		return( tableNumberCol );
	}

	public void setTableNumberCol( ICFBamNumberColTable value ) {
		tableNumberCol = value;
	}

	public ICFBamNumberColFactory getFactoryNumberCol() {
		return( factoryNumberCol );
	}

	public void setFactoryNumberCol( ICFBamNumberColFactory value ) {
		factoryNumberCol = value;
	}

	public ICFBamNumberDefTable getTableNumberDef() {
		return( tableNumberDef );
	}

	public void setTableNumberDef( ICFBamNumberDefTable value ) {
		tableNumberDef = value;
	}

	public ICFBamNumberDefFactory getFactoryNumberDef() {
		return( factoryNumberDef );
	}

	public void setFactoryNumberDef( ICFBamNumberDefFactory value ) {
		factoryNumberDef = value;
	}

	public ICFBamNumberTypeTable getTableNumberType() {
		return( tableNumberType );
	}

	public void setTableNumberType( ICFBamNumberTypeTable value ) {
		tableNumberType = value;
	}

	public ICFBamNumberTypeFactory getFactoryNumberType() {
		return( factoryNumberType );
	}

	public void setFactoryNumberType( ICFBamNumberTypeFactory value ) {
		factoryNumberType = value;
	}

	public ICFBamParamTable getTableParam() {
		return( tableParam );
	}

	public void setTableParam( ICFBamParamTable value ) {
		tableParam = value;
	}

	public ICFBamParamFactory getFactoryParam() {
		return( factoryParam );
	}

	public void setFactoryParam( ICFBamParamFactory value ) {
		factoryParam = value;
	}

	public ICFBamPopDepTable getTablePopDep() {
		return( tablePopDep );
	}

	public void setTablePopDep( ICFBamPopDepTable value ) {
		tablePopDep = value;
	}

	public ICFBamPopDepFactory getFactoryPopDep() {
		return( factoryPopDep );
	}

	public void setFactoryPopDep( ICFBamPopDepFactory value ) {
		factoryPopDep = value;
	}

	public ICFBamPopSubDep1Table getTablePopSubDep1() {
		return( tablePopSubDep1 );
	}

	public void setTablePopSubDep1( ICFBamPopSubDep1Table value ) {
		tablePopSubDep1 = value;
	}

	public ICFBamPopSubDep1Factory getFactoryPopSubDep1() {
		return( factoryPopSubDep1 );
	}

	public void setFactoryPopSubDep1( ICFBamPopSubDep1Factory value ) {
		factoryPopSubDep1 = value;
	}

	public ICFBamPopSubDep2Table getTablePopSubDep2() {
		return( tablePopSubDep2 );
	}

	public void setTablePopSubDep2( ICFBamPopSubDep2Table value ) {
		tablePopSubDep2 = value;
	}

	public ICFBamPopSubDep2Factory getFactoryPopSubDep2() {
		return( factoryPopSubDep2 );
	}

	public void setFactoryPopSubDep2( ICFBamPopSubDep2Factory value ) {
		factoryPopSubDep2 = value;
	}

	public ICFBamPopSubDep3Table getTablePopSubDep3() {
		return( tablePopSubDep3 );
	}

	public void setTablePopSubDep3( ICFBamPopSubDep3Table value ) {
		tablePopSubDep3 = value;
	}

	public ICFBamPopSubDep3Factory getFactoryPopSubDep3() {
		return( factoryPopSubDep3 );
	}

	public void setFactoryPopSubDep3( ICFBamPopSubDep3Factory value ) {
		factoryPopSubDep3 = value;
	}

	public ICFBamPopTopDepTable getTablePopTopDep() {
		return( tablePopTopDep );
	}

	public void setTablePopTopDep( ICFBamPopTopDepTable value ) {
		tablePopTopDep = value;
	}

	public ICFBamPopTopDepFactory getFactoryPopTopDep() {
		return( factoryPopTopDep );
	}

	public void setFactoryPopTopDep( ICFBamPopTopDepFactory value ) {
		factoryPopTopDep = value;
	}

	public ICFBamRelationTable getTableRelation() {
		return( tableRelation );
	}

	public void setTableRelation( ICFBamRelationTable value ) {
		tableRelation = value;
	}

	public ICFBamRelationFactory getFactoryRelation() {
		return( factoryRelation );
	}

	public void setFactoryRelation( ICFBamRelationFactory value ) {
		factoryRelation = value;
	}

	public ICFBamRelationColTable getTableRelationCol() {
		return( tableRelationCol );
	}

	public void setTableRelationCol( ICFBamRelationColTable value ) {
		tableRelationCol = value;
	}

	public ICFBamRelationColFactory getFactoryRelationCol() {
		return( factoryRelationCol );
	}

	public void setFactoryRelationCol( ICFBamRelationColFactory value ) {
		factoryRelationCol = value;
	}

	public ICFBamSchemaDefTable getTableSchemaDef() {
		return( tableSchemaDef );
	}

	public void setTableSchemaDef( ICFBamSchemaDefTable value ) {
		tableSchemaDef = value;
	}

	public ICFBamSchemaDefFactory getFactorySchemaDef() {
		return( factorySchemaDef );
	}

	public void setFactorySchemaDef( ICFBamSchemaDefFactory value ) {
		factorySchemaDef = value;
	}

	public ICFBamSchemaRefTable getTableSchemaRef() {
		return( tableSchemaRef );
	}

	public void setTableSchemaRef( ICFBamSchemaRefTable value ) {
		tableSchemaRef = value;
	}

	public ICFBamSchemaRefFactory getFactorySchemaRef() {
		return( factorySchemaRef );
	}

	public void setFactorySchemaRef( ICFBamSchemaRefFactory value ) {
		factorySchemaRef = value;
	}

	public ICFBamScopeTable getTableScope() {
		return( tableScope );
	}

	public void setTableScope( ICFBamScopeTable value ) {
		tableScope = value;
	}

	public ICFBamScopeFactory getFactoryScope() {
		return( factoryScope );
	}

	public void setFactoryScope( ICFBamScopeFactory value ) {
		factoryScope = value;
	}

	public ICFSecSecAppTable getTableSecApp() {
		return( tableSecApp );
	}

	public void setTableSecApp( ICFSecSecAppTable value ) {
		tableSecApp = value;
	}

	public ICFSecSecAppFactory getFactorySecApp() {
		return( factorySecApp );
	}

	public void setFactorySecApp( ICFSecSecAppFactory value ) {
		factorySecApp = value;
	}

	public ICFSecSecDeviceTable getTableSecDevice() {
		return( tableSecDevice );
	}

	public void setTableSecDevice( ICFSecSecDeviceTable value ) {
		tableSecDevice = value;
	}

	public ICFSecSecDeviceFactory getFactorySecDevice() {
		return( factorySecDevice );
	}

	public void setFactorySecDevice( ICFSecSecDeviceFactory value ) {
		factorySecDevice = value;
	}

	public ICFSecSecFormTable getTableSecForm() {
		return( tableSecForm );
	}

	public void setTableSecForm( ICFSecSecFormTable value ) {
		tableSecForm = value;
	}

	public ICFSecSecFormFactory getFactorySecForm() {
		return( factorySecForm );
	}

	public void setFactorySecForm( ICFSecSecFormFactory value ) {
		factorySecForm = value;
	}

	public ICFSecSecGroupTable getTableSecGroup() {
		return( tableSecGroup );
	}

	public void setTableSecGroup( ICFSecSecGroupTable value ) {
		tableSecGroup = value;
	}

	public ICFSecSecGroupFactory getFactorySecGroup() {
		return( factorySecGroup );
	}

	public void setFactorySecGroup( ICFSecSecGroupFactory value ) {
		factorySecGroup = value;
	}

	public ICFSecSecGroupFormTable getTableSecGroupForm() {
		return( tableSecGroupForm );
	}

	public void setTableSecGroupForm( ICFSecSecGroupFormTable value ) {
		tableSecGroupForm = value;
	}

	public ICFSecSecGroupFormFactory getFactorySecGroupForm() {
		return( factorySecGroupForm );
	}

	public void setFactorySecGroupForm( ICFSecSecGroupFormFactory value ) {
		factorySecGroupForm = value;
	}

	public ICFSecSecGrpIncTable getTableSecGrpInc() {
		return( tableSecGrpInc );
	}

	public void setTableSecGrpInc( ICFSecSecGrpIncTable value ) {
		tableSecGrpInc = value;
	}

	public ICFSecSecGrpIncFactory getFactorySecGrpInc() {
		return( factorySecGrpInc );
	}

	public void setFactorySecGrpInc( ICFSecSecGrpIncFactory value ) {
		factorySecGrpInc = value;
	}

	public ICFSecSecGrpMembTable getTableSecGrpMemb() {
		return( tableSecGrpMemb );
	}

	public void setTableSecGrpMemb( ICFSecSecGrpMembTable value ) {
		tableSecGrpMemb = value;
	}

	public ICFSecSecGrpMembFactory getFactorySecGrpMemb() {
		return( factorySecGrpMemb );
	}

	public void setFactorySecGrpMemb( ICFSecSecGrpMembFactory value ) {
		factorySecGrpMemb = value;
	}

	public ICFSecSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ICFSecSecSessionTable value ) {
		tableSecSession = value;
	}

	public ICFSecSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	public void setFactorySecSession( ICFSecSecSessionFactory value ) {
		factorySecSession = value;
	}

	public ICFSecSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ICFSecSecUserTable value ) {
		tableSecUser = value;
	}

	public ICFSecSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	public void setFactorySecUser( ICFSecSecUserFactory value ) {
		factorySecUser = value;
	}

	public ICFBamServerListFuncTable getTableServerListFunc() {
		return( tableServerListFunc );
	}

	public void setTableServerListFunc( ICFBamServerListFuncTable value ) {
		tableServerListFunc = value;
	}

	public ICFBamServerListFuncFactory getFactoryServerListFunc() {
		return( factoryServerListFunc );
	}

	public void setFactoryServerListFunc( ICFBamServerListFuncFactory value ) {
		factoryServerListFunc = value;
	}

	public ICFBamServerMethodTable getTableServerMethod() {
		return( tableServerMethod );
	}

	public void setTableServerMethod( ICFBamServerMethodTable value ) {
		tableServerMethod = value;
	}

	public ICFBamServerMethodFactory getFactoryServerMethod() {
		return( factoryServerMethod );
	}

	public void setFactoryServerMethod( ICFBamServerMethodFactory value ) {
		factoryServerMethod = value;
	}

	public ICFBamServerObjFuncTable getTableServerObjFunc() {
		return( tableServerObjFunc );
	}

	public void setTableServerObjFunc( ICFBamServerObjFuncTable value ) {
		tableServerObjFunc = value;
	}

	public ICFBamServerObjFuncFactory getFactoryServerObjFunc() {
		return( factoryServerObjFunc );
	}

	public void setFactoryServerObjFunc( ICFBamServerObjFuncFactory value ) {
		factoryServerObjFunc = value;
	}

	public ICFBamServerProcTable getTableServerProc() {
		return( tableServerProc );
	}

	public void setTableServerProc( ICFBamServerProcTable value ) {
		tableServerProc = value;
	}

	public ICFBamServerProcFactory getFactoryServerProc() {
		return( factoryServerProc );
	}

	public void setFactoryServerProc( ICFBamServerProcFactory value ) {
		factoryServerProc = value;
	}

	public ICFSecServiceTable getTableService() {
		return( tableService );
	}

	public void setTableService( ICFSecServiceTable value ) {
		tableService = value;
	}

	public ICFSecServiceFactory getFactoryService() {
		return( factoryService );
	}

	public void setFactoryService( ICFSecServiceFactory value ) {
		factoryService = value;
	}

	public ICFSecServiceTypeTable getTableServiceType() {
		return( tableServiceType );
	}

	public void setTableServiceType( ICFSecServiceTypeTable value ) {
		tableServiceType = value;
	}

	public ICFSecServiceTypeFactory getFactoryServiceType() {
		return( factoryServiceType );
	}

	public void setFactoryServiceType( ICFSecServiceTypeFactory value ) {
		factoryServiceType = value;
	}

	public ICFBamStringColTable getTableStringCol() {
		return( tableStringCol );
	}

	public void setTableStringCol( ICFBamStringColTable value ) {
		tableStringCol = value;
	}

	public ICFBamStringColFactory getFactoryStringCol() {
		return( factoryStringCol );
	}

	public void setFactoryStringCol( ICFBamStringColFactory value ) {
		factoryStringCol = value;
	}

	public ICFBamStringDefTable getTableStringDef() {
		return( tableStringDef );
	}

	public void setTableStringDef( ICFBamStringDefTable value ) {
		tableStringDef = value;
	}

	public ICFBamStringDefFactory getFactoryStringDef() {
		return( factoryStringDef );
	}

	public void setFactoryStringDef( ICFBamStringDefFactory value ) {
		factoryStringDef = value;
	}

	public ICFBamStringTypeTable getTableStringType() {
		return( tableStringType );
	}

	public void setTableStringType( ICFBamStringTypeTable value ) {
		tableStringType = value;
	}

	public ICFBamStringTypeFactory getFactoryStringType() {
		return( factoryStringType );
	}

	public void setFactoryStringType( ICFBamStringTypeFactory value ) {
		factoryStringType = value;
	}

	public ICFIntSubProjectTable getTableSubProject() {
		return( tableSubProject );
	}

	public void setTableSubProject( ICFIntSubProjectTable value ) {
		tableSubProject = value;
	}

	public ICFIntSubProjectFactory getFactorySubProject() {
		return( factorySubProject );
	}

	public void setFactorySubProject( ICFIntSubProjectFactory value ) {
		factorySubProject = value;
	}

	public ICFSecSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ICFSecSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ICFSecSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	public void setFactorySysCluster( ICFSecSysClusterFactory value ) {
		factorySysCluster = value;
	}

	public ICFSecTSecGroupTable getTableTSecGroup() {
		return( tableTSecGroup );
	}

	public void setTableTSecGroup( ICFSecTSecGroupTable value ) {
		tableTSecGroup = value;
	}

	public ICFSecTSecGroupFactory getFactoryTSecGroup() {
		return( factoryTSecGroup );
	}

	public void setFactoryTSecGroup( ICFSecTSecGroupFactory value ) {
		factoryTSecGroup = value;
	}

	public ICFSecTSecGrpIncTable getTableTSecGrpInc() {
		return( tableTSecGrpInc );
	}

	public void setTableTSecGrpInc( ICFSecTSecGrpIncTable value ) {
		tableTSecGrpInc = value;
	}

	public ICFSecTSecGrpIncFactory getFactoryTSecGrpInc() {
		return( factoryTSecGrpInc );
	}

	public void setFactoryTSecGrpInc( ICFSecTSecGrpIncFactory value ) {
		factoryTSecGrpInc = value;
	}

	public ICFSecTSecGrpMembTable getTableTSecGrpMemb() {
		return( tableTSecGrpMemb );
	}

	public void setTableTSecGrpMemb( ICFSecTSecGrpMembTable value ) {
		tableTSecGrpMemb = value;
	}

	public ICFSecTSecGrpMembFactory getFactoryTSecGrpMemb() {
		return( factoryTSecGrpMemb );
	}

	public void setFactoryTSecGrpMemb( ICFSecTSecGrpMembFactory value ) {
		factoryTSecGrpMemb = value;
	}

	public ICFBamTZDateColTable getTableTZDateCol() {
		return( tableTZDateCol );
	}

	public void setTableTZDateCol( ICFBamTZDateColTable value ) {
		tableTZDateCol = value;
	}

	public ICFBamTZDateColFactory getFactoryTZDateCol() {
		return( factoryTZDateCol );
	}

	public void setFactoryTZDateCol( ICFBamTZDateColFactory value ) {
		factoryTZDateCol = value;
	}

	public ICFBamTZDateDefTable getTableTZDateDef() {
		return( tableTZDateDef );
	}

	public void setTableTZDateDef( ICFBamTZDateDefTable value ) {
		tableTZDateDef = value;
	}

	public ICFBamTZDateDefFactory getFactoryTZDateDef() {
		return( factoryTZDateDef );
	}

	public void setFactoryTZDateDef( ICFBamTZDateDefFactory value ) {
		factoryTZDateDef = value;
	}

	public ICFBamTZDateTypeTable getTableTZDateType() {
		return( tableTZDateType );
	}

	public void setTableTZDateType( ICFBamTZDateTypeTable value ) {
		tableTZDateType = value;
	}

	public ICFBamTZDateTypeFactory getFactoryTZDateType() {
		return( factoryTZDateType );
	}

	public void setFactoryTZDateType( ICFBamTZDateTypeFactory value ) {
		factoryTZDateType = value;
	}

	public ICFBamTZTimeColTable getTableTZTimeCol() {
		return( tableTZTimeCol );
	}

	public void setTableTZTimeCol( ICFBamTZTimeColTable value ) {
		tableTZTimeCol = value;
	}

	public ICFBamTZTimeColFactory getFactoryTZTimeCol() {
		return( factoryTZTimeCol );
	}

	public void setFactoryTZTimeCol( ICFBamTZTimeColFactory value ) {
		factoryTZTimeCol = value;
	}

	public ICFBamTZTimeDefTable getTableTZTimeDef() {
		return( tableTZTimeDef );
	}

	public void setTableTZTimeDef( ICFBamTZTimeDefTable value ) {
		tableTZTimeDef = value;
	}

	public ICFBamTZTimeDefFactory getFactoryTZTimeDef() {
		return( factoryTZTimeDef );
	}

	public void setFactoryTZTimeDef( ICFBamTZTimeDefFactory value ) {
		factoryTZTimeDef = value;
	}

	public ICFBamTZTimeTypeTable getTableTZTimeType() {
		return( tableTZTimeType );
	}

	public void setTableTZTimeType( ICFBamTZTimeTypeTable value ) {
		tableTZTimeType = value;
	}

	public ICFBamTZTimeTypeFactory getFactoryTZTimeType() {
		return( factoryTZTimeType );
	}

	public void setFactoryTZTimeType( ICFBamTZTimeTypeFactory value ) {
		factoryTZTimeType = value;
	}

	public ICFBamTZTimestampColTable getTableTZTimestampCol() {
		return( tableTZTimestampCol );
	}

	public void setTableTZTimestampCol( ICFBamTZTimestampColTable value ) {
		tableTZTimestampCol = value;
	}

	public ICFBamTZTimestampColFactory getFactoryTZTimestampCol() {
		return( factoryTZTimestampCol );
	}

	public void setFactoryTZTimestampCol( ICFBamTZTimestampColFactory value ) {
		factoryTZTimestampCol = value;
	}

	public ICFBamTZTimestampDefTable getTableTZTimestampDef() {
		return( tableTZTimestampDef );
	}

	public void setTableTZTimestampDef( ICFBamTZTimestampDefTable value ) {
		tableTZTimestampDef = value;
	}

	public ICFBamTZTimestampDefFactory getFactoryTZTimestampDef() {
		return( factoryTZTimestampDef );
	}

	public void setFactoryTZTimestampDef( ICFBamTZTimestampDefFactory value ) {
		factoryTZTimestampDef = value;
	}

	public ICFBamTZTimestampTypeTable getTableTZTimestampType() {
		return( tableTZTimestampType );
	}

	public void setTableTZTimestampType( ICFBamTZTimestampTypeTable value ) {
		tableTZTimestampType = value;
	}

	public ICFBamTZTimestampTypeFactory getFactoryTZTimestampType() {
		return( factoryTZTimestampType );
	}

	public void setFactoryTZTimestampType( ICFBamTZTimestampTypeFactory value ) {
		factoryTZTimestampType = value;
	}

	public ICFBamTableTable getTableTable() {
		return( tableTable );
	}

	public void setTableTable( ICFBamTableTable value ) {
		tableTable = value;
	}

	public ICFBamTableFactory getFactoryTable() {
		return( factoryTable );
	}

	public void setFactoryTable( ICFBamTableFactory value ) {
		factoryTable = value;
	}

	public ICFBamTableColTable getTableTableCol() {
		return( tableTableCol );
	}

	public void setTableTableCol( ICFBamTableColTable value ) {
		tableTableCol = value;
	}

	public ICFBamTableColFactory getFactoryTableCol() {
		return( factoryTableCol );
	}

	public void setFactoryTableCol( ICFBamTableColFactory value ) {
		factoryTableCol = value;
	}

	public ICFSecTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ICFSecTenantTable value ) {
		tableTenant = value;
	}

	public ICFSecTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

	public void setFactoryTenant( ICFSecTenantFactory value ) {
		factoryTenant = value;
	}

	public ICFBamTextColTable getTableTextCol() {
		return( tableTextCol );
	}

	public void setTableTextCol( ICFBamTextColTable value ) {
		tableTextCol = value;
	}

	public ICFBamTextColFactory getFactoryTextCol() {
		return( factoryTextCol );
	}

	public void setFactoryTextCol( ICFBamTextColFactory value ) {
		factoryTextCol = value;
	}

	public ICFBamTextDefTable getTableTextDef() {
		return( tableTextDef );
	}

	public void setTableTextDef( ICFBamTextDefTable value ) {
		tableTextDef = value;
	}

	public ICFBamTextDefFactory getFactoryTextDef() {
		return( factoryTextDef );
	}

	public void setFactoryTextDef( ICFBamTextDefFactory value ) {
		factoryTextDef = value;
	}

	public ICFBamTextTypeTable getTableTextType() {
		return( tableTextType );
	}

	public void setTableTextType( ICFBamTextTypeTable value ) {
		tableTextType = value;
	}

	public ICFBamTextTypeFactory getFactoryTextType() {
		return( factoryTextType );
	}

	public void setFactoryTextType( ICFBamTextTypeFactory value ) {
		factoryTextType = value;
	}

	public ICFBamTimeColTable getTableTimeCol() {
		return( tableTimeCol );
	}

	public void setTableTimeCol( ICFBamTimeColTable value ) {
		tableTimeCol = value;
	}

	public ICFBamTimeColFactory getFactoryTimeCol() {
		return( factoryTimeCol );
	}

	public void setFactoryTimeCol( ICFBamTimeColFactory value ) {
		factoryTimeCol = value;
	}

	public ICFBamTimeDefTable getTableTimeDef() {
		return( tableTimeDef );
	}

	public void setTableTimeDef( ICFBamTimeDefTable value ) {
		tableTimeDef = value;
	}

	public ICFBamTimeDefFactory getFactoryTimeDef() {
		return( factoryTimeDef );
	}

	public void setFactoryTimeDef( ICFBamTimeDefFactory value ) {
		factoryTimeDef = value;
	}

	public ICFBamTimeTypeTable getTableTimeType() {
		return( tableTimeType );
	}

	public void setTableTimeType( ICFBamTimeTypeTable value ) {
		tableTimeType = value;
	}

	public ICFBamTimeTypeFactory getFactoryTimeType() {
		return( factoryTimeType );
	}

	public void setFactoryTimeType( ICFBamTimeTypeFactory value ) {
		factoryTimeType = value;
	}

	public ICFBamTimestampColTable getTableTimestampCol() {
		return( tableTimestampCol );
	}

	public void setTableTimestampCol( ICFBamTimestampColTable value ) {
		tableTimestampCol = value;
	}

	public ICFBamTimestampColFactory getFactoryTimestampCol() {
		return( factoryTimestampCol );
	}

	public void setFactoryTimestampCol( ICFBamTimestampColFactory value ) {
		factoryTimestampCol = value;
	}

	public ICFBamTimestampDefTable getTableTimestampDef() {
		return( tableTimestampDef );
	}

	public void setTableTimestampDef( ICFBamTimestampDefTable value ) {
		tableTimestampDef = value;
	}

	public ICFBamTimestampDefFactory getFactoryTimestampDef() {
		return( factoryTimestampDef );
	}

	public void setFactoryTimestampDef( ICFBamTimestampDefFactory value ) {
		factoryTimestampDef = value;
	}

	public ICFBamTimestampTypeTable getTableTimestampType() {
		return( tableTimestampType );
	}

	public void setTableTimestampType( ICFBamTimestampTypeTable value ) {
		tableTimestampType = value;
	}

	public ICFBamTimestampTypeFactory getFactoryTimestampType() {
		return( factoryTimestampType );
	}

	public void setFactoryTimestampType( ICFBamTimestampTypeFactory value ) {
		factoryTimestampType = value;
	}

	public ICFIntTldTable getTableTld() {
		return( tableTld );
	}

	public void setTableTld( ICFIntTldTable value ) {
		tableTld = value;
	}

	public ICFIntTldFactory getFactoryTld() {
		return( factoryTld );
	}

	public void setFactoryTld( ICFIntTldFactory value ) {
		factoryTld = value;
	}

	public ICFBamTokenColTable getTableTokenCol() {
		return( tableTokenCol );
	}

	public void setTableTokenCol( ICFBamTokenColTable value ) {
		tableTokenCol = value;
	}

	public ICFBamTokenColFactory getFactoryTokenCol() {
		return( factoryTokenCol );
	}

	public void setFactoryTokenCol( ICFBamTokenColFactory value ) {
		factoryTokenCol = value;
	}

	public ICFBamTokenDefTable getTableTokenDef() {
		return( tableTokenDef );
	}

	public void setTableTokenDef( ICFBamTokenDefTable value ) {
		tableTokenDef = value;
	}

	public ICFBamTokenDefFactory getFactoryTokenDef() {
		return( factoryTokenDef );
	}

	public void setFactoryTokenDef( ICFBamTokenDefFactory value ) {
		factoryTokenDef = value;
	}

	public ICFBamTokenTypeTable getTableTokenType() {
		return( tableTokenType );
	}

	public void setTableTokenType( ICFBamTokenTypeTable value ) {
		tableTokenType = value;
	}

	public ICFBamTokenTypeFactory getFactoryTokenType() {
		return( factoryTokenType );
	}

	public void setFactoryTokenType( ICFBamTokenTypeFactory value ) {
		factoryTokenType = value;
	}

	public ICFIntTopDomainTable getTableTopDomain() {
		return( tableTopDomain );
	}

	public void setTableTopDomain( ICFIntTopDomainTable value ) {
		tableTopDomain = value;
	}

	public ICFIntTopDomainFactory getFactoryTopDomain() {
		return( factoryTopDomain );
	}

	public void setFactoryTopDomain( ICFIntTopDomainFactory value ) {
		factoryTopDomain = value;
	}

	public ICFIntTopProjectTable getTableTopProject() {
		return( tableTopProject );
	}

	public void setTableTopProject( ICFIntTopProjectTable value ) {
		tableTopProject = value;
	}

	public ICFIntTopProjectFactory getFactoryTopProject() {
		return( factoryTopProject );
	}

	public void setFactoryTopProject( ICFIntTopProjectFactory value ) {
		factoryTopProject = value;
	}

	public ICFBamUInt16ColTable getTableUInt16Col() {
		return( tableUInt16Col );
	}

	public void setTableUInt16Col( ICFBamUInt16ColTable value ) {
		tableUInt16Col = value;
	}

	public ICFBamUInt16ColFactory getFactoryUInt16Col() {
		return( factoryUInt16Col );
	}

	public void setFactoryUInt16Col( ICFBamUInt16ColFactory value ) {
		factoryUInt16Col = value;
	}

	public ICFBamUInt16DefTable getTableUInt16Def() {
		return( tableUInt16Def );
	}

	public void setTableUInt16Def( ICFBamUInt16DefTable value ) {
		tableUInt16Def = value;
	}

	public ICFBamUInt16DefFactory getFactoryUInt16Def() {
		return( factoryUInt16Def );
	}

	public void setFactoryUInt16Def( ICFBamUInt16DefFactory value ) {
		factoryUInt16Def = value;
	}

	public ICFBamUInt16TypeTable getTableUInt16Type() {
		return( tableUInt16Type );
	}

	public void setTableUInt16Type( ICFBamUInt16TypeTable value ) {
		tableUInt16Type = value;
	}

	public ICFBamUInt16TypeFactory getFactoryUInt16Type() {
		return( factoryUInt16Type );
	}

	public void setFactoryUInt16Type( ICFBamUInt16TypeFactory value ) {
		factoryUInt16Type = value;
	}

	public ICFBamUInt32ColTable getTableUInt32Col() {
		return( tableUInt32Col );
	}

	public void setTableUInt32Col( ICFBamUInt32ColTable value ) {
		tableUInt32Col = value;
	}

	public ICFBamUInt32ColFactory getFactoryUInt32Col() {
		return( factoryUInt32Col );
	}

	public void setFactoryUInt32Col( ICFBamUInt32ColFactory value ) {
		factoryUInt32Col = value;
	}

	public ICFBamUInt32DefTable getTableUInt32Def() {
		return( tableUInt32Def );
	}

	public void setTableUInt32Def( ICFBamUInt32DefTable value ) {
		tableUInt32Def = value;
	}

	public ICFBamUInt32DefFactory getFactoryUInt32Def() {
		return( factoryUInt32Def );
	}

	public void setFactoryUInt32Def( ICFBamUInt32DefFactory value ) {
		factoryUInt32Def = value;
	}

	public ICFBamUInt32TypeTable getTableUInt32Type() {
		return( tableUInt32Type );
	}

	public void setTableUInt32Type( ICFBamUInt32TypeTable value ) {
		tableUInt32Type = value;
	}

	public ICFBamUInt32TypeFactory getFactoryUInt32Type() {
		return( factoryUInt32Type );
	}

	public void setFactoryUInt32Type( ICFBamUInt32TypeFactory value ) {
		factoryUInt32Type = value;
	}

	public ICFBamUInt64ColTable getTableUInt64Col() {
		return( tableUInt64Col );
	}

	public void setTableUInt64Col( ICFBamUInt64ColTable value ) {
		tableUInt64Col = value;
	}

	public ICFBamUInt64ColFactory getFactoryUInt64Col() {
		return( factoryUInt64Col );
	}

	public void setFactoryUInt64Col( ICFBamUInt64ColFactory value ) {
		factoryUInt64Col = value;
	}

	public ICFBamUInt64DefTable getTableUInt64Def() {
		return( tableUInt64Def );
	}

	public void setTableUInt64Def( ICFBamUInt64DefTable value ) {
		tableUInt64Def = value;
	}

	public ICFBamUInt64DefFactory getFactoryUInt64Def() {
		return( factoryUInt64Def );
	}

	public void setFactoryUInt64Def( ICFBamUInt64DefFactory value ) {
		factoryUInt64Def = value;
	}

	public ICFBamUInt64TypeTable getTableUInt64Type() {
		return( tableUInt64Type );
	}

	public void setTableUInt64Type( ICFBamUInt64TypeTable value ) {
		tableUInt64Type = value;
	}

	public ICFBamUInt64TypeFactory getFactoryUInt64Type() {
		return( factoryUInt64Type );
	}

	public void setFactoryUInt64Type( ICFBamUInt64TypeFactory value ) {
		factoryUInt64Type = value;
	}

	public ICFIntURLProtocolTable getTableURLProtocol() {
		return( tableURLProtocol );
	}

	public void setTableURLProtocol( ICFIntURLProtocolTable value ) {
		tableURLProtocol = value;
	}

	public ICFIntURLProtocolFactory getFactoryURLProtocol() {
		return( factoryURLProtocol );
	}

	public void setFactoryURLProtocol( ICFIntURLProtocolFactory value ) {
		factoryURLProtocol = value;
	}

	public ICFBamUuidColTable getTableUuidCol() {
		return( tableUuidCol );
	}

	public void setTableUuidCol( ICFBamUuidColTable value ) {
		tableUuidCol = value;
	}

	public ICFBamUuidColFactory getFactoryUuidCol() {
		return( factoryUuidCol );
	}

	public void setFactoryUuidCol( ICFBamUuidColFactory value ) {
		factoryUuidCol = value;
	}

	public ICFBamUuidDefTable getTableUuidDef() {
		return( tableUuidDef );
	}

	public void setTableUuidDef( ICFBamUuidDefTable value ) {
		tableUuidDef = value;
	}

	public ICFBamUuidDefFactory getFactoryUuidDef() {
		return( factoryUuidDef );
	}

	public void setFactoryUuidDef( ICFBamUuidDefFactory value ) {
		factoryUuidDef = value;
	}

	public ICFBamUuidGenTable getTableUuidGen() {
		return( tableUuidGen );
	}

	public void setTableUuidGen( ICFBamUuidGenTable value ) {
		tableUuidGen = value;
	}

	public ICFBamUuidGenFactory getFactoryUuidGen() {
		return( factoryUuidGen );
	}

	public void setFactoryUuidGen( ICFBamUuidGenFactory value ) {
		factoryUuidGen = value;
	}

	public ICFBamUuidTypeTable getTableUuidType() {
		return( tableUuidType );
	}

	public void setTableUuidType( ICFBamUuidTypeTable value ) {
		tableUuidType = value;
	}

	public ICFBamUuidTypeFactory getFactoryUuidType() {
		return( factoryUuidType );
	}

	public void setFactoryUuidType( ICFBamUuidTypeFactory value ) {
		factoryUuidType = value;
	}

	public ICFBamValueTable getTableValue() {
		return( tableValue );
	}

	public void setTableValue( ICFBamValueTable value ) {
		tableValue = value;
	}

	public ICFBamValueFactory getFactoryValue() {
		return( factoryValue );
	}

	public void setFactoryValue( ICFBamValueFactory value ) {
		factoryValue = value;
	}

	public boolean isTransactionOpen() {
		throw new CFLibMustOverrideException( getClass(), "isTransactionOpen" );
	}

	public boolean beginTransaction() {
		throw new CFLibMustOverrideException( getClass(), "beginTransaction" );
	}

	public void commit() {
		throw new CFLibMustOverrideException( getClass(), "commit" );
	}

	public void rollback() {
		throw new CFLibMustOverrideException( getClass(), "rollback" );
	}

	public ICFSecTablePerms getTablePerms() {
		return( tablePerms );
	}

	public void setTablePerms( ICFSecTablePerms value ) {
		tablePerms = value;
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	/**
	 *	Release any prepared statements bound to this database instance, such
	 *	that the value of schemaDbName has to be re-evaluated for all future
	 *	invocations.
	 */
	public void releasePreparedStatements() {
	}

	/**
	 *	When you first connect to a database, you can opt to specify a database
	 *	schema name to be used by the session.  The implementation code must always
	 *	be dynamically based on the invocation of <tt>String getDbSchemaName()</tt>
	 *	at runtime.
	 *	<p>
	 *	The initial value is defined by the implementing schema model which has inherited
	 *	the expression of the current schema model being expanded.  That is, it is specified
	 *	in the DbSchemaName attribute of a SchemaDef instance.
	 */
	public String getDbSchemaName() {
		return( schemaDbName );
	}

	public String getLowerDbSchemaName() {
		return( lowerDbSchemaName );
	}

	/**
	 *	The database is expected to override this implementation and invoke the
	 *	<tt>super.setDbSchemaName( String argDbSchemaName )</tt> early
	 *	on in the implementation of the cust body.  You should let the exceptions
	 *	which can be thrown by this implementation pass unimpeded.
	 *	<pg>
	 *	When you set the database schema name, the database-specific implementation
	 *	of this method does a "commit; use database"-type sequence to change
	 *	to the target database.  This should be specified globally for all
	 *	database connections in a given cluster, so that all of
	 *	the application implementation clients are using the same database instance
	 *	regardless of what's been provided by the cust client implementation,
	 *	be it as a Java application or a web interface written using JEE.
	 */
	public void setDbSchemaName( String argDbSchemaName ) {
		final String S_ProcName = "setDbSchemaName";
		if( ( argDbSchemaName == null ) || ( argDbSchemaName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argDbSchemaName" );
		}
		schemaDbName = argDbSchemaName;
		lowerDbSchemaName = schemaDbName.toLowerCase();
	}
}
