// Description: Java 11 base object instance implementation for CFBam SchemaDef.

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

public class CFBamSchemaDefObj
	extends CFBamScopeObj
	implements ICFBamSchemaDefObj
{
	public final static String CLASS_CODE = "SCHM";
	protected ICFIntMinorVersionObj requiredContainerMinorVersion;
	protected ICFIntLicenseObj optionalLookupDefaultLicense;
	protected ICFSecTenantObj requiredOwnerCTenant;

	public CFBamSchemaDefObj() {
		super();
		requiredContainerMinorVersion = null;
		optionalLookupDefaultLicense = null;
		requiredOwnerCTenant = null;
	}

	public CFBamSchemaDefObj( ICFBamSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerMinorVersion = null;
		optionalLookupDefaultLicense = null;
		requiredOwnerCTenant = null;
	}

	public String getClassCode() {
		return( CLASS_CODE );
	}

	public String getGenDefName() {
		return( "SchemaDef" );
	}

	public ICFLibAnyObj getScope() {
		ICFIntMinorVersionObj scope = getRequiredContainerMinorVersion();
		return( scope );
	}

	public ICFLibAnyObj getObjScope() {
		ICFIntMinorVersionObj scope = getRequiredContainerMinorVersion();
		return( scope );
	}

	public String getObjName() {
		String objName;
		objName = getRequiredName();
		return( objName );
	}

	public ICFLibAnyObj getObjQualifier( Class qualifyingClass ) {
		ICFLibAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof ICFBamClusterObj ) {
					break;
				}
				else if( container instanceof ICFBamTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	public ICFLibAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		ICFLibAnyObj subObj = null;
		ICFLibAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getTableTableObj().readTableByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( subObj == null ) {
			subObj = ((ICFBamSchemaObj)getSchema()).getValueTableObj().readValueByUNameIdx( getRequiredTenantId(),
				getRequiredId(),
				nextName, false );
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	public String getObjQualifiedName() {
		String qualName = getObjName();
		ICFLibAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ICFSecClusterObj ) {
				container = null;
			}
			else if( container instanceof ICFSecTenantObj ) {
				container = null;
			}
			else if( container instanceof ICFBamSubProjectObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	public ICFBamScopeObj realise() {
		ICFBamSchemaDefObj retobj = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().realiseSchemaDef(
			(ICFBamSchemaDefObj)this );
		return( (ICFBamScopeObj)retobj );
	}

	public void forget() {
		forget( false );
	}

	public void forget( boolean forgetSubObjects ) {
		((ICFBamSchemaObj)schema).getSchemaDefTableObj().forgetSchemaDef( (ICFBamSchemaDefObj)this, forgetSubObjects );
	}

	public ICFBamScopeObj read() {
		ICFBamSchemaDefObj retobj = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), false );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamScopeObj read( boolean forceRead ) {
		ICFBamSchemaDefObj retobj = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().readSchemaDefByIdIdx( getPKey().getRequiredTenantId(),
			getPKey().getRequiredId(), forceRead );
		return( (ICFBamScopeObj)retobj );
	}

	public ICFBamSchemaDefTableObj getSchemaDefTable() {
		return( ((ICFBamSchemaObj)schema).getSchemaDefTableObj() );
	}

	public CFBamScopeBuff getBuff() {
		if( buff == null ) {
			if( isNew ) {
				buff = ((ICFBamSchema)schema.getBackingStore()).getFactorySchemaDef().newBuff();
			}
			else {
				// Read the data buff via the backing store
				buff = ((ICFBamSchema)schema.getBackingStore()).getTableSchemaDef().readDerivedByIdIdx( ((ICFBamSchemaObj)schema).getAuthorization(),
						getPKey().getRequiredTenantId(),
						getPKey().getRequiredId() );
				if( buff != null ) {
					copyBuffToPKey();
				}
			}
		}
		return( buff );
	}

	public void setBuff( CFBamScopeBuff value ) {
		if( ! ( ( value == null ) || ( value instanceof CFBamSchemaDefBuff ) ) ) {
			throw new CFLibUnsupportedClassException( getClass(),
				"setBuff",
				"value",
				value,
				"CFBamSchemaDefBuff" );
		}
		buff = value;
		copyBuffToPKey();
		requiredOwnerTenant = null;
		requiredContainerMinorVersion = null;
		optionalLookupDefaultLicense = null;
		requiredOwnerCTenant = null;
	}

	public CFBamSchemaDefBuff getSchemaDefBuff() {
		return( (CFBamSchemaDefBuff)getBuff() );
	}

	public ICFBamScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new CFLibUsageException( getClass(), "beginEdit", "An edit is already open" );
		}
		ICFBamSchemaDefObj lockobj;
		if( getIsNew() ) {
			lockobj = (ICFBamSchemaDefObj)this;
		}
		else {
			lockobj = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().lockSchemaDef( getPKey() );
		}
		edit = ((ICFBamSchemaObj)schema).getSchemaDefTableObj().newEditInstance( lockobj );
		return( (ICFBamScopeEditObj)edit );
	}

	public ICFBamSchemaDefEditObj getEditAsSchemaDef() {
		return( (ICFBamSchemaDefEditObj)edit );
	}

	public ICFSecSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			CFBamScopeBuff buff = getBuff();
			createdBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getCreatedByUserId() );
		}
		return( createdBy );
	}

	public Calendar getCreatedAt() {
		return( getBuff().getCreatedAt() );
	}

	public ICFSecSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			CFBamScopeBuff buff = getBuff();
			updatedBy = ((ICFBamSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( buff.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	public Calendar getUpdatedAt() {
		return( getBuff().getUpdatedAt() );
	}

	public long getRequiredMinorVersionId() {
		return( getSchemaDefBuff().getRequiredMinorVersionId() );
	}

	public String getRequiredName() {
		return( getSchemaDefBuff().getRequiredName() );
	}

	public String getOptionalDbName() {
		return( getSchemaDefBuff().getOptionalDbName() );
	}

	public String getOptionalShortName() {
		return( getSchemaDefBuff().getOptionalShortName() );
	}

	public String getOptionalLabel() {
		return( getSchemaDefBuff().getOptionalLabel() );
	}

	public String getOptionalShortDescription() {
		return( getSchemaDefBuff().getOptionalShortDescription() );
	}

	public String getOptionalDescription() {
		return( getSchemaDefBuff().getOptionalDescription() );
	}

	public Long getOptionalDefaultLicenseTenantId() {
		return( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() );
	}

	public Long getOptionalDefaultLicenseId() {
		return( getSchemaDefBuff().getOptionalDefaultLicenseId() );
	}

	public String getRequiredCopyrightPeriod() {
		return( getSchemaDefBuff().getRequiredCopyrightPeriod() );
	}

	public String getRequiredCopyrightHolder() {
		return( getSchemaDefBuff().getRequiredCopyrightHolder() );
	}

	public String getRequiredAuthorEMail() {
		return( getSchemaDefBuff().getRequiredAuthorEMail() );
	}

	public String getRequiredProjectURL() {
		return( getSchemaDefBuff().getRequiredProjectURL() );
	}

	public String getRequiredPublishURI() {
		return( getSchemaDefBuff().getRequiredPublishURI() );
	}

	public String getOptionalJSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImport() );
	}

	public String getOptionalJSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalJSchemaObjInterface() );
	}

	public String getOptionalJSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJSchemaObjMembers() );
	}

	public String getOptionalJSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalJSchemaObjImplementation() );
	}

	public String getOptionalJDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjMembers() );
	}

	public String getOptionalJDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImpl() );
	}

	public String getOptionalJDb2LUWSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJDb2LUWSchemaObjImport() );
	}

	public String getOptionalJMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjMembers() );
	}

	public String getOptionalJMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImpl() );
	}

	public String getOptionalJMSSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMSSqlSchemaObjImport() );
	}

	public String getOptionalJMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjMembers() );
	}

	public String getOptionalJMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImpl() );
	}

	public String getOptionalJMySqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJMySqlSchemaObjImport() );
	}

	public String getOptionalJOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjMembers() );
	}

	public String getOptionalJOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImpl() );
	}

	public String getOptionalJOracleSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJOracleSchemaObjImport() );
	}

	public String getOptionalJPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjMembers() );
	}

	public String getOptionalJPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImpl() );
	}

	public String getOptionalJPgSqlSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJPgSqlSchemaObjImport() );
	}

	public String getOptionalJRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjMembers() );
	}

	public String getOptionalJRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImpl() );
	}

	public String getOptionalJRamSchemaObjImport() {
		return( getSchemaDefBuff().getOptionalJRamSchemaObjImport() );
	}

	public String getOptionalJXMsgSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaImport() );
	}

	public String getOptionalJXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalJXMsgSchemaFormatters() );
	}

	public String getOptionalJXMsgClientSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaImport() );
	}

	public String getOptionalJXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgClientSchemaBody() );
	}

	public String getOptionalJXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaBody() );
	}

	public String getOptionalJXMsgRqstSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaImport() );
	}

	public String getOptionalJXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaWireParsers() );
	}

	public String getOptionalJXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdSpec() );
	}

	public String getOptionalJXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRqstSchemaXsdElementList() );
	}

	public String getOptionalJXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaBody() );
	}

	public String getOptionalJXMsgRspnSchemaImport() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaImport() );
	}

	public String getOptionalJXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaWireParsers() );
	}

	public String getOptionalJXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdElementList() );
	}

	public String getOptionalJXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalJXMsgRspnSchemaXsdSpec() );
	}

	public String getOptionalCppSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjInclude() );
	}

	public String getOptionalCppSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjInterface() );
	}

	public String getOptionalCppSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjMembers() );
	}

	public String getOptionalCppSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalCppSchemaObjImplementation() );
	}

	public String getOptionalCppDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjMembers() );
	}

	public String getOptionalCppDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjImpl() );
	}

	public String getOptionalCppDb2LUWSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppDb2LUWSchemaObjInclude() );
	}

	public String getOptionalCppMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjMembers() );
	}

	public String getOptionalCppMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjImpl() );
	}

	public String getOptionalCppMSSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppMSSqlSchemaObjInclude() );
	}

	public String getOptionalCppMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppMySqlSchemaObjMembers() );
	}

	public String getOptionalCppMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppMySqlSchemaObjImpl() );
	}

	public String getOptionalCppMySqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppMySqlSchemaObjInclude() );
	}

	public String getOptionalCppOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppOracleSchemaObjMembers() );
	}

	public String getOptionalCppOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppOracleSchemaObjImpl() );
	}

	public String getOptionalCppOracleSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppOracleSchemaObjInclude() );
	}

	public String getOptionalCppPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjMembers() );
	}

	public String getOptionalCppPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjImpl() );
	}

	public String getOptionalCppPgSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppPgSqlSchemaObjInclude() );
	}

	public String getOptionalCppRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCppRamSchemaObjMembers() );
	}

	public String getOptionalCppRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCppRamSchemaObjImpl() );
	}

	public String getOptionalCppRamSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalCppRamSchemaObjInclude() );
	}

	public String getOptionalCppXMsgSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgSchemaInclude() );
	}

	public String getOptionalCppXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalCppXMsgSchemaFormatters() );
	}

	public String getOptionalCppXMsgClientSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgClientSchemaInclude() );
	}

	public String getOptionalCppXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalCppXMsgClientSchemaBody() );
	}

	public String getOptionalCppXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaBody() );
	}

	public String getOptionalCppXMsgRqstSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaInclude() );
	}

	public String getOptionalCppXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaWireParsers() );
	}

	public String getOptionalCppXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaXsdSpec() );
	}

	public String getOptionalCppXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCppXMsgRqstSchemaXsdElementList() );
	}

	public String getOptionalCppXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaBody() );
	}

	public String getOptionalCppXMsgRspnSchemaInclude() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaInclude() );
	}

	public String getOptionalCppXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaWireParsers() );
	}

	public String getOptionalCppXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaXsdElementList() );
	}

	public String getOptionalCppXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCppXMsgRspnSchemaXsdSpec() );
	}

	public String getOptionalHppSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjInclude() );
	}

	public String getOptionalHppSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjInterface() );
	}

	public String getOptionalHppSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjMembers() );
	}

	public String getOptionalHppSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalHppSchemaObjImplementation() );
	}

	public String getOptionalHppDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjMembers() );
	}

	public String getOptionalHppDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjImpl() );
	}

	public String getOptionalHppDb2LUWSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppDb2LUWSchemaObjInclude() );
	}

	public String getOptionalHppMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjMembers() );
	}

	public String getOptionalHppMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjImpl() );
	}

	public String getOptionalHppMSSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppMSSqlSchemaObjInclude() );
	}

	public String getOptionalHppMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppMySqlSchemaObjMembers() );
	}

	public String getOptionalHppMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppMySqlSchemaObjImpl() );
	}

	public String getOptionalHppMySqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppMySqlSchemaObjInclude() );
	}

	public String getOptionalHppOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppOracleSchemaObjMembers() );
	}

	public String getOptionalHppOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppOracleSchemaObjImpl() );
	}

	public String getOptionalHppOracleSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppOracleSchemaObjInclude() );
	}

	public String getOptionalHppPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjMembers() );
	}

	public String getOptionalHppPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjImpl() );
	}

	public String getOptionalHppPgSqlSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppPgSqlSchemaObjInclude() );
	}

	public String getOptionalHppRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalHppRamSchemaObjMembers() );
	}

	public String getOptionalHppRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalHppRamSchemaObjImpl() );
	}

	public String getOptionalHppRamSchemaObjInclude() {
		return( getSchemaDefBuff().getOptionalHppRamSchemaObjInclude() );
	}

	public String getOptionalHppXMsgSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgSchemaInclude() );
	}

	public String getOptionalHppXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalHppXMsgSchemaFormatters() );
	}

	public String getOptionalHppXMsgClientSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgClientSchemaInclude() );
	}

	public String getOptionalHppXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalHppXMsgClientSchemaBody() );
	}

	public String getOptionalHppXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaBody() );
	}

	public String getOptionalHppXMsgRqstSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaInclude() );
	}

	public String getOptionalHppXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaWireParsers() );
	}

	public String getOptionalHppXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaXsdSpec() );
	}

	public String getOptionalHppXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalHppXMsgRqstSchemaXsdElementList() );
	}

	public String getOptionalHppXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaBody() );
	}

	public String getOptionalHppXMsgRspnSchemaInclude() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaInclude() );
	}

	public String getOptionalHppXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaWireParsers() );
	}

	public String getOptionalHppXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaXsdElementList() );
	}

	public String getOptionalHppXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalHppXMsgRspnSchemaXsdSpec() );
	}

	public String getOptionalCsSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjUsing() );
	}

	public String getOptionalCsSchemaObjInterface() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjInterface() );
	}

	public String getOptionalCsSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjMembers() );
	}

	public String getOptionalCsSchemaObjImplementation() {
		return( getSchemaDefBuff().getOptionalCsSchemaObjImplementation() );
	}

	public String getOptionalCsDb2LUWSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjMembers() );
	}

	public String getOptionalCsDb2LUWSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjImpl() );
	}

	public String getOptionalCsDb2LUWSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsDb2LUWSchemaObjUsing() );
	}

	public String getOptionalCsMSSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjMembers() );
	}

	public String getOptionalCsMSSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjImpl() );
	}

	public String getOptionalCsMSSqlSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsMSSqlSchemaObjUsing() );
	}

	public String getOptionalCsMySqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsMySqlSchemaObjMembers() );
	}

	public String getOptionalCsMySqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsMySqlSchemaObjImpl() );
	}

	public String getOptionalCsMySqlSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsMySqlSchemaObjUsing() );
	}

	public String getOptionalCsOracleSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsOracleSchemaObjMembers() );
	}

	public String getOptionalCsOracleSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsOracleSchemaObjImpl() );
	}

	public String getOptionalCsOracleSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsOracleSchemaObjUsing() );
	}

	public String getOptionalCsPgSqlSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjMembers() );
	}

	public String getOptionalCsPgSqlSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjImpl() );
	}

	public String getOptionalCsPgSqlSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsPgSqlSchemaObjUsing() );
	}

	public String getOptionalCsRamSchemaObjMembers() {
		return( getSchemaDefBuff().getOptionalCsRamSchemaObjMembers() );
	}

	public String getOptionalCsRamSchemaObjImpl() {
		return( getSchemaDefBuff().getOptionalCsRamSchemaObjImpl() );
	}

	public String getOptionalCsRamSchemaObjUsing() {
		return( getSchemaDefBuff().getOptionalCsRamSchemaObjUsing() );
	}

	public String getOptionalCsXMsgSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgSchemaUsing() );
	}

	public String getOptionalCsXMsgSchemaFormatters() {
		return( getSchemaDefBuff().getOptionalCsXMsgSchemaFormatters() );
	}

	public String getOptionalCsXMsgClientSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgClientSchemaUsing() );
	}

	public String getOptionalCsXMsgClientSchemaBody() {
		return( getSchemaDefBuff().getOptionalCsXMsgClientSchemaBody() );
	}

	public String getOptionalCsXMsgRqstSchemaBody() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaBody() );
	}

	public String getOptionalCsXMsgRqstSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaUsing() );
	}

	public String getOptionalCsXMsgRqstSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaWireParsers() );
	}

	public String getOptionalCsXMsgRqstSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaXsdSpec() );
	}

	public String getOptionalCsXMsgRqstSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCsXMsgRqstSchemaXsdElementList() );
	}

	public String getOptionalCsXMsgRspnSchemaBody() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaBody() );
	}

	public String getOptionalCsXMsgRspnSchemaUsing() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaUsing() );
	}

	public String getOptionalCsXMsgRspnSchemaWireParsers() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaWireParsers() );
	}

	public String getOptionalCsXMsgRspnSchemaXsdElementList() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaXsdElementList() );
	}

	public String getOptionalCsXMsgRspnSchemaXsdSpec() {
		return( getSchemaDefBuff().getOptionalCsXMsgRspnSchemaXsdSpec() );
	}

	public ICFIntMinorVersionObj getRequiredContainerMinorVersion() {
		return( getRequiredContainerMinorVersion( false ) );
	}

	public ICFIntMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead ) {
		if( ( requiredContainerMinorVersion == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerMinorVersion = ((ICFBamSchemaObj)schema).getMinorVersionTableObj().readMinorVersionByIdIdx( getPKey().getRequiredTenantId(),
					getSchemaDefBuff().getRequiredMinorVersionId(), forceRead );
			}
		}
		return( requiredContainerMinorVersion );
	}

	public List<ICFBamTableObj> getOptionalComponentsTables() {
		List<ICFBamTableObj> retval;
		retval = ((ICFBamSchemaObj)schema).getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamTableObj> getOptionalComponentsTables( boolean forceRead ) {
		List<ICFBamTableObj> retval;
		retval = ((ICFBamSchemaObj)schema).getTableTableObj().readTableBySchemaDefIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes() {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamValueObj> getOptionalComponentsTypes( boolean forceRead ) {
		List<ICFBamValueObj> retval;
		retval = ((ICFBamSchemaObj)schema).getValueTableObj().readValueByScopeIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFIntLicenseObj getOptionalLookupDefaultLicense() {
		return( getOptionalLookupDefaultLicense( false ) );
	}

	public ICFIntLicenseObj getOptionalLookupDefaultLicense( boolean forceRead ) {
		if( ( optionalLookupDefaultLicense == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaDefBuff().getOptionalDefaultLicenseTenantId() == null ) {
				anyMissing = true;
			}
			if( getSchemaDefBuff().getOptionalDefaultLicenseId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefaultLicense = ((ICFBamSchemaObj)schema).getLicenseTableObj().readLicenseByIdIdx( getSchemaDefBuff().getOptionalDefaultLicenseTenantId(),
					getSchemaDefBuff().getOptionalDefaultLicenseId(), forceRead );
			}
		}
		return( optionalLookupDefaultLicense );
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs() {
		List<ICFBamSchemaRefObj> retval;
		retval = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			false );
		return( retval );
	}

	public List<ICFBamSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead ) {
		List<ICFBamSchemaRefObj> retval;
		retval = ((ICFBamSchemaObj)schema).getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey().getRequiredTenantId(),
					getPKey().getRequiredId(),
			forceRead );
		return( retval );
	}

	public ICFSecTenantObj getRequiredOwnerCTenant() {
		return( getRequiredOwnerCTenant( false ) );
	}

	public ICFSecTenantObj getRequiredOwnerCTenant( boolean forceRead ) {
		if( ( requiredOwnerCTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerCTenant = ((ICFBamSchemaObj)schema).getTenantTableObj().readTenantByIdIdx( getPKey().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerCTenant );
	}
}
