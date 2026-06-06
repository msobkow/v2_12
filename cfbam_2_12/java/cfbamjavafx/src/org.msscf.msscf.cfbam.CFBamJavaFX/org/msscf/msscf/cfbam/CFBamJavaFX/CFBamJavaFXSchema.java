// Description: Java 11 JavaFX Schema for CFBam.

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
import java.security.KeyStore;
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
import org.msscf.msscf.cfbam.CFBamSaxLoader.CFBamSaxLoader;

public class CFBamJavaFXSchema
implements ICFBamJavaFXSchema
{
	protected CFSecClientConfigurationFile clientConfigurationFile = null;
	protected KeyStore keyStore = null;
	protected ICFBamSchemaObj schema = null;
	protected String clusterName = "system";
	protected ICFSecClusterObj clusterObj = null;
	protected String tenantName = "system";
	protected ICFSecTenantObj tenantObj = null;
	protected String secUserName = "system";
	protected ICFSecSecUserObj secUserObj = null;
	protected ICFSecSecSessionObj secSessionObj = null;
	protected ICFBamJavaFXAtomFactory factoryAtom = null;
	protected ICFBamJavaFXBlobColFactory factoryBlobCol = null;
	protected ICFBamJavaFXBlobDefFactory factoryBlobDef = null;
	protected ICFBamJavaFXBlobTypeFactory factoryBlobType = null;
	protected ICFBamJavaFXBoolColFactory factoryBoolCol = null;
	protected ICFBamJavaFXBoolDefFactory factoryBoolDef = null;
	protected ICFBamJavaFXBoolTypeFactory factoryBoolType = null;
	protected ICFBamJavaFXChainFactory factoryChain = null;
	protected ICFBamJavaFXClearDepFactory factoryClearDep = null;
	protected ICFBamJavaFXClearSubDep1Factory factoryClearSubDep1 = null;
	protected ICFBamJavaFXClearSubDep2Factory factoryClearSubDep2 = null;
	protected ICFBamJavaFXClearSubDep3Factory factoryClearSubDep3 = null;
	protected ICFBamJavaFXClearTopDepFactory factoryClearTopDep = null;
	protected ICFSecJavaFXClusterFactory factoryCluster = null;
	protected ICFBamJavaFXDateColFactory factoryDateCol = null;
	protected ICFBamJavaFXDateDefFactory factoryDateDef = null;
	protected ICFBamJavaFXDateTypeFactory factoryDateType = null;
	protected ICFBamJavaFXDelDepFactory factoryDelDep = null;
	protected ICFBamJavaFXDelSubDep1Factory factoryDelSubDep1 = null;
	protected ICFBamJavaFXDelSubDep2Factory factoryDelSubDep2 = null;
	protected ICFBamJavaFXDelSubDep3Factory factoryDelSubDep3 = null;
	protected ICFBamJavaFXDelTopDepFactory factoryDelTopDep = null;
	protected ICFBamJavaFXDoubleColFactory factoryDoubleCol = null;
	protected ICFBamJavaFXDoubleDefFactory factoryDoubleDef = null;
	protected ICFBamJavaFXDoubleTypeFactory factoryDoubleType = null;
	protected ICFBamJavaFXEnumDefFactory factoryEnumDef = null;
	protected ICFBamJavaFXEnumTagFactory factoryEnumTag = null;
	protected ICFBamJavaFXEnumTypeFactory factoryEnumType = null;
	protected ICFBamJavaFXFloatColFactory factoryFloatCol = null;
	protected ICFBamJavaFXFloatDefFactory factoryFloatDef = null;
	protected ICFBamJavaFXFloatTypeFactory factoryFloatType = null;
	protected ICFSecJavaFXHostNodeFactory factoryHostNode = null;
	protected ICFSecJavaFXISOCcyFactory factoryISOCcy = null;
	protected ICFSecJavaFXISOCtryFactory factoryISOCtry = null;
	protected ICFSecJavaFXISOCtryCcyFactory factoryISOCtryCcy = null;
	protected ICFSecJavaFXISOCtryLangFactory factoryISOCtryLang = null;
	protected ICFSecJavaFXISOLangFactory factoryISOLang = null;
	protected ICFSecJavaFXISOTZoneFactory factoryISOTZone = null;
	protected ICFBamJavaFXId16GenFactory factoryId16Gen = null;
	protected ICFBamJavaFXId32GenFactory factoryId32Gen = null;
	protected ICFBamJavaFXId64GenFactory factoryId64Gen = null;
	protected ICFBamJavaFXIndexFactory factoryIndex = null;
	protected ICFBamJavaFXIndexColFactory factoryIndexCol = null;
	protected ICFBamJavaFXInt16ColFactory factoryInt16Col = null;
	protected ICFBamJavaFXInt16DefFactory factoryInt16Def = null;
	protected ICFBamJavaFXInt16TypeFactory factoryInt16Type = null;
	protected ICFBamJavaFXInt32ColFactory factoryInt32Col = null;
	protected ICFBamJavaFXInt32DefFactory factoryInt32Def = null;
	protected ICFBamJavaFXInt32TypeFactory factoryInt32Type = null;
	protected ICFBamJavaFXInt64ColFactory factoryInt64Col = null;
	protected ICFBamJavaFXInt64DefFactory factoryInt64Def = null;
	protected ICFBamJavaFXInt64TypeFactory factoryInt64Type = null;
	protected ICFIntJavaFXLicenseFactory factoryLicense = null;
	protected ICFIntJavaFXMajorVersionFactory factoryMajorVersion = null;
	protected ICFIntJavaFXMimeTypeFactory factoryMimeType = null;
	protected ICFIntJavaFXMinorVersionFactory factoryMinorVersion = null;
	protected ICFBamJavaFXNmTokenColFactory factoryNmTokenCol = null;
	protected ICFBamJavaFXNmTokenDefFactory factoryNmTokenDef = null;
	protected ICFBamJavaFXNmTokenTypeFactory factoryNmTokenType = null;
	protected ICFBamJavaFXNmTokensColFactory factoryNmTokensCol = null;
	protected ICFBamJavaFXNmTokensDefFactory factoryNmTokensDef = null;
	protected ICFBamJavaFXNmTokensTypeFactory factoryNmTokensType = null;
	protected ICFBamJavaFXNumberColFactory factoryNumberCol = null;
	protected ICFBamJavaFXNumberDefFactory factoryNumberDef = null;
	protected ICFBamJavaFXNumberTypeFactory factoryNumberType = null;
	protected ICFBamJavaFXParamFactory factoryParam = null;
	protected ICFBamJavaFXPopDepFactory factoryPopDep = null;
	protected ICFBamJavaFXPopSubDep1Factory factoryPopSubDep1 = null;
	protected ICFBamJavaFXPopSubDep2Factory factoryPopSubDep2 = null;
	protected ICFBamJavaFXPopSubDep3Factory factoryPopSubDep3 = null;
	protected ICFBamJavaFXPopTopDepFactory factoryPopTopDep = null;
	protected ICFBamJavaFXRelationFactory factoryRelation = null;
	protected ICFBamJavaFXRelationColFactory factoryRelationCol = null;
	protected ICFBamJavaFXSchemaDefFactory factorySchemaDef = null;
	protected ICFBamJavaFXSchemaRefFactory factorySchemaRef = null;
	protected ICFBamJavaFXScopeFactory factoryScope = null;
	protected ICFSecJavaFXSecAppFactory factorySecApp = null;
	protected ICFSecJavaFXSecDeviceFactory factorySecDevice = null;
	protected ICFSecJavaFXSecFormFactory factorySecForm = null;
	protected ICFSecJavaFXSecGroupFactory factorySecGroup = null;
	protected ICFSecJavaFXSecGroupFormFactory factorySecGroupForm = null;
	protected ICFSecJavaFXSecGrpIncFactory factorySecGrpInc = null;
	protected ICFSecJavaFXSecGrpMembFactory factorySecGrpMemb = null;
	protected ICFSecJavaFXSecSessionFactory factorySecSession = null;
	protected ICFSecJavaFXSecUserFactory factorySecUser = null;
	protected ICFBamJavaFXServerListFuncFactory factoryServerListFunc = null;
	protected ICFBamJavaFXServerMethodFactory factoryServerMethod = null;
	protected ICFBamJavaFXServerObjFuncFactory factoryServerObjFunc = null;
	protected ICFBamJavaFXServerProcFactory factoryServerProc = null;
	protected ICFSecJavaFXServiceFactory factoryService = null;
	protected ICFSecJavaFXServiceTypeFactory factoryServiceType = null;
	protected ICFBamJavaFXStringColFactory factoryStringCol = null;
	protected ICFBamJavaFXStringDefFactory factoryStringDef = null;
	protected ICFBamJavaFXStringTypeFactory factoryStringType = null;
	protected ICFIntJavaFXSubProjectFactory factorySubProject = null;
	protected ICFSecJavaFXSysClusterFactory factorySysCluster = null;
	protected ICFSecJavaFXTSecGroupFactory factoryTSecGroup = null;
	protected ICFSecJavaFXTSecGrpIncFactory factoryTSecGrpInc = null;
	protected ICFSecJavaFXTSecGrpMembFactory factoryTSecGrpMemb = null;
	protected ICFBamJavaFXTZDateColFactory factoryTZDateCol = null;
	protected ICFBamJavaFXTZDateDefFactory factoryTZDateDef = null;
	protected ICFBamJavaFXTZDateTypeFactory factoryTZDateType = null;
	protected ICFBamJavaFXTZTimeColFactory factoryTZTimeCol = null;
	protected ICFBamJavaFXTZTimeDefFactory factoryTZTimeDef = null;
	protected ICFBamJavaFXTZTimeTypeFactory factoryTZTimeType = null;
	protected ICFBamJavaFXTZTimestampColFactory factoryTZTimestampCol = null;
	protected ICFBamJavaFXTZTimestampDefFactory factoryTZTimestampDef = null;
	protected ICFBamJavaFXTZTimestampTypeFactory factoryTZTimestampType = null;
	protected ICFBamJavaFXTableFactory factoryTable = null;
	protected ICFBamJavaFXTableColFactory factoryTableCol = null;
	protected ICFSecJavaFXTenantFactory factoryTenant = null;
	protected ICFBamJavaFXTextColFactory factoryTextCol = null;
	protected ICFBamJavaFXTextDefFactory factoryTextDef = null;
	protected ICFBamJavaFXTextTypeFactory factoryTextType = null;
	protected ICFBamJavaFXTimeColFactory factoryTimeCol = null;
	protected ICFBamJavaFXTimeDefFactory factoryTimeDef = null;
	protected ICFBamJavaFXTimeTypeFactory factoryTimeType = null;
	protected ICFBamJavaFXTimestampColFactory factoryTimestampCol = null;
	protected ICFBamJavaFXTimestampDefFactory factoryTimestampDef = null;
	protected ICFBamJavaFXTimestampTypeFactory factoryTimestampType = null;
	protected ICFIntJavaFXTldFactory factoryTld = null;
	protected ICFBamJavaFXTokenColFactory factoryTokenCol = null;
	protected ICFBamJavaFXTokenDefFactory factoryTokenDef = null;
	protected ICFBamJavaFXTokenTypeFactory factoryTokenType = null;
	protected ICFIntJavaFXTopDomainFactory factoryTopDomain = null;
	protected ICFIntJavaFXTopProjectFactory factoryTopProject = null;
	protected ICFBamJavaFXUInt16ColFactory factoryUInt16Col = null;
	protected ICFBamJavaFXUInt16DefFactory factoryUInt16Def = null;
	protected ICFBamJavaFXUInt16TypeFactory factoryUInt16Type = null;
	protected ICFBamJavaFXUInt32ColFactory factoryUInt32Col = null;
	protected ICFBamJavaFXUInt32DefFactory factoryUInt32Def = null;
	protected ICFBamJavaFXUInt32TypeFactory factoryUInt32Type = null;
	protected ICFBamJavaFXUInt64ColFactory factoryUInt64Col = null;
	protected ICFBamJavaFXUInt64DefFactory factoryUInt64Def = null;
	protected ICFBamJavaFXUInt64TypeFactory factoryUInt64Type = null;
	protected ICFIntJavaFXURLProtocolFactory factoryURLProtocol = null;
	protected ICFBamJavaFXUuidColFactory factoryUuidCol = null;
	protected ICFBamJavaFXUuidDefFactory factoryUuidDef = null;
	protected ICFBamJavaFXUuidGenFactory factoryUuidGen = null;
	protected ICFBamJavaFXUuidTypeFactory factoryUuidType = null;
	protected ICFBamJavaFXValueFactory factoryValue = null;

	public CFBamJavaFXSchema() {
	}

	public CFSecClientConfigurationFile getClientConfigurationFile() {
		return( clientConfigurationFile );
	}

	public void setClientConfigurationFile( CFSecClientConfigurationFile value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setClientConfigurationFile",
				1,
				"value" );
		}
		clientConfigurationFile = value;
	}

	public KeyStore getKeyStore() {
		return( keyStore );
	}

	public void setKeyStore( KeyStore value ) {
		keyStore = value;
	}

	public ICFSecSchemaObj getSchema() {
		return( schema );
	}

	public void setSchema( ICFSecSchemaObj argSchema ) {
		final String S_ProcName = "setSchema";
		if( argSchema == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		if( ! ( argSchema instanceof ICFBamSchemaObj ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"argSchema",
				argSchema,
				"ICFBamSchemaObj" );
		}
		schema = (ICFBamSchemaObj)argSchema;
	}

	public String getClusterName() {
		return( clusterName );
	}

	public void setClusterName( String argClusterName ) {
		final String S_ProcName = "setClusterName";
		if( ( argClusterName == null ) || ( argClusterName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argClusterName" );
		}
		clusterName = argClusterName;
		clusterObj = null;
	}

	public ICFSecClusterObj getClusterObj() {
		if( clusterObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					clusterObj = schema.getClusterTableObj().readClusterByUDomNameIdx( clusterName );
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
			if( clusterObj == null ) {
				throw new RuntimeException( "Cluster \"" + clusterName + "\" could not be found" );
			}
		}
		else {
			throw new RuntimeException( "Cannot resolve Cluster before a connection is established" );
		}
		return( clusterObj );
	}

	public String getTenantName() {
		return( tenantName );
	}

	public void setTenantName( String argTenantName ) {
		final String S_ProcName = "setTenantName";
		if( ( argTenantName == null ) || ( argTenantName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argTenantName" );
		}
		tenantName = argTenantName;
		tenantObj = null;
	}

	public ICFSecTenantObj getTenantObj() {
		if( tenantObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					tenantObj = schema.getTenantTableObj().readTenantByUNameIdx( getClusterObj().getRequiredId(), tenantName );
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
			if( tenantObj == null ) {
				throw new RuntimeException( "Tenant \"" + tenantName + "\" could not be found for Cluster \"" + clusterName + "\"" );
			}
		}
		else {
			throw new CFLibRuntimeException( "Cannot resolve tenant before a connection is established" );
		}
		return( tenantObj );
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public void setSecUserName( String argSecUserName ) {
		final String S_ProcName = "setSecUserName";
		if( ( argSecUserName == null ) || ( argSecUserName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argSecUserName" );
		}
		secUserName = argSecUserName;
		secUserObj = null;
	}

	public ICFSecSecUserObj getSecUserObj() {
		if( secUserObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					secUserObj = schema.getSecUserTableObj().readSecUserByULoginIdx( secUserName );
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
			if( secUserObj == null ) {
				throw new RuntimeException( "SecUser \"" + secUserName + "\" could not be found" );
			}
		}
		else {
			throw new CFLibRuntimeException( "Cannot resolve sec user before a connection is established" );
		}
		return( secUserObj );
	}

	public ICFSecSecSessionObj getSecSessionObj() {
		if( secSessionObj == null ) {
			if( ( schema != null ) && schema.isConnected() ) {
				boolean transactionStarted = schema.beginTransaction();
				try {
					getClusterObj();
					getTenantObj();
					getSecUserObj();
					secSessionObj = schema.getSecSessionTableObj().newInstance();
					ICFSecSecSessionEditObj sessionEdit = secSessionObj.beginEdit();
					sessionEdit.setRequiredContainerSecUser( secUserObj );
					sessionEdit.setRequiredStart( Calendar.getInstance() );
					sessionEdit.setOptionalFinish( null );
					secSessionObj = sessionEdit.create();
					sessionEdit = null;
					if( transactionStarted ) {
						schema.commit();
					}
				}
				catch( RuntimeException e ) {
					if( transactionStarted ) {
						try {
							schema.rollback();
						}
						catch( Exception e2 ) {
						}
					}
					throw e;
				}
			}
		}
		else {
			throw new CFLibRuntimeException( "Cannot resolve sec session before a connection is established" );
		}
		return( secSessionObj );
	}

	public ICFBamJavaFXAtomFactory getAtomFactory() {
		if( factoryAtom == null ) {
			factoryAtom = new CFBamJavaFXAtomFactory( this );
		}
		return( factoryAtom );
	}

	public ICFBamJavaFXBlobColFactory getBlobColFactory() {
		if( factoryBlobCol == null ) {
			factoryBlobCol = new CFBamJavaFXBlobColFactory( this );
		}
		return( factoryBlobCol );
	}

	public ICFBamJavaFXBlobDefFactory getBlobDefFactory() {
		if( factoryBlobDef == null ) {
			factoryBlobDef = new CFBamJavaFXBlobDefFactory( this );
		}
		return( factoryBlobDef );
	}

	public ICFBamJavaFXBlobTypeFactory getBlobTypeFactory() {
		if( factoryBlobType == null ) {
			factoryBlobType = new CFBamJavaFXBlobTypeFactory( this );
		}
		return( factoryBlobType );
	}

	public ICFBamJavaFXBoolColFactory getBoolColFactory() {
		if( factoryBoolCol == null ) {
			factoryBoolCol = new CFBamJavaFXBoolColFactory( this );
		}
		return( factoryBoolCol );
	}

	public ICFBamJavaFXBoolDefFactory getBoolDefFactory() {
		if( factoryBoolDef == null ) {
			factoryBoolDef = new CFBamJavaFXBoolDefFactory( this );
		}
		return( factoryBoolDef );
	}

	public ICFBamJavaFXBoolTypeFactory getBoolTypeFactory() {
		if( factoryBoolType == null ) {
			factoryBoolType = new CFBamJavaFXBoolTypeFactory( this );
		}
		return( factoryBoolType );
	}

	public ICFBamJavaFXChainFactory getChainFactory() {
		if( factoryChain == null ) {
			factoryChain = new CFBamJavaFXChainFactory( this );
		}
		return( factoryChain );
	}

	public ICFBamJavaFXClearDepFactory getClearDepFactory() {
		if( factoryClearDep == null ) {
			factoryClearDep = new CFBamJavaFXClearDepFactory( this );
		}
		return( factoryClearDep );
	}

	public ICFBamJavaFXClearSubDep1Factory getClearSubDep1Factory() {
		if( factoryClearSubDep1 == null ) {
			factoryClearSubDep1 = new CFBamJavaFXClearSubDep1Factory( this );
		}
		return( factoryClearSubDep1 );
	}

	public ICFBamJavaFXClearSubDep2Factory getClearSubDep2Factory() {
		if( factoryClearSubDep2 == null ) {
			factoryClearSubDep2 = new CFBamJavaFXClearSubDep2Factory( this );
		}
		return( factoryClearSubDep2 );
	}

	public ICFBamJavaFXClearSubDep3Factory getClearSubDep3Factory() {
		if( factoryClearSubDep3 == null ) {
			factoryClearSubDep3 = new CFBamJavaFXClearSubDep3Factory( this );
		}
		return( factoryClearSubDep3 );
	}

	public ICFBamJavaFXClearTopDepFactory getClearTopDepFactory() {
		if( factoryClearTopDep == null ) {
			factoryClearTopDep = new CFBamJavaFXClearTopDepFactory( this );
		}
		return( factoryClearTopDep );
	}

	public ICFSecJavaFXClusterFactory getClusterFactory() {
		if( factoryCluster == null ) {
			factoryCluster = new CFSecJavaFXClusterFactory( this );
		}
		return( factoryCluster );
	}

	public ICFBamJavaFXDateColFactory getDateColFactory() {
		if( factoryDateCol == null ) {
			factoryDateCol = new CFBamJavaFXDateColFactory( this );
		}
		return( factoryDateCol );
	}

	public ICFBamJavaFXDateDefFactory getDateDefFactory() {
		if( factoryDateDef == null ) {
			factoryDateDef = new CFBamJavaFXDateDefFactory( this );
		}
		return( factoryDateDef );
	}

	public ICFBamJavaFXDateTypeFactory getDateTypeFactory() {
		if( factoryDateType == null ) {
			factoryDateType = new CFBamJavaFXDateTypeFactory( this );
		}
		return( factoryDateType );
	}

	public ICFBamJavaFXDelDepFactory getDelDepFactory() {
		if( factoryDelDep == null ) {
			factoryDelDep = new CFBamJavaFXDelDepFactory( this );
		}
		return( factoryDelDep );
	}

	public ICFBamJavaFXDelSubDep1Factory getDelSubDep1Factory() {
		if( factoryDelSubDep1 == null ) {
			factoryDelSubDep1 = new CFBamJavaFXDelSubDep1Factory( this );
		}
		return( factoryDelSubDep1 );
	}

	public ICFBamJavaFXDelSubDep2Factory getDelSubDep2Factory() {
		if( factoryDelSubDep2 == null ) {
			factoryDelSubDep2 = new CFBamJavaFXDelSubDep2Factory( this );
		}
		return( factoryDelSubDep2 );
	}

	public ICFBamJavaFXDelSubDep3Factory getDelSubDep3Factory() {
		if( factoryDelSubDep3 == null ) {
			factoryDelSubDep3 = new CFBamJavaFXDelSubDep3Factory( this );
		}
		return( factoryDelSubDep3 );
	}

	public ICFBamJavaFXDelTopDepFactory getDelTopDepFactory() {
		if( factoryDelTopDep == null ) {
			factoryDelTopDep = new CFBamJavaFXDelTopDepFactory( this );
		}
		return( factoryDelTopDep );
	}

	public ICFBamJavaFXDoubleColFactory getDoubleColFactory() {
		if( factoryDoubleCol == null ) {
			factoryDoubleCol = new CFBamJavaFXDoubleColFactory( this );
		}
		return( factoryDoubleCol );
	}

	public ICFBamJavaFXDoubleDefFactory getDoubleDefFactory() {
		if( factoryDoubleDef == null ) {
			factoryDoubleDef = new CFBamJavaFXDoubleDefFactory( this );
		}
		return( factoryDoubleDef );
	}

	public ICFBamJavaFXDoubleTypeFactory getDoubleTypeFactory() {
		if( factoryDoubleType == null ) {
			factoryDoubleType = new CFBamJavaFXDoubleTypeFactory( this );
		}
		return( factoryDoubleType );
	}

	public ICFBamJavaFXEnumDefFactory getEnumDefFactory() {
		if( factoryEnumDef == null ) {
			factoryEnumDef = new CFBamJavaFXEnumDefFactory( this );
		}
		return( factoryEnumDef );
	}

	public ICFBamJavaFXEnumTagFactory getEnumTagFactory() {
		if( factoryEnumTag == null ) {
			factoryEnumTag = new CFBamJavaFXEnumTagFactory( this );
		}
		return( factoryEnumTag );
	}

	public ICFBamJavaFXEnumTypeFactory getEnumTypeFactory() {
		if( factoryEnumType == null ) {
			factoryEnumType = new CFBamJavaFXEnumTypeFactory( this );
		}
		return( factoryEnumType );
	}

	public ICFBamJavaFXFloatColFactory getFloatColFactory() {
		if( factoryFloatCol == null ) {
			factoryFloatCol = new CFBamJavaFXFloatColFactory( this );
		}
		return( factoryFloatCol );
	}

	public ICFBamJavaFXFloatDefFactory getFloatDefFactory() {
		if( factoryFloatDef == null ) {
			factoryFloatDef = new CFBamJavaFXFloatDefFactory( this );
		}
		return( factoryFloatDef );
	}

	public ICFBamJavaFXFloatTypeFactory getFloatTypeFactory() {
		if( factoryFloatType == null ) {
			factoryFloatType = new CFBamJavaFXFloatTypeFactory( this );
		}
		return( factoryFloatType );
	}

	public ICFSecJavaFXHostNodeFactory getHostNodeFactory() {
		if( factoryHostNode == null ) {
			factoryHostNode = new CFSecJavaFXHostNodeFactory( this );
		}
		return( factoryHostNode );
	}

	public ICFSecJavaFXISOCcyFactory getISOCcyFactory() {
		if( factoryISOCcy == null ) {
			factoryISOCcy = new CFSecJavaFXISOCcyFactory( this );
		}
		return( factoryISOCcy );
	}

	public ICFSecJavaFXISOCtryFactory getISOCtryFactory() {
		if( factoryISOCtry == null ) {
			factoryISOCtry = new CFSecJavaFXISOCtryFactory( this );
		}
		return( factoryISOCtry );
	}

	public ICFSecJavaFXISOCtryCcyFactory getISOCtryCcyFactory() {
		if( factoryISOCtryCcy == null ) {
			factoryISOCtryCcy = new CFSecJavaFXISOCtryCcyFactory( this );
		}
		return( factoryISOCtryCcy );
	}

	public ICFSecJavaFXISOCtryLangFactory getISOCtryLangFactory() {
		if( factoryISOCtryLang == null ) {
			factoryISOCtryLang = new CFSecJavaFXISOCtryLangFactory( this );
		}
		return( factoryISOCtryLang );
	}

	public ICFSecJavaFXISOLangFactory getISOLangFactory() {
		if( factoryISOLang == null ) {
			factoryISOLang = new CFSecJavaFXISOLangFactory( this );
		}
		return( factoryISOLang );
	}

	public ICFSecJavaFXISOTZoneFactory getISOTZoneFactory() {
		if( factoryISOTZone == null ) {
			factoryISOTZone = new CFSecJavaFXISOTZoneFactory( this );
		}
		return( factoryISOTZone );
	}

	public ICFBamJavaFXId16GenFactory getId16GenFactory() {
		if( factoryId16Gen == null ) {
			factoryId16Gen = new CFBamJavaFXId16GenFactory( this );
		}
		return( factoryId16Gen );
	}

	public ICFBamJavaFXId32GenFactory getId32GenFactory() {
		if( factoryId32Gen == null ) {
			factoryId32Gen = new CFBamJavaFXId32GenFactory( this );
		}
		return( factoryId32Gen );
	}

	public ICFBamJavaFXId64GenFactory getId64GenFactory() {
		if( factoryId64Gen == null ) {
			factoryId64Gen = new CFBamJavaFXId64GenFactory( this );
		}
		return( factoryId64Gen );
	}

	public ICFBamJavaFXIndexFactory getIndexFactory() {
		if( factoryIndex == null ) {
			factoryIndex = new CFBamJavaFXIndexFactory( this );
		}
		return( factoryIndex );
	}

	public ICFBamJavaFXIndexColFactory getIndexColFactory() {
		if( factoryIndexCol == null ) {
			factoryIndexCol = new CFBamJavaFXIndexColFactory( this );
		}
		return( factoryIndexCol );
	}

	public ICFBamJavaFXInt16ColFactory getInt16ColFactory() {
		if( factoryInt16Col == null ) {
			factoryInt16Col = new CFBamJavaFXInt16ColFactory( this );
		}
		return( factoryInt16Col );
	}

	public ICFBamJavaFXInt16DefFactory getInt16DefFactory() {
		if( factoryInt16Def == null ) {
			factoryInt16Def = new CFBamJavaFXInt16DefFactory( this );
		}
		return( factoryInt16Def );
	}

	public ICFBamJavaFXInt16TypeFactory getInt16TypeFactory() {
		if( factoryInt16Type == null ) {
			factoryInt16Type = new CFBamJavaFXInt16TypeFactory( this );
		}
		return( factoryInt16Type );
	}

	public ICFBamJavaFXInt32ColFactory getInt32ColFactory() {
		if( factoryInt32Col == null ) {
			factoryInt32Col = new CFBamJavaFXInt32ColFactory( this );
		}
		return( factoryInt32Col );
	}

	public ICFBamJavaFXInt32DefFactory getInt32DefFactory() {
		if( factoryInt32Def == null ) {
			factoryInt32Def = new CFBamJavaFXInt32DefFactory( this );
		}
		return( factoryInt32Def );
	}

	public ICFBamJavaFXInt32TypeFactory getInt32TypeFactory() {
		if( factoryInt32Type == null ) {
			factoryInt32Type = new CFBamJavaFXInt32TypeFactory( this );
		}
		return( factoryInt32Type );
	}

	public ICFBamJavaFXInt64ColFactory getInt64ColFactory() {
		if( factoryInt64Col == null ) {
			factoryInt64Col = new CFBamJavaFXInt64ColFactory( this );
		}
		return( factoryInt64Col );
	}

	public ICFBamJavaFXInt64DefFactory getInt64DefFactory() {
		if( factoryInt64Def == null ) {
			factoryInt64Def = new CFBamJavaFXInt64DefFactory( this );
		}
		return( factoryInt64Def );
	}

	public ICFBamJavaFXInt64TypeFactory getInt64TypeFactory() {
		if( factoryInt64Type == null ) {
			factoryInt64Type = new CFBamJavaFXInt64TypeFactory( this );
		}
		return( factoryInt64Type );
	}

	public ICFIntJavaFXLicenseFactory getLicenseFactory() {
		if( factoryLicense == null ) {
			factoryLicense = new CFIntJavaFXLicenseFactory( this );
		}
		return( factoryLicense );
	}

	public ICFIntJavaFXMajorVersionFactory getMajorVersionFactory() {
		if( factoryMajorVersion == null ) {
			factoryMajorVersion = new CFIntJavaFXMajorVersionFactory( this );
		}
		return( factoryMajorVersion );
	}

	public ICFIntJavaFXMimeTypeFactory getMimeTypeFactory() {
		if( factoryMimeType == null ) {
			factoryMimeType = new CFIntJavaFXMimeTypeFactory( this );
		}
		return( factoryMimeType );
	}

	public ICFIntJavaFXMinorVersionFactory getMinorVersionFactory() {
		if( factoryMinorVersion == null ) {
			factoryMinorVersion = new CFIntJavaFXMinorVersionFactory( this );
		}
		return( factoryMinorVersion );
	}

	public ICFBamJavaFXNmTokenColFactory getNmTokenColFactory() {
		if( factoryNmTokenCol == null ) {
			factoryNmTokenCol = new CFBamJavaFXNmTokenColFactory( this );
		}
		return( factoryNmTokenCol );
	}

	public ICFBamJavaFXNmTokenDefFactory getNmTokenDefFactory() {
		if( factoryNmTokenDef == null ) {
			factoryNmTokenDef = new CFBamJavaFXNmTokenDefFactory( this );
		}
		return( factoryNmTokenDef );
	}

	public ICFBamJavaFXNmTokenTypeFactory getNmTokenTypeFactory() {
		if( factoryNmTokenType == null ) {
			factoryNmTokenType = new CFBamJavaFXNmTokenTypeFactory( this );
		}
		return( factoryNmTokenType );
	}

	public ICFBamJavaFXNmTokensColFactory getNmTokensColFactory() {
		if( factoryNmTokensCol == null ) {
			factoryNmTokensCol = new CFBamJavaFXNmTokensColFactory( this );
		}
		return( factoryNmTokensCol );
	}

	public ICFBamJavaFXNmTokensDefFactory getNmTokensDefFactory() {
		if( factoryNmTokensDef == null ) {
			factoryNmTokensDef = new CFBamJavaFXNmTokensDefFactory( this );
		}
		return( factoryNmTokensDef );
	}

	public ICFBamJavaFXNmTokensTypeFactory getNmTokensTypeFactory() {
		if( factoryNmTokensType == null ) {
			factoryNmTokensType = new CFBamJavaFXNmTokensTypeFactory( this );
		}
		return( factoryNmTokensType );
	}

	public ICFBamJavaFXNumberColFactory getNumberColFactory() {
		if( factoryNumberCol == null ) {
			factoryNumberCol = new CFBamJavaFXNumberColFactory( this );
		}
		return( factoryNumberCol );
	}

	public ICFBamJavaFXNumberDefFactory getNumberDefFactory() {
		if( factoryNumberDef == null ) {
			factoryNumberDef = new CFBamJavaFXNumberDefFactory( this );
		}
		return( factoryNumberDef );
	}

	public ICFBamJavaFXNumberTypeFactory getNumberTypeFactory() {
		if( factoryNumberType == null ) {
			factoryNumberType = new CFBamJavaFXNumberTypeFactory( this );
		}
		return( factoryNumberType );
	}

	public ICFBamJavaFXParamFactory getParamFactory() {
		if( factoryParam == null ) {
			factoryParam = new CFBamJavaFXParamFactory( this );
		}
		return( factoryParam );
	}

	public ICFBamJavaFXPopDepFactory getPopDepFactory() {
		if( factoryPopDep == null ) {
			factoryPopDep = new CFBamJavaFXPopDepFactory( this );
		}
		return( factoryPopDep );
	}

	public ICFBamJavaFXPopSubDep1Factory getPopSubDep1Factory() {
		if( factoryPopSubDep1 == null ) {
			factoryPopSubDep1 = new CFBamJavaFXPopSubDep1Factory( this );
		}
		return( factoryPopSubDep1 );
	}

	public ICFBamJavaFXPopSubDep2Factory getPopSubDep2Factory() {
		if( factoryPopSubDep2 == null ) {
			factoryPopSubDep2 = new CFBamJavaFXPopSubDep2Factory( this );
		}
		return( factoryPopSubDep2 );
	}

	public ICFBamJavaFXPopSubDep3Factory getPopSubDep3Factory() {
		if( factoryPopSubDep3 == null ) {
			factoryPopSubDep3 = new CFBamJavaFXPopSubDep3Factory( this );
		}
		return( factoryPopSubDep3 );
	}

	public ICFBamJavaFXPopTopDepFactory getPopTopDepFactory() {
		if( factoryPopTopDep == null ) {
			factoryPopTopDep = new CFBamJavaFXPopTopDepFactory( this );
		}
		return( factoryPopTopDep );
	}

	public ICFBamJavaFXRelationFactory getRelationFactory() {
		if( factoryRelation == null ) {
			factoryRelation = new CFBamJavaFXRelationFactory( this );
		}
		return( factoryRelation );
	}

	public ICFBamJavaFXRelationColFactory getRelationColFactory() {
		if( factoryRelationCol == null ) {
			factoryRelationCol = new CFBamJavaFXRelationColFactory( this );
		}
		return( factoryRelationCol );
	}

	public ICFBamJavaFXSchemaDefFactory getSchemaDefFactory() {
		if( factorySchemaDef == null ) {
			factorySchemaDef = new CFBamJavaFXSchemaDefFactory( this );
		}
		return( factorySchemaDef );
	}

	public ICFBamJavaFXSchemaRefFactory getSchemaRefFactory() {
		if( factorySchemaRef == null ) {
			factorySchemaRef = new CFBamJavaFXSchemaRefFactory( this );
		}
		return( factorySchemaRef );
	}

	public ICFBamJavaFXScopeFactory getScopeFactory() {
		if( factoryScope == null ) {
			factoryScope = new CFBamJavaFXScopeFactory( this );
		}
		return( factoryScope );
	}

	public ICFSecJavaFXSecAppFactory getSecAppFactory() {
		if( factorySecApp == null ) {
			factorySecApp = new CFSecJavaFXSecAppFactory( this );
		}
		return( factorySecApp );
	}

	public ICFSecJavaFXSecDeviceFactory getSecDeviceFactory() {
		if( factorySecDevice == null ) {
			factorySecDevice = new CFSecJavaFXSecDeviceFactory( this );
		}
		return( factorySecDevice );
	}

	public ICFSecJavaFXSecFormFactory getSecFormFactory() {
		if( factorySecForm == null ) {
			factorySecForm = new CFSecJavaFXSecFormFactory( this );
		}
		return( factorySecForm );
	}

	public ICFSecJavaFXSecGroupFactory getSecGroupFactory() {
		if( factorySecGroup == null ) {
			factorySecGroup = new CFSecJavaFXSecGroupFactory( this );
		}
		return( factorySecGroup );
	}

	public ICFSecJavaFXSecGroupFormFactory getSecGroupFormFactory() {
		if( factorySecGroupForm == null ) {
			factorySecGroupForm = new CFSecJavaFXSecGroupFormFactory( this );
		}
		return( factorySecGroupForm );
	}

	public ICFSecJavaFXSecGrpIncFactory getSecGrpIncFactory() {
		if( factorySecGrpInc == null ) {
			factorySecGrpInc = new CFSecJavaFXSecGrpIncFactory( this );
		}
		return( factorySecGrpInc );
	}

	public ICFSecJavaFXSecGrpMembFactory getSecGrpMembFactory() {
		if( factorySecGrpMemb == null ) {
			factorySecGrpMemb = new CFSecJavaFXSecGrpMembFactory( this );
		}
		return( factorySecGrpMemb );
	}

	public ICFSecJavaFXSecSessionFactory getSecSessionFactory() {
		if( factorySecSession == null ) {
			factorySecSession = new CFSecJavaFXSecSessionFactory( this );
		}
		return( factorySecSession );
	}

	public ICFSecJavaFXSecUserFactory getSecUserFactory() {
		if( factorySecUser == null ) {
			factorySecUser = new CFSecJavaFXSecUserFactory( this );
		}
		return( factorySecUser );
	}

	public ICFBamJavaFXServerListFuncFactory getServerListFuncFactory() {
		if( factoryServerListFunc == null ) {
			factoryServerListFunc = new CFBamJavaFXServerListFuncFactory( this );
		}
		return( factoryServerListFunc );
	}

	public ICFBamJavaFXServerMethodFactory getServerMethodFactory() {
		if( factoryServerMethod == null ) {
			factoryServerMethod = new CFBamJavaFXServerMethodFactory( this );
		}
		return( factoryServerMethod );
	}

	public ICFBamJavaFXServerObjFuncFactory getServerObjFuncFactory() {
		if( factoryServerObjFunc == null ) {
			factoryServerObjFunc = new CFBamJavaFXServerObjFuncFactory( this );
		}
		return( factoryServerObjFunc );
	}

	public ICFBamJavaFXServerProcFactory getServerProcFactory() {
		if( factoryServerProc == null ) {
			factoryServerProc = new CFBamJavaFXServerProcFactory( this );
		}
		return( factoryServerProc );
	}

	public ICFSecJavaFXServiceFactory getServiceFactory() {
		if( factoryService == null ) {
			factoryService = new CFSecJavaFXServiceFactory( this );
		}
		return( factoryService );
	}

	public ICFSecJavaFXServiceTypeFactory getServiceTypeFactory() {
		if( factoryServiceType == null ) {
			factoryServiceType = new CFSecJavaFXServiceTypeFactory( this );
		}
		return( factoryServiceType );
	}

	public ICFBamJavaFXStringColFactory getStringColFactory() {
		if( factoryStringCol == null ) {
			factoryStringCol = new CFBamJavaFXStringColFactory( this );
		}
		return( factoryStringCol );
	}

	public ICFBamJavaFXStringDefFactory getStringDefFactory() {
		if( factoryStringDef == null ) {
			factoryStringDef = new CFBamJavaFXStringDefFactory( this );
		}
		return( factoryStringDef );
	}

	public ICFBamJavaFXStringTypeFactory getStringTypeFactory() {
		if( factoryStringType == null ) {
			factoryStringType = new CFBamJavaFXStringTypeFactory( this );
		}
		return( factoryStringType );
	}

	public ICFIntJavaFXSubProjectFactory getSubProjectFactory() {
		if( factorySubProject == null ) {
			factorySubProject = new CFIntJavaFXSubProjectFactory( this );
		}
		return( factorySubProject );
	}

	public ICFSecJavaFXSysClusterFactory getSysClusterFactory() {
		if( factorySysCluster == null ) {
			factorySysCluster = new CFSecJavaFXSysClusterFactory( this );
		}
		return( factorySysCluster );
	}

	public ICFSecJavaFXTSecGroupFactory getTSecGroupFactory() {
		if( factoryTSecGroup == null ) {
			factoryTSecGroup = new CFSecJavaFXTSecGroupFactory( this );
		}
		return( factoryTSecGroup );
	}

	public ICFSecJavaFXTSecGrpIncFactory getTSecGrpIncFactory() {
		if( factoryTSecGrpInc == null ) {
			factoryTSecGrpInc = new CFSecJavaFXTSecGrpIncFactory( this );
		}
		return( factoryTSecGrpInc );
	}

	public ICFSecJavaFXTSecGrpMembFactory getTSecGrpMembFactory() {
		if( factoryTSecGrpMemb == null ) {
			factoryTSecGrpMemb = new CFSecJavaFXTSecGrpMembFactory( this );
		}
		return( factoryTSecGrpMemb );
	}

	public ICFBamJavaFXTZDateColFactory getTZDateColFactory() {
		if( factoryTZDateCol == null ) {
			factoryTZDateCol = new CFBamJavaFXTZDateColFactory( this );
		}
		return( factoryTZDateCol );
	}

	public ICFBamJavaFXTZDateDefFactory getTZDateDefFactory() {
		if( factoryTZDateDef == null ) {
			factoryTZDateDef = new CFBamJavaFXTZDateDefFactory( this );
		}
		return( factoryTZDateDef );
	}

	public ICFBamJavaFXTZDateTypeFactory getTZDateTypeFactory() {
		if( factoryTZDateType == null ) {
			factoryTZDateType = new CFBamJavaFXTZDateTypeFactory( this );
		}
		return( factoryTZDateType );
	}

	public ICFBamJavaFXTZTimeColFactory getTZTimeColFactory() {
		if( factoryTZTimeCol == null ) {
			factoryTZTimeCol = new CFBamJavaFXTZTimeColFactory( this );
		}
		return( factoryTZTimeCol );
	}

	public ICFBamJavaFXTZTimeDefFactory getTZTimeDefFactory() {
		if( factoryTZTimeDef == null ) {
			factoryTZTimeDef = new CFBamJavaFXTZTimeDefFactory( this );
		}
		return( factoryTZTimeDef );
	}

	public ICFBamJavaFXTZTimeTypeFactory getTZTimeTypeFactory() {
		if( factoryTZTimeType == null ) {
			factoryTZTimeType = new CFBamJavaFXTZTimeTypeFactory( this );
		}
		return( factoryTZTimeType );
	}

	public ICFBamJavaFXTZTimestampColFactory getTZTimestampColFactory() {
		if( factoryTZTimestampCol == null ) {
			factoryTZTimestampCol = new CFBamJavaFXTZTimestampColFactory( this );
		}
		return( factoryTZTimestampCol );
	}

	public ICFBamJavaFXTZTimestampDefFactory getTZTimestampDefFactory() {
		if( factoryTZTimestampDef == null ) {
			factoryTZTimestampDef = new CFBamJavaFXTZTimestampDefFactory( this );
		}
		return( factoryTZTimestampDef );
	}

	public ICFBamJavaFXTZTimestampTypeFactory getTZTimestampTypeFactory() {
		if( factoryTZTimestampType == null ) {
			factoryTZTimestampType = new CFBamJavaFXTZTimestampTypeFactory( this );
		}
		return( factoryTZTimestampType );
	}

	public ICFBamJavaFXTableFactory getTableFactory() {
		if( factoryTable == null ) {
			factoryTable = new CFBamJavaFXTableFactory( this );
		}
		return( factoryTable );
	}

	public ICFBamJavaFXTableColFactory getTableColFactory() {
		if( factoryTableCol == null ) {
			factoryTableCol = new CFBamJavaFXTableColFactory( this );
		}
		return( factoryTableCol );
	}

	public ICFSecJavaFXTenantFactory getTenantFactory() {
		if( factoryTenant == null ) {
			factoryTenant = new CFSecJavaFXTenantFactory( this );
		}
		return( factoryTenant );
	}

	public ICFBamJavaFXTextColFactory getTextColFactory() {
		if( factoryTextCol == null ) {
			factoryTextCol = new CFBamJavaFXTextColFactory( this );
		}
		return( factoryTextCol );
	}

	public ICFBamJavaFXTextDefFactory getTextDefFactory() {
		if( factoryTextDef == null ) {
			factoryTextDef = new CFBamJavaFXTextDefFactory( this );
		}
		return( factoryTextDef );
	}

	public ICFBamJavaFXTextTypeFactory getTextTypeFactory() {
		if( factoryTextType == null ) {
			factoryTextType = new CFBamJavaFXTextTypeFactory( this );
		}
		return( factoryTextType );
	}

	public ICFBamJavaFXTimeColFactory getTimeColFactory() {
		if( factoryTimeCol == null ) {
			factoryTimeCol = new CFBamJavaFXTimeColFactory( this );
		}
		return( factoryTimeCol );
	}

	public ICFBamJavaFXTimeDefFactory getTimeDefFactory() {
		if( factoryTimeDef == null ) {
			factoryTimeDef = new CFBamJavaFXTimeDefFactory( this );
		}
		return( factoryTimeDef );
	}

	public ICFBamJavaFXTimeTypeFactory getTimeTypeFactory() {
		if( factoryTimeType == null ) {
			factoryTimeType = new CFBamJavaFXTimeTypeFactory( this );
		}
		return( factoryTimeType );
	}

	public ICFBamJavaFXTimestampColFactory getTimestampColFactory() {
		if( factoryTimestampCol == null ) {
			factoryTimestampCol = new CFBamJavaFXTimestampColFactory( this );
		}
		return( factoryTimestampCol );
	}

	public ICFBamJavaFXTimestampDefFactory getTimestampDefFactory() {
		if( factoryTimestampDef == null ) {
			factoryTimestampDef = new CFBamJavaFXTimestampDefFactory( this );
		}
		return( factoryTimestampDef );
	}

	public ICFBamJavaFXTimestampTypeFactory getTimestampTypeFactory() {
		if( factoryTimestampType == null ) {
			factoryTimestampType = new CFBamJavaFXTimestampTypeFactory( this );
		}
		return( factoryTimestampType );
	}

	public ICFIntJavaFXTldFactory getTldFactory() {
		if( factoryTld == null ) {
			factoryTld = new CFIntJavaFXTldFactory( this );
		}
		return( factoryTld );
	}

	public ICFBamJavaFXTokenColFactory getTokenColFactory() {
		if( factoryTokenCol == null ) {
			factoryTokenCol = new CFBamJavaFXTokenColFactory( this );
		}
		return( factoryTokenCol );
	}

	public ICFBamJavaFXTokenDefFactory getTokenDefFactory() {
		if( factoryTokenDef == null ) {
			factoryTokenDef = new CFBamJavaFXTokenDefFactory( this );
		}
		return( factoryTokenDef );
	}

	public ICFBamJavaFXTokenTypeFactory getTokenTypeFactory() {
		if( factoryTokenType == null ) {
			factoryTokenType = new CFBamJavaFXTokenTypeFactory( this );
		}
		return( factoryTokenType );
	}

	public ICFIntJavaFXTopDomainFactory getTopDomainFactory() {
		if( factoryTopDomain == null ) {
			factoryTopDomain = new CFIntJavaFXTopDomainFactory( this );
		}
		return( factoryTopDomain );
	}

	public ICFIntJavaFXTopProjectFactory getTopProjectFactory() {
		if( factoryTopProject == null ) {
			factoryTopProject = new CFIntJavaFXTopProjectFactory( this );
		}
		return( factoryTopProject );
	}

	public ICFBamJavaFXUInt16ColFactory getUInt16ColFactory() {
		if( factoryUInt16Col == null ) {
			factoryUInt16Col = new CFBamJavaFXUInt16ColFactory( this );
		}
		return( factoryUInt16Col );
	}

	public ICFBamJavaFXUInt16DefFactory getUInt16DefFactory() {
		if( factoryUInt16Def == null ) {
			factoryUInt16Def = new CFBamJavaFXUInt16DefFactory( this );
		}
		return( factoryUInt16Def );
	}

	public ICFBamJavaFXUInt16TypeFactory getUInt16TypeFactory() {
		if( factoryUInt16Type == null ) {
			factoryUInt16Type = new CFBamJavaFXUInt16TypeFactory( this );
		}
		return( factoryUInt16Type );
	}

	public ICFBamJavaFXUInt32ColFactory getUInt32ColFactory() {
		if( factoryUInt32Col == null ) {
			factoryUInt32Col = new CFBamJavaFXUInt32ColFactory( this );
		}
		return( factoryUInt32Col );
	}

	public ICFBamJavaFXUInt32DefFactory getUInt32DefFactory() {
		if( factoryUInt32Def == null ) {
			factoryUInt32Def = new CFBamJavaFXUInt32DefFactory( this );
		}
		return( factoryUInt32Def );
	}

	public ICFBamJavaFXUInt32TypeFactory getUInt32TypeFactory() {
		if( factoryUInt32Type == null ) {
			factoryUInt32Type = new CFBamJavaFXUInt32TypeFactory( this );
		}
		return( factoryUInt32Type );
	}

	public ICFBamJavaFXUInt64ColFactory getUInt64ColFactory() {
		if( factoryUInt64Col == null ) {
			factoryUInt64Col = new CFBamJavaFXUInt64ColFactory( this );
		}
		return( factoryUInt64Col );
	}

	public ICFBamJavaFXUInt64DefFactory getUInt64DefFactory() {
		if( factoryUInt64Def == null ) {
			factoryUInt64Def = new CFBamJavaFXUInt64DefFactory( this );
		}
		return( factoryUInt64Def );
	}

	public ICFBamJavaFXUInt64TypeFactory getUInt64TypeFactory() {
		if( factoryUInt64Type == null ) {
			factoryUInt64Type = new CFBamJavaFXUInt64TypeFactory( this );
		}
		return( factoryUInt64Type );
	}

	public ICFIntJavaFXURLProtocolFactory getURLProtocolFactory() {
		if( factoryURLProtocol == null ) {
			factoryURLProtocol = new CFIntJavaFXURLProtocolFactory( this );
		}
		return( factoryURLProtocol );
	}

	public ICFBamJavaFXUuidColFactory getUuidColFactory() {
		if( factoryUuidCol == null ) {
			factoryUuidCol = new CFBamJavaFXUuidColFactory( this );
		}
		return( factoryUuidCol );
	}

	public ICFBamJavaFXUuidDefFactory getUuidDefFactory() {
		if( factoryUuidDef == null ) {
			factoryUuidDef = new CFBamJavaFXUuidDefFactory( this );
		}
		return( factoryUuidDef );
	}

	public ICFBamJavaFXUuidGenFactory getUuidGenFactory() {
		if( factoryUuidGen == null ) {
			factoryUuidGen = new CFBamJavaFXUuidGenFactory( this );
		}
		return( factoryUuidGen );
	}

	public ICFBamJavaFXUuidTypeFactory getUuidTypeFactory() {
		if( factoryUuidType == null ) {
			factoryUuidType = new CFBamJavaFXUuidTypeFactory( this );
		}
		return( factoryUuidType );
	}

	public ICFBamJavaFXValueFactory getValueFactory() {
		if( factoryValue == null ) {
			factoryValue = new CFBamJavaFXValueFactory( this );
		}
		return( factoryValue );
	}
}
