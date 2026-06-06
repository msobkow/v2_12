// Description: Java 11 Schema Object implementation for CFBam.

/*
 *	org.msscf.msscf.CFBam
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

package org.msscf.msscf.cfbam.CFBamObj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.msscf.msscf.cflib.CFLib.*;
import org.msscf.msscf.cfsec.CFSec.*;
import org.msscf.msscf.cfint.CFInt.*;
import org.msscf.msscf.cfsec.CFSecObj.*;
import org.msscf.msscf.cfint.CFIntObj.*;
import org.msscf.msscf.cfbam.CFBam.*;
public class CFBamSchemaObj
	implements ICFBamSchemaObj
{
	public static String SCHEMA_NAME = "CFBam";
	public static String SCHEMA_DBNAME = "cfbam212";
	protected CFSecAuthorization authorization = null;
	protected ICFSecSchema backingStore = null;
	protected String secClusterName = "system";
	protected String secTenantName = "system";
	protected String secUserName = "system";
	protected ICFSecClusterObj secCluster = null;
	protected long secClusterId = 0L;
	protected ICFSecTenantObj secTenant = null;
	protected long secTenantId = 0L;
	protected ICFSecSecUserObj secUser = null;
	protected UUID secSessionUserId = null;
	protected ICFSecSecSessionObj secSession = null;
	protected UUID secSessionSessionId = null;
	protected String schemaDbName = SCHEMA_DBNAME;
	protected String lowerDbSchemaName = SCHEMA_DBNAME.toLowerCase();
	protected ICFBamAtomTableObj atomTableObj;
	protected ICFBamBlobColTableObj blobColTableObj;
	protected ICFBamBlobDefTableObj blobDefTableObj;
	protected ICFBamBlobTypeTableObj blobTypeTableObj;
	protected ICFBamBoolColTableObj boolColTableObj;
	protected ICFBamBoolDefTableObj boolDefTableObj;
	protected ICFBamBoolTypeTableObj boolTypeTableObj;
	protected ICFBamChainTableObj chainTableObj;
	protected ICFBamClearDepTableObj clearDepTableObj;
	protected ICFBamClearSubDep1TableObj clearSubDep1TableObj;
	protected ICFBamClearSubDep2TableObj clearSubDep2TableObj;
	protected ICFBamClearSubDep3TableObj clearSubDep3TableObj;
	protected ICFBamClearTopDepTableObj clearTopDepTableObj;
	protected ICFBamClusterTableObj clusterTableObj;
	protected ICFBamDateColTableObj dateColTableObj;
	protected ICFBamDateDefTableObj dateDefTableObj;
	protected ICFBamDateTypeTableObj dateTypeTableObj;
	protected ICFBamDelDepTableObj delDepTableObj;
	protected ICFBamDelSubDep1TableObj delSubDep1TableObj;
	protected ICFBamDelSubDep2TableObj delSubDep2TableObj;
	protected ICFBamDelSubDep3TableObj delSubDep3TableObj;
	protected ICFBamDelTopDepTableObj delTopDepTableObj;
	protected ICFBamDoubleColTableObj doubleColTableObj;
	protected ICFBamDoubleDefTableObj doubleDefTableObj;
	protected ICFBamDoubleTypeTableObj doubleTypeTableObj;
	protected ICFBamEnumDefTableObj enumDefTableObj;
	protected ICFBamEnumTagTableObj enumTagTableObj;
	protected ICFBamEnumTypeTableObj enumTypeTableObj;
	protected ICFBamFloatColTableObj floatColTableObj;
	protected ICFBamFloatDefTableObj floatDefTableObj;
	protected ICFBamFloatTypeTableObj floatTypeTableObj;
	protected ICFBamHostNodeTableObj hostNodeTableObj;
	protected ICFBamISOCcyTableObj iSOCcyTableObj;
	protected ICFBamISOCtryTableObj iSOCtryTableObj;
	protected ICFBamISOCtryCcyTableObj iSOCtryCcyTableObj;
	protected ICFBamISOCtryLangTableObj iSOCtryLangTableObj;
	protected ICFBamISOLangTableObj iSOLangTableObj;
	protected ICFBamISOTZoneTableObj iSOTZoneTableObj;
	protected ICFBamId16GenTableObj id16GenTableObj;
	protected ICFBamId32GenTableObj id32GenTableObj;
	protected ICFBamId64GenTableObj id64GenTableObj;
	protected ICFBamIndexTableObj indexTableObj;
	protected ICFBamIndexColTableObj indexColTableObj;
	protected ICFBamInt16ColTableObj int16ColTableObj;
	protected ICFBamInt16DefTableObj int16DefTableObj;
	protected ICFBamInt16TypeTableObj int16TypeTableObj;
	protected ICFBamInt32ColTableObj int32ColTableObj;
	protected ICFBamInt32DefTableObj int32DefTableObj;
	protected ICFBamInt32TypeTableObj int32TypeTableObj;
	protected ICFBamInt64ColTableObj int64ColTableObj;
	protected ICFBamInt64DefTableObj int64DefTableObj;
	protected ICFBamInt64TypeTableObj int64TypeTableObj;
	protected ICFBamLicenseTableObj licenseTableObj;
	protected ICFBamMajorVersionTableObj majorVersionTableObj;
	protected ICFBamMimeTypeTableObj mimeTypeTableObj;
	protected ICFBamMinorVersionTableObj minorVersionTableObj;
	protected ICFBamNmTokenColTableObj nmTokenColTableObj;
	protected ICFBamNmTokenDefTableObj nmTokenDefTableObj;
	protected ICFBamNmTokenTypeTableObj nmTokenTypeTableObj;
	protected ICFBamNmTokensColTableObj nmTokensColTableObj;
	protected ICFBamNmTokensDefTableObj nmTokensDefTableObj;
	protected ICFBamNmTokensTypeTableObj nmTokensTypeTableObj;
	protected ICFBamNumberColTableObj numberColTableObj;
	protected ICFBamNumberDefTableObj numberDefTableObj;
	protected ICFBamNumberTypeTableObj numberTypeTableObj;
	protected ICFBamParamTableObj paramTableObj;
	protected ICFBamPopDepTableObj popDepTableObj;
	protected ICFBamPopSubDep1TableObj popSubDep1TableObj;
	protected ICFBamPopSubDep2TableObj popSubDep2TableObj;
	protected ICFBamPopSubDep3TableObj popSubDep3TableObj;
	protected ICFBamPopTopDepTableObj popTopDepTableObj;
	protected ICFBamRelationTableObj relationTableObj;
	protected ICFBamRelationColTableObj relationColTableObj;
	protected ICFBamSchemaDefTableObj schemaDefTableObj;
	protected ICFBamSchemaRefTableObj schemaRefTableObj;
	protected ICFBamScopeTableObj scopeTableObj;
	protected ICFBamSecAppTableObj secAppTableObj;
	protected ICFBamSecDeviceTableObj secDeviceTableObj;
	protected ICFBamSecFormTableObj secFormTableObj;
	protected ICFBamSecGroupTableObj secGroupTableObj;
	protected ICFBamSecGroupFormTableObj secGroupFormTableObj;
	protected ICFBamSecGrpIncTableObj secGrpIncTableObj;
	protected ICFBamSecGrpMembTableObj secGrpMembTableObj;
	protected ICFBamSecSessionTableObj secSessionTableObj;
	protected ICFBamSecUserTableObj secUserTableObj;
	protected ICFBamServerListFuncTableObj serverListFuncTableObj;
	protected ICFBamServerMethodTableObj serverMethodTableObj;
	protected ICFBamServerObjFuncTableObj serverObjFuncTableObj;
	protected ICFBamServerProcTableObj serverProcTableObj;
	protected ICFBamServiceTableObj serviceTableObj;
	protected ICFBamServiceTypeTableObj serviceTypeTableObj;
	protected ICFBamStringColTableObj stringColTableObj;
	protected ICFBamStringDefTableObj stringDefTableObj;
	protected ICFBamStringTypeTableObj stringTypeTableObj;
	protected ICFBamSubProjectTableObj subProjectTableObj;
	protected ICFBamSysClusterTableObj sysClusterTableObj;
	protected ICFBamTSecGroupTableObj tSecGroupTableObj;
	protected ICFBamTSecGrpIncTableObj tSecGrpIncTableObj;
	protected ICFBamTSecGrpMembTableObj tSecGrpMembTableObj;
	protected ICFBamTZDateColTableObj tZDateColTableObj;
	protected ICFBamTZDateDefTableObj tZDateDefTableObj;
	protected ICFBamTZDateTypeTableObj tZDateTypeTableObj;
	protected ICFBamTZTimeColTableObj tZTimeColTableObj;
	protected ICFBamTZTimeDefTableObj tZTimeDefTableObj;
	protected ICFBamTZTimeTypeTableObj tZTimeTypeTableObj;
	protected ICFBamTZTimestampColTableObj tZTimestampColTableObj;
	protected ICFBamTZTimestampDefTableObj tZTimestampDefTableObj;
	protected ICFBamTZTimestampTypeTableObj tZTimestampTypeTableObj;
	protected ICFBamTableTableObj tableTableObj;
	protected ICFBamTableColTableObj tableColTableObj;
	protected ICFBamTenantTableObj tenantTableObj;
	protected ICFBamTextColTableObj textColTableObj;
	protected ICFBamTextDefTableObj textDefTableObj;
	protected ICFBamTextTypeTableObj textTypeTableObj;
	protected ICFBamTimeColTableObj timeColTableObj;
	protected ICFBamTimeDefTableObj timeDefTableObj;
	protected ICFBamTimeTypeTableObj timeTypeTableObj;
	protected ICFBamTimestampColTableObj timestampColTableObj;
	protected ICFBamTimestampDefTableObj timestampDefTableObj;
	protected ICFBamTimestampTypeTableObj timestampTypeTableObj;
	protected ICFBamTldTableObj tldTableObj;
	protected ICFBamTokenColTableObj tokenColTableObj;
	protected ICFBamTokenDefTableObj tokenDefTableObj;
	protected ICFBamTokenTypeTableObj tokenTypeTableObj;
	protected ICFBamTopDomainTableObj topDomainTableObj;
	protected ICFBamTopProjectTableObj topProjectTableObj;
	protected ICFBamUInt16ColTableObj uInt16ColTableObj;
	protected ICFBamUInt16DefTableObj uInt16DefTableObj;
	protected ICFBamUInt16TypeTableObj uInt16TypeTableObj;
	protected ICFBamUInt32ColTableObj uInt32ColTableObj;
	protected ICFBamUInt32DefTableObj uInt32DefTableObj;
	protected ICFBamUInt32TypeTableObj uInt32TypeTableObj;
	protected ICFBamUInt64ColTableObj uInt64ColTableObj;
	protected ICFBamUInt64DefTableObj uInt64DefTableObj;
	protected ICFBamUInt64TypeTableObj uInt64TypeTableObj;
	protected ICFBamURLProtocolTableObj uRLProtocolTableObj;
	protected ICFBamUuidColTableObj uuidColTableObj;
	protected ICFBamUuidDefTableObj uuidDefTableObj;
	protected ICFBamUuidGenTableObj uuidGenTableObj;
	protected ICFBamUuidTypeTableObj uuidTypeTableObj;
	protected ICFBamValueTableObj valueTableObj;

	public CFBamSchemaObj() {
		atomTableObj = new CFBamAtomTableObj( this );
		blobColTableObj = new CFBamBlobColTableObj( this );
		blobDefTableObj = new CFBamBlobDefTableObj( this );
		blobTypeTableObj = new CFBamBlobTypeTableObj( this );
		boolColTableObj = new CFBamBoolColTableObj( this );
		boolDefTableObj = new CFBamBoolDefTableObj( this );
		boolTypeTableObj = new CFBamBoolTypeTableObj( this );
		chainTableObj = new CFBamChainTableObj( this );
		clearDepTableObj = new CFBamClearDepTableObj( this );
		clearSubDep1TableObj = new CFBamClearSubDep1TableObj( this );
		clearSubDep2TableObj = new CFBamClearSubDep2TableObj( this );
		clearSubDep3TableObj = new CFBamClearSubDep3TableObj( this );
		clearTopDepTableObj = new CFBamClearTopDepTableObj( this );
		clusterTableObj = new CFBamClusterTableObj( this );
		dateColTableObj = new CFBamDateColTableObj( this );
		dateDefTableObj = new CFBamDateDefTableObj( this );
		dateTypeTableObj = new CFBamDateTypeTableObj( this );
		delDepTableObj = new CFBamDelDepTableObj( this );
		delSubDep1TableObj = new CFBamDelSubDep1TableObj( this );
		delSubDep2TableObj = new CFBamDelSubDep2TableObj( this );
		delSubDep3TableObj = new CFBamDelSubDep3TableObj( this );
		delTopDepTableObj = new CFBamDelTopDepTableObj( this );
		doubleColTableObj = new CFBamDoubleColTableObj( this );
		doubleDefTableObj = new CFBamDoubleDefTableObj( this );
		doubleTypeTableObj = new CFBamDoubleTypeTableObj( this );
		enumDefTableObj = new CFBamEnumDefTableObj( this );
		enumTagTableObj = new CFBamEnumTagTableObj( this );
		enumTypeTableObj = new CFBamEnumTypeTableObj( this );
		floatColTableObj = new CFBamFloatColTableObj( this );
		floatDefTableObj = new CFBamFloatDefTableObj( this );
		floatTypeTableObj = new CFBamFloatTypeTableObj( this );
		hostNodeTableObj = new CFBamHostNodeTableObj( this );
		iSOCcyTableObj = new CFBamISOCcyTableObj( this );
		iSOCtryTableObj = new CFBamISOCtryTableObj( this );
		iSOCtryCcyTableObj = new CFBamISOCtryCcyTableObj( this );
		iSOCtryLangTableObj = new CFBamISOCtryLangTableObj( this );
		iSOLangTableObj = new CFBamISOLangTableObj( this );
		iSOTZoneTableObj = new CFBamISOTZoneTableObj( this );
		id16GenTableObj = new CFBamId16GenTableObj( this );
		id32GenTableObj = new CFBamId32GenTableObj( this );
		id64GenTableObj = new CFBamId64GenTableObj( this );
		indexTableObj = new CFBamIndexTableObj( this );
		indexColTableObj = new CFBamIndexColTableObj( this );
		int16ColTableObj = new CFBamInt16ColTableObj( this );
		int16DefTableObj = new CFBamInt16DefTableObj( this );
		int16TypeTableObj = new CFBamInt16TypeTableObj( this );
		int32ColTableObj = new CFBamInt32ColTableObj( this );
		int32DefTableObj = new CFBamInt32DefTableObj( this );
		int32TypeTableObj = new CFBamInt32TypeTableObj( this );
		int64ColTableObj = new CFBamInt64ColTableObj( this );
		int64DefTableObj = new CFBamInt64DefTableObj( this );
		int64TypeTableObj = new CFBamInt64TypeTableObj( this );
		licenseTableObj = new CFBamLicenseTableObj( this );
		majorVersionTableObj = new CFBamMajorVersionTableObj( this );
		mimeTypeTableObj = new CFBamMimeTypeTableObj( this );
		minorVersionTableObj = new CFBamMinorVersionTableObj( this );
		nmTokenColTableObj = new CFBamNmTokenColTableObj( this );
		nmTokenDefTableObj = new CFBamNmTokenDefTableObj( this );
		nmTokenTypeTableObj = new CFBamNmTokenTypeTableObj( this );
		nmTokensColTableObj = new CFBamNmTokensColTableObj( this );
		nmTokensDefTableObj = new CFBamNmTokensDefTableObj( this );
		nmTokensTypeTableObj = new CFBamNmTokensTypeTableObj( this );
		numberColTableObj = new CFBamNumberColTableObj( this );
		numberDefTableObj = new CFBamNumberDefTableObj( this );
		numberTypeTableObj = new CFBamNumberTypeTableObj( this );
		paramTableObj = new CFBamParamTableObj( this );
		popDepTableObj = new CFBamPopDepTableObj( this );
		popSubDep1TableObj = new CFBamPopSubDep1TableObj( this );
		popSubDep2TableObj = new CFBamPopSubDep2TableObj( this );
		popSubDep3TableObj = new CFBamPopSubDep3TableObj( this );
		popTopDepTableObj = new CFBamPopTopDepTableObj( this );
		relationTableObj = new CFBamRelationTableObj( this );
		relationColTableObj = new CFBamRelationColTableObj( this );
		schemaDefTableObj = new CFBamSchemaDefTableObj( this );
		schemaRefTableObj = new CFBamSchemaRefTableObj( this );
		scopeTableObj = new CFBamScopeTableObj( this );
		secAppTableObj = new CFBamSecAppTableObj( this );
		secDeviceTableObj = new CFBamSecDeviceTableObj( this );
		secFormTableObj = new CFBamSecFormTableObj( this );
		secGroupTableObj = new CFBamSecGroupTableObj( this );
		secGroupFormTableObj = new CFBamSecGroupFormTableObj( this );
		secGrpIncTableObj = new CFBamSecGrpIncTableObj( this );
		secGrpMembTableObj = new CFBamSecGrpMembTableObj( this );
		secSessionTableObj = new CFBamSecSessionTableObj( this );
		secUserTableObj = new CFBamSecUserTableObj( this );
		serverListFuncTableObj = new CFBamServerListFuncTableObj( this );
		serverMethodTableObj = new CFBamServerMethodTableObj( this );
		serverObjFuncTableObj = new CFBamServerObjFuncTableObj( this );
		serverProcTableObj = new CFBamServerProcTableObj( this );
		serviceTableObj = new CFBamServiceTableObj( this );
		serviceTypeTableObj = new CFBamServiceTypeTableObj( this );
		stringColTableObj = new CFBamStringColTableObj( this );
		stringDefTableObj = new CFBamStringDefTableObj( this );
		stringTypeTableObj = new CFBamStringTypeTableObj( this );
		subProjectTableObj = new CFBamSubProjectTableObj( this );
		sysClusterTableObj = new CFBamSysClusterTableObj( this );
		tSecGroupTableObj = new CFBamTSecGroupTableObj( this );
		tSecGrpIncTableObj = new CFBamTSecGrpIncTableObj( this );
		tSecGrpMembTableObj = new CFBamTSecGrpMembTableObj( this );
		tZDateColTableObj = new CFBamTZDateColTableObj( this );
		tZDateDefTableObj = new CFBamTZDateDefTableObj( this );
		tZDateTypeTableObj = new CFBamTZDateTypeTableObj( this );
		tZTimeColTableObj = new CFBamTZTimeColTableObj( this );
		tZTimeDefTableObj = new CFBamTZTimeDefTableObj( this );
		tZTimeTypeTableObj = new CFBamTZTimeTypeTableObj( this );
		tZTimestampColTableObj = new CFBamTZTimestampColTableObj( this );
		tZTimestampDefTableObj = new CFBamTZTimestampDefTableObj( this );
		tZTimestampTypeTableObj = new CFBamTZTimestampTypeTableObj( this );
		tableTableObj = new CFBamTableTableObj( this );
		tableColTableObj = new CFBamTableColTableObj( this );
		tenantTableObj = new CFBamTenantTableObj( this );
		textColTableObj = new CFBamTextColTableObj( this );
		textDefTableObj = new CFBamTextDefTableObj( this );
		textTypeTableObj = new CFBamTextTypeTableObj( this );
		timeColTableObj = new CFBamTimeColTableObj( this );
		timeDefTableObj = new CFBamTimeDefTableObj( this );
		timeTypeTableObj = new CFBamTimeTypeTableObj( this );
		timestampColTableObj = new CFBamTimestampColTableObj( this );
		timestampDefTableObj = new CFBamTimestampDefTableObj( this );
		timestampTypeTableObj = new CFBamTimestampTypeTableObj( this );
		tldTableObj = new CFBamTldTableObj( this );
		tokenColTableObj = new CFBamTokenColTableObj( this );
		tokenDefTableObj = new CFBamTokenDefTableObj( this );
		tokenTypeTableObj = new CFBamTokenTypeTableObj( this );
		topDomainTableObj = new CFBamTopDomainTableObj( this );
		topProjectTableObj = new CFBamTopProjectTableObj( this );
		uInt16ColTableObj = new CFBamUInt16ColTableObj( this );
		uInt16DefTableObj = new CFBamUInt16DefTableObj( this );
		uInt16TypeTableObj = new CFBamUInt16TypeTableObj( this );
		uInt32ColTableObj = new CFBamUInt32ColTableObj( this );
		uInt32DefTableObj = new CFBamUInt32DefTableObj( this );
		uInt32TypeTableObj = new CFBamUInt32TypeTableObj( this );
		uInt64ColTableObj = new CFBamUInt64ColTableObj( this );
		uInt64DefTableObj = new CFBamUInt64DefTableObj( this );
		uInt64TypeTableObj = new CFBamUInt64TypeTableObj( this );
		uRLProtocolTableObj = new CFBamURLProtocolTableObj( this );
		uuidColTableObj = new CFBamUuidColTableObj( this );
		uuidDefTableObj = new CFBamUuidDefTableObj( this );
		uuidGenTableObj = new CFBamUuidGenTableObj( this );
		uuidTypeTableObj = new CFBamUuidTypeTableObj( this );
		valueTableObj = new CFBamValueTableObj( this );
		}

	public void setSecClusterName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setClusterName",
				1,
				"value" );
		}
		secClusterName = value;
		secCluster = null;
	}

	public String getSecClusterName() {
		return( secClusterName );
	}

	public ICFSecClusterObj getSecCluster() {
		if( secCluster == null ) {
			if( authorization != null ) {
				secCluster = getClusterTableObj().readClusterByIdIdx( authorization.getSecClusterId() );
			}
			else {
				secCluster = getClusterTableObj().readClusterByUDomNameIdx( secClusterName );
				if( ( secCluster == null ) && ( secClusterId > 0 ) ) {
					secCluster = getClusterTableObj().readClusterByIdIdx( secClusterId );
				}
			}
			if( secCluster != null ) {
				secClusterName = secCluster.getRequiredFullDomName();
				secClusterId = secCluster.getRequiredId();
				if( authorization != null ) {
					authorization.setSecCluster( secCluster );
				}
			}
		}
		return( secCluster );
	}

	public void setSecCluster( ICFSecClusterObj value ) {
		secCluster = value;
		if( secCluster == null ) {
			return;
		}
		secClusterId = secCluster.getRequiredId();
		secClusterName = secCluster.getRequiredFullDomName();
		if( authorization != null ) {
			authorization.setSecCluster( secCluster );
		}
	}

	public long getSecClusterId() {
		return( secClusterId );
	}

	public void setSecTenantName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setTenantName",
				1,
				"value" );
		}
		secTenantName = value;
		secTenant = null;
	}

	public String getSecTenantName() {
		return( secTenantName );
	}

	public ICFSecTenantObj getSecTenant() {
		if( secTenant == null ) {
			if( authorization != null ) {
				secTenant = getTenantTableObj().readTenantByIdIdx( authorization.getSecTenantId() );
			}
			else {
				secTenant = getTenantTableObj().readTenantByUNameIdx( getSecCluster().getRequiredId(), secTenantName );
				if( ( secTenant == null ) && ( secTenantId > 0 ) ) {
					secTenant = getTenantTableObj().readTenantByIdIdx( secTenantId );
				}
			}
			if( secTenant != null ) {
				secTenantName = secTenant.getRequiredTenantName();
				secTenantId = secTenant.getRequiredId();
				if( authorization != null ) {
					authorization.setSecTenant( secTenant );
				}
			}
		}
		return( secTenant );
	}

	public void setSecTenant( ICFSecTenantObj value ) {
		secTenant = value;
		if( secTenant == null ) {
			return;
		}
		secTenantId = secTenant.getRequiredId();
		secTenantName = secTenant.getRequiredTenantName();
		if( authorization != null ) {
			authorization.setSecTenant( secTenant );
		}
	}

	public long getSecTenantId() {
		return( secTenantId );
	}

	public void setSecUserName( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				"setUserName",
				1,
				"value" );
		}
		secUserName = value;
		secUser = null;
	}

	public String getSecUserName() {
		return( secUserName );
	}

	public ICFSecSecUserObj getSecUser() {
		if( secUser == null ) {
			if( authorization != null ) {
				secUser = getSecUserTableObj().readSecUserByIdIdx( authorization.getSecUserId() );
			}
			else {
				secUser = getSecUserTableObj().readSecUserByULoginIdx( secUserName );
				if( ( secUser == null ) && ( secSessionUserId != null ) ) {
					secUser = getSecUserTableObj().readSecUserByIdIdx( secSessionUserId );
				}
			}
			if( secUser != null ) {
				secUserName = secUser.getRequiredLoginId();
				secSessionUserId = secUser.getRequiredSecUserId();
			}
		}
		return( secUser );
	}

	public void setSecUser( ICFSecSecUserObj value ) {
		secUser = value;
		if( secUser != null ) {
			secUserName = secUser.getRequiredLoginId();
			secSessionUserId = secUser.getRequiredSecUserId();
		}
	}
	public ICFSecSecSessionObj getSecSession() {
		if( secSession == null ) {
			if( authorization != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( authorization.getSecSessionId() );
			}
			else if( secSessionSessionId != null ) {
				secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionSessionId );
			}
			if( secSession != null ) {
				secSessionSessionId = secSession.getRequiredSecSessionId();
				secSessionUserId = secSession.getRequiredSecUserId();
			}
		}
		return( secSession );
	}

	public void setSecSession( ICFSecSecSessionObj value ) {
		secSession = value;
		if( secSession == null ) {
			return;
		}
		secSessionSessionId = secSession.getRequiredSecSessionId();
		secSessionUserId = secSession.getRequiredSecUserId();
		if( authorization != null ) {
			authorization.setSecSession( secSession );
		}
	}

	public void setSecSessionId( UUID value ) {
		secSessionSessionId = value;
	}

	public UUID getSecSessionSessionId() {
		return( secSessionSessionId );
	}

	public UUID getSecSessionUserId() {
		return( secSessionUserId );
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

	/**
	 *	PostgreSQL coerces database schema names to lowercase for consistency.
	 */
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

		rollback();

		if( ( argDbSchemaName == null ) || ( argDbSchemaName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"argDbSchemaName" );
		}

		if( backingStore != null ) {
			backingStore.setDbSchemaName( argDbSchemaName );
		}

		schemaDbName = argDbSchemaName;
		lowerDbSchemaName = schemaDbName.toLowerCase();

		releasePreparedStatements();
	}

	public String fileImport( String fileName, String fileContent ) {
		String logContent = backingStore.fileImport( getAuthorization(), fileName, fileContent );
		return( logContent );
	}

	/**
	 *	Release any prepared statements acquired by this connection.
	 *	<p>
	 *	Resets the prepared statements so they can acquire the new value of
	 *	<tt>setDbSchemaName()</tt>.
	 */
	public void releasePreparedStatements() {
	}
	public CFSecAuthorization getAuthorization() {
		return( authorization );
	}

	public void setAuthorization( CFSecAuthorization value ) {
		authorization = value;
	}

	public ICFSecSchema getBackingStore() {
		return( backingStore );
	}

	public void setBackingStore( ICFSecSchema value ) {
		backingStore = value;
	}

	public String getSchemaName() {
		return( SCHEMA_NAME );
	}

	public boolean isConnected() {
		if( backingStore == null ) {
			return( false );
		}
		else {
			return( backingStore.isConnected() );
		}
	}

	public boolean connect() {
		return( backingStore.connect() );
	}

	public boolean connect( String username, String password ) {
		return( backingStore.connect( username, password ) );
	}

	public boolean connect( String clusterName, String tenantName, String secUserName, String password ) {
		final String S_ProcName = "connect-full";
		if( ( clusterName == null ) || ( clusterName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"clusterName" );
		}
		if( ( tenantName == null ) || ( tenantName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"tenantName" );
		}
		if( ( secUserName == null ) || ( secUserName.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				3,
				"secUserName" );
		}
		if( ( password == null ) || ( password.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				5,
				"password" );
		}
		if( ! backingStore.connect( secUserName, password, clusterName, tenantName ) ) {
			authorization = null;
			return( false );
		}
		if( authorization != null ) {
			// The login was established as an XMsg client, which automatically sets the Authorization
			// information based on the return message.  You only need to do the remaining SecSession
			// and authorization creation if you're using a direct client-server model instead of
			// an XMsg client-server model.
			setSecClusterName( clusterName );
			setSecTenantName( tenantName );
			setSecUserName( secUserName );
			return( true );
		}

		if( clusterName.equals( "system" )
		 && tenantName.equals( "system" )
		 && secUserName.equals( "system" ) )
		{
			if( secCluster == null ) {
				secCluster = getClusterTableObj().newInstance();
				ICFSecClusterEditObj editCluster = secCluster.getEdit();
				if( editCluster == null ) {
					editCluster = secCluster.beginEdit();
					editCluster.setRequiredDescription( "system" );
					editCluster.setRequiredFullDomName( "system" );
					secCluster = editCluster.create();
					editCluster = null;
				}
			}
			if( secTenant == null ) {
				secTenant = getTenantTableObj().newInstance();
				ICFSecTenantEditObj editTenant = secTenant.getEdit();
				if( editTenant == null ) {
					editTenant = secTenant.beginEdit();
					editTenant.setRequiredContainerCluster( secCluster);
					editTenant.setRequiredTenantName( "system" );
					secTenant = editTenant.create();
					editTenant = null;
				}
			}
			if( secUser == null ) {
				secUser = getSecUserTableObj().newInstance();
				ICFSecSecUserEditObj editSecUser = secUser.getEdit();
				if( editSecUser == null ) {
					editSecUser = secUser.beginEdit();
					editSecUser.setRequiredEMailAddress( "system" );
					editSecUser.setRequiredLoginId( "system" );
					secUser = editSecUser.create();
					editSecUser = null;
				}
			}
			setSecClusterName( clusterName );
			setSecTenantName( tenantName );
			setSecUserName( secUserName );
			secCluster = null;
			secTenant = null;
			secUser = null;
			secSession = null;
			ICFSecClusterObj cluster = getSecCluster();
			ICFSecTenantObj tenant = getSecTenant();
			ICFSecSecUserObj user = getSecUser();
			ICFSecSecSessionObj session;
			if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
				session = getSecSessionTableObj().newInstance();
				ICFSecSecSessionEditObj sessionEdit = session.beginEdit();
				sessionEdit.setRequiredContainerSecUser( user );
				sessionEdit.setRequiredStart( Calendar.getInstance() );
				sessionEdit.setOptionalFinish( null );
				session = sessionEdit.create();
				sessionEdit = null;
				setSecSession( session );
			}
			else {
				session = null;
			}
			if( ( cluster == null ) || ( tenant == null ) || ( user == null ) || ( session == null ) ) {
				disconnect( false );
				authorization = null;
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Could not resolve cluster name, tenant name, user name, or session.  Login cancelled" );
			}
			if( authorization == null ) {
				authorization = new CFSecAuthorization();
			}
			authorization.setSecCluster( cluster );
			authorization.setSecTenant( tenant );
			authorization.setSecSession( session );
			return( true );
		}
		setSecClusterName( clusterName );
		setSecTenantName( tenantName );
		setSecUserName( secUserName );
		boolean transactionStarted = beginTransaction();
		secCluster = null;
		secTenant = null;
		secUser = null;
		secSession = null;
		ICFSecClusterObj cluster = getSecCluster();
		ICFSecTenantObj tenant = getSecTenant();
		ICFSecSecUserObj user = getSecUser();
		ICFSecSecSessionObj session;
		if( ( cluster != null ) && ( tenant != null ) && ( user != null ) ) {
			session = getSecSessionTableObj().newInstance();
			ICFSecSecSessionEditObj sessionEdit = session.beginEdit();
			sessionEdit.setRequiredContainerSecUser( user );
			sessionEdit.setRequiredStart( Calendar.getInstance() );
			sessionEdit.setOptionalFinish( null );
			session = sessionEdit.create();
			sessionEdit = null;
			setSecSession( session );
		}
		else {
			session = null;
		}
		if( transactionStarted ) {
			commit();
		}
		if( ( cluster == null ) || ( tenant == null ) || ( user == null ) || ( session == null ) ) {
			disconnect( false );
			authorization = null;
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Could not resolve cluster name, tenant name, user name, or session.  Login cancelled" );
		}
		if( authorization == null ) {
			authorization = new CFSecAuthorization();
		}
		authorization.setSecCluster( cluster );
		authorization.setSecTenant( tenant );
		authorization.setSecSession( session );
		return( true );
	}

	public void disconnect( boolean doCommit ) {
		backingStore.disconnect( doCommit );
	}

	public void logout() {
		if( authorization == null ) {
			if( isConnected() ) {
				disconnect( false );
			}
			return;
		}
		if( isConnected() ) {
			try {
				boolean transactionStarted = beginTransaction();
				if( ! transactionStarted ) {
					rollback();
					transactionStarted = beginTransaction();
					if( ! transactionStarted ) {
						setAuthorization( null );
						return;
					}
				}
				UUID secSessionId = authorization.getSecSessionId();
				if( secSessionId != null ) {
					ICFSecSecSessionObj secSession = getSecSessionTableObj().readSecSessionByIdIdx( secSessionId );
					if( secSession != null ) {
						if( secSession.getOptionalFinish() == null ) {
							ICFSecSecSessionEditObj editSecSession = secSession.beginEdit();
							editSecSession.setOptionalFinish( Calendar.getInstance() );
							editSecSession.update();
							editSecSession = null;
						}
					}
				}
				commit();
			}
			finally {
				setAuthorization( null );
				try {
					disconnect( false );
				}
				catch( RuntimeException e ) {
				}
			}
		}
	}

	public void minimizeMemory() {
		if( atomTableObj != null ) {
			atomTableObj.minimizeMemory();
		}
		if( blobColTableObj != null ) {
			blobColTableObj.minimizeMemory();
		}
		if( blobDefTableObj != null ) {
			blobDefTableObj.minimizeMemory();
		}
		if( blobTypeTableObj != null ) {
			blobTypeTableObj.minimizeMemory();
		}
		if( boolColTableObj != null ) {
			boolColTableObj.minimizeMemory();
		}
		if( boolDefTableObj != null ) {
			boolDefTableObj.minimizeMemory();
		}
		if( boolTypeTableObj != null ) {
			boolTypeTableObj.minimizeMemory();
		}
		if( chainTableObj != null ) {
			chainTableObj.minimizeMemory();
		}
		if( clearDepTableObj != null ) {
			clearDepTableObj.minimizeMemory();
		}
		if( clearSubDep1TableObj != null ) {
			clearSubDep1TableObj.minimizeMemory();
		}
		if( clearSubDep2TableObj != null ) {
			clearSubDep2TableObj.minimizeMemory();
		}
		if( clearSubDep3TableObj != null ) {
			clearSubDep3TableObj.minimizeMemory();
		}
		if( clearTopDepTableObj != null ) {
			clearTopDepTableObj.minimizeMemory();
		}
		if( clusterTableObj != null ) {
			clusterTableObj.minimizeMemory();
		}
		if( dateColTableObj != null ) {
			dateColTableObj.minimizeMemory();
		}
		if( dateDefTableObj != null ) {
			dateDefTableObj.minimizeMemory();
		}
		if( dateTypeTableObj != null ) {
			dateTypeTableObj.minimizeMemory();
		}
		if( delDepTableObj != null ) {
			delDepTableObj.minimizeMemory();
		}
		if( delSubDep1TableObj != null ) {
			delSubDep1TableObj.minimizeMemory();
		}
		if( delSubDep2TableObj != null ) {
			delSubDep2TableObj.minimizeMemory();
		}
		if( delSubDep3TableObj != null ) {
			delSubDep3TableObj.minimizeMemory();
		}
		if( delTopDepTableObj != null ) {
			delTopDepTableObj.minimizeMemory();
		}
		if( doubleColTableObj != null ) {
			doubleColTableObj.minimizeMemory();
		}
		if( doubleDefTableObj != null ) {
			doubleDefTableObj.minimizeMemory();
		}
		if( doubleTypeTableObj != null ) {
			doubleTypeTableObj.minimizeMemory();
		}
		if( enumDefTableObj != null ) {
			enumDefTableObj.minimizeMemory();
		}
		if( enumTagTableObj != null ) {
			enumTagTableObj.minimizeMemory();
		}
		if( enumTypeTableObj != null ) {
			enumTypeTableObj.minimizeMemory();
		}
		if( floatColTableObj != null ) {
			floatColTableObj.minimizeMemory();
		}
		if( floatDefTableObj != null ) {
			floatDefTableObj.minimizeMemory();
		}
		if( floatTypeTableObj != null ) {
			floatTypeTableObj.minimizeMemory();
		}
		if( hostNodeTableObj != null ) {
			hostNodeTableObj.minimizeMemory();
		}
		if( iSOCcyTableObj != null ) {
			iSOCcyTableObj.minimizeMemory();
		}
		if( iSOCtryTableObj != null ) {
			iSOCtryTableObj.minimizeMemory();
		}
		if( iSOCtryCcyTableObj != null ) {
			iSOCtryCcyTableObj.minimizeMemory();
		}
		if( iSOCtryLangTableObj != null ) {
			iSOCtryLangTableObj.minimizeMemory();
		}
		if( iSOLangTableObj != null ) {
			iSOLangTableObj.minimizeMemory();
		}
		if( iSOTZoneTableObj != null ) {
			iSOTZoneTableObj.minimizeMemory();
		}
		if( id16GenTableObj != null ) {
			id16GenTableObj.minimizeMemory();
		}
		if( id32GenTableObj != null ) {
			id32GenTableObj.minimizeMemory();
		}
		if( id64GenTableObj != null ) {
			id64GenTableObj.minimizeMemory();
		}
		if( indexTableObj != null ) {
			indexTableObj.minimizeMemory();
		}
		if( indexColTableObj != null ) {
			indexColTableObj.minimizeMemory();
		}
		if( int16ColTableObj != null ) {
			int16ColTableObj.minimizeMemory();
		}
		if( int16DefTableObj != null ) {
			int16DefTableObj.minimizeMemory();
		}
		if( int16TypeTableObj != null ) {
			int16TypeTableObj.minimizeMemory();
		}
		if( int32ColTableObj != null ) {
			int32ColTableObj.minimizeMemory();
		}
		if( int32DefTableObj != null ) {
			int32DefTableObj.minimizeMemory();
		}
		if( int32TypeTableObj != null ) {
			int32TypeTableObj.minimizeMemory();
		}
		if( int64ColTableObj != null ) {
			int64ColTableObj.minimizeMemory();
		}
		if( int64DefTableObj != null ) {
			int64DefTableObj.minimizeMemory();
		}
		if( int64TypeTableObj != null ) {
			int64TypeTableObj.minimizeMemory();
		}
		if( licenseTableObj != null ) {
			licenseTableObj.minimizeMemory();
		}
		if( majorVersionTableObj != null ) {
			majorVersionTableObj.minimizeMemory();
		}
		if( mimeTypeTableObj != null ) {
			mimeTypeTableObj.minimizeMemory();
		}
		if( minorVersionTableObj != null ) {
			minorVersionTableObj.minimizeMemory();
		}
		if( nmTokenColTableObj != null ) {
			nmTokenColTableObj.minimizeMemory();
		}
		if( nmTokenDefTableObj != null ) {
			nmTokenDefTableObj.minimizeMemory();
		}
		if( nmTokenTypeTableObj != null ) {
			nmTokenTypeTableObj.minimizeMemory();
		}
		if( nmTokensColTableObj != null ) {
			nmTokensColTableObj.minimizeMemory();
		}
		if( nmTokensDefTableObj != null ) {
			nmTokensDefTableObj.minimizeMemory();
		}
		if( nmTokensTypeTableObj != null ) {
			nmTokensTypeTableObj.minimizeMemory();
		}
		if( numberColTableObj != null ) {
			numberColTableObj.minimizeMemory();
		}
		if( numberDefTableObj != null ) {
			numberDefTableObj.minimizeMemory();
		}
		if( numberTypeTableObj != null ) {
			numberTypeTableObj.minimizeMemory();
		}
		if( paramTableObj != null ) {
			paramTableObj.minimizeMemory();
		}
		if( popDepTableObj != null ) {
			popDepTableObj.minimizeMemory();
		}
		if( popSubDep1TableObj != null ) {
			popSubDep1TableObj.minimizeMemory();
		}
		if( popSubDep2TableObj != null ) {
			popSubDep2TableObj.minimizeMemory();
		}
		if( popSubDep3TableObj != null ) {
			popSubDep3TableObj.minimizeMemory();
		}
		if( popTopDepTableObj != null ) {
			popTopDepTableObj.minimizeMemory();
		}
		if( relationTableObj != null ) {
			relationTableObj.minimizeMemory();
		}
		if( relationColTableObj != null ) {
			relationColTableObj.minimizeMemory();
		}
		if( schemaDefTableObj != null ) {
			schemaDefTableObj.minimizeMemory();
		}
		if( schemaRefTableObj != null ) {
			schemaRefTableObj.minimizeMemory();
		}
		if( scopeTableObj != null ) {
			scopeTableObj.minimizeMemory();
		}
		if( secAppTableObj != null ) {
			secAppTableObj.minimizeMemory();
		}
		if( secDeviceTableObj != null ) {
			secDeviceTableObj.minimizeMemory();
		}
		if( secFormTableObj != null ) {
			secFormTableObj.minimizeMemory();
		}
		if( secGroupTableObj != null ) {
			secGroupTableObj.minimizeMemory();
		}
		if( secGroupFormTableObj != null ) {
			secGroupFormTableObj.minimizeMemory();
		}
		if( secGrpIncTableObj != null ) {
			secGrpIncTableObj.minimizeMemory();
		}
		if( secGrpMembTableObj != null ) {
			secGrpMembTableObj.minimizeMemory();
		}
		if( secSessionTableObj != null ) {
			secSessionTableObj.minimizeMemory();
		}
		if( secUserTableObj != null ) {
			secUserTableObj.minimizeMemory();
		}
		if( serverListFuncTableObj != null ) {
			serverListFuncTableObj.minimizeMemory();
		}
		if( serverMethodTableObj != null ) {
			serverMethodTableObj.minimizeMemory();
		}
		if( serverObjFuncTableObj != null ) {
			serverObjFuncTableObj.minimizeMemory();
		}
		if( serverProcTableObj != null ) {
			serverProcTableObj.minimizeMemory();
		}
		if( serviceTableObj != null ) {
			serviceTableObj.minimizeMemory();
		}
		if( serviceTypeTableObj != null ) {
			serviceTypeTableObj.minimizeMemory();
		}
		if( stringColTableObj != null ) {
			stringColTableObj.minimizeMemory();
		}
		if( stringDefTableObj != null ) {
			stringDefTableObj.minimizeMemory();
		}
		if( stringTypeTableObj != null ) {
			stringTypeTableObj.minimizeMemory();
		}
		if( subProjectTableObj != null ) {
			subProjectTableObj.minimizeMemory();
		}
		if( sysClusterTableObj != null ) {
			sysClusterTableObj.minimizeMemory();
		}
		if( tSecGroupTableObj != null ) {
			tSecGroupTableObj.minimizeMemory();
		}
		if( tSecGrpIncTableObj != null ) {
			tSecGrpIncTableObj.minimizeMemory();
		}
		if( tSecGrpMembTableObj != null ) {
			tSecGrpMembTableObj.minimizeMemory();
		}
		if( tZDateColTableObj != null ) {
			tZDateColTableObj.minimizeMemory();
		}
		if( tZDateDefTableObj != null ) {
			tZDateDefTableObj.minimizeMemory();
		}
		if( tZDateTypeTableObj != null ) {
			tZDateTypeTableObj.minimizeMemory();
		}
		if( tZTimeColTableObj != null ) {
			tZTimeColTableObj.minimizeMemory();
		}
		if( tZTimeDefTableObj != null ) {
			tZTimeDefTableObj.minimizeMemory();
		}
		if( tZTimeTypeTableObj != null ) {
			tZTimeTypeTableObj.minimizeMemory();
		}
		if( tZTimestampColTableObj != null ) {
			tZTimestampColTableObj.minimizeMemory();
		}
		if( tZTimestampDefTableObj != null ) {
			tZTimestampDefTableObj.minimizeMemory();
		}
		if( tZTimestampTypeTableObj != null ) {
			tZTimestampTypeTableObj.minimizeMemory();
		}
		if( tableTableObj != null ) {
			tableTableObj.minimizeMemory();
		}
		if( tableColTableObj != null ) {
			tableColTableObj.minimizeMemory();
		}
		if( tenantTableObj != null ) {
			tenantTableObj.minimizeMemory();
		}
		if( textColTableObj != null ) {
			textColTableObj.minimizeMemory();
		}
		if( textDefTableObj != null ) {
			textDefTableObj.minimizeMemory();
		}
		if( textTypeTableObj != null ) {
			textTypeTableObj.minimizeMemory();
		}
		if( timeColTableObj != null ) {
			timeColTableObj.minimizeMemory();
		}
		if( timeDefTableObj != null ) {
			timeDefTableObj.minimizeMemory();
		}
		if( timeTypeTableObj != null ) {
			timeTypeTableObj.minimizeMemory();
		}
		if( timestampColTableObj != null ) {
			timestampColTableObj.minimizeMemory();
		}
		if( timestampDefTableObj != null ) {
			timestampDefTableObj.minimizeMemory();
		}
		if( timestampTypeTableObj != null ) {
			timestampTypeTableObj.minimizeMemory();
		}
		if( tldTableObj != null ) {
			tldTableObj.minimizeMemory();
		}
		if( tokenColTableObj != null ) {
			tokenColTableObj.minimizeMemory();
		}
		if( tokenDefTableObj != null ) {
			tokenDefTableObj.minimizeMemory();
		}
		if( tokenTypeTableObj != null ) {
			tokenTypeTableObj.minimizeMemory();
		}
		if( topDomainTableObj != null ) {
			topDomainTableObj.minimizeMemory();
		}
		if( topProjectTableObj != null ) {
			topProjectTableObj.minimizeMemory();
		}
		if( uInt16ColTableObj != null ) {
			uInt16ColTableObj.minimizeMemory();
		}
		if( uInt16DefTableObj != null ) {
			uInt16DefTableObj.minimizeMemory();
		}
		if( uInt16TypeTableObj != null ) {
			uInt16TypeTableObj.minimizeMemory();
		}
		if( uInt32ColTableObj != null ) {
			uInt32ColTableObj.minimizeMemory();
		}
		if( uInt32DefTableObj != null ) {
			uInt32DefTableObj.minimizeMemory();
		}
		if( uInt32TypeTableObj != null ) {
			uInt32TypeTableObj.minimizeMemory();
		}
		if( uInt64ColTableObj != null ) {
			uInt64ColTableObj.minimizeMemory();
		}
		if( uInt64DefTableObj != null ) {
			uInt64DefTableObj.minimizeMemory();
		}
		if( uInt64TypeTableObj != null ) {
			uInt64TypeTableObj.minimizeMemory();
		}
		if( uRLProtocolTableObj != null ) {
			uRLProtocolTableObj.minimizeMemory();
		}
		if( uuidColTableObj != null ) {
			uuidColTableObj.minimizeMemory();
		}
		if( uuidDefTableObj != null ) {
			uuidDefTableObj.minimizeMemory();
		}
		if( uuidGenTableObj != null ) {
			uuidGenTableObj.minimizeMemory();
		}
		if( uuidTypeTableObj != null ) {
			uuidTypeTableObj.minimizeMemory();
		}
		if( valueTableObj != null ) {
			valueTableObj.minimizeMemory();
		}
	}

	public boolean isTransactionOpen() {
		boolean txnOpen = backingStore.isTransactionOpen();
		return( txnOpen );
	}

	public boolean beginTransaction() {
		boolean txnInitiated = backingStore.beginTransaction();
		return( txnInitiated );
	}

	public void commit() {
		backingStore.commit();
	}

	public void rollback() {
		backingStore.rollback();
	}
	public ICFBamAtomTableObj getAtomTableObj() {
		return( atomTableObj );
	}

	public ICFBamBlobColTableObj getBlobColTableObj() {
		return( blobColTableObj );
	}

	public ICFBamBlobDefTableObj getBlobDefTableObj() {
		return( blobDefTableObj );
	}

	public ICFBamBlobTypeTableObj getBlobTypeTableObj() {
		return( blobTypeTableObj );
	}

	public ICFBamBoolColTableObj getBoolColTableObj() {
		return( boolColTableObj );
	}

	public ICFBamBoolDefTableObj getBoolDefTableObj() {
		return( boolDefTableObj );
	}

	public ICFBamBoolTypeTableObj getBoolTypeTableObj() {
		return( boolTypeTableObj );
	}

	public ICFBamChainTableObj getChainTableObj() {
		return( chainTableObj );
	}

	public ICFBamClearDepTableObj getClearDepTableObj() {
		return( clearDepTableObj );
	}

	public ICFBamClearSubDep1TableObj getClearSubDep1TableObj() {
		return( clearSubDep1TableObj );
	}

	public ICFBamClearSubDep2TableObj getClearSubDep2TableObj() {
		return( clearSubDep2TableObj );
	}

	public ICFBamClearSubDep3TableObj getClearSubDep3TableObj() {
		return( clearSubDep3TableObj );
	}

	public ICFBamClearTopDepTableObj getClearTopDepTableObj() {
		return( clearTopDepTableObj );
	}

	public ICFBamClusterTableObj getClusterTableObj() {
		return( clusterTableObj );
	}

	public ICFBamDateColTableObj getDateColTableObj() {
		return( dateColTableObj );
	}

	public ICFBamDateDefTableObj getDateDefTableObj() {
		return( dateDefTableObj );
	}

	public ICFBamDateTypeTableObj getDateTypeTableObj() {
		return( dateTypeTableObj );
	}

	public ICFBamDelDepTableObj getDelDepTableObj() {
		return( delDepTableObj );
	}

	public ICFBamDelSubDep1TableObj getDelSubDep1TableObj() {
		return( delSubDep1TableObj );
	}

	public ICFBamDelSubDep2TableObj getDelSubDep2TableObj() {
		return( delSubDep2TableObj );
	}

	public ICFBamDelSubDep3TableObj getDelSubDep3TableObj() {
		return( delSubDep3TableObj );
	}

	public ICFBamDelTopDepTableObj getDelTopDepTableObj() {
		return( delTopDepTableObj );
	}

	public ICFBamDoubleColTableObj getDoubleColTableObj() {
		return( doubleColTableObj );
	}

	public ICFBamDoubleDefTableObj getDoubleDefTableObj() {
		return( doubleDefTableObj );
	}

	public ICFBamDoubleTypeTableObj getDoubleTypeTableObj() {
		return( doubleTypeTableObj );
	}

	public ICFBamEnumDefTableObj getEnumDefTableObj() {
		return( enumDefTableObj );
	}

	public ICFBamEnumTagTableObj getEnumTagTableObj() {
		return( enumTagTableObj );
	}

	public ICFBamEnumTypeTableObj getEnumTypeTableObj() {
		return( enumTypeTableObj );
	}

	public ICFBamFloatColTableObj getFloatColTableObj() {
		return( floatColTableObj );
	}

	public ICFBamFloatDefTableObj getFloatDefTableObj() {
		return( floatDefTableObj );
	}

	public ICFBamFloatTypeTableObj getFloatTypeTableObj() {
		return( floatTypeTableObj );
	}

	public ICFBamHostNodeTableObj getHostNodeTableObj() {
		return( hostNodeTableObj );
	}

	public ICFBamISOCcyTableObj getISOCcyTableObj() {
		return( iSOCcyTableObj );
	}

	public ICFBamISOCtryTableObj getISOCtryTableObj() {
		return( iSOCtryTableObj );
	}

	public ICFBamISOCtryCcyTableObj getISOCtryCcyTableObj() {
		return( iSOCtryCcyTableObj );
	}

	public ICFBamISOCtryLangTableObj getISOCtryLangTableObj() {
		return( iSOCtryLangTableObj );
	}

	public ICFBamISOLangTableObj getISOLangTableObj() {
		return( iSOLangTableObj );
	}

	public ICFBamISOTZoneTableObj getISOTZoneTableObj() {
		return( iSOTZoneTableObj );
	}

	public ICFBamId16GenTableObj getId16GenTableObj() {
		return( id16GenTableObj );
	}

	public ICFBamId32GenTableObj getId32GenTableObj() {
		return( id32GenTableObj );
	}

	public ICFBamId64GenTableObj getId64GenTableObj() {
		return( id64GenTableObj );
	}

	public ICFBamIndexTableObj getIndexTableObj() {
		return( indexTableObj );
	}

	public ICFBamIndexColTableObj getIndexColTableObj() {
		return( indexColTableObj );
	}

	public ICFBamInt16ColTableObj getInt16ColTableObj() {
		return( int16ColTableObj );
	}

	public ICFBamInt16DefTableObj getInt16DefTableObj() {
		return( int16DefTableObj );
	}

	public ICFBamInt16TypeTableObj getInt16TypeTableObj() {
		return( int16TypeTableObj );
	}

	public ICFBamInt32ColTableObj getInt32ColTableObj() {
		return( int32ColTableObj );
	}

	public ICFBamInt32DefTableObj getInt32DefTableObj() {
		return( int32DefTableObj );
	}

	public ICFBamInt32TypeTableObj getInt32TypeTableObj() {
		return( int32TypeTableObj );
	}

	public ICFBamInt64ColTableObj getInt64ColTableObj() {
		return( int64ColTableObj );
	}

	public ICFBamInt64DefTableObj getInt64DefTableObj() {
		return( int64DefTableObj );
	}

	public ICFBamInt64TypeTableObj getInt64TypeTableObj() {
		return( int64TypeTableObj );
	}

	public ICFBamLicenseTableObj getLicenseTableObj() {
		return( licenseTableObj );
	}

	public ICFBamMajorVersionTableObj getMajorVersionTableObj() {
		return( majorVersionTableObj );
	}

	public ICFBamMimeTypeTableObj getMimeTypeTableObj() {
		return( mimeTypeTableObj );
	}

	public ICFBamMinorVersionTableObj getMinorVersionTableObj() {
		return( minorVersionTableObj );
	}

	public ICFBamNmTokenColTableObj getNmTokenColTableObj() {
		return( nmTokenColTableObj );
	}

	public ICFBamNmTokenDefTableObj getNmTokenDefTableObj() {
		return( nmTokenDefTableObj );
	}

	public ICFBamNmTokenTypeTableObj getNmTokenTypeTableObj() {
		return( nmTokenTypeTableObj );
	}

	public ICFBamNmTokensColTableObj getNmTokensColTableObj() {
		return( nmTokensColTableObj );
	}

	public ICFBamNmTokensDefTableObj getNmTokensDefTableObj() {
		return( nmTokensDefTableObj );
	}

	public ICFBamNmTokensTypeTableObj getNmTokensTypeTableObj() {
		return( nmTokensTypeTableObj );
	}

	public ICFBamNumberColTableObj getNumberColTableObj() {
		return( numberColTableObj );
	}

	public ICFBamNumberDefTableObj getNumberDefTableObj() {
		return( numberDefTableObj );
	}

	public ICFBamNumberTypeTableObj getNumberTypeTableObj() {
		return( numberTypeTableObj );
	}

	public ICFBamParamTableObj getParamTableObj() {
		return( paramTableObj );
	}

	public ICFBamPopDepTableObj getPopDepTableObj() {
		return( popDepTableObj );
	}

	public ICFBamPopSubDep1TableObj getPopSubDep1TableObj() {
		return( popSubDep1TableObj );
	}

	public ICFBamPopSubDep2TableObj getPopSubDep2TableObj() {
		return( popSubDep2TableObj );
	}

	public ICFBamPopSubDep3TableObj getPopSubDep3TableObj() {
		return( popSubDep3TableObj );
	}

	public ICFBamPopTopDepTableObj getPopTopDepTableObj() {
		return( popTopDepTableObj );
	}

	public ICFBamRelationTableObj getRelationTableObj() {
		return( relationTableObj );
	}

	public ICFBamRelationColTableObj getRelationColTableObj() {
		return( relationColTableObj );
	}

	public ICFBamSchemaDefTableObj getSchemaDefTableObj() {
		return( schemaDefTableObj );
	}

	public ICFBamSchemaRefTableObj getSchemaRefTableObj() {
		return( schemaRefTableObj );
	}

	public ICFBamScopeTableObj getScopeTableObj() {
		return( scopeTableObj );
	}

	public ICFBamSecAppTableObj getSecAppTableObj() {
		return( secAppTableObj );
	}

	public ICFBamSecDeviceTableObj getSecDeviceTableObj() {
		return( secDeviceTableObj );
	}

	public ICFBamSecFormTableObj getSecFormTableObj() {
		return( secFormTableObj );
	}

	public ICFBamSecGroupTableObj getSecGroupTableObj() {
		return( secGroupTableObj );
	}

	public ICFBamSecGroupFormTableObj getSecGroupFormTableObj() {
		return( secGroupFormTableObj );
	}

	public ICFBamSecGrpIncTableObj getSecGrpIncTableObj() {
		return( secGrpIncTableObj );
	}

	public ICFBamSecGrpMembTableObj getSecGrpMembTableObj() {
		return( secGrpMembTableObj );
	}

	public ICFBamSecSessionTableObj getSecSessionTableObj() {
		return( secSessionTableObj );
	}

	public ICFBamSecUserTableObj getSecUserTableObj() {
		return( secUserTableObj );
	}

	public ICFBamServerListFuncTableObj getServerListFuncTableObj() {
		return( serverListFuncTableObj );
	}

	public ICFBamServerMethodTableObj getServerMethodTableObj() {
		return( serverMethodTableObj );
	}

	public ICFBamServerObjFuncTableObj getServerObjFuncTableObj() {
		return( serverObjFuncTableObj );
	}

	public ICFBamServerProcTableObj getServerProcTableObj() {
		return( serverProcTableObj );
	}

	public ICFBamServiceTableObj getServiceTableObj() {
		return( serviceTableObj );
	}

	public ICFBamServiceTypeTableObj getServiceTypeTableObj() {
		return( serviceTypeTableObj );
	}

	public ICFBamStringColTableObj getStringColTableObj() {
		return( stringColTableObj );
	}

	public ICFBamStringDefTableObj getStringDefTableObj() {
		return( stringDefTableObj );
	}

	public ICFBamStringTypeTableObj getStringTypeTableObj() {
		return( stringTypeTableObj );
	}

	public ICFBamSubProjectTableObj getSubProjectTableObj() {
		return( subProjectTableObj );
	}

	public ICFBamSysClusterTableObj getSysClusterTableObj() {
		return( sysClusterTableObj );
	}

	public ICFBamTSecGroupTableObj getTSecGroupTableObj() {
		return( tSecGroupTableObj );
	}

	public ICFBamTSecGrpIncTableObj getTSecGrpIncTableObj() {
		return( tSecGrpIncTableObj );
	}

	public ICFBamTSecGrpMembTableObj getTSecGrpMembTableObj() {
		return( tSecGrpMembTableObj );
	}

	public ICFBamTZDateColTableObj getTZDateColTableObj() {
		return( tZDateColTableObj );
	}

	public ICFBamTZDateDefTableObj getTZDateDefTableObj() {
		return( tZDateDefTableObj );
	}

	public ICFBamTZDateTypeTableObj getTZDateTypeTableObj() {
		return( tZDateTypeTableObj );
	}

	public ICFBamTZTimeColTableObj getTZTimeColTableObj() {
		return( tZTimeColTableObj );
	}

	public ICFBamTZTimeDefTableObj getTZTimeDefTableObj() {
		return( tZTimeDefTableObj );
	}

	public ICFBamTZTimeTypeTableObj getTZTimeTypeTableObj() {
		return( tZTimeTypeTableObj );
	}

	public ICFBamTZTimestampColTableObj getTZTimestampColTableObj() {
		return( tZTimestampColTableObj );
	}

	public ICFBamTZTimestampDefTableObj getTZTimestampDefTableObj() {
		return( tZTimestampDefTableObj );
	}

	public ICFBamTZTimestampTypeTableObj getTZTimestampTypeTableObj() {
		return( tZTimestampTypeTableObj );
	}

	public ICFBamTableTableObj getTableTableObj() {
		return( tableTableObj );
	}

	public ICFBamTableColTableObj getTableColTableObj() {
		return( tableColTableObj );
	}

	public ICFBamTenantTableObj getTenantTableObj() {
		return( tenantTableObj );
	}

	public ICFBamTextColTableObj getTextColTableObj() {
		return( textColTableObj );
	}

	public ICFBamTextDefTableObj getTextDefTableObj() {
		return( textDefTableObj );
	}

	public ICFBamTextTypeTableObj getTextTypeTableObj() {
		return( textTypeTableObj );
	}

	public ICFBamTimeColTableObj getTimeColTableObj() {
		return( timeColTableObj );
	}

	public ICFBamTimeDefTableObj getTimeDefTableObj() {
		return( timeDefTableObj );
	}

	public ICFBamTimeTypeTableObj getTimeTypeTableObj() {
		return( timeTypeTableObj );
	}

	public ICFBamTimestampColTableObj getTimestampColTableObj() {
		return( timestampColTableObj );
	}

	public ICFBamTimestampDefTableObj getTimestampDefTableObj() {
		return( timestampDefTableObj );
	}

	public ICFBamTimestampTypeTableObj getTimestampTypeTableObj() {
		return( timestampTypeTableObj );
	}

	public ICFBamTldTableObj getTldTableObj() {
		return( tldTableObj );
	}

	public ICFBamTokenColTableObj getTokenColTableObj() {
		return( tokenColTableObj );
	}

	public ICFBamTokenDefTableObj getTokenDefTableObj() {
		return( tokenDefTableObj );
	}

	public ICFBamTokenTypeTableObj getTokenTypeTableObj() {
		return( tokenTypeTableObj );
	}

	public ICFBamTopDomainTableObj getTopDomainTableObj() {
		return( topDomainTableObj );
	}

	public ICFBamTopProjectTableObj getTopProjectTableObj() {
		return( topProjectTableObj );
	}

	public ICFBamUInt16ColTableObj getUInt16ColTableObj() {
		return( uInt16ColTableObj );
	}

	public ICFBamUInt16DefTableObj getUInt16DefTableObj() {
		return( uInt16DefTableObj );
	}

	public ICFBamUInt16TypeTableObj getUInt16TypeTableObj() {
		return( uInt16TypeTableObj );
	}

	public ICFBamUInt32ColTableObj getUInt32ColTableObj() {
		return( uInt32ColTableObj );
	}

	public ICFBamUInt32DefTableObj getUInt32DefTableObj() {
		return( uInt32DefTableObj );
	}

	public ICFBamUInt32TypeTableObj getUInt32TypeTableObj() {
		return( uInt32TypeTableObj );
	}

	public ICFBamUInt64ColTableObj getUInt64ColTableObj() {
		return( uInt64ColTableObj );
	}

	public ICFBamUInt64DefTableObj getUInt64DefTableObj() {
		return( uInt64DefTableObj );
	}

	public ICFBamUInt64TypeTableObj getUInt64TypeTableObj() {
		return( uInt64TypeTableObj );
	}

	public ICFBamURLProtocolTableObj getURLProtocolTableObj() {
		return( uRLProtocolTableObj );
	}

	public ICFBamUuidColTableObj getUuidColTableObj() {
		return( uuidColTableObj );
	}

	public ICFBamUuidDefTableObj getUuidDefTableObj() {
		return( uuidDefTableObj );
	}

	public ICFBamUuidGenTableObj getUuidGenTableObj() {
		return( uuidGenTableObj );
	}

	public ICFBamUuidTypeTableObj getUuidTypeTableObj() {
		return( uuidTypeTableObj );
	}

	public ICFBamValueTableObj getValueTableObj() {
		return( valueTableObj );
	}
}
